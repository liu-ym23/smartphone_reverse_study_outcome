package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k1 extends y implements DisposableHandle, Incomplete {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JobSupport f21633d;

    public k1() {
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        p().b0(this);
    }

    @Override // kotlinx.coroutines.Incomplete
    public p1 getList() {
        return null;
    }

    @Override // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    public final JobSupport p() {
        JobSupport r10 = this.f21633d;
        if (r10 == null) goto L5;
        return r10;
    L5:
        kotlin.jvm.internal.q.y("job");
        return null;
    }

    public final void q(JobSupport r10) {
        this.f21633d = r10;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return e0.a(this) + '@' + e0.b(this) + "[job@" + e0.b(p()) + ']';
    }
}
