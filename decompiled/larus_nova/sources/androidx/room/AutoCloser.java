package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
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

    public void closeDatabaseIfOpen() throws IOException {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mManuallyClosed = true;     // Catch: Throwable -> L11
        SupportSQLiteDatabase r101 = this.mDelegateDatabase;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        r101.close();     // Catch: Throwable -> L11
    L8:
        this.mDelegateDatabase = null;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void decrementCountAndScheduleClose() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mRefCount;     // Catch: Throwable -> L17
        if (r101 <= 0) goto L16;
        int r102 = r101 - 1;     // Catch: Throwable -> L17
        this.mRefCount = r102;     // Catch: Throwable -> L17
        if (r102 == 0) goto L9;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L9:
        if (this.mDelegateDatabase != null) goto L12;
        monitor-exit(r100);     // Catch: Throwable -> L17
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
        Object r100 = this.mLock;
        monitor-enter(r100);
        SupportSQLiteDatabase r101 = this.mDelegateDatabase;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public int getRefCountForTest() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mRefCount;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mHandler.removeCallbacks(this.mExecuteAutoCloser);     // Catch: Throwable -> L22
        this.mRefCount++;     // Catch: Throwable -> L22
        if (this.mManuallyClosed == true) goto L21;
        SupportSQLiteDatabase r101 = this.mDelegateDatabase;     // Catch: Throwable -> L22
        if (r101 != null) goto L9;
    L13:
        SupportSQLiteOpenHelper r102 = this.mDelegateOpenHelper;     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        SupportSQLiteDatabase r103 = r102.getWritableDatabase();     // Catch: Throwable -> L22
        this.mDelegateDatabase = r103;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r103;
    L19:
        throw new IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");     // Catch: Throwable -> L22
    L9:
        if (r101.isOpen() == false) goto L13;
        SupportSQLiteDatabase r104 = this.mDelegateDatabase;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r104;
    L21:
        throw new IllegalStateException("Attempting to open already closed database.");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public <V> V executeRefCountingFunction(Function<SupportSQLiteDatabase, V> r100) {
        V r101 = r100.apply(incrementCountAndEnsureDbIsOpen());     // Catch: Throwable -> L5
        decrementCountAndScheduleClose();
        return r101;
    L5:
        th = move-exception;
        decrementCountAndScheduleClose();
        throw th;
    }

    public void init(SupportSQLiteOpenHelper r100) {
        if (this.mDelegateOpenHelper == null) goto L5;
        return;
    L5:
        this.mDelegateOpenHelper = r100;
    }

    public void setAutoCloseCallback(Runnable r100) {
        this.mOnAutoCloseCallback = r100;
    }

    public AutoCloser(long r100, TimeUnit r101, Executor r102) {
        this.mDelegateOpenHelper = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOnAutoCloseCallback = null;
        this.mLock = new Object();
        this.mRefCount = 0;
        this.mLastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.mManuallyClosed = false;
        this.mExecuteAutoCloser = new AnonymousClass1(this);
        this.mAutoCloser = new AnonymousClass2(this);
        this.mAutoCloseTimeoutInMs = r101.toMillis(r100);
        this.mExecutor = r102;
    }
}
