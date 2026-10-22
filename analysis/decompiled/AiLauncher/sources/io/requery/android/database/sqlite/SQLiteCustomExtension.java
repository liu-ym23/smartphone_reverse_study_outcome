package io.requery.android.database.sqlite;

/* loaded from: classes4.dex */
public final class SQLiteCustomExtension {
    public final String entryPoint;
    public final String path;

    public SQLiteCustomExtension(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("null path");
        }
        this.path = str;
        this.entryPoint = str2;
    }
}
