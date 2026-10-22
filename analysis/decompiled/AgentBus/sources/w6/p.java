package w6;

import com.stepos.cloud.securedata.SecureDataEnvironment;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final SecureDataEnvironment f10815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10816b;

    /* renamed from: c, reason: collision with root package name */
    public final y6.a f10817c;

    public p(SecureDataEnvironment secureDataEnvironment, String str, y6.a aVar) {
        q7.k.e(str, "apiBaseUrl");
        this.f10815a = secureDataEnvironment;
        this.f10816b = str;
        this.f10817c = aVar;
    }

    public static p copy$default(p pVar, SecureDataEnvironment secureDataEnvironment, String str, y6.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            secureDataEnvironment = pVar.f10815a;
        }
        if ((i2 & 2) != 0) {
            str = pVar.f10816b;
        }
        if ((i2 & 4) != 0) {
            aVar = pVar.f10817c;
        }
        pVar.getClass();
        q7.k.e(secureDataEnvironment, "environment");
        q7.k.e(str, "apiBaseUrl");
        q7.k.e(aVar, "gateway");
        return new p(secureDataEnvironment, str, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f10815a == pVar.f10815a && q7.k.a(this.f10816b, pVar.f10816b) && q7.k.a(this.f10817c, pVar.f10817c);
    }

    public final int hashCode() {
        return this.f10817c.hashCode() + m.x.g(this.f10816b, this.f10815a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "SecureDataRuntimeConfig(environment=" + this.f10815a + ", apiBaseUrl=" + this.f10816b + ", gateway=" + this.f10817c + ")";
    }
}
