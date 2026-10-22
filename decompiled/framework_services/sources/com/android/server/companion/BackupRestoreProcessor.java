package com.android.server.companion;

import android.companion.AssociationInfo;
import android.companion.datatransfer.SystemDataTransferRequest;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManagerInternal;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.CollectionUtils;
import com.android.server.companion.association.AssociationDiskStore;
import com.android.server.companion.association.AssociationRequestsProcessor;
import com.android.server.companion.association.AssociationStore;
import com.android.server.companion.association.Associations;
import com.android.server.companion.datatransfer.SystemDataTransferRequestStore;
import com.android.server.companion.utils.RolesUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
class BackupRestoreProcessor {
    private static final int BACKUP_AND_RESTORE_VERSION = 0;
    private static final String TAG = "CDM_BackupRestoreProcessor";
    private final AssociationDiskStore mAssociationDiskStore;
    private final AssociationRequestsProcessor mAssociationRequestsProcessor;
    private final AssociationStore mAssociationStore;
    private final Context mContext;
    private final PackageManagerInternal mPackageManagerInternal;
    private final SystemDataTransferRequestStore mSystemDataTransferRequestStore;

    /* JADX INFO: renamed from: $r8$lambda$DyV-WVlS-Kk4PIRN0FrbMj0nlWE, reason: not valid java name */
    public static /* synthetic */ boolean m2883$r8$lambda$DyVWVlSKk4PIRN0FrbMj0nlWE(AssociationInfo r0, SystemDataTransferRequest r1) {
        return lambda$applyRestoredPayload$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JIdOXdUl_K6TEHMMcvRCDJvcUDo(BackupRestoreProcessor r0, AssociationInfo r1, AssociationInfo r2, Boolean r3) {
        r0.lambda$restorePendingAssociations$2(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$KaaBuRoJlP5hxFXWvNSfy9Fph8Y(AssociationInfo r0, AssociationInfo r1) {
        return lambda$handleCollision$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZI_ky7rF-P1GL62m8KHTAW0h5-o, reason: not valid java name */
    public static /* synthetic */ boolean m2884$r8$lambda$ZI_ky7rFP1GL62m8KHTAW0h5o(SystemDataTransferRequest r0, SystemDataTransferRequest r1) {
        return lambda$handleCollision$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ge7zP4zZ0ZlLddnXsQ-WJKdBIhk, reason: not valid java name */
    public static /* synthetic */ boolean m2885$r8$lambda$ge7zP4zZ0ZlLddnXsQWJKdBIhk(String r0, ApplicationInfo r1) {
        return lambda$applyRestoredPayload$1(r0, r1);
    }

    BackupRestoreProcessor(Context context, PackageManagerInternal packageManagerInternal, AssociationStore associationStore, AssociationDiskStore associationDiskStore, SystemDataTransferRequestStore systemDataTransferRequestStore, AssociationRequestsProcessor associationRequestsProcessor) {
        this.mContext = context;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mAssociationStore = associationStore;
        this.mAssociationDiskStore = associationDiskStore;
        this.mSystemDataTransferRequestStore = systemDataTransferRequestStore;
        this.mAssociationRequestsProcessor = associationRequestsProcessor;
    }

    byte[] getBackupPayload(int userId) {
        Slog.i(TAG, "getBackupPayload() userId=[" + userId + "].");
        byte[] associationsPayload = this.mAssociationDiskStore.getBackupPayload(userId);
        int associationsPayloadLength = associationsPayload.length;
        byte[] requestsPayload = this.mSystemDataTransferRequestStore.getBackupPayload(userId);
        int requestsPayloadLength = requestsPayload.length;
        int payloadSize = (associationsPayloadLength + 12) + requestsPayloadLength;
        return ByteBuffer.allocate(payloadSize).putInt(0).putInt(associationsPayloadLength).put(associationsPayload).putInt(requestsPayloadLength).put(requestsPayload).array();
    }

    void applyRestoredPayload(byte[] payload, int userId) {
        Slog.i(TAG, "applyRestoredPayload() userId=[" + userId + "], payload size=[" + payload.length + "].");
        if (payload.length != 0) goto L6;
        Slog.i(TAG, "CDM backup payload was empty.");
        return;
    L6:
        ByteBuffer buffer = ByteBuffer.wrap(payload);
        int version = buffer.getInt();
        if (version == 0) goto L33;
        Slog.e(TAG, "Unsupported backup payload version");
        return;
    L33:
        byte[] associationsPayload = new byte[buffer.getInt()];     // Catch: Exception -> L30
        buffer.get(associationsPayload);     // Catch: Exception -> L30
        byte[] requestsPayload = new byte[buffer.getInt()];     // Catch: Exception -> L30
        buffer.get(requestsPayload);     // Catch: Exception -> L30
        Associations restoredAssociations = AssociationDiskStore.readAssociationsFromPayload(associationsPayload, userId);
        List<SystemDataTransferRequest> restoredRequestsForUser = this.mSystemDataTransferRequestStore.readRequestsFromPayload(requestsPayload, userId);
        List<ApplicationInfo> installedApps = this.mPackageManagerInternal.getInstalledApplications(0, userId, UserHandle.getCallingUserId());
        Iterator<AssociationInfo> r10 = restoredAssociations.getAssociations().iterator();
    L13:
        if (r10.hasNext() == false) goto L29;
        final AssociationInfo restored = r10.next();
        if (restored.isRevoked() == true) goto L13;
        List<SystemDataTransferRequest> restoredRequests = CollectionUtils.filter(restoredRequestsForUser, new BackupRestoreProcessor$$ExternalSyntheticLambda0(restored));
        if (handleCollision(userId, restored, restoredRequests) == true) goto L13;
        final String packageName = restored.getPackageName();
        int newId = this.mAssociationStore.getNextId();
        AssociationInfo newAssociation = new AssociationInfo.Builder(newId, userId, packageName, restored).build();
        byte[] associationsPayload2 = associationsPayload;
        boolean isPackageInstalled = installedApps.stream().anyMatch(new BackupRestoreProcessor$$ExternalSyntheticLambda1(packageName));
        if (isPackageInstalled == false) goto L23;
        this.mAssociationRequestsProcessor.maybeGrantRoleAndStoreAssociation(newAssociation, null, null);
    L24:
        Iterator<SystemDataTransferRequest> r0 = restoredRequests.iterator();
    L26:
        if (r0.hasNext() == false) goto L28;
        SystemDataTransferRequest restoredRequest = r0.next();
        Iterator<SystemDataTransferRequest> r18 = r0;
        SystemDataTransferRequest newRequest = restoredRequest.copyWithNewId(newId);
        newRequest.setUserId(userId);
        this.mSystemDataTransferRequestStore.writeRequest(userId, newRequest);
        r0 = r18;
        goto L26
    L28:
        associationsPayload = associationsPayload2;
        goto L13
    L23:
        this.mAssociationStore.addAssociation(new AssociationInfo.Builder(newAssociation).setPending(true).build());
        goto L24
    L29:
        return;
    L30:
        bufferException = move-exception;
        Slog.e(TAG, "CDM backup payload was mal-formatted.", bufferException);
    }

    private static /* synthetic */ boolean lambda$applyRestoredPayload$0(AssociationInfo restored, SystemDataTransferRequest it) {
        if (it.getAssociationId() != restored.getId()) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$applyRestoredPayload$1(String packageName, ApplicationInfo app) {
        return packageName.equals(app.packageName);
    }

    public void restorePendingAssociations(int userId, String packageName) {
        List<AssociationInfo> pendingAssociations = this.mAssociationStore.getPendingAssociations(userId, packageName);
        if (pendingAssociations.isEmpty() == true) goto L5;
        Slog.i(TAG, "Found pending associations for package=[" + packageName + "]. Restoring...");
    L5:
        Iterator<AssociationInfo> r1 = pendingAssociations.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        final AssociationInfo association = r1.next();
        final AssociationInfo newAssociation = new AssociationInfo.Builder(association).setPending(false).build();
        RolesUtils.addRoleHolderForAssociation(this.mContext, newAssociation, new BackupRestoreProcessor$$ExternalSyntheticLambda2(this, newAssociation, association));
        goto L7
    }

    private /* synthetic */ void lambda$restorePendingAssociations$2(AssociationInfo newAssociation, AssociationInfo association, Boolean success) {
        if (success.booleanValue() == false) goto L5;
        this.mAssociationStore.updateAssociation(newAssociation);
        Slog.i(TAG, "Association=[" + association + "] is restored.");
        return;
    L5:
        Slog.e(TAG, "Failed to restore association=[" + association + "].");
    }

    private boolean handleCollision(int userId, final AssociationInfo restored, List<SystemDataTransferRequest> restoredRequests) {
        List<AssociationInfo> localAssociations = this.mAssociationStore.getActiveAssociationsByPackage(restored.getUserId(), restored.getPackageName());
        Predicate<AssociationInfo> isSameDevice = new BackupRestoreProcessor$$ExternalSyntheticLambda3(restored);
        AssociationInfo local = (AssociationInfo) CollectionUtils.find(localAssociations, isSameDevice);
        if (local != null) goto L6;
        return false;
    L6:
        Slog.d(TAG, "Conflict detected with association id=" + local.getId() + " while restoring CDM backup. Keeping local association.");
        List<SystemDataTransferRequest> localRequests = this.mSystemDataTransferRequestStore.readRequestsByAssociationId(userId, local.getId());
        Iterator<SystemDataTransferRequest> r5 = restoredRequests.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        final SystemDataTransferRequest restoredRequest = r5.next();
        boolean requestTypeExists = CollectionUtils.any(localRequests, new BackupRestoreProcessor$$ExternalSyntheticLambda4(restoredRequest));
        if (requestTypeExists == true) goto L8;
        Slog.d(TAG, "Restoring " + restoredRequest.getClass().getSimpleName() + " to an existing association id=[" + local.getId() + "].");
        SystemDataTransferRequest newRequest = restoredRequest.copyWithNewId(local.getId());
        newRequest.setUserId(userId);
        this.mSystemDataTransferRequestStore.writeRequest(userId, newRequest);
        goto L8
    L13:
        return true;
    }

    private static /* synthetic */ boolean lambda$handleCollision$3(AssociationInfo restored, AssociationInfo associationInfo) {
        boolean matchesMacAddress = Objects.equals(associationInfo.getDeviceMacAddress(), restored.getDeviceMacAddress());
        if (associationInfo.getDeviceId() != null) goto L5;
    L7:
        boolean matchesDeviceId = false;
    L9:
        if (matchesMacAddress == true) goto L12;
        if (matchesDeviceId == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (associationInfo.getDeviceId().isSameDevice(restored.getDeviceId()) == false) goto L7;
        matchesDeviceId = true;
        goto L9
    }

    private static /* synthetic */ boolean lambda$handleCollision$4(SystemDataTransferRequest restoredRequest, SystemDataTransferRequest request) {
        if (request.getDataType() != restoredRequest.getDataType()) goto L5;
        return true;
    L5:
        return false;
    }
}
