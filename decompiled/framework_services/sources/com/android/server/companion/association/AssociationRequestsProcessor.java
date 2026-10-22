package com.android.server.companion.association;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.companion.AssociatedDevice;
import android.companion.AssociationInfo;
import android.companion.AssociationRequest;
import android.companion.DeviceId;
import android.companion.IAssociationRequestCallback;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.graphics.drawable.Icon;
import android.net.MacAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.companion.utils.PackageUtils;
import com.android.server.companion.utils.PermissionsUtils;
import com.android.server.companion.utils.RolesUtils;
import com.android.server.companion.utils.Utils;
import com.android.server.slice.SliceClientPermissions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AssociationRequestsProcessor {
    private static final int ASSOCIATE_WITHOUT_PROMPT_MAX_PER_TIME_WINDOW = 5;
    private static final long ASSOCIATE_WITHOUT_PROMPT_WINDOW_MS = 3600000;
    private static final Set<String> DEVICE_PROFILES_WITH_REQUIRED_CONFIRMATION = null;
    private static final String EXTRA_APPLICATION_CALLBACK = "application_callback";
    private static final String EXTRA_ASSOCIATION = "association";
    private static final String EXTRA_ASSOCIATION_REQUEST = "association_request";
    private static final String EXTRA_FORCE_CANCEL_CONFIRMATION = "cancel_confirmation";
    private static final String EXTRA_MAC_ADDRESS = "mac_address";
    private static final String EXTRA_RESULT_RECEIVER = "result_receiver";
    private static final int RESULT_CODE_ASSOCIATION_APPROVED = 0;
    private static final int RESULT_CODE_ASSOCIATION_CREATED = 0;
    private static final String TAG = "CDM_AssociationRequestsProcessor";
    private static final String XIAOMI_HEALTH_PACKAGE = "com.mi.health";
    private final AssociationStore mAssociationStore;
    private final ComponentName mCompanionAssociationActivity;
    private final Context mContext;
    private final ResultReceiver mOnRequestConfirmationReceiver;
    private final PackageManagerInternal mPackageManagerInternal;

    /* JADX INFO: renamed from: $r8$lambda$5cHcmgOU5-M7Ixh1vBBnUKnb5XQ, reason: not valid java name */
    public static /* synthetic */ Boolean m2902$r8$lambda$5cHcmgOU5M7Ixh1vBBnUKnb5XQ(AssociationRequestsProcessor r0, int r1, String r2, String r3) {
        return r0.lambda$willAddRoleHolder$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$CgqfujjRwuEbyDGRHVoyUJ7mJww(AssociationRequestsProcessor r0, String r1, AssociationInfo r2, IAssociationRequestCallback r3, ResultReceiver r4, Boolean r5) {
        r0.lambda$maybeGrantRoleAndStoreAssociation$1(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ PendingIntent $r8$lambda$cG0UJrFrYGi05qxlHW0uB_bcn7s(AssociationRequestsProcessor r0, int r1, Intent r2) {
        return r0.lambda$createPendingIntent$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$eimnE-Eo3AocyFnmHvXx98pMczo, reason: not valid java name */
    public static /* synthetic */ void m2903$r8$lambda$eimnEEo3AocyFnmHvXx98pMczo(AssociationRequestsProcessor r0, int r1, String r2, MacAddress r3, AssociationRequest r4, IAssociationRequestCallback r5, ResultReceiver r6) {
        r0.lambda$createAssociationAndNotifyApplication$0(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mprocessAssociationRequestApproval, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2904$$Nest$mprocessAssociationRequestApproval(AssociationRequestsProcessor r0, AssociationRequest r1, IAssociationRequestCallback r2, ResultReceiver r3, MacAddress r4) {
        r0.processAssociationRequestApproval(r1, r2, r3, r4);
    }

    static {
        DEVICE_PROFILES_WITH_REQUIRED_CONFIRMATION = new ArraySet(Arrays.asList(new String[]{"android.app.role.COMPANION_DEVICE_APP_STREAMING", "android.app.role.COMPANION_DEVICE_NEARBY_DEVICE_STREAMING"}));
    }

    public AssociationRequestsProcessor(Context context, PackageManagerInternal packageManagerInternal, AssociationStore associationStore) {
        final Handler r1 = Handler.getMain();
        this.mOnRequestConfirmationReceiver = new AnonymousClass1(this, r1);
        this.mContext = context;
        this.mPackageManagerInternal = packageManagerInternal;
        this.mAssociationStore = associationStore;
        this.mCompanionAssociationActivity = ComponentName.createRelative(this.mContext.getString(R.string.config_defaultRotationResolverService), ".CompanionAssociationActivity");
    }

    public void processNewAssociationRequest(AssociationRequest request, String packageName, int userId, IAssociationRequestCallback callback) {
        request.getClass();
        if (request.isSelfManaged() == false) goto L5;
        request.getDisplayName().getClass();
    L5:
        packageName.getClass();
        callback.getClass();
        int packageUid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        Slog.d(TAG, "processNewAssociationRequest() request=" + request + ", package=u" + userId + SliceClientPermissions.SliceAuthority.DELIMITER + packageName + " (uid=" + packageUid + ")");
        PermissionsUtils.enforcePermissionForCreatingAssociation(this.mContext, request, packageUid);
        PackageUtils.enforceUsesCompanionDeviceFeature(this.mContext, userId, packageName);
        if (request.isSelfManaged() == false) goto L19;
        if (request.isForceConfirmation() == true) goto L19;
        if (DEVICE_PROFILES_WITH_REQUIRED_CONFIRMATION.contains(request.getDeviceProfile()) == true) goto L19;
        if (willAddRoleHolder(request, packageName, userId) == true) goto L19;
        createAssociationAndNotifyApplication(request, packageName, userId, null, callback, null);
        return;
    L19:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == false) goto L25;
        Slog.e(TAG, "3p apps are not allowed to create associations on watch.");
        callback.onFailure(4, "3p apps are not allowed to create associations on watch.");     // Catch: RemoteException -> L23
        return;
    L24:
        return;
    L25:
        request.setPackageName(packageName);
        request.setUserId(userId);
        request.setSkipPrompt(mayAssociateWithoutPrompt(request, packageName, userId));
        Bundle extras = new Bundle();
        extras.putParcelable(EXTRA_ASSOCIATION_REQUEST, request);
        extras.putBinder(EXTRA_APPLICATION_CALLBACK, callback.asBinder());
        extras.putParcelable(EXTRA_RESULT_RECEIVER, Utils.prepareForIpc(this.mOnRequestConfirmationReceiver));
        Intent intent = new Intent();
        intent.setComponent(this.mCompanionAssociationActivity);
        intent.putExtras(extras);
        PendingIntent pendingIntent = createPendingIntent(packageUid, intent);
        callback.onAssociationPending(pendingIntent);     // Catch: RemoteException -> L28
        return;
    }

    public PendingIntent buildAssociationCancellationIntent(String packageName, int userId) {
        packageName.getClass();
        PackageUtils.enforceUsesCompanionDeviceFeature(this.mContext, userId, packageName);
        int packageUid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        Bundle extras = new Bundle();
        extras.putBoolean(EXTRA_FORCE_CANCEL_CONFIRMATION, true);
        Intent intent = new Intent();
        intent.setComponent(this.mCompanionAssociationActivity);
        intent.putExtras(extras);
        return createPendingIntent(packageUid, intent);
    }

    private void processAssociationRequestApproval(AssociationRequest request, IAssociationRequestCallback callback, ResultReceiver resultReceiver, MacAddress macAddress) {
        String packageName = request.getPackageName();
        int userId = request.getUserId();
        int packageUid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        PermissionsUtils.enforcePermissionForCreatingAssociation(this.mContext, request, packageUid);     // Catch: SecurityException -> L6
        createAssociationAndNotifyApplication(request, packageName, userId, macAddress, callback, resultReceiver);
        return;
    L6:
        e = move-exception;
        callback.onFailure(4, e.getMessage());     // Catch: RemoteException -> L10
        return;
    }

    private void createAssociationAndNotifyApplication(final AssociationRequest request, final String packageName, final int userId, final MacAddress macAddress, final IAssociationRequestCallback callback, final ResultReceiver resultReceiver) {
        Binder.withCleanCallingIdentity(new AssociationRequestsProcessor$$ExternalSyntheticLambda3(this, userId, packageName, macAddress, request, callback, resultReceiver));
    }

    private /* synthetic */ void lambda$createAssociationAndNotifyApplication$0(int userId, String packageName, MacAddress macAddress, AssociationRequest request, IAssociationRequestCallback callback, ResultReceiver resultReceiver) throws Exception {
        createAssociation(userId, packageName, macAddress, request.getDisplayName(), request.getDeviceProfile(), request.getAssociatedDevice(), request.isSelfManaged(), callback, resultReceiver, request.getDeviceIcon(), false);
    }

    public void createAssociation(int userId, String packageName, MacAddress macAddress, CharSequence displayName, String deviceProfile, AssociatedDevice associatedDevice, boolean selfManaged, IAssociationRequestCallback callback, ResultReceiver resultReceiver, Icon deviceIcon, boolean skipRoleGrant) {
        int id = this.mAssociationStore.getNextId();
        long timestamp = System.currentTimeMillis();
        AssociationInfo association = new AssociationInfo(id, userId, packageName, macAddress, displayName, deviceProfile, associatedDevice, selfManaged, false, false, false, timestamp, Long.MAX_VALUE, 0, deviceIcon, null);
        if (skipRoleGrant == false) goto L5;
        Slog.i(TAG, "Created association for " + association.getDeviceProfile() + " and userId=" + association.getUserId() + ", packageName=" + association.getPackageName() + " without granting role");
        this.mAssociationStore.addAssociation(association);
        sendCallbackAndFinish(association, callback, resultReceiver);
        return;
    L5:
        maybeGrantRoleAndStoreAssociation(association, callback, resultReceiver);
    }

    public void maybeGrantRoleAndStoreAssociation(final AssociationInfo association, final IAssociationRequestCallback callback, final ResultReceiver resultReceiver) {
        final String deviceProfile = association.getDeviceProfile();
        if (deviceProfile == null) goto L10;
        if (RolesUtils.isRolelessProfile(deviceProfile) == true) goto L10;
        RolesUtils.addRoleHolderForAssociation(this.mContext, association, new AssociationRequestsProcessor$$ExternalSyntheticLambda0(this, deviceProfile, association, callback, resultReceiver));
        return;
    L10:
        this.mAssociationStore.addAssociation(association);
        sendCallbackAndFinish(association, callback, resultReceiver);
    }

    private /* synthetic */ void lambda$maybeGrantRoleAndStoreAssociation$1(String deviceProfile, AssociationInfo association, IAssociationRequestCallback callback, ResultReceiver resultReceiver, Boolean success) {
        if (success.booleanValue() == false) goto L5;
        Slog.i(TAG, "Added " + deviceProfile + " role to userId=" + association.getUserId() + ", packageName=" + association.getPackageName());
        this.mAssociationStore.addAssociation(association);
        sendCallbackAndFinish(association, callback, resultReceiver);
        return;
    L5:
        Slog.e(TAG, "Failed to add u" + association.getUserId() + "\\" + association.getPackageName() + " to the list of " + deviceProfile + " holders.");
        sendCallbackAndFinish(null, callback, resultReceiver);
    }

    public void enableSystemDataSync(int associationId, int flags) {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        AssociationInfo updated = new AssociationInfo.Builder(association).setSystemDataSyncFlags(association.getSystemDataSyncFlags() | flags).build();
        this.mAssociationStore.updateAssociation(updated);
    }

    public void disableSystemDataSync(int associationId, int flags) {
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        AssociationInfo updated = new AssociationInfo.Builder(association).setSystemDataSyncFlags(association.getSystemDataSyncFlags() & (~flags)).build();
        this.mAssociationStore.updateAssociation(updated);
    }

    public void setDeviceId(int associationId, DeviceId deviceId) {
        Slog.i(TAG, "Setting DeviceId=[" + deviceId + "] to id=[" + associationId + "]...");
        AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(associationId);
        this.mAssociationStore.updateAssociation(new AssociationInfo.Builder(association).setDeviceId(deviceId).build());
    }

    private void sendCallbackAndFinish(AssociationInfo association, IAssociationRequestCallback callback, ResultReceiver resultReceiver) {
        if (association == null) goto L10;
        if (callback != null) goto L19;
    L7:
        if (resultReceiver == null) goto L21;
        Bundle data = new Bundle();
        data.putParcelable(EXTRA_ASSOCIATION, association);
        resultReceiver.send(0, data);
        return;
    L21:
        return;
    L19:
        callback.onAssociationCreated(association);     // Catch: RemoteException -> L6
        goto L7
    L10:
        if (callback != null) goto L17;
    L14:
        if (resultReceiver == null) goto L23;
        resultReceiver.send(3, new Bundle());
        return;
    L23:
        return;
    L17:
        callback.onFailure(3, "Association doesn't exist.");     // Catch: RemoteException -> L13
        goto L14
    }

    private boolean willAddRoleHolder(AssociationRequest request, final String packageName, final int userId) {
        final String deviceProfile = request.getDeviceProfile();
        if (deviceProfile != null) goto L5;
        return false;
    L5:
        if (RolesUtils.isRolelessProfile(deviceProfile) == true) goto L11;
        boolean isRoleHolder = ((Boolean) Binder.withCleanCallingIdentity(new AssociationRequestsProcessor$$ExternalSyntheticLambda2(this, userId, packageName, deviceProfile))).booleanValue();
        return !isRoleHolder;
    L11:
        return false;
    }

    private /* synthetic */ Boolean lambda$willAddRoleHolder$2(int userId, String packageName, String deviceProfile) throws Exception {
        return Boolean.valueOf(RolesUtils.isRoleHolder(this.mContext, userId, packageName, deviceProfile));
    }

    private PendingIntent createPendingIntent(final int packageUid, final Intent intent) {
        return (PendingIntent) Binder.withCleanCallingIdentity(new AssociationRequestsProcessor$$ExternalSyntheticLambda1(this, packageUid, intent));
    }

    private /* synthetic */ PendingIntent lambda$createPendingIntent$3(int packageUid, Intent intent) throws Exception {
        return PendingIntent.getActivityAsUser(this.mContext, packageUid, intent, 1409286144, ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(1).toBundle(), UserHandle.CURRENT);
    }

    private boolean mayAssociateWithoutPrompt(AssociationRequest request, String packageName, int userId) {
        long now = System.currentTimeMillis();
        List<AssociationInfo> associationForPackage = this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName);
        int recent = 0;
        Iterator<AssociationInfo> r4 = associationForPackage.iterator();
    L3:
        boolean isRecent = true;
        if (r4.hasNext() == false) goto L16;
        AssociationInfo association = r4.next();
        if ((now - association.getTimeApprovedMs()) < 3600000) goto L9;
        isRecent = false;
    L9:
        if (isRecent == false) goto L3;
        recent = recent + 1;
        if (recent < 5) goto L3;
        Slog.w(TAG, "Too many associations: " + packageName + " already associated " + recent + " devices within the last 3600000ms");
        return false;
    L16:
        if (XIAOMI_HEALTH_PACKAGE.equals(packageName) == false) goto L22;
        if ("android.app.role.COMPANION_DEVICE_WATCH".equals(request.getDeviceProfile()) == false) goto L22;
        Slog.i(TAG, "Allowing " + packageName + " watch association without CDM prompt.");
        return true;
    L22:
        return PackageUtils.isPackageAllowlisted(this.mContext, this.mPackageManagerInternal, packageName);
    }
}
