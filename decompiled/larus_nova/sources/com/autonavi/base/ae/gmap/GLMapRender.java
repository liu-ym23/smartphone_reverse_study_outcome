package com.autonavi.base.ae.gmap;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.amap.api.mapcore.util.t6;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.atomic.AtomicLong;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public class GLMapRender implements GLSurfaceView.Renderer {
    public static final int ANIMATION_TICK_COUNT = 10;
    public static final int LONG_LONG_TICK_COUNT = 30;
    public static final int LONG_TICK_COUNT = 6;
    private static final int MAP_RENDER_MSG_RUNNABLE_ONGLTHREAD = 100;
    private static final int MAP_RENDER_MSG_SURFACE_RENDER = 10;
    public static final int NORMAL_TICK_COUNT = 2;
    public static final int RENDER_FPS_ANIMATION = 30;
    public static final int RENDER_FPS_GESTURE_ACTION = 40;
    static final int RENDER_FPS_MAX = 60;
    public static final int RENDER_FPS_NAVI = 10;
    public static final int RENDER_FPS_NORMAL = 15;
    static final long RENDER_TIMMER_DIFF_MIN = 16;
    static final String TAG = "render";
    private volatile boolean mDisableRender;
    private volatile AtomicLong mDrawFrameTickCount;
    public IAMap mGLMapView;
    private Handler mGLRenderHandler;
    private HandlerThread mGLRenderThread;
    private volatile boolean mIsRendPause;
    private boolean mIsTrafficMode;
    private long mLastFrameTime;
    public volatile boolean mSurfacedestoryed;
    private int mTargetFrameDurationMillis;
    private float mTargetRenderFPS;

    public void onSurfaceDestory() {
        this.mIsRendPause = true;
        Handler r100 = this.mGLRenderHandler;
        if (r100 != null) goto L5;
    L7:
        int r101 = this.mGLMapView.getNativeEngineID();
        this.mGLMapView.destroySurface(r101);
        this.mSurfacedestoryed = true;
        return;
    L5:
        if (this.mGLRenderThread == null) goto L7;
        r100.removeCallbacksAndMessages(null);
        goto L7
    }

    private boolean canRequestRender() {
        if (this.mIsRendPause == false) goto L6;
        return false;
    L6:
        if (this.mDisableRender == false) goto L8;
        return false;
    L8:
        IAMap r100 = this.mGLMapView;
        if (r100 != null) goto L12;
        return false;
    L12:
        if (r100.getRenderMode() != 0) goto L15;
        return true;
    L15:
        return false;
    }

    public void onAttachedToWindow() {
        if (this.mGLRenderThread != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(" AMapGlRenderThread");
        this.mGLRenderThread = r100;
        ThreadMethodProxy.start(r100);
        final Looper r101 = this.mGLRenderThread.getLooper();
        this.mGLRenderHandler = new AnonymousClass1(this, r101);
        return;
    }

    public void onDetachedFromWindow() {
        HandlerThread r100 = this.mGLRenderThread;
        if (r100 == null) goto L6;
        r100.quit();
        this.mGLRenderThread = null;
        this.mGLRenderHandler = null;
        return;
    }

    public void renderPause() {
        if (this.mGLRenderHandler == null) goto L9;
        HandlerThread r100 = this.mGLRenderThread;
        if (r100 == null) goto L9;
        if (ThreadMethodProxy.isAlive(r100) == false) goto L9;
        this.mGLRenderHandler.removeMessages(10);
    L9:
        this.mIsRendPause = true;
    }

    public void renderResume() {
        if (this.mGLRenderHandler == null) goto L9;
        HandlerThread r100 = this.mGLRenderThread;
        if (r100 == null) goto L9;
        if (ThreadMethodProxy.isAlive(r100) == false) goto L9;
        this.mGLRenderHandler.removeMessages(10);
    L9:
        this.mIsRendPause = false;
        this.mDrawFrameTickCount.set(-1);
        resetTickCount(30);
    }

    public boolean isDisableRender() {
        return this.mDisableRender;
    }

    public boolean isRenderPause() {
        return this.mIsRendPause;
    }

    public GLMapRender(IAMap r100) {
        this.mTargetFrameDurationMillis = 66;
        this.mTargetRenderFPS = 15.0f;
        this.mIsRendPause = false;
        this.mSurfacedestoryed = false;
        this.mDisableRender = false;
        this.mGLRenderThread = null;
        this.mGLRenderHandler = null;
        this.mLastFrameTime = System.currentTimeMillis();
        this.mIsTrafficMode = false;
        this.mDrawFrameTickCount = new AtomicLong(6);
        this.mGLMapView = r100;
    }

    public static /* synthetic */ boolean access$000(GLMapRender r100) {
        return r100.canRequestRender();
    }

    private void drawSingleFrame(GL10 r100) {
        this.mGLMapView.drawFrame(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r100) {
        if (this.mGLMapView != null) goto L39;
        return;
    L39:
        this.mLastFrameTime = System.currentTimeMillis();     // Catch: Throwable -> L36
        drawSingleFrame(r100);     // Catch: Throwable -> L36
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L36
        long r102 = r101 - this.mLastFrameTime;     // Catch: Throwable -> L36
        this.mLastFrameTime = r101;     // Catch: Throwable -> L36
        long r103 = this.mDrawFrameTickCount.get();     // Catch: Throwable -> L36
        if (this.mGLMapView.getRenderMode() == 0) goto L8;
        return;
    L8:
        if (this.mGLRenderHandler == null) goto L42;
        HandlerThread r104 = this.mGLRenderThread;     // Catch: Throwable -> L36
        if (r104 != null) goto L12;
        return;
    L12:
        if (ThreadMethodProxy.isAlive(r104) == false) goto L44;
        long r105 = r103 - 1;     // Catch: Throwable -> L36
        this.mDrawFrameTickCount.set(r105);     // Catch: Throwable -> L36
        if (r105 <= 0) goto L16;
        long r106 = Math.max(16, ((long) this.mTargetFrameDurationMillis) - r102);     // Catch: Throwable -> L36
    L31:
        if (r106 <= 0) goto L45;
        Handler r107 = this.mGLRenderHandler;     // Catch: Throwable -> L36
        if (r107 == null) goto L46;
        r107.removeMessages(10);     // Catch: Throwable -> L36
        this.mGLRenderHandler.sendEmptyMessageDelayed(10, r106);     // Catch: Throwable -> L36
        return;
    L46:
        return;
    L45:
        return;
    L16:
        if (r105 <= (-5)) goto L19;
        r106 = 60;
        goto L31
    L19:
        if (r105 <= (-7)) goto L22;
        r106 = 100;
        goto L31
    L22:
        if (r105 <= (-9)) goto L25;
        r106 = 250;
        goto L31
    L25:
        if (this.mIsTrafficMode == false) goto L27;
        r106 = 10000;
    L28:
        this.mDrawFrameTickCount.set(-9);     // Catch: Throwable -> L36
        goto L31
    L27:
        r106 = 500;
        goto L28
    L44:
        return;
    L42:
        return;
    L36:
        th = move-exception;
        t6.a(th, "GLMapRender", "onDrawFrame");
    }

    public void resetTickCount(int r100) {
        long r101 = this.mDrawFrameTickCount.get();
        if (this.mIsRendPause == true) goto L16;
        HandlerThread r102 = this.mGLRenderThread;
        if (r102 == null) goto L16;
        if (this.mGLRenderHandler == null) goto L16;
        if (ThreadMethodProxy.isAlive(r102) == false) goto L16;
        if (r101 > 0) goto L13;
        this.mDrawFrameTickCount.set(r100);
        this.mGLRenderHandler.removeMessages(10);
        this.mGLRenderHandler.sendEmptyMessage(10);
        return;
    L13:
        long r103 = r100;
        if (r101 >= r103) goto L21;
        this.mDrawFrameTickCount.set(r103);
        return;
    L21:
        return;
    L16:
        long r104 = r100;
        if (r101 >= r104) goto L23;
        this.mDrawFrameTickCount.set(r104);
        return;
    }

    public void sendToRenderEvent(Runnable r100) {
        if (this.mGLRenderHandler == null) goto L10;
        HandlerThread r101 = this.mGLRenderThread;
        if (r101 != null) goto L7;
        return;
    L7:
        if (ThreadMethodProxy.isAlive(r101) == false) goto L12;
        this.mGLRenderHandler.post(r100);
        return;
    L12:
        return;
    }

    public void setDisableRender(boolean r100) {
        this.mDisableRender = r100;
    }

    public void setRenderFps(float r100) {
        if (this.mTargetRenderFPS != r100) goto L5;
        return;
    L5:
        if (r100 <= 0.0f) goto L9;
        this.mTargetFrameDurationMillis = (int) ((1.0f / r100) * 1000.0f);
        this.mTargetRenderFPS = r100;
        return;
    }

    public void setTrafficMode(boolean r100) {
        this.mIsTrafficMode = r100;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        this.mIsRendPause = false;
        this.mSurfacedestoryed = false;
        this.mGLMapView.createSurface(r100, r101);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
        if (this.mSurfacedestoryed == false) goto L5;
        onSurfaceCreated(r100, null);
    L5:
        this.mGLMapView.changeSurface(r100, r101, r102);
        resetTickCount(30);
    }
}
