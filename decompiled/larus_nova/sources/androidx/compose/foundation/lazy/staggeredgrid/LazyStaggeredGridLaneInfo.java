package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0001\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0006\u0010\u0013\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0015\u001a\u00020\fJ\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005J\u001a\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", "<init>", "()V", "anchor", "", "lanes", "", "spannedItems", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "setLane", "", "itemIndex", "lane", "getLane", "assignedToLane", "", "targetLane", "upperBound", "lowerBound", BasicTestActionHandler.TEST_ACTION_RESET, "findPreviousItemIndex", "findNextItemIndex", "ensureValidIndex", "requestedIndex", "setGaps", "gaps", "getGaps", "ensureCapacity", "capacity", "newOffset", "SpannedItem", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridLaneInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int LaneFullSpan = -2;
    public static final int LaneUnset = -1;
    private static final int MaxCapacity = 131072;
    private int anchor;
    private int[] lanes;
    private final ArrayDeque<SpannedItem> spannedItems;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$Companion;", "", "<init>", "()V", "MaxCapacity", "", "LaneUnset", "LaneFullSpan", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "<init>", "(I[I)V", "getIndex", "()I", "getGaps", "()[I", "setGaps", "([I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SpannedItem {
        private int[] gaps;
        private final int index;

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] r100) {
            this.gaps = r100;
        }

        public SpannedItem(int r100, int[] r101) {
            this.index = r100;
            this.gaps = r101;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public final void reset() {
        ArraysKt.fill$default(this.lanes, 0, 0, 0, 6, null);
        this.spannedItems.clear();
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }

    public LazyStaggeredGridLaneInfo() {
        this.lanes = new int[16];
        this.spannedItems = new ArrayDeque();
    }

    public final int lowerBound() {
        return this.anchor;
    }

    public final void ensureValidIndex(int r100) {
        int r101 = this.anchor;
        int r102 = r100 - r101;
        if (r102 < 0) goto L6;
        if (r102 >= 131072) goto L6;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        ensureCapacity$default(this, r102 + 1, 0, 2, null);
    L24:
        if ((!this.spannedItems.isEmpty()) == false) goto L29;
        if (this.spannedItems.first().getIndex() >= lowerBound()) goto L29;
        this.spannedItems.removeFirst();
    L29:
        if ((!this.spannedItems.isEmpty()) == false) goto L33;
        if (this.spannedItems.last().getIndex() <= upperBound()) goto L40;
        this.spannedItems.removeLast();
        goto L29
    L40:
        return;
    L33:
        return;
    L10:
        int r104 = Math.max(r100 - (this.lanes.length / 2), 0);
        this.anchor = r104;
        int r105 = r104 - r101;
        if (r105 < 0) goto L16;
        int[] r106 = this.lanes;
        if (r105 >= r106.length) goto L15;
        ArraysKt.copyInto(r106, r106, 0, r105, r106.length);
    L15:
        int[] r107 = this.lanes;
        ArraysKt.fill(r107, 0, Math.max(0, r107.length - r105), this.lanes.length);
        goto L24
    L16:
        int r108 = -r105;
        int[] r109 = this.lanes;
        if ((r109.length + r108) >= 131072) goto L20;
        ensureCapacity((r109.length + r108) + 1, r108);
        goto L24
    L20:
        if (r108 >= r109.length) goto L22;
        ArraysKt.copyInto(r109, r109, r108, 0, r109.length - r108);
    L22:
        int[] r110 = this.lanes;
        ArraysKt.fill(r110, 0, 0, Math.min(r110.length, r108));
    L6:
        r103 = false;
        goto L8
    }

    public final int[] getGaps(int r100) {
        ArrayDeque<SpannedItem> r101 = this.spannedItems;
        final Integer r102 = Integer.valueOf(r100);
        int r103 = CollectionsKt.binarySearch(r101, 0, r101.size(), new LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1(r102));
        SpannedItem r104 = (SpannedItem) CollectionsKt.getOrNull(this.spannedItems, r103);
        if (r104 != null) goto L7;
        return null;
    L7:
        return r104.getGaps();
    }

    public final int getLane(int r100) {
        if (r100 >= lowerBound()) goto L5;
        return -1;
    L5:
        if (r100 < upperBound()) goto L8;
        return -1;
    L8:
        return this.lanes[r100 - this.anchor] - 1;
    }

    private final void ensureCapacity(int r100, int r110) {
        if (r100 > 131072) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Requested item capacity " + r100 + " is larger than max supported: 131072!");
    L8:
        int[] r102 = this.lanes;
        if (r102.length >= r100) goto L16;
        int r103 = r102.length;
    L11:
        if (r103 >= r100) goto L13;
        r103 = r103 * 2;
        goto L11
    L13:
        this.lanes = ArraysKt.copyInto$default(this.lanes, new int[r103], r110, 0, 0, 12, null);
        return;
    L16:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final boolean assignedToLane(int r100, int r101) {
        int r102 = getLane(r100);
        if (r102 != r101) goto L5;
    L10:
        return true;
    L5:
        if (r102 == (-1)) goto L10;
        if (r102 == (-2)) goto L10;
        return false;
    }

    public final int findNextItemIndex(int r100, int r101) {
        int r102 = r100 + 1;
        int r103 = upperBound();
    L3:
        if (r102 >= r103) goto L9;
        if (assignedToLane(r102, r101) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L9:
        return upperBound();
    }

    public final int findPreviousItemIndex(int r100, int r101) {
    L3:
        r100 = r100 - 1;
        if ((-1) >= r100) goto L9;
        if (assignedToLane(r100, r101) == false) goto L3;
        return r100;
    L9:
        return -1;
    }

    public final void setGaps(int r100, int[] r101) {
        ArrayDeque<SpannedItem> r102 = this.spannedItems;
        final Integer r103 = Integer.valueOf(r100);
        int r104 = CollectionsKt.binarySearch(r102, 0, r102.size(), new LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1(r103));
        if (r104 >= 0) goto L7;
        if (r101 != null) goto L6;
        return;
    L6:
        ArrayDeque<SpannedItem> r105 = this.spannedItems;
        r105.add(-(r104 + 1), new SpannedItem(r100, r101));
        return;
    L7:
        if (r101 != null) goto L9;
        this.spannedItems.remove(r104);
        return;
    L9:
        this.spannedItems.get(r104).setGaps(r101);
    }

    public final void setLane(int r100, int r101) {
        if (r100 < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Negative lanes are not supported");
    L8:
        ensureValidIndex(r100);
        this.lanes[r100 - this.anchor] = r101 + 1;
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridLaneInfo r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.ensureCapacity(r101, r102);
    }
}
