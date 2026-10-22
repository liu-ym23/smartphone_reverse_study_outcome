package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tc3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductPriceView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductPriceView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductTextView f174207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f174208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProductTextView f174209c;

    public ProductPriceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductPriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ProductPriceView(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        ViewGroup.LayoutParams r112 = null;
        ProductTextView r113 = new ProductTextView(r100, null, 6, 0);
        r113.setText("¥");
        r113.setMaxLines(1);
        r113.setTextSize(1, 14.0f);
        r113.setWeight(500);
        r113.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r113.setIncludeFontPadding(false);
        Unit r101 = Unit.INSTANCE;
        ProductTextView r102 = new ProductTextView(r100, null, 6, 0);
        r102.setMaxLines(1);
        r102.setTextSize(1, 24.0f);
        r102.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r102.setIncludeFontPadding(false);
        this.f174207a = r102;
        ProductTextView r103 = new ProductTextView(r100, null, 6, 0);
        r103.setMaxLines(1);
        r103.setTextSize(1, 16.0f);
        r103.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r103.setIncludeFontPadding(false);
        this.f174208b = r103;
        ProductTextView r104 = new ProductTextView(r100, null, 6, 0);
        r104.setMaxLines(1);
        r104.setTextSize(1, 12.0f);
        r104.setTextColor(ColorProtector.parseColor("#FFFF003C"));
        r104.setIncludeFontPadding(false);
        this.f174209c = r104;
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -2);
        r105.gravity = 80;
        addView(r113, r105);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(-2, -2);
        r106.setMarginStart(com.bytedance.android.shopping.extensions.b.b(1));
        r106.gravity = 80;
        addView(r102, r106);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-2, -2);
        r107.gravity = 80;
        addView(r103, r107);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        r108.leftMargin = com.bytedance.android.shopping.extensions.b.b(2);
        r108.gravity = 80;
        addView(r104, r108);
        if (f.e() == false) goto L32;
        r113.setTextSize(1, 12.0f);
        Integer r109 = f.c();
        if (r109 != null) goto L9;
    L18:
        Integer r114 = f.c();
        if (r114 != null) goto L22;
    L31:
        r102.setTypeface(Typeface.defaultFromStyle(1));
        r104.setTextSize(1, 13.0f);
        r104.setWeight(600);
        goto L32
    L22:
        if (r114.intValue() != 2) goto L31;
        r102.setTextSize(1, 22.0f);
        ViewGroup.LayoutParams r115 = r102.getLayoutParams();
        if ((r115 instanceof LinearLayout.LayoutParams) == false) goto L27;
        r112 = r115;
    L27:
        LinearLayout.LayoutParams r116 = (LinearLayout.LayoutParams) r112;
        if (r116 == null) goto L30;
        com.bytedance.android.shopping.deepfeed.ui.view.a r117 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r116.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r102.getContext(), 23);
    L30:
        r102.setLayoutParams(r116);
        goto L31
    L9:
        if (r109.intValue() != 1) goto L18;
        r102.setTextSize(1, 28.0f);
        ViewGroup.LayoutParams r118 = r102.getLayoutParams();
        if ((r118 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r112 = r118;
    L14:
        LinearLayout.LayoutParams r119 = (LinearLayout.LayoutParams) r112;
        if (r119 == null) goto L17;
        com.bytedance.android.shopping.deepfeed.ui.view.a r120 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r119.height = com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r102.getContext(), 29);
    L17:
        r102.setLayoutParams(r119);
    L32:
        setVisibility(8);
    }

    public /* synthetic */ ProductPriceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
