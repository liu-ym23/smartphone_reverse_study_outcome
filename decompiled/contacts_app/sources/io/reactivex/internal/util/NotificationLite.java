package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final enum NotificationLite extends Enum<NotificationLite> {
    private static final /* synthetic */ NotificationLite[] $VALUES = null;
    public static final NotificationLite COMPLETE = null;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        DisposableNotification(Disposable r1) {
            this.upstream = r1;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;
        final Throwable e;

        ErrorNotification(Throwable r1) {
            this.e = r1;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.e + "]";
        }

        public int hashCode() {
            return this.e.hashCode();
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ErrorNotification) == true) goto L5;
            return false;
        L5:
            return ObjectHelper.equals(this.e, ((ErrorNotification) r2).e);
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription upstream;

        SubscriptionNotification(Subscription r1) {
            this.upstream = r1;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object r0) {
        return r0;
    }

    public static <T> Object next(T r0) {
        return r0;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    private NotificationLite(String r1, int r2) {
        super(r1, r2);
    }

    public static NotificationLite valueOf(String r1) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, r1);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) $VALUES.clone();
    }

    static {
        NotificationLite r0 = new NotificationLite("COMPLETE", 0);
        COMPLETE = r0;
        $VALUES = new NotificationLite[]{r0};
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object error(Throwable r1) {
        return new ErrorNotification(r1);
    }

    public static Object subscription(Subscription r1) {
        return new SubscriptionNotification(r1);
    }

    public static Object disposable(Disposable r1) {
        return new DisposableNotification(r1);
    }

    public static boolean isComplete(Object r1) {
        if (r1 != COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isError(Object r0) {
        return r0 instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object r0) {
        return r0 instanceof SubscriptionNotification;
    }

    public static boolean isDisposable(Object r0) {
        return r0 instanceof DisposableNotification;
    }

    public static Throwable getError(Object r0) {
        return ((ErrorNotification) r0).e;
    }

    public static Subscription getSubscription(Object r0) {
        return ((SubscriptionNotification) r0).upstream;
    }

    public static Disposable getDisposable(Object r0) {
        return ((DisposableNotification) r0).upstream;
    }

    public static <T> boolean accept(Object r2, Subscriber<? super T> r3) {
        if (r2 != COMPLETE) goto L7;
        r3.onComplete();
        return true;
    L7:
        if ((r2 instanceof ErrorNotification) == false) goto L10;
        r3.onError(((ErrorNotification) r2).e);
        return true;
    L10:
        r3.onNext(r2);
        return false;
    }

    public static <T> boolean accept(Object r2, Observer<? super T> r3) {
        if (r2 != COMPLETE) goto L7;
        r3.onComplete();
        return true;
    L7:
        if ((r2 instanceof ErrorNotification) == false) goto L10;
        r3.onError(((ErrorNotification) r2).e);
        return true;
    L10:
        r3.onNext(r2);
        return false;
    }

    public static <T> boolean acceptFull(Object r2, Subscriber<? super T> r3) {
        if (r2 != COMPLETE) goto L7;
        r3.onComplete();
        return true;
    L7:
        if ((r2 instanceof ErrorNotification) == false) goto L11;
        r3.onError(((ErrorNotification) r2).e);
        return true;
    L11:
        if ((r2 instanceof SubscriptionNotification) == false) goto L14;
        r3.onSubscribe(((SubscriptionNotification) r2).upstream);
        return false;
    L14:
        r3.onNext(r2);
        return false;
    }

    public static <T> boolean acceptFull(Object r2, Observer<? super T> r3) {
        if (r2 != COMPLETE) goto L7;
        r3.onComplete();
        return true;
    L7:
        if ((r2 instanceof ErrorNotification) == false) goto L11;
        r3.onError(((ErrorNotification) r2).e);
        return true;
    L11:
        if ((r2 instanceof DisposableNotification) == false) goto L14;
        r3.onSubscribe(((DisposableNotification) r2).upstream);
        return false;
    L14:
        r3.onNext(r2);
        return false;
    }
}
