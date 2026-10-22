package a73;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv4.dto.business.SameGoodsItem;
import com.bytedance.android.shopping.anchorv4.voavhs.AnchorV4Adapter;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface b {
    void D(int r100);

    void F(Map<String, ? extends Object> r100);

    void d0(float r100);

    AnchorV4Adapter f0();

    AnchorV4Adapter n();

    void u(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r100, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r101, List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r102, List<d63.d> r103, List<j63.c> r104, PromotionRecommendResponse r105, com.bytedance.android.shopping.anchorv4.vm.a r106, j63.a r107, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r108);

    void v(List<SameGoodsItem> r100);

    void z(Map<String, SlcElement> r100);
}
