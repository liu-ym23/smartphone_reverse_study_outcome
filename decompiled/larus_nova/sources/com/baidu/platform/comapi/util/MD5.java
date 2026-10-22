package com.baidu.platform.comapi.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes39.dex */
public class MD5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final char[] f33387a = null;

    static {
        f33387a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public MD5() {
    }

    private static String a(byte[] r100) {
        return a(r100, 0, r100.length);
    }

    public static String getFileMD5String(File r100) throws IOException {
        return getFileMD5String(r100, 131072);
    }

    public static String getFileMD5StringNIO(File r100) throws IOException {
        return getFileMD5StringNIO(r100, 131072);
    }

    public static String getMD5String(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
    L6:
        if (r101 != null) goto L8;
        return "";
    L8:
        r101.update(r100);
        return a(r101.digest());
    L11:
        return "";
    L4:
        r101 = null;
        goto L6
    }

    public static String getMD5String16(String r100) {
        String r101 = getMD5String(r100.getBytes());
        if (r101.length() == 32) goto L5;
        return null;
    L5:
        return r101.substring(8, 24);
    }

    public static String getSignMD5String(String r100) {
        return URLEncodeUtils.generateSign(1, r100);
    }

    public static String getWebSignMD5String(String r100) {
        return URLEncodeUtils.generateSign(2, r100);
    }

    public static String signOpra(String r100) {
        return URLEncodeUtils.generateSign(3, r100);
    }

    public static String getMD5String(String r100) {
        return getMD5String(r100.getBytes());
    }

    private static void a(byte r100, StringBuffer r101) {
        char[] r102 = f33387a;
        char r103 = r102[(r100 & 240) >> 4];
        char r104 = r102[r100 & 15];
        r101.append(r103);
        r101.append(r104);
    }

    public static boolean checkPassword(String r100, String r101) {
        return getMD5String(r100).equals(r101);
    }

    public static String getFileMD5String(File r100, int r101) throws IOException {
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
    L5:
        if (r102 != null) goto L8;
        return "";
    L8:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);
        byte[] r104 = new byte[r101];
    L9:
        int r105 = r103.read(r104);
        if (r105 <= 0) goto L12;
        r102.update(r104, 0, r105);
        goto L9
    L12:
        r103.close();
        return a(r102.digest());
    L15:
        e = move-exception;
        throw new IOException(e.toString());
    L4:
        r102 = null;
        goto L5
    }

    public static String getFileMD5StringNIO(File r100, int r101) throws IOException {
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
    L5:
        if (r102 != null) goto L8;
        return "";
    L8:
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);
        FileChannel r104 = r103.getChannel();
        ByteBuffer r105 = ByteBuffer.allocate(r101);
        int r106 = r104.read(r105);
    L10:
        if (r106 == (-1)) goto L15;
        r105.flip();
        r102.update(r105);
        if (r105.hasRemaining() == true) goto L14;
        r105.clear();
    L14:
        r106 = r104.read(r105);
        goto L10
    L15:
        r103.close();
        return a(r102.digest());
    L18:
        e = move-exception;
        throw new IOException(e.toString());
    L4:
        r102 = null;
        goto L5
    }

    private static String a(byte[] r100, int r101, int r102) {
        StringBuffer r103 = new StringBuffer(r102 * 2);
        int r104 = r102 + r101;
    L3:
        if (r101 >= r104) goto L6;
        a(r100[r101], r103);
        r101 = r101 + 1;
        goto L3
    L6:
        return r103.toString();
    }
}
