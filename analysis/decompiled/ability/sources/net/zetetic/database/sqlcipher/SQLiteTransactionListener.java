package net.zetetic.database.sqlcipher;

/* loaded from: classes4.dex */
public interface SQLiteTransactionListener {
    void onBegin();

    void onCommit();

    void onRollback();
}
