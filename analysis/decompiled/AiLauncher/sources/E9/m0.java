package E9;

/* loaded from: classes5.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2467a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2468b;

    public m0(String name, boolean z10) {
        kotlin.jvm.internal.p.i(name, "name");
        this.f2467a = name;
        this.f2468b = z10;
    }

    public Integer a(m0 visibility) {
        kotlin.jvm.internal.p.i(visibility, "visibility");
        return l0.f2454a.a(this, visibility);
    }

    public String b() {
        return this.f2467a;
    }

    public final boolean c() {
        return this.f2468b;
    }

    public m0 d() {
        return this;
    }

    public final String toString() {
        return b();
    }
}
