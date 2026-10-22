package h3;

import java.util.Locale;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f4075a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4076b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4077c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4078d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4079e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4080f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4081g;

    public a(String str, String str2, boolean z4, int i2, String str3, int i10) {
        this.f4075a = str;
        this.f4076b = str2;
        this.f4077c = z4;
        this.f4078d = i2;
        this.f4079e = str3;
        this.f4080f = i10;
        Locale locale = Locale.US;
        k.d(locale, "US");
        String upperCase = str2.toUpperCase(locale);
        k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
        this.f4081g = ga.k.k0(upperCase, "INT", false) ? 3 : (ga.k.k0(upperCase, "CHAR", false) || ga.k.k0(upperCase, "CLOB", false) || ga.k.k0(upperCase, "TEXT", false)) ? 2 : ga.k.k0(upperCase, "BLOB", false) ? 5 : (ga.k.k0(upperCase, "REAL", false) || ga.k.k0(upperCase, "FLOA", false) || ga.k.k0(upperCase, "DOUB", false)) ? 4 : 1;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f4078d != aVar.f4078d) {
                return false;
            }
            int i2 = aVar.f4080f;
            String str = aVar.f4079e;
            if (!this.f4075a.equals(aVar.f4075a) || this.f4077c != aVar.f4077c) {
                return false;
            }
            String str2 = this.f4079e;
            int i10 = this.f4080f;
            if (i10 == 1 && i2 == 2 && str2 != null && !ib.c.v(str2, str)) {
                return false;
            }
            if (i10 == 2 && i2 == 1 && str != null && !ib.c.v(str, str2)) {
                return false;
            }
            if (i10 != 0 && i10 == i2) {
                if (str2 != null) {
                    if (!ib.c.v(str2, str)) {
                        return false;
                    }
                } else if (str != null) {
                    return false;
                }
            }
            if (this.f4081g != aVar.f4081g) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.f4075a.hashCode() * 31) + this.f4081g) * 31) + (this.f4077c ? 1231 : 1237)) * 31) + this.f4078d;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Column{name='");
        sb2.append(this.f4075a);
        sb2.append("', type='");
        sb2.append(this.f4076b);
        sb2.append("', affinity='");
        sb2.append(this.f4081g);
        sb2.append("', notNull=");
        sb2.append(this.f4077c);
        sb2.append(", primaryKeyPosition=");
        sb2.append(this.f4078d);
        sb2.append(", defaultValue='");
        String str = this.f4079e;
        if (str == null) {
            str = "undefined";
        }
        return a1.a.m(sb2, str, "'}");
    }
}
