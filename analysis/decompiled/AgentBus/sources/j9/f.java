package j9;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final e9.b f5406a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5407b;

    public f(e9.b bVar, int i2) {
        this.f5406a = bVar;
        this.f5407b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return q7.k.a(this.f5406a, fVar.f5406a) && this.f5407b == fVar.f5407b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5407b) + (this.f5406a.hashCode() * 31);
    }

    public final String toString() {
        int i2;
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (true) {
            i2 = this.f5407b;
            if (i10 >= i2) {
                break;
            }
            sb2.append("kotlin/Array<");
            i10++;
        }
        sb2.append(this.f5406a);
        for (int i11 = 0; i11 < i2; i11++) {
            sb2.append(">");
        }
        String string = sb2.toString();
        q7.k.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
