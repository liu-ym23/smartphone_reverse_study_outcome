package a73;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4NavArea;
import com.bytedance.android.shopping.anchorv4.nav.AnchorV4TabArea;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public interface l {
    View N();

    void O();

    void P(ShopFloatEntryVO r100);

    void Q(com.bytedance.android.shopping.anchorv3.i r100);

    void R();

    View S();

    void T(TopRightControlsVO r100, TopNavVO r101);

    void U(BackToTopEntryVO r100);

    void V();

    void Y(boolean r100, AnchorV4NavArea r101, AnchorV4TabArea r102, com.bytedance.android.shopping.anchorv4.topnav.g r103);

    void b0(List<ScrollNode> r100, boolean r101);

    void e0(Map<String, PendantsComponentVO> r100);

    void h(float r100);
}
