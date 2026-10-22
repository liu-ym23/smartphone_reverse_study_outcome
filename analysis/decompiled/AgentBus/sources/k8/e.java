package k8;

import java.util.ArrayList;
import l8.s;
import q7.k;
import r9.l;

/* loaded from: classes.dex */
public final class e implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final e f5655b = new e();

    /* renamed from: c, reason: collision with root package name */
    public static final e f5656c = new e();

    @Override // r9.l
    public void a(f8.c cVar) {
        k.e(cVar, "descriptor");
        throw new IllegalStateException("Cannot infer visibility for " + cVar);
    }

    @Override // r9.l
    public void b(f8.e eVar, ArrayList arrayList) {
        throw new IllegalStateException("Incomplete hierarchy for class " + eVar.getName() + ", unresolved classes " + arrayList);
    }

    public g c(v8.c cVar) {
        k.e(cVar, "javaElement");
        return new g((s) cVar);
    }
}
