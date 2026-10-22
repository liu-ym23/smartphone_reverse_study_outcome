package kotlinx.coroutines.flow;

import C7.r;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {29, 29}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", "Lp9/d;", "", "", "it", "LC7/r;", "<anonymous>", "(Lp9/d;Lkotlin/Array;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class FlowKt__ZipKt$combine$1$1 extends SuspendLambda implements o {

    /* renamed from: a, reason: collision with root package name */
    public int f5218a;
    public /* synthetic */ p9.d b;
    public /* synthetic */ Object[] c;
    public final /* synthetic */ o d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$1$1(o oVar, H7.c cVar) {
        super(3, cVar);
        this.d = oVar;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.d, (H7.c) obj3);
        flowKt__ZipKt$combine$1$1.b = (p9.d) obj;
        flowKt__ZipKt$combine$1$1.c = (Object[]) obj2;
        return flowKt__ZipKt$combine$1$1.invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r1.emit(r6, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.f5218a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r6)
            goto L43
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L18:
            p9.d r1 = r5.b
            kotlin.b.b(r6)
            goto L37
        L1e:
            kotlin.b.b(r6)
            p9.d r1 = r5.b
            java.lang.Object[] r6 = r5.c
            r4 = 0
            r4 = r6[r4]
            r6 = r6[r3]
            r5.b = r1
            r5.f5218a = r3
            S7.o r3 = r5.d
            java.lang.Object r6 = r3.invoke(r4, r6, r5)
            if (r6 != r0) goto L37
            goto L42
        L37:
            r3 = 0
            r5.b = r3
            r5.f5218a = r2
            java.lang.Object r5 = r1.emit(r6, r5)
            if (r5 != r0) goto L43
        L42:
            return r0
        L43:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
