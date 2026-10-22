package com.android.server.companion.datatransfer;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.companion.AssociationInfo;
import android.companion.IOnMessageReceivedListener;
import android.companion.ISystemDataTransferCallback;
import android.companion.datatransfer.PermissionSyncRequest;
import android.companion.datatransfer.SystemDataTransferRequest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.permission.PermissionControllerManager;
import android.util.Slog;
import com.android.server.companion.CompanionDeviceManagerService;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.transport.CompanionTransportManager;
import com.android.server.companion.utils.PackageUtils;
import com.android.server.companion.utils.Utils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SystemDataTransferProcessor {
    private static final String EXTRA_COMPANION_DEVICE_NAME = "companion_device_name";
    private static final String EXTRA_PERMISSION_SYNC_REQUEST = "permission_sync_request";
    private static final String EXTRA_SYSTEM_DATA_TRANSFER_RESULT_RECEIVER = "system_data_transfer_result_receiver";
    private static final String LOG_TAG = "CDM_SystemDataTransferProcessor";
    private static final int RESULT_CODE_SYSTEM_DATA_TRANSFER_ALLOWED = 0;
    private static final int RESULT_CODE_SYSTEM_DATA_TRANSFER_DISALLOWED = 1;
    private final AssociationStore mAssociationStore;
    private final ComponentName mCompanionDeviceDataTransferActivity;
    private final Context mContext;
    private final ExecutorService mExecutor;
    private final ResultReceiver mOnSystemDataTransferRequestConfirmationReceiver;
    private final PackageManagerInternal mPackageManager;
    private final PermissionControllerManager mPermissionControllerManager;
    private final SystemDataTransferRequestStore mSystemDataTransferRequestStore;
    private final CompanionTransportManager mTransportManager;

    public static /* synthetic */ void $r8$lambda$MeeyNywGtgRg2k_lGgqyPiuV9Oo(SystemDataTransferProcessor r0, byte[] r1, UserHandle r2) {
        r0.lambda$onReceivePermissionRestore$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$OZrHtzc-fb5CNs3-2ERaebCOlFA, reason: not valid java name */
    public static /* synthetic */ void m2916$r8$lambda$OZrHtzcfb5CNs32ERaebCOlFA(SystemDataTransferProcessor r0, int r1, int r2, ISystemDataTransferCallback r3) {
        r0.lambda$startSystemDataTransfer$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$a7tZECqNEA-gR-QoHqTPxpP8Ghg, reason: not valid java name */
    public static /* synthetic */ PendingIntent m2917$r8$lambda$a7tZECqNEAgRQoHqTPxpP8Ghg(SystemDataTransferProcessor r0, int r1, Intent r2) {
        return r0.lambda$buildPermissionTransferUserConsentIntent$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$ko5PRrv1cPjC0zfVfmfXP7PK-FQ, reason: not valid java name */
    public static /* synthetic */ void m2918$r8$lambda$ko5PRrv1cPjC0zfVfmfXP7PKFQ(SystemDataTransferProcessor r0, int r1) {
        r0.lambda$removePermissionSyncRequest$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$zNBKbZe-eR53GbYPRMhVaJjjVfM, reason: not valid java name */
    public static /* synthetic */ void m2919$r8$lambda$zNBKbZeeR53GbYPRMhVaJjjVfM(SystemDataTransferProcessor r0, int r1, ISystemDataTransferCallback r2, byte[] r3) {
        r0.lambda$startSystemDataTransfer$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemDataTransferRequestStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemDataTransferRequestStore m2920$$Nest$fgetmSystemDataTransferRequestStore(SystemDataTransferProcessor r0) {
        return r0.mSystemDataTransferRequestStore;
    }

    /* JADX INFO: renamed from: -$$Nest$monReceivePermissionRestore, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2921$$Nest$monReceivePermissionRestore(SystemDataTransferProcessor r0, byte[] r1) {
        r0.onReceivePermissionRestore(r1);
    }

    public SystemDataTransferProcessor(CompanionDeviceManagerService service, PackageManagerInternal packageManager, AssociationStore associationStore, SystemDataTransferRequestStore systemDataTransferRequestStore, CompanionTransportManager transportManager) {
        final Handler r1 = Handler.getMain();
        this.mOnSystemDataTransferRequestConfirmationReceiver = new AnonymousClass2(this, r1);
        this.mContext = service.getContext();
        this.mPackageManager = packageManager;
        this.mAssociationStore = associationStore;
        this.mSystemDataTransferRequestStore = systemDataTransferRequestStore;
        this.mTransportManager = transportManager;
        IOnMessageReceivedListener messageListener = new AnonymousClass1(this);
        this.mTransportManager.addListener(1669491075, messageListener);
        this.mPermissionControllerManager = (PermissionControllerManager) this.mContext.getSystemService(PermissionControllerManager.class);
        this.mExecutor = Executors.newSingleThreadExecutor();
        this.mCompanionDeviceDataTransferActivity = ComponentName.createRelative(this.mContext.getString(R.string.config_defaultRotationResolverService), ".CompanionDeviceDataTransferActivity");
    }

    public boolean isPermissionTransferUserConsented(int associationId) {
        this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        PermissionSyncRequest request = getPermissionSyncRequest(associationId);
        if (request != null) goto L7;
        return false;
    L7:
        return request.isUserConsented();
    }

    public PendingIntent buildPermissionTransferUserConsentIntent(String packageName, int userId, final int associationId) {
        if (PackageUtils.isPermSyncAutoEnabled(this.mContext, this.mPackageManager, packageName) == false) goto L9;
        Slog.i(LOG_TAG, "User consent Intent should be skipped. Returning null.");
        if (getPermissionSyncRequest(associationId) != null) goto L11;
        SystemDataTransferRequest r1 = new PermissionSyncRequest(associationId);
        r1.setUserConsented(true);
        this.mSystemDataTransferRequestStore.writeRequest(userId, r1);
        return null;
    L11:
        return null;
    L9:
        Slog.i(LOG_TAG, "Creating permission sync intent for userId [" + userId + "] associationId [" + associationId + "]");
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        Bundle extras = new Bundle();
        PermissionSyncRequest request = new PermissionSyncRequest(associationId);
        request.setUserId(userId);
        extras.putParcelable(EXTRA_PERMISSION_SYNC_REQUEST, request);
        extras.putCharSequence(EXTRA_COMPANION_DEVICE_NAME, association.getDisplayName());
        extras.putParcelable(EXTRA_SYSTEM_DATA_TRANSFER_RESULT_RECEIVER, Utils.prepareForIpc(this.mOnSystemDataTransferRequestConfirmationReceiver));
        final Intent intent = new Intent();
        intent.setComponent(this.mCompanionDeviceDataTransferActivity);
        intent.putExtras(extras);
        return (PendingIntent) Binder.withCleanCallingIdentity(new SystemDataTransferProcessor$$ExternalSyntheticLambda3(this, associationId, intent));
    }

    private /* synthetic */ PendingIntent lambda$buildPermissionTransferUserConsentIntent$0(int associationId, Intent intent) throws Exception {
        return PendingIntent.getActivityAsUser(this.mContext, associationId, intent, 1409286144, ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1).toBundle(), UserHandle.CURRENT);
    }

    public void startSystemDataTransfer(String packageName, final int userId, final int associationId, final ISystemDataTransferCallback callback) {
        Slog.i(LOG_TAG, "Start system data transfer for package [" + packageName + "] userId [" + userId + "] associationId [" + associationId + "]");
        this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        PermissionSyncRequest request = getPermissionSyncRequest(associationId);
        if (request != null) goto L5;
    L9:
        String message = "User " + userId + " hasn't consented permission sync for associationId [" + associationId + ".";
        Slog.e(LOG_TAG, message);
        callback.onError(message);     // Catch: RemoteException -> L12
        return;
    L13:
        return;
    L5:
        if (request.isUserConsented() == false) goto L9;
        Binder.withCleanCallingIdentity(new SystemDataTransferProcessor$$ExternalSyntheticLambda4(this, userId, associationId, callback));
    }

    private /* synthetic */ void lambda$startSystemDataTransfer$2(int userId, final int associationId, final ISystemDataTransferCallback callback) throws Exception {
        this.mPermissionControllerManager.getRuntimePermissionBackup(UserHandle.of(userId), this.mExecutor, new SystemDataTransferProcessor$$ExternalSyntheticLambda1(this, associationId, callback));
    }

    private /* synthetic */ void lambda$startSystemDataTransfer$1(int associationId, ISystemDataTransferCallback callback, byte[] backup) {
        Future<?> future = this.mTransportManager.requestPermissionRestore(associationId, backup);
        translateFutureToCallback(future, callback);
    }

    public void enablePermissionsSync(int associationId) {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        int userId = association.getUserId();
        SystemDataTransferRequest r2 = new PermissionSyncRequest(associationId);
        r2.setUserConsented(true);
        this.mSystemDataTransferRequestStore.writeRequest(userId, r2);
    }

    public void disablePermissionsSync(int associationId) {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        int userId = association.getUserId();
        SystemDataTransferRequest r2 = new PermissionSyncRequest(associationId);
        r2.setUserConsented(false);
        this.mSystemDataTransferRequestStore.writeRequest(userId, r2);
    }

    public PermissionSyncRequest getPermissionSyncRequest(int associationId) {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        int userId = association.getUserId();
        List<SystemDataTransferRequest> requests = this.mSystemDataTransferRequestStore.readRequestsByAssociationId(userId, associationId);
        Iterator<SystemDataTransferRequest> r3 = requests.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        PermissionSyncRequest r4 = (SystemDataTransferRequest) r3.next();
        if ((r4 instanceof PermissionSyncRequest) == false) goto L4;
        return r4;
    L10:
        return null;
    }

    public void removePermissionSyncRequest(final int associationId) {
        Binder.withCleanCallingIdentity(new SystemDataTransferProcessor$$ExternalSyntheticLambda2(this, associationId));
    }

    private /* synthetic */ void lambda$removePermissionSyncRequest$3(int associationId) throws Exception {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        int userId = association.getUserId();
        this.mSystemDataTransferRequestStore.removeRequestsByAssociationId(userId, associationId);
    }

    private void onReceivePermissionRestore(final byte[] message) {
        if (Build.isDebuggable() == false) goto L5;
    L8:
        Slog.i(LOG_TAG, "Applying permissions.");
        final UserHandle user = this.mContext.getUser();
        Binder.withCleanCallingIdentity(new SystemDataTransferProcessor$$ExternalSyntheticLambda0(this, message, user));
        return;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == true) goto L8;
        Slog.e(LOG_TAG, "Permissions restore is only available on watch.");
    }

    private /* synthetic */ void lambda$onReceivePermissionRestore$4(byte[] message, UserHandle user) throws Exception {
        this.mPermissionControllerManager.stageAndApplyRuntimePermissionsBackup(message, user);
    }

    private static void translateFutureToCallback(Future<?> future, ISystemDataTransferCallback callback) {
        future.get(15, TimeUnit.SECONDS);     // Catch: Exception -> L6
        if (callback == null) goto L25;
        callback.onResult();     // Catch: Exception -> L6 RemoteException -> L8
        goto L19
    L26:
        return;
    L19:
        return;
    L25:
        return;
    L6:
        e = move-exception;
        if (callback == null) goto L28;
        callback.onError(e.getMessage());     // Catch: RemoteException -> L16
        return;
    L27:
        return;
    }
}
