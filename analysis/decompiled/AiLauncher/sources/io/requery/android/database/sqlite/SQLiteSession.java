package io.requery.android.database.sqlite;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.ParcelFileDescriptor;
import io.requery.android.database.CursorWindow;
import x0.d;

@SuppressLint({"Assert"})
/* loaded from: classes4.dex */
public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    public static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        }
        this.mConnectionPool = sQLiteConnectionPool;
    }

    private void acquireConnection(String str, int i10, d dVar) {
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i10, dVar);
            this.mConnectionFlags = i10;
        }
        this.mConnectionUseCount++;
    }

    private void beginTransactionUnchecked(int i10, SQLiteTransactionListener sQLiteTransactionListener, int i11, d dVar) {
        if (dVar != null) {
            dVar.d();
        }
        if (this.mTransactionStack == null) {
            acquireConnection(null, i11, dVar);
        }
        try {
            if (this.mTransactionStack == null) {
                if (i10 == 1) {
                    this.mConnection.execute("BEGIN IMMEDIATE;", null, dVar);
                } else if (i10 != 2) {
                    this.mConnection.execute("BEGIN;", null, dVar);
                } else {
                    this.mConnection.execute("BEGIN EXCLUSIVE;", null, dVar);
                }
            }
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.onBegin();
                } catch (RuntimeException e10) {
                    if (this.mTransactionStack == null) {
                        this.mConnection.execute("ROLLBACK;", null, dVar);
                    }
                    throw e10;
                }
            }
            Transaction transactionObtainTransaction = obtainTransaction(i10, sQLiteTransactionListener);
            transactionObtainTransaction.mParent = this.mTransactionStack;
            this.mTransactionStack = transactionObtainTransaction;
        } catch (Throwable th) {
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
            throw th;
        }
    }

    private void endTransactionUnchecked(d dVar, boolean z10) {
        if (dVar != null) {
            dVar.d();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z11 = false;
        boolean z12 = (transaction.mMarkedSuccessful || z10) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener != null) {
            try {
                if (z12) {
                    sQLiteTransactionListener.onCommit();
                } else {
                    sQLiteTransactionListener.onRollback();
                }
                z11 = z12;
                e = null;
            } catch (RuntimeException e10) {
                e = e10;
            }
        } else {
            z11 = z12;
            e = null;
        }
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        Transaction transaction2 = this.mTransactionStack;
        if (transaction2 == null) {
            try {
                if (z11) {
                    this.mConnection.execute("COMMIT;", null, dVar);
                } else {
                    this.mConnection.execute("ROLLBACK;", null, dVar);
                }
                releaseConnection();
            } catch (Throwable th) {
                releaseConnection();
                throw th;
            }
        } else if (!z11) {
            transaction2.mChildFailed = true;
        }
        if (e != null) {
            throw e;
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i10, d dVar) {
        if (dVar != null) {
            dVar.d();
        }
        int sqlStatementType = SQLiteStatementType.getSqlStatementType(str);
        if (sqlStatementType == 4) {
            beginTransaction(2, null, i10, dVar);
            return true;
        }
        if (sqlStatementType == 5) {
            setTransactionSuccessful();
            endTransaction(dVar);
            return true;
        }
        if (sqlStatementType != 6) {
            return false;
        }
        endTransaction(dVar);
        return true;
    }

    private Transaction obtainTransaction(int i10, SQLiteTransactionListener sQLiteTransactionListener) {
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i10;
        transaction.mListener = sQLiteTransactionListener;
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }

    private void releaseConnection() {
        int i10 = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i10;
        if (i10 == 0) {
            try {
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
            }
        }
    }

    private void throwIfNestedTransaction() {
        if (hasNestedTransaction()) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
    }

    private void throwIfNoTransaction() {
        if (this.mTransactionStack == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
    }

    private void throwIfTransactionMarkedSuccessful() {
        Transaction transaction = this.mTransactionStack;
        if (transaction != null && transaction.mMarkedSuccessful) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    private boolean yieldTransactionUnchecked(long j10, d dVar) throws InterruptedException {
        if (dVar != null) {
            dVar.d();
        }
        if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            return false;
        }
        Transaction transaction = this.mTransactionStack;
        int i10 = transaction.mMode;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        int i11 = this.mConnectionFlags;
        endTransactionUnchecked(dVar, true);
        if (j10 > 0) {
            try {
                Thread.sleep(j10);
            } catch (InterruptedException unused) {
            }
        }
        beginTransactionUnchecked(i10, sQLiteTransactionListener, i11, dVar);
        return true;
    }

    public void beginTransaction(int i10, SQLiteTransactionListener sQLiteTransactionListener, int i11, d dVar) {
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i10, sQLiteTransactionListener, i11, dVar);
    }

    public void endTransaction(d dVar) {
        throwIfNoTransaction();
        endTransactionUnchecked(dVar, false);
    }

    public void execute(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return;
        }
        acquireConnection(str, i10, dVar);
        try {
            this.mConnection.execute(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public ParcelFileDescriptor executeForBlobFileDescriptor(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return null;
        }
        acquireConnection(str, i10, dVar);
        try {
            return this.mConnection.executeForBlobFileDescriptor(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public int executeForChangedRowCount(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return 0;
        }
        acquireConnection(str, i10, dVar);
        try {
            return this.mConnection.executeForChangedRowCount(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i10, int i11, boolean z10, int i12, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        if (executeSpecial(str, objArr, i12, dVar)) {
            cursorWindow.clear();
            return 0;
        }
        acquireConnection(str, i12, dVar);
        try {
            return this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i10, i11, z10, dVar);
        } finally {
            releaseConnection();
        }
    }

    public long executeForLastInsertedRowId(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return 0L;
        }
        acquireConnection(str, i10, dVar);
        try {
            return this.mConnection.executeForLastInsertedRowId(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public long executeForLong(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return 0L;
        }
        acquireConnection(str, i10, dVar);
        try {
            return this.mConnection.executeForLong(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public String executeForString(String str, Object[] objArr, int i10, d dVar) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (executeSpecial(str, objArr, i10, dVar)) {
            return null;
        }
        acquireConnection(str, i10, dVar);
        try {
            return this.mConnection.executeForString(str, objArr, dVar);
        } finally {
            releaseConnection();
        }
    }

    public boolean hasConnection() {
        return this.mConnection != null;
    }

    public boolean hasNestedTransaction() {
        Transaction transaction = this.mTransactionStack;
        return (transaction == null || transaction.mParent == null) ? false : true;
    }

    public boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public void prepare(String str, int i10, d dVar, SQLiteStatementInfo sQLiteStatementInfo) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (dVar != null) {
            dVar.d();
        }
        acquireConnection(str, i10, dVar);
        try {
            this.mConnection.prepare(str, sQLiteStatementInfo);
        } finally {
            releaseConnection();
        }
    }

    public void setTransactionSuccessful() {
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
    }

    public boolean yieldTransaction(long j10, boolean z10, d dVar) {
        if (z10) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else {
            Transaction transaction = this.mTransactionStack;
            if (transaction == null || transaction.mMarkedSuccessful || transaction.mParent != null) {
                return false;
            }
        }
        if (this.mTransactionStack.mChildFailed) {
            return false;
        }
        return yieldTransactionUnchecked(j10, dVar);
    }
}
