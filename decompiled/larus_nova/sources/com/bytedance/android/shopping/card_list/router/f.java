package com.bytedance.android.shopping.card_list.router;

import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CollectPassThroughData;
import com.bytedance.android.shopping.extensions.k;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends CardListKitStarter {
    @Override // com.bytedance.android.shopping.card_list.router.CardListKitStarter
    public final CardPassThroughData b(HashMap<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "schemaMap");
        CardPassThroughData r100 = super.b(r110);
        String r101 = r110.get("previous_page");
        String r102 = r110.get("is_from_personal");
        String r103 = r110.get("collect_experiment_value");
        String r104 = r110.get("sec_uid");
        if (r104 != null) goto L5;
        String r105 = "";
    L6:
        String r106 = r110.get("uid");
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        String r111 = r110.get("uid");
        if (r111 != null) goto L13;
        r111 = "";
    L13:
        if (r101 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
        r101 = com.bytedance.android.ec.core.event.a.VALUE_PERSONAL_HOMEPAGE;
    L21:
        String r108 = r105;
        String r109 = r106;
        String r112 = r111;
        r100.setCollectSchemaData(new CollectPassThroughData(r108, r109, r112, r101, Intrinsics.areEqual(r102, "1"), k.r(r103, 0)));
        return r100;
    L15:
        if (r101.length() == 0) goto L18;
        r107 = false;
        goto L19
    L5:
        r105 = r104;
        goto L6
    }

    public f(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        super(r100, r101);
    }
}
