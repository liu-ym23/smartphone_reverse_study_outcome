package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u0003J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "<init>", "(II)V", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "update", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyListScrollPosition() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    private final void setScrollOffset(int r100) {
        this.scrollOffset$delegate.setIntValue(r100);
    }

    public final void setIndex(int r100) {
        this.index$delegate.setIntValue(r100);
    }

    public final void updateFromMeasureResult(LazyListMeasureResult r100) {
        LazyListMeasuredItem r101 = r100.getFirstVisibleItem();
        if (r101 == null) goto L5;
        Object r102 = r101.getKey();
    L6:
        this.lastKnownFirstItemKey = r102;
        if (this.hadFirstNotEmptyLayout == false) goto L9;
    L10:
        boolean r103 = true;
        this.hadFirstNotEmptyLayout = true;
        int r104 = r100.getFirstVisibleItemScrollOffset();
        int r105 = 0;
        if (r104 >= 0.0f) goto L14;
        r103 = false;
    L14:
        if (r103 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
    L16:
        LazyListMeasuredItem r106 = r100.getFirstVisibleItem();
        if (r106 == null) goto L19;
        r105 = r106.getIndex();
    L19:
        update(r105, r104);
        return;
    L9:
        if (r100.getTotalItemsCount() > 0) goto L10;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void updateScrollOffset(int r100) {
        if (r100 < 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("scrollOffset should be non-negative");
    L8:
        setScrollOffset(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public LazyListScrollPosition(int r100, int r101) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(r100);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(r101);
        this.nearestRangeState = new LazyLayoutNearestRangeState(r100, 30, 100);
    }

    private final void update(int r100, int r101) {
        if (r100 < 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Index should be non-negative (" + r100 + ')');
    L8:
        setIndex(r100);
        this.nearestRangeState.update(r100);
        setScrollOffset(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void requestPositionAndForgetLastKnownKey(int r100, int r101) {
        update(r100, r101);
        this.lastKnownFirstItemKey = null;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider r100, int r101) {
        int r102 = LazyLayoutItemProviderKt.findIndexByKey(r100, this.lastKnownFirstItemKey, r101);
        if (r101 == r102) goto L5;
        setIndex(r102);
        this.nearestRangeState.update(r101);
    L5:
        return r102;
    }

    public /* synthetic */ LazyListScrollPosition(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
