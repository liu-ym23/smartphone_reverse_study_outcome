#version 300 es
precision highp float;

// audio_wave.agsl 的 GLES3 口径。公式不变；gl_FragCoord 已是 y 向上，不再翻 Y。
// 由 GlesRenderer 在独立 HandlerThread 上编译、每帧 eglSwapBuffers。

uniform vec2 iResolution;
uniform float  iTime;
uniform float  uPxPerDp;
uniform float  uDpRef;

uniform float uAmp;
uniform float uFreq;
uniform float uSpeed;
uniform float uLen;
uniform float uTaper;
uniform float uFade;
uniform float uOffsetY;

uniform float uPhase1;
uniform float uPhase2;
uniform float uPhase3;
uniform vec3 uCol1;
uniform vec3 uCol2;
uniform vec3 uCol3;
uniform vec3 uFillCol1;
uniform vec3 uFillCol2;
uniform vec3 uFillCol3;

uniform float uGlowUp;
uniform float uGlowDn;
uniform float uInten;

uniform float uFillSoft;
uniform float uFillOp;
uniform float uFillAdd;

uniform float uIntro;
uniform float uIntroDur;
uniform float uIntroSpeedFrom;
uniform float uWaveTime;
uniform float uStartAt;
uniform float uReleaseAt;
uniform float uExitDur;

uniform float uExtEnergy;
uniform float uEnergyIn;
uniform float uEnergySpeed;

uniform float uMotionBlur;

// 由 GlesRenderer 每帧算一次，像素里不再跑 pathEase / synth / drift。
uniform float uGpuReady;
uniform float uGpuEnergy;
uniform float uGpuDrift;
uniform float uGpuCover;
uniform float uGpuLiveAmp;

out vec4 fragColor;

const float PI = 3.141592653589793;

float bez(float p1, float p2, float u) {
    float v = 1.0 - u;
    return 3.0 * v * v * u * p1 + 3.0 * v * u * u * p2 + u * u * u;
}

float bezDeriv(float p1, float p2, float u) {
    float v = 1.0 - u;
    return 3.0 * v * v * p1 + 6.0 * v * u * (p2 - p1) + 3.0 * u * u * (1.0 - p2);
}

float pathEase(float x1, float y1, float x2, float y2, float x) {
    if (x <= 0.0) return 0.0;
    if (x >= 1.0) return 1.0;
    float u = x;
    for (int i = 0; i < 6; ++i) {
        float dx = bez(x1, x2, u) - x;
        float d  = bezDeriv(x1, x2, u);
        if (abs(d) > 1e-6) u = clamp(u - dx / d, 0.0, 1.0);
    }
    return bez(y1, y2, u);
}

float bandf(float t, float a, float f1, float p1, float f2, float p2) {
    return clamp(a + a * sin(t * f1 + p1) * sin(t * f2 + p2), 0.0, 1.0);
}

float synthEnergy(float t) {
    float low  = bandf(t, 0.45, 0.80, 0.0, 0.37, 1.0);
    float mid  = bandf(t, 0.40, 1.70, 2.0, 0.53, 0.0);
    float high = bandf(t, 0.30, 2.90, 4.0, 0.71, 2.0);
    return 0.5 + 0.5 * low + 0.35 * mid + 0.15 * high;
}

float envelope(float xn) {
    float c = cos(PI * 0.5 * min(abs(uTaper * xn), 1.0));
    return c * c;
}

float waveDrift(float t) {
    float s0 = uIntroSpeedFrom;
    float s1 = uSpeed;
    if (uIntroDur <= 0.001) return t * mix(s0, s1, clamp(uIntro, 0.0, 1.0));
    float d = max(uIntroDur, 0.05);
    if (t <= 0.0) return 0.0;
    if (t < d) {
        float u = t / d;
        return s0 * t + (s1 - s0) * t * u * 0.5;
    }
    return 0.5 * (s0 + s1) * d + s1 * (t - d);
}

vec3 curveYs(float drift, float xn, float mag, vec3 phase) {
    float theta = xn * PI * uFreq + drift;
    return vec3(0.5 + uOffsetY) + mag * sin(vec3(theta) + phase);
}

float curveYAt(float drift, float xn, float ampF, float env, float energy, float phase) {
    return curveYs(drift, xn, ampF * energy * env, vec3(phase)).x;
}

float glowProfile(float sd, float up, float dn) {
    return exp(-abs(sd) / max(sd >= 0.0 ? up : dn, 1e-5));
}

float fillAmt(float sd, float soft) {
    return 1.0 - smoothstep(-max(soft, 1e-5), 0.0, sd);
}

float strokeAt(
    float t, float drift, float uvy, float xn, float ampF, float env, float energy, float phase,
    float up, float dn
) {
    if (uMotionBlur <= 0.001) {
        return glowProfile(uvy - curveYAt(drift, xn, ampF, env, energy, phase), up, dn);
    }
    float w = uMotionBlur / 60.0;
    float acc = 0.0;
    acc += glowProfile(uvy - curveYAt(drift, xn, ampF, env, energy, phase), up, dn);
    acc += glowProfile(uvy - curveYAt(waveDrift(t - w * 0.25), xn, ampF, env, energy, phase), up, dn);
    acc += glowProfile(uvy - curveYAt(waveDrift(t - w * 0.50), xn, ampF, env, energy, phase), up, dn);
    acc += glowProfile(uvy - curveYAt(waveDrift(t - w * 0.75), xn, ampF, env, energy, phase), up, dn);
    return acc * 0.25;
}

