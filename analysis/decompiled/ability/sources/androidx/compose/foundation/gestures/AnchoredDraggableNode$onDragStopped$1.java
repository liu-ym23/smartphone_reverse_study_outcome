package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.ui.unit.Velocity;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", l = {275, 277}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements n {
    final /* synthetic */ long $velocity;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", l = {280}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", ExifInterface.GPS_DIRECTION_TRUE, "availableVelocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        /* synthetic */ long J$0;
        Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, cVar);
            anonymousClass1.J$0 = ((Velocity) obj).getPackedValue();
            return anonymousClass1;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m401invokesFctU(((Velocity) obj).getPackedValue(), (H7.c) obj2);
        }

        /* renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m401invokesFctU(long j5, H7.c<? super Velocity> cVar) {
            return ((AnonymousClass1) create(Velocity.m7073boximpl(j5), cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnchoredDraggableNode anchoredDraggableNode;
            long j5;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                long j6 = this.J$0;
                AnchoredDraggableNode anchoredDraggableNode2 = this.this$0;
                AnchoredDraggableState anchoredDraggableState = anchoredDraggableNode2.state;
                float fM394toFloatTH1AsA0 = this.this$0.m394toFloatTH1AsA0(j6);
                this.L$0 = anchoredDraggableNode2;
                this.J$0 = j6;
                this.label = 1;
                Object obj2 = anchoredDraggableState.settle(fM394toFloatTH1AsA0, this);
                if (obj2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
                anchoredDraggableNode = anchoredDraggableNode2;
                obj = obj2;
                j5 = j6;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j5 = this.J$0;
                anchoredDraggableNode = (AnchoredDraggableNode) this.L$0;
                b.b(obj);
            }
            long jM397toVelocityadjELrA = anchoredDraggableNode.m397toVelocityadjELrA(((Number) obj).floatValue());
            float fRequireOffset = ((AnchoredDraggableNode) this.this$0).state.requireOffset();
            float fMinAnchor = ((AnchoredDraggableNode) this.this$0).state.getAnchors().minAnchor();
            if (fRequireOffset >= ((AnchoredDraggableNode) this.this$0).state.getAnchors().maxAnchor() || fRequireOffset <= fMinAnchor) {
                j5 = jM397toVelocityadjELrA;
            }
            return Velocity.m7073boximpl(j5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j5, H7.c<? super AnchoredDraggableNode$onDragStopped$1> cVar) {
        super(2, cVar);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r9.mo220applyToFlingBMRW4eQ(r3, r1, r8) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r9)
            goto L77
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L18:
            java.lang.Object r8 = r8.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableNode r8 = (androidx.compose.foundation.gestures.AnchoredDraggableNode) r8
            kotlin.b.b(r9)
            goto L4b
        L20:
            kotlin.b.b(r9)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r9 = r8.this$0
            androidx.compose.foundation.OverscrollEffect r9 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r9)
            if (r9 != 0) goto L55
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r9 = r8.this$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r1 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getState$p(r9)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r2 = r8.this$0
            long r4 = r8.$velocity
            long r4 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m386access$reverseIfNeededAH228Gc(r2, r4)
            float r2 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m388access$toFloatTH1AsA0(r2, r4)
            r8.L$0 = r9
            r8.label = r3
            java.lang.Object r8 = r1.settle(r2, r8)
            if (r8 != r0) goto L48
            goto L76
        L48:
            r7 = r9
            r9 = r8
            r8 = r7
        L4b:
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            androidx.compose.foundation.gestures.AnchoredDraggableNode.m391access$toVelocityadjELrA(r8, r9)
            goto L77
        L55:
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r9 = r8.this$0
            androidx.compose.foundation.OverscrollEffect r9 = androidx.compose.foundation.gestures.AnchoredDraggableNode.access$getOverscrollEffect$p(r9)
            kotlin.jvm.internal.k.c(r9)
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r1 = r8.this$0
            long r3 = r8.$velocity
            long r3 = androidx.compose.foundation.gestures.AnchoredDraggableNode.m386access$reverseIfNeededAH228Gc(r1, r3)
            androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 r1 = new androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1
            androidx.compose.foundation.gestures.AnchoredDraggableNode<T> r5 = r8.this$0
            r6 = 0
            r1.<init>(r5, r6)
            r8.label = r2
            java.lang.Object r8 = r9.mo220applyToFlingBMRW4eQ(r3, r1, r8)
            if (r8 != r0) goto L77
        L76:
            return r0
        L77:
            C7.r r8 = C7.r.f317a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
