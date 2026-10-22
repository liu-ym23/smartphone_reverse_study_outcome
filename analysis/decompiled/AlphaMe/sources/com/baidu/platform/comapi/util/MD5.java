package com.baidu.platform.comapi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class MD5 {

    /* renamed from: a, reason: collision with root package name */
    protected static final char[] f9267a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String getFileMD5String(File file) throws IOException {
        return getFileMD5String(file, 131072);
    }

    public static String getFileMD5StringNIO(File file) throws IOException {
        return getFileMD5StringNIO(file, 131072);
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getMD5String16(String str) throws NoSuchAlgorithmException {
        String mD5String = getMD5String(str.getBytes());
        if (mD5String.length() == 32) {
            return mD5String.substring(8, 24);
        }
        return null;
    }

    public static String getSignMD5String(String str) {
        return URLEncodeUtils.generateSign(1, str);
    }

    public static String getWebSignMD5String(String str) {
        return URLEncodeUtils.generateSign(2, str);
    }

    public static String signOpra(String str) {
        return URLEncodeUtils.generateSign(3, str);
    }

    private static String a(byte[] bArr, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer(i5 * 2);
        int i6 = i5 + i4;
        while (i4 < i6) {
            a(bArr[i4], stringBuffer);
            i4++;
        }
        return stringBuffer.toString();
    }

    public static String getFileMD5String(File file, int i4) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[i4];
        while (true) {
            int i5 = fileInputStream.read(bArr);
            if (i5 <= 0) {
                fileInputStream.close();
                try {
                    return a(messageDigest.digest());
                } catch (Exception e4) {
                    throw new IOException(e4.toString());
                }
            }
            messageDigest.update(bArr, 0, i5);
        }
    }

    public static String getFileMD5StringNIO(File file, int i4) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i4);
        for (int i5 = channel.read(byteBufferAllocate); i5 != -1; i5 = channel.read(byteBufferAllocate)) {
            byteBufferAllocate.flip();
            messageDigest.update(byteBufferAllocate);
            if (!byteBufferAllocate.hasRemaining()) {
                byteBufferAllocate.clear();
            }
        }
        fileInputStream.close();
        try {
            return a(messageDigest.digest());
        } catch (Exception e4) {
            throw new IOException(e4.toString());
        }
    }

    public static String getMD5String(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        messageDigest.update(bArr);
        try {
            return a(messageDigest.digest());
        } catch (Exception unused2) {
            return "";
        }
    }

    private static void a(byte b4, StringBuffer stringBuffer) {
        char[] cArr = f9267a;
        char c4 = cArr[(b4 & 240) >> 4];
        char c5 = cArr[b4 & 15];
        stringBuffer.append(c4);
        stringBuffer.append(c5);
    }
}
