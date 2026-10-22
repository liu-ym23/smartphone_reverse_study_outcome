package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public interface LocationListenerCompat extends LocationListener {

    /* JADX INFO: renamed from: androidx.core.location.LocationListenerCompat$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFlushComplete(LocationListenerCompat r100, int r101) {
        }

        public static void $default$onProviderDisabled(LocationListenerCompat r100, String r101) {
        }

        public static void $default$onProviderEnabled(LocationListenerCompat r100, String r101) {
        }

        public static void $default$onStatusChanged(LocationListenerCompat r100, String r101, int r102, Bundle r103) {
        }

        public static void $default$onLocationChanged(LocationListenerCompat r110, List r210) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r210};
            f06.b r111 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(100038);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r112 = r103;
            int r104 = r112.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r112[r105];
            int r113 = r105;
            int r114 = r104;
            f06.a[] r115 = r112;
            f06.d r107 = r106.preInvoke(100038, "androidx/core/location/LocationListenerCompat", "onLocationChanged", r110, r101, "void", r111);     // Catch: Exception -> L23
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L23
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            int r108 = r210.size();
            int r116 = 0;
        L20:
            if (r116 >= r108) goto L22;
            r110.onLocationChanged((Location) ListProtector.get(r210, r116));
            r116 = r116 + 1;
            goto L20
        L22:
            return;
        L14:
            r105 = r113 + 1;
            r104 = r114;
            r112 = r115;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    @Override // android.location.LocationListener
    void onFlushComplete(int r100);

    @Override // android.location.LocationListener
    void onLocationChanged(List<Location> r100);

    @Override // android.location.LocationListener
    void onProviderDisabled(String r100);

    @Override // android.location.LocationListener
    void onProviderEnabled(String r100);

    @Override // android.location.LocationListener
    void onStatusChanged(String r100, int r101, Bundle r102);
}
