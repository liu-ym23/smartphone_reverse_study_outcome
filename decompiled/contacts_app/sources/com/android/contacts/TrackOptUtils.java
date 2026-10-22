package com.android.contacts;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.GlobalProxyLancet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class TrackOptUtils {
    private static final String KEY_BINDER_INFO = "binderInfo";
    private static final String KEY_EXTRA = "extra";
    private static final int MAX_SIZE = 1048576;
    private static final int MSG_QUIT = 10;
    private static final int MSG_TRACK = 9;
    private static final String TAG = "TrackOptUtils";
    private static final String TRACK_FILE_1 = "/mnt/sdcard/obric/.log/contact/.cp1";
    private static final String TRACK_FILE_2 = "/mnt/sdcard/obric/.log/contact/.cp2";
    private static final String TRACK_FILE_DIR = "/mnt/sdcard/obric/.log/contact";
    private static HandlerThread mBackgroundThread;
    private static Handler mHandler;

    public TrackOptUtils() {
    }

    static /* synthetic */ String access$000(long r0) {
        return getFormatedDateTime(r0);
    }

    static /* synthetic */ String access$100(byte[] r0) {
        return encrypt(r0);
    }

    static /* synthetic */ void access$200(String r0) {
        appendLog(r0);
    }

    static /* synthetic */ void access$300() {
        quitLooperNeeded();
    }

    static /* synthetic */ Handler access$400() {
        return mHandler;
    }

    static /* synthetic */ Handler access$402(Handler r0) {
        mHandler = r0;
        return r0;
    }

    static /* synthetic */ HandlerThread access$500() {
        return mBackgroundThread;
    }

    static /* synthetic */ HandlerThread access$502(HandlerThread r0) {
        mBackgroundThread = r0;
        return r0;
    }

    public static void trackDeleteOperation(String r2, String r3) {
        ensureLooperReady();
        if (mHandler == null) goto L11;
        Bundle r0 = new Bundle();
        if (TextUtils.isEmpty(r2) == true) goto L8;
        r0.putString(KEY_BINDER_INFO, r2);
    L8:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r0.putString("extra", r3);
    L10:
        Message r4 = mHandler.obtainMessage(9);
        r4.setData(r0);
        mHandler.sendMessage(r4);
    L11:
        Handler r5 = mHandler;
        if (r5 == null) goto L15;
        r5.removeMessages(10);
        mHandler.sendEmptyMessageDelayed(10, 180000);
        return;
    }

    private static void ensureLooperReady() {
        if (mBackgroundThread != null) goto L9;
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "create HandlerThread");
    L7:
        HandlerThread r0 = new HandlerThread("TOU");
        mBackgroundThread = r0;
        r0.setPriority(1);
        mBackgroundThread.start();
    L9:
        if (mHandler == null) goto L11;
        return;
    L11:
        if (ContactsUtils.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "create Handler");
    L13:
        mHandler = new Handler(mBackgroundThread.getLooper(), new AnonymousClass1());
    }

    private static void quitLooperNeeded() {
        new Thread(new AnonymousClass2()).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.InputStreamReader] */
    private static void parseTrackFile(String r5) {
        InputStreamReader r0 = null;
        File r1 = new File(r5);     // Catch: Throwable -> L21 Exception -> L23
        if (r1.isFile() == true) goto L6;
    L18:
        if (r0 == null) goto L54;
        r0.close();     // Catch: IOException -> L29
    L40:
        return;
    L54:
        return;
    L6:
        if (r1.exists() == false) goto L18;
        InputStreamReader r6 = new InputStreamReader(new FileInputStream(r1));     // Catch: Throwable -> L21 Exception -> L23
        BufferedReader r2 = new BufferedReader(r6);     // Catch: Exception -> L16 Throwable -> L32
    L9:
        String r3 = r2.readLine();     // Catch: Exception -> L16 Throwable -> L32
        if (r3 == null) goto L15;
        byte[] r4 = decrypt(Base64.decode(r3.getBytes(), 2));     // Catch: Exception -> L16 Throwable -> L32
        if (ContactsUtils.DEBUG == false) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, new String(r4));     // Catch: Exception -> L16 Throwable -> L32
        goto L9
    L15:
        r0 = r6;
    L16:
        Exception e = e;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L32
        if (r6 == null) goto L55;
        r6.close();     // Catch: IOException -> L29
        goto L40
    L55:
        return;
    L32:
        Throwable th = th;
    L33:
        if (r5 != 0) goto L45;
    L38:
        throw th;
    L45:
        r5.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e = e;
        r6 = null;
    L21:
        th = move-exception;
        th = th;
        r5 = 0;
    L29:
        e = move-exception;
        e.printStackTrace();
    }

    private static void appendLog(String r9) {
        File r0 = new File(TRACK_FILE_DIR);
        if (r0.exists() == false) goto L9;
        if (r0.isDirectory() == false) goto L9;
        if (r0.canWrite() == false) goto L9;
    L11:
        File r1 = new File(TRACK_FILE_1);
        File r2 = new File(TRACK_FILE_2);
        if (r1.exists() == true) goto L18;
        r1.createNewFile();     // Catch: IOException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
    L18:
        if (r2.exists() == true) goto L24;
        r2.createNewFile();     // Catch: IOException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (r1.length() >= 1048576) goto L26;
        File r3 = r1;
    L27:
        BufferedWriter r4 = null;
        BufferedWriter r6 = new BufferedWriter(new FileWriter(r3, true));     // Catch: Throwable -> L36 IOException -> L38
        r6.append(r9);     // Catch: Throwable -> L32 IOException -> L34
        r6.newLine();     // Catch: Throwable -> L32 IOException -> L34
        r6.close();     // Catch: Throwable -> L32 IOException -> L34
        r6.close();     // Catch: IOException -> L43
    L72:
    L46:
        if (r3.length() >= 1048576) goto L48;
        return;
    L48:
        if (r3 != r1) goto L54;
        if (ContactsUtils.DEBUG == false) goto L52;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "delete 2");
    L52:
        r2.delete();
        return;
    L54:
        if (ContactsUtils.DEBUG == false) goto L56;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "delete 1");
    L56:
        r1.delete();
        return;
    L34:
        e = e;
        r4 = r6;
    L39:
        e.printStackTrace();     // Catch: Throwable -> L36
        if (r4 == null) goto L46;
        r4.close();     // Catch: IOException -> L43
    L32:
        th = th;
        r4 = r6;
    L58:
        if (r4 != null) goto L70;
    L63:
        throw th;
    L70:
        r4.close();     // Catch: IOException -> L61
    L61:
        e = move-exception;
        e.printStackTrace();
    L38:
        e = e;
    L36:
        th = th;
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L26:
        r3 = r2;
    L9:
        if (r0.mkdirs() == true) goto L11;
    }

    private static String getFormatedDateTime(long r2) {
        return new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date(r2));
    }

    private static String encrypt(byte[] r1) {
        return Base64.encodeToString(r1, 2);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static byte[] decrypt(byte[] r1) throws Exception {
        return Base64.decode(r1, 2);
    }
}
