package com.obric.autogui.common.api.space;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayStatusListener;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.SurfaceChangeable;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotConfig;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.special.VDBackNavListener;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.obric.autogui.common.api.space.vd.util.RotationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.m;
import d.x;
import kotlinx.coroutines.f.a;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDisplayOperatingSpace implements DisplayOperatingSpace {
    private final DisplayAccessor displayAccessor;
    private volatile boolean mAndroidSecure;
    private final BaseDisplayOperatingSpace$mDisplayStatus$1 mDisplayStatus;
    private final BaseDisplayOperatingSpace$mDisplayStatusListener$1 mDisplayStatusListener;
    private HandUsingSession mHandUsingSession;
    private volatile Boolean mLastNotifiedSecure;
    private volatile RobotsScreenshotBlockReason mRobotsBlockReason;
    private volatile String mRobotsPolicyCache;
    private volatile ComponentName mRobotsPolicyTopActivity;
    private volatile boolean mRobotsScreenshotForbidden;
    private volatile boolean mRobotsSecure;
    private SpaceStatusCallback mStatusCallback;

    /* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
    private final class HandUsingSession {
        private final HandUsingEventsCallback callback;
        private final View operationView;
        final /* synthetic */ BaseDisplayOperatingSpace this$0;

        public static /* synthetic */ boolean lambda$V85tiQirK5BpUsq5HJxCkOCcBEc(HandUsingSession r0, View r1, MotionEvent r2) {
            return r0.onOperationTouchEvent(r1, r2);
        }

        public static /* synthetic */ boolean lambda$sOx71dLEzKPgYhA9QHjahCLa_AM(HandUsingSession r0, View r1, MotionEvent r2) {
            return r0.onHoverEvent(r1, r2);
        }

        public HandUsingSession(BaseDisplayOperatingSpace r3, View r4, HandUsingEventsCallback r5) {
            HandUsingEventsCallback r6 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r5, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
            o.e(r4, "operationView");
            this.this$0 = r3;
            this.operationView = r4;
            this.callback = r6;
        }

        public final View getOperationView() {
            return this.operationView;
        }

        public final HandUsingEventsCallback getCallback() {
            return this.callback;
        }

        public final void start() {
            Loog.INSTANCE.d(this.this$0.getLogTag(), this.this$0.logPrefix() + " [HandUsing] SessionStart for " + this.operationView);
            this.operationView.setOnTouchListener(new $$Lambda$BaseDisplayOperatingSpace$HandUsingSession$V85tiQirK5BpUsq5HJxCkOCcBEc(this));
            this.operationView.setImportantForAccessibility(4);
            this.operationView.setOnHoverListener(new $$Lambda$BaseDisplayOperatingSpace$HandUsingSession$sOx71dLEzKPgYhA9QHjahCLa_AM(this));
            HandUsingEventsCallback r4 = this.callback;
            if (r4 == null) goto L6;
            AOPlatformTools.INSTANCE.special().configureVDBackNavigationListener((VDBackNavListener) ZeusTransformUtils.preCheckCast(r4, VDBackNavListener.class, "com.obric.aiagent.plugin"));
            return;
        }

        public final void stop() {
            Loog.INSTANCE.d(this.this$0.getLogTag(), this.this$0.logPrefix() + " [HandUsing] SessionEnd for " + this.operationView);
            this.operationView.setOnTouchListener(null);
            this.operationView.setOnHoverListener(null);
            this.operationView.setImportantForAccessibility(1);
            if (this.callback == null) goto L6;
            AOPlatformTools.INSTANCE.special().configureVDBackNavigationListener(null);
            return;
        }

        private final boolean onHoverEvent(View r5, MotionEvent r6) {
            Loog.INSTANCE.d(this.this$0.getLogTag(), this.this$0.logPrefix() + " [HandUsing] hover: " + r6);
            return onOperationTouchEvent(r5, r6);
        }

        private final boolean onOperationTouchEvent(View r6, MotionEvent r7) {
            MotionEvent r8 = MotionEvent.obtain(r7);
            Loog.INSTANCE.d(this.this$0.getLogTag(), this.this$0.logPrefix() + " [HandUsing] touch: " + r7);
            Point r0 = new Point((int) r7.getX(), (int) r7.getY());
            if (Build.VERSION.SDK_INT < 29) goto L5;
            DisplayAccessor.Rotation r9 = this.this$0.getDisplayAccessor().getRotation();
            m<Integer, Integer> r2 = this.this$0.getDisplayAccessor().getSpawnedDimensions();
            RotationUtils.rotatePoint(r0, r9.getEnumValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.b(), Number.class, "com.obric.aiagent.plugin")).intValue());
        L5:
            m r10 = new m(Float.valueOf(r0.x), Float.valueOf(r0.y));
            r8.setLocation(((Number) ZeusTransformUtils.preCheckCast(r10.a(), Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r10.b(), Number.class, "com.obric.aiagent.plugin")).floatValue());
            if (r8.getAction() != 0) goto L12;
            HandUsingEventsCallback r11 = this.callback;
            if (r11 == null) goto L10;
            r11.onSurfaceViewTouched();
        L23:
            DisplayAccessor r12 = this.this$0.getDisplayAccessor();
            o.a(r8);
            boolean r13 = r12.injectIntoDisplay(r8);
            if (r13 == true) goto L26;
            Loog.INSTANCE.w(this.this$0.getLogTag(), this.this$0.logPrefix() + " [HandUsing] TouchEvent not consumed: " + r8);
        L26:
            HandUsingEventsCallback r5 = this.callback;
            if (r5 == null) goto L29;
            r5.onSurfaceViewOriginTouchEvent(r8);
        L29:
            r8.recycle();
            return r13;
        L10:
            Loog.INSTANCE.w(this.this$0.getLogTag(), "touchedCallback is null");
            goto L23
        L12:
            if (r8.getAction() != 1) goto L18;
            HandUsingEventsCallback r14 = this.callback;
            if (r14 == null) goto L16;
            r14.onSurfaceViewTouchEnded();
            goto L23
        L16:
            Loog.INSTANCE.w(this.this$0.getLogTag(), "touchedCallback is null (onSurfaceViewTouchEnded)");
            goto L23
        L18:
            if (r8.getAction() != 3) goto L23;
            HandUsingEventsCallback r15 = this.callback;
            if (r15 == null) goto L22;
            r15.onSurfaceViewTouchCanceled();
            goto L23
        L22:
            Loog.INSTANCE.w(this.this$0.getLogTag(), "touchedCallback is null (onSurfaceViewTouchCanceled)");
            goto L23
        }
    }

    /* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DisplayAccessor.Rotation.values().length];
            r0[DisplayAccessor.Rotation.Rotation90.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DisplayAccessor.Rotation.Rotation270.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplayOperatingSpace$acquireScreenshot$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
    @f(b = "BaseDisplayOperatingSpace.kt", c = {582, 377}, d = "acquireScreenshot$suspendImpl", e = "com.obric.autogui.common.api.space.BaseDisplayOperatingSpace")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseDisplayOperatingSpace this$0;

        AnonymousClass1(BaseDisplayOperatingSpace r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BaseDisplayOperatingSpace.acquireScreenshot$suspendImpl(this.this$0, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplayOperatingSpace$configureSurface$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseDisplayOperatingSpace.kt */
    @f(b = "BaseDisplayOperatingSpace.kt", c = {582}, d = "configureSurface$suspendImpl", e = "com.obric.autogui.common.api.space.BaseDisplayOperatingSpace")
    static final class C11401 extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseDisplayOperatingSpace this$0;

        C11401(BaseDisplayOperatingSpace r3, d.c.d<? super C11401> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BaseDisplayOperatingSpace.configureSurface$suspendImpl(this.this$0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public Object acquireScreenshot(Context r3, ScreenshotConfig r4, d.c.d<? super ScreenshotResult> r5) {
        return acquireScreenshot$suspendImpl(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.space.DisplayOperatingSpace
    public Object configureSurface(Surface r3, d.c.d<? super x> r4) {
        return configureSurface$suspendImpl(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract String getLogTag();

    public abstract String logPrefix();

    public Surface resolveSurfaceToAttach(Surface r1) {
        return r1;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.obric.autogui.common.api.space.BaseDisplayOperatingSpace$mDisplayStatusListener$1] */
    public BaseDisplayOperatingSpace(DisplayAccessor r3) {
        DisplayAccessor r4 = (DisplayAccessor) ZeusTransformUtils.wrapperContextForParams(r3, DisplayAccessor.class, "com.obric.aiagent.plugin");
        o.e(r4, "displayAccessor");
        this.displayAccessor = r4;
        this.mDisplayStatus = new BaseDisplayOperatingSpace$mDisplayStatus$1(this);
        this.mRobotsBlockReason = RobotsScreenshotBlockReason.None;
        this.mDisplayStatusListener = new BaseDisplayOperatingSpace$mDisplayStatusListener$1(this);
    }

    @Override // com.obric.autogui.common.api.space.DisplayOperatingSpace
    public int getDisplayId() {
        return DisplayOperatingSpace.DefaultImpls.getDisplayId(this);
    }

    @Override // com.obric.autogui.common.api.space.DisplayOperatingSpace
    public DisplayAccessor getDisplayAccessor() {
        return this.displayAccessor;
    }

    public final void initializeDisplaySpace() {
        getDisplayAccessor().registerStatusListener((DisplayStatusListener) ZeusTransformUtils.preCheckCast(this.mDisplayStatusListener, DisplayStatusListener.class, "com.obric.aiagent.plugin"));
        setMuted(true);
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public RobotsScreenshotBlockReason getRobotsScreenshotBlockReason() {
        return this.mRobotsBlockReason;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public SpaceStatus getSpaceStatus() {
        return (SpaceStatus) ZeusTransformUtils.preCheckCast(this.mDisplayStatus, SpaceStatus.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public String getRobotsProxyPolicy() {
        return this.mRobotsPolicyCache;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public void updateRobotsPolicyCache(ComponentName r3) {
        refreshRobotsPolicyCache(r3, false, true);
    }

    private final void refreshRobotsPolicyBeforeScreenshot(ComponentName r3) {
        refreshRobotsPolicyCache(r3, true, false);
    }

    private final void refreshRobotsPolicyCache(ComponentName r8, boolean r9, boolean r10) {
        boolean r1 = o.a(r8, this.mRobotsPolicyTopActivity);
        boolean r3 = false;
        if (r10 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r9 == true) goto L13;
        if (r1 == false) goto L13;
        if (r4 == false) goto L30;
        Loog.INSTANCE.w(getLogTag(), "[SecureState] Flush pending callback on same topActivity; topActivity=" + r8 + ", displaySecure=" + this.mDisplayStatus.isSecure() + ", lastNotified=" + this.mLastNotifiedSecure);
        notifyMergedSecureIfNeeded(false, true);
        return;
    L30:
        return;
    L13:
        this.mRobotsPolicyTopActivity = r8;
        String r11 = null;
        if (r8 != null) goto L17;
        this.mRobotsPolicyCache = null;
        this.mRobotsScreenshotForbidden = false;
        this.mRobotsBlockReason = RobotsScreenshotBlockReason.None;
        this.mRobotsSecure = false;
        notifyMergedSecureIfNeeded(true, r10);
        return;
    L17:
        String r2 = r8.getPackageName();
        o.c(r2, "getPackageName(...)");
        String r12 = r8.getClassName();
        o.c(r12, "getClassName(...)");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L22;
        r11 = AOAgentRobotsTools.INSTANCE.acquireTargetPolicy((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r2, r12);     // Catch: Throwable -> L27
    L22:
        this.mRobotsPolicyCache = r11;
        RobotsPolicyState r13 = parseRobotsPolicyState(r11);
        this.mRobotsScreenshotForbidden = r13.getScreenshotForbidden();
        this.mRobotsBlockReason = r13.getHint();
        if (this.mRobotsBlockReason == RobotsScreenshotBlockReason.None) goto L25;
        r3 = true;
    L25:
        this.mRobotsSecure = r3;
        notifyMergedSecureIfNeeded(true, r10);
        return;
    L5:
        if (hasPendingSecureCallback() == false) goto L7;
        r4 = true;
        goto L8
    }

    private final RobotsPolicyState parseRobotsPolicyState(String r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L11;
        JSONObject r7 = new JSONObject(r5);     // Catch: Throwable -> L28
        int r8 = r7.optInt("screenshot_disable", 0);     // Catch: Throwable -> L28
        int r2 = r7.optInt("global_disable", 0);     // Catch: Throwable -> L28
        int r9 = r7.optInt("input_disable", 0);     // Catch: Throwable -> L28
        if (r2 > 0) goto L17;
        if (r8 > 0) goto L17;
        boolean r10 = false;
    L18:
        if (r9 > 0) goto L21;
        r0 = false;
    L21:
        if (r10 == false) goto L23;
        RobotsScreenshotBlockReason r11 = RobotsScreenshotBlockReason.Invisible;     // Catch: Throwable -> L28
    L26:
        return new RobotsPolicyState(r10, r11);
    L23:
        if (r0 == false) goto L25;
        r11 = RobotsScreenshotBlockReason.Inoperable;     // Catch: Throwable -> L28
        goto L26
    L25:
        r11 = RobotsScreenshotBlockReason.None;     // Catch: Throwable -> L28
    L17:
        r10 = true;
    L29:
        return new RobotsPolicyState(false, RobotsScreenshotBlockReason.None);
    L11:
        return new RobotsPolicyState(false, RobotsScreenshotBlockReason.None);
    L5:
        if (d.o.o.d(r4) == true) goto L8;
        r6 = false;
        goto L9
    }

    private final void notifyMergedSecureIfNeeded(boolean r5, boolean r6) {
        boolean r1 = false;
        if (this.mAndroidSecure == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (this.mDisplayStatus.isSecure() != r0) goto L12;
        r1 = true;
    L12:
        boolean r2 = o.a(this.mLastNotifiedSecure, Boolean.valueOf(r0));
        if (r5 == true) goto L18;
        if (r1 == false) goto L18;
        if (r6 == false) goto L17;
        if (r2 == false) goto L18;
        return;
    L17:
        return;
    L18:
        this.mDisplayStatus.setSecure(r0);
        if (r6 == false) goto L27;
        if (r5 == true) goto L22;
        if (r2 == false) goto L22;
        return;
    L22:
        this.mLastNotifiedSecure = Boolean.valueOf(r0);
        SpaceStatusCallback r4 = this.mStatusCallback;
        if (r4 == null) goto L29;
        r4.onSecureChanged(r0);
        return;
    L29:
        return;
    L27:
        return;
    L5:
        if (this.mRobotsSecure == true) goto L8;
        r0 = false;
        goto L10
    }

    private final boolean isScreenshotForbiddenByPolicy() {
        if (this.mAndroidSecure == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mRobotsScreenshotForbidden == true) goto L8;
        return false;
    }

    private final boolean hasPendingSecureCallback() {
        if (this.mStatusCallback != null) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.mLastNotifiedSecure, Boolean.valueOf(this.mDisplayStatus.isSecure())) == true) goto L7;
        return true;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public m<Integer, Integer> getDimensions() {
        m<Integer, Integer> r0 = getDisplayAccessor().getDecoratedDimensions();
        DisplayAccessor.Rotation r2 = getSpaceStatus().getRotation();
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L8;
        if (r3 == 2) goto L8;
        return r0;
    L8:
        return new m(r0.b(), r0.a());
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public DisplayedAppInfo fetchTopDisplayed() {
        return getDisplayAccessor().getTopDisplayedApp();
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public boolean isValid() {
        return !getDisplayAccessor().isDestroyed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v12, types: [T, com.obric.autogui.common.api.platform.display.capture.ScreenshotResult] */
    /* JADX WARN: Type inference failed for: r2v9, types: [T, com.obric.autogui.common.api.platform.display.capture.ScreenshotResult] */
    static /* synthetic */ Object acquireScreenshot$suspendImpl(BaseDisplayOperatingSpace r21, Context r22, ScreenshotConfig r23, d.c.d<? super ScreenshotResult> r24) {
        BaseDisplayOperatingSpace r0 = r21;
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.aiagent.plugin");
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r24, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r5 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r4, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r7 = b.a();
        int r8 = r5.label;
        if (r8 == 0) goto L20;
        if (r8 == 1) goto L19;
        if (r8 != 2) goto L18;
        z.f r1 = (z.f) ZeusTransformUtils.preCheckCast(r5.L$4, z.f.class, "com.obric.aiagent.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(r5.L$3, a.class, "com.obric.aiagent.plugin");
        z.a r9 = (z.a) ZeusTransformUtils.preCheckCast(r5.L$2, z.a.class, "com.obric.aiagent.plugin");
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r5.L$1, z.f.class, "com.obric.aiagent.plugin");
        BaseDisplayOperatingSpace r11 = (BaseDisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5.L$0, BaseDisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: Throwable -> L15
        T r12 = r6;
    L47:
        r1.f38504a = r12;     // Catch: Throwable -> L15
        r0 = r11;
        z.a r13 = r9;
        z.f r14 = r10;
    L48:
        x r15 = x.f38692a;     // Catch: Throwable -> L15
        r3.b(null);
        if (r13.f38499a == false) goto L52;
        r0.notifyMergedSecureIfNeeded(false, true);
    L52:
        ScreenshotResult r16 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r14.f38504a, ScreenshotResult.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L55;
        return r16;
    L55:
        return new ScreenshotResult(ScreenshotResult.Status.ApiError, null, null, 0, null, null, 62, null);
    L15:
        th = th;
    L58:
        r3.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        a r17 = (a) ZeusTransformUtils.preCheckCast(r5.L$5, a.class, "com.obric.aiagent.plugin");
        z.a r18 = (z.a) ZeusTransformUtils.preCheckCast(r5.L$4, z.a.class, "com.obric.aiagent.plugin");
        z.f r19 = (z.f) ZeusTransformUtils.preCheckCast(r5.L$3, z.f.class, "com.obric.aiagent.plugin");
        ScreenshotConfig r110 = (ScreenshotConfig) ZeusTransformUtils.preCheckCast(r5.L$2, ScreenshotConfig.class, "com.obric.aiagent.plugin");
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(r5.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplayOperatingSpace r20 = (BaseDisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r5.L$0, BaseDisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        r13 = r18;
        r2 = r111;
        a r25 = r17;
        r0 = r20;
        r14 = r19;
    L65:
    L56:
        th = th;
        r3 = r25;
        goto L58
    L28:
        if (r0.getDisplayAccessor().isDestroyed() == false) goto L63;
        Loog.INSTANCE.e(r0.getLogTag(), r0.logPrefix() + " acquireScreenshot -> Destroyed during process.");     // Catch: Throwable -> L56
        r14.f38504a = new ScreenshotResult(ScreenshotResult.Status.ScreenClosed, null, null, 0, null, null, 62, null);     // Catch: Throwable -> L56
    L42:
        r3 = r25;
        goto L48
    L63:
        DisplayedAppInfo r112 = r0.getDisplayAccessor().getTopDisplayedApp();     // Catch: Throwable -> L60
        if (r112 == null) goto L35;
        ComponentName r113 = r112.getTopActivity();     // Catch: Throwable -> L60
    L36:
        r0.refreshRobotsPolicyBeforeScreenshot(r113);     // Catch: Throwable -> L56
        if (r0.mRobotsSecure == false) goto L40;
        r13.f38499a = true;     // Catch: Throwable -> L56
    L40:
        if (r0.isScreenshotForbiddenByPolicy() == false) goto L43;
        Loog.INSTANCE.w(r0.getLogTag(), r0.logPrefix() + " AcquireScreenshot blocked by secure policy; androidSecure=" + r0.mAndroidSecure + ", robotsSecure=" + r0.mRobotsSecure + ", top=" + r113);     // Catch: Throwable -> L56
        r13.f38499a = true;     // Catch: Throwable -> L56
        r14.f38504a = new ScreenshotResult(ScreenshotResult.Status.ContainsSecure, null, null, r0.mRobotsScreenshotForbidden ? 1 : 0, null, null, 54, null);     // Catch: Throwable -> L56
        goto L42
    L43:
        Loog.INSTANCE.d(r0.getLogTag(), r0.logPrefix() + " AcquireScreenshot cfg=" + r110);     // Catch: Throwable -> L56
        DisplayAccessor r114 = r0.getDisplayAccessor();     // Catch: Throwable -> L56
        r5.L$0 = r0;     // Catch: Throwable -> L56
        r5.L$1 = r14;     // Catch: Throwable -> L56
        r5.L$2 = r13;     // Catch: Throwable -> L56
        r5.L$3 = r25;     // Catch: Throwable -> L56
        r5.L$4 = r14;     // Catch: Throwable -> L56
        r5.L$5 = null;     // Catch: Throwable -> L56
        r5.label = 2;     // Catch: Throwable -> L56
        Object r26 = r114.captureDisplay(r2, r110, r5);     // Catch: Throwable -> L56
        if (r26 != r7) goto L46;
        return r7;
    L46:
        r9 = r13;
        r12 = r26;
        r3 = r25;
        r10 = r14;
        r11 = r0;
        r1 = r10;
    L35:
        r113 = null;
        goto L36
    L20:
        d.o.a(r6);
        if (r21.getDisplayAccessor().isDestroyed() == false) goto L24;
        Loog.INSTANCE.e(r21.getLogTag(), r21.logPrefix() + " acquireScreenshot -> Destroyed.");
        return new ScreenshotResult(ScreenshotResult.Status.ScreenClosed, null, null, 0, null, null, 62, null);
    L24:
        r14 = new z.f();
        r13 = new z.a();
        r25 = r21.getLock();
        r5.L$0 = r0;
        r5.L$1 = r2;
        r110 = r23;
        r5.L$2 = r110;
        r5.L$3 = r14;
        r5.L$4 = r13;
        r5.L$5 = r25;
        r5.label = 1;
        if (r25.a(null, r5) != r7) goto L65;
        return r7;
    L7:
        r5 = new AnonymousClass1(r0, r4);
        goto L8
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public void setStatusCallback(SpaceStatusCallback r3) {
        SpaceStatusCallback r4 = (SpaceStatusCallback) ZeusTransformUtils.wrapperContextForParams(r3, SpaceStatusCallback.class, "com.obric.aiagent.plugin");
        this.mStatusCallback = r4;
        if (r4 == null) goto L5;
        r4.onSecureChanged(this.mDisplayStatus.isSecure());
    L5:
        this.mLastNotifiedSecure = Boolean.valueOf(this.mDisplayStatus.isSecure());
        if (r4 == null) goto L9;
        r4.onStatusBarAppearanceChanged(this.mDisplayStatus.getStatusBarAppearance());
        return;
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public HandUsingConfigResult configureHandUsing(boolean r6, DisplayHost r7, HandUsingEventsCallback r8) {
        HandUsingEventsCallback r9 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r8, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L6;
        SurfaceView r10 = null;
    L8:
        Loog.INSTANCE.d(getLogTag(), logPrefix() + " HandUsing -> " + r6 + ", operationView=" + r10);
        if (AOPlatformTools.INSTANCE.special().configureHandUsing(r6) == true) goto L12;
        Loog.INSTANCE.e(getLogTag(), logPrefix() + " configureHandUsing -> ApiError.");
        return new HandUsingConfigResult(HandUsingConfigResult.Status.ApiError);
    L12:
        if (r6 == false) goto L18;
        if (r10 == null) goto L17;
        HandUsingSession r11 = new HandUsingSession(this, (View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"), r9);
        this.mHandUsingSession = r11;
        if (r11 == null) goto L20;
        r11.start();
    L20:
        return new HandUsingConfigResult(HandUsingConfigResult.Status.Success);
    L17:
        Loog.INSTANCE.w(getLogTag(), logPrefix() + " configureHandUsing -> OperationView is null.");
        goto L20
    L18:
        stopHandUsingSession();
        goto L20
    L6:
        if (ZeusTransformUtils.instanceOf(r7, DisplayHost.Surface.class) == false) goto L22;
        r10 = ((DisplayHost.Surface) ZeusTransformUtils.preCheckCast(r7, DisplayHost.Surface.class, "com.obric.aiagent.plugin")).getSurfaceView();
        goto L8
    L22:
        if (ZeusTransformUtils.instanceOf(r7, DisplayHost.Mirror.class) == false) goto L26;
        return configureNonSurfaceHandUsing(r6, r7, r9);
    L26:
        throw new k();
    }

    public HandUsingConfigResult configureNonSurfaceHandUsing(boolean r2, DisplayHost r3, HandUsingEventsCallback r4) {
        HandUsingEventsCallback r5 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r4, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r3, "host");
        Loog.INSTANCE.w(getLogTag(), logPrefix() + " configureHandUsing -> host is not supported: " + r3);
        return new HandUsingConfigResult(HandUsingConfigResult.Status.NotSupported);
    }

    static /* synthetic */ Object configureSurface$suspendImpl(BaseDisplayOperatingSpace r6, Surface r7, d.c.d<? super x> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, C11401.class) == false) goto L7;
        C11401 r0 = (C11401) ZeusTransformUtils.preCheckCast(r9, C11401.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r0.L$3, a.class, "com.obric.aiagent.plugin");
        SurfaceChangeable r12 = (SurfaceChangeable) ZeusTransformUtils.preCheckCast(r0.L$2, SurfaceChangeable.class, "com.obric.aiagent.plugin");
        Surface r4 = (Surface) ZeusTransformUtils.preCheckCast(r0.L$1, Surface.class, "com.obric.aiagent.plugin");
        BaseDisplayOperatingSpace r1 = (BaseDisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r0.L$0, BaseDisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
        a r5 = r11;
        r6 = r1;
    L36:
    L33:
        th = move-exception;
        r5.b(null);
        throw th;
    L26:
        if (r6.isValid() == true) goto L30;
        Loog.INSTANCE.e(r6.getLogTag(), r6.logPrefix() + " configureSurface -> DisplaySpace became invalid.");     // Catch: Throwable -> L33
        x r13 = x.f38692a;     // Catch: Throwable -> L33
        r5.b(null);
        return r13;
    L30:
        r12.setSurface(r6.resolveSurfaceToAttach(r4));     // Catch: Throwable -> L33
        x r14 = x.f38692a;     // Catch: Throwable -> L33
        r5.b(null);
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        DisplayAccessor r15 = r6.getDisplayAccessor();
        if (ZeusTransformUtils.instanceOf(r15, SurfaceChangeable.class) == false) goto L17;
        SurfaceChangeable r16 = (SurfaceChangeable) ZeusTransformUtils.preCheckCast(r15, SurfaceChangeable.class, "com.obric.aiagent.plugin");
    L18:
        if (r16 != null) goto L21;
        Loog.INSTANCE.e(r6.getLogTag(), r6.logPrefix() + " configureSurface -> Not a SurfaceAttacher.");
        return x.f38692a;
    L21:
        r5 = r6.getLock();
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r16;
        r0.L$3 = r5;
        r0.label = 1;
        if (r5.a(null, r0) != r2) goto L24;
        return r2;
    L24:
        r4 = r7;
        r12 = r16;
        goto L36
    L17:
        r16 = null;
    L7:
        r0 = new C11401(r6, r9);
        goto L8
    }

    @Override // com.obric.autogui.common.api.space.AOOperatingSpace
    public void setMuted(boolean r1) {
        AOPlatformTools.INSTANCE.special().tryToMuteVD(r1);
    }

    @Override // com.obric.autogui.common.api.space.DisplayOperatingSpace
    public void onDisplaySecureStatusChanged(boolean r5) {
        Loog.INSTANCE.d(getLogTag(), " > " + logPrefix() + " SecureStatus -> " + r5);
        this.mAndroidSecure = r5;
        notifyMergedSecureIfNeeded(true, true);
    }

    @Override // com.obric.autogui.common.api.space.DisplayOperatingSpace
    public void onDisplayStatusBarAppearanceChanged(int r5) {
        Loog.INSTANCE.d(getLogTag(), " > " + logPrefix() + " StatusBarAppearance -> " + r5);
        this.mDisplayStatus.setStatusBarAppearance(r5);
        SpaceStatusCallback r4 = this.mStatusCallback;
        if (r4 == null) goto L6;
        r4.onStatusBarAppearanceChanged(r5);
        return;
    }

    public final void stopHandUsingSession() {
        HandUsingSession r0 = this.mHandUsingSession;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.mHandUsingSession = null;
    }
}
