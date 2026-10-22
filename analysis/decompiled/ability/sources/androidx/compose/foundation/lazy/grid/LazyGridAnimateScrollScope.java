package androidx.compose.foundation.lazy.grid;

import C7.r;
import D7.v;
import H7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J4\u0010\u0019\u001a\u00020\u000e2\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0014\u0010$\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "state", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfo", "", "calculateLineAverageMainAxisSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "Landroidx/compose/foundation/gestures/ScrollScope;", "index", "scrollOffset", "LC7/r;", "snapToItem", "(Landroidx/compose/foundation/gestures/ScrollScope;II)V", "targetIndex", "", "calculateDistanceTo", "(I)F", "Lkotlin/Function2;", "LH7/c;", "", "block", "scroll", "(LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndex", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffset", "getLastVisibleItemIndex", "lastVisibleItemIndex", "getItemCount", "itemCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    public static final int $stable = 0;
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo layoutInfo) {
        final boolean z10 = layoutInfo.getOrientation() == Orientation.Vertical;
        final List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        k kVar = new k() { // from class: androidx.compose.foundation.lazy.grid.LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Integer invoke(int i) {
                boolean z11 = z10;
                LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
                return Integer.valueOf(z11 ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn());
            }
        };
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < visibleItemsInfo.size()) {
            int iIntValue = ((Number) kVar.invoke(Integer.valueOf(i))).intValue();
            if (iIntValue == -1) {
                i++;
            } else {
                int iMax = 0;
                while (i < visibleItemsInfo.size() && ((Number) kVar.invoke(Integer.valueOf(i))).intValue() == iIntValue) {
                    iMax = Math.max(iMax, z10 ? IntSize.m7014getHeightimpl(visibleItemsInfo.get(i).getSize()) : IntSize.m7015getWidthimpl(visibleItemsInfo.get(i).getSize()));
                    i++;
                }
                i6 += iMax;
                i10++;
            }
        }
        return layoutInfo.getMainAxisItemSpacing() + (i6 / i10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public float calculateDistanceTo(int targetIndex) {
        LazyGridItemInfo lazyGridItemInfo;
        LazyGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        if (layoutInfo.getVisibleItemsInfo().isEmpty()) {
            return 0.0f;
        }
        List<LazyGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i);
            if (lazyGridItemInfo.getIndex() == targetIndex) {
                break;
            }
            i++;
        }
        if (lazyGridItemInfo != null) {
            return layoutInfo.getOrientation() == Orientation.Vertical ? IntOffset.m6973getYimpl(r5.getOffset()) : IntOffset.m6972getXimpl(r5.getOffset());
        }
        int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
        return (((((slotsPerLine$foundation_release - 1) * (targetIndex < getFirstVisibleItemIndex() ? -1 : 1)) + (targetIndex - getFirstVisibleItemIndex())) / slotsPerLine$foundation_release) * calculateLineAverageMainAxisSize(layoutInfo)) - getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) v.L0(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public Object scroll(n nVar, c<? super r> cVar) {
        Object objScroll$default = ScrollableState.scroll$default(this.state, null, nVar, cVar, 1, null);
        return objScroll$default == CoroutineSingletons.f4909a ? objScroll$default : r.f317a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope
    public void snapToItem(ScrollScope scrollScope, int i, int i6) {
        this.state.snapToItemIndexInternal$foundation_release(i, i6, true);
    }
}
