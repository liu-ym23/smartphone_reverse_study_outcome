package androidx.compose.foundation.lazy.staggeredgrid;

import D7.p;
import D7.q;
import D7.v;
import H4.o;
import N9.j;
import S7.k;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\tJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0003J\u001d\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "", AppAgent.CONSTRUCT, "()V", "", "capacity", "newOffset", "LC7/r;", "ensureCapacity", "(II)V", "itemIndex", "lane", "setLane", "getLane", "(I)I", "targetLane", "", "assignedToLane", "(II)Z", "upperBound", "()I", "lowerBound", "reset", "findPreviousItemIndex", "(II)I", "findNextItemIndex", "requestedIndex", "ensureValidIndex", "(I)V", "", "gaps", "setGaps", "(I[I)V", "getGaps", "(I)[I", "anchor", "I", "lanes", "[I", "LD7/p;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "spannedItems", "LD7/p;", "Companion", "SpannedItem", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridLaneInfo {
    public static final int FullSpan = -2;
    private static final int MaxCapacity = 131072;
    public static final int Unset = -1;
    private int anchor;
    private int[] lanes = new int[16];
    private final p spannedItems = new p();
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo$SpannedItem;", "", "index", "", "gaps", "", "(I[I)V", "getGaps", "()[I", "setGaps", "([I)V", "getIndex", "()I", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SpannedItem {
        private int[] gaps;
        private final int index;

        public SpannedItem(int i, int[] iArr) {
            this.index = i;
            this.gaps = iArr;
        }

        public final int[] getGaps() {
            return this.gaps;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setGaps(int[] iArr) {
            this.gaps = iArr;
        }
    }

    private final void ensureCapacity(int capacity, int newOffset) {
        if (capacity > 131072) {
            throw new IllegalArgumentException(a.i(capacity, "Requested item capacity ", " is larger than max supported: 131072!").toString());
        }
        int[] iArr = this.lanes;
        if (iArr.length < capacity) {
            int length = iArr.length;
            while (length < capacity) {
                length *= 2;
            }
            int[] iArr2 = new int[length];
            q.Y(newOffset, 0, this.lanes, iArr2, 12);
            this.lanes = iArr2;
        }
    }

    public static /* synthetic */ void ensureCapacity$default(LazyStaggeredGridLaneInfo lazyStaggeredGridLaneInfo, int i, int i6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i6 = 0;
        }
        lazyStaggeredGridLaneInfo.ensureCapacity(i, i6);
    }

    public final boolean assignedToLane(int itemIndex, int targetLane) {
        int lane = getLane(itemIndex);
        return lane == targetLane || lane == -1 || lane == -2;
    }

    public final void ensureValidIndex(int requestedIndex) {
        int i = this.anchor;
        int i6 = requestedIndex - i;
        if (i6 < 0 || i6 >= 131072) {
            int iMax = Math.max(requestedIndex - (this.lanes.length / 2), 0);
            this.anchor = iMax;
            int i10 = iMax - i;
            if (i10 >= 0) {
                int[] iArr = this.lanes;
                if (i10 < iArr.length) {
                    q.R(0, i10, iArr, iArr, iArr.length);
                }
                int[] iArr2 = this.lanes;
                Arrays.fill(iArr2, Math.max(0, iArr2.length - i10), this.lanes.length, 0);
            } else {
                int i11 = -i10;
                int[] iArr3 = this.lanes;
                if (iArr3.length + i11 < 131072) {
                    ensureCapacity(iArr3.length + i11 + 1, i11);
                } else {
                    if (i11 < iArr3.length) {
                        q.R(i11, 0, iArr3, iArr3, iArr3.length - i11);
                    }
                    int[] iArr4 = this.lanes;
                    Arrays.fill(iArr4, 0, Math.min(iArr4.length, i11), 0);
                }
            }
        } else {
            ensureCapacity$default(this, i6 + 1, 0, 2, null);
        }
        while (!this.spannedItems.isEmpty() && ((SpannedItem) this.spannedItems.first()).getIndex() < getAnchor()) {
            this.spannedItems.removeFirst();
        }
        while (!this.spannedItems.isEmpty() && ((SpannedItem) this.spannedItems.last()).getIndex() > upperBound()) {
            this.spannedItems.removeLast();
        }
    }

    public final int findNextItemIndex(int itemIndex, int targetLane) {
        int iUpperBound = upperBound();
        for (int i = itemIndex + 1; i < iUpperBound; i++) {
            if (assignedToLane(i, targetLane)) {
                return i;
            }
        }
        return upperBound();
    }

    public final int findPreviousItemIndex(int itemIndex, int targetLane) {
        do {
            itemIndex--;
            if (-1 >= itemIndex) {
                return -1;
            }
        } while (!assignedToLane(itemIndex, targetLane));
        return itemIndex;
    }

    public final int[] getGaps(int itemIndex) {
        p pVar = this.spannedItems;
        final Integer numValueOf = Integer.valueOf(itemIndex);
        SpannedItem spannedItem = (SpannedItem) v.D0(o.o(pVar, pVar.size(), new k() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$getGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Integer invoke(LazyStaggeredGridLaneInfo.SpannedItem spannedItem2) {
                return Integer.valueOf(j.m(Integer.valueOf(spannedItem2.getIndex()), numValueOf));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((LazyStaggeredGridLaneInfo.SpannedItem) obj);
            }
        }), this.spannedItems);
        if (spannedItem != null) {
            return spannedItem.getGaps();
        }
        return null;
    }

    public final int getLane(int itemIndex) {
        if (itemIndex < getAnchor() || itemIndex >= upperBound()) {
            return -1;
        }
        return this.lanes[itemIndex - this.anchor] - 1;
    }

    /* renamed from: lowerBound, reason: from getter */
    public final int getAnchor() {
        return this.anchor;
    }

    public final void reset() {
        q.g0(this.lanes, 0, 0, 6);
        this.spannedItems.clear();
    }

    public final void setGaps(int itemIndex, int[] gaps) {
        p pVar = this.spannedItems;
        final Integer numValueOf = Integer.valueOf(itemIndex);
        int iO = o.o(pVar, pVar.size(), new k() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo$setGaps$$inlined$binarySearchBy$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final Integer invoke(LazyStaggeredGridLaneInfo.SpannedItem spannedItem) {
                return Integer.valueOf(j.m(Integer.valueOf(spannedItem.getIndex()), numValueOf));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((LazyStaggeredGridLaneInfo.SpannedItem) obj);
            }
        });
        if (iO < 0) {
            if (gaps == null) {
                return;
            }
            this.spannedItems.add(-(iO + 1), new SpannedItem(itemIndex, gaps));
            return;
        }
        if (gaps == null) {
            this.spannedItems.remove(iO);
        } else {
            ((SpannedItem) this.spannedItems.get(iO)).setGaps(gaps);
        }
    }

    public final void setLane(int itemIndex, int lane) {
        if (itemIndex < 0) {
            throw new IllegalArgumentException("Negative lanes are not supported");
        }
        ensureValidIndex(itemIndex);
        this.lanes[itemIndex - this.anchor] = lane + 1;
    }

    public final int upperBound() {
        return this.anchor + this.lanes.length;
    }
}
