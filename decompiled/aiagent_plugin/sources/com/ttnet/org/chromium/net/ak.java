package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Pair;
import com.bytedance.crypto.utils.CryptoConst;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: compiled from: X509Util.java */
/* JADX INFO: loaded from: classes4.dex */
public class ak {
    private static final String TAG = "X509Util";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37890a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CertificateFactory f37891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static X509TrustManagerExtensions f37892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f37893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static X509TrustManagerExtensions f37894e;
    private static KeyStore f;
    private static KeyStore g;
    private static File h;
    private static Set<Pair<X500Principal, PublicKey>> i;
    private static boolean j;
    private static final Object k = null;
    private static final char[] l = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ak$1, reason: invalid class name */
    /* JADX INFO: compiled from: X509Util.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: X509Util.java */
    interface a {
        void a();
    }

    /* JADX INFO: compiled from: X509Util.java */
    private static final class b extends PluginBroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        public void onReceive(Context r5, Intent r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            if (Build.VERSION.SDK_INT >= 26) goto L5;
            boolean r8 = "android.security.STORAGE_CHANGED".equals(r6.getAction());
        L17:
            if (r8 == false) goto L29;
            ak.b();     // Catch: NoSuchAlgorithmException -> L20 KeyStoreException -> L22 CertificateException -> L24
        L32:
            return;
        L22:
            e = move-exception;
            com.ttnet.org.chromium.base.j.e(ak.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L20:
            e = move-exception;
            com.ttnet.org.chromium.base.j.e(ak.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L24:
            e = move-exception;
            com.ttnet.org.chromium.base.j.e(ak.TAG, "Unable to reload the default TrustManager", new Object[]{e});
            return;
        L29:
            return;
        L5:
            if ("android.security.action.KEYCHAIN_CHANGED".equals(r6.getAction()) == false) goto L7;
        L15:
            r8 = true;
            goto L17
        L7:
            if ("android.security.action.TRUST_STORE_CHANGED".equals(r6.getAction()) == true) goto L15;
            if ("android.security.action.KEY_ACCESS_CHANGED".equals(r6.getAction()) == true) goto L12;
        L14:
            r8 = false;
            goto L17
        L12:
            if (r6.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false) == true) goto L14;
            goto L14
        }
    }

    public ak() {
    }

    static /* synthetic */ void b() {
        f();
    }

