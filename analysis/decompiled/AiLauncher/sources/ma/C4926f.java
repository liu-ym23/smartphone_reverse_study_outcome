package ma;

/* renamed from: ma.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4926f {

    /* renamed from: a, reason: collision with root package name */
    public final ga.b f37191a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37192b;

    public C4926f(ga.b classId, int i10) {
        kotlin.jvm.internal.p.i(classId, "classId");
        this.f37191a = classId;
        this.f37192b = i10;
    }

    public final ga.b a() {
        return this.f37191a;
    }

    public final int b() {
        return this.f37192b;
    }

    public final int c() {
        return this.f37192b;
    }

    public final ga.b d() {
        return this.f37191a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4926f)) {
            return false;
        }
        C4926f c4926f = (C4926f) obj;
        return kotlin.jvm.internal.p.d(this.f37191a, c4926f.f37191a) && this.f37192b == c4926f.f37192b;
    }

    public int hashCode() {
        return (this.f37191a.hashCode() * 31) + Integer.hashCode(this.f37192b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f37192b;
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("kotlin/Array<");
        }
        sb2.append(this.f37191a);
        int i12 = this.f37192b;
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(">");
        }
        return sb2.toString();
    }
}
