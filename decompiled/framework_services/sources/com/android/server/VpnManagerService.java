package com.android.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.net.INetd;
import android.net.IVpnManager;
import android.net.Network;
import android.net.UnderlyingNetworkInfo;
import android.net.VpnProfileState;
import android.net.util.NetdService;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.INetworkManagementService;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.net.LegacyVpnInfo;
import com.android.internal.net.VpnConfig;
import com.android.internal.net.VpnProfile;
import com.android.internal.util.DumpUtils;
import com.android.net.module.util.PermissionUtils;
import com.android.server.connectivity.Vpn;
import com.android.server.connectivity.VpnProfileStore;
import com.android.server.net.LockdownVpnTracker;
import com.android.server.pm.Settings;
import com.android.server.pm.UserManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class VpnManagerService extends IVpnManager.Stub {
    private static final String CONTEXT_ATTRIBUTION_TAG = "VPN_MANAGER";
    private static final String TAG = null;
    private final Context mContext;
    private final Dependencies mDeps;
    private final Handler mHandler;
    protected final HandlerThread mHandlerThread;
    private BroadcastReceiver mIntentReceiver;
    private boolean mLockdownEnabled;
    private LockdownVpnTracker mLockdownTracker;
    private final int mMainUserId;
    private final INetworkManagementService mNMS;
    private final INetd mNetd;
    private final Context mUserAllContext;
    private final UserManager mUserManager;
    private BroadcastReceiver mUserPresentReceiver;
    private final VpnProfileStore mVpnProfileStore;
    protected final SparseArray<Vpn> mVpns;

    public static class Dependencies {
        public Dependencies() {
        }

        public int getCallingUid() {
            return Binder.getCallingUid();
        }

        public HandlerThread makeHandlerThread() {
            return new HandlerThread("VpnManagerService");
        }

        public VpnProfileStore getVpnProfileStore() {
            return new VpnProfileStore();
        }

        public INetd getNetd() {
            return NetdService.getInstance();
        }

        public INetworkManagementService getINetworkManagementService() {
            return INetworkManagementService.Stub.asInterface(ServiceManager.getService("network_management"));
        }

        public Vpn createVpn(Looper looper, Context context, INetworkManagementService nms, INetd netd, int userId) {
            return new Vpn(looper, context, nms, netd, userId, new VpnProfileStore());
        }

        public LockdownVpnTracker createLockDownVpnTracker(Context context, Handler handler, Vpn vpn, VpnProfile profile) {
            return new LockdownVpnTracker(context, handler, vpn, profile);
        }

        public int getMainUserId() {
            return ((UserManagerInternal) LocalServices.getService(UserManagerInternal.class)).getMainUserId();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mensureRunningOnHandlerThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m502$$Nest$mensureRunningOnHandlerThread(VpnManagerService r0) {
        r0.ensureRunningOnHandlerThread();
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m503$$Nest$monPackageAdded(VpnManagerService r0, String r1, int r2, boolean r3) {
        r0.onPackageAdded(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m504$$Nest$monPackageRemoved(VpnManagerService r0, String r1, int r2, boolean r3) {
        r0.onPackageRemoved(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageReplaced, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m505$$Nest$monPackageReplaced(VpnManagerService r0, String r1, int r2) {
        r0.onPackageReplaced(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserAdded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m506$$Nest$monUserAdded(VpnManagerService r0, int r1) {
        r0.onUserAdded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m507$$Nest$monUserRemoved(VpnManagerService r0, int r1) {
        r0.onUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m508$$Nest$monUserStarted(VpnManagerService r0, int r1) {
        r0.onUserStarted(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m509$$Nest$monUserStopped(VpnManagerService r0, int r1) {
        r0.onUserStopped(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m510$$Nest$monUserUnlocked(VpnManagerService r0, int r1) {
        r0.onUserUnlocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monVpnLockdownReset, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m511$$Nest$monVpnLockdownReset(VpnManagerService r0) {
        r0.onVpnLockdownReset();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m512$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = VpnManagerService.class.getSimpleName();
    }

    public VpnManagerService(Context context, Dependencies deps) {
        this.mVpns = new SparseArray();
        this.mIntentReceiver = new AnonymousClass1(this);
        this.mUserPresentReceiver = new AnonymousClass2(this);
        this.mContext = context.createAttributionContext(CONTEXT_ATTRIBUTION_TAG);
        this.mDeps = deps;
        this.mHandlerThread = this.mDeps.makeHandlerThread();
        this.mHandlerThread.start();
        this.mHandler = this.mHandlerThread.getThreadHandler();
        this.mVpnProfileStore = this.mDeps.getVpnProfileStore();
        this.mUserAllContext = this.mContext.createContextAsUser(UserHandle.ALL, 0);
        this.mNMS = this.mDeps.getINetworkManagementService();
        this.mNetd = this.mDeps.getNetd();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mMainUserId = this.mDeps.getMainUserId();
        registerReceivers();
        log("VpnManagerService starting up");
    }

    public static VpnManagerService create(Context context) {
        return new VpnManagerService(context, new Dependencies());
    }

    public void systemReady() {
        updateLockdownVpn();
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, writer) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter r0 = new com.android.internal.util.IndentingPrintWriter(writer, "  ");
        r0.println("VPNs:");
        r0.increaseIndent();
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        int i = 0;
    L18:
    L11:
        th = move-exception;
        throw th;
    L9:
        if (i >= this.mVpns.size()) goto L13;
        r0.println(this.mVpns.keyAt(i) + ": " + this.mVpns.valueAt(i).getPackage());     // Catch: Throwable -> L11
        r0.increaseIndent();     // Catch: Throwable -> L11
        this.mVpns.valueAt(i).dump(r0);     // Catch: Throwable -> L11
        r0.decreaseIndent();     // Catch: Throwable -> L11
        r0.println();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L18
    L13:
        r0.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
    }

    public boolean prepareVpn(String oldPackage, String newPackage, int userId) {
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        throwIfLockdownEnabled();     // Catch: Throwable -> L9
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L9
        if (vpn == null) goto L11;
        boolean r2 = vpn.prepare(oldPackage, newPackage, 1);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public void setVpnPackageAuthorization(String packageName, int userId, int vpnType) {
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L7
        if (vpn == null) goto L9;
        vpn.setPackageAuthorization(packageName, vpnType);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor establishVpn(VpnConfig config) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        throwIfLockdownEnabled();     // Catch: Throwable -> L7
        ParcelFileDescriptor r2 = this.mVpns.get(user).establish(config);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean addVpnAddress(String address, int prefixLength) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        throwIfLockdownEnabled();     // Catch: Throwable -> L7
        boolean r2 = this.mVpns.get(user).addAddress(address, prefixLength);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean removeVpnAddress(String address, int prefixLength) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        throwIfLockdownEnabled();     // Catch: Throwable -> L7
        boolean r2 = this.mVpns.get(user).removeAddress(address, prefixLength);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setUnderlyingNetworksForVpn(Network[] networks) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        boolean success = this.mVpns.get(user).setUnderlyingNetworks(networks);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return success;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean provisionVpnProfile(VpnProfile profile, String packageName) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        boolean r2 = this.mVpns.get(user).provisionVpnProfile(packageName, profile);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void deleteVpnProfile(String packageName) {
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        this.mVpns.get(user).deleteVpnProfile(packageName);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private int getAppUid(String app, int userId) {
        PackageManager pm = this.mContext.getPackageManager();
        long token = Binder.clearCallingIdentity();
        int r3 = pm.getPackageUidAsUser(app, userId);     // Catch: Throwable -> L6 PackageManager.NameNotFoundException -> L9
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L10:
        Binder.restoreCallingIdentity(token);
        return -1;
    }

    private void verifyCallingUidAndPackage(String packageName, int callingUid) {
        int userId = UserHandle.getUserId(callingUid);
        if (getAppUid(packageName, userId) != callingUid) goto L6;
        return;
    L6:
        throw new SecurityException(packageName + " does not belong to uid " + callingUid);
    }

    public String startVpnProfile(String packageName) {
        int callingUid = Binder.getCallingUid();
        verifyCallingUidAndPackage(packageName, callingUid);
        int user = UserHandle.getUserId(callingUid);
        SparseArray<Vpn> r2 = this.mVpns;
        monitor-enter(r2);
        throwIfLockdownEnabled();     // Catch: Throwable -> L7
        String r3 = this.mVpns.get(user).startVpnProfile(packageName);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void stopVpnProfile(String packageName) {
        int callingUid = Binder.getCallingUid();
        verifyCallingUidAndPackage(packageName, callingUid);
        int user = UserHandle.getUserId(callingUid);
        SparseArray<Vpn> r2 = this.mVpns;
        monitor-enter(r2);
        this.mVpns.get(user).stopVpnProfile(packageName);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public VpnProfileState getProvisionedVpnProfileState(String packageName) {
        int callingUid = Binder.getCallingUid();
        verifyCallingUidAndPackage(packageName, callingUid);
        int user = UserHandle.getUserId(callingUid);
        SparseArray<Vpn> r2 = this.mVpns;
        monitor-enter(r2);
        VpnProfileState r3 = this.mVpns.get(user).getProvisionedVpnProfileState(packageName);     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public void startLegacyVpn(VpnProfile profile) {
        if (Build.VERSION.DEVICE_INITIAL_SDK_INT >= 31) goto L5;
    L9:
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        throwIfLockdownEnabled();     // Catch: Throwable -> L14
        this.mVpns.get(user).startLegacyVpn(profile);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L5:
        if (VpnProfile.isLegacyType(profile.type) == false) goto L9;
        throw new UnsupportedOperationException("Legacy VPN is deprecated");
    }

    public LegacyVpnInfo getLegacyVpnInfo(int userId) {
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        LegacyVpnInfo r1 = this.mVpns.get(userId).getLegacyVpnInfo();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public VpnConfig getVpnConfig(int userId) {
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L9
        if (vpn == null) goto L11;
        VpnConfig r2 = vpn.getVpnConfig();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isLockdownVpnEnabled() {
        if (this.mVpnProfileStore.get("LOCKDOWN_VPN") == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean updateLockdownVpn() {
        if (this.mDeps.getCallingUid() != 1000) goto L5;
    L10:
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        this.mLockdownEnabled = isLockdownVpnEnabled();     // Catch: Throwable -> L17
        if (this.mLockdownEnabled == true) goto L19;
        setLockdownTracker(null);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L19:
        byte[] profileTag = this.mVpnProfileStore.get("LOCKDOWN_VPN");     // Catch: Throwable -> L17
        if (profileTag != null) goto L24;
        loge("Lockdown VPN configured but cannot be read from keystore");     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L24:
        String profileName = new String(profileTag);     // Catch: Throwable -> L17
        VpnProfile profile = VpnProfile.decode(profileName, this.mVpnProfileStore.get("VPN_" + profileName));     // Catch: Throwable -> L17
        if (profile != null) goto L29;
        loge("Lockdown VPN configured invalid profile " + profileName);     // Catch: Throwable -> L17
        setLockdownTracker(null);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L29:
        int user = UserHandle.getUserId(this.mDeps.getCallingUid());     // Catch: Throwable -> L17
        Vpn vpn = this.mVpns.get(user);     // Catch: Throwable -> L17
        if (vpn != null) goto L34;
        logw("VPN for user " + user + " not ready yet. Skipping lockdown");     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L34:
        setLockdownTracker(this.mDeps.createLockDownVpnTracker(this.mContext, this.mHandler, vpn, profile));     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeps.getCallingUid() == UserHandle.getUid(this.mMainUserId, 1000)) goto L10;
        if (Binder.getCallingPid() == Process.myPid()) goto L10;
        logw("Lockdown VPN only available to system process or AID_SYSTEM on main user");
        return false;
    }

    private void setLockdownTracker(LockdownVpnTracker tracker) {
        LockdownVpnTracker existing = this.mLockdownTracker;
        this.mLockdownTracker = null;
        if (existing == null) goto L5;
        existing.shutdown();
    L5:
        if (tracker == null) goto L8;
        this.mLockdownTracker = tracker;
        this.mLockdownTracker.init();
        return;
    }

    private void throwIfLockdownEnabled() {
        if (this.mLockdownEnabled == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Unavailable in lockdown mode");
    }

    private boolean startAlwaysOnVpn(int userId) {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L10
        if (vpn != null) goto L12;
        Log.wtf(TAG, "User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        boolean r2 = vpn.startAlwaysOnVpn();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isAlwaysOnVpnPackageSupported(int userId, String packageName) {
        enforceSettingsPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L10
        if (vpn != null) goto L12;
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        boolean r2 = vpn.isAlwaysOnPackageSupported(packageName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean setAlwaysOnVpnPackage(int userId, String packageName, boolean lockdown, List<String> lockdownAllowlist) {
        enforceControlAlwaysOnVpnPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isLockdownVpnEnabled() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L8
        if (vpn != null) goto L16;
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L16:
        if (vpn.setAlwaysOnPackage(packageName, lockdown, lockdownAllowlist) == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L20:
        if (startAlwaysOnVpn(userId) == true) goto L25;
        vpn.setAlwaysOnPackage(null, false, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    }

    public String getAlwaysOnVpnPackage(int userId) {
        enforceControlAlwaysOnVpnPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L10
        if (vpn != null) goto L12;
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return null;
    L12:
        String r2 = vpn.getAlwaysOnPackage();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isVpnLockdownEnabled(int userId) {
        enforceControlAlwaysOnVpnPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L10
        if (vpn != null) goto L12;
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        boolean r2 = vpn.getLockdown();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public List<String> getVpnLockdownAllowlist(int userId) {
        enforceControlAlwaysOnVpnPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L10
        if (vpn != null) goto L12;
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return null;
    L12:
        List<String> r2 = vpn.getLockdownAllowlist();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    private Vpn getVpnIfOwner() {
        return getVpnIfOwner(this.mDeps.getCallingUid());
    }

    private Vpn getVpnIfOwner(int uid) {
        int user = UserHandle.getUserId(uid);
        Vpn vpn = this.mVpns.get(user);
        if (vpn != null) goto L5;
        return null;
    L5:
        UnderlyingNetworkInfo info = vpn.getUnderlyingNetworkInfo();
        if (info != null) goto L8;
        return null;
    L8:
        if (info.getOwnerUid() == uid) goto L11;
        return null;
    L11:
        return vpn;
    }

    private void registerReceivers() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_STARTED");
        intentFilter.addAction("android.intent.action.USER_STOPPED");
        intentFilter.addAction("android.intent.action.USER_ADDED");
        intentFilter.addAction("android.intent.action.USER_REMOVED");
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        this.mUserAllContext.registerReceiver(this.mIntentReceiver, intentFilter, null, this.mHandler);
        this.mContext.createContextAsUser(UserHandle.of(this.mMainUserId), 0).registerReceiver(this.mUserPresentReceiver, new IntentFilter("android.intent.action.USER_PRESENT"), null, this.mHandler);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter2.addDataScheme(Settings.ATTR_PACKAGE);
        this.mUserAllContext.registerReceiver(this.mIntentReceiver, intentFilter2, null, this.mHandler);
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction(LockdownVpnTracker.ACTION_LOCKDOWN_RESET);
        this.mUserAllContext.registerReceiver(this.mIntentReceiver, intentFilter3, "android.permission.NETWORK_STACK", this.mHandler, 2);
    }

    private void onUserStarted(int userId) {
        UserInfo user = this.mUserManager.getUserInfo(userId);
        if (user != null) goto L6;
        logw("Started user doesn't exist. UserId: " + userId);
        return;
    L6:
        SparseArray<Vpn> r2 = this.mVpns;
        monitor-enter(r2);
        Vpn userVpn = this.mVpns.get(userId);     // Catch: Throwable -> L26
        if (userVpn != null) goto L30;
        Vpn userVpn2 = this.mDeps.createVpn(this.mHandler.getLooper(), this.mContext, this.mNMS, this.mNetd, userId);     // Catch: Throwable -> L22
        this.mVpns.put(userId, userVpn2);     // Catch: Throwable -> L22
        if (userId == this.mMainUserId) goto L20;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L22
        return;
    L20:
        if (isLockdownVpnEnabled() == false) goto L24;
        updateLockdownVpn();     // Catch: Throwable -> L22
        goto L24
    L30:
        loge("Starting user already has a VPN");     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = th;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L22
        throw th;
    L22:
        th = th;
    L26:
        th = th;
        goto L28
    }

    private void onUserStopped(int userId) {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn userVpn = this.mVpns.get(userId);     // Catch: Throwable -> L9
        if (userVpn != null) goto L11;
        loge("Stopped user has no VPN");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        userVpn.onUserStopped();     // Catch: Throwable -> L9
        this.mVpns.delete(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isCallerCurrentAlwaysOnVpnApp() {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = getVpnIfOwner();     // Catch: Throwable -> L9
        if (vpn != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (vpn.getAlwaysOn() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isCallerCurrentAlwaysOnVpnLockdownApp() {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = getVpnIfOwner();     // Catch: Throwable -> L9
        if (vpn != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (vpn.getLockdown() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private void onUserAdded(int userId) {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        int vpnsSize = this.mVpns.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= vpnsSize) goto L10;
        Vpn vpn = this.mVpns.valueAt(i);     // Catch: Throwable -> L7
        vpn.onUserAdded(userId);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onUserRemoved(int userId) {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        int vpnsSize = this.mVpns.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= vpnsSize) goto L10;
        Vpn vpn = this.mVpns.valueAt(i);     // Catch: Throwable -> L7
        vpn.onUserRemoved(userId);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onPackageReplaced(String packageName, int uid) {
        if (TextUtils.isEmpty(packageName) == true) goto L21;
        if (uid < 0) goto L21;
        int userId = UserHandle.getUserId(uid);
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L12
        if (vpn != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L15:
        if (TextUtils.equals(vpn.getAlwaysOnPackage(), packageName) == false) goto L17;
        log("Restarting always-on VPN package " + packageName + " for user " + userId);     // Catch: Throwable -> L12
        vpn.startAlwaysOnVpn();     // Catch: Throwable -> L12
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L21:
        Log.wtf(TAG, "Invalid package in onPackageReplaced: " + packageName + " | " + uid);
    }

    private void onPackageRemoved(String packageName, int uid, boolean isReplacing) {
        if (TextUtils.isEmpty(packageName) == true) goto L24;
        if (uid < 0) goto L24;
        int userId = UserHandle.getUserId(uid);
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L15
        if (vpn == null) goto L20;
        if (isReplacing == true) goto L20;
        if (TextUtils.equals(vpn.getAlwaysOnPackage(), packageName) == false) goto L17;
        log("Removing always-on VPN package " + packageName + " for user " + userId);     // Catch: Throwable -> L15
        vpn.setAlwaysOnPackage(null, false, null);     // Catch: Throwable -> L15
    L17:
        vpn.refreshPlatformVpnAppExclusionList();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L24:
        Log.wtf(TAG, "Invalid package in onPackageRemoved: " + packageName + " | " + uid);
    }

    private void onPackageAdded(String packageName, int uid, boolean isReplacing) {
        if (TextUtils.isEmpty(packageName) == true) goto L18;
        if (uid < 0) goto L18;
        int userId = UserHandle.getUserId(uid);
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L12
        if (vpn == null) goto L14;
        if (isReplacing == true) goto L14;
        vpn.refreshPlatformVpnAppExclusionList();     // Catch: Throwable -> L12
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L18:
        Log.wtf(TAG, "Invalid package in onPackageAdded: " + packageName + " | " + uid);
    }

    private void onUserUnlocked(int userId) {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (userId == this.mMainUserId) goto L7;
    L11:
        startAlwaysOnVpn(userId);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (isLockdownVpnEnabled() == false) goto L11;
        updateLockdownVpn();     // Catch: Throwable -> L9
        goto L12
    }

    private void onVpnLockdownReset() {
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockdownTracker == null) goto L9;
        this.mLockdownTracker.reset();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public boolean setAppExclusionList(int userId, String vpnPackage, List<String> excludedApps) {
        enforceSettingsPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L9
        if (vpn == null) goto L11;
        boolean r2 = vpn.setAppExclusionList(vpnPackage, excludedApps);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L9
        throw new IllegalStateException("VPN for user " + userId + " not ready yet. Skipping setting the list");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public List<String> getAppExclusionList(int userId, String vpnPackage) {
        enforceSettingsPermission();
        enforceCrossUserPermission(userId);
        SparseArray<Vpn> r0 = this.mVpns;
        monitor-enter(r0);
        Vpn vpn = this.mVpns.get(userId);     // Catch: Throwable -> L9
        if (vpn == null) goto L11;
        List<String> r2 = vpn.getAppExclusionList(vpnPackage);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        logw("User " + userId + " has no Vpn configuration");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public void factoryReset() {
        enforceSettingsPermission();
        if (this.mUserManager.hasUserRestriction("no_network_reset") == false) goto L5;
        return;
    L5:
        if (this.mUserManager.hasUserRestriction("no_config_vpn") == true) goto L38;
        int userId = UserHandle.getCallingUserId();
        SparseArray<Vpn> r1 = this.mVpns;
        monitor-enter(r1);
        String alwaysOnPackage = getAlwaysOnVpnPackage(userId);     // Catch: Throwable -> L12
        if (alwaysOnPackage == null) goto L15;
        setAlwaysOnVpnPackage(userId, null, false, null);     // Catch: Throwable -> L12
        setVpnPackageAuthorization(alwaysOnPackage, userId, -1);     // Catch: Throwable -> L12
    L15:
        if (this.mLockdownEnabled == true) goto L17;
    L24:
        VpnConfig vpnConfig = getVpnConfig(userId);     // Catch: Throwable -> L12
        if (vpnConfig != null) goto L27;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L27:
        if (vpnConfig.legacy == false) goto L29;
        prepareVpn("[Legacy VPN]", "[Legacy VPN]", userId);     // Catch: Throwable -> L12
        goto L30
    L29:
        setVpnPackageAuthorization(vpnConfig.user, userId, -1);     // Catch: Throwable -> L12
        prepareVpn(null, "[Legacy VPN]", userId);     // Catch: Throwable -> L12
        goto L30
    L17:
        if (userId != this.mMainUserId) goto L24;
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        this.mVpnProfileStore.remove("LOCKDOWN_VPN");     // Catch: Throwable -> L21
        this.mLockdownEnabled = false;     // Catch: Throwable -> L21
        setLockdownTracker(null);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        goto L24
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public byte[] getFromVpnProfileStore(String name) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        return this.mVpnProfileStore.get(name);
    }

    public boolean putIntoVpnProfileStore(String name, byte[] blob) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        return this.mVpnProfileStore.put(name, blob);
    }

    public boolean removeFromVpnProfileStore(String name) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        return this.mVpnProfileStore.remove(name);
    }

    public String[] listFromVpnProfileStore(String prefix) {
        PermissionUtils.enforceNetworkStackPermission(this.mContext);
        return this.mVpnProfileStore.list(prefix);
    }

    private void ensureRunningOnHandlerThread() {
        if (this.mHandler.getLooper().getThread() != Thread.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not running on VpnManagerService thread: " + Thread.currentThread().getName());
    }

    private void enforceControlAlwaysOnVpnPermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CONTROL_ALWAYS_ON_VPN", "VpnManagerService");
    }

    private void enforceCrossUserPermission(int userId) {
        if (userId != UserHandle.getCallingUserId()) goto L5;
        return;
    L5:
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "VpnManagerService");
    }

    private void enforceSettingsPermission() {
        PermissionUtils.enforceAnyPermissionOf(this.mContext, new String[]{"android.permission.NETWORK_SETTINGS", "android.permission.MAINLINE_NETWORK_STACK"});
    }

    private static void log(String s) {
        Log.d(TAG, s);
    }

    private static void logw(String s) {
        Log.w(TAG, s);
    }

    private static void loge(String s) {
        Log.e(TAG, s);
    }
}
