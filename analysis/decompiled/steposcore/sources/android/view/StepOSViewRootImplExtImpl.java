package android.view;

import android.app.Activity;
import android.app.StepOSActivityThreadExtImpl;
import android.app.StepOSViewCaptureManager;
import android.app.WindowConfiguration;
import android.app.WindowModeHelper;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentExt;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.StepOSCtsUtils;
import android.os.Trace;
import android.util.Slog;
import android.view.WindowManager;
import android.view.stepos.StepOSVsyncSourceHelper;
import com.android.internal.graphics.backdrop.BackdropLayer;
import com.android.internal.graphics.backdrop.BackdropLayerDrawable;
import com.android.internal.policy.DecorView;
import com.stepos.feature.StepOSFeature;
import java.util.Arrays;
import stepos.app.StepOSWindowManager;
import stepos.uicontroller.UIController;

/* loaded from: classes.dex */
public class StepOSViewRootImplExtImpl implements IStepOSViewRootImplExt {
    private static final boolean DEBUG_LOCAL_FOCUS_FOR_GAME = true;
    private static final float[] DEFAULT_WINDOW_MODE_OFFSET = {0.0f, 0.0f, 1.0f, 1.0f};
    public static final String DEX_LIBRARY_SEARCH_PATH = "dexLibrarySearchPath";
    public static final String DEX_PATH = "dexPath";
    private static final String TAG = "ViewRootImplExt";
    public static final String TARGET_COPY_NODE_CLASS = "targetCopyNodeClass";
    public static final String TARGET_COPY_NODE_METHOD = "targetCopyNodeMethod";
    public static final String TARGET_COPY_NODE_PACKAGE = "targetCopyNodePackage";
    public static final String TARGET_WINDOW_TITLE_KEY = "targetWindowTitle";
    private int mAppIsGameMode;
    private int mBackdropHeight;
    private BackdropLayer mBackdropLayer;
    private ViewTreeObserver mBackdropObserver;
    private ThreadedRenderer mBackdropRenderer;
    private ViewRootImpl mBackdropViewRoot;
    private int mBackdropWidth;
    private ViewRootImpl mHost;
    private Class<?> mTargetCopyNodeClass;
    private UIController mUIController;
    private int mLastWindowMode = 0;
    private int mLastRotation = -1;
    private final float[] mWindowModeOffset = (float[]) DEFAULT_WINDOW_MODE_OFFSET.clone();

    public void onAttach(ViewRootImpl host) {
        this.mHost = host;
    }

    public void onDetach() {
        releaseUIController();
        this.mHost = null;
        this.mTargetCopyNodeClass = null;
    }

    private void releaseUIController() {
        if (this.mUIController != null) {
            this.mUIController.reset();
            this.mUIController = null;
        }
    }

    public void adjustLayoutInDisplayCutoutMode(WindowManager.LayoutParams attrs, WindowConfiguration winConfig) {
        if (this.mHost == null || StepOSCtsUtils.isCtsRunning()) {
            return;
        }
        int customizedMode = this.mHost.mContext.getApplicationInfo().getStepOSExt().getCustomizedCutoutMode();
        if (customizedMode != -1) {
            if (customizedMode >= 0 && attrs.layoutInDisplayCutoutMode == 0) {
                if (customizedMode != 0) {
                    Slog.d(TAG, "adjustLayoutInDisplayCutoutMode customized layoutInDisplayCutoutMode " + WindowManager.LayoutParams.layoutInDisplayCutoutModeToString(attrs.layoutInDisplayCutoutMode) + " -> " + WindowManager.LayoutParams.layoutInDisplayCutoutModeToString(customizedMode));
                }
                attrs.layoutInDisplayCutoutMode = customizedMode;
                return;
            }
            return;
        }
        if (this.mHost.mContext.getApplicationInfo().isForceFull() && winConfig.getBounds().width() > winConfig.getBounds().height()) {
            if (attrs.layoutInDisplayCutoutMode != 3) {
                Slog.d(TAG, "adjustLayoutInDisplayCutoutMode forceFull layoutInDisplayCutoutMode " + WindowManager.LayoutParams.layoutInDisplayCutoutModeToString(attrs.layoutInDisplayCutoutMode));
            }
            attrs.layoutInDisplayCutoutMode = 3;
        }
    }

