package com.bytedance.android.shopping.inflow.cardui.product.header.vh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.shopping.deepfeed.slice.view.list.DeepFeedSlcListVH;
import com.bytedance.android.shopping.inflow.common.utils.Contants$InflowType;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/inflow/cardui/product/header/vh/BannerFooterVH;", "Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcListVH;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BannerFooterVH extends DeepFeedSlcListVH {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f176250b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f176251a;

    public static final class a {
        public static BannerFooterVH a(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new BannerFooterVH(LayoutInflater.from(r100.getContext()).inflate(R.layout.shopping_product_card_banner_footer, r100, false));
        }
    }

    static {
    }

    public BannerFooterVH(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f176251a = (TextView) r100.findViewById(R.id.shopping_release_to_direct_arrow_tv);
    }

    public final void T3(Contants$InflowType r100) {
        Intrinsics.checkNotNullParameter(r100, "inflowType");
        if (r100 != Contants$InflowType.INFEED_PRODUCT) goto L6;
        TextView r101 = this.f176251a;
        int r102 = g1.f45599a;
        r101.setTextColor(g1.a.a(this.itemView.getContext(), R.color.shopping_color_B3FFFFFF));
        return;
    }
}
