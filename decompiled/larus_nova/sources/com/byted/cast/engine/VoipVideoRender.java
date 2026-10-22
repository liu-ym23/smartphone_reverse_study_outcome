package com.byted.cast.engine;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import com.byted.cast.sdk.RTCMediaKind;
import com.byted.cast.sdk.RTCVideoRender;
import com.byted.cast.sdk.log.Logger;
import com.byted.cast.sdk.log.LoggerManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes39.dex */
public class VoipVideoRender implements GLSurfaceView.Renderer, VoipEngine.OnVoipStreamEventListener {
    private static final String TAG = "VoipVideoRender";
    private WeakReference<GLSurfaceView> mGLSurfaceView;
    private Handler mHandler;
    private AtomicInteger mInvalidateCounter;
    private boolean mIsPublished;
    private boolean mIsSubscribed;
    private boolean mIsWaitSubscribe;
    private Logger mLogger;
    private RTCMediaKind mMediaKind;
    private String mMirrorId;
    private int mPreferedLayer;
    private long mRenderContext;
    private RTCVideoRender.StatusListener mStatusListener;
    private String mUserId;
    private VoipEngine mVoipEngine;

    private native void bind(long r100, String r101, int r102);

    private native long create(String r100);

    private native void destroy(long r100);

    private native void draw(long r100);

    private native void init(long r100);

    private native void resize(long r100, int r101, int r102);

    private native void unbind(long r100);

    @Override // com.byted.cast.engine.VoipEngine.OnVoipStreamEventListener
    public void onStreamSubscribed(String r100, RTCMediaKind r101) {
    }

    @Override // com.byted.cast.engine.VoipEngine.OnVoipStreamEventListener
    public void onStreamUnsubscribed(String r100, RTCMediaKind r101) {
    }

    private void invalidate() {
        GLSurfaceView r100 = this.mGLSurfaceView.get();
        if (r100 == null) goto L6;
        this.mInvalidateCounter.incrementAndGet();
        r100.requestRender();
        return;
    }

    public boolean clearSource() {
        long r100 = this.mRenderContext;
        if (r100 == (-1)) goto L6;
        unbind(r100);
    L6:
        if (isSetSource() == false) goto L8;
        this.mLogger.i(TAG, getContextTag() + "clearSource");
        unsubscribe();
        this.mUserId = "";
        this.mMediaKind = RTCMediaKind.INVALID;
    L8:
        this.mIsPublished = false;
        this.mStatusListener = null;
        return true;
    }

    public String getContextTag() {
        return "[" + hashCode() + "][" + this.mRenderContext + "][" + this.mUserId + "][" + this.mMediaKind.toString() + "] ";
    }

    public boolean isSetSource() {
        String r100 = this.mUserId;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if ("".equals(r100) == true) goto L9;
        if (this.mMediaKind == RTCMediaKind.INVALID) goto L9;
        return true;
    }

    public boolean isSubscribed() {
        if (isSetSource() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsSubscribed == false) goto L7;
        return true;
    }

    public boolean subscribe() {
        if (isSetSource() == true) goto L7;
        this.mLogger.e(TAG, getContextTag() + "subscribe failed, video source is not set");
        return false;
    L7:
        if (this.mIsSubscribed == false) goto L10;
        return true;
    L10:
        if (this.mIsPublished == false) goto L12;
        this.mLogger.i(TAG, getContextTag() + "subscribe");
    L13:
        return true;
    L12:
        this.mIsWaitSubscribe = true;
        goto L13
    }

    public boolean unsubscribe() {
        if (isSetSource() == true) goto L7;
        this.mLogger.e(TAG, getContextTag() + "unsubscribe failed, video source is not set");
        return false;
    L7:
        if (this.mIsSubscribed == false) goto L9;
        this.mLogger.i(TAG, getContextTag() + "unsubscribe");
    L9:
        this.mIsWaitSubscribe = false;
        this.mIsSubscribed = false;
        return true;
    }

    public RTCMediaKind getMediaKind() {
        return this.mMediaKind;
    }

