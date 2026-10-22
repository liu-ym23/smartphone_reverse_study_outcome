package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;

@Stable
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 82\u00020\u0001:\u00018BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0014\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0015\u0010\u0012J\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\rH\u0080@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\rH\u0080@¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\n\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b$\u0010#R(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010.\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0011\u00100\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010#R\u0011\u00102\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b1\u0010#R\u0011\u00104\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b3\u0010#R\u0016\u00107\u001a\u0004\u0018\u00010\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "", "skipPartiallyExpanded", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/material3/SheetValue;", "initialValue", "Lkotlin/Function1;", "confirmValueChange", "skipHiddenState", AppAgent.CONSTRUCT, "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;LS7/k;Z)V", "", "requireOffset", "()F", "LC7/r;", "expand", "(LH7/c;)Ljava/lang/Object;", "partialExpand", "show", "hide", "targetValue", "velocity", "animateTo$material3_release", "(Landroidx/compose/material3/SheetValue;FLH7/c;)Ljava/lang/Object;", "animateTo", "snapTo$material3_release", "(Landroidx/compose/material3/SheetValue;LH7/c;)Ljava/lang/Object;", "snapTo", "settle$material3_release", "(FLH7/c;)Ljava/lang/Object;", "settle", "Z", "getSkipPartiallyExpanded$material3_release", "()Z", "getSkipHiddenState$material3_release", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3_release", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "currentValue", "getTargetValue", "isVisible", "getHasExpandedState", "hasExpandedState", "getHasPartiallyExpandedState", "hasPartiallyExpandedState", "getOffset$material3_release", "()Ljava/lang/Float;", TypedValues.CycleType.S_WAVE_OFFSET, "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SheetState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", AppAgent.CONSTRUCT, "()V", "", "skipPartiallyExpanded", "Lkotlin/Function1;", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Landroidx/compose/ui/unit/Density;", "density", "skipHiddenState", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Saver", "(ZLS7/k;Landroidx/compose/ui/unit/Density;Z)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<SheetState, SheetValue> Saver(final boolean skipPartiallyExpanded, final k confirmValueChange, final Density density, final boolean skipHiddenState) {
            return SaverKt.Saver(new n() { // from class: androidx.compose.material3.SheetState$Companion$Saver$1
                @Override // S7.n
                public final SheetValue invoke(SaverScope saverScope, SheetState sheetState) {
                    return sheetState.getCurrentValue();
                }
            }, new k() { // from class: androidx.compose.material3.SheetState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final SheetState invoke(SheetValue sheetValue) {
                    return new SheetState(skipPartiallyExpanded, density, sheetValue, confirmValueChange, skipHiddenState);
                }
            });
        }

        private Companion() {
        }
    }

    public SheetState(boolean z10, final Density density, SheetValue sheetValue, k kVar, boolean z11) {
        this.skipPartiallyExpanded = z10;
        this.skipHiddenState = z11;
        if (z10 && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.");
        }
        if (z11 && sheetValue == SheetValue.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.");
        }
        this.anchoredDraggableState = new AnchoredDraggableState<>(sheetValue, new k() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$1
            {
                super(1);
            }

            public final Float invoke(float f) {
                return Float.valueOf(density.mo381toPx0680j_4(Dp.m6844constructorimpl(56)));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }, new S7.a() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(density.mo381toPx0680j_4(Dp.m6844constructorimpl(125)));
            }
        }, SheetDefaultsKt.BottomSheetAnimationSpec, kVar);
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SheetState sheetState, SheetValue sheetValue, float f, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            f = sheetState.anchoredDraggableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue, f, cVar);
    }

    public final Object animateTo$material3_release(SheetValue sheetValue, float f, H7.c<? super r> cVar) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, sheetValue, f, cVar);
        return objAnimateTo == CoroutineSingletons.f4909a ? objAnimateTo : r.f317a;
    }

    public final Object expand(H7.c<? super r> cVar) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SheetValue.Expanded, 0.0f, cVar, 2, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final Float getOffset$material3_release() {
        return Float.valueOf(this.anchoredDraggableState.getOffset());
    }

    /* renamed from: getSkipHiddenState$material3_release, reason: from getter */
    public final boolean getSkipHiddenState() {
        return this.skipHiddenState;
    }

    /* renamed from: getSkipPartiallyExpanded$material3_release, reason: from getter */
    public final boolean getSkipPartiallyExpanded() {
        return this.skipPartiallyExpanded;
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final Object hide(H7.c<? super r> cVar) {
        if (this.skipHiddenState) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.");
        }
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.Hidden, 0.0f, cVar, 2, null);
        return objAnimateTo$material3_release$default == CoroutineSingletons.f4909a ? objAnimateTo$material3_release$default : r.f317a;
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final Object partialExpand(H7.c<? super r> cVar) {
        if (this.skipPartiallyExpanded) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.");
        }
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0.0f, cVar, 2, null);
        return objAnimateTo$material3_release$default == CoroutineSingletons.f4909a ? objAnimateTo$material3_release$default : r.f317a;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setAnchoredDraggableState$material3_release(AnchoredDraggableState<SheetValue> anchoredDraggableState) {
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public final Object settle$material3_release(float f, H7.c<? super r> cVar) {
        Object obj = this.anchoredDraggableState.settle(f, cVar);
        return obj == CoroutineSingletons.f4909a ? obj : r.f317a;
    }

    public final Object show(H7.c<? super r> cVar) {
        Object objAnimateTo$material3_release$default = animateTo$material3_release$default(this, getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded, 0.0f, cVar, 2, null);
        return objAnimateTo$material3_release$default == CoroutineSingletons.f4909a ? objAnimateTo$material3_release$default : r.f317a;
    }

    public final Object snapTo$material3_release(SheetValue sheetValue, H7.c<? super r> cVar) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, sheetValue, cVar);
        return objSnapTo == CoroutineSingletons.f4909a ? objSnapTo : r.f317a;
    }

    public /* synthetic */ SheetState(boolean z10, Density density, SheetValue sheetValue, k kVar, boolean z11, int i, e eVar) {
        this(z10, density, (i & 4) != 0 ? SheetValue.Hidden : sheetValue, (i & 8) != 0 ? new k() { // from class: androidx.compose.material3.SheetState.1
            @Override // S7.k
            public final Boolean invoke(SheetValue sheetValue2) {
                return Boolean.TRUE;
            }
        } : kVar, (i & 16) != 0 ? false : z11);
    }
}
