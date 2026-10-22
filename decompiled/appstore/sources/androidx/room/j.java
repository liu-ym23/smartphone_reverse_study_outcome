package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends SharedSQLiteStatement {
    public j(RoomDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "database");
        super(r10);
    }

    public abstract void i(SupportSQLiteStatement r10, Object r11);

    public final void j(Object r10) {
        SupportSQLiteStatement r11 = b();
        i(r11, r10);     // Catch: Throwable -> L6
        r11.executeInsert();     // Catch: Throwable -> L6
        h(r11);
        return;
    L6:
        th = move-exception;
        h(r11);
        throw th;
    }

    public final long k(Object r10) {
        SupportSQLiteStatement r11 = b();
        i(r11, r10);     // Catch: Throwable -> L6
        long r12 = r11.executeInsert();     // Catch: Throwable -> L6
        h(r11);
        return r12;
    L6:
        th = move-exception;
        h(r11);
        throw th;
    }
}
