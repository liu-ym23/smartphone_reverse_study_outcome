package v7;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010(R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010.R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u00105R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00101R\u0016\u0010@\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u00101R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0014\u0010H\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010\u001bR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lv7/h;", "", "", "shaderSource", "LB7/a;", "binder", "Lv7/i;", "target", "<init>", "(Ljava/lang/String;LB7/a;Lv7/i;)V", "LY8/t;", "k", "()V", "", "elapsedMs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(J)V", "m", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "f", "()I", "type", "source", "e", "(ILjava/lang/String;)I", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LB7/a;", "c", "Lv7/i;", "Landroid/os/HandlerThread;", Const.INTENT_KEY_UMID, "Landroid/os/HandlerThread;", "renderThread", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroid/opengl/EGLDisplay;", "Landroid/opengl/EGLDisplay;", "eglDisplay", "Landroid/opengl/EGLContext;", "Landroid/opengl/EGLContext;", "eglContext", "Landroid/opengl/EGLSurface;", "Landroid/opengl/EGLSurface;", "eglSurface", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "I", "program", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Z", "running", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "framePending", "posLoc", "n", "timeLoc", "o", "resLoc", "", "p", "F", "surfaceWidth", "q", "surfaceHeight", "r", "vertexShaderSource", "Ljava/nio/FloatBuffer;", "s", "Ljava/nio/FloatBuffer;", "quadVertices", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String shaderSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final B7.a binder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final i target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final HandlerThread renderThread;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public EGLDisplay eglDisplay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public EGLContext eglContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public EGLSurface eglSurface;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int program;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean running;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public boolean initialized;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean framePending;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public int posLoc;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public int timeLoc;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public int resLoc;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public float surfaceWidth;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public float surfaceHeight;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final String vertexShaderSource;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final FloatBuffer quadVertices;

    public h(String shaderSource, B7.a binder, i target) {
        kotlin.jvm.internal.p.i(shaderSource, "shaderSource");
        kotlin.jvm.internal.p.i(binder, "binder");
        kotlin.jvm.internal.p.i(target, "target");
        this.shaderSource = shaderSource;
        this.binder = binder;
        this.target = target;
        HandlerThread handlerThread = new HandlerThread("GlesRenderer");
        handlerThread.start();
        this.renderThread = handlerThread;
        this.handler = new Handler(handlerThread.getLooper());
        EGLDisplay EGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
        kotlin.jvm.internal.p.h(EGL_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = EGL_NO_DISPLAY;
        EGLContext EGL_NO_CONTEXT = EGL14.EGL_NO_CONTEXT;
        kotlin.jvm.internal.p.h(EGL_NO_CONTEXT, "EGL_NO_CONTEXT");
        this.eglContext = EGL_NO_CONTEXT;
        EGLSurface EGL_NO_SURFACE = EGL14.EGL_NO_SURFACE;
        kotlin.jvm.internal.p.h(EGL_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = EGL_NO_SURFACE;
        this.framePending = new AtomicBoolean(false);
        this.posLoc = -1;
        this.timeLoc = -1;
        this.resLoc = -1;
        this.vertexShaderSource = "#version 300 es\nin vec4 aPosition;\nvoid main() {\n    gl_Position = aPosition;\n}";
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        kotlin.jvm.internal.p.h(floatBufferAsFloatBuffer, "apply(...)");
        this.quadVertices = floatBufferAsFloatBuffer;
    }

    public static final void i(final h hVar, long j10) {
        hVar.framePending.set(false);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(hVar.program);
        int i10 = hVar.timeLoc;
        if (i10 >= 0) {
            GLES20.glUniform1f(i10, j10 / 1000.0f);
        }
        int i11 = hVar.resLoc;
        if (i11 >= 0) {
            GLES20.glUniform2f(i11, hVar.surfaceWidth, hVar.surfaceHeight);
        }
        hVar.binder.e(j10);
        hVar.binder.b(new p9.q() { // from class: v7.g
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return h.j(this.f42736a, (String) obj, (float[]) obj2, ((Integer) obj3).intValue());
            }
        });
        GLES20.glDrawArrays(5, 0, 4);
        EGL14.eglSwapBuffers(hVar.eglDisplay, hVar.eglSurface);
    }

    public static final Y8.t j(h hVar, String name, float[] values, int i10) {
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(values, "values");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(hVar.program, name);
        if (iGlGetUniformLocation >= 0) {
            if (i10 == 1) {
                GLES20.glUniform1f(iGlGetUniformLocation, values[0]);
            } else if (i10 == 2) {
                GLES20.glUniform2f(iGlGetUniformLocation, values[0], values[1]);
            } else if (i10 == 3) {
                GLES20.glUniform3f(iGlGetUniformLocation, values[0], values[1], values[2]);
            } else if (i10 == 4) {
                GLES20.glUniform4f(iGlGetUniformLocation, values[0], values[1], values[2], values[3]);
            }
        }
        return Y8.t.f7040a;
    }

    public static final void l(h hVar) {
        hVar.g();
    }

    public static final void n(h hVar) {
        int i10 = hVar.program;
        if (i10 != 0) {
            GLES20.glDeleteProgram(i10);
        }
        if (!kotlin.jvm.internal.p.d(hVar.eglSurface, EGL14.EGL_NO_SURFACE)) {
            EGL14.eglDestroySurface(hVar.eglDisplay, hVar.eglSurface);
        }
        if (!kotlin.jvm.internal.p.d(hVar.eglContext, EGL14.EGL_NO_CONTEXT)) {
            EGL14.eglDestroyContext(hVar.eglDisplay, hVar.eglContext);
        }
        if (!kotlin.jvm.internal.p.d(hVar.eglDisplay, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglTerminate(hVar.eglDisplay);
        }
        hVar.renderThread.quitSafely();
    }

    public final int e(int type, String source) {
        int iGlCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(iGlCreateShader, source);
        GLES20.glCompileShader(iGlCreateShader);
        return iGlCreateShader;
    }

    public final int f() {
        int iE = e(35633, this.vertexShaderSource);
        int iE2 = e(35632, this.shaderSource);
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iE);
        GLES20.glAttachShader(iGlCreateProgram, iE2);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glDeleteShader(iE);
        GLES20.glDeleteShader(iE2);
        return iGlCreateProgram;
    }

    public final void g() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.eglDisplay = eGLDisplayEglGetDisplay;
        int[] iArr = new int[2];
        EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(this.eglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 64, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLConfig eGLConfig = eGLConfigArr[0];
        kotlin.jvm.internal.p.f(eGLConfig);
        this.eglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
        EGLDisplay eGLDisplay2 = this.eglDisplay;
        EGLConfig eGLConfig2 = eGLConfigArr[0];
        kotlin.jvm.internal.p.f(eGLConfig2);
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay2, eGLConfig2, this.target.getSurface(), new int[]{12344}, 0);
        this.eglSurface = eGLSurfaceEglCreateWindowSurface;
        EGL14.eglMakeCurrent(this.eglDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.eglContext);
        int iF = f();
        this.program = iF;
        this.posLoc = GLES20.glGetAttribLocation(iF, "aPosition");
        this.timeLoc = GLES20.glGetUniformLocation(this.program, "iTime");
        this.resLoc = GLES20.glGetUniformLocation(this.program, "iResolution");
        this.surfaceWidth = this.target.getBufferWidth();
        this.surfaceHeight = this.target.getBufferHeight();
        GLES20.glEnableVertexAttribArray(this.posLoc);
        GLES20.glVertexAttribPointer(this.posLoc, 2, 5126, false, 0, (Buffer) this.quadVertices);
        this.initialized = true;
    }

    public final void h(final long elapsedMs) {
        if (this.running && this.initialized && this.framePending.compareAndSet(false, true)) {
            this.handler.post(new Runnable() { // from class: v7.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.i(this.f42734a, elapsedMs);
                }
            });
        }
    }

    public final void k() {
        this.running = true;
        this.handler.post(new Runnable() { // from class: v7.d
            @Override // java.lang.Runnable
            public final void run() {
                h.l(this.f42732a);
            }
        });
    }

    public final void m() {
        this.running = false;
        this.handler.post(new Runnable() { // from class: v7.e
            @Override // java.lang.Runnable
            public final void run() {
                h.n(this.f42733a);
            }
        });
    }
}
