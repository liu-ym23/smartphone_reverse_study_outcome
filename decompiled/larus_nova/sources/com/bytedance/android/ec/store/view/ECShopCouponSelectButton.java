package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopCouponSelectButton;", "Landroid/widget/LinearLayout;", "", "show", "", "setShowText", "", "text", "setText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopCouponSelectButton extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f48744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f48745b;

    public ECShopCouponSelectButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopCouponSelectButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setShowText(boolean r100) {
        TextView r101 = this.f48744a;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f48744a.setText(r100);
    }

    public ECShopCouponSelectButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(17);
        TextView r103 = new TextView(r100);
        r103.setText("选券");
        r103.setTextColor((int) 4284243301L);
        Intrinsics.checkNotNullParameter(r103, "$this$setTextSizeDp");
        r103.setTextSize(1, 12.0f);
        Unit r104 = Unit.INSTANCE;
        this.f48744a = r103;
        ImageView r105 = new ImageView(r100);
        r105.setImageResource(R.drawable.ec_shop_dropdown_arrow);
        this.f48745b = r105;
        addView(r103);
        int r106 = ExtensionsKt.a(8);
        ViewGroup.MarginLayoutParams r107 = new ViewGroup.MarginLayoutParams(r106, r106);
        r107.setMarginStart(ExtensionsKt.a(2));
        addView(r105, r107);
    }

    public /* synthetic */ ECShopCouponSelectButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
