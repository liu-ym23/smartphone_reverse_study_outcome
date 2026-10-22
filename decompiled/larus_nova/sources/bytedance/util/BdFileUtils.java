package bytedance.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class BdFileUtils {
    static List<String> THIRD_FULL_PROVIDER;
    static List<String> THIRD_PROVIDER;

    public BdFileUtils() {
    }

    static {
        THIRD_PROVIDER = Arrays.asList(new String[]{"com.kuaishou.nebula.fileprovider", "com.kwai.videoeditor.kyfileprovider", "com.lemon.lvoverseas.provider", "com.lwcx.lw121.fileprovider", "com.zivn.cloudbrush3.utilcode.provider", "com.tencent.mtt.fileprovider", "com.campmobile.snowcamera.fileprovider", "com.android.fileexplorer.myprovider", "com.ifeimo.videoeditor.provider", "com.mi.android.globalFileexplorer.myprovider"});
        THIRD_FULL_PROVIDER = Arrays.asList(new String[]{"com.jk.cutout.application", "com.zone2345.fileprovider", "com.mobile.kadian.fileprovider"});
    }

    public static boolean isNewGooglePhotosUri(Uri r100) {
        return "com.google.android.apps.photos.contentprovider".equals(r100.getAuthority());
    }

    public static String convertUriToPath(Context r110, Uri r111) {
        Uri r100 = null;
        if (r111 != null) goto L5;
        return null;
    L5:
        String r101 = r111.getScheme();
        if (TextUtils.isEmpty(r101) == true) goto L113;
        if ("file".equals(r101) == true) goto L113;
        if ("http".equals(r101) == false) goto L15;
        return r111.toString();
    L15:
        if ("content".equals(r101) == true) goto L17;
    L20:
        int r102 = Build.VERSION.SDK_INT;
        if (DocumentsContract.isDocumentUri(r110, r111) == false) goto L66;
        if (TextUtils.equals("com.android.externalstorage.documents", r111.getAuthority()) == false) goto L29;
        String[] r103 = DocumentsContract.getDocumentId(r111).split(":");
        if ("primary".equalsIgnoreCase(r103[0]) == false) goto L66;
        return Environment.getExternalStorageDirectory() + HTTP.URL_DEFAULT + r103[1];
    L29:
        if (TextUtils.equals("com.android.providers.downloads.documents", r111.getAuthority()) == false) goto L53;
        String r104 = DocumentsContract.getDocumentId(r111);
        if (r104 == null) goto L37;
        if (r104.startsWith("raw:") == false) goto L37;
        return r104.substring(4);
    L37:
        if (r102 >= 26) goto L39;
        Uri r105 = ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.valueOf(r104).longValue());
    L40:
        String r106 = getDataColumn(r110, r105, null, null);
        if (r106 == null) goto L116;
    L51:
        return r106;
    L116:
        String r107 = new PolarisFileWrapper(r110.getCacheDir(), "uri_tmp").getAbsolutePath();     // Catch: IOException -> L114
        ParcelFileDescriptor r112 = bytedance_util_BdFileUtils_android_content_ContentResolver_openFileDescriptor(r110.getContentResolver(), r111, "r");     // Catch: IOException -> L114
        if (r112 != null) goto L45;
        return null;
    L45:
        PolarisFileInputStreamWrapper r113 = new PolarisFileInputStreamWrapper(r112.getFileDescriptor());     // Catch: IOException -> L114
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r107);     // Catch: IOException -> L114
        byte[] r108 = new byte[4096];     // Catch: IOException -> L114
    L46:
        int r109 = r113.read(r108);     // Catch: IOException -> L114
        if (r109 == (-1)) goto L49;
        r114.write(r108, 0, r109);     // Catch: IOException -> L114
        goto L46
    L49:
        r113.close();     // Catch: IOException -> L114
        r114.close();     // Catch: IOException -> L114
        return new PolarisFileWrapper(r107).getAbsolutePath();
    L39:
        r105 = r111;
        goto L40
    L53:
        if (TextUtils.equals("com.android.providers.media.documents", r111.getAuthority()) == false) goto L66;
        String[] r115 = DocumentsContract.getDocumentId(r111).split(":");
        String r116 = r115[0];
        if (TextUtils.equals("image", r116) == false) goto L58;
        r100 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L64:
        return getDataColumn(r110, r100, "_id=?", new String[]{r115[1]});
    L58:
        if (TextUtils.equals("video", r116) == false) goto L61;
        r100 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L64
    L61:
        if (TextUtils.equals("audio", r116) == false) goto L64;
        r100 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L66:
        if ("content".equals(r101) == false) goto L111;
        r110.getContentResolver();
        if (isNewGooglePhotosUri(r111) == false) goto L82;
        String r117 = r111.getPath();     // Catch: Exception -> L80
        if (r117.contains("mediakey") == true) goto L72;
        int r118 = r117.lastIndexOf("/ORIGINAL");     // Catch: Exception -> L80
        if (r118 >= 0) goto L76;
        r118 = r117.lastIndexOf("/ACTUAL");     // Catch: Exception -> L80
    L76:
        if (r118 >= 0) goto L79;
        return null;
    L79:
        return getDataColumn(r110, UriProtector.parse(r117.substring(r117.indexOf("content"), r117.lastIndexOf("/ORIGINAL"))), null, null);
    L72:
        return getNewGooglephotosFilePath(r110, r111);
    L80:
        return null;
    L82:
        if (THIRD_PROVIDER.contains(r111.getAuthority()) == false) goto L92;
        if (TextUtils.isEmpty(r111.getPath()) == true) goto L97;
        ArrayList r119 = new ArrayList(r111.getPathSegments());
        ListProtector.remove(r119, 0);
        StringBuilder r120 = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        Iterator r121 = r119.iterator();
    L87:
        if (r121.hasNext() == false) goto L90;
        String r122 = (String) r121.next();
        r120.append(HTTP.URL_DEFAULT);
        r120.append(r122);
        goto L87
    L90:
        return r120.toString();
    L97:
        String r123 = r111.getLastPathSegment();
        if (TextUtils.isEmpty(r123) == true) goto L103;
        if (r123.startsWith("/storage/emulated/") == false) goto L103;
        return r123;
    L103:
        if (TextUtils.isEmpty(r123) == true) goto L108;
        if (r123.contains(":") == false) goto L108;
        r123 = r123.split(":")[1];
    L108:
        if (TextUtils.isDigitsOnly(r123) == false) goto L111;
        return getDataColumn(r110, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id= ?", new String[]{r123});
    L92:
        if (THIRD_FULL_PROVIDER.contains(r111.getAuthority()) == false) goto L97;
        String r124 = r111.getPath();
        if (TextUtils.isEmpty(r124) == true) goto L97;
        return Environment.getExternalStorageDirectory().getAbsolutePath() + r124;
    L111:
        return null;
    L17:
        if ("media".equals(r111.getAuthority()) == false) goto L20;
        return getDataColumn(r110, r111, null, null);
    L113:
        return r111.getPath();
    }

    private static File createImageFile(Context r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getCacheDir(), "uritemp");
        if (r102.exists() == true) goto L6;
        r102.mkdirs();
    L6:
        return new PolarisFileWrapper(r102, r101);
    }

    private static String getNewGooglephotosFilePath(Context r100, Uri r101) throws Exception {
        ParcelFileDescriptor r102 = bytedance_util_BdFileUtils_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r101, "r");
        PolarisFileInputStreamWrapper r103 = null;
        if (r102 != null) goto L31;
        return null;
    L31:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r102.getFileDescriptor());     // Catch: Throwable -> L20
        BufferedInputStream r105 = new BufferedInputStream(r104);     // Catch: Throwable -> L17
        File r106 = createImageFile(r100, r101.getPath().substring(r101.getPath().lastIndexOf(HTTP.URL_DEFAULT)) + ".jpg");     // Catch: Throwable -> L17
        BufferedOutputStream r107 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r106));     // Catch: Throwable -> L17
        byte[] r108 = new byte[8192];     // Catch: Throwable -> L15
    L9:
        int r109 = r105.read(r108);     // Catch: Throwable -> L15
        if (r109 <= 0) goto L13;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L15
        goto L9
    L13:
        r104.close();
        r107.close();
        return r106.getAbsolutePath();
    L15:
        th = th;
    L19:
        r103 = r104;
    L22:
        if (r103 == null) goto L24;
        r103.close();
    L24:
        if (r107 == null) goto L26;
        r107.close();
    L26:
        throw th;
    L17:
        th = th;
        r107 = null;
    L20:
        th = th;
        r107 = null;
        goto L22
    }

    private static ParcelFileDescriptor bytedance_util_BdFileUtils_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
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
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static String getDataColumn(Context r100, Uri r101, String r110, String[] r111) {
        Cursor r102 = null;
        Cursor r103 = bytedance_util_BdFileUtils_android_content_ContentResolver_query(r100.getContentResolver(), r101, new String[]{"_data"}, r110, r111, null);     // Catch: Throwable -> L15 IllegalArgumentException -> L19
        if (r103 != null) goto L23;
    L13:
        if (r103 != null) goto L21;
    L22:
        return null;
    L21:
        r103.close();
        goto L22
    L23:
    L10:
        th = th;
        r102 = r103;
    L16:
        if (r102 == null) goto L18;
        r102.close();
    L18:
        throw th;
    L6:
        if (r103.moveToFirst() == false) goto L13;
        String r104 = r103.getString(r103.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        r103.close();
        return r104;
    L20:
        if (r103 == null) goto L22;
    L19:
        r103 = null;
    L15:
        th = th;
        goto L16
    }

    private static Cursor bytedance_util_BdFileUtils_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
