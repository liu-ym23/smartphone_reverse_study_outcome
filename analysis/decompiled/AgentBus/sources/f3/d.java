package f3;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3378f;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3378f) {
            case 0:
                runnable.run();
                break;
            default:
                i.a.S().f4389c.f4392d.execute(runnable);
                break;
        }
    }
}
