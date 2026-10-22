package com.bytedance.android.annie.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes43.dex */
public final class d {
    public static boolean e() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static String f(String r100) {
        int r101 = r100.length();
        char[] r102 = r100.toCharArray();
        int r103 = 0;
        char r104 = 0;
        int r105 = 0;
    L4:
        if (r103 >= r101) goto L10;
        char r106 = r102[r103];
        if (r106 != '/') goto L8;
        if (r104 != '/') goto L8;
    L9:
        r103 = r103 + 1;
        r104 = r106;
    L8:
        r102[r105] = r106;
        r105 = r105 + 1;
        goto L9
    L10:
        if (r104 == '/') goto L12;
    L14:
        if (r105 != r101) goto L16;
        return r100;
    L16:
        return new String(r102, 0, r105);
    L12:
        if (r101 <= 1) goto L14;
        r105 = r105 - 1;
        goto L14
    }

    public static boolean g(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        boolean r101 = "mounted".equals(Environment.getExternalStorageState());     // Catch: Exception -> L6
    L7:
        if (r101 == false) goto L17;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L11;
        return false;
    L11:
        if (r102.delete() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return false;
    L6:
        r101 = false;
        goto L7
    L16:
        return false;
    }

    public static void b(PolarisFileInputStreamWrapper r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];     // Catch: Throwable -> L15
        if (r101 == null) goto L14;
    L5:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
        if (r103 <= 0) goto L7;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        goto L5
    L7:
        r101.flush();     // Catch: Throwable -> L15
        r100.close();     // Catch: IOException -> L20
    L24:
        r101.close();     // Catch: IOException -> L21
        return;
    L34:
        return;
    L14:
        throw new IOException("Failed to copy input:" + r100 + "output:" + r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r100.close();     // Catch: IOException -> L22
    L17:
        if (r101 == null) goto L35;
        r101.close();     // Catch: IOException -> L23
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    }

    public static Uri c(Context r100, String r101) {
        String r102 = "image/jpeg";
        if (e() == true) goto L5;
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_DCIM + "/Camera");
        if (r103.exists() == true) goto L34;
        r103.mkdirs();
    L34:
        String r104 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r100 != null) goto L37;
    L48:
        return null;
    L37:
        if (TextUtils.isEmpty(r101) == true) goto L48;
        if (TextUtils.isEmpty(r104) == true) goto L48;
        if (r104.endsWith(HTTP.URL_DEFAULT) == true) goto L43;
        r104 = r104.concat(HTTP.URL_DEFAULT);
    L43:
        ContentValues r105 = new ContentValues();
        r105.put("_display_name", r101);
        r105.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r105.put("mime_type", "image/jpeg");
        if (e() == false) goto L46;
        Uri r106 = MediaStore.Images.Media.getContentUri("external_primary");
        r105.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r104);
    L50:
        return a(r100.getContentResolver(), r106, r105);
    L46:
        Uri r107 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r105.put("_data", f(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r104 + HTTP.URL_DEFAULT + r101));
        r106 = r107;
        goto L50
    L5:
        if (r101.endsWith(".jpeg") == false) goto L7;
    L29:
        ContentValues r108 = new ContentValues();
        r108.put("title", r101);
        r108.put("_display_name", r101);
        r108.put("mime_type", r102);
        return a(r100.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r108);
    L7:
        if (r101.endsWith(".jpg") == true) goto L29;
        if (r101.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L13;
        r102 = "image/png";
        goto L29
    L13:
        if (r101.endsWith(EffectConstants.GIF_FILE_SUFFIX) == false) goto L16;
        r102 = MimeType.GIF;
        goto L29
    L16:
        if (r101.endsWith(".webp") == false) goto L19;
        r102 = MimeType.WEBP;
        goto L29
    L19:
        if (r101.endsWith(".bmp") == false) goto L22;
        r102 = "image/bmp";
        goto L29
    L22:
        if (r101.endsWith(".jpg2") == false) goto L25;
        r102 = "image/jp2";
        goto L29
    L25:
        if (r101.endsWith(".tif") == false) goto L27;
    L28:
        r102 = MimeType.TIFF;
        goto L29
    L27:
        if (r101.endsWith(".tiff") == false) goto L29;
        goto L28
    }

    public static Uri d(Context r100, String r101) {
        if (e() == false) goto L6;
        ContentValues r102 = new ContentValues();
        r102.put("title", r101);
        r102.put("_display_name", r101);
        r102.put("mime_type", MimeType.MP4);
        return a(r100.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r102);
    L6:
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_DCIM + "/Camera");
        if (r103.exists() == true) goto L9;
        r103.mkdirs();
    L9:
        String r104 = Environment.DIRECTORY_DCIM + "/Camera/";
        if (r100 != null) goto L12;
    L23:
        return null;
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        if (TextUtils.isEmpty(r104) == true) goto L23;
        if (r104.endsWith(HTTP.URL_DEFAULT) == true) goto L18;
        r104 = r104.concat(HTTP.URL_DEFAULT);
    L18:
        ContentValues r105 = new ContentValues();
        r105.put("_display_name", r101);
        r105.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r105.put("mime_type", MimeType.MP4);
        if (e() == false) goto L21;
        Uri r106 = MediaStore.Video.Media.getContentUri("external_primary");
        r105.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r104);
    L25:
        return a(r100.getContentResolver(), r106, r105);
    L21:
        Uri r107 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r105.put("_data", f(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r104 + HTTP.URL_DEFAULT + r101));
        r106 = r107;
        goto L25
    }

    public static Uri a(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
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
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
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
