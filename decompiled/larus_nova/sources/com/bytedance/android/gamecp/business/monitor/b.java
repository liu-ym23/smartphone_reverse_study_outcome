package com.bytedance.android.gamecp.business.monitor;

import bw.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56156a = 0;

    static {
    }

    public static void a(String r100, String r101, String r102) {
        int r103 = com.bytedance.android.gamecp.common.track.b.f56775a;
        com.bytedance.android.gamecp.common.track.b.g("dygame_tech_type_detail_widget_error", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("widget", r100), TuplesKt.to("step", r101), TuplesKt.to("error_msg", String.valueOf(r102))}), new String[0]);
        k r104 = com.bytedance.android.gamecp.host_api.a.b().getHostMonitorService();
        JSONObject r105 = new JSONObject();
        r105.put("widget", r100);
        Unit r106 = Unit.INSTANCE;
        JSONObject r107 = new JSONObject();
        r107.put("step", r101);
        JSONObject r108 = new JSONObject();
        r108.put("error_msg", String.valueOf(r102));
        r104.monitorEvent("dygame_tech_type_detail_widget_error", r105, r107, r108);
    }
}
