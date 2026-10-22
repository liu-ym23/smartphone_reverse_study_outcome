package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final h f11782m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IMonitor f11783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f11784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f11785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Renderer f11786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EGLConfigChooser f11788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EGLContextFactory f11789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EGLWindowSurfaceFactory f11790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GLWrapper f11791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11793k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f11794l;

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 r10, EGLDisplay r11);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 r10, EGLDisplay r11, EGLConfig r12);

        void destroyContext(EGL10 r10, EGLDisplay r11, EGLContext r12);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 r10, EGLDisplay r11, EGLConfig r12, Object r13);

        void destroySurface(EGL10 r10, EGLDisplay r11, EGLSurface r12);
    }

    public interface GLWrapper {
        GL wrap(GL r10);
    }

    public interface Renderer {
        void onDrawFrame(GL10 r10);

        void onSurfaceChanged(GL10 r10, int r11, int r12);

        void onSurfaceCreated(GL10 r10, EGLConfig r11);

        void onSurfaceDestroyed(GL10 r10);
    }

    public static /* synthetic */ class a {
    }

    public abstract class b implements EGLConfigChooser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f11795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f11796b;

        public b(GLTextureView r10, int[] r11) {
            this.f11796b = r10;
            this.f11795a = b(r11);
        }

        public abstract EGLConfig a(EGL10 r10, EGLDisplay r11, EGLConfig[] r12);

        public final int[] b(int[] r10) {
            if (GLTextureView.c(this.f11796b) == 2) goto L5;
            return r10;
        L5:
            int r11 = r10.length;
            int[] r12 = new int[r11 + 2];
            int r13 = r11 - 1;
            System.arraycopy(r10, 0, r12, 0, r13);
            r12[r13] = 12352;
            r12[r11] = 4;
            r12[r11 + 1] = 12344;
            return r12;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 r10, EGLDisplay r11) {
            int[] r12 = new int[1];
            if (r10.eglChooseConfig(r11, this.f11795a, null, 0, r12) == false) goto L17;
            int r13 = r12[0];
            if (r13 <= 0) goto L16;
            EGLConfig[] r14 = new EGLConfig[r13];
            if (r10.eglChooseConfig(r11, this.f11795a, r14, r13, r12) == false) goto L14;
            EGLConfig r15 = a(r10, r11, r14);
            if (r15 == null) goto L12;
            return r15;
        L12:
            throw new IllegalArgumentException("No config chosen");
        L14:
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        L16:
            throw new IllegalArgumentException("No configs match configSpec");
        L17:
            GLTextureView.d(this.f11796b, false, Log.getStackTraceString(new IllegalArgumentException("eglChooseConfig failed")));
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f11797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11799e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11800f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11801g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f11802h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11803i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f11804j;

        public c(GLTextureView r16, int r17, int r18, int r19, int r20, int r21, int r22) {
            this.f11804j = r16;
            super(r16, new int[]{12324, r17, 12323, r18, 12322, r19, 12321, r20, 12325, r21, 12326, r22, 12344});
            this.f11797c = new int[1];
            this.f11798d = r17;
            this.f11799e = r18;
            this.f11800f = r19;
            this.f11801g = r20;
            this.f11802h = r21;
            this.f11803i = r22;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.b
        public EGLConfig a(EGL10 r13, EGLDisplay r14, EGLConfig[] r15) {
            int r10 = r15.length;
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L18;
            EGLConfig r12 = r15[r11];
            int r16 = c(r13, r14, r12, 12325, 0);
            int r17 = c(r13, r14, r12, 12326, 0);
            if (r16 < this.f11802h) goto L17;
            if (r17 < this.f11803i) goto L17;
            int r18 = c(r13, r14, r12, 12324, 0);
            int r19 = c(r13, r14, r12, 12323, 0);
            int r110 = c(r13, r14, r12, 12322, 0);
            int r20 = c(r13, r14, r12, 12321, 0);
            if (r18 != this.f11798d) goto L17;
            if (r19 != this.f11799e) goto L17;
            if (r110 != this.f11800f) goto L17;
            if (r20 != this.f11801g) goto L17;
            return r12;
        L17:
            r11 = r11 + 1;
            goto L3
        L18:
            return null;
        }

        public final int c(EGL10 r10, EGLDisplay r11, EGLConfig r12, int r13, int r14) {
            if (r10.eglGetConfigAttrib(r11, r12, r13, this.f11797c) == true) goto L5;
            return r14;
        L5:
            return this.f11797c[0];
        }
    }

    public class d implements EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f11806b;

        public d(GLTextureView r10) {
            this.f11806b = r10;
            this.f11805a = 12440;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 r10, EGLDisplay r11, EGLConfig r12) {
            int[] r13 = {this.f11805a, GLTextureView.c(this.f11806b), 12344};
            EGLContext r14 = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.c(this.f11806b) != 0) goto L7;
            r13 = null;
        L7:
            return r10.eglCreateContext(r11, r12, r14, r13);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 r10, EGLDisplay r11, EGLContext r12) {
            if (r10.eglDestroyContext(r11, r12) == true) goto L6;
            Log.e("DefaultContextFactory", "display:" + r11 + " context: " + r12);
            StringBuilder r13 = new StringBuilder();
            r13.append("tid=");
            r13.append(Thread.currentThread().getId());
            Log.i("DefaultContextFactory", r13.toString());
            f.k("eglDestroyContex", r10.eglGetError());
            return;
        }

        public /* synthetic */ d(GLTextureView r10, a r11) {
            this(r10);
        }
    }

    public static class e implements EGLWindowSurfaceFactory {
        public e() {
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 r10, EGLDisplay r11, EGLConfig r12, Object r13) {
            return r10.eglCreateWindowSurface(r11, r12, r13, null);
        L5:
            e = move-exception;
            Log.e("GLTextureView", "eglCreateWindowSurface", e);
            return null;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 r10, EGLDisplay r11, EGLSurface r12) {
            r10.eglDestroySurface(r11, r12);
        }

        public /* synthetic */ e(a r10) {
            this();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference f11807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public EGL10 f11808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EGLDisplay f11809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public EGLSurface f11810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public EGLConfig f11811e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EGLContext f11812f;

        public f(WeakReference r10) {
            this.f11807a = r10;
        }

        public static String f(String r10, int r11) {
            return r10 + " failed: " + r11;
        }

        public static void g(String r10, String r11, int r12) {
            Log.w(r10, f(r11, r12));
        }

        public static void k(String r10, int r11) {
            Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + f(r10, r11));
        }

        public GL a() {
            GL r10 = this.f11812f.getGL();
            GLTextureView r11 = (GLTextureView) this.f11807a.get();
            if (r11 != null) goto L5;
            return r10;
        L5:
            if (GLTextureView.h(r11) == null) goto L8;
            r10 = GLTextureView.h(r11).wrap(r10);
        L8:
            if ((GLTextureView.i(r11) & 3) == 0) goto L20;
            int r12 = 1;
            if ((GLTextureView.i(r11) & 1) != 0) goto L14;
            r12 = 0;
        L14:
            if ((GLTextureView.i(r11) & 2) == 0) goto L16;
            i r13 = new i();
        L18:
            return GLDebugHelper.wrap(r10, r12, r13);
        L16:
            r13 = null;
            goto L18
        L20:
            return r10;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f11808b == null) goto L32;
            if (this.f11809c == null) goto L30;
            if (this.f11811e == null) goto L28;
            d();
            GLTextureView r10 = (GLTextureView) this.f11807a.get();
            if (r10 == null) goto L11;
            this.f11810d = GLTextureView.g(r10).createWindowSurface(this.f11808b, this.f11809c, this.f11811e, r10.getSurfaceTexture());
        L12:
            EGLSurface r11 = this.f11810d;
            if (r11 == null) goto L24;
            if (r11 == EGL10.EGL_NO_SURFACE) goto L24;
            if (this.f11808b.eglMakeCurrent(this.f11809c, r11, r11, this.f11812f) == true) goto L21;
            g("EGLHelper", "eglMakeCurrent", this.f11808b.eglGetError());
            return false;
        L21:
            return true;
        L24:
            if (this.f11808b.eglGetError() != 12299) goto L26;
            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
        L26:
            return false;
        L11:
            this.f11810d = null;
            goto L12
        L28:
            throw new RuntimeException("mEglConfig not initialized");
        L30:
            throw new RuntimeException("eglDisplay not initialized");
        L32:
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            d();
        }

        public final void d() {
            EGLSurface r10 = this.f11810d;
            if (r10 == null) goto L11;
            EGLSurface r11 = EGL10.EGL_NO_SURFACE;
            if (r10 == r11) goto L12;
            this.f11808b.eglMakeCurrent(this.f11809c, r11, r11, EGL10.EGL_NO_CONTEXT);
            GLTextureView r12 = (GLTextureView) this.f11807a.get();
            if (r12 == null) goto L9;
            GLTextureView.g(r12).destroySurface(this.f11808b, this.f11809c, this.f11810d);
        L9:
            this.f11810d = null;
            return;
        L12:
            return;
        }

        public void e() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f11812f == null) goto L8;
            GLTextureView r10 = (GLTextureView) this.f11807a.get();
            if (r10 == null) goto L7;
            GLTextureView.f(r10).destroyContext(this.f11808b, this.f11809c, this.f11812f);
        L7:
            this.f11812f = null;
        L8:
            EGLDisplay r11 = this.f11809c;
            if (r11 == null) goto L12;
            this.f11808b.eglTerminate(r11);
            this.f11809c = null;
            return;
        }

        public void h() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 r10 = (EGL10) EGLContext.getEGL();
            this.f11808b = r10;
            EGLDisplay r11 = r10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f11809c = r11;
            if (r11 == EGL10.EGL_NO_DISPLAY) goto L20;
            if (this.f11808b.eglInitialize(r11, new int[2]) == false) goto L18;
            GLTextureView r12 = (GLTextureView) this.f11807a.get();
            if (r12 != null) goto L9;
            this.f11811e = null;
            this.f11812f = null;
        L10:
            EGLContext r13 = this.f11812f;
            if (r13 != null) goto L13;
        L14:
            this.f11812f = null;
            j("createContext");
        L15:
            Log.w("EglHelper", "createContext " + this.f11812f + " tid=" + Thread.currentThread().getId());
            this.f11810d = null;
            return;
        L13:
            if (r13 != EGL10.EGL_NO_CONTEXT) goto L15;
        L9:
            this.f11811e = GLTextureView.e(r12).chooseConfig(this.f11808b, this.f11809c);
            this.f11812f = GLTextureView.f(r12).createContext(this.f11808b, this.f11809c, this.f11811e);
            goto L10
        L18:
            throw new RuntimeException("eglInitialize failed");
        L20:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int i() {
            if (this.f11808b.eglSwapBuffers(this.f11809c, this.f11810d) == false) goto L5;
            return 12288;
        L5:
            return this.f11808b.eglGetError();
        }

        public final void j(String r10) {
            k(r10, this.f11808b.eglGetError());
        }
    }

    public static class g extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11817e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f11818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f11819g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f11820h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11821i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f11822j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11823k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f11824l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f11825m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f11826n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f11827o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ArrayList f11828p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f11829q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public f f11830r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public WeakReference f11831s;

        public g(WeakReference r10) {
            this.f11828p = new ArrayList();
            this.f11829q = true;
            this.f11823k = 0;
            this.f11824l = 0;
            this.f11826n = true;
            this.f11825m = 1;
            this.f11831s = r10;
        }

        public static /* synthetic */ boolean b(g r10, boolean r11) {
            r10.f11814b = r11;
            return r11;
        }

        public boolean a() {
            if (this.f11820h == true) goto L5;
        L9:
            return false;
        L5:
            if (this.f11821i == false) goto L9;
            if (h() == false) goto L9;
            return true;
        }

        public int c() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            int r11 = this.f11825m;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return r11;
        L7:
            th = move-exception;
            throw th;
        }

        public final void d() {
            this.f11830r = new f(this.f11831s);
            this.f11820h = false;
            this.f11821i = false;
            boolean r10 = false;
            boolean r11 = false;
            boolean r12 = false;
            boolean r13 = false;
            boolean r14 = false;
            boolean r15 = false;
            boolean r16 = false;
            boolean r17 = false;
            int r18 = 0;
            int r19 = 0;
            GL10 r20 = null;
        L3:
            Runnable r110 = null;
        L167:
            h r111 = GLTextureView.j();     // Catch: Throwable -> L95
            monitor-enter(r111);     // Catch: Throwable -> L95
        L162:
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L95
        L7:
            if (this.f11813a == true) goto L8;
            if (this.f11828p.isEmpty() == false) goto L21;
            boolean r21 = this.f11816d;     // Catch: Throwable -> L17
            boolean r22 = this.f11815c;     // Catch: Throwable -> L17
            if (r21 == r22) goto L25;
            this.f11816d = r22;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
            boolean r112 = r22;
            Log.i("GLThread", "mPaused is now " + this.f11816d + " tid=" + getId());     // Catch: Throwable -> L17
        L27:
            if (this.f11822j == false) goto L29;
            Log.i("GLThread", "releasing EGL context because asked to tid=" + getId());     // Catch: Throwable -> L17
            n();     // Catch: Throwable -> L17
            m();     // Catch: Throwable -> L17
            this.f11822j = false;     // Catch: Throwable -> L17
            r17 = true;
        L29:
            if (r13 == false) goto L31;
            n();     // Catch: Throwable -> L17
            m();     // Catch: Throwable -> L17
            r13 = false;
        L31:
            if (r112 == true) goto L33;
        L35:
            if (r112 == true) goto L37;
        L46:
            if (r112 == false) goto L51;
            if (GLTextureView.j().e() == false) goto L51;
            this.f11830r.e();     // Catch: Throwable -> L17
            Log.i("GLThread", "terminating EGL because paused tid=" + getId());     // Catch: Throwable -> L17
        L51:
            if (this.f11817e == true) goto L59;
            if (this.f11819g == true) goto L59;
            Log.i("GLThread", "noticed surfaceView surface lost tid=" + getId());     // Catch: Throwable -> L17
            if (this.f11821i == false) goto L57;
            n();     // Catch: Throwable -> L17
        L57:
            this.f11819g = true;     // Catch: Throwable -> L17
            this.f11818f = false;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
        L59:
            if (this.f11817e == true) goto L61;
        L63:
            if (r16 == false) goto L66;
            Log.i("GLThread", "sending render notification tid=" + getId());     // Catch: Throwable -> L17
            this.f11827o = true;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
            r15 = false;
            r16 = false;
        L66:
            if (h() == true) goto L68;
            r10 = r10;
        L145:
            Log.i("GLThread", "waiting tid=" + getId() + " mHaveEglContext: " + this.f11820h + " mHaveEglSurface: " + this.f11821i + " mPaused: " + this.f11816d + " mHasSurface: " + this.f11817e + " mSurfaceIsBad: " + this.f11818f + " mWaitingForSurface: " + this.f11819g + " mWidth: " + this.f11823k + " mHeight: " + this.f11824l + " mRequestRender: " + this.f11826n + " mRenderMode: " + this.f11825m);     // Catch: Throwable -> L17
            GLTextureView.j().wait();     // Catch: Throwable -> L17
            r10 = r10;
            r20 = r20;
            goto L162
        L68:
            if (this.f11820h == true) goto L79;
            if (r17 == false) goto L72;
            r10 = r10;
            r17 = false;
        L81:
            if (this.f11820h == false) goto L86;
            if (this.f11821i == true) goto L86;
            this.f11821i = true;     // Catch: Throwable -> L17
            r11 = true;
            r12 = true;
            r14 = true;
        L86:
            if (this.f11821i == false) goto L145;
            if (this.f11829q == false) goto L90;
            r18 = this.f11823k;     // Catch: Throwable -> L17
            r19 = this.f11824l;     // Catch: Throwable -> L17
            Log.i("GLThread", "noticing that we want render notification tid=" + getId());     // Catch: Throwable -> L17
            this.f11829q = false;     // Catch: Throwable -> L17
            boolean r23 = false;
            r11 = true;
            r14 = true;
            r15 = true;
        L91:
            this.f11826n = r23;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
        L92:
            monitor-exit(r111);     // Catch: Throwable -> L17
            if (r110 != null) goto L94;
            if (r11 == false) goto L110;
            Log.w("GLThread", "egl createSurface");     // Catch: Throwable -> L95
            if (this.f11830r.b() == false) goto L100;
            r11 = r23;
            goto L110
        L100:
            h r24 = GLTextureView.j();     // Catch: Throwable -> L95
            monitor-enter(r24);     // Catch: Throwable -> L95
            this.f11818f = true;     // Catch: Throwable -> L106
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L106
            monitor-exit(r24);     // Catch: Throwable -> L106
            r20 = r20;
            goto L167
        L106:
            th = move-exception;
            throw th;     // Catch: Throwable -> L95
        L110:
            if (r12 == false) goto L112;
            GL10 r25 = (GL10) this.f11830r.a();     // Catch: Throwable -> L95
            GLTextureView.j().a(r25);     // Catch: Throwable -> L95
            r12 = r23;
            GL10 r26 = r25;
        L113:
            if (r10 == false) goto L118;
            Log.w("GLThread", "onSurfaceCreated");     // Catch: Throwable -> L95
            GLTextureView r27 = (GLTextureView) this.f11831s.get();     // Catch: Throwable -> L95
            if (r27 == null) goto L117;
            GLTextureView.b(r27).onSurfaceCreated(r26, this.f11830r.f11811e);     // Catch: Throwable -> L95
        L117:
            r10 = r23;
        L118:
            if (r14 == false) goto L123;
            Log.w("GLThread", "onSurfaceChanged(" + r18 + ", " + r19 + ")");     // Catch: Throwable -> L95
            GLTextureView r28 = (GLTextureView) this.f11831s.get();     // Catch: Throwable -> L95
            if (r28 == null) goto L122;
            GLTextureView.b(r28).onSurfaceChanged(r26, r18, r19);     // Catch: Throwable -> L95
        L122:
            r14 = r23;
        L123:
            StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L95
            r113.append("onDrawFrame tid=");     // Catch: Throwable -> L95
            boolean r114 = r10;
            boolean r29 = r11;
            r113.append(getId());     // Catch: Throwable -> L95
            Log.w("GLThread", r113.toString());     // Catch: Throwable -> L95
            GLTextureView r30 = (GLTextureView) this.f11831s.get();     // Catch: Throwable -> L95
            if (r30 == null) goto L126;
            GLTextureView.b(r30).onDrawFrame(r26);     // Catch: Throwable -> L95
        L126:
            int r31 = this.f11830r.i();     // Catch: Throwable -> L95
            if (r31 == 12288) goto L141;
            if (r31 == 12302) goto L139;
            f.g("GLThread", "eglSwapBuffers", r31);     // Catch: Throwable -> L95
            h r32 = GLTextureView.j();     // Catch: Throwable -> L95
            monitor-enter(r32);     // Catch: Throwable -> L95
            this.f11818f = true;     // Catch: Throwable -> L136
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L136
            monitor-exit(r32);     // Catch: Throwable -> L136
        L136:
            th = move-exception;
            throw th;     // Catch: Throwable -> L95
        L139:
            Log.i("GLThread", "egl context lost tid=" + getId());     // Catch: Throwable -> L95
            r13 = true;
        L141:
            if (r15 == false) goto L143;
            r16 = true;
        L143:
            r11 = r29;
            r20 = r26;
            r10 = r114;
            goto L167
        L112:
            r26 = r20;
            goto L113
        L94:
            r110.run();     // Catch: Throwable -> L95
            r20 = r20;
            goto L3
        L90:
            r23 = false;
            goto L91
        L72:
            if (GLTextureView.j().g(this) == false) goto L79;
            this.f11830r.h();     // Catch: Throwable -> L17 RuntimeException -> L76
        L75:
            this.f11820h = true;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
            r10 = true;
        L76:
            e = move-exception;
            GLTextureView.j().c(this);     // Catch: Throwable -> L17
            throw e;     // Catch: Throwable -> L17
        L79:
            r10 = r10;
            goto L81
        L61:
            if (this.f11819g == false) goto L63;
            Log.i("GLThread", "noticed surfaceView surface acquired tid=" + getId());     // Catch: Throwable -> L17
            this.f11819g = false;     // Catch: Throwable -> L17
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L17
            goto L63
        L37:
            if (this.f11820h == false) goto L46;
            GLTextureView r33 = (GLTextureView) this.f11831s.get();     // Catch: Throwable -> L17
            if (r33 != null) goto L41;
            boolean r34 = false;
        L42:
            if (r34 == true) goto L44;
        L45:
            m();     // Catch: Throwable -> L17
            Log.i("GLThread", "releasing EGL context because paused tid=" + getId());     // Catch: Throwable -> L17
            goto L46
        L44:
            if (GLTextureView.j().d() == false) goto L46;
        L41:
            r34 = GLTextureView.a(r33);     // Catch: Throwable -> L17
            goto L42
        L33:
            if (this.f11821i == false) goto L35;
            Log.i("GLThread", "releasing EGL surface because paused tid=" + getId());     // Catch: Throwable -> L17
            n();     // Catch: Throwable -> L17
            goto L35
        L25:
            r112 = false;
            goto L27
        L21:
            r110 = (Runnable) this.f11828p.remove(0);     // Catch: Throwable -> L17
            r20 = r20;
            r23 = false;
            goto L92
        L8:
            monitor-exit(r111);     // Catch: Throwable -> L17
            h r35 = GLTextureView.j();
            monitor-enter(r35);
            n();     // Catch: Throwable -> L14
            m();     // Catch: Throwable -> L14
            monitor-exit(r35);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L95:
            th = move-exception;
            monitor-enter(GLTextureView.j());
            n();     // Catch: Throwable -> L153
            m();     // Catch: Throwable -> L153
            throw th;
        L153:
            th = move-exception;
            throw th;
        }

        public void e() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            Log.i("GLThread", "onPause tid=" + getId());     // Catch: Throwable -> L12
            this.f11815c = true;     // Catch: Throwable -> L12
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L12
        L6:
            if (this.f11814b == true) goto L15;
            if (this.f11816d == true) goto L15;
            Log.i("Main thread", "onPause waiting for mPaused.");     // Catch: Throwable -> L12
            GLTextureView.j().wait();     // Catch: Throwable -> L12 InterruptedException -> L14
        L14:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L12
        L15:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void f(int r10, int r11) {
            h r12 = GLTextureView.j();
            monitor-enter(r12);
            this.f11823k = r10;     // Catch: Throwable -> L16
            this.f11824l = r11;     // Catch: Throwable -> L16
            this.f11829q = true;     // Catch: Throwable -> L16
            this.f11826n = true;     // Catch: Throwable -> L16
            this.f11827o = false;     // Catch: Throwable -> L16
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L16
        L6:
            if (this.f11814b == true) goto L19;
            if (this.f11816d == true) goto L19;
            if (this.f11827o == true) goto L19;
            if (a() == false) goto L19;
            Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());     // Catch: Throwable -> L16
            GLTextureView.j().wait();     // Catch: Throwable -> L16 InterruptedException -> L18
        L18:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L16
        L19:
            monitor-exit(r12);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void g(Runnable r10) {
            if (r10 == null) goto L12;
            h r11 = GLTextureView.j();
            monitor-enter(r11);
            this.f11828p.add(r10);     // Catch: Throwable -> L8
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }

        public final boolean h() {
            if (this.f11816d == false) goto L5;
        L17:
            return false;
        L5:
            if (this.f11817e == false) goto L17;
            if (this.f11818f == true) goto L17;
            if (this.f11823k <= 0) goto L17;
            if (this.f11824l <= 0) goto L17;
            if (this.f11826n == false) goto L15;
            return true;
        L15:
            if (this.f11825m != 1) goto L17;
            return true;
        }

        public void i() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            this.f11813a = true;     // Catch: Throwable -> L10
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L10
        L7:
            if (this.f11814b == true) goto L13;
            GLTextureView.j().wait();     // Catch: Throwable -> L10 InterruptedException -> L12
        L12:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L10
            goto L7
        L13:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public void j() {
            this.f11822j = true;
            GLTextureView.j().notifyAll();
        }

        public void k() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            this.f11826n = true;     // Catch: Throwable -> L8
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void l(int r10) {
            if (r10 < 0) goto L14;
            if (r10 > 1) goto L14;
            h r11 = GLTextureView.j();
            monitor-enter(r11);
            this.f11825m = r10;     // Catch: Throwable -> L10
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }

        public final void m() {
            if (this.f11820h == false) goto L6;
            this.f11830r.e();
            this.f11820h = false;
            GLTextureView.j().c(this);
            return;
        }

        public final void n() {
            if (this.f11821i == false) goto L6;
            this.f11821i = false;
            this.f11830r.c();
            return;
        }

        public void o() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            Log.i("GLThread", "surfaceCreated tid=" + getId());     // Catch: Throwable -> L11
            this.f11817e = true;     // Catch: Throwable -> L11
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L11
        L6:
            if (this.f11819g == false) goto L14;
            if (this.f11814b == true) goto L14;
            GLTextureView.j().wait();     // Catch: Throwable -> L11 InterruptedException -> L13
        L13:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L11
        L14:
            monitor-exit(r10);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public void p() {
            h r10 = GLTextureView.j();
            monitor-enter(r10);
            Log.i("GLThread", "surfaceDestroyed tid=" + getId());     // Catch: Throwable -> L11
            this.f11817e = false;     // Catch: Throwable -> L11
            GLTextureView.j().notifyAll();     // Catch: Throwable -> L11
        L6:
            if (this.f11819g == true) goto L14;
            if (this.f11814b == true) goto L14;
            GLTextureView.j().wait();     // Catch: Throwable -> L11 InterruptedException -> L13
        L13:
            Thread.currentThread().interrupt();     // Catch: Throwable -> L11
        L14:
            monitor-exit(r10);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            Log.i("GLThread", "starting tid=" + getId());
            d();     // Catch: InterruptedException -> L9 Throwable -> L5
        L5:
            th = move-exception;
            GLTextureView.j().f(this);
            throw th;
        L4:
            GLTextureView.j().f(this);
        }
    }

    public static class h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static String f11832g = "GLThreadManager";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f11833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f11835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f11837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g f11838f;

        static {
        }

        public h() {
        }

        public synchronized void a(GL10 r10) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.f11835c == true) goto L11;
            b();     // Catch: Throwable -> L8
            String r11 = r10.glGetString(7937);     // Catch: Throwable -> L8
            if (this.f11834b >= 131072) goto L10;
            this.f11836d = !r11.startsWith("Q3Dimension MSM7500 ");     // Catch: Throwable -> L8
            notifyAll();     // Catch: Throwable -> L8
        L10:
            this.f11837e = !this.f11836d;     // Catch: Throwable -> L8
            Log.w(f11832g, "checkGLDriver renderer = \"" + r11 + "\" multipleContextsAllowed = " + this.f11836d + " mLimitedGLESContexts = " + this.f11837e);     // Catch: Throwable -> L8
            this.f11835c = true;     // Catch: Throwable -> L8
        L11:
            monitor-exit(this);
        }

        public final void b() {
            if (this.f11833a == true) goto L6;
            this.f11833a = true;
            return;
        }

        public void c(g r10) {
            if (this.f11838f != r10) goto L5;
            this.f11838f = null;
        L5:
            notifyAll();
        }

        public synchronized boolean d() {
            monitor-enter(this);
            boolean r10 = this.f11837e;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r10;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean e() {
            monitor-enter(this);
            b();     // Catch: Throwable -> L7
            boolean r10 = !this.f11836d;
            monitor-exit(this);
            return r10;
        L7:
            th = move-exception;
            throw th;
        }

        public synchronized void f(g r10) {
            monitor-enter(this);
            Log.i("GLThread", "exiting tid=" + r10.getId());     // Catch: Throwable -> L6
            g.b(r10, true);     // Catch: Throwable -> L6
            if (this.f11838f != r10) goto L8;
            this.f11838f = null;     // Catch: Throwable -> L6
        L8:
            notifyAll();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public boolean g(g r10) {
            g r11 = this.f11838f;
            if (r11 == r10) goto L14;
            if (r11 == null) goto L14;
            b();
            if (this.f11836d == false) goto L9;
            return true;
        L9:
            g r12 = this.f11838f;
            if (r12 == null) goto L16;
            r12.j();
            return false;
        L16:
            return false;
        L14:
            this.f11838f = r10;
            notifyAll();
            return true;
        }

        public /* synthetic */ h(a r10) {
            this();
        }
    }

    public static class i extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StringBuilder f11839a;

        public i() {
            this.f11839a = new StringBuilder();
        }

        public final void a() {
            if (this.f11839a.length() <= 0) goto L6;
            Log.v("GLTextureView", this.f11839a.toString());
            StringBuilder r10 = this.f11839a;
            r10.delete(0, r10.length());
            return;
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
        public void write(char[] r10, int r11, int r12) {
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            char r14 = r10[r11 + r13];
            if (r14 != '\n') goto L7;
            a();
        L8:
            r13 = r13 + 1;
            goto L3
        L7:
            this.f11839a.append(r14);
            goto L8
        }
    }

    public class j extends c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ GLTextureView f11840k;

        public j(GLTextureView r10, boolean r11) {
            this.f11840k = r10;
            if (r11 == false) goto L6;
            int r12 = 16;
        L7:
            super(r10, 8, 8, 8, 0, r12, 0);
            return;
        L6:
            r12 = 0;
            goto L7
        }
    }

    static {
        f11782m = new h(null);
    }

    public GLTextureView(Context r10) {
        super(r10);
        this.f11784b = new WeakReference(this);
        l();
    }

    public static /* synthetic */ boolean a(GLTextureView r10) {
        return r10.f11794l;
    }

    public static /* synthetic */ Renderer b(GLTextureView r10) {
        return r10.f11786d;
    }

    public static /* synthetic */ int c(GLTextureView r10) {
        return r10.f11793k;
    }

    public static /* synthetic */ void d(GLTextureView r10, boolean r11, String r12) {
        r10.n(r11, r12);
    }

    public static /* synthetic */ EGLConfigChooser e(GLTextureView r10) {
        return r10.f11788f;
    }

    public static /* synthetic */ EGLContextFactory f(GLTextureView r10) {
        return r10.f11789g;
    }

    public static /* synthetic */ EGLWindowSurfaceFactory g(GLTextureView r10) {
        return r10.f11790h;
    }

    public static /* synthetic */ GLWrapper h(GLTextureView r10) {
        return r10.f11791i;
    }

    public static /* synthetic */ int i(GLTextureView r10) {
        return r10.f11792j;
    }

    public static /* synthetic */ h j() {
        return f11782m;
    }

    public void finalize() {
        g r10 = this.f11785c;     // Catch: Throwable -> L6
        if (r10 == null) goto L8;
        r10.i();     // Catch: Throwable -> L6
    L8:
        super.finalize();
        return;
    L6:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getDebugFlags() {
        return this.f11792j;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f11794l;
    }

    public int getRenderMode() {
        return this.f11785c.c();
    }

    public final void k() {
        if (this.f11785c != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public final void l() {
        setSurfaceTextureListener(this);
    }

    public void m(Runnable r10) {
        this.f11785c.g(r10);
    }

    public final void n(boolean r10, String r11) {
        IMonitor r12 = this.f11783a;
        if (r12 == null) goto L6;
        r12.monitor(r10, "unknown", 0, 0, r11);
        return;
    }

    public void o(int r10, int r11, int r12, int r13, int r14, int r15) {
        setEGLConfigChooser(new c(this, r10, r11, r12, r13, r14, r15));
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.f11787e);
        if (this.f11787e == true) goto L5;
    L14:
        this.f11787e = false;
        return;
    L5:
        if (this.f11786d == null) goto L14;
        g r10 = this.f11785c;
        if (r10 == null) goto L9;
        int r11 = r10.c();
    L10:
        g r12 = new g(this.f11784b);
        this.f11785c = r12;
        if (r11 == 1) goto L13;
        r12.l(r11);
    L13:
        this.f11785c.start();
        goto L14
    L9:
        r11 = 1;
        goto L10
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        g r10 = this.f11785c;
        if (r10 == null) goto L5;
        r10.i();
    L5:
        this.f11787e = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        p(getSurfaceTexture(), 0, r13 - r11, r14 - r12);
    }

    public void onPause() {
        this.f11785c.e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r10, int r11, int r12) {
        q(r10);
        p(r10, 0, r11, r12);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r10) {
        r(r10);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r10, int r11, int r12) {
        p(r10, 0, r11, r12);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r10) {
    }

    public void p(SurfaceTexture r10, int r11, int r12, int r13) {
        this.f11785c.f(r12, r13);
    }

    public void q(SurfaceTexture r10) {
        this.f11785c.o();
    }

    public void r(SurfaceTexture r10) {
        this.f11785c.p();
    }

    public void requestRender() {
        this.f11785c.k();
    }

    public void setDebugFlags(int r10) {
        this.f11792j = r10;
    }

    public void setEGLConfigChooser(EGLConfigChooser r10) {
        k();
        this.f11788f = r10;
    }

    public void setEGLContextClientVersion(int r10) {
        k();
        this.f11793k = r10;
    }

    public void setEGLContextFactory(EGLContextFactory r10) {
        k();
        this.f11789g = r10;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory r10) {
        k();
        this.f11790h = r10;
    }

    public void setGLWrapper(GLWrapper r10) {
        this.f11791i = r10;
    }

    public void setMonitor(IMonitor r10) {
        this.f11783a = r10;
    }

    public void setPreserveEGLContextOnPause(boolean r10) {
        this.f11794l = r10;
    }

    public void setRenderMode(int r10) {
        this.f11785c.l(r10);
    }

    public void setRenderer(Renderer r10) {
        k();
        if (this.f11788f != null) goto L5;
        this.f11788f = new j(this, true);
    L5:
        a r11 = null;
        if (this.f11789g != null) goto L9;
        this.f11789g = new d(this, r11);
    L9:
        if (this.f11790h != null) goto L11;
        this.f11790h = new e(r11);
    L11:
        this.f11786d = r10;
        g r12 = new g(this.f11784b);
        this.f11785c = r12;
        r12.start();
    }

    public void setEGLConfigChooser(boolean r10) {
        setEGLConfigChooser(new j(this, r10));
    }

    public GLTextureView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f11784b = new WeakReference(this);
        l();
    }
}
