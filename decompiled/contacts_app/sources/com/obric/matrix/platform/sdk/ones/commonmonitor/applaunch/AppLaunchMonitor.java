package com.obric.matrix.platform.sdk.ones.commonmonitor.applaunch;

import android.app.Application;
import android.os.SystemClock;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLaunchMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/applaunch/AppLaunchMonitor;", "", "()V", "createCnt", "", "entranceActivityName", "", "mReportDuration", "", "mReportHomeShow", "periodEndMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "periodStartMap", "sActivityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "start", "startWithMain", "getStartMainTime", "markEnd", "", "period", "markStart", "registerActivityLifecycleCallbacks", "app", "Landroid/app/Application;", "reportFirstFrameDuation", "reportUserDataRealShowDuration", "startTrace", "entranceActivity", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppLaunchMonitor {
    private static final long COLD_LAUNCH_MAX_TIME_THRESHOLD = 10000;
    public static final Companion Companion = null;
    public static final String PERIOD_APP_ATTACH = "app_attach";
    public static final String PERIOD_APP_CREATE = "app_create";
    public static final String PERIOD_FIRST_FRAME_SHOW = "first_frame_show";
    public static final String PERIOD_HOME_FRAGMENT_CREATE = "home_fragment_create";
    public static final String PERIOD_HOME_FRAGMENT_CREATE_VIEW = "home_fragment_create_view";
    public static final String PERIOD_HOME_FRAGMENT_RESUME = "home_fragment_resume";
    public static final String PERIOD_MAIN_ACT_CREATE = "main_act_create";
    public static final String PERIOD_MAIN_ACT_RESUME = "main_act_resume";
    public static final String PERIOD_USERDATA_REAL_SHOW = "userdata_real_show";
    private static final String TAG = "AppLaunchMonitor";
    private static final AppLaunchMonitor instance = null;
    private long createCnt;
    private String entranceActivityName;
    private boolean mReportDuration;
    private boolean mReportHomeShow;
    private final LinkedHashMap<String, Long> periodEndMap;
    private final LinkedHashMap<String, Long> periodStartMap;
    private final Application.ActivityLifecycleCallbacks sActivityLifecycleCallbacks;
    private long start;
    private long startWithMain;

    /* JADX INFO: compiled from: AppLaunchMonitor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/applaunch/AppLaunchMonitor$Companion;", "", "()V", "COLD_LAUNCH_MAX_TIME_THRESHOLD", "", "PERIOD_APP_ATTACH", "", "PERIOD_APP_CREATE", "PERIOD_FIRST_FRAME_SHOW", "PERIOD_HOME_FRAGMENT_CREATE", "PERIOD_HOME_FRAGMENT_CREATE_VIEW", "PERIOD_HOME_FRAGMENT_RESUME", "PERIOD_MAIN_ACT_CREATE", "PERIOD_MAIN_ACT_RESUME", "PERIOD_USERDATA_REAL_SHOW", "TAG", "instance", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/applaunch/AppLaunchMonitor;", "getInstance$annotations", "getInstance", "()Lcom/obric/matrix/platform/sdk/ones/commonmonitor/applaunch/AppLaunchMonitor;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final AppLaunchMonitor getInstance() {
            return AppLaunchMonitor.access$getInstance$cp();
        }
    }

    public static final AppLaunchMonitor getInstance() {
        return Companion.getInstance();
    }

    private AppLaunchMonitor() {
        this.start = -1;
        this.startWithMain = -1;
        this.createCnt = 1;
        this.periodStartMap = new LinkedHashMap();
        this.periodEndMap = new LinkedHashMap();
        this.entranceActivityName = "";
        this.sActivityLifecycleCallbacks = new AppLaunchMonitor$sActivityLifecycleCallbacks$1(this);
    }

    public static final /* synthetic */ String access$getEntranceActivityName$p(AppLaunchMonitor r0) {
        return r0.entranceActivityName;
    }

    public static final /* synthetic */ AppLaunchMonitor access$getInstance$cp() {
        return instance;
    }

    public static final /* synthetic */ long access$getStart$p(AppLaunchMonitor r2) {
        return r2.start;
    }

    public static final /* synthetic */ void access$reportFirstFrameDuation(AppLaunchMonitor r0) {
        r0.reportFirstFrameDuation();
    }

    public static final /* synthetic */ void access$setStart$p(AppLaunchMonitor r0, long r1) {
        r0.start = r1;
    }

    static {
        Companion = new Companion(null);
        instance = new AppLaunchMonitor();
    }

    public final void startTrace(String r3) {
        Intrinsics.checkNotNullParameter(r3, "entranceActivity");
        LaunchSceneMonitor.INSTANCE.inject();
        this.entranceActivityName = r3;
        if (LaunchSceneMonitor.INSTANCE.launchWithAct() == false) goto L6;
        this.start = SystemClock.elapsedRealtime();
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == false) goto L9;
        this.startWithMain = SystemClock.elapsedRealtime();
        markStart(PERIOD_APP_ATTACH);
        return;
    }

    private final void reportUserDataRealShowDuration() {
        if (this.mReportHomeShow == false) goto L5;
        return;
    L5:
        this.mReportHomeShow = true;
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L40;
        JSONObject r0 = new JSONObject();
        if (this.periodEndMap.size() <= 0) goto L41;
        Iterator<Map.Entry<String, Long>> r1 = this.periodEndMap.entrySet().iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        Map.Entry<String, Long> r4 = r1.next();
        String r5 = r4.getKey();
        long r6 = r4.getValue().longValue();
        Long r7 = this.periodStartMap.get(r5);
        if (r7 == null) goto L13;
        r0.put(r5, r6 - r7.longValue()).put(r5 + "_start", r7.longValue()).put(r5 + "_end", r6);
        goto L13
    L17:
        Long r2 = this.periodEndMap.get(PERIOD_FIRST_FRAME_SHOW);
        Long r8 = this.periodStartMap.get(PERIOD_HOME_FRAGMENT_CREATE);
        if (r2 == null) goto L23;
        if (r8 == null) goto L23;
        if (r2.longValue() <= r8.longValue()) goto L23;
        r0.put("home_create_to_first_show", r2.longValue() - r8.longValue());
    L23:
        Long r12 = this.periodEndMap.get("userdata_real_show");
        if (r12 == null) goto L29;
        if (r8 == null) goto L29;
        if (r12.longValue() <= r8.longValue()) goto L29;
        r0.put("home_create_to_feed_show", r12.longValue() - r8.longValue());
    L29:
        MLog.i$default(TAG, "reportAppLaunchDuration() now = " + SystemClock.elapsedRealtime() + " , appStartTime= " + LaunchSceneMonitor.INSTANCE.getAppStartTime(), null, 4, null);
        long r9 = SystemClock.elapsedRealtime() - LaunchSceneMonitor.INSTANCE.getAppStartTime();
        if (r9 <= 0) goto L32;
        MLog.i$default(TAG, "reportAppLaunchDuration() total_duration= " + r9 + ", event= " + r0, null, 4, null);
        MatrixTeaManager.Companion.getInstance().onApmColdLaunchUserCompleteEvent(r9, r0);
        return;
    L32:
        MLog.e$default(TAG, "reportAppLaunchDuration()数据非法 total_duration <= 0", null, 4, null);
        return;
    L41:
        return;
    }

    private final void reportFirstFrameDuation() {
        if (this.mReportDuration == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithAct() == false) goto L11;
        this.mReportDuration = true;
        long r0 = SystemClock.elapsedRealtime() - this.start;
        if (r0 >= COLD_LAUNCH_MAX_TIME_THRESHOLD) goto L12;
        MLog.i$default(TAG, "reportDuration: " + r0, null, 4, null);
        MatrixTeaManager.Companion.getInstance().onApmColdLaunchFirstFrameEvent(r0);
        return;
    L12:
        return;
    }

    public final void markStart(String r5) {
        Intrinsics.checkNotNullParameter(r5, "period");
        if (this.mReportHomeShow == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L12;
        long r0 = SystemClock.elapsedRealtime() - this.startWithMain;
        this.periodStartMap.put(r5, Long.valueOf(r0));
        MLog.i$default(TAG, "markStart " + r5 + ' ' + r0, null, 4, null);
        return;
    }

    public final void markEnd(String r5) {
        Intrinsics.checkNotNullParameter(r5, "period");
        if (this.mReportHomeShow == false) goto L6;
        return;
    L6:
        if (LaunchSceneMonitor.INSTANCE.launchWithMainAct() == true) goto L8;
        return;
    L8:
        if (this.startWithMain <= 0) goto L14;
        long r0 = SystemClock.elapsedRealtime() - this.startWithMain;
        this.periodEndMap.put(r5, Long.valueOf(r0));
        MLog.i$default(TAG, "markEnd " + r5 + ' ' + r0, null, 4, null);
        if (Intrinsics.areEqual(r5, "userdata_real_show") == false) goto L15;
        reportUserDataRealShowDuration();
        this.periodStartMap.clear();
        this.periodEndMap.clear();
        return;
    L15:
        return;
    }

    public final long getStartMainTime() {
        return this.startWithMain;
    }

    public final void registerActivityLifecycleCallbacks(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
        r2.registerActivityLifecycleCallbacks(this.sActivityLifecycleCallbacks);
    }
}
