package com.baidu.vi;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.utils.Property;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VGps {

    /* renamed from: a, reason: collision with root package name */
    private static int f9484a = 3;

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private static Handler f9485b = new c();

    /* renamed from: c, reason: collision with root package name */
    private GpsStatus.Listener f9486c = new a();

    /* renamed from: d, reason: collision with root package name */
    private LocationListener f9487d = new b();

    /* renamed from: e, reason: collision with root package name */
    private LocationManager f9488e = null;

    /* renamed from: f, reason: collision with root package name */
    private GpsStatus f9489f = null;

    /* renamed from: g, reason: collision with root package name */
    private int f9490g = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f9491h = 0;

    public class a implements GpsStatus.Listener {
        public a() {
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i4) {
            if (i4 == 2) {
                VGps.this.updateGps(0.0d, 0.0d, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                return;
            }
            if (i4 != 4) {
                return;
            }
            if (VGps.this.f9488e != null) {
                if (VGps.this.f9489f == null) {
                    VGps vGps = VGps.this;
                    vGps.f9489f = vGps.f9488e.getGpsStatus(null);
                } else {
                    VGps.this.f9488e.getGpsStatus(VGps.this.f9489f);
                }
            }
            Iterator<GpsSatellite> it = VGps.this.f9489f.getSatellites().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                if (it.next().usedInFix()) {
                    i5++;
                }
            }
            if (i5 < VGps.f9484a && VGps.this.f9490g >= VGps.f9484a) {
                VGps.this.b();
            }
            VGps.this.f9490g = i5;
        }
    }

    public class b implements LocationListener {
        public b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                float accuracy = location.hasAccuracy() ? location.getAccuracy() : Property.DEFAULT_FLOAT_VALUE;
                if (VGps.this.f9490g >= VGps.f9484a) {
                    VGps.this.updateGps(location.getLongitude(), location.getLatitude(), (float) (location.getSpeed() * 3.6d), location.getBearing(), accuracy, VGps.this.f9490g);
                } else {
                    VGps.this.b();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            VGps.this.updateGps(0.0d, 0.0d, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
            if (i4 == 0 || i4 == 1) {
                VGps.this.updateGps(0.0d, 0.0d, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
            }
        }
    }

    public static class c extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VGps vGps = (VGps) message.obj;
            if (vGps == null) {
                return;
            }
            int i4 = message.what;
            if (i4 == 1) {
                if (vGps.f9490g < VGps.f9484a) {
                    vGps.updateGps(0.0d, 0.0d, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                }
            } else {
                if (i4 == 2) {
                    if (VIContext.getContext() != null) {
                        vGps.f9488e = (LocationManager) VIContext.getContext().getSystemService(MapController.LOCATION_LAYER_TAG);
                        vGps.f9488e.addGpsStatusListener(vGps.f9486c);
                        return;
                    }
                    return;
                }
                if (i4 == 3 && vGps.f9488e != null) {
                    vGps.f9488e.removeGpsStatusListener(vGps.f9486c);
                    vGps.f9488e.removeUpdates(vGps.f9487d);
                }
            }
        }
    }

    public int getGpsSatellitesNum() {
        return this.f9490g;
    }

    public boolean init() {
        f9485b.removeMessages(2);
        Handler handler = f9485b;
        handler.sendMessage(handler.obtainMessage(2, this));
        return true;
    }

    public boolean unInit() {
        f9485b.removeMessages(1);
        f9485b.removeMessages(3);
        Handler handler = f9485b;
        handler.sendMessage(handler.obtainMessage(3, this));
        return true;
    }

    public native void updateGps(double d4, double d5, float f4, float f5, float f6, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (!f9485b.hasMessages(1)) {
            f9485b.sendMessageDelayed(f9485b.obtainMessage(1, this), VehicleBluetoothManager.MIN_CONNECT_DISTANCE);
        }
    }
}
