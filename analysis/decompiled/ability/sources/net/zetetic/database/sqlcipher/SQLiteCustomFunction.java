package net.zetetic.database.sqlcipher;

import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes4.dex */
public final class SQLiteCustomFunction {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase.CustomFunction f5393a;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i, SQLiteDatabase.CustomFunction customFunction) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null.");
        }
        this.name = str;
        this.numArgs = i;
        this.f5393a = customFunction;
    }

    private void dispatchCallback(String[] strArr) {
        this.f5393a.a();
    }
}
