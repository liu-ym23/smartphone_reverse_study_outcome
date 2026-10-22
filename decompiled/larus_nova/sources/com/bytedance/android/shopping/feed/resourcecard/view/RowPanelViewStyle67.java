package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductViewStyle67;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/RowPanelViewStyle67;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Lyd3/m;", "panelsNode", "", "setImage", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RowPanelViewStyle67 extends BasePanelView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f175325f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowTinyProductViewStyle67 f175326e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RowPanelViewStyle67 f175327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ rd3.a f175328b;

        public b(RowPanelViewStyle67 r100, rd3.a r101) {
            this.f175327a = r100;
            this.f175328b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            FeedProductEventTracker r100 = FeedProductEventTracker.f174442a;
            rd3.a r101 = this.f175328b;
            Promotion r102 = this.f175327a.getPromotion();
            Promotion r111 = this.f175327a.getPromotion();
            if (r111 == null) goto L9;
            PromotionProductStruct r112 = r111.getPromotionInfo();
            if (r112 == null) goto L9;
            PromotionProductBaseStruct r113 = r112.getBaseInfo();
            if (r113 == null) goto L9;
            String r114 = r113.getProductId();
        L10:
            FeedProductEventTracker.m(r100, r101, "pic", r114, r102, null, null, null, 112);
            Promotion r115 = this.f175327a.getPromotion();
            if (r115 == null) goto L16;
            String r116 = r115.getLink();
            if (r116 == null) goto L17;
            com.bytedance.android.ec.sdk.helper.p.f48130a.openSchema(this.f175327a.getContext(), r116);
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r114 = null;
            goto L10
        }
    }

    static {
    }

    public RowPanelViewStyle67(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RowPanelViewStyle67(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final void setImage(yd3.m r110) {
        FlowTinyProductViewStyle67 r100 = this.f175326e;
        ECUrlModel r101 = null;
        if (r100 == null) goto L10;
        ECDraweeView r102 = r100.getLineDv();
        if (r102 == null) goto L10;
        if (r110 == null) goto L8;
        ECUrlModel r103 = r110.g();
    L9:
        h0.d(r102, r103, null, null, null, null, null, 120);
        goto L10
    L8:
        r103 = null;
    L10:
        FlowTinyProductViewStyle67 r104 = this.f175326e;
        if (r104 == null) goto L18;
        ECDraweeView r105 = r104.getDiscountMinPriceBg();
        if (r105 == null) goto L19;
        if (r110 == null) goto L16;
        r101 = r110.d();
    L16:
        h0.d(r105, r101, null, null, null, null, null, 120);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.BasePanelView
    public final void a(rd3.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        super.a(r100, r101);
        yd3.p r102 = r100.i();
        if (r102 == null) goto L5;
        yd3.m r103 = r102.l();
    L6:
        Promotion r104 = getPromotion();
        if (r104 == null) goto L17;
        PromotionProductStruct r105 = r104.getPromotionInfo();
        if (r105 == null) goto L18;
        FlowTinyProductViewStyle67 r106 = this.f175326e;
        if (r106 == null) goto L13;
        r106.a(r105);
    L13:
        setImage(r103);
        FlowTinyProductViewStyle67 r107 = this.f175326e;
        if (r107 == null) goto L19;
        r107.setOnClickListener(new b(this, r100));
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public RowPanelViewStyle67(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_row_panel_view_style67, this, true);
        this.f175326e = (FlowTinyProductViewStyle67) findViewById(R.id.product_view);
    }

    public /* synthetic */ RowPanelViewStyle67(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
