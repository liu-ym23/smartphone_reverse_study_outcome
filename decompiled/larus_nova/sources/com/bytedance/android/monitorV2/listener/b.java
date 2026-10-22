package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.util.k;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.u;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f163121b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f163122a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventUpdated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
    }

    public b() {
        this.f163122a = SetsKt.hashSetOf(new String[]{"navigationStart", "performance", PerfLog.TAG_PERF});
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventCreated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
        a(r100, "event_create");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventSampled(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
        a(r100, "event_unsampled");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventTerminated(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
        a(r100, "event_terminated");
    }

    @Override // com.bytedance.android.monitorV2.listener.f
    public void onEventUploaded(com.bytedance.android.monitorV2.event.c r100) {
        Intrinsics.checkNotNullParameter(r100, "eventInfo");
        a(r100, "event_uploaded");
    }

    public final void a(com.bytedance.android.monitorV2.event.c r310, String r311) {
        if (this.f163122a.contains(r310.f163023a) == false) goto L28;
        JSONObject r100 = new JSONObject();
        l.a(r100, r310.f163026d);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        k r101 = new k(r100);
        JSONObject r102 = l.i(r100, "nativeBase");
        JSONObject r103 = l.i(r102, "bid_info");
        JSONObject r104 = l.i(r100, "containerBase");
        String r105 = l.l(r103, "bid");
        String r110 = l.l(r103, "setting_bid");
        String r106 = l.l(r103, "config_bid");
        String r111 = l.m(r104, "container_name", null);
        String r112 = l.m(r104, "schema", null);
        String r107 = l.m(r104, "version", null);
        String r108 = l.m(r104, BytedCertConstant.IntentKey.VIEW_TYPE, null);
        String r109 = l.m(r104, "biz", null);
        String r113 = l.m(r104, "core_view_type", null);
        String r114 = l.m(r104, "core_component", null);
        String r115 = r310.f163023a;
        String r116 = l.l(r102, "url");
        String r117 = u.a(r116);
        String r118 = l.l(r102, "virtual_aid");
        String r119 = l.l(r102, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE);
        String r120 = l.l(r102, "sdk_version");
        String r121 = l.l(r102, "page_version");
        String r312 = "";
        if (Intrinsics.areEqual(r119, "web") == false) goto L7;
        String r313 = r121;
        String r122 = l.l(r102, "web_version");
    L11:
        String r314 = r122;
        if (Intrinsics.areEqual(r119, "web") == false) goto L14;
        r312 = l.l(r102, "webview_type");
    L14:
        String r123 = r312;
        JSONObject r124 = new JSONObject();
        if (HybridEvent.EventPhase.EVENT_CREATE == r310.f163024b.f163016a) goto L17;
        l.d(r124, "bid", r105);
        l.d(r124, "setting_bid", r110);
        l.d(r124, "container_bid", r106);
    L17:
        l.d(r124, "container_name", r111);
        l.d(r124, "schema", r112);
        l.d(r124, "version", r107);
        l.d(r124, BytedCertConstant.IntentKey.VIEW_TYPE, r108);
        l.d(r124, "biz", r109);
        l.d(r124, "core_view_type", r113);
        l.d(r124, "core_component", r114);
        l.d(r124, "stage", r311);
        l.d(r124, "event_type", r115);
        l.d(r124, "full_url", r116);
        l.d(r124, "format_url", r117);
        l.d(r124, "virtual_aid", r118);
        l.d(r124, "engine_type", r119);
        l.d(r124, "sdk_version", r120);
        l.d(r124, "page_version", r313);
        l.d(r124, "engine_version", r314);
        l.d(r124, "webview_type", r123);
        Object r125 = r101.b("containerBase.context.annie_is_card");
        Intrinsics.checkNotNullParameter(r124, "<this>");
        Intrinsics.checkNotNullParameter("annie_is_card", "key");
        if (r125 == null) goto L24;
        Intrinsics.checkNotNullParameter(r124, "<this>");
        Intrinsics.checkNotNullParameter("annie_is_card", "key");
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L22
        Result.m9449constructorimpl(r124.put("annie_is_card", r125));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L24:
        gz2.c.f("hybrid_monitor_sdk_trace", r124);
        return;
    L7:
        r313 = r121;
        if (Intrinsics.areEqual(r119, "lynx") == false) goto L10;
        r122 = l.l(r102, "lynx_version");
        goto L11
    L10:
        r122 = "";
        goto L11
    }
}
