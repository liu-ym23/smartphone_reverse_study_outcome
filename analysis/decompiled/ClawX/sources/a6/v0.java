package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v0 extends x0 {

    /* renamed from: c, reason: collision with root package name */
    public final m f223c;
    public final /* synthetic */ z0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(z0 z0Var, long j4, m mVar) {
        super(j4);
        this.d = z0Var;
        this.f223c = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws o0 {
        this.f223c.C(this.d);
    }

    @Override // a6.x0
    public final String toString() {
        return super.toString() + this.f223c;
    }
}
