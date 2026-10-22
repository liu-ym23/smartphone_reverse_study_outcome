package com.android.server.timezonedetector;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.IndentingPrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class DeviceActivityMonitorImpl implements DeviceActivityMonitor {
    private static final boolean DBG = false;
    private static final String LOG_TAG = "time_zone_detector";
    private final List<DeviceActivityMonitor.Listener> mListeners;

    /* JADX INFO: renamed from: -$$Nest$mnotifyFlightComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8591$$Nest$mnotifyFlightComplete(DeviceActivityMonitorImpl r0) {
        r0.notifyFlightComplete();
    }

    static DeviceActivityMonitor create(Context context, Handler handler) {
        return new DeviceActivityMonitorImpl(context, handler);
    }

    private DeviceActivityMonitorImpl(Context context, final Handler handler) {
        this.mListeners = new ArrayList();
        final ContentResolver contentResolver = context.getContentResolver();
        ContentObserver airplaneModeObserver = new AnonymousClass1(this, handler, contentResolver);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("airplane_mode_on"), true, airplaneModeObserver);
    }

    @Override // com.android.server.timezonedetector.DeviceActivityMonitor
    public synchronized void addListener(DeviceActivityMonitor.Listener listener) {
        monitor-enter(this);
        listener.getClass();     // Catch: Throwable -> L6
        this.mListeners.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void notifyFlightComplete() {
        monitor-enter(this);
        List<DeviceActivityMonitor.Listener> listeners = new ArrayList(this.mListeners);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        Iterator<DeviceActivityMonitor.Listener> r1 = listeners.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        DeviceActivityMonitor.Listener listener = r1.next();
        listener.onFlightComplete();
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public void dump(IndentingPrintWriter pw, String[] args) {
    }
}
