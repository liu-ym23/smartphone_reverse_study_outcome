package e0;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final e f2305a;

    static {
        new f(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, 0, 0);
    }

    public f(String str, int i8, int i9) {
        this.f2305a = new e(str, i8, i9);
    }

    public static f a(int i8, int i9, boolean z, int i10, int i11, int i12, int i13) {
        String string;
        if (z) {
            int i14 = i8 / 2;
            int i15 = i9 / 2;
            StringBuilder sbT = a8.b.t("M0,", i15, " A", i14, ",");
            a8.b.z(sbT, i15, " 0 1,1 ", i8, ",");
            a8.b.z(sbT, i15, " A", i14, ",");
            sbT.append(i15);
            sbT.append(" 0 1,1 0,");
            sbT.append(i15);
            sbT.append(" Z");
            string = sbT.toString();
        } else {
            StringBuilder sb = new StringBuilder("M ");
            int iMin = Math.min(i8 / 2, i9 / 2);
            int iMin2 = Math.min(iMin, i10);
            int iMin3 = Math.min(iMin, i11);
            int iMin4 = Math.min(iMin, i12);
            int iMin5 = Math.min(iMin, i13);
            sb.append(iMin2);
            sb.append(",0 L ");
            sb.append(i8 - iMin3);
            sb.append(",0");
            if (iMin3 > 0) {
                sb.append(" A ");
                sb.append(iMin3);
                sb.append(",");
                sb.append(iMin3);
                sb.append(" 0 0,1 ");
                sb.append(i8);
                sb.append(",");
                sb.append(iMin3);
            }
            sb.append(" L ");
            sb.append(i8);
            sb.append(",");
            sb.append(i9 - iMin4);
            if (iMin4 > 0) {
                sb.append(" A ");
                sb.append(iMin4);
                sb.append(",");
                sb.append(iMin4);
                sb.append(" 0 0,1 ");
                sb.append(i8 - iMin4);
                sb.append(",");
                sb.append(i9);
            }
            sb.append(" L ");
            sb.append(iMin5);
            sb.append(",");
            sb.append(i9);
            if (iMin5 > 0) {
                sb.append(" A ");
                sb.append(iMin5);
                sb.append(",");
                sb.append(iMin5);
                sb.append(" 0 0,1 0,");
                sb.append(i9 - iMin5);
            }
            if (iMin2 > 0) {
                sb.append(" L 0,");
                sb.append(iMin2);
                sb.append(" A ");
                sb.append(iMin2);
                sb.append(",");
                sb.append(iMin2);
                sb.append(" 0 0,1 ");
                sb.append(iMin2);
                sb.append(",0");
            }
            sb.append(" Z");
            string = sb.toString();
        }
        return new f(string, i8, i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return Objects.equals(this.f2305a, ((f) obj).f2305a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f2305a);
    }

    public final String toString() {
        return this.f2305a.toString();
    }
}
