package net.sqlcipher.database;

/* loaded from: classes5.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
