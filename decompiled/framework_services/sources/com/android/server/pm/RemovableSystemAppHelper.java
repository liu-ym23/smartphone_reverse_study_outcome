package com.android.server.pm;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Singleton;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class RemovableSystemAppHelper {
    private static boolean DEBUG = false;
    private static final File REMOVABLE_SYS_APP_LIST_SYSTEM = null;
    private static final File REMOVABLE_SYS_APP_LIST_VENDOR = null;
    static final String TAG = "RemovableSystemAppHelper";
    private static final Singleton<RemovableSystemAppHelper> mSingleton = null;
    private static boolean sRemovableSysAppEnabled;
    private static HashSet<String> sRemovableSystemAppSet;
    private DeletePackageHelper mDeletePackageHelper;
    private InitAppsHelper mInitAppsHelper;
    private PackageManagerService mPms;
    private UserManagerService mUms;

    static {
        DEBUG = false;
        sRemovableSysAppEnabled = true;
        REMOVABLE_SYS_APP_LIST_SYSTEM = Environment.buildPath(Environment.getRootDirectory(), new String[]{"etc", "permissions", "pms_sysapp_removable_system_list.txt"});
        REMOVABLE_SYS_APP_LIST_VENDOR = Environment.buildPath(Environment.getRootDirectory(), new String[]{"etc", "permissions", "pms_sysapp_removable_vendor_list.txt"});
        sRemovableSystemAppSet = new HashSet();
        mSingleton = new AnonymousClass1();
    }

    public static RemovableSystemAppHelper getInstance() {
        return (RemovableSystemAppHelper) mSingleton.get();
    }

    public RemovableSystemAppHelper() {
    }

    public void init(PackageManagerService pms, UserManagerService ums) {
        this.mPms = pms;
        this.mUms = ums;
    }

    public void initBeforeScan() {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "initBeforeScan start");
    L6:
        if (sRemovableSysAppEnabled == false) goto L9;
        buildRemovableSystemAppSet();
    L9:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "initBeforeScan end");
        return;
    }

    public static boolean isRemovableSysApp(String pkgName) {
        if (sRemovableSysAppEnabled == false) goto L6;
        boolean ret = sRemovableSystemAppSet.contains(pkgName);
        return ret;
    L6:
        return false;
    }

    public static Set<String> getRemovableSysApp() {
        return sRemovableSystemAppSet;
    }

    private void buildRemovableSystemAppSet() {
        if (sRemovableSysAppEnabled == true) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "BuildRemovableSystemAppSet start");
    L7:
        sGetRemovableSystemAppFromFile(sRemovableSystemAppSet, REMOVABLE_SYS_APP_LIST_SYSTEM);
        sGetRemovableSystemAppFromFile(sRemovableSystemAppSet, REMOVABLE_SYS_APP_LIST_VENDOR);
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "BuildRemovableSystemAppSet end");
        return;
    }

    private static void sGetRemovableSystemAppFromFile(HashSet<String> resultSet, File file) {
        FileReader fr = null;
        BufferedReader br = null;
    L13:
        th = move-exception;
        if (0 != 0) goto L54;
    L47:
        if (0 == 0) goto L52;
        fr.close();     // Catch: IOException -> L45
    L45:
        io = move-exception;
        Slog.d(TAG, io.getMessage());
    L52:
        throw th;
    L54:
        br.close();     // Catch: IOException -> L45
    L15:
        io = move-exception;
        Slog.d(TAG, io.getMessage());     // Catch: Throwable -> L13
        if (0 == 0) goto L39;
        br.close();     // Catch: IOException -> L22
    L39:
        if (0 == 0) goto L67;
        fr.close();     // Catch: IOException -> L22
        return;
    L67:
        return;
    L4:
        if (file.exists() == false) goto L24;
        FileReader fr2 = new FileReader(file);     // Catch: Throwable -> L13 IOException -> L15
        BufferedReader br2 = new BufferedReader(fr2);     // Catch: Throwable -> L13 IOException -> L15
    L6:
        String line = br2.readLine();     // Catch: Throwable -> L13 IOException -> L15
        if (line == null) goto L20;
        String line2 = line.trim();     // Catch: Throwable -> L13 IOException -> L15
        if (TextUtils.isEmpty(line2) == true) goto L6;
        if (DEBUG == false) goto L17;
        Slog.d(TAG, "read line " + line2);     // Catch: Throwable -> L13 IOException -> L15
    L17:
        resultSet.add(line2);     // Catch: Throwable -> L13 IOException -> L15
        goto L6
    L20:
        br2.close();     // Catch: IOException -> L22
        fr2.close();     // Catch: IOException -> L22
        return;
    L24:
        Slog.d(TAG, "file in " + file + " does not exist!");     // Catch: Throwable -> L13 IOException -> L15
        if (0 != 0) goto L57;
    L29:
        if (0 == 0) goto L64;
        fr.close();     // Catch: IOException -> L27
        return;
    L27:
        io = move-exception;
        Slog.d(TAG, io.getMessage());
        return;
    L64:
        return;
    L57:
        br.close();     // Catch: IOException -> L27
    L22:
        io = move-exception;
        Slog.d(TAG, io.getMessage());
    }
}