    private static List<X509Certificate> a(X509TrustManagerExtensions r0, X509Certificate[] r1, String r2, String r3) {
        return r0.checkServerTrusted(r1, r2, r3);
    L4:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "checkServerTrusted() unexpectedly threw: %s", new Object[]{e});
        throw new CertificateException(e);
    }

    static {
        k = new Object();
        l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    private static void c() {
        Object r0 = k;
        monitor-enter(r0);
        d();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void d() {
        if (f37890a == true) goto L10;
        if (Thread.holdsLock(k) == true) goto L10;
        throw new AssertionError();
    L10:
        if (f37891b != null) goto L12;
        f37891b = CertificateFactory.getInstance("X.509");
    L12:
        AnonymousClass1 r1 = null;
        if (f37892c != null) goto L16;
        f37892c = a(null);
    L16:
        if (j == true) goto L22;
        KeyStore r0 = KeyStore.getInstance("AndroidCAStore");     // Catch: KeyStoreException -> L41
        g = r0;     // Catch: KeyStoreException -> L41
        r0.load(null);     // Catch: IOException -> L39 KeyStoreException -> L41
    L19:
        h = new File(System.getenv("ANDROID_ROOT") + "/etc/security/cacerts");     // Catch: KeyStoreException -> L41
    L20:
        j = true;
    L22:
        if (i != null) goto L25;
        i = new HashSet();
    L25:
        if (f != null) goto L29;
        KeyStore r2 = KeyStore.getInstance(KeyStore.getDefaultType());
        f = r2;
        r2.load(null);     // Catch: IOException -> L40
    L29:
        if (f37894e != null) goto L32;
        f37894e = a(f);
    L32:
        if (f37893d != null) goto L48;
        f37893d = new b(r1);
        IntentFilter r3 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 26) goto L36;
        r3.addAction("android.security.action.KEYCHAIN_CHANGED");
        r3.addAction("android.security.action.KEY_ACCESS_CHANGED");
        r3.addAction("android.security.action.TRUST_STORE_CHANGED");
    L37:
        com.ttnet.org.chromium.base.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), f37893d, r3);
        return;
    L36:
        r3.addAction("android.security.STORAGE_CHANGED");
        goto L37
    }

    private static X509TrustManagerExtensions a(KeyStore r8) {
        TrustManagerFactory r1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        r1.init(r8);
        TrustManager[] r2 = r1.getTrustManagers();     // Catch: RuntimeException -> L15
        int r3 = r2.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L13;
        TrustManager r5 = r2[r4];
        if (ZeusTransformUtils.instanceOf(r5, X509TrustManager.class) == false) goto L12;
        return new X509TrustManagerExtensions((X509TrustManager) ZeusTransformUtils.preCheckCast(r5, X509TrustManager.class, "com.obric.aiagent.plugin"));
    L10:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Error creating trust manager (" + r5.getClass().getName() + "): " + e, new Object[0]);
    L12:
        r4 = r4 + 1;
        goto L5
    L13:
        com.ttnet.org.chromium.base.j.e(TAG, "Could not find suitable trust manager", new Object[0]);
        return null;
    L15:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "TrustManagerFactory.getTrustManagers() unexpectedly threw: %s", new Object[]{e});
        throw new KeyStoreException(e);
    }

    private static void e() {
        if (f37890a == false) goto L5;
    L9:
        f37894e = a(f);
        return;
    L5:
        if (Thread.holdsLock(k) == true) goto L9;
        throw new AssertionError();
    }

    private static void f() {
        Object r0 = k;
        monitor-enter(r0);
        f37892c = null;     // Catch: Throwable -> L9
        i = null;     // Catch: Throwable -> L9
        d();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        al.b().a();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static X509Certificate a(byte[] r2) {
        c();
        return (X509Certificate) ZeusTransformUtils.preCheckCast(f37891b.generateCertificate(new ByteArrayInputStream(r2)), X509Certificate.class, "com.obric.aiagent.plugin");
    }

    public static void b(byte[] r4) {
        c();
        X509Certificate r5 = a(r4);
        Object r0 = k;
        monitor-enter(r0);
        f.setCertificateEntry("root_cert_" + Integer.toString(f.size()), r5);     // Catch: Throwable -> L7
        e();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a() {
        c();
        Object r0 = k;
        monitor-enter(r0);
        f.load(null);     // Catch: Throwable -> L6 IOException -> L12
        e();     // Catch: Throwable -> L6 IOException -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L6
    }

    private static String a(X500Principal r7) {
        byte[] r8 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5).digest(r7.getEncoded());
        char[] r0 = new char[8];
        int r1 = 0;
    L4:
        if (r1 >= 4) goto L7;
        int r3 = r1 * 2;
        char[] r4 = l;
        int r5 = 3 - r1;
        r0[r3] = r4[(r8[r5] >> 4) & 15];
        r0[r3 + 1] = r4[r8[r5] & 15];
        r1 = r1 + 1;
        goto L4
    L7:
        return new String(r0);
    }

    private static boolean b(X509Certificate r9) {
        if (f37890a == true) goto L10;
        if (Thread.holdsLock(k) == true) goto L10;
        throw new AssertionError();
    L10:
        if (g != null) goto L12;
        return false;
    L12:
        Pair<X500Principal, PublicKey> r0 = new Pair(r9.getSubjectX500Principal(), r9.getPublicKey());
        if (i.contains(r0) == false) goto L15;
        return true;
    L15:
        String r2 = a(r9.getSubjectX500Principal());
        int r4 = 0;
    L16:
        String r5 = r2 + '.' + r4;
        if (new File(h, r5).exists() == false) goto L18;
        Certificate r6 = g.getCertificate("system:" + r5);
        if (r6 == null) goto L31;
        if (ZeusTransformUtils.instanceOf(r6, X509Certificate.class) == true) goto L25;
        com.ttnet.org.chromium.base.j.e(TAG, "Anchor " + r5 + " not an X509Certificate: " + r6.getClass().getName(), new Object[0]);
        goto L31
    L25:
        X509Certificate r7 = (X509Certificate) ZeusTransformUtils.preCheckCast(r6, X509Certificate.class, "com.obric.aiagent.plugin");
        if (r9.getSubjectX500Principal().equals(r7.getSubjectX500Principal()) == false) goto L31;
        if (r9.getPublicKey().equals(r7.getPublicKey()) == false) goto L31;
        i.add(r0);
        return true;
    L31:
        r4 = r4 + 1;
        goto L16
    L18:
        return false;
    }

    static boolean a(X509Certificate r5) {
        List<String> r6 = r5.getExtendedKeyUsage();     // Catch: NullPointerException -> L20
        if (r6 != null) goto L7;
        return true;
    L7:
        Iterator<String> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L19;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin");
        if (r2.equals("1.3.6.1.5.5.7.3.1") == true) goto L18;
        if (r2.equals("2.5.29.37.0") == true) goto L18;
        if (r2.equals("2.16.840.1.113730.4.1") == true) goto L18;
        if (r2.equals("1.3.6.1.4.1.311.10.3.3") == false) goto L9;
    L18:
        return true;
    L19:
        return false;
    }

    public static AndroidCertVerifyResult a(byte[][] r8, String r9, String r10) {
        if (r8 == null) goto L58;
        if (r8.length == 0) goto L58;
        if (r8[0] == null) goto L58;
        c();     // Catch: CertificateException -> L55
        ArrayList r2 = new ArrayList();
        r2.add(a(r8[0]));     // Catch: CertificateException -> L53
        int r4 = 1;
    L13:
        if (r4 >= r8.length) goto L18;
        r2.add(a(r8[r4]));     // Catch: CertificateException -> L16
    L17:
        r4 = r4 + 1;
    L16:
        com.ttnet.org.chromium.base.j.d(TAG, "intermediate " + r4 + " failed parsing", new Object[0]);
        goto L17
    L18:
        X509Certificate[] r11 = (X509Certificate[]) ZeusTransformUtils.preCheckCast(r2.toArray(new X509Certificate[r2.size()]), X509Certificate[].class, "com.obric.aiagent.plugin");
        r11[0].checkValidity();     // Catch: CertificateException -> L47 CertificateNotYetValidException -> L49 CertificateExpiredException -> L51
        if (a(r11[0]) == true) goto L23;
        return new AndroidCertVerifyResult(-6);
    L23:
        Object r3 = k;
        monitor-enter(r3);
        X509TrustManagerExtensions r5 = f37892c;     // Catch: Throwable -> L44
        if (r5 != null) goto L61;
        AndroidCertVerifyResult r12 = new AndroidCertVerifyResult(-1);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r12;
    L61:
        List<X509Certificate> r13 = a(r5, r11, r9, r10);     // Catch: CertificateException -> L32 Throwable -> L44
    L35:
        if (r13.size() <= 0) goto L37;
        boolean r14 = b((X509Certificate) ZeusTransformUtils.preCheckCast(r13.get(r13.size() - 1), X509Certificate.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L44
    L38:
        AndroidCertVerifyResult r15 = new AndroidCertVerifyResult(0, r14, r13);     // Catch: Throwable -> L44
        monitor-exit(r3);     // Catch: Throwable -> L44
        return r15;
    L37:
        r14 = false;
    L32:
        e = move-exception;
        r13 = a(f37894e, r11, r9, r10);     // Catch: CertificateException -> L41 Throwable -> L44
    L41:
        com.ttnet.org.chromium.base.j.c(TAG, "Failed to validate the certificate chain, error: " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L44
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
