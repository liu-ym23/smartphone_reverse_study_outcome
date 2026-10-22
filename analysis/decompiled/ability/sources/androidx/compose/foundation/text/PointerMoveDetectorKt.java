package androidx.compose.foundation.text;

import C7.r;
import H7.h;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0080@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pointerEventPass", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onMove", "detectMoves", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerEventPass;LS7/k;LH7/c;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerMoveDetectorKt {

    @c(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", l = {41}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ k $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        final /* synthetic */ PointerInputScope $this_detectMoves;
        int label;

        @c(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", l = {44}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements n {
            final /* synthetic */ h $currentContext;
            final /* synthetic */ k $onMove;
            final /* synthetic */ PointerEventPass $pointerEventPass;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(h hVar, PointerEventPass pointerEventPass, k kVar, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$currentContext = hVar;
                this.$pointerEventPass = pointerEventPass;
                this.$onMove = kVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$pointerEventPass, this.$onMove, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // S7.n
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x003e -> B:14:0x0041). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r1 = r7.label
                    r2 = 1
                    if (r1 == 0) goto L1d
                    if (r1 != r2) goto L15
                    java.lang.Object r1 = r7.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                    java.lang.Object r3 = r7.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    kotlin.b.b(r8)
                    goto L41
                L15:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L1d:
                    kotlin.b.b(r8)
                    java.lang.Object r8 = r7.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                    kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                    r1.<init>()
                    r3 = r8
                L2a:
                    H7.h r8 = r7.$currentContext
                    boolean r8 = kotlinx.coroutines.a.k(r8)
                    if (r8 == 0) goto La1
                    androidx.compose.ui.input.pointer.PointerEventPass r8 = r7.$pointerEventPass
                    r7.L$0 = r3
                    r7.L$1 = r1
                    r7.label = r2
                    java.lang.Object r8 = r3.awaitPointerEvent(r8, r7)
                    if (r8 != r0) goto L41
                    return r0
                L41:
                    androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
                    int r4 = r8.getType()
                    androidx.compose.ui.input.pointer.PointerEventType$Companion r5 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                    int r6 = r5.m5376getMove7fucELk()
                    boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m5370equalsimpl0(r4, r6)
                    if (r6 == 0) goto L55
                    r6 = r2
                    goto L5d
                L55:
                    int r6 = r5.m5374getEnter7fucELk()
                    boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m5370equalsimpl0(r4, r6)
                L5d:
                    if (r6 == 0) goto L61
                    r4 = r2
                    goto L69
                L61:
                    int r5 = r5.m5375getExit7fucELk()
                    boolean r4 = androidx.compose.ui.input.pointer.PointerEventType.m5370equalsimpl0(r4, r5)
                L69:
                    if (r4 == 0) goto L2a
                    java.util.List r8 = r8.getChanges()
                    java.lang.Object r8 = D7.v.A0(r8)
                    androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                    long r4 = r8.getPosition()
                    androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3884boximpl(r4)
                    long r4 = r8.m3905unboximpl()
                    java.lang.Object r6 = r1.f4920a
                    boolean r4 = androidx.compose.ui.geometry.Offset.m3891equalsimpl(r4, r6)
                    if (r4 != 0) goto L8a
                    goto L8b
                L8a:
                    r8 = 0
                L8b:
                    if (r8 == 0) goto L2a
                    S7.k r4 = r7.$onMove
                    long r5 = r8.m3905unboximpl()
                    androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3884boximpl(r5)
                    r1.f4920a = r8
                    androidx.compose.ui.geometry.Offset r8 = androidx.compose.ui.geometry.Offset.m3884boximpl(r5)
                    r4.invoke(r8)
                    goto L2a
                La1:
                    C7.r r7 = C7.r.f317a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_detectMoves = pointerInputScope;
            this.$pointerEventPass = pointerEventPass;
            this.$onMove = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                h context = getContext();
                PointerInputScope pointerInputScope = this.$this_detectMoves;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, this.$pointerEventPass, this.$onMove, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public static final Object detectMoves(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, k kVar, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(pointerInputScope, pointerEventPass, kVar, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public static /* synthetic */ Object detectMoves$default(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, k kVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Initial;
        }
        return detectMoves(pointerInputScope, pointerEventPass, kVar, cVar);
    }
}
