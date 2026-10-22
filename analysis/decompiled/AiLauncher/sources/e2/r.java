package e2;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public class r implements q {

    /* renamed from: e, reason: collision with root package name */
    public static volatile s f32283e;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4936a f32284a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC4936a f32285b;

    /* renamed from: c, reason: collision with root package name */
    public final j2.e f32286c;

    /* renamed from: d, reason: collision with root package name */
    public final k2.i f32287d;

    public r(InterfaceC4936a interfaceC4936a, InterfaceC4936a interfaceC4936a2, j2.e eVar, k2.i iVar, k2.m mVar) {
        this.f32284a = interfaceC4936a;
        this.f32285b = interfaceC4936a2;
        this.f32286c = eVar;
        this.f32287d = iVar;
        mVar.a();
    }

    public static r c() {
        s sVar = f32283e;
        if (sVar != null) {
            return sVar.e();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set<b2.b> d(InterfaceC3978e interfaceC3978e) {
        return interfaceC3978e instanceof InterfaceC3979f ? Collections.unmodifiableSet(((InterfaceC3979f) interfaceC3978e).a()) : Collections.singleton(b2.b.b("proto"));
    }

    public static void f(Context context) {
        if (f32283e == null) {
            synchronized (r.class) {
                try {
                    if (f32283e == null) {
                        f32283e = C3977d.g().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // e2.q
    public void a(l lVar, b2.g gVar) {
        this.f32286c.a(lVar.f().e(lVar.c().c()), b(lVar), gVar);
    }

    public final AbstractC3981h b(l lVar) {
        return AbstractC3981h.a().i(this.f32284a.a()).k(this.f32285b.a()).j(lVar.g()).h(new C3980g(lVar.b(), lVar.d())).g(lVar.c().a()).d();
    }

    public k2.i e() {
        return this.f32287d;
    }

    public b2.f g(InterfaceC3978e interfaceC3978e) {
        return new n(d(interfaceC3978e), m.a().b(interfaceC3978e.getName()).c(interfaceC3978e.getExtras()).a(), this);
    }
}
