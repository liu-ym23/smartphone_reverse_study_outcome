package g0;

/* loaded from: classes.dex */
public final class m extends l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3695i;

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3695i) {
            case 0:
                int i2 = this.f3694h;
                this.f3694h = i2 + 2;
                Object[] objArr = this.f3692f;
                return new a(0, objArr[i2], objArr[i2 + 1]);
            case 1:
                int i10 = this.f3694h;
                this.f3694h = i10 + 2;
                return this.f3692f[i10];
            default:
                int i11 = this.f3694h;
                this.f3694h = i11 + 2;
                return this.f3692f[i11 + 1];
        }
    }
}
