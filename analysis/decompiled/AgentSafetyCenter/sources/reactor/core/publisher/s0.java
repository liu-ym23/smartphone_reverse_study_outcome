package reactor.core.publisher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10855c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ qd.e f10856f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ long f10857g;

    public /* synthetic */ s0(int i) {
        this.f10855c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10855c) {
            case 0:
                this.f10856f.request(this.f10857g);
                break;
            default:
                this.f10856f.request(this.f10857g);
                break;
        }
    }
}
