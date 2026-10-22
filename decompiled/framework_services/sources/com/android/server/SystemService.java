package com.android.server;

import android.annotation.SystemApi;
import android.app.ActivityThread;
import android.content.Context;
import android.content.pm.UserInfo;
import android.os.IBinder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public abstract class SystemService {
    protected static final boolean DEBUG_USER = false;
    public static final int PHASE_ACTIVITY_MANAGER_READY = 550;
    public static final int PHASE_BOOT_COMPLETED = 1000;
    public static final int PHASE_DEVICE_SPECIFIC_SERVICES_READY = 520;
    public static final int PHASE_LOCK_SETTINGS_READY = 480;
    public static final int PHASE_SYSTEM_SERVICES_READY = 500;
    public static final int PHASE_THIRD_PARTY_APPS_CAN_START = 600;
    public static final int PHASE_WAIT_FOR_DEFAULT_DISPLAY = 100;
    public static final int PHASE_WAIT_FOR_SENSOR_SERVICE = 200;
    private final Context mContext;
    private final List<Class<?>> mDependencies;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BootPhase {
    }

    @SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
    public static final class TargetUser {
        private final boolean mFull;
        private final boolean mPreCreated;
        private final boolean mProfile;
        private final int mUserId;
        private final String mUserType;

        public TargetUser(UserInfo userInfo) {
            this.mUserId = userInfo.id;
            this.mFull = userInfo.isFull();
            this.mProfile = userInfo.isProfile();
            this.mUserType = userInfo.userType;
            this.mPreCreated = userInfo.preCreated;
        }

        public boolean isFull() {
            return this.mFull;
        }

        public boolean isProfile() {
            return this.mProfile;
        }

        public boolean isManagedProfile() {
            return UserManager.isUserTypeManagedProfile(this.mUserType);
        }

        public boolean isPreCreated() {
            return this.mPreCreated;
        }

        public UserHandle getUserHandle() {
            return UserHandle.of(this.mUserId);
        }

        public int getUserIdentifier() {
            return this.mUserId;
        }

        public String toString() {
            return Integer.toString(this.mUserId);
        }

        public void dump(PrintWriter pw) {
            pw.print(getUserIdentifier());
            if (isFull() == false) goto L5;
        L7:
            pw.print('(');
            if (isFull() == false) goto L11;
            pw.print("full");
        L11:
            if (isProfile() == false) goto L15;
            if (0 == 0) goto L14;
            pw.print(',');
        L14:
            pw.print("profile");
        L15:
            pw.print(')');
            return;
        L5:
            if (isProfile() == true) goto L7;
        }
    }

    public static final class UserCompletedEventType {
        public static final int EVENT_TYPE_USER_STARTING = 1;
        public static final int EVENT_TYPE_USER_SWITCHING = 4;
        public static final int EVENT_TYPE_USER_UNLOCKED = 2;
        private final int mEventType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventTypesFlag {
        }

        UserCompletedEventType(int eventType) {
            this.mEventType = eventType;
        }

        public static UserCompletedEventType newUserCompletedEventTypeForTest(int eventType) {
            return new UserCompletedEventType(eventType);
        }

        public boolean includesOnUserStarting() {
            if ((this.mEventType & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean includesOnUserUnlocked() {
            if ((this.mEventType & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean includesOnUserSwitching() {
            if ((this.mEventType & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            if (includesOnUserSwitching() == false) goto L6;
            sb.append("|Switching");
        L6:
            if (includesOnUserUnlocked() == false) goto L9;
            sb.append("|Unlocked");
        L9:
            if (includesOnUserStarting() == false) goto L12;
            sb.append("|Starting");
        L12:
            if (sb.length() <= 1) goto L14;
            sb.append("|");
        L14:
            sb.append("}");
            return sb.toString();
        }
    }

    public abstract void onStart();

    public SystemService(Context context) {
        this(context, Collections.emptyList());
    }

    public SystemService(Context context, List<Class<?>> dependencies) {
        this.mContext = context;
        dependencies.getClass();
        this.mDependencies = dependencies;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Context getUiContext() {
        return ActivityThread.currentActivityThread().getSystemUiContext();
    }

    public final List<Class<?>> getDependencies() {
        return this.mDependencies;
    }

    public final boolean isSafeMode() {
        return getManager().isSafeMode();
    }

    public void onBootPhase(int phase) {
    }

    public boolean isUserSupported(TargetUser user) {
        return true;
    }

    protected void dumpSupportedUsers(PrintWriter pw, String prefix) {
        List<UserInfo> allUsers = UserManager.get(this.mContext).getUsers();
        List<Integer> supportedUsers = new ArrayList(allUsers.size());
        int i = 0;
    L4:
        if (i >= allUsers.size()) goto L10;
        UserInfo user = allUsers.get(i);
        if (isUserSupported(new TargetUser(user)) == false) goto L8;
        supportedUsers.add(Integer.valueOf(user.id));
    L8:
        i = i + 1;
        goto L4
    L10:
        if (supportedUsers.isEmpty() == false) goto L13;
        pw.print(prefix);
        pw.println("No supported users");
        return;
    L13:
        int size = supportedUsers.size();
        pw.print(prefix);
        pw.print(size);
        pw.print(" supported user");
        if (size <= 1) goto L16;
        pw.print("s");
    L16:
        pw.print(": ");
        pw.println(supportedUsers);
    }

    public void onUserStarting(TargetUser user) {
    }

    public void onUserUnlocking(TargetUser user) {
    }

    public void onUserUnlocked(TargetUser user) {
    }

    public void onUserSwitching(TargetUser from, TargetUser to) {
    }

    public void onUserStopping(TargetUser user) {
    }

    public void onUserStopped(TargetUser user) {
    }

    public void onUserCompletedEvent(TargetUser user, UserCompletedEventType eventType) {
    }

    protected final void publishBinderService(String name, IBinder service) {
        publishBinderService(name, service, false);
    }

    protected final void publishBinderService(String name, IBinder service, boolean allowIsolated) {
        publishBinderService(name, service, allowIsolated, 8);
    }

    protected final void publishBinderService(String name, IBinder service, boolean allowIsolated, int dumpPriority) {
        ServiceManager.addService(name, service, allowIsolated, dumpPriority);
    }

    protected final IBinder getBinderService(String name) {
        return ServiceManager.getService(name);
    }

    protected final <T> void publishLocalService(Class<T> type, T service) {
        LocalServices.addService(type, service);
    }

    protected final <T> T getLocalService(Class<T> r2) {
        return (T) LocalServices.getService(r2);
    }

    private SystemServiceManager getManager() {
        return (SystemServiceManager) LocalServices.getService(SystemServiceManager.class);
    }
}
