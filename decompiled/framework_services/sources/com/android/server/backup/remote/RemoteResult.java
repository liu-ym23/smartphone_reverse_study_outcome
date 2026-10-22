package com.android.server.backup.remote;

import com.android.internal.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RemoteResult {
    public static final RemoteResult FAILED_CANCELLED = null;
    public static final RemoteResult FAILED_THREAD_INTERRUPTED = null;
    public static final RemoteResult FAILED_TIMED_OUT = null;
    private final int mType;
    private final long mValue;

    @Retention(RetentionPolicy.SOURCE)
    private @interface Type {
        public static final int FAILED_CANCELLED = 2;
        public static final int FAILED_THREAD_INTERRUPTED = 3;
        public static final int FAILED_TIMED_OUT = 1;
        public static final int SUCCESS = 0;
    }

    static {
        FAILED_TIMED_OUT = new RemoteResult(1, 0);
        FAILED_CANCELLED = new RemoteResult(2, 0);
        FAILED_THREAD_INTERRUPTED = new RemoteResult(3, 0);
    }

    public static RemoteResult of(long value) {
        return new RemoteResult(0, value);
    }

    private RemoteResult(int type, long value) {
        this.mType = type;
        this.mValue = value;
    }

    public boolean isPresent() {
        if (this.mType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public long get() {
        Preconditions.checkState(isPresent(), "Can't obtain value of failed result");
        return this.mValue;
    }

    public String toString() {
        return "RemoteResult{" + toStringDescription() + "}";
    }

    private String toStringDescription() {
        switch(this.mType) {
            case 0: goto L13;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        return "FAILED_THREAD_INTERRUPTED";
    L8:
        return "FAILED_CANCELLED";
    L10:
        return "FAILED_TIMED_OUT";
    L5:
        throw new AssertionError("Unknown type");
    L13:
        return Long.toString(this.mValue);
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof RemoteResult) == true) goto L8;
        return false;
    L8:
        RemoteResult that = (RemoteResult) o;
        if (this.mType != that.mType) goto L14;
        if (this.mValue != that.mValue) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mType), Long.valueOf(this.mValue)});
    }
}
