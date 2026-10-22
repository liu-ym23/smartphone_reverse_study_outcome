package com.android.server.notification;

import android.R;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.ZenBypassingApp;
import android.content.AttributionSource;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ParceledListSlice;
import android.content.pm.UserInfo;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.Build;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.service.notification.ConversationChannelWrapper;
import android.service.notification.NotificationListenerService;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.StatsEvent;
import android.util.proto.ProtoOutputStream;
import com.android.internal.config.sysui.SystemUiSystemPropertiesFlags;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.notification.NotificationChannelGroupsHelper;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.usage.UnixCalendar;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PreferencesHelper implements RankingConfig {
    private static final String ATT_ALLOW_BUBBLE = "allow_bubble";
    private static final String ATT_ALL_NOTIFICATION_SILENT = "all_notification_silent";
    private static final String ATT_APP_USER_LOCKED_FIELDS = "app_user_locked_fields";
    private static final String ATT_CREATION_TIME = "creation_time";
    private static final String ATT_ENABLED = "enabled";
    private static final String ATT_HIDE_SILENT = "hide_gentle";
    private static final String ATT_ID = "id";
    private static final String ATT_IMPORTANCE = "importance";
    private static final String ATT_LAST_BUBBLES_VERSION_UPGRADE = "last_bubbles_version_upgrade";
    private static final String ATT_NAME = "name";
    private static final String ATT_PRIORITY = "priority";
    private static final String ATT_PROMOTE_NOTIFS = "promote";
    private static final String ATT_SENT_INVALID_MESSAGE = "sent_invalid_msg";
    private static final String ATT_SENT_VALID_BUBBLE = "sent_valid_bubble";
    private static final String ATT_SENT_VALID_MESSAGE = "sent_valid_msg";
    private static final String ATT_SHOW_BADGE = "show_badge";
    private static final String ATT_UID = "uid";
    private static final String ATT_USERID = "userid";
    private static final String ATT_USER_DEMOTED_INVALID_MSG_APP = "user_demote_msg_app";
    private static final String ATT_VERSION = "version";
    private static final String ATT_VISIBILITY = "visibility";
    private static final boolean DEFAULT_APP_LOCKED_IMPORTANCE = false;
    static final boolean DEFAULT_BUBBLES_ENABLED = true;
    static final int DEFAULT_BUBBLE_PREFERENCE = 0;
    private static final boolean DEFAULT_CAN_HAVE_PROMOTED_NOTIFS = true;
    static final boolean DEFAULT_HIDE_SILENT_STATUS_BAR_ICONS = false;
    private static final int DEFAULT_IMPORTANCE = -1000;
    private static final int DEFAULT_LOCKED_APP_FIELDS = 0;
    private static final int DEFAULT_PRIORITY = 0;
    private static final boolean DEFAULT_SHOW_BADGE = true;
    private static final int DEFAULT_VISIBILITY = -1000;
    static final int NOTIFICATION_CHANNEL_COUNT_LIMIT = 5000;
    private static final int NOTIFICATION_CHANNEL_DELETION_RETENTION_DAYS = 30;
    static final int NOTIFICATION_CHANNEL_GROUP_COUNT_LIMIT = 6000;
    private static final int NOTIFICATION_CHANNEL_GROUP_PULL_LIMIT = 1000;
    private static final int NOTIFICATION_CHANNEL_PULL_LIMIT = 2000;
    private static final int NOTIFICATION_PREFERENCES_PULL_LIMIT = 1000;
    private static final int NOTIFICATION_UPDATE_LOG_SUBTYPE_FROM_APP = 0;
    private static final int NOTIFICATION_UPDATE_LOG_SUBTYPE_FROM_USER = 1;
    private static final long PREF_GRACE_PERIOD_MS = 0;
    private static final String TAG = "NotificationPrefHelper";
    private static final String TAG_CHANNEL = "channel";
    private static final String TAG_DELEGATE = "delegate";
    private static final String TAG_GROUP = "channelGroup";
    private static final String TAG_PACKAGE = "package";
    static final String TAG_RANKING = "ranking";
    private static final String TAG_STATUS_ICONS = "silent_status_icons";
    private static final int XML_VERSION_BUBBLES_UPGRADE = 1;
    private static final int XML_VERSION_NOTIF_PERMISSION = 3;
    private static final int XML_VERSION_REVIEW_PERMISSIONS_NOTIFICATION = 4;
    private final int XML_VERSION;
    private final AppOpsManager mAppOps;
    private SparseBooleanArray mBadgingEnabled;
    private SparseBooleanArray mBubblesEnabled;
    Clock mClock;
    private final Context mContext;
    private boolean mCurrentUserHasPriorityChannels;
    private boolean mHideSilentStatusBarIcons;
    private boolean mIsMediaNotificationFilteringEnabled;
    private final Object mLock;
    private SparseBooleanArray mLockScreenPrivateNotifications;
    private SparseBooleanArray mLockScreenShowNotifications;
    private final NotificationChannelLogger mNotificationChannelLogger;
    private final ArrayMap<String, PackagePreferences> mPackagePreferences;
    private final PermissionHelper mPermissionHelper;
    private final PermissionManager mPermissionManager;
    private final PackageManager mPm;
    private final RankingHandler mRankingHandler;
    private final ArrayMap<String, PackagePreferences> mRestoredWithoutUids;
    private final boolean mShowReviewPermissionsNotification;
    private PreferencesHelperSmtEx mSmtEx;
    private final UriGrantsManagerInternal mUgmInternal;
    private final ManagedServices.UserProfiles mUserProfiles;
    private final ZenModeHelper mZenModeHelper;

    private static class Delegate {
        static final boolean DEFAULT_ENABLED = true;
        boolean mEnabled;
        final String mPkg;
        final int mUid;

        Delegate(String pkg, int uid, boolean enabled) {
            this.mPkg = pkg;
            this.mUid = uid;
            this.mEnabled = enabled;
        }

        public boolean isAllowed(String pkg, int uid) {
            if (pkg != null) goto L5;
        L15:
            return false;
        L5:
            if (uid == (-1)) goto L15;
            if (pkg.equals(this.mPkg) == true) goto L10;
            return false;
        L10:
            if (uid == this.mUid) goto L12;
            return false;
        L12:
            if (this.mEnabled == false) goto L18;
            return true;
        L18:
            return false;
        }
    }

    public @interface LockableAppFields {
        public static final int USER_LOCKED_BUBBLE = 2;
        public static final int USER_LOCKED_IMPORTANCE = 1;
        public static final int USER_LOCKED_PROMOTABLE = 4;
    }

    private static class PackagePreferences {
        boolean allNotificationSilent;
        int bubblePreference;
        boolean canHavePromotedNotifs;
        ArrayMap<String, NotificationChannel> channels;
        long creationTime;
        boolean defaultAppLockedImportance;
        Delegate delegate;
        boolean fixedImportance;
        Map<String, NotificationChannelGroup> groups;
        boolean hasSentInvalidMessage;
        boolean hasSentValidBubble;
        boolean hasSentValidMessage;
        int importance;
        int lockedAppFields;
        boolean migrateToPm;
        String pkg;
        int priority;
        boolean showBadge;
        int uid;
        boolean userDemotedMsgApp;
        int userIdWhenUidUnknown;
        int visibility;

        /* synthetic */ PackagePreferences(PreferencesHelperIA r1) {
            this();
        }

        private PackagePreferences() {
            this.uid = -1;
            this.importance = -1000;
            this.priority = 0;
            this.visibility = -1000;
            this.showBadge = true;
            this.bubblePreference = 0;
            this.lockedAppFields = 0;
            this.defaultAppLockedImportance = false;
            this.fixedImportance = false;
            this.hasSentInvalidMessage = false;
            this.hasSentValidMessage = false;
            this.userDemotedMsgApp = false;
            this.hasSentValidBubble = false;
            this.migrateToPm = false;
            this.canHavePromotedNotifs = false;
            this.delegate = null;
            this.channels = new ArrayMap();
            this.groups = new ConcurrentHashMap();
            this.allNotificationSilent = false;
        }

        public boolean isValidDelegate(String pkg, int uid) {
            if (this.delegate != null) goto L5;
        L7:
            return false;
        L5:
            if (this.delegate.isAllowed(pkg, uid) == false) goto L7;
            return true;
        }
    }

    static {
        PREF_GRACE_PERIOD_MS = Duration.ofDays(2).toMillis();
    }

    public PreferencesHelper(Context context, PackageManager pm, RankingHandler rankingHandler, ZenModeHelper zenHelper, PermissionHelper permHelper, PermissionManager permManager, NotificationChannelLogger notificationChannelLogger, AppOpsManager appOpsManager, ManagedServices.UserProfiles userProfiles, UriGrantsManagerInternal ugmInternal, boolean showReviewPermissionsNotification, Clock clock) {
        this.mLock = new Object();
        this.mPackagePreferences = new ArrayMap();
        this.mRestoredWithoutUids = new ArrayMap();
        this.mHideSilentStatusBarIcons = false;
        this.mSmtEx = new PreferencesHelperSmtEx(this);
        this.mContext = context;
        this.mZenModeHelper = zenHelper;
        this.mRankingHandler = rankingHandler;
        this.mPermissionHelper = permHelper;
        this.mPermissionManager = permManager;
        this.mPm = pm;
        this.mNotificationChannelLogger = notificationChannelLogger;
        this.mAppOps = appOpsManager;
        this.mUserProfiles = userProfiles;
        this.mUgmInternal = ugmInternal;
        this.mShowReviewPermissionsNotification = showReviewPermissionsNotification;
        this.mIsMediaNotificationFilteringEnabled = context.getResources().getBoolean(R.bool.config_restart_radio_on_pdp_fail_regular_deactivation);
        this.mClock = clock;
        this.XML_VERSION = 4;
        updateBadgingEnabled();
        updateBubblesEnabled();
        updateMediaNotificationFilteringEnabled();
    }

    void onBootPhaseAppsCanStart() {
    }

    public void readXml(TypedXmlPullParser parser, boolean forRestore, int userId) throws XmlPullParserException, IOException {
        PreferencesHelper r1 = this;
        TypedXmlPullParser r2 = parser;
        if (r2.getEventType() == 2) goto L6;
        return;
    L6:
        if (TAG_RANKING.equals(r2.getName()) == true) goto L8;
        return;
    L8:
        int xmlVersion = r2.getAttributeInt(null, ATT_VERSION, -1);
        if (r2.getAttributeInt(null, ATT_LAST_BUBBLES_VERSION_UPGRADE, -1) >= Build.VERSION.SDK_INT) goto L11;
        boolean upgradeForBubbles = true;
    L13:
        if (xmlVersion >= 3) goto L15;
        boolean migrateToPermission = true;
    L17:
        if (r1.mShowReviewPermissionsNotification == true) goto L19;
    L21:
        Object r14 = r1.mLock;
        monitor-enter(r14);
    L74:
        int type = r2.next();     // Catch: Throwable -> L63
        if (type == 1) goto L61;
        String tag = r2.getName();     // Catch: Throwable -> L59
        if (type == 3) goto L70;
    L35:
        if (type == 2) goto L66;
        String tag2 = tag;
    L58:
        r1 = this;
        r2 = parser;
        goto L74
    L66:
    L54:
        th = th;
    L64:
        monitor-exit(r14);     // Catch: Throwable -> L63
    L63:
        th = th;
        goto L64
    L65:
        throw th;
    L37:
        if (TAG_STATUS_ICONS.equals(tag) == false) goto L44;
        if (forRestore == false) goto L41;
        if (userId == 0) goto L41;
        tag2 = tag;
    L41:
        r1.mHideSilentStatusBarIcons = r2.getAttributeBoolean(null, ATT_HIDE_SILENT, false);     // Catch: Throwable -> L33
        tag2 = tag;
        goto L58
    L44:
        if ("package".equals(tag) == false) goto L56;
        String name = r2.getAttributeValue(null, "name");     // Catch: Throwable -> L54
        if (TextUtils.isEmpty(name) == true) goto L52;
        tag2 = tag;
        r1.restorePackage(r2, forRestore, userId, name, upgradeForBubbles, migrateToPermission);     // Catch: Throwable -> L50
    L50:
        th = th;
        goto L64
    L52:
        tag2 = tag;
        goto L58
    L56:
        tag2 = tag;
        goto L58
    L70:
        if (TAG_RANKING.equals(tag) == false) goto L35;
    L33:
        th = th;
    L59:
        th = th;
    L61:
        monitor-exit(r14);     // Catch: Throwable -> L59
        return;
    L76:
        th = th;
        goto L64
    L19:
        if (xmlVersion >= 4) goto L21;
        Settings.Global.putInt(r1.mContext.getContentResolver(), "review_permissions_notification_state", 0);
        goto L21
    L15:
        migrateToPermission = false;
        goto L17
    L11:
        upgradeForBubbles = false;
        goto L13
    }

    private void restorePackage(TypedXmlPullParser parser, boolean forRestore, int userId, String name, boolean upgradeForBubbles, boolean migrateToPermission) {
    L10:
        e = e;
    L11:
        String r13 = TAG;
    L112:
        Slog.w(r13, "Failed to restore pkg", e);
        return;
    L4:
        int uid = parser.getAttributeInt(null, "uid", -1);     // Catch: Exception -> L10
        if (forRestore == true) goto L130;
        String r10 = name;
    L19:
        boolean skipWarningLogged = false;
        boolean skipGroupWarningLogged = false;
        int bubblePref = parser.getAttributeInt(null, ATT_ALLOW_BUBBLE, 0);     // Catch: Exception -> L10
        if ((parser.getAttributeInt(null, ATT_APP_USER_LOCKED_FIELDS, 0) & 2) == 0) goto L23;
        boolean r16 = true;
    L24:
        boolean bubbleLocked = r16;
        if (bubbleLocked == true) goto L32;
        if (upgradeForBubbles == false) goto L32;
        if (uid == (-1)) goto L32;
        int uid2 = uid;
        String r8 = "uid";
        int uid3 = uid2;
        if (this.mAppOps.noteOpNoThrow(24, uid2, r10, null, "check-notif-bubble") != 0) goto L33;
        bubblePref = 1;
    L33:
        int appImportance = parser.getAttributeInt(null, ATT_IMPORTANCE, -1000);     // Catch: Exception -> L10
        int fixedUserId = userId;
        if (forRestore == true) goto L126;
        if (uid3 != (-1)) goto L126;
        fixedUserId = parser.getAttributeInt(null, ATT_USERID, 0);     // Catch: Exception -> L10
    L126:
        int appImportance2 = parser.getAttributeInt(null, ATT_PRIORITY, 0);     // Catch: Exception -> L110
        int r17 = parser.getAttributeInt(null, ATT_VISIBILITY, -1000);     // Catch: Exception -> L110
        String r20 = r8;
        boolean r9 = parser.getAttributeBoolean(null, ATT_SHOW_BADGE, true);     // Catch: Exception -> L110
        long r7 = parser.getAttributeLong(null, ATT_CREATION_TIME, this.mClock.millis());     // Catch: Exception -> L110
        r13 = TAG;
        int bubblePref2 = bubblePref;
        int fixedUserId2 = fixedUserId;
        String r26 = r20;
        String r14 = null;
        PackagePreferences r = getOrCreatePackagePreferencesSupportingInvalidUidLocked(name, fixedUserId2, uid3, appImportance, appImportance2, r17, r9, bubblePref2, r7);     // Catch: Exception -> L52
        r.bubblePreference = bubblePref2;     // Catch: Exception -> L52
        r.priority = parser.getAttributeInt(null, ATT_PRIORITY, 0);     // Catch: Exception -> L52
        r.visibility = parser.getAttributeInt(null, ATT_VISIBILITY, -1000);     // Catch: Exception -> L52
        int r11 = 1;
        r.showBadge = parser.getAttributeBoolean(null, ATT_SHOW_BADGE, true);     // Catch: Exception -> L52
        r.lockedAppFields = parser.getAttributeInt(null, ATT_APP_USER_LOCKED_FIELDS, 0);     // Catch: Exception -> L52
        r.hasSentInvalidMessage = parser.getAttributeBoolean(null, ATT_SENT_INVALID_MESSAGE, false);     // Catch: Exception -> L52
        r.hasSentValidMessage = parser.getAttributeBoolean(null, ATT_SENT_VALID_MESSAGE, false);     // Catch: Exception -> L52
        r.userDemotedMsgApp = parser.getAttributeBoolean(null, ATT_USER_DEMOTED_INVALID_MSG_APP, false);     // Catch: Exception -> L52
        r.hasSentValidBubble = parser.getAttributeBoolean(null, ATT_SENT_VALID_BUBBLE, false);     // Catch: Exception -> L52
        r.allNotificationSilent = parser.getAttributeBoolean(null, ATT_ALL_NOTIFICATION_SILENT, false);     // Catch: Exception -> L52
        int innerDepth = parser.getDepth();     // Catch: Exception -> L52
    L44:
        int type = parser.next();     // Catch: Exception -> L52
        if (type == r11) goto L114;
        if (type == 3) goto L49;
    L54:
        if (type == 3) goto L100;
        if (type == 4) goto L57;
        String tagName = parser.getName();     // Catch: Exception -> L52
        if (TAG_GROUP.equals(tagName) == false) goto L75;
    L69:
        e = e;
        r13 = r13;
        goto L112
    L62:
        if (r.groups.size() < 6000) goto L72;
        if (skipGroupWarningLogged == true) goto L71;
        r13 = r13;
        Slog.w(r13, "Skipping further groups for " + r.pkg);     // Catch: Exception -> L67
        skipGroupWarningLogged = true;
        r13 = r13;
    L67:
        e = e;
        goto L112
    L71:
        r13 = r13;
        String r12 = r26;
    L101:
        r26 = r12;
        r13 = r13;
        innerDepth = innerDepth;
        fixedUserId2 = fixedUserId2;
        r11 = 1;
        r14 = null;
        goto L44
    L72:
        r13 = r13;
        String id = parser.getAttributeValue(r14, ATT_ID);     // Catch: Exception -> L67
        CharSequence groupName = parser.getAttributeValue(r14, "name");     // Catch: Exception -> L67
        if (TextUtils.isEmpty(id) == true) goto L77;
        NotificationChannelGroup group = new NotificationChannelGroup(id, groupName);     // Catch: Exception -> L67
        group.populateFromXml(parser);     // Catch: Exception -> L67
        r.groups.put(id, group);     // Catch: Exception -> L67
    L77:
        if (TAG_CHANNEL.equals(tagName) == false) goto L90;
        if (r.channels.size() < 5000) goto L124;
        if (skipWarningLogged == true) goto L83;
        Slog.w(r13, "Skipping further channels for " + r.pkg);     // Catch: Exception -> L67
        skipWarningLogged = true;
        r13 = r13;
        r11 = 1;
        r14 = null;
        goto L44
    L83:
        r12 = r26;
        goto L101
    L124:
        restoreChannel(parser, forRestore, r);     // Catch: Exception -> L86
    L86:
        e = e;
    L90:
        if (TAG_DELEGATE.equals(tagName) == false) goto L98;
        r12 = r26;
        int delegateId = parser.getAttributeInt(null, r12, -1);     // Catch: Exception -> L86
        String delegateName = XmlUtils.readStringAttribute(parser, "name");     // Catch: Exception -> L86
        boolean delegateEnabled = parser.getAttributeBoolean(null, "enabled", true);     // Catch: Exception -> L86
        Delegate d = null;
        if (delegateId != (-1)) goto L94;
    L96:
        r.delegate = d;     // Catch: Exception -> L86
        goto L101
    L94:
        if (TextUtils.isEmpty(delegateName) == true) goto L96;
        d = new Delegate(delegateName, delegateId, delegateEnabled);     // Catch: Exception -> L86
        goto L96
    L98:
        r12 = r26;
        goto L101
    L75:
        r13 = r13;
        goto L77
    L57:
        r12 = r26;
        r13 = r13;
        goto L101
    L100:
        r12 = r26;
        r13 = r13;
        goto L101
    L49:
        if (parser.getDepth() > innerDepth) goto L54;
    L114:
        deleteDefaultChannelIfNeededLocked(r);     // Catch: Exception -> L86 PackageManager.NameNotFoundException -> L105
    L107:
        if (migrateToPermission == false) goto L150;
        r.importance = appImportance;     // Catch: Exception -> L86
        r.migrateToPm = true;     // Catch: Exception -> L86
        return;
    L150:
        return;
    L105:
        e = move-exception;
        Slog.e(r13, "deleteDefaultChannelIfNeededLocked - Exception: " + e);     // Catch: Exception -> L86
    L52:
        e = e;
        r13 = r13;
    L110:
        e = e;
        r13 = TAG;
    L32:
        int r28 = uid;
        r8 = "uid";
        uid3 = r28;
        goto L33
    L23:
        r16 = false;
        goto L24
    L130:
        r10 = name;
        uid = this.mPm.getPackageUidAsUser(r10, userId);     // Catch: Exception -> L10 PackageManager.NameNotFoundException -> L12
        goto L19
    L14:
        e = e;
    L17:
        r10 = name;
        goto L19
    }

    private void restoreChannel(TypedXmlPullParser parser, boolean forRestore, PackagePreferences r) {
        String id = parser.getAttributeValue(null, ATT_ID);     // Catch: Exception -> L13
        String channelName = parser.getAttributeValue(null, "name");     // Catch: Exception -> L13
        int channelImportance = parser.getAttributeInt(null, ATT_IMPORTANCE, -1000);     // Catch: Exception -> L13
        if (TextUtils.isEmpty(id) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(channelName) == true) goto L39;
        NotificationChannel channel = new NotificationChannel(id, channelName, channelImportance);     // Catch: Exception -> L13
        boolean r4 = true;
        if (forRestore == true) goto L9;
        channel.populateFromXml(parser);     // Catch: Exception -> L13
    L17:
        if (r.defaultAppLockedImportance == true) goto L22;
        if (r.fixedImportance == true) goto L22;
        r4 = false;
    L22:
        channel.setImportanceLockedByCriticalDeviceFunction(r4);     // Catch: Exception -> L13
        if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(id) == false) goto L28;
        if (channel.isDeleted() == false) goto L28;
        channel.setDeleted(false);     // Catch: Exception -> L13
    L28:
        if (isShortcutOk(channel) == true) goto L30;
        return;
    L30:
        if (isDeletionOk(channel) == false) goto L41;
        r.channels.put(id, channel);     // Catch: Exception -> L13
        return;
    L41:
        return;
    L9:
        if (r.uid == (-1)) goto L11;
        boolean pkgInstalled = true;
    L12:
        channel.populateFromXmlForRestore(parser, pkgInstalled, this.mContext);     // Catch: Exception -> L13
        goto L17
    L11:
        pkgInstalled = false;
        goto L12
    L39:
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "could not restore channel for " + r.pkg, e);
    }

    private boolean hasUserConfiguredSettings(PackagePreferences p) {
        boolean hasChangedChannel = false;
        Iterator<NotificationChannel> r1 = p.channels.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        NotificationChannel channel = r1.next();
        if (channel.getUserLockedFields() == 0) goto L4;
        hasChangedChannel = true;
    L9:
        if (hasChangedChannel == false) goto L11;
    L14:
        return true;
    L11:
        if (p.importance == 0) goto L14;
        return false;
    }

    private boolean isShortcutOk(NotificationChannel channel) {
        if (channel.getConversationId() != null) goto L5;
    L7:
        boolean isInvalidShortcutChannel = false;
    L9:
        if (isInvalidShortcutChannel == false) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (channel.getConversationId().contains(":placeholder_id") == false) goto L7;
        isInvalidShortcutChannel = true;
        goto L9
    }

    private boolean isDeletionOk(NotificationChannel nc) {
        if (nc.isDeleted() == true) goto L5;
        return true;
    L5:
        long boundary = System.currentTimeMillis() - UnixCalendar.MONTH_IN_MILLIS;
        if (nc.getDeletedTimeMs() > boundary) goto L9;
        return false;
    L9:
        return true;
    }

    private PackagePreferences getPackagePreferencesLocked(String pkg, int uid) {
        String key = packagePreferencesKey(pkg, uid);
        return this.mPackagePreferences.get(key);
    }

    private PackagePreferences getOrCreatePackagePreferencesLocked(String pkg, int uid) {
        pkg.getClass();
        if (uid == (-1)) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Valid uid required to get settings of %s", new Object[]{pkg});
        return getOrCreatePackagePreferencesSupportingInvalidUidLocked(pkg, UserHandle.getUserId(uid), uid, -1000, 0, -1000, true, 0, this.mClock.millis());
    L5:
        r0 = false;
        goto L6
    }

    private PackagePreferences getOrCreatePackagePreferencesSupportingInvalidUidLocked(String pkg, int userId, int uid, int importance, int priority, int visibility, boolean showBadge, int bubblePreference, long creationTime) {
        String key = packagePreferencesKey(pkg, uid);
        if (uid != (-1)) goto L5;
        PackagePreferences r = this.mRestoredWithoutUids.get(unrestoredPackageKey(pkg, userId));
    L7:
        if (r != null) goto L23;
        r = new PackagePreferences(null);
        r.pkg = pkg;
        r.uid = uid;
        r.importance = importance;
        r.priority = priority;
        r.visibility = visibility;
        r.showBadge = showBadge;
        r.bubblePreference = bubblePreference;
        if (r.uid != (-1)) goto L29;
        r.creationTime = creationTime;
    L29:
        createDefaultChannelIfNeededLocked(r);     // Catch: PackageManager.NameNotFoundException -> L14
    L17:
        if (r.uid != (-1)) goto L19;
        r.userIdWhenUidUnknown = userId;
        this.mRestoredWithoutUids.put(unrestoredPackageKey(pkg, userId), r);
        goto L23
    L19:
        this.mPackagePreferences.put(key, r);
    L14:
        e = move-exception;
        Slog.e(TAG, "createDefaultChannelIfNeededLocked - Exception: " + e);
    L23:
        if (r.uid == (-1)) goto L25;
    L28:
        return r;
    L25:
        if (PREF_GRACE_PERIOD_MS >= (this.mClock.millis() - r.creationTime)) goto L28;
        this.mRestoredWithoutUids.remove(unrestoredPackageKey(pkg, userId));
        goto L28
    L5:
        r = this.mPackagePreferences.get(key);
        goto L7
    }

    private boolean shouldHaveDefaultChannel(PackagePreferences r) throws PackageManager.NameNotFoundException {
        int userId = UserHandle.getUserId(r.uid);
        ApplicationInfo applicationInfo = this.mPm.getApplicationInfoAsUser(r.pkg, 0, userId);
        if (applicationInfo.targetSdkVersion < 26) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean deleteDefaultChannelIfNeededLocked(PackagePreferences r) throws PackageManager.NameNotFoundException {
        if (r.channels.containsKey("miscellaneous") == true) goto L6;
        return false;
    L6:
        if (shouldHaveDefaultChannel(r) == false) goto L8;
        return false;
    L8:
        r.channels.remove("miscellaneous");
        return true;
    }

    private boolean createDefaultChannelIfNeededLocked(PackagePreferences r) throws PackageManager.NameNotFoundException {
        boolean r2 = false;
        if (r.uid != (-1)) goto L6;
        return false;
    L6:
        if (r.channels.containsKey("miscellaneous") == false) goto L10;
        r.channels.get("miscellaneous").setName(this.mContext.getString(R.string.duration_years_shortest_future));
        return false;
    L10:
        if (shouldHaveDefaultChannel(r) == true) goto L12;
        return false;
    L12:
        NotificationChannel channel = new NotificationChannel("miscellaneous", this.mContext.getString(R.string.duration_years_shortest_future), r.importance);
        if (r.priority != 2) goto L15;
        r2 = true;
    L15:
        channel.setBypassDnd(r2);
        channel.setLockscreenVisibility(r.visibility);
        if (r.importance == (-1000)) goto L19;
        channel.lockFields(4);
    L19:
        if (r.priority == 0) goto L22;
        channel.lockFields(1);
    L22:
        if (r.visibility == (-1000)) goto L24;
        channel.lockFields(2);
    L24:
        r.channels.put(channel.getId(), channel);
        return true;
    }

    private NotificationChannel addReservedChannelLocked(PackagePreferences p, String channelId) {
        String label = "";
        switch(channelId.hashCode()) {
            case -158881607: goto L15;
            case 1094647583: goto L12;
            case 1094766127: goto L9;
            case 1329636220: goto L6;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L18:
        switch(r1) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            default: goto L24;
        };
    L20:
        label = this.mContext.getString(R.string.whichViewApplicationNamed);
        goto L24
    L21:
        label = this.mContext.getString(R.string.permdesc_foregroundServiceMicrophone);
        goto L24
    L22:
        label = this.mContext.getString(R.string.slices_permission_request);
        goto L24
    L23:
        label = this.mContext.getString(R.string.share_remote_bugreport_action);
    L24:
        NotificationChannel channel = new NotificationChannel(channelId, label, 2);
        p.channels.put(channelId, channel);
        return channel;
    L6:
        if (channelId.equals("android.app.promotions") == false) goto L17;
        r1 = 0;
        goto L18
    L9:
        if (channelId.equals("android.app.recs") == false) goto L17;
        r1 = 1;
        goto L18
    L12:
        if (channelId.equals("android.app.news") == false) goto L17;
        r1 = 2;
        goto L18
    L15:
        if (channelId.equals("android.app.social") == false) goto L17;
        r1 = 3;
        goto L18
    }

    public void writeXml(TypedXmlSerializer out, boolean forBackup, int userId) throws IOException {
        out.startTag(null, TAG_RANKING);
        out.attributeInt(null, ATT_VERSION, this.XML_VERSION);
        out.attributeInt(null, ATT_LAST_BUBBLES_VERSION_UPGRADE, Build.VERSION.SDK_INT);
        if (this.mHideSilentStatusBarIcons == false) goto L5;
        out.startTag(null, TAG_STATUS_ICONS);
        out.attributeBoolean(null, ATT_HIDE_SILENT, this.mHideSilentStatusBarIcons);
        out.endTag(null, TAG_STATUS_ICONS);
    L5:
        ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> notifPermissions = new ArrayMap();
        if (forBackup == false) goto L8;
        notifPermissions = this.mPermissionHelper.getNotificationPermissionValues(userId);
    L8:
        Object r2 = this.mLock;
        monitor-enter(r2);
        int N = this.mPackagePreferences.size();     // Catch: Throwable -> L17
        int i = 0;
    L11:
        if (i >= N) goto L22;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L17
        if (forBackup == true) goto L15;
    L19:
        writePackageXml(r, out, notifPermissions, forBackup);     // Catch: Throwable -> L17
    L20:
        i = i + 1;     // Catch: Throwable -> L17
        goto L11
    L15:
        if (UserHandle.getUserId(r.uid) == userId) goto L19;
    L22:
        if (forBackup == true) goto L26;
        int M = this.mRestoredWithoutUids.size();     // Catch: Throwable -> L17
        int i2 = 0;
    L24:
        if (i2 >= M) goto L26;
        writePackageXml(this.mRestoredWithoutUids.valueAt(i2), out, notifPermissions, false);     // Catch: Throwable -> L17
        i2 = i2 + 1;     // Catch: Throwable -> L17
    L26:
        monitor-exit(r2);     // Catch: Throwable -> L17
        if (notifPermissions.isEmpty() == true) goto L37;
        Iterator<Pair<Integer, String>> r3 = notifPermissions.keySet().iterator();
    L31:
        if (r3.hasNext() == false) goto L37;
        Pair<Integer, String> app = r3.next();
        out.startTag(null, "package");
        out.attribute(null, "name", (String) app.second);
        if (((Boolean) notifPermissions.get(app).first).booleanValue() == false) goto L35;
        int r6 = 3;
    L36:
        out.attributeInt(null, ATT_IMPORTANCE, r6);
        out.endTag(null, "package");
        goto L31
    L35:
        r6 = 0;
    L37:
        out.endTag(null, TAG_RANKING);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void writePackageXml(PackagePreferences r, TypedXmlSerializer out, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> notifPermissions, boolean forBackup) throws IOException {
        out.startTag(null, "package");
        out.attribute(null, "name", r.pkg);
        if (notifPermissions.isEmpty() == true) goto L12;
        Pair<Integer, String> app = new Pair(Integer.valueOf(r.uid), r.pkg);
        Pair<Boolean, Boolean> permission = notifPermissions.get(app);
        if (permission != null) goto L7;
    L9:
        int r7 = 0;
    L10:
        out.attributeInt(null, ATT_IMPORTANCE, r7);
        notifPermissions.remove(app);
    L15:
        if (r.priority == 0) goto L18;
        out.attributeInt(null, ATT_PRIORITY, r.priority);
    L18:
        if (r.visibility == (-1000)) goto L21;
        out.attributeInt(null, ATT_VISIBILITY, r.visibility);
    L21:
        if (r.bubblePreference == 0) goto L23;
        out.attributeInt(null, ATT_ALLOW_BUBBLE, r.bubblePreference);
    L23:
        out.attributeBoolean(null, ATT_SHOW_BADGE, r.showBadge);
        out.attributeInt(null, ATT_APP_USER_LOCKED_FIELDS, r.lockedAppFields);
        out.attributeBoolean(null, ATT_SENT_INVALID_MESSAGE, r.hasSentInvalidMessage);
        out.attributeBoolean(null, ATT_SENT_VALID_MESSAGE, r.hasSentValidMessage);
        out.attributeBoolean(null, ATT_USER_DEMOTED_INVALID_MSG_APP, r.userDemotedMsgApp);
        out.attributeBoolean(null, ATT_SENT_VALID_BUBBLE, r.hasSentValidBubble);
        out.attributeBoolean(null, ATT_ALL_NOTIFICATION_SILENT, r.allNotificationSilent);
        if (r.uid != (-1)) goto L27;
        out.attributeLong(null, ATT_CREATION_TIME, r.creationTime);
        out.attributeInt(null, ATT_USERID, r.userIdWhenUidUnknown);
    L27:
        if (forBackup == true) goto L30;
        out.attributeInt(null, "uid", r.uid);
    L30:
        if (r.delegate == null) goto L35;
        out.startTag(null, TAG_DELEGATE);
        out.attribute(null, "name", r.delegate.mPkg);
        out.attributeInt(null, "uid", r.delegate.mUid);
        if (r.delegate.mEnabled == true) goto L34;
        out.attributeBoolean(null, "enabled", r.delegate.mEnabled);
    L34:
        out.endTag(null, TAG_DELEGATE);
    L35:
        Iterator<NotificationChannelGroup> r2 = r.groups.values().iterator();
    L37:
        if (r2.hasNext() == false) goto L39;
        NotificationChannelGroup group = r2.next();
        group.writeXml(out);
        goto L37
    L39:
        Iterator<NotificationChannel> r3 = r.channels.values().iterator();
    L41:
        if (r3.hasNext() == false) goto L49;
        NotificationChannel channel = r3.next();
        if (forBackup == true) goto L45;
        channel.writeXml(out);
        goto L41
    L45:
        if (channel.isDeleted() == true) goto L41;
        channel.writeXmlForBackup(out, this.mContext);
        goto L41
    L49:
        out.endTag(null, "package");
        return;
    L7:
        if (((Boolean) permission.first).booleanValue() == false) goto L9;
        r7 = 3;
        goto L10
    L12:
        if (r.importance == (-1000)) goto L15;
        out.attributeInt(null, ATT_IMPORTANCE, r.importance);
        goto L15
    }

    public void setBubblesAllowed(String pkg, int uid, int bubblePreference) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L13
        if (p.bubblePreference == bubblePreference) goto L7;
        boolean changed = true;
    L8:
        p.bubblePreference = bubblePreference;     // Catch: Throwable -> L13
        p.lockedAppFields |= 2;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (changed == false) goto L18;
        updateConfig();
        return;
    L18:
        return;
    L7:
        changed = false;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public int getBubblePreference(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        int r2 = p.bubblePreference;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public int getAppLockedFields(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        int r2 = p.lockedAppFields;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean canShowBadge(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        boolean r2 = p.showBadge;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = true;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public void setShowBadge(String packageName, int uid, boolean showBadge) {
        boolean changed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences pkgPrefs = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L7
        if (pkgPrefs.showBadge == showBadge) goto L9;
        pkgPrefs.showBadge = showBadge;     // Catch: Throwable -> L7
        changed = true;
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (changed == false) goto L17;
        updateConfig();
        return;
    L17:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean canBePromoted(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getOrCreatePackagePreferencesLocked(packageName, uid).canHavePromotedNotifs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setCanBePromoted(String packageName, int uid, boolean promote, boolean fromUser) {
        boolean changed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences pkgPrefs = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L9
        if (fromUser == true) goto L12;
        if ((pkgPrefs.lockedAppFields & 4) == 0) goto L12;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return changed;
    L12:
        if (pkgPrefs.canHavePromotedNotifs == promote) goto L17;
        pkgPrefs.canHavePromotedNotifs = promote;     // Catch: Throwable -> L9
        if (fromUser == false) goto L16;
        pkgPrefs.lockedAppFields |= 4;     // Catch: Throwable -> L9
    L16:
        changed = true;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isInInvalidMsgState(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r != null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L7:
        if (r.hasSentInvalidMessage == false) goto L13;
        if (r.hasSentValidMessage == true) goto L13;
        r2 = true;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean hasUserDemotedInvalidMsgApp(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r != null) goto L7;
    L13:
        boolean r2 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L7:
        if (isInInvalidMsgState(packageName, uid) == false) goto L13;
        if (r.userDemotedMsgApp == false) goto L13;
        r2 = true;
    L11:
        th = move-exception;
        throw th;
    }

    public void setInvalidMsgAppDemoted(String packageName, int uid, boolean isDemoted) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L7
        r.userDemotedMsgApp = isDemoted;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setInvalidMessageSent(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r.hasSentInvalidMessage == true) goto L7;
        boolean valueChanged = true;
    L8:
        r.hasSentInvalidMessage = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return valueChanged;
    L7:
        valueChanged = false;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean setValidMessageSent(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r.hasSentValidMessage == true) goto L7;
        boolean valueChanged = true;
    L8:
        r.hasSentValidMessage = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return valueChanged;
    L7:
        valueChanged = false;
    L11:
        th = move-exception;
        throw th;
    }

    boolean hasSentInvalidMsg(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L9
        if (r != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (r.hasSentInvalidMessage == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean hasSentValidMsg(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L9
        if (r != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (r.hasSentValidMessage == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean didUserEverDemoteInvalidMsgApp(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L9
        if (p != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (p.userDemotedMsgApp == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean setValidBubbleSent(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r.hasSentValidBubble == true) goto L7;
        boolean valueChanged = true;
    L8:
        r.hasSentValidBubble = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return valueChanged;
    L7:
        valueChanged = false;
    L11:
        th = move-exception;
        throw th;
    }

    boolean hasSentValidBubble(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L9
        if (p != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (p.hasSentValidBubble == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean isImportanceLocked(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L11
        boolean r2 = false;
        if (p != null) goto L7;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L7:
        if (p.fixedImportance == true) goto L13;
        if (p.defaultAppLockedImportance == false) goto L15;
    L13:
        r2 = true;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean isGroupBlocked(String packageName, int uid, String groupId) {
        if (groupId != null) goto L5;
        return false;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L11
        if (r != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L13:
        NotificationChannelGroup group = r.groups.get(groupId);     // Catch: Throwable -> L11
        if (group != null) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L11
        return false;
    L17:
        boolean r0 = group.isBlocked();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    int getPackagePriority(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        int r2 = p.priority;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    int getPackageVisibility(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        int r2 = p.visibility;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = -1000;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public void createNotificationChannelGroup(String pkg, int uid, NotificationChannelGroup group, boolean fromTargetApp, int callingUid, boolean fromSystemOrSystemUi) {
        pkg.getClass();
        group.getClass();
        group.getId().getClass();
        if (TextUtils.isEmpty(group.getName()) == true) goto L55;
        Object r7 = this.mLock;
        monitor-enter(r7);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L11
        if (r.groups.size() >= 6000) goto L50;
        if (fromTargetApp == false) goto L13;
        group.setBlocked(false);     // Catch: Throwable -> L11
    L13:
        NotificationChannelGroup oldGroup = r.groups.get(group.getId());     // Catch: Throwable -> L11
        boolean r5 = true;
        if (oldGroup == null) goto L22;
        group.setChannels(oldGroup.getChannels());     // Catch: Throwable -> L11
        if (fromTargetApp == false) goto L19;
        group.setBlocked(oldGroup.isBlocked());     // Catch: Throwable -> L11
        group.unlockFields(group.getUserLockedFields());     // Catch: Throwable -> L11
        group.lockFields(oldGroup.getUserLockedFields());     // Catch: Throwable -> L11
        goto L22
    L19:
        if (group.isBlocked() == oldGroup.isBlocked()) goto L22;
        group.lockFields(1);     // Catch: Throwable -> L11
        boolean needsDndChange = true;
    L57:
        boolean needsDndChange2 = group.equals(oldGroup);     // Catch: Throwable -> L46
        if (needsDndChange2 == false) goto L60;
    L39:
        r.groups.put(group.getId(), group);     // Catch: Throwable -> L46
        monitor-exit(r7);     // Catch: Throwable -> L46
        if (needsDndChange == false) goto L45;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
        return;
    L45:
        return;
    L60:
        MetricsLogger.action(getChannelGroupLog(group.getId(), pkg));     // Catch: Throwable -> L34
        NotificationChannelLogger r1 = this.mNotificationChannelLogger;     // Catch: Throwable -> L34
        boolean r6 = true;
        if (oldGroup == null) goto L30;
        r5 = false;
    L30:
        if (oldGroup != null) goto L32;
    L36:
        r6 = false;
    L37:
        r1.logNotificationChannelGroup(group, uid, pkg, r5, r6);     // Catch: Throwable -> L34
        goto L39
    L32:
        if (oldGroup.isBlocked() == false) goto L36;
    L34:
        th = th;
    L52:
        monitor-exit(r7);     // Catch: Throwable -> L51
        throw th;
    L46:
        th = th;
    L22:
        needsDndChange = false;
        goto L57
    L50:
        throw new IllegalStateException("Limit exceed; cannot create more groups");     // Catch: Throwable -> L51
    L11:
        th = th;
    L51:
        th = th;
        goto L52
    L55:
        throw new IllegalArgumentException("group.getName() can't be empty");
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean createNotificationChannel(String pkg, int uid, NotificationChannel channel, boolean fromTargetApp, boolean hasDndAccess, int callingUid, boolean fromSystemOrSystemUi) {
        pkg.getClass();
        channel.getClass();
        channel.getId().getClass();
        Preconditions.checkArgument(!TextUtils.isEmpty(channel.getName()));
        if (channel.getImportance() >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preconditions.checkArgument(r0, "Invalid importance level");
        boolean needsPolicyFileChange = false;
        boolean needsDndChange = false;
        Object r11 = this.mLock;
        monitor-enter(r11);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L17
        if (channel.getGroup() == null) goto L20;
        if (r.groups.containsKey(channel.getGroup()) == true) goto L20;
        throw new IllegalArgumentException("NotificationChannelGroup doesn't exist");     // Catch: Throwable -> L17
    L20:
        if ("miscellaneous".equals(channel.getId()) == true) goto L134;
        if (fromSystemOrSystemUi == false) goto L23;
    L26:
        NotificationChannel existing = r.channels.get(channel.getId());     // Catch: Throwable -> L17
        if (existing == null) goto L82;
        if (fromTargetApp == false) goto L82;
        if (existing.isDeleted() == false) goto L33;
        existing.setDeleted(false);     // Catch: Throwable -> L17
        existing.setDeletedTimeMs(-1);     // Catch: Throwable -> L17
        needsPolicyFileChange = true;
        MetricsLogger.action(getChannelLog(channel, pkg).setType(1));     // Catch: Throwable -> L17
        this.mNotificationChannelLogger.logNotificationChannelCreated(channel, uid, pkg);     // Catch: Throwable -> L17
        boolean wasUndeleted = true;
    L141:
    L37:
        th = th;
    L135:
        monitor-exit(r11);     // Catch: Throwable -> L131
        throw th;
    L35:
        if (Objects.equals(channel.getName().toString(), existing.getName().toString()) == true) goto L40;
        existing.setName(channel.getName().toString());     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
    L40:
        if (Objects.equals(channel.getDescription(), existing.getDescription()) == true) goto L43;
        existing.setDescription(channel.getDescription());     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
    L43:
        if (channel.isBlockable() == existing.isBlockable()) goto L46;
        existing.setBlockable(channel.isBlockable());     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
    L46:
        if (channel.getGroup() != null) goto L48;
    L50:
        int previousExistingImportance = existing.getImportance();     // Catch: Throwable -> L37
        int previousLoggingImportance = NotificationChannelLogger.getLoggingImportance(existing);     // Catch: Throwable -> L37
        if (existing.getUserLockedFields() != 0) goto L56;
        if (channel.getImportance() >= existing.getImportance()) goto L56;
        existing.setImportance(channel.getImportance());     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
    L56:
        if (existing.getUserLockedFields() != 0) goto L67;
        if (hasDndAccess == false) goto L67;
        boolean bypassDnd = channel.canBypassDnd();     // Catch: Throwable -> L37
        if (bypassDnd != existing.canBypassDnd()) goto L61;
        if (wasUndeleted == false) goto L67;
    L61:
        existing.setBypassDnd(bypassDnd);     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
        if (bypassDnd == this.mCurrentUserHasPriorityChannels) goto L64;
    L65:
        needsDndChange = true;
        goto L67
    L64:
        if (previousExistingImportance != existing.getImportance()) goto L65;
    L67:
        if (existing.getOriginalImportance() != (-1000)) goto L70;
        existing.setOriginalImportance(channel.getImportance());     // Catch: Throwable -> L37
        boolean needsPolicyFileChange2 = true;
    L71:
        if (needsPolicyFileChange2 == true) goto L143;
    L75:
        if (needsPolicyFileChange2 == false) goto L80;
        if (wasUndeleted == true) goto L80;
        this.mNotificationChannelLogger.logNotificationChannelModified(existing, uid, pkg, previousLoggingImportance, false);     // Catch: Throwable -> L73
    L73:
        th = th;
    L80:
        boolean needsPolicyFileChange3 = needsPolicyFileChange2;
    L122:
        monitor-exit(r11);     // Catch: Throwable -> L17
        if (needsDndChange == false) goto L127;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
    L127:
        return needsPolicyFileChange3;
    L143:
        updateConfig();     // Catch: Throwable -> L73
        goto L75
    L70:
        needsPolicyFileChange2 = needsPolicyFileChange;
        goto L71
    L48:
        if (existing.getGroup() != null) goto L50;
        existing.setGroup(channel.getGroup());     // Catch: Throwable -> L37
        needsPolicyFileChange = true;
        goto L50
    L33:
        wasUndeleted = false;
    L82:
        if (r.channels.size() >= 5000) goto L130;
        needsPolicyFileChange3 = true;
        if (fromTargetApp == false) goto L91;
        if (hasDndAccess == true) goto L91;
        if (r.priority != 2) goto L89;
        boolean r1 = true;
    L90:
        channel.setBypassDnd(r1);     // Catch: Throwable -> L17
        goto L91
    L89:
        r1 = false;
    L91:
        if (fromTargetApp == false) goto L97;
        channel.setLockscreenVisibility(r.visibility);     // Catch: Throwable -> L17
        if (existing == null) goto L95;
        int r2 = existing.getAllowBubbles();     // Catch: Throwable -> L17
    L96:
        channel.setAllowBubbles(r2);     // Catch: Throwable -> L17
        channel.setImportantConversation(false);     // Catch: Throwable -> L17
        goto L97
    L95:
        r2 = -1;
    L97:
        clearLockedFieldsLocked(channel);     // Catch: Throwable -> L17
        PermissionHelper.grantUriPermission(this.mUgmInternal, channel.getSound(), uid);     // Catch: Throwable -> L17 SecurityException -> L100
    L103:
        if (r.defaultAppLockedImportance == true) goto L108;
        if (r.fixedImportance == true) goto L108;
        boolean r3 = false;
    L109:
        channel.setImportanceLockedByCriticalDeviceFunction(r3);     // Catch: Throwable -> L17
        if (channel.getLockscreenVisibility() != 1) goto L113;
        channel.setLockscreenVisibility(-1000);     // Catch: Throwable -> L17
    L113:
        if (r.showBadge == true) goto L115;
        channel.setShowBadge(false);     // Catch: Throwable -> L17
    L115:
        channel.setOriginalImportance(channel.getImportance());     // Catch: Throwable -> L17
        if (channel.getParentChannelId() == null) goto L118;
        Preconditions.checkArgument(r.channels.containsKey(channel.getParentChannelId()), "Tried to create a conversation channel without a preexisting parent");     // Catch: Throwable -> L17
    L118:
        r.channels.put(channel.getId(), channel);     // Catch: Throwable -> L17
        if (channel.canBypassDnd() == this.mCurrentUserHasPriorityChannels) goto L121;
        needsDndChange = true;
    L121:
        MetricsLogger.action(getChannelLog(channel, pkg).setType(1));     // Catch: Throwable -> L17
        this.mNotificationChannelLogger.logNotificationChannelCreated(channel, uid, pkg);     // Catch: Throwable -> L17
    L108:
        r3 = true;
    L101:
        channel.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);     // Catch: Throwable -> L17
        goto L103
    L130:
        throw new IllegalStateException("Limit exceed; cannot create more channels");     // Catch: Throwable -> L131
    L23:
        if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(channel.getId()) == false) goto L26;
        monitor-exit(r11);     // Catch: Throwable -> L17
        return false;
    L134:
        throw new IllegalArgumentException("Reserved id");     // Catch: Throwable -> L131
    L17:
        th = th;
    L131:
        th = th;
        goto L135
    L5:
        if (channel.getImportance() > 5) goto L7;
        r0 = true;
        goto L8
    }

    void clearLockedFieldsLocked(NotificationChannel channel) {
        channel.unlockFields(channel.getUserLockedFields());
    }

    void unlockNotificationChannelImportance(String pkg, int uid, String updatedChannelId) {
        updatedChannelId.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L11
        NotificationChannel channel = r.channels.get(updatedChannelId);     // Catch: Throwable -> L11
        if (channel == null) goto L14;
        if (channel.isDeleted() == true) goto L14;
        channel.unlockFields(4);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalArgumentException("Channel does not exist");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public void updateNotificationChannel(String pkg, int uid, NotificationChannel updatedChannel, boolean fromUser, int callingUid, boolean fromSystemOrSystemUi) {
        updatedChannel.getClass();
        updatedChannel.getId().getClass();
        boolean needsDndChange = false;
        Object r8 = this.mLock;
        monitor-enter(r8);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L11
        NotificationChannel channel = r.channels.get(updatedChannel.getId());     // Catch: Throwable -> L11
        if (channel == null) goto L61;
        if (channel.isDeleted() == true) goto L61;
        int r4 = 1;
        if (updatedChannel.getLockscreenVisibility() != 1) goto L13;
        updatedChannel.setLockscreenVisibility(-1000);     // Catch: Throwable -> L11
    L13:
        if (fromUser == false) goto L15;
        updatedChannel.lockFields(channel.getUserLockedFields());     // Catch: Throwable -> L11
        lockFieldsForUpdateLocked(channel, updatedChannel);     // Catch: Throwable -> L11
    L17:
        if (channel.isImportanceLockedByCriticalDeviceFunction() == true) goto L19;
    L23:
        r.channels.put(updatedChannel.getId(), updatedChannel);     // Catch: Throwable -> L11
        if (onlyHasDefaultChannel(pkg, uid) == true) goto L26;
        boolean changed = false;
    L68:
        boolean changed2 = channel.equals(updatedChannel);     // Catch: Throwable -> L40
        if (changed2 == true) goto L42;
        LogMaker r3 = getChannelLog(updatedChannel, pkg);     // Catch: Throwable -> L40
        if (fromUser == true) goto L38;
        r4 = 0;
    L38:
        MetricsLogger.action(r3.setSubtype(r4));     // Catch: Throwable -> L40
        this.mNotificationChannelLogger.logNotificationChannelModified(updatedChannel, uid, pkg, NotificationChannelLogger.getLoggingImportance(channel), fromUser);     // Catch: Throwable -> L40
        boolean changed3 = true;
    L43:
        if (fromUser == false) goto L48;
        if (SystemUiSystemPropertiesFlags.getResolver().isEnabled(SystemUiSystemPropertiesFlags.NotificationFlags.PROPAGATE_CHANNEL_UPDATES_TO_CONVERSATIONS) == false) goto L48;
        updateChildrenConversationChannels(r, channel, updatedChannel);     // Catch: Throwable -> L11
    L48:
        if (updatedChannel.canBypassDnd() == this.mCurrentUserHasPriorityChannels) goto L50;
    L51:
        needsDndChange = true;
        changed3 = true;
    L52:
        monitor-exit(r8);     // Catch: Throwable -> L11
        if (needsDndChange == false) goto L56;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
    L56:
        if (changed3 == false) goto L70;
        updateConfig();
        return;
    L70:
        return;
    L50:
        if (channel.getImportance() == updatedChannel.getImportance()) goto L52;
    L42:
        changed3 = changed;
    L40:
        th = th;
    L63:
        monitor-exit(r8);     // Catch: Throwable -> L62
        throw th;
    L26:
        if (updatedChannel.canBypassDnd() == false) goto L28;
        int r5 = 2;
    L29:
        r.priority = r5;     // Catch: Throwable -> L11
        r.visibility = updatedChannel.getLockscreenVisibility();     // Catch: Throwable -> L11
        r.showBadge = updatedChannel.canShowBadge();     // Catch: Throwable -> L11
        changed = true;
        goto L68
    L28:
        r5 = 0;
        goto L29
    L19:
        if (channel.isBlockable() == true) goto L23;
        if (channel.getImportance() == 0) goto L23;
        updatedChannel.setImportance(channel.getImportance());     // Catch: Throwable -> L11
        goto L23
    L15:
        updatedChannel.unlockFields(updatedChannel.getUserLockedFields());     // Catch: Throwable -> L11
    L61:
        throw new IllegalArgumentException("Channel does not exist");     // Catch: Throwable -> L62
    L11:
        th = th;
    L62:
        th = th;
        goto L63
    }

    private void updateChildrenConversationChannels(PackagePreferences packagePreferences, NotificationChannel oldParent, NotificationChannel updatedParent) {
        if (oldParent.equals(updatedParent) == false) goto L6;
        return;
    L6:
        if (oldParent.isConversation() == false) goto L8;
        return;
    L8:
        Iterator<NotificationChannel> r0 = packagePreferences.channels.values().iterator();
    L10:
        if (r0.hasNext() == false) goto L19;
        NotificationChannel channel = r0.next();
        if (channel.isConversation() == true) goto L14;
        NotificationChannel oldParent2 = oldParent;
        NotificationChannel updatedParent2 = updatedParent;
    L18:
        oldParent = oldParent2;
        updatedParent = updatedParent2;
        goto L10
    L14:
        if (oldParent.getId().equals(channel.getParentChannelId()) == false) goto L16;
        oldParent2 = oldParent;
        updatedParent2 = updatedParent;
        maybeUpdateChildConversationChannel(packagePreferences.pkg, packagePreferences.uid, channel, oldParent2, updatedParent2);
        goto L18
    L16:
        oldParent2 = oldParent;
        updatedParent2 = updatedParent;
        goto L18
    }

    private void maybeUpdateChildConversationChannel(String pkg, int uid, NotificationChannel conversation, NotificationChannel oldParent, NotificationChannel updatedParent) {
        boolean changed = false;
        int oldLoggingImportance = NotificationChannelLogger.getLoggingImportance(conversation);
        if ((conversation.getUserLockedFields() & 1) != 0) goto L8;
        if (oldParent.canBypassDnd() == updatedParent.canBypassDnd()) goto L8;
        conversation.setBypassDnd(updatedParent.canBypassDnd());
        changed = true;
    L8:
        if ((conversation.getUserLockedFields() & 2) != 0) goto L13;
        if (oldParent.getLockscreenVisibility() == updatedParent.getLockscreenVisibility()) goto L13;
        conversation.setLockscreenVisibility(updatedParent.getLockscreenVisibility());
        changed = true;
    L13:
        if ((conversation.getUserLockedFields() & 4) != 0) goto L18;
        if (oldParent.getImportance() == updatedParent.getImportance()) goto L18;
        conversation.setImportance(updatedParent.getImportance());
        changed = true;
    L18:
        if ((conversation.getUserLockedFields() & 8) != 0) goto L25;
        if (oldParent.shouldShowLights() == updatedParent.shouldShowLights()) goto L22;
    L23:
        conversation.enableLights(updatedParent.shouldShowLights());
        conversation.setLightColor(updatedParent.getLightColor());
        changed = true;
        goto L25
    L22:
        if (oldParent.getLightColor() != updatedParent.getLightColor()) goto L23;
    L25:
        if ((conversation.getUserLockedFields() & 32) != 0) goto L30;
        if (Objects.equals(oldParent.getSound(), updatedParent.getSound()) == true) goto L30;
        conversation.setSound(updatedParent.getSound(), updatedParent.getAudioAttributes());
        changed = true;
    L30:
        if ((conversation.getUserLockedFields() & 16) != 0) goto L39;
        if (Arrays.equals(oldParent.getVibrationPattern(), updatedParent.getVibrationPattern()) == true) goto L34;
    L37:
        conversation.setVibrationPattern(updatedParent.getVibrationPattern());
        conversation.enableVibration(updatedParent.shouldVibrate());
        changed = true;
        goto L39
    L34:
        if (Objects.equals(oldParent.getVibrationEffect(), updatedParent.getVibrationEffect()) == false) goto L37;
        if (oldParent.shouldVibrate() != updatedParent.shouldVibrate()) goto L37;
    L39:
        if ((conversation.getUserLockedFields() & 128) != 0) goto L44;
        if (oldParent.canShowBadge() == updatedParent.canShowBadge()) goto L44;
        conversation.setShowBadge(updatedParent.canShowBadge());
        changed = true;
    L44:
        if ((conversation.getUserLockedFields() & 256) == 0) goto L46;
    L48:
        if (changed == false) goto L51;
        MetricsLogger.action(getChannelLog(conversation, pkg).setSubtype(1));
        this.mNotificationChannelLogger.logNotificationChannelModified(conversation, uid, pkg, oldLoggingImportance, true);
        return;
    L51:
        return;
    L46:
        if (oldParent.getAllowBubbles() == updatedParent.getAllowBubbles()) goto L48;
        conversation.setAllowBubbles(updatedParent.getAllowBubbles());
        changed = true;
        goto L48
    }

    public NotificationChannel getReservedChannel(String pkg, int uid, int type) {
        pkg.getClass();
        if (uid != (-1)) goto L5;
        return null;
    L5:
        String channelId = NotificationChannel.getChannelIdForBundleType(type);
        if (channelId != null) goto L8;
        return null;
    L8:
        NotificationChannel channel = getConversationNotificationChannel(pkg, uid, channelId, null, true, false);
        return channel;
    }

    public NotificationChannel createReservedChannel(String pkg, int uid, int type) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        String channelId = NotificationChannel.getChannelIdForBundleType(type);     // Catch: Throwable -> L9
        if (channelId != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        NotificationChannel r3 = addReservedChannelLocked(r, channelId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public NotificationChannel getNotificationChannel(String pkg, int uid, String channelId, boolean includeDeleted) {
        pkg.getClass();
        if (uid != (-1)) goto L7;
        return null;
    L7:
        return getConversationNotificationChannel(pkg, uid, channelId, null, true, includeDeleted);
    }

    @Override // com.android.server.notification.RankingConfig
    public NotificationChannel getConversationNotificationChannel(String pkg, int uid, String channelId, String conversationId, boolean returnParentIfNoConversationChannel, boolean includeDeleted) {
        Preconditions.checkNotNull(pkg);
        if (uid != (-1)) goto L6;
        return null;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L11
        if (channelId != null) goto L13;
        channelId = "miscellaneous";
    L13:
        NotificationChannel channel = null;
        if (conversationId == null) goto L16;
        channel = findConversationChannel(r, channelId, conversationId, includeDeleted);     // Catch: Throwable -> L11
    L16:
        if (channel != null) goto L25;
        if (returnParentIfNoConversationChannel == false) goto L25;
        NotificationChannel nc = r.channels.get(channelId);     // Catch: Throwable -> L11
        if (nc == null) goto L25;
        if (includeDeleted == false) goto L22;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return nc;
    L22:
        if (nc.isDeleted() == false) goto L23;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return channel;
    L11:
        th = move-exception;
        throw th;
    }

    private NotificationChannel findConversationChannel(PackagePreferences p, String parentId, String conversationId, boolean includeDeleted) {
        Iterator<NotificationChannel> r0 = p.channels.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        NotificationChannel nc = r0.next();
        if (conversationId.equals(nc.getConversationId()) == false) goto L4;
        if (parentId.equals(nc.getParentChannelId()) == false) goto L4;
        if (includeDeleted == true) goto L12;
        if (nc.isDeleted() == true) goto L4;
    L12:
        return nc;
    L14:
        return null;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean deleteNotificationChannel(String pkg, int uid, String channelId, int callingUid, boolean fromSystemOrSystemUi) {
        boolean deletedChannel = false;
        boolean channelBypassedDnd = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L9
        return false;
    L11:
        NotificationChannel channel = r.channels.get(channelId);     // Catch: Throwable -> L9
        if (channel == null) goto L14;
        channelBypassedDnd = channel.canBypassDnd();     // Catch: Throwable -> L9
        deletedChannel = deleteNotificationChannelLocked(channel, pkg, uid);     // Catch: Throwable -> L9
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L9
        if (channelBypassedDnd == false) goto L18;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
    L18:
        return deletedChannel;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean deleteNotificationChannelLocked(NotificationChannel channel, String pkg, int uid) {
        if (channel.isDeleted() == true) goto L6;
        channel.setDeleted(true);
        channel.setDeletedTimeMs(System.currentTimeMillis());
        LogMaker lm = getChannelLog(channel, pkg);
        lm.setType(2);
        MetricsLogger.action(lm);
        this.mNotificationChannelLogger.logNotificationChannelDeleted(channel, uid, pkg);
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.notification.RankingConfig
    public void permanentlyDeleteNotificationChannel(String pkg, int uid, String channelId) {
        pkg.getClass();
        channelId.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        r.channels.remove(channelId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public void permanentlyDeleteNotificationChannels(String pkg, int uid) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int N = r.channels.size() - 1;     // Catch: Throwable -> L8
        int i = N;
    L11:
        if (i < 0) goto L17;
        String key = r.channels.keyAt(i);     // Catch: Throwable -> L8
        if ("miscellaneous".equals(key) == true) goto L15;
        r.channels.remove(key);     // Catch: Throwable -> L8
    L15:
        i = i - 1;     // Catch: Throwable -> L8
        goto L11
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean shouldHideSilentStatusIcons() {
        return this.mHideSilentStatusBarIcons;
    }

    public void setHideSilentStatusIcons(boolean hide) {
        this.mHideSilentStatusBarIcons = hide;
    }

    public void updateFixedImportance(List<UserInfo> users) {
        Iterator<UserInfo> r0 = users.iterator();
    L4:
        if (r0.hasNext() == false) goto L25;
        UserInfo user = r0.next();
        List<PackageInfo> packages = this.mPm.getInstalledPackagesAsUser(0, user.getUserHandle().getIdentifier());
        Iterator<PackageInfo> r3 = packages.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        PackageInfo pi = r3.next();
        boolean fixed = this.mPermissionHelper.isPermissionFixed(pi.packageName, user.getUserHandle().getIdentifier());
        if (fixed == false) goto L7;
        Object r6 = this.mLock;
        monitor-enter(r6);
        PackagePreferences p = getOrCreatePackagePreferencesLocked(pi.packageName, pi.applicationInfo.uid);     // Catch: Throwable -> L16
        p.fixedImportance = true;     // Catch: Throwable -> L16
        Iterator<NotificationChannel> r9 = p.channels.values().iterator();     // Catch: Throwable -> L16
    L14:
        if (r9.hasNext() == false) goto L18;
        NotificationChannel channel = r9.next();     // Catch: Throwable -> L16
        channel.setImportanceLockedByCriticalDeviceFunction(true);     // Catch: Throwable -> L16
        goto L14
    L18:
        monitor-exit(r6);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void updateDefaultApps(int userId, ArraySet<String> toRemove, ArraySet<Pair<String, Integer>> toAdd) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<PackagePreferences> r1 = this.mPackagePreferences.values().iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L21;
        PackagePreferences p = r1.next();     // Catch: Throwable -> L18
        if (userId != UserHandle.getUserId(p.uid)) goto L6;
        if (toRemove == null) goto L6;
        if (toRemove.contains(p.pkg) == false) goto L6;
        p.defaultAppLockedImportance = false;     // Catch: Throwable -> L18
        if (p.fixedImportance == true) goto L6;
        Iterator<NotificationChannel> r4 = p.channels.values().iterator();     // Catch: Throwable -> L18
    L16:
        if (r4.hasNext() == false) goto L6;
        NotificationChannel channel = r4.next();     // Catch: Throwable -> L18
        channel.setImportanceLockedByCriticalDeviceFunction(false);     // Catch: Throwable -> L18
        goto L16
    L21:
        if (toAdd == null) goto L30;
        Iterator<Pair<String, Integer>> r2 = toAdd.iterator();     // Catch: Throwable -> L18
    L24:
        if (r2.hasNext() == false) goto L30;
        Pair<String, Integer> approvedApp = r2.next();     // Catch: Throwable -> L18
        PackagePreferences p2 = getOrCreatePackagePreferencesLocked((String) approvedApp.first, ((Integer) approvedApp.second).intValue());     // Catch: Throwable -> L18
        p2.defaultAppLockedImportance = true;     // Catch: Throwable -> L18
        Iterator<NotificationChannel> r5 = p2.channels.values().iterator();     // Catch: Throwable -> L18
    L27:
        if (r5.hasNext() == false) goto L24;
        NotificationChannel channel2 = r5.next();     // Catch: Throwable -> L18
        channel2.setImportanceLockedByCriticalDeviceFunction(true);     // Catch: Throwable -> L18
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public NotificationChannelGroup getNotificationChannelGroupWithChannels(String pkg, int uid, String groupId, boolean includeDeleted) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L13
        if (r == null) goto L15;
        if (groupId == null) goto L15;
        if (r.groups.containsKey(groupId) == false) goto L15;
        NotificationChannelGroup r2 = NotificationChannelGroupsHelper.getGroupWithChannels(groupId, r.channels.values(), r.groups, includeDeleted);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public NotificationChannelGroup getNotificationChannelGroup(String groupId, String pkg, int uid) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        NotificationChannelGroup r2 = r.groups.get(groupId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public ParceledListSlice<NotificationChannelGroup> getNotificationChannelGroups(String pkg, int uid, NotificationChannelGroupsHelper.Params params) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        ParceledListSlice<NotificationChannelGroup> r2 = ParceledListSlice.emptyList();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        ParceledListSlice<NotificationChannelGroup> r3 = new ParceledListSlice(NotificationChannelGroupsHelper.getGroupsWithChannels(r.channels.values(), r.groups, params));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    public List<NotificationChannel> deleteNotificationChannelGroup(String pkg, int uid, String groupId, int callingUid, boolean fromSystemOrSystemUi) {
        List<NotificationChannel> deletedChannels = new ArrayList();
        boolean groupBypassedDnd = false;
        Object r3 = this.mLock;
        monitor-enter(r3);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L12
        if (r == null) goto L26;
        if (TextUtils.isEmpty(groupId) == true) goto L26;
        NotificationChannelGroup channelGroup = r.groups.remove(groupId);     // Catch: Throwable -> L12
        if (channelGroup == null) goto L14;
        this.mNotificationChannelLogger.logNotificationChannelGroupDeleted(channelGroup, uid, pkg);     // Catch: Throwable -> L12
    L14:
        int N = r.channels.size();     // Catch: Throwable -> L12
        int i = 0;
    L15:
        if (i >= N) goto L21;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L12
        if (groupId.equals(nc.getGroup()) == false) goto L19;
        groupBypassedDnd = groupBypassedDnd | nc.canBypassDnd();     // Catch: Throwable -> L12
        deleteNotificationChannelLocked(nc, pkg, uid);     // Catch: Throwable -> L12
        deletedChannels.add(nc);     // Catch: Throwable -> L12
    L19:
        i = i + 1;     // Catch: Throwable -> L12
        goto L15
    L21:
        monitor-exit(r3);     // Catch: Throwable -> L12
        if (groupBypassedDnd == false) goto L25;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
    L25:
        return deletedChannels;
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L12
        return deletedChannels;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public Collection<NotificationChannelGroup> getNotificationChannelGroupsWithoutChannels(String pkg, int uid) {
        List<NotificationChannelGroup> groups = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return groups;
    L10:
        groups.addAll(r.groups.values());     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return groups;
    L8:
        th = move-exception;
        throw th;
    }

    public NotificationChannelGroup getGroupForChannel(String pkg, int uid, String channelId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L16
        if (p == null) goto L18;
        NotificationChannel nc = p.channels.get(channelId);     // Catch: Throwable -> L16
        if (nc == null) goto L18;
        if (nc.isDeleted() == true) goto L18;
        if (nc.getGroup() == null) goto L18;
        NotificationChannelGroup group = p.groups.get(nc.getGroup());     // Catch: Throwable -> L16
        if (group == null) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return group;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public ArrayList<ConversationChannelWrapper> getConversations(IntArray userIds, boolean onlyImportant) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<ConversationChannelWrapper> conversations = new ArrayList();     // Catch: Throwable -> L32
        Iterator<PackagePreferences> r2 = this.mPackagePreferences.values().iterator();     // Catch: Throwable -> L32
    L6:
        if (r2.hasNext() == false) goto L38;
        PackagePreferences p = r2.next();     // Catch: Throwable -> L32
        if (userIds.binarySearch(UserHandle.getUserId(p.uid)) < 0) goto L6;
        int N = p.channels.size();     // Catch: Throwable -> L32
        int i = 0;
    L10:
        if (i >= N) goto L6;
        NotificationChannel nc = p.channels.valueAt(i);     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(nc.getConversationId()) == true) goto L36;
        if (nc.isDeleted() == true) goto L36;
        if (nc.isDemoted() == true) goto L36;
        if (nc.isImportantConversation() == true) goto L20;
        if (onlyImportant == true) goto L36;
    L20:
        ConversationChannelWrapper conversation = new ConversationChannelWrapper();     // Catch: Throwable -> L32
        conversation.setPkg(p.pkg);     // Catch: Throwable -> L32
        conversation.setUid(p.uid);     // Catch: Throwable -> L32
        conversation.setNotificationChannel(nc);     // Catch: Throwable -> L32
        NotificationChannel parent = p.channels.get(nc.getParentChannelId());     // Catch: Throwable -> L32
        if (parent != null) goto L23;
        CharSequence r9 = null;
    L24:
        conversation.setParentChannelLabel(r9);     // Catch: Throwable -> L32
        boolean blockedByGroup = false;
        if (nc.getGroup() == null) goto L34;
        NotificationChannelGroup group = p.groups.get(nc.getGroup());     // Catch: Throwable -> L32
        if (group == null) goto L34;
        if (group.isBlocked() == false) goto L31;
        blockedByGroup = true;
        goto L34
    L31:
        conversation.setGroupLabel(group.getName());     // Catch: Throwable -> L32
    L34:
        if (blockedByGroup == true) goto L36;
        conversations.add(conversation);     // Catch: Throwable -> L32
        goto L36
    L23:
        r9 = parent.getName();     // Catch: Throwable -> L32
    L36:
        i = i + 1;     // Catch: Throwable -> L32
        goto L10
    L38:
        monitor-exit(r0);     // Catch: Throwable -> L32
        return conversations;
    L32:
        th = move-exception;
        throw th;
    }

    public ArrayList<ConversationChannelWrapper> getConversations(String pkg, int uid) {
        pkg.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        ArrayList<ConversationChannelWrapper> r2 = new ArrayList();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        ArrayList<ConversationChannelWrapper> conversations = new ArrayList();     // Catch: Throwable -> L9
        int N = r.channels.size();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= N) goto L31;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(nc.getConversationId()) == true) goto L29;
        if (nc.isDeleted() == true) goto L29;
        if (nc.isDemoted() == true) goto L29;
        ConversationChannelWrapper conversation = new ConversationChannelWrapper();     // Catch: Throwable -> L9
        conversation.setPkg(r.pkg);     // Catch: Throwable -> L9
        conversation.setUid(r.uid);     // Catch: Throwable -> L9
        conversation.setNotificationChannel(nc);     // Catch: Throwable -> L9
        conversation.setParentChannelLabel(r.channels.get(nc.getParentChannelId()).getName());     // Catch: Throwable -> L9
        boolean blockedByGroup = false;
        if (nc.getGroup() == null) goto L27;
        NotificationChannelGroup group = r.groups.get(nc.getGroup());     // Catch: Throwable -> L9
        if (group == null) goto L27;
        if (group.isBlocked() == false) goto L26;
        blockedByGroup = true;
        goto L27
    L26:
        conversation.setGroupLabel(group.getName());     // Catch: Throwable -> L9
    L27:
        if (blockedByGroup == true) goto L29;
        conversations.add(conversation);     // Catch: Throwable -> L9
    L29:
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return conversations;
    L9:
        th = move-exception;
        throw th;
    }

    public List<String> deleteConversations(String pkg, int uid, Set<String> conversationIds, int callingUid, boolean fromSystemOrSystemUi) {
        List<String> deletedChannelIds = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return deletedChannelIds;
    L10:
        int N = r.channels.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= N) goto L19;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L8
        if (nc.getConversationId() == null) goto L17;
        if (conversationIds.contains(nc.getConversationId()) == false) goto L17;
        nc.setDeleted(true);     // Catch: Throwable -> L8
        nc.setDeletedTimeMs(System.currentTimeMillis());     // Catch: Throwable -> L8
        LogMaker lm = getChannelLog(nc, pkg);     // Catch: Throwable -> L8
        lm.setType(2);     // Catch: Throwable -> L8
        MetricsLogger.action(lm);     // Catch: Throwable -> L8
        this.mNotificationChannelLogger.logNotificationChannelDeleted(nc, uid, pkg);     // Catch: Throwable -> L8
        deletedChannelIds.add(nc.getId());     // Catch: Throwable -> L8
    L17:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (deletedChannelIds.isEmpty() == false) goto L23;
    L26:
        return deletedChannelIds;
    L23:
        if (this.mCurrentUserHasPriorityChannels == false) goto L26;
        updateCurrentUserHasPriorityChannels(callingUid, fromSystemOrSystemUi);
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.notification.RankingConfig
    public ParceledListSlice<NotificationChannel> getNotificationChannels(String pkg, int uid, boolean includeDeleted, boolean includeBundles) {
        pkg.getClass();
        if (uid == (-1)) goto L5;
        List<NotificationChannel> channels = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L13
        if (r != null) goto L15;
        ParceledListSlice<NotificationChannel> r3 = ParceledListSlice.emptyList();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r3;
    L15:
        int N = r.channels.size();     // Catch: Throwable -> L13
        int i = 0;
    L16:
        if (i >= N) goto L26;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L13
        if (includeDeleted == false) goto L20;
    L21:
        if (includeBundles == false) goto L23;
    L24:
        channels.add(nc);     // Catch: Throwable -> L13
    L25:
        i = i + 1;     // Catch: Throwable -> L13
        goto L16
    L23:
        if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(nc.getId()) == true) goto L25;
    L20:
        if (nc.isDeleted() == true) goto L25;
    L26:
        ParceledListSlice<NotificationChannel> r4 = new ParceledListSlice(channels);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return r4;
    L13:
        th = move-exception;
        throw th;
    L5:
        return ParceledListSlice.emptyList();
    }

    protected List<NotificationChannel> getRemovedPkgNotificationChannels(String pkg, int uid) {
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);
        if (r == null) goto L10;
        if (r.channels == null) goto L10;
        return new ArrayList(r.channels.values());
    L10:
        return new ArrayList();
    }

    public ParceledListSlice<NotificationChannel> getNotificationChannelsBypassingDnd(String pkg, int uid) {
        List<NotificationChannel> channels = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = this.mPackagePreferences.get(packagePreferencesKey(pkg, uid));     // Catch: Throwable -> L14
        if (r == null) goto L17;
        Iterator<NotificationChannel> r3 = r.channels.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r3.hasNext() == false) goto L17;
        NotificationChannel channel = r3.next();     // Catch: Throwable -> L14
        if (channelIsLiveLocked(r, channel) == false) goto L8;
        if (channel.canBypassDnd() == false) goto L8;
        channels.add(channel);     // Catch: Throwable -> L14
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return new ParceledListSlice(channels);
    L14:
        th = move-exception;
        throw th;
    }

    public ArrayList<ZenBypassingApp> getPackagesBypassingDnd(int userId) {
        ArrayList<ZenBypassingApp> bypassing = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<PackagePreferences> r2 = this.mPackagePreferences.values().iterator();     // Catch: Throwable -> L21
    L6:
        if (r2.hasNext() == false) goto L31;
        PackagePreferences p = r2.next();     // Catch: Throwable -> L21
        if (UserHandle.getUserId(p.uid) != userId) goto L6;
        int totalChannelCount = p.channels.size();     // Catch: Throwable -> L21
        int bypassingCount = 0;
        if (totalChannelCount == 0) goto L6;
        Iterator<NotificationChannel> r6 = p.channels.values().iterator();     // Catch: Throwable -> L21
    L15:
        if (r6.hasNext() == false) goto L24;
        NotificationChannel channel = r6.next();     // Catch: Throwable -> L21
        if (channelIsLiveLocked(p, channel) == false) goto L15;
        if (channel.canBypassDnd() == false) goto L15;
        bypassingCount = bypassingCount + 1;     // Catch: Throwable -> L21
        goto L15
    L24:
        if (bypassingCount <= 0) goto L6;
        String r7 = p.pkg;     // Catch: Throwable -> L21
        if (totalChannelCount != bypassingCount) goto L28;
        boolean r8 = true;
    L29:
        bypassing.add(new ZenBypassingApp(r7, r8));     // Catch: Throwable -> L21
        goto L6
    L28:
        r8 = false;
        goto L29
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return bypassing;
    L21:
        th = move-exception;
        throw th;
    }

    public List<String> getPackagesWithAnyChannels(int userId) {
        List<String> pkgs = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<PackagePreferences> r2 = this.mPackagePreferences.values().iterator();     // Catch: Throwable -> L16
    L6:
        if (r2.hasNext() == false) goto L20;
        PackagePreferences p = r2.next();     // Catch: Throwable -> L16
        if (UserHandle.getUserId(p.uid) != userId) goto L6;
        Iterator<NotificationChannel> r4 = p.channels.values().iterator();     // Catch: Throwable -> L16
    L12:
        if (r4.hasNext() == false) goto L6;
        NotificationChannel c = r4.next();     // Catch: Throwable -> L16
        if (c.isDeleted() == true) goto L12;
        pkgs.add(p.pkg);     // Catch: Throwable -> L16
        goto L6
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return pkgs;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean onlyHasDefaultChannel(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L10
        if (r.channels.containsKey("miscellaneous") == true) goto L7;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L7:
        if (r.channels.size() != 1) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L13:
        if (r.channels.size() > 5) goto L25;
        Iterator<NotificationChannel> r2 = r.channels.values().iterator();     // Catch: Throwable -> L10
        if (r2.hasNext() == false) goto L27;
        NotificationChannel c = r2.next();     // Catch: Throwable -> L10
        if (NotificationChannel.SYSTEM_RESERVED_IDS.contains(c.getId()) == false) goto L19;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L19:
        if ("miscellaneous".equals(c.getId()) == true) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    public int getDeletedChannelCount(String pkg, int uid) {
        pkg.getClass();
        int deletedCount = 0;
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return 0;
    L10:
        int N = r.channels.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= N) goto L17;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L8
        if (nc.isDeleted() == false) goto L15;
        deletedCount = deletedCount + 1;     // Catch: Throwable -> L8
    L15:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return deletedCount;
    L8:
        th = move-exception;
        throw th;
    }

    public int getBlockedChannelCount(String pkg, int uid) {
        pkg.getClass();
        int blockedCount = 0;
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return 0;
    L10:
        int N = r.channels.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= N) goto L19;
        NotificationChannel nc = r.channels.valueAt(i);     // Catch: Throwable -> L8
        if (nc.isDeleted() == true) goto L17;
        if (nc.getImportance() != 0) goto L17;
        blockedCount = blockedCount + 1;     // Catch: Throwable -> L8
    L17:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return blockedCount;
    L8:
        th = move-exception;
        throw th;
    }

    void syncHasPriorityChannels() {
        if ((this.mZenModeHelper.getNotificationPolicy(UserHandle.CURRENT).state & 1) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mCurrentUserHasPriorityChannels = r0;
        updateCurrentUserHasPriorityChannels(1000, true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void updateCurrentUserHasPriorityChannels(int callingUid, boolean fromSystemOrSystemUi) {
        ArraySet<Pair<String, Integer>> candidatePkgs = new ArraySet();
        IntArray currentUserIds = this.mUserProfiles.getCurrentProfileIds();
        Object r2 = this.mLock;
        monitor-enter(r2);
        int numPackagePreferences = this.mPackagePreferences.size();     // Catch: Throwable -> L17
        int i = 0;
    L5:
        if (i >= numPackagePreferences) goto L22;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L17
        if (currentUserIds.contains(UserHandle.getUserId(r.uid)) == false) goto L20;
        Iterator<NotificationChannel> r6 = r.channels.values().iterator();     // Catch: Throwable -> L17
    L11:
        if (r6.hasNext() == false) goto L20;
        NotificationChannel channel = r6.next();     // Catch: Throwable -> L17
        if (channelIsLiveLocked(r, channel) == false) goto L11;
        if (channel.canBypassDnd() == false) goto L11;
        candidatePkgs.add(new Pair(r.pkg, Integer.valueOf(r.uid)));     // Catch: Throwable -> L17
    L20:
        i = i + 1;     // Catch: Throwable -> L17
        goto L5
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L17
        boolean haveBypassingApps = true;
        int i2 = candidatePkgs.size() - 1;
    L24:
        if (i2 < 0) goto L29;
        Pair<String, Integer> app = candidatePkgs.valueAt(i2);
        if (this.mPermissionHelper.hasPermission(((Integer) app.second).intValue()) == true) goto L28;
        candidatePkgs.removeAt(i2);
    L28:
        i2 = i2 - 1;
        goto L24
    L29:
        int i3 = candidatePkgs.size();
        if (i3 > 0) goto L34;
        haveBypassingApps = false;
    L34:
        if (this.mCurrentUserHasPriorityChannels == haveBypassingApps) goto L51;
        this.mCurrentUserHasPriorityChannels = haveBypassingApps;
        this.mZenModeHelper.updateHasPriorityChannels(UserHandle.CURRENT, this.mCurrentUserHasPriorityChannels);
        return;
    L51:
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private boolean channelIsLiveLocked(PackagePreferences pkgPref, NotificationChannel channel) {
        if (isGroupBlocked(pkgPref.pkg, pkgPref.uid, channel.getGroup()) == false) goto L6;
        return false;
    L6:
        if (channel.isDeleted() == false) goto L8;
    L12:
        return false;
    L8:
        if (channel.getImportance() == 0) goto L12;
        return true;
    }

    public void updateZenPolicy(boolean areChannelsBypassingDnd, int callingUid, boolean fromSystemOrSystemUi) {
        NotificationManager.Policy policy = this.mZenModeHelper.getNotificationPolicy(UserHandle.CURRENT);
        ZenModeHelper r1 = this.mZenModeHelper;
        UserHandle r2 = UserHandle.CURRENT;
        int r4 = policy.priorityCategories;
        int r5 = policy.priorityCallSenders;
        int r6 = policy.priorityMessageSenders;
        int r7 = policy.suppressedVisualEffects;
        if (areChannelsBypassingDnd == false) goto L5;
        int r8 = 1;
    L6:
        NotificationManager.Policy r3 = new NotificationManager.Policy(r4, r5, r6, r7, r8, policy.priorityConversationSenders);
        if (fromSystemOrSystemUi == false) goto L9;
        int r9 = 5;
    L10:
        r1.setNotificationPolicy(r2, r3, r9, callingUid);
        return;
    L9:
        r9 = 4;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }

    public boolean hasPriorityChannels() {
        return this.mCurrentUserHasPriorityChannels;
    }

    void setAppImportanceLocked(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences prefs = getOrCreatePackagePreferencesLocked(packageName, uid);     // Catch: Throwable -> L8
        if ((prefs.lockedAppFields & 1) == 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        prefs.lockedAppFields |= 1;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateConfig();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public String getNotificationDelegate(String sourcePkg, int sourceUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences prefs = getPackagePreferencesLocked(sourcePkg, sourceUid);     // Catch: Throwable -> L13
        if (prefs == null) goto L18;
        if (prefs.delegate == null) goto L18;
        if (prefs.delegate.mEnabled == true) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L15:
        String r2 = prefs.delegate.mPkg;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public void setNotificationDelegate(String sourcePkg, int sourceUid, String delegatePkg, int delegateUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences prefs = getOrCreatePackagePreferencesLocked(sourcePkg, sourceUid);     // Catch: Throwable -> L7
        prefs.delegate = new Delegate(delegatePkg, delegateUid, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void revokeNotificationDelegate(String sourcePkg, int sourceUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences prefs = getPackagePreferencesLocked(sourcePkg, sourceUid);     // Catch: Throwable -> L9
        if (prefs != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (prefs.delegate == null) goto L11;
        prefs.delegate.mEnabled = false;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isDelegateAllowed(String sourcePkg, int sourceUid, String potentialDelegatePkg, int potentialDelegateUid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences prefs = getPackagePreferencesLocked(sourcePkg, sourceUid);     // Catch: Throwable -> L9
        if (prefs != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (prefs.isValidDelegate(potentialDelegatePkg, potentialDelegateUid) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private void lockFieldsForUpdateLocked(NotificationChannel original, NotificationChannel update) {
        if (original.canBypassDnd() == update.canBypassDnd()) goto L6;
        update.lockFields(1);
    L6:
        if (original.getLockscreenVisibility() == update.getLockscreenVisibility()) goto L9;
        update.lockFields(2);
    L9:
        if (original.getImportance() == update.getImportance()) goto L12;
        update.lockFields(4);
    L12:
        if (original.shouldShowLights() == update.shouldShowLights()) goto L14;
    L15:
        update.lockFields(8);
    L17:
        if (Objects.equals(original.getSound(), update.getSound()) == true) goto L20;
        update.lockFields(32);
    L20:
        if (Arrays.equals(original.getVibrationPattern(), update.getVibrationPattern()) == true) goto L22;
    L25:
        update.lockFields(16);
    L27:
        if (original.canShowBadge() == update.canShowBadge()) goto L30;
        update.lockFields(128);
    L30:
        if (original.getAllowBubbles() == update.getAllowBubbles()) goto L33;
        update.lockFields(256);
        return;
    L33:
        return;
    L22:
        if (Objects.equals(original.getVibrationEffect(), update.getVibrationEffect()) == false) goto L25;
        if (original.shouldVibrate() == update.shouldVibrate()) goto L27;
    L14:
        if (original.getLightColor() == update.getLightColor()) goto L17;
        goto L15
    }

    public void dump(PrintWriter pw, String prefix, NotificationManagerService.DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        pw.print(prefix);
        pw.println("per-package config version: " + this.XML_VERSION);
        pw.println("PackagePreferences:");
        Object r7 = this.mLock;
        monitor-enter(r7);
        dumpPackagePreferencesLocked(pw, prefix, filter, this.mPackagePreferences, pkgPermissions);     // Catch: Throwable -> L7
        pw.println("Restored without uid:");     // Catch: Throwable -> L7
        dumpPackagePreferencesLocked(pw, prefix, filter, this.mRestoredWithoutUids, null);     // Catch: Throwable -> L7
        monitor-exit(r7);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void dump(ProtoOutputStream proto, NotificationManagerService.DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        dumpPackagePreferencesLocked(proto, 2246267895810L, filter, this.mPackagePreferences, pkgPermissions);     // Catch: Throwable -> L7
        dumpPackagePreferencesLocked(proto, 2246267895811L, filter, this.mRestoredWithoutUids, null);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void dumpPackagePreferencesLocked(PrintWriter pw, String prefix, NotificationManagerService.DumpFilter filter, ArrayMap<String, PackagePreferences> packagePreferences, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> packagePermissions) {
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle = null;
        if (packagePermissions == null) goto L5;
        pkgsWithPermissionsToHandle = packagePermissions.keySet();
    L5:
        int N = packagePreferences.size();
        int i = 0;
    L6:
        String r11 = "INVALID_UID";
        if (i >= N) goto L54;
        PackagePreferences r = packagePreferences.valueAt(i);
        if (filter.matches(r.pkg) == false) goto L52;
        pw.print(prefix);
        pw.print("  AppSettings: ");
        pw.print(r.pkg);
        pw.print(" (");
        if (r.uid == (-1)) goto L14;
        r11 = Integer.toString(r.uid);
    L14:
        pw.print(r11);
        pw.print(')');
        if (r.allNotificationSilent == false) goto L17;
        pw.print(" allNotificationSilent=");
        pw.print(r.allNotificationSilent);
    L17:
        Pair<Integer, String> key = new Pair(Integer.valueOf(r.uid), r.pkg);
        if (packagePermissions == null) goto L27;
        if (pkgsWithPermissionsToHandle.contains(key) == false) goto L27;
        pw.print(" importance=");
        if (((Boolean) packagePermissions.get(key).first).booleanValue() == false) goto L24;
        int r16 = 3;
    L25:
        pw.print(NotificationListenerService.Ranking.importanceToString(r16));
        pw.print(" userSet=");
        pw.print(packagePermissions.get(key).second);
        pkgsWithPermissionsToHandle.remove(key);
        goto L27
    L24:
        r16 = 0;
    L27:
        if (r.priority == 0) goto L30;
        pw.print(" priority=");
        pw.print(Notification.priorityToString(r.priority));
    L30:
        if (r.visibility == (-1000)) goto L33;
        pw.print(" visibility=");
        pw.print(Notification.visibilityToString(r.visibility));
    L33:
        if (r.showBadge == true) goto L36;
        pw.print(" showBadge=");
        pw.print(r.showBadge);
    L36:
        if (r.defaultAppLockedImportance == false) goto L39;
        pw.print(" defaultAppLocked=");
        pw.print(r.defaultAppLockedImportance);
    L39:
        if (r.fixedImportance == false) goto L41;
        pw.print(" fixedImportance=");
        pw.print(r.fixedImportance);
    L41:
        pw.println();
        if (r.delegate == null) goto L44;
        pw.print(prefix);
        pw.printf("    Delegate: %s (%s) enabled=%s", new Object[]{r.delegate.mPkg, Integer.valueOf(r.delegate.mUid), Boolean.valueOf(r.delegate.mEnabled)});
        pw.println();
    L44:
        Iterator<NotificationChannel> r6 = r.channels.values().iterator();
    L46:
        if (r6.hasNext() == false) goto L48;
        NotificationChannel channel = r6.next();
        pw.print(prefix);
        channel.dump(pw, "    ", filter.redact);
        goto L46
    L48:
        Iterator<NotificationChannelGroup> r7 = r.groups.values().iterator();
    L50:
        if (r7.hasNext() == false) goto L52;
        NotificationChannelGroup group = r7.next();
        pw.print(prefix);
        pw.print("  ");
        pw.print("  ");
        pw.println(group);
    L52:
        i = i + 1;
        goto L6
    L54:
        if (pkgsWithPermissionsToHandle == null) goto L70;
        Iterator<Pair<Integer, String>> r5 = pkgsWithPermissionsToHandle.iterator();
    L57:
        if (r5.hasNext() == false) goto L80;
        Pair<Integer, String> p = r5.next();
        if (filter.matches((String) p.second) == false) goto L57;
        pw.print(prefix);
        pw.print("  AppSettings: ");
        pw.print((String) p.second);
        pw.print(" (");
        if (((Integer) p.first).intValue() != (-1)) goto L63;
        String r8 = "INVALID_UID";
    L64:
        pw.print(r8);
        pw.print(')');
        pw.print(" importance=");
        if (((Boolean) packagePermissions.get(p).first).booleanValue() == false) goto L67;
        int r9 = 3;
    L68:
        pw.print(NotificationListenerService.Ranking.importanceToString(r9));
        pw.print(" userSet=");
        pw.print(packagePermissions.get(p).second);
        pw.println();
        goto L57
    L67:
        r9 = 0;
        goto L68
    L63:
        r8 = Integer.toString(((Integer) p.first).intValue());
        goto L64
    L80:
        return;
    }

    private void dumpPackagePreferencesLocked(ProtoOutputStream proto, long fieldId, NotificationManagerService.DumpFilter filter, ArrayMap<String, PackagePreferences> packagePreferences, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> packagePermissions) {
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle = null;
        if (packagePermissions == null) goto L5;
        pkgsWithPermissionsToHandle = packagePermissions.keySet();
    L5:
        int N = packagePreferences.size();
        int i = 0;
    L7:
        if (i >= N) goto L30;
        PackagePreferences r = packagePreferences.valueAt(i);
        if (filter.matches(r.pkg) == false) goto L28;
        long fToken = proto.start(fieldId);
        proto.write(1138166333441L, r.pkg);
        proto.write(1120986464258L, r.uid);
        Pair<Integer, String> key = new Pair(Integer.valueOf(r.uid), r.pkg);
        if (packagePermissions != null) goto L13;
    L19:
        proto.write(1120986464260L, r.priority);
        proto.write(1172526071813L, r.visibility);
        proto.write(1133871366150L, r.showBadge);
        Iterator<NotificationChannel> r6 = r.channels.values().iterator();
    L21:
        if (r6.hasNext() == false) goto L23;
        NotificationChannel channel = r6.next();
        channel.dumpDebug(proto, 2246267895815L);
        goto L21
    L23:
        Iterator<NotificationChannelGroup> r7 = r.groups.values().iterator();
    L25:
        if (r7.hasNext() == false) goto L27;
        NotificationChannelGroup group = r7.next();
        group.dumpDebug(proto, 2246267895816L);
        goto L25
    L27:
        proto.end(fToken);
        goto L28
    L13:
        if (pkgsWithPermissionsToHandle.contains(key) == false) goto L19;
        if (((Boolean) packagePermissions.get(key).first).booleanValue() == false) goto L17;
        int r8 = 3;
    L18:
        proto.write(1172526071811L, r8);
        pkgsWithPermissionsToHandle.remove(key);
        goto L19
    L17:
        r8 = 0;
    L28:
        i = i + 1;
        goto L7
    L30:
        if (pkgsWithPermissionsToHandle == null) goto L43;
        Iterator<Pair<Integer, String>> r5 = pkgsWithPermissionsToHandle.iterator();
    L33:
        if (r5.hasNext() == false) goto L55;
        Pair<Integer, String> p = r5.next();
        if (filter.matches((String) p.second) == false) goto L33;
        long fToken2 = proto.start(fieldId);
        proto.write(1138166333441L, (String) p.second);
        proto.write(1120986464258L, ((Integer) p.first).intValue());
        if (((Boolean) packagePermissions.get(p).first).booleanValue() == false) goto L39;
        int r15 = 3;
    L40:
        proto.write(1172526071811L, r15);
        proto.end(fToken2);
        goto L33
    L39:
        r15 = 0;
        goto L40
    L55:
        return;
    }

    int getFsiState(String pkg, int uid, boolean requestedFSIPermission) {
        if (requestedFSIPermission == true) goto L5;
        return 0;
    L5:
        AttributionSource attributionSource = new AttributionSource.Builder(uid).setPackageName(pkg).build();
        int result = this.mPermissionManager.checkPermissionForPreflight("android.permission.USE_FULL_SCREEN_INTENT", attributionSource);
        if (result != 0) goto L9;
        return 1;
    L9:
        return 2;
    }

    boolean isFsiPermissionUserSet(String pkg, int uid, int fsiState, int currentPermissionFlags) {
        if (fsiState != 0) goto L6;
        return false;
    L6:
        if ((currentPermissionFlags & 1) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void pullPackagePreferencesStats(List<StatsEvent> events, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        pullPackagePreferencesStats(events, pkgPermissions, new ArrayMap());
    }

    public void pullPackagePreferencesStats(List<StatsEvent> events, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions, Map<String, Set<Integer>> pkgAdjustmentKeyTypes) {
        if (pkgPermissions == null) goto L5;
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle = pkgPermissions.keySet();
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle2 = pkgsWithPermissionsToHandle;
    L6:
        Object r6 = this.mLock;
        monitor-enter(r6);
        int pulledEvents = 0;
        int pulledEvents2 = 0;
    L45:
        int r9 = 0;
        if (pulledEvents2 >= this.mPackagePreferences.size()) goto L29;
        if (pulledEvents > 1000) goto L29;
        pulledEvents = pulledEvents + 1;     // Catch: Throwable -> L22
        PackagePreferences r = this.mPackagePreferences.valueAt(pulledEvents2);     // Catch: Throwable -> L22
        Pair<Integer, String> key = new Pair(Integer.valueOf(r.uid), r.pkg);     // Catch: Throwable -> L22
        if (pkgPermissions != null) goto L16;
    L24:
        boolean importanceIsUserSet = false;
        int importance = -1000;
    L25:
        boolean requestedFSIPermission = this.mPermissionHelper.hasRequestedPermission("android.permission.USE_FULL_SCREEN_INTENT", r.pkg, r.uid);     // Catch: Throwable -> L22
        int fsiState = getFsiState(r.pkg, r.uid, requestedFSIPermission);     // Catch: Throwable -> L22
        int currentPermissionFlags = this.mPm.getPermissionFlags("android.permission.USE_FULL_SCREEN_INTENT", r.pkg, UserHandle.getUserHandleForUid(r.uid));     // Catch: Throwable -> L22
        boolean fsiIsUserSet = isFsiPermissionUserSet(r.pkg, r.uid, fsiState, currentPermissionFlags);     // Catch: Throwable -> L22
        if (pkgAdjustmentKeyTypes.keySet().size() <= 0) goto L28;
        Slog.w(TAG, "Pkg adjustment types improperly allowed without flag set");     // Catch: Throwable -> L22
    L28:
        int[] allowedBundleTypes = getAllowedTypesForPackage(pkgAdjustmentKeyTypes, r.pkg);     // Catch: Throwable -> L22
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.PACKAGE_NOTIFICATION_PREFERENCES, r.uid, importance, r.visibility, r.lockedAppFields, importanceIsUserSet, fsiState, fsiIsUserSet, allowedBundleTypes));     // Catch: Throwable -> L22
        pulledEvents2 = pulledEvents2 + 1;     // Catch: Throwable -> L22
        goto L45
    L16:
        if (pkgsWithPermissionsToHandle2.contains(key) == false) goto L24;
        Pair<Boolean, Boolean> permissionPair = pkgPermissions.get(key);     // Catch: Throwable -> L22
        if (((Boolean) permissionPair.first).booleanValue() == false) goto L21;
        r9 = 3;
    L21:
        int importance2 = r9;
        boolean importanceIsUserSet2 = ((Boolean) permissionPair.second).booleanValue();     // Catch: Throwable -> L22
        pkgsWithPermissionsToHandle2.remove(key);     // Catch: Throwable -> L22
        importanceIsUserSet = importanceIsUserSet2;
        importance = importance2;
    L29:
        monitor-exit(r6);     // Catch: Throwable -> L22
        if (pkgPermissions == null) goto L42;
        Iterator<Pair<Integer, String>> r0 = pkgsWithPermissionsToHandle2.iterator();
    L33:
        if (r0.hasNext() == false) goto L55;
        Pair<Integer, String> p = r0.next();
        if (pulledEvents > 1000) goto L56;
        pulledEvents = pulledEvents + 1;
        int[] allowedBundleTypes2 = getAllowedTypesForPackage(pkgAdjustmentKeyTypes, (String) p.second);
        int r13 = ((Integer) p.first).intValue();
        if (((Boolean) pkgPermissions.get(p).first).booleanValue() == false) goto L40;
        int r14 = 3;
    L41:
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.PACKAGE_NOTIFICATION_PREFERENCES, r13, r14, -1000, 0, ((Boolean) pkgPermissions.get(p).second).booleanValue(), 0, false, allowedBundleTypes2));
        goto L33
    L40:
        r14 = 0;
        goto L41
    L56:
        return;
    L55:
        return;
    L42:
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        pkgsWithPermissionsToHandle2 = null;
        goto L6
    }

    private int[] getAllowedTypesForPackage(Map<String, Set<Integer>> pkgAdjustmentKeyTypes, String pkg) {
        int[] allowedBundleTypes = new int[0];
        return allowedBundleTypes;
    }

    public void pullPackageChannelPreferencesStats(List<StatsEvent> events) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        int totalChannelsPulled = 0;
        int i = 0;
    L36:
    L26:
        th = th;
    L33:
        monitor-exit(r2);     // Catch: Throwable -> L24
        throw th;
    L6:
        if (i >= this.mPackagePreferences.size()) goto L31;
        if (totalChannelsPulled > 2000) goto L31;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L26
        Iterator<NotificationChannel> r6 = r.channels.values().iterator();     // Catch: Throwable -> L26
    L12:
        if (r6.hasNext() == false) goto L35;
        NotificationChannel channel = r6.next();     // Catch: Throwable -> L26
        totalChannelsPulled = totalChannelsPulled + 1;     // Catch: Throwable -> L26
        if (totalChannelsPulled > 2000) goto L35;
        int r9 = r.uid;     // Catch: Throwable -> L26
        String r10 = channel.getId();     // Catch: Throwable -> L26
        String r11 = channel.getName().toString();     // Catch: Throwable -> L26
        String r12 = channel.getDescription();     // Catch: Throwable -> L26
        int r13 = channel.getImportance();     // Catch: Throwable -> L26
        int r14 = channel.getUserLockedFields();     // Catch: Throwable -> L26
        boolean r15 = channel.isDeleted();     // Catch: Throwable -> L26
        if (channel.getConversationId() == null) goto L20;
        boolean r8 = true;
    L19:
        boolean r16 = r8;
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_PREFERENCES, r9, r10, r11, r12, r13, r14, r15, r16, channel.isDemoted(), channel.isImportantConversation()));     // Catch: Throwable -> L24
        goto L12
    L20:
        r8 = false;
    L35:
        i = i + 1;     // Catch: Throwable -> L24
    L24:
        th = th;
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L24
    }

    public void pullPackageChannelGroupPreferencesStats(List<StatsEvent> events) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int totalGroupsPulled = 0;
        int i = 0;
    L24:
    L17:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPackagePreferences.size()) goto L20;
        if (totalGroupsPulled > 1000) goto L20;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L17
        Iterator<NotificationChannelGroup> r5 = r.groups.values().iterator();     // Catch: Throwable -> L17
    L12:
        if (r5.hasNext() == false) goto L19;
        NotificationChannelGroup groupChannel = r5.next();     // Catch: Throwable -> L17
        totalGroupsPulled = totalGroupsPulled + 1;     // Catch: Throwable -> L17
        if (totalGroupsPulled > 1000) goto L19;
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.PACKAGE_NOTIFICATION_CHANNEL_GROUP_PREFERENCES, r.uid, groupChannel.getId(), groupChannel.getName().toString(), groupChannel.getDescription(), groupChannel.isBlocked(), groupChannel.getUserLockedFields()));     // Catch: Throwable -> L17
    L19:
        i = i + 1;     // Catch: Throwable -> L17
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L17
    }

    public JSONObject dumpJson(NotificationManagerService.DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        JSONObject r0 = new JSONObject();
        JSONArray r1 = new JSONArray();
        Object r6 = this.mLock;
        monitor-enter(r6);
        r0.put("noUid", this.mRestoredWithoutUids.size());     // Catch: Throwable -> L6 JSONException -> L8
    L6:
        th = move-exception;
        throw th;
    L9:
        monitor-exit(r6);     // Catch: Throwable -> L6
        if (pkgPermissions == null) goto L13;
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle = pkgPermissions.keySet();
        Set<Pair<Integer, String>> pkgsWithPermissionsToHandle2 = pkgsWithPermissionsToHandle;
    L14:
        Object r8 = this.mLock;
        monitor-enter(r8);
        int N = this.mPackagePreferences.size();     // Catch: Throwable -> L24
        int i = 0;
    L17:
        int r10 = 0;
        if (i >= N) goto L60;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L24
        if (filter == null) goto L26;
        if (filter.matches(r.pkg) == true) goto L26;
    L58:
        i = i + 1;     // Catch: Throwable -> L24
    L26:
        JSONObject PackagePreferences2 = new JSONObject();     // Catch: Throwable -> L24
        PackagePreferences2.put("userId", UserHandle.getUserId(r.uid));     // Catch: Throwable -> L24 JSONException -> L37
        PackagePreferences2.put("packageName", r.pkg);     // Catch: Throwable -> L24 JSONException -> L37
        Pair<Integer, String> key = new Pair(Integer.valueOf(r.uid), r.pkg);     // Catch: Throwable -> L24 JSONException -> L37
        if (pkgPermissions == null) goto L40;
        if (pkgsWithPermissionsToHandle2.contains(key) == false) goto L40;
        if (((Boolean) pkgPermissions.get(key).first).booleanValue() == false) goto L36;
        r10 = 3;
    L36:
        PackagePreferences2.put(ATT_IMPORTANCE, NotificationListenerService.Ranking.importanceToString(r10));     // Catch: Throwable -> L24 JSONException -> L37
        pkgsWithPermissionsToHandle2.remove(key);     // Catch: Throwable -> L24 JSONException -> L37
    L40:
        if (r.priority == 0) goto L43;
        PackagePreferences2.put(ATT_PRIORITY, Notification.priorityToString(r.priority));     // Catch: Throwable -> L24 JSONException -> L37
    L43:
        if (r.visibility == (-1000)) goto L46;
        PackagePreferences2.put(ATT_VISIBILITY, Notification.visibilityToString(r.visibility));     // Catch: Throwable -> L24 JSONException -> L37
    L46:
        if (r.showBadge == true) goto L48;
        PackagePreferences2.put("showBadge", Boolean.valueOf(r.showBadge));     // Catch: Throwable -> L24 JSONException -> L37
    L48:
        JSONArray channels = new JSONArray();     // Catch: Throwable -> L24 JSONException -> L37
        Iterator<NotificationChannel> r11 = r.channels.values().iterator();     // Catch: Throwable -> L24 JSONException -> L37
    L50:
        if (r11.hasNext() == false) goto L52;
        NotificationChannel channel = r11.next();     // Catch: Throwable -> L24 JSONException -> L37
        channels.put(channel.toJson());     // Catch: Throwable -> L24 JSONException -> L37
        goto L50
    L52:
        PackagePreferences2.put("channels", channels);     // Catch: Throwable -> L24 JSONException -> L37
        JSONArray groups = new JSONArray();     // Catch: Throwable -> L24 JSONException -> L37
        Iterator<NotificationChannelGroup> r14 = r.groups.values().iterator();     // Catch: Throwable -> L24 JSONException -> L37
    L54:
        if (r14.hasNext() == false) goto L56;
        NotificationChannelGroup group = r14.next();     // Catch: Throwable -> L24 JSONException -> L37
        groups.put(group.toJson());     // Catch: Throwable -> L24 JSONException -> L37
        key = key;
        goto L54
    L56:
        PackagePreferences2.put("groups", groups);     // Catch: Throwable -> L24 JSONException -> L37
    L57:
        r1.put(PackagePreferences2);     // Catch: Throwable -> L24
        goto L58
    L60:
        monitor-exit(r8);     // Catch: Throwable -> L24
        if (pkgsWithPermissionsToHandle2 == null) goto L90;
        Iterator<Pair<Integer, String>> r7 = pkgsWithPermissionsToHandle2.iterator();
    L64:
        if (r7.hasNext() == false) goto L90;
        Pair<Integer, String> p = r7.next();
        if (filter == null) goto L69;
        if (filter.matches((String) p.second) == false) goto L64;
    L69:
        JSONObject PackagePreferences3 = new JSONObject();
        PackagePreferences3.put("userId", UserHandle.getUserId(((Integer) p.first).intValue()));     // Catch: JSONException -> L76
        PackagePreferences3.put("packageName", p.second);     // Catch: JSONException -> L76
        if (((Boolean) pkgPermissions.get(p).first).booleanValue() == false) goto L73;
        int r12 = 3;
    L74:
        PackagePreferences3.put(ATT_IMPORTANCE, NotificationListenerService.Ranking.importanceToString(r12));     // Catch: JSONException -> L76
        goto L77
    L73:
        r12 = 0;
    L77:
        r1.put(PackagePreferences3);
    L90:
        r0.put("PackagePreferencess", r1);     // Catch: JSONException -> L81
    L82:
        return r0;
    L24:
        th = move-exception;
        throw th;
    L13:
        pkgsWithPermissionsToHandle2 = null;
        goto L14
    }

    public JSONArray dumpBansJson(NotificationManagerService.DumpFilter filter, ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        JSONArray bans = new JSONArray();
        Map<Integer, String> packageBans = getPermissionBasedPackageBans(pkgPermissions);
        Iterator<Map.Entry<Integer, String>> r2 = packageBans.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<Integer, String> ban = r2.next();
        int userId = UserHandle.getUserId(ban.getKey().intValue());
        String packageName = ban.getValue();
        if (filter == null) goto L9;
        if (filter.matches(packageName) == false) goto L4;
    L9:
        JSONObject banJson = new JSONObject();
        banJson.put("userId", userId);     // Catch: JSONException -> L12
        banJson.put("packageName", packageName);     // Catch: JSONException -> L12
    L14:
        bans.put(banJson);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L16:
        return bans;
    }

    public Map<Integer, String> getPackageBans() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int N = this.mPackagePreferences.size();     // Catch: Throwable -> L9
        ArrayMap<Integer, String> packageBans = new ArrayMap(N);     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L13;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L9
        if (r.importance != 0) goto L11;
        packageBans.put(Integer.valueOf(r.uid), r.pkg);     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return packageBans;
    L9:
        th = move-exception;
        throw th;
    }

    protected Map<Integer, String> getPermissionBasedPackageBans(ArrayMap<Pair<Integer, String>, Pair<Boolean, Boolean>> pkgPermissions) {
        ArrayMap<Integer, String> packageBans = new ArrayMap();
        if (pkgPermissions == null) goto L11;
        Iterator<Pair<Integer, String>> r1 = pkgPermissions.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Pair<Integer, String> p = r1.next();
        if (((Boolean) pkgPermissions.get(p).first).booleanValue() == true) goto L6;
        packageBans.put((Integer) p.first, (String) p.second);
    L11:
        return packageBans;
    }

    public JSONArray dumpChannelsJson(NotificationManagerService.DumpFilter filter) {
        JSONArray channels = new JSONArray();
        Map<String, Integer> packageChannels = getPackageChannels();
        Iterator<Map.Entry<String, Integer>> r2 = packageChannels.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        Map.Entry<String, Integer> channelCount = r2.next();
        String packageName = channelCount.getKey();
        if (filter == null) goto L9;
        if (filter.matches(packageName) == false) goto L4;
    L9:
        JSONObject channelCountJson = new JSONObject();
        channelCountJson.put("packageName", packageName);     // Catch: JSONException -> L12
        channelCountJson.put("channelCount", channelCount.getValue());     // Catch: JSONException -> L12
    L14:
        channels.put(channelCountJson);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L16:
        return channels;
    }

    private Map<String, Integer> getPackageChannels() {
        ArrayMap<String, Integer> packageChannels = new ArrayMap();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L22:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mPackagePreferences.size()) goto L18;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L14
        int channelCount = 0;
        int j = 0;
    L9:
        if (j >= r.channels.size()) goto L16;
        if (r.channels.valueAt(j).isDeleted() == true) goto L13;
        channelCount = channelCount + 1;     // Catch: Throwable -> L14
    L13:
        j = j + 1;     // Catch: Throwable -> L14
        goto L9
    L16:
        packageChannels.put(r.pkg, Integer.valueOf(channelCount));     // Catch: Throwable -> L14
        i = i + 1;     // Catch: Throwable -> L14
        goto L22
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return packageChannels;
    }

    public void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int N = this.mPackagePreferences.size();     // Catch: Throwable -> L10
        int i = N - 1;     // Catch: Throwable -> L10
    L6:
        if (i < 0) goto L14;
        PackagePreferences PackagePreferences2 = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L10
        if (UserHandle.getUserId(PackagePreferences2.uid) != userId) goto L12;
        this.mPackagePreferences.removeAt(i);     // Catch: Throwable -> L10
    L12:
        i = i - 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void onLocaleChanged(Context context, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int N = this.mPackagePreferences.size();     // Catch: Throwable -> L12
        int i = 0;
    L6:
        if (i >= N) goto L16;
        PackagePreferences PackagePreferences2 = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L12
        if (UserHandle.getUserId(PackagePreferences2.uid) != userId) goto L14;
        if (PackagePreferences2.channels.containsKey("miscellaneous") == false) goto L14;
        PackagePreferences2.channels.get("miscellaneous").setName(context.getResources().getString(R.string.duration_years_shortest_future));     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public boolean onPackagesChanged(boolean removingPackage, int changeUserId, String[] pkgList, int[] uidList) {
        String[] r3 = pkgList;
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.length != 0) goto L8;
        return false;
    L8:
        if (removingPackage == false) goto L20;
        int size = Math.min(r3.length, uidList.length);
        int i = 0;
        boolean updated = false;
    L10:
        if (i >= size) goto L80;
        String pkg = r3[i];
        int uid = uidList[i];
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mPackagePreferences.remove(packagePreferencesKey(pkg, uid));     // Catch: Throwable -> L16
        this.mRestoredWithoutUids.remove(unrestoredPackageKey(pkg, changeUserId));     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        updated = true;
        i = i + 1;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L80:
        if (updated == false) goto L82;
        updateConfig();
    L82:
        return updated;
    L20:
        int r6 = r3.length;
        boolean updated2 = false;
        int r8 = 0;
    L22:
        if (r8 >= r6) goto L79;
        String pkg2 = r3[r8];
        int uid2 = this.mPm.getPackageUidAsUser(pkg2, changeUserId);     // Catch: Exception -> L68
        PermissionHelper.PackagePermission p = null;
        Object r12 = this.mLock;     // Catch: Exception -> L68
        monitor-enter(r12);     // Catch: Exception -> L68
        PackagePreferences r = this.mRestoredWithoutUids.get(unrestoredPackageKey(pkg2, changeUserId));     // Catch: Throwable -> L46
        if (r == null) goto L58;
        r.uid = uid2;     // Catch: Throwable -> L46
        this.mRestoredWithoutUids.remove(unrestoredPackageKey(pkg2, changeUserId));     // Catch: Throwable -> L46
        this.mPackagePreferences.put(packagePreferencesKey(r.pkg, r.uid), r);     // Catch: Throwable -> L46
        Iterator<NotificationChannel> r13 = r.channels.values().iterator();     // Catch: Throwable -> L46
    L30:
        if (r13.hasNext() == false) goto L50;
        NotificationChannel channel = r13.next();     // Catch: Throwable -> L46
        if (channel.isSoundRestored() == true) goto L48;
        Uri uri = channel.getSound();     // Catch: Throwable -> L46
        Uri restoredUri = channel.restoreSoundUri(this.mContext, uri, true, channel.getAudioAttributes().getUsage());     // Catch: Throwable -> L42
        if (Settings.System.DEFAULT_NOTIFICATION_URI.equals(restoredUri) == false) goto L44;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L42
        int r17 = r6;
        r15.append("Could not restore sound: ");     // Catch: Throwable -> L40
        r15.append(uri);     // Catch: Throwable -> L40
        r15.append(" for channel: ");     // Catch: Throwable -> L40
        r15.append(channel);     // Catch: Throwable -> L40
        Slog.w(TAG, r15.toString());     // Catch: Throwable -> L40
    L45:
        channel.setSound(restoredUri, channel.getAudioAttributes());     // Catch: Throwable -> L40
    L49:
        r6 = r17;
    L40:
        th = th;
    L66:
        monitor-exit(r12);     // Catch: Throwable -> L40
        throw th;     // Catch: Exception -> L63
    L63:
        e = e;
    L70:
        Slog.e(TAG, "could not restore " + pkg2, e);
    L87:
        PackagePreferences fullPackagePreferences = getPackagePreferencesLocked(pkg2, this.mPm.getPackageUidAsUser(pkg2, changeUserId));     // Catch: PackageManager.NameNotFoundException -> L75
        if (fullPackagePreferences == null) goto L78;
        updated2 = updated2 | createDefaultChannelIfNeededLocked(fullPackagePreferences);     // Catch: PackageManager.NameNotFoundException -> L75
        updated2 = updated2 | deleteDefaultChannelIfNeededLocked(fullPackagePreferences);
    L78:
        r8 = r8 + 1;
        r3 = pkgList;
        r6 = r17;
        goto L22
    L44:
        r17 = r6;
    L42:
        th = th;
        r17 = r6;
        goto L66
    L48:
        r17 = r6;
        goto L49
    L50:
        r17 = r6;
        if (r.migrateToPm == false) goto L57;
        String r5 = r.pkg;     // Catch: Throwable -> L40
        int r7 = UserHandle.getUserId(r.uid);     // Catch: Throwable -> L40
        if (r.importance == 0) goto L55;
        boolean r16 = true;
    L56:
        p = new PermissionHelper.PackagePermission(r5, r7, r16, hasUserConfiguredSettings(r));     // Catch: Throwable -> L40
        goto L57
    L55:
        r16 = false;
    L57:
        updated2 = true;
    L59:
        monitor-exit(r12);     // Catch: Throwable -> L40
        if (p == null) goto L87;
        this.mPermissionHelper.setNotificationPermission(p);     // Catch: Exception -> L63
        goto L87
    L58:
        r17 = r6;
    L46:
        th = th;
        r17 = r6;
    L68:
        e = e;
        r17 = r6;
        goto L70
    L79:
        updated = updated2;
        goto L80
    }

    public void clearData(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences p = getPackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L7
        if (p == null) goto L9;
        p.channels = new ArrayMap();     // Catch: Throwable -> L7
        p.groups = new ArrayMap();     // Catch: Throwable -> L7
        p.delegate = null;     // Catch: Throwable -> L7
        p.lockedAppFields = 0;     // Catch: Throwable -> L7
        p.bubblePreference = 0;     // Catch: Throwable -> L7
        p.importance = -1000;     // Catch: Throwable -> L7
        p.priority = 0;     // Catch: Throwable -> L7
        p.visibility = -1000;     // Catch: Throwable -> L7
        p.showBadge = true;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private LogMaker getChannelLog(NotificationChannel channel, String pkg) {
        return new LogMaker(856).setType(6).setPackageName(pkg).addTaggedData(857, channel.getId()).addTaggedData(858, Integer.valueOf(channel.getImportance()));
    }

    private LogMaker getChannelGroupLog(String groupId, String pkg) {
        return new LogMaker(859).setType(6).addTaggedData(860, groupId).setPackageName(pkg);
    }

    public void updateMediaNotificationFilteringEnabled() {
        boolean newValue = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "qs_media_controls", 1) > 0) goto L5;
    L7:
        newValue = false;
    L9:
        if (newValue == this.mIsMediaNotificationFilteringEnabled) goto L12;
        this.mIsMediaNotificationFilteringEnabled = newValue;
        updateConfig();
        return;
    L12:
        return;
    L5:
        if (this.mContext.getResources().getBoolean(R.bool.config_restart_radio_on_pdp_fail_regular_deactivation) == false) goto L7;
        goto L7
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean isMediaNotificationFilteringEnabled() {
        return this.mIsMediaNotificationFilteringEnabled;
    }

    public void updateBadgingEnabled() {
        if (this.mBadgingEnabled != null) goto L5;
        this.mBadgingEnabled = new SparseBooleanArray();
    L5:
        boolean changed = false;
        int index = 0;
    L7:
        if (index >= this.mBadgingEnabled.size()) goto L18;
        int userId = this.mBadgingEnabled.keyAt(index);
        boolean oldValue = this.mBadgingEnabled.get(userId);
        boolean r6 = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "notification_badging", 1, userId) == 0) goto L11;
        boolean newValue = true;
    L12:
        this.mBadgingEnabled.put(userId, newValue);
        if (oldValue != newValue) goto L16;
        r6 = false;
    L16:
        changed = changed | r6;
        index = index + 1;
        goto L7
    L11:
        newValue = false;
        goto L12
    L18:
        if (changed == false) goto L24;
        updateConfig();
        return;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean badgingEnabled(UserHandle userHandle) {
        int userId = userHandle.getIdentifier();
        boolean r2 = false;
        if (userId != (-1)) goto L6;
        return false;
    L6:
        if (this.mBadgingEnabled.indexOfKey(userId) >= 0) goto L12;
        SparseBooleanArray r1 = this.mBadgingEnabled;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "notification_badging", 1, userId) == 0) goto L10;
        r2 = true;
    L10:
        r1.put(userId, r2);
    L12:
        return this.mBadgingEnabled.get(userId, true);
    }

    public void updateBubblesEnabled() {
        if (this.mBubblesEnabled != null) goto L5;
        this.mBubblesEnabled = new SparseBooleanArray();
    L5:
        boolean changed = false;
        int index = 0;
    L7:
        if (index >= this.mBubblesEnabled.size()) goto L18;
        int userId = this.mBubblesEnabled.keyAt(index);
        boolean oldValue = this.mBubblesEnabled.get(userId);
        boolean r6 = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "notification_bubbles", 1, userId) == 0) goto L11;
        boolean newValue = true;
    L12:
        this.mBubblesEnabled.put(userId, newValue);
        if (oldValue != newValue) goto L16;
        r6 = false;
    L16:
        changed = changed | r6;
        index = index + 1;
        goto L7
    L11:
        newValue = false;
        goto L12
    L18:
        if (changed == false) goto L24;
        updateConfig();
        return;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean bubblesEnabled(UserHandle userHandle) {
        int userId = userHandle.getIdentifier();
        boolean r2 = false;
        if (userId != (-1)) goto L6;
        return false;
    L6:
        if (this.mBubblesEnabled.indexOfKey(userId) >= 0) goto L12;
        SparseBooleanArray r1 = this.mBubblesEnabled;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "notification_bubbles", 1, userId) == 0) goto L10;
        r2 = true;
    L10:
        r1.put(userId, r2);
    L12:
        return this.mBubblesEnabled.get(userId, true);
    }

    public void updateLockScreenPrivateNotifications() {
        if (this.mLockScreenPrivateNotifications != null) goto L5;
        this.mLockScreenPrivateNotifications = new SparseBooleanArray();
    L5:
        boolean changed = false;
        int index = 0;
    L7:
        if (index >= this.mLockScreenPrivateNotifications.size()) goto L18;
        int userId = this.mLockScreenPrivateNotifications.keyAt(index);
        boolean oldValue = this.mLockScreenPrivateNotifications.get(userId);
        boolean r6 = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", 1, userId) == 0) goto L11;
        boolean newValue = true;
    L12:
        this.mLockScreenPrivateNotifications.put(userId, newValue);
        if (oldValue != newValue) goto L16;
        r6 = false;
    L16:
        changed = changed | r6;
        index = index + 1;
        goto L7
    L11:
        newValue = false;
        goto L12
    L18:
        if (changed == false) goto L24;
        updateConfig();
        return;
    }

    public void updateLockScreenShowNotifications() {
        if (this.mLockScreenShowNotifications != null) goto L5;
        this.mLockScreenShowNotifications = new SparseBooleanArray();
    L5:
        boolean changed = false;
        int index = 0;
    L7:
        if (index >= this.mLockScreenShowNotifications.size()) goto L18;
        int userId = this.mLockScreenShowNotifications.keyAt(index);
        boolean oldValue = this.mLockScreenShowNotifications.get(userId);
        boolean r6 = true;
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "lock_screen_show_notifications", 1, userId) == 0) goto L11;
        boolean newValue = true;
    L12:
        this.mLockScreenShowNotifications.put(userId, newValue);
        if (oldValue != newValue) goto L16;
        r6 = false;
    L16:
        changed = changed | r6;
        index = index + 1;
        goto L7
    L11:
        newValue = false;
        goto L12
    L18:
        if (changed == false) goto L24;
        updateConfig();
        return;
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean canShowNotificationsOnLockscreen(int userId) {
        if (this.mLockScreenShowNotifications != null) goto L6;
        this.mLockScreenShowNotifications = new SparseBooleanArray();
    L6:
        return this.mLockScreenShowNotifications.get(userId, true);
    }

    @Override // com.android.server.notification.RankingConfig
    public boolean canShowPrivateNotificationsOnLockScreen(int userId) {
        if (this.mLockScreenPrivateNotifications != null) goto L6;
        this.mLockScreenPrivateNotifications = new SparseBooleanArray();
    L6:
        return this.mLockScreenPrivateNotifications.get(userId, true);
    }

    public void unlockAllNotificationChannels() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int numPackagePreferences = this.mPackagePreferences.size();     // Catch: Throwable -> L10
        int i = 0;
    L5:
        if (i >= numPackagePreferences) goto L14;
        PackagePreferences r = this.mPackagePreferences.valueAt(i);     // Catch: Throwable -> L10
        Iterator<NotificationChannel> r4 = r.channels.values().iterator();     // Catch: Throwable -> L10
    L8:
        if (r4.hasNext() == false) goto L12;
        NotificationChannel channel = r4.next();     // Catch: Throwable -> L10
        channel.unlockFields(4);     // Catch: Throwable -> L10
        goto L8
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L5
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void migrateNotificationPermissions(List<UserInfo> users) {
        Iterator<UserInfo> r0 = users.iterator();
    L4:
        if (r0.hasNext() == false) goto L30;
        UserInfo user = r0.next();
        List<PackageInfo> packages = this.mPm.getInstalledPackagesAsUser(PackageManager.PackageInfoFlags.of(131072), user.getUserHandle().getIdentifier());
        Iterator<PackageInfo> r3 = packages.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        PackageInfo pi = r3.next();
        Object r5 = this.mLock;
        monitor-enter(r5);
        PackagePreferences p = getOrCreatePackagePreferencesLocked(pi.packageName, pi.applicationInfo.uid);     // Catch: Throwable -> L21
        if (p.migrateToPm == true) goto L14;
    L25:
        monitor-exit(r5);     // Catch: Throwable -> L21
        goto L7
    L14:
        if (p.uid == (-1)) goto L25;
        String r8 = p.pkg;     // Catch: Throwable -> L21 Exception -> L23
        int r9 = UserHandle.getUserId(p.uid);     // Catch: Throwable -> L21 Exception -> L23
        if (p.importance == 0) goto L18;
        boolean r10 = true;
    L19:
        PermissionHelper.PackagePermission pkgPerm = new PermissionHelper.PackagePermission(r8, r9, r10, hasUserConfiguredSettings(p));     // Catch: Throwable -> L21 Exception -> L23
        this.mPermissionHelper.setNotificationPermission(pkgPerm);     // Catch: Throwable -> L21 Exception -> L23
    L18:
        r10 = false;
    L23:
        e = move-exception;
        Slog.e(TAG, "could not migrate setting for " + p.pkg, e);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private void updateConfig() {
        this.mRankingHandler.requestSort();
    }

    protected void invalidateNotificationChannelCache() {
        NotificationManager.invalidateNotificationChannelCache();
    }

    protected void invalidateNotificationChannelGroupCache() {
        NotificationManager.invalidateNotificationChannelGroupCache();
    }

    private static String packagePreferencesKey(String pkg, int uid) {
        return pkg + "|" + uid;
    }

    private static String unrestoredPackageKey(String pkg, int userId) {
        return pkg + "|" + userId;
    }

    PreferencesHelperSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public void setPkgAllNotificationSilent(String pkg, int uid, boolean silent) {
        Slog.i(TAG, "setPkgAllNotificationSilent, pkg: " + pkg + ", silent: " + silent);
        boolean changed = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r == null) goto L16;
        if (r.allNotificationSilent == silent) goto L11;
        r.allNotificationSilent = silent;     // Catch: Throwable -> L9
        changed = true;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        if (changed == false) goto L20;
        updateConfig();
        return;
    L20:
        return;
    L16:
        throw new IllegalArgumentException("Invalid package");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isPkgAllNotificationSilent(String pkg, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackagePreferences r = getOrCreatePackagePreferencesLocked(pkg, uid);     // Catch: Throwable -> L9
        if (r == null) goto L12;
        boolean r2 = r.allNotificationSilent;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        throw new IllegalArgumentException("Invalid package " + pkg);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
