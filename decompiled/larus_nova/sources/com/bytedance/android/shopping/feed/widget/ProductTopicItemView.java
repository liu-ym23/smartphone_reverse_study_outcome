package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/ProductTopicItemView;", "Landroid/widget/FrameLayout;", "", "marginRight", "", "setMarginRight", "marginLeft", "setMarginLeft", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductTopicItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f175982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f175983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f175984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TopicItemInfo f175985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f175986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<TopicItemInfo> f175987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnchorV3Param f175988g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductTopicItemView f175989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175990b;

        public a(ProductTopicItemView r100, Context r101) {
            this.f175989a = r100;
            this.f175990b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TopicItemInfo r101 = this.f175989a.f175985d;
            if (r101 == null) goto L11;
            String r102 = r101.getSchema();
            if (r102 == null) goto L11;
            ArrayList<String> r103 = d0.f175444a;
            Context r104 = this.f175990b;
            TopicItemInfo r105 = this.f175989a.f175985d;
            if (r105 == null) goto L9;
            String r106 = r105.getId();
        L10:
            String r107 = r106;
            ProductTopicItemView r108 = this.f175989a;
            d0.b(r104, r102, r107, r108.f175986e, r108.f175987f, r108.f175988g);
            goto L11
        L9:
            r106 = null;
        L11:
            FeedProductEventTracker r109 = FeedProductEventTracker.f174442a;
            Context r110 = this.f175990b;
            TopicItemInfo r111 = this.f175989a.f175985d;
            r109.getClass();
            FeedProductEventTracker.G(r110, "label_click", r111);
        }
    }

    public ProductTopicItemView(Context r100) {
        this(r100, null);
    }

    public final void setMarginLeft(int r100) {
        ViewGroup.LayoutParams r101 = this.f175984c.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.leftMargin = r100;
        return;
    }

    public final void setMarginRight(int r100) {
        ViewGroup.LayoutParams r101 = this.f175984c.getLayoutParams();
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;
        if (r102 == null) goto L9;
        r102.rightMargin = r100;
        return;
    }

    public ProductTopicItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_product_topic_item_view, this);
        this.f175982a = (ECDraweeView) findViewById(R.id.product_feed_sv_topic_icon);
        this.f175983b = (TextView) findViewById(R.id.product_feed_tv_topic_name);
        this.f175984c = findViewById(R.id.product_feed_topic_rootview);
        setOnClickListener(new a(this, r100));
    }
}
