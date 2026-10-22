package com.android.server.location.injector;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeviceIdleHelper {
    private final CopyOnWriteArrayList<DeviceIdleListener> mListeners;

    public interface DeviceIdleListener {
        void onDeviceIdleChanged(boolean r1);
    }

    public abstract boolean isDeviceIdle();

    protected abstract void registerInternal();

    protected abstract void unregisterInternal();

    protected DeviceIdleHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public final synchronized void addListener(DeviceIdleListener listener) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mListeners.add(listener) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mListeners.size() != 1) goto L11;
        registerInternal();     // Catch: Throwable -> L9
        goto L11
    }

    public final synchronized void removeListener(DeviceIdleListener listener) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mListeners.remove(listener) == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mListeners.isEmpty() == false) goto L11;
        unregisterInternal();     // Catch: Throwable -> L9
        goto L11
    }

    protected final void notifyDeviceIdleChanged() {
        boolean deviceIdle = isDeviceIdle();
        Iterator<DeviceIdleListener> r1 = this.mListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        DeviceIdleListener listener = r1.next();
        listener.onDeviceIdleChanged(deviceIdle);
        goto L4
    }
}
