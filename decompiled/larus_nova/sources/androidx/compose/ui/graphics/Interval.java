package androidx.compose.ui.graphics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0011\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/graphics/Interval;", ExifInterface.GPS_DIRECTION_TRUE, "", "start", "", "end", "data", "<init>", "(FFLjava/lang/Object;)V", "getStart", "()F", "getEnd", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "overlaps", "", "other", "contains", "value", "equals", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Interval<T> {
    private final T data;
    private final float end;
    private final float start;

    public int hashCode() {
        int r100 = ((Float.floatToIntBits(this.start) * 31) + Float.floatToIntBits(this.end)) * 31;
        T r101 = this.data;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "Interval(start=" + this.start + ", end=" + this.end + ", data=" + this.data + ')';
    }

    public final T getData() {
        return this.data;
    }

    public final float getEnd() {
        return this.end;
    }

    public final float getStart() {
        return this.start;
    }

    public final boolean contains(float r100) {
        float r101 = this.start;
        if (r100 <= this.end) goto L5;
        return false;
    L5:
        if (r101 > r100) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L26;
        Interval r101 = (Interval) r100;
        if (this.start != r101.start) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L17;
        return false;
    L17:
        if (this.end != r101.end) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L25;
        return false;
    L25:
        return true;
    L19:
        r103 = false;
        goto L20
    L13:
        r102 = false;
        goto L14
    }

    public final boolean overlaps(Interval<T> r100) {
        if (this.start <= r100.end) goto L5;
    L7:
        return false;
    L5:
        if (this.end < r100.start) goto L7;
        return true;
    }

    public final boolean overlaps(float r100, float r101) {
        if (this.start <= r101) goto L5;
    L7:
        return false;
    L5:
        if (this.end < r100) goto L7;
        return true;
    }

    public Interval(float r100, float r101, T r102) {
        this.start = r100;
        this.end = r101;
        this.data = r102;
    }

    public /* synthetic */ Interval(float r100, float r101, Object r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
