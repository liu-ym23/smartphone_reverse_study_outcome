package C9;

import B9.T;
import B9.h0;

/* loaded from: classes4.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final B9.B f329a = T.a("kotlinx.serialization.json.JsonUnquotedLiteral", h0.f242a);

    public static final B a(Number number) {
        return number == null ? u.INSTANCE : new r(number, false, null);
    }

    public static final B b(String str) {
        return str == null ? u.INSTANCE : new r(str, true, null);
    }

    public static final long c(B b) {
        kotlin.jvm.internal.k.f(b, "<this>");
        String strB = b.b();
        D9.t tVar = new D9.t(strB);
        long jI = tVar.i();
        if (tVar.f() == 10) {
            return jI;
        }
        int i = tVar.c;
        int i6 = i - 1;
        D9.t.o(tVar, B7.a.m("Expected input to contain a single valid number, but got '", (i == strB.length() || i6 < 0) ? "EOF" : String.valueOf(strB.charAt(i6)), "' after it"), i6, null, 4);
        throw null;
    }
}
