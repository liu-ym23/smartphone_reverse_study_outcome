package as6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Las6/c;", "", "", "left", "I", "getLeft", "()I", "right", "getRight", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("left")
    private final int left;

    @SerializedName("right")
    private final int right;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.left == r101.left) goto L12;
        return false;
    L12:
        if (this.right == r101.right) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.left * 31) + this.right;
    }

    public final String toString() {
        return "NearbyC2SearchGapConfig(left=" + this.left + ", right=" + this.right + ')';
    }

    public c() {
        this.left = 0;
        this.right = 0;
    }
}
