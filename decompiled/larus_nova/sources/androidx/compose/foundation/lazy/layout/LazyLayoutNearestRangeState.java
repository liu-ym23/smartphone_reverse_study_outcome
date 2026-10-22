package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "Landroidx/compose/runtime/State;", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "<init>", "(III)V", "<set-?>", "value", "getValue", "()Lkotlin/ranges/IntRange;", "setValue", "(Lkotlin/ranges/IntRange;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "lastFirstVisibleItem", "update", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutNearestRangeState implements State<IntRange> {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;
    private final MutableState value$delegate;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState$Companion;", "", "<init>", "()V", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final IntRange calculateNearestItemsRange(int r100, int r101, int r102) {
            int r103 = (r100 / r101) * r101;
            return RangesKt.until(Math.max(r103 - r102, 0), (r103 + r101) + r102);
        }

        public static final /* synthetic */ IntRange access$calculateNearestItemsRange(Companion r100, int r101, int r102, int r103) {
            return r100.calculateNearestItemsRange(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
    public IntRange getValue2() {
        return (IntRange) this.value$delegate.getValue();
    }

    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ IntRange getValue() {
        return getValue2();
    }

    private void setValue(IntRange r100) {
        this.value$delegate.setValue(r100);
    }

    public final void update(int r100) {
        if (r100 == this.lastFirstVisibleItem) goto L6;
        this.lastFirstVisibleItem = r100;
        setValue(Companion.access$calculateNearestItemsRange(Companion, r100, this.slidingWindowSize, this.extraItemCount));
        return;
    }

    public LazyLayoutNearestRangeState(int r100, int r101, int r102) {
        this.slidingWindowSize = r101;
        this.extraItemCount = r102;
        this.value$delegate = SnapshotStateKt.mutableStateOf(Companion.access$calculateNearestItemsRange(Companion, r100, r101, r102), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = r100;
    }
}
