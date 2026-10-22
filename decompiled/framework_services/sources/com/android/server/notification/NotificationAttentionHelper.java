package com.android.server.notification;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.IRingtonePlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.VibrationEffect;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.android.internal.config.sysui.SystemUiSystemPropertiesFlags;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.EventLogTags;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.lights.LightsManager;
import com.android.server.lights.LogicalLight;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationAttentionHelper {
    static final boolean DEBUG = false;
    static final boolean DEBUG_INTERRUPTIVENESS = false;
    static final boolean DEBUG_MUTE_REASON = false;
    private static final int DEFAULT_NOTIFICATION_COOLDOWN_ALL = 1;
    private static final int DEFAULT_NOTIFICATION_COOLDOWN_ENABLED = 1;
    private static final int DEFAULT_NOTIFICATION_COOLDOWN_ENABLED_FOR_WORK = 1;
    private static final int DEFAULT_NOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED = 0;
    private static final float DEFAULT_VOLUME = 1.0f;
    static final int MUTE_REASON_COOLDOWN = 32768;
    static final int MUTE_REASON_DND = 512;
    static final int MUTE_REASON_FLAG_SILENT = 2048;
    static final int MUTE_REASON_GROUP_ALERT = 1024;
    static final int MUTE_REASON_LISTENER_HINT = 256;
    static final int MUTE_REASON_NOT_AUDIBLE = 32;
    static final int MUTE_REASON_NOT_MUTED = 0;
    static final int MUTE_REASON_OTHER_INSISTENT_PLAYING = 8192;
    static final int MUTE_REASON_POST_SILENTLY = 128;
    static final int MUTE_REASON_RATE_LIMIT = 4096;
    static final int MUTE_REASON_SILENT_UPDATE = 64;
    static final int MUTE_REASON_SUPPRESSED_BUBBLE = 16384;
    static final Map<String, Pair<String, Boolean>> NOTIFICATION_AVALANCHE_TRIGGER_EXTRAS = null;
    static final Set<String> NOTIFICATION_AVALANCHE_TRIGGER_INTENTS = null;
    static final String TAG = "NotifAttentionHelper";
    private AccessibilityManager mAccessibilityManager;
    private LogicalLight mAttentionLight;
    private AudioManager mAudioManager;
    private Binder mCallNotificationToken;
    private int mCallState;
    private final Context mContext;
    private int mCurrentWorkProfileId;
    private boolean mDisableNotificationEffects;
    protected boolean mDisableNotificationEffectsForSetupWizard;
    private final boolean mEnableNotificationAccessibilityEvents;
    private final SystemUiSystemPropertiesFlags.FlagResolver mFlagResolver;
    boolean mHasLight;
    private final AudioAttributes mInCallNotificationAudioAttributes;
    private final Uri mInCallNotificationUri;
    private final float mInCallNotificationVolume;
    private boolean mInCallStateOffHook;
    private final BroadcastReceiver mIntentReceiver;
    private boolean mIsAutomotive;
    private KeyguardManager mKeyguardManager;
    ArrayList<String> mLights;
    private final Object mLock;
    private final NotificationManagerPrivate mNMP;
    private boolean mNotificationCooldownApplyToAll;
    private boolean mNotificationCooldownEnabled;
    private boolean mNotificationCooldownForWorkEnabled;
    private boolean mNotificationCooldownVibrateUnlocked;
    private boolean mNotificationEffectsEnabledForAutomotive;
    private LogicalLight mNotificationLight;
    private boolean mNotificationPulseEnabled;
    private final PackageManager mPackageManager;
    private boolean mScreenOn;
    private final SettingsObserver mSettingsObserver;
    private final NotificationAttentionHelperSmtEx mSmtEx;
    private String mSoundNotificationKey;
    private final PolitenessStrategy mStrategy;
    private boolean mSystemReady;
    private final TelephonyManager mTelephonyManager;
    private final UserManager mUm;
    private final NotificationUsageStats mUsageStats;
    private final boolean mUseAttentionLight;
    private boolean mUserPresent;
    private String mVibrateNotificationKey;
    private VibratorHelper mVibratorHelper;
    private final ZenModeHelper mZenModeHelper;

    private interface ExemptionProvider {
        boolean isExempted(NotificationRecord r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface MuteReason {
    }

    static abstract class PolitenessStrategy {
        static final int POLITE_STATE_DEFAULT = 0;
        static final int POLITE_STATE_MUTED = 2;
        static final int POLITE_STATE_POLITE = 1;
        protected boolean mApplyPerPackage;
        protected final ExemptionProvider mExemptionProvider;
        protected boolean mIsActive;
        protected final Map<String, Long> mLastUpdatedTimestampByPackage;
        protected final int mTimeoutMuted;
        protected final int mTimeoutPolite;
        protected final float mVolumeMuted;
        protected final float mVolumePolite;
        protected final Map<String, Integer> mVolumeStates;

        @Retention(RetentionPolicy.SOURCE)
        @interface PolitenessState {
        }

        /* JADX INFO: renamed from: -$$Nest$mgetVibrationIntensity, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m6102$$Nest$mgetVibrationIntensity(PolitenessStrategy r0, NotificationRecord r1) {
            return r0.getVibrationIntensity(r1);
        }

        abstract void onNotificationPosted(NotificationRecord r1);

        public PolitenessStrategy(int timeoutPolite, int timeoutMuted, int volumePolite, int volumeMuted, ExemptionProvider exemptionProvider) {
            this.mIsActive = true;
            this.mVolumeStates = new HashMap();
            this.mLastUpdatedTimestampByPackage = new HashMap();
            this.mTimeoutPolite = timeoutPolite;
            this.mTimeoutMuted = timeoutMuted;
            this.mVolumePolite = volumePolite / 100.0f;
            this.mVolumeMuted = volumeMuted / 100.0f;
            this.mExemptionProvider = exemptionProvider;
        }

        void setApplyCooldownPerPackage(boolean applyPerPackage) {
            this.mApplyPerPackage = applyPerPackage;
        }

        String getChannelKey(NotificationRecord record) {
            if (record.getChannel().getConversationId() == null) goto L5;
            String channelId = record.getChannel().getConversationId();
        L7:
            if (this.mApplyPerPackage == false) goto L12;
            if (record.getChannel().hasUserSetSound() == true) goto L12;
            channelId = "";
        L12:
            return record.getSbn().getNormalizedUserId() + ":" + record.getSbn().getPackageName() + ":" + channelId;
        L5:
            channelId = record.getChannel().getId();
            goto L7
        }

        public float getSoundVolume(NotificationRecord record) {
            float volume = 1.0f;
            String key = getChannelKey(record);
            int volState = getPolitenessState(record);
            switch(volState) {
                case 0: goto L7;
                case 1: goto L6;
                case 2: goto L5;
                default: goto L4;
            };
        L4:
            Log.w(NotificationAttentionHelper.TAG, "getSoundVolume unexpected volume state: " + volState);
        L9:
            if (NotificationAttentionHelper.DEBUG == false) goto L11;
            Log.i(NotificationAttentionHelper.TAG, "getSoundVolume state: " + volState + " vol: " + volume + " key: " + key);
        L11:
            return volume;
        L5:
            volume = this.mVolumeMuted;
            goto L9
        L6:
            volume = this.mVolumePolite;
            goto L9
        L7:
            volume = 1.0f;
            goto L9
        }

        private float getVibrationIntensity(NotificationRecord record) {
            return getSoundVolume(record);
        }

        public void onUserInteraction(NotificationRecord record) {
            String key = getChannelKey(record);
            this.mVolumeStates.put(key, 0);
            setLastNotificationUpdateTimeMs(record, 0);
        }

        public int getPolitenessState(NotificationRecord record) {
            return this.mVolumeStates.getOrDefault(getChannelKey(record), 0).intValue();
        }

        void setLastNotificationUpdateTimeMs(NotificationRecord record, long timestampMillis) {
            record.getChannel().setLastNotificationUpdateTimeMs(timestampMillis);
            this.mLastUpdatedTimestampByPackage.put(record.getSbn().getPackageName(), Long.valueOf(timestampMillis));
        }

        long getLastNotificationUpdateTimeMs(NotificationRecord record) {
            if (record.getChannel().hasUserSetSound() == true) goto L10;
            if (this.mApplyPerPackage == false) goto L10;
            return this.mLastUpdatedTimestampByPackage.getOrDefault(record.getSbn().getPackageName(), 0L).longValue();
        L10:
            return record.getChannel().getLastNotificationUpdateTimeMs();
        }

        int getNextState(int currState, long timeSinceLastNotif) {
            switch(currState) {
                case 0: goto L17;
                case 1: goto L10;
                case 2: goto L6;
                default: goto L4;
            };
        L4:
            Log.w(NotificationAttentionHelper.TAG, "getNextState unexpected volume state: " + currState);
            return currState;
        L6:
            if (timeSinceLastNotif <= this.mTimeoutMuted) goto L8;
            return 1;
        L8:
            return 2;
        L10:
            if (timeSinceLastNotif >= this.mTimeoutMuted) goto L13;
            return 2;
        L13:
            if (timeSinceLastNotif <= this.mTimeoutPolite) goto L15;
            return 0;
        L15:
            return 1;
        L17:
            if (timeSinceLastNotif >= this.mTimeoutPolite) goto L26;
            return 1;
        L26:
            return currState;
        }

        boolean isActive() {
            return this.mIsActive;
        }
    }

    protected final class SettingsObserver extends ContentObserver {
        private static final Uri NOTIFICATION_COOLDOWN_ALL_URI = null;
        private static final Uri NOTIFICATION_COOLDOWN_ENABLED_URI = null;
        private static final Uri NOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI = null;
        private static final Uri NOTIFICATION_LIGHT_PULSE_URI = null;
        final /* synthetic */ NotificationAttentionHelper this$0;

        /* JADX INFO: renamed from: -$$Nest$sfgetNOTIFICATION_COOLDOWN_ALL_URI, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m6103$$Nest$sfgetNOTIFICATION_COOLDOWN_ALL_URI() {
            return NOTIFICATION_COOLDOWN_ALL_URI;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetNOTIFICATION_COOLDOWN_ENABLED_URI, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m6104$$Nest$sfgetNOTIFICATION_COOLDOWN_ENABLED_URI() {
            return NOTIFICATION_COOLDOWN_ENABLED_URI;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetNOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m6105$$Nest$sfgetNOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI() {
            return NOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI;
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetNOTIFICATION_LIGHT_PULSE_URI, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m6106$$Nest$sfgetNOTIFICATION_LIGHT_PULSE_URI() {
            return NOTIFICATION_LIGHT_PULSE_URI;
        }

        static {
            NOTIFICATION_LIGHT_PULSE_URI = Settings.System.getUriFor("notification_light_pulse");
            NOTIFICATION_COOLDOWN_ENABLED_URI = Settings.System.getUriFor("notification_cooldown_enabled");
            NOTIFICATION_COOLDOWN_ALL_URI = Settings.System.getUriFor("notification_cooldown_all");
            NOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI = Settings.System.getUriFor("notification_cooldown_vibrate_unlocked");
        }

        public SettingsObserver(NotificationAttentionHelper this$0) {
            this.this$0 = this$0;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            boolean r2 = false;
            if (NOTIFICATION_LIGHT_PULSE_URI.equals(uri) == false) goto L20;
            if (Settings.System.getIntForUser(NotificationAttentionHelper.m6081$$Nest$fgetmContext(this.this$0).getContentResolver(), "notification_light_pulse", 0, -2) == 0) goto L7;
            boolean pulseEnabled = true;
        L8:
            Object r4 = NotificationAttentionHelper.m6086$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
        L13:
            th = move-exception;
            throw th;
        L11:
            if (NotificationAttentionHelper.m6089$$Nest$fgetmNotificationPulseEnabled(this.this$0) == pulseEnabled) goto L15;
            NotificationAttentionHelper.m6097$$Nest$fputmNotificationPulseEnabled(this.this$0, pulseEnabled);     // Catch: Throwable -> L13
            this.this$0.updateLightsLocked();     // Catch: Throwable -> L13
        L15:
            monitor-exit(r4);     // Catch: Throwable -> L13
            goto L20
        L7:
            pulseEnabled = false;
        L20:
            if (NOTIFICATION_COOLDOWN_ENABLED_URI.equals(uri) == false) goto L34;
            NotificationAttentionHelper r0 = this.this$0;
            if (Settings.System.getIntForUser(NotificationAttentionHelper.m6081$$Nest$fgetmContext(this.this$0).getContentResolver(), "notification_cooldown_enabled", 1, -2) == 0) goto L24;
            boolean r5 = true;
        L25:
            NotificationAttentionHelper.m6095$$Nest$fputmNotificationCooldownEnabled(r0, r5);
            if (NotificationAttentionHelper.m6082$$Nest$fgetmCurrentWorkProfileId(this.this$0) == (-10000)) goto L32;
            NotificationAttentionHelper r1 = this.this$0;
            if (Settings.System.getIntForUser(NotificationAttentionHelper.m6081$$Nest$fgetmContext(this.this$0).getContentResolver(), "notification_cooldown_enabled", 1, NotificationAttentionHelper.m6082$$Nest$fgetmCurrentWorkProfileId(this.this$0)) == 0) goto L30;
            boolean r6 = true;
        L31:
            NotificationAttentionHelper.m6096$$Nest$fputmNotificationCooldownForWorkEnabled(r1, r6);
            goto L34
        L30:
            r6 = false;
            goto L31
        L32:
            NotificationAttentionHelper.m6096$$Nest$fputmNotificationCooldownForWorkEnabled(this.this$0, false);
            goto L34
        L24:
            r5 = false;
        L34:
            if (NOTIFICATION_COOLDOWN_ALL_URI.equals(uri) == false) goto L39;
            NotificationAttentionHelper r3 = this.this$0;
            if (Settings.System.getIntForUser(NotificationAttentionHelper.m6081$$Nest$fgetmContext(this.this$0).getContentResolver(), "notification_cooldown_all", 1, -2) == 0) goto L38;
            r2 = true;
        L38:
            NotificationAttentionHelper.m6094$$Nest$fputmNotificationCooldownApplyToAll(r3, r2);
            NotificationAttentionHelper.m6090$$Nest$fgetmStrategy(this.this$0).setApplyCooldownPerPackage(NotificationAttentionHelper.m6087$$Nest$fgetmNotificationCooldownApplyToAll(this.this$0));
        L39:
            this.this$0.getSmtEx().onSettingsChanged(selfChange, uri);
        }
    }

    public static class Signals {
        private final boolean isCurrentProfile;
        private final int listenerHints;

        /* JADX INFO: renamed from: -$$Nest$fgetisCurrentProfile, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6107$$Nest$fgetisCurrentProfile(Signals r0) {
            return r0.isCurrentProfile;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetlistenerHints, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6108$$Nest$fgetlistenerHints(Signals r0) {
            return r0.listenerHints;
        }

        public Signals(boolean isCurrentProfile, int listenerHints) {
            this.isCurrentProfile = isCurrentProfile;
            this.listenerHints = listenerHints;
        }
    }

    private static class StrategyAvalanche extends PolitenessStrategy {
        private static final String COMMON_KEY = "cross_app_common_key";
        private final PolitenessStrategy mAppStrategy;
        private long mLastAvalancheTriggerTimestamp;
        private long mLastNotificationTimestamp;
        private final int mTimeoutAvalanche;

        StrategyAvalanche(int timeoutPolite, int timeoutMuted, int volumePolite, int volumeMuted, int timeoutAvalanche, PolitenessStrategy appStrategy, ExemptionProvider exemptionProvider) {
            super(timeoutPolite, timeoutMuted, volumePolite, volumeMuted, exemptionProvider);
            this.mLastNotificationTimestamp = 0;
            this.mLastAvalancheTriggerTimestamp = 0;
            this.mTimeoutAvalanche = timeoutAvalanche;
            this.mAppStrategy = appStrategy;
            if (NotificationAttentionHelper.DEBUG == false) goto L6;
            Log.i(NotificationAttentionHelper.TAG, "StrategyAvalanche: " + timeoutPolite + " " + timeoutMuted + " " + timeoutAvalanche);
            return;
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        void onNotificationPosted(NotificationRecord record) {
            if (isAvalancheActive() == false) goto L8;
            long timeSinceLastNotif = System.currentTimeMillis() - getLastNotificationUpdateTimeMs(record);
            String key = getChannelKey(record);
            int currState = getPolitenessState(record);
            int nextState = getNextState(currState, timeSinceLastNotif, record);
            if (NotificationAttentionHelper.DEBUG == false) goto L7;
            Log.i(NotificationAttentionHelper.TAG, "StrategyAvalanche onNotificationPosted time delta: " + timeSinceLastNotif + " vol state: " + nextState + " key: " + key);
        L7:
            this.mVolumeStates.put(key, Integer.valueOf(nextState));
        L8:
            this.mAppStrategy.onNotificationPosted(record);
        }

        int getNextState(int currState, long timeSinceLastNotif, NotificationRecord record) {
            if (isAvalancheExempted(record) == true) goto L7;
            return 2;
        L7:
            if (isAvalancheExemptedFullVolume(record) == false) goto L11;
            return 0;
        L11:
            return getNextState(currState, timeSinceLastNotif);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public int getPolitenessState(NotificationRecord record) {
            if (isAvalancheActive() == false) goto L7;
            return super.getPolitenessState(record);
        L7:
            return this.mAppStrategy.getPolitenessState(record);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public float getSoundVolume(NotificationRecord record) {
            if (isAvalancheActive() == false) goto L7;
            return super.getSoundVolume(record);
        L7:
            return this.mAppStrategy.getSoundVolume(record);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public void onUserInteraction(NotificationRecord record) {
            super.onUserInteraction(record);
            this.mAppStrategy.onUserInteraction(record);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        String getChannelKey(NotificationRecord record) {
            if (isAvalancheActive() == false) goto L11;
            if (isAvalancheExempted(record) == false) goto L9;
            return super.getChannelKey(record);
        L9:
            return record.getSbn().getNormalizedUserId() + ":" + COMMON_KEY;
        L11:
            return this.mAppStrategy.getChannelKey(record);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public void setLastNotificationUpdateTimeMs(NotificationRecord record, long timestampMillis) {
            if (isAvalancheExempted(record) == false) goto L5;
            super.setLastNotificationUpdateTimeMs(record, timestampMillis);
        L5:
            this.mLastNotificationTimestamp = timestampMillis;
            this.mAppStrategy.setLastNotificationUpdateTimeMs(record, timestampMillis);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        long getLastNotificationUpdateTimeMs(NotificationRecord record) {
            if (isAvalancheExempted(record) == false) goto L7;
            return super.getLastNotificationUpdateTimeMs(record);
        L7:
            return this.mLastNotificationTimestamp;
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        void setApplyCooldownPerPackage(boolean applyPerPackage) {
            super.setApplyCooldownPerPackage(applyPerPackage);
            this.mAppStrategy.setApplyCooldownPerPackage(applyPerPackage);
        }

        boolean isAvalancheActive() {
            long timeSinceAvalancheMs = System.currentTimeMillis() - this.mLastAvalancheTriggerTimestamp;
            if (timeSinceAvalancheMs < this.mTimeoutAvalanche) goto L5;
        L7:
            boolean r2 = false;
        L8:
            this.mIsActive = r2;
            if (NotificationAttentionHelper.DEBUG == false) goto L12;
            Log.i(NotificationAttentionHelper.TAG, "StrategyAvalanche: active " + this.mIsActive);
        L12:
            return this.mIsActive;
        L5:
            if (timeSinceAvalancheMs < 0) goto L7;
            r2 = true;
            goto L8
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        boolean isActive() {
            return isAvalancheActive();
        }

        void setTriggerTimeMs(long timestamp) {
            this.mLastAvalancheTriggerTimestamp = timestamp;
        }

        private boolean isAvalancheExemptedFullVolume(NotificationRecord record) {
            if (record.isConversation() == false) goto L8;
            if (record.getChannel().isImportantConversation() == false) goto L8;
            return true;
        L8:
            if (record.getNotification().isStyle(Notification.CallStyle.class) == false) goto L10;
            return true;
        L10:
            String category = record.getNotification().category;
            if ("reminder".equals(category) == false) goto L13;
        L17:
            return true;
        L13:
            if ("event".equals(category) == true) goto L17;
            return this.mExemptionProvider.isExempted(record);
        }

        private boolean isAvalancheExempted(NotificationRecord record) {
            if (isAvalancheExemptedFullVolume(record) == false) goto L6;
            return true;
        L6:
            if (record.isConversation() == true) goto L10;
            if (isConversationMessage(record) == true) goto L10;
        L13:
            if (record.getNotification().fullScreenIntent == null) goto L16;
            return true;
        L16:
            if (record.getNotification().isColorized() == false) goto L18;
            return true;
        L18:
            return false;
        L10:
            if (record.getNotification().getWhen() <= this.mLastAvalancheTriggerTimestamp) goto L13;
            return true;
        }

        private boolean isConversationMessage(NotificationRecord record) {
            if ("msg".equals(record.getSbn().getNotification().category) == true) goto L6;
            return false;
        L6:
            if (record.getChannel().isDemoted() == false) goto L8;
            return false;
        L8:
            ShortcutInfo shortcut = record.getShortcutInfo();
            if (shortcut != null) goto L11;
            return false;
        L11:
            return true;
        }
    }

    private static class StrategyPerApp extends PolitenessStrategy {
        private final int mMaxPostedForReset;
        private final Map<String, Integer> mNumPosted;

        public StrategyPerApp(int timeoutPolite, int timeoutMuted, int volumePolite, int volumeMuted, int maxPosted, ExemptionProvider exemptionProvider) {
            super(timeoutPolite, timeoutMuted, volumePolite, volumeMuted, exemptionProvider);
            this.mNumPosted = new HashMap();
            this.mMaxPostedForReset = maxPosted;
            if (NotificationAttentionHelper.DEBUG == false) goto L6;
            Log.i(NotificationAttentionHelper.TAG, "StrategyPerApp: " + timeoutPolite + " " + timeoutMuted);
            return;
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public void onNotificationPosted(NotificationRecord record) {
            long timeSinceLastNotif = System.currentTimeMillis() - getLastNotificationUpdateTimeMs(record);
            String key = getChannelKey(record);
            int currState = getPolitenessState(record);
            int nextState = getNextState(currState, timeSinceLastNotif, record);
            int numPosted = this.mNumPosted.getOrDefault(key, 0).intValue() + 1;
            this.mNumPosted.put(key, Integer.valueOf(numPosted));
            if (currState != 2) goto L8;
            if (numPosted < this.mMaxPostedForReset) goto L8;
            nextState = 0;
            this.mNumPosted.put(key, 0);
        L8:
            if (NotificationAttentionHelper.DEBUG == false) goto L10;
            Log.i(NotificationAttentionHelper.TAG, "onNotificationPosted time delta: " + timeSinceLastNotif + " vol state: " + nextState + " key: " + key + " numposted " + numPosted);
        L10:
            this.mVolumeStates.put(key, Integer.valueOf(nextState));
        }

        int getNextState(int currState, long timeSinceLastNotif, NotificationRecord record) {
            if (this.mExemptionProvider.isExempted(record) == false) goto L7;
            return 0;
        L7:
            return getNextState(currState, timeSinceLastNotif);
        }

        @Override // com.android.server.notification.NotificationAttentionHelper.PolitenessStrategy
        public void onUserInteraction(NotificationRecord record) {
            super.onUserInteraction(record);
            this.mNumPosted.put(getChannelKey(record), 0);
        }
    }

    public static /* synthetic */ void $r8$lambda$5Nu20XY6rJFYF_iVI639OcBJ3oY(NotificationAttentionHelper r0, NotificationRecord r1, VibrationEffect r2) {
        r0.lambda$playVibration$2(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$_Cy9buvrT-4h45p_F-2dQOykc8I, reason: not valid java name */
    public static /* synthetic */ boolean m6077$r8$lambda$_Cy9buvrT4h45p_F2dQOykc8I(NotificationAttentionHelper r0, NotificationRecord r1) {
        return r0.lambda$createPolitenessStrategy$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager m6078$$Nest$fgetmAudioManager(NotificationAttentionHelper r0) {
        return r0.mAudioManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallNotificationToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ Binder m6079$$Nest$fgetmCallNotificationToken(NotificationAttentionHelper r0) {
        return r0.mCallNotificationToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6080$$Nest$fgetmCallState(NotificationAttentionHelper r0) {
        return r0.mCallState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6081$$Nest$fgetmContext(NotificationAttentionHelper r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentWorkProfileId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6082$$Nest$fgetmCurrentWorkProfileId(NotificationAttentionHelper r0) {
        return r0.mCurrentWorkProfileId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInCallNotificationAudioAttributes, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioAttributes m6083$$Nest$fgetmInCallNotificationAudioAttributes(NotificationAttentionHelper r0) {
        return r0.mInCallNotificationAudioAttributes;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInCallNotificationUri, reason: not valid java name */
    static /* bridge */ /* synthetic */ Uri m6084$$Nest$fgetmInCallNotificationUri(NotificationAttentionHelper r0) {
        return r0.mInCallNotificationUri;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInCallNotificationVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m6085$$Nest$fgetmInCallNotificationVolume(NotificationAttentionHelper r0) {
        return r0.mInCallNotificationVolume;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6086$$Nest$fgetmLock(NotificationAttentionHelper r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationCooldownApplyToAll, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6087$$Nest$fgetmNotificationCooldownApplyToAll(NotificationAttentionHelper r0) {
        return r0.mNotificationCooldownApplyToAll;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationLight, reason: not valid java name */
    static /* bridge */ /* synthetic */ LogicalLight m6088$$Nest$fgetmNotificationLight(NotificationAttentionHelper r0) {
        return r0.mNotificationLight;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationPulseEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6089$$Nest$fgetmNotificationPulseEnabled(NotificationAttentionHelper r0) {
        return r0.mNotificationPulseEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStrategy, reason: not valid java name */
    static /* bridge */ /* synthetic */ PolitenessStrategy m6090$$Nest$fgetmStrategy(NotificationAttentionHelper r0) {
        return r0.mStrategy;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCallNotificationToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6091$$Nest$fputmCallNotificationToken(NotificationAttentionHelper r0, Binder r1) {
        r0.mCallNotificationToken = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCallState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6092$$Nest$fputmCallState(NotificationAttentionHelper r0, int r1) {
        r0.mCallState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInCallStateOffHook, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6093$$Nest$fputmInCallStateOffHook(NotificationAttentionHelper r0, boolean r1) {
        r0.mInCallStateOffHook = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationCooldownApplyToAll, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6094$$Nest$fputmNotificationCooldownApplyToAll(NotificationAttentionHelper r0, boolean r1) {
        r0.mNotificationCooldownApplyToAll = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationCooldownEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6095$$Nest$fputmNotificationCooldownEnabled(NotificationAttentionHelper r0, boolean r1) {
        r0.mNotificationCooldownEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationCooldownForWorkEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6096$$Nest$fputmNotificationCooldownForWorkEnabled(NotificationAttentionHelper r0, boolean r1) {
        r0.mNotificationCooldownForWorkEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationPulseEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6097$$Nest$fputmNotificationPulseEnabled(NotificationAttentionHelper r0, boolean r1) {
        r0.mNotificationPulseEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6098$$Nest$fputmScreenOn(NotificationAttentionHelper r0, boolean r1) {
        r0.mScreenOn = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserPresent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6099$$Nest$fputmUserPresent(NotificationAttentionHelper r0, boolean r1) {
        r0.mUserPresent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mloadUserSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6100$$Nest$mloadUserSettings(NotificationAttentionHelper r0) {
        r0.loadUserSettings();
    }

    /* JADX INFO: renamed from: -$$Nest$smcallStateToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6101$$Nest$smcallStateToString(int r0) {
        return callStateToString(r0);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        DEBUG_INTERRUPTIVENESS = SystemProperties.getBoolean("debug.notification.interruptiveness", false);
        NOTIFICATION_AVALANCHE_TRIGGER_INTENTS = Set.of("android.intent.action.AIRPLANE_MODE", "android.intent.action.BOOT_COMPLETED", "android.intent.action.USER_SWITCHED", "android.intent.action.MANAGED_PROFILE_AVAILABLE");
        NOTIFICATION_AVALANCHE_TRIGGER_EXTRAS = Map.of("android.intent.action.AIRPLANE_MODE", new Pair("state", false), "android.intent.action.MANAGED_PROFILE_AVAILABLE", new Pair("android.intent.extra.QUIET_MODE", false));
        DEBUG_MUTE_REASON = SystemProperties.getBoolean("debug.notification.mute_reason", false);
    }

    public NotificationAttentionHelper(Context context, Object lock, LightsManager lightsManager, AccessibilityManager accessibilityManager, PackageManager packageManager, UserManager userManager, NotificationUsageStats usageStats, NotificationManagerPrivate notificationManagerPrivate, ZenModeHelper zenModeHelper, SystemUiSystemPropertiesFlags.FlagResolver flagResolver) {
        this.mLights = new ArrayList();
        this.mInCallStateOffHook = false;
        this.mScreenOn = true;
        this.mUserPresent = false;
        this.mCallNotificationToken = null;
        this.mCurrentWorkProfileId = ProcessList.INVALID_ADJ;
        this.mIntentReceiver = new AnonymousClass3(this);
        this.mContext = context;
        this.mLock = lock;
        this.mPackageManager = packageManager;
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        this.mAccessibilityManager = accessibilityManager;
        this.mUm = userManager;
        this.mNMP = notificationManagerPrivate;
        this.mUsageStats = usageStats;
        this.mZenModeHelper = zenModeHelper;
        this.mFlagResolver = flagResolver;
        this.mVibratorHelper = new VibratorHelper(context);
        this.mNotificationLight = lightsManager.getLight(4);
        this.mAttentionLight = lightsManager.getLight(5);
        Resources resources = context.getResources();
        this.mUseAttentionLight = resources.getBoolean(R.bool.config_useVideoPauseWorkaround);
        this.mHasLight = resources.getBoolean(R.bool.config_isWindowManagerCameraCompatSplitScreenAspectRatioEnabled);
        this.mEnableNotificationAccessibilityEvents = resources.getBoolean(R.bool.config_enableScreenshotChord);
        if (Settings.Global.getInt(context.getContentResolver(), "device_provisioned", 0) != 0) goto L5;
        this.mDisableNotificationEffectsForSetupWizard = true;
    L5:
        this.mInCallNotificationUri = Uri.parse("file://" + resources.getString(R.string.config_retailDemoPackageSignature));
        this.mInCallNotificationAudioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(2).build();
        this.mInCallNotificationVolume = resources.getFloat(R.dimen.default_magnifier_zoom);
        this.mStrategy = createPolitenessStrategy();
        this.mSmtEx = new NotificationAttentionHelperSmtEx(this, context);
        this.mSettingsObserver = new SettingsObserver(this);
        loadUserSettings();
    }

    private PolitenessStrategy createPolitenessStrategy() {
        PolitenessStrategy appStrategy = new StrategyPerApp(this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_COOLDOWN_T1), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_COOLDOWN_T2), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_VOLUME1), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_VOLUME2), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_COOLDOWN_COUNTER_RESET), new NotificationAttentionHelper$$ExternalSyntheticLambda0(this));
        return new StrategyAvalanche(this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_COOLDOWN_T1), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_COOLDOWN_T2), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_VOLUME1), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_VOLUME2), this.mFlagResolver.getIntValue(SystemUiSystemPropertiesFlags.NotificationFlags.NOTIF_AVALANCHE_TIMEOUT), appStrategy, appStrategy.mExemptionProvider);
    }

    private /* synthetic */ boolean lambda$createPolitenessStrategy$0(NotificationRecord record) {
        String category = record.getNotification().category;
        if (HostingRecord.TRIGGER_TYPE_ALARM.equals(category) == false) goto L5;
    L14:
        return true;
    L5:
        if ("car_emergency".equals(category) == true) goto L14;
        if ("car_warning".equals(category) == true) goto L14;
        if (this.mPackageManager.checkPermission("android.permission.RECEIVE_EMERGENCY_BROADCAST", record.getSbn().getPackageName()) == 0) goto L15;
        return false;
    L15:
        return true;
    }

    private /* synthetic */ boolean lambda$createPolitenessStrategy$1(NotificationRecord record) {
        String category = record.getNotification().category;
        if (HostingRecord.TRIGGER_TYPE_ALARM.equals(category) == false) goto L5;
    L14:
        return true;
    L5:
        if ("car_emergency".equals(category) == true) goto L14;
        if ("car_warning".equals(category) == true) goto L14;
        if (this.mPackageManager.checkPermission("android.permission.RECEIVE_EMERGENCY_BROADCAST", record.getSbn().getPackageName()) == 0) goto L15;
        return false;
    L15:
        return true;
    }

    PolitenessStrategy getPolitenessStrategy() {
        return this.mStrategy;
    }

    public void onSystemReady() {
        this.mSystemReady = true;
        this.mIsAutomotive = this.mPackageManager.hasSystemFeature("android.hardware.type.automotive", 0);
        this.mNotificationEffectsEnabledForAutomotive = this.mContext.getResources().getBoolean(R.bool.config_enableTimeZoneNotificationsTrackingSupported);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
        registerBroadcastListeners();
    }

    private void registerBroadcastListeners() {
        if (this.mPackageManager.hasSystemFeature("android.hardware.telephony") == false) goto L5;
        this.mTelephonyManager.listen(new AnonymousClass1(this), 32);
    L5:
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.PHONE_STATE");
        filter.addAction("android.intent.action.USER_PRESENT");
        filter.addAction("android.intent.action.USER_ADDED");
        filter.addAction("android.intent.action.USER_REMOVED");
        filter.addAction("android.intent.action.USER_SWITCHED");
        filter.addAction("android.intent.action.USER_UNLOCKED");
        Iterator<String> r0 = NOTIFICATION_AVALANCHE_TRIGGER_INTENTS.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        String avalancheIntent = r0.next();
        filter.addAction(avalancheIntent);
        goto L7
    L9:
        this.mContext.registerReceiverAsUser(this.mIntentReceiver, UserHandle.ALL, filter, null, null);
        this.mContext.getContentResolver().registerContentObserver(SettingsObserver.m6106$$Nest$sfgetNOTIFICATION_LIGHT_PULSE_URI(), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(SettingsObserver.m6104$$Nest$sfgetNOTIFICATION_COOLDOWN_ENABLED_URI(), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(SettingsObserver.m6103$$Nest$sfgetNOTIFICATION_COOLDOWN_ALL_URI(), false, this.mSettingsObserver, -1);
        this.mContext.getContentResolver().registerContentObserver(SettingsObserver.m6105$$Nest$sfgetNOTIFICATION_COOLDOWN_VIBRATE_UNLOCKED_URI(), false, this.mSettingsObserver, -1);
        getSmtEx().registerSettingsObserver(this.mSettingsObserver);
    }

    private void loadUserSettings() {
        boolean r2 = false;
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "notification_light_pulse", 0, -2) == 0) goto L5;
        boolean pulseEnabled = true;
    L6:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mNotificationPulseEnabled == pulseEnabled) goto L13;
        this.mNotificationPulseEnabled = pulseEnabled;     // Catch: Throwable -> L11
        updateLightsLocked();     // Catch: Throwable -> L11
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L11
        this.mCurrentWorkProfileId = getManagedProfileId(ActivityManager.getCurrentUser());     // Catch: Exception -> L25
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "notification_cooldown_enabled", 1, -2) == 0) goto L17;
        boolean r5 = true;
    L18:
        this.mNotificationCooldownEnabled = r5;     // Catch: Exception -> L25
        if (this.mCurrentWorkProfileId != (-10000)) goto L21;
        this.mNotificationCooldownForWorkEnabled = false;     // Catch: Exception -> L25
    L29:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "notification_cooldown_all", 1, -2) == 0) goto L31;
        r2 = true;
    L31:
        this.mNotificationCooldownApplyToAll = r2;     // Catch: Exception -> L25
        this.mStrategy.setApplyCooldownPerPackage(this.mNotificationCooldownApplyToAll);     // Catch: Exception -> L25
    L34:
        getSmtEx().loadUserSettings();
        return;
    L21:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "notification_cooldown_enabled", 1, this.mCurrentWorkProfileId) == 0) goto L23;
        boolean r6 = true;
    L24:
        this.mNotificationCooldownForWorkEnabled = r6;     // Catch: Exception -> L25
        goto L29
    L23:
        r6 = false;
        goto L24
    L17:
        r5 = false;
    L25:
        e = move-exception;
        Log.e(TAG, "Failed to read Settings: " + e);
        goto L34
    L5:
        pulseEnabled = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [int] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    int buzzBeepBlinkLocked(NotificationRecord r33, Signals r34) {
        if (this.mIsAutomotive == true) goto L5;
    L7:
        int r6 = 0;
        String r8 = r33.getKey();
        if (DEBUG == false) goto L11;
        Log.d(TAG, "buzzBeepBlinkLocked " + r33);
    L11:
        if (this.mIsAutomotive == false) goto L17;
        if (r33.getImportance() <= 3) goto L15;
        boolean r9 = true;
    L20:
        boolean r15 = r9;
        if (r8 != null) goto L23;
    L25:
        ?? r10 = false;
    L26:
        ?? r16 = r10;
        if (r8 != null) goto L29;
    L31:
        ?? r11 = false;
    L32:
        ?? r17 = r11;
        boolean r13 = false;
        if (r33.isIntercepted() == true) goto L35;
    L37:
        ?? r18 = false;
    L39:
        if (r33.isUpdate == false) goto L41;
    L46:
        if (r15 == true) goto L48;
    L150:
        int r19 = 4;
    L151:
        boolean r3 = false;
        boolean r4 = false;
        ?? r12 = 0;
        boolean r5 = false;
        int r14 = 0;
    L152:
        if (r16 == false) goto L155;
        if (r4 == true) goto L155;
        clearSoundLocked();
    L155:
        if (r17 == false) goto L158;
        if (r3 == true) goto L158;
        clearVibrateLocked();
    L158:
        boolean r7 = this.mLights.remove(r8);
        if (canShowLightsLocked(r33, r34, r15) == false) goto L166;
        this.mLights.add(r8);
        updateLightsLocked();
        if (this.mUseAttentionLight == true) goto L163;
    L165:
        int r110 = 1;
    L169:
        if (r12 != 0) goto L173;
        if (r5 == true) goto L173;
        if (r110 != 0) goto L173;
    L191:
        if (r5 == false) goto L193;
        int r111 = 2;
    L194:
        int r112 = r111 | r12;
        if (r110 != 0) goto L198;
        r19 = 0;
    L198:
        int r113 = ((r112 | r19) | getPoliteBit(r33)) | r14;
        if (r113 <= 0) goto L201;
        MetricsLogger.action(r33.getLogMaker().setCategory(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__SET_PREFERENTIAL_NETWORK_SERVICE_ENABLED).setType(1).setSubtype(r113));
        boolean r114 = r5;
        int r20 = r113;
        EventLogTags.writeNotificationAlert(r8, r12, r114 ? 1 : 0, r110, getPolitenessState(r33), r14);
    L203:
        if (r12 != 0) goto L207;
        if (r114 == true) goto L207;
    L208:
        if (r12 != 0) goto L211;
        if (r114 == true) goto L211;
    L213:
        boolean r115 = false;
    L214:
        r33.setAudiblyAlerted(r115);
        return r20;
    L211:
        if (getPolitenessState(r33) == 2) goto L213;
        r115 = true;
    L207:
        this.mStrategy.setLastNotificationUpdateTimeMs(r33, System.currentTimeMillis());
        goto L208
    L201:
        r114 = r5;
        r20 = r113;
        goto L203
    L193:
        r111 = 0;
    L173:
        if (r33.getSbn().isGroup() == false) goto L180;
        if (r33.getSbn().getNotification().isGroupSummary() == false) goto L180;
        if (DEBUG_INTERRUPTIVENESS == false) goto L191;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r33.getKey() + " is not interruptive: summary");
    L180:
        if (r33.canBubble() == true) goto L182;
        r33.setInterruptive(true);
        if (DEBUG_INTERRUPTIVENESS == false) goto L188;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r33.getKey() + " is interruptive: alerted");
    L188:
        if (r12 != 0) goto L190;
        if (r5 == false) goto L191;
    L190:
        r33.resetRankingTime();
        goto L191
    L182:
        if (DEBUG_INTERRUPTIVENESS == false) goto L191;
        Slog.v(TAG, "INTERRUPTIVENESS: " + r33.getKey() + " is not interruptive: bubble");
        goto L191
    L163:
        if (this.mAttentionLight == null) goto L165;
        this.mAttentionLight.pulse();
        goto L165
    L166:
        if (r7 == false) goto L168;
        updateLightsLocked();
    L168:
        r110 = r6;
        goto L169
    L48:
        if (isNotificationForCurrentUser(r33, r34) == false) goto L150;
        r19 = 4;
        if (this.mSystemReady == false) goto L151;
        if (this.mAudioManager == null) goto L151;
        Uri r21 = r33.getSound();
        if (r21 != null) goto L56;
    L58:
        boolean r116 = false;
    L59:
        boolean r117 = r116;
        VibrationEffect r118 = r33.getVibration();
        Slog.d(TAG, "buzzBeepBlinkLocked: vibration=" + r118);
        if (r118 == null) goto L64;
        r118 = getSmtEx().calculateVibrationEffect(r33);
        if (r118 != null) goto L64;
        Slog.w(TAG, "calculateVibrationEffect failed, fallback to default");
        r118 = r33.getVibration();
    L64:
        if (r118 != null) goto L75;
        if (r117 == false) goto L75;
        if (this.mAudioManager.getRingerModeInternal() != 1) goto L75;
        if (this.mAudioManager.getStreamVolume(AudioAttributes.toLegacyStreamType(r33.getAudioAttributes())) != 0) goto L75;
        if ((r33.getFlags() & 4) == 0) goto L73;
        boolean r22 = true;
    L74:
        r118 = this.mVibratorHelper.createFallbackVibration(r22);
        goto L75
    L73:
        r22 = false;
    L75:
        if (r118 == null) goto L77;
        boolean r23 = true;
    L78:
        boolean r24 = r23;
        if (r24 == true) goto L81;
    L85:
        boolean r25 = false;
    L86:
        if (r117 == true) goto L90;
        if (r24 == true) goto L90;
        boolean r119 = false;
    L91:
        int r26 = shouldMuteNotificationLocked(r33, r34, r119);
        if (DEBUG_MUTE_REASON == false) goto L95;
        if (r26 == 0) goto L95;
        logMuteReason(r26);
    L95:
        if (r26 != 0) goto L145;
        if (r13 == true) goto L99;
        sendAccessibilityEvent(r33);
        r13 = true;
    L99:
        if (DEBUG == false) goto L102;
        Slog.v(TAG, "Interrupting!");
    L102:
        boolean r27 = isInsistentUpdate(r33);
        NotificationChannel r28 = r33.getChannel();
        boolean r29 = true;
        if (r28 == null) goto L106;
        r29 = r28.getSmtEx().getSoundEnabled();
    L106:
        if (r33.isUpdate == false) goto L110;
        boolean r210 = false;
        r6 = 0;
        if (this.mNMP.isBlockSoundAndVibrate(r33.getSbn().getPackageName(), r33.getNotification()) == false) goto L111;
        boolean r30 = true;
    L113:
        if (isInCall() == false) goto L116;
        playInCallNotification();
        boolean r31 = true;
    L126:
        if (this.mAudioManager.getRingerModeInternal() != 0) goto L128;
        boolean r32 = true;
    L130:
        if (isInCall() == true) goto L143;
        if (r24 == false) goto L143;
        if (r32 == true) goto L143;
        if (r30 == true) goto L143;
        if (r27 == false) goto L136;
        boolean r35 = true;
    L144:
        boolean r211 = r35;
        this.mAccessibilityManager.startFlashNotificationEvent(this.mContext, 3, r33.getSbn().getPackageName());
        r3 = r24;
        r4 = r117;
        r12 = r211;
        r5 = r31;
        r14 = r26;
        goto L152
    L136:
        if (r117 == false) goto L139;
        if (r25 == true) goto L139;
        boolean r36 = true;
    L140:
        r35 = playVibration(r33, r118, r36);
        if (r35 == false) goto L144;
        this.mVibrateNotificationKey = r8;
    L139:
        r36 = false;
    L143:
        r35 = false;
        goto L144
    L128:
        r32 = false;
        goto L130
    L116:
        if (this.mNMP.isBlockedSound(r33.sbn.getPackageName()) == true) goto L124;
        if (r117 == false) goto L124;
        if (r29 == false) goto L124;
        if (r25 != 0) goto L124;
        if (r30 == true) goto L124;
        r31 = playSound(r33, r21);
        if (r31 == false) goto L126;
        this.mSoundNotificationKey = r8;
    L124:
        r31 = r210;
    L111:
        r30 = false;
        goto L113
    L110:
        r210 = false;
        r6 = 0;
        goto L111
    L145:
        r6 = 0;
        if ((r33.getFlags() & 4) == 0) goto L148;
        r3 = false;
        r4 = false;
        r12 = 0;
        r5 = false;
        r14 = r26;
        goto L152
    L148:
        r3 = r24;
        r4 = r117;
        r12 = 0;
        r5 = false;
        r14 = r26;
    L90:
        r119 = true;
        goto L91
    L81:
        if (this.mNotificationCooldownVibrateUnlocked == false) goto L85;
        if (this.mUserPresent == false) goto L85;
        r25 = true;
        goto L86
    L77:
        r23 = false;
        goto L78
    L56:
        if (Uri.EMPTY.equals(r21) == true) goto L58;
        r116 = true;
        goto L59
    L41:
        if (r33.getImportance() <= 1) goto L46;
        if (r18 == true) goto L46;
        if (isNotificationForCurrentUser(r33, r34) == false) goto L46;
        sendAccessibilityEvent(r33);
        r13 = true;
        goto L46
    L35:
        if ((r33.getSuppressedVisualEffects() & 32) == 0) goto L37;
        r18 = true;
        goto L39
    L29:
        if (r8.equals(this.mVibrateNotificationKey) == false) goto L31;
        r11 = true;
        goto L32
    L23:
        if (r8.equals(this.mSoundNotificationKey) == false) goto L25;
        r10 = true;
        goto L26
    L15:
        r9 = false;
        goto L20
    L17:
        if (r33.getImportance() < 3) goto L19;
        r9 = true;
        goto L20
    L19:
        r9 = false;
        goto L20
    L5:
        if (this.mNotificationEffectsEnabledForAutomotive == true) goto L7;
        return 0;
    }

    private int getPoliteBit(NotificationRecord record) {
        switch(getPolitenessState(record)) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return 0;
    L6:
        return 16;
    L8:
        return 8;
    }

    private int getPolitenessState(NotificationRecord record) {
        if (isPoliteNotificationFeatureEnabled(record) == true) goto L7;
        return 0;
    L7:
        return this.mStrategy.getPolitenessState(record);
    }

    boolean isInsistentUpdate(NotificationRecord record) {
        if (Objects.equals(record.getKey(), this.mSoundNotificationKey) == true) goto L7;
        if (Objects.equals(record.getKey(), this.mVibrateNotificationKey) == true) goto L7;
    L9:
        return false;
    L7:
        if (isCurrentlyInsistent() == false) goto L9;
        return true;
    }

    boolean isCurrentlyInsistent() {
        if (isLoopingRingtoneNotification(this.mNMP.getNotificationByKey(this.mSoundNotificationKey)) == false) goto L5;
    L8:
        return true;
    L5:
        if (isLoopingRingtoneNotification(this.mNMP.getNotificationByKey(this.mVibrateNotificationKey)) == true) goto L8;
        return false;
    }

    int shouldMuteNotificationLocked(NotificationRecord record, Signals signals, boolean hasAudibleAlert) {
        if (hasAudibleAlert == true) goto L5;
        return 32;
    L5:
        Notification notification = record.getNotification();
        if (record.isUpdate == false) goto L12;
        if ((notification.flags & 8) == 0) goto L12;
        return 64;
    L12:
        if (record.shouldPostSilently() == false) goto L15;
        return 128;
    L15:
        String disableEffects = disableNotificationEffects(record, Signals.m6108$$Nest$fgetlistenerHints(signals));
        if (disableEffects == null) goto L20;
        ZenLog.traceDisableEffects(record, disableEffects);
        return 256;
    L20:
        if (record.isIntercepted() == false) goto L24;
        return 512;
    L24:
        if (record.getSbn().isGroup() == true) goto L26;
    L29:
        String pkg = record.getSbn().getPackageName();
        if (this.mUsageStats.isAlertRateLimited(pkg) == false) goto L34;
        Slog.e(TAG, "Muting recently noisy " + record.getKey());
        return 4096;
    L34:
        if (Notification.isCompatSilentSceneWhitelistPkg(pkg) == false) goto L40;
        if ((notification.flags & 131072) == 0) goto L40;
        Slog.i(TAG, "Muting FLAG_SILENT for compat whitelist pkg=" + pkg);
        return 2048;
    L40:
        if (isCurrentlyInsistent() == false) goto L46;
        if (isInsistentUpdate(record) == true) goto L46;
        return 8192;
    L46:
        if (record.canBubble() == true) goto L48;
    L52:
        boolean isBubbleOrOverflowed = false;
    L54:
        if (record.isUpdate == false) goto L65;
        if (record.isInterruptive() == true) goto L65;
        if (isBubbleOrOverflowed == false) goto L65;
        if (record.getNotification().getBubbleMetadata() == null) goto L65;
        if (record.getNotification().getBubbleMetadata().isNotificationSuppressed() == false) goto L65;
        return 16384;
    L65:
        if (isPoliteNotificationFeatureEnabled(record) == true) goto L67;
    L73:
        return 0;
    L67:
        if (isInsistentUpdate(record) == true) goto L70;
        this.mStrategy.onNotificationPosted(record);
    L70:
        if (getPolitenessState(record) != 2) goto L73;
        return 32768;
    L48:
        if (record.isFlagBubbleRemoved() == false) goto L50;
    L51:
        isBubbleOrOverflowed = true;
        goto L54
    L50:
        if (record.getNotification().isBubbleNotification() == false) goto L52;
    L26:
        if (notification.suppressAlertingDueToGrouping() == false) goto L29;
        return 1024;
    }

    private boolean isLoopingRingtoneNotification(NotificationRecord playingRecord) {
        if (playingRecord != null) goto L4;
        return false;
    L4:
        if (playingRecord.getAudioAttributes().getUsage() == 6) goto L6;
        return false;
    L6:
        if ((playingRecord.getNotification().flags & 4) == 0) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean playSound(NotificationRecord record, Uri soundUri) {
        boolean shouldPlay = this.mAudioManager.shouldNotificationSoundPlay(record.getAudioAttributes());
        if (shouldPlay == true) goto L9;
        if (DEBUG == false) goto L7;
        Slog.v(TAG, "Not playing sound " + soundUri + " due to focus/volume");
    L7:
        return false;
    L9:
        if ((record.getNotification().flags & 4) == 0) goto L11;
        boolean r0 = true;
    L12:
        boolean looping = r0;
        long identity = Binder.clearCallingIdentity();
        IRingtonePlayer player = this.mAudioManager.getRingtonePlayer();     // Catch: Throwable -> L32 RemoteException -> L34
        if (player == null) goto L37;
        if (DEBUG == true) goto L47;
    L23:
    L44:
        player.playAsync(soundUri, record.getSbn().getUser(), looping, record.getAudioAttributes(), getSoundVolume(record));     // Catch: Throwable -> L28 RemoteException -> L30
        Binder.restoreCallingIdentity(identity);
        return true;
    L30:
        e = e;
    L39:
        Log.e(TAG, "Failed playSound: " + e);     // Catch: Throwable -> L28
    L28:
        th = th;
    L42:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L47:
        Slog.v(TAG, "Playing sound " + soundUri + " with attributes " + record.getAudioAttributes());     // Catch: Throwable -> L19 RemoteException -> L21
    L21:
        e = e;
    L19:
        th = th;
    L37:
        Binder.restoreCallingIdentity(identity);
        return false;
    L34:
        e = e;
    L32:
        th = th;
        goto L42
    L11:
        r0 = false;
        goto L12
    }

    private boolean isPoliteNotificationFeatureEnabled(NotificationRecord record) {
        if (this.mNotificationCooldownEnabled == true) goto L6;
        return false;
    L6:
        if (isNotificationForWorkProfile(record) == false) goto L11;
        if (this.mNotificationCooldownForWorkEnabled == true) goto L11;
        return false;
    L11:
        if (this.mNotificationCooldownApplyToAll == false) goto L13;
        return true;
    L13:
        if (record.isConversation() == true) goto L17;
        return false;
    L17:
        return true;
    }

    private float getSoundVolume(NotificationRecord record) {
        if (isPoliteNotificationFeatureEnabled(record) == true) goto L7;
        return 1.0f;
    L7:
        return this.mStrategy.getSoundVolume(record);
    }

    private float getVibrationIntensity(NotificationRecord record) {
        if (isPoliteNotificationFeatureEnabled(record) == true) goto L7;
        return 1.0f;
    L7:
        return PolitenessStrategy.m6102$$Nest$mgetVibrationIntensity(this.mStrategy, record);
    }

    private boolean playVibration(final NotificationRecord record, VibrationEffect effect, boolean delayVibForSound) {
        long identity = Binder.clearCallingIdentity();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L4:
        if (this.mVibrateNotificationKey != null) goto L6;
    L10:
        float scale = getVibrationIntensity(record);     // Catch: Throwable -> L8
        if (Float.compare(scale, 1.0f) == 0) goto L13;
        final VibrationEffect scaledEffect = this.mVibratorHelper.scale(effect, scale);     // Catch: Throwable -> L8
    L14:
        if (delayVibForSound == false) goto L16;
        new Thread(new NotificationAttentionHelper$$ExternalSyntheticLambda1(this, record, scaledEffect)).start();     // Catch: Throwable -> L8
    L17:
        Binder.restoreCallingIdentity(identity);
        return true;
    L16:
        vibrate(record, scaledEffect, false);     // Catch: Throwable -> L8
        goto L17
    L13:
        scaledEffect = effect;
        goto L14
    L6:
        if (this.mVibrateNotificationKey.equals(record.getKey()) == true) goto L10;
        this.mVibrateNotificationKey = null;     // Catch: Throwable -> L8
        this.mVibratorHelper.cancelVibration();     // Catch: Throwable -> L8
        goto L10
    }

    private /* synthetic */ void lambda$playVibration$2(NotificationRecord record, VibrationEffect scaledEffect) {
        int waitMs = this.mAudioManager.getFocusRampTimeMs(3, record.getAudioAttributes());
        if (DEBUG == false) goto L20;
        Slog.v(TAG, "Delaying vibration for notification " + record.getKey() + " by " + waitMs + "ms");
    L20:
        Thread.sleep(waitMs);     // Catch: InterruptedException -> L8
    L11:
        if (this.mNMP.getNotificationByKey(record.getKey()) != null) goto L13;
        Slog.w(TAG, "No vibration for canceled notification " + record.getKey());
        return;
    L13:
        if (record.getKey().equals(this.mVibrateNotificationKey) == false) goto L16;
        vibrate(record, scaledEffect, true);
        return;
    L16:
        if (DEBUG == false) goto L23;
        Slog.v(TAG, "No vibration for notification " + record.getKey() + ": a new notification is vibrating, or effects were cleared while waiting");
        return;
    }

    private void vibrate(NotificationRecord record, VibrationEffect effect, boolean delayed) {
        StringBuilder r0 = new StringBuilder();
        r0.append("Notification (");
        r0.append(record.getSbn().getOpPkg());
        r0.append(" ");
        r0.append(record.getSbn().getUid());
        r0.append(") ");
        if (delayed == false) goto L5;
        String r1 = "(Delayed)";
    L6:
        r0.append(r1);
        String reason = r0.toString();
        int simSlotId = getSmtEx().getSimSlotId(record);
        if (simSlotId == (-1)) goto L9;
        this.mVibratorHelper.vibrate(effect, record.getAudioAttributes(), reason, simSlotId);
        return;
    L9:
        this.mVibratorHelper.vibrate(effect, record.getAudioAttributes(), reason);
        return;
    L5:
        r1 = "";
        goto L6
    }

    void playInCallNotification() {
        ContentResolver cr = this.mContext.getContentResolver();
        if (this.mAudioManager.getRingerModeInternal() == 2) goto L5;
        return;
    L5:
        if (Settings.Secure.getIntForUser(cr, "in_call_notification_enabled", 0, cr.getUserId()) == 0) goto L9;
        new AnonymousClass2(this).start();
        return;
    }

    void clearSoundLocked() {
        this.mSoundNotificationKey = null;
        long identity = Binder.clearCallingIdentity();
        IRingtonePlayer player = this.mAudioManager.getRingtonePlayer();     // Catch: Throwable -> L7 RemoteException -> L9
        if (player == null) goto L12;
        player.stopAsync();     // Catch: Throwable -> L7 RemoteException -> L9
    L12:
        Binder.restoreCallingIdentity(identity);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L9:
        e = move-exception;
        Log.e(TAG, "Failed clearSoundLocked: " + e);     // Catch: Throwable -> L7
        goto L12
    }

    void clearVibrateLocked() {
        this.mVibrateNotificationKey = null;
        long identity = Binder.clearCallingIdentity();
        this.mVibratorHelper.cancelVibration();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void clearLightsLocked() {
        this.mLights.clear();
        updateLightsLocked();
    }

    public void clearEffectsLocked(String key) {
        if (key.equals(this.mSoundNotificationKey) == false) goto L6;
        clearSoundLocked();
    L6:
        if (key.equals(this.mVibrateNotificationKey) == false) goto L8;
        clearVibrateLocked();
    L8:
        boolean removed = this.mLights.remove(key);
        if (removed == false) goto L12;
        updateLightsLocked();
        return;
    }

    public void clearAttentionEffects() {
        clearSoundLocked();
        clearVibrateLocked();
        clearLightsLocked();
    }

    void updateLightsLocked() {
        if (this.mNotificationLight != null) goto L5;
        return;
    L5:
        NotificationRecord ledNotification = null;
    L7:
        if (ledNotification != null) goto L14;
        if (this.mLights.isEmpty() == true) goto L14;
        String owner = this.mLights.get(this.mLights.size() - 1);
        ledNotification = this.mNMP.getNotificationByKey(owner);
        if (ledNotification != null) goto L7;
        Slog.wtfStack(TAG, "LED Notification does not exist: " + owner);
        this.mLights.remove(owner);
    L14:
        if (ledNotification != null) goto L16;
    L25:
        this.mNotificationLight.turnOff();
        return;
    L16:
        if (isInCall() == true) goto L25;
        if (this.mScreenOn == true) goto L25;
        NotificationRecord.Light light = ledNotification.getLight();
        if (light != null) goto L23;
        return;
    L23:
        if (this.mNotificationPulseEnabled == false) goto L34;
        this.mNotificationLight.setFlashing(light.color, 1, light.onMs, light.offMs);
        return;
    }

    boolean canShowLightsLocked(NotificationRecord record, Signals signals, boolean aboveThreshold) {
        if (this.mSystemReady == true) goto L6;
        return false;
    L6:
        if (this.mHasLight == true) goto L9;
        return false;
    L9:
        if (this.mNotificationPulseEnabled == true) goto L12;
        return false;
    L12:
        if (record.getLight() != null) goto L14;
        return false;
    L14:
        if (aboveThreshold == true) goto L17;
        return false;
    L17:
        if ((record.getSuppressedVisualEffects() & 8) == 0) goto L19;
        return false;
    L19:
        Notification notification = record.getNotification();
        if (record.isUpdate == false) goto L25;
        if ((notification.flags & 8) == 0) goto L25;
        return false;
    L25:
        if (record.getSbn().isGroup() == false) goto L30;
        if (record.getNotification().suppressAlertingDueToGrouping() == false) goto L30;
        return false;
    L30:
        if (isInCall() == false) goto L33;
        return false;
    L33:
        if (isNotificationForCurrentUser(record, signals) == true) goto L35;
        return false;
    L35:
        return true;
    }

    private String disableNotificationEffects(NotificationRecord record, int listenerHints) {
        if (this.mDisableNotificationEffectsForSetupWizard == false) goto L6;
        return "booleanState";
    L6:
        if (this.mDisableNotificationEffects == false) goto L9;
        return "booleanState";
    L9:
        if ((listenerHints & 1) == 0) goto L12;
        return "listenerHints";
    L12:
        if (record == null) goto L28;
        if (record.getAudioAttributes() == null) goto L28;
        if ((listenerHints & 2) == 0) goto L22;
        if (record.getAudioAttributes().getUsage() == 6) goto L22;
        return "listenerNoti";
    L22:
        if ((listenerHints & 4) == 0) goto L28;
        if (record.getAudioAttributes().getUsage() != 6) goto L28;
        return "listenerCall";
    L28:
        if (this.mCallState != 0) goto L30;
        return null;
    L30:
        if (this.mZenModeHelper.isCall(record) == true) goto L35;
        return "callState";
    L35:
        return null;
    }

    public void updateDisableNotificationEffectsLocked(int status) {
        if ((262144 & status) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mDisableNotificationEffects = r0;
        if (this.mDisableNotificationEffects == false) goto L10;
        clearAttentionEffects();
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private boolean isInCall() {
        if (this.mInCallStateOffHook == false) goto L5;
        return true;
    L5:
        int audioMode = this.mAudioManager.getMode();
        if (audioMode != 2) goto L8;
    L12:
        return true;
    L8:
        if (audioMode == 3) goto L12;
        return false;
    }

    private static String callStateToString(int state) {
        switch(state) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return "CALL_STATE_OFFHOOK";
    L7:
        return "CALL_STATE_RINGING";
    L9:
        return "CALL_STATE_IDLE";
    L4:
        return "CALL_STATE_UNKNOWN_" + state;
    }

    private boolean isNotificationForCurrentUser(NotificationRecord record, Signals signals) {
        long token = Binder.clearCallingIdentity();
        int currentUser = ActivityManager.getCurrentUser();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(token);
        if (record.getUserId() != (-1)) goto L7;
    L12:
        return true;
    L7:
        if (record.getUserId() == currentUser) goto L12;
        if (Signals.m6107$$Nest$fgetisCurrentProfile(signals) == true) goto L12;
        return false;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean isNotificationForWorkProfile(NotificationRecord record) {
        if (record.getUser().getIdentifier() == this.mCurrentWorkProfileId) goto L5;
    L7:
        return false;
    L5:
        if (this.mCurrentWorkProfileId == (-10000)) goto L7;
        return true;
    }

    private int getManagedProfileId(int parentUserId) {
        List<UserInfo> profiles = this.mUm.getProfiles(parentUserId);
        Iterator<UserInfo> r1 = profiles.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        UserInfo profile = r1.next();
        if (profile.isManagedProfile() == false) goto L4;
        if (profile.getUserHandle().getIdentifier() == parentUserId) goto L4;
        return profile.getUserHandle().getIdentifier();
    L12:
        return ProcessList.INVALID_ADJ;
    }

    void sendAccessibilityEvent(NotificationRecord record) {
        if (this.mAccessibilityManager.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mEnableNotificationAccessibilityEvents == false) goto L27;
        Notification notification = record.getNotification();
        CharSequence packageName = record.getSbn().getPackageName();
        AccessibilityEvent event = AccessibilityEvent.obtain(64);
        event.setPackageName(packageName);
        event.setClassName(Notification.class.getName());
        int visibilityOverride = record.getPackageVisibilityOverride();
        if (visibilityOverride != (-1000)) goto L10;
        int notifVisibility = notification.visibility;
    L11:
        int userId = record.getUser().getIdentifier();
        if (userId >= 0) goto L14;
    L16:
        boolean needPublic = false;
    L17:
        if (needPublic == false) goto L20;
        if (notifVisibility == 1) goto L20;
        event.setParcelableData(notification.publicVersion);
    L21:
        CharSequence tickerText = notification.tickerText;
        if (TextUtils.isEmpty(tickerText) == true) goto L24;
        event.getText().add(tickerText);
    L24:
        this.mAccessibilityManager.sendAccessibilityEvent(event);
        return;
    L20:
        event.setParcelableData(notification);
        goto L21
    L14:
        if (this.mKeyguardManager.isDeviceLocked(userId) == false) goto L16;
        needPublic = true;
        goto L17
    L10:
        notifVisibility = visibilityOverride;
        goto L11
    }

    public void onUserInteraction(NotificationRecord record) {
        if (isPoliteNotificationFeatureEnabled(record) == false) goto L6;
        this.mStrategy.onUserInteraction(record);
        return;
    }

    public void dumpLocked(PrintWriter pw, String prefix, NotificationManagerService.DumpFilter filter) {
        pw.println("\n  Notification attention state:");
        pw.print(prefix);
        pw.println("  mSoundNotificationKey=" + this.mSoundNotificationKey);
        pw.print(prefix);
        pw.println("  mVibrateNotificationKey=" + this.mVibrateNotificationKey);
        pw.print(prefix);
        pw.println("  mDisableNotificationEffects=" + this.mDisableNotificationEffects);
        pw.print(prefix);
        pw.println("  mDisableNotificationEffectsForSetupWizard=" + this.mDisableNotificationEffectsForSetupWizard);
        pw.print(prefix);
        pw.println("  mCallState=" + callStateToString(this.mCallState));
        pw.print(prefix);
        pw.println("  mSystemReady=" + this.mSystemReady);
        pw.print(prefix);
        pw.println("  mNotificationPulseEnabled=" + this.mNotificationPulseEnabled);
        int N = this.mLights.size();
        if (N <= 0) goto L16;
        pw.print(prefix);
        pw.println("  Lights List:");
        int i = 0;
    L5:
        if (i >= N) goto L11;
        if (i != (N - 1)) goto L9;
        pw.print("  > ");
    L10:
        pw.println(this.mLights.get(i));
        i = i + 1;
        goto L5
    L9:
        pw.print("    ");
        goto L10
    L11:
        pw.println("  ");
        return;
    }

    void setIsAutomotive(boolean isAutomotive) {
        this.mIsAutomotive = isAutomotive;
    }

    void setNotificationEffectsEnabledForAutomotive(boolean isEnabled) {
        this.mNotificationEffectsEnabledForAutomotive = isEnabled;
    }

    void setSystemReady(boolean systemReady) {
        this.mSystemReady = systemReady;
    }

    void setKeyguardManager(KeyguardManager keyguardManager) {
        this.mKeyguardManager = keyguardManager;
    }

    void setAccessibilityManager(AccessibilityManager am) {
        this.mAccessibilityManager = am;
    }

    VibratorHelper getVibratorHelper() {
        return this.mVibratorHelper;
    }

    void setVibratorHelper(VibratorHelper helper) {
        this.mVibratorHelper = helper;
    }

    void setScreenOn(boolean on) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mScreenOn = on;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setUserPresent(boolean userPresent) {
        this.mUserPresent = userPresent;
    }

    void setLights(LogicalLight light) {
        this.mNotificationLight = light;
        this.mAttentionLight = light;
    }

    void setAudioManager(AudioManager audioManager) {
        this.mAudioManager = audioManager;
    }

    void setInCallStateOffHook(boolean inCallStateOffHook) {
        this.mInCallStateOffHook = inCallStateOffHook;
    }

    public NotificationAttentionHelperSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    private static void logMuteReason(int muteReason) {
        switch(muteReason) {
            case 32: goto L14;
            case 64: goto L13;
            case 128: goto L12;
            case 256: goto L11;
            case 512: goto L10;
            case 1024: goto L9;
            case 2048: goto L8;
            case 4096: goto L7;
            case 8192: goto L6;
            case 16384: goto L5;
            case 32768: goto L4;
            default: goto L3;
        };
    L3:
        String reason = Integer.toString(muteReason);
    L15:
        Slog.i(TAG, "shouldMuteNotification reason=" + reason);
        return;
    L4:
        reason = "COOLDOWN";
        goto L15
    L5:
        reason = "SUPPRESSED_BUBBLE";
        goto L15
    L6:
        reason = "OTHER_INSISTENT_PLAYING";
        goto L15
    L7:
        reason = "RATE_LIMIT";
        goto L15
    L8:
        reason = "FLAG_SILENT";
        goto L15
    L9:
        reason = "GROUP_ALERT";
        goto L15
    L10:
        reason = "DND";
        goto L15
    L11:
        reason = "LISTENER_HINT";
        goto L15
    L12:
        reason = "POST_SILENTLY";
        goto L15
    L13:
        reason = "SILENT_UPDATE";
        goto L15
    L14:
        reason = "NOT_AUDIBLE";
        goto L15
    }
}
