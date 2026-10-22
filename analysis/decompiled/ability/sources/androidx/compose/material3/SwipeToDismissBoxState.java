package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import androidx.annotation.FloatRange;
import androidx.compose.material3.internal.AnchoredDraggableDefaults;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000eR\u0011\u0010#\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u000f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0011\u0010&\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b%\u0010\u000eR\u0011\u0010(\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010\"¨\u0006*"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "initialValue", "Landroidx/compose/ui/unit/Density;", "density", "Lkotlin/Function1;", "", "confirmValueChange", "", "positionalThreshold", AppAgent.CONSTRUCT, "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;LS7/k;LS7/k;)V", "requireOffset", "()F", "targetValue", "LC7/r;", "snapTo", "(Landroidx/compose/material3/SwipeToDismissBoxValue;LH7/c;)Ljava/lang/Object;", "reset", "(LH7/c;)Ljava/lang/Object;", "direction", "dismiss", "Landroidx/compose/ui/unit/Density;", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "getOffset$material3_release", TypedValues.CycleType.S_WAVE_OFFSET, "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "currentValue", "getTargetValue", "getProgress", "progress", "getDismissDirection", "dismissDirection", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState;
    private final Density density;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "", "confirmValueChange", "", "positionalThreshold", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Saver", "(LS7/k;LS7/k;Landroidx/compose/ui/unit/Density;)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver(final k confirmValueChange, final k positionalThreshold, final Density density) {
            return SaverKt.Saver(new n() { // from class: androidx.compose.material3.SwipeToDismissBoxState$Companion$Saver$1
                @Override // S7.n
                public final SwipeToDismissBoxValue invoke(SaverScope saverScope, SwipeToDismissBoxState swipeToDismissBoxState) {
                    return swipeToDismissBoxState.getCurrentValue();
                }
            }, new k() { // from class: androidx.compose.material3.SwipeToDismissBoxState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final SwipeToDismissBoxState invoke(SwipeToDismissBoxValue swipeToDismissBoxValue) {
                    return new SwipeToDismissBoxState(swipeToDismissBoxValue, density, confirmValueChange, positionalThreshold);
                }
            });
        }

        private Companion() {
        }
    }

    public SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, k kVar, k kVar2) {
        this.density = density;
        this.anchoredDraggableState = new AnchoredDraggableState<>(swipeToDismissBoxValue, kVar2, new S7.a() { // from class: androidx.compose.material3.SwipeToDismissBoxState$anchoredDraggableState$1
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(this.this$0.getDensity().mo381toPx0680j_4(SwipeToDismissBoxKt.DismissVelocityThreshold));
            }
        }, AnchoredDraggableDefaults.INSTANCE.getAnimationSpec(), kVar);
    }

    public final Object dismiss(SwipeToDismissBoxValue swipeToDismissBoxValue, H7.c<? super r> cVar) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, swipeToDismissBoxValue, 0.0f, cVar, 2, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final AnchoredDraggableState<SwipeToDismissBoxValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    /* renamed from: getDensity$material3_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final SwipeToDismissBoxValue getDismissDirection() {
        return (getOffset$material3_release() == 0.0f || Float.isNaN(getOffset$material3_release())) ? SwipeToDismissBoxValue.Settled : getOffset$material3_release() > 0.0f ? SwipeToDismissBoxValue.StartToEnd : SwipeToDismissBoxValue.EndToStart;
    }

    public final float getOffset$material3_release() {
        return this.anchoredDraggableState.getOffset();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final SwipeToDismissBoxValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final Object reset(H7.c<? super r> cVar) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, 0.0f, cVar, 2, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final Object snapTo(SwipeToDismissBoxValue swipeToDismissBoxValue, H7.c<? super r> cVar) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, swipeToDismissBoxValue, cVar);
        return objSnapTo == CoroutineSingletons.f4909a ? objSnapTo : r.f317a;
    }

    public /* synthetic */ SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, k kVar, k kVar2, int i, e eVar) {
        this(swipeToDismissBoxValue, density, (i & 4) != 0 ? new k() { // from class: androidx.compose.material3.SwipeToDismissBoxState.1
            @Override // S7.k
            public final Boolean invoke(SwipeToDismissBoxValue swipeToDismissBoxValue2) {
                return Boolean.TRUE;
            }
        } : kVar, kVar2);
    }
}
