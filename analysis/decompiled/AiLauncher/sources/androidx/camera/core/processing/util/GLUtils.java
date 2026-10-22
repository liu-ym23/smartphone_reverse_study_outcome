package androidx.camera.core.processing.util;

import B0.h;
import D.C0761b0;
import U.B;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import io.ktor.sse.ServerSentEventKt;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class GLUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f11667a = {12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f11668b = {12445, 13632, 12344};

    /* renamed from: c, reason: collision with root package name */
    public static final String f11669c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f11670d;

    /* renamed from: e, reason: collision with root package name */
    public static final B f11671e;

    /* renamed from: f, reason: collision with root package name */
    public static final B f11672f;

    /* renamed from: g, reason: collision with root package name */
    public static final B f11673g;

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f11674h;

    /* renamed from: i, reason: collision with root package name */
    public static final FloatBuffer f11675i;

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f11676j;

    /* renamed from: k, reason: collision with root package name */
    public static final FloatBuffer f11677k;

    /* renamed from: l, reason: collision with root package name */
    public static final W.f f11678l;

    public enum InputFormat {
        UNKNOWN,
        DEFAULT,
        YUV
    }

    public class a implements B {
        @Override // U.B
        public String a(String str, String str2) {
            return String.format(Locale.US, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nuniform float uAlphaScale;\nvoid main() {\n    vec4 src = texture2D(%s, %s);\n    gl_FragColor = vec4(src.rgb, src.a * uAlphaScale);\n}\n", str2, str, str, str2);
        }
    }

    public class b implements B {
        @Override // U.B
        public String a(String str, String str2) {
            return String.format(Locale.US, "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nuniform samplerExternalOES %s;\nuniform float uAlphaScale;\nin vec2 %s;\nout vec4 outColor;\n\nvoid main() {\n  vec4 src = texture(%s, %s);\n  outColor = vec4(src.rgb, src.a * uAlphaScale);\n}", str, str2, str, str2);
        }
    }

    public class c implements B {
        @Override // U.B
        public String a(String str, String str2) {
            return String.format(Locale.US, "#version 300 es\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nuniform float uAlphaScale;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorMat = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorMat * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  vec3 srcRgb = yuvToRgb(srcYuv);\n  outColor = vec4(srcRgb, uAlphaScale);\n}", str, str2, str, str2);
        }
    }

    public static class d extends e {
        public d() {
            super("uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n", "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n");
        }
    }

    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        public int f11679a;

        /* renamed from: b, reason: collision with root package name */
        public int f11680b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f11681c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f11682d = -1;

        /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public e(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.String r0 = "glAttachShader"
                r6.<init>()
                r1 = -1
                r6.f11680b = r1
                r6.f11681c = r1
                r6.f11682d = r1
                r2 = 35633(0x8b31, float:4.9932E-41)
                int r7 = androidx.camera.core.processing.util.GLUtils.y(r2, r7)     // Catch: java.lang.Throwable -> L6a
                r2 = 35632(0x8b30, float:4.9931E-41)
                int r8 = androidx.camera.core.processing.util.GLUtils.y(r2, r8)     // Catch: java.lang.Throwable -> L66
                int r2 = android.opengl.GLES20.glCreateProgram()     // Catch: java.lang.Throwable -> L63
                java.lang.String r3 = "glCreateProgram"
                androidx.camera.core.processing.util.GLUtils.g(r3)     // Catch: java.lang.Throwable -> L46
                android.opengl.GLES20.glAttachShader(r2, r7)     // Catch: java.lang.Throwable -> L46
                androidx.camera.core.processing.util.GLUtils.g(r0)     // Catch: java.lang.Throwable -> L46
                android.opengl.GLES20.glAttachShader(r2, r8)     // Catch: java.lang.Throwable -> L46
                androidx.camera.core.processing.util.GLUtils.g(r0)     // Catch: java.lang.Throwable -> L46
                android.opengl.GLES20.glLinkProgram(r2)     // Catch: java.lang.Throwable -> L46
                r0 = 1
                int[] r3 = new int[r0]     // Catch: java.lang.Throwable -> L46
                r4 = 35714(0x8b82, float:5.0046E-41)
                r5 = 0
                android.opengl.GLES20.glGetProgramiv(r2, r4, r3, r5)     // Catch: java.lang.Throwable -> L46
                r3 = r3[r5]     // Catch: java.lang.Throwable -> L46
                if (r3 != r0) goto L48
                r6.f11679a = r2     // Catch: java.lang.Throwable -> L46
                r6.c()
                return
            L46:
                r6 = move-exception
                goto L6e
            L48:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                r0.<init>()     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                java.lang.String r3 = "Could not link program: "
                r0.append(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                java.lang.String r3 = android.opengl.GLES20.glGetProgramInfoLog(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                r0.append(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                r6.<init>(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
                throw r6     // Catch: java.lang.Throwable -> L46 java.lang.Throwable -> L46
            L63:
                r6 = move-exception
                r2 = r1
                goto L6e
            L66:
                r6 = move-exception
                r8 = r1
            L68:
                r2 = r8
                goto L6e
            L6a:
                r6 = move-exception
                r7 = r1
                r8 = r7
                goto L68
            L6e:
                if (r7 == r1) goto L73
                android.opengl.GLES20.glDeleteShader(r7)
            L73:
                if (r8 == r1) goto L78
                android.opengl.GLES20.glDeleteShader(r8)
            L78:
                if (r2 == r1) goto L7d
                android.opengl.GLES20.glDeleteProgram(r2)
            L7d:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.util.GLUtils.e.<init>(java.lang.String, java.lang.String):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f11679a, "aPosition");
            this.f11682d = iGlGetAttribLocation;
            GLUtils.j(iGlGetAttribLocation, "aPosition");
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f11679a, "uTransMatrix");
            this.f11680b = iGlGetUniformLocation;
            GLUtils.j(iGlGetUniformLocation, "uTransMatrix");
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f11679a, "uAlphaScale");
            this.f11681c = iGlGetUniformLocation2;
            GLUtils.j(iGlGetUniformLocation2, "uAlphaScale");
        }

        public void b() {
            GLES20.glDeleteProgram(this.f11679a);
        }

        public void d(float f10) {
            GLES20.glUniform1f(this.f11681c, f10);
            GLUtils.g("glUniform1f");
        }

        public void e(float[] fArr) {
            GLES20.glUniformMatrix4fv(this.f11680b, 1, false, fArr, 0);
            GLUtils.g("glUniformMatrix4fv");
        }

        public void f() {
            GLES20.glUseProgram(this.f11679a);
            GLUtils.g("glUseProgram");
            GLES20.glEnableVertexAttribArray(this.f11682d);
            GLUtils.g("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.f11682d, 2, 5126, false, 0, (Buffer) GLUtils.f11675i);
            GLUtils.g("glVertexAttribPointer");
            e(GLUtils.l());
            d(1.0f);
        }
    }

    public static class f extends e {

        /* renamed from: e, reason: collision with root package name */
        public int f11683e;

        /* renamed from: f, reason: collision with root package name */
        public int f11684f;

        /* renamed from: g, reason: collision with root package name */
        public int f11685g;

        public f(D.B b10, InputFormat inputFormat) {
            this(b10, g(b10, inputFormat));
        }

        public static B g(D.B b10, InputFormat inputFormat) {
            if (!b10.d()) {
                return GLUtils.f11671e;
            }
            h.b(inputFormat != InputFormat.UNKNOWN, "No default sampler shader available for" + inputFormat);
            return inputFormat == InputFormat.YUV ? GLUtils.f11673g : GLUtils.f11672f;
        }

        public final void c() {
            c();
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.f11679a, "sTexture");
            this.f11683e = iGlGetUniformLocation;
            GLUtils.j(iGlGetUniformLocation, "sTexture");
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f11679a, "aTextureCoord");
            this.f11685g = iGlGetAttribLocation;
            GLUtils.j(iGlGetAttribLocation, "aTextureCoord");
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.f11679a, "uTexMatrix");
            this.f11684f = iGlGetUniformLocation2;
            GLUtils.j(iGlGetUniformLocation2, "uTexMatrix");
        }

        @Override // androidx.camera.core.processing.util.GLUtils.e
        public void f() {
            super.f();
            GLES20.glUniform1i(this.f11683e, 0);
            GLES20.glEnableVertexAttribArray(this.f11685g);
            GLUtils.g("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.f11685g, 2, 5126, false, 0, (Buffer) GLUtils.f11677k);
            GLUtils.g("glVertexAttribPointer");
        }

        public void h(float[] fArr) {
            GLES20.glUniformMatrix4fv(this.f11684f, 1, false, fArr, 0);
            GLUtils.g("glUniformMatrix4fv");
        }

        public f(D.B b10, B b11) {
            super(b10.d() ? GLUtils.f11670d : GLUtils.f11669c, GLUtils.v(b11));
            this.f11683e = -1;
            this.f11684f = -1;
            this.f11685g = -1;
            c();
        }
    }

    static {
        Locale locale = Locale.US;
        f11669c = String.format(locale, "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        f11670d = String.format(locale, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", "vTextureCoord", "vTextureCoord");
        f11671e = new a();
        f11672f = new b();
        f11673g = new c();
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f11674h = fArr;
        f11675i = m(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f11676j = fArr2;
        f11677k = m(fArr2);
        f11678l = W.f.d(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static void e(String str) {
        try {
            f(str);
        } catch (IllegalStateException e10) {
            C0761b0.d("GLUtils", e10.toString(), e10);
        }
    }

    public static void f(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public static void g(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(iGlGetError));
    }

    public static void h(Thread thread) {
        h.i(thread == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    public static void i(AtomicBoolean atomicBoolean, boolean z10) {
        h.i(z10 == atomicBoolean.get(), z10 ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    public static void j(int i10, String str) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalStateException("Unable to locate '" + str + "' in program");
    }

    public static int[] k(String str, D.B b10) {
        int[] iArr = f11667a;
        if (b10.b() == 3) {
            if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
                return f11668b;
            }
            C0761b0.o("GLUtils", "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        }
        return iArr;
    }

    public static float[] l() {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        return fArr;
    }

    public static FloatBuffer m(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    public static EGLSurface n(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i10, int i11) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i10, 12374, i11, 12344}, 0);
        f("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface != null) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static Map<InputFormat, e> o(D.B b10, Map<InputFormat, B> map) {
        Object fVar;
        InputFormat inputFormat;
        HashMap map2 = new HashMap();
        InputFormat[] inputFormatArrValues = InputFormat.values();
        int length = inputFormatArrValues.length;
        for (int i10 = 0; i10 < length; i10++) {
            InputFormat inputFormat2 = inputFormatArrValues[i10];
            B b11 = map.get(inputFormat2);
            if (b11 != null) {
                fVar = new f(b10, b11);
            } else if (inputFormat2 == InputFormat.YUV || inputFormat2 == (inputFormat = InputFormat.DEFAULT)) {
                fVar = new f(b10, inputFormat2);
            } else {
                h.i(inputFormat2 == InputFormat.UNKNOWN, "Unhandled input format: " + inputFormat2);
                if (b10.d()) {
                    fVar = new d();
                } else {
                    B b12 = map.get(inputFormat);
                    fVar = b12 != null ? new f(b10, b12) : new f(b10, inputFormat);
                }
            }
            Log.d("GLUtils", "Shader program for input format " + inputFormat2 + " created: " + fVar);
            map2.put(inputFormat2, fVar);
        }
        return map2;
    }

    public static int p() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g("glGenTextures");
        int i10 = iArr[0];
        GLES20.glBindTexture(36197, i10);
        g("glBindTexture " + i10);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        g("glTexParameter");
        return i10;
    }

    public static EGLSurface q(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        f("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static void r(int i10) {
        GLES20.glDeleteFramebuffers(1, new int[]{i10}, 0);
        g("glDeleteFramebuffers");
    }

    public static void s(int i10) {
        GLES20.glDeleteTextures(1, new int[]{i10}, 0);
        g("glDeleteTextures");
    }

    public static int t() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        g("glGenFramebuffers");
        return iArr[0];
    }

    public static int u() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g("glGenTextures");
        return iArr[0];
    }

    public static String v(B b10) {
        try {
            String strA = b10.a("sTexture", "vTextureCoord");
            if (strA != null && strA.contains("vTextureCoord") && strA.contains("sTexture")) {
                return strA;
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                throw th;
            }
            throw new IllegalArgumentException("Unable retrieve fragment shader source", th);
        }
    }

    public static String w() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return "0.0";
        }
        return ((String) h.f(matcher.group(1))) + "." + ((String) h.f(matcher.group(2)));
    }

    public static Size x(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        return new Size(z(eGLDisplay, eGLSurface, 12375), z(eGLDisplay, eGLSurface, 12374));
    }

    public static int y(int i10, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i10);
        g("glCreateShader type=" + i10);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        C0761b0.o("GLUtils", "Could not compile shader: " + str);
        String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i10 + ServerSentEventKt.COLON + strGlGetShaderInfoLog);
    }

    public static int z(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i10) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i10, iArr, 0);
        return iArr[0];
    }
}
