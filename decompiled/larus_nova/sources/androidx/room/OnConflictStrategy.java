package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
@Retention(RetentionPolicy.CLASS)
public @interface OnConflictStrategy {
    public static final int ABORT = 3;
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int REPLACE = 1;
    public static final int ROLLBACK = 2;
}
