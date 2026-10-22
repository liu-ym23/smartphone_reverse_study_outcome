package com.bytedance.android.shopping.abscontainer.common_biz.helper;

import com.bytedance.android.shopping.extensions.k;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l33.c;
import w33.f;

/* JADX INFO: loaded from: classes12.dex */
public final class OrderLoadingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f164293a = 0;

    static {
    }

    public static void a(c r110, Boolean r111, boolean r112, Map r113, f r210) {
        Intrinsics.checkNotNullParameter(r210, "loadingObservableData");
        if ((!Intrinsics.areEqual(r111, Boolean.TRUE)) == false) goto L18;
        if (r112 == false) goto L6;
        r210.c(new y43.a(true, false, true, true, 18));
        return;
    L6:
        r210.c(new y43.a(false, false, false, false, 30));
        return;
    L18:
        if (r112 == false) goto L15;
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r100 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.f164354a;     // Catch: Exception -> L17
        Pair[] r101 = new Pair[3];     // Catch: Exception -> L17
        r101[0] = TuplesKt.to("service", 61);     // Catch: Exception -> L17
        r101[1] = TuplesKt.to("sdk_info", MapsKt.mapOf(TuplesKt.to("loading_status", 1)));     // Catch: Exception -> L17
        if (r113 != null) goto L13;
        Map r102 = MapsKt.emptyMap();     // Catch: Exception -> L17
    L14:
        r101[2] = TuplesKt.to("ext", k.x(MapsKt.mapOf(TuplesKt.to("sdk_show_info", r102))));     // Catch: Exception -> L17
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.d(r110, MapsKt.mapOf(r101), OrderLoadingHelper$toggleLoading$1.INSTANCE);     // Catch: Exception -> L17
        return;
    L13:
        r102 = r113;
        goto L14
    L15:
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b r103 = com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.f164354a;     // Catch: Exception -> L17
        com.bytedance.android.shopping.abscontainer.common_biz.platform.util.b.d(r110, MapsKt.mapOf(new Pair[]{TuplesKt.to("service", 61), TuplesKt.to("sdk_info", MapsKt.mapOf(TuplesKt.to("loading_status", 0)))}), OrderLoadingHelper$toggleLoading$2.INSTANCE);     // Catch: Exception -> L17
        r210.c(new y43.a(false, false, false, false, 30));     // Catch: Exception -> L17
        return;
    }
}
