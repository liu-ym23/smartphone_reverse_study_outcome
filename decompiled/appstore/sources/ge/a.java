package ge;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends a0.a {
    public a() {
        super(1, 2);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE IF NOT EXISTS `sys_app_auto_update_task_info` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `appId` TEXT NOT NULL, `taskId` TEXT NOT NULL, `updateModel` INTEGER NOT NULL, `pkg` TEXT NOT NULL, `url` TEXT NOT NULL, `md5` TEXT NOT NULL, `size` INTEGER NOT NULL, `localVersionCode` INTEGER NOT NULL, `versionCode` INTEGER NOT NULL, `versionName` TEXT NOT NULL)");
        r10.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_sys_app_auto_update_task_info_pkg` ON `sys_app_auto_update_task_info` (`pkg`)");
    }
}
