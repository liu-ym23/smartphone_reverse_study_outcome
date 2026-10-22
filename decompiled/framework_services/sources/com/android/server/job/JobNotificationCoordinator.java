package com.android.server.job;

import android.app.Notification;
import android.content.pm.UserPackage;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.SparseSetArray;
import com.android.modules.expresslog.Counter;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.notification.NotificationManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
class JobNotificationCoordinator {
    private static final String TAG = "JobNotificationCoordinator";
    private final ArrayMap<UserPackage, SparseSetArray<JobServiceContext>> mCurrentAssociations;
    private final ArrayMap<JobServiceContext, NotificationDetails> mNotificationDetails;
    private final NotificationManagerInternal mNotificationManagerInternal;
    private final Object mUijLock;
    private final SparseArrayMap<String, ArraySet<String>> mUijNotificationChannels;
    private final SparseArrayMap<String, IntArray> mUijNotifications;

    private static final class NotificationDetails {
        public final int appPid;
        public final int appUid;
        public final int jobEndNotificationPolicy;
        public final String notificationChannel;
        public final int notificationId;
        public final UserPackage userPackage;

        NotificationDetails(UserPackage userPackage, int appPid, int appUid, int notificationId, String notificationChannel, int jobEndNotificationPolicy) {
            this.userPackage = userPackage;
            this.notificationId = notificationId;
            this.notificationChannel = notificationChannel;
            this.appPid = appPid;
            this.appUid = appUid;
            this.jobEndNotificationPolicy = jobEndNotificationPolicy;
        }
    }

    JobNotificationCoordinator() {
        this.mUijLock = new Object();
        this.mCurrentAssociations = new ArrayMap();
        this.mNotificationDetails = new ArrayMap();
        this.mUijNotifications = new SparseArrayMap();
        this.mUijNotificationChannels = new SparseArrayMap();
        this.mNotificationManagerInternal = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
    }

    void enqueueNotification(JobServiceContext hostingContext, String packageName, int callingPid, int callingUid, int notificationId, Notification notification, int jobEndNotificationPolicy) {
        validateNotification(packageName, callingUid, notification, jobEndNotificationPolicy);
        JobStatus jobStatus = hostingContext.getRunningJobLocked();
        if (jobStatus != null) goto L6;
        Slog.wtfStack(TAG, "enqueueNotification called with no running job");
        return;
    L6:
        NotificationDetails oldDetails = this.mNotificationDetails.get(hostingContext);
        if (oldDetails != null) goto L13;
        if (jobStatus.startedAsUserInitiatedJob == false) goto L11;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_initial_set_notification_call_required", jobStatus.getUid());
    L19:
        int userId = UserHandle.getUserId(callingUid);
        if (jobStatus.startedAsUserInitiatedJob == false) goto L33;
        notification.flags |= 32768;
        Object r5 = this.mUijLock;
        monitor-enter(r5);
        maybeCreateUijNotificationSetsLocked(userId, packageName);     // Catch: Throwable -> L26
        IntArray notificationIds = (IntArray) this.mUijNotifications.get(userId, packageName);     // Catch: Throwable -> L26
        if (notificationIds.indexOf(notificationId) != (-1)) goto L28;
        notificationIds.add(notificationId);     // Catch: Throwable -> L26
    L28:
        ((ArraySet) this.mUijNotificationChannels.get(userId, packageName)).add(notification.getChannelId());     // Catch: Throwable -> L26
        monitor-exit(r5);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L33:
        UserPackage userPackage = UserPackage.of(userId, packageName);
        NotificationDetails details = new NotificationDetails(userPackage, callingPid, callingUid, notificationId, notification.getChannelId(), jobEndNotificationPolicy);
        SparseSetArray<JobServiceContext> appNotifications = this.mCurrentAssociations.get(userPackage);
        if (appNotifications != null) goto L36;
        appNotifications = new SparseSetArray();
        this.mCurrentAssociations.put(userPackage, appNotifications);
    L36:
        appNotifications.add(notificationId, hostingContext);
        this.mNotificationDetails.put(hostingContext, details);
        this.mNotificationManagerInternal.enqueueNotification(packageName, packageName, callingUid, callingPid, null, notificationId, notification, userId);
        return;
    L11:
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_initial_set_notification_call_optional", jobStatus.getUid());
        goto L19
    L13:
        if (jobStatus.startedAsUserInitiatedJob == false) goto L15;
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_subsequent_set_notification_call_required", jobStatus.getUid());
    L17:
        if (oldDetails.notificationId == notificationId) goto L19;
        removeNotificationAssociation(hostingContext, 0, jobStatus);
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_set_notification_changed_notification_ids", jobStatus.getUid());
        goto L19
    L15:
        Counter.logIncrementWithUid("job_scheduler.value_cntr_w_uid_subsequent_set_notification_call_optional", jobStatus.getUid());
        goto L17
    }

