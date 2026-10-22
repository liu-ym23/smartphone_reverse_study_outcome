package com.android.server.timezonedetector;

import android.app.ActivityManagerInternal;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.TimeZone;
import android.os.Handler;
import android.os.UserHandle;
import android.util.IndentingPrintWriter;
import com.android.server.LocalServices;
import com.android.server.am.ProcessList;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class NotifyingTimeZoneChangeListener implements TimeZoneChangeListener {
    private static final String ACTION_NOTIFICATION_DELETED = "com.android.server.timezonedetector.TimeZoneNotificationDeleted";
    static final long AUTO_REVERT_THRESHOLD = 0;
    private static final int MAX_EVENTS_TO_TRACK = 10;
    private static final String NOTIFICATION_INTENT_EXTRA_CHANGE_ID = "change_id";
    private static final String NOTIFICATION_INTENT_EXTRA_USER_ID = "user_id";
    private static final String NOTIFICATION_TAG = "TimeZoneDetector";
    static final int SIGNAL_TYPE_HEURISTIC = 3;
    static final int SIGNAL_TYPE_NONE = 1;
    static final int SIGNAL_TYPE_NOTIFICATION = 2;
    static final int SIGNAL_TYPE_UNKNOWN = 0;
    static final int STATUS_ACCEPTED = 3;
    static final int STATUS_REJECTED = 2;
    static final int STATUS_SUPERSEDED = 4;
    static final int STATUS_UNKNOWN = 0;
    static final int STATUS_UNTRACKED = 1;
    private static final String TAG = "TimeZoneChangeTracker";
    private static final int TZ_CHANGE_NOTIFICATION_ID = 1001;
    private int mAcceptedLocationChanges;
    private int mAcceptedManualChanges;
    private int mAcceptedTelephonyChanges;
    private int mAcceptedUnknownChanges;
    private final ActivityManagerInternal mActivityManagerInternal;
    private ConfigurationInternal mConfigurationInternal;
    private final Object mConfigurationLock;
    private final Context mContext;
    private final Environment mEnvironment;
    private final Handler mHandler;
    private boolean mIsRegistered;
    private final AtomicInteger mNextChangeEventId;
    private final NotificationManager mNotificationManager;
    private final BroadcastReceiver mNotificationReceiver;
    private int mRejectedLocationChanges;
    private int mRejectedTelephonyChanges;
    private int mRejectedUnknownChanges;
    private final Resources mRes;
    private final ServiceConfigAccessor mServiceConfigAccessor;
    private final ReferenceWithHistory<TimeZoneChangeRecord> mTimeZoneChangeRecord;

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface SignalType {
    }

    static class TimeZoneChangeRecord {
        private final TimeZoneChangeListener.TimeZoneChangeEvent mEvent;
        private final int mId;
        private int mSignalType;
        private int mStatus;

        TimeZoneChangeRecord(int id, TimeZoneChangeListener.TimeZoneChangeEvent event) {
            this.mStatus = 0;
            this.mSignalType = 0;
            this.mId = id;
            event.getClass();
            this.mEvent = event;
        }

        public int getId() {
            return this.mId;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setAccepted(int signalType) {
            setStatus(3, signalType);
        }

        public void setRejected(int signalType) {
            setStatus(2, signalType);
        }

        public void setStatus(int status, int signalType) {
            this.mStatus = status;
            this.mSignalType = signalType;
        }

        public TimeZoneChangeListener.TimeZoneChangeEvent getEvent() {
            return this.mEvent;
        }

        public String toString() {
            return "TrackedTimeZoneChangeEvent{mId=" + this.mId + ", mEvent=" + this.mEvent + ", mStatus=" + this.mStatus + ", mSignalType=" + this.mSignalType + '}';
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof TimeZoneChangeRecord) == false) goto L18;
            TimeZoneChangeRecord that = (TimeZoneChangeRecord) o;
            if (this.mId != that.mId) goto L17;
            if (this.mEvent.equals(that.mEvent) == false) goto L17;
            if (this.mStatus != that.mStatus) goto L17;
            if (this.mSignalType != that.mSignalType) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.mId), this.mEvent, Integer.valueOf(this.mStatus), Integer.valueOf(this.mSignalType)});
        }
    }

    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface TimeZoneChangeStatus {
    }

    /* JADX INFO: renamed from: $r8$lambda$450zpqDjNp-HS3a6OQROBI1EvAI, reason: not valid java name */
    public static /* synthetic */ void m8592$r8$lambda$450zpqDjNpHS3a6OQROBI1EvAI(NotifyingTimeZoneChangeListener r0, TimeZoneChangeRecord r1) {
        r0.lambda$scheduleChangeAcceptedHeuristicCallback$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$iOoFxBwY36rVGc24HJInvungJio(NotifyingTimeZoneChangeListener r0) {
        r0.handleConfigurationUpdate();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotificationSwipedAway, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8593$$Nest$mnotificationSwipedAway(NotifyingTimeZoneChangeListener r0, int r1, int r2) {
        r0.notificationSwipedAway(r1, r2);
    }

    static {
        AUTO_REVERT_THRESHOLD = Duration.ofMinutes(15).toMillis();
    }

    public static NotifyingTimeZoneChangeListener create(Handler handler, Context context, ServiceConfigAccessor serviceConfigAccessor, Environment environment) {
        NotifyingTimeZoneChangeListener changeTracker = new NotifyingTimeZoneChangeListener(handler, context, serviceConfigAccessor, (NotificationManager) context.getSystemService(NotificationManager.class), environment);
        changeTracker.handleConfigurationUpdate();
        return changeTracker;
    }

    NotifyingTimeZoneChangeListener(Handler handler, Context context, ServiceConfigAccessor serviceConfigAccessor, NotificationManager notificationManager, Environment environment) {
        this.mNextChangeEventId = new AtomicInteger(1);
        this.mRes = Resources.getSystem();
        this.mTimeZoneChangeRecord = new ReferenceWithHistory(10);
        this.mNotificationReceiver = new AnonymousClass1(this);
        this.mConfigurationLock = new Object();
        handler.getClass();
        this.mHandler = handler;
        context.getClass();
        this.mContext = context;
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
        this.mServiceConfigAccessor.addConfigurationInternalChangeListener(new NotifyingTimeZoneChangeListener$$ExternalSyntheticLambda0(this));
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mNotificationManager = notificationManager;
        environment.getClass();
        this.mEnvironment = environment;
    }

    private void handleConfigurationUpdate() {
        Object r1 = this.mConfigurationLock;
        monitor-enter(r1);
        ConfigurationInternal oldConfigurationInternal = this.mConfigurationInternal;     // Catch: Throwable -> L11
        this.mConfigurationInternal = this.mServiceConfigAccessor.getCurrentUserConfigurationInternal();     // Catch: Throwable -> L11
        boolean userChanged = false;
        if (areNotificationsEnabled() == false) goto L14;
        if (isNotificationTrackingSupported() == false) goto L14;
        if (this.mIsRegistered == true) goto L16;
        IntentFilter intentFilter = new IntentFilter();     // Catch: Throwable -> L11
        intentFilter.addAction(ACTION_NOTIFICATION_DELETED);     // Catch: Throwable -> L11
        this.mContext.registerReceiverForAllUsers(this.mNotificationReceiver, intentFilter, null, this.mHandler, 4);     // Catch: Throwable -> L11
        this.mIsRegistered = true;     // Catch: Throwable -> L11
    L16:
        if (oldConfigurationInternal != null) goto L18;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L18:
        if (oldConfigurationInternal.getUserId() == this.mConfigurationInternal.getUserId()) goto L21;
        userChanged = true;
    L21:
        if (areNotificationsEnabled() == false) goto L23;
        if (userChanged == false) goto L24;
    L23:
        clearNotificationForUser(oldConfigurationInternal.getUserId());     // Catch: Throwable -> L11
    L14:
        if (this.mIsRegistered == false) goto L16;
        this.mContext.unregisterReceiver(this.mNotificationReceiver);     // Catch: Throwable -> L11
        this.mIsRegistered = false;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void notificationSwipedAway(int userId, int changeEventId) {
        if (isNotificationTrackingSupported() == false) goto L6;
        markChangeAsAccepted(changeEventId, userId, 2);
        return;
    }

    private boolean areNotificationsEnabled() {
        Object r0 = this.mConfigurationLock;
        monitor-enter(r0);
        boolean r1 = this.mConfigurationInternal.getNotificationsEnabledBehavior();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isNotificationTrackingSupported() {
        Object r0 = this.mConfigurationLock;
        monitor-enter(r0);
        boolean r1 = this.mConfigurationInternal.isNotificationTrackingSupported();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isManualChangeTrackingSupported() {
        Object r0 = this.mConfigurationLock;
        monitor-enter(r0);
        boolean r1 = this.mConfigurationInternal.isManualChangeTrackingSupported();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void markChangeAsAccepted(int changeEventId, int userId, int signalType) {
        if (isUserIdCurrentUser(userId) == true) goto L5;
        return;
    L5:
        ReferenceWithHistory<TimeZoneChangeRecord> r0 = this.mTimeZoneChangeRecord;
        monitor-enter(r0);
        TimeZoneChangeRecord lastTimeZoneChangeRecord = this.mTimeZoneChangeRecord.get();     // Catch: Throwable -> L13
        if (lastTimeZoneChangeRecord != null) goto L10;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L10:
        if (lastTimeZoneChangeRecord.getId() == changeEventId) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        if (lastTimeZoneChangeRecord.getStatus() == 0) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L19:
        lastTimeZoneChangeRecord.setAccepted(signalType);     // Catch: Throwable -> L13
        switch(lastTimeZoneChangeRecord.getEvent().getOrigin()) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            default: goto L21;
        };     // Catch: Throwable -> L13
    L21:
        this.mAcceptedUnknownChanges++;     // Catch: Throwable -> L13
        goto L25
    L22:
        this.mAcceptedLocationChanges++;     // Catch: Throwable -> L13
        goto L25
    L23:
        this.mAcceptedTelephonyChanges++;     // Catch: Throwable -> L13
        goto L25
    L24:
        this.mAcceptedManualChanges++;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private boolean isUserIdCurrentUser(int userId) {
        Object r0 = this.mConfigurationLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (userId != this.mConfigurationInternal.getUserId()) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    private void markChangeAsRejected(int changeEventId, int userId, int signalType) {
        if (isUserIdCurrentUser(userId) == true) goto L5;
        return;
    L5:
        TimeZoneChangeRecord lastTimeZoneChangeRecord = this.mTimeZoneChangeRecord.get();
        if (lastTimeZoneChangeRecord != null) goto L8;
        return;
    L8:
        if (lastTimeZoneChangeRecord.getId() == changeEventId) goto L11;
        return;
    L11:
        if (lastTimeZoneChangeRecord.getStatus() == 0) goto L13;
        return;
    L13:
        lastTimeZoneChangeRecord.setRejected(signalType);
        switch(lastTimeZoneChangeRecord.getEvent().getOrigin()) {
            case 2: goto L17;
            case 3: goto L16;
            default: goto L15;
        };
    L15:
        this.mRejectedUnknownChanges++;
        return;
    L16:
        this.mRejectedLocationChanges++;
        return;
    L17:
        this.mRejectedTelephonyChanges++;
    }

    @Override // com.android.server.timezonedetector.TimeZoneChangeListener
    public void process(TimeZoneChangeListener.TimeZoneChangeEvent changeEvent) {
        ReferenceWithHistory<TimeZoneChangeRecord> r0 = this.mTimeZoneChangeRecord;
        monitor-enter(r0);
        fixPotentialHistoryCorruption(changeEvent);     // Catch: Throwable -> L12
        TimeZoneChangeRecord lastTimeZoneChangeRecord = this.mTimeZoneChangeRecord.get();     // Catch: Throwable -> L12
        int changeEventId = this.mNextChangeEventId.getAndIncrement();     // Catch: Throwable -> L12
        TimeZoneChangeRecord trackedChangeEvent = new TimeZoneChangeRecord(changeEventId, changeEvent);     // Catch: Throwable -> L12
        if (isManualChangeTrackingSupported() == false) goto L16;
        if (lastTimeZoneChangeRecord != null) goto L8;
    L14:
        scheduleChangeAcceptedHeuristicCallback(trackedChangeEvent, AUTO_REVERT_THRESHOLD);     // Catch: Throwable -> L12
        goto L16
    L8:
        if (lastTimeZoneChangeRecord.getStatus() != 0) goto L14;
        TimeZoneChangeListener.TimeZoneChangeEvent lastChangeEvent = lastTimeZoneChangeRecord.getEvent();     // Catch: Throwable -> L12
        if (shouldRejectChangeEvent(changeEvent, lastChangeEvent) == false) goto L14;
        markChangeAsRejected(lastTimeZoneChangeRecord.getId(), changeEvent.getUserId(), 3);     // Catch: Throwable -> L12
    L16:
        if (lastTimeZoneChangeRecord == null) goto L21;
        if (lastTimeZoneChangeRecord.getStatus() != 0) goto L21;
        lastTimeZoneChangeRecord.setStatus(4, 1);     // Catch: Throwable -> L12
    L21:
        if (changeEvent.getOrigin() != 1) goto L23;
        trackedChangeEvent.setStatus(1, 1);     // Catch: Throwable -> L12
    L23:
        this.mTimeZoneChangeRecord.set(trackedChangeEvent);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (areNotificationsEnabled() == false) goto L38;
        Object r1 = this.mConfigurationLock;
        monitor-enter(r1);
        int currentUserId = this.mConfigurationInternal.getUserId();     // Catch: Throwable -> L35
        monitor-exit(r1);     // Catch: Throwable -> L35
        if (changeEvent.getOrigin() != 1) goto L34;
        clearNotificationForUser(currentUserId);
        return;
    L34:
        notifyOfTimeZoneChange(currentUserId, trackedChangeEvent);
        return;
    L35:
        th = move-exception;
        throw th;
    L38:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void fixPotentialHistoryCorruption(TimeZoneChangeListener.TimeZoneChangeEvent changeEvent) {
        TimeZoneChangeRecord lastTimeZoneChangeRecord = this.mTimeZoneChangeRecord.get();
        if (lastTimeZoneChangeRecord == null) goto L10;
        TimeZoneChangeListener.TimeZoneChangeEvent lastChangeEvent = lastTimeZoneChangeRecord.getEvent();
        if (changeEvent.getOldZoneId().equals(lastChangeEvent.getNewZoneId()) == true) goto L11;
        int changeEventId = this.mNextChangeEventId.getAndIncrement();
        TimeZoneChangeListener.TimeZoneChangeEvent syntheticChangeEvent = new TimeZoneChangeListener.TimeZoneChangeEvent(this.mEnvironment.elapsedRealtimeMillis(), this.mEnvironment.currentTimeMillis(), 0, ProcessList.INVALID_ADJ, lastChangeEvent.getNewZoneId(), changeEvent.getOldZoneId(), 0, "Synthetic");
        TimeZoneChangeRecord syntheticTrackedChangeEvent = new TimeZoneChangeRecord(changeEventId, syntheticChangeEvent);
        syntheticTrackedChangeEvent.setStatus(4, 1);
        this.mTimeZoneChangeRecord.set(syntheticTrackedChangeEvent);
        if (lastTimeZoneChangeRecord.getStatus() != 0) goto L12;
        lastTimeZoneChangeRecord.setStatus(4, 1);
        return;
    L12:
        return;
    L11:
        return;
    }

    private static boolean shouldRejectChangeEvent(TimeZoneChangeListener.TimeZoneChangeEvent changeEvent, TimeZoneChangeListener.TimeZoneChangeEvent lastChangeEvent) {
        if (changeEvent.getOrigin() == 1) goto L5;
    L9:
        return false;
    L5:
        if (lastChangeEvent.getOrigin() == 1) goto L9;
        if ((changeEvent.getElapsedRealtimeMillis() - lastChangeEvent.getElapsedRealtimeMillis()) >= AUTO_REVERT_THRESHOLD) goto L9;
        return true;
    }

    private void scheduleChangeAcceptedHeuristicCallback(final TimeZoneChangeRecord trackedChangeEvent, long delayMillis) {
        this.mHandler.postDelayed(new NotifyingTimeZoneChangeListener$$ExternalSyntheticLambda1(this, trackedChangeEvent), delayMillis);
    }

    private /* synthetic */ void lambda$scheduleChangeAcceptedHeuristicCallback$0(TimeZoneChangeRecord trackedChangeEvent) {
        changeAcceptedTimeHeuristicCallback(trackedChangeEvent.getId());
    }

    private void changeAcceptedTimeHeuristicCallback(int changeEventId) {
        if (isManualChangeTrackingSupported() == false) goto L6;
        int currentUserId = this.mActivityManagerInternal.getCurrentUserId();
        markChangeAsAccepted(changeEventId, currentUserId, 3);
        return;
    }

    private void clearNotificationForUser(int userId) {
        this.mNotificationManager.cancelAsUser(NOTIFICATION_TAG, 1001, UserHandle.of(userId));
    }

    private void notifyOfTimeZoneChange(int userId, TimeZoneChangeRecord trackedChangeEvent) {
        trackedChangeEvent.getEvent();
    }

    private CharSequence getNotificationBody(TimeZone newTimeZone, long unixEpochTimeMillis) {
        DateFormat timeFormat = SimpleDateFormat.getInstanceForSkeleton("zzzz");
        DateFormat offsetFormat = SimpleDateFormat.getInstanceForSkeleton("ZZZZ");
        String newTime = formatInZone(timeFormat, newTimeZone, unixEpochTimeMillis);
        String newOffset = formatInZone(offsetFormat, newTimeZone, unixEpochTimeMillis);
        return this.mRes.getString(17042251, new Object[]{newTime, newOffset});
    }

    private static String formatInZone(DateFormat timeFormat, TimeZone timeZone, long unixEpochTimeMillis) {
        timeFormat.setTimeZone(timeZone);
        return timeFormat.format(Long.valueOf(unixEpochTimeMillis));
    }

    @Override // com.android.server.timezonedetector.TimeZoneChangeListener
    public void dump(IndentingPrintWriter pw) {
        Object r0 = this.mConfigurationLock;
        monitor-enter(r0);
        pw.println("currentUserId=" + this.mConfigurationInternal.getUserId());     // Catch: Throwable -> L15
        pw.println("notificationsEnabledBehavior=" + this.mConfigurationInternal.getNotificationsEnabledBehavior());     // Catch: Throwable -> L15
        pw.println("notificationTrackingSupported=" + this.mConfigurationInternal.isNotificationTrackingSupported());     // Catch: Throwable -> L15
        pw.println("manualChangeTrackingSupported=" + this.mConfigurationInternal.isManualChangeTrackingSupported());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        pw.println("mAcceptedLocationChanges=" + this.mAcceptedLocationChanges);
        pw.println("mAcceptedManualChanges=" + this.mAcceptedManualChanges);
        pw.println("mAcceptedTelephonyChanges=" + this.mAcceptedTelephonyChanges);
        pw.println("mAcceptedUnknownChanges=" + this.mAcceptedUnknownChanges);
        pw.println("mRejectedLocationChanges=" + this.mRejectedLocationChanges);
        pw.println("mRejectedTelephonyChanges=" + this.mRejectedTelephonyChanges);
        pw.println("mRejectedUnknownChanges=" + this.mRejectedUnknownChanges);
        pw.println("mNextChangeEventId=" + this.mNextChangeEventId);
        pw.println("mTimeZoneChangeRecord:");
        pw.increaseIndent();
        ReferenceWithHistory<TimeZoneChangeRecord> r1 = this.mTimeZoneChangeRecord;
        monitor-enter(r1);
        this.mTimeZoneChangeRecord.dump(pw);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        pw.decreaseIndent();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    }

    TimeZoneChangeRecord getLastTimeZoneChangeRecord() {
        ReferenceWithHistory<TimeZoneChangeRecord> r0 = this.mTimeZoneChangeRecord;
        monitor-enter(r0);
        TimeZoneChangeRecord r1 = this.mTimeZoneChangeRecord.get();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
