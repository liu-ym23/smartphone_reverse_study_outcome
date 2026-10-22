package bo6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lbo6/d;", "", "", "pendantWidth", "I", "f", "()I", "pendantHeight", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "pendantPositionRightX", "d", "pendantPositionBottomY", "b", "pendantPositionLeftX", "c", "pendantPositionTopY", "e", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("life_pendant_height")
    private final int pendantHeight;

    @SerializedName("life_pendant_position_bottom_y")
    private final int pendantPositionBottomY;

    @SerializedName("life_pendant_position_left_x")
    private final int pendantPositionLeftX;

    @SerializedName("life_pendant_position_right_x")
    private final int pendantPositionRightX;

    @SerializedName("life_pendant_position_top_y")
    private final int pendantPositionTopY;

    @SerializedName("life_pendant_width")
    private final int pendantWidth;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.pendantWidth == r101.pendantWidth) goto L12;
        return false;
    L12:
        if (this.pendantHeight == r101.pendantHeight) goto L15;
        return false;
    L15:
        if (this.pendantPositionRightX == r101.pendantPositionRightX) goto L18;
        return false;
    L18:
        if (this.pendantPositionBottomY == r101.pendantPositionBottomY) goto L21;
        return false;
    L21:
        if (this.pendantPositionLeftX == r101.pendantPositionLeftX) goto L24;
        return false;
    L24:
        if (this.pendantPositionTopY == r101.pendantPositionTopY) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.pendantWidth * 31) + this.pendantHeight) * 31) + this.pendantPositionRightX) * 31) + this.pendantPositionBottomY) * 31) + this.pendantPositionLeftX) * 31) + this.pendantPositionTopY;
    }

    public final String toString() {
        return "LifePendantInfo(pendantWidth=" + this.pendantWidth + ", pendantHeight=" + this.pendantHeight + ", pendantPositionRightX=" + this.pendantPositionRightX + ", pendantPositionBottomY=" + this.pendantPositionBottomY + ", pendantPositionLeftX=" + this.pendantPositionLeftX + ", pendantPositionTopY=" + this.pendantPositionTopY + ')';
    }

    public d() {
        this.pendantWidth = 0;
        this.pendantHeight = 0;
        this.pendantPositionRightX = -1;
        this.pendantPositionBottomY = -1;
        this.pendantPositionLeftX = -1;
        this.pendantPositionTopY = -1;
    }

    public final int a() {
        return this.pendantHeight;
    }

    public final int b() {
        return this.pendantPositionBottomY;
    }

    public final int c() {
        return this.pendantPositionLeftX;
    }

    public final int d() {
        return this.pendantPositionRightX;
    }

    public final int e() {
        return this.pendantPositionTopY;
    }

    public final int f() {
        return this.pendantWidth;
    }
}
