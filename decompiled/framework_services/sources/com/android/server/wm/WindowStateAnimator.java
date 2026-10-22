package com.android.server.wm;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.os.Debug;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.EventLog;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.protolog.common.LogLevel;
import com.android.server.policy.WindowManagerPolicy;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class WindowStateAnimator {
    static final int COMMIT_DRAW_PENDING = 2;
    static final int DRAW_PENDING = 1;
    static final int HAS_DRAWN = 4;
    static final int NO_SURFACE = 0;
    static final int PRESERVED_SURFACE_LAYER = 1;
    static final int READY_TO_SHOW = 3;
    static final int ROOT_TASK_CLIP_AFTER_ANIM = 0;
    static final int ROOT_TASK_CLIP_NONE = 1;
    static final String TAG = "WindowManager";
    float mAlpha;
    boolean mAnimationIsEntrance;
    final WindowAnimator mAnimator;
    int mAttrType;
    final Context mContext;
    int mDrawState;
    boolean mEnterAnimationPending;
    boolean mEnteringAnimation;
    private IExtWindowStateAnimator mExt;
    float mLastAlpha;
    boolean mLastHidden;
    final WindowManagerPolicy mPolicy;
    final WindowManagerService mService;
    final Session mSession;
    float mShownAlpha;
    SurfaceControl mSurfaceControl;
    private boolean mSurfaceShown;
    private final Rect mSystemDecorRect;
    private String mTitle;
    private final WallpaperController mWallpaperControllerLocked;
    final WindowState mWin;

    String drawStateToString() {
        switch(this.mDrawState) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L10;
            case 3: goto L8;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return "HAS_DRAWN";
    L8:
        return "READY_TO_SHOW";
    L10:
        return "COMMIT_DRAW_PENDING";
    L12:
        return "DRAW_PENDING";
    L14:
        return "NO_SURFACE";
    L5:
        return Integer.toString(this.mDrawState);
    }

    WindowStateAnimator(WindowState win) {
        this.mShownAlpha = 0.0f;
        this.mAlpha = 0.0f;
        this.mLastAlpha = 0.0f;
        this.mSystemDecorRect = new Rect();
        this.mExt = (IExtWindowStateAnimator) ExtImplFactory.getImpl(IExtWindowStateAnimator.class, new Object[]{this});
        WindowManagerService service = win.mWmService;
        this.mService = service;
        this.mAnimator = service.mAnimator;
        this.mPolicy = service.mPolicy;
        this.mContext = service.mContext;
        this.mWin = win;
        this.mSession = win.mSession;
        this.mAttrType = win.mAttrs.type;
        this.mWallpaperControllerLocked = win.getDisplayContent().mWallpaperController;
    }

    void onAnimationFinished() {
        boolean protoLogParam2 = true;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam1 = this.mWin.mAnimatingExit;
        if (this.mWin.mActivityRecord != null) goto L7;
    L9:
        protoLogParam2 = false;
    L10:
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, -1495677286613044867L, 60, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2)});
        goto L11
    L7:
        if (this.mWin.mActivityRecord.reportedVisible == false) goto L9;
    L11:
        this.mWin.checkPolicyVisibilityChange();
        DisplayContent displayContent = this.mWin.getDisplayContent();
        if (this.mAttrType == 2000) goto L16;
        if (this.mAttrType == 2040) goto L16;
    L18:
        this.mWin.onExitAnimationDone();
        displayContent.pendingLayoutChanges |= 8;
        if (displayContent.mWallpaperController.isWallpaperTarget(this.mWin) == false) goto L22;
        displayContent.pendingLayoutChanges |= 4;
    L22:
        if (WindowManagerDebugConfig.DEBUG_LAYOUT_REPEATS == false) goto L25;
        this.mService.mWindowPlacerLocked.debugLayoutRepeats("WindowStateAnimator", displayContent.pendingLayoutChanges);
    L25:
        if (this.mWin.mActivityRecord == null) goto L28;
        this.mWin.mActivityRecord.updateReportedVisibilityLocked();
        return;
    L28:
        return;
    L16:
        if (this.mWin.isVisibleByPolicy() == false) goto L18;
        displayContent.setLayoutNeeded();
        goto L18
    }

    void hide(SurfaceControl.Transaction transaction, String reason) {
        if (this.mLastHidden == false) goto L5;
        return;
    L5:
        this.mLastHidden = true;
        if (this.mSurfaceControl != null) goto L8;
        return;
    L8:
        if (this.mSurfaceShown == true) goto L11;
        return;
    L11:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L13;
        String protoLogParam0 = String.valueOf(reason);
        String protoLogParam1 = String.valueOf(this.mTitle);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -3150759018467214646L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L13:
        setShown(false);
        transaction.hide(this.mSurfaceControl);
        if (this.mWin.mIsWallpaper == false) goto L18;
        DisplayContent dc = this.mWin.getDisplayContent();
        EventLog.writeEvent(EventLogTags.WM_WALLPAPER_SURFACE, new Object[]{Integer.valueOf(dc.mDisplayId), 0, String.valueOf(dc.mWallpaperController.getWallpaperTarget())});
        return;
    }

    private void setShown(boolean surfaceShown) {
        this.mSurfaceShown = surfaceShown;
        this.mService.updateNonSystemOverlayWindowsVisibilityIfNeeded(this.mWin, surfaceShown);
        this.mWin.onSurfaceShownChanged(surfaceShown);
        this.mSession.onWindowSurfaceVisibilityChanged(this.mWin, this.mSurfaceShown);
    }

    boolean finishDrawingLocked(SurfaceControl.Transaction postDrawTransaction) {
        if (this.mWin.mAttrs.type != 3) goto L5;
        boolean startingWindow = true;
    L6:
        if (startingWindow == true) goto L8;
    L10:
        boolean layoutNeeded = false;
        if (this.mDrawState == 1) goto L13;
    L20:
        if (postDrawTransaction == null) goto L23;
        this.mWin.getSyncTransaction().merge(postDrawTransaction);
        return true;
    L23:
        return layoutNeeded;
    L13:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DRAW_enabled[1] == false) goto L15;
        String protoLogParam0 = String.valueOf(this.mWin);
        String protoLogParam1 = String.valueOf(this.mSurfaceControl);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_DRAW, 345647873457403698L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L15:
        if (startingWindow == true) goto L17;
    L19:
        this.mDrawState = 2;
        layoutNeeded = true;
        goto L20
    L17:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L19;
        String protoLogParam2 = String.valueOf(this.mWin);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -2385558637577093121L, 0, new Object[]{protoLogParam2});
        goto L19
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[1] == false) goto L10;
        String protoLogParam3 = String.valueOf(this.mWin);
        String protoLogParam4 = String.valueOf(drawStateToString());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, 3436877176443058520L, 0, new Object[]{protoLogParam3, protoLogParam4});
        goto L10
    L5:
        startingWindow = false;
        goto L6
    }

    boolean commitFinishDrawingLocked() {
        if (WindowManagerDebugConfig.DEBUG_STARTING_WINDOW_VERBOSE == false) goto L8;
        if (this.mWin.mAttrs.type != 3) goto L8;
        Slog.i(TAG, "commitFinishDrawingLocked: " + this.mWin + " cur mDrawState=" + drawStateToString());
    L8:
        if (this.mDrawState == 2) goto L13;
        if (this.mDrawState == 3) goto L13;
        return false;
    L13:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L15;
        String protoLogParam0 = String.valueOf(this.mSurfaceControl);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -3490933626936411542L, 0, new Object[]{protoLogParam0});
    L15:
        this.mDrawState = 3;
        ActivityRecord activity = this.mWin.mActivityRecord;
        if (activity != null) goto L18;
    L21:
        boolean result = this.mWin.performShowLocked();
        return result;
    L18:
        if (activity.canShowWindows() == true) goto L21;
        if (this.mWin.mAttrs.type == 3) goto L21;
        return false;
    }

    void resetDrawState() {
        this.mDrawState = 1;
        if (this.mWin.mActivityRecord != null) goto L6;
        return;
    L6:
        if (this.mWin.mActivityRecord.isAnimating(1) == true) goto L9;
        this.mWin.mActivityRecord.clearAllDrawn();
        return;
    }

    SurfaceControl createSurfaceLocked() {
        WindowState w = this.mWin;
        if (this.mSurfaceControl != null) goto L5;
        w.setHasSurface(false);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[2] == false) goto L9;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ANIM, -6088246515441976339L, 0, new Object[]{protoLogParam0});
    L9:
        resetDrawState();
        WindowManager.LayoutParams attrs = w.mAttrs;
        if ((this.mWin.mAttrs.privateFlags & 1048576) == 0) goto L12;
        int flags = 4 | 64;
        int flags2 = flags;
    L14:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L84;
        Slog.v(TAG, "Creating surface " + this + " format=" + attrs.format + " flags=" + flags2);
    L84:
    L58:
        e = e;
        SurfaceControl r17 = null;
    L74:
        Slog.e(TAG, "Exception creating surface (parent dead?)", e);
        this.mDrawState = 0;
        return r17;
    L18:
        if ((attrs.flags & 16777216) == 0) goto L20;
        boolean isHwAccelerated = true;
    L21:
        if (isHwAccelerated == false) goto L23;
        int format = -3;
    L24:
        this.mTitle = attrs.getTitle().toString();     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        Trace.traceBegin(32, "new SurfaceControl");     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        this.mSurfaceControl = this.mWin.makeSurface().setParent(this.mWin.mSurfaceControl).setName(this.mTitle).setFormat(format).setFlags(flags2).setMetadata(2, attrs.type).setMetadata(1, this.mSession.mUid).setMetadata(6, this.mSession.mPid).setCallsite("WindowSurfaceController").setBLASTLayer().build();     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        Trace.traceEnd(32);     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        if ((attrs.privateFlags & 16777216) == 0) goto L27;
        boolean r4 = true;
    L28:
        setColorSpaceAgnosticLocked(r4);     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        w.setHasSurface(true);     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        w.mInputWindowHandle.forceChange();     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L64;
        String protoLogParam1 = String.valueOf(this.mSurfaceControl);     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        long protoLogParam2 = this.mSession.mPid;     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        long protoLogParam3 = attrs.format;     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        long protoLogParam4 = flags2;
        String protoLogParam5 = String.valueOf(this);     // Catch: Exception -> L54 Surface.OutOfResourcesException -> L56
        r17 = null;
        goto L76
    L86:
        goto L76
    L78:
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, -2367267008697650481L, 84, new Object[]{protoLogParam1, Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3), Long.valueOf(protoLogParam4), protoLogParam5});     // Catch: Exception -> L40 Surface.OutOfResourcesException -> L42
    L40:
        e = e;
    L44:
        e = e;
    L48:
        e = e;
    L76:
        Slog.w(TAG, "OutOfResourcesException creating surface");
        this.mService.mRoot.reclaimSomeSurfaceMemory(this, "create", true);
        this.mDrawState = 0;
        return r17;
    L54:
        e = e;
        r17 = null;
    L57:
        r17 = null;
        goto L76
    L64:
        if (WindowManagerDebugConfig.DEBUG == false) goto L67;
        Slog.v(TAG, "Got surface: " + this.mSurfaceControl + ", set left=" + w.getFrame().left + " top=" + w.getFrame().top);
    L67:
        if (WindowManagerDebugConfig.SHOW_LIGHT_TRANSACTIONS == false) goto L69;
        Slog.i(TAG, ">>> OPEN TRANSACTION createSurfaceLocked");
        WindowManagerService.logSurface(w, "CREATE pos=(" + w.getFrame().left + "," + w.getFrame().top + ") HIDE", false);
    L69:
        this.mLastHidden = true;
        if (WindowManagerDebugConfig.DEBUG == false) goto L73;
        Slog.v(TAG, "Created surface " + this);
    L73:
        return this.mSurfaceControl;
    L27:
        r4 = false;
        goto L28
    L23:
        format = attrs.format;     // Catch: Exception -> L58 Surface.OutOfResourcesException -> L60
        goto L24
    L20:
        isHwAccelerated = false;
    L61:
        r17 = null;
        goto L76
    L12:
        flags2 = 4;
        goto L14
    L5:
        return this.mSurfaceControl;
    }

    boolean hasSurface() {
        if (this.mSurfaceControl == null) goto L5;
        return true;
    L5:
        return false;
    }

    void getSurfaceControl(SurfaceControl outSurfaceControl) {
        outSurfaceControl.copyFrom(this.mSurfaceControl, "WindowStateAnimator.getSurfaceControl");
    }

    void destroySurfaceLocked(SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        this.mWin.mHidden = true;
    L9:
        e = move-exception;
        Slog.w(TAG, "Exception thrown when destroying Window " + this + " surface " + this.mSurfaceControl + " session " + this.mSession + ": " + e.toString());
        return;
    L7:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L12;
        WindowManagerService.logWithStack(TAG, "Window " + this + " destroying surface " + this.mSurfaceControl + ", session " + this.mSession);     // Catch: RuntimeException -> L9
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L14;
        String protoLogParam0 = String.valueOf(this.mWin);     // Catch: RuntimeException -> L9
        String protoLogParam1 = String.valueOf(new RuntimeException().fillInStackTrace());     // Catch: RuntimeException -> L9
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, -4491856282178275074L, 0, new Object[]{protoLogParam0, protoLogParam1});     // Catch: RuntimeException -> L9
    L14:
        destroySurface(t);     // Catch: RuntimeException -> L9
        if (this.mService.mFlags.mEnsureWallpaperInTransitions == true) goto L17;
        this.mWallpaperControllerLocked.hideWallpapers(this.mWin);     // Catch: RuntimeException -> L9
        return;
    L17:
        if (this.mWallpaperControllerLocked.isWallpaperTarget(this.mWin) == false) goto L25;
        this.mWin.requestUpdateWallpaperIfNeeded();     // Catch: RuntimeException -> L9
        return;
    }

    void prepareSurfaceLocked(SurfaceControl.Transaction t) {
        WindowState w = this.mWin;
        if (hasSurface() == true) goto L5;
        return;
    L5:
        this.mShownAlpha = this.mAlpha;
        if (w.isOnScreen() == true) goto L13;
        hide(t, "prepareSurfaceLocked");
        if (w.mIsWallpaper == true) goto L10;
    L11:
        this.mWallpaperControllerLocked.hideWallpapers(w);
        return;
    L10:
        if (this.mService.mFlags.mEnsureWallpaperInTransitions == false) goto L11;
        return;
    L13:
        if (this.mLastAlpha == this.mShownAlpha) goto L15;
    L16:
        this.mLastAlpha = this.mShownAlpha;
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L19;
        String protoLogParam0 = String.valueOf(this.mSurfaceControl);
        double protoLogParam1 = this.mShownAlpha;
        double protoLogParam2 = w.mHScale;
        double protoLogParam3 = w.mVScale;
        String protoLogParam4 = String.valueOf(w);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -5079712802591263622L, 168, new Object[]{protoLogParam0, Double.valueOf(protoLogParam1), Double.valueOf(protoLogParam2), Double.valueOf(protoLogParam3), protoLogParam4});
    L19:
        t.setAlpha(this.mSurfaceControl, this.mShownAlpha);
        if (this.mDrawState == 4) goto L22;
        return;
    L22:
        if (this.mLastHidden == false) goto L29;
        showRobustly(t);
        this.mLastHidden = false;
        return;
    L29:
        return;
    L15:
        if (this.mLastHidden == true) goto L16;
    }

    private void showRobustly(SurfaceControl.Transaction t) {
        if (this.mSurfaceShown == false) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L9;
        String protoLogParam0 = String.valueOf(this.mTitle);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, 1722557424138072083L, 0, new Object[]{protoLogParam0});
    L9:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L11;
        Slog.v(TAG, "Showing " + this + " during relayout");
    L11:
        setShown(true);
        t.show(this.mSurfaceControl);
        if (getExt() == null) goto L15;
        getExt().showWallpaperWhenLockScreenUnderOccludedWindowIfNeeded(t);
    L15:
        if (this.mWin.mIsWallpaper == false) goto L18;
        DisplayContent dc = this.mWin.mDisplayContent;
        EventLog.writeEvent(EventLogTags.WM_WALLPAPER_SURFACE, new Object[]{Integer.valueOf(dc.mDisplayId), 1, String.valueOf(dc.mWallpaperController.getWallpaperTarget())});
        return;
    }

    void setOpaqueLocked(boolean isOpaque) {
        if (this.mSurfaceControl != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L8;
        String protoLogParam1 = String.valueOf(this.mTitle);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -234122360532158892L, 3, new Object[]{Boolean.valueOf(isOpaque), protoLogParam1});
    L8:
        this.mWin.getPendingTransaction().setOpaque(this.mSurfaceControl, isOpaque);
        this.mService.scheduleAnimationLocked();
    }

    void setColorSpaceAgnosticLocked(boolean agnostic) {
        if (this.mSurfaceControl != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L8;
        String protoLogParam1 = String.valueOf(this.mTitle);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -7231643553450150489L, 3, new Object[]{Boolean.valueOf(agnostic), protoLogParam1});
    L8:
        this.mWin.getPendingTransaction().setColorSpaceAgnostic(this.mSurfaceControl, agnostic);
    }

    void applyEnterAnimationLocked() {
        if (this.mEnterAnimationPending == false) goto L5;
        this.mEnterAnimationPending = false;
        int transit = 1;
    L7:
        if (this.mAttrType == 1) goto L16;
        if (this.mWin.mIsWallpaper == true) goto L16;
        if (this.mWin.mActivityRecord != null) goto L13;
    L14:
        applyAnimationLocked(transit, true);
        goto L16
    L13:
        if (this.mWin.mActivityRecord.hasStartingWindow() == false) goto L14;
    L16:
        if (this.mService.mAccessibilityController.hasCallbacks() == false) goto L19;
        this.mService.mAccessibilityController.onWindowTransition(this.mWin, transit);
        return;
    L19:
        return;
    L5:
        transit = 3;
        goto L7
    }

    boolean applyAnimationLocked(int transit, boolean isEntrance) {
        if (this.mWin.isAnimating() == false) goto L8;
        if (this.mAnimationIsEntrance != isEntrance) goto L8;
        return true;
    L8:
        if (this.mWin.mAttrs.type != 2011) goto L13;
        this.mWin.getDisplayContent().adjustForImeIfNeeded();
        if (isEntrance == false) goto L13;
        this.mWin.setDisplayLayoutNeeded();
        this.mService.mWindowPlacerLocked.requestTraversal();
    L13:
        if (this.mWin.mControllableInsetProvider == null) goto L16;
        return false;
    L16:
        if (this.mWin.mToken.okToAnimate() == false) goto L44;
        int anim = this.mWin.getDisplayContent().getDisplayPolicy().selectAnimation(this.mWin, transit);
        int attr = -1;
        Animation a = null;
        if (anim != 0) goto L20;
        if (isEntrance == false) goto L24;
    L26:
        switch(transit) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            default: goto L32;
        };
    L28:
        attr = 3;
        goto L32
    L29:
        attr = 2;
        goto L32
    L30:
        attr = 1;
        goto L32
    L31:
        attr = 0;
    L32:
        if (attr < 0) goto L35;
        a = this.mWin.mDisplayContent.mTransitionAnimation.loadAnimationAttr(this.mWin.mAttrs, attr, 0);
    L35:
        if (ProtoLogImpl_798997914.isEnabled(WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.VERBOSE) == false) goto L41;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L41;
        String protoLogParam0 = String.valueOf(this);
        long protoLogParam1 = anim;
        long protoLogParam2 = attr;
        String protoLogParam3 = String.valueOf(a);
        long protoLogParam4 = transit;
        long protoLogParam5 = this.mAttrType;
        String protoLogParam7 = String.valueOf(Debug.getCallers(20));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, -5668794009329913533L, 13588, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), protoLogParam3, Long.valueOf(protoLogParam4), Long.valueOf(protoLogParam5), Boolean.valueOf(isEntrance), protoLogParam7});
    L41:
        if (a == null) goto L46;
        Trace.traceBegin(32, "WSA#startAnimation");
        this.mWin.startAnimation(a);
        Trace.traceEnd(32);
        this.mAnimationIsEntrance = isEntrance;
    L46:
        return this.mWin.isAnimating(0, 16);
    L24:
        if (this.mWin.isForceHiddenNonSystemOverlayWindow() == false) goto L26;
        a = new AlphaAnimation(1.0f, 0.0f);
        a.setDuration(this.mContext.getResources().getInteger(R.integer.config_shortAnimTime));
        goto L35
    L20:
        if (anim == (-1)) goto L35;
        Trace.traceBegin(32, "WSA#loadAnimation");
        a = AnimationUtils.loadAnimation(this.mContext, anim);
        Trace.traceEnd(32);
        goto L35
    L44:
        this.mWin.cancelAnimation();
        goto L46
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        if (this.mSurfaceControl == null) goto L5;
        long dumpToken = proto.start(1146756268034L);
        proto.write(1133871366145L, this.mSurfaceShown);
        proto.end(dumpToken);
    L5:
        proto.write(1159641169923L, this.mDrawState);
        this.mSystemDecorRect.dumpDebug(proto, 1146756268036L);
        proto.end(token);
    }

    public void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        if (this.mAnimationIsEntrance == false) goto L6;
        pw.print(prefix);
        pw.print(" mAnimationIsEntrance=");
        pw.print(this.mAnimationIsEntrance);
    L6:
        if (this.mSurfaceControl == null) goto L10;
        if (dumpAll == false) goto L9;
        pw.print(prefix);
        pw.print("mSurface=");
        pw.println(this.mSurfaceControl);
    L9:
        pw.print(prefix);
        pw.print("Surface: shown=");
        pw.print(this.mSurfaceShown);
    L10:
        if (dumpAll == false) goto L13;
        pw.print(prefix);
        pw.print("mDrawState=");
        pw.print(drawStateToString());
        pw.print(prefix);
        pw.print(" mLastHidden=");
        pw.println(this.mLastHidden);
        pw.print(prefix);
        pw.print("mEnterAnimationPending=" + this.mEnterAnimationPending);
        pw.print(prefix);
        pw.print("mSystemDecorRect=");
        this.mSystemDecorRect.printShortString(pw);
        pw.println();
    L13:
        if (this.mShownAlpha == 1.0f) goto L15;
    L18:
        pw.print(prefix);
        pw.print("mShownAlpha=");
        pw.print(this.mShownAlpha);
        pw.print(" mAlpha=");
        pw.print(this.mAlpha);
        pw.print(" mLastAlpha=");
        pw.println(this.mLastAlpha);
    L20:
        if (this.mWin.mGlobalScale == 1.0f) goto L23;
        pw.print(prefix);
        pw.print("mGlobalScale=");
        pw.print(this.mWin.mGlobalScale);
        return;
    L23:
        return;
    L15:
        if (this.mAlpha != 1.0f) goto L18;
        if (this.mLastAlpha == 1.0f) goto L20;
        goto L18
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("WindowStateAnimator{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.mWin.mAttrs.getTitle());
        sb.append('}');
        return sb.toString();
    }

    boolean getShown() {
        if (this.mSurfaceControl != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mSurfaceShown == false) goto L7;
        return true;
    }

    void destroySurface(SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_SURFACE_ALLOC_enabled[2] == false) goto L9;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(Debug.getCallers(8));
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_SURFACE_ALLOC, -111253898741466584L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L9:
        if (this.mWin.mIsWallpaper == true) goto L11;
    L15:
        t.remove(this.mSurfaceControl);
        setShown(false);
        this.mSurfaceControl = null;
        this.mWin.setHasSurface(false);
        this.mDrawState = 0;
        return;
    L11:
        if (this.mWin.mWindowRemovalAllowed == true) goto L15;
        if (this.mWin.mRemoveOnExit == true) goto L15;
        Slog.e(TAG, "Unexpected removing wallpaper surface of " + this.mWin + " by " + Debug.getCallers(8));
        goto L15
    }

    public IExtWindowStateAnimator getExt() {
        return this.mExt;
    }
}
