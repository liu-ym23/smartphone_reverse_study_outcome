package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.compose.foundation.b;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import net.zetetic.database.sqlcipher.SQLiteConnection;

/* loaded from: classes4.dex */
public final class SQLiteConnectionPool implements Closeable {
    public final SQLiteDatabaseConfiguration d;
    public int e;
    public boolean f;
    public int g;
    public ConnectionWaiter h;
    public ConnectionWaiter i;
    public SQLiteConnection k;

    /* renamed from: a, reason: collision with root package name */
    public final CloseGuard f5386a = new CloseGuard();
    public final Object b = new Object();
    public final AtomicBoolean c = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f5387j = new ArrayList();
    public final WeakHashMap l = new WeakHashMap();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class AcquiredConnectionStatus {

        /* renamed from: a, reason: collision with root package name */
        public static final AcquiredConnectionStatus f5389a;
        public static final AcquiredConnectionStatus b;
        public static final AcquiredConnectionStatus c;
        public static final /* synthetic */ AcquiredConnectionStatus[] d;

        static {
            AcquiredConnectionStatus acquiredConnectionStatus = new AcquiredConnectionStatus("NORMAL", 0);
            f5389a = acquiredConnectionStatus;
            AcquiredConnectionStatus acquiredConnectionStatus2 = new AcquiredConnectionStatus("RECONFIGURE", 1);
            b = acquiredConnectionStatus2;
            AcquiredConnectionStatus acquiredConnectionStatus3 = new AcquiredConnectionStatus("DISCARD", 2);
            c = acquiredConnectionStatus3;
            d = new AcquiredConnectionStatus[]{acquiredConnectionStatus, acquiredConnectionStatus2, acquiredConnectionStatus3};
        }

        public static AcquiredConnectionStatus valueOf(String str) {
            return (AcquiredConnectionStatus) Enum.valueOf(AcquiredConnectionStatus.class, str);
        }

        public static AcquiredConnectionStatus[] values() {
            return (AcquiredConnectionStatus[]) d.clone();
        }
    }

    public static final class ConnectionWaiter {

        /* renamed from: a, reason: collision with root package name */
        public ConnectionWaiter f5390a;
        public Thread b;
        public long c;
        public int d;
        public boolean e;
        public String f;
        public int g;
        public SQLiteConnection h;
        public RuntimeException i;

        /* renamed from: j, reason: collision with root package name */
        public int f5391j;
    }

    public SQLiteConnectionPool(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        this.d = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        E();
    }

