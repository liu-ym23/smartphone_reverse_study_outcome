package kotlinx.coroutines.flow.internal;

import lb.n;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class AbstractSharedFlowSlot<F> {
    public abstract boolean allocateLocked(F f8);

    public abstract b<n>[] freeLocked(F f8);
}
