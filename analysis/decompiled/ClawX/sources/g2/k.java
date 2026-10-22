package g2;

import f2.u;
import java.security.GeneralSecurityException;
import k2.o0;
import k2.q1;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final f2.l f2941a;

    /* renamed from: b, reason: collision with root package name */
    public static final f2.k f2942b;

    /* renamed from: c, reason: collision with root package name */
    public static final f2.b f2943c;
    public static final f2.a d;

    static {
        m2.a aVarB = u.b("type.googleapis.com/google.crypto.tink.HmacKey");
        f2941a = new f2.l(j.class);
        f2942b = new f2.k(aVarB);
        f2943c = new f2.b(i.class);
        d = new f2.a(aVarB, new a1.n(11));
    }

    public static c a(o0 o0Var) throws GeneralSecurityException {
        int iOrdinal = o0Var.ordinal();
        if (iOrdinal == 1) {
            return c.f2919g;
        }
        if (iOrdinal == 2) {
            return c.f2922j;
        }
        if (iOrdinal == 3) {
            return c.f2921i;
        }
        if (iOrdinal == 4) {
            return c.f2923k;
        }
        if (iOrdinal == 5) {
            return c.f2920h;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + o0Var.a());
    }

    public static c b(q1 q1Var) throws GeneralSecurityException {
        int iOrdinal = q1Var.ordinal();
        if (iOrdinal == 1) {
            return c.f2924l;
        }
        if (iOrdinal == 2) {
            return c.f2926n;
        }
        if (iOrdinal == 3) {
            return c.f2927o;
        }
        if (iOrdinal == 4) {
            return c.f2925m;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
    }
}
