package E4;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"LE4/f;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "resId", "I", "getResId", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.f, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardIcon {
    private final int resId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FloatCardIcon) && this.resId == ((FloatCardIcon) other).resId;
    }

    public int hashCode() {
        return Integer.hashCode(this.resId);
    }

    public String toString() {
        return "FloatCardIcon(resId=" + this.resId + ")";
    }
}
