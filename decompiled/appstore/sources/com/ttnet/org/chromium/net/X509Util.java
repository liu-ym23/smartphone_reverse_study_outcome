package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.util.Pair;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public abstract class X509Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CertificateFactory f18471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static X509TrustManagerImplementation f18472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f18473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static X509TrustManagerImplementation f18474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static KeyStore f18475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static KeyStore f18476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static File f18477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Set f18478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f18479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f18480j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f18481k = null;

    public interface Natives {
        void notifyKeyChainChanged();
    }

    public interface X509TrustManagerImplementation {
        List<X509Certificate> checkServerTrusted(X509Certificate[] r10, String r11, String r12) throws CertificateException;
    }

    public static /* synthetic */ class a {
    }

    public static final class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r11.getAction()) == false) goto L5;
        L20:
            X509Util.a();     // Catch: NoSuchAlgorithmException -> L13 KeyStoreException -> L15 CertificateException -> L17
        L26:
            return;
        L15:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a("X509Util", "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L13:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a("X509Util", "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L17:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a("X509Util", "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L5:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r11.getAction()) == true) goto L20;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r11.getAction()) == true) goto L10;
            return;
        L10:
            if (r11.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == false) goto L20;
        }

        public /* synthetic */ b(a r10) {
            this();
        }
    }

    public static final class c implements X509TrustManagerImplementation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final X509TrustManagerExtensions f18482a;

        public c(X509TrustManager r10) {
            this.f18482a = new X509TrustManagerExtensions(r10);
        }

        @Override // com.ttnet.org.chromium.net.X509Util.X509TrustManagerImplementation
        public List checkServerTrusted(X509Certificate[] r10, String r11, String r12) {
            return this.f18482a.checkServerTrusted(r10, r11, r12);
        L4:
            e = move-exception;
            com.ttnet.org.chromium.base.j.a("X509Util", "checkServerTrusted() unexpectedly threw: %s", new Object[]{e});
            throw new CertificateException(e);
        }
    }

    static {
        f18480j = new Object();
        f18481k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static /* synthetic */ void a() {
        j();
    }

    public static void b(byte[] r10) {
        f();
        X509Certificate r11 = d(r10);
        Object r12 = f18480j;
        monitor-enter(r12);
        f18475e.setCertificateEntry("root_cert_" + Integer.toString(f18475e.size()), r11);     // Catch: Throwable -> L7
        k();     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c() {
        f();
        Object r10 = f18480j;
        monitor-enter(r10);
        f18475e.load(null);     // Catch: Throwable -> L6 IOException -> L12
        k();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L6
    }

    public static X509Certificate d(byte[] r10) {
        f();
        return (X509Certificate) f18471a.generateCertificate(new ByteArrayInputStream(r10));
    }

    public static X509TrustManagerImplementation e(KeyStore r10) {
        TrustManagerFactory r11 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r11.init(r10);
        TrustManager[] r12 = r11.getTrustManagers();     // Catch: RuntimeException -> L15
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L13;
        TrustManager r15 = r12[r14];
        if ((r15 instanceof X509TrustManager) == false) goto L12;
        return new c((X509TrustManager) r15);
    L10:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a("X509Util", "Error creating trust manager (" + r15.getClass().getName() + "): " + e, new Object[0]);
    L12:
        r14 = r14 + 1;
        goto L5
    L13:
        com.ttnet.org.chromium.base.j.a("X509Util", "Could not find suitable trust manager", new Object[0]);
        return null;
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.a("X509Util", "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", new Object[]{e});
        throw new KeyStoreException(e);
    }

    public static void f() {
        Object r10 = f18480j;
        monitor-enter(r10);
        g();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void g() {
        if (f18471a != null) goto L5;
        f18471a = CertificateFactory.getInstance("X.509");
    L5:
        a r10 = null;
        if (f18472b != null) goto L9;
        f18472b = e(null);
    L9:
        if (f18479i == true) goto L15;
        KeyStore r11 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L30
        f18476f = r11;     // Catch: KeyStoreException -> L30
        r11.load(null);     // Catch: IOException -> L28 KeyStoreException -> L30
    L12:
        f18477g = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L30
    L13:
        f18479i = true;
    L15:
        if (f18478h != null) goto L18;
        f18478h = new HashSet();
    L18:
        if (f18475e != null) goto L22;
        KeyStore r12 = KeyStore.getInstance(KeyStore.getDefaultType());
        f18475e = r12;
        r12.load(null);     // Catch: IOException -> L29
    L22:
        if (f18474d != null) goto L25;
        f18474d = e(f18475e);
    L25:
        if (f18473c != null) goto L37;
        f18473c = new b(r10);
        IntentFilter r13 = new IntentFilter();
        r13.addAction("android.security.action.KEYCHAIN_CHANGED");
        r13.addAction("android.security.action.KEY_ACCESS_CHANGED");
        r13.addAction("android.security.action.TRUST_STORE_CHANGED");
        com.ttnet.org.chromium.base.e.d().registerReceiver(f18473c, r13);
        return;
    }

    public static String h(X500Principal r10) {
        byte[] r11 = MessageDigest.getInstance("MD5").digest(r10.getEncoded());
        char[] r12 = new char[8];
        int r13 = 0;
    L4:
        if (r13 >= 4) goto L7;
        int r14 = r13 * 2;
        char[] r15 = f18481k;
        byte r16 = r11[3 - r13];
        r12[r14] = r15[(r16 >> 4) & 15];
        r12[r14 + 1] = r15[r16 & Ascii.SI];
        r13 = r13 + 1;
        goto L4
    L7:
        return new String(r12);
    }

    public static boolean i(X509Certificate r10) {
        if (f18476f != null) goto L5;
        return false;
    L5:
        Pair r11 = new Pair(r10.getSubjectX500Principal(), r10.getPublicKey());
        if (f18478h.contains(r11) == false) goto L8;
        return true;
    L8:
        String r12 = h(r10.getSubjectX500Principal());
        int r13 = 0;
    L9:
        String r14 = r12 + '.' + r13;
        if (new File(f18477g, r14).exists() == false) goto L11;
        Certificate r15 = f18476f.getCertificate("system:" + r14);
        if (r15 == null) goto L24;
        if ((r15 instanceof X509Certificate) == true) goto L18;
        com.ttnet.org.chromium.base.j.a("X509Util", "Anchor " + r14 + " not an X509Certificate: " + r15.getClass().getName(), new Object[0]);
        goto L24
    L18:
        X509Certificate r16 = (X509Certificate) r15;
        if (r10.getSubjectX500Principal().equals(r16.getSubjectX500Principal()) == false) goto L24;
        if (r10.getPublicKey().equals(r16.getPublicKey()) == false) goto L24;
        f18478h.add(r11);
        return true;
    L24:
        r13 = r13 + 1;
        goto L9
    L11:
        return false;
    }

    public static void j() {
        Object r10 = f18480j;
        monitor-enter(r10);
        f18472b = null;     // Catch: Throwable -> L9
        f18478h = null;     // Catch: Throwable -> L9
        g();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        c0.b().notifyKeyChainChanged();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void k() {
        f18474d = e(f18475e);
    }

    public static boolean l(X509Certificate r10) {
        List<String> r11 = r10.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r11 != null) goto L7;
        return true;
    L7:
        Iterator<String> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L19;
        String r13 = r12.next();
        if (r13.equals("1.3.6.1.5.5.7.3.1") == true) goto L18;
        if (r13.equals("2.5.29.37.0") == true) goto L18;
        if (r13.equals("2.16.840.1.113730.4.1") == true) goto L18;
        if (r13.equals("1.3.6.1.4.1.311.10.3.3") == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult m(byte[][] r10, String r11, String r12) {
        if (r10 == null) goto L59;
        if (r10.length == 0) goto L59;
        if (r10[0] == null) goto L59;
        f();     // Catch: CertificateException -> L56
        ArrayList r13 = new ArrayList();
        r13.add(d(r10[0]));     // Catch: CertificateException -> L54
        int r14 = 1;
    L13:
        if (r14 >= r10.length) goto L18;
        r13.add(d(r10[r14]));     // Catch: CertificateException -> L16
    L17:
        r14 = r14 + 1;
    L16:
        com.ttnet.org.chromium.base.j.h("X509Util", "intermediate " + r14 + " failed parsing", new Object[0]);
        goto L17
    L18:
        X509Certificate[] r15 = (X509Certificate[]) r13.toArray(new X509Certificate[r13.size()]);
        r15[0].checkValidity();     // Catch: CertificateException -> L48 CertificateNotYetValidException -> L50 CertificateExpiredException -> L52
        if (l(r15[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r16 = f18480j;
        monitor-enter(r16);
        X509TrustManagerImplementation r17 = f18472b;     // Catch: Throwable -> L30
        if (r17 != null) goto L67;
        AndroidCertVerifyResult r18 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L30
        monitor-exit(r16);     // Catch: Throwable -> L30
        return r18;
    L67:
        List<X509Certificate> r19 = r17.checkServerTrusted(r15, r11, r12);     // Catch: Throwable -> L30 CertificateException -> L34
    L37:
        if (r19.size() <= 0) goto L39;
        boolean r20 = i(r19.get(r19.size() - 1));     // Catch: Throwable -> L30
    L40:
        AndroidCertVerifyResult r110 = new AndroidCertVerifyResult(0, r20, r19);     // Catch: Throwable -> L30
        monitor-exit(r16);     // Catch: Throwable -> L30
        return r110;
    L39:
        r20 = false;
    L34:
        e = move-exception;
        r19 = f18474d.checkServerTrusted(r15, r11, r12);     // Catch: Throwable -> L30 CertificateException -> L43
    L43:
        com.ttnet.org.chromium.base.j.d("X509Util", "Failed to validate the certificate chain, error: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L30
        return new AndroidCertVerifyResult(-2);
    L30:
        th = move-exception;
        throw th;
    L53:
        return new AndroidCertVerifyResult(-3);
    L51:
        return new AndroidCertVerifyResult(-4);
    L49:
        return new AndroidCertVerifyResult(-1);
    L55:
        return new AndroidCertVerifyResult(-5);
    L57:
        return new AndroidCertVerifyResult(-1);
    L59:
        throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(r10));
    }
}
