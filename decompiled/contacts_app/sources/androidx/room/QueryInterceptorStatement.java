package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> mBindArgsCache;
    private final SupportSQLiteStatement mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;
    private final String mSqlStatement;

    QueryInterceptorStatement(SupportSQLiteStatement compileStatement, RoomDatabase.QueryCallback queryCallback, String sqlStatement, Executor queryCallbackExecutor) {
        this.mBindArgsCache = new ArrayList();
        this.mDelegate = compileStatement;
        this.mQueryCallback = queryCallback;
        this.mSqlStatement = sqlStatement;
        this.mQueryCallbackExecutor = queryCallbackExecutor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.mQueryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda1(this));
        this.mDelegate.execute();
    }

    /* JADX INFO: renamed from: lambda$execute$0$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    /* synthetic */ void m80lambda$execute$0$androidxroomQueryInterceptorStatement() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.mQueryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda0(this));
        return this.mDelegate.executeUpdateDelete();
    }

    /* JADX INFO: renamed from: lambda$executeUpdateDelete$1$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    /* synthetic */ void m82x7bfa4cf9() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.mQueryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda2(this));
        return this.mDelegate.executeInsert();
    }

    /* JADX INFO: renamed from: lambda$executeInsert$2$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    /* synthetic */ void m81lambda$executeInsert$2$androidxroomQueryInterceptorStatement() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    /* JADX INFO: renamed from: lambda$simpleQueryForLong$3$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    /* synthetic */ void m83xa983133b() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.mQueryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda4(this));
        return this.mDelegate.simpleQueryForLong();
    }

    /* JADX INFO: renamed from: lambda$simpleQueryForString$4$androidx-room-QueryInterceptorStatement, reason: not valid java name */
    /* synthetic */ void m84x12aaf991() {
        this.mQueryCallback.onQuery(this.mSqlStatement, this.mBindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.mQueryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda3(this));
        return this.mDelegate.simpleQueryForString();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        saveArgsToCache(index, this.mBindArgsCache.toArray());
        this.mDelegate.bindNull(index);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        saveArgsToCache(index, Long.valueOf(value));
        this.mDelegate.bindLong(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        saveArgsToCache(index, Double.valueOf(value));
        this.mDelegate.bindDouble(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        saveArgsToCache(index, value);
        this.mDelegate.bindString(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        saveArgsToCache(index, value);
        this.mDelegate.bindBlob(index, value);
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

    private void saveArgsToCache(int bindIndex, Object value) {
        int r4 = bindIndex - 1;
        if (r4 < this.mBindArgsCache.size()) goto L7;
        int r0 = this.mBindArgsCache.size();
    L5:
        if (r0 > r4) goto L7;
        this.mBindArgsCache.add(null);
        r0 = r0 + 1;
    L7:
        this.mBindArgsCache.set(r4, value);
    }
}
