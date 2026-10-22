package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w0 extends x0 {

    /* renamed from: c, reason: collision with root package name */
    public final b2 f224c;

    public w0(long j4, b2 b2Var) {
        super(j4);
        this.f224c = b2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f224c.run();
    }

    @Override // a6.x0
    public final String toString() {
        return super.toString() + this.f224c;
    }
}
