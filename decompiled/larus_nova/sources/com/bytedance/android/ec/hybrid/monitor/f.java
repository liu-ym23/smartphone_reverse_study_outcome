package com.bytedance.android.ec.hybrid.monitor;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.apm.ApmAgent;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yj.k;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f47559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f47560b = null;

    public f() {
    }

    static {
        f47560b = new f();
        new ArrayList();
    }

    public static void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "errorType");
        Intrinsics.checkNotNullParameter(r101, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);
        IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
        if (r103 == null) goto L11;
        k r104 = r103.getIHybridHostEventService();
        if (r104 == null) goto L12;
        JSONObject r105 = new JSONObject();
        r105.put("error_type", r100);
        r105.put("error_reason", r101);
        if (r102 == null) goto L9;
        r105.put("detail", r102);
    L9:
        Unit r106 = Unit.INSTANCE;
        r104.logV3("ec_hybrid_error", r105);
        return;
    L12:
        return;
    }

    public static final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        ApmAgent.monitorEvent(r100, r101, r102, r103);
        SDKMonitorUtils.getInstance(String.valueOf(6688)).monitorEvent(r100, r101, r102, r103);
        Single.fromCallable(new e(r100, r101, r102, r103)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static void c(String r100, int r101, String r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r102, "schemaType");
        Intrinsics.checkNotNullParameter(r104, "pageName");
        IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();
        if (r105 == null) goto L8;
        k r106 = r105.getIHybridHostEventService();
        if (r106 == null) goto L9;
        JSONObject r107 = new JSONObject();
        r107.putOpt("event_type", r100);
        r107.putOpt("result", Integer.valueOf(r101));
        r107.putOpt("schema_type", r102);
        r107.putOpt("failed_reason", Integer.valueOf(r103));
        r107.putOpt("page_name", r104);
        Unit r108 = Unit.INSTANCE;
        r106.logV3("ec_mall_lynx_card_pre_view", r107);
        return;
    L9:
        return;
    }

    public static void d(String r100, String r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter("", SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        Intrinsics.checkNotNullParameter(r102, "schemaType");
        IHybridHostService r105 = com.bytedance.android.ec.hybrid.a.h();
        if (r105 == null) goto L8;
        k r106 = r105.getIHybridHostEventService();
        if (r106 == null) goto L9;
        JSONObject r107 = new JSONObject();
        r107.putOpt("event_type", r100);
        r107.putOpt("state", r101);
        r107.putOpt("scene_type", "");
        r107.putOpt("schema_type", r102);
        r107.putOpt("isCache", Boolean.valueOf(r103));
        r107.putOpt("isScrolled", Boolean.valueOf(r104));
        Unit r108 = Unit.INSTANCE;
        r106.logV3("ec_mall_lynx_card_preload", r107);
        return;
    L9:
        return;
    }
}
