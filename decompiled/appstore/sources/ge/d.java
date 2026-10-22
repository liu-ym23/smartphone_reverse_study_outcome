package ge;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends a0.a {
    public d() {
        super(4, 5);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        r10.execSQL("ALTER TABLE `app_install_task` ADD COLUMN `force_install` INTEGER NOT NULL DEFAULT 0");
        r10.execSQL("ALTER TABLE `app_install_task` ADD COLUMN `sha256` TEXT DEFAULT NULL");
    }
}
