package kotlinx.coroutines.flow;

import C7.r;
import S7.o;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.s;

@J7.c(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {174, 176, 178, 179, 181}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lp9/d;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "LC7/r;", "<anonymous>", "(Lp9/d;I)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes4.dex */
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements o {

    /* renamed from: a, reason: collision with root package name */
    public int f5221a;
    public /* synthetic */ p9.d b;
    public /* synthetic */ int c;
    public final /* synthetic */ s d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(s sVar, H7.c cVar) {
        super(3, cVar);
        this.d = sVar;
    }

    @Override // S7.o
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int iIntValue = ((Number) obj2).intValue();
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.d, (H7.c) obj3);
        startedWhileSubscribed$command$1.b = (p9.d) obj;
        startedWhileSubscribed$command$1.c = iIntValue;
        return startedWhileSubscribed$command$1.invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r1.emit(r8, r7) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        if (r1.emit(r8, r7) != r0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062 A[PHI: r1
      0x0062: PHI (r1v3 p9.d) = (r1v2 p9.d), (r1v6 p9.d) binds: [B:25:0x005f, B:13:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072 A[PHI: r1
      0x0072: PHI (r1v4 p9.d) = (r1v3 p9.d), (r1v7 p9.d) binds: [B:28:0x006f, B:12:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r7.f5221a
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L34
            if (r1 == r6) goto L30
            if (r1 == r5) goto L2a
            if (r1 == r4) goto L24
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            goto L30
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1e:
            p9.d r1 = r7.b
            kotlin.b.b(r8)
            goto L72
        L24:
            p9.d r1 = r7.b
            kotlin.b.b(r8)
            goto L62
        L2a:
            p9.d r1 = r7.b
            kotlin.b.b(r8)
            goto L55
        L30:
            kotlin.b.b(r8)
            goto L80
        L34:
            kotlin.b.b(r8)
            p9.d r1 = r7.b
            int r8 = r7.c
            if (r8 <= 0) goto L48
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.f5220a
            r7.f5221a = r6
            java.lang.Object r7 = r1.emit(r8, r7)
            if (r7 != r0) goto L80
            goto L7f
        L48:
            r7.b = r1
            r7.f5221a = r5
            r5 = 0
            java.lang.Object r8 = kotlinx.coroutines.a.f(r5, r7)
            if (r8 != r0) goto L55
            goto L7f
        L55:
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.b
            r7.b = r1
            r7.f5221a = r4
            java.lang.Object r8 = r1.emit(r8, r7)
            if (r8 != r0) goto L62
            goto L7f
        L62:
            r7.b = r1
            r7.f5221a = r3
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r8 = kotlinx.coroutines.a.f(r3, r7)
            if (r8 != r0) goto L72
            goto L7f
        L72:
            kotlinx.coroutines.flow.SharingCommand r8 = kotlinx.coroutines.flow.SharingCommand.c
            r3 = 0
            r7.b = r3
            r7.f5221a = r2
            java.lang.Object r7 = r1.emit(r8, r7)
            if (r7 != r0) goto L80
        L7f:
            return r0
        L80:
            C7.r r7 = C7.r.f317a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
