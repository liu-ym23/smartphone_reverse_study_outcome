package l0;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import k0.C0673a;
import k0.InterfaceC0674b;
import k0.j;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: l0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0749c implements InterfaceC0674b {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f13424b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f13425c = new String[0];

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f13426a;

    public C0749c(SQLiteDatabase delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f13426a = delegate;
    }

    @Override // k0.InterfaceC0674b
    public final void beginTransaction() {
        this.f13426a.beginTransaction();
    }

    @Override // k0.InterfaceC0674b
    public final void beginTransactionNonExclusive() {
        this.f13426a.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f13426a.close();
    }

    @Override // k0.InterfaceC0674b
    public final j compileStatement(String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        SQLiteStatement sQLiteStatementCompileStatement = this.f13426a.compileStatement(sql);
        Intrinsics.checkNotNullExpressionValue(sQLiteStatementCompileStatement, "delegate.compileStatement(sql)");
        return new C0755i(sQLiteStatementCompileStatement);
    }

    @Override // k0.InterfaceC0674b
    public final void endTransaction() {
        this.f13426a.endTransaction();
    }

    @Override // k0.InterfaceC0674b
    public final void execSQL(String sql) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        this.f13426a.execSQL(sql);
    }

    @Override // k0.InterfaceC0674b
    public final boolean inTransaction() {
        return this.f13426a.inTransaction();
    }

    @Override // k0.InterfaceC0674b
    public final boolean isOpen() {
        return this.f13426a.isOpen();
    }

    @Override // k0.InterfaceC0674b
    public final boolean isWriteAheadLoggingEnabled() {
        SQLiteDatabase sQLiteDatabase = this.f13426a;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    @Override // k0.InterfaceC0674b
    public final Cursor query(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return query(new C0673a(query));
    }

    @Override // k0.InterfaceC0674b
    public final void setTransactionSuccessful() {
        this.f13426a.setTransactionSuccessful();
    }

    @Override // k0.InterfaceC0674b
    public final int update(String table, int i4, ContentValues values, String str, Object[] objArr) throws SQLException {
        Intrinsics.checkNotNullParameter(table, "table");
        Intrinsics.checkNotNullParameter(values, "values");
        if (values.size() == 0) {
            throw new IllegalArgumentException("Empty values".toString());
        }
        int size = values.size();
        int length = objArr == null ? size : objArr.length + size;
        Object[] objArr2 = new Object[length];
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(f13424b[i4]);
        sb.append(table);
        sb.append(" SET ");
        int i5 = 0;
        for (String str2 : values.keySet()) {
            sb.append(i5 > 0 ? "," : "");
            sb.append(str2);
            objArr2[i5] = values.get(str2);
            sb.append("=?");
            i5++;
        }
        if (objArr != null) {
            for (int i6 = size; i6 < length; i6++) {
                objArr2[i6] = objArr[i6 - size];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(" WHERE ");
            sb.append(str);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        j jVarCompileStatement = compileStatement(string);
        E3.b.c(jVarCompileStatement, objArr2);
        return ((C0755i) jVarCompileStatement).f13452c.executeUpdateDelete();
    }

    @Override // k0.InterfaceC0674b
    public final void execSQL(String sql, Object[] bindArgs) throws SQLException {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(bindArgs, "bindArgs");
        this.f13426a.execSQL(sql, bindArgs);
    }

    @Override // k0.InterfaceC0674b
    public final Cursor query(k0.i query) {
        Intrinsics.checkNotNullParameter(query, "query");
        Cursor cursorRawQueryWithFactory = this.f13426a.rawQueryWithFactory(new C0747a(1, new C0748b(query)), query.b(), f13425c, null);
        Intrinsics.checkNotNullExpressionValue(cursorRawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return cursorRawQueryWithFactory;
    }

    @Override // k0.InterfaceC0674b
    public final Cursor query(k0.i query, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(query, "query");
        String sql = query.b();
        String[] selectionArgs = f13425c;
        Intrinsics.checkNotNull(cancellationSignal);
        C0747a cursorFactory = new C0747a(0, query);
        SQLiteDatabase sQLiteDatabase = this.f13426a;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(selectionArgs, "selectionArgs");
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        Intrinsics.checkNotNullParameter(cursorFactory, "cursorFactory");
        Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, sql, selectionArgs, null, cancellationSignal);
        Intrinsics.checkNotNullExpressionValue(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return cursorRawQueryWithFactory;
    }
}
