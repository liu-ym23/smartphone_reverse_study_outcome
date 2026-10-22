package r6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends q6.a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u f5145e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f5146f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(String str, u uVar, k kVar) {
        super(str, true);
        this.f5145e = uVar;
        this.f5146f = kVar;
    }

    @Override // q6.a
    public final long a() throws InterruptedException {
        t tVar;
        u uVar = this.f5145e;
        try {
            tVar = uVar.f();
        } catch (Throwable th) {
            tVar = new t(uVar, th, 2);
        }
        k kVar = this.f5146f;
        if (!kVar.f5150e.contains(uVar)) {
            return -1L;
        }
        kVar.f5151f.put(tVar);
        return -1L;
    }
}
