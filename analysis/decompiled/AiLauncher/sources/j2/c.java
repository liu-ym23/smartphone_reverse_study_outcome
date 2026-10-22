package j2;

import e2.AbstractC3981h;
import e2.m;
import e2.r;
import f2.InterfaceC4049d;
import f2.k;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k2.o;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f34499f = Logger.getLogger(r.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final o f34500a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f34501b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4049d f34502c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC4863c f34503d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC4893a f34504e;

    public c(Executor executor, InterfaceC4049d interfaceC4049d, o oVar, InterfaceC4863c interfaceC4863c, InterfaceC4893a interfaceC4893a) {
        this.f34501b = executor;
        this.f34502c = interfaceC4049d;
        this.f34500a = oVar;
        this.f34503d = interfaceC4863c;
        this.f34504e = interfaceC4893a;
    }

    public static /* synthetic */ Object b(c cVar, m mVar, AbstractC3981h abstractC3981h) {
        cVar.f34503d.s(mVar, abstractC3981h);
        cVar.f34500a.a(mVar, 1);
        return null;
    }

    public static /* synthetic */ void c(c cVar, m mVar, b2.g gVar, AbstractC3981h abstractC3981h) {
        try {
            k kVar = cVar.f34502c.get(mVar.b());
            if (kVar == null) {
                String str = String.format("Transport backend '%s' is not registered", mVar.b());
                f34499f.warning(str);
                gVar.a(new IllegalArgumentException(str));
            } else {
                cVar.f34504e.b(C4762b.a(cVar, mVar, kVar.b(abstractC3981h)));
                gVar.a(null);
            }
        } catch (Exception e10) {
            f34499f.warning("Error scheduling event " + e10.getMessage());
            gVar.a(e10);
        }
    }

    @Override // j2.e
    public void a(m mVar, AbstractC3981h abstractC3981h, b2.g gVar) {
        this.f34501b.execute(RunnableC4761a.a(this, mVar, gVar, abstractC3981h));
    }
}
