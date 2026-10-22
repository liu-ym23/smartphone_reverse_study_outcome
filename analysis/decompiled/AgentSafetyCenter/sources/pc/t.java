package pc;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9984a = 1;

    /* renamed from: b, reason: collision with root package name */
    public String f9985b;

    public t(String str) {
        this.f9985b = str;
    }

    public final String toString() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        boolean zContainsAlias;
        switch (this.f9984a) {
            case 0:
                return k0.a.s(new StringBuilder("<"), this.f9985b, '>');
            default:
                StringBuilder sb2 = new StringBuilder("MasterKey{keyAlias=");
                String str = this.f9985b;
                sb2.append(str);
                sb2.append(", isKeyStoreBacked=");
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    zContainsAlias = keyStore.containsAlias(str);
                } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
                    zContainsAlias = false;
                }
                sb2.append(zContainsAlias);
                sb2.append("}");
                return sb2.toString();
        }
    }

    public /* synthetic */ t() {
    }
}