    void removeNotificationAssociation(JobServiceContext hostingContext, int stopReason, JobStatus completedJob) {
        NotificationDetails details = this.mNotificationDetails.remove(hostingContext);
        if (details != null) goto L5;
        return;
    L5:
        SparseSetArray<JobServiceContext> associations = this.mCurrentAssociations.get(details.userPackage);
        if (associations != null) goto L8;
    L30:
        Slog.wtf(TAG, "Association data structures not in sync");
        return;
    L8:
        if (associations.remove(details.notificationId, hostingContext) == false) goto L30;
        int userId = UserHandle.getUserId(details.appUid);
        String packageName = details.userPackage.packageName;
        int notificationId = details.notificationId;
        boolean stripUijFlag = true;
        ArraySet<JobServiceContext> associatedContexts = associations.get(notificationId);
        if (associatedContexts == null) goto L17;
        if (associatedContexts.isEmpty() == true) goto L17;
        stripUijFlag = true ^ isNotificationUsedForAnyUij(userId, packageName, notificationId);
    L23:
        if (stripUijFlag == false) goto L25;
        this.mNotificationManagerInternal.removeUserInitiatedJobFlagFromNotification(packageName, notificationId, userId);
    L25:
        if (completedJob != null) goto L27;
        return;
    L27:
        if (completedJob.startedAsUserInitiatedJob == false) goto L33;
        maybeDeleteNotificationIdAssociation(userId, packageName, notificationId);
        maybeDeleteNotificationChannelAssociation(userId, packageName, details.notificationChannel);
        return;
    L33:
        return;
    L17:
        if (details.jobEndNotificationPolicy != 1) goto L19;
    L22:
        this.mNotificationManagerInternal.cancelNotification(packageName, packageName, details.appUid, details.appPid, null, notificationId, userId);
        stripUijFlag = false;
        goto L23
    L19:
        if (stopReason == 11) goto L22;
        if (stopReason != 13) goto L23;
        goto L22
    }

