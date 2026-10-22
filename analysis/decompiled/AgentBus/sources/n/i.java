package n;

import b0.b3;
import b0.o1;

/* loaded from: classes.dex */
public final class i implements b3 {

    /* renamed from: f, reason: collision with root package name */
    public final q6.b f6631f;

    /* renamed from: g, reason: collision with root package name */
    public final o1 f6632g;

    /* renamed from: h, reason: collision with root package name */
    public n f6633h;

    /* renamed from: i, reason: collision with root package name */
    public long f6634i;

    /* renamed from: j, reason: collision with root package name */
    public long f6635j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f6636k;

    public /* synthetic */ i(q6.b bVar, Comparable comparable, n nVar, int i2) {
        this(bVar, comparable, (i2 & 4) != 0 ? null : nVar, Long.MIN_VALUE, Long.MIN_VALUE, false);
    }

    @Override // b0.b3
    public final Object getValue() {
        return this.f6632g.getValue();
    }

    public final String toString() {
        return "AnimationState(value=" + this.f6632g.getValue() + ", velocity=" + ((p7.k) this.f6631f.f8787g).invoke(this.f6633h) + ", isRunning=" + this.f6636k + ", lastFrameTimeNanos=" + this.f6634i + ", finishedTimeNanos=" + this.f6635j + ')';
    }

    public i(q6.b bVar, Object obj, n nVar, long j2, long j4, boolean z4) {
        n nVarE;
        this.f6631f = bVar;
        this.f6632g = b0.b.n(obj);
        if (nVar != null) {
            nVarE = d.e(nVar);
        } else {
            nVarE = (n) ((p7.k) bVar.f8788h).invoke(obj);
            nVarE.d();
        }
        this.f6633h = nVarE;
        this.f6634i = j2;
        this.f6635j = j4;
        this.f6636k = z4;
    }
}
