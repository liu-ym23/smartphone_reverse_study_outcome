package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LockFreeLinkedListNode f21627a;

    public v(LockFreeLinkedListNode r10) {
        this.f21627a = r10;
    }

    public String toString() {
        return "Removed[" + this.f21627a + ']';
    }
}
