package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductTextOrImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTextOrImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f174219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f174220b;

    public ProductTextOrImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductTextOrImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5(String r100, Integer r101) {
        if (r100 == null) goto L6;
        this.f174220b.setText(r100);
        this.f174220b.setVisibility(0);
        this.f174219a.setVisibility(8);
        return;
    L6:
        if (r101 == null) goto L9;
        int r102 = r101.intValue();
        this.f174219a.setImageResource(r102);
        this.f174219a.setVisibility(0);
        this.f174220b.setVisibility(8);
        return;
    }

    public ProductTextOrImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.inflate(r100, R.layout.shopping_deep_feed_product_text_or_image_view, this);
        this.f174219a = (ImageView) findViewById(R.id.deepfeed_product_cart_icon);
        ProductTextView r103 = (ProductTextView) findViewById(R.id.deepfeed_product_cart_text);
        this.f174220b = r103;
        com.bytedance.android.shopping.deepfeed.ui.view.a r104 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 13));
    }

    public /* synthetic */ ProductTextOrImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
