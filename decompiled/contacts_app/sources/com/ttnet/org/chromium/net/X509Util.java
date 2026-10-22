package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.util.Pair;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.StringEncryptUtils;
import com.google.common.base.Ascii;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
@MainDex
public class X509Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char[] HEX_DIGITS = null;
    private static final String OID_ANY_EKU = "2.5.29.37.0";
    private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
    private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
    private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
    private static final String TAG = "X509Util";
    private static CertificateFactory sCertificateFactory;
    private static X509TrustManagerExtensions sDefaultTrustManager;
    private static boolean sLoadedSystemKeyStore;
    private static final Object sLock = null;
    private static File sSystemCertificateDirectory;
    private static KeyStore sSystemKeyStore;
    private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
    private static KeyStore sTestKeyStore;
    private static X509TrustManagerExtensions sTestTrustManager;
    private static TrustStorageListener sTrustStorageListener;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.X509Util$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    interface Natives {
        void notifyKeyChainChanged();
    }

    private static final class TrustStorageListener extends BroadcastReceiver {
        private TrustStorageListener() {
        }

        /* synthetic */ TrustStorageListener(AnonymousClass1 r1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r6) {
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r6.getAction()) == false) goto L5;
        L13:
            boolean r7 = true;
        L14:
            if (r7 == false) goto L26;
            X509Util.access$000();     // Catch: NoSuchAlgorithmException -> L17 KeyStoreException -> L19 CertificateException -> L21
        L29:
            return;
        L19:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L17:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L21:
            e = move-exception;
            Log.e(X509Util.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L26:
            return;
        L5:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r6.getAction()) == true) goto L13;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r6.getAction()) == true) goto L10;
        L12:
            r7 = false;
            goto L14
        L10:
            if (r6.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L12;
            goto L12
        }
    }

    public X509Util() {
    }

    static /* synthetic */ void access$000() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        reloadDefaultTrustManager();
    }

    private static List<X509Certificate> checkServerTrustedIgnoringRuntimeException(X509TrustManagerExtensions r0, X509Certificate[] r1, String r2, String r3) throws CertificateException {
        return r0.checkServerTrusted(r1, r2, r3);
    L4:
        e = move-exception;
        Log.e(TAG, "checkServerTrusted() unexpectedly threw: %s", new Object[]{e});
        throw new CertificateException(e);
    }

    static {
        sLock = new Object();
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static void ensureInitialized() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Object r0 = sLock;
        monitor-enter(r0);
        ensureInitializedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void ensureInitializedLocked() throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        if (sCertificateFactory != null) goto L5;
        sCertificateFactory = CertificateFactory.getInstance("X.509");
    L5:
        AnonymousClass1 r1 = null;
        if (sDefaultTrustManager != null) goto L9;
        sDefaultTrustManager = createTrustManager(null);
    L9:
        if (sLoadedSystemKeyStore == true) goto L15;
        KeyStore r0 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L30
        sSystemKeyStore = r0;     // Catch: KeyStoreException -> L30
        r0.load(null);     // Catch: IOException -> L28 KeyStoreException -> L30
    L12:
        sSystemCertificateDirectory = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L30
    L13:
        sLoadedSystemKeyStore = true;
    L15:
        if (sSystemTrustAnchorCache != null) goto L18;
        sSystemTrustAnchorCache = new HashSet();
    L18:
        if (sTestKeyStore != null) goto L22;
        KeyStore r2 = KeyStore.getInstance(KeyStore.getDefaultType());
        sTestKeyStore = r2;
        r2.load(null);     // Catch: IOException -> L29
    L22:
        if (sTestTrustManager != null) goto L25;
        sTestTrustManager = createTrustManager(sTestKeyStore);
    L25:
        if (sTrustStorageListener != null) goto L37;
        sTrustStorageListener = new TrustStorageListener(r1);
        IntentFilter r3 = new IntentFilter();
        r3.addAction("android.security.action.KEYCHAIN_CHANGED");
        r3.addAction("android.security.action.KEY_ACCESS_CHANGED");
        r3.addAction("android.security.action.TRUST_STORE_CHANGED");
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), sTrustStorageListener, r3);
        return;
    }

    private static X509TrustManagerExtensions createTrustManager(KeyStore r8) throws KeyStoreException, NoSuchAlgorithmException {
        TrustManagerFactory r1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r1.init(r8);
        TrustManager[] r2 = r1.getTrustManagers();     // Catch: RuntimeException -> L15
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        TrustManager r5 = r2[r4];
        if ((r5 instanceof X509TrustManager) == false) goto L12;
        return new X509TrustManagerExtensions((X509TrustManager) r5);
    L10:
        e = move-exception;
        Log.e(TAG, "Error creating trust manager (" + r5.getClass().getName() + "): " + e, new Object[0]);
    L12:
        r4 = r4 + 1;
        goto L5
    L13:
        Log.e(TAG, "Could not find suitable trust manager", new Object[0]);
        return null;
    L15:
        e = move-exception;
        Log.e(TAG, "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", new Object[]{e});
        throw new KeyStoreException(e);
    }

    private static void reloadTestTrustManager() throws KeyStoreException, NoSuchAlgorithmException {
        sTestTrustManager = createTrustManager(sTestKeyStore);
    }

    private static void reloadDefaultTrustManager() throws KeyStoreException, NoSuchAlgorithmException, CertificateException {
        Object r0 = sLock;
        monitor-enter(r0);
        sDefaultTrustManager = null;     // Catch: Throwable -> L9
        sSystemTrustAnchorCache = null;     // Catch: Throwable -> L9
        ensureInitializedLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        X509UtilJni.get().notifyKeyChainChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static X509Certificate createCertificateFromBytes(byte[] r2) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        return (X509Certificate) sCertificateFactory.generateCertificate(new ByteArrayInputStream(r2));
    }

    public static void addTestRootCertificate(byte[] r4) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        ensureInitialized();
        X509Certificate r5 = createCertificateFromBytes(r4);
        Object r1 = sLock;
        monitor-enter(r1);
        sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), r5);     // Catch: Throwable -> L7
        reloadTestTrustManager();     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        ensureInitialized();
        Object r0 = sLock;
        monitor-enter(r0);
        sTestKeyStore.load(null);     // Catch: Throwable -> L6 IOException -> L12
        reloadTestTrustManager();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    private static String hashPrincipal(X500Principal r6) throws NoSuchAlgorithmException {
        byte[] r7 = MessageDigest.getInstance(StringEncryptUtils.MD5).digest(r6.getEncoded());
        char[] r0 = new char[8];
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        int r2 = r1 * 2;
        char[] r3 = HEX_DIGITS;
        byte r4 = r7[3 - r1];
        r0[r2] = r3[(r4 >> 4) & 15];
        r0[r2 + 1] = r3[r4 & Ascii.SI];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    private static boolean isKnownRoot(X509Certificate r9) throws NoSuchAlgorithmException, KeyStoreException {
        if (sSystemKeyStore != null) goto L5;
        return false;
    L5:
        Pair<X500Principal, PublicKey> r0 = new Pair(r9.getSubjectX500Principal(), r9.getPublicKey());
        if (sSystemTrustAnchorCache.contains(r0) == false) goto L8;
        return true;
    L8:
        String r2 = hashPrincipal(r9.getSubjectX500Principal());
        int r4 = 0;
    L9:
        String r5 = r2 + '.' + r4;
        if (new File(sSystemCertificateDirectory, r5).exists() == false) goto L11;
        Certificate r6 = sSystemKeyStore.getCertificate("system:" + r5);
        if (r6 == null) goto L24;
        if ((r6 instanceof X509Certificate) == true) goto L18;
        Log.e(TAG, "Anchor " + r5 + " not an X509Certificate: " + r6.getClass().getName(), new Object[0]);
        goto L24
    L18:
        X509Certificate r7 = (X509Certificate) r6;
        if (r9.getSubjectX500Principal().equals(r7.getSubjectX500Principal()) == false) goto L24;
        if (r9.getPublicKey().equals(r7.getPublicKey()) == false) goto L24;
        sSystemTrustAnchorCache.add(r0);
        return true;
    L24:
        r4 = r4 + 1;
        goto L9
    L11:
        return false;
    }

    static boolean verifyKeyUsage(X509Certificate r4) throws CertificateException {
        List<String> r5 = r4.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r5 != null) goto L7;
        return true;
    L7:
        Iterator<String> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L19;
        String r2 = r6.next();
        if (r2.equals(OID_TLS_SERVER_AUTH) == true) goto L18;
        if (r2.equals(OID_ANY_EKU) == true) goto L18;
        if (r2.equals(OID_SERVER_GATED_NETSCAPE) == true) goto L18;
        if (r2.equals(OID_SERVER_GATED_MICROSOFT) == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r8, String r9, String r10) throws KeyStoreException, NoSuchAlgorithmException {
        if (r8 == null) goto L58;
        if (r8.length == 0) goto L58;
        if (r8[0] == null) goto L58;
        ensureInitialized();     // Catch: CertificateException -> L55
        ArrayList r2 = new ArrayList();
        r2.add(createCertificateFromBytes(r8[0]));     // Catch: CertificateException -> L53
        int r4 = 1;
    L13:
        if (r4 >= r8.length) goto L18;
        r2.add(createCertificateFromBytes(r8[r4]));     // Catch: CertificateException -> L16
    L17:
        r4 = r4 + 1;
    L16:
        Log.w(TAG, "intermediate " + r4 + " failed parsing", new Object[0]);
        goto L17
    L18:
        X509Certificate[] r11 = (X509Certificate[]) r2.toArray(new X509Certificate[r2.size()]);
        r11[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (verifyKeyUsage(r11[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r3 = sLock;
        monitor-enter(r3);
        X509TrustManagerExtensions r5 = sDefaultTrustManager;     // Catch: Throwable -> L44
        if (r5 != null) goto L63;
        AndroidCertVerifyResult r12 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r12;
    L63:
        List<X509Certificate> r13 = checkServerTrustedIgnoringRuntimeException(r5, r11, r9, r10);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r13.size() <= 0) goto L37;
        boolean r14 = isKnownRoot(r13.get(r13.size() - 1));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r15 = new AndroidCertVerifyResult(0, r14, r13);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r15;
    L37:
        r14 = false;
    L32:
        e = move-exception;
        r13 = checkServerTrustedIgnoringRuntimeException(sTestTrustManager, r11, r9, r10);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        Log.i(TAG, "Failed to validate the certificate chain, error: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L44
        return new AndroidCertVerifyResult(-2);
    L44:
        th = move-exception;
        throw th;
    L52:
        return new AndroidCertVerifyResult(-3);
    L50:
        return new AndroidCertVerifyResult(-4);
    L48:
        return new AndroidCertVerifyResult(-1);
    L54:
        return new AndroidCertVerifyResult(-5);
    L56:
        return new AndroidCertVerifyResult(-1);
    L58:
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(r8));
    }
}
