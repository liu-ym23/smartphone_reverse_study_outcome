package com.stepos.activeview.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class Md5Helper {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String MD5Encode(String str) {
        return MD5Encode(str, null);
    }

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b4 : bArr) {
            stringBuffer.append(byteToHexString(b4, true));
        }
        return stringBuffer.toString();
    }

    public static String byteArrayToHexStringLittleEnding(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b4 : bArr) {
            stringBuffer.append(byteToHexString(b4, false));
        }
        return stringBuffer.toString();
    }

    private static String byteToHexString(byte b4, boolean z4) {
        int i4 = b4;
        if (b4 < 0) {
            i4 = b4 + 256;
        }
        int i5 = i4 / 16;
        int i6 = i4 % 16;
        if (z4) {
            char[] cArr = hexDigits;
            return String.valueOf(cArr[i5] + cArr[i6]);
        }
        char[] cArr2 = hexDigits;
        return String.valueOf(cArr2[i6] + cArr2[i5]);
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[bArr.length << 1];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = hexDigits;
            cArr[i4] = cArr2[(b4 & 240) >>> 4];
            i4 += 2;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    public static byte[] hexStringToByteArray(String str) {
        if (str.length() % 2 != 0) {
            throw new RuntimeException("Error Hex String length");
        }
        byte[] bArr = new byte[str.length() / 2];
        int i4 = 0;
        while (i4 < str.length()) {
            int i5 = i4 / 2;
            int i6 = i4 + 1;
            char cCharAt = str.charAt(i4);
            i4 += 2;
            bArr[i5] = Integer.decode("0x" + cCharAt + str.charAt(i6)).byteValue();
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String md5sum(java.lang.String r2) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L15
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L13 java.io.IOException -> L15
            java.lang.String r2 = md5sum(r1)     // Catch: java.lang.Throwable -> Le java.io.IOException -> L11
            r1.close()     // Catch: java.io.IOException -> Ld
        Ld:
            return r2
        Le:
            r2 = move-exception
            r0 = r1
            goto L20
        L11:
            r2 = move-exception
            goto L17
        L13:
            r2 = move-exception
            goto L20
        L15:
            r2 = move-exception
            r1 = r0
        L17:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L1f
            r1.close()     // Catch: java.io.IOException -> L1f
        L1f:
            return r0
        L20:
            if (r0 == 0) goto L25
            r0.close()     // Catch: java.io.IOException -> L25
        L25:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.utils.Md5Helper.md5sum(java.lang.String):java.lang.String");
    }

    public static String md5sumHeadTail(String str, int i4) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            long length = new File(str).length();
            if (length < i4 * 2) {
                LogUtil.e("md5sumHeadTail file length is: " + length);
                return null;
            }
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i4 - i5;
                        if (i6 > 1024) {
                            i6 = 1024;
                        }
                        int i7 = fileInputStream.read(bArr, 0, i6);
                        if (i7 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i7);
                        i5 += i7;
                    }
                    fileInputStream.close();
                    FileInputStream fileInputStream3 = new FileInputStream(str);
                    long j4 = length - i4;
                    while (j4 > 0) {
                        try {
                            long jSkip = fileInputStream3.skip(j4);
                            if (jSkip > 0) {
                                j4 -= jSkip;
                            } else {
                                LogUtil.e("skip file return: " + jSkip);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            fileInputStream = fileInputStream3;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream3;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    while (true) {
                        int i8 = fileInputStream3.read(bArr);
                        if (i8 <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i8);
                    }
                    String strEncodeHex = encodeHex(messageDigest.digest());
                    try {
                        fileInputStream3.close();
                    } catch (IOException unused3) {
                    }
                    return strEncodeHex;
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String MD5Encode(String str, String str2) throws NoSuchAlgorithmException {
        try {
            String str3 = new String(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return str2 == null ? byteArrayToHexString(messageDigest.digest(str3.getBytes())) : byteArrayToHexString(messageDigest.digest(str3.getBytes(str2)));
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static String byteArrayToHexString(byte[] bArr, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = i4; i6 < i5 + i4; i6++) {
            stringBuffer.append(byteToHexString(bArr[i6], true));
        }
        return stringBuffer.toString();
    }

    public static String md5sum(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int i4 = inputStream.read(bArr);
                if (i4 > 0) {
                    messageDigest.update(bArr, 0, i4);
                } else {
                    return encodeHex(messageDigest.digest());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] MD5Encode(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
