package ua;

/* renamed from: ua.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5638x<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f42655a;

    /* renamed from: b, reason: collision with root package name */
    public final T f42656b;

    /* renamed from: c, reason: collision with root package name */
    public final T f42657c;

    /* renamed from: d, reason: collision with root package name */
    public final T f42658d;

    /* renamed from: e, reason: collision with root package name */
    public final String f42659e;

    public C5638x(T t10, T t11, T t12, T t13, String filePath) {
        kotlin.jvm.internal.p.i(filePath, "filePath");
        this.f42655a = t10;
        this.f42656b = t11;
        this.f42657c = t12;
        this.f42658d = t13;
        this.f42659e = filePath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5638x)) {
            return false;
        }
        C5638x c5638x = (C5638x) obj;
        return kotlin.jvm.internal.p.d(this.f42655a, c5638x.f42655a) && kotlin.jvm.internal.p.d(this.f42656b, c5638x.f42656b) && kotlin.jvm.internal.p.d(this.f42657c, c5638x.f42657c) && kotlin.jvm.internal.p.d(this.f42658d, c5638x.f42658d) && kotlin.jvm.internal.p.d(this.f42659e, c5638x.f42659e);
    }

    public int hashCode() {
        T t10 = this.f42655a;
        int iHashCode = (t10 == null ? 0 : t10.hashCode()) * 31;
        T t11 = this.f42656b;
        int iHashCode2 = (iHashCode + (t11 == null ? 0 : t11.hashCode())) * 31;
        T t12 = this.f42657c;
        int iHashCode3 = (iHashCode2 + (t12 == null ? 0 : t12.hashCode())) * 31;
        T t13 = this.f42658d;
        return ((iHashCode3 + (t13 != null ? t13.hashCode() : 0)) * 31) + this.f42659e.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f42655a + ", compilerVersion=" + this.f42656b + ", languageVersion=" + this.f42657c + ", expectedVersion=" + this.f42658d + ", filePath=" + this.f42659e + ')';
    }
}
