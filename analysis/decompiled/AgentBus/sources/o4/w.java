package o4;

import android.content.Context;
import android.security.keystore.KeyInfo;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final String f7669a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7670b;

    public w(Context context, String str) {
        q7.k.e(context, "context");
        this.f7669a = str;
        this.f7670b = new Object();
        context.getApplicationContext();
    }

    public final boolean a() {
        Object objN;
        boolean zBooleanValue;
        synchronized (this.f7670b) {
            try {
                objN = Boolean.valueOf(b());
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            Object obj = Boolean.FALSE;
            if (objN instanceof c7.l) {
                objN = obj;
            }
            zBooleanValue = ((Boolean) objN).booleanValue();
        }
        return zBooleanValue;
    }

    public final boolean b() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        Certificate[] certificateChain;
        Object objN;
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        String str = this.f7669a;
        if (!keyStore.containsAlias(str)) {
            return false;
        }
        Key key = keyStore.getKey(str, null);
        PrivateKey privateKey = key instanceof PrivateKey ? (PrivateKey) key : null;
        if (privateKey == null || (certificateChain = keyStore.getCertificateChain(str)) == null || certificateChain.length == 0) {
            return false;
        }
        try {
            String[] digests = ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).getDigests();
            q7.k.d(digests, "getDigests(...)");
            objN = Boolean.valueOf(d7.n.U(digests, "NONE"));
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Object obj = Boolean.FALSE;
        if (objN instanceof c7.l) {
            objN = obj;
        }
        return ((Boolean) objN).booleanValue();
    }
}
