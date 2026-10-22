package com.bytedanceos.common.model.database;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AdsReportRecordInfo;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.SearchHotWords;
import com.bytedanceos.common.model.database.columns.AccountAppsColumns;
import com.bytedanceos.common.model.database.columns.AccountCollectionsColumns;
import com.bytedanceos.common.model.database.columns.AdsReportRecordColumns;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.model.database.columns.MyAppsColumns;
import com.bytedanceos.common.model.database.columns.ReservedAppsColumns;
import com.bytedanceos.common.model.database.columns.SearchHistoryColums;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pg.a;
import rx.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class DataBaseManager {

    public static class AccountCollectionsTable {
        public AccountCollectionsTable() {
        }

        public static List<AppInfo> getCollectionsToReport(Context r10) {
            ArrayList r11 = new ArrayList();
            ContentResolver r12 = r10.getContentResolver();
            Cursor r13 = null;
            Cursor r14 = r12.query(AccountCollectionsColumns.URI, null, "app_synced =? ", new String[]{String.valueOf(0)}, null);     // Catch: Throwable -> L16 Exception -> L18
            ContentValues r15 = new ContentValues();     // Catch: Throwable -> L10 Exception -> L12
            r15.put(CommonColumns.APP_REPORT, 1);     // Catch: Throwable -> L10 Exception -> L12
        L5:
            if (r14 == null) goto L14;
            if (r14.moveToNext() == false) goto L14;
            AppInfo r16 = AccountCollectionsColumns.convertDBToAppInfo(r14);     // Catch: Throwable -> L10 Exception -> L12
            r11.add(r16);     // Catch: Throwable -> L10 Exception -> L12
            r12.update(Uri.withAppendedPath(AccountAppsColumns.URI, r16.appPackageName), r15, null, null);     // Catch: Throwable -> L10 Exception -> L12
        L14:
            if (r14 == null) goto L26;
            r14.close();
        L26:
            return r11;
        L12:
            e = e;
            r13 = r14;
        L19:
            j.e(e.getMessage());     // Catch: Throwable -> L16
            if (r13 == null) goto L26;
            r13.close();
        L10:
            th = th;
            r13 = r14;
        L23:
            if (r13 == null) goto L25;
            r13.close();
        L25:
            throw th;
        L16:
            th = th;
        L18:
            e = e;
            goto L19
        }

        public static void updateCollectionsReportState(Context r10, boolean r11) {
            ContentResolver r12 = r10.getContentResolver();     // Catch: Exception -> L6
            ContentValues r13 = new ContentValues();     // Catch: Exception -> L6
            if (r11 == false) goto L8;
            r13.put(CommonColumns.APP_SYNC, 1);     // Catch: Exception -> L6
            r13.put(CommonColumns.APP_REPORT, 0);     // Catch: Exception -> L6
        L9:
            r12.update(AccountCollectionsColumns.URI, r13, "app_report =? ", new String[]{String.valueOf(1)});     // Catch: Exception -> L6
            return;
        L8:
            r13.put(CommonColumns.APP_SYNC, 0);     // Catch: Exception -> L6
            r13.put(CommonColumns.APP_REPORT, 0);     // Catch: Exception -> L6
        L6:
            e = move-exception;
            j.e(e.getMessage());
        }
    }

    public static class AccountTable {
        public AccountTable() {
        }

        public static Map<String, AppInfo> getMyAppsToReport(Context r10) {
            HashMap r11 = new HashMap();
            ContentResolver r12 = r10.getContentResolver();
            Cursor r13 = null;
            Cursor r14 = r12.query(AccountAppsColumns.URI, null, "app_synced =? AND mark_deleted = 0 ", new String[]{String.valueOf(0)}, null);     // Catch: Throwable -> L16 Exception -> L18
            ContentValues r15 = new ContentValues();     // Catch: Throwable -> L10 Exception -> L12
            r15.put(CommonColumns.APP_REPORT, 1);     // Catch: Throwable -> L10 Exception -> L12
        L5:
            if (r14 == null) goto L14;
            if (r14.moveToNext() == false) goto L14;
            AppInfo r16 = AccountAppsColumns.convertDBToAppInfo(r14);     // Catch: Throwable -> L10 Exception -> L12
            r11.put(r16.appPackageName, r16);     // Catch: Throwable -> L10 Exception -> L12
            r12.update(Uri.withAppendedPath(AccountAppsColumns.URI, r16.appPackageName), r15, null, null);     // Catch: Throwable -> L10 Exception -> L12
        L14:
            if (r14 == null) goto L26;
            r14.close();
        L26:
            return r11;
        L12:
            e = e;
            r13 = r14;
        L19:
            j.e(e.getMessage());     // Catch: Throwable -> L16
            if (r13 == null) goto L26;
            r13.close();
        L10:
            th = th;
            r13 = r14;
        L23:
            if (r13 == null) goto L25;
            r13.close();
        L25:
            throw th;
        L16:
            th = th;
        L18:
            e = e;
            goto L19
        }

        public static void updateMyAppsReportState(final Context r10, final boolean r11) {
            Observable.d("").s(a.c()).p(new AnonymousClass1(r10, r11));
        }
    }

    public static class AdsReportRecordTable {
        public AdsReportRecordTable() {
        }

        public static void addReportRecord(AdsReportRecordInfo r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (URLUtil.isNetworkUrl(r10.mReportUrl) == false) goto L32;
            ContentResolver r11 = BaseApplication.c().getContentResolver();
            StringBuilder r12 = new StringBuilder();
            r12.append("title=='" + r10.mTitle + "'");
            r12.append(" AND ");
            r12.append("event_type==" + r10.mEventType);
            r12.append(" AND ");
            r12.append("ads_owner==" + r10.mTaskOwner);
            Cursor r13 = null;
            Uri r14 = AdsReportRecordColumns.URI;     // Catch: Throwable -> L13 Exception -> L15
            r13 = r11.query(r14, null, r12.toString(), null, null);     // Catch: Throwable -> L13 Exception -> L15
            if (r13 != null) goto L10;
        L17:
            r11.insert(r14, AdsReportRecordColumns.convertRecordInfoValues(r10));     // Catch: Throwable -> L13 Exception -> L15
        L18:
            if (r13 == null) goto L23;
        L19:
            r13.close();
            return;
        L23:
            return;
        L10:
            if (r13.getCount() == 0) goto L17;
            j.e("ads report exist! ");     // Catch: Throwable -> L13 Exception -> L15
        L15:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L13
            if (0 != 0) goto L19;
            return;
        L13:
            th = move-exception;
            if (0 == 0) goto L26;
            r13.close();
        L26:
            throw th;
        }

        public static void deleteReportRecord(AdsReportRecordInfo r10) {
            if (r10 != null) goto L4;
        L11:
            j.n("url is null.");
            return;
        L4:
            if (TextUtils.isEmpty(r10.mUrlMD5) == true) goto L11;
            j.n("----->delete:" + BaseApplication.c().getContentResolver().delete(AdsReportRecordColumns.URI, "url_md5=='" + r10.mUrlMD5 + "'", null) + " | " + r10);     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            j.e(e.getMessage());
        }

        private static boolean hasReportRecordExpired(AdsReportRecordInfo r10) {
            if (r10 != null) goto L6;
            return false;
        L6:
            if (((int) ((System.currentTimeMillis() - r10.mEventTime) / 86400000)) < 2) goto L9;
            return true;
        L9:
            return false;
        }

        private static boolean isValidReportRecordRetry(AdsReportRecordInfo r10) {
            if (r10 != null) goto L5;
            return false;
        L5:
            int r11 = (int) ((System.currentTimeMillis() - r10.mEventTime) / 86400000);
            int r12 = (r11 + 1) * 5;
            int r13 = r11 * 5;
            if (r11 >= 2) goto L14;
            int r14 = r10.mRetriedCount;
            if (r14 >= r13) goto L11;
            r10.mRetriedCount = r13 + 1;
            return true;
        L11:
            if (r14 >= r12) goto L14;
            r10.mRetriedCount = r14 + 1;
            return true;
        L14:
            return false;
        }

        public static ArrayList<AdsReportRecordInfo> queryReportRecord() {
            ContentResolver r10 = BaseApplication.c().getContentResolver();
            if (BaseApplication.c().o() == false) goto L6;
            String r11 = "ads_owner==1";
        L5:
            String r12 = r11;
            ArrayList<AdsReportRecordInfo> r13 = new ArrayList();
            Cursor r14 = null;
            Cursor r15 = r10.query(AdsReportRecordColumns.URI, null, r12, null, "event_type ASC");     // Catch: Throwable -> L30 Exception -> L32
            if (r15 != null) goto L44;
        L27:
            if (r15 == null) goto L29;
            r15.close();
        L29:
            return null;
        L44:
        L20:
            e = e;
            r14 = r15;
        L33:
            j.e(e.getMessage());     // Catch: Throwable -> L30
            if (r14 == null) goto L40;
            r14.close();
        L40:
            return r13;
        L18:
            th = th;
            r14 = r15;
        L37:
            if (r14 == null) goto L39;
            r14.close();
        L39:
            throw th;
        L11:
            if (r15.getCount() == 0) goto L27;
        L13:
            if (r15.moveToNext() == false) goto L26;
            AdsReportRecordInfo r16 = AdsReportRecordColumns.convertDBToRecordInfo(r15);     // Catch: Throwable -> L18 Exception -> L20
            if (hasReportRecordExpired(r16) == true) goto L17;
            if (isValidReportRecordRetry(r16) == false) goto L13;
            r13.add(r16);     // Catch: Throwable -> L18 Exception -> L20
            goto L13
        L17:
            deleteReportRecord(r16);     // Catch: Throwable -> L18 Exception -> L20
            goto L13
        L26:
            r15.close();
            goto L40
        L30:
            th = th;
        L32:
            e = e;
            goto L33
        L6:
            r11 = "ads_owner==2";
            goto L5
        }

        public static void updateFailedReportRecord(AdsReportRecordInfo r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (TextUtils.isEmpty(r10.mUrlMD5) == true) goto L14;
            ContentResolver r11 = BaseApplication.c().getContentResolver();     // Catch: Exception -> L8
            ContentValues r12 = new ContentValues();     // Catch: Exception -> L8
            r12.put(AdsReportRecordColumns.ADS_RETRY_COUNT, Integer.valueOf(r10.mRetriedCount));     // Catch: Exception -> L8
            r11.update(AdsReportRecordColumns.URI, r12, "url_md5 =? ", new String[]{r10.mUrlMD5});     // Catch: Exception -> L8
            return;
        L8:
            e = move-exception;
            j.e(e.getMessage());
            return;
        }
    }

    public static class DownloadInfoTable {
        private static Object mLock;

        static {
            mLock = new Object();
        }

        public DownloadInfoTable() {
        }

        public static void addDownloadTask(AppInfo r10) {
            ArrayList r11 = new ArrayList();
            r11.add(r10);
            addDownloadTask(r11);
        }

        public static Map<String, AppInfo> getAllDownloadTask(boolean r10) {
            if (r10 == true) goto L4;
            String r11 = "status <> 16";
        L6:
            return queryDownloadTaskByCase(r11);
        L4:
            r11 = null;
            goto L6
        }

        public static Map<String, AppInfo> getAllFailedDownloads() {
            return queryDownloadTaskByCase("status == 16");
        }

        public static ArrayList<AppInfo> getDownloadIcons(String[] r13) {
            ArrayList<AppInfo> r10 = new ArrayList();
            StringBuilder r11 = new StringBuilder();
            r11.append("app_packagename in (");
            int r12 = r13.length;
            int r14 = r13.length;
            int r15 = 0;
        L4:
            if (r15 >= r14) goto L9;
            r11.append("'" + r13[r15] + "'");
            if (r12 <= 1) goto L8;
            r11.append(",");
        L8:
            r12 = r12 - 1;
            r15 = r15 + 1;
            goto L4
        L9:
            r11.append(")");
            String[] r16 = {CommonColumns.APP_PACKAGENAME, CommonColumns.APP_ICON};
            Object r17 = mLock;
            monitor-enter(r17);
            Cursor r18 = null;
            r18 = BaseApplication.c().getContentResolver().query(DownloadInfoColumns.URI, r16, r11.toString(), null, null);     // Catch: Throwable -> L21 Exception -> L23
            if (r18 != null) goto L15;
        L28:
            if (r18 == null) goto L30;
            r18.close();     // Catch: Throwable -> L26
        L30:
            monitor-exit(r17);     // Catch: Throwable -> L26
            return r10;
        L15:
            if (r18.getCount() == 0) goto L28;
        L18:
            if (r18.moveToNext() == false) goto L25;
            AppInfo r19 = new AppInfo();     // Catch: Throwable -> L21 Exception -> L23
            r19.appPackageName = r18.getString(0);     // Catch: Throwable -> L21 Exception -> L23
            r19.appIcon = r18.getString(1);     // Catch: Throwable -> L21 Exception -> L23
            r10.add(r19);     // Catch: Throwable -> L21 Exception -> L23
        L25:
            r18.close();     // Catch: Throwable -> L26
        L35:
            monitor-exit(r17);     // Catch: Throwable -> L26
            return r10;
        L21:
            th = move-exception;
            if (r18 == null) goto L39;
            r18.close();     // Catch: Throwable -> L26
        L39:
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            throw th;
        L23:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L21
            if (r18 == null) goto L35;
            goto L35
        }

        public static Map<String, AppInfo> queryDownloadTaskByCase(String r10) {
            LinkedHashMap r11 = new LinkedHashMap();
            Cursor r12 = null;
            Object r13 = mLock;     // Catch: Throwable -> L29 Exception -> L31
            monitor-enter(r13);     // Catch: Throwable -> L29 Exception -> L31
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L29 Exception -> L31
        L6:
            if (r11.isEmpty() == false) goto L24;
            r12 = BaseApplication.c().getContentResolver().query(DownloadInfoColumns.URI, null, r10, null, null);     // Catch: Throwable -> L18
            if (r12 != null) goto L10;
        L20:
            monitor-exit(r13);     // Catch: Throwable -> L18
            if (r12 == null) goto L23;
            r12.close();
        L23:
            return r11;
        L10:
            if (r12.getCount() == 0) goto L20;
        L13:
            if (r12.moveToNext() == false) goto L24;
            AppInfo r14 = DownloadInfoColumns.convertDBToAppInfo(r12);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r14.appPackageName) == true) goto L13;
            r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L18
        L24:
            monitor-exit(r13);     // Catch: Throwable -> L18
            if (r12 == null) goto L35;
        L26:
            r12.close();
        L35:
            return r11;
        L29:
            th = move-exception;
            if (0 == 0) goto L38;
            r12.close();
        L38:
            throw th;
        L31:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L29
            if (0 == 0) goto L35;
            goto L35
        }

        public static AppInfo queryDownloadTaskByPackage(String r10) {
            Uri r11 = Uri.withAppendedPath(DownloadInfoColumns.URI, r10);
            if (BaseApplication.c().o() == false) goto L6;
            String r12 = "task_owner==0";
        L5:
            String r13 = r12;
            AppInfo r14 = null;
            Cursor r15 = BaseApplication.c().getContentResolver().query(r11, null, r13, null, null);     // Catch: Throwable -> L25 Exception -> L27
            if (r15 != null) goto L36;
        L22:
            if (r15 == null) goto L24;
            r15.close();
        L24:
            return null;
        L36:
        L19:
            e = e;
        L29:
            j.e(e.getMessage());     // Catch: Throwable -> L17
            if (r15 != null) goto L21;
        L32:
            return r14;
        L21:
            r15.close();
        L17:
            Throwable th = th;
        L33:
            if (r15 == null) goto L35;
            r15.close();
        L35:
            throw th;
        L11:
            if (r15.getCount() == 0) goto L22;
            if (r15.moveToFirst() == false) goto L21;
            r14 = DownloadInfoColumns.convertDBToAppInfo(r15);     // Catch: Throwable -> L17 Exception -> L19
            goto L21
        L27:
            e = e;
            r15 = null;
        L25:
            th = move-exception;
            r15 = null;
            th = th;
            goto L33
        L6:
            r12 = "task_owner==1";
            goto L5
        }

        public static void removeDownloadTask(List<AppInfo> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.isEmpty() == true) goto L33;
            Object r11 = mLock;     // Catch: Exception -> L22
            monitor-enter(r11);     // Catch: Exception -> L22
            StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L14
            r12.append("app_packagename in (");     // Catch: Throwable -> L14
            int r13 = r10.size();     // Catch: Throwable -> L14
            Iterator<AppInfo> r14 = r10.iterator();     // Catch: Throwable -> L14
        L10:
            if (r14.hasNext() == false) goto L17;
            r12.append("'" + r14.next().appPackageName + "'");     // Catch: Throwable -> L14
            if (r13 <= 1) goto L16;
            r12.append(",");     // Catch: Throwable -> L14
        L16:
            r13 = r13 - 1;     // Catch: Throwable -> L14
            goto L10
        L17:
            r12.append(")");     // Catch: Throwable -> L14
            BaseApplication.c().getContentResolver().delete(DownloadInfoColumns.URI, r12.toString(), null);     // Catch: Throwable -> L14
            j.a(r12.toString());     // Catch: Throwable -> L14
            monitor-exit(r11);     // Catch: Throwable -> L14
        L32:
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L22:
            e = move-exception;
            j.e(e.getMessage());
            return;
        }

        public static void updateDownloadTask(List<AppInfo> r10) {
            Observable.d(r10).s(a.c()).p(new AnonymousClass1());
        }

        public static void addDownloadTask(List<AppInfo> r10) {
            Map<String, AppInfo> r11 = getAllDownloadTask(true);
            ArrayList<ContentProviderOperation> r12 = new ArrayList();
            int r13 = 0;
        L4:
            if (r13 >= r10.size()) goto L18;
            AppInfo r14 = r10.get(r13);
            if (TextUtils.isEmpty(r14.appPackageName) == true) goto L12;
            ContentValues r15 = DownloadInfoColumns.convertAppInfoToValues(r14);
            if (r11.containsKey(r14.appPackageName) == false) goto L11;
            r12.add(ContentProviderOperation.newUpdate(Uri.withAppendedPath(DownloadInfoColumns.URI, r14.appPackageName)).withValues(r15).build());
            goto L12
        L11:
            r12.add(ContentProviderOperation.newInsert(DownloadInfoColumns.URI).withValues(r15).build());
        L12:
            r13 = r13 + 1;
            goto L4
        L18:
            BaseApplication.c().getContentResolver().applyBatch(CommonColumns.AUTHORITY, r12);     // Catch: Exception -> L15
            return;
        L15:
            e = move-exception;
            j.e(e.getMessage());
        }
    }

    public static class MyAppsTable {
        public MyAppsTable() {
        }

        public static void deleteApp(String r10) {
            BaseApplication.c().getContentResolver().delete(Uri.withAppendedPath(MyAppsColumns.URI, r10), null, null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            j.e(e.getMessage());
        }

        public static void deleteApps(List<String> r10) {
            if (r10 == null) goto L15;
            if (r10.size() <= 0) goto L15;
            StringBuilder r11 = new StringBuilder();
            r11.append("app_packagename in (");
            int r12 = r10.size();
            Iterator<String> r13 = r10.iterator();
        L8:
            if (r13.hasNext() == false) goto L13;
            r11.append("'" + r13.next() + "'");
            if (r12 <= 1) goto L12;
            r11.append(",");
        L12:
            r12 = r12 - 1;
            goto L8
        L13:
            r11.append(")");
            String r14 = r11.toString();
        L23:
            BaseApplication.c().getContentResolver().delete(MyAppsColumns.URI, r14, null);     // Catch: Exception -> L20
            return;
        L20:
            e = move-exception;
            j.e(e.getMessage());
            return;
        L15:
            if (BaseApplication.c().o() == true) goto L17;
            r14 = "soft_type==1";
            goto L23
        L17:
            r14 = null;
            goto L23
        }

        public static Map<String, AppInfo> getAllUpdateApps() {
            return query("app_update>0");
        }

        public static Map<String, AppInfo> getAutoUpdateApps() {
            return query("app_update==2");
        }

        public static void insert(Map<String, AppInfo> r10) {
            if (r10 != null) goto L4;
        L16:
            j.n("inserted local apps is empty.");
            return;
        L4:
            if (r10.isEmpty() == true) goto L16;
            ContentResolver r11 = BaseApplication.c().getContentResolver();     // Catch: Exception -> L10
            ArrayList<ContentProviderOperation> r12 = new ArrayList();     // Catch: Exception -> L10
            Iterator<AppInfo> r13 = r10.values().iterator();     // Catch: Exception -> L10
        L8:
            if (r13.hasNext() == false) goto L12;
            ContentValues r14 = MyAppsColumns.convertAppInfoToValues(r13.next());     // Catch: Exception -> L10
            r12.add(ContentProviderOperation.newInsert(MyAppsColumns.URI).withValues(r14).build());     // Catch: Exception -> L10
            goto L8
        L12:
            r11.applyBatch(CommonColumns.AUTHORITY, r12);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            j.e(e.getMessage());
        }

        public static Map<String, AppInfo> query(Map<String, AppInfo> r10) {
            if (r10 != null) goto L4;
        L13:
            String r11 = null;
        L15:
            return query(r11);
        L4:
            if (r10.size() <= 0) goto L13;
            StringBuilder r12 = new StringBuilder();
            r12.append("app_packagename in (");
            int r13 = r10.size();
            Iterator<AppInfo> r14 = r10.values().iterator();
        L7:
            if (r14.hasNext() == false) goto L12;
            r12.append("'" + r14.next().appPackageName + "'");
            if (r13 <= 1) goto L11;
            r12.append(",");
        L11:
            r13 = r13 - 1;
            goto L7
        L12:
            r12.append(")");
            r11 = r12.toString();
            goto L15
        }

        public static void update(AppInfo r10) {
            if (r10 != null) goto L10;
            j.a("hide update app info is null");
            return;
        L10:
            BaseApplication.c().getContentResolver().update(Uri.withAppendedPath(MyAppsColumns.URI, r10.appPackageName), MyAppsColumns.convertAppInfoToValues(r10), null, null);     // Catch: Exception -> L7
            j.n("update app: " + r10.appPackageName + "[versioncode: " + r10.appVersionCode + "  hidevode: " + r10.hideVersionCode + "]");     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            j.e(e.getMessage());
        }

        public static void update(Map<String, AppInfo> r10) {
            if (r10.size() <= 0) goto L15;
            ArrayList<ContentProviderOperation> r11 = new ArrayList();
            Iterator<AppInfo> r12 = r10.values().iterator();
        L6:
            if (r12.hasNext() == false) goto L13;
            AppInfo r13 = r12.next();
            ContentValues r14 = MyAppsColumns.convertAppInfoToValues(r13);
            r11.add(ContentProviderOperation.newUpdate(Uri.withAppendedPath(MyAppsColumns.URI, r13.appPackageName)).withValues(r14).build());
            goto L6
        L13:
            BaseApplication.c().getContentResolver().applyBatch(CommonColumns.AUTHORITY, r11);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            j.e(e.getMessage());
            return;
        }

        private static Map<String, AppInfo> query(String r10) {
            LinkedHashMap r11 = new LinkedHashMap();
            ContentResolver r12 = BaseApplication.c().getContentResolver();
            Cursor r13 = null;
        L10:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L8
            if (r13 != null) goto L20;
        L24:
            return r11;
        L20:
            r13.close();
        L8:
            th = move-exception;
            if (r13 == null) goto L27;
            r13.close();
        L27:
            throw th;
        L4:
            if (BaseApplication.c().o() == true) goto L13;
            if (r10 != null) goto L12;
            r10 = "soft_type==1";
            goto L13
        L12:
            r10 = r10 + " AND soft_type==1";     // Catch: Throwable -> L8 Exception -> L10
        L13:
            r13 = r12.query(MyAppsColumns.URI, null, r10, null, "_id DESC");     // Catch: Throwable -> L8 Exception -> L10
        L14:
            if (r13 == null) goto L19;
            if (r13.moveToNext() == false) goto L19;
            AppInfo r14 = MyAppsColumns.convertDBToAppInfo(r13);     // Catch: Throwable -> L8 Exception -> L10
            r14.appState = 64;     // Catch: Throwable -> L8 Exception -> L10
            r14.mApiUrl = BaseApplication.c().j();     // Catch: Throwable -> L8 Exception -> L10
            r11.put(r14.appPackageName, r14);     // Catch: Throwable -> L8 Exception -> L10
            goto L14
        L19:
            if (r13 == null) goto L24;
            goto L20
        }

        public static void insert(AppInfo r10) {
            ContentResolver r11 = BaseApplication.c().getContentResolver();
            Uri r12 = MyAppsColumns.URI;
            Cursor r13 = null;
            r13 = r11.query(Uri.withAppendedPath(r12, r10.appPackageName), null, null, null, null);     // Catch: Throwable -> L7 Exception -> L9
            if (r13.getCount() != 0) goto L11;
            r11.insert(r12, MyAppsColumns.convertAppInfoToValues(r10));     // Catch: Throwable -> L7 Exception -> L9
        L11:
            r13.close();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L7
            j.b(" add app to my app table Exception:" + e.getMessage());     // Catch: Throwable -> L7
            if (r13 != null) goto L11;
            return;
        L7:
            th = move-exception;
            if (r13 == null) goto L18;
            r13.close();
        L18:
            throw th;
        }
    }

    public static class ReserveApps {
        public ReserveApps() {
        }

        public static void deleteApp(String r10) {
            BaseApplication.c().getContentResolver().delete(Uri.withAppendedPath(ReservedAppsColumns.URI, r10), null, null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            j.e(e.getMessage());
        }

        public static Map<String, AppInfo> getReserveApps() {
            LinkedHashMap r10 = new LinkedHashMap();
            ContentResolver r11 = BaseApplication.c().getContentResolver();
            Cursor r12 = null;
            r12 = r11.query(ReservedAppsColumns.URI, null, null, null, "_id DESC");     // Catch: Throwable -> L9 Exception -> L11
        L4:
            if (r12 == null) goto L13;
            if (r12.moveToNext() == false) goto L13;
            AppInfo r13 = ReservedAppsColumns.convertDBToAppInfo(r12);     // Catch: Throwable -> L9 Exception -> L11
            r10.put(r13.appPackageName, r13);     // Catch: Throwable -> L9 Exception -> L11
        L13:
            if (r12 == null) goto L18;
        L14:
            r12.close();
        L18:
            return r10;
        L11:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L9
            if (r12 == null) goto L18;
        L9:
            th = move-exception;
            if (r12 == null) goto L21;
            r12.close();
        L21:
            throw th;
        }

        public static void insert(Map<String, AppInfo> r10) {
            if (r10 != null) goto L4;
        L16:
            j.n("inserted local apps is empty.");
            return;
        L4:
            if (r10.isEmpty() == true) goto L16;
            ContentResolver r11 = BaseApplication.c().getContentResolver();     // Catch: Exception -> L10
            ArrayList<ContentProviderOperation> r12 = new ArrayList();     // Catch: Exception -> L10
            Iterator<AppInfo> r13 = r10.values().iterator();     // Catch: Exception -> L10
        L8:
            if (r13.hasNext() == false) goto L12;
            ContentValues r14 = ReservedAppsColumns.convertAppInfoToValues(r13.next());     // Catch: Exception -> L10
            r12.add(ContentProviderOperation.newInsert(ReservedAppsColumns.URI).withValues(r14).build());     // Catch: Exception -> L10
            goto L8
        L12:
            r11.applyBatch(CommonColumns.AUTHORITY, r12);     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            j.e(e.getMessage());
        }
    }

    public static class SearchHistory {
        public SearchHistory() {
        }

        public static void clearSearchHistory() {
            BaseApplication.c().getContentResolver().delete(SearchHistoryColums.getUri(BaseApplication.c()), null, null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            j.e(e.getMessage());
        }

        public static List<SearchHotWords> readSearchHistory() {
            Uri r10 = SearchHistoryColums.getUri(BaseApplication.c());
            ArrayList r11 = new ArrayList();
            ContentResolver r12 = BaseApplication.c().getContentResolver();
            long r13 = 0;
            Cursor r14 = null;
            r14 = r12.query(r10, new String[]{"keyword", "create_time"}, null, null, "create_time DESC limit 5;");     // Catch: Throwable -> L11 Exception -> L13
        L4:
            if (r14 == null) goto L15;
            if (r14.moveToNext() == false) goto L15;
            String r15 = r14.getString(0);     // Catch: Throwable -> L11 Exception -> L13
            r13 = r14.getLong(1);     // Catch: Throwable -> L11 Exception -> L13
            if (TextUtils.isEmpty(r15) == true) goto L4;
            SearchHotWords r16 = new SearchHotWords();     // Catch: Throwable -> L11 Exception -> L13
            r16.setKeyword(r15);     // Catch: Throwable -> L11 Exception -> L13
            r11.add(r16);     // Catch: Throwable -> L11 Exception -> L13
        L15:
            if (r14 == null) goto L21;
        L16:
            r14.close();
        L21:
            if (r11.size() == 5) goto L31;
        L26:
            return r11;
        L31:
            j.e("readSearchHistory remove " + r12.delete(r10, "create_time < ?", new String[]{String.valueOf(r13)}) + " search history");     // Catch: Exception -> L24
        L24:
            e = move-exception;
            e.printStackTrace();
        L11:
            th = move-exception;
            if (r14 == null) goto L29;
            r14.close();
        L29:
            throw th;
        L13:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L11
            if (r14 == null) goto L21;
            goto L16
        }

        public static void saveSearchHistory(String r10) {
            ContentResolver r11 = BaseApplication.c().getContentResolver();
            Uri r12 = SearchHistoryColums.getUri(BaseApplication.c());
            Cursor r13 = null;
            String r14 = r10.replace("'", "''");     // Catch: Throwable -> L6 Exception -> L8
            r13 = r11.query(r12, new String[]{SearchHistoryColums.USE_COUNT}, "keyword = ?", new String[]{r14}, null);     // Catch: Throwable -> L6 Exception -> L8
            ContentValues r15 = new ContentValues();     // Catch: Throwable -> L6 Exception -> L8
            r15.put("keyword", r14);     // Catch: Throwable -> L6 Exception -> L8
            r15.put("create_time", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6 Exception -> L8
            if (r13.getCount() <= 0) goto L10;
            r13.moveToFirst();     // Catch: Throwable -> L6 Exception -> L8
            r15.put(SearchHistoryColums.USE_COUNT, Integer.valueOf(r13.getInt(r13.getColumnIndexOrThrow(SearchHistoryColums.USE_COUNT)) + 1));     // Catch: Throwable -> L6 Exception -> L8
            r11.update(r12, r15, "keyword = ?", new String[]{r14});     // Catch: Throwable -> L6 Exception -> L8
        L19:
        L11:
            r13.close();
            return;
        L10:
            r15.put(SearchHistoryColums.USE_COUNT, 1);     // Catch: Throwable -> L6 Exception -> L8
            r11.insert(r12, r15);     // Catch: Throwable -> L6 Exception -> L8
        L8:
            e = move-exception;
            j.e(e.getMessage());     // Catch: Throwable -> L6
            if (r13 != null) goto L11;
            return;
        L6:
            th = move-exception;
            if (r13 == null) goto L18;
            r13.close();
        L18:
            throw th;
        }
    }

    public DataBaseManager() {
    }
}
