package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    default void onFlushComplete(int r10) {
    }

    @Override // android.location.LocationListener
    default void onLocationChanged(@NonNull List<Location> r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        onLocationChanged(r10.get(r12));
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.location.LocationListener
    default void onProviderDisabled(@NonNull String r10) {
    }

    @Override // android.location.LocationListener
    default void onProviderEnabled(@NonNull String r10) {
    }

    @Override // android.location.LocationListener
    default void onStatusChanged(@NonNull String r10, int r11, @Nullable Bundle r12) {
    }
}
