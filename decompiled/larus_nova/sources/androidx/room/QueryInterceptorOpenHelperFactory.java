package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes6.dex */
final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return new QueryInterceptorOpenHelper(this.mDelegate.create(r100), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory r100, RoomDatabase.QueryCallback r101, Executor r102) {
        this.mDelegate = r100;
        this.mQueryCallback = r101;
        this.mQueryCallbackExecutor = r102;
    }
}
