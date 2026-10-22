package b0;

/* loaded from: classes.dex */
public final class t2 extends l0.x {

    /* renamed from: c, reason: collision with root package name */
    public float f1375c;

    public t2(float f10, long j2) {
        super(j2);
        this.f1375c = f10;
    }

    @Override // l0.x
    public final void a(l0.x xVar) {
        q7.k.c(xVar, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.f1375c = ((t2) xVar).f1375c;
    }

    @Override // l0.x
    public final l0.x b(long j2) {
        return new t2(this.f1375c, j2);
    }
}
