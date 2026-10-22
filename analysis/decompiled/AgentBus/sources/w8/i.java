package w8;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final h f10902a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10903b;

    public i(h hVar) {
        this.f10902a = hVar;
        this.f10903b = false;
    }

    public static i a(i iVar, h hVar, boolean z4, int i2) {
        if ((i2 & 1) != 0) {
            hVar = iVar.f10902a;
        }
        if ((i2 & 2) != 0) {
            z4 = iVar.f10903b;
        }
        iVar.getClass();
        q7.k.e(hVar, "qualifier");
        return new i(hVar, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f10902a == iVar.f10902a && this.f10903b == iVar.f10903b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iHashCode = this.f10902a.hashCode() * 31;
        boolean z4 = this.f10903b;
        int i2 = z4;
        if (z4 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public final String toString() {
        return "NullabilityQualifierWithMigrationStatus(qualifier=" + this.f10902a + ", isForWarningOnly=" + this.f10903b + ')';
    }

    public i(h hVar, boolean z4) {
        this.f10902a = hVar;
        this.f10903b = z4;
    }
}
