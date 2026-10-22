package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class y extends TextureView implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final k f28348h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f28349i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<y> f28350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j f28351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GLSurfaceView.Renderer f28352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f28353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f28354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g f28355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f28356g;

    public static /* synthetic */ class a {
    }

    public abstract class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int[] f28357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ y f28358b;

        public abstract EGLConfig a(EGL10 r100, EGLDisplay r101, EGLConfig[] r102);

        private int[] a(int[] r100) {
            y r101 = this.f28358b;
            int r102 = y.f28349i;
            r101.getClass();
            this.f28358b.getClass();
            return r100;
        }

        public b(y r100, int[] r101) {
            this.f28358b = r100;
            this.f28357a = a(r101);
        }

        @Override // com.amap.api.mapcore.util.y.f
        public EGLConfig chooseConfig(EGL10 r100, EGLDisplay r110) {
            int[] r101 = new int[1];
            if (r100.eglChooseConfig(r110, this.f28357a, null, 0, r101) == false) goto L18;
            int r102 = r101[0];
            if (r102 <= 0) goto L16;
            EGLConfig[] r103 = new EGLConfig[r102];
            if (r100.eglChooseConfig(r110, this.f28357a, r103, r102, r101) == false) goto L14;
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
        private int[] f28359c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected int f28360d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected int f28361e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f28362f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected int f28363g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected int f28364h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected int f28365i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ y f28366j;

        @Override // com.amap.api.mapcore.util.y.b
        public EGLConfig a(EGL10 r110, EGLDisplay r111, EGLConfig[] r112) {
            int r100 = r112.length;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L42;
            EGLConfig r102 = r112[r101];
            if (r110.eglGetConfigAttrib(r111, r102, 12325, this.f28359c) == false) goto L7;
            int r103 = this.f28359c[0];
        L9:
            if (r110.eglGetConfigAttrib(r111, r102, 12326, this.f28359c) == false) goto L11;
            int r104 = this.f28359c[0];
        L13:
            if (r103 < this.f28364h) goto L41;
            if (r104 < this.f28365i) goto L41;
            if (r110.eglGetConfigAttrib(r111, r102, 12324, this.f28359c) == false) goto L19;
            int r105 = this.f28359c[0];
        L21:
            if (r110.eglGetConfigAttrib(r111, r102, 12323, this.f28359c) == false) goto L23;
            int r106 = this.f28359c[0];
        L25:
            if (r110.eglGetConfigAttrib(r111, r102, 12322, this.f28359c) == false) goto L27;
            int r107 = this.f28359c[0];
        L29:
            if (r110.eglGetConfigAttrib(r111, r102, 12321, this.f28359c) == false) goto L31;
            int r108 = this.f28359c[0];
        L33:
            if (r105 != this.f28360d) goto L41;
            if (r106 != this.f28361e) goto L41;
            if (r107 != this.f28362f) goto L41;
            if (r108 != this.f28363g) goto L41;
            return r102;
        L31:
            r108 = 0;
            goto L33
        L27:
            r107 = 0;
            goto L29
        L23:
            r106 = 0;
            goto L25
        L19:
            r105 = 0;
        L41:
            r101 = r101 + 1;
            goto L3
        L11:
            r104 = 0;
            goto L13
        L7:
            r103 = 0;
            goto L9
        L42:
            return null;
        }

        public c(y r100, int r101, int r102, int r103, int r104, int r110, int r111) {
            this.f28366j = r100;
            super(r100, new int[]{12324, r101, 12323, r102, 12322, r103, 12321, r104, 12325, r110, 12326, r111, 12344});
            this.f28359c = new int[1];
            this.f28360d = r101;
            this.f28361e = r102;
            this.f28362f = r103;
            this.f28363g = r104;
            this.f28364h = r110;
            this.f28365i = r111;
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f28367a;

        private d(y r100) {
            this.f28367a = r100;
        }

        public /* synthetic */ d(y r100, a r101) {
            this(r100);
        }

        @Override // com.amap.api.mapcore.util.y.g
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            this.f28367a.getClass();
            EGLContext r103 = EGL10.EGL_NO_CONTEXT;
            this.f28367a.getClass();
            return r100.eglCreateContext(r101, r102, r103, null);
        }

        @Override // com.amap.api.mapcore.util.y.g
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r100.eglDestroyContext(r101, r102) == false) goto L5;
            return;
        L5:
            Objects.toString(r101);
            Objects.toString(r102);
            throw new RuntimeException("eglDestroyContex failed: " + r100.eglGetError());
        }
    }

    public static class e implements h {
        private e() {
        }

        public /* synthetic */ e(a r100) {
            this();
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
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<y> f28368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        EGL10 f28369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        EGLDisplay f28370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        EGLSurface f28371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        EGLConfig f28372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        EGLContext f28373f;

        private void d() {
            EGLSurface r100 = this.f28371d;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100 == EGL10.EGL_NO_SURFACE) goto L21;
            g();
            y r101 = this.f28368a.get();
            if (r101 != null) goto L9;
        L15:
            this.f28371d = null;
            return;
        L9:
            if (y.d(r101) == null) goto L15;
            if (this.f28369b == null) goto L15;
            if (this.f28370c == null) goto L15;
            h r102 = y.d(r101);     // Catch: Throwable -> L17
            EGL10 r103 = this.f28369b;     // Catch: Throwable -> L17
            EGLDisplay r104 = this.f28370c;     // Catch: Throwable -> L17
            EGLSurface r105 = this.f28371d;     // Catch: Throwable -> L17
            ((e) r102).getClass();     // Catch: Throwable -> L17
            r103.eglDestroySurface(r104, r105);     // Catch: Throwable -> L17
            goto L15
        }

        private void g() {
            EGL10 r100 = this.f28369b;
            if (r100 == null) goto L14;
            EGLDisplay r101 = this.f28370c;
            if (r101 != null) goto L7;
            return;
        L7:
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L16;
            EGLSurface r102 = EGL10.EGL_NO_SURFACE;     // Catch: Throwable -> L11
            r100.eglMakeCurrent(r101, r102, r102, EGL10.EGL_NO_CONTEXT);     // Catch: Throwable -> L11
            return;
        L17:
            return;
        L16:
            return;
        }

        public GL a() {
            GL r100 = this.f28373f.getGL();
            if (this.f28368a.get() == null) goto L5;
            int r101 = y.f28349i;
        L5:
            return r100;
        }

        public boolean b() {
            if (this.f28369b == null) goto L32;
            if (this.f28370c == null) goto L30;
            if (this.f28372e == null) goto L28;
            d();
            y r100 = this.f28368a.get();
            EGLSurface r101 = null;
            if (r100 == null) goto L13;
            h r102 = y.d(r100);
            EGL10 r103 = this.f28369b;
            EGLDisplay r104 = this.f28370c;
            EGLConfig r105 = this.f28372e;
            SurfaceTexture r106 = r100.getSurfaceTexture();
            ((e) r102).getClass();
            r101 = r103.eglCreateWindowSurface(r104, r105, r106, null);     // Catch: IllegalArgumentException -> L33
        L12:
            this.f28371d = r101;
        L14:
            EGLSurface r107 = this.f28371d;
            if (r107 != null) goto L17;
        L25:
            this.f28369b.eglGetError();
            return false;
        L17:
            if (r107 == EGL10.EGL_NO_SURFACE) goto L25;
            if (this.f28369b.eglMakeCurrent(this.f28370c, r107, r107, this.f28373f) == true) goto L23;
            this.f28369b.eglGetError();
            return false;
        L23:
            return true;
        L13:
            this.f28371d = null;
            goto L14
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        public void e() {
            g();
            d();
            EGLContext r100 = this.f28373f;
            if (r100 != null) goto L5;
        L12:
            EGL10 r101 = this.f28369b;
            if (r101 == null) goto L24;
            EGLDisplay r102 = this.f28370c;
            if (r102 != null) goto L17;
            return;
        L17:
            if (r102 == EGL10.EGL_NO_DISPLAY) goto L26;
            r101.eglTerminate(r102);     // Catch: Throwable -> L21
        L19:
            this.f28370c = null;
            return;
        L26:
            return;
        L24:
            return;
        L5:
            if (r100 == EGL10.EGL_NO_CONTEXT) goto L12;
            y r103 = this.f28368a.get();
            if (r103 != null) goto L9;
        L11:
            this.f28373f = null;
            goto L12
        L9:
            if (y.c(r103) == null) goto L11;
            y.c(r103).destroyContext(this.f28369b, this.f28370c, this.f28373f);
            goto L11
        }

        public void f() {
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.f28369b = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f28370c = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L21;
            if (this.f28369b.eglInitialize(r101, new int[2]) == false) goto L19;
            y r102 = this.f28368a.get();
            if (r102 != null) goto L9;
            this.f28372e = null;
            this.f28373f = null;
        L10:
            EGLContext r103 = this.f28373f;
            if (r103 != null) goto L13;
        L16:
            this.f28373f = null;
            throw new RuntimeException("createContext failed: " + this.f28369b.eglGetError());
        L13:
            if (r103 == EGL10.EGL_NO_CONTEXT) goto L16;
            this.f28371d = null;
            return;
        L9:
            this.f28372e = y.b(r102).chooseConfig(this.f28369b, this.f28370c);
            this.f28373f = y.c(r102).createContext(this.f28369b, this.f28370c, this.f28372e);
            goto L10
        L19:
            throw new RuntimeException("eglInitialize failed");
        L21:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public void c() {
            d();
        }

        public i(WeakReference<y> r100) {
            this.f28368a = r100;
        }
    }

    public static class j extends PthreadThreadV2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28374a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f28375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f28376c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f28377d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f28378e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f28379f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f28380g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f28381h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f28382i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f28383j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f28384k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f28385l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f28386m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f28387n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f28388o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private boolean f28389p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private ArrayList<Runnable> f28390q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Runnable f28391r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f28392s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private i f28393t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private WeakReference<y> f28394u;

        public void g() {
            this.f28384k = true;
            y.a().notifyAll();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_amap_api_mapcore_util_y$j_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void d() throws InterruptedException {
            this.f28393t = new i(this.f28394u);
            this.f28381h = false;
            this.f28382i = false;
            boolean r100 = false;
            boolean r101 = false;
            boolean r102 = false;
            GL10 r103 = null;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
            boolean r110 = false;
            int r111 = 0;
            int r112 = 0;
            Runnable r113 = null;
            boolean r114 = false;
        L183:
            k r115 = y.a();     // Catch: Throwable -> L166
            monitor-enter(r115);     // Catch: Throwable -> L166
        L190:
        L163:
            th = move-exception;
            throw th;     // Catch: Throwable -> L166
        L6:
            if (this.f28390q.isEmpty() == false) goto L7;
            if (this.f28374a == true) goto L11;
            boolean r107 = this.f28377d;     // Catch: Throwable -> L163
            boolean r108 = this.f28376c;     // Catch: Throwable -> L163
            if (r107 == r108) goto L26;
            this.f28377d = r108;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
        L28:
            if (this.f28384k == false) goto L30;
            j();     // Catch: Throwable -> L163
            i();     // Catch: Throwable -> L163
            this.f28384k = false;     // Catch: Throwable -> L163
            r102 = true;
        L30:
            if (r100 == false) goto L32;
            j();     // Catch: Throwable -> L163
            i();     // Catch: Throwable -> L163
            r100 = false;
        L32:
            if (r108 == true) goto L34;
        L36:
            if (r108 == true) goto L38;
        L40:
            if (r108 == false) goto L45;
            if (y.a().b() == false) goto L45;
            this.f28393t.e();     // Catch: Throwable -> L163
            this.f28381h = false;     // Catch: Throwable -> L163
        L45:
            if (this.f28378e == true) goto L53;
            if (this.f28380g == true) goto L53;
            if (this.f28382i == false) goto L51;
            j();     // Catch: Throwable -> L163
        L51:
            this.f28380g = true;     // Catch: Throwable -> L163
            this.f28379f = false;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
        L53:
            if (this.f28378e == true) goto L55;
        L57:
            if (r101 == false) goto L60;
            this.f28389p = true;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
            r101 = false;
            r114 = false;
        L60:
            if (f() == false) goto L162;
            if (this.f28381h == true) goto L74;
            if (r102 == false) goto L66;
            r102 = false;
            goto L74
        L66:
            if (y.a().c(this) == false) goto L74;
            this.f28393t.f();     // Catch: RuntimeException -> L70 Throwable -> L163
        L69:
            this.f28381h = true;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
            r104 = true;
        L70:
            e = move-exception;
            y.a().a(this);     // Catch: Throwable -> L163
            throw e;     // Catch: Throwable -> L163
        L74:
            if (this.f28381h == false) goto L79;
            if (this.f28382i == true) goto L79;
            this.f28382i = true;     // Catch: Throwable -> L163
            r105 = true;
            r106 = true;
            r110 = true;
        L79:
            if (this.f28382i == false) goto L162;
            if (this.f28392s == false) goto L83;
            int r109 = this.f28385l;     // Catch: Throwable -> L163
            int r116 = this.f28386m;     // Catch: Throwable -> L163
            this.f28392s = false;     // Catch: Throwable -> L163
            r111 = r109;
            r112 = r116;
            boolean r117 = false;
            r105 = true;
            r110 = true;
            r114 = true;
        L84:
            this.f28388o = r117;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
        L85:
            monitor-exit(r115);     // Catch: Throwable -> L163
            if (r113 != null) goto L87;
            if (r105 == false) goto L109;
            if (this.f28393t.b() == false) goto L100;
            k r118 = y.a();     // Catch: Throwable -> L166
            monitor-enter(r118);     // Catch: Throwable -> L166
            this.f28383j = true;     // Catch: Throwable -> L97
            y.a().notifyAll();     // Catch: Throwable -> L97
            monitor-exit(r118);     // Catch: Throwable -> L97
            r105 = false;
            goto L109
        L97:
            th = move-exception;
            throw th;     // Catch: Throwable -> L166
        L100:
            k r119 = y.a();     // Catch: Throwable -> L166
            monitor-enter(r119);     // Catch: Throwable -> L166
            this.f28383j = true;     // Catch: Throwable -> L106
            this.f28379f = true;     // Catch: Throwable -> L106
            y.a().notifyAll();     // Catch: Throwable -> L106
            monitor-exit(r119);     // Catch: Throwable -> L106
        L106:
            th = move-exception;
            throw th;     // Catch: Throwable -> L166
        L109:
            if (r106 == false) goto L111;
            r103 = (GL10) this.f28393t.a();     // Catch: Throwable -> L166
            y.a().a(r103);     // Catch: Throwable -> L166
            r106 = false;
        L111:
            if (r104 == false) goto L116;
            y r120 = this.f28394u.get();     // Catch: Throwable -> L166
            if (r120 == null) goto L115;
            y.a(r120).onSurfaceCreated(r103, this.f28393t.f28372e);     // Catch: Throwable -> L166
        L115:
            r104 = false;
        L116:
            if (r110 == false) goto L121;
            y r121 = this.f28394u.get();     // Catch: Throwable -> L166
            if (r121 == null) goto L120;
            y.a(r121).onSurfaceChanged(r103, r111, r112);     // Catch: Throwable -> L166
        L120:
            r110 = false;
        L121:
            y r122 = this.f28394u.get();     // Catch: Throwable -> L166
            if (r122 == null) goto L124;
            y.a(r122).onDrawFrame(r103);     // Catch: Throwable -> L166
        L124:
            k r123 = y.a();     // Catch: Throwable -> L166
            monitor-enter(r123);     // Catch: Throwable -> L166
            if (this.f28374a == true) goto L156;
            if (this.f28378e == false) goto L156;
            if (this.f28379f == true) goto L156;
            monitor-exit(r123);     // Catch: Throwable -> L159
            i r124 = this.f28393t;     // Catch: Throwable -> L166
            boolean r125 = r100;
            if (r124.f28369b.eglSwapBuffers(r124.f28370c, r124.f28371d) == true) goto L137;
            int r126 = r124.f28369b.eglGetError();     // Catch: Throwable -> L166
        L138:
            if (r126 == 12288) goto L152;
            if (r126 == 12302) goto L150;
            k r127 = y.a();     // Catch: Throwable -> L166
            monitor-enter(r127);     // Catch: Throwable -> L166
            this.f28379f = true;     // Catch: Throwable -> L147
            y.a().notifyAll();     // Catch: Throwable -> L147
            monitor-exit(r127);     // Catch: Throwable -> L147
        L147:
            th = move-exception;
            throw th;     // Catch: Throwable -> L166
        L150:
            r100 = true;
        L154:
            if (r114 == false) goto L183;
            r101 = true;
        L152:
            r100 = r125;
            goto L154
        L137:
            r126 = 12288;
        L156:
            boolean r128 = r100;
            monitor-exit(r123);     // Catch: Throwable -> L159
            r100 = r128;
            goto L183
        L159:
            th = move-exception;
            throw th;     // Catch: Throwable -> L166
        L87:
            r113.run();     // Catch: Throwable -> L166
            r113 = null;
            goto L183
        L83:
            r117 = false;
        L162:
            y.a().wait();     // Catch: Throwable -> L163
            goto L190
        L55:
            if (this.f28380g == false) goto L57;
            this.f28380g = false;     // Catch: Throwable -> L163
            y.a().notifyAll();     // Catch: Throwable -> L163
            goto L57
        L38:
            if (this.f28381h == false) goto L40;
            y r129 = this.f28394u.get();     // Catch: Throwable -> L163
            i();     // Catch: Throwable -> L163
            goto L40
        L34:
            if (this.f28382i == false) goto L36;
            j();     // Catch: Throwable -> L163
            goto L36
        L26:
            r108 = false;
            goto L28
        L11:
            r113 = this.f28391r;     // Catch: Throwable -> L163
            if (r113 == null) goto L14;
            this.f28391r = null;     // Catch: Throwable -> L163
            goto L85
        L14:
            monitor-exit(r115);     // Catch: Throwable -> L163
            k r130 = y.a();
            monitor-enter(r130);
            j();     // Catch: Throwable -> L20
            i();     // Catch: Throwable -> L20
            monitor-exit(r130);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L7:
            r113 = this.f28390q.remove(0);     // Catch: Throwable -> L163
        L166:
            th = move-exception;
            monitor-enter(y.a());
            j();     // Catch: Throwable -> L172
            i();     // Catch: Throwable -> L172
            throw th;
        L172:
            th = move-exception;
            throw th;
        }

        private boolean f() {
            if (this.f28377d == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f28378e == false) goto L17;
            if (this.f28379f == true) goto L17;
            if (this.f28385l <= 0) goto L17;
            if (this.f28386m <= 0) goto L17;
            if (this.f28388o == false) goto L15;
            return true;
        L15:
            if (this.f28387n != 1) goto L17;
            return true;
        }

        private void i() {
            if (this.f28381h == false) goto L6;
            this.f28393t.e();
            this.f28381h = false;
            y.a().a(this);
            return;
        }

        private void j() {
            if (this.f28382i == false) goto L6;
            this.f28382i = false;
            this.f28393t.c();
            return;
        }

        public void com_amap_api_mapcore_util_y$j__run$___twin___() {
            ThreadMethodProxy.setName(this, "GLThread " + getId());
            d();     // Catch: Throwable -> L5 InterruptedException -> L10
        L5:
            th = move-exception;
            y.a().b(this);
            throw th;
        L8:
            y.a().b(this);
        }

        public int a() {
            k r100 = y.a();
            monitor-enter(r100);
            int r101 = this.f28386m;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public int b() {
            k r100 = y.a();
            monitor-enter(r100);
            int r101 = this.f28387n;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public int c() {
            k r100 = y.a();
            monitor-enter(r100);
            int r101 = this.f28385l;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public void e() {
            k r100 = y.a();
            monitor-enter(r100);
            this.f28376c = false;     // Catch: Throwable -> L17
            this.f28388o = true;     // Catch: Throwable -> L17
            this.f28389p = false;     // Catch: Throwable -> L17
            y.a().notifyAll();     // Catch: Throwable -> L17
        L7:
            if (this.f28375b == true) goto L15;
            if (this.f28377d == false) goto L15;
            if (this.f28389p == true) goto L15;
            y.a().wait();     // Catch: InterruptedException -> L14 Throwable -> L17
        L14:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        public void h() {
            k r100 = y.a();
            monitor-enter(r100);
            this.f28388o = true;     // Catch: Throwable -> L8
            y.a().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void k() {
            k r100 = y.a();
            monitor-enter(r100);
            this.f28378e = true;     // Catch: Throwable -> L17
            this.f28383j = false;     // Catch: Throwable -> L17
            y.a().notifyAll();     // Catch: Throwable -> L17
        L7:
            if (this.f28380g == false) goto L15;
            if (this.f28383j == true) goto L15;
            if (this.f28375b == true) goto L15;
            y.a().wait();     // Catch: InterruptedException -> L14 Throwable -> L17
        L14:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        public j(WeakReference<y> r100) {
            super("core/util/y$j");
            this.f28390q = new ArrayList();
            this.f28392s = true;
            this.f28385l = 0;
            this.f28386m = 0;
            this.f28388o = true;
            this.f28387n = 1;
            this.f28394u = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_amap_api_mapcore_util_y$j_com_larus_apm_impl_protector_RunnableLancet_run(j r100) {
            r100.com_amap_api_mapcore_util_y$j__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public boolean a(long r100) {
            if (r100 <= 0) goto L5;
            long r101 = SystemClock.uptimeMillis() + r100;
        L6:
            k r102 = y.a();
            monitor-enter(r102);
            boolean r110 = true;
            this.f28376c = true;     // Catch: Throwable -> L33
            y.a().notifyAll();     // Catch: Throwable -> L33
        L11:
            if (this.f28375b == true) goto L26;
            if (this.f28377d == true) goto L26;
            if (r100 <= 0) goto L20;
            long r103 = r101 - SystemClock.uptimeMillis();     // Catch: InterruptedException -> L24 Throwable -> L33
        L16:
            if (r103 <= 0) goto L26;
            y.a().wait(r103);     // Catch: InterruptedException -> L24 Throwable -> L33
        L24:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L33
            goto L11
        L20:
            if (MapsInitializer.getTextureViewDestorySync() == true) goto L21;
            y.a().wait(2000);     // Catch: InterruptedException -> L24 Throwable -> L33
            goto L11
        L21:
            y.a().wait();     // Catch: InterruptedException -> L24 Throwable -> L33
        L26:
            if (this.f28375b == false) goto L28;
        L31:
            monitor-exit(r102);     // Catch: Throwable -> L33
            return r110;
        L28:
            if (this.f28377d == true) goto L31;
            r110 = false;
        L33:
            th = move-exception;
            throw th;
        L5:
            r101 = 0;
            goto L6
        }

        public boolean b(long r100) {
            if (r100 <= 0) goto L5;
            long r101 = SystemClock.uptimeMillis() + r100;
        L6:
            k r102 = y.a();
            monitor-enter(r102);
            boolean r110 = false;
            this.f28378e = false;     // Catch: Throwable -> L32
            y.a().notifyAll();     // Catch: Throwable -> L32
        L11:
            if (this.f28380g == true) goto L26;
            if (this.f28375b == true) goto L26;
            if (r100 <= 0) goto L20;
            long r103 = r101 - SystemClock.uptimeMillis();     // Catch: InterruptedException -> L24 Throwable -> L32
        L16:
            if (r103 <= 0) goto L26;
            y.a().wait(r103);     // Catch: InterruptedException -> L24 Throwable -> L32
        L24:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L32
            goto L11
        L20:
            if (MapsInitializer.getTextureViewDestorySync() == true) goto L21;
            y.a().wait(2000);     // Catch: InterruptedException -> L24 Throwable -> L32
            goto L11
        L21:
            y.a().wait();     // Catch: InterruptedException -> L24 Throwable -> L32
        L26:
            if (this.f28380g == false) goto L28;
        L29:
            r110 = true;
        L30:
            monitor-exit(r102);     // Catch: Throwable -> L32
            return r110;
        L28:
            if (this.f28375b == false) goto L30;
        L32:
            th = move-exception;
            throw th;
        L5:
            r101 = 0;
            goto L6
        }

        public void a(int r100) {
            if (r100 < 0) goto L14;
            if (r100 > 1) goto L14;
            k r101 = y.a();
            monitor-enter(r101);
            this.f28387n = r100;     // Catch: Throwable -> L10
            y.a().notifyAll();     // Catch: Throwable -> L10
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
            k r101 = y.a();
            monitor-enter(r101);
            this.f28390q.add(r100);     // Catch: Throwable -> L8
            y.a().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }

        public boolean a(long r100, Runnable r101) {
            if (r100 <= 0) goto L5;
            long r102 = SystemClock.uptimeMillis() + r100;
        L6:
            k r103 = y.a();
            monitor-enter(r103);
            if (r101 != null) goto L31;
        L12:
            this.f28374a = true;     // Catch: Throwable -> L26
            y.a().notifyAll();     // Catch: Throwable -> L26
        L14:
            if (this.f28375b == true) goto L23;
            if (r100 <= 0) goto L20;
            long r104 = r102 - SystemClock.uptimeMillis();     // Catch: InterruptedException -> L22 Throwable -> L26
        L17:
            if (r104 <= 0) goto L23;
            y.a().wait(r104);     // Catch: InterruptedException -> L22 Throwable -> L26
        L22:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L20:
            y.a().wait();     // Catch: InterruptedException -> L22 Throwable -> L26
        L23:
            boolean r105 = this.f28375b;     // Catch: Throwable -> L26
            monitor-exit(r103);     // Catch: Throwable -> L26
            return r105;
        L31:
            if (this.f28375b == true) goto L12;
            this.f28391r = r101;     // Catch: Throwable -> L26
            goto L12
        L5:
            r102 = 0;
            goto L6
        }

        public void a(int r100, int r101) {
            k r102 = y.a();
            monitor-enter(r102);
            this.f28385l = r100;     // Catch: Throwable -> L25
            this.f28386m = r101;     // Catch: Throwable -> L25
            this.f28392s = true;     // Catch: Throwable -> L25
            this.f28388o = true;     // Catch: Throwable -> L25
            this.f28389p = false;     // Catch: Throwable -> L25
            y.a().notifyAll();     // Catch: Throwable -> L25
        L6:
            if (this.f28375b == true) goto L23;
            if (this.f28377d == true) goto L23;
            if (this.f28389p == true) goto L23;
            if (this.f28381h == true) goto L14;
        L18:
            boolean r103 = false;
        L19:
            if (r103 == false) goto L23;
            y.a().wait();     // Catch: InterruptedException -> L22 Throwable -> L25
        L22:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L25
            goto L6
        L14:
            if (this.f28382i == false) goto L18;
            if (f() == false) goto L18;
            r103 = true;
        L23:
            monitor-exit(r102);     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }

        public static /* synthetic */ boolean a(j r100, boolean r101) {
            r100.f28375b = r101;
            return r101;
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f28395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f28396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f28397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f28398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f28399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private j f28400f;

        public synchronized boolean b() {
            monitor-enter(this);
            a();     // Catch: Throwable -> L7
            boolean r100 = !this.f28398d;
            monitor-exit(this);
            return r100;
        L7:
            th = move-exception;
            throw th;
        }

        private void a() {
            if (this.f28395a == true) goto L6;
            this.f28396b = 131072;
            this.f28398d = true;
            this.f28395a = true;
            return;
        }

        private k() {
        }

        public /* synthetic */ k(a r100) {
            this();
        }

        public synchronized void a(GL10 r100) {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.f28397c == true) goto L10;
            if (r100 == null) goto L10;
            a();     // Catch: Throwable -> L12
            String r101 = r100.glGetString(7937);     // Catch: Throwable -> L12
            if (this.f28396b >= 131072) goto L9;
            this.f28398d = !r101.startsWith("Q3Dimension MSM7500 ");     // Catch: Throwable -> L12
            notifyAll();     // Catch: Throwable -> L12
        L9:
            this.f28399e = !this.f28398d;     // Catch: Throwable -> L12
            this.f28397c = true;     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);
        }

        public synchronized void b(j r100) {
            monitor-enter(this);
            j.a(r100, true);     // Catch: Throwable -> L10
            if (this.f28400f != r100) goto L7;
            this.f28400f = null;     // Catch: Throwable -> L10
        L7:
            notifyAll();     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean c(j r100) {
            j r101 = this.f28400f;
            if (r101 == r100) goto L14;
            if (r101 == null) goto L14;
            a();
            if (this.f28398d == false) goto L9;
            return true;
        L9:
            j r102 = this.f28400f;
            if (r102 == null) goto L16;
            r102.g();
            return false;
        L16:
            return false;
        L14:
            this.f28400f = r100;
            notifyAll();
            return true;
        }

        public void a(j r100) {
            if (this.f28400f != r100) goto L5;
            this.f28400f = null;
        L5:
            notifyAll();
        }
    }

    public class l extends c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ y f28401k;

        public l(y r100, boolean r110) {
            this.f28401k = r100;
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
        f28348h = new k(null);
    }

    private void b() {
        if (this.f28351b != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public void d() {
        this.f28351b.a(0);
    }

    public void e() {
        this.f28351b.e();
    }

    public void finalize() throws Throwable {
        j r100 = this.f28351b;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.a(0, null);     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getRenderMode() {
        return this.f28351b.b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        a(0, null);
        super.onDetachedFromWindow();
    }

    public void requestRender() {
        this.f28351b.h();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f28353d == true) goto L5;
    L14:
        this.f28353d = false;
        return;
    L5:
        if (this.f28352c == null) goto L14;
        j r100 = this.f28351b;
        if (r100 == null) goto L9;
        int r101 = r100.b();
    L10:
        j r102 = new j(this.f28350a);
        this.f28351b = r102;
        if (r101 == 1) goto L13;
        r102.a(r101);
    L13:
        ThreadMethodProxy.start(this.f28351b);
        goto L14
    L9:
        r101 = 1;
        goto L10
    }

    public static /* synthetic */ k a() {
        return f28348h;
    }

    private void c() {
        setSurfaceTextureListener(this);
    }

    public static /* synthetic */ f b(y r100) {
        return r100.f28354e;
    }

    public static /* synthetic */ g c(y r100) {
        return r100.f28355f;
    }

    public static /* synthetic */ h d(y r100) {
        return r100.f28356g;
    }

    public boolean a(long r100) {
        return this.f28351b.b(r100);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        this.f28351b.b(0);
        return true;
    }

    public void queueEvent(Runnable r100) {
        this.f28351b.a(r100);
    }

    public void setRenderMode(int r100) {
        this.f28351b.a(r100);
    }

    public void setRenderer(GLSurfaceView.Renderer r100) {
        b();
        if (this.f28354e != null) goto L5;
        this.f28354e = new l(this, true);
    L5:
        a r101 = null;
        if (this.f28355f != null) goto L9;
        this.f28355f = new d(this, r101);
    L9:
        if (this.f28356g != null) goto L11;
        this.f28356g = new e(r101);
    L11:
        this.f28352c = r100;
        j r102 = new j(this.f28350a);
        this.f28351b = r102;
        ThreadMethodProxy.start(r102);
    }

    public void a(f r100) {
        b();
        this.f28354e = r100;
    }

    public void a(g r100) {
        b();
        this.f28355f = r100;
    }

    public static /* synthetic */ GLSurfaceView.Renderer a(y r100) {
        return r100.f28352c;
    }

    public y(Context r100, AttributeSet r101) {
        super(r100, null);
        this.f28350a = new WeakReference(this);
        c();
    }

    public boolean a(long r100, Runnable r101) {
        j r102 = this.f28351b;
        if (r102 != null) goto L5;
        boolean r103 = true;
    L6:
        this.f28353d = true;
        return r103;
    L5:
        r103 = r102.a(r100, r101);
        goto L6
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        this.f28351b.k();
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L15:
        this.f28351b.a(r101, r102);
        return;
    L8:
        if (MapsInitializer.getTextureSizeChangedInvoked() == true) goto L15;
        if (this.f28351b.c() == r101) goto L13;
    L14:
        this.f28351b.a(r101, r102);
        return;
    L13:
        if (this.f28351b.a() != r102) goto L14;
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        this.f28351b.a(r101, r102);
    }

    @Override // android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        getSurfaceTexture();
        j r105 = this.f28351b;
        r105.a(r103 - r101, r104 - r102);
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
