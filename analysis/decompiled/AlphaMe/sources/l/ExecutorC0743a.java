package l;

import java.util.concurrent.Executor;

/* renamed from: l.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ExecutorC0743a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13412a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f13412a) {
            case 1:
                C0744b.g0().f13415i.f13419j.execute(runnable);
                break;
            case 2:
                runnable.run();
                break;
            case 3:
                runnable.run();
                break;
            case 4:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
