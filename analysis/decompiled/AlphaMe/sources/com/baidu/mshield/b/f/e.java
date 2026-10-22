package com.baidu.mshield.b.f;

import android.text.TextUtils;
import ch.qos.logback.core.rolling.helper.DateTokenConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f8287a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", DateTokenConverter.CONVERTER_KEY, "e", "f"};

    public static String a(byte b4) {
        int i4 = b4;
        if (b4 < 0) {
            i4 = b4 + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f8287a;
        sb.append(strArr[i4 / 16]);
        sb.append(strArr[i4 % 16]);
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 * 2;
            cArr2[i5] = cArr[(b4 >>> 4) & 15];
            cArr2[i5 + 1] = cArr[b4 & 15];
        }
        return new String(cArr2);
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b4 : bArr) {
            try {
                stringBuffer.append(a(b4));
            } catch (Throwable th) {
                com.baidu.mshield.b.c.a.a(th);
            }
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str3 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable th) {
                th = th;
                str2 = str3;
                th.printStackTrace();
                return str2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(File file) throws IOException {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = fileInputStream.read(bArr);
                    if (i4 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i4);
                }
                String strB = b(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return strB;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }
}
