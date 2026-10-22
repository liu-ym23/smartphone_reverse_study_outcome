package io.requery.android.database.sqlite;

import io.requery.android.database.sqlite.SQLiteDatabase;

/* loaded from: classes4.dex */
public class SQLiteFunction {
    private final MyArgs args;
    public final SQLiteDatabase.Function callback;
    final int flags;
    public final String name;
    public final int numArgs;
    private final MyResult result;

    public static class MyArgs implements SQLiteDatabase.Function.Args {
        int argsCount;
        long argsPtr;

        private MyArgs() {
        }

        private int checkArg(int i10) {
            if (i10 >= 0 && i10 < this.argsCount) {
                return i10;
            }
            throw new IllegalArgumentException("Requested arg " + i10 + " but had " + this.argsCount);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Args
        public byte[] getBlob(int i10) {
            return SQLiteFunction.nativeGetArgBlob(this.argsPtr, checkArg(i10));
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Args
        public double getDouble(int i10) {
            return SQLiteFunction.nativeGetArgDouble(this.argsPtr, checkArg(i10));
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Args
        public int getInt(int i10) {
            return SQLiteFunction.nativeGetArgInt(this.argsPtr, checkArg(i10));
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Args
        public long getLong(int i10) {
            return SQLiteFunction.nativeGetArgLong(this.argsPtr, checkArg(i10));
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Args
        public String getString(int i10) {
            return SQLiteFunction.nativeGetArgString(this.argsPtr, checkArg(i10));
        }
    }

    public SQLiteFunction(String str, int i10, SQLiteDatabase.Function function) {
        this(str, i10, function, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchCallback(long j10, long j11, int i10) {
        MyResult myResult = this.result;
        myResult.contextPtr = j10;
        MyArgs myArgs = this.args;
        myArgs.argsPtr = j11;
        myArgs.argsCount = i10;
        try {
            this.callback.callback(myArgs, myResult);
            MyResult myResult2 = this.result;
            if (!myResult2.isSet) {
                myResult2.setNull();
            }
        } finally {
            MyResult myResult3 = this.result;
            myResult3.contextPtr = 0L;
            myResult3.isSet = false;
            MyArgs myArgs2 = this.args;
            myArgs2.argsPtr = 0L;
            myArgs2.argsCount = 0;
        }
    }

    public static native byte[] nativeGetArgBlob(long j10, int i10);

    public static native double nativeGetArgDouble(long j10, int i10);

    public static native int nativeGetArgInt(long j10, int i10);

    public static native long nativeGetArgLong(long j10, int i10);

    public static native String nativeGetArgString(long j10, int i10);

    public static native void nativeSetResultBlob(long j10, byte[] bArr);

    public static native void nativeSetResultDouble(long j10, double d10);

    public static native void nativeSetResultError(long j10, String str);

    public static native void nativeSetResultInt(long j10, int i10);

    public static native void nativeSetResultLong(long j10, long j11);

    public static native void nativeSetResultNull(long j10);

    public static native void nativeSetResultString(long j10, String str);

    public static class MyResult implements SQLiteDatabase.Function.Result {
        long contextPtr;
        boolean isSet;

        private MyResult() {
        }

        private void checkSet() {
            if (this.isSet) {
                throw new IllegalStateException("Result is already set");
            }
            this.isSet = true;
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void set(byte[] bArr) {
            checkSet();
            SQLiteFunction.nativeSetResultBlob(this.contextPtr, bArr);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void setError(String str) {
            checkSet();
            SQLiteFunction.nativeSetResultError(this.contextPtr, str);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void setNull() {
            checkSet();
            SQLiteFunction.nativeSetResultNull(this.contextPtr);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void set(double d10) {
            checkSet();
            SQLiteFunction.nativeSetResultDouble(this.contextPtr, d10);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void set(int i10) {
            checkSet();
            SQLiteFunction.nativeSetResultInt(this.contextPtr, i10);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void set(long j10) {
            checkSet();
            SQLiteFunction.nativeSetResultLong(this.contextPtr, j10);
        }

        @Override // io.requery.android.database.sqlite.SQLiteDatabase.Function.Result
        public void set(String str) {
            checkSet();
            SQLiteFunction.nativeSetResultString(this.contextPtr, str);
        }
    }

    public SQLiteFunction(String str, int i10, SQLiteDatabase.Function function, int i11) {
        this.args = new MyArgs();
        this.result = new MyResult();
        if (str == null) {
            throw new IllegalArgumentException("name must not be null.");
        }
        this.name = str;
        this.numArgs = i10;
        this.callback = function;
        this.flags = i11;
    }
}
