package com.android.server.notification;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseSetArray;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.XmlUtils;
import com.android.internal.util.function.TriPredicate;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.TimingsTraceAndSlog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ManagedServices {
    static final int APPROVAL_BY_COMPONENT = 1;
    static final int APPROVAL_BY_PACKAGE = 0;
    static final String ATT_APPROVED_LIST = "approved";
    static final String ATT_DEFAULTS = "defaults";
    static final String ATT_IS_PRIMARY = "primary";
    static final String ATT_USER_CHANGED = "user_changed";
    static final String ATT_USER_ID = "user";
    static final String ATT_USER_SET = "user_set_services";
    static final String ATT_USER_SET_OLD = "user_set";
    static final String ATT_VERSION = "version";
    static final String DB_VERSION = "4";
    private static final String DB_VERSION_1 = "1";
    private static final String DB_VERSION_2 = "2";
    private static final String DB_VERSION_3 = "3";
    protected static final String ENABLED_SERVICES_SEPARATOR = ":";
    private static final int MAX_SERVICE_ENTRIES = 100;
    private static final int ON_BINDING_DIED_REBIND_DELAY_MS = 10000;
    static final String TAG_MANAGED_SERVICES = "service_listing";
    protected final boolean DEBUG;
    protected final String TAG;
    protected int mApprovalLevel;
    protected final ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> mApproved;
    private final Config mConfig;
    protected final Context mContext;
    protected final ArraySet<ComponentName> mDefaultComponents;
    protected final ArraySet<String> mDefaultPackages;
    protected final Object mDefaultsLock;
    private final SparseArray<ArraySet<ComponentName>> mEnabledServicesByUser;
    private final SparseArray<ArraySet<String>> mEnabledServicesPackageNamesByUser;
    private final Handler mHandler;
    protected ArrayMap<Integer, Boolean> mIsUserChanged;
    protected final Object mMutex;
    protected final IPackageManager mPm;
    private final ArrayList<ManagedServiceInfo> mServices;
    private final ArrayList<Pair<ComponentName, Integer>> mServicesBound;
    private final ArraySet<Pair<ComponentName, Integer>> mServicesRebinding;
    private final SparseSetArray<ComponentName> mSnoozing;
    protected final UserManager mUm;
    protected final UserManagerInternal mUmInternal;
    private boolean mUseXml;
    private final UserProfiles mUserProfiles;
    protected ArrayMap<Integer, ArraySet<String>> mUserSetServices;

    /* JADX INFO: renamed from: com.android.server.notification.ManagedServices$1, reason: invalid class name */
    class AnonymousClass1 implements ServiceConnection {
        IInterface mService;
        final /* synthetic */ ManagedServices this$0;
        final /* synthetic */ boolean val$isSystem;
        final /* synthetic */ Pair val$servicesBindingTag;
        final /* synthetic */ int val$targetSdkVersion;
        final /* synthetic */ int val$uid;
        final /* synthetic */ int val$userid;

        /* JADX INFO: renamed from: $r8$lambda$lS7k-sW0B8zlW5v5lj842QuaWYk, reason: not valid java name */
        public static /* synthetic */ void m6075$r8$lambda$lS7ksW0B8zlW5v5lj842QuaWYk(AnonymousClass1 r0, ComponentName r1, int r2) {
            r0.lambda$onBindingDied$0(r1, r2);
        }

        AnonymousClass1(ManagedServices this$0, int r2, Pair r3, boolean r4, int r5, int r6) {
            this.this$0 = this$0;
            this.val$userid = r2;
            this.val$servicesBindingTag = r3;
            this.val$isSystem = r4;
            this.val$targetSdkVersion = r5;
            this.val$uid = r6;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Slog.v(this.this$0.TAG, this.val$userid + " " + ManagedServices.m6071$$Nest$mgetCaption(this.this$0) + " service connected: " + name);
            boolean added = false;
            ManagedServiceInfo info = null;
            Object r3 = this.this$0.mMutex;
            monitor-enter(r3);
            ManagedServices.m6069$$Nest$fgetmServicesRebinding(this.this$0).remove(this.val$servicesBindingTag);     // Catch: Throwable -> L13
            this.mService = this.this$0.asInterface(binder);     // Catch: Throwable -> L13 RemoteException -> L15
            AnonymousClass1 r9 = this;
            info = ManagedServices.m6072$$Nest$mnewServiceInfo(this.this$0, this.mService, name, this.val$userid, this.val$isSystem, r9, this.val$targetSdkVersion, this.val$uid);     // Catch: Throwable -> L9 RemoteException -> L11
            binder.linkToDeath(info, 0);     // Catch: Throwable -> L9 RemoteException -> L11
            added = ManagedServices.m6068$$Nest$fgetmServices(r9.this$0).add(info);     // Catch: Throwable -> L9 RemoteException -> L11
        L19:
            monitor-exit(r3);     // Catch: Throwable -> L9
            if (added == false) goto L30;
            r9.this$0.onServiceAdded(info);
            return;
        L30:
            return;
        L11:
            e = move-exception;
            RemoteException e = e;
        L18:
            Slog.e(r9.this$0.TAG, "Failed to linkToDeath, already dead", e);     // Catch: Throwable -> L9
            goto L19
        L15:
            e = move-exception;
            r9 = this;
            e = e;
        L9:
            th = move-exception;
            Throwable r13 = th;
        L23:
            monitor-exit(r3);     // Catch: Throwable -> L9
            throw r13;
        L13:
            th = move-exception;
            r13 = th;
            goto L23
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Slog.v(this.this$0.TAG, this.val$userid + " " + ManagedServices.m6071$$Nest$mgetCaption(this.this$0) + " connection lost: " + name);
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(final ComponentName name) {
            Slog.w(this.this$0.TAG, this.val$userid + " " + ManagedServices.m6071$$Nest$mgetCaption(this.this$0) + " binding died: " + name);
            Object r0 = this.this$0.mMutex;
            monitor-enter(r0);
            ManagedServices.m6074$$Nest$munbindService(this.this$0, this, name, this.val$userid);     // Catch: Throwable -> L7
            if (ManagedServices.m6069$$Nest$fgetmServicesRebinding(this.this$0).contains(this.val$servicesBindingTag) == true) goto L9;
            ManagedServices.m6069$$Nest$fgetmServicesRebinding(this.this$0).add(this.val$servicesBindingTag);     // Catch: Throwable -> L7
            Handler r1 = ManagedServices.m6067$$Nest$fgetmHandler(this.this$0);     // Catch: Throwable -> L7
            final int r2 = this.val$userid;     // Catch: Throwable -> L7
            r1.postDelayed(new ManagedServices$1$$ExternalSyntheticLambda0(this, name, r2), JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: Throwable -> L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L9:
            Slog.v(this.this$0.TAG, ManagedServices.m6071$$Nest$mgetCaption(this.this$0) + " not rebinding in user " + this.val$userid + " as a previous rebind attempt was made: " + name);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ void lambda$onBindingDied$0(ComponentName name, int userid) {
            this.this$0.reregisterService(name, userid);
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            Slog.v(this.this$0.TAG, "onNullBinding() called with: name = [" + name + "]");
            this.this$0.mContext.unbindService(this);
        }
    }

    public static class Config {
        public String bindPermission;
        public String caption;
        public int clientLabel;
        public String secondarySettingName;
        public String secureSettingName;
        public String serviceInterface;
        public String settingsAction;
        public String xmlTag;

        public Config() {
        }
    }

    public class ManagedServiceInfo implements IBinder.DeathRecipient {
        public ComponentName component;
        public ServiceConnection connection;
        public boolean isSystem;
        public boolean isSystemUi;
        public boolean isVisibleBackgroundUserService;
        public Pair<ComponentName, Integer> mKey;
        public IInterface service;
        public int targetSdkVersion;
        final /* synthetic */ ManagedServices this$0;
        public int uid;
        public int userid;

        public ManagedServiceInfo(ManagedServices this$0, IInterface service, ComponentName component, int userid, boolean isSystem, ServiceConnection connection, int targetSdkVersion, int uid) {
            this.this$0 = this$0;
            this.service = service;
            this.component = component;
            this.userid = userid;
            this.isSystem = isSystem;
            this.connection = connection;
            this.targetSdkVersion = targetSdkVersion;
            this.uid = uid;
            this.mKey = Pair.create(component, Integer.valueOf(userid));
        }

        public boolean isGuest(ManagedServices host) {
            if (this.this$0 == host) goto L5;
            return true;
        L5:
            return false;
        }

        public ManagedServices getOwner() {
            return this.this$0;
        }

        public IInterface getService() {
            return this.service;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public boolean isSystemUi() {
            return this.isSystemUi;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("ManagedServiceInfo[");
            r0.append("component=");
            r0.append(this.component);
            r0.append(",userid=");
            r0.append(this.userid);
            r0.append(",isSystem=");
            r0.append(this.isSystem);
            r0.append(",targetSdkVersion=");
            r0.append(this.targetSdkVersion);
            r0.append(",connection=");
            IBinder r2 = null;
            if (this.connection != null) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            r0.append(",service=");
            r0.append(this.service);
            r0.append(",serviceAsBinder=");
            if (this.service == null) goto L9;
            r2 = this.service.asBinder();
        L9:
            r0.append(r2);
            r0.append(']');
            return r0.toString();
        L5:
            r1 = "<connection>";
            goto L6
        }

        public void dumpDebug(ProtoOutputStream proto, long fieldId, ManagedServices host) {
            long token = proto.start(fieldId);
            this.component.dumpDebug(proto, 1146756268033L);
            proto.write(1120986464258L, this.userid);
            proto.write(1138166333443L, this.service.getClass().getName());
            proto.write(1133871366148L, this.isSystem);
            proto.write(1133871366149L, isGuest(host));
            proto.end(token);
        }

        public boolean isSameUser(int userId) {
            if (isEnabledForUser() == true) goto L6;
            return false;
        L6:
            if (userId != (-1)) goto L8;
        L9:
            return true;
        L8:
            if (userId == this.userid) goto L9;
            return false;
        }

        public boolean enabledAndUserMatches(int nid) {
            if (isEnabledForUser() == true) goto L6;
            return false;
        L6:
            if (this.userid != (-1)) goto L9;
            return true;
        L9:
            if (this.isSystem == false) goto L11;
            return true;
        L11:
            if (nid != (-1)) goto L13;
        L24:
            return true;
        L13:
            if (nid == this.userid) goto L24;
            if (supportsProfiles() == true) goto L18;
            return false;
        L18:
            if (ManagedServices.m6070$$Nest$fgetmUserProfiles(this.this$0).isCurrentProfile(nid) == true) goto L20;
            return false;
        L20:
            if (isPermittedForProfile(nid) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public boolean supportsProfiles() {
            if (this.targetSdkVersion < 21) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (this.this$0.DEBUG == false) goto L5;
            Slog.d(this.this$0.TAG, "binderDied " + this);
        L5:
            ManagedServices.m6073$$Nest$mremoveServiceImpl(this.this$0, this.service, this.userid);
        }

        public boolean isEnabledForUser() {
            boolean r1 = true;
            if (this.isSystem == false) goto L6;
            return true;
        L6:
            if (this.connection != null) goto L8;
            return false;
        L8:
            Object r0 = this.this$0.mMutex;
            monitor-enter(r0);
            ArraySet<ComponentName> enabledServices = (ArraySet) ManagedServices.m6066$$Nest$fgetmEnabledServicesByUser(this.this$0).get(-2);     // Catch: Throwable -> L16
            if (enabledServices != null) goto L14;
        L18:
            r1 = false;
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r1;
        L14:
            if (enabledServices.contains(this.component) == false) goto L18;
        L16:
            th = move-exception;
            throw th;
        }

        public boolean isPermittedForProfile(int userId) {
            if (ManagedServices.m6070$$Nest$fgetmUserProfiles(this.this$0).isProfileUser(userId, this.this$0.mContext) == true) goto L6;
            return true;
        L6:
            DevicePolicyManager dpm = (DevicePolicyManager) this.this$0.mContext.getSystemService("device_policy");
            long identity = Binder.clearCallingIdentity();
            boolean r3 = dpm.isNotificationListenerServicePermitted(this.component.getPackageName(), userId);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r3;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L25:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L25;
            ManagedServiceInfo that = (ManagedServiceInfo) o;
            if (this.userid != that.userid) goto L24;
            if (this.isSystem != that.isSystem) goto L24;
            if (this.targetSdkVersion != that.targetSdkVersion) goto L24;
            if (Objects.equals(this.service, that.service) == false) goto L24;
            if (Objects.equals(this.component, that.component) == false) goto L24;
            if (Objects.equals(this.connection, that.connection) == false) goto L24;
            return true;
        L24:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.service, this.component, Integer.valueOf(this.userid), Boolean.valueOf(this.isSystem), this.connection, Integer.valueOf(this.targetSdkVersion)});
        }
    }

    public static class UserProfiles {
        private final SparseArray<UserInfo> mCurrentProfiles;

        public UserProfiles() {
            this.mCurrentProfiles = new SparseArray();
        }

        public void updateCache(Context context) {
            UserManager userManager = (UserManager) context.getSystemService(ManagedServices.ATT_USER_ID);
            if (userManager == null) goto L16;
            int currentUserId = ActivityManager.getCurrentUser();
            List<UserInfo> profiles = userManager.getProfiles(currentUserId);
            SparseArray<UserInfo> r3 = this.mCurrentProfiles;
            monitor-enter(r3);
            this.mCurrentProfiles.clear();     // Catch: Throwable -> L10
            Iterator<UserInfo> r4 = profiles.iterator();     // Catch: Throwable -> L10
        L8:
            if (r4.hasNext() == false) goto L12;
            UserInfo user = r4.next();     // Catch: Throwable -> L10
            this.mCurrentProfiles.put(user.id, user);     // Catch: Throwable -> L10
            goto L8
        L12:
            monitor-exit(r3);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public IntArray getCurrentProfileIds() {
            SparseArray<UserInfo> r0 = this.mCurrentProfiles;
            monitor-enter(r0);
            IntArray users = new IntArray(this.mCurrentProfiles.size());     // Catch: Throwable -> L7
            int N = this.mCurrentProfiles.size();     // Catch: Throwable -> L7
            int i = 0;
        L5:
            if (i >= N) goto L10;
            users.add(this.mCurrentProfiles.keyAt(i));     // Catch: Throwable -> L7
            i = i + 1;     // Catch: Throwable -> L7
            goto L5
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return users;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isCurrentProfile(int userId) {
            SparseArray<UserInfo> r0 = this.mCurrentProfiles;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mCurrentProfiles.get(userId) == null) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public boolean isProfileUser(int userId, Context context) {
            SparseArray<UserInfo> r0 = this.mCurrentProfiles;
            monitor-enter(r0);
            UserInfo user = this.mCurrentProfiles.get(userId);     // Catch: Throwable -> L8
            boolean r2 = false;
            if (user != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L11:
            if (NotificationManagerService.privateSpaceFlagsEnabled() == false) goto L20;
            if (user.isProfile() == true) goto L15;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L15:
            if (hasParent(user, context) == false) goto L17;
            r2 = true;
            goto L17
        L20:
            if (user.isManagedProfile() == false) goto L22;
        L23:
            r2 = true;
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r2;
        L22:
            if (user.isCloneProfile() == false) goto L24;
        L8:
            th = move-exception;
            throw th;
        }

        boolean hasParent(UserInfo profile, Context context) {
            long identity = Binder.clearCallingIdentity();
            UserManager um = (UserManager) context.getSystemService(UserManager.class);     // Catch: Throwable -> L9
            if (um.getProfileParent(profile.id) == null) goto L6;
            boolean r3 = true;
        L7:
            Binder.restoreCallingIdentity(identity);
            return r3;
        L6:
            r3 = false;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnabledServicesByUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m6066$$Nest$fgetmEnabledServicesByUser(ManagedServices r0) {
        return r0.mEnabledServicesByUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6067$$Nest$fgetmHandler(ManagedServices r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServices, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m6068$$Nest$fgetmServices(ManagedServices r0) {
        return r0.mServices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServicesRebinding, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m6069$$Nest$fgetmServicesRebinding(ManagedServices r0) {
        return r0.mServicesRebinding;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserProfiles m6070$$Nest$fgetmUserProfiles(ManagedServices r0) {
        return r0.mUserProfiles;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCaption, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6071$$Nest$mgetCaption(ManagedServices r0) {
        return r0.getCaption();
    }

    /* JADX INFO: renamed from: -$$Nest$mnewServiceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagedServiceInfo m6072$$Nest$mnewServiceInfo(ManagedServices r0, IInterface r1, ComponentName r2, int r3, boolean r4, ServiceConnection r5, int r6, int r7) {
        return r0.newServiceInfo(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveServiceImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagedServiceInfo m6073$$Nest$mremoveServiceImpl(ManagedServices r0, IInterface r1, int r2) {
        return r0.removeServiceImpl(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$munbindService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6074$$Nest$munbindService(ManagedServices r0, ServiceConnection r1, ComponentName r2, int r3) {
        r0.unbindService(r1, r2, r3);
    }

    protected abstract boolean allowRebindForParentUser();

    protected abstract IInterface asInterface(IBinder r1);

    protected abstract boolean checkType(IInterface r1);

    protected abstract void ensureFilters(ServiceInfo r1, int r2);

    protected abstract Config getConfig();

    protected abstract String getRequiredPermission();

    protected abstract void loadDefaultsFromConfig();

    protected abstract void onServiceAdded(ManagedServiceInfo r1);

    public ManagedServices(Context context, Object mutex, UserProfiles userProfiles, IPackageManager pm) {
        this.TAG = getClass().getSimpleName().replace('$', '.');
        this.DEBUG = Log.isLoggable(this.TAG, 3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mServices = new ArrayList();
        this.mServicesBound = new ArrayList();
        this.mServicesRebinding = new ArraySet();
        this.mDefaultsLock = new Object();
        this.mDefaultComponents = new ArraySet();
        this.mDefaultPackages = new ArraySet();
        this.mEnabledServicesByUser = new SparseArray();
        this.mEnabledServicesPackageNamesByUser = new SparseArray();
        this.mSnoozing = new SparseSetArray();
        this.mApproved = new ArrayMap();
        this.mUserSetServices = new ArrayMap();
        this.mIsUserChanged = new ArrayMap();
        this.mContext = context;
        this.mMutex = mutex;
        this.mUserProfiles = userProfiles;
        this.mPm = pm;
        this.mConfig = getConfig();
        this.mApprovalLevel = 1;
        this.mUm = (UserManager) this.mContext.getSystemService(ATT_USER_ID);
        this.mUmInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mEnabledServicesByUser.put(-2, new ArraySet());
        this.mEnabledServicesPackageNamesByUser.put(-2, new ArraySet());
    }

    private String getCaption() {
        return this.mConfig.caption;
    }

    protected List<ManagedServiceInfo> getServices() {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        List<ManagedServiceInfo> services = new ArrayList(this.mServices);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return services;
    L7:
        th = move-exception;
        throw th;
    }

    protected void addDefaultComponentOrPackage(String packageOrComponent) {
        if (TextUtils.isEmpty(packageOrComponent) == true) goto L24;
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mApprovalLevel != 0) goto L13;
        this.mDefaultPackages.add(packageOrComponent);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        ComponentName cn = ComponentName.unflattenFromString(packageOrComponent);     // Catch: Throwable -> L11
        if (cn != null) goto L16;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L16:
        if (this.mApprovalLevel != 1) goto L20;
        this.mDefaultPackages.add(cn.getPackageName());     // Catch: Throwable -> L11
        this.mDefaultComponents.add(cn);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    }

    boolean isDefaultComponentOrPackage(String packageOrComponent) {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        ComponentName cn = ComponentName.unflattenFromString(packageOrComponent);     // Catch: Throwable -> L9
        if (cn != null) goto L11;
        boolean r2 = this.mDefaultPackages.contains(packageOrComponent);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        boolean r3 = this.mDefaultComponents.contains(cn);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    ArraySet<ComponentName> getDefaultComponents() {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        ArraySet<ComponentName> r1 = new ArraySet(this.mDefaultComponents);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    ArraySet<String> getDefaultPackages() {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        ArraySet<String> r1 = new ArraySet(this.mDefaultPackages);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    ArrayMap<Boolean, ArrayList<ComponentName>> resetComponents(String packageName, int userId) {
        ArraySet<ComponentName> enabledComponents = new ArraySet(getAllowedComponents(userId));
        boolean changed = false;
        Object r2 = this.mDefaultsLock;
        monitor-enter(r2);
        ArrayList<ComponentName> componentsToEnable = new ArrayList(this.mDefaultComponents.size());     // Catch: Throwable -> L14
        ArrayList<ComponentName> disabledComponents = new ArrayList(this.mDefaultComponents.size());     // Catch: Throwable -> L14
        int i = 0;
    L6:
        if (i >= this.mDefaultComponents.size()) goto L17;
        if (enabledComponents.size() <= 0) goto L17;
        ComponentName currentDefault = this.mDefaultComponents.valueAt(i);     // Catch: Throwable -> L14
        if (packageName.equals(currentDefault.getPackageName()) == false) goto L16;
        if (enabledComponents.contains(currentDefault) == true) goto L16;
        componentsToEnable.add(currentDefault);     // Catch: Throwable -> L14
    L16:
        i = i + 1;     // Catch: Throwable -> L14
    L17:
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r5 = this.mApproved;     // Catch: Throwable -> L14
        monitor-enter(r5);     // Catch: Throwable -> L14
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L33
        if (approvedByType == null) goto L41;
        int M = approvedByType.size();     // Catch: Throwable -> L33
        int j = 0;
    L22:
        if (j >= M) goto L41;
        ArraySet<String> approved = approvedByType.valueAt(j);     // Catch: Throwable -> L33
        int i2 = 0;
    L25:
        if (i2 >= enabledComponents.size()) goto L36;
        ComponentName currentComponent = enabledComponents.valueAt(i2);     // Catch: Throwable -> L33
        if (packageName.equals(currentComponent.getPackageName()) == false) goto L35;
        if (this.mDefaultComponents.contains(currentComponent) == true) goto L35;
        if (approved.remove(currentComponent.flattenToString()) == false) goto L35;
        disabledComponents.add(currentComponent);     // Catch: Throwable -> L33
        clearUserSetFlagLocked(currentComponent, userId);     // Catch: Throwable -> L33
        changed = true;
    L35:
        i2 = i2 + 1;     // Catch: Throwable -> L33
        goto L25
    L36:
        int i3 = 0;
    L38:
        if (i3 >= componentsToEnable.size()) goto L40;
        ComponentName candidate = componentsToEnable.get(i3);     // Catch: Throwable -> L33
        changed = changed | approved.add(candidate.flattenToString());     // Catch: Throwable -> L33
        i3 = i3 + 1;     // Catch: Throwable -> L33
        goto L38
    L40:
        j = j + 1;     // Catch: Throwable -> L33
    L41:
        monitor-exit(r5);     // Catch: Throwable -> L33
        monitor-exit(r2);     // Catch: Throwable -> L14
        if (changed == false) goto L46;
        rebindServices(false, -1);
    L46:
        ArrayMap<Boolean, ArrayList<ComponentName>> changes = new ArrayMap();
        changes.put(true, componentsToEnable);
        changes.put(false, disabledComponents);
        return changes;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private boolean clearUserSetFlagLocked(ComponentName component, int userId) {
        String approvedValue = getApprovedValue(component.flattenToString());
        ArraySet<String> userSet = this.mUserSetServices.get(Integer.valueOf(userId));
        if (userSet != null) goto L5;
    L7:
        return false;
    L5:
        if (userSet.remove(approvedValue) == false) goto L7;
        return true;
    }

    protected int getBindFlags() {
        return 83886081;
    }

    protected void onServiceRemovedLocked(ManagedServiceInfo removed) {
    }

    private ManagedServiceInfo newServiceInfo(IInterface service, ComponentName component, int userId, boolean isSystem, ServiceConnection connection, int targetSdkVersion, int uid) {
        return new ManagedServiceInfo(this, service, component, userId, isSystem, connection, targetSdkVersion, uid);
    }

    public void onBootPhaseAppsCanStart() {
    }

    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        pw.println("    Allowed " + getCaption() + "s:");
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        int N = this.mApproved.size();     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= N) goto L21;
        int userId = this.mApproved.keyAt(i).intValue();     // Catch: Throwable -> L15
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.valueAt(i);     // Catch: Throwable -> L15
        Boolean userChanged = this.mIsUserChanged.get(Integer.valueOf(userId));     // Catch: Throwable -> L15
        if (approvedByType == null) goto L20;
        int M = approvedByType.size();     // Catch: Throwable -> L15
        int j = 0;
    L9:
        if (j >= M) goto L20;
        boolean isPrimary = approvedByType.keyAt(j).booleanValue();     // Catch: Throwable -> L15
        ArraySet<String> approved = approvedByType.valueAt(j);     // Catch: Throwable -> L15
        if (approvedByType.size() <= 0) goto L19;
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L15
        r10.append("      ");     // Catch: Throwable -> L15
        r10.append(String.join(ENABLED_SERVICES_SEPARATOR, approved));     // Catch: Throwable -> L15
        r10.append(" (user: ");     // Catch: Throwable -> L15
        r10.append(userId);     // Catch: Throwable -> L15
        r10.append(" isPrimary: ");     // Catch: Throwable -> L15
        r10.append(isPrimary);     // Catch: Throwable -> L15
        if (userChanged != null) goto L17;
        String r11 = "";
    L18:
        r10.append(r11);     // Catch: Throwable -> L15
        r10.append(")");     // Catch: Throwable -> L15
        pw.println(r10.toString());     // Catch: Throwable -> L15
        goto L19
    L17:
        r11 = " isUserChanged: " + userChanged;     // Catch: Throwable -> L15
    L19:
        j = j + 1;     // Catch: Throwable -> L15
    L20:
        i = i + 1;     // Catch: Throwable -> L15
        goto L5
    L21:
        pw.println("    Has user set:");     // Catch: Throwable -> L15
        Set<Integer> userIds = this.mUserSetServices.keySet();     // Catch: Throwable -> L15
        Iterator<Integer> r3 = userIds.iterator();     // Catch: Throwable -> L15
    L23:
        if (r3.hasNext() == false) goto L28;
        int userId2 = r3.next().intValue();     // Catch: Throwable -> L15
        if (this.mIsUserChanged.get(Integer.valueOf(userId2)) != null) goto L23;
        pw.println("      userId=" + userId2 + " value=" + this.mUserSetServices.get(Integer.valueOf(userId2)));     // Catch: Throwable -> L15
        goto L23
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L15
        Object r1 = this.mMutex;
        monitor-enter(r1);
        ArraySet<ComponentName> enabledServicesForCurrentProfiles = this.mEnabledServicesByUser.get(-2);     // Catch: Throwable -> L39
        pw.println("    All " + getCaption() + "s (" + enabledServicesForCurrentProfiles.size() + ") enabled for current profiles:");     // Catch: Throwable -> L39
        Iterator<ComponentName> r2 = enabledServicesForCurrentProfiles.iterator();     // Catch: Throwable -> L39
    L33:
        if (r2.hasNext() == false) goto L42;
        ComponentName cmpt = r2.next();     // Catch: Throwable -> L39
        if (filter == null) goto L41;
        if (filter.matches(cmpt) == false) goto L33;
    L41:
        pw.println("      " + cmpt);     // Catch: Throwable -> L39
        goto L33
    L42:
        pw.println("    Live " + getCaption() + "s (" + this.mServices.size() + "):");     // Catch: Throwable -> L39
        Iterator<ManagedServiceInfo> r4 = this.mServices.iterator();     // Catch: Throwable -> L39
    L44:
        if (r4.hasNext() == false) goto L59;
        ManagedServiceInfo info = r4.next();     // Catch: Throwable -> L39
        if (filter == null) goto L50;
        if (filter.matches(info.component) == false) goto L44;
    L50:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L39
        r5.append("      ");     // Catch: Throwable -> L39
        r5.append(info.component);     // Catch: Throwable -> L39
        r5.append(" (user ");     // Catch: Throwable -> L39
        r5.append(info.userid);     // Catch: Throwable -> L39
        r5.append("): ");     // Catch: Throwable -> L39
        r5.append(info.service);     // Catch: Throwable -> L39
        if (info.isSystem == false) goto L53;
        String r6 = " SYSTEM";
    L54:
        r5.append(r6);     // Catch: Throwable -> L39
        if (info.isGuest(this) == false) goto L57;
        String r7 = " GUEST";
    L58:
        r5.append(r7);     // Catch: Throwable -> L39
        pw.println(r5.toString());     // Catch: Throwable -> L39
        goto L44
    L57:
        r7 = "";
        goto L58
    L53:
        r6 = "";
        goto L54
    L59:
        monitor-exit(r1);     // Catch: Throwable -> L39
        SparseSetArray<ComponentName> r8 = this.mSnoozing;
        monitor-enter(r8);
        SparseSetArray<ComponentName> snoozingComponents = new SparseSetArray(this.mSnoozing);     // Catch: Throwable -> L78
        monitor-exit(r8);     // Catch: Throwable -> L78
        pw.println("    Snoozed " + getCaption() + "s (" + snoozingComponents.size() + "):");
        int i2 = 0;
    L66:
        if (i2 >= snoozingComponents.size()) goto L77;
        pw.println("      User: " + snoozingComponents.keyAt(i2));
        Iterator r9 = snoozingComponents.valuesAt(i2).iterator();
    L69:
        if (r9.hasNext() == false) goto L75;
        ComponentName name = (ComponentName) r9.next();
        ServiceInfo info2 = getServiceInfo(name, snoozingComponents.keyAt(i2));
        StringBuilder r12 = new StringBuilder();
        r12.append("        ");
        r12.append(name.flattenToShortString());
        if (isAutobindAllowed(info2) == false) goto L73;
        String r13 = "";
    L74:
        r12.append(r13);
        pw.println(r12.toString());
        goto L69
    L73:
        r13 = " (META_DATA_DEFAULT_AUTOBIND=false)";
        goto L74
    L75:
        i2 = i2 + 1;
        goto L66
    L77:
        return;
    L78:
        th = move-exception;
        throw th;
    L39:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public void dump(ProtoOutputStream proto, NotificationManagerService.DumpFilter filter) {
        proto.write(1138166333441L, getCaption());
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r4 = this.mApproved;
        monitor-enter(r4);
        int N = this.mApproved.size();     // Catch: Throwable -> L17
        int i = 0;
    L5:
        long r6 = 2246267895810L;
        if (i >= N) goto L26;
        int userId = this.mApproved.keyAt(i).intValue();     // Catch: Throwable -> L17
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.valueAt(i);     // Catch: Throwable -> L17
        if (approvedByType == null) goto L23;
        int M = approvedByType.size();     // Catch: Throwable -> L17
        int j = 0;
    L10:
        if (j >= M) goto L22;
        boolean isPrimary = approvedByType.keyAt(j).booleanValue();     // Catch: Throwable -> L17
        ArraySet<String> approved = approvedByType.valueAt(j);     // Catch: Throwable -> L17
        if (approvedByType.size() <= 0) goto L20;
        long sToken = proto.start(r6);     // Catch: Throwable -> L17
        Iterator<String> r16 = approved.iterator();     // Catch: Throwable -> L17
    L15:
        if (r16.hasNext() == false) goto L19;
        String s = r16.next();     // Catch: Throwable -> L17
        proto.write(2237677961217L, s);     // Catch: Throwable -> L17
        N = N;
        goto L15
    L19:
        int N2 = N;
        proto.write(1120986464258L, userId);     // Catch: Throwable -> L17
        proto.write(1133871366147L, isPrimary);     // Catch: Throwable -> L17
        proto.end(sToken);     // Catch: Throwable -> L17
    L21:
        j = j + 1;     // Catch: Throwable -> L17
        N = N2;
        r6 = 2246267895810L;
        goto L10
    L20:
        N2 = N;
        goto L21
    L22:
        int N3 = N;
    L24:
        i = i + 1;     // Catch: Throwable -> L17
        N = N3;
        goto L5
    L23:
        N3 = N;
        goto L24
    L26:
        monitor-exit(r4);     // Catch: Throwable -> L17
        Object r5 = this.mMutex;
        monitor-enter(r5);
        ArraySet<ComponentName> enabledServicesForCurrentProfiles = this.mEnabledServicesByUser.get(-2);     // Catch: Throwable -> L37
        Iterator<ComponentName> r7 = enabledServicesForCurrentProfiles.iterator();     // Catch: Throwable -> L37
    L31:
        if (r7.hasNext() == false) goto L40;
        ComponentName cmpt = r7.next();     // Catch: Throwable -> L37
        if (filter == null) goto L39;
        if (filter.matches(cmpt) == false) goto L31;
    L39:
        cmpt.dumpDebug(proto, 2246267895811L);     // Catch: Throwable -> L37
        goto L31
    L40:
        Iterator<ManagedServiceInfo> r0 = this.mServices.iterator();     // Catch: Throwable -> L37
    L42:
        if (r0.hasNext() == false) goto L49;
        ManagedServiceInfo info = r0.next();     // Catch: Throwable -> L37
        if (filter == null) goto L48;
        if (filter.matches(info.component) == false) goto L42;
    L48:
        info.dumpDebug(proto, 2246267895812L, this);     // Catch: Throwable -> L37
        goto L42
    L49:
        monitor-exit(r5);     // Catch: Throwable -> L37
        SparseSetArray<ComponentName> r8 = this.mSnoozing;
        monitor-enter(r8);
        int i2 = 0;
    L75:
    L59:
        th = move-exception;
        throw th;
    L54:
        if (i2 >= this.mSnoozing.size()) goto L63;
        long token = proto.start(2246267895814L);     // Catch: Throwable -> L59
        proto.write(1120986464257L, this.mSnoozing.keyAt(i2));     // Catch: Throwable -> L59
        Iterator r9 = this.mSnoozing.valuesAt(i2).iterator();     // Catch: Throwable -> L59
    L57:
        if (r9.hasNext() == false) goto L61;
        ComponentName name = (ComponentName) r9.next();     // Catch: Throwable -> L59
        name.dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L59
        goto L57
    L61:
        proto.end(token);     // Catch: Throwable -> L59
        i2 = i2 + 1;     // Catch: Throwable -> L59
        goto L75
    L63:
        monitor-exit(r8);     // Catch: Throwable -> L59
        return;
    L37:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;
    }

    protected void onSettingRestored(String element, String value, int backupSdkInt, int userId) {
        if (this.mUseXml == true) goto L28;
        Slog.d(this.TAG, "Restored managed service setting: " + element);
        if (this.mConfig.secureSettingName.equals(element) == true) goto L11;
        if (this.mConfig.secondarySettingName != null) goto L9;
        return;
    L9:
        if (this.mConfig.secondarySettingName.equals(element) == true) goto L11;
        return;
    L11:
        if (backupSdkInt >= 26) goto L19;
        String currentSetting = getApproved(userId, this.mConfig.secureSettingName.equals(element));
        if (TextUtils.isEmpty(currentSetting) == true) goto L19;
        if (TextUtils.isEmpty(value) == true) goto L17;
        value = value + ENABLED_SERVICES_SEPARATOR + currentSetting;
        goto L19
    L17:
        value = currentSetting;
    L19:
        if (shouldReflectToSettings() == false) goto L21;
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), element, value, userId);
    L21:
        Iterator r0 = this.mUm.getUsers().iterator();
    L23:
        if (r0.hasNext() == false) goto L25;
        UserInfo user = (UserInfo) r0.next();
        addApprovedList(value, user.id, this.mConfig.secureSettingName.equals(element));
        goto L23
    L25:
        Slog.d(this.TAG, "Done loading approved values from settings");
        rebindServices(false, userId);
        return;
    }

    void writeDefaults(TypedXmlSerializer out) throws IOException {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        List<String> componentStrings = new ArrayList(this.mDefaultComponents.size());     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= this.mDefaultComponents.size()) goto L10;
        componentStrings.add(this.mDefaultComponents.valueAt(i).flattenToString());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L10:
        String defaults = String.join(ENABLED_SERVICES_SEPARATOR, componentStrings);     // Catch: Throwable -> L8
        out.attribute(null, ATT_DEFAULTS, defaults);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void writeXml(TypedXmlSerializer out, boolean forBackup, int userId) throws IOException {
        int r3 = userId;
        out.startTag(null, getConfig().xmlTag);
        out.attributeInt(null, ATT_VERSION, Integer.parseInt(DB_VERSION));
        writeDefaults(out);
        if (forBackup == false) goto L5;
        trimApprovedListsAccordingToInstalledServices(r3);
    L5:
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r5 = this.mApproved;
        monitor-enter(r5);
        int N = this.mApproved.size();     // Catch: Throwable -> L25
        int i = 0;
    L8:
        if (i >= N) goto L44;
        int approvedUserId = this.mApproved.keyAt(i).intValue();     // Catch: Throwable -> L25
        if (forBackup == false) goto L13;
        if (approvedUserId == r3) goto L13;
        int N2 = N;
    L42:
        i = i + 1;     // Catch: Throwable -> L25
        r3 = userId;
        N = N2;
    L13:
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.valueAt(i);     // Catch: Throwable -> L25
        Boolean isUserChanged = this.mIsUserChanged.get(Integer.valueOf(approvedUserId));     // Catch: Throwable -> L25
        if (approvedByType == null) goto L41;
        int M = approvedByType.size();     // Catch: Throwable -> L25
        int j = 0;
    L16:
        if (j >= M) goto L40;
        boolean isPrimary = approvedByType.keyAt(j).booleanValue();     // Catch: Throwable -> L25
        Set<String> approved = approvedByType.valueAt(j);     // Catch: Throwable -> L25
        Set<String> userSet = this.mUserSetServices.get(Integer.valueOf(approvedUserId));     // Catch: Throwable -> L25
        if (approved != null) goto L23;
        if (userSet != null) goto L23;
        if (isUserChanged != null) goto L23;
        int N3 = N;
    L39:
        j = j + 1;     // Catch: Throwable -> L25
        N = N3;
    L23:
        if (approved != null) goto L27;
        String allowedItems = "";
    L28:
        N3 = N;
        out.startTag(null, TAG_MANAGED_SERVICES);     // Catch: Throwable -> L25
        out.attribute(null, ATT_APPROVED_LIST, allowedItems);     // Catch: Throwable -> L25
        out.attributeInt(null, ATT_USER_ID, approvedUserId);     // Catch: Throwable -> L25
        out.attributeBoolean(null, ATT_IS_PRIMARY, isPrimary);     // Catch: Throwable -> L25
        if (isUserChanged == null) goto L31;
        out.attributeBoolean(null, ATT_USER_CHANGED, isUserChanged.booleanValue());     // Catch: Throwable -> L25
    L33:
        writeExtraAttributes(out, approvedUserId);     // Catch: Throwable -> L25
        out.endTag(null, TAG_MANAGED_SERVICES);     // Catch: Throwable -> L25
        if (forBackup == true) goto L39;
        if (isPrimary == false) goto L39;
        if (shouldReflectToSettings() == false) goto L39;
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), getConfig().secureSettingName, allowedItems, approvedUserId);     // Catch: Throwable -> L25
        goto L39
    L31:
        if (userSet == null) goto L33;
        String userSetItems = String.join(ENABLED_SERVICES_SEPARATOR, userSet);     // Catch: Throwable -> L25
        out.attribute(null, ATT_USER_SET, userSetItems);     // Catch: Throwable -> L25
        goto L33
    L27:
        allowedItems = String.join(ENABLED_SERVICES_SEPARATOR, approved);     // Catch: Throwable -> L25
        goto L28
    L40:
        N2 = N;
        goto L42
    L41:
        N2 = N;
        goto L42
    L44:
        monitor-exit(r5);     // Catch: Throwable -> L25
        writeExtraXmlTags(out);
        out.endTag(null, getConfig().xmlTag);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    protected boolean shouldReflectToSettings() {
        return false;
    }

    protected void writeExtraAttributes(TypedXmlSerializer out, int userId) throws IOException {
    }

    protected void writeExtraXmlTags(TypedXmlSerializer out) throws IOException {
    }

    protected void readExtraTag(String tag, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
    }

    protected final void migrateToXml() {
        Iterator r0 = this.mUm.getUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        UserInfo user = (UserInfo) r0.next();
        ContentResolver cr = this.mContext.getContentResolver();
        if (TextUtils.isEmpty(getConfig().secureSettingName) == true) goto L9;
        addApprovedList(Settings.Secure.getStringForUser(cr, getConfig().secureSettingName, user.id), user.id, true);
    L9:
        if (TextUtils.isEmpty(getConfig().secondarySettingName) == true) goto L4;
        addApprovedList(Settings.Secure.getStringForUser(cr, getConfig().secondarySettingName, user.id), user.id, false);
        goto L4
    }

    void readDefaults(TypedXmlPullParser parser) {
        String defaultComponents = XmlUtils.readStringAttribute(parser, ATT_DEFAULTS);
        if (TextUtils.isEmpty(defaultComponents) == true) goto L23;
        String[] components = defaultComponents.split(ENABLED_SERVICES_SEPARATOR);
        Object r2 = this.mDefaultsLock;
        monitor-enter(r2);
        int i = 0;
    L24:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (i >= components.length) goto L19;
        if (TextUtils.isEmpty(components[i]) == true) goto L17;
        ComponentName cn = ComponentName.unflattenFromString(components[i]);     // Catch: Throwable -> L14
        if (cn == null) goto L16;
        this.mDefaultPackages.add(cn.getPackageName());     // Catch: Throwable -> L14
        this.mDefaultComponents.add(cn);     // Catch: Throwable -> L14
        goto L17
    L16:
        this.mDefaultPackages.add(components[i]);     // Catch: Throwable -> L14
    L17:
        i = i + 1;     // Catch: Throwable -> L14
        goto L24
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:? -> B:51:0x00f7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:? -> B:33:0x00c6). Please report as a decompilation issue!!! */
    public void readXml(TypedXmlPullParser parser, TriPredicate<String, Integer, String> allowedManagedServicePackages, boolean forRestore, int userId) throws XmlPullParserException, IOException {
        String version = XmlUtils.readStringAttribute(parser, ATT_VERSION);
        readDefaults(parser);
        boolean needUpgradeUserset = false;
    L3:
        int type = parser.next();
        if (type == 1) goto L79;
        String tag = parser.getName();
        if (type != 3) goto L11;
        if (getConfig().xmlTag.equals(tag) == true) goto L79;
    L11:
        if (type != 2) goto L76;
        if (TAG_MANAGED_SERVICES.equals(tag) == true) goto L14;
        readExtraTag(tag, parser);
        goto L76
    L14:
        Slog.i(this.TAG, "Read " + this.mConfig.caption + " permissions from xml");
        String approved = XmlUtils.readStringAttribute(parser, ATT_APPROVED_LIST);
        if (forRestore == false) goto L17;
        int resolvedUserId = userId;
    L18:
        boolean isPrimary = parser.getAttributeBoolean(null, ATT_IS_PRIMARY, true);
        String isUserChanged = XmlUtils.readStringAttribute(parser, ATT_USER_CHANGED);
        String isUserChanged_Old = XmlUtils.readStringAttribute(parser, ATT_USER_SET_OLD);
        String userSetComponent = XmlUtils.readStringAttribute(parser, ATT_USER_SET);
        if (DB_VERSION.equals(version) == false) goto L39;
        if (isUserChanged != null) goto L22;
        userSetComponent = TextUtils.emptyIfNull(userSetComponent);
        boolean r16 = true;
    L59:
        readExtraAttributes(tag, parser, resolvedUserId);
        if (isUserChanged == null) goto L64;
        if (approved.isEmpty() == false) goto L64;
        denyPregrantedAppUserSet(resolvedUserId, isPrimary);
        this.mUseXml = r16;
    L64:
        if (allowedManagedServicePackages == null) goto L70;
        if (allowedManagedServicePackages.test(getPackageName(approved), Integer.valueOf(resolvedUserId), getRequiredPermission()) == true) goto L70;
        if (approved.isEmpty() == false) goto L3;
    L70:
        if (this.mUm.getUserInfo(resolvedUserId) == null) goto L72;
        addApprovedList(approved, resolvedUserId, isPrimary, userSetComponent);
    L72:
        this.mUseXml = true;
        goto L3
    L22:
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r15 = this.mApproved;
        monitor-enter(r15);
        r16 = true;
        boolean needUpgradeUserset2 = needUpgradeUserset;
        this.mIsUserChanged.put(Integer.valueOf(resolvedUserId), Boolean.valueOf(isUserChanged));     // Catch: Throwable -> L33
        monitor-exit(r15);     // Catch: Throwable -> L33
        if (Boolean.valueOf(isUserChanged).booleanValue() == false) goto L31;
        String r0 = approved;
    L32:
        userSetComponent = r0;
        needUpgradeUserset = needUpgradeUserset2;
        goto L59
    L31:
        r0 = "";
    L33:
        th = th;
    L37:
        monitor-exit(r15);     // Catch: Throwable -> L33
        throw th;
    L35:
        th = th;
        goto L37
    L39:
        r16 = true;
        needUpgradeUserset = true;
        if (userSetComponent != null) goto L59;
        if (isUserChanged_Old != null) goto L43;
    L57:
        userSetComponent = "";
        needUpgradeUserset = true;
        goto L59
    L43:
        if (Boolean.valueOf(isUserChanged_Old).booleanValue() == false) goto L57;
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r17 = this.mApproved;
        monitor-enter(r17);
        this.mIsUserChanged.put(Integer.valueOf(resolvedUserId), true);     // Catch: Throwable -> L51
        monitor-exit(r17);     // Catch: Throwable -> L51
        needUpgradeUserset = false;
        userSetComponent = approved;
    L51:
        th = th;
    L55:
        monitor-exit(r17);     // Catch: Throwable -> L51
        throw th;
    L53:
        th = th;
        goto L55
    L17:
        resolvedUserId = parser.getAttributeInt(null, ATT_USER_ID, 0);
    L76:
        needUpgradeUserset = needUpgradeUserset;
    L79:
        boolean needUpgradeUserset3 = TextUtils.isEmpty(version);
        if (needUpgradeUserset3 == false) goto L82;
    L89:
        boolean isOldVersion = true;
    L91:
        if (isOldVersion == false) goto L93;
        upgradeDefaultsXmlVersion();
    L93:
        if (needUpgradeUserset == false) goto L95;
        upgradeUserSet();
    L95:
        rebindServices(false, -1);
        return;
    L82:
        if (DB_VERSION_1.equals(version) == true) goto L89;
        if (DB_VERSION_2.equals(version) == true) goto L89;
        if (DB_VERSION_3.equals(version) == true) goto L89;
        isOldVersion = false;
        goto L91
    }

    void upgradeDefaultsXmlVersion() {
        Object r0 = this.mDefaultsLock;
        monitor-enter(r0);
        int defaultsSize = this.mDefaultComponents.size() + this.mDefaultPackages.size();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        if (defaultsSize == 0) goto L8;
    L19:
        Object r2 = this.mDefaultsLock;
        monitor-enter(r2);
        int defaultsSize2 = this.mDefaultComponents.size() + this.mDefaultPackages.size();     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        if (defaultsSize2 != 0) goto L38;
        loadDefaultsFromConfig();
        return;
    L38:
        return;
    L26:
        th = move-exception;
        throw th;
    L8:
        if (this.mApprovalLevel != 1) goto L14;
        List<ComponentName> approvedComponents = getAllowedComponents(0);
        int i = 0;
    L11:
        if (i >= approvedComponents.size()) goto L14;
        addDefaultComponentOrPackage(approvedComponents.get(i).flattenToString());
        i = i + 1;
    L14:
        if (this.mApprovalLevel != 0) goto L19;
        List<String> approvedPkgs = getAllowedPackages(0);
        int i2 = 0;
    L17:
        if (i2 >= approvedPkgs.size()) goto L19;
        addDefaultComponentOrPackage(approvedPkgs.get(i2));
        i2 = i2 + 1;
    L29:
        th = move-exception;
        throw th;
    }

    protected void upgradeUserSet() {
    }

    protected void readExtraAttributes(String tag, TypedXmlPullParser parser, int userId) throws IOException {
    }

    protected void addApprovedList(String approved, int userId, boolean isPrimary) {
        addApprovedList(approved, userId, isPrimary, approved);
    }

    protected void addApprovedList(String approved, int userId, boolean isPrimary, String userSet) {
        if (TextUtils.isEmpty(approved) == false) goto L5;
        approved = "";
    L5:
        if (userSet != null) goto L7;
        userSet = approved;
    L7:
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L12
        if (approvedByType != null) goto L14;
        approvedByType = new ArrayMap();     // Catch: Throwable -> L12
        this.mApproved.put(Integer.valueOf(userId), approvedByType);     // Catch: Throwable -> L12
    L14:
        ArraySet<String> approvedList = approvedByType.get(Boolean.valueOf(isPrimary));     // Catch: Throwable -> L12
        if (approvedList != null) goto L17;
        approvedList = new ArraySet();     // Catch: Throwable -> L12
        approvedByType.put(Boolean.valueOf(isPrimary), approvedList);     // Catch: Throwable -> L12
    L17:
        String[] approvedArray = approved.split(ENABLED_SERVICES_SEPARATOR);     // Catch: Throwable -> L12
        int r4 = approvedArray.length;     // Catch: Throwable -> L12
        int r5 = 0;
        int r6 = 0;
    L18:
        if (r6 >= r4) goto L23;
        String pkgOrComponent = approvedArray[r6];     // Catch: Throwable -> L12
        String approvedItem = getApprovedValue(pkgOrComponent);     // Catch: Throwable -> L12
        if (approvedItem == null) goto L22;
        approvedList.add(approvedItem);     // Catch: Throwable -> L12
    L22:
        r6 = r6 + 1;     // Catch: Throwable -> L12
        goto L18
    L23:
        ArraySet<String> userSetList = this.mUserSetServices.get(Integer.valueOf(userId));     // Catch: Throwable -> L12
        if (userSetList != null) goto L26;
        userSetList = new ArraySet();     // Catch: Throwable -> L12
        this.mUserSetServices.put(Integer.valueOf(userId), userSetList);     // Catch: Throwable -> L12
    L26:
        String[] userSetArray = userSet.split(ENABLED_SERVICES_SEPARATOR);     // Catch: Throwable -> L12
        int r7 = userSetArray.length;     // Catch: Throwable -> L12
    L28:
        if (r5 >= r7) goto L33;
        String pkgOrComponent2 = userSetArray[r5];     // Catch: Throwable -> L12
        String approvedItem2 = getApprovedValue(pkgOrComponent2);     // Catch: Throwable -> L12
        if (approvedItem2 == null) goto L32;
        userSetList.add(approvedItem2);     // Catch: Throwable -> L12
    L32:
        r5 = r5 + 1;     // Catch: Throwable -> L12
        goto L28
    L33:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    protected void denyPregrantedAppUserSet(int userId, boolean isPrimary) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
        if (approvedByType != null) goto L9;
        approvedByType = new ArrayMap();     // Catch: Throwable -> L7
        this.mApproved.put(Integer.valueOf(userId), approvedByType);     // Catch: Throwable -> L7
    L9:
        approvedByType.put(Boolean.valueOf(isPrimary), new ArraySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isComponentEnabledForPackage(String pkg) {
        return isComponentEnabledForPackage(pkg, -2);
    }

    protected boolean isComponentEnabledForPackage(String pkg, int userId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ArraySet<String> enabledServicesPackageNames = this.mEnabledServicesPackageNamesByUser.get(resolveUserId(userId));     // Catch: Throwable -> L9
        if (enabledServicesPackageNames != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (enabledServicesPackageNames.contains(pkg) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    protected boolean setPackageOrComponentEnabled(String pkgOrComponent, int userId, boolean isPrimary, boolean enabled) {
        return setPackageOrComponentEnabled(pkgOrComponent, userId, isPrimary, enabled, true);
    }

    protected boolean setPackageOrComponentEnabled(String pkgOrComponent, int userId, boolean isPrimary, boolean enabled, boolean userSet) {
        String r0 = this.TAG;
        StringBuilder r1 = new StringBuilder();
        if (enabled == false) goto L5;
        String r2 = " Allowing ";
    L6:
        r1.append(r2);
        r1.append(this.mConfig.caption);
        r1.append(" ");
        r1.append(pkgOrComponent);
        r1.append(" (userSet: ");
        r1.append(userSet);
        r1.append(")");
        Slog.i(r0, r1.toString());
        boolean changed = false;
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r3 = this.mApproved;
        monitor-enter(r3);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L11
        if (allowedByType != null) goto L13;
        allowedByType = new ArrayMap();     // Catch: Throwable -> L11
        this.mApproved.put(Integer.valueOf(userId), allowedByType);     // Catch: Throwable -> L11
    L13:
        ArraySet<String> approved = allowedByType.get(Boolean.valueOf(isPrimary));     // Catch: Throwable -> L11
        if (approved != null) goto L16;
        approved = new ArraySet();     // Catch: Throwable -> L11
        allowedByType.put(Boolean.valueOf(isPrimary), approved);     // Catch: Throwable -> L11
    L16:
        String approvedItem = getApprovedValue(pkgOrComponent);     // Catch: Throwable -> L11
        if (approvedItem == null) goto L24;
        if (enabled == true) goto L20;
        approved.remove(approvedItem);     // Catch: Throwable -> L11
        changed = true;
        goto L24
    L20:
        if (approved.size() >= 100) goto L22;
        approved.add(approvedItem);     // Catch: Throwable -> L11
        changed = true;
        goto L24
    L22:
        Slog.w(this.TAG, TextUtils.formatSimple("Failed to allow %s %s because there are too many already", new Object[]{this.mConfig.caption, pkgOrComponent}));     // Catch: Throwable -> L11
    L24:
        if (changed == false) goto L33;
        ArraySet<String> userSetServices = this.mUserSetServices.get(Integer.valueOf(userId));     // Catch: Throwable -> L11
        if (userSetServices != null) goto L28;
        userSetServices = new ArraySet();     // Catch: Throwable -> L11
        this.mUserSetServices.put(Integer.valueOf(userId), userSetServices);     // Catch: Throwable -> L11
    L28:
        if (userSet == true) goto L30;
        userSetServices.remove(pkgOrComponent);     // Catch: Throwable -> L11
        goto L33
    L30:
        if (userSetServices.size() >= 100) goto L33;
        userSetServices.add(pkgOrComponent);     // Catch: Throwable -> L11
    L33:
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (changed == false) goto L36;
        rebindServices(false, userId);
    L36:
        return changed;
    L11:
        th = move-exception;
        throw th;
    L5:
        r2 = "Disallowing ";
        goto L6
    }

    private String getApprovedValue(String pkgOrComponent) {
        if (this.mApprovalLevel != 1) goto L10;
        if (ComponentName.unflattenFromString(pkgOrComponent) == null) goto L7;
        return pkgOrComponent;
    L7:
        return null;
    L10:
        return getPackageName(pkgOrComponent);
    }

    protected String getApproved(int userId, boolean primary) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.getOrDefault(Integer.valueOf(userId), new ArrayMap());     // Catch: Throwable -> L7
        ArraySet<String> approved = allowedByType.getOrDefault(Boolean.valueOf(primary), new ArraySet());     // Catch: Throwable -> L7
        String r3 = String.join(ENABLED_SERVICES_SEPARATOR, approved);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    protected List<ComponentName> getAllowedComponents(int userId) {
        List<ComponentName> allowedComponents = new ArrayList();
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r1 = this.mApproved;
        monitor-enter(r1);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.getOrDefault(Integer.valueOf(userId), new ArrayMap());     // Catch: Throwable -> L13
        int i = 0;
    L6:
        if (i >= allowedByType.size()) goto L18;
        ArraySet<String> allowed = allowedByType.valueAt(i);     // Catch: Throwable -> L13
        int j = 0;
    L9:
        if (j >= allowed.size()) goto L16;
        ComponentName cn = ComponentName.unflattenFromString(allowed.valueAt(j));     // Catch: Throwable -> L13
        if (cn == null) goto L15;
        allowedComponents.add(cn);     // Catch: Throwable -> L13
    L15:
        j = j + 1;     // Catch: Throwable -> L13
        goto L9
    L16:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return allowedComponents;
    L13:
        th = move-exception;
        throw th;
    }

    protected List<String> getAllowedPackages(int userId) {
        List<String> allowedPackages = new ArrayList();
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r1 = this.mApproved;
        monitor-enter(r1);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.getOrDefault(Integer.valueOf(userId), new ArrayMap());     // Catch: Throwable -> L13
        int i = 0;
    L6:
        if (i >= allowedByType.size()) goto L18;
        ArraySet<String> allowed = allowedByType.valueAt(i);     // Catch: Throwable -> L13
        int j = 0;
    L9:
        if (j >= allowed.size()) goto L16;
        String pkgName = getPackageName(allowed.valueAt(j));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(pkgName) == true) goto L15;
        allowedPackages.add(pkgName);     // Catch: Throwable -> L13
    L15:
        j = j + 1;     // Catch: Throwable -> L13
        goto L9
    L16:
        i = i + 1;     // Catch: Throwable -> L13
        goto L6
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return allowedPackages;
    L13:
        th = move-exception;
        throw th;
    }

    protected boolean isPackageOrComponentAllowed(String pkgOrComponent, int userId) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.getOrDefault(Integer.valueOf(userId), new ArrayMap());     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= allowedByType.size()) goto L16;
        ArraySet<String> allowed = allowedByType.valueAt(i);     // Catch: Throwable -> L12
        if (allowed.contains(pkgOrComponent) == true) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    protected boolean isPackageOrComponentAllowedWithPermission(ComponentName component, int userId) {
        if (isPackageOrComponentAllowed(component.flattenToString(), userId) == true) goto L9;
        if (isPackageOrComponentAllowed(component.getPackageName(), userId) == true) goto L9;
        return false;
    L9:
        return componentHasBindPermission(component, userId);
    }

    private boolean componentHasBindPermission(ComponentName component, int userId) {
        ServiceInfo info = getServiceInfo(component, userId);
        if (info != null) goto L7;
        return false;
    L7:
        return this.mConfig.bindPermission.equals(info.permission);
    }

    boolean isPackageOrComponentUserSet(String pkgOrComponent, int userId) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArraySet<String> services = this.mUserSetServices.get(Integer.valueOf(userId));     // Catch: Throwable -> L9
        if (services != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (services.contains(pkgOrComponent) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    protected boolean isPackageAllowed(String pkg, int userId) {
        if (pkg != null) goto L5;
        return false;
    L5:
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r1 = this.mApproved;
        monitor-enter(r1);
        ArrayMap<Boolean, ArraySet<String>> allowedByType = this.mApproved.getOrDefault(Integer.valueOf(userId), new ArrayMap());     // Catch: Throwable -> L19
        int i = 0;
    L9:
        if (i >= allowedByType.size()) goto L28;
        ArraySet<String> allowed = allowedByType.valueAt(i);     // Catch: Throwable -> L19
        Iterator<String> r5 = allowed.iterator();     // Catch: Throwable -> L19
    L12:
        if (r5.hasNext() == false) goto L26;
        String allowedEntry = r5.next();     // Catch: Throwable -> L19
        ComponentName component = ComponentName.unflattenFromString(allowedEntry);     // Catch: Throwable -> L19
        if (component == null) goto L22;
        if (pkg.equals(component.getPackageName()) == false) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L19
        return true;
    L22:
        if (pkg.equals(allowedEntry) == false) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L19
        return true;
    L26:
        i = i + 1;     // Catch: Throwable -> L19
        goto L9
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return false;
    L19:
        th = move-exception;
        throw th;
    }

    public void onPackagesChanged(boolean removingPackage, String[] pkgList, int[] uidList) {
        if (this.DEBUG == false) goto L17;
        Object r0 = this.mMutex;
        monitor-enter(r0);
        String r2 = this.TAG;     // Catch: Throwable -> L14
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L14
        r3.append("onPackagesChanged removingPackage=");     // Catch: Throwable -> L14
        r3.append(removingPackage);     // Catch: Throwable -> L14
        r3.append(" pkgList=");     // Catch: Throwable -> L14
        if (pkgList != null) goto L10;
        List r4 = null;
    L11:
        r3.append(r4);     // Catch: Throwable -> L14
        r3.append(" mEnabledServicesPackageNames=");     // Catch: Throwable -> L14
        r3.append(this.mEnabledServicesPackageNamesByUser.get(-2));     // Catch: Throwable -> L14
        Slog.d(r2, r3.toString());     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        goto L17
    L10:
        r4 = Arrays.asList(pkgList);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        if (pkgList != null) goto L19;
        return;
    L19:
        if (pkgList.length <= 0) goto L55;
        boolean anyServicesInvolved = false;
        if (removingPackage == false) goto L26;
        if (uidList == null) goto L26;
        int size = Math.min(pkgList.length, uidList.length);
        int i = 0;
    L24:
        if (i >= size) goto L26;
        String pkg = pkgList[i];
        int userId = UserHandle.getUserId(uidList[i]);
        anyServicesInvolved = removeUninstalledItemsFromApprovedLists(userId, pkg);
        i = i + 1;
    L26:
        int size2 = pkgList.length;
        int r5 = 0;
    L27:
        if (r5 >= size2) goto L42;
        String pkgName = pkgList[r5];
        if (isComponentEnabledForPackage(pkgName) == false) goto L31;
        anyServicesInvolved = true;
    L31:
        if (uidList == null) goto L41;
        if (uidList.length <= 0) goto L41;
        int r6 = uidList.length;
        int r7 = 0;
    L36:
        if (r7 >= r6) goto L41;
        int uid = uidList[r7];
        if (isPackageAllowed(pkgName, UserHandle.getUserId(uid)) == false) goto L40;
        anyServicesInvolved = true;
        trimApprovedListsForInvalidServices(pkgName, UserHandle.getUserId(uid));
    L40:
        r7 = r7 + 1;
    L41:
        r5 = r5 + 1;
        goto L27
    L42:
        if (anyServicesInvolved == false) goto L56;
        rebindServices(false, -1);
        return;
    L56:
        return;
    }

    public void onUserRemoved(int user) {
        Slog.i(this.TAG, "Removing approved services for removed user " + user);
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        this.mApproved.remove(Integer.valueOf(user));     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        SparseSetArray<ComponentName> r1 = this.mSnoozing;
        monitor-enter(r1);
        this.mSnoozing.remove(user);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        unbindUserServices(user);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    public void onUserStopped(int user) {
    }

    public void onUserSwitched(int user) {
        if (this.DEBUG == false) goto L5;
        Slog.d(this.TAG, "onUserSwitched u=" + user);
    L5:
        unbindOtherUserServices(user);
        rebindServices(true, user);
    }

    public void onUserUnlocked(int user) {
        if (this.DEBUG == false) goto L5;
        Slog.d(this.TAG, "onUserUnlocked u=" + user);
    L5:
        rebindServices(false, user);
    }

    private ManagedServiceInfo getServiceFromTokenLocked(IInterface service) {
        if (service != null) goto L5;
        return null;
    L5:
        IBinder token = service.asBinder();
        Object r2 = this.mMutex;
        monitor-enter(r2);
        int nServices = this.mServices.size();     // Catch: Throwable -> L13
        int i = 0;
    L8:
        if (i >= nServices) goto L17;
        ManagedServiceInfo info = this.mServices.get(i);     // Catch: Throwable -> L13
        if (info.service.asBinder() == token) goto L11;
        i = i + 1;     // Catch: Throwable -> L13
        goto L8
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return info;
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    protected boolean isServiceTokenValidLocked(IInterface service) {
        if (service != null) goto L5;
        return false;
    L5:
        ManagedServiceInfo info = getServiceFromTokenLocked(service);
        if (info == null) goto L9;
        return true;
    L9:
        return false;
    }

    protected ManagedServiceInfo checkServiceTokenLocked(IInterface service) {
        checkNotNull(service);
        ManagedServiceInfo info = getServiceFromTokenLocked(service);
        if (info == null) goto L6;
        return info;
    L6:
        throw new SecurityException("Disallowed call from unknown " + getCaption() + ": " + service.asBinder() + " " + service.getClass());
    }

    public boolean isSameUser(IInterface service, int userId) {
        checkNotNull(service);
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ManagedServiceInfo info = getServiceFromTokenLocked(service);     // Catch: Throwable -> L9
        if (info == null) goto L11;
        boolean r2 = info.isSameUser(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    public void unregisterService(IInterface service, int userid) {
        checkNotNull(service);
        unregisterServiceImpl(service, userid);
    }

    public void registerSystemService(IInterface service, ComponentName component, int userid, int uid) {
        checkNotNull(service);
        ManagedServiceInfo info = registerServiceImpl(service, component, userid, 10000, uid);
        if (info == null) goto L6;
        onServiceAdded(info);
        return;
    }

    protected void registerGuestService(ManagedServiceInfo guest) {
        checkNotNull(guest.service);
        if (checkType(guest.service) == false) goto L9;
        if (registerServiceImpl(guest) == null) goto L10;
        onServiceAdded(guest);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException();
    }

    protected void setComponentState(ComponentName component, int userId, boolean enabled) {
        SparseSetArray<ComponentName> r0 = this.mSnoozing;
        monitor-enter(r0);
        boolean previous = !this.mSnoozing.contains(userId, component);     // Catch: Throwable -> L8
        if (previous != enabled) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (enabled == false) goto L12;
        this.mSnoozing.remove(userId, component);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        String r1 = this.TAG;
        StringBuilder r2 = new StringBuilder();
        if (enabled == false) goto L17;
        String r3 = "Enabling ";
    L18:
        r2.append(r3);
        r2.append("component ");
        r2.append(component.flattenToShortString());
        Slog.d(r1, r2.toString());
        Object r4 = this.mMutex;
        monitor-enter(r4);
        if (enabled == true) goto L22;
        unregisterServiceLocked(component, userId);     // Catch: Throwable -> L24
    L28:
        monitor-exit(r4);     // Catch: Throwable -> L24
        return;
    L22:
        if (isPackageOrComponentAllowedWithPermission(component, userId) == false) goto L26;
        registerServiceLocked(component, userId);     // Catch: Throwable -> L24
        goto L28
    L26:
        Slog.d(this.TAG, component + " no longer has permission to be bound");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L17:
        r3 = "Disabling ";
        goto L18
    L12:
        this.mSnoozing.add(userId, component);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private ArraySet<ComponentName> loadComponentNamesFromValues(ArraySet<String> approved, int userId) {
        if (approved == null) goto L19;
        if (approved.size() == 0) goto L19;
        ArraySet<ComponentName> result = new ArraySet(approved.size());
        int i = 0;
    L8:
        if (i >= approved.size()) goto L17;
        String packageOrComponent = approved.valueAt(i);
        if (TextUtils.isEmpty(packageOrComponent) == true) goto L15;
        ComponentName component = ComponentName.unflattenFromString(packageOrComponent);
        if (component == null) goto L14;
        result.add(component);
        goto L15
    L14:
        result.addAll(queryPackageForServices(packageOrComponent, userId));
    L15:
        i = i + 1;
        goto L8
    L17:
        return result;
    L19:
        return new ArraySet();
    }

    protected Set<ComponentName> queryPackageForServices(String packageName, int userId) {
        return queryPackageForServices(packageName, 0, userId);
    }

    protected ArraySet<ComponentName> queryPackageForServices(String packageName, int extraFlags, int userId) {
        ArraySet<ComponentName> installed = new ArraySet();
        PackageManager pm = this.mContext.getPackageManager();
        Intent queryIntent = new Intent(this.mConfig.serviceInterface);
        if (TextUtils.isEmpty(packageName) == true) goto L5;
        queryIntent.setPackage(packageName);
    L5:
        List<ResolveInfo> installedServices = pm.queryIntentServicesAsUser(queryIntent, extraFlags | 132, userId);
        if (this.DEBUG == false) goto L8;
        Slog.v(this.TAG, this.mConfig.serviceInterface + " services: " + installedServices);
    L8:
        if (installedServices == null) goto L16;
        int i = 0;
        int count = installedServices.size();
    L10:
        if (i >= count) goto L16;
        ResolveInfo resolveInfo = installedServices.get(i);
        ServiceInfo info = resolveInfo.serviceInfo;
        ComponentName component = new ComponentName(info.packageName, info.name);
        if (this.mConfig.bindPermission.equals(info.permission) == true) goto L14;
        Slog.w(this.TAG, "Skipping " + getCaption() + " service " + info.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + info.name + ": it does not require the permission " + this.mConfig.bindPermission);
    L15:
        i = i + 1;
        goto L10
    L14:
        installed.add(component);
    L16:
        return installed;
    }

    private void trimApprovedListsAccordingToInstalledServices(int userId) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L8
        if (approvedByType != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = 0;
    L12:
        if (i >= approvedByType.size()) goto L24;
        ArraySet<String> approved = approvedByType.valueAt(i);     // Catch: Throwable -> L8
        int j = approved.size() - 1;     // Catch: Throwable -> L8
    L14:
        if (j < 0) goto L22;
        String approvedPackageOrComponent = approved.valueAt(j);     // Catch: Throwable -> L8
        if (isValidEntry(approvedPackageOrComponent, userId) == true) goto L19;
        approved.removeAt(j);     // Catch: Throwable -> L8
        Slog.v(this.TAG, "Removing " + approvedPackageOrComponent + " from approved list; no matching services found");     // Catch: Throwable -> L8
    L21:
        j = j - 1;     // Catch: Throwable -> L8
        goto L14
    L19:
        if (this.DEBUG == false) goto L21;
        Slog.v(this.TAG, "Keeping " + approvedPackageOrComponent + " on approved list; matching services found");     // Catch: Throwable -> L8
        goto L21
    L22:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean removeUninstalledItemsFromApprovedLists(int uninstalledUserId, String pkg) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r1 = this.mApproved;
        monitor-enter(r1);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(uninstalledUserId));     // Catch: Throwable -> L15
        if (approvedByType == null) goto L19;
        int M = approvedByType.size();     // Catch: Throwable -> L15
        int j = 0;
    L7:
        if (j >= M) goto L19;
        ArraySet<String> approved = approvedByType.valueAt(j);     // Catch: Throwable -> L15
        int O = approved.size();     // Catch: Throwable -> L15
        int k = O - 1;     // Catch: Throwable -> L15
    L9:
        if (k < 0) goto L18;
        String packageOrComponent = approved.valueAt(k);     // Catch: Throwable -> L15
        String packageName = getPackageName(packageOrComponent);     // Catch: Throwable -> L15
        if (TextUtils.equals(pkg, packageName) == false) goto L17;
        approved.removeAt(k);     // Catch: Throwable -> L15
        if (this.DEBUG == false) goto L17;
        Slog.v(this.TAG, "Removing " + packageOrComponent + " from approved list; uninstalled");     // Catch: Throwable -> L15
    L17:
        k = k - 1;     // Catch: Throwable -> L15
        goto L9
    L18:
        j = j + 1;     // Catch: Throwable -> L15
    L19:
        ArraySet<String> userSet = this.mUserSetServices.get(Integer.valueOf(uninstalledUserId));     // Catch: Throwable -> L15
        if (userSet == null) goto L29;
        int numServices = userSet.size();     // Catch: Throwable -> L15
        int i = numServices - 1;     // Catch: Throwable -> L15
    L22:
        if (i < 0) goto L29;
        String pkgOrComponent = userSet.valueAt(i);     // Catch: Throwable -> L15
        if (TextUtils.equals(pkg, getPackageName(pkgOrComponent)) == false) goto L28;
        userSet.removeAt(i);     // Catch: Throwable -> L15
        if (this.DEBUG == false) goto L28;
        Slog.v(this.TAG, "Removing " + pkgOrComponent + " from user-set list; uninstalled");     // Catch: Throwable -> L15
    L28:
        i = i - 1;     // Catch: Throwable -> L15
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    private void trimApprovedListsForInvalidServices(String packageName, int userId) {
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r0 = this.mApproved;
        monitor-enter(r0);
        ArrayMap<Boolean, ArraySet<String>> approvedByType = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L8
        if (approvedByType != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int i = 0;
    L12:
        if (i >= approvedByType.size()) goto L27;
        ArraySet<String> approved = approvedByType.valueAt(i);     // Catch: Throwable -> L8
        int j = approved.size() - 1;     // Catch: Throwable -> L8
    L14:
        if (j < 0) goto L25;
        String approvedPackageOrComponent = approved.valueAt(j);     // Catch: Throwable -> L8
        if (TextUtils.equals(getPackageName(approvedPackageOrComponent), packageName) == false) goto L24;
        ComponentName component = ComponentName.unflattenFromString(approvedPackageOrComponent);     // Catch: Throwable -> L8
        if (component == null) goto L24;
        if (componentHasBindPermission(component, userId) == true) goto L24;
        approved.removeAt(j);     // Catch: Throwable -> L8
        if (this.DEBUG == false) goto L24;
        Slog.v(this.TAG, "Removing " + approvedPackageOrComponent + " from approved list; no bind permission found " + this.mConfig.bindPermission);     // Catch: Throwable -> L8
    L24:
        j = j - 1;     // Catch: Throwable -> L8
        goto L14
    L25:
        i = i + 1;     // Catch: Throwable -> L8
        goto L12
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    protected String getPackageName(String packageOrComponent) {
        ComponentName component = ComponentName.unflattenFromString(packageOrComponent);
        if (component != null) goto L5;
        return packageOrComponent;
    L5:
        return component.getPackageName();
    }

    protected boolean isValidEntry(String packageOrComponent, int userId) {
        return hasMatchingServices(packageOrComponent, userId);
    }

    private boolean hasMatchingServices(String packageOrComponent, int userId) {
        if (TextUtils.isEmpty(packageOrComponent) == true) goto L8;
        String packageName = getPackageName(packageOrComponent);
        if (queryPackageForServices(packageName, userId).size() <= 0) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    protected SparseArray<ArraySet<ComponentName>> getAllowedComponents(IntArray userIds) {
        int nUserIds = userIds.size();
        SparseArray<ArraySet<ComponentName>> componentsByUser = new SparseArray();
        int i = 0;
    L3:
        if (i >= nUserIds) goto L21;
        int userId = userIds.get(i);
        ArrayMap<Integer, ArrayMap<Boolean, ArraySet<String>>> r4 = this.mApproved;
        monitor-enter(r4);
        ArrayMap<Boolean, ArraySet<String>> approvedLists = this.mApproved.get(Integer.valueOf(userId));     // Catch: Throwable -> L13
        if (approvedLists == null) goto L16;
        int N = approvedLists.size();     // Catch: Throwable -> L13
        int j = 0;
    L9:
        if (j >= N) goto L16;
        ArraySet<ComponentName> approvedByUser = componentsByUser.get(userId);     // Catch: Throwable -> L13
        if (approvedByUser != null) goto L15;
        approvedByUser = new ArraySet();     // Catch: Throwable -> L13
        componentsByUser.put(userId, approvedByUser);     // Catch: Throwable -> L13
    L15:
        approvedByUser.addAll(loadComponentNamesFromValues(approvedLists.valueAt(j), userId));     // Catch: Throwable -> L13
        j = j + 1;     // Catch: Throwable -> L13
    L16:
        monitor-exit(r4);     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L21:
        return componentsByUser;
    }

    protected void populateComponentsToBind(SparseArray<Set<ComponentName>> componentsToBind, IntArray activeUsers, SparseArray<ArraySet<ComponentName>> approvedComponentsByUser) {
        int nUserIds = activeUsers.size();
        this.mEnabledServicesByUser.get(-2).clear();
        this.mEnabledServicesPackageNamesByUser.get(-2).clear();
        int i = 0;
    L3:
        if (i >= nUserIds) goto L32;
        int userId = activeUsers.get(i);
        ArraySet<ComponentName> userComponents = approvedComponentsByUser.get(userId);
        if (userComponents != null) goto L8;
        componentsToBind.put(userId, new ArraySet());
    L28:
        i = i + 1;
        goto L3
    L8:
        if (this.mEnabledServicesByUser.contains(-2) == false) goto L10;
        ArraySet<ComponentName> enabledServices = this.mEnabledServicesByUser.get(-2);
    L12:
        if (this.mEnabledServicesPackageNamesByUser.contains(-2) == false) goto L14;
        ArraySet<String> enabledServicesPackageName = this.mEnabledServicesPackageNamesByUser.get(-2);
    L15:
        Set<ComponentName> add = new HashSet(userComponents);
        SparseSetArray<ComponentName> r9 = this.mSnoozing;
        monitor-enter(r9);
        ArraySet<ComponentName> snoozed = this.mSnoozing.get(userId);     // Catch: Throwable -> L20
        if (snoozed == null) goto L22;
        add.removeAll(snoozed);     // Catch: Throwable -> L20
    L22:
        monitor-exit(r9);     // Catch: Throwable -> L20
        componentsToBind.put(userId, add);
        enabledServices.addAll(userComponents);
        int j = 0;
    L25:
        if (j >= userComponents.size()) goto L27;
        enabledServicesPackageName.add(userComponents.valueAt(j).getPackageName());
        j = j + 1;
        goto L25
    L27:
        this.mEnabledServicesByUser.put(-2, enabledServices);
        this.mEnabledServicesPackageNamesByUser.put(-2, enabledServicesPackageName);
    L20:
        th = move-exception;
        throw th;
    L14:
        enabledServicesPackageName = new ArraySet();
        goto L15
    L10:
        enabledServices = new ArraySet();
        goto L12
    }

    protected Set<ManagedServiceInfo> getRemovableConnectedServices() {
        Set<ManagedServiceInfo> removableBoundServices = new ArraySet();
        Iterator<ManagedServiceInfo> r1 = this.mServices.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        ManagedServiceInfo service = r1.next();
        if (service.isSystem == true) goto L4;
        if (service.isGuest(this) == true) goto L4;
        removableBoundServices.add(service);
        goto L4
    L11:
        return removableBoundServices;
    }

    protected void populateComponentsToUnbind(boolean forceRebind, Set<ManagedServiceInfo> removableBoundServices, SparseArray<Set<ComponentName>> allowedComponentsToBind, SparseArray<Set<ComponentName>> componentsToUnbind) {
        Iterator<ManagedServiceInfo> r0 = removableBoundServices.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ManagedServiceInfo info = r0.next();
        Set<ComponentName> allowedComponents = allowedComponentsToBind.get(info.userid);
        if (allowedComponents == null) goto L4;
        if (forceRebind == true) goto L10;
        if (allowedComponents.contains(info.component) == true) goto L4;
    L10:
        Set<ComponentName> toUnbind = componentsToUnbind.get(info.userid, new ArraySet());
        toUnbind.add(info.component);
        componentsToUnbind.put(info.userid, toUnbind);
        goto L4
    }

    protected void rebindServices(boolean forceRebind, int userToRebind) {
        if (this.DEBUG == false) goto L6;
        Slog.d(this.TAG, "rebindServices " + forceRebind + " " + userToRebind);
    L6:
        if (this.mUserProfiles.isProfileUser(userToRebind, this.mContext) == true) goto L8;
    L10:
        boolean rebindAllCurrentUsers = false;
    L11:
        IntArray userIds = getUserIdsForRebindServices(userToRebind, rebindAllCurrentUsers);
        SparseArray<Set<ComponentName>> componentsToBind = new SparseArray();
        SparseArray<Set<ComponentName>> componentsToUnbind = new SparseArray();
        Object r4 = this.mMutex;
        monitor-enter(r4);
        SparseArray<ArraySet<ComponentName>> approvedComponentsByUser = getAllowedComponents(userIds);     // Catch: Throwable -> L17
        Set<ManagedServiceInfo> removableBoundServices = getRemovableConnectedServices();     // Catch: Throwable -> L17
        populateComponentsToBind(componentsToBind, userIds, approvedComponentsByUser);     // Catch: Throwable -> L17
        populateComponentsToUnbind(forceRebind, removableBoundServices, componentsToBind, componentsToUnbind);     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        unbindFromServices(componentsToUnbind);
        bindToServices(componentsToBind);
        return;
    L17:
        th = move-exception;
        throw th;
    L8:
        if (allowRebindForParentUser() == false) goto L10;
        rebindAllCurrentUsers = true;
        goto L11
    }

    private IntArray getUserIdsForRebindServices(int userToRebind, boolean rebindAllCurrentUsers) {
        IntArray userIds = this.mUserProfiles.getCurrentProfileIds();
        if (userToRebind == (-1)) goto L8;
        if (rebindAllCurrentUsers == true) goto L9;
        IntArray userIds2 = new IntArray(1);
        userIds2.add(userToRebind);
        return userIds2;
    L9:
        return userIds;
    L8:
        return userIds;
    }

    void unbindOtherUserServices(int currentUser) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("ManagedServices.unbindOtherUserServices_current" + currentUser);
        unbindServicesImpl(currentUser, true);
        t.traceEnd();
    }

    void unbindUserServices(int user) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("ManagedServices.unbindUserServices" + user);
        unbindServicesImpl(user, false);
        t.traceEnd();
    }

    void unbindServicesImpl(int user, boolean allExceptUser) {
        SparseArray<Set<ComponentName>> componentsToUnbind = new SparseArray();
        Object r1 = this.mMutex;
        monitor-enter(r1);
        Set<ManagedServiceInfo> removableBoundServices = getRemovableConnectedServices();     // Catch: Throwable -> L12
        Iterator<ManagedServiceInfo> r3 = removableBoundServices.iterator();     // Catch: Throwable -> L12
    L6:
        if (r3.hasNext() == false) goto L19;
        ManagedServiceInfo info = r3.next();     // Catch: Throwable -> L12
        if (allExceptUser == true) goto L10;
    L14:
        if (allExceptUser == true) goto L6;
        if (info.userid != user) goto L6;
    L17:
        Set<ComponentName> toUnbind = componentsToUnbind.get(info.userid, new ArraySet());     // Catch: Throwable -> L12
        toUnbind.add(info.component);     // Catch: Throwable -> L12
        componentsToUnbind.put(info.userid, toUnbind);     // Catch: Throwable -> L12
        goto L6
    L10:
        if (info.userid == user) goto L14;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L12
        unbindFromServices(componentsToUnbind);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    protected void unbindFromServices(SparseArray<Set<ComponentName>> componentsToUnbind) {
        int i = 0;
    L4:
        if (i >= componentsToUnbind.size()) goto L11;
        int userId = componentsToUnbind.keyAt(i);
        Set<ComponentName> removableComponents = componentsToUnbind.get(userId);
        Iterator<ComponentName> r3 = removableComponents.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        ComponentName cn = r3.next();
        Slog.v(this.TAG, "disabling " + getCaption() + " for user " + userId + ": " + cn);
        unregisterService(cn, userId);
        goto L7
    L9:
        i = i + 1;
        goto L4
    }

    private void bindToServices(SparseArray<Set<ComponentName>> componentsToBind) {
        int i = 0;
    L4:
        if (i >= componentsToBind.size()) goto L29;
        int userId = componentsToBind.keyAt(i);
        Set<ComponentName> add = componentsToBind.get(userId);
        Iterator<ComponentName> r3 = add.iterator();
    L7:
        if (r3.hasNext() == false) goto L27;
        ComponentName component = r3.next();
        ServiceInfo info = getServiceInfo(component, userId);
        if (info == null) goto L10;
        if (this.mConfig.bindPermission.equals(info.permission) == false) goto L13;
        if (isAutobindAllowed(info) == true) goto L26;
        if (isBoundOrRebinding(component, userId) == true) goto L26;
        SparseSetArray<ComponentName> r6 = this.mSnoozing;
        monitor-enter(r6);
        Slog.d(this.TAG, "Not binding " + getCaption() + " service " + component + ": has META_DATA_DEFAULT_AUTOBIND = false");     // Catch: Throwable -> L23
        this.mSnoozing.add(userId, component);     // Catch: Throwable -> L23
        monitor-exit(r6);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L26:
        Slog.v(this.TAG, "enabling " + getCaption() + " for " + userId + ": " + component);
        registerService(info, userId);
        goto L7
    L13:
        Slog.w(this.TAG, "Not binding " + getCaption() + " service " + component + ": it does not require the permission " + this.mConfig.bindPermission);
        goto L7
    L10:
        Slog.w(this.TAG, "Not binding " + getCaption() + " service " + component + ": service not found");
        goto L7
    L27:
        i = i + 1;
        goto L4
    }

    void registerService(ServiceInfo si, int userId) {
        ensureFilters(si, userId);
        registerService(si.getComponentName(), userId);
    }

    void registerService(ComponentName cn, int userId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        registerServiceLocked(cn, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void reregisterService(ComponentName cn, int userId) {
        if (isPackageOrComponentAllowedWithPermission(cn, userId) == false) goto L6;
        registerService(cn, userId);
        return;
    L6:
        if (this.DEBUG == false) goto L10;
        Slog.v(this.TAG, "skipped reregisterService cn=" + cn + " u=" + userId + " because of isPackageOrComponentAllowedWithPermission check");
        return;
    }

    public void registerSystemService(ComponentName name, int userid) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        registerServiceLocked(name, userid, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void registerServiceLocked(ComponentName name, int userid) {
        registerServiceLocked(name, userid, false);
    }

    private void registerServiceLocked(ComponentName name, int userid, boolean isSystem) {
        if (this.DEBUG == false) goto L5;
        Slog.v(this.TAG, "registerService: " + name + " u=" + userid);
    L5:
        Pair<ComponentName, Integer> servicesBindingTag = Pair.create(name, Integer.valueOf(userid));
        if (this.mServicesBound.contains(servicesBindingTag) == false) goto L9;
        Slog.v(this.TAG, "Not registering " + name + " is already bound");
        return;
    L9:
        this.mServicesBound.add(servicesBindingTag);
        int N = this.mServices.size();
        int i = N - 1;
    L10:
        if (i < 0) goto L19;
        ManagedServiceInfo info = this.mServices.get(i);
        if (name.equals(info.component) == false) goto L18;
        if (info.userid != userid) goto L18;
        Slog.v(this.TAG, "    disconnecting old " + getCaption() + ": " + info.service);
        removeServiceLocked(i);
        if (info.connection == null) goto L18;
        unbindService(info.connection, info.component, info.userid);
    L18:
        i = i - 1;
        goto L10
    L19:
        Intent intent = new Intent(this.mConfig.serviceInterface);
        intent.setComponent(name);
        intent.putExtra("android.intent.extra.client_label", this.mConfig.clientLabel);
        ActivityOptions activityOptions = ActivityOptions.makeBasic();
        activityOptions.setPendingIntentCreatorBackgroundActivityStartMode(2);
        PendingIntent pendingIntent = PendingIntent.getActivity(this.mContext, 0, new Intent(this.mConfig.settingsAction), 67108864, activityOptions.toBundle());
        intent.putExtra("android.intent.extra.client_intent", pendingIntent);
        ApplicationInfo appInfo = this.mContext.getPackageManager().getApplicationInfoAsUser(name.getPackageName(), 0, userid);     // Catch: PackageManager.NameNotFoundException -> L22
        ApplicationInfo appInfo2 = appInfo;
    L24:
        if (appInfo2 == null) goto L27;
        int r0 = appInfo2.targetSdkVersion;
    L26:
        int targetSdkVersion = r0;
        if (appInfo2 == null) goto L31;
        int r1 = appInfo2.uid;
    L30:
        int uid = r1;
        Slog.v(this.TAG, "binding: " + intent);     // Catch: SecurityException -> L41
        ServiceConnection serviceConnection = new AnonymousClass1(this, userid, servicesBindingTag, isSystem, targetSdkVersion, uid);     // Catch: SecurityException -> L41
    L38:
        ex = e;
    L43:
        this.mServicesBound.remove(servicesBindingTag);
        Slog.e(this.TAG, "Unable to bind " + getCaption() + " service: " + intent, ex);
        return;
    L35:
        if (this.mContext.bindServiceAsUser(intent, serviceConnection, getBindFlags(), new UserHandle(userid)) == true) goto L56;
        this.mServicesBound.remove(servicesBindingTag);     // Catch: SecurityException -> L38
        Slog.w(this.TAG, "Unable to bind " + getCaption() + " service: " + intent + " in user " + userid);     // Catch: SecurityException -> L38
        return;
    L56:
        return;
    L41:
        ex = e;
        goto L43
    L31:
        r1 = -1;
        goto L30
    L27:
        r0 = 1;
    L23:
        appInfo2 = null;
        goto L24
    }

    boolean isBound(ComponentName cn, int userId) {
        Pair<ComponentName, Integer> servicesBindingTag = Pair.create(cn, Integer.valueOf(userId));
        Object r1 = this.mMutex;
        monitor-enter(r1);
        boolean r2 = this.mServicesBound.contains(servicesBindingTag);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isBoundOrRebinding(ComponentName cn, int userId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isBound(cn, userId) == true) goto L12;
        if (this.mServicesRebinding.contains(Pair.create(cn, Integer.valueOf(userId))) == true) goto L12;
        boolean r1 = false;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L12:
        r1 = true;
        goto L13
    }

    private void unregisterService(ComponentName name, int userid) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        unregisterServiceLocked(name, userid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void unregisterServiceLocked(ComponentName name, int userid) {
        int N = this.mServices.size();
        int i = N - 1;
    L3:
        if (i < 0) goto L13;
        ManagedServiceInfo info = this.mServices.get(i);
        if (name.equals(info.component) == false) goto L11;
        if (info.userid != userid) goto L11;
        removeServiceLocked(i);
        if (info.connection == null) goto L11;
        unbindService(info.connection, info.component, info.userid);
    L11:
        i = i - 1;
        goto L3
    }

    private ManagedServiceInfo removeServiceImpl(IInterface service, int userid) {
        if (this.DEBUG == false) goto L5;
        Slog.d(this.TAG, "removeServiceImpl service=" + service + " u=" + userid);
    L5:
        ManagedServiceInfo serviceInfo = null;
        Object r1 = this.mMutex;
        monitor-enter(r1);
        int N = this.mServices.size();     // Catch: Throwable -> L14
        int i = N - 1;     // Catch: Throwable -> L14
    L8:
        if (i < 0) goto L18;
        ManagedServiceInfo info = this.mServices.get(i);     // Catch: Throwable -> L14
        if (info.service.asBinder() != service.asBinder()) goto L16;
        if (info.userid != userid) goto L16;
        Slog.d(this.TAG, "Removing active service " + info.component);     // Catch: Throwable -> L14
        serviceInfo = removeServiceLocked(i);     // Catch: Throwable -> L14
    L16:
        i = i - 1;     // Catch: Throwable -> L14
        goto L8
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return serviceInfo;
    L14:
        th = move-exception;
        throw th;
    }

    private ManagedServiceInfo removeServiceLocked(int i) {
        ManagedServiceInfo info = this.mServices.remove(i);
        onServiceRemovedLocked(info);
        return info;
    }

    private void checkNotNull(IInterface service) {
        if (service == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(getCaption() + " must not be null");
    }

    private ManagedServiceInfo registerServiceImpl(IInterface service, ComponentName component, int userid, int targetSdk, int uid) {
        ManagedServiceInfo info = newServiceInfo(service, component, userid, true, null, targetSdk, uid);
        return registerServiceImpl(info);
    }

    private ManagedServiceInfo registerServiceImpl(ManagedServiceInfo info) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        info.service.asBinder().linkToDeath(info, 0);     // Catch: Throwable -> L7 RemoteException -> L9
        this.mServices.add(info);     // Catch: Throwable -> L7 RemoteException -> L9
        monitor-exit(r0);     // Catch: Throwable -> L7
        return info;
    L7:
        th = move-exception;
        throw th;
    L11:
        return null;
    }

    private void unregisterServiceImpl(IInterface service, int userid) {
        ManagedServiceInfo info = removeServiceImpl(service, userid);
        if (info != null) goto L5;
        return;
    L5:
        if (info.connection != null) goto L7;
        return;
    L7:
        if (info.isGuest(this) == true) goto L12;
        unbindService(info.connection, info.component, info.userid);
        return;
    }

    private void unbindService(ServiceConnection connection, ComponentName component, int userId) {
        this.mContext.unbindService(connection);     // Catch: IllegalArgumentException -> L4
    L6:
        Object r0 = this.mMutex;
        monitor-enter(r0);
        this.mServicesBound.remove(Pair.create(component, Integer.valueOf(userId)));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L4:
        e = move-exception;
        Slog.e(this.TAG, getCaption() + " " + component + " could not be unbound", e);
        goto L6
    }

    private ServiceInfo getServiceInfo(ComponentName component, int userId) {
        return this.mPm.getServiceInfo(component, 786560, userId);
    L4:
        e = move-exception;
        e.rethrowFromSystemServer();
        return null;
    }

    private boolean isAutobindAllowed(ServiceInfo serviceInfo) {
        if (serviceInfo != null) goto L5;
    L10:
        return true;
    L5:
        if (serviceInfo.metaData == null) goto L10;
        if (serviceInfo.metaData.containsKey("android.service.notification.default_autobind_listenerservice") == false) goto L10;
        return serviceInfo.metaData.getBoolean("android.service.notification.default_autobind_listenerservice", true);
    }

    public int resolveUserId(int userId) {
        return -2;
    }

    public boolean isComponentEnabledForCurrentProfiles(ComponentName component) {
        return isComponentEnabledForUser(component, -2);
    }

    public boolean isComponentEnabledForUser(ComponentName component, int userId) {
        Object r0 = this.mMutex;
        monitor-enter(r0);
        ArraySet<ComponentName> enabledServicesForUser = this.mEnabledServicesByUser.get(resolveUserId(userId));     // Catch: Throwable -> L9
        if (enabledServicesForUser != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (enabledServicesForUser.contains(component) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }
}
