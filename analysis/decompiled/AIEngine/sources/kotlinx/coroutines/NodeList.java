package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListHead;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.Incomplete
    public NodeList getList() {
        return this;
    }
}
