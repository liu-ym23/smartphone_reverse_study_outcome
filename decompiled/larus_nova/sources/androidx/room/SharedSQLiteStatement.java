package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SharedSQLiteStatement {
    private final RoomDatabase mDatabase;
    private final AtomicBoolean mLock;
    private volatile SupportSQLiteStatement mStmt;

    public abstract String createQuery();

    public void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    private SupportSQLiteStatement createNewStatement() {
        String r100 = createQuery();
        return this.mDatabase.compileStatement(r100);
    }

    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    public SharedSQLiteStatement(RoomDatabase r100) {
        this.mLock = new AtomicBoolean(false);
        this.mDatabase = r100;
    }

    private SupportSQLiteStatement getStmt(boolean r100) {
        if (r100 == false) goto L8;
        if (this.mStmt != null) goto L9;
        this.mStmt = createNewStatement();
    L9:
        return this.mStmt;
    L8:
        return createNewStatement();
    }

    public void release(SupportSQLiteStatement r100) {
        if (r100 != this.mStmt) goto L6;
        this.mLock.set(false);
        return;
    }
}
