package h7;

import g7.l;
import p7.n;
import q7.k;
import q7.z;
import w7.e0;

/* loaded from: classes.dex */
public final class c extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public int f4219f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ n f4220g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g7.d f4221h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g7.d dVar, l lVar, n nVar, g7.d dVar2) {
        super(dVar, lVar);
        this.f4220g = nVar;
        this.f4221h = dVar2;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        int i2 = this.f4219f;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f4219f = 2;
            e0.N(obj);
            return obj;
        }
        this.f4219f = 1;
        e0.N(obj);
        n nVar = this.f4220g;
        k.c(nVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        z.c(2, nVar);
        return nVar.invoke(this.f4221h, this);
    }
}
