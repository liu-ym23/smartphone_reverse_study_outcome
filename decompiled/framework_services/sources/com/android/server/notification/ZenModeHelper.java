package com.android.server.notification;

import android.R;
import android.app.AppOpsManager;
import android.app.AutomaticZenRule;
import android.app.NotificationManager;
import android.app.backup.BackupRestoreEventLogger;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioManagerInternal;
import android.media.VolumePolicy;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.Condition;
import android.service.notification.DeviceEffectsApplier;
import android.service.notification.SystemZenRules;
import android.service.notification.ZenAdapters;
import android.service.notification.ZenDeviceEffects;
import android.service.notification.ZenModeConfig;
import android.service.notification.ZenPolicy;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.StatsEvent;
import android.util.proto.ProtoOutputStream;
import com.android.internal.config.sysui.SystemUiSystemPropertiesFlags;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeHelper {
    static final boolean DEBUG = false;
    private static final Duration DELETED_RULE_KEPT_FOR = null;
    private static final Duration IMPLICIT_RULE_KEPT_FOR = null;
    private static final int MAX_ICON_RESOURCE_NAME_LENGTH = 1000;
    private static final String PACKAGE_ANDROID = "android";
    private static final int RULE_INSTANCE_GRACE_PERIOD = 259200000;
    static final int RULE_LIMIT_PER_PACKAGE = 100;
    static final long SEND_ACTIVATION_AZR_STATUSES = 308673617;
    public static final long SUPPRESSED_EFFECT_ALL = 3;
    public static final long SUPPRESSED_EFFECT_CALLS = 2;
    public static final long SUPPRESSED_EFFECT_NOTIFICATIONS = 1;
    static final String TAG = "ZenModeHelper";
    private final AppOpsManager mAppOps;
    protected AudioManagerInternal mAudioManager;
    private final ArrayList<Callback> mCallbacks;
    private final Clock mClock;
    protected final ZenModeConditions mConditions;
    protected ZenModeConfig mConfig;
    private final Object mConfigLock;
    final SparseArray<ZenModeConfig> mConfigs;
    private ZenDeviceEffects mConsolidatedDeviceEffects;
    protected NotificationManager.Policy mConsolidatedPolicy;
    private final Context mContext;
    private final ZenModeConfig mDefaultConfig;
    private DeviceEffectsApplier mDeviceEffectsApplier;
    private final ZenModeFiltering mFiltering;
    private final SystemUiSystemPropertiesFlags.FlagResolver mFlagResolver;
    private final H mHandler;
    protected boolean mIsSystemServicesReady;
    private final Metrics mMetrics;
    protected PackageManager mPm;
    private String[] mPriorityOnlyDndExemptPackages;
    private final RingerModeDelegate mRingerModeDelegate;
    protected final ArrayMap<String, Integer> mRulesUidCache;
    private final ManagedServices.Config mServiceConfig;
    private final SettingsObserver mSettingsObserver;
    private long mSuppressedEffects;
    private int mUser;
    protected int mZenMode;
    private final ZenModeEventLogger mZenModeEventLogger;
    private ZenModeHelperExtProxy mZenModeHelperExtProxy;

    public static class Callback {
        public Callback() {
        }

        void onConfigChanged() {
        }

        void onZenModeChanged() {
        }

        void onPolicyChanged(NotificationManager.Policy newPolicy) {
        }

        void onConsolidatedPolicyChanged(NotificationManager.Policy newConsolidatedPolicy) {
        }

        void onAutomaticRuleStatusChanged(int userId, String pkg, String id, int status) {
        }
    }

    private final class H extends Handler {
        private static final long METRICS_PERIOD_MS = 21600000;
        private static final int MSG_APPLY_EFFECTS = 6;
        private static final int MSG_AUDIO_APPLIED_TO_RINGER = 7;
        private static final int MSG_AUDIO_NOT_APPLIED_TO_RINGER = 8;
        private static final int MSG_DISPATCH = 1;
        private static final int MSG_METRICS = 2;
        final /* synthetic */ ZenModeHelper this$0;

        /* JADX INFO: renamed from: -$$Nest$mpostApplyDeviceEffects, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6321$$Nest$mpostApplyDeviceEffects(H r0, int r1) {
            r0.postApplyDeviceEffects(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mpostDispatchOnZenModeChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6322$$Nest$mpostDispatchOnZenModeChanged(H r0) {
            r0.postDispatchOnZenModeChanged();
        }

        /* JADX INFO: renamed from: -$$Nest$mpostMetricsTimer, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6323$$Nest$mpostMetricsTimer(H r0) {
            r0.postMetricsTimer();
        }

        /* JADX INFO: renamed from: -$$Nest$mpostUpdateRingerAndAudio, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6324$$Nest$mpostUpdateRingerAndAudio(H r0, boolean r1) {
            r0.postUpdateRingerAndAudio(r1);
        }

        /* synthetic */ H(ZenModeHelper r1, Looper r2, ZenModeHelperIA r3) {
            this(r1, r2);
        }

        private H(ZenModeHelper r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        private void postDispatchOnZenModeChanged() {
            removeMessages(1);
            sendEmptyMessage(1);
        }

        private void postMetricsTimer() {
            removeMessages(2);
            sendEmptyMessageDelayed(2, METRICS_PERIOD_MS);
        }

        private void postUpdateRingerAndAudio(boolean shouldApplyToRinger) {
            if (shouldApplyToRinger == false) goto L4;
            removeMessages(7);
            sendEmptyMessage(7);
            return;
        L4:
            removeMessages(8);
            sendEmptyMessage(8);
        }

        private void postApplyDeviceEffects(int origin) {
            removeMessages(6);
            sendMessage(obtainMessage(6, origin, 0));
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L15;
                case 4: goto L15;
                case 5: goto L15;
                case 6: goto L7;
                case 7: goto L6;
                case 8: goto L5;
                default: goto L15;
            };
        L5:
            ZenModeHelper.m6320$$Nest$mupdateRingerAndAudio(this.this$0, false);
            return;
        L6:
            ZenModeHelper.m6320$$Nest$mupdateRingerAndAudio(this.this$0, true);
            return;
        L7:
            int origin = msg.arg1;
            ZenModeHelper.m6315$$Nest$mapplyConsolidatedDeviceEffects(this.this$0, origin);
            return;
        L8:
            Metrics.m6325$$Nest$memit(ZenModeHelper.m6314$$Nest$fgetmMetrics(this.this$0));
            return;
        L9:
            ZenModeHelper.m6316$$Nest$mdispatchOnZenModeChanged(this.this$0);
            return;
        }
    }

    private final class Metrics extends Callback {
        private static final String COUNTER_MODE_PREFIX = "dnd_mode_";
        private static final String COUNTER_RULE = "dnd_rule_count";
        private static final String COUNTER_TYPE_PREFIX = "dnd_type_";
        private static final int DND_OFF = 0;
        private static final int DND_ON_AUTOMATIC = 2;
        private static final int DND_ON_MANUAL = 1;
        private static final long MINIMUM_LOG_PERIOD_MS = 60000;
        private long mModeLogTimeMs;
        private int mNumZenRules;
        private int mPreviousZenMode;
        private int mPreviousZenType;
        private long mRuleCountLogTime;
        private long mTypeLogTimeMs;
        final /* synthetic */ ZenModeHelper this$0;

        /* JADX INFO: renamed from: -$$Nest$memit, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6325$$Nest$memit(Metrics r0) {
            r0.emit();
        }

        /* synthetic */ Metrics(ZenModeHelper r1, ZenModeHelperIA r2) {
            this(r1);
        }

        private Metrics(ZenModeHelper r3) {
            this.this$0 = r3;
            this.mPreviousZenMode = -1;
            this.mModeLogTimeMs = 0;
            this.mNumZenRules = -1;
            this.mRuleCountLogTime = 0;
            this.mPreviousZenType = -1;
            this.mTypeLogTimeMs = 0;
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onZenModeChanged() {
            emit();
        }

        @Override // com.android.server.notification.ZenModeHelper.Callback
        void onConfigChanged() {
            emit();
        }

        private void emit() {
            H.m6323$$Nest$mpostMetricsTimer(ZenModeHelper.m6313$$Nest$fgetmHandler(this.this$0));
            emitZenMode();
            emitRules();
            emitDndType();
        }

        private void emitZenMode() {
            long now = SystemClock.elapsedRealtime();
            long since = now - this.mModeLogTimeMs;
            if (this.mPreviousZenMode != this.this$0.mZenMode) goto L7;
            if (since > 60000) goto L7;
            return;
        L7:
            if (this.mPreviousZenMode == (-1)) goto L9;
            MetricsLogger.count(ZenModeHelper.m6312$$Nest$fgetmContext(this.this$0), COUNTER_MODE_PREFIX + this.mPreviousZenMode, (int) since);
        L9:
            this.mPreviousZenMode = this.this$0.mZenMode;
            this.mModeLogTimeMs = now;
        }

        private void emitRules() {
            long now = SystemClock.elapsedRealtime();
            long since = now - this.mRuleCountLogTime;
            Object r4 = ZenModeHelper.m6311$$Nest$fgetmConfigLock(this.this$0);
            monitor-enter(r4);
            int numZenRules = this.this$0.mConfig.automaticRules.size();     // Catch: Throwable -> L11
            if (this.mNumZenRules != numZenRules) goto L9;
            if (since > 60000) goto L9;
        L14:
            monitor-exit(r4);     // Catch: Throwable -> L11
            return;
        L9:
            if (this.mNumZenRules == (-1)) goto L13;
            MetricsLogger.count(ZenModeHelper.m6312$$Nest$fgetmContext(this.this$0), COUNTER_RULE, numZenRules - this.mNumZenRules);     // Catch: Throwable -> L11
        L13:
            this.mNumZenRules = numZenRules;     // Catch: Throwable -> L11
            this.mRuleCountLogTime = since;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        private void emitDndType() {
            long now = SystemClock.elapsedRealtime();
            long since = now - this.mTypeLogTimeMs;
            Object r4 = ZenModeHelper.m6311$$Nest$fgetmConfigLock(this.this$0);
            monitor-enter(r4);
            int zenType = 0;
            if (this.this$0.mZenMode == 0) goto L7;
            boolean dndOn = true;
        L8:
            if (dndOn == true) goto L11;
        L15:
            if (zenType != this.mPreviousZenType) goto L19;
            if (since > 60000) goto L19;
        L24:
            monitor-exit(r4);     // Catch: Throwable -> L21
            return;
        L19:
            if (this.mPreviousZenType == (-1)) goto L23;
            MetricsLogger.count(ZenModeHelper.m6312$$Nest$fgetmContext(this.this$0), COUNTER_TYPE_PREFIX + this.mPreviousZenType, (int) since);     // Catch: Throwable -> L21
        L23:
            this.mTypeLogTimeMs = now;     // Catch: Throwable -> L21
            this.mPreviousZenType = zenType;     // Catch: Throwable -> L21
            goto L24
        L11:
            if (this.this$0.mConfig.manualRule == null) goto L13;
            zenType = 1;
            goto L15
        L13:
            zenType = 2;
            goto L15
        L7:
            dndOn = false;
        L21:
            th = move-exception;
            throw th;
        }
    }

    protected final class RingerModeDelegate implements AudioManagerInternal.RingerModeDelegate {
        final /* synthetic */ ZenModeHelper this$0;

        protected RingerModeDelegate(ZenModeHelper this$0) {
            this.this$0 = this$0;
        }

        public String toString() {
            return ZenModeHelper.TAG;
        }

        public int onSetRingerModeInternal(int ringerModeOld, int ringerModeNew, String caller, int ringerModeExternal, VolumePolicy policy) {
            if (ringerModeOld == ringerModeNew) goto L5;
            boolean isChange = true;
        L6:
            int ringerModeExternalOut = ringerModeNew;
            if (this.this$0.mZenMode != 0) goto L9;
        L12:
            ZenModeHelper.m6319$$Nest$msetPreviousRingerModeSetting(this.this$0, Integer.valueOf(ringerModeNew));
        L13:
            int newZen = -1;
            switch(ringerModeNew) {
                case 0: goto L31;
                case 1: goto L16;
                case 2: goto L16;
                default: goto L39;
            };
        L16:
            if (isChange == false) goto L28;
            if (ringerModeOld != 0) goto L28;
            if (this.this$0.mZenMode != 2) goto L21;
        L26:
            int newZen2 = 0;
        L41:
            if (newZen2 == (-1)) goto L43;
            int r0 = -1;
            ZenModeHelper.m6318$$Nest$msetManualZenMode(this.this$0, UserHandle.CURRENT, newZen2, null, 5, "ringerModeInternal", null, false, 1000);
        L44:
            if (isChange == true) goto L49;
            if (newZen2 != r0) goto L49;
            if (ringerModeExternal != ringerModeExternalOut) goto L49;
        L50:
            return ringerModeExternalOut;
        L49:
            ZenLog.traceSetRingerModeInternal(ringerModeOld, ringerModeNew, caller, ringerModeExternal, ringerModeExternalOut);
            goto L50
        L43:
            r0 = -1;
            goto L44
        L21:
            if (this.this$0.mZenMode == 3) goto L26;
            if (this.this$0.mZenMode != 1) goto L28;
            if (areAllPriorityOnlyRingerSoundsMuted() == true) goto L26;
        L28:
            if (this.this$0.mZenMode == 0) goto L39;
            ringerModeExternalOut = 0;
            newZen2 = -1;
            goto L41
        L31:
            if (isChange == false) goto L39;
            if (policy.doNotDisturbWhenSilent == false) goto L39;
            if (this.this$0.mZenMode != 0) goto L37;
            newZen = 1;
        L37:
            ZenModeHelper.m6319$$Nest$msetPreviousRingerModeSetting(this.this$0, Integer.valueOf(ringerModeOld));
            newZen2 = newZen;
        L39:
            newZen2 = -1;
            goto L41
        L9:
            if (this.this$0.mZenMode != 1) goto L13;
            if (areAllPriorityOnlyRingerSoundsMuted() == true) goto L13;
        L5:
            isChange = false;
            goto L6
        }

        private boolean areAllPriorityOnlyRingerSoundsMuted() {
            Object r0 = ZenModeHelper.m6311$$Nest$fgetmConfigLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = ZenModeConfig.areAllPriorityOnlyRingerSoundsMuted(this.this$0.mConfig);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int onSetRingerModeExternal(int ringerModeOld, int ringerModeNew, String caller, int ringerModeInternal, VolumePolicy policy) {
            int ringerModeInternalOut = ringerModeNew;
            int r5 = 0;
            if (ringerModeOld == ringerModeNew) goto L5;
            boolean isChange = true;
        L6:
            if (ringerModeInternal != 1) goto L8;
            boolean isVibrate = true;
        L9:
            int newZen = -1;
            switch(ringerModeNew) {
                case 0: goto L16;
                case 1: goto L13;
                case 2: goto L13;
                default: goto L15;
            };
        L16:
            if (isChange == true) goto L18;
            ringerModeInternalOut = ringerModeInternal;
            int newZen2 = -1;
        L26:
            if (newZen2 == (-1)) goto L28;
            ZenModeHelper.m6318$$Nest$msetManualZenMode(this.this$0, UserHandle.CURRENT, newZen2, null, 5, "ringerModeExternal", caller, false, 1000);
        L28:
            ZenLog.traceSetRingerModeExternal(ringerModeOld, ringerModeNew, caller, ringerModeInternal, ringerModeInternalOut);
            return ringerModeInternalOut;
        L18:
            if (this.this$0.mZenMode != 0) goto L20;
            newZen = 1;
        L20:
            if (isVibrate == false) goto L23;
            r5 = 1;
        L23:
            ringerModeInternalOut = r5;
            newZen2 = newZen;
        L15:
            newZen2 = -1;
            goto L26
        L13:
            if (this.this$0.mZenMode == 0) goto L15;
            newZen2 = 0;
            goto L26
        L8:
            isVibrate = false;
            goto L9
        L5:
            isChange = false;
            goto L6
        }

        public boolean canVolumeDownEnterSilent() {
            if (this.this$0.mZenMode != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int getRingerModeAffectedStreams(int streams) {
            int streams2 = streams | 38;
            if (this.this$0.mZenMode != 2) goto L6;
            return streams2 | 2072;
        L6:
            return streams2 & (-2073);
        }
    }

    private final class SettingsObserver extends ContentObserver {
        private final Uri ZEN_MODE;
        final /* synthetic */ ZenModeHelper this$0;

        public SettingsObserver(ZenModeHelper r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
            this.ZEN_MODE = Settings.Global.getUriFor("zen_mode");
        }

        public void observe() {
            ContentResolver resolver = ZenModeHelper.m6312$$Nest$fgetmContext(this.this$0).getContentResolver();
            resolver.registerContentObserver(this.ZEN_MODE, false, this);
            update(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            update(uri);
        }

        public void update(Uri uri) {
            if (this.ZEN_MODE.equals(uri) == true) goto L5;
            return;
        L5:
            if (this.this$0.mZenMode != ZenModeHelper.m6317$$Nest$mgetZenModeSetting(this.this$0)) goto L7;
            return;
        L7:
            if (ZenModeHelper.DEBUG == false) goto L9;
            Log.d(ZenModeHelper.TAG, "Fixing zen mode setting");
        L9:
            this.this$0.setZenModeSetting(this.this$0.mZenMode);
        }
    }

    public static /* synthetic */ String $r8$lambda$0g2TCyxqVWjORDguCddL_QuImw0(ZenModeHelper r0, ZenModeConfig.ZenRule r1) {
        return r0.lambda$updateImplicitZenRuleNameAndDescription$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfigLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m6311$$Nest$fgetmConfigLock(ZenModeHelper r0) {
        return r0.mConfigLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6312$$Nest$fgetmContext(ZenModeHelper r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ H m6313$$Nest$fgetmHandler(ZenModeHelper r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ Metrics m6314$$Nest$fgetmMetrics(ZenModeHelper r0) {
        return r0.mMetrics;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyConsolidatedDeviceEffects, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6315$$Nest$mapplyConsolidatedDeviceEffects(ZenModeHelper r0, int r1) {
        r0.applyConsolidatedDeviceEffects(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchOnZenModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6316$$Nest$mdispatchOnZenModeChanged(ZenModeHelper r0) {
        r0.dispatchOnZenModeChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetZenModeSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m6317$$Nest$mgetZenModeSetting(ZenModeHelper r0) {
        return r0.getZenModeSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$msetManualZenMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6318$$Nest$msetManualZenMode(ZenModeHelper r0, UserHandle r1, int r2, Uri r3, int r4, String r5, String r6, boolean r7, int r8) {
        r0.setManualZenMode(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX INFO: renamed from: -$$Nest$msetPreviousRingerModeSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6319$$Nest$msetPreviousRingerModeSetting(ZenModeHelper r0, Integer r1) {
        r0.setPreviousRingerModeSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRingerAndAudio, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6320$$Nest$mupdateRingerAndAudio(ZenModeHelper r0, boolean r1) {
        r0.updateRingerAndAudio(r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        DELETED_RULE_KEPT_FOR = Duration.ofDays(30);
        IMPLICIT_RULE_KEPT_FOR = Duration.ofDays(30);
    }

    public ZenModeHelper(Context context, Looper looper, Clock clock, ConditionProviders conditionProviders, SystemUiSystemPropertiesFlags.FlagResolver flagResolver, ZenModeEventLogger zenModeEventLogger) {
        this.mRulesUidCache = new ArrayMap();
        this.mCallbacks = new ArrayList();
        this.mRingerModeDelegate = new RingerModeDelegate(this);
        this.mConfigs = new SparseArray();
        ZenModeHelperIA r1 = null;
        this.mMetrics = new Metrics(this, r1);
        this.mConsolidatedDeviceEffects = new ZenDeviceEffects.Builder().build();
        this.mUser = 0;
        this.mConfigLock = new Object();
        this.mContext = context;
        this.mHandler = new H(this, looper, r1);
        this.mClock = clock;
        addCallback(this.mMetrics);
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mDefaultConfig = ZenModeConfig.getDefaultConfig();
        updateDefaultConfig(this.mContext, this.mDefaultConfig);
        Object r2 = this.mConfigLock;
        monitor-enter(r2);
        this.mConfig = this.mDefaultConfig.copy();     // Catch: Throwable -> L8
        this.mConfigs.put(0, this.mConfig);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        this.mConsolidatedPolicy = this.mConfig.toNotificationPolicy();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mSettingsObserver.observe();
        this.mFiltering = new ZenModeFiltering(this.mContext);
        this.mConditions = new ZenModeConditions(this, conditionProviders);
        this.mServiceConfig = conditionProviders.getConfig();
        this.mFlagResolver = flagResolver;
        this.mZenModeEventLogger = zenModeEventLogger;
        this.mZenModeHelperExtProxy = ZenModeHelperExtProxy.get(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return TAG;
    }

    public boolean matchesCallFilter(UserHandle userHandle, Bundle extras, ValidateNotificationPeople validator, int contactsTimeoutMs, float timeoutAffinity, int callingUid) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        boolean r0 = ZenModeFiltering.matchesCallFilter(this.mContext, this.mZenMode, this.mConsolidatedPolicy, userHandle, extras, validator, contactsTimeoutMs, timeoutAffinity, callingUid);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCall(NotificationRecord record) {
        return this.mFiltering.isCall(record);
    }

    public void recordCaller(NotificationRecord record) {
        this.mFiltering.recordCall(record);
    }

    protected void cleanUpCallersAfter(long timeThreshold) {
        this.mFiltering.cleanUpCallersAfter(timeThreshold);
    }

    public boolean shouldIntercept(NotificationRecord record) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        boolean r1 = this.mFiltering.shouldIntercept(this.mZenMode, this.mConsolidatedPolicy, record);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    public List<Callback> getCallbacks() {
        return this.mCallbacks;
    }

    public void initZenMode() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "initZenMode");
    L5:
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        updateConfigAndZenModeLocked(this.mConfig, 1, "init", true, 1000);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onSystemReady() {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onSystemReady");
    L5:
        this.mAudioManager = (AudioManagerInternal) LocalServices.getService(AudioManagerInternal.class);
        if (this.mAudioManager == null) goto L8;
        this.mAudioManager.setRingerModeDelegate(this.mRingerModeDelegate);
    L8:
        this.mPm = this.mContext.getPackageManager();
        H.m6323$$Nest$mpostMetricsTimer(this.mHandler);
        cleanUpZenRules();
        this.mIsSystemServicesReady = true;
    }

    boolean hasDeviceEffectsApplier() {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeviceEffectsApplier == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void setDeviceEffectsApplier(DeviceEffectsApplier deviceEffectsApplier) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeviceEffectsApplier != null) goto L13;
        this.mDeviceEffectsApplier = deviceEffectsApplier;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        applyConsolidatedDeviceEffects(1);
        return;
    L13:
        throw new IllegalStateException("Already set up a DeviceEffectsApplier!");     // Catch: Throwable -> L10
    }

    public void onUserSwitched(int user) {
        loadConfigForUser(user, "onUserSwitched");
    }

    public void onUserRemoved(int user) {
        if (user >= 0) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Log.d(TAG, "onUserRemoved u=" + user);
    L7:
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        this.mConfigs.remove(user);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void setPriorityOnlyDndExemptPackages(String[] packages) {
        this.mPriorityOnlyDndExemptPackages = packages;
    }

    private void loadConfigForUser(int user, String reason) {
        if (this.mUser == user) goto L42;
        if (user < 0) goto L53;
        this.mUser = user;
        if (DEBUG == false) goto L9;
        Log.d(TAG, reason + " u=" + user);
    L9:
        ZenModeConfig config = null;
        Object r2 = this.mConfigLock;
        monitor-enter(r2);
    L35:
        th = th;
    L49:
        monitor-exit(r2);     // Catch: Throwable -> L39
        throw th;
    L39:
        th = th;
        goto L49
    L12:
        if (this.mConfigs.get(user) != null) goto L45;
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L35
        if (config == null) goto L20;
        ZenModeConfig config2 = config;
    L24:
        Object r8 = this.mConfigLock;
        monitor-enter(r8);
        setConfigLocked(config2, null, 2, reason, 1000);     // Catch: Throwable -> L31
        monitor-exit(r8);     // Catch: Throwable -> L31
        cleanUpZenRules();
        return;
    L31:
        th = move-exception;
        throw th;
    L20:
        if (DEBUG == false) goto L22;
        Log.d(TAG, reason + " generating default config for user " + user);
    L22:
        ZenModeConfig config3 = this.mDefaultConfig.copy();
        config3.user = user;
        config2 = config3;
        goto L24
    L45:
        config = this.mConfigs.get(user).copy();     // Catch: Throwable -> L15
    L15:
        th = th;
        goto L49
    L53:
        return;
    }

    public int getZenModeListenerInterruptionFilter() {
        return NotificationManager.zenModeToInterruptionFilter(this.mZenMode);
    }

    public void setSuppressedEffects(long suppressedEffects) {
        if (this.mSuppressedEffects != suppressedEffects) goto L5;
        return;
    L5:
        this.mSuppressedEffects = suppressedEffects;
        applyRestrictions();
    }

    public long getSuppressedEffects() {
        return this.mSuppressedEffects;
    }

    public int getZenMode() {
        return this.mZenMode;
    }

    Map<String, AutomaticZenRule> getAutomaticZenRules(UserHandle user, int callingUid) {
        HashMap<String, AutomaticZenRule> rules = new HashMap();
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return rules;
    L10:
        Iterator r3 = config.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L17;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r3.next();     // Catch: Throwable -> L8
        if (canManageAutomaticZenRule(rule, callingUid) == false) goto L12;
        rules.put(rule.id, zenRuleToAutomaticZenRule(rule));     // Catch: Throwable -> L8
        goto L12
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return rules;
    L8:
        th = move-exception;
        throw th;
    }

    public AutomaticZenRule getAutomaticZenRule(UserHandle user, String id, int callingUid) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) config.automaticRules.get(id);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (rule != null) goto L15;
        return null;
    L15:
        if (canManageAutomaticZenRule(rule, callingUid) == true) goto L17;
        return null;
    L17:
        return zenRuleToAutomaticZenRule(rule);
    L8:
        th = move-exception;
        throw th;
    }

    public String addAutomaticZenRule(UserHandle user, String pkg, AutomaticZenRule automaticZenRule, int origin, String reason, int callingUid) {
        checkManageRuleOrigin("addAutomaticZenRule", origin);
        if ("android".equals(pkg) == true) goto L20;
        PackageItemInfo component = getServiceInfo(automaticZenRule.getOwner());
        if (component != null) goto L7;
        component = getActivityInfo(automaticZenRule.getConfigurationActivity());
    L7:
        if (component == null) goto L19;
        int ruleInstanceLimit = -1;
        if (component.metaData == null) goto L11;
        ruleInstanceLimit = component.metaData.getInt("android.service.zen.automatic.ruleInstanceLimit", -1);
    L11:
        int newRuleInstanceCount = (getCurrentInstanceCount(user, automaticZenRule.getOwner()) + getCurrentInstanceCount(user, automaticZenRule.getConfigurationActivity())) + 1;
        int newPackageRuleCount = getPackageRuleCount(user, pkg) + 1;
        if (newPackageRuleCount > 100) goto L17;
        if (ruleInstanceLimit <= 0) goto L20;
        if (ruleInstanceLimit >= newRuleInstanceCount) goto L20;
    L17:
        throw new IllegalArgumentException("Rule instance limit exceeded");
    L19:
        throw new IllegalArgumentException("Lacking enabled CPS or config activity");
    L20:
        Object r8 = this.mConfigLock;
        monitor-enter(r8);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L29
        if (config == null) goto L42;
        if (DEBUG == true) goto L46;
        String r9 = reason;
    L34:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L29
        ZenModeConfig.ZenRule rule = new ZenModeConfig.ZenRule();     // Catch: Throwable -> L29
        populateZenRule(pkg, automaticZenRule, newConfig, rule, origin, true);     // Catch: Throwable -> L29
        ZenModeConfig.ZenRule rule2 = maybeRestoreRemovedRule(newConfig, pkg, rule, automaticZenRule, origin);     // Catch: Throwable -> L29
        newConfig.automaticRules.put(rule2.id, rule2);     // Catch: Throwable -> L29
        maybeReplaceDefaultRule(newConfig, null, automaticZenRule);     // Catch: Throwable -> L29
        String r4 = r9;
        if (setConfigLocked(newConfig, origin, r4, rule2.component, true, callingUid) == false) goto L40;
        String r1 = rule2.id;     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
        return r1;
    L40:
        throw new AndroidRuntimeException("Could not create rule");     // Catch: Throwable -> L29
    L46:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L31
        r2.append("addAutomaticZenRule rule= ");     // Catch: Throwable -> L31
        r2.append(automaticZenRule);     // Catch: Throwable -> L31
        r2.append(" reason=");     // Catch: Throwable -> L31
        r9 = reason;
        r2.append(r9);     // Catch: Throwable -> L29
        Log.d(TAG, r2.toString());     // Catch: Throwable -> L29
    L31:
        th = th;
    L43:
        monitor-exit(r8);     // Catch: Throwable -> L29
        throw th;
    L42:
        throw new AndroidRuntimeException("Could not create rule");     // Catch: Throwable -> L29
    L29:
        th = th;
        goto L43
    }

    private ZenModeConfig.ZenRule maybeRestoreRemovedRule(ZenModeConfig config, String pkg, ZenModeConfig.ZenRule ruleToAdd, AutomaticZenRule azrToAdd, int origin) {
        String deletedKey = ZenModeConfig.deletedRuleKey(ruleToAdd);
        if (deletedKey != null) goto L5;
        return ruleToAdd;
    L5:
        ZenModeConfig.ZenRule ruleToRestore = (ZenModeConfig.ZenRule) config.deletedRules.get(deletedKey);
        if (ruleToRestore != null) goto L8;
        return ruleToAdd;
    L8:
        config.deletedRules.remove(deletedKey);
        ruleToRestore.deletionInstant = null;
        if (origin == 4) goto L12;
        return ruleToAdd;
    L12:
        if (Objects.equals(ruleToRestore.pkg, pkg) == false) goto L19;
        if (Objects.equals(ruleToRestore.component, azrToAdd.getOwner()) == false) goto L19;
        populateZenRule(pkg, azrToAdd, config, ruleToRestore, origin, false);
        return ruleToRestore;
    L19:
        return ruleToAdd;
    }

    private static void maybeReplaceDefaultRule(ZenModeConfig config, ZenModeConfig.ZenRule oldRule, AutomaticZenRule rule) {
        if (rule.getType() != 3) goto L15;
        if (oldRule != null) goto L6;
    L7:
        ZenModeConfig.ZenRule sleepingRule = (ZenModeConfig.ZenRule) config.automaticRules.get("EVERY_NIGHT_DEFAULT_RULE");
        if (sleepingRule != null) goto L10;
        return;
    L10:
        if (sleepingRule.enabled == false) goto L12;
        return;
    L12:
        if (sleepingRule.isUserModified() == true) goto L19;
        config.automaticRules.remove("EVERY_NIGHT_DEFAULT_RULE");
        return;
    L19:
        return;
    L6:
        if (oldRule.type != rule.getType()) goto L7;
        return;
    }

    public boolean updateAutomaticZenRule(UserHandle user, String ruleId, AutomaticZenRule automaticZenRule, int origin, String reason, int callingUid) {
        checkManageRuleOrigin("updateAutomaticZenRule", origin);
        if (ruleId == null) goto L41;
        Object r9 = this.mConfigLock;
        monitor-enter(r9);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L11
        if (config != null) goto L14;
        monitor-exit(r9);     // Catch: Throwable -> L11
        return false;
    L14:
        if (DEBUG == true) goto L42;
        String r10 = reason;
    L21:
        ZenModeConfig.ZenRule oldRule = (ZenModeConfig.ZenRule) config.automaticRules.get(ruleId);     // Catch: Throwable -> L11
        if (oldRule == null) goto L37;
        if (canManageAutomaticZenRule(oldRule, callingUid) == false) goto L37;
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L11
        ZenModeConfig.ZenRule newRule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(ruleId);     // Catch: Throwable -> L11
        newRule.getClass();     // Catch: Throwable -> L11
        boolean updated = populateZenRule(newRule.pkg, automaticZenRule, newConfig, newRule, origin, false);     // Catch: Throwable -> L11
        if (updated == true) goto L33;
        monitor-exit(r9);     // Catch: Throwable -> L31
        return true;
    L33:
        maybeReplaceDefaultRule(newConfig, oldRule, automaticZenRule);     // Catch: Throwable -> L31
        String r4 = r10;
        boolean r5 = setConfigLocked(newConfig, origin, r4, newRule.component, true, callingUid);     // Catch: Throwable -> L31
        monitor-exit(r9);     // Catch: Throwable -> L31
        return r5;
    L37:
        throw new SecurityException("Cannot update rules not owned by your condition provider");     // Catch: Throwable -> L31
    L42:
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L18
        r6.append("updateAutomaticZenRule zenRule=");     // Catch: Throwable -> L18
        r6.append(automaticZenRule);     // Catch: Throwable -> L18
        r6.append(" reason=");     // Catch: Throwable -> L18
        r10 = reason;
        r6.append(r10);     // Catch: Throwable -> L11
        Log.d(TAG, r6.toString());     // Catch: Throwable -> L11
    L18:
        th = th;
    L38:
        monitor-exit(r9);     // Catch: Throwable -> L31
        throw th;
    L11:
        th = th;
    L31:
        th = th;
        goto L38
    L41:
        throw new IllegalArgumentException("ruleId cannot be null");
    }

    void applyGlobalZenModeAsImplicitZenRule(UserHandle user, String callingPkg, int callingUid, int zenMode) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L35
        if (config == null) goto L46;
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L35
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(ZenModeConfig.implicitRuleId(callingPkg));     // Catch: Throwable -> L35
        if (zenMode != 0) goto L24;
        if (rule == null) goto L33;
        Condition deactivated = new Condition(rule.conditionId, this.mContext.getString(17042471), 0);     // Catch: Throwable -> L19
        setAutomaticZenRuleStateLocked(newConfig, Collections.singletonList(rule), deactivated, 4, "applyGlobalZenModeAsImplicitZenRule: " + callingPkg, callingUid);     // Catch: Throwable -> L17
    L17:
        th = th;
    L37:
        monitor-exit(r1);     // Catch: Throwable -> L26
        throw th;
    L19:
        th = th;
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L26
        return;
    L24:
        if (rule != null) goto L28;
        rule = newImplicitZenRule(callingPkg);     // Catch: Throwable -> L26
        rule.zenPolicy = config.getZenPolicy().copy();     // Catch: Throwable -> L26
        newConfig.automaticRules.put(rule.id, rule);     // Catch: Throwable -> L26
    L30:
        if ((rule.userModifiedFields & 2) != 0) goto L32;
        rule.zenMode = zenMode;     // Catch: Throwable -> L26
    L32:
        rule.condition = new Condition(rule.conditionId, this.mContext.getString(17042470), 1);     // Catch: Throwable -> L26
        rule.resetConditionOverride();     // Catch: Throwable -> L26
        setConfigLocked(newConfig, null, 4, "applyGlobalZenModeAsImplicitZenRule", callingUid);     // Catch: Throwable -> L26
        goto L33
    L28:
        updateImplicitZenRuleNameAndDescription(rule);     // Catch: Throwable -> L26
        goto L30
    L46:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = th;
    L35:
        th = th;
    L26:
        th = th;
        goto L37
    }

    void applyGlobalPolicyAsImplicitZenRule(UserHandle user, String callingPkg, int callingUid, NotificationManager.Policy policy) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L30
        if (config != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L30
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(ZenModeConfig.implicitRuleId(callingPkg));     // Catch: Throwable -> L30
        if (rule == null) goto L13;
        updateImplicitZenRuleNameAndDescription(rule);     // Catch: Throwable -> L30
        boolean isNew = false;
        ZenModeConfig.ZenRule rule2 = rule;
    L18:
        if (rule2.zenPolicyUserModifiedFields != 0) goto L33;
        ZenPolicy newZenPolicy = ZenAdapters.notificationPolicyToZenPolicy(policy);     // Catch: Throwable -> L30
        if (isNew == true) goto L22;
        ZenPolicy newZenPolicy2 = newZenPolicy;
    L25:
        updatePolicy(newConfig, rule2, newZenPolicy2, false, isNew);     // Catch: Throwable -> L30
        setConfigLocked(newConfig, null, 4, "applyGlobalPolicyAsImplicitZenRule", callingUid);     // Catch: Throwable -> L28
        goto L33
    L22:
        newZenPolicy2 = config.getZenPolicy().overwrittenWith(newZenPolicy);     // Catch: Throwable -> L8
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L13:
        ZenModeConfig.ZenRule rule3 = newImplicitZenRule(callingPkg);     // Catch: Throwable -> L8
        rule3.zenMode = 1;     // Catch: Throwable -> L8
        newConfig.automaticRules.put(rule3.id, rule3);     // Catch: Throwable -> L8
        isNew = true;
        rule2 = rule3;
    L8:
        th = th;
    L35:
        monitor-exit(r1);     // Catch: Throwable -> L28
        throw th;
    L28:
        th = th;
    L30:
        th = th;
        goto L35
    }

    NotificationManager.Policy getNotificationPolicyFromImplicitZenRule(UserHandle user, String callingPkg) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L9
        if (config != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ZenModeConfig.ZenRule implicitRule = (ZenModeConfig.ZenRule) config.automaticRules.get(ZenModeConfig.implicitRuleId(callingPkg));     // Catch: Throwable -> L9
        if (implicitRule != null) goto L14;
    L18:
        NotificationManager.Policy r3 = getNotificationPolicy(user);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L14:
        if (implicitRule.zenPolicy == null) goto L18;
        NotificationManager.Policy r4 = config.toNotificationPolicy(implicitRule.zenPolicy);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r4;
    L9:
        th = move-exception;
        throw th;
    }

    private ZenModeConfig.ZenRule newImplicitZenRule(String pkg) {
        ZenModeConfig.ZenRule rule = new ZenModeConfig.ZenRule();
        rule.id = ZenModeConfig.implicitRuleId(pkg);
        rule.pkg = pkg;
        rule.creationTime = this.mClock.millis();
        updateImplicitZenRuleNameAndDescription(rule);
        rule.type = 0;
        rule.condition = null;
        rule.conditionId = new Uri.Builder().scheme("condition").authority("android").appendPath("implicit").appendPath(pkg).build();
        rule.enabled = true;
        rule.component = null;
        rule.configurationActivity = null;
        return rule;
    }

    private void updateImplicitZenRuleNameAndDescription(final ZenModeConfig.ZenRule rule) {
        Preconditions.checkArgument(ZenModeConfig.isImplicitRuleId(rule.id));
        rule.pkg.getClass();
        String pkgAppName = (String) Binder.withCleanCallingIdentity(new ZenModeHelper$$ExternalSyntheticLambda0(this, rule));
        if (pkgAppName == null) goto L9;
        if ((rule.userModifiedFields & 1) != 0) goto L7;
        rule.name = this.mContext.getString(17042472, new Object[]{pkgAppName});
    L7:
        rule.triggerDescription = this.mContext.getString(17042473, new Object[]{pkgAppName});
        return;
    L9:
        if (rule.name != null) goto L13;
        rule.name = "Unknown";
        return;
    }

    private /* synthetic */ String lambda$updateImplicitZenRuleNameAndDescription$0(ZenModeConfig.ZenRule rule) throws Exception {
        ApplicationInfo applicationInfo = this.mPm.getApplicationInfo(rule.pkg, 0);     // Catch: PackageManager.NameNotFoundException -> L4
        return applicationInfo.loadLabel(this.mPm).toString();
    L4:
        e = move-exception;
        Slog.e(TAG, "Package not found when updating implicit zen rule name", e);
        return null;
    }

    boolean removeAutomaticZenRule(UserHandle user, String id, int origin, String reason, int callingUid) {
        checkManageRuleOrigin("removeAutomaticZenRule", origin);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L10:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L8
        ZenModeConfig.ZenRule ruleToRemove = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(id);     // Catch: Throwable -> L8
        if (ruleToRemove != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L15:
        if (canManageAutomaticZenRule(ruleToRemove, callingUid) == false) goto L37;
        newConfig.automaticRules.remove(id);     // Catch: Throwable -> L8
        maybePreserveRemovedRule(newConfig, ruleToRemove, origin);     // Catch: Throwable -> L8
        if (ruleToRemove.getPkg() == null) goto L31;
        if ("android".equals(ruleToRemove.getPkg()) == true) goto L31;
        Iterator r2 = newConfig.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L22:
        if (r2.hasNext() == false) goto L29;
        ZenModeConfig.ZenRule currRule = (ZenModeConfig.ZenRule) r2.next();     // Catch: Throwable -> L8
        if (currRule.getPkg() == null) goto L22;
        if (currRule.getPkg().equals(ruleToRemove.getPkg()) == false) goto L22;
    L29:
        this.mRulesUidCache.remove(getPackageUserKey(ruleToRemove.getPkg(), newConfig.user));     // Catch: Throwable -> L8
    L31:
        if (DEBUG == false) goto L33;
        Log.d(TAG, "removeZenRule zenRule=" + id + " reason=" + reason);     // Catch: Throwable -> L8
    L33:
        dispatchOnAutomaticRuleStatusChanged(config.user, ruleToRemove.getPkg(), id, 3);     // Catch: Throwable -> L8
        boolean r3 = setConfigLocked(newConfig, origin, reason, null, true, callingUid);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return r3;
    L37:
        throw new SecurityException("Cannot delete rules not owned by your condition provider");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    boolean removeAutomaticZenRules(UserHandle user, String packageName, int origin, String reason, int callingUid) {
        checkManageRuleOrigin("removeAutomaticZenRules", origin);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L34
        if (config != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return false;
    L11:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L34
        int i = newConfig.automaticRules.size() - 1;
    L13:
        if (i < 0) goto L21;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(newConfig.automaticRules.keyAt(i));     // Catch: Throwable -> L9
        if (Objects.equals(rule.getPkg(), packageName) == false) goto L19;
        if (canManageAutomaticZenRule(rule, callingUid) == false) goto L19;
        newConfig.automaticRules.removeAt(i);     // Catch: Throwable -> L9
        maybePreserveRemovedRule(newConfig, rule, origin);     // Catch: Throwable -> L9
    L19:
        i = i - 1;     // Catch: Throwable -> L9
        goto L13
    L21:
        if (origin != 5) goto L29;
        int i2 = newConfig.deletedRules.size() - 1;     // Catch: Throwable -> L9
    L23:
        if (i2 < 0) goto L29;
        if (Objects.equals(((ZenModeConfig.ZenRule) newConfig.deletedRules.get(newConfig.deletedRules.keyAt(i2))).getPkg(), packageName) == false) goto L27;
        newConfig.deletedRules.removeAt(i2);     // Catch: Throwable -> L9
    L27:
        i2 = i2 - 1;
    L29:
        boolean r13 = setConfigLocked(newConfig, origin, reason, null, true, callingUid);     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        return r13;
    L9:
        th = th;
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L32
        throw th;
    L32:
        th = th;
    L34:
        th = th;
        goto L36
    }

    private void maybePreserveRemovedRule(ZenModeConfig config, ZenModeConfig.ZenRule ruleToRemove, int origin) {
        if (origin == 4) goto L5;
        return;
    L5:
        if (ruleToRemove.isUserModified() == true) goto L7;
        return;
    L7:
        if ("android".equals(ruleToRemove.pkg) == true) goto L14;
        String deletedKey = ZenModeConfig.deletedRuleKey(ruleToRemove);
        if (deletedKey == null) goto L15;
        ZenModeConfig.ZenRule deletedRule = ruleToRemove.copy();
        deletedRule.deletionInstant = Instant.now(this.mClock);
        deletedRule.condition = null;
        deletedRule.resetConditionOverride();
        config.deletedRules.put(deletedKey, deletedRule);
        return;
    L15:
        return;
    }

    int getAutomaticZenRuleState(UserHandle user, String id, int callingUid) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 2;
    L10:
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) config.automaticRules.get(id);     // Catch: Throwable -> L8
        if (rule == null) goto L21;
        if (canManageAutomaticZenRule(rule, callingUid) == false) goto L21;
        if (rule.isActive() == false) goto L18;
        int r2 = 1;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L18:
        r2 = 0;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 2;
    L8:
        th = move-exception;
        throw th;
    }

    void setAutomaticZenRuleState(UserHandle user, String id, Condition condition, int origin, int callingUid) {
        checkSetRuleStateOrigin("setAutomaticZenRuleState(String id)", origin);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L19
        if (config == null) goto L26;
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L19
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(id);     // Catch: Throwable -> L19
        if (rule == null) goto L22;
        if (canManageAutomaticZenRule(rule, callingUid) == false) goto L22;
        setAutomaticZenRuleStateLocked(newConfig, Collections.singletonList(rule), condition, origin, "setAzrState: " + rule.id, callingUid);     // Catch: Throwable -> L17
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = th;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
    L19:
        th = th;
        goto L24
    }

    void setAutomaticZenRuleStateFromConditionProvider(UserHandle user, Uri ruleConditionId, Condition condition, int origin, int callingUid) {
        checkSetRuleStateOrigin("setAutomaticZenRuleStateFromConditionProvider", origin);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L25
        if (config != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L25
        List<ZenModeConfig.ZenRule> matchingRules = findMatchingRules(newConfig, ruleConditionId, condition);     // Catch: Throwable -> L25
        int i = matchingRules.size() - 1;
    L12:
        if (i < 0) goto L18;
        if (canManageAutomaticZenRule(matchingRules.get(i), callingUid) == true) goto L16;
        matchingRules.remove(i);     // Catch: Throwable -> L8
    L16:
        i = i - 1;
        goto L12
    L18:
        setAutomaticZenRuleStateLocked(newConfig, matchingRules, condition, origin, "setAzrStateFromCps: " + ruleConditionId, callingUid);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L8:
        th = th;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L23:
        th = th;
    L25:
        th = th;
        goto L27
    }

    private void setAutomaticZenRuleStateLocked(ZenModeConfig config, List<ZenModeConfig.ZenRule> rules, Condition condition, int origin, String reason, int callingUid) {
        if (rules == null) goto L12;
        if (rules.isEmpty() == true) goto L14;
        Iterator<ZenModeConfig.ZenRule> r0 = rules.iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ZenModeConfig.ZenRule rule = r0.next();
        applyConditionAndReconsiderOverride(rule, condition, origin);
        setConfigLocked(config, rule.component, origin, reason, callingUid);
        goto L8
    L10:
        return;
    L14:
        return;
    }

    private static void applyConditionAndReconsiderOverride(ZenModeConfig.ZenRule rule, Condition condition, int origin) {
        if (ZenModeConfig.isImplicitRuleId(rule.id) == false) goto L6;
        rule.condition = condition;
        rule.resetConditionOverride();
        return;
    L6:
        if (origin != 3) goto L21;
        if (condition == null) goto L21;
        if (condition.source != 1) goto L21;
        if (condition.state != 1) goto L16;
        rule.resetConditionOverride();
        if (rule.isActive() == true) goto L29;
        rule.setConditionOverride(1);
        return;
    L29:
        return;
    L16:
        if (condition.state != 0) goto L31;
        rule.resetConditionOverride();
        if (rule.isActive() == false) goto L32;
        rule.setConditionOverride(2);
        return;
    L32:
        return;
    L31:
        return;
    L21:
        if (origin != 7) goto L26;
        if (condition == null) goto L26;
        if (condition.source != 1) goto L26;
        rule.condition = condition;
        rule.resetConditionOverride();
        return;
    L26:
        rule.condition = condition;
        rule.reconsiderConditionOverride();
    }

    private static List<ZenModeConfig.ZenRule> findMatchingRules(ZenModeConfig config, Uri id, Condition condition) {
        List<ZenModeConfig.ZenRule> matchingRules = new ArrayList();
        if (ruleMatches(id, condition, config.manualRule) == false) goto L5;
        matchingRules.add(config.manualRule);
    L12:
        return matchingRules;
    L5:
        Iterator r1 = config.automaticRules.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r1.next();
        if (ruleMatches(id, condition, automaticRule) == false) goto L7;
        matchingRules.add(automaticRule);
        goto L7
    }

    private static boolean ruleMatches(Uri id, Condition condition, ZenModeConfig.ZenRule rule) {
        if (id == null) goto L16;
        if (rule == null) goto L16;
        if (rule.conditionId == null) goto L16;
        if (rule.conditionId.equals(id) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(condition, rule.condition) == false) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    public int getCurrentInstanceCount(UserHandle user, ComponentName cn) {
        if (cn != null) goto L5;
        return 0;
    L5:
        int count = 0;
        Object r2 = this.mConfigLock;
        monitor-enter(r2);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L11
        if (config != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return 0;
    L13:
        Iterator r0 = config.automaticRules.values().iterator();     // Catch: Throwable -> L11
    L15:
        if (r0.hasNext() == false) goto L22;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r0.next();     // Catch: Throwable -> L11
        if (cn.equals(rule.component) == false) goto L19;
    L20:
        count = count + 1;     // Catch: Throwable -> L11
        goto L15
    L19:
        if (cn.equals(rule.configurationActivity) == false) goto L15;
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return count;
    L11:
        th = move-exception;
        throw th;
    }

    private int getPackageRuleCount(UserHandle user, String pkg) {
        if (pkg != null) goto L5;
        return 0;
    L5:
        int count = 0;
        Object r2 = this.mConfigLock;
        monitor-enter(r2);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L11
        if (config != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return 0;
    L13:
        Iterator r0 = config.automaticRules.values().iterator();     // Catch: Throwable -> L11
    L15:
        if (r0.hasNext() == false) goto L20;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r0.next();     // Catch: Throwable -> L11
        if (pkg.equals(rule.getPkg()) == false) goto L15;
        count = count + 1;     // Catch: Throwable -> L11
        goto L15
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return count;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean canManageAutomaticZenRule(ZenModeConfig.ZenRule rule, int callingUid) {
        if (callingUid != 0) goto L5;
    L20:
        return true;
    L5:
        if (callingUid == 1000) goto L20;
        if (this.mContext.checkCallingPermission("android.permission.MANAGE_NOTIFICATIONS") != 0) goto L10;
        return true;
    L10:
        String[] packages = this.mPm.getPackagesForUid(callingUid);
        if (packages == null) goto L18;
        int packageCount = packages.length;
        int i = 0;
    L13:
        if (i >= packageCount) goto L23;
        if (packages[i].equals(rule.getPkg()) == true) goto L16;
        i = i + 1;
        goto L13
    L16:
        return true;
    L23:
        return false;
    L18:
        return false;
    }

    void updateZenRulesOnLocaleChange() {
        updateRuleStringsForCurrentLocale(this.mContext, this.mDefaultConfig);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(UserHandle.CURRENT);     // Catch: Throwable -> L8
        if (config != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L8
        boolean updated = false;
        Iterator r3 = this.mDefaultConfig.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L24;
        ZenModeConfig.ZenRule defaultRule = (ZenModeConfig.ZenRule) r3.next();     // Catch: Throwable -> L8
        ZenModeConfig.ZenRule currRule = (ZenModeConfig.ZenRule) newConfig.automaticRules.get(defaultRule.id);     // Catch: Throwable -> L8
        if (currRule == null) goto L12;
        if ((currRule.userModifiedFields & 1) != 0) goto L12;
        if (defaultRule.name.equals(currRule.name) == true) goto L12;
        if (DEBUG == false) goto L22;
        Slog.d(TAG, "Locale change - updating default zen rule name from " + currRule.name + " to " + defaultRule.name);     // Catch: Throwable -> L8
    L22:
        currRule.name = defaultRule.name;     // Catch: Throwable -> L8
        updated = true;
        goto L12
    L24:
        Iterator r4 = newConfig.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L26:
        if (r4.hasNext() == false) goto L34;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r4.next();     // Catch: Throwable -> L8
        if (SystemZenRules.isSystemOwnedRule(rule) == false) goto L31;
        updated = updated | SystemZenRules.updateTriggerDescription(this.mContext, rule);     // Catch: Throwable -> L8
        goto L26
    L31:
        if (ZenModeConfig.isImplicitRuleId(rule.id) == false) goto L26;
        updateImplicitZenRuleNameAndDescription(rule);     // Catch: Throwable -> L8
        goto L26
    L34:
        if (updated == false) goto L36;
        setConfigLocked(newConfig, null, 5, "updateZenRulesOnLocaleChange", 1000);     // Catch: Throwable -> L8
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private ServiceInfo getServiceInfo(ComponentName owner) {
        Intent queryIntent = new Intent();
        queryIntent.setComponent(owner);
        List<ResolveInfo> installedServices = this.mPm.queryIntentServicesAsUser(queryIntent, 132, UserHandle.getCallingUserId());
        if (installedServices == null) goto L10;
        int i = 0;
        int count = installedServices.size();
    L5:
        if (i >= count) goto L14;
        ResolveInfo resolveInfo = installedServices.get(i);
        ServiceInfo info = resolveInfo.serviceInfo;
        if (this.mServiceConfig.bindPermission.equals(info.permission) == true) goto L8;
        i = i + 1;
        goto L5
    L8:
        return info;
    L14:
        return null;
    L10:
        return null;
    }

    private ActivityInfo getActivityInfo(ComponentName configActivity) {
        Intent queryIntent = new Intent();
        queryIntent.setComponent(configActivity);
        List<ResolveInfo> installedComponents = this.mPm.queryIntentActivitiesAsUser(queryIntent, 129, UserHandle.getCallingUserId());
        if (installedComponents == null) goto L8;
        int count = installedComponents.size();
        if (0 >= count) goto L10;
        ResolveInfo resolveInfo = installedComponents.get(0);
        return resolveInfo.activityInfo;
    L10:
        return null;
    L8:
        return null;
    }

    private boolean populateZenRule(String pkg, AutomaticZenRule azr, ZenModeConfig config, ZenModeConfig.ZenRule rule, int origin, boolean isNew) {
        boolean modified = false;
        if (isNew == false) goto L7;
        rule.id = ZenModeConfig.newRuleId();
        rule.creationTime = this.mClock.millis();
        rule.component = azr.getOwner();
        rule.pkg = pkg;
        modified = true;
    L7:
        if (origin == 5) goto L10;
        if (origin == 3) goto L10;
    L14:
        boolean r8 = false;
        if (azr.isEnabled() == true) goto L21;
        if (isNew == false) goto L18;
    L19:
        rule.disabledOrigin = origin;
    L24:
        if (Objects.equals(rule.conditionId, azr.getConditionId()) == true) goto L26;
        rule.conditionId = azr.getConditionId();
        modified = true;
    L26:
        this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        if (isNew == true) goto L38;
        if (origin != 3) goto L38;
        if (rule.enabled != azr.isEnabled()) goto L38;
        if (rule.conditionId == null) goto L38;
        if (rule.condition == null) goto L38;
        if (rule.conditionId.equals(rule.condition.id) == false) goto L38;
        boolean r3 = true;
    L39:
        boolean shouldPreserveCondition = r3;
        if (shouldPreserveCondition == true) goto L43;
        rule.condition = null;
    L43:
        if (rule.enabled == azr.isEnabled()) goto L46;
        rule.enabled = azr.isEnabled();
        rule.resetConditionOverride();
        modified = true;
    L46:
        if (Objects.equals(rule.configurationActivity, azr.getConfigurationActivity()) == true) goto L49;
        rule.configurationActivity = azr.getConfigurationActivity();
        modified = true;
    L49:
        if (rule.allowManualInvocation == azr.isManualInvocationAllowed()) goto L52;
        rule.allowManualInvocation = azr.isManualInvocationAllowed();
        modified = true;
    L52:
        if (Objects.equals(rule.triggerDescription, azr.getTriggerDescription()) == true) goto L55;
        rule.triggerDescription = azr.getTriggerDescription();
        modified = true;
    L55:
        if (rule.type == azr.getType()) goto L57;
        rule.type = azr.getType();
        modified = true;
    L57:
        String previousName = rule.name;
        if (isNew == false) goto L60;
    L63:
        rule.name = azr.getName();
        modified = modified | (!Objects.equals(rule.name, previousName));
    L64:
        if (isNew == false) goto L66;
    L71:
        boolean r4 = true;
    L72:
        boolean updateValues = r4;
        if (updateValues == true) goto L75;
        return modified;
    L75:
        if (origin != 3) goto L77;
        boolean updateBitmask = true;
    L78:
        if (updateBitmask == true) goto L80;
    L82:
        int newZenMode = NotificationManager.zenModeFromInterruptionFilter(azr.getInterruptionFilter(), 0);
        if (rule.zenMode == newZenMode) goto L88;
        rule.zenMode = newZenMode;
        if (updateBitmask == false) goto L87;
        rule.userModifiedFields |= 2;
    L87:
        modified = true;
    L88:
        String iconResName = drawableResIdToResName(rule.pkg, azr.getIconResId());
        if (Objects.equals(rule.iconResName, iconResName) == true) goto L94;
        rule.iconResName = iconResName;
        if (updateBitmask == false) goto L93;
        rule.userModifiedFields |= 4;
    L93:
        boolean modified2 = true;
    L95:
        boolean modified3 = modified2 | updatePolicy(config, rule, azr.getZenPolicy(), updateBitmask, isNew);
        ZenDeviceEffects r1 = azr.getDeviceEffects();
        if (origin != 4) goto L99;
        r8 = true;
    L99:
        return modified3 | updateZenDeviceEffects(rule, r1, r8, updateBitmask);
    L94:
        modified2 = modified;
        goto L95
    L80:
        if (TextUtils.equals(previousName, azr.getName()) == true) goto L82;
        rule.userModifiedFields |= 1;
        goto L82
    L77:
        updateBitmask = false;
        goto L78
    L66:
        if (doesOriginAlwaysUpdateValues(origin) == true) goto L71;
        if (rule.isUserModified() == false) goto L71;
        r4 = false;
        goto L72
    L60:
        if (doesOriginAlwaysUpdateValues(origin) == true) goto L63;
        if ((rule.userModifiedFields & 1) != 0) goto L64;
    L38:
        r3 = false;
        goto L39
    L18:
        if (rule.enabled == true) goto L19;
    L21:
        if (azr.isEnabled() == false) goto L24;
        rule.disabledOrigin = 0;
    L10:
        if (Objects.equals(rule.pkg, "android") == false) goto L14;
        if (Objects.equals(rule.component, azr.getOwner()) == true) goto L14;
        rule.component = azr.getOwner();
        modified = true;
        goto L14
    }

    private static boolean doesOriginAlwaysUpdateValues(int origin) {
        if (origin != 3) goto L5;
    L8:
        return true;
    L5:
        if (origin == 5) goto L8;
        return false;
    }

    private boolean updatePolicy(ZenModeConfig config, ZenModeConfig.ZenRule zenRule, ZenPolicy newPolicy, boolean updateBitmask, boolean isNew) {
        if (newPolicy != null) goto L10;
        if (isNew == false) goto L7;
        zenRule.zenPolicy = this.mDefaultConfig.getZenPolicy().copy();
        return true;
    L7:
        return false;
    L10:
        if (zenRule.zenPolicy == null) goto L12;
        ZenPolicy oldPolicy = zenRule.zenPolicy;
    L13:
        ZenPolicy newPolicy2 = oldPolicy.overwrittenWith(newPolicy);
        zenRule.zenPolicy = newPolicy2;
        if (updateBitmask == false) goto L68;
        int userModifiedFields = zenRule.zenPolicyUserModifiedFields;
        if (oldPolicy.getPriorityMessageSenders() == newPolicy2.getPriorityMessageSenders()) goto L19;
        userModifiedFields = userModifiedFields | 1;
    L19:
        if (oldPolicy.getPriorityCallSenders() == newPolicy2.getPriorityCallSenders()) goto L22;
        userModifiedFields = userModifiedFields | 2;
    L22:
        if (oldPolicy.getPriorityConversationSenders() == newPolicy2.getPriorityConversationSenders()) goto L25;
        userModifiedFields = userModifiedFields | 4;
    L25:
        if (oldPolicy.getPriorityChannelsAllowed() == newPolicy2.getPriorityChannelsAllowed()) goto L28;
        userModifiedFields = userModifiedFields | 8;
    L28:
        if (oldPolicy.getPriorityCategoryReminders() == newPolicy2.getPriorityCategoryReminders()) goto L31;
        userModifiedFields = userModifiedFields | 16;
    L31:
        if (oldPolicy.getPriorityCategoryEvents() == newPolicy2.getPriorityCategoryEvents()) goto L34;
        userModifiedFields = userModifiedFields | 32;
    L34:
        if (oldPolicy.getPriorityCategoryRepeatCallers() == newPolicy2.getPriorityCategoryRepeatCallers()) goto L37;
        userModifiedFields = userModifiedFields | 64;
    L37:
        if (oldPolicy.getPriorityCategoryAlarms() == newPolicy2.getPriorityCategoryAlarms()) goto L40;
        userModifiedFields = userModifiedFields | 128;
    L40:
        if (oldPolicy.getPriorityCategoryMedia() == newPolicy2.getPriorityCategoryMedia()) goto L43;
        userModifiedFields = userModifiedFields | 256;
    L43:
        if (oldPolicy.getPriorityCategorySystem() == newPolicy2.getPriorityCategorySystem()) goto L46;
        userModifiedFields = userModifiedFields | 512;
    L46:
        if (oldPolicy.getVisualEffectFullScreenIntent() == newPolicy2.getVisualEffectFullScreenIntent()) goto L49;
        userModifiedFields = userModifiedFields | 1024;
    L49:
        if (oldPolicy.getVisualEffectLights() == newPolicy2.getVisualEffectLights()) goto L52;
        userModifiedFields = userModifiedFields | 2048;
    L52:
        if (oldPolicy.getVisualEffectPeek() == newPolicy2.getVisualEffectPeek()) goto L55;
        userModifiedFields = userModifiedFields | 4096;
    L55:
        if (oldPolicy.getVisualEffectStatusBar() == newPolicy2.getVisualEffectStatusBar()) goto L58;
        userModifiedFields = userModifiedFields | 8192;
    L58:
        if (oldPolicy.getVisualEffectBadge() == newPolicy2.getVisualEffectBadge()) goto L61;
        userModifiedFields = userModifiedFields | 16384;
    L61:
        if (oldPolicy.getVisualEffectAmbient() == newPolicy2.getVisualEffectAmbient()) goto L64;
        userModifiedFields = userModifiedFields | 32768;
    L64:
        if (oldPolicy.getVisualEffectNotificationList() == newPolicy2.getVisualEffectNotificationList()) goto L66;
        userModifiedFields = userModifiedFields | 65536;
    L66:
        zenRule.zenPolicyUserModifiedFields = userModifiedFields;
    L68:
        return true ^ newPolicy2.equals(oldPolicy);
    L12:
        oldPolicy = this.mDefaultConfig.getZenPolicy();
        goto L13
    }

    private static boolean updateZenDeviceEffects(ZenModeConfig.ZenRule zenRule, ZenDeviceEffects newEffects, boolean isFromApp, boolean updateBitmask) {
        if (newEffects != null) goto L6;
        return false;
    L6:
        if (zenRule.zenDeviceEffects == null) goto L8;
        ZenDeviceEffects oldEffects = zenRule.zenDeviceEffects;
    L10:
        if (isFromApp == false) goto L12;
        newEffects = new ZenDeviceEffects.Builder(newEffects).setShouldDisableAutoBrightness(oldEffects.shouldDisableAutoBrightness()).setShouldDisableTapToWake(oldEffects.shouldDisableTapToWake()).setShouldDisableTiltToWake(oldEffects.shouldDisableTiltToWake()).setShouldDisableTouch(oldEffects.shouldDisableTouch()).setShouldMinimizeRadioUsage(oldEffects.shouldMinimizeRadioUsage()).setShouldMaximizeDoze(oldEffects.shouldMaximizeDoze()).setShouldUseNightLight(oldEffects.shouldUseNightLight()).setExtraEffects(oldEffects.getExtraEffects()).build();
    L12:
        zenRule.zenDeviceEffects = newEffects;
        if (updateBitmask == false) goto L52;
        int userModifiedFields = zenRule.zenDeviceEffectsUserModifiedFields;
        if (oldEffects.shouldDisplayGrayscale() == newEffects.shouldDisplayGrayscale()) goto L18;
        userModifiedFields = userModifiedFields | 1;
    L18:
        if (oldEffects.shouldSuppressAmbientDisplay() == newEffects.shouldSuppressAmbientDisplay()) goto L21;
        userModifiedFields = userModifiedFields | 2;
    L21:
        if (oldEffects.shouldDimWallpaper() == newEffects.shouldDimWallpaper()) goto L24;
        userModifiedFields = userModifiedFields | 4;
    L24:
        if (oldEffects.shouldUseNightMode() == newEffects.shouldUseNightMode()) goto L27;
        userModifiedFields = userModifiedFields | 8;
    L27:
        if (oldEffects.shouldDisableAutoBrightness() == newEffects.shouldDisableAutoBrightness()) goto L30;
        userModifiedFields = userModifiedFields | 16;
    L30:
        if (oldEffects.shouldDisableTapToWake() == newEffects.shouldDisableTapToWake()) goto L33;
        userModifiedFields = userModifiedFields | 32;
    L33:
        if (oldEffects.shouldDisableTiltToWake() == newEffects.shouldDisableTiltToWake()) goto L36;
        userModifiedFields = userModifiedFields | 64;
    L36:
        if (oldEffects.shouldDisableTouch() == newEffects.shouldDisableTouch()) goto L39;
        userModifiedFields = userModifiedFields | 128;
    L39:
        if (oldEffects.shouldMinimizeRadioUsage() == newEffects.shouldMinimizeRadioUsage()) goto L42;
        userModifiedFields = userModifiedFields | 256;
    L42:
        if (oldEffects.shouldMaximizeDoze() == newEffects.shouldMaximizeDoze()) goto L45;
        userModifiedFields = userModifiedFields | 512;
    L45:
        if (oldEffects.shouldUseNightLight() == newEffects.shouldUseNightLight()) goto L48;
        userModifiedFields = userModifiedFields | 2048;
    L48:
        if (Objects.equals(oldEffects.getExtraEffects(), newEffects.getExtraEffects()) == true) goto L50;
        userModifiedFields = userModifiedFields | 1024;
    L50:
        zenRule.zenDeviceEffectsUserModifiedFields = userModifiedFields;
    L52:
        return !newEffects.equals(oldEffects);
    L8:
        oldEffects = new ZenDeviceEffects.Builder().build();
        goto L10
    }

    private AutomaticZenRule zenRuleToAutomaticZenRule(ZenModeConfig.ZenRule rule) {
        return new AutomaticZenRule.Builder(rule.name, rule.conditionId).setManualInvocationAllowed(rule.allowManualInvocation).setPackage(rule.pkg).setCreationTime(rule.creationTime).setIconResId(drawableResNameToResId(rule.pkg, rule.iconResName)).setType(rule.type).setZenPolicy(rule.zenPolicy).setDeviceEffects(rule.zenDeviceEffects).setEnabled(rule.enabled).setInterruptionFilter(NotificationManager.zenModeToInterruptionFilter(rule.zenMode)).setOwner(rule.component).setConfigurationActivity(rule.configurationActivity).setTriggerDescription(rule.triggerDescription).build();
    }

    protected void updateHasPriorityChannels(UserHandle user, boolean hasPriorityChannels) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L11:
        if (config.hasPriorityChannels != hasPriorityChannels) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L14:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L8
        newConfig.hasPriorityChannels = hasPriorityChannels;     // Catch: Throwable -> L8
        setConfigLocked(newConfig, null, 5, "updateHasPriorityChannels", 1000);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void scheduleActivationBroadcast(String pkg, int userId, String ruleId, boolean activated) {
        if (CompatChanges.isChangeEnabled(SEND_ACTIVATION_AZR_STATUSES, pkg, UserHandle.of(userId)) == false) goto L8;
        if (activated == false) goto L6;
        int r0 = 4;
    L7:
        dispatchOnAutomaticRuleStatusChanged(userId, pkg, ruleId, r0);
        return;
    L6:
        r0 = 5;
        goto L7
    L8:
        dispatchOnAutomaticRuleStatusChanged(userId, pkg, ruleId, -1);
    }

    void scheduleEnabledBroadcast(String pkg, int userId, String ruleId, boolean enabled) {
        if (enabled == false) goto L4;
        int r0 = 1;
    L5:
        dispatchOnAutomaticRuleStatusChanged(userId, pkg, ruleId, r0);
        return;
    L4:
        r0 = 2;
        goto L5
    }

    void setManualZenMode(UserHandle user, int zenMode, Uri conditionId, int origin, String reason, String caller, int callingUid) {
        setManualZenMode(user, zenMode, conditionId, origin, reason, caller, true, callingUid);
    }

    private void setManualZenMode(UserHandle user, int zenMode, Uri conditionId, int origin, String reason, String caller, boolean setRingerMode, int callingUid) {
        Object r10 = this.mConfigLock;
        monitor-enter(r10);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L8
        if (config != null) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L11:
        if (Settings.Global.isValidZenMode(zenMode) == true) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L15:
        if (DEBUG == true) goto L59;
        boolean r8 = setRingerMode;
    L26:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L8
        newConfig.manualRule.enabler = caller;     // Catch: Throwable -> L50
        ZenModeConfig.ZenRule r6 = newConfig.manualRule;     // Catch: Throwable -> L50
        if (conditionId == null) goto L31;
        Uri r9 = conditionId;
    L32:
        r6.conditionId = r9;     // Catch: Throwable -> L50
        newConfig.manualRule.pkg = "android";     // Catch: Throwable -> L50
        newConfig.manualRule.zenMode = zenMode;     // Catch: Throwable -> L50
        ZenModeConfig.ZenRule r7 = newConfig.manualRule;     // Catch: Throwable -> L50
        Uri r12 = newConfig.manualRule.conditionId;     // Catch: Throwable -> L50
        if (zenMode != 0) goto L35;
        int r14 = 0;
    L37:
        if (origin != 3) goto L39;
        int r15 = 1;
    L40:
        r7.condition = new Condition(r12, "", r14, r15);     // Catch: Throwable -> L50
        if (zenMode == 0) goto L43;
    L54:
        setConfigLocked(newConfig, origin, reason, null, r8, callingUid);     // Catch: Throwable -> L50
        monitor-exit(r10);     // Catch: Throwable -> L50
        return;
    L43:
        if (origin == 3) goto L54;
        Iterator r11 = newConfig.automaticRules.values().iterator();     // Catch: Throwable -> L50
    L46:
        if (r11.hasNext() == false) goto L54;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r11.next();     // Catch: Throwable -> L50
        if (automaticRule.isActive() == false) goto L46;
        automaticRule.setConditionOverride(2);     // Catch: Throwable -> L50
        goto L46
    L39:
        r15 = 0;
        goto L40
    L35:
        r14 = 1;
        goto L37
    L31:
        r9 = Uri.EMPTY;     // Catch: Throwable -> L50
        goto L32
    L59:
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L23
        r13.append("setManualZenMode ");     // Catch: Throwable -> L23
        r13.append(Settings.Global.zenModeToString(zenMode));     // Catch: Throwable -> L23
        r13.append(" conditionId=");     // Catch: Throwable -> L23
        r13.append(conditionId);     // Catch: Throwable -> L23
        r13.append(" reason=");     // Catch: Throwable -> L23
        r13.append(reason);     // Catch: Throwable -> L21
        r13.append(" setRingerMode=");     // Catch: Throwable -> L21
        r8 = setRingerMode;
        r13.append(r8);     // Catch: Throwable -> L8
        Log.d(TAG, r13.toString());     // Catch: Throwable -> L8
    L21:
        th = th;
    L57:
        monitor-exit(r10);     // Catch: Throwable -> L50
        throw th;
    L23:
        th = th;
    L8:
        th = th;
    L50:
        th = th;
        goto L57
    }

    public void setManualZenRuleDeviceEffects(UserHandle user, ZenDeviceEffects deviceEffects, int origin, String reason, int callingUid) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L20
        if (config != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L11:
        if (DEBUG == false) goto L13;
        Log.d(TAG, "updateManualRule " + deviceEffects + " reason=" + reason + " callingUid=" + callingUid);     // Catch: Throwable -> L8
    L13:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L20
        newConfig.manualRule.pkg = "android";     // Catch: Throwable -> L20
        newConfig.manualRule.zenDeviceEffects = deviceEffects;     // Catch: Throwable -> L20
        setConfigLocked(newConfig, origin, reason, null, true, callingUid);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L8:
        th = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L18
        throw th;
    L18:
        th = th;
    L20:
        th = th;
        goto L22
    }

    void dump(ProtoOutputStream proto) {
        proto.write(1159641169921L, this.mZenMode);
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mConfig.isManualActive() == false) goto L9;
        this.mConfig.manualRule.dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L7
    L9:
        Iterator r1 = this.mConfig.automaticRules.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (r1.hasNext() == false) goto L16;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r1.next();     // Catch: Throwable -> L7
        if (rule.isActive() == false) goto L11;
        rule.dumpDebug(proto, 2246267895810L);     // Catch: Throwable -> L7
        goto L11
    L16:
        this.mConfig.toNotificationPolicy().dumpDebug(proto, 1146756268037L);     // Catch: Throwable -> L7
        proto.write(1120986464259L, this.mSuppressedEffects);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mZenMode=");
        pw.println(Settings.Global.zenModeToString(this.mZenMode));
        pw.print(prefix);
        pw.println("mConsolidatedPolicy=" + this.mConsolidatedPolicy.toString());
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        int N = this.mConfigs.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= N) goto L10;
        dump(pw, prefix, "mConfigs[u=" + this.mConfigs.keyAt(i) + "]", this.mConfigs.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.print(prefix);
        pw.print("mUser=");
        pw.println(this.mUser);
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        dump(pw, prefix, "mConfig", this.mConfig);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        pw.print(prefix);
        pw.print("mSuppressedEffects=");
        pw.println(this.mSuppressedEffects);
        this.mFiltering.dump(pw, prefix);
        this.mConditions.dump(pw, prefix);
        return;
    L17:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        throw th;
    }

    private static void dump(PrintWriter pw, String prefix, String var, ZenModeConfig config) {
        pw.print(prefix);
        pw.print(var);
        pw.print('=');
        pw.println(config);
    }

    public boolean readXml(TypedXmlPullParser parser, boolean forRestore, int userId, BackupRestoreEventLogger logger) throws XmlPullParserException, IOException {
        ZenModeConfig config = ZenModeConfig.readXml(parser, logger);
        if (config == null) goto L70;
        if (forRestore == false) goto L10;
        config.user = userId;
        if (config.manualRule == null) goto L10;
        config.manualRule.condition = null;
    L10:
        boolean allRulesDisabled = true;
        boolean hasDefaultRules = config.automaticRules.containsAll(ZenModeConfig.getDefaultRuleIds());
        long time = this.mClock.millis();
        int r6 = 1;
        if (config.automaticRules != null) goto L13;
    L33:
        boolean allRulesDisabled2 = true;
    L34:
        if (hasDefaultRules == true) goto L44;
        if (allRulesDisabled2 == false) goto L44;
        if (forRestore == false) goto L38;
    L39:
        config.automaticRules = new ArrayMap();
        Iterator r3 = this.mDefaultConfig.automaticRules.values().iterator();
    L41:
        if (r3.hasNext() == false) goto L43;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r3.next();
        config.automaticRules.put(rule.id, rule.copy());
        goto L41
    L43:
        String reason = "readXml, reset to default rules";
        String reason2 = reason;
    L45:
        SystemZenRules.maybeUpgradeRules(this.mContext, config);
        if (forRestore == false) goto L49;
        config.deletedRules.clear();
    L49:
        if (config.automaticRules == null) goto L56;
        ZenModeConfig.ZenRule obsoleteEventsRule = (ZenModeConfig.ZenRule) config.automaticRules.get("EVENTS_DEFAULT_RULE");
        if (obsoleteEventsRule == null) goto L56;
        if (obsoleteEventsRule.enabled == true) goto L56;
        config.automaticRules.remove("EVENTS_DEFAULT_RULE");
    L56:
        if (DEBUG == false) goto L58;
        Log.d(TAG, reason2);
    L58:
        Object r14 = this.mConfigLock;
        monitor-enter(r14);
        if (forRestore == false) goto L71;
        r6 = 6;
    L71:
        boolean r0 = setConfigLocked(config, null, r6, reason2, 1000);     // Catch: Throwable -> L66
        monitor-exit(r14);     // Catch: Throwable -> L66
        return r0;
    L66:
        th = move-exception;
        throw th;
    L38:
        if (config.version < 8) goto L39;
    L44:
        reason2 = "readXml";
        goto L45
    L13:
        if (config.automaticRules.size() <= 0) goto L33;
        Iterator r5 = config.automaticRules.values().iterator();
    L16:
        if (r5.hasNext() == false) goto L32;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r5.next();
        if (forRestore == false) goto L20;
        automaticRule.condition = null;
        automaticRule.resetConditionOverride();
        automaticRule.creationTime = time;
    L20:
        allRulesDisabled = allRulesDisabled & (!automaticRule.enabled);
        if (config.version >= 11) goto L27;
        ZenPolicy manualRulePolicy = config.getZenPolicy();
        if (automaticRule.zenPolicy != null) goto L25;
        automaticRule.zenPolicy = manualRulePolicy;
        goto L27
    L25:
        automaticRule.zenPolicy = manualRulePolicy.overwrittenWith(automaticRule.zenPolicy);
    L27:
        if (config.version >= 12) goto L16;
        if (ZenModeConfig.isImplicitRuleId(automaticRule.id) == false) goto L16;
        automaticRule.iconResName = null;
        goto L16
    L32:
        allRulesDisabled2 = allRulesDisabled;
        goto L34
    L70:
        return false;
    }

    public void writeXml(TypedXmlSerializer out, boolean forBackup, Integer version, int userId, BackupRestoreEventLogger logger) throws IOException {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        int successfulWrites = 0;
        int unsuccessfulWrites = 0;
        int n = this.mConfigs.size();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= n) goto L19;
        if (forBackup == true) goto L9;
    L27:
        this.mConfigs.valueAt(i).writeXml(out, version, forBackup, logger);     // Catch: Throwable -> L11 Exception -> L15
        successfulWrites = successfulWrites + 1;
    L17:
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L15:
        e = move-exception;
        Slog.e(TAG, "failed to write config", e);     // Catch: Throwable -> L11
        unsuccessfulWrites = unsuccessfulWrites + 1;     // Catch: Throwable -> L11
        goto L17
    L9:
        if (this.mConfigs.keyAt(i) == userId) goto L27;
    L19:
        if (logger == null) goto L23;
        logger.logItemsBackedUp("notifications:zen_config", successfulWrites);     // Catch: Throwable -> L11
        if (unsuccessfulWrites <= 0) goto L23;
        logger.logItemsBackupFailed("notifications:zen_config", unsuccessfulWrites, "notifications:invalid_xml_parsing");     // Catch: Throwable -> L11
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public NotificationManager.Policy getNotificationPolicy(UserHandle user) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L7
        if (config == null) goto L9;
        NotificationManager.Policy r2 = getNotificationPolicy(config);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = getNotificationPolicy(this.mDefaultConfig);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private static NotificationManager.Policy getNotificationPolicy(ZenModeConfig config) {
        if (config != null) goto L5;
        return null;
    L5:
        return config.toNotificationPolicy();
    }

    public void setNotificationPolicy(UserHandle user, NotificationManager.Policy policy, int origin, int callingUid) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        if (policy != null) goto L25;
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L25:
        ZenModeConfig config = getConfigLocked(user);     // Catch: Throwable -> L20
        if (config != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L13:
        ZenModeConfig newConfig = config.copy();     // Catch: Throwable -> L20
        newConfig.applyNotificationPolicy(policy);     // Catch: Throwable -> L20
        setConfigLocked(newConfig, null, origin, "setNotificationPolicy", callingUid);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L20:
        th = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L18
        throw th;
    L7:
        th = th;
    L18:
        th = th;
        goto L22
    }

    private void cleanUpZenRules() {
        Instant keptRuleThreshold = this.mClock.instant().minus(DELETED_RULE_KEPT_FOR);
        Object r2 = this.mConfigLock;
        monitor-enter(r2);
        ZenModeConfig newConfig = this.mConfig.copy();     // Catch: Throwable -> L11
        deleteRulesWithoutOwner(newConfig.automaticRules);     // Catch: Throwable -> L11
        deleteRulesWithoutOwner(newConfig.deletedRules);     // Catch: Throwable -> L11
        int i = newConfig.deletedRules.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        ZenModeConfig.ZenRule deletedRule = (ZenModeConfig.ZenRule) newConfig.deletedRules.valueAt(i);     // Catch: Throwable -> L11
        if (deletedRule.deletionInstant != null) goto L9;
    L13:
        newConfig.deletedRules.removeAt(i);     // Catch: Throwable -> L11
    L14:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (deletedRule.deletionInstant.isBefore(keptRuleThreshold) == false) goto L14;
    L15:
        deleteUnusedImplicitRules(newConfig.automaticRules);     // Catch: Throwable -> L11
        if (newConfig.equals(this.mConfig) == true) goto L18;
        setConfigLocked(newConfig, null, 5, "cleanUpZenRules", 1000);     // Catch: Throwable -> L11
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void deleteRulesWithoutOwner(ArrayMap<String, ZenModeConfig.ZenRule> ruleList) {
        long currentTime = this.mClock.millis();
        if (ruleList == null) goto L17;
        int i = ruleList.size() - 1;
    L5:
        if (i < 0) goto L25;
        ZenModeConfig.ZenRule rule = ruleList.valueAt(i);
        if (259200000 >= (currentTime - rule.creationTime)) goto L16;
        if (rule.getPkg() == null) goto L16;
        this.mPm.getPackageInfo(rule.getPkg(), 4194304);     // Catch: PackageManager.NameNotFoundException -> L12
    L15:
        ruleList.removeAt(i);
    L16:
        i = i - 1;
        goto L5
    L25:
        return;
    }

    private void deleteUnusedImplicitRules(ArrayMap<String, ZenModeConfig.ZenRule> ruleList) {
        if (ruleList != null) goto L4;
        return;
    L4:
        Instant deleteIfUnusedSince = this.mClock.instant().minus(IMPLICIT_RULE_KEPT_FOR);
        int i = ruleList.size() - 1;
    L5:
        if (i < 0) goto L18;
        ZenModeConfig.ZenRule rule = ruleList.valueAt(i);
        if (ZenModeConfig.isImplicitRuleId(rule.id) == false) goto L16;
        if (rule.isUserModified() == true) goto L16;
        if (rule.lastActivation != null) goto L14;
        rule.lastActivation = this.mClock.instant();
    L14:
        if (rule.lastActivation.isBefore(deleteIfUnusedSince) == false) goto L16;
        ruleList.removeAt(i);
    L16:
        i = i - 1;
        goto L5
    }

    public ZenModeConfig getConfig() {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        ZenModeConfig r1 = this.mConfig.copy();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public NotificationManager.Policy getConsolidatedNotificationPolicy() {
        return this.mConsolidatedPolicy.copy();
    }

    protected ZenPolicy getDefaultZenPolicy() {
        return this.mDefaultConfig.getZenPolicy();
    }

    private ZenModeConfig getConfigLocked(UserHandle user) {
        if (user.getIdentifier() == (-2)) goto L10;
        if (user.getIdentifier() == this.mUser) goto L10;
        return this.mConfigs.get(user.getIdentifier());
    L10:
        return this.mConfig;
    }

    private boolean setConfigLocked(ZenModeConfig config, ComponentName triggeringComponent, int origin, String reason, int callingUid) {
        return setConfigLocked(config, origin, reason, triggeringComponent, true, callingUid);
    }

    void setConfig(ZenModeConfig config, ComponentName triggeringComponent, int origin, String reason, int callingUid) {
        Object r1 = this.mConfigLock;
        monitor-enter(r1);
        setConfigLocked(config, triggeringComponent, origin, reason, callingUid);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean setConfigLocked(ZenModeConfig config, int origin, String reason, ComponentName triggeringComponent, boolean setRingerMode, int callingUid) {
        long identity = Binder.clearCallingIdentity();
        if (config == null) goto L55;
    L19:
        e = e;
    L59:
        Log.wtf(TAG, "Invalid rule in config", e);     // Catch: Throwable -> L44
        Binder.restoreCallingIdentity(identity);
        return false;
    L17:
        e = th;
    L62:
        Binder.restoreCallingIdentity(identity);
        throw e;
    L5:
        if (config.isValid() == false) goto L55;
        if (config.user == this.mUser) goto L26;
        Object r3 = this.mConfigLock;     // Catch: Throwable -> L17 SecurityException -> L19
        monitor-enter(r3);     // Catch: Throwable -> L17 SecurityException -> L19
        this.mConfigs.put(config.user, config);     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
    L14:
        if (DEBUG == false) goto L21;
        Log.d(TAG, "setConfigLocked: store config for user " + config.user);     // Catch: Throwable -> L17 SecurityException -> L19
    L21:
        Binder.restoreCallingIdentity(identity);
        return true;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17 SecurityException -> L19
    L26:
        this.mConditions.evaluateConfig(config, null, false);     // Catch: Throwable -> L17 SecurityException -> L19
        Object r4 = this.mConfigLock;     // Catch: Throwable -> L17 SecurityException -> L19
        monitor-enter(r4);     // Catch: Throwable -> L17 SecurityException -> L19
        this.mConfigs.put(config.user, config);     // Catch: Throwable -> L48
        monitor-exit(r4);     // Catch: Throwable -> L48
        if (DEBUG == false) goto L35;
        Log.d(TAG, "setConfigLocked reason=" + reason, new Throwable());     // Catch: Throwable -> L17 SecurityException -> L19
    L35:
        ZenLog.traceConfig(origin, reason, triggeringComponent, this.mConfig, config, callingUid);     // Catch: Throwable -> L44 SecurityException -> L46
        NotificationManager.Policy newPolicy = getNotificationPolicy(config);     // Catch: Throwable -> L17 SecurityException -> L19
        boolean policyChanged = !Objects.equals(getNotificationPolicy(this.mConfig), newPolicy);     // Catch: Throwable -> L17 SecurityException -> L19
        if (policyChanged == false) goto L39;
        dispatchOnPolicyChanged(newPolicy);     // Catch: Throwable -> L17 SecurityException -> L19
    L39:
        updateConfigAndZenModeLocked(config, origin, reason, setRingerMode, callingUid);     // Catch: Throwable -> L17 SecurityException -> L19
        this.mConditions.evaluateConfig(config, triggeringComponent, true);     // Catch: Throwable -> L44 SecurityException -> L46
        Binder.restoreCallingIdentity(identity);
        return true;
    L48:
        th = th;
    L68:
        throw th;     // Catch: Throwable -> L44 SecurityException -> L46
    L52:
        th = th;
    L55:
        Log.w(TAG, "Invalid config in setConfigLocked; " + config);     // Catch: Throwable -> L44 SecurityException -> L46
        Binder.restoreCallingIdentity(identity);
        return false;
    L44:
        e = th;
    L46:
        e = e;
        goto L59
    }

    private void updateConfigAndZenModeLocked(ZenModeConfig config, int origin, String reason, boolean setRingerMode, int callingUid) {
        boolean logZenModeEvents = this.mFlagResolver.isEnabled(SystemUiSystemPropertiesFlags.NotificationFlags.LOG_DND_STATE_EVENTS);
        ZenModeEventLogger.ZenModeInfo prevInfo = new ZenModeEventLogger.ZenModeInfo(this.mZenMode, this.mConfig, this.mConsolidatedPolicy);
        if (config.equals(this.mConfig) == false) goto L5;
    L34:
        String val = Integer.toString(config.hashCode());
        Settings.Global.putString(this.mContext.getContentResolver(), "zen_mode_config_etag", val);
        evaluateZenModeLocked(origin, reason, setRingerMode);
        if (logZenModeEvents == false) goto L53;
        ZenModeEventLogger.ZenModeInfo newInfo = new ZenModeEventLogger.ZenModeInfo(this.mZenMode, this.mConfig, this.mConsolidatedPolicy);
        this.mZenModeEventLogger.maybeLogZenChange(prevInfo, newInfo, callingUid, origin);
        return;
    L53:
        return;
    L5:
        if (origin == 1) goto L18;
        Iterator r2 = config.automaticRules.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L18;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r2.next();
        ZenModeConfig.ZenRule original = (ZenModeConfig.ZenRule) this.mConfig.automaticRules.get(rule.id);
        if (original == null) goto L8;
        if (original.enabled == rule.enabled) goto L15;
        scheduleEnabledBroadcast(rule.getPkg(), config.user, rule.id, rule.enabled);
    L15:
        if (original.isActive() == rule.isActive()) goto L8;
        scheduleActivationBroadcast(rule.getPkg(), config.user, rule.id, rule.isActive());
    L18:
        Instant now = this.mClock.instant();
        if (this.mConfig.isManualActive() == false) goto L21;
    L23:
        Iterator r3 = config.automaticRules.values().iterator();
    L25:
        if (r3.hasNext() == false) goto L33;
        ZenModeConfig.ZenRule rule2 = (ZenModeConfig.ZenRule) r3.next();
        ZenModeConfig.ZenRule previousRule = (ZenModeConfig.ZenRule) this.mConfig.automaticRules.get(rule2.id);
        if (rule2.isActive() == false) goto L25;
        if (previousRule == null) goto L31;
        if (previousRule.isActive() == true) goto L25;
    L31:
        rule2.lastActivation = now;
        goto L25
    L33:
        this.mConfig = config;
        dispatchOnConfigChanged();
        updateAndApplyConsolidatedPolicyAndDeviceEffects(origin, reason);
        goto L34
    L21:
        if (config.isManualActive() == false) goto L23;
        config.manualRule.lastActivation = now;
        goto L23
    }

    private int getZenModeSetting() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode", 0);
    }

    protected void setZenModeSetting(int zen) {
        Settings.Global.putInt(this.mContext.getContentResolver(), "zen_mode", zen);
        ZenLog.traceSetZenMode(Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode", -1), "updated setting");
    }

    private int getPreviousRingerModeSetting() {
        return Settings.Global.getInt(this.mContext.getContentResolver(), "zen_mode_ringer_level", 2);
    }

    private void setPreviousRingerModeSetting(Integer previousRingerLevel) {
        ContentResolver r0 = this.mContext.getContentResolver();
        if (previousRingerLevel != null) goto L5;
        String r1 = null;
    L6:
        Settings.Global.putString(r0, "zen_mode_ringer_level", r1);
        return;
    L5:
        r1 = Integer.toString(previousRingerLevel.intValue());
        goto L6
    }

    protected void evaluateZenModeLocked(int origin, String reason, boolean setRingerMode) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "evaluateZenMode");
    L6:
        if (this.mConfig != null) goto L8;
        return;
    L8:
        boolean shouldApplyToRinger = false;
        if (this.mConsolidatedPolicy != null) goto L11;
        int policyHashBefore = 0;
    L12:
        int zenBefore = this.mZenMode;
        int zen = computeZenMode();
        ZenLog.traceSetZenMode(zen, reason);
        this.mZenMode = zen;
        setZenModeSetting(this.mZenMode);
        updateAndApplyConsolidatedPolicyAndDeviceEffects(origin, reason);
        if (setRingerMode == true) goto L15;
    L21:
        H.m6324$$Nest$mpostUpdateRingerAndAudio(this.mHandler, shouldApplyToRinger);
        if (zen == zenBefore) goto L25;
        H.m6322$$Nest$mpostDispatchOnZenModeChanged(this.mHandler);
        return;
    L25:
        return;
    L15:
        if (zen != zenBefore) goto L19;
        if (zen != 1) goto L21;
        if (policyHashBefore == this.mConsolidatedPolicy.hashCode()) goto L21;
    L19:
        shouldApplyToRinger = true;
        goto L21
    L11:
        policyHashBefore = this.mConsolidatedPolicy.hashCode();
        goto L12
    }

    private void updateRingerAndAudio(boolean shouldApplyToRinger) {
        if (this.mAudioManager == null) goto L5;
        this.mAudioManager.updateRingerModeAffectedStreamsInternal();
    L5:
        if (shouldApplyToRinger == false) goto L7;
        applyZenToRingerMode();
    L7:
        applyRestrictions();
    }

    private int computeZenMode() {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mConfig != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L12:
        if (this.mConfig.isManualActive() == false) goto L16;
        int r1 = this.mConfig.manualRule.zenMode;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L16:
        int zen = 0;
        Iterator r2 = this.mConfig.automaticRules.values().iterator();     // Catch: Throwable -> L9
    L18:
        if (r2.hasNext() == false) goto L25;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r2.next();     // Catch: Throwable -> L9
        if (automaticRule.isActive() == false) goto L18;
        if (zenSeverity(automaticRule.zenMode) <= zenSeverity(zen)) goto L18;
        zen = automaticRule.zenMode;     // Catch: Throwable -> L9
        goto L18
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return zen;
    }

    private void applyCustomPolicy(ZenModeConfig config, ZenPolicy policy, ZenModeConfig.ZenRule rule, boolean useManualConfig) {
        if (rule.zenMode != 2) goto L6;
        policy.apply(ZenPolicy.getBasePolicyInterruptionFilterNone());
        return;
    L6:
        if (rule.zenMode != 3) goto L9;
        policy.apply(ZenPolicy.getBasePolicyInterruptionFilterAlarms());
        return;
    L9:
        if (rule.zenPolicy == null) goto L11;
        policy.apply(rule.zenPolicy);
        return;
    L11:
        if (useManualConfig == false) goto L13;
        policy.apply(config.getZenPolicy());
        return;
    L13:
        Log.wtf(TAG, "active automatic rule found with no specified policy: " + rule);
        policy.apply(this.mDefaultConfig.getZenPolicy());
    }

    private void updateAndApplyConsolidatedPolicyAndDeviceEffects(int origin, String reason) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mConfig != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        ZenPolicy policy = new ZenPolicy();     // Catch: Throwable -> L8
        ZenDeviceEffects.Builder deviceEffectsBuilder = new ZenDeviceEffects.Builder();     // Catch: Throwable -> L8
        if (this.mConfig.isManualActive() == false) goto L13;
        applyCustomPolicy(this.mConfig, policy, this.mConfig.manualRule, true);     // Catch: Throwable -> L8
        deviceEffectsBuilder.add(this.mConfig.manualRule.zenDeviceEffects);     // Catch: Throwable -> L8
    L13:
        Iterator r3 = this.mConfig.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L15:
        if (r3.hasNext() == false) goto L23;
        ZenModeConfig.ZenRule automaticRule = (ZenModeConfig.ZenRule) r3.next();     // Catch: Throwable -> L8
        if (automaticRule.isActive() == false) goto L15;
        if (automaticRule.zenMode == 0) goto L21;
        applyCustomPolicy(this.mConfig, policy, automaticRule, false);     // Catch: Throwable -> L8
    L21:
        deviceEffectsBuilder.add(automaticRule.zenDeviceEffects);     // Catch: Throwable -> L8
        goto L15
    L23:
        NotificationManager.Policy newPolicy = this.mConfig.toNotificationPolicy(policy);     // Catch: Throwable -> L8
        if (Objects.equals(this.mConsolidatedPolicy, newPolicy) == true) goto L26;
        this.mConsolidatedPolicy = newPolicy;     // Catch: Throwable -> L8
        dispatchOnConsolidatedPolicyChanged(newPolicy);     // Catch: Throwable -> L8
        ZenLog.traceSetConsolidatedZenPolicy(this.mConsolidatedPolicy, reason);     // Catch: Throwable -> L8
    L26:
        boolean hasActiveDriving = false;
        boolean hasActiveDrivingWithGrayscale = false;
        Iterator r7 = this.mConfig.automaticRules.values().iterator();     // Catch: Throwable -> L8
    L28:
        if (r7.hasNext() == false) goto L39;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r7.next();     // Catch: Throwable -> L8
        if (rule.isActive() == false) goto L28;
        if (rule.type != 4) goto L28;
        hasActiveDriving = true;
        if (rule.zenDeviceEffects == null) goto L28;
        if (rule.zenDeviceEffects.shouldDisplayGrayscale() == false) goto L28;
        hasActiveDrivingWithGrayscale = true;
    L39:
        if (hasActiveDriving == false) goto L42;
        if (hasActiveDrivingWithGrayscale == true) goto L42;
        deviceEffectsBuilder.setShouldDisplayGrayscale(false);     // Catch: Throwable -> L8
    L42:
        ZenDeviceEffects deviceEffects = deviceEffectsBuilder.build();     // Catch: Throwable -> L8
        if (deviceEffects.equals(this.mConsolidatedDeviceEffects) == true) goto L45;
        this.mConsolidatedDeviceEffects = deviceEffects;     // Catch: Throwable -> L8
        H.m6321$$Nest$mpostApplyDeviceEffects(this.mHandler, origin);     // Catch: Throwable -> L8
    L45:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void applyConsolidatedDeviceEffects(int source) {
        Object r0 = this.mConfigLock;
        monitor-enter(r0);
        DeviceEffectsApplier applier = this.mDeviceEffectsApplier;     // Catch: Throwable -> L9
        ZenDeviceEffects effects = this.mConsolidatedDeviceEffects;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (applier == null) goto L14;
        applier.apply(effects, source);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static void updateDefaultConfig(Context context, ZenModeConfig defaultConfig) {
        updateDefaultAutomaticRulePolicies(defaultConfig);
        SystemZenRules.maybeUpgradeRules(context, defaultConfig);
        updateRuleStringsForCurrentLocale(context, defaultConfig);
    }

    private static void updateRuleStringsForCurrentLocale(Context context, ZenModeConfig defaultConfig) {
        Iterator r0 = defaultConfig.automaticRules.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r0.next();
        if ("EVENTS_DEFAULT_RULE".equals(rule.id) == false) goto L9;
        rule.name = context.getResources().getString(17042454);
    L11:
        SystemZenRules.updateTriggerDescription(context, rule);
        goto L4
    L9:
        if ("EVERY_NIGHT_DEFAULT_RULE".equals(rule.id) == false) goto L11;
        rule.name = context.getResources().getString(17042455);
        goto L11
    }

    private static void updateDefaultAutomaticRulePolicies(ZenModeConfig defaultConfig) {
        ZenPolicy defaultPolicy = defaultConfig.getZenPolicy();
        Iterator r1 = defaultConfig.automaticRules.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r1.next();
        if (ZenModeConfig.getDefaultRuleIds().contains(rule.id) == false) goto L4;
        if (rule.zenPolicy != null) goto L4;
        rule.zenPolicy = defaultPolicy.copy();
        goto L4
    }

    protected void applyRestrictions() {
        if (this.mZenMode == 0) goto L5;
        boolean zenOn = true;
    L7:
        if (this.mZenMode != 1) goto L9;
        boolean zenPriorityOnly = true;
    L11:
        if (this.mZenMode != 2) goto L13;
        boolean zenSilence = true;
    L15:
        if (this.mZenMode == 3) goto L17;
    L19:
        boolean zenAlarmsOnly = false;
    L21:
        if (this.mConsolidatedPolicy.allowCalls() == true) goto L23;
    L25:
        boolean allowCalls = false;
    L26:
        boolean allowRepeatCallers = this.mConsolidatedPolicy.allowRepeatCallers();
        boolean allowSystem = this.mConsolidatedPolicy.allowSystem();
        boolean allowMedia = this.mConsolidatedPolicy.allowMedia();
        boolean allowAlarms = this.mConsolidatedPolicy.allowAlarms();
        if (zenOn == true) goto L32;
        long r16 = 0;
        if ((this.mSuppressedEffects & 1) != 0) goto L33;
        boolean muteNotifications = false;
    L34:
        if (zenAlarmsOnly == true) goto L44;
        if (zenPriorityOnly == false) goto L40;
        if (allowCalls == false) goto L39;
        if (allowRepeatCallers == true) goto L40;
    L39:
        boolean zenAlarmsOnly2 = zenAlarmsOnly;
    L45:
        boolean muteCalls = true;
    L46:
        if (zenPriorityOnly == false) goto L49;
        if (allowAlarms == true) goto L49;
        boolean muteAlarms = true;
    L50:
        if (zenPriorityOnly == false) goto L53;
        if (allowMedia == true) goto L53;
        boolean muteMedia = true;
    L54:
        if (zenAlarmsOnly2 == true) goto L59;
        if (zenPriorityOnly == false) goto L58;
        if (allowSystem == false) goto L59;
    L58:
        boolean muteSystem = false;
    L61:
        if (zenSilence == true) goto L67;
        if (zenPriorityOnly == true) goto L64;
    L66:
        boolean muteEverything = false;
    L68:
        int[] r3 = AudioAttributes.SDK_USAGES.toArray();
        int r2 = r3.length;
        int r8 = 0;
    L69:
        if (r8 >= r2) goto L123;
        boolean zenOn2 = zenOn;
        int usage = r3[r8];
        int r22 = r2;
        int[] r23 = r3;
        int suppressionBehavior = this.mZenModeHelperExtProxy.applyRestrictions_overriderSuppressionBehavior(usage, AudioAttributes.SUPPRESSIBLE_USAGES.get(usage));
        if (suppressionBehavior != 3) goto L73;
        applyRestrictions(zenPriorityOnly, false, usage);
    L122:
        r8 = r8 + 1;
        zenOn = zenOn2;
        r2 = r22;
        r3 = r23;
        goto L69
    L73:
        boolean r4 = true;
        if (suppressionBehavior != 1) goto L81;
        if (muteNotifications == true) goto L79;
        if (muteEverything == true) goto L79;
        r4 = false;
    L79:
        applyRestrictions(zenPriorityOnly, r4, usage);
        goto L122
    L81:
        if (suppressionBehavior != 2) goto L89;
        if (muteCalls == true) goto L86;
        if (muteEverything == true) goto L86;
        boolean r5 = false;
    L87:
        applyRestrictions(zenPriorityOnly, r5, usage);
    L86:
        r5 = true;
        goto L87
    L89:
        if (suppressionBehavior != 4) goto L97;
        if (muteAlarms == true) goto L94;
        if (muteEverything == true) goto L94;
        boolean r6 = false;
    L95:
        applyRestrictions(zenPriorityOnly, r6, usage);
    L94:
        r6 = true;
        goto L95
    L97:
        if (suppressionBehavior != 5) goto L105;
        if (muteMedia == true) goto L102;
        if (muteEverything == true) goto L102;
        boolean r7 = false;
    L103:
        applyRestrictions(zenPriorityOnly, r7, usage);
    L102:
        r7 = true;
        goto L103
    L105:
        if (suppressionBehavior == 6) goto L107;
        applyRestrictions(zenPriorityOnly, muteEverything, usage);
        goto L122
    L107:
        if (usage != 13) goto L115;
        if (muteSystem == true) goto L112;
        if (muteEverything == true) goto L112;
        boolean r9 = false;
    L113:
        applyRestrictions(zenPriorityOnly, r9, usage, 28);
        applyRestrictions(zenPriorityOnly, false, usage, 3);
    L112:
        r9 = true;
        goto L113
    L115:
        if (muteSystem == true) goto L119;
        if (muteEverything == true) goto L119;
        boolean r10 = false;
    L120:
        applyRestrictions(zenPriorityOnly, r10, usage);
    L119:
        r10 = true;
        goto L120
    L123:
        return;
    L64:
        if (ZenModeConfig.areAllZenBehaviorSoundsMuted(this.mConsolidatedPolicy) == false) goto L66;
    L67:
        muteEverything = true;
    L59:
        muteSystem = true;
    L53:
        muteMedia = false;
    L49:
        muteAlarms = false;
    L40:
        zenAlarmsOnly2 = zenAlarmsOnly;
        if ((this.mSuppressedEffects & 2) != r16) goto L45;
        muteCalls = false;
        goto L46
    L44:
        zenAlarmsOnly2 = zenAlarmsOnly;
    L33:
        muteNotifications = true;
        goto L34
    L32:
        r16 = 0;
        goto L33
    L23:
        if (this.mConsolidatedPolicy.allowCallsFrom() != 0) goto L25;
        allowCalls = true;
        goto L26
    L17:
        if (onlyGameModeUseAlarmZenMode() == true) goto L19;
        zenAlarmsOnly = true;
        goto L21
    L13:
        zenSilence = false;
        goto L15
    L9:
        zenPriorityOnly = false;
        goto L11
    L5:
        zenOn = false;
        goto L7
    }

    protected void applyRestrictions(boolean r5, boolean r6, int r7, int r8) {
        long r0 = Binder.clearCallingIdentity();
        AppOpsManager r2 = this.mAppOps;     // Catch: Throwable -> L6
        if (r5 == false) goto L8;
        String[] r3 = this.mPriorityOnlyDndExemptPackages;     // Catch: Throwable -> L6
    L9:
        r2.setRestriction(r8, r7, r6 ? 1 : 0, r3);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(r0);
        return;
    L8:
        r3 = null;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(r0);
        throw th;
    }

    protected void applyRestrictions(boolean zenPriorityOnly, boolean mute, int usage) {
        applyRestrictions(zenPriorityOnly, mute, usage, 3);
        applyRestrictions(zenPriorityOnly, mute, usage, 28);
    }

    protected void applyZenToRingerMode() {
        if (this.mAudioManager != null) goto L5;
        return;
    L5:
        int ringerModeInternal = this.mAudioManager.getRingerModeInternal();
        int newRingerModeInternal = ringerModeInternal;
        switch(this.mZenMode) {
            case 0: goto L14;
            case 1: goto L17;
            case 2: goto L9;
            case 3: goto L9;
            default: goto L17;
        };
    L14:
        if (ringerModeInternal != 0) goto L17;
        newRingerModeInternal = getPreviousRingerModeSetting();
        setPreviousRingerModeSetting(null);
        goto L17
    L9:
        if (onlyGameModeUseAlarmZenMode() == false) goto L11;
        Slog.d(TAG, "ZEN_MODE_ALARMS USE BY GAME MODE");
        goto L17
    L11:
        if (ringerModeInternal == 0) goto L17;
        setPreviousRingerModeSetting(Integer.valueOf(ringerModeInternal));
        newRingerModeInternal = 0;
    L17:
        if (newRingerModeInternal == (-1)) goto L20;
        this.mAudioManager.setRingerModeInternal(newRingerModeInternal, TAG);
        return;
    }

    private void dispatchOnConfigChanged() {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Callback callback = r0.next();
        callback.onConfigChanged();
        goto L4
    }

    private void dispatchOnPolicyChanged(NotificationManager.Policy newPolicy) {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Callback callback = r0.next();
        callback.onPolicyChanged(newPolicy);
        goto L4
    }

    private void dispatchOnConsolidatedPolicyChanged(NotificationManager.Policy newConsolidatedPolicy) {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Callback callback = r0.next();
        callback.onConsolidatedPolicyChanged(newConsolidatedPolicy);
        goto L4
    }

    private void dispatchOnZenModeChanged() {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Callback callback = r0.next();
        callback.onZenModeChanged();
        goto L4
    }

    private void dispatchOnAutomaticRuleStatusChanged(int userId, String pkg, String id, int status) {
        Iterator<Callback> r0 = this.mCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Callback callback = r0.next();
        callback.onAutomaticRuleStatusChanged(userId, pkg, id, status);
        goto L4
    }

    private ZenModeConfig readDefaultConfig(Resources resources) {
        XmlResourceParser parser = null;
        parser = resources.getXml(R.xml.default_zen_mode_config);     // Catch: Throwable -> L11 Exception -> L13
    L5:
        if (parser.next() == 1) goto L16;
        ZenModeConfig config = ZenModeConfig.readXml(XmlUtils.makeTyped(parser), null);     // Catch: Throwable -> L11 Exception -> L13
        if (config == null) goto L5;
        IoUtils.closeQuietly(parser);
        return config;
    L16:
        IoUtils.closeQuietly(parser);
        return new ZenModeConfig();
    L11:
        th = move-exception;
        IoUtils.closeQuietly(parser);
        throw th;
    L13:
        e = move-exception;
        Log.w(TAG, "Error reading default zen mode config from resource", e);     // Catch: Throwable -> L11
        goto L16
    }

    private static int zenSeverity(int zen) {
        switch(zen) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 2;
    L7:
        return 3;
    L9:
        return 1;
    }

    public void pullRules(List<StatsEvent> events) {
        Object r3 = this.mConfigLock;
        monitor-enter(r3);
        int numConfigs = this.mConfigs.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= numConfigs) goto L17;
        int user = this.mConfigs.keyAt(i);     // Catch: Throwable -> L9
        ZenModeConfig config = this.mConfigs.valueAt(i);     // Catch: Throwable -> L9
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.DND_MODE_RULE, user, config.isManualActive(), config.hasPriorityChannels, -1, "", 1000, config.getZenPolicy().toProto(), 0, 0, 0, -1));     // Catch: Throwable -> L9
        if (config.isManualActive() == false) goto L11;
        ruleToProtoLocked(user, config.manualRule, true, events);     // Catch: Throwable -> L9
    L11:
        Iterator r6 = config.automaticRules.values().iterator();     // Catch: Throwable -> L9
    L13:
        if (r6.hasNext() == false) goto L15;
        ZenModeConfig.ZenRule rule = (ZenModeConfig.ZenRule) r6.next();     // Catch: Throwable -> L9
        ruleToProtoLocked(user, rule, false, events);     // Catch: Throwable -> L9
        goto L13
    L15:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void ruleToProtoLocked(int user, ZenModeConfig.ZenRule rule, boolean isManualRule, List<StatsEvent> events) {
        String pkg = "";
        if (rule.id != null) goto L5;
        String id = "";
    L7:
        if (ZenModeConfig.getDefaultRuleIds().contains(id) == true) goto L10;
        id = "";
    L10:
        if (rule.getPkg() == null) goto L14;
        pkg = rule.getPkg();
    L14:
        if (rule.enabler == null) goto L16;
        pkg = rule.enabler;
    L16:
        int ruleType = rule.type;
        if (isManualRule == false) goto L19;
        String id2 = "MANUAL_RULE";
        int ruleType2 = 999;
    L20:
        byte[] policyProto = new byte[0];
        if (rule.zenPolicy == null) goto L23;
        byte[] policyProto2 = rule.zenPolicy.toProto();
        byte[] policyProto3 = policyProto2;
    L24:
        events.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.DND_MODE_RULE, user, rule.enabled, false, rule.zenMode, id2, getPackageUid(pkg, user), policyProto3, rule.userModifiedFields, rule.zenPolicyUserModifiedFields, rule.zenDeviceEffectsUserModifiedFields, ruleType2));
        return;
    L23:
        policyProto3 = policyProto;
        goto L24
    L19:
        id2 = id;
        ruleType2 = ruleType;
        goto L20
    L5:
        id = rule.id;
        goto L7
    }

    private int getPackageUid(String pkg, int user) {
        if ("android".equals(pkg) == false) goto L6;
        return 1000;
    L6:
        String key = getPackageUserKey(pkg, user);
        if (this.mRulesUidCache.get(key) != null) goto L12;
        this.mRulesUidCache.put(key, Integer.valueOf(this.mPm.getPackageUidAsUser(pkg, user)));     // Catch: PackageManager.NameNotFoundException -> L10
    L12:
        return this.mRulesUidCache.getOrDefault(key, -1).intValue();
    }

    private static String getPackageUserKey(String pkg, int user) {
        return pkg + "|" + user;
    }

    private int drawableResNameToResId(String packageName, String resourceName) {
        if (TextUtils.isEmpty(resourceName) == false) goto L10;
        return 0;
    L10:
        Resources res = this.mPm.getResourcesForApplication(packageName);     // Catch: PackageManager.NameNotFoundException -> L7
        return res.getIdentifier(resourceName, null, null);
    L7:
        e = move-exception;
        Slog.w(TAG, "cannot load rule icon for pkg", e);
        return 0;
    }

    private String drawableResIdToResName(String packageName, int resId) {
        if (resId != 0) goto L5;
        return null;
    L5:
        packageName.getClass();
        Resources res = this.mPm.getResourcesForApplication(packageName);     // Catch: Throwable -> L12
        String resourceName = res.getResourceName(resId);     // Catch: Throwable -> L12
        if (resourceName != null) goto L9;
    L14:
        return resourceName;
    L9:
        if (resourceName.length() <= 1000) goto L14;
        Slog.e(TAG, "Resource name for ID=" + resId + " in package " + packageName + " is too long (" + resourceName.length() + "); ignoring it");     // Catch: Throwable -> L12
        return null;
    L15:
        Slog.e(TAG, "Resource name for ID=" + resId + " not found in package " + packageName + ". Resource IDs may change when the application is upgraded, and the system may not be able to find the correct resource.");
        return null;
    }

    private static void checkManageRuleOrigin(String method, int origin) {
        if (origin != 4) goto L5;
    L10:
        boolean r0 = true;
    L11:
        Preconditions.checkArgument(r0, "Expected one of ORIGIN_APP, ORIGIN_SYSTEM, or ORIGIN_USER_IN_SYSTEMUI for %s, but received '%s'.", new Object[]{method, Integer.valueOf(origin)});
        return;
    L5:
        if (origin == 5) goto L10;
        if (origin == 3) goto L10;
        r0 = false;
        goto L11
    }

    private static void checkSetRuleStateOrigin(String method, int origin) {
        if (origin != 4) goto L5;
    L12:
        boolean r0 = true;
    L13:
        Preconditions.checkArgument(r0, "Expected one of ORIGIN_APP, ORIGIN_USER_IN_APP, ORIGIN_SYSTEM, or ORIGIN_USER_IN_SYSTEMUI for %s, but received '%s'.", new Object[]{method, Integer.valueOf(origin)});
        return;
    L5:
        if (origin == 7) goto L12;
        if (origin == 5) goto L12;
        if (origin == 3) goto L12;
        r0 = false;
        goto L13
    }

    private boolean onlyGameModeUseAlarmZenMode() {
        if (this.mZenMode != 3) goto L18;
        ArrayList<AutomaticZenRule> autoZenModeAlarm = new ArrayList();
        Iterator<Map.Entry<String, AutomaticZenRule>> r1 = getAutomaticZenRules(UserHandle.CURRENT, 1000).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, AutomaticZenRule> rule = r1.next();
        if (rule.getValue().isEnabled() == false) goto L6;
        if (rule.getValue().getInterruptionFilter() != 4) goto L6;
        autoZenModeAlarm.add(rule.getValue());
        goto L6
    L14:
        if (autoZenModeAlarm.size() != 1) goto L18;
        if ("game_mode".equals(autoZenModeAlarm.get(0).getName()) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
