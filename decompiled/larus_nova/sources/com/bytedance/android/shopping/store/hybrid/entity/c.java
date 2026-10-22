package com.bytedance.android.shopping.store.hybrid.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/entity/c;", "", "", "Lcom/bytedance/android/shopping/store/hybrid/entity/b;", "componentVersions", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "isvComponentBundleUrl", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("component_versions")
    private final List<b> componentVersions;

    @SerializedName("isv_component_bundle_url")
    private final List<String> isvComponentBundleUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.componentVersions, r101.componentVersions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.isvComponentBundleUrl, r101.isvComponentBundleUrl) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<b> r100 = this.componentVersions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.isvComponentBundleUrl;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IsvInfo(componentVersions=" + this.componentVersions + ", isvComponentBundleUrl=" + this.isvComponentBundleUrl + ")";
    }

    public c() {
        this.componentVersions = null;
        this.isvComponentBundleUrl = null;
    }

    public final List<b> a() {
        return this.componentVersions;
    }

    public final List<String> b() {
        return this.isvComponentBundleUrl;
    }
}
