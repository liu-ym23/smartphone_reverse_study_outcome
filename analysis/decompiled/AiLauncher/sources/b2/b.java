package b2;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f15249a;

    public b(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f15249a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.f15249a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f15249a.equals(((b) obj).f15249a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15249a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f15249a + "\"}";
    }
}
