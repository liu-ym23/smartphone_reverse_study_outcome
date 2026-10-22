package com.android.server.pm;

import android.content.pm.PackageParser;
import android.content.pm.Signature;
import android.util.Slog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BytedancePackageVerifier {
    private static final String CERT_FILE = "/system/etc/security/bytedance.x509.pem";
    private static final String TAG = "PackageVerifier";
    private static final ArrayList<String> WHITE_LIST = null;

    public BytedancePackageVerifier() {
    }

    static {
        WHITE_LIST = new ArrayList();
        WHITE_LIST.add("com.bytedanceos.smartfolder");
    }

    private static PublicKey getPublictKeyFromCert(String certFile) {
        FileInputStream in = null;
        CertificateFactory cf = CertificateFactory.getInstance("X.509");     // Catch: Throwable -> L6 FileNotFoundException -> L8 CertificateException -> L10
        if (certFile != null) goto L12;
        String r5 = CERT_FILE;
    L13:
        in = new FileInputStream(r5);     // Catch: Throwable -> L6 FileNotFoundException -> L8 CertificateException -> L10
        Certificate cer = cf.generateCertificate(in);     // Catch: Throwable -> L6 FileNotFoundException -> L8 CertificateException -> L10
        PublicKey pk = cer.getPublicKey();     // Catch: Throwable -> L6 FileNotFoundException -> L8 CertificateException -> L10
        in.close();     // Catch: IOException -> L16
    L18:
        return pk;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L12:
        r5 = certFile;
    L6:
        th = move-exception;
        if (in != null) goto L41;
    L40:
        throw th;
    L41:
        in.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
    L20:
        Slog.w(TAG, "No app certificate found !!!");     // Catch: Throwable -> L6
        if (in != null) goto L49;
    L26:
        return null;
    L49:
        in.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L28:
        Slog.w(TAG, "Get app certificate failed !!!");     // Catch: Throwable -> L6
        if (in != null) goto L47;
    L34:
        return null;
    L47:
        in.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    private static PackageParser.Package getPackageFor(String pkg) {
        File pkgFile = new File(pkg);
        if (pkgFile.exists() == true) goto L5;
    L13:
        Slog.w(TAG, "apk wrong:" + pkg);
        return null;
    L5:
        if (pkgFile.isDirectory() == true) goto L13;
        PackageParser pp = new PackageParser();
        PackageParser.Package p = pp.parseMonolithicPackage(pkgFile, 0);     // Catch: PackageParser.PackageParserException -> L10
        PackageParser.collectCertificates(p, false);     // Catch: PackageParser.PackageParserException -> L10
        return p;
    L11:
        Slog.w(TAG, "Parse package failed");
        return null;
    }

    public static boolean verifyPackage(String pkg, String certFile) {
        if (pkg != null) goto L4;
        return false;
    L4:
        if (pkg.length() <= 0) goto L9;
        PackageParser.Package p = getPackageFor(pkg);
        return verifyPackage(p, certFile);
    L9:
        return false;
    }

    public static boolean verifyPackage(PackageParser.Package pkg, String certFile) {
        if (pkg != null) goto L5;
    L16:
        Slog.w(TAG, "Either pkg or signature is null");
        return false;
    L5:
        if (pkg.mSigningDetails.signatures == null) goto L16;
        if (WHITE_LIST.contains(pkg.packageName) == true) goto L10;
        return false;
    L10:
        PublicKey pk = getPublictKeyFromCert(certFile);
        if (pk != null) goto L15;
        Slog.w(TAG, "Failed get certificate");
        return false;
    L15:
        return verifyPackage(pkg.mSigningDetails.signatures, pk);
    }

    public static boolean verifyPackage(Signature[] signatures, PublicKey pk) {
        if (signatures != null) goto L5;
    L23:
        return false;
    L5:
        if (signatures.length <= 0) goto L23;
        if (pk != null) goto L12;
        pk = getPublictKeyFromCert(CERT_FILE);
        if (pk != null) goto L12;
        Slog.w(TAG, "Failed get certificate");
        return false;
    L12:
        int r1 = signatures.length;
        int r2 = 0;
    L13:
        if (r2 >= r1) goto L22;
        Signature sig = signatures[r2];
        if (sig.getPublicKey().equals(pk) == true) goto L17;
        r2 = r2 + 1;
        goto L13
    L17:
        return true;
    L21:
        return false;
    L22:
        return false;
    }
}
