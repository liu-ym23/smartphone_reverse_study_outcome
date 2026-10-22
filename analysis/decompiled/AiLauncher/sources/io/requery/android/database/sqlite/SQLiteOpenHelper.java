package io.requery.android.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import io.requery.android.database.DatabaseErrorHandler;
import io.requery.android.database.sqlite.SQLiteDatabase;
import j1.InterfaceC4757d;

/* loaded from: classes4.dex */
public abstract class SQLiteOpenHelper implements InterfaceC4757d {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(context, str, cursorFactory, i10, null);
    }

    private SQLiteDatabase getDatabaseLocked(boolean z10) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z10 || !this.mDatabase.isReadOnly()) {
                return this.mDatabase;
            }
        }
        if (this.mIsInitializing) {
            throw new IllegalStateException("getDatabase called recursively");
        }
        SQLiteDatabase sQLiteDatabaseOpenDatabase = this.mDatabase;
        try {
            this.mIsInitializing = true;
            if (sQLiteDatabaseOpenDatabase == null) {
                String str = this.mName;
                if (str == null) {
                    sQLiteDatabaseOpenDatabase = SQLiteDatabase.create(null);
                } else {
                    try {
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(createConfiguration(this.mContext.getDatabasePath(str).getPath(), (this.mEnableWriteAheadLogging ? SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING : 0) | 6), this.mFactory, this.mErrorHandler);
                    } catch (SQLiteException e10) {
                        if (z10) {
                            throw e10;
                        }
                        Log.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e10);
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(createConfiguration(this.mContext.getDatabasePath(this.mName).getPath(), 1), this.mFactory, this.mErrorHandler);
                    }
                }
            } else if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                sQLiteDatabaseOpenDatabase.reopenReadWrite();
            }
            onConfigure(sQLiteDatabaseOpenDatabase);
            int version = sQLiteDatabaseOpenDatabase.getVersion();
            if (version != this.mNewVersion) {
                if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabaseOpenDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
                sQLiteDatabaseOpenDatabase.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(sQLiteDatabaseOpenDatabase);
                    } else {
                        int i10 = this.mNewVersion;
                        if (version > i10) {
                            onDowngrade(sQLiteDatabaseOpenDatabase, version, i10);
                        } else {
                            onUpgrade(sQLiteDatabaseOpenDatabase, version, i10);
                        }
                    }
                    sQLiteDatabaseOpenDatabase.setVersion(this.mNewVersion);
                    sQLiteDatabaseOpenDatabase.setTransactionSuccessful();
                    sQLiteDatabaseOpenDatabase.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabaseOpenDatabase.endTransaction();
                    throw th;
                }
            }
            onOpen(sQLiteDatabaseOpenDatabase);
            if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                Log.w(TAG, "Opened " + this.mName + " in read-only mode");
            }
            this.mDatabase = sQLiteDatabaseOpenDatabase;
            this.mIsInitializing = false;
            return sQLiteDatabaseOpenDatabase;
        } catch (Throwable th2) {
            this.mIsInitializing = false;
            if (sQLiteDatabaseOpenDatabase != null && sQLiteDatabaseOpenDatabase != this.mDatabase) {
                sQLiteDatabaseOpenDatabase.close();
            }
            throw th2;
        }
    }

    @Override // j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.mIsInitializing) {
            throw new IllegalStateException("Closed during initialization");
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
    }

    public SQLiteDatabaseConfiguration createConfiguration(String str, int i10) {
        return new SQLiteDatabaseConfiguration(str, i10);
    }

    @Override // j1.InterfaceC4757d
    /* renamed from: getDatabaseName */
    public String getName() {
        return this.mName;
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new SQLiteException("Can't downgrade database from version " + i10 + " to " + i11);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11);

    @Override // j1.InterfaceC4757d
    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z10) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                        if (z10) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                    }
                    this.mEnableWriteAheadLogging = z10;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, DatabaseErrorHandler databaseErrorHandler) {
        if (i10 < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i10);
        }
        this.mContext = context;
        this.mName = str;
        this.mFactory = cursorFactory;
        this.mNewVersion = i10;
        this.mErrorHandler = databaseErrorHandler;
    }

    @Override // j1.InterfaceC4757d
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    @Override // j1.InterfaceC4757d
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }
}
