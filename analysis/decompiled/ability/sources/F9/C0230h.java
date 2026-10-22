package F9;

import com.fasterxml.jackson.core.JsonPointer;
import okio.ByteString;
import s2.C1912a;

/* renamed from: F9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0230h {

    /* renamed from: a, reason: collision with root package name */
    public final String f641a;
    public final String b;
    public final ByteString c;

    public C0230h(String str, String pin) {
        kotlin.jvm.internal.k.f(pin, "pin");
        if ((!j9.t.e0(str, "*.", false) || j9.m.q0(str, "*", 1, false, 4) != -1) && ((!j9.t.e0(str, "**.", false) || j9.m.q0(str, "*", 2, false, 4) != -1) && j9.m.q0(str, "*", 0, false, 6) != -1)) {
            throw new IllegalArgumentException("Unexpected pattern: ".concat(str).toString());
        }
        String strN = com.stepos.statsrpk.d.N(str);
        if (strN == null) {
            throw new IllegalArgumentException("Invalid pattern: ".concat(str));
        }
        this.f641a = strN;
        if (j9.t.e0(pin, "sha1/", false)) {
            this.b = "sha1";
            ByteString byteString = ByteString.d;
            String strSubstring = pin.substring(5);
            kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            ByteString byteStringG = C1912a.g(strSubstring);
            if (byteStringG == null) {
                throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
            }
            this.c = byteStringG;
            return;
        }
        if (!j9.t.e0(pin, "sha256/", false)) {
            throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': ".concat(pin));
        }
        this.b = "sha256";
        ByteString byteString2 = ByteString.d;
        String strSubstring2 = pin.substring(7);
        kotlin.jvm.internal.k.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
        ByteString byteStringG2 = C1912a.g(strSubstring2);
        if (byteStringG2 == null) {
            throw new IllegalArgumentException("Invalid pin hash: ".concat(pin));
        }
        this.c = byteStringG2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0230h)) {
            return false;
        }
        C0230h c0230h = (C0230h) obj;
        return kotlin.jvm.internal.k.b(this.f641a, c0230h.f641a) && kotlin.jvm.internal.k.b(this.b, c0230h.b) && kotlin.jvm.internal.k.b(this.c, c0230h.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + B7.a.c(this.f641a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return this.b + JsonPointer.SEPARATOR + this.c.a();
    }
}
