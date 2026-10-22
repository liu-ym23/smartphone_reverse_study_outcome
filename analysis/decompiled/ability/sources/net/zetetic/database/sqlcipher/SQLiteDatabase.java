package net.zetetic.database.sqlcipher;

import B7.a;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.os.Looper;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import androidx.compose.material3.MenuKt;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import net.zetetic.database.DatabaseErrorHandler;
import net.zetetic.database.DatabaseUtils;
import net.zetetic.database.DefaultDatabaseErrorHandler;

/* loaded from: classes4.dex */
public final class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {

    /* renamed from: j, reason: collision with root package name */
    public static final WeakHashMap f5394j = new WeakHashMap();
    public static final String[] k = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public final CursorFactory c;
    public final DatabaseErrorHandler d;
    public final SQLiteDatabaseConfiguration g;
    public SQLiteConnectionPool h;
    public boolean i;
    public final ThreadLocal b = new ThreadLocal<SQLiteSession>() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.1
        @Override // java.lang.ThreadLocal
        public final SQLiteSession initialValue() {
            SQLiteConnectionPool sQLiteConnectionPool;
            SQLiteDatabase sQLiteDatabase = SQLiteDatabase.this;
            synchronized (sQLiteDatabase.e) {
                sQLiteDatabase.I();
                sQLiteConnectionPool = sQLiteDatabase.h;
            }
            return new SQLiteSession(sQLiteConnectionPool);
        }
    };
    public final Object e = new Object();
    public final CloseGuard f = new CloseGuard();

    public interface CursorFactory {
        Cursor a();
    }

    public interface CustomFunction {
        void a();
    }

    public SQLiteDatabase(int i, String str, DatabaseErrorHandler databaseErrorHandler, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, byte[] bArr) {
        this.c = cursorFactory;
        this.d = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler() : databaseErrorHandler;
        this.g = new SQLiteDatabaseConfiguration(str, i, bArr, sQLiteDatabaseHook);
    }

    public static boolean k(File file) {
        boolean zDelete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] fileArrListFiles = parentFile.listFiles(new FileFilter() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.4
                @Override // java.io.FileFilter
                public final boolean accept(File file2) {
                    return file2.getName().startsWith(str);
                }
            });
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    zDelete |= file2.delete();
                }
            }
        }
        return zDelete;
    }

    public static int r(boolean z10) {
        int i = z10 ? 1 : 2;
        Looper looperMyLooper = Looper.myLooper();
        return (looperMyLooper == null || looperMyLooper != Looper.getMainLooper()) ? i : i | 4;
    }

    public static SQLiteDatabase w(int i, String str, DatabaseErrorHandler databaseErrorHandler, CursorFactory cursorFactory, SQLiteDatabaseHook sQLiteDatabaseHook, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(i, str, databaseErrorHandler, cursorFactory, sQLiteDatabaseHook, bArr);
        try {
            try {
                sQLiteDatabase.E();
                return sQLiteDatabase;
            } catch (SQLiteDatabaseCorruptException unused) {
                synchronized (sQLiteDatabase.e) {
                    EventLog.writeEvent(75004, sQLiteDatabase.g.b);
                    sQLiteDatabase.d.a(sQLiteDatabase);
                    sQLiteDatabase.E();
                    return sQLiteDatabase;
                }
            }
        } catch (SQLiteException e) {
            StringBuilder sb = new StringBuilder("Failed to open database '");
            synchronized (sQLiteDatabase.e) {
                sb.append(sQLiteDatabase.g.b);
                sb.append("'.");
                Log.e("SQLiteDatabase", sb.toString(), e);
                sQLiteDatabase.f();
                throw e;
            }
        }
    }

    public final void E() {
        synchronized (this.e) {
            SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
            if (sQLiteDatabaseConfiguration == null) {
                throw new IllegalArgumentException("configuration must not be null.");
            }
            SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabaseConfiguration);
            sQLiteConnectionPool.k = sQLiteConnectionPool.l(sQLiteConnectionPool.d, true);
            sQLiteConnectionPool.f = true;
            sQLiteConnectionPool.f5386a.a();
            this.h = sQLiteConnectionPool;
            this.f.a();
        }
        WeakHashMap weakHashMap = f5394j;
        synchronized (weakHashMap) {
            weakHashMap.put(this, null);
        }
    }

    public final Cursor F() {
        b();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, "pragma database_list;", null, null);
            CursorFactory cursorFactory = this.c;
            String str = sQLiteDirectCursorDriver.b;
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDirectCursorDriver.f5402a, sQLiteDirectCursorDriver.c, sQLiteDirectCursorDriver.d);
            try {
                return cursorFactory == null ? new SQLiteCursor(sQLiteDirectCursorDriver, str, sQLiteQuery) : cursorFactory.a();
            } catch (RuntimeException e) {
                sQLiteQuery.f();
                throw e;
            }
        } finally {
            f();
        }
    }

    public final Cursor G(String str, Object... objArr) {
        b();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, null, null);
            CursorFactory cursorFactory = this.c;
            String str2 = sQLiteDirectCursorDriver.b;
            SQLiteQuery sQLiteQuery = new SQLiteQuery(sQLiteDirectCursorDriver.f5402a, sQLiteDirectCursorDriver.c, sQLiteDirectCursorDriver.d);
            if (objArr != null) {
                try {
                    for (int length = objArr.length; length != 0; length--) {
                        sQLiteQuery.g(length, objArr[length - 1]);
                    }
                } catch (RuntimeException e) {
                    sQLiteQuery.f();
                    throw e;
                }
            }
            return cursorFactory == null ? new SQLiteCursor(sQLiteDirectCursorDriver, str2, sQLiteQuery) : cursorFactory.a();
        } finally {
            f();
        }
    }

    public final void H() {
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                int i = sQLiteDatabaseConfiguration.c;
                boolean z10 = true;
                if ((i & 1) != 1) {
                    z10 = false;
                }
                if (z10) {
                    sQLiteDatabaseConfiguration.c = i & (-2);
                    try {
                        this.h.n(sQLiteDatabaseConfiguration);
                    } catch (RuntimeException e) {
                        this.g.c = i;
                        throw e;
                    }
                }
            } finally {
            }
        }
    }

    public final void I() {
        if (this.h == null) {
            throw new IllegalStateException(a.q(new StringBuilder("The database '"), this.g.b, "' is not open."));
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransaction() {
        g(null, true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionNonExclusive() {
        g(null, false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        g(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.2
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        }, true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener sQLiteTransactionListener) {
        g(new SQLiteTransactionListener() { // from class: net.zetetic.database.sqlcipher.SQLiteDatabase.3
            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onBegin() {
                sQLiteTransactionListener.onBegin();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onCommit() {
                sQLiteTransactionListener.onCommit();
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteTransactionListener
            public final void onRollback() {
                sQLiteTransactionListener.onRollback();
            }
        }, false);
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public final void c() {
        l(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int delete(String str, String str2, Object[] objArr) {
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            strArr[i] = objArr[i].toString();
        }
        b();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM ");
            sb.append(str);
            sb.append(TextUtils.isEmpty(str2) ? "" : " WHERE " + str2);
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), strArr, null);
            try {
                int iExecuteUpdateDelete = sQLiteStatement.executeUpdateDelete();
                f();
                return iExecuteUpdateDelete;
            } finally {
                sQLiteStatement.f();
            }
        } catch (Throwable th) {
            f();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void disableWriteAheadLogging() {
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                int i = sQLiteDatabaseConfiguration.c;
                if ((i & 536870912) == 0) {
                    return;
                }
                sQLiteDatabaseConfiguration.c = i & (-536870913);
                try {
                    this.h.n(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.g.c |= 536870912;
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean enableWriteAheadLogging() {
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                int i = sQLiteDatabaseConfiguration.c;
                if ((i & 536870912) != 0) {
                    return true;
                }
                if ((i & 1) == 1) {
                    return false;
                }
                if (sQLiteDatabaseConfiguration.f5400a.equalsIgnoreCase(":memory:")) {
                    Log.i("SQLiteDatabase", "can't enable WAL for memory databases.");
                    return false;
                }
                if (this.i) {
                    if (Log.isLoggable("SQLiteDatabase", 3)) {
                        Log.d("SQLiteDatabase", "this database: " + this.g.b + " has attached databases. can't  enable WAL.");
                    }
                    return false;
                }
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration2 = this.g;
                sQLiteDatabaseConfiguration2.c |= 536870912;
                try {
                    this.h.n(sQLiteDatabaseConfiguration2);
                    return true;
                } catch (RuntimeException e) {
                    this.g.c &= -536870913;
                    throw e;
                }
            } finally {
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void endTransaction() {
        b();
        try {
            SQLiteSession sQLiteSessionS = s();
            if (sQLiteSessionS.f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            sQLiteSessionS.c(null, false);
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String str) {
        n(str, null);
    }

    public final void finalize() throws Throwable {
        try {
            l(true);
        } finally {
            super.finalize();
        }
    }

    public final void g(SQLiteTransactionListener sQLiteTransactionListener, boolean z10) {
        b();
        try {
            SQLiteSession sQLiteSessionS = s();
            int i = z10 ? 2 : 1;
            int iR = r(false);
            sQLiteSessionS.l();
            sQLiteSessionS.b(i, sQLiteTransactionListener, iR, null);
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final List getAttachedDbs() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.e) {
            try {
                Cursor cursorF = null;
                if (this.h == null) {
                    return null;
                }
                if (!this.i) {
                    arrayList.add(new Pair("main", this.g.f5400a));
                    return arrayList;
                }
                b();
                try {
                    try {
                        cursorF = F();
                        while (cursorF.moveToNext()) {
                            arrayList.add(new Pair(cursorF.getString(1), cursorF.getString(2)));
                        }
                        cursorF.close();
                        return arrayList;
                    } catch (Throwable th) {
                        if (cursorF != null) {
                            cursorF.close();
                        }
                        throw th;
                    }
                } finally {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getMaximumSize() {
        return DatabaseUtils.b(this, "PRAGMA page_size;") * DatabaseUtils.b(this, "PRAGMA max_page_count;");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long getPageSize() {
        return DatabaseUtils.b(this, "PRAGMA page_size;");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        String str;
        synchronized (this.e) {
            str = this.g.f5400a;
        }
        return str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int getVersion() {
        return Long.valueOf(DatabaseUtils.b(this, "PRAGMA user_version;")).intValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final SQLiteStatement compileStatement(String str) {
        b();
        try {
            return new SQLiteStatement(this, str, null, null);
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean inTransaction() {
        b();
        try {
            return s().f != null;
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long insert(String str, int i, ContentValues contentValues) {
        Object[] objArr;
        b();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT");
            sb.append(k[i]);
            sb.append(" INTO ");
            sb.append(str);
            sb.append('(');
            int i6 = 0;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                objArr = new Object[size];
                int i10 = 0;
                for (String str2 : contentValues.keySet()) {
                    sb.append(i10 > 0 ? "," : "");
                    sb.append(str2);
                    objArr[i10] = contentValues.get(str2);
                    i10++;
                }
                sb.append(')');
                sb.append(" VALUES (");
                while (i6 < size) {
                    sb.append(i6 > 0 ? ",?" : "?");
                    i6++;
                }
            } else {
                sb.append("null) VALUES (NULL");
                objArr = null;
            }
            sb.append(')');
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr, null);
            try {
                long jExecuteInsert = sQLiteStatement.executeInsert();
                f();
                return jExecuteInsert;
            } finally {
                sQLiteStatement.f();
            }
        } catch (Throwable th) {
            f();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDatabaseIntegrityOk() {
        List list;
        List attachedDbs;
        b();
        try {
            try {
                attachedDbs = getAttachedDbs();
            } catch (SQLiteException unused) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair("main", getPath()));
                list = arrayList;
            }
            if (attachedDbs == null) {
                throw new IllegalStateException("databaselist for: " + getPath() + " couldn't be retrieved. probably because the database is closed");
            }
            list = attachedDbs;
            for (int i = 0; i < list.size(); i++) {
                Pair pair = (Pair) list.get(i);
                SQLiteStatement sQLiteStatementCompileStatement = null;
                try {
                    sQLiteStatementCompileStatement = compileStatement("PRAGMA " + ((String) pair.first) + ".integrity_check(1);");
                    String strSimpleQueryForString = sQLiteStatementCompileStatement.simpleQueryForString();
                    if (!strSimpleQueryForString.equalsIgnoreCase("ok")) {
                        Log.e("SQLiteDatabase", "PRAGMA integrity_check on " + ((String) pair.second) + " returned: " + strSimpleQueryForString);
                        sQLiteStatementCompileStatement.f();
                        return false;
                    }
                    sQLiteStatementCompileStatement.f();
                } catch (Throwable th) {
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.f();
                    }
                    throw th;
                }
            }
            f();
            return true;
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isDbLockedByCurrentThread() {
        b();
        try {
            return s().b != null;
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isOpen() {
        boolean z10;
        synchronized (this.e) {
            z10 = this.h != null;
        }
        return z10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isReadOnly() {
        boolean z10;
        synchronized (this.e) {
            z10 = true;
            if ((this.g.c & 1) != 1) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean isWriteAheadLoggingEnabled() {
        boolean z10;
        synchronized (this.e) {
            I();
            z10 = (this.g.c & 536870912) != 0;
        }
        return z10;
    }

    public final void l(boolean z10) {
        SQLiteConnectionPool sQLiteConnectionPool;
        Throwable th;
        synchronized (this.e) {
            try {
                CloseGuard closeGuard = this.f;
                if (closeGuard != null) {
                    if (z10 && (th = closeGuard.f5378a) != null) {
                        Log.w("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", th);
                    }
                    this.f.f5378a = null;
                }
                sQLiteConnectionPool = this.h;
                this.h = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z10) {
            return;
        }
        WeakHashMap weakHashMap = f5394j;
        synchronized (weakHashMap) {
            weakHashMap.remove(this);
        }
        if (sQLiteConnectionPool != null) {
            sQLiteConnectionPool.f(false);
        }
    }

    public final void n(String str, Object[] objArr) {
        boolean z10;
        b();
        try {
            if (DatabaseUtils.a(str) == 3) {
                synchronized (this.e) {
                    try {
                        if (this.i) {
                            z10 = false;
                        } else {
                            z10 = true;
                            this.i = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z10) {
                    disableWriteAheadLogging();
                }
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, objArr, null);
            try {
                sQLiteStatement.executeUpdateDelete();
            } finally {
                sQLiteStatement.f();
            }
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean needUpgrade(int i) {
        return i > getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(String str) {
        return G(str, new Object[0]);
    }

    public final SQLiteSession s() {
        return (SQLiteSession) this.b.get();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setForeignKeyConstraintsEnabled(boolean z10) {
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                if (sQLiteDatabaseConfiguration.f == z10) {
                    return;
                }
                sQLiteDatabaseConfiguration.f = z10;
                try {
                    this.h.n(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.g.f = !z10;
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setLocale(Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("locale must not be null.");
        }
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                Locale locale2 = sQLiteDatabaseConfiguration.e;
                sQLiteDatabaseConfiguration.e = locale;
                try {
                    this.h.n(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.g.e = locale2;
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setMaxSqlCacheSize(int i) {
        if (i > 100 || i < 0) {
            throw new IllegalStateException("expected value between 0 and 100");
        }
        synchronized (this.e) {
            try {
                I();
                SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.g;
                int i6 = sQLiteDatabaseConfiguration.d;
                sQLiteDatabaseConfiguration.d = i;
                try {
                    this.h.n(sQLiteDatabaseConfiguration);
                } catch (RuntimeException e) {
                    this.g.d = i6;
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final long setMaximumSize(long j5) {
        long jB = DatabaseUtils.b(this, "PRAGMA page_size;");
        long j6 = j5 / jB;
        if (j5 % jB != 0) {
            j6++;
        }
        return DatabaseUtils.b(this, "PRAGMA max_page_count = " + j6) * jB;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setPageSize(long j5) {
        n("PRAGMA page_size = " + j5, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setTransactionSuccessful() {
        b();
        try {
            SQLiteSession sQLiteSessionS = s();
            if (sQLiteSessionS.f == null) {
                throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            }
            sQLiteSessionS.l();
            sQLiteSessionS.f.d = true;
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void setVersion(int i) {
        n("PRAGMA user_version = " + i, null);
    }

    public final String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        int i6 = 0;
        for (int i10 = 0; i10 < objArr.length; i10++) {
            strArr[i10] = objArr[i10].toString();
        }
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        b();
        try {
            StringBuilder sb = new StringBuilder(MenuKt.InTransitionDuration);
            sb.append("UPDATE ");
            sb.append(k[i]);
            sb.append(str);
            sb.append(" SET ");
            int size = contentValues.size();
            int i11 = length + size;
            Object[] objArr2 = new Object[i11];
            for (String str3 : contentValues.keySet()) {
                sb.append(i6 > 0 ? "," : "");
                sb.append(str3);
                objArr2[i6] = contentValues.get(str3);
                sb.append("=?");
                i6++;
            }
            for (int i12 = size; i12 < i11; i12++) {
                objArr2[i12] = strArr[i12 - size];
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr2, null);
            try {
                int iExecuteUpdateDelete = sQLiteStatement.executeUpdateDelete();
                f();
                return iExecuteUpdateDelete;
            } finally {
                sQLiteStatement.f();
            }
        } catch (Throwable th) {
            f();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely() {
        b();
        try {
            return s().m(-1L);
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final void execSQL(String str, Object[] objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("Empty bindArgs");
        }
        n(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(String str, Object[] objArr) {
        return G(str, objArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        b();
        try {
            String query = supportSQLiteQuery.getQuery();
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, query, "", cancellationSignal);
            SQLiteQuery sQLiteQuery = new SQLiteQuery(this, query, cancellationSignal);
            supportSQLiteQuery.bindTo(sQLiteQuery);
            return new SQLiteCursor(sQLiteDirectCursorDriver, "", sQLiteQuery);
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final boolean yieldIfContendedSafely(long j5) {
        b();
        try {
            return s().m(j5);
        } finally {
            f();
        }
    }
}
