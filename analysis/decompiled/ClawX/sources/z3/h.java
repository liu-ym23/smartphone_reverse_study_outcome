package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends n4.c {

    /* renamed from: a, reason: collision with root package name */
    public final k4.g f6444a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6445b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6446c;

    public h(k4.g gVar, Object obj) {
        this.f6446c = obj;
        if (gVar == null) {
            k4.g gVar2 = k4.d.f3601a;
            gVar = k4.d.f3602b;
        }
        this.f6444a = gVar;
        this.f6445b = ((byte[]) obj).length;
    }

    @Override // n4.e
    public final Long a() {
        return Long.valueOf(this.f6445b);
    }

    @Override // n4.e
    public final k4.g b() {
        return this.f6444a;
    }

    @Override // n4.c
    public final byte[] d() {
        return (byte[]) this.f6446c;
    }
}
