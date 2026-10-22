package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache;
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    public static /* synthetic */ void a(QueryInterceptorStatement r100) {
        r100.lambda$simpleQueryForString$4();
    }

    public static /* synthetic */ void b(QueryInterceptorStatement r100) {
        r100.lambda$execute$0();
    }

    public static /* synthetic */ void c(QueryInterceptorStatement r100) {
        r100.lambda$executeInsert$2();
    }

    public static /* synthetic */ void d(QueryInterceptorStatement r100) {
        r100.lambda$executeUpdateDelete$1();
    }

    public static /* synthetic */ void e(QueryInterceptorStatement r100) {
        r100.lambda$simpleQueryForLong$3();
    }

    private /* synthetic */ void lambda$execute$0() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private /* synthetic */ void lambda$executeInsert$2() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private /* synthetic */ void lambda$executeUpdateDelete$1() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private /* synthetic */ void lambda$simpleQueryForLong$3() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    private /* synthetic */ void lambda$simpleQueryForString$4() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
        this.mDelegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new s0(this));
        this.mDelegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new t0(this));
        return this.mDelegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new r0(this));
        return this.mDelegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new v0(this));
        return this.mDelegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new u0(this));
        return this.mDelegate.simpleQueryForString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        saveArgsToCache(r100, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(r100);
    }

    private void saveArgsToCache(int r100, Object r101) {
        int r102 = r100 - 1;
        if (r102 < this.mBindArgsCache.size()) goto L7;
        int r103 = this.mBindArgsCache.size();
    L5:
        if (r103 > r102) goto L7;
        this.mBindArgsCache.add(null);
        r103 = r103 + 1;
    L7:
        ListProtector.set(this.mBindArgsCache, r102, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        saveArgsToCache(r100, r101);
        this.mDelegate.bindBlob(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        saveArgsToCache(r100, Double.valueOf(r101));
        this.mDelegate.bindDouble(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        saveArgsToCache(r100, Long.valueOf(r101));
        this.mDelegate.bindLong(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        saveArgsToCache(r100, r101);
        this.mDelegate.bindString(r100, r101);
    }

    public QueryInterceptorStatement(SupportSQLiteStatement r100, RoomDatabase.QueryCallback r101, String r102, Executor r103) {
        this.mBindArgsCache = new ArrayList();
        this.mDelegate = r100;
        this.mQueryCallback = r101;
        this.mSqlStatement = r102;
        this.mQueryCallbackExecutor = r103;
    }
}
