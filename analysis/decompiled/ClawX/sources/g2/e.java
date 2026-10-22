package g2;

import f2.u;
import java.security.GeneralSecurityException;
import k2.q1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final f2.l f2932a;

    /* renamed from: b, reason: collision with root package name */
    public static final f2.k f2933b;

    /* renamed from: c, reason: collision with root package name */
    public static final f2.b f2934c;
    public static final f2.a d;

    static {
        m2.a aVarB = u.b("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f2932a = new f2.l(d.class);
        f2933b = new f2.k(aVarB);
        f2934c = new f2.b(a.class);
        d = new f2.a(aVarB, new a1.n(9));
    }

    public static c a(q1 q1Var) throws GeneralSecurityException {
        int iOrdinal = q1Var.ordinal();
        if (iOrdinal == 1) {
            return c.f2916c;
        }
        if (iOrdinal == 2) {
            return c.f2917e;
        }
        if (iOrdinal == 3) {
            return c.f2918f;
        }
        if (iOrdinal == 4) {
            return c.d;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
    }
}
