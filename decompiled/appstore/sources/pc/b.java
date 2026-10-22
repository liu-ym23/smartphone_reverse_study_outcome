package pc;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f23448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23450e;

    public b(float r10, int r11, float r12, int r13, float r14) {
        this.f23446a = r10;
        this.f23447b = r11;
        this.f23448c = r12;
        this.f23449d = r13;
        this.f23450e = r14;
    }

    public static b b(b r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new b(r10.f23446a, r10.f23447b, r10.f23448c, r10.f23449d, r10.f23450e);
    }

    public b a() {
        return b(this);
    }

    public float c() {
        return this.f23448c;
    }

    public float d() {
        return this.f23446a;
    }

    public int e() {
        return this.f23449d;
    }

    public int f() {
        return this.f23447b;
    }

    public float g() {
        return this.f23450e;
    }
}
