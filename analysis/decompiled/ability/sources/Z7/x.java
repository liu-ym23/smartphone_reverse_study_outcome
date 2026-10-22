package Z7;

import b8.l0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.KVariance;

/* loaded from: classes3.dex */
public final class x {
    public static final x c = new x(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final KVariance f1612a;
    public final u b;

    public x(KVariance kVariance, l0 l0Var) {
        String str;
        this.f1612a = kVariance;
        this.b = l0Var;
        if ((kVariance == null) == (l0Var == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
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
        return this.f1612a == xVar.f1612a && kotlin.jvm.internal.k.b(this.b, xVar.b);
    }

    public final int hashCode() {
        KVariance kVariance = this.f1612a;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        u uVar = this.b;
        return iHashCode + (uVar != null ? uVar.hashCode() : 0);
    }

    public final String toString() {
        KVariance kVariance = this.f1612a;
        int i = kVariance == null ? -1 : w.f1611a[kVariance.ordinal()];
        if (i == -1) {
            return "*";
        }
        u uVar = this.b;
        if (i == 1) {
            return String.valueOf(uVar);
        }
        if (i == 2) {
            return "in " + uVar;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + uVar;
    }
}
