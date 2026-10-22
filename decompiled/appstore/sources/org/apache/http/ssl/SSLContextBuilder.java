package org.apache.http.ssl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class SSLContextBuilder {
    static final String TLS = "TLS";
    private String keyManagerFactoryAlgorithm;
    private final Set<KeyManager> keyManagers;
    private String keyStoreType;
    private String protocol;
    private Provider provider;
    private SecureRandom secureRandom;
    private String trustManagerFactoryAlgorithm;
    private final Set<TrustManager> trustManagers;

    public static class KeyManagerDelegate extends X509ExtendedKeyManager {
        private final PrivateKeyStrategy aliasStrategy;
        private final X509ExtendedKeyManager keyManager;

        public KeyManagerDelegate(X509ExtendedKeyManager r10, PrivateKeyStrategy r11) {
            this.keyManager = r10;
            this.aliasStrategy = r11;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseClientAlias(String[] r10, Principal[] r11, Socket r12) {
            Map<String, PrivateKeyDetails> r13 = getClientAliasMap(r10, r11);
            return this.aliasStrategy.chooseAlias(r13, r12);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineClientAlias(String[] r10, Principal[] r11, SSLEngine r12) {
            Map<String, PrivateKeyDetails> r13 = getClientAliasMap(r10, r11);
            return this.aliasStrategy.chooseAlias(r13, null);
        }

        @Override // javax.net.ssl.X509ExtendedKeyManager
        public String chooseEngineServerAlias(String r10, Principal[] r11, SSLEngine r12) {
            Map<String, PrivateKeyDetails> r13 = getServerAliasMap(r10, r11);
            return this.aliasStrategy.chooseAlias(r13, null);
        }

        @Override // javax.net.ssl.X509KeyManager
        public String chooseServerAlias(String r10, Principal[] r11, Socket r12) {
            Map<String, PrivateKeyDetails> r13 = getServerAliasMap(r10, r11);
            return this.aliasStrategy.chooseAlias(r13, r12);
        }

        @Override // javax.net.ssl.X509KeyManager
        public X509Certificate[] getCertificateChain(String r10) {
            return this.keyManager.getCertificateChain(r10);
        }

        public Map<String, PrivateKeyDetails> getClientAliasMap(String[] r12, Principal[] r13) {
            HashMap r10 = new HashMap();
            int r11 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r11) goto L10;
            String r15 = r12[r14];
            String[] r16 = this.keyManager.getClientAliases(r15, r13);
            if (r16 == null) goto L9;
            int r17 = r16.length;
            int r18 = 0;
        L7:
            if (r18 >= r17) goto L9;
            String r19 = r16[r18];
            r10.put(r19, new PrivateKeyDetails(r15, this.keyManager.getCertificateChain(r19)));
            r18 = r18 + 1;
        L9:
            r14 = r14 + 1;
            goto L3
        L10:
            return r10;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getClientAliases(String r10, Principal[] r11) {
            return this.keyManager.getClientAliases(r10, r11);
        }

        @Override // javax.net.ssl.X509KeyManager
        public PrivateKey getPrivateKey(String r10) {
            return this.keyManager.getPrivateKey(r10);
        }

        public Map<String, PrivateKeyDetails> getServerAliasMap(String r10, Principal[] r11) {
            HashMap r12 = new HashMap();
            String[] r13 = this.keyManager.getServerAliases(r10, r11);
            if (r13 == null) goto L7;
            int r14 = r13.length;
            int r15 = 0;
        L5:
            if (r15 >= r14) goto L7;
            String r16 = r13[r15];
            r12.put(r16, new PrivateKeyDetails(r10, this.keyManager.getCertificateChain(r16)));
            r15 = r15 + 1;
        L7:
            return r12;
        }

        @Override // javax.net.ssl.X509KeyManager
        public String[] getServerAliases(String r10, Principal[] r11) {
            return this.keyManager.getServerAliases(r10, r11);
        }
    }

    public static class TrustManagerDelegate implements X509TrustManager {
        private final X509TrustManager trustManager;
        private final TrustStrategy trustStrategy;

        public TrustManagerDelegate(X509TrustManager r10, TrustStrategy r11) {
            this.trustManager = r10;
            this.trustStrategy = r11;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] r10, String r11) throws CertificateException {
            this.trustManager.checkClientTrusted(r10, r11);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] r10, String r11) throws CertificateException {
            if (this.trustStrategy.isTrusted(r10, r11) == true) goto L6;
            this.trustManager.checkServerTrusted(r10, r11);
            return;
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.trustManager.getAcceptedIssuers();
        }
    }

    public SSLContextBuilder() {
        this.keyManagerFactoryAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        this.keyStoreType = KeyStore.getDefaultType();
        this.trustManagerFactoryAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        this.keyManagers = new LinkedHashSet();
        this.trustManagers = new LinkedHashSet();
    }

    public static SSLContextBuilder create() {
        return new SSLContextBuilder();
    }

    public SSLContext build() throws NoSuchAlgorithmException, KeyManagementException {
        String r10 = this.protocol;
        if (r10 != null) goto L6;
        r10 = TLS;
    L6:
        Provider r11 = this.provider;
        if (r11 == null) goto L9;
        SSLContext r12 = SSLContext.getInstance(r10, r11);
    L10:
        initSSLContext(r12, this.keyManagers, this.trustManagers, this.secureRandom);
        return r12;
    L9:
        r12 = SSLContext.getInstance(r10);
        goto L10
    }

    public void initSSLContext(SSLContext r10, Collection<KeyManager> r11, Collection<TrustManager> r12, SecureRandom r13) throws KeyManagementException {
        TrustManager[] r14 = null;
        if (r11.isEmpty() == true) goto L5;
        KeyManager[] r15 = (KeyManager[]) r11.toArray(new KeyManager[r11.size()]);
    L7:
        if (r12.isEmpty() == true) goto L9;
        r14 = (TrustManager[]) r12.toArray(new TrustManager[r12.size()]);
    L9:
        r10.init(r15, r14, r13);
        return;
    L5:
        r15 = null;
        goto L7
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r10, char[] r11, PrivateKeyStrategy r12) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        String r13 = this.keyManagerFactoryAlgorithm;
        if (r13 != null) goto L5;
        r13 = KeyManagerFactory.getDefaultAlgorithm();
    L5:
        KeyManagerFactory r14 = KeyManagerFactory.getInstance(r13);
        r14.init(r10, r11);
        KeyManager[] r15 = r14.getKeyManagers();
        if (r15 == null) goto L19;
        int r16 = 0;
        if (r12 == null) goto L16;
        int r17 = 0;
    L11:
        if (r17 >= r15.length) goto L16;
        KeyManager r18 = r15[r17];
        if ((r18 instanceof X509ExtendedKeyManager) == false) goto L15;
        r15[r17] = new KeyManagerDelegate((X509ExtendedKeyManager) r18, r12);
    L15:
        r17 = r17 + 1;
    L16:
        int r19 = r15.length;
    L17:
        if (r16 >= r19) goto L19;
        this.keyManagers.add(r15[r16]);
        r16 = r16 + 1;
    L19:
        return this;
    }

    public SSLContextBuilder loadTrustMaterial(KeyStore r10, TrustStrategy r11) throws NoSuchAlgorithmException, KeyStoreException {
        String r12 = this.trustManagerFactoryAlgorithm;
        if (r12 != null) goto L5;
        r12 = TrustManagerFactory.getDefaultAlgorithm();
    L5:
        TrustManagerFactory r13 = TrustManagerFactory.getInstance(r12);
        r13.init(r10);
        TrustManager[] r14 = r13.getTrustManagers();
        if (r14 == null) goto L19;
        int r15 = 0;
        if (r11 == null) goto L16;
        int r16 = 0;
    L11:
        if (r16 >= r14.length) goto L16;
        TrustManager r17 = r14[r16];
        if ((r17 instanceof X509TrustManager) == false) goto L15;
        r14[r16] = new TrustManagerDelegate((X509TrustManager) r17, r11);
    L15:
        r16 = r16 + 1;
    L16:
        int r18 = r14.length;
    L17:
        if (r15 >= r18) goto L19;
        this.trustManagers.add(r14[r15]);
        r15 = r15 + 1;
    L19:
        return this;
    }

    public SSLContextBuilder setKeyManagerFactoryAlgorithm(String r10) {
        this.keyManagerFactoryAlgorithm = r10;
        return this;
    }

    public SSLContextBuilder setKeyStoreType(String r10) {
        this.keyStoreType = r10;
        return this;
    }

    public SSLContextBuilder setProtocol(String r10) {
        this.protocol = r10;
        return this;
    }

    public SSLContextBuilder setProvider(Provider r10) {
        this.provider = r10;
        return this;
    }

    public SSLContextBuilder setSecureRandom(SecureRandom r10) {
        this.secureRandom = r10;
        return this;
    }

    public SSLContextBuilder setTrustManagerFactoryAlgorithm(String r10) {
        this.trustManagerFactoryAlgorithm = r10;
        return this;
    }

    public String toString() {
        return "[provider=" + this.provider + ", protocol=" + this.protocol + ", keyStoreType=" + this.keyStoreType + ", keyManagerFactoryAlgorithm=" + this.keyManagerFactoryAlgorithm + ", keyManagers=" + this.keyManagers + ", trustManagerFactoryAlgorithm=" + this.trustManagerFactoryAlgorithm + ", trustManagers=" + this.trustManagers + ", secureRandom=" + this.secureRandom + "]";
    }

    @Deprecated
    public SSLContextBuilder useProtocol(String r10) {
        this.protocol = r10;
        return this;
    }

    public SSLContextBuilder setProvider(String r10) {
        this.provider = Security.getProvider(r10);
        return this;
    }

    public SSLContextBuilder loadKeyMaterial(KeyStore r10, char[] r11) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        return loadKeyMaterial(r10, r11, null);
    }

    public SSLContextBuilder loadTrustMaterial(TrustStrategy r10) throws NoSuchAlgorithmException, KeyStoreException {
        return loadTrustMaterial(null, r10);
    }

    public SSLContextBuilder loadKeyMaterial(File r10, char[] r11, char[] r12, PrivateKeyStrategy r13) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(r10, "Keystore file");
        KeyStore r14 = KeyStore.getInstance(this.keyStoreType);
        FileInputStream r15 = new FileInputStream(r10);
        r14.load(r15, r11);     // Catch: Throwable -> L6
        r15.close();
        return loadKeyMaterial(r14, r12, r13);
    L6:
        th = move-exception;
        r15.close();
        throw th;
    }

    public SSLContextBuilder loadTrustMaterial(File r10, char[] r11, TrustStrategy r12) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(r10, "Truststore file");
        KeyStore r13 = KeyStore.getInstance(this.keyStoreType);
        FileInputStream r14 = new FileInputStream(r10);
        r13.load(r14, r11);     // Catch: Throwable -> L6
        r14.close();
        return loadTrustMaterial(r13, r12);
    L6:
        th = move-exception;
        r14.close();
        throw th;
    }

    public SSLContextBuilder loadKeyMaterial(File r10, char[] r11, char[] r12) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(r10, r11, r12, null);
    }

    public SSLContextBuilder loadTrustMaterial(File r10, char[] r11) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r10, r11, null);
    }

    public SSLContextBuilder loadKeyMaterial(URL r10, char[] r11, char[] r12, PrivateKeyStrategy r13) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        Args.notNull(r10, "Keystore URL");
        KeyStore r14 = KeyStore.getInstance(this.keyStoreType);
        InputStream r15 = r10.openStream();
        r14.load(r15, r11);     // Catch: Throwable -> L6
        r15.close();
        return loadKeyMaterial(r14, r12, r13);
    L6:
        th = move-exception;
        r15.close();
        throw th;
    }

    public SSLContextBuilder loadTrustMaterial(File r10) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r10, null);
    }

    public SSLContextBuilder loadTrustMaterial(URL r10, char[] r11, TrustStrategy r12) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        Args.notNull(r10, "Truststore URL");
        KeyStore r13 = KeyStore.getInstance(this.keyStoreType);
        InputStream r14 = r10.openStream();
        r13.load(r14, r11);     // Catch: Throwable -> L6
        r14.close();
        return loadTrustMaterial(r13, r12);
    L6:
        th = move-exception;
        r14.close();
        throw th;
    }

    public SSLContextBuilder loadKeyMaterial(URL r10, char[] r11, char[] r12) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        return loadKeyMaterial(r10, r11, r12, null);
    }

    public SSLContextBuilder loadTrustMaterial(URL r10, char[] r11) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        return loadTrustMaterial(r10, r11, null);
    }
}
