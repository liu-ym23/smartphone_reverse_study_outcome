package ie;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class i0 implements Executor {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6000c;

    /* renamed from: f, reason: collision with root package name */
    public Handler f6001f;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f6000c) {
            case 0:
                this.f6001f.post(runnable);
                return;
            default:
                Handler handler = this.f6001f;
                runnable.getClass();
                if (handler.post(runnable)) {
                    return;
                }
                throw new RejectedExecutionException(handler + " is shutting down");
        }
    }
}
