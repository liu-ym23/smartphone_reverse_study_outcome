package b4;

import a4.v;
import f4.a1;
import f4.c2;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final a4.l f1522a;

    /* renamed from: b, reason: collision with root package name */
    public static final a4.k f1523b;

    /* renamed from: c, reason: collision with root package name */
    public static final a4.b f1524c;

    /* renamed from: d, reason: collision with root package name */
    public static final a4.a f1525d;

    static {
        i4.a aVarB = v.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f1522a = new a4.l(m.class);
        f1523b = new a4.k(aVarB);
        f1524c = new a4.b(l.class);
        f1525d = new a4.a(aVarB, new b(3));
    }

    public static f a(a1 a1Var) throws GeneralSecurityException {
        int iOrdinal = a1Var.ordinal();
        if (iOrdinal == 1) {
            return f.f1497g;
        }
        if (iOrdinal == 2) {
            return f.f1500j;
        }
        if (iOrdinal == 3) {
            return f.f1499i;
        }
        if (iOrdinal == 4) {
            return f.f1501k;
        }
        if (iOrdinal == 5) {
            return f.f1498h;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + a1Var.b());
    }

    public static f b(c2 c2Var) throws GeneralSecurityException {
        int iOrdinal = c2Var.ordinal();
        if (iOrdinal == 1) {
            return f.f1502l;
        }
        if (iOrdinal == 2) {
            return f.f1504n;
        }
        if (iOrdinal == 3) {
            return f.f1505o;
        }
        if (iOrdinal == 4) {
            return f.f1503m;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var.b());
    }
}
