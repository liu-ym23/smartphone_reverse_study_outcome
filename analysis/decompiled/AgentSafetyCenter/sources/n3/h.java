package n3;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final g f8717a;

    static {
        new h("", 0, 0);
    }

    public h(String str, int i, int i3) {
        g gVar = new g();
        gVar.f8714a = str;
        gVar.f8715b = i;
        gVar.f8716c = i3;
        VarHandle.storeStoreFence();
        this.f8717a = gVar;
    }

    public static h a(int i, int i3, boolean z10, int i10, int i11, int i12, int i13) {
        String string;
        if (z10) {
            int i14 = i / 2;
            int i15 = i3 / 2;
            StringBuilder sbU = k0.a.u("M0,", i15, " A", ",", i14);
            sbU.append(i15);
            sbU.append(" 0 1,1 ");
            sbU.append(i);
            sbU.append(",");
            sbU.append(i15);
            sbU.append(" A");
            sbU.append(i14);
            sbU.append(",");
            sbU.append(i15);
            sbU.append(" 0 1,1 0,");
            sbU.append(i15);
            sbU.append(" Z");
            string = sbU.toString();
        } else {
            StringBuilder sb2 = new StringBuilder("M ");
            int iMin = Math.min(i / 2, i3 / 2);
            int iMin2 = Math.min(iMin, i10);
            int iMin3 = Math.min(iMin, i11);
            int iMin4 = Math.min(iMin, i12);
            int iMin5 = Math.min(iMin, i13);
            sb2.append(iMin2);
            sb2.append(",0 L ");
            sb2.append(i - iMin3);
            sb2.append(",0");
            if (iMin3 > 0) {
                sb2.append(" A ");
                sb2.append(iMin3);
                sb2.append(",");
                sb2.append(iMin3);
                sb2.append(" 0 0,1 ");
                sb2.append(i);
                sb2.append(",");
                sb2.append(iMin3);
            }
            sb2.append(" L ");
            sb2.append(i);
            sb2.append(",");
            sb2.append(i3 - iMin4);
            if (iMin4 > 0) {
                sb2.append(" A ");
                sb2.append(iMin4);
                sb2.append(",");
                sb2.append(iMin4);
                sb2.append(" 0 0,1 ");
                sb2.append(i - iMin4);
                sb2.append(",");
                sb2.append(i3);
            }
            sb2.append(" L ");
            sb2.append(iMin5);
            sb2.append(",");
            sb2.append(i3);
            if (iMin5 > 0) {
                sb2.append(" A ");
                sb2.append(iMin5);
                sb2.append(",");
                sb2.append(iMin5);
                sb2.append(" 0 0,1 0,");
                sb2.append(i3 - iMin5);
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
        return new h(string, i, i3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f8717a.equals(((h) obj).f8717a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8717a.hashCode();
    }

    public final String toString() {
        return this.f8717a.toString();
    }
}
