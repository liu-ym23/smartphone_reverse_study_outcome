package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.platform.comapi.util.EglConfigUtils;
import com.baidu.platform.gl.GLThreadShareLock;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f32926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View.OnLayoutChangeListener f32928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<GLTextureView> f32929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f32930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SurfaceRenderer f32931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f32932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GLSurfaceView.EGLConfigChooser f32933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private GLSurfaceView.EGLContextFactory f32934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private GLSurfaceView.EGLWindowSurfaceFactory f32935j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private GLSurfaceView.GLWrapper f32936k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32937l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32938m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f32939n;

    public class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GLTextureView f32940a;

        public a(GLTextureView r100) {
            this.f32940a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            GLTextureView r109 = this.f32940a;
            r109.onSurfaceTextureSizeChanged(r109.getSurfaceTexture(), r103 - r101, r104 - r102);
        }
    }

    public abstract class b implements GLSurfaceView.EGLConfigChooser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f32941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GLTextureView f32942b;

        public abstract EGLConfig a(EGL10 r100, EGLDisplay r101, EGLConfig[] r102);

        private int[] a(int[] r100) {
            if (GLTextureView.b(this.f32942b) != 2) goto L5;
        L7:
            int r101 = r100.length;
            int[] r102 = new int[r101 + 2];
            int r103 = r101 - 1;
            System.arraycopy(r100, 0, r102, 0, r103);
            r102[r103] = 12352;
            if (GLTextureView.b(this.f32942b) != 2) goto L10;
            r102[r101] = 4;
        L11:
            r102[r101 + 1] = 12344;
            return r102;
        L10:
            r102[r101] = 64;
            goto L11
        L5:
            if (GLTextureView.b(this.f32942b) == 3) goto L7;
            return r100;
        }

        public b(GLTextureView r100, int[] r101) {
            this.f32942b = r100;
            this.f32941a = a(r101);
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 r100, EGLDisplay r110) {
            int[] r101 = new int[1];
            if (r100.eglChooseConfig(r110, this.f32941a, null, 0, r101) == false) goto L18;
            int r102 = r101[0];
            if (r102 <= 0) goto L16;
            EGLConfig[] r103 = new EGLConfig[r102];
            if (r100.eglChooseConfig(r110, this.f32941a, r103, r102, r101) == false) goto L14;
            EGLConfig r104 = a(r100, r110, r103);
            if (r104 == null) goto L12;
            return r104;
        L12:
            throw new IllegalArgumentException("No config chosen");
        L14:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L16:
            throw new IllegalArgumentException("No configs match configSpec");
        L18:
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int[] f32943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected int f32944d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected int f32945e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f32946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected int f32947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int f32948h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected int f32949i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected int f32950j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ GLTextureView f32951k;

        @Override // com.baidu.platform.comapi.map.GLTextureView.b
        public EGLConfig a(EGL10 r110, EGLDisplay r111, EGLConfig[] r112) {
            int r100 = r112.length;
            EGLConfig r101 = null;
            int r113 = 0;
        L3:
            if (r113 >= r100) goto L22;
            EGLConfig r114 = r112[r113];
            int r115 = a(r110, r111, r114, 12325, 0);
            int r102 = a(r110, r111, r114, 12326, 0);
            if (r115 < this.f32948h) goto L21;
            if (r102 < this.f32949i) goto L21;
            int r116 = a(r110, r111, r114, 12324, 0);
            int r117 = a(r110, r111, r114, 12323, 0);
            int r118 = a(r110, r111, r114, 12322, 0);
            int r103 = a(r110, r111, r114, 12321, 0);
            if (r116 != this.f32944d) goto L21;
            if (r117 != this.f32945e) goto L21;
            if (r118 != this.f32946f) goto L21;
            if (r103 != this.f32947g) goto L21;
            if (r101 != null) goto L19;
            r101 = r114;
        L19:
            if (a(r110, r111, r114, 12337, 0) != this.f32950j) goto L21;
            return r114;
        L21:
            r113 = r113 + 1;
            goto L3
        L22:
            return r101;
        }

        private int a(EGL10 r100, EGLDisplay r101, EGLConfig r102, int r103, int r104) {
            if (r100.eglGetConfigAttrib(r101, r102, r103, this.f32943c) == true) goto L5;
            return r104;
        L5:
            return this.f32943c[0];
        }

        public c(GLTextureView r100, int r101, int r102, int r103, int r104, int r110, int r111) {
            this.f32951k = r100;
            super(r100, new int[]{12324, r101, 12323, r102, 12322, r103, 12321, r104, 12325, r110, 12326, r111, 12344});
            this.f32943c = new int[1];
            this.f32944d = r101;
            this.f32945e = r102;
            this.f32946f = r103;
            this.f32947g = r104;
            this.f32948h = r110;
            this.f32949i = r111;
            this.f32950j = 1;
        }

        public c(GLTextureView r100, int r101, int r102, int r103, int r104, int r110, int r111, int r112) {
            this.f32951k = r100;
            super(r100, new int[]{12324, r101, 12323, r102, 12322, r103, 12321, r104, 12325, r110, 12326, r111, 12338, 1, 12337, r112, 12344});
            this.f32943c = new int[1];
            this.f32944d = r101;
            this.f32945e = r102;
            this.f32946f = r103;
            this.f32947g = r104;
            this.f32948h = r110;
            this.f32949i = r111;
            this.f32950j = r112;
        }
    }

    public class d implements GLSurfaceView.EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f32952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ GLTextureView f32953b;

        private d(GLTextureView r100) {
            this.f32953b = r100;
            this.f32952a = 12440;
        }

        public /* synthetic */ d(GLTextureView r100, a r101) {
            this(r100);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            int[] r103 = {this.f32952a, GLTextureView.b(this.f32953b), 12344};
            EGLContext r104 = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.b(this.f32953b) != 0) goto L7;
            r103 = null;
        L7:
            return r100.eglCreateContext(r101, r102, r104, r103);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r100.eglDestroyContext(r101, r102) == true) goto L6;
            f.b("eglDestroyContex", r100.eglGetError());
            return;
        }
    }

    public static class e implements GLSurfaceView.EGLWindowSurfaceFactory {
        private e() {
        }

        public /* synthetic */ e(a r100) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 r100, EGLDisplay r101, EGLSurface r102) {
            r100.eglDestroySurface(r101, r102);
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 r100, EGLDisplay r101, EGLConfig r102, Object r103) {
            return r100.eglCreateWindowSurface(r101, r102, r103, null);
        L8:
            return null;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<GLTextureView> f32954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        EGL10 f32955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        EGLDisplay f32956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        EGLSurface f32957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        EGLConfig f32958e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        EGLContext f32959f;

        public static void a(String r100, String r101, int r102) {
        }

        private void d() {
            EGLSurface r100 = this.f32957d;
            if (r100 == null) goto L11;
            EGLSurface r101 = EGL10.EGL_NO_SURFACE;
            if (r100 == r101) goto L12;
            this.f32955b.eglMakeCurrent(this.f32956c, r101, r101, EGL10.EGL_NO_CONTEXT);
            GLTextureView r102 = this.f32954a.get();
            if (r102 == null) goto L9;
            GLTextureView.e(r102).destroySurface(this.f32955b, this.f32956c, this.f32957d);
        L9:
            this.f32957d = null;
            return;
        L12:
            return;
        }

        public GL a() {
            GL r100 = this.f32959f.getGL();
            GLTextureView r101 = this.f32954a.get();
            if (r101 != null) goto L5;
            return r100;
        L5:
            if (GLTextureView.f(r101) == null) goto L8;
            r100 = GLTextureView.f(r101).wrap(r100);
        L8:
            if ((GLTextureView.g(r101) & 3) == 0) goto L20;
            int r102 = 1;
            if ((GLTextureView.g(r101) & 1) != 0) goto L14;
            r102 = 0;
        L14:
            if ((GLTextureView.g(r101) & 2) == 0) goto L16;
            i r103 = new i();
        L18:
            return GLDebugHelper.wrap(r100, r102, r103);
        L16:
            r103 = null;
            goto L18
        L20:
            return r100;
        }

        public boolean b() {
            Thread.currentThread().getId();
            if (this.f32955b == null) goto L30;
            if (this.f32956c == null) goto L28;
            if (this.f32958e == null) goto L26;
            d();
            GLTextureView r100 = this.f32954a.get();
            if (r100 == null) goto L11;
            this.f32957d = GLTextureView.e(r100).createWindowSurface(this.f32955b, this.f32956c, this.f32958e, r100.getSurfaceTexture());
        L12:
            EGLSurface r101 = this.f32957d;
            if (r101 != null) goto L15;
        L23:
            this.f32955b.eglGetError();
            return false;
        L15:
            if (r101 == EGL10.EGL_NO_SURFACE) goto L23;
            if (this.f32955b.eglMakeCurrent(this.f32956c, r101, r101, this.f32959f) == true) goto L21;
            a("EGLHelper", "eglMakeCurrent", this.f32955b.eglGetError());
            return false;
        L21:
            return true;
        L11:
            this.f32957d = null;
            goto L12
        L26:
            throw new RuntimeException("mEglConfig not initialized");
        L28:
            throw new RuntimeException("eglDisplay not initialized");
        L30:
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            Thread.currentThread().getId();
            d();
        }

        public void e() {
            Thread.currentThread().getId();
            if (this.f32959f == null) goto L8;
            GLTextureView r100 = this.f32954a.get();
            if (r100 == null) goto L7;
            GLTextureView.d(r100).destroyContext(this.f32955b, this.f32956c, this.f32959f);
        L7:
            this.f32959f = null;
        L8:
            EGLDisplay r101 = this.f32956c;
            if (r101 == null) goto L12;
            this.f32955b.eglTerminate(r101);
            this.f32956c = null;
            return;
        }

        public void f() {
            Thread.currentThread().getId();
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.f32955b = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f32956c = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L20;
            EGL10 r102 = this.f32955b;
            if (r102.eglInitialize(r101, new int[2]) == false) goto L18;
            GLTextureView r103 = this.f32954a.get();
            if (r103 != null) goto L9;
            this.f32958e = null;
            this.f32959f = null;
        L10:
            EGLContext r104 = this.f32959f;
            if (r104 != null) goto L13;
        L14:
            this.f32959f = null;
            a("createContext");
        L15:
            Objects.toString(this.f32959f);
            Thread.currentThread().getId();
            this.f32957d = null;
            return;
        L13:
            if (r104 != EGL10.EGL_NO_CONTEXT) goto L15;
        L9:
            this.f32958e = GLTextureView.c(r103).chooseConfig(this.f32955b, this.f32956c);
            this.f32959f = GLTextureView.d(r103).createContext(this.f32955b, this.f32956c, this.f32958e);
            goto L10
        L18:
            throw new RuntimeException("eglInitialize failed");
        L20:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int g() {
            if (this.f32955b.eglSwapBuffers(this.f32956c, this.f32957d) == false) goto L5;
            return 12288;
        L5:
            return this.f32955b.eglGetError();
        }

        public f(WeakReference<GLTextureView> r100) {
            this.f32954a = r100;
        }

        private void a(String r100) {
            b(r100, this.f32955b.eglGetError());
        }

        public static String a(String r100, int r101) {
            return r100 + " EGL failed code: " + r101;
        }

        public static void b(String r100, int r101) {
            throw new RuntimeException(a(r100, r101));
        }
    }

    public static class g extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f32960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f32961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f32962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f32963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f32964e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f32965f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f32966g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f32967h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f32968i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f32969j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f32970k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f32971l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f32972m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f32973n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f32974o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private ArrayList<Runnable> f32975p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f32976q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private f f32977r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private WeakReference<GLTextureView> f32978s;

        public void h() {
            this.f32969j = true;
            GLThreadShareLock.LOCK.notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_GLTextureView$g_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void c() throws InterruptedException {
            g r100 = this;
            r100.f32977r = new f(r100.f32978s);
            r100.f32967h = false;
            r100.f32968i = false;
            boolean r101 = false;
            GL10 r102 = null;
            boolean r103 = false;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
            int r107 = 0;
            int r110 = 0;
            boolean r111 = false;
            boolean r112 = false;
            boolean r113 = false;
        L3:
            Runnable r114 = null;
        L175:
            Object r115 = GLThreadShareLock.LOCK;     // Catch: Throwable -> L161
            monitor-enter(r115);     // Catch: Throwable -> L161
        L174:
        L158:
            th = move-exception;
            throw th;     // Catch: Throwable -> L161
        L7:
            if (r100.f32960a == true) goto L8;
            if (r100.f32975p.isEmpty() == false) goto L19;
            boolean r108 = r100.f32963d;     // Catch: Throwable -> L158
            boolean r109 = r100.f32962c;     // Catch: Throwable -> L158
            if (r108 == r109) goto L23;
            r100.f32963d = r109;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
            getId();     // Catch: Throwable -> L158
        L25:
            if (r100.f32969j == false) goto L27;
            getId();     // Catch: Throwable -> L158
            k();     // Catch: Throwable -> L158
            j();     // Catch: Throwable -> L158
            r100.f32969j = false;     // Catch: Throwable -> L158
            r113 = true;
        L27:
            if (r101 == false) goto L29;
            k();     // Catch: Throwable -> L158
            j();     // Catch: Throwable -> L158
            r101 = false;
        L29:
            if (r109 == true) goto L31;
        L33:
            if (r109 == true) goto L35;
        L46:
            if (r109 == false) goto L51;
            if (GLTextureView.a().c() == false) goto L51;
            r100.f32977r.e();     // Catch: Throwable -> L158
            getId();     // Catch: Throwable -> L158
        L51:
            if (r100.f32964e == true) goto L59;
            if (r100.f32966g == true) goto L59;
            getId();     // Catch: Throwable -> L158
            if (r100.f32968i == false) goto L57;
            k();     // Catch: Throwable -> L158
        L57:
            r100.f32966g = true;     // Catch: Throwable -> L158
            r100.f32965f = false;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
        L59:
            if (r100.f32964e == true) goto L61;
        L63:
            if (r112 == false) goto L66;
            getId();     // Catch: Throwable -> L158
            r100.f32974o = true;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
            r111 = false;
            r112 = false;
        L66:
            if (f() == false) goto L157;
            if (r100.f32967h == true) goto L80;
            if (r113 == false) goto L72;
            r113 = false;
            goto L80
        L72:
            if (GLTextureView.a().c(r100) == false) goto L80;
            r100.f32977r.f();     // Catch: RuntimeException -> L76 Throwable -> L158
        L75:
            r100.f32967h = true;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
            r103 = true;
        L76:
            e = move-exception;
            GLTextureView.a().a(r100);     // Catch: Throwable -> L158
            throw e;     // Catch: Throwable -> L158
        L80:
            if (r100.f32967h == false) goto L85;
            if (r100.f32968i == true) goto L85;
            r100.f32968i = true;     // Catch: Throwable -> L158
            r104 = true;
            r105 = true;
            r106 = true;
        L85:
            if (r100.f32968i == false) goto L157;
            if (r100.f32976q == false) goto L89;
            int r116 = r100.f32970k;     // Catch: Throwable -> L158
            int r117 = r100.f32971l;     // Catch: Throwable -> L158
            getId();     // Catch: Throwable -> L158
            r100.f32976q = false;     // Catch: Throwable -> L158
            r107 = r116;
            r110 = r117;
            boolean r118 = false;
            r104 = true;
            r106 = true;
            r111 = true;
        L90:
            r100.f32973n = r118;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
        L91:
            monitor-exit(r115);     // Catch: Throwable -> L158
            if (r114 != null) goto L93;
            if (r104 == false) goto L107;
            if (r100.f32977r.b() == false) goto L97;
            r104 = false;
            goto L107
        L97:
            Object r119 = GLThreadShareLock.LOCK;     // Catch: Throwable -> L161
            monitor-enter(r119);     // Catch: Throwable -> L161
            r100.f32965f = true;     // Catch: Throwable -> L103
            r119.notifyAll();     // Catch: Throwable -> L103
            monitor-exit(r119);     // Catch: Throwable -> L103
        L103:
            th = move-exception;
            throw th;     // Catch: Throwable -> L161
        L107:
            if (r105 == false) goto L109;
            r102 = (GL10) r100.f32977r.a();     // Catch: Throwable -> L161
            GLTextureView.a().a(r102);     // Catch: Throwable -> L161
            r105 = false;
        L109:
            if (r103 == false) goto L115;
            GLTextureView r120 = r100.f32978s.get();     // Catch: Throwable -> L161
            if (r120 == null) goto L114;
            GLTextureView.a(r120).onSurfaceCreated(null, r120.getWidth(), r120.getHeight(), 0);     // Catch: Throwable -> L161
        L114:
            r103 = false;
        L116:
            if (r106 == false) goto L121;
            GLTextureView r121 = r100.f32978s.get();     // Catch: Throwable -> L161
            if (r121 == null) goto L120;
            GLTextureView.a(r121).onSurfaceChanged(r107, r110);     // Catch: Throwable -> L161
        L120:
            r106 = false;
        L121:
            long r122 = System.currentTimeMillis();     // Catch: Throwable -> L161
            GLTextureView r123 = r100.f32978s.get();     // Catch: Throwable -> L161
            if (r123 == null) goto L124;
            GLTextureView.a(r123).onDrawFrame(r102);     // Catch: Throwable -> L161
            int r124 = r123.getFPS();     // Catch: Throwable -> L161
        L125:
            int r125 = r100.f32977r.g();     // Catch: Throwable -> L161
            if (r125 == 12288) goto L140;
            if (r125 == 12302) goto L138;
            f.a("GLThread", "eglSwapBuffers", r125);     // Catch: Throwable -> L161
            Object r126 = GLThreadShareLock.LOCK;     // Catch: Throwable -> L161
            monitor-enter(r126);     // Catch: Throwable -> L161
            r100.f32965f = true;     // Catch: Throwable -> L135
            r126.notifyAll();     // Catch: Throwable -> L135
            monitor-exit(r126);     // Catch: Throwable -> L135
        L135:
            th = move-exception;
            throw th;     // Catch: Throwable -> L161
        L138:
            getId();     // Catch: Throwable -> L161
            r101 = true;
        L140:
            if (r111 == false) goto L142;
            r112 = true;
        L142:
            long r127 = System.currentTimeMillis();     // Catch: Throwable -> L161
            if (r124 >= 60) goto L155;
            if (r124 <= 0) goto L155;
            long r128 = ((long) (1000 / r124)) - (r127 - r122);     // Catch: Throwable -> L161
            if (r128 <= 1) goto L155;
            Object r129 = GLThreadShareLock.LOCK;     // Catch: Throwable -> L161
            monitor-enter(r129);     // Catch: Throwable -> L161
            r129.wait(r128);     // Catch: Throwable -> L152
            monitor-exit(r129);     // Catch: Throwable -> L152
        L152:
            th = move-exception;
            throw th;     // Catch: Throwable -> L161
        L155:
            r100 = this;
            r101 = r101;
            goto L175
        L124:
            r124 = 60;
            goto L125
        L115:
            r101 = r101;
            goto L116
        L93:
            r114.run();     // Catch: Throwable -> L161
            goto L3
        L89:
            r118 = false;
        L157:
            GLThreadShareLock.LOCK.wait();     // Catch: Throwable -> L158
            r100 = this;
            goto L174
        L61:
            if (r100.f32966g == false) goto L63;
            getId();     // Catch: Throwable -> L158
            r100.f32966g = false;     // Catch: Throwable -> L158
            GLThreadShareLock.LOCK.notifyAll();     // Catch: Throwable -> L158
            goto L63
        L35:
            if (r100.f32967h == false) goto L46;
            GLTextureView r130 = r100.f32978s.get();     // Catch: Throwable -> L158
            if (r130 != null) goto L39;
        L41:
            boolean r131 = false;
        L42:
            if (r131 == true) goto L44;
        L45:
            j();     // Catch: Throwable -> L158
            getId();     // Catch: Throwable -> L158
            goto L46
        L44:
            if (GLTextureView.a().b() == false) goto L46;
        L39:
            if (GLTextureView.h(r130) == false) goto L41;
            r131 = true;
            goto L42
        L31:
            if (r100.f32968i == false) goto L33;
            getId();     // Catch: Throwable -> L158
            k();     // Catch: Throwable -> L158
            goto L33
        L23:
            r109 = false;
            goto L25
        L19:
            r114 = r100.f32975p.remove(0);     // Catch: Throwable -> L158
            goto L91
        L8:
            monitor-exit(r115);     // Catch: Throwable -> L158
            Object r132 = GLThreadShareLock.LOCK;
            monitor-enter(r132);
            k();     // Catch: Throwable -> L14
            j();     // Catch: Throwable -> L14
            monitor-exit(r132);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L161:
            th = move-exception;
            monitor-enter(GLThreadShareLock.LOCK);
            k();     // Catch: Throwable -> L167
            j();     // Catch: Throwable -> L167
            throw th;
        L167:
            th = move-exception;
            throw th;
        }

        private boolean f() {
            if (this.f32963d == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f32964e == false) goto L17;
            if (this.f32965f == true) goto L17;
            if (this.f32970k <= 0) goto L17;
            if (this.f32971l <= 0) goto L17;
            if (this.f32973n == false) goto L15;
            return true;
        L15:
            if (this.f32972m != 1) goto L17;
            return true;
        }

        private void j() {
            if (this.f32967h == false) goto L6;
            this.f32977r.e();
            this.f32967h = false;
            GLTextureView.a().a(this);
            return;
        }

        private void k() {
            if (this.f32968i == false) goto L6;
            this.f32968i = false;
            this.f32977r.c();
            return;
        }

        public boolean a() {
            if (this.f32967h == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f32968i == false) goto L9;
            if (f() == false) goto L9;
            return true;
        }

        public int b() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            int r101 = this.f32972m;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public void com_baidu_platform_comapi_map_GLTextureView$g__run$___twin___() {
            setName("GLThread " + getId());
            c();     // Catch: Throwable -> L5 InterruptedException -> L10
        L5:
            th = move-exception;
            GLTextureView.a().b(this);
            throw th;
        L8:
            GLTextureView.a().b(this);
        }

        public void d() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L14
            this.f32962c = true;     // Catch: Throwable -> L14
            r100.notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.f32961b == true) goto L12;
            if (this.f32963d == true) goto L12;
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void e() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L16
            this.f32962c = false;     // Catch: Throwable -> L16
            this.f32973n = true;     // Catch: Throwable -> L16
            this.f32974o = false;     // Catch: Throwable -> L16
            r100.notifyAll();     // Catch: Throwable -> L16
        L6:
            if (this.f32961b == true) goto L14;
            if (this.f32963d == false) goto L14;
            if (this.f32974o == true) goto L14;
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L13 Throwable -> L16
        L13:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L16
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void g() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            this.f32960a = true;     // Catch: Throwable -> L13
            r100.notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.f32961b == true) goto L11;
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public void i() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            this.f32973n = true;     // Catch: Throwable -> L8
            r100.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void l() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            this.f32964e = true;     // Catch: Throwable -> L15
            r100.notifyAll();     // Catch: Throwable -> L15
        L7:
            if (this.f32966g == false) goto L13;
            if (this.f32961b == true) goto L13;
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public void m() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            this.f32964e = false;     // Catch: Throwable -> L15
            r100.notifyAll();     // Catch: Throwable -> L15
        L7:
            if (this.f32966g == true) goto L13;
            if (this.f32961b == true) goto L13;
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public g(WeakReference<GLTextureView> r100) {
            this.f32975p = new ArrayList();
            this.f32976q = true;
            this.f32970k = 0;
            this.f32971l = 0;
            this.f32973n = true;
            this.f32972m = 1;
            this.f32978s = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_GLTextureView$g_com_larus_apm_impl_protector_RunnableLancet_run(g r100) {
            r100.com_baidu_platform_comapi_map_GLTextureView$g__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void a(int r100) {
            if (r100 < 0) goto L14;
            if (r100 > 1) goto L14;
            Object r101 = GLThreadShareLock.LOCK;
            monitor-enter(r101);
            this.f32972m = r100;     // Catch: Throwable -> L10
            r101.notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }

        public void a(Runnable r100) {
            if (r100 == null) goto L12;
            Object r101 = GLThreadShareLock.LOCK;
            monitor-enter(r101);
            this.f32975p.add(r100);     // Catch: Throwable -> L8
            r101.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }

        public void a(int r100, int r101) {
            Object r102 = GLThreadShareLock.LOCK;
            monitor-enter(r102);
            this.f32970k = r100;     // Catch: Throwable -> L19
            this.f32971l = r101;     // Catch: Throwable -> L19
            this.f32976q = true;     // Catch: Throwable -> L19
            this.f32973n = true;     // Catch: Throwable -> L19
            this.f32974o = false;     // Catch: Throwable -> L19
            r102.notifyAll();     // Catch: Throwable -> L19
        L6:
            if (this.f32961b == true) goto L17;
            if (this.f32963d == true) goto L17;
            if (this.f32974o == true) goto L17;
            if (a() == false) goto L17;
            getId();     // Catch: Throwable -> L19
            GLThreadShareLock.LOCK.wait();     // Catch: InterruptedException -> L16 Throwable -> L19
        L16:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r102);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ boolean a(g r100, boolean r101) {
            r100.f32961b = r101;
            return r101;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static String f32979a = "GLThreadManager";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Class f32980b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final Method f32981c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f32982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f32983e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f32984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f32985g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f32986h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private g f32987i;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        static {
            Class r100 = INVOKESTATIC_com_baidu_platform_comapi_map_GLTextureView$h_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L6
            f32980b = r100;     // Catch: Exception -> L6
            Method r101 = r100.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L6
            f32981c = r101;     // Catch: Exception -> L6
            r101.setAccessible(true);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException(e);
        }

        private void a() {
            if (this.f32982d == false) goto L13;
            return;
        L13:
            this.f32983e = ((Integer) f32981c.invoke(null, new Object[]{"ro.opengles.version", 0})).intValue();     // Catch: Exception -> L7
        L9:
            if (this.f32983e < 131072) goto L11;
            this.f32985g = true;
        L11:
            this.f32982d = true;
            return;
        L7:
            this.f32983e = 65536;
            goto L9
        }

        public boolean b() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            boolean r101 = this.f32986h;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean c() {
            Object r100 = GLThreadShareLock.LOCK;
            monitor-enter(r100);
            a();     // Catch: Throwable -> L7
            boolean r101 = !this.f32985g;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        private h() {
        }

        public /* synthetic */ h(a r100) {
            this();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_baidu_platform_comapi_map_GLTextureView$h_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public void a(GL10 r100) {
            Object r101 = GLThreadShareLock.LOCK;
            monitor-enter(r101);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.f32984f == true) goto L10;
            a();     // Catch: Throwable -> L12
            String r102 = r100.glGetString(7937);     // Catch: Throwable -> L12
            if (this.f32983e >= 131072) goto L9;
            this.f32985g = !r102.startsWith("Q3Dimension MSM7500 ");     // Catch: Throwable -> L12
            r101.notifyAll();     // Catch: Throwable -> L12
        L9:
            this.f32986h = !this.f32985g;     // Catch: Throwable -> L12
            this.f32984f = true;     // Catch: Throwable -> L12
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L12
        }

        public void b(g r100) {
            Object r101 = GLThreadShareLock.LOCK;
            monitor-enter(r101);
            g.a(r100, true);     // Catch: Throwable -> L11
            if (this.f32987i != r100) goto L8;
            this.f32987i = null;     // Catch: Throwable -> L11
        L8:
            r101.notifyAll();     // Catch: Throwable -> L11
            monitor-exit(r101);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean c(g r100) {
            g r101 = this.f32987i;
            if (r101 == r100) goto L14;
            if (r101 == null) goto L14;
            a();
            if (this.f32985g == false) goto L9;
            return true;
        L9:
            g r102 = this.f32987i;
            if (r102 == null) goto L16;
            r102.h();
            return false;
        L16:
            return false;
        L14:
            this.f32987i = r100;
            GLThreadShareLock.LOCK.notifyAll();
            return true;
        }

        public void a(g r100) {
            if (this.f32987i != r100) goto L5;
            this.f32987i = null;
        L5:
            GLThreadShareLock.LOCK.notifyAll();
        }
    }

    public static class i extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StringBuilder f32988a;

        private void a() {
            if (this.f32988a.length() <= 0) goto L6;
            StringBuilder r100 = this.f32988a;
            r100.delete(0, r100.length());
            return;
        }

        public i() {
            this.f32988a = new StringBuilder();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] r100, int r101, int r102) {
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            char r104 = r100[r101 + r103];
            if (r104 != '\n') goto L7;
            a();
        L8:
            r103 = r103 + 1;
            goto L3
        L7:
            this.f32988a.append(r104);
            goto L8
        }
    }

    public class j extends c {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ GLTextureView f32989l;

        public j(GLTextureView r100, boolean r110) {
            this.f32989l = r100;
            if (r110 == false) goto L5;
            int r101 = 16;
        L6:
            super(r100, 8, 8, 8, 0, r101, 0);
            return;
        L5:
            r101 = 0;
            goto L6
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    static {
        f32926a = new h(null);
    }

    private void b() {
        if (this.f32930e != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public void finalize() throws Throwable {
        g r100 = this.f32930e;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.g();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getRenderMode() {
        return this.f32930e.b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        g r100 = this.f32930e;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        this.f32932g = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        g r100 = this.f32930e;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public void onResume() {
        g r100 = this.f32930e;
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    public void requestRender() {
        g r100 = this.f32930e;
        if (r100 == null) goto L6;
        r100.i();
        return;
    }

    private void c() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.f32928c);
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f32932g == true) goto L5;
    L14:
        this.f32932g = false;
        return;
    L5:
        if (this.f32931f == null) goto L14;
        g r100 = this.f32930e;
        if (r100 == null) goto L9;
        int r101 = r100.b();
    L10:
        g r102 = new g(this.f32929d);
        this.f32930e = r102;
        if (r101 == 1) goto L13;
        r102.a(r101);
    L13:
        this.f32930e.start();
        goto L14
    L9:
        r101 = 1;
        goto L10
    }

    public static /* synthetic */ h a() {
        return f32926a;
    }

    public int getDebugFlags() {
        return this.f32937l;
    }

    public int getFPS() {
        return this.f32927b;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f32939n;
    }

    public GLTextureView(Context r100) {
        super(r100);
        this.f32927b = 60;
        this.f32928c = new a(this);
        this.f32929d = new WeakReference(this);
        c();
    }

    public static /* synthetic */ SurfaceRenderer a(GLTextureView r100) {
        return r100.f32931f;
    }

    public static /* synthetic */ int b(GLTextureView r100) {
        return r100.f32938m;
    }

    public static /* synthetic */ GLSurfaceView.EGLConfigChooser c(GLTextureView r100) {
        return r100.f32933h;
    }

    public static /* synthetic */ GLSurfaceView.EGLContextFactory d(GLTextureView r100) {
        return r100.f32934i;
    }

    public static /* synthetic */ GLSurfaceView.EGLWindowSurfaceFactory e(GLTextureView r100) {
        return r100.f32935j;
    }

    public static /* synthetic */ GLSurfaceView.GLWrapper f(GLTextureView r100) {
        return r100.f32936k;
    }

    public static /* synthetic */ int g(GLTextureView r100) {
        return r100.f32937l;
    }

    public static /* synthetic */ boolean h(GLTextureView r100) {
        return r100.f32939n;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        surfaceDestroyed(r100);
        return true;
    }

    public void queueEvent(Runnable r100) {
        g r101 = this.f32930e;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void setDebugFlags(int r100) {
        this.f32937l = r100;
    }

    public void setEGLConfigChooser(boolean r100) {
        setEGLConfigChooser(new j(this, r100));
    }

    public void setEGLContextClientVersion(int r100) {
        b();
        this.f32938m = r100;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory r100) {
        b();
        this.f32934i = r100;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory r100) {
        b();
        this.f32935j = r100;
    }

    public void setFPS(int r100) {
        this.f32927b = r100;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper r100) {
        this.f32936k = r100;
    }

    public void setPreserveEGLContextOnPause(boolean r100) {
        this.f32939n = r100;
    }

    public void setRenderMode(int r100) {
        this.f32930e.a(r100);
    }

    public void setRenderer(SurfaceRenderer r110) {
        b();
        if (this.f32933h == null) goto L20;
    L11:
        a r100 = null;
        if (this.f32934i != null) goto L15;
        this.f32934i = new d(this, r100);
    L15:
        if (this.f32935j != null) goto L17;
        this.f32935j = new e(r100);
    L17:
        this.f32931f = r110;
        g r111 = new g(this.f32929d);
        this.f32930e = r111;
        r111.start();
        return;
    L20:
    L10:
        setEGLConfigChooser(true);
        goto L11
    L6:
        if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 24, 8, 0, 0) == false) goto L8;
        setEGLConfigChooser(8, 8, 8, 0, 24, 8);     // Catch: IllegalArgumentException -> L10
    L19:
        goto L11
    L8:
        setEGLConfigChooser(true);     // Catch: IllegalArgumentException -> L10
        goto L19
    }

    public void surfaceCreated(SurfaceTexture r100) {
        g r101 = this.f32930e;
        if (r101 == null) goto L6;
        r101.l();
        return;
    }

    public void surfaceDestroyed(SurfaceTexture r100) {
        g r101 = this.f32930e;
        if (r101 == null) goto L6;
        r101.m();
        return;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser r100) {
        b();
        this.f32933h = r100;
    }

    public GLTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f32927b = 60;
        this.f32928c = new a(this);
        this.f32929d = new WeakReference(this);
        c();
    }

    public GLTextureView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f32927b = 60;
        this.f32928c = new a(this);
        this.f32929d = new WeakReference(this);
        c();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        surfaceCreated(r100);
        surfaceChanged(r100, 0, r101, r102);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        surfaceChanged(r100, 0, r101, r102);
    }

    public void surfaceChanged(SurfaceTexture r100, int r101, int r102, int r103) {
        g r104 = this.f32930e;
        if (r104 == null) goto L6;
        r104.a(r102, r103);
        return;
    }

    private Bitmap a(int r110, int r111, int r112, int r113, GL10 r210, Bitmap.Config r211) {
        int r100 = r112 * r113;
        int[] r114 = new int[r100];
        int[] r115 = new int[r100];
        IntBuffer r101 = IntBuffer.wrap(r114);
        r101.position(0);
        r210.glReadPixels(r110, r111, r112, r113, 6408, 5121, r101);     // Catch: OutOfMemoryError -> L14 GLException -> L17
        int r102 = 0;
    L4:
        if (r102 >= r113) goto L9;
        int r103 = r102 * r112;     // Catch: OutOfMemoryError -> L14 GLException -> L17
        int r104 = ((r113 - r102) - 1) * r112;     // Catch: OutOfMemoryError -> L14 GLException -> L17
        int r105 = 0;
    L6:
        if (r105 >= r112) goto L8;
        int r106 = r114[r103 + r105];     // Catch: OutOfMemoryError -> L14 GLException -> L17
        r115[r104 + r105] = ((r106 & FakePickerAvatarCreator.GREEN) | ((r106 << 16) & 16711680)) | ((r106 >> 16) & 255);     // Catch: OutOfMemoryError -> L14 GLException -> L17
        r105 = r105 + 1;     // Catch: OutOfMemoryError -> L14 GLException -> L17
        goto L6
    L8:
        r102 = r102 + 1;     // Catch: OutOfMemoryError -> L14 GLException -> L17
        goto L4
    L9:
        if (r211 != null) goto L13;
        return Bitmap.createBitmap(r115, r112, r113, Bitmap.Config.ARGB_8888);
    L13:
        return Bitmap.createBitmap(r115, r112, r113, r211);
    L14:
        e = move-exception;
        e.getMessage();
    L16:
        return null;
    }

    public Bitmap captureImageFromSurface(int r100, int r101, int r110, int r111, Object r112, Bitmap.Config r113) {
        return a(r100, r101, r110, r111, (GL10) r112, r113);
    }

    public void setEGLConfigChooser(int r110, int r111, int r112, int r113, int r114, int r115) {
        setEGLConfigChooser(new c(this, r110, r111, r112, r113, r114, r115));
    }

    public void setEGLConfigChooser(int r110, int r111, int r112, int r113, int r114, int r115, int r116) {
        setEGLConfigChooser(new c(this, r110, r111, r112, r113, r114, r115, r116));
    }
}
