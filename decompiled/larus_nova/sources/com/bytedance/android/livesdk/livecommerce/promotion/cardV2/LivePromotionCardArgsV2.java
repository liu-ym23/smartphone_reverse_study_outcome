package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.e;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImplV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionCardArgsV2 extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bk2.b f150470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jf.d f150471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w83.d<? extends w83.c> f150472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy<i> f150473i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PromotionListEventActionImplV2 f150474j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<com.bytedance.android.ec.common.api.jump.model.g> f150475k;

    public LivePromotionCardArgsV2(g r110, final Context r111, Function0<com.bytedance.android.ec.common.api.jump.model.g> r112) {
        Intrinsics.checkNotNullParameter(r110, "args");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "getPromotionParams");
        g.a r100 = r110.f150037a;
        final ILivePromotionCardContainerHandler r101 = r110.f150038b;
        jf.c r102 = r110.f150039c;
        e r113 = r110.f150040d;
        il.a r114 = r110.f150041e;
        Intrinsics.checkNotNullParameter(r101, "containerHandler");
        Intrinsics.checkNotNullParameter(r114, "historyMap");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "getPromotionParams");
        super(r100, r101, r102, r113, r114);
        this.f150475k = r112;
        bk2.b r103 = new bk2.b();
        this.f150470f = r103;
        fi2.c.a r104 = fi2.c.f477229a;
        jf.d r105 = fi2.c.a(r103, r102, r101.g());
        this.f150471g = r105;
        gj2.a r106 = new gj2.a(r114, r105, r112, r101);
        int r115 = ECSdk.f48106a;
        w83.g r116 = (w83.g) ECSdk.a(w83.g.class);
        if (r116 == null) goto L6;
        w83.d<? extends w83.c> r117 = r116.b(r106);
        if (r117 == null) goto L6;
    L7:
        this.f150472h = r117;
        this.f150473i = LazyKt.lazy(new LivePromotionCardArgsV2$ligoViewManager$1(this, r111, r101));
        this.f150474j = new PromotionListEventActionImplV2(r113, r114);
        return;
    L6:
        r117 = new y83.b(new c());
        goto L7
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.g r110, String r111, boolean r112, String r113, BtmItemBuilder r114, View r115) {
        Intrinsics.checkNotNullParameter(r110, "promotionParams");
        Intrinsics.checkNotNullParameter(r111, "clickArea");
        e r100 = this.f150040d;
        if (r100 == null) goto L7;
        boolean r101 = r100.a("livesdk_click_product", MapsKt.emptyMap(), r113, r110.f42873a, LivePromotionCardArgsV2$recordClickEventByIntercept$intercept$1.INSTANCE);
        boolean r102 = true;
        if (r101 != true) goto L7;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        this.f150471g.g(r110, r111, r112, r113, r114, r115, true);
        return;
    L7:
        r102 = false;
        goto L8
    }
}
