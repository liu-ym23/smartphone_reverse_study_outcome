package com.android.server;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.compat.CompatChanges;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.telephony.BarringInfo;
import android.telephony.CallQuality;
import android.telephony.CallState;
import android.telephony.CellIdentity;
import android.telephony.CellInfo;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.CellularIdentifierDisclosure;
import android.telephony.LinkCapacityEstimate;
import android.telephony.LocationAccessPolicy;
import android.telephony.PhoneCapability;
import android.telephony.PhysicalChannelConfig;
import android.telephony.PreciseCallState;
import android.telephony.PreciseDataConnectionState;
import android.telephony.Rlog;
import android.telephony.SecurityAlgorithmUpdate;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.telephony.data.ApnSetting;
import android.telephony.emergency.EmergencyNumber;
import android.telephony.ims.ImsReasonInfo;
import android.telephony.ims.MediaQualityStatus;
import android.telephony.satellite.NtnSignalStrength;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.LocalLog;
import android.util.Pair;
import android.util.SparseArray;
import com.android.internal.app.IBatteryStats;
import com.android.internal.telephony.ICarrierConfigChangeListener;
import com.android.internal.telephony.ICarrierPrivilegesCallback;
import com.android.internal.telephony.IOnSubscriptionsChangedListener;
import com.android.internal.telephony.IPhoneStateListener;
import com.android.internal.telephony.ISatelliteStateChangeListener;
import com.android.internal.telephony.ITelephonyRegistry;
import com.android.internal.telephony.TelephonyPermissions;
import com.android.internal.telephony.util.TelephonyUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.am.BatteryStatsService;
import com.android.server.autofill.HintsHelper;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyRegistry extends ITelephonyRegistry.Stub {
    private static final String ACTION_ANY_DATA_CONNECTION_STATE_CHANGED = "android.intent.action.ANY_DATA_STATE";
    private static final String ACTION_RADIO_POWER_STATE_CHANGED = "org.codeaurora.intent.action.RADIO_POWER_STATE";
    public static final String ACTION_SIGNAL_STRENGTH_CHANGED = "android.intent.action.SIG_STR";
    private static final String ACTION_SUBSCRIPTION_PHONE_STATE_CHANGED = "android.intent.action.SUBSCRIPTION_PHONE_STATE";
    private static final boolean DBG = false;
    private static final boolean DBG_LOC = false;
    private static final long DISPLAY_INFO_NR_ADVANCED_SUPPORTED = 181658987;
    private static final List<LinkCapacityEstimate> INVALID_LCE_LIST = null;
    private static final int MSG_UPDATE_DEFAULT_SUB = 2;
    private static final int MSG_USER_SWITCHED = 1;
    private static final String PHONE_CONSTANTS_DATA_APN_KEY = "apn";
    private static final String PHONE_CONSTANTS_DATA_APN_TYPE_KEY = "apnType";
    private static final String PHONE_CONSTANTS_SLOT_KEY = "slot";
    private static final String PHONE_CONSTANTS_STATE_KEY = "state";
    private static final String PHONE_CONSTANTS_SUBSCRIPTION_KEY = "subscription";
    private static final Set<Integer> REQUIRE_PRECISE_PHONE_STATE_PERMISSION = null;
    private static final long REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_ACTIVE_DATA_SUB_ID = 182478738;
    private static final long REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_CELL_INFO = 184323934;
    private static final long REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_DISPLAY_INFO = 183164979;
    private static final String TAG = "TelephonyRegistry";
    private static final boolean VDBG = false;
    private int mActiveDataSubId;
    private int[] mAllowedNetworkTypeReason;
    private long[] mAllowedNetworkTypeValue;
    private final AppOpsManager mAppOps;
    private int[] mBackgroundCallState;
    private List<BarringInfo> mBarringInfo;
    private final IBatteryStats mBatteryStats;
    private final BroadcastReceiver mBroadcastReceiver;
    private int[] mCallDisconnectCause;
    private boolean[] mCallForwarding;
    private String[] mCallIncomingNumber;
    private int[] mCallNetworkType;
    private int[] mCallPreciseDisconnectCause;
    private CallQuality[] mCallQuality;
    private int[] mCallState;
    private ArrayList<List<CallState>> mCallStateLists;
    private boolean[] mCarrierNetworkChangeState;
    private List<Pair<List<String>, int[]>> mCarrierPrivilegeStates;
    private List<IntArray> mCarrierRoamingNtnAvailableServices;
    private boolean[] mCarrierRoamingNtnEligible;
    private boolean[] mCarrierRoamingNtnMode;
    private NtnSignalStrength[] mCarrierRoamingNtnSignalStrength;
    private List<Pair<String, Integer>> mCarrierServiceStates;
    private CellIdentity[] mCellIdentity;
    private ArrayList<List<CellInfo>> mCellInfo;
    private ConfigurationProvider mConfigurationProvider;
    private final Context mContext;
    private int[] mDataActivationState;
    private int[] mDataActivity;
    private int[] mDataConnectionNetworkType;
    private int[] mDataConnectionState;
    private int[] mDataEnabledReason;
    private int mDefaultPhoneId;
    private int mDefaultSubId;
    private long[] mECBMDuration;
    private int[] mECBMReason;
    private Map<Integer, List<EmergencyNumber>> mEmergencyNumberList;
    private int[] mForegroundCallState;
    private final Handler mHandler;
    private boolean mHasNotifyOpportunisticSubscriptionInfoChangedOccurred;
    private boolean mHasNotifySubscriptionInfoChangedOccurred;
    private List<ImsReasonInfo> mImsReasonInfo;
    private boolean[] mIsDataEnabled;
    private AtomicBoolean mIsSatelliteEnabled;
    private List<List<LinkCapacityEstimate>> mLinkCapacityEstimateLists;
    private final LocalLog mListenLog;
    private final LocalLog mLocalLog;
    private List<SparseArray<MediaQualityStatus>> mMediaQualityStatus;
    private boolean[] mMessageWaiting;
    private int mNumPhones;
    private EmergencyNumber[] mOutgoingCallEmergencyNumber;
    private EmergencyNumber[] mOutgoingSmsEmergencyNumber;
    private PhoneCapability mPhoneCapability;
    private List<List<PhysicalChannelConfig>> mPhysicalChannelConfigs;
    private final int mPid;
    private PreciseCallState[] mPreciseCallState;
    private List<Map<Pair<Integer, ApnSetting>, PreciseDataConnectionState>> mPreciseDataConnectionStates;
    private int mRadioPowerState;
    private final ArrayList<Record> mRecords;
    private final ArrayList<IBinder> mRemoveList;
    private int[] mRingingCallState;
    private long[] mSCBMDuration;
    private int[] mSCBMReason;
    private ServiceState[] mServiceState;
    private SignalStrength[] mSignalStrength;
    private int[] mSimultaneousCellularCallingSubIds;
    private int[] mSrvccState;
    private TelephonyDisplayInfo[] mTelephonyDisplayInfos;
    private boolean[] mUserMobileDataState;
    private int[] mVoiceActivationState;
    private AtomicBoolean mWasSatelliteEnabledNotified;

    /* JADX INFO: renamed from: com.android.server.TelephonyRegistry$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$android$telephony$LocationAccessPolicy$LocationPermissionResult = null;

        static {
            $SwitchMap$android$telephony$LocationAccessPolicy$LocationPermissionResult = new int[LocationAccessPolicy.LocationPermissionResult.values().length];
            $SwitchMap$android$telephony$LocationAccessPolicy$LocationPermissionResult[LocationAccessPolicy.LocationPermissionResult.DENIED_HARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L12:
            $SwitchMap$android$telephony$LocationAccessPolicy$LocationPermissionResult[LocationAccessPolicy.LocationPermissionResult.DENIED_SOFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            return;
        }
    }

    public static class ConfigurationProvider {
        /* JADX INFO: renamed from: $r8$lambda$C6OjoOM6QjWKuvRgmR-CDyixxwM, reason: not valid java name */
        public static /* synthetic */ Boolean m415$r8$lambda$C6OjoOM6QjWKuvRgmRCDyixxwM(String r0, UserHandle r1) {
            return lambda$isActiveDataSubIdReadPhoneStateEnforcedInPlatformCompat$3(r0, r1);
        }

        public static /* synthetic */ Integer $r8$lambda$fiLSZuDgZl0ukk9Pd8o7udet0Lc() {
            return lambda$getRegistrationLimit$0();
        }

        public static /* synthetic */ Boolean $r8$lambda$ghEnN30A5f91qZpQoxucquw7Y6I(String r0, UserHandle r1) {
            return lambda$isCellInfoReadPhoneStateEnforcedInPlatformCompat$4(r0, r1);
        }

        public static /* synthetic */ Boolean $r8$lambda$ia5Kj1BuRYcdkS9zbfBdAW8KTno(String r0, UserHandle r1) {
            return lambda$isCallStateReadPhoneStateEnforcedInPlatformCompat$2(r0, r1);
        }

        public static /* synthetic */ Boolean $r8$lambda$l8nxyWNylxNGcREs5fzCI3bratg(int r0) {
            return lambda$isRegistrationLimitEnabledInPlatformCompat$1(r0);
        }

        public static /* synthetic */ Boolean $r8$lambda$nI8f59IzWwA0Bc98ojailHfr9cI(String r0, UserHandle r1) {
            return lambda$isDisplayInfoReadPhoneStateEnforcedInPlatformCompat$5(r0, r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$tY0c-UBRwSdOIzZSZtsV8n9UhzY, reason: not valid java name */
        public static /* synthetic */ Boolean m416$r8$lambda$tY0cUBRwSdOIzZSZtsV8n9UhzY(String r0, UserHandle r1) {
            return lambda$isDisplayInfoNrAdvancedSupported$6(r0, r1);
        }

        public ConfigurationProvider() {
        }

        public int getRegistrationLimit() {
            return ((Integer) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda6())).intValue();
        }

        private static /* synthetic */ Integer lambda$getRegistrationLimit$0() throws Exception {
            return Integer.valueOf(DeviceConfig.getInt("telephony", "phone_state_listener_per_pid_registration_limit", 50));
        }

        private static /* synthetic */ Boolean lambda$isRegistrationLimitEnabledInPlatformCompat$1(int uid) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(150880553, uid));
        }

        public boolean isRegistrationLimitEnabledInPlatformCompat(final int uid) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda1(uid))).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$isCallStateReadPhoneStateEnforcedInPlatformCompat$2(String packageName, UserHandle userHandle) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(157233955, packageName, userHandle));
        }

        public boolean isCallStateReadPhoneStateEnforcedInPlatformCompat(final String packageName, final UserHandle userHandle) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda3(packageName, userHandle))).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$isActiveDataSubIdReadPhoneStateEnforcedInPlatformCompat$3(String packageName, UserHandle userHandle) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(TelephonyRegistry.REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_ACTIVE_DATA_SUB_ID, packageName, userHandle));
        }

        public boolean isActiveDataSubIdReadPhoneStateEnforcedInPlatformCompat(final String packageName, final UserHandle userHandle) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda0(packageName, userHandle))).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$isCellInfoReadPhoneStateEnforcedInPlatformCompat$4(String packageName, UserHandle userHandle) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(TelephonyRegistry.REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_CELL_INFO, packageName, userHandle));
        }

        public boolean isCellInfoReadPhoneStateEnforcedInPlatformCompat(final String packageName, final UserHandle userHandle) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda4(packageName, userHandle))).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$isDisplayInfoReadPhoneStateEnforcedInPlatformCompat$5(String packageName, UserHandle userHandle) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(TelephonyRegistry.REQUIRE_READ_PHONE_STATE_PERMISSION_FOR_DISPLAY_INFO, packageName, userHandle));
        }

        public boolean isDisplayInfoReadPhoneStateEnforcedInPlatformCompat(final String packageName, final UserHandle userHandle) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda5(packageName, userHandle))).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$isDisplayInfoNrAdvancedSupported$6(String packageName, UserHandle userHandle) throws Exception {
            return Boolean.valueOf(CompatChanges.isChangeEnabled(TelephonyRegistry.DISPLAY_INFO_NR_ADVANCED_SUPPORTED, packageName, userHandle));
        }

        public boolean isDisplayInfoNrAdvancedSupported(final String packageName, final UserHandle userHandle) {
            return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$ConfigurationProvider$$ExternalSyntheticLambda2(packageName, userHandle))).booleanValue();
        }
    }

    private static class Record {
        IBinder binder;
        IPhoneStateListener callback;
        int callerPid;
        int callerUid;
        String callingFeatureId;
        String callingPackage;
        ICarrierConfigChangeListener carrierConfigChangeListener;
        ICarrierPrivilegesCallback carrierPrivilegesCallback;
        Context context;
        TelephonyRegistryDeathRecipient deathRecipient;
        Set<Integer> eventList;
        IOnSubscriptionsChangedListener onOpportunisticSubscriptionsChangedListenerCallback;
        IOnSubscriptionsChangedListener onSubscriptionsChangedListenerCallback;
        int phoneId;
        boolean renounceCoarseLocationAccess;
        boolean renounceFineLocationAccess;
        ISatelliteStateChangeListener satelliteStateChangeListener;
        int subId;

        /* synthetic */ Record(TelephonyRegistryIA r1) {
            this();
        }

        private Record() {
            this.subId = -1;
            this.phoneId = -1;
        }

        boolean matchTelephonyCallbackEvent(int event) {
            if (this.callback != null) goto L5;
        L7:
            return false;
        L5:
            if (this.eventList.contains(Integer.valueOf(event)) == false) goto L7;
            return true;
        }

        boolean matchOnSubscriptionsChangedListener() {
            if (this.onSubscriptionsChangedListenerCallback == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean matchOnOpportunisticSubscriptionsChangedListener() {
            if (this.onOpportunisticSubscriptionsChangedListenerCallback == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean matchCarrierPrivilegesCallback() {
            if (this.carrierPrivilegesCallback == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean matchCarrierConfigChangeListener() {
            if (this.carrierConfigChangeListener == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean matchSatelliteStateChangeListener() {
            if (this.satelliteStateChangeListener == null) goto L5;
            return true;
        L5:
            return false;
        }

        boolean canReadCallLog() {
            return TelephonyPermissions.checkReadCallLog(this.context, this.subId, this.callerPid, this.callerUid, this.callingPackage, this.callingFeatureId);
        L5:
            return false;
        }

        public String toString() {
            return "{callingPackage=" + TelephonyRegistry.m414$$Nest$smpii(this.callingPackage) + " callerUid=" + this.callerUid + " binder=" + this.binder + " callback=" + this.callback + " onSubscriptionsChangedListenererCallback=" + this.onSubscriptionsChangedListenerCallback + " onOpportunisticSubscriptionsChangedListenererCallback=" + this.onOpportunisticSubscriptionsChangedListenerCallback + " carrierPrivilegesCallback=" + this.carrierPrivilegesCallback + " carrierConfigChangeListener=" + this.carrierConfigChangeListener + " satelliteStateChangeListener=" + this.satelliteStateChangeListener + " subId=" + this.subId + " phoneId=" + this.phoneId + " events=" + this.eventList + "}";
        }
    }

    private class TelephonyRegistryDeathRecipient implements IBinder.DeathRecipient {
        private final IBinder binder;
        final /* synthetic */ TelephonyRegistry this$0;

        TelephonyRegistryDeathRecipient(TelephonyRegistry r1, IBinder binder) {
            this.this$0 = r1;
            this.binder = binder;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            TelephonyRegistry.m412$$Nest$mremove(this.this$0, this.binder);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$3UMmd1mMMJsuVDLHZhqGF3imArs(TelephonyRegistry r0, int r1) {
        return r0.lambda$notifyCarrierNetworkChange$0(r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$4bvuP5Bs7ZKNwT6ScH4S4unvn9I(TelephonyRegistry r0, LocationAccessPolicy.LocationPermissionQuery r1) {
        return r0.lambda$checkCoarseLocationAccess$3(r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$FMzo0RXtfIG5vCO6h7DAMTZmjpQ(TelephonyRegistry r0, LocationAccessPolicy.LocationPermissionQuery r1) {
        return r0.lambda$checkFineLocationAccess$2(r1);
    }

    public static /* synthetic */ String[] $r8$lambda$HpXJgx8CyWpN0VDoFM2cg_0XpI8(TelephonyRegistry r0) {
        return r0.lambda$broadcastServiceStateChanged$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCellIdentity, reason: not valid java name */
    static /* bridge */ /* synthetic */ CellIdentity[] m398$$Nest$fgetmCellIdentity(TelephonyRegistry r0) {
        return r0.mCellIdentity;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultPhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m399$$Nest$fgetmDefaultPhoneId(TelephonyRegistry r0) {
        return r0.mDefaultPhoneId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m400$$Nest$fgetmDefaultSubId(TelephonyRegistry r0) {
        return r0.mDefaultSubId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m401$$Nest$fgetmHandler(TelephonyRegistry r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalLog m402$$Nest$fgetmLocalLog(TelephonyRegistry r0) {
        return r0.mLocalLog;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m403$$Nest$fgetmRecords(TelephonyRegistry r0) {
        return r0.mRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDefaultPhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m404$$Nest$fputmDefaultPhoneId(TelephonyRegistry r0, int r1) {
        r0.mDefaultPhoneId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDefaultSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m405$$Nest$fputmDefaultSubId(TelephonyRegistry r0, int r1) {
        r0.mDefaultSubId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckPossibleMissNotify, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m406$$Nest$mcheckPossibleMissNotify(TelephonyRegistry r0, Record r1, int r2) {
        r0.checkPossibleMissNotify(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPhoneIdFromSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m407$$Nest$mgetPhoneIdFromSubId(TelephonyRegistry r0, int r1) {
        return r0.getPhoneIdFromSubId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m408$$Nest$mgetTelephonyManager(TelephonyRegistry r0) {
        return r0.getTelephonyManager();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleRemoveListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m409$$Nest$mhandleRemoveListLocked(TelephonyRegistry r0) {
        r0.handleRemoveListLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCellLocationForSubscriber, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m410$$Nest$mnotifyCellLocationForSubscriber(TelephonyRegistry r0, int r1, CellIdentity r2, boolean r3) {
        r0.notifyCellLocationForSubscriber(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monMultiSimConfigChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m411$$Nest$monMultiSimConfigChanged(TelephonyRegistry r0) {
        r0.onMultiSimConfigChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$mremove, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m412$$Nest$mremove(TelephonyRegistry r0, IBinder r1) {
        r0.remove(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mvalidatePhoneId, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m413$$Nest$mvalidatePhoneId(TelephonyRegistry r0, int r1) {
        return r0.validatePhoneId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smpii, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m414$$Nest$smpii(String r0) {
        return pii(r0);
    }

    static {
        INVALID_LCE_LIST = new ArrayList(Arrays.asList(new LinkCapacityEstimate[]{new LinkCapacityEstimate(2, -1, -1)}));
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION = new HashSet();
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(13);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(14);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(12);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(26);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(27);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(28);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(31);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(32);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(33);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(34);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(37);
        REQUIRE_PRECISE_PHONE_STATE_PERMISSION.add(39);
    }

    private boolean isLocationPermissionRequired(Set<Integer> events) {
        if (events.contains(5) == false) goto L5;
    L8:
        return true;
    L5:
        if (events.contains(11) == true) goto L8;
        return false;
    }

    private boolean isPhoneStatePermissionRequired(Set<Integer> events, String callingPackage, UserHandle userHandle) {
        if (events.contains(4) == false) goto L5;
    L33:
        return true;
    L5:
        if (events.contains(3) == true) goto L33;
        if (events.contains(25) == true) goto L33;
        if (events.contains(36) == true) goto L14;
        if (events.contains(6) == true) goto L14;
    L17:
        if (events.contains(23) == false) goto L22;
        if (this.mConfigurationProvider.isActiveDataSubIdReadPhoneStateEnforcedInPlatformCompat(callingPackage, userHandle) == false) goto L22;
        return true;
    L22:
        if (events.contains(11) == false) goto L27;
        if (this.mConfigurationProvider.isCellInfoReadPhoneStateEnforcedInPlatformCompat(callingPackage, userHandle) == false) goto L27;
        return true;
    L27:
        if (events.contains(21) == true) goto L29;
        return false;
    L29:
        if (this.mConfigurationProvider.isDisplayInfoReadPhoneStateEnforcedInPlatformCompat(callingPackage, userHandle) == true) goto L34;
        return true;
    L34:
        return false;
    L14:
        if (this.mConfigurationProvider.isCallStateReadPhoneStateEnforcedInPlatformCompat(callingPackage, userHandle) == false) goto L17;
        return true;
    }

    private boolean isPrecisePhoneStatePermissionRequired(Set<Integer> events) {
        Iterator<Integer> r0 = REQUIRE_PRECISE_PHONE_STATE_PERMISSION.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Integer requireEvent = r0.next();
        if (events.contains(requireEvent) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private boolean isActiveEmergencySessionPermissionRequired(Set<Integer> events) {
        if (events.contains(29) == false) goto L5;
    L8:
        return true;
    L5:
        if (events.contains(30) == true) goto L8;
        return false;
    }

    private boolean isPrivilegedPhoneStatePermissionRequired(Set<Integer> events) {
        if (events.contains(16) == false) goto L5;
    L20:
        return true;
    L5:
        if (events.contains(18) == true) goto L20;
        if (events.contains(24) == true) goto L20;
        if (events.contains(35) == true) goto L20;
        if (events.contains(40) == true) goto L20;
        if (events.contains(41) == true) goto L20;
        if (events.contains(47) == true) goto L20;
        if (events.contains(46) == true) goto L20;
        return false;
    }

    private TelephonyManager getTelephonyManager() {
        return (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
    }

    private void onMultiSimConfigChanged() {
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int oldNumPhones = this.mNumPhones;     // Catch: Throwable -> L8
        this.mNumPhones = getTelephonyManager().getActiveModemCount();     // Catch: Throwable -> L8
        if (oldNumPhones != this.mNumPhones) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mCallState = Arrays.copyOf(this.mCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mDataActivity = Arrays.copyOf(this.mCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mDataConnectionState = Arrays.copyOf(this.mCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mDataConnectionNetworkType = Arrays.copyOf(this.mCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallIncomingNumber = (String[]) Arrays.copyOf(this.mCallIncomingNumber, this.mNumPhones);     // Catch: Throwable -> L8
        this.mServiceState = (ServiceState[]) Arrays.copyOf(this.mServiceState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mVoiceActivationState = Arrays.copyOf(this.mVoiceActivationState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mDataActivationState = Arrays.copyOf(this.mDataActivationState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mUserMobileDataState = Arrays.copyOf(this.mUserMobileDataState, this.mNumPhones);     // Catch: Throwable -> L8
        if (this.mSignalStrength == null) goto L13;
        this.mSignalStrength = (SignalStrength[]) Arrays.copyOf(this.mSignalStrength, this.mNumPhones);     // Catch: Throwable -> L8
    L14:
        this.mMessageWaiting = Arrays.copyOf(this.mMessageWaiting, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallForwarding = Arrays.copyOf(this.mCallForwarding, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCellIdentity = (CellIdentity[]) Arrays.copyOf(this.mCellIdentity, this.mNumPhones);     // Catch: Throwable -> L8
        this.mSrvccState = Arrays.copyOf(this.mSrvccState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mPreciseCallState = (PreciseCallState[]) Arrays.copyOf(this.mPreciseCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mForegroundCallState = Arrays.copyOf(this.mForegroundCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mBackgroundCallState = Arrays.copyOf(this.mBackgroundCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mRingingCallState = Arrays.copyOf(this.mRingingCallState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallDisconnectCause = Arrays.copyOf(this.mCallDisconnectCause, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallPreciseDisconnectCause = Arrays.copyOf(this.mCallPreciseDisconnectCause, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallQuality = (CallQuality[]) Arrays.copyOf(this.mCallQuality, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCallNetworkType = Arrays.copyOf(this.mCallNetworkType, this.mNumPhones);     // Catch: Throwable -> L8
        this.mOutgoingCallEmergencyNumber = (EmergencyNumber[]) Arrays.copyOf(this.mOutgoingCallEmergencyNumber, this.mNumPhones);     // Catch: Throwable -> L8
        this.mOutgoingSmsEmergencyNumber = (EmergencyNumber[]) Arrays.copyOf(this.mOutgoingSmsEmergencyNumber, this.mNumPhones);     // Catch: Throwable -> L8
        this.mTelephonyDisplayInfos = (TelephonyDisplayInfo[]) Arrays.copyOf(this.mTelephonyDisplayInfos, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCarrierNetworkChangeState = Arrays.copyOf(this.mCarrierNetworkChangeState, this.mNumPhones);     // Catch: Throwable -> L8
        this.mIsDataEnabled = Arrays.copyOf(this.mIsDataEnabled, this.mNumPhones);     // Catch: Throwable -> L8
        this.mDataEnabledReason = Arrays.copyOf(this.mDataEnabledReason, this.mNumPhones);     // Catch: Throwable -> L8
        this.mAllowedNetworkTypeReason = Arrays.copyOf(this.mAllowedNetworkTypeReason, this.mNumPhones);     // Catch: Throwable -> L8
        this.mAllowedNetworkTypeValue = Arrays.copyOf(this.mAllowedNetworkTypeValue, this.mNumPhones);     // Catch: Throwable -> L8
        this.mECBMReason = Arrays.copyOf(this.mECBMReason, this.mNumPhones);     // Catch: Throwable -> L8
        this.mECBMDuration = Arrays.copyOf(this.mECBMDuration, this.mNumPhones);     // Catch: Throwable -> L8
        this.mSCBMReason = Arrays.copyOf(this.mSCBMReason, this.mNumPhones);     // Catch: Throwable -> L8
        this.mSCBMDuration = Arrays.copyOf(this.mSCBMDuration, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnMode = Arrays.copyOf(this.mCarrierRoamingNtnMode, this.mNumPhones);     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnEligible = Arrays.copyOf(this.mCarrierRoamingNtnEligible, this.mNumPhones);     // Catch: Throwable -> L8
        if (this.mCarrierRoamingNtnSignalStrength == null) goto L17;
        this.mCarrierRoamingNtnSignalStrength = (NtnSignalStrength[]) Arrays.copyOf(this.mCarrierRoamingNtnSignalStrength, this.mNumPhones);     // Catch: Throwable -> L8
    L19:
        if (this.mNumPhones >= oldNumPhones) goto L23;
        cutListToSize(this.mCellInfo, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mImsReasonInfo, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mPreciseDataConnectionStates, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mBarringInfo, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mPhysicalChannelConfigs, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mLinkCapacityEstimateLists, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mCarrierPrivilegeStates, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mCarrierServiceStates, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mCallStateLists, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mMediaQualityStatus, this.mNumPhones);     // Catch: Throwable -> L8
        cutListToSize(this.mCarrierRoamingNtnAvailableServices, this.mNumPhones);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L23:
        int i = oldNumPhones;
    L25:
        if (i >= this.mNumPhones) goto L28;
        this.mCallState[i] = 0;     // Catch: Throwable -> L8
        this.mDataActivity[i] = 0;     // Catch: Throwable -> L8
        this.mDataConnectionState[i] = -1;     // Catch: Throwable -> L8
        this.mVoiceActivationState[i] = 0;     // Catch: Throwable -> L8
        this.mDataActivationState[i] = 0;     // Catch: Throwable -> L8
        this.mCallIncomingNumber[i] = "";     // Catch: Throwable -> L8
        this.mServiceState[i] = new ServiceState();     // Catch: Throwable -> L8
        this.mSignalStrength[i] = null;     // Catch: Throwable -> L8
        this.mUserMobileDataState[i] = false;     // Catch: Throwable -> L8
        this.mMessageWaiting[i] = false;     // Catch: Throwable -> L8
        this.mCallForwarding[i] = false;     // Catch: Throwable -> L8
        this.mCellIdentity[i] = null;     // Catch: Throwable -> L8
        this.mCellInfo.add(i, Collections.EMPTY_LIST);     // Catch: Throwable -> L8
        this.mImsReasonInfo.add(i, null);     // Catch: Throwable -> L8
        this.mSrvccState[i] = -1;     // Catch: Throwable -> L8
        this.mCallDisconnectCause[i] = -1;     // Catch: Throwable -> L8
        this.mCallPreciseDisconnectCause[i] = -1;     // Catch: Throwable -> L8
        this.mCallQuality[i] = createCallQuality();     // Catch: Throwable -> L8
        this.mMediaQualityStatus.add(i, new SparseArray());     // Catch: Throwable -> L8
        this.mCallStateLists.add(i, new ArrayList());     // Catch: Throwable -> L8
        this.mCallNetworkType[i] = 0;     // Catch: Throwable -> L8
        this.mPreciseCallState[i] = createPreciseCallState();     // Catch: Throwable -> L8
        this.mRingingCallState[i] = 0;     // Catch: Throwable -> L8
        this.mForegroundCallState[i] = 0;     // Catch: Throwable -> L8
        this.mBackgroundCallState[i] = 0;     // Catch: Throwable -> L8
        this.mPreciseDataConnectionStates.add(new ArrayMap());     // Catch: Throwable -> L8
        this.mBarringInfo.add(i, new BarringInfo());     // Catch: Throwable -> L8
        this.mCarrierNetworkChangeState[i] = false;     // Catch: Throwable -> L8
        this.mTelephonyDisplayInfos[i] = null;     // Catch: Throwable -> L8
        this.mIsDataEnabled[i] = false;     // Catch: Throwable -> L8
        this.mDataEnabledReason[i] = 0;     // Catch: Throwable -> L8
        this.mPhysicalChannelConfigs.add(i, new ArrayList());     // Catch: Throwable -> L8
        this.mAllowedNetworkTypeReason[i] = -1;     // Catch: Throwable -> L8
        this.mAllowedNetworkTypeValue[i] = -1;     // Catch: Throwable -> L8
        this.mLinkCapacityEstimateLists.add(i, INVALID_LCE_LIST);     // Catch: Throwable -> L8
        this.mCarrierPrivilegeStates.add(i, new Pair(Collections.emptyList(), new int[0]));     // Catch: Throwable -> L8
        this.mCarrierServiceStates.add(i, new Pair(null, -1));     // Catch: Throwable -> L8
        this.mECBMReason[i] = 0;     // Catch: Throwable -> L8
        this.mECBMDuration[i] = 0;     // Catch: Throwable -> L8
        this.mSCBMReason[i] = 0;     // Catch: Throwable -> L8
        this.mSCBMDuration[i] = 0;     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnMode[i] = false;     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnEligible[i] = false;     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnAvailableServices.add(i, new IntArray());     // Catch: Throwable -> L8
        this.mCarrierRoamingNtnSignalStrength[i] = new NtnSignalStrength(0);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L25
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        this.mCarrierRoamingNtnSignalStrength = new NtnSignalStrength[this.mNumPhones];     // Catch: Throwable -> L8
        goto L19
    L13:
        this.mSignalStrength = new SignalStrength[this.mNumPhones];     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void cutListToSize(List list, int size) {
        if (list != null) goto L5;
        return;
    L5:
        if (list.size() <= size) goto L7;
        list.remove(list.size() - 1);
        goto L5
    }

    public TelephonyRegistry(Context context, ConfigurationProvider configurationProvider) {
        this.mRemoveList = new ArrayList();
        this.mRecords = new ArrayList();
        this.mHasNotifySubscriptionInfoChangedOccurred = false;
        this.mHasNotifyOpportunisticSubscriptionInfoChangedOccurred = false;
        this.mDefaultSubId = -1;
        this.mDefaultPhoneId = -1;
        this.mImsReasonInfo = null;
        this.mBarringInfo = null;
        this.mCarrierNetworkChangeState = null;
        this.mPhoneCapability = null;
        this.mActiveDataSubId = -1;
        this.mRadioPowerState = 2;
        this.mLocalLog = new LocalLog(200);
        this.mListenLog = new LocalLog(200);
        this.mSimultaneousCellularCallingSubIds = new int[0];
        this.mCarrierRoamingNtnMode = null;
        this.mCarrierRoamingNtnEligible = null;
        this.mPid = Process.myPid();
        this.mHandler = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mConfigurationProvider = configurationProvider;
        this.mBatteryStats = BatteryStatsService.getService();
        int numPhones = getTelephonyManager().getActiveModemCount();
        this.mNumPhones = numPhones;
        this.mCallState = new int[numPhones];
        this.mDataActivity = new int[numPhones];
        this.mDataConnectionState = new int[numPhones];
        this.mDataConnectionNetworkType = new int[numPhones];
        this.mCallIncomingNumber = new String[numPhones];
        this.mServiceState = new ServiceState[numPhones];
        this.mVoiceActivationState = new int[numPhones];
        this.mDataActivationState = new int[numPhones];
        this.mUserMobileDataState = new boolean[numPhones];
        this.mSignalStrength = new SignalStrength[numPhones];
        this.mMessageWaiting = new boolean[numPhones];
        this.mCallForwarding = new boolean[numPhones];
        this.mCellIdentity = new CellIdentity[numPhones];
        this.mSrvccState = new int[numPhones];
        this.mPreciseCallState = new PreciseCallState[numPhones];
        this.mForegroundCallState = new int[numPhones];
        this.mBackgroundCallState = new int[numPhones];
        this.mRingingCallState = new int[numPhones];
        this.mCallDisconnectCause = new int[numPhones];
        this.mCallPreciseDisconnectCause = new int[numPhones];
        this.mCallQuality = new CallQuality[numPhones];
        this.mMediaQualityStatus = new ArrayList();
        this.mCallNetworkType = new int[numPhones];
        this.mCallStateLists = new ArrayList();
        this.mPreciseDataConnectionStates = new ArrayList();
        this.mCellInfo = new ArrayList(numPhones);
        this.mImsReasonInfo = new ArrayList();
        this.mEmergencyNumberList = new HashMap();
        this.mOutgoingCallEmergencyNumber = new EmergencyNumber[numPhones];
        this.mOutgoingSmsEmergencyNumber = new EmergencyNumber[numPhones];
        this.mBarringInfo = new ArrayList();
        this.mCarrierNetworkChangeState = new boolean[numPhones];
        this.mTelephonyDisplayInfos = new TelephonyDisplayInfo[numPhones];
        this.mPhysicalChannelConfigs = new ArrayList();
        this.mAllowedNetworkTypeReason = new int[numPhones];
        this.mAllowedNetworkTypeValue = new long[numPhones];
        this.mIsDataEnabled = new boolean[numPhones];
        this.mDataEnabledReason = new int[numPhones];
        this.mLinkCapacityEstimateLists = new ArrayList();
        this.mCarrierPrivilegeStates = new ArrayList();
        this.mCarrierServiceStates = new ArrayList();
        this.mECBMReason = new int[numPhones];
        this.mECBMDuration = new long[numPhones];
        this.mSCBMReason = new int[numPhones];
        this.mSCBMDuration = new long[numPhones];
        this.mCarrierRoamingNtnMode = new boolean[numPhones];
        this.mCarrierRoamingNtnEligible = new boolean[numPhones];
        this.mCarrierRoamingNtnAvailableServices = new ArrayList();
        this.mCarrierRoamingNtnSignalStrength = new NtnSignalStrength[numPhones];
        this.mIsSatelliteEnabled = new AtomicBoolean();
        this.mWasSatelliteEnabledNotified = new AtomicBoolean();
        int i = 0;
    L3:
        if (i >= numPhones) goto L5;
        this.mCallState[i] = 0;
        this.mDataActivity[i] = 0;
        this.mDataConnectionState[i] = -1;
        this.mVoiceActivationState[i] = 0;
        this.mDataActivationState[i] = 0;
        this.mCallIncomingNumber[i] = "";
        this.mServiceState[i] = new ServiceState();
        this.mSignalStrength[i] = null;
        this.mUserMobileDataState[i] = false;
        this.mMessageWaiting[i] = false;
        this.mCallForwarding[i] = false;
        this.mCellIdentity[i] = null;
        this.mCellInfo.add(i, Collections.EMPTY_LIST);
        this.mImsReasonInfo.add(i, new ImsReasonInfo());
        this.mSrvccState[i] = -1;
        this.mCallDisconnectCause[i] = -1;
        this.mCallPreciseDisconnectCause[i] = -1;
        this.mCallQuality[i] = createCallQuality();
        this.mMediaQualityStatus.add(i, new SparseArray());
        this.mCallStateLists.add(i, new ArrayList());
        this.mCallNetworkType[i] = 0;
        this.mPreciseCallState[i] = createPreciseCallState();
        this.mRingingCallState[i] = 0;
        this.mForegroundCallState[i] = 0;
        this.mBackgroundCallState[i] = 0;
        this.mPreciseDataConnectionStates.add(new ArrayMap());
        this.mBarringInfo.add(i, new BarringInfo());
        this.mCarrierNetworkChangeState[i] = false;
        this.mTelephonyDisplayInfos[i] = null;
        this.mIsDataEnabled[i] = false;
        this.mDataEnabledReason[i] = 0;
        this.mPhysicalChannelConfigs.add(i, new ArrayList());
        this.mAllowedNetworkTypeReason[i] = -1;
        this.mAllowedNetworkTypeValue[i] = -1;
        this.mLinkCapacityEstimateLists.add(i, INVALID_LCE_LIST);
        this.mCarrierPrivilegeStates.add(i, new Pair(Collections.emptyList(), new int[0]));
        this.mCarrierServiceStates.add(i, new Pair(null, -1));
        this.mECBMReason[i] = 0;
        this.mECBMDuration[i] = 0;
        this.mSCBMReason[i] = 0;
        this.mSCBMDuration[i] = 0;
        this.mCarrierRoamingNtnMode[i] = false;
        this.mCarrierRoamingNtnEligible[i] = false;
        this.mCarrierRoamingNtnAvailableServices.add(i, new IntArray());
        this.mCarrierRoamingNtnSignalStrength[i] = new NtnSignalStrength(0);
        i = i + 1;
        goto L3
    L5:
        this.mAppOps = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
    }

    public void systemRunning() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_SWITCHED");
        filter.addAction("android.intent.action.USER_REMOVED");
        filter.addAction("android.telephony.action.DEFAULT_SUBSCRIPTION_CHANGED");
        filter.addAction("android.telephony.action.MULTI_SIM_CONFIG_CHANGED");
        log("systemRunning register for intents");
        this.mContext.registerReceiver(this.mBroadcastReceiver, filter);
    }

    private boolean doesLimitApplyForListeners(int callingUid, int exemptUid) {
        if (TelephonyPermissions.isSystemOrPhone(callingUid) == true) goto L6;
        if (callingUid == exemptUid) goto L6;
        return true;
    L6:
        return false;
    }

    public void addOnSubscriptionsChangedListener(String callingPackage, String callingFeatureId, IOnSubscriptionsChangedListener callback) {
        UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        IBinder b = callback.asBinder();     // Catch: Throwable -> L8
        boolean doesLimitApply = doesLimitApplyForListeners(Binder.getCallingUid(), Process.myUid());     // Catch: Throwable -> L8
        Record r = add(b, Binder.getCallingUid(), Binder.getCallingPid(), doesLimitApply);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        r.context = this.mContext;     // Catch: Throwable -> L8
        r.onSubscriptionsChangedListenerCallback = callback;     // Catch: Throwable -> L8
        r.callingPackage = callingPackage;     // Catch: Throwable -> L8
        r.callingFeatureId = callingFeatureId;     // Catch: Throwable -> L8
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L8
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L8
        r.eventList = new ArraySet();     // Catch: Throwable -> L8
        if (this.mHasNotifySubscriptionInfoChangedOccurred == true) goto L22;
        log("listen oscl: mHasNotifySubscriptionInfoChangedOccurred==false no callback");     // Catch: Throwable -> L8
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L22:
        r.onSubscriptionsChangedListenerCallback.onSubscriptionsChanged();     // Catch: Throwable -> L8 RemoteException -> L14
    L15:
        remove(r.binder);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void removeOnSubscriptionsChangedListener(String pkgForDebug, IOnSubscriptionsChangedListener callback) {
        remove(callback.asBinder());
    }

    public void addOnOpportunisticSubscriptionsChangedListener(String callingPackage, String callingFeatureId, IOnSubscriptionsChangedListener callback) {
        UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        IBinder b = callback.asBinder();     // Catch: Throwable -> L8
        boolean doesLimitApply = doesLimitApplyForListeners(Binder.getCallingUid(), Process.myUid());     // Catch: Throwable -> L8
        Record r = add(b, Binder.getCallingUid(), Binder.getCallingPid(), doesLimitApply);     // Catch: Throwable -> L8
        if (r != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        r.context = this.mContext;     // Catch: Throwable -> L8
        r.onOpportunisticSubscriptionsChangedListenerCallback = callback;     // Catch: Throwable -> L8
        r.callingPackage = callingPackage;     // Catch: Throwable -> L8
        r.callingFeatureId = callingFeatureId;     // Catch: Throwable -> L8
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L8
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L8
        r.eventList = new ArraySet();     // Catch: Throwable -> L8
        if (this.mHasNotifyOpportunisticSubscriptionInfoChangedOccurred == true) goto L22;
        log("listen ooscl: hasNotifyOpptSubInfoChangedOccurred==false no callback");     // Catch: Throwable -> L8
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L22:
        r.onOpportunisticSubscriptionsChangedListenerCallback.onSubscriptionsChanged();     // Catch: Throwable -> L8 RemoteException -> L14
    L15:
        remove(r.binder);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void notifySubscriptionInfoChanged() {
        if (checkNotifyPermission("notifySubscriptionInfoChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mHasNotifySubscriptionInfoChangedOccurred == true) goto L12;
        log("notifySubscriptionInfoChanged: first invocation mRecords.size=" + this.mRecords.size());     // Catch: Throwable -> L10
    L12:
        this.mHasNotifySubscriptionInfoChangedOccurred = true;     // Catch: Throwable -> L10
        this.mRemoveList.clear();     // Catch: Throwable -> L10
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L10
    L14:
        if (r1.hasNext() == false) goto L22;
        Record r = r1.next();     // Catch: Throwable -> L10
        if (r.matchOnSubscriptionsChangedListener() == false) goto L14;
        r.onSubscriptionsChangedListenerCallback.onSubscriptionsChanged();     // Catch: Throwable -> L10 RemoteException -> L19
    L20:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L10
        goto L14
    L22:
        handleRemoveListLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void notifyOpportunisticSubscriptionInfoChanged() {
        if (checkNotifyPermission("notifyOpportunisticSubscriptionInfoChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.mHasNotifyOpportunisticSubscriptionInfoChangedOccurred == true) goto L12;
        log("notifyOpptSubscriptionInfoChanged: first invocation mRecords.size=" + this.mRecords.size());     // Catch: Throwable -> L10
    L12:
        this.mHasNotifyOpportunisticSubscriptionInfoChangedOccurred = true;     // Catch: Throwable -> L10
        this.mRemoveList.clear();     // Catch: Throwable -> L10
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L10
    L14:
        if (r1.hasNext() == false) goto L22;
        Record r = r1.next();     // Catch: Throwable -> L10
        if (r.matchOnOpportunisticSubscriptionsChangedListener() == false) goto L14;
        r.onOpportunisticSubscriptionsChangedListenerCallback.onSubscriptionsChanged();     // Catch: Throwable -> L10 RemoteException -> L19
    L20:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L10
        goto L14
    L22:
        handleRemoveListLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void listenWithEventList(boolean renounceFineLocationAccess, boolean renounceCoarseLocationAccess, int subId, String callingPackage, String callingFeatureId, IPhoneStateListener callback, int[] events, boolean notifyNow) {
        Set<Integer> eventList = (Set) Arrays.stream(events).boxed().collect(Collectors.toSet());
        listen(renounceFineLocationAccess, renounceCoarseLocationAccess, callingPackage, callingFeatureId, callback, eventList, notifyNow, subId);
    }

    private void listen(boolean renounceFineLocationAccess, boolean renounceCoarseLocationAccess, String callingPackage, String callingFeatureId, IPhoneStateListener callback, Set<Integer> events, boolean notifyNow, int subId) {
        int callerUserId = UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        String str = "listen: E pkg=" + pii(callingPackage) + " uid=" + Binder.getCallingUid() + " events=" + events + " notifyNow=" + notifyNow + " subId=" + subId + " myUserId=" + UserHandle.myUserId() + " callerUserId=" + callerUserId;
        this.mListenLog.log(str);
        if (events.isEmpty() == false) goto L7;
        events.clear();
        remove(callback.asBinder());
        return;
    L7:
        if (checkListenerPermission(events, subId, callingPackage, callingFeatureId, "listen") == true) goto L10;
        return;
    L10:
        if (SubscriptionManager.isValidSubscriptionId(subId) == true) goto L12;
        int subscriptionId = Integer.MAX_VALUE;
    L13:
        int phoneId = getPhoneIdFromSubId(subscriptionId);
        ArrayList<Record> r6 = this.mRecords;
        monitor-enter(r6);
        IBinder b = callback.asBinder();     // Catch: Throwable -> L397
        boolean doesLimitApply = doesLimitApplyForListeners(Binder.getCallingUid(), Process.myUid());     // Catch: Throwable -> L397
        Record r = add(b, Binder.getCallingUid(), Binder.getCallingPid(), doesLimitApply);     // Catch: Throwable -> L397
        if (r == null) goto L423;
        r.context = this.mContext;     // Catch: Throwable -> L397
        r.callback = callback;     // Catch: Throwable -> L395
        r.callingPackage = callingPackage;     // Catch: Throwable -> L395
        r.callingFeatureId = callingFeatureId;     // Catch: Throwable -> L393
        r.renounceCoarseLocationAccess = renounceCoarseLocationAccess;     // Catch: Throwable -> L389
        r.renounceFineLocationAccess = renounceFineLocationAccess;     // Catch: Throwable -> L389
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L389
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L389
        r.subId = subscriptionId;     // Catch: Throwable -> L389
        r.phoneId = phoneId;     // Catch: Throwable -> L389
        r.eventList = events;     // Catch: Throwable -> L389
        if (notifyNow == false) goto L391;
        if (validatePhoneId(r.phoneId) == false) goto L391;
    L56:
        th = th;
    L399:
        monitor-exit(r6);     // Catch: Throwable -> L52
        throw th;
    L34:
        if (events.contains(1) == false) goto L64;
        ServiceState rawSs = new ServiceState(this.mServiceState[r.phoneId]);     // Catch: Throwable -> L56 RemoteException -> L58
        if (checkFineLocationAccess(r, 29) == false) goto L45;
        r.callback.onServiceStateChanged(rawSs);     // Catch: Throwable -> L39 RemoteException -> L41
    L491:
        goto L61
    L45:
        if (checkCoarseLocationAccess(r, 29) == false) goto L48;
        r.callback.onServiceStateChanged(rawSs.createLocationInfoSanitizedCopy(false));     // Catch: Throwable -> L39 RemoteException -> L41
        goto L491
    L48:
        goto L61
    L450:
        r.callback.onServiceStateChanged(rawSs.createLocationInfoSanitizedCopy(true));     // Catch: Throwable -> L52 RemoteException -> L54
    L39:
        th = th;
    L61:
        remove(r.binder);     // Catch: Throwable -> L52
    L64:
        if (events.contains(2) == false) goto L79;
        if (this.mSignalStrength[r.phoneId] == null) goto L79;
        int gsmSignalStrength = this.mSignalStrength[r.phoneId].getGsmSignalStrength();     // Catch: Throwable -> L52 RemoteException -> L73
        IPhoneStateListener r4 = r.callback;     // Catch: Throwable -> L52 RemoteException -> L73
        if (gsmSignalStrength != 99) goto L70;
        int r5 = -1;
    L71:
        r4.onSignalStrengthChanged(r5);     // Catch: Throwable -> L52 RemoteException -> L73
        goto L77
    L70:
        r5 = gsmSignalStrength;
    L77:
        remove(r.binder);     // Catch: Throwable -> L52
    L79:
        if (events.contains(3) == false) goto L85;
        r.callback.onMessageWaitingIndicatorChanged(this.mMessageWaiting[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L82
    L83:
        remove(r.binder);     // Catch: Throwable -> L52
    L85:
        if (events.contains(4) == false) goto L91;
        r.callback.onCallForwardingIndicatorChanged(this.mCallForwarding[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L88
    L89:
        remove(r.binder);     // Catch: Throwable -> L52
    L91:
        if (validateEventAndUserLocked(r, 5) == false) goto L105;
        if (checkCoarseLocationAccess(r, 1) == false) goto L105;
        if (checkFineLocationAccess(r, 29) == false) goto L105;
        r.callback.onCellLocationChanged(this.mCellIdentity[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L99
    L103:
        remove(r.binder);     // Catch: Throwable -> L52
    L105:
        if (events.contains(36) == false) goto L111;
        r.callback.onLegacyCallStateChanged(this.mCallState[r.phoneId], getCallIncomingNumber(r, r.phoneId));     // Catch: Throwable -> L52 RemoteException -> L108
    L109:
        remove(r.binder);     // Catch: Throwable -> L52
    L111:
        if (events.contains(6) == false) goto L117;
        r.callback.onCallStateChanged(this.mCallState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L114
    L115:
        remove(r.binder);     // Catch: Throwable -> L52
    L117:
        if (events.contains(7) == false) goto L123;
        r.callback.onDataConnectionStateChanged(this.mDataConnectionState[r.phoneId], this.mDataConnectionNetworkType[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L120
    L121:
        remove(r.binder);     // Catch: Throwable -> L52
    L123:
        if (events.contains(8) == false) goto L129;
        r.callback.onDataActivity(this.mDataActivity[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L126
    L127:
        remove(r.binder);     // Catch: Throwable -> L52
    L129:
        if (events.contains(9) == false) goto L140;
        if (this.mSignalStrength[r.phoneId] == null) goto L140;
        r.callback.onSignalStrengthsChanged(this.mSignalStrength[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L134
    L138:
        remove(r.binder);     // Catch: Throwable -> L52
    L140:
        if (validateEventAndUserLocked(r, 11) == false) goto L154;
        if (checkCoarseLocationAccess(r, 1) == false) goto L154;
        if (checkFineLocationAccess(r, 29) == false) goto L154;
        r.callback.onCellInfoChanged(this.mCellInfo.get(r.phoneId));     // Catch: Throwable -> L52 RemoteException -> L148
    L152:
        remove(r.binder);     // Catch: Throwable -> L52
    L154:
        if (events.contains(12) == false) goto L160;
        r.callback.onPreciseCallStateChanged(this.mPreciseCallState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L157
    L158:
        remove(r.binder);     // Catch: Throwable -> L52
    L160:
        if (events.contains(26) == false) goto L166;
        r.callback.onCallDisconnectCauseChanged(this.mCallDisconnectCause[r.phoneId], this.mCallPreciseDisconnectCause[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L163
    L164:
        remove(r.binder);     // Catch: Throwable -> L52
    L166:
        if (events.contains(28) == false) goto L175;
        ImsReasonInfo imsReasonInfo = this.mImsReasonInfo.get(r.phoneId);     // Catch: Throwable -> L52
        if (imsReasonInfo == null) goto L175;
        r.callback.onImsCallDisconnectCauseChanged(imsReasonInfo);     // Catch: Throwable -> L52 RemoteException -> L172
    L173:
        remove(r.binder);     // Catch: Throwable -> L52
    L175:
        if (events.contains(13) == false) goto L187;
        Iterator<PreciseDataConnectionState> r0 = this.mPreciseDataConnectionStates.get(r.phoneId).values().iterator();     // Catch: Throwable -> L52 RemoteException -> L181
    L178:
        if (r0.hasNext() == false) goto L187;
        PreciseDataConnectionState pdcs = r0.next();     // Catch: Throwable -> L52 RemoteException -> L181
        r.callback.onPreciseDataConnectionStateChanged(pdcs);     // Catch: Throwable -> L52 RemoteException -> L181
    L185:
        remove(r.binder);     // Catch: Throwable -> L52
    L187:
        if (events.contains(17) == false) goto L193;
        r.callback.onCarrierNetworkChange(this.mCarrierNetworkChangeState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L190
    L191:
        remove(r.binder);     // Catch: Throwable -> L52
    L193:
        if (events.contains(18) == false) goto L199;
        r.callback.onVoiceActivationStateChanged(this.mVoiceActivationState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L196
    L197:
        remove(r.binder);     // Catch: Throwable -> L52
    L199:
        if (events.contains(19) == false) goto L205;
        r.callback.onDataActivationStateChanged(this.mDataActivationState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L202
    L203:
        remove(r.binder);     // Catch: Throwable -> L52
    L205:
        if (events.contains(20) == false) goto L211;
        r.callback.onUserMobileDataStateChanged(this.mUserMobileDataState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L208
    L209:
        remove(r.binder);     // Catch: Throwable -> L52
    L211:
        if (events.contains(21) == false) goto L222;
        if (this.mTelephonyDisplayInfos[r.phoneId] == null) goto L222;
        r.callback.onDisplayInfoChanged(this.mTelephonyDisplayInfos[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L216
    L220:
        remove(r.binder);     // Catch: Throwable -> L52
    L222:
        if (events.contains(25) == false) goto L228;
        r.callback.onEmergencyNumberListChanged(this.mEmergencyNumberList);     // Catch: Throwable -> L52 RemoteException -> L225
    L226:
        remove(r.binder);     // Catch: Throwable -> L52
    L228:
        if (events.contains(22) == false) goto L234;
        r.callback.onPhoneCapabilityChanged(this.mPhoneCapability);     // Catch: Throwable -> L52 RemoteException -> L231
    L232:
        remove(r.binder);     // Catch: Throwable -> L52
    L234:
        if (events.contains(23) == false) goto L240;
        r.callback.onActiveDataSubIdChanged(this.mActiveDataSubId);     // Catch: Throwable -> L52 RemoteException -> L237
    L238:
        remove(r.binder);     // Catch: Throwable -> L52
    L240:
        if (events.contains(24) == false) goto L246;
        r.callback.onRadioPowerStateChanged(this.mRadioPowerState);     // Catch: Throwable -> L52 RemoteException -> L243
    L244:
        remove(r.binder);     // Catch: Throwable -> L52
    L246:
        if (events.contains(16) == false) goto L252;
        r.callback.onSrvccStateChanged(this.mSrvccState[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L249
    L250:
        remove(r.binder);     // Catch: Throwable -> L52
    L252:
        if (events.contains(27) == false) goto L264;
        if (r.callerPid != this.mPid) goto L258;
        List<CallState> callList = List.copyOf(this.mCallStateLists.get(r.phoneId));     // Catch: Throwable -> L52 RemoteException -> L256
    L259:
        r.callback.onCallStatesChanged(callList);     // Catch: Throwable -> L52 RemoteException -> L256
        goto L262
    L258:
        callList = this.mCallStateLists.get(r.phoneId);     // Catch: Throwable -> L52 RemoteException -> L256
    L262:
        remove(r.binder);     // Catch: Throwable -> L52
    L264:
        if (events.contains(32) == false) goto L278;
        BarringInfo barringInfo = this.mBarringInfo.get(r.phoneId);     // Catch: Throwable -> L52
        if (barringInfo == null) goto L278;
        BarringInfo biNoLocation = barringInfo.createLocationInfoSanitizedCopy();     // Catch: Throwable -> L52
        IPhoneStateListener r1 = r.callback;     // Catch: Throwable -> L52 RemoteException -> L275
        if (checkFineLocationAccess(r, 1) == false) goto L272;
        BarringInfo r7 = barringInfo;
    L273:
        r1.onBarringInfoChanged(r7);     // Catch: Throwable -> L52 RemoteException -> L275
        goto L276
    L272:
        r7 = biNoLocation;
    L276:
        remove(r.binder);     // Catch: Throwable -> L52
    L278:
        if (events.contains(33) == false) goto L290;
        IPhoneStateListener r2 = r.callback;     // Catch: Throwable -> L52 RemoteException -> L282
        if (shouldSanitizeLocationForPhysicalChannelConfig(r) == false) goto L284;
        List<PhysicalChannelConfig> r3 = getLocationSanitizedConfigs(this.mPhysicalChannelConfigs.get(r.phoneId));     // Catch: Throwable -> L52 RemoteException -> L282
    L285:
        r2.onPhysicalChannelConfigChanged(r3);     // Catch: Throwable -> L52 RemoteException -> L282
        goto L288
    L284:
        r3 = this.mPhysicalChannelConfigs.get(r.phoneId);     // Catch: Throwable -> L52 RemoteException -> L282
    L288:
        remove(r.binder);     // Catch: Throwable -> L52
    L290:
        if (events.contains(34) == false) goto L296;
        r.callback.onDataEnabledChanged(this.mIsDataEnabled[r.phoneId], this.mDataEnabledReason[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L293
    L294:
        remove(r.binder);     // Catch: Throwable -> L52
    L296:
        if (events.contains(41) == false) goto L302;
        r.callback.onSimultaneousCallingStateChanged(this.mSimultaneousCellularCallingSubIds);     // Catch: Throwable -> L52 RemoteException -> L299
    L300:
        remove(r.binder);     // Catch: Throwable -> L52
    L302:
        if (events.contains(37) == false) goto L313;
        if (this.mLinkCapacityEstimateLists.get(r.phoneId) == null) goto L313;
        r.callback.onLinkCapacityEstimateChanged(this.mLinkCapacityEstimateLists.get(r.phoneId));     // Catch: Throwable -> L52 RemoteException -> L307
    L311:
        remove(r.binder);     // Catch: Throwable -> L52
    L313:
        if (events.contains(39) == false) goto L350;
        Iterator<CallState> r8 = this.mCallStateLists.get(r.phoneId).iterator();     // Catch: Throwable -> L52
    L316:
        if (r8.hasNext() == false) goto L321;
        CallState cs = r8.next();     // Catch: Throwable -> L52
        Iterator<CallState> r17 = r8;
        if (cs.getCallState() == 1) goto L319;
        r8 = r17;
        goto L316
    L319:
        CallState callState = cs;
    L322:
        if (callState == null) goto L350;
        String callId = callState.getImsCallSessionId();     // Catch: Throwable -> L52
        MediaQualityStatus status = this.mMediaQualityStatus.get(r.phoneId).get(1);     // Catch: Throwable -> L52 RemoteException -> L344
        if (status != null) goto L421;
    L333:
        MediaQualityStatus status2 = this.mMediaQualityStatus.get(r.phoneId).get(2);     // Catch: Throwable -> L52 RemoteException -> L341
        if (status2 == null) goto L350;
        if (status2.getCallSessionId().equals(callId) == false) goto L350;
        r.callback.onMediaQualityStatusChanged(status2);     // Catch: Throwable -> L52 RemoteException -> L341
    L421:
        if (status.getCallSessionId().equals(callId) == false) goto L333;
        r.callback.onMediaQualityStatusChanged(status);     // Catch: Throwable -> L52 RemoteException -> L331
    L347:
        remove(r.binder);     // Catch: Throwable -> L52
        goto L350
    L321:
        callState = null;
    L350:
        if (events.contains(40) == false) goto L365;
        if (this.mECBMDuration[r.phoneId] == 0) goto L356;
        r.callback.onCallbackModeStarted(1, this.mECBMDuration[r.phoneId], r.subId);     // Catch: Throwable -> L52 RemoteException -> L354
    L358:
        if (this.mSCBMReason[r.phoneId] == 0) goto L360;
        r.callback.onCallbackModeStarted(2, this.mSCBMDuration[r.phoneId], r.subId);     // Catch: Throwable -> L52 RemoteException -> L354
        goto L365
    L360:
        r.callback.onCallbackModeStopped(2, this.mSCBMReason[r.phoneId], r.subId);     // Catch: Throwable -> L52 RemoteException -> L354
        goto L365
    L356:
        r.callback.onCallbackModeStopped(1, this.mECBMReason[r.phoneId], r.subId);     // Catch: Throwable -> L52 RemoteException -> L354
        goto L358
    L363:
        remove(r.binder);     // Catch: Throwable -> L52
    L365:
        if (events.contains(42) == false) goto L371;
        r.callback.onCarrierRoamingNtnModeChanged(this.mCarrierRoamingNtnMode[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L368
    L369:
        remove(r.binder);     // Catch: Throwable -> L52
    L371:
        if (events.contains(43) == false) goto L377;
        r.callback.onCarrierRoamingNtnEligibleStateChanged(this.mCarrierRoamingNtnEligible[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L374
    L375:
        remove(r.binder);     // Catch: Throwable -> L52
    L377:
        if (events.contains(44) == false) goto L383;
        r.callback.onCarrierRoamingNtnAvailableServicesChanged(this.mCarrierRoamingNtnAvailableServices.get(r.phoneId).toArray());     // Catch: Throwable -> L52 RemoteException -> L380
    L381:
        remove(r.binder);     // Catch: Throwable -> L52
    L383:
        if (events.contains(45) == false) goto L391;
        r.callback.onCarrierRoamingNtnSignalStrengthChanged(this.mCarrierRoamingNtnSignalStrength[r.phoneId]);     // Catch: Throwable -> L52 RemoteException -> L386
    L387:
        remove(r.binder);     // Catch: Throwable -> L52
    L391:
        monitor-exit(r6);     // Catch: Throwable -> L52
        return;
    L389:
        th = th;
    L393:
        th = th;
    L395:
        th = th;
        goto L399
    L423:
        monitor-exit(r6);     // Catch: Throwable -> L20
        return;
    L20:
        th = th;
    L52:
        th = th;
    L397:
        th = th;
        goto L399
    L12:
        subscriptionId = subId;
        goto L13
    }

    private String getCallIncomingNumber(Record record, int phoneId) {
        if (record.canReadCallLog() == true) goto L7;
        return "";
    L7:
        return this.mCallIncomingNumber[phoneId];
    }

    private Record add(IBinder binder, int callingUid, int callingPid, boolean doesLimitApply) {
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int N = this.mRecords.size();     // Catch: Throwable -> L10
        int numRecordsForPid = 0;
        int i = 0;
    L5:
        if (i >= N) goto L16;
        Record r = this.mRecords.get(i);     // Catch: Throwable -> L10
        if (binder == r.binder) goto L8;
        if (r.callerPid != callingPid) goto L15;
        numRecordsForPid = numRecordsForPid + 1;     // Catch: Throwable -> L10
    L15:
        i = i + 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r;
    L16:
        int registrationLimit = this.mConfigurationProvider.getRegistrationLimit();     // Catch: Throwable -> L10
        if (doesLimitApply == false) goto L27;
        if (registrationLimit < 1) goto L27;
        if (numRecordsForPid < registrationLimit) goto L27;
        String errorMsg = "Pid " + callingPid + " has exceeded the number of permissible registered listeners. Ignoring request to add.";     // Catch: Throwable -> L10
        loge(errorMsg);     // Catch: Throwable -> L10
        if (this.mConfigurationProvider.isRegistrationLimitEnabledInPlatformCompat(callingUid) == true) goto L25;
    L29:
        Record r2 = new Record(null);     // Catch: Throwable -> L10
        r2.binder = binder;     // Catch: Throwable -> L10
        r2.deathRecipient = new TelephonyRegistryDeathRecipient(this, binder);     // Catch: Throwable -> L10
        binder.linkToDeath(r2.deathRecipient, 0);     // Catch: Throwable -> L10 RemoteException -> L34
        this.mRecords.add(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L36:
        return null;
    L25:
        throw new IllegalStateException(errorMsg);     // Catch: Throwable -> L10
    L27:
        if (numRecordsForPid < 25) goto L29;
        Rlog.w(TAG, "Pid " + callingPid + " has exceeded half the number of permissible registered listeners. Now at " + numRecordsForPid);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void remove(IBinder binder) {
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int recordCount = this.mRecords.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= recordCount) goto L20;
        Record r = this.mRecords.get(i);     // Catch: Throwable -> L12
        if (r.binder == binder) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L5
    L9:
        if (r.deathRecipient != null) goto L25;
    L15:
        this.mRecords.remove(i);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L25:
        binder.unlinkToDeath(r.deathRecipient, 0);     // Catch: Throwable -> L12 NoSuchElementException -> L14
        goto L15
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void notifyCallStateForAllSubs(int state, String phoneNumber) {
        if (checkNotifyPermission("notifyCallState()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L20
    L9:
        if (r1.hasNext() == false) goto L33;
        Record r = r1.next();     // Catch: Throwable -> L20
        if (r.matchTelephonyCallbackEvent(36) == false) goto L25;
        if (r.subId != Integer.MAX_VALUE) goto L25;
        if (r.canReadCallLog() == false) goto L17;
        String phoneNumberOrEmpty = phoneNumber;
    L18:
        r.callback.onLegacyCallStateChanged(state, phoneNumberOrEmpty);     // Catch: Throwable -> L20 RemoteException -> L22
        goto L23
    L17:
        phoneNumberOrEmpty = "";
    L23:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L20
    L25:
        if (r.matchTelephonyCallbackEvent(6) == false) goto L9;
        if (r.subId != Integer.MAX_VALUE) goto L9;
        r.callback.onCallStateChanged(state);     // Catch: Throwable -> L20 RemoteException -> L30
    L31:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L20
        goto L9
    L33:
        handleRemoveListLocked();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        broadcastCallStateChanged(state, phoneNumber, -1, -1);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void notifyCallState(int phoneId, int subId, int state, String incomingNumber) {
        if (checkNotifyPermission("notifyCallState()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L35;
        this.mCallState[phoneId] = state;     // Catch: Throwable -> L20
        this.mCallIncomingNumber[phoneId] = incomingNumber;     // Catch: Throwable -> L20
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L20
    L11:
        if (r1.hasNext() == false) goto L35;
        Record r = r1.next();     // Catch: Throwable -> L20
        if (r.matchTelephonyCallbackEvent(36) == false) goto L25;
        if (r.subId != subId) goto L25;
        if (r.subId == Integer.MAX_VALUE) goto L25;
        String incomingNumberOrEmpty = getCallIncomingNumber(r, phoneId);     // Catch: Throwable -> L20 RemoteException -> L22
        r.callback.onLegacyCallStateChanged(state, incomingNumberOrEmpty);     // Catch: Throwable -> L20 RemoteException -> L22
    L23:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L20
    L25:
        if (r.matchTelephonyCallbackEvent(6) == false) goto L11;
        if (r.subId != subId) goto L11;
        if (r.subId == Integer.MAX_VALUE) goto L11;
        r.callback.onCallStateChanged(state);     // Catch: Throwable -> L20 RemoteException -> L32
    L33:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L20
    L35:
        handleRemoveListLocked();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        broadcastCallStateChanged(state, incomingNumber, phoneId, subId);
    }

    public void notifyServiceStateForPhoneId(int phoneId, int subId, ServiceState state) {
        if (checkNotifyPermission("notifyServiceState()") == true) goto L5;
        return;
    L5:
        long callingIdentity = Binder.clearCallingIdentity();
        ArrayList<Record> r2 = this.mRecords;     // Catch: Throwable -> L44
        monitor-enter(r2);     // Catch: Throwable -> L44
        String str = "notifyServiceStateForSubscriber: subId=" + subId + " phoneId=" + phoneId + " state=" + state;     // Catch: Throwable -> L23
        this.mLocalLog.log(str);     // Catch: Throwable -> L23
        if (validatePhoneId(phoneId) == false) goto L38;
        this.mServiceState[phoneId] = state;     // Catch: Throwable -> L23
        if (SubscriptionManager.isValidSubscriptionId(subId) == false) goto L37;
        Iterator<Record> r4 = this.mRecords.iterator();     // Catch: Throwable -> L23
    L14:
        if (r4.hasNext() == false) goto L39;
        Record r = r4.next();     // Catch: Throwable -> L23
        if (r.matchTelephonyCallbackEvent(1) == false) goto L14;
        if (idMatch(r, subId, phoneId) == false) goto L14;
        if (checkFineLocationAccess(r, 29) == false) goto L28;
        ServiceState stateToSend = new ServiceState(state);     // Catch: Throwable -> L23 RemoteException -> L25
    L31:
        r.callback.onServiceStateChanged(stateToSend);     // Catch: Throwable -> L23 RemoteException -> L25
        goto L14
    L28:
        if (checkCoarseLocationAccess(r, 29) == false) goto L30;
        stateToSend = state.createLocationInfoSanitizedCopy(false);     // Catch: Throwable -> L23 RemoteException -> L25
        goto L31
    L30:
        stateToSend = state.createLocationInfoSanitizedCopy(true);     // Catch: Throwable -> L23 RemoteException -> L25
        goto L31
    L34:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L23
    L39:
        handleRemoveListLocked();     // Catch: Throwable -> L23
        monitor-exit(r2);     // Catch: Throwable -> L23
        broadcastServiceStateChanged(state, phoneId, subId);     // Catch: Throwable -> L44
        Binder.restoreCallingIdentity(callingIdentity);
        return;
    L37:
        log("notifyServiceStateForSubscriber: INVALID subId=" + subId);     // Catch: Throwable -> L23
        goto L39
    L38:
        log("notifyServiceStateForSubscriber: INVALID phoneId=" + phoneId);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    }

    public void notifySimActivationStateChangedForPhoneId(int phoneId, int subId, int activationType, int activationState) {
        if (checkNotifyPermission("notifySimActivationState()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L42;
        switch(activationType) {
            case 0: goto L15;
            case 1: goto L14;
            default: goto L10;
        };     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        this.mDataActivationState[phoneId] = activationState;     // Catch: Throwable -> L12
    L16:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L18:
        if (r1.hasNext() == false) goto L43;
        Record r = r1.next();     // Catch: Throwable -> L12
        if (activationType != 0) goto L30;
        if (r.matchTelephonyCallbackEvent(18) == false) goto L30;
        if (idMatch(r, subId, phoneId) == false) goto L30;
        r.callback.onVoiceActivationStateChanged(activationState);     // Catch: Throwable -> L12 RemoteException -> L27
        goto L30
    L38:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
    L30:
        if (activationType != 1) goto L18;
        if (r.matchTelephonyCallbackEvent(19) == false) goto L18;
        if (idMatch(r, subId, phoneId) == false) goto L18;
        r.callback.onDataActivationStateChanged(activationState);     // Catch: Throwable -> L12 RemoteException -> L27
    L43:
        handleRemoveListLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        this.mVoiceActivationState[phoneId] = activationState;     // Catch: Throwable -> L12
        goto L16
    L42:
        log("notifySimActivationStateForPhoneId: INVALID phoneId=" + phoneId);     // Catch: Throwable -> L12
        goto L43
    }

    public void notifySignalStrengthForPhoneId(int phoneId, int subId, SignalStrength signalStrength) {
        if (checkNotifyPermission("notifySignalStrength()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L36;
        this.mSignalStrength[phoneId] = signalStrength;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L37;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(9) == false) goto L23;
        if (idMatch(r, subId, phoneId) == false) goto L23;
        r.callback.onSignalStrengthsChanged(new SignalStrength(signalStrength));     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        if (r.matchTelephonyCallbackEvent(2) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        int gsmSignalStrength = signalStrength.getGsmSignalStrength();     // Catch: Throwable -> L18 RemoteException -> L32
        if (gsmSignalStrength != 99) goto L29;
        int ss = -1;
    L30:
        r.callback.onSignalStrengthChanged(ss);     // Catch: Throwable -> L18 RemoteException -> L32
        goto L33
    L29:
        ss = gsmSignalStrength;
    L33:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L37:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        broadcastSignalStrengthChanged(signalStrength, phoneId, subId);
        return;
    L36:
        log("notifySignalStrengthForPhoneId: invalid phoneId=" + phoneId);     // Catch: Throwable -> L18
        goto L37
    }

    public void notifyCarrierNetworkChange(boolean active) {
        int[] subIds = Arrays.stream(SubscriptionManager.from(this.mContext).getCompleteActiveSubscriptionIdList()).filter(new TelephonyRegistry$$ExternalSyntheticLambda1(this)).toArray();
        if (ArrayUtils.isEmpty(subIds) == true) goto L8;
        int r1 = subIds.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        int subId = subIds[r2];
        notifyCarrierNetworkChangeWithPermission(subId, active);
        r2 = r2 + 1;
        goto L5
    L7:
        return;
    L8:
        loge("notifyCarrierNetworkChange without carrier privilege");
        throw new SecurityException("notifyCarrierNetworkChange without carrier privilege");
    }

    private /* synthetic */ boolean lambda$notifyCarrierNetworkChange$0(int i) {
        return TelephonyPermissions.checkCarrierPrivilegeForSubId(this.mContext, i);
    }

    public void notifyCarrierNetworkChangeWithSubId(int subId, boolean active) {
        if (TelephonyPermissions.checkCarrierPrivilegeForSubId(this.mContext, subId) == false) goto L7;
        notifyCarrierNetworkChangeWithPermission(subId, active);
        return;
    L7:
        throw new SecurityException("notifyCarrierNetworkChange without carrier privilege on subId " + subId);
    }

    private void notifyCarrierNetworkChangeWithPermission(int subId, boolean active) {
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        this.mCarrierNetworkChangeState[phoneId] = active;     // Catch: Throwable -> L13
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L6:
        if (r2.hasNext() == false) goto L18;
        Record r = r2.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(17) == false) goto L6;
        if (idMatch(r, subId, phoneId) == false) goto L6;
        r.callback.onCarrierNetworkChange(active);     // Catch: Throwable -> L13 RemoteException -> L15
    L16:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
        goto L6
    L18:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void notifyCellInfo(List<CellInfo> cellInfo) {
        notifyCellInfoForSubscriber(Integer.MAX_VALUE, cellInfo);
    }

    public void notifyCellInfoForSubscriber(int subId, List<CellInfo> cellInfo) {
        if (checkNotifyPermission("notifyCellInfoForSubscriber()") == true) goto L5;
        return;
    L5:
        if (cellInfo != null) goto L7;
        loge("notifyCellInfoForSubscriber() received a null list");
        cellInfo = Collections.EMPTY_LIST;
    L7:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L10:
        if (validatePhoneId(phoneId) == false) goto L29;
        this.mCellInfo.set(phoneId, cellInfo);     // Catch: Throwable -> L24
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L24
    L13:
        if (r2.hasNext() == false) goto L29;
        Record r = r2.next();     // Catch: Throwable -> L24
        if (validateEventAndUserLocked(r, 11) == false) goto L13;
        if (idMatch(r, subId, phoneId) == false) goto L13;
        if (checkCoarseLocationAccess(r, 1) == false) goto L13;
        if (checkFineLocationAccess(r, 29) == false) goto L13;
        r.callback.onCellInfoChanged(cellInfo);     // Catch: Throwable -> L24 RemoteException -> L26
    L27:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L24
    L29:
        handleRemoveListLocked();     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
    }

    public void notifyMessageWaitingChangedForPhoneId(int phoneId, int subId, boolean mwi) {
        if (checkNotifyPermission("notifyMessageWaitingChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mMessageWaiting[phoneId] = mwi;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(3) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onMessageWaitingIndicatorChanged(mwi);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyUserMobileDataStateChangedForPhoneId(int phoneId, int subId, boolean state) {
        if (checkNotifyPermission("notifyUserMobileDataStateChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mUserMobileDataState[phoneId] = state;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(20) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onUserMobileDataStateChanged(state);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyDisplayInfoChanged(int phoneId, int subId, TelephonyDisplayInfo telephonyDisplayInfo) {
        if (checkNotifyPermission("notifyDisplayInfoChanged()") == true) goto L5;
        return;
    L5:
        String str = "notifyDisplayInfoChanged: PhoneId=" + phoneId + " subId=" + subId + " telephonyDisplayInfo=" + telephonyDisplayInfo;
        this.mLocalLog.log(str);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L28;
        this.mTelephonyDisplayInfos[phoneId] = telephonyDisplayInfo;     // Catch: Throwable -> L19
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L19
    L11:
        if (r2.hasNext() == false) goto L28;
        Record r = r2.next();     // Catch: Throwable -> L19
        if (r.matchTelephonyCallbackEvent(21) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        if (this.mConfigurationProvider.isDisplayInfoNrAdvancedSupported(r.callingPackage, Binder.getCallingUserHandle()) == true) goto L23;
        r.callback.onDisplayInfoChanged(getBackwardCompatibleTelephonyDisplayInfo(telephonyDisplayInfo));     // Catch: Throwable -> L19 RemoteException -> L21
        goto L11
    L23:
        r.callback.onDisplayInfoChanged(telephonyDisplayInfo);     // Catch: Throwable -> L19 RemoteException -> L21
        goto L11
    L26:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L19
    L28:
        handleRemoveListLocked();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
    }

    private TelephonyDisplayInfo getBackwardCompatibleTelephonyDisplayInfo(TelephonyDisplayInfo telephonyDisplayInfo) {
        int networkType = telephonyDisplayInfo.getNetworkType();
        int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        if (networkType != 20) goto L6;
        int overrideNetworkType2 = 0;
    L11:
        boolean isRoaming = telephonyDisplayInfo.isRoaming();
        boolean isNtn = telephonyDisplayInfo.isNtn();
        boolean isSatelliteConstrainedData = telephonyDisplayInfo.isSatelliteConstrainedData();
        return new TelephonyDisplayInfo(networkType, overrideNetworkType2, isRoaming, isNtn, isSatelliteConstrainedData);
    L6:
        if (networkType == 13) goto L8;
    L10:
        overrideNetworkType2 = overrideNetworkType;
        goto L11
    L8:
        if (overrideNetworkType != 5) goto L10;
        overrideNetworkType2 = 4;
        goto L11
    }

    public void notifyCallForwardingChanged(boolean cfi) {
        notifyCallForwardingChangedForSubscriber(Integer.MAX_VALUE, cfi);
    }

    public void notifyCallForwardingChangedForSubscriber(int subId, boolean cfi) {
        if (checkNotifyPermission("notifyCallForwardingChanged()") == true) goto L5;
        return;
    L5:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mCallForwarding[phoneId] = cfi;     // Catch: Throwable -> L18
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r2.hasNext() == false) goto L23;
        Record r = r2.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(4) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onCallForwardingIndicatorChanged(cfi);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
    }

    public void notifyDataActivityForSubscriber(int subId, int state) {
        if (checkNotifyPermission("notifyDataActivity()") == true) goto L5;
        return;
    L5:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mDataActivity[phoneId] = state;     // Catch: Throwable -> L18
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r2.hasNext() == false) goto L23;
        Record r = r2.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(8) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onDataActivity(state);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
    }

    public void notifyDataActivityForSubscriberWithSlot(int phoneId, int subId, int state) {
        if (checkNotifyPermission("notifyDataActivityWithSlot()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mDataActivity[phoneId] = state;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(8) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onDataActivity(state);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyDataConnectionForSubscriber(int phoneId, int subId, PreciseDataConnectionState preciseState) {
        if (checkNotifyPermission("notifyDataConnection()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r5 = this.mRecords;
        monitor-enter(r5);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == true) goto L10;
    L69:
        monitor-exit(r5);     // Catch: Throwable -> L22
        return;
    L10:
        if (preciseState.getApnSetting() == null) goto L69;
        Pair<Integer, ApnSetting> key = Pair.create(Integer.valueOf(preciseState.getTransportType()), preciseState.getApnSetting());     // Catch: Throwable -> L22
        PreciseDataConnectionState oldState = this.mPreciseDataConnectionStates.get(phoneId).remove(key);     // Catch: Throwable -> L22
        if (Objects.equals(oldState, preciseState) == true) goto L29;
        Iterator<Record> r8 = this.mRecords.iterator();     // Catch: Throwable -> L22
    L15:
        if (r8.hasNext() == false) goto L27;
        Record r = r8.next();     // Catch: Throwable -> L22
        if (r.matchTelephonyCallbackEvent(13) == false) goto L15;
        if (idMatchRelaxed(r, subId, phoneId) == false) goto L15;
        r.callback.onPreciseDataConnectionStateChanged(preciseState);     // Catch: Throwable -> L22 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L22
        goto L15
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L22
        broadcastDataConnectionStateChanged(phoneId, subId, preciseState);     // Catch: Throwable -> L22
        String str = "notifyDataConnectionForSubscriber: phoneId=" + phoneId + " subId=" + subId + " " + preciseState;     // Catch: Throwable -> L22
        log(str);     // Catch: Throwable -> L22
        this.mLocalLog.log(str);     // Catch: Throwable -> L22
    L29:
        if (preciseState.getState() == 0) goto L31;
        this.mPreciseDataConnectionStates.get(phoneId).put(key, preciseState);     // Catch: Throwable -> L22
    L31:
        Map<Integer, PreciseDataConnectionState> internetConnections = new ArrayMap();     // Catch: Throwable -> L22
        int r10 = 0;
        if (preciseState.getState() == 0) goto L34;
    L36:
        Iterator<Map.Entry<Pair<Integer, ApnSetting>, PreciseDataConnectionState>> r0 = this.mPreciseDataConnectionStates.get(phoneId).entrySet().iterator();     // Catch: Throwable -> L22
    L38:
        if (r0.hasNext() == false) goto L45;
        Map.Entry<Pair<Integer, ApnSetting>, PreciseDataConnectionState> entry = r0.next();     // Catch: Throwable -> L22
        if (((Integer) entry.getKey().first).intValue() != 1) goto L38;
        if (((ApnSetting) entry.getKey().second).getApnTypes().contains(17) == false) goto L38;
        internetConnections.put(Integer.valueOf(entry.getValue().getState()), entry.getValue());     // Catch: Throwable -> L22
        goto L38
    L45:
        int[] statesInPriority = {2, 3, 1, 4, 0};     // Catch: Throwable -> L22
        int networkType = 0;
        int r12 = statesInPriority.length;     // Catch: Throwable -> L22
    L46:
        if (r10 >= r12) goto L51;
        int s = statesInPriority[r10];     // Catch: Throwable -> L22
        if (internetConnections.containsKey(Integer.valueOf(s)) == true) goto L49;
        r10 = r10 + 1;     // Catch: Throwable -> L22
        goto L46
    L49:
        networkType = internetConnections.get(Integer.valueOf(s)).getNetworkType();     // Catch: Throwable -> L22
        int state = s;
    L53:
        if (this.mDataConnectionState[phoneId] == state) goto L55;
    L56:
        String str2 = "onDataConnectionStateChanged(" + TelephonyUtils.dataStateToString(state) + ", " + TelephonyManager.getNetworkTypeName(networkType) + ") subId=" + subId + ", phoneId=" + phoneId;     // Catch: Throwable -> L22
        log(str2);     // Catch: Throwable -> L22
        this.mLocalLog.log(str2);     // Catch: Throwable -> L22
        Iterator<Record> r13 = this.mRecords.iterator();     // Catch: Throwable -> L22
    L58:
        if (r13.hasNext() == false) goto L68;
        Record r2 = r13.next();     // Catch: Throwable -> L22
        if (r2.matchTelephonyCallbackEvent(7) == false) goto L58;
        if (idMatch(r2, subId, phoneId) == false) goto L58;
        r2.callback.onDataConnectionStateChanged(state, networkType);     // Catch: Throwable -> L22 RemoteException -> L65
    L66:
        this.mRemoveList.add(r2.binder);     // Catch: Throwable -> L22
        goto L58
    L68:
        this.mDataConnectionState[phoneId] = state;     // Catch: Throwable -> L22
        this.mDataConnectionNetworkType[phoneId] = networkType;     // Catch: Throwable -> L22
        handleRemoveListLocked();     // Catch: Throwable -> L22
        goto L69
    L55:
        if (this.mDataConnectionNetworkType[phoneId] == networkType) goto L69;
    L51:
        state = 0;
        goto L53
    L34:
        if (preciseState.getApnSetting().getApnTypes().contains(17) == false) goto L36;
        internetConnections.put(0, preciseState);     // Catch: Throwable -> L22
        goto L36
    }

    public void notifyCellLocationForSubscriber(int subId, CellIdentity cellIdentity) {
        notifyCellLocationForSubscriber(subId, cellIdentity, false);
    }

    private void notifyCellLocationForSubscriber(int subId, CellIdentity cellIdentity, boolean hasUserSwitched) {
        log("notifyCellLocationForSubscriber: subId=" + subId + " cellIdentity=" + Rlog.pii(false, cellIdentity));
        if (checkNotifyPermission("notifyCellLocation()") == true) goto L5;
        return;
    L5:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L31;
        if (hasUserSwitched == false) goto L11;
    L15:
        this.mCellIdentity[phoneId] = cellIdentity;     // Catch: Throwable -> L13
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r2.hasNext() == false) goto L31;
        Record r = r2.next();     // Catch: Throwable -> L13
        if (validateEventAndUserLocked(r, 5) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        if (checkCoarseLocationAccess(r, 1) == false) goto L17;
        if (checkFineLocationAccess(r, 29) == false) goto L17;
        r.callback.onCellLocationChanged(cellIdentity);     // Catch: Throwable -> L13 RemoteException -> L28
    L29:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
        goto L17
    L11:
        if (Objects.equals(cellIdentity, this.mCellIdentity[phoneId]) == false) goto L15;
    L31:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    }

    public void notifyPreciseCallState(int phoneId, int subId, int[] callStates, String[] imsCallIds, int[] imsServiceTypes, int[] imsCallTypes) {
        if (checkNotifyPermission("notifyPreciseCallState()") == true) goto L5;
        return;
    L5:
        int ringingCallState = callStates[0];
        int foregroundCallState = callStates[1];
        int backgroundCallState = callStates[2];
        ArrayList<Record> r12 = this.mRecords;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L94;
        boolean preciseCallStateChanged = false;
        this.mRingingCallState[phoneId] = ringingCallState;     // Catch: Throwable -> L12
        this.mForegroundCallState[phoneId] = foregroundCallState;     // Catch: Throwable -> L12
        this.mBackgroundCallState[phoneId] = backgroundCallState;     // Catch: Throwable -> L12
        PreciseCallState preciseCallState = new PreciseCallState(ringingCallState, foregroundCallState, backgroundCallState, -1, -1);     // Catch: Throwable -> L12
        if (preciseCallState.equals(this.mPreciseCallState[phoneId]) == true) goto L14;
        preciseCallStateChanged = true;
        this.mPreciseCallState[phoneId] = preciseCallState;     // Catch: Throwable -> L12
    L14:
        boolean notifyCallState = true;
        if (this.mCallQuality != null) goto L18;
        log("notifyPreciseCallState: mCallQuality is null, skipping call attributes");     // Catch: Throwable -> L12
        notifyCallState = false;
    L58:
        if (preciseCallStateChanged == false) goto L71;
        Iterator<Record> r9 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L61:
        if (r9.hasNext() == false) goto L71;
        Record r = r9.next();     // Catch: Throwable -> L12
        if (r.matchTelephonyCallbackEvent(12) == false) goto L61;
        if (idMatch(r, subId, phoneId) == false) goto L61;
        r.callback.onPreciseCallStateChanged(this.mPreciseCallState[phoneId]);     // Catch: Throwable -> L12 RemoteException -> L68
    L69:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
    L71:
        if (notifyCallState == false) goto L94;
        Iterator<Record> r10 = this.mRecords.iterator();     // Catch: Throwable -> L12
        List<CallState> copyList = null;
    L74:
        if (r10.hasNext() == false) goto L94;
        Record r2 = r10.next();     // Catch: Throwable -> L12
        if (r2.matchTelephonyCallbackEvent(27) == false) goto L74;
        if (idMatch(r2, subId, phoneId) == false) goto L74;
        if (r2.callerPid != this.mPid) goto L85;
        if (copyList != null) goto L85;
        copyList = List.copyOf(this.mCallStateLists.get(phoneId));     // Catch: Throwable -> L12 RemoteException -> L83
    L85:
        IPhoneStateListener r0 = r2.callback;     // Catch: Throwable -> L12 RemoteException -> L83
        if (copyList != null) goto L88;
        List<CallState> r14 = this.mCallStateLists.get(phoneId);     // Catch: Throwable -> L12 RemoteException -> L83
    L89:
        r0.onCallStatesChanged(r14);     // Catch: Throwable -> L12 RemoteException -> L83
        goto L74
    L88:
        r14 = copyList;
        goto L89
    L92:
        this.mRemoveList.add(r2.binder);     // Catch: Throwable -> L12
        goto L74
    L18:
        if (this.mPreciseCallState[phoneId].getForegroundCallState() == 1) goto L20;
        this.mCallNetworkType[phoneId] = 0;     // Catch: Throwable -> L12
        this.mCallQuality[phoneId] = createCallQuality();     // Catch: Throwable -> L12
    L20:
        List<CallState> prevCallStateList = new ArrayList();     // Catch: Throwable -> L12
        prevCallStateList.addAll(this.mCallStateLists.get(phoneId));     // Catch: Throwable -> L12
        this.mCallStateLists.get(phoneId).clear();     // Catch: Throwable -> L12
        if (foregroundCallState == (-1)) goto L30;
        if (foregroundCallState == 0) goto L30;
        CallQuality callQuality = this.mCallQuality[phoneId];     // Catch: Throwable -> L12
        CallState.Builder builder = new CallState.Builder(callStates[1]).setNetworkType(this.mCallNetworkType[phoneId]).setCallQuality(callQuality).setCallClassification(1);     // Catch: Throwable -> L12
        if (imsCallIds == null) goto L28;
        if (imsServiceTypes == null) goto L28;
        if (imsCallTypes == null) goto L28;
        builder = builder.setImsCallSessionId(imsCallIds[1]).setImsCallServiceType(imsServiceTypes[1]).setImsCallType(imsCallTypes[1]);     // Catch: Throwable -> L12
    L28:
        this.mCallStateLists.get(phoneId).add(builder.build());     // Catch: Throwable -> L12
    L30:
        if (backgroundCallState == (-1)) goto L38;
        if (backgroundCallState == 0) goto L38;
        CallState.Builder builder2 = new CallState.Builder(callStates[r11]).setNetworkType(this.mCallNetworkType[phoneId]).setCallQuality(createCallQuality()).setCallClassification(2);     // Catch: Throwable -> L12
        if (imsCallIds == null) goto L37;
        if (imsServiceTypes == null) goto L37;
        if (imsCallTypes == null) goto L37;
        builder2 = builder2.setImsCallSessionId(imsCallIds[2]).setImsCallServiceType(imsServiceTypes[2]).setImsCallType(imsCallTypes[2]);     // Catch: Throwable -> L12
    L37:
        this.mCallStateLists.get(phoneId).add(builder2.build());     // Catch: Throwable -> L12
    L38:
        if (ringingCallState == (-1)) goto L47;
        if (ringingCallState == 0) goto L47;
        CallState.Builder builder3 = new CallState.Builder(callStates[r0]).setNetworkType(this.mCallNetworkType[phoneId]).setCallQuality(createCallQuality()).setCallClassification(0);     // Catch: Throwable -> L12
        if (imsCallIds == null) goto L45;
        if (imsServiceTypes == null) goto L45;
        if (imsCallTypes == null) goto L45;
        builder3 = builder3.setImsCallSessionId(imsCallIds[0]).setImsCallServiceType(imsServiceTypes[0]).setImsCallType(imsCallTypes[0]);     // Catch: Throwable -> L12
    L45:
        this.mCallStateLists.get(phoneId).add(builder3.build());     // Catch: Throwable -> L12
    L47:
        if (prevCallStateList.equals(this.mCallStateLists.get(phoneId)) == false) goto L49;
        notifyCallState = false;
    L49:
        boolean hasOngoingCall = false;
        Iterator<CallState> r11 = this.mCallStateLists.get(phoneId).iterator();     // Catch: Throwable -> L12
    L51:
        if (r11.hasNext() == false) goto L56;
        CallState cs = r11.next();     // Catch: Throwable -> L12
        if (cs.getCallState() == 7) goto L51;
        hasOngoingCall = true;
    L56:
        if (hasOngoingCall == true) goto L58;
        this.mMediaQualityStatus.get(phoneId).clear();     // Catch: Throwable -> L12
    L94:
        handleRemoveListLocked();     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    }

    public void notifyDisconnectCause(int phoneId, int subId, int disconnectCause, int preciseDisconnectCause) {
        if (checkNotifyPermission("notifyDisconnectCause()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mCallDisconnectCause[phoneId] = disconnectCause;     // Catch: Throwable -> L18
        this.mCallPreciseDisconnectCause[phoneId] = preciseDisconnectCause;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(26) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onCallDisconnectCauseChanged(this.mCallDisconnectCause[phoneId], this.mCallPreciseDisconnectCause[phoneId]);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyImsDisconnectCause(int subId, ImsReasonInfo imsReasonInfo) {
        if (checkNotifyPermission("notifyImsCallDisconnectCause()") == true) goto L5;
        return;
    L5:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L27;
        if (imsReasonInfo != null) goto L15;
        loge("ImsReasonInfo is null, subId=" + subId + ", phoneId=" + phoneId);     // Catch: Throwable -> L13
        this.mImsReasonInfo.set(phoneId, new ImsReasonInfo());     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L15:
        this.mImsReasonInfo.set(phoneId, imsReasonInfo);     // Catch: Throwable -> L13
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r2.hasNext() == false) goto L27;
        Record r = r2.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(28) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        r.callback.onImsCallDisconnectCauseChanged(this.mImsReasonInfo.get(phoneId));     // Catch: Throwable -> L13 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    }

    public void notifySrvccStateChanged(int subId, int state) {
        if (checkNotifyPermission("notifySrvccStateChanged()") == true) goto L5;
        return;
    L5:
        int phoneId = getPhoneIdFromSubId(subId);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mSrvccState[phoneId] = state;     // Catch: Throwable -> L18
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r2.hasNext() == false) goto L23;
        Record r = r2.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(16) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onSrvccStateChanged(state);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
    }

    public void notifyOemHookRawEventForSubscriber(int phoneId, int subId, byte[] rawData) {
        if (checkNotifyPermission("notifyOemHookRawEventForSubscriber") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(15) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onOemHookRawEvent(rawData);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyPhoneCapabilityChanged(PhoneCapability capability) {
        if (checkNotifyPermission("notifyPhoneCapabilityChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        this.mPhoneCapability = capability;     // Catch: Throwable -> L14
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L19;
        Record r = r1.next();     // Catch: Throwable -> L14
        if (r.matchTelephonyCallbackEvent(22) == false) goto L9;
        r.callback.onPhoneCapabilityChanged(capability);     // Catch: Throwable -> L14 RemoteException -> L16
    L17:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L14
        goto L9
    L19:
        handleRemoveListLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void notifyActiveDataSubIdChanged(int activeDataSubId) {
        if (checkNotifyPermission("notifyActiveDataSubIdChanged()") == true) goto L5;
        return;
    L5:
        log("notifyActiveDataSubIdChanged: activeDataSubId=" + activeDataSubId);
        this.mLocalLog.log("notifyActiveDataSubIdChanged: activeDataSubId=" + activeDataSubId);
        this.mActiveDataSubId = activeDataSubId;
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L19;
        Record r = r1.next();     // Catch: Throwable -> L14
        if (r.matchTelephonyCallbackEvent(23) == false) goto L9;
        r.callback.onActiveDataSubIdChanged(activeDataSubId);     // Catch: Throwable -> L14 RemoteException -> L16
    L17:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L14
        goto L9
    L19:
        handleRemoveListLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void notifyRadioPowerStateChanged(int phoneId, int subId, int state) {
        if (checkNotifyPermission("notifyRadioPowerStateChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mRadioPowerState = state;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(24) == false) goto L11;
        if (idMatchRelaxed(r, subId, phoneId) == false) goto L11;
        r.callback.onRadioPowerStateChanged(state);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        broadcastRadioPowerStateChanged(state, phoneId, subId);
    }

    public void notifyEmergencyNumberList(int phoneId, int subId) {
        if (checkNotifyPermission("notifyEmergencyNumberList()") == true) goto L6;
        return;
    L6:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.calling") == false) goto L8;
    L10:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L13:
        if (validatePhoneId(phoneId) == false) goto L28;
        TelephonyManager tm = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);     // Catch: Throwable -> L23
        this.mEmergencyNumberList = tm.getEmergencyNumberList();     // Catch: Throwable -> L23
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L23
    L16:
        if (r2.hasNext() == false) goto L28;
        Record r = r2.next();     // Catch: Throwable -> L23
        if (r.matchTelephonyCallbackEvent(25) == false) goto L16;
        if (idMatch(r, subId, phoneId) == false) goto L16;
        r.callback.onEmergencyNumberListChanged(this.mEmergencyNumberList);     // Catch: Throwable -> L23 RemoteException -> L25
    L26:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L23
    L28:
        handleRemoveListLocked();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L8:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.messaging") == true) goto L10;
    }

    public void notifyOutgoingEmergencyCall(int phoneId, int subId, EmergencyNumber emergencyNumber) {
        if (checkNotifyPermission("notifyOutgoingEmergencyCall()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L12;
        this.mOutgoingCallEmergencyNumber[phoneId] = emergencyNumber;     // Catch: Throwable -> L10
    L12:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L10
    L14:
        if (r1.hasNext() == false) goto L22;
        Record r = r1.next();     // Catch: Throwable -> L10
        if (r.matchTelephonyCallbackEvent(29) == false) goto L14;
        r.callback.onOutgoingEmergencyCall(emergencyNumber, subId);     // Catch: Throwable -> L10 RemoteException -> L19
    L20:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L10
        goto L14
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L10
        handleRemoveListLocked();
    }

    public void notifyOutgoingEmergencySms(int phoneId, int subId, EmergencyNumber emergencyNumber) {
        if (checkNotifyPermission("notifyOutgoingEmergencySms()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L21;
        this.mOutgoingSmsEmergencyNumber[phoneId] = emergencyNumber;     // Catch: Throwable -> L16
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L16
    L11:
        if (r1.hasNext() == false) goto L21;
        Record r = r1.next();     // Catch: Throwable -> L16
        if (r.matchTelephonyCallbackEvent(30) == false) goto L11;
        r.callback.onOutgoingEmergencySms(emergencyNumber, subId);     // Catch: Throwable -> L16 RemoteException -> L18
    L19:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L16
    L21:
        handleRemoveListLocked();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public void notifyCallQualityChanged(CallQuality callQuality, int phoneId, int subId, int callNetworkType) {
        if (checkNotifyPermission("notifyCallQualityChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L40;
        this.mCallQuality[phoneId] = callQuality;     // Catch: Throwable -> L24
        this.mCallNetworkType[phoneId] = callNetworkType;     // Catch: Throwable -> L24
        if (this.mCallStateLists.get(phoneId).size() > 0) goto L12;
    L37:
        log("There is no active call to report CallQuality");     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L12:
        if (this.mCallStateLists.get(phoneId).get(0).getCallState() != 1) goto L37;
        CallState prev = this.mCallStateLists.get(phoneId).remove(0);     // Catch: Throwable -> L24
        this.mCallStateLists.get(phoneId).add(0, new CallState.Builder(prev.getCallState()).setNetworkType(callNetworkType).setCallQuality(callQuality).setCallClassification(prev.getCallClassification()).setImsCallSessionId(prev.getImsCallSessionId()).setImsCallServiceType(prev.getImsCallServiceType()).setImsCallType(prev.getImsCallType()).build());     // Catch: Throwable -> L24
        List<CallState> copyList = null;
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L24
    L15:
        if (r2.hasNext() == false) goto L40;
        Record r = r2.next();     // Catch: Throwable -> L24
        if (r.matchTelephonyCallbackEvent(27) == false) goto L15;
        if (idMatch(r, subId, phoneId) == false) goto L15;
        if (r.callerPid != this.mPid) goto L28;
        if (copyList != null) goto L28;
        copyList = List.copyOf(this.mCallStateLists.get(phoneId));     // Catch: Throwable -> L24 RemoteException -> L26
    L28:
        IPhoneStateListener r4 = r.callback;     // Catch: Throwable -> L24 RemoteException -> L26
        if (copyList != null) goto L31;
        List<CallState> r5 = this.mCallStateLists.get(phoneId);     // Catch: Throwable -> L24 RemoteException -> L26
    L32:
        r4.onCallStatesChanged(r5);     // Catch: Throwable -> L24 RemoteException -> L26
        goto L15
    L31:
        r5 = copyList;
        goto L32
    L35:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L24
    L40:
        handleRemoveListLocked();     // Catch: Throwable -> L24
        monitor-exit(r0);     // Catch: Throwable -> L24
    }

    public void notifyRegistrationFailed(int phoneId, int subId, CellIdentity cellIdentity, String chosenPlmn, int domain, int causeCode, int additionalCauseCode) {
        if (checkNotifyPermission("notifyRegistrationFailed()") == true) goto L5;
        return;
    L5:
        CellIdentity noLocationCi = cellIdentity.sanitizeLocationInfo();
        String primaryPlmn = cellIdentity.getPlmn();
        StringBuilder r0 = new StringBuilder();
        r0.append("Registration Failed for phoneId=");
        r0.append(phoneId);
        r0.append(" subId=");
        r0.append(subId);
        r0.append("primaryPlmn=");
        r0.append(primaryPlmn);
        r0.append(" chosenPlmn=");
        String r9 = chosenPlmn;
        r0.append(r9);
        r0.append(" domain=");
        int r10 = domain;
        r0.append(r10);
        r0.append(" causeCode=");
        int r11 = causeCode;
        r0.append(r11);
        r0.append(" additionalCauseCode=");
        int r12 = additionalCauseCode;
        r0.append(r12);
        String logStr = r0.toString();
        this.mLocalLog.log(logStr);
        ArrayList<Record> r13 = this.mRecords;
        monitor-enter(r13);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L27;
        Iterator<Record> r14 = this.mRecords.iterator();     // Catch: Throwable -> L22
    L11:
        if (r14.hasNext() == false) goto L27;
        Record r = r14.next();     // Catch: Throwable -> L22
        if (r.matchTelephonyCallbackEvent(31) == false) goto L26;
        if (idMatch(r, subId, phoneId) == false) goto L26;
        IPhoneStateListener r7 = r.callback;     // Catch: Throwable -> L22 RemoteException -> L24
        if (checkFineLocationAccess(r, 1) == false) goto L19;
        CellIdentity r8 = cellIdentity;
    L20:
        r7.onRegistrationFailed(r8, r9, r10, r11, r12);     // Catch: Throwable -> L22 RemoteException -> L24
        goto L25
    L19:
        r8 = noLocationCi;
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L22
    L26:
        r9 = chosenPlmn;
        r10 = domain;
        r11 = causeCode;
        r12 = additionalCauseCode;
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L22
        monitor-exit(r13);     // Catch: Throwable -> L22
    }

    public void notifyBarringInfoChanged(int phoneId, int subId, BarringInfo barringInfo) {
        if (checkNotifyPermission("notifyBarringInfo()") == true) goto L6;
        return;
    L6:
        if (validatePhoneId(phoneId) == true) goto L9;
        loge("Received invalid phoneId for BarringInfo = " + phoneId);
        return;
    L9:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        if (barringInfo != null) goto L18;
        loge("Received null BarringInfo for subId=" + subId + ", phoneId=" + phoneId);     // Catch: Throwable -> L15
        this.mBarringInfo.set(phoneId, new BarringInfo());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L18:
        if (barringInfo.equals(this.mBarringInfo.get(phoneId)) == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L21:
        this.mBarringInfo.set(phoneId, barringInfo);     // Catch: Throwable -> L15
        BarringInfo biNoLocation = barringInfo.createLocationInfoSanitizedCopy();     // Catch: Throwable -> L15
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L15
    L23:
        if (r2.hasNext() == false) goto L37;
        Record r = r2.next();     // Catch: Throwable -> L15
        if (r.matchTelephonyCallbackEvent(32) == false) goto L23;
        if (idMatch(r, subId, phoneId) == false) goto L23;
        IPhoneStateListener r4 = r.callback;     // Catch: Throwable -> L15 RemoteException -> L34
        if (checkFineLocationAccess(r, 1) == false) goto L31;
        BarringInfo r5 = barringInfo;
    L32:
        r4.onBarringInfoChanged(r5);     // Catch: Throwable -> L15 RemoteException -> L34
        goto L35
    L31:
        r5 = biNoLocation;
    L35:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L15
        goto L23
    L37:
        handleRemoveListLocked();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void notifyPhysicalChannelConfigForSubscriber(int phoneId, int subId, List<PhysicalChannelConfig> configs) {
        if (checkNotifyPermission("notifyPhysicalChannelConfig()") == true) goto L5;
        return;
    L5:
        List<PhysicalChannelConfig> sanitizedConfigs = getLocationSanitizedConfigs(configs);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L27;
        this.mPhysicalChannelConfigs.set(phoneId, configs);     // Catch: Throwable -> L22
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L22
    L11:
        if (r2.hasNext() == false) goto L27;
        Record r = r2.next();     // Catch: Throwable -> L22
        if (r.matchTelephonyCallbackEvent(33) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        IPhoneStateListener r4 = r.callback;     // Catch: Throwable -> L22 RemoteException -> L24
        if (shouldSanitizeLocationForPhysicalChannelConfig(r) == false) goto L19;
        List<PhysicalChannelConfig> r5 = sanitizedConfigs;
    L20:
        r4.onPhysicalChannelConfigChanged(r5);     // Catch: Throwable -> L22 RemoteException -> L24
        goto L25
    L19:
        r5 = configs;
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L22
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
    }

    private static boolean shouldSanitizeLocationForPhysicalChannelConfig(Record record) {
        return !TelephonyPermissions.isSystemOrPhone(record.callerUid);
    }

    private static List<PhysicalChannelConfig> getLocationSanitizedConfigs(List<PhysicalChannelConfig> configs) {
        List<PhysicalChannelConfig> sanitizedConfigs = new ArrayList(configs.size());
        Iterator<PhysicalChannelConfig> r1 = configs.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PhysicalChannelConfig config = r1.next();
        sanitizedConfigs.add(config.createLocationInfoSanitizedCopy());
        goto L4
    L6:
        return sanitizedConfigs;
    }

    public void notifyDataEnabled(int phoneId, int subId, boolean enabled, int reason) {
        if (checkNotifyPermission("notifyDataEnabled()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mIsDataEnabled[phoneId] = enabled;     // Catch: Throwable -> L18
        this.mDataEnabledReason[phoneId] = reason;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(34) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onDataEnabledChanged(enabled, reason);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyAllowedNetworkTypesChanged(int phoneId, int subId, int reason, long allowedNetworkType) {
        if (checkNotifyPermission("notifyAllowedNetworkTypesChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mAllowedNetworkTypeReason[phoneId] = reason;     // Catch: Throwable -> L18
        this.mAllowedNetworkTypeValue[phoneId] = allowedNetworkType;     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(35) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onAllowedNetworkTypesChanged(reason, allowedNetworkType);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifyLinkCapacityEstimateChanged(int phoneId, int subId, List<LinkCapacityEstimate> linkCapacityEstimateList) {
        if (checkNotifyPermission("notifyLinkCapacityEstimateChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L23;
        this.mLinkCapacityEstimateLists.set(phoneId, linkCapacityEstimateList);     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L11:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(37) == false) goto L11;
        if (idMatch(r, subId, phoneId) == false) goto L11;
        r.callback.onLinkCapacityEstimateChanged(linkCapacityEstimateList);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
    }

    public void notifySimultaneousCellularCallingSubscriptionsChanged(int[] subIds) {
        if (checkNotifyPermission("notifySimultaneousCellularCallingSubscriptionsChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        this.mSimultaneousCellularCallingSubIds = subIds;     // Catch: Throwable -> L14
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L14
    L9:
        if (r1.hasNext() == false) goto L19;
        Record r = r1.next();     // Catch: Throwable -> L14
        if (r.matchTelephonyCallbackEvent(41) == false) goto L9;
        r.callback.onSimultaneousCallingStateChanged(subIds);     // Catch: Throwable -> L14 RemoteException -> L16
    L17:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L14
        goto L9
    L19:
        handleRemoveListLocked();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void addCarrierPrivilegesCallback(int phoneId, ICarrierPrivilegesCallback callback, String callingPackage, String callingFeatureId) {
        UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", "addCarrierPrivilegesCallback");
        onMultiSimConfigChanged();
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (validatePhoneId(phoneId) == false) goto L25;
        Record r = add(callback.asBinder(), Binder.getCallingUid(), Binder.getCallingPid(), false);     // Catch: Throwable -> L10
        if (r != null) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        r.context = this.mContext;     // Catch: Throwable -> L10
        r.carrierPrivilegesCallback = callback;     // Catch: Throwable -> L10
        r.callingPackage = callingPackage;     // Catch: Throwable -> L10
        r.callingFeatureId = callingFeatureId;     // Catch: Throwable -> L10
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L10
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L10
        r.phoneId = phoneId;     // Catch: Throwable -> L10
        r.eventList = new ArraySet();     // Catch: Throwable -> L10
        Pair<List<String>, int[]> state = this.mCarrierPrivilegeStates.get(phoneId);     // Catch: Throwable -> L10
        Pair<String, Integer> carrierServiceState = this.mCarrierServiceStates.get(phoneId);     // Catch: Throwable -> L10
        if (r.matchCarrierPrivilegesCallback() == false) goto L22;
        r.carrierPrivilegesCallback.onCarrierPrivilegesChanged(Collections.unmodifiableList((List) state.first), Arrays.copyOf((int[]) state.second, ((int[]) state.second).length));     // Catch: Throwable -> L10 RemoteException -> L17
        r.carrierPrivilegesCallback.onCarrierServiceChanged((String) carrierServiceState.first, ((Integer) carrierServiceState.second).intValue());     // Catch: Throwable -> L10 RemoteException -> L17
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L21:
        remove(r.binder);     // Catch: Throwable -> L10
        goto L22
    L25:
        throw new IllegalArgumentException("Invalid slot index: " + phoneId);     // Catch: Throwable -> L10
    }

    public void removeCarrierPrivilegesCallback(ICarrierPrivilegesCallback callback, String callingPackage) {
        this.mAppOps.checkPackage(Binder.getCallingUid(), callingPackage);
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", "removeCarrierPrivilegesCallback");
        remove(callback.asBinder());
    }

    public void notifyCarrierPrivilegesChanged(int phoneId, List<String> privilegedPackageNames, int[] privilegedUids) {
        if (checkNotifyPermission("notifyCarrierPrivilegesChanged") == true) goto L5;
        return;
    L5:
        onMultiSimConfigChanged();
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L28;
        this.mCarrierPrivilegeStates.set(phoneId, new Pair(privilegedPackageNames, privilegedUids));     // Catch: Throwable -> L19
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L19
    L11:
        if (r1.hasNext() == false) goto L24;
        Record r = r1.next();     // Catch: Throwable -> L19
        if (r.matchCarrierPrivilegesCallback() == false) goto L11;
        if (idMatch(r, -1, phoneId) == false) goto L11;
        r.carrierPrivilegesCallback.onCarrierPrivilegesChanged(Collections.unmodifiableList(privilegedPackageNames), Arrays.copyOf(privilegedUids, privilegedUids.length));     // Catch: Throwable -> L19 RemoteException -> L21
    L22:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L19
        goto L11
    L24:
        handleRemoveListLocked();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L28:
        throw new IllegalArgumentException("Invalid slot index: " + phoneId);     // Catch: Throwable -> L19
    }

    public void notifyCarrierServiceChanged(int phoneId, String packageName, int uid) {
        if (checkNotifyPermission("notifyCarrierServiceChanged") == true) goto L6;
        return;
    L6:
        if (validatePhoneId(phoneId) == true) goto L8;
        return;
    L8:
        onMultiSimConfigChanged();
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        this.mCarrierServiceStates.set(phoneId, new Pair(packageName, Integer.valueOf(uid)));     // Catch: Throwable -> L20
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L20
    L12:
        if (r1.hasNext() == false) goto L25;
        Record r = r1.next();     // Catch: Throwable -> L20
        if (r.matchCarrierPrivilegesCallback() == false) goto L12;
        if (idMatch(r, -1, phoneId) == false) goto L12;
        r.carrierPrivilegesCallback.onCarrierServiceChanged(packageName, uid);     // Catch: Throwable -> L20 RemoteException -> L22
    L23:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L20
        goto L12
    L25:
        handleRemoveListLocked();     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void addCarrierConfigChangeListener(ICarrierConfigChangeListener listener, String pkg, String featureId) {
        UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), pkg);
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        IBinder b = listener.asBinder();     // Catch: Throwable -> L9
        boolean doesLimitApply = doesLimitApplyForListeners(Binder.getCallingUid(), Process.myUid());     // Catch: Throwable -> L9
        Record r = add(b, Binder.getCallingUid(), Binder.getCallingPid(), doesLimitApply);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        loge("Can not create Record instance!");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        r.context = this.mContext;     // Catch: Throwable -> L9
        r.carrierConfigChangeListener = listener;     // Catch: Throwable -> L9
        r.callingPackage = pkg;     // Catch: Throwable -> L9
        r.callingFeatureId = featureId;     // Catch: Throwable -> L9
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L9
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L9
        r.eventList = new ArraySet();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeCarrierConfigChangeListener(ICarrierConfigChangeListener listener, String pkg) {
        this.mAppOps.checkPackage(Binder.getCallingUid(), pkg);
        remove(listener.asBinder());
    }

    public void notifyCarrierConfigChanged(int phoneId, int subId, int carrierId, int specificCarrierId) {
        if (validatePhoneId(phoneId) == false) goto L29;
        if (checkNotifyPermission("notifyCarrierConfigChanged") == true) goto L8;
        loge("Caller has no notify permission!");
        return;
    L8:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        this.mRemoveList.clear();     // Catch: Throwable -> L18
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L12:
        if (r1.hasNext() == false) goto L23;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchCarrierConfigChangeListener() == false) goto L12;
        r.carrierConfigChangeListener.onCarrierConfigChanged(phoneId, subId, carrierId, specificCarrierId);     // Catch: Throwable -> L18 RemoteException -> L20
    L21:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
        goto L12
    L23:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L29:
        throw new IllegalArgumentException("Invalid phoneId: " + phoneId);
    }

    public void addSatelliteStateChangeListener(ISatelliteStateChangeListener listener, String pkg, String featureId) {
        UserHandle.getCallingUserId();
        this.mAppOps.checkPackage(Binder.getCallingUid(), pkg);
        enforceCallingOrSelfAtLeastReadBasicPhoneStatePermission(pkg, featureId, "addSatelliteStateChangeListener");
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        IBinder b = listener.asBinder();     // Catch: Throwable -> L9
        boolean doesLimitApply = doesLimitApplyForListeners(Binder.getCallingUid(), Process.myUid());     // Catch: Throwable -> L9
        Record r = add(b, Binder.getCallingUid(), Binder.getCallingPid(), doesLimitApply);     // Catch: Throwable -> L9
        if (r != null) goto L11;
        loge("addSatelliteStateChangeListener: can not create Record instance!");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        r.context = this.mContext;     // Catch: Throwable -> L9
        r.satelliteStateChangeListener = listener;     // Catch: Throwable -> L9
        r.callingPackage = pkg;     // Catch: Throwable -> L9
        r.callingFeatureId = featureId;     // Catch: Throwable -> L9
        r.callerUid = Binder.getCallingUid();     // Catch: Throwable -> L9
        r.callerPid = Binder.getCallingPid();     // Catch: Throwable -> L9
        r.eventList = new ArraySet();     // Catch: Throwable -> L9
        if (this.mWasSatelliteEnabledNotified.get() == true) goto L14;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L14:
        if (r.matchSatelliteStateChangeListener() == false) goto L20;
        r.satelliteStateChangeListener.onSatelliteEnabledStateChanged(this.mIsSatelliteEnabled.get());     // Catch: Throwable -> L9 RemoteException -> L17
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void removeSatelliteStateChangeListener(ISatelliteStateChangeListener listener, String pkg) {
        this.mAppOps.checkPackage(Binder.getCallingUid(), pkg);
        enforceCallingOrSelfAtLeastReadBasicPhoneStatePermission(pkg, null, "removeSatelliteStateChangeListener");
        remove(listener.asBinder());
    }

    public void notifySatelliteStateChanged(boolean isEnabled) {
        if (checkNotifyPermission("notifySatelliteStateChanged") == true) goto L6;
        loge("notifySatelliteStateChanged: Caller has no notify permission!");
        return;
    L6:
        this.mWasSatelliteEnabledNotified.set(true);
        this.mIsSatelliteEnabled.set(isEnabled);
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        this.mRemoveList.clear();     // Catch: Throwable -> L16
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L16
    L10:
        if (r1.hasNext() == false) goto L21;
        Record r = r1.next();     // Catch: Throwable -> L16
        if (r.matchSatelliteStateChangeListener() == false) goto L10;
        r.satelliteStateChangeListener.onSatelliteEnabledStateChanged(isEnabled);     // Catch: Throwable -> L16 RemoteException -> L18
    L19:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L16
        goto L10
    L21:
        handleRemoveListLocked();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void notifyMediaQualityStatusChanged(int phoneId, int subId, MediaQualityStatus status) {
        if (checkNotifyPermission("notifyMediaQualityStatusChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == true) goto L10;
    L44:
        handleRemoveListLocked();     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L10:
        if (this.mCallStateLists.get(phoneId).size() <= 0) goto L32;
        CallState callState = null;
        Iterator<CallState> r2 = this.mCallStateLists.get(phoneId).iterator();     // Catch: Throwable -> L18
    L13:
        if (r2.hasNext() == false) goto L20;
        CallState cs = r2.next();     // Catch: Throwable -> L18
        if (cs.getCallState() != 1) goto L13;
        callState = cs;
    L20:
        if (callState == null) goto L29;
        String callSessionId = callState.getImsCallSessionId();     // Catch: Throwable -> L18
        if (callSessionId != null) goto L24;
    L26:
        log("SessionId mismatch active call:" + callSessionId + " media quality:" + status.getCallSessionId());     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L24:
        if (callSessionId.equals(status.getCallSessionId()) == false) goto L26;
        this.mMediaQualityStatus.get(phoneId).put(status.getMediaSessionType(), status);     // Catch: Throwable -> L18
        goto L32
    L29:
        log("There is no active call to report CallQaulity");     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L32:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L18
    L34:
        if (r1.hasNext() == false) goto L44;
        Record r = r1.next();     // Catch: Throwable -> L18
        if (r.matchTelephonyCallbackEvent(39) == false) goto L34;
        if (idMatch(r, subId, phoneId) == false) goto L34;
        r.callback.onMediaQualityStatusChanged(status);     // Catch: Throwable -> L18 RemoteException -> L41
    L42:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L18
        goto L34
    }

    public void notifyCallbackModeStarted(int phoneId, int subId, int type, long durationMillis) {
        if (checkNotifyPermission("notifyCallbackModeStarted()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == true) goto L10;
    L17:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L19:
        if (r1.hasNext() == false) goto L27;
        Record r = r1.next();     // Catch: Throwable -> L12
        if (r.matchTelephonyCallbackEvent(40) == false) goto L19;
        r.callback.onCallbackModeStarted(type, durationMillis, subId);     // Catch: Throwable -> L12 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
        goto L19
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L12
        handleRemoveListLocked();
        return;
    L10:
        if (type != 1) goto L15;
        this.mECBMDuration[phoneId] = durationMillis;     // Catch: Throwable -> L12
        goto L17
    L15:
        if (type != 2) goto L17;
        this.mSCBMDuration[phoneId] = durationMillis;     // Catch: Throwable -> L12
        goto L17
    }

    public void notifyCallbackModeRestarted(int phoneId, int subId, int type, long durationMillis) {
        if (checkNotifyPermission("notifyCallbackModeRestarted()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == true) goto L10;
    L17:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L19:
        if (r1.hasNext() == false) goto L27;
        Record r = r1.next();     // Catch: Throwable -> L12
        if (r.matchTelephonyCallbackEvent(40) == false) goto L19;
        r.callback.onCallbackModeRestarted(type, durationMillis, subId);     // Catch: Throwable -> L12 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
        goto L19
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L12
        handleRemoveListLocked();
        return;
    L10:
        if (type != 1) goto L15;
        this.mECBMDuration[phoneId] = durationMillis;     // Catch: Throwable -> L12
        goto L17
    L15:
        if (type != 2) goto L17;
        this.mSCBMDuration[phoneId] = durationMillis;     // Catch: Throwable -> L12
        goto L17
    }

    public void notifyCallbackModeStopped(int phoneId, int subId, int type, int reason) {
        if (checkNotifyPermission("notifyCallbackModeStopped()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == true) goto L10;
    L17:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L19:
        if (r1.hasNext() == false) goto L27;
        Record r = r1.next();     // Catch: Throwable -> L12
        if (r.matchTelephonyCallbackEvent(40) == false) goto L19;
        r.callback.onCallbackModeStopped(type, reason, subId);     // Catch: Throwable -> L12 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
        goto L19
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L12
        handleRemoveListLocked();
        return;
    L10:
        if (type != 1) goto L15;
        this.mECBMReason[phoneId] = reason;     // Catch: Throwable -> L12
        this.mECBMDuration[phoneId] = 0;     // Catch: Throwable -> L12
        goto L17
    L15:
        if (type != 2) goto L17;
        this.mSCBMReason[phoneId] = reason;     // Catch: Throwable -> L12
        this.mSCBMDuration[phoneId] = 0;     // Catch: Throwable -> L12
        goto L17
    }

    public void notifyCarrierRoamingNtnModeChanged(int subId, boolean active) {
        if (checkNotifyPermission("notifyCarrierRoamingNtnModeChanged") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int phoneId = getPhoneIdFromSubId(subId);     // Catch: Throwable -> L12
        if (validatePhoneId(phoneId) == true) goto L14;
        loge("Invalid phone ID " + phoneId + " for " + subId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        this.mCarrierRoamingNtnMode[phoneId] = active;     // Catch: Throwable -> L12
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L12
    L16:
        if (r2.hasNext() == false) goto L26;
        Record r = r2.next();     // Catch: Throwable -> L12
        if (r.matchTelephonyCallbackEvent(42) == false) goto L16;
        if (idMatch(r, subId, phoneId) == false) goto L16;
        r.callback.onCarrierRoamingNtnModeChanged(active);     // Catch: Throwable -> L12 RemoteException -> L23
    L24:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L12
        goto L16
    L26:
        handleRemoveListLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void notifyCarrierRoamingNtnEligibleStateChanged(int subId, boolean eligible) {
        if (checkNotifyPermission("notifyCarrierRoamingNtnEligibleStateChanged") == true) goto L6;
        log("notifyCarrierRoamingNtnEligibleStateChanged: caller does not have required permissions.");
        return;
    L6:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int phoneId = getPhoneIdFromSubId(subId);     // Catch: Throwable -> L13
        if (validatePhoneId(phoneId) == true) goto L15;
        loge("Invalid phone ID " + phoneId + " for " + subId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        this.mCarrierRoamingNtnEligible[phoneId] = eligible;     // Catch: Throwable -> L13
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r2.hasNext() == false) goto L27;
        Record r = r2.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(43) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        r.callback.onCarrierRoamingNtnEligibleStateChanged(eligible);     // Catch: Throwable -> L13 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
        goto L17
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void notifyCarrierRoamingNtnAvailableServicesChanged(int subId, int[] availableServices) {
        if (checkNotifyPermission("notifyCarrierRoamingNtnEligibleStateChanged") == true) goto L6;
        log("notifyCarrierRoamingNtnAvailableServicesChanged: caller does not have required permissions.");
        return;
    L6:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int phoneId = getPhoneIdFromSubId(subId);     // Catch: Throwable -> L13
        if (validatePhoneId(phoneId) == true) goto L15;
        loge("Invalid phone ID " + phoneId + " for " + subId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        IntArray availableServicesIntArray = new IntArray(availableServices.length);     // Catch: Throwable -> L13
        availableServicesIntArray.addAll(availableServices);     // Catch: Throwable -> L13
        this.mCarrierRoamingNtnAvailableServices.set(phoneId, availableServicesIntArray);     // Catch: Throwable -> L13
        Iterator<Record> r3 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r3.hasNext() == false) goto L27;
        Record r = r3.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(44) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        r.callback.onCarrierRoamingNtnAvailableServicesChanged(availableServices);     // Catch: Throwable -> L13 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
        goto L17
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void notifyCarrierRoamingNtnSignalStrengthChanged(int subId, NtnSignalStrength ntnSignalStrength) {
        if (checkNotifyPermission("notifyCarrierRoamingNtnSignalStrengthChanged") == true) goto L6;
        log("notifyCarrierRoamingNtnSignalStrengthChanged: caller does not have required permissions.");
        return;
    L6:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
        int phoneId = getPhoneIdFromSubId(subId);     // Catch: Throwable -> L17
        this.mCarrierRoamingNtnSignalStrength[phoneId] = ntnSignalStrength;     // Catch: Throwable -> L17
        Iterator<Record> r2 = this.mRecords.iterator();     // Catch: Throwable -> L17
    L10:
        if (r2.hasNext() == false) goto L22;
        Record r = r2.next();     // Catch: Throwable -> L17
        if (r.matchTelephonyCallbackEvent(45) == false) goto L10;
        if (idMatch(r, subId, phoneId) == false) goto L10;
        r.callback.onCarrierRoamingNtnSignalStrengthChanged(ntnSignalStrength);     // Catch: Throwable -> L17 RemoteException -> L19
    L20:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L17
        goto L10
    L22:
        handleRemoveListLocked();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void notifySecurityAlgorithmsChanged(int phoneId, int subId, SecurityAlgorithmUpdate update) {
        if (checkNotifyPermission("notifySecurityAlgorithmChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L27;
        if (update != null) goto L15;
        loge("SecurityAlgorithmUpdate is null, subId=" + subId + ", phoneId=" + phoneId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r1.hasNext() == false) goto L27;
        Record r = r1.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(46) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        r.callback.onSecurityAlgorithmsChanged(update);     // Catch: Throwable -> L13 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void notifyCellularIdentifierDisclosedChanged(int phoneId, int subId, CellularIdentifierDisclosure disclosure) {
        if (checkNotifyPermission("notifyCellularIdentifierDisclosedChanged()") == true) goto L5;
        return;
    L5:
        ArrayList<Record> r0 = this.mRecords;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (validatePhoneId(phoneId) == false) goto L27;
        if (disclosure != null) goto L15;
        loge("CellularIdentifierDisclosure is null, subId=" + subId + ", phoneId=" + phoneId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        Iterator<Record> r1 = this.mRecords.iterator();     // Catch: Throwable -> L13
    L17:
        if (r1.hasNext() == false) goto L27;
        Record r = r1.next();     // Catch: Throwable -> L13
        if (r.matchTelephonyCallbackEvent(47) == false) goto L17;
        if (idMatch(r, subId, phoneId) == false) goto L17;
        r.callback.onCellularIdentifierDisclosedChanged(disclosure);     // Catch: Throwable -> L13 RemoteException -> L24
    L25:
        this.mRemoveList.add(r.binder);     // Catch: Throwable -> L13
    L27:
        handleRemoveListLocked();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @NeverCompile
    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        ArrayList<Record> r1 = this.mRecords;
        monitor-enter(r1);
        int recordCount = this.mRecords.size();     // Catch: Throwable -> L11
        pw.println("last known state:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= getTelephonyManager().getActiveModemCount()) goto L13;
        pw.println("Phone Id=" + i);     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        pw.println("mCallState=" + this.mCallState[i]);     // Catch: Throwable -> L11
        pw.println("mRingingCallState=" + this.mRingingCallState[i]);     // Catch: Throwable -> L11
        pw.println("mForegroundCallState=" + this.mForegroundCallState[i]);     // Catch: Throwable -> L11
        pw.println("mBackgroundCallState=" + this.mBackgroundCallState[i]);     // Catch: Throwable -> L11
        pw.println("mPreciseCallState=" + this.mPreciseCallState[i]);     // Catch: Throwable -> L11
        pw.println("mCallDisconnectCause=" + this.mCallDisconnectCause[i]);     // Catch: Throwable -> L11
        pw.println("mCallIncomingNumber=" + this.mCallIncomingNumber[i]);     // Catch: Throwable -> L11
        pw.println("mServiceState=" + this.mServiceState[i]);     // Catch: Throwable -> L11
        pw.println("mVoiceActivationState= " + this.mVoiceActivationState[i]);     // Catch: Throwable -> L11
        pw.println("mDataActivationState= " + this.mDataActivationState[i]);     // Catch: Throwable -> L11
        pw.println("mUserMobileDataState= " + this.mUserMobileDataState[i]);     // Catch: Throwable -> L11
        pw.println("mSignalStrength=" + this.mSignalStrength[i]);     // Catch: Throwable -> L11
        pw.println("mMessageWaiting=" + this.mMessageWaiting[i]);     // Catch: Throwable -> L11
        pw.println("mCallForwarding=" + this.mCallForwarding[i]);     // Catch: Throwable -> L11
        pw.println("mDataActivity=" + this.mDataActivity[i]);     // Catch: Throwable -> L11
        pw.println("mDataConnectionState=" + this.mDataConnectionState[i]);     // Catch: Throwable -> L11
        pw.println("mCellIdentity=" + this.mCellIdentity[i]);     // Catch: Throwable -> L11
        pw.println("mCellInfo=" + this.mCellInfo.get(i));     // Catch: Throwable -> L11
        pw.println("mImsCallDisconnectCause=" + this.mImsReasonInfo.get(i));     // Catch: Throwable -> L11
        pw.println("mSrvccState=" + this.mSrvccState[i]);     // Catch: Throwable -> L11
        pw.println("mCallPreciseDisconnectCause=" + this.mCallPreciseDisconnectCause[i]);     // Catch: Throwable -> L11
        pw.println("mCallQuality=" + this.mCallQuality[i]);     // Catch: Throwable -> L11
        pw.println("mCallNetworkType=" + this.mCallNetworkType[i]);     // Catch: Throwable -> L11
        pw.println("mPreciseDataConnectionStates=" + this.mPreciseDataConnectionStates.get(i));     // Catch: Throwable -> L11
        pw.println("mOutgoingCallEmergencyNumber=" + this.mOutgoingCallEmergencyNumber[i]);     // Catch: Throwable -> L11
        pw.println("mOutgoingSmsEmergencyNumber=" + this.mOutgoingSmsEmergencyNumber[i]);     // Catch: Throwable -> L11
        pw.println("mBarringInfo=" + this.mBarringInfo.get(i));     // Catch: Throwable -> L11
        pw.println("mCarrierNetworkChangeState=" + this.mCarrierNetworkChangeState[i]);     // Catch: Throwable -> L11
        pw.println("mTelephonyDisplayInfo=" + this.mTelephonyDisplayInfos[i]);     // Catch: Throwable -> L11
        pw.println("mIsDataEnabled=" + this.mIsDataEnabled[i]);     // Catch: Throwable -> L11
        pw.println("mDataEnabledReason=" + this.mDataEnabledReason[i]);     // Catch: Throwable -> L11
        pw.println("mAllowedNetworkTypeReason=" + this.mAllowedNetworkTypeReason[i]);     // Catch: Throwable -> L11
        pw.println("mAllowedNetworkTypeValue=" + this.mAllowedNetworkTypeValue[i]);     // Catch: Throwable -> L11
        pw.println("mPhysicalChannelConfigs=" + this.mPhysicalChannelConfigs.get(i));     // Catch: Throwable -> L11
        pw.println("mLinkCapacityEstimateList=" + this.mLinkCapacityEstimateLists.get(i));     // Catch: Throwable -> L11
        pw.println("mECBMReason=" + this.mECBMReason[i]);     // Catch: Throwable -> L11
        pw.println("mECBMDuration=" + this.mECBMDuration[i]);     // Catch: Throwable -> L11
        pw.println("mSCBMReason=" + this.mSCBMReason[i]);     // Catch: Throwable -> L11
        pw.println("mSCBMDuration=" + this.mSCBMDuration[i]);     // Catch: Throwable -> L11
        pw.println("mCarrierRoamingNtnMode=" + this.mCarrierRoamingNtnMode[i]);     // Catch: Throwable -> L11
        pw.println("mCarrierRoamingNtnEligible=" + this.mCarrierRoamingNtnEligible[i]);     // Catch: Throwable -> L11
        pw.println("mCarrierRoamingNtnSignalStrength=" + this.mCarrierRoamingNtnSignalStrength[i]);     // Catch: Throwable -> L11
        Pair<List<String>, int[]> carrierPrivilegeState = this.mCarrierPrivilegeStates.get(i);     // Catch: Throwable -> L11
        pw.println("mCarrierPrivilegeState=<packages=" + pii((List) carrierPrivilegeState.first) + ", uids=" + Arrays.toString((int[]) carrierPrivilegeState.second) + ">");     // Catch: Throwable -> L11
        Pair<String, Integer> carrierServiceState = this.mCarrierServiceStates.get(i);     // Catch: Throwable -> L11
        pw.println("mCarrierServiceState=<package=" + pii((String) carrierServiceState.first) + ", uid=" + carrierServiceState.second + ">");     // Catch: Throwable -> L11
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L11
        r6.append("mCarrierRoamingNtnAvailableServices=");     // Catch: Throwable -> L11
        r6.append(this.mCarrierRoamingNtnAvailableServices.get(i));     // Catch: Throwable -> L11
        pw.println(r6.toString());     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.println("mPhoneCapability=" + this.mPhoneCapability);     // Catch: Throwable -> L11
        pw.println("mActiveDataSubId=" + this.mActiveDataSubId);     // Catch: Throwable -> L11
        pw.println("mRadioPowerState=" + this.mRadioPowerState);     // Catch: Throwable -> L11
        pw.println("mEmergencyNumberList=" + this.mEmergencyNumberList);     // Catch: Throwable -> L11
        pw.println("mDefaultPhoneId=" + this.mDefaultPhoneId);     // Catch: Throwable -> L11
        pw.println("mDefaultSubId=" + this.mDefaultSubId);     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("local logs:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        this.mLocalLog.dump(fd, pw, args);     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("listen logs:");     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        this.mListenLog.dump(fd, pw, args);     // Catch: Throwable -> L11
        pw.decreaseIndent();     // Catch: Throwable -> L11
        pw.println("registrations: count=" + recordCount);     // Catch: Throwable -> L11
        pw.increaseIndent();     // Catch: Throwable -> L11
        Iterator<Record> r3 = this.mRecords.iterator();     // Catch: Throwable -> L11
    L15:
        if (r3.hasNext() == false) goto L17;
        Record r = r3.next();     // Catch: Throwable -> L11
        pw.println(r);     // Catch: Throwable -> L11
        goto L15
    L17:
        pw.decreaseIndent();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void broadcastServiceStateChanged(ServiceState state, int phoneId, int subId) {
        this.mBatteryStats.notePhoneState(state.getState());     // Catch: RemoteException -> L5
    L7:
        if (LocationAccessPolicy.isLocationModeEnabled(this.mContext, this.mContext.getUserId()) == false) goto L9;
        Intent fullIntent = createServiceStateIntent(state, subId, phoneId, false);
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(fullIntent, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"}, createServiceStateBroadcastOptions(subId, phoneId, "I:RA"));
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(fullIntent, new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"}, new String[]{"android.permission.READ_PHONE_STATE"}, null, createServiceStateBroadcastOptions(subId, phoneId, "I:RPA,E:R"));
        Intent sanitizedIntent = createServiceStateIntent(state, subId, phoneId, true);
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(sanitizedIntent, new String[]{"android.permission.READ_PHONE_STATE"}, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, null, createServiceStateBroadcastOptions(subId, phoneId, "I:R,E:A"));
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(sanitizedIntent, new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE"}, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_FINE_LOCATION"}, null, createServiceStateBroadcastOptions(subId, phoneId, "I:RP,E:RA"));
        return;
    L9:
        String[] locationBypassPackages = (String[]) Binder.withCleanCallingIdentity(new TelephonyRegistry$$ExternalSyntheticLambda0(this));
        int r0 = locationBypassPackages.length;
        int r9 = 0;
    L10:
        if (r9 >= r0) goto L12;
        String locationBypassPackage = locationBypassPackages[r9];
        Intent fullIntent2 = createServiceStateIntent(state, subId, phoneId, false);
        fullIntent2.setPackage(locationBypassPackage);
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(fullIntent2, new String[]{"android.permission.READ_PHONE_STATE"}, createServiceStateBroadcastOptions(subId, phoneId, "I:R"));
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(fullIntent2, new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE"}, new String[]{"android.permission.READ_PHONE_STATE"}, null, createServiceStateBroadcastOptions(subId, phoneId, "I:RP,E:R"));
        r9 = r9 + 1;
        goto L10
    L12:
        Intent sanitizedIntent2 = createServiceStateIntent(state, subId, phoneId, true);
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(sanitizedIntent2, new String[]{"android.permission.READ_PHONE_STATE"}, new String[0], locationBypassPackages, createServiceStateBroadcastOptions(subId, phoneId, "I:R,lbp"));
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(sanitizedIntent2, new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE"}, new String[]{"android.permission.READ_PHONE_STATE"}, locationBypassPackages, createServiceStateBroadcastOptions(subId, phoneId, "I:RP,E:R,lbp"));
    }

    private /* synthetic */ String[] lambda$broadcastServiceStateChanged$1() throws Exception {
        return LocationAccessPolicy.getLocationBypassPackages(this.mContext);
    }

    private Intent createServiceStateIntent(ServiceState state, int subId, int phoneId, boolean sanitizeLocation) {
        Intent intent = new Intent("android.intent.action.SERVICE_STATE");
        intent.addFlags(16777216);
        Bundle data = new Bundle();
        if (sanitizeLocation == false) goto L5;
        state.createLocationInfoSanitizedCopy(true).fillInNotifierBundle(data);
    L6:
        intent.putExtras(data);
        intent.putExtra(PHONE_CONSTANTS_SUBSCRIPTION_KEY, subId);
        intent.putExtra("android.telephony.extra.SUBSCRIPTION_INDEX", subId);
        intent.putExtra(PHONE_CONSTANTS_SLOT_KEY, phoneId);
        intent.putExtra("android.telephony.extra.SLOT_INDEX", phoneId);
        return intent;
    L5:
        state.fillInNotifierBundle(data);
        goto L6
    }

    private BroadcastOptions createServiceStateBroadcastOptions(int subId, int phoneId, String tag) {
        return new BroadcastOptions().setDeliveryGroupPolicy(1).setDeliveryGroupMatchingKey("android.intent.action.SERVICE_STATE", subId + "-" + phoneId + "-" + tag).setDeferralPolicy(2);
    }

    private void broadcastRadioPowerStateChanged(int state, int phoneId, int subId) {
        Intent intent = new Intent(ACTION_RADIO_POWER_STATE_CHANGED);
        intent.addFlags(16777216);
        intent.putExtra(PHONE_CONSTANTS_SUBSCRIPTION_KEY, subId);
        intent.putExtra("android.telephony.extra.SUBSCRIPTION_INDEX", subId);
        intent.putExtra(PHONE_CONSTANTS_SLOT_KEY, phoneId);
        intent.putExtra("android.telephony.extra.SLOT_INDEX", phoneId);
        intent.putExtra("state", state);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.READ_PRIVILEGED_PHONE_STATE");
    }

    private void broadcastSignalStrengthChanged(SignalStrength signalStrength, int phoneId, int subId) {
        long ident = Binder.clearCallingIdentity();
        this.mBatteryStats.notePhoneSignalStrength(signalStrength);     // Catch: Throwable -> L5 RemoteException -> L7
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L4:
        Binder.restoreCallingIdentity(ident);
        Intent intent = new Intent(ACTION_SIGNAL_STRENGTH_CHANGED);
        Bundle data = new Bundle();
        fillInSignalStrengthNotifierBundle(signalStrength, data);
        intent.putExtras(data);
        intent.putExtra(PHONE_CONSTANTS_SUBSCRIPTION_KEY, subId);
        intent.putExtra(PHONE_CONSTANTS_SLOT_KEY, phoneId);
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);
    }

    private void fillInSignalStrengthNotifierBundle(SignalStrength signalStrength, Bundle bundle) {
        List<CellSignalStrength> cellSignalStrengths = signalStrength.getCellSignalStrengths();
        Iterator<CellSignalStrength> r1 = cellSignalStrengths.iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        CellSignalStrength cellSignalStrength = r1.next();
        if ((cellSignalStrength instanceof CellSignalStrengthLte) == true) goto L7;
        if ((cellSignalStrength instanceof CellSignalStrengthCdma) == true) goto L10;
        if ((cellSignalStrength instanceof CellSignalStrengthGsm) == true) goto L13;
        if ((cellSignalStrength instanceof CellSignalStrengthWcdma) == true) goto L16;
        if ((cellSignalStrength instanceof CellSignalStrengthTdscdma) == true) goto L19;
        if ((cellSignalStrength instanceof CellSignalStrengthNr) == false) goto L4;
        bundle.putParcelable("Nr", (CellSignalStrengthNr) cellSignalStrength);
        goto L4
    L19:
        bundle.putParcelable("Tdscdma", (CellSignalStrengthTdscdma) cellSignalStrength);
        goto L4
    L16:
        bundle.putParcelable("Wcdma", (CellSignalStrengthWcdma) cellSignalStrength);
        goto L4
    L13:
        bundle.putParcelable("Gsm", (CellSignalStrengthGsm) cellSignalStrength);
        goto L4
    L10:
        bundle.putParcelable("Cdma", (CellSignalStrengthCdma) cellSignalStrength);
        goto L4
    L7:
        bundle.putParcelable("Lte", (CellSignalStrengthLte) cellSignalStrength);
        goto L4
    }

    private void broadcastCallStateChanged(int state, String incomingNumber, int phoneId, int subId) {
        long ident = Binder.clearCallingIdentity();
        if (state != 0) goto L9;
        this.mBatteryStats.notePhoneOff();     // Catch: Throwable -> L5 RemoteException -> L7
        FrameworkStatsLog.write(95, 0);     // Catch: Throwable -> L5 RemoteException -> L7
    L20:
        goto L10
    L9:
        this.mBatteryStats.notePhoneOn();     // Catch: Throwable -> L5 RemoteException -> L7
        FrameworkStatsLog.write(95, 1);     // Catch: Throwable -> L5 RemoteException -> L7
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L10:
        Binder.restoreCallingIdentity(ident);
        Intent intent = new Intent("android.intent.action.PHONE_STATE");
        intent.putExtra("state", callStateToString(state));
        if (subId == (-1)) goto L16;
        intent.setAction(ACTION_SUBSCRIPTION_PHONE_STATE_CHANGED);
        intent.putExtra(PHONE_CONSTANTS_SUBSCRIPTION_KEY, subId);
        intent.putExtra("android.telephony.extra.SUBSCRIPTION_INDEX", subId);
    L16:
        if (phoneId == (-1)) goto L18;
        intent.putExtra(PHONE_CONSTANTS_SLOT_KEY, phoneId);
        intent.putExtra("android.telephony.extra.SLOT_INDEX", phoneId);
    L18:
        intent.addFlags(16777216);
        Intent intentWithPhoneNumber = new Intent(intent);
        intentWithPhoneNumber.putExtra("incoming_number", incomingNumber);
        this.mContext.sendBroadcastAsUser(intentWithPhoneNumber, UserHandle.ALL, "android.permission.READ_PRIVILEGED_PHONE_STATE");
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.READ_PHONE_STATE", 51);
        this.mContext.sendBroadcastAsUserMultiplePermissions(intentWithPhoneNumber, UserHandle.ALL, new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CALL_LOG"});
    }

    private static String callStateToString(int callState) {
        switch(callState) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        return TelephonyManager.EXTRA_STATE_IDLE;
    L6:
        return TelephonyManager.EXTRA_STATE_OFFHOOK;
    L8:
        return TelephonyManager.EXTRA_STATE_RINGING;
    }

    private void broadcastDataConnectionStateChanged(int slotIndex, int subId, PreciseDataConnectionState pdcs) {
        Intent intent = new Intent(ACTION_ANY_DATA_CONNECTION_STATE_CHANGED);
        intent.putExtra("state", TelephonyUtils.dataStateToString(pdcs.getState()));
        intent.putExtra(PHONE_CONSTANTS_DATA_APN_KEY, pdcs.getApnSetting().getApnName());
        intent.putExtra(PHONE_CONSTANTS_DATA_APN_TYPE_KEY, getApnTypesStringFromBitmask(pdcs.getApnSetting().getApnTypeBitmask()));
        intent.putExtra(PHONE_CONSTANTS_SLOT_KEY, slotIndex);
        intent.putExtra(PHONE_CONSTANTS_SUBSCRIPTION_KEY, subId);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.READ_PHONE_STATE");
        this.mContext.createContextAsUser(UserHandle.ALL, 0).sendBroadcastMultiplePermissions(intent, new String[]{"android.permission.READ_PRIVILEGED_PHONE_STATE"}, new String[]{"android.permission.READ_PHONE_STATE"});
    }

    public static String getApnTypesStringFromBitmask(int apnTypeBitmask) {
        List<String> types = new ArrayList();
        int remainingApnTypes = apnTypeBitmask;
        if ((remainingApnTypes & 17) != 17) goto L5;
        types.add("default");
        remainingApnTypes = remainingApnTypes & (-18);
    L5:
        if (remainingApnTypes == 0) goto L11;
        int highestApnTypeBit = Integer.highestOneBit(remainingApnTypes);
        String apnString = ApnSetting.getApnTypeString(highestApnTypeBit);
        if (TextUtils.isEmpty(apnString) == true) goto L9;
        types.add(apnString);
    L9:
        remainingApnTypes = remainingApnTypes & (~highestApnTypeBit);
        goto L5
    L11:
        return TextUtils.join(",", types);
    }

    private void enforceNotifyPermissionOrCarrierPrivilege(String method) {
        if (checkNotifyPermission() == false) goto L5;
        return;
    L5:
        TelephonyPermissions.enforceCallingOrSelfCarrierPrivilege(this.mContext, SubscriptionManager.getDefaultSubscriptionId(), method);
    }

    private boolean checkNotifyPermission(String method) {
        if (checkNotifyPermission() == false) goto L6;
        return true;
    L6:
        String r0 = "Modify Phone State Permission Denial: " + method + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
        return false;
    }

    private boolean checkNotifyPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean checkListenerPermission(Set<Integer> events, int subId, String callingPackage, String callingFeatureId, String message) {
        boolean isPermissionCheckSuccessful = true;
        if (isLocationPermissionRequired(events) == false) goto L11;
        LocationAccessPolicy.LocationPermissionQuery.Builder locationQueryBuilder = new LocationAccessPolicy.LocationPermissionQuery.Builder().setCallingPackage(callingPackage).setCallingFeatureId(callingFeatureId).setMethod(message + " events: " + events).setCallingPid(Binder.getCallingPid()).setCallingUid(Binder.getCallingUid());
        locationQueryBuilder.setMinSdkVersionForFine(29);
        locationQueryBuilder.setMinSdkVersionForCoarse(0);
        locationQueryBuilder.setMinSdkVersionForEnforcement(0);
        LocationAccessPolicy.LocationPermissionResult result = LocationAccessPolicy.checkLocationPermission(this.mContext, locationQueryBuilder.build());
        switch(AnonymousClass3.$SwitchMap$android$telephony$LocationAccessPolicy$LocationPermissionResult[result.ordinal()]) {
            case 1: goto L9;
            case 2: goto L7;
            default: goto L11;
        };
    L7:
        isPermissionCheckSuccessful = false;
        goto L11
    L9:
        throw new SecurityException("Unable to listen for events " + events + " due to insufficient location permissions.");
    L11:
        if (isPhoneStatePermissionRequired(events, callingPackage, Binder.getCallingUserHandle()) == false) goto L16;
        if (TelephonyPermissions.checkCallingOrSelfReadPhoneState(this.mContext, subId, callingPackage, callingFeatureId, message) == true) goto L16;
        isPermissionCheckSuccessful = false;
    L16:
        if (isPrecisePhoneStatePermissionRequired(events) == false) goto L22;
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRECISE_PHONE_STATE", null);     // Catch: SecurityException -> L19
    L20:
        TelephonyPermissions.enforceCallingOrSelfCarrierPrivilege(this.mContext, subId, message);
    L22:
        if (isActiveEmergencySessionPermissionRequired(events) == false) goto L25;
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_ACTIVE_EMERGENCY_SESSION", null);
    L25:
        if (isPrivilegedPhoneStatePermissionRequired(events) == false) goto L27;
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", null);
    L27:
        return isPermissionCheckSuccessful;
    }

    private void handleRemoveListLocked() {
        int size = this.mRemoveList.size();
        if (size <= 0) goto L11;
        Iterator<IBinder> r1 = this.mRemoveList.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        IBinder b = r1.next();
        remove(b);
        goto L6
    L8:
        this.mRemoveList.clear();
        return;
    }

    private boolean validateEventAndUserLocked(Record r, int event) {
        long callingIdentity = Binder.clearCallingIdentity();
        int foregroundUser = ActivityManager.getCurrentUser();     // Catch: Throwable -> L8
        if (UserHandle.getUserId(r.callerUid) != foregroundUser) goto L10;
        if (r.matchTelephonyCallbackEvent(event) == false) goto L10;
        boolean valid = true;
    L11:
        Binder.restoreCallingIdentity(callingIdentity);
        return valid;
    L10:
        valid = false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    }

    private boolean validatePhoneId(int phoneId) {
        if (phoneId >= 0) goto L4;
    L6:
        return false;
    L4:
        if (phoneId >= getTelephonyManager().getActiveModemCount()) goto L6;
        return true;
    }

    private static void log(String s) {
        Rlog.d(TAG, s);
    }

    private static void loge(String s) {
        Rlog.e(TAG, s);
    }

    boolean idMatch(Record r, int subId, int phoneId) {
        if (subId >= 0) goto L9;
        if (r.phoneId == phoneId) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r.subId != Integer.MAX_VALUE) goto L15;
        if (subId == this.mDefaultSubId) goto L13;
        return false;
    L13:
        return true;
    L15:
        if (r.subId == subId) goto L17;
        return false;
    L17:
        return true;
    }

    boolean idMatchRelaxed(Record r, int subId, int phoneId) {
        if (subId >= 0) goto L14;
        if (r.phoneId != (-1)) goto L10;
        if (phoneId == 0) goto L8;
        return false;
    L8:
        return true;
    L10:
        if (r.phoneId == phoneId) goto L12;
        return false;
    L12:
        return true;
    L14:
        if (r.subId != Integer.MAX_VALUE) goto L25;
        if (r.phoneId != (-1)) goto L21;
        if (phoneId == 0) goto L19;
        return false;
    L19:
        return true;
    L21:
        if (subId == this.mDefaultSubId) goto L23;
        return false;
    L23:
        return true;
    L25:
        if (r.subId == subId) goto L27;
        return false;
    L27:
        return true;
    }

    private boolean checkFineLocationAccess(Record r) {
        return checkFineLocationAccess(r, 1);
    }

    private boolean checkCoarseLocationAccess(Record r) {
        return checkCoarseLocationAccess(r, 1);
    }

    private boolean checkFineLocationAccess(Record r, int minSdk) {
        if (r.renounceFineLocationAccess == false) goto L6;
        return false;
    L6:
        final LocationAccessPolicy.LocationPermissionQuery query = new LocationAccessPolicy.LocationPermissionQuery.Builder().setCallingPackage(r.callingPackage).setCallingFeatureId(r.callingFeatureId).setCallingPid(r.callerPid).setCallingUid(r.callerUid).setMethod("TelephonyRegistry push").setLogAsInfo(true).setMinSdkVersionForFine(minSdk).setMinSdkVersionForCoarse(minSdk).setMinSdkVersionForEnforcement(minSdk).build();
        return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$$ExternalSyntheticLambda2(this, query))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$checkFineLocationAccess$2(LocationAccessPolicy.LocationPermissionQuery query) throws Exception {
        LocationAccessPolicy.LocationPermissionResult locationResult = LocationAccessPolicy.checkLocationPermission(this.mContext, query);
        if (locationResult != LocationAccessPolicy.LocationPermissionResult.ALLOWED) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    private boolean checkCoarseLocationAccess(Record r, int minSdk) {
        if (r.renounceCoarseLocationAccess == false) goto L6;
        return false;
    L6:
        final LocationAccessPolicy.LocationPermissionQuery query = new LocationAccessPolicy.LocationPermissionQuery.Builder().setCallingPackage(r.callingPackage).setCallingFeatureId(r.callingFeatureId).setCallingPid(r.callerPid).setCallingUid(r.callerUid).setMethod("TelephonyRegistry push").setLogAsInfo(true).setMinSdkVersionForCoarse(minSdk).setMinSdkVersionForFine(Integer.MAX_VALUE).setMinSdkVersionForEnforcement(minSdk).build();
        return ((Boolean) Binder.withCleanCallingIdentity(new TelephonyRegistry$$ExternalSyntheticLambda3(this, query))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$checkCoarseLocationAccess$3(LocationAccessPolicy.LocationPermissionQuery query) throws Exception {
        LocationAccessPolicy.LocationPermissionResult locationResult = LocationAccessPolicy.checkLocationPermission(this.mContext, query);
        if (locationResult != LocationAccessPolicy.LocationPermissionResult.ALLOWED) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    private void checkPossibleMissNotify(Record r, int phoneId) {
        Set<Integer> events = r.eventList;
        if (events != null) goto L5;
    L103:
        log("checkPossibleMissNotify: events = null.");
        return;
    L5:
        if (events.isEmpty() == true) goto L103;
        if (events.contains(1) == false) goto L21;
        ServiceState ss = new ServiceState(this.mServiceState[phoneId]);     // Catch: RemoteException -> L12
        if (checkFineLocationAccess(r, 29) == false) goto L15;
        r.callback.onServiceStateChanged(ss);     // Catch: RemoteException -> L12
    L111:
    L15:
        if (checkCoarseLocationAccess(r, 29) == false) goto L17;
        r.callback.onServiceStateChanged(ss.createLocationInfoSanitizedCopy(false));     // Catch: RemoteException -> L12
        goto L111
    L17:
        r.callback.onServiceStateChanged(ss.createLocationInfoSanitizedCopy(true));     // Catch: RemoteException -> L12
    L19:
        this.mRemoveList.add(r.binder);
    L21:
        if (events.contains(9) == false) goto L31;
        if (this.mSignalStrength[phoneId] == null) goto L31;
        SignalStrength signalStrength = this.mSignalStrength[phoneId];     // Catch: RemoteException -> L26
        r.callback.onSignalStrengthsChanged(new SignalStrength(signalStrength));     // Catch: RemoteException -> L26
    L29:
        this.mRemoveList.add(r.binder);
    L31:
        if (events.contains(2) == false) goto L45;
        if (this.mSignalStrength[phoneId] == null) goto L45;
        int gsmSignalStrength = this.mSignalStrength[phoneId].getGsmSignalStrength();     // Catch: RemoteException -> L40
        IPhoneStateListener r4 = r.callback;     // Catch: RemoteException -> L40
        if (gsmSignalStrength != 99) goto L37;
        int r5 = -1;
    L38:
        r4.onSignalStrengthChanged(r5);     // Catch: RemoteException -> L40
    L37:
        r5 = gsmSignalStrength;
    L43:
        this.mRemoveList.add(r.binder);
    L45:
        if (validateEventAndUserLocked(r, 11) == false) goto L57;
        if (checkCoarseLocationAccess(r, 1) == false) goto L57;
        if (checkFineLocationAccess(r, 29) == false) goto L57;
        r.callback.onCellInfoChanged(this.mCellInfo.get(phoneId));     // Catch: RemoteException -> L52
    L55:
        this.mRemoveList.add(r.binder);
    L57:
        if (events.contains(20) == false) goto L63;
        r.callback.onUserMobileDataStateChanged(this.mUserMobileDataState[phoneId]);     // Catch: RemoteException -> L60
    L61:
        this.mRemoveList.add(r.binder);
    L63:
        if (events.contains(21) == false) goto L73;
        if (this.mTelephonyDisplayInfos[phoneId] == null) goto L73;
        r.callback.onDisplayInfoChanged(this.mTelephonyDisplayInfos[phoneId]);     // Catch: RemoteException -> L68
    L71:
        this.mRemoveList.add(r.binder);
    L73:
        if (events.contains(3) == false) goto L79;
        r.callback.onMessageWaitingIndicatorChanged(this.mMessageWaiting[phoneId]);     // Catch: RemoteException -> L76
    L77:
        this.mRemoveList.add(r.binder);
    L79:
        if (events.contains(4) == false) goto L85;
        r.callback.onCallForwardingIndicatorChanged(this.mCallForwarding[phoneId]);     // Catch: RemoteException -> L82
    L83:
        this.mRemoveList.add(r.binder);
    L85:
        if (validateEventAndUserLocked(r, 5) == false) goto L97;
        if (checkCoarseLocationAccess(r, 1) == false) goto L97;
        if (checkFineLocationAccess(r, 29) == false) goto L97;
        r.callback.onCellLocationChanged(this.mCellIdentity[phoneId]);     // Catch: RemoteException -> L92
    L95:
        this.mRemoveList.add(r.binder);
    L97:
        if (events.contains(7) == false) goto L126;
        r.callback.onDataConnectionStateChanged(this.mDataConnectionState[phoneId], this.mDataConnectionNetworkType[phoneId]);     // Catch: RemoteException -> L100
        return;
    L101:
        this.mRemoveList.add(r.binder);
        return;
    }

    private String getNetworkTypeName(int type) {
        switch(type) {
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            case 19: goto L3;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "NR";
    L7:
        return "IWLAN";
    L9:
        return "TD_SCDMA";
    L11:
        return "GSM";
    L13:
        return "HSPA+";
    L15:
        return "CDMA - eHRPD";
    L17:
        return "LTE";
    L19:
        return "CDMA - EvDo rev. B";
    L21:
        return "iDEN";
    L23:
        return "HSPA";
    L25:
        return "HSUPA";
    L27:
        return "HSDPA";
    L29:
        return "CDMA - 1xRTT";
    L31:
        return "CDMA - EvDo rev. A";
    L33:
        return "CDMA - EvDo rev. 0";
    L35:
        return "CDMA";
    L37:
        return "UMTS";
    L39:
        return "EDGE";
    L41:
        return "GPRS";
    }

    private static PreciseCallState createPreciseCallState() {
        return new PreciseCallState(-1, -1, -1, -1, -1);
    }

    private static CallQuality createCallQuality() {
        return new CallQuality(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    private int getPhoneIdFromSubId(int subId) {
        SubscriptionManager subManager = (SubscriptionManager) this.mContext.getSystemService("telephony_subscription_service");
        if (subManager != null) goto L6;
        return -1;
    L6:
        if (subId != Integer.MAX_VALUE) goto L8;
        subId = SubscriptionManager.getDefaultSubscriptionId();
    L8:
        SubscriptionInfo info = subManager.getActiveSubscriptionInfo(subId);
        if (info != null) goto L12;
        return -1;
    L12:
        return info.getSimSlotIndex();
    }

    private static String pii(String packageName) {
        if (Build.IS_DEBUGGABLE == true) goto L7;
        return "***";
    L7:
        return packageName;
    }

    private static String pii(List<String> packageNames) {
        if (packageNames.isEmpty() == true) goto L10;
        if (Build.IS_DEBUGGABLE == true) goto L10;
        return "[***, size=" + packageNames.size() + "]";
    L10:
        return packageNames.toString();
    }

    private void enforceCallingOrSelfAtLeastReadBasicPhoneStatePermission(String pkgName, String featureId, String message) {
        boolean hasReadPhoneState = false;
        SubscriptionManager sm = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (sm == null) goto L11;
        int[] r2 = sm.getActiveSubscriptionIdList();
        int r3 = r2.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        int subId = r2[r4];
        if (TelephonyPermissions.checkCallingOrSelfReadPhoneStateNoThrow(this.mContext, subId, pkgName, featureId, message) == true) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        hasReadPhoneState = true;
    L11:
        if (hasReadPhoneState == true) goto L16;
        this.mContext.enforceCallingOrSelfPermission("android.permission.READ_BASIC_PHONE_STATE", message);
        return;
    }
}
