package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.sg1;
import com.bytedance.android.livesdk.config.w00;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f66260a = null;

    static {
        f66260a = TokenCert.with("bpea-apputil_request_permission");
    }

    public static int b(ExifInterface r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        f06.a r107 = r104[r106];
        int r111 = r106;
        int r112 = r105;
        f06.a[] r113 = r104;
        f06.d r108 = r107.preInvoke(SpeechCode.SPEECH_VC_TASK_TYPE_NOT_MATCH, "android/media/ExifInterface", "getAttributeInt", r210, r101, "int", r110);     // Catch: Exception -> L22
        if (r108.f474982a == true) goto L17;
        r100.add(r107);     // Catch: Exception -> L22
    L17:
        if (r108.f474982a == false) goto L21;
        return ((Integer) r108.f474983b).intValue();
    L21:
        return r210.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
    L14:
        r106 = r111 + 1;
        r105 = r112;
        r104 = r113;
        goto L8
    L15:
        r108 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static int e(Bitmap r100) {
    L17:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (Build.VERSION.SDK_INT < 24) goto L16;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: IOException -> L17
        r100.compress(Bitmap.CompressFormat.JPEG, 100, r101);     // Catch: IOException -> L17
        int r102 = b(new ExifInterface(new ByteArrayInputStream(r101.toByteArray())));     // Catch: IOException -> L17
        if (r102 != 3) goto L9;
        return 180;
    L9:
        if (r102 != 6) goto L11;
        return 90;
    L11:
        if (r102 != 8) goto L25;
        return 270;
    L25:
        return 0;
    L16:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    public static Uri c(Context r100, String r101) {
        ?? r102 = 0;
        if (StringUtils.isEmpty(r101) == false) goto L29;
        return null;
    L29:
        Cursor r103 = a(r100.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{DBDefinition.ID}, "_data= ?", new String[]{r101});     // Catch: Throwable -> L13 Exception -> L15
    L11:
        Exception e100 = e;
    L17:
        e100.printStackTrace();     // Catch: Throwable -> L21
        if (r103 == null) goto L20;
    L19:
        r103.close();
    L20:
        return null;
    L7:
        if (r103.moveToFirst() == false) goto L19;
        Uri r104 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Long.parseLong(r103.getString(0)));     // Catch: Exception -> L11 Throwable -> L21
        r103.close();
        return r104;
    L15:
        e = move-exception;
        e100 = e;
        r103 = null;
    L13:
        Throwable th10 = th;
    L23:
        if (r102 == 0) goto L25;
        r102.close();
    L25:
        throw th10;
    L21:
        th = move-exception;
        r102 = r100;
        th10 = th;
        goto L23
    }

    public static String d(Context r110, Uri r111) {
        Cursor r100 = null;
        if (r111 != null) goto L5;
        return null;
    L5:
        String r101 = r111.getScheme();
        if (StringUtils.isEmpty(r101) == true) goto L103;
        if ("file".equals(r101) == true) goto L103;
        if ("http".equals(r101) == false) goto L15;
        return r111.toString();
    L15:
        if ("content".equals(r101) == false) goto L101;
        String[] r102 = {"_data"};
        String r103 = "";
        r100 = a(r110.getContentResolver(), r111, r102, null, null);     // Catch: Exception -> L22 Throwable -> L23
        if (r100.moveToFirst() == false) goto L20;
        r103 = r100.getString(0);     // Catch: Exception -> L22 Throwable -> L23
    L20:
        r100.close();     // Catch: Exception -> L22 Throwable -> L23
    L119:
        r100.close();     // Catch: Exception -> L30
    L32:
        if (StringUtils.isEmpty(r103) == false) goto L53;
        ContentResolver r104 = r110.getContentResolver();     // Catch: Exception -> L43 Throwable -> L44
        String r112 = r111.getLastPathSegment();     // Catch: Exception -> L43 Throwable -> L44
        if (StringUtils.isEmpty(r112) == false) goto L36;
    L38:
        r100 = a(r104, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r102, "_id= ?", new String[]{r112});     // Catch: Exception -> L43 Throwable -> L44
        if (r100.moveToFirst() == false) goto L41;
        r103 = r100.getString(0);     // Catch: Exception -> L43 Throwable -> L44
    L41:
        r100.close();     // Catch: Exception -> L43 Throwable -> L44
    L109:
        r100.close();     // Catch: Exception -> L51
        goto L53
        goto L48
    L36:
        if (r112.contains(":") == false) goto L38;
        r112 = r112.split(":")[1];     // Catch: Exception -> L43 Throwable -> L44
    L44:
        th = move-exception;
        if (r100 != null) goto L121;
    L47:
        throw th;
    L121:
        r100.close();     // Catch: Exception -> L105
    L48:
        if (r100 != null) goto L109;
    L53:
        if (StringUtils.isEmpty(r103) == false) goto L74;
        ContentResolver r105 = r110.getContentResolver();     // Catch: Exception -> L64 Throwable -> L65
        String r113 = r111.getLastPathSegment();     // Catch: Exception -> L64 Throwable -> L65
        if (StringUtils.isEmpty(r113) == false) goto L57;
    L59:
        r100 = a(r105, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, r102, "_id= ?", new String[]{r113});     // Catch: Exception -> L64 Throwable -> L65
        if (r100.moveToFirst() == false) goto L62;
        r103 = r100.getString(0);     // Catch: Exception -> L64 Throwable -> L65
    L62:
        r100.close();     // Catch: Exception -> L64 Throwable -> L65
    L117:
        r100.close();     // Catch: Exception -> L72
        goto L74
        goto L69
    L57:
        if (r113.contains(":") == false) goto L59;
        r113 = r113.split(":")[1];     // Catch: Exception -> L64 Throwable -> L65
    L65:
        th = move-exception;
        if (r100 != null) goto L107;
    L68:
        throw th;
    L107:
        r100.close();     // Catch: Exception -> L104
    L69:
        if (r100 != null) goto L117;
    L74:
        if (StringUtils.isEmpty(r103) == true) goto L76;
        return r103;
    L76:
        if (sg1.f121227a.getValue().booleanValue() == false) goto L130;
    L89:
        e = move-exception;
        ALogger.e("LiveSDK_AppUtil", "parse doc failed", e);
    L115:
        String r114 = r111.getPath();     // Catch: Exception -> L98
        if (StringUtils.isEmpty(r103) == false) goto L131;
        if (r114 != null) goto L95;
        return r103;
    L95:
        if (r114.startsWith("/root") == false) goto L133;
        r103 = r114.substring(5);     // Catch: Exception -> L98
        ALogger.i("LiveSDK_AppUtil", "ears root path = " + r103);     // Catch: Exception -> L98
        return r103;
    L133:
        return r103;
    L131:
        return r103;
    L98:
        e = move-exception;
        ALogger.e("LiveSDK_AppUtil", "filePath failed", e);
        return r103;
    L78:
        if (DocumentsContract.isDocumentUri(r110, r111) == false) goto L115;
        String r115 = DocumentsContract.getDocumentId(r111);     // Catch: Exception -> L89
        if (r115 == null) goto L115;
        if (r115.contains(":") == false) goto L115;
        String[] r116 = r115.split(":");     // Catch: Exception -> L89
        if (r116.length < 2) goto L115;
        if ("primary".equalsIgnoreCase(r116[0]) == false) goto L115;
        r103 = Environment.getExternalStorageDirectory() + HTTP.URL_DEFAULT + r116[1];     // Catch: Exception -> L89
        goto L115
    L130:
        return r103;
    L23:
        th = move-exception;
        if (r100 != null) goto L113;
    L26:
        throw th;
    L113:
        r100.close();     // Catch: Exception -> L106
    L27:
        if (r100 == null) goto L32;
    L101:
        return null;
    L103:
        return r111.getPath();
    }

    public static File f(Context r100, boolean r101) {
        if (r101 == false) goto L4;
        File r102 = r100.getExternalCacheDir();
    L5:
        if (r102 == null) goto L7;
        return r102;
    L7:
        return r100.getCacheDir();
    L4:
        r102 = null;
        goto L5
    }

    public static o1 g(Context r100, Uri r101) {
        o1 r102 = new o1();
        r102.f66249a = r101;
        String r103 = r101.getScheme();
        r103.getClass();
        PolarisFileWrapper r104 = null;
        if (r103.equals("file") == false) goto L5;
        int r105 = com.ss.ugc.effectplatform.util.r.f458047a;
        if (com.ss.ugc.effectplatform.util.r.b(r101.getPath()) == true) goto L21;
        r104 = new PolarisFileWrapper(r101.getPath());
    L21:
        if (r104 != null) goto L23;
    L25:
        return r102;
    L23:
        if (r104.exists() == false) goto L25;
        r102.f66251c = Long.valueOf(r104.length());
        r102.f66250b = r104.getName();
        goto L25
    L5:
        if (r103.equals("content") == true) goto L26;
        return r102;
    L26:
        Uri r106 = UriProtector.parse(r101.toString());     // Catch: Exception -> L16
        ContentResolver r107 = r100.getContentResolver();     // Catch: Exception -> L16
        if (r107 != null) goto L10;
        return r102;
    L10:
        Cursor r108 = a(r107, r106, null, null, null);     // Catch: Exception -> L16
        if (r108 != null) goto L13;
    L15:
        return r102;
    L13:
        if (r108.moveToFirst() == false) goto L15;
        String r109 = r108.getString(r108.getColumnIndex("_display_name"));     // Catch: Exception -> L16
        long r110 = r108.getLong(r108.getColumnIndex("_size"));     // Catch: Exception -> L16
        r102.f66250b = r109;     // Catch: Exception -> L16
        r102.f66251c = Long.valueOf(r110);     // Catch: Exception -> L16
        r108.close();     // Catch: Exception -> L16
    L17:
        return new o1();
    }

    public static File h(Context r100, String r101) {
        File r102 = f(r100, true);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, r101);
        if (r103.exists() == true) goto L8;
        if (r103.mkdir() == true) goto L8;
        return r102;
    L8:
        return r103;
    }

    public static void o(Activity r100, Fragment r101) {
        Intent r102 = new Intent();
        r102.setType("image/*");
        r102.setAction("android.intent.action.OPEN_DOCUMENT");
        if (r101 == null) goto L5;
        r101.startActivityForResult(r102, 40003);     // Catch: Exception -> L7
    L9:
        return;
    L5:
        r100.startActivityForResult(r102, 40003);     // Catch: Exception -> L7
    L7:
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_gallery);
    }

    public static void n(Activity r100, Fragment r101, com.bytedance.android.livesdk.utils.k2.a r102) {
        if (r102 == null) goto L5;
        r102.onCallback();
    L5:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_sdcard);
        return;
    L8:
        Intent r103 = new Intent();
        r103.setType("image/*");
        r103.setAction("android.intent.action.GET_CONTENT");
        if (r101 == null) goto L11;
        r101.startActivityForResult(r103, 40003);     // Catch: Exception -> L13
    L15:
        return;
    L11:
        r100.startActivityForResult(r103, 40003);     // Catch: Exception -> L13
    L13:
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_gallery);
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }

    public static void j(FragmentActivity r100, Fragment r101, String r102, String r103, TokenCert r104) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L6;
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_sdcard);
        return;
    L6:
        SettingKey<Boolean> r105 = m60.i.f512260a;
        m60.i.b r106 = new m60.i.b(r100);
        r106.f512265d = new i();
        r106.f512266e = new i();
        r106.b(new n(r102, r103, r100, r101), null, r104, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void l(Activity r100, Fragment r101, int r102, TokenCert r103, com.bytedance.android.livesdk.utils.k2.a r104) {
        int r105 = Build.VERSION.SDK_INT;
        if (r105 < 34) goto L8;
        if (r100.getApplicationInfo().targetSdkVersion < 34) goto L8;
        String r106 = "android.permission.READ_MEDIA_VISUAL_USER_SELECTED";
    L13:
        SettingKey<Boolean> r107 = m60.i.f512260a;
        m60.i.b r108 = new m60.i.b(r100);
        r108.f512265d = new i();
        r108.f512266e = new i();
        r108.b(new j(r104, r100, r101, r102), null, r103, new String[]{r106});
        return;
    L8:
        if (r105 >= 33) goto L10;
    L12:
        r106 = "android.permission.WRITE_EXTERNAL_STORAGE";
        goto L13
    L10:
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L12;
        r106 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
        goto L13
    }

    public static void m(Activity r100, Fragment r101, int r102, TokenCert r103, String[] r104) {
        SettingKey<Boolean> r105 = m60.i.f512260a;
        m60.i.b r106 = new m60.i.b(r100);
        r106.f512265d = new i();
        r106.f512266e = new i();
        r106.b(new k(r100, r101, r102), null, r103, r104);
    }

    public static void p(Activity r100, Fragment r101, int r102, TokenCert r110, com.bytedance.android.livesdk.utils.k2.a r111) {
        q(r100, r101, r102, false, false, r110, r111);
    }

    public static void i(Activity r100, Fragment r101, int r102, boolean r103, boolean r104, p1 r105) {
        if (r105 == null) goto L5;
        ((com.bytedance.android.livesdk.utils.k2.a) r105).onCallback();
    L5:
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_sdcard);
        return;
    L8:
        Intent r106 = new Intent();
        r106.setType("*/*");
        if (r102 != 40008) goto L11;
        String[] r107 = {"image/*", "video/*"};
    L12:
        r106.putExtra("android.intent.extra.MIME_TYPES", r107);
        r106.putExtra("android.intent.extra.ALLOW_MULTIPLE", r103);
        r106.putExtra("android.intent.extra.LOCAL_ONLY", r104);
        r106.setAction("android.intent.action.GET_CONTENT");
        r106.addCategory("android.intent.category.OPENABLE");
        if (r101 == null) goto L15;
        r101.startActivityForResult(r106, r102);     // Catch: Exception -> L17
    L19:
        return;
    L15:
        r100.startActivityForResult(r106, r102);     // Catch: Exception -> L17
    L17:
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_gallery);
        return;
    L11:
        r107 = new String[]{"image/*"};
        goto L12
    }

    public static void k(Activity r100, Fragment r110, int r111, String r112, String r113, TokenCert r114, com.bytedance.android.livesdk.utils.k2.a r115) {
        if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L6;
        UIUtils.displayToastWithIcon(r100, R.drawable.ttlive_close_popup_textpage, R.string.ttlive_core_photo_error_no_sdcard);
        return;
    L6:
        SettingKey<Boolean> r101 = m60.i.f512260a;
        m60.i.b r102 = new m60.i.b(r100);
        r102.f512265d = new i();
        r102.f512266e = new i();
        r102.b(new o(r115, r112, r113, r100, r110, r111), null, r114, new String[]{"android.permission.CAMERA"});
    }

    public static void q(Activity r110, Fragment r111, int r112, boolean r113, boolean r114, TokenCert r115, com.bytedance.android.livesdk.utils.k2.a r116) {
        int r100 = Build.VERSION.SDK_INT;
        String r101 = BaseConstants.PERMISSION_READ_MEDIA_IMAGES;
        if (r100 < 33) goto L9;
        if (r112 != 40008) goto L7;
        String[] r102 = {BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
    L12:
        String[] r103 = r102;
        if (w00.f121490a.getValue().booleanValue() == true) goto L15;
    L29:
        SettingKey<Boolean> r104 = m60.i.f512260a;
        m60.i.b r117 = new m60.i.b(r110);
        r117.f512265d = new i();
        r117.f512266e = new i();
        r117.b(new m(r110, r111, r112, r113, r114, r115, r116), null, r115, r103);
        return;
    L15:
        if (r112 != 40006) goto L17;
    L20:
        if (r100 >= 33) goto L24;
        r101 = "android.permission.READ_EXTERNAL_STORAGE";
    L24:
        if (ContextCompat.checkSelfPermission(r110, r101) == 0) goto L27;
        SettingKey<Boolean> r105 = m60.i.f512260a;
        m60.i.b r118 = new m60.i.b(r110);
        r118.f512265d = new i();
        r118.f512266e = new i();
        r118.b(new l(r110, r111, r112, r113, r114, r115, r116), null, r115, r103);
        return;
    L27:
        i(r110, r111, r112, r113, r114, r116);
        return;
    L17:
        if (r112 == 400013) goto L20;
        if (r112 != 40003) goto L29;
    L7:
        r102 = new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES};
        goto L12
    L9:
        if (r100 < 29) goto L11;
        r102 = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        goto L12
    L11:
        r102 = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        goto L12
    }
}
