package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f33227a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<SurfaceView> f33228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<e> f33230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private j f33231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SurfaceRenderer f33232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f33233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f f33234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g f33235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f33236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private l f33237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f33238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33239m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33240n;

    public static /* synthetic */ class a {
    }

    public abstract class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f33241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f33242b;

        public abstract EGLConfig a(EGL10 r100, EGLDisplay r101, EGLConfig[] r102);

        private int[] a(int[] r100) {
            if (e.c(this.f33242b) != 2) goto L5;
        L7:
            int r101 = r100.length;
            int[] r102 = new int[r101 + 2];
            int r103 = r101 - 1;
            System.arraycopy(r100, 0, r102, 0, r103);
            r102[r103] = 12352;
            if (e.c(this.f33242b) != 2) goto L10;
            r102[r101] = 4;
        L11:
            r102[r101 + 1] = 12344;
            return r102;
        L10:
            r102[r101] = 64;
            goto L11
        L5:
            if (e.c(this.f33242b) == 3) goto L7;
            return r100;
        }

        public b(e r100, int[] r101) {
            this.f33242b = r100;
            this.f33241a = a(r101);
        }

        @Override // com.baidu.platform.comapi.map.e.f
        public EGLConfig chooseConfig(EGL10 r100, EGLDisplay r110) {
            int[] r101 = new int[1];
            if (r100.eglChooseConfig(r110, this.f33241a, null, 0, r101) == false) goto L18;
            int r102 = r101[0];
            if (r102 <= 0) goto L16;
            EGLConfig[] r103 = new EGLConfig[r102];
            if (r100.eglChooseConfig(r110, this.f33241a, r103, r102, r101) == false) goto L14;
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
        private int[] f33243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected int f33244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected int f33245e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f33246f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected int f33247g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int f33248h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected int f33249i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected int f33250j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected int f33251k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ e f33252l;

        @Override // com.baidu.platform.comapi.map.e.b
        public EGLConfig a(EGL10 r110, EGLDisplay r111, EGLConfig[] r112) {
            int r100 = r112.length;
            EGLConfig r101 = null;
            int r113 = 0;
        L3:
            if (r113 >= r100) goto L22;
            EGLConfig r114 = r112[r113];
            int r115 = a(r110, r111, r114, 12325, 0);
            int r102 = a(r110, r111, r114, 12326, 0);
            if (r115 < this.f33248h) goto L21;
            if (r102 < this.f33249i) goto L21;
            int r116 = a(r110, r111, r114, 12324, 0);
            int r117 = a(r110, r111, r114, 12323, 0);
            int r118 = a(r110, r111, r114, 12322, 0);
            int r103 = a(r110, r111, r114, 12321, 0);
            if (r116 != this.f33244d) goto L21;
            if (r117 != this.f33245e) goto L21;
            if (r118 != this.f33246f) goto L21;
            if (r103 != this.f33247g) goto L21;
            if (r101 != null) goto L19;
            r101 = r114;
        L19:
            if (a(r110, r111, r114, 12337, 0) != this.f33251k) goto L21;
            return r114;
        L21:
            r113 = r113 + 1;
            goto L3
        L22:
            return r101;
        }

        private int a(EGL10 r100, EGLDisplay r101, EGLConfig r102, int r103, int r104) {
            if (r100.eglGetConfigAttrib(r101, r102, r103, this.f33243c) == true) goto L5;
            return r104;
        L5:
            return this.f33243c[0];
        }

        public c(e r100, int r101, int r102, int r103, int r104, int r110, int r111, int r112, int r113) {
            this.f33252l = r100;
            super(r100, new int[]{12324, r101, 12323, r102, 12322, r103, 12321, r104, 12325, r110, 12326, r111, 12338, r112, 12337, r113, 12344});
            this.f33243c = new int[1];
            this.f33244d = r101;
            this.f33245e = r102;
            this.f33246f = r103;
            this.f33247g = r104;
            this.f33248h = r110;
            this.f33249i = r111;
            this.f33250j = r112;
            this.f33251k = r113;
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f33253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f33254b;

        private d(e r100) {
            this.f33254b = r100;
            this.f33253a = 12440;
        }

        public /* synthetic */ d(e r100, a r101) {
            this(r100);
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            int[] r103 = {this.f33253a, e.c(this.f33254b), 12344};
            EGLContext r104 = EGL10.EGL_NO_CONTEXT;
            if (e.c(this.f33254b) != 0) goto L7;
            r103 = null;
        L7:
            return r100.eglCreateContext(r101, r102, r104, r103);
        }

        @Override // com.baidu.platform.comapi.map.e.g
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r102 == null) goto L9;
            if (r101 == null) goto L11;
            EGLSurface r103 = EGL10.EGL_NO_SURFACE;
            r100.eglMakeCurrent(r101, r103, r103, r102);
            if (r100.eglDestroyContext(r101, r102) == true) goto L10;
            r101.toString();
            r102.toString();
            i.b("eglDestroyContex", r100.eglGetError());
            return;
        L10:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.baidu.platform.comapi.map.e$e, reason: collision with other inner class name */
    public static class C0666e implements h {
        private C0666e() {
        }

        public /* synthetic */ C0666e(a r100) {
            this();
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public void destroySurface(EGL10 r100, EGLDisplay r101, EGLSurface r102) {
            r100.eglDestroySurface(r101, r102);
        }

        @Override // com.baidu.platform.comapi.map.e.h
        public EGLSurface createWindowSurface(EGL10 r100, EGLDisplay r101, EGLConfig r102, Object r103) {
            return r100.eglCreateWindowSurface(r101, r102, r103, null);
        L8:
            return null;
        }
    }

    public interface f {
        EGLConfig chooseConfig(EGL10 r100, EGLDisplay r101);
    }

    public interface g {
        EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102);

        void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102);
    }

    public interface h {
        EGLSurface createWindowSurface(EGL10 r100, EGLDisplay r101, EGLConfig r102, Object r103);

        void destroySurface(EGL10 r100, EGLDisplay r101, EGLSurface r102);
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<e> f33255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        EGL10 f33256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        EGLDisplay f33257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        EGLSurface f33258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        EGLConfig f33259e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        EGLContext f33260f;

        private void d() {
            EGLSurface r100 = this.f33258d;
            if (r100 == null) goto L11;
            EGLSurface r101 = EGL10.EGL_NO_SURFACE;
            if (r100 == r101) goto L12;
            this.f33256b.eglMakeCurrent(this.f33257c, r101, r101, EGL10.EGL_NO_CONTEXT);
            e r102 = this.f33255a.get();
            if (r102 == null) goto L9;
            e.f(r102).destroySurface(this.f33256b, this.f33257c, this.f33258d);
        L9:
            this.f33258d = null;
            return;
        L12:
            return;
        }

        public GL a() {
            GL r100 = this.f33260f.getGL();
            e r101 = this.f33255a.get();
            if (r101 != null) goto L5;
            return r100;
        L5:
            if (e.g(r101) == null) goto L8;
            r100 = e.g(r101).a(r100);
        L8:
            if ((e.h(r101) & 3) == 0) goto L20;
            int r102 = 1;
            if ((e.h(r101) & 1) != 0) goto L14;
            r102 = 0;
        L14:
            if ((e.h(r101) & 2) == 0) goto L16;
            m r103 = new m();
        L18:
            return GLDebugHelper.wrap(r100, r102, r103);
        L16:
            r103 = null;
            goto L18
        L20:
            return r100;
        }

        public boolean b() {
            if (this.f33256b == null) goto L30;
            if (this.f33257c == null) goto L28;
            if (this.f33259e == null) goto L26;
            d();
            e r100 = this.f33255a.get();
            if (r100 == null) goto L11;
            this.f33258d = e.f(r100).createWindowSurface(this.f33256b, this.f33257c, this.f33259e, r100.d());
        L12:
            EGLSurface r101 = this.f33258d;
            if (r101 != null) goto L15;
        L23:
            this.f33256b.eglGetError();
            return false;
        L15:
            if (r101 == EGL10.EGL_NO_SURFACE) goto L23;
            if (this.f33256b.eglMakeCurrent(this.f33257c, r101, r101, this.f33260f) == true) goto L21;
            a("EGLHelper", "eglMakeCurrent", this.f33256b.eglGetError());
            return false;
        L21:
            return true;
        L11:
            this.f33258d = null;
            goto L12
        L26:
            throw new RuntimeException("mEglConfig not initialized");
        L28:
            throw new RuntimeException("eglDisplay not initialized");
        L30:
            throw new RuntimeException("egl not initialized");
        }

        public void e() {
            if (this.f33260f == null) goto L8;
            e r100 = this.f33255a.get();
            if (r100 == null) goto L7;
            e.e(r100).destroyContext(this.f33256b, this.f33257c, this.f33260f);
        L7:
            this.f33260f = null;
        L8:
            EGLDisplay r101 = this.f33257c;
            if (r101 == null) goto L12;
            this.f33256b.eglTerminate(r101);
            this.f33257c = null;
            return;
        }

        public int g() {
            if (this.f33256b.eglSwapBuffers(this.f33257c, this.f33258d) == false) goto L5;
            return 12288;
        L5:
            return this.f33256b.eglGetError();
        }

        public void f() {
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.f33256b = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f33257c = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L24;
            EGL10 r102 = this.f33256b;
            if (r102.eglInitialize(r101, new int[2]) == false) goto L22;
            e r103 = this.f33255a.get();
            if (r103 != null) goto L25;
            this.f33259e = null;
            this.f33260f = null;
        L11:
            EGLContext r104 = this.f33260f;
            if (r104 != null) goto L14;
        L15:
            this.f33260f = null;
            a("createContext");
        L16:
            this.f33258d = null;
            return;
        L14:
            if (r104 != EGL10.EGL_NO_CONTEXT) goto L16;
        L25:
            this.f33259e = e.d(r103).chooseConfig(this.f33256b, this.f33257c);     // Catch: IllegalArgumentException -> L18
            this.f33260f = e.e(r103).createContext(this.f33256b, this.f33257c, this.f33259e);
        L18:
            e = move-exception;
            e.printStackTrace();
            return;
        L22:
            throw new RuntimeException("eglInitialize failed");
        L24:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public void c() {
            d();
        }

        public i(WeakReference<e> r100) {
            this.f33255a = r100;
        }

        private static String a(int r100) {
            switch(r100) {
                case 12288: goto L33;
                case 12289: goto L31;
                case 12290: goto L29;
                case 12291: goto L27;
                case 12292: goto L25;
                case 12293: goto L23;
                case 12294: goto L21;
                case 12295: goto L19;
                case 12296: goto L17;
                case 12297: goto L15;
                case 12298: goto L13;
                case 12299: goto L11;
                case 12300: goto L9;
                case 12301: goto L7;
                case 12302: goto L5;
                default: goto L4;
            };
        L5:
            return "EGL_CONTEXT_LOST";
        L7:
            return "EGL_BAD_SURFACE";
        L9:
            return "EGL_BAD_PARAMETER";
        L11:
            return "EGL_BAD_NATIVE_WINDOW";
        L13:
            return "EGL_BAD_NATIVE_PIXMAP";
        L15:
            return "EGL_BAD_MATCH";
        L17:
            return "EGL_BAD_DISPLAY";
        L19:
            return "EGL_BAD_CURRENT_SURFACE";
        L21:
            return "EGL_BAD_CONTEXT";
        L23:
            return "EGL_BAD_CONFIG";
        L25:
            return "EGL_BAD_ATTRIBUTE";
        L27:
            return "EGL_BAD_ALLOC";
        L29:
            return "EGL_BAD_ACCESS";
        L31:
            return "EGL_NOT_INITIALIZED";
        L33:
            return "EGL_SUCCESS";
        L4:
            return b(r100);
        }

        private static String b(int r100) {
            return "0x" + Integer.toHexString(r100);
        }

        private void a(String r100) {
            b(r100, this.f33256b.eglGetError());
        }

        public static String a(String r100, int r101) {
            return r100 + " failed: " + a(r101);
        }

        public static void b(String r100, int r101) {
            throw new RuntimeException(a(r100, r101));
        }

        public static void a(String r100, String r101, int r102) {
            a(r101, r102);
        }
    }

    public static class j extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f33261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile boolean f33262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile boolean f33263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile boolean f33264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile boolean f33265e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private volatile boolean f33266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f33267g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f33268h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile boolean f33269i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f33270j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private volatile boolean f33271k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private volatile int f33272l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private volatile int f33273m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private volatile int f33274n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private volatile boolean f33275o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private volatile boolean f33276p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private volatile boolean f33277q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private volatile ArrayList<Runnable> f33278r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private volatile boolean f33279s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private volatile Runnable f33280t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private i f33281u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private long f33282v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private long f33283w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f33284x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private WeakReference<e> f33285y;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com_baidu_platform_comapi_map_e$j_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void c() throws InterruptedException {
            this.f33281u = new i(this.f33285y);
            this.f33268h = false;
            this.f33269i = false;
            this.f33276p = false;
            boolean r100 = false;
            boolean r101 = false;
            boolean r102 = false;
            Runnable r103 = null;
            GL10 r104 = null;
            boolean r105 = false;
            boolean r106 = false;
            boolean r110 = false;
            boolean r111 = false;
            boolean r112 = false;
            int r113 = 0;
            int r114 = 0;
        L3:
            Runnable r115 = null;
        L189:
            k r116 = e.a();     // Catch: Throwable -> L178
            monitor-enter(r116);     // Catch: Throwable -> L178
        L204:
        L175:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L7:
            if (this.f33261a == true) goto L8;
            if (this.f33278r.isEmpty() == false) goto L19;
            if (this.f33264d == this.f33263c) goto L23;
            boolean r107 = this.f33263c;     // Catch: Throwable -> L175
            this.f33264d = this.f33263c;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
        L25:
            if (this.f33271k == false) goto L27;
            j();     // Catch: Throwable -> L175
            i();     // Catch: Throwable -> L175
            this.f33271k = false;     // Catch: Throwable -> L175
            r102 = true;
        L27:
            if (r100 == false) goto L29;
            j();     // Catch: Throwable -> L175
            i();     // Catch: Throwable -> L175
            r100 = false;
        L29:
            if (r107 == true) goto L31;
        L33:
            if (r107 == false) goto L43;
            if (this.f33268h == false) goto L43;
            e r108 = this.f33285y.get();     // Catch: Throwable -> L175
            if (r108 != null) goto L39;
            boolean r109 = false;
        L40:
            if (r109 == true) goto L43;
            i();     // Catch: Throwable -> L175
            goto L43
        L39:
            r109 = e.a(r108);     // Catch: Throwable -> L175
        L43:
            if (this.f33265e == true) goto L51;
            if (this.f33267g == true) goto L51;
            if (this.f33269i == false) goto L49;
            j();     // Catch: Throwable -> L175
        L49:
            this.f33267g = true;     // Catch: Throwable -> L175
            this.f33266f = false;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
        L51:
            if (this.f33265e == true) goto L53;
        L55:
            if (r101 == false) goto L58;
            this.f33276p = false;     // Catch: Throwable -> L175
            this.f33277q = true;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
            r101 = false;
        L58:
            if (this.f33280t == null) goto L61;
            r103 = this.f33280t;     // Catch: Throwable -> L175
            this.f33280t = null;     // Catch: Throwable -> L175
        L61:
            if (f() == true) goto L63;
            if (r103 == null) goto L174;
            r103.run();     // Catch: Throwable -> L175
            r103 = null;
        L174:
            e.a().wait();     // Catch: Throwable -> L175
            goto L204
        L63:
            if (this.f33268h == true) goto L73;
            if (r102 == false) goto L198;
            r102 = false;
            goto L73
        L198:
            this.f33281u.f();     // Catch: RuntimeException -> L69 Throwable -> L175
        L68:
            this.f33268h = true;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
            r105 = true;
        L69:
            e = move-exception;
            e.a().a(this);     // Catch: Throwable -> L175
            throw e;     // Catch: Throwable -> L175
        L73:
            if (this.f33268h == false) goto L78;
            if (this.f33269i == true) goto L78;
            this.f33269i = true;     // Catch: Throwable -> L175
            r106 = true;
            r110 = true;
            r111 = true;
        L78:
            if (this.f33269i == false) goto L174;
            if (this.f33279s == false) goto L82;
            int r117 = this.f33272l;     // Catch: Throwable -> L175
            int r118 = this.f33273m;     // Catch: Throwable -> L175
            this.f33276p = true;     // Catch: Throwable -> L175
            this.f33279s = false;     // Catch: Throwable -> L175
            r113 = r117;
            r114 = r118;
            boolean r119 = false;
            r106 = true;
            r111 = true;
        L83:
            this.f33275o = r119;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
            if (this.f33276p == false) goto L86;
            r112 = true;
        L86:
            monitor-exit(r116);     // Catch: Throwable -> L175
            if (r115 != null) goto L88;
            if (r106 == true) goto L91;
        L110:
            if (r110 == false) goto L112;
            r104 = (GL10) this.f33281u.a();     // Catch: Throwable -> L178
            r110 = false;
        L112:
            if (r105 == false) goto L121;
            e r120 = this.f33285y.get();     // Catch: Throwable -> L178
            if (r120 == null) goto L120;
            e.b(r120).onSurfaceCreated(null, r120.e(), r120.c(), 0);     // Catch: Throwable -> L117
        L117:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L120:
            r105 = false;
        L122:
            if (r111 == false) goto L130;
            e r121 = this.f33285y.get();     // Catch: Throwable -> L178
            if (r121 != null) goto L190;
        L129:
            r111 = false;
            goto L130
        L190:
            e.b(r121).onSurfaceChanged(r113, r114);     // Catch: Throwable -> L127
        L127:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L130:
            long r122 = System.currentTimeMillis();     // Catch: Throwable -> L178
            e r123 = this.f33285y.get();     // Catch: Throwable -> L178
            if (r123 != null) goto L192;
            int r124 = 60;
        L140:
            int r125 = this.f33281u.g();     // Catch: Throwable -> L178
            if (r125 == 12288) goto L155;
            if (r125 == 12302) goto L153;
            i.a("GLThread", "eglSwapBuffers", r125);     // Catch: Throwable -> L178
            k r126 = e.a();     // Catch: Throwable -> L178
            monitor-enter(r126);     // Catch: Throwable -> L178
            this.f33266f = true;     // Catch: Throwable -> L150
            e.a().notifyAll();     // Catch: Throwable -> L150
            monitor-exit(r126);     // Catch: Throwable -> L150
        L150:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L153:
            r100 = true;
        L155:
            if (r112 == false) goto L157;
            int r127 = 60;
            r101 = true;
            r112 = false;
        L158:
            if (r124 > r127) goto L170;
            if (r124 <= 0) goto L170;
            long r128 = ((long) (1000 / r124)) - (System.currentTimeMillis() - r122);     // Catch: Throwable -> L178
            if (r128 <= 1) goto L170;
            k r129 = e.a();     // Catch: Throwable -> L178
            monitor-enter(r129);     // Catch: Throwable -> L178
            e.a().notifyAll();     // Catch: Throwable -> L167
            e.a().wait(r128);     // Catch: Throwable -> L167
            monitor-exit(r129);     // Catch: Throwable -> L167
        L167:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L170:
            a(System.currentTimeMillis() - r122);     // Catch: Throwable -> L178
            r100 = r100;
            goto L189
        L157:
            r101 = r101;
            r127 = 60;
            goto L158
        L192:
            e.b(r123).onDrawFrame(r104);     // Catch: Throwable -> L137
            if (r103 == null) goto L135;
            r103.run();     // Catch: Throwable -> L137
            r103 = null;
        L135:
            r124 = r123.getFPS();     // Catch: Throwable -> L137
            goto L140
        L137:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L121:
            r100 = r100;
            r101 = r101;
            goto L122
        L91:
            if (this.f33281u.b() == false) goto L101;
            k r130 = e.a();     // Catch: Throwable -> L178
            monitor-enter(r130);     // Catch: Throwable -> L178
            this.f33270j = true;     // Catch: Throwable -> L98
            e.a().notifyAll();     // Catch: Throwable -> L98
            monitor-exit(r130);     // Catch: Throwable -> L98
            r106 = false;
            goto L110
        L98:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L101:
            k r131 = e.a();     // Catch: Throwable -> L178
            monitor-enter(r131);     // Catch: Throwable -> L178
            this.f33270j = true;     // Catch: Throwable -> L107
            this.f33266f = true;     // Catch: Throwable -> L107
            e.a().notifyAll();     // Catch: Throwable -> L107
            monitor-exit(r131);     // Catch: Throwable -> L107
        L107:
            th = move-exception;
            throw th;     // Catch: Throwable -> L178
        L88:
            r115.run();     // Catch: Throwable -> L178
            goto L3
        L82:
            r119 = false;
            goto L83
        L53:
            if (this.f33267g == false) goto L55;
            this.f33267g = false;     // Catch: Throwable -> L175
            e.a().notifyAll();     // Catch: Throwable -> L175
            goto L55
        L31:
            if (this.f33269i == false) goto L33;
            j();     // Catch: Throwable -> L175
            goto L33
        L23:
            r107 = false;
            goto L25
        L19:
            r115 = this.f33278r.remove(0);     // Catch: Throwable -> L175
            goto L86
        L8:
            monitor-exit(r116);     // Catch: Throwable -> L175
            k r132 = e.a();
            monitor-enter(r132);
            j();     // Catch: Throwable -> L14
            i();     // Catch: Throwable -> L14
            monitor-exit(r132);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L178:
            th = move-exception;
            monitor-enter(e.a());
            j();     // Catch: Throwable -> L184
            i();     // Catch: Throwable -> L184
            throw th;
        L184:
            th = move-exception;
            throw th;
        }

        private boolean f() {
            if (this.f33264d == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f33265e == false) goto L17;
            if (this.f33266f == true) goto L17;
            if (this.f33272l <= 0) goto L17;
            if (this.f33273m <= 0) goto L17;
            if (this.f33275o == false) goto L15;
            return true;
        L15:
            if (this.f33274n != 1) goto L17;
            return true;
        }

        private void i() {
            if (this.f33268h == false) goto L6;
            this.f33281u.e();
            this.f33268h = false;
            e.a().a(this);
            return;
        }

        private void j() {
            if (this.f33269i == false) goto L6;
            this.f33269i = false;
            this.f33281u.c();
            return;
        }

        public boolean a() {
            if (this.f33268h == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f33269i == false) goto L9;
            if (f() == false) goto L9;
            return true;
        }

        public void com_baidu_platform_comapi_map_e$j__run$___twin___() {
            setName("GLThread " + getId());
            c();     // Catch: Throwable -> L5 InterruptedException -> L10
        L5:
            th = move-exception;
            e.a().b(this);
            throw th;
        L8:
            e.a().b(this);
        }

        public int b() {
            k r100 = e.a();
            monitor-enter(r100);
            int r101 = this.f33274n;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public void d() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33263c = true;     // Catch: Throwable -> L15
        L7:
            if (this.f33262b == true) goto L13;
            if (this.f33264d == true) goto L13;
            e.a().notifyAll();     // Catch: InterruptedException -> L12 Throwable -> L15
            e.a().wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public void e() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33263c = false;     // Catch: Throwable -> L17
            this.f33275o = true;     // Catch: Throwable -> L17
            this.f33277q = false;     // Catch: Throwable -> L17
        L7:
            if (this.f33262b == true) goto L15;
            if (this.f33264d == false) goto L15;
            if (this.f33277q == true) goto L15;
            e.a().notifyAll();     // Catch: InterruptedException -> L14 Throwable -> L17
            e.a().wait();     // Catch: InterruptedException -> L14 Throwable -> L17
        L14:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        public void g() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33261a = true;     // Catch: Throwable -> L13
        L7:
            if (this.f33262b == true) goto L11;
            e.a().notifyAll();     // Catch: InterruptedException -> L10 Throwable -> L13
            e.a().wait();     // Catch: InterruptedException -> L10 Throwable -> L13
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

        public void h() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33275o = true;     // Catch: Throwable -> L8
            e.a().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void k() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33265e = true;     // Catch: Throwable -> L17
            this.f33270j = false;     // Catch: Throwable -> L17
        L7:
            if (this.f33267g == false) goto L15;
            if (this.f33270j == true) goto L15;
            if (this.f33262b == true) goto L15;
            e.a().notifyAll();     // Catch: InterruptedException -> L14 Throwable -> L17
            e.a().wait();     // Catch: InterruptedException -> L14 Throwable -> L17
        L14:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        public void l() {
            k r100 = e.a();
            monitor-enter(r100);
            this.f33265e = false;     // Catch: Throwable -> L15
        L7:
            if (this.f33267g == true) goto L13;
            if (this.f33262b == true) goto L13;
            e.a().notifyAll();     // Catch: InterruptedException -> L12 Throwable -> L15
            e.a().wait();     // Catch: InterruptedException -> L12 Throwable -> L15
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L15
        L13:
            monitor-exit(r100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        public j(WeakReference<e> r100) {
            this.f33278r = new ArrayList();
            this.f33279s = true;
            this.f33280t = null;
            this.f33284x = 60;
            this.f33272l = 0;
            this.f33273m = 0;
            this.f33275o = true;
            this.f33274n = 1;
            this.f33276p = false;
            this.f33285y = r100;
            setPriority(10);
        }

        private void a(long r100) {
            long r101 = this.f33282v + 1;
            this.f33282v = r101;
            long r102 = this.f33283w + r100;
            this.f33283w = r102;
            if (r101 < 10) goto L9;
            int r103 = (int) (r102 / r101);
            if (r103 <= 0) goto L7;
            this.f33284x = (this.f33284x + (1000 / r103)) / 2;
            this.f33282v = 0;
            this.f33283w = 0;
            return;
        L7:
            this.f33282v = 0;
            this.f33283w = 0;
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_platform_comapi_map_e$j_com_larus_apm_impl_protector_RunnableLancet_run(j r100) {
            r100.com_baidu_platform_comapi_map_e$j__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void b(Runnable r100) {
            k r101 = e.a();
            monitor-enter(r101);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (Thread.currentThread() != this) goto L8;
            monitor-exit(r101);     // Catch: Throwable -> L11
            return;
        L8:
            this.f33276p = true;     // Catch: Throwable -> L11
            this.f33275o = true;     // Catch: Throwable -> L11
            this.f33277q = false;     // Catch: Throwable -> L11
            this.f33280t = r100;     // Catch: Throwable -> L11
            e.a().notifyAll();     // Catch: Throwable -> L11
            monitor-exit(r101);     // Catch: Throwable -> L11
        }

        public void a(int r100) {
            if (r100 < 0) goto L14;
            if (r100 > 1) goto L14;
            k r101 = e.a();
            monitor-enter(r101);
            this.f33274n = r100;     // Catch: Throwable -> L10
            e.a().notifyAll();     // Catch: Throwable -> L10
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
            k r101 = e.a();
            monitor-enter(r101);
            this.f33278r.add(r100);     // Catch: Throwable -> L8
            e.a().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }

        public void a(int r100, int r101) {
            k r102 = e.a();
            monitor-enter(r102);
            this.f33272l = r100;     // Catch: Throwable -> L21
            this.f33273m = r101;     // Catch: Throwable -> L21
            this.f33279s = true;     // Catch: Throwable -> L21
            this.f33275o = true;     // Catch: Throwable -> L21
            this.f33277q = false;     // Catch: Throwable -> L21
            if (Thread.currentThread() != this) goto L9;
            monitor-exit(r102);     // Catch: Throwable -> L21
            return;
        L9:
            if (this.f33262b == true) goto L19;
            if (this.f33264d == true) goto L19;
            if (this.f33277q == true) goto L19;
            if (a() == false) goto L19;
            e.a().notifyAll();     // Catch: InterruptedException -> L18 Throwable -> L21
            e.a().wait();     // Catch: InterruptedException -> L18 Throwable -> L21
        L18:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L21
        L19:
            monitor-exit(r102);     // Catch: Throwable -> L21
            return;
        L21:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ boolean a(j r100, boolean r101) {
            r100.f33262b = r101;
            return r101;
        }
    }

    public static class k {
        private k() {
        }

        public /* synthetic */ k(a r100) {
            this();
        }

        public synchronized void a(j r100) {
            monitor-enter(this);
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void b(j r100) {
            monitor-enter(this);
            j.a(r100, true);     // Catch: Throwable -> L7
            notifyAll();     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public interface l {
        GL a(GL r100);
    }

    public static class m extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private StringBuilder f33286a;

        private void a() {
            if (this.f33286a.length() <= 0) goto L6;
            this.f33286a.toString();
            StringBuilder r100 = this.f33286a;
            r100.delete(0, r100.length());
            return;
        }

        public m() {
            this.f33286a = new StringBuilder();
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
            this.f33286a.append(r104);
            goto L8
        }
    }

    public class n extends c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ e f33287m;

        public n(e r110, boolean r111) {
            this.f33287m = r110;
            if (r111 == false) goto L5;
            int r100 = 16;
        L6:
            super(r110, 8, 8, 8, 0, r100, 0, 0, 0);
            return;
        L5:
            r100 = 0;
            goto L6
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder r100) {
    }

    static {
        f33227a = new k(null);
    }

    private void b() {
        if (this.f33231e != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public int c() {
        SurfaceView r100 = this.f33228b.get();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getHeight();
    }

    public SurfaceHolder d() {
        SurfaceView r100 = this.f33228b.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getHolder();
    }

    public int e() {
        SurfaceView r100 = this.f33228b.get();
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getWidth();
    }

    public void finalize() throws Throwable {
        j r100 = this.f33231e;     // Catch: Throwable -> L7
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

    @Override // com.baidu.platform.comapi.map.r
    public int getRenderMode() {
        return this.f33231e.b();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onAttachedToWindow() {
        if (this.f33233g == true) goto L5;
    L14:
        this.f33233g = false;
        return;
    L5:
        if (this.f33232f == null) goto L14;
        j r100 = this.f33231e;
        if (r100 == null) goto L9;
        int r101 = r100.b();
    L10:
        j r102 = new j(this.f33230d);
        this.f33231e = r102;
        if (r101 == 1) goto L13;
        r102.a(r101);
    L13:
        this.f33231e.start();
        goto L14
    L9:
        r101 = 1;
        goto L10
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onDetachedFromWindow() {
        j r100 = this.f33231e;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        this.f33233g = true;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onPause() {
        this.f33231e.d();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void onResume() {
        this.f33231e.e();
    }

    @Override // com.baidu.platform.comapi.map.r
    public void requestRender() {
        this.f33231e.h();
    }

    public static /* synthetic */ k a() {
        return f33227a;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getDebugFlags() {
        return this.f33238l;
    }

    @Override // com.baidu.platform.comapi.map.r
    public int getFPS() {
        return this.f33229c;
    }

    @Override // com.baidu.platform.comapi.map.r
    public s.a getViewType() {
        return s.a.f33357a;
    }

    public e(SurfaceView r100) {
        this.f33229c = 60;
        this.f33230d = new WeakReference(this);
        this.f33228b = new WeakReference(r100);
    }

    public static /* synthetic */ SurfaceRenderer b(e r100) {
        return r100.f33232f;
    }

    public static /* synthetic */ int c(e r100) {
        return r100.f33239m;
    }

    public static /* synthetic */ f d(e r100) {
        return r100.f33234h;
    }

    public static /* synthetic */ g e(e r100) {
        return r100.f33235i;
    }

    public static /* synthetic */ h f(e r100) {
        return r100.f33236j;
    }

    public static /* synthetic */ l g(e r100) {
        return r100.f33237k;
    }

    public static /* synthetic */ int h(e r100) {
        return r100.f33238l;
    }

    public Bitmap a(Bitmap r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        Bitmap r111 = Bitmap.createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
        int r112 = r100 * r101;
        int[] r113 = new int[r112];
        r110.getPixels(r113, 0, r100, 0, 0, r100, r101);
        int r114 = 0;
    L6:
        if (r114 >= r112) goto L8;
        r113[r114] = (r113[r114] & 16777215) | (-16777216);
        r114 = r114 + 1;
        goto L6
    L8:
        r111.setPixels(r113, 0, r100, 0, 0, r100, r101);
        return r111;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void queueEvent(Runnable r100) {
        this.f33231e.a(r100);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setDebugFlags(int r100) {
        this.f33238l = r100;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setFPS(int r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (r100 <= 60) goto L7;
        r100 = 60;
    L7:
        this.f33229c = r100;
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderMode(int r100) {
        this.f33231e.a(r100);
    }

    @Override // com.baidu.platform.comapi.map.r
    public void setRenderer(SurfaceRenderer r100) {
        b();
        if (this.f33234h != null) goto L5;
        this.f33234h = new n(this, true);
    L5:
        a r101 = null;
        if (this.f33235i != null) goto L9;
        this.f33235i = new d(this, r101);
    L9:
        if (this.f33236j != null) goto L11;
        this.f33236j = new C0666e(r101);
    L11:
        this.f33232f = r100;
        j r102 = new j(this.f33230d);
        this.f33231e = r102;
        r102.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        this.f33231e.k();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        this.f33231e.l();
    }

    public void a(boolean r100) {
        a(new n(this, r100));
    }

    public void b(boolean r100) {
        this.f33240n = r100;
    }

    public void a(int r100) {
        b();
        this.f33239m = r100;
    }

    public void a(f r100) {
        b();
        this.f33234h = r100;
    }

    public void a(g r100) {
        b();
        this.f33235i = r100;
    }

    public static /* synthetic */ boolean a(e r100) {
        return r100.f33240n;
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder r100, Runnable r101) {
        j r102 = this.f33231e;
        if (r102 == null) goto L6;
        r102.b(r101);
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        this.f33231e.a(r102, r103);
    }

    private Bitmap a(int r110, int r111, int r112, int r113, GL10 r114, Bitmap.Config r210) {
        int r100 = r112 * r113;
        int[] r115 = new int[r100];
        int[] r116 = new int[r100];
        IntBuffer r101 = IntBuffer.wrap(r115);
        r101.position(0);
        r114.glReadPixels(r110, r111, r112, r113, 6408, 5121, r101);     // Catch: GLException -> L15
        int r102 = 0;
    L4:
        if (r102 >= r113) goto L10;
        int r103 = r102 * r112;     // Catch: GLException -> L15
        int r104 = ((r113 - r102) - 1) * r112;     // Catch: GLException -> L15
        int r105 = 0;
    L6:
        if (r105 >= r112) goto L9;
        int r106 = r115[r103 + r105];     // Catch: GLException -> L15
        r116[r104 + r105] = ((r106 & FakePickerAvatarCreator.GREEN) | ((r106 << 16) & 16711680)) | ((r106 >> 16) & 255);     // Catch: GLException -> L15
        r105 = r105 + 1;
        goto L6
    L9:
        r102 = r102 + 1;
        goto L4
    L10:
        if (r210 != null) goto L12;
        Bitmap r107 = Bitmap.createBitmap(r116, r112, r113, Bitmap.Config.ARGB_8888);
    L14:
        return a(r107);
    L12:
        r107 = Bitmap.createBitmap(r116, r112, r113, r210);
    L16:
        return null;
    }

    @Override // com.baidu.platform.comapi.map.r
    public Bitmap captureImageFromSurface(int r100, int r101, int r110, int r111, Object r112, Bitmap.Config r113) {
        return a(r100, r101, r110, r111, (GL10) r112, r113);
    }

    public void a(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117) {
        a(new c(this, r110, r111, r112, r113, r114, r115, r116, r117));
    }
}
