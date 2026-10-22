package androidx.compose.ui.input.pointer.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/input/pointer/util/DataPointAtTime;", "", "time", "", "dataPoint", "", "<init>", "(JF)V", "getTime", "()J", "setTime", "(J)V", "getDataPoint", "()F", "setDataPoint", "(F)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DataPointAtTime {
    public static final int $stable = 8;
    private float dataPoint;
    private long time;

    public static /* synthetic */ DataPointAtTime copy$default(DataPointAtTime r100, long r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.time;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.dataPoint;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.time;
    }

    public final float component2() {
        return this.dataPoint;
    }

    public final DataPointAtTime copy(long r100, float r101) {
        return new DataPointAtTime(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DataPointAtTime) == true) goto L8;
        return false;
    L8:
        DataPointAtTime r101 = (DataPointAtTime) r100;
        if (this.time == r101.time) goto L12;
        return false;
    L12:
        if (Float.compare(this.dataPoint, r101.dataPoint) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.time;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + Float.floatToIntBits(this.dataPoint);
    }

    public String toString() {
        return "DataPointAtTime(time=" + this.time + ", dataPoint=" + this.dataPoint + ')';
    }

    public final float getDataPoint() {
        return this.dataPoint;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setDataPoint(float r100) {
        this.dataPoint = r100;
    }

    public final void setTime(long r100) {
        this.time = r100;
    }

    public DataPointAtTime(long r100, float r101) {
        this.time = r100;
        this.dataPoint = r101;
    }
}
