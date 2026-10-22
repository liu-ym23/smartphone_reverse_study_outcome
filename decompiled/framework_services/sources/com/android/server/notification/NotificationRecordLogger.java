package com.android.server.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Person;
import android.os.Bundle;
import android.util.Log;
import com.android.internal.art.ArtStatsLog;
import com.android.internal.logging.InstanceId;
import com.android.internal.logging.UiEventLogger;
import com.android.internal.util.FrameworkStatsLog;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
interface NotificationRecordLogger {
    public static final String TAG = "NotificationRecordLogger";

    public static final enum NotificationCancelledEvent extends Enum<NotificationCancelledEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationCancelledEvent[] $VALUES = null;
        public static final NotificationCancelledEvent INVALID = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_APP_CANCEL = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_APP_CANCEL_ALL = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_ASSISTANT = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_CHANNEL_BANNED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_CHANNEL_REMOVED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_CLEAR_DATA = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_CLICK = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_ERROR = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_GROUP_OPTIMIZATION = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_GROUP_SUMMARY_CANCELED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_LISTENER_CANCEL = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_LISTENER_CANCEL_ALL = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_PACKAGE_BANNED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_PACKAGE_CHANGED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_PACKAGE_SUSPENDED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_PROFILE_TURNED_OFF = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_SNOOZED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_TIMEOUT = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_UNAUTOBUNDLED = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_AOD = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_BUBBLE = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_CANCEL_ALL = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_LOCKSCREEN = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_OTHER = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_PEEK = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_SHADE = null;
        public static final NotificationCancelledEvent NOTIFICATION_CANCEL_USER_STOPPED = null;
        private final int mId;

        private static /* synthetic */ NotificationCancelledEvent[] $values() {
            return new NotificationCancelledEvent[]{INVALID, NOTIFICATION_CANCEL_CLICK, NOTIFICATION_CANCEL_USER_OTHER, NOTIFICATION_CANCEL_USER_CANCEL_ALL, NOTIFICATION_CANCEL_ERROR, NOTIFICATION_CANCEL_PACKAGE_CHANGED, NOTIFICATION_CANCEL_USER_STOPPED, NOTIFICATION_CANCEL_PACKAGE_BANNED, NOTIFICATION_CANCEL_APP_CANCEL, NOTIFICATION_CANCEL_APP_CANCEL_ALL, NOTIFICATION_CANCEL_LISTENER_CANCEL, NOTIFICATION_CANCEL_LISTENER_CANCEL_ALL, NOTIFICATION_CANCEL_GROUP_SUMMARY_CANCELED, NOTIFICATION_CANCEL_GROUP_OPTIMIZATION, NOTIFICATION_CANCEL_PACKAGE_SUSPENDED, NOTIFICATION_CANCEL_PROFILE_TURNED_OFF, NOTIFICATION_CANCEL_UNAUTOBUNDLED, NOTIFICATION_CANCEL_CHANNEL_BANNED, NOTIFICATION_CANCEL_SNOOZED, NOTIFICATION_CANCEL_TIMEOUT, NOTIFICATION_CANCEL_CHANNEL_REMOVED, NOTIFICATION_CANCEL_CLEAR_DATA, NOTIFICATION_CANCEL_USER_PEEK, NOTIFICATION_CANCEL_USER_AOD, NOTIFICATION_CANCEL_USER_BUBBLE, NOTIFICATION_CANCEL_USER_LOCKSCREEN, NOTIFICATION_CANCEL_USER_SHADE, NOTIFICATION_CANCEL_ASSISTANT};
        }

        public static NotificationCancelledEvent valueOf(String name) {
            return (NotificationCancelledEvent) Enum.valueOf(NotificationCancelledEvent.class, name);
        }

        public static NotificationCancelledEvent[] values() {
            return (NotificationCancelledEvent[]) $VALUES.clone();
        }

