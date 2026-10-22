package com.android.server.location.geofence;

import android.os.IBinder;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GeofenceProxy$GeofenceProxyServiceConnection$$ExternalSyntheticLambda0 implements ServiceWatcher.BinderOperation {
    public final /* synthetic */ GeofenceProxy f$0;

    public /* synthetic */ GeofenceProxy$GeofenceProxyServiceConnection$$ExternalSyntheticLambda0(GeofenceProxy r1) {
        this.f$0 = r1;
    }

    public final void run(IBinder r2) {
        this.f$0.updateGeofenceHardware(r2);
    }
}
