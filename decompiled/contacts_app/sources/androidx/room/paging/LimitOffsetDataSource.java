package androidx.room.paging;

import android.database.Cursor;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    protected abstract List<T> convertRows(Cursor cursor);

    protected LimitOffsetDataSource(RoomDatabase db, SupportSQLiteQuery query, boolean inTransaction, String... tables) {
        this(db, RoomSQLiteQuery.copyFrom(query), inTransaction, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, SupportSQLiteQuery query, boolean inTransaction, boolean registerObserverImmediately, String... tables) {
        this(db, RoomSQLiteQuery.copyFrom(query), inTransaction, registerObserverImmediately, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, RoomSQLiteQuery query, boolean inTransaction, String... tables) {
        this(db, query, inTransaction, true, tables);
    }

    protected LimitOffsetDataSource(RoomDatabase db, RoomSQLiteQuery query, boolean inTransaction, boolean registerObserverImmediately, final String... tables) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = db;
        this.mSourceQuery = query;
        this.mInTransaction = inTransaction;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + query.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + query.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new AnonymousClass1(this, tables);
        if (registerObserverImmediately == false) goto L6;
        registerObserverIfNecessary();
        return;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true) == false) goto L6;
        this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        return;
    }

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        r0.copyArgumentsFrom(this.mSourceQuery);
        Cursor r3 = this.mDb.query(r0);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        int r1 = r3.getInt(0);     // Catch: Throwable -> L10
        r3.close();
        r0.release();
        return r1;
    L8:
        r3.close();
        r0.release();
        return 0;
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(PositionalDataSource.LoadInitialParams params, PositionalDataSource.LoadInitialCallback<T> callback) {
        registerObserverIfNecessary();
        List<T> r0 = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor r1 = null;
        int r2 = countItems();     // Catch: Throwable -> L18
        if (r2 == 0) goto L10;
        int r3 = computeInitialLoadPosition(params, r2);     // Catch: Throwable -> L18
        RoomSQLiteQuery r7 = getSQLiteQuery(r3, computeInitialLoadSize(params, r3, r2));     // Catch: Throwable -> L18
        r1 = this.mDb.query(r7);     // Catch: Throwable -> L8
        List<T> r4 = convertRows(r1);     // Catch: Throwable -> L8
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L8
        RoomSQLiteQuery r5 = r7;
        int r8 = r3;
        r0 = r4;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        this.mDb.endTransaction();
        if (r5 == null) goto L16;
        r5.release();
    L16:
        callback.onResult(r0, r8, r2);
        return;
    L8:
        th = th;
    L20:
        if (r1 == null) goto L22;
        r1.close();
    L22:
        this.mDb.endTransaction();
        if (r7 == null) goto L25;
        r7.release();
    L25:
        throw th;
    L10:
        r8 = 0;
        r5 = null;
    L18:
        th = th;
        r7 = null;
        goto L20
    }

    public void loadRange(PositionalDataSource.LoadRangeParams params, PositionalDataSource.LoadRangeCallback<T> callback) {
        callback.onResult(loadRange(params.startPosition, params.loadSize));
    }

    public List<T> loadRange(int startPosition, int loadCount) {
        RoomSQLiteQuery r3 = getSQLiteQuery(startPosition, loadCount);
        if (this.mInTransaction == false) goto L15;
        this.mDb.beginTransaction();
        Cursor r4 = null;
        r4 = this.mDb.query(r3);     // Catch: Throwable -> L10
        List<T> r0 = convertRows(r4);     // Catch: Throwable -> L10
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r4.close();
    L8:
        this.mDb.endTransaction();
        r3.release();
        return r0;
    L10:
        th = move-exception;
        if (r4 == null) goto L13;
        r4.close();
    L13:
        this.mDb.endTransaction();
        r3.release();
        throw th;
    L15:
        Cursor r5 = this.mDb.query(r3);
        List<T> r2 = convertRows(r5);     // Catch: Throwable -> L19
        r5.close();
        r3.release();
        return r2;
    L19:
        th = move-exception;
        r5.close();
        r3.release();
        throw th;
    }

    private RoomSQLiteQuery getSQLiteQuery(int startPosition, int loadCount) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        r0.copyArgumentsFrom(this.mSourceQuery);
        r0.bindLong(r0.getArgCount() - 1, loadCount);
        r0.bindLong(r0.getArgCount(), startPosition);
        return r0;
    }
}
