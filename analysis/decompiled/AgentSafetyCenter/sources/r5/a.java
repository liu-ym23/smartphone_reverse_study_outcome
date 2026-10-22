package r5;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10461c;

    /* renamed from: f, reason: collision with root package name */
    public Object f10462f;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f10461c) {
            case 0:
                ((Handler) ((i) this.f10462f).f9732g).post(runnable);
                break;
            default:
                ((ScheduledThreadPoolExecutor) this.f10462f).schedule(runnable, 0L, TimeUnit.NANOSECONDS);
                break;
        }
    }
}
