package g1;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f19884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19886e;

    public f(int r10, int r11, long r12, int r13) {
        this.f19886e = 1;
        this.f19882a = r10;
        this.f19883b = r11;
        this.f19885d = r13;
        this.f19884c = r12;
    }

    public void a(long r10) {
        this.f19886e++;
        this.f19883b = (int) (((long) this.f19883b) + r10);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof f) == false) goto L10;
        f r11 = (f) r10;
        if (r11.f19882a == this.f19882a) goto L7;
        return false;
    L7:
        if (r11.f19885d != this.f19885d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.f19885d + "," + this.f19882a + "," + this.f19886e + "," + this.f19883b + "," + this.f19884c;
    }
}
