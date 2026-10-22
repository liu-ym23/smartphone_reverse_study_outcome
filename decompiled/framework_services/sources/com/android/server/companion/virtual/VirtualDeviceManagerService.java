package com.android.server.companion.virtual;

import android.R;
import android.app.compat.CompatChanges;
import android.companion.AssociationInfo;
import android.companion.CompanionDeviceManager;
import android.companion.virtual.IVirtualDevice;
import android.companion.virtual.IVirtualDeviceActivityListener;
import android.companion.virtual.IVirtualDeviceListener;
import android.companion.virtual.IVirtualDeviceManager;
import android.companion.virtual.IVirtualDeviceSoundEffectListener;
import android.companion.virtual.VirtualDevice;
import android.companion.virtual.VirtualDeviceManager;
import android.companion.virtual.VirtualDeviceParams;
import android.companion.virtual.sensor.VirtualSensor;
import android.companion.virtualnative.IVirtualDeviceManagerNative;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.IVirtualDisplayCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.ExceptionUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.window.DisplayWindowPolicyController;
import com.android.internal.util.DumpUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.audio.AudioService$$ExternalSyntheticLambda2;
import com.android.server.wm.ActivityInterceptorCallback;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class VirtualDeviceManagerService extends SystemService {
    static final int CDM_ASSOCIATION_ID_NONE = 0;
    public static final long ENABLE_DEFAULT_DEVICE_CAMERA_ACCESS = 371173368;
    private static final String TAG = "VirtualDeviceManagerService";
    private static final List<String> VIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES = null;
    private static final String VIRTUAL_DEVICE_NATIVE_SERVICE = "virtualdevice_native";
    private static AtomicInteger sNextUniqueIndex;
    private ArrayMap<String, AssociationInfo> mActiveAssociations;
    private final ActivityInterceptorCallback mActivityInterceptorCallback;
    private final SparseArray<ArraySet<Integer>> mAppsOnVirtualDevices;
    private final Handler mHandler;
    private final VirtualDeviceManagerImpl mImpl;
    private final VirtualDeviceManagerInternal mLocalService;
    private final VirtualDeviceManagerNativeImpl mNativeImpl;
    private final PendingTrampolineMap mPendingTrampolines;
    private StrongAuthTracker mStrongAuthTracker;
    private final RemoteCallbackList<IVirtualDeviceListener> mVirtualDeviceListeners;
    private final VirtualDeviceLog mVirtualDeviceLog;
    private final Object mVirtualDeviceManagerLock;
    private final SparseArray<VirtualDeviceImpl> mVirtualDevices;

    private final class LocalService extends VirtualDeviceManagerInternal {
        private final ArraySet<Integer> mAllUidsOnVirtualDevice;
        private final ArrayList<VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener> mAppsOnVirtualDeviceListeners;
        private final ArrayList<Consumer<String>> mPersistentDeviceIdRemovedListeners;
        final /* synthetic */ VirtualDeviceManagerService this$0;

        public static /* synthetic */ void $r8$lambda$dLbsHCcOP2jvmO_2g7pPBOBlGVk(Set r0, List r1) {
            lambda$onPersistentDeviceIdsRemoved$1(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$lHk1NfYFJ0c29J3Uo8tHcIoOyDk(VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener[] r0, ArraySet r1) {
            lambda$onAppsOnVirtualDeviceChanged$0(r0, r1);
        }

        /* synthetic */ LocalService(VirtualDeviceManagerService r1, VirtualDeviceManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(VirtualDeviceManagerService r1) {
            this.this$0 = r1;
            this.mAppsOnVirtualDeviceListeners = new ArrayList();
            this.mPersistentDeviceIdRemovedListeners = new ArrayList();
            this.mAllUidsOnVirtualDevice = new ArraySet();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public VirtualDeviceManager.VirtualDevice createVirtualDevice(VirtualDeviceParams params) {
            params.getClass();
            params.getName().getClass();
            IVirtualDevice virtualDevice = VirtualDeviceManagerImpl.m3033$$Nest$mcreateVirtualDevice(VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0), new Binder(), this.this$0.getContext().getAttributionSource(), null, params, null, null);
            return new VirtualDeviceManager.VirtualDevice(this.this$0.getContext(), virtualDevice);
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public int getDeviceOwnerUid(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L7;
            return -1;
        L7:
            return virtualDevice.getOwnerUid();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public VirtualSensor getVirtualSensor(int deviceId, int handle) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L7;
            return null;
        L7:
            return virtualDevice.getVirtualSensorByHandle(handle);
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public ArraySet<Integer> getDeviceIdsForUid(int uid) {
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            ArraySet<Integer> result = new ArraySet();
            int i = 0;
        L4:
            if (i >= virtualDevicesSnapshot.size()) goto L10;
            VirtualDeviceImpl device = virtualDevicesSnapshot.get(i);
            if (device.isAppRunningOnVirtualDevice(uid) == false) goto L8;
            result.add(Integer.valueOf(device.getDeviceId()));
        L8:
            i = i + 1;
            goto L4
        L10:
            return result;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void onVirtualDisplayCreated(IVirtualDevice virtualDevice, int displayId, IVirtualDisplayCallback callback, DisplayWindowPolicyController dwpc) {
            VirtualDeviceImpl virtualDeviceImpl = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, ((VirtualDeviceImpl) virtualDevice).getDeviceId());
            if (virtualDeviceImpl == null) goto L6;
            virtualDeviceImpl.onVirtualDisplayCreated(displayId, callback, dwpc);
            return;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void onVirtualDisplayRemoved(IVirtualDevice virtualDevice, int displayId) {
            VirtualDeviceImpl virtualDeviceImpl = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, ((VirtualDeviceImpl) virtualDevice).getDeviceId());
            if (virtualDeviceImpl == null) goto L6;
            virtualDeviceImpl.onVirtualDisplayRemoved(displayId);
            return;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void onAppsOnVirtualDeviceChanged() {
            final ArraySet<Integer> latestRunningUids = new ArraySet();
            Object r1 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r1);
            int size = VirtualDeviceManagerService.m3019$$Nest$fgetmAppsOnVirtualDevices(this.this$0).size();     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= size) goto L10;
            latestRunningUids.addAll((ArraySet) VirtualDeviceManagerService.m3019$$Nest$fgetmAppsOnVirtualDevices(this.this$0).valueAt(i));     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            if (this.mAllUidsOnVirtualDevice.equals(latestRunningUids) == true) goto L12;
            this.mAllUidsOnVirtualDevice.clear();     // Catch: Throwable -> L7
            this.mAllUidsOnVirtualDevice.addAll(latestRunningUids);     // Catch: Throwable -> L7
            final VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener[] listeners = (VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener[]) this.mAppsOnVirtualDeviceListeners.toArray(new VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener[0]);     // Catch: Throwable -> L7
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (listeners == null) goto L22;
            VirtualDeviceManagerService.m3020$$Nest$fgetmHandler(this.this$0).post(new VirtualDeviceManagerService$LocalService$$ExternalSyntheticLambda0(listeners, latestRunningUids));
            return;
        L22:
            return;
        L12:
            listeners = null;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onAppsOnVirtualDeviceChanged$0(VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener[] listeners, ArraySet latestRunningUids) {
            int r0 = listeners.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener listener = listeners[r1];
            listener.onAppsOnAnyVirtualDeviceChanged(latestRunningUids);
            r1 = r1 + 1;
            goto L3
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void onPersistentDeviceIdsRemoved(final Set<String> removedPersistentDeviceIds) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            final List<Consumer<String>> persistentDeviceIdRemovedListeners = List.copyOf(this.mPersistentDeviceIdRemovedListeners);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            VirtualDeviceManagerService.m3020$$Nest$fgetmHandler(this.this$0).post(new VirtualDeviceManagerService$LocalService$$ExternalSyntheticLambda2(removedPersistentDeviceIds, persistentDeviceIdRemovedListeners));
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onPersistentDeviceIdsRemoved$1(Set removedPersistentDeviceIds, List persistentDeviceIdRemovedListeners) {
            Iterator r0 = removedPersistentDeviceIds.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            String persistentDeviceId = (String) r0.next();
            Iterator r2 = persistentDeviceIdRemovedListeners.iterator();
        L7:
            if (r2.hasNext() == false) goto L4;
            Consumer<String> listener = (Consumer) r2.next();
            listener.accept(persistentDeviceId);
            goto L7
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void onAuthenticationPrompt(int uid) {
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L4:
            if (i >= virtualDevicesSnapshot.size()) goto L7;
            VirtualDeviceImpl device = virtualDevicesSnapshot.get(i);
            device.showToastWhereUidIsRunning(uid, R.string.autofill_save_never, 1, Looper.getMainLooper());
            i = i + 1;
            goto L4
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public int getBaseVirtualDisplayFlags(IVirtualDevice virtualDevice) {
            return ((VirtualDeviceImpl) virtualDevice).getBaseVirtualDisplayFlags();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public LocaleList getPreferredLocaleListForUid(int uid) {
            VirtualDeviceImpl virtualDevice = null;
            Object r1 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r1);
            int i = 0;
        L20:
        L10:
            th = move-exception;
            throw th;
        L6:
            if (i >= VirtualDeviceManagerService.m3019$$Nest$fgetmAppsOnVirtualDevices(this.this$0).size()) goto L13;
            if (((ArraySet) VirtualDeviceManagerService.m3019$$Nest$fgetmAppsOnVirtualDevices(this.this$0).valueAt(i)).contains(Integer.valueOf(uid)) == true) goto L9;
            i = i + 1;     // Catch: Throwable -> L10
            goto L20
        L9:
            int deviceId = VirtualDeviceManagerService.m3019$$Nest$fgetmAppsOnVirtualDevices(this.this$0).keyAt(i);     // Catch: Throwable -> L10
            virtualDevice = (VirtualDeviceImpl) VirtualDeviceManagerService.m3027$$Nest$fgetmVirtualDevices(this.this$0).get(deviceId);     // Catch: Throwable -> L10
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L10
            if (virtualDevice != null) goto L17;
            return null;
        L17:
            return virtualDevice.getDeviceLocaleList();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public boolean isAppRunningOnAnyVirtualDevice(int uid) {
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L4:
            if (i >= virtualDevicesSnapshot.size()) goto L10;
            if (virtualDevicesSnapshot.get(i).isAppRunningOnVirtualDevice(uid) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public boolean isInputDeviceOwnedByVirtualDevice(int inputDeviceId) {
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L4:
            if (i >= virtualDevicesSnapshot.size()) goto L10;
            if (virtualDevicesSnapshot.get(i).isInputDeviceOwnedByVirtualDevice(inputDeviceId) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public ArraySet<Integer> getDisplayIdsForDevice(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L6;
            return new ArraySet();
        L6:
            return (ArraySet) Arrays.stream(virtualDevice.getDisplayIds()).boxed().collect(Collectors.toCollection(new VirtualDeviceManagerService$LocalService$$ExternalSyntheticLambda1()));
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public int getDeviceIdForDisplayId(int displayId) {
            return VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0).getDeviceIdForDisplayId(displayId);
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public VirtualDevice getVirtualDevice(int deviceId) {
            return VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0).getVirtualDevice(deviceId);
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public long getDimDurationMillisForDeviceId(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L6;
            return -1;
        L6:
            return virtualDevice.getDimDurationMillis();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public long getScreenOffTimeoutMillisForDeviceId(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L6;
            return -1;
        L6:
            return virtualDevice.getScreenOffTimeoutMillis();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public boolean isValidVirtualDeviceId(int deviceId) {
            return VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0).isValidVirtualDeviceId(deviceId);
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public String getPersistentIdForDevice(int deviceId) {
            if (deviceId != 0) goto L5;
            return "default:0";
        L5:
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L9;
            return null;
        L9:
            return virtualDevice.getPersistentDeviceId();
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public Set<String> getAllPersistentDeviceIds() {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            Set<String> r1 = Set.copyOf(VirtualDeviceManagerService.m3018$$Nest$fgetmActiveAssociations(this.this$0).keySet());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void registerAppsOnVirtualDeviceListener(VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener listener) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            this.mAppsOnVirtualDeviceListeners.add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void unregisterAppsOnVirtualDeviceListener(VirtualDeviceManagerInternal.AppsOnVirtualDeviceListener listener) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            this.mAppsOnVirtualDeviceListeners.remove(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void registerPersistentDeviceIdRemovedListener(Consumer<String> persistentDeviceIdRemovedListener) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            this.mPersistentDeviceIdRemovedListeners.add(persistentDeviceIdRemovedListener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.companion.virtual.VirtualDeviceManagerInternal
        public void unregisterPersistentDeviceIdRemovedListener(Consumer<String> persistentDeviceIdRemovedListener) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            this.mPersistentDeviceIdRemovedListeners.remove(persistentDeviceIdRemovedListener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class PendingTrampolineMap {
        private static final int TRAMPOLINE_WAIT_MS = 5000;
        private final Handler mHandler;
        private final ConcurrentHashMap<String, VirtualDeviceImpl.PendingTrampoline> mMap;

        public static /* synthetic */ void $r8$lambda$0bgKT1UpaEZSPZYjVP2DHLfS7gg(PendingTrampolineMap r0, VirtualDeviceImpl.PendingTrampoline r1) {
            r0.lambda$put$0(r1);
        }

        PendingTrampolineMap(Handler handler) {
            this.mMap = new ConcurrentHashMap();
            this.mHandler = handler;
        }

        VirtualDeviceImpl.PendingTrampoline put(String packageName, final VirtualDeviceImpl.PendingTrampoline pendingTrampoline) {
            VirtualDeviceImpl.PendingTrampoline existing = this.mMap.put(packageName, pendingTrampoline);
            this.mHandler.removeCallbacksAndMessages(existing);
            this.mHandler.postDelayed(new VirtualDeviceManagerService$PendingTrampolineMap$$ExternalSyntheticLambda0(this, pendingTrampoline), pendingTrampoline, 5000);
            return existing;
        }

        private /* synthetic */ void lambda$put$0(VirtualDeviceImpl.PendingTrampoline pendingTrampoline) {
            String creatorPackage = pendingTrampoline.mPendingIntent.getCreatorPackage();
            if (creatorPackage == null) goto L6;
            remove(creatorPackage);
            return;
        }

        VirtualDeviceImpl.PendingTrampoline remove(String packageName) {
            VirtualDeviceImpl.PendingTrampoline pendingTrampoline = this.mMap.remove(packageName);
            this.mHandler.removeCallbacksAndMessages(pendingTrampoline);
            return pendingTrampoline;
        }
    }

    private class StrongAuthTracker extends LockPatternUtils.StrongAuthTracker {
        final Set<Integer> mUsersInLockdown;
        final /* synthetic */ VirtualDeviceManagerService this$0;

        StrongAuthTracker(VirtualDeviceManagerService r1, Context context) {
            this.this$0 = r1;
            super(context);
            this.mUsersInLockdown = new ArraySet();
        }

        public synchronized void onStrongAuthRequiredChanged(int userId) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if ((getStrongAuthForUser(userId) & 32) <= 0) goto L13;
            if (this.mUsersInLockdown.add(Integer.valueOf(userId)) == true) goto L8;
        L17:
            monitor-exit(this);
            return;
        L8:
            if (this.mUsersInLockdown.size() != 1) goto L17;
            this.this$0.onLockdownChanged(true);     // Catch: Throwable -> L10
            goto L17
        L13:
            if (this.mUsersInLockdown.remove(Integer.valueOf(userId)) == false) goto L17;
            if (this.mUsersInLockdown.isEmpty() == false) goto L17;
            this.this$0.onLockdownChanged(false);     // Catch: Throwable -> L10
            goto L17
        }
    }

    class VirtualDeviceManagerImpl extends IVirtualDeviceManager.Stub {
        private final VirtualDeviceImpl.PendingTrampolineCallback mPendingTrampolineCallback;
        final /* synthetic */ VirtualDeviceManagerService this$0;

        public static /* synthetic */ void $r8$lambda$jzEpZQ5vPeglfgWMn0kTnGBeR2U(VirtualDeviceManagerImpl r0, int r1, ArraySet r2) {
            r0.lambda$createVirtualDevice$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$syAH5aT1X0ioagQ1Tnh9uqQjPvk(int r0, IVirtualDeviceListener r1) {
            lambda$createVirtualDevice$1(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateVirtualDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ IVirtualDevice m3033$$Nest$mcreateVirtualDevice(VirtualDeviceManagerImpl r0, IBinder r1, AttributionSource r2, AssociationInfo r3, VirtualDeviceParams r4, IVirtualDeviceActivityListener r5, IVirtualDeviceSoundEffectListener r6) {
            return r0.createVirtualDevice(r1, r2, r3, r4, r5, r6);
        }

        VirtualDeviceManagerImpl(VirtualDeviceManagerService this$0) {
            this.this$0 = this$0;
            this.mPendingTrampolineCallback = new AnonymousClass1(this);
        }

        public IVirtualDevice createVirtualDevice(IBinder token, AttributionSource attributionSource, int associationId, VirtualDeviceParams params, IVirtualDeviceActivityListener activityListener, IVirtualDeviceSoundEffectListener soundEffectListener) {
            createVirtualDevice_enforcePermission();
            activityListener.getClass();
            soundEffectListener.getClass();
            String packageName = attributionSource.getPackageName();
            AssociationInfo associationInfo = getAssociationInfo(packageName, associationId);
            if (associationInfo == null) goto L11;
            if (VirtualDeviceManagerService.m3031$$Nest$sfgetVIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES().contains(associationInfo.getDeviceProfile()) == false) goto L9;
            return createVirtualDevice(token, attributionSource, associationInfo, params, activityListener, soundEffectListener);
        L9:
            throw new IllegalArgumentException("Unsupported CDM Association device profile " + associationInfo.getDeviceProfile() + " for virtual device creation.");
        L11:
            throw new IllegalArgumentException("No association with ID " + associationId);
        }

        private IVirtualDevice createVirtualDevice(IBinder token, AttributionSource attributionSource, AssociationInfo associationInfo, VirtualDeviceParams params, IVirtualDeviceActivityListener activityListener, IVirtualDeviceSoundEffectListener soundEffectListener) {
            createVirtualDevice_enforcePermission();
            attributionSource.enforceCallingUid();
            String packageName = attributionSource.getPackageName();
            if (PermissionUtils.validateCallingPackageName(this.this$0.getContext(), packageName) == false) goto L14;
            params.getClass();
            UserHandle userHandle = IVirtualDeviceManager.Stub.getCallingUserHandle();
            CameraAccessController cameraAccessController = VirtualDeviceManagerService.m3028$$Nest$mgetCameraAccessController(this.this$0, userHandle, params, attributionSource.getPackageName());
            final int deviceId = VirtualDeviceManagerService.m3032$$Nest$sfgetsNextUniqueIndex().getAndIncrement();
            Consumer<ArraySet<Integer>> runningAppsChangedCallback = new VirtualDeviceManagerService$VirtualDeviceManagerImpl$$ExternalSyntheticLambda0(this, deviceId);
            VirtualDeviceImpl virtualDevice = new VirtualDeviceImpl(this.this$0.getContext(), associationInfo, this.this$0, VirtualDeviceManagerService.m3025$$Nest$fgetmVirtualDeviceLog(this.this$0), token, attributionSource, deviceId, cameraAccessController, this.mPendingTrampolineCallback, activityListener, soundEffectListener, runningAppsChangedCallback, params);
            Counter.logIncrement("virtual_devices.value_virtual_devices_created_count");
            Object r4 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r4);
            VirtualDeviceManagerService.m3027$$Nest$fgetmVirtualDevices(this.this$0).put(deviceId, virtualDevice);     // Catch: Throwable -> L10
            monitor-exit(r4);     // Catch: Throwable -> L10
            VirtualDeviceManagerService.m3024$$Nest$fgetmVirtualDeviceListeners(this.this$0).broadcast(new VirtualDeviceManagerService$VirtualDeviceManagerImpl$$ExternalSyntheticLambda1(deviceId));
            Counter.logIncrementWithUid("virtual_devices.value_virtual_devices_created_with_uid_count", attributionSource.getUid());
            return virtualDevice;
        L10:
            th = move-exception;
            throw th;
        L14:
            throw new SecurityException("Package name " + packageName + " does not belong to calling uid " + IVirtualDeviceManager.Stub.getCallingUid());
        }

        private /* synthetic */ void lambda$createVirtualDevice$0(int deviceId, ArraySet runningUids) {
            this.this$0.notifyRunningAppsChanged(deviceId, runningUids);
        }

        private static /* synthetic */ void lambda$createVirtualDevice$1(int deviceId, IVirtualDeviceListener listener) {
            listener.onVirtualDeviceCreated(deviceId);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.i(VirtualDeviceManagerService.TAG, "Failed to invoke onVirtualDeviceCreated listener: " + e.getMessage());
        }

        public List<VirtualDevice> getVirtualDevices() {
            List<VirtualDevice> virtualDevices = new ArrayList();
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L4:
            if (i >= virtualDevicesSnapshot.size()) goto L7;
            VirtualDeviceImpl device = virtualDevicesSnapshot.get(i);
            virtualDevices.add(device.getPublicVirtualDeviceObject());
            i = i + 1;
            goto L4
        L7:
            return virtualDevices;
        }

        public VirtualDevice getVirtualDevice(int deviceId) {
            VirtualDeviceImpl device = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (device != null) goto L6;
            return null;
        L6:
            return device.getPublicVirtualDeviceObject();
        }

        public void registerVirtualDeviceListener(IVirtualDeviceListener listener) {
            VirtualDeviceManagerService.m3024$$Nest$fgetmVirtualDeviceListeners(this.this$0).register(listener);
        }

        public void unregisterVirtualDeviceListener(IVirtualDeviceListener listener) {
            VirtualDeviceManagerService.m3024$$Nest$fgetmVirtualDeviceListeners(this.this$0).unregister(listener);
        }

        public int getDevicePolicy(int deviceId, int policyType) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L7;
            return 0;
        L7:
            return virtualDevice.getDevicePolicy(policyType);
        }

        public int getDeviceIdForDisplayId(int displayId) {
            if (displayId == (-1)) goto L16;
            if (displayId == 0) goto L16;
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L8:
            if (i >= virtualDevicesSnapshot.size()) goto L15;
            VirtualDeviceImpl virtualDevice = virtualDevicesSnapshot.get(i);
            if (virtualDevice.isDisplayOwnedByVirtualDevice(displayId) == true) goto L12;
            i = i + 1;
            goto L8
        L12:
            return virtualDevice.getDeviceId();
        L15:
            return 0;
        L16:
            return 0;
        }

        public CharSequence getDisplayNameForPersistentDeviceId(String persistentDeviceId) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            AssociationInfo associationInfo = (AssociationInfo) VirtualDeviceManagerService.m3018$$Nest$fgetmActiveAssociations(this.this$0).get(persistentDeviceId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            if (associationInfo != null) goto L9;
            return null;
        L9:
            return associationInfo.getDisplayName();
        L10:
            th = move-exception;
            throw th;
        }

        public List<String> getAllPersistentDeviceIds() {
            return new ArrayList(VirtualDeviceManagerService.m3022$$Nest$fgetmLocalService(this.this$0).getAllPersistentDeviceIds());
        }

        public boolean isValidVirtualDeviceId(int deviceId) {
            Object r0 = VirtualDeviceManagerService.m3026$$Nest$fgetmVirtualDeviceManagerLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = VirtualDeviceManagerService.m3027$$Nest$fgetmVirtualDevices(this.this$0).contains(deviceId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getAudioPlaybackSessionId(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L7;
            return 0;
        L7:
            return virtualDevice.getAudioPlaybackSessionId();
        }

        public int getAudioRecordingSessionId(int deviceId) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice != null) goto L7;
            return 0;
        L7:
            return virtualDevice.getAudioRecordingSessionId();
        }

        public void playSoundEffect(int deviceId, int effectType) {
            VirtualDeviceImpl virtualDevice = VirtualDeviceManagerService.m3029$$Nest$mgetVirtualDeviceForId(this.this$0, deviceId);
            if (virtualDevice == null) goto L6;
            virtualDevice.playSoundEffect(effectType);
            return;
        }

        public boolean isVirtualDeviceOwnedMirrorDisplay(int displayId) {
            if (getDeviceIdForDisplayId(displayId) != 0) goto L5;
            return false;
        L5:
            DisplayManagerInternal displayManager = (DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class);
            if (displayManager.getDisplayIdToMirror(displayId) == (-1)) goto L9;
            return true;
        L9:
            return false;
        }

        private AssociationInfo getAssociationInfo(String packageName, int associationId) {
            UserHandle userHandle = IVirtualDeviceManager.Stub.getCallingUserHandle();
            CompanionDeviceManager cdm = (CompanionDeviceManager) this.this$0.getContext().createContextAsUser(userHandle, 0).getSystemService(CompanionDeviceManager.class);
            long identity = Binder.clearCallingIdentity();
            List<AssociationInfo> associations = cdm.getAllAssociations();     // Catch: Throwable -> L18
            Binder.restoreCallingIdentity(identity);
            int callingUserId = userHandle.getIdentifier();
            if (associations == null) goto L15;
            int associationSize = associations.size();
            int i = 0;
        L7:
            if (i >= associationSize) goto L27;
            AssociationInfo associationInfo = associations.get(i);
            if (associationInfo.belongsToPackage(callingUserId, packageName) == false) goto L13;
            if (associationId != associationInfo.getId()) goto L13;
            return associationInfo;
        L13:
            i = i + 1;
            goto L7
        L27:
            return null;
        L15:
            Slog.w(VirtualDeviceManagerService.TAG, "No associations for user " + callingUserId);
            return null;
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        L4:
            e = move-exception;
            Slog.e(VirtualDeviceManagerService.TAG, "Error during IPC", e);
            throw ExceptionUtils.propagate(e, RemoteException.class);
        }

        public void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), VirtualDeviceManagerService.TAG, fout) == true) goto L5;
            return;
        L5:
            fout.println("Created virtual devices: ");
            ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = VirtualDeviceManagerService.m3030$$Nest$mgetVirtualDevicesSnapshot(this.this$0);
            int i = 0;
        L7:
            if (i >= virtualDevicesSnapshot.size()) goto L9;
            virtualDevicesSnapshot.get(i).dump(fd, fout, args);
            i = i + 1;
            goto L7
        L9:
            VirtualDeviceManagerService.m3025$$Nest$fgetmVirtualDeviceLog(this.this$0).dump(fout);
        }
    }

    final class VirtualDeviceManagerNativeImpl extends IVirtualDeviceManagerNative.Stub {
        final /* synthetic */ VirtualDeviceManagerService this$0;

        VirtualDeviceManagerNativeImpl(VirtualDeviceManagerService this$0) {
            this.this$0 = this$0;
        }

        public int[] getDeviceIdsForUid(int uid) {
            return VirtualDeviceManagerService.m3022$$Nest$fgetmLocalService(this.this$0).getDeviceIdsForUid(uid).stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
        }

        public int getDevicePolicy(int deviceId, int policyType) {
            return VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0).getDevicePolicy(deviceId, policyType);
        }

        public int getDeviceIdForDisplayId(int displayId) {
            return VirtualDeviceManagerService.m3021$$Nest$fgetmImpl(this.this$0).getDeviceIdForDisplayId(displayId);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$eM-uhh-4fTQJevYwUm88_ltE5E4, reason: not valid java name */
    public static /* synthetic */ void m3016$r8$lambda$eMuhh4fTQJevYwUm88_ltE5E4(VirtualDeviceManagerService r0, int r1) {
        r0.onCameraAccessBlocked(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$l-WyqPohEXN68g7USus9Gopp5h0, reason: not valid java name */
    public static /* synthetic */ void m3017$r8$lambda$lWyqPohEXN68g7USus9Gopp5h0(int r0, IVirtualDeviceListener r1) {
        lambda$removeVirtualDevice$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveAssociations, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m3018$$Nest$fgetmActiveAssociations(VirtualDeviceManagerService r0) {
        return r0.mActiveAssociations;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppsOnVirtualDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3019$$Nest$fgetmAppsOnVirtualDevices(VirtualDeviceManagerService r0) {
        return r0.mAppsOnVirtualDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3020$$Nest$fgetmHandler(VirtualDeviceManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceManagerImpl m3021$$Nest$fgetmImpl(VirtualDeviceManagerService r0) {
        return r0.mImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceManagerInternal m3022$$Nest$fgetmLocalService(VirtualDeviceManagerService r0) {
        return r0.mLocalService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingTrampolines, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingTrampolineMap m3023$$Nest$fgetmPendingTrampolines(VirtualDeviceManagerService r0) {
        return r0.mPendingTrampolines;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m3024$$Nest$fgetmVirtualDeviceListeners(VirtualDeviceManagerService r0) {
        return r0.mVirtualDeviceListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceLog m3025$$Nest$fgetmVirtualDeviceLog(VirtualDeviceManagerService r0) {
        return r0.mVirtualDeviceLog;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDeviceManagerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3026$$Nest$fgetmVirtualDeviceManagerLock(VirtualDeviceManagerService r0) {
        return r0.mVirtualDeviceManagerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVirtualDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3027$$Nest$fgetmVirtualDevices(VirtualDeviceManagerService r0) {
        return r0.mVirtualDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCameraAccessController, reason: not valid java name */
    static /* bridge */ /* synthetic */ CameraAccessController m3028$$Nest$mgetCameraAccessController(VirtualDeviceManagerService r0, UserHandle r1, VirtualDeviceParams r2, String r3) {
        return r0.getCameraAccessController(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVirtualDeviceForId, reason: not valid java name */
    static /* bridge */ /* synthetic */ VirtualDeviceImpl m3029$$Nest$mgetVirtualDeviceForId(VirtualDeviceManagerService r0, int r1) {
        return r0.getVirtualDeviceForId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVirtualDevicesSnapshot, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m3030$$Nest$mgetVirtualDevicesSnapshot(VirtualDeviceManagerService r0) {
        return r0.getVirtualDevicesSnapshot();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetVIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m3031$$Nest$sfgetVIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES() {
        return VIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsNextUniqueIndex, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m3032$$Nest$sfgetsNextUniqueIndex() {
        return sNextUniqueIndex;
    }

    static {
        VIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES = Arrays.asList(new String[]{"android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION", "android.app.role.COMPANION_DEVICE_APP_STREAMING", "android.app.role.COMPANION_DEVICE_NEARBY_DEVICE_STREAMING", "android.app.role.COMPANION_DEVICE_VIRTUAL_DEVICE"});
        sNextUniqueIndex = new AtomicInteger(1);
    }

    public VirtualDeviceManagerService(Context context) {
        super(context);
        this.mVirtualDeviceManagerLock = new Object();
        this.mVirtualDeviceLog = new VirtualDeviceLog(getContext());
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPendingTrampolines = new PendingTrampolineMap(this.mHandler);
        this.mActiveAssociations = new ArrayMap();
        this.mVirtualDeviceListeners = new RemoteCallbackList();
        this.mVirtualDevices = new SparseArray();
        this.mAppsOnVirtualDevices = new SparseArray();
        this.mActivityInterceptorCallback = new AnonymousClass1(this);
        this.mImpl = new VirtualDeviceManagerImpl(this);
        this.mNativeImpl = new VirtualDeviceManagerNativeImpl(this);
        this.mLocalService = new LocalService(this, null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("virtualdevice", this.mImpl);
        publishBinderService(VIRTUAL_DEVICE_NATIVE_SERVICE, this.mNativeImpl);
        publishLocalService(VirtualDeviceManagerInternal.class, this.mLocalService);
        ActivityTaskManagerInternal activityTaskManagerInternal = (ActivityTaskManagerInternal) getLocalService(ActivityTaskManagerInternal.class);
        activityTaskManagerInternal.registerActivityStartInterceptor(3, this.mActivityInterceptorCallback);
        CompanionDeviceManager cdm = (CompanionDeviceManager) getContext().getSystemService(CompanionDeviceManager.class);
        if (cdm == null) goto L5;
        onCdmAssociationsChanged(cdm.getAllAssociations(-1));
        cdm.addOnAssociationsChangedListener(getContext().getMainExecutor(), new VirtualDeviceManagerService$$ExternalSyntheticLambda0(this), -1);
    L6:
        this.mStrongAuthTracker = new StrongAuthTracker(this, getContext());
        new LockPatternUtils(getContext()).registerStrongAuthTracker(this.mStrongAuthTracker);
        return;
    L5:
        Slog.e(TAG, "Failed to find CompanionDeviceManager. No CDM association info  will be available.");
        goto L6
    }

    void onLockdownChanged(boolean lockdownActive) {
        ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = getVirtualDevicesSnapshot();
        int i = 0;
    L4:
        if (i >= virtualDevicesSnapshot.size()) goto L7;
        virtualDevicesSnapshot.get(i).onLockdownChanged(lockdownActive);
        i = i + 1;
        goto L4
    }

    private void onCameraAccessBlocked(int appUid) {
        ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = getVirtualDevicesSnapshot();
        int i = 0;
    L4:
        if (i >= virtualDevicesSnapshot.size()) goto L7;
        VirtualDeviceImpl virtualDevice = virtualDevicesSnapshot.get(i);
        virtualDevice.showToastWhereUidIsRunning(appUid, getContext().getString(17042328, new Object[]{virtualDevice.getDisplayName()}), 1, Looper.myLooper());
        i = i + 1;
        goto L4
    }

    private CameraAccessController getCameraAccessController(UserHandle userHandle, VirtualDeviceParams params, String callingPackage) {
        if (CompatChanges.isChangeEnabled(ENABLE_DEFAULT_DEVICE_CAMERA_ACCESS, callingPackage, userHandle) == true) goto L5;
    L8:
        int userId = userHandle.getIdentifier();
        ArrayList<VirtualDeviceImpl> virtualDevicesSnapshot = getVirtualDevicesSnapshot();
        int i = 0;
    L10:
        if (i >= virtualDevicesSnapshot.size()) goto L15;
        CameraAccessController cameraAccessController = virtualDevicesSnapshot.get(i).getCameraAccessController();
        if (cameraAccessController.getUserId() == userId) goto L13;
        i = i + 1;
        goto L10
    L13:
        return cameraAccessController;
    L15:
        Context userContext = getContext().createContextAsUser(userHandle, 0);
        return new CameraAccessController(userContext, this.mLocalService, new VirtualDeviceManagerService$$ExternalSyntheticLambda1(this));
    L5:
        if (params.getDevicePolicy(7) != 0) goto L8;
        return null;
    }

    VirtualDeviceManagerInternal getLocalServiceInstance() {
        return this.mLocalService;
    }

    void notifyRunningAppsChanged(int deviceId, ArraySet<Integer> uids) {
        Object r0 = this.mVirtualDeviceManagerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDevices.contains(deviceId) == true) goto L11;
        Slog.e(TAG, "notifyRunningAppsChanged called for unknown deviceId:" + deviceId + " (maybe it was recently closed?)");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mAppsOnVirtualDevices.put(deviceId, uids);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mLocalService.onAppsOnVirtualDeviceChanged();
    }

    void addVirtualDevice(VirtualDeviceImpl virtualDevice) {
        Object r0 = this.mVirtualDeviceManagerLock;
        monitor-enter(r0);
        this.mVirtualDevices.put(virtualDevice.getDeviceId(), virtualDevice);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean removeVirtualDevice(final int deviceId) {
        Object r0 = this.mVirtualDeviceManagerLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVirtualDevices.contains(deviceId) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mAppsOnVirtualDevices.remove(deviceId);     // Catch: Throwable -> L9
        this.mVirtualDevices.remove(deviceId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        this.mVirtualDeviceListeners.broadcast(new VirtualDeviceManagerService$$ExternalSyntheticLambda2(deviceId));
        Intent i = new Intent("android.companion.virtual.action.VIRTUAL_DEVICE_REMOVED");
        i.putExtra("android.companion.virtual.extra.VIRTUAL_DEVICE_ID", deviceId);
        i.setFlags(1073741824);
        long identity = Binder.clearCallingIdentity();
        getContext().sendBroadcastAsUser(i, UserHandle.ALL);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(identity);
        return true;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ void lambda$removeVirtualDevice$0(int deviceId, IVirtualDeviceListener listener) {
        listener.onVirtualDeviceClosed(deviceId);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.i(TAG, "Failed to invoke onVirtualDeviceClosed listener: " + e.getMessage());
    }

    void onCdmAssociationsChanged(List<AssociationInfo> associations) {
        ArrayMap<String, AssociationInfo> vdmAssociations = new ArrayMap();
        int i = 0;
    L4:
        if (i >= associations.size()) goto L11;
        AssociationInfo association = associations.get(i);
        if (VIRTUAL_DEVICE_COMPANION_DEVICE_PROFILES.contains(association.getDeviceProfile()) == false) goto L10;
        if (association.isRevoked() == true) goto L10;
        String persistentId = VirtualDeviceImpl.createPersistentDeviceId(association.getId());
        vdmAssociations.put(persistentId, association);
    L10:
        i = i + 1;
        goto L4
    L11:
        Set<VirtualDeviceImpl> virtualDevicesToRemove = new HashSet();
        Object r2 = this.mVirtualDeviceManagerLock;
        monitor-enter(r2);
        Set<String> removedPersistentDeviceIds = this.mActiveAssociations.keySet();     // Catch: Throwable -> L19
        removedPersistentDeviceIds.removeAll(vdmAssociations.keySet());     // Catch: Throwable -> L19
        this.mActiveAssociations = vdmAssociations;     // Catch: Throwable -> L19
        int i2 = 0;
    L15:
        if (i2 >= this.mVirtualDevices.size()) goto L23;
        VirtualDeviceImpl virtualDevice = this.mVirtualDevices.valueAt(i2);     // Catch: Throwable -> L19
        if (removedPersistentDeviceIds.contains(virtualDevice.getPersistentDeviceId()) == false) goto L21;
        virtualDevicesToRemove.add(virtualDevice);     // Catch: Throwable -> L19
    L21:
        i2 = i2 + 1;     // Catch: Throwable -> L19
        goto L15
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L19
        Iterator<VirtualDeviceImpl> r3 = virtualDevicesToRemove.iterator();
    L26:
        if (r3.hasNext() == false) goto L29;
        r3.next().close();
        goto L26
    L29:
        if (removedPersistentDeviceIds.isEmpty() == true) goto L44;
        this.mLocalService.onPersistentDeviceIdsRemoved(removedPersistentDeviceIds);
        return;
    L44:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private ArrayList<VirtualDeviceImpl> getVirtualDevicesSnapshot() {
        Object r0 = this.mVirtualDeviceManagerLock;
        monitor-enter(r0);
        ArrayList<VirtualDeviceImpl> virtualDevices = new ArrayList(this.mVirtualDevices.size());     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mVirtualDevices.size()) goto L11;
        virtualDevices.add(this.mVirtualDevices.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return virtualDevices;
    L8:
        th = move-exception;
        throw th;
    }

    private VirtualDeviceImpl getVirtualDeviceForId(int deviceId) {
        Object r0 = this.mVirtualDeviceManagerLock;
        monitor-enter(r0);
        VirtualDeviceImpl r1 = this.mVirtualDevices.get(deviceId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
