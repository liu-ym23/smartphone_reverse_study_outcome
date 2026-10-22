package com.android.server.locksettings;

import android.R;
import android.app.ActivityManager;
import android.app.IActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteLockscreenValidationResult;
import android.app.RemoteLockscreenValidationSession;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.admin.DeviceStateCache;
import android.app.admin.PasswordMetrics;
import android.app.trust.IStrongAuthTracker;
import android.app.trust.TrustManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.authsecret.IAuthSecret;
import android.hardware.biometrics.BiometricManager;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IProgressListener;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.ICeStorageLockEventListener;
import android.os.storage.IStorageManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.security.AndroidKeyStoreMaintenance;
import android.security.KeyStoreAuthorization;
import android.security.keystore.KeyProtection;
import android.security.keystore.recovery.KeyChainProtectionParams;
import android.security.keystore.recovery.KeyChainSnapshot;
import android.security.keystore.recovery.RecoveryCertPath;
import android.security.keystore.recovery.WrappedApplicationKey;
import android.security.keystore2.AndroidKeyStoreLoadStoreParameter;
import android.security.keystore2.AndroidKeyStoreProvider;
import android.service.gatekeeper.IGateKeeperService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.pm.RoSystemFeatures;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.internal.widget.ICheckCredentialProgressCallback;
import com.android.internal.widget.ILockSettings;
import com.android.internal.widget.IWeakEscrowTokenActivatedListener;
import com.android.internal.widget.IWeakEscrowTokenRemovedListener;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockSettingsInternal;
import com.android.internal.widget.LockSettingsStateListener;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.RebootEscrowListener;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.job.controllers.JobStatus;
import com.android.server.locksettings.recoverablekeystore.RecoverableKeyStoreManager;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.Slogf;
import com.android.server.wm.WindowManagerInternal;
import com.bytedance.securityserver.trustcircle.LockEventServiceManager;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class LockSettingsService extends ILockSettings.Stub {
    private static final String BIOMETRIC_PERMISSION = "android.permission.MANAGE_BIOMETRIC";
    private static final String DEFAULT_PASSWORD = "default_password";
    private static final int GK_PW_HANDLE_STORE_DURATION_MS = 600000;
    private static final int HEADLESS_VENDOR_AUTH_SECRET_LENGTH = 32;
    private static final String LSKF_LAST_CHANGED_TIME_KEY = "sp-handle-ts";
    private static final String MIGRATED_FRP2 = "migrated_frp2";
    private static final String MIGRATED_KEYSTORE_NS = "migrated_keystore_namespace";
    private static final String MIGRATED_SP_FULL = "migrated_all_users_to_sp_and_bound_keys";
    private static final String MIGRATED_WEAVER_DISABLED_ON_UNSECURED_USERS = "migrated_weaver_disabled_on_unsecured_users";
    private static final String PERMISSION = "android.permission.ACCESS_KEYGUARD_SECURE_STORAGE";
    private static final String PREV_LSKF_BASED_PROTECTOR_ID_KEY = "prev-sp-handle";
    private static final int PROFILE_KEY_IV_SIZE = 12;
    private static final String PROFILE_KEY_NAME_DECRYPT = "profile_key_name_decrypt_";
    private static final String PROFILE_KEY_NAME_ENCRYPT = "profile_key_name_encrypt_";
    private static final String SEPARATE_PROFILE_CHALLENGE_KEY = "lockscreen.profilechallenge";
    private static final int[] SYSTEM_CREDENTIAL_UIDS = null;
    private static final String TAG = "LockSettingsService";
    private static final String USER_SERIAL_NUMBER_KEY = "serial-number";
    private static String mSavePassword;
    private final IActivityManager mActivityManager;
    protected byte[] mAuthSecret;
    protected IAuthSecret mAuthSecretService;
    private final BiometricDeferredQueue mBiometricDeferredQueue;
    private final BroadcastReceiver mBroadcastReceiver;
    private final ICeStorageLockEventListener mCeStorageLockEventListener;
    private final Context mContext;
    private final DeviceProvisionedObserver mDeviceProvisionedObserver;
    private SparseIntArray mEarlyCreatedUsers;
    private SparseIntArray mEarlyRemovedUsers;
    protected IGateKeeperService mGateKeeperService;
    private final LongSparseArray<byte[]> mGatekeeperPasswords;
    private final Object mGcWorkToken;
    protected final Handler mHandler;
    protected boolean mHasSecureLockScreen;
    protected final Object mHeadlessAuthSecretLock;
    private final Injector mInjector;
    private final KeyStore mKeyStore;
    private final KeyStoreAuthorization mKeyStoreAuthorization;
    private final CopyOnWriteArrayList<LockSettingsStateListener> mLockSettingsStateListeners;
    private final NotificationManager mNotificationManager;
    private ArrayList<Pair<Long, Integer>> mProtectorsToDestroyOnBootCompleted;
    private final RebootEscrowManager mRebootEscrowManager;
    private final RecoverableKeyStoreManager mRecoverableKeyStoreManager;
    private final Object mSeparateChallengeLock;
    private final SyntheticPasswordManager mSpManager;
    protected final LockSettingsStorage mStorage;
    private final IStorageManager mStorageManager;
    private final StorageManagerInternal mStorageManagerInternal;
    private final LockSettingsStrongAuth mStrongAuth;
    private final SynchronizedStrongAuthTracker mStrongAuthTracker;
    private boolean mThirdPartyAppsStarted;
    private final UnifiedProfilePasswordCache mUnifiedProfilePasswordCache;
    private final Object mUserCreationAndRemovalLock;
    protected final UserManager mUserManager;
    private final SparseArray<PasswordMetrics> mUserPasswordMetrics;

    /* JADX INFO: renamed from: com.android.server.locksettings.LockSettingsService$3, reason: invalid class name */
    class AnonymousClass3 implements ICeStorageLockEventListener {
        final /* synthetic */ LockSettingsService this$0;

        /* JADX INFO: renamed from: $r8$lambda$0nJI8C3dk_d-RkKvRK_DpigPXfM, reason: not valid java name */
        public static /* synthetic */ void m5449$r8$lambda$0nJI8C3dk_dRkKvRK_DpigPXfM(AnonymousClass3 r0, int r1) {
            r0.lambda$onStorageLocked$0(r1);
        }

        AnonymousClass3(LockSettingsService this$0) {
            this.this$0 = this$0;
        }

        public void onStorageLocked(final int userId) {
            Slog.i(LockSettingsService.TAG, "Storage lock event received for " + userId);
            this.this$0.mHandler.post(new LockSettingsService$3$$ExternalSyntheticLambda0(this, userId));
        }

        private /* synthetic */ void lambda$onStorageLocked$0(int userId) {
            UserProperties userProperties = LockSettingsService.m5431$$Nest$mgetUserProperties(this.this$0, userId);
            if (userProperties != null) goto L5;
            return;
        L5:
            if (userProperties.getAllowStoppingUserWithDelayedLocking() == false) goto L9;
            int strongAuthRequired = LockPatternUtils.StrongAuthTracker.getDefaultFlags(LockSettingsService.m5423$$Nest$fgetmContext(this.this$0));
            this.this$0.requireStrongAuth(strongAuthRequired, userId);
            return;
        }
    }

    private class DeviceProvisionedObserver extends ContentObserver {
        private final Uri mDeviceProvisionedUri;
        private boolean mRegistered;
        final /* synthetic */ LockSettingsService this$0;

        public DeviceProvisionedObserver(LockSettingsService r1) {
            this.this$0 = r1;
            super(null);
            this.mDeviceProvisionedUri = Settings.Global.getUriFor("device_provisioned");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mDeviceProvisionedUri.equals(uri) == false) goto L8;
            updateRegistration();
            if (isProvisioned() == false) goto L9;
            Slog.i(LockSettingsService.TAG, "Reporting device setup complete to IGateKeeperService");
            reportDeviceSetupComplete();
            clearFrpCredentialIfOwnerNotSecure();
            return;
        L9:
            return;
        }

        public void onSystemReady() {
            if (LockPatternUtils.frpCredentialEnabled(LockSettingsService.m5423$$Nest$fgetmContext(this.this$0)) == false) goto L6;
            updateRegistration();
            return;
        L6:
            if (isProvisioned() == true) goto L10;
            Slog.i(LockSettingsService.TAG, "FRP credential disabled, reporting device setup complete to Gatekeeper immediately");
            reportDeviceSetupComplete();
            return;
        }

        private void reportDeviceSetupComplete() {
            LockSettingsService.m5430$$Nest$mgetGateKeeperService(this.this$0).reportDeviceSetupComplete();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(LockSettingsService.TAG, "Failure reporting to IGateKeeperService", e);
        }

        private void clearFrpCredentialIfOwnerNotSecure() {
            List<UserInfo> users = this.this$0.mUserManager.getUsers();
            Iterator<UserInfo> r1 = users.iterator();
        L4:
            if (r1.hasNext() == false) goto L12;
            UserInfo user = r1.next();
            if (LockPatternUtils.userOwnsFrpCredential(LockSettingsService.m5423$$Nest$fgetmContext(this.this$0), user) == false) goto L4;
            if (LockSettingsService.m5435$$Nest$misUserSecure(this.this$0, user.id) == true) goto L16;
            Slogf.d(LockSettingsService.TAG, "Clearing FRP credential tied to user %d", new Object[]{Integer.valueOf(user.id)});
            this.this$0.mStorage.writePersistentDataBlock(0, user.id, 0, null);
            return;
        L16:
            return;
        }

        private void updateRegistration() {
            boolean register = !isProvisioned();
            if (register != this.mRegistered) goto L5;
            return;
        L5:
            if (register == false) goto L7;
            LockSettingsService.m5423$$Nest$fgetmContext(this.this$0).getContentResolver().registerContentObserver(this.mDeviceProvisionedUri, false, this);
        L8:
            this.mRegistered = register;
            return;
        L7:
            LockSettingsService.m5423$$Nest$fgetmContext(this.this$0).getContentResolver().unregisterContentObserver(this);
            goto L8
        }

        private boolean isProvisioned() {
            if (Settings.Global.getInt(LockSettingsService.m5423$$Nest$fgetmContext(this.this$0).getContentResolver(), "device_provisioned", 0) == 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    private class GateKeeperDiedRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ LockSettingsService this$0;

        /* synthetic */ GateKeeperDiedRecipient(LockSettingsService r1, LockSettingsServiceIA r2) {
            this(r1);
        }

        private GateKeeperDiedRecipient(LockSettingsService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mGateKeeperService.asBinder().unlinkToDeath(this, 0);
            this.this$0.mGateKeeperService = null;
        }
    }

    static class Injector {
        protected Context mContext;
        private Handler mHandler;
        private ServiceThread mHandlerThread;

        public Injector(Context context) {
            this.mContext = context;
        }

        public Context getContext() {
            return this.mContext;
        }

        public ServiceThread getServiceThread() {
            if (this.mHandlerThread != null) goto L6;
            this.mHandlerThread = new ServiceThread(LockSettingsService.TAG, 10, true);
            this.mHandlerThread.start();
        L6:
            return this.mHandlerThread;
        }

        public Handler getHandler(ServiceThread handlerThread) {
            if (this.mHandler != null) goto L6;
            this.mHandler = new Handler(handlerThread.getLooper());
        L6:
            return this.mHandler;
        }

        public LockSettingsStorage getStorage() {
            final LockSettingsStorage storage = new LockSettingsStorage(this.mContext);
            storage.setDatabaseOnCreateCallback(new AnonymousClass1(this, storage));
            return storage;
        }

        public LockSettingsStrongAuth getStrongAuth() {
            return new LockSettingsStrongAuth(this.mContext);
        }

        public SynchronizedStrongAuthTracker getStrongAuthTracker() {
            return new SynchronizedStrongAuthTracker(this.mContext);
        }

        public IActivityManager getActivityManager() {
            return ActivityManager.getService();
        }

        public NotificationManager getNotificationManager() {
            return (NotificationManager) this.mContext.getSystemService("notification");
        }

        public UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService("user");
        }

        public UserManagerInternal getUserManagerInternal() {
            return (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        }

        public DevicePolicyManager getDevicePolicyManager() {
            return (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        }

        public DeviceStateCache getDeviceStateCache() {
            return DeviceStateCache.getInstance();
        }

        public RecoverableKeyStoreManager getRecoverableKeyStoreManager() {
            return RecoverableKeyStoreManager.getInstance(this.mContext);
        }

        public IStorageManager getStorageManager() {
            IBinder service = ServiceManager.getService("mount");
            if (service != null) goto L5;
            return null;
        L5:
            return IStorageManager.Stub.asInterface(service);
        }

        public StorageManagerInternal getStorageManagerInternal() {
            return (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
        }

        public SyntheticPasswordManager getSyntheticPasswordManager(LockSettingsStorage storage) {
            return new SyntheticPasswordManager(getContext(), storage, getUserManager(), new PasswordSlotManager());
        }

        public RebootEscrowManager getRebootEscrowManager(RebootEscrowManager.Callbacks callbacks, LockSettingsStorage storage) {
            return new RebootEscrowManager(this.mContext, callbacks, storage, getHandler(getServiceThread()), getUserManagerInternal());
        }

        public int binderGetCallingUid() {
            return Binder.getCallingUid();
        }

        public boolean isGsiRunning() {
            return LockPatternUtils.isGsiRunning();
        }

        public FingerprintManager getFingerprintManager() {
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint") == true) goto L5;
            return null;
        L5:
            return (FingerprintManager) this.mContext.getSystemService("fingerprint");
        }

        public FaceManager getFaceManager() {
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.biometrics.face") == true) goto L5;
            return null;
        L5:
            return (FaceManager) this.mContext.getSystemService("face");
        }

        public BiometricManager getBiometricManager() {
            return (BiometricManager) this.mContext.getSystemService("biometric");
        }

        public KeyStore getKeyStore() {
            KeyStore ks = KeyStore.getInstance(SyntheticPasswordCrypto.androidKeystoreProviderName());     // Catch: Exception -> L4
            ks.load(new AndroidKeyStoreLoadStoreParameter(SyntheticPasswordCrypto.keyNamespace()));     // Catch: Exception -> L4
            return ks;
        L4:
            e = move-exception;
            throw new IllegalStateException("Cannot load keystore", e);
        }

        public KeyStoreAuthorization getKeyStoreAuthorization() {
            return KeyStoreAuthorization.getInstance();
        }

        public UnifiedProfilePasswordCache getUnifiedProfilePasswordCache(KeyStore ks) {
            return new UnifiedProfilePasswordCache(ks);
        }

        public boolean isHeadlessSystemUserMode() {
            return UserManager.isHeadlessSystemUserMode();
        }

        public boolean isMainUserPermanentAdmin() {
            return Resources.getSystem().getBoolean(R.bool.config_keepRestrictedProfilesInBackground);
        }
    }

    public static final class Lifecycle extends SystemService {
        private LockSettingsService mLockSettingsService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            AndroidKeyStoreProvider.install();
            this.mLockSettingsService = new LockSettingsService(getContext());
            publishBinderService("lock_settings", this.mLockSettingsService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            super.onBootPhase(phase);
            LockSettingsService.m5437$$Nest$monBootPhase(this.mLockSettingsService, phase);
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            LockSettingsService.m5441$$Nest$monUserStarting(this.mLockSettingsService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            LockSettingsService.m5442$$Nest$monUserUnlocking(this.mLockSettingsService, user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            this.mLockSettingsService.onUserStopped(user.getUserIdentifier());
        }
    }

    private final class LocalService extends LockSettingsInternal {
        final /* synthetic */ LockSettingsService this$0;

        /* synthetic */ LocalService(LockSettingsService r1, LockSettingsServiceIA r2) {
            this(r1);
        }

        private LocalService(LockSettingsService r1) {
            this.this$0 = r1;
        }

        public void onThirdPartyAppsStarted() {
            LockSettingsService.m5440$$Nest$monThirdPartyAppsStarted(this.this$0);
        }

        public void createNewUser(int userId, int userSerialNumber) {
            LockSettingsService.m5429$$Nest$mcreateNewUser(this.this$0, userId, userSerialNumber);
        }

        public void removeUser(int userId) {
            LockSettingsService.m5444$$Nest$mremoveUser(this.this$0, userId);
        }

        public long addEscrowToken(byte[] token, int userId, LockPatternUtils.EscrowTokenStateChangeCallback callback) {
            return LockSettingsService.m5428$$Nest$maddEscrowToken(this.this$0, token, 0, userId, callback);
        }

        public boolean removeEscrowToken(long handle, int userId) {
            return LockSettingsService.m5443$$Nest$mremoveEscrowToken(this.this$0, handle, userId);
        }

        public boolean isEscrowTokenActive(long handle, int userId) {
            return LockSettingsService.m5433$$Nest$misEscrowTokenActive(this.this$0, handle, userId);
        }

        public boolean setLockCredentialWithToken(LockscreenCredential credential, long tokenHandle, byte[] token, int userId) {
            if (this.this$0.mHasSecureLockScreen == true) goto L11;
            if (credential == null) goto L11;
            if (credential.getType() == (-1)) goto L11;
            throw new UnsupportedOperationException("This operation requires secure lock screen feature.");
        L11:
            if (LockSettingsService.m5445$$Nest$msetLockCredentialWithToken(this.this$0, credential, tokenHandle, token, userId) == true) goto L14;
            return false;
        L14:
            LockSettingsService.m5439$$Nest$monPostPasswordChanged(this.this$0, credential, userId);
            return true;
        }

        public boolean unlockUserWithToken(long tokenHandle, byte[] token, int userId) {
            return LockSettingsService.m5447$$Nest$munlockUserWithToken(this.this$0, tokenHandle, token, userId);
        }

        public PasswordMetrics getUserPasswordMetrics(int userHandle) {
            long identity = Binder.clearCallingIdentity();
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L4:
            if (LockSettingsService.m5434$$Nest$misProfileWithUnifiedLock(this.this$0, userHandle) == false) goto L8;
            Slog.w(LockSettingsService.TAG, "Querying password metrics for unified challenge profile: " + userHandle);     // Catch: Throwable -> L6
        L8:
            PasswordMetrics r2 = this.this$0.getUserPasswordMetrics(userHandle);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        }

        public boolean prepareRebootEscrow() {
            if (LockSettingsService.m5425$$Nest$fgetmRebootEscrowManager(this.this$0).prepareRebootEscrow() == true) goto L6;
            return false;
        L6:
            LockSettingsService.m5427$$Nest$fgetmStrongAuth(this.this$0).requireStrongAuth(64, -1);
            return true;
        }

        public void setRebootEscrowListener(RebootEscrowListener listener) {
            LockSettingsService.m5425$$Nest$fgetmRebootEscrowManager(this.this$0).setRebootEscrowListener(listener);
        }

        public boolean clearRebootEscrow() {
            if (LockSettingsService.m5425$$Nest$fgetmRebootEscrowManager(this.this$0).clearRebootEscrow() == true) goto L6;
            return false;
        L6:
            LockSettingsService.m5427$$Nest$fgetmStrongAuth(this.this$0).noLongerRequireStrongAuth(64, -1);
            return true;
        }

        public int armRebootEscrow() {
            return LockSettingsService.m5425$$Nest$fgetmRebootEscrowManager(this.this$0).armRebootEscrowIfNeeded();
        }

        public void refreshStrongAuthTimeout(int userId) {
            LockSettingsService.m5427$$Nest$fgetmStrongAuth(this.this$0).refreshStrongAuthTimeout(userId);
        }

        public void registerLockSettingsStateListener(LockSettingsStateListener listener) {
            listener.getClass();
            LockSettingsService.m5424$$Nest$fgetmLockSettingsStateListeners(this.this$0).add(listener);
        }

        public void unregisterLockSettingsStateListener(LockSettingsStateListener listener) {
            LockSettingsService.m5424$$Nest$fgetmLockSettingsStateListeners(this.this$0).remove(listener);
        }
    }

    private class RebootEscrowCallbacks implements RebootEscrowManager.Callbacks {
        final /* synthetic */ LockSettingsService this$0;

        /* synthetic */ RebootEscrowCallbacks(LockSettingsService r1, LockSettingsServiceIA r2) {
            this(r1);
        }

        private RebootEscrowCallbacks(LockSettingsService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.locksettings.RebootEscrowManager.Callbacks
        public boolean isUserSecure(int userId) {
            return LockSettingsService.m5435$$Nest$misUserSecure(this.this$0, userId);
        }

        @Override // com.android.server.locksettings.RebootEscrowManager.Callbacks
        public void onRebootEscrowRestored(byte spVersion, byte[] rawSyntheticPassword, int userId) {
            SyntheticPasswordManager.SyntheticPassword sp = new SyntheticPasswordManager.SyntheticPassword(spVersion);
            sp.recreateDirectly(rawSyntheticPassword);
            SyntheticPasswordManager r7 = LockSettingsService.m5426$$Nest$fgetmSpManager(this.this$0);
            monitor-enter(r7);
            LockSettingsService.m5426$$Nest$fgetmSpManager(this.this$0).verifyChallenge(LockSettingsService.m5430$$Nest$mgetGateKeeperService(this.this$0), sp, 0, userId);     // Catch: Throwable -> L10
            monitor-exit(r7);     // Catch: Throwable -> L10
            Slogf.i(LockSettingsService.TAG, "Restored synthetic password for user %d using reboot escrow", new Object[]{Integer.valueOf(userId)});
            LockSettingsService.m5438$$Nest$monCredentialVerified(this.this$0, sp, LockSettingsService.m5436$$Nest$mloadPasswordMetrics(this.this$0, sp, userId), userId);
            return;
        L12:
            th = move-exception;
            Throwable r11 = th;
        L14:
            monitor-exit(r7);     // Catch: Throwable -> L10
            throw r11;
        L10:
            th = move-exception;
            r11 = th;
            goto L14
        }
    }

    protected static class SynchronizedStrongAuthTracker extends LockPatternUtils.StrongAuthTracker {
        public SynchronizedStrongAuthTracker(Context context) {
            super(context);
        }

        protected void handleStrongAuthRequiredChanged(int strongAuthFlags, int userId) {
            monitor-enter(this);
            super.handleStrongAuthRequiredChanged(strongAuthFlags, userId);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public int getStrongAuthForUser(int userId) {
            monitor-enter(this);
            int r0 = super.getStrongAuthForUser(userId);     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        void register(LockSettingsStrongAuth strongAuth) {
            strongAuth.registerStrongAuthTracker(getStub());
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$FWVI1eyxB9tmDBzH0SOsZo-74ts, reason: not valid java name */
    public static /* synthetic */ void m5419$r8$lambda$FWVI1eyxB9tmDBzH0SOsZo74ts(LockSettingsService r0, int r1) {
        r0.lambda$setLockCredentialWithToken$8(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Fp2-_MnfZR3gmX_-iLJ7__JpSYc, reason: not valid java name */
    public static /* synthetic */ void m5420$r8$lambda$Fp2_MnfZR3gmX_iLJ7__JpSYc() {
        lambda$scheduleGc$9();
    }

    public static /* synthetic */ void $r8$lambda$NG5dIc9cUKIi9Raet18tJdg14BE(LockSettingsService r0) {
        r0.lambda$onBootPhase$0();
    }

    public static /* synthetic */ String $r8$lambda$S7zkKjAgMNeAKjHN4_9C5fuoMvQ(LockSettingsService r0) {
        return r0.lambda$getEncryptionNotificationTitle$1();
    }

    public static /* synthetic */ String $r8$lambda$XCm7_eZIpHxSQ45mdjNGOtd8Hlo(LockSettingsService r0) {
        return r0.lambda$getEncryptionNotificationDetail$2();
    }

    /* JADX INFO: renamed from: $r8$lambda$hiJP-SLuTLh5gLEsB8zZoC6u8Xg, reason: not valid java name */
    public static /* synthetic */ void m5421$r8$lambda$hiJPSLuTLh5gLEsB8zZoC6u8Xg(LockSettingsService r0, long r1) {
        r0.lambda$storeGatekeeperPasswordTemporarily$7(r1);
    }

    public static /* synthetic */ void $r8$lambda$ngCT3cMxpFEV5pkUvsRQ4poK3y8(LockSettingsService r0, LockscreenCredential r1, int r2) {
        r0.lambda$notifyPasswordChanged$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$vzY-KpEW3wradGt2aqXJJHw8JcU, reason: not valid java name */
    public static /* synthetic */ void m5422$r8$lambda$vzYKpEW3wradGt2aqXJJHw8JcU(int r0) {
        lambda$notifySeparateProfileChallengeChanged$4(r0);
    }

    public static /* synthetic */ String $r8$lambda$w16uzHbczcF_I4cEtr8QSBkbM5g(LockSettingsService r0) {
        return r0.lambda$getEncryptionNotificationMessage$3();
    }

    public static /* synthetic */ void $r8$lambda$w74_n37GJxjbhmy70RvsCtVpqp8(IWeakEscrowTokenActivatedListener r0, long r1, int r3) {
        lambda$addWeakEscrowToken$5(r0, r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5423$$Nest$fgetmContext(LockSettingsService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockSettingsStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m5424$$Nest$fgetmLockSettingsStateListeners(LockSettingsService r0) {
        return r0.mLockSettingsStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRebootEscrowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ RebootEscrowManager m5425$$Nest$fgetmRebootEscrowManager(LockSettingsService r0) {
        return r0.mRebootEscrowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyntheticPasswordManager m5426$$Nest$fgetmSpManager(LockSettingsService r0) {
        return r0.mSpManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrongAuth, reason: not valid java name */
    static /* bridge */ /* synthetic */ LockSettingsStrongAuth m5427$$Nest$fgetmStrongAuth(LockSettingsService r0) {
        return r0.mStrongAuth;
    }

    /* JADX INFO: renamed from: -$$Nest$maddEscrowToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m5428$$Nest$maddEscrowToken(LockSettingsService r0, byte[] r1, int r2, int r3, LockPatternUtils.EscrowTokenStateChangeCallback r4) {
        return r0.addEscrowToken(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateNewUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5429$$Nest$mcreateNewUser(LockSettingsService r0, int r1, int r2) {
        r0.createNewUser(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetGateKeeperService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IGateKeeperService m5430$$Nest$mgetGateKeeperService(LockSettingsService r0) {
        return r0.getGateKeeperService();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserProperties m5431$$Nest$mgetUserProperties(LockSettingsService r0, int r1) {
        return r0.getUserProperties(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhideEncryptionNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5432$$Nest$mhideEncryptionNotification(LockSettingsService r0, UserHandle r1) {
        r0.hideEncryptionNotification(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misEscrowTokenActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5433$$Nest$misEscrowTokenActive(LockSettingsService r0, long r1, int r3) {
        return r0.isEscrowTokenActive(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$misProfileWithUnifiedLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5434$$Nest$misProfileWithUnifiedLock(LockSettingsService r0, int r1) {
        return r0.isProfileWithUnifiedLock(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misUserSecure, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5435$$Nest$misUserSecure(LockSettingsService r0, int r1) {
        return r0.isUserSecure(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mloadPasswordMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ PasswordMetrics m5436$$Nest$mloadPasswordMetrics(LockSettingsService r0, SyntheticPasswordManager.SyntheticPassword r1, int r2) {
        return r0.loadPasswordMetrics(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monBootPhase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5437$$Nest$monBootPhase(LockSettingsService r0, int r1) {
        r0.onBootPhase(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monCredentialVerified, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5438$$Nest$monCredentialVerified(LockSettingsService r0, SyntheticPasswordManager.SyntheticPassword r1, PasswordMetrics r2, int r3) {
        r0.onCredentialVerified(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monPostPasswordChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5439$$Nest$monPostPasswordChanged(LockSettingsService r0, LockscreenCredential r1, int r2) {
        r0.onPostPasswordChanged(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monThirdPartyAppsStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5440$$Nest$monThirdPartyAppsStarted(LockSettingsService r0) {
        r0.onThirdPartyAppsStarted();
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStarting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5441$$Nest$monUserStarting(LockSettingsService r0, int r1) {
        r0.onUserStarting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserUnlocking, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5442$$Nest$monUserUnlocking(LockSettingsService r0, int r1) {
        r0.onUserUnlocking(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveEscrowToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5443$$Nest$mremoveEscrowToken(LockSettingsService r0, long r1, int r3) {
        return r0.removeEscrowToken(r1, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5444$$Nest$mremoveUser(LockSettingsService r0, int r1) {
        r0.removeUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetLockCredentialWithToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5445$$Nest$msetLockCredentialWithToken(LockSettingsService r0, LockscreenCredential r1, long r2, byte[] r4, int r5) {
        return r0.setLockCredentialWithToken(r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mtieProfileLockIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5446$$Nest$mtieProfileLockIfNecessary(LockSettingsService r0, int r1, LockscreenCredential r2) {
        r0.tieProfileLockIfNecessary(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munlockUserWithToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5447$$Nest$munlockUserWithToken(LockSettingsService r0, long r1, byte[] r3, int r4) {
        return r0.unlockUserWithToken(r1, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActivatedEncryptionNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5448$$Nest$mupdateActivatedEncryptionNotifications(LockSettingsService r0, String r1) {
        r0.updateActivatedEncryptionNotifications(r1);
    }

    static {
        mSavePassword = DEFAULT_PASSWORD;
        SYSTEM_CREDENTIAL_UIDS = new int[]{1016, 0, 1000};
    }

    private void onBootPhase(int phase) {
        if (phase != 550) goto L6;
        migrateOldDataAfterSystemReady();
        deleteRepairModePersistentDataIfNeeded();
        return;
    L6:
        if (phase != 1000) goto L10;
        this.mHandler.post(new LockSettingsService$$ExternalSyntheticLambda7(this));
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0() {
        destroyMigratedProtectors();
        loadEscrowData();
    }

    private LockscreenCredential generateRandomProfilePassword() {
        byte[] randomLockSeed = SecureRandomUtils.randomBytes(40);
        char[] newPasswordChars = HexEncoding.encode(randomLockSeed);
        byte[] newPassword = new byte[newPasswordChars.length];
        int i = 0;
    L4:
        if (i >= newPasswordChars.length) goto L6;
        newPassword[i] = (byte) newPasswordChars[i];
        i = i + 1;
        goto L4
    L6:
        LockscreenCredential credential = LockscreenCredential.createUnifiedProfilePassword(newPassword);
        LockPatternUtils.zeroize(newPasswordChars);
        LockPatternUtils.zeroize(newPassword);
        LockPatternUtils.zeroize(randomLockSeed);
        return credential;
    }

    private void tieProfileLockIfNecessary(int profileUserId, LockscreenCredential profileUserPassword) {
        if (isCredentialShareableWithParent(profileUserId) == true) goto L6;
        return;
    L6:
        if (getSeparateProfileChallengeEnabledInternal(profileUserId) == false) goto L9;
        return;
    L9:
        if (this.mStorage.hasChildProfileLock(profileUserId) == false) goto L11;
        return;
    L11:
        UserInfo parent = this.mUserManager.getProfileParent(profileUserId);
        if (parent != null) goto L15;
        return;
    L15:
        if (isUserSecure(parent.id) == false) goto L17;
    L41:
        long parentSid = getGateKeeperService().getSecureUserId(parent.id);     // Catch: RemoteException -> L36
        if (parentSid != 0) goto L24;
        return;
    L24:
        LockscreenCredential unifiedProfilePassword = generateRandomProfilePassword();
        setLockCredentialInternal(unifiedProfilePassword, profileUserPassword, profileUserId, true);     // Catch: Throwable -> L29
        tieProfileLockToParent(profileUserId, parent.id, unifiedProfilePassword);     // Catch: Throwable -> L29
        this.mUnifiedProfilePasswordCache.storePassword(profileUserId, unifiedProfilePassword, parentSid);     // Catch: Throwable -> L29
        if (unifiedProfilePassword == null) goto L45;
        unifiedProfilePassword.close();
        return;
    L45:
        return;
    L29:
        th = move-exception;
        if (unifiedProfilePassword != null) goto L39;
    L35:
        throw th;
    L39:
        unifiedProfilePassword.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
    L36:
        e = move-exception;
        Slog.e(TAG, "Failed to talk to GateKeeper service", e);
        return;
    L17:
        if (profileUserPassword.isNone() == true) goto L41;
        Slogf.i(TAG, "Clearing password for profile user %d to match parent", new Object[]{Integer.valueOf(profileUserId)});
        setLockCredentialInternal(LockscreenCredential.createNone(), profileUserPassword, profileUserId, true);
    }

    public LockSettingsService(Context context) {
        this(new Injector(context));
    }

    protected LockSettingsService(Injector injector) {
        this.mSeparateChallengeLock = new Object();
        this.mDeviceProvisionedObserver = new DeviceProvisionedObserver(this);
        this.mUserCreationAndRemovalLock = new Object();
        this.mEarlyCreatedUsers = new SparseIntArray();
        this.mEarlyRemovedUsers = new SparseIntArray();
        this.mProtectorsToDestroyOnBootCompleted = new ArrayList();
        this.mUserPasswordMetrics = new SparseArray();
        this.mHeadlessAuthSecretLock = new Object();
        this.mLockSettingsStateListeners = new CopyOnWriteArrayList();
        this.mGcWorkToken = new Object();
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mCeStorageLockEventListener = new AnonymousClass3(this);
        this.mInjector = injector;
        this.mContext = injector.getContext();
        this.mKeyStore = injector.getKeyStore();
        this.mKeyStoreAuthorization = injector.getKeyStoreAuthorization();
        this.mRecoverableKeyStoreManager = injector.getRecoverableKeyStoreManager();
        this.mHandler = injector.getHandler(injector.getServiceThread());
        this.mStrongAuth = injector.getStrongAuth();
        this.mActivityManager = injector.getActivityManager();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_STARTING");
        filter.addAction("android.intent.action.LOCALE_CHANGED");
        injector.getContext().registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
        this.mStorage = injector.getStorage();
        this.mNotificationManager = injector.getNotificationManager();
        this.mUserManager = injector.getUserManager();
        this.mStorageManager = injector.getStorageManager();
        this.mStorageManagerInternal = injector.getStorageManagerInternal();
        this.mStrongAuthTracker = injector.getStrongAuthTracker();
        this.mStrongAuthTracker.register(this.mStrongAuth);
        this.mGatekeeperPasswords = new LongSparseArray();
        this.mSpManager = injector.getSyntheticPasswordManager(this.mStorage);
        this.mUnifiedProfilePasswordCache = injector.getUnifiedProfilePasswordCache(this.mKeyStore);
        this.mBiometricDeferredQueue = new BiometricDeferredQueue(this.mSpManager);
        LockSettingsServiceIA r1 = null;
        this.mRebootEscrowManager = injector.getRebootEscrowManager(new RebootEscrowCallbacks(this, r1), this.mStorage);
        LocalServices.addService(LockSettingsInternal.class, new LocalService(this, r1));
    }

    private void updateActivatedEncryptionNotifications(String reason) {
        Iterator r0 = this.mUserManager.getUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        UserInfo userInfo = (UserInfo) r0.next();
        int r4 = 0;
        Context userContext = this.mContext.createContextAsUser(UserHandle.of(userInfo.id), 0);
        NotificationManager nm = (NotificationManager) userContext.getSystemService("notification");
        StatusBarNotification[] r5 = nm.getActiveNotifications();
        int r6 = r5.length;
    L7:
        if (r4 >= r6) goto L4;
        StatusBarNotification notification = r5[r4];
        if (notification.getId() == 9) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        maybeShowEncryptionNotificationForUser(userInfo.id, reason);
        goto L4
    }

    private void maybeShowEncryptionNotificationForUser(int userId, String reason) {
        UserInfo user = this.mUserManager.getUserInfo(userId);
        if (user.isManagedProfile() == true) goto L6;
        return;
    L6:
        if (isCeStorageUnlocked(userId) == false) goto L8;
        return;
    L8:
        UserHandle userHandle = user.getUserHandle();
        boolean isSecure = isUserSecure(userId);
        if (isSecure == true) goto L11;
        return;
    L11:
        if (this.mUserManager.isUserUnlockingOrUnlocked(userHandle) == true) goto L21;
        UserInfo parent = this.mUserManager.getProfileParent(userId);
        if (parent != null) goto L15;
        return;
    L15:
        if (this.mUserManager.isUserUnlockingOrUnlocked(parent.getUserHandle()) == true) goto L17;
        return;
    L17:
        if (this.mUserManager.isQuietModeEnabled(userHandle) == true) goto L24;
        showEncryptionNotificationForProfile(userHandle, parent.getUserHandle(), reason);
        return;
    L24:
        return;
    }

    private void showEncryptionNotificationForProfile(UserHandle user, UserHandle parent, String reason) {
        CharSequence title = getEncryptionNotificationTitle();
        CharSequence message = getEncryptionNotificationMessage();
        CharSequence detail = getEncryptionNotificationDetail();
        KeyguardManager km = (KeyguardManager) this.mContext.getSystemService("keyguard");
        Intent unlockIntent = km.createConfirmDeviceCredentialIntent(null, null, user.getIdentifier());
        if (unlockIntent != null) goto L6;
        return;
    L6:
        if (StorageManager.isFileEncrypted() == true) goto L8;
        return;
    L8:
        unlockIntent.setFlags(276824064);
        PendingIntent intent = PendingIntent.getActivityAsUser(this.mContext, 0, unlockIntent, AudioFormat.E_AC3, null, parent);
        Slogf.d(TAG, "Showing encryption notification for user %d; reason: %s", new Object[]{Integer.valueOf(user.getIdentifier()), reason});
        showEncryptionNotification(user, title, message, detail, intent);
    }

    private String getEncryptionNotificationTitle() {
        return this.mInjector.getDevicePolicyManager().getResources().getString("Core.PROFILE_ENCRYPTED_TITLE", new LockSettingsService$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ String lambda$getEncryptionNotificationTitle$1() {
        return this.mContext.getString(R.string.serviceEnabled);
    }

    private String getEncryptionNotificationDetail() {
        return this.mInjector.getDevicePolicyManager().getResources().getString("Core.PROFILE_ENCRYPTED_DETAIL", new LockSettingsService$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ String lambda$getEncryptionNotificationDetail$2() {
        return this.mContext.getString(R.string.serviceClassVoice);
    }

    private String getEncryptionNotificationMessage() {
        return this.mInjector.getDevicePolicyManager().getResources().getString("Core.PROFILE_ENCRYPTED_MESSAGE", new LockSettingsService$$ExternalSyntheticLambda8(this));
    }

    private /* synthetic */ String lambda$getEncryptionNotificationMessage$3() {
        return this.mContext.getString(R.string.serviceDisabled);
    }

    private void showEncryptionNotification(UserHandle user, CharSequence title, CharSequence message, CharSequence detail, PendingIntent intent) {
        Notification notification = new Notification.Builder(this.mContext, "DEVICE_ADMIN_ALERTS").setSmallIcon(R.drawable.pointer_wait_vector_27).setWhen(0).setOngoing(true).setTicker(title).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setSubText(detail).setVisibility(1).setContentIntent(intent).build();
        this.mNotificationManager.notifyAsUser(null, 9, notification, user);
    }

    private void hideEncryptionNotification(UserHandle userHandle) {
        Slogf.d(TAG, "Hiding encryption notification for user %d", new Object[]{Integer.valueOf(userHandle.getIdentifier())});
        this.mNotificationManager.cancelAsUser(null, 9, userHandle);
    }

    void onUserStopped(int userId) {
        hideEncryptionNotification(new UserHandle(userId));
        UserProperties userProperties = getUserProperties(userId);
        if (userProperties != null) goto L5;
    L7:
        int strongAuthRequired = LockPatternUtils.StrongAuthTracker.getDefaultFlags(this.mContext);
        requireStrongAuth(strongAuthRequired, userId);
        monitor-enter(this);
        this.mUserPasswordMetrics.remove(userId);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (userProperties.getAllowStoppingUserWithDelayedLocking() == false) goto L7;
    }

    private void onUserStarting(int userId) {
        maybeShowEncryptionNotificationForUser(userId, "user started");
    }

    private void removeStateForReusedUserIdIfNecessary(int userId, int serialNumber) {
        if (userId != 0) goto L4;
        return;
    L4:
        int storedSerialNumber = this.mStorage.getInt(USER_SERIAL_NUMBER_KEY, -1, userId);
        if (storedSerialNumber == serialNumber) goto L10;
        if (storedSerialNumber == (-1)) goto L8;
        Slogf.i(TAG, "Removing stale state for reused userId %d (serial %d => %d)", new Object[]{Integer.valueOf(userId), Integer.valueOf(storedSerialNumber), Integer.valueOf(serialNumber)});
        removeUserState(userId);
    L8:
        this.mStorage.setInt(USER_SERIAL_NUMBER_KEY, serialNumber, userId);
        return;
    }

    private void onUserUnlocking(final int userId) {
        this.mHandler.post(new AnonymousClass1(this, userId));
    }

    public void systemReady() {
        checkWritePermission();
        this.mHasSecureLockScreen = this.mContext.getPackageManager().hasSystemFeature("android.software.secure_lock_screen");
        migrateOldData();
        getAuthSecretHal();
        this.mDeviceProvisionedObserver.onSystemReady();
        LockPatternUtils.invalidateCredentialTypeCache();
        this.mStorage.prefetchUser(0);
        this.mBiometricDeferredQueue.systemReady(this.mInjector.getFingerprintManager(), this.mInjector.getFaceManager(), this.mInjector.getBiometricManager());
        this.mStorageManagerInternal.registerStorageLockEventListener(this.mCeStorageLockEventListener);
    }

    private void loadEscrowData() {
        this.mRebootEscrowManager.loadRebootEscrowDataIfAvailable(this.mHandler);
    }

    private void getAuthSecretHal() {
        this.mAuthSecretService = IAuthSecret.Stub.asInterface(ServiceManager.waitForDeclaredService(IAuthSecret.DESCRIPTOR + "/default"));
        if (this.mAuthSecretService == null) goto L15;
        Slog.i(TAG, "Device implements AIDL AuthSecret HAL");
        return;
    L15:
        android.hardware.authsecret.V1_0.IAuthSecret authSecretServiceHidl = android.hardware.authsecret.V1_0.IAuthSecret.getService(true);     // Catch: RemoteException -> L8 NoSuchElementException -> L10
        this.mAuthSecretService = new AuthSecretHidlAdapter(authSecretServiceHidl);     // Catch: RemoteException -> L8 NoSuchElementException -> L10
        Slog.i(TAG, "Device implements HIDL AuthSecret HAL");     // Catch: RemoteException -> L8 NoSuchElementException -> L10
        goto L13
    L19:
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Failed to get AuthSecret HAL(hidl)", e);
        return;
    L13:
        Slog.i(TAG, "Device doesn't implement AuthSecret HAL");
    }

    private void migrateOldData() {
        if (getString(MIGRATED_KEYSTORE_NS, null, 0) != null) goto L15;
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
        boolean success = true & this.mSpManager.migrateKeyNamespace();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        if ((success & migrateProfileLockKeys()) == false) goto L11;
        setString(MIGRATED_KEYSTORE_NS, "true", 0);
        Slog.i(TAG, "Migrated keys to LSS namespace");
        return;
    L11:
        Slog.w(TAG, "Failed to migrate keys to LSS namespace");
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void migrateOldDataAfterSystemReady() {
        if (LockPatternUtils.frpCredentialEnabled(this.mContext) == true) goto L5;
        return;
    L5:
        if (getBoolean(MIGRATED_FRP2, false, 0) == true) goto L9;
        migrateFrpCredential();
        setBoolean(MIGRATED_FRP2, true, 0);
        return;
    }

    private void migrateFrpCredential() {
        LockSettingsStorage.PersistentData data = this.mStorage.readPersistentDataBlock();
        if (data != LockSettingsStorage.PersistentData.NONE) goto L5;
    L7:
        Iterator r1 = this.mUserManager.getUsers().iterator();
    L9:
        if (r1.hasNext() == false) goto L23;
        UserInfo userInfo = (UserInfo) r1.next();
        if (LockPatternUtils.userOwnsFrpCredential(this.mContext, userInfo) == false) goto L9;
        if (isUserSecure(userInfo.id) == false) goto L9;
        SyntheticPasswordManager r3 = this.mSpManager;
        monitor-enter(r3);
        int actualQuality = (int) getLong("lockscreen.password_type", 0, userInfo.id);     // Catch: Throwable -> L19
        this.mSpManager.migrateFrpPasswordLocked(getCurrentLskfBasedProtectorId(userInfo.id), userInfo, redactActualQualityToMostLenientEquivalentQuality(actualQuality));     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L23:
        return;
    L5:
        if (data.isBadFormatFromAndroid14Beta() == true) goto L7;
    }

    private boolean migrateProfileLockKeys() {
        boolean success = true;
        List<UserInfo> users = this.mUserManager.getUsers();
        int userCount = users.size();
        int i = 0;
    L3:
        if (i >= userCount) goto L11;
        UserInfo user = users.get(i);
        if (isCredentialShareableWithParent(user.id) == false) goto L9;
        if (getSeparateProfileChallengeEnabledInternal(user.id) == true) goto L9;
        success = (success & SyntheticPasswordCrypto.migrateLockSettingsKey(PROFILE_KEY_NAME_ENCRYPT + user.id)) & SyntheticPasswordCrypto.migrateLockSettingsKey(PROFILE_KEY_NAME_DECRYPT + user.id);
    L9:
        i = i + 1;
        goto L3
    L11:
        return success;
    }

    void deleteRepairModePersistentDataIfNeeded() {
        if (LockPatternUtils.isRepairModeSupported(this.mContext) == true) goto L5;
        return;
    L5:
        if (LockPatternUtils.isRepairModeActive(this.mContext) == false) goto L7;
        return;
    L7:
        if (this.mInjector.isGsiRunning() == true) goto L13;
        this.mStorage.deleteRepairModePersistentData();
        return;
    }

    private boolean isWeaverDisabledOnUnsecuredUsers() {
        return this.mContext.getResources().getBoolean(R.bool.config_displayBlanksAfterDoze);
    }

    private void onThirdPartyAppsStarted() {
        Object r0 = this.mUserCreationAndRemovalLock;
        monitor-enter(r0);
        int i = 0;
    L41:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mEarlyRemovedUsers.size()) goto L10;
        int userId = this.mEarlyRemovedUsers.keyAt(i);     // Catch: Throwable -> L8
        Slogf.i(TAG, "Removing locksettings state for removed user %d now that boot is complete", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L8
        removeUserState(userId);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L41
    L10:
        this.mEarlyRemovedUsers = null;     // Catch: Throwable -> L8
        int i2 = 0;
    L12:
        if (i2 >= this.mEarlyCreatedUsers.size()) goto L14;
        int userId2 = this.mEarlyCreatedUsers.keyAt(i2);     // Catch: Throwable -> L8
        int serialNumber = this.mEarlyCreatedUsers.valueAt(i2);     // Catch: Throwable -> L8
        removeStateForReusedUserIdIfNecessary(userId2, serialNumber);     // Catch: Throwable -> L8
        Slogf.i(TAG, "Creating locksettings state for user %d now that boot is complete", new Object[]{Integer.valueOf(userId2)});     // Catch: Throwable -> L8
        initializeSyntheticPassword(userId2);     // Catch: Throwable -> L8
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        this.mEarlyCreatedUsers = null;     // Catch: Throwable -> L8
        if (getBoolean(MIGRATED_SP_FULL, false, 0) == true) goto L17;
    L20:
        Iterator r1 = this.mUserManager.getAliveUsers().iterator();     // Catch: Throwable -> L8
    L22:
        if (r1.hasNext() == false) goto L31;
        UserInfo user = (UserInfo) r1.next();     // Catch: Throwable -> L8
        removeStateForReusedUserIdIfNecessary(user.id, user.serialNumber);     // Catch: Throwable -> L8
        SyntheticPasswordManager r5 = this.mSpManager;     // Catch: Throwable -> L8
        monitor-enter(r5);     // Catch: Throwable -> L8
        migrateUserToSpWithBoundKeysLocked(user.id);     // Catch: Throwable -> L28
        monitor-exit(r5);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L31:
        setBoolean(MIGRATED_SP_FULL, true, 0);     // Catch: Throwable -> L8
        if (isWeaverDisabledOnUnsecuredUsers() == false) goto L34;
        setBoolean(MIGRATED_WEAVER_DISABLED_ON_UNSECURED_USERS, true, 0);     // Catch: Throwable -> L8
    L34:
        this.mThirdPartyAppsStarted = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        if (isWeaverDisabledOnUnsecuredUsers() == false) goto L34;
        if (getBoolean(MIGRATED_WEAVER_DISABLED_ON_UNSECURED_USERS, false, 0) == true) goto L34;
        goto L20
    }

    private void migrateUserToSpWithBoundKeysLocked(int userId) {
        if (isUserSecure(userId) == false) goto L6;
        Slogf.d(TAG, "User %d is secured; no migration needed", new Object[]{Integer.valueOf(userId)});
        return;
    L6:
        long protectorId = getCurrentLskfBasedProtectorId(userId);
        if (protectorId != 0) goto L10;
        Slogf.i(TAG, "Migrating unsecured user %d to SP-based credential", new Object[]{Integer.valueOf(userId)});
        initializeSyntheticPassword(userId);
        return;
    L10:
        Slogf.i(TAG, "Existing unsecured user %d has a synthetic password", new Object[]{Integer.valueOf(userId)});
        int userId2 = userId;
        SyntheticPasswordManager.AuthenticationResult result = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), protectorId, LockscreenCredential.createNone(), userId2, null);
        SyntheticPasswordManager.SyntheticPassword sp = result.syntheticPassword;
        if (isWeaverDisabledOnUnsecuredUsers() == false) goto L28;
        Slog.i(TAG, "config_disableWeaverOnUnsecuredUsers=true");
        int i = 0;
    L14:
        if (i >= 12) goto L17;
        if (sp != null) goto L17;
        Slog.e(TAG, "Failed to unwrap synthetic password. Waiting 5 seconds to retry.");
        SystemClock.sleep(5000);
        result = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), protectorId, LockscreenCredential.createNone(), userId2, null);
        sp = result.syntheticPassword;
        i = i + 1;
    L17:
        if (sp == null) goto L27;
        if (result.usedWeaver == false) goto L25;
        Slog.i(TAG, "Removing Weaver protection from the synthetic password");
        long newProtectorId = this.mSpManager.createLskfBasedProtector(getGateKeeperService(), LockscreenCredential.createNone(), sp, userId2);
        SyntheticPasswordManager.AuthenticationResult result2 = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), newProtectorId, LockscreenCredential.createNone(), userId2, null);
        userId2 = userId2;
        sp = result2.syntheticPassword;
        if (sp == null) goto L24;
        setCurrentLskfBasedProtectorId(newProtectorId, userId2);
        this.mProtectorsToDestroyOnBootCompleted.add(new Pair(Long.valueOf(protectorId), Integer.valueOf(userId2)));
    L29:
        Slogf.i(TAG, "Encrypting CE key of user %d with synthetic password", new Object[]{Integer.valueOf(userId2)});
        setCeStorageProtection(userId2, sp);
        Slogf.i(TAG, "Initializing Keystore super keys for user %d", new Object[]{Integer.valueOf(userId2)});
        initKeystoreSuperKeys(userId2, sp, true);
        return;
    L24:
        throw new IllegalStateException("New SP protector does not work");
    L25:
        Slog.i(TAG, "Synthetic password is already not protected by Weaver");
        goto L29
    L27:
        throw new IllegalStateException("Failed to unwrap synthetic password for unsecured user");
    L28:
        if (sp != null) goto L29;
        throw new IllegalStateException("Failed to unwrap synthetic password for unsecured user " + userId2);
    }

    private void destroyMigratedProtectors() {
        if (this.mProtectorsToDestroyOnBootCompleted.isEmpty() == true) goto L16;
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        Iterator<Pair<Long, Integer>> r1 = this.mProtectorsToDestroyOnBootCompleted.iterator();     // Catch: Throwable -> L10
    L8:
        if (r1.hasNext() == false) goto L12;
        Pair<Long, Integer> pair = r1.next();     // Catch: Throwable -> L10
        this.mSpManager.destroyLskfBasedProtector(((Long) pair.first).longValue(), ((Integer) pair.second).intValue());     // Catch: Throwable -> L10
        goto L8
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L16:
        this.mProtectorsToDestroyOnBootCompleted = null;
    }

    private int redactActualQualityToMostLenientEquivalentQuality(int quality) {
        switch(quality) {
            case 131072: goto L6;
            case 196608: goto L6;
            case 262144: goto L4;
            case 327680: goto L4;
            case 393216: goto L4;
            default: goto L3;
        };
    L3:
        return quality;
    L4:
        return 262144;
    L6:
        return 131072;
    }

    private void enforceFrpNotActive() {
        int mainUserId = this.mInjector.getUserManagerInternal().getMainUserId();
        if (mainUserId >= 0) goto L6;
        Slog.d(TAG, "No Main user on device; skipping enforceFrpNotActive");
        return;
    L6:
        ContentResolver cr = this.mContext.getContentResolver();
        if (Settings.Secure.getIntForUser(cr, "user_setup_complete", 0, mainUserId) == 0) goto L9;
    L9:
        boolean isFrpActive = this.mStorage.isFactoryResetProtectionActive();
        if (isFrpActive == true) goto L13;
        return;
    L13:
        throw new SecurityException("Cannot change credential while factory reset protection is active");
    }

    private final void checkWritePermission() {
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "LockSettingsWrite");
    }

    private final void checkPasswordReadPermission() {
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "LockSettingsRead");
    }

    private final void checkPasswordHavePermission() {
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "LockSettingsHave");
    }

    private final void checkDatabaseReadPermission(String requestedKey, int userId) {
        if (hasPermission(PERMISSION) == false) goto L6;
        return;
    L6:
        throw new SecurityException("uid=" + ILockSettings.Stub.getCallingUid() + " needs permission " + PERMISSION + " to read " + requestedKey + " for user " + userId);
    }

    private final void checkBiometricPermission() {
        this.mContext.enforceCallingOrSelfPermission(BIOMETRIC_PERMISSION, "LockSettingsBiometric");
    }

    private boolean hasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkManageWeakEscrowTokenMethodUsage() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_WEAK_ESCROW_TOKEN", "Requires MANAGE_WEAK_ESCROW_TOKEN permission.");
        if (RoSystemFeatures.hasFeatureAutomotive(this.mContext) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Weak escrow token are only for automotive devices.");
    }

    public boolean hasSecureLockScreen() {
        return this.mHasSecureLockScreen;
    }

    public boolean getSeparateProfileChallengeEnabled(int userId) {
        checkDatabaseReadPermission(SEPARATE_PROFILE_CHALLENGE_KEY, userId);
        return getSeparateProfileChallengeEnabledInternal(userId);
    }

    private boolean getSeparateProfileChallengeEnabledInternal(int userId) {
        Object r0 = this.mSeparateChallengeLock;
        monitor-enter(r0);
        boolean r1 = this.mStorage.getBoolean(SEPARATE_PROFILE_CHALLENGE_KEY, false, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSeparateProfileChallengeEnabled(int userId, boolean enabled, LockscreenCredential profileUserPassword) {
        checkWritePermission();
        if (this.mHasSecureLockScreen == true) goto L10;
        if (profileUserPassword == null) goto L10;
        if (profileUserPassword.getType() == (-1)) goto L10;
        throw new UnsupportedOperationException("This operation requires secure lock screen feature.");
    L10:
        Object r0 = this.mSeparateChallengeLock;
        monitor-enter(r0);
        if (profileUserPassword == null) goto L22;
        LockscreenCredential r1 = profileUserPassword;
    L15:
        setSeparateProfileChallengeEnabledLocked(userId, enabled, r1);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        notifySeparateProfileChallengeChanged(userId);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        r1 = LockscreenCredential.createNone();     // Catch: Throwable -> L19
        goto L15
    }

    private void setSeparateProfileChallengeEnabledLocked(int userId, boolean enabled, LockscreenCredential profileUserPassword) {
        boolean old = getBoolean(SEPARATE_PROFILE_CHALLENGE_KEY, false, userId);
        setBoolean(SEPARATE_PROFILE_CHALLENGE_KEY, enabled, userId);
        if (enabled == false) goto L7;
        this.mStorage.removeChildProfileLock(userId);     // Catch: IllegalStateException -> L5
        removeKeystoreProfileKey(userId);     // Catch: IllegalStateException -> L5
        return;
    L7:
        SyntheticPasswordManager r1 = this.mSpManager;     // Catch: IllegalStateException -> L5
        monitor-enter(r1);     // Catch: IllegalStateException -> L5
        tieProfileLockIfNecessary(userId, profileUserPassword);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: IllegalStateException -> L5
    L5:
        e = move-exception;
        setBoolean(SEPARATE_PROFILE_CHALLENGE_KEY, old, userId);
        throw e;
    }

    private void notifySeparateProfileChallengeChanged(final int userId) {
        this.mHandler.post(new LockSettingsService$$ExternalSyntheticLambda5(userId));
    }

    private static /* synthetic */ void lambda$notifySeparateProfileChallengeChanged$4(int userId) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmi == null) goto L6;
        dpmi.reportSeparateProfileChallengeChanged(userId);
        return;
    }

    public void setBoolean(String key, boolean value, int userId) {
        checkWritePermission();
        key.getClass();
        this.mStorage.setBoolean(key, value, userId);
    }

    public void setLong(String key, long value, int userId) {
        checkWritePermission();
        key.getClass();
        this.mStorage.setLong(key, value, userId);
    }

    public void setString(String key, String value, int userId) {
        checkWritePermission();
        key.getClass();
        this.mStorage.setString(key, value, userId);
    }

    public boolean getBoolean(String key, boolean defaultValue, int userId) {
        checkDatabaseReadPermission(key, userId);
        return this.mStorage.getBoolean(key, defaultValue, userId);
    }

    public long getLong(String key, long defaultValue, int userId) {
        checkDatabaseReadPermission(key, userId);
        return this.mStorage.getLong(key, defaultValue, userId);
    }

    public String getString(String key, String defaultValue, int userId) {
        checkDatabaseReadPermission(key, userId);
        return this.mStorage.getString(key, defaultValue, userId);
    }

    private int getKeyguardStoredQuality(int userId) {
        return (int) this.mStorage.getLong("lockscreen.password_type", 0, userId);
    }

    public int getPinLength(int userId) {
        checkPasswordHavePermission();
        PasswordMetrics passwordMetrics = getUserPasswordMetrics(userId);
        if (passwordMetrics != null) goto L5;
    L8:
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L15
        if (protectorId != 0) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L15
        return -1;
    L17:
        int r4 = this.mSpManager.getPinLength(protectorId, userId);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return r4;
    L15:
        th = move-exception;
        throw th;
    L5:
        if (passwordMetrics.credType != 3) goto L8;
        return passwordMetrics.length;
    }

    public boolean refreshStoredPinLength(int userId) {
        checkPasswordHavePermission();
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        PasswordMetrics passwordMetrics = getUserPasswordMetrics(userId);     // Catch: Throwable -> L9
        if (passwordMetrics == null) goto L11;
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L9
        boolean r4 = this.mSpManager.refreshPinLengthOnDisk(passwordMetrics, protectorId, userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L11:
        Log.w(TAG, "PasswordMetrics is not available");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public int getCredentialType(int userId) {
        checkPasswordHavePermission();
        return getCredentialTypeInternal(userId);
    }

    private int getCredentialTypeInternal(int userId) {
        if (LockPatternUtils.isSpecialUserId(userId) == true) goto L5;
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L13
        if (protectorId != 0) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return -1;
    L15:
        int rawType = this.mSpManager.getCredentialType(protectorId, userId);     // Catch: Throwable -> L13
        if (rawType == 2) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return rawType;
    L19:
        int r4 = LockPatternUtils.pinOrPasswordQualityToCredentialType(getKeyguardStoredQuality(userId));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L13:
        th = move-exception;
        throw th;
    L5:
        return this.mSpManager.getSpecialUserCredentialType(userId);
    }

    private boolean isUserSecure(int userId) {
        if (getCredentialTypeInternal(userId) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void retainPassword(String password) {
        if (LockPatternUtils.isDeviceEncryptionEnabled() == false) goto L8;
        if (password == null) goto L6;
        mSavePassword = password;
        return;
    L6:
        mSavePassword = DEFAULT_PASSWORD;
        return;
    }

    public void sanitizePassword() {
        if (LockPatternUtils.isDeviceEncryptionEnabled() == false) goto L6;
        mSavePassword = DEFAULT_PASSWORD;
        return;
    }

    private boolean checkCryptKeeperPermissions() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CRYPT_KEEPER", "no permission to get the password");     // Catch: SecurityException -> L5
        return false;
    L6:
        return true;
    }

    public String getPassword() {
        if (checkCryptKeeperPermissions() == false) goto L6;
        this.mContext.enforceCallingOrSelfPermission(PERMISSION, "no crypt_keeper or admin permission to get the password");
    L6:
        return mSavePassword;
    }

    void initKeystoreSuperKeys(int userId, SyntheticPasswordManager.SyntheticPassword sp, boolean allowExisting) {
        byte[] password = sp.deriveKeyStorePassword();
        int res = AndroidKeyStoreMaintenance.initUserSuperKeys(userId, password, allowExisting);     // Catch: Throwable -> L9
        if (res != 0) goto L8;
        LockPatternUtils.zeroize(password);
        return;
    L8:
        throw new IllegalStateException("Failed to initialize Keystore super keys for user " + userId);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        LockPatternUtils.zeroize(password);
        throw th;
    }

    private void unlockKeystore(int userId, SyntheticPasswordManager.SyntheticPassword sp) {
        this.mKeyStoreAuthorization.onDeviceUnlocked(userId, sp.deriveKeyStorePassword());
    }

    protected LockscreenCredential getDecryptedPasswordForTiedProfile(int userId) throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, CertificateException, IOException {
        Slogf.d(TAG, "Decrypting password for tied profile %d", new Object[]{Integer.valueOf(userId)});
        byte[] storedData = this.mStorage.readChildProfileLock(userId);
        if (storedData == null) goto L11;
        byte[] iv = Arrays.copyOfRange(storedData, 0, 12);
        byte[] encryptedPassword = Arrays.copyOfRange(storedData, 12, storedData.length);
        SecretKey decryptionKey = (SecretKey) this.mKeyStore.getKey(PROFILE_KEY_NAME_DECRYPT + userId, null);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, decryptionKey, new GCMParameterSpec(128, iv));
        byte[] decryptionResult = cipher.doFinal(encryptedPassword);
        LockscreenCredential credential = LockscreenCredential.createUnifiedProfilePassword(decryptionResult);
        LockPatternUtils.zeroize(decryptionResult);
        long parentSid = getGateKeeperService().getSecureUserId(this.mUserManager.getProfileParent(userId).id);     // Catch: RemoteException -> L7
        this.mUnifiedProfilePasswordCache.storePassword(userId, credential, parentSid);     // Catch: RemoteException -> L7
    L9:
        return credential;
    L7:
        e = move-exception;
        Slogf.w(TAG, "Failed to talk to GateKeeper service", e);
        goto L9
    L11:
        throw new FileNotFoundException("Child profile lock file not found");
    }

    private void unlockChildProfile(int profileHandle) {
        doVerifyCredential(getDecryptedPasswordForTiedProfile(profileHandle), profileHandle, null, 0);     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        if ((e instanceof FileNotFoundException) == false) goto L8;
        Slog.i(TAG, "Child profile key not found");
        return;
    L8:
        Slog.e(TAG, "Failed to decrypt child profile key", e);
    }

    private void unlockUser(int userId) {
        boolean alreadyUnlocked = this.mUserManager.isUserUnlockingOrUnlocked(userId);
        final CountDownLatch latch = new CountDownLatch(1);
        IProgressListener.Stub r2 = new AnonymousClass4(this, latch);
        this.mActivityManager.unlockUser2(userId, r2);     // Catch: RemoteException -> L42
        latch.await(15, TimeUnit.SECONDS);     // Catch: InterruptedException -> L6
    L9:
        if (isCredentialShareableWithParent(userId) == true) goto L11;
        Iterator r3 = this.mUserManager.getProfiles(userId).iterator();
    L16:
        if (r3.hasNext() == false) goto L40;
        UserInfo profile = (UserInfo) r3.next();
        if (profile.id == userId) goto L16;
        if (isCredentialShareableWithParent(profile.id) == false) goto L16;
        if (hasUnifiedChallenge(profile.id) == true) goto L26;
    L32:
        if (alreadyUnlocked == true) goto L16;
        long ident = ILockSettings.Stub.clearCallingIdentity();
        maybeShowEncryptionNotificationForUser(profile.id, "parent unlocked");     // Catch: Throwable -> L36
        ILockSettings.Stub.restoreCallingIdentity(ident);
    L36:
        th = move-exception;
        ILockSettings.Stub.restoreCallingIdentity(ident);
        throw th;
    L26:
        if (this.mUserManager.isUserRunning(profile.id) == false) goto L49;
        unlockChildProfile(profile.id);
        goto L32
    L49:
        getDecryptedPasswordForTiedProfile(profile.id);     // Catch: Throwable -> L30
    L30:
        e = move-exception;
        Slog.d(TAG, "Cache unified profile password failed", e);
        goto L32
    L40:
        this.mBiometricDeferredQueue.processPendingLockoutResets();
        return;
    L11:
        if (hasUnifiedChallenge(userId) == true) goto L62;
        this.mBiometricDeferredQueue.processPendingLockoutResets();
        return;
    L62:
        return;
    L7:
        Thread.currentThread().interrupt();
    L42:
        e = move-exception;
        throw e.rethrowAsRuntimeException();
    }

    private boolean hasUnifiedChallenge(int userId) {
        if (getSeparateProfileChallengeEnabledInternal(userId) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mStorage.hasChildProfileLock(userId) == false) goto L7;
        return true;
    }

    private Map<Integer, LockscreenCredential> getDecryptedPasswordsForAllTiedProfiles(int userId) {
        if (isCredentialShareableWithParent(userId) == false) goto L6;
        return null;
    L6:
        Map<Integer, LockscreenCredential> result = new ArrayMap();
        List<UserInfo> profiles = this.mUserManager.getProfiles(userId);
        int size = profiles.size();
        int i = 0;
    L7:
        if (i >= size) goto L20;
        UserInfo profile = profiles.get(i);
        if (isCredentialShareableWithParent(profile.id) == false) goto L18;
        int profileUserId = profile.id;
        if (getSeparateProfileChallengeEnabledInternal(profileUserId) == true) goto L18;
        result.put(Integer.valueOf(profileUserId), getDecryptedPasswordForTiedProfile(profileUserId));     // Catch: Throwable -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "getDecryptedPasswordsForAllTiedProfiles failed for user " + profileUserId, e);
    L18:
        i = i + 1;
        goto L7
    L20:
        return result;
    }

    private void synchronizeUnifiedChallengeForProfiles(int userId, Map<Integer, LockscreenCredential> profilePasswordMap) {
        if (isCredentialShareableWithParent(userId) == false) goto L5;
        return;
    L5:
        boolean isSecure = isUserSecure(userId);
        List<UserInfo> profiles = this.mUserManager.getProfiles(userId);
        int size = profiles.size();
        int i = 0;
    L6:
        if (i >= size) goto L21;
        UserInfo profile = profiles.get(i);
        int profileUserId = profile.id;
        if (isCredentialShareableWithParent(profileUserId) == false) goto L19;
        if (getSeparateProfileChallengeEnabledInternal(profileUserId) == true) goto L19;
        if (isSecure == false) goto L14;
        tieProfileLockIfNecessary(profileUserId, LockscreenCredential.createNone());
        goto L19
    L14:
        if (profilePasswordMap != null) goto L16;
    L18:
        Slog.wtf(TAG, "Attempt to clear tied challenge, but no password supplied.");
        goto L19
    L16:
        if (profilePasswordMap.containsKey(Integer.valueOf(profileUserId)) == false) goto L18;
        setLockCredentialInternal(LockscreenCredential.createNone(), profilePasswordMap.get(Integer.valueOf(profileUserId)), profileUserId, true);
        this.mStorage.removeChildProfileLock(profileUserId);
        removeKeystoreProfileKey(profileUserId);
    L19:
        i = i + 1;
        goto L6
    }

    private boolean isProfileWithUnifiedLock(int userId) {
        if (isCredentialShareableWithParent(userId) == true) goto L5;
    L7:
        return false;
    L5:
        if (getSeparateProfileChallengeEnabledInternal(userId) == true) goto L7;
        return true;
    }

    private void sendCredentialsOnUnlockIfRequired(LockscreenCredential credential, int userId) {
        if (LockPatternUtils.isSpecialUserId(userId) == false) goto L6;
        return;
    L6:
        if (credential.isNone() == false) goto L9;
        return;
    L9:
        if (isProfileWithUnifiedLock(userId) == false) goto L11;
        return;
    L11:
        Iterator<Integer> r0 = getProfilesWithSameLockScreen(userId).iterator();
    L13:
        if (r0.hasNext() == false) goto L15;
        int profileId = r0.next().intValue();
        this.mRecoverableKeyStoreManager.lockScreenSecretAvailable(credential.getType(), credential.getCredential(), profileId);
        goto L13
    }

    private void sendCredentialsOnChangeIfRequired(LockscreenCredential credential, int userId, boolean isLockTiedToParent) {
        if (isLockTiedToParent == false) goto L5;
        return;
    L5:
        if (credential.isNone() == false) goto L7;
        byte[] secret = null;
    L8:
        Iterator<Integer> r1 = getProfilesWithSameLockScreen(userId).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        int profileId = r1.next().intValue();
        this.mRecoverableKeyStoreManager.lockScreenSecretChanged(credential.getType(), secret, profileId);
        goto L10
    L12:
        return;
    L7:
        secret = credential.getCredential();
        goto L8
    }

    private Set<Integer> getProfilesWithSameLockScreen(int userId) {
        Set<Integer> profiles = new ArraySet();
        Iterator r1 = this.mUserManager.getProfiles(userId).iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UserInfo profile = (UserInfo) r1.next();
        if (profile.id == userId) goto L11;
        if (profile.profileGroupId != userId) goto L4;
        if (isProfileWithUnifiedLock(profile.id) == false) goto L4;
    L11:
        profiles.add(Integer.valueOf(profile.id));
        goto L4
    L13:
        return profiles;
    }

    public boolean setLockCredential(LockscreenCredential credential, LockscreenCredential savedCredential, int userId) {
        if (this.mHasSecureLockScreen == true) goto L11;
        if (credential == null) goto L11;
        if (credential.getType() == (-1)) goto L11;
        throw new UnsupportedOperationException("This operation requires secure lock screen feature");
    L11:
        if (hasPermission(PERMISSION) == false) goto L13;
    L21:
        credential.validateBasicRequirements();
        long identity = Binder.clearCallingIdentity();
        enforceFrpNotActive();     // Catch: Throwable -> L27
        if (savedCredential.isNone() == false) goto L25;
    L29:
        Object r0 = this.mSeparateChallengeLock;     // Catch: Throwable -> L27
        monitor-enter(r0);     // Catch: Throwable -> L27
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L32:
        if (setLockCredentialInternal(credential, savedCredential, userId, false) == true) goto L40;
        scheduleGc();     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        Binder.restoreCallingIdentity(identity);
        return false;
    L40:
        setSeparateProfileChallengeEnabledLocked(userId, true, null);     // Catch: Throwable -> L37
        notifyPasswordChanged(credential, userId);     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        if (isCredentialShareableWithParent(userId) == false) goto L45;
        setDeviceUnlockedForUser(userId);     // Catch: Throwable -> L27
    L45:
        notifySeparateProfileChallengeChanged(userId);     // Catch: Throwable -> L27
        onPostPasswordChanged(credential, userId);     // Catch: Throwable -> L27
        scheduleGc();     // Catch: Throwable -> L27
        if (savedCredential.getType() != (-1)) goto L51;
        if (credential.getType() == (-1)) goto L51;
        LockEventServiceManager.getInstance(this.mContext).sendLockEvent(1, credential.getType(), credential.getCredential(), new Bundle());     // Catch: Throwable -> L27
    L60:
        Binder.restoreCallingIdentity(identity);
        return true;
    L51:
        if (credential.getType() != (-1)) goto L56;
        if (savedCredential.getType() == (-1)) goto L56;
        LockEventServiceManager.getInstance(this.mContext).sendLockEvent(4, savedCredential.getType(), new byte[0], new Bundle());     // Catch: Throwable -> L27
    L56:
        if (credential.getType() == (-1)) goto L60;
        if (savedCredential.getType() == (-1)) goto L60;
        LockEventServiceManager.getInstance(this.mContext).sendLockEvent(3, credential.getType(), credential.getCredential(), new Bundle());     // Catch: Throwable -> L27
        goto L60
    L25:
        if (isProfileWithUnifiedLock(userId) == false) goto L29;
        verifyCredential(savedCredential, this.mUserManager.getProfileParent(userId).id, 0);     // Catch: Throwable -> L27
        savedCredential.zeroize();     // Catch: Throwable -> L27
        savedCredential = LockscreenCredential.createNone();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L13:
        if (hasPermission("android.permission.SET_AND_VERIFY_LOCKSCREEN_CREDENTIALS") == true) goto L21;
        if (hasPermission("android.permission.SET_INITIAL_LOCK") == false) goto L20;
        if (savedCredential.isNone() == true) goto L21;
    L20:
        throw new SecurityException("setLockCredential requires SET_AND_VERIFY_LOCKSCREEN_CREDENTIALS or android.permission.ACCESS_KEYGUARD_SECURE_STORAGE");
    }

    public boolean writeRepairModeCredential(int userId) {
        checkWritePermission();
        long identity = Binder.clearCallingIdentity();
        SyntheticPasswordManager r2 = this.mSpManager;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L9
        boolean r5 = this.mSpManager.writeRepairModeCredentialLocked(protectorId, userId);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return r5;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean setLockCredentialInternal(LockscreenCredential credential, LockscreenCredential savedCredential, int userId, boolean isLockTiedToParent) {
        credential.getClass();
        savedCredential.getClass();
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
        if (savedCredential.isNone() == true) goto L54;
    L16:
        LockscreenCredential savedCredential2 = savedCredential;
    L50:
        long oldProtectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L41
        SyntheticPasswordManager.AuthenticationResult authResult = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), oldProtectorId, savedCredential2, userId, null);     // Catch: Throwable -> L31
        VerifyCredentialResponse response = authResult.gkResponse;     // Catch: Throwable -> L31
        SyntheticPasswordManager.SyntheticPassword sp = authResult.syntheticPassword;     // Catch: Throwable -> L31
        if (sp == null) goto L22;
        onSyntheticPasswordUnlocked(userId, sp);     // Catch: Throwable -> L31
        setLockCredentialWithSpLocked(credential, sp, userId);     // Catch: Throwable -> L31
        sendCredentialsOnChangeIfRequired(credential, userId, isLockTiedToParent);     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return true;
    L22:
        if (response != null) goto L24;
    L35:
        Slog.w(TAG, "Failed to enroll: incorrect credential.");     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return false;
    L24:
        if (response.getResponseCode() == (-1)) goto L35;
        if (response.getResponseCode() != 1) goto L34;
        Slog.w(TAG, "Failed to enroll: rate limit exceeded.");     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return false;
    L34:
        throw new IllegalStateException("password change failed");     // Catch: Throwable -> L31
    L31:
        th = th;
    L55:
        monitor-exit(r1);     // Catch: Throwable -> L47
        throw th;
    L47:
        th = th;
    L41:
        th = th;
        goto L55
    L54:
    L10:
        th = th;
        goto L55
    L7:
        if (isProfileWithUnifiedLock(userId) == false) goto L16;
        savedCredential2 = getDecryptedPasswordForTiedProfile(userId);     // Catch: Throwable -> L10 Throwable -> L12 FileNotFoundException -> L14
        goto L50
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt child profile key", e);     // Catch: Throwable -> L10
    L15:
        Slog.i(TAG, "Child profile key not found");     // Catch: Throwable -> L10
    L43:
        th = th;
        goto L55
    }

    private void onPostPasswordChanged(LockscreenCredential newCredential, int userId) {
        updatePasswordHistory(newCredential, userId);
        ((TrustManager) this.mContext.getSystemService(TrustManager.class)).reportEnabledTrustAgentsChanged(userId);
        sendMainUserCredentialChangedNotificationIfNeeded(userId);
    }

    private void updatePasswordHistory(LockscreenCredential password, int userHandle) {
        if (password.isNone() == false) goto L6;
        return;
    L6:
        if (password.isPattern() == false) goto L8;
        return;
    L8:
        String passwordHistory = getString("lockscreen.passwordhistory", null, userHandle);
        if (passwordHistory != null) goto L11;
        passwordHistory = "";
    L11:
        int passwordHistoryLength = getRequestedPasswordHistoryLength(userHandle);
        if (passwordHistoryLength != 0) goto L14;
        String passwordHistory2 = "";
    L28:
        setString("lockscreen.passwordhistory", passwordHistory2, userHandle);
        return;
    L14:
        Slogf.d(TAG, "Adding new password to password history for user %d", new Object[]{Integer.valueOf(userHandle)});
        byte[] hashFactor = getHashFactor(password, userHandle);
        byte[] salt = getSalt(userHandle).getBytes();
        String hash = password.passwordToHistoryHash(salt, hashFactor);
        if (hash != null) goto L19;
        Slog.e(TAG, "Failed to compute password hash; password history won't be updated");
        return;
    L19:
        if (TextUtils.isEmpty(passwordHistory) == false) goto L21;
        passwordHistory2 = hash;
        goto L28
    L21:
        String[] history = passwordHistory.split(",");
        StringJoiner joiner = new StringJoiner(",");
        joiner.add(hash);
        int i = 0;
    L23:
        if (i >= (passwordHistoryLength - 1)) goto L27;
        if (i >= history.length) goto L27;
        joiner.add(history[i]);
        i = i + 1;
    L27:
        passwordHistory2 = joiner.toString();
        goto L28
    }

    private String getSalt(int userId) {
        long salt = getLong("lockscreen.password_salt", 0, userId);
        if (salt != 0) goto L6;
        salt = SecureRandomUtils.randomLong();
        setLong("lockscreen.password_salt", salt, userId);
    L6:
        return Long.toHexString(salt);
    }

    private int getRequestedPasswordHistoryLength(int userId) {
        return this.mInjector.getDevicePolicyManager().getPasswordHistoryLength(null, userId);
    }

    private UserProperties getUserProperties(int userId) {
        return this.mInjector.getUserManagerInternal().getUserProperties(userId);
    }

    protected boolean isCredentialShareableWithParent(int userId) {
        UserProperties props = getUserProperties(userId);
        if (props != null) goto L5;
    L7:
        return false;
    L5:
        if (props.isCredentialShareableWithParent() == false) goto L7;
        return true;
    }

    public boolean registerWeakEscrowTokenRemovedListener(IWeakEscrowTokenRemovedListener listener) {
        checkManageWeakEscrowTokenMethodUsage();
        long token = Binder.clearCallingIdentity();
        boolean r2 = this.mSpManager.registerWeakEscrowTokenRemovedListener(listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean unregisterWeakEscrowTokenRemovedListener(IWeakEscrowTokenRemovedListener listener) {
        checkManageWeakEscrowTokenMethodUsage();
        long token = Binder.clearCallingIdentity();
        boolean r2 = this.mSpManager.unregisterWeakEscrowTokenRemovedListener(listener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public long addWeakEscrowToken(byte[] token, int userId, final IWeakEscrowTokenActivatedListener listener) {
        checkManageWeakEscrowTokenMethodUsage();
        listener.getClass();
        LockPatternUtils.EscrowTokenStateChangeCallback internalListener = new LockSettingsService$$ExternalSyntheticLambda1(listener);
        long restoreToken = Binder.clearCallingIdentity();
        long r3 = addEscrowToken(token, 1, userId, internalListener);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(restoreToken);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(restoreToken);
        throw th;
    }

    private static /* synthetic */ void lambda$addWeakEscrowToken$5(IWeakEscrowTokenActivatedListener listener, long handle, int userId1) {
        listener.onWeakEscrowTokenActivated(handle, userId1);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Exception while notifying weak escrow token has been activated", e);
    }

    public boolean removeWeakEscrowToken(long handle, int userId) {
        checkManageWeakEscrowTokenMethodUsage();
        long token = Binder.clearCallingIdentity();
        boolean r2 = removeEscrowToken(handle, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean isWeakEscrowTokenActive(long handle, int userId) {
        checkManageWeakEscrowTokenMethodUsage();
        long token = Binder.clearCallingIdentity();
        boolean r2 = isEscrowTokenActive(handle, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean isWeakEscrowTokenValid(long handle, byte[] token, int userId) {
        checkManageWeakEscrowTokenMethodUsage();
        long restoreToken = Binder.clearCallingIdentity();
        SyntheticPasswordManager r3 = this.mSpManager;     // Catch: Throwable -> L33
        monitor-enter(r3);     // Catch: Throwable -> L33
    L27:
        th = th;
    L29:
        monitor-exit(r3);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Throwable r12 = th;
    L35:
        Binder.restoreCallingIdentity(restoreToken);
        throw r12;
    L7:
        if (this.mSpManager.hasEscrowData(userId) == false) goto L44;
        SyntheticPasswordManager.AuthenticationResult authResult = this.mSpManager.unlockWeakTokenBasedProtector(getGateKeeperService(), handle, token, userId);     // Catch: Throwable -> L22
        if (authResult.syntheticPassword != null) goto L24;
        Slog.w(TAG, "Invalid escrow token supplied");     // Catch: Throwable -> L22
        monitor-exit(r3);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(restoreToken);
        return false;
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(restoreToken);
        return true;
    L44:
        Slog.w(TAG, "Escrow token is disabled on the current user");     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(restoreToken);
        return false;
    L12:
        th = th;
    L22:
        th = th;
    L33:
        th = move-exception;
        r12 = th;
        goto L35
    }

    protected void tieProfileLockToParent(int profileUserId, int parentUserId, LockscreenCredential password) {
        Slogf.i(TAG, "Tying lock for profile user %d to parent user %d", new Object[]{Integer.valueOf(profileUserId), Integer.valueOf(parentUserId)});
        long parentSid = getGateKeeperService().getSecureUserId(parentUserId);     // Catch: RemoteException -> L22
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");     // Catch: Throwable -> L15
        keyGenerator.init(new SecureRandom());     // Catch: Throwable -> L15
        SecretKey secretKey = keyGenerator.generateKey();     // Catch: Throwable -> L15
        this.mKeyStore.setEntry(PROFILE_KEY_NAME_ENCRYPT + profileUserId, new KeyStore.SecretKeyEntry(secretKey), new KeyProtection.Builder(1).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build());     // Catch: Throwable -> L17
        this.mKeyStore.setEntry(PROFILE_KEY_NAME_DECRYPT + profileUserId, new KeyStore.SecretKeyEntry(secretKey), new KeyProtection.Builder(2).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).setUserAuthenticationRequired(true).setBoundToSpecificSecureUserId(parentSid).setUserAuthenticationValidityDurationSeconds(30).build());     // Catch: Throwable -> L17
        SecretKey keyStoreEncryptionKey = (SecretKey) this.mKeyStore.getKey(PROFILE_KEY_NAME_ENCRYPT + profileUserId, null);     // Catch: Throwable -> L17
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");     // Catch: Throwable -> L17
        cipher.init(1, keyStoreEncryptionKey);     // Catch: Throwable -> L17
        byte[] ciphertext = cipher.doFinal(password.getCredential());     // Catch: Throwable -> L17
        byte[] iv = cipher.getIV();     // Catch: Throwable -> L17
        this.mKeyStore.deleteEntry(PROFILE_KEY_NAME_ENCRYPT + profileUserId);     // Catch: Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15
        if (iv.length != 12) goto L14;
        this.mStorage.writeChildProfileLock(profileUserId, ArrayUtils.concat(new byte[][]{iv, ciphertext}));
        return;
    L14:
        throw new IllegalArgumentException("Invalid iv length: " + iv.length);
    L17:
        th = move-exception;
        this.mKeyStore.deleteEntry(PROFILE_KEY_NAME_ENCRYPT + profileUserId);     // Catch: Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15
        throw th;     // Catch: Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15 Throwable -> L15
    L15:
        e = move-exception;
        throw new IllegalStateException("Failed to encrypt key", e);
    L22:
        e = e;
    L27:
        throw new IllegalStateException("Failed to talk to GateKeeper service", e);
    L24:
        e = e;
        goto L27
    }

    private void setCeStorageProtection(int userId, SyntheticPasswordManager.SyntheticPassword sp) {
        byte[] secret = sp.deriveFileBasedEncryptionKey();
        long callingId = Binder.clearCallingIdentity();
        this.mStorageManager.setCeStorageProtection(userId, secret);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(callingId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingId);
        throw th;
    L8:
        e = move-exception;
        throw new IllegalStateException("Failed to protect CE key for user " + userId, e);     // Catch: Throwable -> L6
    }

    private boolean isCeStorageUnlocked(int userId) {
        return this.mStorageManager.isCeStorageUnlocked(userId);
    L4:
        e = move-exception;
        Slog.e(TAG, "Error checking whether CE storage is unlocked", e);
        return false;
    }

    private void unlockCeStorage(int userId, SyntheticPasswordManager.SyntheticPassword sp) {
        if (isCeStorageUnlocked(userId) == false) goto L7;
        Slogf.d(TAG, "CE storage for user %d is already unlocked", new Object[]{Integer.valueOf(userId)});
        return;
    L7:
        if (isUserSecure(userId) == false) goto L9;
        String userType = "secured";
    L10:
        byte[] secret = sp.deriveFileBasedEncryptionKey();
        this.mStorageManager.unlockCeStorage(userId, secret);     // Catch: Throwable -> L13 RemoteException -> L15
        Slogf.i(TAG, "Unlocked CE storage for %s user %d", new Object[]{userType, Integer.valueOf(userId)});     // Catch: Throwable -> L13 RemoteException -> L15
    L12:
        LockPatternUtils.zeroize(secret);
        return;
    L15:
        e = move-exception;
        Slogf.wtf(TAG, e, "Failed to unlock CE storage for %s user %d", new Object[]{userType, Integer.valueOf(userId)});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        LockPatternUtils.zeroize(secret);
        throw th;
    L9:
        userType = "unsecured";
        goto L10
    }

    public void unlockUserKeyIfUnsecured(int userId) {
        checkPasswordReadPermission();
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
    L28:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L34:
        if (isCeStorageUnlocked(userId) == false) goto L12;
        Slogf.d(TAG, "CE storage for user %d is already unlocked", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (isUserSecure(userId) == false) goto L16;
        Slogf.d(TAG, "Not unlocking CE storage for user %d yet because user is secured", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L16:
        Slogf.i(TAG, "Unwrapping synthetic password for unsecured user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L28
        SyntheticPasswordManager.AuthenticationResult result = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), getCurrentLskfBasedProtectorId(userId), LockscreenCredential.createNone(), userId, null);     // Catch: Throwable -> L23
        if (result.syntheticPassword != null) goto L25;
        Slogf.wtf(TAG, "Failed to unwrap synthetic password for unsecured user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L25:
        onSyntheticPasswordUnlocked(userId, result.syntheticPassword);     // Catch: Throwable -> L23
        unlockKeystore(userId, result.syntheticPassword);     // Catch: Throwable -> L23
        unlockCeStorage(userId, result.syntheticPassword);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L9:
        th = th;
    L23:
        th = th;
        goto L30
    }

    public void resetKeyStore(int userId) {
        checkWritePermission();
        Slogf.d(TAG, "Resetting keystore for user %d", new Object[]{Integer.valueOf(userId)});
        List<Integer> profileUserIds = new ArrayList();
        List<LockscreenCredential> profileUserDecryptedPasswords = new ArrayList();
        List<UserInfo> profiles = this.mUserManager.getProfiles(userId);
        Iterator<UserInfo> r7 = profiles.iterator();
    L4:
        if (r7.hasNext() == false) goto L71;
        UserInfo pi = r7.next();
        if (isCredentialShareableWithParent(pi.id) == false) goto L4;
        if (getSeparateProfileChallengeEnabledInternal(pi.id) == true) goto L4;
        if (this.mStorage.hasChildProfileLock(pi.id) == false) goto L4;
        profileUserDecryptedPasswords.add(getDecryptedPasswordForTiedProfile(pi.id));     // Catch: Throwable -> L13
        profileUserIds.add(Integer.valueOf(pi.id));     // Catch: Throwable -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt child profile key", e);
        goto L4
    L71:
        int[] r0 = this.mUserManager.getProfileIdsWithDisabled(userId);     // Catch: Throwable -> L49
        int r8 = r0.length;     // Catch: Throwable -> L49
        int r9 = 0;
    L18:
        if (r9 >= r8) goto L30;
        int profileId = r0[r9];     // Catch: Throwable -> L27
        int[] r11 = SYSTEM_CREDENTIAL_UIDS;     // Catch: Throwable -> L27
        int r12 = r11.length;     // Catch: Throwable -> L27
        int r13 = 0;
    L20:
        if (r13 >= r12) goto L29;
        int uid = r11[r13];     // Catch: Throwable -> L27
        List<Integer> profileUserIds2 = profileUserIds;
        AndroidKeyStoreMaintenance.clearNamespace(0, UserHandle.getUid(profileId, uid));     // Catch: Throwable -> L25
        r13 = r13 + 1;
        profileUserIds = profileUserIds2;
    L25:
        th = th;
        List<Integer> profileUserIds3 = profileUserIds2;
    L51:
        int i = 0;
    L53:
        if (i >= profileUserIds3.size()) goto L62;
        int piUserId = profileUserIds3.get(i).intValue();
        LockscreenCredential piUserDecryptedPassword = profileUserDecryptedPasswords.get(i);
        if (piUserId == (-1)) goto L58;
        if (piUserDecryptedPassword == null) goto L58;
        tieProfileLockToParent(piUserId, userId, piUserDecryptedPassword);
    L58:
        if (piUserDecryptedPassword == null) goto L60;
        piUserDecryptedPassword.zeroize();
    L60:
        i = i + 1;
        goto L53
    L62:
        throw th;
    L29:
        r9 = r9 + 1;
    L27:
        th = th;
        profileUserIds3 = profileUserIds;
        goto L51
    L30:
        profileUserIds2 = profileUserIds;
        if (this.mUserManager.getUserInfo(userId).isPrimary() == true) goto L34;
    L35:
        int i2 = 0;
    L37:
        if (i2 >= profileUserIds2.size()) goto L46;
        List<Integer> profileUserIds4 = profileUserIds2;
        int piUserId2 = profileUserIds4.get(i2).intValue();
        LockscreenCredential piUserDecryptedPassword2 = profileUserDecryptedPasswords.get(i2);
        if (piUserId2 == (-1)) goto L42;
        if (piUserDecryptedPassword2 == null) goto L42;
        tieProfileLockToParent(piUserId2, userId, piUserDecryptedPassword2);
    L42:
        if (piUserDecryptedPassword2 == null) goto L44;
        piUserDecryptedPassword2.zeroize();
    L44:
        i2 = i2 + 1;
        profileUserIds2 = profileUserIds4;
        goto L37
    L46:
        return;
    L34:
        AndroidKeyStoreMaintenance.clearNamespace(2, 102);     // Catch: Throwable -> L25
    L47:
        th = th;
        profileUserIds3 = profileUserIds2;
    L49:
        th = th;
        profileUserIds3 = profileUserIds;
        goto L51
    }

    public VerifyCredentialResponse checkCredential(LockscreenCredential credential, int userId, ICheckCredentialProgressCallback progressCallback) {
        checkPasswordReadPermission();
        long identity = Binder.clearCallingIdentity();
        VerifyCredentialResponse response = doVerifyCredential(credential, userId, progressCallback, 0);     // Catch: Throwable -> L12
        if (response.getResponseCode() != 0) goto L14;
        if (userId != 0) goto L14;
        if (credential.isNone() == false) goto L9;
        String credentialString = null;
    L10:
        retainPassword(credentialString);     // Catch: Throwable -> L12
        goto L14
    L9:
        credentialString = new String(credential.getCredential());     // Catch: Throwable -> L12
    L14:
        Binder.restoreCallingIdentity(identity);
        scheduleGc();
        return response;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        scheduleGc();
        throw th;
    }

    public VerifyCredentialResponse verifyCredential(LockscreenCredential credential, int userId, int flags) {
        if (hasPermission(PERMISSION) == false) goto L5;
    L9:
        long identity = Binder.clearCallingIdentity();
        VerifyCredentialResponse response = doVerifyCredential(credential, userId, null, flags);     // Catch: Throwable -> L14
        if (response.getResponseCode() != 0) goto L16;
        LockEventServiceManager.getInstance(this.mContext).sendLockEvent(2, credential.getType(), credential.getCredential(), new Bundle());     // Catch: Throwable -> L14
    L16:
        Binder.restoreCallingIdentity(identity);
        scheduleGc();
        return response;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        scheduleGc();
        throw th;
    L5:
        if (hasPermission("android.permission.SET_AND_VERIFY_LOCKSCREEN_CREDENTIALS") == true) goto L9;
        throw new SecurityException("verifyCredential requires SET_AND_VERIFY_LOCKSCREEN_CREDENTIALS or android.permission.ACCESS_KEYGUARD_SECURE_STORAGE");
    }

    public VerifyCredentialResponse verifyGatekeeperPasswordHandle(long gatekeeperPasswordHandle, long challenge, int userId) {
        checkPasswordReadPermission();
        LongSparseArray<byte[]> r1 = this.mGatekeeperPasswords;
        monitor-enter(r1);
        byte[] gatekeeperPassword = this.mGatekeeperPasswords.get(gatekeeperPasswordHandle);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        SyntheticPasswordManager r8 = this.mSpManager;
        monitor-enter(r8);
        if (gatekeeperPassword != null) goto L35;
        Slog.d(TAG, "No gatekeeper password for handle");     // Catch: Throwable -> L11
        VerifyCredentialResponse response = VerifyCredentialResponse.ERROR;     // Catch: Throwable -> L11
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L18
        return response;
    L11:
        th = th;
    L22:
        monitor-exit(r8);     // Catch: Throwable -> L18
        throw th;
    L35:
        response = this.mSpManager.verifyChallengeInternal(getGateKeeperService(), gatekeeperPassword, challenge, userId);     // Catch: Throwable -> L18
    L20:
        th = th;
    L18:
        th = th;
    L24:
        th = th;
    L30:
        throw th;
    L28:
        th = th;
        goto L30
    }

    public void removeGatekeeperPasswordHandle(long gatekeeperPasswordHandle) {
        checkPasswordReadPermission();
        LongSparseArray<byte[]> r0 = this.mGatekeeperPasswords;
        monitor-enter(r0);
        this.mGatekeeperPasswords.remove(gatekeeperPasswordHandle);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private VerifyCredentialResponse doVerifyCredential(LockscreenCredential credential, int userId, ICheckCredentialProgressCallback progressCallback, int flags) {
        if (credential == null) goto L59;
        if (credential.isNone() == true) goto L59;
        boolean success = false;
        if (userId != (-9999)) goto L12;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L12;
        Slog.e(TAG, "FRP credential can only be verified prior to provisioning.");
        return VerifyCredentialResponse.ERROR;
    L12:
        if (userId == (-9998)) goto L14;
    L17:
        Slogf.i(TAG, "Verifying lockscreen credential for user %d", new Object[]{Integer.valueOf(userId)});
        SyntheticPasswordManager r8 = this.mSpManager;
        monitor-enter(r8);
    L25:
        th = move-exception;
        throw th;
    L20:
        if (LockPatternUtils.isSpecialUserId(userId) == false) goto L29;
        VerifyCredentialResponse response = this.mSpManager.verifySpecialUserCredential(userId, getGateKeeperService(), credential, progressCallback);     // Catch: Throwable -> L25
        if (response.isMatched() == false) goto L27;
        if (userId != (-9999)) goto L27;
        this.mStorage.deactivateFactoryResetProtectionWithoutSecret();     // Catch: Throwable -> L25
    L27:
        monitor-exit(r8);     // Catch: Throwable -> L25
        return response;
    L29:
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L25
        SyntheticPasswordManager.AuthenticationResult authResult = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), protectorId, credential, userId, progressCallback);     // Catch: Throwable -> L25
        VerifyCredentialResponse response2 = authResult.gkResponse;     // Catch: Throwable -> L25
        if (response2.getResponseCode() == 0) goto L32;
    L39:
        monitor-exit(r8);     // Catch: Throwable -> L25
        if (response2.getResponseCode() != 0) goto L47;
        Slogf.i(TAG, "Successfully verified lockscreen credential for user %d", new Object[]{Integer.valueOf(userId)});
        onCredentialVerified(authResult.syntheticPassword, PasswordMetrics.computeForCredential(credential), userId);
        if ((flags & 1) == 0) goto L45;
        long gkHandle = storeGatekeeperPasswordTemporarily(authResult.syntheticPassword.deriveGkPassword());
        response2 = new VerifyCredentialResponse.Builder().setGatekeeperPasswordHandle(gkHandle).build();
    L45:
        sendCredentialsOnUnlockIfRequired(credential, userId);
    L52:
        if (response2.getResponseCode() != 0) goto L54;
        success = true;
    L54:
        notifyLockSettingsStateListeners(success, userId);
        return response2;
    L47:
        if (response2.getResponseCode() != 1) goto L52;
        if (response2.getTimeout() <= 0) goto L52;
        requireStrongAuth(8, userId);
        goto L52
    L32:
        if ((flags & 2) != 0) goto L34;
    L38:
        this.mBiometricDeferredQueue.addPendingLockoutResetForUser(userId, authResult.syntheticPassword.deriveGkPassword());     // Catch: Throwable -> L25
        goto L39
    L34:
        if (this.mSpManager.writeRepairModeCredentialLocked(protectorId, userId) == true) goto L38;
        Slog.e(TAG, "Failed to write repair mode credential");     // Catch: Throwable -> L25
        VerifyCredentialResponse r0 = VerifyCredentialResponse.ERROR;     // Catch: Throwable -> L25
        monitor-exit(r8);     // Catch: Throwable -> L25
        return r0;
    L14:
        if (LockPatternUtils.isRepairModeActive(this.mContext) == true) goto L17;
        Slog.e(TAG, "Repair mode is not active on the device.");
        return VerifyCredentialResponse.ERROR;
    L59:
        throw new IllegalArgumentException("Credential can't be null or empty");
    }

    private void notifyLockSettingsStateListeners(boolean success, int userId) {
        Iterator<LockSettingsStateListener> r0 = this.mLockSettingsStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        LockSettingsStateListener listener = r0.next();
        if (success == true) goto L7;
        listener.onAuthenticationFailed(userId);
        goto L4
    L7:
        listener.onAuthenticationSucceeded(userId);
        goto L4
    }

    public VerifyCredentialResponse verifyTiedProfileChallenge(LockscreenCredential credential, int userId, int flags) {
        checkPasswordReadPermission();
        Slogf.i(TAG, "Verifying tied profile challenge for user %d", new Object[]{Integer.valueOf(userId)});
        if (isProfileWithUnifiedLock(userId) == false) goto L18;
        int parentProfileId = this.mUserManager.getProfileParent(userId).id;
        VerifyCredentialResponse parentResponse = doVerifyCredential(credential, parentProfileId, null, flags);
        if (parentResponse.getResponseCode() == 0) goto L19;
        return parentResponse;
    L19:
        VerifyCredentialResponse r1 = doVerifyCredential(getDecryptedPasswordForTiedProfile(userId), userId, null, flags);     // Catch: Throwable -> L10 Throwable -> L12
        scheduleGc();
        return r1;
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to decrypt child profile key", e);     // Catch: Throwable -> L10
        throw new IllegalStateException("Unable to get tied profile token");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        scheduleGc();
        throw th;
    L18:
        throw new IllegalArgumentException("User id must be managed/clone profile with unified lock");
    }

    private void setUserPasswordMetrics(LockscreenCredential password, int userHandle) {
        monitor-enter(this);
        this.mUserPasswordMetrics.put(userHandle, PasswordMetrics.computeForCredential(password));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    PasswordMetrics getUserPasswordMetrics(int userHandle) {
        if (isUserSecure(userHandle) == false) goto L5;
        monitor-enter(this);
        PasswordMetrics r0 = this.mUserPasswordMetrics.get(userHandle);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r0;
    L10:
        th = move-exception;
        throw th;
    L5:
        return new PasswordMetrics(-1);
    }

    private PasswordMetrics loadPasswordMetrics(SyntheticPasswordManager.SyntheticPassword sp, int userHandle) {
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isUserSecure(userHandle) == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        PasswordMetrics r1 = this.mSpManager.getPasswordMetrics(sp, getCurrentLskfBasedProtectorId(userHandle), userHandle);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    private void notifyPasswordChanged(final LockscreenCredential newCredential, final int userId) {
        this.mHandler.post(new LockSettingsService$$ExternalSyntheticLambda4(this, newCredential, userId));
    }

    private /* synthetic */ void lambda$notifyPasswordChanged$6(LockscreenCredential newCredential, int userId) {
        this.mInjector.getDevicePolicyManager().reportPasswordChanged(PasswordMetrics.computeForCredential(newCredential), userId);
        ((WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class)).reportPasswordChanged(userId);
    }

    private void createNewUser(int userId, int userSerialNumber) {
        AndroidKeyStoreMaintenance.onUserAdded(userId);
        Object r0 = this.mUserCreationAndRemovalLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mThirdPartyAppsStarted == true) goto L11;
        Slogf.i(TAG, "Delaying locksettings state creation for user %d until third-party apps are started", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L9
        this.mEarlyCreatedUsers.put(userId, userSerialNumber);     // Catch: Throwable -> L9
        this.mEarlyRemovedUsers.delete(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        removeStateForReusedUserIdIfNecessary(userId, userSerialNumber);     // Catch: Throwable -> L9
        initializeSyntheticPassword(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void removeUser(int userId) {
        Object r0 = this.mUserCreationAndRemovalLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mThirdPartyAppsStarted == true) goto L14;
        Slogf.i(TAG, "Delaying locksettings state removal for user %d until third-party apps are started", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L9
        if (this.mEarlyCreatedUsers.indexOfKey(userId) < 0) goto L11;
        this.mEarlyCreatedUsers.delete(userId);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mEarlyRemovedUsers.put(userId, -1);     // Catch: Throwable -> L9
        goto L12
    L14:
        Slogf.i(TAG, "Removing state for user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L9
        removeUserState(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void removeUserState(int userId) {
        removeBiometricsForUser(userId);
        this.mSpManager.removeUser(getGateKeeperService(), userId);
        this.mStrongAuth.removeUser(userId);
        AndroidKeyStoreMaintenance.onUserRemoved(userId);
        this.mUnifiedProfilePasswordCache.removePassword(userId);
        gateKeeperClearSecureUserId(userId);
        removeKeystoreProfileKey(userId);
        this.mStorage.removeUser(userId);
    }

    private void removeKeystoreProfileKey(int targetUserId) {
        String encryptAlias = PROFILE_KEY_NAME_ENCRYPT + targetUserId;
        String decryptAlias = PROFILE_KEY_NAME_DECRYPT + targetUserId;
    L8:
        e = move-exception;
        Slogf.e(TAG, e, "Error removing keystore profile key for user %d", new Object[]{Integer.valueOf(targetUserId)});
        return;
    L4:
        if (this.mKeyStore.containsAlias(encryptAlias) == true) goto L10;
        if (this.mKeyStore.containsAlias(decryptAlias) == true) goto L10;
        return;
    L10:
        Slogf.i(TAG, "Removing keystore profile key for user %d", new Object[]{Integer.valueOf(targetUserId)});     // Catch: KeyStoreException -> L8
        this.mKeyStore.deleteEntry(encryptAlias);     // Catch: KeyStoreException -> L8
        this.mKeyStore.deleteEntry(decryptAlias);     // Catch: KeyStoreException -> L8
    }

    public void registerStrongAuthTracker(IStrongAuthTracker tracker) {
        checkPasswordReadPermission();
        this.mStrongAuth.registerStrongAuthTracker(tracker);
    }

    public void unregisterStrongAuthTracker(IStrongAuthTracker tracker) {
        checkPasswordReadPermission();
        this.mStrongAuth.unregisterStrongAuthTracker(tracker);
    }

    public void requireStrongAuth(int strongAuthReason, int userId) {
        checkWritePermission();
        this.mStrongAuth.requireStrongAuth(strongAuthReason, userId);
    }

    public void reportSuccessfulBiometricUnlock(boolean isStrongBiometric, int userId) {
        checkBiometricPermission();
        this.mStrongAuth.reportSuccessfulBiometricUnlock(isStrongBiometric, userId);
    }

    public void scheduleNonStrongBiometricIdleTimeout(int userId) {
        checkBiometricPermission();
        this.mStrongAuth.scheduleNonStrongBiometricIdleTimeout(userId);
    }

    public void userPresent(int userId) {
        checkWritePermission();
        this.mStrongAuth.reportUnlock(userId);
    }

    public int getStrongAuthForUser(int userId) {
        checkPasswordReadPermission();
        return this.mStrongAuthTracker.getStrongAuthForUser(userId);
    }

    private boolean isCallerShell() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 2000) goto L7;
        if (callingUid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void enforceShell() {
        if (isCallerShell() == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller must be shell");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        enforceShell();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        if (ArrayUtils.isEmpty(args) == false) goto L5;
        String r0 = "";
    L6:
        Slogf.i(TAG, "Executing shell command '%s'; callingPid=%d, callingUid=%d", new Object[]{r0, Integer.valueOf(callingPid), Integer.valueOf(callingUid)});
        long origId = Binder.clearCallingIdentity();
        LockSettingsShellCommand command = new LockSettingsShellCommand(new LockPatternUtils(this.mContext), this.mContext, callingPid, callingUid);     // Catch: Throwable -> L10
        command.exec(this, in, out, err, args, callback, resultReceiver);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(origId);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L5:
        r0 = args[0];
        goto L6
    }

    public void initRecoveryServiceWithSigFile(String rootCertificateAlias, byte[] recoveryServiceCertFile, byte[] recoveryServiceSigFile) throws RemoteException {
        this.mRecoverableKeyStoreManager.initRecoveryServiceWithSigFile(rootCertificateAlias, recoveryServiceCertFile, recoveryServiceSigFile);
    }

    public KeyChainSnapshot getKeyChainSnapshot() throws RemoteException {
        return this.mRecoverableKeyStoreManager.getKeyChainSnapshot();
    }

    public void setSnapshotCreatedPendingIntent(PendingIntent intent) throws RemoteException {
        this.mRecoverableKeyStoreManager.setSnapshotCreatedPendingIntent(intent);
    }

    public void setServerParams(byte[] serverParams) throws RemoteException {
        this.mRecoverableKeyStoreManager.setServerParams(serverParams);
    }

    public void setRecoveryStatus(String alias, int status) throws RemoteException {
        this.mRecoverableKeyStoreManager.setRecoveryStatus(alias, status);
    }

    public Map getRecoveryStatus() throws RemoteException {
        return this.mRecoverableKeyStoreManager.getRecoveryStatus();
    }

    public void setRecoverySecretTypes(int[] secretTypes) throws RemoteException {
        this.mRecoverableKeyStoreManager.setRecoverySecretTypes(secretTypes);
    }

    public int[] getRecoverySecretTypes() throws RemoteException {
        return this.mRecoverableKeyStoreManager.getRecoverySecretTypes();
    }

    public byte[] startRecoverySessionWithCertPath(String sessionId, String rootCertificateAlias, RecoveryCertPath verifierCertPath, byte[] vaultParams, byte[] vaultChallenge, List<KeyChainProtectionParams> secrets) throws RemoteException {
        return this.mRecoverableKeyStoreManager.startRecoverySessionWithCertPath(sessionId, rootCertificateAlias, verifierCertPath, vaultParams, vaultChallenge, secrets);
    }

    public Map<String, String> recoverKeyChainSnapshot(String sessionId, byte[] recoveryKeyBlob, List<WrappedApplicationKey> applicationKeys) throws RemoteException {
        return this.mRecoverableKeyStoreManager.recoverKeyChainSnapshot(sessionId, recoveryKeyBlob, applicationKeys);
    }

    public void closeSession(String sessionId) throws RemoteException {
        this.mRecoverableKeyStoreManager.closeSession(sessionId);
    }

    public void removeKey(String alias) throws RemoteException {
        this.mRecoverableKeyStoreManager.removeKey(alias);
    }

    public String generateKey(String alias) throws RemoteException {
        return this.mRecoverableKeyStoreManager.generateKey(alias);
    }

    public String generateKeyWithMetadata(String alias, byte[] metadata) throws RemoteException {
        return this.mRecoverableKeyStoreManager.generateKeyWithMetadata(alias, metadata);
    }

    public String importKey(String alias, byte[] keyBytes) throws RemoteException {
        return this.mRecoverableKeyStoreManager.importKey(alias, keyBytes);
    }

    public String importKeyWithMetadata(String alias, byte[] keyBytes, byte[] metadata) throws RemoteException {
        return this.mRecoverableKeyStoreManager.importKeyWithMetadata(alias, keyBytes, metadata);
    }

    public String getKey(String alias) throws RemoteException {
        return this.mRecoverableKeyStoreManager.getKey(alias);
    }

    public RemoteLockscreenValidationSession startRemoteLockscreenValidation() {
        return this.mRecoverableKeyStoreManager.startRemoteLockscreenValidation(this);
    }

    public RemoteLockscreenValidationResult validateRemoteLockscreen(byte[] encryptedCredential) {
        return this.mRecoverableKeyStoreManager.validateRemoteLockscreen(encryptedCredential, this);
    }

    private synchronized IGateKeeperService getGateKeeperService() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mGateKeeperService == null) goto L10;
        IGateKeeperService r0 = this.mGateKeeperService;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r0;
    L10:
        IBinder service = ServiceManager.waitForService("android.service.gatekeeper.IGateKeeperService");     // Catch: Throwable -> L8
        LockSettingsServiceIA r1 = null;
        if (service != null) goto L25;
        Slog.e(TAG, "Unable to acquire GateKeeperService");     // Catch: Throwable -> L8
        monitor-exit(this);
        return null;
    L25:
        service.linkToDeath(new GateKeeperDiedRecipient(this, r1), 0);     // Catch: Throwable -> L8 RemoteException -> L15
    L17:
        this.mGateKeeperService = IGateKeeperService.Stub.asInterface(service);     // Catch: Throwable -> L8
        IGateKeeperService r2 = this.mGateKeeperService;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r2;
    L15:
        e = move-exception;
        Slog.w(TAG, " Unable to register death recipient", e);     // Catch: Throwable -> L8
        goto L17
    }

    private void gateKeeperClearSecureUserId(int userId) {
        getGateKeeperService().clearSecureUserId(userId);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to clear SID", e);
    }

    private void onSyntheticPasswordCreated(int userId, SyntheticPasswordManager.SyntheticPassword sp) {
        onSyntheticPasswordKnown(userId, sp, true);
    }

    private void onSyntheticPasswordUnlocked(int userId, SyntheticPasswordManager.SyntheticPassword sp) {
        onSyntheticPasswordKnown(userId, sp, false);
    }

    private void onSyntheticPasswordKnown(int userId, SyntheticPasswordManager.SyntheticPassword sp, boolean justCreated) {
        if (this.mInjector.isGsiRunning() == false) goto L6;
        Slog.w(TAG, "Running in GSI; skipping calls to AuthSecret and RebootEscrow");
        return;
    L6:
        this.mRebootEscrowManager.callToRebootEscrowIfNeeded(userId, sp.getVersion(), sp.getSyntheticPassword());
        callToAuthSecretIfNeeded(userId, sp, justCreated);
    }

    private void callToAuthSecretIfNeeded(int userId, SyntheticPasswordManager.SyntheticPassword sp, boolean justCreated) {
        if (this.mAuthSecretService != null) goto L5;
        return;
    L5:
        UserManagerInternal userManagerInternal = this.mInjector.getUserManagerInternal();
        UserInfo userInfo = userManagerInternal.getUserInfo(userId);
        if (userInfo != null) goto L9;
        return;
    L9:
        if (this.mInjector.isHeadlessSystemUserMode() == true) goto L14;
        if (userId == 0) goto L12;
        return;
    L12:
        byte[] authSecret = sp.deriveVendorAuthSecret();
    L49:
        Slog.i(TAG, "Sending vendor auth secret to IAuthSecret HAL as user: " + userId);
        this.mAuthSecretService.setPrimaryUserCredential(authSecret);     // Catch: RemoteException -> L52
        return;
    L52:
        e = move-exception;
        Slog.w(TAG, "Failed to send vendor auth secret to IAuthSecret HAL", e);
        return;
    L14:
        if (this.mInjector.isMainUserPermanentAdmin() == true) goto L16;
        return;
    L16:
        if (userInfo.isFull() == false) goto L68;
        if (justCreated == true) goto L20;
        authSecret = this.mSpManager.readVendorAuthSecret(sp, userId);
        if (authSecret != null) goto L45;
        Slog.e(TAG, "Unable to read vendor auth secret for user: " + userId);
        return;
    L45:
        Object r3 = this.mHeadlessAuthSecretLock;
        monitor-enter(r3);
        this.mAuthSecret = authSecret;     // Catch: Throwable -> L55
        monitor-exit(r3);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    L20:
        if (userInfo.isMain() == false) goto L29;
        Slog.i(TAG, "Generating new vendor auth secret and storing for user: " + userId);
        authSecret = SecureRandomUtils.randomBytes(32);
        Object r4 = this.mHeadlessAuthSecretLock;
        monitor-enter(r4);
        this.mAuthSecret = authSecret;     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
    L37:
        this.mSpManager.writeVendorAuthSecret(authSecret, sp, userId);
    L26:
        th = move-exception;
        throw th;
    L29:
        Object r2 = this.mHeadlessAuthSecretLock;
        monitor-enter(r2);
        byte[] authSecret2 = this.mAuthSecret;     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
        if (authSecret2 != null) goto L36;
        Slog.e(TAG, "Creating non-main user " + userId + " but vendor auth secret is not in memory");
        return;
    L36:
        authSecret = authSecret2;
    L38:
        th = move-exception;
        throw th;
    }

    SyntheticPasswordManager.SyntheticPassword initializeSyntheticPassword(int userId) {
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        Slogf.i(TAG, "Initializing synthetic password for user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L11
        if (getCurrentLskfBasedProtectorId(userId) != 0) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1, "Cannot reinitialize SP");     // Catch: Throwable -> L11
        SyntheticPasswordManager.SyntheticPassword sp = this.mSpManager.newSyntheticPassword(userId);     // Catch: Throwable -> L11
        long protectorId = this.mSpManager.createLskfBasedProtector(getGateKeeperService(), LockscreenCredential.createNone(), sp, userId);     // Catch: Throwable -> L11
        setCurrentLskfBasedProtectorId(protectorId, userId);     // Catch: Throwable -> L11
        setCeStorageProtection(userId, sp);     // Catch: Throwable -> L11
        initKeystoreSuperKeys(userId, sp, false);     // Catch: Throwable -> L11
        onSyntheticPasswordCreated(userId, sp);     // Catch: Throwable -> L11
        Slogf.i(TAG, "Successfully initialized synthetic password for user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return sp;
    L7:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    long getCurrentLskfBasedProtectorId(int userId) {
        return getLong("sp-handle", 0, userId);
    }

    private void setCurrentLskfBasedProtectorId(long newProtectorId, int userId) {
        long oldProtectorId = getCurrentLskfBasedProtectorId(userId);
        setLong("sp-handle", newProtectorId, userId);
        setLong(PREV_LSKF_BASED_PROTECTOR_ID_KEY, oldProtectorId, userId);
        setLong(LSKF_LAST_CHANGED_TIME_KEY, System.currentTimeMillis(), userId);
    }

    private long storeGatekeeperPasswordTemporarily(byte[] gatekeeperPassword) {
        long handle = 0;
        LongSparseArray<byte[]> r2 = this.mGatekeeperPasswords;
        monitor-enter(r2);
    L5:
        if (handle == 0) goto L15;
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mGatekeeperPasswords.get(handle) != null) goto L15;
        this.mGatekeeperPasswords.put(handle, gatekeeperPassword);     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        final long finalHandle = handle;
        this.mHandler.postDelayed(new LockSettingsService$$ExternalSyntheticLambda0(this, finalHandle), 600000);
        return handle;
    L15:
        handle = SecureRandomUtils.randomLong();     // Catch: Throwable -> L13
        goto L5
    }

    private /* synthetic */ void lambda$storeGatekeeperPasswordTemporarily$7(long finalHandle) {
        LongSparseArray<byte[]> r0 = this.mGatekeeperPasswords;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mGatekeeperPasswords.get(finalHandle) == null) goto L9;
        Slogf.d(TAG, "Cached Gatekeeper password with handle %016x has expired", new Object[]{Long.valueOf(finalHandle)});     // Catch: Throwable -> L7
        this.mGatekeeperPasswords.remove(finalHandle);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void onCredentialVerified(SyntheticPasswordManager.SyntheticPassword sp, PasswordMetrics metrics, int userId) {
        if (metrics == null) goto L10;
        monitor-enter(this);
        this.mUserPasswordMetrics.put(userId, metrics);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    L10:
        unlockKeystore(userId, sp);
        unlockCeStorage(userId, sp);
        unlockUser(userId);
        activateEscrowTokens(sp, userId);
        if (isCredentialShareableWithParent(userId) == true) goto L13;
    L16:
        this.mStrongAuth.reportSuccessfulStrongAuthUnlock(userId);
        onSyntheticPasswordUnlocked(userId, sp);
        return;
    L13:
        if (getSeparateProfileChallengeEnabledInternal(userId) == false) goto L15;
        setDeviceUnlockedForUser(userId);
        goto L16
    L15:
        this.mStrongAuth.reportUnlock(userId);
        goto L16
    }

    private void setDeviceUnlockedForUser(int userId) {
        TrustManager trustManager = (TrustManager) this.mContext.getSystemService(TrustManager.class);
        trustManager.setDeviceLockedForUser(userId, false);
    }

    private long setLockCredentialWithSpLocked(LockscreenCredential credential, SyntheticPasswordManager.SyntheticPassword sp, int userId) {
        Slogf.i(TAG, "Changing lockscreen credential of user %d; newCredentialType=%s\n", new Object[]{Integer.valueOf(userId), LockPatternUtils.credentialTypeToString(credential.getType())});
        int savedCredentialType = getCredentialTypeInternal(userId);
        long oldProtectorId = getCurrentLskfBasedProtectorId(userId);
        long newProtectorId = this.mSpManager.createLskfBasedProtector(getGateKeeperService(), credential, sp, userId);
        if (credential.isNone() == true) goto L7;
        Map<Integer, LockscreenCredential> profilePasswords = null;
        if (this.mSpManager.hasSidForUser(userId) == true) goto L8;
        this.mSpManager.newSidForUser(getGateKeeperService(), sp, userId);
        this.mSpManager.verifyChallenge(getGateKeeperService(), sp, 0, userId);
    L8:
        setCurrentLskfBasedProtectorId(newProtectorId, userId);
        LockPatternUtils.invalidateCredentialTypeCache();
        synchronizeUnifiedChallengeForProfiles(userId, profilePasswords);
        setUserPasswordMetrics(credential, userId);
        this.mUnifiedProfilePasswordCache.removePassword(userId);
        if (savedCredentialType == (-1)) goto L11;
        this.mSpManager.destroyAllWeakTokenBasedProtectors(userId);
    L11:
        if (profilePasswords == null) goto L16;
        Iterator<Map.Entry<Integer, LockscreenCredential>> r0 = profilePasswords.entrySet().iterator();
    L14:
        if (r0.hasNext() == false) goto L16;
        Map.Entry<Integer, LockscreenCredential> entry = r0.next();
        entry.getValue().zeroize();
    L16:
        this.mSpManager.destroyLskfBasedProtector(oldProtectorId, userId);
        Slogf.i(TAG, "Successfully changed lockscreen credential of user %d", new Object[]{Integer.valueOf(userId)});
        return newProtectorId;
    L7:
        profilePasswords = getDecryptedPasswordsForAllTiedProfiles(userId);
        this.mSpManager.clearSidForUser(userId);
        gateKeeperClearSecureUserId(userId);
        unlockCeStorage(userId, sp);
        unlockKeystore(userId, sp);
        AndroidKeyStoreMaintenance.onUserLskfRemoved(userId);
        removeBiometricsForUser(userId);
        goto L8
    }

    private void sendMainUserCredentialChangedNotificationIfNeeded(int userId) {
        if (userId == this.mInjector.getUserManagerInternal().getMainUserId()) goto L5;
        return;
    L5:
        sendBroadcast(new Intent("android.intent.action.MAIN_USER_LOCKSCREEN_KNOWLEDGE_FACTOR_CHANGED"), UserHandle.of(userId), "android.permission.CONFIGURE_FACTORY_RESET_PROTECTION");
    }

    void sendBroadcast(Intent intent, UserHandle userHandle, String permission) {
        this.mContext.sendBroadcastAsUser(intent, userHandle, permission, null);
    }

    private void removeBiometricsForUser(int userId) {
        removeAllFingerprintForUser(userId);
        removeAllFaceForUser(userId);
    }

    private void removeAllFingerprintForUser(int userId) {
        FingerprintManager mFingerprintManager = this.mInjector.getFingerprintManager();
        if (mFingerprintManager != null) goto L5;
        return;
    L5:
        if (mFingerprintManager.isHardwareDetected() == true) goto L7;
        return;
    L7:
        if (mFingerprintManager.hasEnrolledFingerprints(userId) == false) goto L18;
        CountDownLatch latch = new CountDownLatch(1);
        mFingerprintManager.removeAll(userId, fingerprintManagerRemovalCallback(latch));
        latch.await(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L11
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Latch interrupted when removing fingerprint", e);
        return;
    }

    private void removeAllFaceForUser(int userId) {
        FaceManager mFaceManager = this.mInjector.getFaceManager();
        if (mFaceManager != null) goto L5;
        return;
    L5:
        if (mFaceManager.isHardwareDetected() == true) goto L7;
        return;
    L7:
        if (mFaceManager.hasEnrolledTemplates(userId) == false) goto L18;
        CountDownLatch latch = new CountDownLatch(1);
        mFaceManager.removeAll(userId, faceManagerRemovalCallback(latch));
        latch.await(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L11
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Latch interrupted when removing face", e);
        return;
    }

    private FingerprintManager.RemovalCallback fingerprintManagerRemovalCallback(final CountDownLatch latch) {
        return new AnonymousClass5(this, latch);
    }

    private FaceManager.RemovalCallback faceManagerRemovalCallback(final CountDownLatch latch) {
        return new AnonymousClass6(this, latch);
    }

    public byte[] getHashFactor(LockscreenCredential currentCredential, int userId) {
        checkPasswordReadPermission();
        Slogf.d(TAG, "Getting password history hash factor for user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L39
        if (isProfileWithUnifiedLock(userId) == true) goto L51;
        LockscreenCredential currentCredential2 = currentCredential;
    L49:
        SyntheticPasswordManager r10 = this.mSpManager;     // Catch: Throwable -> L37
        monitor-enter(r10);     // Catch: Throwable -> L37
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L31
        SyntheticPasswordManager.AuthenticationResult auth = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), protectorId, currentCredential2, userId, null);     // Catch: Throwable -> L25
        if (auth.syntheticPassword != null) goto L27;
        Slog.w(TAG, "Current credential is incorrect");     // Catch: Throwable -> L25
        monitor-exit(r10);     // Catch: Throwable -> L25
        scheduleGc();
        return null;
    L27:
        byte[] r0 = auth.syntheticPassword.derivePasswordHashFactor();     // Catch: Throwable -> L25
        monitor-exit(r10);     // Catch: Throwable -> L25
        scheduleGc();
        return r0;
    L31:
        th = move-exception;
        Throwable r11 = th;
    L33:
        monitor-exit(r10);     // Catch: Throwable -> L25
        throw r11;     // Catch: Throwable -> L35
    L35:
        th = th;
    L41:
        scheduleGc();
        throw th;
    L25:
        th = move-exception;
        r11 = th;
    L37:
        th = th;
        goto L41
    L51:
        LockscreenCredential currentCredential3 = getDecryptedPasswordForTiedProfile(userId);     // Catch: Throwable -> L8 Exception -> L10
        currentCredential2 = currentCredential3;
        goto L49
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to get unified profile password", e);     // Catch: Throwable -> L8
        scheduleGc();
        return null;
    L8:
        th = th;
    L39:
        th = th;
        goto L41
    }

    private long addEscrowToken(byte[] token, int type, int userId, LockPatternUtils.EscrowTokenStateChangeCallback callback) {
        Slogf.i(TAG, "Adding escrow token for user %d", new Object[]{Integer.valueOf(userId)});
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
        SyntheticPasswordManager.SyntheticPassword sp = null;
    L10:
        th = move-exception;
        Throwable r14 = th;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r14;
    L12:
        th = move-exception;
        r14 = th;
        goto L25
    L6:
        if (isUserSecure(userId) == true) goto L14;
        long protectorId = getCurrentLskfBasedProtectorId(userId);     // Catch: Throwable -> L12
        int userId2 = userId;
        sp = this.mSpManager.unlockLskfBasedProtector(getGateKeeperService(), protectorId, LockscreenCredential.createNone(), userId2, null).syntheticPassword;     // Catch: Throwable -> L10
    L15:
        disableEscrowTokenOnNonManagedDevicesIfNeeded(userId2);     // Catch: Throwable -> L10
        if (this.mSpManager.hasEscrowData(userId2) == false) goto L24;
        long handle = this.mSpManager.addPendingToken(token, type, userId2, callback);     // Catch: Throwable -> L10
        if (sp == null) goto L20;
        Slogf.i(TAG, "Immediately activating escrow token %016x", new Object[]{Long.valueOf(handle)});     // Catch: Throwable -> L10
        this.mSpManager.createTokenBasedProtector(handle, sp, userId2);     // Catch: Throwable -> L10
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return handle;
    L20:
        Slogf.i(TAG, "Escrow token %016x will be activated when user is unlocked", new Object[]{Long.valueOf(handle)});     // Catch: Throwable -> L10
        goto L21
    L24:
        throw new SecurityException("Escrow token is disabled on the current user");     // Catch: Throwable -> L10
    L14:
        userId2 = userId;
        goto L15
    }

    private void activateEscrowTokens(SyntheticPasswordManager.SyntheticPassword sp, int userId) {
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        disableEscrowTokenOnNonManagedDevicesIfNeeded(userId);     // Catch: Throwable -> L8
        Iterator<Long> r1 = this.mSpManager.getPendingTokensForUser(userId).iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        long handle = r1.next().longValue();     // Catch: Throwable -> L8
        Slogf.i(TAG, "Activating escrow token %016x for user %d", new Object[]{Long.valueOf(handle), Integer.valueOf(userId)});     // Catch: Throwable -> L8
        this.mSpManager.createTokenBasedProtector(handle, sp, userId);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isEscrowTokenActive(long handle, int userId) {
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
        boolean r1 = this.mSpManager.protectorExists(handle, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasPendingEscrowToken(int userId) {
        checkPasswordReadPermission();
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSpManager.getPendingTokensForUser(userId).isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private boolean removeEscrowToken(long handle, int userId) {
        SyntheticPasswordManager r0 = this.mSpManager;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (handle != getCurrentLskfBasedProtectorId(userId)) goto L12;
        Slog.w(TAG, "Escrow token handle equals LSKF-based protector ID");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L12:
        if (this.mSpManager.removePendingToken(handle, userId) == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L16:
        if (this.mSpManager.protectorExists(handle, userId) == false) goto L20;
        this.mSpManager.destroyTokenBasedProtector(handle, userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    }

    private boolean setLockCredentialWithToken(LockscreenCredential credential, long tokenHandle, byte[] token, final int userId) {
        credential.validateBasicRequirements();
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
    L31:
        th = th;
    L38:
        monitor-exit(r1);     // Catch: Throwable -> L31
        throw th;
    L33:
        th = th;
        goto L38
    L5:
        if (this.mSpManager.hasEscrowData(userId) == false) goto L37;
        if (isEscrowTokenActive(tokenHandle, userId) == false) goto L40;
        boolean result = setLockCredentialWithTokenInternalLocked(credential, tokenHandle, token, userId);     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L31
        if (result == false) goto L30;
        Object r2 = this.mSeparateChallengeLock;
        monitor-enter(r2);
        setSeparateProfileChallengeEnabledLocked(userId, true, null);     // Catch: Throwable -> L27
        monitor-exit(r2);     // Catch: Throwable -> L27
        if (credential.isNone() == false) goto L26;
        this.mHandler.post(new LockSettingsService$$ExternalSyntheticLambda9(this, userId));
    L26:
        notifyPasswordChanged(credential, userId);
        notifySeparateProfileChallengeChanged(userId);
    L27:
        th = move-exception;
        throw th;
    L30:
        return result;
    L40:
        Slog.e(TAG, "Unknown or unactivated token: " + Long.toHexString(tokenHandle));     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return false;
    L12:
        th = th;
        goto L38
    L37:
        throw new SecurityException("Escrow token is disabled on the current user");     // Catch: Throwable -> L31
    }

    private /* synthetic */ void lambda$setLockCredentialWithToken$8(int userId) {
        unlockUser(userId);
    }

    private boolean setLockCredentialWithTokenInternalLocked(LockscreenCredential credential, long tokenHandle, byte[] token, int userId) {
        Slogf.i(TAG, "Resetting lockscreen credential of user %d using escrow token %016x", new Object[]{Integer.valueOf(userId), Long.valueOf(tokenHandle)});
        SyntheticPasswordManager.AuthenticationResult result = this.mSpManager.unlockTokenBasedProtector(getGateKeeperService(), tokenHandle, token, userId);
        if (result.syntheticPassword != null) goto L7;
        Slog.w(TAG, "Invalid escrow token supplied");
        return false;
    L7:
        if (result.gkResponse.getResponseCode() == 0) goto L10;
        Slog.e(TAG, "Obsolete token: synthetic password decrypted but it fails GK verification.");
        return false;
    L10:
        onSyntheticPasswordUnlocked(userId, result.syntheticPassword);
        setLockCredentialWithSpLocked(credential, result.syntheticPassword, userId);
        return true;
    }

    private boolean unlockUserWithToken(long tokenHandle, byte[] token, int userId) {
        SyntheticPasswordManager r1 = this.mSpManager;
        monitor-enter(r1);
        Slogf.i(TAG, "Unlocking user %d using escrow token %016x", new Object[]{Integer.valueOf(userId), Long.valueOf(tokenHandle)});     // Catch: Throwable -> L24
        if (this.mSpManager.hasEscrowData(userId) == false) goto L28;
        SyntheticPasswordManager.AuthenticationResult authResult = this.mSpManager.unlockTokenBasedProtector(getGateKeeperService(), tokenHandle, token, userId);     // Catch: Throwable -> L19
        if (authResult.syntheticPassword != null) goto L21;
        Slog.w(TAG, "Invalid escrow token supplied");     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return false;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L19
        Slogf.i(TAG, "Unlocked synthetic password for user %d using escrow token", new Object[]{Integer.valueOf(userId)});
        onCredentialVerified(authResult.syntheticPassword, loadPasswordMetrics(authResult.syntheticPassword, userId), userId);
        return true;
    L28:
        Slogf.w(TAG, "Escrow token support is disabled on user %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return false;
    L10:
        th = th;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L19
        throw th;
    L24:
        th = th;
    L19:
        th = th;
        goto L26
    }

    public boolean tryUnlockWithCachedUnifiedChallenge(int userId) {
        checkPasswordReadPermission();
        LockscreenCredential cred = this.mUnifiedProfilePasswordCache.retrievePassword(userId);
        boolean r1 = false;
        if (cred != null) goto L19;
        if (cred == null) goto L6;
        cred.close();
    L6:
        return false;
    L19:
        if (doVerifyCredential(cred, userId, null, 0).getResponseCode() != 0) goto L11;
        r1 = true;
    L11:
        cred.close();
        return r1;
    L13:
        th = move-exception;
        cred.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    public void removeCachedUnifiedChallenge(int userId) {
        checkWritePermission();
        this.mUnifiedProfilePasswordCache.removePassword(userId);
    }

    static String timestampToString(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }

    protected void dump(FileDescriptor fd, PrintWriter printWriter, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, printWriter) == true) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
        dumpInternal(printWriter);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void dumpInternal(PrintWriter printWriter) {
        IndentingPrintWriter pw = new IndentingPrintWriter(printWriter, "  ");
        pw.println("Current lock settings service state:");
        pw.println();
        pw.println("User State:");
        pw.increaseIndent();
        List<UserInfo> users = this.mUserManager.getUsers();
        int user = 0;
    L4:
        if (user >= users.size()) goto L23;
        int userId = users.get(user).id;
        pw.println("User " + userId);
        pw.increaseIndent();
        SyntheticPasswordManager r4 = this.mSpManager;
        monitor-enter(r4);
        pw.println(TextUtils.formatSimple("LSKF-based SP protector ID: %016x", new Object[]{Long.valueOf(getCurrentLskfBasedProtectorId(userId))}));     // Catch: Throwable -> L20
        pw.println(TextUtils.formatSimple("LSKF last changed: %s (previous protector: %016x)", new Object[]{timestampToString(getLong(LSKF_LAST_CHANGED_TIME_KEY, 0, userId)), Long.valueOf(getLong(PREV_LSKF_BASED_PROTECTOR_ID_KEY, 0, userId))}));     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L20
        pw.println(TextUtils.formatSimple("SID: %016x", new Object[]{Long.valueOf(getGateKeeperService().getSecureUserId(userId))}));     // Catch: RemoteException -> L11
    L12:
        pw.println("Quality: " + getKeyguardStoredQuality(userId));
        int credentialType = getCredentialTypeInternal(userId);
        pw.println("CredentialType: " + LockPatternUtils.credentialTypeToString(credentialType));
        if (credentialType != (-1)) goto L15;
        pw.println("IsLockScreenDisabled: " + getBoolean("lockscreen.disabled", false, userId));
    L15:
        pw.println("SeparateChallenge: " + getSeparateProfileChallengeEnabledInternal(userId));
        if (getUserPasswordMetrics(userId) == null) goto L18;
        String r6 = "known";
    L19:
        pw.println(TextUtils.formatSimple("Metrics: %s", new Object[]{r6}));
        pw.decreaseIndent();
        user = user + 1;
        goto L4
    L18:
        r6 = "unknown";
    L20:
        th = move-exception;
        throw th;
    L23:
        pw.println();
        pw.decreaseIndent();
        pw.println("Keys in namespace:");
        pw.increaseIndent();
        dumpKeystoreKeys(pw);
        pw.println();
        pw.decreaseIndent();
        pw.println("Storage:");
        pw.increaseIndent();
        this.mStorage.dump(pw);
        pw.println();
        pw.decreaseIndent();
        pw.println("StrongAuth:");
        pw.increaseIndent();
        this.mStrongAuth.dump(pw);
        pw.println();
        pw.decreaseIndent();
        pw.println("RebootEscrow:");
        pw.increaseIndent();
        this.mRebootEscrowManager.dump(pw);
        pw.println();
        pw.decreaseIndent();
        pw.println("PasswordHandleCount: " + this.mGatekeeperPasswords.size());
        Object r2 = this.mUserCreationAndRemovalLock;
        monitor-enter(r2);
        pw.println("ThirdPartyAppsStarted: " + this.mThirdPartyAppsStarted);     // Catch: Throwable -> L28
        monitor-exit(r2);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    private void dumpKeystoreKeys(IndentingPrintWriter pw) {
        Enumeration<String> aliases = this.mKeyStore.aliases();     // Catch: KeyStoreException -> L7
    L4:
        if (aliases.hasMoreElements() == false) goto L16;
        pw.println(aliases.nextElement());     // Catch: KeyStoreException -> L7
        goto L4
    L16:
        return;
    L7:
        e = move-exception;
        pw.println("Unable to get keys: " + e.toString());
        Slog.d(TAG, "Dump error", e);
    }

    private void disableEscrowTokenOnNonManagedDevicesIfNeeded(int userId) {
        if (this.mSpManager.hasAnyEscrowData(userId) == true) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L8:
        if (DeviceConfig.getBoolean("device_policy_manager", "deprecate_usermanagerinternal_devicepolicy", true) == true) goto L10;
        UserManagerInternal userManagerInternal = this.mInjector.getUserManagerInternal();     // Catch: Throwable -> L14
        if (userManagerInternal.isUserManaged(userId) == false) goto L22;
        Slog.i(TAG, "Managed profile can have escrow token");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);
        return;
    L22:
        if (userManagerInternal.isDeviceManaged() == false) goto L26;
        Slog.i(TAG, "Corp-owned device can have escrow token");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);
        return;
    L26:
        Binder.restoreCallingIdentity(identity);
        if (this.mInjector.getDeviceStateCache().isDeviceProvisioned() == true) goto L31;
        Slog.i(TAG, "Postpone disabling escrow tokens until device is provisioned");
        return;
    L31:
        if (RoSystemFeatures.hasFeatureAutomotive(this.mContext) == false) goto L33;
        return;
    L33:
        UserInfo userInfo = this.mInjector.getUserManagerInternal().getUserInfo(userId);
        if (userInfo != null) goto L36;
    L39:
        Slogf.i(TAG, "Permanently disabling support for escrow tokens on user %d", new Object[]{Integer.valueOf(userId)});
        this.mSpManager.destroyEscrowData(userId);
        return;
    L36:
        if (userInfo.isForTesting() == false) goto L39;
        Slog.i(TAG, "Keeping escrow data for test-only user");
        return;
    L10:
        if (this.mInjector.getDeviceStateCache().isUserOrganizationManaged(userId) == false) goto L26;
        Slog.i(TAG, "Organization managed users can have escrow token");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);
    }

    private void scheduleGc() {
        this.mHandler.removeCallbacksAndMessages(this.mGcWorkToken);
        this.mHandler.postDelayed(new LockSettingsService$$ExternalSyntheticLambda3(), this.mGcWorkToken, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    }

    private static /* synthetic */ void lambda$scheduleGc$9() {
        System.gc();
        System.runFinalization();
        System.gc();
    }
}
