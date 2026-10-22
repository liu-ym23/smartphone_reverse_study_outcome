package d7;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class p implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2973f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f2974g;

    public /* synthetic */ p(int i2, Object obj) {
        this.f2973f = i2;
        this.f2974g = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f2973f) {
            case 0:
                return q7.k.h((Object[]) this.f2974g);
            case 1:
                return new d0((Iterator) ((p7.a) this.f2974g).c());
            default:
                return ((fa.j) this.f2974g).iterator();
        }
    }
}
