package dg;

import kotlinx.coroutines.e0;
import kotlinx.coroutines.scheduling.TaskContext;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f19210c;

    public i(Runnable r10, long r11, TaskContext r12) {
        super(r11, r12);
        this.f19210c = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19210c.run();     // Catch: Throwable -> L5
        this.f19208b.afterTask();
        return;
    L5:
        th = move-exception;
        this.f19208b.afterTask();
        throw th;
    }

    public String toString() {
        return "Task[" + e0.a(this.f19210c) + '@' + e0.b(this.f19210c) + ", " + this.f19207a + ", " + this.f19208b + ']';
    }
}
