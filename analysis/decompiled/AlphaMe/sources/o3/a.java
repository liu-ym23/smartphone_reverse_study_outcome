package o3;

/* loaded from: classes2.dex */
public final class a implements n3.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f13804a;

    public a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("A marker name cannot be null");
        }
        this.f13804a = str;
    }

    public final boolean a(n3.e eVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("Other cannot be null");
        }
        if (equals(eVar)) {
            return true;
        }
        synchronized (this) {
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof n3.e)) {
            return this.f13804a.equals(((a) ((n3.e) obj)).f13804a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f13804a.hashCode();
    }

    public final String toString() {
        synchronized (this) {
        }
        return this.f13804a;
    }
}
