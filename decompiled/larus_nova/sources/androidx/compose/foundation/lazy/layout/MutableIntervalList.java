package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u000f0\u0015H\u0016J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0096\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0011\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\tH\u0082\bJ\u001a\u0010\u001b\u001a\u00020\u001c*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/MutableIntervalList;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/IntervalList;", "<init>", "()V", "intervals", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "value", "", "size", "getSize", "()I", "lastInterval", "addInterval", "", "(ILjava/lang/Object;)V", "forEach", "fromIndex", "toIndex", "block", "Lkotlin/Function1;", MonitorConstants.CONNECT_TYPE_GET, "index", "getIntervalForIndex", "itemIndex", "checkIndexBounds", "contains", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableIntervalList<T> implements IntervalList<T> {
    public static final int $stable = 8;
    private final MutableVector<IntervalList.Interval<T>> intervals;
    private IntervalList.Interval<? extends T> lastInterval;
    private int size;

    public MutableIntervalList() {
        this.intervals = new MutableVector(new IntervalList.Interval[16], 0);
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public int getSize() {
        return this.size;
    }

    private final void checkIndexBounds(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r100 + ", size " + getSize());
        return;
    L10:
        return;
    L5:
        if (r100 >= getSize()) goto L7;
        r101 = true;
        goto L7
    }

    private final IntervalList.Interval<T> getIntervalForIndex(int r100) {
        IntervalList.Interval<? extends T> r101 = this.lastInterval;
        if (r101 != null) goto L5;
    L7:
        MutableVector<IntervalList.Interval<T>> r102 = this.intervals;
        int r103 = IntervalListKt.access$binarySearch(r102, r100);
        IntervalList.Interval r104 = (IntervalList.Interval<? extends T>) r102.content[r103];
        this.lastInterval = r104;
        return r104;
    L5:
        if (contains(r101, r100) == false) goto L7;
        return r101;
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public IntervalList.Interval<T> get(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r100 + ", size " + getSize());
    L10:
        return getIntervalForIndex(r100);
    L5:
        if (r100 >= getSize()) goto L7;
        r101 = true;
        goto L7
    }

    private final boolean contains(IntervalList.Interval<? extends T> r100, int r101) {
        int r102 = r100.getStartIndex();
        if (r101 >= (r100.getStartIndex() + r100.getSize())) goto L7;
        if (r102 > r101) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public final void addInterval(int r100, T r101) {
        if (r100 < 0) goto L4;
        boolean r102 = true;
    L5:
        if (r102 == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("size should be >=0");
    L7:
        if (r100 != 0) goto L9;
        return;
    L9:
        IntervalList.Interval<T> r103 = new IntervalList.Interval(getSize(), r100, r101);
        this.size = getSize() + r100;
        this.intervals.add(r103);
        return;
    L4:
        r102 = false;
        goto L5
    }

    @Override // androidx.compose.foundation.lazy.layout.IntervalList
    public void forEach(int r100, int r101, Function1<? super IntervalList.Interval<? extends T>, Unit> r102) {
        boolean r103 = false;
        if (r100 >= 0) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == true) goto L11;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r100 + ", size " + getSize());
    L11:
        if (r101 >= 0) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == true) goto L18;
        InlineClassHelperKt.throwIndexOutOfBoundsException("Index " + r101 + ", size " + getSize());
    L18:
        if (r101 < r100) goto L20;
        r103 = true;
    L20:
        if (r103 == true) goto L22;
        InlineClassHelperKt.throwIllegalArgumentException("toIndex (" + r101 + ") should be not smaller than fromIndex (" + r100 + ')');
    L22:
        int r106 = IntervalListKt.access$binarySearch(this.intervals, r100);
        int r107 = this.intervals.content[r106].getStartIndex();
    L23:
        if (r107 > r101) goto L25;
        IntervalList.Interval<T> r108 = this.intervals.content[r106];
        r102.invoke(r108);
        r107 = r107 + r108.getSize();
        r106 = r106 + 1;
        goto L23
    L25:
        return;
    L13:
        if (r101 >= getSize()) goto L15;
        r105 = true;
        goto L16
    L5:
        if (r100 >= getSize()) goto L7;
        r104 = true;
        goto L9
    }
}
