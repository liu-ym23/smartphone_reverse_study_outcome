package E4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"LE4/b;", "", "", "color", "", "widthDp", "cornerRadiusDp", "<init>", "(IFF)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "F", "c", "()F", Const.INTENT_KEY_PKGNAME, "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: E4.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class FloatCardBadgeBorder {
    private final int color;
    private final float cornerRadiusDp;
    private final float widthDp;

    public FloatCardBadgeBorder(int i10, float f10, float f11) {
        this.color = i10;
        this.widthDp = f10;
        this.cornerRadiusDp = f11;
    }

    /* renamed from: a, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: b, reason: from getter */
    public final float getCornerRadiusDp() {
        return this.cornerRadiusDp;
    }

    /* renamed from: c, reason: from getter */
    public final float getWidthDp() {
        return this.widthDp;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FloatCardBadgeBorder)) {
            return false;
        }
        FloatCardBadgeBorder floatCardBadgeBorder = (FloatCardBadgeBorder) other;
        return this.color == floatCardBadgeBorder.color && Float.compare(this.widthDp, floatCardBadgeBorder.widthDp) == 0 && Float.compare(this.cornerRadiusDp, floatCardBadgeBorder.cornerRadiusDp) == 0;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.color) * 31) + Float.hashCode(this.widthDp)) * 31) + Float.hashCode(this.cornerRadiusDp);
    }

    public String toString() {
        return "FloatCardBadgeBorder(color=" + this.color + ", widthDp=" + this.widthDp + ", cornerRadiusDp=" + this.cornerRadiusDp + ")";
    }

    public /* synthetic */ FloatCardBadgeBorder(int i10, float f10, float f11, int i11, kotlin.jvm.internal.i iVar) {
        this(i10, (i11 & 2) != 0 ? 1.0f : f10, (i11 & 4) != 0 ? 4.0f : f11);
    }
}
