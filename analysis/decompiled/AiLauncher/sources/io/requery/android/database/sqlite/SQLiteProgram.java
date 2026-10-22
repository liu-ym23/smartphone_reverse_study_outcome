package io.requery.android.database.sqlite;

import j1.InterfaceC4758e;
import java.util.Arrays;
import x0.d;

/* loaded from: classes4.dex */
public abstract class SQLiteProgram extends SQLiteClosable implements InterfaceC4758e {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final Object[] mBindArgs;
    private final String[] mColumnNames;
    private final SQLiteDatabase mDatabase;
    private final int mNumParameters;
    private final boolean mReadOnly;
    private final String mSql;

    public SQLiteProgram(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, d dVar) {
        this.mDatabase = sQLiteDatabase;
        String strTrim = str.trim();
        this.mSql = strTrim;
        int sqlStatementType = SQLiteStatementType.getSqlStatementType(strTrim);
        if (sqlStatementType == 4 || sqlStatementType == 5 || sqlStatementType == 6) {
            this.mReadOnly = false;
            this.mColumnNames = EMPTY_STRING_ARRAY;
            this.mNumParameters = 0;
        } else {
            boolean z10 = sqlStatementType == 1;
            SQLiteStatementInfo sQLiteStatementInfo = new SQLiteStatementInfo();
            sQLiteDatabase.getThreadSession().prepare(strTrim, sQLiteDatabase.getThreadDefaultConnectionFlags(z10), dVar, sQLiteStatementInfo);
            this.mReadOnly = sQLiteStatementInfo.readOnly;
            this.mColumnNames = sQLiteStatementInfo.columnNames;
            this.mNumParameters = sQLiteStatementInfo.numParameters;
        }
        if (objArr != null && objArr.length > this.mNumParameters) {
            throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.mNumParameters + " arguments.");
        }
        int i10 = this.mNumParameters;
        if (i10 == 0) {
            this.mBindArgs = null;
            return;
        }
        Object[] objArr2 = new Object[i10];
        this.mBindArgs = objArr2;
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
    }

    private void bind(int i10, Object obj) {
        if (i10 >= 1 && i10 <= this.mNumParameters) {
            this.mBindArgs[i10 - 1] = obj;
            return;
        }
        throw new IllegalArgumentException("Cannot bind argument at index " + i10 + " because the index is out of range.  The statement has " + this.mNumParameters + " parameters.");
    }

    public void bindAllArgsAsStrings(String[] strArr) {
        if (strArr != null) {
            for (int length = strArr.length; length != 0; length--) {
                bindString(length, strArr[length - 1]);
            }
        }
    }

    @Override // j1.InterfaceC4758e
    public void bindBlob(int i10, byte[] bArr) {
        if (bArr != null) {
            bind(i10, bArr);
            return;
        }
        throw new IllegalArgumentException("the bind value at index " + i10 + " is null");
    }

    @Override // j1.InterfaceC4758e
    public void bindDouble(int i10, double d10) {
        bind(i10, Double.valueOf(d10));
    }

    @Override // j1.InterfaceC4758e
    public void bindLong(int i10, long j10) {
        bind(i10, Long.valueOf(j10));
    }

    @Override // j1.InterfaceC4758e
    public void bindNull(int i10) {
        bind(i10, null);
    }

    public void bindObject(int i10, Object obj) {
        if (obj == null) {
            bindNull(i10);
            return;
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            bindDouble(i10, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Number) {
            bindLong(i10, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                bindLong(i10, 1L);
                return;
            } else {
                bindLong(i10, 0L);
                return;
            }
        }
        if (obj instanceof byte[]) {
            bindBlob(i10, (byte[]) obj);
        } else {
            bindString(i10, obj.toString());
        }
    }

    @Override // j1.InterfaceC4758e
    public void bindString(int i10, String str) {
        if (str != null) {
            bind(i10, str);
            return;
        }
        throw new IllegalArgumentException("the bind value at index " + i10 + " is null");
    }

    @Override // j1.InterfaceC4758e
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

    public final String getSql() {
        return this.mSql;
    }

    @Override // io.requery.android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        clearBindings();
    }

    public final void onCorruption() {
        this.mDatabase.onCorruption();
    }
}