        static {
            INVALID = new NotificationCancelledEvent("INVALID", 0, 0);
            NOTIFICATION_CANCEL_CLICK = new NotificationCancelledEvent("NOTIFICATION_CANCEL_CLICK", 1, 164);
            NOTIFICATION_CANCEL_USER_OTHER = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_OTHER", 2, 165);
            NOTIFICATION_CANCEL_USER_CANCEL_ALL = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_CANCEL_ALL", 3, 166);
            NOTIFICATION_CANCEL_ERROR = new NotificationCancelledEvent("NOTIFICATION_CANCEL_ERROR", 4, 167);
            NOTIFICATION_CANCEL_PACKAGE_CHANGED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_PACKAGE_CHANGED", 5, 168);
            NOTIFICATION_CANCEL_USER_STOPPED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_STOPPED", 6, 169);
            NOTIFICATION_CANCEL_PACKAGE_BANNED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_PACKAGE_BANNED", 7, 170);
            NOTIFICATION_CANCEL_APP_CANCEL = new NotificationCancelledEvent("NOTIFICATION_CANCEL_APP_CANCEL", 8, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__CROSS_PROFILE_SETTINGS_PAGE_USER_DECLINED_CONSENT);
            NOTIFICATION_CANCEL_APP_CANCEL_ALL = new NotificationCancelledEvent("NOTIFICATION_CANCEL_APP_CANCEL_ALL", 9, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__CROSS_PROFILE_SETTINGS_PAGE_PERMISSION_REVOKED);
            NOTIFICATION_CANCEL_LISTENER_CANCEL = new NotificationCancelledEvent("NOTIFICATION_CANCEL_LISTENER_CANCEL", 10, 173);
            NOTIFICATION_CANCEL_LISTENER_CANCEL_ALL = new NotificationCancelledEvent("NOTIFICATION_CANCEL_LISTENER_CANCEL_ALL", 11, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_EMPTY_STATE_QUIET_MODE);
            NOTIFICATION_CANCEL_GROUP_SUMMARY_CANCELED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_GROUP_SUMMARY_CANCELED", 12, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_LAUNCH_OTHER_APP);
            NOTIFICATION_CANCEL_GROUP_OPTIMIZATION = new NotificationCancelledEvent("NOTIFICATION_CANCEL_GROUP_OPTIMIZATION", 13, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_PICK_RESULT);
            NOTIFICATION_CANCEL_PACKAGE_SUSPENDED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_PACKAGE_SUSPENDED", 14, 177);
            NOTIFICATION_CANCEL_PROFILE_TURNED_OFF = new NotificationCancelledEvent("NOTIFICATION_CANCEL_PROFILE_TURNED_OFF", 15, 178);
            NOTIFICATION_CANCEL_UNAUTOBUNDLED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_UNAUTOBUNDLED", 16, 179);
            NOTIFICATION_CANCEL_CHANNEL_BANNED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_CHANNEL_BANNED", 17, 180);
            NOTIFICATION_CANCEL_SNOOZED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_SNOOZED", 18, 181);
            NOTIFICATION_CANCEL_TIMEOUT = new NotificationCancelledEvent("NOTIFICATION_CANCEL_TIMEOUT", 19, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__CREDENTIAL_MANAGEMENT_APP_REQUEST_FAILED);
            NOTIFICATION_CANCEL_CHANNEL_REMOVED = new NotificationCancelledEvent("NOTIFICATION_CANCEL_CHANNEL_REMOVED", 20, 1261);
            NOTIFICATION_CANCEL_CLEAR_DATA = new NotificationCancelledEvent("NOTIFICATION_CANCEL_CLEAR_DATA", 21, 1262);
            NOTIFICATION_CANCEL_USER_PEEK = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_PEEK", 22, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__PLATFORM_PROVISIONING_COPY_ACCOUNT_MS);
            NOTIFICATION_CANCEL_USER_AOD = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_AOD", 23, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__PLATFORM_PROVISIONING_CREATE_PROFILE_MS);
            NOTIFICATION_CANCEL_USER_BUBBLE = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_BUBBLE", 24, 1228);
            NOTIFICATION_CANCEL_USER_LOCKSCREEN = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_LOCKSCREEN", 25, 193);
            NOTIFICATION_CANCEL_USER_SHADE = new NotificationCancelledEvent("NOTIFICATION_CANCEL_USER_SHADE", 26, 192);
            NOTIFICATION_CANCEL_ASSISTANT = new NotificationCancelledEvent("NOTIFICATION_CANCEL_ASSISTANT", 27, FrameworkStatsLog.DEVICE_ORIENTATION_CHANGED);
            $VALUES = $values();
        }

