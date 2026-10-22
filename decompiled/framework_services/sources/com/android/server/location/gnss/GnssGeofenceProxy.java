package com.android.server.location.gnss;

import android.location.IGpsGeofenceHardware;
import android.util.SparseArray;
import com.android.server.location.gnss.hal.GnssNative;

/* JADX INFO: loaded from: classes2.dex */
class GnssGeofenceProxy extends IGpsGeofenceHardware.Stub implements GnssNative.BaseCallbacks {
    private final SparseArray<GeofenceEntry> mGeofenceEntries;
    private final GnssNative mGnssNative;
    private final Object mLock;

    private static class GeofenceEntry {
        public int geofenceId;
        public int lastTransition;
        public double latitude;
        public double longitude;
        public int monitorTransitions;
        public int notificationResponsiveness;
        public boolean paused;
        public double radius;
        public int unknownTimer;

        /* synthetic */ GeofenceEntry(GnssGeofenceProxyIA r1) {
            this();
        }

        private GeofenceEntry() {
        }
    }

    GnssGeofenceProxy(GnssNative gnssNative) {
        this.mLock = new Object();
        this.mGeofenceEntries = new SparseArray();
        this.mGnssNative = gnssNative;
        this.mGnssNative.addBaseCallbacks(this);
    }

    public boolean isHardwareGeofenceSupported() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mGnssNative.isGeofencingSupported();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean addCircularHardwareGeofence(int geofenceId, double latitude, double longitude, double radius, int lastTransition, int monitorTransitions, int notificationResponsiveness, int unknownTimer) {
        Object r14 = this.mLock;
        monitor-enter(r14);
        boolean added = this.mGnssNative.addGeofence(geofenceId, latitude, longitude, radius, lastTransition, monitorTransitions, notificationResponsiveness, unknownTimer);     // Catch: Throwable -> L23
        if (added == false) goto L40;
        GeofenceEntry entry = new GeofenceEntry(null);     // Catch: Throwable -> L37
        entry.geofenceId = geofenceId;     // Catch: Throwable -> L37
        entry.latitude = latitude;     // Catch: Throwable -> L35
        entry.longitude = longitude;     // Catch: Throwable -> L33
        entry.radius = radius;     // Catch: Throwable -> L31
        entry.lastTransition = lastTransition;     // Catch: Throwable -> L29
        entry.monitorTransitions = monitorTransitions;     // Catch: Throwable -> L27
        entry.notificationResponsiveness = notificationResponsiveness;     // Catch: Throwable -> L25
        entry.unknownTimer = unknownTimer;     // Catch: Throwable -> L23
        this.mGeofenceEntries.put(geofenceId, entry);     // Catch: Throwable -> L23
    L25:
        th = th;
    L44:
        monitor-exit(r14);     // Catch: Throwable -> L23
        throw th;
    L27:
        th = th;
    L29:
        th = th;
    L31:
        th = th;
    L33:
        th = th;
    L35:
        th = th;
    L37:
        th = th;
    L40:
        monitor-exit(r14);     // Catch: Throwable -> L23
        return added;
    L23:
        th = th;
    L42:
        th = th;
        goto L44
    }

    public boolean removeHardwareGeofence(int geofenceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean removed = this.mGnssNative.removeGeofence(geofenceId);     // Catch: Throwable -> L7
        if (removed == false) goto L9;
        this.mGeofenceEntries.remove(geofenceId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return removed;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean pauseHardwareGeofence(int geofenceId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean paused = this.mGnssNative.pauseGeofence(geofenceId);     // Catch: Throwable -> L9
        if (paused == false) goto L11;
        GeofenceEntry entry = this.mGeofenceEntries.get(geofenceId);     // Catch: Throwable -> L9
        if (entry == null) goto L11;
        entry.paused = true;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return paused;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean resumeHardwareGeofence(int geofenceId, int monitorTransitions) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean resumed = this.mGnssNative.resumeGeofence(geofenceId, monitorTransitions);     // Catch: Throwable -> L9
        if (resumed == false) goto L11;
        GeofenceEntry entry = this.mGeofenceEntries.get(geofenceId);     // Catch: Throwable -> L9
        if (entry == null) goto L11;
        entry.paused = false;     // Catch: Throwable -> L9
        entry.monitorTransitions = monitorTransitions;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return resumed;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.gnss.hal.GnssNative.BaseCallbacks
    public void onHalRestarted() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L20:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mGeofenceEntries.size()) goto L16;
        GeofenceEntry entry = this.mGeofenceEntries.valueAt(i);     // Catch: Throwable -> L12
        boolean added = this.mGnssNative.addGeofence(entry.geofenceId, entry.latitude, entry.longitude, entry.radius, entry.lastTransition, entry.monitorTransitions, entry.notificationResponsiveness, entry.unknownTimer);     // Catch: Throwable -> L12
        if (added == false) goto L14;
        if (entry.paused == false) goto L14;
        this.mGnssNative.pauseGeofence(entry.geofenceId);     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L20
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L12
    }
}
