package com.bef.effectsdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.Writer;
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

/* JADX INFO: loaded from: classes39.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = true;
    private static final boolean LOG_EGL = true;
    private static final boolean LOG_PAUSE_RESUME = true;
    private static final boolean LOG_RENDERER = true;
    private static final boolean LOG_RENDERER_DRAW_FRAME = true;
    private static final boolean LOG_SURFACE = true;
    private static final boolean LOG_THREADS = true;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLTextureView";
    private static final GLThreadManager sGLThreadManager = null;
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    SurfaceTexture mPrevSurfaceTexture;
    private GLSurfaceView.Renderer mRenderer;
    private final WeakReference<GLTextureView> mThisWeakRef;

    /* JADX INFO: renamed from: com.bef.effectsdk.GLTextureView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;
        final /* synthetic */ GLTextureView this$0;

        public abstract EGLConfig chooseConfig(EGL10 r100, EGLDisplay r101, EGLConfig[] r102);

        private int[] filterConfigSpec(int[] r100) {
            if (GLTextureView.access$200(this.this$0) != 2) goto L7;
            int r101 = r100.length;
            int[] r102 = new int[r101 + 2];
            int r103 = r101 - 1;
            System.arraycopy(r100, 0, r102, 0, r103);
            r102[r103] = 12352;
            r102[r101] = 4;
            r102[r101 + 1] = 12344;
            return r102;
        L7:
            if (GLTextureView.access$200(this.this$0) != 3) goto L10;
            int r104 = r100.length;
            int[] r105 = new int[r104 + 2];
            int r106 = r104 - 1;
            System.arraycopy(r100, 0, r105, 0, r106);
            r105[r106] = 12352;
            r105[r104] = 64;
            r105[r104 + 1] = 12344;
            return r105;
        L10:
            return r100;
        }

        public BaseConfigChooser(GLTextureView r100, int[] r101) {
            this.this$0 = r100;
            this.mConfigSpec = filterConfigSpec(r101);
        }

        @Override // com.bef.effectsdk.GLTextureView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 r100, EGLDisplay r110) {
            int[] r101 = new int[1];
            if (r100.eglChooseConfig(r110, this.mConfigSpec, null, 0, r101) == false) goto L18;
            int r102 = r101[0];
            if (r102 <= 0) goto L16;
            EGLConfig[] r103 = new EGLConfig[r102];
            if (r100.eglChooseConfig(r110, this.mConfigSpec, r103, r102, r101) == false) goto L14;
            EGLConfig r104 = chooseConfig(r100, r110, r103);
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

    public class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;
        final /* synthetic */ GLTextureView this$0;

        @Override // com.bef.effectsdk.GLTextureView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 r110, EGLDisplay r111, EGLConfig[] r112) {
            int r100 = r112.length;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L18;
            EGLConfig r102 = r112[r101];
            int r103 = findConfigAttrib(r110, r111, r102, 12325, 0);
            int r104 = findConfigAttrib(r110, r111, r102, 12326, 0);
            if (r103 < this.mDepthSize) goto L17;
            if (r104 < this.mStencilSize) goto L17;
            int r105 = findConfigAttrib(r110, r111, r102, 12324, 0);
            int r113 = findConfigAttrib(r110, r111, r102, 12323, 0);
            int r114 = findConfigAttrib(r110, r111, r102, 12322, 0);
            int r106 = findConfigAttrib(r110, r111, r102, 12321, 0);
            if (r105 != this.mRedSize) goto L17;
            if (r113 != this.mGreenSize) goto L17;
            if (r114 != this.mBlueSize) goto L17;
            if (r106 != this.mAlphaSize) goto L17;
            return r102;
        L17:
            r101 = r101 + 1;
            goto L3
        L18:
            return null;
        }

        private int findConfigAttrib(EGL10 r100, EGLDisplay r101, EGLConfig r102, int r103, int r104) {
            if (r100.eglGetConfigAttrib(r101, r102, r103, this.mValue) == true) goto L5;
            return r104;
        L5:
            return this.mValue[0];
        }

        public ComponentSizeChooser(GLTextureView r100, int r101, int r102, int r103, int r104, int r110, int r111) {
            this.this$0 = r100;
            super(r100, new int[]{12324, r101, 12323, r102, 12322, r103, 12321, r104, 12325, r110, 12326, r111, 12344});
            this.mValue = new int[1];
            this.mRedSize = r101;
            this.mGreenSize = r102;
            this.mBlueSize = r103;
            this.mAlphaSize = r104;
            this.mDepthSize = r110;
            this.mStencilSize = r111;
        }
    }

    public class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;
        final /* synthetic */ GLTextureView this$0;

        private DefaultContextFactory(GLTextureView r100) {
            this.this$0 = r100;
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public /* synthetic */ DefaultContextFactory(GLTextureView r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.bef.effectsdk.GLTextureView.EGLContextFactory
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r110) {
            EGLContext r102 = r100.eglCreateContext(r101, r110, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 3, 12344});
            GLTextureView.access$202(this.this$0, 3);
            EGLContext r103 = EGL10.EGL_NO_CONTEXT;
            if (r102 != r103) goto L7;
            r102 = r100.eglCreateContext(r101, r110, r103, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
            GLTextureView.access$202(this.this$0, 2);
            if (r102 != EGL10.EGL_NO_CONTEXT) goto L7;
            GLTextureView.access$202(this.this$0, 0);
        L7:
            return r102;
        }

        @Override // com.bef.effectsdk.GLTextureView.EGLContextFactory
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r100.eglDestroyContext(r101, r102) == true) goto L6;
            Objects.toString(r101);
            Objects.toString(r102);
            ThreadMethodProxy.currentThread().getId();
            EglHelper.throwEglException("eglDestroyContex", r100.eglGetError());
            return;
        }
    }

    public static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public /* synthetic */ DefaultWindowSurfaceFactory(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bef.effectsdk.GLTextureView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 r100, EGLDisplay r101, EGLSurface r102) {
            r100.eglDestroySurface(r101, r102);
        }

        @Override // com.bef.effectsdk.GLTextureView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 r100, EGLDisplay r101, EGLConfig r102, Object r103) {
            return r100.eglCreateWindowSurface(r101, r102, r103, null);
        L8:
            return null;
        }
    }

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 r100, EGLDisplay r101);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102);

        void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 r100, EGLDisplay r101, EGLConfig r102, Object r103);

        void destroySurface(EGL10 r100, EGLDisplay r101, EGLSurface r102);
    }

    public static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLTextureViewWeakRef;

        private void destroySurfaceImp() {
            EGLSurface r100 = this.mEglSurface;
            if (r100 == null) goto L11;
            EGLSurface r101 = EGL10.EGL_NO_SURFACE;
            if (r100 == r101) goto L12;
            this.mEgl.eglMakeCurrent(this.mEglDisplay, r101, r101, EGL10.EGL_NO_CONTEXT);
            GLTextureView r102 = this.mGLTextureViewWeakRef.get();
            if (r102 == null) goto L9;
            GLTextureView.access$500(r102).destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
        L9:
            this.mEglSurface = null;
            return;
        L12:
            return;
        }

        public GL createGL() {
            GL r100 = this.mEglContext.getGL();
            GLTextureView r101 = this.mGLTextureViewWeakRef.get();
            if (r101 != null) goto L5;
            return r100;
        L5:
            if (GLTextureView.access$600(r101) == null) goto L8;
            r100 = GLTextureView.access$600(r101).wrap(r100);
        L8:
            if ((GLTextureView.access$700(r101) & 3) == 0) goto L20;
            int r102 = 1;
            if ((GLTextureView.access$700(r101) & 1) != 0) goto L14;
            r102 = 0;
        L14:
            if ((GLTextureView.access$700(r101) & 2) == 0) goto L16;
            LogWriter r103 = new LogWriter();
        L18:
            return GLDebugHelper.wrap(r100, r102, r103);
        L16:
            r103 = null;
            goto L18
        L20:
            return r100;
        }

        public boolean createSurface() {
            ThreadMethodProxy.currentThread().getId();
            if (this.mEgl == null) goto L30;
            if (this.mEglDisplay == null) goto L28;
            if (this.mEglConfig == null) goto L26;
            destroySurfaceImp();
            GLTextureView r100 = this.mGLTextureViewWeakRef.get();
            if (r100 == null) goto L11;
            this.mEglSurface = GLTextureView.access$500(r100).createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, r100.getSurfaceTexture());
        L12:
            EGLSurface r101 = this.mEglSurface;
            if (r101 != null) goto L15;
        L23:
            this.mEgl.eglGetError();
            return false;
        L15:
            if (r101 == EGL10.EGL_NO_SURFACE) goto L23;
            if (this.mEgl.eglMakeCurrent(this.mEglDisplay, r101, r101, this.mEglContext) == true) goto L21;
            logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
            return false;
        L21:
            return true;
        L11:
            this.mEglSurface = null;
            goto L12
        L26:
            throw new RuntimeException("mEglConfig not initialized");
        L28:
            throw new RuntimeException("eglDisplay not initialized");
        L30:
            throw new RuntimeException("egl not initialized");
        }

        public void destroySurface() {
            ThreadMethodProxy.currentThread().getId();
            destroySurfaceImp();
        }

        public void finish() {
            ThreadMethodProxy.currentThread().getId();
            if (this.mEglContext == null) goto L8;
            GLTextureView r100 = this.mGLTextureViewWeakRef.get();
            if (r100 == null) goto L7;
            GLTextureView.access$400(r100).destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
        L7:
            this.mEglContext = null;
        L8:
            EGLDisplay r101 = this.mEglDisplay;
            if (r101 == null) goto L12;
            this.mEgl.eglTerminate(r101);
            this.mEglDisplay = null;
            return;
        }

        public void start() {
            ThreadMethodProxy.currentThread().getId();
            EGL10 r100 = (EGL10) EGLContext.getEGL();
            this.mEgl = r100;
            EGLDisplay r101 = r100.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = r101;
            if (r101 == EGL10.EGL_NO_DISPLAY) goto L20;
            EGL10 r102 = this.mEgl;
            if (r102.eglInitialize(r101, new int[2]) == false) goto L18;
            GLTextureView r103 = this.mGLTextureViewWeakRef.get();
            if (r103 != null) goto L9;
            this.mEglConfig = null;
            this.mEglContext = null;
        L10:
            EGLContext r104 = this.mEglContext;
            if (r104 != null) goto L13;
        L14:
            this.mEglContext = null;
            throwEglException("createContext");
        L15:
            Objects.toString(this.mEglContext);
            ThreadMethodProxy.currentThread().getId();
            this.mEglSurface = null;
            return;
        L13:
            if (r104 != EGL10.EGL_NO_CONTEXT) goto L15;
        L9:
            this.mEglConfig = GLTextureView.access$300(r103).chooseConfig(this.mEgl, this.mEglDisplay);
            this.mEglContext = GLTextureView.access$400(r103).createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            goto L10
        L18:
            throw new RuntimeException("eglInitialize failed");
        L20:
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface) == false) goto L5;
            return 12288;
        L5:
            return this.mEgl.eglGetError();
        }

        public EglHelper(WeakReference<GLTextureView> r100) {
            this.mGLTextureViewWeakRef = r100;
        }

        private void throwEglException(String r100) {
            throwEglException(r100, this.mEgl.eglGetError());
        }

        public static String formatEglError(String r100, int r101) {
            return r100 + " failed";
        }

        public static void throwEglException(String r100, int r101) {
            String r102 = formatEglError(r100, r101);
            ThreadMethodProxy.currentThread().getId();
            throw new RuntimeException(r102);
        }

        public static void logEglErrorAsWarning(String r100, String r101, int r102) {
            formatEglError(r101, r102);
        }
    }

    public static class GLThread extends PthreadThreadV2 {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<GLTextureView> mGLTextureViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode;
        private boolean mRequestPaused;
        private boolean mRequestRender;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth;

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.access$800().notifyAll();
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_bef_effectsdk_GLTextureView$GLThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void guardedRun() throws InterruptedException {
            this.mEglHelper = new EglHelper(this.mGLTextureViewWeakRef);
            this.mHaveEglContext = false;
            this.mHaveEglSurface = false;
            GL10 r100 = null;
            boolean r101 = false;
            boolean r102 = false;
            boolean r103 = false;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
            boolean r110 = false;
            boolean r111 = false;
            int r112 = 0;
            int r113 = 0;
        L3:
            Runnable r114 = null;
        L176:
            GLThreadManager r115 = GLTextureView.access$800();     // Catch: Throwable -> L154
            monitor-enter(r115);     // Catch: Throwable -> L154
        L171:
        L151:
            th = move-exception;
            throw th;     // Catch: Throwable -> L154
        L7:
            if (this.mHaveEglContext == false) goto L12;
            if (this.mEventQueue.isEmpty() == true) goto L12;
            r114 = this.mEventQueue.remove(0);     // Catch: Throwable -> L151
        L92:
            monitor-exit(r115);     // Catch: Throwable -> L151
            if (r102 == false) goto L114;
            if (this.mEglHelper.createSurface() == false) goto L105;
            GLThreadManager r107 = GLTextureView.access$800();     // Catch: Throwable -> L154
            monitor-enter(r107);     // Catch: Throwable -> L154
            this.mFinishedCreatingEglSurface = true;     // Catch: Throwable -> L102
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L102
            monitor-exit(r107);     // Catch: Throwable -> L102
            r102 = false;
            goto L114
        L102:
            th = move-exception;
            throw th;     // Catch: Throwable -> L154
        L105:
            GLThreadManager r108 = GLTextureView.access$800();     // Catch: Throwable -> L154
            monitor-enter(r108);     // Catch: Throwable -> L154
            this.mFinishedCreatingEglSurface = true;     // Catch: Throwable -> L111
            this.mSurfaceIsBad = true;     // Catch: Throwable -> L111
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L111
            monitor-exit(r108);     // Catch: Throwable -> L111
        L111:
            th = move-exception;
            throw th;     // Catch: Throwable -> L154
        L114:
            if (r103 == false) goto L116;
            r100 = (GL10) this.mEglHelper.createGL();     // Catch: Throwable -> L154
            GLTextureView.access$800().checkGLDriver(r100);     // Catch: Throwable -> L154
            r103 = false;
        L116:
            if (r101 == false) goto L121;
            GLTextureView r109 = this.mGLTextureViewWeakRef.get();     // Catch: Throwable -> L154
            if (r109 == null) goto L120;
            GLTextureView.access$1000(r109).onSurfaceCreated(r100, this.mEglHelper.mEglConfig);     // Catch: Throwable -> L154
        L120:
            r101 = false;
        L121:
            if (r114 != null) goto L122;
            if (r105 == false) goto L128;
            GLTextureView r116 = this.mGLTextureViewWeakRef.get();     // Catch: Throwable -> L154
            if (r116 == null) goto L127;
            GLTextureView.access$1000(r116).onSurfaceChanged(r100, r112, r113);     // Catch: Throwable -> L154
        L127:
            r105 = false;
        L128:
            getId();     // Catch: Throwable -> L154
            GLTextureView r117 = this.mGLTextureViewWeakRef.get();     // Catch: Throwable -> L154
            if (r117 == null) goto L131;
            GLTextureView.access$1000(r117).onDrawFrame(r100);     // Catch: Throwable -> L154
        L131:
            int r118 = this.mEglHelper.swap();     // Catch: Throwable -> L154
            if (r118 == 12288) goto L147;
            if (r118 == 12302) goto L144;
            EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r118);     // Catch: Throwable -> L154
            GLThreadManager r119 = GLTextureView.access$800();     // Catch: Throwable -> L154
            monitor-enter(r119);     // Catch: Throwable -> L154
            this.mSurfaceIsBad = true;     // Catch: Throwable -> L141
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L141
            monitor-exit(r119);     // Catch: Throwable -> L141
        L141:
            th = move-exception;
            throw th;     // Catch: Throwable -> L154
        L144:
            getId();     // Catch: Throwable -> L154
            r104 = true;
        L147:
            if (r106 == false) goto L176;
            r110 = true;
            goto L176
        L122:
            r114.run();     // Catch: Throwable -> L154
        L12:
            if (this.mShouldExit == true) goto L13;
            boolean r120 = this.mPaused;     // Catch: Throwable -> L151
            boolean r121 = this.mRequestPaused;     // Catch: Throwable -> L151
            if (r120 == r121) goto L26;
            this.mPaused = r121;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
            getId();     // Catch: Throwable -> L151
        L28:
            if (this.mShouldReleaseEglContext == false) goto L30;
            getId();     // Catch: Throwable -> L151
            this.mGLTextureViewWeakRef.get().onExitContext();     // Catch: Throwable -> L151
            stopEglSurfaceLocked();     // Catch: Throwable -> L151
            stopEglContextLocked();     // Catch: Throwable -> L151
            this.mShouldReleaseEglContext = false;     // Catch: Throwable -> L151
            r111 = true;
        L30:
            if (r104 == false) goto L32;
            this.mGLTextureViewWeakRef.get().onExitContext();     // Catch: Throwable -> L151
            stopEglSurfaceLocked();     // Catch: Throwable -> L151
            stopEglContextLocked();     // Catch: Throwable -> L151
            r104 = false;
        L32:
            if (r121 == true) goto L34;
        L36:
            if (r121 == true) goto L38;
        L47:
            if (r121 == false) goto L52;
            if (GLTextureView.access$800().shouldTerminateEGLWhenPausing() == false) goto L52;
            this.mEglHelper.finish();     // Catch: Throwable -> L151
            getId();     // Catch: Throwable -> L151
        L52:
            if (this.mHasSurface == true) goto L60;
            if (this.mWaitingForSurface == true) goto L60;
            getId();     // Catch: Throwable -> L151
            if (this.mHaveEglSurface == false) goto L58;
            stopEglSurfaceLocked();     // Catch: Throwable -> L151
        L58:
            this.mWaitingForSurface = true;     // Catch: Throwable -> L151
            this.mSurfaceIsBad = false;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
        L60:
            if (this.mHasSurface == true) goto L62;
        L64:
            if (r110 == false) goto L67;
            getId();     // Catch: Throwable -> L151
            this.mRenderComplete = true;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
            r106 = false;
            r110 = false;
        L67:
            if (readyToDraw() == false) goto L150;
            if (this.mHaveEglContext == true) goto L81;
            if (r111 == false) goto L73;
            r111 = false;
            goto L81
        L73:
            if (GLTextureView.access$800().tryAcquireEglContextLocked(this) == false) goto L81;
            this.mEglHelper.start();     // Catch: RuntimeException -> L77 Throwable -> L151
        L76:
            this.mHaveEglContext = true;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
            r101 = true;
        L77:
            e = move-exception;
            GLTextureView.access$800().releaseEglContextLocked(this);     // Catch: Throwable -> L151
            throw e;     // Catch: Throwable -> L151
        L81:
            if (this.mHaveEglContext == false) goto L86;
            if (this.mHaveEglSurface == true) goto L86;
            this.mHaveEglSurface = true;     // Catch: Throwable -> L151
            r102 = true;
            r103 = true;
            r105 = true;
        L86:
            if (this.mHaveEglSurface == false) goto L150;
            if (this.mSizeChanged == false) goto L90;
            int r122 = this.mWidth;     // Catch: Throwable -> L151
            int r123 = this.mHeight;     // Catch: Throwable -> L151
            getId();     // Catch: Throwable -> L151
            this.mSizeChanged = false;     // Catch: Throwable -> L151
            r112 = r122;
            r113 = r123;
            boolean r124 = false;
            r102 = true;
            r105 = true;
            r106 = true;
        L91:
            this.mRequestRender = r124;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
            goto L92
        L90:
            r124 = false;
        L150:
            getId();     // Catch: Throwable -> L151
            GLTextureView.access$800().wait();     // Catch: Throwable -> L151
            goto L171
        L62:
            if (this.mWaitingForSurface == false) goto L64;
            getId();     // Catch: Throwable -> L151
            this.mWaitingForSurface = false;     // Catch: Throwable -> L151
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L151
            goto L64
        L38:
            if (this.mHaveEglContext == false) goto L47;
            GLTextureView r125 = this.mGLTextureViewWeakRef.get();     // Catch: Throwable -> L151
            if (r125 != null) goto L42;
            boolean r126 = false;
        L43:
            if (r126 == true) goto L45;
        L46:
            stopEglContextLocked();     // Catch: Throwable -> L151
            getId();     // Catch: Throwable -> L151
            goto L47
        L45:
            if (GLTextureView.access$800().shouldReleaseEGLContextWhenPausing() == false) goto L47;
        L42:
            r126 = GLTextureView.access$900(r125);     // Catch: Throwable -> L151
            goto L43
        L34:
            if (this.mHaveEglSurface == false) goto L36;
            getId();     // Catch: Throwable -> L151
            stopEglSurfaceLocked();     // Catch: Throwable -> L151
            goto L36
        L26:
            r121 = false;
            goto L28
        L13:
            this.mGLTextureViewWeakRef.get().onExitContext();     // Catch: Throwable -> L151
            monitor-exit(r115);     // Catch: Throwable -> L151
            GLThreadManager r127 = GLTextureView.access$800();
            monitor-enter(r127);
            stopEglSurfaceLocked();     // Catch: Throwable -> L20
            stopEglContextLocked();     // Catch: Throwable -> L20
            monitor-exit(r127);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L154:
            th = move-exception;
            monitor-enter(GLTextureView.access$800());
            stopEglSurfaceLocked();     // Catch: Throwable -> L160
            stopEglContextLocked();     // Catch: Throwable -> L160
            throw th;
        L160:
            th = move-exception;
            throw th;
        }

        private boolean readyToDraw() {
            if (this.mPaused == false) goto L5;
        L17:
            return false;
        L5:
            if (this.mHasSurface == false) goto L17;
            if (this.mSurfaceIsBad == true) goto L17;
            if (this.mWidth <= 0) goto L17;
            if (this.mHeight <= 0) goto L17;
            if (this.mRequestRender == false) goto L15;
            return true;
        L15:
            if (this.mRenderMode != 1) goto L17;
            return true;
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext == false) goto L6;
            this.mEglHelper.finish();
            this.mHaveEglContext = false;
            GLTextureView.access$800().releaseEglContextLocked(this);
            return;
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface == false) goto L6;
            this.mHaveEglSurface = false;
            this.mEglHelper.destroySurface();
            return;
        }

        public boolean ableToDraw() {
            if (this.mHaveEglContext == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mHaveEglSurface == false) goto L9;
            if (readyToDraw() == false) goto L9;
            return true;
        }

        public void com_bef_effectsdk_GLTextureView$GLThread__run$___twin___() {
            ThreadMethodProxy.setName(this, "GLThread " + getId());
            getId();
            guardedRun();     // Catch: Throwable -> L9 Throwable -> L5
        L5:
            th = move-exception;
            GLTextureView.access$800().threadExiting(this);
            throw th;
        L4:
            GLTextureView.access$800().threadExiting(this);
        }

        public int getRenderMode() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            int r101 = this.mRenderMode;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public void onPause() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L14
            this.mRequestPaused = true;     // Catch: Throwable -> L14
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.mExited == true) goto L12;
            if (this.mPaused == true) goto L12;
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void onResume() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L16
            this.mRequestPaused = false;     // Catch: Throwable -> L16
            this.mRequestRender = true;     // Catch: Throwable -> L16
            this.mRenderComplete = false;     // Catch: Throwable -> L16
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L16
        L6:
            if (this.mExited == true) goto L14;
            if (this.mPaused == false) goto L14;
            if (this.mRenderComplete == true) goto L14;
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L13 Throwable -> L16
        L13:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void requestExitAndWait() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            this.mShouldExit = true;     // Catch: Throwable -> L13
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L13
        L7:
            if (this.mExited == true) goto L11;
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L10 Throwable -> L13
        L10:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public void requestRender() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            this.mRequestRender = true;     // Catch: Throwable -> L8
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void surfaceCreated() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L16
            this.mHasSurface = true;     // Catch: Throwable -> L16
            this.mFinishedCreatingEglSurface = false;     // Catch: Throwable -> L16
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L16
        L6:
            if (this.mWaitingForSurface == false) goto L14;
            if (this.mFinishedCreatingEglSurface == true) goto L14;
            if (this.mExited == true) goto L14;
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L13 Throwable -> L16
        L13:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
        L14:
            monitor-exit(r100);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        public void surfaceDestroyed() {
            GLThreadManager r100 = GLTextureView.access$800();
            monitor-enter(r100);
            getId();     // Catch: Throwable -> L14
            this.mHasSurface = false;     // Catch: Throwable -> L14
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L14
        L6:
            if (this.mWaitingForSurface == true) goto L12;
            if (this.mExited == true) goto L12;
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L11 Throwable -> L14
        L11:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public GLThread(WeakReference<GLTextureView> r100) {
            super("GLTextureView$GLThread");
            this.mEventQueue = new ArrayList();
            this.mSizeChanged = true;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mRequestRender = true;
            this.mRenderMode = 1;
            this.mGLTextureViewWeakRef = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bef_effectsdk_GLTextureView$GLThread_com_larus_apm_impl_protector_RunnableLancet_run(GLThread r100) {
            r100.com_bef_effectsdk_GLTextureView$GLThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public void queueEvent(Runnable r100) {
            if (r100 == null) goto L12;
            GLThreadManager r101 = GLTextureView.access$800();
            monitor-enter(r101);
            this.mEventQueue.add(r100);     // Catch: Throwable -> L8
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L12:
            throw new IllegalArgumentException("r must not be null");
        }

        public void setRenderMode(int r100) {
            if (r100 < 0) goto L14;
            if (r100 > 1) goto L14;
            GLThreadManager r101 = GLTextureView.access$800();
            monitor-enter(r101);
            this.mRenderMode = r100;     // Catch: Throwable -> L10
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r101);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new IllegalArgumentException("renderMode");
        }

        public static /* synthetic */ boolean access$1102(GLThread r100, boolean r101) {
            r100.mExited = r101;
            return r101;
        }

        public void onWindowResize(int r100, int r101) {
            GLThreadManager r102 = GLTextureView.access$800();
            monitor-enter(r102);
            this.mWidth = r100;     // Catch: Throwable -> L19
            this.mHeight = r101;     // Catch: Throwable -> L19
            this.mSizeChanged = true;     // Catch: Throwable -> L19
            this.mRequestRender = true;     // Catch: Throwable -> L19
            this.mRenderComplete = false;     // Catch: Throwable -> L19
            GLTextureView.access$800().notifyAll();     // Catch: Throwable -> L19
        L6:
            if (this.mExited == true) goto L17;
            if (this.mPaused == true) goto L17;
            if (this.mRenderComplete == true) goto L17;
            if (ableToDraw() == false) goto L17;
            getId();     // Catch: Throwable -> L19
            GLTextureView.access$800().wait();     // Catch: InterruptedException -> L16 Throwable -> L19
        L16:
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r102);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }
    }

    public static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            monitor-enter(this);
            boolean r100 = this.mLimitedGLESContexts;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r100;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            monitor-enter(this);
            checkGLESVersion();     // Catch: Throwable -> L7
            boolean r100 = !this.mMultipleGLESContextsAllowed;
            monitor-exit(this);
            return r100;
        L7:
            th = move-exception;
            throw th;
        }

        private void checkGLESVersion() {
            if (this.mGLESVersionCheckComplete == true) goto L6;
            this.mMultipleGLESContextsAllowed = true;
            this.mGLESVersionCheckComplete = true;
            return;
        }

        public /* synthetic */ GLThreadManager(AnonymousClass1 r100) {
            this();
        }

        public synchronized void checkGLDriver(GL10 r100) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (this.mGLESDriverCheckComplete == true) goto L16;
            checkGLESVersion();     // Catch: Throwable -> L18
            String r101 = r100.glGetString(7937);     // Catch: Throwable -> L18
            boolean r102 = false;
            if (this.mGLESVersion >= 131072) goto L13;
            if (r101.startsWith(kMSM7K_RENDERER_PREFIX) == true) goto L10;
            boolean r103 = true;
        L11:
            this.mMultipleGLESContextsAllowed = r103;     // Catch: Throwable -> L18
            notifyAll();     // Catch: Throwable -> L18
            goto L13
        L10:
            r103 = false;
        L13:
            if (this.mMultipleGLESContextsAllowed == true) goto L15;
            r102 = true;
        L15:
            this.mLimitedGLESContexts = r102;     // Catch: Throwable -> L18
            this.mGLESDriverCheckComplete = true;     // Catch: Throwable -> L18
        L16:
            monitor-exit(this);
        }

        public void releaseEglContextLocked(GLThread r100) {
            if (this.mEglOwner != r100) goto L5;
            this.mEglOwner = null;
        L5:
            notifyAll();
        }

        public synchronized void threadExiting(GLThread r100) {
            monitor-enter(this);
            r100.getId();     // Catch: Throwable -> L9
            GLThread.access$1102(r100, true);     // Catch: Throwable -> L9
            if (this.mEglOwner != r100) goto L6;
            this.mEglOwner = null;     // Catch: Throwable -> L9
        L6:
            notifyAll();     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public boolean tryAcquireEglContextLocked(GLThread r100) {
            GLThread r101 = this.mEglOwner;
            if (r101 == r100) goto L14;
            if (r101 == null) goto L14;
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed == false) goto L9;
            return true;
        L9:
            GLThread r102 = this.mEglOwner;
            if (r102 == null) goto L16;
            r102.requestReleaseEglContextLocked();
            return false;
        L16:
            return false;
        L14:
            this.mEglOwner = r100;
            notifyAll();
            return true;
        }
    }

    public interface GLWrapper {
        GL wrap(GL r100);
    }

    public static class LogWriter extends Writer {
        private StringBuilder mBuilder;

        private void flushBuilder() {
            if (this.mBuilder.length() <= 0) goto L6;
            this.mBuilder.toString();
            StringBuilder r100 = this.mBuilder;
            r100.delete(0, r100.length());
            return;
        }

        public LogWriter() {
            this.mBuilder = new StringBuilder();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] r100, int r101, int r102) {
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            char r104 = r100[r101 + r103];
            if (r104 != '\n') goto L7;
            flushBuilder();
        L8:
            r103 = r103 + 1;
            goto L3
        L7:
            this.mBuilder.append(r104);
            goto L8
        }
    }

    public class SimpleEGLConfigChooser extends ComponentSizeChooser {
        final /* synthetic */ GLTextureView this$0;

        public SimpleEGLConfigChooser(GLTextureView r100, boolean r110) {
            this.this$0 = r100;
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

    public void onExitContext() {
    }

    static {
        sGLThreadManager = new GLThreadManager(null);
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) goto L6;
        return;
    L6:
        throw new IllegalStateException("setRenderer has already been called for this instance.");
    }

    public void finalize() throws Throwable {
        GLThread r100 = this.mGLThread;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.requestExitAndWait();     // Catch: Throwable -> L7
    L5:
        super.finalize();
        return;
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void onDestroy() {
        SurfaceTexture r100 = this.mPrevSurfaceTexture;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        GLThread r100 = this.mGLThread;
        if (r100 == null) goto L5;
        r100.requestExitAndWait();
    L5:
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        if (this.mPrevSurfaceTexture == null) goto L7;
        SurfaceTexture r100 = getSurfaceTexture();
        SurfaceTexture r101 = this.mPrevSurfaceTexture;
        if (r100 == r101) goto L7;
        setSurfaceTexture(r101);
        this.mGLThread.surfaceCreated();
    L7:
        this.mGLThread.onResume();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached == true) goto L5;
    L14:
        this.mDetached = false;
        return;
    L5:
        if (this.mRenderer == null) goto L14;
        GLThread r100 = this.mGLThread;
        if (r100 == null) goto L9;
        int r101 = r100.getRenderMode();
    L10:
        GLThread r102 = new GLThread(this.mThisWeakRef);
        this.mGLThread = r102;
        if (r101 == 1) goto L13;
        r102.setRenderMode(r101);
    L13:
        this.mGLThread.onWindowResize(getWidth(), getHeight());
        ThreadMethodProxy.start(this.mGLThread);
        goto L14
    L9:
        r101 = 1;
        goto L10
    }

    public static /* synthetic */ GLThreadManager access$800() {
        return sGLThreadManager;
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public int getEGLContextClientVersion() {
        return this.mEGLContextClientVersion;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public GLTextureView(Context r100) {
        super(r100);
        this.mPrevSurfaceTexture = null;
        this.mThisWeakRef = new WeakReference(this);
        init();
    }

    public static /* synthetic */ GLSurfaceView.Renderer access$1000(GLTextureView r100) {
        return r100.mRenderer;
    }

    public static /* synthetic */ int access$200(GLTextureView r100) {
        return r100.mEGLContextClientVersion;
    }

    public static /* synthetic */ EGLConfigChooser access$300(GLTextureView r100) {
        return r100.mEGLConfigChooser;
    }

    public static /* synthetic */ EGLContextFactory access$400(GLTextureView r100) {
        return r100.mEGLContextFactory;
    }

    public static /* synthetic */ EGLWindowSurfaceFactory access$500(GLTextureView r100) {
        return r100.mEGLWindowSurfaceFactory;
    }

    public static /* synthetic */ GLWrapper access$600(GLTextureView r100) {
        return r100.mGLWrapper;
    }

    public static /* synthetic */ int access$700(GLTextureView r100) {
        return r100.mDebugFlags;
    }

    public static /* synthetic */ boolean access$900(GLTextureView r100) {
        return r100.mPreserveEGLContextOnPause;
    }

    public void on(SurfaceHolder r100) {
        this.mGLThread.surfaceCreated();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        GLThread r101 = this.mGLThread;
        if (r101 == null) goto L7;
        r101.surfaceDestroyed();
        return false;
    L7:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
        if (getRenderMode() == 0) goto L6;
        requestRender();
        return;
    }

    public void queueEvent(Runnable r100) {
        this.mGLThread.queueEvent(r100);
    }

    public void setDebugFlags(int r100) {
        this.mDebugFlags = r100;
    }

    public void setEGLConfigChooser(boolean r100) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(this, r100));
    }

    public void setEGLContextClientVersion(int r100) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = r100;
    }

    public void setEGLContextFactory(EGLContextFactory r100) {
        checkRenderThreadState();
        this.mEGLContextFactory = r100;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory r100) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = r100;
    }

    public void setGLWrapper(GLWrapper r100) {
        this.mGLWrapper = r100;
    }

    public void setPreserveEGLContextOnPause(boolean r100) {
        this.mPreserveEGLContextOnPause = r100;
    }

    public void setRenderMode(int r100) {
        this.mGLThread.setRenderMode(r100);
    }

    public void setRenderer(GLSurfaceView.Renderer r100) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser != null) goto L5;
        this.mEGLConfigChooser = new SimpleEGLConfigChooser(this, true);
    L5:
        AnonymousClass1 r101 = null;
        if (this.mEGLContextFactory != null) goto L9;
        this.mEGLContextFactory = new DefaultContextFactory(this, r101);
    L9:
        if (this.mEGLWindowSurfaceFactory != null) goto L11;
        this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory(r101);
    L11:
        this.mRenderer = r100;
        GLThread r102 = new GLThread(this.mThisWeakRef);
        this.mGLThread = r102;
        ThreadMethodProxy.start(r102);
    }

    public void setEGLConfigChooser(EGLConfigChooser r100) {
        checkRenderThreadState();
        this.mEGLConfigChooser = r100;
    }

    public GLTextureView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mPrevSurfaceTexture = null;
        this.mThisWeakRef = new WeakReference(this);
        init();
    }

    public static /* synthetic */ int access$202(GLTextureView r100, int r101) {
        r100.mEGLContextClientVersion = r101;
        return r101;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        this.mPrevSurfaceTexture = r100;
        GLThread r103 = this.mGLThread;
        if (r103 == null) goto L6;
        r103.surfaceCreated();
        return;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        this.mGLThread.onWindowResize(r101, r102);
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        GLThread r104 = this.mGLThread;
        if (r104 == null) goto L6;
        r104.onWindowResize(r100, r101);
        return;
    }

    public void setEGLConfigChooser(int r110, int r111, int r112, int r113, int r114, int r115) {
        setEGLConfigChooser(new ComponentSizeChooser(this, r110, r111, r112, r113, r114, r115));
    }
}
