package com.baidu.mshield.x0.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import java.io.CharArrayWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32492a = "";

    public g() {
    }

    public static String b(Context r100) {
        if (TextUtils.isEmpty(f32492a) == false) goto L6;
        f32492a = new g().f(r100);
    L6:
        return f32492a;
    }

    public String a(Context r100) {
        String r101 = e.a(r100);
        if (TextUtils.isEmpty("") == false) goto L8;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return "1|" + com.baidu.mshield.b.f.e.a(UUID.randomUUID().toString());
    L8:
        return "0|" + com.baidu.mshield.b.f.e.a("" + r101);
    }

    public String c(Context r100) {
        com.baidu.mshield.x0.l.c r101 = new com.baidu.mshield.x0.l.c(r100);     // Catch: Throwable -> L11
        String r102 = r101.c();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == true) goto L6;
        return r102;
    L6:
        String r103 = r101.b();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r101.b(r103);     // Catch: Throwable -> L11
        return r103;
    L10:
        return "";
    L11:
        th = move-exception;
        d.a(th);
        return "";
    }

    public String d(Context r100) {
    L14:
        th = move-exception;
        d.a(th);
    L16:
        return "";
    L4:
        if (a(r100, "android.permission.READ_EXTERNAL_STORAGE") == true) goto L7;
        return "";
    L7:
        if (com.baidu.sec.privacy.f.c.d(r100) == true) goto L10;
        com.baidu.mshield.b.c.a.a("getNewUidBySdCard isCanRequestNetBackground=false");     // Catch: Throwable -> L14
        return "";
    L10:
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
        r101.append(Environment.getExternalStorageDirectory());     // Catch: Throwable -> L14
        String r102 = File.separator;     // Catch: Throwable -> L14
        r101.append(r102);     // Catch: Throwable -> L14
        r101.append(".zp");     // Catch: Throwable -> L14
        r101.append(r102);     // Catch: Throwable -> L14
        r101.append(".icosc");     // Catch: Throwable -> L14
        File r103 = com.baidu.mshield.b.e.a.a(r100, r101.toString());     // Catch: Throwable -> L14
        if (r103.exists() == false) goto L16;
        return a(r103);
    }

    public String e(Context r100) {
        return b(r100, "com.q.zi.i");
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }

    public final String f(Context r100) {
        String r101 = c(r100);
        boolean r102 = false;
        if (TextUtils.isEmpty(r101) == false) goto L12;
        r101 = e(r100);
        boolean r103 = true;
        if (TextUtils.isEmpty(r101) == false) goto L11;
        r101 = d(r100);
        if (TextUtils.isEmpty(r101) == false) goto L9;
        r101 = a(r100);
        boolean r104 = true;
    L10:
        r102 = true;
    L14:
        if (r102 == false) goto L16;
    L17:
        new com.baidu.mshield.x0.l.c(r100).a(r101);
    L18:
        if (r103 == false) goto L20;
    L21:
        a(r100, "com.q.zi.i", r101);
    L23:
        if (a(r100, "android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L28;
        if (r104 == false) goto L26;
    L27:
        c(r100, r101);
        goto L28
    L26:
        if (TextUtils.isEmpty(d(r100)) == true) goto L27;
    L28:
        return r101;
    L20:
        if (TextUtils.isEmpty(e(r100)) == false) goto L23;
    L16:
        if (TextUtils.isEmpty(c(r100)) == false) goto L18;
    L9:
        r104 = false;
        goto L10
    L11:
        r104 = false;
        r102 = true;
    L13:
        r103 = false;
        goto L14
    L12:
        r104 = false;
        goto L13
    }

    public final String a(File r100) {
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L17
        char[] r102 = new char[8192];     // Catch: Throwable -> L15
        CharArrayWriter r103 = new CharArrayWriter();     // Catch: Throwable -> L15
    L6:
        int r104 = r101.read(r102);     // Catch: Throwable -> L15
        if (r104 <= 0) goto L9;
        r103.write(r102, 0, r104);     // Catch: Throwable -> L15
        goto L6
    L9:
        String r105 = r103.toString();     // Catch: Throwable -> L15
        r101.close();     // Catch: Throwable -> L12
    L14:
        return r105;
    L12:
        th = move-exception;
        d.a(th);
    L15:
        th = th;
    L41:
        d.a(th);     // Catch: Throwable -> L26
        if (r101 != null) goto L37;
    L25:
        return null;
    L37:
        r101.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        d.a(th);
    L26:
        th = move-exception;
        if (r101 != null) goto L33;
    L32:
        throw th;
    L33:
        r101.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        d.a(th);
    L17:
        th = th;
        r101 = null;
        goto L41
    }

    public final boolean a(Context r100, String r101) {
        if (com_baidu_mshield_x0_d_g_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid()) != 0) goto L7;
        return true;
    L7:
        return false;
    L8:
        th = move-exception;
        d.a(th);
        return false;
    }

    public final String b(Context r100, String r101) {
        return com.baidu.mshield.b.e.a.d(r100, r101);
    L4:
        th = move-exception;
        d.a(th);
        return null;
    }

    public final void c(Context r100, String r101) {
    L21:
        th = move-exception;
        Throwable th10 = th;
        PolarisFileWriterWrapper r102 = null;
    L38:
        d.a(th10);     // Catch: Throwable -> L30
        if (r102 == null) goto L48;
        r102.close();     // Catch: Throwable -> L27
    L42:
        return;
    L48:
        return;
    L30:
        th = move-exception;
        if (r102 != null) goto L40;
    L36:
        throw th;
    L40:
        r102.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        d.a(th);
        goto L36
    L3:
        if (Build.VERSION.SDK_INT <= 28) goto L6;
        return;
    L6:
        if (com.baidu.mshield.b.e.a.d(r100) == true) goto L9;
        com.baidu.mshield.b.c.a.a("tryPutExternalStorageValue isCanRequestNetBackground=false");     // Catch: Throwable -> L21
        return;
    L9:
        File r103 = com.baidu.mshield.b.e.a.a(r100, Environment.getExternalStorageDirectory() + File.separator + ".zp");     // Catch: Throwable -> L21
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, ".icosc");     // Catch: Throwable -> L21
        if (r103.exists() == true) goto L12;
        r103.mkdirs();     // Catch: Throwable -> L21
    L15:
        r102 = new PolarisFileWriterWrapper(r104, false);     // Catch: Throwable -> L21
        r102.write(r101);     // Catch: Throwable -> L19
        r102.flush();     // Catch: Throwable -> L19
        r102.close();     // Catch: Throwable -> L27
    L19:
        th10 = th;
        goto L38
    L12:
        if (r103.isDirectory() == true) goto L15;
        r103.delete();     // Catch: Throwable -> L21
        r103.mkdirs();     // Catch: Throwable -> L21
    L27:
        th = move-exception;
        d.a(th);
    }

    public final boolean a(Context r100, String r101, String r102) {
        com.baidu.mshield.b.e.a.a(r100, r101, r102);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        d.a(th);
        return false;
    }

    private static int com_baidu_mshield_x0_d_g_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_baidu_mshield_x0_d_g_android_content_Context_checkPermission");
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
