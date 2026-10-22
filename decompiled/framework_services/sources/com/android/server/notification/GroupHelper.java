package com.android.server.notification;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import com.android.server.BinaryTransparencyService$Digest$$ExternalSyntheticRecord1;
import com.android.server.inputmethod.AdditionalSubtypeMapRepository$WriteTask$$ExternalSyntheticRecord0;
import com.android.server.media.SystemMediaRoute2Provider2$ProviderProxyRecord$$ExternalSyntheticRecord0;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class GroupHelper {
    protected static final String AGGREGATE_GROUP_KEY = "Aggregate_";
    private static final int ALL_CHILDREN_FLAG = 16;
    private static final int ANY_CHILDREN_FLAGS = 34;
    protected static final String AUTOGROUP_KEY = "ranker_group";
    protected static final int BASE_FLAGS = 1792;
    static final boolean DEBUG = false;
    protected static final int FLAG_INVALID = -1;
    private static final int MIN_CHILD_COUNT_TO_AVOID_FORCE_GROUPING = 3;
    private static List<NotificationSectioner> NOTIFICATION_BUNDLE_SECTIONS = null;
    private static List<NotificationSectioner> NOTIFICATION_SHADE_SECTIONS = null;
    private static final String NUBIA_PUSH_CLIENT_PACKAGE = "com.zte.dbneopush";
    static final int REGROUP_REASON_BUNDLE = 1;
    static final int REGROUP_REASON_CHANNEL_UPDATE = 0;
    static final int REGROUP_REASON_UNBUNDLE = 2;
    static final int REGROUP_REASON_UNBUNDLE_ORIGINAL_GROUP = 3;
    private static final String TAG = "GroupHelper";
    private final ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> mAggregatedNotifications;
    private final int mAutoGroupAtCount;
    private final int mAutogroupSparseGroupsAtCount;
    private final Callback mCallback;
    private final ArrayMap<FullyQualifiedGroupKey, CachedSummary> mCanceledSummaries;
    private final Context mContext;
    private boolean mIsTestHarnessExempted;
    private final PackageManager mPackageManager;
    private final ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> mUngroupedAbuseNotifications;
    private final ArrayMap<String, ArrayMap<String, NotificationAttributes>> mUngroupedNotifications;

    static final class CachedSummary extends Record {
        private final PendingIntent deleteIntent;
        private final int id;
        private final String key;
        private final String originalGroupKey;
        private final String tag;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof CachedSummary) == false) goto L16;
            CachedSummary r4 = (CachedSummary) r3;
            if (this.id == r4.id) goto L7;
            return false;
        L7:
            if (Objects.equals(this.tag, r4.tag) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.originalGroupKey, r4.originalGroupKey) == true) goto L11;
            return false;
        L11:
            if (Objects.equals(this.key, r4.key) == true) goto L13;
            return false;
        L13:
            if (Objects.equals(this.deleteIntent, r4.deleteIntent) == false) goto L22;
            return true;
        L22:
            return false;
        L16:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Integer.valueOf(this.id), this.tag, this.originalGroupKey, this.key, this.deleteIntent};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetdeleteIntent, reason: not valid java name */
        static /* bridge */ /* synthetic */ PendingIntent m6056$$Nest$fgetdeleteIntent(CachedSummary r0) {
            return r0.deleteIntent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6057$$Nest$fgetid(CachedSummary r0) {
            return r0.id;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetkey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6058$$Nest$fgetkey(CachedSummary r0) {
            return r0.key;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetoriginalGroupKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6059$$Nest$fgetoriginalGroupKey(CachedSummary r0) {
            return r0.originalGroupKey;
        }

        /* JADX INFO: renamed from: -$$Nest$fgettag, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6060$$Nest$fgettag(CachedSummary r0) {
            return r0.tag;
        }

        CachedSummary(int id, String tag, String originalGroupKey, String key, PendingIntent deleteIntent) {
            this.id = id;
            this.tag = tag;
            this.originalGroupKey = originalGroupKey;
            this.key = key;
            this.deleteIntent = deleteIntent;
        }

        public PendingIntent deleteIntent() {
            return this.deleteIntent;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return GroupHelper$CachedSummary$$ExternalSyntheticRecord0.m(this.id, this.tag, this.originalGroupKey, this.key, this.deleteIntent);
        }

        public int id() {
            return this.id;
        }

        public String key() {
            return this.key;
        }

        public String originalGroupKey() {
            return this.originalGroupKey;
        }

        public String tag() {
            return this.tag;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), CachedSummary.class, "id;tag;originalGroupKey;key;deleteIntent");
        }
    }

    protected interface Callback {
        void addAutoGroup(String r1, String r2, boolean r3);

        void addAutoGroupSummary(int r1, String r2, String r3, String r4, int r5, NotificationAttributes r6);

        void removeAppProvidedSummary(String r1);

        NotificationRecord removeAppProvidedSummaryOnClassification(String r1, String r2);

        void removeAutoGroup(String r1);

        void removeAutoGroupSummary(int r1, String r2, String r3);

        void removeNotificationFromCanceledGroup(int r1, String r2, String r3, int r4);

        void sendAppProvidedSummaryDeleteIntent(String r1, PendingIntent r2);

        void updateAutogroupSummary(int r1, String r2, String r3, NotificationAttributes r4);
    }

    static final class FullyQualifiedGroupKey extends Record {
        private final String groupName;
        private final String pkg;
        private final int userId;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof FullyQualifiedGroupKey) == false) goto L12;
            FullyQualifiedGroupKey r4 = (FullyQualifiedGroupKey) r3;
            if (this.userId == r4.userId) goto L7;
            return false;
        L7:
            if (Objects.equals(this.pkg, r4.pkg) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.groupName, r4.groupName) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpkg, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6061$$Nest$fgetpkg(FullyQualifiedGroupKey r0) {
            return r0.pkg;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6062$$Nest$fgetuserId(FullyQualifiedGroupKey r0) {
            return r0.userId;
        }

        FullyQualifiedGroupKey(int userId, String pkg, String groupName) {
            this.userId = userId;
            this.pkg = pkg;
            this.groupName = groupName;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        public String groupName() {
            return this.groupName;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return AdditionalSubtypeMapRepository$WriteTask$$ExternalSyntheticRecord0.m(this.userId, this.pkg, this.groupName);
        }

        public String pkg() {
            return this.pkg;
        }

        public int userId() {
            return this.userId;
        }

        FullyQualifiedGroupKey(int userId, String pkg, NotificationSectioner sectioner) {
            StringBuilder r0 = new StringBuilder();
            r0.append(GroupHelper.AGGREGATE_GROUP_KEY);
            if (sectioner == null) goto L5;
            String r1 = sectioner.mName;
        L6:
            r0.append(r1);
            this(userId, pkg, r0.toString());
            return;
        L5:
            r1 = "";
            goto L6
        }

        static FullyQualifiedGroupKey forRecord(NotificationRecord record, NotificationSectioner sectioner) {
            return new FullyQualifiedGroupKey(record.getUserId(), record.getSbn().getPackageName(), sectioner);
        }

        @Override // java.lang.Record
        public String toString() {
            return this.userId + "|" + this.pkg + "|g:" + this.groupName;
        }
    }

    protected static class NotificationAttributes {
        public final String channelId;
        public final int flags;
        public final int groupAlertBehavior;
        public final Icon icon;
        public final int iconColor;
        public final int visibility;

        public NotificationAttributes(int flags, Icon icon, int iconColor, int visibility, int groupAlertBehavior, String channelId) {
            this.flags = flags;
            this.icon = icon;
            this.iconColor = iconColor;
            this.visibility = visibility;
            this.groupAlertBehavior = groupAlertBehavior;
            this.channelId = channelId;
        }

        public NotificationAttributes(NotificationAttributes attr) {
            this.flags = attr.flags;
            this.icon = attr.icon;
            this.iconColor = attr.iconColor;
            this.visibility = attr.visibility;
            this.groupAlertBehavior = attr.groupAlertBehavior;
            this.channelId = attr.channelId;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof NotificationAttributes) == false) goto L22;
            NotificationAttributes that = (NotificationAttributes) o;
            if (this.flags != that.flags) goto L21;
            if (this.iconColor != that.iconColor) goto L21;
            if (this.icon.sameAs(that.icon) == false) goto L21;
            if (this.visibility != that.visibility) goto L21;
            if (this.groupAlertBehavior != that.groupAlertBehavior) goto L21;
            if (this.channelId.equals(that.channelId) == false) goto L21;
            return true;
        L21:
            return false;
        L22:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Integer.valueOf(this.flags), Integer.valueOf(this.iconColor), this.icon, Integer.valueOf(this.visibility), Integer.valueOf(this.groupAlertBehavior), this.channelId});
        }

        public String toString() {
            return "NotificationAttributes: flags: " + this.flags + " icon: " + this.icon + " color: " + this.iconColor + " vis: " + this.visibility + " groupAlertBehavior: " + this.groupAlertBehavior + " channelId: " + this.channelId;
        }
    }

    private static final class NotificationMoveOp extends Record {
        private final FullyQualifiedGroupKey newGroup;
        private final FullyQualifiedGroupKey oldGroup;
        private final NotificationRecord record;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof NotificationMoveOp) == false) goto L12;
            NotificationMoveOp r4 = (NotificationMoveOp) r3;
            if (Objects.equals(this.record, r4.record) == true) goto L7;
            return false;
        L7:
            if (Objects.equals(this.oldGroup, r4.oldGroup) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.newGroup, r4.newGroup) == false) goto L16;
            return true;
        L16:
            return false;
        L12:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.record, this.oldGroup, this.newGroup};
        }

        /* JADX INFO: renamed from: -$$Nest$fgetnewGroup, reason: not valid java name */
        static /* bridge */ /* synthetic */ FullyQualifiedGroupKey m6063$$Nest$fgetnewGroup(NotificationMoveOp r0) {
            return r0.newGroup;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetoldGroup, reason: not valid java name */
        static /* bridge */ /* synthetic */ FullyQualifiedGroupKey m6064$$Nest$fgetoldGroup(NotificationMoveOp r0) {
            return r0.oldGroup;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetrecord, reason: not valid java name */
        static /* bridge */ /* synthetic */ NotificationRecord m6065$$Nest$fgetrecord(NotificationMoveOp r0) {
            return r0.record;
        }

        /* synthetic */ NotificationMoveOp(NotificationRecord r1, FullyQualifiedGroupKey r2, FullyQualifiedGroupKey r3, GroupHelperIA r4) {
            this(r1, r2, r3);
        }

        private NotificationMoveOp(NotificationRecord record, FullyQualifiedGroupKey oldGroup, FullyQualifiedGroupKey newGroup) {
            this.record = record;
            this.oldGroup = oldGroup;
            this.newGroup = newGroup;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return SystemMediaRoute2Provider2$ProviderProxyRecord$$ExternalSyntheticRecord0.m(this.record, this.oldGroup, this.newGroup);
        }

        public FullyQualifiedGroupKey newGroup() {
            return this.newGroup;
        }

        public FullyQualifiedGroupKey oldGroup() {
            return this.oldGroup;
        }

        public NotificationRecord record() {
            return this.record;
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), NotificationMoveOp.class, "record;oldGroup;newGroup");
        }
    }

    protected static class NotificationSectioner {
        final String mName;
        private final Predicate<NotificationRecord> mSectionChecker;
        final int mSummaryId;

        /* synthetic */ NotificationSectioner(String r1, int r2, Predicate r3, GroupHelperIA r4) {
            this(r1, r2, r3);
        }

        private NotificationSectioner(String name, int summaryId, Predicate<NotificationRecord> sectionChecker) {
            this.mName = name;
            this.mSummaryId = summaryId;
            this.mSectionChecker = sectionChecker;
        }

        boolean isInSection(NotificationRecord record) {
            if (isNotificationGroupable(record) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mSectionChecker.test(record) == false) goto L7;
            return true;
        }

        private boolean isNotificationGroupable(NotificationRecord record) {
            if (record.isConversation() == false) goto L5;
            return false;
        L5:
            Notification notification = record.getSbn().getNotification();
            if (notification.isForegroundService() == true) goto L8;
        L12:
            boolean isColorizedFGS = false;
        L14:
            if (record.getImportance() > 1) goto L16;
        L18:
            boolean isCall = false;
        L20:
            if (isColorizedFGS == true) goto L27;
            if (isCall == true) goto L27;
            if (record.getSbn().getNotification().isMediaNotification() == false) goto L26;
            return false;
        L26:
            return true;
        L27:
            return false;
        L16:
            if (notification.isStyle(Notification.CallStyle.class) == false) goto L18;
            isCall = true;
            goto L20
        L8:
            if (notification.isColorized() == false) goto L12;
            if (record.getImportance() <= 1) goto L12;
            isColorizedFGS = true;
            goto L14
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface RegroupingReason {
    }

    public static /* synthetic */ boolean $r8$lambda$5GuZJuBrqC7Uv5BlklHQ1ANK7Ww(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$3(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Jb-alKhUHC8ZHo9uONB6z9BQH8c, reason: not valid java name */
    public static /* synthetic */ boolean m6053$r8$lambda$JbalKhUHC8ZHo9uONB6z9BQH8c(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$JdYLtF53zID3brZQfa8kkolVAnU(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$2(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$K83IKWLoiP7DqU6rpnWA1TZSGYo(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$7(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$NegTJpaY8GjhZifLja121BHRtBU(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$SF_u8Ke9E7EQKKb2n2VmK1AfF4M(NotificationRecord r0) {
        return lambda$getNotificationShadeSections$8(r0);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        NOTIFICATION_SHADE_SECTIONS = getNotificationShadeSections();
    }

    private static List<NotificationSectioner> getNotificationShadeSections() {
        ArrayList<NotificationSectioner> sectionsList = new ArrayList();
        String r3 = "PromotionsSection";
        int r4 = 0;
        GroupHelperIA r5 = null;
        String r6 = "SocialSection";
        String r7 = "NewsSection";
        String r8 = "RecsSection";
        sectionsList.addAll(List.of(new NotificationSectioner(r3, r4, new GroupHelper$$ExternalSyntheticLambda0(), r5), new NotificationSectioner(r6, r4, new GroupHelper$$ExternalSyntheticLambda1(), r5), new NotificationSectioner(r7, r4, new GroupHelper$$ExternalSyntheticLambda2(), r5), new NotificationSectioner(r8, r4, new GroupHelper$$ExternalSyntheticLambda3(), r5)));
        NOTIFICATION_BUNDLE_SECTIONS = new ArrayList(sectionsList);
        String r9 = "AlertingSection";
        NotificationSectioner r1 = new NotificationSectioner(r9, r4, new GroupHelper$$ExternalSyntheticLambda4(), r5);
        String r10 = "SilentSection";
        int r11 = 1;
        sectionsList.addAll(List.of(r1, new NotificationSectioner(r10, r11, new GroupHelper$$ExternalSyntheticLambda5(), r5)));
        return sectionsList;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$0(NotificationRecord record) {
        if ("android.app.promotions".equals(record.getChannel().getId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() >= 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$1(NotificationRecord record) {
        if ("android.app.social".equals(record.getChannel().getId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() >= 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$2(NotificationRecord record) {
        if ("android.app.news".equals(record.getChannel().getId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() >= 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$3(NotificationRecord record) {
        if ("android.app.recs".equals(record.getChannel().getId()) == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() >= 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$4(NotificationRecord record) {
        if (record.isConversation() == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getChannel().isImportantConversation() == false) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$5(NotificationRecord record) {
        if (record.isConversation() == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() < 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$6(NotificationRecord record) {
        if (record.isConversation() == true) goto L5;
    L7:
        return false;
    L5:
        if (record.getImportance() >= 3) goto L7;
        return true;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$7(NotificationRecord record) {
        if (record.getImportance() < 3) goto L5;
        return true;
    L5:
        return false;
    }

    private static /* synthetic */ boolean lambda$getNotificationShadeSections$8(NotificationRecord record) {
        if (record.getImportance() >= 3) goto L5;
        return true;
    L5:
        return false;
    }

    public GroupHelper(Context context, PackageManager packageManager, int autoGroupAtCount, int autoGroupSparseGroupsAtCount, Callback callback) {
        this.mUngroupedNotifications = new ArrayMap();
        this.mUngroupedAbuseNotifications = new ArrayMap();
        this.mCanceledSummaries = new ArrayMap();
        this.mAggregatedNotifications = new ArrayMap();
        this.mAutoGroupAtCount = autoGroupAtCount;
        this.mCallback = callback;
        this.mContext = context;
        this.mPackageManager = packageManager;
        this.mAutogroupSparseGroupsAtCount = autoGroupSparseGroupsAtCount;
        NOTIFICATION_SHADE_SECTIONS = getNotificationShadeSections();
    }

    void setTestHarnessExempted(boolean isExempted) {
        if (ActivityManager.isRunningInUserTestHarness() == false) goto L6;
        if (isExempted == false) goto L6;
        boolean r0 = true;
    L7:
        this.mIsTestHarnessExempted = r0;
        return;
    L6:
        r0 = false;
        goto L7
    }

    private String generatePackageKey(int userId, String pkg) {
        return userId + "|" + pkg;
    }

    protected static int getAutogroupSummaryFlags(ArrayMap<String, NotificationAttributes> childrenMap) {
        Collection<NotificationAttributes> children = childrenMap.values();
        int r2 = 0;
        if (children.size() <= 0) goto L5;
        boolean allChildrenHasFlag = true;
    L6:
        int anyChildFlagSet = 0;
        Iterator<NotificationAttributes> r4 = children.iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        NotificationAttributes childAttr = r4.next();
        if (hasAnyFlag(childAttr.flags, 16) == true) goto L13;
        allChildrenHasFlag = false;
    L13:
        if (hasAnyFlag(childAttr.flags, 34) == false) goto L8;
        anyChildFlagSet = anyChildFlagSet | (childAttr.flags & 34);
        goto L8
    L16:
        if (allChildrenHasFlag == false) goto L19;
        r2 = 16;
    L19:
        return (r2 | 1792) | anyChildFlagSet;
    L5:
        allChildrenHasFlag = false;
        goto L6
    }

    private static boolean hasAnyFlag(int flags, int mask) {
        if ((flags & mask) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean onNotificationPosted(NotificationRecord record, boolean autogroupSummaryExists) {
        boolean sbnToBeAutogrouped = false;
        StatusBarNotification sbn = record.getSbn();     // Catch: Exception -> L6
        if (sbn.isAppGroup() == true) goto L8;
        sbnToBeAutogrouped = maybeGroupWithSections(record, autogroupSummaryExists);     // Catch: Exception -> L6
    L12:
    L11:
        return sbnToBeAutogrouped;
    L8:
        maybeUngroupOnAppGrouped(record);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "Failure processing new notification", e);
        goto L11
    }

    public void onNotificationRemoved(NotificationRecord record) {
        Slog.wtf(TAG, "This overload of onNotificationRemoved() should not be called if notification_force_grouping is enabled!", new Exception("call stack"));     // Catch: Exception -> L5
        onNotificationRemoved(record, new ArrayList(), false);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Error processing canceled notification", e);
    }

    private boolean maybeGroup(StatusBarNotification sbn, boolean autogroupSummaryExists) {
        List<String> notificationsToGroup = new ArrayList();
        List<NotificationAttributes> childrenAttr = new ArrayList();
        boolean sbnToBeAutogrouped = false;
        ArrayMap<String, ArrayMap<String, NotificationAttributes>> r6 = this.mUngroupedNotifications;
        monitor-enter(r6);
        String packageKey = generatePackageKey(sbn.getUserId(), sbn.getPackageName());     // Catch: Throwable -> L28
        ArrayMap<String, NotificationAttributes> children = this.mUngroupedNotifications.getOrDefault(packageKey, new ArrayMap());     // Catch: Throwable -> L28
        NotificationAttributes attr = new NotificationAttributes(sbn.getNotification().flags, sbn.getNotification().getSmallIcon(), sbn.getNotification().color, sbn.getNotification().visibility, 2, sbn.getNotification().getChannelId());     // Catch: Throwable -> L28
        children.put(sbn.getKey(), attr);     // Catch: Throwable -> L28
        this.mUngroupedNotifications.put(packageKey, children);     // Catch: Throwable -> L28
        if (children.size() >= this.mAutoGroupAtCount) goto L9;
        if (autogroupSummaryExists == true) goto L9;
        int flags = 0;
    L31:
        monitor-exit(r6);     // Catch: Throwable -> L26
        if (notificationsToGroup.size() <= 0) goto L25;
        if (autogroupSummaryExists == false) goto L16;
        NotificationAttributes attr2 = new NotificationAttributes(flags, sbn.getNotification().getSmallIcon(), sbn.getNotification().color, 0, 2, sbn.getNotification().getChannelId());
        this.mCallback.updateAutogroupSummary(sbn.getUserId(), sbn.getPackageName(), AUTOGROUP_KEY, updateAutobundledSummaryAttributes(sbn.getPackageName(), childrenAttr, attr2));
    L17:
        Iterator<String> r0 = notificationsToGroup.iterator();
    L19:
        if (r0.hasNext() == false) goto L25;
        String keyToGroup = r0.next();
        if (keyToGroup.equals(sbn.getKey()) == true) goto L22;
        this.mCallback.addAutoGroup(keyToGroup, AUTOGROUP_KEY, true);
        goto L19
    L22:
        sbnToBeAutogrouped = true;
        goto L19
    L16:
        sbn.getNotification().getSmallIcon();
        int r2 = sbn.getNotification().color;
        sbn.getNotification().getChannelId();
        NotificationAttributes iconAttr = getAutobundledSummaryAttributes(sbn.getPackageName(), childrenAttr);
        Icon summaryIcon = iconAttr.icon;
        int summaryIconColor = iconAttr.iconColor;
        int summaryVisibility = iconAttr.visibility;
        String summaryChannelId = iconAttr.channelId;
        NotificationAttributes attr3 = new NotificationAttributes(flags, summaryIcon, summaryIconColor, summaryVisibility, 2, summaryChannelId);
        this.mCallback.addAutoGroupSummary(sbn.getUserId(), sbn.getPackageName(), sbn.getKey(), AUTOGROUP_KEY, Integer.MAX_VALUE, attr3);
    L25:
        return sbnToBeAutogrouped;
    L26:
        th = th;
    L29:
        monitor-exit(r6);     // Catch: Throwable -> L28
    L28:
        th = th;
        goto L29
    L30:
        throw th;
    L9:
        int flags2 = getAutogroupSummaryFlags(children);     // Catch: Throwable -> L28
        notificationsToGroup.addAll(children.keySet());     // Catch: Throwable -> L28
        childrenAttr.addAll(children.values());     // Catch: Throwable -> L28
        flags = flags2;
        goto L31
    L35:
        th = th;
        goto L29
    }

    private void maybeUngroup(StatusBarNotification sbn, boolean notificationGone, int userId) {
        boolean removeSummary = false;
        int summaryFlags = -1;
        boolean updateSummaryFlags = false;
        boolean removeAutogroupOverlay = false;
        List<NotificationAttributes> childrenAttrs = new ArrayList();
        ArrayMap<String, ArrayMap<String, NotificationAttributes>> r8 = this.mUngroupedNotifications;
        monitor-enter(r8);
        String key = generatePackageKey(sbn.getUserId(), sbn.getPackageName());     // Catch: Throwable -> L8
        ArrayMap<String, NotificationAttributes> children = this.mUngroupedNotifications.getOrDefault(key, new ArrayMap());     // Catch: Throwable -> L8
        if (children.size() != 0) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L11:
        if (children.containsKey(sbn.getKey()) == false) goto L24;
        int flags = children.remove(sbn.getKey()).flags;     // Catch: Throwable -> L8
        if (hasAnyFlag(flags, 34) == false) goto L15;
        updateSummaryFlags = true;
        summaryFlags = getAutogroupSummaryFlags(children);     // Catch: Throwable -> L8
    L15:
        if (notificationGone == true) goto L20;
        if (sbn.getOverrideGroupKey() == null) goto L20;
        removeAutogroupOverlay = true;
    L20:
        if (children.size() != 0) goto L22;
        removeSummary = true;
        int flags2 = summaryFlags;
    L41:
        monitor-exit(r8);     // Catch: Throwable -> L37
        if (removeSummary == false) goto L28;
        this.mCallback.removeAutoGroupSummary(userId, sbn.getPackageName(), AUTOGROUP_KEY);
    L34:
        if (removeAutogroupOverlay == false) goto L44;
        this.mCallback.removeAutoGroup(sbn.getKey());
        return;
    L44:
        return;
    L28:
        NotificationAttributes attr = new NotificationAttributes(flags2, sbn.getNotification().getSmallIcon(), sbn.getNotification().color, 0, 2, sbn.getNotification().getChannelId());
        boolean attributesUpdated = false;
        NotificationAttributes newAttr = updateAutobundledSummaryAttributes(sbn.getPackageName(), childrenAttrs, attr);
        if (newAttr.equals(attr) == true) goto L31;
        attributesUpdated = true;
        attr = newAttr;
    L31:
        if (updateSummaryFlags == true) goto L33;
        if (attributesUpdated == false) goto L34;
    L33:
        this.mCallback.updateAutogroupSummary(userId, sbn.getPackageName(), AUTOGROUP_KEY, attr);
    L37:
        th = th;
    L39:
        monitor-exit(r8);     // Catch: Throwable -> L8
        throw th;
    L22:
        childrenAttrs.addAll(children.values());     // Catch: Throwable -> L8
        flags2 = summaryFlags;
        goto L41
    L24:
        flags2 = -1;
    L8:
        th = th;
        goto L39
    }

    NotificationAttributes getAutobundledSummaryAttributes(String packageName, List<NotificationAttributes> childrenAttr) {
        Icon newIcon = null;
        boolean childrenHaveSameIcon = true;
        int newColor = 1;
        boolean childrenHaveSameColor = true;
        Iterator<NotificationAttributes> r5 = childrenAttr.iterator();
        int newVisibility = 0;
    L4:
        if (r5.hasNext() == false) goto L20;
        NotificationAttributes state = r5.next();
        if (newIcon != null) goto L9;
        newIcon = state.icon;
    L11:
        if (newColor != 1) goto L14;
        newColor = state.iconColor;
    L17:
        if (state.visibility != 1) goto L4;
        newVisibility = 1;
        goto L4
    L14:
        if (newColor == state.iconColor) goto L17;
        childrenHaveSameColor = false;
        goto L17
    L9:
        if (newIcon.sameAs(state.icon) == true) goto L11;
        childrenHaveSameIcon = false;
        goto L11
    L20:
        if (childrenHaveSameIcon == true) goto L22;
        Icon newIcon2 = getMonochromeAppIcon(packageName);
        Icon newIcon3 = newIcon2;
    L23:
        if (childrenHaveSameColor == true) goto L25;
        int newColor2 = 0;
    L26:
        Iterator<NotificationAttributes> r2 = childrenAttr.iterator();
    L28:
        if (r2.hasNext() == false) goto L33;
        NotificationAttributes attr = r2.next();
        if (attr.groupAlertBehavior == 1) goto L28;
        int newGroupAlertBehavior = 2;
    L35:
        if (childrenAttr.isEmpty() == true) goto L38;
        String r0 = childrenAttr.get(0).channelId;
    L37:
        String channelId = r0;
        return new NotificationAttributes(0, newIcon3, newColor2, newVisibility, newGroupAlertBehavior, channelId);
    L38:
        r0 = null;
        goto L37
    L33:
        newGroupAlertBehavior = 1;
        goto L35
    L25:
        newColor2 = newColor;
        goto L26
    L22:
        newIcon3 = newIcon;
        goto L23
    }

    NotificationAttributes updateAutobundledSummaryAttributes(String packageName, List<NotificationAttributes> childrenAttr, NotificationAttributes oldAttr) {
        NotificationAttributes newAttr = getAutobundledSummaryAttributes(packageName, childrenAttr);
        Icon newIcon = newAttr.icon;
        int newColor = newAttr.iconColor;
        String newChannelId = newAttr.channelId;
        if (newAttr.icon != null) goto L5;
        Icon newIcon2 = oldAttr.icon;
        Icon newIcon3 = newIcon2;
    L7:
        if (newAttr.iconColor != 1) goto L9;
        int newColor2 = oldAttr.iconColor;
        int newColor3 = newColor2;
    L11:
        if (newAttr.channelId != null) goto L13;
        String newChannelId2 = oldAttr.channelId;
        String newChannelId3 = newChannelId2;
    L15:
        return new NotificationAttributes(oldAttr.flags, newIcon3, newColor3, newAttr.visibility, oldAttr.groupAlertBehavior, newChannelId3);
    L13:
        newChannelId3 = newChannelId;
        goto L15
    L9:
        newColor3 = newColor;
        goto L11
    L5:
        newIcon3 = newIcon;
        goto L7
    }

    private NotificationAttributes getSummaryAttributes(String pkgName, ArrayMap<String, NotificationAttributes> childrenMap) {
        int flags = getAutogroupSummaryFlags(childrenMap);
        NotificationAttributes attr = getAutobundledSummaryAttributes(pkgName, childrenMap.values().stream().toList());
        return new NotificationAttributes(flags, attr.icon, attr.iconColor, attr.visibility, attr.groupAlertBehavior, attr.channelId);
    }

    Icon getMonochromeAppIcon(String pkg) {
        Icon monochromeIcon = null;
        Drawable appIcon = this.mPackageManager.getApplicationIcon(pkg);     // Catch: PackageManager.NameNotFoundException -> L9
        if ((appIcon instanceof AdaptiveIconDrawable) == true) goto L6;
    L13:
        if (monochromeIcon == null) goto L16;
        return monochromeIcon;
    L16:
        return Icon.createWithResource(this.mContext, R.drawable.pointer_vertical_double_arrow_vector_icon);
    L6:
        if (((AdaptiveIconDrawable) appIcon).getMonochrome() == null) goto L13;
        monochromeIcon = Icon.createWithResourceAdaptiveDrawable(pkg, ((AdaptiveIconDrawable) appIcon).getSourceDrawableResId(), true, AdaptiveIconDrawable.getExtraInsetFraction() * (-2.0f));     // Catch: PackageManager.NameNotFoundException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to getApplicationIcon() in getMonochromeAppIcon()", e);
        goto L13
    }

    private boolean maybeGroupWithSections(NotificationRecord record, boolean autogroupSummaryExists) {
        StatusBarNotification sbn = record.getSbn();
        boolean sbnToBeAutogrouped = false;
        NotificationSectioner sectioner = getSection(record);
        if (sectioner != null) goto L8;
        maybeUngroupOnNonGroupableUpdate(record);
        if (DEBUG == false) goto L7;
        Slog.i(TAG, "Skipping autogrouping for " + record + " no valid section found.");
    L7:
        return false;
    L8:
        String pkgName = sbn.getPackageName();
        FullyQualifiedGroupKey fullAggregateGroupKey = new FullyQualifiedGroupKey(record.getUserId(), pkgName, sectioner);
        FullyQualifiedGroupKey prevSectionKey = getPreviousValidSectionKey(record);
        if (prevSectionKey == null) goto L17;
        if (fullAggregateGroupKey.equals(prevSectionKey) == true) goto L17;
        if (DEBUG == false) goto L15;
        Slog.i(TAG, "Section changed for: " + record);
    L15:
        maybeUngroupOnSectionChanged(record, prevSectionKey);
    L17:
        if (record.getGroupKey().equals(fullAggregateGroupKey.toString()) == false) goto L19;
        return false;
    L19:
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r10 = this.mAggregatedNotifications;
        monitor-enter(r10);
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L29
        ungrouped.put(record.getKey(), new NotificationAttributes(record.getFlags(), record.getNotification().getSmallIcon(), record.getNotification().color, record.getNotification().visibility, record.getNotification().getGroupAlertBehavior(), record.getChannel().getId()));     // Catch: Throwable -> L29
        this.mUngroupedAbuseNotifications.put(fullAggregateGroupKey, ungrouped);     // Catch: Throwable -> L29
        if (ungrouped.size() >= this.mAutoGroupAtCount) goto L25;
        if (autogroupSummaryExists == true) goto L25;
    L41:
        monitor-exit(r10);     // Catch: Throwable -> L29
        return sbnToBeAutogrouped;
    L25:
        if (DEBUG == true) goto L27;
    L32:
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L29
        aggregatedNotificationsAttrs.putAll(ungrouped);     // Catch: Throwable -> L29
        this.mAggregatedNotifications.put(fullAggregateGroupKey, aggregatedNotificationsAttrs);     // Catch: Throwable -> L29
        updateAggregateAppGroup(fullAggregateGroupKey, record.getKey(), autogroupSummaryExists, sectioner.mSummaryId);     // Catch: Throwable -> L29
        Iterator<String> r11 = ungrouped.keySet().iterator();     // Catch: Throwable -> L29
    L34:
        if (r11.hasNext() == false) goto L40;
        String keyToGroup = r11.next();     // Catch: Throwable -> L29
        if (keyToGroup.equals(record.getKey()) == false) goto L38;
        sbnToBeAutogrouped = true;
        goto L34
    L38:
        this.mCallback.addAutoGroup(keyToGroup, fullAggregateGroupKey.toString(), true);     // Catch: Throwable -> L29
        goto L34
    L40:
        this.mUngroupedAbuseNotifications.remove(fullAggregateGroupKey);     // Catch: Throwable -> L29
        goto L41
    L27:
        if (ungrouped.size() < this.mAutoGroupAtCount) goto L31;
        Slog.i(TAG, "Found >=" + this.mAutoGroupAtCount + " ungrouped notifications => force grouping");     // Catch: Throwable -> L29
        goto L32
    L31:
        Slog.i(TAG, "Found aggregate summary => force grouping");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    private void maybeUngroupOnNonGroupableUpdate(NotificationRecord record) {
        maybeUngroupWithSections(record, getPreviousValidSectionKey(record));
    }

    private void maybeUngroupOnSectionChanged(NotificationRecord record, FullyQualifiedGroupKey prevSectionKey) {
        maybeUngroupWithSections(record, prevSectionKey);
        if (record.getGroupKey().equals(prevSectionKey.toString()) == false) goto L6;
        record.setOverrideGroupKey(null);
        return;
    }

    private void maybeUngroupOnAppGrouped(NotificationRecord record) {
        FullyQualifiedGroupKey currentSectionKey = getSectionGroupKeyWithFallback(record);
        FullyQualifiedGroupKey prevSectionKey = getPreviousValidSectionKey(record);
        if (prevSectionKey != null) goto L5;
    L10:
        maybeUngroupWithSections(record, currentSectionKey);
        return;
    L5:
        if (prevSectionKey.equals(currentSectionKey) == true) goto L10;
        if (DEBUG == false) goto L9;
        Slog.i(TAG, "Section changed for: " + record);
    L9:
        currentSectionKey = prevSectionKey;
        goto L10
    }

    private void maybeUngroupWithSections(NotificationRecord record, FullyQualifiedGroupKey fullAggregateGroupKey) {
        if (fullAggregateGroupKey == null) goto L4;
        StatusBarNotification sbn = record.getSbn();
        String pkgName = sbn.getPackageName();
        int userId = record.getUserId();
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r3 = this.mAggregatedNotifications;
        monitor-enter(r3);
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L14
        ungrouped.remove(sbn.getKey());     // Catch: Throwable -> L14
        this.mUngroupedAbuseNotifications.put(fullAggregateGroupKey, ungrouped);     // Catch: Throwable -> L14
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L14
        if (aggregatedNotificationsAttrs.containsKey(record.getKey()) == false) goto L26;
        aggregatedNotificationsAttrs.remove(sbn.getKey());     // Catch: Throwable -> L14
        this.mAggregatedNotifications.put(fullAggregateGroupKey, aggregatedNotificationsAttrs);     // Catch: Throwable -> L14
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "maybeUngroup removeAutoGroup: " + record);     // Catch: Throwable -> L14
    L16:
        this.mCallback.removeAutoGroup(sbn.getKey());     // Catch: Throwable -> L14
        if (aggregatedNotificationsAttrs.isEmpty() == false) goto L23;
        if (DEBUG == false) goto L21;
        Slog.i(TAG, "Aggregate group is empty: " + fullAggregateGroupKey);     // Catch: Throwable -> L14
    L21:
        this.mCallback.removeAutoGroupSummary(userId, pkgName, fullAggregateGroupKey.toString());     // Catch: Throwable -> L14
        this.mAggregatedNotifications.remove(fullAggregateGroupKey);     // Catch: Throwable -> L14
        goto L26
    L23:
        if (DEBUG == false) goto L25;
        Slog.i(TAG, "Aggregate group not empty, updating: " + fullAggregateGroupKey);     // Catch: Throwable -> L14
    L25:
        updateAggregateAppGroup(fullAggregateGroupKey, sbn.getKey(), true, 0);     // Catch: Throwable -> L14
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L4:
        if (DEBUG == false) goto L32;
        Slog.i(TAG, "Skipping maybeUngroupWithSections for " + record + " no valid section found.");
        return;
    }

    protected void onNotificationPostedWithDelay(NotificationRecord record, List<NotificationRecord> notificationList, Map<String, NotificationRecord> summaryByGroupKey) {
        StatusBarNotification sbn = record.getSbn();
        if (sbn.isAppGroup() == true) goto L6;
        return;
    L6:
        if (record.isCanceled == false) goto L9;
        return;
    L9:
        if (this.mIsTestHarnessExempted == false) goto L11;
        return;
    L11:
        NotificationSectioner sectioner = getSection(record);
        if (sectioner == null) goto L14;
        String pkgName = sbn.getPackageName();
        FullyQualifiedGroupKey fullAggregateGroupKey = new FullyQualifiedGroupKey(record.getUserId(), pkgName, sectioner);
        if (record.getGroupKey().equals(fullAggregateGroupKey.toString()) == false) goto L20;
        return;
    L20:
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r9 = this.mAggregatedNotifications;
        monitor-enter(r9);
    L35:
        th = move-exception;
        Throwable r11 = th;
    L52:
        monitor-exit(r9);     // Catch: Throwable -> L35
        throw r11;
    L37:
        th = move-exception;
        r11 = th;
        goto L52
    L23:
        if (isGroupChildWithoutSummary(record, summaryByGroupKey) == true) goto L41;
        if (isGroupSummaryWithoutChildren(record, notificationList) == true) goto L41;
        groupSparseGroups(record, notificationList, summaryByGroupKey, sectioner, fullAggregateGroupKey);     // Catch: Throwable -> L30
    L33:
        monitor-exit(r9);     // Catch: Throwable -> L35
        return;
    L30:
        e = move-exception;
        Slog.wtf(TAG, "Failed to group sparse groups", e);     // Catch: Throwable -> L35
    L41:
        if (DEBUG == false) goto L44;
        Log.i(TAG, "isGroupChildWithoutSummary OR isGroupSummaryWithoutChild" + record);     // Catch: Throwable -> L35
    L44:
        if (isGroupChildWithoutSummary(record, summaryByGroupKey) == true) goto L46;
    L49:
        addToUngroupedAndMaybeAggregate(record, fullAggregateGroupKey, sectioner);     // Catch: Throwable -> L35
        monitor-exit(r9);     // Catch: Throwable -> L35
        return;
    L46:
        if (NUBIA_PUSH_CLIENT_PACKAGE.equals(sbn.getOpPkg()) == false) goto L49;
        monitor-exit(r9);     // Catch: Throwable -> L35
        return;
    L14:
        if (DEBUG == false) goto L58;
        Log.i(TAG, "Skipping autogrouping for " + record + " no valid section found.");
        return;
    }

    private void addToUngroupedAndMaybeAggregate(NotificationRecord record, FullyQualifiedGroupKey fullAggregateGroupKey, NotificationSectioner sectioner) {
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());
        ungrouped.put(record.getKey(), new NotificationAttributes(record.getFlags(), record.getNotification().getSmallIcon(), record.getNotification().color, record.getNotification().visibility, record.getNotification().getGroupAlertBehavior(), record.getChannel().getId()));
        this.mUngroupedAbuseNotifications.put(fullAggregateGroupKey, ungrouped);
        boolean hasSummary = !this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap()).isEmpty();
        if (ungrouped.size() >= this.mAutoGroupAtCount) goto L8;
        if (hasSummary == true) goto L8;
        return;
    L8:
        if (DEBUG == true) goto L10;
    L13:
        aggregateUngroupedNotifications(fullAggregateGroupKey, record.getKey(), ungrouped, hasSummary, sectioner.mSummaryId);
        return;
    L10:
        if (ungrouped.size() < this.mAutoGroupAtCount) goto L12;
        Slog.i(TAG, "Found >=" + this.mAutoGroupAtCount + " ungrouped notifications => force grouping");
        goto L13
    L12:
        Slog.i(TAG, "Found aggregate summary => force grouping");
        goto L13
    }

    private static boolean isGroupChildBundled(NotificationRecord record, Map<String, NotificationRecord> summaryByGroupKey) {
        StatusBarNotification sbn = record.getSbn();
        String groupKey = record.getSbn().getGroupKey();
        if (sbn.isAppGroup() == true) goto L6;
        return false;
    L6:
        if (record.getNotification().isGroupSummary() == false) goto L8;
        return false;
    L8:
        NotificationRecord summary = summaryByGroupKey.get(groupKey);
        if (summary != null) goto L12;
        return false;
    L12:
        return isInBundleSection(record);
    }

    private static boolean isInBundleSection(NotificationRecord record) {
        NotificationSectioner sectioner = getSection(record);
        if (sectioner != null) goto L5;
    L7:
        return false;
    L5:
        if (NOTIFICATION_BUNDLE_SECTIONS.contains(sectioner) == false) goto L7;
        return true;
    }

    protected void onNotificationRemoved(NotificationRecord record, List<NotificationRecord> notificationList, boolean sendingDelete) {
        StatusBarNotification sbn = record.getSbn();
        String pkgName = sbn.getPackageName();
        int userId = record.getUserId();
        FullyQualifiedGroupKey fullAggregateGroupKey = getSectionGroupKeyWithFallback(record);
        if (fullAggregateGroupKey == null) goto L5;
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r9 = this.mAggregatedNotifications;
        monitor-enter(r9);
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L36
        ungrouped.remove(record.getKey());     // Catch: Throwable -> L36
        this.mUngroupedAbuseNotifications.put(fullAggregateGroupKey, ungrouped);     // Catch: Throwable -> L36
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L36
        if (record.getGroupKey().equals(fullAggregateGroupKey.toString()) == false) goto L45;
    L18:
        aggregatedNotificationsAttrs.remove(record.getKey());     // Catch: Throwable -> L36
        this.mAggregatedNotifications.put(fullAggregateGroupKey, aggregatedNotificationsAttrs);     // Catch: Throwable -> L36
        if (aggregatedNotificationsAttrs.isEmpty() == false) goto L26;
        if (DEBUG == false) goto L23;
        Slog.i(TAG, "Aggregate group is empty: " + fullAggregateGroupKey);     // Catch: Throwable -> L16
    L23:
        this.mCallback.removeAutoGroupSummary(userId, pkgName, fullAggregateGroupKey.toString());     // Catch: Throwable -> L16
        this.mAggregatedNotifications.remove(fullAggregateGroupKey);     // Catch: Throwable -> L16
    L30:
        if (record.isCanceled == false) goto L39;
        maybeClearCanceledSummariesCache(pkgName, userId, record.getNotification().getGroup(), notificationList, sendingDelete);     // Catch: Throwable -> L34
    L39:
        monitor-exit(r9);     // Catch: Throwable -> L34
        return;
    L26:
        if (DEBUG == false) goto L28;
        Slog.i(TAG, "Aggregate group not empty, updating: " + fullAggregateGroupKey);     // Catch: Throwable -> L16
    L28:
        updateAggregateAppGroup(fullAggregateGroupKey, sbn.getKey(), true, 0);     // Catch: Throwable -> L36
        goto L30
    L45:
    L16:
        th = th;
    L41:
        monitor-exit(r9);     // Catch: Throwable -> L34
        throw th;
    L13:
        if (aggregatedNotificationsAttrs.containsKey(record.getKey()) == false) goto L39;
    L34:
        th = th;
    L36:
        th = th;
        goto L41
    L5:
        if (DEBUG == false) goto L46;
        Slog.i(TAG, "Skipping autogroup cleanup for " + record + " no valid section found.");
        return;
    }

    private FullyQualifiedGroupKey getSectionGroupKeyWithFallback(NotificationRecord record) {
        NotificationSectioner sectioner = getSection(record);
        if (sectioner == null) goto L7;
        return FullyQualifiedGroupKey.forRecord(record, sectioner);
    L7:
        return getPreviousValidSectionKey(record);
    }

    private FullyQualifiedGroupKey getPreviousValidSectionKey(NotificationRecord record) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
        String recordKey = record.getKey();     // Catch: Throwable -> L12
        Iterator<Map.Entry<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>>> r2 = this.mUngroupedAbuseNotifications.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L15;
        Map.Entry<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> ungroupedSection = r2.next();     // Catch: Throwable -> L12
        if (ungroupedSection.getValue().containsKey(recordKey) == false) goto L6;
        FullyQualifiedGroupKey r3 = ungroupedSection.getKey();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L15:
        Iterator<Map.Entry<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>>> r4 = this.mAggregatedNotifications.entrySet().iterator();     // Catch: Throwable -> L12
    L17:
        if (r4.hasNext() == false) goto L24;
        Map.Entry<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> aggregatedSection = r4.next();     // Catch: Throwable -> L12
        if (aggregatedSection.getValue().containsKey(recordKey) == false) goto L17;
        FullyQualifiedGroupKey r5 = aggregatedSection.getKey();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r5;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    protected void onGroupedNotificationRemovedWithDelay(NotificationRecord summaryRecord, List<NotificationRecord> notificationList, Map<String, NotificationRecord> summaryByGroupKey) {
        StatusBarNotification sbn = summaryRecord.getSbn();
        if (sbn.isAppGroup() == true) goto L6;
        return;
    L6:
        if (summaryRecord.isCanceled == false) goto L9;
        return;
    L9:
        if (this.mIsTestHarnessExempted == false) goto L11;
        return;
    L11:
        NotificationSectioner sectioner = getSection(summaryRecord);
        if (sectioner == null) goto L14;
        String pkgName = sbn.getPackageName();
        FullyQualifiedGroupKey fullAggregateGroupKey = new FullyQualifiedGroupKey(summaryRecord.getUserId(), pkgName, sectioner);
        if (summaryRecord.getGroupKey().equals(fullAggregateGroupKey.toString()) == false) goto L20;
        return;
    L20:
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r9 = this.mAggregatedNotifications;
        monitor-enter(r9);
        if (isGroupSummaryWithoutChildren(summaryRecord, notificationList) == false) goto L50;
    L27:
        th = th;
    L44:
        monitor-exit(r9);     // Catch: Throwable -> L40
        throw th;
    L25:
        if (DEBUG == false) goto L29;
        Slog.i(TAG, "isGroupSummaryWithoutChild " + summaryRecord);     // Catch: Throwable -> L27
    L29:
        addToUngroupedAndMaybeAggregate(summaryRecord, fullAggregateGroupKey, sectioner);     // Catch: Throwable -> L27
        monitor-exit(r9);     // Catch: Throwable -> L27
        return;
    L50:
        groupSparseGroups(summaryRecord, notificationList, summaryByGroupKey, sectioner, fullAggregateGroupKey);     // Catch: Throwable -> L35
    L38:
        monitor-exit(r9);     // Catch: Throwable -> L40
        return;
    L35:
        e = move-exception;
        Slog.wtf(TAG, "Failed to group sparse groups", e);     // Catch: Throwable -> L40
    L40:
        th = th;
    L42:
        th = th;
        goto L44
    L14:
        if (DEBUG == false) goto L52;
        Slog.i(TAG, "Skipping autogrouping for " + summaryRecord + " no valid section found.");
        return;
    }

    protected void onGroupSummaryAdded(NotificationRecord summaryRecord, List<NotificationRecord> notificationList) {
        String groupKey = summaryRecord.getSbn().getGroup();
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r1 = this.mAggregatedNotifications;
        monitor-enter(r1);
        NotificationSectioner sectioner = getSection(summaryRecord);     // Catch: Throwable -> L9
        if (sectioner != null) goto L11;
        Slog.w(TAG, "onGroupSummaryAdded " + summaryRecord + ": no valid section found");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        FullyQualifiedGroupKey aggregateGroupKey = FullyQualifiedGroupKey.forRecord(summaryRecord, sectioner);     // Catch: Throwable -> L9
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(aggregateGroupKey, new ArrayMap());     // Catch: Throwable -> L9
        if (ungrouped.isEmpty() == false) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L15:
        Iterator<NotificationRecord> r5 = notificationList.iterator();     // Catch: Throwable -> L9
    L17:
        if (r5.hasNext() == false) goto L26;
        NotificationRecord r = r5.next();     // Catch: Throwable -> L9
        if (r.getNotification().isGroupSummary() == true) goto L17;
        if (groupKey.equals(r.getSbn().getGroup()) == false) goto L17;
        if (ungrouped.containsKey(r.getKey()) == false) goto L17;
        ungrouped.remove(r.getKey());     // Catch: Throwable -> L9
        goto L17
    L26:
        this.mUngroupedAbuseNotifications.put(aggregateGroupKey, ungrouped);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void onChannelUpdated(int userId, String pkgName, NotificationChannel channel, List<NotificationRecord> notificationList, ArrayMap<String, NotificationRecord> summaryByGroupKey) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
        ArrayMap<String, Integer> regroupingReasonMap = new ArrayMap();     // Catch: Throwable -> L14
        ArrayMap<String, NotificationRecord> notificationsToCheck = new ArrayMap();     // Catch: Throwable -> L14
        Iterator<NotificationRecord> r3 = notificationList.iterator();     // Catch: Throwable -> L14
    L6:
        if (r3.hasNext() == false) goto L17;
        NotificationRecord r = r3.next();     // Catch: Throwable -> L14
        if (r.getChannel().getId().equals(channel.getId()) == false) goto L6;
        if (r.getSbn().getPackageName().equals(pkgName) == false) goto L6;
        if (r.getUserId() != userId) goto L6;
        notificationsToCheck.put(r.getKey(), r);     // Catch: Throwable -> L14
        regroupingReasonMap.put(r.getKey(), 0);     // Catch: Throwable -> L14
        goto L6
    L17:
        regroupNotifications(userId, pkgName, notificationsToCheck, regroupingReasonMap);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void onChannelUpdated(NotificationRecord record) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
        ArrayMap<String, NotificationRecord> notificationsToCheck = new ArrayMap();     // Catch: Throwable -> L7
        notificationsToCheck.put(record.getKey(), record);     // Catch: Throwable -> L7
        ArrayMap<String, Integer> regroupReasons = new ArrayMap();     // Catch: Throwable -> L7
        regroupReasons.put(record.getKey(), 1);     // Catch: Throwable -> L7
        regroupNotifications(record.getUserId(), record.getSbn().getPackageName(), notificationsToCheck, regroupReasons);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onNotificationUnbundled(NotificationRecord record, boolean originalSummaryExists) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
        ArrayMap<String, NotificationRecord> notificationsToCheck = new ArrayMap();     // Catch: Throwable -> L11
        notificationsToCheck.put(record.getKey(), record);     // Catch: Throwable -> L11
        int r2 = record.getUserId();     // Catch: Throwable -> L11
        String r3 = record.getSbn().getPackageName();     // Catch: Throwable -> L11
        String r4 = record.getKey();     // Catch: Throwable -> L11
        if (originalSummaryExists == false) goto L7;
        int r5 = 3;
    L8:
        regroupNotifications(r2, r3, notificationsToCheck, Map.of(r4, Integer.valueOf(r5)));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r5 = 2;
    L11:
        th = move-exception;
        throw th;
    }

    private void regroupNotifications(int userId, String pkgName, ArrayMap<String, NotificationRecord> notificationsToCheck, Map<String, Integer> regroupReasons) {
        ArrayList<NotificationMoveOp> notificationsToMove = new ArrayList();
        notificationsToMove.addAll(getAutogroupedNotificationsMoveOps(userId, pkgName, notificationsToCheck));
        notificationsToMove.addAll(getUngroupedNotificationsMoveOps(userId, pkgName, notificationsToCheck));
        if (notificationsToMove.isEmpty() == true) goto L6;
        moveNotificationsToNewSection(userId, pkgName, notificationsToMove, regroupReasons);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<NotificationMoveOp> getReclassifiedNotificationsMoveOps(int r8, String r9, ArrayMap<String, NotificationRecord> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<NotificationRecord> r1 = r10.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        NotificationRecord r2 = r1.next();
        if (isChildOfValidAppGroup(r2) == false) goto L4;
        NotificationSectioner r3 = getSection(r2);
        if (r3 == null) goto L4;
        if (NOTIFICATION_BUNDLE_SECTIONS.contains(r3) == false) goto L4;
        FullyQualifiedGroupKey r4 = new FullyQualifiedGroupKey(r8, r9, r3);
        if (DEBUG == false) goto L14;
        Slog.v(TAG, "Regroup after classification: " + r2 + " to: " + r4);
    L14:
        r0.add(new NotificationMoveOp(r2, null, r4, 0 == true ? 1 : 0));
        goto L4
    L16:
        return r0;
    }

    public static boolean isOriginalGroupSummaryPresent(NotificationRecord r, ArrayMap<String, NotificationRecord> summaryByGroupKey) {
        if (r.getSbn().isAppGroup() == true) goto L5;
    L12:
        return false;
    L5:
        if (r.getNotification().isGroupChild() == false) goto L12;
        String oldGroupKey = getFullAggregateGroupKey(r.getSbn().getPackageName(), r.getOriginalGroupKey(), r.getUserId());
        NotificationRecord groupSummary = summaryByGroupKey.get(oldGroupKey);
        if (groupSummary != null) goto L9;
        return false;
    L9:
        if (isAggregatedGroup(groupSummary) == true) goto L14;
        return true;
    L14:
        return false;
    }

    private List<NotificationMoveOp> getAutogroupedNotificationsMoveOps(int userId, String pkgName, ArrayMap<String, NotificationRecord> notificationsToCheck) {
        ArrayList<NotificationMoveOp> notificationsToMove = new ArrayList();
        Set<FullyQualifiedGroupKey> oldGroups = new HashSet(this.mAggregatedNotifications.keySet());
        Iterator<FullyQualifiedGroupKey> r2 = oldGroups.iterator();
    L4:
        if (r2.hasNext() == false) goto L29;
        FullyQualifiedGroupKey oldFullAggKey = r2.next();
        if (pkgName.equals(FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(oldFullAggKey)) == false) goto L4;
        if (userId != FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(oldFullAggKey)) goto L4;
        ArrayMap<String, NotificationAttributes> notificationsInAggGroup = this.mAggregatedNotifications.get(oldFullAggKey);
        if (notificationsInAggGroup == null) goto L4;
        Iterator<String> r6 = notificationsInAggGroup.keySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L4;
        String key = r6.next();
        if (notificationsToCheck.get(key) == null) goto L14;
        NotificationSectioner sectioner = getSection(notificationsToCheck.get(key));
        if (sectioner == null) goto L14;
        FullyQualifiedGroupKey newFullAggregateGroupKey = new FullyQualifiedGroupKey(userId, pkgName, sectioner);
        if (oldFullAggKey.equals(newFullAggregateGroupKey) == true) goto L14;
        if (DEBUG == false) goto L25;
        Log.i(TAG, "Change section on channel update: " + key);
    L25:
        notificationsToMove.add(new NotificationMoveOp(notificationsToCheck.get(key), oldFullAggKey, newFullAggregateGroupKey, null));
        notificationsToCheck.remove(key);
        goto L14
    L29:
        return notificationsToMove;
    }

    private List<NotificationMoveOp> getUngroupedNotificationsMoveOps(int userId, String pkgName, ArrayMap<String, NotificationRecord> notificationsToCheck) {
        int r1 = userId;
        ArrayList<NotificationMoveOp> notificationsToMove = new ArrayList();
        if (notificationsToCheck.isEmpty() == true) goto L32;
        Set<FullyQualifiedGroupKey> oldUngroupedSectionKeys = new HashSet(this.mUngroupedAbuseNotifications.keySet());
        Iterator<FullyQualifiedGroupKey> r6 = oldUngroupedSectionKeys.iterator();
    L6:
        if (r6.hasNext() == false) goto L32;
        FullyQualifiedGroupKey oldFullAggKey = r6.next();
        if (pkgName.equals(FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(oldFullAggKey)) == false) goto L31;
        if (r1 != FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(oldFullAggKey)) goto L31;
        ArrayMap<String, NotificationAttributes> ungroupedOld = this.mUngroupedAbuseNotifications.get(oldFullAggKey);
        if (ungroupedOld == null) goto L6;
        Set<String> ungroupedKeys = new HashSet(ungroupedOld.keySet());
        Iterator<String> r11 = ungroupedKeys.iterator();
    L16:
        if (r11.hasNext() == false) goto L30;
        String key = r11.next();
        NotificationRecord record = notificationsToCheck.get(key);
        if (record == null) goto L29;
        NotificationSectioner sectioner = getSection(record);
        if (sectioner == null) goto L16;
        FullyQualifiedGroupKey newFullAggregateGroupKey = new FullyQualifiedGroupKey(r1, pkgName, sectioner);
        if (oldFullAggKey.equals(newFullAggregateGroupKey) == true) goto L29;
        if (DEBUG == false) goto L27;
        Log.i(TAG, "Change ungrouped section: " + key);
    L27:
        notificationsToMove.add(new NotificationMoveOp(record, oldFullAggKey, newFullAggregateGroupKey, null));
        notificationsToCheck.remove(key);
        ungroupedOld.remove(key);
    L29:
        r1 = userId;
        goto L16
    L30:
        this.mUngroupedAbuseNotifications.put(oldFullAggKey, ungroupedOld);
    L31:
        r1 = userId;
    L32:
        return notificationsToMove;
    }

    private void moveNotificationsToNewSection(int userId, String pkgName, List<NotificationMoveOp> notificationsToMove, Map<String, Integer> regroupReasons) {
        GroupHelper r0 = this;
        ArrayMap r1 = new ArrayMap();
        new ArrayMap();
        Iterator<NotificationMoveOp> r2 = notificationsToMove.iterator();
    L4:
        if (r2.hasNext() == false) goto L22;
        NotificationMoveOp moveOp = r2.next();
        final NotificationRecord record = NotificationMoveOp.m6065$$Nest$fgetrecord(moveOp);
        final FullyQualifiedGroupKey oldFullAggregateGroupKey = NotificationMoveOp.m6064$$Nest$fgetoldGroup(moveOp);
        final FullyQualifiedGroupKey newFullAggregateGroupKey = NotificationMoveOp.m6063$$Nest$fgetnewGroup(moveOp);
        if (DEBUG == false) goto L9;
        Log.i(TAG, "moveNotificationToNewSection: " + record + " " + newFullAggregateGroupKey + " from: " + oldFullAggregateGroupKey + " regroupingReason: " + regroupReasons);
    L9:
        final boolean r8 = true;
        if (oldFullAggregateGroupKey == null) goto L16;
        ArrayMap<String, NotificationAttributes> oldAggregatedNotificationsAttrs = r0.mAggregatedNotifications.getOrDefault(oldFullAggregateGroupKey, new ArrayMap());
        oldAggregatedNotificationsAttrs.remove(record.getKey());
        r0.mAggregatedNotifications.put(oldFullAggregateGroupKey, oldAggregatedNotificationsAttrs);
        if (r1.containsKey(oldFullAggregateGroupKey) == true) goto L16;
        r1.put(oldFullAggregateGroupKey, new C1GroupUpdateOp(oldFullAggregateGroupKey, record, r8));
    L16:
        if (newFullAggregateGroupKey == null) goto L20;
        ArrayMap<String, NotificationAttributes> newAggregatedNotificationsAttrs = r0.mAggregatedNotifications.getOrDefault(newFullAggregateGroupKey, new ArrayMap());
        final boolean hasSummary = true ^ newAggregatedNotificationsAttrs.isEmpty();
        ArrayMap<String, NotificationAttributes> ungrouped = r0.mUngroupedAbuseNotifications.getOrDefault(newFullAggregateGroupKey, new ArrayMap());
        Iterator<NotificationMoveOp> r20 = r2;
        ungrouped.put(record.getKey(), new NotificationAttributes(record.getFlags(), record.getNotification().getSmallIcon(), record.getNotification().color, record.getNotification().visibility, record.getNotification().getGroupAlertBehavior(), record.getChannel().getId()));
        r0.mUngroupedAbuseNotifications.put(newFullAggregateGroupKey, ungrouped);
        record.setOverrideGroupKey(null);
        if (r1.containsKey(newFullAggregateGroupKey) == true) goto L21;
        r1.put(newFullAggregateGroupKey, new C1GroupUpdateOp(newFullAggregateGroupKey, record, hasSummary));
    L21:
        r2 = r20;
        goto L4
    L20:
        r20 = r2;
        goto L21
    L22:
        Iterator r9 = r1.keySet().iterator();
    L24:
        if (r9.hasNext() == false) goto L43;
        FullyQualifiedGroupKey groupKey = (FullyQualifiedGroupKey) r9.next();
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = r0.mAggregatedNotifications.getOrDefault(groupKey, new ArrayMap());
        ArrayMap<String, NotificationAttributes> ungrouped2 = r0.mUngroupedAbuseNotifications.getOrDefault(groupKey, new ArrayMap());
        NotificationRecord triggeringNotification = C1GroupUpdateOp.m6055$$Nest$fgetrecord((C1GroupUpdateOp) r1.get(groupKey));
        boolean hasSummary2 = C1GroupUpdateOp.m6054$$Nest$fgethasSummary((C1GroupUpdateOp) r1.get(groupKey));
        if (ungrouped2.size() >= r0.mAutoGroupAtCount) goto L37;
        if (hasSummary2 == false) goto L32;
        if (aggregatedNotificationsAttrs.isEmpty() == false) goto L37;
    L32:
        if (aggregatedNotificationsAttrs.isEmpty() == false) goto L41;
        if (hasSummary2 == false) goto L41;
        r0.mCallback.removeAutoGroupSummary(userId, pkgName, groupKey.toString());
        r0.mAggregatedNotifications.remove(groupKey);
    L41:
        r0 = this;
    L37:
        NotificationSectioner sectioner = getSection(triggeringNotification);
        if (sectioner == null) goto L24;
        r0.aggregateUngroupedNotifications(groupKey, triggeringNotification.getKey(), ungrouped2, hasSummary2, sectioner.mSummaryId);
        goto L41
    }

    static String getFullAggregateGroupKey(String pkgName, String groupName, int userId) {
        return new FullyQualifiedGroupKey(userId, pkgName, groupName).toString();
    }

    static String getFullAggregateGroupKey(NotificationRecord record) {
        return new FullyQualifiedGroupKey(record.getUserId(), record.getSbn().getPackageName(), getSection(record)).toString();
    }

    protected static boolean isAggregatedGroup(NotificationRecord record) {
        if ((record.mOriginalFlags & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isNotificationAggregatedInSection(NotificationRecord record, NotificationSectioner sectioner) {
        FullyQualifiedGroupKey fullAggregateGroupKey = FullyQualifiedGroupKey.forRecord(record, sectioner);
        return record.getGroupKey().equals(fullAggregateGroupKey.toString());
    }

    private boolean isChildOfValidAppGroup(NotificationRecord record) {
        StatusBarNotification sbn = record.getSbn();
        if (sbn.isAppGroup() == true) goto L6;
        return false;
    L6:
        if (sbn.getNotification().isGroupChild() == true) goto L9;
        return false;
    L9:
        if (record.isCanceled == false) goto L11;
        return false;
    L11:
        NotificationSectioner sectioner = getSection(record);
        if (sectioner != null) goto L18;
        if (DEBUG == false) goto L16;
        Slog.i(TAG, "Skipping autogrouping for " + record + " no valid section found.");
    L16:
        return false;
    L18:
        if (isNotificationAggregatedInSection(record, sectioner) == false) goto L20;
        return false;
    L20:
        return true;
    }

    private static int getNumChildrenForGroup(String groupKey, List<NotificationRecord> notificationList) {
        int numChildren = 0;
        Iterator<NotificationRecord> r1 = notificationList.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        NotificationRecord r = r1.next();
        if (r.getNotification().isGroupSummary() == true) goto L4;
        if (groupKey.equals(r.getSbn().getGroup()) == false) goto L4;
        numChildren = numChildren + 1;
        goto L4
    L12:
        if (DEBUG == false) goto L14;
        Log.i(TAG, "getNumChildrenForGroup " + groupKey + " numChild: " + numChildren);
    L14:
        return numChildren;
    }

    private static boolean isGroupSummaryWithoutChildren(NotificationRecord record, List<NotificationRecord> notificationList) {
        StatusBarNotification sbn = record.getSbn();
        String groupKey = record.getSbn().getGroup();
        if (sbn.isAppGroup() == true) goto L5;
    L11:
        return false;
    L5:
        if (record.getNotification().isGroupSummary() == false) goto L11;
        if (getNumChildrenForGroup(groupKey, notificationList) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isGroupChildWithoutSummary(NotificationRecord record, Map<String, NotificationRecord> summaryByGroupKey) {
        StatusBarNotification sbn = record.getSbn();
        String groupKey = record.getSbn().getGroupKey();
        if (sbn.isAppGroup() == true) goto L6;
        return false;
    L6:
        if (record.getNotification().isGroupSummary() == false) goto L9;
        return false;
    L9:
        if (summaryByGroupKey.containsKey(groupKey) == false) goto L11;
        return false;
    L11:
        return true;
    }

    private void aggregateUngroupedNotifications(FullyQualifiedGroupKey fullAggregateGroupKey, String triggeringNotifKey, Map<String, NotificationAttributes> ungrouped, boolean hasSummary, int summaryId) {
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());
        aggregatedNotificationsAttrs.putAll(ungrouped);
        this.mAggregatedNotifications.put(fullAggregateGroupKey, aggregatedNotificationsAttrs);
        updateAggregateAppGroup(fullAggregateGroupKey, triggeringNotifKey, hasSummary, summaryId);
        Iterator<String> r1 = ungrouped.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String key = r1.next();
        this.mCallback.addAutoGroup(key, fullAggregateGroupKey.toString(), true);
        goto L4
    L6:
        this.mUngroupedAbuseNotifications.remove(fullAggregateGroupKey);
    }

    private void updateAggregateAppGroup(FullyQualifiedGroupKey fullAggregateGroupKey, String triggeringNotifKey, boolean hasSummary, int summaryId) {
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());
        NotificationAttributes attr = getSummaryAttributes(FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(fullAggregateGroupKey), aggregatedNotificationsAttrs);
        if (hasSummary == false) goto L5;
        String r4 = attr.channelId;
        String r8 = triggeringNotifKey;
    L6:
        String channelId = r4;
        NotificationAttributes summaryAttr = new NotificationAttributes(attr.flags, attr.icon, attr.iconColor, attr.visibility, attr.groupAlertBehavior, channelId);
        if (hasSummary == true) goto L13;
        if (DEBUG == false) goto L11;
        Log.i(TAG, "Create aggregate summary: " + fullAggregateGroupKey);
    L11:
        this.mCallback.addAutoGroupSummary(FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(fullAggregateGroupKey), FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(fullAggregateGroupKey), r8, fullAggregateGroupKey.toString(), summaryId, summaryAttr);
        return;
    L13:
        if (DEBUG == false) goto L15;
        Log.i(TAG, "Update aggregate summary: " + fullAggregateGroupKey);
    L15:
        this.mCallback.updateAutogroupSummary(FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(fullAggregateGroupKey), FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(fullAggregateGroupKey), fullAggregateGroupKey.toString(), summaryAttr);
        return;
    L5:
        r8 = triggeringNotifKey;
        r4 = aggregatedNotificationsAttrs.get(r8).channelId;
        goto L6
    }

    private void groupSparseGroups(NotificationRecord record, List<NotificationRecord> notificationList, Map<String, NotificationRecord> summaryByGroupKey, NotificationSectioner sectioner, FullyQualifiedGroupKey fullAggregateGroupKey) {
        ArrayMap<String, NotificationRecord> sparseGroupSummaries = getSparseGroups(fullAggregateGroupKey, notificationList, summaryByGroupKey, sectioner);
        if (sparseGroupSummaries.size() >= this.mAutogroupSparseGroupsAtCount) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Log.i(TAG, "Aggregate sparse groups for: " + record.getSbn().getPackageName() + " Section: " + sectioner.mName);
    L7:
        ArrayMap<String, NotificationAttributes> ungrouped = this.mUngroupedAbuseNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());
        ArrayMap<String, NotificationAttributes> aggregatedNotificationsAttrs = this.mAggregatedNotifications.getOrDefault(fullAggregateGroupKey, new ArrayMap());
        boolean r10 = true;
        boolean hasSummary = !aggregatedNotificationsAttrs.isEmpty();
        String triggeringKey = null;
        if (record.getNotification().isGroupSummary() == true) goto L10;
        triggeringKey = record.getKey();
    L10:
        Iterator<NotificationRecord> r12 = notificationList.iterator();
    L12:
        if (r12.hasNext() == false) goto L39;
        NotificationRecord r = r12.next();
        if (sparseGroupSummaries.containsKey(r.getGroupKey()) == false) goto L32;
        if (r.getNotification().isGroupSummary() == true) goto L25;
        if (DEBUG == false) goto L20;
        Log.i(TAG, "Aggregate notification (sparse group): " + r);
    L20:
        this.mCallback.addAutoGroup(r.getKey(), fullAggregateGroupKey.toString(), r10);
        aggregatedNotificationsAttrs.put(r.getKey(), new NotificationAttributes(r.getFlags(), r.getNotification().getSmallIcon(), r.getNotification().color, r.getNotification().visibility, r.getNotification().getGroupAlertBehavior(), r.getChannel().getId()));
        if (triggeringKey != null) goto L23;
        triggeringKey = r.getKey();
        boolean r14 = true;
    L38:
        r10 = r14;
        goto L12
    L23:
        r14 = true;
        goto L38
    L25:
        if (r.getNotification().isGroupSummary() == true) goto L27;
        r14 = true;
        goto L38
    L27:
        if (DEBUG == false) goto L29;
        Log.i(TAG, "Remove app summary (sparse group): " + r);
    L29:
        this.mCallback.removeAppProvidedSummary(r.getKey());
        cacheCanceledSummary(r);
        r14 = true;
        goto L38
    L32:
        if (ungrouped.containsKey(r.getKey()) == true) goto L34;
        r14 = true;
        goto L38
    L34:
        if (DEBUG == false) goto L36;
        Log.i(TAG, "Aggregate ungrouped (sparse group): " + r);
    L36:
        r14 = true;
        this.mCallback.addAutoGroup(r.getKey(), fullAggregateGroupKey.toString(), true);
        aggregatedNotificationsAttrs.put(r.getKey(), ungrouped.get(r.getKey()));
        goto L38
    L39:
        this.mAggregatedNotifications.put(fullAggregateGroupKey, aggregatedNotificationsAttrs);
        updateAggregateAppGroup(fullAggregateGroupKey, triggeringKey, hasSummary, sectioner.mSummaryId);
        this.mUngroupedAbuseNotifications.remove(fullAggregateGroupKey);
    }

    protected ArrayMap<String, NotificationRecord> getSparseGroups(FullyQualifiedGroupKey fullAggregateGroupKey, List<NotificationRecord> notificationList, Map<String, NotificationRecord> summaryByGroupKey, NotificationSectioner sectioner) {
        ArrayMap<String, NotificationRecord> sparseGroups = new ArrayMap();
        Iterator<NotificationRecord> r1 = summaryByGroupKey.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L23;
        NotificationRecord summary = r1.next();
        if (summary == null) goto L4;
        if (sectioner.isInSection(summary) == false) goto L4;
        if (summary.getSbn().getPackageName().equalsIgnoreCase(FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(fullAggregateGroupKey)) == false) goto L4;
        if (summary.getUserId() != FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(fullAggregateGroupKey)) goto L4;
        if (summary.getSbn().isAppGroup() == false) goto L4;
        if (summary.getGroupKey().equals(fullAggregateGroupKey.toString()) == true) goto L4;
        int numChildren = getNumChildrenForGroupWithSection(summary.getSbn().getGroup(), notificationList, sectioner);
        if (numChildren <= 0) goto L4;
        if (numChildren >= 3) goto L4;
        sparseGroups.put(summary.getGroupKey(), summary);
        goto L4
    L23:
        return sparseGroups;
    }

    private int getNumChildrenForGroupWithSection(String groupKey, List<NotificationRecord> notificationList, NotificationSectioner sectioner) {
        int numChildren = 0;
        Iterator<NotificationRecord> r1 = notificationList.iterator();
    L4:
        if (r1.hasNext() == false) goto L21;
        NotificationRecord r = r1.next();
        if (r.getNotification().isGroupSummary() == true) goto L4;
        if (groupKey.equals(r.getSbn().getGroup()) == false) goto L4;
        NotificationSectioner childSection = getSection(r);
        if (childSection == null) goto L15;
        if (childSection != sectioner) goto L15;
        numChildren = numChildren + 1;
    L15:
        if (DEBUG == false) goto L33;
        Slog.i(TAG, "getNumChildrenForGroupWithSection skip because invalid section: " + groupKey + " r: " + r);
        return -1;
    L33:
        return -1;
    L21:
        if (DEBUG == false) goto L23;
        Slog.i(TAG, "getNumChildrenForGroupWithSection " + groupKey + " numChild: " + numChildren);
    L23:
        return numChildren;
    }

    private void cacheCanceledSummary(NotificationRecord record) {
        FullyQualifiedGroupKey groupKey = new FullyQualifiedGroupKey(record.getUserId(), record.getSbn().getPackageName(), record.getNotification().getGroup());
        this.mCanceledSummaries.put(groupKey, new CachedSummary(record.getSbn().getId(), record.getSbn().getTag(), record.getNotification().getGroup(), record.getKey(), record.getNotification().deleteIntent));
    }

    private void maybeClearCanceledSummariesCache(String pkgName, int userId, String groupName, List<NotificationRecord> notificationList, boolean sendSummaryDelete) {
        FullyQualifiedGroupKey findKey = new FullyQualifiedGroupKey(userId, pkgName, groupName);
        CachedSummary summary = this.mCanceledSummaries.get(findKey);
        if (summary != null) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Log.i(TAG, "Try removing cached summary: " + summary);
    L7:
        boolean stillHasChildren = false;
        Iterator<NotificationRecord> r3 = notificationList.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        NotificationRecord r = r3.next();
        if (CachedSummary.m6059$$Nest$fgetoriginalGroupKey(summary).equals(r.getNotification().getGroup()) == false) goto L9;
        if (r.getUser().getIdentifier() != userId) goto L9;
        if (r.getSbn().getPackageName().equals(pkgName) == false) goto L9;
        stillHasChildren = true;
    L18:
        if (stillHasChildren == true) goto L34;
        removeCachedSummary(pkgName, userId, summary);
        if (sendSummaryDelete == true) goto L22;
        return;
    L22:
        if (CachedSummary.m6056$$Nest$fgetdeleteIntent(summary) == null) goto L36;
        this.mCallback.sendAppProvidedSummaryDeleteIntent(pkgName, CachedSummary.m6056$$Nest$fgetdeleteIntent(summary));
        return;
    L36:
        return;
    }

    protected CachedSummary findCanceledSummary(String pkgName, String tag, int id, int userId) {
        Iterator<FullyQualifiedGroupKey> r0 = this.mCanceledSummaries.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        FullyQualifiedGroupKey key = r0.next();
        if (pkgName.equals(FullyQualifiedGroupKey.m6061$$Nest$fgetpkg(key)) == false) goto L4;
        if (userId != FullyQualifiedGroupKey.m6062$$Nest$fgetuserId(key)) goto L4;
        CachedSummary summary = this.mCanceledSummaries.get(key);
        if (summary == null) goto L4;
        if (CachedSummary.m6057$$Nest$fgetid(summary) != id) goto L4;
        if (TextUtils.equals(tag, CachedSummary.m6060$$Nest$fgettag(summary)) == false) goto L4;
        return summary;
    L17:
        return null;
    }

    protected CachedSummary findCanceledSummary(String pkgName, String tag, int id, int userId, String groupName) {
        FullyQualifiedGroupKey findKey = new FullyQualifiedGroupKey(userId, pkgName, groupName);
        CachedSummary summary = this.mCanceledSummaries.get(findKey);
        if (summary != null) goto L5;
        return null;
    L5:
        if (CachedSummary.m6057$$Nest$fgetid(summary) == id) goto L7;
        return null;
    L7:
        if (TextUtils.equals(tag, CachedSummary.m6060$$Nest$fgettag(summary)) == false) goto L12;
        return summary;
    L12:
        return null;
    }

    private void removeCachedSummary(String pkgName, int userId, CachedSummary summary) {
        FullyQualifiedGroupKey key = new FullyQualifiedGroupKey(userId, pkgName, CachedSummary.m6059$$Nest$fgetoriginalGroupKey(summary));
        this.mCanceledSummaries.remove(key);
    }

    protected boolean isUpdateForCanceledSummary(NotificationRecord record) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r1 = this.mAggregatedNotifications;
        monitor-enter(r1);
        boolean r2 = false;
        if (record.getSbn().isAppGroup() == true) goto L7;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return false;
    L7:
        if (record.getNotification().isGroupSummary() == false) goto L15;
        CachedSummary cachedSummary = findCanceledSummary(record.getSbn().getPackageName(), record.getSbn().getTag(), record.getSbn().getId(), record.getUserId(), record.getNotification().getGroup());     // Catch: Throwable -> L13
        if (cachedSummary == null) goto L11;
        r2 = true;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public void maybeCancelGroupChildrenForCanceledSummary(String pkgName, String tag, int id, int userId, int cancelReason) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
        CachedSummary summary = findCanceledSummary(pkgName, tag, id, userId);     // Catch: Throwable -> L9
        if (summary != null) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (DEBUG == false) goto L11;
        Log.i(TAG, "Found cached summary: " + CachedSummary.m6058$$Nest$fgetkey(summary));     // Catch: Throwable -> L9
    L11:
        this.mCallback.removeNotificationFromCanceledGroup(userId, pkgName, CachedSummary.m6059$$Nest$fgetoriginalGroupKey(summary), cancelReason);     // Catch: Throwable -> L9
        removeCachedSummary(pkgName, userId, summary);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    static NotificationSectioner getSection(NotificationRecord record) {
        Iterator<NotificationSectioner> r0 = NOTIFICATION_SHADE_SECTIONS.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        NotificationSectioner sectioner = r0.next();
        if (sectioner.isInSection(record) == false) goto L4;
        return sectioner;
    L9:
        return null;
    }

    protected void dump(PrintWriter pw, String prefix) {
        ArrayMap<FullyQualifiedGroupKey, ArrayMap<String, NotificationAttributes>> r0 = this.mAggregatedNotifications;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mUngroupedAbuseNotifications.isEmpty() == true) goto L20;
        pw.println(prefix + "Ungrouped notifications:");     // Catch: Throwable -> L15
        Iterator<FullyQualifiedGroupKey> r1 = this.mUngroupedAbuseNotifications.keySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r1.hasNext() == false) goto L18;
        FullyQualifiedGroupKey groupKey = r1.next();     // Catch: Throwable -> L15
        if (this.mUngroupedAbuseNotifications.getOrDefault(groupKey, new ArrayMap()).isEmpty() == true) goto L8;
        pw.println(prefix + prefix + groupKey.toString());     // Catch: Throwable -> L15
        Iterator<String> r3 = this.mUngroupedAbuseNotifications.get(groupKey).keySet().iterator();     // Catch: Throwable -> L15
    L13:
        if (r3.hasNext() == false) goto L8;
        String notifKey = r3.next();     // Catch: Throwable -> L15
        pw.println(prefix + prefix + prefix + notifKey);     // Catch: Throwable -> L15
        goto L13
    L18:
        pw.println("");     // Catch: Throwable -> L15
    L20:
        if (this.mAggregatedNotifications.isEmpty() == true) goto L33;
        pw.println(prefix + "Autogrouped notifications:");     // Catch: Throwable -> L15
        Iterator<FullyQualifiedGroupKey> r2 = this.mAggregatedNotifications.keySet().iterator();     // Catch: Throwable -> L15
    L23:
        if (r2.hasNext() == false) goto L31;
        FullyQualifiedGroupKey groupKey2 = r2.next();     // Catch: Throwable -> L15
        if (this.mAggregatedNotifications.getOrDefault(groupKey2, new ArrayMap()).isEmpty() == true) goto L23;
        pw.println(prefix + prefix + groupKey2.toString());     // Catch: Throwable -> L15
        Iterator<String> r4 = this.mAggregatedNotifications.get(groupKey2).keySet().iterator();     // Catch: Throwable -> L15
    L28:
        if (r4.hasNext() == false) goto L23;
        String notifKey2 = r4.next();     // Catch: Throwable -> L15
        pw.println(prefix + prefix + prefix + notifKey2);     // Catch: Throwable -> L15
        goto L28
    L31:
        pw.println("");     // Catch: Throwable -> L15
    L33:
        if (this.mCanceledSummaries.isEmpty() == true) goto L39;
        pw.println(prefix + "Cached canceled summaries:");     // Catch: Throwable -> L15
        Iterator<CachedSummary> r5 = this.mCanceledSummaries.values().iterator();     // Catch: Throwable -> L15
    L36:
        if (r5.hasNext() == false) goto L38;
        CachedSummary summary = r5.next();     // Catch: Throwable -> L15
        pw.println(prefix + prefix + prefix + CachedSummary.m6058$$Nest$fgetkey(summary) + " -> " + CachedSummary.m6059$$Nest$fgetoriginalGroupKey(summary));     // Catch: Throwable -> L15
        goto L36
    L38:
        pw.println("");     // Catch: Throwable -> L15
    L39:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }
}
