package k2;

import android.content.Context;
import f2.InterfaceC4049d;
import java.util.concurrent.Executor;
import l2.InterfaceC4863c;
import m2.InterfaceC4893a;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class j implements g2.b<i> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Context> f34617a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4049d> f34618b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<InterfaceC4863c> f34619c;

    /* renamed from: d, reason: collision with root package name */
    public final X8.a<o> f34620d;

    /* renamed from: e, reason: collision with root package name */
    public final X8.a<Executor> f34621e;

    /* renamed from: f, reason: collision with root package name */
    public final X8.a<InterfaceC4893a> f34622f;

    /* renamed from: g, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f34623g;

    public j(X8.a<Context> aVar, X8.a<InterfaceC4049d> aVar2, X8.a<InterfaceC4863c> aVar3, X8.a<o> aVar4, X8.a<Executor> aVar5, X8.a<InterfaceC4893a> aVar6, X8.a<InterfaceC4936a> aVar7) {
        this.f34617a = aVar;
        this.f34618b = aVar2;
        this.f34619c = aVar3;
        this.f34620d = aVar4;
        this.f34621e = aVar5;
        this.f34622f = aVar6;
        this.f34623g = aVar7;
    }

    public static j a(X8.a<Context> aVar, X8.a<InterfaceC4049d> aVar2, X8.a<InterfaceC4863c> aVar3, X8.a<o> aVar4, X8.a<Executor> aVar5, X8.a<InterfaceC4893a> aVar6, X8.a<InterfaceC4936a> aVar7) {
        return new j(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static i c(Context context, InterfaceC4049d interfaceC4049d, InterfaceC4863c interfaceC4863c, o oVar, Executor executor, InterfaceC4893a interfaceC4893a, InterfaceC4936a interfaceC4936a) {
        return new i(context, interfaceC4049d, interfaceC4863c, oVar, executor, interfaceC4893a, interfaceC4936a);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f34617a.get(), this.f34618b.get(), this.f34619c.get(), this.f34620d.get(), this.f34621e.get(), this.f34622f.get(), this.f34623g.get());
    }
}
