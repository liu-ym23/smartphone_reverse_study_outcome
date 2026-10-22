package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public final class r1 implements DisposableHandle, ChildHandle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r1 f21672a = null;

    static {
        f21672a = new r1();
    }

    public r1() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public boolean childCancelled(Throwable r10) {
        return false;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
    }

    @Override // kotlinx.coroutines.ChildHandle
    public Job getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
