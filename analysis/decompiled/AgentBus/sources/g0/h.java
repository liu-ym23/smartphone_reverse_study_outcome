package g0;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends d7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3684f;

    /* renamed from: g, reason: collision with root package name */
    public final c f3685g;

    public /* synthetic */ h(c cVar, int i2) {
        this.f3684f = i2;
        this.f3685g = cVar;
    }

    @Override // d7.a
    public final int a() {
        switch (this.f3684f) {
            case 0:
                c cVar = this.f3685g;
                cVar.getClass();
                return cVar.f3674g;
            default:
                c cVar2 = this.f3685g;
                cVar2.getClass();
                return cVar2.f3674g;
        }
    }

    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f3684f) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                c cVar = this.f3685g;
                Object obj2 = cVar.get(key);
                return obj2 != null ? obj2.equals(entry.getValue()) : entry.getValue() == null && cVar.containsKey(entry.getKey());
            default:
                return this.f3685g.containsKey(obj);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3684f) {
            case 0:
                k kVar = this.f3685g.f3673f;
                l[] lVarArr = new l[8];
                for (int i2 = 0; i2 < 8; i2++) {
                    lVarArr[i2] = new m(0);
                }
                return new i(kVar, lVarArr);
            default:
                k kVar2 = this.f3685g.f3673f;
                l[] lVarArr2 = new l[8];
                for (int i10 = 0; i10 < 8; i10++) {
                    lVarArr2[i10] = new m(1);
                }
                return new i(kVar2, lVarArr2);
        }
    }
}
