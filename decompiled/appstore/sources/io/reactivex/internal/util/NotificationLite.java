package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public final enum NotificationLite extends Enum<NotificationLite> {
    private static final /* synthetic */ NotificationLite[] $VALUES = null;
    public static final NotificationLite COMPLETE = null;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final Disposable upstream;

        public DisposableNotification(Disposable r10) {
            this.upstream = r10;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f20727e;

        public ErrorNotification(Throwable r10) {
            this.f20727e = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ErrorNotification) == true) goto L5;
            return false;
        L5:
            return io.reactivex.internal.functions.a.a(this.f20727e, ((ErrorNotification) r10).f20727e);
        }

        public int hashCode() {
            return this.f20727e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f20727e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final Subscription upstream;

        public SubscriptionNotification(Subscription r10) {
            this.upstream = r10;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    static {
        NotificationLite r10 = new NotificationLite("COMPLETE", 0);
        COMPLETE = r10;
        $VALUES = new NotificationLite[]{r10};
    }

    private NotificationLite(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> boolean accept(Object r10, Subscriber<? super T> r11) {
        if (r10 != COMPLETE) goto L7;
        r11.onComplete();
        return true;
    L7:
        if ((r10 instanceof ErrorNotification) == false) goto L10;
        r11.onError(((ErrorNotification) r10).f20727e);
        return true;
    L10:
        r11.onNext(r10);
        return false;
    }

    public static <T> boolean acceptFull(Object r10, Subscriber<? super T> r11) {
        if (r10 != COMPLETE) goto L7;
        r11.onComplete();
        return true;
    L7:
        if ((r10 instanceof ErrorNotification) == false) goto L11;
        r11.onError(((ErrorNotification) r10).f20727e);
        return true;
    L11:
        if ((r10 instanceof SubscriptionNotification) == false) goto L14;
        r11.onSubscribe(((SubscriptionNotification) r10).upstream);
        return false;
    L14:
        r11.onNext(r10);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(Disposable r10) {
        return new DisposableNotification(r10);
    }

    public static Object error(Throwable r10) {
        return new ErrorNotification(r10);
    }

    public static Disposable getDisposable(Object r10) {
        return ((DisposableNotification) r10).upstream;
    }

    public static Throwable getError(Object r10) {
        return ((ErrorNotification) r10).f20727e;
    }

    public static Subscription getSubscription(Object r10) {
        return ((SubscriptionNotification) r10).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object r10) {
        return r10;
    }

    public static boolean isComplete(Object r10) {
        if (r10 != COMPLETE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isDisposable(Object r10) {
        return r10 instanceof DisposableNotification;
    }

    public static boolean isError(Object r10) {
        return r10 instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object r10) {
        return r10 instanceof SubscriptionNotification;
    }

    public static <T> Object next(T r10) {
        return r10;
    }

    public static Object subscription(Subscription r10) {
        return new SubscriptionNotification(r10);
    }

    public static NotificationLite valueOf(String r10) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, r10);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object r10, Observer<? super T> r11) {
        if (r10 != COMPLETE) goto L7;
        r11.onComplete();
        return true;
    L7:
        if ((r10 instanceof ErrorNotification) == false) goto L10;
        r11.onError(((ErrorNotification) r10).f20727e);
        return true;
    L10:
        r11.onNext(r10);
        return false;
    }

    public static <T> boolean acceptFull(Object r10, Observer<? super T> r11) {
        if (r10 != COMPLETE) goto L7;
        r11.onComplete();
        return true;
    L7:
        if ((r10 instanceof ErrorNotification) == false) goto L11;
        r11.onError(((ErrorNotification) r10).f20727e);
        return true;
    L11:
        if ((r10 instanceof DisposableNotification) == false) goto L14;
        r11.onSubscribe(((DisposableNotification) r10).upstream);
        return false;
    L14:
        r11.onNext(r10);
        return false;
    }
}
