package T9;

import E9.W;
import Z8.F;
import Z9.InterfaceC1178a;
import Z9.InterfaceC1179b;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import ma.AbstractC4927g;
import w9.InterfaceC5752k;
import xa.C5868k;
import xa.InterfaceC5865h;
import ya.AbstractC5990d0;

/* loaded from: classes5.dex */
public class c implements U9.f {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f5885f = {t.i(new PropertyReference1Impl(c.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final ga.c f5886a;

    /* renamed from: b, reason: collision with root package name */
    public final W f5887b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5865h f5888c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1179b f5889d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f5890e;

    public c(V9.k c10, InterfaceC1178a interfaceC1178a, ga.c fqName) {
        W NO_SOURCE;
        Collection<InterfaceC1179b> collectionG;
        p.i(c10, "c");
        p.i(fqName, "fqName");
        this.f5886a = fqName;
        if (interfaceC1178a == null || (NO_SOURCE = c10.a().t().a(interfaceC1178a)) == null) {
            NO_SOURCE = W.f2444a;
            p.h(NO_SOURCE, "NO_SOURCE");
        }
        this.f5887b = NO_SOURCE;
        this.f5888c = c10.e().i(new b(c10, this));
        this.f5889d = (interfaceC1178a == null || (collectionG = interfaceC1178a.g()) == null) ? null : (InterfaceC1179b) F.r0(collectionG);
        boolean z10 = false;
        if (interfaceC1178a != null && interfaceC1178a.k()) {
            z10 = true;
        }
        this.f5890e = z10;
    }

    public static final AbstractC5990d0 g(V9.k kVar, c cVar) {
        AbstractC5990d0 abstractC5990d0N = kVar.d().g().p(cVar.f()).n();
        p.h(abstractC5990d0N, "getDefaultType(...)");
        return abstractC5990d0N;
    }

    @Override // F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        return kotlin.collections.a.i();
    }

    public final InterfaceC1179b c() {
        return this.f5889d;
    }

    @Override // F9.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC5990d0 getType() {
        return (AbstractC5990d0) C5868k.a(this.f5888c, this, f5885f[0]);
    }

    @Override // F9.c
    public W e() {
        return this.f5887b;
    }

    @Override // F9.c
    public ga.c f() {
        return this.f5886a;
    }

    @Override // U9.f
    public boolean k() {
        return this.f5890e;
    }
}