    boolean isNotificationAssociatedWithAnyUserInitiatedJobs(int notificationId, int userId, String packageName) {
        Object r0 = this.mUijLock;
        monitor-enter(r0);
        IntArray notifications = (IntArray) this.mUijNotifications.get(userId, packageName);     // Catch: Throwable -> L11
        boolean r2 = false;
        if (notifications != null) goto L7;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L7:
        if (notifications.indexOf(notificationId) == (-1)) goto L9;
        r2 = true;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    boolean isNotificationChannelAssociatedWithAnyUserInitiatedJobs(String notificationChannel, int userId, String packageName) {
        Object r0 = this.mUijLock;
        monitor-enter(r0);
        ArraySet<String> channels = (ArraySet) this.mUijNotificationChannels.get(userId, packageName);     // Catch: Throwable -> L9
        if (channels == null) goto L11;
        boolean r2 = channels.contains(notificationChannel);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isNotificationUsedForAnyUij(int userId, String packageName, int notificationId) {
        UserPackage pkgDetails = UserPackage.of(userId, packageName);
        SparseSetArray<JobServiceContext> associations = this.mCurrentAssociations.get(pkgDetails);
        if (associations != null) goto L5;
        return false;
    L5:
        ArraySet<JobServiceContext> associatedContexts = associations.get(notificationId);
        if (associatedContexts != null) goto L8;
        return false;
    L8:
        int i = associatedContexts.size() - 1;
    L9:
        if (i < 0) goto L17;
        JobStatus jobStatus = associatedContexts.valueAt(i).getRunningJobLocked();
        if (jobStatus == null) goto L15;
        if (jobStatus.startedAsUserInitiatedJob == false) goto L15;
        return true;
    L15:
        i = i - 1;
        goto L9
    L17:
        return false;
    }

    private void maybeDeleteNotificationIdAssociation(int userId, String packageName, int notificationId) {
        if (isNotificationUsedForAnyUij(userId, packageName, notificationId) == false) goto L5;
        return;
    L5:
        Object r0 = this.mUijLock;
        monitor-enter(r0);
        IntArray notifications = (IntArray) this.mUijNotifications.get(userId, packageName);     // Catch: Throwable -> L12
        if (notifications == null) goto L14;
        notifications.remove(notifications.indexOf(notificationId));     // Catch: Throwable -> L12
        if (notifications.size() != 0) goto L14;
        this.mUijNotifications.delete(userId, packageName);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void maybeDeleteNotificationChannelAssociation(int userId, String packageName, String notificationChannel) {
        int i = this.mNotificationDetails.size() - 1;
    L3:
        if (i < 0) goto L18;
        JobServiceContext jsc = this.mNotificationDetails.keyAt(i);
        NotificationDetails details = this.mNotificationDetails.get(jsc);
        if (details == null) goto L17;
        if (UserHandle.getUserId(details.appUid) != userId) goto L17;
        if (details.userPackage.packageName.equals(packageName) == false) goto L17;
        if (details.notificationChannel.equals(notificationChannel) == false) goto L17;
        JobStatus jobStatus = jsc.getRunningJobLocked();
        if (jobStatus == null) goto L17;
        if (jobStatus.startedAsUserInitiatedJob == false) goto L17;
        return;
    L17:
        i = i - 1;
        goto L3
    L18:
        Object r0 = this.mUijLock;
        monitor-enter(r0);
        ArraySet<String> channels = (ArraySet) this.mUijNotificationChannels.get(userId, packageName);     // Catch: Throwable -> L25
        if (channels == null) goto L27;
        channels.remove(notificationChannel);     // Catch: Throwable -> L25
        if (channels.isEmpty() == false) goto L27;
        this.mUijNotificationChannels.delete(userId, packageName);     // Catch: Throwable -> L25
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    private void maybeCreateUijNotificationSetsLocked(int userId, String packageName) {
        if (this.mUijNotifications.get(userId, packageName) != null) goto L6;
        this.mUijNotifications.add(userId, packageName, new IntArray());
    L6:
        if (this.mUijNotificationChannels.get(userId, packageName) != null) goto L9;
        this.mUijNotificationChannels.add(userId, packageName, new ArraySet());
        return;
    }

    private void validateNotification(String packageName, int callingUid, Notification notification, int jobEndNotificationPolicy) {
        if (notification == null) goto L19;
        if (notification.getSmallIcon() == null) goto L17;
        if (this.mNotificationManagerInternal.getNotificationChannel(packageName, callingUid, notification.getChannelId()) == null) goto L15;
        if (jobEndNotificationPolicy != 0) goto L9;
        return;
    L9:
        if (jobEndNotificationPolicy != 1) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("invalid job end notification policy");
    L15:
        throw new IllegalArgumentException("invalid notification channel");
    L17:
        throw new IllegalArgumentException("small icon required");
    L19:
        throw new NullPointerException("notification");
    }
}
