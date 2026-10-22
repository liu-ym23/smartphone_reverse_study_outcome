package com.bef.effectsdk.view;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bef.effectsdk.AssetResourceFinder;
import com.bef.effectsdk.GLTextureView;
import com.bef.effectsdk.ResourceFinder;
import com.bef.effectsdk.message.MessageCenter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class BEFView extends GLTextureView implements GLSurfaceView.Renderer, ViewControllerInterface.NativeMessageListener, MessageCenter.Listener {
    protected static final long NANO_SECONDS_PER_MICRO_SECOND = 1000000;
    protected static final long NANO_SECONDS_PER_SECOND = 1000000000;
    private static final String TAG = "BEFView";
    protected String mAdBundlePath;
    private AssetResourceFinder mAssetResourceFinder;
    private long mAttachedEffect;
    protected Queue<Runnable> mCacheMessages;
    private boolean mDestroyed;
    protected long mHandle;
    private long mLastAttachedEffect;
    private long mLastTickInNanoSeconds;
    protected HashSet<MessageListener> mListeners;
    protected float[] mMatrix;
    private boolean mMultipleTouchEnabled;
    protected boolean mNativeInited;
    private Builder.Params mParams;
    protected int mSourceTexture;
    private int[] mTouch_ids;
    private float[] mTouch_xs;
    private float[] mTouch_ys;

    /* JADX INFO: renamed from: com.bef.effectsdk.view.BEFView$12, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$bef$effectsdk$view$BEFView$FitMode = null;

        static {
            int[] r100 = new int[FitMode.values().length];
            $SwitchMap$com$bef$effectsdk$view$BEFView$FitMode = r100;
            r100[FitMode.FIT_WIDTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bef$effectsdk$view$BEFView$FitMode[FitMode.FIT_HEIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bef$effectsdk$view$BEFView$FitMode[FitMode.FILL_SCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bef$effectsdk$view$BEFView$FitMode[FitMode.NO_CLIP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum BEFViewSceneKey extends Enum<BEFViewSceneKey> {
        private static final /* synthetic */ BEFViewSceneKey[] $VALUES = null;
        public static final BEFViewSceneKey GAME = null;
        public static final BEFViewSceneKey LIVE = null;
        public static final BEFViewSceneKey LIVE_OGC = null;
        public static final BEFViewSceneKey M10N = null;
        public static final BEFViewSceneKey SHOOT = null;

        private static /* synthetic */ BEFViewSceneKey[] $values() {
            return new BEFViewSceneKey[]{SHOOT, LIVE, LIVE_OGC, GAME, M10N};
        }

        static {
            SHOOT = new BEFViewSceneKey("SHOOT", 0);
            LIVE = new BEFViewSceneKey("LIVE", 1);
            LIVE_OGC = new BEFViewSceneKey("LIVE_OGC", 2);
            GAME = new BEFViewSceneKey("GAME", 3);
            M10N = new BEFViewSceneKey("M10N", 4);
            $VALUES = $values();
        }

        public static BEFViewSceneKey[] values() {
            return (BEFViewSceneKey[]) $VALUES.clone();
        }

        public static BEFViewSceneKey valueOf(String r100) {
            return (BEFViewSceneKey) a.a(BEFViewSceneKey.class, r100);
        }

        private BEFViewSceneKey(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class Builder {
        private Params mParams;

        public class Params {
            private double mFPS;
            private FitMode mFitMode;
            private boolean mKeepStatusAtPause;
            private boolean mNeglectTouchEvent;
            private int mRenderHeight;
            private int mRenderWidth;
            private ResourceFinder mResourceFinder;
            private BEFViewSceneKey mSceneKey;
            final /* synthetic */ Builder this$0;

            private Params(Builder r100) {
                this.this$0 = r100;
            }

            public static /* synthetic */ int access$100(Params r100) {
                return r100.mRenderWidth;
            }

            public static /* synthetic */ int access$200(Params r100) {
                return r100.mRenderHeight;
            }

            public static /* synthetic */ double access$300(Params r100) {
                return r100.mFPS;
            }

            public static /* synthetic */ FitMode access$400(Params r100) {
                return r100.mFitMode;
            }

            public static /* synthetic */ ResourceFinder access$500(Params r100) {
                return r100.mResourceFinder;
            }

            public static /* synthetic */ BEFViewSceneKey access$600(Params r100) {
                return r100.mSceneKey;
            }

            public static /* synthetic */ boolean access$700(Params r100) {
                return r100.mNeglectTouchEvent;
            }

            public static /* synthetic */ boolean access$800(Params r100) {
                return r100.mKeepStatusAtPause;
            }

            public /* synthetic */ Params(Builder r100, AnonymousClass1 r101) {
                this(r100);
            }

            public static /* synthetic */ int access$102(Params r100, int r101) {
                r100.mRenderWidth = r101;
                return r101;
            }

            public static /* synthetic */ int access$202(Params r100, int r101) {
                r100.mRenderHeight = r101;
                return r101;
            }

            public static /* synthetic */ double access$302(Params r100, double r101) {
                r100.mFPS = r101;
                return r101;
            }

            public static /* synthetic */ FitMode access$402(Params r100, FitMode r101) {
                r100.mFitMode = r101;
                return r101;
            }

            public static /* synthetic */ ResourceFinder access$502(Params r100, ResourceFinder r101) {
                r100.mResourceFinder = r101;
                return r101;
            }

            public static /* synthetic */ BEFViewSceneKey access$602(Params r100, BEFViewSceneKey r101) {
                r100.mSceneKey = r101;
                return r101;
            }

            public static /* synthetic */ boolean access$702(Params r100, boolean r101) {
                r100.mNeglectTouchEvent = r101;
                return r101;
            }

            public static /* synthetic */ boolean access$802(Params r100, boolean r101) {
                r100.mKeepStatusAtPause = r101;
                return r101;
            }
        }

        public static Builder obtain() {
            Builder r100 = new Builder();
            Params.access$102(r100.mParams, 720);
            Params.access$202(r100.mParams, 1280);
            Params.access$302(r100.mParams, 30.0d);
            Params.access$402(r100.mParams, FitMode.FILL_SCREEN);
            Params.access$502(r100.mParams, null);
            Params.access$602(r100.mParams, BEFViewSceneKey.SHOOT);
            Params.access$702(r100.mParams, false);
            Params.access$802(r100.mParams, false);
            return r100;
        }

        private Builder() {
            this.mParams = new Params(this, null);
        }

        public BEFView build(Context r100) {
            BEFView r101 = new BEFView(r100, null);
            BEFView.access$1000(r101, this.mParams);
            return r101;
        }

        public Builder setFPS(double r100) {
            Params.access$302(this.mParams, r100);
            return this;
        }

        public Builder setFitMode(FitMode r100) {
            Params.access$402(this.mParams, r100);
            return this;
        }

        public Builder setKeepStatusAtPause(boolean r100) {
            Params.access$802(this.mParams, r100);
            return this;
        }

        public Builder setNeglectTouchEvent(boolean r100) {
            Params.access$702(this.mParams, r100);
            return this;
        }

        public Builder setResourceFinder(ResourceFinder r100) {
            Params.access$502(this.mParams, r100);
            return this;
        }

        public Builder setSceneKey(BEFViewSceneKey r100) {
            Params.access$602(this.mParams, r100);
            return this;
        }

        public BEFView build(Context r100, AttributeSet r101) {
            BEFView r102 = new BEFView(r100, r101, null);
            BEFView.access$1000(r102, this.mParams);
            return r102;
        }

        public Builder setRenderSize(int r100, int r101) {
            Params.access$102(this.mParams, r100);
            Params.access$202(this.mParams, r101);
            return this;
        }
    }

    public static class Color {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f33657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f33658b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f33659g;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f33660r;

        public Color() {
            setColor(0.0f, 0.0f, 0.0f, 0.0f);
        }

        public float alpha() {
            return this.f33657a;
        }

        public float blue() {
            return this.f33658b;
        }

        public float green() {
            return this.f33659g;
        }

        public float red() {
            return this.f33660r;
        }

        public Color(float r100, float r101, float r102, float r103) {
            setColor(r100, r101, r102, r103);
        }

        public void setColor(float r100, float r101, float r102, float r103) {
            this.f33660r = r100;
            this.f33659g = r101;
            this.f33658b = r102;
            this.f33657a = r103;
        }
    }

    public static final enum FitMode extends Enum<FitMode> {
        private static final /* synthetic */ FitMode[] $VALUES = null;
        public static final FitMode FILL_SCREEN = null;
        public static final FitMode FIT_HEIGHT = null;
        public static final FitMode FIT_WIDTH = null;
        public static final FitMode FIT_WIDTH_BOTTOM = null;
        public static final FitMode NO_CLIP = null;

        private static /* synthetic */ FitMode[] $values() {
            return new FitMode[]{FIT_WIDTH, FIT_HEIGHT, FILL_SCREEN, FIT_WIDTH_BOTTOM, NO_CLIP};
        }

        static {
            FIT_WIDTH = new FitMode("FIT_WIDTH", 0);
            FIT_HEIGHT = new FitMode("FIT_HEIGHT", 1);
            FILL_SCREEN = new FitMode("FILL_SCREEN", 2);
            FIT_WIDTH_BOTTOM = new FitMode("FIT_WIDTH_BOTTOM", 3);
            NO_CLIP = new FitMode("NO_CLIP", 4);
            $VALUES = $values();
        }

        public static FitMode[] values() {
            return (FitMode[]) $VALUES.clone();
        }

        public static FitMode valueOf(String r100) {
            return (FitMode) a.a(FitMode.class, r100);
        }

        private FitMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface MessageListener {
        void onMessageReceived(long r100, long r101, long r102, String r103);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 r100, int r101, int r102) {
    }

    private void initRender() {
        setNativeInited(false);
        long r100 = this.mHandle;
        if (r100 != 0) goto L22;
    L7:
        int r101 = this.mSourceTexture;
        if (r101 <= 0) goto L11;
        ViewControllerInterface.deleteTexture(r101);
    L11:
        if (this.mHandle != 0) goto L17;
        long[] r102 = new long[2];
        ViewControllerInterface.createHandle(r102, Builder.Params.access$600(this.mParams).ordinal());
        this.mHandle = r102[0];
        if (Builder.Params.access$500(this.mParams) == null) goto L15;
        ViewControllerInterface.setResourceFinder(this.mHandle, Builder.Params.access$500(this.mParams).createNativeResourceFinder(this.mHandle), 0);
    L16:
        ViewControllerInterface.init(this.mHandle, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams));
        goto L17
    L15:
        ViewControllerInterface.setResourceFinder(this.mHandle, 0, 0);
    L17:
        ViewControllerInterface.addMessageListener(this.mHandle, this);
        MessageCenter.init();
        MessageCenter.addListener(this);
        this.mLastTickInNanoSeconds = System.nanoTime();
        int[] r103 = new int[1];
        int[] r104 = new int[1];
        int[] r105 = new int[1];
        GLES20.glGenTextures(1, r103, 0);
        GLES20.glBindTexture(3553, r103[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glTexImage2D(3553, 0, 6408, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams), 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        GLES20.glGetIntegerv(36006, r105, 0);
        GLES20.glGenFramebuffers(1, r104, 0);
        GLES20.glBindFramebuffer(36160, r104[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r103[0], 0);
        GLES20.glViewport(0, 0, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams));
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glBindFramebuffer(36160, r105[0]);
        GLES20.glDeleteFramebuffers(1, r104, 0);
        this.mSourceTexture = r103[0];
        String r106 = this.mAdBundlePath;
        if (r106 == "") goto L20;
        ViewControllerInterface.setStickerPath(this.mHandle, r106);
    L20:
        this.mLastAttachedEffect = 0;
        setNativeInited(true);
        return;
    L22:
        ViewControllerInterface.destroy(r100);     // Catch: Exception -> L6
        this.mHandle = 0;     // Catch: Exception -> L6
        goto L7
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onDestroy() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        queueEvent(new AnonymousClass8(this));
        super.onDestroy();
        this.mDestroyed = true;
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onPause() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        queueEvent(new AnonymousClass6(this));
        super.onPause();
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onResume() {
        if (this.mDestroyed == false) goto L5;
        return;
    L5:
        super.onResume();
        queueEvent(new AnonymousClass7(this));
    }

    private void destoryRender() {
        if (getNativeInited() != true) goto L12;
        setNativeInited(false);
        if (Builder.Params.access$500(this.mParams) == null) goto L7;
        Builder.Params.access$500(this.mParams).release(this.mHandle);
    L7:
        AssetResourceFinder r100 = this.mAssetResourceFinder;
        if (r100 == null) goto L10;
        r100.release(0);
    L10:
        ViewControllerInterface.removeMessageListener(this.mHandle, this);
        ViewControllerInterface.destroy(this.mHandle);
        this.mHandle = 0;
        ViewControllerInterface.deleteTexture(this.mSourceTexture);
        this.mSourceTexture = 0;
        MessageCenter.removeListener(this);
        MessageCenter.destroy();
        this.mLastAttachedEffect = 0;
        return;
    }

    public boolean getNativeInited() {
        return this.mNativeInited;
    }

    @Override // com.bef.effectsdk.GLTextureView
    public void onExitContext() {
        destoryRender();
    }

    private BEFView(Context r100) {
        super(r100);
        this.mHandle = 0;
        this.mAdBundlePath = "";
        this.mNativeInited = false;
        this.mMatrix = new float[16];
        this.mTouch_ids = new int[10];
        this.mTouch_xs = new float[10];
        this.mTouch_ys = new float[10];
        this.mMultipleTouchEnabled = true;
        this.mAttachedEffect = 0;
        this.mLastAttachedEffect = 0;
        this.mDestroyed = false;
        this.mAssetResourceFinder = null;
        init(r100);
    }

    public static /* synthetic */ Builder.Params access$1200(BEFView r100) {
        return r100.mParams;
    }

    public static /* synthetic */ void access$1300(BEFView r100) {
        r100.destoryRender();
    }

    public static /* synthetic */ void access$1400(BEFView r100) {
        r100.initRender();
    }

    private void dealWithTouches(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        if (r101 <= 10) goto L5;
        final int r102 = 10;
    L6:
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L9;
        this.mTouch_ids[r104] = r100.getPointerId(r104);
        this.mTouch_xs[r104] = r100.getX(r104);
        this.mTouch_ys[r104] = r100.getY(r104);
        r104 = r104 + 1;
        goto L7
    L9:
        convertTouchesToNormalizedPos(this.mTouch_xs, this.mTouch_ys, r102);
        int r105 = r100.getActionIndex();
        if (this.mMultipleTouchEnabled == true) goto L12;
        if (r105 == 0) goto L12;
        return;
    L12:
        int r106 = r100.getAction() & 255;
        if (r106 == 0) goto L27;
        if (r106 != 1) goto L16;
    L26:
        final int[] r107 = {this.mTouch_ids[r105]};
        final float[] r108 = {this.mTouch_xs[r105]};
        final float[] r109 = {this.mTouch_ys[r105]};
        queueEvent(new AnonymousClass5(this, r107, r108, r109, r102));
        return;
    L16:
        if (r106 != 2) goto L18;
        final int[] r110 = new int[r102];
        final float[] r111 = new float[r102];
        final float[] r112 = new float[r102];
    L23:
        if (r103 >= r102) goto L25;
        r110[r103] = this.mTouch_ids[r103];
        r111[r103] = this.mTouch_xs[r103];
        r112[r103] = this.mTouch_ys[r103];
        r103 = r103 + 1;
        goto L23
    L25:
        queueEvent(new AnonymousClass4(this, r110, r111, r112, r102));
        return;
    L18:
        if (r106 == 5) goto L27;
        if (r106 == 6) goto L26;
        return;
    L27:
        final int[] r113 = {this.mTouch_ids[r105]};
        final float[] r114 = {this.mTouch_xs[r105]};
        final float[] r115 = {this.mTouch_ys[r105]};
        queueEvent(new AnonymousClass3(this, r113, r114, r115, r102));
        return;
    L5:
        r102 = r101;
        goto L6
    }

    private void init(Context r100) {
        setPreserveEGLContextOnPause(true);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(1);
        this.mListeners = new HashSet();
        this.mCacheMessages = new LinkedList();
        AssetResourceFinder r101 = new AssetResourceFinder(r100.getAssets(), "");
        this.mAssetResourceFinder = r101;
        r101.createNativeResourceFinder(0);
        this.mDestroyed = false;
    }

    private void setParams(Builder.Params r100) {
        this.mParams = r100;
    }

    public synchronized int addMessageListener(MessageListener r100) {
        monitor-enter(this);
        if (r100 != null) goto L14;
        monitor-exit(this);
        return -1;
    L14:
        this.mListeners.add(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void attachEffect(long r100) {
        monitor-enter(this);
        this.mAttachedEffect = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 r210) {
        if (getNativeInited() == true) goto L5;
        return;
    L5:
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        long r100 = this.mAttachedEffect;
        if (r100 == this.mLastAttachedEffect) goto L8;
        ViewControllerInterface.attachEffect(this.mHandle, r100);
        this.mLastAttachedEffect = this.mAttachedEffect;
    L8:
        long r101 = System.nanoTime() - this.mLastTickInNanoSeconds;
        double r102 = (1.0d / Builder.Params.access$300(this.mParams)) * 1.0E9d;
        double r103 = r101;
        if (r103 < r102) goto L22;
    L12:
        this.mLastTickInNanoSeconds = System.nanoTime();
    L14:
        if (this.mCacheMessages.isEmpty() == true) goto L16;
        this.mCacheMessages.poll().run();
        goto L14
    L16:
        double r110 = System.nanoTime() / 1.0E9d;
        int r104 = getWidth();
        int r105 = getHeight();
        Matrix.setIdentityM(this.mMatrix, 0);
        RectF r106 = new RectF(0.0f, 0.0f, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams));
        float r107 = r104;
        RectF r108 = new RectF(0.0f, 0.0f, r107, r105);
        PointF r109 = fitResolution(new PointF(0.0f, 0.0f), r106, r108, Builder.Params.access$400(this.mParams));
        PointF r111 = fitResolution(new PointF(Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams)), r106, r108, Builder.Params.access$400(this.mParams));
        if (Builder.Params.access$400(this.mParams) != FitMode.FIT_WIDTH_BOTTOM) goto L19;
        r109 = new PointF(0.0f, 0.0f);
        r111 = new PointF(r107, (Builder.Params.access$200(this.mParams) * r104) / Builder.Params.access$100(this.mParams));
    L19:
        float r112 = r109.x;
        float r113 = r109.y;
        ViewControllerInterface.processFrame(this.mHandle, this.mSourceTexture, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams), this.mMatrix, new float[]{r112, r113, r111.x - r112, r111.y - r113}, r110);
        return;
    L22:
        Thread.sleep((long) (((r102 - r103) * 1.0d) / 1000000.0d));     // Catch: Exception -> L21
        goto L12
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (getNativeInited() == true) goto L5;
        return false;
    L5:
        if (this.mAdBundlePath != "") goto L7;
        return false;
    L7:
        if (Builder.Params.access$700(this.mParams) == true) goto L14;
        dealWithTouches(r100);
        ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        return true;
    L14:
        return false;
    }

    public synchronized int removeMessageListener(MessageListener r100) {
        monitor-enter(this);
        if (r100 != null) goto L14;
        monitor-exit(this);
        return -1;
    L14:
        this.mListeners.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return 0;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean setExternalTouchEvent(MotionEvent r100) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (getNativeInited() == true) goto L6;
    L12:
        monitor-exit(this);
        return false;
    L6:
        if (this.mAdBundlePath == "") goto L12;
        dealWithTouches(r100);     // Catch: Throwable -> L15
        monitor-exit(this);
        return true;
    }

    public void setNativeInited(boolean r100) {
        this.mNativeInited = r100;
    }

    public synchronized void setStickerPath(final String r100) {
        monitor-enter(this);
        queueEvent(new AnonymousClass1(this, r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private BEFView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mHandle = 0;
        this.mAdBundlePath = "";
        this.mNativeInited = false;
        this.mMatrix = new float[16];
        this.mTouch_ids = new int[10];
        this.mTouch_xs = new float[10];
        this.mTouch_ys = new float[10];
        this.mMultipleTouchEnabled = true;
        this.mAttachedEffect = 0;
        this.mLastAttachedEffect = 0;
        this.mDestroyed = false;
        this.mAssetResourceFinder = null;
        init(r100);
    }

    public static /* synthetic */ void access$1000(BEFView r100, Builder.Params r101) {
        r100.setParams(r101);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        initRender();
    }

    public synchronized void setRenderCacheData(final String r100, final String r101) {
        monitor-enter(this);
        queueEvent(new AnonymousClass9(this, r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setRenderCacheTexture(final String r100, final String r101) {
        monitor-enter(this);
        queueEvent(new AnonymousClass10(this, r100, r101));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ BEFView(Context r100, AnonymousClass1 r101) {
        this(r100);
    }

    public /* synthetic */ BEFView(Context r100, AttributeSet r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    private void convertTouchesToNormalizedPos(float[] r110, float[] r111, int r112) {
        int r100 = getWidth();
        int r101 = getHeight();
        int r102 = 0;
    L3:
        if (r102 >= r112) goto L16;
        float r103 = r110[r102];
        float r104 = r111[r102];
        PointF r105 = new PointF(r103, r104);
        float r106 = r100;
        float r113 = r101;
        RectF r107 = new RectF(0.0f, 0.0f, r106, r113);
        new PointF();
        FitMode r114 = Builder.Params.access$400(this.mParams);
        FitMode r115 = FitMode.FILL_SCREEN;
        if (r114 != r115) goto L8;
        PointF r108 = fitResolution(r105, r107, new RectF(0.0f, 0.0f, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams)), FitMode.NO_CLIP);
    L14:
        r110[r102] = r108.x / Builder.Params.access$100(this.mParams);
        r111[r102] = r108.y / Builder.Params.access$200(this.mParams);
    L15:
        r102 = r102 + 1;
        goto L3
    L8:
        if (Builder.Params.access$400(this.mParams) != FitMode.NO_CLIP) goto L11;
        r108 = fitResolution(r105, r107, new RectF(0.0f, 0.0f, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams)), r115);
        goto L14
    L11:
        if (Builder.Params.access$400(this.mParams) != FitMode.FIT_WIDTH_BOTTOM) goto L13;
        float r109 = ((r106 * 1.0f) / Builder.Params.access$100(this.mParams)) * Builder.Params.access$200(this.mParams);
        r110[r102] = (r103 * 1.0f) / r106;
        r111[r102] = ((r104 - (r113 - r109)) * 1.0f) / r109;
        goto L15
    L13:
        r108 = fitResolution(r105, r107, new RectF(0.0f, 0.0f, Builder.Params.access$100(this.mParams), Builder.Params.access$200(this.mParams)), Builder.Params.access$400(this.mParams));
        goto L14
    }

    private PointF fitResolution(PointF r110, RectF r111, RectF r112, FitMode r113) {
        PointF r100 = new PointF();
        float r101 = r112.left;
        float r102 = r112.top;
        float r103 = r112.width();
        float r104 = r112.height();
        float r105 = (r110.x - r111.left) / r111.width();
        float r106 = (r110.y - r111.top) / r111.height();
        int r114 = AnonymousClass12.$SwitchMap$com$bef$effectsdk$view$BEFView$FitMode[r113.ordinal()];
        if (r114 != 1) goto L5;
        float r115 = r103 / r111.width();
        r100.x = (int) (r101 + (r105 * r103));
        r100.y = (int) ((r102 + ((r104 - (r111.height() * r115)) / 2.0f)) + ((r106 * r115) * r111.height()));
    L25:
        return r100;
    L5:
        if (r114 != 2) goto L7;
        float r116 = r104 / r111.height();
        r100.x = (int) ((r101 + ((r103 - (r111.width() * r116)) / 2.0f)) + ((r105 * r116) * r111.width()));
        r100.y = (int) (r102 + (r106 * r104));
        goto L25
    L7:
        if (r114 == 3) goto L18;
        if (r114 != 4) goto L25;
        if ((r103 / r111.width()) <= (r104 / r111.height())) goto L16;
        return fitResolution(r110, r111, r112, FitMode.FIT_HEIGHT);
    L16:
        return fitResolution(r110, r111, r112, FitMode.FIT_WIDTH);
    L18:
        if ((r103 / r111.width()) >= (r104 / r111.height())) goto L22;
        return fitResolution(r110, r111, r112, FitMode.FIT_HEIGHT);
    L22:
        return fitResolution(r110, r111, r112, FitMode.FIT_WIDTH);
    }

    @Override // com.bef.effectsdk.view.ViewControllerInterface.NativeMessageListener
    public synchronized int nativeOnMsgReceived(long r110, long r111, long r112, String r113) {
        monitor-enter(this);
        Iterator<MessageListener> r100 = this.mListeners.iterator();     // Catch: Throwable -> L12
    L6:
        if (r100.hasNext() == false) goto L9;
        r100.next().onMessageReceived(r110, r111, r112, r113);     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(this);
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bef.effectsdk.message.MessageCenter.Listener
    public void onMessageReceived(int r100, int r110, int r111, String r112) {
        postMessage(r100, r110, r111, r112);
    }

    public synchronized int postMessage(final long r110, final long r111, final long r112, final String r113) {
        monitor-enter(this);
        queueEvent(new AnonymousClass2(this, r110, r111, r112, r113));     // Catch: Throwable -> L8
        monitor-exit(this);
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void setRenderCacheTextureWithBuffer(final String r100, final byte[] r101, final int r110, final int r111) {
        monitor-enter(this);
        queueEvent(new AnonymousClass11(this, r100, r101, r110, r111));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
