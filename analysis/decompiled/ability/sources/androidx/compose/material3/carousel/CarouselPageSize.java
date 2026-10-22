package androidx.compose.material3.carousel;

import S7.n;
import U7.a;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Density;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u000b*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/carousel/CarouselPageSize;", "Landroidx/compose/foundation/pager/PageSize;", "Lkotlin/Function2;", "", "Landroidx/compose/material3/carousel/KeylineList;", "keylineList", "beforeContentPadding", "afterContentPadding", AppAgent.CONSTRUCT, "(LS7/n;FF)V", "Landroidx/compose/ui/unit/Density;", "", "availableSpace", "pageSpacing", "calculateMainAxisPageSize", "(Landroidx/compose/ui/unit/Density;II)I", "LS7/n;", "F", "Landroidx/compose/material3/carousel/Strategy;", "<set-?>", "strategyState$delegate", "Landroidx/compose/runtime/MutableState;", "getStrategyState", "()Landroidx/compose/material3/carousel/Strategy;", "setStrategyState", "(Landroidx/compose/material3/carousel/Strategy;)V", "strategyState", "getStrategy", "strategy", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselPageSize implements PageSize {
    public static final int $stable = 0;
    private final float afterContentPadding;
    private final float beforeContentPadding;
    private final n keylineList;

    /* renamed from: strategyState$delegate, reason: from kotlin metadata */
    private final MutableState strategyState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Strategy.INSTANCE.getEmpty(), null, 2, null);

    public CarouselPageSize(n nVar, float f, float f7) {
        this.keylineList = nVar;
        this.beforeContentPadding = f;
        this.afterContentPadding = f7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Strategy getStrategyState() {
        return (Strategy) this.strategyState.getValue();
    }

    private final void setStrategyState(Strategy strategy) {
        this.strategyState.setValue(strategy);
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public int calculateMainAxisPageSize(Density density, int i, int i6) {
        float f = i;
        float f7 = i6;
        setStrategyState(new Strategy((KeylineList) this.keylineList.invoke(Float.valueOf(f), Float.valueOf(f7)), f, f7, this.beforeContentPadding, this.afterContentPadding));
        return getStrategy().getIsValid() ? a.U(getStrategy().getItemMainAxisSize()) : i;
    }

    public final Strategy getStrategy() {
        return getStrategyState();
    }
}
