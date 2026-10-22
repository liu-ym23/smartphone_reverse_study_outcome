package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUtils;
import com.bytedance.apm.util.PermissionUtils;
import com.bytedance.article.common.monitor.file.FileUploadManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionFetch {
    public static final String PERMISSION_FILE_BACK_TYPE = "permission_back";
    private static long lastFetchTime;
    private static String[] permissionList;

    static {
    }

    public PermissionFetch() {
    }

    public static Map<String, Boolean> checkAppPermissions(Context r6) {
        HashMap r0 = new HashMap();
        String[] r1 = permissionList;
        if (r1 == null) goto L7;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        String r4 = r1[r3];
        r0.put(r4, Boolean.valueOf(PermissionUtils.checkSelfPermission(r6, r4)));
        r3 = r3 + 1;
    L7:
        return r0;
    }

    public static boolean writePermissionInfo(Context r8) {
        if (PermissionUtils.isGrantSDCardWritePermission(r8) == true) goto L64;
        return false;
    L64:
        permissionList = r8.getPackageManager().getPackageInfo(r8.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        String r0 = FileUtils.getExternalRootDir(r8).getAbsolutePath() + File.separator + "backfetch" + File.separator + "permissioninfo";
        BufferedWriter r2 = null;
        File r3 = new File(r0);     // Catch: Throwable -> L28 IOException -> L30
        if (r3.exists() == true) goto L10;
        r3.mkdirs();     // Catch: Throwable -> L28 IOException -> L30
    L10:
        FileWriter r4 = new FileWriter(r0 + File.separator + generateUploadFileName());     // Catch: Throwable -> L28 IOException -> L30
        BufferedWriter r1 = new BufferedWriter(r4);     // Catch: IOException -> L26 Throwable -> L42
        Iterator<Map.Entry<String, Boolean>> r9 = checkAppPermissions(r8).entrySet().iterator();     // Catch: Throwable -> L22 IOException -> L24
    L14:
        if (r9.hasNext() == false) goto L55;
        Map.Entry<String, Boolean> r5 = r9.next();     // Catch: Throwable -> L22 IOException -> L24
        r1.write(String.format("permission: %s, result: %b\n", new Object[]{r5.getKey(), r5.getValue()}));     // Catch: Throwable -> L22 IOException -> L24
    L55:
        r1.close();     // Catch: IOException -> L19
        r4.close();     // Catch: IOException -> L19
    L21:
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = e;
        r2 = r1;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r2 != null) goto L59;
    L37:
        if (r4 == null) goto L41;
        r4.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        e.printStackTrace();
    L41:
        return false;
    L59:
        r2.close();     // Catch: IOException -> L35
    L22:
        th = th;
        r2 = r1;
    L43:
        if (r2 != null) goto L57;
    L47:
        if (r4 == null) goto L51;
        r4.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L57:
        r2.close();     // Catch: IOException -> L45
    L26:
        e = e;
    L42:
        th = th;
        goto L43
    L30:
        e = e;
        r4 = null;
    L28:
        th = th;
        r4 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String r1 = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return String.format("%s_permissionInfo", new Object[]{r0.format(new Date(System.currentTimeMillis()))});
    L7:
        return String.format("%s_permissionInfo_%s", new Object[]{r0.format(new Date(System.currentTimeMillis())), r1});
    }

    public static void uploadPermissionFile(Context r4) {
        if (FetchUtils.checkFetchInterval(lastFetchTime, System.currentTimeMillis()) == true) goto L6;
        return;
    L6:
        if (writePermissionInfo(r4) == false) goto L9;
        lastFetchTime = System.currentTimeMillis();
        FileUploadManager.registerFileCallBack(PERMISSION_FILE_BACK_TYPE, new AnonymousClass1());
        return;
    }
}
