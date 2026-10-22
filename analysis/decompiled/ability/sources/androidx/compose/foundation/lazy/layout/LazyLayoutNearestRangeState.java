package androidx.compose.foundation.lazy.layout;

import Y7.f;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR+\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "Landroidx/compose/runtime/State;", "LY7/f;", "", "firstVisibleItem", "slidingWindowSize", "extraItemCount", AppAgent.CONSTRUCT, "(III)V", "LC7/r;", "update", "(I)V", "I", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "()LY7/f;", "setValue", "(LY7/f;)V", "value", "lastFirstVisibleItem", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State<f> {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private final int extraItemCount;
    private int lastFirstVisibleItem;
    private final int slidingWindowSize;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "firstVisibleItem", "slidingWindowSize", "extraItemCount", "LY7/f;", "calculateNearestItemsRange", "(III)LY7/f;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f calculateNearestItemsRange(int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
            int i = (firstVisibleItem / slidingWindowSize) * slidingWindowSize;
            return AbstractC1451a.X(Math.max(i - extraItemCount, 0), i + slidingWindowSize + extraItemCount);
        }

        private Companion() {
        }
    }

    public LazyLayoutNearestRangeState(int i, int i6, int i10) {
        this.slidingWindowSize = i6;
        this.extraItemCount = i10;
        this.value = SnapshotStateKt.mutableStateOf(Companion.calculateNearestItemsRange(i, i6, i10), SnapshotStateKt.structuralEqualityPolicy());
        this.lastFirstVisibleItem = i;
    }

    private void setValue(f fVar) {
        this.value.setValue(fVar);
    }

    public final void update(int firstVisibleItem) {
        if (firstVisibleItem != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = firstVisibleItem;
            setValue(Companion.calculateNearestItemsRange(firstVisibleItem, this.slidingWindowSize, this.extraItemCount));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public f getValue() {
        return (f) this.value.getValue();
    }
}
