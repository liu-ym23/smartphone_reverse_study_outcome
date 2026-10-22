package K;

/* renamed from: K.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0886i extends Z {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3983a;

    public C0886i(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null value");
        }
        this.f3983a = obj;
    }

    @Override // K.Z
    public Object b() {
        return this.f3983a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Z) {
            return this.f3983a.equals(((Z) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f3983a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Identifier{value=" + this.f3983a + "}";
    }
}
