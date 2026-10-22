package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NotificationLite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f24153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f24154b = null;

    public static final class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f24155e;

        public OnErrorSentinel(Throwable r10) {
            this.f24155e = r10;
        }

        public String toString() {
            return "Notification=>Error:" + this.f24155e;
        }
    }

    static {
        f24153a = new AnonymousClass1();
        f24154b = new AnonymousClass2();
    }

    public static boolean a(Observer r10, Object r11) {
        if (r11 != f24153a) goto L7;
        r10.onCompleted();
        return true;
    L7:
        if (r11 != f24154b) goto L10;
        r10.onNext(null);
        return false;
    L10:
        if (r11 == null) goto L18;
        if (r11.getClass() != OnErrorSentinel.class) goto L15;
        r10.onError(((OnErrorSentinel) r11).f24155e);
        return true;
    L15:
        r10.onNext(r11);
        return false;
    L18:
        throw new IllegalArgumentException("The lite notification can not be null");
    }

    public static Object b() {
        return f24153a;
    }

    public static Object c(Throwable r10) {
        return new OnErrorSentinel(r10);
    }

    public static Object d(Object r10) {
        if (r10 != f24154b) goto L6;
        return null;
    L6:
        return r10;
    }

    public static boolean e(Object r10) {
        if (r10 != f24153a) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(Object r10) {
        return r10 instanceof OnErrorSentinel;
    }

    public static Object g(Object r10) {
        if (r10 == null) goto L4;
        return r10;
    L4:
        return f24154b;
    }
}
