package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import net.zetetic.database.sqlcipher.SQLiteConnectionPool;

/* loaded from: classes4.dex */
public final class SQLiteSession {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteConnectionPool f5406a;
    public SQLiteConnection b;
    public int c;
    public int d;
    public Transaction e;
    public Transaction f;

    public static final class Transaction {

        /* renamed from: a, reason: collision with root package name */
        public Transaction f5407a;
        public int b;
        public SQLiteTransactionListener c;
        public boolean d;
        public boolean e;
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        if (sQLiteConnectionPool == null) {
            throw new IllegalArgumentException("connectionPool must not be null");
        }
        this.f5406a = sQLiteConnectionPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f5  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r21, int r22, android.os.CancellationSignal r23) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.zetetic.database.sqlcipher.SQLiteSession.a(java.lang.String, int, android.os.CancellationSignal):void");
    }

    public final void b(int i, SQLiteTransactionListener sQLiteTransactionListener, int i6, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.f == null) {
            a(null, i6, cancellationSignal);
        }
        try {
            if (this.f == null) {
                if (i == 1) {
                    this.b.h("BEGIN IMMEDIATE;", null, cancellationSignal);
                } else if (i != 2) {
                    this.b.h("BEGIN;", null, cancellationSignal);
                } else {
                    this.b.h("BEGIN EXCLUSIVE;", null, cancellationSignal);
                }
            }
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.onBegin();
                } catch (RuntimeException e) {
                    if (this.f == null) {
                        this.b.h("ROLLBACK;", null, cancellationSignal);
                    }
                    throw e;
                }
            }
            Transaction transaction = this.e;
            if (transaction != null) {
                this.e = transaction.f5407a;
                transaction.f5407a = null;
                transaction.d = false;
                transaction.e = false;
            } else {
                transaction = new Transaction();
            }
            transaction.b = i;
            transaction.c = sQLiteTransactionListener;
            transaction.f5407a = this.f;
            this.f = transaction;
        } catch (Throwable th) {
            if (this.f == null) {
                k();
            }
            throw th;
        }
    }

    public final void c(CancellationSignal cancellationSignal, boolean z10) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.f;
        boolean z11 = false;
        boolean z12 = (transaction.d || z10) && !transaction.e;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.c;
        if (sQLiteTransactionListener != null) {
            try {
                if (z12) {
                    sQLiteTransactionListener.onCommit();
                } else {
                    sQLiteTransactionListener.onRollback();
                }
                z11 = z12;
                e = null;
            } catch (RuntimeException e) {
                e = e;
            }
        } else {
            z11 = z12;
            e = null;
        }
        Transaction transaction2 = transaction.f5407a;
        this.f = transaction2;
        transaction.f5407a = this.e;
        transaction.c = null;
        this.e = transaction;
        if (transaction2 == null) {
            try {
                if (z11) {
                    this.b.h("COMMIT;", null, cancellationSignal);
                } else {
                    this.b.h("ROLLBACK;", null, cancellationSignal);
                }
                k();
            } catch (Throwable th) {
                k();
                throw th;
            }
        } else if (!z11) {
            transaction2.e = true;
        }
        if (e != null) {
            throw e;
        }
    }

    public final void d(String str, Object[] objArr, int i) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i, null)) {
            return;
        }
        a(str, i, null);
        try {
            this.b.h(str, objArr, null);
        } finally {
            k();
        }
    }

    public final int e(String str, Object[] objArr, int i) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i, null)) {
            return 0;
        }
        a(str, i, null);
        try {
            return this.b.i(str, objArr);
        } finally {
            k();
        }
    }

    public final int f(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i6, boolean z10, int i10, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        if (j(str, i10, cancellationSignal)) {
            cursorWindow.clear();
            return 0;
        }
        a(str, i10, cancellationSignal);
        try {
            return this.b.j(str, objArr, cursorWindow, i, i6, z10, cancellationSignal);
        } finally {
            k();
        }
    }

    public final long g(String str, Object[] objArr, int i) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i, null)) {
            return 0L;
        }
        a(str, i, null);
        try {
            return this.b.k(str, objArr);
        } finally {
            k();
        }
    }

    public final long h(String str, Object[] objArr, int i) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i, null)) {
            return 0L;
        }
        a(str, i, null);
        try {
            return this.b.l(str, objArr);
        } finally {
            k();
        }
    }

    public final String i(String str, Object[] objArr, int i) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (j(str, i, null)) {
            return null;
        }
        a(str, i, null);
        try {
            return this.b.m(str, objArr);
        } finally {
            k();
        }
    }

    public final boolean j(String str, int i, CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
        if (sqlStatementType == 4) {
            l();
            b(2, null, i, cancellationSignal);
            return true;
        }
        if (sqlStatementType != 5) {
            if (sqlStatementType != 6) {
                return false;
            }
            if (this.f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            c(cancellationSignal, false);
            return true;
        }
        if (this.f == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        l();
        Transaction transaction = this.f;
        transaction.d = true;
        if (transaction == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        c(cancellationSignal, false);
        return true;
    }

    public final void k() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            try {
                this.f5406a.w(this.b);
            } finally {
                this.b = null;
            }
        }
    }

    public final void l() {
        Transaction transaction = this.f;
        if (transaction != null && transaction.d) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    public final boolean m(long j5) throws InterruptedException {
        boolean z10;
        if (this.f == null) {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
        l();
        Transaction transaction = this.f;
        if (transaction != null && transaction.f5407a != null) {
            throw new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
        }
        if (!transaction.e) {
            SQLiteConnectionPool sQLiteConnectionPool = this.f5406a;
            SQLiteConnection sQLiteConnection = this.b;
            int i = this.c;
            synchronized (sQLiteConnectionPool.b) {
                try {
                    if (!sQLiteConnectionPool.l.containsKey(sQLiteConnection)) {
                        throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    }
                    if (sQLiteConnectionPool.f) {
                        boolean z11 = sQLiteConnection.e;
                        SQLiteConnectionPool.ConnectionWaiter connectionWaiter = sQLiteConnectionPool.i;
                        if (connectionWaiter == null) {
                            z10 = false;
                        } else {
                            int i6 = (i & 4) != 0 ? 1 : 0;
                            while (i6 <= connectionWaiter.d) {
                                if (!z11 && connectionWaiter.e) {
                                    connectionWaiter = connectionWaiter.f5390a;
                                    if (connectionWaiter == null) {
                                        break;
                                    }
                                }
                                z10 = true;
                            }
                            z10 = false;
                        }
                    } else {
                        z10 = false;
                    }
                } finally {
                }
            }
            if (z10) {
                Transaction transaction2 = this.f;
                int i10 = transaction2.b;
                SQLiteTransactionListener sQLiteTransactionListener = transaction2.c;
                int i11 = this.c;
                c(null, true);
                if (j5 > 0) {
                    try {
                        Thread.sleep(j5);
                    } catch (InterruptedException unused) {
                    }
                }
                b(i10, sQLiteTransactionListener, i11, null);
                return true;
            }
        }
        return false;
    }
}
