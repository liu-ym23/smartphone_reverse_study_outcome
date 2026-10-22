package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.d;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class LocationManagerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final WeakHashMap<a, WeakReference<LocationListenerTransport>> f1243a = null;

    private static final class CancellableLocationListener implements LocationListener {
        private androidx.core.util.a<Location> mConsumer;
        private final Executor mExecutor;
        private final LocationManager mLocationManager;
        private final Handler mTimeoutHandler;
        Runnable mTimeoutRunnable;
        private boolean mTriggered;

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
        }

        CancellableLocationListener(LocationManager r3, Executor r4, androidx.core.util.a<Location> r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            androidx.core.util.a<Location> r7 = (androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r5, androidx.core.util.a.class, "com.obric.aiagent.plugin");
            this.mLocationManager = r3;
            this.mExecutor = r6;
            this.mTimeoutHandler = new Handler(Looper.getMainLooper());
            this.mConsumer = r7;
        }

        public void cancel() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            cleanup();
        }

        public void startTimeout(long r3) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        L7:
            Runnable r0 = new $$Lambda$LocationManagerCompat$CancellableLocationListener$t_KfxTHtM_iJ8uJYVqEknYPfeGQ(this);     // Catch: Throwable -> L10
            this.mTimeoutRunnable = r0;     // Catch: Throwable -> L10
            this.mTimeoutHandler.postDelayed(r0, r3);     // Catch: Throwable -> L10
            monitor-exit(this);     // Catch: Throwable -> L10
        }

        public /* synthetic */ void lambda$startTimeout$0$LocationManagerCompat$CancellableLocationListener() {
            this.mTimeoutRunnable = null;
            onLocationChanged((Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r3) {
            onLocationChanged((Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r4) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mTriggered == false) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.mTriggered = true;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            final androidx.core.util.a<Location> r0 = this.mConsumer;
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$CancellableLocationListener$3ZULwbbK50Cps1Fq3NjhzVs6lfs(r0, r4));
            cleanup();
        }

        static /* synthetic */ void lambda$onLocationChanged$1(androidx.core.util.a r2, Location r3) {
            ((androidx.core.util.a) ZeusTransformUtils.wrapperContextForParams(r2, androidx.core.util.a.class, "com.obric.aiagent.plugin")).accept(r3);
        }

        private void cleanup() {
            this.mConsumer = null;
            INVOKEVIRTUAL_androidx_core_location_LocationManagerCompat$CancellableLocationListener_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(this.mLocationManager, this);
            Runnable r1 = this.mTimeoutRunnable;
            if (r1 == null) goto L6;
            this.mTimeoutHandler.removeCallbacks(r1);
            this.mTimeoutRunnable = null;
            return;
        }

        public static void INVOKEVIRTUAL_androidx_core_location_LocationManagerCompat$CancellableLocationListener_com_obric_performance_power_monitor_gps_LocationLancet_removeUpdates(LocationManager r2, LocationListener r3) {
            LocationListener r4 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r3, LocationListener.class, "com.obric.aiagent.plugin");
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r2.removeUpdates(r4);
            return;
        L6:
            r2.removeUpdates(r4);
            com.obric.performance.power.monitor.g.a.c(r4.hashCode());
        }
    }

    private static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {
        final GnssMeasurementsEvent.Callback mCallback;
        volatile Executor mExecutor;

        GnssMeasurementsTransport(GnssMeasurementsEvent.Callback r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            this.mCallback = r3;
            this.mExecutor = r5;
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(final GnssMeasurementsEvent r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$GnssMeasurementsTransport$iLdMFvSQqE3vx6WxeoBOCcjw4k(this, r0, r3));
        }

        public /* synthetic */ void lambda$onGnssMeasurementsReceived$0$LocationManagerCompat$GnssMeasurementsTransport(Executor r3, GnssMeasurementsEvent r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onGnssMeasurementsReceived(r4);
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$GnssMeasurementsTransport$GFF3lbHvLRJjzms5Rdrtz0gScAc(this, r0, r3));
        }

        public /* synthetic */ void lambda$onStatusChanged$1$LocationManagerCompat$GnssMeasurementsTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.onStatusChanged(r4);
        }
    }

    private static class GnssStatusTransport extends GnssStatus.Callback {
        final androidx.core.location.a.AbstractC0030a mCallback;

        GnssStatusTransport(androidx.core.location.a.AbstractC0030a r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            g.a(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.mCallback.a();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.mCallback.b();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int r1) {
            this.mCallback.a(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r1) {
            this.mCallback.a(androidx.core.location.a.a(r1));
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {
        final androidx.core.location.a.AbstractC0030a mCallback;
        volatile Executor mExecutor;
        private final LocationManager mLocationManager;

        GpsStatusTransport(LocationManager r3, androidx.core.location.a.AbstractC0030a r4) {
            if (r4 == null) goto L5;
            boolean r0 = true;
        L6:
            g.a(r0, "invalid null callback");
            this.mLocationManager = r3;
            this.mCallback = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void register(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor != null) goto L5;
            boolean r0 = true;
        L6:
            g.b(r0);
            this.mExecutor = r4;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r4) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r4 != 1) goto L8;
            r0.execute(new $$Lambda$LocationManagerCompat$GpsStatusTransport$YdTHlyzRR62cUonlTLG1CDPrghk(this, r0));
            return;
        L8:
            if (r4 != 2) goto L10;
            r0.execute(new $$Lambda$LocationManagerCompat$GpsStatusTransport$o4is_vEFQnCFL3phcwhrVAcNx6o(this, r0));
            return;
        L10:
            if (r4 != 3) goto L12;
            GpsStatus r5 = this.mLocationManager.getGpsStatus(null);
            if (r5 == null) goto L25;
            final int r6 = r5.getTimeToFirstFix();
            r0.execute(new $$Lambda$LocationManagerCompat$GpsStatusTransport$T0auuLwzEMM99veZUbxskDo10s(this, r0, r6));
            return;
        L25:
            return;
        L12:
            if (r4 != 4) goto L28;
            GpsStatus r7 = this.mLocationManager.getGpsStatus(null);
            if (r7 == null) goto L23;
            final androidx.core.location.a r8 = androidx.core.location.a.a(r7);
            r0.execute(new $$Lambda$LocationManagerCompat$GpsStatusTransport$5LQtx9KQJVgBGFLVGIv7mR63U68(this, r0, r8));
            return;
        L23:
            return;
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$0$LocationManagerCompat$GpsStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.a();
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$1$LocationManagerCompat$GpsStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.b();
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$2$LocationManagerCompat$GpsStatusTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.a(r4);
        }

        public /* synthetic */ void lambda$onGpsStatusChanged$3$LocationManagerCompat$GpsStatusTransport(Executor r3, androidx.core.location.a r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.a(r4);
        }
    }

    private static class LocationListenerTransport implements LocationListener {
        final Executor mExecutor;
        volatile a mKey;

        LocationListenerTransport(a r3, Executor r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            this.mKey = r3;
            this.mExecutor = r5;
        }

        public a getKey() {
            return (a) ZeusTransformUtils.preCheckCast(d.a(this.mKey), a.class, "com.obric.aiagent.plugin");
        }

        public void unregister() {
            this.mKey = null;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$nQA1ES9Z0HoQZ4k2kiq64G5J1Hw(this, r3));
        }

        public /* synthetic */ void lambda$onLocationChanged$0$LocationManagerCompat$LocationListenerTransport(Location r1) {
            a r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.f1245b.onLocationChanged(r1);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(List<Location> r3) {
            final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$MhoeUnGkDr3ot8_83pxTiAeIweg(this, r4));
        }

        public /* synthetic */ void lambda$onLocationChanged$1$LocationManagerCompat$LocationListenerTransport(List r3) {
            List<Location> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            a r2 = this.mKey;
            if (r2 != null) goto L5;
            return;
        L5:
            r2.f1245b.onLocationChanged(r4);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$e6SckAVOXLz5sqdYaQciymznw4(this, r3));
        }

        public /* synthetic */ void lambda$onFlushComplete$2$LocationManagerCompat$LocationListenerTransport(int r1) {
            a r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.f1245b.onFlushComplete(r1);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String r3, final int r4, final Bundle r5) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$DPle4JPT7thJs_1Mhy2Ne8V4No(this, r3, r4, r5));
        }

        public /* synthetic */ void lambda$onStatusChanged$3$LocationManagerCompat$LocationListenerTransport(String r1, int r2, Bundle r3) {
            a r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.f1245b.onStatusChanged(r1, r2, r3);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$B1gsSTxy0V0GwE3O1urJcFM1Nw(this, r3));
        }

        public /* synthetic */ void lambda$onProviderEnabled$4$LocationManagerCompat$LocationListenerTransport(String r1) {
            a r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.f1245b.onProviderEnabled(r1);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String r3) {
            if (this.mKey != null) goto L5;
            return;
        L5:
            this.mExecutor.execute(new $$Lambda$LocationManagerCompat$LocationListenerTransport$lsVZkfjeu_iNJq_Fu3P9SKpwa6w(this, r3));
        }

        public /* synthetic */ void lambda$onProviderDisabled$5$LocationManagerCompat$LocationListenerTransport(String r1) {
            a r0 = this.mKey;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.f1245b.onProviderDisabled(r1);
        }
    }

    private static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final androidx.core.location.a.AbstractC0030a mCallback;
        volatile Executor mExecutor;

        PreRGnssStatusTransport(androidx.core.location.a.AbstractC0030a r3) {
            if (r3 == null) goto L5;
            boolean r0 = true;
        L6:
            g.a(r0, "invalid null callback");
            this.mCallback = r3;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void register(Executor r5) {
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
            boolean r0 = true;
            if (r6 == null) goto L5;
            boolean r2 = true;
        L6:
            g.a(r2, "invalid null executor");
            if (this.mExecutor == null) goto L10;
            r0 = false;
        L10:
            g.b(r0);
            this.mExecutor = r6;
            return;
        L5:
            r2 = false;
            goto L6
        }

        public void unregister() {
            this.mExecutor = null;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$W1WiagGzlSlFoo8c3Qd6urjz2M(this, r0));
        }

        public /* synthetic */ void lambda$onStarted$0$LocationManagerCompat$PreRGnssStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.a();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$EV3ALfMBDotS9TFPL4C05K2QFGM(this, r0));
        }

        public /* synthetic */ void lambda$onStopped$1$LocationManagerCompat$PreRGnssStatusTransport(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r4) goto L5;
            return;
        L5:
            this.mCallback.b();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$UrmG531cBaBG_MqEWQ130Gx_xM(this, r0, r3));
        }

        public /* synthetic */ void lambda$onFirstFix$2$LocationManagerCompat$PreRGnssStatusTransport(Executor r3, int r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.a(r4);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus r3) {
            final Executor r0 = this.mExecutor;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.execute(new $$Lambda$LocationManagerCompat$PreRGnssStatusTransport$M98hBYbLkP_lHaBu4FbOg7TdZV0(this, r0, r3));
        }

        public /* synthetic */ void lambda$onSatelliteStatusChanged$3$LocationManagerCompat$PreRGnssStatusTransport(Executor r3, GnssStatus r4) {
            Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            if (this.mExecutor == r5) goto L5;
            return;
        L5:
            this.mCallback.a(androidx.core.location.a.a(r4));
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final LocationListenerCompat f1245b;

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L5;
            return false;
        L5:
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            if (this.f1244a.equals(r5.f1244a) == true) goto L8;
            return false;
        L8:
            if (this.f1245b.equals(r5.f1245b) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return d.a(new Object[]{this.f1244a, this.f1245b});
        }
    }

    static {
        f1243a = new WeakHashMap();
    }
}
