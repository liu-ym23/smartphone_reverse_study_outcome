package U5;

import android.util.Log;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1274a;

    public /* synthetic */ b(int i) {
        this.f1274a = i;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        switch (this.f1274a) {
            case 0:
                Log.e("ScheduledExecutor", "Exceeded ThreadPoolExecutor pool size");
                break;
            default:
                W5.c.b("V3OfflineEmitter", "Task exceeds maximum limit");
                break;
        }
    }
}
