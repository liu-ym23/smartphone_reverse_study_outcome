package com.android.server.telecom;

import android.app.role.RoleManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManagerInternal;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.telecom.DefaultDialerManager;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.util.IntArray;
import android.util.Slog;
import com.android.internal.telecom.ITelecomLoader;
import com.android.internal.telecom.ITelecomService;
import com.android.internal.telephony.SmsApplication;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.permission.LegacyPermissionManagerInternal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TelecomLoaderService extends SystemService {
    private static final String SERVICE_ACTION = "com.android.ITelecomService";
    private static final ComponentName SERVICE_COMPONENT = null;
    private static final String TAG = "TelecomLoaderService";
    private final Context mContext;
    private IntArray mDefaultSimCallManagerRequests;
    private final Object mLock;
    private TelecomServiceConnection mServiceConnection;
    private InternalServiceRepository mServiceRepo;

    private class TelecomServiceConnection implements ServiceConnection {
        final /* synthetic */ TelecomLoaderService this$0;

        /* synthetic */ TelecomServiceConnection(TelecomLoaderService r1, TelecomLoaderServiceIA r2) {
            this(r1);
        }

        private TelecomServiceConnection(TelecomLoaderService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            ITelecomLoader telecomLoader = ITelecomLoader.Stub.asInterface(service);     // Catch: RemoteException -> L17
            PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: RemoteException -> L17
            ITelecomService telecomService = telecomLoader.createTelecomService(TelecomLoaderService.m8460$$Nest$fgetmServiceRepo(this.this$0), packageManagerInternal.getSystemUiServiceComponent().getPackageName());     // Catch: RemoteException -> L17
            SmsApplication.getDefaultMmsApplication(TelecomLoaderService.m8457$$Nest$fgetmContext(this.this$0), false);     // Catch: RemoteException -> L17
            ServiceManager.addService("telecom", telecomService.asBinder());     // Catch: RemoteException -> L17
            Object r3 = TelecomLoaderService.m8459$$Nest$fgetmLock(this.this$0);     // Catch: RemoteException -> L17
            monitor-enter(r3);     // Catch: RemoteException -> L17
            LegacyPermissionManagerInternal permissionManager = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);     // Catch: Throwable -> L11
            if (TelecomLoaderService.m8458$$Nest$fgetmDefaultSimCallManagerRequests(this.this$0) == null) goto L13;
            TelecomManager telecomManager = (TelecomManager) TelecomLoaderService.m8457$$Nest$fgetmContext(this.this$0).getSystemService("telecom");     // Catch: Throwable -> L11
            PhoneAccountHandle phoneAccount = telecomManager.getSimCallManager();     // Catch: Throwable -> L11
            if (phoneAccount == null) goto L13;
            int requestCount = TelecomLoaderService.m8458$$Nest$fgetmDefaultSimCallManagerRequests(this.this$0).size();     // Catch: Throwable -> L11
            String packageName = phoneAccount.getComponentName().getPackageName();     // Catch: Throwable -> L11
            int i = requestCount - 1;     // Catch: Throwable -> L11
        L9:
            if (i < 0) goto L13;
            int userId = TelecomLoaderService.m8458$$Nest$fgetmDefaultSimCallManagerRequests(this.this$0).get(i);     // Catch: Throwable -> L11
            TelecomLoaderService.m8458$$Nest$fgetmDefaultSimCallManagerRequests(this.this$0).remove(i);     // Catch: Throwable -> L11
            permissionManager.grantDefaultPermissionsToDefaultSimCallManager(packageName, userId);     // Catch: Throwable -> L11
            i = i - 1;     // Catch: Throwable -> L11
        L13:
            monitor-exit(r3);     // Catch: Throwable -> L11
            goto L18
        L24:
            return;
        L11:
            th = move-exception;
            throw th;     // Catch: RemoteException -> L17
        L18:
            Slog.w(TelecomLoaderService.TAG, "Failed linking to death.");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            TelecomLoaderService.m8461$$Nest$mconnectToTelecom(this.this$0);
        }
    }

    public static /* synthetic */ String[] $r8$lambda$I4xymkAb1WjTJtq7WJwATe5MuGI(TelecomLoaderService r0, int r1) {
        return r0.lambda$registerDefaultAppProviders$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$dJgKg2CsTlJqKXrDLKl2biV0hj8(TelecomLoaderService r0, String r1, UserHandle r2) {
        r0.lambda$registerDefaultAppNotifier$3(r1, r2);
    }

    public static /* synthetic */ String[] $r8$lambda$ksjTvpTZsBknxC7MzfiZrjZ61rE(TelecomLoaderService r0, int r1) {
        return r0.lambda$registerDefaultAppProviders$2(r1);
    }

    public static /* synthetic */ String[] $r8$lambda$u4SYx5qXJvRP9mWlRHHl58QD4Lk(TelecomLoaderService r0, int r1) {
        return r0.lambda$registerDefaultAppProviders$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8457$$Nest$fgetmContext(TelecomLoaderService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultSimCallManagerRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m8458$$Nest$fgetmDefaultSimCallManagerRequests(TelecomLoaderService r0) {
        return r0.mDefaultSimCallManagerRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8459$$Nest$fgetmLock(TelecomLoaderService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceRepo, reason: not valid java name */
    static /* bridge */ /* synthetic */ InternalServiceRepository m8460$$Nest$fgetmServiceRepo(TelecomLoaderService r0) {
        return r0.mServiceRepo;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectToTelecom, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8461$$Nest$mconnectToTelecom(TelecomLoaderService r0) {
        r0.connectToTelecom();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSimCallManagerPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8462$$Nest$mupdateSimCallManagerPermissions(TelecomLoaderService r0, int r1) {
        r0.updateSimCallManagerPermissions(r1);
    }

    static {
        SERVICE_COMPONENT = new ComponentName("com.android.server.telecom", "com.android.server.telecom.components.TelecomService");
    }

    public TelecomLoaderService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mContext = context;
        registerDefaultAppProviders();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        registerDefaultAppNotifier();
        registerCarrierConfigChangedReceiver();
        setupServiceRepository();
        connectToTelecom();
        return;
    }

    private void connectToTelecom() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        TelecomLoaderServiceIA r2 = null;
        if (this.mServiceConnection == null) goto L9;
        this.mContext.unbindService(this.mServiceConnection);     // Catch: Throwable -> L7
        this.mServiceConnection = null;     // Catch: Throwable -> L7
    L9:
        TelecomServiceConnection serviceConnection = new TelecomServiceConnection(this, r2);     // Catch: Throwable -> L7
        Intent intent = new Intent(SERVICE_ACTION);     // Catch: Throwable -> L7
        intent.setComponent(SERVICE_COMPONENT);     // Catch: Throwable -> L7
        if (this.mContext.bindServiceAsUser(intent, serviceConnection, 67108929, UserHandle.SYSTEM) == false) goto L12;
        this.mServiceConnection = serviceConnection;     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setupServiceRepository() {
        DeviceIdleInternal deviceIdleInternal = (DeviceIdleInternal) getLocalService(DeviceIdleInternal.class);
        this.mServiceRepo = new InternalServiceRepository(deviceIdleInternal);
    }

    private void registerDefaultAppProviders() {
        LegacyPermissionManagerInternal permissionManager = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        permissionManager.setSmsAppPackagesProvider(new TelecomLoaderService$$ExternalSyntheticLambda0(this));
        permissionManager.setDialerAppPackagesProvider(new TelecomLoaderService$$ExternalSyntheticLambda1(this));
        permissionManager.setSimCallManagerPackagesProvider(new TelecomLoaderService$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ String[] lambda$registerDefaultAppProviders$0(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        ComponentName smsComponent = SmsApplication.getDefaultSmsApplication(this.mContext, true);
        if (smsComponent != null) goto L14;
        return null;
    L14:
        return new String[]{smsComponent.getPackageName()};
    }

    private /* synthetic */ String[] lambda$registerDefaultAppProviders$1(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        String packageName = DefaultDialerManager.getDefaultDialerApplication(this.mContext);
        if (packageName != null) goto L14;
        return null;
    L14:
        return new String[]{packageName};
    }

    private /* synthetic */ String[] lambda$registerDefaultAppProviders$2(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection == null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L9
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (subscriptionManager != null) goto L18;
        return null;
    L18:
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        List<String> packages = new ArrayList();
        int[] subIds = subscriptionManager.getActiveSubscriptionIdList();
        int r4 = subIds.length;
        int r6 = 0;
    L19:
        if (r6 >= r4) goto L25;
        int subId = subIds[r6];
        PhoneAccountHandle phoneAccount = telecomManager.getSimCallManagerForSubscription(subId);
        if (phoneAccount == null) goto L23;
        packages.add(phoneAccount.getComponentName().getPackageName());
    L23:
        r6 = r6 + 1;
        goto L19
    L25:
        return (String[]) packages.toArray(new String[0]);
    L7:
        if (this.mDefaultSimCallManagerRequests != null) goto L11;
        this.mDefaultSimCallManagerRequests = new IntArray();     // Catch: Throwable -> L9
    L11:
        this.mDefaultSimCallManagerRequests.add(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    }

    private void registerDefaultAppNotifier() {
        RoleManager roleManager = (RoleManager) this.mContext.getSystemService(RoleManager.class);
        roleManager.addOnRoleHoldersChangedListenerAsUser(this.mContext.getMainExecutor(), new TelecomLoaderService$$ExternalSyntheticLambda3(this), UserHandle.ALL);
    }

    private /* synthetic */ void lambda$registerDefaultAppNotifier$3(String roleName, UserHandle user) {
        updateSimCallManagerPermissions(user.getIdentifier());
    }

    private void registerCarrierConfigChangedReceiver() {
        BroadcastReceiver receiver = new AnonymousClass1(this);
        this.mContext.registerReceiverAsUser(receiver, UserHandle.ALL, new IntentFilter("android.telephony.action.CARRIER_CONFIG_CHANGED"), null, null);
    }

    private void updateSimCallManagerPermissions(int userId) {
        LegacyPermissionManagerInternal permissionManager = (LegacyPermissionManagerInternal) LocalServices.getService(LegacyPermissionManagerInternal.class);
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        PhoneAccountHandle phoneAccount = telecomManager.getSimCallManager(userId);
        if (phoneAccount == null) goto L6;
        Slog.i(TAG, "updating sim call manager permissions for userId:" + userId);
        String packageName = phoneAccount.getComponentName().getPackageName();
        permissionManager.grantDefaultPermissionsToDefaultSimCallManager(packageName, userId);
        return;
    }
}
