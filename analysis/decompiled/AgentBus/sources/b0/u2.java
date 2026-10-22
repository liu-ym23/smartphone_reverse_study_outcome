package b0;

/* loaded from: classes.dex */
public final class u2 extends l0.x {

    /* renamed from: c, reason: collision with root package name */
    public int f1378c;

    public u2(long j2, int i2) {
        super(j2);
        this.f1378c = i2;
    }

    @Override // l0.x
    public final void a(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableIntStateImpl.IntStateStateRecord");
        this.f1378c = ((u2) xVar).f1378c;
    }

    @Override // l0.x
    public final l0.x b(long j2) {
        return new u2(j2, this.f1378c);
    }
}
