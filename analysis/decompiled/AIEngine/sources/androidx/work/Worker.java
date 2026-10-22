package androidx.work;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.work.c;
import h2.f;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Worker extends c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Worker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        g.f(context, "context");
        g.f(workerParams, "workerParams");
    }

    public abstract c.a.C0023c b();

    @Override // androidx.work.c
    public final c5.a<f> getForegroundInfoAsync() {
        Executor backgroundExecutor = getBackgroundExecutor();
        g.e(backgroundExecutor, "backgroundExecutor");
        return CallbackToFutureAdapter.a(new com.stepos.core.ota.downloader.b(backgroundExecutor, (zb.a) new zb.a<f>() { // from class: androidx.work.Worker.getForegroundInfoAsync.1
            {
                super(0);
            }

            @Override // zb.a
            public final f invoke() {
                Worker.this.getClass();
                throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for `getForegroundInfo()`");
            }
        }));
    }

    @Override // androidx.work.c
    public final c5.a<c.a> startWork() {
        Executor backgroundExecutor = getBackgroundExecutor();
        g.e(backgroundExecutor, "backgroundExecutor");
        return CallbackToFutureAdapter.a(new com.stepos.core.ota.downloader.b(backgroundExecutor, (zb.a) new zb.a<c.a>() { // from class: androidx.work.Worker.startWork.1
            {
                super(0);
            }

            @Override // zb.a
            public final c.a invoke() {
                return Worker.this.b();
            }
        }));
    }
}
