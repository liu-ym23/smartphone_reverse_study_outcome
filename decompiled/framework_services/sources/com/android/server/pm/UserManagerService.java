package com.android.server.pm;

import android.R;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityManagerNative;
import android.app.ActivityOptions;
import android.app.AlarmManager;
import android.app.BroadcastOptions;
import android.app.IActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.StatsManager;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.doppelganger.DoppelgangerConfigure;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.LauncherUserInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PackagePartitions;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserInfo;
import android.content.pm.UserPackage;
import android.content.pm.UserProperties;
import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.IBinder;
import android.os.IProgressListener;
import android.os.IUserManager;
import android.os.IUserRestrictionsListener;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SELinux;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.os.storage.StorageManagerInternal;
import android.service.voice.VoiceInteractionManagerInternal;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.StatsEvent;
import android.util.TimeUtils;
import android.util.TypedValue;
import android.util.Xml;
import com.android.internal.app.IAppOpsService;
import com.android.internal.app.SetScreenLockDialogActivity;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.BundleUtils;
import com.android.server.ISmtResourceControl;
import com.android.server.LocalServices;
import com.android.server.LockGuard;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.am.UserState;
import com.android.server.storage.DeviceStorageMonitorInternal;
import com.android.server.utils.Slogf;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.voiceinteraction.DatabaseHelper;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class UserManagerService extends IUserManager.Stub {
    private static final int ALLOWED_FLAGS_FOR_CREATE_USERS_PERMISSION = 38700;
    private static final String ATTR_CONVERTED_FROM_PRE_CREATED = "convertedFromPreCreated";
    private static final String ATTR_CREATION_TIME = "created";
    private static final String ATTR_FLAGS = "flags";
    private static final String ATTR_GUEST_TO_REMOVE = "guestToRemove";
    private static final String ATTR_ICON_PATH = "icon";
    private static final String ATTR_ID = "id";
    private static final String ATTR_KEY = "key";
    private static final String ATTR_LAST_ENTERED_FOREGROUND_TIME = "lastEnteredForeground";
    private static final String ATTR_LAST_LOGGED_IN_FINGERPRINT = "lastLoggedInFingerprint";
    private static final String ATTR_LAST_LOGGED_IN_TIME = "lastLoggedIn";
    private static final String ATTR_MULTIPLE = "m";
    private static final String ATTR_NEXT_SERIAL_NO = "nextSerialNumber";
    private static final String ATTR_PARTIAL = "partial";
    private static final String ATTR_PRE_CREATED = "preCreated";
    private static final String ATTR_PROFILE_BADGE = "profileBadge";
    private static final String ATTR_PROFILE_GROUP_ID = "profileGroupId";
    private static final String ATTR_RESTRICTED_PROFILE_PARENT_ID = "restrictedProfileParentId";
    private static final String ATTR_SEED_ACCOUNT_NAME = "seedAccountName";
    private static final String ATTR_SEED_ACCOUNT_TYPE = "seedAccountType";
    private static final String ATTR_SERIAL_NO = "serialNumber";
    private static final String ATTR_TYPE = "type";
    private static final String ATTR_TYPE_BOOLEAN = "b";
    private static final String ATTR_TYPE_BUNDLE = "B";
    private static final String ATTR_TYPE_BUNDLE_ARRAY = "BA";
    private static final String ATTR_TYPE_INTEGER = "i";
    private static final String ATTR_TYPE_STRING = "s";
    private static final String ATTR_TYPE_STRING_ARRAY = "sa";
    private static final String ATTR_USER_TYPE_VERSION = "userTypeConfigVersion";
    private static final String ATTR_USER_VERSION = "version";
    private static final String ATTR_VALUE_TYPE = "type";
    private static final int BOOT_TO_HSU_FOR_PROVISIONED_DEVICE = 1;
    private static final int BOOT_TO_PREVIOUS_OR_FIRST_SWITCHABLE_USER = 0;
    private static final long BOOT_USER_SET_TIMEOUT_MS = 300000;
    private static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_DESCRIPTION_KEY = "custom_logo_description";
    private static final String CUSTOM_BIOMETRIC_PROMPT_LOGO_RES_ID_KEY = "custom_logo_res_id";
    static final boolean DBG = false;
    public static final boolean DBG_ALLOCATION = false;
    static final boolean DBG_MUMD = false;
    private static final boolean DBG_WITH_STACKTRACE = false;
    private static final long EPOCH_PLUS_30_YEARS = 946080000000L;
    private static final String LOG_TAG = "UserManagerService";
    static final int MAX_RECENTLY_REMOVED_IDS_SIZE = 100;
    static final int MAX_USER_ID = 21473;
    static final int MIN_USER_ID = 11;
    private static final long PRIVATE_SPACE_AUTO_LOCK_INACTIVITY_ALARM_WINDOW_MS = 0;
    private static final long PRIVATE_SPACE_AUTO_LOCK_INACTIVITY_TIMEOUT_MS = 300000;
    private static final String PRIVATE_SPACE_AUTO_LOCK_TIMER_TAG = "PrivateSpaceAutoLockTimer";
    private static final boolean RELEASE_DELETED_USER_ID = false;
    private static final String RESTRICTIONS_FILE_PREFIX = "res_";
    private static final String TAG_ACCOUNT = "account";
    private static final String TAG_DEVICE_OWNER_USER_ID = "deviceOwnerUserId";
    private static final String TAG_DEVICE_POLICY_GLOBAL_RESTRICTIONS = "device_policy_global_restrictions";
    private static final String TAG_DEVICE_POLICY_LOCAL_RESTRICTIONS = "device_policy_local_restrictions";
    private static final String TAG_DEVICE_POLICY_RESTRICTIONS = "device_policy_restrictions";
    private static final String TAG_ENTRY = "entry";
    private static final String TAG_GLOBAL_RESTRICTION_OWNER_ID = "globalRestrictionOwnerUserId";
    private static final String TAG_GUEST_RESTRICTIONS = "guestRestrictions";
    private static final String TAG_IGNORE_PREPARE_STORAGE_ERRORS = "ignorePrepareStorageErrors";
    private static final String TAG_LAST_REQUEST_QUIET_MODE_ENABLED_CALL = "lastRequestQuietModeEnabledCall";
    private static final String TAG_NAME = "name";
    private static final String TAG_RESTRICTIONS = "restrictions";
    private static final String TAG_SEED_ACCOUNT_OPTIONS = "seedAccountOptions";
    private static final String TAG_USER = "user";
    private static final String TAG_USERS = "users";
    private static final String TAG_USER_PROPERTIES = "userProperties";
    private static final String TAG_VALUE = "value";
    private static final String TRON_DEMO_CREATED = "users_demo_created";
    private static final String TRON_GUEST_CREATED = "users_guest_created";
    private static final String TRON_USER_CREATED = "users_user_created";
    private static final String USER_INFO_DIR = null;
    private static final String USER_LIST_FILENAME = "userlist.xml";
    private static final String USER_PHOTO_FILENAME = "photo.png";
    private static final String USER_PHOTO_FILENAME_TMP = "photo.png.tmp";
    private static final int USER_VERSION = 11;
    static final int WRITE_USER_DELAY = 2000;
    static final int WRITE_USER_LIST_MSG = 2;
    static final int WRITE_USER_MSG = 1;
    private static final String XML_SUFFIX = ".xml";
    private static UserManagerService sInstance;
    private final String ACTION_DISABLE_QUIET_MODE_AFTER_UNLOCK;
    private ActivityManagerInternal mAmInternal;
    private IAppOpsService mAppOpsService;
    private final Object mAppRestrictionsLock;
    private final RestrictionsSet mAppliedUserRestrictions;
    private final RestrictionsSet mBaseUserRestrictions;
    private int mBootUser;
    private final CountDownLatch mBootUserLatch;
    private final RestrictionsSet mCachedEffectiveUserRestrictions;
    private final BroadcastReceiver mConfigurationChangeReceiver;
    private final Context mContext;
    private int mCurrentBootPhase;
    private final BroadcastReceiver mDeviceInactivityBroadcastReceiver;
    private DevicePolicyManagerInternal mDevicePolicyManagerInternal;
    private final RestrictionsSet mDevicePolicyUserRestrictions;
    private final BroadcastReceiver mDisableQuietModeCallback;
    private boolean mForceEphemeralUsers;
    private final Bundle mGuestRestrictions;
    private final Handler mHandler;
    private final ThreadPoolExecutor mInternalExecutor;
    private boolean mIsDeviceInactivityBroadcastReceiverRegistered;
    private boolean mIsDeviceManaged;
    private final SparseBooleanArray mIsUserManaged;
    private KeyguardManager.KeyguardLockedStateListener mKeyguardLockedStateListener;
    private final Configuration mLastConfiguration;
    private final LocalService mLocalService;
    private final LockPatternUtils mLockPatternUtils;
    private int mNextSerialNumber;
    private final AtomicReference<String> mOwnerName;
    private final TypedValue mOwnerNameTypedValue;
    private final Object mPackagesLock;
    private final PackageManagerService mPm;
    private PackageManagerInternal mPmInternal;
    private final SettingsObserver mPrivateSpaceAutoLockSettingsObserver;
    private PrivateSpaceAutoLockTimer mPrivateSpaceAutoLockTimer;
    private final LinkedList<Integer> mRecentlyRemovedIds;
    private final SparseBooleanArray mRemovingUserIds;
    private final Object mRestrictionsLock;
    private final UserSystemPackageInstaller mSystemPackageInstaller;
    private boolean mUpdatingSystemUserMode;
    public final AtomicInteger mUser0Allocations;
    private final UserDataPreparer mUserDataPreparer;
    private int[] mUserIds;
    private int[] mUserIdsIncludingPreCreated;
    private final UserJourneyLogger mUserJourneyLogger;
    private final ArrayList<UserManagerInternal.UserLifecycleListener> mUserLifecycleListeners;
    private final File mUserListFile;
    private final IBinder mUserRestrictionToken;
    private final ArrayList<UserManagerInternal.UserRestrictionsListener> mUserRestrictionsListeners;
    private final WatchedUserStates mUserStates;
    private int mUserTypeVersion;
    private final ArrayMap<String, UserTypeDetails> mUserTypes;
    private int mUserVersion;
    private final UserVisibilityMediator mUserVisibilityMediator;
    private final SparseArray<UserData> mUsers;
    private final File mUsersDir;
    private final Object mUsersLock;

    /* JADX INFO: renamed from: com.android.server.pm.UserManagerService$7, reason: invalid class name */
    class AnonymousClass7 extends IIntentReceiver.Stub {
        final /* synthetic */ UserManagerService this$0;
        final /* synthetic */ int val$userId;

        public static /* synthetic */ void $r8$lambda$HsDpeSmsJXl5f6TgKfzr72gGBAQ(AnonymousClass7 r0, int r1) {
            r0.lambda$performReceive$0(r1);
        }

        AnonymousClass7(UserManagerService this$0, int r2) {
            this.this$0 = this$0;
            this.val$userId = r2;
        }

        public void performReceive(Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, int sendingUser) {
            final int r1 = this.val$userId;
            new Thread(new UserManagerService$7$$ExternalSyntheticLambda0(this, r1)).start();
        }

        private /* synthetic */ void lambda$performReceive$0(int userId) {
            UserManagerService.m6998$$Nest$mgetActivityManagerInternal(this.this$0).onUserRemoving(userId);
            UserManagerService.m7018$$Nest$mremoveUserState(this.this$0, userId);
        }
    }

    private class DisableQuietModeUserUnlockedCallback extends IProgressListener.Stub {
        private final IntentSender mTarget;
        final /* synthetic */ UserManagerService this$0;

        public static /* synthetic */ void $r8$lambda$qKLFxoUq1Odwe1YmPInfJWDDZ7k(DisableQuietModeUserUnlockedCallback r0) {
            r0.lambda$onFinished$0();
        }

        public DisableQuietModeUserUnlockedCallback(UserManagerService r1, IntentSender target) {
            this.this$0 = r1;
            target.getClass();
            this.mTarget = target;
        }

        public void onStarted(int id, Bundle extras) {
        }

        public void onProgress(int id, int progress, Bundle extras) {
        }

        public void onFinished(int id, Bundle extras) {
            UserManagerService.m6975$$Nest$fgetmHandler(this.this$0).post(new UserManagerService$DisableQuietModeUserUnlockedCallback$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$onFinished$0() {
            ActivityOptions activityOptions = ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1);     // Catch: IntentSender.SendIntentException -> L4
            UserManagerService.m6974$$Nest$fgetmContext(this.this$0).startIntentSender(this.mTarget, null, 0, 0, 0, activityOptions.toBundle());     // Catch: IntentSender.SendIntentException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(UserManagerService.LOG_TAG, "Failed to start the target in the callback", e);
        }
    }

    public static class LifeCycle extends SystemService {
        private UserManagerService mUms;

        public LifeCycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mUms = UserManagerService.getInstance();
            publishBinderService(UserManagerService.TAG_USER, this.mUms);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            UserManagerService.m6988$$Nest$fputmCurrentBootPhase(this.mUms, phase);
            if (phase != 550) goto L9;
            UserManagerService.m6994$$Nest$mcleanupPartialUsers(this.mUms);
            if (UserManagerService.m6979$$Nest$fgetmPm(this.mUms).isDeviceUpgrading() == false) goto L7;
            UserManagerService.m6995$$Nest$mcleanupPreCreatedUsers(this.mUms);
        L7:
            UserManagerService.m7016$$Nest$mregisterStatsCallbacks(this.mUms);
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser targetUser) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.mUms);
            monitor-enter(r0);
            UserData user = UserManagerService.m7006$$Nest$mgetUserDataLU(this.mUms, targetUser.getUserIdentifier());     // Catch: Throwable -> L11
            if (user == null) goto L13;
            user.startRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
            if (targetUser.getUserIdentifier() != 0) goto L13;
            if (targetUser.isFull() == false) goto L13;
            UserManagerService.m7023$$Nest$msetLastEnteredForegroundTimeToNow(this.mUms, user);     // Catch: Throwable -> L11
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser targetUser) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.mUms);
            monitor-enter(r0);
            UserData user = UserManagerService.m7006$$Nest$mgetUserDataLU(this.mUms, targetUser.getUserIdentifier());     // Catch: Throwable -> L7
            if (user == null) goto L9;
            user.unlockRealtime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            if (targetUser.getUserIdentifier() == 0) goto L13;
            return;
        L13:
            if (UserManager.isCommunalProfileEnabled() == false) goto L21;
            UserManagerService.m7024$$Nest$mstartCommunalProfile(this.mUms);
            return;
        L21:
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.mUms);
            monitor-enter(r0);
            UserData user = UserManagerService.m7006$$Nest$mgetUserDataLU(this.mUms, to.getUserIdentifier());     // Catch: Throwable -> L7
            if (user == null) goto L9;
            UserManagerService.m7023$$Nest$msetLastEnteredForegroundTimeToNow(this.mUms, user);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser targetUser) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.mUms);
            monitor-enter(r0);
            UserData user = UserManagerService.m7006$$Nest$mgetUserDataLU(this.mUms, targetUser.getUserIdentifier());     // Catch: Throwable -> L7
            if (user == null) goto L9;
            user.startRealtime = 0;     // Catch: Throwable -> L7
            user.unlockRealtime = 0;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class LocalService extends UserManagerInternal {
        final /* synthetic */ UserManagerService this$0;

        /* synthetic */ LocalService(UserManagerService r1, UserManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(UserManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setDevicePolicyUserRestrictions(int originatingUserId, Bundle global, RestrictionsSet local, boolean isDeviceOwner) {
            UserManagerService.m7022$$Nest$msetDevicePolicyUserRestrictionsInner(this.this$0, originatingUserId, global, local, isDeviceOwner);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setUserRestriction(int userId, String key, boolean value) {
            this.this$0.setUserRestrictionInner(userId, key, value);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean getUserRestriction(int userId, String key) {
            return this.this$0.getUserRestrictions(userId).getBoolean(key);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void addUserRestrictionsListener(UserManagerInternal.UserRestrictionsListener listener) {
            ArrayList r0 = UserManagerService.m6983$$Nest$fgetmUserRestrictionsListeners(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6983$$Nest$fgetmUserRestrictionsListeners(this.this$0).add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void removeUserRestrictionsListener(UserManagerInternal.UserRestrictionsListener listener) {
            ArrayList r0 = UserManagerService.m6983$$Nest$fgetmUserRestrictionsListeners(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6983$$Nest$fgetmUserRestrictionsListeners(this.this$0).remove(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void addUserLifecycleListener(UserManagerInternal.UserLifecycleListener listener) {
            ArrayList r0 = UserManagerService.m6982$$Nest$fgetmUserLifecycleListeners(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6982$$Nest$fgetmUserLifecycleListeners(this.this$0).add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void removeUserLifecycleListener(UserManagerInternal.UserLifecycleListener listener) {
            ArrayList r0 = UserManagerService.m6982$$Nest$fgetmUserLifecycleListeners(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6982$$Nest$fgetmUserLifecycleListeners(this.this$0).remove(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setDeviceManaged(boolean isManaged) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6990$$Nest$fputmIsDeviceManaged(this.this$0, isManaged);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isDeviceManaged() {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UserManagerService.m6976$$Nest$fgetmIsDeviceManaged(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setUserManaged(int userId, boolean isManaged) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6977$$Nest$fgetmIsUserManaged(this.this$0).put(userId, isManaged);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserManaged(int userId) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UserManagerService.m6977$$Nest$fgetmIsUserManaged(this.this$0).get(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setUserIcon(int userId, Bitmap bitmap) {
            long ident = Binder.clearCallingIdentity();
            Object r2 = UserManagerService.m6978$$Nest$fgetmPackagesLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
            UserData userData = UserManagerService.m7007$$Nest$mgetUserDataNoChecks(this.this$0, userId);     // Catch: Throwable -> L17
            if (userData == null) goto L19;
            if (userData.info.partial == true) goto L19;
            UserManagerService.m7025$$Nest$mwriteBitmapLP(this.this$0, userData.info, bitmap);     // Catch: Throwable -> L17
            UserManagerService.m7026$$Nest$mwriteUserLP(this.this$0, userData);     // Catch: Throwable -> L17
            monitor-exit(r2);     // Catch: Throwable -> L17
            UserManagerService.m7020$$Nest$msendUserInfoChangedBroadcast(this.this$0, userId);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(ident);
            return;
        L19:
            Slog.w(UserManagerService.LOG_TAG, "setUserIcon: unknown user #" + userId);     // Catch: Throwable -> L17
            monitor-exit(r2);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(ident);
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setForceEphemeralUsers(boolean forceEphemeralUsers) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6989$$Nest$fputmForceEphemeralUsers(this.this$0, forceEphemeralUsers);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void removeAllUsers() {
            if (this.this$0.getCurrentUserId() != 0) goto L5;
            UserManagerService.m7017$$Nest$mremoveAllUsersExceptSystemAndPermanentAdminMain(this.this$0);
            return;
        L5:
            BroadcastReceiver userSwitchedReceiver = new AnonymousClass1(this);
            IntentFilter userSwitchedFilter = new IntentFilter();
            userSwitchedFilter.addAction("android.intent.action.USER_SWITCHED");
            UserManagerService.m6974$$Nest$fgetmContext(this.this$0).registerReceiver(userSwitchedReceiver, userSwitchedFilter, null, UserManagerService.m6975$$Nest$fgetmHandler(this.this$0));
            ActivityManager am = (ActivityManager) UserManagerService.m6974$$Nest$fgetmContext(this.this$0).getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
            am.switchUser(0);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void onEphemeralUserStop(int userId) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserInfo userInfo = UserManagerService.m7008$$Nest$mgetUserInfoLU(this.this$0, userId);     // Catch: Throwable -> L11
            if (userInfo != null) goto L7;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (userInfo.isEphemeral() == false) goto L13;
            UserManagerService.m6991$$Nest$maddUserInfoFlags(this.this$0, userInfo, 64);     // Catch: Throwable -> L11
            if (userInfo.isGuest() == false) goto L13;
            userInfo.guestToRemove = true;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public UserInfo createUserEvenWhenDisallowed(String name, String userType, int flags, String[] disallowedPackages, Object token) throws UserManager.CheckedUserOperationException {
            return UserManagerService.m6996$$Nest$mcreateUserInternalUnchecked(this.this$0, name, userType, flags, ProcessList.INVALID_ADJ, false, disallowedPackages, token);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean removeUserEvenWhenDisallowed(int userId) {
            return UserManagerService.m7019$$Nest$mremoveUserWithProfilesUnchecked(this.this$0, userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserRunning(int userId) {
            WatchedUserStates r0 = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0);
            monitor-enter(r0);
            int state = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0).get(userId, -1);     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            if (state != (-1)) goto L8;
        L12:
            return false;
        L8:
            if (state == 4) goto L12;
            if (state == 5) goto L12;
            return true;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setUserState(int userId, int userState) {
            WatchedUserStates r0 = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0).put(userId, userState);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void removeUserState(int userId) {
            WatchedUserStates r0 = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0);
            monitor-enter(r0);
            UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0).delete(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int[] getUserIds() {
            return this.this$0.getUserIds();
        }

        @Override // com.android.server.pm.UserManagerInternal
        public List<UserInfo> getUsers(boolean excludeDying) {
            return getUsers(true, excludeDying, true);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public List<UserInfo> getUsers(boolean excludePartial, boolean excludeDying, boolean excludePreCreated) {
            return UserManagerService.m7013$$Nest$mgetUsersInternal(this.this$0, excludePartial, excludeDying, excludePreCreated);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int[] getProfileIds(int userId, boolean enabledOnly) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            int[] r1 = UserManagerService.m7003$$Nest$mgetProfileIdsLU(this.this$0, userId, null, enabledOnly, false).toArray();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int[] getProfileIdsExcludingHidden(int userId, boolean enabledOnly) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            int[] r1 = UserManagerService.m7003$$Nest$mgetProfileIdsLU(this.this$0, userId, null, enabledOnly, true).toArray();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public LauncherUserInfo getLauncherUserInfo(int userId) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserInfo userInfo = UserManagerService.m7008$$Nest$mgetUserInfoLU(this.this$0, userId);     // Catch: Throwable -> L22
            monitor-exit(r0);     // Catch: Throwable -> L22
            if (userInfo == null) goto L20;
            UserTypeDetails userDetails = UserManagerService.m7011$$Nest$mgetUserTypeDetails(this.this$0, userInfo);
            Bundle config = new Bundle();
            if (userInfo.isPrivateProfile() == false) goto L19;
            int parentId = UserManagerService.m7004$$Nest$mgetProfileParentIdUnchecked(this.this$0, userId);     // Catch: android.provider.Settings.SettingNotFoundException -> L16
            boolean r7 = true;
            if (android.provider.Settings.Secure.getIntForUser(UserManagerService.m6974$$Nest$fgetmContext(this.this$0).getContentResolver(), "hide_privatespace_entry_point", parentId) == 1) goto L14;
            r7 = false;
        L14:
            config.putBoolean("private_space_entrypoint_hidden", r7);     // Catch: android.provider.Settings.SettingNotFoundException -> L16
        L17:
            config.putBoolean("private_space_entrypoint_hidden", false);
        L19:
            return new LauncherUserInfo.Builder(userDetails.getName(), userInfo.serialNumber, config).build();
        L20:
            return null;
        L22:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserUnlockingOrUnlocked(int userId) {
            WatchedUserStates r0 = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0);
            monitor-enter(r0);
            int state = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0).get(userId, -1);     // Catch: Throwable -> L21
            monitor-exit(r0);     // Catch: Throwable -> L21
            if (state == 4) goto L20;
            if (state == 5) goto L20;
            if (state != 2) goto L14;
        L17:
            return true;
        L14:
            if (state == 3) goto L17;
            return false;
        L20:
            return StorageManager.isCeStorageUnlocked(userId);
        L21:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserUnlocked(int userId) {
            WatchedUserStates r0 = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0);
            monitor-enter(r0);
            int state = UserManagerService.m6984$$Nest$fgetmUserStates(this.this$0).get(userId, -1);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            if (state == 4) goto L17;
            if (state == 5) goto L17;
            if (state != 3) goto L14;
            return true;
        L14:
            return false;
        L17:
            return StorageManager.isCeStorageUnlocked(userId);
        L18:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserInitialized(int userId) {
            UserInfo userInfo = getUserInfo(userId);
            if (userInfo != null) goto L5;
        L7:
            return false;
        L5:
            if ((userInfo.flags & 16) == 0) goto L7;
            return true;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean exists(int userId) {
            if (UserManagerService.m7009$$Nest$mgetUserInfoNoChecks(this.this$0, userId) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isProfileAccessible(int callingUserId, int targetUserId, String debugMsg, boolean throwSecurityException) {
            if (targetUserId != callingUserId) goto L5;
            return true;
        L5:
            Object r1 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r1);
            UserInfo callingUserInfo = UserManagerService.m7008$$Nest$mgetUserInfoLU(this.this$0, callingUserId);     // Catch: Throwable -> L24
            if (callingUserInfo == null) goto L35;
            if (callingUserInfo.isProfile() == true) goto L35;
            UserInfo targetUserInfo = UserManagerService.m7008$$Nest$mgetUserInfoLU(this.this$0, targetUserId);     // Catch: Throwable -> L24
            if (targetUserInfo == null) goto L31;
            if (targetUserInfo.isEnabled() == false) goto L31;
            if (targetUserInfo.profileGroupId == (-10000)) goto L26;
            if (targetUserInfo.profileGroupId != callingUserInfo.profileGroupId) goto L26;
            monitor-exit(r1);     // Catch: Throwable -> L24
            return true;
        L26:
            if (throwSecurityException == true) goto L30;
            monitor-exit(r1);     // Catch: Throwable -> L24
            return false;
        L30:
            throw new SecurityException(debugMsg + " for unrelated profile " + targetUserId);     // Catch: Throwable -> L24
        L31:
            if (throwSecurityException == false) goto L33;
            Slog.w(UserManagerService.LOG_TAG, debugMsg + " for disabled profile " + targetUserId + " from " + callingUserId);     // Catch: Throwable -> L24
        L33:
            monitor-exit(r1);     // Catch: Throwable -> L24
            return false;
        L35:
            if (throwSecurityException == true) goto L40;
            Slog.w(UserManagerService.LOG_TAG, debugMsg + " for another profile " + targetUserId + " from " + callingUserId);     // Catch: Throwable -> L24
            monitor-exit(r1);     // Catch: Throwable -> L24
            return false;
        L40:
            throw new SecurityException(debugMsg + " for another profile " + targetUserId + " from " + callingUserId);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getProfileParentId(int userId) {
            return UserManagerService.m7004$$Nest$mgetProfileParentIdUnchecked(this.this$0, userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isSettingRestrictedForUser(String setting, int userId, String value, int callingUid) {
            return this.this$0.isSettingRestrictedForUser(setting, userId, value, callingUid);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean hasUserRestriction(String restrictionKey, int userId) {
            if (UserRestrictionsUtils.isValidRestriction(restrictionKey) == true) goto L5;
            return false;
        L5:
            Bundle restrictions = UserManagerService.m7001$$Nest$mgetEffectiveUserRestrictions(this.this$0, userId);
            if (restrictions != null) goto L8;
            return false;
        L8:
            if (restrictions.getBoolean(restrictionKey) == false) goto L12;
            return true;
        L12:
            return false;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public UserInfo getUserInfo(int userId) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserData userData = (UserData) UserManagerService.m6986$$Nest$fgetmUsers(this.this$0).get(userId);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            if (userData != null) goto L9;
            return null;
        L9:
            return userData.info;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public UserInfo[] getUserInfos() {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            int userSize = UserManagerService.m6986$$Nest$fgetmUsers(this.this$0).size();     // Catch: Throwable -> L7
            UserInfo[] allInfos = new UserInfo[userSize];     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= userSize) goto L10;
            allInfos[i] = ((UserData) UserManagerService.m6986$$Nest$fgetmUsers(this.this$0).valueAt(i)).info;     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return allInfos;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void setDefaultCrossProfileIntentFilters(int parentUserId, int profileUserId) {
            UserTypeDetails userTypeDetails = UserManagerService.m7012$$Nest$mgetUserTypeDetailsNoChecks(this.this$0, profileUserId);
            Bundle restrictions = UserManagerService.m7001$$Nest$mgetEffectiveUserRestrictions(this.this$0, profileUserId);
            UserManagerService.m7021$$Nest$msetDefaultCrossProfileIntentFilters(this.this$0, profileUserId, userTypeDetails, restrictions, parentUserId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean shouldIgnorePrepareStorageErrors(int userId) {
            Object r0 = UserManagerService.m6987$$Nest$fgetmUsersLock(this.this$0);
            monitor-enter(r0);
            UserData userData = (UserData) UserManagerService.m6986$$Nest$fgetmUsers(this.this$0).get(userId);     // Catch: Throwable -> L9
            if (userData != null) goto L7;
        L11:
            boolean r2 = false;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L7:
            if (userData.getIgnorePrepareStorageErrors() == false) goto L11;
            r2 = true;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public UserProperties getUserProperties(int userId) {
            UserProperties props = UserManagerService.m7010$$Nest$mgetUserPropertiesInternal(this.this$0, userId);
            if (props != null) goto L5;
            Slog.w(UserManagerService.LOG_TAG, "A null UserProperties was returned for user " + userId);
        L5:
            return props;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int assignUserToDisplayOnStart(int userId, int profileGroupId, int userStartMode, int displayId) {
            UserProperties properties = getUserProperties(userId);
            if (properties != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            boolean isAlwaysVisible = r1;
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).assignUserToDisplayOnStart(userId, profileGroupId, userStartMode, displayId, isAlwaysVisible);
        L5:
            if (properties.getAlwaysVisible() == false) goto L7;
            r1 = true;
            goto L8
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean assignUserToExtraDisplay(int userId, int displayId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).assignUserToExtraDisplay(userId, displayId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean unassignUserFromExtraDisplay(int userId, int displayId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).unassignUserFromExtraDisplay(userId, displayId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void unassignUserFromDisplayOnStop(int userId) {
            UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).unassignUserFromDisplayOnStop(userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserVisible(int userId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).isUserVisible(userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isUserVisible(int userId, int displayId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).isUserVisible(userId, displayId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public boolean isVisibleBackgroundFullUser(int userId) {
            if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L6;
            return false;
        L6:
            if (userId != this.this$0.getCurrentUserId()) goto L8;
            boolean isForeground = true;
        L9:
            boolean isProfile = UserManagerService.m7015$$Nest$misProfileUnchecked(this.this$0, userId);
            boolean isVisible = isUserVisible(userId);
            if (isVisible == false) goto L15;
            if (isForeground == true) goto L16;
            if (isProfile == false) goto L14;
            return false;
        L14:
            return true;
        L16:
            return false;
        L15:
            return false;
        L8:
            isForeground = false;
            goto L9
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getMainDisplayAssignedToUser(int userId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).getMainDisplayAssignedToUser(userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int[] getDisplaysAssignedToUser(int userId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).getDisplaysAssignedToUser(userId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getUserAssignedToDisplay(int displayId) {
            return UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).getUserAssignedToDisplay(displayId);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void addUserVisibilityListener(UserManagerInternal.UserVisibilityListener listener) {
            UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).addListener(listener);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void removeUserVisibilityListener(UserManagerInternal.UserVisibilityListener listener) {
            UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).removeListener(listener);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public void onSystemUserVisibilityChanged(boolean visible) {
            UserManagerService.m6985$$Nest$fgetmUserVisibilityMediator(this.this$0).onSystemUserVisibilityChanged(visible);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int[] getUserTypesForStatsd(int[] userIds) {
            if (userIds != null) goto L5;
            return null;
        L5:
            int[] userTypes = new int[userIds.length];
            int i = 0;
        L7:
            if (i >= userTypes.length) goto L14;
            UserInfo userInfo = getUserInfo(userIds[i]);
            if (userInfo != null) goto L11;
            UserManagerService.m6981$$Nest$fgetmUserJourneyLogger(this.this$0);
            userTypes[i] = UserJourneyLogger.getUserTypeForStatsd("");
        L12:
            i = i + 1;
            goto L7
        L11:
            UserManagerService.m6981$$Nest$fgetmUserJourneyLogger(this.this$0);
            userTypes[i] = UserJourneyLogger.getUserTypeForStatsd(userInfo.userType);
            goto L12
        L14:
            return userTypes;
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getMainUserId() {
            return UserManagerService.m7002$$Nest$mgetMainUserIdUnchecked(this.this$0);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getBootUser(boolean waitUntilSet) throws UserManager.CheckedUserOperationException {
            if (waitUntilSet == false) goto L17;
            TimingsTraceAndSlog t = new TimingsTraceAndSlog();
            t.traceBegin("wait-boot-user");
        L8:
            e = move-exception;
            Thread.currentThread().interrupt();
            Slogf.w(UserManagerService.LOG_TAG, e, "InterruptedException during wait for boot user.", new Object[0]);
        L15:
            t.traceEnd();
            goto L17
        L6:
            if (UserManagerService.m6973$$Nest$fgetmBootUserLatch(this.this$0).getCount() == 0) goto L11;
            Slogf.d(UserManagerService.LOG_TAG, "Sleeping for boot user to be set. Max sleep for Time: %d", new Object[]{300000L});     // Catch: InterruptedException -> L8
        L11:
            if (UserManagerService.m6973$$Nest$fgetmBootUserLatch(this.this$0).await(300000, TimeUnit.MILLISECONDS) == true) goto L15;
            Slogf.w(UserManagerService.LOG_TAG, "Boot user not set. Timeout: %d", new Object[]{300000L});     // Catch: InterruptedException -> L8
        L17:
            return UserManagerService.m6999$$Nest$mgetBootUserUnchecked(this.this$0);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getCommunalProfileId() {
            return UserManagerService.m7000$$Nest$mgetCommunalProfileIdUnchecked(this.this$0);
        }

        @Override // com.android.server.pm.UserManagerInternal
        public int getSupervisingProfileId() {
            return UserManagerService.m7005$$Nest$mgetSupervisingProfileId(this.this$0);
        }
    }

    final class MainHandler extends Handler {
        final /* synthetic */ UserManagerService this$0;

        MainHandler(UserManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L13;
                case 2: goto L5;
                default: goto L30;
            };
        L5:
            removeMessages(2);
            Object r0 = UserManagerService.m6978$$Nest$fgetmPackagesLock(this.this$0);
            monitor-enter(r0);
            UserManagerService.m7027$$Nest$mwriteUserListLP(this.this$0);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            removeMessages(1, msg.obj);
            Object r1 = UserManagerService.m6978$$Nest$fgetmPackagesLock(this.this$0);
            monitor-enter(r1);
            int userId = ((Integer) msg.obj).intValue();     // Catch: Throwable -> L18
            UserData userData = UserManagerService.m7007$$Nest$mgetUserDataNoChecks(this.this$0, userId);     // Catch: Throwable -> L18
            if (userData == null) goto L20;
            UserManagerService.m7026$$Nest$mwriteUserLP(this.this$0, userData);     // Catch: Throwable -> L18
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L18
            return;
        L20:
            Slog.i(UserManagerService.LOG_TAG, "handle(WRITE_USER_MSG): no data for user " + userId + ", it was probably removed before handler could handle it");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            throw th;
        }
    }

    private class PrivateSpaceAutoLockTimer implements AlarmManager.OnAlarmListener {
        private final int mUserId;
        final /* synthetic */ UserManagerService this$0;

        PrivateSpaceAutoLockTimer(UserManagerService r1, int userId) {
            this.this$0 = r1;
            this.mUserId = userId;
        }

        int getUserId() {
            return this.mUserId;
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            PowerManager powerManager = (PowerManager) UserManagerService.m6974$$Nest$fgetmContext(this.this$0).getSystemService(PowerManager.class);
            if (powerManager != null) goto L5;
        L7:
            Slog.i(UserManagerService.LOG_TAG, "Device is interactive, skipping auto-lock for profile user " + this.mUserId);
            return;
        L5:
            if (powerManager.isInteractive() == true) goto L7;
            Slog.i(UserManagerService.LOG_TAG, "Auto-locking private space with user-id " + this.mUserId);
            this.this$0.setQuietModeEnabledAsync(this.mUserId, true, null, UserManagerService.m6974$$Nest$fgetmContext(this.this$0).getPackageName());
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ UserManagerService this$0;

        SettingsObserver(UserManagerService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (UserManagerService.m7028$$Nest$smisAutoLockForPrivateSpaceEnabled() == false) goto L8;
            String path = uri.getLastPathSegment();
            if (TextUtils.equals(path, "private_space_auto_lock") == false) goto L9;
            int autoLockPreference = android.provider.Settings.Secure.getIntForUser(UserManagerService.m6974$$Nest$fgetmContext(this.this$0).getContentResolver(), "private_space_auto_lock", 2, UserManagerService.m7002$$Nest$mgetMainUserIdUnchecked(this.this$0));
            Slog.i(UserManagerService.LOG_TAG, "Auto-lock settings changed to " + autoLockPreference);
            this.this$0.setOrUpdateAutoLockPreferenceForPrivateProfile(autoLockPreference);
            return;
        L9:
            return;
        }
    }

    static class UserData {
        String account;
        UserInfo info;
        private boolean mIgnorePrepareStorageErrors;
        long mLastEnteredForegroundTimeMillis;
        private long mLastRequestQuietModeEnabledMillis;
        boolean persistSeedData;
        String seedAccountName;
        PersistableBundle seedAccountOptions;
        String seedAccountType;
        long startRealtime;
        long unlockRealtime;
        UserProperties userProperties;

        UserData() {
        }

        void setLastRequestQuietModeEnabledMillis(long millis) {
            this.mLastRequestQuietModeEnabledMillis = millis;
        }

        long getLastRequestQuietModeEnabledMillis() {
            return this.mLastRequestQuietModeEnabledMillis;
        }

        boolean getIgnorePrepareStorageErrors() {
            return this.mIgnorePrepareStorageErrors;
        }

        void setIgnorePrepareStorageErrors() {
            if (Build.VERSION.DEVICE_INITIAL_SDK_INT >= 33) goto L6;
            this.mIgnorePrepareStorageErrors = true;
            return;
        L6:
            Slog.w(UserManagerService.LOG_TAG, "Not setting mIgnorePrepareStorageErrors to true since this is a new device");
        }

        void clearSeedAccountData() {
            this.seedAccountName = null;
            this.seedAccountType = null;
            this.seedAccountOptions = null;
            this.persistSeedData = false;
        }
    }

    private class WatchedUserStates {
        final SparseIntArray states;

        public WatchedUserStates(UserManagerService r1) {
            this.states = new SparseIntArray();
            invalidateIsUserUnlockedCache();
        }

        public int get(int userId) {
            return this.states.get(userId);
        }

        public int get(int userId, int fallback) {
            if (this.states.indexOfKey(userId) < 0) goto L6;
            return this.states.get(userId);
        L6:
            return fallback;
        }

        public void put(int userId, int state) {
            this.states.put(userId, state);
            invalidateIsUserUnlockedCache();
        }

        public void delete(int userId) {
            this.states.delete(userId);
            invalidateIsUserUnlockedCache();
        }

        public boolean has(int userId) {
            if (this.states.get(userId, ProcessList.INVALID_ADJ) == (-10000)) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return this.states.toString();
        }

        private void invalidateIsUserUnlockedCache() {
            UserManager.invalidateIsUserUnlockedCache();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-nIi6LRodwAORSqw6XAooGUSiIc, reason: not valid java name */
    public static /* synthetic */ void m6970$r8$lambda$nIi6LRodwAORSqw6XAooGUSiIc(UserManagerService r0, UserInfo r1, Object r2) {
        r0.lambda$convertPreCreatedUserIfPossible$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$26ui7_lCqlzkPpzw0dz2f9n5uFs(UserManagerService r0, Bundle r1, int r2) {
        r0.lambda$updateUserRestrictionsInternalLR$3(r1, r2);
    }

    public static /* synthetic */ Boolean $r8$lambda$8eV6Xmej9_mxKEMO7xMgASyHpwA(UserManagerService r0, Account r1, String r2, String r3) {
        return r0.lambda$someUserHasAccountNoChecks$7(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$NMj-qB85ijSYwf8IH4Vvg91OKvo, reason: not valid java name */
    public static /* synthetic */ void m6971$r8$lambda$NMjqB85ijSYwf8IH4Vvg91OKvo(IUserRestrictionsListener r0, int r1, Bundle r2, Bundle r3) {
        lambda$addUserRestrictionsListener$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$rRhoSdlK7ENXzeQ0MuUSUFWjg60(UserManagerService r0, int r1, boolean r2, IntentSender r3, String r4) {
        r0.lambda$setQuietModeEnabledAsync$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$tsX7gCLULeeS3JBY0HD-bzVn0iQ, reason: not valid java name */
    public static /* synthetic */ void m6972$r8$lambda$tsX7gCLULeeS3JBY0HDbzVn0iQ(UserManagerService r0, int r1, String r2) {
        r0.lambda$getUserListFile$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$vpJVddHmPlPLapyRDgqvMTpabok(UserManagerService r0, int r1, int r2, String r3) {
        r0.lambda$getUserFile$5(r1, r2, r3);
    }

    public static /* synthetic */ int $r8$lambda$yIybRUvnMFarqB2JHfYXkMUsauk(UserManagerService r0, int r1, List r2) {
        return r0.onPullAtom(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootUserLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m6973$$Nest$fgetmBootUserLatch(UserManagerService r0) {
        return r0.mBootUserLatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6974$$Nest$fgetmContext(UserManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6975$$Nest$fgetmHandler(UserManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsDeviceManaged, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6976$$Nest$fgetmIsDeviceManaged(UserManagerService r0) {
        return r0.mIsDeviceManaged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsUserManaged, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m6977$$Nest$fgetmIsUserManaged(UserManagerService r0) {
        return r0.mIsUserManaged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackagesLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6978$$Nest$fgetmPackagesLock(UserManagerService r0) {
        return r0.mPackagesLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPm, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerService m6979$$Nest$fgetmPm(UserManagerService r0) {
        return r0.mPm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRestrictionsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6980$$Nest$fgetmRestrictionsLock(UserManagerService r0) {
        return r0.mRestrictionsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserJourneyLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserJourneyLogger m6981$$Nest$fgetmUserJourneyLogger(UserManagerService r0) {
        return r0.mUserJourneyLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserLifecycleListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m6982$$Nest$fgetmUserLifecycleListeners(UserManagerService r0) {
        return r0.mUserLifecycleListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserRestrictionsListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m6983$$Nest$fgetmUserRestrictionsListeners(UserManagerService r0) {
        return r0.mUserRestrictionsListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ WatchedUserStates m6984$$Nest$fgetmUserStates(UserManagerService r0) {
        return r0.mUserStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserVisibilityMediator, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserVisibilityMediator m6985$$Nest$fgetmUserVisibilityMediator(UserManagerService r0) {
        return r0.mUserVisibilityMediator;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6986$$Nest$fgetmUsers(UserManagerService r0) {
        return r0.mUsers;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsersLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6987$$Nest$fgetmUsersLock(UserManagerService r0) {
        return r0.mUsersLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentBootPhase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6988$$Nest$fputmCurrentBootPhase(UserManagerService r0, int r1) {
        r0.mCurrentBootPhase = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmForceEphemeralUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6989$$Nest$fputmForceEphemeralUsers(UserManagerService r0, boolean r1) {
        r0.mForceEphemeralUsers = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsDeviceManaged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6990$$Nest$fputmIsDeviceManaged(UserManagerService r0, boolean r1) {
        r0.mIsDeviceManaged = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddUserInfoFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6991$$Nest$maddUserInfoFlags(UserManagerService r0, UserInfo r1, int r2) {
        r0.addUserInfoFlags(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyUserRestrictionsLR, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6992$$Nest$mapplyUserRestrictionsLR(UserManagerService r0, int r1) {
        r0.applyUserRestrictionsLR(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelPendingAutoLockAlarms, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6993$$Nest$mcancelPendingAutoLockAlarms(UserManagerService r0) {
        r0.cancelPendingAutoLockAlarms();
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupPartialUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6994$$Nest$mcleanupPartialUsers(UserManagerService r0) {
        r0.cleanupPartialUsers();
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupPreCreatedUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6995$$Nest$mcleanupPreCreatedUsers(UserManagerService r0) {
        r0.cleanupPreCreatedUsers();
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateUserInternalUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserInfo m6996$$Nest$mcreateUserInternalUnchecked(UserManagerService r0, String r1, String r2, int r3, int r4, boolean r5, String[] r6, Object r7) {
        return r0.createUserInternalUnchecked(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mfinishRemoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6997$$Nest$mfinishRemoveUser(UserManagerService r0, int r1) {
        r0.finishRemoveUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m6998$$Nest$mgetActivityManagerInternal(UserManagerService r0) {
        return r0.getActivityManagerInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetBootUserUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6999$$Nest$mgetBootUserUnchecked(UserManagerService r0) {
        return r0.getBootUserUnchecked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCommunalProfileIdUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7000$$Nest$mgetCommunalProfileIdUnchecked(UserManagerService r0) {
        return r0.getCommunalProfileIdUnchecked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetEffectiveUserRestrictions, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m7001$$Nest$mgetEffectiveUserRestrictions(UserManagerService r0, int r1) {
        return r0.getEffectiveUserRestrictions(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMainUserIdUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7002$$Nest$mgetMainUserIdUnchecked(UserManagerService r0) {
        return r0.getMainUserIdUnchecked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetProfileIdsLU, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntArray m7003$$Nest$mgetProfileIdsLU(UserManagerService r0, int r1, String r2, boolean r3, boolean r4) {
        return r0.getProfileIdsLU(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetProfileParentIdUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7004$$Nest$mgetProfileParentIdUnchecked(UserManagerService r0, int r1) {
        return r0.getProfileParentIdUnchecked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSupervisingProfileId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7005$$Nest$mgetSupervisingProfileId(UserManagerService r0) {
        return r0.getSupervisingProfileId();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserDataLU, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserData m7006$$Nest$mgetUserDataLU(UserManagerService r0, int r1) {
        return r0.getUserDataLU(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserDataNoChecks, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserData m7007$$Nest$mgetUserDataNoChecks(UserManagerService r0, int r1) {
        return r0.getUserDataNoChecks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserInfoLU, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserInfo m7008$$Nest$mgetUserInfoLU(UserManagerService r0, int r1) {
        return r0.getUserInfoLU(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserInfoNoChecks, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserInfo m7009$$Nest$mgetUserInfoNoChecks(UserManagerService r0, int r1) {
        return r0.getUserInfoNoChecks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserPropertiesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserProperties m7010$$Nest$mgetUserPropertiesInternal(UserManagerService r0, int r1) {
        return r0.getUserPropertiesInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserTypeDetails, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserTypeDetails m7011$$Nest$mgetUserTypeDetails(UserManagerService r0, UserInfo r1) {
        return r0.getUserTypeDetails(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserTypeDetailsNoChecks, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserTypeDetails m7012$$Nest$mgetUserTypeDetailsNoChecks(UserManagerService r0, int r1) {
        return r0.getUserTypeDetailsNoChecks(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUsersInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m7013$$Nest$mgetUsersInternal(UserManagerService r0, boolean r1, boolean r2, boolean r3) {
        return r0.getUsersInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$minvalidateOwnerNameIfNecessary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7014$$Nest$minvalidateOwnerNameIfNecessary(UserManagerService r0, Resources r1, boolean r2) {
        r0.invalidateOwnerNameIfNecessary(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misProfileUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7015$$Nest$misProfileUnchecked(UserManagerService r0, int r1) {
        return r0.isProfileUnchecked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterStatsCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7016$$Nest$mregisterStatsCallbacks(UserManagerService r0) {
        r0.registerStatsCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAllUsersExceptSystemAndPermanentAdminMain, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7017$$Nest$mremoveAllUsersExceptSystemAndPermanentAdminMain(UserManagerService r0) {
        r0.removeAllUsersExceptSystemAndPermanentAdminMain();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUserState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7018$$Nest$mremoveUserState(UserManagerService r0, int r1) {
        r0.removeUserState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUserWithProfilesUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7019$$Nest$mremoveUserWithProfilesUnchecked(UserManagerService r0, int r1) {
        return r0.removeUserWithProfilesUnchecked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendUserInfoChangedBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7020$$Nest$msendUserInfoChangedBroadcast(UserManagerService r0, int r1) {
        r0.sendUserInfoChangedBroadcast(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDefaultCrossProfileIntentFilters, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7021$$Nest$msetDefaultCrossProfileIntentFilters(UserManagerService r0, int r1, UserTypeDetails r2, Bundle r3, int r4) {
        r0.setDefaultCrossProfileIntentFilters(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDevicePolicyUserRestrictionsInner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7022$$Nest$msetDevicePolicyUserRestrictionsInner(UserManagerService r0, int r1, Bundle r2, RestrictionsSet r3, boolean r4) {
        r0.setDevicePolicyUserRestrictionsInner(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetLastEnteredForegroundTimeToNow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7023$$Nest$msetLastEnteredForegroundTimeToNow(UserManagerService r0, UserData r1) {
        r0.setLastEnteredForegroundTimeToNow(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartCommunalProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7024$$Nest$mstartCommunalProfile(UserManagerService r0) {
        r0.startCommunalProfile();
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteBitmapLP, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7025$$Nest$mwriteBitmapLP(UserManagerService r0, UserInfo r1, Bitmap r2) {
        r0.writeBitmapLP(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteUserLP, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7026$$Nest$mwriteUserLP(UserManagerService r0, UserData r1) {
        r0.writeUserLP(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteUserListLP, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7027$$Nest$mwriteUserListLP(UserManagerService r0) {
        r0.writeUserListLP();
    }

    /* JADX INFO: renamed from: -$$Nest$smisAutoLockForPrivateSpaceEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7028$$Nest$smisAutoLockForPrivateSpaceEnabled() {
        return isAutoLockForPrivateSpaceEnabled();
    }

    static {
        USER_INFO_DIR = "system" + File.separator + "users";
        PRIVATE_SPACE_AUTO_LOCK_INACTIVITY_ALARM_WINDOW_MS = TimeUnit.SECONDS.toMillis(55);
    }

    private void cancelPendingAutoLockAlarms() {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        if (alarmManager != null) goto L5;
        return;
    L5:
        if (this.mPrivateSpaceAutoLockTimer == null) goto L9;
        alarmManager.cancel(this.mPrivateSpaceAutoLockTimer);
        return;
    }

    void maybeScheduleAlarmToAutoLockPrivateSpace() {
        int privateSpaceAutoLockPreference = android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "private_space_auto_lock", 2, getMainUserIdUnchecked());
        if (privateSpaceAutoLockPreference == 1) goto L6;
        Slogf.d(LOG_TAG, "Not scheduling auto-lock on inactivity,preference is set to %d", new Object[]{Integer.valueOf(privateSpaceAutoLockPreference)});
        return;
    L6:
        int privateProfileUserId = getPrivateProfileUserId();
        if (privateProfileUserId != (-10000)) goto L9;
        return;
    L9:
        if (isQuietModeEnabled(privateProfileUserId) == false) goto L12;
        Slogf.d(LOG_TAG, "Not scheduling auto-lock alarm for %d, quiet mode already enabled", new Object[]{Integer.valueOf(privateProfileUserId)});
        return;
    L12:
        scheduleAlarmToAutoLockPrivateSpace(privateProfileUserId, 300000);
    }

    void scheduleAlarmToAutoLockPrivateSpace(int userId, long delayInMillis) {
        AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        if (alarmManager != null) goto L6;
        Slog.e(LOG_TAG, "AlarmManager not available, cannot schedule auto-lock alarm");
        return;
    L6:
        initPrivateSpaceAutoLockTimer(userId);
        long alarmWindowStartTime = SystemClock.elapsedRealtime() + delayInMillis;
        alarmManager.setWindow(2, alarmWindowStartTime, PRIVATE_SPACE_AUTO_LOCK_INACTIVITY_ALARM_WINDOW_MS, PRIVATE_SPACE_AUTO_LOCK_TIMER_TAG, new HandlerExecutor(this.mHandler), this.mPrivateSpaceAutoLockTimer);
    }

    private void initPrivateSpaceAutoLockTimer(int userId) {
        cancelPendingAutoLockAlarms();
        if (this.mPrivateSpaceAutoLockTimer != null) goto L5;
    L6:
        this.mPrivateSpaceAutoLockTimer = new PrivateSpaceAutoLockTimer(this, userId);
        return;
    L5:
        if (this.mPrivateSpaceAutoLockTimer.getUserId() != userId) goto L6;
    }

    private void initializeAndRegisterKeyguardLockedStateListener() {
        this.mKeyguardLockedStateListener = new UserManagerService$$ExternalSyntheticLambda2(this);
        KeyguardManager keyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);     // Catch: Exception -> L5
        Slog.i(LOG_TAG, "Adding keyguard locked state listener");     // Catch: Exception -> L5
        keyguardManager.addKeyguardLockedStateListener(new HandlerExecutor(this.mHandler), this.mKeyguardLockedStateListener);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(LOG_TAG, "Error adding keyguard locked listener ", e);
    }

    void setOrUpdateAutoLockPreferenceForPrivateProfile(int autoLockPreference) {
        int privateProfileUserId = getPrivateProfileUserId();
        if (privateProfileUserId != (-10000)) goto L7;
        Slog.e(LOG_TAG, "Auto-lock preference updated but private space user not found");
        return;
    L7:
        if (autoLockPreference != 1) goto L12;
        if (this.mIsDeviceInactivityBroadcastReceiverRegistered == true) goto L14;
        Slog.i(LOG_TAG, "Registering device inactivity broadcast receivers");
        this.mContext.registerReceiver(this.mDeviceInactivityBroadcastReceiver, new IntentFilter("android.intent.action.SCREEN_OFF"), null, this.mHandler);
        this.mContext.registerReceiver(this.mDeviceInactivityBroadcastReceiver, new IntentFilter("android.intent.action.SCREEN_ON"), null, this.mHandler);
        this.mIsDeviceInactivityBroadcastReceiverRegistered = true;
    L14:
        if (autoLockPreference != 0) goto L21;
        initializeAndRegisterKeyguardLockedStateListener();
        return;
    L21:
        KeyguardManager keyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);     // Catch: Exception -> L18
        Slog.i(LOG_TAG, "Removing keyguard locked state listener");     // Catch: Exception -> L18
        keyguardManager.removeKeyguardLockedStateListener(this.mKeyguardLockedStateListener);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error adding keyguard locked state listener ", e);
        return;
    L12:
        if (this.mIsDeviceInactivityBroadcastReceiverRegistered == false) goto L14;
        Slog.i(LOG_TAG, "Removing device inactivity broadcast receivers");
        cancelPendingAutoLockAlarms();
        this.mContext.unregisterReceiver(this.mDeviceInactivityBroadcastReceiver);
        this.mIsDeviceInactivityBroadcastReceiverRegistered = false;
        goto L14
    }

    void tryAutoLockingPrivateSpaceOnKeyguardChanged(boolean isKeyguardLocked) {
        if (isAutoLockForPrivateSpaceEnabled() == false) goto L12;
        int autoLockPreference = android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "private_space_auto_lock", 2, getMainUserIdUnchecked());
        if (autoLockPreference != 0) goto L7;
        boolean isAutoLockOnDeviceLockSelected = true;
    L8:
        if (isKeyguardLocked == false) goto L13;
        if (isAutoLockOnDeviceLockSelected == false) goto L14;
        autoLockPrivateSpace();
        return;
    L14:
        return;
    L13:
        return;
    L7:
        isAutoLockOnDeviceLockSelected = false;
        goto L8
    }

    void autoLockPrivateSpace() {
        int privateProfileUserId = getPrivateProfileUserId();
        if (privateProfileUserId == (-10000)) goto L6;
        Slog.i(LOG_TAG, "Auto-locking private space with user-id " + privateProfileUserId);
        setQuietModeEnabledAsync(privateProfileUserId, true, null, this.mContext.getPackageName());
        return;
    }

    void setQuietModeEnabledAsync(final int userId, final boolean enableQuietMode, final IntentSender target, final String callingPackage) {
        Slog.d(LOG_TAG, "Calling setQuietModeEnabled for user " + userId + " on a separate thread");
        this.mInternalExecutor.execute(new UserManagerService$$ExternalSyntheticLambda4(this, userId, enableQuietMode, target, callingPackage));
    }

    private /* synthetic */ void lambda$setQuietModeEnabledAsync$0(int userId, boolean enableQuietMode, IntentSender target, String callingPackage) {
        setQuietModeEnabled(userId, enableQuietMode, target, callingPackage);
    }

    private /* synthetic */ void lambda$setQuietModeEnabledAsync$1(int userId, boolean enableQuietMode, IntentSender target, String callingPackage) {
        setQuietModeEnabled(userId, enableQuietMode, target, callingPackage);
    }

    public static UserManagerService getInstance() {
        monitor-enter(UserManagerService.class);
        UserManagerService r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(UserManagerService.class);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    UserManagerService(Context context) {
        this(context, null, null, new Object(), context.getCacheDir(), null);
    }

    UserManagerService(Context context, PackageManagerService pm, UserDataPreparer userDataPreparer, Object packagesLock) {
        this(context, pm, userDataPreparer, packagesLock, Environment.getDataDirectory(), null);
    }

    UserManagerService(Context context, PackageManagerService pm, UserDataPreparer userDataPreparer, Object packagesLock, File dataDir, SparseArray<UserData> users) {
        this.mUsersLock = LockGuard.installNewLock(2);
        this.mRestrictionsLock = new Object();
        this.mAppRestrictionsLock = new Object();
        this.mUserRestrictionToken = new Binder();
        this.mBootUserLatch = new CountDownLatch(1);
        this.mBaseUserRestrictions = new RestrictionsSet();
        this.mCachedEffectiveUserRestrictions = new RestrictionsSet();
        this.mAppliedUserRestrictions = new RestrictionsSet();
        this.mDevicePolicyUserRestrictions = new RestrictionsSet();
        this.mGuestRestrictions = new Bundle();
        this.mRemovingUserIds = new SparseBooleanArray();
        this.mRecentlyRemovedIds = new LinkedList();
        this.mUserVersion = 0;
        this.mUserTypeVersion = 0;
        this.mIsUserManaged = new SparseBooleanArray();
        this.mUserRestrictionsListeners = new ArrayList();
        this.mUserLifecycleListeners = new ArrayList();
        this.mUserJourneyLogger = new UserJourneyLogger();
        this.ACTION_DISABLE_QUIET_MODE_AFTER_UNLOCK = "com.android.server.pm.DISABLE_QUIET_MODE_AFTER_UNLOCK";
        this.mDisableQuietModeCallback = new AnonymousClass1(this);
        this.mIsDeviceInactivityBroadcastReceiverRegistered = false;
        this.mDeviceInactivityBroadcastReceiver = new AnonymousClass2(this);
        this.mOwnerName = new AtomicReference();
        this.mOwnerNameTypedValue = new TypedValue();
        this.mLastConfiguration = new Configuration();
        this.mConfigurationChangeReceiver = new AnonymousClass3(this);
        this.mUserStates = new WatchedUserStates(this);
        this.mBootUser = ProcessList.INVALID_ADJ;
        this.mContext = context;
        this.mPm = pm;
        this.mPackagesLock = packagesLock;
        if (users == null) goto L5;
        SparseArray<UserData> r3 = users;
    L6:
        this.mUsers = r3;
        this.mHandler = new MainHandler(this);
        this.mInternalExecutor = new ThreadPoolExecutor(0, 1, 24, TimeUnit.HOURS, new LinkedBlockingQueue());
        this.mUserVisibilityMediator = new UserVisibilityMediator(this.mHandler);
        this.mUserDataPreparer = userDataPreparer;
        this.mUserTypes = UserTypeFactory.getUserTypes();
        invalidateOwnerNameIfNecessary(getContextResources(), true);
        Object r1 = this.mPackagesLock;
        monitor-enter(r1);
        this.mUsersDir = new File(dataDir, USER_INFO_DIR);     // Catch: Throwable -> L14
        this.mUsersDir.mkdirs();     // Catch: Throwable -> L14
        File userZeroDir = new File(this.mUsersDir, String.valueOf(0));     // Catch: Throwable -> L14
        userZeroDir.mkdirs();     // Catch: Throwable -> L14
        FileUtils.setPermissions(this.mUsersDir.toString(), 509, -1, -1);     // Catch: Throwable -> L14
        this.mUserListFile = new File(this.mUsersDir, USER_LIST_FILENAME);     // Catch: Throwable -> L14
        initDefaultGuestRestrictions();     // Catch: Throwable -> L14
        readUserListLP();     // Catch: Throwable -> L14
        sInstance = this;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        this.mSystemPackageInstaller = new UserSystemPackageInstaller(this, this.mUserTypes);
        this.mLocalService = new LocalService(this, null);
        LocalServices.addService(UserManagerInternal.class, this.mLocalService);
        this.mLockPatternUtils = new LockPatternUtils(this.mContext);
        this.mUserStates.put(0, 0);
        this.mUser0Allocations = null;
        this.mPrivateSpaceAutoLockSettingsObserver = new SettingsObserver(this, this.mHandler);
        emulateSystemUserModeIfNeeded();
        initPropertyInvalidatedCaches();
        return;
    L14:
        th = th;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw th;
    L16:
        th = th;
        goto L18
    L5:
        r3 = new SparseArray();
        goto L6
    }

    private static final void initPropertyInvalidatedCaches() {
        UserManager.invalidateIsUserUnlockedCache();
        UserManager.invalidateQuietModeEnabledCache();
        UserManager.invalidateStaticUserProperties();
        UserManager.invalidateUserPropertiesCache();
        UserManager.invalidateCacheOnUserListChange();
        UserManager.invalidateUserRestriction();
    }

    void systemReady() {
        this.mAppOpsService = IAppOpsService.Stub.asInterface(ServiceManager.getService("appops"));
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        applyUserRestrictionsLR(0);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        this.mContext.registerReceiver(this.mDisableQuietModeCallback, new IntentFilter("com.android.server.pm.DISABLE_QUIET_MODE_AFTER_UNLOCK"), null, this.mHandler);
        this.mContext.registerReceiver(this.mConfigurationChangeReceiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"), null, this.mHandler);
        if (isAutoLockForPrivateSpaceEnabled() == false) goto L13;
        int mainUserId = getMainUserIdUnchecked();
        if (mainUserId == (-10000)) goto L13;
        this.mContext.getContentResolver().registerContentObserverAsUser(android.provider.Settings.Secure.getUriFor("private_space_auto_lock"), false, this.mPrivateSpaceAutoLockSettingsObserver, UserHandle.of(mainUserId));
        setOrUpdateAutoLockPreferenceForPrivateProfile(android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "private_space_auto_lock", 2, mainUserId));
    L13:
        if (isAutoLockingPrivateSpaceOnRestartsEnabled() == false) goto L15;
        autoLockPrivateSpace();
    L15:
        showHsumNotificationIfNeeded();
        if (UserManagerInternal.shouldShowNotificationForBackgroundUserSounds() == false) goto L24;
        new BackgroundUserSoundNotifier(this.mContext);
        return;
    L24:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private boolean doesDeviceHardwareSupportPrivateSpace() {
        if (this.mPm.hasSystemFeature("android.hardware.type.embedded", 0) == false) goto L5;
        return false;
    L5:
        if (this.mPm.hasSystemFeature("android.hardware.type.watch", 0) == false) goto L7;
        return false;
    L7:
        if (this.mPm.hasSystemFeature("android.software.leanback", 0) == false) goto L9;
        return false;
    L9:
        if (this.mPm.hasSystemFeature("android.hardware.type.automotive", 0) == true) goto L16;
        return true;
    L16:
        return false;
    }

    private static boolean isAutoLockForPrivateSpaceEnabled() {
        return true;
    }

    private boolean isAutoLockingPrivateSpaceOnRestartsEnabled() {
        return true;
    }

    private Resources getSystemResources() {
        return Resources.getSystem();
    }

    private Resources getContextResources() {
        return this.mContext.getResources();
    }

    UserManagerInternal getInternalForInjectorOnly() {
        return this.mLocalService;
    }

    private void startCommunalProfile() {
        int communalProfileId = getCommunalProfileIdUnchecked();
        if (communalProfileId == (-10000)) goto L12;
        Slogf.d(LOG_TAG, "Starting the Communal Profile");
        boolean started = false;
        started = ActivityManager.getService().startProfile(communalProfileId);     // Catch: RemoteException -> L7
    L9:
        if (started == true) goto L17;
        Slogf.wtf(LOG_TAG, "Failed to start communal profile userId=%d", new Object[]{Integer.valueOf(communalProfileId)});
        return;
    L17:
        return;
    L7:
        e = move-exception;
        e.rethrowAsRuntimeException();
        goto L9
    L12:
        Slogf.w(LOG_TAG, "Cannot start Communal Profile because there isn't one");
    }

    private void markUserForRemovalIfNecessaryLU(UserInfo ui) {
        if (ui.isEphemeral() == true) goto L6;
        return;
    L6:
        if (ui.preCreated == false) goto L9;
        return;
    L9:
        if (ui.lastLoggedInTime == 0) goto L11;
    L15:
        addRemovingUserIdLocked(ui.id);
        ui.partial = true;
        addUserInfoFlags(ui, 64);
        return;
    L11:
        if (ui.isGuest() == false) goto L15;
        if (getSystemResources().getBoolean(R.bool.config_hideDisplayCutoutWithDisplayArea) == false) goto L15;
    }

    private void cleanupPartialUsers() {
        ArrayList<UserInfo> partials = new ArrayList();
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= userSize) goto L21;
        UserInfo ui = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L11
        if (ui.partial == true) goto L14;
        if (ui.guestToRemove == true) goto L14;
    L19:
        i = i + 1;     // Catch: Throwable -> L11
    L14:
        if (ui.id == 0) goto L19;
        partials.add(ui);     // Catch: Throwable -> L11
        if (this.mRemovingUserIds.get(ui.id) == true) goto L18;
        addRemovingUserIdLocked(ui.id);     // Catch: Throwable -> L11
    L18:
        ui.partial = true;     // Catch: Throwable -> L11
        goto L19
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L11
        int partialsSize = partials.size();
        int i2 = 0;
    L23:
        if (i2 >= partialsSize) goto L26;
        UserInfo ui2 = partials.get(i2);
        Slog.w(LOG_TAG, "Removing partially created user " + ui2.id + " (name=" + ui2.name + ")");
        removeUserState(ui2.id);
        i2 = i2 + 1;
        goto L23
    L26:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void cleanupPreCreatedUsers() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L9
        ArrayList<UserInfo> preCreatedUsers = new ArrayList(userSize);     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= userSize) goto L13;
        UserInfo ui = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L9
        if (ui.preCreated == false) goto L11;
        preCreatedUsers.add(ui);     // Catch: Throwable -> L9
        addRemovingUserIdLocked(ui.id);     // Catch: Throwable -> L9
        addUserInfoFlags(ui, 64);     // Catch: Throwable -> L9
        ui.partial = true;     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        int preCreatedSize = preCreatedUsers.size();
        int i2 = 0;
    L15:
        if (i2 >= preCreatedSize) goto L18;
        UserInfo ui2 = preCreatedUsers.get(i2);
        Slog.i(LOG_TAG, "Removing pre-created user " + ui2.id);
        removeUserState(ui2.id);
        i2 = i2 + 1;
        goto L15
    L18:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public String getUserAccount(int userId) {
        checkManageUserAndAcrossUsersFullPermission("get user account");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        String r1 = this.mUsers.get(userId).account;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUserAccount(int userId, String accountName) {
        checkManageUserAndAcrossUsersFullPermission("set user account");
        UserData userToUpdate = null;
        Object r1 = this.mPackagesLock;
        monitor-enter(r1);
        Object r2 = this.mUsersLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L14
        if (userData != null) goto L16;
        Slog.e(LOG_TAG, "User not found for setting user account: u" + userId);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L16:
        String currentAccount = userData.account;     // Catch: Throwable -> L14
        if (Objects.equals(currentAccount, accountName) == true) goto L19;
        userData.account = accountName;     // Catch: Throwable -> L14
        userToUpdate = userData;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L14
        if (userToUpdate == null) goto L22;
        writeUserLP(userToUpdate);     // Catch: Throwable -> L12
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public UserInfo getPrimaryUser() {
        checkManageUsersPermission("query users");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= userSize) goto L16;
        UserInfo ui = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L12
        if (ui.isPrimary() == false) goto L14;
        if (this.mRemovingUserIds.get(ui.id) == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return ui;
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public int getMainUserId() {
        checkQueryOrCreateUsersPermission("get main user id");
        return getMainUserIdUnchecked();
    }

    private int getMainUserIdUnchecked() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L13
        int i = 0;
    L5:
        if (i >= userSize) goto L17;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L13
        if (user.isMain() == false) goto L15;
        if (this.mRemovingUserIds.get(user.id) == true) goto L15;
        int r4 = user.id;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return ProcessList.INVALID_ADJ;
    L13:
        th = move-exception;
        throw th;
    }

    private int getPrivateProfileUserId() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int[] r1 = getUserIds();     // Catch: Throwable -> L13
        int r2 = r1.length;     // Catch: Throwable -> L13
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L16;
        int userId = r1[r3];     // Catch: Throwable -> L13
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L13
        if (userInfo == null) goto L15;
        if (userInfo.isPrivateProfile() == false) goto L15;
        int r4 = userInfo.id;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L15:
        r3 = r3 + 1;     // Catch: Throwable -> L13
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return ProcessList.INVALID_ADJ;
    L13:
        th = move-exception;
        throw th;
    }

    public void setBootUser(int userId) {
        checkCreateUsersPermission("Set boot user");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        Slogf.i(LOG_TAG, "setBootUser %d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L8
        this.mBootUser = userId;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mBootUserLatch.countDown();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int getBootUser() {
        checkCreateUsersPermission("Get boot user");
        return getBootUserUnchecked();
    L5:
        e = move-exception;
        throw e.toServiceSpecificException();
    }

    private int getBootUserUnchecked() throws UserManager.CheckedUserOperationException {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mBootUser == (-10000)) goto L16;
        UserData userData = this.mUsers.get(this.mBootUser);     // Catch: Throwable -> L13
        if (userData != null) goto L9;
    L15:
        Slogf.w(LOG_TAG, "Provided boot user cannot be switched to: %d", new Object[]{Integer.valueOf(this.mBootUser)});     // Catch: Throwable -> L13
        goto L16
    L9:
        if (userData.info.supportsSwitchToByUser() == false) goto L15;
        Slogf.i(LOG_TAG, "Using provided boot user: %d", new Object[]{Integer.valueOf(this.mBootUser)});     // Catch: Throwable -> L13
        int r2 = this.mBootUser;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (isHeadlessSystemUserMode() == false) goto L27;
        int bootStrategy = getContextResources().getInteger(R.integer.config_keyguardDrawnTimeout);
        switch(bootStrategy) {
            case 0: goto L26;
            case 1: goto L24;
            default: goto L21;
        };
    L21:
        Slogf.w(LOG_TAG, "Unknown HSUM boot strategy: %d", new Object[]{Integer.valueOf(bootStrategy)});
        return getPreviousOrFirstSwitchableUser();
    L24:
        return getBootUserBasedOnProvisioning();
    L26:
        return getPreviousOrFirstSwitchableUser();
    L27:
        return 0;
    }

    private int getBootUserBasedOnProvisioning() throws UserManager.CheckedUserOperationException {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "device_provisioned", 0) == 0) goto L5;
        boolean provisioned = true;
    L6:
        if (provisioned == false) goto L8;
        return 0;
    L8:
        int firstSwitchableFullUser = getFirstSwitchableUser(true);
        if (firstSwitchableFullUser == (-10000)) goto L13;
        Slogf.i(LOG_TAG, "Boot user is first switchable full user %d", new Object[]{Integer.valueOf(firstSwitchableFullUser)});
        return firstSwitchableFullUser;
    L13:
        throw new UserManager.CheckedUserOperationException("No switchable full user found", 1);
    L5:
        provisioned = false;
        goto L6
    }

    private int getPreviousOrFirstSwitchableUser() throws UserManager.CheckedUserOperationException {
        int previousUser = getPreviousFullUserToEnterForeground();
        if (previousUser == (-10000)) goto L6;
        Slogf.i(LOG_TAG, "Boot user is previous user %d", new Object[]{Integer.valueOf(previousUser)});
        return previousUser;
    L6:
        int firstSwitchableUser = getFirstSwitchableUser(false);
        if (firstSwitchableUser == (-10000)) goto L11;
        Slogf.i(LOG_TAG, "Boot user is first switchable user %d", new Object[]{Integer.valueOf(firstSwitchableUser)});
        return firstSwitchableUser;
    L11:
        throw new UserManager.CheckedUserOperationException("No switchable users found", 1);
    }

    private int getFirstSwitchableUser(boolean fullUserOnly) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= userSize) goto L19;
        UserData userData = this.mUsers.valueAt(i);     // Catch: Throwable -> L12
        if (userData.info.supportsSwitchToByUser() == false) goto L17;
        if (fullUserOnly == false) goto L14;
        if (userData.info.isFull() == false) goto L17;
    L14:
        int firstSwitchable = userData.info.id;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return firstSwitchable;
    L17:
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return ProcessList.INVALID_ADJ;
    L12:
        th = move-exception;
        throw th;
    }

    public int getPreviousFullUserToEnterForeground() {
        checkQueryOrCreateUsersPermission("get previous user");
        return getPreviousFullUserToEnterForegroundUnchecked();
    }

    private int getPreviousFullUserToEnterForegroundUnchecked() {
        int previousUser = ProcessList.INVALID_ADJ;
        long latestEnteredTime = 0;
        int currentUser = getCurrentUserId();
        Object r4 = this.mUsersLock;
        monitor-enter(r4);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L19
        int i = 0;
    L5:
        if (i >= userSize) goto L23;
        UserData userData = this.mUsers.valueAt(i);     // Catch: Throwable -> L19
        int userId = userData.info.id;     // Catch: Throwable -> L19
        if (userId == currentUser) goto L21;
        if (userData.info.isFull() == false) goto L21;
        if (userData.info.partial == true) goto L21;
        if (userData.info.isEnabled() == false) goto L21;
        if (this.mRemovingUserIds.get(userId) == true) goto L21;
        long userEnteredTime = userData.mLastEnteredForegroundTimeMillis;     // Catch: Throwable -> L19
        if (userEnteredTime <= latestEnteredTime) goto L21;
        latestEnteredTime = userEnteredTime;
        previousUser = userId;
    L21:
        i = i + 1;     // Catch: Throwable -> L19
        goto L5
    L23:
        monitor-exit(r4);     // Catch: Throwable -> L19
        return previousUser;
    L19:
        th = move-exception;
        throw th;
    }

    public int getCommunalProfileId() {
        checkQueryOrCreateUsersPermission("get communal profile user id");
        return getCommunalProfileIdUnchecked();
    }

    private int getCommunalProfileIdUnchecked() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L13
        int i = 0;
    L5:
        if (i >= userSize) goto L17;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L13
        if (user.isCommunalProfile() == false) goto L15;
        if (this.mRemovingUserIds.get(user.id) == true) goto L15;
        int r4 = user.id;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return ProcessList.INVALID_ADJ;
    L13:
        th = move-exception;
        throw th;
    }

    private int getSupervisingProfileId() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L13
        int i = 0;
    L5:
        if (i >= userSize) goto L17;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L13
        if (user.isSupervisingProfile() == false) goto L15;
        if (this.mRemovingUserIds.get(user.id) == true) goto L15;
        int r4 = user.id;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return ProcessList.INVALID_ADJ;
    L13:
        th = move-exception;
        throw th;
    }

    public List<UserInfo> getUsers(boolean excludeDying) {
        return getUsers(true, excludeDying, true);
    }

    public List<UserInfo> getUsers(boolean excludePartial, boolean excludeDying, boolean excludePreCreated) {
        checkCreateUsersPermission("query users");
        return getUsersInternal(excludePartial, excludeDying, excludePreCreated);
    }

    private List<UserInfo> getUsersInternal(boolean excludePartial, boolean excludeDying, boolean excludePreCreated) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        ArrayList<UserInfo> users = new ArrayList(this.mUsers.size());     // Catch: Throwable -> L11
        int userSize = this.mUsers.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= userSize) goto L23;
        UserInfo ui = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L11
        if (excludePartial == false) goto L13;
        if (ui.partial == false) goto L13;
    L21:
        i = i + 1;     // Catch: Throwable -> L11
    L13:
        if (excludeDying == true) goto L15;
    L16:
        if (excludePreCreated == true) goto L18;
    L20:
        users.add(userWithName(ui));     // Catch: Throwable -> L11
        goto L21
    L18:
        if (ui.preCreated == false) goto L20;
    L15:
        if (this.mRemovingUserIds.get(ui.id) == true) goto L21;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return users;
    L11:
        th = move-exception;
        throw th;
    }

    public List<UserInfo> getProfiles(int userId, boolean enabledOnly) {
        if (userId == UserHandle.getCallingUserId()) goto L5;
        checkQueryOrCreateUsersPermission("getting profiles related to user " + userId);
        boolean returnFullInfo = true;
    L6:
        long ident = Binder.clearCallingIdentity();
        Object r3 = this.mUsersLock;     // Catch: Throwable -> L17
        monitor-enter(r3);     // Catch: Throwable -> L17
        List<UserInfo> r4 = getProfilesLU(userId, null, enabledOnly, returnFullInfo);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return r4;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L5:
        returnFullInfo = hasCreateUsersPermission();
        goto L6
    }

    public int[] getProfileIds(int userId, boolean enabledOnly) {
        return getProfileIds(userId, null, enabledOnly, false);
    }

    public int[] getProfileIds(int userId, String userType, boolean enabledOnly, boolean excludeHidden) {
        if (userId == UserHandle.getCallingUserId()) goto L5;
        checkQueryOrCreateUsersPermission("getting profiles related to user " + userId);
    L5:
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mUsersLock;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        int[] r3 = getProfileIdsLU(userId, userType, enabledOnly, excludeHidden).toArray();     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return r3;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private List<UserInfo> getProfilesLU(int userId, String userType, boolean enabledOnly, boolean fullInfo) {
        IntArray profileIds = getProfileIdsLU(userId, userType, enabledOnly, false);
        ArrayList<UserInfo> users = new ArrayList(profileIds.size());
        int i = 0;
    L4:
        if (i >= profileIds.size()) goto L11;
        int profileId = profileIds.get(i);
        UserInfo userInfo = this.mUsers.get(profileId).info;
        if (fullInfo == true) goto L8;
        UserInfo userInfo2 = new UserInfo(userInfo);
        userInfo2.name = null;
        userInfo2.iconPath = null;
    L9:
        users.add(userInfo2);
        i = i + 1;
        goto L4
    L8:
        userInfo2 = userWithName(userInfo);
        goto L9
    L11:
        return users;
    }

    private IntArray getProfileIdsLU(int userId, String userType, boolean enabledOnly, boolean excludeHidden) {
        UserInfo user = getUserInfoLU(userId);
        IntArray result = new IntArray(this.mUsers.size());
        if (user != null) goto L5;
        return result;
    L5:
        int userSize = this.mUsers.size();
        int i = 0;
    L6:
        if (i >= userSize) goto L31;
        UserInfo profile = this.mUsers.valueAt(i).info;
        if (isSameProfileGroup(user, profile) == false) goto L29;
        if (enabledOnly == false) goto L15;
        if (profile.isEnabled() == false) goto L29;
    L15:
        if (this.mRemovingUserIds.get(profile.id) == true) goto L29;
        if (profile.partial == true) goto L29;
        if (userType != null) goto L22;
    L24:
        if (excludeHidden == true) goto L26;
    L28:
        result.add(profile.id);
        goto L29
    L26:
        if (isProfileHidden(profile.id) == false) goto L28;
    L22:
        if (userType.equals(profile.userType) == true) goto L24;
    L29:
        i = i + 1;
        goto L6
    L31:
        return result;
    }

    public int[] getProfileIdsExcludingHidden(int userId, boolean enabledOnly) {
        return getProfileIds(userId, null, enabledOnly, true);
    }

    private boolean isProfileHidden(int userId) {
        if (getUserPropertiesInternal(userId).getProfileApiVisibility() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getCredentialOwnerProfile(int userId) {
        checkManageUsersPermission("get the credential owner");
        long identity = Binder.clearCallingIdentity();
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L4:
        if (this.mLockPatternUtils.isSeparateProfileChallengeEnabled(userId) == true) goto L22;
        Object r2 = this.mUsersLock;     // Catch: Throwable -> L20
        monitor-enter(r2);     // Catch: Throwable -> L20
        UserInfo profileParent = getProfileParentLU(userId);     // Catch: Throwable -> L13
        if (profileParent == null) goto L16;
        int r4 = profileParent.id;     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(identity);
        return r4;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L22:
        Binder.restoreCallingIdentity(identity);
        return userId;
    }

    public boolean isSameProfileGroup(int userId, int otherUserId) {
        if (userId != otherUserId) goto L5;
        return true;
    L5:
        checkQueryUsersPermission("check if in the same profile group");
        return isSameProfileGroupNoChecks(userId, otherUserId);
    }

    private boolean isSameProfileGroupNoChecks(int userId, int otherUserId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L8
        if (userInfo != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        UserInfo otherUserInfo = getUserInfoLU(otherUserId);     // Catch: Throwable -> L8
        if (otherUserInfo != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L14:
        boolean r2 = isSameProfileGroup(userInfo, otherUserInfo);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isSameUserOrProfileGroupOrTargetIsCommunal(UserInfo asker, UserInfo target) {
        if (asker.id != target.id) goto L6;
        return true;
    L6:
        if (asker.profileGroupId != (-10000)) goto L8;
    L10:
        return false;
    L8:
        if (asker.profileGroupId != target.profileGroupId) goto L10;
        return true;
    }

    public UserInfo getProfileParent(int userId) {
        if (hasManageUsersOrPermission("android.permission.INTERACT_ACROSS_USERS") == false) goto L13;
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo r1 = getProfileParentLU(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new SecurityException("You need MANAGE_USERS or INTERACT_ACROSS_USERS permission to get the profile parent");
    }

    public int getProfileParentId(int userId) {
        checkManageUsersPermission("get the profile parent");
        return getProfileParentIdUnchecked(userId);
    }

    private int getProfileParentIdUnchecked(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo profileParent = getProfileParentLU(userId);     // Catch: Throwable -> L8
        if (profileParent != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return userId;
    L10:
        int r2 = profileParent.id;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private UserInfo getProfileParentLU(int userId) {
        UserInfo profile = getUserInfoLU(userId);
        if (profile != null) goto L5;
        return null;
    L5:
        int parentUserId = profile.profileGroupId;
        if (parentUserId != userId) goto L8;
    L12:
        return null;
    L8:
        if (parentUserId == (-10000)) goto L12;
        return getUserInfoLU(parentUserId);
    }

    private static boolean isSameProfileGroup(UserInfo user1, UserInfo user2) {
        if (user1.id != user2.id) goto L5;
    L10:
        return true;
    L5:
        if (user1.profileGroupId != (-10000)) goto L7;
    L9:
        return false;
    L7:
        if (user1.profileGroupId != user2.profileGroupId) goto L9;
        goto L9
    }

    private String getAvailabilityIntentAction(boolean enableQuietMode, boolean useManagedActions) {
        if (useManagedActions == false) goto L6;
        if (enableQuietMode == false) goto L5;
        return "android.intent.action.MANAGED_PROFILE_UNAVAILABLE";
    L5:
        return "android.intent.action.MANAGED_PROFILE_AVAILABLE";
    L6:
        if (enableQuietMode == false) goto L8;
        return "android.intent.action.PROFILE_UNAVAILABLE";
    L8:
        return "android.intent.action.PROFILE_AVAILABLE";
    }

    private void broadcastProfileAvailabilityChanges(UserInfo profileInfo, UserHandle parentHandle, boolean enableQuietMode, boolean useManagedActions) {
        Intent availabilityIntent = new Intent();
        availabilityIntent.setAction(getAvailabilityIntentAction(enableQuietMode, useManagedActions));
        availabilityIntent.putExtra("android.intent.extra.QUIET_MODE", enableQuietMode);
        availabilityIntent.putExtra("android.intent.extra.USER", profileInfo.getUserHandle());
        availabilityIntent.putExtra("android.intent.extra.user_handle", profileInfo.getUserHandle().getIdentifier());
        if (profileInfo.isManagedProfile() == false) goto L5;
        getDevicePolicyManagerInternal().broadcastIntentToManifestReceivers(availabilityIntent, parentHandle, true);
    L5:
        availabilityIntent.addFlags(1342177280);
        BroadcastOptions r1 = new BroadcastOptions().setDeferralPolicy(2).setDeliveryGroupPolicy(1);
        if (useManagedActions == false) goto L8;
        String r2 = "android.intent.action.MANAGED_PROFILE_AVAILABLE";
    L9:
        Bundle options = r1.setDeliveryGroupMatchingKey(r2, String.valueOf(profileInfo.getUserHandle().getIdentifier())).toBundle();
        this.mContext.sendBroadcastAsUser(availabilityIntent, parentHandle, null, options);
        return;
    L8:
        r2 = "android.intent.action.PROFILE_AVAILABLE";
        goto L9
    }

    public boolean requestQuietModeEnabled(String callingPackage, boolean enableQuietMode, int userId, IntentSender target, int flags) {
        callingPackage.getClass();
        if (enableQuietMode == false) goto L9;
        if (target == null) goto L9;
        throw new IllegalArgumentException("target should only be specified when we are disabling quiet mode.");
    L9:
        if ((flags & 2) == 0) goto L11;
        boolean dontAskCredential = true;
    L13:
        if ((flags & 1) == 0) goto L15;
        boolean r0 = true;
    L16:
        boolean onlyIfCredentialNotRequired = r0;
        if (dontAskCredential == false) goto L22;
        if (onlyIfCredentialNotRequired == false) goto L22;
        throw new IllegalArgumentException("invalid flags: " + flags);
    L22:
        int r3 = Binder.getCallingUid();
        if (target == null) goto L25;
        boolean r5 = true;
    L26:
        ensureCanModifyQuietMode(callingPackage, r3, userId, r5, dontAskCredential);
        if (onlyIfCredentialNotRequired == true) goto L29;
    L33:
        long identity = Binder.clearCallingIdentity();
        if (dontAskCredential == true) goto L109;
    L52:
        if (enableQuietMode == false) goto L57;
        setQuietModeEnabled(userId, true, target, callingPackage);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(identity);
        return true;
    L57:
        UserProperties userProperties = getUserPropertiesInternal(userId);     // Catch: Throwable -> L45
        if (userProperties == null) goto L82;
        if (userProperties.isAuthAlwaysRequiredToDisableQuietMode() == false) goto L82;
        if (onlyIfCredentialNotRequired == false) goto L64;
        Binder.restoreCallingIdentity(identity);
        return false;
    L64:
        KeyguardManager km = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);     // Catch: Throwable -> L45
        int parentUserId = getProfileParentId(userId);     // Catch: Throwable -> L45
        if (km != null) goto L67;
    L71:
        if (km != null) goto L73;
    L79:
        Slog.w(LOG_TAG, "Allowing profile unlock even when device credentials are not set for user " + userId);     // Catch: Throwable -> L45
        goto L82
    L73:
        if (km.isDeviceSecure(parentUserId) == true) goto L79;
        if (android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 0, userId) != 1) goto L79;
        Intent setScreenLockPromptIntent = SetScreenLockDialogActivity.createBaseIntent(1);     // Catch: Throwable -> L45
        setScreenLockPromptIntent.putExtra("origin_user_id", userId);     // Catch: Throwable -> L45
        this.mContext.startActivityAsUser(setScreenLockPromptIntent, UserHandle.of(parentUserId));     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(identity);
        return false;
    L67:
        if (km.isDeviceSecure(parentUserId) == false) goto L71;
        showConfirmCredentialToDisableQuietMode(userId, target, callingPackage);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(identity);
        return false;
    L82:
        boolean hasUnifiedChallenge = this.mLockPatternUtils.isManagedProfileWithUnifiedChallenge(userId);     // Catch: Throwable -> L45
        if (hasUnifiedChallenge == true) goto L85;
    L88:
        if (dontAskCredential == false) goto L90;
    L95:
        boolean needToShowConfirmCredential = false;
    L97:
        if (needToShowConfirmCredential == false) goto L104;
        if (onlyIfCredentialNotRequired == false) goto L101;
        Binder.restoreCallingIdentity(identity);
        return false;
    L101:
        showConfirmCredentialToDisableQuietMode(userId, target, callingPackage);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(identity);
        return false;
    L104:
        setQuietModeEnabled(userId, false, target, callingPackage);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(identity);
        return r9;
    L90:
        if (this.mLockPatternUtils.isSecure(userId) == false) goto L95;
        if (hasUnifiedChallenge == true) goto L93;
    L94:
        needToShowConfirmCredential = true;
        goto L97
    L93:
        if (StorageManager.isCeStorageUnlocked(userId) == true) goto L95;
    L85:
        if (((KeyguardManager) this.mContext.getSystemService(KeyguardManager.class)).isDeviceLocked(this.mLocalService.getProfileParentId(userId)) == false) goto L87;
        if (onlyIfCredentialNotRequired == false) goto L88;
    L87:
        this.mLockPatternUtils.tryUnlockWithCachedUnifiedChallenge(userId);     // Catch: Throwable -> L45
        goto L88
    L109:
        Object r4 = this.mUsersLock;     // Catch: Throwable -> L45
        monitor-enter(r4);     // Catch: Throwable -> L45
        UserInfo userInfo = getUserInfo(userId);     // Catch: Throwable -> L49
        monitor-exit(r4);     // Catch: Throwable -> L49
        if (userInfo == null) goto L48;
        if (userInfo.isManagedProfile() == true) goto L52;
        throw new IllegalArgumentException("Invalid flags: " + flags + ". Can't skip credential check for the user");     // Catch: Throwable -> L45
    L48:
        throw new IllegalArgumentException("Invalid user. Can't find user details for userId " + userId);     // Catch: Throwable -> L45
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L29:
        if (callingPackage.equals(getPackageManagerInternal().getSystemUiServiceComponent().getPackageName()) == false) goto L33;
        throw new SecurityException("SystemUI is not allowed to set QUIET_MODE_DISABLE_ONLY_IF_CREDENTIAL_NOT_REQUIRED");
    L25:
        r5 = false;
        goto L26
    L15:
        r0 = false;
        goto L16
    L11:
        dontAskCredential = false;
        goto L13
    }

    private void ensureCanModifyQuietMode(String callingPackage, int callingUid, int targetUserId, boolean startIntent, boolean dontAskCredential) {
        verifyCallingPackage(callingPackage, callingUid);
        if (hasManageUsersPermission() == false) goto L5;
        return;
    L5:
        if (startIntent == true) goto L24;
        if (dontAskCredential == true) goto L22;
        if (isSameProfileGroupNoChecks(UserHandle.getUserId(callingUid), targetUserId) == false) goto L20;
        boolean hasModifyQuietModePermission = hasPermissionGranted("android.permission.MODIFY_QUIET_MODE", callingUid);
        if (hasModifyQuietModePermission == false) goto L12;
        return;
    L12:
        ShortcutServiceInternal shortcutInternal = (ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class);
        if (shortcutInternal == null) goto L18;
        boolean isForegroundLauncher = shortcutInternal.isForegroundDefaultLauncher(callingPackage, callingUid);
        if (isForegroundLauncher == false) goto L18;
        return;
    L18:
        throw new SecurityException("Can't modify quiet mode, caller is neither foreground default launcher nor has MANAGE_USERS/MODIFY_QUIET_MODE permission");
    L20:
        throw new SecurityException("MANAGE_USERS permission is required to modify quiet mode for a different profile group.");
    L22:
        throw new SecurityException("MANAGE_USERS permission is required to disable quiet mode without credentials.");
    L24:
        throw new SecurityException("MANAGE_USERS permission is required to start intent after disabling quiet mode.");
    }

    private void setQuietModeEnabled(int userId, boolean enableQuietMode, IntentSender target, String callingPackage) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo profile = getUserInfoLU(userId);     // Catch: Throwable -> L13
        UserInfo parent = getProfileParentLU(userId);     // Catch: Throwable -> L13
        if (profile == null) goto L39;
        if (profile.isProfile() == false) goto L39;
        if (profile.isQuietModeEnabled() != enableQuietMode) goto L15;
        Slog.i(LOG_TAG, "Quiet mode is already " + enableQuietMode);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        UserManager.invalidateQuietModeEnabledCache();     // Catch: Throwable -> L13
        profile.flags ^= 128;     // Catch: Throwable -> L13
        UserData profileUserData = getUserDataLU(profile.id);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        Object r4 = this.mPackagesLock;
        monitor-enter(r4);
        writeUserLP(profileUserData);     // Catch: Throwable -> L35
        monitor-exit(r4);     // Catch: Throwable -> L35
        if (enableQuietMode == false) goto L25;
        stopUserForQuietMode(userId);     // Catch: RemoteException -> L23
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).killForegroundAppsForUser(userId);     // Catch: RemoteException -> L23
    L31:
        logQuietModeEnabled(userId, enableQuietMode, callingPackage);
        broadcastProfileAvailabilityChanges(profile, parent.getUserHandle(), enableQuietMode, false);
        if (profile.isManagedProfile() == false) goto L46;
        broadcastProfileAvailabilityChanges(profile, parent.getUserHandle(), enableQuietMode, true);
        return;
    L46:
        return;
    L25:
        if (target == null) goto L27;
        DisableQuietModeUserUnlockedCallback r1 = new DisableQuietModeUserUnlockedCallback(this, target);     // Catch: RemoteException -> L23
    L28:
        ActivityManager.getService().startProfileWithListener(userId, r1);     // Catch: RemoteException -> L23
        goto L31
    L27:
        r1 = null;
    L23:
        e = move-exception;
        e.rethrowAsRuntimeException();
    L35:
        th = move-exception;
        throw th;
    L39:
        throw new IllegalArgumentException("User " + userId + " is not a profile");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void stopUserForQuietMode(int userId) throws RemoteException {
        ActivityManager.getService().stopUserWithDelayedLocking(userId, null);
    }

    private void logQuietModeEnabled(int userId, boolean enableQuietMode, String callingPackage) {
        Slogf.i(LOG_TAG, "requestQuietModeEnabled called by package %s, with enableQuietMode %b.", new Object[]{callingPackage, Boolean.valueOf(enableQuietMode)});
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (userData != null) goto L8;
        return;
    L8:
        long now = System.currentTimeMillis();
        if (userData.getLastRequestQuietModeEnabledMillis() == 0) goto L11;
        long period = now - userData.getLastRequestQuietModeEnabledMillis();
    L12:
        DevicePolicyEventLogger.createEvent(55).setInt(UserJourneyLogger.getUserTypeForStatsd(userData.info.userType)).setStrings(new String[]{callingPackage}).setBoolean(enableQuietMode).setTimePeriod(period).write();
        userData.setLastRequestQuietModeEnabledMillis(now);
        return;
    L11:
        period = now - userData.info.creationTime;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean isQuietModeEnabled(int userId) {
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        Object r1 = this.mUsersLock;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        UserInfo info = getUserInfoLU(userId);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        if (info == null) goto L17;
        if (info.isProfile() == false) goto L17;
        boolean r2 = info.isQuietModeEnabled();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r2;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private void showConfirmCredentialToDisableQuietMode(int userId, IntentSender target, String callingPackage) {
        if (getUserInfo(userId).isManagedProfile() == false) goto L14;
        WatchedUserStates r0 = this.mUserStates;
        monitor-enter(r0);
        int state = this.mUserStates.get(userId, -1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (state == (-1)) goto L14;
        Slog.i(LOG_TAG, "showConfirmCredentialToDisableQuietMode() called too early, managed user " + userId + " is still alive.");
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        KeyguardManager km = (KeyguardManager) this.mContext.getSystemService("keyguard");
        Intent unlockIntent = km.createConfirmDeviceCredentialIntent(null, null, userId);
        if (unlockIntent != null) goto L17;
        return;
    L17:
        Intent callBackIntent = new Intent("com.android.server.pm.DISABLE_QUIET_MODE_AFTER_UNLOCK");
        if (target == null) goto L20;
        callBackIntent.putExtra("android.intent.extra.INTENT", target);
    L20:
        callBackIntent.putExtra("android.intent.extra.USER_ID", userId);
        callBackIntent.setPackage(this.mContext.getPackageName());
        callBackIntent.putExtra("android.intent.extra.PACKAGE_NAME", callingPackage);
        callBackIntent.addFlags(268435456);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, 0, callBackIntent, 1409286144);
        unlockIntent.putExtra("android.intent.extra.INTENT", pendingIntent.getIntentSender());
        unlockIntent.setFlags(276824064);
        if (getUserInfo(userId).isPrivateProfile() == false) goto L23;
        unlockIntent.putExtra(CUSTOM_BIOMETRIC_PROMPT_LOGO_RES_ID_KEY, 17305218);
        unlockIntent.putExtra(CUSTOM_BIOMETRIC_PROMPT_LOGO_DESCRIPTION_KEY, this.mContext.getString(R.string.serviceClassDataSync));
    L23:
        this.mContext.startActivityAsUser(unlockIntent, UserHandle.of(getProfileParentIdUnchecked(userId)));
    }

    public void setUserEnabled(int userId) {
        checkManageUsersPermission("enable user");
        boolean wasUserDisabled = false;
        Object r1 = this.mPackagesLock;
        monitor-enter(r1);
        Object r2 = this.mUsersLock;     // Catch: Throwable -> L21
        monitor-enter(r2);     // Catch: Throwable -> L21
        UserInfo info = getUserInfoLU(userId);     // Catch: Throwable -> L11
        if (info != null) goto L9;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L21
        if (wasUserDisabled == false) goto L30;
        if (info != null) goto L18;
        return;
    L18:
        if (info.isProfile() == false) goto L32;
        sendProfileAddedBroadcast(info.profileGroupId, info.id);
        return;
    L32:
        return;
    L30:
        return;
    L9:
        if (info.isEnabled() == true) goto L13;
        wasUserDisabled = true;
        removeUserInfoFlags(info, 64);     // Catch: Throwable -> L11
        writeUserLP(getUserDataLU(info.id));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private void addUserInfoFlags(UserInfo userInfo, int flags) {
        int diff = (~userInfo.flags) & flags;
        if (diff <= 0) goto L6;
        userInfo.flags |= diff;
        UserManager.invalidateOnUserInfoFlagChange(diff);
        return;
    }

    private void removeUserInfoFlags(UserInfo userInfo, int flags) {
        int diff = userInfo.flags & flags;
        if (diff <= 0) goto L6;
        userInfo.flags ^= diff;
        UserManager.invalidateOnUserInfoFlagChange(diff);
        return;
    }

    public void setUserAdmin(int userId) {
        checkManageUserAndAcrossUsersFullPermission("set user admin");
        checkAdminStatusChangeAllowed(userId);
        this.mUserJourneyLogger.logUserJourneyBegin(userId, 7);
        Object r2 = this.mPackagesLock;
        monitor-enter(r2);
        Object r3 = this.mUsersLock;     // Catch: Throwable -> L34
        monitor-enter(r3);     // Catch: Throwable -> L34
        UserData user = getUserDataLU(userId);     // Catch: Throwable -> L18
        if (user != null) goto L22;
        this.mUserJourneyLogger.logNullUserJourneyError(7, getCurrentUserId(), userId, "", -1);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L22:
        if (user.info.isAdmin() == false) goto L27;
        this.mUserJourneyLogger.logUserJourneyFinishWithError(getCurrentUserId(), user.info, 7, 5);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L27:
        user.info.flags ^= 2;     // Catch: Throwable -> L16
        writeUserLP(user);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        this.mUserJourneyLogger.logUserJourneyFinishWithError(getCurrentUserId(), user.info, 7, -1);
        return;
    L18:
        th = move-exception;
        Throwable r11 = th;
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L16
        throw r11;     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        r11 = th;
    L34:
        th = move-exception;
        Throwable r12 = th;
    L36:
        monitor-exit(r2);     // Catch: Throwable -> L14
        throw r12;
    L14:
        th = move-exception;
        r12 = th;
        goto L36
    }

    public void revokeUserAdmin(int userId) {
        checkManageUserAndAcrossUsersFullPermission("revoke admin privileges");
        checkAdminStatusChangeAllowed(userId);
        this.mUserJourneyLogger.logUserJourneyBegin(userId, 8);
        Object r2 = this.mPackagesLock;
        monitor-enter(r2);
        Object r3 = this.mUsersLock;     // Catch: Throwable -> L34
        monitor-enter(r3);     // Catch: Throwable -> L34
        UserData user = getUserDataLU(userId);     // Catch: Throwable -> L18
        if (user != null) goto L22;
        this.mUserJourneyLogger.logNullUserJourneyError(8, getCurrentUserId(), userId, "", -1);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L22:
        if (user.info.isAdmin() == true) goto L27;
        this.mUserJourneyLogger.logUserJourneyFinishWithError(getCurrentUserId(), user.info, 8, 6);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L27:
        user.info.flags ^= 2;     // Catch: Throwable -> L16
        writeUserLP(user);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        this.mUserJourneyLogger.logUserJourneyFinishWithError(getCurrentUserId(), user.info, 8, -1);
        return;
    L18:
        th = move-exception;
        Throwable r11 = th;
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L16
        throw r11;     // Catch: Throwable -> L14
    L16:
        th = move-exception;
        r11 = th;
    L34:
        th = move-exception;
        Throwable r12 = th;
    L36:
        monitor-exit(r2);     // Catch: Throwable -> L14
        throw r12;
    L14:
        th = move-exception;
        r12 = th;
        goto L36
    }

    public void evictCredentialEncryptionKey(int userId) {
        checkManageUsersPermission("evict CE key");
        IActivityManager am = ActivityManagerNative.getDefault();
        long identity = Binder.clearCallingIdentity();
        if (isProfileUnchecked(userId) == false) goto L5;
        int userStartMode = 3;
    L17:
        am.restartUserInBackground(userId, userStartMode);     // Catch: Throwable -> L10 RemoteException -> L12
        Binder.restoreCallingIdentity(identity);
        return;
    L12:
        re = move-exception;
        throw re.rethrowAsRuntimeException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        userStartMode = 2;
        goto L17
    }

    public boolean isUserOfType(int userId, String userType) {
        checkQueryOrCreateUsersPermission("check user type");
        if (userType != null) goto L5;
    L7:
        return false;
    L5:
        if (userType.equals(getUserTypeNoChecks(userId)) == false) goto L7;
        return true;
    }

    private String getUserTypeNoChecks(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L7
        if (userInfo == null) goto L9;
        String r2 = userInfo.userType;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private UserTypeDetails getUserTypeDetailsNoChecks(int userId) {
        String typeStr = getUserTypeNoChecks(userId);
        if (typeStr != null) goto L7;
        return null;
    L7:
        return this.mUserTypes.get(typeStr);
    }

    private UserTypeDetails getUserTypeDetails(UserInfo userInfo) {
        if (userInfo == null) goto L5;
        String typeStr = userInfo.userType;
    L6:
        if (typeStr != null) goto L8;
        return null;
    L8:
        return this.mUserTypes.get(typeStr);
    L5:
        typeStr = null;
        goto L6
    }

    public UserInfo getUserInfo(int userId) {
        checkQueryOrCreateUsersPermission("query user");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo r1 = userWithName(getUserInfoLU(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private UserInfo userWithName(UserInfo orig) {
        if (orig != null) goto L4;
    L17:
        return orig;
    L4:
        if (orig.name != null) goto L17;
        String name = null;
        if (orig.id != 0) goto L9;
        name = getOwnerName();
    L14:
        if (name == null) goto L17;
        UserInfo withName = new UserInfo(orig);
        withName.name = name;
        return withName;
    L9:
        if (orig.isMain() == false) goto L12;
        name = getOwnerName();
        goto L14
    L12:
        if (orig.isGuest() == false) goto L14;
        name = getGuestName();
        goto L14
    }

    boolean isUserTypeSubtypeOfFull(String userType) {
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (userTypeDetails.isFull() == false) goto L7;
        return true;
    }

    boolean isUserTypeSubtypeOfProfile(String userType) {
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (userTypeDetails.isProfile() == false) goto L7;
        return true;
    }

    boolean isUserTypeSubtypeOfSystem(String userType) {
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (userTypeDetails.isSystem() == false) goto L7;
        return true;
    }

    public UserProperties getUserPropertiesCopy(int userId) {
        checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserProperties");
        UserProperties origProperties = getUserPropertiesInternal(userId);
        if (origProperties == null) goto L11;
        if (Binder.getCallingUid() != 1000) goto L7;
        boolean exposeAllFields = true;
    L8:
        boolean hasManage = hasManageUsersPermission();
        boolean hasQuery = hasQueryUsersPermission();
        return new UserProperties(origProperties, exposeAllFields, hasManage, hasQuery);
    L7:
        exposeAllFields = false;
        goto L8
    L11:
        throw new IllegalArgumentException("Cannot access properties for user " + userId);
    }

    private UserProperties getUserPropertiesInternal(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L9
        if (userData == null) goto L12;
        UserProperties r2 = userData.userProperties;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean hasBadge(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "hasBadge");
        UserTypeDetails userTypeDetails = getUserTypeDetailsNoChecks(userId);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (userTypeDetails.hasBadge() == false) goto L7;
        return true;
    }

    public int getUserBadgeLabelResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserBadgeLabelResId");
        UserInfo userInfo = getUserInfoNoChecks(userId);
        UserTypeDetails userTypeDetails = getUserTypeDetails(userInfo);
        if (userInfo == null) goto L10;
        if (userTypeDetails == null) goto L10;
        if (userTypeDetails.hasBadge() == false) goto L10;
        int badgeIndex = userInfo.profileBadge;
        return userTypeDetails.getBadgeLabel(badgeIndex);
    L10:
        Slog.e(LOG_TAG, "Requested badge label for non-badged user " + userId);
        return 0;
    }

    public int getUserBadgeColorResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserBadgeColorResId");
        UserInfo userInfo = getUserInfoNoChecks(userId);
        UserTypeDetails userTypeDetails = getUserTypeDetails(userInfo);
        if (userInfo == null) goto L10;
        if (userTypeDetails == null) goto L10;
        if (userTypeDetails.hasBadge() == false) goto L10;
        return userTypeDetails.getBadgeColor(userInfo.profileBadge);
    L10:
        Slog.e(LOG_TAG, "Requested badge dark color for non-badged user " + userId);
        return 0;
    }

    public int getUserBadgeDarkColorResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserBadgeDarkColorResId");
        UserInfo userInfo = getUserInfoNoChecks(userId);
        UserTypeDetails userTypeDetails = getUserTypeDetails(userInfo);
        if (userInfo == null) goto L10;
        if (userTypeDetails == null) goto L10;
        if (userTypeDetails.hasBadge() == false) goto L10;
        return userTypeDetails.getDarkThemeBadgeColor(userInfo.profileBadge);
    L10:
        Slog.e(LOG_TAG, "Requested badge color for non-badged user " + userId);
        return 0;
    }

    public int getUserIconBadgeResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserIconBadgeResId");
        UserTypeDetails userTypeDetails = getUserTypeDetailsNoChecks(userId);
        if (userTypeDetails != null) goto L5;
    L9:
        Slog.e(LOG_TAG, "Requested icon badge for non-badged user " + userId);
        return 0;
    L5:
        if (userTypeDetails.hasBadge() == false) goto L9;
        return userTypeDetails.getIconBadge();
    }

    public int getUserBadgeResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserBadgeResId");
        UserTypeDetails userTypeDetails = getUserTypeDetailsNoChecks(userId);
        if (userTypeDetails != null) goto L5;
    L9:
        Slog.e(LOG_TAG, "Requested badge for non-badged user " + userId);
        return 0;
    L5:
        if (userTypeDetails.hasBadge() == false) goto L9;
        return userTypeDetails.getBadgePlain();
    }

    public int getUserBadgeNoBackgroundResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserBadgeNoBackgroundResId");
        UserTypeDetails userTypeDetails = getUserTypeDetailsNoChecks(userId);
        if (userTypeDetails != null) goto L5;
    L9:
        Slog.e(LOG_TAG, "Requested badge (no background) for non-badged user " + userId);
        return 0;
    L5:
        if (userTypeDetails.hasBadge() == false) goto L9;
        return userTypeDetails.getBadgeNoBackground();
    }

    public int getUserStatusBarIconResId(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserStatusBarIconResId");
        UserTypeDetails userTypeDetails = getUserTypeDetailsNoChecks(userId);
        if (userTypeDetails != null) goto L5;
    L9:
        Slog.w(LOG_TAG, "Requested status bar icon for non-badged user " + userId);
        return 0;
    L5:
        if (userTypeDetails.hasBadge() == false) goto L9;
        return userTypeDetails.getStatusBarIcon();
    }

    public int getProfileLabelResId(int userId) {
        checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getProfileLabelResId");
        UserInfo userInfo = getUserInfoNoChecks(userId);
        UserTypeDetails userTypeDetails = getUserTypeDetails(userInfo);
        if (userInfo == null) goto L8;
        if (userTypeDetails == null) goto L10;
        int userIndex = userInfo.profileBadge;
        return userTypeDetails.getLabel(userIndex);
    L10:
        return 0;
    L8:
        return 0;
    }

    public int getProfileAccessibilityLabelResId(int userId) {
        checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getProfileAccessibilityLabelResId");
        UserInfo userInfo = getUserInfoNoChecks(userId);
        UserTypeDetails userTypeDetails = getUserTypeDetails(userInfo);
        if (userInfo == null) goto L8;
        if (userTypeDetails != null) goto L7;
        return 0;
    L7:
        return userTypeDetails.getAccessibilityString();
    L8:
        return 0;
    }

    public boolean isProfile(int userId) {
        checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(userId, "isProfile");
        return isProfileUnchecked(userId);
    }

    private boolean isProfileUnchecked(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L9
        if (userInfo != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (userInfo.isProfile() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public String getProfileType(int userId) {
        checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getProfileType");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L9
        if (userInfo != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L7:
        if (userInfo.isProfile() == false) goto L11;
        String r2 = userInfo.userType;     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        r2 = "";
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isUserUnlockingOrUnlocked(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "isUserUnlockingOrUnlocked");
        return this.mLocalService.isUserUnlockingOrUnlocked(userId);
    }

    public boolean isUserUnlocked(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "isUserUnlocked");
        return this.mLocalService.isUserUnlocked(userId);
    }

    public boolean isUserRunning(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "isUserRunning");
        return this.mLocalService.isUserRunning(userId);
    }

    public boolean isUserForeground(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId == userId) goto L10;
        if (hasManageUsersOrPermission("android.permission.INTERACT_ACROSS_USERS") == true) goto L10;
        throw new SecurityException("Caller from user " + callingUserId + " needs MANAGE_USERS or INTERACT_ACROSS_USERS permission to check if another user (" + userId + ") is running in the foreground");
    L10:
        if (userId != getCurrentUserId()) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isUserVisible(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId == userId) goto L10;
        if (hasManageUsersOrPermission("android.permission.INTERACT_ACROSS_USERS") == true) goto L10;
        throw new SecurityException("Caller from user " + callingUserId + " needs MANAGE_USERS or INTERACT_ACROSS_USERS permission to check if another user (" + userId + ") is visible");
    L10:
        return this.mUserVisibilityMediator.isUserVisible(userId);
    }

    public static void enforceCurrentUserIfVisibleBackgroundEnabled() {
        if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L5;
        return;
    L5:
        int callingUserId = UserHandle.getCallingUserId();
        long ident = Binder.clearCallingIdentity();
        int currentUserId = ActivityManager.getCurrentUser();     // Catch: Throwable -> L14
        if (callingUserId == 0) goto L16;
        if (callingUserId == currentUserId) goto L16;
        if (getInstance().isSameProfileGroup(callingUserId, currentUserId) == true) goto L16;
        throw new SecurityException("Invalid calling user on devices that enable visible background users. callingUserId=" + callingUserId + " currentUserId=" + currentUserId);     // Catch: Throwable -> L14
    L16:
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    Pair<Integer, Integer> getCurrentAndTargetUserIds() {
        ActivityManagerInternal activityManagerInternal = getActivityManagerInternal();
        if (activityManagerInternal != null) goto L7;
        Slog.w(LOG_TAG, "getCurrentAndTargetUserId() called too early, ActivityManagerInternal is not set yet");
        return new Pair(Integer.valueOf(ProcessList.INVALID_ADJ), Integer.valueOf(ProcessList.INVALID_ADJ));
    L7:
        return activityManagerInternal.getCurrentAndTargetUserIds();
    }

    int getCurrentUserId() {
        ActivityManagerInternal activityManagerInternal = getActivityManagerInternal();
        if (activityManagerInternal != null) goto L7;
        Slog.w(LOG_TAG, "getCurrentUserId() called too early, ActivityManagerInternal is not set yet");
        return ProcessList.INVALID_ADJ;
    L7:
        return activityManagerInternal.getCurrentUserId();
    }

    boolean isCurrentUserOrRunningProfileOfCurrentUser(int userId) {
        int currentUserId = getCurrentUserId();
        if (currentUserId != userId) goto L7;
        return true;
    L7:
        if (isProfileUnchecked(userId) == false) goto L12;
        int parentId = getProfileParentIdUnchecked(userId);
        if (parentId == currentUserId) goto L11;
        return false;
    L11:
        return isUserRunning(userId);
    L12:
        return false;
    }

    boolean isUserVisibleOnDisplay(int userId, int displayId) {
        return this.mUserVisibilityMediator.isUserVisible(userId, displayId);
    }

    public int[] getVisibleUsers() {
        if (hasManageUsersOrPermission("android.permission.INTERACT_ACROSS_USERS") == false) goto L12;
        long ident = Binder.clearCallingIdentity();
        int[] r2 = this.mUserVisibilityMediator.getVisibleUsers().toArray();     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);
        return r2;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L12:
        throw new SecurityException("Caller needs MANAGE_USERS or INTERACT_ACROSS_USERS permission to get list of visible users");
    }

    public int getMainDisplayIdAssignedToUser(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId == userId) goto L10;
        if (hasManageUsersOrPermission("android.permission.INTERACT_ACROSS_USERS") == true) goto L10;
        throw new SecurityException("Caller from user " + callingUserId + " needs MANAGE_USERS or INTERACT_ACROSS_USERS permission to get the main display for (" + userId + ")");
    L10:
        return this.mUserVisibilityMediator.getMainDisplayAssignedToUser(userId);
    }

    public boolean isForegroundUserAdmin() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int currentUserId = getCurrentUserId();     // Catch: Throwable -> L11
        boolean r3 = false;
        if (currentUserId == (-10000)) goto L16;
        UserInfo userInfo = getUserInfoLU(currentUserId);     // Catch: Throwable -> L11
        if (userInfo != null) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L9:
        if (userInfo.isAdmin() == false) goto L13;
        r3 = true;
        goto L13
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public String getUserName() {
        int callingUid = Binder.getCallingUid();
        if (hasQueryOrCreateUsersPermission() == false) goto L5;
    L9:
        int userId = UserHandle.getUserId(callingUid);
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
        UserInfo userInfo = userWithName(getUserInfoLU(userId));     // Catch: Throwable -> L18
        if (userInfo == null) goto L21;
        if (userInfo.name == null) goto L21;
        String r4 = userInfo.name;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r4;
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return "";
    L18:
        th = move-exception;
        throw th;
    L5:
        if (hasPermissionGranted("android.permission.GET_ACCOUNTS_PRIVILEGED", callingUid) == true) goto L9;
        throw new SecurityException("You need MANAGE_USERS, CREATE_USERS, QUERY_USERS, or GET_ACCOUNTS_PRIVILEGED permissions to: get user name");
    }

    public long getUserStartRealtime() {
        int userId = UserHandle.getUserId(Binder.getCallingUid());
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        UserData user = getUserDataLU(userId);     // Catch: Throwable -> L9
        if (user == null) goto L11;
        long r3 = user.startRealtime;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r3;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public long getUserUnlockRealtime() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData user = getUserDataLU(UserHandle.getUserId(Binder.getCallingUid()));     // Catch: Throwable -> L9
        if (user == null) goto L11;
        long r2 = user.unlockRealtime;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    private void checkManageOrInteractPermissionIfCallerInOtherProfileGroup(int userId, String name) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != userId) goto L5;
        return;
    L5:
        if (isSameProfileGroupNoChecks(callingUserId, userId) == false) goto L8;
        return;
    L8:
        if (hasManageUsersPermission() == false) goto L11;
        return;
    L11:
        if (hasPermissionGranted("android.permission.INTERACT_ACROSS_USERS", Binder.getCallingUid()) == false) goto L14;
        return;
    L14:
        throw new SecurityException("You need INTERACT_ACROSS_USERS or MANAGE_USERS permission to: check " + name);
    }

    private void checkQueryOrInteractPermissionIfCallerInOtherProfileGroup(int userId, String name) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != userId) goto L5;
        return;
    L5:
        if (isSameProfileGroupNoChecks(callingUserId, userId) == false) goto L8;
        return;
    L8:
        if (hasQueryUsersPermission() == false) goto L11;
        return;
    L11:
        if (hasPermissionGranted("android.permission.INTERACT_ACROSS_USERS", Binder.getCallingUid()) == false) goto L14;
        return;
    L14:
        throw new SecurityException("You need INTERACT_ACROSS_USERS, MANAGE_USERS, or QUERY_USERS permission to: check " + name);
    }

    private void checkQueryOrCreateUsersPermissionIfCallerInOtherProfileGroup(int userId, String name) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != userId) goto L5;
        return;
    L5:
        if (isSameProfileGroupNoChecks(callingUserId, userId) == true) goto L10;
        checkQueryOrCreateUsersPermission(name);
        return;
    }

    public boolean isDemoUser(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != userId) goto L5;
    L9:
        boolean r2 = false;
        if (SystemProperties.getBoolean("ro.boot.arc_demo_mode", false) == false) goto L12;
        return true;
    L12:
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L19
        if (userInfo != null) goto L17;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L17:
        if (userInfo.isDemo() == false) goto L21;
        r2 = true;
    L19:
        th = move-exception;
        throw th;
    L5:
        if (hasManageUsersPermission() == true) goto L9;
        throw new SecurityException("You need MANAGE_USERS permission to query if u=" + userId + " is a demo user");
    }

    public boolean isAdminUser(int userId) {
        checkQueryOrCreateUsersPermissionIfCallerInOtherProfileGroup(userId, "isAdminUser");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L9
        if (userInfo != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (userInfo.isAdmin() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isPreCreated(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "isPreCreated");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L9
        if (userInfo != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (userInfo.preCreated == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public int getUserSwitchability(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserSwitchability");
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("getUserSwitchability-" + userId);
        int flags = 0;
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.telecom") == false) goto L15;
        t.traceBegin("TM.isInCall");
        long identity = Binder.clearCallingIdentity();
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService(TelecomManager.class);     // Catch: Throwable -> L10
        if (telecomManager == null) goto L12;
        if (telecomManager.isInCall() == false) goto L12;
        flags = 0 | 1;
    L12:
        Binder.restoreCallingIdentity(identity);
        t.traceEnd();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L15:
        t.traceBegin("hasUserRestriction-DISALLOW_USER_SWITCH");
        if (this.mLocalService.hasUserRestriction("no_user_switch", userId) == false) goto L18;
        flags = flags | 2;
    L18:
        t.traceEnd();
        if (isHeadlessSystemUserMode() == true) goto L28;
        t.traceBegin("getInt-ALLOW_USER_SWITCHING_WHEN_SYSTEM_USER_LOCKED");
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "allow_user_switching_when_system_user_locked", 0) == 0) goto L23;
        boolean allowUserSwitchingWhenSystemUserLocked = true;
    L24:
        t.traceEnd();
        t.traceBegin("isUserUnlocked-USER_SYSTEM");
        boolean systemUserUnlocked = this.mLocalService.isUserUnlocked(0);
        t.traceEnd();
        if (allowUserSwitchingWhenSystemUserLocked == true) goto L28;
        if (systemUserUnlocked == true) goto L28;
        flags = flags | 4;
        goto L28
    L23:
        allowUserSwitchingWhenSystemUserLocked = false;
    L28:
        t.traceEnd();
        return flags;
    }

    boolean isUserSwitcherEnabled(int userId) {
        ContentResolver r0 = this.mContext.getContentResolver();
        if (getSystemResources().getBoolean(R.bool.config_smart_battery_available) == false) goto L5;
        int r1 = 1;
    L7:
        if (android.provider.Settings.Global.getInt(r0, "user_switcher_enabled", r1) == 0) goto L9;
        boolean multiUserSettingOn = true;
    L11:
        if (UserManager.supportsMultipleUsers() == true) goto L13;
        return false;
    L13:
        if (hasUserRestriction("no_user_switch", userId) == false) goto L15;
        return false;
    L15:
        if (UserManager.isDeviceInDemoMode(this.mContext) == true) goto L22;
        if (multiUserSettingOn == true) goto L19;
        return false;
    L19:
        return true;
    L22:
        return false;
    L9:
        multiUserSettingOn = false;
        goto L11
    L5:
        r1 = 0;
        goto L7
    }

    public int getUserLogoutability(int userId) {
        throw new UnsupportedOperationException("aconfig flag android.multiuser.logout_user_api not enabled");
    }

    private int getUserToLogoutCurrentUserTo() {
        if (isHeadlessSystemUserMode() == false) goto L9;
        if (canSwitchToHeadlessSystemUser() == false) goto L9;
        return 0;
    L9:
        return getPreviousFullUserToEnterForegroundUnchecked();
    }

    public boolean isUserSwitcherEnabled(boolean showEvenIfNotActionable, int userId) {
        if (isUserSwitcherEnabled(userId) == true) goto L6;
        return false;
    L6:
        if (showEvenIfNotActionable == false) goto L8;
    L11:
        return true;
    L8:
        if (hasUserRestriction("no_add_user", userId) == false) goto L11;
        if (areThereMultipleSwitchableUsers() == true) goto L11;
        return false;
    }

    private boolean areThereMultipleSwitchableUsers() {
        List<UserInfo> aliveUsers = getUsers(true, true, true);
        boolean isAnyAliveUser = false;
        Iterator<UserInfo> r3 = aliveUsers.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        UserInfo userInfo = r3.next();
        if (userInfo.supportsSwitchToByUser() == false) goto L4;
        if (isAnyAliveUser == true) goto L8;
        isAnyAliveUser = true;
        goto L4
    L8:
        return true;
    L11:
        return false;
    }

    public boolean isRestricted(int userId) {
        if (userId == UserHandle.getCallingUserId()) goto L5;
        checkQueryOrCreateUsersPermission("query isRestricted for user " + userId);
    L5:
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L13
        if (userInfo != null) goto L10;
        boolean r2 = false;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L10:
        r2 = userInfo.isRestricted();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public boolean canHaveRestrictedProfile(int userId) {
        checkManageUsersPermission("canHaveRestrictedProfile");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L13
        boolean r2 = false;
        if (userInfo == null) goto L22;
        if (userInfo.canHaveProfile() == false) goto L22;
        if (userInfo.isAdmin() == true) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L16:
        if (this.mIsDeviceManaged == false) goto L18;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L18:
        if (this.mIsUserManaged.get(userId) == true) goto L20;
        r2 = true;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean canAddPrivateProfile(int userId) {
        checkCreateUsersPermission("canHaveRestrictedProfile");
        UserInfo parentUserInfo = getUserInfo(userId);
        if (isUserTypeEnabled("android.os.usertype.profile.PRIVATE") == true) goto L5;
        return false;
    L5:
        if (canAddMoreProfilesToUser("android.os.usertype.profile.PRIVATE", userId, false) == false) goto L17;
        if (parentUserInfo != null) goto L8;
        return false;
    L8:
        if (parentUserInfo.isMain() == true) goto L10;
        return false;
    L10:
        if (doesDeviceHardwareSupportPrivateSpace() == true) goto L12;
        return false;
    L12:
        if (hasUserRestriction("no_add_private_profile", userId) == true) goto L21;
        return true;
    L21:
        return false;
    L17:
        return false;
    }

    public boolean hasRestrictedProfiles(int userId) {
        checkManageUsersPermission("hasRestrictedProfiles");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L13
        int i = 0;
    L5:
        if (i >= userSize) goto L17;
        UserInfo profile = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L13
        if (userId == profile.id) goto L15;
        if (profile.restrictedProfileParentId != userId) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L15:
        i = i + 1;     // Catch: Throwable -> L13
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }

    private UserInfo getUserInfoLU(int userId) {
        UserData userData = this.mUsers.get(userId);
        if (userData != null) goto L5;
    L10:
        if (userData != null) goto L12;
        return null;
    L12:
        return userData.info;
    L5:
        if (userData.info.partial == false) goto L10;
        if (this.mRemovingUserIds.get(userId) == true) goto L10;
        Slog.w(LOG_TAG, "getUserInfo: unknown user #" + userId);
        return null;
    }

    private UserData getUserDataLU(int userId) {
        UserData userData = this.mUsers.get(userId);
        if (userData != null) goto L5;
    L10:
        return userData;
    L5:
        if (userData.info.partial == false) goto L10;
        if (this.mRemovingUserIds.get(userId) == true) goto L10;
        return null;
    }

    private UserInfo getUserInfoNoChecks(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L7
        if (userData == null) goto L9;
        UserInfo r2 = userData.info;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        throw th;
    }

    private UserData getUserDataNoChecks(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData r1 = this.mUsers.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean exists(int userId) {
        return this.mLocalService.exists(userId);
    }

    private int getCrossProfileIntentFilterAccessControl(int userId) {
        UserProperties userProperties = getUserPropertiesInternal(userId);
        if (userProperties != null) goto L7;
        return 0;
    L7:
        return userProperties.getCrossProfileIntentFilterAccessControl();
    }

    public void enforceCrossProfileIntentFilterAccess(int sourceUserId, int targetUserId, int callingUid, boolean addCrossProfileIntentFilter) {
        if (isCrossProfileIntentFilterAccessible(sourceUserId, targetUserId, addCrossProfileIntentFilter) == false) goto L6;
        return;
    L6:
        throw new SecurityException("CrossProfileIntentFilter cannot be accessed by user " + callingUid);
    }

    public boolean isCrossProfileIntentFilterAccessible(int sourceUserId, int targetUserId, boolean addCrossProfileIntentFilter) {
        int effectiveAccessControl = getCrossProfileIntentFilterAccessControl(sourceUserId, targetUserId);
        if (10 != effectiveAccessControl) goto L8;
        if (PackageManagerServiceUtils.isSystemOrRoot() == true) goto L8;
        return false;
    L8:
        if (20 != effectiveAccessControl) goto L13;
        if (addCrossProfileIntentFilter == true) goto L11;
    L12:
        return false;
    L11:
        if (PackageManagerServiceUtils.isSystemOrRoot() == false) goto L12;
        return true;
    L13:
        return true;
    }

    public int getCrossProfileIntentFilterAccessControl(int sourceUserId, int targetUserId) {
        int sourceAccessControlLevel = getCrossProfileIntentFilterAccessControl(sourceUserId);
        int targetAccessControlLevel = getCrossProfileIntentFilterAccessControl(targetUserId);
        int effectiveAccessControl = Math.max(sourceAccessControlLevel, targetAccessControlLevel);
        return effectiveAccessControl;
    }

    public void setUserName(int userId, String name) {
        checkManageUsersPermission("rename users");
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        UserData userData = getUserDataNoChecks(userId);     // Catch: Throwable -> L14
        if (userData == null) goto L28;
        if (userData.info.partial == true) goto L28;
        if (Objects.equals(name, userData.info.name) == false) goto L16;
        Slogf.i(LOG_TAG, "setUserName: ignoring for user #%d as it didn't change (%s)", new Object[]{Integer.valueOf(userId), getRedacted(name)});     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        if (name != null) goto L18;
        Slogf.i(LOG_TAG, "setUserName: resetting name of user #%d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L14
    L19:
        userData.info.name = name;     // Catch: Throwable -> L14
        writeUserLP(userData);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        long ident = Binder.clearCallingIdentity();
        sendUserInfoChangedBroadcast(userId);     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(ident);
        return;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L18:
        Slogf.i(LOG_TAG, "setUserName: setting name of user #%d to %s", new Object[]{Integer.valueOf(userId), getRedacted(name)});     // Catch: Throwable -> L14
    L28:
        Slogf.w(LOG_TAG, "setUserName: unknown user #%d", new Object[]{Integer.valueOf(userId)});     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean setUserEphemeral(int userId, boolean enableEphemeral) {
        checkCreateUsersPermission("update ephemeral user flag");
        if (enableEphemeral == false) goto L6;
        return UserManager.isRemoveResultSuccessful(setUserEphemeralUnchecked(userId));
    L6:
        return setUserNonEphemeralUnchecked(userId);
    }

    private boolean setUserNonEphemeralUnchecked(int userId) {
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        Object r1 = this.mUsersLock;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L14
        if (userData != null) goto L17;
        Slog.e(LOG_TAG, TextUtils.formatSimple("Cannot set user %d non-ephemeral, invalid user id provided.", new Object[]{Integer.valueOf(userId)}));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L17:
        if (userData.info.isEphemeral() == true) goto L22;
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L22:
        if ((userData.info.flags & 8192) == 0) goto L27;
        Slog.e(LOG_TAG, TextUtils.formatSimple("User %d can not be changed to non-ephemeral because it was set ephemeral on create.", new Object[]{Integer.valueOf(userId)}));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L14
        userData.info.flags &= -257;     // Catch: Throwable -> L12
        writeUserLP(userData);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private int setUserEphemeralUnchecked(int userId) {
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        Object r1 = this.mUsersLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        int userRemovability = getUserRemovabilityLocked(userId, "set as ephemeral");     // Catch: Throwable -> L13
        if (userRemovability == 3) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        return userRemovability;
    L15:
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        userData.info.flags |= 256;     // Catch: Throwable -> L11
        writeUserLP(userData);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Slog.i(LOG_TAG, TextUtils.formatSimple("User %d is set ephemeral and will be removed on user switch or reboot.", new Object[]{Integer.valueOf(userId)}));
        return 1;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setUserIcon(int userId, Bitmap bitmap) {
        checkManageUsersPermission("update users");     // Catch: UserManager.CheckedUserOperationException -> L4
        enforceUserRestriction("no_set_user_icon", userId, "Cannot set user icon");     // Catch: UserManager.CheckedUserOperationException -> L4
        this.mLocalService.setUserIcon(userId, bitmap);     // Catch: UserManager.CheckedUserOperationException -> L4
        return;
    L4:
        e = move-exception;
        throw e.toServiceSpecificException();
    }

    private void sendUserInfoChangedBroadcast(int userId) {
        Intent changedIntent = new Intent("android.intent.action.USER_INFO_CHANGED");
        changedIntent.putExtra("android.intent.extra.user_handle", userId);
        changedIntent.addFlags(1073741824);
        this.mContext.sendBroadcastAsUser(changedIntent, UserHandle.ALL);
        Intent bgIntent = new Intent("android.intent.action.USER_INFO_CHANGED_BACKGROUND");
        bgIntent.putExtra("android.intent.extra.user_handle", userId);
        bgIntent.addFlags(16777216);
        this.mContext.sendBroadcastAsUser(bgIntent, UserHandle.ALL, "android.permission.MANAGE_USERS");
    }

    public ParcelFileDescriptor getUserIcon(int targetUserId) {
        if (hasManageUsersOrPermission("android.permission.GET_ACCOUNTS_PRIVILEGED") == false) goto L33;
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        UserInfo targetUserInfo = getUserInfoNoChecks(targetUserId);     // Catch: Throwable -> L14
        if (targetUserInfo == null) goto L27;
        if (targetUserInfo.partial == true) goto L27;
        int callingUserId = UserHandle.getCallingUserId();     // Catch: Throwable -> L14
        UserInfo callingUserInfo = getUserInfoNoChecks(callingUserId);     // Catch: Throwable -> L14
        if (isSameUserOrProfileGroupOrTargetIsCommunal(callingUserInfo, targetUserInfo) == true) goto L17;
        checkManageUsersPermission("get the icon of a user who is not related");     // Catch: Throwable -> L14
    L17:
        if (targetUserInfo.iconPath != null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L20:
        String iconPath = targetUserInfo.iconPath;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return ParcelFileDescriptor.open(new File(iconPath), 268435456);
    L24:
        e = move-exception;
        Slog.e(LOG_TAG, "Couldn't find icon file", e);
        return null;
    L27:
        Slog.w(LOG_TAG, "getUserIcon: unknown user #" + targetUserId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    L33:
        throw new SecurityException("You need MANAGE_USERS or GET_ACCOUNTS_PRIVILEGED permissions to: get user icon");
    }

    public void makeInitialized(int userId) {
        checkManageUsersPermission("makeInitialized");
        boolean scheduleWriteUser = false;
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L12
        if (userData == null) goto L18;
        if (userData.info.partial == true) goto L18;
        if ((userData.info.flags & 16) != 0) goto L14;
        userData.info.flags |= 16;     // Catch: Throwable -> L12
        scheduleWriteUser = true;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (scheduleWriteUser == false) goto L24;
        scheduleWriteUser(userId);
        return;
    L24:
        return;
    L18:
        Slog.w(LOG_TAG, "makeInitialized: unknown user #" + userId);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void initDefaultGuestRestrictions() {
        Bundle r0 = this.mGuestRestrictions;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mGuestRestrictions.isEmpty() == false) goto L14;
        UserTypeDetails guestType = this.mUserTypes.get("android.os.usertype.full.GUEST");     // Catch: Throwable -> L11
        if (guestType != null) goto L13;
        Slog.wtf(LOG_TAG, "Can't set default guest restrictions: type doesn't exist.");     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        guestType.addDefaultRestrictionsTo(this.mGuestRestrictions);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public Bundle getDefaultGuestRestrictions() {
        checkManageUsersPermission("getDefaultGuestRestrictions");
        Bundle r0 = this.mGuestRestrictions;
        monitor-enter(r0);
        Bundle r1 = new Bundle(this.mGuestRestrictions);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDefaultGuestRestrictions(Bundle restrictions) {
        checkManageUsersPermission("setDefaultGuestRestrictions");
        List<UserInfo> guests = getGuestUsers();
        Object r1 = this.mRestrictionsLock;
        monitor-enter(r1);
        int i = 0;
    L29:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= guests.size()) goto L11;
        updateUserRestrictionsInternalLR(restrictions, guests.get(i).id);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L29
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        Bundle r2 = this.mGuestRestrictions;
        monitor-enter(r2);
        this.mGuestRestrictions.clear();     // Catch: Throwable -> L24
        this.mGuestRestrictions.putAll(restrictions);     // Catch: Throwable -> L24
        monitor-exit(r2);     // Catch: Throwable -> L24
        Object r3 = this.mPackagesLock;
        monitor-enter(r3);
        writeUserListLP();     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L24:
        th = move-exception;
        throw th;
    }

    void setUserRestrictionInner(int userId, String key, boolean value) {
        if (UserRestrictionsUtils.isValidRestriction(key) == true) goto L6;
        Slog.e(LOG_TAG, "Setting invalid restriction " + key);
        return;
    L6:
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        Bundle newRestrictions = BundleUtils.clone(this.mDevicePolicyUserRestrictions.getRestrictions(userId));     // Catch: Throwable -> L13
        newRestrictions.putBoolean(key, value);     // Catch: Throwable -> L13
        if (this.mDevicePolicyUserRestrictions.updateRestrictions(userId, newRestrictions) == true) goto L11;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        if (userId != (-1)) goto L15;
        applyUserRestrictionsForAllUsersLR();     // Catch: Throwable -> L13
        goto L16
    L15:
        applyUserRestrictionsLR(userId);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void setDevicePolicyUserRestrictionsInner(int originatingUserId, Bundle global, RestrictionsSet local, boolean isDeviceOwner) {
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        IntArray updatedUserIds = this.mDevicePolicyUserRestrictions.getUserIds();     // Catch: Throwable -> L8
        this.mCachedEffectiveUserRestrictions.removeAllRestrictions();     // Catch: Throwable -> L8
        this.mDevicePolicyUserRestrictions.removeAllRestrictions();     // Catch: Throwable -> L8
        this.mDevicePolicyUserRestrictions.updateRestrictions(-1, global);     // Catch: Throwable -> L8
        IntArray localUserIds = local.getUserIds();     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= localUserIds.size()) goto L10;
        int userId = localUserIds.get(i);     // Catch: Throwable -> L8
        this.mDevicePolicyUserRestrictions.updateRestrictions(userId, local.getRestrictions(userId));     // Catch: Throwable -> L8
        updatedUserIds.add(userId);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        applyUserRestrictionsForAllUsersLR();     // Catch: Throwable -> L8
        int i2 = 0;
    L12:
        if (i2 >= updatedUserIds.size()) goto L19;
        if (updatedUserIds.get(i2) == (-1)) goto L17;
        applyUserRestrictionsLR(updatedUserIds.get(i2));     // Catch: Throwable -> L8
    L17:
        i2 = i2 + 1;     // Catch: Throwable -> L8
        goto L12
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private Bundle computeEffectiveUserRestrictionsLR(int userId) {
        Bundle baseRestrictions = this.mBaseUserRestrictions.getRestrictionsNonNull(userId);
        Bundle global = this.mDevicePolicyUserRestrictions.getRestrictionsNonNull(-1);
        Bundle local = this.mDevicePolicyUserRestrictions.getRestrictionsNonNull(userId);
        if (global.isEmpty() == true) goto L5;
    L7:
        Bundle effective = BundleUtils.clone(baseRestrictions);
        UserRestrictionsUtils.merge(effective, global);
        UserRestrictionsUtils.merge(effective, local);
        return effective;
    L5:
        if (local.isEmpty() == false) goto L7;
        return baseRestrictions;
    }

    private void invalidateEffectiveUserRestrictionsLR(int userId) {
        this.mCachedEffectiveUserRestrictions.remove(userId);
    }

    private Bundle getEffectiveUserRestrictions(int userId) {
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        Bundle restrictions = this.mCachedEffectiveUserRestrictions.getRestrictions(userId);     // Catch: Throwable -> L7
        if (restrictions != null) goto L9;
        restrictions = computeEffectiveUserRestrictionsLR(userId);     // Catch: Throwable -> L7
        this.mCachedEffectiveUserRestrictions.updateRestrictions(userId, restrictions);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return restrictions;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasUserRestriction(String restrictionKey, int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "hasUserRestriction");
        if (userExists(userId) == true) goto L7;
        return false;
    L7:
        return this.mLocalService.hasUserRestriction(restrictionKey, userId);
    }

    public boolean hasUserRestrictionOnAnyUser(String restrictionKey) {
        if (UserRestrictionsUtils.isValidRestriction(restrictionKey) == true) goto L5;
        return false;
    L5:
        List<UserInfo> users = getUsers(true);
        int i = 0;
    L7:
        if (i >= users.size()) goto L15;
        int userId = users.get(i).id;
        Bundle restrictions = getEffectiveUserRestrictions(userId);
        if (restrictions == null) goto L13;
        if (restrictions.getBoolean(restrictionKey) == false) goto L13;
        return true;
    L13:
        i = i + 1;
        goto L7
    L15:
        return false;
    }

    public boolean isSettingRestrictedForUser(String setting, int userId, String value, int callingUid) {
        if (Binder.getCallingUid() != 1000) goto L7;
        return UserRestrictionsUtils.isSettingRestrictedForUser(this.mContext, setting, userId, value, callingUid);
    L7:
        throw new SecurityException("Non-system caller");
    }

    public void addUserRestrictionsListener(final IUserRestrictionsListener listener) {
        if (Binder.getCallingUid() != 1000) goto L7;
        this.mLocalService.addUserRestrictionsListener(new UserManagerService$$ExternalSyntheticLambda8(listener));
        return;
    L7:
        throw new SecurityException("Non-system caller");
    }

    private static /* synthetic */ void lambda$addUserRestrictionsListener$2(IUserRestrictionsListener listener, int userId, Bundle newRestrict, Bundle prevRestrict) {
        listener.onUserRestrictionsChanged(userId, newRestrict, prevRestrict);     // Catch: RemoteException -> L4
        return;
    L4:
        re = move-exception;
        Slog.e("IUserRestrictionsListener", "Unable to invoke listener: " + re.getMessage());
    }

    public int getUserRestrictionSource(String restrictionKey, int userId) {
        List<UserManager.EnforcingUser> enforcingUsers = getUserRestrictionSources(restrictionKey, userId);
        int result = 0;
        int i = enforcingUsers.size() - 1;
    L3:
        if (i < 0) goto L6;
        result = result | enforcingUsers.get(i).getUserRestrictionSource();
        i = i - 1;
        goto L3
    L6:
        return result;
    }

    public List<UserManager.EnforcingUser> getUserRestrictionSources(String restrictionKey, int userId) {
        checkQueryUsersPermission("call getUserRestrictionSources.");
        if (hasUserRestriction(restrictionKey, userId) == false) goto L5;
        List<UserManager.EnforcingUser> result = new ArrayList();
        if (hasBaseUserRestriction(restrictionKey, userId) == false) goto L9;
        result.add(new UserManager.EnforcingUser(ProcessList.INVALID_ADJ, 1));
    L9:
        DevicePolicyManagerInternal dpmi = getDevicePolicyManagerInternal();
        if (dpmi == null) goto L12;
        result.addAll(dpmi.getUserRestrictionSources(restrictionKey, userId));
    L12:
        return result;
    L5:
        return Collections.emptyList();
    }

    public Bundle getUserRestrictions(int userId) {
        checkManageOrInteractPermissionIfCallerInOtherProfileGroup(userId, "getUserRestrictions");
        return BundleUtils.clone(getEffectiveUserRestrictions(userId));
    }

    public boolean hasBaseUserRestriction(String restrictionKey, int userId) {
        checkCreateUsersPermission("hasBaseUserRestriction");
        boolean r1 = false;
        if (UserRestrictionsUtils.isValidRestriction(restrictionKey) == true) goto L5;
        return false;
    L5:
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        Bundle bundle = this.mBaseUserRestrictions.getRestrictions(userId);     // Catch: Throwable -> L12
        if (bundle != null) goto L10;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L10:
        if (bundle.getBoolean(restrictionKey, false) == false) goto L14;
        r1 = true;
    L12:
        th = move-exception;
        throw th;
    }

    public void setUserRestriction(String key, boolean value, int userId) {
        checkManageUsersPermission("setUserRestriction");
        if (UserRestrictionsUtils.isValidRestriction(key) == true) goto L6;
        return;
    L6:
        if (userExists(userId) == true) goto L9;
        Slogf.w(LOG_TAG, "Cannot set user restriction %s. User with id %d does not exist", new Object[]{key, Integer.valueOf(userId)});
        return;
    L9:
        Object r0 = this.mRestrictionsLock;
        monitor-enter(r0);
        Bundle newRestrictions = BundleUtils.clone(this.mBaseUserRestrictions.getRestrictions(userId));     // Catch: Throwable -> L14
        newRestrictions.putBoolean(key, value);     // Catch: Throwable -> L14
        updateUserRestrictionsInternalLR(newRestrictions, userId);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void updateUserRestrictionsInternalLR(Bundle newBaseRestrictions, final int userId) {
        Bundle prevAppliedRestrictions = UserRestrictionsUtils.nonNull(this.mAppliedUserRestrictions.getRestrictions(userId));
        if (newBaseRestrictions == null) goto L14;
        Bundle prevBaseRestrictions = this.mBaseUserRestrictions.getRestrictions(userId);
        boolean r2 = false;
        if (prevBaseRestrictions == newBaseRestrictions) goto L7;
        boolean r4 = true;
    L8:
        Preconditions.checkState(r4);
        if (this.mCachedEffectiveUserRestrictions.getRestrictions(userId) == newBaseRestrictions) goto L11;
        r2 = true;
    L11:
        Preconditions.checkState(r2);
        if (this.mBaseUserRestrictions.updateRestrictions(userId, new Bundle(newBaseRestrictions)) == false) goto L14;
        scheduleWriteUser(userId);
        goto L14
    L7:
        r4 = false;
    L14:
        final Bundle effective = computeEffectiveUserRestrictionsLR(userId);
        this.mCachedEffectiveUserRestrictions.updateRestrictions(userId, new Bundle(effective));
        if (this.mAppOpsService == null) goto L17;
        this.mHandler.post(new UserManagerService$$ExternalSyntheticLambda0(this, effective, userId));
    L17:
        propagateUserRestrictionsLR(userId, effective, prevAppliedRestrictions);
        this.mAppliedUserRestrictions.updateRestrictions(userId, new Bundle(effective));
    }

    private /* synthetic */ void lambda$updateUserRestrictionsInternalLR$3(Bundle effective, int userId) {
        this.mAppOpsService.setUserRestrictions(effective, this.mUserRestrictionToken, userId);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.w(LOG_TAG, "Unable to notify AppOpsService of UserRestrictions");
    }

    private void propagateUserRestrictionsLR(final int userId, Bundle newRestrictions, Bundle prevRestrictions) {
        if (UserRestrictionsUtils.areEqual(newRestrictions, prevRestrictions) == false) goto L5;
        return;
    L5:
        final Bundle newRestrictionsFinal = new Bundle(newRestrictions);
        final Bundle prevRestrictionsFinal = new Bundle(prevRestrictions);
        this.mHandler.post(new AnonymousClass4(this, userId, newRestrictionsFinal, prevRestrictionsFinal));
    }

    private void applyUserRestrictionsLR(int userId) {
        updateUserRestrictionsInternalLR(null, userId);
        scheduleWriteUser(userId);
    }

    private void applyUserRestrictionsForAllUsersLR() {
        this.mCachedEffectiveUserRestrictions.removeAllRestrictions();
        Runnable r = new AnonymousClass5(this);
        this.mHandler.post(r);
    }

    private boolean isUserLimitReached() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int count = getAliveUsersExcludingGuestsCountLU();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (count >= UserManager.getMaxSupportedUsers()) goto L9;
    L11:
        return false;
    L9:
        if (isCreationOverrideEnabled() == true) goto L11;
        return true;
    L13:
        th = move-exception;
        throw th;
    }

    private boolean canAddMoreUsersOfType(UserTypeDetails userTypeDetails) {
        if (isUserTypeEnabled(userTypeDetails) == true) goto L5;
        return false;
    L5:
        int max = userTypeDetails.getMaxAllowed();
        if (max != (-1)) goto L9;
        return true;
    L9:
        if (getNumberOfUsersOfType(userTypeDetails.getName()) < max) goto L13;
        if (isCreationOverrideEnabled() == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int getRemainingCreatableUserCount(String userType) {
        checkQueryOrCreateUsersPermission("get the remaining number of users that can be added.");
        UserTypeDetails type = this.mUserTypes.get(userType);
        if (type != null) goto L5;
    L46:
        return 0;
    L5:
        if (isUserTypeEnabled(type) == false) goto L46;
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
        int userCount = getAliveUsersExcludingGuestsCountLU();     // Catch: Throwable -> L15
        int r5 = Integer.MAX_VALUE;
        if (UserManager.isUserTypeGuest(userType) == true) goto L17;
        if (UserManager.isUserTypeDemo(userType) == true) goto L17;
        int result = UserManager.getMaxSupportedUsers() - userCount;     // Catch: Throwable -> L15
    L19:
        if (type.isManagedProfile() == true) goto L21;
    L34:
        if (result > 0) goto L38;
        monitor-exit(r2);     // Catch: Throwable -> L15
        return 0;
    L38:
        if (type.getMaxAllowed() == (-1)) goto L41;
        r5 = type.getMaxAllowed() - getNumberOfUsersOfType(userType);     // Catch: Throwable -> L15
    L41:
        int r1 = Math.max(0, Math.min(result, r5));     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return r1;
    L21:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.managed_users") == true) goto L24;
        monitor-exit(r2);     // Catch: Throwable -> L15
        return 0;
    L24:
        boolean r6 = true;
        if (result > 0) goto L27;
        boolean r7 = true;
    L28:
        if (userCount == 1) goto L32;
        r6 = false;
    L32:
        if ((r6 & r7) == false) goto L34;
        result = 1;
        goto L34
    L27:
        r7 = false;
    L17:
        result = Integer.MAX_VALUE;
    L15:
        th = move-exception;
        throw th;
    }

    private int getNumberOfUsersOfType(String userType) {
        int count = 0;
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        int size = this.mUsers.size();     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= size) goto L19;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L15
        if (user.userType.equals(userType) == false) goto L17;
        if (user.guestToRemove == true) goto L17;
        if (this.mRemovingUserIds.get(user.id) == true) goto L17;
        if (user.preCreated == true) goto L17;
        count = count + 1;     // Catch: Throwable -> L15
    L17:
        i = i + 1;     // Catch: Throwable -> L15
        goto L5
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return count;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean canAddMoreUsersOfType(String userType) {
        checkCreateUsersPermission("check if more users can be added.");
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (canAddMoreUsersOfType(userTypeDetails) == false) goto L7;
        return true;
    }

    public boolean isUserTypeEnabled(String userType) {
        checkCreateUsersPermission("check if user type is enabled.");
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
    L7:
        return false;
    L5:
        if (isUserTypeEnabled(userTypeDetails) == false) goto L7;
        return true;
    }

    private boolean isUserTypeEnabled(UserTypeDetails userTypeDetails) {
        if (userTypeDetails.isEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (isCreationOverrideEnabled() == true) goto L8;
        return false;
    }

    private boolean isCreationOverrideEnabled() {
        if (Build.isDebuggable() == true) goto L5;
        return false;
    L5:
        if (SystemProperties.getBoolean("debug.user.creation_override", false) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean canAddMoreManagedProfiles(int userId, boolean allowedToRemoveOne) {
        return canAddMoreProfilesToUser("android.os.usertype.profile.MANAGED", userId, allowedToRemoveOne);
    }

    public boolean canAddMoreProfilesToUser(String userType, int userId, boolean allowedToRemoveOne) {
        if (getRemainingCreatableProfileCount(userType, userId, allowedToRemoveOne) <= 0) goto L5;
    L8:
        return true;
    L5:
        if (isCreationOverrideEnabled() == true) goto L8;
        return false;
    }

    public int getRemainingCreatableProfileCount(String userType, int userId) {
        return getRemainingCreatableProfileCount(userType, userId, false);
    }

    private int getRemainingCreatableProfileCount(String userType, int userId, boolean allowedToRemoveOne) {
        checkQueryOrCreateUsersPermission("get the remaining number of profiles that can be added to the given user.");
        UserTypeDetails type = this.mUserTypes.get(userType);
        if (type != null) goto L5;
    L47:
        return 0;
    L5:
        if (isUserTypeEnabled(type) == false) goto L47;
        boolean isManagedProfile = type.isManagedProfile();
        if (isManagedProfile == true) goto L10;
    L12:
        Object r3 = this.mUsersLock;
        monitor-enter(r3);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L32
        if (userInfo == null) goto L43;
        if (userInfo.canHaveProfile() == false) goto L43;
        int userTypeCount = getProfileIds(userId, userType, false, false).length;     // Catch: Throwable -> L32
        if (userTypeCount <= 0) goto L23;
        if (allowedToRemoveOne == false) goto L23;
        int profilesRemovedCount = 1;
    L24:
        int usersCountAfterRemoving = getAliveUsersExcludingGuestsCountLU() - profilesRemovedCount;     // Catch: Throwable -> L32
        int result = UserManager.getMaxSupportedUsers() - usersCountAfterRemoving;     // Catch: Throwable -> L32
        if (result > 0) goto L29;
        if (isManagedProfile == false) goto L29;
        if (usersCountAfterRemoving != 1) goto L29;
        result = 1;
    L29:
        int maxUsersOfType = getMaxUsersOfTypePerParent(type);     // Catch: Throwable -> L32
        if (maxUsersOfType == (-1)) goto L34;
        result = Math.min(result, maxUsersOfType - (userTypeCount - profilesRemovedCount));     // Catch: Throwable -> L32
    L34:
        if (result > 0) goto L38;
        monitor-exit(r3);     // Catch: Throwable -> L32
        return 0;
    L38:
        if (type.getMaxAllowed() == (-1)) goto L40;
        result = Math.min(result, type.getMaxAllowed() - (getNumberOfUsersOfType(userType) - profilesRemovedCount));     // Catch: Throwable -> L32
    L40:
        int r1 = Math.max(0, result);     // Catch: Throwable -> L32
        monitor-exit(r3);     // Catch: Throwable -> L32
        return r1;
    L23:
        profilesRemovedCount = 0;
    L43:
        monitor-exit(r3);     // Catch: Throwable -> L32
        return 0;
    L32:
        th = move-exception;
        throw th;
    L10:
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.managed_users") == true) goto L12;
        return 0;
    }

    private int getAliveUsersExcludingGuestsCountLU() {
        int aliveUserCount = 0;
        int totalUserCount = this.mUsers.size();
        int i = 0;
    L3:
        if (i >= totalUserCount) goto L13;
        UserInfo user = this.mUsers.valueAt(i).info;
        if (this.mRemovingUserIds.get(user.id) == true) goto L11;
        if (user.isGuest() == true) goto L11;
        if (user.preCreated == true) goto L11;
        aliveUserCount = aliveUserCount + 1;
    L11:
        i = i + 1;
        goto L3
    L13:
        return aliveUserCount;
    }

    private static final void checkManageUserAndAcrossUsersFullPermission(String message) {
        int uid = Binder.getCallingUid();
        if (uid == 1000) goto L13;
        if (uid != 0) goto L7;
        return;
    L7:
        if (hasPermissionGranted("android.permission.MANAGE_USERS", uid) == false) goto L12;
        if (hasPermissionGranted("android.permission.INTERACT_ACROSS_USERS_FULL", uid) == false) goto L12;
        return;
    L12:
        throw new SecurityException("You need MANAGE_USERS and INTERACT_ACROSS_USERS_FULL permission to: " + message);
    }

    private static boolean hasPermissionGranted(String permission, int uid) {
        if (ActivityManager.checkComponentPermission(permission, uid, -1, true) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static final void checkManageUsersPermission(String message) {
        if (hasManageUsersPermission() == false) goto L6;
        return;
    L6:
        throw new SecurityException("You need MANAGE_USERS permission to: " + message);
    }

    private static final void checkCreateUsersPermission(String message) {
        if (hasCreateUsersPermission() == false) goto L6;
        return;
    L6:
        throw new SecurityException("You either need MANAGE_USERS or CREATE_USERS permission to: " + message);
    }

    private static final void checkQueryUsersPermission(String message) {
        if (hasQueryUsersPermission() == false) goto L6;
        return;
    L6:
        throw new SecurityException("You either need MANAGE_USERS or QUERY_USERS permission to: " + message);
    }

    private static final void checkQueryOrCreateUsersPermission(String message) {
        if (hasQueryOrCreateUsersPermission() == false) goto L6;
        return;
    L6:
        throw new SecurityException("You either need MANAGE_USERS, CREATE_USERS, or QUERY_USERS permission to: " + message);
    }

    private static final void checkCreateUsersPermission(int creationFlags) {
        if (((-38701) & creationFlags) != 0) goto L10;
        if (hasCreateUsersPermission() == false) goto L8;
        return;
    L8:
        throw new SecurityException("You either need MANAGE_USERS or CREATE_USERS permission to create an user with flags: " + creationFlags);
    L10:
        if (hasManageUsersPermission() == false) goto L13;
        return;
    L13:
        throw new SecurityException("You need MANAGE_USERS permission to create an user  with flags: " + creationFlags);
    }

    private static final boolean hasManageUsersPermission() {
        int callingUid = Binder.getCallingUid();
        return hasManageUsersPermission(callingUid);
    }

    private static boolean hasManageUsersPermission(int callingUid) {
        if (UserHandle.isSameApp(callingUid, 1000) == true) goto L9;
        if (callingUid == 0) goto L9;
        if (hasPermissionGranted("android.permission.MANAGE_USERS", callingUid) == true) goto L9;
        return false;
    L9:
        return true;
    }

    private static final boolean hasManageUsersOrPermission(String alternativePermission) {
        int callingUid = Binder.getCallingUid();
        if (hasManageUsersPermission(callingUid) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasPermissionGranted(alternativePermission, callingUid) == true) goto L8;
        return false;
    }

    private static final boolean hasCreateUsersPermission() {
        return hasManageUsersOrPermission("android.permission.CREATE_USERS");
    }

    private static final boolean hasQueryUsersPermission() {
        return hasManageUsersOrPermission("android.permission.QUERY_USERS");
    }

    private static final boolean hasQueryOrCreateUsersPermission() {
        if (hasCreateUsersPermission() == false) goto L5;
    L8:
        return true;
    L5:
        if (hasPermissionGranted("android.permission.QUERY_USERS", Binder.getCallingUid()) == true) goto L8;
        return false;
    }

    private static void checkSystemOrRoot(String message) {
        int uid = Binder.getCallingUid();
        if (UserHandle.isSameApp(uid, 1000) == true) goto L8;
        if (uid != 0) goto L7;
        return;
    L7:
        throw new SecurityException("Only system may: " + message);
    }

    private void checkAdminStatusChangeAllowed(int targetUser) {
        if (hasUserRestriction("no_grant_admin", UserHandle.getCallingUserId()) == true) goto L8;
        if (hasUserRestriction("no_grant_admin", targetUser) == true) goto L8;
        return;
    L8:
        throw new SecurityException("Admin status change is restricted. The DISALLOW_GRANT_ADMIN restriction is applied either on the current or the target user.");
    }

    private void writeBitmapLP(UserInfo info, Bitmap bitmap) {
        File dir = new File(this.mUsersDir, Integer.toString(info.id));     // Catch: FileNotFoundException -> L5
        File file = new File(dir, USER_PHOTO_FILENAME);     // Catch: FileNotFoundException -> L5
        File tmp = new File(dir, USER_PHOTO_FILENAME_TMP);     // Catch: FileNotFoundException -> L5
        if (dir.exists() == true) goto L7;
        dir.mkdir();     // Catch: FileNotFoundException -> L5
        FileUtils.setPermissions(dir.getPath(), 505, -1, -1);     // Catch: FileNotFoundException -> L5
    L7:
        Bitmap.CompressFormat r3 = Bitmap.CompressFormat.PNG;     // Catch: FileNotFoundException -> L5
        FileOutputStream os = new FileOutputStream(tmp);     // Catch: FileNotFoundException -> L5
        if (bitmap.compress(r3, 100, os) == true) goto L10;
    L21:
        os.close();     // Catch: IOException -> L16
    L17:
        tmp.delete();     // Catch: FileNotFoundException -> L5
        return;
    L10:
        if (tmp.renameTo(file) == false) goto L21;
        if (SELinux.restorecon(file) == false) goto L21;
        info.iconPath = file.getAbsolutePath();     // Catch: FileNotFoundException -> L5
    L5:
        e = move-exception;
        Slog.w(LOG_TAG, "Error setting photo for user ", e);
    }

    public int[] getUserIds() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int[] r1 = this.mUserIds;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean userExists(int id) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int[] r1 = this.mUserIds;     // Catch: Throwable -> L11
        int r2 = r1.length;     // Catch: Throwable -> L11
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L14;
        int userId = r1[r4];     // Catch: Throwable -> L11
        if (userId == id) goto L8;
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public int[] getUserIdsIncludingPreCreated() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int[] r1 = this.mUserIdsIncludingPreCreated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isHeadlessSystemUserMode() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        boolean r2 = false;
        UserData systemUserData = this.mUsers.get(0);     // Catch: Throwable -> L9
        if (systemUserData.info.isFull() == true) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isDefaultHeadlessSystemUserMode() {
        if (Build.isDebuggable() == false) goto L5;
        String emulatedValue = SystemProperties.get("persist.debug.user_mode_emulation");
        if (TextUtils.isEmpty(emulatedValue) == true) goto L20;
        if ("headless".equals(emulatedValue) == false) goto L13;
        return true;
    L13:
        if ("full".equals(emulatedValue) == false) goto L17;
        return false;
    L17:
        if ("default".equals(emulatedValue) == true) goto L20;
        Slogf.e(LOG_TAG, "isDefaultHeadlessSystemUserMode(): ignoring invalid valued of property %s: %s", new Object[]{"persist.debug.user_mode_emulation", emulatedValue});
    L20:
        return RoSystemProperties.MULTIUSER_HEADLESS_SYSTEM_USER;
    L5:
        return RoSystemProperties.MULTIUSER_HEADLESS_SYSTEM_USER;
    }

    private void emulateSystemUserModeIfNeeded() {
        if (Build.isDebuggable() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(SystemProperties.get("persist.debug.user_mode_emulation")) == false) goto L8;
        return;
    L8:
        boolean newHeadlessSystemUserMode = isDefaultHeadlessSystemUserMode();
        Object r1 = this.mPackagesLock;
        monitor-enter(r1);
        Object r2 = this.mUsersLock;     // Catch: Throwable -> L18
        monitor-enter(r2);     // Catch: Throwable -> L18
        boolean mainIsAlreadyNonSystem = false;
        UserData systemUserData = this.mUsers.get(0);     // Catch: Throwable -> L20
        if (systemUserData != null) goto L22;
        Slogf.wtf(LOG_TAG, "emulateSystemUserModeIfNeeded(): no system user data");     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L22:
        int oldMainUserId = getMainUserIdUnchecked();     // Catch: Throwable -> L20
        int oldSysFlags = systemUserData.info.flags;     // Catch: Throwable -> L20
        if (newHeadlessSystemUserMode == false) goto L25;
        String newUserType = "android.os.usertype.system.HEADLESS";
        int newSysFlags = (oldSysFlags & (-1025)) & (-16385);     // Catch: Throwable -> L20
    L27:
        if (systemUserData.info.userType.equals(newUserType) == false) goto L32;
        Slogf.d(LOG_TAG, "emulateSystemUserModeIfNeeded(): system user type is already %s, returning", new Object[]{newUserType});     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L32:
        Slogf.i(LOG_TAG, "Persisting emulated system user data: type changed from %s to %s, flags changed from %s to %s", new Object[]{systemUserData.info.userType, newUserType, UserInfo.flagsToString(oldSysFlags), UserInfo.flagsToString(newSysFlags)});     // Catch: Throwable -> L20
        systemUserData.info.userType = newUserType;     // Catch: Throwable -> L20
        systemUserData.info.flags = newSysFlags;     // Catch: Throwable -> L20
        writeUserLP(systemUserData);     // Catch: Throwable -> L20
        UserData oldMain = getUserDataNoChecks(oldMainUserId);     // Catch: Throwable -> L20
        if (newHeadlessSystemUserMode == false) goto L46;
        if (oldMain != null) goto L36;
    L39:
        if (mainIsAlreadyNonSystem == true) goto L51;
        if (isMainUserPermanentAdmin() == false) goto L51;
        UserInfo newMainUser = getEarliestCreatedFullUser();     // Catch: Throwable -> L20
        if (newMainUser == null) goto L51;
        Slogf.i(LOG_TAG, "Designating user " + newMainUser.id + " to be Main");     // Catch: Throwable -> L20
        newMainUser.flags = newMainUser.flags | 16384;     // Catch: Throwable -> L20
        writeUserLP(getUserDataNoChecks(newMainUser.id));     // Catch: Throwable -> L20
    L51:
        monitor-exit(r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L18
        this.mUpdatingSystemUserMode = true;
        return;
    L36:
        if ((oldMain.info.flags & 2048) != 0) goto L39;
        mainIsAlreadyNonSystem = true;
        goto L39
    L46:
        if (oldMain != null) goto L48;
    L50:
        Slogf.i(LOG_TAG, "Designated user 0 to be Main");     // Catch: Throwable -> L20
        goto L51
    L48:
        if ((oldMain.info.flags & 2048) != 0) goto L50;
        Slogf.i(LOG_TAG, "Transferring Main to user 0 from " + oldMain.info.id);     // Catch: Throwable -> L20
        UserInfo r4 = oldMain.info;     // Catch: Throwable -> L20
        r4.flags = r4.flags & (-16385);     // Catch: Throwable -> L20
        writeUserLP(oldMain);     // Catch: Throwable -> L20
        goto L51
    L25:
        newUserType = "android.os.usertype.full.SYSTEM";
        newSysFlags = (oldSysFlags | 1024) | 16384;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void showHsumNotificationIfNeeded() {
        if (RoSystemProperties.MULTIUSER_HEADLESS_SYSTEM_USER != isHeadlessSystemUserMode()) goto L6;
        return;
    L6:
        if (Build.isDebuggable() == true) goto L8;
    L10:
        Slogf.w(LOG_TAG, "Posting warning that device's HSUM status doesn't match the build's.");
        String title = this.mContext.getString(17042449);
        String message = this.mContext.getString(17042448);
        Notification notification = new Notification.Builder(this.mContext, "DEVELOPER").setSmallIcon(17305175).setWhen(0).setOngoing(true).setTicker(title).setDefaults(0).setColor(this.mContext.getColor(R.color.system_notification_accent_color)).setContentTitle(title).setContentText(message).setVisibility(1).build();
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        notificationManager.notifyAsUser(null, 77, notification, UserHandle.ALL);
        return;
    L8:
        if (TextUtils.isEmpty(SystemProperties.get("persist.debug.user_mode_emulation")) == true) goto L10;
    }

    private ResilientAtomicFile getUserListFile() {
        File tempBackup = new File(this.mUserListFile.getParent(), this.mUserListFile.getName() + ".backup");
        File reserveCopy = new File(this.mUserListFile.getParent(), this.mUserListFile.getName() + ".reservecopy");
        return new ResilientAtomicFile(this.mUserListFile, tempBackup, reserveCopy, 505, "user list", new UserManagerService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$getUserListFile$4(int priority, String msg) {
        Slog.e(LOG_TAG, msg);
        scheduleWriteUserList();
    }

    private void readUserListLP() {
        boolean guestRestrictionsArePresentOnUserListXml = false;
        ResilientAtomicFile file = getUserListFile();
        FileInputStream fin = file.openRead();     // Catch: Throwable -> L8 Exception -> L10
        if (fin != null) goto L12;
        Slog.e(LOG_TAG, "userlist.xml not found, fallback to single user");     // Catch: Throwable -> L8 Exception -> L10
        fallbackToSingleUserLP();     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return;
    L12:
        TypedXmlPullParser parser = Xml.resolvePullParser(fin);     // Catch: Throwable -> L8 Exception -> L10
    L13:
        int type = parser.next();     // Catch: Throwable -> L8 Exception -> L10
        if (type == 2) goto L17;
        if (type != 1) goto L13;
    L17:
        if (type == 2) goto L22;
        Slog.e(LOG_TAG, "Unable to read user list");     // Catch: Throwable -> L8 Exception -> L10
        fallbackToSingleUserLP();     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return;
    L22:
        this.mNextSerialNumber = -1;     // Catch: Throwable -> L8 Exception -> L10
        if (parser.getName().equals("users") == false) goto L25;
        this.mNextSerialNumber = parser.getAttributeInt(null, ATTR_NEXT_SERIAL_NO, this.mNextSerialNumber);     // Catch: Throwable -> L8 Exception -> L10
        this.mUserVersion = parser.getAttributeInt(null, ATTR_USER_VERSION, this.mUserVersion);     // Catch: Throwable -> L8 Exception -> L10
        this.mUserTypeVersion = parser.getAttributeInt(null, ATTR_USER_TYPE_VERSION, this.mUserTypeVersion);     // Catch: Throwable -> L8 Exception -> L10
    L25:
        int type2 = parser.next();     // Catch: Throwable -> L8 Exception -> L10
        if (type2 == 1) goto L67;
        if (type2 != 2) goto L25;
        String name = parser.getName();     // Catch: Throwable -> L8 Exception -> L10
        if (name.equals(TAG_USER) == false) goto L49;
        UserData userData = readUserLP(parser.getAttributeInt(null, ATTR_ID), this.mUserVersion);     // Catch: Throwable -> L8 Exception -> L10
        if (userData == null) goto L25;
        Object r10 = this.mUsersLock;     // Catch: Throwable -> L8 Exception -> L10
        monitor-enter(r10);     // Catch: Throwable -> L8 Exception -> L10
        addUserDataLU(userData);     // Catch: Throwable -> L39
        if (this.mNextSerialNumber < 0) goto L41;
        if (this.mNextSerialNumber <= userData.info.id) goto L41;
    L42:
        markUserForRemovalIfNecessaryLU(userData.info);     // Catch: Throwable -> L39
        monitor-exit(r10);     // Catch: Throwable -> L39
    L41:
        this.mNextSerialNumber = userData.info.id + 1;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8 Exception -> L10
    L49:
        if (name.equals(TAG_GUEST_RESTRICTIONS) == false) goto L25;
        guestRestrictionsArePresentOnUserListXml = true;
    L51:
        int type3 = parser.next();     // Catch: Throwable -> L8 Exception -> L10
        if (type3 == 1) goto L25;
        if (type3 == 3) goto L25;
        if (type3 != 2) goto L51;
        if (parser.getName().equals(TAG_RESTRICTIONS) == false) goto L25;
        Bundle r9 = this.mGuestRestrictions;     // Catch: Throwable -> L8 Exception -> L10
        monitor-enter(r9);     // Catch: Throwable -> L8 Exception -> L10
        UserRestrictionsUtils.readRestrictions(parser, this.mGuestRestrictions);     // Catch: Throwable -> L63
        monitor-exit(r9);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8 Exception -> L10
    L67:
        updateUserIds();     // Catch: Throwable -> L8 Exception -> L10
        upgradeIfNecessaryLP();     // Catch: Throwable -> L8 Exception -> L10
        updateUsersWithFeatureFlags(guestRestrictionsArePresentOnUserListXml);     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
    L73:
        th = move-exception;
        throw th;
    L71:
        if (this.mUsers.size() != 0) goto L75;
        Slog.e(LOG_TAG, "mUsers is empty, fallback to single user");     // Catch: Throwable -> L73
        fallbackToSingleUserLP();     // Catch: Throwable -> L73
    L75:
        monitor-exit(r2);     // Catch: Throwable -> L73
        return;
    L10:
        e = move-exception;
        file.failRead(null, e);     // Catch: Throwable -> L8
        readUserListLP();     // Catch: Throwable -> L8
        file.close();
        return;
    L8:
        th = move-exception;
        if (file != null) goto L92;
    L88:
        throw th;
    L92:
        file.close();     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        th.addSuppressed(th);
        goto L88
    }

    private void upgradeIfNecessaryLP() {
        upgradeIfNecessaryLP(this.mUserVersion, this.mUserTypeVersion);
    }

    private void updateUsersWithFeatureFlags(boolean guestRestrictionsArePresentOnUserListXml) {
        if (guestRestrictionsArePresentOnUserListXml != true) goto L10;
        int[] r0 = getUserIds();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        int userId = r0[r2];
        writeUserLP(getUserDataNoChecks(userId));
        r2 = r2 + 1;
        goto L5
    L7:
        writeUserListLP();
        return;
    }

    void upgradeIfNecessaryLP(int userVersion, int userTypeVersion) {
        Slog.i(LOG_TAG, "Upgrading users from userVersion " + userVersion + " to 11");
        Set<Integer> userIdsToWrite = new ArraySet();
        int originalVersion = this.mUserVersion;
        int originalUserTypeVersion = this.mUserTypeVersion;
        if (userVersion >= 1) goto L9;
        UserData userData = getUserDataNoChecks(0);
        if ("Primary".equals(userData.info.name) == false) goto L7;
        userData.info.name = getContextResources().getString(R.string.permdesc_useFingerprint);
        userIdsToWrite.add(Integer.valueOf(userData.info.id));
    L7:
        userVersion = 1;
    L9:
        if (userVersion >= 2) goto L15;
        UserData userData2 = getUserDataNoChecks(0);
        if ((userData2.info.flags & 16) != 0) goto L13;
        userData2.info.flags |= 16;
        userIdsToWrite.add(Integer.valueOf(userData2.info.id));
    L13:
        userVersion = 2;
    L15:
        if (userVersion >= 4) goto L18;
        userVersion = 4;
    L18:
        if (userVersion >= 5) goto L21;
        initDefaultGuestRestrictions();
        userVersion = 5;
    L21:
        if (userVersion >= 6) goto L41;
        Object r6 = this.mUsersLock;
        monitor-enter(r6);
        int i = 0;
    L188:
    L32:
        th = move-exception;
        throw th;
    L26:
        if (i >= this.mUsers.size()) goto L36;
        UserData userData3 = this.mUsers.valueAt(i);     // Catch: Throwable -> L32
        if (userData3.info.isRestricted() == false) goto L34;
        if (userData3.info.restrictedProfileParentId != (-10000)) goto L34;
        userData3.info.restrictedProfileParentId = 0;     // Catch: Throwable -> L32
        userIdsToWrite.add(Integer.valueOf(userData3.info.id));     // Catch: Throwable -> L32
    L34:
        i = i + 1;     // Catch: Throwable -> L32
        goto L188
    L36:
        monitor-exit(r6);     // Catch: Throwable -> L32
        userVersion = 6;
    L41:
        if (userVersion >= 7) goto L63;
        Object r7 = this.mRestrictionsLock;
        monitor-enter(r7);
    L47:
        th = move-exception;
        throw th;
    L45:
        if (this.mDevicePolicyUserRestrictions.removeRestrictionsForAllUsers("ensure_verify_apps") == false) goto L49;
        this.mDevicePolicyUserRestrictions.getRestrictionsNonNull(-1).putBoolean("ensure_verify_apps", true);     // Catch: Throwable -> L47
    L49:
        monitor-exit(r7);     // Catch: Throwable -> L47
        List<UserInfo> guestUsers = getGuestUsers();
        int i2 = 0;
    L52:
        if (i2 >= guestUsers.size()) goto L59;
        UserInfo guestUser = guestUsers.get(i2);
        if (guestUser == null) goto L58;
        if (hasUserRestriction("no_config_wifi", guestUser.id) == true) goto L58;
        setUserRestriction("no_config_wifi", true, guestUser.id);
    L58:
        i2 = i2 + 1;
        goto L52
    L59:
        userVersion = 7;
    L63:
        if (userVersion >= 8) goto L84;
        Object r5 = this.mUsersLock;
        monitor-enter(r5);
        UserData userData4 = this.mUsers.get(0);     // Catch: Throwable -> L69
        userData4.info.flags |= 2048;     // Catch: Throwable -> L69
        if (isDefaultHeadlessSystemUserMode() == true) goto L71;
        userData4.info.flags |= 1024;     // Catch: Throwable -> L69
    L71:
        userIdsToWrite.add(Integer.valueOf(userData4.info.id));     // Catch: Throwable -> L69
        int i3 = 1;
    L73:
        if (i3 >= this.mUsers.size()) goto L79;
        UserData userData5 = this.mUsers.valueAt(i3);     // Catch: Throwable -> L69
        if ((userData5.info.flags & 32) != 0) goto L77;
        userData5.info.flags |= 1024;     // Catch: Throwable -> L69
        userIdsToWrite.add(Integer.valueOf(userData5.info.id));     // Catch: Throwable -> L69
    L77:
        i3 = i3 + 1;     // Catch: Throwable -> L69
        goto L73
    L79:
        monitor-exit(r5);     // Catch: Throwable -> L69
        userVersion = 8;
    L69:
        th = move-exception;
        throw th;
    L84:
        if (userVersion >= 9) goto L114;
        Object r8 = this.mUsersLock;
        monitor-enter(r8);
        int i4 = 0;
    L185:
    L95:
        th = move-exception;
        throw th;
    L89:
        if (i4 >= this.mUsers.size()) goto L109;
        UserData userData6 = this.mUsers.valueAt(i4);     // Catch: Throwable -> L95
        int flags = userData6.info.flags;     // Catch: Throwable -> L95
        if ((flags & 2048) != 0) goto L93;
        userData6.info.userType = UserInfo.getDefaultUserType(flags);     // Catch: Throwable -> L95 IllegalArgumentException -> L105
    L100:
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userData6.info.userType);     // Catch: Throwable -> L95
        if (userTypeDetails == null) goto L104;
        userData6.info.flags |= userTypeDetails.getDefaultUserInfoFlags();     // Catch: Throwable -> L95
        userIdsToWrite.add(Integer.valueOf(userData6.info.id));     // Catch: Throwable -> L95
        i4 = i4 + 1;     // Catch: Throwable -> L95
        goto L185
    L104:
        throw new IllegalStateException("Cannot upgrade user with flags " + Integer.toHexString(flags) + " because " + userData6.info.userType + " isn't defined on this device!");     // Catch: Throwable -> L95
    L105:
        e = move-exception;
        throw new IllegalStateException("Cannot upgrade user with flags " + Integer.toHexString(flags) + " because it doesn't correspond to a valid user type.", e);     // Catch: Throwable -> L95
    L93:
        if ((flags & 1024) == 0) goto L97;
        userData6.info.userType = "android.os.usertype.full.SYSTEM";     // Catch: Throwable -> L95
        goto L100
    L97:
        userData6.info.userType = "android.os.usertype.system.HEADLESS";     // Catch: Throwable -> L95
        goto L100
    L109:
        monitor-exit(r8);     // Catch: Throwable -> L95
        userVersion = 9;
    L114:
        if (userVersion >= 10) goto L132;
        Object r9 = this.mUsersLock;
        monitor-enter(r9);
        int i5 = 0;
    L184:
    L123:
        th = move-exception;
        throw th;
    L119:
        if (i5 >= this.mUsers.size()) goto L128;
        UserData userData7 = this.mUsers.valueAt(i5);     // Catch: Throwable -> L123
        UserTypeDetails userTypeDetails2 = this.mUserTypes.get(userData7.info.userType);     // Catch: Throwable -> L123
        if (userTypeDetails2 == null) goto L126;
        userData7.userProperties = new UserProperties(userTypeDetails2.getDefaultUserPropertiesReference());     // Catch: Throwable -> L123
        userIdsToWrite.add(Integer.valueOf(userData7.info.id));     // Catch: Throwable -> L123
        i5 = i5 + 1;     // Catch: Throwable -> L123
        goto L184
    L126:
        throw new IllegalStateException("Cannot upgrade user because " + userData7.info.userType + " isn't defined on this device!");     // Catch: Throwable -> L123
    L128:
        monitor-exit(r9);     // Catch: Throwable -> L123
        userVersion = 10;
    L132:
        if (userVersion < 11) goto L134;
    L149:
        int newUserTypeVersion = UserTypeFactory.getUserTypeVersion();
        if (newUserTypeVersion <= userTypeVersion) goto L159;
        Object r10 = this.mUsersLock;
        monitor-enter(r10);
        upgradeUserTypesLU(UserTypeFactory.getUserTypeUpgrades(), this.mUserTypes, userTypeVersion, userIdsToWrite);     // Catch: Throwable -> L156
        monitor-exit(r10);     // Catch: Throwable -> L156
    L156:
        th = move-exception;
        throw th;
    L159:
        if (userVersion >= 11) goto L161;
        Slog.w(LOG_TAG, "User version " + this.mUserVersion + " didn't upgrade as expected to 11");
        return;
    L161:
        if (userVersion <= 11) goto L163;
        Slog.wtf(LOG_TAG, "Upgraded user version " + this.mUserVersion + " is higher the SDK's one of 11. Someone forgot to update USER_VERSION?");
    L163:
        this.mUserVersion = userVersion;
        this.mUserTypeVersion = newUserTypeVersion;
        if (originalVersion >= this.mUserVersion) goto L166;
    L167:
        Iterator<Integer> r2 = userIdsToWrite.iterator();
    L169:
        if (r2.hasNext() == false) goto L174;
        int userId = r2.next().intValue();
        UserData userData8 = getUserDataNoChecks(userId);
        if (userData8 == null) goto L169;
        writeUserLP(userData8);
        goto L169
    L174:
        writeUserListLP();
        return;
    L166:
        if (originalUserTypeVersion < this.mUserTypeVersion) goto L167;
        return;
    L134:
        if (isHeadlessSystemUserMode() == true) goto L136;
        Object r11 = this.mUsersLock;
        monitor-enter(r11);
        UserData userData9 = this.mUsers.get(0);     // Catch: Throwable -> L146
        userData9.info.flags |= 16384;     // Catch: Throwable -> L146
        userIdsToWrite.add(Integer.valueOf(userData9.info.id));     // Catch: Throwable -> L146
        monitor-exit(r11);     // Catch: Throwable -> L146
    L145:
        userVersion = 11;
    L146:
        th = move-exception;
        throw th;
    L136:
        if (isMainUserPermanentAdmin() == false) goto L145;
        UserInfo earliestCreatedUser = getEarliestCreatedFullUser();
        if (earliestCreatedUser == null) goto L145;
        earliestCreatedUser.flags |= 16384;
        userIdsToWrite.add(Integer.valueOf(earliestCreatedUser.id));
        goto L145
    }

    private void upgradeUserTypesLU(List<UserTypeFactory.UserTypeUpgrade> upgradeOps, ArrayMap<String, UserTypeDetails> userTypes, int formerUserTypeVersion, Set<Integer> userIdsToWrite) {
        Iterator<UserTypeFactory.UserTypeUpgrade> r0 = upgradeOps.iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        UserTypeFactory.UserTypeUpgrade userTypeUpgrade = r0.next();
        if (formerUserTypeVersion > userTypeUpgrade.getUpToVersion()) goto L4;
        int i = 0;
    L9:
        if (i >= this.mUsers.size()) goto L4;
        UserData userData = this.mUsers.valueAt(i);
        if (userTypeUpgrade.getFromType().equals(userData.info.userType) == false) goto L17;
        UserTypeDetails newUserType = userTypes.get(userTypeUpgrade.getToType());
        if (newUserType == null) goto L16;
        upgradeProfileToTypeLU(userData.info, newUserType);
        userIdsToWrite.add(Integer.valueOf(userData.info.id));
        goto L17
    L16:
        throw new IllegalStateException("Upgrade destination user type not defined: " + userTypeUpgrade.getToType());
    L17:
        i = i + 1;
        goto L9
    }

    void upgradeProfileToTypeLU(UserInfo userInfo, UserTypeDetails newUserType) {
        Slog.i(LOG_TAG, "Upgrading user " + userInfo.id + " from " + userInfo.userType + " to " + newUserType.getName());
        if (userInfo.isProfile() == false) goto L24;
        if (canAddMoreProfilesToUser(newUserType.getName(), userInfo.profileGroupId, false) == true) goto L7;
        Slog.w(LOG_TAG, "Exceeded maximum profiles of type " + newUserType.getName() + " for user " + userInfo.id + ". Maximum allowed= " + newUserType.getMaxAllowedPerParent());
    L7:
        UserTypeDetails oldUserType = this.mUserTypes.get(userInfo.userType);
        if (oldUserType == null) goto L10;
        int oldFlags = oldUserType.getDefaultUserInfoFlags();
    L11:
        userInfo.userType = newUserType.getName();
        userInfo.flags = newUserType.getDefaultUserInfoFlags() | (userInfo.flags ^ oldFlags);
        Object r2 = this.mRestrictionsLock;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (BundleUtils.isEmpty(newUserType.getDefaultRestrictions()) == true) goto L18;
        Bundle newRestrictions = BundleUtils.clone(this.mBaseUserRestrictions.getRestrictions(userInfo.id));     // Catch: Throwable -> L16
        UserRestrictionsUtils.merge(newRestrictions, newUserType.getDefaultRestrictions());     // Catch: Throwable -> L16
        updateUserRestrictionsInternalLR(newRestrictions, userInfo.id);     // Catch: Throwable -> L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L16
        userInfo.profileBadge = getFreeProfileBadgeLU(userInfo.profileGroupId, userInfo.userType);
        return;
    L10:
        oldFlags = 4096;
        goto L11
    L24:
        throw new IllegalStateException("Can only upgrade profile types. " + userInfo.userType + " is not a profile type.");
    }

    private UserInfo getEarliestCreatedFullUser() {
        List<UserInfo> users = getUsersInternal(true, true, true);
        UserInfo earliestUser = null;
        long earliestCreationTime = Long.MAX_VALUE;
        int i = 0;
    L4:
        if (i >= users.size()) goto L16;
        UserInfo info = users.get(i);
        if (info.isFull() == false) goto L14;
        if (info.isAdmin() == false) goto L14;
        if (info.creationTime < 0) goto L14;
        if (info.creationTime >= earliestCreationTime) goto L14;
        earliestCreationTime = info.creationTime;
        earliestUser = info;
    L14:
        i = i + 1;
        goto L4
    L16:
        return earliestUser;
    }

    private void fallbackToSingleUserLP() {
        if (isDefaultHeadlessSystemUserMode() == false) goto L5;
        String r0 = "android.os.usertype.system.HEADLESS";
    L6:
        String systemUserType = r0;
        int flags = this.mUserTypes.get(systemUserType).getDefaultUserInfoFlags() | 16;
        UserInfo system = new UserInfo(0, null, null, flags, systemUserType);
        UserData userData = putUserInfo(system);
        userData.userProperties = new UserProperties(this.mUserTypes.get(userData.info.userType).getDefaultUserPropertiesReference());
        this.mNextSerialNumber = 11;
        this.mUserVersion = 11;
        this.mUserTypeVersion = UserTypeFactory.getUserTypeVersion();
        Bundle restrictions = new Bundle();
        String[] defaultFirstUserRestrictions = getContextResources().getStringArray(R.array.config_displayCutoutApproximationRectArray);     // Catch: Resources.NotFoundException -> L13
        int r7 = defaultFirstUserRestrictions.length;     // Catch: Resources.NotFoundException -> L13
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L19;
        String userRestriction = defaultFirstUserRestrictions[r8];     // Catch: Resources.NotFoundException -> L13
        if (UserRestrictionsUtils.isValidRestriction(userRestriction) == false) goto L15;
        restrictions.putBoolean(userRestriction, true);     // Catch: Resources.NotFoundException -> L13
    L15:
        r8 = r8 + 1;
    L19:
        if (restrictions.isEmpty() == true) goto L28;
        Object r9 = this.mRestrictionsLock;
        monitor-enter(r9);
        this.mBaseUserRestrictions.updateRestrictions(0, restrictions);     // Catch: Throwable -> L25
        monitor-exit(r9);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    L28:
        initDefaultGuestRestrictions();
        writeUserLP(userData);
        writeUserListLP();
        return;
    L13:
        e = move-exception;
        Slog.e(LOG_TAG, "Couldn't find resource: config_defaultFirstUserRestrictions", e);
        goto L19
    L5:
        r0 = "android.os.usertype.full.SYSTEM";
        goto L6
    }

    private String getOwnerName() {
        return this.mOwnerName.get();
    }

    private String getGuestName() {
        return this.mContext.getString(R.string.indeterminate_progress_55);
    }

    private void invalidateOwnerNameIfNecessary(Resources res, boolean forceUpdate) {
        int configChanges = this.mLastConfiguration.updateFrom(res.getConfiguration());
        if (forceUpdate == false) goto L5;
    L6:
        res.getValue(R.string.permdesc_useFingerprint, this.mOwnerNameTypedValue, true);
        CharSequence ownerName = this.mOwnerNameTypedValue.coerceToString();
        AtomicReference<String> r2 = this.mOwnerName;
        if (ownerName == null) goto L9;
        String r3 = ownerName.toString();
    L10:
        r2.set(r3);
        UserManager.invalidateCacheOnUserDataChanged();
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        if ((this.mOwnerNameTypedValue.changingConfigurations & configChanges) != 0) goto L6;
    }

    private void scheduleWriteUserList() {
        if (this.mHandler.hasMessages(2) == true) goto L5;
        Message msg = this.mHandler.obtainMessage(2);
        this.mHandler.sendMessageDelayed(msg, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    L5:
        UserManager.invalidateCacheOnUserDataChanged();
    }

    private void scheduleWriteUser(int userId) {
        if (this.mHandler.hasMessages(1, Integer.valueOf(userId)) == true) goto L5;
        Message msg = this.mHandler.obtainMessage(1, Integer.valueOf(userId));
        this.mHandler.sendMessageDelayed(msg, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    L5:
        UserManager.invalidateCacheOnUserDataChanged();
    }

    private ResilientAtomicFile getUserFile(final int userId) {
        File file = new File(this.mUsersDir, userId + XML_SUFFIX);
        File tempBackup = new File(this.mUsersDir, userId + XML_SUFFIX + ".backup");
        File reserveCopy = new File(this.mUsersDir, userId + XML_SUFFIX + ".reservecopy");
        return new ResilientAtomicFile(file, tempBackup, reserveCopy, 505, "user info", new UserManagerService$$ExternalSyntheticLambda3(this, userId));
    }

    private /* synthetic */ void lambda$getUserFile$5(int userId, int priority, String msg) {
        Slog.e(LOG_TAG, msg);
        UserData userData = getUserDataNoChecks(userId);
        if (userData == null) goto L6;
        scheduleWriteUser(userId);
        return;
    }

    private void writeUserLP(UserData userData) {
        UserManager.invalidateCacheOnUserDataChanged();
        ResilientAtomicFile userFile = getUserFile(userData.info.id);
        FileOutputStream fos = null;
        fos = userFile.startWrite();     // Catch: Throwable -> L5 Exception -> L7
        writeUserLP(userData, fos);     // Catch: Throwable -> L5 Exception -> L7
        userFile.finishWrite(fos);     // Catch: Throwable -> L5 Exception -> L7
    L9:
        if (userFile == null) goto L23;
        userFile.close();
        return;
    L23:
        return;
    L7:
        ioe = move-exception;
        Slog.e(LOG_TAG, "Error writing user info " + userData.info.id, ioe);     // Catch: Throwable -> L5
        userFile.failWrite(fos);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        if (userFile != null) goto L18;
    L17:
        throw th;
    L18:
        userFile.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    void writeUserLP(UserData userData, OutputStream os) throws IOException, XmlPullParserException {
        TypedXmlSerializer serializer = Xml.resolveSerializer(os);
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        UserInfo userInfo = userData.info;
        serializer.startTag(null, TAG_USER);
        serializer.attributeInt(null, ATTR_ID, userInfo.id);
        serializer.attributeInt(null, ATTR_SERIAL_NO, userInfo.serialNumber);
        serializer.attributeInt(null, ATTR_FLAGS, userInfo.flags);
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, userInfo.userType);
        serializer.attributeLong(null, ATTR_CREATION_TIME, userInfo.creationTime);
        serializer.attributeLong(null, ATTR_LAST_LOGGED_IN_TIME, userInfo.lastLoggedInTime);
        if (userInfo.lastLoggedInFingerprint == null) goto L5;
        serializer.attribute(null, ATTR_LAST_LOGGED_IN_FINGERPRINT, userInfo.lastLoggedInFingerprint);
    L5:
        serializer.attributeLong(null, ATTR_LAST_ENTERED_FOREGROUND_TIME, userData.mLastEnteredForegroundTimeMillis);
        if (userInfo.iconPath == null) goto L9;
        serializer.attribute(null, ATTR_ICON_PATH, userInfo.iconPath);
    L9:
        if (userInfo.partial == false) goto L12;
        serializer.attributeBoolean(null, ATTR_PARTIAL, true);
    L12:
        if (userInfo.preCreated == false) goto L15;
        serializer.attributeBoolean(null, ATTR_PRE_CREATED, true);
    L15:
        if (userInfo.convertedFromPreCreated == false) goto L18;
        serializer.attributeBoolean(null, ATTR_CONVERTED_FROM_PRE_CREATED, true);
    L18:
        if (userInfo.guestToRemove == false) goto L21;
        serializer.attributeBoolean(null, ATTR_GUEST_TO_REMOVE, true);
    L21:
        if (userInfo.profileGroupId == (-10000)) goto L23;
        serializer.attributeInt(null, ATTR_PROFILE_GROUP_ID, userInfo.profileGroupId);
    L23:
        serializer.attributeInt(null, ATTR_PROFILE_BADGE, userInfo.profileBadge);
        if (userInfo.restrictedProfileParentId == (-10000)) goto L27;
        serializer.attributeInt(null, ATTR_RESTRICTED_PROFILE_PARENT_ID, userInfo.restrictedProfileParentId);
    L27:
        if (userData.persistSeedData == false) goto L35;
        if (userData.seedAccountName == null) goto L32;
        serializer.attribute(null, ATTR_SEED_ACCOUNT_NAME, truncateString(userData.seedAccountName, 500));
    L32:
        if (userData.seedAccountType == null) goto L35;
        serializer.attribute(null, ATTR_SEED_ACCOUNT_TYPE, truncateString(userData.seedAccountType, 500));
    L35:
        if (userInfo.name == null) goto L37;
        serializer.startTag(null, "name");
        serializer.text(truncateString(userInfo.name, 100));
        serializer.endTag(null, "name");
    L37:
        Object r1 = this.mRestrictionsLock;
        monitor-enter(r1);
        UserRestrictionsUtils.writeRestrictions(serializer, this.mBaseUserRestrictions.getRestrictions(userInfo.id), TAG_RESTRICTIONS);     // Catch: Throwable -> L47
        if (userInfo.id != 0) goto L52;
        UserRestrictionsUtils.writeRestrictions(serializer, this.mDevicePolicyUserRestrictions.getRestrictions(-1), TAG_DEVICE_POLICY_GLOBAL_RESTRICTIONS);     // Catch: Throwable -> L47
        serializer.startTag(null, TAG_GUEST_RESTRICTIONS);     // Catch: Throwable -> L47
        Bundle r4 = this.mGuestRestrictions;     // Catch: Throwable -> L47
        monitor-enter(r4);     // Catch: Throwable -> L47
        UserRestrictionsUtils.writeRestrictions(serializer, this.mGuestRestrictions, TAG_RESTRICTIONS);     // Catch: Throwable -> L49
        monitor-exit(r4);     // Catch: Throwable -> L49
        serializer.endTag(null, TAG_GUEST_RESTRICTIONS);     // Catch: Throwable -> L47
        goto L52
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L47
    L52:
        UserRestrictionsUtils.writeRestrictions(serializer, this.mDevicePolicyUserRestrictions.getRestrictions(userInfo.id), TAG_DEVICE_POLICY_LOCAL_RESTRICTIONS);     // Catch: Throwable -> L47
        monitor-exit(r1);     // Catch: Throwable -> L47
        if (userData.account == null) goto L58;
        serializer.startTag(null, TAG_ACCOUNT);
        serializer.text(userData.account);
        serializer.endTag(null, TAG_ACCOUNT);
    L58:
        if (userData.persistSeedData == false) goto L63;
        if (userData.seedAccountOptions == null) goto L63;
        serializer.startTag(null, TAG_SEED_ACCOUNT_OPTIONS);
        userData.seedAccountOptions.saveToXml(serializer);
        serializer.endTag(null, TAG_SEED_ACCOUNT_OPTIONS);
    L63:
        if (userData.userProperties == null) goto L66;
        serializer.startTag(null, TAG_USER_PROPERTIES);
        userData.userProperties.writeToXml(serializer);
        serializer.endTag(null, TAG_USER_PROPERTIES);
    L66:
        if (userData.getLastRequestQuietModeEnabledMillis() == 0) goto L68;
        serializer.startTag(null, TAG_LAST_REQUEST_QUIET_MODE_ENABLED_CALL);
        serializer.text(String.valueOf(userData.getLastRequestQuietModeEnabledMillis()));
        serializer.endTag(null, TAG_LAST_REQUEST_QUIET_MODE_ENABLED_CALL);
    L68:
        serializer.startTag(null, TAG_IGNORE_PREPARE_STORAGE_ERRORS);
        serializer.text(String.valueOf(userData.getIgnorePrepareStorageErrors()));
        serializer.endTag(null, TAG_IGNORE_PREPARE_STORAGE_ERRORS);
        serializer.endTag(null, TAG_USER);
        serializer.endDocument();
        return;
    L47:
        th = move-exception;
        throw th;
    }

    private String truncateString(String original, int limit) {
        if (original != null) goto L4;
    L8:
        return original;
    L4:
        if (original.length() <= limit) goto L8;
        return original.substring(0, limit);
    }

    private void writeUserListLP() {
        UserManager.invalidateCacheOnUserDataChanged();
        ResilientAtomicFile file = getUserListFile();
        FileOutputStream fos = file.startWrite();     // Catch: Throwable -> L16 Exception -> L18
        TypedXmlSerializer serializer = Xml.resolveSerializer(fos);     // Catch: Throwable -> L16 Exception -> L18
        serializer.startDocument(null, true);     // Catch: Throwable -> L16 Exception -> L18
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Throwable -> L16 Exception -> L18
        serializer.startTag(null, "users");     // Catch: Throwable -> L16 Exception -> L18
        serializer.attributeInt(null, ATTR_NEXT_SERIAL_NO, this.mNextSerialNumber);     // Catch: Throwable -> L16 Exception -> L18
        serializer.attributeInt(null, ATTR_USER_VERSION, this.mUserVersion);     // Catch: Throwable -> L16 Exception -> L18
        serializer.attributeInt(null, ATTR_USER_TYPE_VERSION, this.mUserTypeVersion);     // Catch: Throwable -> L16 Exception -> L18
        Object r3 = this.mUsersLock;     // Catch: Throwable -> L16 Exception -> L18
        monitor-enter(r3);     // Catch: Throwable -> L16 Exception -> L18
        int[] userIdsToWrite = new int[this.mUsers.size()];     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= userIdsToWrite.length) goto L12;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L9
        userIdsToWrite[i] = user.id;     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L12:
        monitor-exit(r3);     // Catch: Throwable -> L9
        int r4 = userIdsToWrite.length;     // Catch: Throwable -> L16 Exception -> L18
        int r6 = 0;
    L14:
        if (r6 >= r4) goto L20;
        int id = userIdsToWrite[r6];     // Catch: Throwable -> L16 Exception -> L18
        serializer.startTag(null, TAG_USER);     // Catch: Throwable -> L16 Exception -> L18
        serializer.attributeInt(null, ATTR_ID, id);     // Catch: Throwable -> L16 Exception -> L18
        serializer.endTag(null, TAG_USER);     // Catch: Throwable -> L16 Exception -> L18
        r6 = r6 + 1;     // Catch: Throwable -> L16 Exception -> L18
        goto L14
    L20:
        serializer.endTag(null, "users");     // Catch: Throwable -> L16 Exception -> L18
        serializer.endDocument();     // Catch: Throwable -> L16 Exception -> L18
        file.finishWrite(fos);     // Catch: Throwable -> L16 Exception -> L18
    L26:
        if (file == null) goto L43;
        file.close();
        return;
    L43:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16 Exception -> L18
    L18:
        e = move-exception;
        Slog.e(LOG_TAG, "Error writing user list", e);     // Catch: Throwable -> L16
        file.failWrite(null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (file != null) goto L36;
    L34:
        throw th;
    L36:
        file.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    }

    private UserData readUserLP(int id, int userVersion) {
        ResilientAtomicFile file = getUserFile(id);
        FileInputStream fis = file.openRead();     // Catch: Throwable -> L8 Exception -> L10
        if (fis != null) goto L12;
        Slog.e(LOG_TAG, "User info not found, returning null, user id: " + id);     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return null;
    L12:
        UserData r0 = readUserLP(id, fis, userVersion);     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return r0;
    L10:
        e = move-exception;
        Slog.e(LOG_TAG, "Error reading user info, user id: " + id);     // Catch: Throwable -> L8
        file.failRead(null, e);     // Catch: Throwable -> L8
        UserData r1 = readUserLP(id, userVersion);     // Catch: Throwable -> L8
        file.close();
        return r1;
    L8:
        th = move-exception;
        if (file != null) goto L27;
    L24:
        throw th;
    L27:
        file.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    UserData readUserLP(int id, InputStream is, int userVersion) throws IOException, XmlPullParserException {
        int flags = 0;
        String account = null;
        long lastRequestQuietModeEnabledTimestamp = 0;
        boolean persistSeedData = false;
        PersistableBundle seedAccountOptions = null;
        UserProperties userProperties = null;
        Bundle baseRestrictions = null;
        Bundle legacyLocalRestrictions = null;
        Bundle localRestrictions = null;
        Bundle globalRestrictions = null;
        boolean ignorePrepareStorageErrors = true;
        TypedXmlPullParser parser = Xml.resolvePullParser(is);
    L3:
        int type = parser.next();
        int flags2 = flags;
        if (type == 2) goto L8;
        int type2 = type;
        if (type2 == 1) goto L10;
        flags = flags2;
    L10:
        if (type2 == 2) goto L14;
        Slog.e(LOG_TAG, "Unable to read user " + id);
        return null;
    L14:
        if (type2 == 2) goto L16;
    L116:
        String name = null;
        long lastEnteredForegroundTime = 0;
        String iconPath = null;
        String name2 = null;
        String lastLoggedInFingerprint = null;
        long lastLoggedInTime = 0;
        int serialNumber = id;
        int restrictedProfileParentId = 0;
        int profileBadge = -10000;
        long lastRequestQuietModeEnabledTimestamp2 = 0;
        boolean preCreated = false;
        boolean converted = false;
        boolean guestToRemove = false;
        boolean persistSeedData2 = false;
        String seedAccountName = null;
        String seedAccountType = null;
        PersistableBundle seedAccountOptions2 = null;
        UserProperties userProperties2 = null;
        Bundle baseRestrictions2 = null;
        Bundle legacyLocalRestrictions2 = null;
        Bundle localRestrictions2 = null;
        Bundle globalRestrictions2 = null;
        long lastRequestQuietModeEnabledTimestamp3 = 0;
        boolean partial = false;
        int profileGroupId = -10000;
        String account2 = null;
        int flags3 = flags2;
    L117:
        long lastRequestQuietModeEnabledTimestamp4 = lastRequestQuietModeEnabledTimestamp2;
        UserInfo userInfo = new UserInfo(id, name2, name, flags3, iconPath);
        userInfo.serialNumber = serialNumber;
        userInfo.creationTime = lastRequestQuietModeEnabledTimestamp3;
        userInfo.lastLoggedInTime = lastLoggedInTime;
        userInfo.lastLoggedInFingerprint = lastLoggedInFingerprint;
        userInfo.partial = partial;
        userInfo.preCreated = preCreated;
        userInfo.convertedFromPreCreated = converted;
        boolean preCreated2 = guestToRemove;
        userInfo.guestToRemove = preCreated2;
        userInfo.profileGroupId = profileGroupId;
        int profileGroupId2 = restrictedProfileParentId;
        userInfo.profileBadge = profileGroupId2;
        userInfo.restrictedProfileParentId = profileBadge;
        UserData userData = new UserData();
        userData.info = userInfo;
        userData.account = account2;
        String account3 = seedAccountName;
        userData.seedAccountName = account3;
        String seedAccountName2 = seedAccountType;
        userData.seedAccountType = seedAccountName2;
        userData.persistSeedData = persistSeedData2;
        userData.seedAccountOptions = seedAccountOptions2;
        userData.userProperties = userProperties2;
        userData.setLastRequestQuietModeEnabledMillis(lastRequestQuietModeEnabledTimestamp4);
        long lastRequestQuietModeEnabledTimestamp5 = lastEnteredForegroundTime;
        userData.mLastEnteredForegroundTimeMillis = lastRequestQuietModeEnabledTimestamp5;
        if (ignorePrepareStorageErrors == false) goto L120;
        userData.setIgnorePrepareStorageErrors();
    L120:
        Object r2 = this.mRestrictionsLock;
        monitor-enter(r2);
        Bundle baseRestrictions3 = baseRestrictions2;
        if (baseRestrictions3 != null) goto L157;
    L128:
        Bundle localRestrictions3 = localRestrictions2;
        if (localRestrictions3 != null) goto L155;
        Bundle baseRestrictions4 = legacyLocalRestrictions2;
        if (baseRestrictions4 == null) goto L146;
        this.mDevicePolicyUserRestrictions.updateRestrictions(id, baseRestrictions4);     // Catch: Throwable -> L136
    L162:
    L146:
        Bundle globalRestrictions3 = globalRestrictions2;
        if (globalRestrictions3 == null) goto L151;
        this.mDevicePolicyUserRestrictions.updateRestrictions(-1, globalRestrictions3);     // Catch: Throwable -> L149
    L151:
        monitor-exit(r2);     // Catch: Throwable -> L149
        return userData;
    L155:
        this.mDevicePolicyUserRestrictions.updateRestrictions(id, localRestrictions3);     // Catch: Throwable -> L141
        Bundle baseRestrictions5 = legacyLocalRestrictions2;
        if (baseRestrictions5 == null) goto L146;
        Slog.wtf(LOG_TAG, "Seeing both legacy and current local restrictions in xml");     // Catch: Throwable -> L136
    L141:
        th = th;
    L153:
        monitor-exit(r2);     // Catch: Throwable -> L149
        throw th;
    L136:
        th = th;
        goto L153
    L157:
        this.mBaseUserRestrictions.updateRestrictions(id, baseRestrictions3);     // Catch: Throwable -> L126
    L126:
        th = th;
    L149:
        th = th;
        goto L153
    L16:
        if (parser.getName().equals(TAG_USER) == false) goto L116;
        int storedId = parser.getAttributeInt(null, ATTR_ID, -1);
        if (storedId == id) goto L21;
        Slog.e(LOG_TAG, "User id does not match the file name");
        return null;
    L21:
        int serialNumber2 = parser.getAttributeInt(null, ATTR_SERIAL_NO, id);
        int flags4 = parser.getAttributeInt(null, ATTR_FLAGS, 0);
        String userType = parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
        if (userType == null) goto L24;
        String r0 = userType.intern();
    L25:
        String userType2 = r0;
        String iconPath2 = parser.getAttributeValue(null, ATTR_ICON_PATH);
        long creationTime = parser.getAttributeLong(null, ATTR_CREATION_TIME, 0);
        long lastLoggedInTime2 = parser.getAttributeLong(null, ATTR_LAST_LOGGED_IN_TIME, 0);
        String lastLoggedInFingerprint2 = parser.getAttributeValue(null, ATTR_LAST_LOGGED_IN_FINGERPRINT);
        long lastEnteredForegroundTime2 = parser.getAttributeLong(null, ATTR_LAST_ENTERED_FOREGROUND_TIME, 0);
        int profileGroupId3 = parser.getAttributeInt(null, ATTR_PROFILE_GROUP_ID, ProcessList.INVALID_ADJ);
        int profileBadge2 = parser.getAttributeInt(null, ATTR_PROFILE_BADGE, 0);
        int restrictedProfileParentId2 = parser.getAttributeInt(null, ATTR_RESTRICTED_PROFILE_PARENT_ID, ProcessList.INVALID_ADJ);
        boolean partial2 = parser.getAttributeBoolean(null, ATTR_PARTIAL, false);
        boolean preCreated3 = parser.getAttributeBoolean(null, ATTR_PRE_CREATED, false);
        boolean converted2 = parser.getAttributeBoolean(null, ATTR_CONVERTED_FROM_PRE_CREATED, false);
        boolean guestToRemove2 = parser.getAttributeBoolean(null, ATTR_GUEST_TO_REMOVE, false);
        String seedAccountName3 = parser.getAttributeValue(null, ATTR_SEED_ACCOUNT_NAME);
        String seedAccountType2 = parser.getAttributeValue(null, ATTR_SEED_ACCOUNT_TYPE);
        if (seedAccountName3 != null) goto L28;
        if (seedAccountType2 != null) goto L28;
    L29:
        int outerDepth = parser.getDepth();
        String name3 = null;
    L30:
        int type3 = parser.next();
        if (type3 == 1) goto L115;
        if (type3 == 3) goto L35;
    L38:
        if (type3 == 3) goto L113;
        if (type3 == 4) goto L113;
        String tag = parser.getName();
        if ("name".equals(tag) == false) goto L49;
        int type4 = parser.next();
        if (type4 != 4) goto L47;
        name3 = parser.getText();
        int outerDepth2 = outerDepth;
    L111:
        outerDepth = outerDepth2;
        goto L30
    L47:
        outerDepth2 = outerDepth;
        goto L111
    L49:
        if (TAG_RESTRICTIONS.equals(tag) == false) goto L52;
        baseRestrictions = UserRestrictionsUtils.readRestrictions(parser);
        outerDepth2 = outerDepth;
        type4 = type3;
        goto L111
    L52:
        if (TAG_DEVICE_POLICY_RESTRICTIONS.equals(tag) == false) goto L55;
        legacyLocalRestrictions = UserRestrictionsUtils.readRestrictions(parser);
        outerDepth2 = outerDepth;
        type4 = type3;
        goto L111
    L55:
        if (TAG_DEVICE_POLICY_LOCAL_RESTRICTIONS.equals(tag) == false) goto L61;
        if (userVersion >= 10) goto L59;
        RestrictionsSet oldLocalRestrictions = RestrictionsSet.readRestrictions(parser, TAG_DEVICE_POLICY_LOCAL_RESTRICTIONS);
        Bundle localRestrictions4 = oldLocalRestrictions.mergeAll();
        localRestrictions = localRestrictions4;
        outerDepth2 = outerDepth;
        type4 = type3;
        goto L111
    L59:
        Bundle localRestrictions5 = UserRestrictionsUtils.readRestrictions(parser);
        localRestrictions = localRestrictions5;
        outerDepth2 = outerDepth;
        type4 = type3;
        goto L111
    L61:
        if (TAG_DEVICE_POLICY_GLOBAL_RESTRICTIONS.equals(tag) == false) goto L64;
        globalRestrictions = UserRestrictionsUtils.readRestrictions(parser);
        outerDepth2 = outerDepth;
        type4 = type3;
        goto L111
    L64:
        if (TAG_GUEST_RESTRICTIONS.equals(tag) == false) goto L84;
    L65:
        int r1 = parser.next();
        int type5 = r1;
        outerDepth2 = outerDepth;
        if (r1 == 1) goto L83;
        if (type5 == 3) goto L82;
        if (type5 == 2) goto L71;
        outerDepth = outerDepth2;
        goto L65
    L71:
        type5 = type5;
        if (parser.getName().equals(TAG_RESTRICTIONS) == false) goto L83;
        Bundle r3 = this.mGuestRestrictions;
        monitor-enter(r3);
        UserRestrictionsUtils.readRestrictions(parser, this.mGuestRestrictions);     // Catch: Throwable -> L78
        monitor-exit(r3);     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;
    L82:
        type5 = type5;
    L83:
        type4 = type5;
        goto L111
    L84:
        outerDepth2 = outerDepth;
        if (TAG_ACCOUNT.equals(tag) == false) goto L91;
        type4 = parser.next();
        if (type4 != 4) goto L111;
        account = parser.getText();
        goto L111
    L91:
        if (TAG_SEED_ACCOUNT_OPTIONS.equals(tag) == false) goto L94;
        PersistableBundle seedAccountOptions3 = PersistableBundle.restoreFromXml(parser);
        persistSeedData = true;
        seedAccountOptions = seedAccountOptions3;
        type4 = type3;
        goto L111
    L94:
        if (TAG_USER_PROPERTIES.equals(tag) == false) goto L101;
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType2);
        if (userTypeDetails == null) goto L97;
        UserProperties defaultProps = userTypeDetails.getDefaultUserPropertiesReference();
        UserProperties userProperties3 = new UserProperties(parser, defaultProps);
        userProperties = userProperties3;
        type4 = type3;
        goto L111
    L97:
        Slog.e(LOG_TAG, "User has properties but no user type!");
        return null;
    L101:
        if (TAG_LAST_REQUEST_QUIET_MODE_ENABLED_CALL.equals(tag) == false) goto L106;
        type4 = parser.next();
        if (type4 != 4) goto L111;
        lastRequestQuietModeEnabledTimestamp = Long.parseLong(parser.getText());
        goto L111
    L106:
        if (TAG_IGNORE_PREPARE_STORAGE_ERRORS.equals(tag) == false) goto L110;
        type4 = parser.next();
        if (type4 != 4) goto L111;
        ignorePrepareStorageErrors = Boolean.parseBoolean(parser.getText());
        goto L111
    L110:
        type4 = type3;
    L113:
        outerDepth = outerDepth;
        goto L30
    L35:
        if (parser.getDepth() > outerDepth) goto L38;
    L115:
        name2 = name3;
        name = iconPath2;
        lastEnteredForegroundTime = lastEnteredForegroundTime2;
        iconPath = userType2;
        lastLoggedInFingerprint = lastLoggedInFingerprint2;
        lastLoggedInTime = lastLoggedInTime2;
        serialNumber = serialNumber2;
        restrictedProfileParentId = profileBadge2;
        profileBadge = restrictedProfileParentId2;
        preCreated = preCreated3;
        converted = converted2;
        guestToRemove = guestToRemove2;
        persistSeedData2 = persistSeedData;
        seedAccountName = seedAccountName3;
        seedAccountType = seedAccountType2;
        seedAccountOptions2 = seedAccountOptions;
        userProperties2 = userProperties;
        baseRestrictions2 = baseRestrictions;
        legacyLocalRestrictions2 = legacyLocalRestrictions;
        localRestrictions2 = localRestrictions;
        globalRestrictions2 = globalRestrictions;
        lastRequestQuietModeEnabledTimestamp2 = lastRequestQuietModeEnabledTimestamp;
        lastRequestQuietModeEnabledTimestamp3 = creationTime;
        partial = partial2;
        profileGroupId = profileGroupId3;
        account2 = account;
        flags3 = flags4;
    L28:
        persistSeedData = true;
        goto L29
    L24:
        r0 = null;
        goto L25
    L8:
        type2 = type;
        goto L10
    }

    private static boolean cleanAppRestrictionsForPackageLAr(String pkg, int userId) {
        File dir = Environment.getUserSystemDirectory(userId);
        File resFile = new File(dir, packageToRestrictionsFileName(pkg));
        if (resFile.exists() == false) goto L6;
        resFile.delete();
        return true;
    L6:
        return false;
    }

    public UserInfo createProfileForUserWithThrow(String name, String userType, int flags, int userId, String[] disallowedPackages) throws ServiceSpecificException {
        checkCreateUsersPermission(flags);
        return createUserInternal(name, userType, flags, userId, disallowedPackages);
    L5:
        e = move-exception;
        throw e.toServiceSpecificException();
    }

    public UserInfo createProfileForUserEvenWhenDisallowedWithThrow(String name, String userType, int flags, int userId, String[] disallowedPackages) throws ServiceSpecificException {
        checkCreateUsersPermission(flags);
        return createUserInternalUnchecked(name, userType, flags, userId, false, disallowedPackages, null);
    L5:
        e = move-exception;
        throw e.toServiceSpecificException();
    }

    public UserInfo createUserWithThrow(String name, String userType, int flags) throws ServiceSpecificException {
        checkCreateUsersPermission(flags);
        return createUserInternal(name, userType, flags, ProcessList.INVALID_ADJ, null);
    L5:
        e = move-exception;
        throw e.toServiceSpecificException();
    }

    public UserInfo preCreateUserWithThrow(String userType) throws ServiceSpecificException {
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails == null) goto L5;
        int r0 = userTypeDetails.getDefaultUserInfoFlags();
    L6:
        int flags = r0;
        checkCreateUsersPermission(flags);
        Preconditions.checkArgument(isUserTypeEligibleForPreCreation(userTypeDetails), "cannot pre-create user of type " + userType);
        Slog.i(LOG_TAG, "Pre-creating user of type " + userType);
        return createUserInternalUnchecked(null, userType, flags, ProcessList.INVALID_ADJ, true, null, null);
    L9:
        e = move-exception;
        throw e.toServiceSpecificException();
    L5:
        r0 = 0;
        goto L6
    }

    public UserHandle createUserWithAttributes(String userName, String userType, int flags, Bitmap userIcon, String accountName, String accountType, PersistableBundle accountOptions) throws ServiceSpecificException {
        checkCreateUsersPermission(flags);
        if (someUserHasAccountNoChecks(accountName, accountType) == true) goto L15;
        UserInfo userInfo = createUserInternal(userName, userType, flags, ProcessList.INVALID_ADJ, null);     // Catch: UserManager.CheckedUserOperationException -> L11
        if (userIcon == null) goto L9;
        this.mLocalService.setUserIcon(userInfo.id, userIcon);
    L9:
        setSeedAccountDataNoChecks(userInfo.id, accountName, accountType, accountOptions, true);
        return userInfo.getUserHandle();
    L11:
        e = move-exception;
        throw e.toServiceSpecificException();
    L15:
        throw new ServiceSpecificException(7);
    }

    private UserInfo createUserInternal(String name, String userType, int flags, int parentId, String[] disallowedPackages) throws UserManager.CheckedUserOperationException {
        if (UserManager.isUserTypeCloneProfile(userType) == false) goto L6;
        String restriction = "no_add_clone_profile";
    L12:
        enforceUserRestriction(restriction, UserHandle.getCallingUserId(), "Cannot add user");
        if ((flags & 2) == 0) goto L16;
        enforceUserRestriction("no_grant_admin", UserHandle.getCallingUserId(), "Cannot create ADMIN user");
    L16:
        return createUserInternalUnchecked(name, userType, flags, parentId, false, disallowedPackages, null);
    L6:
        if (UserManager.isUserTypeManagedProfile(userType) == false) goto L9;
        restriction = "no_add_managed_profile";
        goto L12
    L9:
        if (UserManager.isUserTypePrivateProfile(userType) == false) goto L11;
        restriction = "no_add_private_profile";
        goto L12
    L11:
        restriction = "no_add_user";
        goto L12
    }

    private UserInfo createUserInternalUnchecked(String name, String userType, int flags, int parentId, boolean preCreate, String[] disallowedPackages, Object token) throws UserManager.CheckedUserOperationException {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("createUser-" + flags);
        this.mUserJourneyLogger.logUserJourneyBegin(-1, 4);
        UserInfo newUser = createUserInternalUncheckedNoTracing(name, userType, flags, parentId, preCreate, disallowedPackages, t, token);     // Catch: Throwable -> L9
        if (newUser == null) goto L6;
        this.mUserJourneyLogger.logUserCreateJourneyFinish(getCurrentUserId(), newUser);
    L7:
        t.traceEnd();
        return newUser;
    L6:
        this.mUserJourneyLogger.logNullUserJourneyError(4, getCurrentUserId(), -1, userType, flags);
    L9:
        th = move-exception;
        if (0 == 0) goto L12;
        this.mUserJourneyLogger.logUserCreateJourneyFinish(getCurrentUserId(), null);
    L13:
        t.traceEnd();
        throw th;
    L12:
        this.mUserJourneyLogger.logNullUserJourneyError(4, getCurrentUserId(), -1, userType, flags);
        goto L13
    }

    private UserInfo createUserInternalUncheckedNoTracing(String name, String userType, int flags, int parentId, boolean preCreate, String[] disallowedPackages, TimingsTraceAndSlog t, Object token) throws UserManager.CheckedUserOperationException {
        String truncatedName = truncateString(name, 100);
        UserTypeDetails userTypeDetails = this.mUserTypes.get(userType);
        if (userTypeDetails != null) goto L5;
        throwCheckedUserOperationException("Cannot create user of invalid user type: " + userType, 1);
    L5:
        String userType2 = userType.intern();
        int flags2 = flags | userTypeDetails.getDefaultUserInfoFlags();
        if (checkUserTypeConsistency(flags2) == true) goto L9;
        throwCheckedUserOperationException("Cannot add user. Flags (" + Integer.toHexString(flags2) + ") and userTypeDetails (" + userType2 + ") are inconsistent.", 1);
    L9:
        if ((flags2 & 2048) == 0) goto L12;
        throwCheckedUserOperationException("Cannot add user. Flags (" + Integer.toHexString(flags2) + ") indicated SYSTEM user, which cannot be created.", 1);
    L12:
        if (isUserTypeEnabled(userTypeDetails) == true) goto L14;
        throwCheckedUserOperationException("Cannot add a user of disabled type " + userType2 + ".", 8);
    L14:
        Object r9 = this.mUsersLock;
        monitor-enter(r9);
    L207:
        th = th;
    L226:
        throw th;
    L211:
        th = th;
        goto L226
    L17:
        if (this.mForceEphemeralUsers == false) goto L19;
        flags2 = flags2 | 256;     // Catch: Throwable -> L207
    L19:
        monitor-exit(r9);     // Catch: Throwable -> L207
        if (preCreate == true) goto L27;
        if (parentId >= 0) goto L27;
        if (isUserTypeEligibleForPreCreation(userTypeDetails) == false) goto L27;
        UserInfo preCreatedUser = convertPreCreatedUserIfPossible(userType2, flags2, truncatedName, token);
        if (preCreatedUser == null) goto L27;
        return preCreatedUser;
    L27:
        DeviceStorageMonitorInternal dsm = (DeviceStorageMonitorInternal) LocalServices.getService(DeviceStorageMonitorInternal.class);
        if (dsm.isMemoryLow() == false) goto L31;
        throwCheckedUserOperationException("Cannot add user. Not enough space on disk.", 5);
    L31:
        if ((flags2 & 16384) == 0) goto L33;
        boolean r0 = true;
    L34:
        boolean isMainUser = r0;
        boolean isProfile = userTypeDetails.isProfile();
        boolean isGuest = UserManager.isUserTypeGuest(userType2);
        boolean isRestricted = UserManager.isUserTypeRestricted(userType2);
        boolean isDemo = UserManager.isUserTypeDemo(userType2);
        boolean isManagedProfile = UserManager.isUserTypeManagedProfile(userType2);
        boolean isPrivateProfile = UserManager.isUserTypePrivateProfile(userType2);
        boolean requiresProfileParent = userTypeDetails.isProfileParentRequired();
        long ident = Binder.clearCallingIdentity();
        Object r11 = this.mPackagesLock;     // Catch: Throwable -> L203
        monitor-enter(r11);     // Catch: Throwable -> L203
        if (parentId != (-10000)) goto L228;
        UserData parent = null;
    L54:
        if (isMainUser == true) goto L56;
    L58:
        if (preCreate == false) goto L60;
    L62:
        if (isGuest == true) goto L68;
        if (isManagedProfile == true) goto L68;
        if (isDemo == true) goto L68;
        if (isUserLimitReached() == false) goto L68;
        throwCheckedUserOperationException("Cannot add user. Maximum user limit is reached.", 6);     // Catch: Throwable -> L46
    L68:
        if (requiresProfileParent == true) goto L70;
    L72:
        if (isPrivateProfile == true) goto L74;
    L76:
        if (isRestricted == false) goto L82;
        if (parentId == 0) goto L82;
        if (isCreationOverrideEnabled() == true) goto L82;
        throwCheckedUserOperationException("Cannot add restricted profile - parent user must be system", 1);     // Catch: Throwable -> L46
    L82:
        if ((1073741824 & flags2) == 0) goto L239;
        int userId = 10;
    L85:
        Slog.i(LOG_TAG, "Creating user " + userId + " of type " + userType2);     // Catch: Throwable -> L197
        Environment.getUserSystemDirectory(userId).mkdirs();     // Catch: Throwable -> L197
        Object r7 = this.mUsersLock;     // Catch: Throwable -> L197
        monitor-enter(r7);     // Catch: Throwable -> L197
        if (parent != null) goto L243;
    L93:
        if (preCreate == false) goto L96;
        flags2 = flags2 & (-257);
    L96:
        if ((flags2 & 256) == 0) goto L98;
        flags2 = flags2 | 8192;
    L98:
        UserData parent2 = parent;
        int userId2 = userId;
        int userId3 = flags2;
        Object r27 = r11;
        UserInfo userInfo = new UserInfo(userId2, truncatedName, null, userId3, userType2);     // Catch: Throwable -> L186
        int r12 = this.mNextSerialNumber;     // Catch: Throwable -> L186
        this.mNextSerialNumber = r12 + 1;     // Catch: Throwable -> L186
        userInfo.serialNumber = r12;     // Catch: Throwable -> L186
        userInfo.creationTime = getCreationTime();     // Catch: Throwable -> L108
        userInfo.partial = true;     // Catch: Throwable -> L108
        userInfo.preCreated = preCreate;     // Catch: Throwable -> L108
        userInfo.lastLoggedInFingerprint = PackagePartitions.FINGERPRINT;     // Catch: Throwable -> L108
        if (userTypeDetails.hasBadge() == true) goto L106;
    L110:
        UserData userData = new UserData();     // Catch: Throwable -> L108
        userData.info = userInfo;     // Catch: Throwable -> L108
        userData.userProperties = new UserProperties(userTypeDetails.getDefaultUserPropertiesReference());     // Catch: Throwable -> L108
        addUserDataLU(userData);     // Catch: Throwable -> L108
        monitor-exit(r7);     // Catch: Throwable -> L108
        writeUserLP(userData);     // Catch: Throwable -> L184
        writeUserListLP();     // Catch: Throwable -> L184
        if (parent2 != null) goto L245;
    L126:
        monitor-exit(r27);     // Catch: Throwable -> L184
        t.traceBegin("createUserStorageKeys");     // Catch: Throwable -> L182
        StorageManager storage = (StorageManager) this.mContext.getSystemService(StorageManager.class);     // Catch: Throwable -> L182
        storage.createUserStorageKeys(userId2, userInfo.isEphemeral());     // Catch: Throwable -> L182
        t.traceEnd();     // Catch: Throwable -> L182
        t.traceBegin("prepareUserData");     // Catch: Throwable -> L182
        this.mUserDataPreparer.prepareUserData(userInfo, 1);     // Catch: Throwable -> L182
        t.traceEnd();     // Catch: Throwable -> L182
        t.traceBegin("LSS.createNewUser");     // Catch: Throwable -> L182
        this.mLockPatternUtils.createNewUser(userId2, userInfo.serialNumber);     // Catch: Throwable -> L182
        t.traceEnd();     // Catch: Throwable -> L182
        if (userId2 == 10) goto L217;
        Set<String> userTypeInstallablePackages = this.mSystemPackageInstaller.getInstallablePackagesForUserType(userType2);     // Catch: Throwable -> L182
    L135:
        t.traceBegin("PM.createNewUser");     // Catch: Throwable -> L182
        this.mPm.createNewUser(userId2, userTypeInstallablePackages, disallowedPackages);     // Catch: Throwable -> L132
        t.traceEnd();     // Catch: Throwable -> L132
        Bundle restrictions = new Bundle();     // Catch: Throwable -> L132
        if (isGuest == false) goto L152;
        Bundle r3 = this.mGuestRestrictions;     // Catch: Throwable -> L132
        monitor-enter(r3);     // Catch: Throwable -> L132
        Bundle restrictions2 = restrictions;
        restrictions2.putAll(this.mGuestRestrictions);     // Catch: Throwable -> L146
        monitor-exit(r3);     // Catch: Throwable -> L146
    L155:
        Object r4 = this.mRestrictionsLock;     // Catch: Throwable -> L132
        monitor-enter(r4);     // Catch: Throwable -> L132
        this.mBaseUserRestrictions.updateRestrictions(userId2, restrictions2);     // Catch: Throwable -> L179
        monitor-exit(r4);     // Catch: Throwable -> L179
    L160:
        userInfo.partial = false;     // Catch: Throwable -> L132
        UserManager.invalidateCacheOnUserListChange();     // Catch: Throwable -> L132
        Object r5 = this.mPackagesLock;     // Catch: Throwable -> L132
        monitor-enter(r5);     // Catch: Throwable -> L132
        writeUserLP(userData);     // Catch: Throwable -> L176
        monitor-exit(r5);     // Catch: Throwable -> L176
        updateUserIds();     // Catch: Throwable -> L132
        t.traceBegin("PM.onNewUserCreated-" + userId2);     // Catch: Throwable -> L132
        this.mPm.onNewUserCreated(userId2, false);     // Catch: Throwable -> L132
        t.traceEnd();     // Catch: Throwable -> L132
        applyDefaultUserSettings(userTypeDetails, userId2);     // Catch: Throwable -> L132
        setDefaultCrossProfileIntentFilters(userId2, userTypeDetails, restrictions2, parentId);     // Catch: Throwable -> L132
        if (preCreate == false) goto L173;
        Slog.i(LOG_TAG, "starting pre-created user " + userInfo.toFullString());     // Catch: Throwable -> L132
        IActivityManager am = ActivityManager.getService();     // Catch: Throwable -> L132
        am.startUserInBackground(userId2);     // Catch: Throwable -> L132 RemoteException -> L170
    L174:
        Binder.restoreCallingIdentity(ident);
        return userInfo;
    L170:
        e = move-exception;
        Slog.w(LOG_TAG, "could not start pre-created user " + userId2, e);     // Catch: Throwable -> L132
        goto L174
    L173:
        dispatchUserAdded(userInfo, token);     // Catch: Throwable -> L132
        goto L174
    L176:
        th = move-exception;
        throw th;     // Catch: Throwable -> L132
    L179:
        th = move-exception;
        throw th;     // Catch: Throwable -> L132
    L132:
        th = th;
    L205:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L148:
        th = th;
    L150:
        monitor-exit(r3);     // Catch: Throwable -> L146
        throw th;     // Catch: Throwable -> L132
    L146:
        th = th;
        goto L150
    L152:
        restrictions2 = restrictions;
        userTypeDetails.addDefaultRestrictionsTo(restrictions2);     // Catch: Throwable -> L132
        if (isMainUser == false) goto L155;
        restrictions2.remove("no_outgoing_calls");     // Catch: Throwable -> L132
        restrictions2.remove("no_sms");     // Catch: Throwable -> L132
        goto L155
    L217:
        userTypeInstallablePackages = DoppelgangerConfigure.DOPPELGANGER_NECESSARY_PACKAGES;     // Catch: Throwable -> L132
    L182:
        th = th;
        goto L205
    L245:
        if (isProfile == true) goto L116;
        if (isRestricted == false) goto L126;
        if (parent2.info.restrictedProfileParentId != (-10000)) goto L125;
        parent2.info.restrictedProfileParentId = parent2.info.id;     // Catch: Throwable -> L118
        writeUserLP(parent2);     // Catch: Throwable -> L118
    L125:
        userInfo.restrictedProfileParentId = parent2.info.restrictedProfileParentId;     // Catch: Throwable -> L118
        goto L126
    L116:
        if (parent2.info.profileGroupId != (-10000)) goto L120;
        parent2.info.profileGroupId = parent2.info.id;     // Catch: Throwable -> L118
        writeUserLP(parent2);     // Catch: Throwable -> L118
    L120:
        userInfo.profileGroupId = parent2.info.profileGroupId;     // Catch: Throwable -> L118
    L118:
        th = th;
    L199:
        monitor-exit(r27);     // Catch: Throwable -> L193
        throw th;     // Catch: Throwable -> L201
    L201:
        th = th;
    L184:
        th = th;
        goto L199
    L106:
        if (parentId == (-10000)) goto L110;
        userInfo.profileBadge = getFreeProfileBadgeLU(parentId, userType2);     // Catch: Throwable -> L108
    L108:
        th = th;
    L231:
        monitor-exit(r7);     // Catch: Throwable -> L195
        throw th;     // Catch: Throwable -> L193
    L195:
        th = th;
    L186:
        th = th;
    L189:
        th = th;
        goto L231
    L243:
        if (parent.info.isEphemeral() == false) goto L93;
        flags2 = flags2 | 256;
    L91:
        th = th;
    L197:
        th = th;
        r27 = r11;
        goto L199
    L239:
        int userId4 = getNextAvailableId();     // Catch: Throwable -> L197
        userId = userId4;
        goto L85
    L74:
        if (canAddPrivateProfile(parentId) == true) goto L76;
        throwCheckedUserOperationException("Cannot add profile of type " + userType2 + " for user " + parentId, 9);     // Catch: Throwable -> L46
        goto L76
    L70:
        if (canAddMoreProfilesToUser(userType2, parentId, false) == true) goto L72;
        throwCheckedUserOperationException("Cannot add more profiles of type " + userType2 + " for user " + parentId, 6);     // Catch: Throwable -> L46
        goto L72
    L60:
        if (canAddMoreUsersOfType(userTypeDetails) == true) goto L62;
        throwCheckedUserOperationException("Cannot add more users of type " + userType2 + ". Maximum number of that type already exists.", 6);     // Catch: Throwable -> L46
        goto L62
    L56:
        if (getMainUserIdUnchecked() == (-10000)) goto L58;
        throwCheckedUserOperationException("Cannot add user with FLAG_MAIN as main user already exists.", 6);     // Catch: Throwable -> L46
        goto L58
    L228:
        Object r10 = this.mUsersLock;     // Catch: Throwable -> L46
        monitor-enter(r10);     // Catch: Throwable -> L46
        UserData parent3 = getUserDataLU(parentId);     // Catch: Throwable -> L49
        monitor-exit(r10);     // Catch: Throwable -> L49
        if (parent3 != null) goto L48;
        throwCheckedUserOperationException("Cannot find user data for parent user " + parentId, 1);     // Catch: Throwable -> L46
    L48:
        parent = parent3;
        goto L54
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = th;
        r27 = r11;
    L193:
        th = th;
    L203:
        th = th;
        goto L205
    L33:
        r0 = false;
        goto L34
    }

    private void applyDefaultUserSettings(UserTypeDetails userTypeDetails, int userId) {
        Bundle systemSettings = userTypeDetails.getDefaultSystemSettings();
        Bundle secureSettings = userTypeDetails.getDefaultSecureSettings();
        if (systemSettings.isEmpty() == true) goto L5;
    L7:
        int systemSettingsSize = systemSettings.size();
        String[] systemSettingsArray = (String[]) systemSettings.keySet().toArray(new String[systemSettingsSize]);
        int i = 0;
    L9:
        if (i >= systemSettingsSize) goto L14;
        String setting = systemSettingsArray[i];
        if (android.provider.Settings.System.putStringForUser(this.mContext.getContentResolver(), setting, systemSettings.getString(setting), userId) == true) goto L13;
        Slog.e(LOG_TAG, "Failed to insert default system setting: " + setting);
    L13:
        i = i + 1;
        goto L9
    L14:
        int secureSettingsSize = secureSettings.size();
        String[] secureSettingsArray = (String[]) secureSettings.keySet().toArray(new String[secureSettingsSize]);
        int i2 = 0;
    L15:
        if (i2 >= secureSettingsSize) goto L21;
        String setting2 = secureSettingsArray[i2];
        if (android.provider.Settings.Secure.putStringForUser(this.mContext.getContentResolver(), setting2, secureSettings.getString(setting2), userId) == true) goto L19;
        Slog.e(LOG_TAG, "Failed to insert default secure setting: " + setting2);
    L19:
        i2 = i2 + 1;
        goto L15
    L21:
        return;
    L5:
        if (secureSettings.isEmpty() == false) goto L7;
    }

    private void setDefaultCrossProfileIntentFilters(int profileUserId, UserTypeDetails profileDetails, Bundle profileRestrictions, int parentUserId) {
        if (profileDetails == null) goto L25;
        if (profileDetails.isProfile() == false) goto L30;
        List<DefaultCrossProfileIntentFilter> filters = profileDetails.getDefaultCrossProfileIntentFilters();
        if (filters.isEmpty() == false) goto L10;
        return;
    L10:
        boolean disallowSharingIntoProfile = profileRestrictions.getBoolean("no_sharing_into_profile", false);
        int size = profileDetails.getDefaultCrossProfileIntentFilters().size();
        int i = 0;
    L11:
        if (i >= size) goto L23;
        DefaultCrossProfileIntentFilter filter = profileDetails.getDefaultCrossProfileIntentFilters().get(i);
        if (disallowSharingIntoProfile == false) goto L18;
        if (filter.letsPersonalDataIntoProfile == false) goto L18;
    L21:
        i = i + 1;
    L18:
        if (filter.direction != 0) goto L20;
        this.mPm.addCrossProfileIntentFilter(this.mPm.snapshotComputer(), filter.filter, this.mContext.getOpPackageName(), profileUserId, parentUserId, filter.flags);
        goto L21
    L20:
        this.mPm.addCrossProfileIntentFilter(this.mPm.snapshotComputer(), filter.filter, this.mContext.getOpPackageName(), parentUserId, profileUserId, filter.flags);
        goto L21
    L23:
        return;
    L30:
        return;
    }

    private UserInfo convertPreCreatedUserIfPossible(String userType, int flags, String name, final Object token) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData preCreatedUserData = getPreCreatedUserLU(userType);     // Catch: Throwable -> L34
        monitor-exit(r0);     // Catch: Throwable -> L34
        if (preCreatedUserData != null) goto L9;
        return null;
    L9:
        WatchedUserStates r2 = this.mUserStates;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.mUserStates.has(preCreatedUserData.info.id) == false) goto L18;
        Slog.w(LOG_TAG, "Cannot reuse pre-created user " + preCreatedUserData.info.id + " because it didn't stop yet");     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        return null;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L16
        final UserInfo preCreatedUser = preCreatedUserData.info;
        int newFlags = preCreatedUser.flags | flags;
        if (checkUserTypeConsistency(newFlags) == true) goto L23;
        Slog.wtf(LOG_TAG, "Cannot reuse pre-created user " + preCreatedUser.id + " of type " + userType + " because flags are inconsistent. Flags (" + Integer.toHexString(flags) + "); preCreatedUserFlags ( " + Integer.toHexString(preCreatedUser.flags) + ").");
        return null;
    L23:
        Slog.i(LOG_TAG, "Reusing pre-created user " + preCreatedUser.id + " of type " + userType + " and bestowing on it flags " + UserInfo.flagsToString(flags));
        preCreatedUser.name = name;
        preCreatedUser.flags = newFlags;
        preCreatedUser.preCreated = false;
        preCreatedUser.convertedFromPreCreated = true;
        preCreatedUser.creationTime = getCreationTime();
        Object r1 = this.mPackagesLock;
        monitor-enter(r1);
        writeUserLP(preCreatedUserData);     // Catch: Throwable -> L29
        writeUserListLP();     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        updateUserIds();
        Binder.withCleanCallingIdentity(new UserManagerService$$ExternalSyntheticLambda6(this, preCreatedUser, token));
        return preCreatedUser;
    L29:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$convertPreCreatedUserIfPossible$6(UserInfo preCreatedUser, Object token) throws Exception {
        this.mPm.onNewUserCreated(preCreatedUser.id, true);
        dispatchUserAdded(preCreatedUser, token);
        VoiceInteractionManagerInternal vimi = (VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class);
        if (vimi == null) goto L6;
        vimi.onPreCreatedUserConversion(preCreatedUser.id);
        return;
    }

    static boolean checkUserTypeConsistency(int flags) {
        if (isAtMostOneFlag(flags & 4620) == true) goto L5;
    L9:
        return false;
    L5:
        if (isAtMostOneFlag(flags & 5120) == false) goto L9;
        if (isAtMostOneFlag(flags & 6144) == false) goto L9;
        return true;
    }

    private static boolean isAtMostOneFlag(int flags) {
        if (((flags - 1) & flags) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean installWhitelistedSystemPackages(boolean isFirstBoot, boolean isUpgrade, ArraySet<String> existingPackages) {
        UserSystemPackageInstaller r0 = this.mSystemPackageInstaller;
        if (isFirstBoot == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return r0.installWhitelistedSystemPackages(r1, isUpgrade, existingPackages);
    L5:
        if (this.mUpdatingSystemUserMode == true) goto L8;
        r1 = false;
        goto L10
    }

    public String[] getPreInstallableSystemPackages(String userType) {
        checkCreateUsersPermission("getPreInstallableSystemPackages");
        Set<String> installableSystemPackages = this.mSystemPackageInstaller.getInstallablePackagesForUserType(userType);
        if (installableSystemPackages != null) goto L7;
        return null;
    L7:
        return (String[]) installableSystemPackages.toArray(new String[installableSystemPackages.size()]);
    }

    private long getCreationTime() {
        long now = System.currentTimeMillis();
        if (now > EPOCH_PLUS_30_YEARS) goto L7;
        return 0;
    L7:
        return now;
    }

    private void dispatchUserAdded(UserInfo userInfo, Object token) {
        ArrayList<UserManagerInternal.UserLifecycleListener> r0 = this.mUserLifecycleListeners;
        monitor-enter(r0);
        int i = 0;
    L30:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUserLifecycleListeners.size()) goto L11;
        this.mUserLifecycleListeners.get(i).onUserCreated(userInfo, token);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L30
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        Intent addedIntent = new Intent("android.intent.action.USER_ADDED");
        addedIntent.addFlags(16777216);
        addedIntent.addFlags(67108864);
        addedIntent.putExtra("android.intent.extra.user_handle", userInfo.id);
        addedIntent.putExtra("android.intent.extra.USER", UserHandle.of(userInfo.id));
        this.mContext.sendBroadcastAsUser(addedIntent, UserHandle.ALL, "android.permission.MANAGE_USERS");
        Context r1 = this.mContext;
        if (userInfo.isGuest() == false) goto L16;
        String r2 = TRON_GUEST_CREATED;
    L19:
        MetricsLogger.count(r1, r2, 1);
        if (userInfo.isProfile() == false) goto L23;
        sendProfileAddedBroadcast(userInfo.profileGroupId, userInfo.id);
        return;
    L23:
        if (android.provider.Settings.Global.getString(this.mContext.getContentResolver(), "user_switcher_enabled") == null) goto L25;
        return;
    L25:
        if (getSystemResources().getBoolean(R.bool.config_enableWifiDisplay) == false) goto L35;
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "user_switcher_enabled", 1);
        return;
    L35:
        return;
    L16:
        if (userInfo.isDemo() == false) goto L18;
        r2 = TRON_DEMO_CREATED;
        goto L19
    L18:
        r2 = TRON_USER_CREATED;
        goto L19
    }

    private UserData getPreCreatedUserLU(String userType) {
        int userSize = this.mUsers.size();
        int i = 0;
    L3:
        if (i >= userSize) goto L15;
        UserData user = this.mUsers.valueAt(i);
        if (user.info.preCreated == false) goto L14;
        if (user.info.partial == true) goto L14;
        if (user.info.userType.equals(userType) == false) goto L14;
        if (user.info.isInitialized() == true) goto L13;
        Slog.w(LOG_TAG, "found pre-created user of type " + userType + ", but it's not initialized yet: " + user.info.toFullString());
        goto L14
    L13:
        return user;
    L14:
        i = i + 1;
        goto L3
    L15:
        return null;
    }

    private static boolean isUserTypeEligibleForPreCreation(UserTypeDetails userTypeDetails) {
        if (userTypeDetails != null) goto L6;
        return false;
    L6:
        if (userTypeDetails.isProfile() == false) goto L8;
        return false;
    L8:
        if (userTypeDetails.getName().equals("android.os.usertype.full.RESTRICTED") == true) goto L13;
        return true;
    L13:
        return false;
    }

    private void registerStatsCallbacks() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.USER_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new UserManagerService$$ExternalSyntheticLambda5(this));
        statsManager.setPullAtomCallback(FrameworkStatsLog.MULTI_USER_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new UserManagerService$$ExternalSyntheticLambda5(this));
    }

    private int onPullAtom(int atomTag, List<StatsEvent> data) {
        UserManagerService r1 = this;
        int r5 = -1;
        boolean r6 = true;
        if (atomTag != 10152) goto L27;
        List<UserInfo> users = r1.getUsersInternal(true, true, true);
        int size = users.size();
        if (size <= 1) goto L25;
        int idx = 0;
    L7:
        if (idx >= size) goto L24;
        UserInfo user = users.get(idx);
        int userTypeStandard = UserJourneyLogger.getUserTypeForStatsd(user.userType);
        if (userTypeStandard != 0) goto L12;
        String r0 = user.userType;
    L11:
        String userTypeCustom = r0;
        WatchedUserStates r11 = r1.mUserStates;
        monitor-enter(r11);
    L21:
        th = move-exception;
        throw th;
    L16:
        if (r1.mUserStates.get(user.id, r5) != 3) goto L18;
        boolean isUserRunningUnlocked = true;
    L19:
        monitor-exit(r11);     // Catch: Throwable -> L21
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.USER_INFO, user.id, userTypeStandard, userTypeCustom, user.flags, user.creationTime, user.lastLoggedInTime, isUserRunningUnlocked));
        idx = idx + 1;
        r5 = -1;
        r1 = this;
        goto L7
    L18:
        isUserRunningUnlocked = false;
        goto L19
    L12:
        r0 = null;
        goto L11
    L24:
        int r21 = 0;
    L39:
        return r21;
    L25:
        r21 = 0;
        goto L39
    L27:
        r21 = 0;
        if (atomTag == 10160) goto L30;
        Slogf.e(LOG_TAG, "Unexpected atom tag: %d", new Object[]{Integer.valueOf(atomTag)});
        return 1;
    L30:
        if (UserManager.getMaxSupportedUsers() <= 1) goto L39;
        int r2 = UserManager.getMaxSupportedUsers();
        boolean r7 = isUserSwitcherEnabled(-1);
        if (UserManager.supportsMultipleUsers() == true) goto L34;
    L36:
        r6 = false;
    L37:
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.MULTI_USER_INFO, r2, r7, r6));
        goto L39
    L34:
        if (hasUserRestriction("no_add_user", -1) == true) goto L36;
        goto L36
    }

    UserData putUserInfo(UserInfo userInfo) {
        UserData userData = new UserData();
        userData.info = userInfo;
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        addUserDataLU(userData);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        updateUserIds();
        return userData;
    L8:
        th = move-exception;
        throw th;
    }

    void removeUserInfo(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        removeUserDataLU(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public UserInfo createRestrictedProfileWithThrow(String name, int parentUserId) throws ServiceSpecificException {
        checkCreateUsersPermission("setupRestrictedProfile");
        UserInfo user = createProfileForUserWithThrow(name, "android.os.usertype.full.RESTRICTED", 0, parentUserId, null);
        long identity = Binder.clearCallingIdentity();
        setUserRestriction("no_modify_accounts", true, user.id);     // Catch: Throwable -> L6
        android.provider.Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "location_mode", 0, user.id);     // Catch: Throwable -> L6
        setUserRestriction("no_share_location", true, user.id);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return user;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public List<UserInfo> getGuestUsers() {
        checkManageUsersPermission("getGuestUsers");
        ArrayList<UserInfo> guestUsers = new ArrayList();
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        int size = this.mUsers.size();     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= size) goto L19;
        UserInfo user = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L15
        if (user.isGuest() == false) goto L17;
        if (user.guestToRemove == true) goto L17;
        if (user.preCreated == true) goto L17;
        if (this.mRemovingUserIds.get(user.id) == true) goto L17;
        guestUsers.add(user);     // Catch: Throwable -> L15
    L17:
        i = i + 1;     // Catch: Throwable -> L15
        goto L5
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return guestUsers;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean markGuestForDeletion(int userId) {
        checkManageUsersPermission("Only the system can remove users");
        if (getUserRestrictions(UserHandle.getCallingUserId()).getBoolean("no_remove_user", false) == false) goto L6;
        Slog.w(LOG_TAG, "Cannot remove user. DISALLOW_REMOVE_USER is enabled.");
        return false;
    L6:
        long ident = Binder.clearCallingIdentity();
        Object r3 = this.mPackagesLock;     // Catch: Throwable -> L39
        monitor-enter(r3);     // Catch: Throwable -> L39
        Object r4 = this.mUsersLock;     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L29
        if (userId == 0) goto L31;
        if (userData == null) goto L31;
        if (this.mRemovingUserIds.get(userId) == true) goto L31;
        monitor-exit(r4);     // Catch: Throwable -> L29
        if (userData.info.isGuest() == true) goto L25;
        monitor-exit(r3);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return false;
    L25:
        userData.info.guestToRemove = true;     // Catch: Throwable -> L23
        addUserInfoFlags(userData.info, 64);     // Catch: Throwable -> L23
        writeUserLP(userData);     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return true;
    L31:
        monitor-exit(r4);     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(ident);
        return false;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public boolean removeUser(int userId) {
        Slog.i(LOG_TAG, "removeUser u" + userId);
        checkCreateUsersPermission("Only the system can remove users");
        Optional<String> restrictionOptional = getUserRemovalRestrictionOptional(userId);
        if (restrictionOptional.isEmpty() == true) goto L9;
        if (getUserRestrictions(UserHandle.getCallingUserId()).getBoolean(restrictionOptional.get(), false) == false) goto L9;
        Slog.w(LOG_TAG, "Cannot remove user. " + restrictionOptional.get() + " is enabled.");
        return false;
    L9:
        if (this.mCurrentBootPhase >= 550) goto L13;
        Slog.w(LOG_TAG, "Cannot remove user, removeUser is called too early during boot. ActivityManager is not ready yet.");
        return false;
    L13:
        return removeUserWithProfilesUnchecked(userId);
    }

    private boolean removeUserWithProfilesUnchecked(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userRemovability = getUserRemovabilityLocked(userId, "removed");     // Catch: Throwable -> L9
        if (userRemovability == 3) goto L11;
        boolean r2 = UserManager.isRemoveResultSuccessful(userRemovability);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L9
        boolean isProfile = userData.info.isProfile();     // Catch: Throwable -> L9
        IntArray profileIds = null;
        if (isProfile == true) goto L15;
        profileIds = getProfileIdsLU(userId, null, false, false);     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (isProfile == true) goto L42;
        Pair<Integer, Integer> currentAndTargetUserIds = getCurrentAndTargetUserIds();
        if (userId != ((Integer) currentAndTargetUserIds.first).intValue()) goto L22;
        Slog.w(LOG_TAG, "Current user cannot be removed.");
        return false;
    L22:
        if (userId != ((Integer) currentAndTargetUserIds.second).intValue()) goto L25;
        Slog.w(LOG_TAG, "Target user of an ongoing user switch cannot be removed.");
        return false;
    L25:
        int i = profileIds.size() - 1;
    L26:
        if (i < 0) goto L42;
        int profileId = profileIds.get(i);
        if (profileId == userId) goto L40;
        Slog.i(LOG_TAG, "removing profile:" + profileId + " associated with user:" + userId);
        if (removeUserUnchecked(profileId) == true) goto L40;
        Slog.i(LOG_TAG, "Unable to immediately remove profile " + profileId + "associated with user " + userId + ". User is set as ephemeral and will be removed on user switch or reboot.");
        Object r6 = this.mPackagesLock;
        monitor-enter(r6);
        UserData profileData = getUserDataNoChecks(userId);     // Catch: Throwable -> L37
        profileData.info.flags |= 256;     // Catch: Throwable -> L37
        writeUserLP(profileData);     // Catch: Throwable -> L37
        monitor-exit(r6);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L40:
        i = i - 1;
    L42:
        return removeUserUnchecked(userId);
    L9:
        th = move-exception;
        throw th;
    }

    public boolean removeUserEvenWhenDisallowed(int userId) {
        checkCreateUsersPermission("Only the system can remove users");
        return removeUserWithProfilesUnchecked(userId);
    }

    private Optional<String> getUserRemovalRestrictionOptional(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        boolean isManagedProfile = false;
        if (userInfo != null) goto L9;
    L11:
        boolean isPrivateProfile = false;
    L12:
        if (userInfo != null) goto L14;
    L16:
        if (isPrivateProfile == true) goto L18;
        if (isManagedProfile == false) goto L21;
        String r2 = "no_remove_managed_profile";
    L23:
        return Optional.of(r2);
    L21:
        r2 = "no_remove_user";
        goto L23
    L18:
        return Optional.empty();
    L14:
        if (userInfo.isManagedProfile() == false) goto L16;
        isManagedProfile = true;
        goto L16
    L9:
        if (userInfo.isPrivateProfile() == false) goto L11;
        isPrivateProfile = true;
    L24:
        th = move-exception;
        throw th;
    }

    private boolean removeUserUnchecked(int userId) {
        long ident = Binder.clearCallingIdentity();
        Object r2 = this.mPackagesLock;     // Catch: Throwable -> L25
        monitor-enter(r2);     // Catch: Throwable -> L25
        Object r3 = this.mUsersLock;     // Catch: Throwable -> L14
        monitor-enter(r3);     // Catch: Throwable -> L14
        int userRemovability = getUserRemovabilityLocked(userId, "removed");     // Catch: Throwable -> L16
        if (userRemovability == 3) goto L18;
        boolean r5 = UserManager.isRemoveResultSuccessful(userRemovability);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return r5;
    L18:
        final UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L16
        Slog.i(LOG_TAG, "Removing user " + userId);     // Catch: Throwable -> L16
        addRemovingUserIdLocked(userId);     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        boolean r4 = true;
        userData.info.partial = true;     // Catch: Throwable -> L14
        UserManager.invalidateCacheOnUserListChange();     // Catch: Throwable -> L14
        addUserInfoFlags(userData.info, 64);     // Catch: Throwable -> L14
        writeUserLP(userData);     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        this.mUserJourneyLogger.logUserJourneyBegin(userId, 6);     // Catch: Throwable -> L25
        this.mUserJourneyLogger.startSessionForDelayedJourney(userId, 9, userData.info.creationTime);     // Catch: Throwable -> L25
        this.mAppOpsService.removeUser(userId);     // Catch: Throwable -> L25 RemoteException -> L27
    L30:
        if (userData.info.profileGroupId == (-10000)) goto L55;
        if (userData.info.isProfile() == false) goto L55;
        sendProfileRemovedBroadcast(userData.info.profileGroupId, userData.info.id, userData.info.userType);     // Catch: Throwable -> L25
    L55:
        int res = ActivityManager.getService().stopUserWithCallback(userId, new AnonymousClass6(this, userData));     // Catch: Throwable -> L25 RemoteException -> L41
        if (res == 0) goto L39;
        r4 = false;
    L39:
        Binder.restoreCallingIdentity(ident);
        return r4;
    L41:
        e = move-exception;
        Slog.w(LOG_TAG, "Failed to stop user during removal.", e);     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(ident);
        return false;
    L27:
        e = move-exception;
        Slog.w(LOG_TAG, "Unable to notify AppOpsService of removing user.", e);     // Catch: Throwable -> L25
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void addRemovingUserId(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        addRemovingUserIdLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void addRemovingUserIdLocked(int userId) {
        this.mRemovingUserIds.put(userId, true);
        this.mRecentlyRemovedIds.add(Integer.valueOf(userId));
        if (this.mRecentlyRemovedIds.size() <= 100) goto L6;
        this.mRecentlyRemovedIds.removeFirst();
        return;
    }

    public int removeUserWhenPossible(int userId, boolean overrideDevicePolicy) {
        Slog.i(LOG_TAG, "removeUserWhenPossible u" + userId);
        checkCreateUsersPermission("Only the system can remove users");
        if (overrideDevicePolicy == true) goto L10;
        Optional<String> restrictionOptional = getUserRemovalRestrictionOptional(userId);
        if (restrictionOptional.isEmpty() == true) goto L10;
        if (getUserRestrictions(UserHandle.getCallingUserId()).getBoolean(restrictionOptional.get(), false) == false) goto L10;
        Slog.w(LOG_TAG, "Cannot remove user. " + restrictionOptional.get() + " is enabled.");
        return -2;
    L10:
        Slog.i(LOG_TAG, "Attempting to immediately remove user " + userId);
        if (removeUserWithProfilesUnchecked(userId) == false) goto L13;
        return 0;
    L13:
        Slog.i(LOG_TAG, TextUtils.formatSimple("Unable to immediately remove user %d. Now trying to set it ephemeral.", new Object[]{Integer.valueOf(userId)}));
        return setUserEphemeralUnchecked(userId);
    }

    private int getUserRemovabilityLocked(int userId, String msg) {
        String prefix = TextUtils.formatSimple("User %d can not be %s, ", new Object[]{Integer.valueOf(userId), msg});
        if (userId != 0) goto L6;
        Slog.e(LOG_TAG, prefix + "system user cannot be removed.");
        return -4;
    L6:
        UserData userData = this.mUsers.get(userId);
        if (userData != null) goto L11;
        Slog.e(LOG_TAG, prefix + "invalid user id provided.");
        return -3;
    L11:
        if (isNonRemovableMainUser(userData.info) == false) goto L15;
        Slog.e(LOG_TAG, prefix + "main user cannot be removed when it's a permanent admin user.");
        return -5;
    L15:
        if (this.mRemovingUserIds.get(userId) == false) goto L18;
        Slog.w(LOG_TAG, prefix + "it is already scheduled for removal.");
        return 2;
    L18:
        return 3;
    }

    private void finishRemoveUser(int userId) {
        Slog.i(LOG_TAG, "finishRemoveUser " + userId);
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        UserInfo user = getUserInfoLU(userId);     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        if (user != null) goto L8;
    L11:
        ArrayList<UserManagerInternal.UserLifecycleListener> r3 = this.mUserLifecycleListeners;
        monitor-enter(r3);
        int i = 0;
    L35:
    L17:
        th = move-exception;
        throw th;
    L15:
        if (i >= this.mUserLifecycleListeners.size()) goto L20;
        this.mUserLifecycleListeners.get(i).onUserRemoved(user);     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        goto L35
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L17
        long ident = Binder.clearCallingIdentity();
        Intent removedIntent = new Intent("android.intent.action.USER_REMOVED");     // Catch: Throwable -> L25
        removedIntent.addFlags(16777216);     // Catch: Throwable -> L25
        removedIntent.putExtra("android.intent.extra.user_handle", userId);     // Catch: Throwable -> L25
        removedIntent.putExtra("android.intent.extra.USER", UserHandle.of(userId));     // Catch: Throwable -> L25
        getActivityManagerInternal().broadcastIntentWithCallback(removedIntent, new AnonymousClass7(this, userId), new String[]{"android.permission.MANAGE_USERS"}, -1, null, null, null);     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(ident);
        return;
    L25:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        if (user.preCreated == false) goto L11;
        Slog.i(LOG_TAG, "Removing a pre-created user with user id: " + userId);
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).onUserStopped(userId);
        removeUserState(userId);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    private void removeUserState(int userId) {
        Slog.i(LOG_TAG, "Removing user state of user " + userId);
        this.mLockPatternUtils.removeUser(userId);
        ((StorageManager) this.mContext.getSystemService(StorageManager.class)).destroyUserStorageKeys(userId);     // Catch: IllegalStateException -> L5
    L7:
        this.mPm.cleanUpUser(this, userId);
        this.mUserDataPreparer.destroyUserData(userId, 3);
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        removeUserDataLU(userId);     // Catch: Throwable -> L37
        this.mIsUserManaged.delete(userId);     // Catch: Throwable -> L37
        getActivityManagerInternal().onUserRemoved(userId);     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        WatchedUserStates r1 = this.mUserStates;
        monitor-enter(r1);
        this.mUserStates.delete(userId);     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
        Object r2 = this.mRestrictionsLock;
        monitor-enter(r2);
        this.mBaseUserRestrictions.remove(userId);     // Catch: Throwable -> L20
        this.mAppliedUserRestrictions.remove(userId);     // Catch: Throwable -> L20
        this.mCachedEffectiveUserRestrictions.remove(userId);     // Catch: Throwable -> L20
        if (this.mDevicePolicyUserRestrictions.remove(userId) == false) goto L22;
        applyUserRestrictionsForAllUsersLR();     // Catch: Throwable -> L20
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L20
        Object r3 = this.mPackagesLock;
        monitor-enter(r3);
        writeUserListLP();     // Catch: Throwable -> L29
        monitor-exit(r3);     // Catch: Throwable -> L29
        getUserFile(userId).delete();
        updateUserIds();
        return;
    L29:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        throw th;
    L34:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    L5:
        e = move-exception;
        Slog.i(LOG_TAG, "Destroying storage keys for user " + userId + " failed, continuing anyway", e);
        goto L7
    }

    private void sendProfileAddedBroadcast(int parentUserId, int addedUserId) {
        sendProfileBroadcast(new Intent("android.intent.action.PROFILE_ADDED"), parentUserId, addedUserId);
    }

    private void sendProfileRemovedBroadcast(int parentUserId, int removedUserId, String userType) {
        if (Objects.equals(userType, "android.os.usertype.profile.MANAGED") == false) goto L5;
        sendManagedProfileRemovedBroadcast(parentUserId, removedUserId);
    L5:
        sendProfileBroadcast(new Intent("android.intent.action.PROFILE_REMOVED"), parentUserId, removedUserId);
    }

    private void sendProfileBroadcast(Intent intent, int parentUserId, int userId) {
        UserHandle parentHandle = UserHandle.of(parentUserId);
        intent.putExtra("android.intent.extra.USER", UserHandle.of(userId));
        intent.addFlags(1342177280);
        this.mContext.sendBroadcastAsUser(intent, parentHandle, null);
    }

    private void sendManagedProfileRemovedBroadcast(int parentUserId, int removedUserId) {
        Intent managedProfileIntent = new Intent("android.intent.action.MANAGED_PROFILE_REMOVED");
        managedProfileIntent.putExtra("android.intent.extra.USER", UserHandle.of(removedUserId));
        managedProfileIntent.putExtra("android.intent.extra.user_handle", removedUserId);
        UserHandle parentHandle = UserHandle.of(parentUserId);
        getDevicePolicyManagerInternal().broadcastIntentToManifestReceivers(managedProfileIntent, parentHandle, false);
        managedProfileIntent.addFlags(1342177280);
        this.mContext.sendBroadcastAsUser(managedProfileIntent, parentHandle, null);
    }

    public Bundle getApplicationRestrictions(String packageName) {
        return getApplicationRestrictionsForUser(packageName, UserHandle.getCallingUserId());
    }

    public Bundle getApplicationRestrictionsForUser(String packageName, int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L5;
    L6:
        checkSystemOrRoot("get application restrictions for other user/app " + packageName);
    L7:
        Object r0 = this.mAppRestrictionsLock;
        monitor-enter(r0);
        Bundle r1 = readApplicationRestrictionsLAr(packageName, userId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (UserHandle.isSameApp(Binder.getCallingUid(), getUidForPackage(packageName)) == true) goto L7;
        goto L6
    }

    public void setApplicationRestrictions(String packageName, Bundle restrictions, int userId) {
        checkSystemOrRoot("set application restrictions");
        String validationResult = FrameworkParsingPackageUtils.validateName(packageName, false, false);
        if (validationResult != null) goto L24;
        if (restrictions == null) goto L6;
        restrictions.setDefusable(true);
    L6:
        Object r1 = this.mAppRestrictionsLock;
        monitor-enter(r1);
        if (restrictions == null) goto L15;
    L13:
        th = move-exception;
        throw th;
    L10:
        if (restrictions.isEmpty() == true) goto L15;
        writeApplicationRestrictionsLAr(packageName, restrictions, userId);     // Catch: Throwable -> L13
        boolean changed = true;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (changed == true) goto L19;
        return;
    L19:
        Intent changeIntent = new Intent("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
        changeIntent.setPackage(packageName);
        changeIntent.addFlags(1073741824);
        this.mContext.sendBroadcastAsUser(changeIntent, UserHandle.of(userId));
        return;
    L15:
        changed = cleanAppRestrictionsForPackageLAr(packageName, userId);     // Catch: Throwable -> L13
        goto L16
    L24:
        throw new IllegalArgumentException("Invalid package name: " + validationResult);
    }

    private int getUidForPackage(String packageName) {
        long ident = Binder.clearCallingIdentity();
        int r2 = this.mContext.getPackageManager().getApplicationInfo(packageName, 4194304).uid;     // Catch: Throwable -> L6 PackageManager.NameNotFoundException -> L8
        Binder.restoreCallingIdentity(ident);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L12:
        Binder.restoreCallingIdentity(ident);
        return -1;
    }

    private static Bundle readApplicationRestrictionsLAr(String packageName, int userId) {
        AtomicFile restrictionsFile = new AtomicFile(new File(Environment.getUserSystemDirectory(userId), packageToRestrictionsFileName(packageName)));
        return readApplicationRestrictionsLAr(restrictionsFile);
    }

    static Bundle readApplicationRestrictionsLAr(AtomicFile restrictionsFile) {
        Bundle restrictions = new Bundle();
        ArrayList<String> values = new ArrayList();
        if (restrictionsFile.getBaseFile().exists() == true) goto L5;
        return restrictions;
    L5:
        FileInputStream fis = null;
        fis = restrictionsFile.openRead();     // Catch: Throwable -> L11 Throwable -> L13
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L11 Throwable -> L13
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L11 Throwable -> L13
        if (parser.getEventType() == 2) goto L16;
        Slog.e(LOG_TAG, "Unable to read restrictions file " + restrictionsFile.getBaseFile());     // Catch: Throwable -> L11 Throwable -> L13
        IoUtils.closeQuietly(fis);
        return restrictions;
    L16:
        if (parser.next() == 1) goto L20;
        readEntry(restrictions, values, parser);     // Catch: Throwable -> L11 Throwable -> L13 Throwable -> L13
    L20:
        IoUtils.closeQuietly(fis);
        return restrictions;
    L11:
        th = move-exception;
        IoUtils.closeQuietly(null);
        throw th;
    L13:
        e = move-exception;
        Slog.w(LOG_TAG, "Error parsing " + restrictionsFile.getBaseFile(), e);     // Catch: Throwable -> L11
        goto L20
    }

    private static void readEntry(Bundle restrictions, ArrayList<String> values, TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() == 2) goto L5;
        return;
    L5:
        if (parser.getName().equals("entry") == false) goto L45;
        String key = parser.getAttributeValue(null, ATTR_KEY);
        String valType = parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
        int count = parser.getAttributeInt(null, ATTR_MULTIPLE, -1);
        if (count == (-1)) goto L18;
        values.clear();
    L9:
        if (count <= 0) goto L16;
        int type = parser.next();
        if (type == 1) goto L16;
        if (type != 2) goto L9;
        if (parser.getName().equals(TAG_VALUE) == false) goto L9;
        values.add(parser.nextText().trim());
        count = count - 1;
    L16:
        String[] valueStrings = new String[values.size()];
        values.toArray(valueStrings);
        restrictions.putStringArray(key, valueStrings);
        return;
    L18:
        if (ATTR_TYPE_BUNDLE.equals(valType) == false) goto L21;
        restrictions.putBundle(key, readBundleEntry(parser, values));
        return;
    L21:
        if (ATTR_TYPE_BUNDLE_ARRAY.equals(valType) == false) goto L27;
        int outerDepth = parser.getDepth();
        ArrayList<Bundle> bundleList = new ArrayList();
    L24:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L26;
        Bundle childBundle = readBundleEntry(parser, values);
        bundleList.add(childBundle);
        goto L24
    L26:
        restrictions.putParcelableArray(key, (Parcelable[]) bundleList.toArray(new Bundle[bundleList.size()]));
        return;
    L27:
        String value = parser.nextText().trim();
        if (ATTR_TYPE_BOOLEAN.equals(valType) == false) goto L31;
        restrictions.putBoolean(key, Boolean.parseBoolean(value));
        return;
    L31:
        if (ATTR_TYPE_INTEGER.equals(valType) == false) goto L33;
        restrictions.putInt(key, Integer.parseInt(value));
        return;
    L33:
        restrictions.putString(key, value);
        return;
    }

    private static Bundle readBundleEntry(TypedXmlPullParser parser, ArrayList<String> values) throws IOException, XmlPullParserException {
        Bundle childBundle = new Bundle();
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L6;
        readEntry(childBundle, values, parser);
        goto L4
    L6:
        return childBundle;
    }

    private static void writeApplicationRestrictionsLAr(String packageName, Bundle restrictions, int userId) {
        AtomicFile restrictionsFile = new AtomicFile(new File(Environment.getUserSystemDirectory(userId), packageToRestrictionsFileName(packageName)));
        writeApplicationRestrictionsLAr(restrictions, restrictionsFile);
    }

    static void writeApplicationRestrictionsLAr(Bundle restrictions, AtomicFile restrictionsFile) {
        FileOutputStream fos = null;
        fos = restrictionsFile.startWrite();     // Catch: Exception -> L5
        TypedXmlSerializer serializer = Xml.resolveSerializer(fos);     // Catch: Exception -> L5
        serializer.startDocument(null, true);     // Catch: Exception -> L5
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Exception -> L5
        serializer.startTag(null, TAG_RESTRICTIONS);     // Catch: Exception -> L5
        writeBundle(restrictions, serializer);     // Catch: Exception -> L5
        serializer.endTag(null, TAG_RESTRICTIONS);     // Catch: Exception -> L5
        serializer.endDocument();     // Catch: Exception -> L5
        restrictionsFile.finishWrite(fos);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        restrictionsFile.failWrite(fos);
        Slog.e(LOG_TAG, "Error writing application restrictions list", e);
    }

    private static void writeBundle(Bundle restrictions, TypedXmlSerializer serializer) throws IOException {
        Iterator<String> r0 = restrictions.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L43;
        String key = r0.next();
        Object value = restrictions.get(key);
        serializer.startTag(null, "entry");
        serializer.attribute(null, ATTR_KEY, key);
        if ((value instanceof Boolean) == false) goto L9;
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_BOOLEAN);
        serializer.text(value.toString());
    L42:
        serializer.endTag(null, "entry");
        goto L4
    L9:
        if ((value instanceof Integer) == false) goto L11;
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_INTEGER);
        serializer.text(value.toString());
        goto L42
    L11:
        String r5 = "";
        if (value != null) goto L14;
    L38:
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_STRING);
        if (value == null) goto L41;
        r5 = (String) value;
    L41:
        serializer.text(r5);
        goto L42
    L14:
        if ((value instanceof String) == true) goto L38;
        if ((value instanceof Bundle) == false) goto L19;
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_BUNDLE);
        writeBundle((Bundle) value, serializer);
        goto L42
    L19:
        int r9 = 0;
        if ((value instanceof Parcelable[]) == false) goto L30;
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_BUNDLE_ARRAY);
        Parcelable[] array = (Parcelable[]) value;
        int r7 = array.length;
    L23:
        if (r9 >= r7) goto L42;
        Parcelable parcelable = array[r9];
        if ((parcelable instanceof Bundle) == false) goto L28;
        serializer.startTag(null, "entry");
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_BUNDLE);
        writeBundle((Bundle) parcelable, serializer);
        serializer.endTag(null, "entry");
        r9 = r9 + 1;
        goto L23
    L28:
        throw new IllegalArgumentException("bundle-array can only hold Bundles");
    L30:
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, ATTR_TYPE_STRING_ARRAY);
        String[] values = (String[]) value;
        serializer.attributeInt(null, ATTR_MULTIPLE, values.length);
        int r8 = values.length;
    L32:
        if (r9 >= r8) goto L42;
        String choice = values[r9];
        serializer.startTag(null, TAG_VALUE);
        if (choice == null) goto L36;
        String r11 = choice;
    L37:
        serializer.text(r11);
        serializer.endTag(null, TAG_VALUE);
        r9 = r9 + 1;
        goto L32
    L36:
        r11 = "";
        goto L37
    }

    public int getUserSerialNumber(int userId) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L7
        if (userInfo == null) goto L9;
        int r2 = userInfo.serialNumber;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = -1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isUserNameSet(int userId) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (hasQueryOrCreateUsersPermission() == true) goto L10;
        if (callingUserId != userId) goto L9;
        if (hasPermissionGranted("android.permission.GET_ACCOUNTS_PRIVILEGED", callingUid) == true) goto L10;
    L9:
        throw new SecurityException("You need MANAGE_USERS, CREATE_USERS, QUERY_USERS, or GET_ACCOUNTS_PRIVILEGED permissions to: get whether user name is set");
    L10:
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
        UserInfo userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L17
        if (userInfo != null) goto L15;
    L19:
        boolean r4 = false;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L17
        return r4;
    L15:
        if (userInfo.name == null) goto L19;
        r4 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public int getUserHandle(int userSerialNumber) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int[] r1 = this.mUserIds;     // Catch: Throwable -> L12
        int r2 = r1.length;     // Catch: Throwable -> L12
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L15;
        int userId = r1[r3];     // Catch: Throwable -> L12
        UserInfo info = getUserInfoLU(userId);     // Catch: Throwable -> L12
        if (info == null) goto L14;
        if (info.serialNumber != userSerialNumber) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return userId;
    L14:
        r3 = r3 + 1;     // Catch: Throwable -> L12
        goto L5
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return -1;
    L12:
        th = move-exception;
        throw th;
    }

    public long getUserCreationTime(int userId) {
        int callingUserId = UserHandle.getCallingUserId();
        UserInfo userInfo = null;
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
        if (callingUserId != userId) goto L8;
        userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L6
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L6
        if (userInfo == null) goto L18;
        return userInfo.creationTime;
    L18:
        throw new SecurityException("userId can only be the calling user or a profile associated with this user");
    L8:
        UserInfo parent = getProfileParentLU(userId);     // Catch: Throwable -> L6
        if (parent == null) goto L13;
        if (parent.id != callingUserId) goto L13;
        userInfo = getUserInfoLU(userId);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void addUserDataLU(UserData userData) {
        UserManager.invalidateCacheOnUserListChange();
        this.mUsers.put(userData.info.id, userData);
    }

    private void removeUserDataLU(int userId) {
        UserManager.invalidateCacheOnUserListChange();
        this.mUsers.remove(userId);
    }

    private void updateUserIds() {
        int num = 0;
        int numIncludingPreCreated = 0;
        Object r2 = this.mUsersLock;
        monitor-enter(r2);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= userSize) goto L14;
        UserInfo userInfo = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L11
        if (userInfo.partial == true) goto L13;
        numIncludingPreCreated = numIncludingPreCreated + 1;     // Catch: Throwable -> L11
        if (userInfo.preCreated == true) goto L13;
        num = num + 1;     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L14:
        int[] newUsers = new int[num];     // Catch: Throwable -> L11
        int[] newUsersIncludingPreCreated = new int[numIncludingPreCreated];     // Catch: Throwable -> L11
        int n = 0;
        int n2 = 0;
        int i2 = 0;
    L15:
        if (i2 >= userSize) goto L23;
        UserInfo userInfo2 = this.mUsers.valueAt(i2).info;     // Catch: Throwable -> L11
        if (userInfo2.partial == true) goto L22;
        int userId = this.mUsers.keyAt(i2);     // Catch: Throwable -> L11
        int nIncludingPreCreated = n2 + 1;     // Catch: Throwable -> L11
        newUsersIncludingPreCreated[n2] = userId;     // Catch: Throwable -> L11
        if (userInfo2.preCreated == true) goto L21;
        newUsers[n] = userId;     // Catch: Throwable -> L11
        n = n + 1;     // Catch: Throwable -> L11
        n2 = nIncludingPreCreated;
        goto L22
    L21:
        n2 = nIncludingPreCreated;
    L22:
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L15
    L23:
        this.mUserIds = newUsers;     // Catch: Throwable -> L11
        this.mUserIdsIncludingPreCreated = newUsersIncludingPreCreated;     // Catch: Throwable -> L11
        UserPackage.setValidUserIds(this.mUserIds);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void onBeforeStartUser(int userId) {
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo != null) goto L5;
        return;
    L5:
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("onBeforeStartUser-" + userId);
        boolean migrateAppsData = PackagePartitions.FINGERPRINT.equals(userInfo.lastLoggedInFingerprint) ^ true;
        t.traceBegin("prepareUserData");
        this.mUserDataPreparer.prepareUserData(userInfo, 1);
        t.traceEnd();
        t.traceBegin("reconcileAppsData");
        getPackageManagerInternal().reconcileAppsData(userId, 1, migrateAppsData);
        t.traceEnd();
        if (userId == 0) goto L15;
        t.traceBegin("applyUserRestrictions");
        Object r3 = this.mRestrictionsLock;
        monitor-enter(r3);
        applyUserRestrictionsLR(userId);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
        t.traceEnd();
    L12:
        th = move-exception;
        throw th;
    L15:
        t.traceEnd();
    }

    public void onBeforeUnlockUser(int userId) {
        UserInfo userInfo = getUserInfo(userId);
        if (userInfo != null) goto L5;
        return;
    L5:
        boolean migrateAppsData = !PackagePartitions.FINGERPRINT.equals(userInfo.lastLoggedInFingerprint);
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("prepareUserData-" + userId);
        this.mUserDataPreparer.prepareUserData(userInfo, 2);
        t.traceEnd();
        StorageManagerInternal smInternal = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
        smInternal.markCeStoragePrepared(userId);
        t.traceBegin("reconcileAppsData-" + userId);
        getPackageManagerInternal().reconcileAppsData(userId, 2, migrateAppsData);
        t.traceEnd();
    }

    void reconcileUsers(String volumeUuid) {
        this.mUserDataPreparer.reconcileUsers(volumeUuid, getUsers(true, true, false));
    }

    public void onUserLoggedIn(int userId) {
        UserData userData = getUserDataNoChecks(userId);
        if (userData != null) goto L5;
    L12:
        Slog.w(LOG_TAG, "userForeground: unknown user #" + userId);
        return;
    L5:
        if (userData.info.partial == true) goto L12;
        long now = System.currentTimeMillis();
        if (now <= EPOCH_PLUS_30_YEARS) goto L10;
        userData.info.lastLoggedInTime = now;
    L10:
        userData.info.lastLoggedInFingerprint = PackagePartitions.FINGERPRINT;
        scheduleWriteUser(userId);
    }

    int getNextAvailableId() {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int nextId = scanNextAvailableIdLocked();     // Catch: Throwable -> L8
        if (nextId < 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return nextId;
    L11:
        if (this.mRemovingUserIds.size() <= 0) goto L17;
        Slog.i(LOG_TAG, "All available IDs are used. Recycling LRU ids.");     // Catch: Throwable -> L8
        this.mRemovingUserIds.clear();     // Catch: Throwable -> L8
        Iterator<Integer> r2 = this.mRecentlyRemovedIds.iterator();     // Catch: Throwable -> L8
    L14:
        if (r2.hasNext() == false) goto L16;
        Integer recentlyRemovedId = r2.next();     // Catch: Throwable -> L8
        this.mRemovingUserIds.put(recentlyRemovedId.intValue(), true);     // Catch: Throwable -> L8
        goto L14
    L16:
        nextId = scanNextAvailableIdLocked();     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        UserManager.invalidateStaticUserProperties();
        UserManager.invalidateUserPropertiesCache();
        if (nextId < 0) goto L22;
        return nextId;
    L22:
        throw new IllegalStateException("No user id available!");
    L8:
        th = move-exception;
        throw th;
    }

    private int scanNextAvailableIdLocked() {
        int i = 11;
    L4:
        if (i >= MAX_USER_ID) goto L11;
        if (this.mUsers.indexOfKey(i) >= 0) goto L10;
        if (this.mRemovingUserIds.get(i) == true) goto L10;
        return i;
    L10:
        i = i + 1;
        goto L4
    L11:
        return -1;
    }

    private static String packageToRestrictionsFileName(String packageName) {
        return RESTRICTIONS_FILE_PREFIX + packageName + XML_SUFFIX;
    }

    private static String getRedacted(String string) {
        if (string != null) goto L5;
        return null;
    L5:
        return string.length() + "_chars";
    }

    public void setSeedAccountData(int userId, String accountName, String accountType, PersistableBundle accountOptions, boolean persist) {
        checkManageUsersPermission("set user seed account data");
        setSeedAccountDataNoChecks(userId, accountName, accountType, accountOptions, persist);
    }

    private void setSeedAccountDataNoChecks(int userId, String accountName, String accountType, PersistableBundle accountOptions, boolean persist) {
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        Object r1 = this.mUsersLock;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L14
        if (userData != null) goto L17;
        Slog.e(LOG_TAG, "No such user for settings seed data u=" + userId);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L17:
        userData.seedAccountName = truncateString(accountName, 500);     // Catch: Throwable -> L14
        userData.seedAccountType = truncateString(accountType, 500);     // Catch: Throwable -> L14
        if (accountOptions != null) goto L20;
    L22:
        userData.persistSeedData = persist;     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (persist == false) goto L26;
        writeUserLP(userData);     // Catch: Throwable -> L12
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L20:
        if (accountOptions.isBundleContentsWithinLengthLimit(1000) == false) goto L22;
        userData.seedAccountOptions = accountOptions;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public String getSeedAccountName(int userId) throws RemoteException {
        checkManageUsersPermission("Cannot get seed account information");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L10
        if (userData != null) goto L7;
        String r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = userData.seedAccountName;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public String getSeedAccountType(int userId) throws RemoteException {
        checkManageUsersPermission("Cannot get seed account information");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L10
        if (userData != null) goto L7;
        String r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = userData.seedAccountType;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public PersistableBundle getSeedAccountOptions(int userId) throws RemoteException {
        checkManageUsersPermission("Cannot get seed account information");
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L10
        if (userData != null) goto L7;
        PersistableBundle r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = userData.seedAccountOptions;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void clearSeedAccountData(int userId) throws RemoteException {
        checkManageUsersPermission("Cannot clear seed account information");
        Object r0 = this.mPackagesLock;
        monitor-enter(r0);
        Object r1 = this.mUsersLock;     // Catch: Throwable -> L11
        monitor-enter(r1);     // Catch: Throwable -> L11
        UserData userData = getUserDataLU(userId);     // Catch: Throwable -> L13
        if (userData != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L15:
        userData.clearSeedAccountData();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        writeUserLP(userData);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public boolean someUserHasSeedAccount(String accountName, String accountType) {
        checkManageUsersPermission("check seed account information");
        return someUserHasSeedAccountNoChecks(accountName, accountType);
    }

    private boolean someUserHasSeedAccountNoChecks(String accountName, String accountType) {
        Object r0 = this.mUsersLock;
        monitor-enter(r0);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L25
        int i = 0;
    L5:
        if (i >= userSize) goto L29;
        UserData data = this.mUsers.valueAt(i);     // Catch: Throwable -> L25
        if (data.info.isInitialized() == false) goto L10;
    L27:
        i = i + 1;     // Catch: Throwable -> L25
        goto L5
    L10:
        if (this.mRemovingUserIds.get(data.info.id) == true) goto L27;
        if (data.seedAccountName == null) goto L27;
        if (data.seedAccountName.equals(accountName) == false) goto L27;
        if (data.seedAccountType == null) goto L27;
        if (data.seedAccountType.equals(accountType) == false) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return true;
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return false;
    L25:
        th = move-exception;
        throw th;
    }

    public boolean someUserHasAccount(String accountName, String accountType) {
        checkCreateUsersPermission("check seed account information");
        return someUserHasAccountNoChecks(accountName, accountType);
    }

    private boolean someUserHasAccountNoChecks(final String accountName, final String accountType) {
        if (TextUtils.isEmpty(accountName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(accountType) == true) goto L11;
        final Account account = new Account(accountName, accountType);
        return ((Boolean) Binder.withCleanCallingIdentity(new UserManagerService$$ExternalSyntheticLambda7(this, account, accountName, accountType))).booleanValue();
    L11:
        return false;
    }

    private /* synthetic */ Boolean lambda$someUserHasAccountNoChecks$7(Account account, String accountName, String accountType) throws Exception {
        if (AccountManager.get(this.mContext).someUserHasAccount(account) == false) goto L5;
    L8:
        boolean r0 = true;
    L10:
        return Boolean.valueOf(r0);
    L5:
        if (someUserHasSeedAccountNoChecks(accountName, accountType) == true) goto L8;
        r0 = false;
        goto L10
    }

    private void setLastEnteredForegroundTimeToNow(UserData userData) {
        userData.mLastEnteredForegroundTimeMillis = System.currentTimeMillis();
        scheduleWriteUser(userData.info.id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new UserManagerServiceShellCommand(this, this.mSystemPackageInstaller, this.mLockPatternUtils, this.mContext).exec(this, in, out, err, args, callback, resultReceiver);
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, LOG_TAG, pw) == true) goto L5;
        return;
    L5:
        long now = System.currentTimeMillis();
        long nowRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        if (args != null) goto L8;
    L25:
        int currentUserId = getCurrentUserId();
        pw.print("Current user: ");
        if (currentUserId == (-10000)) goto L28;
        pw.println(currentUserId);
    L29:
        pw.println();
        Object r11 = this.mPackagesLock;
        monitor-enter(r11);
        Object r12 = this.mUsersLock;     // Catch: Throwable -> L127
        monitor-enter(r12);     // Catch: Throwable -> L127
        pw.println("Users:");     // Catch: Throwable -> L41
        int i = 0;
    L35:
        if (i >= this.mUsers.size()) goto L44;
        UserData userData = this.mUsers.valueAt(i);     // Catch: Throwable -> L41
        if (userData == null) goto L40;
        dumpUserLocked(pw, userData, sb, now, nowRealtime);     // Catch: Throwable -> L41
    L40:
        i = i + 1;     // Catch: Throwable -> L41
        goto L35
    L44:
        monitor-exit(r12);     // Catch: Throwable -> L41
        pw.println();     // Catch: Throwable -> L127
        pw.println("Device properties:");     // Catch: Throwable -> L127
        pw.println("  Device policy global restrictions:");     // Catch: Throwable -> L127
        Object r3 = this.mRestrictionsLock;     // Catch: Throwable -> L127
        monitor-enter(r3);     // Catch: Throwable -> L127
        UserRestrictionsUtils.dumpRestrictions(pw, "    ", this.mDevicePolicyUserRestrictions.getRestrictions(-1));     // Catch: Throwable -> L139
        monitor-exit(r3);     // Catch: Throwable -> L139
        pw.println("  Guest restrictions:");     // Catch: Throwable -> L127
        Bundle r4 = this.mGuestRestrictions;     // Catch: Throwable -> L127
        monitor-enter(r4);     // Catch: Throwable -> L127
        UserRestrictionsUtils.dumpRestrictions(pw, "    ", this.mGuestRestrictions);     // Catch: Throwable -> L136
        monitor-exit(r4);     // Catch: Throwable -> L136
        Object r5 = this.mUsersLock;     // Catch: Throwable -> L127
        monitor-enter(r5);     // Catch: Throwable -> L127
        pw.println();     // Catch: Throwable -> L58
        pw.println("  Device managed: " + this.mIsDeviceManaged);     // Catch: Throwable -> L58
        if (this.mRemovingUserIds.size() <= 0) goto L60;
        pw.println();     // Catch: Throwable -> L58
        pw.println("  Recently removed userIds: " + this.mRecentlyRemovedIds);     // Catch: Throwable -> L58
    L60:
        monitor-exit(r5);     // Catch: Throwable -> L58
        WatchedUserStates r6 = this.mUserStates;     // Catch: Throwable -> L127
        monitor-enter(r6);     // Catch: Throwable -> L127
        pw.print("  Started users state: [");     // Catch: Throwable -> L68
        int size = this.mUserStates.states.size();     // Catch: Throwable -> L68
        int i2 = 0;
    L64:
        if (i2 >= size) goto L71;
        int userId = this.mUserStates.states.keyAt(i2);     // Catch: Throwable -> L68
        int state = this.mUserStates.states.valueAt(i2);     // Catch: Throwable -> L68
        pw.print(userId);     // Catch: Throwable -> L68
        pw.print('=');     // Catch: Throwable -> L68
        pw.print(UserState.stateToString(state));     // Catch: Throwable -> L68
        if (i2 == (size - 1)) goto L70;
        pw.print(", ");     // Catch: Throwable -> L68
    L70:
        i2 = i2 + 1;     // Catch: Throwable -> L68
        goto L64
    L71:
        pw.println(']');     // Catch: Throwable -> L68
        monitor-exit(r6);     // Catch: Throwable -> L68
        Object r7 = this.mUsersLock;     // Catch: Throwable -> L127
        monitor-enter(r7);     // Catch: Throwable -> L127
        pw.print("  Cached user IDs: ");     // Catch: Throwable -> L129
        pw.println(Arrays.toString(this.mUserIds));     // Catch: Throwable -> L129
        pw.print("  Cached user IDs (including pre-created): ");     // Catch: Throwable -> L129
        pw.println(Arrays.toString(this.mUserIdsIncludingPreCreated));     // Catch: Throwable -> L129
        monitor-exit(r7);     // Catch: Throwable -> L129
        monitor-exit(r11);     // Catch: Throwable -> L127
        pw.println();
        this.mUserVisibilityMediator.dump(pw, args);
        pw.println();
        pw.println();
        int effectiveMaxSupportedUsers = UserManager.getMaxSupportedUsers();
        pw.print("  Max users: " + effectiveMaxSupportedUsers);
        int defaultMaxSupportedUsers = getSystemResources().getInteger(R.integer.config_notificationServiceArchiveSize);
        if (effectiveMaxSupportedUsers == defaultMaxSupportedUsers) goto L81;
        pw.print(" (built-in value: " + defaultMaxSupportedUsers + ")");
    L81:
        pw.println(" (limit reached: " + isUserLimitReached() + ")");
        StringBuilder r0 = new StringBuilder();
        r0.append("  Supports switchable users: ");
        r0.append(UserManager.supportsMultipleUsers());
        pw.println(r0.toString());
        pw.println("  All guests ephemeral: " + getSystemResources().getBoolean(R.bool.config_hideNavBarForKeyboard));
        pw.println("  Force ephemeral users: " + this.mForceEphemeralUsers);
        boolean isHeadlessSystemUserMode = isHeadlessSystemUserMode();
        pw.println("  Is headless-system mode: " + isHeadlessSystemUserMode);
        if (isHeadlessSystemUserMode == RoSystemProperties.MULTIUSER_HEADLESS_SYSTEM_USER) goto L85;
        pw.println("  (differs from the current default build value)");
    L85:
        if (TextUtils.isEmpty(SystemProperties.get("persist.debug.user_mode_emulation")) == true) goto L89;
        pw.println("  (emulated by 'cmd user set-system-user-mode-emulation')");
        if (this.mUpdatingSystemUserMode == false) goto L89;
        pw.println("  (and being updated after boot)");
    L89:
        if (isHeadlessSystemUserMode == false) goto L91;
        pw.println("  Can switch to headless system user: " + getSystemResources().getBoolean(R.bool.config_carrier_volte_tty_supported));
    L91:
        pw.println("  User version: " + this.mUserVersion);
        pw.println("  Owner name: " + getOwnerName());
        Object r14 = this.mUsersLock;
        monitor-enter(r14);
        pw.println("  Boot user: " + this.mBootUser);     // Catch: Throwable -> L124
        monitor-exit(r14);     // Catch: Throwable -> L124
        pw.println("Can add private profile: " + canAddPrivateProfile(currentUserId));
        pw.println();
        pw.println("Number of listeners for");
        ArrayList<UserManagerInternal.UserRestrictionsListener> r13 = this.mUserRestrictionsListeners;
        monitor-enter(r13);
        pw.println("  restrictions: " + this.mUserRestrictionsListeners.size());     // Catch: Throwable -> L121
        monitor-exit(r13);     // Catch: Throwable -> L121
        ArrayList<UserManagerInternal.UserLifecycleListener> r15 = this.mUserLifecycleListeners;
        monitor-enter(r15);
        pw.println("  user lifecycle events: " + this.mUserLifecycleListeners.size());     // Catch: Throwable -> L118
        monitor-exit(r15);     // Catch: Throwable -> L118
        pw.println();
        pw.println("User types version: " + this.mUserTypeVersion);
        pw.println("User types (" + this.mUserTypes.size() + " types):");
        int i3 = 0;
    L105:
        if (i3 >= this.mUserTypes.size()) goto L107;
        pw.println("    " + this.mUserTypes.keyAt(i3) + ": ");
        this.mUserTypes.valueAt(i3).dump(pw, "        ");
        i3 = i3 + 1;
        goto L105
    L107:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        ipw.println();     // Catch: Throwable -> L111
        this.mSystemPackageInstaller.dump(ipw);     // Catch: Throwable -> L111
        ipw.close();
        return;
    L111:
        th = move-exception;
        ipw.close();     // Catch: Throwable -> L115
        throw th;
    L115:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L118:
        th = move-exception;
        throw th;
    L121:
        th = move-exception;
        throw th;
    L124:
        th = move-exception;
        throw th;
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L58:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L136:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L139:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        throw th;
    L28:
        pw.println("N/A");
        goto L29
    L8:
        if (args.length <= 0) goto L25;
        byte r8 = 0;
        String r10 = args[0];
        switch(r10.hashCode()) {
            case -1247813202: goto L16;
            case 1333469547: goto L13;
            default: goto L18;
        };
    L18:
        r8 = -1;
    L19:
        switch(r8) {
            case 0: goto L23;
            case 1: goto L21;
            default: goto L25;
        };
    L21:
        this.mUserVisibilityMediator.dump(pw, args);
        return;
    L23:
        dumpUser(pw, UserHandle.parseUserArg(args[1]), sb, now, nowRealtime);
        return;
    L13:
        if (r10.equals("--user") == true) goto L19;
        r8 = -1;
        goto L19
    L16:
        if (r10.equals("--visibility-mediator") == false) goto L177;
        r8 = 1;
        goto L19
    L177:
        r8 = -1;
        goto L19
    }

    private void dumpUser(PrintWriter pw, int userId, StringBuilder sb, long now, long nowRealtime) {
        if (userId != (-2)) goto L9;
        int currentUserId = getCurrentUserId();
        pw.print("Current user: ");
        if (currentUserId != (-10000)) goto L8;
        pw.println("Cannot determine current user");
        return;
    L8:
        userId = currentUserId;
    L9:
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        UserData userData = this.mUsers.get(userId);     // Catch: Throwable -> L16
        if (userData != null) goto L18;
        pw.println("User " + userId + " not found");     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L18:
        dumpUserLocked(pw, userData, sb, now, nowRealtime);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void dumpUserLocked(PrintWriter pw, UserData userData, StringBuilder tempStringBuilder, long now, long nowRealtime) {
        UserInfo userInfo = userData.info;
        int userId = userInfo.id;
        pw.print("  ");
        pw.print(userInfo);
        pw.print(" serialNo=");
        pw.print(userInfo.serialNumber);
        pw.print(" isPrimary=");
        pw.print(userInfo.isPrimary());
        if (userInfo.profileGroupId == userInfo.id) goto L8;
        if (userInfo.profileGroupId == (-10000)) goto L8;
        pw.print(" parentId=");
        pw.print(userInfo.profileGroupId);
    L8:
        if (this.mRemovingUserIds.get(userId) == false) goto L11;
        pw.print(" <removing> ");
    L11:
        if (userInfo.partial == false) goto L14;
        pw.print(" <partial>");
    L14:
        if (userInfo.preCreated == false) goto L17;
        pw.print(" <pre-created>");
    L17:
        if (userInfo.convertedFromPreCreated == false) goto L19;
        pw.print(" <converted>");
    L19:
        pw.println();
        pw.print("    Type: ");
        pw.println(userInfo.userType);
        pw.print("    Flags: ");
        pw.print(userInfo.flags);
        pw.print(" (");
        pw.print(UserInfo.flagsToString(userInfo.flags));
        pw.println(")");
        pw.print("    State: ");
        WatchedUserStates r2 = this.mUserStates;
        monitor-enter(r2);
        int state = this.mUserStates.get(userId, -1);     // Catch: Throwable -> L46
        monitor-exit(r2);     // Catch: Throwable -> L46
        pw.println(UserState.stateToString(state));
        pw.print("    Created: ");
        dumpTimeAgo(pw, tempStringBuilder, now, userInfo.creationTime);
        pw.print("    Last logged in: ");
        dumpTimeAgo(pw, tempStringBuilder, now, userInfo.lastLoggedInTime);
        pw.print("    Last logged in fingerprint: ");
        pw.println(userInfo.lastLoggedInFingerprint);
        pw.print("    Start time: ");
        dumpTimeAgo(pw, tempStringBuilder, nowRealtime, userData.startRealtime);
        pw.print("    Unlock time: ");
        dumpTimeAgo(pw, tempStringBuilder, nowRealtime, userData.unlockRealtime);
        pw.print("    Last entered foreground: ");
        dumpTimeAgo(pw, tempStringBuilder, now, userData.mLastEnteredForegroundTimeMillis);
        pw.print("    Has profile owner: ");
        pw.println(this.mIsUserManaged.get(userId));
        pw.println("    Restrictions:");
        Object r3 = this.mRestrictionsLock;
        monitor-enter(r3);
        UserRestrictionsUtils.dumpRestrictions(pw, "      ", this.mBaseUserRestrictions.getRestrictions(userInfo.id));     // Catch: Throwable -> L43
        pw.println("    Device policy restrictions:");     // Catch: Throwable -> L43
        UserRestrictionsUtils.dumpRestrictions(pw, "      ", this.mDevicePolicyUserRestrictions.getRestrictions(userInfo.id));     // Catch: Throwable -> L43
        pw.println("    Effective restrictions:");     // Catch: Throwable -> L43
        UserRestrictionsUtils.dumpRestrictions(pw, "      ", this.mCachedEffectiveUserRestrictions.getRestrictions(userInfo.id));     // Catch: Throwable -> L43
        monitor-exit(r3);     // Catch: Throwable -> L43
        if (userData.account == null) goto L31;
        pw.print("    Account name: " + userData.account);
        pw.println();
    L31:
        if (userData.seedAccountName == null) goto L38;
        pw.print("    Seed account name: " + userData.seedAccountName);
        pw.println();
        if (userData.seedAccountType == null) goto L36;
        pw.print("         account type: " + userData.seedAccountType);
        pw.println();
    L36:
        if (userData.seedAccountOptions == null) goto L38;
        pw.print("         account options exist");
        pw.println();
    L38:
        pw.print("    Can have profile: ");
        pw.println(userInfo.canHaveProfile());
        if (userData.userProperties == null) goto L41;
        userData.userProperties.println(pw, "    ");
    L41:
        pw.println("    Ignore errors preparing storage: " + userData.getIgnorePrepareStorageErrors());
        return;
    L43:
        th = move-exception;
        throw th;
    L46:
        th = move-exception;
        throw th;
    }

    private static void dumpTimeAgo(PrintWriter pw, StringBuilder sb, long nowTime, long time) {
        if (time != 0) goto L5;
        pw.println("<unknown>");
        return;
    L5:
        sb.setLength(0);
        TimeUtils.formatDuration(nowTime - time, sb);
        sb.append(" ago");
        pw.println(sb);
    }

    boolean isUserInitialized(int userId) {
        return this.mLocalService.isUserInitialized(userId);
    }

    private void enforceUserRestriction(String restriction, int userId, String message) throws UserManager.CheckedUserOperationException {
        if (hasUserRestriction(restriction, userId) == false) goto L10;
        StringBuilder r0 = new StringBuilder();
        if (message == null) goto L7;
        String r1 = message + ": ";
    L8:
        r0.append(r1);
        r0.append(restriction);
        r0.append(" is enabled.");
        String errorMessage = r0.toString();
        Slog.w(LOG_TAG, errorMessage);
        throw new UserManager.CheckedUserOperationException(errorMessage, 10);
    L7:
        r1 = "";
        goto L8
    }

    private void throwCheckedUserOperationException(String message, int userOperationResult) throws UserManager.CheckedUserOperationException {
        Slog.e(LOG_TAG, message);
        throw new UserManager.CheckedUserOperationException(message, userOperationResult);
    }

    private void removeAllUsersExceptSystemAndPermanentAdminMain() {
        ArrayList<UserInfo> usersToRemove = new ArrayList();
        Object r1 = this.mUsersLock;
        monitor-enter(r1);
        int userSize = this.mUsers.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= userSize) goto L15;
        UserInfo ui = this.mUsers.valueAt(i).info;     // Catch: Throwable -> L11
        if (ui.id == 0) goto L13;
        if (isNonRemovableMainUser(ui) == true) goto L13;
        usersToRemove.add(ui);     // Catch: Throwable -> L11
    L13:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L11
        Iterator<UserInfo> r2 = usersToRemove.iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        removeUser(r2.next().id);
        goto L18
    L20:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static void debug(String message) {
        Slog.d(LOG_TAG, message + "");
    }

    int getMaxUsersOfTypePerParent(String userType) {
        UserTypeDetails type = this.mUserTypes.get(userType);
        if (type != null) goto L7;
        return 0;
    L7:
        return getMaxUsersOfTypePerParent(type);
    }

    private static int getMaxUsersOfTypePerParent(UserTypeDetails userTypeDetails) {
        int defaultMax = userTypeDetails.getMaxAllowedPerParent();
        if (Build.IS_DEBUGGABLE == true) goto L6;
        return defaultMax;
    L6:
        if (userTypeDetails.isManagedProfile() == true) goto L8;
        return defaultMax;
    L8:
        return SystemProperties.getInt("persist.sys.max_profiles", defaultMax);
    }

    int getFreeProfileBadgeLU(int parentUserId, String userType) {
        Set<Integer> usedBadges = new ArraySet();
        int userSize = this.mUsers.size();
        int i = 0;
    L3:
        if (i >= userSize) goto L12;
        UserInfo ui = this.mUsers.valueAt(i).info;
        if (ui.userType.equals(userType) == false) goto L11;
        if (ui.profileGroupId != parentUserId) goto L11;
        if (this.mRemovingUserIds.get(ui.id) == true) goto L11;
        usedBadges.add(Integer.valueOf(ui.profileBadge));
    L11:
        i = i + 1;
        goto L3
    L12:
        int maxUsersOfType = getMaxUsersOfTypePerParent(userType);
        if (maxUsersOfType != (-1)) goto L15;
        maxUsersOfType = Integer.MAX_VALUE;
    L15:
        int i2 = 0;
    L16:
        if (i2 >= maxUsersOfType) goto L21;
        if (usedBadges.contains(Integer.valueOf(i2)) == false) goto L19;
        i2 = i2 + 1;
        goto L16
    L19:
        return i2;
    L21:
        return 0;
    }

    boolean hasProfile(int userId) {
        throw new UnsupportedOperationException();
    }

    private void verifyCallingPackage(String callingPackage, int callingUid) {
        int packageUid = this.mPm.snapshotComputer().getPackageUid(callingPackage, 0, UserHandle.getUserId(callingUid));
        if (packageUid != callingUid) goto L6;
        return;
    L6:
        throw new SecurityException("Specified package " + callingPackage + " does not match the calling uid " + callingUid);
    }

    private PackageManagerInternal getPackageManagerInternal() {
        if (this.mPmInternal != null) goto L6;
        this.mPmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    L6:
        return this.mPmInternal;
    }

    private DevicePolicyManagerInternal getDevicePolicyManagerInternal() {
        if (this.mDevicePolicyManagerInternal != null) goto L6;
        this.mDevicePolicyManagerInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
    L6:
        return this.mDevicePolicyManagerInternal;
    }

    private ActivityManagerInternal getActivityManagerInternal() {
        if (this.mAmInternal != null) goto L6;
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
    L6:
        return this.mAmInternal;
    }

    private boolean isNonRemovableMainUser(UserInfo userInfo) {
        if (userInfo.isMain() == true) goto L5;
    L7:
        return false;
    L5:
        if (isMainUserPermanentAdmin() == false) goto L7;
        return true;
    }

    public boolean isMainUserPermanentAdmin() {
        return getSystemResources().getBoolean(R.bool.config_keepRestrictedProfilesInBackground);
    }

    public boolean canSwitchToHeadlessSystemUser() {
        return getSystemResources().getBoolean(R.bool.config_carrier_volte_tty_supported);
    }

    public UserJourneyLogger getUserJourneyLogger() {
        return this.mUserJourneyLogger;
    }
}
