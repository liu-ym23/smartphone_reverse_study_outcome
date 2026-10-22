package com.bytedance.android.shopping.anchorv4.dto.base;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J]\u0010\u001d\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Gradient;", "Ljava/io/Serializable;", "colors", "", "", "startPoint", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Point;", "endPoint", "locations", "", "startPosition", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Position;", "endPosition", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/base/Point;Lcom/bytedance/android/shopping/anchorv4/dto/base/Point;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/base/Position;Lcom/bytedance/android/shopping/anchorv4/dto/base/Position;)V", "getColors", "()Ljava/util/List;", "getEndPoint", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Point;", "getEndPosition", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Position;", "getLocations", "getStartPoint", "getStartPosition", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Gradient implements Serializable {

    @SerializedName("colors")
    private final List<String> colors;

    @SerializedName("end_point")
    private final Point endPoint;

    @SerializedName("end_position")
    private final Position endPosition;

    @SerializedName("locations")
    private final List<Float> locations;

    @SerializedName("start_point")
    private final Point startPoint;

    @SerializedName("start_position")
    private final Position startPosition;

    public Gradient() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Gradient copy$default(Gradient r100, List r101, Point r102, Point r103, List r104, Position r105, Position r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.colors;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.startPoint;
    L8:
        Point r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.endPoint;
    L11:
        Point r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.locations;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.startPosition;
    L17:
        Position r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.endPosition;
    L20:
        List r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final List<String> component1() {
        return this.colors;
    }

    public final Point component2() {
        return this.startPoint;
    }

    public final Point component3() {
        return this.endPoint;
    }

    public final List<Float> component4() {
        return this.locations;
    }

    public final Position component5() {
        return this.startPosition;
    }

    public final Position component6() {
        return this.endPosition;
    }

    public final Gradient copy(List<String> r100, Point r110, Point r111, List<Float> r112, Position r113, Position r114) {
        return new Gradient(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Gradient) == false) goto L18;
        Gradient r101 = (Gradient) r100;
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.startPoint, r101.startPoint) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.endPoint, r101.endPoint) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.locations, r101.locations) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.startPosition, r101.startPosition) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.endPosition, r101.endPosition) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.colors;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Point r104 = this.startPoint;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Point r107 = this.endPoint;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Float> r110 = this.locations;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Position r113 = this.startPosition;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Position r116 = this.endPosition;
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

    public String toString() {
        return "Gradient(colors=" + this.colors + ", startPoint=" + this.startPoint + ", endPoint=" + this.endPoint + ", locations=" + this.locations + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ")";
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final Point getEndPoint() {
        return this.endPoint;
    }

    public final Position getEndPosition() {
        return this.endPosition;
    }

    public final List<Float> getLocations() {
        return this.locations;
    }

    public final Point getStartPoint() {
        return this.startPoint;
    }

    public final Position getStartPosition() {
        return this.startPosition;
    }

    public Gradient(List<String> r100, Point r101, Point r102, List<Float> r103, Position r104, Position r105) {
        this.colors = r100;
        this.startPoint = r101;
        this.endPoint = r102;
        this.locations = r103;
        this.startPosition = r104;
        this.endPosition = r105;
    }

    public /* synthetic */ Gradient(List r100, Point r101, Point r102, List r103, Position r110, Position r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        List r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Point r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Point r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        Position r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Position r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
