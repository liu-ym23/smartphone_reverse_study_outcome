package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopMallGoldCouponView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMallGoldCouponView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f48790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f48791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f48792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f48793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f48794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f48795f;

    public ECShopMallGoldCouponView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECShopMallGoldCouponView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public ECShopMallGoldCouponView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        View r103 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_window_gold_coupon_view_layout, this, true);
        this.f48795f = r103;
        this.f48790a = (TextView) r103.findViewById(R.id.coupon_tag);
        this.f48791b = (TextView) r103.findViewById(R.id.coupon_prefix);
        this.f48792c = (ImageView) r103.findViewById(R.id.coupon_divider);
        this.f48793d = r103.findViewById(R.id.coupon_stroke);
        this.f48794e = r103.findViewById(R.id.coupon_divider_new);
    }

    public /* synthetic */ ECShopMallGoldCouponView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
