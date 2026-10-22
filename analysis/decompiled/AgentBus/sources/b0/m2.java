package b0;

import kotlinx.coroutines.CoroutineExceptionHandler;

/* loaded from: classes.dex */
public final class m2 extends g7.a implements CoroutineExceptionHandler {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m0.c f1242g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n2 f1243h;

    /* JADX WARN: Illegal instructions before constructor call */
    public m2(m0.c cVar, n2 n2Var) {
        ia.z zVar = ia.z.f5026f;
        this.f1242g = cVar;
        this.f1243h = n2Var;
        super(zVar);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void e(g7.l lVar, Throwable th) throws Throwable {
        m0.c cVar = this.f1242g;
        n2 n2Var = this.f1243h;
        s7.a.m0(th, new c2(2, cVar, n2Var));
        CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) n2Var.f1247f.o(ia.z.f5026f);
        if (coroutineExceptionHandler == null) {
            throw th;
        }
        coroutineExceptionHandler.e(lVar, th);
    }
}
