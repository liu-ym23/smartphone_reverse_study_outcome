package com.bytedance.android.livesdkapi.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes12.dex */
public class MD5Utils {
    protected static char[] sHexDigits;

    public MD5Utils() {
    }

    static {
        sHexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String getMD5String(byte[] r100) {
        byte[] r101 = MessageDigest.getInstance("MD5").digest(r100);     // Catch: NoSuchAlgorithmException -> L8
        StringBuffer r102 = new StringBuffer();     // Catch: NoSuchAlgorithmException -> L8
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L6;
        byte r104 = r101[r103];     // Catch: NoSuchAlgorithmException -> L8
        r102.append(sHexDigits[(r104 & 240) >> 4]);     // Catch: NoSuchAlgorithmException -> L8
        r102.append(sHexDigits[r104 & 15]);     // Catch: NoSuchAlgorithmException -> L8
        r103 = r103 + 1;     // Catch: NoSuchAlgorithmException -> L8
        goto L4
    L6:
        return r102.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getMD5String(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return getMD5String(r100.getBytes());
    }
}
