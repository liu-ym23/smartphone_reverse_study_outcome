package kotlinx.coroutines;

import C7.r;
import S7.n;
import i9.k;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import m9.l0;

@J7.c(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {1003, 1005}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Li9/k;", "Lm9/c0;", "LC7/r;", "<anonymous>", "(Li9/k;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class JobSupport$children$1 extends RestrictedSuspendLambda implements n {

    /* renamed from: a, reason: collision with root package name */
    public l0 f5178a;
    public kotlinx.coroutines.internal.a b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(H7.c cVar, c cVar2) {
        super(2, cVar);
        this.e = cVar2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c create(Object obj, H7.c cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(cVar, this.e);
        jobSupport$children$1.d = obj;
        return jobSupport$children$1;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((JobSupport$children$1) create((k) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0066 -> B:25:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlinx.coroutines.internal.a r1 = r5.b
            m9.l0 r3 = r5.f5178a
            java.lang.Object r4 = r5.d
            i9.k r4 = (i9.k) r4
            kotlin.b.b(r6)
            goto L7b
        L18:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L20:
            kotlin.b.b(r6)
            goto L80
        L24:
            kotlin.b.b(r6)
            java.lang.Object r6 = r5.d
            i9.k r6 = (i9.k) r6
            kotlinx.coroutines.c r1 = r5.e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.c.f5183a
            java.lang.Object r1 = r4.get(r1)
            boolean r4 = r1 instanceof m9.C1722o
            if (r4 == 0) goto L41
            m9.o r1 = (m9.C1722o) r1
            kotlinx.coroutines.c r1 = r1.e
            r5.c = r3
            r6.a(r5, r1)
            return r0
        L41:
            boolean r3 = r1 instanceof m9.InterfaceC1706Y
            if (r3 == 0) goto L80
            m9.Y r1 = (m9.InterfaceC1706Y) r1
            m9.l0 r1 = r1.b()
            if (r1 == 0) goto L80
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = kotlinx.coroutines.internal.a.f5251a
            java.lang.Object r3 = r3.get(r1)
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.k.d(r3, r4)
            kotlinx.coroutines.internal.a r3 = (kotlinx.coroutines.internal.a) r3
            r4 = r3
            r3 = r1
            r1 = r4
            r4 = r6
        L5e:
            boolean r6 = r1.equals(r3)
            if (r6 != 0) goto L80
            boolean r6 = r1 instanceof m9.C1722o
            if (r6 == 0) goto L7b
            r6 = r1
            m9.o r6 = (m9.C1722o) r6
            kotlinx.coroutines.c r6 = r6.e
            r5.d = r4
            r5.f5178a = r3
            r5.b = r1
            r5.c = r2
            r4.a(r5, r6)
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            return r0
        L7b:
            kotlinx.coroutines.internal.a r1 = r1.f()
            goto L5e
        L80:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
