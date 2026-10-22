package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES30;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class GL3ShaderViewKawaseBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11587a;

    public class a implements GLSurfaceView.Renderer {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f11588J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public int V;
        public int W;
        public final float[] X;
        public FloatBuffer Y;
        public Bitmap Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11589a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public Bitmap f11590a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11591b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f11592b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11593c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f11594c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f11595d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f11596d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f11597e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f11598e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11599f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public int f11600f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11601g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f11602g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11603h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f11604h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11605i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f11606i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11607j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f11608j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11609k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f11610k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11611l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public float f11612l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11613m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f11614m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11615n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public final /* synthetic */ GL3ShaderViewKawaseBlur f11616n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11617o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11618p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11619q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f11620r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f11621s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f11622t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11623u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11624v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11625w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11626x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f11627y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f11628z;

        public a(GL3ShaderViewKawaseBlur r10) {
            this.f11616n0 = r10;
            this.f11589a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f11591b = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.f11593c = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n";
            this.f11595d = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n";
            this.f11597e = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.f11588J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.X = r11;
            this.f11592b0 = 0;
            this.f11594c0 = 0;
            this.f11596d0 = 0;
            this.f11598e0 = 0;
            this.f11600f0 = 0;
            this.f11602g0 = 0;
            this.f11604h0 = 0;
            this.f11606i0 = 0;
            this.f11608j0 = 0;
            this.f11610k0 = 0;
            this.f11612l0 = 0.0f;
            this.f11614m0 = 0.0f;
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.Y = r12;
            r12.position(0);
        }

        public final void a(String r10) {
            int r11 = GLES30.glGetError();
            if (r11 != 0) goto L5;
            return;
        L5:
            Log.e("GL3BlurRenderer", r10 + ": glError " + r11);
            throw new RuntimeException(r10 + ": glError " + r11);
        }

        public final int[] b(int r16, int r17) {
            int[] r10 = new int[1];
            GLES30.glGenFramebuffers(1, r10, 0);
            GLES30.glBindFramebuffer(36160, r10[0]);
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            GLES30.glBindTexture(3553, r11[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r16, r17, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r11[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r10[0], r11[0]};
        }

        public final int c(String r10, String r11) {
            int r12 = e(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = e(35632, r11);
            if (r13 != 0) goto L8;
            return 0;
        L8:
            int r14 = GLES30.glCreateProgram();
            if (r14 == 0) goto L14;
            GLES30.glAttachShader(r14, r12);
            a("glAttachShader");
            GLES30.glAttachShader(r14, r13);
            a("glAttachShader");
            GLES30.glLinkProgram(r14);
            int[] r15 = new int[1];
            GLES30.glGetProgramiv(r14, 35714, r15, 0);
            if (r15[0] == 1) goto L14;
            Log.e("GL3BlurRenderer", "Could not link program: ");
            Log.e("GL3BlurRenderer", GLES30.glGetProgramInfoLog(r14));
            GLES30.glDeleteProgram(r14);
            return 0;
        L14:
            return r14;
        }

        public final int d(int r13, int r14) {
            int[] r10 = new int[1];
            GLES30.glGenTextures(1, r10, 0);
            GLES30.glBindTexture(3553, r10[0]);
            GLES30.glTexImage2D(3553, 0, 6408, r13, r14, 0, 6408, 5121, null);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
            return r10[0];
        }

        public final int e(int r10, String r11) {
            int r12 = GLES30.glCreateShader(r10);
            if (r12 == 0) goto L8;
            GLES30.glShaderSource(r12, r11);
            GLES30.glCompileShader(r12);
            int[] r13 = new int[1];
            GLES30.glGetShaderiv(r12, 35713, r13, 0);
            if (r13[0] != 0) goto L9;
            Log.e("GL3BlurRenderer", "Could not compile shader " + r10 + ":");
            Log.e("GL3BlurRenderer", GLES30.glGetShaderInfoLog(r12));
            GLES30.glDeleteShader(r12);
            return 0;
        L9:
            return r12;
        L8:
            return r12;
        }

        public final int f(Bitmap r10) {
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            int r12 = r11[0];
            if (r12 == 0) goto L6;
            GLES30.glBindTexture(3553, r12);
            GLUtils.texImage2D(3553, 0, r10, 0);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glTexParameteri(3553, 10242, 33071);
            GLES30.glTexParameteri(3553, 10243, 33071);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r11[0];
        }

        public final int[] g(int r12, int r13) {
            GLES30.glUseProgram(r12);
            int[] r10 = new int[1];
            GLES30.glGenVertexArrays(1, r10, 0);
            int r11 = r10[0];
            GLES30.glBindVertexArray(r11);
            int[] r14 = new int[1];
            GLES30.glGenBuffers(1, r14, 0);
            int r15 = r14[0];
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.X.length * 4, this.Y, 35044);
            GLES30.glEnableVertexAttribArray(r13);
            GLES30.glVertexAttribPointer(r13, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r11, r15};
        }

        public final void h(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11613m);
            GLES30.glUniform2f(this.f11618p, r13, r14);
            GLES30.glUniform1f(this.f11619q, r12);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11617o, 0);
            GLES30.glBindVertexArray(this.f11620r);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r11 == 0) goto L6;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        public final void i(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11622t);
            GLES30.glUniform2f(this.f11625w, r13, r14);
            GLES30.glUniform1f(this.f11626x, r12);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11624v, 0);
            GLES30.glBindVertexArray(this.f11627y);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
        }

        public final void j(int r10, int r11, int r12, float r13, boolean r14) {
            if (r12 == 0) goto L5;
            GLES30.glViewport(0, 0, this.P, this.Q);
            GLES30.glBindFramebuffer(36160, r12);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.A);
            if (r12 == 0) goto L9;
            GLES30.glUniform2f(this.E, this.P, this.Q);
        L10:
            GLES30.glUniform1i(this.F, r14 ? 1 : 0);
            GLES30.glUniform1f(this.G, r13);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.C, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r11);
            GLES30.glUniform1i(this.D, 1);
            GLES30.glBindVertexArray(this.H);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r12 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.E, this.L, this.N);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.L, this.N);
            goto L6
        }

        public final void k(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.P, this.Q);
            GLES30.glBindFramebuffer(36160, r11);
        L6:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11599f);
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.f11605i, this.P, this.Q);
            GLES30.glUniform1i(this.f11607j, 1);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11603h, 0);
            GLES30.glBindVertexArray(this.f11609k);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.f11605i, this.L, this.N);
            GLES30.glUniform1i(this.f11607j, 0);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.L, this.N);
            goto L6
        }

        public void l(Bitmap r10) {
            this.f11590a0 = r10;
        }

        public void m(float r10) {
            if (this.f11614m0 == r10) goto L6;
            this.f11614m0 = r10;
            this.f11612l0 = r10 * 10.0f;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r14) {
            int r15 = this.L;
            if (r15 == 0) goto L41;
            int r10 = this.N;
            if (r10 == 0) goto L42;
            boolean r11 = true;
            if (r15 == this.M) goto L10;
        L13:
            boolean r16 = true;
        L15:
            if (this.f11590a0 == this.Z) goto L20;
            int r17 = this.f11588J;
            if (r17 == 0) goto L19;
            GLES30.glDeleteTextures(1, new int[]{r17}, 0);
        L19:
            this.f11588J = f(this.f11590a0);
        L21:
            if (r11 == false) goto L26;
            k(this.f11588J, this.f11592b0);
            if (this.K != 0) goto L25;
            this.K = d(this.P, this.Q);
        L25:
            GLES30.glBindFramebuffer(36160, this.f11592b0);
            GLES30.glBindTexture(3553, this.K);
            GLES30.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, this.P, this.Q);
            GLES30.glBindFramebuffer(36160, 0);
            GLES30.glBindTexture(3553, 0);
        L26:
            float r18 = this.f11612l0;
            if (r18 < 150.0f) goto L30;
            float r19 = r18 / 120.0f;
            h(this.K, this.f11600f0, r19, this.R, this.S);
            h(this.f11602g0, this.f11604h0, r19, this.T, this.U);
            h(this.f11606i0, this.f11608j0, r19, this.V, this.W);
            i(this.f11610k0, this.f11604h0, r19, this.T, this.U);
            i(this.f11606i0, this.f11600f0, r19, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r19, this.P, this.Q);
            k(this.f11594c0, 0);
        L39:
            this.M = this.L;
            this.O = this.N;
            this.Z = this.f11590a0;
            return;
        L30:
            if (r18 < 120.0f) goto L33;
            float r110 = r18 / 120.0f;
            h(this.K, this.f11600f0, r110, this.R, this.S);
            h(this.f11602g0, this.f11604h0, r110, this.T, this.U);
            h(this.f11606i0, this.f11608j0, r110, this.V, this.W);
            i(this.f11610k0, this.f11604h0, r110, this.T, this.U);
            i(this.f11606i0, this.f11600f0, r110, this.R, this.S);
            i(this.f11602g0, this.f11596d0, r110, this.P, this.Q);
            float r111 = this.f11612l0 / 30.0f;
            h(this.K, this.f11600f0, r111, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r111, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r111, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r111, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r111, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r111, this.P, this.Q);
            j(this.f11594c0, this.f11598e0, 0, 1.0f - ((150.0f - this.f11612l0) / 30.0f), false);
            goto L39
        L33:
            if (r18 < 30.0f) goto L36;
            float r112 = r18 / 30.0f;
            h(this.K, this.f11600f0, r112, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r112, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r112, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r112, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r112, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r112, this.P, this.Q);
            k(this.f11594c0, 0);
            goto L39
        L36:
            if (r18 < 15.0f) goto L38;
            float r113 = r18 / 15.0f;
            h(this.K, this.f11592b0, r113, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, r113, this.P, this.Q);
            h(this.f11598e0, this.f11592b0, r113, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, r113, this.P, this.Q);
            h(this.f11598e0, this.f11592b0, r113, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, r113, this.P, this.Q);
            float r114 = this.f11612l0 / 30.0f;
            h(this.K, this.f11600f0, r114, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r114, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r114, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r114, this.P, this.Q);
            h(this.f11594c0, this.f11600f0, r114, this.R, this.S);
            i(this.f11602g0, this.f11592b0, r114, this.P, this.Q);
            j(this.f11598e0, this.f11594c0, 0, 1.0f - ((30.0f - this.f11612l0) / 15.0f), false);
            goto L39
        L38:
            h(this.K, this.f11592b0, 1.0f, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, 1.0f, this.P, this.Q);
            h(this.f11598e0, this.f11592b0, 1.0f, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, 1.0f, this.P, this.Q);
            h(this.f11598e0, this.f11592b0, 1.0f, this.P, this.Q);
            i(this.f11594c0, this.f11596d0, 1.0f, this.P, this.Q);
            j(this.f11588J, this.f11598e0, 0, this.f11612l0 / 15.0f, true);
            goto L39
        L20:
            r11 = r16;
            goto L21
        L10:
            if (r10 != this.O) goto L13;
            r16 = false;
            goto L15
        L42:
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.L = r11;
            this.N = r12;
            if (r11 == 0) goto L43;
            if (r12 != 0) goto L7;
            return;
        L7:
            if (r11 == this.M) goto L9;
        L11:
            int r13 = this.f11592b0;
            if (r13 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L14:
            int r14 = this.f11594c0;
            if (r14 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L17:
            int r15 = this.f11596d0;
            if (r15 == 0) goto L20;
            GLES30.glDeleteFramebuffers(1, new int[]{r15}, 0);
        L20:
            int r16 = this.f11598e0;
            if (r16 == 0) goto L23;
            GLES30.glDeleteTextures(1, new int[]{r16}, 0);
        L23:
            int r17 = this.f11600f0;
            if (r17 == 0) goto L26;
            GLES30.glDeleteFramebuffers(1, new int[]{r17}, 0);
        L26:
            int r18 = this.f11602g0;
            if (r18 == 0) goto L29;
            GLES30.glDeleteTextures(1, new int[]{r18}, 0);
        L29:
            int r19 = this.f11604h0;
            if (r19 == 0) goto L32;
            GLES30.glDeleteFramebuffers(1, new int[]{r19}, 0);
        L32:
            int r20 = this.f11606i0;
            if (r20 == 0) goto L35;
            GLES30.glDeleteTextures(1, new int[]{r20}, 0);
        L35:
            int r21 = this.f11608j0;
            if (r21 == 0) goto L38;
            GLES30.glDeleteFramebuffers(1, new int[]{r21}, 0);
        L38:
            int r22 = this.f11610k0;
            if (r22 == 0) goto L41;
            GLES30.glDeleteTextures(1, new int[]{r22}, 0);
        L41:
            int r23 = this.L / 4;
            this.P = r23;
            int r24 = this.N / 4;
            this.Q = r24;
            int[] r25 = b(r23, r24);
            this.f11592b0 = r25[0];
            this.f11594c0 = r25[1];
            int[] r26 = b(this.P, this.Q);
            this.f11596d0 = r26[0];
            this.f11598e0 = r26[1];
            this.R = (int) Math.ceil(this.P / 2.0f);
            int r27 = (int) Math.ceil(this.Q / 2.0f);
            this.S = r27;
            int[] r28 = b(this.R, r27);
            this.f11600f0 = r28[0];
            this.f11602g0 = r28[1];
            this.T = (int) Math.ceil(this.R / 2.0f);
            int r29 = (int) Math.ceil(this.S / 2.0f);
            this.U = r29;
            int[] r30 = b(this.T, r29);
            this.f11604h0 = r30[0];
            this.f11606i0 = r30[1];
            this.V = (int) Math.ceil(this.T / 2.0f);
            int r31 = (int) Math.ceil(this.U / 2.0f);
            this.W = r31;
            int[] r32 = b(this.V, r31);
            this.f11608j0 = r32[0];
            this.f11610k0 = r32[1];
            return;
        L9:
            if (r12 != this.O) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f11599f = r13;
            this.f11601g = GLES30.glGetAttribLocation(r13, "vPosition");
            a("glGetAttribLocation");
            this.f11603h = GLES30.glGetUniformLocation(this.f11599f, "u_background");
            a("glGetAttribLocation");
            this.f11605i = GLES30.glGetUniformLocation(this.f11599f, "u_resolution");
            a("glGetUniformLocation");
            this.f11607j = GLES30.glGetUniformLocation(this.f11599f, "u_revert");
            a("glGetUniformLocation");
            int[] r10 = g(this.f11599f, this.f11601g);
            this.f11609k = r10[0];
            this.f11611l = r10[1];
            int r14 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 0.125;\n}\n");
            this.f11613m = r14;
            this.f11615n = GLES30.glGetAttribLocation(r14, "vPosition");
            a("glGetAttribLocation");
            this.f11617o = GLES30.glGetUniformLocation(this.f11613m, "u_background");
            a("glGetAttribLocation");
            this.f11618p = GLES30.glGetUniformLocation(this.f11613m, "u_resolution");
            a("glGetUniformLocation");
            this.f11619q = GLES30.glGetUniformLocation(this.f11613m, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r15 = g(this.f11613m, this.f11615n);
            this.f11620r = r15[0];
            this.f11621s = r15[1];
            int r16 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * u_blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * u_blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f11622t = r16;
            this.f11623u = GLES30.glGetAttribLocation(r16, "vPosition");
            a("glGetAttribLocation");
            this.f11624v = GLES30.glGetUniformLocation(this.f11622t, "u_background");
            a("glGetAttribLocation");
            this.f11625w = GLES30.glGetUniformLocation(this.f11622t, "u_resolution");
            a("glGetUniformLocation");
            this.f11626x = GLES30.glGetUniformLocation(this.f11622t, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r17 = g(this.f11622t, this.f11623u);
            this.f11627y = r17[0];
            this.f11628z = r17[1];
            int r18 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform int u_revert;\nuniform float u_alpha;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    vec4 colorB = texture(u_foreground, texUV);\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    vec4 colorA = texture(u_background, texUV);\n    fragColor = mix(colorA, colorB, u_alpha);\n}\n");
            this.A = r18;
            this.B = GLES30.glGetAttribLocation(r18, "vPosition");
            a("glGetAttribLocation");
            this.C = GLES30.glGetUniformLocation(this.A, "u_background");
            a("glGetAttribLocation");
            this.D = GLES30.glGetUniformLocation(this.A, "u_foreground");
            a("glGetAttribLocation");
            this.E = GLES30.glGetUniformLocation(this.A, "u_resolution");
            a("glGetUniformLocation");
            this.F = GLES30.glGetUniformLocation(this.A, "u_revert");
            a("glGetUniformLocation");
            this.G = GLES30.glGetUniformLocation(this.A, "u_alpha");
            a("glGetUniformLocation");
            int[] r19 = g(this.A, this.B);
            this.H = r19[0];
            this.I = r19[1];
        }
    }

    static {
    }

    public GL3ShaderViewKawaseBlur(Context r10) {
        super(r10, null);
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
        a r10 = new a(this);
        this.f11587a = r10;
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
        this.f11587a.l(r10);
    }

    public void setBlurRadius(float r10) {
        this.f11587a.m(r10);
    }

    public GL3ShaderViewKawaseBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
