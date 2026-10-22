package com.baidu.bbalbscesium;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.KevaImpl;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f30086c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f30087d = "CuidV266Manager";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f30088e = "com.baidu.deviceid";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f30089f = "com.baidu.deviceid.v2";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f30090g = "backups/.SystemConfig";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f30091h = ".cuid2";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f30092i = "bd_setting_i";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f30093j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f30094k = ".cuid";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f30095l = "baidu";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final boolean f30096m = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f30097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f30098b;

    public g(Context r100, d r101) {
        this.f30097a = r100;
        this.f30098b = r101;
    }

    private f a() {
        return f.a(e(f30088e), e(f30092i));
    }

    private f a(Context r100) {
        List r101 = this.f30098b.b(r100);
        f r102 = null;
        if (r101 == null) goto L17;
        File r103 = r100.getFilesDir();
        String r104 = r103.getName();
        String r105 = KevaImpl.PrivateConstants.FILES_DIR_NAME;
        if (KevaImpl.PrivateConstants.FILES_DIR_NAME.equals(r104) == true) goto L7;
        r103.getAbsolutePath();
        r105 = r103.getName();
    L7:
        Iterator r106 = r101.iterator();
    L9:
        if (r106.hasNext() == false) goto L17;
        c r107 = (c) r106.next();
        if (r107.f30063d == true) goto L9;
        PolarisFileWrapper r108 = new PolarisFileWrapper(new PolarisFileWrapper(r107.f30060a.dataDir, r105), f.f30074g);
        if (r108.exists() == false) goto L9;
        r102 = f.a(com.baidu.bbalbscesium.o.c.a(r108));
        if (r102 == null) goto L9;
    L17:
        return r102;
    }

    private boolean a(String r100) {
        if (com_baidu_bbalbscesium_g_android_content_Context_checkPermission(this.f30097a, r100, Process.myPid(), Process.myUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private f b() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (r100.exists() == true) goto L5;
        return null;
    L5:
        return f.a(com.baidu.bbalbscesium.o.c.a(r100));
    }

    private String c(String r100) {
        return "0";
    }

    private f d(String r100) {
        String r101 = "";
        PolarisFileWrapper r102 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (r102.exists() == true) goto L23;
        r102 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
    L23:
        BufferedReader r103 = new BufferedReader(new PolarisFileReaderWrapper(r102));     // Catch: Throwable -> L22
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L22
    L7:
        String r105 = r103.readLine();     // Catch: Throwable -> L22
        if (r105 == null) goto L10;
        r104.append(r105);     // Catch: Throwable -> L22
        r104.append("\r\n");     // Catch: Throwable -> L22
        goto L7
    L10:
        r103.close();     // Catch: Throwable -> L22
        byte[] r106 = com.baidu.bbalbscesium.k.a.g.a();     // Catch: Throwable -> L22
        String[] r107 = new String(com.baidu.bbalbscesium.k.a.c.a(r106, r106, com.baidu.bbalbscesium.m.b.a(r104.toString().getBytes()))).split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L22
        if (r107 == null) goto L18;
        if (r107.length != 2) goto L18;
        String r108 = r107[0];     // Catch: Throwable -> L22
        r101 = r107[1];     // Catch: Throwable -> L21
    L20:
        return f.a(r101, r108);
    L18:
        r108 = "";
        goto L20
    }

    private String e(String r100) {
        return com_baidu_bbalbscesium_g_android_provider_Settings$System_getString(this.f30097a.getContentResolver(), r100);
    L4:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        return null;
    }

    private boolean f(String r100) {
        FileOutputStream r101 = null;
        r101 = this.f30097a.openFileOutput(f.f30074g, 0);     // Catch: Throwable -> L10 Exception -> L12
        r101.write(r100.getBytes());     // Catch: Throwable -> L10 Exception -> L12
        r101.flush();     // Catch: Throwable -> L10 Exception -> L12
    L30:
        r101.close();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        return true;
    L12:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);     // Catch: Throwable -> L10
        if (r101 != null) goto L28;
    L19:
        return false;
    L28:
        r101.close();     // Catch: Exception -> L17
    L17:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
    L10:
        th = move-exception;
        if (r101 != null) goto L32;
    L25:
        throw th;
    L32:
        r101.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        com.baidu.bbalbscesium.o.c.a(e);
        goto L25
    }

    public void a(f r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f30097a.getFilesDir(), f.f30074g);
        String r102 = r100.e();
        if (r101.exists() == false) goto L11;
        f r103 = f.a(com.baidu.bbalbscesium.o.c.a(r101));
        if (r103 != null) goto L8;
        if (r103 == null) goto L11;
        return;
    L8:
        if (r103.a() == false) goto L13;
        r102 = r103.e();
        goto L11
    L13:
        return;
    L11:
        f(r102);
    }

    public f b(String r100) {
        f r101 = a(this.f30097a);
        if (r101 != null) goto L5;
        r101 = f.a(e(f30089f));
    L5:
        boolean r102 = a("android.permission.READ_EXTERNAL_STORAGE");
        if (r101 != null) goto L9;
        if (r102 == false) goto L9;
        r101 = b();
    L9:
        if (r101 != null) goto L12;
        r101 = a();
    L12:
        if (r101 != null) goto L15;
        if (r102 == false) goto L15;
        r101 = d(c(""));
        boolean r103 = true;
    L16:
        if (r103 == true) goto L18;
        c("");
    L18:
        if (r101 == null) goto L20;
        r101.a();
    L20:
        return r101;
    L15:
        r103 = false;
        goto L16
    }

    private static String com_baidu_bbalbscesium_g_android_provider_Settings$System_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.System.getString(r110, r111);
        r100.a(102003, "android/provider/Settings$System", "getString", Settings.System.class, r101, r114, r112, true);
        return r114;
    }

    private static int com_baidu_bbalbscesium_g_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_com_baidu_bbalbscesium_g_android_content_Context_checkPermission");
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