    public long getRenderContext() {
        return this.mRenderContext;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public static /* synthetic */ long access$000(VoipVideoRender r100) {
        return r100.mRenderContext;
    }

    public static /* synthetic */ Logger access$200(VoipVideoRender r100) {
        return r100.mLogger;
    }

    public static /* synthetic */ VoipEngine access$300(VoipVideoRender r100) {
        return r100.mVoipEngine;
    }

    public static /* synthetic */ String access$400(VoipVideoRender r100) {
        return r100.mUserId;
    }

    public static /* synthetic */ RTCMediaKind access$500(VoipVideoRender r100) {
        return r100.mMediaKind;
    }

    public static /* synthetic */ RTCVideoRender.StatusListener access$800(VoipVideoRender r100) {
        return r100.mStatusListener;
    }

    public void notifyVideoSimulcasted(final int r100) {
        this.mHandler.post(new AnonymousClass3(this, r100));
    }

    public void notifyVideoStatusChanged(final boolean r100) {
        this.mHandler.post(new AnonymousClass2(this, r100));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r100) {
        this.mLogger.i(TAG, getContextTag() + "onDrawFrame");
        if (this.mRenderContext != (-1)) goto L5;
        return;
    L5:
        if (isSetSource() == true) goto L7;
        return;
    L7:
        if (this.mInvalidateCounter.get() <= 0) goto L12;
        this.mInvalidateCounter.decrementAndGet();
        draw(this.mRenderContext);
        return;
    }

    public VoipVideoRender(GLSurfaceView r100, final String r101) {
        this.mRenderContext = -1;
        this.mUserId = "";
        this.mMediaKind = RTCMediaKind.INVALID;
        this.mIsPublished = false;
        this.mIsSubscribed = false;
        this.mIsWaitSubscribe = false;
        this.mPreferedLayer = 1;
        this.mVoipEngine = new VoipEngine(null);
        this.mInvalidateCounter = new AtomicInteger(0);
        this.mMirrorId = r101;
        Logger r102 = LoggerManager.getLogger(r101);
        this.mLogger = r102;
        r102.i(TAG, "VoipVideoRender construct  " + r100.toString());
        this.mGLSurfaceView = new WeakReference(r100);
        r100.getHolder().addCallback(new AnonymousClass1(this, r101));
        this.mVoipEngine.addOnVoipStreamEventListener(this);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ long access$002(VoipVideoRender r100, long r101) {
        r100.mRenderContext = r101;
        return r101;
    }

    public static /* synthetic */ long access$100(VoipVideoRender r100, String r101) {
        return r100.create(r101);
    }

    public static /* synthetic */ void access$700(VoipVideoRender r100, long r101) {
        r100.destroy(r101);
    }

    @Override // com.byted.cast.engine.VoipEngine.OnVoipStreamEventListener
    public void onStreamUnpublished(String r100, RTCMediaKind r101) {
        this.mIsPublished = false;
        notifyVideoStatusChanged(false);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        this.mLogger.i(TAG, getContextTag() + "onSurfaceCreated");
        long r102 = this.mRenderContext;
        if (r102 == (-1)) goto L6;
        init(r102);
        return;
    }

    @Override // com.byted.cast.engine.VoipEngine.OnVoipStreamEventListener
    public void onStreamPublished(String r100, RTCMediaKind r101, int r102) {
        this.mIsPublished = true;
        notifyVideoStatusChanged(true);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
        this.mLogger.i(TAG, getContextTag() + "onSurfaceChanged: " + r101 + "x" + r102);
        long r103 = this.mRenderContext;
        if (r103 == (-1)) goto L6;
        resize(r103, r101, r102);
        return;
    }

    public boolean setSource(String r100, RTCMediaKind r101, RTCVideoRender.StatusListener r102) {
        if (r100 != null) goto L5;
    L14:
        this.mLogger.i(TAG, getContextTag() + "setSource failed, invalid params: " + r100 + "-" + r101.toString());
        return false;
    L5:
        if ("".equals(r100) == true) goto L14;
        if (r101 == RTCMediaKind.INVALID) goto L14;
        this.mUserId = r100;
        this.mMediaKind = r101;
        this.mStatusListener = r102;
        this.mLogger.i(TAG, getContextTag() + "setSource");
        long r103 = this.mRenderContext;
        if (r103 == (-1)) goto L16;
        bind(r103, this.mUserId, this.mMediaKind.value());
        return true;
    L16:
        return true;
    }

    public static /* synthetic */ void access$600(VoipVideoRender r100, long r101, String r102, int r103) {
        r100.bind(r101, r102, r103);
    }
}
