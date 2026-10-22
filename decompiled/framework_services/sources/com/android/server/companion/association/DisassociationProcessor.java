package com.android.server.companion.association;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.companion.AssociationInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.CollectionUtils;
import com.android.server.companion.datatransfer.SystemDataTransferRequestStore;
import com.android.server.companion.devicepresence.CompanionAppBinder;
import com.android.server.companion.devicepresence.DevicePresenceProcessor;
import com.android.server.companion.transport.CompanionTransportManager;
import com.android.server.companion.utils.RolesUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class DisassociationProcessor {
    private static final long ASSOCIATION_REMOVAL_TIME_WINDOW_DEFAULT = 0;
    public static final String REASON_API = "api";
    public static final String REASON_LEGACY = "legacy";
    public static final String REASON_PKG_DATA_CLEARED = "pkg-data-cleared";
    public static final String REASON_REVOKED = "revoked";
    public static final String REASON_SELF_IDLE = "self-idle";
    public static final String REASON_SHELL = "shell";
    private static final String SYS_PROP_DEBUG_REMOVAL_TIME_WINDOW = "debug.cdm.cdmservice.removal_time_window";
    private static final String TAG = "CDM_DisassociationProcessor";
    private final ActivityManager mActivityManager;
    private final AssociationStore mAssociationStore;
    private final CompanionAppBinder mCompanionAppController;
    private final Context mContext;
    private final DevicePresenceProcessor mDevicePresenceMonitor;
    private final NotificationManager mNotificationManager;
    private final OnPackageVisibilityChangeListener mOnPackageVisibilityChangeListener;
    private final PackageManager mPackageManager;
    private final PackageManagerInternal mPackageManagerInternal;
    private final SystemDataTransferRequestStore mSystemDataTransferRequestStore;
    private final CompanionTransportManager mTransportManager;

    private class OnPackageVisibilityChangeListener implements ActivityManager.OnUidImportanceListener {
        final /* synthetic */ DisassociationProcessor this$0;

        /* synthetic */ OnPackageVisibilityChangeListener(DisassociationProcessor r1, DisassociationProcessorIA r2) {
            this(r1);
        }

        private OnPackageVisibilityChangeListener(DisassociationProcessor r1) {
            this.this$0 = r1;
        }

        public void onUidImportance(int uid, int importance) {
            if (importance > 100) goto L5;
            return;
        L5:
            String[] packageNames = DisassociationProcessor.m2914$$Nest$fgetmPackageManager(this.this$0).getPackagesForUid(uid);
            if (packageNames != null) goto L8;
            return;
        L8:
            if (packageNames.length == 0) goto L25;
            int userId = UserHandle.getUserId(uid);
            int r2 = packageNames.length;
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L18;
            String packageName = packageNames[r3];
            Iterator<AssociationInfo> r5 = DisassociationProcessor.m2913$$Nest$fgetmAssociationStore(this.this$0).getRevokedAssociations(userId, packageName).iterator();
        L14:
            if (r5.hasNext() == false) goto L16;
            AssociationInfo association = r5.next();
            this.this$0.disassociate(association.getId(), DisassociationProcessor.REASON_REVOKED);
            goto L14
        L16:
            r3 = r3 + 1;
            goto L11
        L18:
            if (DisassociationProcessor.m2913$$Nest$fgetmAssociationStore(this.this$0).getRevokedAssociations().isEmpty() == false) goto L24;
            DisassociationProcessor.m2915$$Nest$mstopListening(this.this$0);
            return;
        L24:
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$47sq2Nj-NrVpeXlanjXrxGINZIw, reason: not valid java name */
    public static /* synthetic */ Integer m2910$r8$lambda$47sq2NjNrVpeXlanjXrxGINZIw(DisassociationProcessor r0, String r1, int r2) {
        return r0.lambda$getPackageProcessImportance$3(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$GY1a2aChEJmoyp6c_NMCfmIZkhY(DisassociationProcessor r0) {
        r0.lambda$stopListening$5();
    }

    public static /* synthetic */ void $r8$lambda$HHQRKhyk7AdCoimgnli3m2p6aiw(DisassociationProcessor r0) {
        r0.lambda$startListening$4();
    }

    /* JADX INFO: renamed from: $r8$lambda$VaKvyLTKXIyQg-NojqqfRS9J0Vc, reason: not valid java name */
    public static /* synthetic */ boolean m2911$r8$lambda$VaKvyLTKXIyQgNojqqfRS9J0Vc(String r0, int r1, AssociationInfo r2) {
        return lambda$disassociate$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$fxs-KBH0DInedDwjab-IDffzEmw, reason: not valid java name */
    public static /* synthetic */ void m2912$r8$lambda$fxsKBH0DInedDwjabIDffzEmw(DisassociationProcessor r0, int r1, String r2, AssociationInfo r3) {
        r0.lambda$disassociate$1(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$yA0R16GPX_xx7qUdTGXbnJu5_SE(DisassociationProcessor r0, AssociationInfo r1) {
        return r0.lambda$disassociate$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAssociationStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ AssociationStore m2913$$Nest$fgetmAssociationStore(DisassociationProcessor r0) {
        return r0.mAssociationStore;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m2914$$Nest$fgetmPackageManager(DisassociationProcessor r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mstopListening, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2915$$Nest$mstopListening(DisassociationProcessor r0) {
        r0.stopListening();
    }

    static {
        ASSOCIATION_REMOVAL_TIME_WINDOW_DEFAULT = TimeUnit.DAYS.toMillis(90);
    }

    public DisassociationProcessor(Context context, ActivityManager activityManager, AssociationStore associationStore, PackageManagerInternal packageManager, DevicePresenceProcessor devicePresenceMonitor, CompanionAppBinder applicationController, SystemDataTransferRequestStore systemDataTransferRequestStore, CompanionTransportManager companionTransportManager, NotificationManager notificationManager) {
        this.mContext = context;
        this.mActivityManager = activityManager;
        this.mAssociationStore = associationStore;
        this.mPackageManagerInternal = packageManager;
        this.mOnPackageVisibilityChangeListener = new OnPackageVisibilityChangeListener(this, null);
        this.mDevicePresenceMonitor = devicePresenceMonitor;
        this.mCompanionAppController = applicationController;
        this.mSystemDataTransferRequestStore = systemDataTransferRequestStore;
        this.mTransportManager = companionTransportManager;
        this.mNotificationManager = notificationManager;
        this.mPackageManager = context.getPackageManager();
    }

    public void disassociate(final int id, String reason) {
        Slog.i(TAG, "Disassociating id=[" + id + "]...");
        final AssociationInfo association = this.mAssociationStore.getAssociationWithCallerChecks(id);
        final int userId = association.getUserId();
        final String packageName = association.getPackageName();
        final String deviceProfile = association.getDeviceProfile();
        if (deviceProfile != null) goto L5;
    L7:
        boolean isRoleInUseByOtherAssociations = false;
    L8:
        int packageProcessImportance = getPackageProcessImportance(userId, packageName);
        if (packageProcessImportance > 100) goto L14;
        if (deviceProfile == null) goto L14;
        if (isRoleInUseByOtherAssociations == true) goto L14;
        Slog.i(TAG, "Cannot disassociate id=[" + id + "] now - process is visible. Start listening to package importance...");
        AssociationInfo revokedAssociation = new AssociationInfo.Builder(association).setRevoked(true).build();
        this.mAssociationStore.updateAssociation(revokedAssociation);
        startListening();
        return;
    L14:
        this.mTransportManager.detachSystemDataTransport(id);
        this.mSystemDataTransferRequestStore.removeRequestsByAssociationId(userId, id);
        this.mAssociationStore.removeAssociation(association.getId(), reason);
        Binder.withCleanCallingIdentity(new DisassociationProcessor$$ExternalSyntheticLambda2(this, userId, packageName, association));
        if (isRoleInUseByOtherAssociations == true) goto L20;
        if (deviceProfile == null) goto L20;
        if (deviceProfile.equals("android.app.role.SYSTEM_AUTOMOTIVE_PROJECTION") == true) goto L20;
        RolesUtils.removeRoleHolderForAssociation(this.mContext, association.getUserId(), association.getPackageName(), association.getDeviceProfile());
    L20:
        boolean wasPresent = this.mDevicePresenceMonitor.isDevicePresent(id);
        if (wasPresent == true) goto L23;
        return;
    L23:
        if (association.isNotifyOnDeviceNearby() == false) goto L31;
        boolean shouldStayBound = CollectionUtils.any(this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName), new DisassociationProcessor$$ExternalSyntheticLambda3(this));
        if (shouldStayBound == true) goto L30;
        this.mCompanionAppController.unbindCompanionApp(userId, packageName);
        return;
    L30:
        return;
    L31:
        return;
    L5:
        if (CollectionUtils.any(this.mAssociationStore.getActiveAssociationsByPackage(userId, packageName), new DisassociationProcessor$$ExternalSyntheticLambda1(deviceProfile, id)) == false) goto L7;
        isRoleInUseByOtherAssociations = true;
        goto L8
    }

    private static /* synthetic */ boolean lambda$disassociate$0(String deviceProfile, int id, AssociationInfo it) {
        if (deviceProfile.equals(it.getDeviceProfile()) == true) goto L5;
    L7:
        return false;
    L5:
        if (id == it.getId()) goto L7;
        return true;
    }

    private /* synthetic */ void lambda$disassociate$1(int userId, String packageName, AssociationInfo association) throws Exception {
        if (this.mAssociationStore.getAssociationsByPackage(userId, packageName).isEmpty() == true) goto L5;
        return;
    L5:
        if (association.getDeviceProfile() != null) goto L7;
        return;
    L7:
        if (RolesUtils.NLS_PROFILES.contains(association.getDeviceProfile()) == false) goto L22;
        Intent nlsIntent = new Intent("android.service.notification.NotificationListenerService");
        List<ResolveInfo> matchedServiceList = this.mContext.getPackageManager().queryIntentServicesAsUser(nlsIntent, 0, userId);
        Iterator<ResolveInfo> r3 = matchedServiceList.iterator();
    L10:
        if (r3.hasNext() == false) goto L23;
        ResolveInfo service = r3.next();
        if (service.getComponentInfo().getComponentName().getPackageName().equals(packageName) == false) goto L10;
        this.mNotificationManager.setNotificationListenerAccessGranted(service.getComponentInfo().getComponentName(), false, false);
        goto L10
    L23:
        return;
    }

    private /* synthetic */ boolean lambda$disassociate$2(AssociationInfo it) {
        if (it.isNotifyOnDeviceNearby() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mDevicePresenceMonitor.isDevicePresent(it.getId()) == false) goto L7;
        return true;
    }

    @Deprecated
    public void disassociate(int userId, String packageName, String macAddress) {
        AssociationInfo association = this.mAssociationStore.getFirstAssociationByAddress(userId, packageName, macAddress);
        if (association == null) goto L7;
        this.mAssociationStore.getAssociationWithCallerChecks(association.getId());
        disassociate(association.getId(), REASON_LEGACY);
        return;
    L7:
        throw new IllegalArgumentException("Association for mac address=[" + macAddress + "] doesn't exist");
    }

    private int getPackageProcessImportance(final int userId, final String packageName) {
        return ((Integer) Binder.withCleanCallingIdentity(new DisassociationProcessor$$ExternalSyntheticLambda5(this, packageName, userId))).intValue();
    }

    private /* synthetic */ Integer lambda$getPackageProcessImportance$3(String packageName, int userId) throws Exception {
        int uid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        return Integer.valueOf(this.mActivityManager.getUidImportance(uid));
    }

    private void startListening() {
        Slog.i(TAG, "Start listening to uid importance changes...");
        Binder.withCleanCallingIdentity(new DisassociationProcessor$$ExternalSyntheticLambda4(this));     // Catch: IllegalArgumentException -> L5
        return;
    L6:
        Slog.e(TAG, "Failed to start listening to uid importance changes.");
    }

    private /* synthetic */ void lambda$startListening$4() throws Exception {
        this.mActivityManager.addOnUidImportanceListener(this.mOnPackageVisibilityChangeListener, 200);
    }

    private void stopListening() {
        Slog.i(TAG, "Stop listening to uid importance changes.");
        Binder.withCleanCallingIdentity(new DisassociationProcessor$$ExternalSyntheticLambda0(this));     // Catch: IllegalArgumentException -> L5
        return;
    L6:
        Slog.e(TAG, "Failed to stop listening to uid importance changes.");
    }

    private /* synthetic */ void lambda$stopListening$5() throws Exception {
        this.mActivityManager.removeOnUidImportanceListener(this.mOnPackageVisibilityChangeListener);
    }

    public void removeIdleSelfManagedAssociations() {
        Slog.i(TAG, "Removing idle self-managed associations.");
        long currentTime = System.currentTimeMillis();
        long removalWindow = SystemProperties.getLong(SYS_PROP_DEBUG_REMOVAL_TIME_WINDOW, -1);
        if (removalWindow > 0) goto L5;
        removalWindow = ASSOCIATION_REMOVAL_TIME_WINDOW_DEFAULT;
    L5:
        Iterator<AssociationInfo> r0 = this.mAssociationStore.getAssociations().iterator();
    L7:
        if (r0.hasNext() == false) goto L18;
        AssociationInfo association = r0.next();
        if (association.isSelfManaged() == false) goto L7;
        if ((currentTime - association.getLastTimeConnectedMs()) < removalWindow) goto L14;
        boolean isInactive = true;
    L15:
        if (isInactive == false) goto L7;
        int id = association.getId();
        Slog.i(TAG, "Removing inactive self-managed association=[" + association.toShortString() + "].");
        disassociate(id, REASON_SELF_IDLE);
        goto L7
    L14:
        isInactive = false;
        goto L15
    }
}
