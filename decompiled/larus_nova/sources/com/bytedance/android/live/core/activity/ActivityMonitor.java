package com.bytedance.android.live.core.activity;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.w0;
import com.bytedance.android.live.core.setting.x0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import om0.c;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final class ActivityMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f64743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Boolean f64744b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/activity/ActivityMonitor$ActivityStatusCode;", "", "", "code", "I", "getCode", "()I", "setCode", "(I)V", "SUCCESS", "UNKNOWN_CODE", "READY", "livecore-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ActivityStatusCode extends Enum<ActivityStatusCode> {
        public static final ActivityStatusCode READY = null;
        public static final ActivityStatusCode SUCCESS = null;
        public static final ActivityStatusCode UNKNOWN_CODE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActivityStatusCode[] f64745a = null;
        private int code;

        static {
            ActivityStatusCode r100 = new ActivityStatusCode("SUCCESS", 0, 1);
            SUCCESS = r100;
            ActivityStatusCode r101 = new ActivityStatusCode("UNKNOWN_CODE", 1, -1);
            UNKNOWN_CODE = r101;
            ActivityStatusCode r102 = new ActivityStatusCode("READY", 2, 2);
            READY = r102;
            f64745a = new ActivityStatusCode[]{r100, r101, r102};
        }

        public static ActivityStatusCode valueOf(String r100) {
            return (ActivityStatusCode) a.a(ActivityStatusCode.class, r100);
        }

        public static ActivityStatusCode[] values() {
            return (ActivityStatusCode[]) f64745a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int r100) {
            this.code = r100;
        }

        public ActivityStatusCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    static {
        f64743a = x0.f65451a.getValue();
        f64744b = w0.f65443a.getValue();
    }

    @JvmStatic
    public static final boolean a() {
        return f64744b.booleanValue();
    }

    @JvmStatic
    public static final void c(String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "serviceName");
        wm0.a r100 = c.h();
        if (r100 == null) goto L5;
        r100.g(r110, LiveTracingMonitor.EventModule.ACTIVITY.name(), LiveTracingMonitor.EventType.BUSSINESS_API_CALL.name(), r111, r112, r113);
    L6:
        String r114 = "ActivityMonitor_" + r110;
        StringBuilder r101 = new StringBuilder("Activity->");
        r101.append(r111);
        r101.append(":  serviceName= ");
        r101.append(r110);
        r101.append(",extraLog= ");
        if (r113 == null) goto L9;
        String r115 = r113.toString();
    L10:
        r101.append(r115);
        ALogger.i(r114, r101.toString());
        return;
    L9:
        r115 = null;
        goto L10
    L5:
        LiveTracingMonitor.e(r110, LiveTracingMonitor.EventModule.ACTIVITY, LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r111, r112, r113);
        goto L6
    }

    @JvmStatic
    public static final void b(String r100, int r101, JSONObject r102, String r103, String r104, JSONObject r105, String r106) {
        LiveMonitor.a r107 = new LiveMonitor.a(r100, LiveTracingMonitor.EventModule.ACTIVITY);
        r107.l(r101);
        r107.f64902e = r102;
        r107.k(r105);
        r107.c(r103);
        r107.d(r104);
        r107.f64906i = true;
        r107.a().report();
        ALogger.i("ActivityMonitor_" + r103, "Activity->" + r103 + ":  serviceName= " + r100 + ", statusCode= " + r101 + ", extraLog= " + r102.toString() + ", categoryPrimary= " + r103 + ", alogJson = " + r106);
    }

    public static /* synthetic */ void d(String r100, int r110, JSONObject r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 16) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r115 & 64) == 0) goto L9;
        String r102 = "";
    L10:
        b(r100, r110, r111, r112, r101, null, r102);
        return;
    L9:
        r102 = r114;
        goto L10
    L5:
        r101 = r113;
        goto L7
    }
}
