package aa3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Laa3/b;", "", "", "productMaxFilters", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "liveMaxFilters", "c", "productFiltersTimestamp", "d", "liveFiltersTimestamp", "b", "", "activeRefreshEnable", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("active_refresh_enable")
    private final Boolean activeRefreshEnable;

    @SerializedName("live_filters_timestamp")
    private final Integer liveFiltersTimestamp;

    @SerializedName("live_max_filters")
    private final Integer liveMaxFilters;

    @SerializedName("product_filters_timestamp")
    private final Integer productFiltersTimestamp;

    @SerializedName("product_max_filters")
    private final Integer productMaxFilters;

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
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.productMaxFilters, r101.productMaxFilters) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.liveMaxFilters, r101.liveMaxFilters) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productFiltersTimestamp, r101.productFiltersTimestamp) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveFiltersTimestamp, r101.liveFiltersTimestamp) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.activeRefreshEnable, r101.activeRefreshEnable) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.productMaxFilters;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.liveMaxFilters;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.productFiltersTimestamp;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.liveFiltersTimestamp;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.activeRefreshEnable;
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
        return "MallFeedImpressionConfig(productMaxFilters=" + this.productMaxFilters + ", liveMaxFilters=" + this.liveMaxFilters + ", productFiltersTimestamp=" + this.productFiltersTimestamp + ", liveFiltersTimestamp=" + this.liveFiltersTimestamp + ", activeRefreshEnable=" + this.activeRefreshEnable + ")";
    }

    public final Boolean a() {
        return this.activeRefreshEnable;
    }

    public final Integer b() {
        return this.liveFiltersTimestamp;
    }

    public final Integer c() {
        return this.liveMaxFilters;
    }

    public final Integer d() {
        return this.productFiltersTimestamp;
    }

    public final Integer e() {
        return this.productMaxFilters;
    }

    public b(int r100) {
        this.productMaxFilters = null;
        this.liveMaxFilters = null;
        this.productFiltersTimestamp = null;
        this.liveFiltersTimestamp = null;
        this.activeRefreshEnable = null;
    }
}
