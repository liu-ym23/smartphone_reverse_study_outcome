package com.bytedance.android.ec.hybrid.data.utils;

import com.bytedance.android.shopping.api.mall.MallPageName;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/data/utils/d;", "", "", "", "keys", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "paths", "c", "pageNames", "b", "setPageNames", "(Ljava/util/List;)V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("keys")
    private final List<String> keys;

    @SerializedName("page_names")
    private List<String> pageNames;

    @SerializedName("paths")
    private final List<String> paths;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.keys, r101.keys) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.paths, r101.paths) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.pageNames, r101.pageNames) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.keys;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.paths;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.pageNames;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallChunkedApiConfig(keys=" + this.keys + ", paths=" + this.paths + ", pageNames=" + this.pageNames + ")";
    }

    public final List<String> a() {
        return this.keys;
    }

    public final List<String> b() {
        return this.pageNames;
    }

    public final List<String> c() {
        return this.paths;
    }

    public d(Object r100) {
        List<String> r101 = CollectionsKt.listOf("homepage");
        List<String> r102 = CollectionsKt.listOf(new String[]{"/aweme/v2/commerce/bff/homepage", "/aweme/v2/commerce/bff/homepage/"});
        List<String> r103 = CollectionsKt.listOf(new String[]{MallPageName.X_TAB_MALL, "order_homepage", "popup_mall_homepage"});
        this.keys = r101;
        this.paths = r102;
        this.pageNames = r103;
    }
}
