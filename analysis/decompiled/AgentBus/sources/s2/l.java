package s2;

import ia.f1;
import ia.g1;
import ia.w1;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class l extends i7.i implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ w1 f9399f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(w1 w1Var, g7.d dVar) {
        super(3, dVar);
        this.f9399f = w1Var;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        w7.e0.N(obj);
        f1.cancel$default((g1) this.f9399f, (CancellationException) null, 1, (Object) null);
        return c7.r.f1986a;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        l lVar = new l(this.f9399f, (g7.d) obj3);
        c7.r rVar = c7.r.f1986a;
        lVar.invokeSuspend(rVar);
        return rVar;
    }
}
