package T0;

import androidx.room.AbstractC0351g;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public String f1840a;

    /* renamed from: b, reason: collision with root package name */
    public String f1841b;

    /* renamed from: c, reason: collision with root package name */
    public int f1842c;

    /* renamed from: d, reason: collision with root package name */
    public a f1843d;

    /* renamed from: e, reason: collision with root package name */
    public float f1844e;

    /* renamed from: f, reason: collision with root package name */
    public int f1845f;

    /* renamed from: g, reason: collision with root package name */
    public String f1846g;

    /* renamed from: h, reason: collision with root package name */
    public String f1847h;

    /* renamed from: i, reason: collision with root package name */
    public String f1848i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1849j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1850k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1851l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1852m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1853n;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.f1840a, iVar.f1840a) && Intrinsics.areEqual(this.f1841b, iVar.f1841b) && this.f1842c == iVar.f1842c && this.f1843d == iVar.f1843d && Float.compare(this.f1844e, iVar.f1844e) == 0 && this.f1845f == iVar.f1845f && Intrinsics.areEqual(this.f1846g, iVar.f1846g) && Intrinsics.areEqual(this.f1847h, iVar.f1847h) && Intrinsics.areEqual(this.f1848i, iVar.f1848i) && this.f1849j == iVar.f1849j && this.f1850k == iVar.f1850k && this.f1851l == iVar.f1851l && this.f1852m == iVar.f1852m && this.f1853n == iVar.f1853n;
    }

    public final int hashCode() {
        int iHashCode = this.f1840a.hashCode() * 31;
        String str = this.f1841b;
        return Boolean.hashCode(this.f1853n) + ((Boolean.hashCode(this.f1852m) + ((Boolean.hashCode(this.f1851l) + ((Boolean.hashCode(this.f1850k) + ((Boolean.hashCode(this.f1849j) + AbstractC0351g.d(this.f1848i, AbstractC0351g.d(this.f1847h, AbstractC0351g.d(this.f1846g, B0.g.d(this.f1845f, (Float.hashCode(this.f1844e) + ((this.f1843d.hashCode() + B0.g.d(this.f1842c, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31)) * 31)) * 31, 31), 31), 31), 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String str = this.f1840a;
        int i4 = this.f1842c;
        a aVar = this.f1843d;
        String str2 = this.f1846g;
        String str3 = this.f1847h;
        String str4 = this.f1848i;
        boolean z4 = this.f1849j;
        boolean z5 = this.f1850k;
        boolean z6 = this.f1851l;
        boolean z7 = this.f1853n;
        StringBuilder sbW = B0.g.w("OcrConfig(modelPath=", str, ", labelPath=");
        sbW.append(this.f1841b);
        sbW.append(", cpuThreadNum=");
        sbW.append(i4);
        sbW.append(", cpuPowerMode=");
        sbW.append(aVar);
        sbW.append(", scoreThreshold=");
        sbW.append(this.f1844e);
        sbW.append(", detLongSize=");
        sbW.append(this.f1845f);
        sbW.append(", detModelFilename=");
        sbW.append(str2);
        sbW.append(", recModelFilename=");
        AbstractC0351g.C(sbW, str3, ", clsModelFilename=", str4, ", isRunDet=");
        sbW.append(z4);
        sbW.append(", isRunCls=");
        sbW.append(z5);
        sbW.append(", isRunRec=");
        sbW.append(z6);
        sbW.append(", isUseOpencl=");
        sbW.append(this.f1852m);
        sbW.append(", isDrwwTextPositionBox=");
        sbW.append(z7);
        sbW.append(")");
        return sbW.toString();
    }
}