    public void onAppVisibilityChange(boolean appVisible, boolean upcomingWindowFocus) {
        if (this.mHost != null && this.mAppIsGameMode == 1 && !upcomingWindowFocus && appVisible && WindowConfiguration.isStepOSPinWindow(this.mLastWindowMode)) {
            this.mHost.windowFocusChanged(false);
            this.mHost.windowFocusChanged(true);
        }
    }

    public void onConfigurationChange(Configuration overrideConfig, IWindow window, boolean appVisible, boolean upcomingWindowFocus) {
        if (this.mHost == null || overrideConfig == null) {
            return;
        }
        int windowMode = overrideConfig.windowConfiguration.getWindowingMode();
        int rotation = overrideConfig.windowConfiguration.getRotation();
        Rect bounds = overrideConfig.windowConfiguration.getBounds();
        int appWidth = bounds != null ? bounds.width() : 0;
        if (appWidth != 0 && (this.mLastRotation != rotation || this.mLastWindowMode != windowMode)) {
            this.mLastRotation = rotation;
            if (this.mLastWindowMode != windowMode) {
                this.mLastWindowMode = windowMode;
                updateGameModeOnWindowChanged(windowMode, bounds, appVisible, upcomingWindowFocus);
            }
            if (!WindowConfiguration.isStepOSMiniWindow(this.mLastWindowMode)) {
                System.arraycopy(DEFAULT_WINDOW_MODE_OFFSET, 0, this.mWindowModeOffset, 0, this.mWindowModeOffset.length);
                return;
            } else {
                StepOSWindowManager.getInstance().getWindowModeTouchOffset(window, this.mWindowModeOffset);
                return;
            }
        }
        if (WindowConfiguration.isStepOSMiniWindow(this.mLastWindowMode) && Arrays.equals(this.mWindowModeOffset, DEFAULT_WINDOW_MODE_OFFSET)) {
            StepOSWindowManager.getInstance().getWindowModeTouchOffset(window, this.mWindowModeOffset);
        }
    }

    public int getLastWindowMode() {
        return this.mLastWindowMode;
    }

    public boolean canLocalLayout(WindowConfiguration winConfig, View view) {
        Activity activity;
        Configuration config;
        if (winConfig == null || !(view instanceof DecorView) || (activity = resolveActivity(view.getContext())) == null || (config = WindowModeHelper.getCurrentConfig(activity)) == null) {
            return true;
        }
        return config.isStepOSWindowMode() ? winConfig.diff(config.windowConfiguration, false) == 0 : !config.isStepOSMagicWindow();
    }

    public void onInputEvent(InputEvent event) {
        if (!(event instanceof MotionEvent)) {
            return;
        }
        MotionEvent motionEvent = (MotionEvent) event;
        if (WindowConfiguration.isStepOSWindowMode(this.mLastWindowMode)) {
            motionEvent.setRawDisplayOffset(this.mWindowModeOffset[0], this.mWindowModeOffset[1]);
            motionEvent.setRawDisplayScale(this.mWindowModeOffset[2], this.mWindowModeOffset[3]);
        } else {
            motionEvent.setRawDisplayOffset(0.0f, 0.0f);
            motionEvent.setRawDisplayScale(1.0f, 1.0f);
        }
    }

