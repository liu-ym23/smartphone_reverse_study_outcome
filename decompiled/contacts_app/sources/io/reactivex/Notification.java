package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes4.dex */
public final class Notification<T> {
    static final Notification<Object> COMPLETE = null;
    final Object value;

    private Notification(Object r1) {
        this.value = r1;
    }

    public boolean isOnComplete() {
        if (this.value != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.value);
    }

    public boolean isOnNext() {
        Object r0 = this.value;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(r0) == true) goto L7;
        return true;
    }

    public T getValue() {
        Object r0 = this.value;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (NotificationLite.isError(r0) == false) goto L7;
        return null;
    L7:
        return (T) this.value;
    }

    public Throwable getError() {
        Object r1 = this.value;
        if (NotificationLite.isError(r1) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Notification) == true) goto L5;
        return false;
    L5:
        return ObjectHelper.equals(this.value, ((Notification) r2).value);
    }

    public int hashCode() {
        Object r0 = this.value;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        Object r0 = this.value;
        if (r0 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r0) == false) goto L11;
        return "OnErrorNotification[" + NotificationLite.getError(r0) + "]";
    L11:
        return "OnNextNotification[" + this.value + "]";
    }

    public static <T> Notification<T> createOnNext(T r1) {
        ObjectHelper.requireNonNull(r1, "value is null");
        return new Notification(r1);
    }

    public static <T> Notification<T> createOnError(Throwable r1) {
        ObjectHelper.requireNonNull(r1, "error is null");
        return new Notification(NotificationLite.error(r1));
    }

    public static <T> Notification<T> createOnComplete() {
        return (Notification<T>) COMPLETE;
    }

    static {
        COMPLETE = new Notification(null);
    }
}
