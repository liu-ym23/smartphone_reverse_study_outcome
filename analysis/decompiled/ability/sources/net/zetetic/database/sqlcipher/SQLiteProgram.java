package net.zetetic.database.sqlcipher;

import android.database.DatabaseUtils;
import android.os.CancellationSignal;
import android.util.EventLog;
import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.Arrays;

/* loaded from: classes4.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements SupportSQLiteProgram {
    public static final String[] h = new String[0];
    public final SQLiteDatabase b;
    public final String c;
    public final boolean d;
    public final String[] e;
    public final int f;
    public final Object[] g;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        this.b = sQLiteDatabase;
        String strTrim = str.trim();
        this.c = strTrim;
        int sqlStatementType = DatabaseUtils.getSqlStatementType(strTrim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.d = false;
            this.e = h;
            this.f = 0;
        } else {
            boolean z10 = sqlStatementType == 1;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            SQLiteSession sQLiteSessionS = sQLiteDatabase.s();
            int iR = SQLiteDatabase.r(z10);
            sQLiteSessionS.getClass();
            if (strTrim == null) {
                throw new IllegalArgumentException("sql must not be null.");
            }
            if (cancellationSignal != null) {
                cancellationSignal.throwIfCanceled();
            }
            sQLiteSessionS.a(strTrim, iR, cancellationSignal);
            try {
                sQLiteSessionS.b.q(strTrim, sQLiteStatementInfo);
                sQLiteSessionS.k();
                this.d = sQLiteStatementInfo.c;
                this.e = sQLiteStatementInfo.b;
                this.f = sQLiteStatementInfo.f5408a;
            } catch (Throwable th) {
                sQLiteSessionS.k();
                throw th;
            }
        }
        if (objArr != null && objArr.length > this.f) {
            StringBuilder sb = new StringBuilder("Too many bind arguments.  ");
            sb.append(objArr.length);
            sb.append(" arguments were provided but the statement needs ");
            throw new IllegalArgumentException(a.o(sb, " arguments.", this.f));
        }
        int i = this.f;
        if (i == 0) {
            this.g = null;
            return;
        }
        Object[] objArr2 = new Object[i];
        this.g = objArr2;
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException(a.i(i, "the bind value at index ", " is null"));
        }
        g(i, bArr);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int i, double d) {
        g(i, Double.valueOf(d));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int i, long j5) {
        g(i, Long.valueOf(j5));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int i) {
        g(i, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int i, String str) {
        if (str == null) {
            throw new IllegalArgumentException(a.i(i, "the bind value at index ", " is null"));
        }
        g(i, str);
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public final void c() {
        clearBindings();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void clearBindings() {
        Object[] objArr = this.g;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    public final void g(int i, Object obj) {
        int i6 = this.f;
        if (i < 1 || i > i6) {
            throw new IllegalArgumentException(b.o(i, "Cannot bind argument at index ", i6, " because the index is out of range.  The statement has ", " parameters."));
        }
        this.g[i - 1] = obj;
    }

    public final int i() {
        this.b.getClass();
        return SQLiteDatabase.r(this.d);
    }

    public final void k() {
        String str;
        SQLiteDatabase sQLiteDatabase = this.b;
        synchronized (sQLiteDatabase.e) {
            str = sQLiteDatabase.g.b;
        }
        EventLog.writeEvent(75004, str);
        sQLiteDatabase.d.a(sQLiteDatabase);
    }
}
