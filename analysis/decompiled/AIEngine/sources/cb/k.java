package cb;

import com.tonyodev.fetch2.Download;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3365a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ya.f f3366b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f3367c;

    public /* synthetic */ k(ya.f fVar, Download download, int i10) {
        this.f3365a = i10;
        this.f3366b = fVar;
        this.f3367c = download;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3365a) {
            case 0:
                this.f3366b.onWaitingNetwork(this.f3367c);
                break;
            case 1:
                this.f3366b.onPaused(this.f3367c);
                break;
            case 2:
                this.f3366b.onDeleted(this.f3367c);
                break;
            case 3:
                this.f3366b.onResumed(this.f3367c);
                break;
            default:
                this.f3366b.onAdded(this.f3367c);
                break;
        }
    }
}
