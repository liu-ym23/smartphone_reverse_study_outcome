package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.k;
import S7.o;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0016\u001a\u00020\u0004*\u00020\u0015H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017Jz\u0010\u001a\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0004*\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001fR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/foundation/CombinedClickableNodeImpl;", "Landroidx/compose/foundation/CombinedClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "Lkotlin/Function0;", "LC7/r;", "onClick", "", "onLongClickLabel", "onLongClick", "onDoubleClick", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/IndicationNodeFactory;", "indicationNodeFactory", "", "enabled", "onClickLabel", "Landroidx/compose/ui/semantics/Role;", "role", AppAgent.CONSTRUCT, "(LS7/a;Ljava/lang/String;LS7/a;LS7/a;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "clickPointerInput", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LH7/c;)Ljava/lang/Object;", "update-nSzSaCc", "(LS7/a;Ljava/lang/String;LS7/a;LS7/a;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;)V", "update", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applyAdditionalSemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Ljava/lang/String;", "LS7/a;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class CombinedClickableNodeImpl extends AbstractClickableNode implements CombinedClickableNode {
    private S7.a onDoubleClick;
    private S7.a onLongClick;
    private String onLongClickLabel;

    @c(c = "androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4", f = "Clickable.kt", l = {787}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/PressGestureScope;Landroidx/compose/ui/geometry/Offset;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.CombinedClickableNodeImpl$clickPointerInput$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements o {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass4(H7.c<? super AnonymousClass4> cVar) {
            super(3, cVar);
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m293invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3905unboximpl(), (H7.c) obj3);
        }

        /* renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m293invoked4ec7I(PressGestureScope pressGestureScope, long j5, H7.c<? super r> cVar) {
            AnonymousClass4 anonymousClass4 = CombinedClickableNodeImpl.this.new AnonymousClass4(cVar);
            anonymousClass4.L$0 = pressGestureScope;
            anonymousClass4.J$0 = j5;
            return anonymousClass4.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j5 = this.J$0;
                if (CombinedClickableNodeImpl.this.getEnabled()) {
                    CombinedClickableNodeImpl combinedClickableNodeImpl = CombinedClickableNodeImpl.this;
                    this.label = 1;
                    if (combinedClickableNodeImpl.m210handlePressInteractiond4ec7I(pressGestureScope, j5, this) == coroutineSingletons) {
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

    public /* synthetic */ CombinedClickableNodeImpl(S7.a aVar, String str, S7.a aVar2, S7.a aVar3, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z10, String str2, Role role, e eVar) {
        this(aVar, str, aVar2, aVar3, mutableInteractionSource, indicationNodeFactory, z10, str2, role);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.onLongClick != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.onLongClickLabel, new S7.a() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.applyAdditionalSemantics.1
                {
                    super(0);
                }

                @Override // S7.a
                public final Boolean invoke() {
                    S7.a aVar = CombinedClickableNodeImpl.this.onLongClick;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object clickPointerInput(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        Object objDetectTapGestures = TapGestureDetectorKt.detectTapGestures(pointerInputScope, (!getEnabled() || this.onDoubleClick == null) ? null : new k() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m291invokek4lQ0M(((Offset) obj).m3905unboximpl());
                return r.f317a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m291invokek4lQ0M(long j5) {
                S7.a aVar = CombinedClickableNodeImpl.this.onDoubleClick;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
        }, (!getEnabled() || this.onLongClick == null) ? null : new k() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.3
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m292invokek4lQ0M(((Offset) obj).m3905unboximpl());
                return r.f317a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m292invokek4lQ0M(long j5) {
                S7.a aVar = CombinedClickableNodeImpl.this.onLongClick;
                if (aVar != null) {
                    aVar.invoke();
                }
            }
        }, new AnonymousClass4(null), new k() { // from class: androidx.compose.foundation.CombinedClickableNodeImpl.clickPointerInput.5
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m294invokek4lQ0M(((Offset) obj).m3905unboximpl());
                return r.f317a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m294invokek4lQ0M(long j5) {
                if (CombinedClickableNodeImpl.this.getEnabled()) {
                    CombinedClickableNodeImpl.this.getOnClick().invoke();
                }
            }
        }, cVar);
        return objDetectTapGestures == CoroutineSingletons.f4909a ? objDetectTapGestures : r.f317a;
    }

    @Override // androidx.compose.foundation.CombinedClickableNode
    /* renamed from: update-nSzSaCc */
    public void mo290updatenSzSaCc(S7.a onClick, String onLongClickLabel, S7.a onLongClick, S7.a onDoubleClick, MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean enabled, String onClickLabel, Role role) {
        boolean z10;
        if (!kotlin.jvm.internal.k.b(this.onLongClickLabel, onLongClickLabel)) {
            this.onLongClickLabel = onLongClickLabel;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if ((this.onLongClick == null) != (onLongClick == null)) {
            disposeInteractions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
            z10 = true;
        } else {
            z10 = false;
        }
        this.onLongClick = onLongClick;
        if ((this.onDoubleClick == null) != (onDoubleClick == null)) {
            z10 = true;
        }
        this.onDoubleClick = onDoubleClick;
        boolean z11 = getEnabled() == enabled ? z10 : true;
        m214updateCommonQzZPfjk(interactionSource, indicationNodeFactory, enabled, onClickLabel, role, onClick);
        if (z11) {
            resetPointerInputHandler();
        }
    }

    private CombinedClickableNodeImpl(S7.a aVar, String str, S7.a aVar2, S7.a aVar3, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z10, String str2, Role role) {
        super(mutableInteractionSource, indicationNodeFactory, z10, str2, role, aVar, null);
        this.onLongClickLabel = str;
        this.onLongClick = aVar2;
        this.onDoubleClick = aVar3;
    }
}
