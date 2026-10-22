package N9;

/* loaded from: classes5.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f5026a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5027b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5028c;

    public v(int i10, int i11, int i12) {
        this.f5026a = i10;
        this.f5027b = i11;
        this.f5028c = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f5026a == vVar.f5026a && this.f5027b == vVar.f5027b && this.f5028c == vVar.f5028c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f5026a) * 31) + Integer.hashCode(this.f5027b)) * 31) + Integer.hashCode(this.f5028c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f5026a);
        sb2.append('.');
        sb2.append(this.f5027b);
        sb2.append('.');
        sb2.append(this.f5028c);
        return sb2.toString();
    }
}
