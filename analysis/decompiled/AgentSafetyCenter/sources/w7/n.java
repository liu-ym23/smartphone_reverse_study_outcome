package w7;

import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final c8.a f15336d;

    /* renamed from: e, reason: collision with root package name */
    public static final c8.a f15337e;

    /* renamed from: f, reason: collision with root package name */
    public static final n f15338f;

    /* renamed from: a, reason: collision with root package name */
    public final a f15339a;

    /* renamed from: b, reason: collision with root package name */
    public final c8.a f15340b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f15341c = null;

    static {
        c8.a aVar = new c8.a(c8.e.JSON_POINTER);
        f15336d = aVar;
        f15337e = new c8.a(c8.e.URI_REFERENCE);
        f15338f = new n(null, aVar);
    }

    public n(a aVar, c8.a aVar2) {
        this.f15339a = aVar;
        this.f15340b = aVar2;
    }

    public static n c(String str) {
        a aVar;
        if (str == null) {
            return null;
        }
        if ("#".equals(str)) {
            return f15338f;
        }
        int iIndexOf = str.indexOf(35);
        c8.a aVarA = f15336d;
        if (iIndexOf == -1) {
            aVar = new a(str);
        } else {
            a aVar2 = new a(str.substring(0, iIndexOf));
            int i = iIndexOf + 1;
            if (str.length() > i) {
                aVarA = k.a(str.substring(i));
            }
            aVar = aVar2;
        }
        return new n(aVar, aVarA);
    }

    public static String d(n nVar, String str) {
        int i;
        if ("#".equals(str)) {
            return androidx.activity.b.n(new StringBuilder(), nVar.f15339a.f15287a, "#");
        }
        int iIndexOf = str.indexOf(35);
        a aVar = nVar.f15339a;
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (aVar != null) {
            strSubstring = !strSubstring.isEmpty() ? aVar.b(strSubstring).f15287a : aVar.f15287a;
        }
        String strSubstring2 = (iIndexOf == -1 || str.length() <= (i = iIndexOf + 1)) ? "" : str.substring(i);
        return !strSubstring2.isEmpty() ? k0.a.o(strSubstring, "#", strSubstring2) : k0.a.n(strSubstring, "#");
    }

    public final n a(int i) {
        return new n(this.f15339a, this.f15340b.a(i));
    }

    public final n b(String str) {
        return new n(this.f15339a, this.f15340b.b(str));
    }

    public final n e(String str) {
        int i;
        boolean zEquals = "#".equals(str);
        c8.a aVarA = f15336d;
        a aVar = this.f15339a;
        if (zEquals) {
            return new n(aVar, aVarA);
        }
        int iIndexOf = str.indexOf(35);
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (aVar == null) {
            aVar = new a(strSubstring);
        } else if (!strSubstring.isEmpty()) {
            aVar = aVar.b(strSubstring);
        }
        if (iIndexOf != -1 && str.length() > (i = iIndexOf + 1)) {
            String strSubstring2 = str.substring(i);
            if (!strSubstring2.isEmpty()) {
                aVarA = k.a(strSubstring2);
            }
        }
        return new n(aVar, aVarA);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return Objects.equals(this.f15340b, nVar.f15340b) && Objects.equals(this.f15339a, nVar.f15339a);
    }

    public final int hashCode() {
        return Objects.hash(this.f15340b, this.f15339a);
    }

    public final String toString() {
        if (this.f15341c == null) {
            a aVar = this.f15339a;
            if (aVar == null || this.f15340b != null) {
                StringBuilder sb2 = new StringBuilder();
                a aVar2 = this.f15339a;
                if (aVar2 != null) {
                    sb2.append(aVar2);
                }
                sb2.append("#");
                c8.a aVar3 = this.f15340b;
                if (aVar3 != null) {
                    sb2.append(aVar3);
                }
                this.f15341c = sb2.toString();
            } else {
                this.f15341c = aVar.f15287a;
            }
        }
        return this.f15341c;
    }
}
