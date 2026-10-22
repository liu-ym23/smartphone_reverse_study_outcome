package com.stepos.agentframework.display;

import Y8.t;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import h8.C4148a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001c\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/display/k;", "", "<init>", "()V", "Lcom/stepos/agentframework/display/k$a;", "tick", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "e", "(Lcom/stepos/agentframework/display/k$a;)Ljava/lang/AutoCloseable;", "LY8/t;", "f", "(Lcom/stepos/agentframework/display/k$a;)V", "", "TAG", "Ljava/lang/String;", "", "FRAME_INTERVAL_MS", "J", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "ticks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "running", "Z", "com/stepos/agentframework/display/k$c", "beat", "Lcom/stepos/agentframework/display/k$c;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class k {
    public static final long FRAME_INTERVAL_MS = 33;
    private static final String TAG = "WaitFrameClock";
    private static volatile boolean running;
    public static final k INSTANCE = new k();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final CopyOnWriteArrayList<a> ticks = new CopyOnWriteArrayList<>();
    private static final c beat = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/display/k$a;", "", "", "nowMs", "LY8/t;", Const.INTENT_KEY_APIKEY, "(J)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(long nowMs);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/display/k$b;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lcom/stepos/agentframework/display/k$a;", "tick", "<init>", "(Lcom/stepos/agentframework/display/k$a;)V", "LY8/t;", "close", "()V", "Lcom/stepos/agentframework/display/k$a;", "", AlipayXuiIsland.REASON_CLOSED, "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AutoCloseable {
        private volatile boolean closed;
        private final a tick;

        public b(a tick) {
            p.i(tick, "tick");
            this.tick = tick;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            k.INSTANCE.f(this.tick);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/display/k$c", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            Object objB;
            if (k.ticks.isEmpty()) {
                k.running = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            Iterator it = k.ticks.iterator();
            p.h(it, "iterator(...)");
            while (it.hasNext()) {
                a aVar = (a) it.next();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    aVar.a(jUptimeMillis);
                    objB = Result.b(t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(k.TAG, "wait frame tick failed", thE, false, 8, null);
                }
            }
            k.handler.postDelayed(this, 33L);
        }
    }

    public final AutoCloseable e(a tick) {
        p.i(tick, "tick");
        ticks.addIfAbsent(tick);
        if (!running) {
            running = true;
            handler.postDelayed(beat, 33L);
        }
        return new b(tick);
    }

    public final void f(a tick) {
        ticks.remove(tick);
    }
}
