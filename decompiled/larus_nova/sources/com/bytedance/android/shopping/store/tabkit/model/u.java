package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR4\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/u;", "", "", "", "subTabBlockList", "Ljava/util/Map;", "getSubTabBlockList", "()Ljava/util/Map;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("sub_tab_block_list")
    private final Map<String, Map<String, String>> subTabBlockList;

    public u() {
    }

    public final List<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        LinkedHashMap r101 = new LinkedHashMap();
        String[] r102 = {"global", r100};
        int r103 = 0;
    L3:
        if (r103 >= 2) goto L10;
        String r104 = r102[r103];
        Map<String, Map<String, String>> r105 = this.subTabBlockList;
        if (r105 == null) goto L9;
        Map<String, String> r106 = r105.get(r104);
        if (r106 == null) goto L9;
        r101.putAll(r106);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator r108 = r101.entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L20;
        Map.Entry r109 = (Map.Entry) r108.next();
        if (com.bytedance.android.shopping.extensions.k.r((String) r109.getValue(), 0) <= 0) goto L16;
        boolean r110 = true;
    L17:
        if (r110 == false) goto L12;
        r107.put(r109.getKey(), r109.getValue());
        goto L12
    L16:
        r110 = false;
        goto L17
    L20:
        return CollectionsKt.toList(r107.keySet());
    }
}
