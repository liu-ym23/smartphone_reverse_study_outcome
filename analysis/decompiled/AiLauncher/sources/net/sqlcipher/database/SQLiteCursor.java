package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.database.SQLException;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;

/* loaded from: classes5.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private String[] mColumns;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    protected MainThreadNotificationHandler mNotificationHandler;
    private SQLiteQuery mQuery;
    private int mCount = -1;
    private int mCursorWindowCapacity = 0;
    private boolean fillWindowForwardOnly = false;
    private int mMaxRead = Integer.MAX_VALUE;
    private int mInitialRead = Integer.MAX_VALUE;
    private int mCursorState = 0;
    private ReentrantLock mLock = null;
    private boolean mPendingData = false;
    private Throwable mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    private Map<String, Integer> mColumnNameMap = null;

    public static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        public MainThreadNotificationHandler(SQLiteCursor sQLiteCursor) {
            this.wrappedCursor = new WeakReference<>(sQLiteCursor);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SQLiteCursor sQLiteCursor = this.wrappedCursor.get();
            if (sQLiteCursor != null) {
                sQLiteCursor.notifyDataSetChange();
            }
        }
    }

    public final class QueryThread implements Runnable {
        private final int mThreadState;

        public QueryThread(int i10) {
            this.mThreadState = i10;
        }

        private void sendMessage() {
            SQLiteCursor sQLiteCursor = SQLiteCursor.this;
            MainThreadNotificationHandler mainThreadNotificationHandler = sQLiteCursor.mNotificationHandler;
            if (mainThreadNotificationHandler == null) {
                sQLiteCursor.mPendingData = true;
            } else {
                mainThreadNotificationHandler.sendEmptyMessage(1);
                SQLiteCursor.this.mPendingData = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            CursorWindow cursorWindow = ((AbstractWindowedCursor) SQLiteCursor.this).mWindow;
            Process.setThreadPriority(Process.myTid(), 10);
            while (true) {
                if (SQLiteCursor.this.mLock == null) {
                    SQLiteCursor.this.mLock = new ReentrantLock(true);
                }
                SQLiteCursor.this.mLock.lock();
                if (SQLiteCursor.this.mCursorState != this.mThreadState) {
                    return;
                }
                try {
                    int iFillWindow = SQLiteCursor.this.mQuery.fillWindow(cursorWindow, SQLiteCursor.this.mMaxRead, SQLiteCursor.this.mCount);
                    if (iFillWindow == 0) {
                        return;
                    }
                    if (iFillWindow != -1) {
                        SQLiteCursor.this.mCount = iFillWindow;
                        sendMessage();
                        return;
                    } else {
                        SQLiteCursor sQLiteCursor = SQLiteCursor.this;
                        SQLiteCursor.access$512(sQLiteCursor, sQLiteCursor.mMaxRead);
                        sendMessage();
                    }
                } catch (Exception unused) {
                    return;
                } finally {
                    SQLiteCursor.this.mLock.unlock();
                }
            }
        }
    }

    public SQLiteCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        this.mDatabase = sQLiteDatabase;
        this.mDriver = sQLiteCursorDriver;
        this.mEditTable = str;
        this.mQuery = sQLiteQuery;
        try {
            sQLiteDatabase.lock();
            int iColumnCountLocked = this.mQuery.columnCountLocked();
            this.mColumns = new String[iColumnCountLocked];
            for (int i10 = 0; i10 < iColumnCountLocked; i10++) {
                String strColumnNameLocked = this.mQuery.columnNameLocked(i10);
                this.mColumns[i10] = strColumnNameLocked;
                if (StepOSRecipientEmailHistory._ID.equals(strColumnNameLocked)) {
                    this.mRowIdColumnIndex = i10;
                }
            }
        } finally {
            sQLiteDatabase.unlock();
        }
    }

    public static /* synthetic */ int access$512(SQLiteCursor sQLiteCursor, int i10) {
        int i11 = sQLiteCursor.mCount + i10;
        sQLiteCursor.mCount = i11;
        return i11;
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.mWindow = null;
        }
    }

    private void fillWindow(int i10) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        int iCursorPickFillWindowStartPosition = this.fillWindowForwardOnly ? i10 : this.mCount == -1 ? cursorPickFillWindowStartPosition(i10, 0) : cursorPickFillWindowStartPosition(i10, this.mCursorWindowCapacity);
        this.mWindow.setStartPosition(iCursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i10);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = iCursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }

    private void queryThreadLock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.lock();
        }
    }

    private void queryThreadUnlock() {
        ReentrantLock reentrantLock = this.mLock;
        if (reentrantLock != null) {
            reentrantLock.unlock();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (!supportsUpdates()) {
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (map != null) {
                try {
                    this.mUpdatedRows.putAll(map);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mUpdatedRows.size() == 0) {
                return true;
            }
            this.mDatabase.beginTransaction();
            try {
                StringBuilder sb2 = new StringBuilder(128);
                for (Map.Entry<Long, Map<String, Object>> entry : this.mUpdatedRows.entrySet()) {
                    Map<String, Object> value = entry.getValue();
                    Long key = entry.getKey();
                    if (key == null || value == null) {
                        throw new IllegalStateException("null rowId or values found! rowId = " + key + ", values = " + value);
                    }
                    if (value.size() != 0) {
                        long jLongValue = key.longValue();
                        Iterator<Map.Entry<String, Object>> it = value.entrySet().iterator();
                        sb2.setLength(0);
                        sb2.append("UPDATE " + this.mEditTable + " SET ");
                        Object[] objArr = new Object[value.size()];
                        int i10 = 0;
                        while (it.hasNext()) {
                            Map.Entry<String, Object> next = it.next();
                            sb2.append(next.getKey());
                            sb2.append("=?");
                            objArr[i10] = next.getValue();
                            if (it.hasNext()) {
                                sb2.append(", ");
                            }
                            i10++;
                        }
                        sb2.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + '=' + jLongValue);
                        sb2.append(';');
                        this.mDatabase.execSQL(sb2.toString(), objArr);
                        this.mDatabase.rowUpdated(this.mEditTable, jLongValue);
                    }
                }
                this.mDatabase.setTransactionSuccessful();
                this.mDatabase.endTransaction();
                this.mUpdatedRows.clear();
                onChange(true);
                return true;
            } catch (Throwable th2) {
                this.mDatabase.endTransaction();
                throw th2;
            }
        }
    }

    public int cursorPickFillWindowStartPosition(int i10, int i11) {
        return Math.max(i10 - (i11 / 3), 0);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean z10;
        checkPosition();
        if (this.mRowIdColumnIndex == -1 || this.mCurrentRowID == null) {
            return false;
        }
        this.mDatabase.lock();
        try {
            try {
                this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});
                z10 = true;
            } catch (SQLException unused) {
                z10 = false;
            }
            int i10 = this.mPos;
            requery();
            moveToPosition(i10);
            if (!z10) {
                return false;
            }
            onChange(true);
            return true;
        } finally {
            this.mDatabase.unlock();
        }
    }

    @Override // net.sqlcipher.AbstractCursor
    public void finalize() {
        try {
            if (this.mWindow != null) {
                this.mQuery.mSql.getClass();
                close();
                SQLiteDebug.notifyActiveCursorFinalized();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String str) {
        if (this.mColumnNameMap == null) {
            String[] strArr = this.mColumns;
            int length = strArr.length;
            HashMap map = new HashMap(length, 1.0f);
            for (int i10 = 0; i10 < length; i10++) {
                map.put(strArr[i10], Integer.valueOf(i10));
            }
            this.mColumnNameMap = map;
        }
        if (str.lastIndexOf(46) != -1) {
            new Exception();
        }
        Integer num = this.mColumnNameMap.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount == -1) {
            fillWindow(0);
        }
        return this.mCount;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int i10, int i11) {
        CursorWindow cursorWindow = this.mWindow;
        if (cursorWindow != null && i11 >= cursorWindow.getStartPosition() && i11 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
            return true;
        }
        fillWindow(i11);
        return true;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        if (!(Integer.MAX_VALUE == this.mMaxRead && Integer.MAX_VALUE == this.mInitialRead) && this.mNotificationHandler == null) {
            queryThreadLock();
            try {
                this.mNotificationHandler = new MainThreadNotificationHandler(this);
                if (this.mPendingData) {
                    notifyDataSetChange();
                    this.mPendingData = false;
                }
            } finally {
                queryThreadUnlock();
            }
        }
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed()) {
            return false;
        }
        this.mDatabase.lock();
        try {
            CursorWindow cursorWindow = this.mWindow;
            if (cursorWindow != null) {
                cursorWindow.clear();
            }
            this.mPos = -1;
            this.mDriver.cursorRequeried(this);
            this.mCount = -1;
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mQuery.requery();
                this.mDatabase.unlock();
                return super.requery();
            } finally {
                queryThreadUnlock();
            }
        } catch (Throwable th) {
            this.mDatabase.unlock();
            throw th;
        }
    }

    public void setFillWindowForwardOnly(boolean z10) {
        this.fillWindowForwardOnly = z10;
    }

    public void setLoadStyle(int i10, int i11) {
        this.mMaxRead = i11;
        this.mInitialRead = i10;
        this.mLock = new ReentrantLock(true);
    }

    public void setSelectionArguments(String[] strArr) {
        this.mDriver.setBindArguments(strArr);
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow cursorWindow) {
        if (this.mWindow != null) {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.close();
                queryThreadUnlock();
                this.mCount = -1;
            } catch (Throwable th) {
                queryThreadUnlock();
                throw th;
            }
        }
        this.mWindow = cursorWindow;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int i10, android.database.CursorWindow cursorWindow) {
        int iCursorPickFillWindowStartPosition;
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(true);
        } else {
            this.mCursorState++;
            queryThreadLock();
            try {
                this.mWindow.clear();
            } finally {
                queryThreadUnlock();
            }
        }
        if (this.fillWindowForwardOnly) {
            iCursorPickFillWindowStartPosition = i10;
        } else if (this.mCount == -1) {
            iCursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i10, 0);
        } else {
            iCursorPickFillWindowStartPosition = cursorPickFillWindowStartPosition(i10, this.mCursorWindowCapacity);
        }
        this.mWindow.setStartPosition(iCursorPickFillWindowStartPosition);
        this.mWindow.setRequiredPosition(i10);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity == 0) {
            this.mCursorWindowCapacity = this.mWindow.getNumRows();
        }
        if (this.mCount == -1) {
            this.mCount = iCursorPickFillWindowStartPosition + this.mInitialRead;
            new Thread(new QueryThread(this.mCursorState), "query thread").start();
        }
    }
}
