package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.model.live.ligo.DynamicType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomCarryNewView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f150187e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LivePromotionCardArgs f150188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w83.d<?> f150189g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy<w83.i> f150190h;

    private final void update(com.bytedance.android.livesdk.livecommerce.promotion.card.i r100) {
        ListItemBottomCarryNewView r101 = (ListItemBottomCarryNewView) w().f();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        rl.a r102 = r100.f150059a.f42855a.getDynamicSlot();
        if (r102 == null) goto L6;
        ll.a r103 = r102.a();
        if (r103 == null) goto L6;
    L7:
        if (r103 == null) goto L31;
        String r104 = r100.f150059a.f42855a.getProductId();
        r101.setVisibility(0);
        int r105 = r103.a();
        if (r105 != DynamicType.NATIVE.getValue()) goto L20;
        r101.setVisibility(0);
        Lazy<? extends w83.i> r106 = r101.f150101a;
        if (r106 != null) goto L13;
    L30:
        r101.f150102b = r103;
        return;
    L13:
        if (r106.isInitialized() != true) goto L30;
        Lazy<? extends w83.i> r107 = r101.f150101a;
        if (r107 == null) goto L30;
        w83.i r108 = r107.getValue();
        if (r108 == null) goto L30;
        w83.i.a.a(r108, r101, r103, true, 8);
        goto L30
    L20:
        if (r105 != DynamicType.LYNX.getValue()) goto L30;
        r101.setVisibility(0);
        Lazy<? extends w83.i> r109 = r101.f150101a;
        if (r109 == null) goto L30;
        if (r109.isInitialized() != true) goto L30;
        Lazy<? extends w83.i> r110 = r101.f150101a;
        if (r110 == null) goto L30;
        w83.i r111 = r110.getValue();
        if (r111 == null) goto L30;
        w83.i.a.b(r111, r101, r103, r104);
        goto L30
    L31:
        ll.a r112 = r101.f150102b;
        if (r112 == null) goto L34;
        Integer r113 = Integer.valueOf(r112.a());
    L35:
        int r114 = DynamicType.NATIVE.getValue();
        if (r113 != null) goto L39;
    L41:
        int r115 = DynamicType.LYNX.getValue();
        if (r113 != null) goto L45;
    L47:
        r101.f150102b = null;
        Unit r116 = Unit.INSTANCE;
        return;
    L45:
        if (r113.intValue() != r115) goto L47;
        r101.a();
        goto L47
    L39:
        if (r113.intValue() != r114) goto L41;
        r101.b();
        goto L47
    L34:
        r113 = null;
    L6:
        r103 = r100.f150059a.f42855a.getClientData().f533699h;
        goto L7
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if ((r100 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r100 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r101 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f150187e == true) goto L11;
        this.f150187e = true;
        ListItemBottomCarryNewView r102 = (ListItemBottomCarryNewView) w().f();
        LivePromotionCardArgs r103 = this.f150188f;
        Lazy<w83.i> r104 = this.f150190h;
        Intrinsics.checkNotNullParameter(r103, "argument");
        r102.f150101a = r104;
        r102.getClass();
    L11:
        int r105 = a.f150186a[r101.f150060b.ordinal()];
        if (r105 != 1) goto L14;
        update(r101);
        return;
    L14:
        if (r105 != 2) goto L37;
        ListItemBottomCarryNewView r106 = (ListItemBottomCarryNewView) w().f();
        ll.a r107 = r106.f150102b;
        if (r107 == null) goto L19;
        Integer r108 = Integer.valueOf(r107.a());
    L20:
        int r109 = DynamicType.NATIVE.getValue();
        if (r108 != null) goto L24;
    L26:
        int r110 = DynamicType.LYNX.getValue();
        if (r108 != null) goto L30;
    L32:
        r106.f150102b = null;
        return;
    L30:
        if (r108.intValue() != r110) goto L32;
        r106.a();
        goto L32
    L24:
        if (r108.intValue() != r109) goto L26;
        r106.b();
        goto L32
    L19:
        r108 = null;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(LivePromotionCardArgs r100, w83.d<?> r101, Lazy<? extends w83.i> r102) {
        Intrinsics.checkNotNullParameter(r100, "arguments");
        Intrinsics.checkNotNullParameter(r102, "ligoViewManager");
        this.f150188f = r100;
        this.f150189g = r101;
        this.f150190h = r102;
    }
}
