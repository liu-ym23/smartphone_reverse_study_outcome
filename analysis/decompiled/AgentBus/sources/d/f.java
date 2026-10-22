package d;

import b0.x0;
import c.k;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final x0 f2738a = new x0(this);

    /* renamed from: b, reason: collision with root package name */
    public final e.a f2739b;

    /* renamed from: c, reason: collision with root package name */
    public p7.a f2740c;

    public f(a aVar) {
        this.f2739b = new e.a(this, aVar);
    }

    public final void a(boolean z4) {
        d3.g gVar;
        d3.g gVar2;
        x0 x0Var = this.f2738a;
        x0Var.f1415b = z4;
        Iterator it = ((ArrayList) x0Var.f1414a).iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            boolean z10 = kVar.f1707e && z4;
            if (kVar.f2808b != z10) {
                kVar.f2808b = z10;
                i5.f fVar = kVar.f2809c;
                if (fVar != null && (gVar2 = (d3.g) fVar.f4654h) != null) {
                    gVar2.b();
                }
            }
        }
        e.a aVar = this.f2739b;
        if (aVar.f2808b == z4) {
            return;
        }
        aVar.f2808b = z4;
        i5.f fVar2 = aVar.f2809c;
        if (fVar2 == null || (gVar = (d3.g) fVar2.f4654h) == null) {
            return;
        }
        gVar.b();
    }
}
