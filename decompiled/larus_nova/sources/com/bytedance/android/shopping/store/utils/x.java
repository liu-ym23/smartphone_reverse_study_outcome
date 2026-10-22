package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.event.ECShopApiEmptyParamsErrorEvent;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f186987a = 0;

    static {
    }

    public static String b(Pair... r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L23;
        Pair r104 = r100[r103];
        Object r105 = r104.component2();
        boolean r106 = true;
        if (r105 != null) goto L7;
    L19:
        if (r106 == false) goto L21;
        r101.add(r104);
    L21:
        r103 = r103 + 1;
        goto L3
    L7:
        if ((r105 instanceof String) == true) goto L9;
        r105 = null;
    L9:
        String r107 = (String) r105;
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == true) goto L19;
        r106 = false;
        goto L19
    L12:
        if (r107.length() == 0) goto L15;
        r108 = false;
        goto L16
    L23:
        return CollectionsKt.joinToString$default(CollectionsKt.toList(r101), "-", null, null, 0, null, null, 62, null);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "secShopId");
        if (StringsKt.isBlank(r101) == true) goto L5;
        return;
    L5:
        if (ECAppInfoService.f48114e.isDebug() == false) goto L7;
        int r102 = com.bytedance.android.ec.sdk.helper.j.f48125a;
        com.bytedance.android.ec.sdk.helper.j.c("SHOP_API_MONITOR_HELPER_TOAST", "店铺网络接口[" + r100 + "]检验失败，secShopId为空");
        return;
    L7:
        ECShopApiEmptyParamsErrorEvent r103 = new ECShopApiEmptyParamsErrorEvent();
        r103.setApiPath(r100);
        r103.setEmptyParams(b(new Pair[]{TuplesKt.to("sec_shop_id", r101)}));
    }
}
