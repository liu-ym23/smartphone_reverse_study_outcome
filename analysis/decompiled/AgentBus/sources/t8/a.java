package t8;

import java.util.Set;
import m.x;
import q7.k;
import v9.z;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f9772a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9773b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9774c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9775d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f9776e;

    /* renamed from: f, reason: collision with root package name */
    public final z f9777f;

    public a(int i2, int i10, boolean z4, boolean z10, Set set, z zVar) {
        x.t(i2, "howThisTypeIsUsed");
        x.t(i10, "flexibility");
        this.f9772a = i2;
        this.f9773b = i10;
        this.f9774c = z4;
        this.f9775d = z10;
        this.f9776e = set;
        this.f9777f = zVar;
    }

    public static a a(a aVar, int i2, boolean z4, Set set, z zVar, int i10) {
        int i11 = aVar.f9772a;
        if ((i10 & 2) != 0) {
            i2 = aVar.f9773b;
        }
        int i12 = i2;
        if ((i10 & 4) != 0) {
            z4 = aVar.f9774c;
        }
        boolean z10 = z4;
        boolean z11 = aVar.f9775d;
        if ((i10 & 16) != 0) {
            set = aVar.f9776e;
        }
        Set set2 = set;
        if ((i10 & 32) != 0) {
            zVar = aVar.f9777f;
        }
        aVar.getClass();
        x.t(i11, "howThisTypeIsUsed");
        x.t(i12, "flexibility");
        return new a(i11, i12, z10, z11, set2, zVar);
    }

    public final a b(int i2) {
        x.t(i2, "flexibility");
        return a(this, i2, false, null, null, 61);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(aVar.f9777f, this.f9777f) && aVar.f9772a == this.f9772a && aVar.f9773b == this.f9773b && aVar.f9774c == this.f9774c && aVar.f9775d == this.f9775d;
    }

    public final int hashCode() {
        z zVar = this.f9777f;
        int iHashCode = zVar != null ? zVar.hashCode() : 0;
        int iD = n.f.d(this.f9772a) + (iHashCode * 31) + iHashCode;
        int iD2 = n.f.d(this.f9773b) + (iD * 31) + iD;
        int i2 = (iD2 * 31) + (this.f9774c ? 1 : 0) + iD2;
        return (i2 * 31) + (this.f9775d ? 1 : 0) + i2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("JavaTypeAttributes(howThisTypeIsUsed=");
        int i2 = this.f9772a;
        sb2.append(i2 != 1 ? i2 != 2 ? "null" : "COMMON" : "SUPERTYPE");
        sb2.append(", flexibility=");
        int i10 = this.f9773b;
        sb2.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? "null" : "FLEXIBLE_LOWER_BOUND" : "FLEXIBLE_UPPER_BOUND" : "INFLEXIBLE");
        sb2.append(", isRaw=");
        sb2.append(this.f9774c);
        sb2.append(", isForAnnotationParameter=");
        sb2.append(this.f9775d);
        sb2.append(", visitedTypeParameters=");
        sb2.append(this.f9776e);
        sb2.append(", defaultType=");
        sb2.append(this.f9777f);
        sb2.append(')');
        return sb2.toString();
    }

    public /* synthetic */ a(int i2, boolean z4, boolean z10, Set set, int i10) {
        this(i2, 1, (i10 & 4) != 0 ? false : z4, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? null : set, null);
    }
}
