package z3;

import A3.c;
import A3.d;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import x3.p;

/* renamed from: z3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1348b extends p {

    /* renamed from: b, reason: collision with root package name */
    private final Handler f24069b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f24070c;

    /* renamed from: z3.b$a */
    private static final class a extends p.c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f24071a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f24072b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f24073c;

        a(Handler handler, boolean z5) {
            this.f24071a = handler;
            this.f24072b = z5;
        }

        @Override // x3.p.c
        public c c(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f24073c) {
                return d.a();
            }
            RunnableC0260b runnableC0260b = new RunnableC0260b(this.f24071a, S3.a.t(runnable));
            Message messageObtain = Message.obtain(this.f24071a, runnableC0260b);
            messageObtain.obj = this;
            if (this.f24072b) {
                messageObtain.setAsynchronous(true);
            }
            this.f24071a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j5));
            if (!this.f24073c) {
                return runnableC0260b;
            }
            this.f24071a.removeCallbacks(runnableC0260b);
            return d.a();
        }

        @Override // A3.c
        public void dispose() {
            this.f24073c = true;
            this.f24071a.removeCallbacksAndMessages(this);
        }

        @Override // A3.c
        public boolean g() {
            return this.f24073c;
        }
    }

    /* renamed from: z3.b$b, reason: collision with other inner class name */
    private static final class RunnableC0260b implements Runnable, c {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f24074a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f24075b;

        /* renamed from: c, reason: collision with root package name */
        private volatile boolean f24076c;

        RunnableC0260b(Handler handler, Runnable runnable) {
            this.f24074a = handler;
            this.f24075b = runnable;
        }

        @Override // A3.c
        public void dispose() {
            this.f24074a.removeCallbacks(this);
            this.f24076c = true;
        }

        @Override // A3.c
        public boolean g() {
            return this.f24076c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f24075b.run();
            } catch (Throwable th) {
                S3.a.r(th);
            }
        }
    }

    C1348b(Handler handler, boolean z5) {
        this.f24069b = handler;
        this.f24070c = z5;
    }

    @Override // x3.p
    public p.c a() {
        return new a(this.f24069b, this.f24070c);
    }

    @Override // x3.p
    public c c(Runnable runnable, long j5, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0260b runnableC0260b = new RunnableC0260b(this.f24069b, S3.a.t(runnable));
        Message messageObtain = Message.obtain(this.f24069b, runnableC0260b);
        if (this.f24070c) {
            messageObtain.setAsynchronous(true);
        }
        this.f24069b.sendMessageDelayed(messageObtain, timeUnit.toMillis(j5));
        return runnableC0260b;
    }
}
