package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.StepperActionType;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.livesdk.livecommerce.network.response.ECCartItem;
import com.bytedance.android.livesdk.livecommerce.network.response.ECCartItemBasicInfo;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartData;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEditCartResponse;
import com.bytedance.android.livesdk.livecommerce.network.response.ECShopCartItem;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import org.greenrobot.eventbus.EventBus;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class m implements v0<ECEditCartResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PromotionJumpDispatcher f148679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepperActionType f148680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ql.a f148681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f148682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f148683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ cf.a f148684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f148685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f148686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g f148687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f148688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f148689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f148690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f148691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Context f148692n;

    @Override // vi2.v0
    public final void onError(Throwable r100) {
        StepperActionType r101 = this.f148680b;
        int r102 = g.f148654m[r101.ordinal()];
        if (r102 != 1) goto L5;
        Context r103 = this.f148692n;
        UIUtils.displayToast(r103, th.a.g(r103, R.string.ec_add_shop_cart_fail));
        return;
    L5:
        if (r102 != 2) goto L11;
        Context r104 = this.f148692n;
        UIUtils.displayToast(r104, th.a.g(r104, R.string.ec_sub_shop_cart_fail));
        return;
    }

    @Override // vi2.v0
    public final void onSuccess(ECEditCartResponse r310) {
        ECEditCartResponse r100 = r310;
        int r101 = 0;
        String r102 = null;
        List<CartNumWithBusinessLine> r103 = null;
        List<CartNumWithBusinessLine> r104 = null;
        if (r100 != null) goto L5;
    L45:
        if (r100 == null) goto L51;
        String r105 = r100.statusMessage;
        if (r105 == null) goto L51;
        if (a2.b(r105) != true) goto L51;
        UIUtils.displayToast(this.f148692n, r100.statusMessage);
    L69:
        PromotionJumpDispatcher r106 = this.f148679a;
        ql.a r107 = this.f148681c;
        com.bytedance.android.ec.common.api.jump.model.g r108 = this.f148687i;
        String r109 = this.f148688j;
        String r110 = this.f148689k;
        String r111 = this.f148690l;
        String r112 = this.f148691m;
        com.bytedance.android.ec.model.response.v r113 = r107.getStepperInfo();
        if (r113 == null) goto L72;
        int r114 = r113.b();
    L73:
        if (r100 == null) goto L75;
        int r115 = r100.statusCode;
    L76:
        PromotionJumpDispatcher.u(r106, r107, r108, r109, r110, r111, false, r112, r114, r115);
        return;
    L75:
        r115 = -1;
        goto L76
    L72:
        r114 = 0;
    L51:
        if (r100 == null) goto L62;
        ECEditCartData r116 = r100.getEditCartData();
        if (r116 == null) goto L62;
        String r117 = r116.getToastMsg();
        if (r117 == null) goto L62;
        if (a2.b(r117) != true) goto L62;
        Context r118 = this.f148692n;
        ECEditCartData r119 = r100.getEditCartData();
        if (r119 == null) goto L61;
        r102 = r119.getToastMsg();
    L61:
        UIUtils.displayToast(r118, r102);
    L62:
        StepperActionType r120 = this.f148680b;
        int r121 = g.f148653l[r120.ordinal()];
        if (r121 != 1) goto L65;
        Context r122 = this.f148692n;
        UIUtils.displayToast(r122, th.a.g(r122, R.string.ec_add_shop_cart_fail));
        goto L69
    L65:
        if (r121 != 2) goto L69;
        Context r123 = this.f148692n;
        UIUtils.displayToast(r123, th.a.g(r123, R.string.ec_sub_shop_cart_fail));
        goto L69
    L5:
        if (r100.statusCode != 0) goto L45;
        ECEditCartData r124 = r100.getEditCartData();
        if (r124 == null) goto L9;
        r101 = r124.getCartNum();
    L9:
        StepperActionType r125 = this.f148680b;
        int r126 = g.f148651j[r125.ordinal()];
        if (r126 == 1) goto L17;
        if (r126 != 2) goto L21;
        EventBus r127 = EventBus.getDefault();
        String r210 = this.f148681c.getProductId();
        if (r124 == null) goto L16;
        r103 = r124.getCartNumWithBusinessLine();
    L16:
        int r128 = r101;
        List<CartNumWithBusinessLine> r129 = r103;
        r127.post(new hl.b(r128, null, 201, r210, r129, this.f148682d, String.valueOf(this.f148683e), "edit_cart_from_stepper", null, null, null, null, null, null, false, null, null, null, 1048320));
    L21:
        EventBus.getDefault().post(new hl.d(r101));
        EventBus.getDefault().post(new hl.g(r101, true));
        StepperActionType r130 = this.f148680b;
        int r131 = g.f148652k[r130.ordinal()];
        if (r131 != 1) goto L24;
        String r132 = "stepper_add";
    L29:
        String r133 = r132;
        if (r124 == null) goto L44;
        List<ECShopCartItem> r134 = r124.getShopCartItem();
        if (r134 == null) goto L44;
        ECShopCartItem r135 = (ECShopCartItem) CollectionsKt.firstOrNull(r134);
        if (r135 == null) goto L44;
        List<ECCartItem> r136 = r135.getCartItemList();
        if (r136 == null) goto L44;
        ECCartItem r137 = (ECCartItem) CollectionsKt.firstOrNull(r136);
        if (r137 == null) goto L44;
        ECCartItemBasicInfo r138 = r137.getBasicInfo();
        if (r138 == null) goto L44;
        cf.a r139 = this.f148684f;
        if (r139 == null) goto L44;
        r139.b(r138.getComboNum(), r138.getProductId(), this.f148685g, r138.getCartId(), 201, this.f148686h, r138.getComboId(), Integer.valueOf(r138.getComboNum()), r133);
    L44:
        PromotionJumpDispatcher.u(this.f148679a, this.f148681c, this.f148687i, this.f148688j, this.f148689k, this.f148690l, true, this.f148691m, this.f148683e, r100.statusCode);
        return;
    L24:
        if (r131 != 2) goto L27;
        r132 = "stepper_sub";
        goto L29
    L27:
        throw new NoWhenBranchMatchedException();
    L17:
        EventBus r140 = EventBus.getDefault();
        String r141 = this.f148681c.getProductId();
        if (r124 == null) goto L20;
        r104 = r124.getCartNumWithBusinessLine();
    L20:
        r140.post(new hl.f(r141, r104, this.f148682d, String.valueOf(this.f148683e)));
        goto L21
    }

    public m(PromotionJumpDispatcher r100, StepperActionType r101, ql.a r102, String r103, int r104, cf.a r105, String r106, String r107, com.bytedance.android.ec.common.api.jump.model.g r108, String r110, String r111, String r112, String r113, Context r114) {
        this.f148679a = r100;
        this.f148680b = r101;
        this.f148681c = r102;
        this.f148682d = r103;
        this.f148683e = r104;
        this.f148684f = r105;
        this.f148685g = r106;
        this.f148686h = r107;
        this.f148687i = r108;
        this.f148688j = r110;
        this.f148689k = r111;
        this.f148690l = r112;
        this.f148691m = r113;
        this.f148692n = r114;
    }
}
