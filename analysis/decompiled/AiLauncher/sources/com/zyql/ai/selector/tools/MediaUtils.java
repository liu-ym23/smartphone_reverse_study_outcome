package com.zyql.ai.selector.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import com.zyql.ai.selector.PictureContentResolver;
import com.zyql.ai.selector.app.PictureAppMaster;
import com.zyql.ai.selector.config.PictureConfig;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.entity.MediaExtraInfo;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class MediaUtils {
    public static Uri createAudioUri(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("AUD_"));
        contentValues.put("datetaken", string);
        if (TextUtils.isEmpty(str) || str.startsWith("image") || str.startsWith("video")) {
            str = PictureMimeType.MIME_TYPE_AUDIO_AMR;
        }
        contentValues.put("mime_type", str);
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        contentValues.put("datetaken", string);
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", PictureMimeType.DCIM);
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static Bundle createQueryArgsBundle(String str, String[] strArr, int i10, int i11) {
        Bundle bundle = new Bundle();
        bundle.putString("android:query-arg-sql-selection", str);
        bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
        bundle.putString("android:query-arg-sql-limit", i10 + " offset " + i11);
        return bundle;
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String string = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        contentValues.put("datetaken", string);
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (externalStorageState.equals("mounted")) {
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static void deleteCamera(Context context, String str) {
        if (!TextUtils.isEmpty(str) && SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(str)) {
            context.getContentResolver().delete(Uri.parse(str), null, null);
        }
    }

    public static String getAudioFilePathFromUri(Context context, Uri uri) {
        String string = "";
        try {
            Cursor cursorQuery = context.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    cursorQuery.moveToFirst();
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return string;
        } catch (Exception e10) {
            e10.printStackTrace();
            return string;
        }
    }

    public static MediaExtraInfo getAudioSize(Context context, String str) throws IOException {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (PictureMimeType.isContent(str)) {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                try {
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                } catch (IOException e12) {
                    throw new RuntimeException(e12);
                }
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                throw th;
            } catch (IOException e13) {
                throw new RuntimeException(e13);
            }
        }
    }

    public static long getCameraFirstBucketId(Context context) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {PictureFileUtils.getDCIMCameraPath() + "%"};
                if (SdkVersionUtils.checkedAndroid_R()) {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, createQueryArgsBundle("_data like ?", strArr, 1, 0), null);
                } else {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                }
                cursor = cursorQuery;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (cursor == null) {
                    return -1L;
                }
            }
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                long j10 = cursor.getLong(cursor.getColumnIndex(PictureConfig.EXTRA_BUCKET_ID));
                cursor.close();
                return j10;
            }
            if (cursor == null) {
                return -1L;
            }
            cursor.close();
            return -1L;
        } finally {
        }
    }

    public static int getDCIMLastImageId(Context context) {
        Cursor cursorQuery = null;
        try {
            try {
                String[] strArr = {PictureFileUtils.getDCIMCameraPath() + "%"};
                cursorQuery = SdkVersionUtils.checkedAndroid_R() ? context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, createQueryArgsBundle("_data like ?", strArr, 1, 0), null) : context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                if (cursorQuery == null || cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return -1;
                }
                int i10 = DateUtils.dateDiffer(cursorQuery.getLong(cursorQuery.getColumnIndex("date_added"))) <= 1 ? cursorQuery.getInt(cursorQuery.getColumnIndex(StepOSRecipientEmailHistory._ID)) : -1;
                cursorQuery.close();
                return i10;
            } catch (Exception e10) {
                e10.printStackTrace();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return -1;
            }
        } finally {
        }
    }

    public static MediaExtraInfo getImageSize(Context context, String str) {
        ExifInterface exifInterface;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream contentResolverOpenInputStream = null;
        try {
            try {
                if (PictureMimeType.isContent(str)) {
                    contentResolverOpenInputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                    exifInterface = new ExifInterface(contentResolverOpenInputStream);
                } else {
                    exifInterface = new ExifInterface(str);
                }
                mediaExtraInfo.setWidth(exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 1));
                mediaExtraInfo.setHeight(exifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 1));
                PictureFileUtils.close(contentResolverOpenInputStream);
                return mediaExtraInfo;
            } catch (Exception e10) {
                e10.printStackTrace();
                PictureFileUtils.close(contentResolverOpenInputStream);
                return mediaExtraInfo;
            }
        } catch (Throwable th) {
            PictureFileUtils.close(contentResolverOpenInputStream);
            throw th;
        }
    }

    public static MediaExtraInfo getVideoSize(Context context, String str) {
        int i10;
        int i11;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (PictureMimeType.isContent(str)) {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (TextUtils.equals("90", strExtractMetadata) || TextUtils.equals("270", strExtractMetadata)) {
                    i10 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                } else {
                    i11 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i10 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                }
                mediaExtraInfo.setWidth(i11);
                mediaExtraInfo.setHeight(i10);
                mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                try {
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                } catch (IOException e12) {
                    throw new RuntimeException(e12);
                }
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                throw th;
            } catch (IOException e13) {
                throw new RuntimeException(e13);
            }
        }
    }

    public static boolean isLongImg(int i10, int i11) {
        return i10 > 0 && i11 > 0 && i11 > i10 * 3;
    }

    public static void removeMedia(Context context, int i10) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(i10)});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean isLongImg(LocalMedia localMedia) {
        int width = localMedia.getWidth();
        int height = localMedia.getHeight();
        return width > 0 && height > 0 && height > width * 3;
    }

    public static MediaExtraInfo getImageSize(String str) throws Throwable {
        BitmapFactory.Options options;
        InputStream fileInputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream inputStream = null;
        try {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (PictureMimeType.isContent(str)) {
                    fileInputStream = PictureContentResolver.getContentResolverOpenInputStream(PictureAppMaster.getInstance().getAppContext(), Uri.parse(str));
                } else {
                    fileInputStream = new FileInputStream(str);
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            BitmapFactory.decodeStream(fileInputStream, null, options);
            mediaExtraInfo.setWidth(options.outWidth);
            mediaExtraInfo.setHeight(options.outHeight);
            PictureFileUtils.close(fileInputStream);
            return mediaExtraInfo;
        } catch (Exception e11) {
            inputStream = fileInputStream;
            e = e11;
            e.printStackTrace();
            PictureFileUtils.close(inputStream);
            return mediaExtraInfo;
        } catch (Throwable th2) {
            inputStream = fileInputStream;
            th = th2;
            PictureFileUtils.close(inputStream);
            throw th;
        }
    }
}
