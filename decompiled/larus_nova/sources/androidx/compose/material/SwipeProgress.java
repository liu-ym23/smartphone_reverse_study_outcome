package androidx.compose.material;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Landroidx/compose/material/SwipeProgress;", ExifInterface.GPS_DIRECTION_TRUE, "", "from", RemoteMessageConst.TO, "fraction", "", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "getFraction", "()F", "equals", "", "other", "hashCode", "", "toString", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SwipeProgress<T> {
    public static final int $stable = 0;
    private final float fraction;
    private final T from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final T f7849to;

    public int hashCode() {
        T r100 = this.from;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f7849to;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.fraction);
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SwipeProgress(from=" + this.from + ", to=" + this.f7849to + ", fraction=" + this.fraction + ')';
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.f7849to;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SwipeProgress) == true) goto L8;
        return false;
    L8:
        SwipeProgress r101 = (SwipeProgress) r100;
        if (Intrinsics.areEqual(this.from, r101.from) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7849to, r101.f7849to) == true) goto L15;
        return false;
    L15:
        if (this.fraction != r101.fraction) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r102 = false;
        goto L18
    }

    public SwipeProgress(T r100, T r101, float r102) {
        this.from = r100;
        this.f7849to = r101;
        this.fraction = r102;
    }
}
