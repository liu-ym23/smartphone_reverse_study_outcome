package com.bytedance.android.shopping.inflow.detail.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.utils.y;
import com.bytedance.android.shopping.feed.event.g;
import com.bytedance.android.shopping.feed.event.l1;
import com.bytedance.android.shopping.feed.utils.l;
import com.bytedance.android.shopping.feed.view.c;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/widget/AnchorV3ProductBrandView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/feed/view/c;", "", "d", "Ljava/lang/String;", "getPageType", "()Ljava/lang/String;", "setPageType", "(Ljava/lang/String;)V", "pageType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3ProductBrandView extends LinearLayout implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f176304f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f176305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f176306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PromotionProductStruct f176307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f176308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f176309e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV3ProductBrandView f176310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f176311b;

        public a(AnchorV3ProductBrandView r100, Context r101) {
            this.f176310a = r100;
            this.f176311b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AnchorV3ProductBrandView r101 = this.f176310a;
            if (r101.f176309e == true) goto L6;
            int r102 = l.f175455a;
            PromotionProductStruct r103 = r101.f176307c;
            String r104 = r101.getPageType();
            Context r105 = this.f176311b;
            Intrinsics.checkNotNullParameter("brand_name_click", "eventName");
            int r106 = com.bytedance.android.ec.core.opt.ab.c.f45223a;
            l1 r107 = new l1("brand_name_click");
            r107.f174800a = y.d(r103);
            r107.f174801b = r104;
            g.c(r107, r105, null);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public AnchorV3ProductBrandView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3ProductBrandView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.shopping.feed.view.c
    public final void a() {
    }

    public final String getPageType() {
        return this.f176308d;
    }

    public final void setPageType(String r100) {
        this.f176308d = r100;
    }

    public AnchorV3ProductBrandView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (ld3.b.a() == false) goto L5;
        Map<Activity, ShoppingAsyncCacheInflater> r103 = ShoppingAsyncCacheInflater.f45261d;
        View r104 = ShoppingAsyncCacheInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v3_brand_layout, this, true);
    L6:
        this.f176305a = (ECDraweeView) r104.findViewById(R.id.anchor_v3_sv_brand_icon);
        this.f176306b = (TextView) r104.findViewById(R.id.anchor_v3_tv_brand_name);
        r104.setOnClickListener(new a(this, r100));
        return;
    L5:
        ShoppingAsyncInflater.f45268e.getClass();
        r104 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v3_brand_layout, this, true);
        goto L6
    }

    public /* synthetic */ AnchorV3ProductBrandView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
