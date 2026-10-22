package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import java.util.List;

/* loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1921a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(int i, Object obj, Object obj2) {
        this.f1921a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1921a) {
            case 0:
                ((Consumer) this.b).accept((Location) this.c);
                break;
            case 1:
                ((LocationManagerCompat.LocationListenerTransport) this.b).lambda$onLocationChanged$1((List) this.c);
                break;
            default:
                ((LocationManagerCompat.LocationListenerTransport) this.b).lambda$onLocationChanged$0((Location) this.c);
                break;
        }
    }
}
