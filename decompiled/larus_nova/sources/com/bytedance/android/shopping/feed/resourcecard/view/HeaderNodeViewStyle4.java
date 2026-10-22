package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle4;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "getMoreContainer", "()Landroid/view/ViewGroup;", "moreContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle4 extends HeaderNodeView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f175261e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f175262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f175263d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeaderNodeViewStyle4 f175264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175265b;

        public a(HeaderNodeViewStyle4 r100, Context r101) {
            this.f175264a = r100;
            this.f175265b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            yd3.f r111 = this.f175264a.getHeaderNode();
            if (r111 == null) goto L7;
            yd3.g r112 = r111.c();
            if (r112 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f175265b, r112.c());
        L7:
            rd3.a r100 = this.f175264a.getAnchorInflowFeedItem();
            if (r100 == null) goto L11;
            FeedProductEventTracker.m(FeedProductEventTracker.f174442a, r100, "button", null, null, null, null, null, 124);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle4(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderNodeViewStyle4(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final ViewGroup getMoreContainer() {
        return this.f175262c;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        super.a(r100);
        TextView r101 = this.f175263d;
        yd3.f r102 = getHeaderNode();
        if (r102 == null) goto L7;
        yd3.g r103 = r102.c();
        if (r103 == null) goto L7;
        String r104 = r103.d();
    L8:
        r101.setText(r104);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public HeaderNodeViewStyle4(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_header_node_view_style_4, this, true);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.ec_more_container);
        this.f175262c = r103;
        this.f175263d = (TextView) findViewById(R.id.ec_more_tv);
        r103.setOnClickListener(new a(this, r100));
        float r104 = 12;
        Resources r105 = Resources.getSystem();
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        Resources r107 = Resources.getSystem();
        setPadding(r106, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeViewStyle4(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
