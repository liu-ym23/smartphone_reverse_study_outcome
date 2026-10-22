package z;

import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lz/j;", "Ljava/util/concurrent/Executor;", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "Ljava/lang/Runnable;", "command", "LY8/t;", "execute", "(Ljava/lang/Runnable;)V", Const.INTENT_KEY_APIKEY, "Landroid/os/Handler;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j implements Executor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    public j(Handler handler) {
        kotlin.jvm.internal.p.i(handler, "handler");
        this.handler = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        kotlin.jvm.internal.p.i(command, "command");
        if (this.handler.post(command)) {
            return;
        }
        throw new RejectedExecutionException(this.handler + " is shutting down");
    }
}
