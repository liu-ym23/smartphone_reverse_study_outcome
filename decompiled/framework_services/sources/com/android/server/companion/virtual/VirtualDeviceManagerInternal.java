package com.android.server.companion.virtual;

import android.companion.virtual.IVirtualDevice;
import android.companion.virtual.VirtualDevice;
import android.companion.virtual.VirtualDeviceManager;
import android.companion.virtual.VirtualDeviceParams;
import android.companion.virtual.sensor.VirtualSensor;
import android.hardware.display.IVirtualDisplayCallback;
import android.os.LocaleList;
import android.util.ArraySet;
import android.window.DisplayWindowPolicyController;
import java.util.Set;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualDeviceManagerInternal {

    public interface AppsOnVirtualDeviceListener {
        void onAppsOnAnyVirtualDeviceChanged(Set<Integer> r1);
    }

    public abstract VirtualDeviceManager.VirtualDevice createVirtualDevice(VirtualDeviceParams r1);

    public abstract Set<String> getAllPersistentDeviceIds();

    public abstract int getBaseVirtualDisplayFlags(IVirtualDevice r1);

    public abstract int getDeviceIdForDisplayId(int r1);

    public abstract ArraySet<Integer> getDeviceIdsForUid(int r1);

    public abstract int getDeviceOwnerUid(int r1);

    public abstract long getDimDurationMillisForDeviceId(int r1);

    public abstract ArraySet<Integer> getDisplayIdsForDevice(int r1);

    public abstract String getPersistentIdForDevice(int r1);

    public abstract LocaleList getPreferredLocaleListForUid(int r1);

    public abstract long getScreenOffTimeoutMillisForDeviceId(int r1);

    public abstract VirtualDevice getVirtualDevice(int r1);

    public abstract VirtualSensor getVirtualSensor(int r1, int r2);

    public abstract boolean isAppRunningOnAnyVirtualDevice(int r1);

    public abstract boolean isInputDeviceOwnedByVirtualDevice(int r1);

    public abstract boolean isValidVirtualDeviceId(int r1);

    public abstract void onAppsOnVirtualDeviceChanged();

    public abstract void onAuthenticationPrompt(int r1);

    public abstract void onPersistentDeviceIdsRemoved(Set<String> r1);

    public abstract void onVirtualDisplayCreated(IVirtualDevice r1, int r2, IVirtualDisplayCallback r3, DisplayWindowPolicyController r4);

    public abstract void onVirtualDisplayRemoved(IVirtualDevice r1, int r2);

    public abstract void registerAppsOnVirtualDeviceListener(AppsOnVirtualDeviceListener r1);

    public abstract void registerPersistentDeviceIdRemovedListener(Consumer<String> r1);

    public abstract void unregisterAppsOnVirtualDeviceListener(AppsOnVirtualDeviceListener r1);

    public abstract void unregisterPersistentDeviceIdRemovedListener(Consumer<String> r1);

    public VirtualDeviceManagerInternal() {
    }
}
