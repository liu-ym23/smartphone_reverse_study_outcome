package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock;
    private volatile SupportSQLiteStatement mStmt;

    protected abstract String createQuery();

    public SharedSQLiteStatement(RoomDatabase database) {
        this.mLock = new AtomicBoolean(false);
        this.mDatabase = database;
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    private SupportSQLiteStatement createNewStatement() {
        String r0 = createQuery();
        return this.mDatabase.compileStatement(r0);
    }

    private SupportSQLiteStatement getStmt(boolean canUseCached) {
        if (canUseCached == false) goto L8;
        if (this.mStmt != null) goto L9;
        this.mStmt = createNewStatement();
    L9:
        return this.mStmt;
    L8:
        return createNewStatement();
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public void release(SupportSQLiteStatement statement) {
        if (statement != this.mStmt) goto L6;
        this.mLock.set(false);
        return;
    }
}
