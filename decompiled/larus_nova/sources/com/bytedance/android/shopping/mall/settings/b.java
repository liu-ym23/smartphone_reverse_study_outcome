package com.bytedance.android.shopping.mall.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/mall/settings/b;", "", "", "enableCacheClean", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "", "cacheCleanThreshold", "Ljava/lang/Integer;", "getCacheCleanThreshold", "()Ljava/lang/Integer;", "cleanToNumber", "getCleanToNumber", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("cache_clean_threshold")
    private final Integer cacheCleanThreshold;

    @SerializedName("clean_to_number")
    private final Integer cleanToNumber;

    @SerializedName("enable_cache_clean")
    private final Boolean enableCacheClean;

    public static final class a {
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.enableCacheClean, r101.enableCacheClean) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cacheCleanThreshold, r101.cacheCleanThreshold) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cleanToNumber, r101.cleanToNumber) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.enableCacheClean;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.cacheCleanThreshold;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.cleanToNumber;
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
        return "MallTabCacheCleanConfig(enableCacheClean=" + this.enableCacheClean + ", cacheCleanThreshold=" + this.cacheCleanThreshold + ", cleanToNumber=" + this.cleanToNumber + ")";
    }

    public final Boolean a() {
        return this.enableCacheClean;
    }

    public b(int r100) {
        this.enableCacheClean = Boolean.FALSE;
        this.cacheCleanThreshold = 5;
        this.cleanToNumber = 3;
    }
}
