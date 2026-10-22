package com.bytedance.android.livesdk.livecommerce.promotion.card.model;

import android.view.View;
import bk2.b;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.e;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import il.a;
import jf.c;
import jf.d;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePromotionCardArgs extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f150097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f150098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PromotionListEventActionImpl f150099h;

    public LivePromotionCardArgs(g r110) {
        Intrinsics.checkNotNullParameter(r110, "args");
        g.a r100 = r110.f150037a;
        ILivePromotionCardContainerHandler r101 = r110.f150038b;
        c r102 = r110.f150039c;
        e r103 = r110.f150040d;
        a r111 = r110.f150041e;
        Intrinsics.checkNotNullParameter(r101, "containerHandler");
        Intrinsics.checkNotNullParameter(r111, "historyMap");
        super(r100, r101, r102, r103, r111);
        b r104 = new b();
        this.f150097f = r104;
        fi2.c.a r105 = fi2.c.f477229a;
        this.f150098g = fi2.c.a(r104, r102, r101.g());
        this.f150099h = new PromotionListEventActionImpl(r103, r111);
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.e r110, String r111, boolean r112, String r113, BtmItemBuilder r114, View r115) {
        Intrinsics.checkNotNullParameter(r110, "promotionParams");
        Intrinsics.checkNotNullParameter(r111, "clickArea");
        e r100 = this.f150040d;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.a("livesdk_click_product", MapsKt.emptyMap(), r113, r110.f42855a, LivePromotionCardArgs$recordClickEventByIntercept$intercept$1.INSTANCE) != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        d.b.f(this.f150098g, r110.f42856b, r111, r112, r113, r114, r115, false, 64);
        return;
    L7:
        r101 = false;
        goto L8
    }

    public static /* synthetic */ void b(LivePromotionCardArgs r100, com.bytedance.android.ec.common.api.jump.model.e r101, String r110, String r111, BtmItemBuilder r112, View r113, int r114) {
        if ((r114 & 4) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r114 & 16) == 0) goto L9;
        BtmItemBuilder r103 = null;
    L11:
        if ((r114 & 32) == 0) goto L13;
        View r104 = null;
    L14:
        r100.a(r101, r110, r102, r111, r103, r104);
        return;
    L13:
        r104 = r113;
        goto L14
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = false;
        goto L7
    }
}
