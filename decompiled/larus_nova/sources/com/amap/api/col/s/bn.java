package com.amap.api.col.s;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.NamedPipe;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Symlink;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes28.dex */
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f26303a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f26304b = null;

    static {
        f26303a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', OthersPermission.STICKY, Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f', 'g', 'h', 'i', 'j', 'k', Symlink.UNIX_ID, 'm', 'n', 'o', NamedPipe.UNIX_ID, 'q', Permission.READ, 's', OthersPermission.STICKY_E, 'u', 'v', Permission.WRITE, Permission.EXECUTE, 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f26304b = new byte[128];
        int r100 = 0;
    L3:
        if (r100 >= 128) goto L5;
        f26304b[r100] = -1;
        r100 = r100 + 1;
        goto L3
    L5:
        int r101 = 65;
    L7:
        if (r101 > 90) goto L9;
        f26304b[r101] = (byte) (r101 - 65);
        r101 = r101 + 1;
        goto L7
    L9:
        int r102 = 97;
    L11:
        if (r102 > 122) goto L13;
        f26304b[r102] = (byte) ((r102 - 97) + 26);
        r102 = r102 + 1;
        goto L11
    L13:
        int r103 = 48;
    L15:
        if (r103 > 57) goto L17;
        f26304b[r103] = (byte) ((r103 - 48) + 52);
        r103 = r103 + 1;
        goto L15
    L17:
        byte[] r104 = f26304b;
        r104[43] = 62;
        r104[47] = 63;
    }

    public static byte[] a(byte[] r100) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator r101 = KeyGenerator.getInstance(bs.c("EQUVT"));
        if (r101 != null) goto L5;
        return null;
    L5:
        r101.init(256);
        byte[] r102 = r101.generateKey().getEncoded();
        PublicKey r103 = bs.d();
        if (r103 != null) goto L8;
        return null;
    L8:
        byte[] r104 = a(r102, r103);
        byte[] r105 = a(r102, r100);
        byte[] r106 = new byte[r104.length + r105.length];
        System.arraycopy(r104, 0, r106, 0, r104.length);
        System.arraycopy(r105, 0, r106, r104.length, r105.length);
        return r106;
    }

    public static byte[] b(String r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        byte[] r102 = bs.a(r100);
        int r103 = r102.length;
        ByteArrayOutputStream r104 = new ByteArrayOutputStream(r103);
    L7:
        if (r101 >= r103) goto L50;
    L8:
        int r105 = r101 + 1;
        byte r106 = f26304b[r102[r101]];
        if (r105 >= r103) goto L13;
        if (r106 != (-1)) goto L13;
        r101 = r105;
    L13:
        if (r106 == (-1)) goto L50;
    L14:
        int r107 = r105 + 1;
        byte r108 = f26304b[r102[r105]];
        if (r107 >= r103) goto L19;
        if (r108 != (-1)) goto L19;
        r105 = r107;
    L19:
        if (r108 == (-1)) goto L50;
        r104.write((r106 << 2) | ((r108 & 48) >>> 4));
    L21:
        if (r107 == r103) goto L23;
        int r109 = r107 + 1;
        byte r110 = r102[r107];
        if (r110 == 61) goto L27;
        byte r111 = f26304b[r110];
        if (r109 >= r103) goto L33;
        if (r111 != (-1)) goto L33;
        r107 = r109;
    L33:
        if (r111 == (-1)) goto L50;
        r104.write(((r108 & 15) << 4) | ((r111 & 60) >>> 2));
    L35:
        if (r109 == r103) goto L37;
        int r112 = r109 + 1;
        byte r113 = r102[r109];
        if (r113 == 61) goto L41;
        byte r114 = f26304b[r113];
        if (r112 >= r103) goto L47;
        if (r114 != (-1)) goto L47;
        r109 = r112;
    L47:
        if (r114 == (-1)) goto L50;
        r104.write(r114 | ((r111 & 3) << 6));
        r101 = r112;
        goto L7
    L41:
        return r104.toByteArray();
    L37:
        return r104.toByteArray();
    L27:
        return r104.toByteArray();
    L23:
        return r104.toByteArray();
    L50:
        return r104.toByteArray();
    L5:
        return new byte[0];
    }

    public static String c(byte[] r100) {
        return d(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String d(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        int r104 = r103 + 1;
        int r105 = r100[r103] & UByte.MAX_VALUE;
        if (r104 == r102) goto L6;
        int r106 = r104 + 1;
        int r107 = r100[r104] & UByte.MAX_VALUE;
        if (r106 == r102) goto L9;
        int r108 = r106 + 1;
        int r109 = r100[r106] & UByte.MAX_VALUE;
        char[] r110 = f26303a;
        r101.append(r110[r105 >>> 2]);
        r101.append(r110[((r105 & 3) << 4) | ((r107 & 240) >>> 4)]);
        r101.append(r110[((r107 & 15) << 2) | ((r109 & 192) >>> 6)]);
        r101.append(r110[r109 & 63]);
        r103 = r108;
        goto L3
    L9:
        char[] r111 = f26303a;
        r101.append(r111[r105 >>> 2]);
        r101.append(r111[((r105 & 3) << 4) | ((r107 & 240) >>> 4)]);
        r101.append(r111[(r107 & 15) << 2]);
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);
        goto L12
    L6:
        char[] r112 = f26303a;
        r101.append(r112[r105 >>> 2]);
        r101.append(r112[(r105 & 3) << 4]);
        r101.append("==");
    L12:
        return r101.toString();
    }

    public static String a(String r100) {
        return bs.a(b(r100));
    }

    public static String b(byte[] r100) {
        return d(r100);
    L4:
        th = move-exception;
        cd.a(th, "er", "e64");
        return null;
    }

    public static byte[] a(byte[] r100, Key r101) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher r102 = Cipher.getInstance(bs.c("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
        r102.init(1, r101);
        return r102.doFinal(r100);
    }

    private static byte[] a(byte[] r100, byte[] r101) {
        return c(r100, r101, bs.c());
    L4:
        th = move-exception;
        cd.a(th, "er", "asEn");
        return null;
    }

    public static byte[] a(byte[] r100, byte[] r101, byte[] r102) throws Exception {
        IvParameterSpec r103 = new IvParameterSpec(r102);
        SecretKeySpec r104 = new SecretKeySpec(r100, bs.c("EQUVT"));
        Cipher r105 = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r105.init(2, r104, r103);
        return r105.doFinal(r101);
    }

    public static byte[] b(byte[] r100, byte[] r101, byte[] r102) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return c(r100, r101, r102);
    }

    private static byte[] c(byte[] r100, byte[] r101, byte[] r102) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec r103 = new IvParameterSpec(r102);
        SecretKeySpec r104 = new SecretKeySpec(r100, bs.c("EQUVT"));
        Cipher r105 = Cipher.getInstance(bs.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        r105.init(1, r104, r103);     // Catch: InvalidAlgorithmParameterException -> L5
    L8:
        return r105.doFinal(r101);
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
