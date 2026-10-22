package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.module.PromotionCardExternalView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f150694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f150695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w83.d<?> f150696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy<i> f150697h;

    private final void update(com.bytedance.android.livesdk.livecommerce.promotion.card.h r100) {
        PromotionCardExternalView r101 = (PromotionCardExternalView) w().f();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        dm.a.b r102 = dm.a.a("CardBottom");
        StringBuilder r103 = new StringBuilder("bind card, product id = ");
        r103.append(r100.f150056a.f42873a.getProductId());
        r103.append(", bottom region=");
        ll.a r104 = r100.f150056a.f42873a.getClientData().f533699h;
        if (r104 == null) goto L5;
        Integer r105 = Integer.valueOf(r104.hashCode());
    L6:
        r103.append(r105);
        r102.a(r103.toString());
        rl.a r106 = r100.f150056a.f42873a.getDynamicSlot();
        if (r106 == null) goto L10;
        ll.a r107 = r106.a();
        if (r107 == null) goto L10;
    L12:
        if (r107 == null) goto L28;
        String r108 = r100.f150056a.f42873a.getProductId();
        r101.setVisibility(0);
        int r109 = r107.a();
        if (r109 != DynamicType.NATIVE.getValue()) goto L21;
        r101.setVisibility(0);
        Lazy<? extends i> r110 = r101.f150690b;
        if (r110 == null) goto L27;
        i r111 = r110.getValue();
        if (r111 == null) goto L27;
        i.a.a(r111, r101, r107, true, 8);
    L27:
        r101.f150691c = r107;
        r101.f150692d = r108;
        return;
    L21:
        if (r109 != DynamicType.LYNX.getValue()) goto L27;
        r101.setVisibility(0);
        Lazy<? extends i> r112 = r101.f150690b;
        if (r112 == null) goto L27;
        i r113 = r112.getValue();
        if (r113 == null) goto L27;
        i.a.b(r113, r101, r107, r108);
        goto L27
    L28:
        ll.a r114 = r101.f150691c;
        if (r114 == null) goto L31;
        Integer r115 = Integer.valueOf(r114.a());
    L32:
        int r116 = DynamicType.NATIVE.getValue();
        if (r115 != null) goto L36;
    L43:
        int r117 = DynamicType.LYNX.getValue();
        if (r115 != null) goto L47;
    L54:
        r101.f150691c = null;
        r101.f150692d = null;
        Unit r118 = Unit.INSTANCE;
        return;
    L47:
        if (r115.intValue() != r117) goto L54;
        Lazy<? extends i> r119 = r101.f150690b;
        if (r119 == null) goto L53;
        i r120 = r119.getValue();
        if (r120 == null) goto L53;
        r120.b(r101);
    L53:
        r101.setVisibility(8);
        goto L54
    L36:
        if (r115.intValue() != r116) goto L43;
        Lazy<? extends i> r121 = r101.f150690b;
        if (r121 == null) goto L42;
        i r122 = r121.getValue();
        if (r122 == null) goto L42;
        r122.d(r101);
    L42:
        r101.setVisibility(8);
        goto L54
    L31:
        r115 = null;
    L10:
        r107 = r100.f150056a.f42873a.getClientData().f533699h;
        goto L12
    L5:
        r105 = null;
        goto L6
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.h) == true) goto L5;
        QModel r101 = null;
    L6:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r102 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r101;
        if (r102 != null) goto L9;
        return;
    L9:
        if (this.f150694e == true) goto L12;
        this.f150694e = true;
        PromotionCardExternalView r103 = (PromotionCardExternalView) w().f();
        LivePromotionCardArgsV2 r104 = this.f150695f;
        Lazy<i> r105 = this.f150697h;
        Intrinsics.checkNotNullParameter(r104, "argument");
        r103.f150689a = r104;
        r103.f150690b = r105;
        r103.getClass();
    L12:
        int r106 = a.f150693a[r102.f150057b.ordinal()];
        if (r106 != 1) goto L15;
        update(r102);
        return;
    L15:
        if (r106 != 2) goto L52;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r107 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r100;
        PromotionCardExternalView r108 = (PromotionCardExternalView) w().f();
        dm.a.b r109 = dm.a.a("CardBottom");
        StringBuilder r110 = new StringBuilder("recycle card, product id=");
        r110.append(r108.f150692d);
        r110.append(", bottom region=");
        ll.a r111 = r108.f150691c;
        if (r111 == null) goto L20;
        Integer r112 = Integer.valueOf(r111.hashCode());
    L21:
        r110.append(r112);
        r109.a(r110.toString());
        ll.a r113 = r108.f150691c;
        if (r113 == null) goto L24;
        Integer r114 = Integer.valueOf(r113.a());
    L25:
        int r115 = DynamicType.NATIVE.getValue();
        if (r114 != null) goto L29;
    L36:
        int r116 = DynamicType.LYNX.getValue();
        if (r114 != null) goto L40;
    L47:
        r108.f150691c = null;
        r108.f150692d = null;
        return;
    L40:
        if (r114.intValue() != r116) goto L47;
        Lazy<? extends i> r117 = r108.f150690b;
        if (r117 == null) goto L46;
        i r118 = r117.getValue();
        if (r118 == null) goto L46;
        r118.b(r108);
    L46:
        r108.setVisibility(8);
        goto L47
    L29:
        if (r114.intValue() != r115) goto L36;
        Lazy<? extends i> r119 = r108.f150690b;
        if (r119 == null) goto L35;
        i r120 = r119.getValue();
        if (r120 == null) goto L35;
        r120.d(r108);
    L35:
        r108.setVisibility(8);
        goto L47
    L24:
        r114 = null;
        goto L25
    L20:
        r112 = null;
        goto L21
    L52:
        return;
    L5:
        r101 = r100;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(LivePromotionCardArgsV2 r100, w83.d<?> r101, Lazy<? extends i> r102) {
        Intrinsics.checkNotNullParameter(r100, "arguments");
        Intrinsics.checkNotNullParameter(r102, "ligoViewManager");
        this.f150695f = r100;
        this.f150696g = r101;
        this.f150697h = r102;
    }
}
