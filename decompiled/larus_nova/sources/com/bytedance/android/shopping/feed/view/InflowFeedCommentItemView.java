package com.bytedance.android.shopping.feed.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/InflowFeedCommentItemView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InflowFeedCommentItemView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f175501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f175502b;

    public InflowFeedCommentItemView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public InflowFeedCommentItemView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getSize(r100);
        Iterator<T> r103 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L6;
        r104 = r104 + ((View) r103.next()).getMeasuredWidth();
        goto L4
    L6:
        if (r104 <= r102) goto L10;
        TextView r105 = this.f175501a;
        r105.measure(View.MeasureSpec.makeMeasureSpec(r102 - (r104 - r105.getMeasuredWidth()), 1073741824), r101);
        return;
    }

    public InflowFeedCommentItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_inflow_feed_comment_item, this, true);
    L6:
        this.f175501a = (TextView) findViewById(R.id.inflow_feed_comment_view_comment);
        this.f175502b = (ECDraweeView) findViewById(R.id.inflow_feed_comment_view_avatar);
        TextView r104 = (TextView) findViewById(R.id.inflow_feed_comment_view_comment_prefix);
        TextView r105 = (TextView) findViewById(R.id.inflow_feed_comment_view_comment_suffix);
        setGravity(16);
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_inflow_feed_comment_item, this, true);
        goto L6
    }

    public /* synthetic */ InflowFeedCommentItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
