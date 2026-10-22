package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.utils.Property;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public List<c> f5441a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private LocationManager f5442b = null;

    /* renamed from: c, reason: collision with root package name */
    private b f5443c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5444d = false;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static q f5445a = new q();
    }

    public class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            try {
                Iterator<c> it = q.this.f5441a.iterator();
                while (it.hasNext()) {
                    it.next().a(location);
                }
            } catch (Exception unused) {
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
        }
    }

    public interface c {
        void a(Location location);
    }

    public static q a() {
        return a.f5445a;
    }

    public void b() {
        LocationManager locationManager;
        b bVar = this.f5443c;
        if (bVar == null || (locationManager = this.f5442b) == null) {
            return;
        }
        locationManager.removeUpdates(bVar);
        this.f5443c = null;
    }

    public void a(Context context, Looper looper) {
        try {
            if (this.f5442b == null) {
                this.f5442b = (LocationManager) context.getSystemService(MapController.LOCATION_LAYER_TAG);
            }
            if (this.f5443c == null) {
                this.f5443c = new b();
            }
            LocationManager locationManager = this.f5442b;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            this.f5442b.requestLocationUpdates("network", 1000L, Property.DEFAULT_FLOAT_VALUE, this.f5443c, looper);
        } catch (Exception unused) {
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f5441a.remove(cVar);
        if (this.f5441a.size() == 0 && this.f5444d) {
            b();
            this.f5444d = false;
        }
    }

    public void a(c cVar, Context context, Looper looper) {
        if (cVar == null) {
            return;
        }
        if (!this.f5441a.contains(cVar)) {
            this.f5441a.add(cVar);
        }
        if (this.f5441a.size() != 1 || this.f5444d) {
            return;
        }
        a(context, looper);
        this.f5444d = true;
    }
}
