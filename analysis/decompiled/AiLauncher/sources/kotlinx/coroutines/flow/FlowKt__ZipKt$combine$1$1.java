package kotlinx.coroutines.flow;

import Xa.c;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", "LXa/c;", "", "", "it", "LY8/t;", "<anonymous>", "(LXa/c;Lkotlin/Array;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {29, 29}, m = "invokeSuspend", v = 1)
/* loaded from: classes5.dex */
public final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements q<c<? super R>, Object[], InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f36604a;

    /* renamed from: b, reason: collision with root package name */
    public int f36605b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f36606c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f36607d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q<T1, T2, InterfaceC4014c<? super R>, Object> f36608e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(q<? super T1, ? super T2, ? super InterfaceC4014c<? super R>, ? extends Object> qVar, InterfaceC4014c<? super FlowKt__ZipKt$combine$1$1> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.f36608e = qVar;
    }

    @Override // p9.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(c<? super R> cVar, Object[] objArr, InterfaceC4014c<? super t> interfaceC4014c) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.f36608e, interfaceC4014c);
        flowKt__ZipKt$combine$1$1.f36606c = cVar;
        flowKt__ZipKt$combine$1$1.f36607d = objArr;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        if (r3.emit(r9, r8) == r2) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f36606c
            Xa.c r0 = (Xa.c) r0
            java.lang.Object r1 = r8.f36607d
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r8.f36605b
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L2a
            if (r3 == r5) goto L22
            if (r3 != r4) goto L1a
            kotlin.C4849c.b(r9)
            goto L64
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L22:
            java.lang.Object r3 = r8.f36604a
            Xa.c r3 = (Xa.c) r3
            kotlin.C4849c.b(r9)
            goto L4c
        L2a:
            kotlin.C4849c.b(r9)
            p9.q<T1, T2, e9.c<? super R>, java.lang.Object> r9 = r8.f36608e
            r3 = 0
            r3 = r1[r3]
            r6 = r1[r5]
            java.lang.Object r7 = g9.h.a(r0)
            r8.f36606c = r7
            java.lang.Object r7 = g9.h.a(r1)
            r8.f36607d = r7
            r8.f36604a = r0
            r8.f36605b = r5
            java.lang.Object r9 = r9.invoke(r3, r6, r8)
            if (r9 != r2) goto L4b
            goto L63
        L4b:
            r3 = r0
        L4c:
            java.lang.Object r0 = g9.h.a(r0)
            r8.f36606c = r0
            java.lang.Object r0 = g9.h.a(r1)
            r8.f36607d = r0
            r0 = 0
            r8.f36604a = r0
            r8.f36605b = r4
            java.lang.Object r8 = r3.emit(r9, r8)
            if (r8 != r2) goto L64
        L63:
            return r2
        L64:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
