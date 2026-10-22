package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "map", "Landroidx/collection/ObjectIntMap;", "", "keys", "", "[Ljava/lang/Object;", "keysStartIndex", "", "getIndex", "key", "getKey", "index", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap<Object> map;

    public static /* synthetic */ Unit a(int r100, int r101, MutableObjectIntMap r102, NearestRangeKeyIndexMap r103, IntervalList.Interval r104) {
        return lambda$2$lambda$1(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object r100) {
        ObjectIntMap<Object> r101 = this.map;
        int r102 = r101.findKeyIndex(r100);
        if (r102 >= 0) goto L7;
        return -1;
    L7:
        return r101.values[r102];
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int r100) {
        Object[] r101 = this.keys;
        int r102 = r100 - this.keysStartIndex;
        boolean r103 = false;
        if (r102 >= 0) goto L5;
    L7:
        if (r103 == true) goto L11;
        return null;
    L11:
        return r101[r102];
    L5:
        if (r102 >= r101.length) goto L7;
        r103 = true;
        goto L7
    }

    public NearestRangeKeyIndexMap(IntRange r100, LazyLayoutIntervalContent<?> r101) {
        IntervalList<Interval> r102 = r101.getIntervals();
        final int r103 = r100.getFirst();
        if (r103 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
    L8:
        final int r105 = Math.min(r100.getLast(), r102.getSize() - 1);
        if (r105 >= r103) goto L11;
        this.map = ObjectIntMapKt.emptyObjectIntMap();
        this.keys = new Object[0];
        this.keysStartIndex = 0;
        return;
    L11:
        int r106 = (r105 - r103) + 1;
        this.keys = new Object[r106];
        this.keysStartIndex = r103;
        final MutableObjectIntMap r107 = new MutableObjectIntMap(r106);
        r102.forEach(r103, r105, new k0(r103, r105, r107, this));
        this.map = r107;
        return;
    L5:
        r104 = false;
        goto L6
    }

    private static final Unit lambda$2$lambda$1(int r100, int r101, MutableObjectIntMap r102, NearestRangeKeyIndexMap r103, IntervalList.Interval r104) {
        Function1<Integer, Object> r105 = ((LazyLayoutIntervalContent.Interval) r104.getValue()).getKey();
        int r106 = Math.max(r100, r104.getStartIndex());
        int r107 = Math.min(r101, (r104.getStartIndex() + r104.getSize()) - 1);
        if (r106 > r107) goto L12;
    L4:
        if (r105 == null) goto L7;
        Object r108 = r105.invoke(Integer.valueOf(r106 - r104.getStartIndex()));
        if (r108 == null) goto L7;
    L8:
        r102.set(r108, r106);
        r103.keys[r106 - r103.keysStartIndex] = r108;
        if (r106 == r107) goto L12;
        r106 = r106 + 1;
    L7:
        r108 = Lazy_androidKt.getDefaultLazyLayoutKey(r106);
    L12:
        return Unit.INSTANCE;
    }
}
