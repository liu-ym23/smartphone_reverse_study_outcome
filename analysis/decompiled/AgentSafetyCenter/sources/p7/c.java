package p7;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends m7.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9839a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9840b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9841c;

    @Override // m7.n
    public final Object read(u7.a aVar) {
        switch (this.f9839a) {
            case 0:
                if (aVar.Y() == u7.b.f14169m) {
                    aVar.U();
                    return null;
                }
                Collection collection = (Collection) ((o7.o) this.f9841c).b();
                aVar.d();
                while (aVar.H()) {
                    collection.add(((r) this.f9840b).f9894c.read(aVar));
                }
                aVar.n();
                return collection;
            default:
                Class cls = (Class) this.f9840b;
                Object obj = ((w0) this.f9841c).f9914g.read(aVar);
                if (obj == null || cls.isInstance(obj)) {
                    return obj;
                }
                throw new m7.h("Expected a " + cls.getName() + " but was " + obj.getClass().getName() + "; at path " + aVar.F());
        }
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        switch (this.f9839a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    cVar.e();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((r) this.f9840b).write(cVar, it.next());
                    }
                    cVar.n();
                    break;
                } else {
                    cVar.C();
                    break;
                }
            default:
                ((w0) this.f9841c).f9914g.write(cVar, obj);
                break;
        }
    }
}
