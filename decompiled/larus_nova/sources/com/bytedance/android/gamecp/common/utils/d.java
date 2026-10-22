package com.bytedance.android.gamecp.common.utils;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57215a = 0;

    public d() {
    }

    static {
    }

    public static void a(String r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = "android";
    L8:
        Intrinsics.checkNotNullParameter(r100, "status");
        com.bytedance.android.gamecp.host_api.a.b().getLogService().logV3("dygame_tech_all_lynx_detail_page_full_link_event", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", r100), TuplesKt.to("reason", r101), TuplesKt.to("from", r102)}));
    }
}
