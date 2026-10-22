package d0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: c, reason: collision with root package name */
    public final Object f1759c;

    public c() {
        super(12);
        this.f1759c = new Object();
    }

    @Override // d0.b
    public final Object a() {
        Object objA;
        synchronized (this.f1759c) {
            objA = super.a();
        }
        return objA;
    }

    @Override // d0.b
    public final boolean c(Object obj) {
        boolean zC;
        synchronized (this.f1759c) {
            zC = super.c(obj);
        }
        return zC;
    }
}
