package net.zetetic.database.sqlcipher;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import androidx.room.AbstractC0351g;
import com.stepos.activeview.utils.Constants;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import k0.g;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.Logger;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public abstract class SQLiteOpenHelper implements g {
    private static final boolean DEBUG_STRICT_READONLY = false;
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final SQLiteDatabaseHook mDatabaseHook;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private boolean mIsInitializing;
    private final int mMinimumSupportedVersion;
    private final String mName;
    private final int mNewVersion;
    private byte[] mPassword;

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        this(context, str, cursorFactory, i4, null);
    }

    private static byte[] getBytes(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        ByteBuffer byteBufferEncode = Charset.forName(Constants.UTF_8_CODE).encode(CharBuffer.wrap(str));
        byte[] bArr = new byte[byteBufferEncode.limit()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    private SQLiteDatabase getDatabaseLocked(boolean z4) {
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        if (sQLiteDatabase != null) {
            if (!sQLiteDatabase.isOpen()) {
                this.mDatabase = null;
            } else if (!z4 || !this.mDatabase.isReadOnly()) {
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
                String path = this.mName;
                if (path == null) {
                    sQLiteDatabaseOpenDatabase = SQLiteDatabase.create(null);
                } else {
                    try {
                        if (!path.startsWith("file:")) {
                            path = this.mContext.getDatabasePath(path).getPath();
                        }
                        String str = path;
                        File file = new File(new File(str).getParent());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(str, this.mPassword, this.mFactory, this.mEnableWriteAheadLogging ? 805306368 : SQLiteDatabase.CREATE_IF_NECESSARY, this.mErrorHandler, this.mDatabaseHook);
                    } catch (SQLiteException e4) {
                        if (z4) {
                            throw e4;
                        }
                        Logger.e(TAG, "Couldn't open " + this.mName + " for writing (will try read-only):", e4);
                        sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(this.mName).getPath(), this.mPassword, this.mFactory, 1, this.mErrorHandler, this.mDatabaseHook);
                    }
                }
            } else if (z4 && sQLiteDatabaseOpenDatabase.isReadOnly()) {
                sQLiteDatabaseOpenDatabase.reopenReadWrite();
            }
            onConfigure(sQLiteDatabaseOpenDatabase);
            int version = sQLiteDatabaseOpenDatabase.getVersion();
            if (version != this.mNewVersion) {
                if (sQLiteDatabaseOpenDatabase.isReadOnly()) {
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabaseOpenDatabase.getVersion() + " to " + this.mNewVersion + ": " + this.mName);
                }
                if (version > 0 && version < this.mMinimumSupportedVersion) {
                    File file2 = new File(sQLiteDatabaseOpenDatabase.getPath());
                    onBeforeDelete(sQLiteDatabaseOpenDatabase);
                    sQLiteDatabaseOpenDatabase.close();
                    if (!SQLiteDatabase.deleteDatabase(file2)) {
                        throw new IllegalStateException("Unable to delete obsolete database " + this.mName + " with version " + version);
                    }
                    this.mIsInitializing = false;
                    SQLiteDatabase databaseLocked = getDatabaseLocked(z4);
                    this.mIsInitializing = false;
                    if (sQLiteDatabaseOpenDatabase != this.mDatabase) {
                        sQLiteDatabaseOpenDatabase.close();
                    }
                    return databaseLocked;
                }
                sQLiteDatabaseOpenDatabase.beginTransaction();
                try {
                    if (version == 0) {
                        onCreate(sQLiteDatabaseOpenDatabase);
                    } else {
                        int i4 = this.mNewVersion;
                        if (version > i4) {
                            onDowngrade(sQLiteDatabaseOpenDatabase, version, i4);
                        } else {
                            onUpgrade(sQLiteDatabaseOpenDatabase, version, i4);
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
                Logger.w(TAG, "Opened " + this.mName + " in read-only mode");
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
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

    public String getDatabaseName() {
        return this.mName;
    }

    public void onBeforeDelete(SQLiteDatabase sQLiteDatabase) {
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        throw new SQLiteException(B0.g.k("Can't downgrade database from version ", i4, " to ", i5));
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5);

    @Override // k0.g
    public void setWriteAheadLoggingEnabled(boolean z4) {
        synchronized (this) {
            try {
                if (this.mEnableWriteAheadLogging != z4) {
                    SQLiteDatabase sQLiteDatabase = this.mDatabase;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && !this.mDatabase.isReadOnly()) {
                        if (z4) {
                            this.mDatabase.enableWriteAheadLogging();
                        } else {
                            this.mDatabase.disableWriteAheadLogging();
                        }
                    }
                    this.mEnableWriteAheadLogging = z4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, cursorFactory, i4, 0, databaseErrorHandler);
    }

    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(false);
        }
        return databaseLocked;
    }

    @Override // k0.g
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase databaseLocked;
        synchronized (this) {
            databaseLocked = getDatabaseLocked(true);
        }
        return databaseLocked;
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4, int i5, DatabaseErrorHandler databaseErrorHandler) {
        this(context, str, new byte[0], cursorFactory, i4, i5, databaseErrorHandler, (SQLiteDatabaseHook) null, false);
    }

    public SQLiteOpenHelper(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i4, int i5, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4) {
        this(context, str, getBytes(str2), cursorFactory, i4, i5, databaseErrorHandler, sQLiteDatabaseHook, z4);
    }

    public SQLiteOpenHelper(Context context, String str, byte[] bArr, SQLiteDatabase.CursorFactory cursorFactory, int i4, int i5, DatabaseErrorHandler databaseErrorHandler, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4) {
        if (i4 >= 1) {
            this.mContext = context;
            this.mName = str;
            this.mPassword = bArr;
            this.mFactory = cursorFactory;
            this.mNewVersion = i4;
            this.mErrorHandler = databaseErrorHandler;
            this.mDatabaseHook = sQLiteDatabaseHook;
            this.mEnableWriteAheadLogging = z4;
            this.mMinimumSupportedVersion = Math.max(0, i5);
            return;
        }
        throw new IllegalArgumentException(AbstractC0351g.m("Version must be >= 1, was ", i4));
    }
}
