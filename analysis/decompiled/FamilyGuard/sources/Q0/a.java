package Q0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class a implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Set<i> f4867a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f4868b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4869c;

    a() {
    }

    @Override // Q0.h
    public void a(i iVar) {
        this.f4867a.add(iVar);
        if (this.f4869c) {
            iVar.d();
        } else if (this.f4868b) {
            iVar.a();
        } else {
            iVar.g();
        }
    }

    @Override // Q0.h
    public void b(i iVar) {
        this.f4867a.remove(iVar);
    }

    void c() {
        this.f4869c = true;
        Iterator it = X0.k.j(this.f4867a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).d();
        }
    }

    void d() {
        this.f4868b = true;
        Iterator it = X0.k.j(this.f4867a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).a();
        }
    }

    void e() {
        this.f4868b = false;
        Iterator it = X0.k.j(this.f4867a).iterator();
        while (it.hasNext()) {
            ((i) it.next()).g();
        }
    }
}
