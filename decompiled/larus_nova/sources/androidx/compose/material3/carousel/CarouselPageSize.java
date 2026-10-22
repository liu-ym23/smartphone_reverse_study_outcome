package androidx.compose.material3.carousel;

import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.unit.Density;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016R>\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/carousel/CarouselPageSize;", "Landroidx/compose/foundation/pager/PageSize;", "keylineList", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "availableSpace", "itemSpacing", "Landroidx/compose/material3/carousel/KeylineList;", "beforeContentPadding", "afterContentPadding", "<init>", "(Lkotlin/jvm/functions/Function2;FF)V", "<set-?>", "Landroidx/compose/material3/carousel/Strategy;", "strategyState", "getStrategyState", "()Landroidx/compose/material3/carousel/Strategy;", "setStrategyState", "(Landroidx/compose/material3/carousel/Strategy;)V", "strategyState$delegate", "Landroidx/compose/runtime/MutableState;", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "getStrategy", "calculateMainAxisPageSize", "", "Landroidx/compose/ui/unit/Density;", "pageSpacing", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CarouselPageSize implements PageSize {
    public static final int $stable = 0;
    private final float afterContentPadding;
    private final float beforeContentPadding;
    private final Function2<Float, Float, KeylineList> keylineList;
    private final MutableState strategyState$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    private final Strategy getStrategyState() {
        return (Strategy) this.strategyState$delegate.getValue();
    }

    public final Strategy getStrategy() {
        return getStrategyState();
    }

    private final void setStrategyState(Strategy r100) {
        this.strategyState$delegate.setValue(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselPageSize(Function2<? super Float, ? super Float, KeylineList> r100, float r101, float r102) {
        this.keylineList = r100;
        this.beforeContentPadding = r101;
        this.afterContentPadding = r102;
        this.strategyState$delegate = SnapshotStateKt.mutableStateOf$default(Strategy.Companion.getEmpty(), null, 2, null);
    }

    @Override // androidx.compose.foundation.pager.PageSize
    public int calculateMainAxisPageSize(Density r100, int r101, int r102) {
        float r103 = r101;
        float r104 = r102;
        setStrategyState(new Strategy(this.keylineList.invoke(Float.valueOf(r103), Float.valueOf(r104)), r103, r104, this.beforeContentPadding, this.afterContentPadding));
        if (getStrategy().isValid() == true) goto L5;
        return r101;
    L5:
        return MathKt.roundToInt(getStrategy().getItemMainAxisSize());
    }
}
