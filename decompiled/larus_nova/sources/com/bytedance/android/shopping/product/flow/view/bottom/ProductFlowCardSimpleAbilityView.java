package com.bytedance.android.shopping.product.flow.view.bottom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\u000f\u001a\u00020\n8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/view/bottom/ProductFlowCardSimpleAbilityView;", "Landroid/widget/FrameLayout;", "", "", "resId", "", "setIcon", "", "text", "setText", "Landroid/widget/ImageView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "getTextTV", "()Landroid/widget/TextView;", "textTV", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProductFlowCardSimpleAbilityView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f182371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f182372b;

    public ProductFlowCardSimpleAbilityView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductFlowCardSimpleAbilityView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ImageView getIcon() {
        return this.f182371a;
    }

    public final TextView getTextTV() {
        return this.f182372b;
    }

    public final void setIcon(int r100) {
        this.f182371a.setImageResource(r100);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f182372b.setText(r100);
    }

    public ProductFlowCardSimpleAbilityView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_product_flow_card_ability_view, this);
        this.f182371a = (ImageView) findViewById(R.id.product_flow_card_ability_view_icon);
        this.f182372b = (TextView) findViewById(R.id.product_flow_card_ability_view_tv);
    }

    public /* synthetic */ ProductFlowCardSimpleAbilityView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
