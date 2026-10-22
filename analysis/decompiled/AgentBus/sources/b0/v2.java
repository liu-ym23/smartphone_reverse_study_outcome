package b0;

/* loaded from: classes.dex */
public final class v2 extends l0.x {

    /* renamed from: c, reason: collision with root package name */
    public long f1386c;

    public v2(long j2, long j4) {
        super(j2);
        this.f1386c = j4;
    }

    @Override // l0.x
    public final void a(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableLongStateImpl.LongStateStateRecord");
        this.f1386c = ((v2) xVar).f1386c;
    }

    @Override // l0.x
    public final l0.x b(long j2) {
        return new v2(j2, this.f1386c);
    }
}
