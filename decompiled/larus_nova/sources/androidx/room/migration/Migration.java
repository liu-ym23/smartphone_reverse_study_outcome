package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public abstract void migrate(SupportSQLiteDatabase r100);

    public Migration(int r100, int r101) {
        this.startVersion = r100;
        this.endVersion = r101;
    }
}
