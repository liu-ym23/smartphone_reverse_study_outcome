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

/* JADX INFO: loaded from: classes17.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    public abstract List<T> convertRows(Cursor r100);

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true) == false) goto L6;
        this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        return;
    }

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        r100.copyArgumentsFrom(this.mSourceQuery);
        Cursor r101 = this.mDb.query(r100);
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    L4:
        if (r101.moveToFirst() == false) goto L8;
        int r102 = r101.getInt(0);     // Catch: Throwable -> L10
        r101.close();
        r100.release();
        return r102;
    L8:
        r101.close();
        r100.release();
        return 0;
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    private RoomSQLiteQuery getSQLiteQuery(int r100, int r101) {
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        r102.copyArgumentsFrom(this.mSourceQuery);
        r102.bindLong(r102.getArgCount() - 1, r101);
        r102.bindLong(r102.getArgCount(), r100);
        return r102;
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadInitial(PositionalDataSource.LoadInitialParams r100, PositionalDataSource.LoadInitialCallback<T> r101) {
        registerObserverIfNecessary();
        List<T> r102 = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor r103 = null;
        int r104 = countItems();     // Catch: Throwable -> L18
        if (r104 == 0) goto L10;
        int r105 = PositionalDataSource.computeInitialLoadPosition(r100, r104);     // Catch: Throwable -> L18
        RoomSQLiteQuery r106 = getSQLiteQuery(r105, PositionalDataSource.computeInitialLoadSize(r100, r105, r104));     // Catch: Throwable -> L18
        r103 = this.mDb.query(r106);     // Catch: Throwable -> L8
        List<T> r107 = convertRows(r103);     // Catch: Throwable -> L8
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L8
        RoomSQLiteQuery r108 = r106;
        int r109 = r105;
        r102 = r107;
    L11:
        if (r103 == null) goto L13;
        r103.close();
    L13:
        this.mDb.endTransaction();
        if (r108 == null) goto L16;
        r108.release();
    L16:
        r101.onResult(r102, r109, r104);
        return;
    L8:
        th = th;
    L20:
        if (r103 == null) goto L22;
        r103.close();
    L22:
        this.mDb.endTransaction();
        if (r106 == null) goto L25;
        r106.release();
    L25:
        throw th;
    L10:
        r109 = 0;
        r108 = null;
    L18:
        th = th;
        r106 = null;
        goto L20
    }

    public List<T> loadRange(int r100, int r101) {
        RoomSQLiteQuery r102 = getSQLiteQuery(r100, r101);
        if (this.mInTransaction == false) goto L15;
        this.mDb.beginTransaction();
        Cursor r103 = null;
        r103 = this.mDb.query(r102);     // Catch: Throwable -> L10
        List<T> r104 = convertRows(r103);     // Catch: Throwable -> L10
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        if (r103 == null) goto L8;
        r103.close();
    L8:
        this.mDb.endTransaction();
        r102.release();
        return r104;
    L10:
        th = move-exception;
        if (r103 == null) goto L13;
        r103.close();
    L13:
        this.mDb.endTransaction();
        r102.release();
        throw th;
    L15:
        Cursor r105 = this.mDb.query(r102);
        List<T> r106 = convertRows(r105);     // Catch: Throwable -> L19
        r105.close();
        r102.release();
        return r106;
    L19:
        th = move-exception;
        r105.close();
        r102.release();
        throw th;
    }

    @Override // androidx.paging.PositionalDataSource
    public void loadRange(PositionalDataSource.LoadRangeParams r100, PositionalDataSource.LoadRangeCallback<T> r101) {
        r101.onResult(loadRange(r100.startPosition, r100.loadSize));
    }

    public LimitOffsetDataSource(RoomDatabase r100, RoomSQLiteQuery r101, boolean r102, String... r110) {
        this(r100, r101, r102, true, r110);
    }

    public LimitOffsetDataSource(RoomDatabase r100, SupportSQLiteQuery r101, boolean r102, String... r103) {
        this(r100, RoomSQLiteQuery.copyFrom(r101), r102, r103);
    }

    public LimitOffsetDataSource(RoomDatabase r100, RoomSQLiteQuery r101, boolean r102, boolean r103, final String... r104) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = r100;
        this.mSourceQuery = r101;
        this.mInTransaction = r102;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + r101.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + r101.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new AnonymousClass1(this, r104);
        if (r103 == false) goto L6;
        registerObserverIfNecessary();
        return;
    }

    public LimitOffsetDataSource(RoomDatabase r100, SupportSQLiteQuery r101, boolean r102, boolean r110, String... r111) {
        this(r100, RoomSQLiteQuery.copyFrom(r101), r102, r110, r111);
    }
}
