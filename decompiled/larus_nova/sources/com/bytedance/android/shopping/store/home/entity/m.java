package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {
    public static final ECShopCartInfo a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getCartInfo");
        Blcok r101 = r100.f183745f;     // Catch: Exception -> L19
        if (r101 == null) goto L18;
        List<Module> r102 = r101.getModuleList();     // Catch: Exception -> L19
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();     // Catch: Exception -> L19
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();     // Catch: Exception -> L19
        if (Intrinsics.areEqual(((Module) r104).getName(), ECShopModuleType.SHOPCARTINFO.getType()) == false) goto L9;
    L14:
        Module r105 = (Module) r104;     // Catch: Exception -> L19
        if (r105 == null) goto L18;
        return (ECShopCartInfo) new Gson().fromJson(r105.getData(), ECShopCartInfo.class);
    L13:
        r104 = null;
    L18:
        return null;
    }
}