    public static void c(SQLiteConnection sQLiteConnection) {
        try {
            sQLiteConnection.g(false);
        } catch (RuntimeException e) {
            Log.e("SQLiteConnectionPool", "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection, e);
        }
    }

    public final void E() {
        if ((this.d.c & 536870912) != 0) {
            this.e = Math.max(2, 10);
        } else {
            this.e = 1;
        }
    }

    public final void F() {
        if (!this.f) {
            throw new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
        }
    }

    public final SQLiteConnection G(int i, String str) {
        ArrayList arrayList = this.f5387j;
        int size = arrayList.size();
        if (size > 1 && str != null) {
            for (int i6 = 0; i6 < size; i6++) {
                SQLiteConnection sQLiteConnection = (SQLiteConnection) arrayList.get(i6);
                if (sQLiteConnection.g.get(str) != null) {
                    arrayList.remove(i6);
                    g(sQLiteConnection, i);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            SQLiteConnection sQLiteConnection2 = (SQLiteConnection) arrayList.remove(size - 1);
            g(sQLiteConnection2, i);
            return sQLiteConnection2;
        }
        int size2 = this.l.size();
        if (this.k != null) {
            size2++;
        }
        if (size2 >= this.e) {
            return null;
        }
        SQLiteConnection sQLiteConnectionL = l(this.d, false);
        g(sQLiteConnectionL, i);
        return sQLiteConnectionL;
    }

    public final SQLiteConnection H(int i) {
        SQLiteConnection sQLiteConnection = this.k;
        if (sQLiteConnection != null) {
            this.k = null;
            g(sQLiteConnection, i);
            return sQLiteConnection;
        }
        Iterator it = this.l.keySet().iterator();
        while (it.hasNext()) {
            if (((SQLiteConnection) it.next()).e) {
                return null;
            }
        }
        SQLiteConnection sQLiteConnectionL = l(this.d, true);
        g(sQLiteConnectionL, i);
        return sQLiteConnectionL;
    }

    public final void I() {
        SQLiteConnection sQLiteConnectionH;
        ConnectionWaiter connectionWaiter = this.i;
        ConnectionWaiter connectionWaiter2 = null;
        boolean z10 = false;
        boolean z11 = false;
        while (connectionWaiter != null) {
            boolean z12 = true;
            if (this.f) {
                try {
                    if (connectionWaiter.e || z10) {
                        sQLiteConnectionH = null;
                    } else {
                        sQLiteConnectionH = G(connectionWaiter.g, connectionWaiter.f);
                        if (sQLiteConnectionH == null) {
                            z10 = true;
                        }
                    }
                    if (sQLiteConnectionH == null && !z11 && (sQLiteConnectionH = H(connectionWaiter.g)) == null) {
                        z11 = true;
                    }
                    if (sQLiteConnectionH != null) {
                        connectionWaiter.h = sQLiteConnectionH;
                    } else if (z10 && z11) {
                        return;
                    } else {
                        z12 = false;
                    }
                } catch (RuntimeException e) {
                    connectionWaiter.i = e;
                }
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.f5390a;
            if (z12) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.f5390a = connectionWaiter3;
                } else {
                    this.i = connectionWaiter3;
                }
                connectionWaiter.f5390a = null;
                LockSupport.unpark(connectionWaiter.b);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            connectionWaiter = connectionWaiter3;
        }
    }

    public final void b() {
        ArrayList arrayList = this.f5387j;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c((SQLiteConnection) arrayList.get(i));
        }
        arrayList.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        f(false);
    }

    public final void f(boolean z10) {
        Throwable th;
        CloseGuard closeGuard = this.f5386a;
        if (z10 && (th = closeGuard.f5378a) != null) {
            Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th);
        }
        this.f5386a.f5378a = null;
        if (z10) {
            return;
        }
        synchronized (this.b) {
            try {
                F();
                this.f = false;
                b();
                SQLiteConnection sQLiteConnection = this.k;
                if (sQLiteConnection != null) {
                    c(sQLiteConnection);
                    this.k = null;
                }
                int size = this.l.size();
                if (size != 0) {
                    Log.i("SQLiteConnectionPool", "The connection pool for " + this.d.b + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                }
                I();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            f(true);
        } finally {
            super.finalize();
        }
    }

    public final void g(SQLiteConnection sQLiteConnection, int i) {
        try {
            sQLiteConnection.k = (i & 1) != 0;
            this.l.put(sQLiteConnection, AcquiredConnectionStatus.f5389a);
        } catch (RuntimeException e) {
            Log.e("SQLiteConnectionPool", "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i);
            c(sQLiteConnection);
            throw e;
        }
    }

    public final void i(int i, long j5) {
        int i6;
        String string;
        Thread threadCurrentThread = Thread.currentThread();
        StringBuilder sb = new StringBuilder("The connection pool for database '");
        sb.append(this.d.b);
        sb.append("' has been unable to grant a connection to thread ");
        sb.append(threadCurrentThread.getId());
        sb.append(" (");
        sb.append(threadCurrentThread.getName());
        sb.append(") with flags 0x");
        sb.append(Integer.toHexString(i));
        sb.append(" for ");
        sb.append(j5 * 0.001f);
        sb.append(" seconds.\n");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        if (this.l.isEmpty()) {
            i6 = 0;
        } else {
            Iterator it = this.l.keySet().iterator();
            i6 = 0;
            while (it.hasNext()) {
                SQLiteConnection.OperationLog operationLog = ((SQLiteConnection) it.next()).i;
                synchronized (operationLog.f5383a) {
                    try {
                        SQLiteConnection.Operation operation = operationLog.f5383a[operationLog.b];
                        if (operation == null || operation.g) {
                            string = null;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            operation.a(sb2);
                            string = sb2.toString();
                        }
                    } finally {
                    }
                }
                if (string != null) {
                    arrayList.add(string);
                    i10++;
                } else {
                    i6++;
                }
            }
        }
        int size = this.f5387j.size();
        if (this.k != null) {
            size++;
        }
        sb.append("Connections: ");
        sb.append(i10);
        sb.append(" active, ");
        sb.append(i6);
        sb.append(" idle, ");
        sb.append(size);
        sb.append(" available.\n");
        if (!arrayList.isEmpty()) {
            sb.append("\nRequests in progress:\n");
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                b.C(sb, "  ", (String) it2.next(), "\n");
            }
        }
        Log.w("SQLiteConnectionPool", sb.toString());
    }

    public final void k(AcquiredConnectionStatus acquiredConnectionStatus) {
        WeakHashMap weakHashMap = this.l;
        if (weakHashMap.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(weakHashMap.size());
        for (Map.Entry entry : weakHashMap.entrySet()) {
            AcquiredConnectionStatus acquiredConnectionStatus2 = (AcquiredConnectionStatus) entry.getValue();
            if (acquiredConnectionStatus != acquiredConnectionStatus2 && acquiredConnectionStatus2 != AcquiredConnectionStatus.c) {
                arrayList.add((SQLiteConnection) entry.getKey());
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            weakHashMap.put((SQLiteConnection) arrayList.get(i), acquiredConnectionStatus);
        }
    }

    public final SQLiteConnection l(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z10) {
        int i = this.g;
        this.g = i + 1;
        SQLiteConnection sQLiteConnection = new SQLiteConnection(this, sQLiteDatabaseConfiguration, i, z10);
        try {
            sQLiteConnection.p();
            return sQLiteConnection;
        } catch (SQLiteException e) {
            sQLiteConnection.g(false);
            throw e;
        }
    }

    public final void n(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        if (sQLiteDatabaseConfiguration == null) {
            throw new IllegalArgumentException("configuration must not be null.");
        }
        synchronized (this.b) {
            try {
                F();
                boolean z10 = ((sQLiteDatabaseConfiguration.c ^ this.d.c) & 536870912) != 0;
                if (z10) {
                    if (!this.l.isEmpty()) {
                        throw new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                    }
                    b();
                }
                if (sQLiteDatabaseConfiguration.f != this.d.f && !this.l.isEmpty()) {
                    throw new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                }
                if (!Arrays.equals(sQLiteDatabaseConfiguration.g, this.d.g)) {
                    this.k.e(sQLiteDatabaseConfiguration.g);
                    this.d.a(sQLiteDatabaseConfiguration);
                    b();
                    r();
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.d;
                if (sQLiteDatabaseConfiguration2.c != sQLiteDatabaseConfiguration.c) {
                    if (z10) {
                        b();
                        SQLiteConnection sQLiteConnection = this.k;
                        if (sQLiteConnection != null) {
                            c(sQLiteConnection);
                            this.k = null;
                        }
                    }
                    SQLiteConnection sQLiteConnectionL = l(sQLiteDatabaseConfiguration, true);
                    b();
                    SQLiteConnection sQLiteConnection2 = this.k;
                    if (sQLiteConnection2 != null) {
                        c(sQLiteConnection2);
                        this.k = null;
                    }
                    k(AcquiredConnectionStatus.c);
                    this.k = sQLiteConnectionL;
                    this.d.a(sQLiteDatabaseConfiguration);
                    E();
                } else {
                    sQLiteDatabaseConfiguration2.a(sQLiteDatabaseConfiguration);
                    E();
                    ArrayList arrayList = this.f5387j;
                    int size = arrayList.size();
                    while (true) {
                        int i = size - 1;
                        if (size <= this.e - 1) {
                            break;
                        }
                        c((SQLiteConnection) arrayList.remove(i));
                        size = i;
                    }
                    r();
                }
                I();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r() {
        SQLiteConnection sQLiteConnection = this.k;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.d;
        if (sQLiteConnection != null) {
            try {
                sQLiteConnection.r(sQLiteDatabaseConfiguration);
            } catch (RuntimeException e) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure available primary connection, closing it: " + this.k, e);
                c(this.k);
                this.k = null;
            }
        }
        ArrayList arrayList = this.f5387j;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            SQLiteConnection sQLiteConnection2 = (SQLiteConnection) arrayList.get(i);
            try {
                sQLiteConnection2.r(sQLiteDatabaseConfiguration);
            } catch (RuntimeException e6) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure available non-primary connection, closing it: " + sQLiteConnection2, e6);
                c(sQLiteConnection2);
                arrayList.remove(i);
                size--;
                i--;
            }
            i++;
        }
        k(AcquiredConnectionStatus.b);
    }

    public final boolean s(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        AcquiredConnectionStatus acquiredConnectionStatus2 = AcquiredConnectionStatus.b;
        AcquiredConnectionStatus acquiredConnectionStatus3 = AcquiredConnectionStatus.c;
        if (acquiredConnectionStatus == acquiredConnectionStatus2) {
            try {
                sQLiteConnection.r(this.d);
            } catch (RuntimeException e) {
                Log.e("SQLiteConnectionPool", "Failed to reconfigure released connection, closing it: " + sQLiteConnection, e);
                acquiredConnectionStatus = acquiredConnectionStatus3;
            }
        }
        if (acquiredConnectionStatus != acquiredConnectionStatus3) {
            return true;
        }
        c(sQLiteConnection);
        return false;
    }

    public final String toString() {
        return "SQLiteConnectionPool: " + this.d.f5400a;
    }

    public final void w(SQLiteConnection sQLiteConnection) {
        synchronized (this.b) {
            try {
                AcquiredConnectionStatus acquiredConnectionStatus = (AcquiredConnectionStatus) this.l.remove(sQLiteConnection);
                if (acquiredConnectionStatus == null) {
                    throw new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                }
                if (!this.f) {
                    c(sQLiteConnection);
                } else if (sQLiteConnection.e) {
                    if (s(sQLiteConnection, acquiredConnectionStatus)) {
                        this.k = sQLiteConnection;
                    }
                    I();
                } else if (this.f5387j.size() >= this.e - 1) {
                    c(sQLiteConnection);
                } else {
                    if (s(sQLiteConnection, acquiredConnectionStatus)) {
                        this.f5387j.add(sQLiteConnection);
                    }
                    I();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
