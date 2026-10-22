package g0;

/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: i, reason: collision with root package name */
    public final ea.g f3696i;

    public n(ea.g gVar) {
        this.f3696i = gVar;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f3694h;
        this.f3694h = i2 + 2;
        Object[] objArr = this.f3692f;
        return new b(this.f3696i, objArr[i2], objArr[i2 + 1]);
    }
}
