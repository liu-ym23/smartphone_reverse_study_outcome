package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.p;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ2\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\u0016\u0010\u0015J&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0087@¢\u0006\u0004\b\u0012\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R&\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0#8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R/\u00100\u001a\u0004\u0018\u00010\t2\b\u0010*\u001a\u0004\u0018\u00010\t8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010/R\u0011\u00101\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b3\u00102R\u0011\u00106\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00107\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b7\u00102R\u0011\u0010\f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b8\u00105R\u0011\u0010:\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b9\u0010\u001c¨\u0006<"}, d2 = {"Landroidx/compose/material3/DrawerState;", "", "Landroidx/compose/material3/DrawerValue;", "initialValue", "Lkotlin/Function1;", "", "confirmStateChange", AppAgent.CONSTRUCT, "(Landroidx/compose/material3/DrawerValue;LS7/k;)V", "Landroidx/compose/ui/unit/Density;", "requireDensity", "()Landroidx/compose/ui/unit/Density;", "targetValue", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpec", "velocity", "LC7/r;", "animateTo", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;FLH7/c;)Ljava/lang/Object;", "open", "(LH7/c;)Ljava/lang/Object;", "close", "anim", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;LH7/c;)Ljava/lang/Object;", "snapTo", "(Landroidx/compose/material3/DrawerValue;LH7/c;)Ljava/lang/Object;", "requireOffset$material3_release", "()F", "requireOffset", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "Landroidx/compose/runtime/State;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "getOffset$annotations", "()V", "<set-?>", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getDensity$material3_release", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "density", "isOpen", "()Z", "isClosed", "getCurrentValue", "()Landroidx/compose/material3/DrawerValue;", "currentValue", "isAnimationRunning", "getTargetValue", "getCurrentOffset", "currentOffset", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerState {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<DrawerValue> anchoredDraggableState;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final State<Float> offset;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/material3/DrawerState$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Landroidx/compose/material3/DrawerValue;", "", "confirmStateChange", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DrawerState;", "Saver", "(LS7/k;)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Saver<DrawerState, DrawerValue> Saver(final k confirmStateChange) {
            return SaverKt.Saver(new n() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$1
                @Override // S7.n
                public final DrawerValue invoke(SaverScope saverScope, DrawerState drawerState) {
                    return drawerState.getCurrentValue();
                }
            }, new k() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$2
                {
                    super(1);
                }

                @Override // S7.k
                public final DrawerState invoke(DrawerValue drawerValue) {
                    return new DrawerState(drawerValue, confirmStateChange);
                }
            });
        }

        private Companion() {
        }
    }

    @J7.c(c = "androidx.compose.material3.DrawerState$animateTo$3", f = "NavigationDrawer.kt", l = {254}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDragScope;", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/DrawerValue;", "anchors", "latestTarget", "LC7/r;", "<anonymous>", "(Landroidx/compose/material3/internal/AnchoredDragScope;Landroidx/compose/material3/internal/DraggableAnchors;Landroidx/compose/material3/DrawerValue;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.DrawerState$animateTo$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(float f, AnimationSpec<Float> animationSpec, H7.c<? super AnonymousClass3> cVar) {
            super(4, cVar);
            this.$velocity = f;
            this.$animationSpec = animationSpec;
        }

        @Override // S7.p
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<DrawerValue> draggableAnchors, DrawerValue drawerValue, H7.c<? super r> cVar) {
            AnonymousClass3 anonymousClass3 = DrawerState.this.new AnonymousClass3(this.$velocity, this.$animationSpec, cVar);
            anonymousClass3.L$0 = anchoredDragScope;
            anonymousClass3.L$1 = draggableAnchors;
            anonymousClass3.L$2 = drawerValue;
            return anonymousClass3.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                float fPositionOf = ((DraggableAnchors) this.L$1).positionOf((DrawerValue) this.L$2);
                if (!Float.isNaN(fPositionOf)) {
                    final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                    float currentOffset = Float.isNaN(DrawerState.this.getCurrentOffset()) ? 0.0f : DrawerState.this.getCurrentOffset();
                    ref$FloatRef.f4917a = currentOffset;
                    float f = this.$velocity;
                    AnimationSpec<Float> animationSpec = this.$animationSpec;
                    n nVar = new n() { // from class: androidx.compose.material3.DrawerState.animateTo.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                            return r.f317a;
                        }

                        public final void invoke(float f7, float f9) {
                            anchoredDragScope.dragTo(f7, f9);
                            ref$FloatRef.f4917a = f7;
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 1;
                    if (SuspendAnimationKt.animate(currentOffset, fPositionOf, f, animationSpec, nVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    public DrawerState(DrawerValue drawerValue, k kVar) {
        this.anchoredDraggableState = new AnchoredDraggableState<>(drawerValue, new k() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$1
            public final Float invoke(float f) {
                return Float.valueOf(NavigationDrawerKt.DrawerPositionalThreshold * f);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        }, new S7.a() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$2
            {
                super(0);
            }

            @Override // S7.a
            public final Float invoke() {
                return Float.valueOf(this.this$0.requireDensity().mo381toPx0680j_4(NavigationDrawerKt.DrawerVelocityThreshold));
            }
        }, NavigationDrawerKt.AnimationSpec, kVar);
        this.offset = new State<Float>() { // from class: androidx.compose.material3.DrawerState$offset$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.runtime.State
            public Float getValue() {
                return Float.valueOf(this.this$0.getAnchoredDraggableState$material3_release().getOffset());
            }
        };
        this.density = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(DrawerState drawerState, DrawerValue drawerValue, AnimationSpec animationSpec, float f, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = NavigationDrawerKt.AnimationSpec;
        }
        if ((i & 4) != 0) {
            f = drawerState.anchoredDraggableState.getLastVelocity();
        }
        return drawerState.animateTo(drawerValue, animationSpec, f, cVar);
    }

    @C7.c
    public static /* synthetic */ void getOffset$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density$material3_release = getDensity$material3_release();
        if (density$material3_release != null) {
            return density$material3_release;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?").toString());
    }

    @C7.c
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, H7.c<? super r> cVar) {
        Object objAnimateTo$default = animateTo$default(this, drawerValue, animationSpec, 0.0f, cVar, 4, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final Object close(H7.c<? super r> cVar) {
        Object objAnimateTo$default = animateTo$default(this, DrawerValue.Closed, null, 0.0f, cVar, 6, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final AnchoredDraggableState<DrawerValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material3_release() {
        return (Density) this.density.getValue();
    }

    public final State<Float> getOffset() {
        return this.offset;
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final Object open(H7.c<? super r> cVar) {
        Object objAnimateTo$default = animateTo$default(this, DrawerValue.Open, null, 0.0f, cVar, 6, null);
        return objAnimateTo$default == CoroutineSingletons.f4909a ? objAnimateTo$default : r.f317a;
    }

    public final float requireOffset$material3_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final void setDensity$material3_release(Density density) {
        this.density.setValue(density);
    }

    public final Object snapTo(DrawerValue drawerValue, H7.c<? super r> cVar) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, drawerValue, cVar);
        return objSnapTo == CoroutineSingletons.f4909a ? objSnapTo : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, float f, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, drawerValue, null, new AnonymousClass3(f, animationSpec, null), cVar, 2, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }

    public /* synthetic */ DrawerState(DrawerValue drawerValue, k kVar, int i, e eVar) {
        this(drawerValue, (i & 2) != 0 ? new k() { // from class: androidx.compose.material3.DrawerState.1
            @Override // S7.k
            public final Boolean invoke(DrawerValue drawerValue2) {
                return Boolean.TRUE;
            }
        } : kVar);
    }
}
