package s4;

import hc.i;
import java.util.Locale;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f11387a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11388b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11389c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11390d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11391e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11392f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11393g;

    public e(String str, String str2, boolean z10, int i, String str3, int i3) {
        str.getClass();
        str2.getClass();
        this.f11387a = str;
        this.f11388b = str2;
        this.f11389c = z10;
        this.f11390d = i;
        this.f11391e = str3;
        this.f11392f = i3;
        String upperCase = str2.toUpperCase(Locale.ROOT);
        upperCase.getClass();
        this.f11393g = hc.h.X(upperCase, "INT", false) ? 3 : (hc.h.X(upperCase, "CHAR", false) || hc.h.X(upperCase, "CLOB", false) || hc.h.X(upperCase, "TEXT", false)) ? 2 : hc.h.X(upperCase, "BLOB", false) ? 5 : (hc.h.X(upperCase, "REAL", false) || hc.h.X(upperCase, "FLOA", false) || hc.h.X(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                boolean z10 = this.f11390d > 0;
                e eVar = (e) obj;
                int i = eVar.f11392f;
                if (z10 == (eVar.f11390d > 0) && k.a(this.f11387a, eVar.f11387a) && this.f11389c == eVar.f11389c) {
                    String str = eVar.f11391e;
                    int i3 = this.f11392f;
                    String str2 = this.f11391e;
                    if ((i3 != 1 || i != 2 || str2 == null || id.k.o(str2, str)) && ((i3 != 2 || i != 1 || str == null || id.k.o(str, str2)) && ((i3 == 0 || i3 != i || (str2 == null ? str == null : id.k.o(str2, str))) && this.f11393g == eVar.f11393g))) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f11387a.hashCode() * 31) + this.f11393g) * 31) + (this.f11389c ? 1231 : 1237)) * 31) + this.f11390d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("\n            |Column {\n            |   name = '");
        sb2.append(this.f11387a);
        sb2.append("',\n            |   type = '");
        sb2.append(this.f11388b);
        sb2.append("',\n            |   affinity = '");
        sb2.append(this.f11393g);
        sb2.append("',\n            |   notNull = '");
        sb2.append(this.f11389c);
        sb2.append("',\n            |   primaryKeyPosition = '");
        sb2.append(this.f11390d);
        sb2.append("',\n            |   defaultValue = '");
        String str = this.f11391e;
        if (str == null) {
            str = "undefined";
        }
        sb2.append(str);
        sb2.append("'\n            |}\n        ");
        return i.M(i.O(sb2.toString()));
    }
}
