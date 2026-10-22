package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 extends kotlinx.coroutines.internal.n implements Incomplete {
    public p1() {
    }

    @Override // kotlinx.coroutines.Incomplete
    public p1 getList() {
        return this;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return super.toString();
    }
}
