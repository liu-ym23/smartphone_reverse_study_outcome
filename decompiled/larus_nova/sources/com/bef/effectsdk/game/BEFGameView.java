package com.bef.effectsdk.game;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.bef.effectsdk.OpenGLUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public class BEFGameView extends GLSurfaceView implements GLSurfaceView.Renderer, NativeInterface.NativeMessageListener {
    protected static final long NANO_SECONDS_PER_MICRO_SECOND = 1000000;
    protected static final long NANO_SECONDS_PER_SECOND = 1000000000;
    protected static final int sDesignHeight = 1280;
    protected static final int sDesignWidth = 720;
    protected static final int sINALID_HANDLE = 0;
    protected long mAnimationInterval;
    protected Queue<Runnable> mCacheMessages;
    protected double mCurrentFps;
    protected int mDstTexture;
    protected int mFBO;
    private boolean mFirstLoopGuard;
    protected long mFps;
    protected String mGameBundlePath;
    protected int mGlMatrixHandle;
    protected int mGlPosHandle;
    protected int mGlProgram;
    protected int mGlTextureSampleHandle;
    protected int mGlUvHandle;
    protected long mHandle;
    private long mLastTickInNanoSeconds;
    protected HashSet<MessageListener> mListeners;
    protected float[] mMatrix;
    private boolean mMultipleTouchEnabled;
    protected boolean mNativeInited;
    protected int mSrcTexture;
    private long mStartTimeStampNanoSeconds;
    protected boolean mSwallowTouches;
    private int[] mTouch_ids;
    private float[] mTouch_xs;
    private float[] mTouch_ys;

    public class BEFGameContextFactory implements GLSurfaceView.EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;
        final /* synthetic */ BEFGameView this$0;

        private BEFGameContextFactory(BEFGameView r100) {
            this.this$0 = r100;
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public /* synthetic */ BEFGameContextFactory(BEFGameView r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            return r100.eglCreateContext(r101, r102, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            if (r100.eglDestroyContext(r101, r102) == true) goto L6;
            Objects.toString(r101);
            Objects.toString(r102);
        L6:
            if (this.this$0.getNativeInited() == false) goto L9;
            this.this$0.setNativeInited(false);
            NativeInterface.destroy(this.this$0.mHandle);
            this.this$0.deleteBuffers();
            return;
        }
    }

    public interface MessageListener {
        int onMsgReceived(long r100, long r101, long r102, String r103);
    }

    public void deleteBuffers() {
        GLES20.glDeleteTextures(1, new int[]{this.mSrcTexture}, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mDstTexture}, 0);
        GLES20.glDeleteBuffers(1, new int[]{this.mFBO}, 0);
    }

    public void destroyBEFGame() {
    }

    public synchronized double getCurrentFps() {
        monitor-enter(this);
        double r100 = this.mCurrentFps;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean getNativeInited() {
        monitor-enter(this);
        boolean r100 = this.mNativeInited;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
    }

    public void initRenderObject() {
        int r100 = OpenGLUtils.loadProgram(RenderTextureUtils.renderVS, RenderTextureUtils.renderFS);
        this.mGlProgram = r100;
        this.mGlUvHandle = GLES20.glGetAttribLocation(r100, "attUV");
        this.mGlPosHandle = GLES20.glGetAttribLocation(this.mGlProgram, "attPosition");
        this.mGlMatrixHandle = GLES20.glGetUniformLocation(this.mGlProgram, "mvpMatrix");
        this.mGlTextureSampleHandle = GLES20.glGetUniformLocation(this.mGlProgram, "uTexture");
        getWidth();
        getHeight();
        this.mSrcTexture = RenderTextureUtils.generateBlankTexture(720, 1280);
        this.mDstTexture = RenderTextureUtils.generateBlankTexture(720, 1280);
        int[] r101 = new int[1];
        GLES20.glGenFramebuffers(1, r101, 0);
        int r102 = r101[0];
        this.mFBO = r102;
        GLES20.glBindFramebuffer(36160, r102);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mDstTexture, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void pauseGame() {
        queueEvent(new AnonymousClass3(this));
    }

    public void resumeGame() {
        queueEvent(new AnonymousClass4(this));
    }

    public void renderTextureToView() {
        GLES20.glBindFramebuffer(36160, 0);
        int r100 = getWidth();
        int r101 = getHeight();
        GLES20.glViewport(0, 0, r100, r101);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.mGlProgram);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mDstTexture);
        GLES20.glUniform1i(this.mGlTextureSampleHandle, 0);
        Matrix.setIdentityM(this.mMatrix, 0);
        GLES20.glUniformMatrix4fv(this.mGlMatrixHandle, 1, false, this.mMatrix, 0);
        GLES20.glEnableVertexAttribArray(this.mGlPosHandle);
        float r102 = r101 / 2.0f;
        GLES20.glVertexAttribPointer(this.mGlPosHandle, 2, 5126, false, 0, RenderTextureUtils.getVertexBufferWithParams(-1.0f, 1.0f, ((((r100 * 1.0f) / 720.0f) * 1280.0f) - r102) / r102, -1.0f));
        GLES20.glEnableVertexAttribArray(this.mGlUvHandle);
        GLES20.glVertexAttribPointer(this.mGlUvHandle, 2, 5126, false, 0, RenderTextureUtils.getUVBuffer());
        GLES20.glDrawArrays(5, 0, 4);
    }

    public BEFGameView(Context r100) {
        super(r100);
        this.mHandle = 0;
        this.mGameBundlePath = "";
        this.mSwallowTouches = false;
        this.mMatrix = new float[16];
        this.mFirstLoopGuard = true;
        this.mMultipleTouchEnabled = true;
        this.mTouch_ids = new int[10];
        this.mTouch_xs = new float[10];
        this.mTouch_ys = new float[10];
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        setZOrderMediaOverlay(true);
        setEGLContextFactory(new BEFGameContextFactory(this, null));
        setRenderer(this);
        setRenderMode(1);
        this.mListeners = new HashSet();
        this.mCacheMessages = new LinkedList();
        setFps(60);
    }

    public int addMessageListener(MessageListener r100) {
        if (r100 != null) goto L5;
        return 3;
    L5:
        this.mListeners.add(r100);
        return 0;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r100) {
        if (getNativeInited() == true) goto L5;
        return;
    L5:
        if (this.mGameBundlePath.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mFirstLoopGuard == false) goto L11;
        this.mStartTimeStampNanoSeconds = System.nanoTime();
        this.mLastTickInNanoSeconds = System.nanoTime();
    L11:
        if (this.mFirstLoopGuard == false) goto L13;
    L15:
        render((System.nanoTime() - this.mStartTimeStampNanoSeconds) / 1.0E9d);
        long r101 = System.nanoTime() - this.mLastTickInNanoSeconds;
        long r102 = this.mAnimationInterval;
        if (r101 < r102) goto L26;
    L21:
        double r103 = 1.0d / (((System.nanoTime() - this.mLastTickInNanoSeconds) * 1.0d) / 1.0E9d);
        this.mCurrentFps = r103;
        long r104 = this.mFps;
        if (r103 < r104) goto L24;
        this.mCurrentFps = r104;
    L24:
        this.mLastTickInNanoSeconds = System.nanoTime();
        this.mFirstLoopGuard = false;
        return;
    L26:
        Thread.sleep((long) (((r102 - r101) * 1.0d) / 1000000.0d));     // Catch: Exception -> L20
    L13:
        if (this.mCacheMessages.isEmpty() == true) goto L15;
        this.mCacheMessages.poll().run();
        goto L13
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        if (r101 <= 10) goto L5;
        r101 = 10;
    L5:
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L8;
        this.mTouch_ids[r102] = r100.getPointerId(r102);
        this.mTouch_xs[r102] = r100.getX(r102);
        this.mTouch_ys[r102] = r100.getY(r102);
        r102 = r102 + 1;
        goto L6
    L8:
        int r103 = r100.getAction() & 255;
        if (r103 == 0) goto L41;
        if (r103 != 1) goto L12;
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, 1);
        final int[] r104 = {this.mTouch_ids[0]};
        final float[] r105 = {this.mTouch_xs[0]};
        final float[] r106 = {this.mTouch_ys[0]};
        queueEvent(new AnonymousClass10(this, r104, r105, r106));
        return true;
    L12:
        if (r103 != 2) goto L14;
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, r101);
        if (this.mMultipleTouchEnabled == true) goto L35;
        final int[] r107 = {this.mTouch_ids[0]};
        final float[] r108 = {this.mTouch_xs[0]};
        final float[] r109 = {this.mTouch_ys[0]};
        queueEvent(new AnonymousClass7(this, r107, r108, r109));
    L34:
        return this.mSwallowTouches;
    L35:
        int r110 = 0;
    L36:
        if (r110 >= r101) goto L38;
        final int[] r111 = {this.mTouch_ids[r110]};
        final float[] r112 = {this.mTouch_xs[r110]};
        final float[] r113 = {this.mTouch_ys[r110]};
        queueEvent(new AnonymousClass8(this, r111, r112, r113));
        r110 = r110 + 1;
        goto L36
    L38:
        return true;
    L14:
        if (r103 != 5) goto L16;
        int r114 = r100.getAction() >> 8;
        if (this.mMultipleTouchEnabled == true) goto L28;
        if (r114 != 0) goto L34;
    L28:
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, r101);
        final int[] r115 = {this.mTouch_ids[r114]};
        final float[] r116 = {this.mTouch_xs[r114]};
        final float[] r117 = {this.mTouch_ys[r114]};
        queueEvent(new AnonymousClass5(this, r115, r116, r117));
        return true;
    L16:
        if (r103 != 6) goto L34;
        int r118 = r100.getAction() >> 8;
        if (this.mMultipleTouchEnabled == true) goto L22;
        if (r118 != 0) goto L34;
    L22:
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, r101);
        final int[] r119 = {this.mTouch_ids[r118]};
        final float[] r120 = {this.mTouch_xs[r118]};
        final float[] r121 = {this.mTouch_ys[r118]};
        queueEvent(new AnonymousClass9(this, r119, r120, r121));
        return true;
    L41:
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, 1);
        final int[] r122 = {this.mTouch_ids[0]};
        final float[] r123 = {this.mTouch_xs[0]};
        final float[] r124 = {this.mTouch_ys[0]};
        queueEvent(new AnonymousClass6(this, r122, r123, r124));
        return true;
    }

    public int removeMessageListener(MessageListener r100) {
        if (r100 != null) goto L5;
        return 3;
    L5:
        this.mListeners.remove(r100);
        return 0;
    }

    public void render(double r100) {
        NativeInterface.setSize(this.mHandle, 720, 1280);
        renderGameToTexture(r100);
        renderTextureToView();
    }

    public void renderGameToTexture(double r110) {
        GLES20.glBindFramebuffer(36160, this.mFBO);
        GLES20.glViewport(0, 0, 720, 1280);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        NativeInterface.processFrame(this.mHandle, this.mSrcTexture, this.mDstTexture, r110);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void setFps(long r100) {
        if (r100 < 60) goto L5;
        this.mFps = 60;
    L6:
        long r101 = this.mFps;
        this.mCurrentFps = r101;
        this.mAnimationInterval = (long) ((1.0f / r101) * 1.0E9f);
        return;
    L5:
        this.mFps = r100;
        goto L6
    }

    public void setGameBundlePath(final String r100) {
        queueEvent(new AnonymousClass1(this, r100));
    }

    public void setNativeInited(boolean r100) {
        this.mNativeInited = r100;
    }

    public void setSwallowTouches(boolean r100) {
        this.mSwallowTouches = r100;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        super.surfaceDestroyed(r100);
    }

    public static /* synthetic */ boolean access$102(BEFGameView r100, boolean r101) {
        r100.mFirstLoopGuard = r101;
        return r101;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        this.mStartTimeStampNanoSeconds = System.nanoTime();
        this.mLastTickInNanoSeconds = System.nanoTime();
        long[] r102 = new long[2];
        NativeInterface.createHandle(r102);
        long r103 = r102[0];
        this.mHandle = r103;
        NativeInterface.init(r103, 720, 1280);
        NativeInterface.addMessageListener(this.mHandle, this);
        initRenderObject();
        setNativeInited(true);
        if (this.mGameBundlePath.isEmpty() == true) goto L6;
        NativeInterface.setGameBundlePath(this.mHandle, this.mGameBundlePath);
        return;
    }

    public void convertTouchesToNormalizedPos(float[] r100, float[] r110, int r111) {
        float r101 = getWidth();
        float r102 = ((r101 * 1.0f) / 720.0f) * 1280.0f;
        float r103 = getHeight() - r102;
        int r104 = 0;
    L3:
        if (r104 >= r111) goto L5;
        float r105 = r100[r104];
        float r106 = r110[r104];
        r100[r104] = ((r105 * 2.0f) / r101) - 1.0f;
        r110[r104] = 1.0f - (((r106 - r103) * 2.0f) / r102);
        r104 = r104 + 1;
        goto L3
    }

    @Override // com.bef.effectsdk.game.NativeInterface.NativeMessageListener
    public int nativeOnMsgReceived(long r110, long r111, long r112, String r113) {
        Iterator<MessageListener> r100 = this.mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onMsgReceived(r110, r111, r112, r113);
        goto L4
    L6:
        return 0;
    }

    public int postMessage(final long r110, final long r111, final long r112, final String r113) {
        queueEvent(new AnonymousClass2(this, r110, r111, r112, r113));
        return 0;
    }
}
