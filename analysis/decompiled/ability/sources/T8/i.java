package T8;

import D7.N;
import h8.InterfaceC1522e;
import java.util.Set;

/* loaded from: classes4.dex */
public final class i {
    public static final Set c;

    /* renamed from: a, reason: collision with root package name */
    public final k f1220a;
    public final kotlin.reflect.jvm.internal.impl.storage.b b;

    static {
        G8.c cVarG = e8.n.c.g();
        G8.c cVarE = cVarG.e();
        G8.f fVarF = cVarG.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        c = N.Q(new G8.b(cVarE, fVarF));
    }

    public i(k kVar) {
        this.f1220a = kVar;
        this.b = kVar.f1222a.d(new J4.b(this, 5));
    }

    public final InterfaceC1522e a(G8.b classId, f fVar) {
        kotlin.jvm.internal.k.f(classId, "classId");
        return (InterfaceC1522e) this.b.invoke(new h(classId, fVar));
    }
}
