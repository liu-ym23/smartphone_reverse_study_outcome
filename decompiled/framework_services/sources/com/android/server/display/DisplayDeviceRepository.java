package com.android.server.display;

import android.os.Trace;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.Surface;
import com.android.server.SysOptBridge;
import com.android.server.display.utils.DebugUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class DisplayDeviceRepository implements DisplayAdapter.Listener {
    private static final boolean DEBUG = false;
    public static final int DISPLAY_DEVICE_EVENT_ADDED = 1;
    public static final int DISPLAY_DEVICE_EVENT_REMOVED = 3;
    private static final String TAG = "DisplayDeviceRepository";
    private final List<DisplayDevice> mDisplayDevices;
    private final List<Listener> mListeners;
    private final PersistentDataStore mPersistentDataStore;
    private final DisplayManagerService.SyncRoot mSyncRoot;

    public interface Listener {
        void onDisplayDeviceChangedLocked(DisplayDevice r1, int r2);

        void onDisplayDeviceEventLocked(DisplayDevice r1, int r2);

        void onTraversalRequested();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    DisplayDeviceRepository(DisplayManagerService.SyncRoot syncRoot, PersistentDataStore persistentDataStore) {
        this.mDisplayDevices = new ArrayList();
        this.mListeners = new ArrayList();
        this.mSyncRoot = syncRoot;
        this.mPersistentDataStore = persistentDataStore;
    }

    public void addListener(Listener listener) {
        this.mListeners.add(listener);
    }

    @Override // com.android.server.display.DisplayAdapter.Listener
    public void onDisplayDeviceEvent(DisplayDevice device, int event) {
        String tag = null;
        if (DEBUG == false) goto L5;
        tag = "DisplayDeviceRepository#onDisplayDeviceEvent (event=" + event + ")";
        Trace.beginAsyncSection(tag, 0);
    L5:
        switch(event) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            default: goto L11;
        };
    L7:
        handleDisplayDeviceRemoved(device);
        goto L11
    L8:
        handleDisplayDeviceChanged(device);
        goto L11
    L9:
        handleDisplayDeviceAdded(device);
    L11:
        if (DEBUG == false) goto L14;
        Trace.endAsyncSection(tag, 0);
        return;
    }

    @Override // com.android.server.display.DisplayAdapter.Listener
    public void onTraversalRequested() {
        int size = this.mListeners.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        this.mListeners.get(i).onTraversalRequested();
        i = i + 1;
        goto L3
    }

    public boolean containsLocked(DisplayDevice d) {
        return this.mDisplayDevices.contains(d);
    }

    public int sizeLocked() {
        return this.mDisplayDevices.size();
    }

    public void forEachLocked(Consumer<DisplayDevice> consumer) {
        int count = this.mDisplayDevices.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        consumer.accept(this.mDisplayDevices.get(i));
        i = i + 1;
        goto L3
    }

    public DisplayDevice getByAddressLocked(DisplayAddress address) {
        int i = this.mDisplayDevices.size() - 1;
    L3:
        if (i < 0) goto L11;
        DisplayDevice device = this.mDisplayDevices.get(i);
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();
        if (address.equals(info.address) == true) goto L10;
        if (DisplayAddress.Physical.isPortMatch(address, info.address) == true) goto L10;
        i = i - 1;
    L10:
        return device;
    L11:
        return null;
    }

    public DisplayDevice getByUniqueIdLocked(String uniqueId) {
        int i = this.mDisplayDevices.size() - 1;
    L3:
        if (i < 0) goto L8;
        DisplayDevice displayDevice = this.mDisplayDevices.get(i);
        if (displayDevice.getUniqueId().equals(uniqueId) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return displayDevice;
    L8:
        return null;
    }

    private void handleDisplayDeviceAdded(DisplayDevice device) {
        DisplayManagerService.SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();     // Catch: Throwable -> L9
        if (this.mDisplayDevices.contains(device) == false) goto L11;
        Slog.w(TAG, "Attempted to add already added display device: " + info);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.i(TAG, "Display device added: " + info);     // Catch: Throwable -> L9
        device.mDebugLastLoggedDeviceInfo = info;     // Catch: Throwable -> L9
        this.mDisplayDevices.add(device);     // Catch: Throwable -> L9
        sendEventLocked(device, 1);     // Catch: Throwable -> L9
        if (info == null) goto L14;
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyDisplayEvent(info.ownerPackageName, info.ownerUid, info.name, info.type, true);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void handleDisplayDeviceChanged(DisplayDevice device) {
        DisplayManagerService.SyncRoot r0 = this.mSyncRoot;
        monitor-enter(r0);
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();     // Catch: Throwable -> L9
        if (this.mDisplayDevices.contains(device) == true) goto L12;
        Slog.w(TAG, "Attempted to change non-existent display device: " + info);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (DEBUG == false) goto L14;
        Trace.traceBegin(131072, "handleDisplayDeviceChanged");     // Catch: Throwable -> L9
    L14:
        int diff = device.mDebugLastLoggedDeviceInfo.diff(info);     // Catch: Throwable -> L9
        if (diff != 0) goto L18;
        Slog.i(TAG, "Display device same: " + info);     // Catch: Throwable -> L9
    L35:
        if ((diff & 8) != 0) goto L49;
    L41:
        device.mDebugLastLoggedDeviceInfo = info;     // Catch: Throwable -> L9
        device.applyPendingDisplayDeviceInfoChangesLocked();     // Catch: Throwable -> L9
        sendChangedEventLocked(device, diff);     // Catch: Throwable -> L9
        if (DEBUG == false) goto L44;
        Trace.traceEnd(131072);     // Catch: Throwable -> L9
    L44:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L49:
        this.mPersistentDataStore.setColorMode(device, info.colorMode);     // Catch: Throwable -> L38
        this.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L9
        goto L41
    L38:
        th = move-exception;
        this.mPersistentDataStore.saveIfNeeded();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L18:
        if (diff != 2) goto L21;
        Slog.i(TAG, "Display device changed state: \"" + info.name + "\", " + Display.stateToString(info.state));     // Catch: Throwable -> L9
        goto L35
    L21:
        if (diff != 32) goto L24;
        Slog.i(TAG, "Display device rotated: \"" + info.name + "\", " + Surface.rotationToString(info.rotation));     // Catch: Throwable -> L9
        goto L35
    L24:
        if ((diff & 448) == 0) goto L27;
        Slog.i(TAG, "Display device changed render timings: \"" + info.name + "\", renderFrameRate=" + info.renderFrameRate + ", presentationDeadlineNanos=" + info.presentationDeadlineNanos + ", appVsyncOffsetNanos=" + info.appVsyncOffsetNanos + ", frameRateOverrides=" + Arrays.toString(info.frameRateOverrides));     // Catch: Throwable -> L9
        goto L35
    L27:
        if (diff != 4) goto L32;
        if (DEBUG == false) goto L35;
        Slog.i(TAG, "Display device changed committed state: \"" + info.name + "\", " + Display.stateToString(info.committedState));     // Catch: Throwable -> L9
        goto L35
    L32:
        if (diff == 16) goto L35;
        Slog.i(TAG, "Display device changed: " + info);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void handleDisplayDeviceRemoved(DisplayDevice device) {
        DisplayManagerService.SyncRoot r1 = this.mSyncRoot;
        monitor-enter(r1);
        DisplayDeviceInfo info = device.getDisplayDeviceInfoLocked();     // Catch: Throwable -> L9
        if (this.mDisplayDevices.remove(device) == true) goto L11;
        Slog.w(TAG, "Attempted to remove non-existent display device: " + info);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        Slog.i(TAG, "Display device removed: " + info);     // Catch: Throwable -> L9
        device.mDebugLastLoggedDeviceInfo = info;     // Catch: Throwable -> L9
        sendEventLocked(device, 3);     // Catch: Throwable -> L9
        if (info == null) goto L14;
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().notifyDisplayEvent(info.ownerPackageName, info.ownerUid, info.name, info.type, false);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void sendEventLocked(DisplayDevice device, int event) {
        int size = this.mListeners.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        this.mListeners.get(i).onDisplayDeviceEventLocked(device, event);
        i = i + 1;
        goto L3
    }

    private void sendChangedEventLocked(DisplayDevice device, int diff) {
        int size = this.mListeners.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        this.mListeners.get(i).onDisplayDeviceChangedLocked(device, diff);
        i = i + 1;
        goto L3
    }
}
