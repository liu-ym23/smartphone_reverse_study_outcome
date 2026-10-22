package androidx.work;

import ad.l;
import android.content.Context;
import g5.n;
import g5.r;
import g5.t;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ExecutorService;
import t2.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class Worker extends t {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        context.getClass();
        workerParameters.getClass();
    }

    @Override // g5.t
    public final m a() {
        ExecutorService executorService = this.f4339b.f1660a;
        executorService.getClass();
        l lVar = new l(this, 10);
        n nVar = new n(1);
        nVar.f4332b = executorService;
        nVar.f4333c = lVar;
        VarHandle.storeStoreFence();
        return t.n.i(nVar);
    }

    public abstract r b();
}
