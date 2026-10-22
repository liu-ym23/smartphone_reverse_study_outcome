package com.bytedance.android.shopping.product.flow.indicator;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import cg4.a;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.product.flow.banner.BannerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import yg3.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/indicator/NumberBannerIndicatorView;", "Landroid/widget/LinearLayout;", "Lyg3/c;", "", "description", "", "setDescription", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NumberBannerIndicatorView extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f182366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f182367b;

    public NumberBannerIndicatorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NumberBannerIndicatorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // yg3.c
    public final void b(BannerView r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerView");
    }

    public final void c(TextView r100) {
        ColorStateList r101 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        int r102 = ExtensionsKt.getDp(10);
        int r103 = ExtensionsKt.getDp(2);
        r100.setTextSize(11.0f);
        r100.setTextColor(r101);
        r100.setPadding(r102, r103, r102, r103);
    }

    public final void setDescription(String r100) {
        if (a.a(r100) == false) goto L10;
        TextView r101 = this.f182366a;
        if (r101 == null) goto L7;
        r101.setText(r100);
    L7:
        TextView r102 = this.f182366a;
        if (r102 == null) goto L14;
        ExtensionsKt.visible(r102);
        return;
    L14:
        return;
    L10:
        TextView r103 = this.f182366a;
        if (r103 == null) goto L16;
        r103.setVisibility(4);
        return;
    }

    @Override // yg3.c
    public final void a(int r100, int r101) {
        TextView r102 = this.f182367b;
        if (r102 == null) goto L6;
        int r103 = g1.f45599a;
        r102.setText(g1.a.c(getContext(), com.larus.nova.R.string.shopping_anchor_v3_detail_header_indicator_suffix, new Object[]{"", Integer.valueOf(r100 + 1), Integer.valueOf(r101)}));
        return;
    }

    public NumberBannerIndicatorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(com.larus.nova.R.layout.ec_inflow_num_indicator_view, this, true);
        TextView r103 = (TextView) findViewById(com.larus.nova.R.id.spec_text);
        TextView r104 = null;
        if (r103 == null) goto L5;
        c(r103);
        r103.setBackgroundResource(com.larus.nova.R.drawable.shopping_bg_product_feed_indicator_with_white);
        r103.setVisibility(4);
        Unit r105 = Unit.INSTANCE;
    L6:
        this.f182366a = r103;
        TextView r106 = (TextView) findViewById(com.larus.nova.R.id.indicator_text);
        if (r106 == null) goto L9;
        c(r106);
        int r107 = g1.f45599a;
        r106.setText(g1.a.c(r100, com.larus.nova.R.string.shopping_anchor_v3_detail_header_indicator_suffix, new Object[]{"", 1, 0}));
        r106.setBackgroundResource(com.larus.nova.R.drawable.shopping_bg_product_feed_indicator_with_white);
        Unit r108 = Unit.INSTANCE;
        r104 = r106;
    L9:
        this.f182367b = r104;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ NumberBannerIndicatorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
