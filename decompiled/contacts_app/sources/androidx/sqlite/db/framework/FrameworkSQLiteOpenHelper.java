package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper.Callback mCallback;
    private final Context mContext;
    private OpenHelper mDelegate;
    private final Object mLock;
    private final String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    static class OpenHelper extends SQLiteOpenHelper {
        final SupportSQLiteOpenHelper.Callback mCallback;
        final FrameworkSQLiteDatabase[] mDbRef;
        private boolean mMigrated;

        OpenHelper(Context r7, String r8, final FrameworkSQLiteDatabase[] r9, final SupportSQLiteOpenHelper.Callback r10) {
            super(r7, r8, null, r10.version, new AnonymousClass1(r10, r9));
            this.mCallback = r10;
            this.mDbRef = r9;
        }

        synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getWritableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            SupportSQLiteDatabase r1 = getWritableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            FrameworkSQLiteDatabase r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
            monitor-enter(this);
            this.mMigrated = false;     // Catch: Throwable -> L12
            SQLiteDatabase r0 = super.getReadableDatabase();     // Catch: Throwable -> L12
            if (this.mMigrated == false) goto L9;
            close();     // Catch: Throwable -> L12
            SupportSQLiteDatabase r1 = getReadableSupportDatabase();     // Catch: Throwable -> L12
            monitor-exit(this);
            return r1;
        L9:
            FrameworkSQLiteDatabase r2 = getWrappedDb(r0);     // Catch: Throwable -> L12
            monitor-exit(this);
            return r2;
        L12:
            th = move-exception;
            throw th;
        }

        FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase r1) {
            return getWrappedDb(this.mDbRef, r1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            this.mCallback.onCreate(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(r2), r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase r2) {
            this.mCallback.onConfigure(getWrappedDb(r2));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r2, int r3, int r4) {
            this.mMigrated = true;
            this.mCallback.onDowngrade(getWrappedDb(r2), r3, r4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase r2) {
            if (this.mMigrated == true) goto L6;
            this.mCallback.onOpen(getWrappedDb(r2));
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            monitor-enter(this);
            super.close();     // Catch: Throwable -> L6
            this.mDbRef[0] = null;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] r2, SQLiteDatabase r3) {
            FrameworkSQLiteDatabase r1 = r2[0];
            if (r1 != null) goto L5;
        L6:
            r2[0] = new FrameworkSQLiteDatabase(r3);
        L8:
            return r2[0];
        L5:
            if (r1.isDelegate(r3) == true) goto L8;
            goto L6
        }
    }

    FrameworkSQLiteOpenHelper(Context r2, String r3, SupportSQLiteOpenHelper.Callback r4) {
        this(r2, r3, r4, false);
    }

    FrameworkSQLiteOpenHelper(Context r1, String r2, SupportSQLiteOpenHelper.Callback r3, boolean r4) {
        this.mContext = r1;
        this.mName = r2;
        this.mCallback = r3;
        this.mUseNoBackupDirectory = r4;
        this.mLock = new Object();
    }

    private OpenHelper getDelegate() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mDelegate != null) goto L13;
        FrameworkSQLiteDatabase[] r1 = new FrameworkSQLiteDatabase[1];     // Catch: Throwable -> L16
        if (this.mName != null) goto L9;
    L11:
        this.mDelegate = new OpenHelper(this.mContext, this.mName, r1, this.mCallback);     // Catch: Throwable -> L16
    L12:
        this.mDelegate.setWriteAheadLoggingEnabled(this.mWriteAheadLoggingEnabled);     // Catch: Throwable -> L16
        goto L13
    L9:
        if (this.mUseNoBackupDirectory == false) goto L11;
        File r2 = new File(this.mContext.getNoBackupFilesDir(), this.mName);     // Catch: Throwable -> L16
        this.mDelegate = new OpenHelper(this.mContext, r2.getAbsolutePath(), r1, this.mCallback);     // Catch: Throwable -> L16
    L13:
        OpenHelper r6 = this.mDelegate;     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r6;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mName;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r3) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        OpenHelper r1 = this.mDelegate;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.setWriteAheadLoggingEnabled(r3);     // Catch: Throwable -> L10
    L7:
        this.mWriteAheadLoggingEnabled = r3;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getDelegate().close();
    }
}
