package rx.subscriptions;

import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24477a = null;

    public static final class a implements Subscription {
        public a() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }

    static {
        f24477a = new a();
    }

    public static Subscription a(Action0 r10) {
        return rx.subscriptions.a.a(r10);
    }

    public static Subscription b() {
        return f24477a;
    }
}
