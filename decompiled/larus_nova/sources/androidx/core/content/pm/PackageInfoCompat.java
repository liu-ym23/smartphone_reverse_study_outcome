package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageInfoCompat {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Signature[] getApkContentsSigners(SigningInfo r100) {
            return r100.getApkContentsSigners();
        }

        public static long getLongVersionCode(PackageInfo r100) {
            return r100.getLongVersionCode();
        }

        public static Signature[] getSigningCertificateHistory(SigningInfo r100) {
            return r100.getSigningCertificateHistory();
        }

        public static boolean hasMultipleSigners(SigningInfo r100) {
            return r100.hasMultipleSigners();
        }

        public static boolean hasSigningCertificate(PackageManager r100, String r101, byte[] r102, int r103) {
            return r100.hasSigningCertificate(r101, r102, r103);
        }
    }

    private PackageInfoCompat() {
    }

    private static byte[] computeSHA256Digest(byte[] r100) {
        return MessageDigest.getInstance("SHA256").digest(r100);
    L4:
        e = move-exception;
        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
    }

    public static long getLongVersionCode(PackageInfo r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getLongVersionCode(r100);
    L7:
        return r100.versionCode;
    }

    private static boolean byteArrayContains(byte[][] r100, byte[] r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (Arrays.equals(r101, r100[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static List<Signature> getSignatures(PackageManager r100, String r101) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT < 28) goto L8;
        SigningInfo r102 = r100.getPackageInfo(r101, AMapEngineUtils.HALF_MAX_P20_WIDTH).signingInfo;
        if (Api28Impl.hasMultipleSigners(r102) == false) goto L7;
        Signature[] r103 = Api28Impl.getApkContentsSigners(r102);
    L9:
        if (r103 != null) goto L13;
        return Collections.emptyList();
    L13:
        return Arrays.asList(r103);
    L7:
        r103 = Api28Impl.getSigningCertificateHistory(r102);
        goto L9
    L8:
        r103 = r100.getPackageInfo(r101, 64).signatures;
        goto L9
    }

    public static boolean hasSignatures(PackageManager r100, String r101, Map<byte[], Integer> r102, boolean r110) throws PackageManager.NameNotFoundException {
        if (r102.isEmpty() == false) goto L5;
        return false;
    L5:
        Set<byte[]> r103 = r102.keySet();
        Iterator<byte[]> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L22;
        byte[] r105 = r104.next();
        if (r105 == null) goto L21;
        Integer r106 = r102.get(r105);
        if (r106 == null) goto L19;
        int r107 = r106.intValue();
        if (r107 == 0) goto L7;
        if (r107 == 1) goto L7;
        throw new IllegalArgumentException("Unsupported certificate type " + r106 + " when verifying " + r101);
    L19:
        throw new IllegalArgumentException("Type must be specified for cert when verifying " + r101);
    L21:
        throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + r101);
    L22:
        List<Signature> r108 = getSignatures(r100, r101);
        if (r110 == true) goto L34;
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Iterator<byte[]> r111 = r103.iterator();
    L28:
        if (r111.hasNext() == false) goto L32;
        byte[] r109 = r111.next();
        if (Api28Impl.hasSigningCertificate(r100, r101, r109, r102.get(r109).intValue()) == true) goto L28;
        return false;
    L32:
        return true;
    L34:
        if (r108.size() != 0) goto L36;
    L62:
        return false;
    L36:
        if (r102.size() > r108.size()) goto L62;
        if (r110 == false) goto L42;
        if (r102.size() != r108.size()) goto L62;
    L42:
        if (r102.containsValue(1) == false) goto L47;
        byte[][] r112 = new byte[r108.size()][];
        int r113 = 0;
    L45:
        if (r113 >= r108.size()) goto L48;
        r112[r113] = computeSHA256Digest(((Signature) ListProtector.get(r108, r113)).toByteArray());
        r113 = r113 + 1;
    L48:
        Iterator<byte[]> r114 = r103.iterator();
        if (r114.hasNext() == false) goto L62;
        byte[] r115 = r114.next();
        Integer r116 = r102.get(r115);
        int r117 = r116.intValue();
        if (r117 == 0) goto L59;
        if (r117 != 1) goto L57;
        if (byteArrayContains(r112, r115) == true) goto L61;
        return false;
    L61:
        return true;
    L57:
        throw new IllegalArgumentException("Unsupported certificate type " + r116);
    L59:
        if (r108.contains(new Signature(r115)) == true) goto L61;
        return false;
    L47:
        r112 = null;
        goto L48
    }
}
