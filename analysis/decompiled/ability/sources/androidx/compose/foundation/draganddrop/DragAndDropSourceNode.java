package androidx.compose.foundation.draganddrop;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@StabilityInferred(parameters = 0)
@ExperimentalFoundationApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R>\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "drawDragDecoration", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "LH7/c;", "", "dragAndDropSourceHandler", AppAgent.CONSTRUCT, "(LS7/k;LS7/n;)V", "Landroidx/compose/ui/unit/IntSize;", "size", "onRemeasured-ozmzZPI", "(J)V", "onRemeasured", "LS7/k;", "getDrawDragDecoration", "()LS7/k;", "setDrawDragDecoration", "(LS7/k;)V", "LS7/n;", "getDragAndDropSourceHandler", "()LS7/n;", "setDragAndDropSourceHandler", "(LS7/n;)V", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropSourceNode extends DelegatingNode implements LayoutAwareModifierNode {
    public static final int $stable = 8;
    private n dragAndDropSourceHandler;
    private k drawDragDecoration;
    private long size = IntSize.INSTANCE.m7020getZeroYbymL2g();

    @c(c = "androidx.compose.foundation.draganddrop.DragAndDropSourceNode$1", f = "DragAndDropSource.kt", l = {113}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceNode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ DragAndDropModifierNode $dragAndDropModifierNode;
        private /* synthetic */ Object L$0;
        int label;

        @Metadata(d1 = {"\u0000}\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J:\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0096A¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\f*\u00020\u000bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f*\u00020\u0010H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000b*\u00020\u0010H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u000b*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0015\u001a\u00020\u000b*\u00020\fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u001b*\u00020\u001aH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u0016*\u00020\u000bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0018J\u0017\u0010 \u001a\u00020\u0016*\u00020\u0010H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0014J\u0014\u0010$\u001a\u00020#*\u00020\"H\u0097\u0001¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u001a*\u00020\u001bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001dJ\u0017\u0010*\u001a\u00020\u0010*\u00020\u000bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u0010*\u00020\u0016H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010)J\u001a\u0010*\u001a\u00020\u0010*\u00020\fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0017\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00107\u001a\u00020\u001a8VX\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b8\u00103R$\u0010@\u001a\u00020:2\u0006\u0010;\u001a\u00020:8V@VX\u0096\u000f¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010C\u001a\u00020A8\u0016X\u0096\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bB\u00106R\u0014\u0010G\u001a\u00020D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010F\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006H"}, d2 = {"androidx/compose/foundation/draganddrop/DragAndDropSourceNode$1$1", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "R", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LH7/c;", "", "block", "awaitPointerEventScope", "(LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/Dp;", "", "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp-GaN1DYA", "(J)F", "toDp", "", "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "Landroidx/compose/ui/unit/DpRect;", "Landroidx/compose/ui/geometry/Rect;", "toRect", "(Landroidx/compose/ui/unit/DpRect;)Landroidx/compose/ui/geometry/Rect;", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "transferData", "LC7/r;", "startTransfer", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;)V", "getDensity", "()F", "density", "getExtendedTouchPadding-NH-jbRc", "()J", "extendedTouchPadding", "getFontScale", "fontScale", "", "<anonymous parameter 0>", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "interceptOutOfBoundsChildEvents", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.foundation.draganddrop.DragAndDropSourceNode$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00141 implements DragAndDropSourceScope, PointerInputScope {
            private final /* synthetic */ PointerInputScope $$delegate_0;
            final /* synthetic */ DragAndDropModifierNode $dragAndDropModifierNode;
            final /* synthetic */ DragAndDropSourceNode this$0;

            public C00141(PointerInputScope pointerInputScope, DragAndDropModifierNode dragAndDropModifierNode, DragAndDropSourceNode dragAndDropSourceNode) {
                this.$dragAndDropModifierNode = dragAndDropModifierNode;
                this.this$0 = dragAndDropSourceNode;
                this.$$delegate_0 = pointerInputScope;
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            public <R> Object awaitPointerEventScope(n nVar, H7.c<? super R> cVar) {
                return this.$$delegate_0.awaitPointerEventScope(nVar, cVar);
            }

            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return this.$$delegate_0.getDensity();
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
            public long mo372getExtendedTouchPaddingNHjbRc() {
                return this.$$delegate_0.mo372getExtendedTouchPaddingNHjbRc();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return this.$$delegate_0.getFontScale();
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            public boolean getInterceptOutOfBoundsChildEvents() {
                return this.$$delegate_0.getInterceptOutOfBoundsChildEvents();
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            /* renamed from: getSize-YbymL2g, reason: not valid java name */
            public long getBoundsSize() {
                return this.$$delegate_0.getBoundsSize();
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            public ViewConfiguration getViewConfiguration() {
                return this.$$delegate_0.getViewConfiguration();
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
            public int mo374roundToPxR2X_6o(long j5) {
                return this.$$delegate_0.mo374roundToPxR2X_6o(j5);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: roundToPx-0680j_4, reason: not valid java name */
            public int mo375roundToPx0680j_4(float f) {
                return this.$$delegate_0.mo375roundToPx0680j_4(f);
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputScope
            public void setInterceptOutOfBoundsChildEvents(boolean z10) {
                this.$$delegate_0.setInterceptOutOfBoundsChildEvents(z10);
            }

            @Override // androidx.compose.foundation.draganddrop.DragAndDropSourceScope
            public void startTransfer(DragAndDropTransferData transferData) {
                this.$dragAndDropModifierNode.mo3644drag12SF9DM(transferData, IntSizeKt.m7027toSizeozmzZPI(getBoundsSize()), this.this$0.getDrawDragDecoration());
            }

            @Override // androidx.compose.ui.unit.FontScaling
            @Stable
            /* renamed from: toDp-GaN1DYA, reason: not valid java name */
            public float mo376toDpGaN1DYA(long j5) {
                return this.$$delegate_0.mo376toDpGaN1DYA(j5);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toDp-u2uoSUM, reason: not valid java name */
            public float mo377toDpu2uoSUM(float f) {
                return this.$$delegate_0.mo377toDpu2uoSUM(f);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
            public long mo379toDpSizekrfVVM(long j5) {
                return this.$$delegate_0.mo379toDpSizekrfVVM(j5);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toPx--R2X_6o, reason: not valid java name */
            public float mo380toPxR2X_6o(long j5) {
                return this.$$delegate_0.mo380toPxR2X_6o(j5);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toPx-0680j_4, reason: not valid java name */
            public float mo381toPx0680j_4(float f) {
                return this.$$delegate_0.mo381toPx0680j_4(f);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            public Rect toRect(DpRect dpRect) {
                return this.$$delegate_0.toRect(dpRect);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
            public long mo382toSizeXkaWNTQ(long j5) {
                return this.$$delegate_0.mo382toSizeXkaWNTQ(j5);
            }

            @Override // androidx.compose.ui.unit.FontScaling
            @Stable
            /* renamed from: toSp-0xMU5do, reason: not valid java name */
            public long mo383toSp0xMU5do(float f) {
                return this.$$delegate_0.mo383toSp0xMU5do(f);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
            public long mo384toSpkPz2Gy4(float f) {
                return this.$$delegate_0.mo384toSpkPz2Gy4(f);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toDp-u2uoSUM, reason: not valid java name */
            public float mo378toDpu2uoSUM(int i) {
                return this.$$delegate_0.mo378toDpu2uoSUM(i);
            }

            @Override // androidx.compose.ui.unit.Density
            @Stable
            /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
            public long mo385toSpkPz2Gy4(int i) {
                return this.$$delegate_0.mo385toSpkPz2Gy4(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DragAndDropModifierNode dragAndDropModifierNode, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$dragAndDropModifierNode = dragAndDropModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = DragAndDropSourceNode.this.new AnonymousClass1(this.$dragAndDropModifierNode, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                n dragAndDropSourceHandler = DragAndDropSourceNode.this.getDragAndDropSourceHandler();
                C00141 c00141 = new C00141(pointerInputScope, this.$dragAndDropModifierNode, DragAndDropSourceNode.this);
                this.label = 1;
                if (dragAndDropSourceHandler.invoke(c00141, this) == coroutineSingletons) {
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

    public DragAndDropSourceNode(k kVar, n nVar) {
        this.drawDragDecoration = kVar;
        this.dragAndDropSourceHandler = nVar;
        delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1((DragAndDropModifierNode) delegate(DragAndDropNodeKt.DragAndDropModifierNode()), null)));
    }

    public final n getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final k getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo371onRemeasuredozmzZPI(long size) {
        this.size = size;
    }

    public final void setDragAndDropSourceHandler(n nVar) {
        this.dragAndDropSourceHandler = nVar;
    }

    public final void setDrawDragDecoration(k kVar) {
        this.drawDragDecoration = kVar;
    }
}
