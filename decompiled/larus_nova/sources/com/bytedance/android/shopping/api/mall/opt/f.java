package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/f;", "", "", "homepageCount", "Ljava/lang/Integer;", "getHomepageCount", "()Ljava/lang/Integer;", "homepagePreload", "c", "feedCount", "getFeedCount", "feedPreload", "b", "allowAutoLoadCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("allow_auto_load_from_new_data")
    private final Integer allowAutoLoadCount;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_FEED_COUNT)
    private final Integer feedCount;

    @SerializedName("feed_preload")
    private final Integer feedPreload;

    @SerializedName("homepage_count")
    private final Integer homepageCount;

    @SerializedName("homepage_preload")
    private final Integer homepagePreload;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L16;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.homepageCount, r101.homepageCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.homepagePreload, r101.homepagePreload) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedCount, r101.feedCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedPreload, r101.feedPreload) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.allowAutoLoadCount, r101.allowAutoLoadCount) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.homepageCount;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.homepagePreload;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.feedCount;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.feedPreload;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.allowAutoLoadCount;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "RequestCountAndPreloadCount(homepageCount=" + this.homepageCount + ", homepagePreload=" + this.homepagePreload + ", feedCount=" + this.feedCount + ", feedPreload=" + this.feedPreload + ", allowAutoLoadCount=" + this.allowAutoLoadCount + ")";
    }

    public f() {
        this.homepageCount = null;
        this.homepagePreload = null;
        this.feedCount = null;
        this.feedPreload = null;
        this.allowAutoLoadCount = null;
    }

    public final Integer a() {
        return this.allowAutoLoadCount;
    }

    public final Integer b() {
        return this.feedPreload;
    }

    public final Integer c() {
        return this.homepagePreload;
    }
}
