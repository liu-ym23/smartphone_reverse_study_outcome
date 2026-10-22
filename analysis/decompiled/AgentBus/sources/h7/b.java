package h7;

import i7.g;
import p7.n;
import q7.k;
import q7.z;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: f, reason: collision with root package name */
    public int f4216f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f4217g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g7.d f4218h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(g7.d dVar, g7.d dVar2, n nVar) {
        super(dVar);
        this.f4217g = nVar;
        this.f4218h = dVar2;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f4216f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f4216f = 2;
            e0.N(obj);
            return obj;
        }
        this.f4216f = 1;
        e0.N(obj);
        n nVar = this.f4217g;
        k.c(nVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        z.c(2, nVar);
        return nVar.invoke(this.f4218h, this);
    }
}
