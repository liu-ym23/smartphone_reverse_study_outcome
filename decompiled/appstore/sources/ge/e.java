package ge;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends a0.a {
    public e() {
        super(5, 6);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE IF NOT EXISTS `_new_app_install_task` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `pkg` TEXT NOT NULL, `version_code` INTEGER NOT NULL, `app_name` TEXT NOT NULL, `icon_url` TEXT, `status` INTEGER NOT NULL, `apk_file_path` TEXT, `expected_md5` TEXT, `is_update` INTEGER NOT NULL, `is_auto_update` INTEGER NOT NULL, `download_wifi_required` INTEGER NOT NULL, `download_wait_wifi` INTEGER NOT NULL, `download_url` TEXT, `download_url_backups` TEXT, `download_id` INTEGER, `download_status` INTEGER, `download_error_code` INTEGER, `download_error_message` TEXT, `download_progress` REAL NOT NULL, `download_file_path` TEXT, `cur_bytes` INTEGER NOT NULL, `total_bytes` INTEGER NOT NULL, `download_speed` REAL, `download_modified_time` TEXT, `update_mode` INTEGER NOT NULL, `compliance_mode` INTEGER NOT NULL DEFAULT 0, `install_flag` INTEGER NOT NULL, `install_mode` INTEGER NOT NULL DEFAULT 1, `install_result_code` INTEGER, `business_extra` TEXT, `debug_extra` TEXT, `created_at` INTEGER NOT NULL, `force_install` INTEGER NOT NULL DEFAULT 0, `sha256` TEXT)");
        r10.execSQL("INSERT INTO `_new_app_install_task` (`id`,`pkg`,`version_code`,`app_name`,`icon_url`,`status`,`apk_file_path`,`expected_md5`,`is_update`,`is_auto_update`,`download_wifi_required`,`download_wait_wifi`,`download_url`,`download_url_backups`,`download_id`,`download_status`,`download_error_code`,`download_error_message`,`download_progress`,`download_file_path`,`cur_bytes`,`total_bytes`,`download_speed`,`download_modified_time`,`update_mode`,`install_flag`,`install_mode`,`install_result_code`,`business_extra`,`debug_extra`,`created_at`,`force_install`,`sha256`) SELECT `id`,`pkg`,`version_code`,`app_name`,`icon_url`,`status`,`apk_file_path`,`expected_md5`,`is_update`,`is_auto_update`,`download_wifi_required`,`download_wait_wifi`,`download_url`,`download_url_backups`,`download_id`,`download_status`,`download_error_code`,`download_error_message`,`download_progress`,`download_file_path`,`cur_bytes`,`total_bytes`,`download_speed`,`download_modified_time`,`update_mode`,`install_flag`,`install_mode`,`install_result_code`,`business_extra`,`debug_extra`,`created_at`,`force_install`,`sha256` FROM `app_install_task`");
        r10.execSQL("DROP TABLE `app_install_task`");
        r10.execSQL("ALTER TABLE `_new_app_install_task` RENAME TO `app_install_task`");
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
    }
}
