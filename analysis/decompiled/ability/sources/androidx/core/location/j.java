package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1928a;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport b;
    public final /* synthetic */ Executor c;

    public /* synthetic */ j(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i) {
        this.f1928a = i;
        this.b = preRGnssStatusTransport;
        this.c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1928a) {
            case 0:
                this.b.lambda$onStopped$1(this.c);
                break;
            default:
                this.b.lambda$onStarted$0(this.c);
                break;
        }
    }
}
