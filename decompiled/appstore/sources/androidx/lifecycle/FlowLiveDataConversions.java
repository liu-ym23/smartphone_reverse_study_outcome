package androidx.lifecycle;

import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes.dex */
public abstract class FlowLiveDataConversions {
    public static final Flow a(LiveData r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return kotlinx.coroutines.flow.c.k(kotlinx.coroutines.flow.c.e(new FlowLiveDataConversions$asFlow$1(r10, null)));
    }
}
