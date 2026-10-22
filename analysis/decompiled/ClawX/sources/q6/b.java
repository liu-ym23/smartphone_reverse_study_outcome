package q6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f4871e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p5.a f4872f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, p5.a aVar) {
        super(str, true);
        this.f4872f = aVar;
    }

    @Override // q6.a
    public final long a() {
        switch (this.f4871e) {
            case 0:
                this.f4872f.invoke();
                return -1L;
            default:
                return ((Number) this.f4872f.invoke()).longValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, boolean z, p5.a aVar) {
        super(str, z);
        this.f4872f = aVar;
    }
}
