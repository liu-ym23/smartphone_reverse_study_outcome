package ge;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends a0.a {
    public b() {
        super(2, 3);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        r10.execSQL("ALTER TABLE `app_install_task` ADD COLUMN `download_url_backups` TEXT DEFAULT NULL");
    }
}
