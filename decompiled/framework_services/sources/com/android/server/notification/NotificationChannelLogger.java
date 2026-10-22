package com.android.server.notification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.usb.descriptors.UsbDescriptor;

/* JADX INFO: loaded from: classes2.dex */
public interface NotificationChannelLogger {

    public static final enum NotificationChannelEvent extends Enum<NotificationChannelEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationChannelEvent[] $VALUES = null;
        public static final NotificationChannelEvent APP_NOTIFICATIONS_BLOCKED = null;
        public static final NotificationChannelEvent APP_NOTIFICATIONS_UNBLOCKED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_CONVERSATION_CREATED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_CONVERSATION_DELETED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_CREATED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_DELETED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_GROUP_CREATED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_GROUP_DELETED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_GROUP_UPDATED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_UPDATED = null;
        public static final NotificationChannelEvent NOTIFICATION_CHANNEL_UPDATED_BY_USER = null;
        private final int mId;

        private static /* synthetic */ NotificationChannelEvent[] $values() {
            return new NotificationChannelEvent[]{NOTIFICATION_CHANNEL_CREATED, NOTIFICATION_CHANNEL_UPDATED, NOTIFICATION_CHANNEL_UPDATED_BY_USER, NOTIFICATION_CHANNEL_DELETED, NOTIFICATION_CHANNEL_GROUP_CREATED, NOTIFICATION_CHANNEL_GROUP_UPDATED, NOTIFICATION_CHANNEL_GROUP_DELETED, NOTIFICATION_CHANNEL_CONVERSATION_CREATED, NOTIFICATION_CHANNEL_CONVERSATION_DELETED, APP_NOTIFICATIONS_BLOCKED, APP_NOTIFICATIONS_UNBLOCKED};
        }

        public static NotificationChannelEvent valueOf(String name) {
            return (NotificationChannelEvent) Enum.valueOf(NotificationChannelEvent.class, name);
        }

        public static NotificationChannelEvent[] values() {
            return (NotificationChannelEvent[]) $VALUES.clone();
        }

        static {
            NOTIFICATION_CHANNEL_CREATED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_CREATED", 0, 219);
            NOTIFICATION_CHANNEL_UPDATED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_UPDATED", 1, UsbDescriptor.CLASSID_DIAGNOSTIC);
            NOTIFICATION_CHANNEL_UPDATED_BY_USER = new NotificationChannelEvent("NOTIFICATION_CHANNEL_UPDATED_BY_USER", 2, 221);
            NOTIFICATION_CHANNEL_DELETED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_DELETED", 3, 222);
            NOTIFICATION_CHANNEL_GROUP_CREATED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_GROUP_CREATED", 4, FrameworkStatsLog.EXCLUSION_RECT_STATE_CHANGED);
            NOTIFICATION_CHANNEL_GROUP_UPDATED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_GROUP_UPDATED", 5, UsbDescriptor.CLASSID_WIRELESS);
            NOTIFICATION_CHANNEL_GROUP_DELETED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_GROUP_DELETED", 6, 226);
            NOTIFICATION_CHANNEL_CONVERSATION_CREATED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_CONVERSATION_CREATED", 7, 272);
            NOTIFICATION_CHANNEL_CONVERSATION_DELETED = new NotificationChannelEvent("NOTIFICATION_CHANNEL_CONVERSATION_DELETED", 8, 274);
            APP_NOTIFICATIONS_BLOCKED = new NotificationChannelEvent("APP_NOTIFICATIONS_BLOCKED", 9, FrameworkStatsLog.BEDTIME_MODE_STATE_CHANGED);
            APP_NOTIFICATIONS_UNBLOCKED = new NotificationChannelEvent("APP_NOTIFICATIONS_UNBLOCKED", 10, 558);
            $VALUES = $values();
        }

