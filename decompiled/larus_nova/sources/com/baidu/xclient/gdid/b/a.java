package com.baidu.xclient.gdid.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.xclient.gdid.e;
import com.baidu.xclient.gdid.j.d;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import f06.b;
import java.io.BufferedReader;
import java.io.File;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f33587a;

    public static String a(Context r100) {
    L17:
        th = move-exception;
        d.a(th);
        f33587a = "";
    L20:
        return f33587a;
    L3:
        if (TextUtils.isEmpty(f33587a) == false) goto L5;
        String r101 = b(r100);     // Catch: Throwable -> L17
        f33587a = r101;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r101) == false) goto L13;
        String r102 = c(r100);     // Catch: Throwable -> L17
        f33587a = r102;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r102) == false) goto L13;
        f33587a = e.e().q();     // Catch: Throwable -> L17
    L13:
        if (TextUtils.isEmpty(f33587a) == false) goto L15;
        String r103 = com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());     // Catch: Throwable -> L17
        f33587a = r103;     // Catch: Throwable -> L17
        String r104 = new String(Base64.encode(com.baidu.xclient.gdid.a.a(r103.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");     // Catch: Throwable -> L17
        e.e().c(r104);     // Catch: Throwable -> L17
        a(r100, r104);     // Catch: Throwable -> L17
        b(r100, r104);     // Catch: Throwable -> L17
        goto L20
    L15:
        f33587a = new String(com.baidu.xclient.gdid.a.b(Base64.decode(f33587a, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");     // Catch: Throwable -> L17
        goto L20
    L5:
        return f33587a;
    }

    public static void a(Context r100, String r101) {
    L10:
        th = move-exception;
        d.a(th);
        return;
    L3:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (com_baidu_xclient_gdid_b_a_android_content_Context_checkPermission(r100, "android.permission.WRITE_SETTINGS", Process.myPid(), Process.myUid()) != 0) goto L15;
        com.baidu.mshield.b.e.a.a(r100, "setting_gdidv", r101);     // Catch: Throwable -> L10
        return;
    }

    public static String b(Context r100) {
        return com.baidu.mshield.b.e.a.a(r100, "setting_gdidv", false);
    L4:
        th = move-exception;
        d.a(th);
        return null;
    }

    public static void b(Context r100, String r101) {
    L64:
        th = move-exception;
        d.a(th);
        return;
    L3:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (com_baidu_xclient_gdid_b_a_android_content_Context_checkPermission(r100, "android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != (-1)) goto L10;
        return;
    L10:
        FileLock r102 = null;
        File r103 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");     // Catch: Throwable -> L41
        if (r103 == null) goto L31;
        File r104 = r103.getParentFile();     // Catch: Throwable -> L41
        if (r104.exists() == true) goto L17;
        r104.mkdir();     // Catch: Throwable -> L41
    L17:
        if (r103.exists() == true) goto L19;
        r103.createNewFile();     // Catch: Throwable -> L41
    L19:
        byte[] r105 = r101.getBytes();     // Catch: Throwable -> L41
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L41
        FileChannel r107 = r106.getChannel();     // Catch: Throwable -> L29
        r102 = r107.tryLock();     // Catch: Throwable -> L27
        if (r102 != null) goto L24;
    L32:
        if (r102 == null) goto L36;
        r102.release();     // Catch: Throwable -> L34
    L36:
        if (r107 == null) goto L38;
        r107.close();     // Catch: Throwable -> L34
    L38:
        if (r106 == null) goto L80;
    L39:
        r106.close();     // Catch: Throwable -> L34
    L82:
        return;
    L80:
        return;
    L24:
        if (r102.isValid() == false) goto L32;
        r106.write(r105);     // Catch: Throwable -> L27
    L27:
        Throwable th10 = th;
    L69:
        d.a(th10);     // Catch: Throwable -> L52
        if (r102 == null) goto L46;
        r102.release();     // Catch: Throwable -> L34
    L46:
        if (r107 == null) goto L48;
        r107.close();     // Catch: Throwable -> L34
    L48:
        if (r106 != null) goto L39;
        return;
    L52:
        th = move-exception;
        if (r102 != null) goto L73;
    L57:
        if (r107 == null) goto L59;
        r107.close();     // Catch: Throwable -> L55
    L59:
        if (r106 == null) goto L63;
        r106.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L64
    L63:
        throw th;     // Catch: Throwable -> L64
    L73:
        r102.release();     // Catch: Throwable -> L55
    L29:
        th10 = th;
        r107 = null;
        goto L69
    L31:
        r107 = null;
        r106 = null;
    L41:
        th = move-exception;
        th10 = th;
        r107 = null;
        r106 = null;
    L34:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L64
    }

    public static String c(Context r100) {
    L16:
        th = move-exception;
        d.a(th);
        return null;
    L5:
        if (com_baidu_xclient_gdid_b_a_android_content_Context_checkPermission(r100, "android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != (-1)) goto L8;
        return "";
    L8:
        File r101 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");     // Catch: Throwable -> L16
        if (r101 == null) goto L23;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r101);     // Catch: Throwable -> L16
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L16
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L16
    L11:
        String r105 = r103.readLine();     // Catch: Throwable -> L16
        if (r105 == null) goto L14;
        r104.append(r105);     // Catch: Throwable -> L16
        goto L11
    L14:
        r103.close();     // Catch: Throwable -> L16
        r102.close();     // Catch: Throwable -> L16
        return r104.toString();
    L23:
        return null;
    }

    private static int com_baidu_xclient_gdid_b_a_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        b r112 = new b("auto_cert_com_baidu_xclient_gdid_b_a_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
