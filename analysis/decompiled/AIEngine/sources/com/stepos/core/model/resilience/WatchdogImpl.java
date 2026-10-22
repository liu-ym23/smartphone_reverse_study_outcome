package com.stepos.core.model.resilience;

import android.util.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WatchdogImpl implements IWatchdog {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Watchdog";
    private final CoroutineScope scope;
    private final AtomicLong totalCancelled;
    private final AtomicLong totalTimeouts;
    private final AtomicLong totalWatched;
    private final ConcurrentHashMap<String, Job> watchJobs;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WatchdogImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.core.model.resilience.IWatchdog
    public void cancel(String taskId) {
        g.f(taskId, "taskId");
        Job jobRemove = this.watchJobs.remove(taskId);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, null, 1, null);
            this.totalCancelled.incrementAndGet();
            Log.d(TAG, "Cancelled watch: ".concat(taskId));
        }
    }

    @Override // com.stepos.core.model.resilience.IWatchdog
    public void cancelAll() {
        int size = this.watchJobs.size();
        Collection<Job> collectionValues = this.watchJobs.values();
        g.e(collectionValues, "<get-values>(...)");
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), null, 1, null);
        }
        this.watchJobs.clear();
        this.totalCancelled.addAndGet(size);
        Log.i(TAG, "Cancelled all watches: " + size);
    }

    public final WatchdogStatistics getStatistics() {
        return new WatchdogStatistics(this.watchJobs.size(), this.totalWatched.get(), this.totalTimeouts.get(), this.totalCancelled.get());
    }

    public final void shutdown() {
        cancelAll();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    @Override // com.stepos.core.model.resilience.IWatchdog
    public void watch(String taskId, long j10, a<n> onTimeout) {
        g.f(taskId, "taskId");
        g.f(onTimeout, "onTimeout");
        Job jobRemove = this.watchJobs.remove(taskId);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, null, 1, null);
        }
        this.totalWatched.incrementAndGet();
        Log.d(TAG, "Watching task: " + taskId + ", timeout=" + j10 + "ms");
        this.watchJobs.put(taskId, BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new WatchdogImpl$watch$job$1(j10, taskId, this, onTimeout, null), 3, null));
    }

    @Override // com.stepos.core.model.resilience.IWatchdog
    public int watchingCount() {
        return this.watchJobs.size();
    }

    public WatchdogImpl(CoroutineScope scope) {
        g.f(scope, "scope");
        this.scope = scope;
        this.watchJobs = new ConcurrentHashMap<>();
        this.totalWatched = new AtomicLong(0L);
        this.totalTimeouts = new AtomicLong(0L);
        this.totalCancelled = new AtomicLong(0L);
    }

    public /* synthetic */ WatchdogImpl(CoroutineScope coroutineScope, int i10, e eVar) {
        this((i10 & 1) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null))) : coroutineScope);
    }
}
