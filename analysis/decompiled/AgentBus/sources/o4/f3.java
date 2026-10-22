package o4;

import java.net.Socket;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/* loaded from: classes.dex */
public final class f3 extends X509ExtendedKeyManager {

    /* renamed from: a, reason: collision with root package name */
    public final String f7367a;

    /* renamed from: b, reason: collision with root package name */
    public final KeyStore f7368b;

    public f3(String str, KeyStore keyStore) {
        this.f7367a = str;
        this.f7368b = keyStore;
    }

    public final boolean a(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        KeyStore keyStore = this.f7368b;
        String str2 = this.f7367a;
        if (!keyStore.containsAlias(str2)) {
            return false;
        }
        Key key = keyStore.getKey(str2, null);
        PrivateKey privateKey = key instanceof PrivateKey ? (PrivateKey) key : null;
        if (privateKey == null) {
            return false;
        }
        if (str == null || ga.k.t0(str)) {
            return true;
        }
        String algorithm = privateKey.getAlgorithm();
        if (ga.r.a0(algorithm, str)) {
            return true;
        }
        if (str.equalsIgnoreCase("EC")) {
            return ga.r.a0(algorithm, "EC") || ga.r.a0(algorithm, "ECDSA");
        }
        return false;
    }

    @Override // javax.net.ssl.X509KeyManager
    public final String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        String str;
        String str2 = this.f7367a;
        if (strArr == null) {
            if (a(null)) {
                return str2;
            }
            return null;
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = null;
                break;
            }
            str = strArr[i2];
            if (a(str)) {
                break;
            }
            i2++;
        }
        if (str != null) {
            return str2;
        }
        return null;
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public final String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return chooseClientAlias(strArr, principalArr, null);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public final String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public final String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public final X509Certificate[] getCertificateChain(String str) {
        Certificate[] certificateChain;
        if (!q7.k.a(str, this.f7367a) || (certificateChain = this.f7368b.getCertificateChain(str)) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(certificateChain.length);
        for (Certificate certificate : certificateChain) {
            q7.k.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            arrayList.add((X509Certificate) certificate);
        }
        return (X509Certificate[]) arrayList.toArray(new X509Certificate[0]);
    }

    @Override // javax.net.ssl.X509KeyManager
    public final String[] getClientAliases(String str, Principal[] principalArr) {
        String str2 = a(str) ? this.f7367a : null;
        if (str2 != null) {
            return new String[]{str2};
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public final PrivateKey getPrivateKey(String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        if (!q7.k.a(str, this.f7367a)) {
            return null;
        }
        Key key = this.f7368b.getKey(str, null);
        if (key instanceof PrivateKey) {
            return (PrivateKey) key;
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public final String[] getServerAliases(String str, Principal[] principalArr) {
        return null;
    }
}
