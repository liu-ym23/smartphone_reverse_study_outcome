package cb;

import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2core.Reason;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3380a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hb.d f3381b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Download f3382c;

    public /* synthetic */ p(hb.d dVar, Download download, int i10) {
        this.f3380a = i10;
        this.f3381b = dVar;
        this.f3382c = download;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f3380a;
        hb.d dVar = this.f3381b;
        switch (i10) {
            case 0:
                Reason reason = Reason.f8218a;
                dVar.a();
                break;
            case 1:
                Reason reason2 = Reason.f8218a;
                dVar.a();
                break;
            case 2:
                Reason reason3 = Reason.f8218a;
                dVar.a();
                break;
            default:
                Reason reason4 = Reason.f8218a;
                dVar.a();
                break;
        }
    }
}
