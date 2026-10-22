package j0;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q0 extends kotlin.jvm.internal.q implements p5.l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f3414b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a1.w f3415c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(z zVar, a1.w wVar) {
        super(1);
        this.f3414b = zVar;
        this.f3415c = wVar;
    }

    @Override // p5.l
    public final Object invoke(Object obj) throws a6.o0 {
        b5.a0 a0Var;
        b5.a0 a0Var2;
        Throwable th = (Throwable) obj;
        this.f3414b.invoke(th);
        c6.c cVar = (c6.c) this.f3415c.d;
        cVar.j(th, false);
        do {
            Object objI = cVar.i();
            a0Var = null;
            if (objI instanceof c6.i) {
                objI = null;
            }
            a0Var2 = b5.a0.f883a;
            if (objI != null) {
                ((n0) objI).f3398b.f0(th == null ? new CancellationException("DataStore scope was cancelled before updateData could complete") : th);
                a0Var = a0Var2;
            }
        } while (a0Var != null);
        return a0Var2;
    }
}
