package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.r1;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yd3.t;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeViewStyle1;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/HeaderNodeView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNodeViewStyle1 extends HeaderNodeView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f175242g = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f175243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f175244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECDraweeView f175245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f175246f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HeaderNodeViewStyle1 f175247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f175248b;

        public a(HeaderNodeViewStyle1 r100, Context r101) {
            this.f175247a = r100;
            this.f175248b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            yd3.f r111 = this.f175247a.getHeaderNode();
            if (r111 == null) goto L7;
            yd3.g r112 = r111.c();
            if (r112 == null) goto L7;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f175248b, r112.c());
        L7:
            rd3.a r100 = this.f175247a.getAnchorInflowFeedItem();
            if (r100 == null) goto L10;
            FeedProductEventTracker.m(FeedProductEventTracker.f174442a, r100, "rank_entrance", null, null, null, null, null, 124);
        L10:
            rd3.a r113 = this.f175247a.getAnchorInflowFeedItem();
            if (r113 == null) goto L15;
            yd3.p r114 = r113.i();
            if (r114 == null) goto L15;
            Integer r115 = Integer.valueOf(r114.getType());
        L16:
            if (r115 != null) goto L19;
            return;
        L19:
            if (r115.intValue() != 2) goto L38;
            r1 r116 = new r1();
            r116.f174857a = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE;
            rd3.a r101 = this.f175247a.getAnchorInflowFeedItem();
            if (r101 == null) goto L25;
            rd3.o r102 = r101.g();
            if (r102 == null) goto L25;
            String r103 = r102.a();
        L26:
            r116.f174867k = r103;
            rd3.a r104 = this.f175247a.getAnchorInflowFeedItem();
            if (r104 == null) goto L31;
            Promotion r105 = r104.f();
            if (r105 == null) goto L31;
            String r106 = r105.getId();
        L32:
            r116.f174868l = r106;
            rd3.a r107 = this.f175247a.getAnchorInflowFeedItem();
            if (r107 == null) goto L35;
            Integer r108 = Integer.valueOf(r107.f537239f);
        L36:
            r116.f174859c = String.valueOf(r108);
            r116.post(null, null);
            return;
        L35:
            r108 = null;
        L31:
            r106 = null;
        L25:
            r103 = null;
            goto L26
        L38:
            return;
        L15:
            r115 = null;
            goto L16
        }
    }

    public static final class b {
    }

    static {
    }

    public HeaderNodeViewStyle1(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HeaderNodeViewStyle1(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.HeaderNodeView
    public final void a(rd3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        super.a(r100);
        ECDraweeView r101 = this.f175245e;
        yd3.f r102 = getHeaderNode();
        String r103 = null;
        if (r102 == null) goto L7;
        t r104 = r102.d();
        if (r104 == null) goto L7;
        ECUrlModel r105 = r104.b();
    L8:
        y.a(r101, r105);
        TextView r106 = this.f175243c;
        yd3.f r107 = getHeaderNode();
        if (r107 == null) goto L13;
        t r108 = r107.f();
        if (r108 == null) goto L13;
        String r109 = r108.c();
    L14:
        r106.setText(r109);
        TextView r110 = this.f175246f;
        yd3.f r111 = getHeaderNode();
        if (r111 == null) goto L19;
        yd3.g r112 = r111.c();
        if (r112 == null) goto L19;
        r103 = r112.d();
    L19:
        r110.setText(r103);
        return;
    L13:
        r109 = null;
    L7:
        r105 = null;
        goto L8
    }

    public HeaderNodeViewStyle1(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_header_node_view_style_1, this, true);
        this.f175243c = (TextView) findViewById(R.id.header_node_title);
        this.f175245e = (ECDraweeView) findViewById(R.id.header_node_title_icon);
        ViewGroup r103 = (ViewGroup) findViewById(R.id.ec_more_container);
        this.f175244d = r103;
        this.f175246f = (TextView) findViewById(R.id.ec_more_tv);
        r103.setOnClickListener(new a(this, r100));
        float r104 = 12;
        Resources r105 = Resources.getSystem();
        int r106 = MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())));
        Resources r107 = Resources.getSystem();
        setPadding(r106, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))), 0);
    }

    public /* synthetic */ HeaderNodeViewStyle1(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
