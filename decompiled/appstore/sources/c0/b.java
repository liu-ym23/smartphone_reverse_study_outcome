package c0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6023a = null;

    static {
        f6023a = new b();
    }

    public b() {
    }

    public static final void a(CancellationSignal r10) {
        q.g(r10, "cancellationSignal");
        r10.cancel();
    }

    public static final CancellationSignal b() {
        return new CancellationSignal();
    }

    public static final boolean c(File r10) {
        q.g(r10, "file");
        return SQLiteDatabase.deleteDatabase(r10);
    }

    public static final void d(SQLiteDatabase r10) {
        q.g(r10, "sQLiteDatabase");
        r10.disableWriteAheadLogging();
    }

    public static final boolean e(SQLiteDatabase r10) {
        q.g(r10, "sQLiteDatabase");
        return r10.isWriteAheadLoggingEnabled();
    }

    public static final Cursor f(SQLiteDatabase r10, String r11, String[] r12, String r13, CancellationSignal r14, SQLiteDatabase.CursorFactory r15) {
        q.g(r10, "sQLiteDatabase");
        q.g(r11, "sql");
        q.g(r12, "selectionArgs");
        q.g(r14, "cancellationSignal");
        q.g(r15, "cursorFactory");
        Cursor r16 = r10.rawQueryWithFactory(r15, r11, r12, r13, r14);
        q.f(r16, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return r16;
    }

    public static final void g(SQLiteDatabase r10, boolean r11) {
        q.g(r10, "sQLiteDatabase");
        r10.setForeignKeyConstraintsEnabled(r11);
    }

    public static final void h(SQLiteOpenHelper r10, boolean r11) {
        q.g(r10, "sQLiteOpenHelper");
        r10.setWriteAheadLoggingEnabled(r11);
    }
}
