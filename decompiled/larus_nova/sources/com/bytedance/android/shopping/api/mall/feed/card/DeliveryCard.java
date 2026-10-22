package com.bytedance.android.shopping.api.mall.feed.card;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/card/DeliveryCard;", "Lcom/bytedance/android/ec/hybrid/list/holder/BaseViewHolder;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeliveryCard extends BaseViewHolder {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f170528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f170529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f170530q;

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final boolean C3() {
        return false;
    }

    public DeliveryCard(final View r210) {
        Intrinsics.checkNotNullParameter(r210, "itemView");
        super(r210);
        Lazy r110 = LazyKt.lazy(new DeliveryCard$tvText$2(r210));
        this.f170528o = r110;
        View r111 = r210.findViewById(R.id.left_divider);
        this.f170529p = r111;
        View r112 = r210.findViewById(R.id.right_divider);
        this.f170530q = r112;
        Double r113 = Double.valueOf(19.75d);
        q4(this, r111, 36, 1, null, r113, 8, null, 36);
        q4(this, r112, 36, 1, 8, r113, null, null, 48);
        r111.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorProtector.parseColor("#F4F4F4"), ColorProtector.parseColor("#D9D9D9")}));
        r112.setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{ColorProtector.parseColor("#D9D9D9"), ColorProtector.parseColor("#F4F4F4")}));
        r111.setAlpha(1.0f);
        r112.setAlpha(1.0f);
        q4(this, (AppCompatTextView) r110.getValue(), null, null, null, Double.valueOf(11.5d), null, Double.valueOf(10.5d), 23);
        ((AppCompatTextView) r110.getValue()).setMaxWidth(ToolsKt.d(270, this.itemView.getContext(), true, null));
        ((AppCompatTextView) r110.getValue()).setTextSize(0, ToolsKt.d(12, this.itemView.getContext(), true, null));
        TextViewCompat.setLineHeight((AppCompatTextView) r110.getValue(), ToolsKt.d(17, this.itemView.getContext(), true, null));
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        if ((r100 instanceof DeliveryCardData) == true) goto L5;
        r100 = null;
    L5:
        DeliveryCardData r103 = (DeliveryCardData) r100;
        if (r103 == null) goto L11;
        String r104 = r103.getText();
        if (r104 == null) goto L12;
        ((AppCompatTextView) this.f170528o.getValue()).setText(r104);
        return;
    L12:
        return;
    }

    public static void q4(DeliveryCard r100, View r101, Number r102, Number r103, Number r104, Number r105, Number r106, Number r107, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r102 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r103 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r105 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r106 = null;
    L18:
        if ((r110 & 32) == 0) goto L20;
        r107 = null;
    L20:
        r100.getClass();
        ViewGroup.LayoutParams r108 = r101.getLayoutParams();
        if (r108 != null) goto L23;
        return;
    L23:
        if (r102 == null) goto L25;
        r108.width = ToolsKt.d(r102, r101.getContext(), true, null);
    L25:
        if (r103 == null) goto L28;
        r108.height = ToolsKt.d(r103, r101.getContext(), true, null);
    L28:
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L30;
        ViewGroup.LayoutParams r109 = null;
    L31:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r109;
        if (r111 == null) goto L41;
        if (r104 == null) goto L35;
        r111.setMarginStart(ToolsKt.d(r104, r101.getContext(), true, null));
    L35:
        if (r105 == null) goto L37;
        r111.topMargin = ToolsKt.d(r105, r101.getContext(), true, null);
    L37:
        if (r106 == null) goto L39;
        r111.setMarginEnd(ToolsKt.d(r106, r101.getContext(), true, null));
    L39:
        if (r107 == null) goto L41;
        r111.bottomMargin = ToolsKt.d(r107, r101.getContext(), true, null);
    L41:
        r101.setLayoutParams(r108);
        return;
    L30:
        r109 = r108;
        goto L31
    }
}
