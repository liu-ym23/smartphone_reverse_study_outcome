package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements SupportSQLiteDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteDatabase f4529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoomDatabase.QueryCallback f4531c;

    public d0(SupportSQLiteDatabase r10, Executor r11, RoomDatabase.QueryCallback r12) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "queryCallbackExecutor");
        kotlin.jvm.internal.q.g(r12, "queryCallback");
        this.f4529a = r10;
        this.f4530b = r11;
        this.f4531c = r12;
    }

    public static /* synthetic */ void a(d0 r10, String r11) {
        r(r10, r11);
    }

    public static /* synthetic */ void b(d0 r10) {
        q(r10);
    }

    public static /* synthetic */ void c(d0 r10) {
        x(r10);
    }

    public static /* synthetic */ void d(d0 r10, String r11, List r12) {
        s(r10, r11, r12);
    }

    public static /* synthetic */ void e(d0 r10) {
        m(r10);
    }

    public static /* synthetic */ void f(d0 r10) {
        n(r10);
    }

    public static /* synthetic */ void g(d0 r10, String r11, Object[] r12) {
        u(r10, r11, r12);
    }

    public static /* synthetic */ void h(d0 r10) {
        o(r10);
    }

    public static /* synthetic */ void i(d0 r10, String r11) {
        t(r10, r11);
    }

    public static /* synthetic */ void j(d0 r10) {
        p(r10);
    }

    public static /* synthetic */ void k(d0 r10, SupportSQLiteQuery r11, g0 r12) {
        v(r10, r11, r12);
    }

    public static /* synthetic */ void l(d0 r10, SupportSQLiteQuery r11, g0 r12) {
        w(r10, r11, r12);
    }

    public static final void m(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("BEGIN EXCLUSIVE TRANSACTION", kotlin.collections.t.i());
    }

    public static final void n(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("BEGIN DEFERRED TRANSACTION", kotlin.collections.t.i());
    }

    public static final void o(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("BEGIN EXCLUSIVE TRANSACTION", kotlin.collections.t.i());
    }

    public static final void p(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("BEGIN DEFERRED TRANSACTION", kotlin.collections.t.i());
    }

    public static final void q(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("END TRANSACTION", kotlin.collections.t.i());
    }

    public static final void r(d0 r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$sql");
        r10.f4531c.onQuery(r11, kotlin.collections.t.i());
    }

    public static final void s(d0 r10, String r11, List r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$sql");
        kotlin.jvm.internal.q.g(r12, "$inputArguments");
        r10.f4531c.onQuery(r11, r12);
    }

    public static final void t(d0 r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$query");
        r10.f4531c.onQuery(r11, kotlin.collections.t.i());
    }

    public static final void u(d0 r10, String r11, Object[] r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$query");
        kotlin.jvm.internal.q.g(r12, "$bindArgs");
        r10.f4531c.onQuery(r11, kotlin.collections.n.K(r12));
    }

    public static final void v(d0 r10, SupportSQLiteQuery r11, g0 r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$query");
        kotlin.jvm.internal.q.g(r12, "$queryInterceptorProgram");
        r10.f4531c.onQuery(r11.getSql(), r12.a());
    }

    public static final void w(d0 r10, SupportSQLiteQuery r11, g0 r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "$query");
        kotlin.jvm.internal.q.g(r12, "$queryInterceptorProgram");
        r10.f4531c.onQuery(r11.getSql(), r12.a());
    }

    public static final void x(d0 r10) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        r10.f4531c.onQuery("TRANSACTION SUCCESSFUL", kotlin.collections.t.i());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.f4530b.execute(new w(this));
        this.f4529a.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.f4530b.execute(new y(this));
        this.f4529a.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r10) {
        kotlin.jvm.internal.q.g(r10, "transactionListener");
        this.f4530b.execute(new b0(this));
        this.f4529a.beginTransactionWithListener(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
        kotlin.jvm.internal.q.g(r10, "transactionListener");
        this.f4530b.execute(new s(this));
        this.f4529a.beginTransactionWithListenerNonExclusive(r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4529a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r10) {
        kotlin.jvm.internal.q.g(r10, "sql");
        return new m0(this.f4529a.compileStatement(r10), r10, this.f4530b, this.f4531c);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r10, String r11, Object[] r12) {
        kotlin.jvm.internal.q.g(r10, "table");
        return this.f4529a.delete(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.f4529a.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.f4529a.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.f4530b.execute(new r(this));
        this.f4529a.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r10, Object[] r11) {
        kotlin.jvm.internal.q.g(r10, "sql");
        this.f4529a.execPerConnectionSQL(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r10) {
        kotlin.jvm.internal.q.g(r10, "sql");
        this.f4530b.execute(new v(this, r10));
        this.f4529a.execSQL(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List getAttachedDbs() {
        return this.f4529a.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.f4529a.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.f4529a.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.f4529a.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.f4529a.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.f4529a.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r10, int r11, ContentValues r12) {
        kotlin.jvm.internal.q.g(r10, "table");
        kotlin.jvm.internal.q.g(r12, "values");
        return this.f4529a.insert(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.f4529a.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.f4529a.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.f4529a.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.f4529a.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.f4529a.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.f4529a.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r10) {
        return this.f4529a.needUpgrade(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r10) {
        kotlin.jvm.internal.q.g(r10, "query");
        this.f4530b.execute(new t(this, r10));
        return this.f4529a.query(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r10) {
        this.f4529a.setForeignKeyConstraintsEnabled(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r10) {
        kotlin.jvm.internal.q.g(r10, "locale");
        this.f4529a.setLocale(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r10) {
        this.f4529a.setMaxSqlCacheSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r10) {
        return this.f4529a.setMaximumSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r10) {
        this.f4529a.setPageSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.f4530b.execute(new x(this));
        this.f4529a.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r10) {
        this.f4529a.setVersion(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r10, int r11, ContentValues r12, String r13, Object[] r14) {
        kotlin.jvm.internal.q.g(r10, "table");
        kotlin.jvm.internal.q.g(r12, "values");
        return this.f4529a.update(r10, r11, r12, r13, r14);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.f4529a.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r10) {
        return this.f4529a.yieldIfContendedSafely(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r10, Object[] r11) {
        kotlin.jvm.internal.q.g(r10, "sql");
        kotlin.jvm.internal.q.g(r11, "bindArgs");
        List r12 = kotlin.collections.s.c();
        kotlin.collections.y.w(r12, r11);
        final List r13 = kotlin.collections.s.a(r12);
        this.f4530b.execute(new z(this, r10, r13));
        this.f4529a.execSQL(r10, r13.toArray(new Object[0]));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r10, final Object[] r11) {
        kotlin.jvm.internal.q.g(r10, "query");
        kotlin.jvm.internal.q.g(r11, "bindArgs");
        this.f4530b.execute(new u(this, r10, r11));
        return this.f4529a.query(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10) {
        kotlin.jvm.internal.q.g(r10, "query");
        final g0 r11 = new g0();
        r10.bindTo(r11);
        this.f4530b.execute(new a0(this, r10, r11));
        return this.f4529a.query(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10, CancellationSignal r11) {
        kotlin.jvm.internal.q.g(r10, "query");
        final g0 r12 = new g0();
        r10.bindTo(r12);
        this.f4530b.execute(new c0(this, r10, r12));
        return this.f4529a.query(r10);
    }
}