void main() {
    vec2 fragCoord = gl_FragCoord.xy;
    vec2 uv = fragCoord / iResolution;

    float hostH = max(iResolution.y, 1.0);
    float dp = uDpRef > 0.5
             ? min(iResolution.x, iResolution.y) / (uDpRef * hostH)
             : uPxPerDp / hostH;

    float x0  = 0.5 - 0.5 * uLen;
    float u   = (uv.x - x0) / max(uLen, 1e-4);
    float xn  = u * 2.0 - 1.0;
    float win = smoothstep(0.0, 0.012, u) * smoothstep(0.0, 0.012, 1.0 - u);

    if (uWaveTime < 0.0 && uWaveTime > -1.5)  { fragColor = vec4(0.0); return; }
    if (uReleaseAt >= 0.0 && uStartAt >= 0.0 && uReleaseAt <= uStartAt)  { fragColor = vec4(0.0); return; }
    if (uWaveTime < -1.5 && uStartAt >= 0.0 && iTime < uStartAt)  { fragColor = vec4(0.0); return; }

    float maxBand = 0.5 + uOffsetY + abs(uAmp) * dp * 1.35 + max(uGlowUp, uGlowDn) * dp + 0.04;
    if (uv.y > maxBand)  { fragColor = vec4(0.0); return; }

    float energy;
    float liveAmp;
    float cover;
    float drift;
    float localT = uWaveTime >= 0.0
        ? uWaveTime
        : (uStartAt >= 0.0 ? max(iTime - uStartAt, 0.0) : iTime);
    if (uGpuReady > 0.5) {
        energy = uGpuEnergy;
        liveAmp = uGpuLiveAmp;
        cover = uGpuCover;
        drift = uGpuDrift;
    } else {
        float intro;
        if (uIntroDur > 0.001) {
            intro = pathEase(0.3, 0.0, 0.1, 1.0, clamp(localT / uIntroDur, 0.0, 1.0));
        } else {
            intro = clamp(uIntro, 0.0, 1.0);
        }
        float vol = clamp(uEnergyIn, 0.0, 1.0);
        float volumeAmp = mix(0.30, 1.10, vol);
        float listenEnergy = mix(synthEnergy(localT * uEnergySpeed),
                                 volumeAmp,
                                 clamp(uExtEnergy, 0.0, 1.0));
        energy = mix(1.0, listenEnergy, intro);
        liveAmp = uAmp * intro;
        cover = 1.0;
        if (uReleaseAt >= 0.0 && localT > uReleaseAt) {
            float te = localT - uReleaseAt;
            float exitDur = max(uExitDur, 0.05);
            float p0 = exitDur * (0.300 / 0.433);
            float p1 = max(exitDur - p0, 0.001);
            if (te >= exitDur)  { fragColor = vec4(0.0); return; }
            if (te < p0) {
                float e = pathEase(0.35, 0.0, 0.67, 1.0, clamp(te / max(p0, 0.001), 0.0, 1.0));
                liveAmp = mix(uAmp, -9.07, e);
            } else {
                float e = pathEase(0.33, 0.0, 0.62, 1.0, clamp((te - p0) / p1, 0.0, 1.0));
                liveAmp = mix(-9.07, 0.0, e);
            }
            cover = 1.0 - pathEase(0.33, 0.0, 0.62, 1.0, clamp(te / exitDur, 0.0, 1.0));
        }
        drift = waveDrift(localT);
    }
    float ampK = clamp(abs(liveAmp) / max(abs(uAmp), 1.0), 0.0, 1.0);
    if (ampK <= 0.0005)  { fragColor = vec4(0.0); return; }
    float env = envelope(xn);
    float ampF = liveAmp * dp;
    float up   = uGlowUp * dp * ampK;
    float dn   = uGlowDn * dp * ampK;
    float soft = uFillSoft * dp * ampK;
    vec3 phase = vec3(uPhase1, uPhase2, uPhase3);

    vec3 sd = uv.y - curveYs(drift, xn, ampF * energy * env, phase);
    float sd1 = sd.x;
    float sd2 = sd.y;
    float sd3 = sd.z;

    float a1 = fillAmt(sd1, soft) * uFillOp;
    float a2 = fillAmt(sd2, soft) * uFillOp;
    float a3 = fillAmt(sd3, soft) * uFillOp;
    vec3 fc;
    float  fa;
    if (uFillAdd > 0.5) {
        fc = uFillCol1 * a1 + uFillCol2 * a2 + uFillCol3 * a3;
        fa = clamp(a1 + a2 + a3, 0.0, 1.0);
    } else {
        fc = uFillCol1 * a1;                      fa = a1;
        fc = uFillCol2 * a2 + fc * (1.0 - a2);    fa = a2 + fa * (1.0 - a2);
        fc = uFillCol3 * a3 + fc * (1.0 - a3);    fa = a3 + fa * (1.0 - a3);
    }

    vec3 sc;
    if (uMotionBlur <= 0.001) {
        sc = uCol1 * glowProfile(sd1, up, dn)
           + uCol2 * glowProfile(sd2, up, dn)
           + uCol3 * glowProfile(sd3, up, dn);
    } else {
        sc = uCol1 * strokeAt(localT, drift, uv.y, xn, ampF, env, energy, uPhase1, up, dn)
           + uCol2 * strokeAt(localT, drift, uv.y, xn, ampF, env, energy, uPhase2, up, dn)
           + uCol3 * strokeAt(localT, drift, uv.y, xn, ampF, env, energy, uPhase3, up, dn);
    }
    sc *= uInten;

    float g    = xn * uFade;
    float hwin = win * exp(-g * g);
    vec3 col = (fc + sc) * hwin;

    float da  = clamp(max(max(col.r, col.g), col.b), 0.0, 1.0);
    float aOut = max(da, clamp(fa * hwin, 0.0, 1.0)) * cover;
    fragColor = vec4(min(col, vec3(1.0)) * cover, aOut);
}
