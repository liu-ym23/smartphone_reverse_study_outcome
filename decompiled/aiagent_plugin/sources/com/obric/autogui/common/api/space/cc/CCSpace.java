package com.obric.autogui.common.api.space.cc;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCActionFailureReason;
import com.obric.autogui.common.api.platform.computercontrol.CCActionResult;
import com.obric.autogui.common.api.platform.computercontrol.CCSessionAccessor;
import com.obric.autogui.common.api.platform.computercontrol.CCTouchEvent;
import com.obric.autogui.common.api.platform.computercontrol.IComputerControlApi;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.special.IAutoActionSpecialApi;
import com.obric.autogui.common.api.platform.special.VDBackNavListener;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.BaseDisplayOperatingSpace;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import kotlinx.coroutines.f.a;

/* JADX INFO: compiled from: CCSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CCSpace extends BaseDisplayOperatingSpace {
    private static final Companion Companion = null;
    private static final long NANOS_PER_MILLIS = 1000000;
    private static final String TAG = "CC/Space";
    private final CCBackgroundSurface backgroundSurface;
    private final String logTag;
    private volatile boolean mScreenshotBlockedByBusiness;
    private final CCSessionAccessor sessionAccessor;
    private final String spaceId;
    private final AOOperatingSpace.SpaceType type;

    /* JADX INFO: compiled from: CCSpace.kt */
    private static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CCSpace.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CCActionFailureReason.values().length];
            r0[CCActionFailureReason.Unsupported.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[CCActionFailureReason.InvalidArgument.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[CCActionFailureReason.InvalidSession.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CCActionFailureReason.SessionClosed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[CCActionFailureReason.ApiError.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.cc.CCSpace$destroyCC$1, reason: invalid class name */
    /* JADX INFO: compiled from: CCSpace.kt */
    @f(b = "CCSpace.kt", c = {98}, d = "destroyCC", e = "com.obric.autogui.common.api.space.cc.CCSpace")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CCSpace this$0;

        AnonymousClass1(CCSpace r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.destroyCC((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void lambda$JDyH1K7ZBxte3WYT2KnLo0qzYpw(CCSpace r0, HandUsingEventsCallback r1, CCTouchEvent r2) {
        enableMirrorHandUsing$lambda$2$lambda$1(r0, r1, r2);
    }

    public final CCSessionAccessor getSessionAccessor() {
        return this.sessionAccessor;
    }

    public CCSpace(CCSessionAccessor r3, DisplayAccessor r4, CCBackgroundSurface r5) {
        CCSessionAccessor r6 = (CCSessionAccessor) ZeusTransformUtils.wrapperContextForParams(r3, CCSessionAccessor.class, "com.obric.aiagent.plugin");
        DisplayAccessor r7 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r4, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r6, "sessionAccessor");
        o.e(r7, "displayAccessor");
        o.e(r5, "backgroundSurface");
        super(r7);
        this.sessionAccessor = r6;
        this.backgroundSurface = r5;
        this.logTag = TAG;
        this.spaceId = "CCS." + r7.getDisplayId();
        this.type = AOOperatingSpace.SpaceType.ComputerControl;
        initializeDisplaySpace();
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public String getLogTag() {
        return this.logTag;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public String getSpaceId() {
        return this.spaceId;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public AOOperatingSpace.SpaceType getType() {
        return this.type;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public a getLock() {
        return CCSpaceManager.INSTANCE.getCCLock();
    }

    public final void setScreenshotBlockedByBusiness(boolean r4) {
        if (this.mScreenshotBlockedByBusiness != r4) goto L5;
        return;
    L5:
        this.mScreenshotBlockedByBusiness = r4;
        Loog.INSTANCE.i(TAG, "event=business_screenshot_policy_changed spaceId=" + getSpaceId() + " businessScreenshotBlocked=" + r4 + " frameworkSessionState=" + this.sessionAccessor.getState());
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace, com.obric.autogui.common.api.space.AOOperatingSpace
    public Object acquireScreenshot(Context r10, ScreenshotConfig r11, d.c.d<? super ScreenshotResult> r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.c.d<? super ScreenshotResult> r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (this.mScreenshotBlockedByBusiness == false) goto L7;
        Loog.INSTANCE.w(TAG, "event=screenshot_blocked_by_business spaceId=" + getSpaceId() + " frameworkSessionState=" + this.sessionAccessor.getState());
        return new ScreenshotResult(ScreenshotResult.Status.NoScreenFound, null, null, 0, null, null, 62, null);
    L7:
        return super.acquireScreenshot(r13, r11, r14);
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace, com.obric.autogui.common.api.space.AOOperatingSpace
    public void setMuted(boolean r4) {
        CCActionResult r0 = AOPlatformTools.INSTANCE.computerControl().tryToMute(this.sessionAccessor, r4);
        if (ZeusTransformUtils.instanceOf(r0, CCActionResult.Failed.class) == false) goto L6;
        Loog.INSTANCE.w(TAG, logPrefix() + " setMuted(" + r4 + ") failed: " + r0);
        return;
    }

    public final Object destroyCC(d.c.d<? super x> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r7, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CCSpace this = (CCSpace) ZeusTransformUtils.preCheckCast(r0.L$0, CCSpace.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
    L17:
        this.backgroundSurface.release();
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r8);
        stopHandUsingSession();
        cleanupMirrorHandUsing$default(this, null, 1, null);
        DisplayAccessor r9 = getDisplayAccessor();
        r0.L$0 = this;
        r0.label = 1;
        if (r9.destroy(r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public HandUsingConfigResult configureNonSurfaceHandUsing(boolean r3, DisplayHost r4, HandUsingEventsCallback r5) {
        HandUsingEventsCallback r6 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r5, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "host");
        if (ZeusTransformUtils.instanceOf(r4, DisplayHost.Mirror.class) == false) goto L7;
        return configureMirrorHandUsing(r3, (DisplayHost.Mirror) ZeusTransformUtils.preCheckCast(r4, DisplayHost.Mirror.class, "com.obric.aiagent.plugin"), r6);
    L7:
        return super.configureNonSurfaceHandUsing(r3, r4, r6);
    }

    private final HandUsingConfigResult configureMirrorHandUsing(boolean r3, DisplayHost.Mirror r4, HandUsingEventsCallback r5) {
        HandUsingEventsCallback r6 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r5, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        if (r3 == false) goto L6;
        return enableMirrorHandUsing(r4.getView(), r6);
    L6:
        return cleanupMirrorHandUsing(r4.getView());
    }

    private final HandUsingConfigResult enableMirrorHandUsing(View r6, HandUsingEventsCallback r7) {
        final HandUsingEventsCallback r8 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r7, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        IAutoActionSpecialApi r0 = AOPlatformTools.INSTANCE.special();
        if (r8 == null) goto L6;
        r0.configureVDBackNavigationListener((VDBackNavListener) ZeusTransformUtils.preCheckCast(r8, VDBackNavListener.class, "com.obric.aiagent.plugin"));
    L6:
        if (r8 == null) goto L11;
        CCActionResult r9 = AOPlatformTools.INSTANCE.computerControl().setTouchListener(this.sessionAccessor, new $$Lambda$CCSpace$JDyH1K7ZBxte3WYT2KnLo0qzYpw(this, r8));
        if (ZeusTransformUtils.instanceOf(r9, CCActionResult.Failed.class) == false) goto L11;
        Loog.INSTANCE.w(TAG, logPrefix() + " setMirrorTouchListener failed: " + r9);
        cleanupMirrorHandUsing(r6);
        return toHandUsingConfigResult((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L11:
        CCActionResult r10 = AOPlatformTools.INSTANCE.computerControl().setMirrorViewInteractive(r6, true);
        if (o.a(r10, CCActionResult.Success.INSTANCE) == false) goto L15;
        return new HandUsingConfigResult(HandUsingConfigResult.Status.Success);
    L15:
        if (ZeusTransformUtils.instanceOf(r10, CCActionResult.Failed.class) == false) goto L19;
        Loog.INSTANCE.w(TAG, logPrefix() + " setMirrorViewInteractive(true) failed: " + r10);
        cleanupMirrorHandUsing(r6);
        return toHandUsingConfigResult((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r10, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L19:
        throw new k();
    }

    private static final void enableMirrorHandUsing$lambda$2$lambda$1(CCSpace r2, HandUsingEventsCallback r3, CCTouchEvent r4) {
        HandUsingEventsCallback r5 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r3, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r4, "event");
        r2.dispatchMirrorTouchEvent(r4, r5);
    }

    static /* synthetic */ HandUsingConfigResult cleanupMirrorHandUsing$default(CCSpace r0, View r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = CCSpaceManager.INSTANCE.getCurrentMirrorView$common_release();
    L6:
        return r0.cleanupMirrorHandUsing(r1);
    }

    private final HandUsingConfigResult cleanupMirrorHandUsing(View r8) {
        HandUsingConfigResult.Status r0 = HandUsingConfigResult.Status.Success;
        IComputerControlApi r1 = AOPlatformTools.INSTANCE.computerControl();
        if (r8 == null) goto L7;
        CCActionResult r9 = r1.setMirrorViewInteractive(r8, false);
        if (ZeusTransformUtils.instanceOf(r9, CCActionResult.Failed.class) == false) goto L7;
        Loog.INSTANCE.w(TAG, logPrefix() + " setMirrorViewInteractive(false) failed: " + r9);
        r0 = toHandUsingStatus((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r9, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L7:
        CCActionResult r10 = r1.setTouchListener(this.sessionAccessor, null);
        if (ZeusTransformUtils.instanceOf(r10, CCActionResult.Failed.class) == false) goto L12;
        Loog.INSTANCE.w(TAG, logPrefix() + " clearMirrorTouchListener failed: " + r10);
        if (r0 != HandUsingConfigResult.Status.Success) goto L12;
        r0 = toHandUsingStatus((CCActionResult.Failed) ZeusTransformUtils.preCheckCast(r10, CCActionResult.Failed.class, "com.obric.aiagent.plugin"));
    L12:
        AOPlatformTools.INSTANCE.special().configureVDBackNavigationListener(null);
        return new HandUsingConfigResult(r0);
    }

    private final void dispatchMirrorTouchEvent(CCTouchEvent r3, HandUsingEventsCallback r4) {
        HandUsingEventsCallback r5 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r4, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        r5.onSurfaceViewTouched();
    L12:
        MotionEvent r2 = toMotionEvent(r3);
        r5.onSurfaceViewOriginTouchEvent(r2);     // Catch: Throwable -> L16
        r2.recycle();
        return;
    L16:
        th = move-exception;
        r2.recycle();
        throw th;
    L5:
        if (r0 != 1) goto L7;
        r5.onSurfaceViewTouchEnded();
        goto L12
    L7:
        if (r0 != 3) goto L12;
        r5.onSurfaceViewTouchCanceled();
        goto L12
    }

    private final MotionEvent toMotionEvent(CCTouchEvent r19) {
        long r6 = r19.getEventTimeNanos() / NANOS_PER_MILLIS;
        MotionEvent r0 = MotionEvent.obtain(r6, r6, r19.getAction(), r19.getX(), r19.getY(), r19.getPressure(), r19.getMajorAxisSize(), 0, 1.0f, 1.0f, 0, 0);
        o.c(r0, "obtain(...)");
        return r0;
    }

    private final HandUsingConfigResult toHandUsingConfigResult(CCActionResult.Failed r2) {
        return new HandUsingConfigResult(toHandUsingStatus(r2));
    }

    private final HandUsingConfigResult.Status toHandUsingStatus(CCActionResult.Failed r1) {
        CCActionFailureReason r0 = r1.getReason();
        int r2 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r2 == 1) goto L16;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L16;
        if (r2 == 4) goto L16;
        if (r2 != 5) goto L14;
        return HandUsingConfigResult.Status.ApiError;
    L14:
        throw new k();
    L16:
        return HandUsingConfigResult.Status.NotSupported;
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public String logPrefix() {
        return "[CCS/" + getDisplayId() + ']';
    }

    @Override // com.obric.autogui.common.api.space.BaseDisplayOperatingSpace
    public Surface resolveSurfaceToAttach(Surface r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return this.backgroundSurface.getSurface();
    }
}
