package y2;

/* loaded from: classes2.dex */
public final class s extends w {

    /* renamed from: a, reason: collision with root package name */
    public final String f43836a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f43837b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43838c;

    public /* synthetic */ s(String str, boolean z10, int i10, r rVar) {
        this.f43836a = str;
        this.f43837b = z10;
        this.f43838c = i10;
    }

    @Override // y2.w
    public final int a() {
        return this.f43838c;
    }

    @Override // y2.w
    public final String b() {
        return this.f43836a;
    }

    @Override // y2.w
    public final boolean c() {
        return this.f43837b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.f43836a.equals(wVar.b()) && this.f43837b == wVar.c() && this.f43838c == wVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f43836a.hashCode() ^ 1000003;
        return this.f43838c ^ (((iHashCode * 1000003) ^ (true != this.f43837b ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f43836a + ", enableFirelog=" + this.f43837b + ", firelogEventType=" + this.f43838c + "}";
    }
}
