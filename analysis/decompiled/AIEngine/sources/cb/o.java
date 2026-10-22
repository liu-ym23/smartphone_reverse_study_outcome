package cb;

import com.tonyodev.fetch2.Download;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3377a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ya.f f3378b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f3379c;

    public /* synthetic */ o(ya.f fVar, Download download, int i10) {
        this.f3377a = i10;
        this.f3378b = fVar;
        this.f3379c = download;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3377a) {
            case 0:
                this.f3378b.onCompleted(this.f3379c);
                break;
            default:
                this.f3378b.onCancelled(this.f3379c);
                break;
        }
    }
}
