package net.zetetic.database.sqlcipher;

import B0.g;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import java.util.Arrays;
import k0.h;
import s.AbstractC0831a;

/* loaded from: classes2.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements h {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Object[] mBindArgs;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        String strTrim = str.trim();
        this.mSql = strTrim;
        int sqlStatementType = DatabaseUtils.getSqlStatementType(strTrim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.mReadOnly = false;
            this.mColumnNames = EMPTY_STRING_ARRAY;
            this.mNumParameters = 0;
        } else {
            boolean z4 = sqlStatementType == 1;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            sQLiteDatabase.getThreadSession().prepare(strTrim, sQLiteDatabase.getThreadDefaultConnectionFlags(z4), cancellationSignal, sQLiteStatementInfo);
            this.mReadOnly = sQLiteStatementInfo.readOnly;
            this.mColumnNames = sQLiteStatementInfo.columnNames;
            this.mNumParameters = sQLiteStatementInfo.numParameters;
        }
        if (objArr != null && objArr.length > this.mNumParameters) {
            StringBuilder sb = new StringBuilder("Too many bind arguments.  ");
            sb.append(objArr.length);
            sb.append(" arguments were provided but the statement needs ");
            throw new IllegalArgumentException(AbstractC0831a.d(sb, this.mNumParameters, " arguments."));
        }
        int i4 = this.mNumParameters;
        if (i4 == 0) {
            this.mBindArgs = null;
            return;
        }
        Object[] objArr2 = new Object[i4];
        this.mBindArgs = objArr2;
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    private void bind(int i4, Object obj) {
        if (i4 < 1 || i4 > this.mNumParameters) {
            throw new IllegalArgumentException(AbstractC0831a.d(g.t("Cannot bind argument at index ", i4, " because the index is out of range.  The statement has "), this.mNumParameters, " parameters."));
        }
        this.mBindArgs[i4 - 1] = obj;
    }

    public void bindAllArgs(Object... objArr) {
        if (objArr != null) {
            for (int length = objArr.length; length != 0; length--) {
                bind(length, objArr[length - 1]);
            }
        }
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    @Override // k0.h
    public void bindBlob(int i4, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException(g.j("the bind value at index ", i4, " is null"));
        }
        bind(i4, bArr);
    }

    @Override // k0.h
    public void bindDouble(int i4, double d4) {
        bind(i4, Double.valueOf(d4));
    }

    @Override // k0.h
    public void bindLong(int i4, long j4) {
        bind(i4, Long.valueOf(j4));
    }

    @Override // k0.h
    public void bindNull(int i4) {
        bind(i4, null);
    }

    @Override // k0.h
    public void bindString(int i4, String str) {
        if (str == null) {
            throw new IllegalArgumentException(g.j("the bind value at index ", i4, " is null"));
        }
        bind(i4, str);
    }

    public void clearBindings() {
        Object[] objArr = this.mBindArgs;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    public final Object[] getBindArgs() {
        return this.mBindArgs;
    }

    public final String[] getColumnNames() {
        return this.mColumnNames;
    }

    public final int getConnectionFlags() {
        return this.mDatabase.getThreadDefaultConnectionFlags(this.mReadOnly);
    }

    public final SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public final SQLiteSession getSession() {
        return this.mDatabase.getThreadSession();
    }

    public String getSql() {
        return this.mSql;
    }

    @Deprecated
    public final int getUniqueId() {
        return -1;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteClosable
    public void onAllReferencesReleased() {
        clearBindings();
    }

    public final void onCorruption(SQLiteException sQLiteException) {
        this.mDatabase.onCorruption(sQLiteException);
    }
}
