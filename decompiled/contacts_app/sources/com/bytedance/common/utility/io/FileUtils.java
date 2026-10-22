package com.bytedance.common.utility.io;

import android.content.Context;
import android.os.Environment;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class FileUtils {
    private static final byte[] GIF87A = null;
    private static final byte[] GIF89A = null;
    private static final byte[] JPEG = null;
    private static final byte[] PNG = null;
    private static final String TAG = "FileUtils";

    public static final enum ImageType extends Enum<ImageType> {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ImageType GIF = null;
        public static final ImageType JPG = null;
        public static final ImageType PNG = null;
        public static final ImageType UNKNOWN = null;

        private ImageType(String r1, int r2) {
            super(r1, r2);
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) Enum.valueOf(ImageType.class, r1);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        static {
            ImageType r0 = new ImageType("UNKNOWN", 0);
            UNKNOWN = r0;
            ImageType r1 = new ImageType("JPG", 1);
            JPG = r1;
            ImageType r3 = new ImageType("PNG", 2);
            PNG = r3;
            ImageType r5 = new ImageType("GIF", 3);
            GIF = r5;
            $VALUES = new ImageType[]{r0, r1, r3, r5};
        }
    }

    static {
        GIF87A = new byte[]{71, 73, 70, 56, 55, 97};
        GIF89A = new byte[]{71, 73, 70, 56, 57, 97};
        JPEG = new byte[]{-1, -40, -1};
        PNG = new byte[]{-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10};
    }

    private FileUtils() {
    }

    public static InputStream getInputStream(String r2) {
        File r0 = new File(r2);
        if (r0.exists() == true) goto L15;
        return null;
    L15:
        return new FileInputStream(r0);
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] getByteArray(String r5) {
        File r0 = new File(r5);
        if (r0.exists() == true) goto L18;
        return null;
    L18:
        FileInputStream r6 = new FileInputStream(r0);     // Catch: Exception -> L10
        int r1 = (int) r0.length();     // Catch: Exception -> L10
        byte[] r2 = new byte[r1];     // Catch: Exception -> L10
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L8;
        r2[r3] = (byte) r6.read();     // Catch: Exception -> L10
        r3 = r3 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        r6.close();     // Catch: Exception -> L10
        return r2;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean copyFile(String r3, String r4, String r5) {
        if (StringUtils.isEmpty(r3) == false) goto L5;
    L37:
        return false;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L37;
        if (StringUtils.isEmpty(r5) == true) goto L37;
        FileInputStream r0 = null;
        FileInputStream r2 = new FileInputStream(r3);     // Catch: Throwable -> L21 Exception -> L23
        boolean r6 = saveInputStream(r2, r4, r5);     // Catch: Throwable -> L17 Exception -> L19
        r2.close();     // Catch: Exception -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L19:
        e = e;
        r0 = r2;
    L24:
        e.printStackTrace();     // Catch: Throwable -> L21
        if (r0 != null) goto L40;
    L30:
        return false;
    L40:
        r0.close();     // Catch: Exception -> L28
    L28:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
        r0 = r2;
    L31:
        if (r0 != null) goto L42;
    L36:
        throw th;
    L42:
        r0.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = e;
    L21:
        th = th;
        goto L31
    }

    public static boolean saveInputStream(InputStream r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        FileOutputStream r1 = null;
        File r2 = new File(r5);     // Catch: Throwable -> L35 Exception -> L37
        if (r2.exists() == false) goto L9;
    L16:
        FileOutputStream r7 = new FileOutputStream(new File(r2, r6));     // Catch: Throwable -> L35 Exception -> L37
        byte[] r8 = new byte[1024];     // Catch: Throwable -> L31 Exception -> L33
    L19:
        int r3 = r4.read(r8);     // Catch: Throwable -> L31 Exception -> L33
        if (r3 == (-1)) goto L22;
        r7.write(r8, 0, r3);     // Catch: Throwable -> L31 Exception -> L33
        goto L19
    L22:
        r7.flush();     // Catch: Throwable -> L31 Exception -> L33
        r7.close();     // Catch: Throwable -> L31 Exception -> L33
        r4.close();     // Catch: Throwable -> L35 Exception -> L37
        if (r4 == null) goto L76;
        r4.close();     // Catch: Exception -> L27
        return true;
    L27:
        e = move-exception;
        e.printStackTrace();
        return true;
    L76:
        return true;
    L33:
        e = e;
        r1 = r7;
    L38:
        Logger.d(TAG, "save inputstream error: " + e);     // Catch: Throwable -> L35
        if (r1 != null) goto L67;
    L41:
        if (r4 != null) goto L59;
    L46:
        return false;
    L59:
        r4.close();     // Catch: Exception -> L44
    L44:
        e = move-exception;
        e.printStackTrace();
        goto L46
    L67:
        r1.close();     // Catch: Exception -> L56
    L31:
        th = th;
        r1 = r7;
    L47:
        if (r1 != null) goto L69;
    L49:
        if (r4 == null) goto L74;
        r4.close();     // Catch: Exception -> L52
        throw th;
    L52:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L74:
        throw th;
    L69:
        r1.close();     // Catch: Exception -> L55
        goto L49
    L9:
        if (r2.mkdirs() == true) goto L16;
        if (r4 != null) goto L57;
    L15:
        return false;
    L57:
        r4.close();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L35:
        th = th;
    L37:
        e = e;
        goto L38
    }

    public static ImageType getImageType(String r1) {
        if (StringUtils.isEmpty(r1) == true) goto L7;
        return getImageType(new File(r1));
    L7:
        return ImageType.UNKNOWN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0072 -> B:64:0x0075). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File r3) {
        if (r3 == null) goto L59;
        if (r3.exists() == false) goto L59;
        ImageType r0 = ImageType.UNKNOWN;
        ?? r1 = 0;
        FileInputStream r2 = null;
        r1 = 0;
        FileInputStream r4 = new FileInputStream(r3);     // Catch: Throwable -> L42 Exception -> L44
        byte[] r5 = new byte[8];     // Catch: Throwable -> L38 Exception -> L40
        r4.read(r5);     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r5, GIF89A) == false) goto L12;
    L32:
        ImageType r6 = ImageType.GIF;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L35
    L37:
        return r6;
    L35:
        e = move-exception;
        e.printStackTrace();
        goto L37
    L12:
        if (checkSignature(r5, GIF87A) == true) goto L32;
        if (checkSignature(r5, JPEG) == false) goto L22;
        ImageType r7 = ImageType.JPG;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L19
    L21:
        return r7;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L22:
        byte[] r8 = PNG;     // Catch: Throwable -> L38 Exception -> L40
        if (checkSignature(r5, r8) == false) goto L30;
        ImageType r9 = ImageType.PNG;     // Catch: Throwable -> L38 Exception -> L40
        r4.close();     // Catch: Exception -> L27
    L29:
        return r9;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L30:
        r4.close();     // Catch: Exception -> L49
        r1 = r8;
    L64:
        return r0;
    L40:
        e = e;
        r2 = r4;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L42
        r1 = r2;
        if (r2 == null) goto L64;
        r2.close();     // Catch: Exception -> L49
        r1 = r2;
    L38:
        th = th;
        r1 = r4;
    L52:
        if (r1 != 0) goto L60;
    L57:
        throw th;
    L60:
        r1.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
    L42:
        th = th;
    L44:
        e = e;
    L49:
        e = move-exception;
        e.printStackTrace();
        r1 = r1;
    L59:
        return ImageType.UNKNOWN;
    }

    public static boolean isGif(File r1) {
        if (getImageType(r1) != ImageType.GIF) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean exists(String r1) {
        if (StringUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        return new File(r1).exists();
    }

    private static boolean checkSignature(byte[] r4, byte[] r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L18;
        int r1 = 0;
    L8:
        if (r1 >= r5.length) goto L13;
        if (r4[r1] != r5[r1]) goto L19;
        r1 = r1 + 1;
        goto L8
    L19:
        return false;
    L13:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public static void chmod(String r11, int r12) {
        Class<?> r2 = Class.forName("android.os.FileUtils");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r2 != null) goto L6;
        return;
    L6:
        Method r3 = r2.getMethod("setPermissions", new Class[]{String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r3 != null) goto L9;
        return;
    L9:
        int r13 = ((Integer) r3.invoke(null, new Object[]{r11, Integer.valueOf(r12), -1, -1})).intValue();     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        if (r13 == 0) goto L21;
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + r13 + " for '" + r11 + "', probably didn't work.");     // Catch: NoSuchMethodException -> L13 InvocationTargetException -> L14 IllegalAccessException -> L15 ClassNotFoundException -> L16 Throwable -> L18
        goto L26
    L25:
        return;
    L21:
        return;
    L16:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        return;
    L15:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        return;
    L13:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        return;
    L14:
        Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        return;
    }

    public static String getFileNameWithoutExtension(String r2) {
        String r3 = new File(r2).getName();
        if (StringUtils.isEmpty(r3) == true) goto L8;
        int r0 = r3.lastIndexOf(LibrarianImpl.Constants.DOT);
        if ((-1) != r0) goto L7;
        return "";
    L7:
        return r3.substring(0, r0);
    L8:
        return "";
    }

    public static String getExtension(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        int r0 = r2.lastIndexOf(LibrarianImpl.Constants.DOT);
        if (r0 != (-1)) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }

    public static void clearDir(String r3) throws Exception {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r0.listFiles();
        int r1 = r4.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L14;
        if (r4[r2].isDirectory() == false) goto L11;
        removeDir(r4[r2].getAbsolutePath());
    L13:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r4[r2].isFile() == false) goto L13;
        r4[r2].delete();
        goto L13
    }

    public static void removeDir(String r4) throws Exception {
        File r0 = new File(r4);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L19;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath());
    L12:
        r2 = r2 + 1;
        goto L7
    L11:
        r5[r2].delete();
        goto L12
    L13:
        r0.delete();
        return;
    }

    public static void clearDir(String r3, Set<String> r4) throws Exception {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L18;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L17:
        r2 = r2 + 1;
        goto L6
    L11:
        if (r5[r2].isFile() == false) goto L17;
        String r6 = r5[r2].getName();
        if (r4 != null) goto L15;
    L16:
        r5[r2].delete();
        goto L17
    L15:
        if (r4.contains(r6) == true) goto L17;
    }

    public static void removeDir(String r3, Set<String> r4) throws Exception {
        File r0 = new File(r3);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        if (r0.isDirectory() == false) goto L22;
        File[] r5 = r0.listFiles();
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L23;
        if (r5[r2].isDirectory() == false) goto L11;
        removeDir(r5[r2].getAbsolutePath(), r4);
    L16:
        r2 = r2 + 1;
        goto L7
    L11:
        String r6 = r5[r2].getName();
        if (r4 != null) goto L14;
    L15:
        r5[r2].delete();
        goto L16
    L14:
        if (r4.contains(r6) == true) goto L16;
    L23:
        return;
    }

    public static long getDirectorySize(File r6, boolean r7) {
        long r0 = 0;
        if (r6.exists() == false) goto L6;
    L8:
        File[] r8 = r6.listFiles();     // Catch: Throwable -> L20
        int r2 = r8.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L19;
        File r4 = r8[r3];     // Catch: Throwable -> L20
        if (r4.isDirectory() == false) goto L15;
        long r5 = getDirectorySize(r4, r7);     // Catch: Throwable -> L20
    L13:
        r0 = r0 + r5;     // Catch: Throwable -> L20
    L18:
        r3 = r3 + 1;
        goto L9
    L15:
        if (r4.isFile() == false) goto L18;
        r5 = r4.length();     // Catch: Throwable -> L20
        goto L13
    L6:
        if (r6.isDirectory() == false) goto L8;
        return 0;
    L19:
        return r0;
    }

    public static String getCacheDirPath(Context r3) throws NullPointerException {
        if (r3 == null) goto L19;
        String r1 = null;
        if (r3.getCacheDir() == null) goto L9;
        String r4 = r3.getCacheDir().getPath();     // Catch: Throwable -> L20
    L8:
        r1 = r4;
        goto L14
    L9:
        File r5 = r3.getDir("/data/data/" + r3.getPackageName() + "/cache/", 0);     // Catch: Throwable -> L20
        if (r5 == null) goto L14;
        r4 = r5.getPath();     // Catch: Throwable -> L20
    L14:
        if (StringUtils.isEmpty(r1) == true) goto L17;
        return r1;
    L17:
        throw new NullPointerException("Cannot Create Cache Dir");
    L19:
        throw new NullPointerException("Context is NUll");
    }

    public static String getFilesDirPath(Context r3) throws NullPointerException {
        if (r3 == null) goto L19;
        String r1 = null;
        if (r3.getFilesDir() == null) goto L9;
        String r4 = r3.getFilesDir().getPath();     // Catch: Throwable -> L20
    L8:
        r1 = r4;
        goto L14
    L9:
        File r5 = r3.getDir("/data/data/" + r3.getPackageName() + "/files/", 0);     // Catch: Throwable -> L20
        if (r5 == null) goto L14;
        r4 = r5.getPath();     // Catch: Throwable -> L20
    L14:
        if (StringUtils.isEmpty(r1) == true) goto L17;
        return r1;
    L17:
        throw new NullPointerException("Cannot Create Files Dir");
    L19:
        throw new NullPointerException("Context is NUll");
    }

    public static boolean isExternalStorageWritable() {
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean isExternalStorageReadable() {
        String r0 = Environment.getExternalStorageState();
        if ("mounted".equals(r0) == false) goto L5;
        return true;
    L5:
        if ("mounted_ro".equals(r0) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
