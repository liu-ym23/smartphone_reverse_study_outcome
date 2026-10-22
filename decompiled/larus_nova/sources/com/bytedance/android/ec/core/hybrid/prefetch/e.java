package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/e;", "", "", "Lcom/bytedance/android/ec/core/hybrid/prefetch/v;", "staticPreloadConfig", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lcom/bytedance/android/ec/core/hybrid/prefetch/a;", "apiPreloadConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("api_preload_config")
    private final List<a> apiPreloadConfig;

    @SerializedName("static_preload_config")
    private final List<v> staticPreloadConfig;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.staticPreloadConfig, r101.staticPreloadConfig) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.apiPreloadConfig, r101.apiPreloadConfig) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<v> r100 = this.staticPreloadConfig;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<a> r104 = this.apiPreloadConfig;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImagePreloadConfig(staticPreloadConfig=" + this.staticPreloadConfig + ", apiPreloadConfig=" + this.apiPreloadConfig + ")";
    }

    public e() {
        this.staticPreloadConfig = null;
        this.apiPreloadConfig = null;
    }

    public final List<a> a() {
        return this.apiPreloadConfig;
    }

    public final List<v> b() {
        return this.staticPreloadConfig;
    }
}
