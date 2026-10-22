package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;
import org.java_websocket.WebSocketImpl;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ@\u0010#\u001a\u00020\u000f2.\u0010\"\u001a*\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001eH¦@¢\u0006\u0004\b#\u0010$J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H&ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H&ø\u0001\u0000¢\u0006\u0004\b,\u0010(J\u000f\u0010.\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u000fH\u0016¢\u0006\u0004\b0\u0010\u0011J*\u00109\u001a\u00020\u000f2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u00020\u000fH\u0016¢\u0006\u0004\b:\u0010\u0011J\r\u0010;\u001a\u00020\u000f¢\u0006\u0004\b;\u0010\u0011JO\u0010=\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010<\u001a\u00020\u0006¢\u0006\u0004\b=\u0010>R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010?R<\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0007\u0010A\u001a\u0004\bB\u0010CR$\u0010\b\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00068\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\b\u0010D\u001a\u0004\bE\u0010/R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\n\u0010F\u001a\u0004\bG\u0010HR \u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010AR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010DR\u0018\u0010R\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010S\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006T"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "canDrag", "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/gestures/Orientation;", "orientationLock", AppAgent.CONSTRUCT, "(LS7/k;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "LC7/r;", "startListeningForEvents", "()V", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "initializePointerInputNode", "()Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", NotificationCompat.CATEGORY_EVENT, "processDragStart", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "processDragStop", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;LH7/c;)Ljava/lang/Object;", "processDragCancel", "(LH7/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "LH7/c;", "", "forEachDelta", "drag", "(LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/geometry/Offset;", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStarted", "Landroidx/compose/ui/unit/Velocity;", "velocity", "onDragStopped-TH1AsA0", "onDragStopped", "startDragImmediately", "()Z", "onDetach", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "disposeInteractionSource", "shouldResetPointerInputHandling", "update", "(LS7/k;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;Z)V", "Landroidx/compose/foundation/gestures/Orientation;", "<set-?>", "LS7/k;", "getCanDrag", "()LS7/k;", "Z", "getEnabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "_canDrag", "Lo9/e;", "Landroidx/compose/foundation/gestures/DragEvent;", "channel", "Lo9/e;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "isListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final k _canDrag = new k() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // S7.k
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return (Boolean) this.this$0.getCanDrag().invoke(pointerInputChange);
        }
    };
    private k canDrag;
    private InterfaceC1779e channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;

    @c(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", l = {521}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", l = {523}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00201 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
            final /* synthetic */ n $onDrag;
            final /* synthetic */ a $onDragCancel;
            final /* synthetic */ k $onDragEnd;
            final /* synthetic */ n $onDragStart;
            final /* synthetic */ a $shouldAwaitTouchSlop;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00201(DragGestureNode dragGestureNode, PointerInputScope pointerInputScope, n nVar, k kVar, a aVar, a aVar2, n nVar2, H7.c<? super C00201> cVar) {
                super(2, cVar);
                this.this$0 = dragGestureNode;
                this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
                this.$onDragStart = nVar;
                this.$onDragEnd = kVar;
                this.$onDragCancel = aVar;
                this.$shouldAwaitTouchSlop = aVar2;
                this.$onDrag = nVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00201 c00201 = new C00201(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, cVar);
                c00201.L$0 = obj;
                return c00201;
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r11.label
                    r2 = 1
                    if (r1 == 0) goto L1e
                    if (r1 != r2) goto L16
                    java.lang.Object r0 = r11.L$0
                    r1 = r0
                    m9.z r1 = (m9.InterfaceC1733z) r1
                    kotlin.b.b(r12)     // Catch: java.util.concurrent.CancellationException -> L12
                    goto L5d
                L12:
                    r0 = move-exception
                    r12 = r0
                    r10 = r11
                    goto L4a
                L16:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L1e:
                    kotlin.b.b(r12)
                    java.lang.Object r12 = r11.L$0
                    r1 = r12
                    m9.z r1 = (m9.InterfaceC1733z) r1
                    androidx.compose.foundation.gestures.DragGestureNode r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> L47
                    androidx.compose.foundation.gestures.Orientation r8 = androidx.compose.foundation.gestures.DragGestureNode.access$getOrientationLock$p(r12)     // Catch: java.util.concurrent.CancellationException -> L47
                    androidx.compose.ui.input.pointer.PointerInputScope r3 = r11.$$this$SuspendingPointerInputModifierNode     // Catch: java.util.concurrent.CancellationException -> L47
                    S7.n r4 = r11.$onDragStart     // Catch: java.util.concurrent.CancellationException -> L47
                    S7.k r5 = r11.$onDragEnd     // Catch: java.util.concurrent.CancellationException -> L47
                    S7.a r6 = r11.$onDragCancel     // Catch: java.util.concurrent.CancellationException -> L47
                    S7.a r7 = r11.$shouldAwaitTouchSlop     // Catch: java.util.concurrent.CancellationException -> L47
                    S7.n r9 = r11.$onDrag     // Catch: java.util.concurrent.CancellationException -> L47
                    r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> L47
                    r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L47
                    r10 = r11
                    java.lang.Object r11 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L44
                    if (r11 != r0) goto L5d
                    return r0
                L44:
                    r0 = move-exception
                L45:
                    r12 = r0
                    goto L4a
                L47:
                    r0 = move-exception
                    r10 = r11
                    goto L45
                L4a:
                    androidx.compose.foundation.gestures.DragGestureNode r11 = r10.this$0
                    o9.e r11 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r11)
                    if (r11 == 0) goto L57
                    androidx.compose.foundation.gestures.DragEvent$DragCancelled r0 = androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE
                    r11.a(r0)
                L57:
                    boolean r11 = m9.AbstractC1683A.l(r1)
                    if (r11 == 0) goto L60
                L5d:
                    C7.r r11 = C7.r.f317a
                    return r11
                L60:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00201) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = DragGestureNode.this.new AnonymousClass1(cVar);
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
                final VelocityTracker velocityTracker = new VelocityTracker();
                final DragGestureNode dragGestureNode = DragGestureNode.this;
                n nVar = new n() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        m451invokeUv8p0NA((PointerInputChange) obj2, ((Offset) obj3).m3905unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                    public final void m451invokeUv8p0NA(PointerInputChange pointerInputChange, long j5) {
                        if (((Boolean) dragGestureNode.getCanDrag().invoke(pointerInputChange)).booleanValue()) {
                            if (!dragGestureNode.isListeningForEvents) {
                                if (dragGestureNode.channel == null) {
                                    dragGestureNode.channel = Z6.k.b(Integer.MAX_VALUE, 6, null);
                                }
                                dragGestureNode.startListeningForEvents();
                            }
                            long jM3899minusMKHz9U = Offset.m3899minusMKHz9U(pointerInputChange.getPosition(), OffsetKt.Offset(Offset.m3895getXimpl(j5) * Math.signum(Offset.m3895getXimpl(pointerInputChange.getPosition())), Offset.m3896getYimpl(j5) * Math.signum(Offset.m3896getYimpl(pointerInputChange.getPosition()))));
                            InterfaceC1779e interfaceC1779e = dragGestureNode.channel;
                            if (interfaceC1779e != null) {
                                interfaceC1779e.a(new DragEvent.DragStarted(jM3899minusMKHz9U, null));
                            }
                        }
                    }
                };
                final DragGestureNode dragGestureNode2 = DragGestureNode.this;
                k kVar = new k() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PointerInputChange) obj2);
                        return r.f317a;
                    }

                    public final void invoke(PointerInputChange pointerInputChange) {
                        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                        float maximumFlingVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(dragGestureNode2, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                        long jM5520calculateVelocityAH228Gc = velocityTracker.m5520calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
                        velocityTracker.resetTracking();
                        InterfaceC1779e interfaceC1779e = dragGestureNode2.channel;
                        if (interfaceC1779e != null) {
                            interfaceC1779e.a(new DragEvent.DragStopped(DraggableKt.m466toValidVelocityTH1AsA0(jM5520calculateVelocityAH228Gc), null));
                        }
                    }
                };
                final DragGestureNode dragGestureNode3 = DragGestureNode.this;
                a aVar = new a() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m450invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m450invoke() {
                        InterfaceC1779e interfaceC1779e = dragGestureNode3.channel;
                        if (interfaceC1779e != null) {
                            interfaceC1779e.a(DragEvent.DragCancelled.INSTANCE);
                        }
                    }
                };
                final DragGestureNode dragGestureNode4 = DragGestureNode.this;
                a aVar2 = new a() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Boolean invoke() {
                        return Boolean.valueOf(!dragGestureNode4.getStartDragImmediately());
                    }
                };
                final DragGestureNode dragGestureNode5 = DragGestureNode.this;
                C00201 c00201 = new C00201(DragGestureNode.this, pointerInputScope, nVar, kVar, aVar, aVar2, new n() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        m449invokeUv8p0NA((PointerInputChange) obj2, ((Offset) obj3).m3905unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                    public final void m449invokeUv8p0NA(PointerInputChange pointerInputChange, long j5) {
                        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
                        InterfaceC1779e interfaceC1779e = dragGestureNode5.channel;
                        if (interfaceC1779e != null) {
                            interfaceC1779e.a(new DragEvent.DragDelta(j5, null));
                        }
                    }
                }, null);
                this.label = 1;
                if (AbstractC1683A.f(c00201, this) == coroutineSingletons) {
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

    @c(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", l = {563}, m = "processDragCancel")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C04051(H7.c<? super C04051> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", l = {545, 548}, m = "processDragStart")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C04061(H7.c<? super C04061> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", l = {555}, m = "processDragStop")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C04071(H7.c<? super C04071> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", l = {432, 434, 436, WebSocketImpl.DEFAULT_WSS_PORT, 445, 448}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04081 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        @c(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", l = {439}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "LC7/r;", "processDelta", "<anonymous>", "(LS7/k;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00211 extends SuspendLambda implements n {
            final /* synthetic */ Ref$ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00211(Ref$ObjectRef<DragEvent> ref$ObjectRef, DragGestureNode dragGestureNode, H7.c<? super C00211> cVar) {
                super(2, cVar);
                this.$event = ref$ObjectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00211 c00211 = new C00211(this.$event, this.this$0, cVar);
                c00211.L$0 = obj;
                return c00211;
            }

            @Override // S7.n
            public final Object invoke(k kVar, H7.c<? super r> cVar) {
                return ((C00211) create(kVar, cVar)).invokeSuspend(r.f317a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0047 -> B:25:0x0059). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0053 -> B:24:0x0056). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r1 = r5.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                    java.lang.Object r3 = r5.L$0
                    S7.k r3 = (S7.k) r3
                    kotlin.b.b(r6)
                    goto L56
                L15:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L1d:
                    kotlin.b.b(r6)
                    java.lang.Object r6 = r5.L$0
                    S7.k r6 = (S7.k) r6
                    r3 = r6
                L25:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r6 = r5.$event
                    java.lang.Object r6 = r6.f4920a
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                    if (r1 != 0) goto L5c
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                    if (r1 != 0) goto L5c
                    boolean r1 = r6 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                    r4 = 0
                    if (r1 == 0) goto L39
                    androidx.compose.foundation.gestures.DragEvent$DragDelta r6 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r6
                    goto L3a
                L39:
                    r6 = r4
                L3a:
                    if (r6 == 0) goto L3f
                    r3.invoke(r6)
                L3f:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r5.$event
                    androidx.compose.foundation.gestures.DragGestureNode r6 = r5.this$0
                    o9.e r6 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r6)
                    if (r6 == 0) goto L59
                    r5.L$0 = r3
                    r5.L$1 = r1
                    r5.label = r2
                    java.lang.Object r6 = r6.u(r5)
                    if (r6 != r0) goto L56
                    return r0
                L56:
                    r4 = r6
                    androidx.compose.foundation.gestures.DragEvent r4 = (androidx.compose.foundation.gestures.DragEvent) r4
                L59:
                    r1.f4920a = r4
                    goto L25
                L5c:
                    C7.r r5 = C7.r.f317a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C04081.C00211.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public C04081(H7.c<? super C04081> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C04081 c04081 = DragGestureNode.this.new C04081(cVar);
            c04081.L$0 = obj;
            return c04081;
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x00f9, code lost:
        
            if (r7.processDragCancel(r6) != r0) goto L11;
         */
        /* JADX WARN: Path cross not found for [B:44:0x00d8, B:40:0x00bf], limit reached: 56 */
        /* JADX WARN: Path cross not found for [B:46:0x00dc, B:19:0x005c], limit reached: 56 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[PHI: r1 r3
          0x0032: PHI (r1v14 kotlin.jvm.internal.Ref$ObjectRef) = (r1v6 kotlin.jvm.internal.Ref$ObjectRef), (r1v19 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:13:0x002f, B:36:0x00b6] A[DONT_GENERATE, DONT_INLINE]
          0x0032: PHI (r3v8 m9.z) = (r3v5 m9.z), (r3v11 m9.z) binds: [B:13:0x002f, B:36:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005c A[PHI: r4
          0x005c: PHI (r4v7 m9.z) = (r4v0 m9.z), (r4v3 m9.z), (r4v3 m9.z), (r4v3 m9.z), (r4v5 m9.z), (r4v8 m9.z) binds: [B:18:0x0054, B:45:0x00da, B:47:0x00e9, B:41:0x00d3, B:30:0x008c, B:11:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00bf A[Catch: CancellationException -> 0x00d6, TryCatch #2 {CancellationException -> 0x00d6, blocks: (B:38:0x00b9, B:40:0x00bf, B:44:0x00d8, B:46:0x00dc), top: B:59:0x00b9 }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00d8 A[Catch: CancellationException -> 0x00d6, TryCatch #2 {CancellationException -> 0x00d6, blocks: (B:38:0x00b9, B:40:0x00bf, B:44:0x00d8, B:46:0x00dc), top: B:59:0x00b9 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008c -> B:19:0x005c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d3 -> B:19:0x005c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00da -> B:19:0x005c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00e9 -> B:19:0x005c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00f9 -> B:11:0x0025). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C04081.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C04081) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public DragGestureNode(k kVar, boolean z10, MutableInteractionSource mutableInteractionSource, Orientation orientation) {
        this.orientationLock = orientation;
        this.canDrag = kVar;
        this.enabled = z10;
        this.interactionSource = mutableInteractionSource;
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragCancel(H7.c<? super C7.r> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.DragGestureNode.C04051
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C04051) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r5 = (androidx.compose.foundation.gestures.DragGestureNode) r5
            kotlin.b.b(r6)
            goto L4e
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.b.b(r6)
            androidx.compose.foundation.interaction.DragInteraction$Start r6 = r5.dragInteraction
            if (r6 == 0) goto L51
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.interactionSource
            if (r2 == 0) goto L4e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r4 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r4.<init>(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r2.emit(r4, r0)
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = 0
            r5.dragInteraction = r6
        L51:
            androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r0 = r6.m7093getZero9UxMQ8M()
            r5.mo399onDragStoppedTH1AsA0(r0)
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragCancel(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStart(androidx.compose.foundation.gestures.DragEvent.DragStarted r7, H7.c<? super C7.r> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureNode.C04061
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C04061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.L$2
            androidx.compose.foundation.interaction.DragInteraction$Start r6 = (androidx.compose.foundation.interaction.DragInteraction.Start) r6
            java.lang.Object r7 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStarted r7 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r7
            java.lang.Object r0 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r0 = (androidx.compose.foundation.gestures.DragGestureNode) r0
            kotlin.b.b(r8)
            goto L82
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            androidx.compose.foundation.gestures.DragEvent$DragStarted r7 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r7
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r6 = (androidx.compose.foundation.gestures.DragGestureNode) r6
            kotlin.b.b(r8)
            goto L68
        L4b:
            kotlin.b.b(r8)
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = r6.dragInteraction
            if (r8 == 0) goto L68
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L68
            androidx.compose.foundation.interaction.DragInteraction$Cancel r5 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r5.<init>(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.emit(r5, r0)
            if (r8 != r1) goto L68
            goto L7f
        L68:
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r8.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r6.interactionSource
            if (r2 == 0) goto L84
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r0 = r2.emit(r8, r0)
            if (r0 != r1) goto L80
        L7f:
            return r1
        L80:
            r0 = r6
            r6 = r8
        L82:
            r8 = r6
            r6 = r0
        L84:
            r6.dragInteraction = r8
            long r7 = r7.getStartPoint()
            r6.mo398onDragStartedk4lQ0M(r7)
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStart(androidx.compose.foundation.gestures.DragEvent$DragStarted, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processDragStop(androidx.compose.foundation.gestures.DragEvent.DragStopped r6, H7.c<? super C7.r> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.DragGestureNode.C04071
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C04071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.gestures.DragEvent$DragStopped r6 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r5 = (androidx.compose.foundation.gestures.DragGestureNode) r5
            kotlin.b.b(r7)
            goto L55
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.b.b(r7)
            androidx.compose.foundation.interaction.DragInteraction$Start r7 = r5.dragInteraction
            if (r7 == 0) goto L58
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r5.interactionSource
            if (r2 == 0) goto L55
            androidx.compose.foundation.interaction.DragInteraction$Stop r4 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r4.<init>(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r2.emit(r4, r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r7 = 0
            r5.dragInteraction = r7
        L58:
            long r6 = r6.getVelocity()
            r5.mo399onDragStoppedTH1AsA0(r6)
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStop(androidx.compose.foundation.gestures.DragEvent$DragStopped, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        AbstractC1683A.n(getCoroutineScope(), null, new C04081(null), 3);
    }

    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, k kVar, boolean z10, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z11, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            kVar = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z10 = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        if ((i & 16) != 0) {
            z11 = false;
        }
        boolean z12 = z11;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        k kVar2 = kVar;
        dragGestureNode.update(kVar2, z10, mutableInteractionSource2, orientation, z12);
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start start = this.dragInteraction;
        if (start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(start));
            }
            this.dragInteraction = null;
        }
    }

    public abstract Object drag(n nVar, H7.c<? super r> cVar);

    public final k getCanDrag() {
        return this.canDrag;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    /* renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo398onDragStartedk4lQ0M(long startedPosition);

    /* renamed from: onDragStopped-TH1AsA0 */
    public abstract void mo399onDragStoppedTH1AsA0(long velocity);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo212onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (this.enabled && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo212onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    /* renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public final void update(k canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        this.canDrag = canDrag;
        boolean z10 = true;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode suspendingPointerInputModifierNode2 = this.pointerInputNode;
                if (suspendingPointerInputModifierNode2 != null) {
                    undelegate(suspendingPointerInputModifierNode2);
                }
                this.pointerInputNode = null;
            }
            shouldResetPointerInputHandling = true;
        }
        if (!kotlin.jvm.internal.k.b(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
        } else {
            z10 = shouldResetPointerInputHandling;
        }
        if (!z10 || (suspendingPointerInputModifierNode = this.pointerInputNode) == null) {
            return;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
    }
}
