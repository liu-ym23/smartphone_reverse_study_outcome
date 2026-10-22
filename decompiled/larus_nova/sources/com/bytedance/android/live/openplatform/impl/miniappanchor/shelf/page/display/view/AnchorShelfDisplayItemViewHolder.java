package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.trade.AnchorShelfDisplayTradeLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/view/AnchorShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/view/CommonShelfDisplayItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/display/viewmodel/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorShelfDisplayItemViewHolder extends CommonShelfDisplayItemViewHolder<com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f84519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnchorShelfDisplayTradeLayout f84520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f84521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f84522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AnchorShelfDisplayTradeLayout.a f84523o;

    public static final class a {
    }

    public interface b {
        void gw(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r100);

        void tW(com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r100);
    }

    public interface c {
        void l50(int r100, long r101);
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean X3() {
        com.bytedance.android.live.openplatform.api.utils.a r100 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        return com.bytedance.android.live.openplatform.api.utils.a.f84001a.h();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Y3() {
        com.bytedance.android.live.openplatform.api.utils.a r100 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        return com.bytedance.android.live.openplatform.api.utils.a.f84001a.i();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean Z3() {
        com.bytedance.android.live.openplatform.api.utils.a r100 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        return com.bytedance.android.live.openplatform.api.utils.a.f84001a.e();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final boolean T3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r101 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.f84572a.c(true);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String V3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r101 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.c(null);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final String W3(com.bytedance.android.live.openplatform.api.model.shelf.a r100) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r101 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r100;
        Intrinsics.checkNotNullParameter(r101, "cardInfo");
        return r101.f84572a.h();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonShelfDisplayItemViewHolder
    public final void U3(CommonProductLabelLayout r100, com.bytedance.android.live.openplatform.api.model.shelf.a r101) {
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r102 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r101;
        Intrinsics.checkNotNullParameter(r100, "labelLayout");
        Intrinsics.checkNotNullParameter(r102, "cardInfo");
        ProductInfo r103 = r102.getProductInfo();
        if (r103 == null) goto L14;
        com.bytedance.android.live.openplatform.api.utils.a r104 = com.bytedance.android.live.openplatform.api.utils.a.f84001a;
        if (r104.h() == true) goto L7;
    L13:
        r100.setVisibility(8);
        return;
    L7:
        if (r104.j() == false) goto L13;
        List<ProductLabelInfo> r105 = r103.labelList;
        if (r105 == null) goto L13;
        if ((!r105.isEmpty()) != true) goto L13;
        List<ProductLabelInfo> r106 = r103.labelList;
        Intrinsics.checkNotNull(r106);
        r100.r(r106);
        r100.setVisibility(0);
        return;
    L14:
        r100.setVisibility(8);
    }

    public AnchorShelfDisplayItemViewHolder(View r100, c r101, b r102, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view.a r103) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "onItemExplainButtonClickListener");
        Intrinsics.checkNotNullParameter(r102, "onItemClickListener");
        Intrinsics.checkNotNullParameter(r103, "config");
        super(r100);
        this.f84521m = r101;
        this.f84522n = r102;
        this.f84523o = r103;
        this.f84519k = (TextView) r100.findViewById(R.id.review_status_tv);
        this.f84520l = (AnchorShelfDisplayTradeLayout) r100.findViewById(R.id.trade_layout);
    }
}
