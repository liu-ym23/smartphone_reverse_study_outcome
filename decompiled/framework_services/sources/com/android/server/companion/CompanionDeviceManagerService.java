package com.android.server.companion;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ecm.EnhancedConfirmationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.companion.AssociationInfo;
import android.companion.AssociationRequest;
import android.companion.DeviceId;
import android.companion.IAssociationRequestCallback;
import android.companion.ICompanionDeviceManager;
import android.companion.IOnAssociationsChangedListener;
import android.companion.IOnMessageReceivedListener;
import android.companion.IOnTransportsChangedListener;
import android.companion.ISystemDataTransferCallback;
import android.companion.ObservingDevicePresenceRequest;
import android.companion.datatransfer.PermissionSyncRequest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.net.MacAddress;
import android.os.Binder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PowerExemptionManager;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ExceptionUtils;
import android.util.Slog;
import com.android.internal.content.PackageMonitor;
import com.android.internal.notification.NotificationAccessConfirmationActivityContract;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.companion.association.AssociationDiskStore;
import com.android.server.companion.association.AssociationRequestsProcessor;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.companion.association.InactiveAssociationsRemovalService;
import com.android.server.companion.datatransfer.SystemDataTransferProcessor;
import com.android.server.companion.datatransfer.SystemDataTransferRequestStore;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceCall;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncController;
import com.android.server.companion.datatransfer.contextsync.CrossDeviceSyncControllerCallback;
import com.android.server.companion.devicepresence.CompanionAppBinder;
import com.android.server.companion.devicepresence.DevicePresenceProcessor;
import com.android.server.companion.devicepresence.ObservableUuid;
import com.android.server.companion.devicepresence.ObservableUuidStore;
import com.android.server.companion.transport.CompanionTransportManager;
import com.android.server.companion.utils.PackageUtils;
import com.android.server.companion.utils.PermissionsUtils;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class CompanionDeviceManagerService extends SystemService {
    private static final int MAX_CN_LENGTH = 500;
    private static final long PAIR_WITHOUT_PROMPT_WINDOW_MS = 600000;
    private static final String TAG = "CDM_CompanionDeviceManagerService";
    private final AssociationRequestsProcessor mAssociationRequestsProcessor;
    private final AssociationStore mAssociationStore;
    private final BackupRestoreProcessor mBackupRestoreProcessor;
    private final CompanionAppBinder mCompanionAppBinder;
    private final CompanionExemptionProcessor mCompanionExemptionProcessor;
    private final CrossDeviceSyncController mCrossDeviceSyncController;
    private final DevicePresenceProcessor mDevicePresenceProcessor;
    private final DisassociationProcessor mDisassociationProcessor;
    private final ObservableUuidStore mObservableUuidStore;
    private final PackageMonitor mPackageMonitor;
    private final SystemDataTransferProcessor mSystemDataTransferProcessor;
    private final SystemDataTransferRequestStore mSystemDataTransferRequestStore;
    private final CompanionTransportManager mTransportManager;

    public class CompanionDeviceManagerImpl extends ICompanionDeviceManager.Stub {
        final /* synthetic */ CompanionDeviceManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$ZMsfRpQZ2dfhY6xdjBA1Gio0BTI(String r0, AssociationInfo r1) {
            return lambda$isDeviceAssociatedForWifiConnection$1(r0, r1);
        }

        public static /* synthetic */ PendingIntent $r8$lambda$bKrxs04qGqM4c37Vsn3wxssSYxk(CompanionDeviceManagerImpl r0, String r1, int r2, int r3, ComponentName r4) {
            return r0.lambda$requestNotificationAccess$0(r1, r2, r3, r4);
        }

        public CompanionDeviceManagerImpl(CompanionDeviceManagerService this$0) {
            this.this$0 = this$0;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        L4:
            e = move-exception;
            Slog.e(CompanionDeviceManagerService.TAG, "Error during IPC", e);
            throw ExceptionUtils.propagate(e, RemoteException.class);
        }

        public void associate(AssociationRequest request, IAssociationRequestCallback callback, String packageName, int userId) throws RemoteException {
            Slog.i(CompanionDeviceManagerService.TAG, "associate() request=" + request + ", package=u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName);
            PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.this$0.getContext(), userId, packageName, "create associations");
            if (request.isSkipRoleGrant() == false) goto L5;
            checkCallerCanSkipRoleGrant();
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).createAssociation(userId, packageName, null, request.getDisplayName(), request.getDeviceProfile(), null, request.isSelfManaged(), callback, null, request.getDeviceIcon(), true);
            return;
        L5:
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).processNewAssociationRequest(request, packageName, userId, callback);
        }

        public PendingIntent buildAssociationCancellationIntent(String packageName, int userId) throws RemoteException {
            Slog.i(CompanionDeviceManagerService.TAG, "buildAssociationCancellationIntent() package=u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName);
            PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.this$0.getContext(), userId, packageName, "build association cancellation intent");
            return CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).buildAssociationCancellationIntent(packageName, userId);
        }

        public List<AssociationInfo> getAssociations(String packageName, int userId) {
            PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.this$0.getContext(), userId, packageName, "get associations");
            return CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getActiveAssociationsByPackage(userId, packageName);
        }

        public List<AssociationInfo> getAllAssociationsForUser(int userId) throws RemoteException {
            getAllAssociationsForUser_enforcePermission();
            PermissionsUtils.enforceCallerIsSystemOrCanInteractWithUserId(this.this$0.getContext(), userId);
            if (userId != (-1)) goto L7;
            return CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getActiveAssociations();
        L7:
            return CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getActiveAssociationsByUser(userId);
        }

        public void addOnAssociationsChangedListener(IOnAssociationsChangedListener listener, int userId) {
            addOnAssociationsChangedListener_enforcePermission();
            PermissionsUtils.enforceCallerIsSystemOrCanInteractWithUserId(this.this$0.getContext(), userId);
            CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).registerRemoteListener(listener, userId);
        }

        public void removeOnAssociationsChangedListener(IOnAssociationsChangedListener listener, int userId) {
            removeOnAssociationsChangedListener_enforcePermission();
            PermissionsUtils.enforceCallerIsSystemOrCanInteractWithUserId(this.this$0.getContext(), userId);
            CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).unregisterRemoteListener(listener);
        }

        public void addOnTransportsChangedListener(IOnTransportsChangedListener listener) {
            addOnTransportsChangedListener_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).addListener(listener);
        }

        public void removeOnTransportsChangedListener(IOnTransportsChangedListener listener) {
            removeOnTransportsChangedListener_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).removeListener(listener);
        }

        public void sendMessage(int messageType, byte[] data, int[] associationIds) {
            sendMessage_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).sendMessage(messageType, data, associationIds);
        }

        public void addOnMessageReceivedListener(int messageType, IOnMessageReceivedListener listener) {
            addOnMessageReceivedListener_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).addListener(messageType, listener);
        }

        public void removeOnMessageReceivedListener(int messageType, IOnMessageReceivedListener listener) {
            removeOnMessageReceivedListener_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).removeListener(messageType, listener);
        }

        @Deprecated
        public void legacyDisassociate(String deviceMacAddress, String packageName, int userId) {
            deviceMacAddress.getClass();
            packageName.getClass();
            CompanionDeviceManagerService.m2892$$Nest$fgetmDisassociationProcessor(this.this$0).disassociate(userId, packageName, deviceMacAddress);
        }

        public void disassociate(int associationId) {
            CompanionDeviceManagerService.m2892$$Nest$fgetmDisassociationProcessor(this.this$0).disassociate(associationId, DisassociationProcessor.REASON_API);
        }

        public PendingIntent requestNotificationAccess(final ComponentName component, final int userId) throws RemoteException {
            final int callingUid = ICompanionDeviceManager.Stub.getCallingUid();
            final String callingPackage = component.getPackageName();
            checkCanCallNotificationApi(callingPackage, userId);
            if (component.flattenToString().length() > 500) goto L7;
            return (PendingIntent) Binder.withCleanCallingIdentity(new CompanionDeviceManagerService$CompanionDeviceManagerImpl$$ExternalSyntheticLambda0(this, callingPackage, callingUid, userId, component));
        L7:
            throw new IllegalArgumentException("Component name is too long.");
        }

        private /* synthetic */ PendingIntent lambda$requestNotificationAccess$0(String callingPackage, int callingUid, int userId, ComponentName component) throws Exception {
            if (PackageUtils.isRestrictedSettingsAllowed(this.this$0.getContext(), callingPackage, callingUid) == true) goto L5;
            Slog.e(CompanionDeviceManagerService.TAG, "Side loaded app must enable restricted setting before request the notification access");
            Intent intent = ((EnhancedConfirmationManager) this.this$0.getContext().getSystemService(EnhancedConfirmationManager.class)).createRestrictedSettingDialogIntent(callingPackage, "android:access_notifications");
        L7:
            return PendingIntent.getActivityAsUser(this.this$0.getContext(), 0, intent, 1409286144, null, new UserHandle(userId));
        L5:
            intent = NotificationAccessConfirmationActivityContract.launcherIntent(this.this$0.getContext(), userId, component);
            goto L7
        }

        @Deprecated
        public boolean hasNotificationAccess(ComponentName component) throws RemoteException {
            checkCanCallNotificationApi(component.getPackageName(), UserHandle.getCallingUserId());
            NotificationManager nm = (NotificationManager) this.this$0.getContext().getSystemService(NotificationManager.class);
            return nm.isNotificationListenerAccessGranted(component);
        }

        public boolean isDeviceAssociatedForWifiConnection(String packageName, final String macAddress, int userId) {
            isDeviceAssociatedForWifiConnection_enforcePermission();
            if (this.this$0.getContext().getPackageManager().checkPermission("android.permission.COMPANION_APPROVE_WIFI_CONNECTIONS", packageName) != 0) goto L5;
            boolean bypassMacPermission = true;
        L6:
            if (bypassMacPermission == false) goto L9;
            return true;
        L9:
            return CollectionUtils.any(CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getActiveAssociationsByPackage(userId, packageName), new CompanionDeviceManagerService$CompanionDeviceManagerImpl$$ExternalSyntheticLambda1(macAddress));
        L5:
            bypassMacPermission = false;
            goto L6
        }

        private static /* synthetic */ boolean lambda$isDeviceAssociatedForWifiConnection$1(String macAddress, AssociationInfo a) {
            return a.isLinkedTo(macAddress);
        }

        @Deprecated
        public void legacyStartObservingDevicePresence(String deviceAddress, String callingPackage, int userId) throws RemoteException {
            legacyStartObservingDevicePresence_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).startObservingDevicePresence(userId, callingPackage, deviceAddress);
        }

        @Deprecated
        public void legacyStopObservingDevicePresence(String deviceAddress, String callingPackage, int userId) throws RemoteException {
            legacyStopObservingDevicePresence_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).stopObservingDevicePresence(userId, callingPackage, deviceAddress);
        }

        public void startObservingDevicePresence(ObservingDevicePresenceRequest request, String packageName, int userId) {
            startObservingDevicePresence_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).startObservingDevicePresence(request, packageName, userId, true);
        }

        public void stopObservingDevicePresence(ObservingDevicePresenceRequest request, String packageName, int userId) {
            stopObservingDevicePresence_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).stopObservingDevicePresence(request, packageName, userId, true);
        }

        public boolean removeBond(int associationId, String packageName, int userId) {
            removeBond_enforcePermission();
            Slog.i(CompanionDeviceManagerService.TAG, "removeBond() associationId=" + associationId + ", package=u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName);
            PermissionsUtils.enforceCallerCanManageAssociationsForPackage(this.this$0.getContext(), userId, packageName, "remove bonds");
            AssociationInfo association = CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getAssociationWithCallerChecks(associationId);
            MacAddress address = association.getDeviceMacAddress();
            if (address == null) goto L7;
            BluetoothAdapter btAdapter = ((BluetoothManager) this.this$0.getContext().getSystemService(BluetoothManager.class)).getAdapter();
            BluetoothDevice btDevice = btAdapter.getRemoteDevice(address.toString().toUpperCase());
            return btDevice.removeBond();
        L7:
            throw new IllegalArgumentException("Association id=[" + associationId + "] doesn't have a device address.");
        }

        public PendingIntent buildPermissionTransferUserConsentIntent(String packageName, int userId, int associationId) {
            return CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).buildPermissionTransferUserConsentIntent(packageName, userId, associationId);
        }

        public boolean isPermissionTransferUserConsented(String packageName, int userId, int associationId) {
            return CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).isPermissionTransferUserConsented(associationId);
        }

        public void startSystemDataTransfer(String packageName, int userId, int associationId, ISystemDataTransferCallback callback) {
            CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).startSystemDataTransfer(packageName, userId, associationId, callback);
        }

        public void attachSystemDataTransport(String packageName, int userId, int associationId, ParcelFileDescriptor fd, int flags) {
            attachSystemDataTransport_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).attachSystemDataTransport(associationId, fd, flags);
        }

        public void detachSystemDataTransport(String packageName, int userId, int associationId) {
            detachSystemDataTransport_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).detachSystemDataTransport(associationId);
        }

        public void enableSecureTransport(boolean enabled) {
            enableSecureTransport_enforcePermission();
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).enableSecureTransport(enabled);
        }

        public void enableSystemDataSync(int associationId, int flags) {
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).enableSystemDataSync(associationId, flags);
        }

        public void disableSystemDataSync(int associationId, int flags) {
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).disableSystemDataSync(associationId, flags);
        }

        public void enablePermissionsSync(int associationId) {
            if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L7;
            CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).enablePermissionsSync(associationId);
            return;
        L7:
            throw new SecurityException("Caller must be system UID");
        }

        public void disablePermissionsSync(int associationId) {
            if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L7;
            CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).disablePermissionsSync(associationId);
            return;
        L7:
            throw new SecurityException("Caller must be system UID");
        }

        public PermissionSyncRequest getPermissionSyncRequest(int associationId) {
            if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L7;
            return CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0).getPermissionSyncRequest(associationId);
        L7:
            throw new SecurityException("Caller must be system UID");
        }

        public void notifySelfManagedDeviceAppeared(int associationId) {
            notifySelfManagedDeviceAppeared_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).notifySelfManagedDevicePresenceEvent(associationId, true);
        }

        public void notifySelfManagedDeviceDisappeared(int associationId) {
            notifySelfManagedDeviceDisappeared_enforcePermission();
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).notifySelfManagedDevicePresenceEvent(associationId, false);
        }

        public boolean isCompanionApplicationBound(String packageName, int userId) {
            return CompanionDeviceManagerService.m2889$$Nest$fgetmCompanionAppBinder(this.this$0).isCompanionApplicationBound(userId, packageName);
        }

        public void createAssociation(String packageName, String macAddress, int userId, byte[] certificate) {
            createAssociation_enforcePermission();
            if (this.this$0.getContext().getPackageManager().hasSigningCertificate(packageName, certificate, 1) == true) goto L6;
            Slog.e(CompanionDeviceManagerService.TAG, "Given certificate doesn't match the package certificate.");
            return;
        L6:
            MacAddress macAddressObj = MacAddress.fromString(macAddress);
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).createAssociation(userId, packageName, macAddressObj, null, null, null, false, null, null, null, false);
        }

        private void checkCanCallNotificationApi(String callingPackage, int userId) {
            PermissionsUtils.enforceCallerIsSystemOr(userId, callingPackage);
            if (ICompanionDeviceManager.Stub.getCallingUid() != 1000) goto L5;
            return;
        L5:
            PackageUtils.enforceUsesCompanionDeviceFeature(this.this$0.getContext(), userId, callingPackage);
            Preconditions.checkState(!ArrayUtils.isEmpty(CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getActiveAssociationsByPackage(userId, callingPackage)), "App must have an association before calling this API");
        }

        private void checkCallerCanSkipRoleGrant() {
            Context context = this.this$0.getContext().createContextAsUser(Binder.getCallingUserHandle(), 0);
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
            if (keyguardManager == null) goto L10;
            if (keyguardManager.isKeyguardSecure() == false) goto L10;
            throw new SecurityException("Skipping CDM role grant requires insecure keyguard.");
        L10:
            if (this.this$0.getContext().checkCallingPermission("android.permission.ASSOCIATE_COMPANION_DEVICES") != 0) goto L13;
            return;
        L13:
            throw new SecurityException("Skipping CDM role grant requires ASSOCIATE_COMPANION_DEVICES permission.");
        }

        public boolean canPairWithoutPrompt(String packageName, String macAddress, int userId) {
            AssociationInfo association = CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).getFirstAssociationByAddress(userId, packageName, macAddress);
            if (association != null) goto L6;
            return false;
        L6:
            if ((System.currentTimeMillis() - association.getTimeApprovedMs()) >= 600000) goto L9;
            return true;
        L9:
            return false;
        }

        public void setDeviceId(int associationId, DeviceId deviceId) {
            CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0).setDeviceId(associationId, deviceId);
        }

        public byte[] getBackupPayload(int userId) {
            if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L7;
            return CompanionDeviceManagerService.m2888$$Nest$fgetmBackupRestoreProcessor(this.this$0).getBackupPayload(userId);
        L7:
            throw new SecurityException("Caller must be system");
        }

        public void applyRestoredPayload(byte[] payload, int userId) {
            if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L7;
            CompanionDeviceManagerService.m2888$$Nest$fgetmBackupRestoreProcessor(this.this$0).applyRestoredPayload(payload, userId);
            return;
        L7:
            throw new SecurityException("Caller must be system");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            return new CompanionDeviceShellCommand(this.this$0, CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0), CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0), CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0), CompanionDeviceManagerService.m2893$$Nest$fgetmSystemDataTransferProcessor(this.this$0), CompanionDeviceManagerService.m2886$$Nest$fgetmAssociationRequestsProcessor(this.this$0), CompanionDeviceManagerService.m2888$$Nest$fgetmBackupRestoreProcessor(this.this$0), CompanionDeviceManagerService.m2892$$Nest$fgetmDisassociationProcessor(this.this$0)).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);
        }

        public void dump(FileDescriptor fd, PrintWriter out, String[] args) {
            if (DumpUtils.checkDumpAndUsageStatsPermission(this.this$0.getContext(), CompanionDeviceManagerService.TAG, out) == true) goto L5;
            return;
        L5:
            CompanionDeviceManagerService.m2887$$Nest$fgetmAssociationStore(this.this$0).dump(out);
            CompanionDeviceManagerService.m2891$$Nest$fgetmDevicePresenceProcessor(this.this$0).dump(out);
            CompanionDeviceManagerService.m2889$$Nest$fgetmCompanionAppBinder(this.this$0).dump(out);
            CompanionDeviceManagerService.m2895$$Nest$fgetmTransportManager(this.this$0).dump(out);
            CompanionDeviceManagerService.m2894$$Nest$fgetmSystemDataTransferRequestStore(this.this$0).dump(out);
        }
    }

    private class LocalService implements CompanionDeviceManagerServiceInternal {
        final /* synthetic */ CompanionDeviceManagerService this$0;

        /* synthetic */ LocalService(CompanionDeviceManagerService r1, CompanionDeviceManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(CompanionDeviceManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void removeInactiveSelfManagedAssociations() {
            CompanionDeviceManagerService.m2892$$Nest$fgetmDisassociationProcessor(this.this$0).removeIdleSelfManagedAssociations();
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void registerCallMetadataSyncCallback(CrossDeviceSyncControllerCallback callback, int type) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).registerCallMetadataSyncCallback(callback, type);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void crossDeviceSync(int userId, Collection<CrossDeviceCall> calls) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).syncToAllDevicesForUserId(userId, calls);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void crossDeviceSync(AssociationInfo associationInfo, Collection<CrossDeviceCall> calls) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).syncToSingleDevice(associationInfo, calls);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void sendCrossDeviceSyncMessage(int associationId, byte[] message) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).syncMessageToDevice(associationId, message);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void sendCrossDeviceSyncMessageToAllDevices(int userId, byte[] message) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).syncMessageToAllDevicesForUserId(userId, message);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void addSelfOwnedCallId(String callId) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).addSelfOwnedCallId(callId);
            return;
        }

        @Override // com.android.server.companion.CompanionDeviceManagerServiceInternal
        public void removeSelfOwnedCallId(String callId) {
            if (CompanionDeviceConfig.isEnabled(CompanionDeviceConfig.ENABLE_CONTEXT_SYNC_TELECOM) == false) goto L6;
            CompanionDeviceManagerService.m2890$$Nest$fgetmCrossDeviceSyncController(this.this$0).removeSelfOwnedCallId(callId);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssociationRequestsProcessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssociationRequestsProcessor m2886$$Nest$fgetmAssociationRequestsProcessor(CompanionDeviceManagerService r0) {
        return r0.mAssociationRequestsProcessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssociationStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssociationStore m2887$$Nest$fgetmAssociationStore(CompanionDeviceManagerService r0) {
        return r0.mAssociationStore;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupRestoreProcessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupRestoreProcessor m2888$$Nest$fgetmBackupRestoreProcessor(CompanionDeviceManagerService r0) {
        return r0.mBackupRestoreProcessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCompanionAppBinder, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompanionAppBinder m2889$$Nest$fgetmCompanionAppBinder(CompanionDeviceManagerService r0) {
        return r0.mCompanionAppBinder;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCrossDeviceSyncController, reason: not valid java name */
    static /* bridge */ /* synthetic */ CrossDeviceSyncController m2890$$Nest$fgetmCrossDeviceSyncController(CompanionDeviceManagerService r0) {
        return r0.mCrossDeviceSyncController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDevicePresenceProcessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ DevicePresenceProcessor m2891$$Nest$fgetmDevicePresenceProcessor(CompanionDeviceManagerService r0) {
        return r0.mDevicePresenceProcessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisassociationProcessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisassociationProcessor m2892$$Nest$fgetmDisassociationProcessor(CompanionDeviceManagerService r0) {
        return r0.mDisassociationProcessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemDataTransferProcessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemDataTransferProcessor m2893$$Nest$fgetmSystemDataTransferProcessor(CompanionDeviceManagerService r0) {
        return r0.mSystemDataTransferProcessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemDataTransferRequestStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemDataTransferRequestStore m2894$$Nest$fgetmSystemDataTransferRequestStore(CompanionDeviceManagerService r0) {
        return r0.mSystemDataTransferRequestStore;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransportManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ CompanionTransportManager m2895$$Nest$fgetmTransportManager(CompanionDeviceManagerService r0) {
        return r0.mTransportManager;
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageAddedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2896$$Nest$monPackageAddedInternal(CompanionDeviceManagerService r0, int r1, String r2) {
        r0.onPackageAddedInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageModifiedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2897$$Nest$monPackageModifiedInternal(CompanionDeviceManagerService r0, int r1, String r2) {
        r0.onPackageModifiedInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoveOrDataClearedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2898$$Nest$monPackageRemoveOrDataClearedInternal(CompanionDeviceManagerService r0, int r1, String r2) {
        r0.onPackageRemoveOrDataClearedInternal(r1, r2);
    }

    public CompanionDeviceManagerService(Context context) {
        super(context);
        this.mPackageMonitor = new AnonymousClass1(this);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        PowerExemptionManager powerExemptionManager = (PowerExemptionManager) context.getSystemService(PowerExemptionManager.class);
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        ActivityTaskManagerInternal atmInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        ActivityManagerInternal amInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        PowerManagerInternal powerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        AssociationDiskStore associationDiskStore = new AssociationDiskStore();
        this.mAssociationStore = new AssociationStore(context, userManager, associationDiskStore);
        this.mSystemDataTransferRequestStore = new SystemDataTransferRequestStore();
        this.mObservableUuidStore = new ObservableUuidStore();
        this.mAssociationRequestsProcessor = new AssociationRequestsProcessor(context, packageManagerInternal, this.mAssociationStore);
        this.mBackupRestoreProcessor = new BackupRestoreProcessor(context, packageManagerInternal, this.mAssociationStore, associationDiskStore, this.mSystemDataTransferRequestStore, this.mAssociationRequestsProcessor);
        this.mCompanionAppBinder = new CompanionAppBinder(context);
        this.mCompanionExemptionProcessor = new CompanionExemptionProcessor(context, powerExemptionManager, appOpsManager, packageManagerInternal, atmInternal, amInternal, this.mAssociationStore);
        this.mDevicePresenceProcessor = new DevicePresenceProcessor(context, this.mCompanionAppBinder, userManager, this.mAssociationStore, this.mObservableUuidStore, powerManagerInternal, this.mCompanionExemptionProcessor);
        this.mTransportManager = new CompanionTransportManager(context, this.mAssociationStore);
        this.mDisassociationProcessor = new DisassociationProcessor(context, activityManager, this.mAssociationStore, packageManagerInternal, this.mDevicePresenceProcessor, this.mCompanionAppBinder, this.mSystemDataTransferRequestStore, this.mTransportManager, notificationManager);
        this.mSystemDataTransferProcessor = new SystemDataTransferProcessor(this, packageManagerInternal, this.mAssociationStore, this.mSystemDataTransferRequestStore, this.mTransportManager);
        this.mCrossDeviceSyncController = new CrossDeviceSyncController(getContext(), this.mTransportManager);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mAssociationStore.refreshCache();
        Iterator<AssociationInfo> r0 = this.mAssociationStore.getRevokedAssociations().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AssociationInfo ai = r0.next();
        this.mDisassociationProcessor.disassociate(ai.getId(), DisassociationProcessor.REASON_REVOKED);
        goto L4
    L6:
        this.mObservableUuidStore.getObservableUuidsForUser(getContext().getUserId());
        publishBinderService("companiondevice", new CompanionDeviceManagerImpl(this));
        LocalServices.addService(CompanionDeviceManagerServiceInternal.class, new LocalService(this, null));
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        Context context = getContext();
        if (phase != 500) goto L6;
        this.mPackageMonitor.register(context, FgThread.get().getLooper(), UserHandle.ALL, true);
        return;
    L6:
        if (phase != 1000) goto L10;
        this.mDevicePresenceProcessor.init(context);
        InactiveAssociationsRemovalService.schedule(getContext());
        this.mCrossDeviceSyncController.onBootCompleted();
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        Slog.d(TAG, "onUserUnlocking...");
        int userId = user.getUserIdentifier();
        List<AssociationInfo> associations = this.mAssociationStore.getActiveAssociationsByUser(userId);
        if (associations.isEmpty() == false) goto L5;
        return;
    L5:
        this.mCompanionExemptionProcessor.updateAtm(userId, associations);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final CompanionExemptionProcessor r3 = this.mCompanionExemptionProcessor;
        r3.getClass();
        executor.execute(new CompanionDeviceManagerService$$ExternalSyntheticLambda0(r3));
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocked(SystemService.TargetUser user) {
        Slog.i(TAG, "onUserUnlocked() user=" + user);
        this.mDevicePresenceProcessor.sendDevicePresenceEventOnUnlocked(user.getUserIdentifier());
    }

    private void onPackageRemoveOrDataClearedInternal(int userId, String packageName) {
        List<AssociationInfo> associationsForPackage = this.mAssociationStore.getAssociationsByPackage(userId, packageName);
        if (associationsForPackage.isEmpty() == true) goto L9;
        Slog.i(TAG, "Package removed or data cleared for user=[" + userId + "], package=[" + packageName + "]. Cleaning up CDM data...");
        Iterator<AssociationInfo> r1 = associationsForPackage.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        AssociationInfo association = r1.next();
        this.mDisassociationProcessor.disassociate(association.getId(), DisassociationProcessor.REASON_PKG_DATA_CLEARED);
        goto L6
    L8:
        this.mCompanionAppBinder.onPackageChanged(userId);
    L9:
        List<ObservableUuid> uuidsTobeObserved = this.mObservableUuidStore.getObservableUuidsForPackage(userId, packageName);
        Iterator<ObservableUuid> r2 = uuidsTobeObserved.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        ObservableUuid uuid = r2.next();
        this.mObservableUuidStore.removeObservableUuid(userId, uuid.getUuid(), packageName);
        goto L11
    }

    private void onPackageModifiedInternal(int userId, String packageName) {
        List<AssociationInfo> associations = this.mAssociationStore.getAssociationsByPackage(userId, packageName);
        if (associations.isEmpty() == true) goto L6;
        this.mCompanionExemptionProcessor.exemptPackage(userId, packageName, false);
        this.mCompanionAppBinder.onPackageChanged(userId);
        return;
    }

    private void onPackageAddedInternal(int userId, String packageName) {
        this.mBackupRestoreProcessor.restorePendingAssociations(userId, packageName);
    }

    void removeInactiveSelfManagedAssociations() {
        this.mDisassociationProcessor.removeIdleSelfManagedAssociations();
    }
}
