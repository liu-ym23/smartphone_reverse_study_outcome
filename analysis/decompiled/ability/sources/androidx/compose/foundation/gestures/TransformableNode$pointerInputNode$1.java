package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import o9.InterfaceC1779e;

@c(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1", f = "Transformable.kt", l = {155}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TransformableNode$pointerInputNode$1 extends SuspendLambda implements n {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TransformableNode this$0;

    @c(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1", f = "Transformable.kt", l = {174}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TransformableNode this$0;

        @c(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1", f = "Transformable.kt", l = {158, 161}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00291 extends SuspendLambda implements n {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ TransformableNode this$0;

            @c(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1", f = "Transformable.kt", l = {166}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00301 extends SuspendLambda implements n {
                final /* synthetic */ Ref$ObjectRef<TransformEvent> $event;
                private /* synthetic */ Object L$0;
                Object L$1;
                int label;
                final /* synthetic */ TransformableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00301(Ref$ObjectRef<TransformEvent> ref$ObjectRef, TransformableNode transformableNode, H7.c<? super C00301> cVar) {
                    super(2, cVar);
                    this.$event = ref$ObjectRef;
                    this.this$0 = transformableNode;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C00301 c00301 = new C00301(this.$event, this.this$0, cVar);
                    c00301.L$0 = obj;
                    return c00301;
                }

                @Override // S7.n
                public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
                    return ((C00301) create(transformScope, cVar)).invokeSuspend(r.f317a);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:20:0x005b). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                    /*
                        r6 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r1 = r6.label
                        r2 = 1
                        if (r1 == 0) goto L1d
                        if (r1 != r2) goto L15
                        java.lang.Object r1 = r6.L$1
                        kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                        java.lang.Object r3 = r6.L$0
                        androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                        kotlin.b.b(r7)
                        goto L5b
                    L15:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L1d:
                        kotlin.b.b(r7)
                        java.lang.Object r7 = r6.L$0
                        androidx.compose.foundation.gestures.TransformScope r7 = (androidx.compose.foundation.gestures.TransformScope) r7
                        r3 = r7
                    L25:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r7 = r6.$event
                        java.lang.Object r7 = r7.f4920a
                        boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStopped
                        if (r1 != 0) goto L5e
                        boolean r1 = r7 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformDelta
                        if (r1 == 0) goto L34
                        androidx.compose.foundation.gestures.TransformEvent$TransformDelta r7 = (androidx.compose.foundation.gestures.TransformEvent.TransformDelta) r7
                        goto L35
                    L34:
                        r7 = 0
                    L35:
                        if (r7 == 0) goto L46
                        float r1 = r7.getZoomChange()
                        long r4 = r7.getPanChange()
                        float r7 = r7.getRotationChange()
                        r3.mo413transformByd4ec7I(r1, r4, r7)
                    L46:
                        kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.TransformEvent> r1 = r6.$event
                        androidx.compose.foundation.gestures.TransformableNode r7 = r6.this$0
                        o9.e r7 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r7)
                        r6.L$0 = r3
                        r6.L$1 = r1
                        r6.label = r2
                        java.lang.Object r7 = r7.u(r6)
                        if (r7 != r0) goto L5b
                        return r0
                    L5b:
                        r1.f4920a = r7
                        goto L25
                    L5e:
                        C7.r r6 = C7.r.f317a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00291.C00301.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00291(TransformableNode transformableNode, H7.c<? super C00291> cVar) {
                super(2, cVar);
                this.this$0 = transformableNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00291 c00291 = new C00291(this.this$0, cVar);
                c00291.L$0 = obj;
                return c00291;
            }

            /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
            
                if (r10.transform(r1, r6, r9) == r0) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0080  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007e -> B:13:0x0034). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) {
                /*
                    r9 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r9.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L2d
                    if (r1 == r3) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r1 = r9.L$0
                    m9.z r1 = (m9.InterfaceC1733z) r1
                    kotlin.b.b(r10)     // Catch: java.util.concurrent.CancellationException -> L13
                L13:
                    r10 = r1
                    goto L34
                L15:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L1d:
                    java.lang.Object r1 = r9.L$2
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                    java.lang.Object r4 = r9.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref$ObjectRef) r4
                    java.lang.Object r5 = r9.L$0
                    m9.z r5 = (m9.InterfaceC1733z) r5
                    kotlin.b.b(r10)
                    goto L57
                L2d:
                    kotlin.b.b(r10)
                    java.lang.Object r10 = r9.L$0
                    m9.z r10 = (m9.InterfaceC1733z) r10
                L34:
                    boolean r1 = m9.AbstractC1683A.l(r10)
                    if (r1 == 0) goto L80
                    kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                    r1.<init>()
                    androidx.compose.foundation.gestures.TransformableNode r4 = r9.this$0
                    o9.e r4 = androidx.compose.foundation.gestures.TransformableNode.access$getChannel$p(r4)
                    r9.L$0 = r10
                    r9.L$1 = r1
                    r9.L$2 = r1
                    r9.label = r3
                    java.lang.Object r4 = r4.u(r9)
                    if (r4 != r0) goto L54
                    goto L7d
                L54:
                    r5 = r10
                    r10 = r4
                    r4 = r1
                L57:
                    r1.f4920a = r10
                    java.lang.Object r10 = r4.f4920a
                    boolean r10 = r10 instanceof androidx.compose.foundation.gestures.TransformEvent.TransformStarted
                    if (r10 == 0) goto L7e
                    androidx.compose.foundation.gestures.TransformableNode r10 = r9.this$0     // Catch: java.util.concurrent.CancellationException -> L7e
                    androidx.compose.foundation.gestures.TransformableState r10 = androidx.compose.foundation.gestures.TransformableNode.access$getState$p(r10)     // Catch: java.util.concurrent.CancellationException -> L7e
                    androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.UserInput     // Catch: java.util.concurrent.CancellationException -> L7e
                    androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1 r6 = new androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$1$1     // Catch: java.util.concurrent.CancellationException -> L7e
                    androidx.compose.foundation.gestures.TransformableNode r7 = r9.this$0     // Catch: java.util.concurrent.CancellationException -> L7e
                    r8 = 0
                    r6.<init>(r4, r7, r8)     // Catch: java.util.concurrent.CancellationException -> L7e
                    r9.L$0 = r5     // Catch: java.util.concurrent.CancellationException -> L7e
                    r9.L$1 = r8     // Catch: java.util.concurrent.CancellationException -> L7e
                    r9.L$2 = r8     // Catch: java.util.concurrent.CancellationException -> L7e
                    r9.label = r2     // Catch: java.util.concurrent.CancellationException -> L7e
                    java.lang.Object r10 = r10.transform(r1, r6, r9)     // Catch: java.util.concurrent.CancellationException -> L7e
                    if (r10 != r0) goto L7e
                L7d:
                    return r0
                L7e:
                    r10 = r5
                    goto L34
                L80:
                    C7.r r9 = C7.r.f317a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1.AnonymousClass1.C00291.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00291) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2", f = "Transformable.kt", l = {176}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.TransformableNode$pointerInputNode$1$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends RestrictedSuspendLambda implements n {
            final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TransformableNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(TransformableNode transformableNode, InterfaceC1733z interfaceC1733z, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.this$0 = transformableNode;
                this.$$this$coroutineScope = interfaceC1733z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$$this$coroutineScope, cVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // S7.n
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                return ((AnonymousClass2) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            b.b(obj);
                            AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            boolean z10 = this.this$0.lockRotationOnZoomPan;
                            InterfaceC1779e interfaceC1779e = this.this$0.channel;
                            k kVar = this.this$0.updatedCanPan;
                            this.label = 1;
                            if (TransformableKt.detectZoom(awaitPointerEventScope, z10, interfaceC1779e, kVar, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            b.b(obj);
                        }
                    } catch (CancellationException e) {
                        if (!AbstractC1683A.l(this.$$this$coroutineScope)) {
                            throw e;
                        }
                    }
                    return r.f317a;
                } finally {
                    this.this$0.channel.a(TransformEvent.TransformStopped.INSTANCE);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PointerInputScope pointerInputScope, TransformableNode transformableNode, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = transformableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$SuspendingPointerInputModifierNode, this.this$0, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                CoroutineStart coroutineStart = CoroutineStart.f5175a;
                AbstractC1683A.n(interfaceC1733z, null, new C00291(this.this$0, null), 1);
                PointerInputScope pointerInputScope = this.$$this$SuspendingPointerInputModifierNode;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, interfaceC1733z, null);
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass2, this) == coroutineSingletons) {
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

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformableNode$pointerInputNode$1(TransformableNode transformableNode, H7.c<? super TransformableNode$pointerInputNode$1> cVar) {
        super(2, cVar);
        this.this$0 = transformableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        TransformableNode$pointerInputNode$1 transformableNode$pointerInputNode$1 = new TransformableNode$pointerInputNode$1(this.this$0, cVar);
        transformableNode$pointerInputNode$1.L$0 = obj;
        return transformableNode$pointerInputNode$1;
    }

    @Override // S7.n
    public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        return ((TransformableNode$pointerInputNode$1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        r rVar = r.f317a;
        if (i == 0) {
            b.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.this$0.enabled) {
                return rVar;
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(pointerInputScope, this.this$0, null);
            this.label = 1;
            if (AbstractC1683A.f(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
        }
        return rVar;
    }
}
