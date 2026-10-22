package reactor.core.publisher;

/* loaded from: classes4.dex */
public final /* synthetic */ class S implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5890a;
    public final /* synthetic */ Z9.e b;
    public final /* synthetic */ long c;

    public /* synthetic */ S(Z9.e eVar, long j5, int i) {
        this.f5890a = i;
        this.b = eVar;
        this.c = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5890a) {
            case 0:
                this.b.request(this.c);
                break;
            default:
                this.b.request(this.c);
                break;
        }
    }
}
