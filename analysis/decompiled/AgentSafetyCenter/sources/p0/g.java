package p0;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends kb.h {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9668f;

    /* renamed from: g, reason: collision with root package name */
    public b f9669g;

    public /* synthetic */ g(int i) {
        this.f9668f = i;
    }

    @Override // jb.n
    public final int a() {
        switch (this.f9668f) {
            case 0:
                b bVar = this.f9669g;
                bVar.getClass();
                return bVar.f9659f;
            default:
                b bVar2 = this.f9669g;
                bVar2.getClass();
                return bVar2.f9659f;
        }
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        switch (this.f9668f) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                b bVar = this.f9669g;
                Object obj2 = bVar.get(entry.getKey());
                return obj2 != null ? obj2.equals(entry.getValue()) : entry.getValue() == null && bVar.containsKey(entry.getKey());
            default:
                return this.f9669g.containsKey(obj);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f9668f) {
            case 0:
                j jVar = this.f9669g.f9658c;
                k[] kVarArr = new k[8];
                for (int i = 0; i < 8; i++) {
                    kVarArr[i] = new l(0);
                }
                return new h(jVar, kVarArr);
            default:
                j jVar2 = this.f9669g.f9658c;
                k[] kVarArr2 = new k[8];
                for (int i3 = 0; i3 < 8; i3++) {
                    kVarArr2[i3] = new l(1);
                }
                return new h(jVar2, kVarArr2);
        }
    }
}
