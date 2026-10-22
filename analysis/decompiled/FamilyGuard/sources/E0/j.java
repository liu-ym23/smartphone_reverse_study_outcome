package E0;

import X0.k;
import Y0.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final X0.g<InterfaceC1340f, String> f1307a = new X0.g<>(1000);

    /* renamed from: b, reason: collision with root package name */
    private final D.e<b> f1308b = Y0.a.d(10, new a());

    class a implements a.d<b> {
        a() {
        }

        @Override // Y0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    private static final class b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        final MessageDigest f1310a;

        /* renamed from: b, reason: collision with root package name */
        private final Y0.c f1311b = Y0.c.a();

        b(MessageDigest messageDigest) {
            this.f1310a = messageDigest;
        }

        @Override // Y0.a.f
        public Y0.c g() {
            return this.f1311b;
        }
    }

    private String a(InterfaceC1340f interfaceC1340f) {
        b bVar = (b) X0.j.d(this.f1308b.b());
        try {
            interfaceC1340f.b(bVar.f1310a);
            return k.t(bVar.f1310a.digest());
        } finally {
            this.f1308b.a(bVar);
        }
    }

    public String b(InterfaceC1340f interfaceC1340f) {
        String strG;
        synchronized (this.f1307a) {
            strG = this.f1307a.g(interfaceC1340f);
        }
        if (strG == null) {
            strG = a(interfaceC1340f);
        }
        synchronized (this.f1307a) {
            this.f1307a.k(interfaceC1340f, strG);
        }
        return strG;
    }
}