        private NotificationChannelEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }

        public static NotificationChannelEvent getUpdated(boolean byUser) {
            if (byUser == false) goto L5;
            return NOTIFICATION_CHANNEL_UPDATED_BY_USER;
        L5:
            return NOTIFICATION_CHANNEL_UPDATED;
        }

        public static NotificationChannelEvent getCreated(NotificationChannel channel) {
            if (channel.getConversationId() == null) goto L6;
            return NOTIFICATION_CHANNEL_CONVERSATION_CREATED;
        L6:
            return NOTIFICATION_CHANNEL_CREATED;
        }

        public static NotificationChannelEvent getDeleted(NotificationChannel channel) {
            if (channel.getConversationId() == null) goto L6;
            return NOTIFICATION_CHANNEL_CONVERSATION_DELETED;
        L6:
            return NOTIFICATION_CHANNEL_DELETED;
        }

        public static NotificationChannelEvent getGroupUpdated(boolean isNew) {
            if (isNew == false) goto L5;
            return NOTIFICATION_CHANNEL_GROUP_CREATED;
        L5:
            return NOTIFICATION_CHANNEL_GROUP_DELETED;
        }

        public static NotificationChannelEvent getBlocked(boolean enabled) {
            if (enabled == false) goto L5;
            return APP_NOTIFICATIONS_UNBLOCKED;
        L5:
            return APP_NOTIFICATIONS_BLOCKED;
        }
    }

    void logAppEvent(NotificationChannelEvent r1, int r2, String r3);

    void logNotificationChannel(NotificationChannelEvent r1, NotificationChannel r2, int r3, String r4, int r5, int r6);

    void logNotificationChannelGroup(NotificationChannelEvent r1, NotificationChannelGroup r2, int r3, String r4, boolean r5);

    default void logNotificationChannelCreated(NotificationChannel channel, int uid, String pkg) {
        logNotificationChannel(NotificationChannelEvent.getCreated(channel), channel, uid, pkg, 0, getLoggingImportance(channel));
    }

    default void logNotificationChannelDeleted(NotificationChannel channel, int uid, String pkg) {
        logNotificationChannel(NotificationChannelEvent.getDeleted(channel), channel, uid, pkg, getLoggingImportance(channel), 0);
    }

    default void logNotificationChannelModified(NotificationChannel channel, int uid, String pkg, int oldLoggingImportance, boolean byUser) {
        logNotificationChannel(NotificationChannelEvent.getUpdated(byUser), channel, uid, pkg, oldLoggingImportance, getLoggingImportance(channel));
    }

    default void logNotificationChannelGroup(NotificationChannelGroup channelGroup, int uid, String pkg, boolean isNew, boolean wasBlocked) {
        logNotificationChannelGroup(NotificationChannelEvent.getGroupUpdated(isNew), channelGroup, uid, pkg, wasBlocked);
    }

    default void logNotificationChannelGroupDeleted(NotificationChannelGroup channelGroup, int uid, String pkg) {
        logNotificationChannelGroup(NotificationChannelEvent.NOTIFICATION_CHANNEL_GROUP_DELETED, channelGroup, uid, pkg, false);
    }

    default void logAppNotificationsAllowed(int uid, String pkg, boolean enabled) {
        logAppEvent(NotificationChannelEvent.getBlocked(enabled), uid, pkg);
    }

    static int getIdHash(NotificationChannel channel) {
        return SmallHash.hash(channel.getId());
    }

    static int getConversationIdHash(NotificationChannel channel) {
        return SmallHash.hash(channel.getConversationId());
    }

    static int getIdHash(NotificationChannelGroup group) {
        return SmallHash.hash(group.getId());
    }

    static int getLoggingImportance(NotificationChannel channel) {
        return getLoggingImportance(channel, channel.getImportance());
    }

    static int getLoggingImportance(NotificationChannel channel, int importance) {
        if (channel.getConversationId() != null) goto L5;
    L12:
        return importance;
    L5:
        if (importance < 4) goto L12;
        if (channel.isImportantConversation() == false) goto L11;
        return 5;
    L11:
        return importance;
    }

    static int getImportance(NotificationChannelGroup channelGroup) {
        return getImportance(channelGroup.isBlocked());
    }

    static int getImportance(boolean isBlocked) {
        if (isBlocked == false) goto L4;
        return 0;
    L4:
        return 3;
    }
}
