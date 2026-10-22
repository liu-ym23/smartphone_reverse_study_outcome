package u3;

import com.networknt.schema.path.PathType;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class j {
    public static final A3.a d;
    public static final A3.a e;
    public static final j f;

    /* renamed from: a, reason: collision with root package name */
    public final C2035a f6704a;
    public final A3.a b;
    public volatile String c = null;

    static {
        A3.a aVar = new A3.a(PathType.JSON_POINTER);
        d = aVar;
        e = new A3.a(PathType.URI_REFERENCE);
        f = new j(null, aVar);
    }

    public j(C2035a c2035a, A3.a aVar) {
        this.f6704a = c2035a;
        this.b = aVar;
    }

    public static j c(String str) {
        C2035a c2035a;
        if (str == null) {
            return null;
        }
        if ("#".equals(str)) {
            return f;
        }
        int iIndexOf = str.indexOf(35);
        A3.a aVarA = d;
        if (iIndexOf == -1) {
            c2035a = new C2035a(str);
        } else {
            C2035a c2035a2 = new C2035a(str.substring(0, iIndexOf));
            int i = iIndexOf + 1;
            if (str.length() > i) {
                aVarA = h.a(str.substring(i));
            }
            c2035a = c2035a2;
        }
        return new j(c2035a, aVarA);
    }

    public static String d(j jVar, String str) {
        int i;
        if ("#".equals(str)) {
            return B7.a.q(new StringBuilder(), jVar.f6704a.f6694a, "#");
        }
        int iIndexOf = str.indexOf(35);
        C2035a c2035a = jVar.f6704a;
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (c2035a != null) {
            strSubstring = !strSubstring.isEmpty() ? c2035a.b(strSubstring).f6694a : c2035a.f6694a;
        }
        String strSubstring2 = (iIndexOf == -1 || str.length() <= (i = iIndexOf + 1)) ? "" : str.substring(i);
        return !strSubstring2.isEmpty() ? B7.a.B(strSubstring, "#", strSubstring2) : androidx.appfunctions.metadata.a.l(strSubstring, "#");
    }

    public final j a(int i) {
        A3.a aVar = this.b;
        aVar.getClass();
        return new j(this.f6704a, new A3.a(aVar, i));
    }

    public final j b(String str) {
        A3.a aVar = this.b;
        aVar.getClass();
        return new j(this.f6704a, new A3.a(aVar, str));
    }

    public final j e(String str) {
        int i;
        if (str == null) {
            return this;
        }
        boolean zEquals = "#".equals(str);
        A3.a aVarA = d;
        C2035a c2035a = this.f6704a;
        if (zEquals) {
            return new j(c2035a, aVarA);
        }
        int iIndexOf = str.indexOf(35);
        String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
        if (c2035a == null) {
            c2035a = new C2035a(strSubstring);
        } else if (!strSubstring.isEmpty()) {
            c2035a = c2035a.b(strSubstring);
        }
        if (iIndexOf != -1 && str.length() > (i = iIndexOf + 1)) {
            String strSubstring2 = str.substring(i);
            if (!strSubstring2.isEmpty()) {
                aVarA = h.a(strSubstring2);
            }
        }
        return new j(c2035a, aVarA);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return Objects.equals(this.b, jVar.b) && Objects.equals(this.f6704a, jVar.f6704a);
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.f6704a);
    }

    public final String toString() {
        if (this.c == null) {
            C2035a c2035a = this.f6704a;
            if (c2035a == null || this.b != null) {
                StringBuilder sb = new StringBuilder();
                C2035a c2035a2 = this.f6704a;
                if (c2035a2 != null) {
                    sb.append(c2035a2);
                }
                sb.append("#");
                A3.a aVar = this.b;
                if (aVar != null) {
                    sb.append(aVar);
                }
                this.c = sb.toString();
            } else {
                this.c = c2035a.f6694a;
            }
        }
        return this.c;
    }
}
