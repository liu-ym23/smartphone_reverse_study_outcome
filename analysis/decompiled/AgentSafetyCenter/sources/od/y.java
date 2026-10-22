package od;

import java.util.RandomAccess;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends kb.e implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public l[] f9495f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f9496g;

    @Override // jb.n
    public final int a() {
        return this.f9495f.length;
    }

    @Override // jb.n, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof l) {
            return super.contains((l) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f9495f[i];
    }

    @Override // kb.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof l) {
            return super.indexOf((l) obj);
        }
        return -1;
    }

    @Override // kb.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof l) {
            return super.lastIndexOf((l) obj);
        }
        return -1;
    }
}