        private NotificationCancelledEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }

        public static NotificationCancelledEvent fromCancelReason(int reason, int surface) {
            if (surface != (-1)) goto L7;
            Log.wtf(NotificationRecordLogger.TAG, "Unexpected surface: " + surface + " with reason " + reason);
            return INVALID;
        L7:
            if (reason != 2) goto L24;
            switch(surface) {
                case 0: goto L22;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                default: goto L9;
            };
        L9:
            Log.wtf(NotificationRecordLogger.TAG, "Unexpected surface: " + surface + " with reason " + reason);
            return INVALID;
        L12:
            return NOTIFICATION_CANCEL_USER_LOCKSCREEN;
        L14:
            return NOTIFICATION_CANCEL_USER_BUBBLE;
        L16:
            return NOTIFICATION_CANCEL_USER_SHADE;
        L18:
            return NOTIFICATION_CANCEL_USER_AOD;
        L20:
            return NOTIFICATION_CANCEL_USER_PEEK;
        L22:
            return NOTIFICATION_CANCEL_USER_OTHER;
        L24:
            if (1 > reason) goto L30;
            if (reason > 21) goto L30;
            return values()[reason];
        L30:
            if (reason == 22) goto L32;
            Log.wtf(NotificationRecordLogger.TAG, "Unexpected reason: " + reason + " with surface " + surface);
            return INVALID;
        L32:
            return NOTIFICATION_CANCEL_ASSISTANT;
        }
    }

    public static final enum NotificationEvent extends Enum<NotificationEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationEvent[] $VALUES = null;
        public static final NotificationEvent NOTIFICATION_ACTION_CLICKED = null;
        public static final NotificationEvent NOTIFICATION_ACTION_CLICKED_0 = null;
        public static final NotificationEvent NOTIFICATION_ACTION_CLICKED_1 = null;
        public static final NotificationEvent NOTIFICATION_ACTION_CLICKED_2 = null;
        public static final NotificationEvent NOTIFICATION_ASSIST_ACTION_CLICKED_0 = null;
        public static final NotificationEvent NOTIFICATION_ASSIST_ACTION_CLICKED_1 = null;
        public static final NotificationEvent NOTIFICATION_ASSIST_ACTION_CLICKED_2 = null;
        public static final NotificationEvent NOTIFICATION_CLICKED = null;
        public static final NotificationEvent NOTIFICATION_CLOSE = null;
        public static final NotificationEvent NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_0 = null;
        public static final NotificationEvent NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_1 = null;
        public static final NotificationEvent NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_2 = null;
        public static final NotificationEvent NOTIFICATION_DETAIL_CLOSE_SYSTEM = null;
        public static final NotificationEvent NOTIFICATION_DETAIL_CLOSE_USER = null;
        public static final NotificationEvent NOTIFICATION_DETAIL_OPEN_SYSTEM = null;
        public static final NotificationEvent NOTIFICATION_DETAIL_OPEN_USER = null;
        public static final NotificationEvent NOTIFICATION_DIRECT_REPLIED = null;
        public static final NotificationEvent NOTIFICATION_FORCE_GROUP = null;
        public static final NotificationEvent NOTIFICATION_FORCE_GROUP_SUMMARY = null;
        public static final NotificationEvent NOTIFICATION_NOT_POSTED_SNOOZED = null;
        public static final NotificationEvent NOTIFICATION_OPEN = null;
        public static final NotificationEvent NOTIFICATION_SMART_REPLIED = null;
        public static final NotificationEvent NOTIFICATION_SMART_REPLY_VISIBLE = null;
        public static final NotificationEvent NOTIFICATION_SNOOZED = null;
        private final int mId;

        private static /* synthetic */ NotificationEvent[] $values() {
            return new NotificationEvent[]{NOTIFICATION_OPEN, NOTIFICATION_CLOSE, NOTIFICATION_SNOOZED, NOTIFICATION_NOT_POSTED_SNOOZED, NOTIFICATION_CLICKED, NOTIFICATION_ACTION_CLICKED, NOTIFICATION_DETAIL_OPEN_SYSTEM, NOTIFICATION_DETAIL_CLOSE_SYSTEM, NOTIFICATION_DETAIL_OPEN_USER, NOTIFICATION_DETAIL_CLOSE_USER, NOTIFICATION_DIRECT_REPLIED, NOTIFICATION_SMART_REPLIED, NOTIFICATION_SMART_REPLY_VISIBLE, NOTIFICATION_ACTION_CLICKED_0, NOTIFICATION_ACTION_CLICKED_1, NOTIFICATION_ACTION_CLICKED_2, NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_0, NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_1, NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_2, NOTIFICATION_ASSIST_ACTION_CLICKED_0, NOTIFICATION_ASSIST_ACTION_CLICKED_1, NOTIFICATION_ASSIST_ACTION_CLICKED_2, NOTIFICATION_FORCE_GROUP, NOTIFICATION_FORCE_GROUP_SUMMARY};
        }

        public static NotificationEvent valueOf(String name) {
            return (NotificationEvent) Enum.valueOf(NotificationEvent.class, name);
        }

        public static NotificationEvent[] values() {
            return (NotificationEvent[]) $VALUES.clone();
        }

        static {
            NOTIFICATION_OPEN = new NotificationEvent("NOTIFICATION_OPEN", 0, 197);
            NOTIFICATION_CLOSE = new NotificationEvent("NOTIFICATION_CLOSE", 1, FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__SET_USB_DATA_SIGNALING);
            NOTIFICATION_SNOOZED = new NotificationEvent("NOTIFICATION_SNOOZED", 2, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_MEDIA_SESSION_CALLBACK);
            NOTIFICATION_NOT_POSTED_SNOOZED = new NotificationEvent("NOTIFICATION_NOT_POSTED_SNOOZED", 3, 319);
            NOTIFICATION_CLICKED = new NotificationEvent("NOTIFICATION_CLICKED", 4, 320);
            NOTIFICATION_ACTION_CLICKED = new NotificationEvent("NOTIFICATION_ACTION_CLICKED", 5, 321);
            NOTIFICATION_DETAIL_OPEN_SYSTEM = new NotificationEvent("NOTIFICATION_DETAIL_OPEN_SYSTEM", 6, 327);
            NOTIFICATION_DETAIL_CLOSE_SYSTEM = new NotificationEvent("NOTIFICATION_DETAIL_CLOSE_SYSTEM", 7, 328);
            NOTIFICATION_DETAIL_OPEN_USER = new NotificationEvent("NOTIFICATION_DETAIL_OPEN_USER", 8, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_TILE_ONCLICK);
            NOTIFICATION_DETAIL_CLOSE_USER = new NotificationEvent("NOTIFICATION_DETAIL_CLOSE_USER", 9, 330);
            NOTIFICATION_DIRECT_REPLIED = new NotificationEvent("NOTIFICATION_DIRECT_REPLIED", 10, 331);
            NOTIFICATION_SMART_REPLIED = new NotificationEvent("NOTIFICATION_SMART_REPLIED", 11, ArtStatsLog.ART_DATUM_REPORTED);
            NOTIFICATION_SMART_REPLY_VISIBLE = new NotificationEvent("NOTIFICATION_SMART_REPLY_VISIBLE", 12, FrameworkStatsLog.DEVICE_ROTATED);
            NOTIFICATION_ACTION_CLICKED_0 = new NotificationEvent("NOTIFICATION_ACTION_CLICKED_0", 13, 450);
            NOTIFICATION_ACTION_CLICKED_1 = new NotificationEvent("NOTIFICATION_ACTION_CLICKED_1", 14, FrameworkStatsLog.CDM_ASSOCIATION_ACTION);
            NOTIFICATION_ACTION_CLICKED_2 = new NotificationEvent("NOTIFICATION_ACTION_CLICKED_2", 15, FrameworkStatsLog.MAGNIFICATION_TRIPLE_TAP_AND_HOLD_ACTIVATED_SESSION_REPORTED);
            NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_0 = new NotificationEvent("NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_0", 16, FrameworkStatsLog.MAGNIFICATION_FOLLOW_TYPING_FOCUS_ACTIVATED_SESSION_REPORTED);
            NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_1 = new NotificationEvent("NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_1", 17, 454);
            NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_2 = new NotificationEvent("NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_2", 18, 455);
            NOTIFICATION_ASSIST_ACTION_CLICKED_0 = new NotificationEvent("NOTIFICATION_ASSIST_ACTION_CLICKED_0", 19, 456);
            NOTIFICATION_ASSIST_ACTION_CLICKED_1 = new NotificationEvent("NOTIFICATION_ASSIST_ACTION_CLICKED_1", 20, ArtStatsLog.ISOLATED_COMPILATION_SCHEDULED);
            NOTIFICATION_ASSIST_ACTION_CLICKED_2 = new NotificationEvent("NOTIFICATION_ASSIST_ACTION_CLICKED_2", 21, ArtStatsLog.ISOLATED_COMPILATION_ENDED);
            NOTIFICATION_FORCE_GROUP = new NotificationEvent("NOTIFICATION_FORCE_GROUP", 22, 1843);
            NOTIFICATION_FORCE_GROUP_SUMMARY = new NotificationEvent("NOTIFICATION_FORCE_GROUP_SUMMARY", 23, 1844);
            $VALUES = $values();
        }

        private NotificationEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }

        public static NotificationEvent fromVisibility(boolean visible) {
            if (visible == false) goto L5;
            return NOTIFICATION_OPEN;
        L5:
            return NOTIFICATION_CLOSE;
        }

        public static NotificationEvent fromExpanded(boolean expanded, boolean userAction) {
            if (userAction == false) goto L7;
            if (expanded == false) goto L6;
            return NOTIFICATION_DETAIL_OPEN_USER;
        L6:
            return NOTIFICATION_DETAIL_CLOSE_USER;
        L7:
            if (expanded == false) goto L10;
            return NOTIFICATION_DETAIL_OPEN_SYSTEM;
        L10:
            return NOTIFICATION_DETAIL_CLOSE_SYSTEM;
        }

        public static NotificationEvent fromAction(int index, boolean isAssistant, boolean isContextual) {
            if (index < 0) goto L15;
            if (index > 2) goto L15;
            if (isAssistant == true) goto L8;
            if (isContextual == false) goto L13;
            return values()[NOTIFICATION_CONTEXTUAL_ACTION_CLICKED_0.ordinal() + index];
        L13:
            return values()[NOTIFICATION_ACTION_CLICKED_0.ordinal() + index];
        L8:
            return values()[NOTIFICATION_ASSIST_ACTION_CLICKED_0.ordinal() + index];
        L15:
            return NOTIFICATION_ACTION_CLICKED;
        }
    }

    public static final enum NotificationPanelEvent extends Enum<NotificationPanelEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationPanelEvent[] $VALUES = null;
        public static final NotificationPanelEvent NOTIFICATION_PANEL_CLOSE = null;
        public static final NotificationPanelEvent NOTIFICATION_PANEL_OPEN = null;
        private final int mId;

        private static /* synthetic */ NotificationPanelEvent[] $values() {
            return new NotificationPanelEvent[]{NOTIFICATION_PANEL_OPEN, NOTIFICATION_PANEL_CLOSE};
        }

        public static NotificationPanelEvent valueOf(String name) {
            return (NotificationPanelEvent) Enum.valueOf(NotificationPanelEvent.class, name);
        }

        public static NotificationPanelEvent[] values() {
            return (NotificationPanelEvent[]) $VALUES.clone();
        }

        static {
            NOTIFICATION_PANEL_OPEN = new NotificationPanelEvent("NOTIFICATION_PANEL_OPEN", 0, 325);
            NOTIFICATION_PANEL_CLOSE = new NotificationPanelEvent("NOTIFICATION_PANEL_CLOSE", 1, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_PACKAGE_INSTALLER);
            $VALUES = $values();
        }

        private NotificationPanelEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }
    }

    public static final enum NotificationPullStatsEvent extends Enum<NotificationPullStatsEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationPullStatsEvent[] $VALUES = null;
        public static final NotificationPullStatsEvent NOTIFICATION_BUNDLE_PREFERENCES_PULLED = null;
        private final int mId;

        private static /* synthetic */ NotificationPullStatsEvent[] $values() {
            return new NotificationPullStatsEvent[]{NOTIFICATION_BUNDLE_PREFERENCES_PULLED};
        }

        public static NotificationPullStatsEvent valueOf(String name) {
            return (NotificationPullStatsEvent) Enum.valueOf(NotificationPullStatsEvent.class, name);
        }

        public static NotificationPullStatsEvent[] values() {
            return (NotificationPullStatsEvent[]) $VALUES.clone();
        }

        static {
            NOTIFICATION_BUNDLE_PREFERENCES_PULLED = new NotificationPullStatsEvent("NOTIFICATION_BUNDLE_PREFERENCES_PULLED", 0, 2072);
            $VALUES = $values();
        }

        private NotificationPullStatsEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }
    }

    public static class NotificationRecordPair {
        public final NotificationRecord old;
        public final NotificationRecord r;

        NotificationRecordPair(NotificationRecord r, NotificationRecord old) {
            this.r = r;
            this.old = old;
        }

        boolean shouldLogReported(int buzzBeepBlink) {
            if (this.r != null) goto L6;
            return false;
        L6:
            if (this.old == null) goto L25;
            if (buzzBeepBlink > 0) goto L25;
            if (Objects.equals(this.r.getSbn().getChannelIdLogTag(), this.old.getSbn().getChannelIdLogTag()) == false) goto L24;
            if (Objects.equals(this.r.getSbn().getGroupLogTag(), this.old.getSbn().getGroupLogTag()) == false) goto L24;
            if (this.r.getSbn().getNotification().isGroupSummary() != this.old.getSbn().getNotification().isGroupSummary()) goto L24;
            if (Objects.equals(this.r.getSbn().getNotification().category, this.old.getSbn().getNotification().category) == false) goto L24;
            if (this.r.getImportance() != this.old.getImportance()) goto L24;
            if (NotificationRecordLogger.getLoggingImportance(this.r) != NotificationRecordLogger.getLoggingImportance(this.old)) goto L24;
            if (this.r.rankingScoreMatches(this.old.getRankingScore()) == false) goto L24;
            return false;
        L24:
            return true;
        L25:
            return true;
        }

        public int getStyle() {
            return getStyle(this.r.getSbn().getNotification().extras);
        }

        private int getStyle(Bundle extras) {
            if (extras == null) goto L9;
            String template = extras.getString("android.template");
            if (template != null) goto L6;
            return 0;
        L6:
            if (template.isEmpty() == false) goto L8;
            return 0;
        L8:
            return template.hashCode();
        L9:
            return 0;
        }

        int getNumPeople() {
            return getNumPeople(this.r.getSbn().getNotification().extras);
        }

        private int getNumPeople(Bundle extras) {
            if (extras == null) goto L9;
            ArrayList<Person> people = extras.getParcelableArrayList("android.people.list", Person.class);
            if (people != null) goto L6;
            return 0;
        L6:
            if (people.isEmpty() == false) goto L8;
            return 0;
        L8:
            return people.size();
        L9:
            return 0;
        }

        int getAssistantHash() {
            String assistant = this.r.getAdjustmentIssuer();
            if (assistant != null) goto L6;
            return 0;
        L6:
            return assistant.hashCode();
        }

        int getInstanceId() {
            if (this.r.getSbn().getInstanceId() != null) goto L6;
            return 0;
        L6:
            return this.r.getSbn().getInstanceId().getId();
        }

        int getNotificationIdHash() {
            return SmallHash.hash(Objects.hashCode(this.r.getSbn().getTag()) ^ this.r.getSbn().getId());
        }

        int getChannelIdHash() {
            return SmallHash.hash(this.r.getSbn().getNotification().getChannelId());
        }

        int getGroupIdHash() {
            return SmallHash.hash(this.r.getSbn().getGroup());
        }
    }

    public static class NotificationReported {
        final int age_in_minutes;
        final int alerting;
        final int assistant_hash;
        final float assistant_ranking_score;
        final String category;
        final int channel_id_hash;
        final int event_id;
        final int fsi_state;
        final int group_id_hash;
        final int group_instance_id;
        final boolean has_promotable_characteristics;
        final int importance;
        final int importance_asst;
        final int importance_initial;
        final int importance_initial_source;
        final int importance_source;
        final int instance_id;
        final boolean is_foreground_service;
        final boolean is_group_summary;
        final boolean is_locked;
        final boolean is_non_dismissible;
        final boolean is_ongoing;
        final boolean is_promoted_ongoing;
        final int notification_id_hash;
        final int num_people;
        final String package_name;
        final int position;
        long post_duration_millis;
        final int style;
        final long timeout_millis;
        final int uid;

        NotificationReported(NotificationRecordPair p, NotificationReportedEvent eventType, int position, int buzzBeepBlink, InstanceId groupId) {
            Notification notification = p.r.getSbn().getNotification();
            this.event_id = eventType.getId();
            this.uid = p.r.getUid();
            this.package_name = p.r.getSbn().getPackageName();
            this.instance_id = p.getInstanceId();
            this.notification_id_hash = p.getNotificationIdHash();
            this.channel_id_hash = p.getChannelIdHash();
            this.group_id_hash = p.getGroupIdHash();
            boolean hasFsiRequestedButDeniedFlag = false;
            if (groupId != null) goto L5;
            int r2 = 0;
        L6:
            this.group_instance_id = r2;
            this.is_group_summary = notification.isGroupSummary();
            this.category = notification.category;
            this.style = p.getStyle();
            this.num_people = p.getNumPeople();
            this.position = position;
            this.importance = NotificationRecordLogger.getLoggingImportance(p.r);
            this.alerting = buzzBeepBlink;
            this.importance_source = p.r.getImportanceExplanationCode();
            this.importance_initial = p.r.getInitialImportance();
            this.importance_initial_source = p.r.getInitialImportanceExplanationCode();
            this.importance_asst = p.r.getAssistantImportance();
            this.assistant_hash = p.getAssistantHash();
            this.assistant_ranking_score = p.r.getRankingScore();
            this.is_ongoing = p.r.getSbn().isOngoing();
            this.is_foreground_service = NotificationRecordLogger.isForegroundService(p.r);
            this.timeout_millis = notification.getTimeoutAfter();
            this.is_non_dismissible = NotificationRecordLogger.isNonDismissible(p.r);
            if (notification.fullScreenIntent == null) goto L9;
            boolean hasFullScreenIntent = true;
        L11:
            if ((notification.flags & 16384) == 0) goto L13;
            hasFsiRequestedButDeniedFlag = true;
        L13:
            this.fsi_state = NotificationRecordLogger.getFsiState(hasFullScreenIntent, hasFsiRequestedButDeniedFlag, eventType);
            this.is_locked = p.r.isLocked();
            this.age_in_minutes = NotificationRecordLogger.getAgeInMinutes(p.r.getSbn().getPostTime(), notification.getWhen());
            this.is_promoted_ongoing = notification.isPromotedOngoing();
            this.has_promotable_characteristics = notification.hasPromotableCharacteristics();
            return;
        L9:
            hasFullScreenIntent = false;
            goto L11
        L5:
            r2 = groupId.getId();
            goto L6
        }
    }

    public static final enum NotificationReportedEvent extends Enum<NotificationReportedEvent> implements UiEventLogger.UiEventEnum {
        private static final /* synthetic */ NotificationReportedEvent[] $VALUES = null;
        public static final NotificationReportedEvent NOTIFICATION_ADJUSTED = null;
        public static final NotificationReportedEvent NOTIFICATION_POSTED = null;
        public static final NotificationReportedEvent NOTIFICATION_UPDATED = null;
        private final int mId;

        private static /* synthetic */ NotificationReportedEvent[] $values() {
            return new NotificationReportedEvent[]{NOTIFICATION_POSTED, NOTIFICATION_UPDATED, NOTIFICATION_ADJUSTED};
        }

        public static NotificationReportedEvent valueOf(String name) {
            return (NotificationReportedEvent) Enum.valueOf(NotificationReportedEvent.class, name);
        }

        public static NotificationReportedEvent[] values() {
            return (NotificationReportedEvent[]) $VALUES.clone();
        }

        static {
            NOTIFICATION_POSTED = new NotificationReportedEvent("NOTIFICATION_POSTED", 0, 162);
            NOTIFICATION_UPDATED = new NotificationReportedEvent("NOTIFICATION_UPDATED", 1, 163);
            NOTIFICATION_ADJUSTED = new NotificationReportedEvent("NOTIFICATION_ADJUSTED", 2, 908);
            $VALUES = $values();
        }

        private NotificationReportedEvent(String r1, int r2, int id) {
            super(r1, r2);
            this.mId = id;
        }

        public int getId() {
            return this.mId;
        }

        public static NotificationReportedEvent fromRecordPair(NotificationRecordPair p) {
            if (p.old == null) goto L6;
            return NOTIFICATION_UPDATED;
        L6:
            return NOTIFICATION_POSTED;
        }
    }

    void log(UiEventLogger.UiEventEnum r1);

    void log(UiEventLogger.UiEventEnum r1, NotificationRecord r2);

    void logNotificationAdjusted(NotificationRecord r1, int r2, int r3, InstanceId r4);

    void logNotificationPosted(NotificationReported r1);

    default NotificationReported prepareToLogNotificationPosted(NotificationRecord r, NotificationRecord old, int position, int buzzBeepBlink, InstanceId groupId) {
        NotificationRecordPair p = new NotificationRecordPair(r, old);
        if (p.shouldLogReported(buzzBeepBlink) == true) goto L7;
        return null;
    L7:
        return new NotificationReported(p, NotificationReportedEvent.fromRecordPair(p), position, buzzBeepBlink, groupId);
    }

    default void logNotificationCancelled(NotificationRecord r, int reason, int dismissalSurface) {
        log(NotificationCancelledEvent.fromCancelReason(reason, dismissalSurface), r);
    }

    default void logNotificationVisibility(NotificationRecord r, boolean visible) {
        log(NotificationEvent.fromVisibility(visible), r);
    }

    static int getLoggingImportance(NotificationRecord r) {
        int importance = r.getImportance();
        NotificationChannel channel = r.getChannel();
        if (channel != null) goto L6;
        return importance;
    L6:
        return NotificationChannelLogger.getLoggingImportance(channel, importance);
    }

    static boolean isForegroundService(NotificationRecord r) {
        if (r.getSbn() != null) goto L5;
    L11:
        return false;
    L5:
        if (r.getSbn().getNotification() == null) goto L11;
        if ((r.getSbn().getNotification().flags & 64) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    static boolean isNonDismissible(NotificationRecord r) {
        if (r.getSbn() != null) goto L5;
    L11:
        return false;
    L5:
        if (r.getSbn().getNotification() == null) goto L11;
        if ((r.getNotification().flags & 8192) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    static int getFsiState(boolean hasFullScreenIntent, boolean hasFsiRequestedButDeniedFlag, NotificationReportedEvent eventType) {
        if (eventType != NotificationReportedEvent.NOTIFICATION_UPDATED) goto L5;
        return 0;
    L5:
        if (hasFullScreenIntent == false) goto L8;
        return 1;
    L8:
        if (hasFsiRequestedButDeniedFlag == false) goto L11;
        return 2;
    L11:
        return 0;
    }

    static int getAgeInMinutes(long postTimeMs, long whenMs) {
        return (int) Duration.ofMillis(postTimeMs - whenMs).toMinutes();
    }
}
