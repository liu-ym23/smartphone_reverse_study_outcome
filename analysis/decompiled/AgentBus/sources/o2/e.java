package o2;

import java.util.Objects;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final d f7228a;

    static {
        new e("", 0, 0);
    }

    public e(String str, int i2, int i10) {
        this.f7228a = new d(str, i2, i10);
    }

    public static e a(int i2, int i10, boolean z4, int i11, int i12, int i13, int i14) {
        String string;
        if (z4) {
            int i15 = i2 / 2;
            int i16 = i10 / 2;
            string = "M0," + i16 + " A" + i15 + "," + i16 + " 0 1,1 " + i2 + "," + i16 + " A" + i15 + "," + i16 + " 0 1,1 0," + i16 + " Z";
        } else {
            StringBuilder sb2 = new StringBuilder("M ");
            int iMin = Math.min(i2 / 2, i10 / 2);
            int iMin2 = Math.min(iMin, i11);
            int iMin3 = Math.min(iMin, i12);
            int iMin4 = Math.min(iMin, i13);
            int iMin5 = Math.min(iMin, i14);
            sb2.append(iMin2);
            sb2.append(",0 L ");
            sb2.append(i2 - iMin3);
            sb2.append(",0");
            if (iMin3 > 0) {
                sb2.append(" A ");
                sb2.append(iMin3);
                sb2.append(",");
                sb2.append(iMin3);
                sb2.append(" 0 0,1 ");
                sb2.append(i2);
                sb2.append(",");
                sb2.append(iMin3);
            }
            sb2.append(" L ");
            sb2.append(i2);
            sb2.append(",");
            sb2.append(i10 - iMin4);
            if (iMin4 > 0) {
                sb2.append(" A ");
                sb2.append(iMin4);
                sb2.append(",");
                sb2.append(iMin4);
                sb2.append(" 0 0,1 ");
                sb2.append(i2 - iMin4);
                sb2.append(",");
                sb2.append(i10);
            }
            sb2.append(" L ");
            sb2.append(iMin5);
            sb2.append(",");
            sb2.append(i10);
            if (iMin5 > 0) {
                sb2.append(" A ");
                sb2.append(iMin5);
                sb2.append(",");
                sb2.append(iMin5);
                sb2.append(" 0 0,1 0,");
                sb2.append(i10 - iMin5);
            }
            if (iMin2 > 0) {
                sb2.append(" L 0,");
                sb2.append(iMin2);
                sb2.append(" A ");
                sb2.append(iMin2);
                sb2.append(",");
                sb2.append(iMin2);
                sb2.append(" 0 0,1 ");
                sb2.append(iMin2);
                sb2.append(",0");
            }
            sb2.append(" Z");
            string = sb2.toString();
        }
        return new e(string, i2, i10);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return Objects.equals(this.f7228a, ((e) obj).f7228a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f7228a);
    }

    public final String toString() {
        return this.f7228a.toString();
    }
}
