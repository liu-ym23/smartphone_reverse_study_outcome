package ge;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public final class c extends a0.a {
    public c() {
        super(3, 4);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        r10.execSQL("ALTER TABLE `app_install_task` ADD COLUMN `install_mode` INTEGER NOT NULL DEFAULT 1");
    }
}
