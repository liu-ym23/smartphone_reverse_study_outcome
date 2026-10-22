package v5;

import a6.w;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    public static final k f5986c = new k(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final l f5987a;

    /* renamed from: b, reason: collision with root package name */
    public final i f5988b;

    public k(l lVar, f0 f0Var) {
        String str;
        this.f5987a = lVar;
        this.f5988b = f0Var;
        if ((lVar == null) == (f0Var == null)) {
            return;
        }
        if (lVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + lVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f5987a == kVar.f5987a && p.a(this.f5988b, kVar.f5988b);
    }

    public final int hashCode() {
        l lVar = this.f5987a;
        int iHashCode = (lVar == null ? 0 : lVar.hashCode()) * 31;
        i iVar = this.f5988b;
        return iHashCode + (iVar != null ? iVar.hashCode() : 0);
    }

    public final String toString() {
        l lVar = this.f5987a;
        int i8 = lVar == null ? -1 : j.f5985a[lVar.ordinal()];
        if (i8 == -1) {
            return "*";
        }
        i iVar = this.f5988b;
        if (i8 == 1) {
            return String.valueOf(iVar);
        }
        if (i8 == 2) {
            return "in " + iVar;
        }
        if (i8 != 3) {
            throw new w();
        }
        return "out " + iVar;
    }
}
