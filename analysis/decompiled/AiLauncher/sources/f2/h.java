package f2;

import android.content.Context;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class h implements g2.b<g> {

    /* renamed from: a, reason: collision with root package name */
    public final X8.a<Context> f32541a;

    /* renamed from: b, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f32542b;

    /* renamed from: c, reason: collision with root package name */
    public final X8.a<InterfaceC4936a> f32543c;

    public h(X8.a<Context> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<InterfaceC4936a> aVar3) {
        this.f32541a = aVar;
        this.f32542b = aVar2;
        this.f32543c = aVar3;
    }

    public static h a(X8.a<Context> aVar, X8.a<InterfaceC4936a> aVar2, X8.a<InterfaceC4936a> aVar3) {
        return new h(aVar, aVar2, aVar3);
    }

    public static g c(Context context, InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2) {
        return new g(context, interfaceC4936a, interfaceC4936a2);
    }

    @Override // X8.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g get() {
        return c(this.f32541a.get(), this.f32542b.get(), this.f32543c.get());
    }
}
