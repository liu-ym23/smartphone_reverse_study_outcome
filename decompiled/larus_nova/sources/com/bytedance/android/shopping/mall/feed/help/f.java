package com.bytedance.android.shopping.mall.feed.help;

import com.bytedance.android.shopping.api.mall.common.feed.help.ECMallGulPrefetch;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/f;", "", "", "", "pageName", "Ljava/util/List;", "getPageName", "()Ljava/util/List;", "afterWindVanePage", "getAfterWindVanePage", "", "useFetchType", "Ljava/lang/Integer;", "getUseFetchType", "()Ljava/lang/Integer;", "unExposeSkew", "b", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("after_wind_vane_page")
    private final List<String> afterWindVanePage;

    @SerializedName("page_name")
    private final List<String> pageName;

    @SerializedName("un_expose_skew")
    private final Integer unExposeSkew;

    @SerializedName("use_fetch_type")
    private final Integer useFetchType;

    public static final class a {
    }

    static {
    }

    public f() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.afterWindVanePage, r101.afterWindVanePage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.useFetchType, r101.useFetchType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unExposeSkew, r101.unExposeSkew) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.pageName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.afterWindVanePage;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.useFetchType;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.unExposeSkew;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "FetchGYLByBehaviorConfig(pageName=" + this.pageName + ", afterWindVanePage=" + this.afterWindVanePage + ", useFetchType=" + this.useFetchType + ", unExposeSkew=" + this.unExposeSkew + ")";
    }

    public final Integer b() {
        return this.unExposeSkew;
    }

    public f(Object r100) {
        this.pageName = null;
        this.afterWindVanePage = null;
        this.useFetchType = null;
        this.unExposeSkew = 2;
    }

    public final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Lazy r101 = ECMallGulPrefetch.f170248h;
        Integer r102 = ECMallGulPrefetch.Companion.a().e();
        if (r102 != null) goto L6;
    L8:
        List<String> r103 = this.pageName;
        if (r103 != null) goto L11;
    L13:
        return 0;
    L11:
        if (r103.contains(r100) != true) goto L13;
        return 1;
    L6:
        if (r102.intValue() != 1) goto L8;
        return 0;
    }
}
