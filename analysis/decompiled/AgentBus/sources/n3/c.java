package n3;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import f8.x;
import java.io.Closeable;
import q7.k;

/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f6816g = new String[0];

    /* renamed from: f, reason: collision with root package name */
    public final SQLiteDatabase f6817f;

    public c(SQLiteDatabase sQLiteDatabase) {
        this.f6817f = sQLiteDatabase;
    }

    public final void a() {
        this.f6817f.beginTransaction();
    }

    public final void b() {
        this.f6817f.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6817f.close();
    }

    public final j d(String str) throws SQLException {
        k.e(str, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f6817f.compileStatement(str);
        k.d(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new j(sQLiteStatementCompileStatement);
    }

    public final void e() {
        this.f6817f.endTransaction();
    }

    public final void g(String str) throws SQLException {
        k.e(str, "sql");
        this.f6817f.execSQL(str);
    }

    public final boolean i() {
        return this.f6817f.inTransaction();
    }

    public final boolean k() {
        SQLiteDatabase sQLiteDatabase = this.f6817f;
        k.e(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public final Cursor n(String str) {
        k.e(str, "query");
        return o(new x(str));
    }

    public final Cursor o(m3.c cVar) {
        k.e(cVar, "query");
        final b bVar = new b(0, cVar);
        Cursor cursorRawQueryWithFactory = this.f6817f.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: n3.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                return (Cursor) bVar.u(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, cVar.a(), f6816g, null);
        k.d(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    public final void q() {
        this.f6817f.setTransactionSuccessful();
    }
}
