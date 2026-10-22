package com.bytedance.android.shopping.store.product;

import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.repository.vo.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public final class f {
    /* JADX WARN: Multi-variable type inference failed */
    public static StoreV2ProductListResponseVO a(List r110, List r111, List r112, boolean r210, Integer r211, Long r212, Integer r213, String r214, Integer r215, n r216, Integer r217, List r218, Map r219, ECHybridListDTO r310, k r311, String r312, String r313, int r314) {
        String r100 = null;
        if ((r314 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        List r103 = null;
    L14:
        int r104 = 0;
        if ((r314 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r314 & 16) == 0) goto L21;
        Integer r106 = null;
    L23:
        if ((r314 & 256) == 0) goto L25;
        Integer r107 = null;
    L27:
        if ((r314 & 512) == 0) goto L29;
        n r108 = null;
    L31:
        if ((r314 & 1024) == 0) goto L33;
        Integer r113 = null;
    L35:
        if ((r314 & 2048) == 0) goto L37;
        List r114 = null;
    L39:
        if ((r314 & 4096) == 0) goto L41;
        Map r115 = null;
    L43:
        if ((r314 & 8192) == 0) goto L45;
        ECHybridListDTO r116 = null;
    L47:
        if ((r314 & 16384) == 0) goto L49;
        k r117 = null;
    L51:
        if ((32768 & r314) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r314 & 65536) != 0) goto L58;
        r100 = r313;
    L58:
        StoreV2ProductListResponseVO r109 = new StoreV2ProductListResponseVO();
        r109.setGoodTypes(r101);
        r109.setSortTypes(r102);
        if (r103 == null) goto L61;
        r109.setProducts(r103);
    L61:
        r109.setHasMore(r105);
        if (r212 == null) goto L64;
        long r119 = r212.longValue();
    L65:
        r109.setCursor(r119);
        if (r213 == null) goto L68;
        r104 = r213.intValue();
    L68:
        r109.setRecommendModuleType(r104);
        r109.setBottomModuleParams(r214);
        r109.setLayoutType(r107);
        r109.setDiscountFilterButtons(r108);
        r109.setForceProductLayout(r113);
        r109.setStyleType(r106);
        r109.setPickTypes(r114);
        r109.setBizExtra(r115);
        r109.setHybridList(r116);
        r109.setHybridListVO(r117);
        r109.setPaginationParams(r118);
        r109.setHybridParams(r100);
        return r109;
    L64:
        r119 = 0;
        goto L65
    L53:
        r118 = r312;
        goto L55
    L49:
        r117 = r311;
        goto L51
    L45:
        r116 = r310;
        goto L47
    L41:
        r115 = r219;
        goto L43
    L37:
        r114 = r218;
        goto L39
    L33:
        r113 = r217;
        goto L35
    L29:
        r108 = r216;
        goto L31
    L25:
        r107 = r215;
        goto L27
    L21:
        r106 = r211;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
