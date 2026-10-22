package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.obric.common.oea.foundation.animation.engine.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class GL3ShaderViewSnow extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11711b = "GL2ShaderView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11712a;

    public static class a implements GLSurfaceView.Renderer {
        public b A;
        public b B;
        public Context C;
        public final float[] D;
        public FloatBuffer E;
        public Bitmap F;
        public Bitmap G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f11713J;
        public int K;
        public int L;
        public int M;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11719f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11720g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11721h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11722i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11723j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11724k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11725l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11726m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11727n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11728o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11729p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11730q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f11731r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f11732s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f11733t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11734u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11735v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11736w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11737x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f11738y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public b f11739z;

        public a(Context r10) {
            this.f11714a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f11715b = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.f11716c = "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.f11731r = -1.0f;
            this.f11732s = -1.0f;
            this.f11733t = -1.0f;
            this.f11734u = 0;
            this.f11735v = 0;
            this.f11736w = 0;
            this.f11737x = 0;
            this.f11738y = 0;
            this.f11739z = new b(1.0f);
            this.A = new b(0.5f);
            this.B = new b(1.0f);
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.D = r11;
            this.H = 0;
            this.L = 0;
            this.M = 0;
            this.C = r10;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.E = r12;
            r12.position(0);
        }

        public static /* synthetic */ b a(a r10) {
            return r10.f11739z;
        }

        public static /* synthetic */ b b(a r10) {
            return r10.A;
        }

        public static /* synthetic */ b c(a r10) {
            return r10.B;
        }

        public static int h(Context r10, Bitmap r11) {
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            int r13 = r12[0];
            if (r13 == 0) goto L6;
            GLES30.glBindTexture(3553, r13);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLUtils.texImage2D(3553, 0, r11, 0);
            GLES30.glBindTexture(3553, 0);
            r11.recycle();
        L6:
            return r12[0];
        }

        public final void d(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewSnow.a(), r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        public final int e(String r10, String r11) {
            int r12 = g(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = g(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            d("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            d("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e(GL3ShaderViewSnow.a(), "Could not link program: ");
            Log.e(GL3ShaderViewSnow.a(), GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        public final void f() {
            if (this.H != 0) goto L5;
            int r10 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.H = r10;
            this.I = GLES30.glGetAttribLocation(r10, "vPosition");
            d("glGetAttribLocation");
            this.f11713J = GLES30.glGetUniformLocation(this.H, "u_background");
            d("glGetAttribLocation");
            this.K = GLES30.glGetUniformLocation(this.H, "u_resolution");
            d("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.H);
            if (this.L != 0) goto L8;
            int[] r11 = new int[1];
            GLES30.glGenFramebuffers(1, r11, 0);
            this.L = r11[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.L);
            if (this.M != 0) goto L11;
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            this.M = r12[0];
        L11:
            GLES30.glBindTexture(3553, this.M);
            GLES30.glTexImage2D(3553, 0, 6408, this.f11735v, this.f11737x, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.M, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        public final int g(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e(GL3ShaderViewSnow.a(), "Could not compile shader " + r10 + ":");
            Log.e(GL3ShaderViewSnow.a(), GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        public final void i() {
            GLES30.glBindFramebuffer(36160, this.L);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.H);
            GLES30.glUniform2f(this.K, this.f11735v, this.f11737x);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11727n);
            GLES30.glUniform1i(this.f11713J, 0);
            GLES30.glEnableVertexAttribArray(this.I);
            GLES30.glVertexAttribPointer(this.I, 2, 5126, false, 0, this.E);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.M);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public void j(Bitmap r10) {
            this.F = r10;
        }

        public void k(Bitmap r10) {
            this.G = r10;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            if (this.f11735v == this.f11736w) goto L5;
        L6:
            f();
            i();
        L7:
            long r11 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11717d);
            GLES30.glUniform1f(this.f11723j, (r11 % BatteryFactorConfig.WIFI_BPS) / 1000.0f);
            int r12 = this.f11735v;
            if (r12 == this.f11736w) goto L10;
        L11:
            this.f11736w = r12;
            int r13 = this.f11737x;
            this.f11738y = r13;
            GLES30.glUniform2f(this.f11722i, r12, r13);
        L13:
            if (this.f11739z.a() == this.f11731r) goto L16;
            float r14 = this.f11739z.a();
            this.f11731r = r14;
            GLES30.glUniform1f(this.f11724k, r14);
        L16:
            if (this.A.a() == this.f11732s) goto L19;
            float r15 = this.A.a();
            this.f11732s = r15;
            GLES30.glUniform1f(this.f11725l, r15);
        L19:
            if (this.B.a() == this.f11733t) goto L21;
            float r16 = this.B.a();
            this.f11733t = r16;
            GLES30.glUniform1f(this.f11726m, r16);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11727n);
            GLES30.glUniform1i(this.f11719f, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.M);
            GLES30.glUniform1i(this.f11720g, 1);
            GLES30.glActiveTexture(33986);
            GLES30.glBindTexture(3553, this.f11728o);
            GLES30.glUniform1i(this.f11721h, 2);
            GLES30.glBindVertexArray(this.f11729p);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.f11737x == this.f11738y) goto L13;
        L5:
            if (this.f11737x == this.f11738y) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.f11735v = r11;
            this.f11737x = r12;
            GLES30.glViewport(0, 0, r11, r12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
            int r12 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define clamp01(x) clamp(x, 0.0, 1.0)\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform sampler2D u_frostTex;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD         = 9.0;\nconst float SNOW_LAYERS = 30.0;\nconst float SNOW_DEPTH  = 0.5;\nconst float SNOW_WIDTH  = 0.5;\nconst vec3 FROST_COLOR  = vec3(0.82, 0.89, 0.96);\nconst vec2 SHIFT        = vec2(0.07, -0.03);\nout vec4 fragColor;\nvec3 blendNormal(in vec3 baseColor, in vec3 blendColor, in float opacity) {\n    return mix(baseColor, blendColor, opacity);\n}\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nconst mat3 randomMat = mat3(13.323122, 23.5112, 21.71123,\n        21.1212, 28.7312, 11.9312,\n        21.8112, 14.7212, 61.3934);\nfloat generateSnowLayer(in vec2 uv, in float t, float layer, float width) {\n    float depth = layer * SNOW_DEPTH;\n    vec2 q = uv * (1.0 + depth);\n    q += vec2(q.y * width * (fract(layer * 7.238917) - 0.5),\n            t / (1.0 + depth * 0.03));\n    vec3 n = vec3(floor(q), 31.189 + layer);\n    vec3 m = floor(n) / 1e5 + fract(n);\n    vec3 mp = (31415.9 + m) / fract(randomMat * m);\n    vec3 r = fract(mp);\n    vec2 s = abs(fract(q) - 0.5 + 0.9 * r.xy - 0.45) +\n            0.01 * abs(2.0 * fract(10.0 * q.yx) - 1.0);\n    float d = 0.6 * (s.x + s.y) + max(s.x, s.y) - 0.01;\n    float edge = 0.005 + 0.05 * min(0.5 * abs(layer - 5.0), 1.0);\n    return smoothstep(edge, -edge, d) * r.x / (1.0 + 0.02 * depth);\n}\nfloat computeSnow(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    float snow = 0.0;\n    float layers = mix(0.0, SNOW_LAYERS, u_intensity);\n    float width  = mix(0.0, SNOW_WIDTH, u_intensity);\n    for (float i = 0.0; i < layers; i++) {\n        snow += generateSnowLayer(uv, t, i, width);\n    }\n    return clamp01(snow);\n}\nvec2 frostEffect(in vec2 uv) {\n    vec4 frostTex = texture(u_frostTex, uv);\n    vec2 offset = vec2(random(uv + frostTex.r * 0.05),\n            random(uv + frostTex.b * 0.05));\n    float distToCenter = distance(uv, vec2(0.5));\n    float frostiness   = mix(1.0, 0.5, u_intensity);\n    float vignette     = pow(1.0 - smoothstep(frostiness, 0.0, distToCenter), 2.0);\n    offset *= 0.025 * vignette + frostTex.rg * vignette * u_intensity * 4.0;\n    return clamp(offset, vec2(0.0), vec2(1.0));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor    = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    vec2 frostOffset  = frostEffect(texUV);\n    float snowEffect  = computeSnow(uv + frostOffset * 0.3, t);\n    vec3 effectColor = prepassColor + snowEffect;\n    effectColor = blendNormal(effectColor, FROST_COLOR, frostOffset.x);\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f11717d = r12;
            if (r12 != 0) goto L5;
            return;
        L5:
            this.f11718e = GLES30.glGetAttribLocation(r12, "vPosition");
            d("glGetAttribLocation");
            this.f11719f = GLES30.glGetUniformLocation(this.f11717d, "u_background");
            d("glGetAttribLocation");
            this.f11720g = GLES30.glGetUniformLocation(this.f11717d, "u_prepass");
            d("glGetAttribLocation");
            this.f11721h = GLES30.glGetUniformLocation(this.f11717d, "u_frostTex");
            d("glGetAttribLocation");
            this.f11722i = GLES30.glGetUniformLocation(this.f11717d, "u_resolution");
            d("glGetUniformLocation");
            this.f11723j = GLES30.glGetUniformLocation(this.f11717d, "u_time");
            d("glGetUniformLocation");
            this.f11724k = GLES30.glGetUniformLocation(this.f11717d, "u_alpha");
            d("glGetUniformLocation");
            this.f11725l = GLES30.glGetUniformLocation(this.f11717d, "u_intensity");
            d("glGetUniformLocation");
            this.f11726m = GLES30.glGetUniformLocation(this.f11717d, "u_speed");
            d("glGetUniformLocation");
            GLES30.glUseProgram(this.f11717d);
            this.f11727n = h(this.C, this.F);
            this.f11728o = h(this.C, this.G);
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.f11729p = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            int r16 = r15[0];
            this.f11730q = r16;
            GLES30.glBindBuffer(34962, r16);
            GLES30.glBufferData(34962, this.D.length * 4, this.E, 35044);
            GLES30.glEnableVertexAttribArray(this.f11718e);
            GLES30.glVertexAttribPointer(this.f11718e, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewSnow(Context r10) {
        super(r10, null);
    }

    public static /* synthetic */ String a() {
        return f11711b;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long r10) {
        requestRender();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public final void init() {
        getHolder().setFormat(1);
        setZOrderOnTop(true);
        setEGLContextClientVersion(3);
        setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        a r10 = new a(getContext());
        this.f11712a = r10;
        setRenderer(r10);
        setRenderMode(0);
        setPreserveEGLContextOnPause(true);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Choreographer.getInstance().removeFrameCallback(this);
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void setBackgroundImage(Bitmap r10) {
        this.f11712a.j(r10);
    }

    public void setFrostImage(Bitmap r10) {
        this.f11712a.k(r10);
    }

    public void setShaderAlpha(float r10) {
        a.a(this.f11712a).b(r10);
    }

    public void setShaderIntensity(float r10) {
        a.b(this.f11712a).b(r10);
    }

    public void setShaderSpeed(float r10) {
        a.c(this.f11712a).b(r10);
    }

    public GL3ShaderViewSnow(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
