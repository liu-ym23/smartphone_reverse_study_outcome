package kotlinx.coroutines.flow.internal;

import b6.c;
import kotlin.coroutines.d;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SafeCollector_commonKt {
    public static final void checkContext(SafeCollector<?> safeCollector, d dVar) {
        if (((Number) dVar.fold(0, new c(safeCollector, 5))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + dVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int checkContext$lambda$0(SafeCollector safeCollector, int i10, d.a aVar) {
        d.b<?> key = aVar.getKey();
        d.a aVar2 = safeCollector.collectContext.get(key);
        if (key != Job.Key) {
            if (aVar != aVar2) {
                return Integer.MIN_VALUE;
            }
            return i10 + 1;
        }
        Job job = (Job) aVar2;
        Job jobTransitiveCoroutineParent = transitiveCoroutineParent((Job) aVar, job);
        if (jobTransitiveCoroutineParent == job) {
            return job == null ? i10 : i10 + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + jobTransitiveCoroutineParent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public static final Job transitiveCoroutineParent(Job job, Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof ScopeCoroutine)) {
                return job;
            }
            job = ((ScopeCoroutine) job).getParent();
        }
        return null;
    }
}
