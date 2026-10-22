package com.android.server.notification;

import android.R;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.Person;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ShortcutInfo;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioSystem;
import android.metrics.LogMaker;
import android.net.Uri;
import android.net.util.NetworkConstants;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Trace;
import android.os.UserHandle;
import android.os.VibrationEffect;
import android.provider.Settings;
import android.service.notification.Adjustment;
import android.service.notification.NotificationListenerService;
import android.service.notification.NotificationStats;
import android.service.notification.SnoozeCriterion;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.widget.RemoteViews;
import com.android.internal.logging.MetricsLogger;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.input.KeyboardMetricsCollector;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.uri.UriGrantsManagerInternal;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationRecord {
    static final boolean DBG = false;
    private static final int MAX_SOUND_DELAY_MS = 2000;
    static final String TAG = "NotificationRecord";
    boolean isCanceled;
    public boolean isUpdate;
    private String mAdjustmentIssuer;
    private final List<Adjustment> mAdjustments;
    private boolean mAllowBubble;
    private boolean mAppDemotedFromConvo;
    private int mAssistantImportance;
    private AudioAttributes mAttributes;
    private int mAuthoritativeRank;
    private int mBundleType;
    private boolean mCanceledAfterLifetimeExtension;
    private NotificationChannel mChannel;
    private float mContactAffinity;
    private final Context mContext;
    private long mCreationTimeMs;
    private int mCriticality;
    private boolean mEditChoicesBeforeSending;
    private boolean mFlagBubbleRemoved;
    private String mGlobalSortKey;
    private ArraySet<Uri> mGrantableUris;
    private boolean mHasSeenSmartReplies;
    private boolean mHasSentValidMsg;
    private boolean mHidden;
    private int mImportance;
    private int mImportanceExplanationCode;
    private boolean mImportanceFixed;
    private int mInitialImportanceExplanationCode;
    private boolean mIntercept;
    private boolean mInterceptSet;
    private long mInterruptionTimeMs;
    private boolean mIsAppImportanceLocked;
    private boolean mIsInterruptive;
    private boolean mIsNotConversationOverride;
    private KeyguardManager mKeyguardManager;
    private long mLastAudiblyAlertedMs;
    private long mLastIntrusive;
    private Light mLight;
    private int mNumberOfSmartActionsAdded;
    private int mNumberOfSmartRepliesAdded;
    final int mOriginalFlags;
    private int mPackagePriority;
    private int mPackageVisibility;
    private boolean mPendingLogUpdate;
    private ArrayList<String> mPeopleOverride;
    private ArraySet<String> mPhoneNumbers;
    private boolean mPkgAllowedAsConvo;
    private boolean mPostSilently;
    private final PowerManager mPowerManager;
    private boolean mPreChannelsNotification;
    private int mProposedImportance;
    private float mRankingScore;
    private long mRankingTimeMs;
    private boolean mRecentlyIntrusive;
    private boolean mRecordedInterruption;
    private boolean mSensitiveContent;
    private ShortcutInfo mShortcutInfo;
    private boolean mShowBadge;
    private ArrayList<CharSequence> mSmartReplies;
    private NotificationRecordSmtEx mSmtEx;
    private ArrayList<SnoozeCriterion> mSnoozeCriteria;
    private Uri mSound;
    private final NotificationStats mStats;
    private boolean mSuggestionsGeneratedByAssistant;
    private String mSummarization;
    private int mSuppressedVisualEffects;
    private ArrayList<Notification.Action> mSystemGeneratedSmartActions;
    private int mSystemImportance;
    final int mTargetSdkVersion;
    private boolean mTextChanged;
    private final UriGrantsManagerInternal mUgmInternal;
    final long mUpdateTimeMs;
    private String mUserExplanation;
    private int mUserSentiment;
    private VibrationEffect mVibration;
    private long mVisibleSinceMs;
    IBinder permissionOwner;
    final StatusBarNotification sbn;
    NotificationUsageStats.SingleNotificationStats stats;

    static final class Light {
        public final int color;
        public final int offMs;
        public final int onMs;

        public Light(int color, int onMs, int offMs) {
            this.color = color;
            this.onMs = onMs;
            this.offMs = offMs;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if (o != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != o.getClass()) goto L21;
            Light light = (Light) o;
            if (this.color == light.color) goto L14;
            return false;
        L14:
            if (this.onMs == light.onMs) goto L17;
            return false;
        L17:
            if (this.offMs != light.offMs) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            int result = this.color;
            int result2 = (result * 31) + this.onMs;
            return (result2 * 31) + this.offMs;
        }

        public String toString() {
            return "Light{color=" + this.color + ", onMs=" + this.onMs + ", offMs=" + this.offMs + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$m3xVdeXccEasPWsrg0D9LxsE8QE(NotificationRecord r0, Uri r1) {
        r0.lambda$calculateGrantableUris$0(r1);
    }

    static {
        DBG = Log.isLoggable(TAG, 3);
    }

    public NotificationRecord(Context context, StatusBarNotification sbn, NotificationChannel channel) {
        this.mSystemImportance = -1000;
        this.mAssistantImportance = -1000;
        this.mImportance = -1000;
        this.mRankingScore = 0.0f;
        this.mCriticality = 2;
        this.mImportanceExplanationCode = 0;
        this.mInitialImportanceExplanationCode = 0;
        this.mSuppressedVisualEffects = 0;
        this.mPreChannelsNotification = true;
        this.mPendingLogUpdate = false;
        this.mProposedImportance = -1000;
        this.mSensitiveContent = false;
        this.mCanceledAfterLifetimeExtension = false;
        this.mBundleType = 0;
        this.mSummarization = null;
        this.mSmtEx = new NotificationRecordSmtEx(this);
        this.sbn = sbn;
        this.mTargetSdkVersion = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageTargetSdkVersion(sbn.getPackageName());
        this.mUgmInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        this.mOriginalFlags = sbn.getNotification().flags;
        this.mRankingTimeMs = calculateRankingTimeMs(0);
        this.mCreationTimeMs = sbn.getPostTime();
        this.mUpdateTimeMs = this.mCreationTimeMs;
        this.mInterruptionTimeMs = this.mCreationTimeMs;
        this.mContext = context;
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.stats = new NotificationUsageStats.SingleNotificationStats();
        this.mChannel = channel;
        this.mPreChannelsNotification = isPreChannelsNotification();
        this.mSound = calculateSound();
        this.mVibration = calculateVibration();
        this.mAttributes = calculateAttributes();
        this.mImportance = calculateInitialImportance();
        this.mLight = calculateLights();
        this.mAdjustments = new ArrayList();
        this.mStats = new NotificationStats();
        calculateUserSentiment();
        calculateGrantableUris();
    }

    private boolean isPreChannelsNotification() {
        if ("miscellaneous".equals(getChannel().getId()) == true) goto L5;
        return false;
    L5:
        if (this.mTargetSdkVersion >= 26) goto L10;
        return true;
    L10:
        return false;
    }

    private Uri calculateSound() {
        Notification n = getSbn().getNotification();
        if (this.mContext.getPackageManager().hasSystemFeature("android.software.leanback") == false) goto L6;
        return null;
    L6:
        Uri sound = this.mChannel.getSound();
        if (this.mPreChannelsNotification == true) goto L9;
        return sound;
    L9:
        if ((getChannel().getUserLockedFields() & 32) != 0) goto L19;
        boolean useDefaultSound = true;
        if ((n.defaults & 1) != 0) goto L14;
        useDefaultSound = false;
    L14:
        if (useDefaultSound == false) goto L17;
        return Settings.System.DEFAULT_NOTIFICATION_URI;
    L17:
        return n.sound;
    L19:
        return sound;
    }

    private Light calculateLights() {
        int defaultLightColor = this.mContext.getResources().getColor(R.color.datepicker_default_selected_text_color_material_dark);
        int defaultLightOn = this.mContext.getResources().getInteger(R.integer.config_defaultUndimsRequired);
        int defaultLightOff = this.mContext.getResources().getInteger(R.integer.config_defaultUiModeType);
        if (getChannel().getLightColor() == 0) goto L5;
        int channelLightColor = getChannel().getLightColor();
    L7:
        if (getChannel().shouldShowLights() == false) goto L9;
        Light light = new Light(channelLightColor, defaultLightOn, defaultLightOff);
    L11:
        if (this.mPreChannelsNotification == true) goto L13;
        return light;
    L13:
        if ((getChannel().getUserLockedFields() & 8) != 0) goto L22;
        Notification notification = getSbn().getNotification();
        if ((notification.flags & 1) == 0) goto L19;
        Light light2 = new Light(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.defaults & 4) == 0) goto L23;
        Light light3 = new Light(defaultLightColor, defaultLightOn, defaultLightOff);
        return light3;
    L23:
        return light2;
    L19:
        return null;
    L22:
        return light;
    L9:
        light = null;
        goto L11
    L5:
        channelLightColor = defaultLightColor;
        goto L7
    }

    private VibrationEffect getVibrationForChannel(NotificationChannel channel, VibratorHelper helper, boolean insistent) {
        if (channel.shouldVibrate() == true) goto L6;
        return null;
    L6:
        VibrationEffect vibration = channel.getVibrationEffect();
        if (vibration != null) goto L9;
    L12:
        long[] vibrationPattern = channel.getVibrationPattern();
        if (vibrationPattern == null) goto L17;
        return VibratorHelper.createWaveformVibration(vibrationPattern, insistent);
    L17:
        return helper.createDefaultVibration(insistent);
    L9:
        if (helper.areEffectComponentsSupported(vibration) == false) goto L12;
        return vibration.applyRepeatingIndefinitely(insistent, 0);
    }

    private VibrationEffect calculateVibration() {
        VibratorHelper helper = new VibratorHelper(this.mContext);
        Notification notification = getSbn().getNotification();
        boolean useDefaultVibrate = false;
        if ((notification.flags & 4) == 0) goto L5;
        boolean insistent = true;
    L7:
        if (this.mPreChannelsNotification == false) goto L19;
        if ((getChannel().getUserLockedFields() & 16) != 0) goto L19;
        if ((notification.defaults & 2) == 0) goto L13;
        useDefaultVibrate = true;
    L13:
        if (useDefaultVibrate == false) goto L17;
        return helper.createDefaultVibration(insistent);
    L17:
        return VibratorHelper.createWaveformVibration(notification.vibrate, insistent);
    L19:
        return getVibrationForChannel(getChannel(), helper, insistent);
    L5:
        insistent = false;
        goto L7
    }

    private AudioAttributes calculateAttributes() {
        Notification n = getSbn().getNotification();
        AudioAttributes attributes = getChannel().getAudioAttributes();
        if (attributes != null) goto L6;
        attributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
    L6:
        if (this.mPreChannelsNotification == true) goto L8;
        return attributes;
    L8:
        if ((getChannel().getUserLockedFields() & 32) == 0) goto L10;
        return attributes;
    L10:
        if (n.audioAttributes == null) goto L13;
        return n.audioAttributes;
    L13:
        if (n.audioStreamType < 0) goto L18;
        if (n.audioStreamType >= AudioSystem.getNumStreamTypes()) goto L18;
        return new AudioAttributes.Builder().setInternalLegacyStreamType(n.audioStreamType).build();
    L18:
        if (n.audioStreamType == (-1)) goto L25;
        Log.w(TAG, String.format("Invalid stream type: %d", new Object[]{Integer.valueOf(n.audioStreamType)}));
        return attributes;
    L25:
        return attributes;
    }

    private int calculateInitialImportance() {
        Notification n = getSbn().getNotification();
        int importance = getChannel().getImportance();
        boolean r3 = true;
        if (getChannel().hasUserSetImportance() == false) goto L5;
        int r2 = 2;
    L6:
        this.mInitialImportanceExplanationCode = r2;
        if ((n.flags & 128) == 0) goto L9;
        n.priority = 2;
    L9:
        int requestedImportance = 3;
        n.priority = NotificationManagerService.clamp(n.priority, -2, 2);
        switch(n.priority) {
            case -2: goto L15;
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L12;
            default: goto L16;
        };
    L12:
        requestedImportance = 4;
        goto L16
    L13:
        requestedImportance = 3;
        goto L16
    L14:
        requestedImportance = 2;
        goto L16
    L15:
        requestedImportance = 1;
    L16:
        this.stats.requestedImportance = requestedImportance;
        NotificationUsageStats.SingleNotificationStats r5 = this.stats;
        if (this.mSound == null) goto L19;
    L22:
        r5.isNoisy = r3;
        if (this.mPreChannelsNotification == false) goto L42;
        if (importance == (-1000)) goto L29;
        if (getChannel().hasUserSetImportance() == true) goto L42;
    L29:
        if (this.stats.isNoisy == true) goto L33;
        if (requestedImportance <= 2) goto L33;
        requestedImportance = 2;
    L33:
        if (this.stats.isNoisy == false) goto L38;
        if (requestedImportance >= 3) goto L38;
        requestedImportance = 3;
    L38:
        if (n.fullScreenIntent == null) goto L40;
        requestedImportance = 4;
    L40:
        importance = requestedImportance;
        this.mInitialImportanceExplanationCode = 5;
    L42:
        if (((NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class)).isPkgAllNotificationSilent(getSbn().getPackageName(), getUid()) == false) goto L44;
        importance = 2;
    L44:
        this.stats.naturalImportance = importance;
        return importance;
    L19:
        if (this.mVibration != null) goto L22;
        r3 = false;
        goto L22
    L5:
        r2 = 1;
        goto L6
    }

    public void copyRankingInformation(NotificationRecord previous) {
        this.mContactAffinity = previous.mContactAffinity;
        this.mRecentlyIntrusive = previous.mRecentlyIntrusive;
        this.mPackagePriority = previous.mPackagePriority;
        this.mPackageVisibility = previous.mPackageVisibility;
        this.mIntercept = previous.mIntercept;
        this.mHidden = previous.mHidden;
        this.mRankingTimeMs = calculateRankingTimeMs(previous.getRankingTimeMs());
        this.mCreationTimeMs = previous.mCreationTimeMs;
        this.mVisibleSinceMs = previous.mVisibleSinceMs;
        if (previous.getSbn().getOverrideGroupKey() == null) goto L6;
        getSbn().setOverrideGroupKey(previous.getSbn().getOverrideGroupKey());
        return;
    }

    public Notification getNotification() {
        return getSbn().getNotification();
    }

    public int getFlags() {
        return getSbn().getNotification().flags;
    }

    public UserHandle getUser() {
        return getSbn().getUser();
    }

    public String getKey() {
        return getSbn().getKey();
    }

    public int getUserId() {
        return getSbn().getUserId();
    }

    public int getUid() {
        return getSbn().getUid();
    }

    void dump(ProtoOutputStream proto, long fieldId, boolean redact, int state) {
        long token = proto.start(fieldId);
        proto.write(1138166333441L, getSbn().getKey());
        proto.write(1159641169922L, state);
        if (getChannel() == null) goto L5;
        proto.write(1138166333444L, getChannel().getId());
    L5:
        boolean r3 = false;
        if (getLight() == null) goto L8;
        boolean r2 = true;
    L9:
        proto.write(1133871366152L, r2);
        if (getVibration() == null) goto L12;
        r3 = true;
    L12:
        proto.write(1133871366151L, r3);
        proto.write(1120986464259L, getSbn().getNotification().flags);
        proto.write(1138166333449L, getGroupKey());
        proto.write(1172526071818L, getImportance());
        if (getSound() == null) goto L16;
        proto.write(1138166333445L, getSound().toString());
    L16:
        if (getAudioAttributes() == null) goto L18;
        getAudioAttributes().dumpDebug(proto, 1146756268038L);
    L18:
        proto.write(1138166333451L, getSbn().getPackageName());
        proto.write(1138166333452L, getSbn().getOpPkg());
        proto.end(token);
        return;
    L8:
        r2 = false;
        goto L9
    }

    String formatRemoteViews(RemoteViews rv) {
        if (rv != null) goto L6;
        return "null";
    L6:
        return String.format("%s/0x%08x (%d bytes): %s", new Object[]{rv.getPackage(), Integer.valueOf(rv.getLayoutId()), Long.valueOf(rv.estimateMemoryUsage()), rv.toString()});
    }

    @NeverCompile
    void dump(PrintWriter pw, String prefix, Context baseContext, boolean redact) {
        Notification notification = getSbn().getNotification();
        pw.println(prefix + this);
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "uid=" + getSbn().getUid() + " userId=" + getSbn().getUserId());
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix2);
        r1.append("opPkg=");
        r1.append(getSbn().getOpPkg());
        pw.println(r1.toString());
        pw.println(prefix2 + "icon=" + notification.getSmallIcon());
        pw.println(prefix2 + "flags=" + Notification.flagsToString(notification.flags));
        pw.println(prefix2 + "originalFlags=" + Notification.flagsToString(this.mOriginalFlags));
        pw.println(prefix2 + "pri=" + notification.priority);
        pw.println(prefix2 + "key=" + getSbn().getKey());
        pw.println(prefix2 + "seen=" + this.mStats.hasSeen());
        pw.println(prefix2 + "groupKey=" + getGroupKey());
        StringBuilder r2 = new StringBuilder();
        r2.append(prefix2);
        r2.append("notification=");
        pw.println(r2.toString());
        dumpNotification(pw, prefix2 + prefix2, notification, redact);
        pw.println(prefix2 + "publicNotification=");
        dumpNotification(pw, prefix2 + prefix2, notification.publicVersion, redact);
        pw.println(prefix2 + "stats=" + this.stats.toString());
        pw.println(prefix2 + "mContactAffinity=" + this.mContactAffinity);
        pw.println(prefix2 + "mRecentlyIntrusive=" + this.mRecentlyIntrusive);
        pw.println(prefix2 + "mPackagePriority=" + this.mPackagePriority);
        pw.println(prefix2 + "mPackageVisibility=" + this.mPackageVisibility);
        pw.println(prefix2 + "mSystemImportance=" + NotificationListenerService.Ranking.importanceToString(this.mSystemImportance));
        pw.println(prefix2 + "mAsstImportance=" + NotificationListenerService.Ranking.importanceToString(this.mAssistantImportance));
        pw.println(prefix2 + "mImportance=" + NotificationListenerService.Ranking.importanceToString(this.mImportance));
        pw.println(prefix2 + "mImportanceExplanation=" + getImportanceExplanation());
        pw.println(prefix2 + "mProposedImportance=" + NotificationListenerService.Ranking.importanceToString(this.mProposedImportance));
        pw.println(prefix2 + "mIsAppImportanceLocked=" + this.mIsAppImportanceLocked);
        pw.println(prefix2 + "mSensitiveContent=" + this.mSensitiveContent);
        pw.println(prefix2 + "mCanceledAfterLifetimeExtension=" + this.mCanceledAfterLifetimeExtension);
        pw.println(prefix2 + "mIntercept=" + this.mIntercept);
        pw.println(prefix2 + "mHidden==" + this.mHidden);
        pw.println(prefix2 + "mGlobalSortKey=" + this.mGlobalSortKey);
        pw.println(prefix2 + "mRankingTimeMs=" + this.mRankingTimeMs);
        pw.println(prefix2 + "mCreationTimeMs=" + this.mCreationTimeMs);
        pw.println(prefix2 + "mVisibleSinceMs=" + this.mVisibleSinceMs);
        pw.println(prefix2 + "mUpdateTimeMs=" + this.mUpdateTimeMs);
        pw.println(prefix2 + "mInterruptionTimeMs=" + this.mInterruptionTimeMs);
        pw.println(prefix2 + "mSuppressedVisualEffects= " + this.mSuppressedVisualEffects);
        if (this.mPreChannelsNotification == false) goto L5;
        pw.println(prefix2 + "defaults=" + Notification.defaultsToString(notification.defaults));
        pw.println(prefix2 + "n.sound=" + notification.sound);
        pw.println(prefix2 + "n.audioStreamType=" + notification.audioStreamType);
        pw.println(prefix2 + "n.audioAttributes=" + notification.audioAttributes);
        StringBuilder r3 = new StringBuilder();
        r3.append(prefix2);
        r3.append(String.format("  led=0x%08x onMs=%d offMs=%d", new Object[]{Integer.valueOf(notification.ledARGB), Integer.valueOf(notification.ledOnMS), Integer.valueOf(notification.ledOffMS)}));
        pw.println(r3.toString());
        pw.println(prefix2 + "vibrate=" + Arrays.toString(notification.vibrate));
    L5:
        pw.println(prefix2 + "mSound= " + this.mSound);
        pw.println(prefix2 + "mVibration= " + this.mVibration);
        pw.println(prefix2 + "mAttributes= " + this.mAttributes);
        pw.println(prefix2 + "mLight= " + this.mLight);
        pw.println(prefix2 + "mShowBadge=" + this.mShowBadge);
        pw.println(prefix2 + "mColorized=" + notification.isColorized());
        pw.println(prefix2 + "mAllowBubble=" + this.mAllowBubble);
        pw.println(prefix2 + "isBubble=" + notification.isBubbleNotification());
        pw.println(prefix2 + "mIsInterruptive=" + this.mIsInterruptive);
        pw.println(prefix2 + "effectiveNotificationChannel=" + getChannel());
        if (getPeopleOverride() == null) goto L9;
        pw.println(prefix2 + "overridePeople= " + TextUtils.join(",", getPeopleOverride()));
    L9:
        if (getSnoozeCriteria() == null) goto L11;
        pw.println(prefix2 + "snoozeCriteria=" + TextUtils.join(",", getSnoozeCriteria()));
    L11:
        pw.println(prefix2 + "mAdjustments=" + this.mAdjustments);
        StringBuilder r4 = new StringBuilder();
        r4.append(prefix2);
        r4.append("shortcut=");
        r4.append(notification.getShortcutId());
        r4.append(" found valid? ");
        boolean r5 = false;
        if (this.mShortcutInfo == null) goto L14;
        boolean r6 = true;
    L15:
        r4.append(r6);
        pw.println(r4.toString());
        pw.println(prefix2 + "mUserVisOverride=" + getPackageVisibilityOverride());
        StringBuilder r7 = new StringBuilder();
        r7.append(prefix2);
        r7.append("hasSummarization=");
        if (this.mSummarization == null) goto L18;
        r5 = true;
    L18:
        r7.append(r5);
        pw.println(r7.toString());
        return;
    L14:
        r6 = false;
        goto L15
    }

    private void dumpNotification(PrintWriter pw, String prefix, Notification notification, boolean redact) {
        if (notification != null) goto L5;
        pw.println(prefix + KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG);
        return;
    L5:
        pw.println(prefix + "fullscreenIntent=" + notification.fullScreenIntent);
        pw.println(prefix + "contentIntent=" + notification.contentIntent);
        pw.println(prefix + "deleteIntent=" + notification.deleteIntent);
        pw.println(prefix + "number=" + notification.number);
        pw.println(prefix + "groupAlertBehavior=" + notification.getGroupAlertBehavior());
        pw.println(prefix + "when=" + notification.when + SliceClientPermissions.SliceAuthority.DELIMITER + notification.getWhen());
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("tickerText=");
        pw.print(r0.toString());
        if (TextUtils.isEmpty(notification.tickerText) == true) goto L16;
        String ticker = notification.tickerText.toString();
        if (redact == true) goto L10;
        pw.println(ticker);
    L17:
        pw.println(prefix + "vis=" + notification.visibility);
        pw.println(prefix + "contentView=" + formatRemoteViews(notification.contentView));
        pw.println(prefix + "bigContentView=" + formatRemoteViews(notification.bigContentView));
        pw.println(prefix + "headsUpContentView=" + formatRemoteViews(notification.headsUpContentView));
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        r1.append(String.format("color=0x%08x", new Object[]{Integer.valueOf(notification.color)}));
        pw.println(r1.toString());
        pw.println(prefix + "timeout=" + Duration.ofMillis(notification.getTimeoutAfter()));
        if (notification.actions == null) goto L33;
        if (notification.actions.length <= 0) goto L33;
        pw.println(prefix + "actions={");
        int N = notification.actions.length;
        int i = 0;
    L22:
        if (i >= N) goto L31;
        Notification.Action action = notification.actions[i];
        if (action == null) goto L30;
        Integer r4 = Integer.valueOf(i);
        CharSequence r5 = action.title;
        if (action.actionIntent != null) goto L28;
        String r6 = "null";
    L29:
        pw.println(String.format("%s    [%d] \"%s\" -> %s", new Object[]{prefix, r4, r5, r6}));
        goto L30
    L28:
        r6 = action.actionIntent.toString();
    L30:
        i = i + 1;
        goto L22
    L31:
        pw.println(prefix + "  }");
    L33:
        if (notification.extras != null) goto L35;
        return;
    L35:
        if (notification.extras.size() <= 0) goto L76;
        pw.println(prefix + "extras={");
        Iterator<String> r2 = notification.extras.keySet().iterator();
    L38:
        if (r2.hasNext() == false) goto L63;
        String key = r2.next();
        pw.print(prefix + "    " + key + "=");
        Object val = notification.extras.get(key);
        if (val == null) goto L41;
        pw.print(val.getClass().getSimpleName());
        if (redact == false) goto L50;
        if ((val instanceof CharSequence) == false) goto L50;
        if (shouldRedactStringExtra(key) == false) goto L50;
        pw.print(String.format(" [length=%d]", new Object[]{Integer.valueOf(((CharSequence) val).length())}));
    L61:
        pw.println();
    L50:
        if ((val instanceof Bitmap) == false) goto L53;
        pw.print(String.format(" (%dx%d)", new Object[]{Integer.valueOf(((Bitmap) val).getWidth()), Integer.valueOf(((Bitmap) val).getHeight())}));
        goto L61
    L53:
        if (val.getClass().isArray() == false) goto L60;
        int N2 = Array.getLength(val);
        pw.print(" (" + N2 + ")");
        if (redact == true) goto L61;
        int j = 0;
    L57:
        if (j >= N2) goto L61;
        pw.println();
        pw.print(String.format("%s      [%d] %s", new Object[]{prefix, Integer.valueOf(j), String.valueOf(Array.get(val, j))}));
        j = j + 1;
        goto L57
    L60:
        pw.print(" (" + String.valueOf(val) + ")");
        goto L61
    L41:
        pw.println("null");
        goto L38
    L63:
        pw.println(prefix + "}");
        return;
    L76:
        return;
    L10:
        if (ticker.length() <= 16) goto L12;
        String r3 = ticker.substring(0, 8);
    L13:
        pw.print(r3);
        pw.println("...");
        goto L17
    L12:
        r3 = "";
        goto L13
    L16:
        pw.println("null");
        goto L17
    }

    private boolean shouldRedactStringExtra(String key) {
        if (key != null) goto L6;
        return true;
    L6:
        switch(key.hashCode()) {
            case -1349298919: goto L15;
            case -330858995: goto L12;
            case 1258919194: goto L9;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L18:
        switch(r1) {
            case 0: goto L20;
            case 1: goto L20;
            case 2: goto L20;
            default: goto L19;
        };
    L19:
        return true;
    L20:
        return false;
    L9:
        if (key.equals("android.support.v4.app.extra.COMPAT_TEMPLATE") == false) goto L17;
        r1 = 2;
        goto L18
    L12:
        if (key.equals("android.substName") == false) goto L17;
        r1 = 0;
        goto L18
    L15:
        if (key.equals("android.template") == false) goto L17;
        r1 = 1;
        goto L18
    }

    public final String toString() {
        return String.format("NotificationRecord(0x%08x: pkg=%s user=%s id=%d tag=%s importance=%d key=%s: %s)", new Object[]{Integer.valueOf(System.identityHashCode(this)), getSbn().getPackageName(), getSbn().getUser(), Integer.valueOf(getSbn().getId()), getSbn().getTag(), Integer.valueOf(this.mImportance), getSbn().getKey(), getSbn().getNotification()});
    }

    public boolean hasAdjustment(String key) {
        List<Adjustment> r0 = this.mAdjustments;
        monitor-enter(r0);
        Iterator<Adjustment> r1 = this.mAdjustments.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        Adjustment adjustment = r1.next();     // Catch: Throwable -> L12
        if (adjustment.getSignals().containsKey(key) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public void addAdjustment(Adjustment adjustment) {
        List<Adjustment> r0 = this.mAdjustments;
        monitor-enter(r0);
        this.mAdjustments.add(adjustment);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void applyAdjustments() {
        System.currentTimeMillis();
        List<Adjustment> r2 = this.mAdjustments;
        monitor-enter(r2);
        Iterator<Adjustment> r3 = this.mAdjustments.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L55;
        Adjustment adjustment = r3.next();     // Catch: Throwable -> L10
        Bundle signals = adjustment.getSignals();     // Catch: Throwable -> L10
        if (signals.containsKey("key_people") == false) goto L13;
        ArrayList<String> people = adjustment.getSignals().getStringArrayList("key_people");     // Catch: Throwable -> L10
        setPeopleOverride(people);     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_people", people.toString());     // Catch: Throwable -> L10
    L13:
        if (signals.containsKey("key_snooze_criteria") == false) goto L16;
        ArrayList<SnoozeCriterion> snoozeCriterionList = adjustment.getSignals().getParcelableArrayList("key_snooze_criteria", SnoozeCriterion.class);     // Catch: Throwable -> L10
        setSnoozeCriteria(snoozeCriterionList);     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_snooze_criteria", snoozeCriterionList.toString());     // Catch: Throwable -> L10
    L16:
        if (signals.containsKey("key_group_key") == false) goto L19;
        String groupOverrideKey = adjustment.getSignals().getString("key_group_key");     // Catch: Throwable -> L10
        setOverrideGroupKey(groupOverrideKey);     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_group_key", groupOverrideKey);     // Catch: Throwable -> L10
    L19:
        if (signals.containsKey("key_user_sentiment") == false) goto L26;
        if (this.mIsAppImportanceLocked == true) goto L26;
        if ((getChannel().getUserLockedFields() & 4) != 0) goto L26;
        setUserSentiment(adjustment.getSignals().getInt("key_user_sentiment", 0));     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_user_sentiment", Integer.toString(getUserSentiment()));     // Catch: Throwable -> L10
    L26:
        if (signals.containsKey("key_contextual_actions") == false) goto L29;
        setSystemGeneratedSmartActions(signals.getParcelableArrayList("key_contextual_actions", Notification.Action.class));     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_contextual_actions", getSystemGeneratedSmartActions().toString());     // Catch: Throwable -> L10
    L29:
        if (signals.containsKey("key_text_replies") == false) goto L32;
        setSmartReplies(signals.getCharSequenceArrayList("key_text_replies"));     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_text_replies", getSmartReplies().toString());     // Catch: Throwable -> L10
    L32:
        if (signals.containsKey("key_importance") == false) goto L35;
        int importance = signals.getInt("key_importance");     // Catch: Throwable -> L10
        int importance2 = Math.min(4, Math.max(-1000, importance));     // Catch: Throwable -> L10
        setAssistantImportance(importance2);     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_importance", Integer.toString(importance2));     // Catch: Throwable -> L10
    L35:
        if (signals.containsKey("key_ranking_score") == false) goto L38;
        this.mRankingScore = signals.getFloat("key_ranking_score");     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_ranking_score", Float.toString(this.mRankingScore));     // Catch: Throwable -> L10
    L38:
        if (signals.containsKey("key_not_conversation") == false) goto L41;
        this.mIsNotConversationOverride = signals.getBoolean("key_not_conversation");     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_not_conversation", Boolean.toString(this.mIsNotConversationOverride));     // Catch: Throwable -> L10
    L41:
        if (signals.containsKey("key_importance_proposal") == false) goto L44;
        this.mProposedImportance = signals.getInt("key_importance_proposal");     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_importance_proposal", Integer.toString(this.mProposedImportance));     // Catch: Throwable -> L10
    L44:
        if (signals.containsKey("key_sensitive_content") == false) goto L47;
        this.mSensitiveContent = signals.getBoolean("key_sensitive_content");     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_sensitive_content", Boolean.toString(this.mSensitiveContent));     // Catch: Throwable -> L10
    L47:
        if (signals.containsKey("key_type") == false) goto L50;
        updateNotificationChannel((NotificationChannel) signals.getParcelable("key_type", NotificationChannel.class));     // Catch: Throwable -> L10
        EventLogTags.writeNotificationAdjusted(getKey(), "key_type", this.mChannel.getId());     // Catch: Throwable -> L10
    L50:
        if (signals.isEmpty() == true) goto L6;
        if (adjustment.getIssuer() == null) goto L6;
        this.mAdjustmentIssuer = adjustment.getIssuer();     // Catch: Throwable -> L10
        goto L6
    L55:
        this.mAdjustments.clear();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    String getAdjustmentIssuer() {
        return this.mAdjustmentIssuer;
    }

    public void setIsAppImportanceLocked(boolean isAppImportanceLocked) {
        this.mIsAppImportanceLocked = isAppImportanceLocked;
        calculateUserSentiment();
    }

    public void setContactAffinity(float contactAffinity) {
        this.mContactAffinity = contactAffinity;
    }

    public float getContactAffinity() {
        return this.mContactAffinity;
    }

    public void setRecentlyIntrusive(boolean recentlyIntrusive) {
        this.mRecentlyIntrusive = recentlyIntrusive;
        if (recentlyIntrusive == false) goto L6;
        this.mLastIntrusive = System.currentTimeMillis();
        return;
    }

    public boolean isRecentlyIntrusive() {
        return this.mRecentlyIntrusive;
    }

    public long getLastIntrusive() {
        return this.mLastIntrusive;
    }

    public void setPackagePriority(int packagePriority) {
        this.mPackagePriority = packagePriority;
    }

    public int getPackagePriority() {
        return this.mPackagePriority;
    }

    public void setPackageVisibilityOverride(int packageVisibility) {
        this.mPackageVisibility = packageVisibility;
    }

    public int getPackageVisibilityOverride() {
        return this.mPackageVisibility;
    }

    private String getUserExplanation() {
        if (this.mUserExplanation != null) goto L6;
        this.mUserExplanation = this.mContext.getResources().getString(R.string.keyguard_accessibility_widget_deleted);
    L6:
        return this.mUserExplanation;
    }

    public void setSystemImportance(int importance) {
        this.mSystemImportance = importance;
        calculateImportance();
    }

    public void setAssistantImportance(int importance) {
        this.mAssistantImportance = importance;
    }

    public int getAssistantImportance() {
        return this.mAssistantImportance;
    }

    public void setImportanceFixed(boolean fixed) {
        this.mImportanceFixed = fixed;
    }

    public boolean isImportanceFixed() {
        return this.mImportanceFixed;
    }

    protected void calculateImportance() {
        this.mImportance = calculateInitialImportance();
        this.mImportanceExplanationCode = this.mInitialImportanceExplanationCode;
        if (getChannel().hasUserSetImportance() == true) goto L10;
        if (this.mAssistantImportance == (-1000)) goto L10;
        if (this.mImportanceFixed == true) goto L10;
        this.mImportance = this.mAssistantImportance;
        this.mImportanceExplanationCode = 3;
    L10:
        if (this.mSystemImportance == (-1000)) goto L13;
        this.mImportance = this.mSystemImportance;
        this.mImportanceExplanationCode = 4;
        return;
    }

    public int getImportance() {
        return this.mImportance;
    }

    int getInitialImportance() {
        return this.stats.naturalImportance;
    }

    public int getProposedImportance() {
        return this.mProposedImportance;
    }

    public boolean hasSensitiveContent() {
        return this.mSensitiveContent;
    }

    public float getRankingScore() {
        return this.mRankingScore;
    }

    int getImportanceExplanationCode() {
        return this.mImportanceExplanationCode;
    }

    int getInitialImportanceExplanationCode() {
        return this.mInitialImportanceExplanationCode;
    }

    public CharSequence getImportanceExplanation() {
        switch(this.mImportanceExplanationCode) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            case 5: goto L11;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        return "system";
    L7:
        return "asst";
    L9:
        return "user";
    L11:
        return "app";
    L13:
        return null;
    }

    public String getSummarization() {
        return null;
    }

    public boolean setIntercepted(boolean intercept) {
        this.mIntercept = intercept;
        this.mInterceptSet = true;
        return this.mIntercept;
    }

    public void setCriticality(int criticality) {
        this.mCriticality = criticality;
    }

    public int getCriticality() {
        return this.mCriticality;
    }

    public boolean isIntercepted() {
        return this.mIntercept;
    }

    public boolean hasInterceptBeenSet() {
        return this.mInterceptSet;
    }

    public boolean isNewEnoughForAlerting(long now) {
        if (getFreshnessMs(now) > 2000) goto L5;
        return true;
    L5:
        return false;
    }

    public void setHidden(boolean hidden) {
        this.mHidden = hidden;
    }

    public boolean isHidden() {
        return this.mHidden;
    }

    public boolean isForegroundService() {
        if ((getFlags() & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setPostSilently(boolean postSilently) {
        this.mPostSilently = postSilently;
    }

    public boolean shouldPostSilently() {
        return this.mPostSilently;
    }

    public void setSuppressedVisualEffects(int effects) {
        this.mSuppressedVisualEffects = effects;
    }

    public int getSuppressedVisualEffects() {
        return this.mSuppressedVisualEffects;
    }

    public boolean isCategory(String category) {
        return Objects.equals(getNotification().category, category);
    }

    public boolean isAudioAttributesUsage(int usage) {
        if (this.mAttributes.getUsage() != usage) goto L5;
        return true;
    L5:
        return false;
    }

    public long getRankingTimeMs() {
        return this.mRankingTimeMs;
    }

    public int getFreshnessMs(long now) {
        return (int) (now - this.mUpdateTimeMs);
    }

    public int getLifespanMs(long now) {
        return (int) (now - this.mCreationTimeMs);
    }

    public int getExposureMs(long now) {
        if (this.mVisibleSinceMs != 0) goto L6;
        return 0;
    L6:
        return (int) (now - this.mVisibleSinceMs);
    }

    public int getInterruptionMs(long now) {
        return (int) (now - this.mInterruptionTimeMs);
    }

    public long getUpdateTimeMs() {
        return this.mUpdateTimeMs;
    }

    public void setVisibility(boolean r12, int r13, int r14, NotificationRecordLogger r15) {
        long r0 = System.currentTimeMillis();
        if (r12 == false) goto L5;
        long r2 = r0;
    L6:
        this.mVisibleSinceMs = r2;
        this.stats.onVisibilityChanged(r12);
        LogMaker r3 = getLogMaker(r0).setCategory(128);
        if (r12 == false) goto L9;
        int r4 = 1;
    L10:
        MetricsLogger.action(r3.setType(r4).addTaggedData(798, Integer.valueOf(r13)).addTaggedData(1395, Integer.valueOf(r14)));
        if (r12 == false) goto L13;
        setSeen();
        MetricsLogger.histogram(this.mContext, "note_freshness", getFreshnessMs(r0));
    L13:
        String r5 = getKey();
        int r7 = getLifespanMs(r0);
        int r8 = getFreshnessMs(r0);
        EventLogTags.writeNotificationVisibility(r5, r12 ? 1 : 0, r7, r8, 0, r13);
        r15.logNotificationVisibility(this, r12);
        return;
    L9:
        r4 = 2;
        goto L10
    L5:
        r2 = this.mVisibleSinceMs;
        goto L6
    }

    private long calculateRankingTimeMs(long previousRankingTimeMs) {
        Notification n = getNotification();
        if (n.hasAppProvidedWhen() == false) goto L9;
        if (n.getWhen() > getSbn().getPostTime()) goto L9;
        return n.getWhen();
    L9:
        if (previousRankingTimeMs <= 0) goto L12;
        return previousRankingTimeMs;
    L12:
        return getSbn().getPostTime();
    }

    public void setGlobalSortKey(String globalSortKey) {
        this.mGlobalSortKey = globalSortKey;
    }

    public String getGlobalSortKey() {
        return this.mGlobalSortKey;
    }

    public boolean isSeen() {
        return this.mStats.hasSeen();
    }

    public void setSeen() {
        this.mStats.setSeen();
        if (this.mTextChanged == false) goto L6;
        setInterruptive(true);
        return;
    }

    public void setAuthoritativeRank(int authoritativeRank) {
        this.mAuthoritativeRank = authoritativeRank;
    }

    public int getAuthoritativeRank() {
        return this.mAuthoritativeRank;
    }

    public String getGroupKey() {
        return getSbn().getGroupKey();
    }

    public void setOverrideGroupKey(String overrideGroupKey) {
        getSbn().setOverrideGroupKey(overrideGroupKey);
    }

    public String getOriginalGroupKey() {
        return getSbn().getNotification().getGroup();
    }

    public NotificationChannel getChannel() {
        return this.mChannel;
    }

    public boolean getIsAppImportanceLocked() {
        return this.mIsAppImportanceLocked;
    }

    protected void updateNotificationChannel(NotificationChannel channel) {
        if (channel == null) goto L8;
        this.mChannel = channel;
        calculateImportance();
        calculateUserSentiment();
        this.mVibration = calculateVibration();
        if (channel.getAudioAttributes() == null) goto L6;
        this.mAttributes = channel.getAudioAttributes();
        return;
    L6:
        this.mAttributes = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        return;
    }

    public void setShowBadge(boolean showBadge) {
        this.mShowBadge = showBadge;
    }

    public boolean canBubble() {
        return this.mAllowBubble;
    }

    public void setAllowBubble(boolean allow) {
        this.mAllowBubble = allow;
    }

    public boolean canShowBadge() {
        return this.mShowBadge;
    }

    public Light getLight() {
        return this.mLight;
    }

    public Uri getSound() {
        return this.mSound;
    }

    public VibrationEffect getVibration() {
        return this.mVibration;
    }

    public AudioAttributes getAudioAttributes() {
        return this.mAttributes;
    }

    public ArrayList<String> getPeopleOverride() {
        return this.mPeopleOverride;
    }

    public void resetRankingTime() {
        this.mRankingTimeMs = calculateRankingTimeMs(getSbn().getPostTime());
    }

    public void setInterruptive(boolean interruptive) {
        this.mIsInterruptive = interruptive;
        long now = System.currentTimeMillis();
        if (interruptive == false) goto L5;
        long r2 = now;
    L6:
        this.mInterruptionTimeMs = r2;
        if (interruptive == false) goto L10;
        MetricsLogger.action(getLogMaker().setCategory(1501).setType(1).addTaggedData(NetworkConstants.ETHER_MTU, Integer.valueOf(getInterruptionMs(now))));
        MetricsLogger.histogram(this.mContext, "note_interruptive", getInterruptionMs(now));
        return;
    L10:
        return;
    L5:
        r2 = this.mInterruptionTimeMs;
        goto L6
    }

    public void setAudiblyAlerted(boolean audiblyAlerted) {
        if (audiblyAlerted == false) goto L4;
        long r0 = System.currentTimeMillis();
    L5:
        this.mLastAudiblyAlertedMs = r0;
        return;
    L4:
        r0 = -1;
        goto L5
    }

    public void setTextChanged(boolean textChanged) {
        this.mTextChanged = textChanged;
    }

    public void setRecordedInterruption(boolean recorded) {
        this.mRecordedInterruption = recorded;
    }

    public boolean hasRecordedInterruption() {
        return this.mRecordedInterruption;
    }

    public boolean isInterruptive() {
        return this.mIsInterruptive;
    }

    public boolean isTextChanged() {
        return this.mTextChanged;
    }

    public long getLastAudiblyAlertedMs() {
        return this.mLastAudiblyAlertedMs;
    }

    protected void setPeopleOverride(ArrayList<String> people) {
        this.mPeopleOverride = people;
    }

    public ArrayList<SnoozeCriterion> getSnoozeCriteria() {
        return this.mSnoozeCriteria;
    }

    protected void setSnoozeCriteria(ArrayList<SnoozeCriterion> snoozeCriteria) {
        this.mSnoozeCriteria = snoozeCriteria;
    }

    private void calculateUserSentiment() {
        if ((getChannel().getUserLockedFields() & 4) == 0) goto L5;
    L6:
        this.mUserSentiment = 1;
        return;
    L5:
        if (this.mIsAppImportanceLocked == true) goto L6;
    }

    private void setUserSentiment(int userSentiment) {
        this.mUserSentiment = userSentiment;
    }

    public int getUserSentiment() {
        return this.mUserSentiment;
    }

    public NotificationStats getStats() {
        return this.mStats;
    }

    public void recordExpanded() {
        this.mStats.setExpanded();
    }

    public void recordDirectReplied() {
        Notification notification = getSbn().getNotification();
        notification.flags |= 65536;
        this.mStats.setDirectReplied();
    }

    public void recordSmartReplied() {
        Notification notification = getSbn().getNotification();
        notification.flags |= 65536;
        this.mStats.setSmartReplied();
    }

    public void recordDismissalSurface(int surface) {
        this.mStats.setDismissalSurface(surface);
    }

    public void recordDismissalSentiment(int sentiment) {
        this.mStats.setDismissalSentiment(sentiment);
    }

    public void recordSnoozed() {
        this.mStats.setSnoozed();
    }

    public void recordViewedSettings() {
        this.mStats.setViewedSettings();
    }

    public void setNumSmartRepliesAdded(int noReplies) {
        this.mNumberOfSmartRepliesAdded = noReplies;
    }

    public int getNumSmartRepliesAdded() {
        return this.mNumberOfSmartRepliesAdded;
    }

    public void setNumSmartActionsAdded(int noActions) {
        this.mNumberOfSmartActionsAdded = noActions;
    }

    public int getNumSmartActionsAdded() {
        return this.mNumberOfSmartActionsAdded;
    }

    public void setSuggestionsGeneratedByAssistant(boolean generatedByAssistant) {
        this.mSuggestionsGeneratedByAssistant = generatedByAssistant;
    }

    public boolean getSuggestionsGeneratedByAssistant() {
        return this.mSuggestionsGeneratedByAssistant;
    }

    public boolean getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public void setEditChoicesBeforeSending(boolean editChoicesBeforeSending) {
        this.mEditChoicesBeforeSending = editChoicesBeforeSending;
    }

    public boolean hasSeenSmartReplies() {
        return this.mHasSeenSmartReplies;
    }

    public void setSeenSmartReplies(boolean hasSeenSmartReplies) {
        this.mHasSeenSmartReplies = hasSeenSmartReplies;
    }

    public boolean hasBeenVisiblyExpanded() {
        return this.stats.hasBeenVisiblyExpanded();
    }

    public boolean isFlagBubbleRemoved() {
        return this.mFlagBubbleRemoved;
    }

    public void setFlagBubbleRemoved(boolean flagBubbleRemoved) {
        this.mFlagBubbleRemoved = flagBubbleRemoved;
    }

    public void setSystemGeneratedSmartActions(ArrayList<Notification.Action> systemGeneratedSmartActions) {
        this.mSystemGeneratedSmartActions = systemGeneratedSmartActions;
    }

    public ArrayList<Notification.Action> getSystemGeneratedSmartActions() {
        return this.mSystemGeneratedSmartActions;
    }

    public void setSmartReplies(ArrayList<CharSequence> smartReplies) {
        this.mSmartReplies = smartReplies;
    }

    public ArrayList<CharSequence> getSmartReplies() {
        return this.mSmartReplies;
    }

    public boolean isProxied() {
        return !Objects.equals(getSbn().getPackageName(), getSbn().getOpPkg());
    }

    public int getNotificationType() {
        if (isConversation() == false) goto L7;
        return 1;
    L7:
        if (getImportance() < 3) goto L10;
        return 2;
    L10:
        return 4;
    }

    public ArraySet<Uri> getGrantableUris() {
        return this.mGrantableUris;
    }

    private void calculateGrantableUris() {
        Trace.beginSection("NotificationRecord.calculateGrantableUris");
        int sourceUid = getSbn().getUid();     // Catch: Throwable -> L18
        if (sourceUid != 1000) goto L8;
        Trace.endSection();
        return;
    L8:
        Notification notification = getNotification();     // Catch: Throwable -> L18
        notification.visitUris(new NotificationRecord$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L18
        if (notification.getChannelId() == null) goto L20;
        NotificationChannel channel = getChannel();     // Catch: Throwable -> L18
        if (channel == null) goto L20;
        Uri r3 = channel.getSound();     // Catch: Throwable -> L18
        if ((channel.getUserLockedFields() & 32) == 0) goto L15;
        boolean r4 = true;
    L16:
        visitGrantableUri(r3, r4, true);     // Catch: Throwable -> L18
        goto L20
    L15:
        r4 = false;
    L20:
        Trace.endSection();
        return;
    L18:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    private /* synthetic */ void lambda$calculateGrantableUris$0(Uri uri) {
        visitGrantableUri(uri, false, false);
    }

    private void visitGrantableUri(Uri uri, boolean userOverriddenUri, boolean isSound) {
        if (uri != null) goto L5;
        return;
    L5:
        if (this.mGrantableUris != null) goto L7;
    L9:
        int sourceUid = getSbn().getUid();
        PermissionHelper.grantUriPermission(this.mUgmInternal, uri, sourceUid);     // Catch: SecurityException -> L13
        if (this.mGrantableUris != null) goto L15;
        this.mGrantableUris = new ArraySet();     // Catch: SecurityException -> L13
    L15:
        this.mGrantableUris.add(uri);     // Catch: SecurityException -> L13
        return;
    L13:
        e = move-exception;
        if (userOverriddenUri == false) goto L20;
        return;
    L20:
        if (isSound == false) goto L23;
        this.mSound = Settings.System.DEFAULT_NOTIFICATION_URI;
        Log.w(TAG, "Replacing " + uri + " from " + sourceUid + ": " + e.getMessage());
        return;
    L23:
        if (this.mTargetSdkVersion >= 28) goto L25;
        Log.w(TAG, "Ignoring " + uri + " from " + sourceUid + ": " + e.getMessage());
        return;
    L25:
        throw e;
    L7:
        if (this.mGrantableUris.contains(uri) == false) goto L9;
    }

    public LogMaker getLogMaker(long now) {
        LogMaker lm = getSbn().getLogMaker().addTaggedData(858, Integer.valueOf(this.mImportance)).addTaggedData(793, Integer.valueOf(getLifespanMs(now))).addTaggedData(795, Integer.valueOf(getFreshnessMs(now))).addTaggedData(794, Integer.valueOf(getExposureMs(now))).addTaggedData(NetworkConstants.ETHER_MTU, Integer.valueOf(getInterruptionMs(now)));
        if (this.mImportanceExplanationCode == 0) goto L12;
        lm.addTaggedData(1688, Integer.valueOf(this.mImportanceExplanationCode));
        if (this.mImportanceExplanationCode == 3) goto L9;
        if (this.mImportanceExplanationCode != 4) goto L12;
    L9:
        if (this.stats.naturalImportance == (-1000)) goto L12;
        lm.addTaggedData(1690, Integer.valueOf(this.mInitialImportanceExplanationCode));
        lm.addTaggedData(1689, Integer.valueOf(this.stats.naturalImportance));
    L12:
        if (this.mAssistantImportance == (-1000)) goto L15;
        lm.addTaggedData(1691, Integer.valueOf(this.mAssistantImportance));
    L15:
        if (this.mAdjustmentIssuer == null) goto L17;
        lm.addTaggedData(1742, Integer.valueOf(this.mAdjustmentIssuer.hashCode()));
    L17:
        return lm;
    }

    public LogMaker getLogMaker() {
        return getLogMaker(System.currentTimeMillis());
    }

    public LogMaker getItemLogMaker() {
        return getLogMaker().setCategory(128);
    }

    public boolean hasUndecoratedRemoteView() {
        Notification notification = getNotification();
        if (notification.isStyle(Notification.DecoratedCustomViewStyle.class) == false) goto L5;
    L8:
        boolean hasDecoratedStyle = true;
    L10:
        if (notification.contentView == null) goto L12;
    L17:
        boolean hasCustomRemoteView = true;
    L18:
        if (hasCustomRemoteView == false) goto L22;
        if (hasDecoratedStyle == true) goto L22;
        return true;
    L22:
        return false;
    L12:
        if (notification.bigContentView != null) goto L17;
        if (notification.headsUpContentView != null) goto L17;
        hasCustomRemoteView = false;
        goto L18
    L5:
        if (notification.isStyle(Notification.DecoratedMediaCustomViewStyle.class) == true) goto L8;
        hasDecoratedStyle = false;
        goto L10
    }

    public void setShortcutInfo(ShortcutInfo shortcutInfo) {
        this.mShortcutInfo = shortcutInfo;
    }

    public ShortcutInfo getShortcutInfo() {
        return this.mShortcutInfo;
    }

    public void setHasSentValidMsg(boolean hasSentValidMsg) {
        this.mHasSentValidMsg = hasSentValidMsg;
    }

    public void userDemotedAppFromConvoSpace(boolean userDemoted) {
        this.mAppDemotedFromConvo = userDemoted;
    }

    public void setPkgAllowedAsConvo(boolean allowedAsConvo) {
        this.mPkgAllowedAsConvo = allowedAsConvo;
    }

    public boolean isCanceledAfterLifetimeExtension() {
        return this.mCanceledAfterLifetimeExtension;
    }

    public void setCanceledAfterLifetimeExtension(boolean canceledAfterLifetimeExtension) {
        this.mCanceledAfterLifetimeExtension = canceledAfterLifetimeExtension;
    }

    public int getBundleType() {
        return this.mBundleType;
    }

    public void setBundleType(int bundleType) {
        this.mBundleType = bundleType;
    }

    public boolean isConversation() {
        Notification notification = getNotification();
        if (this.mChannel.isDemoted() == false) goto L5;
    L37:
        return false;
    L5:
        if (this.mAppDemotedFromConvo == true) goto L37;
        if (this.mIsNotConversationOverride == false) goto L11;
        return false;
    L11:
        if (notification.isStyle(Notification.MessagingStyle.class) == true) goto L21;
        if (this.mPkgAllowedAsConvo == true) goto L15;
    L19:
        return false;
    L15:
        if (this.mTargetSdkVersion >= 30) goto L19;
        if ("msg".equals(getNotification().category) == false) goto L19;
        return true;
    L21:
        if (this.mTargetSdkVersion < 30) goto L32;
        if (notification.isStyle(Notification.MessagingStyle.class) == false) goto L32;
        if (this.mShortcutInfo != null) goto L27;
    L30:
        return false;
    L27:
        if (isOnlyBots(this.mShortcutInfo.getPersons()) == true) goto L30;
    L32:
        if (this.mHasSentValidMsg == true) goto L34;
    L36:
        return true;
    L34:
        if (this.mShortcutInfo != null) goto L36;
        return false;
    }

    private boolean isOnlyBots(Person[] persons) {
        if (persons != null) goto L5;
    L15:
        return false;
    L5:
        if (persons.length == 0) goto L15;
        int r1 = persons.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        Person person = persons[r2];
        if (person.isBot() == false) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    StatusBarNotification getSbn() {
        return this.sbn;
    }

    public boolean rankingScoreMatches(float otherScore) {
        if (Math.abs(this.mRankingScore - otherScore) >= 1.0E-4d) goto L5;
        return true;
    L5:
        return false;
    }

    protected void setPendingLogUpdate(boolean pendingLogUpdate) {
        this.mPendingLogUpdate = pendingLogUpdate;
    }

    protected boolean hasPendingLogUpdate() {
        return this.mPendingLogUpdate;
    }

    public void mergePhoneNumbers(ArraySet<String> phoneNumbers) {
        if (phoneNumbers != null) goto L4;
        return;
    L4:
        if (phoneNumbers.size() != 0) goto L7;
        return;
    L7:
        if (this.mPhoneNumbers != null) goto L9;
        this.mPhoneNumbers = new ArraySet();
    L9:
        this.mPhoneNumbers.addAll(phoneNumbers);
    }

    public ArraySet<String> getPhoneNumbers() {
        return this.mPhoneNumbers;
    }

    boolean isLocked() {
        if (getKeyguardManager().isKeyguardLocked() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mPowerManager.isInteractive() == false) goto L8;
        return false;
    }

    private KeyguardManager getKeyguardManager() {
        if (this.mKeyguardManager != null) goto L6;
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
    L6:
        return this.mKeyguardManager;
    }

    public NotificationRecordSmtEx getSmtEx() {
        return this.mSmtEx;
    }
}
