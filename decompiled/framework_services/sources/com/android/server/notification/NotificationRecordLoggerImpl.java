package com.android.server.notification;

import com.android.internal.logging.InstanceId;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.logging.UiEventLoggerImpl;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
class NotificationRecordLoggerImpl implements NotificationRecordLogger {
    private UiEventLogger mUiEventLogger;

    NotificationRecordLoggerImpl() {
        this.mUiEventLogger = new UiEventLoggerImpl();
    }

    @Override // com.android.server.notification.NotificationRecordLogger
    public void logNotificationPosted(NotificationRecordLogger.NotificationReported nr) {
        writeNotificationReportedAtom(nr);
    }

    @Override // com.android.server.notification.NotificationRecordLogger
    public void logNotificationAdjusted(NotificationRecord r, int position, int buzzBeepBlink, InstanceId groupId) {
        NotificationRecordLogger.NotificationRecordPair p = new NotificationRecordLogger.NotificationRecordPair(r, null);
        writeNotificationReportedAtom(new NotificationRecordLogger.NotificationReported(p, NotificationRecordLogger.NotificationReportedEvent.NOTIFICATION_ADJUSTED, position, buzzBeepBlink, groupId));
    }

    private void writeNotificationReportedAtom(NotificationRecordLogger.NotificationReported notificationReported) {
        FrameworkStatsLog.write(FrameworkStatsLog.NOTIFICATION_REPORTED, notificationReported.event_id, notificationReported.uid, notificationReported.package_name, notificationReported.instance_id, notificationReported.notification_id_hash, notificationReported.channel_id_hash, notificationReported.group_id_hash, notificationReported.group_instance_id, notificationReported.is_group_summary, notificationReported.category, notificationReported.style, notificationReported.num_people, notificationReported.position, notificationReported.importance, notificationReported.alerting, notificationReported.importance_source, notificationReported.importance_initial, notificationReported.importance_initial_source, notificationReported.importance_asst, notificationReported.assistant_hash, notificationReported.assistant_ranking_score, notificationReported.is_ongoing, notificationReported.is_foreground_service, notificationReported.timeout_millis, notificationReported.is_non_dismissible, notificationReported.post_duration_millis, notificationReported.fsi_state, notificationReported.is_locked, notificationReported.age_in_minutes, notificationReported.is_promoted_ongoing, notificationReported.has_promotable_characteristics);
    }

    @Override // com.android.server.notification.NotificationRecordLogger
    public void log(UiEventLogger.UiEventEnum event, NotificationRecord r) {
        if (r != null) goto L4;
        return;
    L4:
        this.mUiEventLogger.logWithInstanceId(event, r.getUid(), r.getSbn().getPackageName(), r.getSbn().getInstanceId());
    }

    @Override // com.android.server.notification.NotificationRecordLogger
    public void log(UiEventLogger.UiEventEnum event) {
        this.mUiEventLogger.log(event);
    }
}
