package com.smt.obric.appstore.domain.app.db;

import androidx.room.RoomDatabase;
import androidx.room.m;
import androidx.room.q0;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import b0.b;
import com.bytedanceos.common.ad.param.AdReportParam;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import ge.c;
import ge.d;
import ge.e;
import ge.g;
import ge.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class AppBD_Impl extends AppBD {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile AppInstallTaskDAO f17957r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile SysAppAutoUpdateTaskInfoDao f17958s;

    public class a extends q0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppBD_Impl f17959b;

        public a(AppBD_Impl r10, int r11) {
            this.f17959b = r10;
            super(r11);
        }

        @Override // androidx.room.q0.b
        public void a(SupportSQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE IF NOT EXISTS `app_install_task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pkg` TEXT NOT NULL, `version_code` INTEGER NOT NULL, `app_name` TEXT NOT NULL, `icon_url` TEXT, `status` INTEGER NOT NULL, `apk_file_path` TEXT, `expected_md5` TEXT, `is_update` INTEGER NOT NULL, `is_auto_update` INTEGER NOT NULL, `download_wifi_required` INTEGER NOT NULL, `download_wait_wifi` INTEGER NOT NULL, `download_url` TEXT, `download_url_backups` TEXT, `download_id` INTEGER, `download_status` INTEGER, `download_error_code` INTEGER, `download_error_message` TEXT, `download_progress` REAL NOT NULL, `download_file_path` TEXT, `cur_bytes` INTEGER NOT NULL, `total_bytes` INTEGER NOT NULL, `download_speed` REAL, `download_modified_time` TEXT, `update_mode` INTEGER NOT NULL, `compliance_mode` INTEGER NOT NULL DEFAULT 0, `install_flag` INTEGER NOT NULL, `install_mode` INTEGER NOT NULL DEFAULT 1, `install_result_code` INTEGER, `business_extra` TEXT, `debug_extra` TEXT, `created_at` INTEGER NOT NULL, `force_install` INTEGER NOT NULL DEFAULT 0, `sha256` TEXT)");
            r10.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_app_install_task_pkg` ON `app_install_task` (`pkg`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_download_id` ON `app_install_task` (`download_id`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_version_code` ON `app_install_task` (`version_code`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_status` ON `app_install_task` (`status`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_is_update` ON `app_install_task` (`is_update`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_is_auto_update` ON `app_install_task` (`is_auto_update`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_download_wifi_required` ON `app_install_task` (`download_wifi_required`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_download_wait_wifi` ON `app_install_task` (`download_wait_wifi`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_download_status` ON `app_install_task` (`download_status`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_update_mode` ON `app_install_task` (`update_mode`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_compliance_mode` ON `app_install_task` (`compliance_mode`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_app_install_task_created_at` ON `app_install_task` (`created_at`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `sys_app_auto_update_task_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `appId` TEXT NOT NULL, `taskId` TEXT NOT NULL, `updateModel` INTEGER NOT NULL, `pkg` TEXT NOT NULL, `url` TEXT NOT NULL, `md5` TEXT NOT NULL, `size` INTEGER NOT NULL, `localVersionCode` INTEGER NOT NULL, `versionCode` INTEGER NOT NULL, `versionName` TEXT NOT NULL)");
            r10.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sys_app_auto_update_task_info_pkg` ON `sys_app_auto_update_task_info` (`pkg`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r10.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9dcd36cb6f68222fe6f16b1fc9afb746')");
        }

        @Override // androidx.room.q0.b
        public void b(SupportSQLiteDatabase r10) {
            r10.execSQL("DROP TABLE IF EXISTS `app_install_task`");
            r10.execSQL("DROP TABLE IF EXISTS `sys_app_auto_update_task_info`");
            List r11 = AppBD_Impl.H(this.f17959b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).b(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void c(SupportSQLiteDatabase r10) {
            List r11 = AppBD_Impl.I(this.f17959b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).a(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void d(SupportSQLiteDatabase r10) {
            AppBD_Impl.J(this.f17959b, r10);
            AppBD_Impl.K(this.f17959b, r10);
            List r11 = AppBD_Impl.L(this.f17959b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).c(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void e(SupportSQLiteDatabase r10) {
        }

        @Override // androidx.room.q0.b
        public void f(SupportSQLiteDatabase r10) {
            b.b(r10);
        }

        @Override // androidx.room.q0.b
        public q0.c g(SupportSQLiteDatabase r24) {
            HashMap r10 = new HashMap(34);
            r10.put("id", new TableInfo.a("id", "INTEGER", true, 1, null, 1));
            r10.put(AppPermissionActivity.EXTRA_APP_PKG, new TableInfo.a(AppPermissionActivity.EXTRA_APP_PKG, "TEXT", true, 0, null, 1));
            r10.put("version_code", new TableInfo.a("version_code", "INTEGER", true, 0, null, 1));
            r10.put("app_name", new TableInfo.a("app_name", "TEXT", true, 0, null, 1));
            r10.put(AppPermissionActivity.EXTRA_APP_ICON_URL, new TableInfo.a(AppPermissionActivity.EXTRA_APP_ICON_URL, "TEXT", false, 0, null, 1));
            r10.put("status", new TableInfo.a("status", "INTEGER", true, 0, null, 1));
            r10.put("apk_file_path", new TableInfo.a("apk_file_path", "TEXT", false, 0, null, 1));
            r10.put("expected_md5", new TableInfo.a("expected_md5", "TEXT", false, 0, null, 1));
            r10.put("is_update", new TableInfo.a("is_update", "INTEGER", true, 0, null, 1));
            r10.put("is_auto_update", new TableInfo.a("is_auto_update", "INTEGER", true, 0, null, 1));
            r10.put("download_wifi_required", new TableInfo.a("download_wifi_required", "INTEGER", true, 0, null, 1));
            r10.put("download_wait_wifi", new TableInfo.a("download_wait_wifi", "INTEGER", true, 0, null, 1));
            r10.put(ServerElements.DOWNLOAD_URL, new TableInfo.a(ServerElements.DOWNLOAD_URL, "TEXT", false, 0, null, 1));
            r10.put(ServerElements.DOWNLOAD_URL_BACKUPS, new TableInfo.a(ServerElements.DOWNLOAD_URL_BACKUPS, "TEXT", false, 0, null, 1));
            r10.put("download_id", new TableInfo.a("download_id", "INTEGER", false, 0, null, 1));
            r10.put("download_status", new TableInfo.a("download_status", "INTEGER", false, 0, null, 1));
            r10.put("download_error_code", new TableInfo.a("download_error_code", "INTEGER", false, 0, null, 1));
            r10.put("download_error_message", new TableInfo.a("download_error_message", "TEXT", false, 0, null, 1));
            r10.put("download_progress", new TableInfo.a("download_progress", "REAL", true, 0, null, 1));
            r10.put("download_file_path", new TableInfo.a("download_file_path", "TEXT", false, 0, null, 1));
            r10.put("cur_bytes", new TableInfo.a("cur_bytes", "INTEGER", true, 0, null, 1));
            r10.put("total_bytes", new TableInfo.a("total_bytes", "INTEGER", true, 0, null, 1));
            r10.put("download_speed", new TableInfo.a("download_speed", "REAL", false, 0, null, 1));
            r10.put("download_modified_time", new TableInfo.a("download_modified_time", "TEXT", false, 0, null, 1));
            r10.put(DownloadInfoColumns.COLUMN_UPDATE_MODE, new TableInfo.a(DownloadInfoColumns.COLUMN_UPDATE_MODE, "INTEGER", true, 0, null, 1));
            r10.put("compliance_mode", new TableInfo.a("compliance_mode", "INTEGER", true, 0, AdReportParam.ClickPosType.SKIP, 1));
            r10.put("install_flag", new TableInfo.a("install_flag", "INTEGER", true, 0, null, 1));
            r10.put("install_mode", new TableInfo.a("install_mode", "INTEGER", true, 0, "1", 1));
            r10.put("install_result_code", new TableInfo.a("install_result_code", "INTEGER", false, 0, null, 1));
            r10.put("business_extra", new TableInfo.a("business_extra", "TEXT", false, 0, null, 1));
            r10.put("debug_extra", new TableInfo.a("debug_extra", "TEXT", false, 0, null, 1));
            r10.put("created_at", new TableInfo.a("created_at", "INTEGER", true, 0, null, 1));
            r10.put("force_install", new TableInfo.a("force_install", "INTEGER", true, 0, AdReportParam.ClickPosType.SKIP, 1));
            r10.put("sha256", new TableInfo.a("sha256", "TEXT", false, 0, null, 1));
            HashSet r11 = new HashSet(0);
            HashSet r12 = new HashSet(12);
            r12.add(new TableInfo.e("index_app_install_task_pkg", true, Arrays.asList(new String[]{AppPermissionActivity.EXTRA_APP_PKG}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_download_id", false, Arrays.asList(new String[]{"download_id"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_version_code", false, Arrays.asList(new String[]{"version_code"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_status", false, Arrays.asList(new String[]{"status"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_is_update", false, Arrays.asList(new String[]{"is_update"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_is_auto_update", false, Arrays.asList(new String[]{"is_auto_update"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_download_wifi_required", false, Arrays.asList(new String[]{"download_wifi_required"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_download_wait_wifi", false, Arrays.asList(new String[]{"download_wait_wifi"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_download_status", false, Arrays.asList(new String[]{"download_status"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_update_mode", false, Arrays.asList(new String[]{DownloadInfoColumns.COLUMN_UPDATE_MODE}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_compliance_mode", false, Arrays.asList(new String[]{"compliance_mode"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_app_install_task_created_at", false, Arrays.asList(new String[]{"created_at"}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r13 = new TableInfo("app_install_task", r10, r11, r12);
            TableInfo r14 = TableInfo.a(r24, "app_install_task");
            if (r13.equals(r14) == false) goto L5;
            HashMap r15 = new HashMap(11);
            r15.put("id", new TableInfo.a("id", "INTEGER", true, 1, null, 1));
            r15.put("appId", new TableInfo.a("appId", "TEXT", true, 0, null, 1));
            r15.put("taskId", new TableInfo.a("taskId", "TEXT", true, 0, null, 1));
            r15.put("updateModel", new TableInfo.a("updateModel", "INTEGER", true, 0, null, 1));
            r15.put(AppPermissionActivity.EXTRA_APP_PKG, new TableInfo.a(AppPermissionActivity.EXTRA_APP_PKG, "TEXT", true, 0, null, 1));
            r15.put("url", new TableInfo.a("url", "TEXT", true, 0, null, 1));
            r15.put(ServerElements.MD5, new TableInfo.a(ServerElements.MD5, "TEXT", true, 0, null, 1));
            r15.put("size", new TableInfo.a("size", "INTEGER", true, 0, null, 1));
            r15.put("localVersionCode", new TableInfo.a("localVersionCode", "INTEGER", true, 0, null, 1));
            r15.put("versionCode", new TableInfo.a("versionCode", "INTEGER", true, 0, null, 1));
            r15.put("versionName", new TableInfo.a("versionName", "TEXT", true, 0, null, 1));
            HashSet r16 = new HashSet(0);
            HashSet r17 = new HashSet(1);
            r17.add(new TableInfo.e("index_sys_app_auto_update_task_info_pkg", true, Arrays.asList(new String[]{AppPermissionActivity.EXTRA_APP_PKG}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r18 = new TableInfo("sys_app_auto_update_task_info", r15, r16, r17);
            TableInfo r19 = TableInfo.a(r24, "sys_app_auto_update_task_info");
            if (r18.equals(r19) == true) goto L11;
            return new q0.c(false, "sys_app_auto_update_task_info(com.smt.obric.appstore.domain.app.entity.SysAppAutoUpdateTaskInfo).\n Expected:\n" + r18 + "\n Found:\n" + r19);
        L11:
            return new q0.c(true, null);
        L5:
            return new q0.c(false, "app_install_task(com.smt.obric.appstore.domain.app.entity.AppInstallTask).\n Expected:\n" + r13 + "\n Found:\n" + r14);
        }
    }

    public AppBD_Impl() {
    }

    public static /* synthetic */ List H(AppBD_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List I(AppBD_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ SupportSQLiteDatabase J(AppBD_Impl r10, SupportSQLiteDatabase r11) {
        r10.f4459a = r11;
        return r11;
    }

    public static /* synthetic */ void K(AppBD_Impl r10, SupportSQLiteDatabase r11) {
        r10.x(r11);
    }

    public static /* synthetic */ List L(AppBD_Impl r10) {
        return r10.f4466h;
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppBD
    public AppInstallTaskDAO F() {
        if (this.f17957r != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f17957r != null) goto L12;
        this.f17957r = new g(this);     // Catch: Throwable -> L10
    L12:
        AppInstallTaskDAO r10 = this.f17957r;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f17957r;
    }

    @Override // com.smt.obric.appstore.domain.app.db.AppBD
    public SysAppAutoUpdateTaskInfoDao G() {
        if (this.f17958s != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f17958s != null) goto L12;
        this.f17958s = new h(this);     // Catch: Throwable -> L10
    L12:
        SysAppAutoUpdateTaskInfoDao r10 = this.f17958s;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f17958s;
    }

    @Override // androidx.room.RoomDatabase
    public m g() {
        return new m(this, new HashMap(0), new HashMap(0), new String[]{"app_install_task", "sys_app_auto_update_task_info"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper h(androidx.room.h r10) {
        q0 r11 = new q0(r10, new a(this, 6), "9dcd36cb6f68222fe6f16b1fc9afb746", "4274de30d6606c9dcf856e8f8f8c2d61");
        SupportSQLiteOpenHelper.b r12 = SupportSQLiteOpenHelper.b.a(r10.f4554a).d(r10.f4555b).c(r11).b();
        return r10.f4556c.create(r12);
    }

    @Override // androidx.room.RoomDatabase
    public List j(Map r10) {
        ArrayList r11 = new ArrayList();
        r11.add(new ge.a());
        r11.add(new ge.b());
        r11.add(new c());
        r11.add(new d());
        r11.add(new e());
        return r11;
    }

    @Override // androidx.room.RoomDatabase
    public Set p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map q() {
        HashMap r10 = new HashMap();
        r10.put(AppInstallTaskDAO.class, g.k());
        r10.put(SysAppAutoUpdateTaskInfoDao.class, h.c());
        return r10;
    }
}
