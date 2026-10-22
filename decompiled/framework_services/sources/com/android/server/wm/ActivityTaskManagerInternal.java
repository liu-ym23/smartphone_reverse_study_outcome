package com.android.server.wm;

import android.app.ActivityManager;
import android.app.IAppTask;
import android.app.IApplicationThread;
import android.app.ITaskStackListener;
import android.app.ProfilerInfo;
import android.content.ComponentName;
import android.content.IIntentSender;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.os.RemoteException;
import android.service.voice.IVoiceInteractionSession;
import android.util.IntArray;
import android.util.proto.ProtoOutputStream;
import android.window.TaskSnapshot;
import com.android.internal.app.IVoiceInteractor;
import com.android.server.am.PendingIntentRecord;
import com.android.server.am.UserState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ActivityTaskManagerInternal {
    public static final int APP_TRANSITION_RECENTS_ANIM = 5;
    public static final int APP_TRANSITION_SNAPSHOT = 4;
    public static final int APP_TRANSITION_SPLASH_SCREEN = 1;
    public static final int APP_TRANSITION_TIMEOUT = 3;
    public static final int APP_TRANSITION_WINDOWS_DRAWN = 2;
    public static final String ASSIST_ACTIVITY_ID = "activityId";
    public static final String ASSIST_KEY_CONTENT = "content";
    public static final String ASSIST_KEY_DATA = "data";
    public static final String ASSIST_KEY_RECEIVER_EXTRAS = "receiverExtras";
    public static final String ASSIST_KEY_STRUCTURE = "structure";
    public static final String ASSIST_TASK_ID = "taskId";

    public final class ActivityTokens {
        private final IBinder mActivityToken;
        private final IApplicationThread mAppThread;
        private final IBinder mAssistToken;
        private final IBinder mShareableActivityToken;
        private final int mUid;

        public ActivityTokens(ActivityTaskManagerInternal this$0, IBinder activityToken, IBinder assistToken, IApplicationThread appThread, IBinder shareableActivityToken, int uid) {
            this.mActivityToken = activityToken;
            this.mAssistToken = assistToken;
            this.mAppThread = appThread;
            this.mShareableActivityToken = shareableActivityToken;
            this.mUid = uid;
        }

        public IBinder getActivityToken() {
            return this.mActivityToken;
        }

        public IBinder getAssistToken() {
            return this.mAssistToken;
        }

        public IBinder getShareableActivityToken() {
            return this.mShareableActivityToken;
        }

        public IApplicationThread getApplicationThread() {
            return this.mAppThread;
        }

        public int getUid() {
            return this.mUid;
        }
    }

    public static class PackageConfig {
        public final Integer mGrammaticalGender;
        public final LocaleList mLocales;
        public final Integer mNightMode;

        public PackageConfig(Integer nightMode, LocaleList locales, Integer grammaticalGender) {
            this.mNightMode = nightMode;
            this.mLocales = locales;
            this.mGrammaticalGender = grammaticalGender;
        }

        public String toString() {
            return "PackageConfig: nightMode " + this.mNightMode + " locales " + this.mLocales;
        }
    }

    public interface PackageConfigurationUpdater {
        boolean commit();

        PackageConfigurationUpdater setGrammaticalGender(int r1);

        PackageConfigurationUpdater setLocales(LocaleList r1);

        PackageConfigurationUpdater setNightMode(int r1);
    }

    public static final class PreBindInfo {
        public final CompatibilityInfo compatibilityInfo;
        public final Configuration configuration;

        PreBindInfo(CompatibilityInfo compatInfo, Configuration config) {
            this.compatibilityInfo = compatInfo;
            this.configuration = config;
        }
    }

    public interface ScreenObserver {
        default void onAwakeStateChanged(boolean isAwake) {
        }

        default void onKeyguardStateChanged(boolean isShowing) {
        }

        default void onKeyguardGoingAway() {
        }
    }

    public abstract boolean attachApplication(WindowProcessController r1) throws RemoteException;

    public abstract boolean canCloseSystemDialogs(int r1, int r2);

    public abstract boolean canGcNow();

    public abstract boolean canShowErrorDialogs(int r1);

    public abstract boolean checkCanCloseSystemDialogs(int r1, int r2, String r3);

    public abstract void cleanupDisabledPackageComponents(String r1, Set<String> r2, int r3, boolean r4);

    public abstract void cleanupRecentTasksForUser(int r1);

    public abstract void clearHeavyWeightProcessIfEquals(WindowProcessController r1);

    public abstract void clearLockedTasks(String r1);

    public abstract void clearPendingResultForActivity(IBinder r1, WeakReference<PendingIntentRecord> r2);

    public abstract void closeSystemDialogs(String r1);

    public abstract PackageConfigurationUpdater createPackageConfigurationUpdater();

    public abstract PackageConfigurationUpdater createPackageConfigurationUpdater(String r1, int r2);

    public abstract void dump(String r1, FileDescriptor r2, PrintWriter r3, String[] r4, int r5, boolean r6, boolean r7, String r8, int r9);

    public abstract boolean dumpActivity(FileDescriptor r1, PrintWriter r2, String r3, String[] r4, int r5, boolean r6, boolean r7, boolean r8, int r9, int r10);

    public abstract void dumpForOom(PrintWriter r1);

    public abstract boolean dumpForProcesses(FileDescriptor r1, PrintWriter r2, boolean r3, String r4, int r5, boolean r6, boolean r7, int r8);

    public abstract void enableScreenAfterBoot(boolean r1);

    public abstract void finishHeavyWeightApp();

    public abstract int finishTopCrashedActivities(WindowProcessController r1, String r2);

    public abstract void flushRecentTasks();

    public abstract ComponentName getActivityName(IBinder r1);

    public abstract List<ActivityManager.AppTask> getAppTasks(String r1, int r2);

    public abstract PackageConfig getApplicationConfig(String r1, int r2);

    public abstract ActivityTokens getAttachedNonFinishingActivityForTask(int r1, IBinder r2);

    public abstract int getDisplayId(IBinder r1);

    public abstract ComponentName getHomeActivityForUser(int r1);

    public abstract Intent getHomeIntent();

    public abstract IIntentSender getIntentSender(int r1, String r2, String r3, int r4, int r5, IBinder r6, String r7, int r8, Intent[] r9, String[] r10, int r11, Bundle r12);

    public abstract ActivityMetricsLaunchObserverRegistry getLaunchObserverRegistry();

    public abstract ActivityManager.RecentTaskInfo getMostRecentTaskFromBackground();

    public abstract ActivityServiceConnectionsHolder getServiceConnectionsHolder(IBinder r1);

    public abstract ActivityTaskManagerInternalSmtBase getSmtEx();

    public abstract TaskSnapshot getTaskSnapshotBlocking(int r1, boolean r2, int r3);

    public abstract int getTaskToShowPermissionDialogOn(String r1, int r2);

    public abstract WindowProcessController getTopApp();

    public abstract int getTopProcessState();

    public abstract List<ActivityAssistInfo> getTopVisibleActivities();

    public abstract ActivityRecord getTopVisibleFullScreenActivity(int r1);

    public abstract IBinder getUriPermissionOwnerForActivity(IBinder r1);

    public abstract boolean handleAppCrashInActivityController(String r1, int r2, String r3, String r4, long r5, String r7, Runnable r8);

    public abstract void handleAppDied(WindowProcessController r1, boolean r2, Runnable r3);

    public abstract boolean hasResumedActivity(int r1);

    public abstract boolean hasSystemAlertWindowPermission(int r1, int r2, String r3);

    public abstract boolean isAssistDataAllowed();

    public abstract boolean isBaseOfLockedTask(String r1);

    public abstract boolean isCallerRecents(int r1);

    public abstract boolean isGetTasksAllowed(String r1, int r2, int r3);

    public abstract boolean isNoDisplay(String r1, int r2, int r3);

    public abstract boolean isRecentsComponentHomeActivity(int r1);

    public abstract boolean isShuttingDown();

    public abstract boolean isSleeping();

    public abstract boolean isUidForeground(int r1);

    public abstract void loadRecentTasksForUser(int r1);

    public abstract void notifyActiveDreamChanged(ComponentName r1);

    public abstract void notifyActiveVoiceInteractionServiceChanged(ComponentName r1);

    public abstract void notifyLockedProfile(int r1);

    public abstract void onCleanUpApplicationRecord(WindowProcessController r1);

    public abstract boolean onForceStopPackage(String r1, boolean r2, boolean r3, int r4);

    public abstract void onHandleAppCrash(WindowProcessController r1);

    public abstract void onLocalVoiceInteractionStarted(IBinder r1, IVoiceInteractionSession r2, IVoiceInteractor r3);

    public abstract void onPackageAdded(String r1, boolean r2);

    public abstract void onPackageDataCleared(String r1, int r2);

    public abstract void onPackageReplaced(ApplicationInfo r1);

    public abstract void onPackageUninstalled(String r1, int r2);

    public abstract void onPackagesSuspendedChanged(String[] r1, boolean r2, int r3);

    public abstract void onProcessAdded(WindowProcessController r1);

    public abstract void onProcessMapped(int r1, WindowProcessController r2);

    public abstract void onProcessRemoved(String r1, int r2);

    public abstract void onProcessUnMapped(int r1);

    public abstract void onUidActive(int r1, int r2);

    public abstract void onUidInactive(int r1);

    public abstract void onUidProcStateChanged(int r1, int r2);

    public abstract void onUserStopped(int r1);

    public abstract PreBindInfo preBindApplication(WindowProcessController r1, ApplicationInfo r2);

    public abstract void registerActivityStartInterceptor(int r1, ActivityInterceptorCallback r2);

    public abstract void registerCompatScaleProvider(int r1, CompatScaleProvider r2);

    public abstract void registerScreenObserver(ScreenObserver r1);

    public abstract void registerTaskStackListener(ITaskStackListener r1);

    public abstract void removeRecentTasksByPackageName(String r1, int r2);

    public abstract void removeUser(int r1);

    public abstract boolean requestBackGesture();

    public abstract void restartTaskActivityProcessIfVisible(int r1, String r2);

    public abstract void resumeTopActivities(boolean r1);

    public abstract void scheduleDestroyAllActivities(String r1);

    public abstract void sendActivityResult(int r1, IBinder r2, String r3, int r4, int r5, Intent r6);

    public abstract void setAccessibilityServiceUids(IntArray r1);

    public abstract void setAllowAppSwitches(String r1, int r2, int r3);

    public abstract void setBackgroundActivityStartCallback(BackgroundActivityStartCallback r1);

    public abstract void setCompanionAppUids(int r1, Set<Integer> r2);

    public abstract void setDeviceOwnerUid(int r1);

    public abstract void setProfileApp(String r1);

    public abstract void setProfileOwnerUids(Set<Integer> r1);

    public abstract void setProfileProc(WindowProcessController r1);

    public abstract void setProfilerInfo(ProfilerInfo r1);

    public abstract void setVr2dDisplayId(int r1);

    public abstract boolean showStrictModeViolationDialog();

    public abstract void showSystemReadyErrorDialogsIfNeeded();

    public abstract boolean shuttingDown(boolean r1, int r2);

    public abstract int startActivitiesAsPackage(String r1, String r2, int r3, Intent[] r4, Bundle r5);

    public abstract int startActivitiesInPackage(int r1, int r2, int r3, String r4, String r5, Intent[] r6, String[] r7, IBinder r8, SafeActivityOptions r9, int r10, boolean r11, PendingIntentRecord r12, boolean r13);

    public abstract int startActivityAsUser(IApplicationThread r1, String r2, String r3, Intent r4, IBinder r5, int r6, Bundle r7, int r8);

    public abstract int startActivityInPackage(int r1, int r2, int r3, String r4, String r5, Intent r6, String r7, IBinder r8, String r9, int r10, int r11, SafeActivityOptions r12, int r13, Task r14, String r15, boolean r16, PendingIntentRecord r17, boolean r18);

    public abstract int startActivityWithScreenshot(Intent r1, String r2, int r3, int r4, IBinder r5, Bundle r6, int r7);

    public abstract void startConfirmDeviceCredentialIntent(Intent r1, Bundle r2);

    public abstract IAppTask startDreamActivity(Intent r1, int r2, int r3);

    public abstract boolean startHomeActivity(int r1, String r2);

    public abstract boolean startHomeOnAllDisplays(int r1, String r2);

    public abstract boolean startHomeOnDisplay(int r1, String r2, int r3, boolean r4, boolean r5);

    public abstract boolean switchUser(int r1, UserState r2);

    public abstract void unregisterActivityStartInterceptor(int r1);

    public abstract void unregisterCompatScaleProvider(int r1);

    public abstract void unregisterScreenObserver(ScreenObserver r1);

    public abstract void unregisterTaskStackListener(ITaskStackListener r1);

    public abstract void updateTopComponentForFactoryTest();

    public abstract void updateUserConfiguration();

    public abstract boolean useTopSchedGroupForTopProcess();

    public abstract void writeActivitiesToProto(ProtoOutputStream r1);

    public abstract void writeProcessesToProto(ProtoOutputStream r1, String r2, int r3, boolean r4);

    public ActivityTaskManagerInternal() {
    }
}
