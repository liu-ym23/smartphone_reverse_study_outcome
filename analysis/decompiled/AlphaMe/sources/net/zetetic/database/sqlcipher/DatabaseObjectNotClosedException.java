package net.zetetic.database.sqlcipher;

/* loaded from: classes2.dex */
public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s, reason: collision with root package name */
    private static final String f13671s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f13671s);
    }
}
