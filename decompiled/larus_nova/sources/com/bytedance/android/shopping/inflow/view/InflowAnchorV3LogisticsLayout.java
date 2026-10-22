package com.bytedance.android.shopping.inflow.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/InflowAnchorV3LogisticsLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "weight", "", "setFontWeight", "color", "setTextColor", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowAnchorV3LogisticsLayout extends FrameLayout implements com.bytedance.android.shopping.feed.view.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f176341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f176342b;

    public InflowAnchorV3LogisticsLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowAnchorV3LogisticsLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final void setFontWeight(int r100) {
        TextView r101 = this.f176342b;
        ViewExtensionsKt.e(r101, r101.getPaint(), 500);
    }

    public final void setTextColor(int r100) {
        this.f176342b.setTextColor(r100);
    }

    public InflowAnchorV3LogisticsLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        View r104 = ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v3_logistics_layout, this, true);
    L6:
        ECDraweeView r105 = (ECDraweeView) r104.findViewById(R.id.anchor_v3_logistic_icon);
        this.f176341a = r105;
        TextView r106 = (TextView) r104.findViewById(R.id.anchor_v3_logistic_text);
        this.f176342b = r106;
        se3.a.c(r106, 2, 14.0f);
        se3.a.b(r105);
        return;
    L5:
        r104 = u63.a.a(r100, R.layout.ec_commerce_anchor_v3_logistics_layout, this, true);
        goto L6
    }

    public /* synthetic */ InflowAnchorV3LogisticsLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
