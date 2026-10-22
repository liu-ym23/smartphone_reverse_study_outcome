package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.n1;
import com.bytedance.android.shopping.feed.event.y;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.FlowTinyProductView;
import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardBuyButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/RowPanelView;", "Lcom/bytedance/android/shopping/feed/resourcecard/view/BasePanelView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RowPanelView extends BasePanelView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f175319f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowTinyProductView f175320e;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromotionProductStruct f175321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RowPanelView f175322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ rd3.a f175323c;

        public static final class a implements nl.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f175324a;

            public a(b r100) {
                this.f175324a = r100;
            }

            @Override // nl.d
            public final void b(String r110, Map r111) {
                Intrinsics.checkNotNullParameter(r110, "enterPageType");
                FeedProductEventTracker r100 = FeedProductEventTracker.f174442a;
                b r112 = this.f175324a;
                rd3.a r101 = r112.f175323c;
                Promotion r102 = r112.f175322b.getPromotion();
                Promotion r113 = this.f175324a.f175322b.getPromotion();
                ProductFeedViewModel r114 = null;
                if (r113 == null) goto L9;
                PromotionProductStruct r115 = r113.getPromotionInfo();
                if (r115 == null) goto L9;
                PromotionProductBaseStruct r116 = r115.getBaseInfo();
                if (r116 == null) goto L9;
                String r103 = r116.getProductId();
            L10:
                FeedProductEventTracker.m(r100, r101, "buynow", r103, r102, null, null, null, 112);
                Context r104 = this.f175324a.f175322b.getContext();
                b r117 = this.f175324a;
                rd3.a r105 = r117.f175323c;
                if (r105 == null) goto L13;
                r114 = r105.f537236c;
            L13:
                FeedProductEventTracker.j(r104, r114, r105, r117.f175322b.getPromotion(), null, null);
                s0.a(new n1());
                return;
            L9:
                r103 = null;
                goto L10
            }
        }

        public b(PromotionProductStruct r100, RowPanelView r101, rd3.a r102) {
            this.f175321a = r100;
            this.f175322b = r101;
            this.f175323c = r102;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            EventBus.getDefault().post(new y("forward"));
            if (this.f175323c.f537238e == false) goto L5;
            String r100 = "a1.b7365.c3865.d60364";
        L6:
            Context r101 = this.f175322b.getContext();
            Boolean r102 = null;
            Object[] r103 = 0;
            if ((r101 instanceof FragmentActivity) == true) goto L9;
            r101 = null;
        L9:
            FragmentActivity r104 = (FragmentActivity) r101;
            rd3.a r105 = this.f175323c;
            a r106 = new a(this);
            PromotionProductStruct r110 = this.f175321a;
            Promotion r107 = this.f175322b.getPromotion();
            if (r107 == null) goto L12;
            String r111 = r107.getRecommendInfo();
        L13:
            ProductFeedActionHelper.e(r210, r104, r105, r106, null, r110, r111, new BtmItemBuilder(r100, r102, 2, r103 == true ? 1 : 0).withPageFinder(PageFinder.via(r210)), null, false, null, null, null, 7952);
            return;
        L12:
            r111 = null;
            goto L13
        L5:
            r100 = "a1.b7365.c4701.d05311";
            goto L6
        }
    }

    static {
    }

    public RowPanelView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RowPanelView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.resourcecard.view.BasePanelView
    public final void a(rd3.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "anchorInflowFeedItem");
        super.a(r100, r101);
        Promotion r102 = getPromotion();
        if (r102 == null) goto L27;
        PromotionProductStruct r103 = r102.getPromotionInfo();
        if (r103 == null) goto L28;
        FlowTinyProductView r104 = this.f175320e;
        if (r104 == null) goto L21;
        yd3.p r105 = r100.i();
        if (r105 == null) goto L13;
        yd3.m r106 = r105.l();
        if (r106 == null) goto L13;
        Integer r107 = r106.f();
    L14:
        if (r107 != null) goto L17;
    L19:
        int r108 = 5;
    L20:
        r104.setStyle(r108);
        r104.a(r103);
        goto L21
    L17:
        if (r107.intValue() != 4) goto L19;
        r108 = 6;
    L13:
        r107 = null;
    L21:
        FlowTinyProductView r109 = this.f175320e;
        if (r109 == null) goto L29;
        ProductFlowCardBuyButton r110 = r109.getBuyButton();
        if (r110 == null) goto L30;
        r110.setOnClickListener(new b(r103, this, r100));
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    public RowPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_row_panel_view, this, true);
        this.f175320e = (FlowTinyProductView) findViewById(R.id.product_view);
    }

    public /* synthetic */ RowPanelView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
