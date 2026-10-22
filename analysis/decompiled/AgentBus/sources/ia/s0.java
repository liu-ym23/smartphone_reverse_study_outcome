package ia;

/* loaded from: classes.dex */
public final class s0 extends u0 {

    /* renamed from: h, reason: collision with root package name */
    public final m f4999h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ w0 f5000i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(w0 w0Var, long j2, m mVar) {
        super(j2);
        this.f5000i = w0Var;
        this.f4999h = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4999h.D(this.f5000i);
    }

    @Override // ia.u0
    public final String toString() {
        return super.toString() + this.f4999h;
    }
}
