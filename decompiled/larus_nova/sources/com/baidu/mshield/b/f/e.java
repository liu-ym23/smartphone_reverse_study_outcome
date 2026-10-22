package com.baidu.mshield.b.f;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f32386a = null;

    static {
        f32386a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f"};
    }

    public static String a(File r100) {
        if (r100 != null) goto L5;
    L37:
        return null;
    L5:
        if (r100.exists() == false) goto L37;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L21
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L21
        byte[] r103 = new byte[8192];     // Catch: Throwable -> L19
    L10:
        int r104 = r102.read(r103);     // Catch: Throwable -> L19
        if (r104 == (-1)) goto L13;
        r101.update(r103, 0, r104);     // Catch: Throwable -> L19
        goto L10
    L13:
        String r105 = b(r101.digest());     // Catch: Throwable -> L19
        r102.close();     // Catch: IOException -> L16
    L18:
        return r105;
    L16:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L30
        if (r102 != null) goto L38;
    L29:
        return null;
    L38:
        r102.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L30:
        th = move-exception;
        if (r102 != null) goto L48;
    L36:
        throw th;
    L48:
        r102.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = th;
        r102 = null;
        goto L42
    }

    public static String b(byte[] r100) {
        char[] r101 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L7;
        byte r104 = r100[r103];
        int r105 = r103 * 2;
        r102[r105] = r101[(r104 >>> 4) & 15];
        r102[r105 + 1] = r101[r104 & 15];
        r103 = r103 + 1;
        goto L4
    L7:
        return new String(r102);
    }

    public static String c(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L15;
        return a(MessageDigest.getInstance("MD5").digest(r100));
    L9:
        th = move-exception;
        th.printStackTrace();
        return null;
    L15:
        return null;
    }

    public static String a(String r100) {
        String r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L15;
        return null;
    L15:
        String r102 = new String(r100);     // Catch: Throwable -> L10
        return a(MessageDigest.getInstance("MD5").digest(r102.getBytes()));
    L8:
        th = th;
        r101 = r102;
    L11:
        th.printStackTrace();
        return r101;
    L10:
        th = th;
        goto L11
    }

    public static String a(byte r100) {
        if (r100 >= 0) goto L4;
        int r101 = r100 + 256;
    L4:
        int r102 = r101 / 16;
        StringBuilder r103 = new StringBuilder();
        String[] r104 = f32386a;
        r103.append(r104[r102]);
        r103.append(r104[r101 % 16]);
        return r103.toString();
    }

    public static String a(byte[] r100) {
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
    L11:
    L7:
        th = move-exception;
        com.baidu.mshield.b.c.a.a(th);
    L10:
        return r101.toString();
    L4:
        if (r102 >= r100.length) goto L10;
        r101.append(a(r100[r102]));     // Catch: Throwable -> L7
        r102 = r102 + 1;
        goto L11
    }
}
