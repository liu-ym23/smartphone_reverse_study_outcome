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
public class GL3ShaderViewRain extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11683b = "GL2ShaderView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11684a;

    public static class a implements GLSurfaceView.Renderer {
        public final float[] A;
        public FloatBuffer B;
        public Bitmap C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11686b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11688d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11689e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11690f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11691g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11692h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11693i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11694j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11695k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11696l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11697m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11698n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11699o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f11700p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f11701q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f11702r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f11703s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f11704t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11705u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11706v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public b f11707w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public b f11708x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public b f11709y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Context f11710z;

        public a(Context r10) {
            this.f11685a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f11686b = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.f11687c = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.f11700p = -1.0f;
            this.f11701q = -1.0f;
            this.f11702r = -1.0f;
            this.f11703s = 0;
            this.f11704t = 0;
            this.f11705u = 0;
            this.f11706v = 0;
            this.f11707w = new b(1.0f);
            this.f11708x = new b(1.0f);
            this.f11709y = new b(0.25f);
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.A = r11;
            this.D = 0;
            this.H = 0;
            this.I = 0;
            this.f11710z = r10;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.B = r12;
            r12.position(0);
        }

        public static /* synthetic */ b a(a r10) {
            return r10.f11707w;
        }

        public static /* synthetic */ b b(a r10) {
            return r10.f11708x;
        }

        public static /* synthetic */ b c(a r10) {
            return r10.f11709y;
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
            Log.e(GL3ShaderViewRain.a(), r10 + ": glError " + r11);
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
            Log.e(GL3ShaderViewRain.a(), "Could not link program: ");
            Log.e(GL3ShaderViewRain.a(), GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        public final void f() {
            if (this.D != 0) goto L5;
            int r10 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.D = r10;
            this.E = GLES30.glGetAttribLocation(r10, "vPosition");
            d("glGetAttribLocation");
            this.F = GLES30.glGetUniformLocation(this.D, "u_background");
            d("glGetAttribLocation");
            this.G = GLES30.glGetUniformLocation(this.D, "u_resolution");
            d("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.D);
            if (this.H != 0) goto L8;
            int[] r11 = new int[1];
            GLES30.glGenFramebuffers(1, r11, 0);
            this.H = r11[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.H);
            if (this.I != 0) goto L11;
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            this.I = r12[0];
        L11:
            GLES30.glBindTexture(3553, this.I);
            GLES30.glTexImage2D(3553, 0, 6408, this.f11703s, this.f11705u, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.I, 0);
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
            Log.e(GL3ShaderViewRain.a(), "Could not compile shader " + r10 + ":");
            Log.e(GL3ShaderViewRain.a(), GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        public final void i() {
            GLES30.glBindFramebuffer(36160, this.H);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.D);
            GLES30.glUniform2f(this.G, this.f11703s, this.f11705u);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11697m);
            GLES30.glUniform1i(this.F, 0);
            GLES30.glEnableVertexAttribArray(this.E);
            GLES30.glVertexAttribPointer(this.E, 2, 5126, false, 0, this.B);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.I);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public void j(Bitmap r10) {
            this.C = r10;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            if (this.f11703s == this.f11704t) goto L5;
        L6:
            f();
            i();
        L7:
            long r11 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11688d);
            GLES30.glUniform1f(this.f11693i, (r11 % BatteryFactorConfig.WIFI_BPS) / 1000.0f);
            int r12 = this.f11703s;
            if (r12 == this.f11704t) goto L10;
        L11:
            this.f11704t = r12;
            int r13 = this.f11705u;
            this.f11706v = r13;
            GLES30.glUniform2f(this.f11692h, r12, r13);
        L13:
            if (this.f11707w.a() == this.f11700p) goto L16;
            float r14 = this.f11707w.a();
            this.f11700p = r14;
            GLES30.glUniform1f(this.f11694j, r14);
        L16:
            if (this.f11708x.a() == this.f11701q) goto L19;
            float r15 = this.f11708x.a();
            this.f11701q = r15;
            GLES30.glUniform1f(this.f11695k, r15);
        L19:
            if (this.f11709y.a() == this.f11702r) goto L21;
            float r16 = this.f11709y.a();
            this.f11702r = r16;
            GLES30.glUniform1f(this.f11696l, r16);
        L21:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11697m);
            GLES30.glUniform1i(this.f11690f, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.I);
            GLES30.glUniform1i(this.f11691g, 1);
            GLES30.glBindVertexArray(this.f11698n);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.f11705u == this.f11706v) goto L13;
        L5:
            if (this.f11705u == this.f11706v) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.f11703s = r11;
            this.f11705u = r12;
            GLES30.glViewport(0, 0, r11, r12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
            int r12 = e("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nconst float LOD = 9.0;\nconst float RAIN_AMOUNT = 0.5;\nconst float RAIN_TURBIDITY = 2.0;\nconst float RAIN_TRAIL = 1.5;\nconst float MASK_SIZE = 0.55;\nconst float MASK_BLUR = 0.4;\nconst float MASK_RATIO = 1.75;\nout vec4 fragColor;\nvec3 random3(float seed) {\n    vec3 p3 = fract(vec3(seed) * vec3(0.1031, 0.11369, 0.13787));\n    p3 += dot(p3, p3.yzx + 19.19);\n    return fract(vec3((p3.x + p3.y) * p3.z,\n            (p3.x + p3.z) * p3.y,\n            (p3.y + p3.z) * p3.x));\n}\nfloat random(float t) {\n    return fract(sin(t * 12345.564) * 7658.76);\n}\nfloat saw(float border, float t) {\n    return smoothstep(0.0, border, t) * smoothstep(1.0, border, t);\n}\nvec2 computeDropLayer(vec2 uv, float time) {\n    vec2 originalUV = uv;\n    uv.y += time * 0.75;\n    vec2 gridBase = vec2(6.0, 1.0);\n    vec2 gridSize = gridBase * 2.0;\n    vec2 cellID = floor(uv * gridSize);\n    float columnOffset = random(cellID.x);\n    uv.y += columnOffset;\n    cellID = floor(uv * gridSize);\n    vec3 cellNoise = random3(cellID.x * 35.2 + cellID.y * 2376.1);\n    vec2 cellPos = fract(uv * gridSize) - vec2(0.5, 0.0);\n    float dropCenterX = cellNoise.x - 0.5;\n    float yFactor = originalUV.y * 20.0;\n    float wiggle = sin(yFactor + sin(yFactor));\n    dropCenterX += wiggle * (0.5 - abs(dropCenterX)) * (cellNoise.z - 0.5);\n    dropCenterX *= 0.7;\n    float timeOffset = fract(time + cellNoise.z);\n    float dropCenterY = (saw(0.85, timeOffset) - 0.5) * 0.9 + 0.5;\n    vec2 dropCenter = vec2(dropCenterX, dropCenterY);\n    float distToDrop = length((cellPos - dropCenter) * vec2(1.0, 6.0));\n    float mainDrop = smoothstep(0.4, 0.0, distToDrop);\n    float rFactor = sqrt(smoothstep(1.0, dropCenterY, cellPos.y));\n    float deltaX = abs(cellPos.x - dropCenterX);\n    float trailIntensity = smoothstep(0.23 * rFactor, 0.15 * rFactor * rFactor, deltaX);\n    float frontTrail = smoothstep(-0.02, 0.02, cellPos.y - dropCenterY);\n    trailIntensity *= frontTrail * rFactor * rFactor;\n    float trail2 = smoothstep(0.2 * rFactor, 0.0, deltaX);\n    float droplets = max(0.0, (sin(originalUV.y * (1.0 - originalUV.y) * 120.0) - cellPos.y))\n            * trail2 * frontTrail * cellNoise.z;\n    float adjustedY = fract(originalUV.y * 10.0) + (cellPos.y - 0.5);\n    float dropletsDist = length(cellPos - vec2(dropCenterX, adjustedY));\n    droplets = smoothstep(0.3, 0.0, dropletsDist);\n    float dropValue = mainDrop + droplets * rFactor * frontTrail;\n    return vec2(dropValue, trailIntensity);\n}\nfloat computeStaticDrops(vec2 uv, float time) {\n    uv *= 40.0;\n    vec2 cellID = floor(uv);\n    uv = fract(uv) - 0.5;\n    vec3 cellNoise = random3(cellID.x * 107.45 + cellID.y * 3543.654);\n    vec2 targetPos = (cellNoise.xy - 0.5) * 0.7;\n    float distanceToTarget = length(uv - targetPos);\n    float fade = saw(0.025, fract(time + cellNoise.z));\n    float dropsVal = smoothstep(0.3, 0.0, distanceToTarget)\n            * fract(cellNoise.z * 10.0) * fade;\n    return dropsVal;\n}\nvec2 computeDrops(vec2 uv, float time, float staticLevel, float layerOneLevel, float layerTwoLevel) {\n    float dropsStatic = computeStaticDrops(uv, time) * staticLevel;\n    vec2 dropLayerA = computeDropLayer(uv, time) * layerOneLevel;\n    vec2 dropLayerB = computeDropLayer(uv * 1.85, time) * layerTwoLevel;\n    float combinedDrops = dropsStatic + dropLayerA.x + dropLayerB.x;\n    combinedDrops = smoothstep(0.3, 1.0, combinedDrops);\n    return vec2(combinedDrops, max(dropLayerA.y * staticLevel, dropLayerB.y * layerOneLevel));\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算各层级系数\n    float staticLevel = smoothstep(-0.5, 1.0, RAIN_AMOUNT * u_intensity) * 2.0;\n    float layerOneLevel = smoothstep(0.25, 0.75, RAIN_AMOUNT * u_intensity);\n    float layerTwoLevel = smoothstep(0.0, 0.5, RAIN_AMOUNT * u_intensity);\n    // 计算雨滴效果\n    vec2 dropEffect = computeDrops(uv, t, staticLevel, layerOneLevel, layerTwoLevel);\n    // 根据屏幕坐标生成遮罩（一般用于限定雨滴的区域）\n    vec2 maskUV = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    maskUV.x *= MASK_RATIO;\n    float mask = 1.0 - smoothstep(MASK_SIZE - MASK_BLUR, MASK_SIZE, length(maskUV));\n    vec2 maskedDropEffect = dropEffect * mask;\n    // 计算法线用于扰动预处理贴图\n    vec2 offset = vec2(0.001, 0.0);\n    float dropRight = computeDrops(uv + offset, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    float dropDown  = computeDrops(uv + offset.yx, t, staticLevel, layerOneLevel, layerTwoLevel).x * mask;\n    vec2 normal = vec2(dropRight - maskedDropEffect.x,\n            dropDown - maskedDropEffect.x);\n    // 焦点根据拖尾效果混合两个采样 LOD\n    float focus = mix(LOD - maskedDropEffect.y * RAIN_TRAIL, RAIN_TURBIDITY, smoothstep(0.1, 0.2, maskedDropEffect.x));\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 effectColor = textureLod(u_prepass, texUV + normal, focus).rgb;\n    vec3 finalColor = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f11688d = r12;
            if (r12 != 0) goto L5;
            return;
        L5:
            this.f11689e = GLES30.glGetAttribLocation(r12, "vPosition");
            d("glGetAttribLocation");
            this.f11690f = GLES30.glGetUniformLocation(this.f11688d, "u_background");
            d("glGetAttribLocation");
            this.f11691g = GLES30.glGetUniformLocation(this.f11688d, "u_prepass");
            d("glGetAttribLocation");
            this.f11692h = GLES30.glGetUniformLocation(this.f11688d, "u_resolution");
            d("glGetUniformLocation");
            this.f11693i = GLES30.glGetUniformLocation(this.f11688d, "u_time");
            d("glGetUniformLocation");
            this.f11694j = GLES30.glGetUniformLocation(this.f11688d, "u_alpha");
            d("glGetUniformLocation");
            this.f11695k = GLES30.glGetUniformLocation(this.f11688d, "u_intensity");
            d("glGetUniformLocation");
            this.f11696l = GLES30.glGetUniformLocation(this.f11688d, "u_speed");
            d("glGetUniformLocation");
            GLES30.glUseProgram(this.f11688d);
            this.f11697m = h(this.f11710z, this.C);
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.f11698n = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            int r16 = r15[0];
            this.f11699o = r16;
            GLES30.glBindBuffer(34962, r16);
            GLES30.glBufferData(34962, this.A.length * 4, this.B, 35044);
            GLES30.glEnableVertexAttribArray(this.f11689e);
            GLES30.glVertexAttribPointer(this.f11689e, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewRain(Context r10) {
        super(r10, null);
    }

    public static /* synthetic */ String a() {
        return f11683b;
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
        this.f11684a = r10;
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
        this.f11684a.j(r10);
    }

    public void setShaderAlpha(float r10) {
        a.a(this.f11684a).b(r10);
    }

    public void setShaderIntensity(float r10) {
        a.b(this.f11684a).b(r10);
    }

    public void setShaderSpeed(float r10) {
        a.c(this.f11684a).b(r10);
    }

    public GL3ShaderViewRain(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
