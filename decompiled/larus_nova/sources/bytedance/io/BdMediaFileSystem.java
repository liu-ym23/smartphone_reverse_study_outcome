package bytedance.io;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Size;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.ss.android.downloadlib.constants.MimeType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import x.f;

/* JADX INFO: loaded from: classes28.dex */
public class BdMediaFileSystem {
    private static final String[] ALBUM_COUNT_PROJECTION = null;
    private static final String[] ALBUM_PROJECTION_HIGH = null;
    private static final String[] ALBUM_PROJECTION_LOW = null;
    private static final String[] AUDIO_PROJECTION_HIGH = null;
    private static final String[] AUDIO_PROJECTION_LOW = null;
    private static final String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final String COLUMN_BUCKET_ID = "bucket_id";
    private static final String COLUMN_DURATION = "duration";
    private static final String COLUMN_ORIENTATION = "orientation";
    private static final String[] IMAGE_PROJECTION_HIGH = null;
    private static final String[] IMAGE_PROJECTION_LOW = null;
    public static final String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final String MIME_TYPE_PREFIX_VIDEO = "video";
    private static final String SELECTION_ALL = "(media_type=? OR media_type=?) AND _size>0 AND width>0";
    private static final String[] SELECTION_ALL_ARGS = null;
    private static final String[] SELECT_AUDIOS = null;
    private static final String[] SELECT_IMAGE = null;
    private static final String[] SELECT_VIDEOS = null;
    private static final String[] VIDEO_PROJECTION_HIGH = null;
    private static final String[] VIDEO_PROJECTION_LOW = null;

