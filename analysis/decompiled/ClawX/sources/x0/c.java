package x0;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6247a;

    public c(String str, Object obj) {
        this.f6247a = str;
    }

    public final String toString() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        boolean zContainsAlias;
        StringBuilder sb = new StringBuilder("MasterKey{keyAlias=");
        String str = this.f6247a;
        sb.append(str);
        sb.append(", isKeyStoreBacked=");
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            zContainsAlias = keyStore.containsAlias(str);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
            zContainsAlias = false;
        }
        sb.append(zContainsAlias);
        sb.append("}");
        return sb.toString();
    }
}
