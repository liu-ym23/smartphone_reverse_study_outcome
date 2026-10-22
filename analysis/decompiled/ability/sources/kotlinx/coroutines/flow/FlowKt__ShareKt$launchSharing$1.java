package kotlinx.coroutines.flow;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;
import p9.s;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {210, 214, 215, 221}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public int f5214a;
    public final /* synthetic */ s b;
    public final /* synthetic */ p9.c c;
    public final /* synthetic */ i d;
    public final /* synthetic */ Float e;

    @J7.c(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ int f5215a;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(2, cVar);
            anonymousClass1.f5215a = ((Number) obj).intValue();
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(Integer.valueOf(((Number) obj).intValue()), (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            kotlin.b.b(obj);
            return Boolean.valueOf(this.f5215a > 0);
        }
    }

    @J7.c(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {223}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "it", "LC7/r;", "<anonymous>", "(Lkotlinx/coroutines/flow/SharingCommand;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f5216a;
        public /* synthetic */ Object b;
        public final /* synthetic */ p9.c c;
        public final /* synthetic */ i d;
        public final /* synthetic */ Float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p9.c cVar, i iVar, Float f, H7.c cVar2) {
            super(2, cVar2);
            this.c = cVar;
            this.d = iVar;
            this.e = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.c, this.d, this.e, cVar);
            anonymousClass2.b = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create((SharingCommand) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f5216a;
            if (i == 0) {
                kotlin.b.b(obj);
                int iOrdinal = ((SharingCommand) this.b).ordinal();
                i iVar = this.d;
                if (iOrdinal == 0) {
                    this.f5216a = 1;
                    if (this.c.collect(iVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    a5.d dVar = p9.e.b;
                    Float f = this.e;
                    if (f == dVar) {
                        iVar.b();
                        throw null;
                    }
                    iVar.i(f);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharing$1(s sVar, p9.c cVar, i iVar, Float f, H7.c cVar2) {
        super(2, cVar2);
        this.b = sVar;
        this.c = cVar;
        this.d = iVar;
        this.e = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        return new FlowKt__ShareKt$launchSharing$1(this.b, this.c, this.d, this.e, cVar);
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__ShareKt$launchSharing$1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
    
        if (r5.collect(r7, r14) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        if (r5.collect(r7, r14) != r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
    
        if (kotlinx.coroutines.flow.d.d(r15, r1, r14) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r14.f5214a
            r2 = 4
            r3 = 3
            r4 = 1
            p9.c r5 = r14.c
            r6 = 2
            kotlinx.coroutines.flow.i r7 = r14.d
            if (r1 == 0) goto L27
            if (r1 == r4) goto L23
            if (r1 == r6) goto L1f
            if (r1 == r3) goto L23
            if (r1 != r2) goto L17
            goto L23
        L17:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L1f:
            kotlin.b.b(r15)
            goto L50
        L23:
            kotlin.b.b(r15)
            goto L90
        L27:
            kotlin.b.b(r15)
            p9.r r15 = p9.q.f5566a
            p9.s r1 = r14.b
            if (r1 != r15) goto L39
            r14.f5214a = r4
            java.lang.Object r14 = r5.collect(r7, r14)
            if (r14 != r0) goto L90
            goto L8f
        L39:
            p9.r r15 = p9.q.b
            r4 = 0
            if (r1 != r15) goto L59
            q9.l r15 = r7.h()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r6, r4)
            r14.f5214a = r6
            java.lang.Object r15 = kotlinx.coroutines.flow.d.i(r15, r1, r14)
            if (r15 != r0) goto L50
            goto L8f
        L50:
            r14.f5214a = r3
            java.lang.Object r14 = r5.collect(r7, r14)
            if (r14 != r0) goto L90
            goto L8f
        L59:
            q9.l r10 = r7.h()
            kotlinx.coroutines.flow.StartedWhileSubscribed$command$1 r9 = new kotlinx.coroutines.flow.StartedWhileSubscribed$command$1
            r9.<init>(r1, r4)
            int r15 = p9.h.f5560a
            kotlinx.coroutines.flow.internal.d r8 = new kotlinx.coroutines.flow.internal.d
            kotlin.coroutines.EmptyCoroutineContext r11 = kotlin.coroutines.EmptyCoroutineContext.f4908a
            r12 = -2
            kotlinx.coroutines.channels.BufferOverflow r13 = kotlinx.coroutines.channels.BufferOverflow.f5184a
            r8.<init>(r9, r10, r11, r12, r13)
            kotlinx.coroutines.flow.StartedWhileSubscribed$command$2 r15 = new kotlinx.coroutines.flow.StartedWhileSubscribed$command$2
            r15.<init>(r6, r4)
            p9.g r1 = new p9.g
            r1.<init>(r8, r15)
            p9.c r15 = kotlinx.coroutines.flow.d.f(r1)
            p9.c r15 = kotlinx.coroutines.flow.d.f(r15)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            java.lang.Float r3 = r14.e
            r1.<init>(r5, r7, r3, r4)
            r14.f5214a = r2
            java.lang.Object r14 = kotlinx.coroutines.flow.d.d(r15, r1, r14)
            if (r14 != r0) goto L90
        L8f:
            return r0
        L90:
            C7.r r14 = C7.r.f317a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
