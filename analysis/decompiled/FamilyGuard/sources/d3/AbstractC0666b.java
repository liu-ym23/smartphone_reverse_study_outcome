package d3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: d3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0666b {

    /* renamed from: a, reason: collision with root package name */
    private final long f16608a;

    /* renamed from: b, reason: collision with root package name */
    private long f16609b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16610c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f16611d;

    /* renamed from: d3.b$a */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (AbstractC0666b.this) {
                try {
                    if (!AbstractC0666b.this.f16610c) {
                        int i5 = message.what;
                        if (i5 == -1) {
                            AbstractC0666b.this.f16609b = SystemClock.elapsedRealtime() + AbstractC0666b.this.f16608a;
                        } else if (i5 == 1) {
                            long jElapsedRealtime = AbstractC0666b.this.f16609b - SystemClock.elapsedRealtime();
                            if (jElapsedRealtime <= 0) {
                                AbstractC0666b.this.f();
                                AbstractC0666b abstractC0666b = AbstractC0666b.this;
                                abstractC0666b.f16609b = (abstractC0666b.f16609b + AbstractC0666b.this.f16608a) - jElapsedRealtime;
                                sendMessageDelayed(obtainMessage(1), AbstractC0666b.this.f16608a);
                            } else if (jElapsedRealtime <= AbstractC0666b.this.f16608a) {
                                sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    public AbstractC0666b(long j5) {
        this(null, j5);
    }

    public synchronized void e() {
        this.f16610c = true;
        this.f16611d.removeMessages(1);
        this.f16611d.removeMessages(-1);
    }

    public abstract void f();

    public synchronized AbstractC0666b g() {
        this.f16610c = false;
        this.f16609b = SystemClock.elapsedRealtime() + this.f16608a;
        Handler handler = this.f16611d;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public AbstractC0666b(Looper looper, long j5) {
        this.f16610c = false;
        this.f16608a = j5;
        this.f16611d = new a(looper == null ? Looper.getMainLooper() : looper);
    }
}
