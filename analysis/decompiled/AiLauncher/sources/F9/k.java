package F9;

import E9.W;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.p;
import ma.AbstractC4927g;
import ya.AbstractC5990d0;
import ya.S;

/* loaded from: classes5.dex */
public final class k implements c {

    /* renamed from: a, reason: collision with root package name */
    public final C9.j f2614a;

    /* renamed from: b, reason: collision with root package name */
    public final ga.c f2615b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<ga.e, AbstractC4927g<?>> f2616c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2617d;

    /* renamed from: e, reason: collision with root package name */
    public final Y8.h f2618e;

    /* JADX WARN: Multi-variable type inference failed */
    public k(C9.j builtIns, ga.c fqName, Map<ga.e, ? extends AbstractC4927g<?>> allValueArguments, boolean z10) {
        p.i(builtIns, "builtIns");
        p.i(fqName, "fqName");
        p.i(allValueArguments, "allValueArguments");
        this.f2614a = builtIns;
        this.f2615b = fqName;
        this.f2616c = allValueArguments;
        this.f2617d = z10;
        this.f2618e = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new j(this));
    }

    public static final AbstractC5990d0 c(k kVar) {
        return kVar.f2614a.p(kVar.f()).n();
    }

    @Override // F9.c
    public Map<ga.e, AbstractC4927g<?>> a() {
        return this.f2616c;
    }

    @Override // F9.c
    public W e() {
        W NO_SOURCE = W.f2444a;
        p.h(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // F9.c
    public ga.c f() {
        return this.f2615b;
    }

    @Override // F9.c
    public S getType() {
        Object value = this.f2618e.getValue();
        p.h(value, "getValue(...)");
        return (S) value;
    }

    public /* synthetic */ k(C9.j jVar, ga.c cVar, Map map, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this(jVar, cVar, map, (i10 & 8) != 0 ? false : z10);
    }
}
