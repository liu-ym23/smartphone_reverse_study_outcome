package ar6;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lar6/b;", "", "", "", "borderRadius", "Ljava/util/List;", "getBorderRadius", "()Ljava/util/List;", "borderTopLeftRadius", "Ljava/lang/Float;", "getBorderTopLeftRadius", "()Ljava/lang/Float;", "borderTopRightRadius", "getBorderTopRightRadius", "borderBottomRightRadius", "getBorderBottomRightRadius", "borderBottomLeftRadius", "getBorderBottomLeftRadius", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("border_bottom_left_radius")
    private final Float borderBottomLeftRadius;

    @SerializedName("border_bottom_right_radius")
    private final Float borderBottomRightRadius;

    @SerializedName("border_radius")
    private final List<Float> borderRadius;

    @SerializedName("border_top_left_radius")
    private final Float borderTopLeftRadius;

    @SerializedName("border_top_right_radius")
    private final Float borderTopRightRadius;

    public b() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.borderRadius, r101.borderRadius) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderTopLeftRadius, r101.borderTopLeftRadius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.borderTopRightRadius, r101.borderTopRightRadius) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.borderBottomRightRadius, r101.borderBottomRightRadius) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.borderBottomLeftRadius, r101.borderBottomLeftRadius) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<Float> r100 = this.borderRadius;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Float r104 = this.borderTopLeftRadius;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.borderTopRightRadius;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Float r110 = this.borderBottomRightRadius;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.borderBottomLeftRadius;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "StdBorderVO(borderRadius=" + this.borderRadius + ", borderTopLeftRadius=" + this.borderTopLeftRadius + ", borderTopRightRadius=" + this.borderTopRightRadius + ", borderBottomRightRadius=" + this.borderBottomRightRadius + ", borderBottomLeftRadius=" + this.borderBottomLeftRadius + ')';
    }

    public b(List r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.borderRadius = r100;
        this.borderTopLeftRadius = null;
        this.borderTopRightRadius = null;
        this.borderBottomRightRadius = null;
        this.borderBottomLeftRadius = null;
    }
}
