package w7;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public static final x f10874c = new x(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final y f10875a;

    /* renamed from: b, reason: collision with root package name */
    public final u f10876b;

    public x(y yVar, u uVar) {
        String str;
        this.f10875a = yVar;
        this.f10876b = uVar;
        if ((yVar == null) == (uVar == null)) {
            return;
        }
        if (yVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + yVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f10875a == xVar.f10875a && q7.k.a(this.f10876b, xVar.f10876b);
    }

    public final int hashCode() {
        y yVar = this.f10875a;
        int iHashCode = (yVar == null ? 0 : yVar.hashCode()) * 31;
        u uVar = this.f10876b;
        return iHashCode + (uVar != null ? uVar.hashCode() : 0);
    }

    public final String toString() {
        y yVar = this.f10875a;
        int i2 = yVar == null ? -1 : w.$EnumSwitchMapping$0[yVar.ordinal()];
        if (i2 == -1) {
            return "*";
        }
        u uVar = this.f10876b;
        if (i2 == 1) {
            return String.valueOf(uVar);
        }
        if (i2 == 2) {
            return "in " + uVar;
        }
        if (i2 != 3) {
            throw new a4.u();
        }
        return "out " + uVar;
    }
}
