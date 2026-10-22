package io.objectbox.exception;

/* loaded from: classes4.dex */
public class DbDetachedException extends DbException {
    public DbDetachedException() {
        this("Entity must be attached to a Box.");
    }

    public DbDetachedException(String str) {
        super(str);
    }
}
