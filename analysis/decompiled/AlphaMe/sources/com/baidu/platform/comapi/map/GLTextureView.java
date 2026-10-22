package com.baidu.platform.comapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.alibaba.fastjson.util.UTF8Decoder;
import com.baidu.platform.comapi.util.EglConfigUtils;
import com.baidu.platform.gl.GLThreadShareLock;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final h f8787a = new h(null);

    /* renamed from: b, reason: collision with root package name */
    private int f8788b;

    /* renamed from: c, reason: collision with root package name */
    private final View.OnLayoutChangeListener f8789c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<GLTextureView> f8790d;

    /* renamed from: e, reason: collision with root package name */
    private g f8791e;

    /* renamed from: f, reason: collision with root package name */
    private SurfaceRenderer f8792f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8793g;

    /* renamed from: h, reason: collision with root package name */
    private GLSurfaceView.EGLConfigChooser f8794h;

    /* renamed from: i, reason: collision with root package name */
    private GLSurfaceView.EGLContextFactory f8795i;

    /* renamed from: j, reason: collision with root package name */
    private GLSurfaceView.EGLWindowSurfaceFactory f8796j;

    /* renamed from: k, reason: collision with root package name */
    private GLSurfaceView.GLWrapper f8797k;

    /* renamed from: l, reason: collision with root package name */
    private int f8798l;

    /* renamed from: m, reason: collision with root package name */
    private int f8799m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8800n;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            GLTextureView gLTextureView = GLTextureView.this;
            gLTextureView.onSurfaceTextureSizeChanged(gLTextureView.getSurfaceTexture(), i6 - i4, i7 - i5);
        }
    }

    public abstract class b implements GLSurfaceView.EGLConfigChooser {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f8802a;

        public b(int[] iArr) {
            this.f8802a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (GLTextureView.this.f8799m != 2 && GLTextureView.this.f8799m != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i4 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            iArr2[i4] = 12352;
            if (GLTextureView.this.f8799m == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f8802a, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i4 = iArr[0];
            if (i4 <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i4];
            if (!egl10.eglChooseConfig(eGLDisplay, this.f8802a, eGLConfigArr, i4, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigA = a(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigA != null) {
                return eGLConfigA;
            }
            throw new IllegalArgumentException("No config chosen");
        }
    }

    public static class e implements GLSurfaceView.EGLWindowSurfaceFactory {
        private e() {
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e4) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e4);
                return null;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GLTextureView> f8815a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f8816b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f8817c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f8818d;

        /* renamed from: e, reason: collision with root package name */
        EGLConfig f8819e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f8820f;

        public f(WeakReference<GLTextureView> weakReference) {
            this.f8815a = weakReference;
        }

        public static void a(String str, String str2, int i4) {
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f8818d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f8816b.eglMakeCurrent(this.f8817c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f8815a.get();
            if (gLTextureView != null) {
                gLTextureView.f8796j.destroySurface(this.f8816b, this.f8817c, this.f8818d);
            }
            this.f8818d = null;
        }

        public boolean b() {
            Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
            if (this.f8816b == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.f8817c == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.f8819e == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            d();
            GLTextureView gLTextureView = this.f8815a.get();
            if (gLTextureView != null) {
                this.f8818d = gLTextureView.f8796j.createWindowSurface(this.f8816b, this.f8817c, this.f8819e, gLTextureView.getSurfaceTexture());
            } else {
                this.f8818d = null;
            }
            EGLSurface eGLSurface = this.f8818d;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.f8816b.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (this.f8816b.eglMakeCurrent(this.f8817c, eGLSurface, eGLSurface, this.f8820f)) {
                return true;
            }
            a("EGLHelper", "eglMakeCurrent", this.f8816b.eglGetError());
            return false;
        }

        public void c() {
            Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
            d();
        }

        public void e() {
            Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
            if (this.f8820f != null) {
                GLTextureView gLTextureView = this.f8815a.get();
                if (gLTextureView != null) {
                    gLTextureView.f8795i.destroyContext(this.f8816b, this.f8817c, this.f8820f);
                }
                this.f8820f = null;
            }
            EGLDisplay eGLDisplay = this.f8817c;
            if (eGLDisplay != null) {
                this.f8816b.eglTerminate(eGLDisplay);
                this.f8817c = null;
            }
        }

        public void f() {
            Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f8816b = egl10;
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f8817c = eGLDisplayEglGetDisplay;
            if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.f8816b.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            GLTextureView gLTextureView = this.f8815a.get();
            if (gLTextureView == null) {
                this.f8819e = null;
                this.f8820f = null;
            } else {
                this.f8819e = gLTextureView.f8794h.chooseConfig(this.f8816b, this.f8817c);
                this.f8820f = gLTextureView.f8795i.createContext(this.f8816b, this.f8817c, this.f8819e);
            }
            EGLContext eGLContext = this.f8820f;
            if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                this.f8820f = null;
                a("createContext");
            }
            Log.w("EglHelper", "createContext " + this.f8820f + " tid=" + Thread.currentThread().getId());
            this.f8818d = null;
        }

        public int g() {
            if (this.f8816b.eglSwapBuffers(this.f8817c, this.f8818d)) {
                return 12288;
            }
            return this.f8816b.eglGetError();
        }

        public GL a() {
            GL gl = this.f8820f.getGL();
            GLTextureView gLTextureView = this.f8815a.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.f8797k != null) {
                gl = gLTextureView.f8797k.wrap(gl);
            }
            if ((gLTextureView.f8798l & 3) != 0) {
                return GLDebugHelper.wrap(gl, (gLTextureView.f8798l & 1) == 0 ? 0 : 1, (gLTextureView.f8798l & 2) != 0 ? new i() : null);
            }
            return gl;
        }

        private void a(String str) {
            b(str, this.f8816b.eglGetError());
        }

        public static String a(String str, int i4) {
            return str + " EGL failed code: " + i4;
        }

        public static void b(String str, int i4) {
            throw new RuntimeException(a(str, i4));
        }
    }

    public static class g extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8821a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f8822b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f8823c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8824d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f8825e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8826f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8827g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f8828h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f8829i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f8830j;

        /* renamed from: o, reason: collision with root package name */
        private boolean f8835o;

        /* renamed from: r, reason: collision with root package name */
        private f f8838r;

        /* renamed from: s, reason: collision with root package name */
        private WeakReference<GLTextureView> f8839s;

        /* renamed from: p, reason: collision with root package name */
        private ArrayList<Runnable> f8836p = new ArrayList<>();

        /* renamed from: q, reason: collision with root package name */
        private boolean f8837q = true;

        /* renamed from: k, reason: collision with root package name */
        private int f8831k = 0;

        /* renamed from: l, reason: collision with root package name */
        private int f8832l = 0;

        /* renamed from: n, reason: collision with root package name */
        private boolean f8834n = true;

        /* renamed from: m, reason: collision with root package name */
        private int f8833m = 1;

        public g(WeakReference<GLTextureView> weakReference) {
            this.f8839s = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:160:0x035b  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x0364 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:166:0x0373 A[Catch: all -> 0x0252, TryCatch #1 {all -> 0x0252, blocks: (B:4:0x001c, B:5:0x001e, B:106:0x024a, B:110:0x0257, B:112:0x0266, B:113:0x0268, B:120:0x0277, B:123:0x027b, B:126:0x0291, B:128:0x02a2, B:135:0x02c4, B:137:0x02ef, B:139:0x02f7, B:141:0x0305, B:143:0x0313, B:147:0x0321, B:148:0x032a, B:155:0x0337, B:157:0x033b, B:161:0x035c, B:164:0x0366, B:166:0x0373, B:167:0x0375, B:173:0x037d, B:179:0x039c, B:6:0x001f, B:8:0x0023, B:19:0x0035, B:21:0x003d, B:104:0x0247, B:22:0x004b, B:24:0x0051, B:26:0x005c, B:28:0x0089, B:31:0x008f, B:33:0x00b3, B:35:0x00bc, B:38:0x00c2, B:40:0x00df, B:42:0x00e3, B:44:0x00ed, B:46:0x00f3, B:48:0x00fd, B:50:0x0102, B:52:0x011c, B:54:0x0126, B:56:0x012d, B:57:0x0145, B:59:0x0149, B:62:0x014f, B:64:0x016b, B:65:0x016e, B:66:0x0179, B:68:0x017d, B:71:0x0183, B:74:0x01a7, B:75:0x01c9, B:77:0x01cf, B:90:0x01fd, B:92:0x0201, B:94:0x0205, B:95:0x020b, B:97:0x020f, B:99:0x0213, B:101:0x0219, B:103:0x023e, B:177:0x038e, B:81:0x01d9, B:83:0x01e3, B:85:0x01e9, B:87:0x01f3, B:88:0x01fa, B:150:0x032c, B:151:0x0331, B:115:0x026a, B:116:0x026f, B:168:0x0376, B:169:0x0379), top: B:189:0x001c, inners: #0, #3, #4, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:175:0x0385  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x020f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void c() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instructions count: 939
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comapi.map.GLTextureView.g.c():void");
        }

        private boolean f() {
            return !this.f8824d && this.f8825e && !this.f8826f && this.f8831k > 0 && this.f8832l > 0 && (this.f8834n || this.f8833m == 1);
        }

        private void j() {
            if (this.f8828h) {
                this.f8838r.e();
                this.f8828h = false;
                GLTextureView.f8787a.a(this);
            }
        }

        private void k() {
            if (this.f8829i) {
                this.f8829i = false;
                this.f8838r.c();
            }
        }

        public int b() {
            int i4;
            synchronized (GLThreadShareLock.LOCK) {
                i4 = this.f8833m;
            }
            return i4;
        }

        public void d() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                Log.i("GLThread", "onPause tid=" + getId());
                this.f8823c = true;
                obj.notifyAll();
                while (!this.f8822b && !this.f8824d) {
                    Log.i("Main thread", "onPause waiting for mPaused.");
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void e() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                Log.i("GLThread", "onResume tid=" + getId());
                this.f8823c = false;
                this.f8834n = true;
                this.f8835o = false;
                obj.notifyAll();
                while (!this.f8822b && this.f8824d && !this.f8835o) {
                    Log.i("Main thread", "onResume waiting for !mPaused.");
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void g() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f8821a = true;
                obj.notifyAll();
                while (!this.f8822b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void h() {
            this.f8830j = true;
            GLThreadShareLock.LOCK.notifyAll();
        }

        public void i() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f8834n = true;
                obj.notifyAll();
            }
        }

        public void l() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f8825e = true;
                obj.notifyAll();
                while (this.f8827g && !this.f8822b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void m() {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f8825e = false;
                obj.notifyAll();
                while (!this.f8827g && !this.f8822b) {
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                c();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.f8787a.b(this);
                throw th;
            }
            GLTextureView.f8787a.b(this);
        }

        public boolean a() {
            return this.f8828h && this.f8829i && f();
        }

        public void a(int i4) {
            if (i4 >= 0 && i4 <= 1) {
                Object obj = GLThreadShareLock.LOCK;
                synchronized (obj) {
                    this.f8833m = i4;
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }

        public void a(int i4, int i5) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                this.f8831k = i4;
                this.f8832l = i5;
                this.f8837q = true;
                this.f8834n = true;
                this.f8835o = false;
                obj.notifyAll();
                while (!this.f8822b && !this.f8824d && !this.f8835o && a()) {
                    Log.i("Main thread", "onWindowResize waiting for render complete from tid=" + getId());
                    try {
                        GLThreadShareLock.LOCK.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void a(Runnable runnable) {
            if (runnable != null) {
                Object obj = GLThreadShareLock.LOCK;
                synchronized (obj) {
                    this.f8836p.add(runnable);
                    obj.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private static String f8840a = "GLThreadManager";

        /* renamed from: b, reason: collision with root package name */
        private static final Class f8841b;

        /* renamed from: c, reason: collision with root package name */
        private static final Method f8842c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f8843d;

        /* renamed from: e, reason: collision with root package name */
        private int f8844e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f8845f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8846g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f8847h;

        /* renamed from: i, reason: collision with root package name */
        private g f8848i;

        static {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f8841b = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                f8842c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }

        private h() {
        }

        public void a(g gVar) {
            if (this.f8848i == gVar) {
                this.f8848i = null;
            }
            GLThreadShareLock.LOCK.notifyAll();
        }

        public void b(g gVar) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                try {
                    gVar.f8822b = true;
                    if (this.f8848i == gVar) {
                        this.f8848i = null;
                    }
                    obj.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean c(g gVar) {
            g gVar2 = this.f8848i;
            if (gVar2 == gVar || gVar2 == null) {
                this.f8848i = gVar;
                GLThreadShareLock.LOCK.notifyAll();
                return true;
            }
            a();
            if (this.f8846g) {
                return true;
            }
            g gVar3 = this.f8848i;
            if (gVar3 == null) {
                return false;
            }
            gVar3.h();
            return false;
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        public void a(GL10 gl10) {
            Object obj = GLThreadShareLock.LOCK;
            synchronized (obj) {
                try {
                    if (!this.f8845f) {
                        a();
                        String strGlGetString = gl10.glGetString(7937);
                        if (this.f8844e < 131072) {
                            this.f8846g = !strGlGetString.startsWith("Q3Dimension MSM7500 ");
                            obj.notifyAll();
                        }
                        this.f8847h = !this.f8846g;
                        Log.w(f8840a, "checkGLDriver renderer = \"" + strGlGetString + "\" multipleContextsAllowed = " + this.f8846g + " mLimitedGLESContexts = " + this.f8847h);
                        this.f8845f = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b() {
            boolean z4;
            synchronized (GLThreadShareLock.LOCK) {
                z4 = this.f8847h;
            }
            return z4;
        }

        public boolean c() {
            boolean z4;
            synchronized (GLThreadShareLock.LOCK) {
                a();
                z4 = !this.f8846g;
            }
            return z4;
        }

        private void a() {
            if (this.f8843d) {
                return;
            }
            try {
                this.f8844e = ((Integer) f8842c.invoke(null, "ro.opengles.version", 0)).intValue();
            } catch (Exception unused) {
                this.f8844e = UTF8Decoder.Surrogate.UCS4_MIN;
            }
            if (this.f8844e >= 131072) {
                this.f8846g = true;
            }
            Log.w(f8840a, "checkGLESVersion mGLESVersion = " + this.f8844e + " mMultipleGLESContextsAllowed = " + this.f8846g);
            this.f8843d = true;
        }
    }

    public static class i extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private StringBuilder f8849a = new StringBuilder();

        private void a() {
            if (this.f8849a.length() > 0) {
                StringBuilder sb = this.f8849a;
                sb.delete(0, sb.length());
            }
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
        public void write(char[] cArr, int i4, int i5) {
            for (int i6 = 0; i6 < i5; i6++) {
                char c4 = cArr[i4 + i6];
                if (c4 == '\n') {
                    a();
                } else {
                    this.f8849a.append(c4);
                }
            }
        }
    }

    public class j extends c {
        public j(boolean z4) {
            super(8, 8, 8, 0, z4 ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.f8788b = 60;
        this.f8789c = new a();
        this.f8790d = new WeakReference<>(this);
        c();
    }

    public Bitmap captureImageFromSurface(int i4, int i5, int i6, int i7, Object obj, Bitmap.Config config) {
        return a(i4, i5, i6, i7, (GL10) obj, config);
    }

    public void finalize() throws Throwable {
        try {
            g gVar = this.f8791e;
            if (gVar != null) {
                gVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.f8798l;
    }

    public int getFPS() {
        return this.f8788b;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.f8800n;
    }

    public int getRenderMode() {
        return this.f8791e.b();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("GLTextureView", "onAttachedToWindow reattach =" + this.f8793g);
        if (this.f8793g && this.f8792f != null) {
            g gVar = this.f8791e;
            int iB = gVar != null ? gVar.b() : 1;
            g gVar2 = new g(this.f8790d);
            this.f8791e = gVar2;
            if (iB != 1) {
                gVar2.a(iB);
            }
            this.f8791e.start();
        }
        this.f8793g = false;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Log.d("GLTextureView", "onDetachedFromWindow");
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.g();
        }
        this.f8793g = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.d();
        }
    }

    public void onResume() {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
        surfaceChanged(surfaceTexture, 0, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.a(runnable);
        }
    }

    public void requestRender() {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.i();
        }
    }

    public void setDebugFlags(int i4) {
        this.f8798l = i4;
    }

    public void setEGLConfigChooser(GLSurfaceView.EGLConfigChooser eGLConfigChooser) {
        b();
        this.f8794h = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i4) {
        b();
        this.f8799m = i4;
    }

    public void setEGLContextFactory(GLSurfaceView.EGLContextFactory eGLContextFactory) {
        b();
        this.f8795i = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(GLSurfaceView.EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        b();
        this.f8796j = eGLWindowSurfaceFactory;
    }

    public void setFPS(int i4) {
        this.f8788b = i4;
    }

    public void setGLWrapper(GLSurfaceView.GLWrapper gLWrapper) {
        this.f8797k = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z4) {
        this.f8800n = z4;
    }

    public void setRenderMode(int i4) {
        this.f8791e.a(i4);
    }

    public void setRenderer(SurfaceRenderer surfaceRenderer) {
        b();
        if (this.f8794h == null) {
            try {
                if (EglConfigUtils.isSupportConfig(8, 8, 8, 0, 24, 8, 0, 0)) {
                    setEGLConfigChooser(8, 8, 8, 0, 24, 8);
                } else {
                    setEGLConfigChooser(true);
                }
            } catch (IllegalArgumentException unused) {
                setEGLConfigChooser(true);
            }
        }
        a aVar = null;
        if (this.f8795i == null) {
            this.f8795i = new d(this, aVar);
        }
        if (this.f8796j == null) {
            this.f8796j = new e(aVar);
        }
        this.f8792f = surfaceRenderer;
        g gVar = new g(this.f8790d);
        this.f8791e = gVar;
        gVar.start();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i4, int i5, int i6) {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.a(i5, i6);
        }
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.l();
        }
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        g gVar = this.f8791e;
        if (gVar != null) {
            gVar.m();
        }
    }

    public class d implements GLSurfaceView.EGLContextFactory {

        /* renamed from: a, reason: collision with root package name */
        private int f8813a;

        private d() {
            this.f8813a = 12440;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f8813a, GLTextureView.this.f8799m, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.f8799m == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            f.b("eglDestroyContex", egl10.eglGetError());
        }

        public /* synthetic */ d(GLTextureView gLTextureView, a aVar) {
            this();
        }
    }

    private void b() {
        if (this.f8791e != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void c() {
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(this.f8789c);
    }

    private Bitmap a(int i4, int i5, int i6, int i7, GL10 gl10, Bitmap.Config config) {
        int i8 = i6 * i7;
        int[] iArr = new int[i8];
        int[] iArr2 = new int[i8];
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        intBufferWrap.position(0);
        try {
            gl10.glReadPixels(i4, i5, i6, i7, 6408, 5121, intBufferWrap);
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = i9 * i6;
                int i11 = ((i7 - i9) - 1) * i6;
                for (int i12 = 0; i12 < i6; i12++) {
                    int i13 = iArr[i10 + i12];
                    iArr2[i11 + i12] = (i13 & (-16711936)) | ((i13 << 16) & 16711680) | ((i13 >> 16) & 255);
                }
            }
            if (config == null) {
                return Bitmap.createBitmap(iArr2, i6, i7, Bitmap.Config.ARGB_8888);
            }
            return Bitmap.createBitmap(iArr2, i6, i7, config);
        } catch (GLException unused) {
            return null;
        } catch (OutOfMemoryError e4) {
            Log.e("OutOfMemoryError", " createBitmap cause OutOfMemoryError : " + e4.getMessage());
            return null;
        }
    }

    public void setEGLConfigChooser(boolean z4) {
        setEGLConfigChooser(new j(z4));
    }

    public void setEGLConfigChooser(int i4, int i5, int i6, int i7, int i8, int i9) {
        setEGLConfigChooser(new c(i4, i5, i6, i7, i8, i9));
    }

    public void setEGLConfigChooser(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        setEGLConfigChooser(new c(i4, i5, i6, i7, i8, i9, i10));
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8788b = 60;
        this.f8789c = new a();
        this.f8790d = new WeakReference<>(this);
        c();
    }

    public class c extends b {

        /* renamed from: c, reason: collision with root package name */
        private int[] f8804c;

        /* renamed from: d, reason: collision with root package name */
        protected int f8805d;

        /* renamed from: e, reason: collision with root package name */
        protected int f8806e;

        /* renamed from: f, reason: collision with root package name */
        protected int f8807f;

        /* renamed from: g, reason: collision with root package name */
        protected int f8808g;

        /* renamed from: h, reason: collision with root package name */
        protected int f8809h;

        /* renamed from: i, reason: collision with root package name */
        protected int f8810i;

        /* renamed from: j, reason: collision with root package name */
        protected int f8811j;

        public c(int i4, int i5, int i6, int i7, int i8, int i9) {
            super(new int[]{12324, i4, 12323, i5, 12322, i6, 12321, i7, 12325, i8, 12326, i9, 12344});
            this.f8804c = new int[1];
            this.f8805d = i4;
            this.f8806e = i5;
            this.f8807f = i6;
            this.f8808g = i7;
            this.f8809h = i8;
            this.f8810i = i9;
            this.f8811j = 1;
        }

        @Override // com.baidu.platform.comapi.map.GLTextureView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            EGLConfig eGLConfig = null;
            for (EGLConfig eGLConfig2 : eGLConfigArr) {
                int iA = a(egl10, eGLDisplay, eGLConfig2, 12325, 0);
                int iA2 = a(egl10, eGLDisplay, eGLConfig2, 12326, 0);
                if (iA >= this.f8809h && iA2 >= this.f8810i) {
                    int iA3 = a(egl10, eGLDisplay, eGLConfig2, 12324, 0);
                    int iA4 = a(egl10, eGLDisplay, eGLConfig2, 12323, 0);
                    int iA5 = a(egl10, eGLDisplay, eGLConfig2, 12322, 0);
                    int iA6 = a(egl10, eGLDisplay, eGLConfig2, 12321, 0);
                    if (iA3 == this.f8805d && iA4 == this.f8806e && iA5 == this.f8807f && iA6 == this.f8808g) {
                        if (eGLConfig == null) {
                            eGLConfig = eGLConfig2;
                        }
                        if (a(egl10, eGLDisplay, eGLConfig2, 12337, 0) == this.f8811j) {
                            return eGLConfig2;
                        }
                    }
                }
            }
            return eGLConfig;
        }

        public c(int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
            super(new int[]{12324, i4, 12323, i5, 12322, i6, 12321, i7, 12325, i8, 12326, i9, 12338, 1, 12337, i10, 12344});
            this.f8804c = new int[1];
            this.f8805d = i4;
            this.f8806e = i5;
            this.f8807f = i6;
            this.f8808g = i7;
            this.f8809h = i8;
            this.f8810i = i9;
            this.f8811j = i10;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i4, int i5) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i4, this.f8804c) ? this.f8804c[0] : i5;
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f8788b = 60;
        this.f8789c = new a();
        this.f8790d = new WeakReference<>(this);
        c();
    }
}
