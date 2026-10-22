package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1925a;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport b;
    public final /* synthetic */ String c;

    public /* synthetic */ g(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i) {
        this.f1925a = i;
        this.b = locationListenerTransport;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1925a) {
            case 0:
                this.b.lambda$onProviderEnabled$4(this.c);
                break;
            default:
                this.b.lambda$onProviderDisabled$5(this.c);
                break;
        }
    }
}
