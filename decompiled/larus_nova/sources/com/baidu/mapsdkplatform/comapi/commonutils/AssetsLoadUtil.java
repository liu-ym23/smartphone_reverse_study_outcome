package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

/* JADX INFO: loaded from: classes39.dex */
public class AssetsLoadUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f32028a = false;

    static {
        f32028a = true;
    }

    public AssetsLoadUtil() {
    }

    private static void a(InputStream r100, FileOutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];
    L24:
        int r103 = r100.read(r102);     // Catch: Throwable -> L10
        if (r103 == (-1)) goto L6;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L10
        goto L24
    L6:
        r101.flush();     // Catch: Throwable -> L10
        r100.close();     // Catch: IOException -> L14
    L18:
        r101.close();     // Catch: IOException -> L15
        return;
    L29:
        return;
    L10:
        th = move-exception;
        r100.close();     // Catch: IOException -> L16
    L22:
        r101.close();     // Catch: IOException -> L17
        throw th;
    L30:
        throw th;
    }

    public static String getAssetsFilePath(Context r100, String r101) {
        PolarisFileOutputStreamWrapper r102 = null;
        InputStream r103 = r100.getAssets().open(r101);     // Catch: Throwable -> L22 IOException -> L24
        byte[] r104 = new byte[r103.available()];     // Catch: Throwable -> L18 IOException -> L20
        r103.read(r104);     // Catch: Throwable -> L18 IOException -> L20
        String r105 = r100.getFilesDir().getAbsolutePath();     // Catch: Throwable -> L18 IOException -> L20
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105 + HTTP.URL_DEFAULT + r101);     // Catch: IOException -> L16 Throwable -> L18
        if (r106.exists() == false) goto L8;
        r106.delete();     // Catch: IOException -> L16 Throwable -> L18
    L8:
        r106.createNewFile();     // Catch: IOException -> L16 Throwable -> L18
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r106);     // Catch: IOException -> L16 Throwable -> L18
    L55:
        r107.write(r104);     // Catch: IOException -> L14 Throwable -> L38
        r103.close();     // Catch: IOException -> L12
        r107.close();     // Catch: IOException -> L12
    L37:
        return r105 + HTTP.URL_DEFAULT + r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        IOException e100 = e;
    L27:
        e100.printStackTrace();     // Catch: Throwable -> L38
        if (r103 != null) goto L58;
    L32:
        if (r107 == null) goto L37;
        r107.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L58:
        r103.close();     // Catch: IOException -> L30
    L38:
        th = th;
        r102 = r107;
    L40:
        if (r103 != null) goto L53;
    L44:
        if (r102 == null) goto L48;
        r102.close();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        e.printStackTrace();
    L48:
        throw th;
    L53:
        r103.close();     // Catch: IOException -> L42
    L16:
        e = e;
    L26:
        r107 = null;
        e100 = e;
    L20:
        e = e;
        r105 = null;
    L18:
        th = th;
        goto L40
    L24:
        e = e;
        r105 = null;
        r103 = null;
    L22:
        th = th;
        r103 = null;
        goto L40
    }

    public static Bitmap loadAssetsFile(String r100, Context r101) {
        InputStream r102 = r101.getAssets().open(r100);     // Catch: Exception -> L8
        if (r102 == null) goto L6;
        return BitmapFactory.decodeStream(r102);
    L6:
        return null;
    L9:
        return BitmapFactory.decodeFile(a("assets/" + r100, r100, r101));
    }

    private static String a(String r100, String r101, Context r110) {
        StringBuilder r102 = new StringBuilder(r110.getFilesDir().getAbsolutePath());
        if (f32028a == false) goto L5;
        String r103 = r110.getPackageCodePath();
    L6:
        PolarisZipFileWrapper r104 = null;
        PolarisZipFileWrapper r105 = new PolarisZipFileWrapper(r103);     // Catch: Throwable -> L22 Exception -> L35
        goto L25
    L44:
        int r106 = r101.lastIndexOf(HTTP.URL_DEFAULT);     // Catch: Throwable -> L19 Exception -> L21
        if (r106 <= 0) goto L11;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r110.getFilesDir().getAbsolutePath());     // Catch: Throwable -> L19 Exception -> L21
        String r111 = r101.substring(0, r106);     // Catch: Throwable -> L19 Exception -> L21
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107.getAbsolutePath() + HTTP.URL_DEFAULT + r111, r101.substring(r106 + 1, r101.length()));     // Catch: Throwable -> L19 Exception -> L21
    L12:
        r107.mkdirs();     // Catch: Throwable -> L19 Exception -> L21
        ZipEntry r109 = r105.getEntry(r100);     // Catch: Throwable -> L19 Exception -> L21
        if (r109 == null) goto L41;
        a(r105.getInputStream(r109), new PolarisFileOutputStreamWrapper(r108));     // Catch: Throwable -> L19 Exception -> L21
        r102.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L19 Exception -> L21
        r102.append(r100);     // Catch: Throwable -> L19 Exception -> L21
        r105.close();     // Catch: IOException -> L32
    L36:
        goto L28
    L41:
        r105.close();     // Catch: IOException -> L33
    L15:
        return null;
    L11:
        r107 = new PolarisFileWrapper(r110.getFilesDir(), ChameleonAssertResManager.ASSET_FOLDER);     // Catch: Throwable -> L19 Exception -> L21
        r108 = new PolarisFileWrapper(r107.getAbsolutePath(), r101);     // Catch: Throwable -> L19 Exception -> L21
    L21:
        r104 = r105;
    L19:
        th = th;
        r104 = r105;
    L29:
        if (r104 != null) goto L39;
    L31:
        throw th;
    L39:
        r104.close();     // Catch: IOException -> L34
    L22:
        th = th;
    L28:
        return r102.toString();
    L25:
        if (r104 == null) goto L28;
        r104.close();     // Catch: IOException -> L32
        goto L36
    L5:
        r103 = "";
        goto L6
    }

    public static void copyFileFromAsset(String r100, String r101, Context r102) {
        PolarisFileOutputStreamWrapper r103 = null;
        InputStream r104 = r102.getAssets().open(r100);     // Catch: Throwable -> L24 Exception -> L26
        if (r104 != null) goto L47;
    L16:
        if (r104 != null) goto L54;
    L20:
        if (r103 == null) goto L60;
        r103.close();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L60:
        return;
    L54:
        r104.close();     // Catch: IOException -> L18
        goto L20
    L47:
        byte[] r105 = new byte[r104.available()];     // Catch: Throwable -> L14 Exception -> L46
        r104.read(r105);     // Catch: Throwable -> L14 Exception -> L46
        PolarisFileWrapper r106 = new PolarisFileWrapper(r102.getFilesDir().getAbsolutePath() + HTTP.URL_DEFAULT + r101);     // Catch: Throwable -> L14 Exception -> L46
        if (r106.exists() == false) goto L8;
        r106.delete();     // Catch: Throwable -> L14 Exception -> L46
    L8:
        r106.createNewFile();     // Catch: Throwable -> L14 Exception -> L46
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r106);     // Catch: Throwable -> L14 Exception -> L46
        r107.write(r105);     // Catch: Throwable -> L11 Exception -> L13
        r107.close();     // Catch: Throwable -> L11 Exception -> L13
        r103 = r107;
        goto L16
    L13:
        r103 = r107;
    L11:
        th = th;
        r103 = r107;
    L37:
        if (r104 != null) goto L50;
    L41:
        if (r103 == null) goto L45;
        r103.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        e.printStackTrace();
    L45:
        throw th;
    L50:
        r104.close();     // Catch: IOException -> L39
    L14:
        th = th;
    L27:
        a("assets/" + r100, r101, r102);     // Catch: Throwable -> L14
        if (r104 != null) goto L52;
    L32:
        if (r103 == null) goto L62;
        r103.close();     // Catch: IOException -> L30
        return;
    L30:
        e = move-exception;
        e.printStackTrace();
        return;
    L62:
        return;
    L52:
        r104.close();     // Catch: IOException -> L30
        goto L32
    L26:
        r104 = null;
    L24:
        th = th;
        r104 = null;
        goto L37
    }
}
