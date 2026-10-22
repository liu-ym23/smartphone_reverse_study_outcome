package n0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    d f18863a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18864b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18865c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18866d;

    public d(c cVar, int i5, String str, String str2) {
        if (cVar.f18859o == null) {
            cVar.f18859o = this;
        } else {
            cVar.f18860p.f18863a = this;
        }
        cVar.f18860p = this;
        this.f18864b = i5;
        this.f18865c = cVar.h(str);
        this.f18866d = cVar.h(str2);
    }

    int a() {
        return 8;
    }

    void b(C0871a c0871a) {
        c0871a.g(this.f18864b & (-393217)).g(this.f18865c).g(this.f18866d);
        c0871a.g(0);
    }

    public void c() {
    }
}
