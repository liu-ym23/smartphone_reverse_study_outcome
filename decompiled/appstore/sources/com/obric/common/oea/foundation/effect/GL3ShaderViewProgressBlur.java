package com.obric.common.oea.foundation.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
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
public class GL3ShaderViewProgressBlur extends GLSurfaceView implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f11629a;

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
        public int f11630J;
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
        public int X;
        public int Y;
        public float Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11631a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public float f11632a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11633b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f11634b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f11635c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f11636c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f11637d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f11638d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f11639e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f11640e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f11641f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public final float[] f11642f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11643g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public FloatBuffer f11644g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11645h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public Bitmap f11646h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11647i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public Bitmap f11648i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11649j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f11650j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11651k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f11652k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11653l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f11654l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11655m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f11656m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f11657n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f11658n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f11659o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f11660o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f11661p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f11662p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f11663q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f11664q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f11665r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public int f11666r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f11667s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f11668s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f11669t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f11670t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f11671u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public int f11672u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f11673v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public float f11674v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f11675w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public int f11676w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f11677x;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public Rect f11678x0;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f11679y;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public Rect f11680y0;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f11681z;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final /* synthetic */ GL3ShaderViewProgressBlur f11682z0;

        public a(GL3ShaderViewProgressBlur r10) {
            this.f11682z0 = r10;
            this.f11631a = "#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n";
            this.f11633b = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n";
            this.f11635c = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n";
            this.f11637d = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n";
            this.f11639e = "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n";
            this.f11641f = "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n";
            this.U = 0;
            this.V = 0;
            this.W = 0;
            this.X = 0;
            this.Y = 0;
            this.Z = 0.0f;
            this.f11632a0 = 0.0f;
            float[] r11 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
            this.f11642f0 = r11;
            this.f11650j0 = 0;
            this.f11652k0 = 0;
            this.f11654l0 = 0;
            this.f11656m0 = 0;
            this.f11658n0 = 0;
            this.f11660o0 = 0;
            this.f11662p0 = 0;
            this.f11664q0 = 0;
            this.f11666r0 = 0;
            this.f11668s0 = 0;
            this.f11670t0 = 0;
            this.f11672u0 = 0;
            this.f11674v0 = 60.0f;
            this.f11676w0 = 0;
            this.f11678x0 = new Rect(0, 0, 1264, 400);
            this.f11680y0 = new Rect(0, 0, 1264, 400);
            FloatBuffer r12 = ByteBuffer.allocateDirect(r11.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(r11);
            this.f11644g0 = r12;
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
            GLES30.glTexParameteri(3553, 10242, 33648);
            GLES30.glTexParameteri(3553, 10243, 33648);
            GLES30.glTexParameteri(3553, 10241, 9729);
            GLES30.glTexParameteri(3553, 10240, 9729);
            GLES30.glFramebufferTexture2D(36160, 36064, 3553, r11[0], 0);
            GLES30.glBindFramebuffer(36160, 0);
            return new int[]{r10[0], r11[0]};
        }

        public final int c(String r10, String r11) {
            int r12 = d(35633, r10);
            if (r12 != 0) goto L5;
            return 0;
        L5:
            int r13 = d(35632, r11);
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

        public final int d(int r10, String r11) {
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

        public final int e(Bitmap r10) {
            int[] r11 = new int[1];
            GLES30.glGenTextures(1, r11, 0);
            int r12 = r11[0];
            if (r12 == 0) goto L6;
            GLES30.glBindTexture(3553, r12);
            GLUtils.texImage2D(3553, 0, r10, 0);
            GLES30.glTexParameteri(3553, 10241, 9728);
            GLES30.glTexParameteri(3553, 10240, 9728);
            GLES30.glTexParameteri(3553, 10242, 10497);
            GLES30.glTexParameteri(3553, 10243, 10497);
            GLES30.glBindTexture(3553, 0);
        L6:
            return r11[0];
        }

        public final int[] f(int r12, int r13) {
            GLES30.glUseProgram(r12);
            int[] r10 = new int[1];
            GLES30.glGenVertexArrays(1, r10, 0);
            int r11 = r10[0];
            GLES30.glBindVertexArray(r11);
            int[] r14 = new int[1];
            GLES30.glGenBuffers(1, r14, 0);
            int r15 = r14[0];
            GLES30.glBindBuffer(34962, r15);
            GLES30.glBufferData(34962, this.f11642f0.length * 4, this.f11644g0, 35044);
            GLES30.glEnableVertexAttribArray(r13);
            GLES30.glVertexAttribPointer(r13, 2, 5126, false, 0, 0);
            GLES30.glBindBuffer(34962, 0);
            GLES30.glBindVertexArray(0);
            GLES30.glUseProgram(0);
            return new int[]{r11, r15};
        }

        public void g() {
            int r10 = this.f11654l0;
            if (r10 == 0) goto L5;
            GLES30.glDeleteFramebuffers(1, new int[]{r10}, 0);
        L5:
            int r11 = this.f11656m0;
            if (r11 == 0) goto L8;
            GLES30.glDeleteTextures(1, new int[]{r11}, 0);
        L8:
            int r12 = this.f11658n0;
            if (r12 == 0) goto L11;
            GLES30.glDeleteFramebuffers(1, new int[]{r12}, 0);
        L11:
            int r13 = this.f11660o0;
            if (r13 == 0) goto L14;
            GLES30.glDeleteTextures(1, new int[]{r13}, 0);
        L14:
            int r14 = this.f11662p0;
            if (r14 == 0) goto L17;
            GLES30.glDeleteFramebuffers(1, new int[]{r14}, 0);
        L17:
            int r15 = this.f11664q0;
            if (r15 == 0) goto L20;
            GLES30.glDeleteTextures(1, new int[]{r15}, 0);
        L20:
            int r16 = this.f11666r0;
            if (r16 == 0) goto L23;
            GLES30.glDeleteFramebuffers(1, new int[]{r16}, 0);
        L23:
            int r17 = this.f11668s0;
            if (r17 == 0) goto L26;
            GLES30.glDeleteTextures(1, new int[]{r17}, 0);
        L26:
            int r18 = this.f11670t0;
            if (r18 == 0) goto L29;
            GLES30.glDeleteFramebuffers(1, new int[]{r18}, 0);
        L29:
            int r19 = this.f11672u0;
            if (r19 == 0) goto L32;
            GLES30.glDeleteTextures(1, new int[]{r19}, 0);
        L32:
            int[] r20 = b(this.f11678x0.width(), this.f11678x0.height());
            this.f11654l0 = r20[0];
            this.f11656m0 = r20[1];
            int[] r21 = b(this.f11678x0.width(), this.f11678x0.height());
            this.f11658n0 = r21[0];
            this.f11660o0 = r21[1];
            this.f11634b0 = this.f11678x0.width() / 2;
            int r22 = this.f11678x0.height() / 2;
            this.f11636c0 = r22;
            int[] r23 = b(this.f11634b0, r22);
            this.f11662p0 = r23[0];
            this.f11664q0 = r23[1];
            int[] r24 = b(this.f11634b0, this.f11636c0);
            this.f11666r0 = r24[0];
            this.f11668s0 = r24[1];
            this.f11638d0 = (int) Math.ceil(this.f11634b0 / 2.0f);
            int r25 = (int) Math.ceil(this.f11636c0 / 2.0f);
            this.f11640e0 = r25;
            int[] r26 = b(this.f11638d0, r25);
            this.f11670t0 = r26[0];
            this.f11672u0 = r26[1];
        }

        public final void h(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11659o);
            GLES30.glUniform2f(this.f11665r, r13, r14);
            GLES30.glUniform1f(this.f11669t, r12);
            int r15 = this.f11676w0;
            if (r15 != 0) goto L6;
            GLES30.glUniform4f(this.f11667s, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11663q, 0);
            GLES30.glBindVertexArray(this.f11671u);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            if (r11 == 0) goto L12;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L12:
            return;
        L6:
            if (r15 != 1) goto L8;
            GLES30.glUniform4f(this.f11667s, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        public final void i(int r10, int r11, float r12, int r13, int r14) {
            GLES30.glViewport(0, 0, r13, r14);
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11675w);
            GLES30.glUniform2f(this.f11681z, r13, r14);
            GLES30.glUniform1f(this.B, r12);
            int r15 = this.f11676w0;
            if (r15 != 0) goto L6;
            GLES30.glUniform4f(this.A, 0.0f, 0.0f, 0.0f, 1.0f);
        L8:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11679y, 0);
            GLES30.glBindVertexArray(this.C);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L6:
            if (r15 != 1) goto L8;
            GLES30.glUniform4f(this.A, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L8
        }

        public final void j(int r10, int r11) {
            if (r11 == 0) goto L5;
            GLES30.glViewport(0, 0, this.f11678x0.width(), this.f11678x0.height());
            GLES30.glBindFramebuffer(36160, r11);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
        L6:
            GLES30.glUseProgram(this.E);
            Rect r12 = this.f11678x0;
            float r13 = r12.left / this.V;
            int r14 = this.X;
            float r15 = (r14 - r12.bottom) / r14;
            float r16 = r12.width() / this.V;
            float r17 = this.f11678x0.height();
            int r18 = this.X;
            float r19 = r17 / r18;
            if (r11 == 0) goto L9;
            GLES30.glUniform2f(this.H, this.f11678x0.width(), this.f11678x0.height());
            GLES30.glUniform4f(this.I, r13, r15, r16, r19);
        L10:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.G, 0);
            GLES30.glBindVertexArray(this.f11630J);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L14;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L14:
            return;
        L9:
            GLES30.glUniform2f(this.H, this.V, r18);
            GLES30.glUniform4f(this.I, (-r13) / r16, (-r15) / r19, 1.0f / r16, 1.0f / r19);
            goto L10
        L5:
            GLES30.glViewport(0, 0, this.V, this.X);
            goto L6
        }

        public final void k(int r10, int r11, int r12, float r13) {
            GLES30.glViewport(0, 0, this.f11678x0.width(), this.f11678x0.height());
            GLES30.glBindFramebuffer(36160, r12);
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.L);
            GLES30.glUniform2f(this.P, this.f11678x0.width(), this.f11678x0.height());
            GLES30.glUniform1f(this.R, r13);
            int r14 = this.f11676w0;
            if (r14 != 0) goto L5;
            GLES30.glUniform4f(this.Q, 0.0f, 0.0f, 0.0f, 1.0f);
        L7:
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.N, 0);
            GLES30.glActiveTexture(33985);
            GLES30.glBindTexture(3553, r11);
            GLES30.glUniform1i(this.O, 1);
            GLES30.glBindVertexArray(this.S);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindFramebuffer(36160, 0);
            return;
        L5:
            if (r14 != 1) goto L7;
            GLES30.glUniform4f(this.Q, 0.0f, 1.0f, 0.0f, -1.0f);
            goto L7
        }

        public final void l(int r10, int r11, boolean r12, float r13, float r14) {
            GLES30.glViewport(0, 0, this.V, this.X);
            if (r11 == 0) goto L5;
            GLES30.glBindFramebuffer(36160, r11);
        L5:
            GLES30.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES30.glClear(16384);
            GLES30.glUseProgram(this.f11643g);
            GLES30.glUniform2f(this.f11649j, this.V, this.X);
            GLES30.glUniform1i(this.f11651k, r12 ? 1 : 0);
            GLES30.glUniform2f(this.f11653l, r13, r14);
            GLES30.glActiveTexture(33984);
            GLES30.glBindTexture(3553, r10);
            GLES30.glUniform1i(this.f11647i, 0);
            GLES30.glBindVertexArray(this.f11655m);
            GLES30.glDrawArrays(6, 0, 4);
            GLES30.glBindVertexArray(0);
            GLES30.glBindTexture(3553, 0);
            if (r11 == 0) goto L9;
            GLES30.glBindFramebuffer(36160, 0);
            return;
        }

        public void m(Bitmap r10) {
            this.f11648i0 = r10;
        }

        public void n(float r10) {
            this.f11674v0 = r10 * 20.0f;
        }

        public void o(Rect r10) {
            this.f11678x0.set(r10);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 r11) {
            if (this.V != 0) goto L5;
            return;
        L5:
            if (this.X != 0) goto L8;
            return;
        L8:
            if (this.f11648i0 == this.f11646h0) goto L13;
            int r12 = this.U;
            if (r12 == 0) goto L12;
            GLES30.glDeleteTextures(1, new int[]{r12}, 0);
        L12:
            this.U = e(this.f11648i0);
        L13:
            l(this.U, this.f11650j0, true, this.Z, this.f11632a0);
            if (this.f11680y0.width() == this.f11678x0.width()) goto L16;
        L17:
            g();
        L18:
            j(this.f11652k0, this.f11654l0);
            float r13 = this.f11674v0 / 30.0f;
            h(this.f11656m0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            h(this.f11664q0, this.f11670t0, r13, this.f11638d0, this.f11640e0);
            i(this.f11672u0, this.f11662p0, r13, this.f11634b0, this.f11636c0);
            k(this.f11656m0, this.f11664q0, this.f11658n0, r13);
            l(this.f11652k0, 0, false, 0.0f, 0.0f);
            j(this.f11660o0, 0);
            this.W = this.V;
            this.Y = this.X;
            this.f11646h0 = this.f11648i0;
            this.f11680y0.set(this.f11678x0);
            return;
        L16:
            if (this.f11680y0.height() == this.f11678x0.height()) goto L18;
            goto L17
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 r10, int r11, int r12) {
            this.V = r11;
            this.X = r12;
            if (r11 == 0) goto L19;
            if (r12 != 0) goto L7;
            return;
        L7:
            if (r11 == this.W) goto L9;
        L11:
            int r13 = this.f11650j0;
            if (r13 == 0) goto L14;
            GLES30.glDeleteFramebuffers(1, new int[]{r13}, 0);
        L14:
            int r14 = this.f11652k0;
            if (r14 == 0) goto L17;
            GLES30.glDeleteTextures(1, new int[]{r14}, 0);
        L17:
            int[] r15 = b(this.V, this.X);
            this.f11650j0 = r15[0];
            this.f11652k0 = r15[1];
            g();
            return;
        L9:
            if (r12 != this.Y) goto L11;
            return;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 r11, EGLConfig r12) {
            int r13 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec2 u_uvOffset;\nuniform sampler2D u_background;\nuniform int u_revert;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.y = u_revert > 0 ? 1.0 - texUV.y : texUV.y;\n    texUV += u_uvOffset;\n    fragColor = texture(u_background, texUV);\n}\n");
            this.f11643g = r13;
            this.f11645h = GLES30.glGetAttribLocation(r13, "vPosition");
            a("glGetAttribLocation");
            this.f11647i = GLES30.glGetUniformLocation(this.f11643g, "u_background");
            a("glGetAttribLocation");
            this.f11649j = GLES30.glGetUniformLocation(this.f11643g, "u_resolution");
            a("glGetUniformLocation");
            this.f11651k = GLES30.glGetUniformLocation(this.f11643g, "u_revert");
            a("glGetUniformLocation");
            this.f11653l = GLES30.glGetUniformLocation(this.f11643g, "u_uvOffset");
            a("glGetUniformLocation");
            int[] r10 = f(this.f11643g, this.f11645h);
            this.f11655m = r10[0];
            this.f11657n = r10[1];
            int r14 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor = texture(u_background, uv) * 0.5;\n    fragColor += texture(u_background, uv - halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + halfPixel * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n    fragColor += texture(u_background, uv - vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 0.125;\n}\n");
            this.f11659o = r14;
            this.f11661p = GLES30.glGetAttribLocation(r14, "vPosition");
            a("glGetAttribLocation");
            this.f11663q = GLES30.glGetUniformLocation(this.f11659o, "u_background");
            a("glGetAttribLocation");
            this.f11665r = GLES30.glGetUniformLocation(this.f11659o, "u_resolution");
            a("glGetUniformLocation");
            this.f11667s = GLES30.glGetUniformLocation(this.f11659o, "u_direction");
            a("glGetUniformLocation");
            this.f11669t = GLES30.glGetUniformLocation(this.f11659o, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r15 = f(this.f11659o, this.f11661p);
            this.f11671u = r15[0];
            this.f11673v = r15[1];
            int r16 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision mediump float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec2 halfPixel = 0.5 / u_resolution;\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    blurOffset = blurOffset < 1.0 ? 1.0 : blurOffset;\n    fragColor =  texture(u_background, uv + vec2(-halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(halfPixel.x * 2.0, 0.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor += texture(u_background, uv + vec2(0.0, -halfPixel.y * 2.0) * blurOffset);\n    fragColor += texture(u_background, uv + vec2(-halfPixel.x, -halfPixel.y) * blurOffset) * 2.0;\n    fragColor /=  12.0;\n}\n");
            this.f11675w = r16;
            this.f11677x = GLES30.glGetAttribLocation(r16, "vPosition");
            a("glGetAttribLocation");
            this.f11679y = GLES30.glGetUniformLocation(this.f11675w, "u_background");
            a("glGetAttribLocation");
            this.f11681z = GLES30.glGetUniformLocation(this.f11675w, "u_resolution");
            a("glGetUniformLocation");
            this.A = GLES30.glGetUniformLocation(this.f11675w, "u_direction");
            a("glGetUniformLocation");
            this.B = GLES30.glGetUniformLocation(this.f11675w, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r17 = f(this.f11675w, this.f11677x);
            this.C = r17[0];
            this.D = r17[1];
            int r18 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform sampler2D u_background;\nuniform int u_revert;\nuniform vec4 u_clip;\nout vec4 fragColor;\nvoid main() {\n    vec2 texUV = gl_FragCoord.xy / u_resolution;\n    texUV.x = u_clip.x + u_clip.z * texUV.x;\n    texUV.y = u_clip.y + u_clip.w * texUV.y;\n    if (texUV.x < 0.0 || texUV.x > 1.0 || texUV.y < 0.0 || texUV.y > 1.0) {\n        discard;\n    }\n    fragColor = texture(u_background, texUV);\n}\n");
            this.E = r18;
            this.F = GLES30.glGetAttribLocation(r18, "vPosition");
            a("glGetAttribLocation");
            this.G = GLES30.glGetUniformLocation(this.E, "u_background");
            a("glGetAttribLocation");
            this.H = GLES30.glGetUniformLocation(this.E, "u_resolution");
            a("glGetUniformLocation");
            this.I = GLES30.glGetUniformLocation(this.E, "u_clip");
            a("glGetUniformLocation");
            int[] r19 = f(this.E, this.F);
            this.f11630J = r19[0];
            this.K = r19[1];
            int r110 = c("#version 300 es\nin vec4 vPosition;\nvoid main() {\n  gl_Position = vPosition;\n}\n", "#version 300 es\nprecision highp float;\nuniform vec2 u_resolution;\nuniform vec4 u_direction;\nuniform sampler2D u_background;\nuniform sampler2D u_foreground;\nuniform float u_blurOffset;\nout vec4 fragColor;\nfloat easeInCubic(float t) {\n    return t * t;\n}\nvoid main() {\n    vec2 uv = gl_FragCoord.xy / u_resolution;\n    vec4 colorA = texture(u_background, uv);\n    vec4 colorB = texture(u_foreground, uv);\n    float factor = dot(uv - u_direction.xy, u_direction.zw);\n    float blurOffset = u_blurOffset * easeInCubic(factor);\n    float alpha = blurOffset > 2.0 ? 1.0 : blurOffset / 2.0;\n    fragColor = mix(colorA, colorB, alpha);\n}\n");
            this.L = r110;
            this.M = GLES30.glGetAttribLocation(r110, "vPosition");
            a("glGetAttribLocation");
            this.N = GLES30.glGetUniformLocation(this.L, "u_background");
            a("glGetAttribLocation");
            this.O = GLES30.glGetUniformLocation(this.L, "u_foreground");
            a("glGetAttribLocation");
            this.P = GLES30.glGetUniformLocation(this.L, "u_resolution");
            a("glGetUniformLocation");
            this.Q = GLES30.glGetUniformLocation(this.L, "u_direction");
            a("glGetUniformLocation");
            this.R = GLES30.glGetUniformLocation(this.L, "u_blurOffset");
            a("glGetUniformLocation");
            int[] r111 = f(this.L, this.M);
            this.S = r111[0];
            this.T = r111[1];
        }

        public void p(int r10) {
            this.f11676w0 = r10;
        }
    }

    static {
    }

    public GL3ShaderViewProgressBlur(Context r10) {
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
        this.f11629a = r10;
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
        this.f11629a.m(r10);
    }

    public void setBlurRadius(float r10) {
        this.f11629a.n(r10);
    }

    public void setClipRect(Rect r10) {
        this.f11629a.o(r10);
    }

    public void setDirection(int r10) {
        this.f11629a.p(r10);
    }

    public GL3ShaderViewProgressBlur(Context r10, AttributeSet r11) {
        super(r10, r11);
        init();
    }
}
