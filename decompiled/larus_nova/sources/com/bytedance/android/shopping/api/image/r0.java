package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/image/r0;", "", "", "enableDowngrade", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "optUrlCache", "e", "", "closeMaxTime", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "downgradeValue", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "checkCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "Lcom/bytedance/android/shopping/api/image/s0;", "versions", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("check_count")
    private final Integer checkCount;

    @SerializedName("close_max_time")
    private final Long closeMaxTime;

    @SerializedName("downgrade_value")
    private final Integer downgradeValue;

    @SerializedName("enable_downgrade")
    private final Boolean enableDowngrade;

    @SerializedName("opt_url_cache")
    private final Boolean optUrlCache;

    @SerializedName("versions")
    private final Map<String, s0> versions;

    public r0() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r0) == false) goto L18;
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.enableDowngrade, r101.enableDowngrade) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optUrlCache, r101.optUrlCache) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.closeMaxTime, r101.closeMaxTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downgradeValue, r101.downgradeValue) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.checkCount, r101.checkCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.versions, r101.versions) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.enableDowngrade;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.optUrlCache;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.closeMaxTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.downgradeValue;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.checkCount;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, s0> r116 = this.versions;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UrlModifyConfDowngradeConf(enableDowngrade=" + this.enableDowngrade + ", optUrlCache=" + this.optUrlCache + ", closeMaxTime=" + this.closeMaxTime + ", downgradeValue=" + this.downgradeValue + ", checkCount=" + this.checkCount + ", versions=" + this.versions + ")";
    }

    public final Integer a() {
        return this.checkCount;
    }

    public final Long b() {
        return this.closeMaxTime;
    }

    public final Integer c() {
        return this.downgradeValue;
    }

    public final Boolean d() {
        return this.enableDowngrade;
    }

    public final Boolean e() {
        return this.optUrlCache;
    }

    public final Map<String, s0> f() {
        return this.versions;
    }

    public r0(Object r100) {
        this.enableDowngrade = null;
        this.optUrlCache = null;
        this.closeMaxTime = null;
        this.downgradeValue = null;
        this.checkCount = null;
        this.versions = null;
    }
}
