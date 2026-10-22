package com.ss.android.socialbase.downloader.file;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadFileUtils {
    private static SparseArray<MediaItem> MEDIA_STORE_DATA = null;
    public static final String MODE_READ = "r";
    public static final String MODE_WRITE = "w";
    private static final String TAG = "DownloadFileUtils";

    static class MediaItem {
        public String columnId;
        public Uri contentUri;
        public String contentUriString;

        MediaItem() {
        }

        static MediaItem build(Uri r1, String r2) {
            MediaItem r0 = new MediaItem();
            r0.contentUri = r1;
            r0.contentUriString = r1.toString();
            r0.columnId = r2;
            return r0;
        }
    }

    public DownloadFileUtils() {
    }

    static {
        MEDIA_STORE_DATA = new SparseArray();     // Catch: Throwable -> L9
        if (isAtLeastAndroidQ() == false) goto L7;
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.getContentUri("external_primary"), "_id"));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(5, MediaItem.build(MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        MEDIA_STORE_DATA.put(2, MediaItem.build(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(3, MediaItem.build(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
        MEDIA_STORE_DATA.put(4, MediaItem.build(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_id"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();
    }

    public static boolean isMediaUri(String r1) {
        if (getTypeByUri(r1) > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static String getContentUriString(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        if (r4.startsWith("content") == false) goto L18;
        int r0 = 0;
    L8:
        if (r0 >= MEDIA_STORE_DATA.size()) goto L19;
        int r1 = MEDIA_STORE_DATA.keyAt(r0);
        MediaItem r2 = (MediaItem) ZeusTransformUtils.preCheckCast(MEDIA_STORE_DATA.get(r1), MediaItem.class, "com.obric.aiagent.plugin");
        if (r4.startsWith(r2.contentUriString) == true) goto L12;
        r0 = r0 + 1;
        goto L8
    L12:
        return r2.contentUriString;
    L19:
        return null;
    L18:
        return null;
    }

    public static int getTypeByUri(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return -1;
    L6:
        if (r6.startsWith("content") == false) goto L15;
        int r0 = 0;
    L9:
        if (r0 >= MEDIA_STORE_DATA.size()) goto L14;
        int r2 = MEDIA_STORE_DATA.keyAt(r0);
        if (r6.startsWith(((MediaItem) ZeusTransformUtils.preCheckCast(MEDIA_STORE_DATA.get(r2), MediaItem.class, "com.obric.aiagent.plugin")).contentUriString) == true) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r2;
    L14:
        return -1;
    L15:
        return 1;
    }

    public static void checkUri(Uri r10, int r11) {
        MediaItem r0 = (MediaItem) ZeusTransformUtils.preCheckCast(MEDIA_STORE_DATA.get(r11), MediaItem.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L21;
        String r6 = r0.columnId + " = ?";
        String[] r7 = {r10.getLastPathSegment()};
        Cursor r12 = null;
        Uri r3 = r0.contentUri;     // Catch: Throwable -> L17
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Uri r4 = MediaStore.setIncludePending(r0.contentUri);     // Catch: Throwable -> L17
    L9:
        r12 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r4, null, r6, r7, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r12 == null) goto L16;
        if (r12.moveToFirst() == false) goto L16;
        DownloadUtils.safeClose(new Cursor[]{r12});
        return;
    L16:
        throw new Throwable("Fail to check Uri with cursor.");     // Catch: Throwable -> L17
    L8:
        r4 = r3;
    L17:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r12});
        throw th;
    L21:
        throw new Throwable("Fail to check Uri, type error :" + r11);
    }

    public static void deleteUri(Uri r3) {
        ZeusProviderTransform.delete(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), r3, null, null, "com.obric.aiagent.plugin");
    }

    public static ParcelFileDescriptor getParcelFileDescriptor(Uri r3, String r4) {
        if (r3 == null) goto L13;
        ParcelFileDescriptor r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver().openFileDescriptor(r3, r4);     // Catch: Exception -> L9
        if (r5 == null) goto L8;
        return r5;
    L8:
        throw new IOException("Fail to get ParcelFileDescriptor, fileDescriptor is null");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        throw new IOException("Fail to get ParcelFileDescriptor", e);
    L13:
        throw new IOException("Fail to get ParcelFileDescriptor, uri is null");
    }

    public static FileDescriptor getFileDescriptor(Uri r0, String r1) {
        ParcelFileDescriptor r2 = getParcelFileDescriptor(r0, r1);
        if (r2 == null) goto L7;
        return r2.getFileDescriptor();
    L7:
        throw new IOException("Fail to get FileDescriptor, ParcelFileDescriptor is null");
    }

    public static long getLength(Uri r5) {
        ParcelFileDescriptor r2 = null;
        r2 = getParcelFileDescriptor(r5, MODE_READ);     // Catch: Throwable -> L6
        long r3 = r2.getStatSize();     // Catch: Throwable -> L6
        DownloadUtils.safeClose(new Closeable[]{r2});
        return r3;
    L6:
        DownloadUtils.safeClose(new Closeable[]{r2});
        return -1;
    }

    public static boolean exists(Uri r4) {
        if (getLength(r4) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean emptyFile(FileOutputStream r2) {
        r2.write(new byte[0]);     // Catch: Throwable -> L6
        r2.close();     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static boolean existsAndNotEmpty(DownloadFile r4) {
        if (r4.exists() == true) goto L5;
    L7:
        return false;
    L5:
        if (r4.length() <= 0) goto L7;
        return true;
    }

    public static boolean isAtLeastAndroidQ() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static Uri getUriAtLeastQ(Uri r1, String r2, String r3, String r4) {
        Uri r0 = queryUriAtLeastQ(r1, r2, r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createUriAtLeastQ(r1, r2, r3, r4);
    }

    public static Uri queryUriAtLeastQ(Uri r12, String r13, String r14, String r15) {
        Cursor r2 = null;
        if (r12 != null) goto L5;
    L41:
        return null;
    L5:
        if (TextUtils.isEmpty(r13) == true) goto L41;
        if (TextUtils.isEmpty(r14) == true) goto L41;
        if (r13.startsWith("/") == false) goto L13;
        r13 = r13.substring(1);
    L13:
        if (r13.endsWith("/") == true) goto L42;
        r13 = r13 + "/";
    L42:
        StringBuilder r4 = new StringBuilder().append("relative_path = ? AND _display_name = ?");     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r15) == false) goto L19;
        String r6 = "";
    L20:
        String r5 = r4.append(r6).toString();     // Catch: Throwable -> L38
        if (TextUtils.isEmpty(r15) == false) goto L23;
        String[] r16 = {r13, r14};     // Catch: Throwable -> L38
    L24:
        Bundle r9 = new Bundle();     // Catch: Throwable -> L38
        r9.putString("android:query-arg-sql-selection", r5);     // Catch: Throwable -> L38
        r9.putStringArray("android:query-arg-sql-selection-args", r16);     // Catch: Throwable -> L38
        r9.putString("android:query-arg-sql-sort-order", "_id DESC");     // Catch: Throwable -> L38
        if (Build.VERSION.SDK_INT <= 30) goto L27;
        r9.putInt("android:query-arg-match-pending", 1);     // Catch: Throwable -> L38
    L27:
        Cursor r17 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), MediaStore.setIncludePending(r12), new String[]{"_id"}, r9, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        if (r17 != null) goto L44;
    L36:
        DownloadUtils.safeClose(new Cursor[]{r17});
        return null;
    L44:
    L34:
        th = th;
        r2 = r17;
    L39:
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L30:
        if (r17.moveToFirst() == false) goto L36;
        Uri r18 = ContentUris.withAppendedId(r12, r17.getLong(r17.getColumnIndexOrThrow("_id")));     // Catch: Throwable -> L34
        DownloadUtils.safeClose(new Cursor[]{r17});
        return r18;
    L23:
        r16 = new String[]{r13, r14, r15};     // Catch: Throwable -> L38
        goto L24
    L19:
        r6 = " AND mime_type = ?";
    L38:
        th = th;
        goto L39
    }

    public static Uri createUriAtLeastQ(Uri r3, String r4, String r5, String r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return ZeusProviderTransform.insert(r0.getContentResolver(), r3, createContentValues(r4, r5, r6), "com.obric.aiagent.plugin");
    }

    public static ContentValues createContentValues(String r2, String r3, String r4) {
        ContentValues r0 = new ContentValues();
        r0.put("relative_path", r2);
        r0.put("_display_name", r3);
        r0.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r0.put("mime_type", r4);
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String getFilePathFromUri(Uri r12) {
        String[] r1 = {"_data"};
        String r9 = null;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r0 != null) goto L7;
        DownloadUtils.safeClose(new Cursor[]{null});
        return null;
    L7:
        Cursor r13 = ZeusProviderTransform.query(r0.getContentResolver(), r12, r1, null, null, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r13 != null) goto L22;
    L15:
        DownloadUtils.safeClose(new Cursor[]{r13});
        return r9;
    L22:
    L13:
        th = th;
        r9 = r13;
    L18:
        DownloadUtils.safeClose(new Cursor[]{r9});
        throw th;
    L10:
        if (r13.moveToFirst() == false) goto L15;
        r9 = r13.getString(r13.getColumnIndex(r1[0]));     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    }

    public static Uri getUriFromFilePath(String r15) {
        Uri r1 = DownloadDirUtils.getRootContentUri();
        Cursor r2 = null;
    L19:
        th = th;
    L20:
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L8;
        Cursor r16 = ZeusProviderTransform.query(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver(), MediaStore.setIncludePending(r1), new String[]{"_id"}, "_data=? ", new String[]{r15}, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
    L9:
        if (r16 != null) goto L24;
    L17:
        DownloadUtils.safeClose(new Cursor[]{r16});
        return null;
    L24:
    L15:
        th = move-exception;
        r2 = r16;
        th = th;
        goto L20
    L11:
        if (r16.moveToFirst() == false) goto L17;
        Uri r0 = ContentUris.withAppendedId(r1, r16.getInt(r16.getColumnIndex("_id")));     // Catch: Throwable -> L15
        DownloadUtils.safeClose(new Cursor[]{r16});
        return r0;
    L8:
        r16 = null;
        goto L9
    }

    public static Pair<String, String> getParentAndNameFromUri(Uri r0) {
        return getParentAndNameFromRelativePath(getFilePathFromUri(r0));
    }

    public static Pair<String, String> getParentAndNameFromRelativePath(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        File r0 = new File(r2);
        return new Pair(r0.getParent(), r0.getName());
    L6:
        return null;
    }

    public static boolean isScopedStorage() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        int r1 = r0.getApplicationInfo().targetSdkVersion;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT:" + Build.VERSION.SDK_INT + " targetSdkVersion:" + r1);
    L12:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT < Android Q");
    L16:
        return false;
    L18:
        if (r1 == 29) goto L20;
    L25:
        if (r1 <= 29) goto L31;
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT > Android Q");
    L29:
        return true;
    L31:
        if (Logger.debug() == false) goto L33;
        Logger.globalDebug(TAG, "isScopedStorage", "ScopedStorage = False");
    L33:
        return false;
    L20:
        if (DownloadDirUtils.isExternalStorageLegacy(false) == true) goto L25;
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "isScopedStorage", "SDK_INT = Android Q and isExternalStorageLegacy");
    L24:
        return true;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "isScopedStorage", "Context is null");
    L7:
        return false;
    }

    public static boolean checkUriInsert(String r1) {
        checkUri(Uri.parse(r1), getTypeByUri(r1));     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public static boolean isFilePathInExternalPublicDir(String r6) {
        if (isMediaUri(r6) == false) goto L5;
        return true;
    L5:
        File r2 = DownloadDirUtils.getExternalStorageDirectory(false);
        if (r2 != null) goto L8;
    L31:
        return false;
    L8:
        if (r6.startsWith(r2.getPath()) == false) goto L31;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L13;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "Context is null");
        return false;
    L13:
        File r5 = DownloadDirUtils.getExternalCacheDir(r3, false);
        if (r5 != null) goto L17;
        Logger.globalError(TAG, "isFilePathInExternalPublicDir", "ExternalCacheDir is null");
        return false;
    L17:
        String r4 = r5.getParent();
        if (r4 != null) goto L20;
    L22:
        File r7 = DownloadDirUtils.getObbDirStr(r3, false);
        if (r7 == null) goto L28;
        if (r6.startsWith(r7.getAbsolutePath()) == false) goto L28;
        return false;
    L28:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.UNCHECK_EXTERNAL_PUBLIC_DIR, 0) <= 0) goto L30;
        return false;
    L30:
        return true;
    L20:
        if (r6.startsWith(r4) == false) goto L22;
        return false;
    }
}