    private void updateGameModeOnWindowChanged(int windowMode, Rect bounds, boolean appVisible, boolean upcomingWindowFocus) {
        boolean isPinWindow = WindowConfiguration.isStepOSPinWindow(windowMode);
        if (this.mAppIsGameMode == 0 && isPinWindow) {
            int appHeight = bounds != null ? bounds.height() : 0;
            int appWidth = bounds != null ? bounds.width() : 0;
            if (appHeight != 0) {
                float ratio = (Math.max(appHeight, appWidth) * 1.0f) / Math.min(appHeight, appWidth);
                this.mAppIsGameMode = ratio > 2.0f ? 1 : -1;
            }
        }
        if (this.mAppIsGameMode == 1) {
            if (isPinWindow) {
                this.mHost.mWindowAttributes.flags |= IntentExt.STEPOS_FLAG_IMMEDIATE_BROADCAST;
            } else {
                this.mHost.mWindowAttributes.flags &= -268435457;
            }
        }
        if (isPinWindow && this.mAppIsGameMode == 1 && !upcomingWindowFocus && appVisible) {
            this.mHost.windowFocusChanged(false);
            this.mHost.windowFocusChanged(true);
        }
    }

    private static Activity resolveActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public void postApexRequest(Handler handler, Intent intent) {
        if (handler == null) {
            return;
        }
        Message message = Message.obtain();
        message.what = 139;
        message.obj = intent;
        handler.sendMessage(message);
    }

    public void apexRequest(Intent intent, View view) {
        if (view == null) {
            return;
        }
        StepOSViewCaptureManager.getInstance().apexRequest(intent, view);
    }

    public void onRootViewAttached(ViewRootImpl viewRoot) {
        if (viewRoot == null) {
            return;
        }
        this.mUIController = new UIController(viewRoot);
    }

    public void onDispatchDetachedFromWindow(ViewRootImpl viewRoot) {
        releaseUIController();
        this.mBackdropViewRoot = null;
        this.mBackdropRenderer = null;
        this.mBackdropObserver = null;
        this.mBackdropLayer = null;
    }

