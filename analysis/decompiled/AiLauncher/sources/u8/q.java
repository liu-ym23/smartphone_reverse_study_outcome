package u8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import u8.i;

/* loaded from: classes4.dex */
public class q implements i.b {

    /* renamed from: a, reason: collision with root package name */
    public final List<i> f42503a;

    /* renamed from: b, reason: collision with root package name */
    public final List<i> f42504b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<i> f42505c = new HashSet(3);

    public q(List<i> list) {
        this.f42503a = list;
        this.f42504b = new ArrayList(list.size());
    }

    public static <P extends i> P d(List<i> list, Class<P> cls) {
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            P p10 = (P) it.next();
            if (cls.isAssignableFrom(p10.getClass())) {
                return p10;
            }
        }
        return null;
    }

    @Override // u8.i.b
    public <P extends i> P a(Class<P> cls) {
        return (P) e(cls);
    }

    @Override // u8.i.b
    public <P extends i> void b(Class<P> cls, i.a<? super P> aVar) {
        aVar.a(e(cls));
    }

    public final void c(i iVar) {
        if (this.f42504b.contains(iVar)) {
            return;
        }
        if (this.f42505c.contains(iVar)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.f42505c);
        }
        this.f42505c.add(iVar);
        iVar.i(this);
        this.f42505c.remove(iVar);
        if (this.f42504b.contains(iVar)) {
            return;
        }
        if (io.noties.markwon.core.a.class.isAssignableFrom(iVar.getClass())) {
            this.f42504b.add(0, iVar);
        } else {
            this.f42504b.add(iVar);
        }
    }

    public final <P extends i> P e(Class<P> cls) {
        P p10 = (P) d(this.f42504b, cls);
        if (p10 != null) {
            return p10;
        }
        P p11 = (P) d(this.f42503a, cls);
        if (p11 != null) {
            c(p11);
            return p11;
        }
        throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.f42503a);
    }

    public List<i> f() {
        Iterator<i> it = this.f42503a.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        return this.f42504b;
    }
}
