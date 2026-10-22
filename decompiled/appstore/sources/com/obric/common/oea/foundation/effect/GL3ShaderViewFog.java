package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
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
public class GL3ShaderViewFog extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f11558b = "GL2ShaderView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11559a;

    public static class a implements GLSurfaceView.Renderer {
        public b A;
        public int B;
        public Context C;
        public final float[] D;
        public FloatBuffer E;
        public Bitmap F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f11560J;
        public int K;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11568h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11569i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11570j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11571k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11572l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11573m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11574n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11575o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11576p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f11577q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f11578r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f11579s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f11580t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11581u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11582v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11583w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11584x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public b f11585y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public b f11586z;

        public a(Context r10) {
            this.f11561a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f11562b = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n";
            this.f11563c = "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n";
            this.f11577q = -1.0f;
            this.f11578r = -1.0f;
            this.f11579s = -1.0f;
            this.f11580t = 0;
            this.f11581u = 0;
            this.f11582v = 0;
            this.f11583w = 0;
            this.f11584x = 0;
            this.f11585y = new b(1.0f);
            this.f11586z = new b(0.8f);
            this.A = new b(0.5f);
            this.B = -3618616;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.D = r11;
            this.G = 0;
            this.K = 0;
            this.L = 0;
            this.C = r10;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.E = r12;
            r12.position(0);
        }

        public static /* synthetic */ b a(a r10) {
            return r10.f11585y;
        }

        public static /* synthetic */ b b(a r10) {
            return r10.f11586z;
        }

        public static /* synthetic */ b c(a r10) {
            return r10.A;
        }

        public static /* synthetic */ int d(a r10, int r11) {
            r10.B = r11;
            return r11;
        }

        public static int i(Context r10, Bitmap r11) {
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

        public final void e(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e(GL3ShaderViewFog.a(), r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        public final int f(String r10, String r11) {
            int r12 = h(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = h(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            e("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            e("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e(GL3ShaderViewFog.a(), "Could not link program: ");
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        public final void g() {
            if (this.G != 0) goto L5;
            int r10 = f("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nout vec4 fragColor;\nvec3 blendOverlay(in vec3 base, in vec3 blend) {\n    return mix(2.0 * base * blend, 1.0 - 2.0 * (1.0 - base) * (1.0 - blend), step(0.5, base));\n}\nvec3 dim(in vec3 baseColor) {\n    vec3 overlayColor = vec3(0.0);\n    vec3 overlayResult = blendOverlay(baseColor, overlayColor);\n    float overlayAlpha = 0.3;\n    return mix(baseColor, overlayResult, overlayAlpha);\n}\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = 1.0 - texUV.y;\n    vec4 baseColor = texture(u_background, texUV);\n    fragColor = vec4(dim(baseColor.rgb), baseColor.a);\n}\n");
            this.G = r10;
            this.H = GLES30.glGetAttribLocation(r10, "vPosition");
            e("glGetAttribLocation");
            this.I = GLES30.glGetUniformLocation(this.G, "u_background");
            e("glGetAttribLocation");
            this.f11560J = GLES30.glGetUniformLocation(this.G, "u_resolution");
            e("glGetUniformLocation");
        L5:
            GLES30.glUseProgram(this.G);
            if (this.K != 0) goto L8;
            int[] r11 = new int[1];
            GLES30.glGenFramebuffers(1, r11, 0);
            this.K = r11[0];
        L8:
            GLES30.glBindFramebuffer(36160, this.K);
            if (this.L != 0) goto L11;
            int[] r12 = new int[1];
            GLES30.glGenTextures(1, r12, 0);
            this.L = r12[0];
        L11:
            GLES30.glBindTexture(3553, this.L);
            GLES30.glTexImage2D(3553, 0, 6408, this.f11581u, this.f11583w, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9987);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.L, 0);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glUseProgram(0);
        }

        public final int h(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e(GL3ShaderViewFog.a(), "Could not compile shader " + r10 + ":");
            Log.e(GL3ShaderViewFog.a(), GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        public final void j() {
            GLES30.glBindFramebuffer(36160, this.K);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.G);
            GLES30.glUniform2f(this.f11560J, this.f11581u, this.f11583w);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11574n);
            GLES30.glUniform1i(this.I, 0);
            GLES30.glEnableVertexAttribArray(this.H);
            GLES30.glVertexAttribPointer(this.H, 2, 5126, false, 0, this.E);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindTexture(3553, this.L);
            GLES30.glGenerateMipmap(3553);
            GLES30.glBindTexture(3553, 0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public void k(Bitmap r10) {
            this.F = r10;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r10) {
            if (this.f11581u == this.f11582v) goto L5;
        L6:
            g();
            j();
        L7:
            long r11 = System.currentTimeMillis();
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11564d);
            GLES30.glUniform1f(this.f11570j, (r11 % BatteryFactorConfig.WIFI_BPS) / 1000.0f);
            int r12 = this.f11581u;
            if (r12 == this.f11582v) goto L10;
        L11:
            this.f11582v = r12;
            int r13 = this.f11583w;
            this.f11584x = r13;
            GLES30.glUniform2f(this.f11568h, r12, r13);
        L13:
            if (this.f11585y.a() == this.f11577q) goto L16;
            float r14 = this.f11585y.a();
            this.f11577q = r14;
            GLES30.glUniform1f(this.f11571k, r14);
        L16:
            if (this.f11586z.a() == this.f11578r) goto L19;
            float r15 = this.f11586z.a();
            this.f11578r = r15;
            GLES30.glUniform1f(this.f11572l, r15);
        L19:
            if (this.A.a() == this.f11579s) goto L21;
            float r16 = this.A.a();
            this.f11579s = r16;
            GLES30.glUniform1f(this.f11573m, r16);
        L21:
            int r17 = this.B;
            if (r17 == this.f11580t) goto L24;
            this.f11580t = r17;
            GLES30.glUniform3f(this.f11569i, Color.red(r17) / 255.0f, Color.green(this.f11580t) / 255.0f, Color.blue(this.f11580t) / 255.0f);
        L24:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, this.f11574n);
            GLES30.glUniform1i(this.f11566f, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, this.L);
            GLES30.glUniform1i(this.f11567g, 1);
            GLES30.glBindVertexArray(this.f11575o);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            return;
        L10:
            if (this.f11583w == this.f11584x) goto L13;
        L5:
            if (this.f11583w == this.f11584x) goto L7;
            goto L6
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.f11581u = r11;
            this.f11583w = r12;
            GLES30.glViewport(0, 0, r11, r12);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r10, EGLConfig r11) {
            int r12 = f("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\n#define PI 3.141592653589793\nuniform vec2 u_resolution;\nuniform float u_time;\nuniform sampler2D u_background;\nuniform sampler2D u_prepass;\nuniform float u_alpha;\nuniform float u_intensity;\nuniform float u_speed;\nuniform vec3 u_color;\nconst float LOD             = 9.0;\nconst int FBM_OCTAVES       = 4;\nconst float DUST_GRID_SIZE  = 80.0;\nconst float DUST_SIZE       = 2.0;\nconst vec2 SHIFT            = vec2(0.07, -0.03);\nout vec4 fragColor;\nfloat random(in vec2 uv) {\n    return fract(sin(dot(uv, vec2(12.9898, 78.233))) * 43758.5453123);\n}\nvec2 hash(in vec2 p) {\n    return fract(sin(vec2(dot(p, vec2(127.1, 311.7)),\n            dot(p, vec2(269.5, 183.3))))\n            * 43758.5453123);\n}\nfloat noise(in vec2 uv) {\n    vec2 i = floor(uv);\n    vec2 f = fract(uv);\n    float a = random(i);\n    float b = random(i + vec2(1.0, 0.0));\n    float c = random(i + vec2(0.0, 1.0));\n    float d = random(i + vec2(1.0, 1.0));\n    vec2 u = f * f * (3.0 - 2.0 * f);\n    return mix(a, b, u.x) +\n            (c - a) * u.y * (1.0 - u.x) +\n            (d - b) * u.x * u.y;\n}\nfloat fbm(in vec2 uv) {\n    float value = 0.0;\n    float amplitude = 0.5;\n    vec2 shiftUV = vec2(100.0);\n    mat2 rot = mat2(cos(0.5), sin(0.5),\n            -sin(0.5), cos(0.5));\n    for (int i = 0; i < FBM_OCTAVES; i++) {\n        value += amplitude * noise(uv);\n        uv = uv * rot * 2.0 + shiftUV;\n        amplitude *= 0.5;\n    }\n    return value;\n}\nfloat computeFog(in vec2 uv, in float t) {\n    uv += t * SHIFT;\n    vec2 q;\n    q.x = fbm(uv + 0.1 * t);\n    q.y = fbm(uv + 1.0);\n    vec2 r;\n    r.x = fbm(uv + q + vec2(1.7, 9.2) + 0.15 * t);\n    r.y = fbm(uv + q + vec2(8.3, 2.8) + 0.126 * t);\n    float f = fbm(uv + r) * u_intensity;\n    float end = mix(1.0, 0.5, u_intensity);\n    return smoothstep(0.0, end, f);\n}\nfloat computeDust(in float t) {\n    vec2 coord = gl_FragCoord.xy + u_resolution.y * t * SHIFT * 4.0;\n    float gridSize = mix(DUST_GRID_SIZE * 2.0, DUST_GRID_SIZE, u_intensity);\n    vec2 cellPos = floor(coord / gridSize);\n    vec2 randOffset = hash(cellPos);\n    vec2 drift = vec2(sin(t + randOffset.x * 6.28318),\n            cos(t + randOffset.y * 6.28318)) * gridSize;\n    vec2 dustCenter = (cellPos + randOffset) * gridSize + drift;\n    float d = length(coord - dustCenter);\n    float particle = 1.0 - smoothstep(0.0, DUST_SIZE, d);\n    float brightness = mix(0.5, 1.0, randOffset.y);\n    return particle * brightness;\n}\nvoid main() {\n    vec2 uv = (gl_FragCoord.xy - 0.5 * u_resolution) / u_resolution.y;\n    float t = u_time * u_speed;\n    // 计算雾效果与尘埃\n    float fogEffect  = computeFog(uv, t);\n    float dustEffect = computeDust(t);\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec3 baseColor = texture(u_background, texUV).rgb;\n    vec3 prepassColor = textureLod(u_prepass, texUV, LOD).rgb;\n    // 将雾与尘埃和指定颜色混合\n    vec3 effectColor = mix(prepassColor, (fogEffect + dustEffect) * u_color, fogEffect);\n    vec3 finalColor  = mix(baseColor, effectColor, u_alpha);\n    fragColor = vec4(finalColor, 1.0);\n}\n");
            this.f11564d = r12;
            if (r12 != 0) goto L5;
            return;
        L5:
            this.f11565e = GLES30.glGetAttribLocation(r12, "vPosition");
            e("glGetAttribLocation");
            this.f11566f = GLES30.glGetUniformLocation(this.f11564d, "u_background");
            e("glGetAttribLocation");
            this.f11567g = GLES30.glGetUniformLocation(this.f11564d, "u_prepass");
            e("glGetAttribLocation");
            this.f11568h = GLES30.glGetUniformLocation(this.f11564d, "u_resolution");
            e("glGetUniformLocation");
            this.f11569i = GLES30.glGetUniformLocation(this.f11564d, "u_color");
            e("glGetUniformLocation");
            this.f11570j = GLES30.glGetUniformLocation(this.f11564d, "u_time");
            e("glGetUniformLocation");
            this.f11571k = GLES30.glGetUniformLocation(this.f11564d, "u_alpha");
            e("glGetUniformLocation");
            this.f11572l = GLES30.glGetUniformLocation(this.f11564d, "u_intensity");
            e("glGetUniformLocation");
            this.f11573m = GLES30.glGetUniformLocation(this.f11564d, "u_speed");
            e("glGetUniformLocation");
            GLES30.glUseProgram(this.f11564d);
            this.f11574n = i(this.C, this.F);
            int[] r13 = new int[1];
            GLES30.glGenVertexArrays(1, r13, 0);
            int r14 = r13[0];
            this.f11575o = r14;
            GLES30.glBindVertexArray(r14);
            int[] r15 = new int[1];
            GLES30.glGenBuffers(1, r15, 0);
            int r16 = r15[0];
            this.f11576p = r16;
            GLES30.glBindBuffer(34962, r16);
            GLES30.glBufferData(34962, this.D.length * 4, this.E, 35044);
            GLES30.glEnableVertexAttribArray(this.f11565e);
            GLES30.glVertexAttribPointer(this.f11565e, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
        }
    }

    static {
    }

    public GL3ShaderViewFog(Context r10) {
        super(r10, null);
    }

    public static /* synthetic */ String a() {
        return f11558b;
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
        this.f11559a = r10;
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
        this.f11559a.k(r10);
    }

    public void setShaderAlpha(float r10) {
        a.a(this.f11559a).b(r10);
    }

    public void setShaderColor(int r10) {
        a.d(this.f11559a, r10);
    }

    public void setShaderIntensity(float r10) {
        a.b(this.f11559a).b(r10);
    }

    public void setShaderSpeed(float r10) {
        a.c(this.f11559a).b(r10);
    }

    public GL3ShaderViewFog(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
