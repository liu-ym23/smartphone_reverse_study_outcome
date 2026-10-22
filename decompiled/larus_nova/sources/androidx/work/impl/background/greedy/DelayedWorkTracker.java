package androidx.work.impl.background.greedy;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class DelayedWorkTracker {
    static final String TAG = null;
    final GreedyScheduler mGreedyScheduler;
    private final RunnableScheduler mRunnableScheduler;
    private final Map<String, Runnable> mRunnables;

    static {
        TAG = Logger.tagWithPrefix("DelayedWorkTracker");
    }

    public void schedule(final WorkSpec r100) {
        Runnable r101 = this.mRunnables.remove(r100.f15686id);
        if (r101 == null) goto L5;
        this.mRunnableScheduler.cancel(r101);
    L5:
        Runnable r102 = new AnonymousClass1(this, r100);
        this.mRunnables.put(r100.f15686id, r102);
        long r103 = System.currentTimeMillis();
        long r104 = r100.calculateNextRunTime() - r103;
        this.mRunnableScheduler.scheduleWithDelay(r104, r102);
    }

    public void unschedule(String r100) {
        Runnable r101 = this.mRunnables.remove(r100);
        if (r101 == null) goto L6;
        this.mRunnableScheduler.cancel(r101);
        return;
    }

    public DelayedWorkTracker(GreedyScheduler r100, RunnableScheduler r101) {
        this.mGreedyScheduler = r100;
        this.mRunnableScheduler = r101;
        this.mRunnables = new HashMap();
    }
}
