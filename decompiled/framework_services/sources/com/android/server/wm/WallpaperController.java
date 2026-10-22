package com.android.server.wm;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.pico.utils.ExtImplFactory;
import android.util.ArraySet;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.window.ScreenCapture;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ToBooleanFunction;
import com.android.server.wallpaper.WallpaperCropper;
import com.android.server.wallpaper.WallpaperDefaultDisplayInfo;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperController {
    private static final String TAG = "WindowManager";
    private static final int WALLPAPER_DRAW_NORMAL = 0;
    private static final int WALLPAPER_DRAW_PENDING = 1;
    private static final long WALLPAPER_DRAW_PENDING_TIMEOUT_DURATION = 500;
    private static final int WALLPAPER_DRAW_TIMEOUT = 2;
    private static final long WALLPAPER_TIMEOUT = 150;
    private static final long WALLPAPER_TIMEOUT_RECOVERY = 10000;
    private Consumer<WindowState> mComputeMaxZoomOutFunction;
    private WallpaperDefaultDisplayInfo mDefaultDisplayInfo;
    private DisplayContent mDisplayContent;
    private final FindWallpaperTargetResult mFindResults;
    private final ToBooleanFunction<WindowState> mFindWallpaperTargetFunction;
    private IExtWallpaperController mIExt;
    private Point mLargestDisplaySize;
    private boolean mLastFrozen;
    private long mLastWallpaperTimeoutTime;
    private float mLastWallpaperZoomOut;
    private float mMaxWallpaperScale;
    private float mMinWallpaperScale;
    private WindowState mPrevWallpaperTarget;
    private WindowManagerService mService;
    private boolean mShouldOffsetWallpaperCenter;
    private WindowState mWaitingOnWallpaper;
    private int mWallpaperDrawState;
    private WindowState mWallpaperTarget;
    private final ArrayList<WallpaperWindowToken> mWallpaperTokens;

    private static final class FindWallpaperTargetResult {
        boolean isWallpaperTargetForLetterbox;
        boolean mNeedsShowWhenLockedWallpaper;
        TopWallpaper mTopWallpaper;
        boolean useTopWallpaperAsTarget;
        WindowState wallpaperTarget;

        static final class TopWallpaper {
            WindowState mTopHideWhenLockedWallpaper;
            WindowState mTopShowWhenLockedWallpaper;

            TopWallpaper() {
                this.mTopHideWhenLockedWallpaper = null;
                this.mTopShowWhenLockedWallpaper = null;
            }

            void reset() {
                this.mTopHideWhenLockedWallpaper = null;
                this.mTopShowWhenLockedWallpaper = null;
            }
        }

        /* synthetic */ FindWallpaperTargetResult(WallpaperControllerIA r1) {
            this();
        }

        private FindWallpaperTargetResult() {
            this.mTopWallpaper = new TopWallpaper();
            this.useTopWallpaperAsTarget = false;
            this.wallpaperTarget = null;
            this.isWallpaperTargetForLetterbox = false;
        }

        void setTopHideWhenLockedWallpaper(WindowState win) {
            if (this.mTopWallpaper.mTopHideWhenLockedWallpaper != win) goto L5;
        L7:
            this.mTopWallpaper.mTopHideWhenLockedWallpaper = win;
            return;
        L5:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[0] == false) goto L7;
            String protoLogParam0 = String.valueOf(win);
            String protoLogParam1 = String.valueOf(this.mTopWallpaper.mTopHideWhenLockedWallpaper);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 4151327328872447804L, 0, new Object[]{protoLogParam0, protoLogParam1});
            goto L7
        }

        void setTopShowWhenLockedWallpaper(WindowState win) {
            if (this.mTopWallpaper.mTopShowWhenLockedWallpaper != win) goto L5;
        L7:
            this.mTopWallpaper.mTopShowWhenLockedWallpaper = win;
            return;
        L5:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[0] == false) goto L7;
            String protoLogParam0 = String.valueOf(win);
            String protoLogParam1 = String.valueOf(this.mTopWallpaper.mTopShowWhenLockedWallpaper);
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 6943105284590482059L, 0, new Object[]{protoLogParam0, protoLogParam1});
            goto L7
        }

        boolean hasTopHideWhenLockedWallpaper() {
            if (this.mTopWallpaper.mTopHideWhenLockedWallpaper == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasTopShowWhenLockedWallpaper() {
            if (this.mTopWallpaper.mTopShowWhenLockedWallpaper == null) goto L5;
            return true;
        L5:
            return false;
        }

        WindowState getTopWallpaper(boolean isKeyguardLocked) {
            if (isKeyguardLocked == true) goto L8;
            if (hasTopHideWhenLockedWallpaper() == false) goto L8;
            return this.mTopWallpaper.mTopHideWhenLockedWallpaper;
        L8:
            return this.mTopWallpaper.mTopShowWhenLockedWallpaper;
        }

        void setWallpaperTarget(WindowState win) {
            this.wallpaperTarget = win;
        }

        void setUseTopWallpaperAsTarget(boolean topWallpaperAsTarget) {
            this.useTopWallpaperAsTarget = topWallpaperAsTarget;
        }

        void setIsWallpaperTargetForLetterbox(boolean isWallpaperTargetForLetterbox) {
            this.isWallpaperTargetForLetterbox = isWallpaperTargetForLetterbox;
        }

        void reset() {
            this.mTopWallpaper.reset();
            this.mNeedsShowWhenLockedWallpaper = false;
            this.wallpaperTarget = null;
            this.useTopWallpaperAsTarget = false;
            this.isWallpaperTargetForLetterbox = false;
        }
    }

    public static /* synthetic */ void $r8$lambda$Foys_2tpRO31MIGZTpXv0yRJ2NM(WallpaperController r0, WindowState r1) {
        r0.lambda$new$1(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$hx8XkBssStE3IyUBABr4kxamAjk(WindowState r0, WindowState r1) {
        return lambda$updateWallpaperWindowsTarget$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$mGgSC2tR8xiTbib_tZYb3IIU2Ig(WallpaperController r0, WindowState r1) {
        return r0.lambda$new$0(r1);
    }

    private /* synthetic */ boolean lambda$new$0(WindowState w) {
        ActivityRecord ar = w.mActivityRecord;
        if (ar == null) goto L10;
        if (ar.isVisibleRequested() == true) goto L10;
        if (ar.isVisible() == true) goto L10;
        return false;
    L10:
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L13;
        Slog.v(TAG, "Win " + w + ": isOnScreen=" + w.isOnScreen() + " mDrawState=" + w.mWinAnimator.mDrawState);
    L13:
        if (this.mService.mPolicy.isKeyguardLocked() == false) goto L31;
        if (w.getExt() == null) goto L20;
        if (w.getExt().isNeedShowWhenLockedWallpaper() == false) goto L20;
        this.mFindResults.mNeedsShowWhenLockedWallpaper = true;
    L44:
        if (isBackNavigationTarget(w) == false) goto L51;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L48;
        Slog.v(TAG, "Found back animation wallpaper target: " + w);
    L48:
        this.mFindResults.setWallpaperTarget(w);
        return true;
    L51:
        if (w.hasWallpaper() == true) goto L53;
    L76:
        return false;
    L53:
        if (w.mActivityRecord == null) goto L58;
        if (w.isOnScreen() == false) goto L76;
    L61:
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L63;
        Slog.v(TAG, "Found wallpaper target: " + w);
    L63:
        this.mFindResults.setWallpaperTarget(w);
        this.mFindResults.setIsWallpaperTargetForLetterbox(w.hasWallpaperForLetterboxBackground());
        if (w != this.mWallpaperTarget) goto L71;
        if (w.isAnimating(3) == false) goto L71;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L71;
        Slog.v(TAG, "Win " + w + ": token animating, looking behind.");
    L71:
        if (w.mActivityRecord == null) goto L73;
    L75:
        return true;
    L73:
        if (this.mDisplayContent.isKeyguardGoingAway() == false) goto L75;
        return false;
    L58:
        if (w.isReadyForDisplay() == false) goto L76;
    L20:
        if (w.hasWallpaper() == false) goto L44;
        if (this.mService.mPolicy.isKeyguardHostWindow(w.mAttrs) == false) goto L44;
        if (w.mTransitionController.hasTransientLaunch(this.mDisplayContent) == false) goto L44;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L28;
        Slog.v(TAG, "Found keyguard as wallpaper target: " + w);
    L28:
        this.mFindResults.setWallpaperTarget(w);
        return false;
    L31:
        if (this.mService.mFlags.mAodTransition == false) goto L44;
        if (this.mDisplayContent.isKeyguardLockedOrAodShowing() == false) goto L44;
        if (this.mService.mPolicy.isKeyguardHostWindow(w.mAttrs) == false) goto L44;
        if (w.mTransitionController.isInAodAppearTransition() == false) goto L44;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L41;
        Slog.v(TAG, "Found aod transition wallpaper target: " + w);
    L41:
        this.mFindResults.setWallpaperTarget(w);
        return true;
    }

    private boolean isBackNavigationTarget(WindowState w) {
        return this.mService.mAtmService.mBackNavigationController.isWallpaperVisible(w);
    }

    private /* synthetic */ void lambda$new$1(WindowState windowState) {
        if (windowState.mIsWallpaper == false) goto L5;
        return;
    L5:
        if (Float.compare(windowState.mWallpaperZoomOut, this.mLastWallpaperZoomOut) <= 0) goto L9;
        this.mLastWallpaperZoomOut = windowState.mWallpaperZoomOut;
        return;
    }

    WallpaperController(WindowManagerService service, DisplayContent displayContent) {
        this.mWallpaperTokens = new ArrayList();
        this.mWallpaperTarget = null;
        this.mPrevWallpaperTarget = null;
        this.mLastWallpaperZoomOut = 0.0f;
        this.mLastFrozen = false;
        this.mWallpaperDrawState = 0;
        this.mLargestDisplaySize = null;
        this.mFindResults = new FindWallpaperTargetResult(null);
        this.mDefaultDisplayInfo = null;
        this.mFindWallpaperTargetFunction = new WallpaperController$$ExternalSyntheticLambda0(this);
        this.mComputeMaxZoomOutFunction = new WallpaperController$$ExternalSyntheticLambda1(this);
        this.mIExt = (IExtWallpaperController) ExtImplFactory.getImpl(IExtWallpaperController.class, new Object[]{this});
        this.mService = service;
        this.mDisplayContent = displayContent;
        Resources resources = service.mContext.getResources();
        this.mMinWallpaperScale = resources.getFloat(R.dimen.floating_toolbar_text_size);
        this.mMaxWallpaperScale = resources.getFloat(R.dimen.floating_toolbar_preferred_width);
        this.mShouldOffsetWallpaperCenter = resources.getBoolean(R.bool.config_pinnerAssistantApp);
    }

    void resetLargestDisplay(Display display) {
        if (display != null) goto L4;
        return;
    L4:
        if (display.getType() != 1) goto L8;
        this.mLargestDisplaySize = null;
        return;
    }

    void setMinWallpaperScale(float minScale) {
        this.mMinWallpaperScale = minScale;
    }

    void setMaxWallpaperScale(float maxScale) {
        this.mMaxWallpaperScale = maxScale;
    }

    void setShouldOffsetWallpaperCenter(boolean shouldOffset) {
        this.mShouldOffsetWallpaperCenter = shouldOffset;
    }

    private Point findLargestDisplaySize() {
        boolean r0 = this.mShouldOffsetWallpaperCenter;
        return null;
    }

    WindowState getWallpaperTarget() {
        return this.mWallpaperTarget;
    }

    WindowState getPrevWallpaperTarget() {
        return this.mPrevWallpaperTarget;
    }

    boolean isWallpaperTarget(WindowState win) {
        if (win != this.mWallpaperTarget) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isBelowWallpaperTarget(WindowState win) {
        if (this.mWallpaperTarget != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mWallpaperTarget.mLayer < win.mBaseLayer) goto L7;
        return true;
    }

    boolean isWallpaperVisible() {
        int i = this.mWallpaperTokens.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mWallpaperTokens.get(i).isVisible() == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean hasVisibleRequestedShowWhenLockedWallpaper() {
        int i = this.mWallpaperTokens.size() - 1;
    L3:
        if (i < 0) goto L10;
        WallpaperWindowToken token = this.mWallpaperTokens.get(i);
        if (token.canShowWhenLocked() == false) goto L9;
        if (token.isVisibleRequested() == false) goto L9;
        return true;
    L9:
        i = i - 1;
        goto L3
    L10:
        return false;
    }

    void hideDeferredWallpapersIfNeededLegacy() {
        int i = this.mWallpaperTokens.size() - 1;
    L3:
        if (i < 0) goto L9;
        WallpaperWindowToken token = this.mWallpaperTokens.get(i);
        if (token.isVisibleRequested() == true) goto L7;
        token.commitVisibility(false);
    L7:
        i = i - 1;
        goto L3
    }

    void hideWallpapers(WindowState winGoingAway) {
        if (this.mWallpaperTarget == null) goto L10;
        if (this.mWallpaperTarget == winGoingAway) goto L7;
        return;
    L7:
        if (this.mPrevWallpaperTarget == null) goto L10;
        return;
    L10:
        if (this.mFindResults.useTopWallpaperAsTarget == false) goto L12;
        return;
    L12:
        int i = this.mWallpaperTokens.size() - 1;
    L13:
        if (i < 0) goto L21;
        WallpaperWindowToken token = this.mWallpaperTokens.get(i);
        if (token.isVisible() == false) goto L19;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[0] == false) goto L19;
        String protoLogParam0 = String.valueOf(token);
        String protoLogParam1 = String.valueOf(winGoingAway);
        String protoLogParam2 = String.valueOf(this.mWallpaperTarget);
        String protoLogParam3 = String.valueOf(this.mPrevWallpaperTarget);
        String protoLogParam4 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -5254364639040552989L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2, protoLogParam3, protoLogParam4});
    L19:
        token.setVisibility(false);
        i = i - 1;
        goto L13
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    boolean updateWallpaperOffset(WindowState wallpaperWin, boolean sync) {
        Rect lastWallpaperBounds = wallpaperWin.getParentFrame();
        int screenWidth = lastWallpaperBounds.width();
        int screenHeight = lastWallpaperBounds.height();
        float screenRatio = screenWidth / screenHeight;
        Point screenSize = new Point(screenWidth, screenHeight);
        WallpaperWindowToken token = wallpaperWin.mToken.asWallpaperToken();
        Point bitmapSize = new Point(wallpaperWin.mRequestedWidth, wallpaperWin.mRequestedHeight);
        SparseArray<Rect> cropHints = token.getCropHints();
        if (bitmapSize.x > 0) goto L5;
    L8:
        Rect wallpaperFrame = wallpaperWin.getFrame();
    L9:
        int frameWidth = wallpaperFrame.width();
        int frameHeight = wallpaperFrame.height();
        float frameRatio = frameWidth / frameHeight;
        if (frameRatio < screenRatio) goto L12;
        boolean scaleHeight = true;
    L13:
        float zoom = 1.0f;
        if (wallpaperFrame.isEmpty() == false) goto L16;
        float cropZoom = 1.0f;
    L20:
        if (scaleHeight == false) goto L22;
        float w = frameHeight * screenRatio;
    L23:
        if (scaleHeight == false) goto L25;
        float w2 = frameHeight;
    L26:
        float h = w2;
        int screenWidth2 = (-wallpaperFrame.left) + ((int) (((cropZoom - 1.0f) * w) / 2.0f));
        int screenHeight2 = (-wallpaperFrame.top) + ((int) (((cropZoom - 1.0f) * h) / 2.0f));
        int diffWidth = (int) (wallpaperWin.mHScale * (frameWidth - w));
        int diffHeight = (int) (wallpaperWin.mVScale * (frameHeight - h));
        if (wallpaperWin.isRtl() == false) goto L29;
        float defaultWallpaperX = 1.0f;
    L31:
        if (token.mWallpaperX < 0.0f) goto L33;
        float wpx = token.mWallpaperX;
    L34:
        float r19 = -1.0f;
        if (token.mWallpaperXStep < 0.0f) goto L37;
        float wpxs = token.mWallpaperXStep;
    L38:
        int displayOffset = getDisplayWidthOffset(diffWidth, lastWallpaperBounds, wallpaperWin.isRtl());
        int availw = diffWidth - displayOffset;
        if (availw <= 0) goto L41;
        float r26 = 0.5f;
        int offsetX = -((int) ((availw * wpx) + 0.5f));
    L42:
        int offsetX2 = offsetX;
        int offsetX3 = token.mWallpaperDisplayOffsetX;
        if (offsetX3 == Integer.MIN_VALUE) goto L46;
        int offsetX4 = offsetX2 + token.mWallpaperDisplayOffsetX;
    L49:
        int offsetX5 = (int) (offsetX4 + (wallpaperWin.mHScale * screenWidth2));
        if (wallpaperWin.mWallpaperX == wpx) goto L52;
    L55:
        wallpaperWin.mWallpaperX = wpx;
        wallpaperWin.mWallpaperXStep = wpxs;
        boolean rawChanged = true;
    L56:
        boolean rawChanged2 = rawChanged;
        if (token.mWallpaperY < 0.0f) goto L59;
        float r0 = token.mWallpaperY;
    L60:
        float wpy = r0;
        if (token.mWallpaperYStep < 0.0f) goto L63;
        r19 = token.mWallpaperYStep;
    L63:
        float wpys = r19;
        if (diffHeight <= 0) goto L66;
        int offsetY = -((int) ((diffHeight * wpy) + r26));
    L67:
        int offsetY2 = offsetY;
        int offsetY3 = token.mWallpaperDisplayOffsetY;
        if (offsetY3 == Integer.MIN_VALUE) goto L70;
        int offsetY4 = offsetY2 + token.mWallpaperDisplayOffsetY;
    L71:
        int offsetY5 = (int) (offsetY4 + (wallpaperWin.mVScale * screenHeight2));
        if (wallpaperWin.mWallpaperY == wpy) goto L74;
    L77:
        wallpaperWin.mWallpaperY = wpy;
        float wpys2 = wpys;
        wallpaperWin.mWallpaperYStep = wpys2;
        boolean rawChanged3 = true;
    L78:
        boolean rawChanged4 = rawChanged3;
        if (Float.compare(wallpaperWin.mWallpaperZoomOut, this.mLastWallpaperZoomOut) == 0) goto L82;
        wallpaperWin.mWallpaperZoomOut = this.mLastWallpaperZoomOut;
        rawChanged4 = true;
    L82:
        if (wallpaperWin.mShouldScaleWallpaper == false) goto L85;
        zoom = zoomOutToScale(wallpaperWin.mWallpaperZoomOut);
    L85:
        float totalZoom = zoom * cropZoom;
        boolean changed = wallpaperWin.setWallpaperOffset(offsetX5, offsetY5, totalZoom);
        if (rawChanged4 == false) goto L160;
        if ((wallpaperWin.mAttrs.privateFlags & 4) == 0) goto L160;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L103;
        StringBuilder r3 = new StringBuilder();     // Catch: RemoteException -> L98
        r3.append("Report new wp offset ");     // Catch: RemoteException -> L96
        r3.append(wallpaperWin);     // Catch: RemoteException -> L96
        r3.append(" x=");     // Catch: RemoteException -> L96
        r3.append(wallpaperWin.mWallpaperX);     // Catch: RemoteException -> L96
        r3.append(" y=");     // Catch: RemoteException -> L96
        r3.append(wallpaperWin.mWallpaperY);     // Catch: RemoteException -> L96
        r3.append(" zoom=");     // Catch: RemoteException -> L96
        r3.append(wallpaperWin.mWallpaperZoomOut);     // Catch: RemoteException -> L96
        Slog.v(TAG, r3.toString());     // Catch: RemoteException -> L96
    L103:
        if (sync == false) goto L165;
        this.mWaitingOnWallpaper = wallpaperWin;     // Catch: RemoteException -> L96
    L165:
        wallpaperWin.mClient.dispatchWallpaperOffsets(wallpaperWin.mWallpaperX, wallpaperWin.mWallpaperY, wallpaperWin.mWallpaperXStep, wallpaperWin.mWallpaperYStep, wallpaperWin.mWallpaperZoomOut, sync);     // Catch: RemoteException -> L152
        if (sync == false) goto L160;
        if (this.mWaitingOnWallpaper == null) goto L160;
        long start = SystemClock.uptimeMillis();     // Catch: RemoteException -> L152
        if ((this.mLastWallpaperTimeoutTime + 10000) >= start) goto L148;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L128;
    L167:
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -6856158722649737204L, 0, null);     // Catch: RemoteException -> L119 InterruptedException -> L121
    L128:
        this.mService.mGlobalLock.wait(150);     // Catch: RemoteException -> L119 InterruptedException -> L121
    L176:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L134;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -5966696477376431672L, 0, null);     // Catch: RemoteException -> L119
    L134:
        if ((start + 150) >= SystemClock.uptimeMillis()) goto L148;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L145;
        String protoLogParam0 = String.valueOf(wallpaperWin);     // Catch: RemoteException -> L142
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 4198834090919802045L, 0, new Object[]{protoLogParam0});     // Catch: RemoteException -> L140
    L145:
        this.mLastWallpaperTimeoutTime = start;     // Catch: RemoteException -> L140
    L148:
        this.mWaitingOnWallpaper = null;     // Catch: RemoteException -> L140
    L160:
        return changed;
    L74:
        if (wallpaperWin.mWallpaperYStep != wpys) goto L77;
        wpys2 = wpys;
        rawChanged3 = rawChanged2;
        goto L78
    L70:
        offsetY4 = offsetY2;
        goto L71
    L66:
        offsetY = 0;
        goto L67
    L59:
        r0 = r26;
        goto L60
    L52:
        if (wallpaperWin.mWallpaperXStep != wpxs) goto L55;
        rawChanged = false;
        goto L56
    L46:
        if (wallpaperWin.isRtl() == true) goto L48;
        offsetX4 = offsetX2 - displayOffset;
        goto L49
    L48:
        offsetX4 = offsetX2;
        goto L49
    L41:
        r26 = 0.5f;
        offsetX = 0;
        goto L42
    L37:
        wpxs = -1.0f;
        goto L38
    L33:
        wpx = defaultWallpaperX;
        goto L34
    L29:
        defaultWallpaperX = 0.0f;
        goto L31
    L25:
        float w3 = frameWidth;
        w2 = w3 / screenRatio;
        goto L26
    L22:
        w = frameWidth;
        goto L23
    L16:
        if (scaleHeight == false) goto L18;
        cropZoom = (screenHeight / frameHeight) / wallpaperWin.mVScale;
        goto L20
    L18:
        cropZoom = (screenWidth / frameWidth) / wallpaperWin.mHScale;
        goto L20
    L12:
        scaleHeight = false;
        goto L13
    L5:
        if (bitmapSize.y <= 0) goto L8;
        wallpaperFrame = WallpaperCropper.getCrop(screenSize, getOrCreateDefaultDisplayInfo(), bitmapSize, cropHints, wallpaperWin.isRtl());
        goto L9
    }

    private WallpaperDefaultDisplayInfo getOrCreateDefaultDisplayInfo() {
        if (this.mDefaultDisplayInfo != null) goto L5;
        WindowManager windowManager = (WindowManager) this.mService.mContext.getSystemService(WindowManager.class);
        Resources resources = this.mService.mContext.getResources();
        this.mDefaultDisplayInfo = new WallpaperDefaultDisplayInfo(windowManager, resources);
        return this.mDefaultDisplayInfo;
    L5:
        return this.mDefaultDisplayInfo;
    }

    private int getDisplayWidthOffset(int availWidth, Rect displayFrame, boolean isRtl) {
        boolean r0 = this.mShouldOffsetWallpaperCenter;
        return 0;
    }

    void setWindowWallpaperPosition(WindowState window, float x, float y, float xStep, float yStep) {
        if (window.mWallpaperX == x) goto L5;
    L6:
        window.mWallpaperX = x;
        window.mWallpaperY = y;
        window.mWallpaperXStep = xStep;
        window.mWallpaperYStep = yStep;
        updateWallpaperOffsetLocked(window, !this.mService.mFlags.mWallpaperOffsetAsync);
        return;
    L5:
        if (window.mWallpaperY != y) goto L6;
    }

    void setWallpaperZoomOut(WindowState window, float zoom) {
        if (Float.compare(window.mWallpaperZoomOut, zoom) == 0) goto L7;
        window.mWallpaperZoomOut = zoom;
        computeLastWallpaperZoomOut();
        int i = this.mWallpaperTokens.size() - 1;
    L5:
        if (i < 0) goto L9;
        WallpaperWindowToken token = this.mWallpaperTokens.get(i);
        token.updateWallpaperOffset(false);
        i = i - 1;
        goto L5
    L9:
        return;
    }

    void setShouldZoomOutWallpaper(WindowState window, boolean shouldZoom) {
        if (shouldZoom == window.mShouldScaleWallpaper) goto L6;
        window.mShouldScaleWallpaper = shouldZoom;
        updateWallpaperOffsetLocked(window, false);
        return;
    }

    void setWindowWallpaperDisplayOffset(WindowState window, int x, int y) {
        if (window.mWallpaperDisplayOffsetX == x) goto L5;
    L6:
        window.mWallpaperDisplayOffsetX = x;
        window.mWallpaperDisplayOffsetY = y;
        updateWallpaperOffsetLocked(window, !this.mService.mFlags.mWallpaperOffsetAsync);
        return;
    L5:
        if (window.mWallpaperDisplayOffsetY != y) goto L6;
    }

    void sendWindowWallpaperCommandUnchecked(WindowState window, String action, int x, int y, int z, Bundle extras, boolean sync) {
        sendWindowWallpaperCommand(action, x, y, z, extras, sync);
    }

    private void sendWindowWallpaperCommand(String action, int x, int y, int z, Bundle extras, boolean sync) {
        int curTokenNdx = this.mWallpaperTokens.size() - 1;
    L3:
        if (curTokenNdx < 0) goto L6;
        WallpaperWindowToken token = this.mWallpaperTokens.get(curTokenNdx);
        token.sendWindowWallpaperCommand(action, x, y, z, extras, sync);
        curTokenNdx = curTokenNdx - 1;
        goto L3
    }

    private void updateWallpaperOffsetLocked(WindowState changingTarget, boolean sync) {
        WindowState target = this.mWallpaperTarget;
        if (target == null) goto L5;
    L9:
        WallpaperWindowToken token = getTokenForTarget(target);
        if (token != null) goto L13;
        return;
    L13:
        if (target.mWallpaperX < 0.0f) goto L16;
        token.mWallpaperX = target.mWallpaperX;
    L19:
        if (target.mWallpaperY < 0.0f) goto L22;
        token.mWallpaperY = target.mWallpaperY;
    L25:
        if (target.mWallpaperDisplayOffsetX == Integer.MIN_VALUE) goto L28;
        token.mWallpaperDisplayOffsetX = target.mWallpaperDisplayOffsetX;
    L31:
        if (target.mWallpaperDisplayOffsetY == Integer.MIN_VALUE) goto L34;
        token.mWallpaperDisplayOffsetY = target.mWallpaperDisplayOffsetY;
    L37:
        if (target.mWallpaperXStep < 0.0f) goto L40;
        token.mWallpaperXStep = target.mWallpaperXStep;
    L43:
        if (target.mWallpaperYStep < 0.0f) goto L46;
        token.mWallpaperYStep = target.mWallpaperYStep;
    L48:
        token.updateWallpaperOffset(sync);
        return;
    L46:
        if (changingTarget.mWallpaperYStep < 0.0f) goto L48;
        token.mWallpaperYStep = changingTarget.mWallpaperYStep;
        goto L48
    L40:
        if (changingTarget.mWallpaperXStep < 0.0f) goto L43;
        token.mWallpaperXStep = changingTarget.mWallpaperXStep;
        goto L43
    L34:
        if (changingTarget.mWallpaperDisplayOffsetY == Integer.MIN_VALUE) goto L37;
        token.mWallpaperDisplayOffsetY = changingTarget.mWallpaperDisplayOffsetY;
        goto L37
    L28:
        if (changingTarget.mWallpaperDisplayOffsetX == Integer.MIN_VALUE) goto L31;
        token.mWallpaperDisplayOffsetX = changingTarget.mWallpaperDisplayOffsetX;
        goto L31
    L22:
        if (changingTarget.mWallpaperY < 0.0f) goto L25;
        token.mWallpaperY = changingTarget.mWallpaperY;
        goto L25
    L16:
        if (changingTarget.mWallpaperX < 0.0f) goto L19;
        token.mWallpaperX = changingTarget.mWallpaperX;
        goto L19
    L5:
        if (changingTarget.mToken.isVisible() == false) goto L9;
        if (changingTarget.mTransitionController.inTransition() == false) goto L9;
        target = changingTarget;
        goto L9
    }

    private WallpaperWindowToken getTokenForTarget(WindowState target) {
        if (target != null) goto L5;
        return null;
    L5:
        FindWallpaperTargetResult r1 = this.mFindResults;
        if (target.canShowWhenLocked() == false) goto L10;
        if (this.mService.isKeyguardLocked() == false) goto L10;
    L13:
        boolean r2 = true;
    L15:
        WindowState window = r1.getTopWallpaper(r2);
        if (window != null) goto L19;
        return null;
    L19:
        return window.mToken.asWallpaperToken();
    L10:
        if (this.mService.mFlags.mAodTransition == true) goto L12;
    L14:
        r2 = false;
        goto L15
    L12:
        if (this.mDisplayContent.isAodShowing() == false) goto L14;
        goto L13
    }

    void clearLastWallpaperTimeoutTime() {
        this.mLastWallpaperTimeoutTime = 0;
    }

    void wallpaperCommandComplete(IBinder window) {
        if (this.mWaitingOnWallpaper != null) goto L5;
        return;
    L5:
        if (this.mWaitingOnWallpaper.mClient.asBinder() != window) goto L9;
        this.mWaitingOnWallpaper = null;
        this.mService.mGlobalLock.notifyAll();
        return;
    }

    void wallpaperOffsetsComplete(IBinder window) {
        if (this.mWaitingOnWallpaper != null) goto L5;
        return;
    L5:
        if (this.mWaitingOnWallpaper.mClient.asBinder() != window) goto L9;
        this.mWaitingOnWallpaper = null;
        this.mService.mGlobalLock.notifyAll();
        return;
    }

    private void findWallpaperTarget() {
        this.mFindResults.reset();
        if (this.mService.mAtmService.mSupportsFreeformWindowManagement == true) goto L5;
    L7:
        findWallpapers();
        this.mDisplayContent.forAllWindows(this.mFindWallpaperTargetFunction, true);
        if (this.mFindResults.mNeedsShowWhenLockedWallpaper == false) goto L11;
        this.mFindResults.setUseTopWallpaperAsTarget(true);
    L11:
        if (this.mFindResults.wallpaperTarget == null) goto L13;
        return;
    L13:
        if (this.mFindResults.useTopWallpaperAsTarget == false) goto L21;
        FindWallpaperTargetResult r0 = this.mFindResults;
        FindWallpaperTargetResult r1 = this.mFindResults;
        if (this.mService.mFlags.mAodTransition == false) goto L17;
        boolean r2 = this.mDisplayContent.isKeyguardLockedOrAodShowing();
    L18:
        r0.setWallpaperTarget(r1.getTopWallpaper(r2));
        return;
    L17:
        r2 = this.mDisplayContent.isKeyguardLocked();
        goto L18
    L21:
        return;
    L5:
        if (this.mDisplayContent.getDefaultTaskDisplayArea().isRootTaskVisible(5) == false) goto L7;
        this.mFindResults.setUseTopWallpaperAsTarget(true);
        goto L7
    }

    private void findWallpapers() {
        int i = this.mWallpaperTokens.size() - 1;
    L3:
        if (i < 0) goto L20;
        WallpaperWindowToken token = this.mWallpaperTokens.get(i);
        boolean canShowWhenLocked = token.canShowWhenLocked();
        int j = token.getChildCount() - 1;
    L5:
        if (j < 0) goto L18;
        WindowState w = token.getChildAt(j);
        if (w.mIsWallpaper == false) goto L17;
        if (canShowWhenLocked == true) goto L11;
    L13:
        if (canShowWhenLocked == true) goto L17;
        if (this.mFindResults.hasTopHideWhenLockedWallpaper() == true) goto L17;
        this.mFindResults.setTopHideWhenLockedWallpaper(w);
        goto L17
    L11:
        if (this.mFindResults.hasTopShowWhenLockedWallpaper() == true) goto L13;
        this.mFindResults.setTopShowWhenLockedWallpaper(w);
    L17:
        j = j - 1;
        goto L5
    L18:
        i = i - 1;
        goto L3
    }

    void collectTopWallpapers(Transition transition) {
        if (this.mFindResults.hasTopShowWhenLockedWallpaper() == false) goto L9;
        if (this.mService.mFlags.mEnsureWallpaperInTransitions == false) goto L7;
        transition.collect(this.mFindResults.mTopWallpaper.mTopShowWhenLockedWallpaper.mToken);
        goto L9
    L7:
        transition.collect(this.mFindResults.mTopWallpaper.mTopShowWhenLockedWallpaper);
    L9:
        if (this.mFindResults.hasTopHideWhenLockedWallpaper() == true) goto L11;
        return;
    L11:
        if (this.mService.mFlags.mEnsureWallpaperInTransitions == false) goto L13;
        transition.collect(this.mFindResults.mTopWallpaper.mTopHideWhenLockedWallpaper.mToken);
        return;
    L13:
        transition.collect(this.mFindResults.mTopWallpaper.mTopHideWhenLockedWallpaper);
    }

    private boolean isFullscreen(WindowManager.LayoutParams attrs) {
        if (attrs.x == 0) goto L5;
    L11:
        return false;
    L5:
        if (attrs.y != 0) goto L11;
        if (attrs.width != (-1)) goto L11;
        if (attrs.height != (-1)) goto L11;
        return true;
    }

    private void updateWallpaperWindowsTarget(FindWallpaperTargetResult result) {
        WindowState wallpaperTarget = result.wallpaperTarget;
        if (this.mWallpaperTarget == wallpaperTarget) goto L58;
        if (this.mPrevWallpaperTarget == null) goto L10;
        if (this.mPrevWallpaperTarget == wallpaperTarget) goto L58;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L12;
        String protoLogParam0 = String.valueOf(wallpaperTarget);
        String protoLogParam1 = String.valueOf(this.mWallpaperTarget);
        String protoLogParam2 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -3751289048117070874L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L12:
        getExt().traceNewWallpaperTarget(wallpaperTarget, this.mWallpaperTarget);
        this.mPrevWallpaperTarget = null;
        final WindowState prevWallpaperTarget = this.mWallpaperTarget;
        this.mWallpaperTarget = wallpaperTarget;
        if (prevWallpaperTarget != null) goto L16;
        if (wallpaperTarget == null) goto L16;
        updateWallpaperOffsetLocked(this.mWallpaperTarget, false);
    L16:
        if (wallpaperTarget == null) goto L55;
        if (prevWallpaperTarget == null) goto L69;
        boolean oldAnim = prevWallpaperTarget.isAnimatingLw();
        boolean foundAnim = wallpaperTarget.isAnimatingLw();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L22;
        String protoLogParam3 = String.valueOf(foundAnim);
        String protoLogParam4 = String.valueOf(oldAnim);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 5625223922466895079L, 0, new Object[]{protoLogParam3, protoLogParam4});
    L22:
        if (foundAnim == false) goto L54;
        if (oldAnim == true) goto L26;
        return;
    L26:
        if (this.mDisplayContent.getWindow(new WallpaperController$$ExternalSyntheticLambda2(prevWallpaperTarget)) != null) goto L29;
        return;
    L29:
        if (wallpaperTarget.mActivityRecord != null) goto L31;
    L33:
        boolean newTargetHidden = false;
    L35:
        if (prevWallpaperTarget.mActivityRecord != null) goto L37;
    L39:
        boolean oldTargetHidden = false;
    L41:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L44;
        String protoLogParam5 = String.valueOf(prevWallpaperTarget);
        boolean protoLogParam6 = oldTargetHidden;
        String protoLogParam7 = String.valueOf(wallpaperTarget);
        boolean protoLogParam8 = newTargetHidden;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 7634524672408826188L, 204, new Object[]{protoLogParam5, Boolean.valueOf(protoLogParam6), protoLogParam7, Boolean.valueOf(protoLogParam8)});
    L44:
        this.mPrevWallpaperTarget = prevWallpaperTarget;
        if (newTargetHidden == false) goto L51;
        if (oldTargetHidden == true) goto L51;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L50;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -4345077332231178044L, 0, null);
    L50:
        this.mWallpaperTarget = prevWallpaperTarget;
    L51:
        result.setWallpaperTarget(wallpaperTarget);
        return;
    L37:
        if (prevWallpaperTarget.mActivityRecord.isVisibleRequested() == true) goto L39;
        oldTargetHidden = true;
        goto L41
    L31:
        if (wallpaperTarget.mActivityRecord.isVisibleRequested() == true) goto L33;
        newTargetHidden = true;
        goto L35
    L54:
        return;
    L69:
        return;
    L55:
        return;
    L58:
        if (this.mPrevWallpaperTarget != null) goto L61;
        return;
    L61:
        if (this.mPrevWallpaperTarget.isAnimatingLw() == false) goto L63;
        return;
    L63:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L65;
        WindowState r7 = null;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -3477087868568520027L, 0, null);
    L66:
        this.mPrevWallpaperTarget = r7;
        this.mWallpaperTarget = wallpaperTarget;
        return;
    L65:
        r7 = null;
        goto L66
    }

    private static /* synthetic */ boolean lambda$updateWallpaperWindowsTarget$2(WindowState prevWallpaperTarget, WindowState w) {
        if (w != prevWallpaperTarget) goto L4;
        return true;
    L4:
        return false;
    }

    private void updateWallpaperTokens(boolean visibility, boolean keyguardLocked) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L5;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 257349083882992098L, 15, new Object[]{Boolean.valueOf(visibility), Boolean.valueOf(keyguardLocked)});
    L5:
        WindowState topWallpaper = this.mFindResults.getTopWallpaper(keyguardLocked);
        if (topWallpaper != null) goto L8;
        WallpaperWindowToken topWallpaperToken = null;
    L9:
        int curTokenNdx = this.mWallpaperTokens.size() - 1;
    L10:
        if (curTokenNdx < 0) goto L18;
        WallpaperWindowToken token = this.mWallpaperTokens.get(curTokenNdx);
        if (visibility == false) goto L15;
        if (token != topWallpaperToken) goto L15;
        boolean r5 = true;
    L16:
        token.updateWallpaperWindows(r5);
        curTokenNdx = curTokenNdx - 1;
    L15:
        r5 = false;
        goto L16
    L18:
        return;
    L8:
        topWallpaperToken = topWallpaper.mToken.asWallpaperToken();
        goto L9
    }

    void adjustWallpaperWindows() {
        this.mDisplayContent.mWallpaperMayChange = false;
        findWallpaperTarget();
        updateWallpaperWindowsTarget(this.mFindResults);
        WallpaperWindowToken token = getTokenForTarget(this.mWallpaperTarget);
        if (token == null) goto L5;
        boolean visible = true;
    L6:
        if (visible == true) goto L8;
    L19:
        boolean visibleRequested = visible;
        if (this.mDisplayContent.mWmService.mFlags.mEnsureWallpaperInTransitions == false) goto L31;
        if (this.mWallpaperTarget != null) goto L24;
    L26:
        boolean r5 = false;
    L27:
        visibleRequested = r5;
        if (getExt() == null) goto L31;
        visibleRequested = visibleRequested | getExt().keepVisibleIfNeed(this.mWallpaperTarget, visible, visibleRequested, this.mFindResults.mNeedsShowWhenLockedWallpaper);
        goto L31
    L24:
        if (this.mWallpaperTarget.isVisibleRequested() == false) goto L26;
        r5 = true;
    L31:
        if (this.mService.mFlags.mAodTransition == false) goto L33;
        boolean r6 = this.mDisplayContent.isKeyguardLockedOrAodShowing();
    L34:
        updateWallpaperTokens(visibleRequested, r6);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L41;
        long protoLogParam0 = this.mDisplayContent.getDisplayId();
        boolean protoLogParam1 = visible;
        if (this.mService.mFlags.mAodTransition == false) goto L39;
        boolean protoLogParam2 = this.mDisplayContent.isKeyguardLockedOrAodShowing();
    L40:
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, 7408402065665963407L, 61, new Object[]{Long.valueOf(protoLogParam0), Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2)});
        goto L41
    L39:
        protoLogParam2 = this.mDisplayContent.isKeyguardLocked();
    L41:
        if (visible == true) goto L43;
    L50:
        WallpaperController r7 = this;
    L52:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[0] == false) goto L55;
        String protoLogParam3 = String.valueOf(r7.mWallpaperTarget);
        String protoLogParam4 = String.valueOf(r7.mPrevWallpaperTarget);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -8598497865499265448L, 0, new Object[]{protoLogParam3, protoLogParam4});
        return;
    L55:
        return;
    L43:
        if (this.mLastFrozen == this.mFindResults.isWallpaperTargetForLetterbox) goto L50;
        this.mLastFrozen = this.mFindResults.isWallpaperTargetForLetterbox;
        if (this.mFindResults.isWallpaperTargetForLetterbox == false) goto L48;
        String r2 = "android.wallpaper.freeze";
    L49:
        r7 = this;
        r7.sendWindowWallpaperCommand(r2, 0, 0, 0, null, false);
        goto L52
    L48:
        r2 = "android.wallpaper.unfreeze";
        goto L49
    L33:
        r6 = this.mDisplayContent.isKeyguardLocked();
        goto L34
    L8:
        if (this.mWallpaperTarget.mWallpaperX < 0.0f) goto L11;
        token.mWallpaperX = this.mWallpaperTarget.mWallpaperX;
        token.mWallpaperXStep = this.mWallpaperTarget.mWallpaperXStep;
    L11:
        if (this.mWallpaperTarget.mWallpaperY < 0.0f) goto L14;
        token.mWallpaperY = this.mWallpaperTarget.mWallpaperY;
        token.mWallpaperYStep = this.mWallpaperTarget.mWallpaperYStep;
    L14:
        if (this.mWallpaperTarget.mWallpaperDisplayOffsetX == Integer.MIN_VALUE) goto L17;
        token.mWallpaperDisplayOffsetX = this.mWallpaperTarget.mWallpaperDisplayOffsetX;
    L17:
        if (this.mWallpaperTarget.mWallpaperDisplayOffsetY == Integer.MIN_VALUE) goto L19;
        token.mWallpaperDisplayOffsetY = this.mWallpaperTarget.mWallpaperDisplayOffsetY;
        goto L19
    L5:
        visible = false;
        goto L6
    }

    boolean processWallpaperDrawPendingTimeout() {
        if (this.mWallpaperDrawState != 1) goto L9;
        this.mWallpaperDrawState = 2;
        if (WindowManagerDebugConfig.DEBUG_WALLPAPER == false) goto L7;
        Slog.v(TAG, "*** WALLPAPER DRAW TIMEOUT");
    L7:
        this.mService.mAtmService.mBackNavigationController.startAnimation();
        return true;
    L9:
        return false;
    }

    boolean wallpaperTransitionReady() {
        boolean transitionReady = true;
        boolean wallpaperReady = true;
        int curTokenIndex = this.mWallpaperTokens.size() - 1;
    L4:
        if (curTokenIndex < 0) goto L18;
        if (1 == 0) goto L18;
        WallpaperWindowToken token = this.mWallpaperTokens.get(curTokenIndex);
        if (token.hasVisibleNotDrawnWallpaper() == true) goto L8;
        curTokenIndex = curTokenIndex - 1;
        goto L4
    L8:
        wallpaperReady = false;
        if (this.mWallpaperDrawState == 2) goto L12;
        transitionReady = false;
    L12:
        if (this.mWallpaperDrawState != 0) goto L15;
        this.mWallpaperDrawState = 1;
        this.mService.mH.removeMessages(39, this);
        this.mService.mH.sendMessageDelayed(this.mService.mH.obtainMessage(39, this), 500);
    L15:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WALLPAPER_enabled[1] == false) goto L18;
        long protoLogParam0 = this.mWallpaperDrawState;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_WALLPAPER, -5402010429724738603L, 1, new Object[]{Long.valueOf(protoLogParam0)});
    L18:
        if (wallpaperReady == false) goto L20;
        this.mWallpaperDrawState = 0;
        this.mService.mH.removeMessages(39, this);
    L20:
        return transitionReady;
    }

    void adjustWallpaperWindowsForAppTransitionIfNeeded(ArraySet<ActivityRecord> openingApps) {
        boolean adjust = false;
        if ((this.mDisplayContent.pendingLayoutChanges & 4) == 0) goto L5;
        adjust = true;
    L11:
        if (adjust == false) goto L16;
        adjustWallpaperWindows();
        return;
    L16:
        return;
    L5:
        int i = openingApps.size() - 1;
    L6:
        if (i < 0) goto L11;
        ActivityRecord activity = openingApps.valueAt(i);
        if (activity.windowsCanBeWallpaperTarget() == true) goto L9;
        i = i - 1;
        goto L6
    L9:
        adjust = true;
        goto L11
    }

    void addWallpaperToken(WallpaperWindowToken token) {
        this.mWallpaperTokens.add(token);
    }

    void removeWallpaperToken(WallpaperWindowToken token) {
        this.mWallpaperTokens.remove(token);
    }

    void onWallpaperTokenReordered() {
        if (this.mWallpaperTokens.size() <= 1) goto L6;
        this.mWallpaperTokens.sort(null);
        return;
    }

    boolean canScreenshotWallpaper() {
        return canScreenshotWallpaper(getTopVisibleWallpaper());
    }

    private boolean canScreenshotWallpaper(WindowState wallpaperWindowState) {
        if (this.mService.mPolicy.isScreenOn() == false) goto L5;
        if (wallpaperWindowState == null) goto L10;
        return true;
    L10:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L12;
        Slog.i(TAG, "No visible wallpaper to screenshot");
    L12:
        return false;
    L5:
        if (WindowManagerDebugConfig.DEBUG_SCREENSHOT == false) goto L7;
        Slog.i(TAG, "Attempted to take screenshot while display was off.");
    L7:
        return false;
    }

    Bitmap screenshotWallpaperLocked() {
        WindowState wallpaperWindowState = getTopVisibleWallpaper();
        if (canScreenshotWallpaper(wallpaperWindowState) == true) goto L5;
        return null;
    L5:
        Rect bounds = wallpaperWindowState.getBounds();
        bounds.offsetTo(0, 0);
        ScreenCapture.ScreenshotHardwareBuffer wallpaperBuffer = ScreenCapture.captureLayers(wallpaperWindowState.getSurfaceControl(), bounds, 1.0f);
        if (wallpaperBuffer != null) goto L10;
        Slog.w(TAG, "Failed to screenshot wallpaper");
        return null;
    L10:
        return Bitmap.wrapHardwareBuffer(wallpaperBuffer.getHardwareBuffer(), wallpaperBuffer.getColorSpace());
    }

    SurfaceControl mirrorWallpaperSurface() {
        WindowState wallpaperWindowState = getTopVisibleWallpaper();
        if (wallpaperWindowState != null) goto L7;
        return null;
    L7:
        return SurfaceControl.mirrorSurface(wallpaperWindowState.mToken.getSurfaceControl());
    }

    WindowState getTopVisibleWallpaper() {
        int curTokenNdx = this.mWallpaperTokens.size() - 1;
    L3:
        if (curTokenNdx < 0) goto L13;
        WallpaperWindowToken token = this.mWallpaperTokens.get(curTokenNdx);
        int i = token.getChildCount() - 1;
    L5:
        if (i < 0) goto L12;
        WindowState w = token.getChildAt(i);
        if (w.mWinAnimator.getShown() == false) goto L11;
        if (w.mWinAnimator.mLastAlpha <= 0.0f) goto L11;
        return w;
    L11:
        i = i - 1;
        goto L5
    L12:
        curTokenNdx = curTokenNdx - 1;
        goto L3
    L13:
        return null;
    }

    private void computeLastWallpaperZoomOut() {
        this.mLastWallpaperZoomOut = 0.0f;
        this.mDisplayContent.forAllWindows(this.mComputeMaxZoomOutFunction, true);
    }

    private float zoomOutToScale(float zoomOut) {
        return MathUtils.lerp(this.mMinWallpaperScale, this.mMaxWallpaperScale, 1.0f - zoomOut);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("displayId=");
        pw.println(this.mDisplayContent.getDisplayId());
        pw.print(prefix);
        pw.print("mWallpaperTarget=");
        pw.println(this.mWallpaperTarget);
        pw.print(prefix);
        pw.print("mLastWallpaperZoomOut=");
        pw.println(this.mLastWallpaperZoomOut);
        if (this.mPrevWallpaperTarget == null) goto L5;
        pw.print(prefix);
        pw.print("mPrevWallpaperTarget=");
        pw.println(this.mPrevWallpaperTarget);
    L5:
        int i = this.mWallpaperTokens.size() - 1;
    L6:
        if (i < 0) goto L9;
        WallpaperWindowToken t = this.mWallpaperTokens.get(i);
        pw.print(prefix);
        pw.println("token " + t + ":");
        dumpValue(pw, prefix, "mWallpaperX", t.mWallpaperX);
        dumpValue(pw, prefix, "mWallpaperY", t.mWallpaperY);
        dumpValue(pw, prefix, "mWallpaperXStep", t.mWallpaperXStep);
        dumpValue(pw, prefix, "mWallpaperYStep", t.mWallpaperYStep);
        dumpValue(pw, prefix, "mWallpaperDisplayOffsetX", t.mWallpaperDisplayOffsetX);
        dumpValue(pw, prefix, "mWallpaperDisplayOffsetY", t.mWallpaperDisplayOffsetY);
        i = i - 1;
        goto L6
    }

    private void dumpValue(PrintWriter pw, String prefix, String valueName, float value) {
        pw.print(prefix);
        pw.print("  " + valueName + "=");
        if (value < 0.0f) goto L5;
        Object r0 = Float.valueOf(value);
    L6:
        pw.println(r0);
        return;
    L5:
        r0 = "NA";
        goto L6
    }

    public IExtWallpaperController getExt() {
        return this.mIExt;
    }
}
