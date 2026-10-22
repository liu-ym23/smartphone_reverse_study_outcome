package cn.com.chinatelecom.account;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public class z {
    public static String a(FileInputStream r100) {
        MessageDigest r101 = MessageDigest.getInstance("SHA-256");     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        byte[] r102 = new byte[1024];     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
    L3:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        int r104 = 0;
        if (r103 == (-1)) goto L6;
        r101.update(r102, 0, r103);     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        goto L3
    L6:
        byte[] r105 = r101.digest();     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        int r107 = r105.length;     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
    L7:
        if (r104 >= r107) goto L12;
        String r108 = Integer.toHexString(r105[r104] & UByte.MAX_VALUE);     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        if (r108.length() != 1) goto L11;
        r106.append('0');     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
    L11:
        r106.append(r108);     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        r104 = r104 + 1;     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
        goto L7
    L12:
        String r109 = r106.toString();     // Catch: Throwable -> L15 IOException -> L17 NoSuchAlgorithmException -> L20
    L30:
        r100.close();     // Catch: IOException -> L26
    L14:
        return r109;
    L15:
        th = move-exception;
        if (r100 != null) goto L32;
    L25:
        throw th;
    L32:
        r100.close();     // Catch: IOException -> L27
    L17:
        e = move-exception;
        throw new RuntimeException("Error reading from FileInputStream", e);     // Catch: Throwable -> L15
    L20:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L15
    }

    public static String a(String r100) {
        byte[] r101 = MessageDigest.getInstance("SHA-256").digest(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L10
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L10
        int r103 = r101.length;     // Catch: Exception -> L10
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        String r105 = Integer.toHexString(r101[r104] & UByte.MAX_VALUE);     // Catch: Exception -> L10
        if (r105.length() != 1) goto L7;
        r102.append('0');     // Catch: Exception -> L10
    L7:
        r102.append(r105);     // Catch: Exception -> L10
        r104 = r104 + 1;     // Catch: Exception -> L10
        goto L3
    L8:
        return r102.toString().toUpperCase();
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String a(String r100, String r101) {
        Mac r102 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L11
        r102.init(new SecretKeySpec(r101.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));     // Catch: Exception -> L11
        byte[] r103 = r102.doFinal(r100.getBytes(StandardCharsets.UTF_8));     // Catch: Exception -> L11
        StringBuilder r104 = new StringBuilder();     // Catch: Exception -> L11
        int r105 = r103.length;     // Catch: Exception -> L11
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L9;
        String r107 = Integer.toHexString(r103[r106] & UByte.MAX_VALUE);     // Catch: Exception -> L11
        if (r107.length() != 1) goto L8;
        r104.append('0');     // Catch: Exception -> L11
    L8:
        r104.append(r107);     // Catch: Exception -> L11
        r106 = r106 + 1;     // Catch: Exception -> L11
        goto L4
    L9:
        return r104.toString().toUpperCase();
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
