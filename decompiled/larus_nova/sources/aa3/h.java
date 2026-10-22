package aa3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Laa3/h;", "", "", "", "filterParams", "Ljava/util/List;", "b", "()Ljava/util/List;", "besidesEnterMethod", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("besides_enter_method")
    private final List<String> besidesEnterMethod;

    @SerializedName("filter_params")
    private final List<String> filterParams;

    public static final class a {
    }

    static {
    }

    public h() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.filterParams, r101.filterParams) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.besidesEnterMethod, r101.besidesEnterMethod) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r100 = this.filterParams;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.besidesEnterMethod;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallTrafficParamsFilterConfig(filterParams=" + this.filterParams + ", besidesEnterMethod=" + this.besidesEnterMethod + ")";
    }

    public final List<String> a() {
        return this.besidesEnterMethod;
    }

    public final List<String> b() {
        return this.filterParams;
    }

    public h(Object r100) {
        this.filterParams = null;
        this.besidesEnterMethod = null;
    }
}
