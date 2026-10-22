package androidx.lifecycle;

import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\u0005H\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "<init>", "()V", "paused", "", CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED, "isDraining", "queue", "Ljava/util/Queue;", "Ljava/lang/Runnable;", "pause", "", "resume", VideoEventOneOutSync.END_TYPE_FINISH, "drainQueue", "canRun", "dispatchAndEnqueue", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "runnable", "enqueue", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused;
    private final Queue<Runnable> queue;

    public static /* synthetic */ void a(DispatchQueue r100, Runnable r101) {
        dispatchAndEnqueue$lambda$2$lambda$1(r100, r101);
    }

    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    public final void pause() {
        this.paused = true;
    }

    public final boolean canRun() {
        if (this.finished == false) goto L5;
    L8:
        return true;
    L5:
        if (this.paused == false) goto L8;
        return false;
    }

    public final void drainQueue() {
        if (this.isDraining == false) goto L21;
        return;
    L21:
        this.isDraining = true;     // Catch: Throwable -> L18
    L8:
        if ((!this.queue.isEmpty()) == false) goto L16;
        if (canRun() == false) goto L16;
        Runnable r100 = this.queue.poll();     // Catch: Throwable -> L18
        if (r100 == null) goto L8;
        r100.run();     // Catch: Throwable -> L18
    L16:
        this.isDraining = false;
        return;
    L18:
        th = move-exception;
        this.isDraining = false;
        throw th;
    }

    public final void resume() {
        if (this.paused == true) goto L6;
        return;
    L6:
        if ((!this.finished) == false) goto L10;
        this.paused = false;
        drainQueue();
        return;
    L10:
        throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
    }

    public DispatchQueue() {
        this.paused = true;
        this.queue = new ArrayDeque();
    }

    private final void enqueue(Runnable r100) {
        if (this.queue.offer(r100) == false) goto L7;
        drainQueue();
        return;
    L7:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    private static final void dispatchAndEnqueue$lambda$2$lambda$1(DispatchQueue r100, Runnable r101) {
        r100.enqueue(r101);
    }

    public final void dispatchAndEnqueue(CoroutineContext r100, final Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "runnable");
        MainCoroutineDispatcher r102 = Dispatchers.getMain().getImmediate();
        if (r102.isDispatchNeeded(r100) == false) goto L5;
    L8:
        r102.dispatch(r100, new e(this, r101));
        return;
    L5:
        if (canRun() == true) goto L8;
        enqueue(r101);
    }
}
