package e8;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.AccountAppsColumns;
import com.bytedanceos.common.model.database.columns.AccountCollectionsColumns;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.bytedanceos.common.model.database.columns.InstalledAppsColumns;
import com.bytedanceos.common.model.database.columns.WifiDownloadAppsColumns;
import com.bytedanceos.common.toolbox.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f19319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f19320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f19321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f19322d;

    /* JADX INFO: renamed from: e8.a$a, reason: collision with other inner class name */
    public class RunnableC0243a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f19324b;

        public RunnableC0243a(Context r10, String r11) {
            this.f19323a = r10;
            this.f19324b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver r10 = this.f19323a.getContentResolver();
            Uri r11 = Uri.withAppendedPath(InstalledAppsColumns.URI, this.f19324b);
            Cursor r12 = null;
            Cursor r13 = r10.query(r11, new String[]{CommonColumns.APP_SYNC}, null, null, null);     // Catch: Throwable -> L17 Exception -> L19
            if (r13 != null) goto L31;
        L14:
            r10.delete(r11, null, null);     // Catch: Throwable -> L10 Exception -> L12
            if (r13 == null) goto L27;
            r13.close();
        L27:
            return;
        L12:
            e = e;
            r12 = r13;
        L20:
            e.printStackTrace();     // Catch: Throwable -> L17
            j.b(" removeInstalledApp Exception:" + e.getMessage());     // Catch: Throwable -> L17
            if (r12 == null) goto L27;
            r12.close();
        L10:
            th = th;
            r12 = r13;
        L24:
            if (r12 == null) goto L26;
            r12.close();
        L26:
            throw th;
        L31:
            if (r13.moveToFirst() == false) goto L14;
            if (r13.getInt(0) != 0) goto L14;
            int r14 = r10.delete(Uri.withAppendedPath(AccountAppsColumns.URI, this.f19324b), null, null);     // Catch: Throwable -> L10 Exception -> L12
            com.bytedanceos.appstore.datacache.a.N0().Q0(this.f19324b);     // Catch: Throwable -> L10 Exception -> L12
            j.a("delete myappdatacache   " + r14 + "  /" + this.f19324b);     // Catch: Throwable -> L10 Exception -> L12
        L17:
            th = th;
        L19:
            e = e;
            goto L20
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f19325a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f19326b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f19327c = null;

        static {
            f19325a = new String[]{CommonColumns.APP_PACKAGENAME, CommonColumns.APP_VERSIONCODE};
            f19326b = new String[]{CommonColumns.APP_PACKAGENAME, CommonColumns.APP_VERSIONNAME};
            f19327c = new String[]{"app_name", CommonColumns.APP_PACKAGENAME, CommonColumns.APP_VERSIONCODE, CommonColumns.APP_VERSIONNAME, InstalledAppsColumns.APP_INSTALLEDTIME, InstalledAppsColumns.APP_UPDATETIME};
        }
    }

    static {
        f19319a = new Object();
        f19320b = new Object();
        f19321c = new Object();
        f19322d = new Object();
    }

    public static boolean a(List r14, Context r15) {
        if (r14 != null) goto L5;
    L41:
        return false;
    L5:
        if (r14.size() == 0) goto L41;
        Object r10 = f19321c;
        monitor-enter(r10);
        Cursor r11 = null;
        SimpleDateFormat r12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L16 Exception -> L18
        Iterator r16 = r14.iterator();     // Catch: Throwable -> L16 Exception -> L18
    L12:
        if (r16.hasNext() == false) goto L26;
        AppInfo r13 = (AppInfo) r16.next();     // Catch: Throwable -> L16 Exception -> L18
        ContentResolver r17 = r15.getContentResolver();     // Catch: Throwable -> L16 Exception -> L18
        Uri r18 = WifiDownloadAppsColumns.URI;     // Catch: Throwable -> L16 Exception -> L18
        Uri r19 = Uri.withAppendedPath(r18, r13.appPackageName);     // Catch: Throwable -> L16 Exception -> L18
        ContentValues r110 = new ContentValues();     // Catch: Throwable -> L16 Exception -> L18
        r11 = r17.query(r19, null, null, null, null);     // Catch: Throwable -> L16 Exception -> L18
        if (r11.getCount() != 0) goto L20;
        r110.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L16 Exception -> L18
        r110.put("app_id", r13.appId);     // Catch: Throwable -> L16 Exception -> L18
        r110.put("app_name", r13.appName);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_PACKAGENAME, r13.appPackageName);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_ICON, r13.appIcon);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_CATEGORY, r13.appCategoryName);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_SCORES, Float.valueOf(r13.appScores));     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r13.appVersionCode));     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_DOWNLOADURL, r13.appDownloadUrl);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_SIZE, Long.valueOf(r13.appBytes));     // Catch: Throwable -> L16 Exception -> L18
        r110.put("soft_type", Integer.valueOf(r13.getSoftType()));     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_OPTIME, r12.format(new Date()));     // Catch: Throwable -> L16 Exception -> L18
        r110.put("app_tab_source", r13.tabSource);     // Catch: Throwable -> L16 Exception -> L18
        r110.put(CommonColumns.APP_VERSIONNAME, r13.appVersionName);     // Catch: Throwable -> L16 Exception -> L18
        r17.insert(r18, r110);     // Catch: Throwable -> L16 Exception -> L18
        goto L12
    L20:
        j.a(" packageName exist:" + r13.appPackageName);     // Catch: Throwable -> L16 Exception -> L18
        r11.close();     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L24
        return false;
    L26:
        if (r11 == null) goto L28;
        r11.close();     // Catch: Throwable -> L24
    L28:
        monitor-exit(r10);     // Catch: Throwable -> L24
        return true;
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        j.b(" updateWifiApps Exception:" + e.getMessage());     // Catch: Throwable -> L16
        if (r11 == null) goto L35;
        r11.close();     // Catch: Throwable -> L24
    L35:
        return false;
    L16:
        th = move-exception;
        if (r11 == null) goto L38;
        r11.close();     // Catch: Throwable -> L24
    L38:
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static boolean b(AppInfo r12, Context r13) {
        if (r12 != null) goto L5;
    L37:
        return false;
    L5:
        if (TextUtils.isEmpty(r12.appPackageName) == true) goto L37;
        String r10 = r12.appPackageName;
        Object r11 = f19321c;
        monitor-enter(r11);
        Cursor r14 = null;
        ContentResolver r15 = r13.getContentResolver();     // Catch: Throwable -> L19 Exception -> L21
        Uri r16 = WifiDownloadAppsColumns.URI;     // Catch: Throwable -> L19 Exception -> L21
        Uri r17 = Uri.withAppendedPath(r16, r10);     // Catch: Throwable -> L19 Exception -> L21
        ContentValues r18 = new ContentValues();     // Catch: Throwable -> L19 Exception -> L21
        Cursor r19 = r15.query(r17, null, null, null, null);     // Catch: Throwable -> L19 Exception -> L21
        if (r19.getCount() != 0) goto L23;
        r18.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L19 Exception -> L21
        r18.put("app_id", r12.appId);     // Catch: Throwable -> L19 Exception -> L21
        r18.put("app_name", r12.appName);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_PACKAGENAME, r10);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_ICON, r12.appIcon);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_CATEGORY, r12.appCategoryName);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_SCORES, Float.valueOf(r12.appScores));     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r12.appVersionCode));     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_DOWNLOADURL, r12.appDownloadUrl);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_SIZE, Long.valueOf(r12.appBytes));     // Catch: Throwable -> L19 Exception -> L21
        r18.put("soft_type", Integer.valueOf(r12.getSoftType()));     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_OPTIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));     // Catch: Throwable -> L19 Exception -> L21
        r18.put("app_tab_source", r12.tabSource);     // Catch: Throwable -> L19 Exception -> L21
        r18.put(CommonColumns.APP_VERSIONNAME, r12.appVersionName);     // Catch: Throwable -> L19 Exception -> L21
        r15.insert(r16, r18);     // Catch: Throwable -> L19 Exception -> L21
        r19.close();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return true;
    L23:
        j.a(" packageName exist:" + r10);     // Catch: Throwable -> L19 Exception -> L21
        r19.close();     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        j.b(" updateWifiApps Exception:" + e.getMessage());     // Catch: Throwable -> L19
        if (0 == 0) goto L31;
        r14.close();     // Catch: Throwable -> L17
    L31:
        return false;
    L19:
        th = move-exception;
        if (0 == 0) goto L34;
        r14.close();     // Catch: Throwable -> L17
    L34:
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static void c(Context r10) {
        Object r11 = f19320b;
        monitor-enter(r11);
        r10.getContentResolver().delete(AccountCollectionsColumns.URI, null, null);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        j.b(" clearCollections Exception:" + e.getMessage());     // Catch: Throwable -> L6
        e.printStackTrace();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void d(Context r10) {
        Object r11 = f19319a;
        monitor-enter(r11);
        r10.getContentResolver().delete(AccountAppsColumns.URI, null, null);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        j.b(" clearMyApps Exception:" + e.getMessage());     // Catch: Throwable -> L6
        e.printStackTrace();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void e(Context r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        new Thread(new RunnableC0243a(r10, r11)).start();
    }

    public static void f(Context r10, ArrayList r11, boolean r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L39;
        Object r14 = f19319a;
        monitor-enter(r14);
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L14 Exception -> L16
        r15.append("app_packagename in (");     // Catch: Throwable -> L14 Exception -> L16
        int r16 = r11.size();     // Catch: Throwable -> L14 Exception -> L16
        Iterator r17 = r11.iterator();     // Catch: Throwable -> L14 Exception -> L16
    L10:
        if (r17.hasNext() == false) goto L19;
        r15.append("'" + ((AppInfo) r17.next()).appPackageName + "'");     // Catch: Throwable -> L14 Exception -> L16
        if (r16 <= 1) goto L18;
        r15.append(",");     // Catch: Throwable -> L14 Exception -> L16
    L18:
        r16 = r16 - 1;     // Catch: Throwable -> L14 Exception -> L16
        goto L10
    L19:
        r15.append(")");     // Catch: Throwable -> L14 Exception -> L16
        if (r13 == false) goto L22;
        ContentValues r18 = new ContentValues();     // Catch: Throwable -> L14 Exception -> L16
        r18.put(AccountAppsColumns.APP_MARK_DELETED, Integer.valueOf(r13 ? 1 : 0));     // Catch: Throwable -> L14 Exception -> L16
        int r19 = r10.getContentResolver().update(AccountAppsColumns.URI, r18, r15.toString(), null);     // Catch: Throwable -> L14 Exception -> L16
    L23:
        if (r19 <= 0) goto L28;
        if (r12 == true) goto L28;
        com.bytedanceos.appstore.utils.a.x("com.bytedanceos.game.store.sync.my.apps", com.bytedanceos.appstore.utils.b.Z(r11));     // Catch: Throwable -> L14 Exception -> L16
    L28:
        monitor-exit(r14);     // Catch: Throwable -> L14
        return;
    L22:
        r19 = r10.getContentResolver().delete(AccountAppsColumns.URI, r15.toString(), null);     // Catch: Throwable -> L14 Exception -> L16
    L16:
        e = move-exception;
        j.b(" deleteInstalledHistory Exception:" + e.getMessage());     // Catch: Throwable -> L14
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static void g(ArrayList r10, Context r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L34;
        if (r11 == null) goto L35;
        Object r12 = f19321c;
        monitor-enter(r12);
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L15 Exception -> L17
        r13.append("app_packagename in (");     // Catch: Throwable -> L15 Exception -> L17
        int r14 = r10.size();     // Catch: Throwable -> L15 Exception -> L17
        Iterator r15 = r10.iterator();     // Catch: Throwable -> L15 Exception -> L17
    L11:
        if (r15.hasNext() == false) goto L20;
        r13.append("'" + ((AppInfo) r15.next()).appPackageName + "'");     // Catch: Throwable -> L15 Exception -> L17
        if (r14 <= 1) goto L19;
        r13.append(",");     // Catch: Throwable -> L15 Exception -> L17
    L19:
        r14 = r14 - 1;     // Catch: Throwable -> L15 Exception -> L17
        goto L11
    L20:
        r13.append(")");     // Catch: Throwable -> L15 Exception -> L17
        r11.getContentResolver().delete(WifiDownloadAppsColumns.URI, r13.toString(), null);     // Catch: Throwable -> L15 Exception -> L17
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        j.b(" deleteInstalledHistory Exception:" + e.getMessage());     // Catch: Throwable -> L15
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L23
    L35:
        return;
    }

    public static boolean h(AppInfo r10, Context r11) {
        if (r10 != null) goto L5;
    L41:
        return false;
    L5:
        if (TextUtils.isEmpty(r10.appPackageName) == true) goto L41;
        String r12 = r10.appPackageName;
        Object r13 = f19321c;
        monitor-enter(r13);
        Cursor r14 = null;
        ContentResolver r15 = r11.getContentResolver();     // Catch: Throwable -> L28 Exception -> L30
        Uri r16 = Uri.withAppendedPath(WifiDownloadAppsColumns.URI, r12);     // Catch: Throwable -> L28 Exception -> L30
        Cursor r17 = r15.query(r16, null, null, null, null);     // Catch: Throwable -> L28 Exception -> L30
    L22:
        e = e;
        r14 = r17;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L28
        j.b("daleteWifiApps Exception:" + e.getMessage());     // Catch: Throwable -> L28
        if (r14 == null) goto L34;
        r14.close();     // Catch: Throwable -> L18
    L34:
        monitor-exit(r13);     // Catch: Throwable -> L18
        return false;
    L20:
        th = th;
        r14 = r17;
    L36:
        if (r14 == null) goto L38;
        r14.close();     // Catch: Throwable -> L18
    L38:
        throw th;     // Catch: Throwable -> L18
    L12:
        if (r17.getCount() == 0) goto L24;
        r11.getContentResolver().delete(r16, null, null);     // Catch: Throwable -> L20 Exception -> L22
        r17.close();     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
        return true;
    L24:
        j.a(" packageName not exist:" + r12);     // Catch: Throwable -> L20 Exception -> L22
        r17.close();     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
        return false;
    L30:
        e = e;
    L28:
        th = th;
    L18:
        th = move-exception;
        throw th;
    }

    public static JSONArray i(Context r10) {
        JSONArray r11 = new JSONArray();
        ContentResolver r12 = r10.getContentResolver();
        Cursor r13 = null;
        r13 = r12.query(InstalledAppsColumns.URI, b.f19327c, null, null, null);     // Catch: Throwable -> L11 Exception -> L13
    L4:
        if (r13 == null) goto L15;
        if (r13.moveToNext() == false) goto L15;
        String r14 = r13.getString(r13.getColumnIndex(CommonColumns.APP_PACKAGENAME));     // Catch: Throwable -> L11 Exception -> L13
        if (TextUtils.isEmpty(r14) == true) goto L4;
        r11.put(r14);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        if (r13 == null) goto L20;
    L16:
        r13.close();
    L20:
        return r11;
    L11:
        th = move-exception;
        if (r13 == null) goto L23;
        r13.close();
    L23:
        throw th;
    L13:
        e = move-exception;
        j.b(" getAllInstalledFullAppsInfo Exception:" + e.getMessage());     // Catch: Throwable -> L11
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r13 == null) goto L20;
        goto L20
    }

    public static Map j(Context r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        ContentResolver r12 = r10.getContentResolver();
        Cursor r13 = null;
        r13 = r12.query(InstalledAppsColumns.URI, null, null, null, null);     // Catch: Throwable -> L9 Exception -> L11
    L4:
        if (r13 == null) goto L13;
        if (r13.moveToNext() == false) goto L13;
        AppInfo r14 = InstalledAppsColumns.convertDBToAppInfo(r13);     // Catch: Throwable -> L9 Exception -> L11
        r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        if (r13 == null) goto L18;
    L14:
        r13.close();
    L18:
        return r11;
    L9:
        th = move-exception;
        if (r13 == null) goto L21;
        r13.close();
    L21:
        throw th;
    L11:
        e = move-exception;
        j.b(" getAllInstalledFullAppsInfo Exception:" + e.getMessage());     // Catch: Throwable -> L9
        e.printStackTrace();     // Catch: Throwable -> L9
        if (r13 == null) goto L18;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static ArrayList k(Context r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        HashMap r11 = new HashMap();
        ContentResolver r12 = r10.getContentResolver();
        Object r13 = f19319a;
        monitor-enter(r13);
        Cursor r14 = r12.query(AccountAppsColumns.URI, null, "mark_deleted = 1 ", null, null);     // Catch: Throwable -> L28 Exception -> L30
    L8:
        if (r14 == null) goto L21;
    L19:
        e = e;
    L32:
        j.b(" getMyApps Exception:" + e.getMessage());     // Catch: Throwable -> L17
        e.printStackTrace();     // Catch: Throwable -> L17
        if (r14 == null) goto L35;
        r14.close();     // Catch: Throwable -> L24
    L35:
        monitor-exit(r13);     // Catch: Throwable -> L24
        return null;
    L10:
        if (r14.moveToNext() == false) goto L21;
        AppInfo r15 = AccountAppsColumns.convertDBToAppInfo(r14);     // Catch: Throwable -> L17 Exception -> L19
        if (TextUtils.equals(r15.appPackageName, "com.bytedanceos.googleinstaller") == true) goto L8;
        if (r11.containsKey(r15.appPackageName) == true) goto L8;
        r11.put(r15.appPackageName, r15);     // Catch: Throwable -> L17 Exception -> L19
    L21:
        ArrayList r16 = new ArrayList(r11.values());     // Catch: Throwable -> L17 Exception -> L19
        if (r14 == null) goto L26;
        r14.close();     // Catch: Throwable -> L24
    L26:
        monitor-exit(r13);     // Catch: Throwable -> L24
        return r16;
    L17:
        Throwable th = th;
        ?? r17 = r12;
    L37:
        if (r17 == 0) goto L39;
        r17.close();     // Catch: Throwable -> L24
    L39:
        throw th;     // Catch: Throwable -> L24
    L30:
        e = e;
        r14 = null;
    L28:
        th = move-exception;
        r17 = 0;
        th = th;
    L24:
        th = move-exception;
        throw th;
    }

    public static Map l(Context r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        ContentResolver r12 = r10.getContentResolver();
        Cursor r13 = null;
        r13 = r12.query(AccountAppsColumns.URI, null, "mark_deleted = 0 ", null, "create_time DESC;");     // Catch: Throwable -> L14 Exception -> L16
    L4:
        if (r13 == null) goto L18;
        if (r13.moveToNext() == false) goto L18;
        AppInfo r14 = AccountAppsColumns.convertDBToAppInfo(r13);     // Catch: Throwable -> L14 Exception -> L16
        if (TextUtils.equals(r14.appPackageName, "com.bytedanceos.googleinstaller") == true) goto L4;
        if (r11.containsKey(r14.appPackageName) == true) goto L4;
        r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L14 Exception -> L16
    L18:
        if (r13 == null) goto L20;
        r13.close();
    L20:
        return r11;
    L16:
        e = move-exception;
        j.b(" getMyApps Exception:" + e.getMessage());     // Catch: Throwable -> L14
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r13 == null) goto L24;
        r13.close();
    L24:
        return r11;
    L14:
        th = move-exception;
        if (r13 == null) goto L27;
        r13.close();
    L27:
        throw th;
    }

    public static ArrayList m(Context r10) {
        ArrayList r11 = new ArrayList();
        Cursor r12 = null;
        r12 = r10.getContentResolver().query(InstalledAppsColumns.URI, new String[]{CommonColumns.APP_PACKAGENAME}, "app_synced =? ", new String[]{String.valueOf(0)}, null);     // Catch: Throwable -> L14 Exception -> L16
        if (r12 != null) goto L6;
    L20:
        if (r12 == null) goto L22;
        r12.close();
    L22:
        return r11;
    L6:
        if (r12.getCount() == 0) goto L20;
    L9:
        if (r12.moveToNext() == false) goto L18;
        int r13 = r12.getColumnIndex(CommonColumns.APP_PACKAGENAME);     // Catch: Throwable -> L14 Exception -> L16
        if (r13 == (-1)) goto L9;
        AppInfo r14 = new AppInfo();     // Catch: Throwable -> L14 Exception -> L16
        r14.appPackageName = r12.getString(r13);     // Catch: Throwable -> L14 Exception -> L16
        r11.add(r14);     // Catch: Throwable -> L14 Exception -> L16
    L18:
        r12.close();
        return r11;
    L16:
        e = move-exception;
        j.b(" getInstalledSyncApps Exception:" + e.getMessage());     // Catch: Throwable -> L14
        e.printStackTrace();     // Catch: Throwable -> L14
        if (r12 == null) goto L26;
        r12.close();
    L26:
        return r11;
    L14:
        th = move-exception;
        if (r12 == null) goto L29;
        r12.close();
    L29:
        throw th;
    }

    public static Map n(Context r10) {
        LinkedHashMap r11 = new LinkedHashMap();
        ContentResolver r12 = r10.getContentResolver();
        Cursor r13 = null;
        r13 = r12.query(WifiDownloadAppsColumns.URI, null, null, null, "create_time ASC;");     // Catch: Throwable -> L11 Exception -> L13
    L4:
        if (r13 == null) goto L15;
        if (r13.moveToNext() == false) goto L15;
        AppInfo r14 = WifiDownloadAppsColumns.convertDBToAppInfo(r13);     // Catch: Throwable -> L11 Exception -> L13
        r14.appState = 4;     // Catch: Throwable -> L11 Exception -> L13
        if (r11.containsKey(r14.appPackageName) == true) goto L4;
        r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        if (r13 == null) goto L17;
        r13.close();
    L17:
        return r11;
    L11:
        th = move-exception;
        if (r13 == null) goto L24;
        r13.close();
    L24:
        throw th;
    L13:
        e = move-exception;
        j.b(" getWifiApps Exception:" + e.getMessage());     // Catch: Throwable -> L11
        e.printStackTrace();     // Catch: Throwable -> L11
        if (r13 == null) goto L21;
        r13.close();
    L21:
        return r11;
    }

    public static int o(Map r10, Context r11) {
        Object r12 = f19320b;
        monitor-enter(r12);
        int r13 = 0;
        ContentResolver r14 = r11.getContentResolver();     // Catch: Throwable -> L11 Exception -> L13
        r14.delete(AccountCollectionsColumns.URI, null, null);     // Catch: Throwable -> L11 Exception -> L13
        Iterator r15 = r10.values().iterator();     // Catch: Throwable -> L11 Exception -> L13
        ArrayList<ContentProviderOperation> r16 = new ArrayList();     // Catch: Throwable -> L11 Exception -> L13
    L7:
        if (r15.hasNext() == false) goto L17;
        AppInfo r17 = (AppInfo) r15.next();     // Catch: Throwable -> L11 Exception -> L13
        ContentValues r18 = new ContentValues();     // Catch: Throwable -> L11 Exception -> L13
        r18.put("app_id", r17.appId);     // Catch: Throwable -> L11 Exception -> L13
        r18.put("app_name", r17.appName);     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_PACKAGENAME, r17.appPackageName);     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_ICON, r17.appIcon);     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_CATEGORY, r17.appCategoryName);     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_SCORES, Float.valueOf(r17.appScores));     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r17.appVersionCode));     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_DOWNLOADURL, r17.appDownloadUrl);     // Catch: Throwable -> L11 Exception -> L13
        r18.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_OPTIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));     // Catch: Throwable -> L11 Exception -> L13
        r18.put(AccountCollectionsColumns.APP_COLLECT, Integer.valueOf(r17.isCollected ? 1 : 0));     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_SYNC, 1);     // Catch: Throwable -> L11 Exception -> L13
        r18.put(CommonColumns.APP_SIZE, Long.valueOf(r17.appBytes));     // Catch: Throwable -> L11 Exception -> L13
        r18.put("soft_type", Integer.valueOf(r17.getSoftType()));     // Catch: Throwable -> L11 Exception -> L13
        AppInfo.From r19 = r17.appFrom;     // Catch: Throwable -> L11 Exception -> L13
        if (r19 != null) goto L15;
        String r20 = "";
    L16:
        r18.put(CommonColumns.APP_MARK, r20);     // Catch: Throwable -> L11 Exception -> L13
        r16.add(ContentProviderOperation.newInsert(AccountCollectionsColumns.URI).withValues(r18).build());     // Catch: Throwable -> L11 Exception -> L13
        r13 = r13 + 1;     // Catch: Throwable -> L11 Exception -> L13
        goto L7
    L15:
        r20 = r19.mark;     // Catch: Throwable -> L11 Exception -> L13
        goto L16
    L17:
        r14.applyBatch(CommonColumns.AUTHORITY, r16);     // Catch: Throwable -> L11 Exception -> L13
    L20:
        monitor-exit(r12);     // Catch: Throwable -> L11
        return r13;
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        j.b(" initCollectionsToDB Exception:" + e.getMessage());     // Catch: Throwable -> L11
        e.printStackTrace();     // Catch: Throwable -> L11
        goto L20
    }

    public static synchronized int p(Context r10, Map r11) {
        monitor-enter(a.class);
        int r12 = 0;
        ContentResolver r13 = r10.getContentResolver();     // Catch: Throwable -> L9 Exception -> L11
        r13.delete(InstalledAppsColumns.URI, null, null);     // Catch: Throwable -> L9 Exception -> L11
        Iterator r14 = r11.values().iterator();     // Catch: Throwable -> L9 Exception -> L11
        ArrayList<ContentProviderOperation> r15 = new ArrayList();     // Catch: Throwable -> L9 Exception -> L11
    L7:
        if (r14.hasNext() == false) goto L13;
        ContentValues r16 = InstalledAppsColumns.convertAppInfoToValues((AppInfo) r14.next());     // Catch: Throwable -> L9 Exception -> L11
        r16.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L9 Exception -> L11
        r15.add(ContentProviderOperation.newInsert(InstalledAppsColumns.URI).withValues(r16).build());     // Catch: Throwable -> L9 Exception -> L11
        r12 = r12 + 1;     // Catch: Throwable -> L9 Exception -> L11
        goto L7
    L13:
        r13.applyBatch(CommonColumns.AUTHORITY, r15);     // Catch: Throwable -> L9 Exception -> L11
    L16:
        monitor-exit(a.class);
        return r12;
    L11:
        e = move-exception;
        j.b(" initInstalledAppsToDB Exception:" + e.getMessage());     // Catch: Throwable -> L9
        e.printStackTrace();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static int q(Map r11, Context r12, boolean r13) {
        Object r10 = f19319a;
        monitor-enter(r10);
        int r14 = 0;
        if (r13 == false) goto L11;
        d(r12);     // Catch: Throwable -> L7 Exception -> L9
        Map r15 = null;
    L12:
        ContentResolver r16 = r12.getContentResolver();     // Catch: Throwable -> L7 Exception -> L9
        Iterator r17 = r11.values().iterator();     // Catch: Throwable -> L7 Exception -> L9
        int r18 = r11.size();     // Catch: Throwable -> L7 Exception -> L9
        ArrayList<ContentProviderOperation> r19 = new ArrayList();     // Catch: Throwable -> L7 Exception -> L9
        long r20 = System.currentTimeMillis();     // Catch: Throwable -> L7 Exception -> L9
        int r21 = 0;
    L36:
    L22:
        e = e;
        r14 = r21;
    L28:
        j.b(" initMyAppsToDB Exception:" + e.getMessage());     // Catch: Throwable -> L7
        e.printStackTrace();     // Catch: Throwable -> L7
        r21 = r14;
    L29:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r21;
    L15:
        if (r17.hasNext() == false) goto L26;
        AppInfo r22 = (AppInfo) r17.next();     // Catch: Throwable -> L7 Exception -> L22
        ContentValues r23 = AccountAppsColumns.convertAppInfoToValues(r22, ((long) (r18 - r14)) + r20);     // Catch: Throwable -> L7 Exception -> L22
        if (r13 == true) goto L24;
        if (r15 == null) goto L24;
        if (r15.containsKey(r22.appPackageName) == false) goto L24;
        ContentProviderOperation r24 = ContentProviderOperation.newUpdate(Uri.withAppendedPath(AccountAppsColumns.URI, r22.appPackageName)).withValues(r23).build();     // Catch: Throwable -> L7 Exception -> L22
    L25:
        r19.add(r24);     // Catch: Throwable -> L7 Exception -> L22
        r21 = r21 + 1;     // Catch: Throwable -> L7 Exception -> L22
        r14 = r14 + 1;     // Catch: Throwable -> L7 Exception -> L22
    L24:
        r24 = ContentProviderOperation.newInsert(AccountAppsColumns.URI).withValues(r23).build();     // Catch: Throwable -> L7 Exception -> L22
        goto L25
    L26:
        r16.applyBatch(CommonColumns.AUTHORITY, r19);     // Catch: Throwable -> L7 Exception -> L22
        goto L29
    L11:
        r15 = l(r12);     // Catch: Throwable -> L7 Exception -> L9
    L9:
        e = e;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean r(Context r16, AppInfo r17) {
        if (r17 != null) goto L5;
    L52:
        return false;
    L5:
        if (TextUtils.isEmpty(r17.appPackageName) == true) goto L52;
        String r10 = r17.appPackageName;
        boolean r11 = r17.isCollected;
        Object r12 = f19320b;
        monitor-enter(r12);
        Cursor r13 = null;
        ContentResolver r14 = r16.getContentResolver();     // Catch: Throwable -> L13 Exception -> L15
        Uri r15 = AccountCollectionsColumns.URI;     // Catch: Throwable -> L13 Exception -> L15
        Uri r18 = Uri.withAppendedPath(r15, r10);     // Catch: Throwable -> L13 Exception -> L15
        ContentValues r19 = new ContentValues();     // Catch: Throwable -> L13 Exception -> L15
        r19.put(AccountCollectionsColumns.APP_COLLECT, Integer.valueOf(r11 ? 1 : 0));     // Catch: Throwable -> L13 Exception -> L15
        r19.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L13 Exception -> L15
        r19.put("soft_type", Integer.valueOf(r17.getSoftType()));     // Catch: Throwable -> L13 Exception -> L15
        r19.put(CommonColumns.APP_OPTIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));     // Catch: Throwable -> L13 Exception -> L15
        r19.put("app_name", r17.appName);     // Catch: Throwable -> L13 Exception -> L15
        r19.put(CommonColumns.APP_CATEGORY, r17.appCategoryName);     // Catch: Throwable -> L13 Exception -> L15
        AppInfo.From r20 = r17.appFrom;     // Catch: Throwable -> L13 Exception -> L15
        if (r20 != null) goto L17;
        String r21 = "";
    L18:
        r19.put(CommonColumns.APP_MARK, r21);     // Catch: Throwable -> L13 Exception -> L15
        Cursor r22 = r14.query(r18, null, null, null, null);     // Catch: Throwable -> L13 Exception -> L15
    L24:
        e = e;
        r13 = r22;
    L41:
        e.printStackTrace();     // Catch: Throwable -> L13
        j.b(" updateCollection Exception:" + e.getMessage());     // Catch: Throwable -> L13
        if (r13 == null) goto L44;
        r13.close();     // Catch: Throwable -> L39
    L44:
        monitor-exit(r12);     // Catch: Throwable -> L39
        return false;
    L22:
        th = th;
        r13 = r22;
    L47:
        if (r13 == null) goto L49;
        r13.close();     // Catch: Throwable -> L39
    L49:
        throw th;     // Catch: Throwable -> L39
    L20:
        if (r22.getCount() != 0) goto L27;
        r19.put("app_id", r17.appId);     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_PACKAGENAME, r10);     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_ICON, r17.appIcon);     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_SCORES, Float.valueOf(r17.appScores));     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_DOWNLOADURL, r17.appDownloadUrl);     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_SIZE, Long.valueOf(r17.appBytes));     // Catch: Throwable -> L22 Exception -> L24
        r19.put(CommonColumns.APP_SYNC, 0);     // Catch: Throwable -> L22 Exception -> L24
        r14.insert(r15, r19);     // Catch: Throwable -> L22 Exception -> L24
    L32:
        if (r17.getSoftType() == 1) goto L34;
    L36:
        r22.close();     // Catch: Throwable -> L39
        monitor-exit(r12);     // Catch: Throwable -> L39
        return true;
    L34:
        if (r17.isNeededSync == false) goto L36;
        com.bytedanceos.appstore.utils.a.x("com.bytedanceos.game.store.sync.collection.apps", com.bytedanceos.appstore.utils.b.Y(r17));     // Catch: Throwable -> L22 Exception -> L24
    L27:
        if (r17.isNeededSync == false) goto L29;
        r19.put(CommonColumns.APP_SYNC, 0);     // Catch: Throwable -> L22 Exception -> L24
    L30:
        r14.update(r18, r19, null, null);     // Catch: Throwable -> L22 Exception -> L24
        goto L32
    L29:
        r19.put(CommonColumns.APP_SYNC, 1);     // Catch: Throwable -> L22 Exception -> L24
        goto L30
    L17:
        r21 = r20.mark;     // Catch: Throwable -> L13 Exception -> L15
    L39:
        th = move-exception;
        throw th;
    L15:
        e = e;
    L13:
        th = th;
        goto L47
    }

    public static boolean s(Context r10, String r11, float r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return false;
    L5:
        Object r13 = f19320b;
        monitor-enter(r13);
        ContentResolver r14 = r10.getContentResolver();     // Catch: Throwable -> L11 Exception -> L13
        Uri r15 = Uri.withAppendedPath(AccountCollectionsColumns.URI, r11);     // Catch: Throwable -> L11 Exception -> L13
        ContentValues r16 = new ContentValues();     // Catch: Throwable -> L11 Exception -> L13
        r16.put(CommonColumns.APP_SCORES, Float.valueOf(r12));     // Catch: Throwable -> L11 Exception -> L13
        r14.update(r15, r16, null, null);     // Catch: Throwable -> L11 Exception -> L13
        monitor-exit(r13);     // Catch: Throwable -> L11
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        j.b(" updateCollection Exception:" + e.getMessage());     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public static void t(Context r10, AppInfo r11) {
        ContentResolver r12 = r10.getContentResolver();
        Uri r13 = InstalledAppsColumns.URI;
        Uri r14 = Uri.withAppendedPath(r13, r11.appPackageName);
        Cursor r15 = null;
        Cursor r16 = r12.query(r14, null, null, null, null);     // Catch: Throwable -> L13 Exception -> L15
    L9:
        e = e;
        r15 = r16;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L13
        j.b(" addInstalledApp Exception:" + e.getMessage());     // Catch: Throwable -> L13
        if (r15 == null) goto L23;
        r15.close();
    L23:
        return;
    L7:
        th = th;
        r15 = r16;
    L20:
        if (r15 == null) goto L22;
        r15.close();
    L22:
        throw th;
    L5:
        if (r16.getCount() != 0) goto L11;
        ContentValues r17 = InstalledAppsColumns.convertAppInfoToValues(r11);     // Catch: Throwable -> L7 Exception -> L9
        r17.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L7 Exception -> L9
        r12.insert(r13, r17);     // Catch: Throwable -> L7 Exception -> L9
    L12:
        r16.close();
        goto L23
    L11:
        r12.update(r14, InstalledAppsColumns.convertAppInfoToValues(r11), null, null);     // Catch: Throwable -> L7 Exception -> L9
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    public static boolean u(Context r10, String r11, float r12) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return false;
    L5:
        Object r13 = f19319a;
        monitor-enter(r13);
        ContentResolver r14 = r10.getContentResolver();     // Catch: Throwable -> L11 Exception -> L13
        Uri r15 = Uri.withAppendedPath(AccountAppsColumns.URI, r11);     // Catch: Throwable -> L11 Exception -> L13
        ContentValues r16 = new ContentValues();     // Catch: Throwable -> L11 Exception -> L13
        r16.put(CommonColumns.APP_SCORES, Float.valueOf(r12));     // Catch: Throwable -> L11 Exception -> L13
        r14.update(r15, r16, null, null);     // Catch: Throwable -> L11 Exception -> L13
        monitor-exit(r13);     // Catch: Throwable -> L11
        return true;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        j.b(" updateMyApp Exception:" + e.getMessage());     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public static void v(Context r10, ArrayList r11, boolean r12) {
        ContentValues r13 = new ContentValues();     // Catch: Exception -> L8
        int r14 = 0;
        r13.put(CommonColumns.APP_SYNC, Integer.valueOf(r12 ? 1 : 0));     // Catch: Exception -> L8
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L8
        r15.append("app_packagename in (");     // Catch: Exception -> L8
        int r16 = r11.size();     // Catch: Exception -> L8
    L4:
        if (r14 >= r16) goto L11;
        r15.append("'" + ((AppInfo) r11.get(r14)).appPackageName + "'");     // Catch: Exception -> L8
        if (r14 >= (r16 - 1)) goto L10;
        r15.append(",");     // Catch: Exception -> L8
    L10:
        r14 = r14 + 1;     // Catch: Exception -> L8
        goto L4
    L11:
        r15.append(")");     // Catch: Exception -> L8
        j.a("updateSyncInstalledApps rows = " + r10.getContentResolver().update(InstalledAppsColumns.URI, r13, r15.toString(), null));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        j.a("updateSyncInstalledApps Exception:" + e.getMessage());
    }
}
