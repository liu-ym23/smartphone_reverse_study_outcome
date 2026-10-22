package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class WorkDatabasePathHelper {
    private static final String[] DATABASE_EXTRA_FILES = null;
    private static final String TAG = null;
    private static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    public static String getWorkDatabaseName() {
        return WORK_DATABASE_NAME;
    }

    static {
        TAG = Logger.tagWithPrefix("WrkDbPathHelper");
        DATABASE_EXTRA_FILES = new String[]{"-journal", "-shm", "-wal"};
    }

    private WorkDatabasePathHelper() {
    }

    public static File getDatabasePath(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        return getDefaultDatabasePath(r100);
    L7:
        return getNoBackupPath(r100, WORK_DATABASE_NAME);
    }

    public static File getDefaultDatabasePath(Context r100) {
        return r100.getDatabasePath(WORK_DATABASE_NAME);
    }

    public static void migrateDatabase(Context r100) {
        File r101 = getDefaultDatabasePath(r100);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return;
    L5:
        if (r101.exists() == false) goto L28;
        Logger.get().debug(TAG, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map<File, File> r102 = migrationPaths(r100);
        Iterator<File> r103 = r102.keySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L29;
        File r104 = r103.next();
        File r105 = r102.get(r104);
        if (r104.exists() == false) goto L8;
        if (r105 == null) goto L8;
        if (r105.exists() == false) goto L16;
        Logger.get().warning(TAG, String.format("Over-writing contents of %s", new Object[]{r105}), new Throwable[0]);
    L16:
        if (r104.renameTo(r105) == false) goto L18;
        String r106 = String.format("Migrated %s to %s", new Object[]{r104, r105});
    L19:
        Logger.get().debug(TAG, r106, new Throwable[0]);
        goto L8
    L18:
        r106 = String.format("Renaming %s to %s failed", new Object[]{r104, r105});
        goto L19
    L29:
        return;
    }

    public static Map<File, File> migrationPaths(Context r110) {
        HashMap r100 = new HashMap();
        if (Build.VERSION.SDK_INT < 23) goto L7;
        File r101 = getDefaultDatabasePath(r110);
        File r111 = getDatabasePath(r110);
        r100.put(r101, r111);
        String[] r102 = DATABASE_EXTRA_FILES;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        String r105 = r102[r104];
        r100.put(new File(r101.getPath() + r105), new File(r111.getPath() + r105));
        r104 = r104 + 1;
    L7:
        return r100;
    }

    private static File getNoBackupPath(Context r100, String r101) {
        return new File(r100.getNoBackupFilesDir(), r101);
    }
}
