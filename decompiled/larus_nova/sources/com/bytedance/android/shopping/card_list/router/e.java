package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends CardListKitStarter {
    @Override // com.bytedance.android.shopping.card_list.router.CardListKitStarter
    public final CardPassThroughData b(HashMap<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaMap");
        CardPassThroughData r100 = super.b(r110);
        String r101 = r110.get(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE);
        String r102 = r110.get("history_path");
        String r103 = r110.get("enter_from_live_saas");
        String r104 = r110.get("cart_ids");
        String r105 = r110.get("shop_ids");
        String r106 = r110.get("show_shop_ids");
        String r107 = r110.get("anchor_cart_id");
        int r111 = k.r(r110.get("cart_height_percent"), 0);
        String r108 = r110.get("transparent_params");
        if (r108 != null) goto L5;
        String r112 = "";
    L6:
        String r113 = r110.get("delivery_session_id");
        if (r113 != null) goto L9;
        r113 = "";
    L9:
        r100.setCartSchemaData(new CartPassThroughData(r101, r102, r103, r104, r105, r106, r107, r112, r111, r113));
        return r100;
    L5:
        r112 = r108;
        goto L6
    }

    public e(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        super(r100, r101);
    }
}
