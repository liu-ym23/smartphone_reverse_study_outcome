package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BK\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0015\u001a\u00020\u0012*\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u0016*\u00020\u0011H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0016\u0010\u001b\u001a\u00020\u0011*\u00020\u0016H\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aJ\u0016\u0010\u001f\u001a\u00020\u0016*\u00020\u0016H\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u0012*\u00020\u0012H\u0002ø\u0001\u0001¢\u0006\u0004\b \u0010\u001eJ@\u0010(\u001a\u00020$2.\u0010'\u001a*\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0%\u0012\u0006\u0012\u0004\u0018\u00010&0!H\u0096@¢\u0006\u0004\b(\u0010)J\u001a\u0010-\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0012H\u0016ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u001a\u00100\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0016H\u0016ø\u0001\u0001¢\u0006\u0004\b/\u0010,J\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u00101JQ\u00102\u001a\u00020$2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b2\u0010\u0010R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00103R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00104R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00105R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00106R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u00107R\u0014\u00108\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00101\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "state", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "enabled", "reverseDirection", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/OverscrollEffect;", "overscrollEffect", "startDragImmediately", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)V", "", "Landroidx/compose/ui/geometry/Offset;", "toOffset-tuRUvjQ", "(F)J", "toOffset", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toVelocity", "toFloat-TH1AsA0", "(J)F", "toFloat", "toFloat-k-4lQ0M", "reverseIfNeeded-AH228Gc", "(J)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "LC7/r;", "LH7/c;", "", "forEachDelta", "drag", "(LS7/n;LH7/c;)Ljava/lang/Object;", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStarted", "velocity", "onDragStopped-TH1AsA0", "onDragStopped", "()Z", "update", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "Landroidx/compose/foundation/gestures/Orientation;", "Ljava/lang/Boolean;", "Landroidx/compose/foundation/OverscrollEffect;", "Z", "isReverseDirection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private Boolean reverseDirection;
    private boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", l = {251}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "it", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements o {
        final /* synthetic */ n $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, AnchoredDraggableNode<T> anchoredDraggableNode, H7.c<? super AnonymousClass2> cVar) {
            super(3, cVar);
            this.$forEachDelta = nVar;
            this.this$0 = anchoredDraggableNode;
        }

        @Override // S7.o
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, H7.c<? super r> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$forEachDelta, this.this$0, cVar);
            anonymousClass2.L$0 = anchoredDragScope;
            return anonymousClass2.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
                n nVar = this.$forEachDelta;
                final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                k kVar = new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((DragEvent.DragDelta) obj2);
                        return r.f317a;
                    }

                    public final void invoke(DragEvent.DragDelta dragDelta) {
                        if (((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect == null) {
                            AnchoredDragScope anchoredDragScope2 = anchoredDragScope;
                            AnchoredDraggableState anchoredDraggableState = ((AnchoredDraggableNode) anchoredDraggableNode).state;
                            AnchoredDraggableNode<T> anchoredDraggableNode2 = anchoredDraggableNode;
                            AnchoredDragScope.dragTo$default(anchoredDragScope2, anchoredDraggableState.newOffsetForDelta$foundation_release(anchoredDraggableNode2.m395toFloatk4lQ0M(anchoredDraggableNode2.m393reverseIfNeededMKHz9U(dragDelta.getDelta()))), 0.0f, 2, null);
                            return;
                        }
                        OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect;
                        kotlin.jvm.internal.k.c(overscrollEffect);
                        long jM393reverseIfNeededMKHz9U = anchoredDraggableNode.m393reverseIfNeededMKHz9U(dragDelta.getDelta());
                        int iM5312getUserInputWNlRxjI = NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI();
                        final AnchoredDraggableNode<T> anchoredDraggableNode3 = anchoredDraggableNode;
                        final AnchoredDragScope anchoredDragScope3 = anchoredDragScope;
                        overscrollEffect.mo221applyToScrollRhakbz0(jM393reverseIfNeededMKHz9U, iM5312getUserInputWNlRxjI, new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                return Offset.m3884boximpl(m400invokeMKHz9U(((Offset) obj2).m3905unboximpl()));
                            }

                            /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
                            public final long m400invokeMKHz9U(long j5) {
                                float fNewOffsetForDelta$foundation_release = ((AnchoredDraggableNode) anchoredDraggableNode3).state.newOffsetForDelta$foundation_release(anchoredDraggableNode3.m395toFloatk4lQ0M(j5));
                                AnchoredDraggableNode<T> anchoredDraggableNode4 = anchoredDraggableNode3;
                                long jM396toOffsettuRUvjQ = anchoredDraggableNode4.m396toOffsettuRUvjQ(fNewOffsetForDelta$foundation_release - ((AnchoredDraggableNode) anchoredDraggableNode4).state.requireOffset());
                                AnchoredDragScope.dragTo$default(anchoredDragScope3, fNewOffsetForDelta$foundation_release, 0.0f, 2, null);
                                return jM396toOffsettuRUvjQ;
                            }
                        });
                    }
                };
                this.label = 1;
                if (nVar.invoke(kVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean z10, Boolean bool, MutableInteractionSource mutableInteractionSource, OverscrollEffect overscrollEffect, boolean z11) {
        super(AnchoredDraggableKt.AlwaysDrag, z10, mutableInteractionSource, orientation);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = bool;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = z11;
    }

    private final boolean isReverseDirection() {
        Boolean bool = this.reverseDirection;
        if (bool == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        kotlin.jvm.internal.k.c(bool);
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m392reverseIfNeededAH228Gc(long j5) {
        return Velocity.m7088timesadjELrA(j5, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m393reverseIfNeededMKHz9U(long j5) {
        return Offset.m3902timestuRUvjQ(j5, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m394toFloatTH1AsA0(long j5) {
        return this.orientation == Orientation.Vertical ? Velocity.m7083getYimpl(j5) : Velocity.m7082getXimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m395toFloatk4lQ0M(long j5) {
        return this.orientation == Orientation.Vertical ? Offset.m3896getYimpl(j5) : Offset.m3895getXimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m396toOffsettuRUvjQ(float f) {
        Orientation orientation = this.orientation;
        float f7 = orientation == Orientation.Horizontal ? f : 0.0f;
        if (orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return OffsetKt.Offset(f7, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m397toVelocityadjELrA(float f) {
        Orientation orientation = this.orientation;
        float f7 = orientation == Orientation.Horizontal ? f : 0.0f;
        if (orientation != Orientation.Vertical) {
            f = 0.0f;
        }
        return VelocityKt.Velocity(f7, f);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(n nVar, H7.c<? super r> cVar) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, null, new AnonymousClass2(nVar, this, null), cVar, 1, null);
        return objAnchoredDrag$default == CoroutineSingletons.f4909a ? objAnchoredDrag$default : r.f317a;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo398onDragStartedk4lQ0M(long startedPosition) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStopped-TH1AsA0, reason: not valid java name */
    public void mo399onDragStoppedTH1AsA0(long velocity) {
        if (getIsAttached()) {
            AbstractC1683A.n(getCoroutineScope(), null, new AnchoredDraggableNode$onDragStopped$1(this, velocity, null), 3);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        boolean z10;
        boolean z11 = true;
        if (kotlin.jvm.internal.k.b(this.state, state)) {
            z10 = false;
        } else {
            this.state = state;
            z10 = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z10 = true;
        }
        if (kotlin.jvm.internal.k.b(this.reverseDirection, reverseDirection)) {
            z11 = z10;
        } else {
            this.reverseDirection = reverseDirection;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default(this, null, enabled, interactionSource, orientation, z11, 1, null);
    }
}
