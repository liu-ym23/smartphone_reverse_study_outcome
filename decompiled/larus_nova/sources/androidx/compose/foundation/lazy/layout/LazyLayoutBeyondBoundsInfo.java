package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "", "<init>", "()V", "beyondBoundsItems", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "addInterval", "start", "", "end", "removeInterval", "", VideoThumbInfo.KEY_INTERVAL, "hasIntervals", "", "getStart", "()I", "getEnd", "Interval", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsInfo {
    public static final int $stable = 0;
    private final MutableVector<Interval> beyondBoundsItems;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Interval {
        public static final int $stable = 0;
        private final int end;
        private final int start;

        public static /* synthetic */ Interval copy$default(Interval r100, int r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.start;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.end;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final Interval copy(int r100, int r101) {
            return new Interval(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Interval) == true) goto L8;
            return false;
        L8:
            Interval r101 = (Interval) r100;
            if (this.start == r101.start) goto L12;
            return false;
        L12:
            if (this.end == r101.end) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public Interval(int r100, int r101) {
            this.start = r100;
            this.end = r101;
            boolean r102 = true;
            if (r100 < 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("negative start index");
        L8:
            if (r101 >= r100) goto L11;
            r102 = false;
        L11:
            if (r102 == true) goto L14;
            InlineClassHelperKt.throwIllegalArgumentException("end index greater than start");
            return;
        L14:
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
        $stable = MutableVector.$stable;
    }

    public final int getEnd() {
        int r100 = this.beyondBoundsItems.first().getEnd();
        MutableVector<Interval> r101 = this.beyondBoundsItems;
        Interval[] r102 = r101.content;
        int r103 = r101.getSize();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        Interval r105 = r102[r104];
        if (r105.getEnd() <= r100) goto L7;
        r100 = r105.getEnd();
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        return r100;
    }

    public final int getStart() {
        int r100 = this.beyondBoundsItems.first().getStart();
        MutableVector<Interval> r101 = this.beyondBoundsItems;
        Interval[] r102 = r101.content;
        int r103 = r101.getSize();
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L8;
        Interval r106 = r102[r105];
        if (r106.getStart() >= r100) goto L7;
        r100 = r106.getStart();
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        if (r100 < 0) goto L10;
        r104 = true;
    L10:
        if (r104 == true) goto L12;
        InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
    L12:
        return r100;
    }

    public final boolean hasIntervals() {
        if (this.beyondBoundsItems.getSize() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LazyLayoutBeyondBoundsInfo() {
        this.beyondBoundsItems = new MutableVector(new Interval[16], 0);
    }

    public final void removeInterval(Interval r100) {
        this.beyondBoundsItems.remove(r100);
    }

    public final Interval addInterval(int r100, int r101) {
        Interval r102 = new Interval(r100, r101);
        this.beyondBoundsItems.add(r102);
        return r102;
    }
}
