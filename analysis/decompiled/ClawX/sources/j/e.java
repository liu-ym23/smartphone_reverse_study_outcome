package j;

import androidx.datastore.preferences.protobuf.z0;
import c5.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends j implements Map {
    public z0 d;

    /* renamed from: e, reason: collision with root package name */
    public b f3288e;

    /* renamed from: f, reason: collision with root package name */
    public d f3289f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(j jVar) {
        super(0);
        int i8 = jVar.f3306c;
        b(this.f3306c + i8);
        if (this.f3306c != 0) {
            for (int i9 = 0; i9 < i8; i9++) {
                put(jVar.f(i9), jVar.i(i9));
            }
        } else if (i8 > 0) {
            l.V(0, jVar.f3304a, 0, this.f3304a, i8);
            l.W(jVar.f3305b, this.f3305b, 0, 0, i8 << 1);
            this.f3306c = i8;
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        z0 z0Var = this.d;
        if (z0Var != null) {
            return z0Var;
        }
        z0 z0Var2 = new z0(1, this);
        this.d = z0Var2;
        return z0Var2;
    }

    public final boolean j(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(Collection collection) {
        int i8 = this.f3306c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i8 != this.f3306c;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f3288e;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f3288e = bVar2;
        return bVar2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f3306c);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f3289f;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.f3289f = dVar2;
        return dVar2;
    }
}
