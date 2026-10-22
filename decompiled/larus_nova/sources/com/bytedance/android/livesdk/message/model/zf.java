package com.bytedance.android.livesdk.message.model;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes11.dex */
public final class zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f153706a = null;

    static {
        f153706a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public static String a(byte[] r100) {
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L8
        r101.update(r100);     // Catch: Exception -> L8
        byte[] r102 = r101.digest();     // Catch: Exception -> L8
        char[] r103 = new char[32];     // Catch: Exception -> L8
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= 16) goto L6;
        byte r106 = r102[r104];     // Catch: Exception -> L8
        int r107 = r105 + 1;     // Catch: Exception -> L8
        char[] r108 = f153706a;     // Catch: Exception -> L8
        r103[r105] = r108[(r106 >>> 4) & 15];     // Catch: Exception -> L8
        r105 = r107 + 1;     // Catch: Exception -> L8
        r103[r107] = r108[r106 & 15];     // Catch: Exception -> L8
        r104 = r104 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        return new String(r103);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
