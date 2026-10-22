package com.bytedance.android.live.recharge.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.platform.core.ui.DiamondFitTextView;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.utils.r3;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/viewholder/CustomDealViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/RechargeItem$CustomItem;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomDealViewHolder extends AbsRechargeViewHolder<RechargeItem.CustomItem> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f90557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DiamondFitTextView f90558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f90559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f90560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f90561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f90562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f90563h;

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void U3() {
        this.itemView.setSelected(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void V3() {
        this.itemView.setSelected(false);
        RechargeItem.CustomItem r100 = (RechargeItem.CustomItem) this.f90222a;
        if (r100 == null) goto L6;
        r100.f90223a = 0;
        r100.f90225c = "";
        r100.f90226d = RechargeItem.CustomItem.Mode.INPUT;
        W3(r100);
        return;
    }

    public CustomDealViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f90557b = (TextView) r100.findViewById(R.id.desc);
        this.f90558c = (DiamondFitTextView) r100.findViewById(R.id.diamond);
        this.f90559d = (TextView) r100.findViewById(R.id.price);
        this.f90560e = (ViewGroup) r100.findViewById(R.id.diamond_layout);
        this.f90561f = (TextView) r100.findViewById(R.id.custom_deal_input);
        this.f90562g = (TextView) r100.findViewById(R.id.custom_deal_input_tip);
        this.f90563h = (ViewGroup) r100.findViewById(R.id.custom_deal_input_layout);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder
    public final void T3(RechargeItem r100) {
        RechargeItem.CustomItem r101 = (RechargeItem.CustomItem) r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f90222a = r101;
        if (r101.f90226d != RechargeItem.CustomItem.Mode.DIAMOND) goto L33;
        ViewGroup r102 = this.f90560e;
        if (r102 == null) goto L7;
        ViewUtilsKt.f(r102);
    L7:
        ViewGroup r103 = this.f90563h;
        if (r103 == null) goto L10;
        ViewUtilsKt.e(r103);
    L10:
        String r104 = r101.f90225c;
        if (TextUtils.isEmpty(r104) == true) goto L18;
        TextView r105 = this.f90557b;
        if (r105 == null) goto L15;
        ViewUtilsKt.f(r105);
    L15:
        TextView r106 = this.f90557b;
        if (r106 == null) goto L21;
        r106.setText(r104);
    L21:
        String r107 = r3.b();
        DiamondFitTextView r108 = this.f90558c;
        if (r108 == null) goto L24;
        String r109 = String.valueOf(r101.f90223a / 10);
        r108.f90253f = r109;
        r108.f90254g = r107;
        r108.f90252e = R.color.ttlive_recharge_diamond_color;
        r108.z(r109, r108.f90251d, true);
    L24:
        DiamondFitTextView r110 = this.f90558c;
        if (r110 == null) goto L27;
        r110.setTextAlignment(4);
    L27:
        TextView r111 = this.f90559d;
        if (r111 == null) goto L30;
        r111.setTextSize(1, 12.0f);
    L30:
        String r112 = q.a(r101.f90223a);
        TextView r113 = this.f90559d;
        if (r113 == null) goto L35;
        r113.setText(s1.C(R.string.ttlive_recharge_dialog_real_price, new Object[]{r112}));
        return;
    L35:
        return;
    L18:
        TextView r114 = this.f90557b;
        if (r114 == null) goto L21;
        ViewUtilsKt.e(r114);
        goto L21
    L33:
        W3(r101);
    }

    public final void W3(RechargeItem.CustomItem r100) {
        ViewGroup r101 = this.f90563h;
        if (r101 == null) goto L5;
        ViewUtilsKt.f(r101);
    L5:
        ViewGroup r102 = this.f90560e;
        if (r102 == null) goto L8;
        ViewUtilsKt.e(r102);
    L8:
        String r103 = r100.f90225c;
        if (TextUtils.isEmpty(r103) == true) goto L16;
        TextView r104 = this.f90557b;
        if (r104 == null) goto L13;
        ViewUtilsKt.f(r104);
    L13:
        TextView r105 = this.f90557b;
        if (r105 == null) goto L19;
        r105.setText(r103);
    L19:
        TextView r106 = this.f90561f;
        if (r106 == null) goto L22;
        r106.setText(s1.B(R.string.ttlive_input_money));
    L22:
        long r107 = r100.f90224b;
        if (r107 <= 0) goto L30;
        TextView r108 = this.f90562g;
        if (r108 == null) goto L27;
        ViewUtilsKt.f(r108);
    L27:
        TextView r109 = this.f90562g;
        if (r109 == null) goto L34;
        r109.setText(s1.C(R.string.ttlive_live_custom_recharge_price_tip, new Object[]{Integer.valueOf((int) (r107 / 100.0f))}));
        return;
    L34:
        return;
    L30:
        TextView r110 = this.f90562g;
        if (r110 == null) goto L36;
        ViewUtilsKt.e(r110);
        return;
    L36:
        return;
    L16:
        TextView r111 = this.f90557b;
        if (r111 == null) goto L19;
        ViewUtilsKt.e(r111);
        goto L19
    }
}
