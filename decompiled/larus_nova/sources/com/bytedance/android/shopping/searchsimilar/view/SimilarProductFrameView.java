package com.bytedance.android.shopping.searchsimilar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.searchsimilar.model.ProductFrame;
import com.bytedance.android.shopping.searchsimilar.viewmodel.SimilarProductVM;
import com.bytedance.android.shopping.widget.legacy.SquareImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/SimilarProductFrameView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimilarProductFrameView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f182540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f182541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SquareImageView f182542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SquareImageView f182543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f182544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProductFrame f182545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f182546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SimilarProductVM f182547h;

    public SimilarProductFrameView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimilarProductFrameView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100) {
        this.f182544e = r100;
        if (r100 == false) goto L13;
        LinearLayout r101 = this.f182541b;
        if (r101 == null) goto L7;
        r101.setVisibility(0);
    L7:
        SquareImageView r102 = this.f182542c;
        if (r102 == null) goto L10;
        r102.setVisibility(0);
    L10:
        SquareImageView r103 = this.f182543d;
        if (r103 == null) goto L23;
        r103.setVisibility(8);
        return;
    L23:
        return;
    L13:
        LinearLayout r104 = this.f182541b;
        if (r104 == null) goto L16;
        r104.setVisibility(8);
    L16:
        SquareImageView r105 = this.f182542c;
        if (r105 == null) goto L19;
        r105.setVisibility(8);
    L19:
        SquareImageView r106 = this.f182543d;
        if (r106 == null) goto L25;
        r106.setVisibility(0);
        return;
    }

    public SimilarProductFrameView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_similar_product_frame_layout, this, true);
        this.f182540a = (FrameLayout) findViewById(R.id.ec_similar_product_frame_view_container);
        this.f182541b = (LinearLayout) findViewById(R.id.ec_similar_product_frame_selected_image_container);
        this.f182542c = (SquareImageView) findViewById(R.id.ec_similar_product_frame_selected_image);
        this.f182543d = (SquareImageView) findViewById(R.id.ec_similar_product_frame_unselected_image);
    }

    public /* synthetic */ SimilarProductFrameView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
