package k2;

import java.util.concurrent.Executor;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public final class n implements g2.b<m> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Executor> f34630a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4863c> f34631b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<o> f34632c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<InterfaceC4893a> f34633d;

    public n(X8.a<Executor> aVar, X8.a<InterfaceC4863c> aVar2, X8.a<o> aVar3, X8.a<InterfaceC4893a> aVar4) {
        this.f34630a = aVar;
        this.f34631b = aVar2;
        this.f34632c = aVar3;
        this.f34633d = aVar4;
    }

    public static n a(X8.a<Executor> aVar, X8.a<InterfaceC4863c> aVar2, X8.a<o> aVar3, X8.a<InterfaceC4893a> aVar4) {
        return new n(aVar, aVar2, aVar3, aVar4);
    }

    public static m c(Executor executor, InterfaceC4863c interfaceC4863c, o oVar, InterfaceC4893a interfaceC4893a) {
        return new m(executor, interfaceC4863c, oVar, interfaceC4893a);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m get() {
        return c(this.f34630a.get(), this.f34631b.get(), this.f34632c.get(), this.f34633d.get());
    }
}
