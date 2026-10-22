package net.zetetic.database.sqlcipher;

import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes2.dex */
public final class SQLiteCustomFunction {
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i4, SQLiteDatabase.CustomFunction customFunction) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null.");
        }
        this.name = str;
        this.numArgs = i4;
        this.callback = customFunction;
    }

    private void dispatchCallback(String[] strArr) {
        this.callback.callback(strArr);
    }
}
