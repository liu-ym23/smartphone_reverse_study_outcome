package net.sqlcipher.database;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteMisuseException;
import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

/* loaded from: classes5.dex */
public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i10, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i10;
        this.mBindArgs = strArr;
    }

    private final native int native_column_count();

    private final native String native_column_name(int i10);

    private final native int native_fill_window(CursorWindow cursorWindow, int i10, int i11, int i12, int i13, int i14);

    public void bindArguments(Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj == null) {
                bindNull(i10 + 1);
            } else if (obj instanceof Double) {
                bindDouble(i10 + 1, ((Double) obj).doubleValue());
            } else if (obj instanceof Float) {
                bindDouble(i10 + 1, ((Number) obj).floatValue());
            } else if (obj instanceof Long) {
                bindLong(i10 + 1, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bindLong(i10 + 1, ((Number) obj).intValue());
            } else if (obj instanceof Boolean) {
                bindLong(i10 + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else if (obj instanceof byte[]) {
                bindBlob(i10 + 1, (byte[]) obj);
            } else {
                bindString(i10 + 1, obj.toString());
            }
        }
    }

    @Override // net.sqlcipher.database.SQLiteProgram, j1.InterfaceC4758e
    public void bindDouble(int i10, double d10) {
        this.mBindArgs[i10 - 1] = Double.toString(d10);
        if (this.mClosed) {
            return;
        }
        super.bindDouble(i10, d10);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, j1.InterfaceC4758e
    public void bindLong(int i10, long j10) {
        this.mBindArgs[i10 - 1] = Long.toString(j10);
        if (this.mClosed) {
            return;
        }
        super.bindLong(i10, j10);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, j1.InterfaceC4758e
    public void bindNull(int i10) {
        this.mBindArgs[i10 - 1] = null;
        if (this.mClosed) {
            return;
        }
        super.bindNull(i10);
    }

    @Override // net.sqlcipher.database.SQLiteProgram, j1.InterfaceC4758e
    public void bindString(int i10, String str) {
        this.mBindArgs[i10 - 1] = str;
        if (this.mClosed) {
            return;
        }
        super.bindString(i10, str);
    }

    public int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    public String columnNameLocked(int i10) {
        acquireReference();
        try {
            return native_column_name(i10);
        } finally {
            releaseReference();
        }
    }

    public int fillWindow(CursorWindow cursorWindow, int i10, int i11) throws Throwable {
        SQLiteQuery sQLiteQuery;
        CursorWindow cursorWindow2;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            try {
                try {
                    acquireReference();
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    releaseReference();
                    this.mDatabase.unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                cursorWindow.acquireReference();
                sQLiteQuery = this;
                cursorWindow2 = cursorWindow;
                try {
                    int iNative_fill_window = sQLiteQuery.native_fill_window(cursorWindow2, cursorWindow.getStartPosition(), cursorWindow.getRequiredPosition(), this.mOffsetIndex, i10, i11);
                    if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                        Log.d(TAG, "fillWindow(): " + sQLiteQuery.mSql);
                    }
                    cursorWindow2.releaseReference();
                    sQLiteQuery.releaseReference();
                    sQLiteQuery.mDatabase.unlock();
                    return iNative_fill_window;
                } catch (SQLiteDatabaseCorruptException e10) {
                    e = e10;
                    SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = e;
                    sQLiteQuery.mDatabase.onCorruption();
                    throw sQLiteDatabaseCorruptException;
                } catch (IllegalStateException unused) {
                    cursorWindow2.releaseReference();
                    sQLiteQuery.releaseReference();
                    sQLiteQuery.mDatabase.unlock();
                    return 0;
                }
            } catch (SQLiteDatabaseCorruptException e11) {
                e = e11;
                sQLiteQuery = this;
            } catch (IllegalStateException unused2) {
                sQLiteQuery = this;
                cursorWindow2 = cursorWindow;
            } catch (Throwable th4) {
                th = th4;
                Throwable th5 = th;
                cursorWindow.releaseReference();
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
            Throwable th22 = th;
            releaseReference();
            this.mDatabase.unlock();
            throw th22;
        }
    }

    public void requery() {
        String[] strArr = this.mBindArgs;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.mObjectBindArgs;
                if (objArr != null) {
                    bindArguments(objArr);
                    return;
                }
                int i10 = 0;
                while (i10 < length) {
                    int i11 = i10 + 1;
                    super.bindString(i11, this.mBindArgs[i10]);
                    i10 = i11;
                }
            } catch (SQLiteMisuseException e10) {
                StringBuilder sb2 = new StringBuilder("mSql " + this.mSql);
                for (int i12 = 0; i12 < length; i12++) {
                    sb2.append(" ");
                    sb2.append(this.mBindArgs[i12]);
                }
                sb2.append(" ");
                throw new IllegalStateException(sb2.toString(), e10);
            }
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    public SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i10, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i10;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[objArr != null ? objArr.length : 0];
    }
}
