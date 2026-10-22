package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4793c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f4794d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f4795a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f4796a = null;

        static {
            f4796a = new a();
        }

        public a() {
        }

        @DoNotInline
        public final void a(@NotNull SQLiteDatabase r10, @NotNull String r11, @Nullable Object[] r12) {
            q.g(r10, "sQLiteDatabase");
            q.g(r11, "sql");
            r10.execPerConnectionSQL(r11, r12);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    static {
        f4792b = new b(null);
        f4793c = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        f4794d = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase r10) {
        q.g(r10, "delegate");
        this.f4795a = r10;
    }

    public static /* synthetic */ Cursor a(SupportSQLiteQuery r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        return e(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Cursor b(Function4 r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        return d(r10, r11, r12, r13, r14);
    }

    public static final Cursor d(Function4 r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        q.g(r10, "$tmp0");
        return (Cursor) r10.invoke(r11, r12, r13, r14);
    }

    public static final Cursor e(SupportSQLiteQuery r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        q.g(r10, "$query");
        q.d(r14);
        r10.bindTo(new e(r14));
        return new SQLiteCursor(r12, r13, r14);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.f4795a.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.f4795a.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r10) {
        q.g(r10, "transactionListener");
        this.f4795a.beginTransactionWithListener(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
        q.g(r10, "transactionListener");
        this.f4795a.beginTransactionWithListenerNonExclusive(r10);
    }

    public final boolean c(SQLiteDatabase r10) {
        q.g(r10, "sqLiteDatabase");
        return q.b(this.f4795a, r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4795a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r10) {
        q.g(r10, "sql");
        SQLiteStatement r11 = this.f4795a.compileStatement(r10);
        q.f(r11, "delegate.compileStatement(sql)");
        return new f(r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r10, String r11, Object[] r12) {
        q.g(r10, "table");
        StringBuilder r13 = new StringBuilder();
        r13.append("DELETE FROM ");
        r13.append(r10);
        if (r11 != null) goto L5;
    L8:
        String r14 = r13.toString();
        q.f(r14, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r15 = compileStatement(r14);
        c0.a.f6020c.b(r15, r12);
        return r15.executeUpdateDelete();
    L5:
        if (r11.length() == 0) goto L8;
        r13.append(" WHERE ");
        r13.append(r11);
        goto L8
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        c0.b.d(this.f4795a);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.f4795a.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.f4795a.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r10, Object[] r11) {
        q.g(r10, "sql");
        a.f4796a.a(this.f4795a, r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r10) {
        q.g(r10, "sql");
        this.f4795a.execSQL(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List getAttachedDbs() {
        return this.f4795a.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.f4795a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.f4795a.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.f4795a.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.f4795a.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.f4795a.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r10, int r11, ContentValues r12) {
        q.g(r10, "table");
        q.g(r12, "values");
        return this.f4795a.insertWithOnConflict(r10, null, r12, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.f4795a.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.f4795a.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f4795a.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.f4795a.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return c0.b.e(this.f4795a);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r10) {
        return this.f4795a.needUpgrade(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r10) {
        q.g(r10, "query");
        return query(new c0.a(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r10) {
        c0.b.g(this.f4795a, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r10) {
        q.g(r10, "locale");
        this.f4795a.setLocale(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r10) {
        this.f4795a.setMaxSqlCacheSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r10) {
        this.f4795a.setMaximumSize(r10);
        return this.f4795a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r10) {
        this.f4795a.setPageSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.f4795a.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r10) {
        this.f4795a.setVersion(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r10, int r11, ContentValues r12, String r13, Object[] r14) {
        q.g(r10, "table");
        q.g(r12, "values");
        if (r12.size() == 0) goto L26;
        int r15 = r12.size();
        if (r14 != null) goto L7;
        int r16 = r15;
    L8:
        Object[] r17 = new Object[r16];
        StringBuilder r18 = new StringBuilder();
        r18.append("UPDATE ");
        r18.append(f4793c[r11]);
        r18.append(r10);
        r18.append(" SET ");
        Iterator<String> r19 = r12.keySet().iterator();
        int r20 = 0;
    L10:
        if (r19.hasNext() == false) goto L16;
        String r21 = r19.next();
        if (r20 <= 0) goto L14;
        String r22 = ",";
    L15:
        r18.append(r22);
        r18.append(r21);
        r17[r20] = r12.get(r21);
        r18.append("=?");
        r20 = r20 + 1;
        goto L10
    L14:
        r22 = "";
        goto L15
    L16:
        if (r14 == null) goto L21;
        int r23 = r15;
    L18:
        if (r23 >= r16) goto L21;
        r17[r23] = r14[r23 - r15];
        r23 = r23 + 1;
    L21:
        if (TextUtils.isEmpty(r13) == true) goto L23;
        r18.append(" WHERE ");
        r18.append(r13);
    L23:
        String r24 = r18.toString();
        q.f(r24, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r25 = compileStatement(r24);
        c0.a.f6020c.b(r25, r17);
        return r25.executeUpdateDelete();
    L7:
        r16 = r14.length + r15;
        goto L8
    L26:
        throw new IllegalArgumentException("Empty values");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.f4795a.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r10, Object[] r11) {
        q.g(r10, "sql");
        q.g(r11, "bindArgs");
        this.f4795a.execSQL(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r10, Object[] r11) {
        q.g(r10, "query");
        q.g(r11, "bindArgs");
        return query(new c0.a(r10, r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r10) {
        return this.f4795a.yieldIfContendedSafely(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10) {
        q.g(r10, "query");
        final Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> r11 = new FrameworkSQLiteDatabase$query$cursorFactory$1(r10);
        Cursor r12 = this.f4795a.rawQueryWithFactory(new androidx.sqlite.db.framework.b(r11), r10.getSql(), f4794d, null);
        q.f(r12, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return r12;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10, CancellationSignal r11) {
        q.g(r10, "query");
        SQLiteDatabase r12 = this.f4795a;
        String r13 = r10.getSql();
        String[] r14 = f4794d;
        q.d(r11);
        return c0.b.f(r12, r13, r14, null, r11, new androidx.sqlite.db.framework.a(r10));
    }
}
