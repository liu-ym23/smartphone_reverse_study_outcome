package b4;

import a4.v;
import f4.c2;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final a4.l f1511a;

    /* renamed from: b, reason: collision with root package name */
    public static final a4.k f1512b;

    /* renamed from: c, reason: collision with root package name */
    public static final a4.b f1513c;

    /* renamed from: d, reason: collision with root package name */
    public static final a4.a f1514d;

    static {
        i4.a aVarB = v.b("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f1511a = new a4.l(g.class);
        f1512b = new a4.k(aVarB);
        f1513c = new a4.b(a.class);
        f1514d = new a4.a(aVarB, new b(1));
    }

    public static f a(c2 c2Var) throws GeneralSecurityException {
        int iOrdinal = c2Var.ordinal();
        if (iOrdinal == 1) {
            return f.f1493c;
        }
        if (iOrdinal == 2) {
            return f.f1495e;
        }
        if (iOrdinal == 3) {
            return f.f1496f;
        }
        if (iOrdinal == 4) {
            return f.f1494d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var.b());
    }
}
