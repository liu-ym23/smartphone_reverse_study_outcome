package com.baidu.platform.comapi.resource;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.MD5;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33381a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f33382b;

    static {
        f33381a = new b();
    }

    private b() {
        this.f33382b = JNIInitializer.getCachedContext().getSharedPreferences("engine_resource_sp", 0);
    }

    private String a() {
        String r100 = SysOSUtil.getInstance().getOutputDirPath();
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        r101.mkdirs();
    L5:
        return r100;
    }

    public synchronized void a(ResourceList r110) {
        monitor-enter(this);
        Context r100 = JNIInitializer.getCachedContext();     // Catch: Throwable -> L25
        boolean r101 = false;
        byte[] r102 = null;
        boolean r103 = true;
        String r104 = a();     // Catch: Throwable -> L15 Throwable -> L25
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, "/ver.dat");     // Catch: Throwable -> L15 Throwable -> L25
        r102 = r110.resVer();     // Catch: Throwable -> L14 Throwable -> L25
        boolean r106 = b(r105, r102);     // Catch: Throwable -> L14 Throwable -> L25
        if (r106 == true) goto L28;
    L11:
        a(r104);     // Catch: Throwable -> L13 Throwable -> L25
        r101 = r103;
    L17:
        if (r106 == false) goto L21;
        if (r101 == false) goto L21;
        r101 = a(r105, r102);     // Catch: Throwable -> L25
    L21:
        if (OpenLogUtil.isMapLogEnable() == false) goto L23;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("initEngineRes firstInit = " + r106 + "; isInitSucceed = " + r101);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L13:
        r103 = r106;
        goto L16
    L28:
        AssetManager r107 = r100.getAssets();     // Catch: Throwable -> L13 Throwable -> L25
        String[] r111 = r110.resList();     // Catch: Throwable -> L13 Throwable -> L25
        byte[] r108 = new byte[65536];     // Catch: Throwable -> L13 Throwable -> L25
        int r109 = r111.length;     // Catch: Throwable -> L13 Throwable -> L25
        int r112 = 0;
    L9:
        if (r112 >= r109) goto L11;
        String r113 = r111[r112];     // Catch: Throwable -> L13 Throwable -> L25
        r103 = a(r107, r108, r113, r104 + HTTP.URL_DEFAULT + r113);     // Catch: Throwable -> L13 Throwable -> L25
        r112 = r112 + 1;     // Catch: Throwable -> L13 Throwable -> L25
    L16:
        r106 = r103;
    L15:
        r105 = null;
    L25:
        th = move-exception;
        throw th;
    }

    private void a(String r100) {
        if (this.f33382b != null) goto L5;
        return;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "shader/");
        String r102 = MD5.getMD5String(Build.FINGERPRINT);
        if (r101.exists() == true) goto L9;
        this.f33382b.edit().putString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, r102).commit();
        return;
    L9:
        String r103 = this.f33382b.getString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, "");
        if (TextUtils.isEmpty(r103) == false) goto L12;
    L17:
        a(r101);
        if (r101.exists() == true) goto L21;
        this.f33382b.edit().putString(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT, r102).commit();
        return;
    L21:
        return;
    L12:
        if (r103.equals(r102) == false) goto L15;
        return;
    L15:
        if (MD5.getMD5String(r103).equals(r102) == false) goto L17;
    }

    private static void a(File r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFile() == false) goto L7;
    L22:
        r100.delete();
        return;
    L7:
        if (r100.exists() == true) goto L9;
    L13:
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L20;
        int r102 = 0;
    L17:
        if (r102 >= r101.length) goto L20;
        a(r101[r102]);
        r101[r102].delete();
        r102 = r102 + 1;
    L20:
        if (r100.exists() == false) goto L25;
        r100.delete();
        return;
    L25:
        return;
    L9:
        if (r100.list() == null) goto L13;
        if (r100.list().length != 0) goto L13;
        goto L13
    }

    private boolean a(File r100, byte[] r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        PolarisFileOutputStreamWrapper r102 = null;
    L17:
        th = th;
    L18:
        a.a(r102);
        throw th;
    L8:
        if (r100.exists() == false) goto L10;
        r100.delete();     // Catch: Throwable -> L17 Exception -> L22
    L10:
        r100.createNewFile();     // Catch: Throwable -> L17 Exception -> L22
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r100);     // Catch: Throwable -> L17 Exception -> L22
        r103.write(r101);     // Catch: Throwable -> L14 Exception -> L16
        a.a(r103);
        return true;
    L16:
        r102 = r103;
    L14:
        th = th;
        r102 = r103;
        goto L18
    L20:
        a.a(r102);
    L21:
        return false;
    }

    private boolean b(File r100, byte[] r101) {
        if (r100 != null) goto L5;
    L21:
        return true;
    L5:
        if (r100.exists() == false) goto L21;
        if (r101 == null) goto L21;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L17 IOException -> L23
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L14 IOException -> L22
        r103.read(r104);     // Catch: Throwable -> L14 IOException -> L22
        if (Arrays.equals(r104, r101) == false) goto L16;
        a.a(r103);
        return false;
    L14:
        th = th;
        r102 = r103;
    L18:
        a.a(r102);
        throw th;
    L16:
        r102 = r103;
        goto L20
    L17:
        th = th;
    L20:
        a.a(r102);
        goto L21
    }

    private boolean a(AssetManager r110, byte[] r111, String r112, String r113) {
        InputStream r100 = null;
    L34:
        a.a(null);
        return false;
    L31:
        th = move-exception;
        a.a(null);
        throw th;
    L4:
        if (TextUtils.isEmpty(r112) == false) goto L6;
    L20:
        r100 = r110.open(r112);     // Catch: Throwable -> L31 Exception -> L34
        PolarisFileWrapper r114 = new PolarisFileWrapper(r113);     // Catch: Throwable -> L31 Exception -> L34
        File r115 = r114.getParentFile();     // Catch: Throwable -> L31 Exception -> L34
        if (r115 == null) goto L26;
        if (r115.isDirectory() == true) goto L26;
        r115.mkdirs();     // Catch: Throwable -> L31 Exception -> L34
    L26:
        if (r114.exists() == false) goto L28;
        r114.delete();     // Catch: Throwable -> L31 Exception -> L34
    L28:
        r114.createNewFile();     // Catch: Throwable -> L31 Exception -> L34
        a.a(r100, new PolarisFileOutputStreamWrapper(r114), r111);     // Catch: Throwable -> L31 Exception -> L34
    L29:
        a.a(r100);
        return true;
    L6:
        if (r112.endsWith(".dir") == false) goto L20;
        String r116 = r112.substring(0, r112.indexOf(".dir"));     // Catch: Throwable -> L31 Exception -> L34
        String r117 = r113.substring(0, r113.indexOf(".dir"));     // Catch: Throwable -> L31 Exception -> L34
        String[] r101 = r110.list(r116);     // Catch: Throwable -> L31 Exception -> L34
        if (r101 == null) goto L29;
        if (r101.length <= 0) goto L29;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r117);     // Catch: Throwable -> L31 Exception -> L34
        if (r102.exists() == false) goto L14;
        r102.delete();     // Catch: Throwable -> L31 Exception -> L34
    L14:
        r102.mkdirs();     // Catch: Throwable -> L31 Exception -> L34
        int r103 = r101.length;     // Catch: Throwable -> L31 Exception -> L34
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L29;
        String r105 = r101[r104];     // Catch: Throwable -> L31 Exception -> L34
        if (TextUtils.isEmpty(r105) == true) goto L19;
        a(r110, r111, r116 + HTTP.URL_DEFAULT + r105, r117 + HTTP.URL_DEFAULT + r105);     // Catch: Throwable -> L31 Exception -> L34
    L19:
        r104 = r104 + 1;     // Catch: Throwable -> L31 Exception -> L34
        goto L15
    }
}
