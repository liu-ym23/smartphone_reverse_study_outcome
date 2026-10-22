package com.obric.autogui.common.api.space.errtrack;

import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppErrorTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppErrorTracker {
    public static final int ERROR_ANR = 2;
    public static final int ERROR_BLACK = 4;
    public static final int ERROR_CRASH = 1;
    public static final int ERROR_NO_ERROR = 0;
    public static final int ERROR_RELAUNCH = 3;
    private static final String EVENT_OAUTO_APP_ERROR = "oauto_app_error";
    public static final AppErrorTracker INSTANCE = null;
    public static final int SCALE_FACTOR = 20;
    private static final String TAG = "AppErrorTracker";
    public static final int TERMINATE = 99;
    private static final f appRestartRecord$delegate = null;
    private static AtomicInteger mCurrentErrorType;
    private static AtomicInteger mErrorTimes;
    private static boolean mInit;
    private static AtomicInteger mRelaunchTimes;
    private static final am mScope = null;
    private static IAutoActionAgentEventListener.SessionInfo mSessionInfo;

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.errtrack.AppErrorTracker$checkOpenSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppErrorTracker.kt */
    @d.c.b.a.f(b = "AppErrorTracker.kt", c = {106}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.errtrack.AppErrorTracker$checkOpenSuccess$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AOOperatingSpace $operatingSpace;
        final /* synthetic */ ComponentName $prevTopActivity;
        final /* synthetic */ String $targetAppPackage;
        int label;

        AnonymousClass1(Context r3, String r4, ComponentName r5, AOOperatingSpace r6, d<? super AnonymousClass1> r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AOOperatingSpace r9 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r6, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d r10 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.$context = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
            this.$targetAppPackage = r4;
            this.$prevTopActivity = r5;
            this.$operatingSpace = r9;
            super(2, r10);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$context, this.$targetAppPackage, this.$prevTopActivity, this.$operatingSpace, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r9);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r9);
            TrackVDOpenAppSuccessWorker r10 = new TrackVDOpenAppSuccessWorker(this.$context, this.$targetAppPackage, this.$prevTopActivity, (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(this.$operatingSpace, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"));
            d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r10.run(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.errtrack.AppErrorTracker$maybeReportBlackScreen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AppErrorTracker.kt */
    @d.c.b.a.f(b = "AppErrorTracker.kt", c = {121}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.errtrack.AppErrorTracker$maybeReportBlackScreen$1")
    static final class C11451 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ Bitmap $scaledBitmap;
        int label;

        C11451(Bitmap r3, d<? super C11451> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$scaledBitmap = r3;
            super(2, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11451(this.$scaledBitmap, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11451) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11451.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            ReportBlackScreenWorker r6 = new ReportBlackScreenWorker(this.$scaledBitmap);
            d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r6.run(r2) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ ConcurrentHashMap lambda$8uldJvaPvW8lUSlA7s67NMOgU58() {
        return appRestartRecord_delegate$lambda$0();
    }

    private AppErrorTracker() {
    }

    static {
        INSTANCE = new AppErrorTracker();
        mCurrentErrorType = new AtomicInteger(0);
        appRestartRecord$delegate = g.a($$Lambda$AppErrorTracker$8uldJvaPvW8lUSlA7s67NMOgU58.INSTANCE);
        mRelaunchTimes = new AtomicInteger(0);
        mErrorTimes = new AtomicInteger(0);
        mScope = an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public final void init() {
        mInit = true;
    }

    public final void release() {
        if (mInit == true) goto L5;
        return;
    L5:
        mInit = false;
        mCurrentErrorType.set(0);
        mRelaunchTimes.set(0);
        mErrorTimes.set(0);
        getAppRestartRecord().clear();
    }

    private final ConcurrentHashMap<String, Integer> getAppRestartRecord() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(appRestartRecord$delegate.b(), ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    }

    private static final ConcurrentHashMap appRestartRecord_delegate$lambda$0() {
        return new ConcurrentHashMap();
    }

    public final void checkOpenSuccess(Context r10, ComponentName r11, String r12) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "context");
        d.h.b.o.e(r12, "targetAppPackage");
        AOOperatingSpace r5 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r5 != null) goto L6;
        Loog.INSTANCE.e(TAG, "checkOpenSuccess: no active space found.");
        return;
    L6:
        if (r11 != null) goto L10;
        Loog.INSTANCE.w(TAG, "checkOpenSuccess: prevTopActivity is null.");
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, DisplayOperatingSpace.class) == true) goto L13;
        Loog.INSTANCE.e(TAG, "checkOpenSuccess: only DisplayOperatingSpace is supported.");
        return;
    L13:
        i.a(mScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r12, r11, r5, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void maybeReportBlackScreen(IScreenshot r8) {
        IScreenshot r7 = (IScreenshot) ZeusTransformUtils.wrapperContextForParams(r8, IScreenshot.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "screenshot");
        Bitmap r9 = r7.getBitmap();
        Bitmap r10 = Bitmap.createScaledBitmap(r9, r9.getWidth() / 20, r9.getHeight() / 20, false).copy(Bitmap.Config.ARGB_8888, false);
        if (r10 != null) goto L5;
        return;
    L5:
        i.a(mScope, null, null, (m) ZeusTransformUtils.preCheckCast(new C11451(r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void reportEvent(int r9) {
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("error_type", r9);
        IAutoActionAgentEventListener.SessionInfo r8 = mSessionInfo;
        if (r8 == null) goto L5;
        String r10 = r8.getSessionId();
    L6:
        r2.put("session_id", r10);
        x r11 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, EVENT_OAUTO_APP_ERROR, r2, false, false, null, 28, null);
        return;
    L5:
        r10 = null;
        goto L6
    }

    public final void updateSessionInfo(IAutoActionAgentEventListener.SessionInfo r1) {
        d.h.b.o.e(r1, "sessionInfo");
        mSessionInfo = r1;
    }

    public final void clearCurrentError() {
        mCurrentErrorType.set(0);
    }

    public final int getCurrentError() {
        return mCurrentErrorType.get();
    }

    public final void recordAppRestart(String r2, String r3, String r4) {
        String r5 = r2 + '-' + r3 + '-' + r4;
        Integer r6 = getAppRestartRecord().getOrDefault(r5, 0);
        d.h.b.o.c(r6, "getOrDefault(...)");
        getAppRestartRecord().put(r5, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() + 1));
    }

    public final int getAppRestartTimes(String r2, String r3, String r4) {
        Integer r1 = getAppRestartRecord().getOrDefault(r2 + '-' + r3 + '-' + r4, 0);
        d.h.b.o.c(r1, "getOrDefault(...)");
        return ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue();
    }
}
