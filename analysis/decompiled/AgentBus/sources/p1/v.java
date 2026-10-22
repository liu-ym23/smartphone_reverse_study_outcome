package p1;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f8373a;

    /* renamed from: b, reason: collision with root package name */
    public final p7.n f8374b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f8375c;

    public v(String str, p7.n nVar) {
        this.f8373a = str;
        this.f8374b = nVar;
    }

    public final void a(i iVar, Object obj) {
        iVar.i(this, obj);
    }

    public final String toString() {
        return "AccessibilityKey: " + this.f8373a;
    }

    public /* synthetic */ v(String str) {
        this(str, r.f8341w);
    }

    public v(String str, int i2) {
        this(str);
        this.f8375c = true;
    }

    public v(String str, boolean z4, p7.n nVar) {
        this(str, nVar);
        this.f8375c = z4;
    }
}
