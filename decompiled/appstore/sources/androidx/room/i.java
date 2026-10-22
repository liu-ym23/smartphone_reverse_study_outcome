package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends SharedSQLiteStatement {
    public i(RoomDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "database");
        super(r10);
    }

    public abstract void i(SupportSQLiteStatement r10, Object r11);

    public final int j(Object r10) {
        SupportSQLiteStatement r11 = b();
        i(r11, r10);     // Catch: Throwable -> L6
        int r12 = r11.executeUpdateDelete();     // Catch: Throwable -> L6
        h(r11);
        return r12;
    L6:
        th = move-exception;
        h(r11);
        throw th;
    }
}
