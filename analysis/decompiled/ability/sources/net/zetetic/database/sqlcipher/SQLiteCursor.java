package net.zetetic.database.sqlcipher;

import android.database.AbstractWindowedCursor;
import android.database.CursorWindow;
import android.util.Log;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    public static final int g = (int) (Math.pow(1024.0d, 2.0d) * 8.0d);

    /* renamed from: a, reason: collision with root package name */
    public final String[] f5392a;
    public final SQLiteQuery b;
    public final SQLiteCursorDriver c;
    public int d;
    public int e;
    public HashMap f;

    @Deprecated
    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public final void b(int i) {
        SQLiteQuery sQLiteQuery = this.b;
        String path = sQLiteQuery.b.getPath();
        int i6 = g + 512;
        CursorWindow window = getWindow();
        if (window == null) {
            setWindow(new CursorWindow(path, i6));
        } else {
            window.clear();
        }
        try {
            if (this.d != -1) {
                sQLiteQuery.l(((AbstractWindowedCursor) this).mWindow, Math.max(i - (this.e / 3), 0), i, false);
                return;
            }
            this.d = sQLiteQuery.l(((AbstractWindowedCursor) this).mWindow, Math.max(i, 0), i, true);
            this.e = ((AbstractWindowedCursor) this).mWindow.getNumRows();
            if (Log.isLoggable("SQLiteCursor", 3)) {
                Log.d("SQLiteCursor", "received count(*) from native_fill_window: " + this.d);
            }
        } catch (RuntimeException e) {
            setWindow(null);
            throw e;
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        synchronized (this) {
            this.b.f();
            this.c.getClass();
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final void deactivate() {
        super.deactivate();
        this.c.getClass();
    }

    @Override // android.database.AbstractCursor
    public final void finalize() throws Throwable {
        try {
            if (((AbstractWindowedCursor) this).mWindow != null) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getColumnIndex(String str) {
        if (this.f == null) {
            String[] strArr = this.f5392a;
            int length = strArr.length;
            HashMap map = new HashMap(length, 1.0f);
            for (int i = 0; i < length; i++) {
                map.put(strArr[i], Integer.valueOf(i));
            }
            this.f = map;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            Log.e("SQLiteCursor", "requesting column name with table name -- ".concat(str), new Exception());
            str = str.substring(iLastIndexOf + 1);
        }
        Integer num = (Integer) this.f.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final String[] getColumnNames() {
        return this.f5392a;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final int getCount() {
        if (this.d == -1) {
            b(0);
        }
        return this.d;
    }

    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    public final boolean onMove(int i, int i6) {
        CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
        if (cursorWindow != null && i6 >= cursorWindow.getStartPosition()) {
            if (i6 < ((AbstractWindowedCursor) this).mWindow.getNumRows() + ((AbstractWindowedCursor) this).mWindow.getStartPosition()) {
                return true;
            }
        }
        b(i6);
        return true;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public final boolean requery() {
        if (isClosed()) {
            return false;
        }
        synchronized (this) {
            try {
                if (!this.b.b.isOpen()) {
                    return false;
                }
                CursorWindow cursorWindow = ((AbstractWindowedCursor) this).mWindow;
                if (cursorWindow != null) {
                    cursorWindow.clear();
                }
                ((AbstractWindowedCursor) this).mPos = -1;
                this.d = -1;
                this.c.getClass();
                try {
                    return super.requery();
                } catch (IllegalStateException e) {
                    Log.w("SQLiteCursor", "requery() failed " + e.getMessage(), e);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.database.AbstractWindowedCursor
    public final void setWindow(CursorWindow cursorWindow) {
        super.setWindow(cursorWindow);
        this.d = -1;
    }

    public SQLiteCursor(SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.d = -1;
        if (sQLiteQuery == null) {
            throw new IllegalArgumentException("query object cannot be null");
        }
        this.c = sQLiteCursorDriver;
        this.f = null;
        this.b = sQLiteQuery;
        this.f5392a = sQLiteQuery.e;
    }
}
