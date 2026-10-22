package W2;

/* loaded from: classes.dex */
public abstract class d extends c {

    /* renamed from: k, reason: collision with root package name */
    private String f5740k;

    /* renamed from: l, reason: collision with root package name */
    private String f5741l;

    /* renamed from: m, reason: collision with root package name */
    private String f5742m;

    /* renamed from: n, reason: collision with root package name */
    private String f5743n;

    public d(String str, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Name must not be null");
        }
        this.f5740k = str;
        this.f5741l = str2;
        this.f5742m = str3;
        this.f5743n = str4;
    }

    @Override // W2.c
    public String d() {
        return this.f5742m;
    }

    @Override // W2.c
    public String f() {
        return this.f5741l;
    }

    @Override // W2.c
    public String h() {
        return this.f5740k;
    }

    @Override // W2.c
    public String l() {
        return this.f5743n;
    }
}
