package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeadBubbleSingleCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeadBubbleSingleCard extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f189918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f189919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SimpleDraweeView f189920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SimpleDraweeView f189921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SimpleDraweeView f189922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SimpleDraweeView f189923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f189924g;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189918a = (TextView) findViewById(R.id.ec_window_head_bubble_title);
        this.f189919b = (TextView) findViewById(R.id.ec_window_head_bubble_subtitle);
        SimpleDraweeView r100 = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_entrance);
        this.f189920c = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_product_one);
        this.f189921d = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_product_two);
        this.f189922e = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_product_three);
        this.f189923f = (SimpleDraweeView) findViewById(R.id.ec_window_head_bubble_product_four);
        this.f189924g = findViewById(R.id.ec_window_head_bubble_just_watched);
    }

    public WindowHeadBubbleSingleCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
