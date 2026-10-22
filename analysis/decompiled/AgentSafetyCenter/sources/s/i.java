package s;

import k0.r2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements r2 {

    /* renamed from: c, reason: collision with root package name */
    public final n6.a f11020c;

    /* renamed from: f, reason: collision with root package name */
    public final k0.k1 f11021f;

    /* renamed from: g, reason: collision with root package name */
    public n f11022g;

    /* renamed from: h, reason: collision with root package name */
    public long f11023h;
    public long i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11024j;

    /* JADX WARN: Type inference failed for: r2v2, types: [xb.l, yb.l] */
    public i(n6.a aVar, Object obj, n nVar, long j10, long j11, boolean z10) {
        n nVarH;
        this.f11020c = aVar;
        this.f11021f = k0.z.v(obj);
        if (nVar != null) {
            nVarH = d.h(nVar);
        } else {
            nVarH = (n) ((yb.l) aVar.f8776c).invoke(obj);
            nVarH.d();
        }
        this.f11022g = nVarH;
        this.f11023h = j10;
        this.i = j11;
        this.f11024j = z10;
    }

    @Override // k0.r2
    public final Object getValue() {
        return this.f11021f.getValue();
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [xb.l, yb.l] */
    public final String toString() {
        return "AnimationState(value=" + this.f11021f.getValue() + ", velocity=" + ((yb.l) this.f11020c.f8777f).invoke(this.f11022g) + ", isRunning=" + this.f11024j + ", lastFrameTimeNanos=" + this.f11023h + ", finishedTimeNanos=" + this.i + ')';
    }

    public /* synthetic */ i(n6.a aVar, Object obj, n nVar, int i) {
        this(aVar, obj, (i & 4) != 0 ? null : nVar, Long.MIN_VALUE, Long.MIN_VALUE, false);
    }
}
