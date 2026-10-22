package net.zetetic.database.sqlcipher;

import B7.a;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;
import android.util.LruCache;
import androidx.compose.foundation.b;
import java.util.ArrayList;
import java.util.WeakHashMap;
import net.zetetic.database.DatabaseUtils;
import stepai.android.llm.base.twoway.FlowType;

/* loaded from: classes4.dex */
public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    public static final String[] m = new String[0];
    public static final byte[] n = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final CloseGuard f5380a;
    public final SQLiteConnectionPool b;
    public final SQLiteDatabaseConfiguration c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final PreparedStatementCache g;
    public PreparedStatement h;
    public final OperationLog i;

    /* renamed from: j, reason: collision with root package name */
    public long f5381j;
    public boolean k;
    public int l;

    public static final class Operation {

        /* renamed from: a, reason: collision with root package name */
        public long f5382a;
        public long b;
        public long c;
        public String d;
        public String e;
        public ArrayList f;
        public boolean g;
        public RuntimeException h;
        public int i;

        public final void a(StringBuilder sb) {
            sb.append(this.d);
            if (this.g) {
                sb.append(" took ");
                sb.append(this.c - this.b);
                sb.append("ms");
            } else {
                sb.append(" started ");
                sb.append(System.currentTimeMillis() - this.f5382a);
                sb.append("ms ago");
            }
            sb.append(" - ");
            sb.append(!this.g ? "running" : this.h != null ? FlowType.FAILED : "succeeded");
            if (this.e != null) {
                sb.append(", sql=\"");
                sb.append(this.e.replaceAll("[\\s]*\\n+[\\s]*", " "));
                sb.append("\"");
            }
            if (this.h != null) {
                sb.append(", exception=\"");
                sb.append(this.h.getMessage());
                sb.append("\"");
            }
        }
    }

    public static final class OperationLog {

        /* renamed from: a, reason: collision with root package name */
        public final Operation[] f5383a = new Operation[20];
        public int b;
        public int c;

        public final int a(String str, String str2, Object[] objArr) {
            int i;
            synchronized (this.f5383a) {
                try {
                    int i6 = (this.b + 1) % 20;
                    Operation[] operationArr = this.f5383a;
                    Operation operation = operationArr[i6];
                    if (operation == null) {
                        operation = new Operation();
                        operationArr[i6] = operation;
                    } else {
                        operation.g = false;
                        operation.h = null;
                        ArrayList arrayList = operation.f;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    operation.f5382a = System.currentTimeMillis();
                    operation.b = SystemClock.uptimeMillis();
                    operation.d = str;
                    operation.e = str2;
                    if (objArr != null) {
                        ArrayList arrayList2 = operation.f;
                        if (arrayList2 == null) {
                            operation.f = new ArrayList();
                        } else {
                            arrayList2.clear();
                        }
                        for (Object obj : objArr) {
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.f.add(obj);
                            } else {
                                operation.f.add(SQLiteConnection.n);
                            }
                        }
                    }
                    int i10 = this.c;
                    this.c = i10 + 1;
                    i = (i10 << 8) | i6;
                    operation.i = i;
                    this.b = i6;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i;
        }

        public final void b(int i) {
            synchronized (this.f5383a) {
                Operation operation = this.f5383a[i & 255];
                if (operation.i != i) {
                    operation = null;
                }
                if (operation != null) {
                    operation.c = SystemClock.uptimeMillis();
                    operation.g = true;
                }
            }
        }

        public final void c(int i) {
            synchronized (this.f5383a) {
                Operation operation = this.f5383a[i & 255];
                if (operation.i != i) {
                    operation = null;
                }
                if (operation != null) {
                    operation.c = SystemClock.uptimeMillis();
                    operation.g = true;
                }
            }
        }

        public final void d(int i, RuntimeException runtimeException) {
            synchronized (this.f5383a) {
                try {
                    Operation operation = this.f5383a[i & 255];
                    if (operation.i != i) {
                        operation = null;
                    }
                    if (operation != null) {
                        operation.h = runtimeException;
                    }
                } finally {
                }
            }
        }
    }

    public static final class PreparedStatement {

        /* renamed from: a, reason: collision with root package name */
        public PreparedStatement f5384a;
        public String b;
        public long c;
        public int d;
        public boolean e;
        public boolean f;
        public boolean g;
    }

    public final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        public PreparedStatementCache(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean z10, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            PreparedStatement preparedStatement3 = preparedStatement;
            preparedStatement3.f = false;
            if (preparedStatement3.g) {
                return;
            }
            SQLiteConnection.this.n(preparedStatement3);
        }
    }

    public SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i, boolean z10) {
        CloseGuard closeGuard = new CloseGuard();
        this.f5380a = closeGuard;
        this.i = new OperationLog();
        this.b = sQLiteConnectionPool;
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.c = sQLiteDatabaseConfiguration2;
        this.d = i;
        this.e = z10;
        this.f = (sQLiteDatabaseConfiguration.c & 1) != 0;
        this.g = new PreparedStatementCache(sQLiteDatabaseConfiguration2.d);
        closeGuard.a();
    }

    public static String d(String str) {
        return str.equals("0") ? "OFF" : str.equals("1") ? "NORMAL" : str.equals("2") ? "FULL" : str;
    }

    private static native void nativeBindBlob(long j5, long j6, int i, byte[] bArr);

    private static native void nativeBindDouble(long j5, long j6, int i, double d);

    private static native void nativeBindLong(long j5, long j6, int i, long j10);

    private static native void nativeBindNull(long j5, long j6, int i);

    private static native void nativeBindString(long j5, long j6, int i, String str);

    private static native void nativeCancel(long j5);

    private static native void nativeClose(long j5);

    private static native void nativeExecute(long j5, long j6);

    private static native int nativeExecuteForBlobFileDescriptor(long j5, long j6);

    private static native int nativeExecuteForChangedRowCount(long j5, long j6);

    private static native long nativeExecuteForCursorWindow(long j5, long j6, CursorWindow cursorWindow, int i, int i6, boolean z10);

    private static native long nativeExecuteForLastInsertedRowId(long j5, long j6);

    private static native long nativeExecuteForLong(long j5, long j6);

    private static native String nativeExecuteForString(long j5, long j6);

    private static native void nativeExecuteRaw(long j5, long j6);

    private static native void nativeFinalizeStatement(long j5, long j6);

    private static native int nativeGetColumnCount(long j5, long j6);

    private static native String nativeGetColumnName(long j5, long j6, int i);

    private static native int nativeGetDbLookaside(long j5);

    private static native int nativeGetParameterCount(long j5, long j6);

    private static native boolean nativeHasCodec();

    private static native boolean nativeIsReadOnly(long j5, long j6);

    private static native int nativeKey(long j5, byte[] bArr);

    private static native long nativeOpen(String str, int i, String str2, boolean z10, boolean z11);

    private static native long nativePrepareStatement(long j5, String str);

    private static native int nativeReKey(long j5, byte[] bArr);

    private static native void nativeRegisterCustomFunction(long j5, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j5, String str);

    private static native void nativeResetCancel(long j5, boolean z10);

    private static native void nativeResetStatementAndClearBindings(long j5, long j6);

    public static boolean o() {
        return nativeHasCodec();
    }

    public final PreparedStatement a(String str) {
        boolean z10;
        PreparedStatementCache preparedStatementCache = this.g;
        PreparedStatement preparedStatement = preparedStatementCache.get(str);
        if (preparedStatement == null) {
            z10 = false;
        } else {
            if (!preparedStatement.g) {
                return preparedStatement;
            }
            z10 = true;
        }
        long jNativePrepareStatement = nativePrepareStatement(this.f5381j, str);
        try {
            int iNativeGetParameterCount = nativeGetParameterCount(this.f5381j, jNativePrepareStatement);
            int iA = DatabaseUtils.a(str);
            boolean zNativeIsReadOnly = nativeIsReadOnly(this.f5381j, jNativePrepareStatement);
            PreparedStatement preparedStatement2 = this.h;
            if (preparedStatement2 != null) {
                this.h = preparedStatement2.f5384a;
                preparedStatement2.f5384a = null;
                preparedStatement2.f = false;
            } else {
                preparedStatement2 = new PreparedStatement();
            }
            preparedStatement2.b = str;
            preparedStatement2.c = jNativePrepareStatement;
            preparedStatement2.d = iNativeGetParameterCount;
            preparedStatement2.e = zNativeIsReadOnly;
            if (!z10 && (iA == 2 || iA == 1)) {
                try {
                    preparedStatementCache.put(str, preparedStatement2);
                    preparedStatement2.f = true;
                } catch (RuntimeException e) {
                    e = e;
                    preparedStatement = preparedStatement2;
                    if (preparedStatement == null || !preparedStatement.f) {
                        nativeFinalizeStatement(this.f5381j, jNativePrepareStatement);
                    }
                    throw e;
                }
            }
            preparedStatement2.g = true;
            return preparedStatement2;
        } catch (RuntimeException e6) {
            e = e6;
        }
    }

    public final void b(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            int i = this.l + 1;
            this.l = i;
            if (i == 1) {
                nativeResetCancel(this.f5381j, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
    }

    public final void c(PreparedStatement preparedStatement, Object[] objArr) {
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.d) {
            throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.d + " bind arguments but " + length + " were provided.");
        }
        if (length == 0) {
            return;
        }
        long j5 = preparedStatement.c;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            char c = obj == null ? (char) 0 : obj instanceof byte[] ? (char) 4 : ((obj instanceof Float) || (obj instanceof Double)) ? (char) 2 : ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) ? (char) 1 : (char) 3;
            if (c == 0) {
                nativeBindNull(this.f5381j, j5, i + 1);
            } else if (c == 1) {
                nativeBindLong(this.f5381j, j5, i + 1, ((Number) obj).longValue());
            } else if (c == 2) {
                nativeBindDouble(this.f5381j, j5, i + 1, ((Number) obj).doubleValue());
            } else if (c == 4) {
                nativeBindBlob(this.f5381j, j5, i + 1, (byte[]) obj);
            } else if (obj instanceof Boolean) {
                nativeBindLong(this.f5381j, j5, i + 1, ((Boolean) obj).booleanValue() ? 1L : 0L);
            } else {
                nativeBindString(this.f5381j, j5, i + 1, obj.toString());
            }
        }
    }

    public final void e(byte[] bArr) {
        int iNativeReKey = nativeReKey(this.f5381j, bArr);
        Log.i("SQLiteConnection", "Database rekey operation returned:" + iNativeReKey);
        if (iNativeReKey != 0) {
            throw new SQLiteException(a.h(iNativeReKey, "Failed to rekey database, result code:"));
        }
    }

    public final void f(CancellationSignal cancellationSignal) {
        if (cancellationSignal != null) {
            int i = this.l - 1;
            this.l = i;
            if (i == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.f5381j, false);
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            SQLiteConnectionPool sQLiteConnectionPool = this.b;
            if (sQLiteConnectionPool != null && this.f5381j != 0) {
                Log.w("SQLiteConnectionPool", "A SQLiteConnection object for database '" + sQLiteConnectionPool.d.b + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
                sQLiteConnectionPool.c.set(true);
            }
            g(true);
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final void g(boolean z10) {
        Throwable th;
        CloseGuard closeGuard = this.f5380a;
        if (z10 && (th = closeGuard.f5378a) != null) {
            Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th);
        }
        closeGuard.f5378a = null;
        if (this.f5381j != 0) {
            OperationLog operationLog = this.i;
            int iA = operationLog.a("close", null, null);
            try {
                this.g.evictAll();
                nativeClose(this.f5381j);
                this.f5381j = 0L;
            } finally {
                operationLog.b(iA);
            }
        }
    }

    public final void h(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.i;
        int iA = operationLog.a("execute", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    x(preparedStatementA);
                    c(preparedStatementA, objArr);
                    b(cancellationSignal);
                    try {
                        nativeExecute(this.f5381j, preparedStatementA.c);
                    } finally {
                        f(cancellationSignal);
                    }
                } finally {
                    s(preparedStatementA);
                }
            } finally {
                operationLog.b(iA);
            }
        } catch (RuntimeException e) {
            operationLog.d(iA, e);
            throw e;
        }
    }

    public final int i(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.i;
        int iA = operationLog.a("executeForChangedRowCount", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    x(preparedStatementA);
                    c(preparedStatementA, objArr);
                    return nativeExecuteForChangedRowCount(this.f5381j, preparedStatementA.c);
                } finally {
                    s(preparedStatementA);
                }
            } catch (RuntimeException e) {
                operationLog.d(iA, e);
                throw e;
            }
        } finally {
            operationLog.c(iA);
        }
    }

    public final int j(String str, Object[] objArr, CursorWindow cursorWindow, int i, int i6, boolean z10, CancellationSignal cancellationSignal) {
        OperationLog operationLog = this.i;
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        if (cursorWindow == null) {
            throw new IllegalArgumentException("window must not be null.");
        }
        cursorWindow.acquireReference();
        try {
            int iA = operationLog.a("executeForCursorWindow", str, objArr);
            try {
                try {
                    PreparedStatement preparedStatementA = a(str);
                    try {
                        x(preparedStatementA);
                        c(preparedStatementA, objArr);
                        b(cancellationSignal);
                        try {
                            long jNativeExecuteForCursorWindow = nativeExecuteForCursorWindow(this.f5381j, preparedStatementA.c, cursorWindow, i, i6, z10);
                            int i10 = (int) (jNativeExecuteForCursorWindow >> 32);
                            int i11 = (int) jNativeExecuteForCursorWindow;
                            cursorWindow.getNumRows();
                            cursorWindow.setStartPosition(i10);
                            operationLog.c(iA);
                            cursorWindow.releaseReference();
                            return i11;
                        } finally {
                            f(cancellationSignal);
                        }
                    } finally {
                        s(preparedStatementA);
                    }
                } catch (RuntimeException e) {
                    operationLog.d(iA, e);
                    throw e;
                }
            } catch (Throwable th) {
                operationLog.c(iA);
                throw th;
            }
        } catch (Throwable th2) {
            cursorWindow.releaseReference();
            throw th2;
        }
    }

    public final long k(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.i;
        int iA = operationLog.a("executeForLastInsertedRowId", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    x(preparedStatementA);
                    c(preparedStatementA, objArr);
                    return nativeExecuteForLastInsertedRowId(this.f5381j, preparedStatementA.c);
                } finally {
                    s(preparedStatementA);
                }
            } catch (RuntimeException e) {
                operationLog.d(iA, e);
                throw e;
            }
        } finally {
            operationLog.b(iA);
        }
    }

    public final long l(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.i;
        int iA = operationLog.a("executeForLong", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    x(preparedStatementA);
                    c(preparedStatementA, objArr);
                    return nativeExecuteForLong(this.f5381j, preparedStatementA.c);
                } finally {
                    s(preparedStatementA);
                }
            } catch (RuntimeException e) {
                operationLog.d(iA, e);
                throw e;
            }
        } finally {
            operationLog.b(iA);
        }
    }

    public final String m(String str, Object[] objArr) {
        if (str == null) {
            throw new IllegalArgumentException("sql must not be null.");
        }
        OperationLog operationLog = this.i;
        int iA = operationLog.a("executeForString", str, objArr);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    x(preparedStatementA);
                    c(preparedStatementA, objArr);
                    return nativeExecuteForString(this.f5381j, preparedStatementA.c);
                } finally {
                    s(preparedStatementA);
                }
            } catch (RuntimeException e) {
                operationLog.d(iA, e);
                throw e;
            }
        } finally {
            operationLog.b(iA);
        }
    }

    public final void n(PreparedStatement preparedStatement) {
        nativeFinalizeStatement(this.f5381j, preparedStatement.c);
        preparedStatement.b = null;
        preparedStatement.f5384a = this.h;
        this.h = preparedStatement;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        nativeCancel(this.f5381j);
    }

    public final void p() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.c;
        this.f5381j = nativeOpen(sQLiteDatabaseConfiguration.f5400a, sQLiteDatabaseConfiguration.c, sQLiteDatabaseConfiguration.b, SQLiteDebug.f5401a, SQLiteDebug.b);
        SQLiteDatabaseHook sQLiteDatabaseHook = this.c.h;
        if (sQLiteDatabaseHook != null) {
            sQLiteDatabaseHook.a();
        }
        byte[] bArr = this.c.g;
        if (bArr != null && bArr.length > 0) {
            Log.i("SQLiteConnection", "Database keying operation returned:" + nativeKey(this.f5381j, bArr));
        }
        SQLiteDatabaseHook sQLiteDatabaseHook2 = this.c.h;
        if (sQLiteDatabaseHook2 != null) {
            sQLiteDatabaseHook2.b();
        }
        byte[] bArr2 = this.c.g;
        if (bArr2 != null && bArr2.length > 0) {
            l("SELECT COUNT(*) FROM sqlite_schema;", null);
        }
        if (!this.c.f5400a.equalsIgnoreCase(":memory:") && !this.f) {
            WeakHashMap weakHashMap = SQLiteDatabase.f5394j;
            if (!nativeHasCodec()) {
                synchronized (SQLiteGlobal.f5403a) {
                    try {
                        if (SQLiteGlobal.b == 0) {
                            SQLiteGlobal.b = new StatFs("/data").getBlockSize();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (l("PRAGMA page_size", null) != 4096) {
                    h("PRAGMA page_size=4096", null, null);
                }
            }
        }
        t();
        if (!this.c.f5400a.equalsIgnoreCase(":memory:") && !this.f) {
            if (l("PRAGMA journal_size_limit", null) != 10000) {
                l("PRAGMA journal_size_limit=10000", null);
            }
        }
        if (!this.c.f5400a.equalsIgnoreCase(":memory:") && !this.f) {
            long jMax = Math.max(1, 1000);
            if (l("PRAGMA wal_autocheckpoint", null) != jMax) {
                l("PRAGMA wal_autocheckpoint=" + jMax, null);
            }
        }
        w();
        if (!nativeHasCodec()) {
            v();
        }
        int size = this.c.i.size();
        for (int i = 0; i < size; i++) {
            nativeRegisterCustomFunction(this.f5381j, (SQLiteCustomFunction) this.c.i.get(i));
        }
    }

    public final void q(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        OperationLog operationLog = this.i;
        int iA = operationLog.a("prepare", str, null);
        try {
            try {
                PreparedStatement preparedStatementA = a(str);
                try {
                    sQLiteStatementInfo.f5408a = preparedStatementA.d;
                    sQLiteStatementInfo.c = preparedStatementA.e;
                    int iNativeGetColumnCount = nativeGetColumnCount(this.f5381j, preparedStatementA.c);
                    if (iNativeGetColumnCount == 0) {
                        sQLiteStatementInfo.b = m;
                    } else {
                        sQLiteStatementInfo.b = new String[iNativeGetColumnCount];
                        for (int i = 0; i < iNativeGetColumnCount; i++) {
                            sQLiteStatementInfo.b[i] = nativeGetColumnName(this.f5381j, preparedStatementA.c, i);
                        }
                    }
                    s(preparedStatementA);
                } catch (Throwable th) {
                    s(preparedStatementA);
                    throw th;
                }
            } catch (RuntimeException e) {
                operationLog.d(iA, e);
                throw e;
            }
        } finally {
            operationLog.b(iA);
        }
    }

    public final void r(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2;
        this.k = false;
        int size = sQLiteDatabaseConfiguration.i.size();
        int i = 0;
        while (true) {
            sQLiteDatabaseConfiguration2 = this.c;
            if (i >= size) {
                break;
            }
            SQLiteCustomFunction sQLiteCustomFunction = (SQLiteCustomFunction) sQLiteDatabaseConfiguration.i.get(i);
            if (!sQLiteDatabaseConfiguration2.i.contains(sQLiteCustomFunction)) {
                nativeRegisterCustomFunction(this.f5381j, sQLiteCustomFunction);
            }
            i++;
        }
        boolean z10 = sQLiteDatabaseConfiguration.f != sQLiteDatabaseConfiguration2.f;
        boolean z11 = ((sQLiteDatabaseConfiguration.c ^ sQLiteDatabaseConfiguration2.c) & 536870912) != 0;
        boolean zEquals = sQLiteDatabaseConfiguration.e.equals(sQLiteDatabaseConfiguration2.e);
        sQLiteDatabaseConfiguration2.a(sQLiteDatabaseConfiguration);
        if (z10) {
            t();
        }
        if (z11) {
            w();
        }
        if (zEquals) {
            return;
        }
        v();
    }

    public final void s(PreparedStatement preparedStatement) {
        preparedStatement.g = false;
        if (!preparedStatement.f) {
            n(preparedStatement);
            return;
        }
        try {
            nativeResetStatementAndClearBindings(this.f5381j, preparedStatement.c);
        } catch (SQLiteException unused) {
            this.g.remove(preparedStatement.b);
        }
    }

    public final void t() {
        if (this.f) {
            return;
        }
        long j5 = this.c.f ? 1L : 0L;
        if (l("PRAGMA foreign_keys", null) != j5) {
            h(b.p(j5, "PRAGMA foreign_keys="), null, null);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SQLiteConnection: ");
        sb.append(this.c.f5400a);
        sb.append(" (");
        return androidx.appfunctions.metadata.a.o(sb, ")", this.d);
    }

    public final void u(String str) {
        String strM = m("PRAGMA journal_mode", null);
        if (strM.equalsIgnoreCase(str)) {
            return;
        }
        try {
            if (m("PRAGMA journal_mode=".concat(str), null).equalsIgnoreCase(str)) {
                return;
            }
        } catch (SQLiteDatabaseLockedException unused) {
        }
        StringBuilder sb = new StringBuilder("Could not change the database journal mode of '");
        androidx.constraintlayout.core.dsl.a.A(sb, this.c.b, "' from '", strM, "' to '");
        sb.append(str);
        sb.append("' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        Log.w("SQLiteConnection", sb.toString());
    }

    public final void v() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.c;
        if ((sQLiteDatabaseConfiguration.c & 16) != 0) {
            return;
        }
        String string = sQLiteDatabaseConfiguration.e.toString();
        nativeRegisterLocalizedCollators(this.f5381j, string);
        if (this.f) {
            return;
        }
        try {
            h("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String strM = m("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null);
            if (strM == null || !strM.equals(string)) {
                h("BEGIN", null, null);
                try {
                    h("DELETE FROM android_metadata", null, null);
                    h("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{string}, null);
                    h("REINDEX LOCALIZED", null, null);
                    h("COMMIT", null, null);
                } catch (Throwable th) {
                    h("ROLLBACK", null, null);
                    throw th;
                }
            }
        } catch (RuntimeException e) {
            throw new SQLiteException(androidx.appfunctions.metadata.a.p(new StringBuilder("Failed to change locale for db '"), sQLiteDatabaseConfiguration.b, "' to '", string, "'."), e);
        }
    }

    public final void w() {
        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.c;
        if (sQLiteDatabaseConfiguration.f5400a.equalsIgnoreCase(":memory:") || this.f) {
            return;
        }
        if ((sQLiteDatabaseConfiguration.c & 536870912) != 0) {
            u("WAL");
            if (d(m("PRAGMA synchronous", null)).equalsIgnoreCase(d("normal"))) {
                return;
            }
            h("PRAGMA synchronous=".concat("normal"), null, null);
            return;
        }
        u("delete");
        if (d(m("PRAGMA synchronous", null)).equalsIgnoreCase(d("normal"))) {
            return;
        }
        h("PRAGMA synchronous=".concat("normal"), null, null);
    }

    public final void x(PreparedStatement preparedStatement) {
        if (this.k && !preparedStatement.e) {
            throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        }
    }
}
