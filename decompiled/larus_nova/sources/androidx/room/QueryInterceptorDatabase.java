package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public static /* synthetic */ void a(QueryInterceptorDatabase r100) {
        r100.lambda$endTransaction$4();
    }

    public static /* synthetic */ void b(QueryInterceptorDatabase r100) {
        r100.lambda$beginTransactionNonExclusive$1();
    }

    public static /* synthetic */ void c(QueryInterceptorDatabase r100) {
        r100.lambda$setTransactionSuccessful$5();
    }

    public static /* synthetic */ void d(QueryInterceptorDatabase r100, String r101, List r102) {
        r100.lambda$execSQL$11(r101, r102);
    }

    public static /* synthetic */ void e(QueryInterceptorDatabase r100) {
        r100.lambda$beginTransactionWithListenerNonExclusive$3();
    }

    public static /* synthetic */ void f(QueryInterceptorDatabase r100, String r101) {
        r100.lambda$execSQL$10(r101);
    }

    public static /* synthetic */ void g(QueryInterceptorDatabase r100, SupportSQLiteQuery r101, QueryInterceptorProgram r102) {
        r100.lambda$query$8(r101, r102);
    }

    public static /* synthetic */ void h(QueryInterceptorDatabase r100, String r101) {
        r100.lambda$query$6(r101);
    }

    public static /* synthetic */ void i(QueryInterceptorDatabase r100, String r101, List r102) {
        r100.lambda$query$7(r101, r102);
    }

    public static /* synthetic */ void j(QueryInterceptorDatabase r100, SupportSQLiteQuery r101, QueryInterceptorProgram r102) {
        r100.lambda$query$9(r101, r102);
    }

    public static /* synthetic */ void k(QueryInterceptorDatabase r100) {
        r100.lambda$beginTransaction$0();
    }

    public static /* synthetic */ void l(QueryInterceptorDatabase r100) {
        r100.lambda$beginTransactionWithListener$2();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ void execPerConnectionSQL(String r100, Object[] r101) {
        SupportSQLiteDatabase.CC.$default$execPerConnectionSQL(this, r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return SupportSQLiteDatabase.CC.$default$isExecPerConnectionSQLSupported(this);
    }

    private /* synthetic */ void lambda$beginTransaction$0() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    private /* synthetic */ void lambda$beginTransactionNonExclusive$1() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    private /* synthetic */ void lambda$beginTransactionWithListener$2() {
        this.mQueryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    private /* synthetic */ void lambda$beginTransactionWithListenerNonExclusive$3() {
        this.mQueryCallback.onQuery("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    private /* synthetic */ void lambda$endTransaction$4() {
        this.mQueryCallback.onQuery("END TRANSACTION", Collections.emptyList());
    }

    private /* synthetic */ void lambda$setTransactionSuccessful$5() {
        this.mQueryCallback.onQuery("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.mQueryCallbackExecutor.execute(new n0(this));
        this.mDelegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.mQueryCallbackExecutor.execute(new f0(this));
        this.mDelegate.beginTransactionNonExclusive();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.mDelegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.mDelegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.mQueryCallbackExecutor.execute(new p0(this));
        this.mDelegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.mDelegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.mDelegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.mDelegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.mDelegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.mDelegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.mDelegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.mDelegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mDelegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.mDelegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.mDelegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        return this.mDelegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.mQueryCallbackExecutor.execute(new k0(this));
        this.mDelegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.mDelegate.yieldIfContendedSafely();
    }

    private /* synthetic */ void lambda$execSQL$10(String r100) {
        this.mQueryCallback.onQuery(r100, new ArrayList(0));
    }

    private /* synthetic */ void lambda$query$6(String r100) {
        this.mQueryCallback.onQuery(r100, Collections.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r100) {
        this.mQueryCallbackExecutor.execute(new h0(this));
        this.mDelegate.beginTransactionWithListener(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        this.mQueryCallbackExecutor.execute(new l0(this));
        this.mDelegate.beginTransactionWithListenerNonExclusive(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r100) {
        return new QueryInterceptorStatement(this.mDelegate.compileStatement(r100), this.mQueryCallback, r100, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r100) throws SQLException {
        this.mQueryCallbackExecutor.execute(new g0(this, r100));
        this.mDelegate.execSQL(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r100) {
        return this.mDelegate.needUpgrade(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r100) {
        final QueryInterceptorProgram r101 = new QueryInterceptorProgram();
        r100.bindTo(r101);
        this.mQueryCallbackExecutor.execute(new m0(this, r100, r101));
        return this.mDelegate.query(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r100) {
        this.mDelegate.setForeignKeyConstraintsEnabled(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r100) {
        this.mDelegate.setLocale(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r100) {
        this.mDelegate.setMaxSqlCacheSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r100) {
        return this.mDelegate.setMaximumSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r100) {
        this.mDelegate.setPageSize(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r100) {
        this.mDelegate.setVersion(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r100) {
        return this.mDelegate.yieldIfContendedSafely(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r100) {
        this.mQueryCallbackExecutor.execute(new o0(this, r100));
        return this.mDelegate.query(r100);
    }

    private /* synthetic */ void lambda$execSQL$11(String r100, List r101) {
        this.mQueryCallback.onQuery(r100, r101);
    }

    private /* synthetic */ void lambda$query$7(String r100, List r101) {
        this.mQueryCallback.onQuery(r100, r101);
    }

    private /* synthetic */ void lambda$query$8(SupportSQLiteQuery r100, QueryInterceptorProgram r101) {
        this.mQueryCallback.onQuery(r100.getSql(), r101.getBindArgs());
    }

    private /* synthetic */ void lambda$query$9(SupportSQLiteQuery r100, QueryInterceptorProgram r101) {
        this.mQueryCallback.onQuery(r100.getSql(), r101.getBindArgs());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r100, Object[] r101) throws SQLException {
        final ArrayList r102 = new ArrayList();
        r102.addAll(Arrays.asList(r101));
        this.mQueryCallbackExecutor.execute(new q0(this, r100, r102));
        this.mDelegate.execSQL(r100, r102.toArray());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r100, Object[] r101) {
        final ArrayList r102 = new ArrayList();
        r102.addAll(Arrays.asList(r101));
        this.mQueryCallbackExecutor.execute(new j0(this, r100, r102));
        return this.mDelegate.query(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r100, CancellationSignal r101) {
        final QueryInterceptorProgram r102 = new QueryInterceptorProgram();
        r100.bindTo(r102);
        this.mQueryCallbackExecutor.execute(new i0(this, r100, r102));
        return this.mDelegate.query(r100);
    }

    public QueryInterceptorDatabase(SupportSQLiteDatabase r100, RoomDatabase.QueryCallback r101, Executor r102) {
        this.mDelegate = r100;
        this.mQueryCallback = r101;
        this.mQueryCallbackExecutor = r102;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        return this.mDelegate.delete(r100, r101, r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) throws SQLException {
        return this.mDelegate.insert(r100, r101, r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r102, String r110, Object[] r111) {
        return this.mDelegate.update(r100, r101, r102, r110, r111);
    }
}
