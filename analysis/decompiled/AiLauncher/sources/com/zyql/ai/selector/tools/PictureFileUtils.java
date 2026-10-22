package com.zyql.ai.selector.tools;

import Mb.I;
import Mb.InterfaceC0967e;
import Mb.InterfaceC0968f;
import Mb.u;
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.b;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import com.zyql.ai.selector.config.PictureMimeType;
import io.ktor.sse.ServerSentEventKt;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PictureFileUtils {
    public static final String POSTFIX = ".jpeg";
    public static final String POST_AUDIO = ".amr";
    public static final String POST_VIDEO = ".mp4";
    static final String TAG = "PictureFileUtils";

    private PictureFileUtils() {
    }

    public static boolean bufferCopy(InterfaceC0968f interfaceC0968f, File file) {
        InterfaceC0967e interfaceC0967eB = null;
        try {
            try {
                interfaceC0967eB = u.b(u.f(file));
                interfaceC0967eB.V0(interfaceC0968f);
                interfaceC0967eB.flush();
                close(interfaceC0968f);
                close(interfaceC0967eB);
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                close(interfaceC0968f);
                close(interfaceC0967eB);
                return false;
            }
        } catch (Throwable th) {
            close(interfaceC0968f);
            close(interfaceC0967eB);
            throw th;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void copyFile(String str, String str2) throws Throwable {
        Throwable th;
        FileChannel channel;
        Exception exc;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel fileChannel = null;
        try {
            FileChannel channel2 = new FileInputStream(new File(str)).getChannel();
            try {
                channel = new FileOutputStream(new File(str2)).getChannel();
            } catch (Exception e10) {
                exc = e10;
                channel = null;
            } catch (Throwable th2) {
                th = th2;
                channel = null;
            }
            try {
                channel2.transferTo(0L, channel2.size(), channel);
                close(channel2);
            } catch (Exception e11) {
                exc = e11;
                fileChannel = channel2;
                try {
                    exc.printStackTrace();
                    close(fileChannel);
                    close(channel);
                } catch (Throwable th3) {
                    th = th3;
                    close(fileChannel);
                    close(channel);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = channel2;
                close(fileChannel);
                close(channel);
                throw th;
            }
        } catch (Exception e12) {
            exc = e12;
            channel = null;
        } catch (Throwable th5) {
            th = th5;
            channel = null;
        }
        close(channel);
    }

    public static File createCameraFile(Context context, int i10, String str, String str2, String str3) {
        return createMediaFile(context, i10, str, str2, str3);
    }

    public static String createFilePath(Context context, String str, String str2, String str3) {
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(str2);
        if (PictureMimeType.isHasVideo(str2)) {
            String str4 = getVideoDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("VID_") + lastImgSuffix;
                }
                return str4 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "VID_" + str.toUpperCase() + lastImgSuffix;
            }
            return str4 + str3;
        }
        if (PictureMimeType.isHasAudio(str2)) {
            String str5 = getAudioDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("AUD_") + lastImgSuffix;
                }
                return str5 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AUD_" + str.toUpperCase() + lastImgSuffix;
            }
            return str5 + str3;
        }
        String str6 = getDiskCacheDir(context) + File.separator;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = DateUtils.getCreateFileName("IMG_") + lastImgSuffix;
            }
            return str6 + str3;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "IMG_" + str.toUpperCase() + lastImgSuffix;
        }
        return str6 + str3;
    }

    private static File createMediaFile(Context context, int i10, String str, String str2, String str3) {
        return createOutFile(context, i10, str, str2, str3);
    }

    private static File createOutFile(Context context, int i10, String str, String str2, String str3) {
        File file;
        File rootDirFile;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                rootDirFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(rootDirFile.getAbsolutePath());
                String str4 = File.separator;
                sb2.append(str4);
                sb2.append(PictureMimeType.CAMERA);
                sb2.append(str4);
                file = new File(sb2.toString());
            } else {
                rootDirFile = getRootDirFile(applicationContext, i10);
                file = new File(rootDirFile.getAbsolutePath() + File.separator);
            }
            if (!rootDirFile.exists()) {
                rootDirFile.mkdirs();
            }
        } else {
            File file2 = new File(str3);
            File parentFile = file2.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                file2.getParentFile().mkdirs();
            }
            file = file2;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (i10 == 2) {
            if (zIsEmpty) {
                str = DateUtils.getCreateFileName("VID_") + ".mp4";
            }
            return new File(file, str);
        }
        if (i10 == 3) {
            if (zIsEmpty) {
                str = DateUtils.getCreateFileName("AUD_") + POST_AUDIO;
            }
            return new File(file, str);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ".jpeg";
        }
        if (zIsEmpty) {
            str = DateUtils.getCreateFileName("IMG_") + str2;
        }
        return new File(file, str);
    }

    @Deprecated
    public static void deleteAllCacheDirFile(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null && (fileArrListFiles3 = externalFilesDir.listFiles()) != null) {
            for (File file : fileArrListFiles3) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 != null && (fileArrListFiles2 = externalFilesDir2.listFiles()) != null) {
            for (File file2 : fileArrListFiles2) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 == null || (fileArrListFiles = externalFilesDir3.listFiles()) == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isFile()) {
                file3.delete();
            }
        }
    }

    @Deprecated
    public static void deleteCacheDirFile(Context context, int i10) {
        File[] fileArrListFiles;
        File externalFilesDir = context.getExternalFilesDir(i10 == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    public static String getAudioDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    public static String getDCIMCameraPath() {
        try {
            return "%" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            } catch (IllegalArgumentException e10) {
                Log.i(TAG, String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", e10.getMessage()));
                if (cursorQuery == null) {
                    return "";
                }
            }
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                cursorQuery.close();
                return string;
            }
            if (cursorQuery == null) {
                return "";
            }
            cursorQuery.close();
            return "";
        } finally {
        }
    }

    public static String getDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    @SuppressLint({"NewApi"})
    public static String getPath(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!DocumentsContract.isDocumentUri(applicationContext, uri)) {
            return SkillStoreKt.SKILL_DOC_TYPE_CONTENT.equalsIgnoreCase(uri.getScheme()) ? isGooglePhotosUri(uri) ? uri.getLastPathSegment() : getDataColumn(applicationContext, uri, null, null) : Const.STR_FILE.equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : "";
        }
        if (!isExternalStorageDocument(uri)) {
            if (isDownloadsDocument(uri)) {
                return getDataColumn(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ValueOf.toLong(DocumentsContract.getDocumentId(uri))), null, null);
            }
            if (!isMediaDocument(uri)) {
                return "";
            }
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(ServerSentEventKt.COLON);
            String str = strArrSplit[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(applicationContext, uri2, "_id=?", new String[]{strArrSplit[1]});
        }
        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(ServerSentEventKt.COLON);
        if (!"primary".equalsIgnoreCase(strArrSplit2[0])) {
            return "";
        }
        if (SdkVersionUtils.checkedAndroid_Q()) {
            return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + strArrSplit2[1];
        }
        return Environment.getExternalStorageDirectory() + "/" + strArrSplit2[1];
    }

    private static File getRootDirFile(Context context, int i10) {
        return i10 != 2 ? i10 != 3 ? context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) : context.getExternalFilesDir(Environment.DIRECTORY_MUSIC) : context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
    }

    public static String getVideoDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        return externalFilesDir == null ? "" : externalFilesDir.getPath();
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isFileExists(String str) {
        return TextUtils.isEmpty(str) || new File(str).exists();
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri parUri(Context context, File file) {
        return b.getUriForFile(context, context.getPackageName() + ".luckProvider", file);
    }

    public static String rename(String str) {
        return str.substring(0, str.lastIndexOf(".")) + "_" + DateUtils.getCreateFileName() + str.substring(str.lastIndexOf("."));
    }

    public static boolean copyFile(FileInputStream fileInputStream, String str) throws Throwable {
        Throwable th;
        FileChannel channel;
        if (fileInputStream == null) {
            return false;
        }
        FileChannel fileChannel = null;
        try {
            FileChannel channel2 = fileInputStream.getChannel();
            try {
                channel = new FileOutputStream(new File(str)).getChannel();
                try {
                    channel2.transferTo(0L, channel2.size(), channel);
                    close(fileInputStream);
                    close(channel2);
                    close(channel);
                    return true;
                } catch (Exception unused) {
                    fileChannel = channel2;
                    close(fileInputStream);
                    close(fileChannel);
                    close(channel);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel2;
                    close(fileInputStream);
                    close(fileChannel);
                    close(channel);
                    throw th;
                }
            } catch (Exception unused2) {
                channel = null;
            } catch (Throwable th3) {
                th = th3;
                channel = null;
            }
        } catch (Exception unused3) {
            channel = null;
        } catch (Throwable th4) {
            th = th4;
            channel = null;
        }
    }

    public static boolean bufferCopy(InterfaceC0968f interfaceC0968f, OutputStream outputStream) {
        InterfaceC0967e interfaceC0967eB = null;
        try {
            try {
                interfaceC0967eB = u.b(u.h(outputStream));
                interfaceC0967eB.V0(interfaceC0968f);
                interfaceC0967eB.flush();
                close(interfaceC0968f);
                close(interfaceC0967eB);
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
                close(interfaceC0968f);
                close(interfaceC0967eB);
                return false;
            }
        } catch (Throwable th) {
            close(interfaceC0968f);
            close(interfaceC0967eB);
            throw th;
        }
    }

    public static boolean bufferCopy(File file, OutputStream outputStream) throws Throwable {
        InterfaceC0967e interfaceC0967e;
        I iC;
        InterfaceC0967e interfaceC0967eB = null;
        try {
            iC = u.c(u.k(file));
        } catch (Exception e10) {
            e = e10;
            interfaceC0967e = null;
        } catch (Throwable th) {
            th = th;
            interfaceC0967e = null;
        }
        try {
            interfaceC0967eB = u.b(u.h(outputStream));
            interfaceC0967eB.V0(iC);
            interfaceC0967eB.flush();
            close(iC);
            close(outputStream);
            close(interfaceC0967eB);
            return true;
        } catch (Exception e11) {
            e = e11;
            InterfaceC0967e interfaceC0967e2 = interfaceC0967eB;
            interfaceC0967eB = iC;
            interfaceC0967e = interfaceC0967e2;
            try {
                e.printStackTrace();
                close(interfaceC0967eB);
                close(outputStream);
                close(interfaceC0967e);
                return false;
            } catch (Throwable th2) {
                th = th2;
                close(interfaceC0967eB);
                close(outputStream);
                close(interfaceC0967e);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InterfaceC0967e interfaceC0967e3 = interfaceC0967eB;
            interfaceC0967eB = iC;
            interfaceC0967e = interfaceC0967e3;
            close(interfaceC0967eB);
            close(outputStream);
            close(interfaceC0967e);
            throw th;
        }
    }
}
