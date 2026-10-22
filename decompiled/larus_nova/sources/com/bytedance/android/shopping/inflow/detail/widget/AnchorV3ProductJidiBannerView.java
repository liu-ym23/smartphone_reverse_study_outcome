package com.bytedance.android.shopping.inflow.detail.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.shopping.feed.view.c;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld3.b;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/widget/AnchorV3ProductJidiBannerView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3ProductJidiBannerView extends LinearLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f176312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f176313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f176314c;

    public AnchorV3ProductJidiBannerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3ProductJidiBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public AnchorV3ProductJidiBannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_commerce_banner_product_layout, this, true);
    L6:
        this.f176312a = (SimpleDraweeView) findViewById(R.id.anchor_v3_sv_banner_icon);
        this.f176313b = (TextView) findViewById(R.id.anchor_v3_tv_banner_description);
        this.f176314c = findViewById(R.id.anchor_v3_ic_arrow);
        return;
    L5:
        u63.a.a(r100, R.layout.ec_commerce_banner_product_layout, this, true);
        goto L6
    }

    public /* synthetic */ AnchorV3ProductJidiBannerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
