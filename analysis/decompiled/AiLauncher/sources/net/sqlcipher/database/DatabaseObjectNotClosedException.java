package net.sqlcipher.database;

/* loaded from: classes5.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s, reason: collision with root package name */
    private static final String f37303s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f37303s);
    }
}
