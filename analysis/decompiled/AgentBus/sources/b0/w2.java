package b0;

/* loaded from: classes.dex */
public final class w2 extends l0.x {

    /* renamed from: c, reason: collision with root package name */
    public Object f1392c;

    public w2(long j2, Object obj) {
        super(j2);
        this.f1392c = obj;
    }

    @Override // l0.x
    public final void a(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord<T of androidx.compose.runtime.SnapshotMutableStateImpl.StateStateRecord>");
        this.f1392c = ((w2) xVar).f1392c;
    }

    @Override // l0.x
    public final l0.x b(long j2) {
        return new w2(l0.m.k().g(), this.f1392c);
    }
}
