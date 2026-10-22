package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final px0.a f87367a;

    public static final class a {
    }

    static {
    }

    public b(px0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "roomOrEpisode");
        this.f87367a = r100;
    }

    public final void a(boolean r100, int r101) {
        Pair[] r102 = new Pair[3];
        r102[0] = TuplesKt.to("room_id", String.valueOf(this.f87367a.b()));
        r102[1] = TuplesKt.to("anchor_id", this.f87367a.a());
        if (r100 == false) goto L5;
        String r103 = "1";
    L6:
        r102[2] = TuplesKt.to("is_ecom_fansclub", r103);
        Map<? extends String, ? extends String> r104 = MapsKt.mutableMapOf(r102);
        if (r101 <= 0) goto L9;
        r104.put("source", String.valueOf(r101));
    L9:
        mz0.n r105 = new mz0.n();
        Map<String, String> r106 = r105.f516447a;
        Intrinsics.checkNotNullParameter(r106, "map");
        Intrinsics.checkNotNullParameter(r104, "map");
        r106.putAll(r104);
        mz0.m r107 = new mz0.m();
        r107.b(LogCommon.ROOM);
        r107.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r108 = r105.f516448b;
        ArrayList r109 = (ArrayList) r108;
        r109.addAll(r107.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r110 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r111 = com.bytedance.android.scope.m.b(r110).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r111);
        ((mz0.i) ((f80.a) r111)).w3("livesdk_fansclub_api_call_rd", r105.f516447a, r105.f516448b);
        return;
    L5:
        r103 = "0";
        goto L6
    }
}
