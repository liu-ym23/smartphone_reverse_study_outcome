package mg;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import og.f;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.subscriptions.e;

/* JADX INFO: loaded from: classes4.dex */
public class b extends jg.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f22304a;

    public static class a extends jg.a.AbstractC0284a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f22305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final lg.b f22306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f22307c;

        public a(Handler r10) {
            this.f22305a = r10;
            this.f22306b = lg.a.a().b();
        }

        @Override // jg.a.AbstractC0284a
        public Subscription a(Action0 r10) {
            return b(r10, 0, TimeUnit.MILLISECONDS);
        }

        @Override // jg.a.AbstractC0284a
        public Subscription b(Action0 r10, long r11, TimeUnit r12) {
            if (this.f22307c == true) goto L5;
            RunnableC0319b r13 = new RunnableC0319b(this.f22306b.c(r10), this.f22305a);
            Message r14 = Message.obtain(this.f22305a, r13);
            r14.obj = this;
            this.f22305a.sendMessageDelayed(r14, r12.toMillis(r11));
            if (this.f22307c == false) goto L10;
            this.f22305a.removeCallbacks(r13);
            return e.b();
        L10:
            return r13;
        L5:
            return e.b();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f22307c;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f22307c = true;
            this.f22305a.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: renamed from: mg.b$b, reason: collision with other inner class name */
    public static final class RunnableC0319b implements Runnable, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Action0 f22308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f22309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f22310c;

        public RunnableC0319b(Action0 r10, Handler r11) {
            this.f22308a = r10;
            this.f22309b = r11;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f22310c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22308a.call();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if ((th instanceof OnErrorNotImplementedException) == false) goto L8;
            IllegalStateException r10 = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
        L9:
            f.c().b().a(r10);
            Thread r11 = Thread.currentThread();
            r11.getUncaughtExceptionHandler().uncaughtException(r11, r10);
            return;
        L8:
            r10 = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
            goto L9
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f22310c = true;
            this.f22309b.removeCallbacks(this);
        }
    }

    public b(Looper r10) {
        this.f22304a = new Handler(r10);
    }

    @Override // jg.a
    public jg.a.AbstractC0284a createWorker() {
        return new a(this.f22304a);
    }
}
