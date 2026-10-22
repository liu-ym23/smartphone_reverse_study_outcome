package nb;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6972a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f6973b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6974c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f6975d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6976e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6977f;

    public h(boolean z4, Integer num, boolean z10, Integer num2, boolean z11, boolean z12) {
        this.f6972a = z4;
        this.f6973b = num;
        this.f6974c = z10;
        this.f6975d = num2;
        this.f6976e = z11;
        this.f6977f = z12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f6972a == hVar.f6972a && q7.k.a(this.f6973b, hVar.f6973b) && this.f6974c == hVar.f6974c && q7.k.a(this.f6975d, hVar.f6975d) && this.f6976e == hVar.f6976e && this.f6977f == hVar.f6977f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z4 = this.f6972a;
        int i2 = z4;
        if (z4 != 0) {
            i2 = 1;
        }
        int i10 = i2 * 31;
        Integer num = this.f6973b;
        int iHashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z10 = this.f6974c;
        int i11 = z10;
        if (z10 != 0) {
            i11 = 1;
        }
        int i12 = (iHashCode + i11) * 31;
        Integer num2 = this.f6975d;
        int iHashCode2 = (i12 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z11 = this.f6976e;
        int i13 = z11;
        if (z11 != 0) {
            i13 = 1;
        }
        int i14 = (iHashCode2 + i13) * 31;
        boolean z12 = this.f6977f;
        return i14 + (z12 ? 1 : z12 ? 1 : 0);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f6972a + ", clientMaxWindowBits=" + this.f6973b + ", clientNoContextTakeover=" + this.f6974c + ", serverMaxWindowBits=" + this.f6975d + ", serverNoContextTakeover=" + this.f6976e + ", unknownValues=" + this.f6977f + ')';
    }
}
