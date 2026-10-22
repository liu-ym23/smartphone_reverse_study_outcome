package androidx.sqlite.db.framework;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import kotlin.jvm.internal.g;
import y1.a;
import y1.b;
import y1.f;
import z1.d;
import z1.e;
import zb.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f2628b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f2629c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f2630a;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f2630a = sQLiteDatabase;
    }

    @Override // y1.b
    public final void A() {
        this.f2630a.beginTransactionNonExclusive();
    }

    @Override // y1.b
    public final boolean A0() {
        SQLiteDatabase sQLiteDatabase = this.f2630a;
        g.f(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    @Override // y1.b
    public final void H() {
        this.f2630a.endTransaction();
    }

    @Override // y1.b
    public final f a0(String str) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = this.f2630a.compileStatement(str);
        g.e(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new e(sQLiteStatementCompileStatement);
    }

    @Override // y1.b
    public final Cursor b0(final y1.e eVar) {
        final r<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> rVar = new r<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteDatabase$query$cursorFactory$1
            {
                super(4);
            }

            @Override // zb.r
            public final SQLiteCursor a(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                SQLiteQuery sQLiteQuery2 = sQLiteQuery;
                g.c(sQLiteQuery2);
                eVar.o(new d(sQLiteQuery2));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery2);
            }
        };
        Cursor cursorRawQueryWithFactory = this.f2630a.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: z1.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                r tmp0 = rVar;
                g.f(tmp0, "$tmp0");
                return (Cursor) tmp0.a(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.a(), f2629c, null);
        g.e(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2630a.close();
    }

    @Override // y1.b
    public final void l() {
        this.f2630a.beginTransaction();
    }

    @Override // y1.b
    public final void n(String sql) throws SQLException {
        g.f(sql, "sql");
        this.f2630a.execSQL(sql);
    }

    @Override // y1.b
    public final Cursor o0(String query) {
        g.f(query, "query");
        return b0(new a(query));
    }

    @Override // y1.b
    public final boolean w0() {
        return this.f2630a.inTransaction();
    }

    @Override // y1.b
    public final void y() {
        this.f2630a.setTransactionSuccessful();
    }

    @Override // y1.b
    public final void z(String str, Object[] bindArgs) throws SQLException {
        g.f(bindArgs, "bindArgs");
        this.f2630a.execSQL(str, bindArgs);
    }
}
