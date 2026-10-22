package y9;

import java.util.ArrayList;
import java.util.Iterator;
import kb.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16056a;

    /* renamed from: b, reason: collision with root package name */
    public Object f16057b;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList a() {
        ?? r22 = this.f16057b;
        ArrayList arrayList = new ArrayList(m.m0(r22, 10));
        Iterator it = r22.iterator();
        while (it.hasNext()) {
            arrayList.add(((h) it.next()).f16054a);
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable, java.lang.Object] */
    public final void b() {
        Iterator it = this.f16057b.iterator();
        while (it.hasNext()) {
            try {
                ((h) it.next()).f16055b.a();
            } catch (Throwable th) {
                id.c.l(th);
            }
        }
    }
}
