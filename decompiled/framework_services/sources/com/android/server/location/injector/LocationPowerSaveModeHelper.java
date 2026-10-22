package com.android.server.location.injector;

import android.os.PowerManager;
import android.util.Log;
import com.android.server.location.LocationManagerService;
import com.android.server.location.eventlog.LocationEventLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LocationPowerSaveModeHelper {
    private final CopyOnWriteArrayList<LocationPowerSaveModeChangedListener> mListeners;

    public interface LocationPowerSaveModeChangedListener {
        void onLocationPowerSaveModeChanged(int r1);
    }

    public abstract int getLocationPowerSaveMode();

    public LocationPowerSaveModeHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public final void addListener(LocationPowerSaveModeChangedListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(LocationPowerSaveModeChangedListener listener) {
        this.mListeners.remove(listener);
    }

    protected final void notifyLocationPowerSaveModeChanged(int locationPowerSaveMode) {
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "location power save mode is now " + PowerManager.locationPowerSaveModeToString(locationPowerSaveMode));
    L5:
        LocationEventLog.EVENT_LOG.logLocationPowerSaveMode(locationPowerSaveMode);
        Iterator<LocationPowerSaveModeChangedListener> r0 = this.mListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        LocationPowerSaveModeChangedListener listener = r0.next();
        listener.onLocationPowerSaveModeChanged(locationPowerSaveMode);
        goto L7
    }
}
