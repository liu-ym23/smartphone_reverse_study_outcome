package com.bytedance.android.shopping.mall.homepage.jsb;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f178210a = 0;

    static {
    }

    public static void a(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "sceneID");
        long r100 = System.currentTimeMillis();
        String r113 = "";
        if (r111 != null) goto L5;
        String r101 = "";
    L6:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.feedItemClicked", r100, r110, false, MapsKt.mapOf(TuplesKt.to(ST.UUID_DEVICE, r101)), false, 32));
        long r102 = System.currentTimeMillis();
        if (r112 == null) goto L10;
        r113 = r112;
    L10:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.gylCardClicked", r102, r110, false, MapsKt.mapOf(TuplesKt.to("itemId", r113)), false, 32));
        return;
    L5:
        r101 = r111;
        goto L6
    }
}
