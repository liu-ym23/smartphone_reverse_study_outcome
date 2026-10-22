package com.android.contacts.util;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.FileUtils;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.google.common.io.Closeables;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class ContactPhotoUtils {
    public static final String FILE_PROVIDER_AUTHORITY = "com.android.contacts.files";
    private static final String PHOTO_DATE_FORMAT = "'IMG'_yyyyMMdd_HHmmss";
    private static final String TAG = "ContactPhotoUtils";

    public ContactPhotoUtils() {
    }

    public static Uri generateTempImageUri(Context r2) {
        return FileProvider.getUriForFile(r2, FILE_PROVIDER_AUTHORITY, new File(pathForTempPhoto(r2, generateTempPhotoFileName())));
    }

    public static Uri generateTempCroppedImageUri(Context r2) {
        return FileProvider.getUriForFile(r2, FILE_PROVIDER_AUTHORITY, new File(pathForTempPhoto(r2, generateTempCroppedPhotoFileName())));
    }

    public static Uri generateTempImageUriForBitmap(Context r5, Bitmap r6) {
        FileOutputStream r0 = null;
        if (r6 != null) goto L42;
        return null;
    L42:
        File r1 = new File(pathForTempPhoto(r5, generateTempPhotoFileName()));     // Catch: Throwable -> L14 Exception -> L16
        FileOutputStream r2 = new FileOutputStream(r1);     // Catch: Throwable -> L14 Exception -> L16
        r6.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: Exception -> L12 Throwable -> L25
        r2.flush();     // Catch: Exception -> L12 Throwable -> L25
        Uri r7 = FileProvider.getUriForFile(r5, FILE_PROVIDER_AUTHORITY, r1);     // Catch: Exception -> L12 Throwable -> L25
        r2.close();     // Catch: IOException -> L9
    L11:
        return r7;
    L9:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = e;
    L18:
        e.printStackTrace();     // Catch: Throwable -> L25
        if (r2 != null) goto L38;
    L24:
        return null;
    L38:
        r2.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L25:
        th = th;
        r0 = r2;
    L27:
        if (r0 != null) goto L40;
    L32:
        throw th;
    L40:
        r0.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    L16:
        e = e;
        r2 = null;
    L14:
        th = th;
        goto L27
    }

    private static String pathForTempPhoto(Context r1, String r2) {
        File r3 = r1.getCacheDir();
        r3.mkdirs();
        return new File(r3, r2).getAbsolutePath();
    }

    private static String generateTempPhotoFileName() {
        Date r0 = new Date(System.currentTimeMillis());
        return "ContactPhoto-" + new SimpleDateFormat(PHOTO_DATE_FORMAT, Locale.US).format(r0) + ".jpg";
    }

    private static String generateTempCroppedPhotoFileName() {
        Date r0 = new Date(System.currentTimeMillis());
        return "ContactPhoto-" + new SimpleDateFormat(PHOTO_DATE_FORMAT, Locale.US).format(r0) + "-cropped.jpg";
    }

    private static int getOrientation(int r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getOrientation flag:" + r2);
        if (r2 != 6) goto L7;
        return 90;
    L7:
        if (r2 != 3) goto L11;
        return 180;
    L11:
        if (r2 != 8) goto L14;
        return 270;
    L14:
        return 0;
    }

    public static Bitmap makeBitmap(byte[] r5) {
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: OutOfMemoryError -> L13
        r1.inJustDecodeBounds = true;     // Catch: OutOfMemoryError -> L13
        BitmapFactory.decodeByteArray(r5, 0, r5.length, r1);     // Catch: OutOfMemoryError -> L13
        if (r1.mCancel == false) goto L6;
    L12:
        return null;
    L6:
        if (r1.outWidth == (-1)) goto L12;
        if (r1.outHeight == (-1)) goto L12;
        r1.inJustDecodeBounds = false;     // Catch: OutOfMemoryError -> L13
        r1.inDither = false;     // Catch: OutOfMemoryError -> L13
        r1.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: OutOfMemoryError -> L13
        return BitmapFactory.decodeByteArray(r5, 0, r5.length, r1);
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Got oom exception ", e);
        return null;
    }

    public static Bitmap getCorrectlyOrientedImage(byte[] r8) {
        int r0 = getOrientation(new ExifInterface(new ByteArrayInputStream(r8)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));     // Catch: IOException -> L4
        Bitmap r1 = makeBitmap(r8);     // Catch: IOException -> L4
        Matrix r6 = new Matrix();     // Catch: IOException -> L4
        r6.postRotate(r0);     // Catch: IOException -> L4
        return Bitmap.createBitmap(r1, 0, 0, r1.getWidth(), r1.getHeight(), r6, true);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getCorrectlyOrientedImage e:" + e);
        return null;
    }

    public static Bitmap getCorrectlyOrientedImage(Context r11, Uri r12) {
        Bitmap r4 = BitmapFactory.decodeStream(r11.getContentResolver().openInputStream(r12), null, null);     // Catch: Throwable -> L5
        int r13 = getExifOrientation(r11, r12);     // Catch: Throwable -> L5
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getCorrectlyOrientedImage orientation:" + r13);     // Catch: Throwable -> L5
        Matrix r9 = new Matrix();     // Catch: Throwable -> L5
        r9.postRotate(r13);     // Catch: Throwable -> L5
        return Bitmap.createBitmap(r4, 0, 0, r4.getWidth(), r4.getHeight(), r9, true);
    L5:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getCorrectlyOrientedImage e:" + th);
        return null;
    }

    private static int getExifOrientation(Context r1, Uri r2) {
        InputStream r3 = r1.getContentResolver().openInputStream(r2);     // Catch: IOException -> L9
        if (r3 == null) goto L6;
        ExifInterface r4 = new ExifInterface(r3);     // Catch: IOException -> L9
        r3.close();     // Catch: IOException -> L9
    L8:
        return getOrientation(r4.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
    L6:
        r4 = null;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getExifOrientation e:" + e);
        return -1;
    }

    public static Bitmap getBitmapFromUri(Context r1, Uri r2) throws FileNotFoundException {
        InputStream r0 = r1.getContentResolver().openInputStream(r2);
        Bitmap r3 = getCorrectlyOrientedImage(r1, r2);     // Catch: Throwable -> L6
        Closeables.closeQuietly(r0);
        return r3;
    L6:
        th = move-exception;
        Closeables.closeQuietly(r0);
        throw th;
    }

    public static byte[] compressBitmap(Bitmap r3) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream((r3.getWidth() * r3.getHeight()) * 4);
        r3.compress(Bitmap.CompressFormat.PNG, 100, r1);     // Catch: IOException -> L5
        r1.flush();     // Catch: IOException -> L5
        r1.close();     // Catch: IOException -> L5
        return r1.toByteArray();
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Unable to serialize photo: " + e.toString());
        return null;
    }

    public static void addCropExtras(Intent r2, int r3) {
        r2.putExtra("crop", "true");
        r2.putExtra("scale", true);
        r2.putExtra("scaleUpIfNeeded", true);
        r2.putExtra("aspectX", 1);
        r2.putExtra("aspectY", 1);
        r2.putExtra("outputX", r3);
        r2.putExtra("outputY", r3);
    }

    public static void addPhotoPickerExtras(Intent r2, Uri r3) {
        r2.putExtra("output", r3);
        r2.addFlags(3);
        r2.setClipData(ClipData.newRawUri("output", r3));
    }

    public static void addBytedanceOSExtras(Intent r2) {
        r2.setPackage(Constants.PACKAGE_NAME_GALLERY);
        r2.putExtra(com.obric.contacts.Constants.get_EXTRA_BYTEDANCE_ANIM_RESOURCE_ID(), new int[]{0, R.anim.slide_down_out});
    }

    public static boolean savePhotoFromUriToUri(Context r1, Uri r2, Uri r3, boolean r4) {
        return savePhotoFromUriToUri(r1, r2, r3, r4, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    public static boolean savePhotoFromUriToUri(Context r9, Uri r10, Uri r11, boolean r12, boolean r13) {
        if (r10 == null) goto L52;
        if (r11 == null) goto L52;
        if (isFilePathAndNotStorage(r10) == true) goto L52;
        ?? r4 = "rw";
        AssetFileDescriptor r14 = r9.getContentResolver().openAssetFileDescriptor(r11, "rw");     // Catch: Throwable -> L39
        FileOutputStream r3 = r14.createOutputStream();     // Catch: Throwable -> L37
        if (r13 == false) goto L25;
        Bitmap r15 = getCorrectlyOrientedImage(r9, r10);     // Catch: Throwable -> L35
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();     // Catch: Throwable -> L35
        if (r15 != null) goto L18;
        Closeables.closeQuietly(r14);
        Closeables.closeQuietly(null);
        Closeables.closeQuietly(r3);
        if (r12 == false) goto L17;
        r9.getContentResolver().delete(r10, null, null);
    L17:
        return false;
    L18:
        r15.compress(Bitmap.CompressFormat.PNG, 0, r5);     // Catch: Throwable -> L35
        r4 = new ByteArrayInputStream(r5.toByteArray());     // Catch: Throwable -> L35
        byte[] r16 = new byte[16384];     // Catch: Throwable -> L33
        long r6 = 0;
    L21:
        int r7 = r4.read(r16);     // Catch: Throwable -> L33
        if (r7 <= 0) goto L27;
        r3.write(r16, 0, r7);     // Catch: Throwable -> L33
        r6 = r6 + ((long) r7);
    L27:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "Wrote " + r6 + " bytes for photo " + r10.toString());     // Catch: Throwable -> L33
        Closeables.closeQuietly(r14);
        Closeables.closeQuietly(r4);
        Closeables.closeQuietly(r3);
        if (r12 == false) goto L62;
        r9.getContentResolver().delete(r10, null, null);
        return true;
    L62:
        return true;
    L25:
        r4 = r9.getContentResolver().openInputStream(r10);     // Catch: Throwable -> L35
        r6 = FileUtils.copy(r4, r3);     // Catch: Throwable -> L33
    L33:
        th = th;
    L55:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to write photo: " + r10.toString() + " because: " + th);     // Catch: Throwable -> L47
        Closeables.closeQuietly(r14);
        Closeables.closeQuietly(r4);
        Closeables.closeQuietly(r3);
        if (r12 == false) goto L46;
        r9.getContentResolver().delete(r10, null, null);
    L46:
        return false;
    L47:
        th = move-exception;
        Closeables.closeQuietly(r14);
        Closeables.closeQuietly(r4);
        Closeables.closeQuietly(r3);
        if (r12 == false) goto L51;
        r9.getContentResolver().delete(r10, null, null);
    L51:
        throw th;
    L35:
        th = th;
        r4 = 0;
    L37:
        th = th;
        r3 = null;
    L41:
        r4 = r3;
    L39:
        th = th;
        r14 = null;
        r3 = null;
    L52:
        return false;
    }

    private static boolean isFilePathAndNotStorage(Uri r2) {
        if ("file".equals(r2.getScheme()) == true) goto L11;
    L9:
        return false;
    L11:
        if (r2.getPath() == null) goto L9;
        return !new File(r2.getPath()).getCanonicalFile().getCanonicalPath().startsWith("/storage/");
    }
}
