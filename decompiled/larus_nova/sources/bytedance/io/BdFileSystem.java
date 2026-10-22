package bytedance.io;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.StatFs;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import bytedance.io.exception.IllegalPathException;
import bytedance.util.BdFileUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import w.a;
import x.b;
import x.c;
import x.d;
import x.e;
import x.g;
import x.h;
import x.i;

/* JADX INFO: loaded from: classes28.dex */
public class BdFileSystem {
    private static final a fms = null;

    public BdFileSystem() {
    }

    static {
        fms = a.C8054a.f557764a;
    }

    public static boolean delete(File r100) throws IllegalPathException {
        fms.getClass();
        return a.a(r100).delete();
    }

    public static boolean deleteByToken(String r100) throws IOException {
        return getFile(r100).delete();
    }

    public static void deleteFiles(List<BdFile> r100) throws IllegalPathException {
        Iterator<BdFile> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        BdFile r102 = r101.next();
        fms.getClass();
        a.a(r102).delete();
        goto L4
    }

    public static void deleteOnExit(File r100) throws IllegalPathException {
        fms.getClass();
        a.a(r100).deleteOnExit();
    }

    public static void deleteOnExitByToken(String r100) throws IOException {
        getFile(r100).deleteOnExit();
    }

    public static void doFileOperation(d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 > 28) goto L8;
        r100.a();
        return;
    L8:
        if (r101 == 29) goto L10;
    L12:
        r100.b();
        return;
    L10:
        if (Environment.isExternalStorageLegacy() == false) goto L12;
        r100.a();
    }

    public static long getAvailableStorageSize(Context r100) {
        if (Environment.getDataDirectory() != null) goto L7;
        return -1;
    L7:
        return getDirectoryAvailableSize(r100.getFilesDir().getParent());
    }

    private static long getDirectoryAvailableSize(String r100) {
        StatFs r101 = new StatFs(r100);     // Catch: IllegalArgumentException -> L5
        return r101.getBlockSizeLong() * r101.getAvailableBlocksLong();
    L5:
        return -1;
    }

    private static long getDirectoryTotalSize(String r100) {
        StatFs r101 = new StatFs(r100);     // Catch: IllegalArgumentException -> L5
        return r101.getBlockSizeLong() * r101.getBlockCountLong();
    L5:
        return -1;
    }

    public static String getExternalDir(Context r100) {
        return r100.getExternalCacheDir().getParent();
    }

    public static BdFile getFile(String r100) throws IOException, IllegalPathException {
        return new BdFile(r100);
    }

    public static x.a getFileInputStream(String r100) throws FileNotFoundException, IllegalPathException {
        return new x.a(r100);
    }

    public static b getFileOutputStream(String r100) throws FileNotFoundException, IllegalPathException {
        return new b(r100);
    }

    public static c getFileReader(String r100) throws FileNotFoundException, IllegalPathException {
        return new c(r100);
    }

    public static e getFileWriter(String r100) throws IOException {
        return new e(r100);
    }

    public static g getPrintStream(String r100) throws FileNotFoundException, IllegalPathException {
        return new g(r100);
    }

    public static h getPrintWriter(String r100) throws FileNotFoundException, IllegalPathException {
        return new h(r100);
    }

    public static long getTotalStorageSize(Context r100) {
        if (Environment.getDataDirectory() != null) goto L7;
        return -1;
    L7:
        return getDirectoryTotalSize(r100.getFilesDir().getParent());
    }

    public static BdFile[] listFiles(String r100) throws IOException {
        return getFile(r100).listFiles();
    }

    public static x.a openFileInput(String r100) throws FileNotFoundException, IllegalPathException {
        return new x.a(r100);
    }

    public static boolean delete(String r100) throws IOException {
        return getFile(r100).delete();
    }

    public static void deleteOnExit(String r100) throws IOException {
        getFile(r100).deleteOnExit();
    }

    public static void copyFile(File r100, File r101) throws IOException {
        fms.getClass();
        BdFile r102 = a.a(r100);
        BdFile r103 = a.a(r101);
        if (r102.exists() == false) goto L52;
        if (r102.getCanonicalPath().equals(r103.getCanonicalPath()) == true) goto L50;
        if (r103.getParentFile() == null) goto L16;
        if (r103.getParentFile().exists() == true) goto L16;
        if (r103.getParentFile().mkdirs() == true) goto L16;
        throw new IOException("Failed to copy from->" + r102 + " to->" + r103 + " because of dest parent mkdir failed");
    L16:
        if (r103.exists() == false) goto L23;
        if (r103.canWrite() == true) goto L23;
        throw new IOException("Failed to copy from->" + r102 + " to->" + r103 + "because of destFile cant write!");
    L23:
        if (r102.length() == (-1)) goto L48;
        r102.toString();
        r103.toString();
        PolarisFileInputStreamWrapper r104 = null;
        PolarisFileOutputStreamWrapper r105 = null;
        byte[] r106 = new byte[4096];     // Catch: Throwable -> L43
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L43
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L41
    L53:
        int r109 = r107.read(r106);     // Catch: Throwable -> L39
        if (r109 < 0) goto L29;
        r108.write(r106, 0, r109);     // Catch: Throwable -> L39
        goto L53
    L29:
        r108.flush();     // Catch: Throwable -> L39
        r108.getFD().sync();     // Catch: Throwable -> L39
        bytedance.util.a.a(r107);
        bytedance.util.a.b(r108);
        if (r102.length() != r103.length()) goto L35;
        r103.setLastModified(r102.lastModified());
        return;
    L35:
        throw new IOException("Failed to copy full contents from->" + r102 + " to->" + r103);
    L39:
        th = th;
        r105 = r108;
    L42:
        PolarisFileOutputStreamWrapper r110 = r105;
        r104 = r107;
    L45:
        bytedance.util.a.a(r104);
        bytedance.util.a.b(r110);
        throw th;
    L41:
        th = th;
    L43:
        th = th;
        r110 = null;
        goto L45
    L48:
        throw new IOException("Failed to copy from->" + r102 + " to->" + r103 + " fileLen=-1");
    L50:
        throw new IOException("Failed to copy same path from->" + r102 + " to->" + r103);
    L52:
        throw new FileNotFoundException("Failed to copy from->" + r102 + "to->" + r103 + "because of srcFile not exist");
    }

    public static Uri createImageUri(Context r100, String r101) {
        return BdMediaFileSystem.createImageUri(r100, r101);
    }

    public static Uri createMusicUri(Context r100, String r101) {
        return BdMediaFileSystem.createMusicUri(r100, r101);
    }

    public static Uri createVideoUri(Context r100, String r101) {
        return BdMediaFileSystem.createVideoUri(r100, r101);
    }

    public static void deleteFiles(List<BdFile> r100, boolean r101) throws IllegalPathException {
        if (r101 == false) goto L15;
        Iterator<BdFile> r102 = r100.iterator();
    L5:
        if (r102.hasNext() == false) goto L25;
        BdFile r103 = r102.next();
        fms.getClass();
        if (a.a(r103).isDirectory() == false) goto L10;
        deleteFiles(new ArrayList(Arrays.asList(a.a(r103).listFiles())));
    L10:
        if (r103.isDirectory() == false) goto L11;
        if (r103.listFiles().length != 0) goto L5;
        r103.delete();
        goto L5
    L11:
        r103.delete();
        goto L5
    L25:
        return;
    L15:
        deleteFiles(r100);
    }

    private static Uri downloadFile(InputStream r100, File r101) throws IOException {
        PolarisFileOutputStreamWrapper r102 = new PolarisFileOutputStreamWrapper(r101);
        BufferedInputStream r103 = new BufferedInputStream(r100);
        BufferedOutputStream r104 = new BufferedOutputStream(r102);
        byte[] r105 = new byte[8192];
    L3:
        int r106 = r103.read(r105);
        if (r106 <= 0) goto L6;
        r104.write(r105, 0, r106);
        r104.flush();
        goto L3
    L6:
        r104.close();
        r103.close();
        return Uri.fromFile(r101);
    }

    public static BdFile getFile(File r100, String r101) throws IOException {
        return new BdFile(r100, r101);
    }

    public static b getFileOutputStream(String r100, boolean r101) throws FileNotFoundException, IllegalPathException {
        if (r100 == null) goto L5;
        BdFile r102 = new BdFile(r100);
    L7:
        return new b(r102, r101);
    L5:
        r102 = null;
        goto L7
    }

    public static e getFileWriter(String r100, boolean r101) throws IOException {
        return new e(r100, r101);
    }

    public static InputStream getInputStream(Context r100, Uri r101) throws FileNotFoundException {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.getScheme();
        if (TextUtils.isEmpty(r102) == true) goto L49;
        if ("file".equals(r102) == true) goto L49;
        if (DocumentsContract.isDocumentUri(r100, r101) == false) goto L36;
        if (TextUtils.equals("com.android.providers.media.documents", r101.getAuthority()) == false) goto L36;
        String[] r103 = DocumentsContract.getDocumentId(r101).split(":");
        String r104 = r103[0];
        if (TextUtils.equals("image", r104) == false) goto L20;
        Uri r105 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Images.Media.getContentUri("external_primary");
    L31:
        if (TextUtils.isEmpty(r103[1]) == false) goto L34;
        return null;
    L34:
        return ContentResolverWrapper.openInputStream(r100.getContentResolver(), ContentUris.withAppendedId(r105, CastLongProtector.parseLong(r103[1])));
    L20:
        if (TextUtils.equals("video", r104) == false) goto L25;
        r105 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Video.Media.getContentUri("external_primary");
        goto L31
    L25:
        if (TextUtils.equals("audio", r104) == false) goto L29;
        r105 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Audio.Media.getContentUri("external_primary");
        goto L31
    L29:
        r105 = null;
    L36:
        if ("content".equals(r102) == true) goto L38;
    L41:
        String r106 = BdFileUtils.convertUriToPath(r100, r101);
        if (TextUtils.isEmpty(r106) == false) goto L44;
    L47:
        return null;
    L44:
        if (new PolarisFileWrapper(r106).exists() == false) goto L47;
        return new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r106));
    L38:
        if ("media".equals(r101.getAuthority()) == false) goto L41;
        return ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);
    L49:
        return new PolarisFileInputStreamWrapper(r101.getPath());
    }

    public static long getLength(Context r100, Uri r101) {
        return BdMediaFileSystem.getLength(r100, r101);
    }

    public static OutputStream getOutputStream(Context r100, Uri r101) throws FileNotFoundException {
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.getScheme();
        if (TextUtils.isEmpty(r102) == true) goto L49;
        if ("file".equals(r102) == true) goto L49;
        if (DocumentsContract.isDocumentUri(r100, r101) == false) goto L36;
        if (TextUtils.equals("com.android.providers.media.documents", r101.getAuthority()) == false) goto L36;
        String[] r103 = DocumentsContract.getDocumentId(r101).split(":");
        String r104 = r103[0];
        if (TextUtils.equals("image", r104) == false) goto L20;
        Uri r105 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Images.Media.getContentUri("external_primary");
    L31:
        if (TextUtils.isEmpty(r103[1]) == false) goto L34;
        return null;
    L34:
        return ContentResolverWrapper.openOutputStream(r100.getContentResolver(), ContentUris.withAppendedId(r105, CastLongProtector.parseLong(r103[1])));
    L20:
        if (TextUtils.equals("video", r104) == false) goto L25;
        r105 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Video.Media.getContentUri("external_primary");
        goto L31
    L25:
        if (TextUtils.equals("audio", r104) == false) goto L29;
        r105 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        if (bytedance.util.a.d() == false) goto L31;
        r105 = MediaStore.Audio.Media.getContentUri("external_primary");
        goto L31
    L29:
        r105 = null;
    L36:
        if ("content".equals(r102) == true) goto L38;
    L41:
        String r106 = BdFileUtils.convertUriToPath(r100, r101);
        if (TextUtils.isEmpty(r106) == false) goto L44;
    L47:
        return null;
    L44:
        if (new PolarisFileWrapper(r106).exists() == false) goto L47;
        return new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r106));
    L38:
        if ("media".equals(r101.getAuthority()) == false) goto L41;
        return ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r101);
    L49:
        return new PolarisFileOutputStreamWrapper(r101.getPath());
    }

    public static g getPrintStream(String r100, String r101) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        return new g(r100, r101);
    }

    public static h getPrintWriter(String r100, String r101) throws FileNotFoundException, UnsupportedEncodingException, IllegalPathException {
        return new h(r100, r101);
    }

    public static i getRandomAccessFile(String r100, String r101) throws FileNotFoundException, IllegalPathException {
        if (r100 == null) goto L5;
        BdFile r102 = new BdFile(r100);
    L7:
        return new i(r102, r101);
    L5:
        r102 = null;
        goto L7
    }

    public static ParcelFileDescriptor getReadFileDescriptor(Context r100, Uri r101) throws IOException {
        return getFileDescriptor(r100, r101, "r");
    }

    public static ParcelFileDescriptor getWriteFileDescriptor(Context r100, Uri r101) throws IOException {
        return getFileDescriptor(r100, r101, "rw");
    }

    public static boolean isUriExists(Context r100, Uri r101) {
        return BdMediaFileSystem.isUriExists(r100, r101);
    }

    public static boolean renameTo(File r100, File r101) throws IllegalPathException {
        fms.getClass();
        return r100.renameTo(a.a(r101));
    }

    public static void copyFile(File r100, FileOutputStream r101) throws IOException {
        fms.getClass();
        BdFile r102 = a.a(r100);
        if (r102.exists() == false) goto L25;
        if (r102.length() == (-1)) goto L23;
        r102.toString();
        Objects.toString(r101.getFD());
        byte[] r103 = new byte[4096];     // Catch: Throwable -> L18
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L18
    L26:
        int r105 = r104.read(r103);     // Catch: Throwable -> L16
        if (r105 < 0) goto L10;
        r101.write(r103, 0, r105);     // Catch: Throwable -> L16
        goto L26
    L10:
        r101.flush();     // Catch: Throwable -> L16
        r101.getFD().sync();     // Catch: Throwable -> L16
        bytedance.util.a.a(r104);
        bytedance.util.a.b(r101);
        return;
    L16:
        th = th;
    L20:
        bytedance.util.a.a(r104);
        bytedance.util.a.b(r101);
        throw th;
    L18:
        th = th;
        r104 = null;
        goto L20
    L23:
        throw new IOException("Failed to copy from->" + r102 + " to->" + r101.getFD() + " fileLen=-1");
    L25:
        throw new FileNotFoundException("Failed to copy from->" + r102 + "to->" + r101.getFD() + "because of srcFile not exist");
    }

    public static BdFile getFile(String r100, String r101) throws IOException {
        return new BdFile(r100, r101);
    }

    public static i getRandomAccessFile(File r100, String r101) throws FileNotFoundException, IllegalPathException {
        return new i(r100, r101);
    }

    public static boolean renameTo(String r100, String r101) throws IOException, IllegalPathException {
        return getFile(r100).renameTo(getFile(r101));
    }

    public static void copyFile(InputStream r100, FileOutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];     // Catch: Throwable -> L15
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
    L6:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
        if (r103 <= 0) goto L8;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        goto L6
    L8:
        r101.flush();     // Catch: Throwable -> L15
        r101.getFD().sync();     // Catch: Throwable -> L15
        bytedance.util.a.a(r100);
        bytedance.util.a.b(r101);
        return;
    L14:
        throw new IOException("Failed to copy input:" + r100 + "output:" + r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        bytedance.util.a.a(r100);
        bytedance.util.a.b(r101);
        throw th;
    }

    public static void copyFile(InputStream r100, OutputStream r101) throws IOException {
        byte[] r102 = new byte[4096];     // Catch: Throwable -> L15
        if (r100 == null) goto L14;
        if (r101 == null) goto L14;
    L6:
        int r103 = r100.read(r102);     // Catch: Throwable -> L15
        if (r103 <= 0) goto L8;
        r101.write(r102, 0, r103);     // Catch: Throwable -> L15
        goto L6
    L8:
        r101.flush();     // Catch: Throwable -> L15
        bytedance.util.a.a(r100);
        bytedance.util.a.b(r101);
        return;
    L14:
        throw new IOException("Failed to copy input:" + r100 + "output:" + r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        bytedance.util.a.a(r100);
        bytedance.util.a.b(r101);
        throw th;
    }

    public static void copyFile(String r100, String r101) throws IOException {
        copyFile(getFile(r100), getFile(r101));
    }

    private static Uri bytedance_io_BdFileSystem_android_content_ContentResolver_insert(ContentResolver r110, Uri r111, ContentValues r210) throws IOException {
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

    private static ParcelFileDescriptor bytedance_io_BdFileSystem_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
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
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
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
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Uri downloadPublicFile(InputStream r100, String r101, Context r102) throws IOException {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        ContentResolver r103 = r102.getContentResolver();
        ContentValues r104 = new ContentValues();
        r104.put(LynxEventReporter.PROP_NAME_RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
        r104.put("_display_name", r101);
        r104.put("is_pending", 1);
        Uri r105 = bytedance_io_BdFileSystem_android_content_ContentResolver_insert(r103, MediaStore.Downloads.EXTERNAL_CONTENT_URI, r104);
        if (r105 == null) goto L14;
        OutputStream r106 = ContentResolverWrapper.openOutputStream(r103, r105);     // Catch: Exception -> L16
        BufferedInputStream r107 = new BufferedInputStream(r100);     // Catch: Exception -> L16
        BufferedOutputStream r108 = new BufferedOutputStream(r106);     // Catch: Exception -> L16
        byte[] r109 = new byte[8192];     // Catch: Exception -> L16
    L9:
        int r110 = r107.read(r109);     // Catch: Exception -> L16
        if (r110 <= 0) goto L12;
        r108.write(r109, 0, r110);     // Catch: Exception -> L16
        r108.flush();     // Catch: Exception -> L16
        goto L9
    L12:
        r108.close();     // Catch: Exception -> L16
        r107.close();     // Catch: Exception -> L16
        r104.clear();     // Catch: Exception -> L16
        r104.put("is_pending", 0);     // Catch: Exception -> L16
        bytedance_io_BdFileSystem_android_content_ContentResolver_update(r103, r105, r104, null, null);     // Catch: Exception -> L16
        return r105;
    L14:
        a.C8054a.f557764a.getClass();     // Catch: Exception -> L16
        throw new IOException("Failed to get Downloads uri");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        a.C8054a.f557764a.getClass();
        bytedance_io_BdFileSystem_android_content_ContentResolver_delete(r103, r105, null, null);
        throw e;
    L5:
        return downloadFile(r100, new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), r101));
    }

    public static ParcelFileDescriptor getFileDescriptor(Context r100, Uri r101, String r102) throws IOException {
        return bytedance_io_BdFileSystem_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), r101, r102);
    }

    private static int bytedance_io_BdFileSystem_android_content_ContentResolver_delete(ContentResolver r110, Uri r111, String r210, String[] r211) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240019);
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
        f06.d r107 = r106.preInvoke(240019, "android/content/ContentResolver", "delete", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.delete(r111, r210, r211);
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

    private static int bytedance_io_BdFileSystem_android_content_ContentResolver_update(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) throws IOException {
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
