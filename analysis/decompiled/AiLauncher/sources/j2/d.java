package j2;

import f2.InterfaceC4049d;
import java.util.concurrent.Executor;
import k2.o;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public final class d implements g2.b<c> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Executor> f34505a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4049d> f34506b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<o> f34507c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<InterfaceC4863c> f34508d;

    /* renamed from: e, reason: collision with root package name */
    public final X8.a<InterfaceC4893a> f34509e;

    public d(X8.a<Executor> aVar, X8.a<InterfaceC4049d> aVar2, X8.a<o> aVar3, X8.a<InterfaceC4863c> aVar4, X8.a<InterfaceC4893a> aVar5) {
        this.f34505a = aVar;
        this.f34506b = aVar2;
        this.f34507c = aVar3;
        this.f34508d = aVar4;
        this.f34509e = aVar5;
    }

    public static d a(X8.a<Executor> aVar, X8.a<InterfaceC4049d> aVar2, X8.a<o> aVar3, X8.a<InterfaceC4863c> aVar4, X8.a<InterfaceC4893a> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, InterfaceC4049d interfaceC4049d, o oVar, InterfaceC4863c interfaceC4863c, InterfaceC4893a interfaceC4893a) {
        return new c(executor, interfaceC4049d, oVar, interfaceC4863c, interfaceC4893a);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f34505a.get(), this.f34506b.get(), this.f34507c.get(), this.f34508d.get(), this.f34509e.get());
    }
}
