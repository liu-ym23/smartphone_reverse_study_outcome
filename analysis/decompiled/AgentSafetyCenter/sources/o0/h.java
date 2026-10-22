package o0;

import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends a {

    /* renamed from: g, reason: collision with root package name */
    public f f8992g;

    /* renamed from: h, reason: collision with root package name */
    public int f8993h;
    public j i;

    /* renamed from: j, reason: collision with root package name */
    public int f8994j;

    public final void a() {
        if (this.f8993h != this.f8992g.e()) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // o0.a, java.util.ListIterator
    public final void add(Object obj) {
        a();
        f fVar = this.f8992g;
        fVar.add(this.f8974c, obj);
        this.f8974c++;
        this.f8975f = fVar.a();
        this.f8993h = fVar.e();
        this.f8994j = -1;
        b();
    }

    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void b() {
        f fVar = this.f8992g;
        Object[] objArr = fVar.f8987j;
        if (objArr == null) {
            this.i = null;
            return;
        }
        int i = (fVar.f8989l - 1) & (-32);
        int i3 = this.f8974c;
        if (i3 > i) {
            i3 = i;
        }
        int i10 = (fVar.f8986h / 5) + 1;
        j jVar = this.i;
        if (jVar == null) {
            this.i = new j(objArr, i3, i, i10);
            return;
        }
        jVar.f8974c = i3;
        jVar.f8975f = i;
        jVar.f8997g = i10;
        if (jVar.f8998h.length < i10) {
            jVar.f8998h = new Object[i10];
        }
        jVar.f8998h[0] = objArr;
        ?? r02 = i3 == i ? 1 : 0;
        jVar.i = r02;
        jVar.b(i3 - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        f fVar = this.f8992g;
        a();
        if (!hasNext()) {
            g5.f.k();
            return null;
        }
        int i = this.f8974c;
        this.f8994j = i;
        j jVar = this.i;
        if (jVar == null) {
            Object[] objArr = fVar.f8988k;
            this.f8974c = i + 1;
            return objArr[i];
        }
        if (jVar.hasNext()) {
            this.f8974c++;
            return jVar.next();
        }
        Object[] objArr2 = fVar.f8988k;
        int i3 = this.f8974c;
        this.f8974c = i3 + 1;
        return objArr2[i3 - jVar.f8975f];
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        f fVar = this.f8992g;
        a();
        if (!hasPrevious()) {
            g5.f.k();
            return null;
        }
        int i = this.f8974c;
        this.f8994j = i - 1;
        j jVar = this.i;
        if (jVar == null) {
            Object[] objArr = fVar.f8988k;
            int i3 = i - 1;
            this.f8974c = i3;
            return objArr[i3];
        }
        int i10 = jVar.f8975f;
        if (i <= i10) {
            this.f8974c = i - 1;
            return jVar.previous();
        }
        Object[] objArr2 = fVar.f8988k;
        int i11 = i - 1;
        this.f8974c = i11;
        return objArr2[i11 - i10];
    }

    @Override // o0.a, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        f fVar = this.f8992g;
        a();
        int i = this.f8994j;
        if (i == -1) {
            throw new IllegalStateException();
        }
        fVar.b(i);
        int i3 = this.f8994j;
        if (i3 < this.f8974c) {
            this.f8974c = i3;
        }
        this.f8975f = fVar.a();
        this.f8993h = fVar.e();
        this.f8994j = -1;
        b();
    }

    @Override // o0.a, java.util.ListIterator
    public final void set(Object obj) {
        a();
        int i = this.f8994j;
        if (i == -1) {
            throw new IllegalStateException();
        }
        f fVar = this.f8992g;
        fVar.set(i, obj);
        this.f8993h = fVar.e();
        b();
    }
}
