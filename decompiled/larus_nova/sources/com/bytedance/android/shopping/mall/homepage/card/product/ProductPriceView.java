package com.bytedance.android.shopping.mall.homepage.card.product;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/product/ProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f178018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f178019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProductTextView f178020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ProductTextView f178021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProductTextView f178022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProductTextView f178023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProductTextView f178024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ProductTextView f178025h;

    public ProductPriceView(Context r100) {
        super(r100);
        ProductTextView r101 = new ProductTextView(getContext());
        r101.setText("¥");
        r101.setMaxLines(1);
        Unit r102 = Unit.INSTANCE;
        this.f178019b = r101;
        ProductTextView r103 = new ProductTextView(getContext());
        r103.setMaxLines(1);
        this.f178020c = r103;
        ProductTextView r104 = new ProductTextView(getContext());
        r104.setMaxLines(1);
        this.f178021d = r104;
        ProductTextView r105 = new ProductTextView(getContext());
        r105.setMaxLines(1);
        this.f178022e = r105;
        ProductTextView r106 = new ProductTextView(getContext());
        r106.setMaxLines(1);
        this.f178023f = r106;
        ProductTextView r107 = new ProductTextView(getContext());
        r107.setMaxLines(1);
        this.f178024g = r107;
        ProductTextView r108 = new ProductTextView(getContext());
        r108.setMaxLines(1);
        this.f178025h = r108;
        addView(r101, new LinearLayout.LayoutParams(-2, -2));
        addView(r103, new LinearLayout.LayoutParams(-2, -2));
        addView(r104, new LinearLayout.LayoutParams(-2, -2));
        addView(r105, new LinearLayout.LayoutParams(-2, -2));
        addView(r106, new LinearLayout.LayoutParams(-2, -2));
        addView(r107, new LinearLayout.LayoutParams(-2, -2));
        addView(r108, new LinearLayout.LayoutParams(-2, -2));
    }

    public ProductPriceView(Context r100, AttributeSet r101) {
        super(r100, r101);
        ProductTextView r102 = new ProductTextView(getContext());
        r102.setText("¥");
        r102.setMaxLines(1);
        Unit r103 = Unit.INSTANCE;
        this.f178019b = r102;
        ProductTextView r104 = new ProductTextView(getContext());
        r104.setMaxLines(1);
        this.f178020c = r104;
        ProductTextView r105 = new ProductTextView(getContext());
        r105.setMaxLines(1);
        this.f178021d = r105;
        ProductTextView r106 = new ProductTextView(getContext());
        r106.setMaxLines(1);
        this.f178022e = r106;
        ProductTextView r107 = new ProductTextView(getContext());
        r107.setMaxLines(1);
        this.f178023f = r107;
        ProductTextView r108 = new ProductTextView(getContext());
        r108.setMaxLines(1);
        this.f178024g = r108;
        ProductTextView r109 = new ProductTextView(getContext());
        r109.setMaxLines(1);
        this.f178025h = r109;
        addView(r102, new LinearLayout.LayoutParams(-2, -2));
        addView(r104, new LinearLayout.LayoutParams(-2, -2));
        addView(r105, new LinearLayout.LayoutParams(-2, -2));
        addView(r106, new LinearLayout.LayoutParams(-2, -2));
        addView(r107, new LinearLayout.LayoutParams(-2, -2));
        addView(r108, new LinearLayout.LayoutParams(-2, -2));
        addView(r109, new LinearLayout.LayoutParams(-2, -2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(getChildAt(getChildCount() - 1), this.f178025h) == true) goto L7;
        return;
    L7:
        if (this.f178018a < 10) goto L23;
        if (this.f178025h.getPaint().measureText(this.f178025h.getText().toString()) <= this.f178025h.getMeasuredWidth()) goto L24;
        int r102 = this.f178018a - 1;
        this.f178018a = r102;
        if (r102 < 10) goto L12;
        ProductTextView r103 = this.f178025h;
        int r104 = c.f47296a;
        r103.setTextSize(1, c.b(Integer.valueOf(r102), getContext()));
        goto L7
    L12:
        this.f178025h.setVisibility(8);
        goto L7
    L24:
        return;
    }

    public ProductPriceView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ProductTextView r103 = new ProductTextView(getContext());
        r103.setText("¥");
        r103.setMaxLines(1);
        Unit r104 = Unit.INSTANCE;
        this.f178019b = r103;
        ProductTextView r105 = new ProductTextView(getContext());
        r105.setMaxLines(1);
        this.f178020c = r105;
        ProductTextView r106 = new ProductTextView(getContext());
        r106.setMaxLines(1);
        this.f178021d = r106;
        ProductTextView r107 = new ProductTextView(getContext());
        r107.setMaxLines(1);
        this.f178022e = r107;
        ProductTextView r108 = new ProductTextView(getContext());
        r108.setMaxLines(1);
        this.f178023f = r108;
        ProductTextView r109 = new ProductTextView(getContext());
        r109.setMaxLines(1);
        this.f178024g = r109;
        ProductTextView r110 = new ProductTextView(getContext());
        r110.setMaxLines(1);
        this.f178025h = r110;
        addView(r103, new LinearLayout.LayoutParams(-2, -2));
        addView(r105, new LinearLayout.LayoutParams(-2, -2));
        addView(r106, new LinearLayout.LayoutParams(-2, -2));
        addView(r107, new LinearLayout.LayoutParams(-2, -2));
        addView(r108, new LinearLayout.LayoutParams(-2, -2));
        addView(r109, new LinearLayout.LayoutParams(-2, -2));
        addView(r110, new LinearLayout.LayoutParams(-2, -2));
    }
}
