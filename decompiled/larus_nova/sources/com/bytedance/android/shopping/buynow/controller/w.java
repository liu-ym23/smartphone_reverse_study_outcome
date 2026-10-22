package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f170872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AndroidYaTaInstance f170873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BuyNowViewModel f170874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f170875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f170876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RecyclerView f170877f;

    public static final void a(w r110, boolean r111) {
        AndroidYaTaInstance r100 = r110.f170873b;
        String r101 = null;
        if (r100 == null) goto L7;
        Map<String, Object> r102 = r100.j();
        if (r102 == null) goto L7;
        Object r103 = r102.get("header_ceiling");
    L9:
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        Map r104 = (Map) r103;
        if (r104 == null) goto L37;
        Object r105 = r104.get("target_component_name");
        if ((r105 instanceof String) == true) goto L16;
        r105 = null;
    L16:
        String r106 = (String) r105;
        if (r106 == null) goto L51;
        Object r107 = r104.get("target_yata_key");
        if ((r107 instanceof String) == true) goto L22;
        r107 = null;
    L22:
        String r108 = (String) r107;
        if (r108 == null) goto L52;
        com.bytedance.kmp.ec.yata.store.node.c r109 = com.bytedance.android.shopping.buynow.utils.h.a(r110.f170873b, r106, r108);
        AndroidYaTaInstance r112 = r110.f170873b;
        if (r112 == null) goto L45;
        YataEventCenter r113 = r112.k();
        if (r113 == null) goto L45;
        com.bytedance.kmp.ec.yata.event.common.e.a r114 = com.bytedance.kmp.ec.yata.event.common.e.f251660a;
        AndroidYaTaInstance r115 = r110.f170873b;
        if (r109 == null) goto L32;
        r101 = r109.getKey();
    L32:
        String r116 = r101;
        if (r111 == false) goto L35;
        String r117 = "exchangeToCeiling";
    L36:
        r113.d(r114.a(r115, null, r116, r117, null, "calcVisibility"));
        goto L45
    L35:
        r117 = "exchangToNoCeiling";
    L45:
        com.bytedance.android.shopping.buynow.tracker.a r118 = r110.f170874c.getTracker();
        if (r111 == false) goto L48;
        String r119 = "1";
    L49:
        r118.a(MapsKt.mapOf(TuplesKt.to("is_ceiling", r119)));
        return;
    L48:
        r119 = "0";
        goto L49
    L52:
        return;
    L51:
        return;
    L37:
        View r120 = r110.f170876e;
        int r121 = 8;
        if (r111 == false) goto L40;
        int r122 = 0;
    L41:
        r120.setVisibility(r122);
        View r123 = r110.f170875d;
        if (r111 == true) goto L44;
        r121 = 0;
    L44:
        r123.setVisibility(r121);
        goto L45
    L40:
        r122 = 8;
    L7:
        r103 = null;
        goto L9
    }

    public w(AndroidYaTaInstance r100, BuyNowViewModel r101, View r102, View r103, RecyclerView r104) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        Intrinsics.checkNotNullParameter(r102, "headerContainer");
        Intrinsics.checkNotNullParameter(r103, "ceilingHeaderContainer");
        Intrinsics.checkNotNullParameter(r104, "bodyContainer");
        this.f170873b = r100;
        this.f170874c = r101;
        this.f170875d = r102;
        this.f170876e = r103;
        this.f170877f = r104;
    }
}
