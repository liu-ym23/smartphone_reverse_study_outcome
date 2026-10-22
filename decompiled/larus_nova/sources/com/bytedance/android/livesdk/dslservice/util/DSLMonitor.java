package com.bytedance.android.livesdk.dslservice.util;

import am2.x;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DSLMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f122951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f122952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f122953c;

    public DSLMonitor() {
        this.f122951a = "livesdk_dsl_load_component_card";
        this.f122952b = "livesdk_dsl_load_component_result";
        this.f122953c = "TriangleManager";
    }

    public String c() {
        return this.f122953c;
    }

    public final void a(Function1<? super f, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "initBlock");
        e(0, r100);
    }

    public final void d(Function1<? super f, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "initBlock");
        e(1, r100);
    }

    public final void e(int r100, Function1<? super f, Unit> r101) {
        Function2 r102 = DSLMonitor$logDebugInfo$logFunc$1.INSTANCE;
        if (r100 == 0) goto L12;
        if (r100 != 1) goto L7;
        r102 = DSLMonitor$logDebugInfo$1.INSTANCE;
    L14:
        f r103 = new f();
        r101.invoke(r103);
        String r104 = "";
        if (r103.f122972b == null) goto L23;
        String r105 = r103.f122971a;
        if (r105 != null) goto L19;
        r105 = c();
    L19:
        String r106 = r103.f122972b;
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        r102.invoke(r105, r106);
    L23:
        Throwable r107 = r103.f122973c;
        if (r107 == null) goto L36;
        StringBuilder r108 = new StringBuilder();
        String r109 = r103.f122971a;
        if (r109 != null) goto L28;
        r109 = c();
    L28:
        r108.append(r109);
        String r110 = r103.f122972b;
        if (r110 == null) goto L32;
        r104 = r110;
    L32:
        r108.append(r104);
        SafetyGuard.a(null, r107, r108.toString());
        if (v.a() == false) goto L37;
        throw r107;
    L37:
        return;
    L36:
        return;
    L7:
        if (r100 != 2) goto L14;
        r102 = DSLMonitor$logDebugInfo$2.INSTANCE;
        goto L14
    L12:
        if (v.a() == true) goto L14;
    }

    public final void h(final String r100, final Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "map");
        j0.l().sendLog(r100, r101, new Object[]{IRoom.class, x.class});
        e(1, new DSLMonitor$sendTrackLog$1(this, r100, r101));
    }

    public static void g(String r100, Map r101, int r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "map");
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.EventModule.common;
        JSONObject r105 = new JSONObject();
        r105.put("latency", r103);     // Catch: JSONException -> L15
    L4:
        JSONObject r106 = new JSONObject();
        r106.put("status_code", r102);     // Catch: JSONException -> L16
    L6:
        Iterator r107 = r101.entrySet().iterator();
    L8:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        r106.put((String) r108.getKey(), (String) r108.getValue());     // Catch: JSONException -> L12
        goto L8
    L13:
        LiveMonitor r109 = new LiveMonitor();
        r109.mCategory = r106;
        r109.mEventModule = r104;
        r109.mServiceName = r100;
        r109.mExtraLog = null;
        r109.mMetrics = r105;
        LiveMonitor.access$002(r109, false);
        LiveMonitor.access$102(r109, false);
        LiveMonitor.access$202(r109, true);
        LiveMonitor.access$302(r109, false);
        LiveMonitor.access$402(r109, false);
        r109.report();
    }

    public final void f(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "dslType");
        Intrinsics.checkNotNullParameter(r102, "loadType");
        Intrinsics.checkNotNullParameter(r103, "id");
        HashMap r104 = new HashMap();
        r104.put("result", String.valueOf(r101));
        r104.put("dsl_type", r100);
        r104.put(ChameleonOpenTracker.ParamKey.LOAD_TYPE, r102);
        r104.put("id", r103);
        h(this.f122952b, r104);
    }

    public static HashMap b(long r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "dslType");
        Intrinsics.checkNotNullParameter(r104, "loadType");
        Pair[] r105 = new Pair[5];
        r105[0] = TuplesKt.to(ThumbGlideUrl.SOURCE_TEMPLATE, r101);
        r105[1] = TuplesKt.to(ChameleonOpenTracker.ParamKey.COST, String.valueOf(r100));
        if (r103 == false) goto L5;
        String r106 = "1";
    L6:
        r105[2] = TuplesKt.to("isFirst", r106);
        r105[3] = TuplesKt.to("loadType", r104);
        r105[4] = TuplesKt.to("dsl_type", r102);
        return MapsKt.hashMapOf(r105);
    L5:
        r106 = "0";
        goto L6
    }
}
