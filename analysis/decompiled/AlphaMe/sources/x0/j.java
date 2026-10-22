package x0;

import B0.r;
import Z2.F;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class j extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public int f15884a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.palette.b f15885b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f15886c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f15887d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(stepos.support.v7.app.palette.b bVar, r rVar, e eVar, Continuation continuation) {
        super(2, continuation);
        this.f15885b = bVar;
        this.f15886c = rVar;
        this.f15887d = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new j(this.f15885b, this.f15886c, this.f15887d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a5  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.f15884a
            r2 = 1
            if (r1 == 0) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lbb
        L10:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L18:
            kotlin.ResultKt.throwOnFailure(r9)
            stepos.support.v7.app.palette.b r9 = r8.f15885b
            r9.getClass()
            B0.r r1 = r8.f15886c
            java.lang.String r3 = "spec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.util.List r9 = r9.f14577a
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r9 = r9.iterator()
        L34:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L4b
            java.lang.Object r4 = r9.next()
            r5 = r4
            y0.d r5 = (y0.d) r5
            boolean r5 = r5.b(r1)
            if (r5 == 0) goto L34
            r3.add(r4)
            goto L34
        L4b:
            java.util.ArrayList r9 = new java.util.ArrayList
            int r4 = kotlin.collections.CollectionsKt.e(r3)
            r9.<init>(r4)
            java.util.Iterator r3 = r3.iterator()
        L58:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L76
            java.lang.Object r4 = r3.next()
            y0.d r4 = (y0.d) r4
            r4.getClass()
            y0.c r5 = new y0.c
            r6 = 0
            r5.<init>(r4, r6)
            b3.c r4 = new b3.c
            r4.<init>(r5)
            r9.add(r4)
            goto L58
        L76:
            java.util.List r9 = kotlin.collections.CollectionsKt.toList(r9)
            java.util.Collection r9 = (java.util.Collection) r9
            r3 = 0
            b3.h[] r4 = new b3.InterfaceC0379h[r3]
            java.lang.Object[] r9 = r9.toArray(r4)
            b3.h[] r9 = (b3.InterfaceC0379h[]) r9
            x0.h r4 = new x0.h
            r4.<init>(r9)
            b3.l r9 = b3.m.f4416a
            boolean r9 = r4 instanceof b3.InterfaceC0367A
            if (r9 == 0) goto L91
            goto Lab
        L91:
            b3.l r9 = b3.m.f4416a
            b3.k r5 = b3.m.f4417b
            boolean r6 = r4 instanceof b3.C0378g
            if (r6 == 0) goto La5
            r6 = r4
            b3.g r6 = (b3.C0378g) r6
            kotlin.jvm.functions.Function1 r7 = r6.f4406b
            if (r7 != r9) goto La5
            kotlin.jvm.functions.Function2 r9 = r6.f4407c
            if (r9 != r5) goto La5
            goto Lab
        La5:
            b3.g r9 = new b3.g
            r9.<init>(r4)
            r4 = r9
        Lab:
            x0.i r9 = new x0.i
            x0.e r5 = r8.f15887d
            r9.<init>(r3, r5, r1)
            r8.f15884a = r2
            java.lang.Object r8 = r4.collect(r9, r8)
            if (r8 != r0) goto Lbb
            return r0
        Lbb:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
