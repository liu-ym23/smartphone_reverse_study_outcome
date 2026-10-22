package o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends a {

    /* renamed from: g, reason: collision with root package name */
    public Object[] f8990g;

    /* renamed from: h, reason: collision with root package name */
    public j f8991h;

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        j jVar = this.f8991h;
        if (jVar.hasNext()) {
            this.f8974c++;
            return jVar.next();
        }
        Object[] objArr = this.f8990g;
        int i = this.f8974c;
        this.f8974c = i + 1;
        return objArr[i - jVar.f8975f];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            g5.f.k();
            return null;
        }
        int i = this.f8974c;
        j jVar = this.f8991h;
        int i3 = jVar.f8975f;
        if (i <= i3) {
            this.f8974c = i - 1;
            return jVar.previous();
        }
        Object[] objArr = this.f8990g;
        int i10 = i - 1;
        this.f8974c = i10;
        return objArr[i10 - i3];
    }
}
