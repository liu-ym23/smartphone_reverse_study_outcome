package androidx.compose.foundation.lazy;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R+\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0010R+\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00028F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u0010R\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0017\u0010%\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "", "initialIndex", "initialScrollOffset", AppAgent.CONSTRUCT, "(II)V", "index", "scrollOffset", "LC7/r;", "update", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureResult", "updateFromMeasureResult", "(Landroidx/compose/foundation/lazy/LazyListMeasureResult;)V", "updateScrollOffset", "(I)V", "requestPositionAndForgetLastKnownKey", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "itemProvider", "updateScrollPositionIfTheFirstItemWasMoved", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;I)I", "<set-?>", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "getIndex", "()I", "setIndex", "scrollOffset$delegate", "getScrollOffset", "setScrollOffset", "", "hadFirstNotEmptyLayout", "Z", "lastKnownFirstItemKey", "Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;

    /* renamed from: index$delegate, reason: from kotlin metadata */
    private final MutableIntState index;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;

    /* renamed from: scrollOffset$delegate, reason: from kotlin metadata */
    private final MutableIntState scrollOffset;

    /* JADX WARN: Illegal instructions before constructor call */
    public LazyListScrollPosition() {
        int i = 0;
        this(i, i, 3, null);
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset.setIntValue(i);
    }

    private final void update(int index, int scrollOffset) {
        if (index < 0.0f) {
            throw new IllegalArgumentException(a.k("Index should be non-negative (", index, ')').toString());
        }
        setIndex(index);
        this.nearestRangeState.update(index);
        setScrollOffset(scrollOffset);
    }

    public final int getIndex() {
        return this.index.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int getScrollOffset() {
        return this.scrollOffset.getIntValue();
    }

    public final void requestPositionAndForgetLastKnownKey(int index, int scrollOffset) {
        update(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final void setIndex(int i) {
        this.index.setIntValue(i);
    }

    public final void updateFromMeasureResult(LazyListMeasureResult measureResult) {
        LazyListMeasuredItem firstVisibleItem = measureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = measureResult.getFirstVisibleItemScrollOffset();
            if (firstVisibleItemScrollOffset < 0.0f) {
                throw new IllegalStateException(a.k("scrollOffset should be non-negative (", firstVisibleItemScrollOffset, ')').toString());
            }
            LazyListMeasuredItem firstVisibleItem2 = measureResult.getFirstVisibleItem();
            update(firstVisibleItem2 != null ? firstVisibleItem2.getIndex() : 0, firstVisibleItemScrollOffset);
        }
    }

    public final void updateScrollOffset(int scrollOffset) {
        if (scrollOffset < 0.0f) {
            throw new IllegalStateException(a.k("scrollOffset should be non-negative (", scrollOffset, ')').toString());
        }
        setScrollOffset(scrollOffset);
    }

    @ExperimentalFoundationApi
    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider itemProvider, int index) {
        int iFindIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, index);
        if (index != iFindIndexByKey) {
            setIndex(iFindIndexByKey);
            this.nearestRangeState.update(index);
        }
        return iFindIndexByKey;
    }

    public LazyListScrollPosition(int i, int i6) {
        this.index = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scrollOffset = SnapshotIntStateKt.mutableIntStateOf(i6);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    public /* synthetic */ LazyListScrollPosition(int i, int i6, int i10, e eVar) {
        this((i10 & 1) != 0 ? 0 : i, (i10 & 2) != 0 ? 0 : i6);
    }
}
