package as6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Las6/b;", "", "", "left", "I", "getLeft", "()I", "right", "getRight", "horizontalMiddle", "getHorizontalMiddle", "top", "getTop", "bottom", "getBottom", "verticalMiddle", "getVerticalMiddle", "cardPadding", "getCardPadding", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("bottom")
    private final int bottom;

    @SerializedName("card_padding")
    private final int cardPadding;

    @SerializedName("horizontal_middle")
    private final int horizontalMiddle;

    @SerializedName("left")
    private final int left;

    @SerializedName("right")
    private final int right;

    @SerializedName("top")
    private final int top;

    @SerializedName("vertical_middle")
    private final int verticalMiddle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.right == r101.right) goto L15;
        return false;
    L15:
        if (this.horizontalMiddle == r101.horizontalMiddle) goto L18;
        return false;
    L18:
        if (this.top == r101.top) goto L21;
        return false;
    L21:
        if (this.bottom == r101.bottom) goto L24;
        return false;
    L24:
        if (this.verticalMiddle == r101.verticalMiddle) goto L27;
        return false;
    L27:
        if (this.cardPadding == r101.cardPadding) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.left * 31) + this.right) * 31) + this.horizontalMiddle) * 31) + this.top) * 31) + this.bottom) * 31) + this.verticalMiddle) * 31) + this.cardPadding;
    }

    public final String toString() {
        return "NearbyC2FeedGapConfig(left=" + this.left + ", right=" + this.right + ", horizontalMiddle=" + this.horizontalMiddle + ", top=" + this.top + ", bottom=" + this.bottom + ", verticalMiddle=" + this.verticalMiddle + ", cardPadding=" + this.cardPadding + ')';
    }

    public b() {
        this.left = 8;
        this.right = 8;
        this.horizontalMiddle = 5;
        this.top = 8;
        this.bottom = 0;
        this.verticalMiddle = 5;
        this.cardPadding = 8;
    }
}