    public void requestUIController(final ViewRootImpl viewRoot) {
        if (viewRoot == null) {
            return;
        }
        viewRoot.mHandler.post(new Runnable() { // from class: android.view.StepOSViewRootImplExtImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestUIController$0(viewRoot);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestUIController$0(ViewRootImpl viewRoot) {
        if (this.mUIController != null) {
            try {
                StepOSWindowManager.getInstance().updateUIController(viewRoot.mWindow, this.mUIController);
            } catch (Exception e) {
            }
        }
    }

    public boolean scheduleTraversalsImmediately() {
        if (!StepOSActivityThreadExtImpl.mDoFrameOptEnable || !StepOSActivityThreadExtImpl.mAppDoFrameOptEnable) {
            return false;
        }
        StepOSActivityThreadExtImpl.mAppDoFrameOptEnable = false;
        Trace.traceBegin(8L, "scheduleTraversalsImmediately In");
        if (!this.mHost.mTraversalScheduled) {
            this.mHost.mTraversalScheduled = true;
            Trace.traceBegin(8L, "scheduleTraversalsImmediately occurred");
            this.mHost.mTraversalBarrier = this.mHost.mHandler.getLooper().getQueue().postSyncBarrier();
            this.mHost.mChoreographer.getChoreographerInner().getStepOSExt().postCallbackImmediately(3, this.mHost.mTraversalRunnable, (Object) null, 0L);
            this.mHost.mChoreographer.getChoreographerInner().doFrameImmediately();
            this.mHost.notifyRendererOfFramePending();
            this.mHost.pokeDrawLockIfNeeded();
            Trace.traceEnd(8L);
            Trace.traceEnd(8L);
            return true;
        }
        Trace.traceEnd(8L);
        return false;
    }

    public int chooseInitialVsyncSource(Display display) {
        return StepOSVsyncSourceHelper.chooseInitialVsyncSource(display);
    }

    public Choreographer resolveChoreographerForVsyncSource(int vsyncSource) {
        if (this.mHost == null) {
            return Choreographer.getInstance();
        }
        switch (sanitizePreferredFrameVsyncSource(vsyncSource)) {
        }
        return Choreographer.getInstance();
    }

    public int sanitizePreferredFrameVsyncSource(int vsyncSource) {
        switch (vsyncSource) {
            case 0:
            case 99:
                return vsyncSource;
            default:
                return 0;
        }
    }

    public void setPreferredFrameVsyncSource(int vsyncSource) {
        int sanitizedVsyncSource;
        if (this.mHost == null || this.mHost.mPreferredFrameVsyncSource == (sanitizedVsyncSource = sanitizePreferredFrameVsyncSource(vsyncSource))) {
            return;
        }
        Choreographer previousChoreographer = this.mHost.mChoreographer;
        Choreographer nextChoreographer = resolveChoreographerForVsyncSource(sanitizedVsyncSource);
        if (previousChoreographer == nextChoreographer) {
            this.mHost.mPreferredFrameVsyncSource = sanitizedVsyncSource;
            return;
        }
        boolean traversalScheduled = this.mHost.mTraversalScheduled;
        boolean consumeBatchedInputScheduled = this.mHost.mConsumeBatchedInputScheduled;
        this.mHost.unscheduleTraversals();
        this.mHost.unscheduleConsumeBatchedInput();
        this.mHost.mInvalidateOnAnimationRunnable.moveToChoreographer(previousChoreographer, nextChoreographer);
        this.mHost.mPreferredFrameVsyncSource = sanitizedVsyncSource;
        this.mHost.mChoreographer = nextChoreographer;
        if (consumeBatchedInputScheduled) {
            this.mHost.scheduleConsumeBatchedInput();
        }
        if (traversalScheduled) {
            this.mHost.scheduleTraversals();
        }
    }

    public long createStepOSEffect(String shader) {
        return StepOSWindowManager.getInstance().createStepOSEffect(shader);
    }

    public void onBackdropInit(ViewRootImpl viewRoot, ThreadedRenderer renderer, ViewTreeObserver observer) {
        if (!StepOSFeature.isEnabled(33)) {
            return;
        }
        this.mBackdropViewRoot = viewRoot;
        this.mBackdropRenderer = renderer;
        this.mBackdropObserver = observer;
    }

    private BackdropLayer ensureBackdropLayer() {
        if (this.mBackdropLayer == null && this.mBackdropObserver != null) {
            this.mBackdropLayer = new BackdropLayer(this.mBackdropViewRoot, this.mBackdropRenderer, this.mBackdropObserver);
            if (this.mBackdropWidth > 0 && this.mBackdropHeight > 0) {
                this.mBackdropLayer.onSizeChanged(this.mBackdropWidth, this.mBackdropHeight);
            }
        }
        return this.mBackdropLayer;
    }

    public void onBackdropSizeChanged(int w, int h) {
        this.mBackdropWidth = w;
        this.mBackdropHeight = h;
        if (this.mBackdropLayer != null) {
            this.mBackdropLayer.onSizeChanged(w, h);
        }
    }

    public void onBackdropSurfaceControlUpdate(SurfaceControl surfaceControl) {
        if (this.mBackdropLayer != null) {
            this.mBackdropLayer.updateSurfaceControl(surfaceControl);
        }
    }

    public void onBackdropDestroyHardwareResources() {
        if (this.mBackdropLayer != null) {
            this.mBackdropLayer.destroyHardwareResources();
        }
    }

    public void requestBackdropCapture(Object listener) {
        BackdropLayer layer;
        if (StepOSFeature.isEnabled(32) && (listener instanceof BackdropLayer.BackdropLayerListener) && (layer = ensureBackdropLayer()) != null) {
            layer.requestBackdropCapture((BackdropLayer.BackdropLayerListener) listener);
        }
    }

    public void removeBackdropCapture(Object listener) {
        if (this.mBackdropLayer != null && (listener instanceof BackdropLayer.BackdropLayerListener)) {
            this.mBackdropLayer.removeBackdropCapture((BackdropLayer.BackdropLayerListener) listener);
        }
    }

    public Drawable createBackdropLayerDrawable(ViewRootImpl viewRoot) {
        if (!StepOSFeature.isEnabled(33)) {
            return null;
        }
        return new BackdropLayerDrawable(viewRoot);
    }
}
