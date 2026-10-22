package bytekn.foundation.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z.b<K, z.a<V>> f21808a;

    public final Collection<V> b() {
        Collection<z.a<V>> r100 = this.f21808a.values();
        ArrayList r101 = new ArrayList();
        Iterator<z.a<V>> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addAll(r102.next());
        goto L4
    L6:
        return r101;
    }

    public d() {
        this.f21808a = new z.b(false);
    }

    public final void a(K r100, V r101) {
        z.a<V> r102 = this.f21808a.get(r100);
        if (r102 != null) goto L5;
        z.a<V> r103 = new z.a(false);
        r103.add(r101);
        this.f21808a.put(r100, r103);
        return;
    L5:
        r102.add(r101);
    }
}
