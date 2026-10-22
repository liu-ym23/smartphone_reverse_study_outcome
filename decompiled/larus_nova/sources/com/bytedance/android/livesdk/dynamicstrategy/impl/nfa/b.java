package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.k0;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f123213a = 0;

    public b() {
    }

    static {
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("StrategyCepNfa_timer", r100);
    }

    public static void b(String r100, Map r101) {
        k0.o().j(r100, r101);
    }

    public static void c(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "patternName");
        Intrinsics.checkNotNullParameter(r103, "reason");
        b("StrategyCepNfa_pattern", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r100), TuplesKt.to(ReportCardMonitorPlugin.EVENT_NAME, r101), TuplesKt.to("pattern_name", r102), TuplesKt.to("reason", r103)}));
    }

    public static void a(String r100, String r101, long r102, long r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r104, "reason");
        b("StrategyCepNfa_flow_remove", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r100), TuplesKt.to("nfa_name", r101), TuplesKt.to(DyPayConstant.KEY_START_TIME, Long.valueOf(r102)), TuplesKt.to("lastTime", Long.valueOf(r103)), TuplesKt.to("reason", r104)}));
    }
}
