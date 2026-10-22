package dg;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f19204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f19205g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CoroutineScheduler f19206h;

    public e(int r10, int r11, long r12, String r13) {
        this.f19202d = r10;
        this.f19203e = r11;
        this.f19204f = r12;
        this.f19205g = r13;
        this.f19206h = e();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void a(CoroutineContext r10, Runnable r11) {
        CoroutineScheduler.g(this.f19206h, r11, null, false, 6, null);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void b(CoroutineContext r10, Runnable r11) {
        CoroutineScheduler.g(this.f19206h, r11, null, true, 2, null);
    }

    public final CoroutineScheduler e() {
        return new CoroutineScheduler(this.f19202d, this.f19203e, this.f19204f, this.f19205g);
    }

    public final void f(Runnable r10, TaskContext r11, boolean r12) {
        this.f19206h.f(r10, r11, r12);
    }
}
