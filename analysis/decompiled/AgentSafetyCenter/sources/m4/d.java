package m4;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8216c;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f8216c) {
            case 0:
                runnable.run();
                break;
            default:
                n.a.W().f8611c.f8615d.execute(runnable);
                break;
        }
    }
}
