package kotlinx.coroutines;

import Ka.l;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LKa/l;", "Lkotlinx/coroutines/g;", "LY8/t;", "<anonymous>", "(LKa/l;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {1003, 1005}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements p<l<? super g>, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36243a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36244b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36245c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36246d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36247e;

    /* renamed from: f, reason: collision with root package name */
    public int f36248f;

    /* renamed from: g, reason: collision with root package name */
    public int f36249g;

    /* renamed from: h, reason: collision with root package name */
    public int f36250h;

    /* renamed from: i, reason: collision with root package name */
    public int f36251i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f36252j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ JobSupport f36253k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, InterfaceC4014c<? super JobSupport$children$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f36253k = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.f36253k, interfaceC4014c);
        jobSupport$children$1.f36252j = obj;
        return jobSupport$children$1;
    }

    @Override // p9.p
    public final Object invoke(l<? super g> lVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((JobSupport$children$1) create(lVar, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        if (r0.a(r2, r11) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
    
        if (r0.a(r12, r11) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b5, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0088 -> B:27:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b3 -> B:27:0x00b6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f36252j
            Ka.l r0 = (Ka.l) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r11.f36251i
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            int r2 = r11.f36249g
            int r4 = r11.f36248f
            java.lang.Object r6 = r11.f36247e
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r6
            java.lang.Object r6 = r11.f36246d
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r6
            java.lang.Object r7 = r11.f36245c
            Za.n r7 = (Za.C1194n) r7
            java.lang.Object r8 = r11.f36244b
            Ua.B0 r8 = (Ua.B0) r8
            java.lang.Object r9 = r11.f36243a
            kotlin.C4849c.b(r12)
            goto Lb6
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            kotlin.C4849c.b(r12)
            goto Lbb
        L3b:
            kotlin.C4849c.b(r12)
            kotlinx.coroutines.JobSupport r12 = r11.f36253k
            java.lang.Object r12 = r12.c0()
            boolean r2 = r12 instanceof Ua.C1079s
            if (r2 == 0) goto L62
            r2 = r12
            Ua.s r2 = (Ua.C1079s) r2
            Ua.t r2 = r2.childJob
            java.lang.Object r3 = g9.h.a(r0)
            r11.f36252j = r3
            java.lang.Object r12 = g9.h.a(r12)
            r11.f36243a = r12
            r11.f36251i = r4
            java.lang.Object r11 = r0.a(r2, r11)
            if (r11 != r1) goto Lbb
            goto Lb5
        L62:
            boolean r2 = r12 instanceof Ua.InterfaceC1077q0
            if (r2 == 0) goto Lbb
            r2 = r12
            Ua.q0 r2 = (Ua.InterfaceC1077q0) r2
            Ua.B0 r2 = r2.getList()
            if (r2 == 0) goto Lbb
            java.lang.Object r4 = r2.j()
            java.lang.String r6 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.p.g(r4, r6)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r9 = r12
            r7 = r2
            r8 = r7
            r6 = r4
            r2 = r5
            r4 = r2
        L80:
            boolean r12 = kotlin.jvm.internal.p.d(r6, r7)
            if (r12 != 0) goto Lbb
            boolean r12 = r6 instanceof Ua.C1079s
            if (r12 == 0) goto Lb6
            r12 = r6
            Ua.s r12 = (Ua.C1079s) r12
            Ua.t r12 = r12.childJob
            r11.f36252j = r0
            java.lang.Object r10 = g9.h.a(r9)
            r11.f36243a = r10
            java.lang.Object r10 = g9.h.a(r8)
            r11.f36244b = r10
            r11.f36245c = r7
            r11.f36246d = r6
            java.lang.Object r10 = g9.h.a(r6)
            r11.f36247e = r10
            r11.f36248f = r4
            r11.f36249g = r2
            r11.f36250h = r5
            r11.f36251i = r3
            java.lang.Object r12 = r0.a(r12, r11)
            if (r12 != r1) goto Lb6
        Lb5:
            return r1
        Lb6:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = r6.k()
            goto L80
        Lbb:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
