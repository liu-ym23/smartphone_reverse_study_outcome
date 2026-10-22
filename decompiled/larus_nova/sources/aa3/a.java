package aa3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Laa3/a;", "", "", "durationBeforeProductDetail", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "durationBeforeTop", "b", "onlyBorderDuration", "c", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("border_duration_before_product_detail")
    private final int durationBeforeProductDetail;

    @SerializedName("border_duration_before_top")
    private final int durationBeforeTop;

    @SerializedName("only_border_duration")
    private final int onlyBorderDuration;

    /* JADX INFO: renamed from: aa3.a$a, reason: collision with other inner class name */
    public static final class C0036a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.durationBeforeProductDetail == r101.durationBeforeProductDetail) goto L8;
        return false;
    L8:
        if (this.durationBeforeTop == r101.durationBeforeTop) goto L10;
        return false;
    L10:
        if (this.onlyBorderDuration == r101.onlyBorderDuration) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.durationBeforeProductDetail * 31) + this.durationBeforeTop) * 31) + this.onlyBorderDuration;
    }

    public final String toString() {
        return "MallCardAnimationDurationConfig(durationBeforeProductDetail=" + this.durationBeforeProductDetail + ", durationBeforeTop=" + this.durationBeforeTop + ", onlyBorderDuration=" + this.onlyBorderDuration + ")";
    }

    public final int a() {
        return this.durationBeforeProductDetail;
    }

    public final int b() {
        return this.durationBeforeTop;
    }

    public final int c() {
        return this.onlyBorderDuration;
    }

    public a(int r100) {
        this.durationBeforeProductDetail = 300;
        this.durationBeforeTop = 800;
        this.onlyBorderDuration = 3000;
    }
}
