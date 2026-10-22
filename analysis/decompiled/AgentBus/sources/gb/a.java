package gb;

import ab.m;
import ab.n;
import ob.j;
import p.e0;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public long f4032a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4033b;

    public a(j jVar) {
        k.e(jVar, "source");
        this.f4033b = jVar;
        this.f4032a = 262144L;
    }

    public n a() {
        m mVar = new m();
        while (true) {
            String strF = ((j) this.f4033b).F(this.f4032a);
            this.f4032a -= strF.length();
            if (strF.length() == 0) {
                return mVar.d();
            }
            int iQ0 = ga.k.q0(strF, ':', 1, 4);
            if (iQ0 != -1) {
                String strSubstring = strF.substring(0, iQ0);
                k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = strF.substring(iQ0 + 1);
                k.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                mVar.b(strSubstring, strSubstring2);
            } else if (strF.charAt(0) == ':') {
                String strSubstring3 = strF.substring(1);
                k.d(strSubstring3, "this as java.lang.String).substring(startIndex)");
                mVar.b("", strSubstring3);
            } else {
                mVar.b("", strF);
            }
        }
    }

    public a(e0 e0Var) {
        this.f4033b = e0Var;
        this.f4032a = 0L;
    }
}
