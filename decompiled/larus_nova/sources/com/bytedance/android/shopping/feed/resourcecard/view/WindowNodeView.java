package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yd3.u;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/WindowNodeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowNodeView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f175344l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f175345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f175346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rd3.a f175347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f175348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f175349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f175350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f175351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f175352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageWithPrice f175353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageWithPrice f175354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ImageWithPrice f175355k;

    public static final class a {
    }

    static {
    }

    public WindowNodeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public WindowNodeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (((((this.f175348d.getMeasuredWidth() + com.bytedance.android.shopping.extensions.b.b(8)) + com.bytedance.android.shopping.extensions.b.b(16)) + com.bytedance.android.shopping.extensions.b.b(40)) + com.bytedance.android.shopping.extensions.b.b(64)) <= this.f175351g.getMeasuredWidth()) goto L10;
        u r102 = this.f175345a;
        if (r102 == null) goto L11;
        String r103 = r102.d();
        if (r103 == null) goto L12;
        this.f175348d.setText(r103.substring(0, Math.min(8, r103.length())));
        this.f175348d.setText(this.f175348d.getText().toString() + "...的橱窗");
        return;
    L12:
        return;
    L11:
        return;
    }

    public WindowNodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_window_node_view, this, true);
        this.f175348d = (TextView) findViewById(R.id.window_node_author_name);
        this.f175346b = (ECDraweeView) findViewById(R.id.window_node_author_avatar);
        LinearLayout r103 = (LinearLayout) findViewById(R.id.window_node_info_ll);
        this.f175349e = findViewById(R.id.following_tip);
        this.f175350f = (TextView) findViewById(R.id.reco_info);
        this.f175351g = (ViewGroup) findViewById(R.id.header_ll);
        this.f175352h = findViewById(R.id.window_node_button);
        this.f175353i = (ImageWithPrice) findViewById(R.id.image_view_1);
        this.f175354j = (ImageWithPrice) findViewById(R.id.image_view_2);
        this.f175355k = (ImageWithPrice) findViewById(R.id.image_view_3);
    }

    public /* synthetic */ WindowNodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(rd3.a r110, String r111, String r112, Promotion r113) {
        String r100 = "pic";
        if (Intrinsics.areEqual(r111, "pic") == false) goto L9;
        com.bytedance.android.ec.sdk.helper.p r101 = com.bytedance.android.ec.sdk.helper.p.f48130a;
        Context r102 = getContext();
        if (r113 == null) goto L7;
        String r103 = r113.getLink();
    L8:
        r101.openSchema(r102, r103);
    L14:
        FeedProductEventTracker r104 = FeedProductEventTracker.f174442a;
        if (Intrinsics.areEqual(r111, "pic") == true) goto L18;
        r100 = "others";
    L18:
        FeedProductEventTracker.m(r104, r110, r100, null, null, null, null, null, 124);
        Context r105 = getContext();
        if (r113 == null) goto L25;
        PromotionProductStruct r106 = r113.getPromotionInfo();
        if (r106 == null) goto L25;
        PromotionProductBaseStruct r107 = r106.getBaseInfo();
        if (r107 == null) goto L25;
        String r108 = r107.getProductId();
    L26:
        FeedProductEventTracker.R(r110, r105, null, "product_flow_under", r112, r111, LiveEndPageData.TAG_WINDOW, r108);
        return;
    L25:
        r108 = null;
        goto L26
    L7:
        r103 = null;
        goto L8
    L9:
        yd3.p r109 = r110.i();
        if (r109 == null) goto L14;
        String r114 = r109.n();
        if (r114 == null) goto L14;
        com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(getContext(), r114);
        goto L14
    }
}
