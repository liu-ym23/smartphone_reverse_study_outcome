package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class AutoCloser {
    final long mAutoCloseTimeoutInMs;
    final Runnable mAutoCloser;
    SupportSQLiteDatabase mDelegateDatabase;
    private SupportSQLiteOpenHelper mDelegateOpenHelper;
    private final Runnable mExecuteAutoCloser;
    final Executor mExecutor;
    private final Handler mHandler;
    long mLastDecrementRefCountTimeStamp;
    final Object mLock;
    private boolean mManuallyClosed;
    Runnable mOnAutoCloseCallback;
    int mRefCount;

    AutoCloser(long autoCloseTimeoutAmount, TimeUnit autoCloseTimeUnit, Executor autoCloseExecutor) {
        this.mDelegateOpenHelper = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOnAutoCloseCallback = null;
        this.mLock = new Object();
        this.mRefCount = 0;
        this.mLastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.mManuallyClosed = false;
        this.mExecuteAutoCloser = new AnonymousClass1(this);
        this.mAutoCloser = new AnonymousClass2(this);
        this.mAutoCloseTimeoutInMs = autoCloseTimeUnit.toMillis(autoCloseTimeoutAmount);
        this.mExecutor = autoCloseExecutor;
    }

    public void init(SupportSQLiteOpenHelper delegateOpenHelper) {
        if (this.mDelegateOpenHelper == null) goto L6;
        Log.e("ROOM", "AutoCloser initialized multiple times. Please file a bug against room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
        return;
    L6:
        this.mDelegateOpenHelper = delegateOpenHelper;
    }

    public <V> V executeRefCountingFunction(Function<SupportSQLiteDatabase, V> function) {
        V r2 = function.apply(incrementCountAndEnsureDbIsOpen());     // Catch: Throwable -> L5
        decrementCountAndScheduleClose();
        return r2;
    L5:
        th = move-exception;
        decrementCountAndScheduleClose();
        throw th;
    }

    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHandler.removeCallbacks(this.mExecuteAutoCloser);     // Catch: Throwable -> L22
        this.mRefCount++;     // Catch: Throwable -> L22
        if (this.mManuallyClosed == true) goto L21;
        SupportSQLiteDatabase r1 = this.mDelegateDatabase;     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
    L13:
        SupportSQLiteOpenHelper r2 = this.mDelegateOpenHelper;     // Catch: Throwable -> L22
        if (r2 == null) goto L19;
        SupportSQLiteDatabase r3 = r2.getWritableDatabase();     // Catch: Throwable -> L22
        this.mDelegateDatabase = r3;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r3;
    L19:
        throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");     // Catch: Throwable -> L22
    L9:
        if (r1.isOpen() == false) goto L13;
        SupportSQLiteDatabase r4 = this.mDelegateDatabase;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r4;
    L21:
        throw new IllegalStateException("Attempting to open already closed database.");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public void decrementCountAndScheduleClose() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mRefCount;     // Catch: Throwable -> L17
        if (r1 <= 0) goto L16;
        int r2 = r1 - 1;     // Catch: Throwable -> L17
        this.mRefCount = r2;     // Catch: Throwable -> L17
        if (r2 == 0) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (this.mDelegateDatabase != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L12:
        this.mHandler.postDelayed(this.mExecuteAutoCloser, this.mAutoCloseTimeoutInMs);     // Catch: Throwable -> L17
        goto L13
    L16:
        throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public SupportSQLiteDatabase getDelegateDatabase() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SupportSQLiteDatabase r1 = this.mDelegateDatabase;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void closeDatabaseIfOpen() throws IOException {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mManuallyClosed = true;     // Catch: Throwable -> L11
        SupportSQLiteDatabase r1 = this.mDelegateDatabase;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.close();     // Catch: Throwable -> L11
    L8:
        this.mDelegateDatabase = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public int getRefCountForTest() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mRefCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAutoCloseCallback(Runnable onAutoClose) {
        this.mOnAutoCloseCallback = onAutoClose;
    }
}
