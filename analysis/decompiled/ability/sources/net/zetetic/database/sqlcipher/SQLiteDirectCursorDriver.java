package net.zetetic.database.sqlcipher;

import android.os.CancellationSignal;

/* loaded from: classes4.dex */
public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f5402a;
    public final String b;
    public final String c;
    public final CancellationSignal d;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.f5402a = sQLiteDatabase;
        this.b = str2;
        this.c = str;
        this.d = cancellationSignal;
    }

    public final String toString() {
        return "SQLiteDirectCursorDriver: " + this.c;
    }
}
