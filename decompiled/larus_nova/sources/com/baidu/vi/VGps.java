package com.baidu.vi;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.camera.video.AudioStats;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import fna.g;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public class VGps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f33573a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f33574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GpsStatus.Listener f33575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LocationListener f33576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LocationManager f33577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GpsStatus f33578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f33579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f33580h;

    public class a implements GpsStatus.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VGps f33581a;

        public a(VGps r100) {
            this.f33581a = r100;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r110) {
            if (r110 != 2) goto L5;
            this.f33581a.updateGps(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0f, 0.0f, 0.0f, 0);
            return;
        L5:
            if (r110 == 4) goto L8;
            return;
        L8:
            if (VGps.a(this.f33581a) != null) goto L10;
        L13:
            Iterator<GpsSatellite> r111 = VGps.b(this.f33581a).getSatellites().iterator();
            int r100 = 0;
        L15:
            if (r111.hasNext() == false) goto L20;
            if (r111.next().usedInFix() == false) goto L15;
            r100 = r100 + 1;
            goto L15
        L20:
            if (r100 < VGps.a()) goto L22;
        L24:
            VGps.a(this.f33581a, r100);
            return;
        L22:
            if (VGps.c(this.f33581a) < VGps.a()) goto L24;
            VGps.d(this.f33581a);
            goto L24
        L10:
            if (VGps.b(this.f33581a) != null) goto L12;
            VGps r112 = this.f33581a;
            VGps.a(r112, VGps.a(r112).getGpsStatus(null));
            goto L13
        L12:
            VGps.a(this.f33581a).getGpsStatus(VGps.b(this.f33581a));
            goto L13
        }
    }

    public class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ VGps f33582a;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r100) {
        }

        public b(VGps r100) {
            this.f33582a = r100;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r210) {
            ArrayList r100 = new ArrayList();
            Object[] r110 = {r210};
            f06.b r111 = new f06.b();
            g06.a r101 = ApiHookConfig.f245611b.get(100038);
            if (r101 == null) goto L5;
            f06.a[] r102 = r101.f479473i;
        L6:
            f06.a[] r103 = r102;
            int r104 = r103.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r103[r105];
            int r112 = r105;
            int r113 = r104;
            f06.a[] r114 = r103;
            d r107 = r106.preInvoke(100038, "com/baidu/vi/VGps$b", "onLocationChanged", this, r110, "void", r111);     // Catch: Exception -> L29
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L29
        L17:
            if (r107.f474982a == false) goto L19;
            return;
        L19:
            if (r210 != null) goto L21;
            return;
        L21:
            if (r210.hasAccuracy() == false) goto L23;
            float r115 = r210.getAccuracy();
        L25:
            if (VGps.c(this.f33582a) < VGps.a()) goto L27;
            this.f33582a.updateGps(r210.getLongitude(), r210.getLatitude(), (float) (((double) r210.getSpeed()) * 3.6d), r210.getBearing(), r115, VGps.c(this.f33582a));
            return;
        L27:
            VGps.d(this.f33582a);
            return;
        L23:
            r115 = 0.0f;
        L14:
            r105 = r112 + 1;
            r104 = r113;
            r103 = r114;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r102 = ApiHookConfig.f245613d;
            goto L6
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r110) {
            this.f33582a.updateGps(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0f, 0.0f, 0.0f, 0);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r110, int r111, Bundle r112) {
            if (r111 != 0) goto L4;
        L6:
            this.f33582a.updateGps(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0f, 0.0f, 0.0f, 0);
            return;
        L4:
            if (r111 == 1) goto L6;
        }
    }

    public static class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message r110) {
            VGps r100 = (VGps) r110.obj;
            if (r100 != null) goto L5;
            return;
        L5:
            int r111 = r110.what;
            if (r111 == 1) goto L19;
            if (r111 == 2) goto L16;
            if (r111 == 3) goto L13;
            return;
        L13:
            if (VGps.a(r100) == null) goto L22;
            VGps.a(r100).removeGpsStatusListener(VGps.e(r100));
            INVOKEVIRTUAL_com_baidu_vi_VGps$c_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(VGps.a(r100), VGps.f(r100));
            return;
        L22:
            return;
        L16:
            if (VIContext.getContext() == null) goto L24;
            VGps.a(r100, (LocationManager) VIContext.getContext().getSystemService("location"));
            com_baidu_vi_VGps$c_android_location_LocationManager_addGpsStatusListener(VGps.a(r100), VGps.e(r100));
            return;
        L24:
            return;
        L19:
            if (VGps.c(r100) >= VGps.a()) goto L26;
            r100.updateGps(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 0.0f, 0.0f, 0.0f, 0);
            return;
        }

        public static void INVOKEVIRTUAL_com_baidu_vi_VGps$c_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(LocationManager r100, LocationListener r101) {
            if (g.d() == true) goto L6;
            r100.removeUpdates(r101);
            return;
        L6:
            r100.removeUpdates(r101);
            nna.a.a(r101.hashCode());
        }

        private static boolean com_baidu_vi_VGps$c_android_location_LocationManager_addGpsStatusListener(LocationManager r110, GpsStatus.Listener r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b();
            g06.a r102 = ApiHookConfig.f245611b.get(100005);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(100005, "android/location/LocationManager", "addGpsStatusListener", r110, r101, "boolean", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Boolean) r107.f474983b).booleanValue();
        L21:
            return r110.addGpsStatusListener(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    private synchronized void b() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f33574b.hasMessages(1) == true) goto L6;
        Message r100 = f33574b.obtainMessage(1, this);     // Catch: Throwable -> L8
        f33574b.sendMessageDelayed(r100, 3000);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public native void updateGps(double r100, double r101, float r102, float r103, float r104, int r105);

    static {
        f33574b = new c();
    }

    public boolean init() {
        f33574b.removeMessages(2);
        Handler r100 = f33574b;
        r100.sendMessage(r100.obtainMessage(2, this));
        return true;
    }

    public boolean unInit() {
        f33574b.removeMessages(1);
        f33574b.removeMessages(3);
        Handler r100 = f33574b;
        r100.sendMessage(r100.obtainMessage(3, this));
        return true;
    }

    public VGps() {
        this.f33575c = new a(this);
        this.f33576d = new b(this);
        this.f33577e = null;
        this.f33578f = null;
        this.f33579g = 0;
        this.f33580h = 0;
    }

    public static /* synthetic */ int a() {
        return f33573a;
    }

    public int getGpsSatellitesNum() {
        return this.f33579g;
    }

    public static /* synthetic */ LocationManager a(VGps r100) {
        return r100.f33577e;
    }

    public static /* synthetic */ GpsStatus b(VGps r100) {
        return r100.f33578f;
    }

    public static /* synthetic */ int c(VGps r100) {
        return r100.f33579g;
    }

    public static /* synthetic */ void d(VGps r100) {
        r100.b();
    }

    public static /* synthetic */ GpsStatus.Listener e(VGps r100) {
        return r100.f33575c;
    }

    public static /* synthetic */ LocationListener f(VGps r100) {
        return r100.f33576d;
    }

    public static /* synthetic */ int a(VGps r100, int r101) {
        r100.f33579g = r101;
        return r101;
    }

    public static /* synthetic */ GpsStatus a(VGps r100, GpsStatus r101) {
        r100.f33578f = r101;
        return r101;
    }

    public static /* synthetic */ LocationManager a(VGps r100, LocationManager r101) {
        r100.f33577e = r101;
        return r101;
    }
}
