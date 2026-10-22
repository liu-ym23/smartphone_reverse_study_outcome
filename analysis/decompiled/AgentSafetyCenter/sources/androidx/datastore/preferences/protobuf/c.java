package androidx.datastore.preferences.protobuf;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public int f1091c;

    /* renamed from: f, reason: collision with root package name */
    public int f1092f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ f f1093g;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1091c < this.f1092f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        byte bF;
        int i = this.f1091c;
        if (i < this.f1092f) {
            this.f1091c = i + 1;
            bF = this.f1093g.f(i);
        } else {
            g5.f.k();
            bF = 0;
        }
        return Byte.valueOf(bF);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
