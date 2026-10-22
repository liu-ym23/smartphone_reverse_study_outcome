package y4;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f26097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f26098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f26099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f26100d;

    public a() {
        this.f26097a = false;
        this.f26098b = -1;
        this.f26099c = -1;
        this.f26100d = -1;
    }

    public int a() {
        return this.f26098b;
    }

    public long b() {
        long r10 = this.f26099c;
        if (r10 < 0) goto L11;
        long r11 = this.f26100d;
        if (r11 >= 0) goto L7;
        return -1;
    L7:
        if (r10 <= r11) goto L10;
        return -1;
    L10:
        return r11 - r10;
    L11:
        return -1;
    }

    public boolean c() {
        return this.f26097a;
    }

    public void d(long r10) {
        this.f26100d = r10;
    }

    public void e(boolean r10) {
        this.f26097a = r10;
    }

    public void f(int r10) {
        this.f26098b = r10;
    }

    public void g(long r10) {
        this.f26099c = r10;
    }
}
