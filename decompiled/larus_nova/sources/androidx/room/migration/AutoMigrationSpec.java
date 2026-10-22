package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes6.dex */
public interface AutoMigrationSpec {

    /* JADX INFO: renamed from: androidx.room.migration.AutoMigrationSpec$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public final /* synthetic */ class CC {
        public static void $default$onPostMigrate(AutoMigrationSpec r100, SupportSQLiteDatabase r101) {
        }
    }

    void onPostMigrate(SupportSQLiteDatabase r100);
}
