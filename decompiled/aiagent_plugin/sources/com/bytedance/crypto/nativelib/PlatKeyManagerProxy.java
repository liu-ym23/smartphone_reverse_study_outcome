package com.bytedance.crypto.nativelib;

import android.content.Context;
import com.bytedance.crypto.platform.PlatKeyManager;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class PlatKeyManagerProxy {
    private static final String TAG = "PlatKeyManagerProxy";
    private static volatile PlatKeyManagerProxy platKeyManagerProxy;

    public PlatKeyManagerProxy() {
    }

    public static PlatKeyManagerProxy getInstance() {
        if (platKeyManagerProxy != null) goto L15;
        monitor-enter(PlatKeyManagerProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (platKeyManagerProxy != null) goto L9;
        platKeyManagerProxy = new PlatKeyManagerProxy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PlatKeyManagerProxy.class);     // Catch: Throwable -> L11
    L15:
        return platKeyManagerProxy;
    }

    public byte[] decryptModelFile(Context r3, String r4, String r5, String r6) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "decryptModelFile enter");
        if (r4 != null) goto L5;
    L36:
        String r7 = "inPath is null or empty";
    L28:
        LogUtils.e(TAG, r7);
        return new byte[0];
    L5:
        if (r4.isEmpty() == true) goto L36;
        if (r5 != null) goto L9;
    L35:
        r7 = "FEKCipher is null or empty";
        goto L28
    L9:
        if (r5.isEmpty() == true) goto L35;
        if (r6 != null) goto L13;
    L34:
        r7 = "secAppId is null or empty";
        goto L28
    L13:
        if (r6.isEmpty() == true) goto L34;
        FileInputStream r1 = new FileInputStream(r4);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        byte[] r8 = PlatKeyManager.getInstance().decryptModelFileV2(r2, r1, r5, r6);     // Catch: Throwable -> L19
        r1.close();     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
        return r8;
    L19:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L25 IOException -> L30 FileNotFoundException -> L32
    L32:
        e = move-exception;
        StringBuilder r9 = new StringBuilder().append("File not exist, exception: ");
        String r10 = e.getMessage();
    L27:
        r7 = r9.append(r10).toString();
    L30:
        e = move-exception;
        r9 = new StringBuilder().append("IOException: ");
        r10 = e.getMessage();
    L25:
        e = move-exception;
        r9 = new StringBuilder().append("Other exception: ");
        r10 = e.getMessage();
        goto L27
    }

    public int decryptModelFileByStream(Context r7, String r8, String r9, String r10, String r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "decryptModelFileByStream enter");
        if (r8 != null) goto L5;
    L51:
        String r12 = "inPath is null or empty";
    L47:
        LogUtils.e(TAG, r12);
        return -2;
    L5:
        if (r8.isEmpty() == true) goto L51;
        if (r9 != null) goto L9;
    L50:
        r12 = "outPath is null or empty";
        goto L47
    L9:
        if (r9.isEmpty() == true) goto L50;
        if (r10 != null) goto L13;
    L49:
        r12 = "FEKCipher is null or empty";
        goto L47
    L13:
        if (r10.isEmpty() == true) goto L49;
        if (r11 != null) goto L17;
    L46:
        r12 = "secAppId is null or empty";
        goto L47
    L17:
        if (r11.isEmpty() == true) goto L46;
        FileInputStream r13 = new FileInputStream(r8);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        FileOutputStream r14 = new FileOutputStream(r9);     // Catch: Throwable -> L31
        int r15 = PlatKeyManager.getInstance().decryptModelFileV2(r1, r13, r14, r10, r11);     // Catch: Throwable -> L25
        r14.close();     // Catch: Throwable -> L31
        r13.close();     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
        return r15;
    L25:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L37 IOException -> L40 FileNotFoundException -> L43
    L43:
        e = move-exception;
        LogUtils.e(TAG, "File not exist, exception: " + e.getMessage());
        return -16;
    L40:
        e = move-exception;
        LogUtils.e(TAG, "IOException: " + e.getMessage());
        return -17;
    L37:
        e = move-exception;
        LogUtils.e(TAG, "Other exception: " + e.getMessage());
        return -1000;
    }

    public String reEncryptFEK(Context r2, String r3, String r4, int r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        LogUtils.d(TAG, "reEncryptFEK enter");
        return PlatKeyManager.getInstance().reEncryptFEKV2(r1, r3, r5, r4);
    }
}
