package com.bytedance.platform.godzilla.launch.safe;

import android.content.Context;
import android.os.Environment;
import com.bytedance.keva.KevaImpl;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class FileUtils {
    private FileUtils() {
    }

    private void clearAppSpFile(Context r5) {
        File r0 = new File(fetchApplicationDataDir(r5), KevaImpl.PrivateConstants.SP_DIR_NAME);
        if (r0.exists() == true) goto L5;
        return;
    L5:
        File[] r4 = r0.listFiles();
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.length <= 0) goto L25;
        int r6 = r4.length;
        int r1 = 0;
    L10:
        if (r1 >= r6) goto L26;
        File r2 = r4[r1];
        if (r2.getName().endsWith(".sp.xml") == false) goto L14;
    L19:
        r2.delete();
    L20:
        r1 = r1 + 1;
        goto L10
    L14:
        if (r2.getName().equals("all_app_settings_sp.xml") == true) goto L19;
        if (r2.getName().equals("app_setting.xml") == true) goto L19;
        if (r2.getName().equals("local_app_setting.xml") == false) goto L20;
    L26:
        return;
    }

    private void deletePaths(Context r4, String[] r5) {
        File r3 = fetchApplicationDataDir(r4);
        int r6 = r5.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L5;
        dropFileOrDirectory(new File(r3, r5[r0]));
        r0 = r0 + 1;
        goto L3
    }

    private File fetchApplicationDataDir(Context r1) {
        return r1.getFilesDir().getParentFile();
    }

    public static void deleteCacheDir(Context r0) {
        dropFileRecursion(r0.getCacheDir());
    }

    public static void eraseDatabases(Context r3) {
        dropFileRecursion(new File("/data/data/" + r3.getPackageName() + "/databases"));
    }

    public static void erasePreference(Context r3) {
        dropFileRecursion(new File("/data/data/" + r3.getPackageName() + "/shared_prefs"));
    }

    public static void dropDatabase(Context r0, String r1) {
        r0.deleteDatabase(r1);
    }

    public static void dropFiles(Context r0) {
        dropFileRecursion(r0.getFilesDir());
    }

    public static void dropCacheExt(Context r2) {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L6;
        dropFileRecursion(r2.getExternalCacheDir());
        return;
    }

    public static void dropCustomFile(String r1) {
        dropFileRecursion(new File(r1));
    }

    public static void cleanApplicationData(Context r2, String... r3) {
        deleteCacheDir(r2);
        dropCacheExt(r2);
        eraseDatabases(r2);
        erasePreference(r2);
        dropFiles(r2);
        int r4 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        dropCustomFile(r3[r0]);
        r0 = r0 + 1;
        goto L3
    }

    public static void dropFileOrDirectory(File r1) {
        if (r1.isDirectory() == false) goto L5;
        dropFileRecursion(r1);
        return;
    L5:
        dropFile(r1);
    }

    public static boolean dropFile(File r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.exists() == true) goto L6;
        return false;
    L6:
        if (r1.isFile() == false) goto L13;
        r1.delete();
        return true;
    L13:
        return false;
    }

    public static void dropFileRecursion(File r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.exists() == true) goto L6;
        return;
    L6:
        if (r4.isDirectory() == false) goto L26;
        File[] r5 = r4.listFiles();
        if (r5 == null) goto L25;
        int r0 = r5.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L27;
        File r2 = r5[r1];
        if (r2.isDirectory() == false) goto L16;
        dropFileRecursion(r2);
        r2.delete();
    L18:
        r1 = r1 + 1;
        goto L11
    L16:
        if (r2.isFile() == false) goto L18;
        r2.delete();
        goto L18
    L27:
        return;
    L25:
        return;
    }
}
