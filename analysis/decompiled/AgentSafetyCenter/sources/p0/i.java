package p0;

import java.util.Iterator;
import jb.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends n {

    /* renamed from: f, reason: collision with root package name */
    public b f9670f;

    @Override // jb.n
    public final int a() {
        b bVar = this.f9670f;
        bVar.getClass();
        return bVar.f9659f;
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f9670f.containsValue(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        j jVar = this.f9670f.f9658c;
        k[] kVarArr = new k[8];
        for (int i = 0; i < 8; i++) {
            kVarArr[i] = new l(2);
        }
        return new h(jVar, kVarArr);
    }
}