    public static class a implements Comparator<BdMediaFolder> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(BdMediaFolder r100, BdMediaFolder r101) {
            return Long.compare(r101.f21479e, r100.f21479e);
        }
    }

    public BdMediaFileSystem() {
    }

    static {
        IMAGE_PROJECTION_HIGH = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data", "datetaken", "orientation"};
        IMAGE_PROJECTION_LOW = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "_size", "width", "height", "_data", "datetaken", "orientation"};
        VIDEO_PROJECTION_HIGH = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "width", "height", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data", "datetaken", "resolution", "orientation"};
        VIDEO_PROJECTION_LOW = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "width", "height", "_data", "datetaken", "resolution"};
        AUDIO_PROJECTION_HIGH = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "is_music", "album", "album_id", "artist", "title", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data", "datetaken"};
        AUDIO_PROJECTION_LOW = new String[]{DBDefinition.ID, "_display_name", "date_modified", "date_added", "mime_type", "duration", "_size", "album", "album_id", "artist", "title", "is_music", "_data"};
        ALBUM_PROJECTION_HIGH = new String[]{DBDefinition.ID, "_display_name", "date_added", "mime_type", "_size", "width", "height", "duration", LynxEventReporter.PROP_NAME_RELATIVE_PATH, "_data", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "orientation"};
        ALBUM_COUNT_PROJECTION = new String[]{DBDefinition.ID, COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
        ALBUM_PROJECTION_LOW = new String[]{DBDefinition.ID, "_display_name", "date_added", "mime_type", "_size", "width", "height", "duration", "_data", COLUMN_BUCKET_ID, COLUMN_BUCKET_DISPLAY_NAME, "orientation"};
        SELECTION_ALL_ARGS = new String[]{String.valueOf(1), String.valueOf(3)};
        SELECT_IMAGE = new String[]{"image/jpeg", "image/png", MimeType.GIF, MimeType.WEBP, "image/bmp"};
        SELECT_VIDEOS = new String[]{"video/webm", MimeType.MP4, "video/ogg", "video/flv", "video/avi", "video/wmv", "video/rmvb"};
        SELECT_AUDIOS = new String[]{"audio/mp3", "audio/midi", MimeType.WAV, "audio/m3u", "audio/m4a", "audio/ogg", "audio/ra"};
    }

    public static Uri createImageUri(Context r100, String r101) {
        return createImageUri(r100, r101, "image/jpeg");
    }

    public static Uri createMusicUri(Context r100, String r101) {
        return createMusicUri(r100, r101, "audio/mp3");
    }

    public static Uri createVideoUri(Context r100, String r101) {
        return createVideoUri(r100, r101, MimeType.MP4);
    }

    public static Uri getFileUri(Context r100, File r101) throws IOException {
        return new f(r100, r101).f561989c.take();
    L4:
        e = move-exception;
        throw new IOException("File failed to scan as a uri", e);
    }

    public static Uri getImageContentUri(Context r100, String r101) {
        return getImageContentUri(r100, r101, null);
    }

    public static long getLength(Context r100, Uri r101) {
        if ("file".equals(r101.getScheme()) == false) goto L7;
        return new PolarisFileWrapper(r101.getPath()).length();
    L7:
        if ("content".equals(r101.getScheme()) == true) goto L12;
    L10:
        return 0;
    L12:
        return bytedance_io_BdMediaFileSystem_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r101, "r").getStatSize();
    }

    public static String getMimeType(Context r100, Uri r101) {
        return r100.getContentResolver().getType(r101);
    }

    public static Uri getMusicContentUri(Context r100, String r101) {
        return getMusicContentUri(r100, r101, null);
    }

    public static Uri getVideoContentUri(Context r100, String r101) {
        return getVideoContentUri(r100, r101, null);
    }

    public static boolean isUriExists(Context r100, Uri r101) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        AssetFileDescriptor r102 = ContentResolverWrapper.openAssetFileDescriptor(r100.getContentResolver(), r101, "r");     // Catch: FileNotFoundException -> L15
        if (r102 != null) goto L16;
        return false;
    L16:
        r102.close();     // Catch: IOException -> L14
        return true;
    L20:
        return true;
    L13:
        return false;
    }

    public static void updateMediaStore(Context r100, String r101) {
        Intent r102 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        r102.setData(Uri.fromFile(new PolarisFileWrapper(r101)));
        r100.sendBroadcast(r102);
        MediaScannerConnection.scanFile(r100, new String[]{r101}, null, null);
    }

    private static Uri bytedance_io_BdMediaFileSystem_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
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
        d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
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
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static ParcelFileDescriptor bytedance_io_BdMediaFileSystem_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
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

    public static Uri createImageUri(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_DCIM + "/Camera");
        if (r103.exists() == true) goto L6;
        r103.mkdirs();
    L6:
        return createImageUri(r100, r101, r102, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createMusicUri(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_MUSIC);
        if (r103.exists() == true) goto L6;
        r103.mkdirs();
    L6:
        return createMusicUri(r100, r101, r102, Environment.DIRECTORY_MUSIC + HTTP.URL_DEFAULT);
    }

    public static Uri createVideoUri(Context r100, String r101, String r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + Environment.DIRECTORY_DCIM + "/Camera");
        if (r103.exists() == true) goto L6;
        r103.mkdirs();
    L6:
        return createVideoUri(r100, r101, r102, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri getImageContentUri(Context r100, String r101, String r102) {
        return getImageContentUri(r100, r101, r102, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri getMusicContentUri(Context r100, String r101, String r102) {
        return getMusicContentUri(r100, r101, r102, Environment.DIRECTORY_MUSIC);
    }

    public static Uri getVideoContentUri(Context r100, String r101, String r102) {
        return getVideoContentUri(r100, r101, r102, Environment.DIRECTORY_DCIM + "/Camera/");
    }

    public static Uri createImageUri(Context r100, String r101, String r102, String r103) {
        return createImageUri(r100, r101, r102, r103, null);
    }

    public static Uri createMusicUri(Context r100, String r101, String r102, String r103) {
        return createMusicUri(r100, r101, r102, r103, null);
    }

    public static Uri createVideoUri(Context r100, String r101, String r102, String r103) {
        return createVideoUri(r100, r101, r102, r103, null);
    }

    public static Uri getImageContentUri(Context r110, String r111, String r112, String r113) {
        String r100 = r113;
        Cursor r101 = null;
        Uri r102 = null;
        if (r110 != null) goto L5;
    L66:
        return null;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L66;
        if (TextUtils.isEmpty(r113) == true) goto L66;
        if (r100.endsWith(HTTP.URL_DEFAULT) == true) goto L12;
        r100 = r100.concat(HTTP.URL_DEFAULT);
    L12:
        Uri r103 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L68;
        r103 = MediaStore.Images.Media.getContentUri("external_primary");
    L68:
        String r104 = bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r100 + HTTP.URL_DEFAULT + r111);     // Catch: Throwable -> L62
        if (bytedance.util.a.d() == false) goto L19;
        Cursor r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r103, new String[]{DBDefinition.ID, "mime_type"}, bytedance.util.a.c("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{r100, r100.substring(0, r100.length() - 1), r111}, -1, 0, null), null);     // Catch: Throwable -> L62
    L20:
        Cursor r106 = r105;
        if (r106 != null) goto L67;
    L59:
        if (r106 == null) goto L61;
        r106.close();
    L61:
        return null;
    L67:
    L57:
        th = th;
        r101 = r106;
    L63:
        if (r101 == null) goto L65;
        r101.close();
    L65:
        throw th;
    L23:
        if (r106.moveToFirst() == false) goto L59;
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L57
        BdMediaItem r108 = new BdMediaItem();     // Catch: Throwable -> L57
        r108.setMimeType(r106.getString(r106.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L57
        r108.setUri(ContentUris.withAppendedId(r103, r106.getLong(r106.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L57
        r107.add(r108);     // Catch: Throwable -> L57
    L26:
        if (r106.moveToNext() == false) goto L30;
        BdMediaItem r109 = new BdMediaItem();     // Catch: Throwable -> L57
        r108.setMimeType(r106.getString(r106.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L57
        r108.setUri(ContentUris.withAppendedId(r103, r106.getLong(r106.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L57
        r107.add(r109);     // Catch: Throwable -> L57
        goto L26
    L30:
        if (r107.size() == 1) goto L32;
        Iterator r114 = r107.iterator();     // Catch: Throwable -> L57
    L43:
        if (r114.hasNext() == false) goto L51;
        BdMediaItem r115 = (BdMediaItem) r114.next();     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r112) == true) goto L50;
        if ("image/*".equals(r112) == true) goto L50;
        if (r112.equals(r115.getMimeType()) == false) goto L43;
    L50:
        r102 = r115.getUri();     // Catch: Throwable -> L57
    L51:
        if (r102 == null) goto L56;
        Uri r116 = r102;
    L53:
        r106.close();
        return r116;
    L56:
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r107.get(0)).getMimeType());     // Catch: Throwable -> L57
    L32:
        if (TextUtils.isEmpty(r112) == false) goto L34;
    L40:
        r116 = ((BdMediaItem) r107.get(0)).getUri();     // Catch: Throwable -> L57
        goto L53
    L34:
        if ("image/*".equals(r112) == true) goto L40;
        if (r112.equals(((BdMediaItem) r107.get(0)).getMimeType()) == true) goto L40;
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r107.get(0)).getMimeType());     // Catch: Throwable -> L57
    L19:
        r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r103, new String[]{DBDefinition.ID, "mime_type"}, "_data=?", new String[]{r104}, null);     // Catch: Throwable -> L62
    L62:
        th = th;
        goto L63
    }

    public static Uri getMusicContentUri(Context r110, String r111, String r112, String r113) {
        String r100 = r113;
        Cursor r101 = null;
        Uri r102 = null;
        if (r110 != null) goto L5;
    L66:
        return null;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L66;
        if (TextUtils.isEmpty(r113) == true) goto L66;
        if (r100.endsWith(HTTP.URL_DEFAULT) == true) goto L12;
        r100 = r100.concat(HTTP.URL_DEFAULT);
    L12:
        Uri r103 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L68;
        r103 = MediaStore.Audio.Media.getContentUri("external_primary");
    L68:
        String r104 = bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r100 + HTTP.URL_DEFAULT + r111);     // Catch: Throwable -> L62
        if (bytedance.util.a.d() == false) goto L19;
        Cursor r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r103, new String[]{DBDefinition.ID, "mime_type"}, bytedance.util.a.c("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{r100, r100.substring(0, r100.length() - 1), r111}, -1, 0, null), null);     // Catch: Throwable -> L62
    L20:
        Cursor r106 = r105;
        if (r106 != null) goto L67;
    L59:
        if (r106 == null) goto L61;
        r106.close();
    L61:
        return null;
    L67:
    L57:
        th = th;
        r101 = r106;
    L63:
        if (r101 == null) goto L65;
        r101.close();
    L65:
        throw th;
    L23:
        if (r106.moveToFirst() == false) goto L59;
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L57
        BdMediaItem r108 = new BdMediaItem();     // Catch: Throwable -> L57
        r108.setMimeType(r106.getString(r106.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L57
        r108.setUri(ContentUris.withAppendedId(r103, r106.getLong(r106.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L57
        r107.add(r108);     // Catch: Throwable -> L57
    L26:
        if (r106.moveToNext() == false) goto L30;
        BdMediaItem r109 = new BdMediaItem();     // Catch: Throwable -> L57
        r109.setMimeType(r106.getString(r106.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L57
        r109.setUri(ContentUris.withAppendedId(r103, r106.getLong(r106.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L57
        r107.add(r109);     // Catch: Throwable -> L57
        goto L26
    L30:
        if (r107.size() == 1) goto L32;
        Iterator r114 = r107.iterator();     // Catch: Throwable -> L57
    L43:
        if (r114.hasNext() == false) goto L51;
        BdMediaItem r115 = (BdMediaItem) r114.next();     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r112) == true) goto L50;
        if ("audio/*".equals(r112) == true) goto L50;
        if (r112.equals(r115.getMimeType()) == false) goto L43;
    L50:
        r102 = r115.getUri();     // Catch: Throwable -> L57
    L51:
        if (r102 == null) goto L56;
        Uri r116 = r102;
    L53:
        r106.close();
        return r116;
    L56:
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r107.get(0)).getMimeType());     // Catch: Throwable -> L57
    L32:
        if (TextUtils.isEmpty(r112) == false) goto L34;
    L40:
        r116 = ((BdMediaItem) r107.get(0)).getUri();     // Catch: Throwable -> L57
        goto L53
    L34:
        if ("audio/*".equals(r112) == true) goto L40;
        if (r112.equals(((BdMediaItem) r107.get(0)).getMimeType()) == true) goto L40;
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r107.get(0)).getMimeType());     // Catch: Throwable -> L57
    L19:
        r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r103, new String[]{DBDefinition.ID, "mime_type"}, "_data=?", new String[]{r104}, null);     // Catch: Throwable -> L62
    L62:
        th = th;
        goto L63
    }

    public static Bitmap getThumbnail(Context r100, Uri r101, int r102, int r103) throws IOException {
        return r100.getContentResolver().loadThumbnail(r101, new Size(r102, r103), null);
    }

    public static Uri getVideoContentUri(Context r110, String r111, String r112, String r113) {
        Cursor r100 = null;
        Uri r101 = null;
        if (r110 != null) goto L5;
    L63:
        return null;
    L5:
        if (TextUtils.isEmpty(r111) == true) goto L63;
        if (TextUtils.isEmpty(r113) == true) goto L63;
        Uri r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L64;
        r102 = MediaStore.Video.Media.getContentUri("external_primary");
    L64:
        String r103 = bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r113 + HTTP.URL_DEFAULT + r111);     // Catch: Throwable -> L59
        if (bytedance.util.a.d() == false) goto L16;
        Cursor r104 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r102, new String[]{DBDefinition.ID, "mime_type"}, bytedance.util.a.c("(relative_path=? OR relative_path=?) AND _display_name=?", new String[]{r113, r113.substring(0, r113.length() - 1), r111}, -1, 0, null), null);     // Catch: Throwable -> L59
    L17:
        Cursor r105 = r104;
        if (r105 != null) goto L65;
    L56:
        if (r105 == null) goto L58;
        r105.close();
    L58:
        return null;
    L65:
    L54:
        th = th;
        r100 = r105;
    L60:
        if (r100 == null) goto L62;
        r100.close();
    L62:
        throw th;
    L20:
        if (r105.moveToFirst() == false) goto L56;
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L54
        BdMediaItem r107 = new BdMediaItem();     // Catch: Throwable -> L54
        r107.setMimeType(r105.getString(r105.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L54
        r107.setUri(ContentUris.withAppendedId(r102, r105.getLong(r105.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L54
        r106.add(r107);     // Catch: Throwable -> L54
    L23:
        if (r105.moveToNext() == false) goto L27;
        BdMediaItem r108 = new BdMediaItem();     // Catch: Throwable -> L54
        r108.setMimeType(r105.getString(r105.getColumnIndexOrThrow("mime_type")));     // Catch: Throwable -> L54
        r108.setUri(ContentUris.withAppendedId(r102, r105.getLong(r105.getColumnIndexOrThrow(DBDefinition.ID))));     // Catch: Throwable -> L54
        r106.add(r108);     // Catch: Throwable -> L54
        goto L23
    L27:
        if (r106.size() == 1) goto L29;
        Iterator r109 = r106.iterator();     // Catch: Throwable -> L54
    L40:
        if (r109.hasNext() == false) goto L48;
        BdMediaItem r114 = (BdMediaItem) r109.next();     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(r112) == true) goto L47;
        if (r112.equals(r114.getMimeType()) == true) goto L47;
        if ("video/*".equals(r112) == false) goto L40;
    L47:
        r101 = r114.getUri();     // Catch: Throwable -> L54
    L48:
        if (r101 == null) goto L53;
        Uri r115 = r101;
    L50:
        r105.close();
        return r115;
    L53:
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r106.get(0)).getMimeType());     // Catch: Throwable -> L54
    L29:
        if (TextUtils.isEmpty(r112) == false) goto L31;
    L37:
        r115 = ((BdMediaItem) r106.get(0)).getUri();     // Catch: Throwable -> L54
        goto L50
    L31:
        if ("video/*".equals(r112) == true) goto L37;
        if (r112.equals(((BdMediaItem) r106.get(0)).getMimeType()) == true) goto L37;
        throw new IllegalArgumentException("Except mimetype is " + r112 + ", actual mimetype is " + ((BdMediaItem) r106.get(0)).getMimeType());     // Catch: Throwable -> L54
    L16:
        r104 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r102, new String[]{DBDefinition.ID, "mime_type"}, "_data=?", new String[]{r103}, null);     // Catch: Throwable -> L59
    L59:
        th = th;
        goto L60
    }

    private static Cursor bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, Bundle r113, CancellationSignal r114) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114};
        b r115 = new b();
        d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }

    public static Uri createImageUri(Context r100, String r101, String r102, String r103, ContentValues r104) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return null;
    L9:
        if (r103.endsWith(HTTP.URL_DEFAULT) == true) goto L11;
        r103 = r103.concat(HTTP.URL_DEFAULT);
    L11:
        if (r104 != null) goto L13;
        r104 = new ContentValues();
    L13:
        r104.put("_display_name", r101);
        r104.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r104.put("mime_type", r102);
        if (bytedance.util.a.d() == false) goto L16;
        Uri r105 = MediaStore.Images.Media.getContentUri("external_primary");
        r104.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r103);
    L18:
        return bytedance_io_BdMediaFileSystem_android_content_ContentResolver_insert(r100.getContentResolver(), r105, r104);
    L16:
        Uri r106 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r104.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT + r101));
        r105 = r106;
        goto L18
    }

    public static Uri createMusicUri(Context r100, String r101, String r102, String r103, ContentValues r104) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return null;
    L9:
        if (r103.endsWith(HTTP.URL_DEFAULT) == true) goto L11;
        r103 = r103.concat(HTTP.URL_DEFAULT);
    L11:
        if (r104 != null) goto L13;
        r104 = new ContentValues();
    L13:
        r104.put("_display_name", r101);
        r104.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r104.put("mime_type", r102);
        if (bytedance.util.a.d() == false) goto L16;
        Uri r105 = MediaStore.Audio.Media.getContentUri("external_primary");
        r104.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r103);
    L18:
        return bytedance_io_BdMediaFileSystem_android_content_ContentResolver_insert(r100.getContentResolver(), r105, r104);
    L16:
        Uri r106 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        r104.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT + r101));
        r105 = r106;
        goto L18
    }

    public static Uri createVideoUri(Context r100, String r101, String r102, String r103, ContentValues r104) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return null;
    L9:
        if (r103.endsWith(HTTP.URL_DEFAULT) == true) goto L11;
        r103 = r103.concat(HTTP.URL_DEFAULT);
    L11:
        if (r104 != null) goto L13;
        r104 = new ContentValues();
    L13:
        r104.put("_display_name", r101);
        r104.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        r104.put("mime_type", r102);
        if (bytedance.util.a.d() == false) goto L16;
        Uri r105 = MediaStore.Video.Media.getContentUri("external_primary");
        r104.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, r103);
    L18:
        return bytedance_io_BdMediaFileSystem_android_content_ContentResolver_insert(r100.getContentResolver(), r105, r104);
    L16:
        Uri r106 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        r104.put("_data", bytedance.util.a.e(Environment.getExternalStorageDirectory().getPath() + HTTP.URL_DEFAULT + r103 + HTTP.URL_DEFAULT + r101));
        r105 = r106;
        goto L18
    }

    private static Cursor bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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

    public static List<BdMediaFolder> getAlbums(Context r210, String r211, String[] r212, String r310, int r311, int r312) {
        String r100 = r310;
        ArrayList r101 = new ArrayList();
        Uri r102 = MediaStore.Files.getContentUri("external");
        Cursor r110 = null;
    L81:
        th = move-exception;
        if (0 != 0) goto L135;
    L137:
        throw th;
    L135:
        if (r110.isClosed() == true) goto L137;
        r110.close();
    L125:
        e = e;
        ArrayList r103 = r101;
    L127:
        e.printStackTrace();     // Catch: Throwable -> L81
        if (r110 != null) goto L130;
    L132:
        return r103;
    L130:
        if (r110.isClosed() == true) goto L132;
    L131:
        r110.close();
        goto L132
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L12;
        Cursor r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r102, ALBUM_PROJECTION_HIGH, bytedance.util.a.c(r211, r212, r311, r312, r100), null);     // Catch: Throwable -> L81 Exception -> L125
    L9:
        r110 = r105;
        if (r110 == null) goto L120;
        ArrayList<BdMediaItem> r106 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L125
        ArrayList<BdMediaItem> r107 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L125
        ArrayList<BdMediaItem> r108 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L125
        if (r110.getCount() <= 0) goto L120;
        int r109 = r110.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L81 Exception -> L125
        int r111 = r110.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L81 Exception -> L125
        int r112 = r110.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L81 Exception -> L125
        int r113 = r110.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L81 Exception -> L125
        int r114 = r110.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L81 Exception -> L125
        int r115 = r110.getColumnIndexOrThrow("width");     // Catch: Throwable -> L81 Exception -> L125
        int r116 = r110.getColumnIndexOrThrow("height");     // Catch: Throwable -> L81 Exception -> L125
        int r117 = r110.getColumnIndexOrThrow("duration");     // Catch: Throwable -> L81 Exception -> L125
        int r118 = r110.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L81 Exception -> L125
        int r119 = r110.getColumnIndexOrThrow(COLUMN_BUCKET_ID);     // Catch: Throwable -> L81 Exception -> L125
        int r120 = r110.getColumnIndexOrThrow(COLUMN_BUCKET_DISPLAY_NAME);     // Catch: Throwable -> L81 Exception -> L118
        ArrayList<BdMediaItem> r213 = r107;
        int r121 = r110.getColumnIndexOrThrow("orientation");     // Catch: Throwable -> L81 Exception -> L118
        if (bytedance.util.a.d() == false) goto L27;
        int r122 = r110.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L81 Exception -> L118
    L28:
        ArrayList<BdMediaItem> r214 = r106;
        StringBuilder r123 = new StringBuilder();     // Catch: Throwable -> L81 Exception -> L118
        Uri r124 = r102;
        r123.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L81 Exception -> L118
        r123.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L81 Exception -> L118
        int r125 = r123.toString().length();     // Catch: Throwable -> L81 Exception -> L118
        HashMap r126 = new HashMap();     // Catch: Throwable -> L81 Exception -> L118
    L30:
        HashMap r313 = r126;
        if (r110.moveToNext() == false) goto L112;
        BdMediaItem r127 = new BdMediaItem();     // Catch: Throwable -> L81 Exception -> L118
        int r128 = r122;
        int r314 = r120;
        long r129 = r110.getLong(r109);     // Catch: Throwable -> L81 Exception -> L118
        r127.setId(r129);     // Catch: Throwable -> L81 Exception -> L118
        int r130 = r109;
        r127.setName(r110.getString(r111));     // Catch: Throwable -> L81 Exception -> L118
        int r215 = r111;
        r127.setDateAdded(r110.getLong(r112));     // Catch: Throwable -> L81 Exception -> L118
        r127.setMimeType(r110.getString(r113));     // Catch: Throwable -> L81 Exception -> L118
        r127.setFileSize(r110.getLong(r114));     // Catch: Throwable -> L81 Exception -> L118
        int r131 = r110.getInt(r115);     // Catch: Throwable -> L81 Exception -> L118
        int r132 = r110.getInt(r116);     // Catch: Throwable -> L81 Exception -> L118
        int r216 = r112;
        int r133 = r110.getInt(r121);     // Catch: Throwable -> L81 Exception -> L118
        r127.setOrientation(r133);     // Catch: Throwable -> L81 Exception -> L118
        int r217 = r121;
        if (r133 != 90) goto L36;
    L39:
        r127.setWidth(r132);     // Catch: Throwable -> L81 Exception -> L118
        r127.setHeight(r131);     // Catch: Throwable -> L81 Exception -> L118
    L40:
        r127.setDuration(r110.getLong(r117));     // Catch: Throwable -> L81 Exception -> L118
        long r134 = r110.getLong(r119);     // Catch: Throwable -> L81 Exception -> L118
        String r135 = r110.getString(r314);     // Catch: Throwable -> L81 Exception -> L118
        r127.setBucketId(r134);     // Catch: Throwable -> L81 Exception -> L118
        r127.setBucketName(r135);     // Catch: Throwable -> L81 Exception -> L118
        if (bytedance.util.a.d() == false) goto L52;
        int r315 = r314;
        String r136 = r110.getString(r128);     // Catch: Throwable -> L81 Exception -> L118
        if (r136 != null) goto L50;
        int r218 = r128;
        String r137 = r110.getString(r118);     // Catch: Throwable -> L81 Exception -> L118
        int r219 = r113;
        String r138 = File.separator;     // Catch: Throwable -> L81 Exception -> L118
        int r220 = r114;
        int r221 = r115;
        r136 = r137.substring(r125, r137.lastIndexOf(r138)) + r138;     // Catch: IndexOutOfBoundsException -> L48 Throwable -> L81 Exception -> L118
    L51:
        r127.setRelativePath(r136);     // Catch: Throwable -> L81 Exception -> L118
    L56:
        Uri r139 = r124;
        r127.setUri(ContentUris.withAppendedId(r139, r129));     // Catch: Throwable -> L81 Exception -> L118
        ArrayList<BdMediaItem> r140 = r214;
        r140.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        if (r127.getMimeType() != null) goto L59;
    L61:
        ArrayList<BdMediaItem> r141 = r108;
        if (r127.getMimeType() != null) goto L64;
    L66:
        ArrayList<BdMediaItem> r142 = r213;
        boolean r143 = false;
    L67:
        boolean r144 = r143;
        boolean r145 = false;
    L68:
        int r222 = r119;
        if (r313.containsKey(Long.valueOf(r134)) == true) goto L90;
        BdMediaFolder r146 = new BdMediaFolder();     // Catch: Throwable -> L81 Exception -> L118
        r146.f21476b = r135;     // Catch: Throwable -> L81 Exception -> L118
        r146.f21475a = r134;     // Catch: Throwable -> L81 Exception -> L118
        r146.f21477c = r127.getUri();     // Catch: Throwable -> L81 Exception -> L118
        int r316 = r118;
        int r223 = r116;
        r146.f21479e = r127.getDateAdded();     // Catch: Throwable -> L81 Exception -> L118
        r146.f21478d = r127.getMimeType();     // Catch: Throwable -> L81 Exception -> L118
        ArrayList<BdMediaItem> r147 = r146.f21482h;     // Catch: Throwable -> L81 Exception -> L118
        if (r147 != null) goto L74;
        r147 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L74:
        r147.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        if (r145 == false) goto L83;
        ArrayList<BdMediaItem> r148 = r146.f21484j;     // Catch: Throwable -> L81 Exception -> L118
        if (r148 != null) goto L80;
        r148 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L80:
        r148.add(r127);     // Catch: Throwable -> L81 Exception -> L118
    L89:
        r146.f21480f = 1;     // Catch: Throwable -> L81 Exception -> L118
        r313.put(Long.valueOf(r134), r146);     // Catch: Throwable -> L81 Exception -> L118
    L111:
        r125 = r125;
        r116 = r223;
        r118 = r316;
        r124 = r139;
        r214 = r140;
        r213 = r142;
        r126 = r313;
        r109 = r130;
        r111 = r215;
        r112 = r216;
        r121 = r217;
        r122 = r218;
        r113 = r219;
        r114 = r220;
        r115 = r221;
        r119 = r222;
        r108 = r141;
        r120 = r315;
        goto L30
    L83:
        if (r144 == false) goto L89;
        ArrayList<BdMediaItem> r149 = r146.f21483i;     // Catch: Throwable -> L81 Exception -> L118
        if (r149 != null) goto L88;
        r149 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L88:
        r149.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        goto L89
    L90:
        r316 = r118;
        r223 = r116;
        BdMediaFolder r150 = (BdMediaFolder) r313.get(Long.valueOf(r134));     // Catch: Throwable -> L81 Exception -> L118
        if (r150 == null) goto L111;
        ArrayList<BdMediaItem> r151 = r150.f21482h;     // Catch: Throwable -> L81 Exception -> L118
        if (r151 != null) goto L97;
        r151 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L97:
        r151.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        if (r145 == false) goto L104;
        ArrayList<BdMediaItem> r152 = r150.f21484j;     // Catch: Throwable -> L81 Exception -> L118
        if (r152 != null) goto L103;
        r152 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L103:
        r152.add(r127);     // Catch: Throwable -> L81 Exception -> L118
    L110:
        r150.f21480f++;     // Catch: Throwable -> L81 Exception -> L118
        goto L111
    L104:
        if (r144 == false) goto L110;
        ArrayList<BdMediaItem> r153 = r150.f21483i;     // Catch: Throwable -> L81 Exception -> L118
        if (r153 != null) goto L109;
        r153 = new ArrayList();     // Catch: Throwable -> L81 Exception -> L118
    L109:
        r153.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        goto L110
    L64:
        if (r127.getMimeType().startsWith("image") == false) goto L66;
        r142 = r213;
        r142.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        r143 = true;
        goto L67
    L59:
        if (r127.getMimeType().startsWith("video") == false) goto L61;
        r141 = r108;
        r141.add(r127);     // Catch: Throwable -> L81 Exception -> L118
        r145 = true;
        r144 = false;
        r142 = r213;
    L49:
        r127.setRelativePath("");     // Catch: Throwable -> L81 Exception -> L118
        goto L51
    L50:
        r218 = r128;
        r219 = r113;
        r220 = r114;
        r221 = r115;
        goto L51
    L52:
        r315 = r314;
        r219 = r113;
        r220 = r114;
        r221 = r115;
        r218 = r128;
        String r154 = r110.getString(r118);     // Catch: Throwable -> L81 Exception -> L118
        String r155 = File.separator;     // Catch: Throwable -> L81 Exception -> L118
        r127.setRelativePath(r154.substring(r125, r154.lastIndexOf(r155)) + r155);     // Catch: IndexOutOfBoundsException -> L55 Throwable -> L81 Exception -> L118
    L55:
        r127.setRelativePath("");     // Catch: Throwable -> L81 Exception -> L118
        goto L56
    L36:
        if (r133 == 270) goto L39;
        r127.setWidth(r131);     // Catch: Throwable -> L81 Exception -> L118
        r127.setHeight(r132);     // Catch: Throwable -> L81 Exception -> L118
        goto L40
    L112:
        ArrayList<BdMediaItem> r156 = r213;
        ArrayList<BdMediaItem> r157 = r108;
        ArrayList<BdMediaItem> r158 = r214;
        r103 = r101;
        r103.addAll(r313.values());     // Catch: Throwable -> L81 Exception -> L116
        Collections.sort(r103, new a());     // Catch: Throwable -> L81 Exception -> L116
        BdMediaFolder r159 = new BdMediaFolder();     // Catch: Throwable -> L81 Exception -> L116
        r159.f21477c = r158.get(0).getUri();     // Catch: Throwable -> L81 Exception -> L116
        r159.f21478d = r158.get(0).getMimeType();     // Catch: Throwable -> L81 Exception -> L116
        r159.f21479e = r158.get(0).getDateAdded();     // Catch: Throwable -> L81 Exception -> L116
        r159.f21476b = "";     // Catch: Throwable -> L81 Exception -> L116
        r159.f21475a = -1;     // Catch: Throwable -> L81 Exception -> L116
        r159.f21482h = r158;     // Catch: Throwable -> L81 Exception -> L116
        r159.f21483i = r156;     // Catch: Throwable -> L81 Exception -> L116
        r159.f21484j = r157;     // Catch: Throwable -> L81 Exception -> L116
        r159.f21480f = r158.size();     // Catch: Throwable -> L81 Exception -> L116
        r159.f21481g = true;     // Catch: Throwable -> L81 Exception -> L116
        r103.add(0, r159);     // Catch: Throwable -> L81 Exception -> L116
    L121:
        if (r110 == null) goto L132;
        if (r110.isClosed() == true) goto L132;
    L116:
        e = e;
        goto L127
    L27:
        r122 = -1;
    L118:
        e = e;
        r103 = r101;
    L120:
        r103 = r101;
        goto L121
    L12:
        if (bytedance.util.a.d() == false) goto L16;
        if (r311 <= 0) goto L15;
        r100 = r100 + (" LIMIT " + r311 + " OFFSET " + r312);     // Catch: Throwable -> L81 Exception -> L125
    L15:
        r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r102, ALBUM_PROJECTION_HIGH, r211, r212, r100);     // Catch: Throwable -> L81 Exception -> L125
        goto L9
    L16:
        if (r311 <= 0) goto L18;
        r100 = r100 + (" LIMIT " + r311 + " OFFSET " + r312);     // Catch: Throwable -> L81 Exception -> L125
    L18:
        r105 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r102, ALBUM_PROJECTION_LOW, r211, r212, r100);     // Catch: Throwable -> L81 Exception -> L125
        goto L9
    L6:
        r104 = false;
        goto L7
    }

    public static List<BdMediaItem> getImages(Context r110, String r210, String[] r211, String r212, int r213, int r214) {
        String r100 = r212;
        ArrayList r101 = new ArrayList();
        Uri r111 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor r112 = null;
    L52:
        th = move-exception;
        if (r112 == null) goto L55;
        r112.close();
    L55:
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L12;
        Cursor r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r111, IMAGE_PROJECTION_HIGH, bytedance.util.a.c(r210, r211, r213, r214, r100), null);     // Catch: Throwable -> L52
    L9:
        r112 = r103;
        if (r112 != null) goto L24;
        if (r112 == null) goto L23;
        r112.close();
    L23:
        return r101;
    L24:
        int r104 = r112.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L52
        int r105 = r112.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L52
        int r106 = r112.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L52
        int r107 = r112.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L52
        int r108 = r112.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L52
        int r109 = r112.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L52
        int r113 = r112.getColumnIndexOrThrow("width");     // Catch: Throwable -> L52
        int r114 = r112.getColumnIndexOrThrow("height");     // Catch: Throwable -> L52
        int r115 = r112.getColumnIndexOrThrow("datetaken");     // Catch: Throwable -> L52
        int r116 = r112.getColumnIndexOrThrow("orientation");     // Catch: Throwable -> L52
        if (bytedance.util.a.d() == false) goto L27;
        int r117 = r112.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L52
    L28:
        int r118 = r112.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L52
        StringBuilder r119 = new StringBuilder();     // Catch: Throwable -> L52
        ArrayList r120 = r101;
        r119.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L52
        r119.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L52
        int r121 = r119.toString().length();     // Catch: Throwable -> L52
    L29:
        if (r112.moveToNext() == false) goto L50;
        BdMediaItem r122 = new BdMediaItem();     // Catch: Throwable -> L52
        int r123 = r117;
        int r124 = r118;
        long r125 = r112.getLong(r104);     // Catch: Throwable -> L52
        r122.setId(r125);     // Catch: Throwable -> L52
        int r215 = r104;
        r122.setName(r112.getString(r105));     // Catch: Throwable -> L52
        int r216 = r105;
        r122.setModify(r112.getLong(r106));     // Catch: Throwable -> L52
        r122.setDateAdded(r112.getLong(r107));     // Catch: Throwable -> L52
        r122.setMimeType(r112.getString(r108));     // Catch: Throwable -> L52
        r122.setFileSize(r112.getLong(r109));     // Catch: Throwable -> L52
        r122.setWidth(r112.getInt(r113));     // Catch: Throwable -> L52
        r122.setHeight(r112.getInt(r114));     // Catch: Throwable -> L52
        r122.setDateToken(r112.getLong(r115));     // Catch: Throwable -> L52
        r122.setOrientation(r112.getInt(r116));     // Catch: Throwable -> L52
        if (bytedance.util.a.d() == true) goto L35;
        int r126 = r124;
        int r127 = r106;
        int r217 = r107;
        int r218 = r108;
        int r128 = r109;
        int r219 = r123;
        String r129 = r112.getString(r126);     // Catch: Throwable -> L52
        String r130 = File.separator;     // Catch: Throwable -> L52
        r122.setRelativePath(r129.substring(r121, r129.lastIndexOf(r130)) + r130);     // Catch: IndexOutOfBoundsException -> L47 Throwable -> L52
    L48:
        r122.setUri(ContentUris.withAppendedId(r111, r125));     // Catch: Throwable -> L52
        ArrayList r131 = r120;
        r131.add(r122);     // Catch: Throwable -> L52
        r106 = r127;
        r117 = r219;
        r107 = r217;
        r108 = r218;
        r118 = r126;
        r120 = r131;
        r109 = r128;
        r104 = r215;
        r105 = r216;
        goto L29
    L47:
        r122.setRelativePath("");     // Catch: Throwable -> L52
        goto L48
    L35:
        String r132 = r112.getString(r123);     // Catch: Throwable -> L52
        if (r132 != null) goto L42;
        r219 = r123;
        r126 = r124;
        r127 = r106;
        String r133 = r112.getString(r126);     // Catch: Throwable -> L52
        r217 = r107;
        String r134 = File.separator;     // Catch: Throwable -> L52
        r218 = r108;
        r128 = r109;
        r132 = r133.substring(r121, r133.lastIndexOf(r134)) + r134;     // Catch: IndexOutOfBoundsException -> L41 Throwable -> L52
    L43:
        r122.setRelativePath(r132);     // Catch: Throwable -> L52
        goto L48
    L41:
        r122.setRelativePath("");     // Catch: Throwable -> L52
        goto L43
    L42:
        r219 = r123;
        r217 = r107;
        r218 = r108;
        r128 = r109;
        r126 = r124;
        r127 = r106;
        goto L43
    L50:
        ArrayList r135 = r120;
        r112.close();
        return r135;
    L27:
        r117 = -1;
        goto L28
    L12:
        if (bytedance.util.a.d() == false) goto L16;
        if (r213 <= 0) goto L15;
        r100 = r100 + (" LIMIT " + r213 + " OFFSET " + r214);     // Catch: Throwable -> L52
    L15:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r111, IMAGE_PROJECTION_HIGH, r210, r211, r100);     // Catch: Throwable -> L52
        goto L9
    L16:
        if (r213 <= 0) goto L18;
        r100 = r100 + (" LIMIT " + r213 + " OFFSET " + r214);     // Catch: Throwable -> L52
    L18:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r110.getContentResolver(), r111, IMAGE_PROJECTION_LOW, r210, r211, r100);     // Catch: Throwable -> L52
        goto L9
    L6:
        r102 = false;
        goto L7
    }

    public static List<BdMediaItem> getMusics(Context r210, String r211, String[] r212, String r213, int r214, int r215) {
        String r100 = r213;
        ArrayList r101 = new ArrayList();
        Uri r110 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor r111 = null;
    L52:
        th = move-exception;
        if (r111 == null) goto L55;
        r111.close();
    L55:
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L12;
        Cursor r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, AUDIO_PROJECTION_HIGH, bytedance.util.a.c(r211, r212, r214, r215, r100), null);     // Catch: Throwable -> L52
    L9:
        r111 = r103;
        if (r111 != null) goto L24;
        if (r111 == null) goto L23;
        r111.close();
    L23:
        return r101;
    L24:
        int r104 = r111.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L52
        int r105 = r111.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L52
        int r106 = r111.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L52
        int r107 = r111.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L52
        int r108 = r111.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L52
        int r109 = r111.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L52
        int r112 = r111.getColumnIndexOrThrow("is_music");     // Catch: Throwable -> L52
        int r113 = r111.getColumnIndexOrThrow("duration");     // Catch: Throwable -> L52
        int r114 = r111.getColumnIndexOrThrow("title");     // Catch: Throwable -> L52
        int r115 = r111.getColumnIndexOrThrow("album");     // Catch: Throwable -> L52
        int r116 = r111.getColumnIndexOrThrow("artist");     // Catch: Throwable -> L52
        int r117 = r111.getColumnIndexOrThrow("album_id");     // Catch: Throwable -> L52
        if (bytedance.util.a.d() == false) goto L27;
        int r118 = r111.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L52
        int r119 = r111.getColumnIndexOrThrow("datetaken");     // Catch: Throwable -> L52
        int r120 = r118;
    L28:
        int r121 = r111.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L52
        int r216 = r119;
        StringBuilder r122 = new StringBuilder();     // Catch: Throwable -> L52
        int r217 = r121;
        r122.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L52
        r122.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L52
        int r123 = r122.toString().length();     // Catch: Throwable -> L52
    L29:
        if (r111.moveToNext() == false) goto L50;
        BdMediaItem r124 = new BdMediaItem();     // Catch: Throwable -> L52
        int r218 = r116;
        int r219 = r117;
        long r125 = r111.getLong(r104);     // Catch: Throwable -> L52
        r124.setId(r125);     // Catch: Throwable -> L52
        int r220 = r104;
        r124.setName(r111.getString(r105));     // Catch: Throwable -> L52
        int r221 = r105;
        r124.setModify(r111.getLong(r106));     // Catch: Throwable -> L52
        r124.setDateAdded(r111.getLong(r107));     // Catch: Throwable -> L52
        r124.setMimeType(r111.getString(r108));     // Catch: Throwable -> L52
        r124.setFileSize(r111.getLong(r109));     // Catch: Throwable -> L52
        r124.setMusicType(r111.getInt(r112));     // Catch: Throwable -> L52
        r124.setDuration(r111.getLong(r113));     // Catch: Throwable -> L52
        r124.setTitle(r111.getString(r114));     // Catch: Throwable -> L52
        r124.setAlbum(r111.getString(r115));     // Catch: Throwable -> L52
        r124.setArtist(r111.getString(r218));     // Catch: Throwable -> L52
        int r222 = r107;
        int r223 = r108;
        r124.setAlbumId(r111.getLong(r219));     // Catch: Throwable -> L52
        if (bytedance.util.a.d() == false) goto L44;
        String r126 = r111.getString(r120);     // Catch: Throwable -> L52
        if (r126 != null) goto L41;
        int r127 = r218;
        int r128 = r217;
        int r224 = r219;
        String r129 = r111.getString(r128);     // Catch: Throwable -> L52
        int r130 = r106;
        String r131 = File.separator;     // Catch: Throwable -> L52
        int r225 = r120;
        String r132 = r129.substring(r123, r129.lastIndexOf(r131)) + r131;     // Catch: IndexOutOfBoundsException -> L40 Throwable -> L52
    L43:
        r124.setRelativePath(r132);     // Catch: Throwable -> L52
        int r133 = r216;
        r124.setDateToken(r111.getLong(r133));     // Catch: Throwable -> L52
    L48:
        Uri r134 = r110;
        r124.setUri(ContentUris.withAppendedId(r134, r125));     // Catch: Throwable -> L52
        ArrayList r135 = r101;
        r135.add(r124);     // Catch: Throwable -> L52
        r117 = r224;
        r107 = r222;
        r108 = r223;
        r217 = r128;
        r216 = r133;
        r110 = r134;
        r101 = r135;
        r116 = r127;
        r106 = r130;
        r120 = r225;
        r104 = r220;
        r105 = r221;
        goto L29
    L40:
        r124.setRelativePath("");     // Catch: Throwable -> L52
    L42:
        r132 = r126;
        goto L43
    L41:
        r127 = r218;
        r130 = r106;
        r225 = r120;
        r128 = r217;
        r224 = r219;
        goto L42
    L44:
        r127 = r218;
        r130 = r106;
        r225 = r120;
        r128 = r217;
        r224 = r219;
        r133 = r216;
        String r136 = r111.getString(r128);     // Catch: Throwable -> L52
        String r137 = File.separator;     // Catch: Throwable -> L52
        r124.setRelativePath(r136.substring(r123, r136.lastIndexOf(r137)) + r137);     // Catch: IndexOutOfBoundsException -> L47 Throwable -> L52
    L47:
        r124.setRelativePath("");     // Catch: Throwable -> L52
        goto L48
    L50:
        ArrayList r138 = r101;
        r111.close();
        return r138;
    L27:
        r119 = -1;
        r120 = -1;
        goto L28
    L12:
        if (bytedance.util.a.d() == false) goto L16;
        if (r214 <= 0) goto L15;
        r100 = r100 + (" LIMIT " + r214 + " OFFSET " + r215);     // Catch: Throwable -> L52
    L15:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, AUDIO_PROJECTION_HIGH, r211, r212, r100);     // Catch: Throwable -> L52
        goto L9
    L16:
        if (r214 <= 0) goto L18;
        r100 = r100 + (" LIMIT " + r214 + " OFFSET " + r215);     // Catch: Throwable -> L52
    L18:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, AUDIO_PROJECTION_LOW, r211, r212, r100);     // Catch: Throwable -> L52
        goto L9
    L6:
        r102 = false;
        goto L7
    }

    public static List<BdMediaItem> getVideos(Context r100, String r101, String[] r102, String r110, int r111, int r112) {
        return getVideos(r100, r101, r102, r110, r111, r112, false);
    }

    public static List<BdMediaItem> getVideos(Context r210, String r211, String[] r212, String r213, int r214, int r215, boolean r310) {
        String r100 = r213;
        ArrayList r101 = new ArrayList();
        Uri r110 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor r111 = null;
    L58:
        th = move-exception;
        if (r111 == null) goto L61;
        r111.close();
    L61:
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 30) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L12;
        Cursor r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, VIDEO_PROJECTION_HIGH, bytedance.util.a.c(r211, r212, r214, r215, r100), null);     // Catch: Throwable -> L58
    L9:
        r111 = r103;
        if (r111 != null) goto L24;
        if (r111 == null) goto L23;
        r111.close();
    L23:
        return r101;
    L24:
        int r104 = r111.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L58
        int r105 = r111.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L58
        int r106 = r111.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L58
        int r107 = r111.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L58
        int r108 = r111.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L58
        int r109 = r111.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L58
        int r112 = r111.getColumnIndexOrThrow("width");     // Catch: Throwable -> L58
        int r113 = r111.getColumnIndexOrThrow("height");     // Catch: Throwable -> L58
        int r114 = r111.getColumnIndexOrThrow("duration");     // Catch: Throwable -> L58
        int r115 = r111.getColumnIndexOrThrow("datetaken");     // Catch: Throwable -> L58
        int r116 = r111.getColumnIndexOrThrow("resolution");     // Catch: Throwable -> L58
        if (bytedance.util.a.d() == false) goto L27;
        int r117 = r111.getColumnIndexOrThrow(LynxEventReporter.PROP_NAME_RELATIVE_PATH);     // Catch: Throwable -> L58
        int r118 = r111.getColumnIndexOrThrow("orientation");     // Catch: Throwable -> L58
    L28:
        int r119 = r111.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L58
        Uri r120 = r110;
        StringBuilder r121 = new StringBuilder();     // Catch: Throwable -> L58
        int r216 = r119;
        r121.append(Environment.getExternalStorageDirectory().getPath());     // Catch: Throwable -> L58
        r121.append(HTTP.URL_DEFAULT);     // Catch: Throwable -> L58
        int r122 = r121.toString().length();     // Catch: Throwable -> L58
    L29:
        if (r111.moveToNext() == false) goto L56;
        BdMediaItem r123 = new BdMediaItem();     // Catch: Throwable -> L58
        int r124 = r117;
        int r217 = r118;
        long r125 = r111.getLong(r104);     // Catch: Throwable -> L58
        r123.setId(r125);     // Catch: Throwable -> L58
        int r218 = r104;
        int r126 = r111.getInt(r112);     // Catch: Throwable -> L58
        int r219 = r112;
        int r127 = r111.getInt(r113);     // Catch: Throwable -> L58
        int r220 = r113;
        r123.setName(r111.getString(r105));     // Catch: Throwable -> L58
        r123.setModify(r111.getLong(r106));     // Catch: Throwable -> L58
        r123.setDateAdded(r111.getLong(r107));     // Catch: Throwable -> L58
        r123.setMimeType(r111.getString(r108));     // Catch: Throwable -> L58
        r123.setFileSize(r111.getLong(r109));     // Catch: Throwable -> L58
        r123.setWidth(r126);     // Catch: Throwable -> L58
        r123.setHeight(r127);     // Catch: Throwable -> L58
        r123.setDuration(r111.getLong(r114));     // Catch: Throwable -> L58
        r123.setDateToken(r111.getLong(r115));     // Catch: Throwable -> L58
        r123.setResolution(r111.getString(r116));     // Catch: Throwable -> L58
        if (bytedance.util.a.d() == true) goto L35;
        int r221 = r105;
        int r222 = r108;
        int r223 = r109;
        int r224 = r124;
        int r128 = r216;
        int r129 = r217;
        int r225 = r106;
        int r226 = r107;
        String r130 = r111.getString(r128);     // Catch: Throwable -> L58
        String r131 = File.separator;     // Catch: Throwable -> L58
        r123.setRelativePath(r130.substring(r122, r130.lastIndexOf(r131)) + r131);     // Catch: IndexOutOfBoundsException -> L53 Throwable -> L58
    L54:
        Uri r132 = r120;
        r123.setUri(ContentUris.withAppendedId(r132, r125));     // Catch: Throwable -> L58
        ArrayList r133 = r101;
        r133.add(r123);     // Catch: Throwable -> L58
        r107 = r226;
        r112 = r219;
        r113 = r220;
        r120 = r132;
        r216 = r128;
        r101 = r133;
        r118 = r129;
        r108 = r222;
        r109 = r223;
        r117 = r224;
        r106 = r225;
        r104 = r218;
        r105 = r221;
        goto L29
    L53:
        r123.setRelativePath("");     // Catch: Throwable -> L58
        goto L54
    L35:
        String r134 = r111.getString(r124);     // Catch: Throwable -> L58
        r221 = r105;
        r225 = r106;
        int r135 = r111.getInt(r217);     // Catch: Throwable -> L58
        if (r134 != null) goto L42;
        r129 = r217;
        r128 = r216;
        r226 = r107;
        String r136 = r111.getString(r128);     // Catch: Throwable -> L58
        r222 = r108;
        String r137 = File.separator;     // Catch: Throwable -> L58
        r223 = r109;
        r224 = r124;
        r134 = r136.substring(r122, r136.lastIndexOf(r137)) + r137;     // Catch: IndexOutOfBoundsException -> L41 Throwable -> L58
    L43:
        r123.setRelativePath(r134);     // Catch: Throwable -> L58
        r123.setOrientation(r135);     // Catch: Throwable -> L58
        if (r310 == false) goto L54;
        if (r135 != 90) goto L48;
    L49:
        r123.setWidth(r127);     // Catch: Throwable -> L58
        r123.setHeight(r126);     // Catch: Throwable -> L58
        goto L54
    L48:
        if (r135 != 270) goto L54;
    L41:
        r123.setRelativePath("");     // Catch: Throwable -> L58
        goto L43
    L42:
        r129 = r217;
        r222 = r108;
        r223 = r109;
        r224 = r124;
        r128 = r216;
        r226 = r107;
        goto L43
    L56:
        ArrayList r138 = r101;
        r111.close();
        return r138;
    L27:
        r117 = -1;
        r118 = -1;
        goto L28
    L12:
        if (bytedance.util.a.d() == false) goto L16;
        if (r214 <= 0) goto L15;
        r100 = r100 + (" LIMIT " + r214 + " OFFSET " + r215);     // Catch: Throwable -> L58
    L15:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, VIDEO_PROJECTION_HIGH, r211, r212, r100);     // Catch: Throwable -> L58
        goto L9
    L16:
        if (r214 <= 0) goto L18;
        r100 = r100 + (" LIMIT " + r214 + " OFFSET " + r215);     // Catch: Throwable -> L58
    L18:
        r103 = bytedance_io_BdMediaFileSystem_android_content_ContentResolver_query(r210.getContentResolver(), r110, VIDEO_PROJECTION_LOW, r211, r212, r100);     // Catch: Throwable -> L58
        goto L9
    L6:
        r102 = false;
        goto L7
    }
}
