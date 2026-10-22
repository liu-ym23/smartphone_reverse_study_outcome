package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    public static abstract class In {
        public In() {
        }

        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        public abstract Packet<byte[]> getPacket();

        public static In of(Packet<byte[]> r100, ImageCapture.OutputFileOptions r101) {
            return new AutoValue_JpegBytes2Disk_In(r100, r101);
        }
    }

    public JpegBytes2Disk() {
    }

    private static File createTempFile(ImageCapture.OutputFileOptions r100) throws ImageCaptureException {
        File r101 = r100.getFile();     // Catch: IOException -> L9
        if (r101 == null) goto L8;
        return new File(r101.getParent(), TEMP_FILE_PREFIX + UUID.randomUUID().toString() + getFileExtensionWithDot(r101));
    L8:
        return File.createTempFile(TEMP_FILE_PREFIX, ".tmp");
    L9:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to create temp file.", e);
    }

    private static String getFileExtensionWithDot(File r100) {
        String r101 = r100.getName();
        int r102 = r101.lastIndexOf(46);
        if (r102 >= 0) goto L5;
        return "";
    L5:
        return r101.substring(r102);
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions r100) {
        if (r100.getFile() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions r100) {
        if (r100.getSaveCollection() != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getContentResolver() == null) goto L9;
        if (r100.getContentValues() == null) goto L9;
        return true;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions r100) {
        if (r100.getOutputStream() == null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public ImageCapture.OutputFileResults apply2(In r100) throws ImageCaptureException {
        Packet<byte[]> r101 = r100.getPacket();
        ImageCapture.OutputFileOptions r102 = r100.getOutputFileOptions();
        File r103 = createTempFile(r102);
        writeBytesToFile(r103, r101.getData());
        Exif r104 = r101.getExif();
        Objects.requireNonNull(r104);
        updateFileExif(r103, r104, r102, r101.getRotationDegrees());
        return new ImageCapture.OutputFileResults(moveFileToTarget(r103, r102));
    }

    @Override // androidx.camera.core.processing.Operation
    public /* bridge */ /* synthetic */ ImageCapture.OutputFileResults apply(In r100) throws ImageCaptureException {
        return apply2(r100);
    }

    private static Uri copyFileToFile(File r100, File r101) throws ImageCaptureException {
        if (r101.exists() == false) goto L6;
        r101.delete();
    L6:
        if (r100.renameTo(r101) == false) goto L10;
        return Uri.fromFile(r101);
    L10:
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + r101.getAbsolutePath(), null);
    }

    private static Uri copyFileToMediaStore(File r100, ImageCapture.OutputFileOptions r101) throws ImageCaptureException {
        ContentResolver r102 = r101.getContentResolver();
        Objects.requireNonNull(r102);
        if (r101.getContentValues() == null) goto L5;
        ContentValues r103 = new ContentValues(r101.getContentValues());
    L6:
        setContentValuePendingFlag(r103, 1);
        Uri r104 = null;
        Uri r105 = androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_insert(r102, r101.getSaveCollection(), r103);     // Catch: Throwable -> L20 SecurityException -> L22 IOException -> L24
    L32:
        if (r105 == null) goto L19;
        copyTempFileToUri(r100, r105, r102);     // Catch: Throwable -> L12 SecurityException -> L14 IOException -> L16
        updateUriPendingStatus(r105, r102, 0);
        return r105;
    L19:
        throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);     // Catch: Throwable -> L12 SecurityException -> L14 IOException -> L16
    L16:
        e = e;
    L17:
        r104 = r105;
    L26:
        throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + r104, e);     // Catch: Throwable -> L20
    L14:
        e = e;
    L12:
        th = th;
        r104 = r105;
    L27:
        if (r104 == null) goto L29;
        updateUriPendingStatus(r104, r102, 0);
    L29:
        throw th;
    L20:
        th = th;
    L24:
        e = e;
    L22:
        e = e;
        goto L26
    L5:
        r103 = new ContentValues();
        goto L6
    }

    private static void copyFileToOutputStream(File r100, OutputStream r101) throws IOException {
        FileInputStream r102 = new FileInputStream(r100);
        byte[] r103 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r104 = r102.read(r103);     // Catch: Throwable -> L10
        if (r104 <= 0) goto L8;
        r101.write(r103, 0, r104);     // Catch: Throwable -> L10
        goto L4
    L8:
        r102.close();
        return;
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public static Uri moveFileToTarget(File r100, ImageCapture.OutputFileOptions r101) throws ImageCaptureException {
        Uri r102 = null;
        if (isSaveToMediaStore(r101) == false) goto L7;
        r102 = copyFileToMediaStore(r100, r101);     // Catch: Throwable -> L14 IOException -> L16
    L12:
        r100.delete();
        return r102;
    L7:
        if (isSaveToOutputStream(r101) == false) goto L10;
        OutputStream r103 = r101.getOutputStream();     // Catch: Throwable -> L14 IOException -> L16
        Objects.requireNonNull(r103);     // Catch: Throwable -> L14 IOException -> L16
        OutputStream r104 = r103;     // Catch: Throwable -> L14 IOException -> L16
        copyFileToOutputStream(r100, r103);     // Catch: Throwable -> L14 IOException -> L16
        goto L12
    L10:
        if (isSaveToFile(r101) == false) goto L12;
        File r105 = r101.getFile();     // Catch: Throwable -> L14 IOException -> L16
        Objects.requireNonNull(r105);     // Catch: Throwable -> L14 IOException -> L16
        File r106 = r105;     // Catch: Throwable -> L14 IOException -> L16
        r102 = copyFileToFile(r100, r105);     // Catch: Throwable -> L14 IOException -> L16
        goto L12
    L17:
        throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r100.delete();
        throw th;
    }

    private static void setContentValuePendingFlag(ContentValues r100, int r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r100.put("is_pending", Integer.valueOf(r101));
        return;
    }

    private static void writeBytesToFile(File r100, byte[] r101) throws ImageCaptureException {
        FileOutputStream r102 = new FileOutputStream(r100);     // Catch: IOException -> L12
        r102.write(r101, 0, new InvalidJpegDataParser().getValidDataLength(r101));     // Catch: Throwable -> L6
        r102.close();     // Catch: IOException -> L12
        return;
    L6:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to write to temp file", e);
    }

    private static Uri androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) throws ImageCaptureException {
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

    private static void copyTempFileToUri(File r100, Uri r101, ContentResolver r102) throws IOException {
        OutputStream r103 = r102.openOutputStream(r101);
        if (r103 == null) goto L10;
        copyFileToOutputStream(r100, r103);     // Catch: Throwable -> L7
        r103.close();
        return;
    L10:
        throw new FileNotFoundException(r101 + " cannot be resolved.");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (r103 != null) goto L17;
    L16:
        throw th;
    L17:
        r103.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    private static void updateUriPendingStatus(Uri r100, ContentResolver r101, int r102) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        ContentValues r103 = new ContentValues();
        setContentValuePendingFlag(r103, r102);
        androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_update(r101, r100, r103, null, null);
        return;
    }

    private static void updateFileExif(File r100, Exif r101, ImageCapture.OutputFileOptions r102, int r103) throws ImageCaptureException {
        Exif r104 = Exif.createFromFile(r100);     // Catch: IOException -> L17
        r101.copyToCroppedImage(r104);     // Catch: IOException -> L17
        if (r104.getRotation() != 0) goto L6;
        if (r103 == 0) goto L6;
        r104.rotate(r103);     // Catch: IOException -> L17
    L6:
        ImageCapture.Metadata r105 = r102.getMetadata();     // Catch: IOException -> L17
        if (r105.isReversedHorizontal() == false) goto L10;
        r104.flipHorizontally();     // Catch: IOException -> L17
    L10:
        if (r105.isReversedVertical() == false) goto L13;
        r104.flipVertically();     // Catch: IOException -> L17
    L13:
        if (r105.getLocation() == null) goto L15;
        r104.attachLocation(r105.getLocation());     // Catch: IOException -> L17
    L15:
        r104.save();     // Catch: IOException -> L17
        return;
    L17:
        e = move-exception;
        throw new ImageCaptureException(1, "Failed to update Exif data", e);
    }

    private static int androidx_camera_core_imagecapture_JpegBytes2Disk_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211, r212};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
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
        f06.d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211, r212);
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
