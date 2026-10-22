package com.android.server.audio;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.IUidObserver;
import android.app.NotificationManager;
import android.app.PropertyInvalidatedCache;
import android.app.role.OnRoleHoldersChangedListener;
import android.app.role.RoleManager;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.AttributionSource;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.SensorPrivacyManager;
import android.hardware.SensorPrivacyManagerInternal;
import android.hardware.display.DisplayManager;
import android.hardware.hdmi.HdmiAudioSystemClient;
import android.hardware.hdmi.HdmiClient;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.HdmiPlaybackClient;
import android.hardware.hdmi.HdmiTvClient;
import android.hardware.input.InputManager;
import android.hidl.manager.V1_0.IServiceManager;
import android.media.AudioAttributes;
import android.media.AudioDescriptor;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioDeviceVolumeManager;
import android.media.AudioFocusInfo;
import android.media.AudioFormat;
import android.media.AudioHalVersionInfo;
import android.media.AudioManager;
import android.media.AudioManagerInternal;
import android.media.AudioMixerAttributes;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioRecordingConfiguration;
import android.media.AudioRoutesInfo;
import android.media.AudioSystem;
import android.media.BluetoothProfileConnectionInfo;
import android.media.FadeManagerConfiguration;
import android.media.IAudioDeviceVolumeDispatcher;
import android.media.IAudioFocusDispatcher;
import android.media.IAudioManagerNative;
import android.media.IAudioModeDispatcher;
import android.media.IAudioRecordChangedDispatcher;
import android.media.IAudioRoutesObserver;
import android.media.IAudioServerStateDispatcher;
import android.media.IAudioService;
import android.media.ICapturePresetDevicesRoleDispatcher;
import android.media.ICommunicationDeviceDispatcher;
import android.media.IDeviceVolumeBehaviorDispatcher;
import android.media.IDevicesForAttributesCallback;
import android.media.ILoudnessCodecUpdatesDispatcher;
import android.media.IMuteAwaitConnectionCallback;
import android.media.IPlaybackConfigDispatcher;
import android.media.IPreferredMixerAttributesDispatcher;
import android.media.IRecordingConfigDispatcher;
import android.media.IRingtonePlayer;
import android.media.ISpatializerCallback;
import android.media.ISpatializerHeadToSoundStagePoseCallback;
import android.media.ISpatializerHeadTrackerAvailableCallback;
import android.media.ISpatializerHeadTrackingModeCallback;
import android.media.ISpatializerOutputCallback;
import android.media.IStrategyNonDefaultDevicesDispatcher;
import android.media.IStrategyPreferredDevicesDispatcher;
import android.media.IStreamAliasingDispatcher;
import android.media.IVolumeController;
import android.media.LoudnessCodecInfo;
import android.media.MediaMetrics;
import android.media.PlayerBase;
import android.media.Utils;
import android.media.VolumeInfo;
import android.media.VolumePolicy;
import android.media.audiopolicy.AudioMix;
import android.media.audiopolicy.AudioMixingRule;
import android.media.audiopolicy.AudioPolicyConfig;
import android.media.audiopolicy.AudioProductStrategy;
import android.media.audiopolicy.AudioVolumeGroup;
import android.media.audiopolicy.IAudioPolicyCallback;
import android.media.audiopolicy.IAudioVolumeChangeDispatcher;
import android.media.permission.ClearCallingIdentityContext;
import android.media.permission.SafeCloseable;
import android.media.projection.IMediaProjection;
import android.media.projection.IMediaProjectionCallback;
import android.media.projection.IMediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.HwBinder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.PersistableBundle;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceDebugInfo;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.service.notification.ZenModeConfig;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.EventLogTags;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.UiModeManagerService;
import com.android.server.UiModeManagerService$Stub$$ExternalSyntheticLambda3;
import com.android.server.common.Constants;
import com.android.server.dispatcher.SystemVolumeUpdateDispatcher;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.permission.PermissionManagerServiceInternal;
import com.android.server.pm.pkg.PackageState;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import com.android.server.utils.PriorityDump;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class AudioService extends IAudioService.Stub implements AccessibilityManager.TouchExplorationStateChangeListener, AccessibilityManager.AccessibilityServicesStateChangeListener, AudioSystemAdapter.OnRoutingUpdatedListener, AudioSystemAdapter.OnVolRangeInitRequestListener {
    private static final String AUDIO_HAL_SERVICE_PREFIX = "android.hardware.audio";
    private static final long AUDIO_MODE_RESET_TIMEOUT_MS = 3000;
    public static final int BECOMING_NOISY_DELAY_MS = 1000;
    static final int BT_COMM_DEVICE_ACTIVE_BLE_HEADSET = 2;
    static final int BT_COMM_DEVICE_ACTIVE_BLE_SPEAKER = 4;
    static final int BT_COMM_DEVICE_ACTIVE_SCO = 1;
    private static final int CHECK_MODE_FOR_UID_PERIOD_MS = 6000;
    static final int CONNECTION_STATE_CONNECTED = 1;
    static final int CONNECTION_STATE_DISCONNECTED = 0;
    protected static final boolean DEBUG_AP = true;
    protected static final boolean DEBUG_COMM_RTE = true;
    protected static final boolean DEBUG_DEVICES = true;
    protected static final boolean DEBUG_LOG_SOUND_FX = true;
    protected static final boolean DEBUG_MODE = true;
    protected static final boolean DEBUG_SCO = true;
    protected static final boolean DEBUG_VOL = true;
    private static final byte[] DEFAULT_ARC_AUDIO_DESCRIPTOR = null;
    private static final int DEFAULT_STREAM_TYPE_OVERRIDE_DELAY_MS = 0;
    protected static int DEFAULT_VOL_STREAM_NO_PLAYBACK = 0;
    private static final Set<Integer> DEVICE_MEDIA_UNMUTED_ON_PLUG_SET = null;
    private static final int FLAG_ADJUST_VOLUME = 1;
    private static final int INDICATE_SYSTEM_READY_RETRY_DELAY_MS = 1000;
    private static final String KEY_AUDIO_ATTRIBUTES = "audio_attributes";
    private static final String KEY_AUDIO_MIXER_ATTRIBUTES = "audio_mixer_attributes";
    static final int LOG_NB_EVENTS_DEVICE_CONNECTION = 200;
    static final int LOG_NB_EVENTS_DYN_POLICY = 10;
    static final int LOG_NB_EVENTS_FORCE_USE = 20;
    static final int LOG_NB_EVENTS_HARDENING = 50;
    static final int LOG_NB_EVENTS_LIFECYCLE = 20;
    static final int LOG_NB_EVENTS_LOUDNESS_CODEC = 30;
    static final int LOG_NB_EVENTS_PHONE_STATE = 20;
    static final int LOG_NB_EVENTS_SOUND_DOSE = 50;
    static final int LOG_NB_EVENTS_SPATIAL = 30;
    static final int LOG_NB_EVENTS_VOLUME = 100;
    protected static int[] MAX_STREAM_VOLUME = null;
    protected static final float MIN_ALARM_ATTENUATION_NON_PRIVILEGED_DB = -36.0f;
    protected static int[] MIN_STREAM_VOLUME = null;
    private static final int MSG_ACCESSORY_PLUG_MEDIA_UNMUTE = 21;
    private static final int MSG_ADD_ASSISTANT_SERVICE_UID = 44;
    private static final int MSG_APPLY_INPUT_GAIN_INDEX = 105;
    private static final int MSG_AUDIO_SERVER_DIED = 4;
    private static final int MSG_BROADCAST_MASTER_MUTE = 55;
    private static final int MSG_BROADCAST_MICROPHONE_MUTE = 30;
    private static final int MSG_BT_COMM_DEVICE_ACTIVE_UPDATE = 57;
    private static final int MSG_BT_DEV_CHANGED = 38;
    private static final int MSG_CHECK_MODE_FOR_UID = 31;
    private static final int MSG_CONFIGURATION_CHANGED = 54;
    private static final int MSG_DISABLE_AUDIO_FOR_UID = 100;
    private static final int MSG_DISPATCH_AUDIO_MODE = 40;
    private static final int MSG_DISPATCH_AUDIO_SERVER_STATE = 23;
    private static final int MSG_DISPATCH_DEVICE_VOLUME_BEHAVIOR = 47;
    private static final int MSG_DISPATCH_PREFERRED_MIXER_ATTRIBUTES = 52;
    private static final int MSG_DYN_POLICY_MIX_STATE_UPDATE = 19;
    private static final int MSG_ENABLE_SURROUND_FORMATS = 24;
    private static final int MSG_FOLD_UPDATE = 49;
    private static final int MSG_HDMI_VOLUME_CHECK = 28;
    private static final int MSG_INDICATE_SYSTEM_READY = 20;
    private static final int MSG_INIT_ADI_DEVICE_STATES = 103;
    private static final int MSG_INIT_HEADTRACKING_SENSORS = 42;
    private static final int MSG_INIT_INPUT_GAINS = 104;
    private static final int MSG_INIT_SPATIALIZER = 102;
    private static final int MSG_INIT_STREAMS_VOLUMES = 101;
    private static final int MSG_LOAD_SOUND_EFFECTS = 7;
    private static final int MSG_NOTIFY_VOL_EVENT = 22;
    private static final int MSG_NO_LOG_FOR_PLAYER_I = 51;
    private static final int MSG_OBSERVE_DEVICES_FOR_ALL_STREAMS = 27;
    private static final int MSG_PERSIST_INPUT_GAIN_INDEX = 106;
    private static final int MSG_PERSIST_RINGER_MODE = 3;
    private static final int MSG_PERSIST_VOLUME = 1;
    private static final int MSG_PERSIST_VOLUME_GROUP = 2;
    private static final int MSG_PLAYBACK_CONFIG_CHANGE = 29;
    private static final int MSG_PLAY_SOUND_EFFECT = 5;
    private static final int MSG_RECORDING_CONFIG_CHANGE = 37;
    private static final int MSG_REINIT_VOLUMES = 34;
    private static final int MSG_REMOVE_ASSISTANT_SERVICE_UID = 45;
    private static final int MSG_RESET_SPATIALIZER = 50;
    private static final int MSG_ROTATION_UPDATE = 48;
    private static final int MSG_ROUTING_UPDATED = 41;
    private static final int MSG_SET_ALL_VOLUMES = 10;
    private static final int MSG_SET_DEVICE_STREAM_VOLUME = 26;
    static final int MSG_SET_DEVICE_VOLUME = 0;
    private static final int MSG_SET_FORCE_USE = 8;
    private static final int MSG_STREAM_DEVICES_CHANGED = 32;
    private static final int MSG_SYSTEM_READY = 16;
    private static final int MSG_UNLOAD_SOUND_EFFECTS = 15;
    private static final int MSG_UNMUTE_STREAM_ON_SINGLE_VOL_DEVICE = 18;
    private static final int MSG_UPDATE_A11Y_SERVICE_UIDS = 35;
    private static final int MSG_UPDATE_ACTIVE_ASSISTANT_SERVICE_UID = 46;
    private static final int MSG_UPDATE_AUDIO_MODE = 36;
    private static final int MSG_UPDATE_AUDIO_MODE_SIGNAL = 39;
    private static final int MSG_UPDATE_CONTEXTUAL_VOLUMES = 56;
    private static final int MSG_UPDATE_RINGER_MODE = 25;
    private static final int MSG_UPDATE_VOLUME_STATES_FOR_DEVICE = 33;
    static final int MUSICFX_HELPER_MSG_START = 1100;
    private static final int[] NO_ACTIVE_ASSISTANT_SERVICE_UIDS = null;
    private static final int PERSIST_DELAY = 500;
    private static final String[] RINGER_MODE_NAMES = null;
    static final int SAFE_MEDIA_VOLUME_MSG_START = 1000;
    private static final int SCHEDULED_PERMISSION_UPDATE_DELAY_MS = 60;
    private static final int SCHEDULED_PERMISSION_UPDATE_LONG_DELAY_MS = 500;
    private static final int SENDMSG_NOOP = 1;
    private static final int SENDMSG_QUEUE = 2;
    private static final int SENDMSG_REPLACE = 0;
    private static final boolean SPATIAL_AUDIO_ENABLED_DEFAULT = true;
    private static final int[] STREAM_VOLUME_OPS = null;
    private static final String TAG = "AS.AudioService";
    private static final int TOUCH_EXPLORE_STREAM_TYPE_OVERRIDE_DELAY_MS = 1000;
    private static final VibrationAttributes TOUCH_VIBRATION_ATTRIBUTES = null;
    private static final int UNMUTE_STREAM_DELAY = 350;
    private static final int UNSET_INDEX = -1;
    private static final int UPDATE_CONTEXTUAL_VOLUME_DELAY_MS = 500;
    private static HashMap<String, String> mCachedParams = null;
    private static final String mMetricsId = "audio.service.";
    private static final ThreadLocal<MediaMetrics.Item> mMmi = null;
    static VolumeInfo sDefaultVolumeInfo;
    static final EventLogger sDeviceLogger = null;
    static final EventLogger sForceUseLogger = null;
    private static boolean sIndependentA11yVolume;
    static final EventLogger sLifecycleLogger = null;
    static final EventLogger sMuteLogger = null;
    protected static volatile int sRingerAndZenModeMutedStreams;
    static final EventLogger sSpatialLogger = null;
    private static int sStreamOverrideDelayMs;
    protected static SparseIntArray sStreamVolumeAlias;
    private static final SparseArray<VolumeGroupState> sVolumeGroupStates = null;
    static final EventLogger sVolumeLogger = null;
    private final int[] STREAM_VOLUME_ALIAS_DEFAULT;
    private final int[] STREAM_VOLUME_ALIAS_NONE;
    private final int[] STREAM_VOLUME_ALIAS_TELEVISION;
    private final int[] STREAM_VOLUME_ALIAS_VOICE;
    protected final AudioServiceExtProxy mASExt;
    Set<Integer> mAbsVolumeMultiModeCaseDevices;
    Map<Integer, AbsoluteVolumeDeviceInfo> mAbsoluteVolumeDeviceInfoMap;
    private final Object mAbsoluteVolumeDeviceInfoMapLock;
    private int[] mAccessibilityServiceUids;
    private final Object mAccessibilityServiceUidsLock;
    private int[] mActiveAssistantServiceUids;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AppOpsManager mAppOps;
    private final ArraySet<Integer> mAssistantUids;
    private PowerManager.WakeLock mAudioEventWakeLock;
    private AudioHandler mAudioHandler;
    private int mAudioModeResetCount;
    private final Object mAudioModeResetLock;
    private final HashMap<IBinder, AudioPolicyProxy> mAudioPolicies;
    private final AudioPolicyFacade mAudioPolicy;
    private int mAudioPolicyCounter;
    private final Executor mAudioServerLifecycleExecutor;
    private final HashMap<IBinder, AsdProxy> mAudioServerStateListeners;
    private final AudioSystemAdapter mAudioSystem;
    private final AudioSystem.ErrorCallback mAudioSystemCallback;
    private AudioSystemThread mAudioSystemThread;
    private final AudioVolumeChangeHandler mAudioVolumeChangeHandler;
    private final AudioVolumeGroupHelperBase mAudioVolumeGroupHelper;
    private volatile boolean mAvrcpAbsVolSupported;
    private final HandlerThread mBroadcastHandlerThread;
    private final AtomicInteger mBtCommDeviceActive;
    private boolean mBtScoOnByApp;
    private CacheWatcher mCacheWatcher;
    private final HashMap<Integer, Integer> mCachedAbsVolDrivingStreams;
    private final Object mCachedAbsVolDrivingStreamsLock;
    private AtomicBoolean mCameraSoundForced;
    private final ContentResolver mContentResolver;
    final Context mContext;
    private final AudioDeviceBroker mDeviceBroker;
    final RemoteCallbackList<IDeviceVolumeBehaviorDispatcher> mDeviceVolumeBehaviorDispatchers;
    private DisplayManager.DisplayListener mDisplayListener;
    private DisplayManager mDisplayManager;
    private boolean mDockAudioMediaEnabled;
    private int mDockState;
    private final AudioSystem.DynamicPolicyCallback mDynPolicyCallback;
    private final EventLogger mDynPolicyLogger;
    private String mEnabledSurroundFormats;
    private int mEncodedSurroundMode;
    private IAudioPolicyCallback mExtVolumeController;
    private final Object mExtVolumeControllerLock;
    Set<Integer> mFixedVolumeDevices;
    private ForceControlStreamClient mForceControlStreamClient;
    private final Object mForceControlStreamLock;
    Set<Integer> mFullVolumeDevices;
    private final HardeningEnforcer mHardeningEnforcer;
    private final EventLogger mHardeningLogger;
    private final boolean mHasSpatializerEffect;
    boolean mHasVibrator;
    private HdmiAudioSystemClient mHdmiAudioSystemClient;
    private boolean mHdmiCecVolumeControlEnabled;
    private final Object mHdmiClientLock;
    private MyHdmiControlStatusChangeListenerCallback mHdmiControlStatusChangeListenerCallback;
    private HdmiControlManager mHdmiManager;
    private HdmiPlaybackClient mHdmiPlaybackClient;
    private boolean mHdmiSystemAudioSupported;
    private HdmiTvClient mHdmiTvClient;
    private boolean mHomeSoundEffectEnabled;
    private InputDeviceVolumeHelper mInputDeviceVolumeHelper;
    private int mInputMethodServiceUid;
    private final Object mInputMethodServiceUidLock;
    private boolean mIsCallScreeningModeSupported;
    private final boolean mIsSingleVolume;
    private final LoudnessCodecHelper mLoudnessCodecHelper;
    private long mLoweredFromNormalToVibrateTime;
    private AtomicBoolean mMasterMute;
    private final MediaFocusControl mMediaFocusControl;
    private final AtomicBoolean mMediaPlaybackActive;
    private volatile MediaSessionManager mMediaSessionManager;
    private boolean mMicMuteFromApi;
    private boolean mMicMuteFromPrivacyToggle;
    private boolean mMicMuteFromRestrictions;
    private boolean mMicMuteFromSwitch;
    private boolean mMicMuteFromSystemCached;
    private AtomicInteger mMode;
    final RemoteCallbackList<IAudioModeDispatcher> mModeDispatchers;
    private final EventLogger mModeLogger;
    private final AtomicInteger mModeOwnerInDeviceBroker;
    private final boolean mMonitorRotation;
    private final MusicFxHelper mMusicFxHelper;
    protected int mMuteAffectedStreams;
    final RemoteCallbackList<IMuteAwaitConnectionCallback> mMuteAwaitConnectionDispatchers;
    private final Object mMuteAwaitConnectionLock;
    private int[] mMutedUsagesAwaitingConnection;
    private AudioDeviceAttributes mMutingExpectedDevice;
    private MyHdmiCecVolumeControlFeatureListener mMyHdmiCecVolumeControlFeatureListener;
    private final IAudioManagerNative mNativeShim;
    private boolean mNavigationRepeatSoundEffectsEnabled;
    private NotificationManager mNm;
    private boolean mNotifAliasRing;
    private final AudioServerPermissionProvider mPermissionProvider;
    private final int mPlatformType;
    private final IPlaybackConfigDispatcher mPlaybackActivityMonitor;
    private final PlaybackActivityMonitor mPlaybackMonitor;
    final RemoteCallbackList<IPreferredMixerAttributesDispatcher> mPrefMixerAttrDispatcher;
    private float[] mPrescaleAbsoluteVolume;
    private int mPrevVolDirection;
    private int mPrimaryAssistantUid;
    private IMediaProjectionManager mProjectionService;
    private final BroadcastReceiver mReceiver;
    private final RecordingActivityMonitor mRecordMonitor;
    private RestorableParameters mRestorableParameters;
    private int mRingerMode;
    protected int mRingerModeAffectedStreams;
    private final boolean mRingerModeAffectsAlarm;
    private AudioManagerInternal.RingerModeDelegate mRingerModeDelegate;
    private int mRingerModeExternal;
    private volatile IRingtonePlayer mRingtonePlayer;
    private final ArrayList<RmtSbmxFullVolDeathHandler> mRmtSbmxFullVolDeathHandlers;
    private int mRmtSbmxFullVolRefCount;
    RoleObserver mRoleObserver;
    private AtomicBoolean mRttEnabled;
    private final List<Future> mScheduledPermissionTasks;
    private final SensorPrivacyManagerInternal mSensorPrivacyManagerInternal;
    final ArrayList<SetModeDeathHandler> mSetModeDeathHandlers;
    private final SettingsAdapter mSettings;
    private final Object mSettingsLock;
    private SettingsObserver mSettingsObserver;
    private SoundEffectsHelper mSfxHelper;
    private final AtomicBoolean mShouldEnableAllHardening;
    private final SoundDoseHelper mSoundDoseHelper;
    private final SpatializerHelper mSpatializerHelper;
    final RemoteCallbackList<IStreamAliasingDispatcher> mStreamAliasingDispatchers;
    private SparseArray<VolumeStreamState> mStreamStates;
    private SubscriptionManager.OnSubscriptionsChangedListener mSubscriptionChangedListener;
    private int[] mSupportedSystemUsages;
    private final Object mSupportedSystemUsagesLock;
    private boolean mSupportsMicPrivacyToggle;
    private boolean mSurroundModeChanged;
    private long mSysPropListenerNativeHandle;
    private boolean mSystemReady;
    private final SystemServerAdapter mSystemServer;
    private final IUidObserver mUidObserver;
    private final boolean mUseFixedVolume;
    private final boolean mUseVolumeGroupAliases;
    private final UserManagerInternal mUserManagerInternal;
    private int mUserMutableStreams;
    private final UserManagerInternal.UserRestrictionsListener mUserRestrictionsListener;
    private boolean mUserSelectedVolumeControlStream;
    private boolean mUserSwitchedReceived;
    private int mVibrateSetting;
    private Vibrator mVibrator;
    private final AtomicBoolean mVoicePlaybackActive;
    private final IRecordingConfigDispatcher mVoiceRecordingActivityMonitor;
    private int mVolumeControlStream;
    private final VolumeController mVolumeController;
    private final AtomicBoolean mVolumeControllerLongPressEnabled;
    private volatile VolumePolicy mVolumePolicy;
    private final Object mVolumeStateLock;
    private ZAudioService mZAudioService;
    private int mZenModeAffectedStreams;

    /* JADX INFO: renamed from: com.android.server.audio.AudioService$8, reason: invalid class name */
    class AnonymousClass8 extends BroadcastReceiver {
        final /* synthetic */ Executor val$audioserverExecutor;
        final /* synthetic */ AudioServerPermissionProvider val$provider;

        /* JADX INFO: renamed from: $r8$lambda$xv9-nEF6lf-JqbtB6cBOFa8D0Lo, reason: not valid java name */
        public static /* synthetic */ void m2110$r8$lambda$xv9nEF6lfJqbtB6cBOFa8D0Lo(AudioServerPermissionProvider r0, int r1, String r2) {
            lambda$onReceive$0(r0, r1, r2);
        }

        AnonymousClass8(Executor r1, AudioServerPermissionProvider r2) {
            this.val$audioserverExecutor = r1;
            this.val$provider = r2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            final String pkgName = intent.getData().getEncodedSchemeSpecificPart();
            final int uid = intent.getIntExtra("android.intent.extra.UID", -1);
            if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L5;
            return;
        L5:
            if (intent.getBooleanExtra("android.intent.extra.ARCHIVAL", false) == false) goto L8;
            return;
        L8:
            if ("android.intent.action.PACKAGE_ADDED".equals(action) == false) goto L12;
            Executor r3 = this.val$audioserverExecutor;
            final AudioServerPermissionProvider r4 = this.val$provider;
            r3.execute(new AudioService$8$$ExternalSyntheticLambda0(r4, uid, pkgName));
            return;
        }

        private static /* synthetic */ void lambda$onReceive$0(AudioServerPermissionProvider provider, int uid, String pkgName) {
            provider.onModifyPackageState(uid, pkgName, false);
        }
    }

    private static final class AbsoluteVolumeDeviceInfo implements IBinder.DeathRecipient {
        private final IAudioDeviceVolumeDispatcher mCallback;
        private final AudioDeviceAttributes mDevice;
        private int mDeviceVolumeBehavior;
        private final boolean mHandlesVolumeAdjustment;
        private final AudioService mParent;
        private final List<VolumeInfo> mVolumeInfos;

        /* JADX INFO: renamed from: $r8$lambda$ud8TCBCkZeXC-SnqV9wjro1irKg, reason: not valid java name */
        public static /* synthetic */ boolean m2111$r8$lambda$ud8TCBCkZeXCSnqV9wjro1irKg(int r0, int r1) {
            return lambda$getMatchingVolumeInfoForStream$0(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ IAudioDeviceVolumeDispatcher m2112$$Nest$fgetmCallback(AbsoluteVolumeDeviceInfo r0) {
            return r0.mCallback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDevice, reason: not valid java name */
        static /* bridge */ /* synthetic */ AudioDeviceAttributes m2113$$Nest$fgetmDevice(AbsoluteVolumeDeviceInfo r0) {
            return r0.mDevice;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceVolumeBehavior, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2114$$Nest$fgetmDeviceVolumeBehavior(AbsoluteVolumeDeviceInfo r0) {
            return r0.mDeviceVolumeBehavior;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmHandlesVolumeAdjustment, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2115$$Nest$fgetmHandlesVolumeAdjustment(AbsoluteVolumeDeviceInfo r0) {
            return r0.mHandlesVolumeAdjustment;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetMatchingVolumeInfoForStream, reason: not valid java name */
        static /* bridge */ /* synthetic */ VolumeInfo m2116$$Nest$mgetMatchingVolumeInfoForStream(AbsoluteVolumeDeviceInfo r0, int r1) {
            return r0.getMatchingVolumeInfoForStream(r1);
        }

        /* synthetic */ AbsoluteVolumeDeviceInfo(AudioService r1, AudioDeviceAttributes r2, List r3, IAudioDeviceVolumeDispatcher r4, boolean r5, int r6, AudioServiceIA r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private AbsoluteVolumeDeviceInfo(AudioService parent, AudioDeviceAttributes device, List<VolumeInfo> volumeInfos, IAudioDeviceVolumeDispatcher callback, boolean handlesVolumeAdjustment, int behavior) {
            this.mParent = parent;
            this.mDevice = device;
            this.mVolumeInfos = volumeInfos;
            this.mCallback = callback;
            this.mHandlesVolumeAdjustment = handlesVolumeAdjustment;
            this.mDeviceVolumeBehavior = behavior;
            this.mCallback.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L5
            return;
        L5:
            e = move-exception;
            Slog.w(AudioService.TAG, "Exception: " + e + "\nCannot listen to callback binder death for device " + this.mDevice);
        }

        private VolumeInfo getMatchingVolumeInfoForStream(final int streamType) {
            Iterator<VolumeInfo> r0 = this.mVolumeInfos.iterator();
        L4:
            if (r0.hasNext() == false) goto L23;
            VolumeInfo volumeInfo = r0.next();
            boolean volumeGroupMatches = false;
            if (volumeInfo.hasStreamType() == true) goto L8;
        L10:
            boolean streamTypeMatches = false;
        L12:
            if (volumeInfo.hasVolumeGroup() == true) goto L14;
        L18:
            if (streamTypeMatches == true) goto L22;
            if (volumeGroupMatches == false) goto L4;
        L22:
            return volumeInfo;
        L14:
            if (Arrays.stream(volumeInfo.getVolumeGroup().getLegacyStreamTypes()).anyMatch(new AudioService$AbsoluteVolumeDeviceInfo$$ExternalSyntheticLambda0(streamType)) == false) goto L18;
            volumeGroupMatches = true;
            goto L18
        L8:
            if (volumeInfo.getStreamType() != streamType) goto L10;
            streamTypeMatches = true;
            goto L12
        L23:
            return null;
        }

        private static /* synthetic */ boolean lambda$getMatchingVolumeInfoForStream$0(int streamType, int s) {
            if (s != streamType) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (AudioService.m2088$$Nest$mremoveAudioSystemDeviceOutFromAbsVolumeDevices(this.mParent, this.mDevice.getInternalType()) == null) goto L6;
            AudioService.m2049$$Nest$mdispatchDeviceVolumeBehavior(this.mParent, this.mDevice, 0);
            return;
        }

        public void unlinkToDeath() {
            this.mCallback.asBinder().unlinkToDeath(this, 0);     // Catch: NullPointerException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(AudioService.TAG, "Exception: " + e + "\nCannot unlink to death, null binder object for device " + this.mDevice);
        }
    }

    private class AsdProxy implements IBinder.DeathRecipient {
        private final IAudioServerStateDispatcher mAsd;
        final /* synthetic */ AudioService this$0;

        AsdProxy(AudioService r1, IAudioServerStateDispatcher asd) {
            this.this$0 = r1;
            this.mAsd = asd;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HashMap r0 = AudioService.m1988$$Nest$fgetmAudioServerStateListeners(this.this$0);
            monitor-enter(r0);
            AudioService.m1988$$Nest$fgetmAudioServerStateListeners(this.this$0).remove(this.mAsd.asBinder());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        IAudioServerStateDispatcher callback() {
            return this.mAsd;
        }
    }

    private static final class AudioDeviceArray {
        final String[] mDeviceAddresses;
        final int[] mDeviceTypes;

        AudioDeviceArray(int[] types, String[] addresses) {
            this.mDeviceTypes = types;
            this.mDeviceAddresses = addresses;
        }
    }

    class AudioHandler extends Handler {
        final /* synthetic */ AudioService this$0;

        AudioHandler(AudioService this$0) {
            this.this$0 = this$0;
        }

        AudioHandler(AudioService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        private void setAllVolumes(VolumeStreamState streamState) {
            streamState.applyAllVolumes();
            int numStreamTypes = AudioSystem.getNumStreamTypes();
            int streamType = numStreamTypes - 1;
        L3:
            if (streamType < 0) goto L13;
            VolumeStreamState vss = this.this$0.getVssForStream(streamType);
            if (vss == null) goto L11;
            if (streamType == VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState)) goto L11;
            if (AudioService.sStreamVolumeAlias.get(streamType, -1) != VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState)) goto L11;
            vss.applyAllVolumes();
        L11:
            streamType = streamType - 1;
            goto L3
        }

        private void persistVolume(VolumeStreamState streamState, int device) {
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L6;
            return;
        L6:
            if (AudioService.m2007$$Nest$fgetmIsSingleVolume(this.this$0) == false) goto L11;
            if (VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState) == 3) goto L11;
            return;
        L11:
            if (VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState) != 7) goto L14;
            return;
        L14:
            if (VolumeStreamState.m2130$$Nest$mhasValidSettingsName(streamState) == false) goto L17;
            AudioService.m2016$$Nest$fgetmSettings(this.this$0).putSystemIntForUser(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), streamState.getSettingNameForDevice(device), (streamState.getIndex(device) + 5) / 10, -2);
            return;
        }

        private void persistRingerMode(int ringerMode) {
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L5;
            return;
        L5:
            AudioService.m2016$$Nest$fgetmSettings(this.this$0).putGlobalInt(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), "mode_ringer", ringerMode);
        }

        private void onNotifyVolumeEvent(IAudioPolicyCallback apc, int direction) {
            apc.notifyVolumeAdjust(direction);     // Catch: Exception -> L4
            return;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            boolean r1 = false;
            switch(msg.what) {
                case 0: goto L108;
                case 1: goto L107;
                case 2: goto L106;
                case 3: goto L105;
                case 4: goto L104;
                case 5: goto L103;
                case 7: goto L96;
                case 8: goto L92;
                case 10: goto L91;
                case 15: goto L90;
                case 16: goto L89;
                case 18: goto L88;
                case 19: goto L87;
                case 20: goto L86;
                case 21: goto L85;
                case 22: goto L84;
                case 23: goto L80;
                case 24: goto L79;
                case 25: goto L78;
                case 26: goto L77;
                case 27: goto L76;
                case 28: goto L75;
                case 29: goto L74;
                case 30: goto L73;
                case 31: goto L54;
                case 32: goto L53;
                case 33: goto L52;
                case 34: goto L51;
                case 35: goto L50;
                case 36: goto L38;
                case 37: goto L37;
                case 38: goto L36;
                case 39: goto L38;
                case 40: goto L35;
                case 41: goto L34;
                case 42: goto L33;
                case 44: goto L32;
                case 45: goto L31;
                case 46: goto L30;
                case 47: goto L29;
                case 48: goto L28;
                case 49: goto L27;
                case 50: goto L26;
                case 51: goto L25;
                case 52: goto L24;
                case 54: goto L23;
                case 55: goto L19;
                case 56: goto L18;
                case 57: goto L17;
                case 100: goto L13;
                case 101: goto L12;
                case 102: goto L11;
                case 103: goto L10;
                case 104: goto L9;
                case 105: goto L8;
                case 106: goto L7;
                case 1001: goto L6;
                case 1002: goto L6;
                case 1003: goto L6;
                case 1004: goto L6;
                case 1005: goto L6;
                case 1006: goto L6;
                case 1007: goto L6;
                case 1101: goto L5;
                default: goto L4;
            };
        L4:
            Log.e(AudioService.TAG, "Unsupported msgId " + msg.what);
            return;
        L5:
            AudioService.m2010$$Nest$fgetmMusicFxHelper(this.this$0).handleMessage(msg);
            return;
        L6:
            AudioService.m2019$$Nest$fgetmSoundDoseHelper(this.this$0).handleMessage(msg);
            return;
        L7:
            AudioService.m2072$$Nest$monPersistInputGainIndex(this.this$0, (AudioDeviceAttributes) msg.obj);
            return;
        L8:
            AudioService.m2063$$Nest$monApplyInputGainIndex(this.this$0, (AudioDeviceAttributes) msg.obj, msg.arg1);
            return;
        L9:
            AudioService.m2069$$Nest$monInitInputGains(this.this$0);
            AudioService.m1984$$Nest$fgetmAudioEventWakeLock(this.this$0).release();
            return;
        L10:
            this.this$0.onInitAdiDeviceStates();
            AudioService.m1984$$Nest$fgetmAudioEventWakeLock(this.this$0).release();
            return;
        L11:
            this.this$0.onInitSpatializer();
            AudioService.m1984$$Nest$fgetmAudioEventWakeLock(this.this$0).release();
            return;
        L12:
            AudioService.m2070$$Nest$monInitStreamsAndVolumes(this.this$0);
            AudioService.m1984$$Nest$fgetmAudioEventWakeLock(this.this$0).release();
            return;
        L13:
            PlaybackActivityMonitor r0 = AudioService.m2012$$Nest$fgetmPlaybackMonitor(this.this$0);
            if (msg.arg1 != 1) goto L16;
            r1 = true;
        L16:
            r0.disableAudioForUid(r1, msg.arg2);
            AudioService.m1984$$Nest$fgetmAudioEventWakeLock(this.this$0).release();
            return;
        L17:
            AudioService.m2081$$Nest$monUpdateBtCommDeviceActive(this.this$0, msg.arg1);
            return;
        L18:
            AudioService.m2082$$Nest$monUpdateContextualVolumes(this.this$0);
            return;
        L19:
            SystemServerAdapter r2 = AudioService.m2024$$Nest$fgetmSystemServer(this.this$0);
            if (msg.arg1 != 1) goto L22;
            r1 = true;
        L22:
            r2.broadcastMasterMuteStatus(r1);
            return;
        L23:
            AudioService.m2065$$Nest$monConfigurationChanged(this.this$0);
            return;
        L24:
            this.this$0.onDispatchPreferredMixerAttributesChanged(msg.getData(), msg.arg1);
            return;
        L25:
            AudioService.m2012$$Nest$fgetmPlaybackMonitor(this.this$0).ignorePlayerIId(msg.arg1);
            return;
        L26:
            AudioService.m2020$$Nest$fgetmSpatializerHelper(this.this$0).reset(AudioService.m2002$$Nest$fgetmHasSpatializerEffect(this.this$0));
            return;
        L27:
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setParameters((String) msg.obj);
            return;
        L28:
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setParameters((String) msg.obj);
            return;
        L29:
            AudioService.m2049$$Nest$mdispatchDeviceVolumeBehavior(this.this$0, (AudioDeviceAttributes) msg.obj, msg.arg1);
            return;
        L30:
            AudioService.m2097$$Nest$mupdateActiveAssistantServiceUids(this.this$0);
            return;
        L31:
            AudioService.m2077$$Nest$monRemoveAssistantServiceUids(this.this$0, new int[]{msg.arg1});
            return;
        L32:
            AudioService.m2062$$Nest$monAddAssistantServiceUids(this.this$0, new int[]{msg.arg1});
            return;
        L33:
            AudioService.m2020$$Nest$fgetmSpatializerHelper(this.this$0).onInitSensors();
            return;
        L34:
            this.this$0.onRoutingUpdatedFromAudioThread();
            return;
        L35:
            this.this$0.dispatchMode(msg.arg1);
            return;
        L36:
            this.this$0.mASExt.queueOnBluetoothActiveDeviceChanged_onBefore((AudioDeviceBroker.BtDeviceChangedData) msg.obj);
            AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).queueOnBluetoothActiveDeviceChanged((AudioDeviceBroker.BtDeviceChangedData) msg.obj);
            return;
        L37:
            AudioService.m2075$$Nest$monRecordingConfigChange(this.this$0, (List) msg.obj);
            return;
        L38:
            Object r3 = AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).mSetModeLock;
            monitor-enter(r3);
            UpdateAudioModeInfo info = (UpdateAudioModeInfo) msg.obj;     // Catch: Throwable -> L47
            AudioService r4 = this.this$0;     // Catch: Throwable -> L47
            int r5 = info.getMode();     // Catch: Throwable -> L47
            int r6 = info.getPid();     // Catch: Throwable -> L47
            String r7 = info.getPackageName();     // Catch: Throwable -> L47
            if (msg.what != 39) goto L43;
            boolean r9 = true;
        L44:
            r4.onUpdateAudioMode(r5, r6, r7, false, r9);     // Catch: Throwable -> L47
            monitor-exit(r3);     // Catch: Throwable -> L47
            return;
        L43:
            r9 = false;
        L47:
            th = move-exception;
            throw th;
        L50:
            AudioService.m2080$$Nest$monUpdateAccessibilityServiceUids(this.this$0);
            return;
        L51:
            AudioService.m2076$$Nest$monReinitVolumes(this.this$0, (String) msg.obj);
            return;
        L52:
            AudioService.m2084$$Nest$monUpdateVolumeStatesForAudioDevice(this.this$0, msg.arg1, (String) msg.obj);
            return;
        L53:
            SomeArgs args = (SomeArgs) msg.obj;
            Intent intent = (Intent) args.arg1;
            Bundle options = (Bundle) args.arg2;
            args.recycle();
            AudioService.m2090$$Nest$msendBroadcastToAll(this.this$0, intent.putExtra("android.media.EXTRA_PREV_VOLUME_STREAM_DEVICES", msg.arg1).putExtra("android.media.EXTRA_VOLUME_STREAM_DEVICES", msg.arg2), options);
            return;
        L54:
            Object r8 = AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).mSetModeLock;
            monitor-enter(r8);
        L60:
            th = move-exception;
            throw th;
        L57:
            if (msg.obj != null) goto L62;
            monitor-exit(r8);     // Catch: Throwable -> L60
            return;
        L62:
            SetModeDeathHandler h = (SetModeDeathHandler) msg.obj;     // Catch: Throwable -> L60
            if (this.this$0.mSetModeDeathHandlers.indexOf(h) >= 0) goto L66;
            monitor-exit(r8);     // Catch: Throwable -> L60
            return;
        L66:
            boolean wasActive = h.isActive();     // Catch: Throwable -> L60
            h.setPlaybackActive(this.this$0.isPlaybackActiveForUid(h.getUid()));     // Catch: Throwable -> L60
            h.setRecordingActive(this.this$0.isRecordingActiveForUid(h.getUid()));     // Catch: Throwable -> L60
            if (wasActive == h.isActive()) goto L69;
            this.this$0.onUpdateAudioMode(-1, Process.myPid(), this.this$0.mContext.getPackageName(), false, false);     // Catch: Throwable -> L60
        L69:
            monitor-exit(r8);     // Catch: Throwable -> L60
            return;
        L73:
            AudioService.m2024$$Nest$fgetmSystemServer(this.this$0).sendMicrophoneMuteChangedIntent();
            return;
        L74:
            AudioService.m2073$$Nest$monPlaybackConfigChange(this.this$0, (List) msg.obj);
            return;
        L75:
            AudioService.m2064$$Nest$monCheckVolumeCecOnHdmiConnection(this.this$0, msg.arg1, (String) msg.obj);
            return;
        L76:
            AudioService.m2071$$Nest$monObserveDevicesForAllStreams(this.this$0, msg.arg1);
            return;
        L77:
            AudioService.m2078$$Nest$monSetVolumeIndexOnDevice(this.this$0, (DeviceVolumeUpdate) msg.obj);
            return;
        L78:
            AudioService.m2083$$Nest$monUpdateRingerModeServiceInt(this.this$0);
            return;
        L79:
            AudioService.m2068$$Nest$monEnableSurroundFormats(this.this$0, (ArrayList) msg.obj);
            return;
        L80:
            AudioService r10 = this.this$0;
            if (msg.arg1 != 1) goto L83;
            r1 = true;
        L83:
            AudioService.m2066$$Nest$monDispatchAudioServerStateChange(r10, r1);
            return;
        L84:
            onNotifyVolumeEvent((IAudioPolicyCallback) msg.obj, msg.arg1);
            return;
        L85:
            AudioService.m2061$$Nest$monAccessoryPlugMediaUnmute(this.this$0, msg.arg1);
            return;
        L86:
            this.this$0.onIndicateSystemReady();
            return;
        L87:
            AudioService.m2067$$Nest$monDynPolicyMixStateUpdate(this.this$0, (String) msg.obj, msg.arg1);
            return;
        L88:
            AudioService.m2079$$Nest$monUnmuteStreamOnSingleVolDevice(this.this$0, msg.arg1, msg.arg2);
            return;
        L89:
            this.this$0.onSystemReady();
            return;
        L90:
            AudioService.m2018$$Nest$fgetmSfxHelper(this.this$0).unloadSoundEffects();
            return;
        L91:
            setAllVolumes((VolumeStreamState) msg.obj);
            return;
        L92:
            String eventSource = (String) msg.obj;
            int useCase = msg.arg1;
            int config = msg.arg2;
            if (useCase != 1) goto L95;
            Log.wtf(AudioService.TAG, "Invalid force use FOR_MEDIA in AudioService from " + eventSource);
            return;
        L95:
            new MediaMetrics.Item("audio.forceUse." + AudioSystem.forceUseUsageToString(useCase)).set(MediaMetrics.Property.EVENT, "setForceUse").set(MediaMetrics.Property.FORCE_USE_DUE_TO, eventSource).set(MediaMetrics.Property.FORCE_USE_MODE, AudioSystem.forceUseConfigToString(config)).record();
            AudioService.sForceUseLogger.enqueue(new AudioServiceEvents.ForceUseEvent(useCase, config, eventSource));
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setForceUse(useCase, config);
            return;
        L96:
            LoadSoundEffectReply reply = (LoadSoundEffectReply) msg.obj;
            if (AudioService.m2023$$Nest$fgetmSystemReady(this.this$0) == false) goto L99;
            AudioService.m2018$$Nest$fgetmSfxHelper(this.this$0).loadSoundEffects(reply);
            return;
        L99:
            Log.w(AudioService.TAG, "[schedule]loadSoundEffects() called before boot complete");
            if (reply == null) goto L174;
            reply.run(false);
            return;
        L174:
            return;
        L103:
            AudioService.m2018$$Nest$fgetmSfxHelper(this.this$0).playSoundEffect(msg.arg1, msg.arg2);
            return;
        L104:
            this.this$0.onAudioServerDied();
            return;
        L105:
            persistRingerMode(this.this$0.getRingerModeInternal());
            return;
        L106:
            VolumeGroupState vgs = (VolumeGroupState) msg.obj;
            VolumeGroupState.m2122$$Nest$mpersistVolumeGroup(vgs, msg.arg1);
            return;
        L107:
            persistVolume((VolumeStreamState) msg.obj, msg.arg1);
            return;
        L108:
            this.this$0.setDeviceVolume((VolumeStreamState) msg.obj, msg.arg1);
        }
    }

    public class AudioPolicyProxy extends AudioPolicyConfig implements IBinder.DeathRecipient {
        private static final String TAG = "AudioPolicyProxy";
        final AttributionSource mAttributionSource;
        int mFocusDuckBehavior;
        final boolean mHasFocusListener;
        boolean mIsFocusPolicy;
        boolean mIsTestFocusPolicy;
        final boolean mIsVolumeController;
        final IAudioPolicyCallback mPolicyCallback;
        final IMediaProjection mProjection;
        UnregisterOnStopCallback mProjectionCallback;
        final HashMap<Integer, AudioDeviceArray> mUidDeviceAffinities;
        final HashMap<Integer, AudioDeviceArray> mUserIdDeviceAffinities;
        final /* synthetic */ AudioService this$0;

        private final class UnregisterOnStopCallback extends IMediaProjectionCallback.Stub {
            final /* synthetic */ AudioPolicyProxy this$1;

            /* synthetic */ UnregisterOnStopCallback(AudioPolicyProxy r1, AudioServiceIA r2) {
                this(r1);
            }

            private UnregisterOnStopCallback(AudioPolicyProxy r1) {
                this.this$1 = r1;
            }

            public void onStop() {
                this.this$1.this$0.unregisterAudioPolicyAsync(this.this$1.mPolicyCallback);
            }

            public void onCapturedContentResize(int width, int height) {
            }

            public void onCapturedContentVisibilityChanged(boolean isVisible) {
            }
        }

        public static /* synthetic */ void $r8$lambda$Hh5oz7jBWTQhN1SdJkxc4FbHeGg(AudioMixingRule r0, AudioMix r1) {
            lambda$updateMixingRules$0(r0, r1);
        }

        AudioPolicyProxy(AudioService this$0, AudioPolicyConfig config, IAudioPolicyCallback token, boolean hasFocusListener, boolean isFocusPolicy, boolean isTestFocusPolicy, boolean isVolumeController, IMediaProjection projection, AttributionSource attributionSource) {
            this.this$0 = this$0;
            super(config);
            this.mUidDeviceAffinities = new HashMap();
            this.mUserIdDeviceAffinities = new HashMap();
            this.mFocusDuckBehavior = 0;
            this.mIsFocusPolicy = false;
            this.mIsTestFocusPolicy = false;
            StringBuilder r1 = new StringBuilder();
            r1.append(config.hashCode());
            r1.append(":ap:");
            int r2 = AudioService.m1987$$Nest$fgetmAudioPolicyCounter(this$0);
            AudioService.m2033$$Nest$fputmAudioPolicyCounter(this$0, r2 + 1);
            r1.append(r2);
            setRegistration(new String(r1.toString()));
            this.mPolicyCallback = token;
            this.mAttributionSource = attributionSource;
            this.mHasFocusListener = hasFocusListener;
            this.mIsVolumeController = isVolumeController;
            this.mProjection = projection;
            if (this.mHasFocusListener == false) goto L8;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this$0).addFocusFollower(this.mPolicyCallback);
            if (isFocusPolicy == false) goto L8;
            this.mIsFocusPolicy = true;
            this.mIsTestFocusPolicy = isTestFocusPolicy;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this$0).setFocusPolicy(this.mPolicyCallback, this.mIsTestFocusPolicy);
        L8:
            if (this.mIsVolumeController == false) goto L11;
            AudioService.m2093$$Nest$msetExtVolumeController(this$0, this.mPolicyCallback);
        L11:
            if (this.mProjection == null) goto L18;
            this.mProjectionCallback = new UnregisterOnStopCallback(this, null);
            this.mProjection.registerCallback(this.mProjectionCallback);     // Catch: RemoteException -> L15
        L15:
            e = move-exception;
            release();
            throw new IllegalStateException("MediaProjection callback registration failed, could not link to " + projection + " binder death", e);
        L18:
            int status = connectMixes();
            if (status != 0) goto L21;
            return;
        L21:
            release();
            throw new IllegalStateException("Could not connect mix, error: " + status);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            AudioService.m1996$$Nest$fgetmDynPolicyLogger(this.this$0).enqueue(new EventLogger.StringEvent("AudioPolicy " + this.mPolicyCallback.asBinder() + " died").printLog(TAG));
            List<String> addresses = new ArrayList();
            Iterator r1 = ((AudioPolicyConfig) this).mMixes.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            AudioMix mix = (AudioMix) r1.next();
            addresses.add(mix.getRegistration());
            goto L4
        L6:
            AudioService.m2074$$Nest$monPolicyClientDeath(this.this$0, addresses);
            release();
        }

        String getRegistrationId() {
            return getRegistration();
        }

        void release() {
            if (this.mIsFocusPolicy == false) goto L6;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this.this$0).unsetFocusPolicy(this.mPolicyCallback, this.mIsTestFocusPolicy);
        L6:
            if (this.mFocusDuckBehavior != 1) goto L9;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this.this$0).setDuckingInExtPolicyAvailable(false);
        L9:
            if (this.mHasFocusListener == false) goto L12;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this.this$0).removeFocusFollower(this.mPolicyCallback);
        L12:
            if (this.mProjectionCallback == null) goto L18;
            this.mProjection.unregisterCallback(this.mProjectionCallback);     // Catch: RemoteException -> L15
        L16:
            Log.e(TAG, "Fail to unregister Audiopolicy callback from MediaProjection");
        L18:
            if (this.mIsVolumeController == false) goto L27;
            Object r0 = AudioService.m1998$$Nest$fgetmExtVolumeControllerLock(this.this$0);
            monitor-enter(r0);
            AudioService.m2037$$Nest$fputmExtVolumeController(this.this$0, null);     // Catch: Throwable -> L24
            monitor-exit(r0);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        L27:
            long identity = Binder.clearCallingIdentity();
            ArrayList r2 = ((AudioPolicyConfig) this).mMixes;     // Catch: Throwable -> L47
            monitor-enter(r2);     // Catch: Throwable -> L47
            removeMixes(new ArrayList(((AudioPolicyConfig) this).mMixes));     // Catch: Throwable -> L44
            monitor-exit(r2);     // Catch: Throwable -> L44
            Binder.restoreCallingIdentity(identity);
            HashMap r3 = AudioService.m1986$$Nest$fgetmAudioPolicies(this.this$0);
            monitor-enter(r3);
            AudioService.m1986$$Nest$fgetmAudioPolicies(this.this$0).remove(this.mPolicyCallback.asBinder());     // Catch: Throwable -> L41
            monitor-exit(r3);     // Catch: Throwable -> L41
            this.mPolicyCallback.notifyUnregistration();     // Catch: RemoteException -> L38
            return;
        L62:
            return;
        L41:
            th = move-exception;
            throw th;
        L44:
            th = move-exception;
            throw th;     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        boolean hasMixAffectingUsage(int usage, int excludedFlags) {
            Iterator r0 = ((AudioPolicyConfig) this).mMixes.iterator();
        L4:
            if (r0.hasNext() == false) goto L12;
            AudioMix mix = (AudioMix) r0.next();
            if (mix.isAffectingUsage(usage) == false) goto L4;
            if ((mix.getRouteFlags() & excludedFlags) == excludedFlags) goto L4;
            return true;
        L12:
            return false;
        }

        boolean hasMixRoutedToDevices(int[] deviceTypes, String[] deviceAddresses) {
            int i = 0;
        L4:
            if (i >= deviceTypes.length) goto L16;
            boolean hasDevice = false;
            Iterator r2 = ((AudioPolicyConfig) this).mMixes.iterator();
        L7:
            if (r2.hasNext() == false) goto L12;
            AudioMix mix = (AudioMix) r2.next();
            if (mix.isRoutedToDevice(deviceTypes[i], deviceAddresses[i]) == false) goto L7;
            hasDevice = true;
        L12:
            if (hasDevice == false) goto L13;
            i = i + 1;
            goto L4
        L13:
            return false;
        L16:
            return true;
        }

        int addMixes(ArrayList<AudioMix> mixes) {
            ArrayList r0 = ((AudioPolicyConfig) this).mMixes;
            monitor-enter(r0);
            Iterator<AudioMix> r1 = mixes.iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            AudioMix mix = r1.next();     // Catch: Throwable -> L8
            setMixRegistration(mix);     // Catch: Throwable -> L8
            mix.setVirtualDeviceId(this.mAttributionSource.getDeviceId());     // Catch: Throwable -> L8
            goto L6
        L10:
            int result = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).registerPolicyMixes(mixes, true);     // Catch: Throwable -> L8
            if (result != 0) goto L13;
            add(mixes);     // Catch: Throwable -> L8
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return result;
        L8:
            th = move-exception;
            throw th;
        }

        int removeMixes(ArrayList<AudioMix> mixes) {
            ArrayList r0 = ((AudioPolicyConfig) this).mMixes;
            monitor-enter(r0);
            remove(mixes);     // Catch: Throwable -> L7
            int r1 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).registerPolicyMixes(mixes, false);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        int connectMixes() {
            long identity = Binder.clearCallingIdentity();
            Iterator r2 = ((AudioPolicyConfig) this).mMixes.iterator();     // Catch: Throwable -> L7
        L5:
            if (r2.hasNext() == false) goto L9;
            AudioMix mix = (AudioMix) r2.next();     // Catch: Throwable -> L7
            mix.setVirtualDeviceId(this.mAttributionSource.getDeviceId());     // Catch: Throwable -> L7
            goto L5
        L9:
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).registerPolicyMixes(((AudioPolicyConfig) this).mMixes, false);     // Catch: Throwable -> L7
            int r3 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).registerPolicyMixes(((AudioPolicyConfig) this).mMixes, true);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return r3;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        int updateMixingRules(AudioMix[] mixesToUpdate, AudioMixingRule[] updatedMixingRules) {
            mixesToUpdate.getClass();
            updatedMixingRules.getClass();
            int r0 = mixesToUpdate.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L6;
            AudioMix mix = mixesToUpdate[r1];
            mix.setVirtualDeviceId(this.mAttributionSource.getDeviceId());
            r1 = r1 + 1;
            goto L3
        L6:
            if (mixesToUpdate.length == updatedMixingRules.length) goto L9;
            Log.e(TAG, "Provided list of audio mixes to update and corresponding mixing rules have mismatching length (mixesToUpdate.length = " + mixesToUpdate.length + ", updatedMixingRules.length = " + updatedMixingRules.length + ").");
            return -2;
        L9:
            ArrayList r2 = ((AudioPolicyConfig) this).mMixes;
            monitor-enter(r2);
            SafeCloseable unused = ClearCallingIdentityContext.create();     // Catch: Throwable -> L24
            int ret = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).updateMixingRules(mixesToUpdate, updatedMixingRules);     // Catch: Throwable -> L19
            if (ret != 0) goto L22;
            int i = 0;
        L16:
            if (i >= mixesToUpdate.length) goto L22;
            final AudioMix audioMixToUpdate = mixesToUpdate[i];     // Catch: Throwable -> L19
            final AudioMixingRule audioMixingRule = updatedMixingRules[i];     // Catch: Throwable -> L19
            Stream r6 = ((AudioPolicyConfig) this).mMixes.stream();     // Catch: Throwable -> L19
            audioMixToUpdate.getClass();     // Catch: Throwable -> L19
            r6.filter(new AudioService$AudioPolicyProxy$$ExternalSyntheticLambda0(audioMixToUpdate)).findAny().ifPresent(new AudioService$AudioPolicyProxy$$ExternalSyntheticLambda1(audioMixingRule));     // Catch: Throwable -> L19
            i = i + 1;
            goto L16
        L22:
            if (unused == null) goto L26;
            unused.close();     // Catch: Throwable -> L24
        L26:
            monitor-exit(r2);     // Catch: Throwable -> L24
            return ret;
        L19:
            th = move-exception;
            if (unused != null) goto L37;
        L34:
            throw th;     // Catch: Throwable -> L24
        L37:
            unused.close();     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$updateMixingRules$0(AudioMixingRule audioMixingRule, AudioMix mix) {
            mix.setAudioMixingRule(audioMixingRule);
        }

        int setUidDeviceAffinities(int uid, int[] types, String[] addresses) {
            Integer Uid = new Integer(uid);
            if (this.mUidDeviceAffinities.remove(Uid) != null) goto L5;
        L8:
            AudioDeviceArray deviceArray = new AudioDeviceArray(types, addresses);
            if (setUidDeviceAffinitiesOnSystem(uid, deviceArray) != 0) goto L12;
            this.mUidDeviceAffinities.put(Uid, deviceArray);
            return 0;
        L12:
            Log.e(TAG, "AudioSystem. setUidDeviceAffinities(" + uid + ") failed");
            return -1;
        L5:
            if (removeUidDeviceAffinitiesFromSystem(uid) == 0) goto L8;
            Log.e(TAG, "AudioSystem. removeUidDeviceAffinities(" + uid + ") failed,  cannot call AudioSystem.setUidDeviceAffinities");
            return -1;
        }

        int removeUidDeviceAffinities(int uid) {
            if (this.mUidDeviceAffinities.remove(new Integer(uid)) != null) goto L5;
        L8:
            Log.e(TAG, "AudioSystem. removeUidDeviceAffinities failed");
            return -1;
        L5:
            if (removeUidDeviceAffinitiesFromSystem(uid) != 0) goto L8;
            return 0;
        }

        private int removeUidDeviceAffinitiesFromSystem(int uid) {
            long identity = Binder.clearCallingIdentity();
            int r2 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).removeUidDeviceAffinities(uid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private int setUidDeviceAffinitiesOnSystem(int uid, AudioDeviceArray deviceArray) {
            long identity = Binder.clearCallingIdentity();
            int r2 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setUidDeviceAffinities(uid, deviceArray.mDeviceTypes, deviceArray.mDeviceAddresses);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        int setUserIdDeviceAffinities(int userId, int[] types, String[] addresses) {
            Integer UserId = new Integer(userId);
            if (this.mUserIdDeviceAffinities.remove(UserId) != null) goto L5;
        L8:
            AudioDeviceArray audioDeviceArray = new AudioDeviceArray(types, addresses);
            if (setUserIdDeviceAffinitiesOnSystem(userId, audioDeviceArray) != 0) goto L12;
            this.mUserIdDeviceAffinities.put(UserId, audioDeviceArray);
            return 0;
        L12:
            Log.e(TAG, "AudioSystem.setUserIdDeviceAffinities(" + userId + ") failed");
            return -1;
        L5:
            if (removeUserIdDeviceAffinitiesFromSystem(userId) == 0) goto L8;
            Log.e(TAG, "AudioSystem. removeUserIdDeviceAffinities(" + UserId + ") failed,  cannot call AudioSystem.setUserIdDeviceAffinities");
            return -1;
        }

        int removeUserIdDeviceAffinities(int userId) {
            if (this.mUserIdDeviceAffinities.remove(new Integer(userId)) != null) goto L5;
        L8:
            Log.e(TAG, "AudioSystem.removeUserIdDeviceAffinities failed");
            return -1;
        L5:
            if (removeUserIdDeviceAffinitiesFromSystem(userId) != 0) goto L8;
            return 0;
        }

        private int removeUserIdDeviceAffinitiesFromSystem(int userId) {
            long identity = Binder.clearCallingIdentity();
            int r2 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).removeUserIdDeviceAffinities(userId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private int setUserIdDeviceAffinitiesOnSystem(int userId, AudioDeviceArray deviceArray) {
            long identity = Binder.clearCallingIdentity();
            int r2 = AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setUserIdDeviceAffinities(userId, deviceArray.mDeviceTypes, deviceArray.mDeviceAddresses);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        int setupDeviceAffinities() {
            Iterator<Map.Entry<Integer, AudioDeviceArray>> r0 = this.mUidDeviceAffinities.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L14;
            Map.Entry<Integer, AudioDeviceArray> uidEntry = r0.next();
            int uidStatus = removeUidDeviceAffinitiesFromSystem(uidEntry.getKey().intValue());
            if (uidStatus != 0) goto L7;
            int uidStatus2 = setUidDeviceAffinitiesOnSystem(uidEntry.getKey().intValue(), uidEntry.getValue());
            if (uidStatus2 == 0) goto L4;
            Log.e(TAG, "setupDeviceAffinities failed to set device affinity for uid " + uidEntry.getKey());
            return uidStatus2;
        L7:
            Log.e(TAG, "setupDeviceAffinities failed to remove device affinity for uid " + uidEntry.getKey());
            return uidStatus;
        L14:
            Iterator<Map.Entry<Integer, AudioDeviceArray>> r1 = this.mUserIdDeviceAffinities.entrySet().iterator();
        L16:
            if (r1.hasNext() == false) goto L26;
            Map.Entry<Integer, AudioDeviceArray> userIdEntry = r1.next();
            int userIdStatus = removeUserIdDeviceAffinitiesFromSystem(userIdEntry.getKey().intValue());
            if (userIdStatus != 0) goto L19;
            int userIdStatus2 = setUserIdDeviceAffinitiesOnSystem(userIdEntry.getKey().intValue(), userIdEntry.getValue());
            if (userIdStatus2 == 0) goto L16;
            Log.e(TAG, "setupDeviceAffinities failed to set device affinity for userId " + userIdEntry.getKey());
            return userIdStatus2;
        L19:
            Log.e(TAG, "setupDeviceAffinities failed to remove device affinity for userId " + userIdEntry.getKey());
            return userIdStatus;
        L26:
            return 0;
        }

        public String toLogFriendlyString() {
            String textDump = super.toLogFriendlyString();
            String textDump2 = (((((textDump + " Uid Device Affinities:\n") + logFriendlyAttributeDeviceArrayMap("Uid", this.mUidDeviceAffinities, "     ")) + " UserId Device Affinities:\n") + logFriendlyAttributeDeviceArrayMap("UserId", this.mUserIdDeviceAffinities, "     ")) + " Proxy:\n") + "   is focus policy= " + this.mIsFocusPolicy + "\n";
            if (this.mIsFocusPolicy == false) goto L6;
            textDump2 = ((textDump2 + "     focus duck behaviour= " + this.mFocusDuckBehavior + "\n") + "     is test focus policy= " + this.mIsTestFocusPolicy + "\n") + "     has focus listener= " + this.mHasFocusListener + "\n";
        L6:
            return textDump2 + "   media projection= " + this.mProjection + "\n";
        }

        private String logFriendlyAttributeDeviceArrayMap(String attribute, Map<Integer, AudioDeviceArray> map, String spacer) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator<Map.Entry<Integer, AudioDeviceArray>> r1 = map.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L11;
            Map.Entry<Integer, AudioDeviceArray> mapEntry = r1.next();
            stringBuilder.append(spacer);
            stringBuilder.append(attribute);
            stringBuilder.append(": ");
            stringBuilder.append(mapEntry.getKey());
            stringBuilder.append("\n");
            AudioDeviceArray deviceArray = mapEntry.getValue();
            String deviceSpacer = spacer + "   ";
            int i = 0;
        L7:
            if (i >= deviceArray.mDeviceTypes.length) goto L4;
            stringBuilder.append(deviceSpacer);
            stringBuilder.append("Type: 0x");
            stringBuilder.append(Integer.toHexString(deviceArray.mDeviceTypes[i]));
            stringBuilder.append(" Address: ");
            stringBuilder.append(deviceArray.mDeviceAddresses[i]);
            stringBuilder.append("\n");
            i = i + 1;
            goto L7
        L11:
            return stringBuilder.toString();
        }
    }

    private class AudioServiceBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ AudioService this$0;

        /* synthetic */ AudioServiceBroadcastReceiver(AudioService r1, AudioServiceIA r2) {
            this(r1);
        }

        private AudioServiceBroadcastReceiver(AudioService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.intent.action.DOCK_EVENT") == false) goto L18;
            int dockState = intent.getIntExtra("android.intent.extra.DOCK_STATE", 0);
            switch(dockState) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                default: goto L6;
            };
        L6:
            int config = 0;
        L11:
            if (dockState == 3) goto L16;
            if (dockState == 0) goto L14;
        L15:
            AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).setForceUse_Async(3, config, "ACTION_DOCK_EVENT intent");
            goto L16
        L14:
            if (AudioService.m1995$$Nest$fgetmDockState(this.this$0) != 3) goto L15;
        L16:
            AudioService.m2034$$Nest$fputmDockState(this.this$0, dockState);
            return;
        L7:
            config = 9;
            goto L11
        L8:
            config = 8;
            goto L11
        L9:
            config = 6;
            goto L11
        L10:
            config = 7;
            goto L11
        L18:
            if (action.equals("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED") == false) goto L20;
        L93:
            AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).postReceiveBtEvent(intent);
            return;
        L20:
            if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED") == true) goto L93;
            if (action.equals("android.intent.action.SCREEN_ON") == false) goto L29;
            if (AudioService.m2009$$Nest$fgetmMonitorRotation(this.this$0) == false) goto L27;
            RotationHelper.enable();
        L27:
            AudioSystem.setParameters("screen_state=on");
            return;
        L29:
            if (action.equals("android.intent.action.SCREEN_OFF") == false) goto L35;
            if (AudioService.m2009$$Nest$fgetmMonitorRotation(this.this$0) == false) goto L33;
            RotationHelper.disable();
        L33:
            AudioSystem.setParameters("screen_state=off");
            return;
        L35:
            if (action.equals("android.intent.action.CONFIGURATION_CHANGED") == false) goto L38;
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 54, 0, 0, 0, null, 0);
            return;
        L38:
            if (action.equals("android.intent.action.USER_SWITCHED") == false) goto L49;
            boolean audioDiscarded = AudioService.m2008$$Nest$fgetmMediaFocusControl(this.this$0).maybeDiscardAudioFocusOwner();
            if (audioDiscarded == true) goto L42;
        L44:
            AudioService.m2046$$Nest$fputmUserSwitchedReceived(this.this$0, true);
            if (AudioService.m2021$$Nest$fgetmSupportsMicPrivacyToggle(this.this$0) == false) goto L47;
            AudioService.m2041$$Nest$fputmMicMuteFromPrivacyToggle(this.this$0, AudioService.m2015$$Nest$fgetmSensorPrivacyManagerInternal(this.this$0).isSensorPrivacyEnabled(AudioService.m2050$$Nest$mgetCurrentUserId(this.this$0), 1));
            AudioService.m2095$$Nest$msetMicrophoneMuteNoCallerCheck(this.this$0, AudioService.m2050$$Nest$mgetCurrentUserId(this.this$0));
        L47:
            AudioService.m2086$$Nest$mreadAudioSettings(this.this$0, true);
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 10, 2, 0, 0, this.this$0.getVssForStreamOrDefault(3), 0);
            return;
        L42:
            if (AudioService.m2026$$Nest$fgetmUserSwitchedReceived(this.this$0) == false) goto L44;
            AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).postBroadcastBecomingNoisy();
            goto L44
        L49:
            if (action.equals("android.intent.action.USER_BACKGROUND") == false) goto L59;
            int userId = intent.getIntExtra("android.intent.extra.user_handle", -1);
            if (userId < 0) goto L95;
            UserInfo userInfo = UserManagerService.getInstance().getUserInfo(userId);
            AudioService.m2060$$Nest$mkillBackgroundUserProcessesWithRecordAudioPermission(this.this$0, userInfo);
        L95:
            UserManagerService.getInstance().setUserRestriction("no_record_audio", true, userId);     // Catch: IllegalArgumentException -> L55
            return;
        L55:
            e = move-exception;
            Slog.w(AudioService.TAG, "Failed to apply DISALLOW_RECORD_AUDIO restriction: " + e);
            return;
        L59:
            if (action.equals("android.intent.action.USER_FOREGROUND") == false) goto L67;
            UserManagerService.getInstance().setUserRestriction("no_record_audio", false, intent.getIntExtra("android.intent.extra.user_handle", -1));     // Catch: IllegalArgumentException -> L63
            return;
        L63:
            e = move-exception;
            Slog.w(AudioService.TAG, "Failed to apply DISALLOW_RECORD_AUDIO restriction: " + e);
            return;
        L67:
            if (action.equals("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION") == false) goto L69;
        L92:
            AudioService.m2010$$Nest$fgetmMusicFxHelper(this.this$0).handleAudioEffectBroadcast(context, intent);
            return;
        L69:
            if (action.equals("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION") == true) goto L92;
            if (action.equals("android.intent.action.PACKAGES_SUSPENDED") == false) goto L90;
            int[] suspendedUids = intent.getIntArrayExtra("android.intent.extra.changed_uid_list");
            String[] suspendedPackages = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
            if (suspendedPackages == null) goto L88;
            if (suspendedUids != null) goto L77;
            return;
        L77:
            if (suspendedPackages.length != suspendedUids.length) goto L103;
            int i = 0;
        L81:
            if (i >= suspendedUids.length) goto L116;
            if (TextUtils.isEmpty(suspendedPackages[i]) == true) goto L85;
            AudioService.m2008$$Nest$fgetmMediaFocusControl(this.this$0).noFocusForSuspendedApp(suspendedPackages[i], suspendedUids[i]);
        L85:
            i = i + 1;
            goto L81
        L116:
            return;
        L103:
            return;
        L88:
            return;
        L90:
            if (action.equals("com.android.server.audio.action.CHECK_MUSIC_ACTIVE") == false) goto L115;
            AudioService.m2019$$Nest$fgetmSoundDoseHelper(this.this$0).onCheckMusicActive("com.android.server.audio.action.CHECK_MUSIC_ACTIVE", AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).isStreamActive(3, 0));
            return;
        }
    }

    final class AudioServiceInternal extends AudioManagerInternal {
        final /* synthetic */ AudioService this$0;

        AudioServiceInternal(AudioService this$0) {
            this.this$0 = this$0;
        }

        public void setRingerModeDelegate(AudioManagerInternal.RingerModeDelegate delegate) {
            AudioService.m2043$$Nest$fputmRingerModeDelegate(this.this$0, delegate);
            if (AudioService.m2014$$Nest$fgetmRingerModeDelegate(this.this$0) == null) goto L12;
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            AudioService.m2102$$Nest$mupdateRingerAndZenModeAffectedStreams(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            setRingerModeInternal(getRingerModeInternal(), "AS.AudioService.setRingerModeDelegate");
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public int getRingerModeInternal() {
            return this.this$0.getRingerModeInternal();
        }

        public void setRingerModeInternal(int ringerMode, String caller) {
            this.this$0.setRingerModeInternal(ringerMode, caller);
        }

        public void silenceRingerModeInternal(String caller) {
            this.this$0.silenceRingerModeInternal(caller);
        }

        public void updateRingerModeAffectedStreamsInternal() {
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2102$$Nest$mupdateRingerAndZenModeAffectedStreams(this.this$0) == false) goto L9;
            AudioService.m2096$$Nest$msetRingerModeInt(this.this$0, getRingerModeInternal(), false);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void addAssistantServiceUid(int uid, int owningUid) {
            AudioService.m2011$$Nest$fgetmPermissionProvider(this.this$0).setIsolatedServiceUid(uid, owningUid);
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 44, 2, uid, 0, null, 0);
        }

        public void removeAssistantServiceUid(int uid) {
            AudioService.m2011$$Nest$fgetmPermissionProvider(this.this$0).clearIsolatedServiceUid(uid);
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 45, 2, uid, 0, null, 0);
        }

        public void setActiveAssistantServicesUids(IntArray activeUids) {
            Object r1 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r1);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (activeUids.size() != 0) goto L10;
            AudioService.m2031$$Nest$fputmActiveAssistantServiceUids(this.this$0, AudioService.m2103$$Nest$sfgetNO_ACTIVE_ASSISTANT_SERVICE_UIDS());     // Catch: Throwable -> L7
        L27:
            monitor-exit(r1);     // Catch: Throwable -> L7
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 46, 0, 0, 0, null, 0);
            return;
        L10:
            if (AudioService.m1983$$Nest$fgetmActiveAssistantServiceUids(this.this$0) != null) goto L12;
        L15:
            boolean changed = true;
        L17:
            if (changed == true) goto L25;
            int i = 0;
        L20:
            if (i >= AudioService.m1983$$Nest$fgetmActiveAssistantServiceUids(this.this$0).length) goto L25;
            if (activeUids.get(i) != AudioService.m1983$$Nest$fgetmActiveAssistantServiceUids(this.this$0)[i]) goto L23;
            i = i + 1;     // Catch: Throwable -> L7
            goto L20
        L23:
            changed = true;
        L25:
            if (changed == false) goto L27;
            AudioService.m2031$$Nest$fputmActiveAssistantServiceUids(this.this$0, activeUids.toArray());     // Catch: Throwable -> L7
            goto L27
        L12:
            if (AudioService.m1983$$Nest$fgetmActiveAssistantServiceUids(this.this$0).length != activeUids.size()) goto L15;
            changed = false;
            goto L17
        }

        public void setAccessibilityServiceUids(IntArray uids) {
            if (this.this$0.isPlatformAutomotive() == false) goto L5;
            return;
        L5:
            Object r1 = AudioService.m1982$$Nest$fgetmAccessibilityServiceUidsLock(this.this$0);
            monitor-enter(r1);
        L10:
            th = move-exception;
            throw th;
        L8:
            if (uids.size() != 0) goto L13;
            AudioService.m2030$$Nest$fputmAccessibilityServiceUids(this.this$0, null);     // Catch: Throwable -> L10
        L30:
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 35, 0, 0, 0, null, 0);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            return;
        L13:
            if (AudioService.m1981$$Nest$fgetmAccessibilityServiceUids(this.this$0) != null) goto L15;
        L18:
            boolean changed = true;
        L20:
            if (changed == true) goto L28;
            int i = 0;
        L23:
            if (i >= AudioService.m1981$$Nest$fgetmAccessibilityServiceUids(this.this$0).length) goto L28;
            if (uids.get(i) != AudioService.m1981$$Nest$fgetmAccessibilityServiceUids(this.this$0)[i]) goto L26;
            i = i + 1;     // Catch: Throwable -> L10
            goto L23
        L26:
            changed = true;
        L28:
            if (changed == false) goto L30;
            AudioService.m2030$$Nest$fputmAccessibilityServiceUids(this.this$0, uids.toArray());     // Catch: Throwable -> L10
            goto L30
        L15:
            if (AudioService.m1981$$Nest$fgetmAccessibilityServiceUids(this.this$0).length != uids.size()) goto L18;
            changed = false;
            goto L20
        }

        public void setInputMethodServiceUid(int uid) {
            Object r0 = AudioService.m2006$$Nest$fgetmInputMethodServiceUidLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2005$$Nest$fgetmInputMethodServiceUid(this.this$0) == uid) goto L9;
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setCurrentImeUid(uid);     // Catch: Throwable -> L7
            AudioService.m2040$$Nest$fputmInputMethodServiceUid(this.this$0, uid);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private class AudioServiceUserRestrictionsListener implements UserManagerInternal.UserRestrictionsListener {
        final /* synthetic */ AudioService this$0;

        /* synthetic */ AudioServiceUserRestrictionsListener(AudioService r1, AudioServiceIA r2) {
            this(r1);
        }

        private AudioServiceUserRestrictionsListener(AudioService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.UserManagerInternal.UserRestrictionsListener
        public void onUserRestrictionsChanged(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
            boolean wasRestricted = prevRestrictions.getBoolean("no_unmute_microphone");
            boolean isRestricted = newRestrictions.getBoolean("no_unmute_microphone");
            if (wasRestricted == isRestricted) goto L5;
            AudioService.m2042$$Nest$fputmMicMuteFromRestrictions(this.this$0, isRestricted);
            AudioService.m2095$$Nest$msetMicrophoneMuteNoCallerCheck(this.this$0, userId);
        L5:
            boolean isRestricted2 = true;
            if (prevRestrictions.getBoolean("no_adjust_volume") == false) goto L8;
        L11:
            boolean wasRestricted2 = true;
        L13:
            if (newRestrictions.getBoolean("no_adjust_volume") == false) goto L15;
        L20:
            if (wasRestricted2 == isRestricted2) goto L23;
            AudioService.m2094$$Nest$msetMasterMuteInternalNoCallerCheck(this.this$0, isRestricted2, 0, userId, "onUserRestrictionsChanged");
            return;
        L23:
            return;
        L15:
            if (newRestrictions.getBoolean("disallow_unmute_device") == true) goto L20;
            isRestricted2 = false;
            goto L20
        L8:
            if (prevRestrictions.getBoolean("disallow_unmute_device") == true) goto L11;
            wasRestricted2 = false;
            goto L13
        }
    }

    private class AudioSystemThread extends Thread {
        final /* synthetic */ AudioService this$0;

        AudioSystemThread(AudioService r1) {
            this.this$0 = r1;
            super("AudioService");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            AudioService r0 = this.this$0;
            monitor-enter(r0);
            AudioService.m2032$$Nest$fputmAudioHandler(this.this$0, new AudioHandler(this.this$0));     // Catch: Throwable -> L8
            this.this$0.notify();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Looper.loop();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private static class AudioVolumeGroupHelper extends AudioVolumeGroupHelperBase {
        /* synthetic */ AudioVolumeGroupHelper(AudioServiceIA r1) {
            this();
        }

        private AudioVolumeGroupHelper() {
        }

        @Override // com.android.server.audio.AudioVolumeGroupHelperBase
        public List<AudioVolumeGroup> getAudioVolumeGroups() {
            return AudioVolumeGroup.getAudioVolumeGroups();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BtCommDeviceActiveType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BtProfile {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BtProfileConnectionState {
    }

    private static class CacheWatcher extends Thread {
        private final AtomicBoolean mRunning;
        private final Runnable mTask;
        private final PropertyInvalidatedCache.NonceWatcher mWatcher;

        public CacheWatcher(Runnable r) {
            this.mRunning = new AtomicBoolean(false);
            this.mWatcher = PropertyInvalidatedCache.getNonceWatcher(PermissionManager.CACHE_KEY_PACKAGE_INFO_CACHE);
            this.mTask = r;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.mRunning.set(true);
        L4:
            if (this.mRunning.get() == false) goto L10;
            doCheck();
            this.mWatcher.waitForChange();     // Catch: InterruptedException -> L8
        L8:
            e = move-exception;
            Log.wtf(AudioService.TAG, "Unexpected Interrupt", e);
            goto L4
        }

        public synchronized void doCheck() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mWatcher.isChanged() == false) goto L9;
            this.mTask.run();     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }

        public void done() {
            this.mRunning.set(false);
            this.mWatcher.wakeUp();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionState {
    }

    private static final class DeviceVolumeUpdate {
        private static final int NO_NEW_INDEX = -2049;
        final String mCaller;
        final int mDevice;
        final int mStreamType;
        private final int mVssVolIndex;

        DeviceVolumeUpdate(int streamType, int vssVolIndex, int device, String caller) {
            this.mStreamType = streamType;
            this.mVssVolIndex = vssVolIndex;
            this.mDevice = device;
            this.mCaller = caller;
        }

        DeviceVolumeUpdate(int streamType, int device, String caller) {
            this.mStreamType = streamType;
            this.mVssVolIndex = NO_NEW_INDEX;
            this.mDevice = device;
            this.mCaller = caller;
        }

        boolean hasVolumeIndex() {
            if (this.mVssVolIndex == NO_NEW_INDEX) goto L5;
            return true;
        L5:
            return false;
        }

        int getVolumeIndex() throws IllegalStateException {
            if (this.mVssVolIndex == NO_NEW_INDEX) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkState(r0);
            return this.mVssVolIndex;
        L5:
            r0 = false;
            goto L6
        }
    }

    private class ForceControlStreamClient implements IBinder.DeathRecipient {
        private IBinder mCb;
        final /* synthetic */ AudioService this$0;

        ForceControlStreamClient(AudioService r3, IBinder cb) {
            this.this$0 = r3;
            if (cb != null) goto L11;
        L9:
            this.mCb = cb;
            return;
        L11:
            cb.linkToDeath(this, 0);     // Catch: RemoteException -> L7
        L8:
            Log.w(AudioService.TAG, "ForceControlStreamClient() could not link to " + cb + " binder death");
            cb = null;
            goto L9
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            boolean controlStreamChanged = false;
            Object r1 = AudioService.m2000$$Nest$fgetmForceControlStreamLock(this.this$0);
            monitor-enter(r1);
            Log.w(AudioService.TAG, "SCO client died");     // Catch: Throwable -> L7
            if (AudioService.m1999$$Nest$fgetmForceControlStreamClient(this.this$0) == this) goto L9;
            Log.w(AudioService.TAG, "unregistered control stream client died");     // Catch: Throwable -> L7
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (controlStreamChanged == false) goto L18;
            this.this$0.mASExt.onControlStreamInputsChanged("force_control_stream_client_died");
            return;
        L18:
            return;
        L9:
            AudioService.m2038$$Nest$fputmForceControlStreamClient(this.this$0, null);     // Catch: Throwable -> L7
            AudioService.m2047$$Nest$fputmVolumeControlStream(this.this$0, -1);     // Catch: Throwable -> L7
            AudioService.m2045$$Nest$fputmUserSelectedVolumeControlStream(this.this$0, false);     // Catch: Throwable -> L7
            controlStreamChanged = true;
        L7:
            th = move-exception;
            throw th;
        }

        public void release() {
            if (this.mCb == null) goto L6;
            this.mCb.unlinkToDeath(this, 0);
            this.mCb = null;
            return;
        }

        public IBinder getBinder() {
            return this.mCb;
        }
    }

    public interface ISafeHearingVolumeController {
        void postDisplayCsdWarning(int r1, int r2);

        void postDisplaySafeVolumeWarning(int r1);
    }

    public static final class Lifecycle extends SystemService {
        private AudioService mService;

        public static /* synthetic */ Thread $r8$lambda$6de2JXnKKk1CN0vVSo8fHCTAFzs(Runnable r0) {
            return lambda$new$0(r0);
        }

        public Lifecycle(Context context) {
            super(context);
            ScheduledExecutorService audioserverLifecycleExecutor = Executors.newSingleThreadScheduledExecutor(new AudioService$Lifecycle$$ExternalSyntheticLambda0());
            DefaultAudioPolicyFacade audioPolicyFacade = new DefaultAudioPolicyFacade(audioserverLifecycleExecutor);
            this.mService = new AudioService(context, AudioSystemAdapter.getDefaultAdapter(), SystemServerAdapter.getDefaultAdapter(context), SettingsAdapter.getDefaultAdapter(), new AudioVolumeGroupHelper(null), audioPolicyFacade, null, (AppOpsManager) context.getSystemService(AppOpsManager.class), PermissionEnforcer.fromContext(context), AudioService.m2104$$Nest$sminitializeAudioServerPermissionProvider(context, audioPolicyFacade, audioserverLifecycleExecutor), audioserverLifecycleExecutor);
        }

        private static /* synthetic */ Thread lambda$new$0(Runnable r) {
            return new Thread(r, "audioserver_lifecycle");
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("audio", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 550) goto L6;
            this.mService.systemReady();
            return;
        }
    }

    private static final class LoadSoundEffectReply implements SoundEffectsHelper.OnEffectsLoadCompleteHandler {
        private static final int SOUND_EFFECTS_ERROR = -1;
        private static final int SOUND_EFFECTS_LOADED = 0;
        private static final int SOUND_EFFECTS_LOADING = 1;
        private static final int SOUND_EFFECTS_LOAD_TIMEOUT_MS = 5000;
        private int mStatus;

        /* synthetic */ LoadSoundEffectReply(AudioServiceIA r1) {
            this();
        }

        private LoadSoundEffectReply() {
            this.mStatus = 1;
        }

        @Override // com.android.server.audio.SoundEffectsHelper.OnEffectsLoadCompleteHandler
        public synchronized void run(boolean success) {
            monitor-enter(this);
            if (success == false) goto L5;
            int r0 = 0;
        L12:
            this.mStatus = r0;     // Catch: Throwable -> L9
            notify();     // Catch: Throwable -> L9
            monitor-exit(this);
            return;
        L9:
            th = move-exception;
            throw th;
        L5:
            r0 = -1;
            goto L12
        }

        public synchronized boolean waitForLoaded(int attempts) {
            monitor-enter(this);
        L25:
        L11:
            th = move-exception;
            throw th;
        L4:
            boolean r1 = true;
            if (this.mStatus != 1) goto L17;
            int attempts2 = attempts - 1;
            if (attempts <= 0) goto L17;
            wait(5000);     // Catch: Throwable -> L11 InterruptedException -> L13
        L15:
            attempts = attempts2;
        L14:
            Log.w(AudioService.TAG, "Interrupted while waiting sound pool loaded.");     // Catch: Throwable -> L11
        L17:
            int attempts3 = this.mStatus;     // Catch: Throwable -> L11
            if (attempts3 == 0) goto L21;
            r1 = false;
        L21:
            monitor-exit(this);
            return r1;
        }
    }

    private class MyHdmiCecVolumeControlFeatureListener implements HdmiControlManager.HdmiCecVolumeControlFeatureListener {
        final /* synthetic */ AudioService this$0;

        /* synthetic */ MyHdmiCecVolumeControlFeatureListener(AudioService r1, AudioServiceIA r2) {
            this(r1);
        }

        private MyHdmiCecVolumeControlFeatureListener(AudioService r1) {
            this.this$0 = r1;
        }

        public void onHdmiCecVolumeControlFeature(int hdmiCecVolumeControl) {
            Object r0 = AudioService.m2003$$Nest$fgetmHdmiClientLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2004$$Nest$fgetmHdmiManager(this.this$0) != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            AudioService r1 = this.this$0;     // Catch: Throwable -> L8
            boolean r2 = true;
            if (hdmiCecVolumeControl == 1) goto L14;
            r2 = false;
        L14:
            AudioService.m2039$$Nest$fputmHdmiCecVolumeControlEnabled(r1, r2);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private class MyHdmiControlStatusChangeListenerCallback implements HdmiControlManager.HdmiControlStatusChangeListener {
        final /* synthetic */ AudioService this$0;

        /* synthetic */ MyHdmiControlStatusChangeListenerCallback(AudioService r1, AudioServiceIA r2) {
            this(r1);
        }

        private MyHdmiControlStatusChangeListenerCallback(AudioService r1) {
            this.this$0 = r1;
        }

        public void onStatusChange(int isCecEnabled, boolean isCecAvailable) {
            Object r0 = AudioService.m2003$$Nest$fgetmHdmiClientLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2004$$Nest$fgetmHdmiManager(this.this$0) != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            boolean r1 = false;
            boolean cecEnabled = true;
            if (isCecEnabled == 1) goto L14;
            cecEnabled = false;
        L14:
            AudioService r3 = this.this$0;     // Catch: Throwable -> L8
            if (cecEnabled == false) goto L17;
            r1 = isCecAvailable;
        L17:
            AudioService.m2099$$Nest$mupdateHdmiCecSinkLocked(r3, r1);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private static class RestorableParameters {
        private Map<String, BooleanSupplier> mMap;

        /* JADX INFO: renamed from: $r8$lambda$JVps76o3ZM2FTHiX-AHAgS-pysM, reason: not valid java name */
        public static /* synthetic */ boolean m2117$r8$lambda$JVps76o3ZM2FTHiXAHAgSpysM(BooleanSupplier r0) {
            return lambda$restoreAll$1(r0);
        }

        public static /* synthetic */ boolean $r8$lambda$l7AV0DaGl0hY4s25VX3wTbeGuso(String r0) {
            return lambda$setParameters$0(r0);
        }

        /* synthetic */ RestorableParameters(AudioServiceIA r1) {
            this();
        }

        private RestorableParameters() {
            this.mMap = new AnonymousClass1(this);
        }

        public int setParameters(String id, final String parameter) {
            id.getClass();
            parameter.getClass();
            Map<String, BooleanSupplier> r0 = this.mMap;
            monitor-enter(r0);
            int status = AudioSystem.setParameters(parameter);     // Catch: Throwable -> L7
            if (status != 0) goto L9;
            queueRestoreWithRemovalIfTrue(id, new AudioService$RestorableParameters$$ExternalSyntheticLambda1(parameter));     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return status;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$setParameters$0(String parameter) {
            if (AudioSystem.setParameters(parameter) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void queueRestoreWithRemovalIfTrue(String id, BooleanSupplier supplier) {
            id.getClass();
            Map<String, BooleanSupplier> r0 = this.mMap;
            monitor-enter(r0);
            if (supplier == null) goto L8;
            this.mMap.put(id, supplier);     // Catch: Throwable -> L6
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L8:
            this.mMap.remove(id);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        public void restoreAll() {
            Map<String, BooleanSupplier> r0 = this.mMap;
            monitor-enter(r0);
            this.mMap.values().removeIf(new AudioService$RestorableParameters$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ boolean lambda$restoreAll$1(BooleanSupplier v) {
            return v.getAsBoolean();
        }
    }

    private class RmtSbmxFullVolDeathHandler implements IBinder.DeathRecipient {
        private IBinder mICallback;
        final /* synthetic */ AudioService this$0;

        RmtSbmxFullVolDeathHandler(AudioService r3, IBinder cb) {
            this.this$0 = r3;
            this.mICallback = cb;
            cb.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(AudioService.TAG, "can't link to death", e);
        }

        boolean isHandlerFor(IBinder cb) {
            return this.mICallback.equals(cb);
        }

        void forget() {
            this.mICallback.unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(AudioService.TAG, "error unlinking to death", e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(AudioService.TAG, "Recorder with remote submix at full volume died " + this.mICallback);
            this.this$0.forceRemoteSubmixFullVolume(false, this.mICallback);
        }
    }

    class RoleObserver implements OnRoleHoldersChangedListener {
        private final Executor mExecutor;
        private RoleManager mRm;
        final /* synthetic */ AudioService this$0;

        RoleObserver(AudioService this$0) {
            this.this$0 = this$0;
            this.mExecutor = this$0.mContext.getMainExecutor();
        }

        public void register() {
            this.mRm = (RoleManager) this.this$0.mContext.getSystemService("role");
            if (this.mRm == null) goto L12;
            this.mRm.addOnRoleHoldersChangedListenerAsUser(this.mExecutor, this, UserHandle.ALL);
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            AudioService.m2098$$Nest$mupdateAssistantUIdLocked(this.this$0, true);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void onRoleHoldersChanged(String roleName, UserHandle user) {
            if ("android.app.role.ASSISTANT".equals(roleName) == false) goto L12;
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            AudioService.m2098$$Nest$mupdateAssistantUIdLocked(this.this$0, false);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public String getAssistantRoleHolder() {
            if (this.mRm == null) goto L10;
            List<String> assistants = this.mRm.getRoleHolders("android.app.role.ASSISTANT");
            if (assistants.size() != 0) goto L7;
            String r2 = "";
        L8:
            String assitantPackage = r2;
            return assitantPackage;
        L7:
            r2 = assistants.get(0);
            goto L8
        L10:
            return "";
        }
    }

    private class SetModeDeathHandler implements IBinder.DeathRecipient {
        private final IBinder mCb;
        private final boolean mIsPrivileged;
        private int mMode;
        private final String mPackage;
        private final int mPid;
        private boolean mPlaybackActive;
        private boolean mRecordingActive;
        private final int mUid;
        private long mUpdateTime;
        final /* synthetic */ AudioService this$0;

        SetModeDeathHandler(AudioService r3, IBinder cb, int pid, int uid, boolean isPrivileged, String caller, int mode) {
            this.this$0 = r3;
            this.mPlaybackActive = false;
            this.mRecordingActive = false;
            this.mMode = mode;
            this.mCb = cb;
            this.mPid = pid;
            this.mUid = uid;
            this.mPackage = caller;
            this.mIsPrivileged = isPrivileged;
            this.mUpdateTime = System.currentTimeMillis();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r1 = AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).mSetModeLock;
            monitor-enter(r1);
            Log.w(AudioService.TAG, "SetModeDeathHandler client died");     // Catch: Throwable -> L7
            int index = this.this$0.mSetModeDeathHandlers.indexOf(this);     // Catch: Throwable -> L7
            if (index >= 0) goto L9;
            Log.w(AudioService.TAG, "unregistered SetModeDeathHandler client died");     // Catch: Throwable -> L7
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L9:
            SetModeDeathHandler r2 = this.this$0.mSetModeDeathHandlers.get(index);     // Catch: Throwable -> L7
            this.this$0.mSetModeDeathHandlers.remove(index);     // Catch: Throwable -> L7
            this.this$0.postUpdateAudioMode(2, -1, Process.myPid(), this.this$0.mContext.getPackageName(), false, 0);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public int getPid() {
            return this.mPid;
        }

        public void setMode(int mode) {
            this.mMode = mode;
            this.mUpdateTime = System.currentTimeMillis();
        }

        public int getMode() {
            return this.mMode;
        }

        public IBinder getBinder() {
            return this.mCb;
        }

        public int getUid() {
            return this.mUid;
        }

        public String getPackage() {
            return this.mPackage;
        }

        public boolean isPrivileged() {
            return this.mIsPrivileged;
        }

        public long getUpdateTime() {
            return this.mUpdateTime;
        }

        public void setPlaybackActive(boolean active) {
            this.mPlaybackActive = active;
        }

        public void setRecordingActive(boolean active) {
            this.mRecordingActive = active;
        }

        public boolean isActive() {
            if (this.mIsPrivileged == false) goto L5;
            return true;
        L5:
            if (this.mMode != 3) goto L11;
            if (this.mRecordingActive == false) goto L9;
            return true;
        L9:
            if (this.mPlaybackActive == false) goto L11;
            return true;
        L11:
            if (this.mMode != 1) goto L13;
            return true;
        L13:
            if (this.mMode == 4) goto L21;
            return false;
        L21:
            return true;
        }

        public void dump(PrintWriter pw, int index) {
            SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
            if (index < 0) goto L5;
            pw.println("  Requester # " + (index + 1) + ":");
        L5:
            pw.println("  - Mode: " + AudioSystem.modeToString(this.mMode));
            pw.println("  - Binder: " + this.mCb);
            pw.println("  - Pid: " + this.mPid);
            pw.println("  - Uid: " + this.mUid);
            pw.println("  - Package: " + this.mPackage);
            pw.println("  - Privileged: " + this.mIsPrivileged);
            pw.println("  - Active: " + isActive());
            pw.println("    Playback active: " + this.mPlaybackActive);
            pw.println("    Recording active: " + this.mRecordingActive);
            pw.println("  - update time: " + format.format(new Date(this.mUpdateTime)));
        }
    }

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ AudioService this$0;

        SettingsObserver(AudioService r5) {
            this.this$0 = r5;
            super(new Handler());
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("zen_mode"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("zen_mode_config_etag"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("mute_alarm_stream_with_ringer_mode"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.System.getUriFor("mode_ringer_streams_affected"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("dock_audio_media_enabled"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.System.getUriFor("master_mono"), false, this, -1);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.System.getUriFor("master_balance"), false, this, -1);
            AudioService.m2036$$Nest$fputmEncodedSurroundMode(r5, AudioService.m2016$$Nest$fgetmSettings(r5).getGlobalInt(AudioService.m1992$$Nest$fgetmContentResolver(r5), "encoded_surround_output", 0));
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("encoded_surround_output"), false, this);
            AudioService.m2035$$Nest$fputmEnabledSurroundFormats(r5, AudioService.m2016$$Nest$fgetmSettings(r5).getGlobalString(AudioService.m1992$$Nest$fgetmContentResolver(r5), "encoded_surround_output_enabled_formats"));
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Global.getUriFor("encoded_surround_output_enabled_formats"), false, this);
            AudioService.m1992$$Nest$fgetmContentResolver(r5).registerContentObserver(Settings.Secure.getUriFor("voice_interaction_service"), false, this);
            r5.mASExt.SettingsObserver_onEnd(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange);
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mASExt.SettingsObserver_onChange_onBegin_earlyReturn(selfChange, uri) == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (AudioService.m2102$$Nest$mupdateRingerAndZenModeAffectedStreams(this.this$0) == false) goto L13;
            AudioService.m2096$$Nest$msetRingerModeInt(this.this$0, this.this$0.getRingerModeInternal(), false);     // Catch: Throwable -> L8
        L13:
            AudioService.m2087$$Nest$mreadDockAudioSettings(this.this$0, AudioService.m1992$$Nest$fgetmContentResolver(this.this$0));     // Catch: Throwable -> L8
            AudioService.m2101$$Nest$mupdateMasterMono(this.this$0, AudioService.m1992$$Nest$fgetmContentResolver(this.this$0));     // Catch: Throwable -> L8
            AudioService.m2100$$Nest$mupdateMasterBalance(this.this$0, AudioService.m1992$$Nest$fgetmContentResolver(this.this$0));     // Catch: Throwable -> L8
            updateEncodedSurroundOutput();     // Catch: Throwable -> L8
            AudioService.m2091$$Nest$msendEnabledSurroundFormats(this.this$0, AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), AudioService.m2022$$Nest$fgetmSurroundModeChanged(this.this$0));     // Catch: Throwable -> L8
            AudioService.m2098$$Nest$mupdateAssistantUIdLocked(this.this$0, false);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private void updateEncodedSurroundOutput() {
            int newSurroundMode = AudioService.m2016$$Nest$fgetmSettings(this.this$0).getGlobalInt(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), "encoded_surround_output", 0);
            if (AudioService.m1997$$Nest$fgetmEncodedSurroundMode(this.this$0) == newSurroundMode) goto L5;
            AudioService.m2092$$Nest$msendEncodedSurroundMode(this.this$0, newSurroundMode, "SettingsObserver");
            AudioService.m1993$$Nest$fgetmDeviceBroker(this.this$0).toggleHdmiIfConnected_Async();
            AudioService.m2036$$Nest$fputmEncodedSurroundMode(this.this$0, newSurroundMode);
            AudioService.m2044$$Nest$fputmSurroundModeChanged(this.this$0, true);
            return;
        L5:
            AudioService.m2044$$Nest$fputmSurroundModeChanged(this.this$0, false);
        }
    }

    static class UpdateAudioModeInfo {
        private final int mMode;
        private final String mPackageName;
        private final int mPid;

        UpdateAudioModeInfo(int mode, int pid, String packageName) {
            this.mMode = mode;
            this.mPid = pid;
            this.mPackageName = packageName;
        }

        int getMode() {
            return this.mMode;
        }

        int getPid() {
            return this.mPid;
        }

        String getPackageName() {
            return this.mPackageName;
        }
    }

    public class VolumeController implements ISafeHearingVolumeController {
        private static final String TAG = "VolumeController";
        private IVolumeController mController;
        private int mLongPressTimeout;
        private long mNextLongPress;
        private boolean mVisible;
        final /* synthetic */ AudioService this$0;

        public VolumeController(AudioService this$0) {
            this.this$0 = this$0;
        }

        public void setController(IVolumeController controller) {
            this.mController = controller;
            this.mVisible = false;
        }

        public IVolumeController getController() {
            return this.mController;
        }

        public void loadSettings(ContentResolver cr) {
            this.mLongPressTimeout = AudioService.m2016$$Nest$fgetmSettings(this.this$0).getSecureIntForUser(cr, "long_press_timeout", 500, -2);
        }

        public boolean suppressAdjustment(int resolvedStream, int flags, boolean isMute) {
            int r1 = 0;
            if (this.this$0.mASExt.suppressAdjustment_onBegin_earlyReturn(resolvedStream, flags, isMute) == false) goto L6;
            Log.d(TAG, "Suppress adjustment is disabled");
            return false;
        L6:
            if (isMute == false) goto L9;
            return false;
        L9:
            if (resolvedStream == AudioService.DEFAULT_VOL_STREAM_NO_PLAYBACK) goto L11;
            return false;
        L11:
            if (this.mController != null) goto L13;
            return false;
        L13:
            if (resolvedStream == 3) goto L15;
        L17:
            long now = SystemClock.uptimeMillis();
            if ((flags & 1) == 0) goto L30;
            if (this.mVisible == true) goto L30;
            if (this.mNextLongPress < now) goto L24;
        L28:
            return true;
        L24:
            if (AudioService.m2028$$Nest$fgetmVolumeControllerLongPressEnabled(this.this$0).get() == false) goto L27;
            r1 = this.mLongPressTimeout;
        L27:
            this.mNextLongPress = ((long) r1) + now;
        L30:
            if (this.mNextLongPress > 0) goto L32;
            return false;
        L32:
            if (now <= this.mNextLongPress) goto L34;
            this.mNextLongPress = 0;
            return false;
        L34:
            return true;
        L15:
            if (AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).isStreamActive(3, this.mLongPressTimeout) == false) goto L17;
            return false;
        }

        public void setVisible(boolean visible) {
            this.mVisible = visible;
        }

        public boolean isSameBinder(IVolumeController controller) {
            return Objects.equals(asBinder(), binder(controller));
        }

        public IBinder asBinder() {
            return binder(this.mController);
        }

        private IBinder binder(IVolumeController controller) {
            if (controller != null) goto L5;
            return null;
        L5:
            return controller.asBinder();
        }

        public String toString() {
            return "VolumeController(" + asBinder() + ",mVisible=" + this.mVisible + ")";
        }

        @Override // com.android.server.audio.AudioService.ISafeHearingVolumeController
        public void postDisplaySafeVolumeWarning(int flags) {
            if (this.mController != null) goto L5;
            return;
        L5:
            int flags2 = flags | 1;
            this.mController.displaySafeVolumeWarning(flags2);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Log.w(TAG, "Error calling displaySafeVolumeWarning", e);
        }

        @Override // com.android.server.audio.AudioService.ISafeHearingVolumeController
        public void postDisplayCsdWarning(int csdWarning, int displayDurationMs) {
            if (this.mController != null) goto L11;
            Log.e(TAG, "Unable to display CSD warning, no controller");
            return;
        L11:
            this.mController.displayCsdWarning(csdWarning, displayDurationMs);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            Log.w(TAG, "Error calling displayCsdWarning for warning " + csdWarning, e);
        }

        public void postVolumeChanged(int streamType, int flags) {
            if (this.mController != null) goto L10;
            return;
        L10:
            this.mController.volumeChanged(streamType, flags);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.w(TAG, "Error calling volumeChanged", e);
        }

        public void postMasterMuteChanged(int flags) {
            if (this.mController != null) goto L10;
            return;
        L10:
            this.mController.masterMuteChanged(flags);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.w(TAG, "Error calling masterMuteChanged", e);
        }

        public void setLayoutDirection(int layoutDirection) {
            if (this.mController != null) goto L10;
            return;
        L10:
            this.mController.setLayoutDirection(layoutDirection);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.w(TAG, "Error calling setLayoutDirection", e);
        }

        public void postDismiss() {
            if (this.mController != null) goto L10;
            return;
        L10:
            this.mController.dismiss();     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.w(TAG, "Error calling dismiss", e);
        }

        public void setA11yMode(int a11yMode) {
            if (this.mController != null) goto L10;
            return;
        L10:
            this.mController.setA11yMode(a11yMode);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.w(TAG, "Error calling setA11Mode", e);
        }
    }

    private class VolumeGroupState {
        private AudioAttributes mAudioAttributes;
        private final AudioVolumeGroup mAudioVolumeGroup;
        private boolean mHasValidStreamType;
        private final SparseIntArray mIndexMap;
        private int mIndexMax;
        private int mIndexMin;
        private boolean mIsMuted;
        private int mPublicStreamType;
        private String mSettingName;
        final /* synthetic */ AudioService this$0;

        /* JADX INFO: renamed from: $r8$lambda$gCNLKhwqvcsugo2bjA3Lt37fh-s, reason: not valid java name */
        public static /* synthetic */ void m2118$r8$lambda$gCNLKhwqvcsugo2bjA3Lt37fhs(PrintWriter r0, int r1) {
            lambda$dump$0(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIndexMin, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2119$$Nest$fputmIndexMin(VolumeGroupState r0, int r1) {
            r0.mIndexMin = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2120$$Nest$mdump(VolumeGroupState r0, PrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$misVssMuteBijective, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2121$$Nest$misVssMuteBijective(VolumeGroupState r0, int r1) {
            return r0.isVssMuteBijective(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mpersistVolumeGroup, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2122$$Nest$mpersistVolumeGroup(VolumeGroupState r0, int r1) {
            r0.persistVolumeGroup(r1);
        }

        /* synthetic */ VolumeGroupState(AudioService r1, AudioVolumeGroup r2, AudioServiceIA r3) {
            this(r1, r2);
        }

        private int getDeviceForVolume() {
            return this.this$0.getDeviceForStream(this.mPublicStreamType);
        }

        private VolumeGroupState(AudioService r7, AudioVolumeGroup avg) {
            this.this$0 = r7;
            this.mIndexMap = new SparseIntArray(8);
            int r0 = 0;
            this.mHasValidStreamType = false;
            this.mPublicStreamType = 3;
            this.mAudioAttributes = AudioProductStrategy.getDefaultAttributes();
            this.mIsMuted = false;
            this.mAudioVolumeGroup = avg;
            Log.v(AudioService.TAG, "VolumeGroupState for " + avg.toString());
            Iterator r1 = avg.getAudioAttributes().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            AudioAttributes aa = (AudioAttributes) r1.next();
            if (aa.equals(this.mAudioAttributes) == true) goto L4;
            this.mAudioAttributes = aa;
        L9:
            int[] streamTypes = this.mAudioVolumeGroup.getLegacyStreamTypes();
            String streamSettingName = "";
            if (streamTypes.length == 0) goto L22;
            int r3 = streamTypes.length;
        L13:
            if (r0 >= r3) goto L20;
            int streamType = streamTypes[r0];
            if (streamType == (-1)) goto L19;
            if (streamType >= AudioSystem.getNumStreamTypes()) goto L19;
            this.mPublicStreamType = streamType;
            this.mHasValidStreamType = true;
            streamSettingName = Settings.System.VOLUME_SETTINGS_INT[this.mPublicStreamType];
        L19:
            r0 = r0 + 1;
        L20:
            this.mIndexMin = r7.getVssForStreamOrDefault(this.mPublicStreamType).getMinIndex() / 10;
            this.mIndexMax = r7.getVssForStreamOrDefault(this.mPublicStreamType).getMaxIndex() / 10;
        L25:
            if (streamSettingName.isEmpty() == true) goto L27;
            String r8 = streamSettingName;
        L28:
            this.mSettingName = r8;
            readSettings();
            return;
        L27:
            r8 = "volume_" + name();
            goto L28
        L22:
            if (avg.getAudioAttributes().isEmpty() == true) goto L31;
            this.mIndexMin = AudioSystem.getMinVolumeIndexForAttributes(this.mAudioAttributes);
            this.mIndexMax = AudioSystem.getMaxVolumeIndexForAttributes(this.mAudioAttributes);
            goto L25
        L31:
            throw new IllegalArgumentException("volume group: " + this.mAudioVolumeGroup.name() + " has neither valid attributes nor valid stream types assigned");
        }

        public int[] getLegacyStreamTypes() {
            return this.mAudioVolumeGroup.getLegacyStreamTypes();
        }

        public String name() {
            return this.mAudioVolumeGroup.name();
        }

        public int getId() {
            return this.mAudioVolumeGroup.getId();
        }

        private boolean isVssMuteBijective(int stream) {
            if (this.this$0.isStreamAffectedByMute(stream) == true) goto L5;
        L11:
            return false;
        L5:
            if (getMinIndex() != ((this.this$0.getVssForStreamOrDefault(stream).getMinIndex() + 5) / 10)) goto L11;
            if (getMinIndex() != 0) goto L9;
        L10:
            return true;
        L9:
            if (AudioService.m2105$$Nest$smisCallStream(stream) == false) goto L11;
            goto L10
        }

        private boolean isMutable() {
            if (this.mIndexMin != 0) goto L5;
        L10:
            return true;
        L5:
            if (this.mHasValidStreamType == true) goto L7;
        L9:
            return false;
        L7:
            if (isVssMuteBijective(this.mPublicStreamType) == false) goto L9;
            goto L9
        }

        public boolean mute(boolean muted) {
            if (isMutable() == true) goto L7;
            Log.d(AudioService.TAG, "invalid mute on unmutable volume group " + name());
            return false;
        L7:
            if (this.mIsMuted == muted) goto L9;
            boolean changed = true;
        L10:
            if (changed == false) goto L12;
            this.mIsMuted = muted;
            applyAllVolumes(false);
        L12:
            return changed;
        L9:
            changed = false;
            goto L10
        }

        public boolean isMuted() {
            return this.mIsMuted;
        }

        public void adjustVolume(int direction, int flags) {
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);     // Catch: Throwable -> L14
            monitor-enter(r1);     // Catch: Throwable -> L14
            int device = getDeviceForVolume();     // Catch: Throwable -> L16
            int previousIndex = getIndex(device);     // Catch: Throwable -> L16
            if (AudioService.m2056$$Nest$misMuteAdjust(this.this$0, direction) == true) goto L9;
        L18:
            float stepFactor = this.this$0.getVssForStreamOrDefault(this.mPublicStreamType).getIndexStepFactor();     // Catch: Throwable -> L16
            boolean r5 = false;
            switch(direction) {
                case -100: goto L32;
                case -1: goto L28;
                case 1: goto L26;
                case 100: goto L25;
                case 101: goto L22;
                default: goto L35;
            };     // Catch: Throwable -> L16
        L25:
            mute(false);     // Catch: Throwable -> L16
            goto L35
        L26:
            setVolumeIndex(Math.min((int) ((previousIndex + 1) * stepFactor), this.mIndexMax), device, flags);     // Catch: Throwable -> L16
            goto L35
        L32:
            if (previousIndex == 0) goto L34;
            mute(true);     // Catch: Throwable -> L16
        L34:
            this.mIsMuted = true;     // Catch: Throwable -> L16
        L35:
            monitor-exit(r1);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L22:
            if (this.mIsMuted == true) goto L24;
            r5 = true;
        L24:
            mute(r5);     // Catch: Throwable -> L16
            goto L35
        L28:
            if (isMuted() == false) goto L31;
            if (previousIndex == 0) goto L31;
            mute(false);     // Catch: Throwable -> L16
        L31:
            int newIndex = Math.max((int) ((previousIndex - 1) * stepFactor), this.mIndexMin);     // Catch: Throwable -> L16
            setVolumeIndex(newIndex, device, flags);     // Catch: Throwable -> L16
            goto L35
        L9:
            if (isMutable() == true) goto L18;
            Log.d(AudioService.TAG, "invalid mute on unmutable volume group " + name());     // Catch: Throwable -> L16
            monitor-exit(r1);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public int getVolumeIndex() {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
            int r1 = getIndex(getDeviceForVolume());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setVolumeIndex(int index, int flags) {
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);     // Catch: Throwable -> L11
            monitor-enter(r1);     // Catch: Throwable -> L11
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L7:
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L15;
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L15:
            setVolumeIndex(index, getDeviceForVolume(), flags);     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        private void setVolumeIndex(int index, int device, int flags) {
            updateVolumeIndex(index, device);
            if (index != 0) goto L5;
            boolean r0 = true;
        L6:
            boolean changed = mute(r0);
            if (changed == true) goto L10;
            setVolumeIndexInt(getValidIndex(index), device, flags);
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void updateVolumeIndex(int index, int device) {
            if (this.mIndexMap.indexOfKey(device) >= 0) goto L5;
        L8:
            this.mIndexMap.put(device, getValidIndex(index));
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 2, 2, device, 0, this, 500);
            return;
        L5:
            if (this.mIndexMap.get(device) != index) goto L8;
        }

        private void setVolumeIndexInt(int index, int device, int flags) {
            if (this.mHasValidStreamType == false) goto L10;
            if (isVssMuteBijective(this.mPublicStreamType) == false) goto L10;
            if (this.this$0.getVssForStreamOrDefault(this.mPublicStreamType).isFullyMuted() == false) goto L10;
            index = 0;
        L13:
            int index2 = (int) (this.mIndexMin + ((index - this.mIndexMin) / this.this$0.getVssForStreamOrDefault(this.mPublicStreamType).getIndexStepFactor()));
            Log.d(AudioService.TAG, "setVolumeIndexInt(" + this.mAudioVolumeGroup.getId() + ", " + index2 + ", false, " + device + ")");
            int index3 = this.this$0.mASExt.setStreamVolumeIndex_capIndex(this.mPublicStreamType, index2, false, device);
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setVolumeIndexForAttributes(this.mAudioAttributes, index3, false, device);
            if (this.mPublicStreamType != 6) goto L16;
        L17:
            Log.i(AudioService.TAG, "setVolumeIndexInt mPublicStreamType" + this.mPublicStreamType + ", index = " + index3 + ", device = " + device);
            if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == true) goto L21;
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setStreamVolumeIndexAS(this.mPublicStreamType, index3, false, 128);
        L21:
            if (AudioSystem.DEVICE_OUT_ALL_SCO_SET.contains(Integer.valueOf(device)) == true) goto L25;
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setStreamVolumeIndexAS(this.mPublicStreamType, index3, false, 16);
            return;
        L25:
            return;
        L16:
            if (this.mPublicStreamType == 0) goto L17;
            return;
        L10:
            if (AudioService.m2058$$Nest$misStreamBluetoothSco(this.this$0, this.mPublicStreamType) == false) goto L13;
            if (index != 0) goto L13;
            index = 1;
            goto L13
        }

        private int getIndex(int device) {
            int index = this.mIndexMap.get(device, -1);
            if (index == (-1)) goto L6;
            return index;
        L6:
            return this.mIndexMap.get(1073741824);
        }

        private boolean hasIndexForDevice(int device) {
            if (this.mIndexMap.get(device, -1) == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public int getMaxIndex() {
            return this.mIndexMax;
        }

        public int getMinIndex() {
            return this.mIndexMin;
        }

        private boolean isValidStream(int stream) {
            if (stream != (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.getVssForStream(stream) == null) goto L7;
            return true;
        }

        public boolean isMusic() {
            if (this.mHasValidStreamType == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mPublicStreamType != 3) goto L7;
            return true;
        }

        public boolean isVoiceCall() {
            if (this.mHasValidStreamType == true) goto L5;
        L7:
            return false;
        L5:
            if (this.mPublicStreamType != 0) goto L7;
            return true;
        }

        public void applyAllVolumes(boolean userSwitch) {
            Object r3 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r3);
            int i = 0;
        L90:
            int r5 = 1073741824;
            if (i >= this.mIndexMap.size()) goto L44;
            int device = this.mIndexMap.keyAt(i);     // Catch: Throwable -> L22
            int index = this.mIndexMap.valueAt(i);     // Catch: Throwable -> L22
            boolean synced = false;
            if (device == 1073741824) goto L42;
            int[] r6 = getLegacyStreamTypes();     // Catch: Throwable -> L22
            int r10 = r6.length;     // Catch: Throwable -> L22
            int r11 = 0;
        L10:
            if (r11 >= r10) goto L35;
            int stream = r6[r11];     // Catch: Throwable -> L22
            if (isValidStream(stream) == false) goto L33;
            VolumeStreamState vss = this.this$0.getVssForStreamOrDefault(stream);     // Catch: Throwable -> L22
            boolean streamMuted = VolumeStreamState.m2126$$Nest$fgetmIsMuted(vss);     // Catch: Throwable -> L22
            int deviceForStream = this.this$0.getDeviceForStream(stream);     // Catch: Throwable -> L22
            int indexForStream = (vss.getIndex(deviceForStream) + 5) / 10;     // Catch: Throwable -> L22
            if (device == deviceForStream) goto L16;
            i = i;
        L34:
            r11 = r11 + 1;     // Catch: Throwable -> L22
            i = i;
            goto L10
        L16:
            if (indexForStream != index) goto L25;
            if (isMuted() != streamMuted) goto L25;
            if (isVssMuteBijective(stream) == false) goto L25;
            i = i;
            synced = true;
        L25:
            if (isMuted() == streamMuted) goto L30;
            if (isVssMuteBijective(stream) == false) goto L30;
            vss.mute(isMuted(), "VGS.applyAllVolumes#1");     // Catch: Throwable -> L22
        L30:
            if (indexForStream == index) goto L34;
            vss.setIndex(index * 10, device, "from vgs", true);     // Catch: Throwable -> L22
            goto L34
        L33:
            i = i;
            goto L34
        L35:
            int i2 = i;
            if (synced == true) goto L43;
            Log.d(AudioService.TAG, "applyAllVolumes: apply index " + index + ", group " + this.mAudioVolumeGroup.name() + " and device " + AudioSystem.getOutputDeviceName(device));     // Catch: Throwable -> L22
            if (isMuted() == false) goto L40;
            int r0 = 0;
        L41:
            setVolumeIndexInt(r0, device, 0);     // Catch: Throwable -> L22
            goto L43
        L40:
            r0 = index;
        L43:
            i = i2 + 1;     // Catch: Throwable -> L22
            goto L90
        L42:
            i2 = i;
            goto L43
        L44:
            int index2 = getIndex(1073741824);     // Catch: Throwable -> L22
            boolean synced2 = false;
            int deviceForVolume = getDeviceForVolume();     // Catch: Throwable -> L22
            if (userSwitch == true) goto L47;
        L49:
            boolean forceDeviceSync = false;
        L50:
            int[] r8 = getLegacyStreamTypes();     // Catch: Throwable -> L22
            int r9 = r8.length;     // Catch: Throwable -> L22
            int r12 = 0;
        L51:
            if (r12 >= r9) goto L74;
            int stream2 = r8[r12];     // Catch: Throwable -> L22
            if (isValidStream(stream2) == false) goto L71;
            VolumeStreamState vss2 = this.this$0.getVssForStreamOrDefault(stream2);     // Catch: Throwable -> L22
            boolean streamMuted2 = VolumeStreamState.m2126$$Nest$fgetmIsMuted(vss2);     // Catch: Throwable -> L22
            int defaultStreamIndex = (vss2.getIndex(r5) + 5) / 10;     // Catch: Throwable -> L22
            if (forceDeviceSync == false) goto L57;
            vss2.setIndex(index2 * 10, deviceForVolume, "from vgs", true);     // Catch: Throwable -> L22
        L57:
            if (defaultStreamIndex == index2) goto L59;
        L63:
            if (defaultStreamIndex == index2) goto L67;
            vss2.setIndex(index2 * 10, 1073741824, "from vgs", true);     // Catch: Throwable -> L22
        L67:
            if (isMuted() == streamMuted2) goto L72;
            if (isVssMuteBijective(stream2) == false) goto L72;
            vss2.mute(isMuted(), "VGS.applyAllVolumes#2");     // Catch: Throwable -> L22
        L72:
            r12 = r12 + 1;     // Catch: Throwable -> L22
            synced2 = synced2;
            r5 = 1073741824;
            goto L51
        L59:
            if (isMuted() != streamMuted2) goto L63;
            if (isVssMuteBijective(stream2) == false) goto L63;
            synced2 = true;
            goto L72
        L71:
            synced2 = synced2;
            goto L72
        L74:
            if (synced2 == true) goto L80;
            Log.d(AudioService.TAG, "applyAllVolumes: apply default device index " + index2 + ", group " + this.mAudioVolumeGroup.name());     // Catch: Throwable -> L22
            if (isMuted() == false) goto L78;
            int r4 = 0;
        L79:
            setVolumeIndexInt(r4, 1073741824, 0);     // Catch: Throwable -> L22
            goto L80
        L78:
            r4 = index2;
        L80:
            if (forceDeviceSync == false) goto L86;
            Log.d(AudioService.TAG, "applyAllVolumes: forceDeviceSync index " + index2 + ", device " + AudioSystem.getOutputDeviceName(deviceForVolume) + ", group " + this.mAudioVolumeGroup.name());     // Catch: Throwable -> L22
            if (isMuted() == false) goto L84;
            int r7 = 0;
        L85:
            setVolumeIndexInt(r7, deviceForVolume, 0);     // Catch: Throwable -> L22
            goto L86
        L84:
            r7 = index2;
        L86:
            monitor-exit(r3);     // Catch: Throwable -> L22
            return;
        L47:
            if (this.mIndexMap.indexOfKey(deviceForVolume) >= 0) goto L49;
            forceDeviceSync = true;
        L22:
            th = move-exception;
            throw th;
        }

        public void clearIndexCache() {
            this.mIndexMap.clear();
        }

        private int getVolumePersistenceUserId() {
            if (isMusic() == true) goto L5;
        L7:
            return -2;
        L5:
            if (this.this$0.isPlatformAutomotive() == true) goto L7;
            return 0;
        }

        private void persistVolumeGroup(int device) {
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L5;
            return;
        L5:
            if (this.mHasValidStreamType == true) goto L21;
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
            Log.v(AudioService.TAG, "persistVolumeGroup: storing index " + getIndex(device) + " for group " + this.mAudioVolumeGroup.name() + ", device " + AudioSystem.getOutputDeviceName(device) + " and User=" + AudioService.m2050$$Nest$mgetCurrentUserId(this.this$0) + " mSettingName: " + this.mSettingName);     // Catch: Throwable -> L12
            boolean success = AudioService.m2016$$Nest$fgetmSettings(this.this$0).putSystemIntForUser(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), getSettingNameForDevice(device), getIndex(device), getVolumePersistenceUserId());     // Catch: Throwable -> L12
            if (success == true) goto L14;
            Log.e(AudioService.TAG, "persistVolumeGroup failed for group " + this.mAudioVolumeGroup.name());     // Catch: Throwable -> L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void readSettings() {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L11;
            this.mIndexMap.put(1073741824, this.mIndexMax);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            Iterator r1 = AudioSystem.DEVICE_OUT_ALL_SET.iterator();     // Catch: Throwable -> L9
        L13:
            if (r1.hasNext() == false) goto L27;
            int device = ((Integer) r1.next()).intValue();     // Catch: Throwable -> L9
            if (device != 1073741824) goto L17;
            int defaultIndex = AudioSystem.DEFAULT_STREAM_VOLUME[this.mPublicStreamType];     // Catch: Throwable -> L9
        L18:
            String name = getSettingNameForDevice(device);     // Catch: Throwable -> L9
            int index = AudioService.m2016$$Nest$fgetmSettings(this.this$0).getSystemIntForUser(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), name, defaultIndex, getVolumePersistenceUserId());     // Catch: Throwable -> L9
            if (index == (-1)) goto L13;
            if (this.mPublicStreamType == 7) goto L24;
        L26:
            Log.v(AudioService.TAG, "readSettings: found stored index " + getValidIndex(index) + " for group " + this.mAudioVolumeGroup.name() + ", device: " + name + ", User=" + AudioService.m2050$$Nest$mgetCurrentUserId(this.this$0));     // Catch: Throwable -> L9
            this.mIndexMap.put(device, getValidIndex(index));     // Catch: Throwable -> L9
            goto L13
        L24:
            if (AudioService.m1991$$Nest$fgetmCameraSoundForced(this.this$0).get() == false) goto L26;
            index = this.mIndexMax;     // Catch: Throwable -> L9
            goto L26
        L17:
            defaultIndex = -1;
            goto L18
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        private int getValidIndex(int index) {
            if (index >= this.mIndexMin) goto L7;
            return this.mIndexMin;
        L7:
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == true) goto L13;
            if (index > this.mIndexMax) goto L13;
            return index;
        L13:
            return this.mIndexMax;
        }

        public String getSettingNameForDevice(int device) {
            String suffix = AudioSystem.getOutputDeviceName(device);
            if (suffix.isEmpty() == false) goto L7;
            return this.mSettingName;
        L7:
            return this.mSettingName + "_" + AudioSystem.getOutputDeviceName(device);
        }

        void setSettingName(String settingName) {
            this.mSettingName = settingName;
        }

        String getSettingName() {
            return this.mSettingName;
        }

        private void dump(final PrintWriter pw) {
            pw.println("- VOLUME GROUP " + this.mAudioVolumeGroup.name() + ":");
            pw.print("   Muted: ");
            pw.println(this.mIsMuted);
            pw.print("   Min: ");
            pw.println(this.mIndexMin);
            pw.print("   Max: ");
            pw.println(this.mIndexMax);
            pw.print("   Current: ");
            int i = 0;
        L4:
            if (i >= this.mIndexMap.size()) goto L15;
            if (i <= 0) goto L7;
            pw.print(", ");
        L7:
            int device = this.mIndexMap.keyAt(i);
            pw.print(Integer.toHexString(device));
            if (device != 1073741824) goto L10;
            String deviceName = "default";
        L12:
            if (deviceName.isEmpty() == true) goto L14;
            pw.print(" (");
            pw.print(deviceName);
            pw.print(")");
        L14:
            pw.print(": ");
            pw.print(this.mIndexMap.valueAt(i));
            i = i + 1;
            goto L4
        L10:
            deviceName = AudioSystem.getOutputDeviceName(device);
            goto L12
        L15:
            pw.println();
            pw.print("   Devices: ");
            int n = 0;
            int devices = getDeviceForVolume();
            Iterator r3 = AudioSystem.DEVICE_OUT_ALL_SET.iterator();
        L17:
            if (r3.hasNext() == false) goto L25;
            int device2 = ((Integer) r3.next()).intValue();
            if ((devices & device2) != device2) goto L17;
            int n2 = n + 1;
            if (n <= 0) goto L23;
            pw.print(", ");
        L23:
            pw.print(AudioSystem.getOutputDeviceName(device2));
            n = n2;
            goto L17
        L25:
            pw.println();
            pw.print("   Streams: ");
            Arrays.stream(getLegacyStreamTypes()).forEach(new AudioService$VolumeGroupState$$ExternalSyntheticLambda0(pw));
        }

        private static /* synthetic */ void lambda$dump$0(PrintWriter pw, int stream) {
            pw.print(AudioSystem.streamToString(stream) + " ");
        }
    }

    class VolumeStreamState {
        private final SparseIntArray mIndexMap;
        private int mIndexMax;
        private int mIndexMin;
        private int mIndexMinNoPerm;
        private float mIndexStepFactor;
        private boolean mIsMuted;
        private boolean mIsMutedInternally;
        private Set<Integer> mObservedDeviceSet;
        private final Intent mStreamDevicesChanged;
        private final Bundle mStreamDevicesChangedOptions;
        private final int mStreamType;
        private final Intent mVolumeChanged;
        private final Bundle mVolumeChangedOptions;
        private VolumeGroupState mVolumeGroupState;
        private String mVolumeIndexSettingName;
        final /* synthetic */ AudioService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmIndexMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseIntArray m2123$$Nest$fgetmIndexMap(VolumeStreamState r0) {
            return r0.mIndexMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIndexMax, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2124$$Nest$fgetmIndexMax(VolumeStreamState r0) {
            return r0.mIndexMax;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIndexMin, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2125$$Nest$fgetmIndexMin(VolumeStreamState r0) {
            return r0.mIndexMin;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsMuted, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2126$$Nest$fgetmIsMuted(VolumeStreamState r0) {
            return r0.mIsMuted;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStreamType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m2127$$Nest$fgetmStreamType(VolumeStreamState r0) {
            return r0.mStreamType;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmIsMuted, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2128$$Nest$fputmIsMuted(VolumeStreamState r0, boolean r1) {
            r0.mIsMuted = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m2129$$Nest$mdump(VolumeStreamState r0, PrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mhasValidSettingsName, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2130$$Nest$mhasValidSettingsName(VolumeStreamState r0) {
            return r0.hasValidSettingsName();
        }

        /* JADX INFO: renamed from: -$$Nest$misMutable, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m2131$$Nest$misMutable(VolumeStreamState r0) {
            return r0.isMutable();
        }

        /* synthetic */ VolumeStreamState(AudioService r1, String r2, int r3, AudioServiceIA r4) {
            this(r1, r2, r3);
        }

        private VolumeStreamState(AudioService this$0, String settingName, int streamType) {
            this.this$0 = this$0;
            this.mVolumeGroupState = null;
            this.mIndexStepFactor = 1.0f;
            this.mIsMuted = false;
            this.mIsMutedInternally = false;
            this.mObservedDeviceSet = new TreeSet();
            final int r1 = 8;
            this.mIndexMap = new AnonymousClass1(this, r1);
            this.mVolumeIndexSettingName = settingName;
            this.mStreamType = streamType;
            this.mIndexMin = AudioService.MIN_STREAM_VOLUME[streamType] * 10;
            this.mIndexMax = AudioService.MAX_STREAM_VOLUME[streamType] * 10;
            updateIndexFactors();
            this.mIndexMinNoPerm = this.mIndexMin;
            readSettings();
            this.mVolumeChanged = new Intent("android.media.VOLUME_CHANGED_ACTION");
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", this.mStreamType);
            BroadcastOptions volumeChangedOptions = BroadcastOptions.makeBasic();
            volumeChangedOptions.setDeliveryGroupPolicy(1);
            volumeChangedOptions.setDeliveryGroupMatchingKey("android.media.VOLUME_CHANGED_ACTION", String.valueOf(this.mStreamType));
            volumeChangedOptions.setDeferralPolicy(2);
            this.mVolumeChangedOptions = volumeChangedOptions.toBundle();
            this.mStreamDevicesChanged = new Intent("android.media.STREAM_DEVICES_CHANGED_ACTION");
            this.mStreamDevicesChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", this.mStreamType);
            BroadcastOptions streamDevicesChangedOptions = BroadcastOptions.makeBasic();
            streamDevicesChangedOptions.setDeliveryGroupPolicy(1);
            streamDevicesChangedOptions.setDeliveryGroupMatchingKey("android.media.STREAM_DEVICES_CHANGED_ACTION", String.valueOf(this.mStreamType));
            streamDevicesChangedOptions.setDeferralPolicy(2);
            this.mStreamDevicesChangedOptions = streamDevicesChangedOptions.toBundle();
        }

        public void updateIndexFactors() {
            int indexMinVolCurve = AudioService.MIN_STREAM_VOLUME[this.mStreamType];
            int indexMaxVolCurve = AudioService.MAX_STREAM_VOLUME[this.mStreamType];
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mStreamType == 0) goto L7;
        L23:
            monitor-exit(this);     // Catch: Throwable -> L9
            int status = AudioSystem.initStreamVolume(this.mStreamType, indexMinVolCurve, indexMaxVolCurve);
            AudioService.sVolumeLogger.enqueue(new EventLogger.StringEvent("updateIndexFactors() stream:" + this.mStreamType + " index min/max:" + (this.mIndexMin / 10) + SliceClientPermissions.SliceAuthority.DELIMITER + (this.mIndexMax / 10) + " indexStepFactor:" + this.mIndexStepFactor).printSlog(0, AudioService.TAG));
            if (status == 0) goto L32;
            AudioService.sVolumeLogger.enqueue(new EventLogger.StringEvent("Failed initStreamVolume with status=" + status).printSlog(1, AudioService.TAG));
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 34, 1, 0, 0, "updateIndexFactors()", 2000);
            return;
        L32:
            return;
        L7:
            if (AudioService.MAX_STREAM_VOLUME[6] <= AudioService.MAX_STREAM_VOLUME[this.mStreamType]) goto L12;
            this.mIndexMax = AudioService.MAX_STREAM_VOLUME[6] * 10;     // Catch: Throwable -> L9
        L12:
            if (AudioService.m2057$$Nest$misStreamBluetoothComm(this.this$0, this.mStreamType) == true) goto L14;
            this.mIndexMin = AudioService.MIN_STREAM_VOLUME[0] * 10;     // Catch: Throwable -> L9
            this.mIndexStepFactor = (this.mIndexMax - this.mIndexMin) / ((AudioService.MAX_STREAM_VOLUME[this.mStreamType] * 10) - (AudioService.MIN_STREAM_VOLUME[this.mStreamType] * 10));     // Catch: Throwable -> L9
        L20:
            if (this.mVolumeGroupState == null) goto L22;
            VolumeGroupState.m2119$$Nest$fputmIndexMin(this.mVolumeGroupState, this.mIndexMin);     // Catch: Throwable -> L9
        L22:
            this.mIndexMinNoPerm = this.mIndexMin;     // Catch: Throwable -> L9
            goto L23
        L14:
            if (AudioService.m1990$$Nest$fgetmBtCommDeviceActive(this.this$0).get() != 1) goto L16;
            this.mIndexMin = AudioService.MIN_STREAM_VOLUME[6] * 10;     // Catch: Throwable -> L9
            indexMinVolCurve = AudioService.MIN_STREAM_VOLUME[6];     // Catch: Throwable -> L9
            indexMaxVolCurve = AudioService.MAX_STREAM_VOLUME[6];     // Catch: Throwable -> L9
        L17:
            this.mIndexStepFactor = 1.0f;     // Catch: Throwable -> L9
            goto L20
        L16:
            this.mIndexMin = AudioService.MIN_STREAM_VOLUME[this.mStreamType] * 10;     // Catch: Throwable -> L9
            goto L17
        }

        public void setVolumeGroupState(VolumeGroupState volumeGroupState) {
            this.mVolumeGroupState = volumeGroupState;
            if (this.mVolumeGroupState == null) goto L6;
            this.mVolumeGroupState.setSettingName(this.mVolumeIndexSettingName);
            return;
        }

        public float getIndexStepFactor() {
            return this.mIndexStepFactor;
        }

        public void updateNoPermMinIndex(int index) {
            this.mIndexMinNoPerm = index * 10;
            if (this.mIndexMinNoPerm >= this.mIndexMin) goto L5;
            Log.e(AudioService.TAG, "Invalid mIndexMinNoPerm for stream " + this.mStreamType);
            this.mIndexMinNoPerm = this.mIndexMin;
        L5:
            if (0 == 0) goto L8;
            Log.d(AudioService.TAG, "Clear min volume cache from updateNoPermMinIndex");
            AudioManager.clearVolumeCache("getStreamMinVolume");
            return;
        }

        public Set<Integer> observeDevicesForStream_syncVSS(boolean checkOthers) {
            if (AudioService.m2024$$Nest$fgetmSystemServer(this.this$0).isPrivileged() == false) goto L5;
            Set<Integer> deviceSet = AudioService.m2051$$Nest$mgetDeviceSetForStreamDirect(this.this$0, this.mStreamType);
            if (deviceSet.equals(this.mObservedDeviceSet) == true) goto L9;
            int devices = AudioSystem.getDeviceMaskFromSet(deviceSet);
            int prevDevices = AudioSystem.getDeviceMaskFromSet(this.mObservedDeviceSet);
            this.mObservedDeviceSet = deviceSet;
            if (checkOthers == false) goto L14;
            this.this$0.postObserveDevicesForAllStreams(this.mStreamType);
        L14:
            if (AudioService.sStreamVolumeAlias.get(this.mStreamType, -1) != this.mStreamType) goto L16;
            EventLogTags.writeStreamDevicesChanged(this.mStreamType, prevDevices, devices);
        L16:
            SomeArgs args = SomeArgs.obtain();
            args.arg1 = this.mStreamDevicesChanged;
            args.arg2 = this.mStreamDevicesChangedOptions;
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 32, 2, prevDevices, devices, args, 0);
            return this.mObservedDeviceSet;
        L9:
            return this.mObservedDeviceSet;
        L5:
            return new TreeSet();
        }

        public String getSettingNameForDevice(int device) {
            if (hasValidSettingsName() == true) goto L6;
            return null;
        L6:
            String suffix = AudioSystem.getOutputDeviceName(device);
            if (suffix.isEmpty() == false) goto L11;
            return this.mVolumeIndexSettingName;
        L11:
            return this.mVolumeIndexSettingName + "_" + suffix;
        }

        private boolean hasValidSettingsName() {
            if (this.mVolumeIndexSettingName != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mVolumeIndexSettingName.isEmpty() == true) goto L7;
            return true;
        }

        void setSettingName(String settingName) {
            this.mVolumeIndexSettingName = settingName;
            if (this.mVolumeGroupState == null) goto L6;
            this.mVolumeGroupState.setSettingName(this.mVolumeIndexSettingName);
            return;
        }

        String getSettingName() {
            return this.mVolumeIndexSettingName;
        }

        public void readSettings() {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == false) goto L12;
            this.mIndexMap.put(1073741824, this.mIndexMax);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.mStreamType == 1) goto L32;
            if (this.mStreamType == 7) goto L32;
            Iterator r1 = AudioSystem.DEVICE_OUT_ALL_SET.iterator();     // Catch: Throwable -> L9
        L18:
            if (r1.hasNext() == false) goto L30;
            int device = ((Integer) r1.next()).intValue();     // Catch: Throwable -> L9
            if (device != 1073741824) goto L22;
            int defaultIndex = AudioSystem.DEFAULT_STREAM_VOLUME[this.mStreamType];     // Catch: Throwable -> L9
        L24:
            if (hasValidSettingsName() == true) goto L26;
            int index = defaultIndex;
        L27:
            if (index == (-1)) goto L18;
            this.mIndexMap.put(device, getValidIndex(index * 10, true));     // Catch: Throwable -> L9
            goto L18
        L26:
            String name = getSettingNameForDevice(device);     // Catch: Throwable -> L9
            index = AudioService.m2016$$Nest$fgetmSettings(this.this$0).getSystemIntForUser(AudioService.m1992$$Nest$fgetmContentResolver(this.this$0), name, defaultIndex, -2);     // Catch: Throwable -> L9
            goto L27
        L22:
            defaultIndex = -1;
            goto L24
        L30:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L32:
            int index2 = AudioSystem.DEFAULT_STREAM_VOLUME[this.mStreamType] * 10;     // Catch: Throwable -> L9
            if (AudioService.m1991$$Nest$fgetmCameraSoundForced(this.this$0).get() == false) goto L35;
            index2 = this.mIndexMax;     // Catch: Throwable -> L9
        L35:
            this.mIndexMap.put(1073741824, index2);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        private void setStreamVolumeIndex(int index, int device) {
            if (AudioService.m2058$$Nest$misStreamBluetoothSco(this.this$0, this.mStreamType) == false) goto L8;
            if (index != 0) goto L8;
            if (isFullyMuted() == true) goto L8;
            index = 1;
        L8:
            if (index == 0) goto L10;
            index = ((int) ((this.mIndexMin + (((index * 10) - this.mIndexMin) / getIndexStepFactor())) + 5.0f)) / 10;
        L10:
            Log.d(AudioService.TAG, "setStreamVolumeIndexAS(streamType=" + this.mStreamType + ", index=" + index + ", muted=false, device=" + device + ")");
            int index2 = this.this$0.mASExt.setStreamVolumeIndex_capIndex(this.mStreamType, index, false, device);
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setStreamVolumeIndexAS(this.mStreamType, index2, false, device);
            if (this.mStreamType == 6) goto L15;
            if (this.mStreamType == 0) goto L15;
            return;
        L15:
            if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == true) goto L18;
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setStreamVolumeIndexAS(this.mStreamType, index2, false, 128);
        L18:
            if (AudioSystem.DEVICE_OUT_ALL_SCO_SET.contains(Integer.valueOf(device)) == true) goto L22;
            AudioService.m1989$$Nest$fgetmAudioSystem(this.this$0).setStreamVolumeIndexAS(this.mStreamType, index2, false, 16);
            return;
        }

        void applyDeviceVolume_syncVSS(int device) {
            if (isFullyMuted() == false) goto L6;
            int index = 0;
        L23:
            setStreamVolumeIndex(index, device);
            return;
        L6:
            if (AudioService.m2053$$Nest$misAbsoluteVolumeDevice(this.this$0, device) == true) goto L20;
            if (this.this$0.isA2dpAbsoluteVolumeDevice(device) == true) goto L20;
            if (AudioSystem.isLeAudioDeviceType(device) == true) goto L20;
            if (AudioService.m2055$$Nest$misFullVolumeDevice(this.this$0, device) == false) goto L16;
            index = (this.mIndexMax + 5) / 10;
            goto L23
        L16:
            if (device != 134217728) goto L18;
            index = (getIndex(device) + 5) / 10;
            goto L23
        L18:
            int index2 = getIndex(device);
            index = (index2 + 5) / 10;
        L20:
            if (AudioService.m2053$$Nest$misAbsoluteVolumeDevice(this.this$0, device) == false) goto L22;
            index = (this.mIndexMax + 5) / 10;
            goto L23
        L22:
            int index3 = getIndex(device);
            index = (index3 + 5) / 10;
            goto L23
        }

        public void applyAllVolumes() {
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r1);
            boolean isAbsoluteVolume = false;
            int i = 0;
        L57:
            if (i >= this.mIndexMap.size()) goto L48;
            int device = this.mIndexMap.keyAt(i);     // Catch: Throwable -> L22
            if (device == 1073741824) goto L46;
            if (isFullyMuted() == false) goto L13;
            int index = 0;
        L33:
            if (this.mStreamType != 3) goto L44;
            AudioHandler r5 = AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0);     // Catch: Throwable -> L22
            if (isAbsoluteVolume == false) goto L38;
            int r4 = 1;
        L56:
            AudioService.m2106$$Nest$smsendMsg(r5, 1006, 2, device, r4, this, 0);     // Catch: Throwable -> L41
        L41:
            th = th;
        L54:
            monitor-exit(r1);     // Catch: Throwable -> L41
            throw th;
        L38:
            r4 = 0;
        L44:
            setStreamVolumeIndex(index, device);     // Catch: Throwable -> L41
            goto L46
        L13:
            if (AudioService.m2053$$Nest$misAbsoluteVolumeDevice(this.this$0, device) == false) goto L15;
        L28:
            isAbsoluteVolume = true;
            if (AudioService.m2053$$Nest$misAbsoluteVolumeDevice(this.this$0, device) == false) goto L31;
            index = (this.mIndexMax + 5) / 10;     // Catch: Throwable -> L22
            goto L33
        L31:
            int index2 = getIndex(device);     // Catch: Throwable -> L22
            index = (index2 + 5) / 10;     // Catch: Throwable -> L22
            goto L33
        L15:
            if (this.this$0.isA2dpAbsoluteVolumeDevice(device) == true) goto L28;
            if (AudioSystem.isLeAudioDeviceType(device) == true) goto L28;
            if (AudioService.m2055$$Nest$misFullVolumeDevice(this.this$0, device) == false) goto L25;
            index = (this.mIndexMax + 5) / 10;     // Catch: Throwable -> L22
            goto L33
        L25:
            if (device != 134217728) goto L27;
            isAbsoluteVolume = true;
            index = (getIndex(device) + 5) / 10;     // Catch: Throwable -> L22
            goto L33
        L27:
            index = (this.mIndexMap.valueAt(i) + 5) / 10;     // Catch: Throwable -> L22
        L46:
            i = i + 1;     // Catch: Throwable -> L41
            goto L57
        L48:
            if (isFullyMuted() == false) goto L50;
            int index3 = 0;
        L51:
            setStreamVolumeIndex(index3, 1073741824);     // Catch: Throwable -> L41
            monitor-exit(r1);     // Catch: Throwable -> L41
            return;
        L50:
            int index4 = getIndex(1073741824);     // Catch: Throwable -> L41
            index3 = (index4 + 5) / 10;     // Catch: Throwable -> L41
        L22:
            th = th;
            goto L54
        }

        public boolean adjustIndex(int deltaIndex, int device, String caller, boolean hasModifyAudioSettings) {
            return setIndex(getIndex(device) + deltaIndex, device, caller, hasModifyAudioSettings);
        }

        /* JADX WARN: Not initialized variable reg: 9, insn: 0x029f: MOVE (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('index' int)]), block:B:142:0x029f */
        public boolean setIndex(int index, int device, String caller, boolean hasModifyAudioSettings) {
            StringBuilder aliasStreamIndexes = new StringBuilder();
            Object r6 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r6);
            Object r7 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);     // Catch: Throwable -> L151
            monitor-enter(r7);     // Catch: Throwable -> L151
            int oldIndex = getIndex(device);     // Catch: Throwable -> L147
            int index2 = getValidIndex(index, hasModifyAudioSettings);     // Catch: Throwable -> L145
            int aliasIndex = index2;
        L135:
            th = th;
        L149:
            monitor-exit(r7);     // Catch: Throwable -> L143
        L143:
            th = th;
            goto L149
        L150:
            throw th;     // Catch: Throwable -> L141
        L12:
            if (this.mStreamType == 7) goto L171;
        L19:
            this.mIndexMap.put(device, index2);     // Catch: Throwable -> L135
            boolean isCurrentDevice = true;
            if (oldIndex == index2) goto L22;
            boolean changed = true;
        L24:
            if (device == this.this$0.getDeviceForStream(this.mStreamType)) goto L27;
            isCurrentDevice = false;
        L27:
            int numStreamTypes = AudioSystem.getNumStreamTypes();     // Catch: Throwable -> L135
            int streamType = numStreamTypes - 1;
        L29:
            if (streamType < 0) goto L50;
            VolumeStreamState aliasStreamState = this.this$0.getVssForStream(streamType);     // Catch: Throwable -> L17
            if (aliasStreamState != null) goto L33;
        L48:
            int oldIndex2 = oldIndex;
            aliasIndex = aliasIndex;
        L49:
            streamType = streamType - 1;     // Catch: Throwable -> L17
            oldIndex = oldIndex2;
            aliasIndex = aliasIndex;
            goto L29
        L33:
            if (streamType == this.mStreamType) goto L48;
            oldIndex2 = oldIndex;
            if (AudioService.sStreamVolumeAlias.get(streamType, -1) != this.mStreamType) goto L47;
            if (changed == false) goto L38;
        L41:
            int scaledIndex = AudioService.m2089$$Nest$mrescaleIndex(this.this$0, aliasIndex, this.mStreamType, streamType);     // Catch: Throwable -> L17
            boolean changedAlias = aliasStreamState.setIndex(scaledIndex, device, caller, hasModifyAudioSettings);     // Catch: Throwable -> L17
            if (isCurrentDevice == false) goto L45;
            changedAlias = changedAlias | aliasStreamState.setIndex(scaledIndex, this.this$0.getDeviceForStream(streamType), caller, hasModifyAudioSettings);     // Catch: Throwable -> L17
        L45:
            if (changedAlias == false) goto L49;
            aliasStreamIndexes.append(AudioSystem.streamToString(streamType));     // Catch: Throwable -> L17
            aliasStreamIndexes.append(":");     // Catch: Throwable -> L17
            aliasStreamIndexes.append((scaledIndex + 5) / 10);     // Catch: Throwable -> L17
            aliasStreamIndexes.append(" ");     // Catch: Throwable -> L17
            goto L49
        L38:
            if (aliasStreamState.hasIndexForDevice(device) == false) goto L41;
            aliasIndex = aliasIndex;
            goto L49
        L47:
            aliasIndex = aliasIndex;
            goto L49
        L50:
            int oldIndex3 = oldIndex;
            if (changed == false) goto L63;
            if (this.mStreamType != 2) goto L63;
            if (device != 2) goto L63;
            int i = 0;
        L57:
            if (i >= this.mIndexMap.size()) goto L63;
            int otherDevice = this.mIndexMap.keyAt(i);     // Catch: Throwable -> L17
            if (AudioSystem.DEVICE_OUT_ALL_SCO_SET.contains(Integer.valueOf(otherDevice)) == false) goto L61;
            this.mIndexMap.put(otherDevice, index2);     // Catch: Throwable -> L17
        L61:
            i = i + 1;     // Catch: Throwable -> L17
        L63:
            if (changed == true) goto L65;
        L86:
            if (changed == false) goto L138;
            updateVolumeGroupIndex(device, false);     // Catch: Throwable -> L135
            int oldIndex4 = (oldIndex3 + 5) / 10;     // Catch: Throwable -> L135
            int index3 = (index2 + 5) / 10;     // Catch: Throwable -> L135
        L122:
            th = th;
            goto L149
        L90:
            if (AudioService.sStreamVolumeAlias.get(this.mStreamType, -1) != this.mStreamType) goto L96;
            if (caller == null) goto L173;
        L95:
            EventLogTags.writeVolumeChanged(this.mStreamType, oldIndex4, index3, this.mIndexMax / 10, caller);     // Catch: Throwable -> L93
            goto L96
        L173:
            Log.w(AudioService.TAG, "No caller for volume_changed event", new Throwable());     // Catch: Throwable -> L93
        L93:
            th = th;
        L96:
            if (index3 == oldIndex4) goto L138;
            if (isCurrentDevice == false) goto L138;
            int streamAlias = AudioService.sStreamVolumeAlias.get(this.mStreamType, -1);     // Catch: Throwable -> L122
            if (AudioService.m2007$$Nest$fgetmIsSingleVolume(this.this$0) == true) goto L101;
        L104:
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", index3);     // Catch: Throwable -> L122
            this.mVolumeChanged.putExtra("android.media.EXTRA_PREV_VOLUME_STREAM_VALUE", oldIndex4);     // Catch: Throwable -> L122
            int extraStreamType = this.mStreamType;     // Catch: Throwable -> L122
            if (AudioService.m2058$$Nest$misStreamBluetoothSco(this.this$0, this.mStreamType) == false) goto L108;
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 6);     // Catch: Throwable -> L93
            extraStreamType = 6;
        L109:
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE_ALIAS", streamAlias);     // Catch: Throwable -> L122
            if (this.mStreamType != streamAlias) goto L126;
            String aliasStreamIndexesString = "";
            if (aliasStreamIndexes.isEmpty() == true) goto L115;
            aliasStreamIndexesString = " aliased streams: " + aliasStreamIndexes;     // Catch: Throwable -> L93
        L115:
            AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolChangedBroadcastEvent(extraStreamType, aliasStreamIndexesString, index3, oldIndex4));     // Catch: Throwable -> L122
            if (extraStreamType == this.mStreamType) goto L126;
            AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolChangedBroadcastEvent(this.mStreamType, aliasStreamIndexesString, index3, oldIndex4));     // Catch: Throwable -> L120
        L120:
            th = th;
        L126:
            AudioService.m2090$$Nest$msendBroadcastToAll(this.this$0, this.mVolumeChanged, this.mVolumeChangedOptions);     // Catch: Throwable -> L120
            this.this$0.mASExt.setIndex_onEnd(this.mStreamType, index3, device, caller);     // Catch: Throwable -> L120
            if (Constants.ENABLE_GAME_ASSIST == false) goto L130;
            SystemVolumeUpdateDispatcher.getInstance().notifyVolumeUpdated(this.mStreamType, index3, device, caller);     // Catch: Throwable -> L120
        L130:
            if (extraStreamType == this.mStreamType) goto L138;
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", this.mStreamType);     // Catch: Throwable -> L120
            AudioService.m2090$$Nest$msendBroadcastToAll(this.this$0, this.mVolumeChanged, null);     // Catch: Throwable -> L120
            goto L138
        L108:
            this.mVolumeChanged.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", this.mStreamType);     // Catch: Throwable -> L122
            goto L109
        L101:
            if (streamAlias == this.mStreamType) goto L104;
        L138:
            monitor-exit(r7);     // Catch: Throwable -> L143
            monitor-exit(r6);     // Catch: Throwable -> L141
            return changed;
        L65:
            if (this.mStreamType != 6) goto L67;
        L68:
            Log.i(AudioService.TAG, "setIndex device = " + device + ", index= " + index2);     // Catch: Throwable -> L17
            if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == true) goto L78;
            int i2 = 0;
        L72:
            if (i2 >= this.mIndexMap.size()) goto L78;
            int otherDevice2 = this.mIndexMap.keyAt(i2);     // Catch: Throwable -> L17
            if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(otherDevice2)) == false) goto L76;
            this.mIndexMap.put(otherDevice2, index2);     // Catch: Throwable -> L17
        L76:
            i2 = i2 + 1;     // Catch: Throwable -> L17
        L78:
            if (AudioSystem.DEVICE_OUT_ALL_SCO_SET.contains(Integer.valueOf(device)) == true) goto L86;
            int i3 = 0;
        L80:
            if (i3 >= this.mIndexMap.size()) goto L86;
            int otherDevice3 = this.mIndexMap.keyAt(i3);     // Catch: Throwable -> L17
            if (AudioSystem.DEVICE_OUT_ALL_SCO_SET.contains(Integer.valueOf(otherDevice3)) == false) goto L85;
            this.mIndexMap.put(otherDevice3, index2);     // Catch: Throwable -> L17
        L85:
            i3 = i3 + 1;
        L17:
            th = th;
            goto L149
        L67:
            if (this.mStreamType != 0) goto L86;
        L22:
            changed = false;
            goto L24
        L171:
            if (AudioService.m1991$$Nest$fgetmCameraSoundForced(this.this$0).get() == false) goto L19;
            index2 = this.mIndexMax;     // Catch: Throwable -> L17
        L145:
            th = th;
        L147:
            th = th;
        L141:
            th = th;
        L165:
            monitor-exit(r6);     // Catch: Throwable -> L155
            throw th;
        L155:
            th = th;
            goto L165
        L177:
            th = th;
        L151:
            th = th;
            goto L165
        }

        public int getIndex(int device) {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
            int index = this.mIndexMap.get(device, -1);     // Catch: Throwable -> L7
            if (index != (-1)) goto L9;
            index = this.mIndexMap.get(1073741824);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return index;
        L7:
            th = move-exception;
            throw th;
        }

        public VolumeInfo getVolumeInfo(int device) {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
            int index = this.mIndexMap.get(device, -1);     // Catch: Throwable -> L7
            if (index != (-1)) goto L9;
            index = this.mIndexMap.get(1073741824);     // Catch: Throwable -> L7
        L9:
            VolumeInfo vi = new VolumeInfo.Builder(this.mStreamType).setMinVolumeIndex(getMinIndex()).setMaxVolumeIndex(getMaxIndex()).setVolumeIndex(index).setMuted(isFullyMuted()).build();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return vi;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean hasIndexForDevice(int device) {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mIndexMap.get(device, -1) == (-1)) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public int getMaxIndex() {
            return this.mIndexMax;
        }

        public int getMinIndex() {
            return this.mIndexMin;
        }

        public int getMinIndex(boolean isPrivileged) {
            if (isPrivileged == false) goto L5;
            return this.mIndexMin;
        L5:
            return this.mIndexMinNoPerm;
        }

        public void setAllIndexes(VolumeStreamState srcStream, String caller) {
            if (srcStream != null) goto L4;
            return;
        L4:
            if (this.mStreamType == srcStream.mStreamType) goto L19;
            int srcStreamType = srcStream.getStreamType();
            int index = srcStream.getIndex(1073741824);
            int index2 = AudioService.m2089$$Nest$mrescaleIndex(this.this$0, index, srcStreamType, this.mStreamType);
            int i = 0;
        L8:
            if (i >= this.mIndexMap.size()) goto L10;
            this.mIndexMap.put(this.mIndexMap.keyAt(i), index2);
            i = i + 1;
            goto L8
        L10:
            SparseIntArray srcMap = srcStream.mIndexMap;
            int i2 = 0;
        L12:
            if (i2 >= srcMap.size()) goto L15;
            int device = srcMap.keyAt(i2);
            int index3 = srcMap.valueAt(i2);
            setIndex(AudioService.m2089$$Nest$mrescaleIndex(this.this$0, index3, srcStreamType, this.mStreamType), device, caller, true);
            i2 = i2 + 1;
            goto L12
        L15:
            return;
        }

        public void setAllIndexesToMax() {
            int i = 0;
        L4:
            if (i >= this.mIndexMap.size()) goto L7;
            this.mIndexMap.put(this.mIndexMap.keyAt(i), this.mIndexMax);
            i = i + 1;
            goto L4
        }

        private void updateVolumeGroupIndex(int device, boolean forceMuteState) {
            Object r0 = AudioService.m2017$$Nest$fgetmSettingsLock(this.this$0);
            monitor-enter(r0);
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r1);     // Catch: Throwable -> L26
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L7:
            if (this.mVolumeGroupState == null) goto L23;
            int groupIndex = (getIndex(device) + 5) / 10;     // Catch: Throwable -> L13
            Log.d(AudioService.TAG, "updateVolumeGroupIndex for stream " + this.mStreamType + ", muted=" + this.mIsMuted + ", device=" + device + ", index=" + getIndex(device) + ", group " + this.mVolumeGroupState.name() + " Muted=" + this.mVolumeGroupState.isMuted() + ", Index=" + groupIndex + ", forceMuteState=" + forceMuteState);     // Catch: Throwable -> L13
            this.mVolumeGroupState.updateVolumeIndex(groupIndex, device);     // Catch: Throwable -> L13
            if (isMutable() == false) goto L23;
            VolumeGroupState r3 = this.mVolumeGroupState;     // Catch: Throwable -> L13
            if (forceMuteState == false) goto L15;
            boolean r4 = this.mIsMuted;     // Catch: Throwable -> L13
        L22:
            r3.mute(r4);     // Catch: Throwable -> L13
            goto L23
        L15:
            if (groupIndex != 0) goto L19;
            if (AudioService.m2105$$Nest$smisCallStream(this.mStreamType) == true) goto L19;
        L20:
            r4 = true;
        L19:
            if (this.mIsMuted == true) goto L20;
            r4 = false;
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            throw th;
        }

        public boolean mute(boolean state, String source) {
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r1);
            boolean changed = mute(state, true, source);     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            if (changed == false) goto L9;
            AudioService.m2048$$Nest$mbroadcastMuteSetting(this.this$0, this.mStreamType, state);
        L9:
            return changed;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean muteInternally(boolean state) {
            boolean changed = false;
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r1);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (state == this.mIsMutedInternally) goto L9;
            changed = true;
            this.mIsMutedInternally = state;     // Catch: Throwable -> L7
            applyAllVolumes();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L7
            if (changed == false) goto L12;
            AudioService.sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(9, this.mStreamType, state));
        L12:
            return changed;
        }

        public boolean isFullyMuted() {
            if (this.mIsMuted == false) goto L5;
        L8:
            return true;
        L5:
            if (this.mIsMutedInternally == true) goto L8;
            return false;
        }

        private boolean isMutable() {
            if (this.this$0.isStreamAffectedByMute(this.mStreamType) == true) goto L5;
        L9:
            return false;
        L5:
            if (this.mIndexMin != 0) goto L7;
        L8:
            return true;
        L7:
            if (AudioService.m2105$$Nest$smisCallStream(this.mStreamType) == false) goto L9;
            goto L8
        }

        public boolean mute(boolean state, boolean apply, String src) {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
        L16:
            th = move-exception;
            throw th;
        L5:
            if (state == this.mIsMuted) goto L7;
            boolean changed = true;
        L8:
            if (changed == false) goto L21;
            AudioService.sMuteLogger.enqueue(new AudioServiceEvents.StreamMuteEvent(this.mStreamType, state, src));     // Catch: Throwable -> L16
            if (state == false) goto L12;
        L18:
            this.mIsMuted = state;     // Catch: Throwable -> L16
            if (apply == false) goto L21;
            doMute();     // Catch: Throwable -> L16
            goto L21
        L12:
            if (AudioService.m2059$$Nest$misStreamMutedByRingerOrZenMode(this.this$0, this.mStreamType) == false) goto L18;
            Slog.e(AudioService.TAG, "Attempt to unmute stream " + this.mStreamType + " despite ringer-zen muted stream 0x" + Integer.toHexString(AudioService.sRingerAndZenModeMutedStreams), new Exception());     // Catch: Throwable -> L16
            AudioService.sMuteLogger.enqueue(new AudioServiceEvents.StreamUnmuteErrorEvent(this.mStreamType, AudioService.sRingerAndZenModeMutedStreams));     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            return false;
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return changed;
        L7:
            changed = false;
            goto L8
        }

        public void doMute() {
            Object r1 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r1);
            updateVolumeGroupIndex(this.this$0.getDeviceForStream(this.mStreamType), true);     // Catch: Throwable -> L7
            AudioService.m2106$$Nest$smsendMsg(AudioService.m1985$$Nest$fgetmAudioHandler(this.this$0), 10, 2, 0, 0, this, 0);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public int getStreamType() {
            return this.mStreamType;
        }

        public void checkFixedVolumeDevices() {
            Object r0 = AudioService.m2029$$Nest$fgetmVolumeStateLock(this.this$0);
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (AudioService.sStreamVolumeAlias.get(this.mStreamType) != 3) goto L19;
            int i = 0;
        L8:
            if (i >= this.mIndexMap.size()) goto L19;
            int device = this.mIndexMap.keyAt(i);     // Catch: Throwable -> L15
            int index = this.mIndexMap.valueAt(i);     // Catch: Throwable -> L15
            if (AudioService.m2055$$Nest$misFullVolumeDevice(this.this$0, device) == false) goto L12;
        L17:
            this.mIndexMap.put(device, this.mIndexMax);     // Catch: Throwable -> L15
        L18:
            applyDeviceVolume_syncVSS(device);     // Catch: Throwable -> L15
            i = i + 1;     // Catch: Throwable -> L15
            goto L8
        L12:
            if (AudioService.m2054$$Nest$misFixedVolumeDevice(this.this$0, device) == false) goto L18;
            if (index == 0) goto L18;
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L15
        }

        private int getValidIndex(int index, boolean hasModifyAudioSettings) {
            if (hasModifyAudioSettings == false) goto L4;
            int indexMin = this.mIndexMin;
        L5:
            if (index >= indexMin) goto L8;
            return indexMin;
        L8:
            if (AudioService.m2025$$Nest$fgetmUseFixedVolume(this.this$0) == true) goto L14;
            if (index > this.mIndexMax) goto L14;
            return index;
        L14:
            return this.mIndexMax;
        L4:
            indexMin = this.mIndexMinNoPerm;
            goto L5
        }

        private void dump(PrintWriter pw) {
            pw.print("   Muted: ");
            pw.println(this.mIsMuted);
            pw.print("   Muted Internally: ");
            pw.println(this.mIsMutedInternally);
            pw.print("   Min: ");
            pw.print((this.mIndexMin + 5) / 10);
            if (this.mIndexMin == this.mIndexMinNoPerm) goto L5;
            pw.print(" w/o perm:");
            pw.println((this.mIndexMinNoPerm + 5) / 10);
        L6:
            pw.print("   Max: ");
            pw.println((this.mIndexMax + 5) / 10);
            pw.print("   streamVolume:");
            pw.println(this.this$0.getStreamVolume(this.mStreamType));
            pw.print("   Current: ");
            int i = 0;
        L8:
            if (i >= this.mIndexMap.size()) goto L19;
            if (i <= 0) goto L11;
            pw.print(", ");
        L11:
            int device = this.mIndexMap.keyAt(i);
            pw.print(Integer.toHexString(device));
            if (device != 1073741824) goto L14;
            String deviceName = "default";
        L16:
            if (deviceName.isEmpty() == true) goto L18;
            pw.print(" (");
            pw.print(deviceName);
            pw.print(")");
        L18:
            pw.print(": ");
            int index = (this.mIndexMap.valueAt(i) + 5) / 10;
            pw.print(index);
            i = i + 1;
            goto L8
        L14:
            deviceName = AudioSystem.getOutputDeviceName(device);
            goto L16
        L19:
            pw.println();
            pw.print("   Devices: ");
            pw.print(AudioSystem.deviceSetToString(this.this$0.getDeviceSetForStream(this.mStreamType)));
            pw.println();
            pw.print("   Volume Group: ");
            if (this.mVolumeGroupState == null) goto L22;
            String r0 = this.mVolumeGroupState.name();
        L23:
            pw.println(r0);
            return;
        L22:
            r0 = "n/a";
            goto L23
        L5:
            pw.println();
            goto L6
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-euQQktjdiXf3rzJi2rVYM5QOu8, reason: not valid java name */
    public static /* synthetic */ void m1968$r8$lambda$euQQktjdiXf3rzJi2rVYM5QOu8(AudioService r0, PlayerBase r1) {
        r0.lambda$new$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$0g3d-toOnDKjvE-m6dLfEXYqrYU, reason: not valid java name */
    public static /* synthetic */ void m1969$r8$lambda$0g3dtoOnDKjvEm6dLfEXYqrYU(ArrayList r0, ArrayList r1, String r2, ZenModeConfig.ZenRule r3) {
        lambda$updateZenModeAffectedStreams$16(r0, r1, r2, r3);
    }

    public static /* synthetic */ Integer $r8$lambda$1CcbBNvgbx5ySCeQTFVjQXTOOMg(AudioService r0, int r1, Integer r2, Integer r3) {
        return r0.lambda$setAvrcpAbsoluteVolumeSupported$18(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$3G7w7StpWrcJLyXvZc7soDDFoJ0(AudioService r0, AudioDeviceAttributes r1, int[] r2, IMuteAwaitConnectionCallback r3, Boolean r4) {
        r0.lambda$cancelMuteAwaitConnection$23(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$3VuBo_lBuE5M3IuArQgtvjSPFTE(AudioPolicyProxy r0) {
        lambda$onAudioServerDied$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$47Jjx-F8FSrlIf-FhX2f-gAiptc, reason: not valid java name */
    public static /* synthetic */ void m1970$r8$lambda$47JjxF8FSrlIfFhX2fgAiptc(AudioDeviceAttributes r0, int[] r1, IMuteAwaitConnectionCallback r2, Boolean r3) {
        lambda$onMuteAwaitConnectionTimeout$25(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$4dBLkVHS3j_u88LZCtk_QqGCJt4(AudioService r0, boolean r1, Integer r2) {
        r0.lambda$muteAliasStreams$14(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$6PheTTUBR0Mr3b17ETIltXfzUmo(AudioService r0, AudioDeviceAttributes r1, int[] r2, IMuteAwaitConnectionCallback r3, Boolean r4) {
        r0.lambda$checkMuteAwaitConnection$24(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$DibgoIeZH8-Wb9iw-NZ6c3_PPtk, reason: not valid java name */
    public static /* synthetic */ String m1971$r8$lambda$DibgoIeZH8Wb9iwNZ6c3_PPtk(AudioDeviceAttributes r0) {
        return lambda$setPreferredDevicesForCapturePreset$12(r0);
    }

    public static /* synthetic */ Boolean $r8$lambda$DqviBihdIIPl1huCaIiD5EnaiKA(AudioService r0, Integer r1) {
        return r0.lambda$new$3(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$MqGuHwBGoklynxxSs6-AiJreQWM, reason: not valid java name */
    public static /* synthetic */ void m1972$r8$lambda$MqGuHwBGoklynxxSs6AiJreQWM(AudioService r0) {
        r0.lambda$setupPermissionListener$19();
    }

    /* JADX INFO: renamed from: $r8$lambda$Mz9vHx-wfckmjJ7952wCDW_xj7o, reason: not valid java name */
    public static /* synthetic */ boolean m1973$r8$lambda$Mz9vHxwfckmjJ7952wCDW_xj7o(AudioDeviceAttributes r0) {
        return lambda$setPreferredDevicesForStrategy$11(r0);
    }

    public static /* synthetic */ Integer $r8$lambda$QKnA7lwPU_mD13PwyjlkkEGBR_A(AudioService r0, int r1, Integer r2, Integer r3) {
        return r0.lambda$onUpdateContextualVolumes$15(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$Ye0W1bWwMQmMLkwWBDSjdp_03C8(Integer r0, String r1) {
        return lambda$initializeAudioServerPermissionProvider$28(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZGWGMYpFSlBzwJjutrExpEOmxng(AudioService r0, Integer r1) {
        r0.lambda$initExternalEventReceivers$5(r1);
    }

    public static /* synthetic */ String $r8$lambda$_gsyIT3ecFvLhZ3OgJNjgWNeCzc(AudioDeviceAttributes r0) {
        return lambda$setPreferredDevicesForStrategy$10(r0);
    }

    public static /* synthetic */ void $r8$lambda$_qheeaB7x3hG113nmnMIIf8j5NM(AudioService r0, ScheduledExecutorService r1) {
        r0.lambda$setupPermissionListener$20(r1);
    }

    public static /* synthetic */ void $r8$lambda$a4dgieoC36odt7_uJ6dZl4kLlFo(AudioServerPermissionProvider r0, AudioPolicyFacade r1) {
        lambda$initializeAudioServerPermissionProvider$30(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aGbadQBCyM76zQvURlh9dEvA78Y(AudioService r0, Boolean r1) {
        r0.lambda$initExternalEventReceivers$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$bNjDvJ5cNRyWy1p3qpwbELM1kGQ(AudioService r0, int r1, boolean r2) {
        r0.lambda$onSystemReady$7(r1, r2);
    }

    public static /* synthetic */ int $r8$lambda$dy0OOFdCO7LkxsJMYGICGuIrhd4(Integer r0) {
        return lambda$getActiveUidsForStream$31(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$e94tBPlBFLmQ2g-oDom1gnP8PfQ, reason: not valid java name */
    public static /* synthetic */ void m1974$r8$lambda$e94tBPlBFLmQ2goDom1gnP8PfQ(AudioService r0, Integer r1, Integer r2) {
        r0.lambda$onReinitVolumes$9(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$f1DCHh_08Aeq_nxSytIND9bwWcQ(int r0, Map.Entry r1) {
        return lambda$getAbsoluteVolumeDevicesWithBehavior$26(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$gYS_-oND_F_IUnw9rtMzdkx_HBY, reason: not valid java name */
    public static /* synthetic */ void m1975$r8$lambda$gYS_oND_F_IUnw9rtMzdkx_HBY(AudioService r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$nZYC-kE3kPmIF6tMMnjXkivsP4Y, reason: not valid java name */
    public static /* synthetic */ void m1976$r8$lambda$nZYCkE3kPmIF6tMMnjXkivsP4Y(AudioService r0, AudioDeviceAttributes r1, int[] r2, IMuteAwaitConnectionCallback r3, Boolean r4) {
        r0.lambda$muteAwaitConnection$22(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$oKv9k-Cs8iC0gRTPbIQ9ZqOBrbM, reason: not valid java name */
    public static /* synthetic */ void m1977$r8$lambda$oKv9kCs8iC0gRTPbIQ9ZqOBrbM(AudioService r0, AudioDeviceAttributes r1) {
        r0.lambda$new$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$pNoc_mF0zgiKC5bbsVcvqbiIn0Y(PrintWriter r0, Integer r1, Integer r2) {
        lambda$dump$27(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$rABy371EIk4Zqf0IGawY_Ja1NB0(AudioAttributes r0) {
        return lambda$ensureValidVolumeGroup$17(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$t2v5j-tnrnb1Qw5L62eNijhilfg, reason: not valid java name */
    public static /* synthetic */ void m1978$r8$lambda$t2v5jtnrnb1Qw5L62eNijhilfg(AudioService r0) {
        r0.lambda$setupPermissionListener$21();
    }

    /* JADX INFO: renamed from: $r8$lambda$vRSxii1V5X5ZbNlFilA_19TY9-w, reason: not valid java name */
    public static /* synthetic */ boolean m1979$r8$lambda$vRSxii1V5X5ZbNlFilA_19TY9w(AudioDeviceAttributes r0) {
        return lambda$setPreferredDevicesForCapturePreset$13(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$xSy-kURxS2ORFTzenxx_LfNlcGc, reason: not valid java name */
    public static /* synthetic */ void m1980$r8$lambda$xSykURxS2ORFTzenxx_LfNlcGc(AudioService r0, Integer r1, Integer r2) {
        r0.lambda$onInitStreamsAndVolumes$4(r1, r2);
    }

    public static /* synthetic */ int[] $r8$lambda$z58ZRLCLphSDg4DZBigPv7Pg9lg(UserManagerInternal r0) {
        return lambda$initializeAudioServerPermissionProvider$29(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m1981$$Nest$fgetmAccessibilityServiceUids(AudioService r0) {
        return r0.mAccessibilityServiceUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccessibilityServiceUidsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1982$$Nest$fgetmAccessibilityServiceUidsLock(AudioService r0) {
        return r0.mAccessibilityServiceUidsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveAssistantServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m1983$$Nest$fgetmActiveAssistantServiceUids(AudioService r0) {
        return r0.mActiveAssistantServiceUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioEventWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m1984$$Nest$fgetmAudioEventWakeLock(AudioService r0) {
        return r0.mAudioEventWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioHandler m1985$$Nest$fgetmAudioHandler(AudioService r0) {
        return r0.mAudioHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioPolicies, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m1986$$Nest$fgetmAudioPolicies(AudioService r0) {
        return r0.mAudioPolicies;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioPolicyCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1987$$Nest$fgetmAudioPolicyCounter(AudioService r0) {
        return r0.mAudioPolicyCounter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioServerStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m1988$$Nest$fgetmAudioServerStateListeners(AudioService r0) {
        return r0.mAudioServerStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioSystem, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioSystemAdapter m1989$$Nest$fgetmAudioSystem(AudioService r0) {
        return r0.mAudioSystem;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBtCommDeviceActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicInteger m1990$$Nest$fgetmBtCommDeviceActive(AudioService r0) {
        return r0.mBtCommDeviceActive;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraSoundForced, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m1991$$Nest$fgetmCameraSoundForced(AudioService r0) {
        return r0.mCameraSoundForced;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContentResolver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentResolver m1992$$Nest$fgetmContentResolver(AudioService r0) {
        return r0.mContentResolver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceBroker, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioDeviceBroker m1993$$Nest$fgetmDeviceBroker(AudioService r0) {
        return r0.mDeviceBroker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManager m1994$$Nest$fgetmDisplayManager(AudioService r0) {
        return r0.mDisplayManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1995$$Nest$fgetmDockState(AudioService r0) {
        return r0.mDockState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDynPolicyLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m1996$$Nest$fgetmDynPolicyLogger(AudioService r0) {
        return r0.mDynPolicyLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEncodedSurroundMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1997$$Nest$fgetmEncodedSurroundMode(AudioService r0) {
        return r0.mEncodedSurroundMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtVolumeControllerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1998$$Nest$fgetmExtVolumeControllerLock(AudioService r0) {
        return r0.mExtVolumeControllerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForceControlStreamClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ ForceControlStreamClient m1999$$Nest$fgetmForceControlStreamClient(AudioService r0) {
        return r0.mForceControlStreamClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForceControlStreamLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2000$$Nest$fgetmForceControlStreamLock(AudioService r0) {
        return r0.mForceControlStreamLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHardeningLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m2001$$Nest$fgetmHardeningLogger(AudioService r0) {
        return r0.mHardeningLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasSpatializerEffect, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2002$$Nest$fgetmHasSpatializerEffect(AudioService r0) {
        return r0.mHasSpatializerEffect;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiClientLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2003$$Nest$fgetmHdmiClientLock(AudioService r0) {
        return r0.mHdmiClientLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiControlManager m2004$$Nest$fgetmHdmiManager(AudioService r0) {
        return r0.mHdmiManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputMethodServiceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2005$$Nest$fgetmInputMethodServiceUid(AudioService r0) {
        return r0.mInputMethodServiceUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputMethodServiceUidLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2006$$Nest$fgetmInputMethodServiceUidLock(AudioService r0) {
        return r0.mInputMethodServiceUidLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsSingleVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2007$$Nest$fgetmIsSingleVolume(AudioService r0) {
        return r0.mIsSingleVolume;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaFocusControl, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaFocusControl m2008$$Nest$fgetmMediaFocusControl(AudioService r0) {
        return r0.mMediaFocusControl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMonitorRotation, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2009$$Nest$fgetmMonitorRotation(AudioService r0) {
        return r0.mMonitorRotation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMusicFxHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ MusicFxHelper m2010$$Nest$fgetmMusicFxHelper(AudioService r0) {
        return r0.mMusicFxHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioServerPermissionProvider m2011$$Nest$fgetmPermissionProvider(AudioService r0) {
        return r0.mPermissionProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlaybackMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlaybackActivityMonitor m2012$$Nest$fgetmPlaybackMonitor(AudioService r0) {
        return r0.mPlaybackMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecordMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ RecordingActivityMonitor m2013$$Nest$fgetmRecordMonitor(AudioService r0) {
        return r0.mRecordMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRingerModeDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManagerInternal.RingerModeDelegate m2014$$Nest$fgetmRingerModeDelegate(AudioService r0) {
        return r0.mRingerModeDelegate;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorPrivacyManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorPrivacyManagerInternal m2015$$Nest$fgetmSensorPrivacyManagerInternal(AudioService r0) {
        return r0.mSensorPrivacyManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ SettingsAdapter m2016$$Nest$fgetmSettings(AudioService r0) {
        return r0.mSettings;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettingsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2017$$Nest$fgetmSettingsLock(AudioService r0) {
        return r0.mSettingsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSfxHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundEffectsHelper m2018$$Nest$fgetmSfxHelper(AudioService r0) {
        return r0.mSfxHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundDoseHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SoundDoseHelper m2019$$Nest$fgetmSoundDoseHelper(AudioService r0) {
        return r0.mSoundDoseHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpatializerHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ SpatializerHelper m2020$$Nest$fgetmSpatializerHelper(AudioService r0) {
        return r0.mSpatializerHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportsMicPrivacyToggle, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2021$$Nest$fgetmSupportsMicPrivacyToggle(AudioService r0) {
        return r0.mSupportsMicPrivacyToggle;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSurroundModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2022$$Nest$fgetmSurroundModeChanged(AudioService r0) {
        return r0.mSurroundModeChanged;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2023$$Nest$fgetmSystemReady(AudioService r0) {
        return r0.mSystemReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemServer, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemServerAdapter m2024$$Nest$fgetmSystemServer(AudioService r0) {
        return r0.mSystemServer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseFixedVolume, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2025$$Nest$fgetmUseFixedVolume(AudioService r0) {
        return r0.mUseFixedVolume;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserSwitchedReceived, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2026$$Nest$fgetmUserSwitchedReceived(AudioService r0) {
        return r0.mUserSwitchedReceived;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumeController, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeController m2027$$Nest$fgetmVolumeController(AudioService r0) {
        return r0.mVolumeController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumeControllerLongPressEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m2028$$Nest$fgetmVolumeControllerLongPressEnabled(AudioService r0) {
        return r0.mVolumeControllerLongPressEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumeStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2029$$Nest$fgetmVolumeStateLock(AudioService r0) {
        return r0.mVolumeStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAccessibilityServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2030$$Nest$fputmAccessibilityServiceUids(AudioService r0, int[] r1) {
        r0.mAccessibilityServiceUids = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveAssistantServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2031$$Nest$fputmActiveAssistantServiceUids(AudioService r0, int[] r1) {
        r0.mActiveAssistantServiceUids = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAudioHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2032$$Nest$fputmAudioHandler(AudioService r0, AudioHandler r1) {
        r0.mAudioHandler = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAudioPolicyCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2033$$Nest$fputmAudioPolicyCounter(AudioService r0, int r1) {
        r0.mAudioPolicyCounter = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2034$$Nest$fputmDockState(AudioService r0, int r1) {
        r0.mDockState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEnabledSurroundFormats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2035$$Nest$fputmEnabledSurroundFormats(AudioService r0, String r1) {
        r0.mEnabledSurroundFormats = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEncodedSurroundMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2036$$Nest$fputmEncodedSurroundMode(AudioService r0, int r1) {
        r0.mEncodedSurroundMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmExtVolumeController, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2037$$Nest$fputmExtVolumeController(AudioService r0, IAudioPolicyCallback r1) {
        r0.mExtVolumeController = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmForceControlStreamClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2038$$Nest$fputmForceControlStreamClient(AudioService r0, ForceControlStreamClient r1) {
        r0.mForceControlStreamClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHdmiCecVolumeControlEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2039$$Nest$fputmHdmiCecVolumeControlEnabled(AudioService r0, boolean r1) {
        r0.mHdmiCecVolumeControlEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInputMethodServiceUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2040$$Nest$fputmInputMethodServiceUid(AudioService r0, int r1) {
        r0.mInputMethodServiceUid = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMicMuteFromPrivacyToggle, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2041$$Nest$fputmMicMuteFromPrivacyToggle(AudioService r0, boolean r1) {
        r0.mMicMuteFromPrivacyToggle = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMicMuteFromRestrictions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2042$$Nest$fputmMicMuteFromRestrictions(AudioService r0, boolean r1) {
        r0.mMicMuteFromRestrictions = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRingerModeDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2043$$Nest$fputmRingerModeDelegate(AudioService r0, AudioManagerInternal.RingerModeDelegate r1) {
        r0.mRingerModeDelegate = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSurroundModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2044$$Nest$fputmSurroundModeChanged(AudioService r0, boolean r1) {
        r0.mSurroundModeChanged = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserSelectedVolumeControlStream, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2045$$Nest$fputmUserSelectedVolumeControlStream(AudioService r0, boolean r1) {
        r0.mUserSelectedVolumeControlStream = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserSwitchedReceived, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2046$$Nest$fputmUserSwitchedReceived(AudioService r0, boolean r1) {
        r0.mUserSwitchedReceived = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVolumeControlStream, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2047$$Nest$fputmVolumeControlStream(AudioService r0, int r1) {
        r0.mVolumeControlStream = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mbroadcastMuteSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2048$$Nest$mbroadcastMuteSetting(AudioService r0, int r1, boolean r2) {
        r0.broadcastMuteSetting(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchDeviceVolumeBehavior, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2049$$Nest$mdispatchDeviceVolumeBehavior(AudioService r0, AudioDeviceAttributes r1, int r2) {
        r0.dispatchDeviceVolumeBehavior(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2050$$Nest$mgetCurrentUserId(AudioService r0) {
        return r0.getCurrentUserId();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDeviceSetForStreamDirect, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m2051$$Nest$mgetDeviceSetForStreamDirect(AudioService r0, int r1) {
        return r0.getDeviceSetForStreamDirect(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPackageNameForUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2052$$Nest$mgetPackageNameForUid(AudioService r0, int r1) {
        return r0.getPackageNameForUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misAbsoluteVolumeDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2053$$Nest$misAbsoluteVolumeDevice(AudioService r0, int r1) {
        return r0.isAbsoluteVolumeDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misFixedVolumeDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2054$$Nest$misFixedVolumeDevice(AudioService r0, int r1) {
        return r0.isFixedVolumeDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misFullVolumeDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2055$$Nest$misFullVolumeDevice(AudioService r0, int r1) {
        return r0.isFullVolumeDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misMuteAdjust, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2056$$Nest$misMuteAdjust(AudioService r0, int r1) {
        return r0.isMuteAdjust(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misStreamBluetoothComm, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2057$$Nest$misStreamBluetoothComm(AudioService r0, int r1) {
        return r0.isStreamBluetoothComm(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misStreamBluetoothSco, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2058$$Nest$misStreamBluetoothSco(AudioService r0, int r1) {
        return r0.isStreamBluetoothSco(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misStreamMutedByRingerOrZenMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2059$$Nest$misStreamMutedByRingerOrZenMode(AudioService r0, int r1) {
        return r0.isStreamMutedByRingerOrZenMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mkillBackgroundUserProcessesWithRecordAudioPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2060$$Nest$mkillBackgroundUserProcessesWithRecordAudioPermission(AudioService r0, UserInfo r1) {
        r0.killBackgroundUserProcessesWithRecordAudioPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monAccessoryPlugMediaUnmute, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2061$$Nest$monAccessoryPlugMediaUnmute(AudioService r0, int r1) {
        r0.onAccessoryPlugMediaUnmute(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monAddAssistantServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2062$$Nest$monAddAssistantServiceUids(AudioService r0, int[] r1) {
        r0.onAddAssistantServiceUids(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monApplyInputGainIndex, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2063$$Nest$monApplyInputGainIndex(AudioService r0, AudioDeviceAttributes r1, int r2) {
        r0.onApplyInputGainIndex(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monCheckVolumeCecOnHdmiConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2064$$Nest$monCheckVolumeCecOnHdmiConnection(AudioService r0, int r1, String r2) {
        r0.onCheckVolumeCecOnHdmiConnection(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monConfigurationChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2065$$Nest$monConfigurationChanged(AudioService r0) {
        r0.onConfigurationChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monDispatchAudioServerStateChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2066$$Nest$monDispatchAudioServerStateChange(AudioService r0, boolean r1) {
        r0.onDispatchAudioServerStateChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monDynPolicyMixStateUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2067$$Nest$monDynPolicyMixStateUpdate(AudioService r0, String r1, int r2) {
        r0.onDynPolicyMixStateUpdate(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monEnableSurroundFormats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2068$$Nest$monEnableSurroundFormats(AudioService r0, ArrayList r1) {
        r0.onEnableSurroundFormats(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monInitInputGains, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2069$$Nest$monInitInputGains(AudioService r0) {
        r0.onInitInputGains();
    }

    /* JADX INFO: renamed from: -$$Nest$monInitStreamsAndVolumes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2070$$Nest$monInitStreamsAndVolumes(AudioService r0) {
        r0.onInitStreamsAndVolumes();
    }

    /* JADX INFO: renamed from: -$$Nest$monObserveDevicesForAllStreams, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2071$$Nest$monObserveDevicesForAllStreams(AudioService r0, int r1) {
        r0.onObserveDevicesForAllStreams(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPersistInputGainIndex, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2072$$Nest$monPersistInputGainIndex(AudioService r0, AudioDeviceAttributes r1) {
        r0.onPersistInputGainIndex(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPlaybackConfigChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2073$$Nest$monPlaybackConfigChange(AudioService r0, List r1) {
        r0.onPlaybackConfigChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPolicyClientDeath, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2074$$Nest$monPolicyClientDeath(AudioService r0, List r1) {
        r0.onPolicyClientDeath(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monRecordingConfigChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2075$$Nest$monRecordingConfigChange(AudioService r0, List r1) {
        r0.onRecordingConfigChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monReinitVolumes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2076$$Nest$monReinitVolumes(AudioService r0, String r1) {
        r0.onReinitVolumes(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monRemoveAssistantServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2077$$Nest$monRemoveAssistantServiceUids(AudioService r0, int[] r1) {
        r0.onRemoveAssistantServiceUids(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monSetVolumeIndexOnDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2078$$Nest$monSetVolumeIndexOnDevice(AudioService r0, DeviceVolumeUpdate r1) {
        r0.onSetVolumeIndexOnDevice(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUnmuteStreamOnSingleVolDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2079$$Nest$monUnmuteStreamOnSingleVolDevice(AudioService r0, int r1, int r2) {
        r0.onUnmuteStreamOnSingleVolDevice(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateAccessibilityServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2080$$Nest$monUpdateAccessibilityServiceUids(AudioService r0) {
        r0.onUpdateAccessibilityServiceUids();
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateBtCommDeviceActive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2081$$Nest$monUpdateBtCommDeviceActive(AudioService r0, int r1) {
        r0.onUpdateBtCommDeviceActive(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateContextualVolumes, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2082$$Nest$monUpdateContextualVolumes(AudioService r0) {
        r0.onUpdateContextualVolumes();
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateRingerModeServiceInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2083$$Nest$monUpdateRingerModeServiceInt(AudioService r0) {
        r0.onUpdateRingerModeServiceInt();
    }

    /* JADX INFO: renamed from: -$$Nest$monUpdateVolumeStatesForAudioDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2084$$Nest$monUpdateVolumeStatesForAudioDevice(AudioService r0, int r1, String r2) {
        r0.onUpdateVolumeStatesForAudioDevice(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mqueueMsgUnderWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2085$$Nest$mqueueMsgUnderWakeLock(AudioService r0, Handler r1, int r2, int r3, int r4, Object r5, int r6) {
        r0.queueMsgUnderWakeLock(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadAudioSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2086$$Nest$mreadAudioSettings(AudioService r0, boolean r1) {
        r0.readAudioSettings(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadDockAudioSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2087$$Nest$mreadDockAudioSettings(AudioService r0, ContentResolver r1) {
        r0.readDockAudioSettings(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAudioSystemDeviceOutFromAbsVolumeDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ AbsoluteVolumeDeviceInfo m2088$$Nest$mremoveAudioSystemDeviceOutFromAbsVolumeDevices(AudioService r0, int r1) {
        return r0.removeAudioSystemDeviceOutFromAbsVolumeDevices(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrescaleIndex, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2089$$Nest$mrescaleIndex(AudioService r0, int r1, int r2, int r3) {
        return r0.rescaleIndex(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendBroadcastToAll, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2090$$Nest$msendBroadcastToAll(AudioService r0, Intent r1, Bundle r2) {
        r0.sendBroadcastToAll(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendEnabledSurroundFormats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2091$$Nest$msendEnabledSurroundFormats(AudioService r0, ContentResolver r1, boolean r2) {
        r0.sendEnabledSurroundFormats(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendEncodedSurroundMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2092$$Nest$msendEncodedSurroundMode(AudioService r0, int r1, String r2) {
        r0.sendEncodedSurroundMode(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetExtVolumeController, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2093$$Nest$msetExtVolumeController(AudioService r0, IAudioPolicyCallback r1) {
        r0.setExtVolumeController(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMasterMuteInternalNoCallerCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2094$$Nest$msetMasterMuteInternalNoCallerCheck(AudioService r0, boolean r1, int r2, int r3, String r4) {
        r0.setMasterMuteInternalNoCallerCheck(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMicrophoneMuteNoCallerCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2095$$Nest$msetMicrophoneMuteNoCallerCheck(AudioService r0, int r1) {
        r0.setMicrophoneMuteNoCallerCheck(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetRingerModeInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2096$$Nest$msetRingerModeInt(AudioService r0, int r1, boolean r2) {
        r0.setRingerModeInt(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActiveAssistantServiceUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2097$$Nest$mupdateActiveAssistantServiceUids(AudioService r0) {
        r0.updateActiveAssistantServiceUids();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAssistantUIdLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2098$$Nest$mupdateAssistantUIdLocked(AudioService r0, boolean r1) {
        r0.updateAssistantUIdLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateHdmiCecSinkLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2099$$Nest$mupdateHdmiCecSinkLocked(AudioService r0, boolean r1) {
        r0.updateHdmiCecSinkLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMasterBalance, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2100$$Nest$mupdateMasterBalance(AudioService r0, ContentResolver r1) {
        r0.updateMasterBalance(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateMasterMono, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2101$$Nest$mupdateMasterMono(AudioService r0, ContentResolver r1) {
        r0.updateMasterMono(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRingerAndZenModeAffectedStreams, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2102$$Nest$mupdateRingerAndZenModeAffectedStreams(AudioService r0) {
        return r0.updateRingerAndZenModeAffectedStreams();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetNO_ACTIVE_ASSISTANT_SERVICE_UIDS, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m2103$$Nest$sfgetNO_ACTIVE_ASSISTANT_SERVICE_UIDS() {
        return NO_ACTIVE_ASSISTANT_SERVICE_UIDS;
    }

    /* JADX INFO: renamed from: -$$Nest$sminitializeAudioServerPermissionProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioServerPermissionProvider m2104$$Nest$sminitializeAudioServerPermissionProvider(Context r0, AudioPolicyFacade r1, Executor r2) {
        return initializeAudioServerPermissionProvider(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smisCallStream, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2105$$Nest$smisCallStream(int r0) {
        return isCallStream(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smsendMsg, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2106$$Nest$smsendMsg(Handler r0, int r1, int r2, int r3, int r4, Object r5, int r6) {
        sendMsg(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: getDevicesForAttributes, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List m2107getDevicesForAttributes(AudioAttributes r1) throws RemoteException {
        return getDevicesForAttributes(r1);
    }

    /* JADX INFO: renamed from: getDevicesForAttributesUnprotected, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List m2108getDevicesForAttributesUnprotected(AudioAttributes r1) throws RemoteException {
        return getDevicesForAttributesUnprotected(r1);
    }

    /* JADX INFO: renamed from: getIndependentStreamTypes, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ List m2109getIndependentStreamTypes() throws RemoteException {
        return getIndependentStreamTypes();
    }

    static {
        mCachedParams = new HashMap();
        NO_ACTIVE_ASSISTANT_SERVICE_UIDS = new int[0];
        MAX_STREAM_VOLUME = new int[]{5, 7, 7, 15, 7, 7, 15, 7, 15, 15, 15, 15};
        MIN_STREAM_VOLUME = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0};
        STREAM_VOLUME_OPS = new int[]{34, 36, 35, 36, 37, 38, 39, 36, 36, 36, 64, 36};
        DEFAULT_VOL_STREAM_NO_PLAYBACK = 3;
        TOUCH_VIBRATION_ATTRIBUTES = VibrationAttributes.createForUsage(18);
        mMmi = new ThreadLocal();
        DEFAULT_ARC_AUDIO_DESCRIPTOR = new byte[]{9, 127, 7};
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET = new HashSet();
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.add(4);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.add(8);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.add(131072);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.add(134217728);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.addAll(AudioSystem.DEVICE_OUT_ALL_A2DP_SET);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.addAll(AudioSystem.DEVICE_OUT_ALL_BLE_SET);
        DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.addAll(AudioSystem.DEVICE_OUT_ALL_USB_SET);
        sVolumeGroupStates = new SparseArray();
        sIndependentA11yVolume = false;
        sLifecycleLogger = new EventLogger(20, "audio services lifecycle");
        sMuteLogger = new EventLogger(30, "mute commands");
        sDeviceLogger = new EventLogger(200, "wired/A2DP/hearing aid device connection");
        sForceUseLogger = new EventLogger(20, "force use (logged before setForceUse() is executed)");
        sVolumeLogger = new EventLogger(100, "volume changes (logged when command received by AudioService)");
        sSpatialLogger = new EventLogger(30, "spatial audio");
        RINGER_MODE_NAMES = new String[]{"SILENT", "VIBRATE", PriorityDump.PRIORITY_ARG_NORMAL};
    }

    public void setNotifAliasRingForTest(boolean alias) {
        super.setNotifAliasRingForTest_enforcePermission();
        if (this.mNotifAliasRing == alias) goto L5;
        boolean update = true;
    L6:
        this.mNotifAliasRing = alias;
        if (update == false) goto L10;
        updateStreamVolumeAlias(true, "AudioServiceTest");
        return;
    L10:
        return;
    L5:
        update = false;
        goto L6
    }

    boolean isPlatformVoice() {
        if (this.mPlatformType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    boolean isPlatformTelevision() {
        if (this.mPlatformType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isPlatformAutomotive() {
        if (this.mPlatformType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    int getVolumeForDeviceIgnoreMute(int stream, int device) {
        VolumeStreamState streamState = this.mStreamStates.get(stream);
        if (streamState != null) goto L7;
        return -1;
    L7:
        return streamState.getIndex(device);
    }

    VolumeStreamState getVssForStream(int stream) {
        return this.mStreamStates.get(stream);
    }

    VolumeStreamState getVssForStreamOrDefault(int stream) {
        VolumeStreamState streamState = this.mStreamStates.get(stream);
        if (streamState == null) goto L6;
        return streamState;
    L6:
        throw new IllegalArgumentException("No VolumeStreamState for stream " + stream);
    }

    int getMaxVssVolumeForStream(int stream) {
        VolumeStreamState streamState = this.mStreamStates.get(stream);
        if (streamState != null) goto L7;
        return -1;
    L7:
        return streamState.getMaxIndex();
    }

    public static String makeAlsaAddressString(int card, int device) {
        return "card=" + card + ";device=" + device;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v10 */
    /* JADX WARN: Type inference failed for: r31v11 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r31v3 */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r31v6 */
    /* JADX WARN: Type inference failed for: r31v8 */
    /* JADX WARN: Type inference failed for: r31v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v19 */
    public AudioService(Context r44, AudioSystemAdapter r45, SystemServerAdapter r46, SettingsAdapter r47, AudioVolumeGroupHelperBase r48, AudioPolicyFacade r49, Looper r50, AppOpsManager r51, PermissionEnforcer r52, AudioServerPermissionProvider r53, Executor r54) {
        super(r52);
        this.mNotifAliasRing = false;
        this.mVolumeController = new VolumeController(this);
        this.mVolumeControllerLongPressEnabled = new AtomicBoolean(true);
        this.mMode = new AtomicInteger(0);
        this.mSettingsLock = new Object();
        this.mVolumeStateLock = new Object();
        this.STREAM_VOLUME_ALIAS_VOICE = new int[]{0, 2, 2, 3, 4, 2, 6, 2, 2, 3, 3, 3};
        this.STREAM_VOLUME_ALIAS_TELEVISION = new int[]{3, 3, 3, 3, 3, 3, 6, 3, 3, 3, 3, 3};
        this.STREAM_VOLUME_ALIAS_NONE = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        this.STREAM_VOLUME_ALIAS_DEFAULT = new int[]{0, 2, 2, 3, 4, 2, 6, 2, 2, 3, 3, 3};
        this.mAvrcpAbsVolSupported = false;
        this.mCachedAbsVolDrivingStreamsLock = new Object();
        this.mCachedAbsVolDrivingStreams = new HashMap(Map.of(536870912, 3, 536870913, 3, 536870914, 3, 134217728, 3));
        this.mAudioSystemCallback = new AnonymousClass1(this);
        this.mRingerModeExternal = -1;
        this.mRingerModeAffectedStreams = 0;
        this.mZenModeAffectedStreams = 0;
        this.mBtCommDeviceActive = new AtomicInteger(0);
        AudioServiceIA r15 = null;
        this.mReceiver = new AudioServiceBroadcastReceiver(this, r15);
        this.mScheduledPermissionTasks = new ArrayList();
        this.mUserRestrictionsListener = new AudioServiceUserRestrictionsListener(this, r15);
        this.mNativeShim = new AnonymousClass2(this);
        this.mSetModeDeathHandlers = new ArrayList();
        this.mPrevVolDirection = 0;
        this.mVolumeControlStream = -1;
        this.mUserSelectedVolumeControlStream = false;
        this.mForceControlStreamLock = new Object();
        this.mForceControlStreamClient = null;
        this.mFixedVolumeDevices = new HashSet(Arrays.asList(new Integer[]{2048, 2097152}));
        this.mFullVolumeDevices = new HashSet(Arrays.asList(new Integer[]{262144, 262145}));
        this.mAbsoluteVolumeDeviceInfoMapLock = new Object();
        this.mAbsoluteVolumeDeviceInfoMap = new ArrayMap();
        this.mAbsVolumeMultiModeCaseDevices = new HashSet(Arrays.asList(new Integer[]{134217728, 536870912, 536870913}));
        this.mDockAudioMediaEnabled = true;
        this.mRestorableParameters = new RestorableParameters(r15);
        this.mDockState = 0;
        this.mPrescaleAbsoluteVolume = new float[]{0.6f, 0.8f, 0.9f};
        this.mVolumePolicy = VolumePolicy.DEFAULT;
        this.mAssistantUids = new ArraySet();
        this.mPrimaryAssistantUid = -1;
        this.mActiveAssistantServiceUids = NO_ACTIVE_ASSISTANT_SERVICE_UIDS;
        this.mAccessibilityServiceUidsLock = new Object();
        this.mInputMethodServiceUidLock = new Object();
        this.mInputMethodServiceUid = -1;
        this.mSupportedSystemUsagesLock = new Object();
        this.mSupportedSystemUsages = new int[]{17};
        this.mShouldEnableAllHardening = new AtomicBoolean(false);
        this.mUidObserver = new AnonymousClass3(this);
        this.mRttEnabled = new AtomicBoolean(false);
        this.mMasterMute = new AtomicBoolean(false);
        this.mDisplayListener = new AnonymousClass4(this);
        this.mModeOwnerInDeviceBroker = new AtomicInteger(0);
        this.mSubscriptionChangedListener = new AnonymousClass5(this);
        this.mVoicePlaybackActive = new AtomicBoolean(false);
        this.mMediaPlaybackActive = new AtomicBoolean(false);
        this.mPlaybackActivityMonitor = new AnonymousClass6(this);
        this.mVoiceRecordingActivityMonitor = new AnonymousClass7(this);
        this.mRmtSbmxFullVolRefCount = 0;
        this.mRmtSbmxFullVolDeathHandlers = new ArrayList();
        this.mStreamAliasingDispatchers = new RemoteCallbackList();
        this.mIsCallScreeningModeSupported = false;
        this.mModeDispatchers = new RemoteCallbackList();
        this.mAudioModeResetLock = new Object();
        this.mAudioModeResetCount = 0;
        this.mMuteAwaitConnectionLock = new Object();
        this.mMuteAwaitConnectionDispatchers = new RemoteCallbackList();
        this.mDeviceVolumeBehaviorDispatchers = new RemoteCallbackList();
        this.mHdmiClientLock = new Object();
        this.mHdmiSystemAudioSupported = false;
        this.mHdmiControlStatusChangeListenerCallback = new MyHdmiControlStatusChangeListenerCallback(this, r15);
        this.mMyHdmiCecVolumeControlFeatureListener = new MyHdmiCecVolumeControlFeatureListener(this, r15);
        this.mCameraSoundForced = new AtomicBoolean(false);
        this.mModeLogger = new EventLogger(20, "phone state (logged after successful call to AudioSystem.setPhoneState(int, int))");
        this.mDynPolicyLogger = new EventLogger(10, "dynamic policy events (logged when command received by AudioService)");
        this.mHardeningLogger = new EventLogger(50, "Hardening enforcement");
        this.mPrefMixerAttrDispatcher = new RemoteCallbackList();
        this.mExtVolumeControllerLock = new Object();
        this.mDynPolicyCallback = new AnonymousClass10(this);
        this.mAudioServerStateListeners = new HashMap();
        this.mAudioPolicies = new HashMap();
        this.mAudioPolicyCounter = 0;
        sLifecycleLogger.enqueue(new EventLogger.StringEvent("AudioService()"));
        this.mContext = r44;
        this.mContentResolver = r44.getContentResolver();
        this.mAppOps = r51;
        this.mPermissionProvider = r53;
        this.mAudioServerLifecycleExecutor = r54;
        this.mAudioSystem = r45;
        this.mSystemServer = r46;
        this.mAudioVolumeGroupHelper = r48;
        this.mSettings = r47;
        this.mAudioPolicy = r49;
        this.mAudioPolicy.registerOnStartTask(new AudioService$$ExternalSyntheticLambda34(this));
        this.mASExt = AudioServiceExtProxy.get(this);
        this.mASExt.AudioService_onStart();
        setExtension(this.mASExt);
        this.mPlatformType = AudioSystem.getPlatformType(r44);
        this.mBroadcastHandlerThread = new HandlerThread("AudioService Broadcast");
        this.mBroadcastHandlerThread.start();
        this.mDeviceBroker = new AudioDeviceBroker(this.mContext, this, this.mAudioSystem);
        this.mIsSingleVolume = AudioSystem.isSingleVolume(r44);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mSensorPrivacyManagerInternal = (SensorPrivacyManagerInternal) LocalServices.getService(SensorPrivacyManagerInternal.class);
        this.mAudioEventWakeLock = ((PowerManager) r44.getSystemService("power")).newWakeLock(1, "handleAudioEvent");
        this.mSfxHelper = new SoundEffectsHelper(this.mContext, new AudioService$$ExternalSyntheticLambda35(this));
        this.mSpatializerHelper = new SpatializerHelper(this, this.mAudioSystem, this.mDeviceBroker, SystemProperties.getBoolean("ro.audio.spatializer_binaural_enabled_default", true), SystemProperties.getBoolean("ro.audio.spatializer_transaural_enabled_default", true), this.mContext.getResources().getBoolean(R.bool.config_supportDoubleTapWake));
        this.mVibrator = (Vibrator) r44.getSystemService("vibrator");
        if (this.mVibrator != null) goto L5;
        boolean r0 = false;
    L6:
        this.mHasVibrator = r0;
        this.mSupportsMicPrivacyToggle = ((SensorPrivacyManager) r44.getSystemService(SensorPrivacyManager.class)).supportsSensorToggle(1);
        this.mUseVolumeGroupAliases = this.mContext.getResources().getBoolean(R.bool.config_honor_data_retry_timer_for_emergency_network);
        this.mAudioVolumeChangeHandler = new AudioVolumeChangeHandler(this.mAudioSystem);
        if (AudioProductStrategy.getAudioProductStrategies().size() <= 0) goto L23;
        int r2 = AudioSystem.getNumStreamTypes() - 1;
    L9:
        if (r2 < 0) goto L18;
        AudioAttributes r3 = AudioProductStrategy.getAudioAttributesForStrategyWithLegacyStreamType(r2);
        int r4 = AudioSystem.getMaxVolumeIndexForAttributes(r3);
        if (r4 == (-1)) goto L13;
        MAX_STREAM_VOLUME[r2] = r4;
    L13:
        int r5 = AudioSystem.getMinVolumeIndexForAttributes(r3);
        if (r5 == (-1)) goto L16;
        MIN_STREAM_VOLUME[r2] = r5;
    L16:
        r2 = r2 - 1;
        goto L9
    L18:
        if (this.mUseVolumeGroupAliases == false) goto L23;
        int r6 = 0;
    L21:
        if (r6 >= AudioSystem.DEFAULT_STREAM_VOLUME.length) goto L23;
        AudioSystem.DEFAULT_STREAM_VOLUME[r6] = -1;
        r6 = r6 + 1;
    L23:
        int r7 = SystemProperties.getInt("ro.config.vc_call_vol_steps", -1);
        if (r7 == (-1)) goto L26;
        MAX_STREAM_VOLUME[0] = r7;
    L26:
        int r8 = SystemProperties.getInt("ro.config.vc_call_vol_default", -1);
        if (r8 != (-1)) goto L29;
    L33:
        AudioSystem.DEFAULT_STREAM_VOLUME[0] = (MAX_STREAM_VOLUME[0] * 3) / 4;
    L34:
        int r9 = SystemProperties.getInt("ro.config.media_vol_steps", -1);
        if (r9 == (-1)) goto L37;
        MAX_STREAM_VOLUME[3] = r9;
    L37:
        int r10 = SystemProperties.getInt("ro.config.media_vol_default", -1);
        if (r10 == (-1)) goto L45;
        if (r10 > MAX_STREAM_VOLUME[3]) goto L45;
        if (r10 < MIN_STREAM_VOLUME[3]) goto L45;
        AudioSystem.DEFAULT_STREAM_VOLUME[3] = r10;
    L48:
        int r11 = SystemProperties.getInt("ro.config.alarm_vol_steps", -1);
        if (r11 == (-1)) goto L125;
        MAX_STREAM_VOLUME[4] = r11;
    L125:
        int r1 = this.mContext.getResources().getInteger(R.integer.config_audio_notif_vol_steps);     // Catch: Resources.NotFoundException -> L55
        if (r1 > MAX_STREAM_VOLUME[4]) goto L57;
        MIN_STREAM_VOLUME[4] = r1;     // Catch: Resources.NotFoundException -> L55
    L60:
        int r12 = SystemProperties.getInt("ro.config.alarm_vol_default", -1);
        if (r12 != (-1)) goto L63;
    L65:
        AudioSystem.DEFAULT_STREAM_VOLUME[4] = (MAX_STREAM_VOLUME[4] * 6) / 7;
    L66:
        int r13 = SystemProperties.getInt("ro.config.system_vol_steps", -1);
        if (r13 == (-1)) goto L69;
        char r22 = 1;
        MAX_STREAM_VOLUME[1] = r13;
    L70:
        int r14 = SystemProperties.getInt("ro.config.system_vol_default", -1);
        if (r14 != (-1)) goto L73;
    L75:
        AudioSystem.DEFAULT_STREAM_VOLUME[r22] = MAX_STREAM_VOLUME[r22];
    L76:
        int r16 = SystemProperties.getInt("ro.config.assistant_vol_min", -1);
        if (r16 == (-1)) goto L79;
        MIN_STREAM_VOLUME[11] = r16;
    L79:
        int[] r17 = this.mASExt.AudioService_getStreams(new int[]{5, 2});
        int[] r18 = this.mASExt.AudioService_getStepsResId(new int[]{R.integer.config_autoBrightnessLightSensorRate, R.integer.config_autoPowerModeAnyMotionSensor});
        int[] r19 = this.mASExt.AudioService_getDefaultResId(new int[]{R.integer.config_autoBrightnessDarkeningLightDebounce, R.integer.config_autoBrightnessShortTermModelTimeout});
        int r20 = 0;
        ?? r21 = r11;
    L81:
        if (r20 >= r17.length) goto L115;
        int[] r31 = MIN_STREAM_VOLUME;
        int r32 = r20;
        int r35 = r9;
        r31[r17[r20]] = this.mASExt.AudioService_getMinVolume(r17[r32], MIN_STREAM_VOLUME[r17[r32]]);
        int r23 = this.mContext.getResources().getInteger(r18[r32]);     // Catch: Resources.NotFoundException -> L86
        if (r23 <= 0) goto L89;
        Log.i(TAG, "Stream " + r17[r32] + ": using max vol of " + r23);     // Catch: Resources.NotFoundException -> L86
        MAX_STREAM_VOLUME[r17[r32]] = r23;     // Catch: Resources.NotFoundException -> L86
    L127:
        int r24 = this.mContext.getResources().getInteger(r19[r32]);     // Catch: Resources.NotFoundException -> L110
        int r30 = r10;
        if (r24 > MAX_STREAM_VOLUME[r17[r32]]) goto L109;
    L106:
        e = e;
        ?? r33 = r21;
    L112:
        Log.e(TAG, "Error querying default vol for stream type " + r17[r32], e);
    L113:
        r20 = r32 + 1;
        r10 = r30;
        r21 = r33;
        r9 = r35;
        goto L81
    L95:
        if (r24 >= MIN_STREAM_VOLUME[r17[r32]]) goto L123;
        throw new IllegalArgumentException("Invalid default volume (" + r24 + ") for stream " + r17[r32] + ", lower than min volume of " + MIN_STREAM_VOLUME[r17[r32]]);     // Catch: Resources.NotFoundException -> L104
    L123:
        Log.i(TAG, "Stream " + r17[r32] + ": using default vol of " + r24);     // Catch: Resources.NotFoundException -> L98
        AudioSystem.DEFAULT_STREAM_VOLUME[r17[r32]] = r24;     // Catch: Resources.NotFoundException -> L98
        r33 = r21;
    L98:
        e = e;
        r33 = r21;
        goto L112
    L109:
        throw new IllegalArgumentException("Invalid default volume (" + r24 + ") for stream " + r17[r32] + ", greater than max volume of " + MAX_STREAM_VOLUME[r17[r32]]);     // Catch: Resources.NotFoundException -> L104
    L104:
        e = e;
        r33 = r31;
    L110:
        e = e;
        r30 = r10;
        r33 = r21;
        goto L112
    L89:
        throw new IllegalArgumentException("Invalid negative max volume for stream " + r17[r32]);     // Catch: Resources.NotFoundException -> L86
    L86:
        e = move-exception;
        Log.e(TAG, "Error querying max vol for stream type " + r17[r32], e);
        goto L127
    L115:
        if (r50 != null) goto L117;
        createAudioSystemThread();
    L118:
        this.mSoundDoseHelper = new SoundDoseHelper(this, this.mContext, this.mAudioHandler, this.mSettings, this.mVolumeController);
        AudioSystem.setErrorCallback(this.mAudioSystemCallback);
        updateAudioHalPids();
        this.mUseFixedVolume = this.mContext.getResources().getBoolean(R.bool.config_use_strict_phone_number_comparation_for_russia);
        this.mRingerModeAffectsAlarm = this.mContext.getResources().getBoolean(R.bool.config_autoPowerModePrefetchLocation);
        this.mRecordMonitor = new RecordingActivityMonitor(this.mContext);
        this.mRecordMonitor.registerRecordingCallback(this.mVoiceRecordingActivityMonitor, true);
        this.mASExt.AudioService_beforeUpdateStreamVolumeAlias();
        updateStreamVolumeAlias(false, TAG);
        readPersistedSettings();
        readUserRestrictions();
        this.mLoudnessCodecHelper = new LoudnessCodecHelper(this);
        this.mPlaybackMonitor = new PlaybackActivityMonitor(r44, MAX_STREAM_VOLUME[4], new AudioService$$ExternalSyntheticLambda36(this), new AudioService$$ExternalSyntheticLambda37(this));
        this.mPlaybackMonitor.registerPlaybackCallback(this.mPlaybackActivityMonitor, true);
        this.mMediaFocusControl = new MediaFocusControl(this.mContext, this.mPlaybackMonitor);
        this.mZAudioService = new ZAudioService(this, this.mSettings);
        readAndSetLowRamDevice();
        this.mIsCallScreeningModeSupported = AudioSystem.isCallScreeningModeSupported();
        if (this.mSystemServer.isPrivileged() == false) goto L121;
        LocalServices.addService(AudioManagerInternal.class, new AudioServiceInternal(this));
        this.mUserManagerInternal.addUserRestrictionsListener(this.mUserRestrictionsListener);
        this.mRecordMonitor.initMonitor();
    L121:
        this.mMonitorRotation = SystemProperties.getBoolean("ro.audio.monitorRotation", false);
        this.mHasSpatializerEffect = SystemProperties.getBoolean("ro.audio.spatializer_enabled", false);
        AudioSystemAdapter.setRoutingListener(this);
        AudioSystemAdapter.setVolRangeInitReqListener(this);
        this.mASExt.initReflectionValues();
        queueMsgUnderWakeLock(this.mAudioHandler, 101, 0, 0, null, 0);
        mCachedParams.put("hdr_record_on", "false");
        mCachedParams.put("wnr_on", "false");
        mCachedParams.put("ans_on", "false");
        mCachedParams.put("orientation", "landscape");
        mCachedParams.put("inverted", "false");
        mCachedParams.put("facing", "none");
        mCachedParams.put("hdr_audio_channel_count", "0");
        mCachedParams.put("hdr_audio_sampling_rate", "0");
        queueMsgUnderWakeLock(this.mAudioHandler, 103, 0, 0, null, 0);
        queueMsgUnderWakeLock(this.mAudioHandler, 102, 0, 0, null, 0);
        this.mDisplayManager = (DisplayManager) r44.getSystemService(DisplayManager.class);
        this.mMusicFxHelper = new MusicFxHelper(this.mContext, this.mAudioHandler);
        this.mHardeningEnforcer = new HardeningEnforcer(this.mContext, isPlatformAutomotive(), this.mShouldEnableAllHardening, this.mAppOps, r44.getPackageManager(), this.mHardeningLogger);
        return;
    L117:
        this.mAudioHandler = new AudioHandler(this, r50);
        goto L118
    L73:
        if (r14 > MAX_STREAM_VOLUME[r22]) goto L75;
        AudioSystem.DEFAULT_STREAM_VOLUME[r22] = r14;
        goto L76
    L69:
        r22 = 1;
        goto L70
    L63:
        if (r12 > MAX_STREAM_VOLUME[4]) goto L65;
        AudioSystem.DEFAULT_STREAM_VOLUME[4] = r12;
        goto L66
    L57:
        Log.e(TAG, "Error min alarm volume greater than max alarm volume");     // Catch: Resources.NotFoundException -> L55
    L55:
        e = move-exception;
        Log.e(TAG, "Error querying for alarm min volume ", e);
    L45:
        if (isPlatformTelevision() == false) goto L47;
        AudioSystem.DEFAULT_STREAM_VOLUME[3] = MAX_STREAM_VOLUME[3] / 4;
        goto L48
    L47:
        AudioSystem.DEFAULT_STREAM_VOLUME[3] = MAX_STREAM_VOLUME[3] / 3;
        goto L48
    L29:
        if (r8 > MAX_STREAM_VOLUME[0]) goto L33;
        if (r8 < MIN_STREAM_VOLUME[0]) goto L33;
        AudioSystem.DEFAULT_STREAM_VOLUME[0] = r8;
        goto L34
    L5:
        r0 = this.mVibrator.hasVibrator();
        goto L6
    }

    private /* synthetic */ void lambda$new$0() {
        this.mAudioPolicy.setEnableHardening(this.mShouldEnableAllHardening.get());
    }

    private /* synthetic */ void lambda$new$1(PlayerBase playerBase) {
        ignorePlayerLogs(playerBase);
    }

    private /* synthetic */ void lambda$new$2(AudioDeviceAttributes device) {
        onMuteAwaitConnectionTimeout(device);
    }

    private /* synthetic */ Boolean lambda$new$3(Integer stream) {
        return Boolean.valueOf(isStreamMute(stream.intValue()));
    }

    private void initVolumeStreamStates() {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        Object r1 = this.mVolumeStateLock;
        monitor-enter(r1);
        int streamType = numStreamTypes - 1;
    L5:
        if (streamType < 0) goto L18;
        VolumeStreamState streamState = getVssForStream(streamType);     // Catch: Throwable -> L14
        if (streamState == null) goto L16;
        int groupId = getVolumeGroupForStreamType(streamType);     // Catch: Throwable -> L14
        if (groupId == (-1)) goto L16;
        if (sVolumeGroupStates.indexOfKey(groupId) < 0) goto L16;
        streamState.setVolumeGroupState(sVolumeGroupStates.get(groupId));     // Catch: Throwable -> L14
    L16:
        streamType = streamType - 1;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
    }

    private void onInitStreamsAndVolumes() {
        monitor-enter(this);
        this.mCameraSoundForced.set(readCameraSoundForced());     // Catch: Throwable -> L17
        AudioHandler r2 = this.mAudioHandler;     // Catch: Throwable -> L17
        if (this.mCameraSoundForced.get() == false) goto L6;
        int r6 = 11;
    L7:
        sendMsg(r2, 8, 2, 4, r6, new String("AudioService ctor"), 0);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        createStreamStates();
        initVolumeGroupStates();
        this.mSoundDoseHelper.initSafeMediaVolumeIndex();
        initVolumeStreamStates();
        sRingerAndZenModeMutedStreams = 0;
        sMuteLogger.enqueue(new AudioServiceEvents.RingerZenMutedStreamsEvent(sRingerAndZenModeMutedStreams, "onInitStreamsAndVolumes"));
        setRingerModeInt(getRingerModeInternal(), false);
        initExternalEventReceivers();
        checkVolumeRangeInitialization("AudioService()");
        Object r1 = this.mCachedAbsVolDrivingStreamsLock;
        monitor-enter(r1);
        this.mCachedAbsVolDrivingStreams.forEach(new AudioService$$ExternalSyntheticLambda22(this));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L6:
        r6 = 0;
    L17:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onInitStreamsAndVolumes$4(Integer dev, Integer stream) {
        if (dev.intValue() != 128) goto L5;
        boolean enabled = this.mAvrcpAbsVolSupported;
        boolean enabled2 = enabled;
    L6:
        int result = this.mAudioSystem.setDeviceAbsoluteVolumeEnabled(dev.intValue(), "", enabled2, stream.intValue());
        if (result == 0) goto L10;
        sVolumeLogger.enqueueAndSlog(new AudioServiceEvents.VolumeEvent(13, result, dev.intValue(), enabled2, stream.intValue()).eventToString(), 1, TAG);
        return;
    L10:
        return;
    L5:
        enabled2 = true;
        goto L6
    }

    private void onInitInputGains() {
        this.mInputDeviceVolumeHelper = new InputDeviceVolumeHelper(this.mSettings, this.mContentResolver, "input_gain_index_settings");
    }

    private MediaSessionManager getMediaSessionManager() {
        if (this.mMediaSessionManager != null) goto L6;
        this.mMediaSessionManager = (MediaSessionManager) this.mContext.getSystemService("media_session");
    L6:
        return this.mMediaSessionManager;
    }

    private void initExternalEventReceivers() {
        this.mSettingsObserver = new SettingsObserver(this);
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        if (this.mDeviceBroker.isScoManagedByAudio() == true) goto L5;
        intentFilter.addAction("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED");
    L5:
        intentFilter.addAction("android.intent.action.DOCK_EVENT");
        if (this.mDisplayManager != null) goto L8;
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
    L8:
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        intentFilter.addAction("android.intent.action.USER_BACKGROUND");
        intentFilter.addAction("android.intent.action.USER_FOREGROUND");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.intent.action.PACKAGES_SUSPENDED");
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        if (this.mMonitorRotation == false) goto L11;
        RotationHelper.init(this.mContext, this.mAudioHandler, new AudioService$$ExternalSyntheticLambda3(this), new AudioService$$ExternalSyntheticLambda4(this));
    L11:
        intentFilter.addAction("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION");
        intentFilter.addAction("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION");
        intentFilter.addAction("com.android.server.audio.action.CHECK_MUSIC_ACTIVE");
        intentFilter.setPriority(1000);
        this.mContext.registerReceiverAsUser(this.mReceiver, UserHandle.ALL, intentFilter, null, this.mBroadcastHandlerThread.getThreadHandler(), 2);
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (subscriptionManager != null) goto L14;
        Log.e(TAG, "initExternalEventReceivers cannot create SubscriptionManager!");
    L16:
        if (this.mDisplayManager == null) goto L19;
        this.mDisplayManager.registerDisplayListener(this.mDisplayListener, this.mAudioHandler);
        return;
    L19:
        return;
    L14:
        subscriptionManager.addOnSubscriptionsChangedListener(this.mSubscriptionChangedListener);
        goto L16
    }

    private /* synthetic */ void lambda$initExternalEventReceivers$5(Integer rotation) {
        onRotationUpdate(rotation);
    }

    private /* synthetic */ void lambda$initExternalEventReceivers$6(Boolean foldState) {
        onFoldStateUpdate(foldState);
    }

    public void systemReady() {
        sendMsg(this.mAudioHandler, 16, 2, 0, 0, null, 0);
    }

    private void updateVibratorInfos() {
        VibratorManager vibratorManager = (VibratorManager) this.mContext.getSystemService(VibratorManager.class);
        if (vibratorManager != null) goto L6;
        Slog.e(TAG, "Vibrator manager is not found");
        return;
    L6:
        int[] vibratorIds = vibratorManager.getVibratorIds();
        if (vibratorIds.length != 0) goto L10;
        Slog.d(TAG, "No vibrator found");
        return;
    L10:
        List<Vibrator> vibrators = new ArrayList(vibratorIds.length);
        int r4 = vibratorIds.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L18;
        int id = vibratorIds[r5];
        Vibrator vibrator = vibratorManager.getVibrator(id);
        if (vibrator == null) goto L15;
        vibrators.add(vibrator);
    L16:
        r5 = r5 + 1;
        goto L11
    L15:
        Slog.w(TAG, "Vibrator(" + id + ") is not found");
        goto L16
    L18:
        if (vibrators.isEmpty() == false) goto L21;
        Slog.w(TAG, "Cannot find any available vibrator");
        return;
    L21:
        AudioSystem.setVibratorInfos(vibrators);
    }

    public void onSystemReady() {
        this.mSystemReady = true;
        setupPermissionListener();
        scheduleLoadSoundEffects();
        this.mDeviceBroker.onSystemReady();
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.hdmi.cec") == false) goto L20;
        Object r1 = this.mHdmiClientLock;
        monitor-enter(r1);
        this.mHdmiManager = (HdmiControlManager) this.mContext.getSystemService(HdmiControlManager.class);     // Catch: Throwable -> L9
        if (this.mHdmiManager == null) goto L11;
        this.mHdmiManager.addHdmiControlStatusChangeListener(this.mHdmiControlStatusChangeListenerCallback);     // Catch: Throwable -> L9
        this.mHdmiManager.addHdmiCecVolumeControlFeatureListener(this.mContext.getMainExecutor(), this.mMyHdmiCecVolumeControlFeatureListener);     // Catch: Throwable -> L9
    L11:
        this.mHdmiTvClient = this.mHdmiManager.getTvClient();     // Catch: Throwable -> L9
        if (this.mHdmiTvClient == null) goto L14;
        this.mFixedVolumeDevices.removeAll(AudioSystem.DEVICE_ALL_HDMI_SYSTEM_AUDIO_AND_SPEAKER_SET);     // Catch: Throwable -> L9
    L14:
        this.mHdmiPlaybackClient = this.mHdmiManager.getPlaybackClient();     // Catch: Throwable -> L9
        this.mHdmiAudioSystemClient = this.mHdmiManager.getAudioSystemClient();     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L20:
        if (this.mSupportsMicPrivacyToggle == false) goto L22;
        this.mSensorPrivacyManagerInternal.addSensorPrivacyListenerForAllUsers(1, new AudioService$$ExternalSyntheticLambda18(this));
    L22:
        this.mNm = (NotificationManager) this.mContext.getSystemService("notification");
        this.mSoundDoseHelper.configureSafeMedia(true, TAG);
        initA11yMonitoring();
        this.mRoleObserver = new RoleObserver(this);
        this.mRoleObserver.register();
        this.mASExt.AudioService_onSystemReady();
        onIndicateSystemReady();
        this.mMicMuteFromSystemCached = this.mAudioSystem.isMicrophoneMuted();
        setMicMuteFromSwitchInput();
        initMinStreamVolumeWithoutModifyAudioSettings();
        updateVibratorInfos();
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
        AudioSystem.setSupportedSystemUsages(this.mSupportedSystemUsages);     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onSystemReady$7(int userId, boolean enabled) {
        if (userId != getCurrentUserId()) goto L6;
        this.mMicMuteFromPrivacyToggle = enabled;
        setMicrophoneMuteNoCallerCheck(getCurrentUserId());
        return;
    }

    @Override // com.android.server.audio.AudioSystemAdapter.OnRoutingUpdatedListener
    public void onRoutingUpdatedFromNative() {
        sendMsg(this.mAudioHandler, 41, 0, 0, 0, null, 0);
    }

    void onRoutingUpdatedFromAudioThread() {
        if (this.mHasSpatializerEffect == false) goto L5;
        this.mSpatializerHelper.onRoutingUpdated();
    L5:
        checkMuteAwaitConnection();
    }

    void onRotationUpdate(Integer rotation) {
        this.mSpatializerHelper.setDisplayOrientation((float) ((((double) rotation.intValue()) * 3.141592653589793d) / 180.0d));
        String rotationParameter = "rotation=" + rotation;
        sendMsg(this.mAudioHandler, 48, 0, 0, 0, rotationParameter, 0);
    }

    void onFoldStateUpdate(Boolean foldState) {
        this.mSpatializerHelper.setFoldState(foldState.booleanValue());
        StringBuilder r0 = new StringBuilder();
        r0.append("device_folded=");
        if (foldState.booleanValue() == false) goto L5;
        String r1 = "on";
    L6:
        r0.append(r1);
        String foldStateParameter = r0.toString();
        sendMsg(this.mAudioHandler, 49, 0, 0, 0, foldStateParameter, 0);
        return;
    L5:
        r1 = "off";
        goto L6
    }

    void ignorePlayerLogs(PlayerBase playerToIgnore) {
    }

    @Override // com.android.server.audio.AudioSystemAdapter.OnVolRangeInitRequestListener
    public void onVolumeRangeInitRequestFromNative() {
        sendMsg(this.mAudioHandler, 34, 0, 0, 0, "onVolumeRangeInitRequestFromNative", 0);
    }

    void onIndicateSystemReady() {
        if (AudioSystem.systemReady() != 0) goto L5;
        return;
    L5:
        sendMsg(this.mAudioHandler, 20, 0, 0, 0, null, 1000);
    }

    public void onAudioServerDied() {
        if (this.mSystemReady == false) goto L119;
        if (AudioSystem.checkAudioFlinger() != 0) goto L119;
        Log.i(TAG, "Audioserver started.");
        sLifecycleLogger.enqueue(new EventLogger.StringEvent("onAudioServerDied() audioserver started"));
        updateAudioHalPids();
        AudioSystem.setParameters("restarting=true");
        String params = new String("");
        Log.i(TAG, "Cached params " + mCachedParams.toString());
        Iterator<Map.Entry<String, String>> r1 = mCachedParams.entrySet().iterator();
        String params2 = params;
    L9:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, String> parm = r1.next();
        if (params2.isEmpty() == true) goto L13;
        params2 = params2 + ";";
    L13:
        Log.i(TAG, "Key " + parm.getKey() + " Value " + parm.getValue());
        params2 = ((params2 + parm.getKey()) + "=") + parm.getValue();
        Log.i(TAG, "Params " + params2);
        goto L9
    L15:
        if (params2.isEmpty() == true) goto L17;
        Log.i(TAG, "Restore params " + params2);
        AudioSystem.setParameters(params2);
    L18:
        readAndSetLowRamDevice();
        this.mIsCallScreeningModeSupported = AudioSystem.isCallScreeningModeSupported();
        this.mDeviceBroker.onAudioServerDied();
        Object r2 = this.mDeviceBroker.mSetModeLock;
        monitor-enter(r2);
        onUpdateAudioMode(-1, Process.myPid(), this.mContext.getPackageName(), true, false);     // Catch: Throwable -> L112
        monitor-exit(r2);     // Catch: Throwable -> L112
        if (this.mCameraSoundForced.get() == false) goto L27;
        int r0 = 11;
    L28:
        int forSys = r0;
        this.mDeviceBroker.setForceUse_Async(4, forSys, "onAudioServerDied");
        onReinitVolumes("after audioserver restart");
        restoreVolumeGroups();
        updateMasterMono(this.mContentResolver);
        updateMasterBalance(this.mContentResolver);
        setRingerModeInt(getRingerModeInternal(), false);
        if (this.mMonitorRotation == false) goto L31;
        RotationHelper.updateOrientation();
    L31:
        this.mRestorableParameters.restoreAll();
        if (this.mDockAudioMediaEnabled == false) goto L34;
        int r3 = 9;
    L35:
        int forDock = r3;
        this.mDeviceBroker.setForceUse_Async(3, forDock, "onAudioServerDied");
        sendEncodedSurroundMode(this.mContentResolver, "onAudioServerDied");
        sendEnabledSurroundFormats(this.mContentResolver, true);
        AudioSystem.setRttEnabled(this.mRttEnabled.get());
        Object r7 = this.mSettingsLock;
        monitor-enter(r7);
        resetAssistantServicesUidsLocked();     // Catch: Throwable -> L109
        monitor-exit(r7);     // Catch: Throwable -> L109
        Object r8 = this.mAccessibilityServiceUidsLock;
        monitor-enter(r8);
        AudioSystem.setA11yServicesUids(this.mAccessibilityServiceUids);     // Catch: Throwable -> L106
        monitor-exit(r8);     // Catch: Throwable -> L106
        Object r9 = this.mInputMethodServiceUidLock;
        monitor-enter(r9);
        this.mAudioSystem.setCurrentImeUid(this.mInputMethodServiceUid);     // Catch: Throwable -> L103
        monitor-exit(r9);     // Catch: Throwable -> L103
        Object r10 = this.mHdmiClientLock;
        monitor-enter(r10);
    L54:
        th = move-exception;
        throw th;
    L50:
        if (this.mHdmiManager != null) goto L52;
    L56:
        monitor-exit(r10);     // Catch: Throwable -> L54
        Object r11 = this.mSupportedSystemUsagesLock;
        monitor-enter(r11);
        AudioSystem.setSupportedSystemUsages(this.mSupportedSystemUsages);     // Catch: Throwable -> L98
        monitor-exit(r11);     // Catch: Throwable -> L98
        HashMap<IBinder, AudioPolicyProxy> r12 = this.mAudioPolicies;
        monitor-enter(r12);
        ArrayList<AudioPolicyProxy> invalidProxies = new ArrayList();     // Catch: Throwable -> L69
        Iterator<AudioPolicyProxy> r13 = this.mAudioPolicies.values().iterator();     // Catch: Throwable -> L69
    L65:
        if (r13.hasNext() == false) goto L75;
        AudioPolicyProxy policy = r13.next();     // Catch: Throwable -> L69
        int status = policy.connectMixes();     // Catch: Throwable -> L69
        if (status == 0) goto L71;
        Log.e(TAG, "onAudioServerDied: error " + AudioSystem.audioSystemErrorToString(status) + " when connecting mixes for policy " + policy.toLogFriendlyString());     // Catch: Throwable -> L69
        invalidProxies.add(policy);     // Catch: Throwable -> L69
        goto L65
    L71:
        int deviceAffinitiesStatus = policy.setupDeviceAffinities();     // Catch: Throwable -> L69
        if (deviceAffinitiesStatus == 0) goto L65;
        Log.e(TAG, "onAudioServerDied: error " + AudioSystem.audioSystemErrorToString(deviceAffinitiesStatus) + " when connecting device affinities for policy " + policy.toLogFriendlyString());     // Catch: Throwable -> L69
        invalidProxies.add(policy);     // Catch: Throwable -> L69
        goto L65
    L75:
        invalidProxies.forEach(new AudioService$$ExternalSyntheticLambda14());     // Catch: Throwable -> L69
        monitor-exit(r12);     // Catch: Throwable -> L69
        PlaybackActivityMonitor r14 = this.mPlaybackMonitor;
        monitor-enter(r14);
        HashMap<Integer, Integer> allowedCapturePolicies = this.mPlaybackMonitor.getAllAllowedCapturePolicies();     // Catch: Throwable -> L85
        Iterator<Map.Entry<Integer, Integer>> r15 = allowedCapturePolicies.entrySet().iterator();     // Catch: Throwable -> L85
    L81:
        if (r15.hasNext() == false) goto L88;
        Map.Entry<Integer, Integer> entry = r15.next();     // Catch: Throwable -> L85
        int result = this.mAudioSystem.setAllowedCapturePolicy(entry.getKey().intValue(), AudioAttributes.capturePolicyToFlags(entry.getValue().intValue(), 0));     // Catch: Throwable -> L85
        if (result == 0) goto L81;
        Log.e(TAG, "Failed to restore capture policy, uid: " + entry.getKey() + ", capture policy: " + entry.getValue() + ", result: " + result);     // Catch: Throwable -> L85
        this.mPlaybackMonitor.setAllowedCapturePolicy(entry.getKey().intValue(), 1);     // Catch: Throwable -> L85
        goto L81
    L88:
        monitor-exit(r14);     // Catch: Throwable -> L85
        this.mSpatializerHelper.reset(this.mHasSpatializerEffect);
        this.mZAudioService.reset();
        if (this.mMonitorRotation == false) goto L92;
        RotationHelper.forceUpdate();
    L92:
        onIndicateSystemReady();
        AudioSystem.setParameters("restarting=false");
        this.mSoundDoseHelper.reset(true);
        sendMsg(this.mAudioHandler, 23, 2, 1, 0, null, 0);
        setMicrophoneMuteNoCallerCheck(getCurrentUserId());
        setMicMuteFromSwitchInput();
        updateVibratorInfos();
        return;
    L85:
        th = move-exception;
        throw th;
    L69:
        th = move-exception;
        throw th;
    L98:
        th = move-exception;
        throw th;
    L52:
        if (this.mHdmiTvClient == null) goto L56;
        setHdmiSystemAudioSupported(this.mHdmiSystemAudioSupported);     // Catch: Throwable -> L54
    L103:
        th = move-exception;
        throw th;
    L106:
        th = move-exception;
        throw th;
    L109:
        th = move-exception;
        throw th;
    L34:
        r3 = 0;
        goto L35
    L27:
        r0 = 0;
    L112:
        th = th;
    L116:
        monitor-exit(r2);     // Catch: Throwable -> L112
        throw th;
    L114:
        th = th;
        goto L116
    L17:
        Log.i(TAG, "Empty cached params " + params2);
    L119:
        Log.e(TAG, "Audioserver died.");
        sLifecycleLogger.enqueue(new EventLogger.StringEvent("onAudioServerDied() audioserver died"));
        sendMsg(this.mAudioHandler, 4, 1, 0, 0, null, 500);
    }

    private static /* synthetic */ void lambda$onAudioServerDied$8(AudioPolicyProxy policy) {
        policy.release();
    }

    private void onRemoveAssistantServiceUids(int[] uids) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        removeAssistantServiceUidsLocked(uids);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeAssistantServiceUidsLocked(int[] uids) {
        boolean changed = false;
        int index = 0;
    L4:
        if (index >= uids.length) goto L11;
        if (this.mAssistantUids.remove(Integer.valueOf(uids[index])) == true) goto L8;
        Slog.e(TAG, TextUtils.formatSimple("Cannot remove assistant service, uid(%d) not present", new Object[]{Integer.valueOf(uids[index])}));
    L9:
        index = index + 1;
        goto L4
    L8:
        changed = true;
        goto L9
    L11:
        if (changed == false) goto L17;
        updateAssistantServicesUidsLocked();
        return;
    }

    private void onAddAssistantServiceUids(int[] uids) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        addAssistantServiceUidsLocked(uids);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void addAssistantServiceUidsLocked(int[] uids) {
        boolean changed = false;
        int index = 0;
    L4:
        if (index >= uids.length) goto L14;
        if (uids[index] == (-1)) goto L12;
        if (this.mAssistantUids.add(Integer.valueOf(uids[index])) == true) goto L11;
        Slog.e(TAG, TextUtils.formatSimple("Cannot add assistant service, uid(%d) already present", new Object[]{Integer.valueOf(uids[index])}));
        goto L12
    L11:
        changed = true;
    L12:
        index = index + 1;
        goto L4
    L14:
        if (changed == false) goto L21;
        updateAssistantServicesUidsLocked();
        return;
    }

    private void resetAssistantServicesUidsLocked() {
        this.mAssistantUids.clear();
        updateAssistantUIdLocked(true);
    }

    private void updateAssistantServicesUidsLocked() {
        int[] assistantUids = this.mAssistantUids.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
        AudioSystem.setAssistantServicesUids(assistantUids);
    }

    private void updateActiveAssistantServiceUids() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int[] activeAssistantServiceUids = this.mActiveAssistantServiceUids;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        AudioSystem.setActiveAssistantServicesUids(activeAssistantServiceUids);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onReinitVolumes(String caller) {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int streamType = numStreamTypes - 1;
    L3:
        if (streamType < 0) goto L12;
        VolumeStreamState streamState = getVssForStream(streamType);
        if (streamState == null) goto L11;
        int res = AudioSystem.initStreamVolume(streamType, MIN_STREAM_VOLUME[streamType], MAX_STREAM_VOLUME[streamType]);
        if (res != 0) goto L9;
        streamState.applyAllVolumes();
        goto L11
    L9:
        Log.e(TAG, "Failed to initStreamVolume (" + res + ") for stream " + streamType);
        int streamType2 = res;
    L13:
        if (streamType2 == 0) goto L16;
        sLifecycleLogger.enqueue(new EventLogger.StringEvent(caller + ": initStreamVolume failed with " + streamType2 + " will retry").printLog(1, TAG));
        sendMsg(this.mAudioHandler, 34, 1, 0, 0, caller, 2000);
        return;
    L16:
        Object r12 = this.mCachedAbsVolDrivingStreamsLock;
        monitor-enter(r12);
        this.mCachedAbsVolDrivingStreams.forEach(new AudioService$$ExternalSyntheticLambda5(this));     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
        if (checkVolumeRangeInitialization(caller) == true) goto L23;
        return;
    L23:
        sLifecycleLogger.enqueue(new EventLogger.StringEvent(caller + ": initStreamVolume succeeded").printLog(0, TAG));
        return;
    L25:
        th = move-exception;
        throw th;
    L11:
        streamType = streamType - 1;
        goto L3
    L12:
        streamType2 = 0;
        goto L13
    }

    private /* synthetic */ void lambda$onReinitVolumes$9(Integer dev, Integer stream) {
        if (dev.intValue() != 128) goto L5;
        boolean enabled = this.mAvrcpAbsVolSupported;
        boolean enabled2 = enabled;
    L6:
        int result = this.mAudioSystem.setDeviceAbsoluteVolumeEnabled(dev.intValue(), "", enabled2, stream.intValue());
        if (result == 0) goto L10;
        sVolumeLogger.enqueueAndSlog(new AudioServiceEvents.VolumeEvent(13, result, dev.intValue(), enabled2, stream.intValue()).eventToString(), 1, TAG);
        return;
    L10:
        return;
    L5:
        enabled2 = true;
        goto L6
    }

    private boolean checkVolumeRangeInitialization(String caller) {
        boolean success = true;
        int r5 = 0;
        int[] basicStreams = {4, 2, 3, 0, 10};
        int r2 = basicStreams.length;
    L4:
        if (r5 >= r2) goto L12;
        int streamType = basicStreams[r5];
        AudioAttributes aa = new AudioAttributes.Builder().setInternalLegacyStreamType(streamType).build();
        if (AudioSystem.getMaxVolumeIndexForAttributes(aa) < 0) goto L11;
        if (AudioSystem.getMinVolumeIndexForAttributes(aa) < 0) goto L11;
        r5 = r5 + 1;
    L11:
        success = false;
    L12:
        if (success == true) goto L15;
        sLifecycleLogger.enqueue(new EventLogger.StringEvent(caller + ": initStreamVolume succeeded but invalid mix/max levels, will retry").printLog(2, TAG));
        sendMsg(this.mAudioHandler, 34, 1, 0, 0, caller, 2000);
    L15:
        return success;
    }

    private void onDispatchAudioServerStateChange(boolean state) {
        HashMap<IBinder, AsdProxy> r0 = this.mAudioServerStateListeners;
        monitor-enter(r0);
        Iterator<AsdProxy> r1 = this.mAudioServerStateListeners.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L15;
        AsdProxy asdp = r1.next();     // Catch: Throwable -> L10
        asdp.callback().dispatchAudioServerStateChange(state);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Log.w(TAG, "Could not call dispatchAudioServerStateChange()", e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void createAudioSystemThread() {
        this.mAudioSystemThread = new AudioSystemThread(this);
        this.mAudioSystemThread.start();
        waitForAudioHandlerCreation();
    }

    private void waitForAudioHandlerCreation() {
        monitor-enter(this);
    L15:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mAudioHandler != null) goto L11;
        wait();     // Catch: Throwable -> L7 InterruptedException -> L9
    L10:
        Log.e(TAG, "Interrupted while waiting on volume handler.");     // Catch: Throwable -> L7
        goto L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public void setSupportedSystemUsages(int[] systemUsages) {
        super.setSupportedSystemUsages_enforcePermission();
        verifySystemUsages(systemUsages);
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
        AudioSystem.setSupportedSystemUsages(systemUsages);     // Catch: Throwable -> L7
        this.mSupportedSystemUsages = systemUsages;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int[] getSupportedSystemUsages() {
        super.getSupportedSystemUsages_enforcePermission();
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
        int[] r1 = Arrays.copyOf(this.mSupportedSystemUsages, this.mSupportedSystemUsages.length);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void verifySystemUsages(int[] systemUsages) {
        int i = 0;
    L4:
        if (i >= systemUsages.length) goto L11;
        if (AudioAttributes.isSystemUsage(systemUsages[i]) == false) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("Non-system usage provided: " + systemUsages[i]);
    }

    public List<AudioProductStrategy> getAudioProductStrategies() {
        super.getAudioProductStrategies_enforcePermission();
        return AudioProductStrategy.getAudioProductStrategies();
    }

    public List<AudioVolumeGroup> getAudioVolumeGroups() {
        super.getAudioVolumeGroups_enforcePermission();
        return this.mAudioVolumeGroupHelper.getAudioVolumeGroups();
    }

    private void checkAllAliasStreamVolumes() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        Object r1 = this.mVolumeStateLock;     // Catch: Throwable -> L21
        monitor-enter(r1);     // Catch: Throwable -> L21
        int numStreamTypes = AudioSystem.getNumStreamTypes();     // Catch: Throwable -> L14
        int streamType = 0;
    L7:
        if (streamType >= numStreamTypes) goto L18;
        int streamAlias = sStreamVolumeAlias.get(streamType, -1);     // Catch: Throwable -> L14
        VolumeStreamState streamState = getVssForStream(streamType);     // Catch: Throwable -> L14
        if (streamAlias == (-1)) goto L16;
        if (streamState == null) goto L16;
        streamState.setAllIndexes(getVssForStream(streamAlias), TAG);     // Catch: Throwable -> L14
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState) == true) goto L16;
        streamState.applyAllVolumes();     // Catch: Throwable -> L14
    L16:
        streamType = streamType + 1;     // Catch: Throwable -> L14
        goto L7
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    void postCheckVolumeCecOnHdmiConnection(int state, String caller) {
        sendMsg(this.mAudioHandler, 28, 0, state, 0, caller, 0);
    }

    private void onCheckVolumeCecOnHdmiConnection(int state, String caller) {
        if (state != 1) goto L24;
        if (this.mSoundDoseHelper.safeDevicesContains(1024) == false) goto L8;
        this.mSoundDoseHelper.scheduleMusicActiveCheck();
    L8:
        if (isPlatformTelevision() == false) goto L22;
        Object r0 = this.mHdmiClientLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.mHdmiManager != null) goto L14;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L16
        goto L22
    L14:
        if (this.mHdmiPlaybackClient == null) goto L18;
        updateHdmiCecSinkLocked(this.mFullVolumeDevices.contains(1024));     // Catch: Throwable -> L16
    L22:
        sendEnabledSurroundFormats(this.mContentResolver, true);
        return;
    L24:
        if (isPlatformTelevision() == false) goto L41;
        Object r1 = this.mHdmiClientLock;
        monitor-enter(r1);
    L30:
        th = move-exception;
        throw th;
    L28:
        if (this.mHdmiManager == null) goto L32;
        updateHdmiCecSinkLocked(this.mFullVolumeDevices.contains(1024));     // Catch: Throwable -> L30
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    }

    private void postUpdateVolumeStatesForAudioDevice(int device, String caller) {
        sendMsg(this.mAudioHandler, 33, 2, device, 0, caller, 0);
    }

    private void onUpdateVolumeStatesForAudioDevice(int device, String caller) {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        Object r1 = this.mSettingsLock;
        monitor-enter(r1);
        Object r2 = this.mVolumeStateLock;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        int streamType = 0;
    L7:
        if (streamType >= numStreamTypes) goto L12;
        updateVolumeStates(device, streamType, caller);     // Catch: Throwable -> L9
        streamType = streamType + 1;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void updateVolumeStates(int device, int streamType, String caller) {
        if (streamType != 6) goto L6;
        return;
    L6:
        if (device != 4194304) goto L8;
        device = 2;
    L8:
        VolumeStreamState streamState = getVssForStream(streamType);
        if (streamState != null) goto L12;
        return;
    L12:
        if (streamState.hasIndexForDevice(device) == true) goto L14;
        streamState.setIndex(getVssForStreamOrDefault(sStreamVolumeAlias.get(streamType)).getIndex(1073741824), device, caller, true);
    L14:
        List<AudioDeviceAttributes> devicesForAttributes = getDevicesForAttributesInt(new AudioAttributes.Builder().setInternalLegacyStreamType(streamType).build(), true);
        Iterator<AudioDeviceAttributes> r2 = devicesForAttributes.iterator();
    L16:
        if (r2.hasNext() == false) goto L25;
        AudioDeviceAttributes deviceAttributes = r2.next();
        if (deviceAttributes.getType() != AudioDeviceInfo.convertInternalDeviceToDeviceType(device)) goto L16;
        streamState.checkFixedVolumeDevices();
        if (isStreamMute(streamType) == false) goto L16;
        if (this.mFullVolumeDevices.contains(Integer.valueOf(device)) == false) goto L16;
        streamState.mute(false, "updateVolumeStates(" + caller);
        goto L16
    }

    private void checkAllFixedVolumeDevices() {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int streamType = 0;
    L3:
        if (streamType >= numStreamTypes) goto L9;
        VolumeStreamState vss = getVssForStream(streamType);
        if (vss == null) goto L7;
        vss.checkFixedVolumeDevices();
    L7:
        streamType = streamType + 1;
        goto L3
    }

    private void checkAllFixedVolumeDevices(int streamType) {
        VolumeStreamState vss = getVssForStream(streamType);
        if (vss != null) goto L5;
        return;
    L5:
        vss.checkFixedVolumeDevices();
    }

    private void checkMuteAffectedStreams() {
        int i = 0;
    L4:
        if (i >= this.mStreamStates.size()) goto L15;
        VolumeStreamState vss = this.mStreamStates.valueAt(i);
        if (vss == null) goto L14;
        if (VolumeStreamState.m2125$$Nest$fgetmIndexMin(vss) <= 0) goto L14;
        if (VolumeStreamState.m2127$$Nest$fgetmStreamType(vss) == 0) goto L14;
        if (VolumeStreamState.m2127$$Nest$fgetmStreamType(vss) == 6) goto L14;
        this.mMuteAffectedStreams &= ~(1 << VolumeStreamState.m2127$$Nest$fgetmStreamType(vss));
    L14:
        i = i + 1;
        goto L4
    L15:
        updateUserMutableStreams();
    }

    private void createStreamStates() {
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        this.mStreamStates = new SparseArray(numStreamTypes);
        int i = 0;
    L3:
        if (i >= numStreamTypes) goto L8;
        int streamAlias = sStreamVolumeAlias.get(i, -1);
        if (streamAlias < 0) goto L7;
        this.mStreamStates.set(i, new VolumeStreamState(this, Settings.System.VOLUME_SETTINGS_INT[streamAlias], i, null));
    L7:
        i = i + 1;
        goto L3
    L8:
        checkAllFixedVolumeDevices();
        checkAllAliasStreamVolumes();
        checkMuteAffectedStreams();
        updateDefaultVolumes();
    }

    private void updateDefaultVolumes() {
        int stream = 0;
    L4:
        if (stream >= this.mStreamStates.size()) goto L20;
        int streamType = this.mStreamStates.keyAt(stream);
        int streamVolumeAlias = sStreamVolumeAlias.get(streamType, -1);
        if (this.mUseVolumeGroupAliases == true) goto L8;
    L15:
        if (streamVolumeAlias < 0) goto L18;
        if (streamType == streamVolumeAlias) goto L18;
        AudioSystem.DEFAULT_STREAM_VOLUME[streamType] = getUiDefaultRescaledIndex(streamVolumeAlias, streamType);
    L18:
        stream = stream + 1;
        goto L4
    L8:
        if (AudioSystem.DEFAULT_STREAM_VOLUME[streamType] != (-1)) goto L18;
        streamVolumeAlias = 3;
        int defaultAliasVolume = getUiDefaultRescaledIndex(3, streamType);
        if (defaultAliasVolume < MIN_STREAM_VOLUME[streamType]) goto L15;
        if (defaultAliasVolume > MAX_STREAM_VOLUME[streamType]) goto L15;
        AudioSystem.DEFAULT_STREAM_VOLUME[streamType] = defaultAliasVolume;
        goto L18
    }

    private int getUiDefaultRescaledIndex(int srcStream, int dstStream) {
        return (rescaleIndex(AudioSystem.DEFAULT_STREAM_VOLUME[srcStream] * 10, srcStream, dstStream) + 5) / 10;
    }

    private static int replaceBtScoStreamWithVoiceCall(int streamType, String caller) {
        if (streamType != 6) goto L6;
        Log.d(TAG, "Deprecating STREAM_BLUETOOTH_SCO, using STREAM_VOICE_CALL instead for caller: " + caller);
        return 0;
    L6:
        return streamType;
    }

    private boolean isStreamBluetoothSco(int streamType) {
        if (streamType == 6) goto L11;
        if (streamType == 0) goto L6;
    L8:
        return false;
    L6:
        if (this.mBtCommDeviceActive.get() != 1) goto L8;
        return true;
    L11:
        throw new IllegalArgumentException("STREAM_BLUETOOTH_SCO is deprecated");
    }

    private boolean isStreamBluetoothComm(int streamType) {
        if (streamType != 0) goto L6;
        if (this.mBtCommDeviceActive.get() == 0) goto L6;
    L7:
        return true;
    L6:
        if (streamType == 6) goto L7;
        return false;
    }

    private void dumpStreamStates(PrintWriter pw) {
        pw.println("\nStream volumes (device: index)");
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int i = 0;
    L3:
        if (i >= numStreamTypes) goto L16;
        if (i == 6) goto L15;
        StringBuilder alias = new StringBuilder();
        int streamAlias = sStreamVolumeAlias.get(i, -1);
        if (streamAlias == i) goto L11;
        if (streamAlias == (-1)) goto L11;
        alias.append(" (aliased to: ");
        alias.append(AudioSystem.STREAM_NAMES[streamAlias]);
        alias.append(")");
    L11:
        pw.println("- " + AudioSystem.STREAM_NAMES[i] + alias + ":");
        VolumeStreamState vss = getVssForStream(i);
        if (vss == null) goto L14;
        VolumeStreamState.m2129$$Nest$mdump(vss, pw);
    L14:
        pw.println("");
    L15:
        i = i + 1;
        goto L3
    L16:
        pw.print("\n- mute affected streams = 0x");
        pw.println(Integer.toHexString(this.mMuteAffectedStreams));
        pw.print("\n- user mutable streams = 0x");
        pw.println(Integer.toHexString(this.mUserMutableStreams));
    }

    private void initStreamVolumeAlias(int[] streamVolumeAlias) {
        sStreamVolumeAlias = new SparseIntArray(streamVolumeAlias.length);
        int i = 0;
    L4:
        if (i >= streamVolumeAlias.length) goto L7;
        sStreamVolumeAlias.put(i, streamVolumeAlias[i]);
        i = i + 1;
        goto L4
    }

    private void updateStreamVolumeAlias(boolean updateVolumes, String caller) {
        int assistantStreamAlias = 3;
        if (sIndependentA11yVolume == false) goto L5;
        int r0 = 10;
    L6:
        int a11yStreamAlias = r0;
        if (this.mContext.getResources().getBoolean(R.bool.config_useSystemProvidedLauncherForSecondary) == false) goto L11;
        assistantStreamAlias = 11;
    L11:
        if (this.mIsSingleVolume == false) goto L14;
        initStreamVolumeAlias(this.STREAM_VOLUME_ALIAS_TELEVISION);
        int dtmfStreamAlias = 3;
    L24:
        if (this.mIsSingleVolume == false) goto L27;
        this.mRingerModeAffectedStreams = 0;
    L30:
        int dtmfStreamAlias2 = dtmfStreamAlias;
    L31:
        sStreamVolumeAlias.put(8, dtmfStreamAlias2);
        sStreamVolumeAlias.put(10, a11yStreamAlias);
        sStreamVolumeAlias.put(11, assistantStreamAlias);
        sStreamVolumeAlias.delete(6);
        if (updateVolumes == true) goto L34;
    L53:
        dispatchStreamAliasingUpdate();
        return;
    L34:
        if (this.mStreamStates == null) goto L53;
        updateDefaultVolumes();
        Object r6 = this.mSettingsLock;
        monitor-enter(r6);
        Object r10 = this.mVolumeStateLock;     // Catch: Throwable -> L46
        monitor-enter(r10);     // Catch: Throwable -> L46
        getVssForStreamOrDefault(8).setAllIndexes(getVssForStreamOrDefault(dtmfStreamAlias2), caller);     // Catch: Throwable -> L48
        getVssForStreamOrDefault(10).setSettingName(Settings.System.VOLUME_SETTINGS_INT[a11yStreamAlias]);     // Catch: Throwable -> L48
        getVssForStreamOrDefault(10).setAllIndexes(getVssForStreamOrDefault(a11yStreamAlias), caller);     // Catch: Throwable -> L48
        monitor-exit(r10);     // Catch: Throwable -> L48
        monitor-exit(r6);     // Catch: Throwable -> L46
        if (sIndependentA11yVolume == false) goto L45;
        getVssForStreamOrDefault(10).readSettings();
    L45:
        setRingerModeInt(getRingerModeInternal(), false);
        sendMsg(this.mAudioHandler, 10, 2, 0, 0, getVssForStreamOrDefault(8), 0);
        sendMsg(this.mAudioHandler, 10, 2, 0, 0, getVssForStreamOrDefault(10), 0);
        goto L53
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    L27:
        if (isInCommunication() == false) goto L29;
        this.mRingerModeAffectedStreams &= -257;
        dtmfStreamAlias2 = 0;
        goto L31
    L29:
        this.mRingerModeAffectedStreams |= 256;
        goto L30
    L14:
        if (this.mUseVolumeGroupAliases == false) goto L16;
        initStreamVolumeAlias(this.STREAM_VOLUME_ALIAS_NONE);
        dtmfStreamAlias = 8;
        goto L24
    L16:
        int dtmfStreamAlias3 = this.mPlatformType;
        switch(dtmfStreamAlias3) {
            case 1: goto L19;
            default: goto L18;
        };
    L18:
        initStreamVolumeAlias(this.STREAM_VOLUME_ALIAS_DEFAULT);
        dtmfStreamAlias = 3;
    L21:
        if (this.mNotifAliasRing == true) goto L24;
        sStreamVolumeAlias.put(5, 5);
        goto L24
    L19:
        initStreamVolumeAlias(this.STREAM_VOLUME_ALIAS_VOICE);
        dtmfStreamAlias = 2;
        goto L21
    L5:
        r0 = 3;
        goto L6
    }

    private void readDockAudioSettings(ContentResolver cr) {
        int r2 = 0;
        boolean r1 = true;
        if (this.mSettings.getGlobalInt(cr, "dock_audio_media_enabled", 0) == 1) goto L6;
        r1 = false;
    L6:
        this.mDockAudioMediaEnabled = r1;
        AudioHandler r3 = this.mAudioHandler;
        if (this.mDockAudioMediaEnabled == false) goto L11;
        r2 = 9;
    L11:
        sendMsg(r3, 8, 2, 3, r2, new String("readDockAudioSettings"), 0);
    }

    private void updateMasterMono(ContentResolver cr) {
        boolean masterMono = false;
        if (this.mSettings.getSystemIntForUser(cr, "master_mono", 0, -2) != 1) goto L5;
        masterMono = true;
    L5:
        Log.d(TAG, String.format("Master mono %b", new Object[]{Boolean.valueOf(masterMono)}));
        AudioSystem.setMasterMono(masterMono);
    }

    private void updateMasterBalance(ContentResolver cr) {
        float masterBalance = Settings.System.getFloatForUser(cr, "master_balance", 0.0f, -2);
        Log.d(TAG, String.format("Master balance %f", new Object[]{Float.valueOf(masterBalance)}));
        if (AudioSystem.setMasterBalance(masterBalance) == 0) goto L6;
        Log.e(TAG, String.format("setMasterBalance failed for %f", new Object[]{Float.valueOf(masterBalance)}));
        return;
    }

    private void sendEncodedSurroundMode(ContentResolver cr, String eventSource) {
        int encodedSurroundMode = this.mSettings.getGlobalInt(cr, "encoded_surround_output", 0);
        sendEncodedSurroundMode(encodedSurroundMode, eventSource);
    }

    private void sendEncodedSurroundMode(int encodedSurroundMode, String eventSource) {
        int forceSetting = 17;
        switch(encodedSurroundMode) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Log.e(TAG, "updateSurroundSoundSettings: illegal value " + encodedSurroundMode);
    L10:
        if (forceSetting == 17) goto L13;
        this.mDeviceBroker.setForceUse_Async(6, forceSetting, eventSource);
        return;
    L13:
        return;
    L5:
        forceSetting = 15;
        goto L10
    L6:
        forceSetting = 14;
        goto L10
    L7:
        forceSetting = 13;
        goto L10
    L8:
        forceSetting = 0;
        goto L10
    }

    protected void onUnhandledException(int code, int flags, Exception e) {
        Slog.wtf(TAG, "Uncaught exception in AudioService: " + code + ", " + flags, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MANAGE_AUDIO_POLICY") != 0) goto L7;
        new AudioManagerShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
        return;
    L7:
        throw new SecurityException("Missing MANAGE_AUDIO_POLICY permission");
    }

    public IAudioManagerNative getNativeInterface() {
        return this.mNativeShim;
    }

    public Map<Integer, Boolean> getSurroundFormats() {
        Map<Integer, Boolean> surroundFormats = new HashMap();
        int status = AudioSystem.getSurroundFormats(surroundFormats);
        if (status == 0) goto L6;
        Log.e(TAG, "getSurroundFormats failed:" + status);
        return new HashMap();
    L6:
        return surroundFormats;
    }

    public List<Integer> getReportedSurroundFormats() {
        ArrayList<Integer> reportedSurroundFormats = new ArrayList();
        int status = AudioSystem.getReportedSurroundFormats(reportedSurroundFormats);
        if (status == 0) goto L6;
        Log.e(TAG, "getReportedSurroundFormats failed:" + status);
        return new ArrayList();
    L6:
        return reportedSurroundFormats;
    }

    public boolean isSurroundFormatEnabled(int audioFormat) {
        if (isSurroundFormat(audioFormat) == true) goto L6;
        Log.w(TAG, "audioFormat to enable is not a surround format.");
        return false;
    L6:
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mSettingsLock;     // Catch: Throwable -> L16
        monitor-enter(r2);     // Catch: Throwable -> L16
        HashSet<Integer> enabledFormats = getEnabledFormats();     // Catch: Throwable -> L13
        boolean r4 = enabledFormats.contains(Integer.valueOf(audioFormat));     // Catch: Throwable -> L13
        monitor-exit(r2);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r4;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public boolean setSurroundFormatEnabled(int audioFormat, boolean enabled) {
        if (isSurroundFormat(audioFormat) == true) goto L7;
        Log.w(TAG, "audioFormat to enable is not a surround format.");
        return false;
    L7:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") != 0) goto L26;
        HashSet<Integer> enabledFormats = getEnabledFormats();
        if (enabled == false) goto L11;
        enabledFormats.add(Integer.valueOf(audioFormat));
    L12:
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mSettingsLock;     // Catch: Throwable -> L22
        monitor-enter(r3);     // Catch: Throwable -> L22
        this.mSettings.putGlobalString(this.mContentResolver, "encoded_surround_output_enabled_formats", TextUtils.join(",", enabledFormats));     // Catch: Throwable -> L19
        monitor-exit(r3);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(token);
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L11:
        enabledFormats.remove(Integer.valueOf(audioFormat));
        goto L12
    L26:
        throw new SecurityException("Missing WRITE_SETTINGS permission");
    }

    public boolean setEncodedSurroundMode(int mode) {
        setEncodedSurroundMode_enforcePermission();
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mSettingsLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        this.mSettings.putGlobalInt(this.mContentResolver, "encoded_surround_output", toEncodedSurroundSetting(mode));     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return true;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public int getEncodedSurroundMode(int targetSdkVersion) {
        long token = Binder.clearCallingIdentity();
        Object r2 = this.mSettingsLock;     // Catch: Throwable -> L12
        monitor-enter(r2);     // Catch: Throwable -> L12
        int encodedSurroundSetting = this.mSettings.getGlobalInt(this.mContentResolver, "encoded_surround_output", 0);     // Catch: Throwable -> L9
        int r4 = toEncodedSurroundOutputMode(encodedSurroundSetting, targetSdkVersion);     // Catch: Throwable -> L9
        monitor-exit(r2);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return r4;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private HashSet<Integer> getEnabledFormats() {
        final HashSet<Integer> formats = new HashSet();
        String enabledFormats = this.mSettings.getGlobalString(this.mContentResolver, "encoded_surround_output_enabled_formats");
        if (enabledFormats != null) goto L9;
    L8:
        return formats;
    L9:
        Arrays.stream(TextUtils.split(enabledFormats, ",")).mapToInt(new AudioService$$ExternalSyntheticLambda29()).forEach(new AudioService$$ExternalSyntheticLambda30(formats));     // Catch: NumberFormatException -> L6
    L6:
        e = move-exception;
        Log.w(TAG, "ENCODED_SURROUND_OUTPUT_ENABLED_FORMATS misformatted.", e);
        goto L8
    }

    private int toEncodedSurroundOutputMode(int encodedSurroundSetting, int targetSdkVersion) {
        if (targetSdkVersion > 31) goto L6;
        if (encodedSurroundSetting <= 3) goto L6;
        return -1;
    L6:
        switch(encodedSurroundSetting) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L8;
            default: goto L7;
        };
    L7:
        return -1;
    L8:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    L13:
        return 0;
    }

    private int toEncodedSurroundSetting(int encodedSurroundOutputMode) {
        switch(encodedSurroundOutputMode) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    }

    private boolean isSurroundFormat(int audioFormat) {
        int[] r0 = AudioFormat.SURROUND_SOUND_ENCODING;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        int sf = r0[r3];
        if (sf == audioFormat) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void sendEnabledSurroundFormats(ContentResolver cr, boolean forceUpdate) {
        if (this.mEncodedSurroundMode == 3) goto L5;
        return;
    L5:
        String enabledSurroundFormats = this.mSettings.getGlobalString(cr, "encoded_surround_output_enabled_formats");
        if (enabledSurroundFormats != null) goto L8;
        String enabledSurroundFormats2 = "";
    L9:
        if (forceUpdate == false) goto L11;
    L13:
        this.mEnabledSurroundFormats = enabledSurroundFormats2;
        String[] surroundFormats = TextUtils.split(enabledSurroundFormats2, ",");
        ArrayList<Integer> formats = new ArrayList();
        int r5 = surroundFormats.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L27;
        String format = surroundFormats[r6];
        int audioFormat = Integer.valueOf(format).intValue();     // Catch: Exception -> L22
        if (isSurroundFormat(audioFormat) == false) goto L26;
        if (formats.contains(Integer.valueOf(audioFormat)) == true) goto L26;
        formats.add(Integer.valueOf(audioFormat));     // Catch: Exception -> L22
    L26:
        r6 = r6 + 1;
    L25:
        Log.e(TAG, "Invalid enabled surround format:" + format);
        goto L26
    L27:
        this.mSettings.putGlobalString(this.mContext.getContentResolver(), "encoded_surround_output_enabled_formats", TextUtils.join(",", formats));
        sendMsg(this.mAudioHandler, 24, 2, 0, 0, formats, 0);
        return;
    L11:
        if (TextUtils.equals(enabledSurroundFormats2, this.mEnabledSurroundFormats) == false) goto L13;
        return;
    L8:
        enabledSurroundFormats2 = enabledSurroundFormats;
        goto L9
    }

    private void onEnableSurroundFormats(ArrayList<Integer> enabledSurroundFormats) {
        int[] r0 = AudioFormat.SURROUND_SOUND_ENCODING;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int surroundFormat = r0[r2];
        boolean enabled = enabledSurroundFormats.contains(Integer.valueOf(surroundFormat));
        int ret = AudioSystem.setSurroundFormatEnabled(surroundFormat, enabled);
        Log.i(TAG, "enable surround format:" + surroundFormat + " " + enabled + " " + ret);
        r2 = r2 + 1;
        goto L3
    }

    private void updateAssistantUIdLocked(boolean forceUpdate) {
        int assistantUid = -1;
        String packageName = "";
        if (this.mRoleObserver == null) goto L6;
        packageName = this.mRoleObserver.getAssistantRoleHolder();
    L6:
        if (TextUtils.isEmpty(packageName) == false) goto L18;
        String assistantName = this.mSettings.getSecureStringForUser(this.mContentResolver, "voice_interaction_service", -2);
        if (TextUtils.isEmpty(assistantName) == false) goto L11;
        assistantName = this.mSettings.getSecureStringForUser(this.mContentResolver, "assistant", -2);
    L11:
        if (TextUtils.isEmpty(assistantName) == true) goto L18;
        ComponentName componentName = ComponentName.unflattenFromString(assistantName);
        if (componentName != null) goto L16;
        Slog.w(TAG, "Invalid service name for voice_interaction_service: " + assistantName);
        return;
    L16:
        packageName = componentName.getPackageName();
    L18:
        if (TextUtils.isEmpty(packageName) == true) goto L26;
        PackageManager pm = this.mContext.getPackageManager();
        if (pm.checkPermission("android.permission.CAPTURE_AUDIO_HOTWORD", packageName) != 0) goto L26;
        assistantUid = pm.getPackageUidAsUser(packageName, getCurrentUserId());     // Catch: PackageManager.NameNotFoundException -> L23
    L24:
        Log.e(TAG, "updateAssistantUId() could not find UID for package: " + packageName);
    L26:
        if (this.mPrimaryAssistantUid != assistantUid) goto L28;
        if (forceUpdate == true) goto L28;
        return;
    L28:
        this.mAssistantUids.remove(Integer.valueOf(this.mPrimaryAssistantUid));
        this.mPrimaryAssistantUid = assistantUid;
        addAssistantServiceUidsLocked(new int[]{this.mPrimaryAssistantUid});
    }

    private void readPersistedSettings() {
        if (this.mSystemServer.isPrivileged() == true) goto L5;
        return;
    L5:
        ContentResolver cr = this.mContentResolver;
        int r3 = 2;
        int ringerModeFromSettings = this.mSettings.getGlobalInt(cr, "mode_ringer", 2);
        int ringerMode = ringerModeFromSettings;
        if (isValidRingerMode(ringerMode) == true) goto L9;
        ringerMode = 2;
    L9:
        if (ringerMode == 1) goto L11;
    L13:
        if (ringerMode == ringerModeFromSettings) goto L16;
        this.mSettings.putGlobalInt(cr, "mode_ringer", ringerMode);
    L16:
        if (this.mUseFixedVolume == false) goto L18;
    L19:
        ringerMode = 2;
    L20:
        Object r5 = this.mSettingsLock;
        monitor-enter(r5);
        this.mRingerMode = ringerMode;     // Catch: Throwable -> L25
        if (this.mRingerModeExternal != (-1)) goto L28;
        this.mRingerModeExternal = this.mRingerMode;     // Catch: Throwable -> L25
    L28:
        if (this.mHasVibrator == false) goto L30;
        int r6 = 2;
    L31:
        this.mVibrateSetting = AudioSystem.getValueForVibrateSetting(0, 1, r6);     // Catch: Throwable -> L25
        int r7 = this.mVibrateSetting;     // Catch: Throwable -> L25
        if (this.mHasVibrator == true) goto L35;
        r3 = 0;
    L35:
        this.mVibrateSetting = AudioSystem.getValueForVibrateSetting(r7, 0, r3);     // Catch: Throwable -> L25
        updateRingerAndZenModeAffectedStreams();     // Catch: Throwable -> L25
        readDockAudioSettings(cr);     // Catch: Throwable -> L25
        sendEncodedSurroundMode(cr, "readPersistedSettings");     // Catch: Throwable -> L25
        sendEnabledSurroundFormats(cr, true);     // Catch: Throwable -> L25
        updateAssistantUIdLocked(true);     // Catch: Throwable -> L25
        resetActiveAssistantUidsLocked();     // Catch: Throwable -> L25
        monitor-exit(r5);     // Catch: Throwable -> L25
        AudioSystem.setRttEnabled(this.mRttEnabled.get());
        this.mMuteAffectedStreams = this.mSettings.getSystemIntForUser(cr, "mute_streams_affected", 111, -2);
        updateUserMutableStreams();
        updateMasterMono(cr);
        updateMasterBalance(cr);
        Object r4 = this.mSettingsLock;
        monitor-enter(r4);
        broadcastRingerMode("android.media.RINGER_MODE_CHANGED", this.mRingerModeExternal);     // Catch: Throwable -> L43
        broadcastRingerMode("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION", this.mRingerMode);     // Catch: Throwable -> L43
        monitor-exit(r4);     // Catch: Throwable -> L43
        broadcastVibrateSetting(0);
        broadcastVibrateSetting(1);
        this.mVolumeController.loadSettings(cr);
        return;
    L43:
        th = move-exception;
        throw th;
    L30:
        r6 = 0;
    L25:
        th = move-exception;
        throw th;
    L18:
        if (this.mIsSingleVolume == false) goto L20;
    L11:
        if (this.mHasVibrator == true) goto L13;
        ringerMode = 0;
        goto L13
    }

    private void updateUserMutableStreams() {
        this.mUserMutableStreams = this.mMuteAffectedStreams;
        this.mUserMutableStreams &= -2;
        this.mUserMutableStreams &= -65;
    }

    private void resetActiveAssistantUidsLocked() {
        this.mActiveAssistantServiceUids = NO_ACTIVE_ASSISTANT_SERVICE_UIDS;
        updateActiveAssistantServiceUids();
    }

    private void readUserRestrictions() {
        if (this.mSystemServer.isPrivileged() == true) goto L5;
        return;
    L5:
        int currentUser = getCurrentUserId();
        if (this.mUseFixedVolume == false) goto L9;
        AudioSystem.setMasterVolume(1.0f);
    L9:
        if (this.mUserManagerInternal.getUserRestriction(currentUser, "disallow_unmute_device") == false) goto L11;
    L14:
        boolean masterMute = true;
    L15:
        setMasterMuteInternalNoCallerCheck(masterMute, 0, currentUser, "readUserRestrictions");
        this.mMicMuteFromRestrictions = this.mUserManagerInternal.getUserRestriction(currentUser, "no_unmute_microphone");
        Log.d(TAG, String.format("Mic mute %b, user=%d", new Object[]{Boolean.valueOf(this.mMicMuteFromRestrictions), Integer.valueOf(currentUser)}));
        setMicrophoneMuteNoCallerCheck(currentUser);
        return;
    L11:
        if (this.mUserManagerInternal.getUserRestriction(currentUser, "no_adjust_volume") == true) goto L14;
        masterMute = false;
        goto L15
    }

    private int getIndexRange(int streamType) {
        return getVssForStreamOrDefault(streamType).getMaxIndex() - getVssForStreamOrDefault(streamType).getMinIndex();
    }

    private int rescaleIndex(VolumeInfo volumeInfo, int dstStream) {
        if (volumeInfo.getVolumeIndex() == (-100)) goto L13;
        if (volumeInfo.getMinVolumeIndex() == (-100)) goto L13;
        if (volumeInfo.getMaxVolumeIndex() == (-100)) goto L13;
        return rescaleIndex(volumeInfo.getVolumeIndex(), volumeInfo.getMinVolumeIndex(), volumeInfo.getMaxVolumeIndex(), getVssForStreamOrDefault(dstStream).getMinIndex(), getVssForStreamOrDefault(dstStream).getMaxIndex());
    L13:
        Log.e(TAG, "rescaleIndex: volumeInfo has invalid index or range");
        return getVssForStreamOrDefault(dstStream).getMinIndex();
    }

    private int rescaleIndex(int index, int srcStream, VolumeInfo dstVolumeInfo) {
        int dstMin = dstVolumeInfo.getMinVolumeIndex();
        int dstMax = dstVolumeInfo.getMaxVolumeIndex();
        if (dstMin == (-100)) goto L9;
        if (dstMax != (-100)) goto L7;
        return index;
    L7:
        return rescaleIndex(index, getVssForStreamOrDefault(srcStream).getMinIndex(), getVssForStreamOrDefault(srcStream).getMaxIndex(), dstMin, dstMax);
    L9:
        return index;
    }

    private int rescaleIndex(int index, int srcStream, int dstStream) {
        VolumeStreamState srcVss = getVssForStreamOrDefault(srcStream);
        VolumeStreamState dstVss = getVssForStreamOrDefault(dstStream);
        int newIndex = rescaleIndex(index, srcVss.getMinIndex(), srcVss.getMaxIndex(), dstVss.getMinIndex(), dstVss.getMaxIndex());
        if (dstStream != 8) goto L11;
        if (srcStream == 0) goto L6;
        return newIndex;
    L6:
        if (srcVss.getMinIndex() <= dstVss.getMinIndex()) goto L13;
        int newIndex2 = newIndex + (srcVss.getMinIndex() - dstVss.getMinIndex());
        if (newIndex2 > dstVss.getMaxIndex()) goto L10;
        return newIndex2;
    L10:
        return dstVss.getMaxIndex();
    L13:
        return newIndex;
    L11:
        return newIndex;
    }

    private int rescaleIndex(int index, int srcMin, int srcMax, int dstMin, int dstMax) {
        int srcRange = srcMax - srcMin;
        int dstRange = dstMax - dstMin;
        if (srcRange != 0) goto L7;
        Log.e(TAG, "rescaleIndex : index range should not be zero");
        return dstMin;
    L7:
        return ((((index - srcMin) * dstRange) + (srcRange / 2)) / srcRange) + dstMin;
    }

    private int rescaleStep(int step, int srcStream, int dstStream) {
        int srcRange = getIndexRange(srcStream);
        int dstRange = getIndexRange(dstStream);
        if (srcRange != 0) goto L7;
        Log.e(TAG, "rescaleStep : index range should not be zero");
        return 0;
    L7:
        return ((step * dstRange) + (srcRange / 2)) / srcRange;
    }

    public int setPreferredDevicesForStrategy(int strategy, List<AudioDeviceAttributes> devices) {
        super.setPreferredDevicesForStrategy_enforcePermission();
        if (devices != null) goto L5;
        return -1;
    L5:
        List<AudioDeviceAttributes> devices2 = retrieveBluetoothAddresses(devices);
        String logString = String.format("setPreferredDevicesForStrategy u/pid:%d/%d strat:%d dev:%s", new Object[]{Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()), Integer.valueOf(strategy), devices2.stream().map(new AudioService$$ExternalSyntheticLambda16()).collect(Collectors.joining(","))});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        if (devices2.stream().anyMatch(new AudioService$$ExternalSyntheticLambda17()) == false) goto L9;
        Log.e(TAG, "Unsupported input routing in " + logString);
        return -1;
    L9:
        int status = this.mDeviceBroker.setPreferredDevicesForStrategySync(strategy, devices2);
        if (status == 0) goto L12;
        Log.e(TAG, String.format("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));
    L12:
        return status;
    }

    private static /* synthetic */ String lambda$setPreferredDevicesForStrategy$10(AudioDeviceAttributes e) {
        return e.toString();
    }

    private static /* synthetic */ boolean lambda$setPreferredDevicesForStrategy$11(AudioDeviceAttributes device) {
        if (device.getRole() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int removePreferredDevicesForStrategy(int strategy) {
        super.removePreferredDevicesForStrategy_enforcePermission();
        String logString = String.format("removePreferredDevicesForStrategy strat:%d", new Object[]{Integer.valueOf(strategy)});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        int status = this.mDeviceBroker.removePreferredDevicesForStrategySync(strategy);
        if (status != 0) goto L5;
    L7:
        return status;
    L5:
        if (status == (-2)) goto L7;
        Log.e(TAG, String.format("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));
        goto L7
    }

    public List<AudioDeviceAttributes> getPreferredDevicesForStrategy(int strategy) {
        super.getPreferredDevicesForStrategy_enforcePermission();
        List<AudioDeviceAttributes> devices = new ArrayList();
        long identity = Binder.clearCallingIdentity();
        int status = AudioSystem.getDevicesForRoleAndStrategy(strategy, 1, devices);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        if (status == 0) goto L9;
        Log.e(TAG, String.format("Error %d in getPreferredDeviceForStrategy(%d)", new Object[]{Integer.valueOf(status), Integer.valueOf(strategy)}));
        return new ArrayList();
    L9:
        return anonymizeAudioDeviceAttributesList(devices);
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int setDeviceAsNonDefaultForStrategy(int strategy, AudioDeviceAttributes device) {
        super.setDeviceAsNonDefaultForStrategy_enforcePermission();
        device.getClass();
        AudioDeviceAttributes device2 = retrieveBluetoothAddress(device);
        String logString = String.format("setDeviceAsNonDefaultForStrategy u/pid:%d/%d strat:%d dev:%s", new Object[]{Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()), Integer.valueOf(strategy), device2.toString()});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        if (device2.getRole() != 1) goto L6;
        Log.e(TAG, "Unsupported input routing in " + logString);
        return -1;
    L6:
        int status = this.mDeviceBroker.setDeviceAsNonDefaultForStrategySync(strategy, device2);
        if (status == 0) goto L9;
        Log.e(TAG, String.format("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));
    L9:
        return status;
    }

    public int removeDeviceAsNonDefaultForStrategy(int strategy, AudioDeviceAttributes device) {
        super.removeDeviceAsNonDefaultForStrategy_enforcePermission();
        device.getClass();
        AudioDeviceAttributes device2 = retrieveBluetoothAddress(device);
        String logString = String.format("removeDeviceAsNonDefaultForStrategy strat:%d dev:%s", new Object[]{Integer.valueOf(strategy), device2.toString()});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        if (device2.getRole() != 1) goto L6;
        Log.e(TAG, "Unsupported input routing in " + logString);
        return -1;
    L6:
        int status = this.mDeviceBroker.removeDeviceAsNonDefaultForStrategySync(strategy, device2);
        if (status != 0) goto L9;
    L11:
        return status;
    L9:
        if (status == (-2)) goto L11;
        Log.e(TAG, String.format("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));
        goto L11
    }

    public List<AudioDeviceAttributes> getNonDefaultDevicesForStrategy(int strategy) {
        super.getNonDefaultDevicesForStrategy_enforcePermission();
        List<AudioDeviceAttributes> devices = new ArrayList();
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        int status = AudioSystem.getDevicesForRoleAndStrategy(strategy, 2, devices);     // Catch: Throwable -> L11
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        if (status == 0) goto L10;
        Log.e(TAG, String.format("Error %d in getNonDefaultDeviceForStrategy(%d)", new Object[]{Integer.valueOf(status), Integer.valueOf(strategy)}));
        return new ArrayList();
    L10:
        return anonymizeAudioDeviceAttributesList(devices);
    L11:
        th = move-exception;
        if (ignored != null) goto L18;
    L17:
        throw th;
    L18:
        ignored.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public void registerStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.registerStrategyPreferredDevicesDispatcher(dispatcher, isBluetoothPrividged());
    }

    public void unregisterStrategyPreferredDevicesDispatcher(IStrategyPreferredDevicesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.unregisterStrategyPreferredDevicesDispatcher(dispatcher);
    }

    public void registerStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.registerStrategyNonDefaultDevicesDispatcher(dispatcher, isBluetoothPrividged());
    }

    public void unregisterStrategyNonDefaultDevicesDispatcher(IStrategyNonDefaultDevicesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.unregisterStrategyNonDefaultDevicesDispatcher(dispatcher);
    }

    public int setPreferredDevicesForCapturePreset(int capturePreset, List<AudioDeviceAttributes> devices) {
        if (devices != null) goto L5;
        return -1;
    L5:
        enforceModifyAudioRoutingPermission();
        String logString = String.format("setPreferredDevicesForCapturePreset u/pid:%d/%d source:%d dev:%s", new Object[]{Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()), Integer.valueOf(capturePreset), devices.stream().map(new AudioService$$ExternalSyntheticLambda9()).collect(Collectors.joining(","))});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        if (devices.stream().anyMatch(new AudioService$$ExternalSyntheticLambda10()) == false) goto L9;
        Log.e(TAG, "Unsupported output routing in " + logString);
        return -1;
    L9:
        int status = this.mDeviceBroker.setPreferredDevicesForCapturePresetSync(capturePreset, retrieveBluetoothAddresses(devices));
        if (status == 0) goto L12;
        Log.e(TAG, String.format("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));
    L12:
        return status;
    }

    private static /* synthetic */ String lambda$setPreferredDevicesForCapturePreset$12(AudioDeviceAttributes e) {
        return e.toString();
    }

    private static /* synthetic */ boolean lambda$setPreferredDevicesForCapturePreset$13(AudioDeviceAttributes device) {
        if (device.getRole() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public int clearPreferredDevicesForCapturePreset(int capturePreset) {
        super.clearPreferredDevicesForCapturePreset_enforcePermission();
        String logString = String.format("removePreferredDeviceForCapturePreset source:%d", new Object[]{Integer.valueOf(capturePreset)});
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));
        int status = this.mDeviceBroker.clearPreferredDevicesForCapturePresetSync(capturePreset);
        if (status != 0) goto L5;
    L7:
        return status;
    L5:
        if (status == (-2)) goto L7;
        Log.e(TAG, String.format("Error %d in %s", new Object[]{Integer.valueOf(status), logString}));
        goto L7
    }

    public List<AudioDeviceAttributes> getPreferredDevicesForCapturePreset(int capturePreset) {
        super.getPreferredDevicesForCapturePreset_enforcePermission();
        List<AudioDeviceAttributes> devices = new ArrayList();
        long identity = Binder.clearCallingIdentity();
        int status = AudioSystem.getDevicesForRoleAndCapturePreset(capturePreset, 1, devices);     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        if (status == 0) goto L9;
        Log.e(TAG, String.format("Error %d in getPreferredDeviceForCapturePreset(%d)", new Object[]{Integer.valueOf(status), Integer.valueOf(capturePreset)}));
        return new ArrayList();
    L9:
        return anonymizeAudioDeviceAttributesList(devices);
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void registerCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.registerCapturePresetDevicesRoleDispatcher(dispatcher, isBluetoothPrividged());
    }

    public void unregisterCapturePresetDevicesRoleDispatcher(ICapturePresetDevicesRoleDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        enforceModifyAudioRoutingPermission();
        this.mDeviceBroker.unregisterCapturePresetDevicesRoleDispatcher(dispatcher);
    }

    public ArrayList<AudioDeviceAttributes> getDevicesForAttributes(AudioAttributes attributes) {
        enforceQueryStateOrModifyRoutingPermission();
        return new ArrayList(anonymizeAudioDeviceAttributesList(getDevicesForAttributesInt(attributes, false)));
    }

    public ArrayList<AudioDeviceAttributes> getDevicesForAttributesUnprotected(AudioAttributes attributes) {
        return new ArrayList(anonymizeAudioDeviceAttributesList(getDevicesForAttributesInt(attributes, false)));
    }

    public boolean isMusicActive(boolean remotely) {
        long token = Binder.clearCallingIdentity();
        if (remotely == false) goto L9;
        boolean r2 = AudioSystem.isStreamActiveRemotely(3, 0);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
        return r2;
    L9:
        boolean r3 = AudioSystem.isStreamActive(3, 0);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(token);
        return r3;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    protected ArrayList<AudioDeviceAttributes> getDevicesForAttributesInt(AudioAttributes attributes, boolean forVolume) {
        attributes.getClass();
        return this.mAudioSystem.getDevicesForAttributes(attributes, forVolume);
    }

    public void addOnDevicesForAttributesChangedListener(AudioAttributes attributes, IDevicesForAttributesCallback callback) {
        super.addOnDevicesForAttributesChangedListener_enforcePermission();
        this.mAudioSystem.addOnDevicesForAttributesChangedListener(attributes, false, callback);
    }

    public void removeOnDevicesForAttributesChangedListener(IDevicesForAttributesCallback callback) {
        this.mAudioSystem.removeOnDevicesForAttributesChangedListener(callback);
    }

    public void handleVolumeKey(KeyEvent event, boolean isOnTv, String callingPackage, String caller) {
        if (isOnTv == false) goto L9;
        if (event.getAction() != 0) goto L7;
        int keyEventMode = 1;
    L13:
        switch(event.getKeyCode()) {
            case 24: goto L22;
            case 25: goto L21;
            case 164: goto L17;
            default: goto L14;
        };
    L14:
        Log.e(TAG, "Invalid key code " + event.getKeyCode() + " sent by " + callingPackage);
        return;
    L21:
        adjustSuggestedStreamVolume(-1, Integer.MIN_VALUE, 4101, callingPackage, caller, Binder.getCallingUid(), Binder.getCallingPid(), true, keyEventMode);
        return;
    L22:
        adjustSuggestedStreamVolume(1, Integer.MIN_VALUE, 4101, callingPackage, caller, Binder.getCallingUid(), Binder.getCallingPid(), true, keyEventMode);
        return;
    L17:
        if (event.getAction() == 0) goto L19;
        return;
    L19:
        if (event.getRepeatCount() != 0) goto L25;
        adjustSuggestedStreamVolume(101, Integer.MIN_VALUE, 4101, callingPackage, caller, Binder.getCallingUid(), Binder.getCallingPid(), true, 0);
        return;
    L25:
        return;
    L7:
        keyEventMode = 2;
        goto L13
    L9:
        if (event.getAction() == 0) goto L11;
        return;
    L11:
        keyEventMode = 0;
        goto L13
    }

    public void setNavigationRepeatSoundEffectsEnabled(boolean enabled) {
        this.mNavigationRepeatSoundEffectsEnabled = enabled;
    }

    public boolean areNavigationRepeatSoundEffectsEnabled() {
        return this.mNavigationRepeatSoundEffectsEnabled;
    }

    public void setHomeSoundEffectEnabled(boolean enabled) {
        this.mHomeSoundEffectEnabled = enabled;
    }

    public boolean isHomeSoundEffectEnabled() {
        return this.mHomeSoundEffectEnabled;
    }

    private void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags, String callingPackage, String caller, int uid, int pid, boolean hasModifyAudioSettings, int keyEventMode) {
        int flags2 = flags;
        Object r2 = this.mForceControlStreamLock;
        monitor-enter(r2);
        Log.d(TAG, "adjustSuggestedStreamVolume() stream=" + suggestedStreamType + ", flags=" + flags2 + ", caller=" + caller + ", volControlStream=" + this.mVolumeControlStream + ", userSelect=" + this.mUserSelectedVolumeControlStream);     // Catch: Throwable -> L60
        monitor-exit(r2);     // Catch: Throwable -> L60
        if (direction == 0) goto L8;
        EventLogger r0 = sVolumeLogger;
        StringBuilder r3 = new StringBuilder(callingPackage);
        r3.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r3.append(caller);
        r3.append(" uid:");
        int r10 = uid;
        r3.append(r10);
        int r5 = direction;
        r0.enqueue(new AudioServiceEvents.VolumeEvent(0, suggestedStreamType, r5, flags2, r3.toString()));
    L9:
        boolean hasExternalVolumeController = notifyExternalVolumeController(direction);
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.service.adjustSuggestedStreamVolume").setUid(Binder.getCallingUid()).set(MediaMetrics.Property.CALLING_PACKAGE, callingPackage).set(MediaMetrics.Property.CLIENT_NAME, caller).set(MediaMetrics.Property.DIRECTION, this.mASExt.getMediaMetricsValueByDirection(r5));
        MediaMetrics.Key r4 = MediaMetrics.Property.EXTERNAL;
        if (hasExternalVolumeController == false) goto L12;
        String r6 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L13:
        MediaMetrics.Item r7 = r1.set(r4, r6).set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags2)).set(MediaMetrics.Property.EVENT, "adjustSuggestedStreamVolume").set(MediaMetrics.Property.ORIGINAL_STREAM_TYPE, AudioSystem.streamToString(r4)).set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags2)).set(MediaMetrics.Property.VOLUME_CONTROL_STREAM, AudioSystem.streamToString(this.mVolumeControlStream));
        MediaMetrics.Key r8 = MediaMetrics.Property.USER_SELECTED_VOLUME_CONTROL_STREAM;
        if (this.mUserSelectedVolumeControlStream == false) goto L16;
        String r9 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L17:
        MediaMetrics.Item mmi = r7.set(r8, r9);
        mMmi.set(mmi);
        if (hasExternalVolumeController == false) goto L21;
        mmi.record();
        return;
    L21:
        Object r11 = this.mForceControlStreamLock;
        monitor-enter(r11);
        Log.d(TAG, "adjustSuggestedStreamVolume() stream=" + r4 + ", flags=" + flags2 + ", caller=" + caller + ", volControlStream=" + this.mVolumeControlStream + ", userSelect=" + this.mUserSelectedVolumeControlStream);     // Catch: Throwable -> L26
        if (this.mUserSelectedVolumeControlStream == false) goto L28;
        int maybeActiveStreamType = this.mVolumeControlStream;     // Catch: Throwable -> L26
    L41:
        monitor-exit(r11);     // Catch: Throwable -> L26
        boolean isMute = isMuteAdjust(direction);
        int streamType = replaceBtScoStreamWithVoiceCall(maybeActiveStreamType, "adjustSuggestedStreamVolume");
        ensureValidStreamType(streamType);
        int resolvedStream = sStreamVolumeAlias.get(streamType, -1);
        if (resolvedStream != (-1)) goto L46;
        Log.e(TAG, "adjustSuggestedStreamVolume: no stream vol alias for stream type " + streamType);
        return;
    L46:
        mmi.set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(resolvedStream));
        if ((flags2 & 4) == 0) goto L51;
        if (resolvedStream == 2) goto L51;
        flags2 = flags2 & (-5);
    L51:
        if (this.mVolumeController.suppressAdjustment(resolvedStream, flags2, isMute) == true) goto L53;
    L55:
        int direction2 = r5;
        int flags3 = flags2;
    L56:
        adjustStreamVolume(streamType, direction2, flags3, callingPackage, caller, r10, pid, null, hasModifyAudioSettings, keyEventMode);
        return;
    L53:
        if (this.mIsSingleVolume == true) goto L55;
        direction2 = 0;
        Log.d(TAG, "Volume controller suppressed adjustment");
        flags3 = (flags2 & (-5)) & (-17);
        goto L56
    L28:
        maybeActiveStreamType = getActiveStreamType(suggestedStreamType);     // Catch: Throwable -> L26
        if (maybeActiveStreamType == 2) goto L34;
        if (maybeActiveStreamType == 5) goto L34;
        boolean activeForReal = this.mAudioSystem.isStreamActive(maybeActiveStreamType, 0);     // Catch: Throwable -> L26
    L35:
        if (activeForReal == true) goto L41;
        if (this.mVolumeControlStream == (-1)) goto L41;
        maybeActiveStreamType = this.mVolumeControlStream;     // Catch: Throwable -> L26
    L34:
        activeForReal = wasStreamActiveRecently(maybeActiveStreamType, 0);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L16:
        r9 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        goto L17
    L12:
        r6 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
        goto L13
    L8:
        r5 = direction;
        r10 = uid;
    L60:
        th = th;
    L66:
        throw th;
    L64:
        th = th;
        goto L66
    }

    private boolean notifyExternalVolumeController(int direction) {
        Object r1 = this.mExtVolumeControllerLock;
        monitor-enter(r1);
        IAudioPolicyCallback externalVolumeController = this.mExtVolumeController;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (externalVolumeController != null) goto L9;
        return false;
    L9:
        sendMsg(this.mAudioHandler, 22, 2, direction, 0, externalVolumeController, 0);
        return true;
    L11:
        th = th;
    L19:
        throw th;
    L15:
        th = th;
        goto L19
    }

    public void adjustStreamVolume(int streamType, int direction, int flags, String callingPackage) {
        adjustStreamVolumeWithAttribution(streamType, direction, flags, callingPackage, null);
    }

    public void adjustStreamVolumeWithAttribution(int streamType, int direction, int flags, String callingPackage, String attributionTag) {
        if (this.mHardeningEnforcer.blockVolumeMethod(103, callingPackage, Binder.getCallingUid()) == false) goto L6;
        return;
    L6:
        if (streamType == 10) goto L8;
    L11:
        AudioServiceEvents.VolumeEvent evt = new AudioServiceEvents.VolumeEvent(1, streamType, direction, flags, callingPackage);
        sVolumeLogger.enqueue(evt);
        if (isMuteAdjust(direction) == false) goto L14;
        sMuteLogger.enqueue(evt);
    L14:
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.service.adjustStreamVolumeWithAttribution").setUid(Binder.getCallingUid()).set(MediaMetrics.Property.EVENT, "adjustStreamVolumeWithAttribution").set(MediaMetrics.Property.CALLING_PACKAGE, callingPackage).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(streamType)).set(MediaMetrics.Property.DIRECTION, this.mASExt.getMediaMetricsValueByDirection(direction)).set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags));
        mMmi.set(mmi);
        adjustStreamVolume(streamType, direction, flags, callingPackage, callingPackage, Binder.getCallingUid(), Binder.getCallingPid(), attributionTag, callingHasAudioSettingsPermission(), 0);
        return;
    L8:
        if (canChangeAccessibilityVolume() == true) goto L11;
        Log.w(TAG, "Trying to call adjustStreamVolume() for a11y withoutCHANGE_ACCESSIBILITY_VOLUME / callingPackage=" + callingPackage);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    protected void adjustStreamVolume(int streamType, int direction, int flags, String callingPackage, String caller, int uid, int pid, String attributionTag, boolean hasModifyAudioSettings, int streamTypeAlias) {
        int uid2 = uid;
        Log.d(TAG, "adjustStreamVolume() stream=" + streamType + ", dir=" + direction + ", flags=" + flags + ", caller=" + caller);
        if (this.mUseFixedVolume == false) goto L5;
        return;
    L5:
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "adjustStreamVolume");
        ensureValidDirection(direction);
        ensureValidStreamType(streamType2);
        boolean isMuteAdjust = isMuteAdjust(direction);
        if (isMuteAdjust == true) goto L8;
    L11:
        if (isMuteAdjust == false) goto L20;
        if (streamType2 == 0) goto L16;
        if (isStreamBluetoothSco(streamType2) == false) goto L20;
    L16:
        if (this.mContext.checkPermission("android.permission.MODIFY_PHONE_STATE", pid, uid2) == 0) goto L20;
        Log.w(TAG, "MODIFY_PHONE_STATE Permission Denial: adjustStreamVolume from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
        return;
    L20:
        if (streamType2 == 11) goto L22;
    L25:
        int streamTypeAlias2 = sStreamVolumeAlias.get(streamType2, -1);
        if (streamTypeAlias2 != (-1)) goto L28;
        Log.e(TAG, "adjustStreamVolume: no stream vol alias for stream type " + streamType2);
    L28:
        VolumeStreamState streamState = getVssForStreamOrDefault(streamTypeAlias2);
        int device = getDeviceForStream(streamTypeAlias2);
        int aliasIndex = streamState.getIndex(device);
        boolean adjustVolume = true;
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == true) goto L36;
        if (AudioSystem.DEVICE_OUT_ALL_BLE_SET.contains(Integer.valueOf(device)) == true) goto L36;
        if ((flags & 64) == 0) goto L36;
        return;
    L36:
        if (uid2 != 1000) goto L39;
        uid2 = UserHandle.getUid(getCurrentUserId(), UserHandle.getAppId(uid2));
    L39:
        if (checkNoteAppOp(STREAM_VOLUME_OPS[streamTypeAlias2], uid2, callingPackage, attributionTag) == true) goto L41;
        return;
    L41:
        this.mSoundDoseHelper.invalidatePendingVolumeCommand();
        int flags2 = flags & (-33);
        if (streamTypeAlias2 == 3) goto L44;
    L51:
        int step = rescaleStep((int) (10.0f * streamState.getIndexStepFactor()), streamType2, streamTypeAlias2);
        int flags3 = aliasIndex;
        int aliasIndex2 = flags2;
    L53:
        if ((aliasIndex2 & 2) == 0) goto L55;
    L69:
        int ringerMode = getRingerModeInternal();
        int flags4 = aliasIndex2;
        if (ringerMode != 1) goto L72;
        int flags5 = flags4 & (-17);
    L73:
        int flags6 = flags5;
        int result = checkForRingerModeChange(flags3, direction, step, VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState), callingPackage, flags6);
        int aliasIndex3 = flags3;
        int step2 = step;
        if ((result & 1) == 0) goto L76;
        boolean r2 = true;
    L77:
        adjustVolume = r2;
        if ((result & 128) == 0) goto L81;
        flags6 = flags6 | 128;
    L81:
        if ((result & 2048) == 0) goto L85;
        flags6 = flags6 | 2048;
    L85:
        if (volumeAdjustmentAllowedByDnd(streamTypeAlias2, flags6) == true) goto L87;
        boolean adjustVolume2 = false;
    L88:
        int oldIndex = getVssForStreamOrDefault(streamType2).getIndex(device);
        if (isAbsoluteVolumeDevice(device) == true) goto L91;
    L97:
        int oldIndex2 = oldIndex;
    L98:
        if (adjustVolume2 == false) goto L173;
        if (direction == 0) goto L173;
        if (streamTypeAlias == 2) goto L173;
        this.mAudioHandler.removeMessages(18);
        if (isMuteAdjust == false) goto L115;
        if (this.mFullVolumeDevices.contains(Integer.valueOf(device)) == true) goto L115;
        if (direction != 101(0x65, float:1.42E-43)) goto L110;
        boolean state = !VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState);
    L113:
        muteAliasStreams(streamTypeAlias2, state);
        int streamType3 = streamType2;
        oldIndex2 = oldIndex2;
        int flags7 = flags6;
        int flags8 = streamTypeAlias2;
        int device2 = device;
        streamTypeAlias = streamTypeAlias;
    L142:
        int streamType4 = streamType3;
        int newIndex = getVssForStreamOrDefault(streamType4).getIndex(device2);
        if (flags8 != getBluetoothContextualVolumeStream()) goto L150;
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device2)) == false) goto L150;
        if ((flags7 & 64) != 0) goto L150;
        Log.d(TAG, "adjustStreamVolume: postSetAvrcpAbsoluteVolumeIndex index=" + newIndex + "stream=" + streamType4);
        this.mDeviceBroker.postSetAvrcpAbsoluteVolumeIndex(newIndex / 10);
    L155:
        if (AudioSystem.isLeAudioDeviceType(device2) == false) goto L162;
        if (streamType4 != getBluetoothContextualVolumeStream()) goto L162;
        if ((flags7 & 64) != 0) goto L162;
        Log.d(TAG, "adjustStreamVolume postSetLeAudioVolumeIndex index=" + newIndex + " stream=" + streamType4);
        this.mDeviceBroker.postSetLeAudioVolumeIndex(newIndex, getVssForStreamOrDefault(streamType4).getMaxIndex(), streamType4);
    L162:
        if (device2 == 134217728) goto L164;
    L174:
        int newIndex2 = getVssForStreamOrDefault(streamType4).getIndex(device2);
        if (adjustVolume2 == false) goto L261;
        Object r1 = this.mHdmiClientLock;
        monitor-enter(r1);
    L251:
        th = th;
    L259:
        monitor-exit(r1);     // Catch: Throwable -> L251
        throw th;
    L254:
        th = th;
        goto L259
    L179:
        if (this.mHdmiManager == null) goto L256;
        HdmiClient hdmiClient = this.mHdmiPlaybackClient;     // Catch: Throwable -> L254
        if (this.mHdmiTvClient != null) goto L274;
        HdmiClient hdmiClient2 = hdmiClient;
    L188:
        if (this.mHdmiPlaybackClient != null) goto L190;
    L192:
        boolean r0 = false;
    L193:
        boolean playbackDeviceConditions = r0;
        if (this.mHdmiTvClient != null) goto L197;
    L203:
        boolean r3 = false;
    L204:
        boolean tvConditions = r3;
        if (playbackDeviceConditions == true) goto L209;
        if (tvConditions == true) goto L209;
        streamType4 = streamType4;
        flags7 = flags7;
        device2 = device2;
    L246:
        if (flags8 != 3) goto L253;
        int oldIndex3 = oldIndex2;
        if (oldIndex3 != newIndex2) goto L250;
        if (isMuteAdjust == true) goto L250;
    L257:
        monitor-exit(r1);     // Catch: Throwable -> L251
    L262:
        int oldIndex4 = oldIndex3;
        int device3 = device2;
        sendVolumeUpdate(streamType4, oldIndex4, newIndex2, flags7, device3);
        MediaMetrics.Item mmi = mMmi.get();
        if (mmi != null) goto L265;
        Log.w(TAG, "adjustStreamVolume MediaMetrics.Item is null");
        return;
    L265:
        mmi.set(MediaMetrics.Property.OLD_INDEX, Integer.valueOf((oldIndex4 + 5) / 10)).set(MediaMetrics.Property.NEW_INDEX, Integer.valueOf((newIndex2 + 5) / 10)).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(device3));
        if (adjustVolume2 == false) goto L282;
        mmi.record();
        return;
    L282:
        return;
    L250:
        maybeSendSystemAudioStatusCommand(isMuteAdjust);     // Catch: Throwable -> L251
        goto L257
    L253:
        oldIndex3 = oldIndex2;
    L209:
        if (this.mHdmiCecVolumeControlEnabled == true) goto L212;
    L244:
        streamType4 = streamType4;
        flags7 = flags7;
        device2 = device2;
        goto L246
    L212:
        if (flags8 != 3) goto L244;
        switch(direction) {
            case -100: goto L218;
            case -1: goto L217;
            case 1: goto L216;
            case 100: goto L218;
            case 101: goto L218;
            default: goto L215;
        };
    L215:
        int streamType5 = 0;
    L219:
        if (streamType5 != 0) goto L271;
        flags7 = flags7;
        device2 = device2;
        goto L246
    L271:
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L241
        switch(streamTypeAlias) {
            case 0: goto L235;
            case 1: goto L234;
            case 2: goto L233;
            default: goto L279;
        };
    L233:
        hdmiClient2.sendVolumeKeyEvent(streamType5, false);     // Catch: Throwable -> L227
    L236:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L237
        goto L246
    L234:
        hdmiClient2.sendVolumeKeyEvent(streamType5, true);     // Catch: Throwable -> L227
        goto L236
    L235:
        hdmiClient2.sendVolumeKeyEvent(streamType5, true);     // Catch: Throwable -> L227
        hdmiClient2.sendVolumeKeyEvent(streamType5, false);     // Catch: Throwable -> L227
        goto L236
    L279:
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L229
        r5.append("Invalid keyEventMode ");     // Catch: Throwable -> L227
        r5.append(streamTypeAlias);     // Catch: Throwable -> L227
        Log.e(TAG, r5.toString());     // Catch: Throwable -> L227
    L229:
        th = th;
    L239:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L237
        throw th;     // Catch: Throwable -> L237
    L237:
        th = th;
    L227:
        th = th;
    L241:
        th = th;
        goto L259
    L216:
        streamType5 = 24;
        goto L219
    L217:
        streamType5 = 25;
        goto L219
    L218:
        streamType5 = 164;
        goto L219
    L197:
        if (this.mHdmiSystemAudioSupported == false) goto L203;
        if (isAbsoluteVolumeDevice(device2) == true) goto L203;
        if (isA2dpAbsoluteVolumeDevice(device2) == true) goto L203;
        r3 = true;
    L184:
        th = th;
        goto L259
    L190:
        if (isFullVolumeDevice(device2) == false) goto L192;
        r0 = true;
        goto L193
    L274:
        hdmiClient2 = this.mHdmiTvClient;     // Catch: Throwable -> L184
        goto L188
    L256:
        streamType4 = streamType4;
        flags7 = flags7;
        device2 = device2;
        oldIndex3 = oldIndex2;
        goto L257
    L261:
        streamType4 = streamType4;
        flags7 = flags7;
        device2 = device2;
        oldIndex3 = oldIndex2;
        goto L262
    L164:
        if (streamType4 != getBluetoothContextualVolumeStream()) goto L174;
        Log.d(TAG, "adjustStreamVolume postSetHearingAidVolumeIndex index=" + newIndex + " stream=" + streamType4);
        VolumeStreamState vss = getVssForStreamOrDefault(streamType4);
        Object r4 = this.mVolumeStateLock;
        monitor-enter(r4);
        int haIndex = (int) (vss.getMinIndex() + ((newIndex - vss.getMinIndex()) / vss.getIndexStepFactor()));     // Catch: Throwable -> L170
        monitor-exit(r4);     // Catch: Throwable -> L170
        this.mDeviceBroker.postSetHearingAidVolumeIndex(haIndex, streamType4);
    L170:
        th = move-exception;
        throw th;
    L150:
        if (isAbsoluteVolumeDevice(device2) == false) goto L155;
        if ((flags7 & 8192) != 0) goto L155;
        dispatchAbsoluteVolumeChanged(streamType4, getAbsoluteVolumeDeviceInfo(device2), newIndex);
        goto L155
    L110:
        if (direction != (-100)) goto L112;
        state = true;
        goto L113
    L112:
        state = false;
    L115:
        if (direction != 1) goto L120;
        if (this.mSoundDoseHelper.raiseVolumeDisplaySafeMediaVolume(streamTypeAlias2, aliasIndex3 + step2, device, flags6) == false) goto L120;
        Log.e(TAG, "adjustStreamVolume() safe volume index = " + oldIndex2);
        streamType3 = streamType2;
        oldIndex2 = oldIndex2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        device2 = device;
        streamTypeAlias = streamTypeAlias;
    L120:
        if (isFullVolumeDevice(device) == false) goto L122;
        streamType3 = streamType2;
        oldIndex2 = oldIndex2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        device2 = device;
        streamTypeAlias = streamTypeAlias;
        goto L142
    L122:
        if (streamState.adjustIndex(direction * step2, device, caller, hasModifyAudioSettings) == true) goto L128;
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState) == true) goto L128;
        streamType3 = streamType2;
        oldIndex2 = oldIndex2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        device2 = device;
        streamTypeAlias = streamTypeAlias;
    L128:
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState) == true) goto L130;
        streamType3 = streamType2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
    L140:
        device2 = device;
        sendMsg(this.mAudioHandler, 0, 2, device2, 0, streamState, 0);
        goto L142
    L130:
        if (direction != 1) goto L133;
        muteAliasStreams(streamTypeAlias2, false);
        streamType3 = streamType2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        goto L140
    L133:
        if (direction == (-1)) goto L135;
        streamType3 = streamType2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        goto L140
    L135:
        if (this.mIsSingleVolume == false) goto L137;
        flags7 = flags6;
        streamType3 = streamType2;
        sendMsg(this.mAudioHandler, 18, 2, streamTypeAlias2, flags7, null, 350);
        flags8 = streamTypeAlias2;
        goto L140
    L137:
        streamType3 = streamType2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
    L173:
        oldIndex2 = oldIndex2;
        flags7 = flags6;
        flags8 = streamTypeAlias2;
        device2 = device;
        streamTypeAlias = streamTypeAlias;
        streamType4 = streamType2;
        goto L174
    L91:
        if ((flags6 & 8192) != 0) goto L97;
        oldIndex2 = oldIndex;
        AbsoluteVolumeDeviceInfo info = getAbsoluteVolumeDeviceInfo(device);
        if (AbsoluteVolumeDeviceInfo.m2115$$Nest$fgetmHandlesVolumeAdjustment(info) == false) goto L98;
        dispatchAbsoluteVolumeAdjusted(streamType2, info, oldIndex2, direction, streamTypeAlias);
        return;
    L87:
        adjustVolume2 = adjustVolume;
        goto L88
    L76:
        r2 = false;
        goto L77
    L72:
        flags5 = flags4;
        goto L73
    L55:
        if (isUiSoundsStreamType(streamTypeAlias2) == true) goto L69;
        if (isStreamMutedByRingerOrZenMode(streamTypeAlias2) == true) goto L60;
    L68:
        flags6 = aliasIndex2;
        aliasIndex3 = flags3;
        step2 = step;
        goto L85
    L60:
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState) == false) goto L68;
        if (direction != 101) goto L64;
    L67:
        adjustVolume = false;
        flags6 = aliasIndex2;
        aliasIndex3 = flags3;
        step2 = step;
        goto L85
    L64:
        if (direction == 100) goto L67;
        if (direction != 1) goto L68;
    L44:
        if (isFixedVolumeDevice(device) == false) goto L51;
        int flags9 = flags2 | 32;
        step = this.mSoundDoseHelper.getSafeMediaVolumeIndex(device);
        if (step >= 0) goto L48;
        step = streamState.getMaxIndex();
    L48:
        if (aliasIndex == 0) goto L50;
        flags3 = step;
        aliasIndex2 = flags9;
        goto L53
    L50:
        flags3 = aliasIndex;
        aliasIndex2 = flags9;
        goto L53
    L22:
        if (this.mContext.checkPermission("android.permission.MODIFY_AUDIO_ROUTING", pid, uid2) == 0) goto L25;
        Log.w(TAG, "MODIFY_AUDIO_ROUTING Permission Denial: adjustStreamVolume from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
        return;
    L8:
        if (isStreamAffectedByMute(streamType2) == true) goto L11;
    }

    private void muteAliasStreams(int streamAlias, final boolean state) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        Object r1 = this.mVolumeStateLock;     // Catch: Throwable -> L30
        monitor-enter(r1);     // Catch: Throwable -> L30
        List<Integer> streamsToMute = new ArrayList();     // Catch: Throwable -> L20
        int streamIdx = 0;
    L8:
        if (streamIdx >= this.mStreamStates.size()) goto L26;
        VolumeStreamState vss = this.mStreamStates.valueAt(streamIdx);     // Catch: Throwable -> L20
        if (vss == null) goto L25;
        if (streamAlias != sStreamVolumeAlias.get(vss.getStreamType())) goto L25;
        if (VolumeStreamState.m2131$$Nest$misMutable(vss) == false) goto L25;
        if (this.mCameraSoundForced.get() == false) goto L22;
        if (vss.getStreamType() == 7) goto L25;
    L22:
        boolean changed = vss.mute(state, false, "muteAliasStreams");     // Catch: Throwable -> L20
        if (changed == false) goto L25;
        streamsToMute.add(Integer.valueOf(vss.getStreamType()));     // Catch: Throwable -> L20
    L25:
        streamIdx = streamIdx + 1;     // Catch: Throwable -> L20
        goto L8
    L26:
        streamsToMute.forEach(new AudioService$$ExternalSyntheticLambda26(this, state));     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L30
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$muteAliasStreams$14(boolean state, Integer streamToMute) {
        getVssForStreamOrDefault(streamToMute.intValue()).doMute();
        broadcastMuteSetting(streamToMute.intValue(), state);
    }

    private void broadcastMuteSetting(int streamType, boolean isMuted) {
        Intent intent = new Intent("android.media.STREAM_MUTE_CHANGED_ACTION");
        intent.putExtra("android.media.EXTRA_STREAM_VOLUME_MUTED", isMuted);
        if (isStreamBluetoothSco(streamType) == false) goto L5;
        intent.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", 6);
        sendBroadcastToAll(intent, null);
    L5:
        intent.putExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", streamType);
        sendBroadcastToAll(intent, null);
    }

    private void onUnmuteStreamOnSingleVolDevice(int streamAlias, int flags) {
        Object r1 = this.mSettingsLock;
        monitor-enter(r1);
        Object r2 = this.mVolumeStateLock;     // Catch: Throwable -> L39
        monitor-enter(r2);     // Catch: Throwable -> L39
        VolumeStreamState streamState = getVssForStreamOrDefault(streamAlias);     // Catch: Throwable -> L35
        boolean wasMuted = streamState.mute(false, "onUnmuteStreamOnSingleVolDevice");     // Catch: Throwable -> L35
        if (wasMuted == true) goto L47;
    L12:
        int device = getDeviceForStream(streamAlias);     // Catch: Throwable -> L35
        int index = streamState.getIndex(device);     // Catch: Throwable -> L35
        sendVolumeUpdate(streamAlias, index, index, flags, device);     // Catch: Throwable -> L33
        monitor-exit(r2);     // Catch: Throwable -> L33
        if (streamAlias != 3) goto L31;
        if (wasMuted == false) goto L31;
        Object r12 = this.mHdmiClientLock;     // Catch: Throwable -> L29
        monitor-enter(r12);     // Catch: Throwable -> L29
        maybeSendSystemAudioStatusCommand(true);     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L31:
        monitor-exit(r1);     // Catch: Throwable -> L29
        return;
    L47:
        muteAliasStreams(streamAlias, false);     // Catch: Throwable -> L10
    L10:
        th = th;
    L37:
        monitor-exit(r2);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L29
    L35:
        th = th;
    L33:
        th = th;
    L29:
        th = move-exception;
        Throwable r13 = th;
    L41:
        monitor-exit(r1);     // Catch: Throwable -> L29
        throw r13;
    L39:
        th = move-exception;
        r13 = th;
        goto L41
    }

    private void maybeSendSystemAudioStatusCommand(boolean isMuteAdjust) {
        if (this.mHdmiAudioSystemClient != null) goto L5;
        return;
    L5:
        if (this.mHdmiSystemAudioSupported == true) goto L7;
        return;
    L7:
        if (this.mHdmiCecVolumeControlEnabled == false) goto L20;
        long identity = Binder.clearCallingIdentity();
        this.mHdmiAudioSystemClient.sendReportAudioStatusCecCommand(isMuteAdjust, getStreamVolume(3), getStreamMaxVolume(3), isStreamMute(3));     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(identity);
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private int getNewRingerMode(int stream, int index, int flags) {
        if (this.mIsSingleVolume == false) goto L7;
        return getRingerModeExternal();
    L7:
        if ((flags & 2) == 0) goto L9;
    L13:
        if (index == 0) goto L15;
        return 2;
    L15:
        if (this.mHasVibrator == false) goto L18;
        return 1;
    L18:
        if (this.mVolumePolicy.volumeDownToEnterSilent == false) goto L20;
        return 0;
    L20:
        return 2;
    L9:
        if (stream == getUiSoundsStreamType()) goto L13;
        return getRingerModeExternal();
    }

    private boolean isAndroidNPlus(String caller) {
        ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfoAsUser(caller, 0, UserHandle.getUserId(Binder.getCallingUid()));     // Catch: PackageManager.NameNotFoundException -> L8
        if (applicationInfo.targetSdkVersion < 24) goto L7;
        return true;
    L7:
        return false;
    L9:
        return true;
    }

    private boolean wouldToggleZenMode(int newMode) {
        if (getRingerModeExternal() != 0) goto L7;
        if (newMode == 0) goto L7;
        return true;
    L7:
        if (getRingerModeExternal() == 0) goto L10;
        if (newMode != 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    void onSetStreamVolume(int streamType, int index, int flags, int device, String caller, boolean hasModifyAudioSettings, boolean canChangeMute) {
        int stream = sStreamVolumeAlias.get(streamType, -1);
        if (stream != (-1)) goto L6;
        Log.e(TAG, "onSetStreamVolume: no stream vol alias for stream type " + stream);
        return;
    L6:
        boolean r7 = false;
        if ((flags & 2) == 0) goto L9;
    L10:
        setRingerMode(getNewRingerMode(stream, index, flags), "AS.AudioService.onSetStreamVolume", false);
    L11:
        setStreamVolumeInt(stream, index, device, false, caller, hasModifyAudioSettings);
        if (isStreamBluetoothSco(streamType) == true) goto L18;
        if (canChangeMute == false) goto L19;
        if (index != 0) goto L16;
        r7 = true;
    L16:
        muteAliasStreams(stream, r7);
        return;
    L19:
        return;
    L18:
        return;
    L9:
        if (stream != getUiSoundsStreamType()) goto L11;
        goto L10
    }

    private void enforceModifyAudioRoutingPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Missing MODIFY_AUDIO_ROUTING permission");
    }

    private void enforceQueryStateOrModifyRoutingPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.QUERY_AUDIO_STATE") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("Missing MODIFY_AUDIO_ROUTING or QUERY_AUDIO_STATE permissions");
    }

    public void registerAudioVolumeCallback(IAudioVolumeChangeDispatcher callback) {
        this.mAudioVolumeChangeHandler.registerListener(callback);
    }

    public void unregisterAudioVolumeCallback(IAudioVolumeChangeDispatcher callback) {
        this.mAudioVolumeChangeHandler.unregisterListener(callback);
    }

    public void setVolumeGroupVolumeIndex(int groupId, int index, int flags, String callingPackage, String attributionTag) {
        super.setVolumeGroupVolumeIndex_enforcePermission();
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L6;
        Log.e(TAG, ": no volume group found for id " + groupId);
        return;
    L6:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);
        EventLogger r0 = sVolumeLogger;
        String r6 = vgs.name();
        StringBuilder r5 = new StringBuilder();
        String r12 = callingPackage;
        r5.append(r12);
        r5.append(", user ");
        r5.append(getCurrentUserId());
        int r7 = index;
        r0.enqueue(new AudioServiceEvents.VolumeEvent(8, r6, r7, flags, r5.toString()));
        int r10 = flags;
        vgs.setVolumeIndex(r7, r10);
        int[] r4 = vgs.getLegacyStreamTypes();
        int r8 = r4.length;
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L14;
        int groupedStream = r4[r9];
        ensureValidStreamType(groupedStream);     // Catch: IllegalArgumentException -> L11
        setStreamVolume(groupedStream, r7, r10, null, r12, callingPackage, attributionTag, Binder.getCallingUid(), true, true);
    L13:
        r9 = r9 + 1;
        r7 = index;
        r10 = flags;
        r12 = callingPackage;
    L12:
        Log.d(TAG, "volume group " + groupId + " has internal streams (" + groupedStream + "), do not change associated stream volume");
        goto L13
    }

    public int getVolumeGroupVolumeIndex(int groupId) {
        super.getVolumeGroupVolumeIndex_enforcePermission();
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
        int r2 = 0;
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L11;
        Log.e(TAG, "No volume group for id " + groupId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);     // Catch: Throwable -> L9
        if (vgs.isMuted() == true) goto L15;
        r2 = vgs.getVolumeIndex();     // Catch: Throwable -> L9
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public int getVolumeGroupMaxVolumeIndex(int groupId) {
        super.getVolumeGroupMaxVolumeIndex_enforcePermission();
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L12;
        Log.e(TAG, "No volume group for id " + groupId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 0;
    L12:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);     // Catch: Throwable -> L10
        int r2 = vgs.getMaxIndex();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    public int getVolumeGroupMinVolumeIndex(int groupId) {
        super.getVolumeGroupMinVolumeIndex_enforcePermission();
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L12;
        Log.e(TAG, "No volume group for id " + groupId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 0;
    L12:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);     // Catch: Throwable -> L10
        int r2 = vgs.getMinIndex();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    public void setDeviceVolume(VolumeInfo vi, AudioDeviceAttributes ada, String callingPackage) {
        super.setDeviceVolume_enforcePermission();
        vi.getClass();
        ada.getClass();
        callingPackage.getClass();
        if (vi.hasStreamType() == true) goto L6;
        Log.e(TAG, "Unsupported non-stream type based VolumeInfo", new Exception());
        return;
    L6:
        int index = vi.getVolumeIndex();
        if (index == (-100)) goto L9;
    L13:
        this.mAudioSystem.clearRoutingCache();
        int streamType = replaceBtScoStreamWithVoiceCall(vi.getStreamType(), "setDeviceVolume");
        VolumeStreamState vss = getVssForStream(streamType);
        int currDev = getDeviceForStream(streamType);
        if (currDev == ada.getInternalType()) goto L18;
        if (vss == null) goto L18;
        boolean skipping = false;
    L19:
        EventLogger r13 = sVolumeLogger;
        AudioServiceEvents.DeviceVolumeEvent r4 = new AudioServiceEvents.DeviceVolumeEvent(streamType, index, ada, currDev, callingPackage, skipping);
        int index2 = index;
        r13.enqueue(r4);
        if (skipping == false) goto L23;
        return;
    L23:
        if (vi.hasMuteCommand() == true) goto L25;
    L30:
        sVolumeLogger.enqueueAndLog("setDeviceVolume from:" + callingPackage + " " + vi + " " + ada, 0, TAG);
        if (vi.getMinVolumeIndex() == (-100)) goto L44;
        if (vi.getMaxVolumeIndex() == (-100)) goto L44;
        int min = (vss.getMinIndex() + 5) / 10;
        int max = (vss.getMaxIndex() + 5) / 10;
        if (vi.getMinVolumeIndex() == min) goto L38;
    L41:
        int index3 = rescaleIndex(index2, vi.getMinVolumeIndex(), vi.getMaxVolumeIndex(), min, max);
    L48:
        setStreamVolumeWithAttributionInt(streamType, index3, 0, ada, callingPackage, null, false);
        return;
    L38:
        if (vi.getMaxVolumeIndex() != max) goto L41;
        index2 = index2;
    L47:
        index3 = index2;
    L44:
        if ((index2 * 10) < vss.getMinIndex()) goto L53;
        if ((index2 * 10) <= vss.getMaxIndex()) goto L47;
    L53:
        throw new IllegalArgumentException("invalid volume index " + index2 + " not between min/max for stream " + vi.getStreamType());
    L25:
        if (vi.isMuted() == false) goto L30;
        if (isStreamMute(streamType) == true) goto L30;
        setStreamVolumeWithAttributionInt(streamType, vss.getMinIndex(), 0, ada, callingPackage, null, false);
        return;
    L18:
        skipping = true;
        goto L19
    L9:
        if (vi.hasMuteCommand() == true) goto L13;
        throw new IllegalArgumentException("changing device volume requires a volume index or mute command");
    }

    public void setStreamVolume(int streamType, int index, int flags, String callingPackage) {
        setStreamVolumeWithAttribution(streamType, index, flags, callingPackage, null);
    }

    public void adjustVolumeGroupVolume(int groupId, int direction, int flags, String callingPackage) {
        ensureValidDirection(direction);
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L6;
        Log.e(TAG, ": no volume group found for id " + groupId);
        return;
    L6:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);
        int[] r2 = vgs.getLegacyStreamTypes();
        int r5 = r2.length;
        int r8 = 0;
        boolean fallbackOnStream = false;
    L7:
        if (r8 >= r5) goto L21;
        int stream = r2[r8];
        ensureValidStreamType(stream);     // Catch: IllegalArgumentException -> L17
        if (VolumeGroupState.m2121$$Nest$misVssMuteBijective(vgs, stream) == false) goto L19;
        adjustStreamVolume(stream, direction, flags, callingPackage);
        if (isMuteAdjust(direction) == true) goto L14;
        fallbackOnStream = true;
        goto L19
    L14:
        return;
    L19:
        r8 = r8 + 1;
    L18:
        Log.d(TAG, "volume group " + groupId + " has internal streams (" + stream + "), do not change associated stream volume");
        goto L19
    L21:
        if (fallbackOnStream == false) goto L23;
        return;
    L23:
        sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(11, vgs.name(), direction, flags, callingPackage));
        vgs.adjustVolume(direction, flags);
    }

    public int getLastAudibleVolumeForVolumeGroup(int groupId) {
        super.getLastAudibleVolumeForVolumeGroup_enforcePermission();
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L12;
        Log.e(TAG, ": no volume group found for id " + groupId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 0;
    L12:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);     // Catch: Throwable -> L10
        int r2 = vgs.getVolumeIndex();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    public boolean isVolumeGroupMuted(int groupId) {
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sVolumeGroupStates.indexOfKey(groupId) >= 0) goto L12;
        Log.e(TAG, ": no volume group found for id " + groupId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L12:
        VolumeGroupState vgs = sVolumeGroupStates.get(groupId);     // Catch: Throwable -> L10
        boolean r2 = vgs.isMuted();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    }

    public void setStreamVolumeWithAttribution(int streamType, int index, int flags, String callingPackage, String attributionTag) {
        if (this.mHardeningEnforcer.blockVolumeMethod(100, callingPackage, Binder.getCallingUid()) == false) goto L5;
        return;
    L5:
        setStreamVolumeWithAttributionInt(streamType, index, flags, null, callingPackage, attributionTag, true);
    }

    protected void setStreamVolumeWithAttributionInt(int streamType, int index, int flags, AudioDeviceAttributes ada, String callingPackage, String attributionTag, boolean canChangeMuteAndUpdateController) {
        String r5 = callingPackage;
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "setStreamVolumeWithAttributionInt");
        if (streamType2 == 10) goto L5;
    L8:
        if (streamType2 != 0) goto L17;
        if (index != 0) goto L17;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto L17;
        if (isStreamBluetoothSco(streamType2) == true) goto L17;
        Log.w(TAG, "Trying to call setStreamVolume() for STREAM_VOICE_CALL and index 0 without MODIFY_PHONE_STATE  callingPackage=" + r5);
        return;
    L17:
        if (streamType2 == 11) goto L19;
    L22:
        if (ada != null) goto L24;
        int deviceType = getDeviceForStream(streamType2);
        int streamType3 = streamType2;
        r5 = callingPackage;
        sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(2, streamType3, index, flags, getStreamVolume(streamType2, deviceType), callingPackage));
        AudioDeviceAttributes ada2 = new AudioDeviceAttributes(deviceType, "");
    L25:
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.service.setStreamVolumeWithAttributionInt").setUid(Binder.getCallingUid()).set(MediaMetrics.Property.EVENT, "setStreamVolumeWithAttributionInt").set(MediaMetrics.Property.CALLING_PACKAGE, r5).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(streamType3)).set(MediaMetrics.Property.INDEX, Integer.valueOf(index)).set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags));
        mMmi.set(mmi);
        setStreamVolume(streamType3, index, flags, ada2, r5, callingPackage, attributionTag, Binder.getCallingUid(), callingOrSelfHasAudioSettingsPermission(), canChangeMuteAndUpdateController);
        mmi.record();
        return;
    L24:
        streamType3 = streamType2;
        ada2 = ada;
        goto L25
    L19:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") == 0) goto L22;
        Log.w(TAG, "Trying to call setStreamVolume() for STREAM_ASSISTANT without MODIFY_AUDIO_ROUTING  callingPackage=" + r5);
        return;
    L5:
        if (canChangeAccessibilityVolume() == true) goto L8;
        Log.w(TAG, "Trying to call setStreamVolume() for a11y without CHANGE_ACCESSIBILITY_VOLUME  callingPackage=" + r5);
    }

    public boolean isUltrasoundSupported() {
        super.isUltrasoundSupported_enforcePermission();
        return AudioSystem.isUltrasoundSupported();
    }

    public boolean isHotwordStreamSupported(boolean lookbackAudio) {
        super.isHotwordStreamSupported_enforcePermission();
        return this.mAudioPolicy.isHotwordStreamSupported(lookbackAudio);
    L5:
        e = move-exception;
        Log.e(TAG, "Suppressing exception calling into AudioPolicy", e);
        return false;
    }

    private boolean canChangeAccessibilityVolume() {
        Object r0 = this.mAccessibilityServiceUidsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CHANGE_ACCESSIBILITY_VOLUME") != 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if (this.mAccessibilityServiceUids == null) goto L20;
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L8
        int i = 0;
    L14:
        if (i >= this.mAccessibilityServiceUids.length) goto L20;
        if (this.mAccessibilityServiceUids[i] == callingUid) goto L17;
        i = i + 1;     // Catch: Throwable -> L8
        goto L14
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    public int getBluetoothContextualVolumeStream() {
        return getBluetoothContextualVolumeStream(this.mMode.get());
    }

    private int getBluetoothContextualVolumeStream(int mode) {
        boolean voiceActivityCanOverride = true;
        switch(mode) {
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L6;
        };
    L5:
        voiceActivityCanOverride = false;
    L6:
        if (voiceActivityCanOverride == true) goto L8;
    L14:
        return 3;
    L8:
        if (this.mVoicePlaybackActive.get() == false) goto L14;
        if (mode == 0) goto L14;
        if (getDeviceForStream(0) != 128) goto L13;
        return 3;
    L13:
        return 0;
    L16:
        if (getDeviceForStream(0) != 128) goto L18;
        return 3;
    L18:
        return 0;
    }

    private void onPlaybackConfigChange(List<AudioPlaybackConfiguration> configs) {
        boolean voiceActive = false;
        boolean mediaActive = false;
        Iterator<AudioPlaybackConfiguration> r2 = configs.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        AudioPlaybackConfiguration config = r2.next();
        int usage = config.getAudioAttributes().getUsage();
        if (config.isActive() == false) goto L4;
        if (usage != 2) goto L11;
    L12:
        voiceActive = true;
    L14:
        if (usage == 1) goto L18;
        if (usage == 14) goto L18;
        if (usage != 0) goto L4;
    L18:
        mediaActive = true;
        goto L4
    L11:
        if (usage != 3) goto L14;
    L21:
        if (this.mVoicePlaybackActive.getAndSet(voiceActive) == voiceActive) goto L24;
        postUpdateContextualVolumes();
    L24:
        if (this.mMediaPlaybackActive.getAndSet(mediaActive) == mediaActive) goto L27;
        if (mediaActive == false) goto L27;
        this.mSoundDoseHelper.scheduleMusicActiveCheck();
    L27:
        this.mLoudnessCodecHelper.updateCodecParameters(configs);
        updateAudioModeHandlers(configs, null);
        this.mDeviceBroker.updateCommunicationRouteClientsActivity(configs, null);
        this.mASExt.onPlaybackConfigChange_onEnd(configs);
    }

    void updateAudioModeHandlers(List<AudioPlaybackConfiguration> playbackConfigs, List<AudioRecordingConfiguration> recordConfigs) {
        Object r1 = this.mDeviceBroker.mSetModeLock;
        monitor-enter(r1);
        boolean updateAudioMode = false;
        Iterator<SetModeDeathHandler> r4 = this.mSetModeDeathHandlers.iterator();     // Catch: Throwable -> L22
        int existingMsgPolicy = 2;
        int delay = 6000;
    L7:
        if (r4.hasNext() == false) goto L45;
        SetModeDeathHandler h = r4.next();     // Catch: Throwable -> L22
        boolean wasActive = h.isActive();     // Catch: Throwable -> L22
        if (playbackConfigs == null) goto L25;
        h.setPlaybackActive(false);     // Catch: Throwable -> L22
        Iterator<AudioPlaybackConfiguration> r8 = playbackConfigs.iterator();     // Catch: Throwable -> L22
    L12:
        if (r8.hasNext() == false) goto L25;
        AudioPlaybackConfiguration config = r8.next();     // Catch: Throwable -> L22
        int usage = config.getAudioAttributes().getUsage();     // Catch: Throwable -> L22
        if (config.getClientUid() != h.getUid()) goto L12;
        if (usage == 2) goto L20;
        if (usage != 3) goto L12;
    L20:
        if (config.isActive() == false) goto L12;
        h.setPlaybackActive(true);     // Catch: Throwable -> L22
    L25:
        if (recordConfigs == null) goto L38;
        h.setRecordingActive(false);     // Catch: Throwable -> L22
        Iterator<AudioRecordingConfiguration> r7 = recordConfigs.iterator();     // Catch: Throwable -> L22
    L28:
        if (r7.hasNext() == false) goto L38;
        AudioRecordingConfiguration config2 = r7.next();     // Catch: Throwable -> L22
        if (config2.getClientUid() != h.getUid()) goto L28;
        if (config2.isClientSilenced() == true) goto L28;
        if (config2.getAudioSource() != 7) goto L28;
        h.setRecordingActive(true);     // Catch: Throwable -> L22
    L38:
        if (wasActive == h.isActive()) goto L7;
        updateAudioMode = true;
        if (h.isActive() == false) goto L7;
        if (h != getAudioModeOwnerHandler()) goto L7;
        delay = 0;
        existingMsgPolicy = 0;
        goto L7
    L45:
        if (updateAudioMode == false) goto L47;
        postUpdateAudioMode(existingMsgPolicy, -1, Process.myPid(), this.mContext.getPackageName(), false, delay);     // Catch: Throwable -> L22
    L47:
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    void postUpdateAudioMode(int msgPolicy, int mode, int pid, String packageName, boolean signal, int delay) {
        Object r1 = this.mAudioModeResetLock;
        monitor-enter(r1);
        if (signal == true) goto L28;
    L26:
        AudioHandler r2 = this.mAudioHandler;     // Catch: Throwable -> L21
        if (signal == false) goto L13;
        int r0 = 39;
    L14:
        sendMsg(r2, r0, msgPolicy, 0, 0, new UpdateAudioModeInfo(mode, pid, packageName), delay);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L13:
        r0 = 36;
    L21:
        th = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L19
        throw th;
    L28:
        this.mAudioModeResetCount++;     // Catch: Throwable -> L7
    L7:
        th = th;
    L19:
        th = th;
        goto L23
    }

    private void onRecordingConfigChange(List<AudioRecordingConfiguration> configs) {
        updateAudioModeHandlers(null, configs);
        this.mDeviceBroker.updateCommunicationRouteClientsActivity(null, configs);
    }

    private void dumpFlags(PrintWriter pw) {
        pw.println("\nFun with Flags:");
        pw.println("\tcom.android.media.audio.as_device_connection_failure:false");
        pw.println("\tandroid.media.audio.autoPublicVolumeApiHardening:true");
        pw.println("\tandroid.media.audio.automaticBtDeviceType - EOL");
        pw.println("\tandroid.media.audio.featureSpatialAudioHeadtrackingLowLatency:true");
        pw.println("\tandroid.media.audio.focusFreezeTestApi:true");
        pw.println("\tcom.android.media.audio.audioserverPermissions:true");
        pw.println("\tcom.android.media.audio.disablePrescaleAbsoluteVolume:true");
        pw.println("\tcom.android.media.audio.setStreamVolumeOrder - EOL");
        pw.println("\tandroid.media.audio.ringtoneUserUriCheck:false");
        pw.println("\tandroid.media.audio.roForegroundAudioControl:true");
        pw.println("\tandroid.media.audio.scoManagedByAudio:false");
        pw.println("\tcom.android.media.audio.absVolumeIndexFix - EOL");
        pw.println("\tcom.android.media.audio.vgsVssSyncMuteOrder - EOL");
        pw.println("\tcom.android.media.audio.replaceStreamBtSco:true");
        pw.println("\tcom.android.media.audio.equalScoLeaVcIndexRange:true");
        pw.println("\tcom.android.media.audio.ringMyCar:false");
        pw.println("\tandroid.media.audio.Flags.concurrentAudioRecordBypassPermission:false");
        pw.println("\tandroid.media.audio.Flags.cacheGetStreamMinMaxVolume:false");
        pw.println("\tandroid.media.audio.Flags.cacheGetStreamVolume:false");
        pw.println("\tcom.android.media.audio.optimizeBtDeviceSwitch:false");
    }

    private void dumpAudioMode(PrintWriter pw) {
        pw.println("\nAudio mode: ");
        pw.println("- Requested mode = " + AudioSystem.modeToString(getMode()));
        pw.println("- Actual mode = " + AudioSystem.modeToString(this.mMode.get()));
        pw.println("- Mode owner: ");
        SetModeDeathHandler hdlr = getAudioModeOwnerHandler();
        if (hdlr == null) goto L5;
        hdlr.dump(pw, -1);
    L6:
        pw.println("- Mode owner stack: ");
        if (this.mSetModeDeathHandlers.isEmpty() == false) goto L9;
        pw.println("   Empty");
        return;
    L9:
        int i = 0;
    L11:
        if (i >= this.mSetModeDeathHandlers.size()) goto L15;
        this.mSetModeDeathHandlers.get(i).dump(pw, i);
        i = i + 1;
        goto L11
    L15:
        return;
    L5:
        pw.println("   None");
        goto L6
    }

    void postUpdateContextualVolumes() {
        sendMsg(this.mAudioHandler, 56, 0, 0, 0, TAG, 500);
    }

    private void onUpdateContextualVolumes() {
        final int streamType = getBluetoothContextualVolumeStream();
        Slog.i(TAG, "onUpdateContextualVolumes: absolute volume driving streams " + streamType + " avrcp supported: " + this.mAvrcpAbsVolSupported);
        Object r1 = this.mCachedAbsVolDrivingStreamsLock;
        monitor-enter(r1);
        this.mCachedAbsVolDrivingStreams.replaceAll(new AudioService$$ExternalSyntheticLambda27(this, streamType));     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        Set<Integer> deviceTypes = getDeviceSetForStreamDirect(streamType);
        Set<Integer> absVolumeDeviceTypes = new ArraySet(AudioSystem.DEVICE_OUT_ALL_A2DP_SET);
        absVolumeDeviceTypes.addAll(this.mAbsVolumeMultiModeCaseDevices);
        Set<Integer> absVolumeDevices = AudioSystem.intersectionAudioDeviceTypes(absVolumeDeviceTypes, deviceTypes);
        if (absVolumeDevices.isEmpty() == false) goto L10;
        return;
    L10:
        if (absVolumeDevices.size() <= 1) goto L13;
        Slog.w(TAG, "onUpdateContextualVolumes too many active devices: " + ((String) absVolumeDevices.stream().map(new AudioService$$ExternalSyntheticLambda28()).collect(Collectors.joining(","))) + ", for stream: " + streamType);
        return;
    L13:
        int device = ((Integer[]) absVolumeDevices.toArray(new Integer[0]))[0].intValue();
        int index = (getVolumeForDeviceIgnoreMute(streamType, device) + 5) / 10;
        Slog.i(TAG, "onUpdateContextualVolumes streamType: " + streamType + ", device: " + AudioSystem.getOutputDeviceName(device) + ", index: " + index);
        if (AudioSystem.isLeAudioDeviceType(device) == false) goto L17;
        this.mDeviceBroker.postSetLeAudioVolumeIndex(index * 10, getVssForStreamOrDefault(streamType).getMaxIndex(), streamType);
    L29:
        sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(6, this.mVoicePlaybackActive.get(), streamType, index, device));
        return;
    L17:
        if (device != 134217728) goto L27;
        int haIndex = index * 10;
        VolumeStreamState vss = getVssForStreamOrDefault(streamType);
        Object r9 = this.mVolumeStateLock;
        monitor-enter(r9);
        int haIndex2 = (int) (vss.getMinIndex() + ((haIndex - vss.getMinIndex()) / vss.getIndexStepFactor()));     // Catch: Throwable -> L23
        monitor-exit(r9);     // Catch: Throwable -> L23
        this.mDeviceBroker.postSetHearingAidVolumeIndex(haIndex2, streamType);
    L23:
        th = move-exception;
        throw th;
    L27:
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == false) goto L31;
        this.mDeviceBroker.postSetAvrcpAbsoluteVolumeIndex(index);
        goto L29
    L31:
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Integer lambda$onUpdateContextualVolumes$15(int streamType, Integer absDev, Integer stream) {
        if (absDev.intValue() != 128) goto L8;
        boolean enabled = this.mAvrcpAbsVolSupported;
        if (enabled == true) goto L7;
        Slog.w(TAG, "Updating avrcp not supported in onUpdateContextualVolumes");
    L7:
        boolean enabled2 = enabled;
    L10:
        if (stream.intValue() == streamType) goto L15;
        int result = this.mAudioSystem.setDeviceAbsoluteVolumeEnabled(absDev.intValue(), "", enabled2, streamType);
        if (result == 0) goto L14;
        int streamType2 = streamType;
        sVolumeLogger.enqueueAndSlog(new AudioServiceEvents.VolumeEvent(13, result, absDev.intValue(), enabled2, streamType2).eventToString(), 1, TAG);
    L17:
        return Integer.valueOf(streamType2);
    L14:
        streamType2 = streamType;
        goto L17
    L15:
        streamType2 = streamType;
        goto L17
    L8:
        enabled2 = true;
        goto L10
    }

    private void setStreamVolume(int streamType, int index, int flags, AudioDeviceAttributes ada, String callingPackage, String caller, String attributionTag, int uid, boolean hasModifyAudioSettings, boolean canChangeMuteAndUpdateController) {
        Log.d(TAG, "setStreamVolume(stream=" + streamType + ", index=" + index + ", dev=" + ada + ", calling=" + callingPackage + ")");
        if (this.mUseFixedVolume == false) goto L5;
        return;
    L5:
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "setStreamVolume");
        ensureValidStreamType(streamType2);
        int streamTypeAlias = sStreamVolumeAlias.get(streamType2, -1);
        if (streamTypeAlias != (-1)) goto L9;
        Log.e(TAG, "setStreamVolume: no stream vol alias for stream type " + streamType2);
        return;
    L9:
        VolumeStreamState streamState = getVssForStreamOrDefault(streamTypeAlias);
        if (ada != null) goto L12;
        int probeDevice = getDeviceForStream(streamType2);
    L13:
        int rewritten = this.mASExt.setStreamVolume_rewriteStreamType(streamType2, probeDevice, callingPackage);
        if (rewritten == streamType2) goto L20;
        Log.i(TAG, "setStreamVolume rewrite " + streamType2 + " -> " + rewritten);
        int streamTypeAlias2 = sStreamVolumeAlias.get(rewritten, -1);
        if (streamTypeAlias2 != (-1)) goto L19;
        Log.e(TAG, "setStreamVolume: no alias for rewritten stream " + rewritten);
        return;
    L19:
        VolumeStreamState streamState2 = getVssForStreamOrDefault(streamTypeAlias2);
        int streamTypeAlias3 = streamTypeAlias2;
        VolumeStreamState streamState3 = streamState2;
        int streamTypeAlias4 = rewritten;
    L21:
        if (callingPackage != null) goto L23;
    L26:
        if (ada != null) goto L28;
        int r0 = getDeviceForStream(streamTypeAlias4);
    L29:
        int device = r0;
    L31:
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(device)) == true) goto L38;
        if (AudioSystem.DEVICE_OUT_ALL_BLE_SET.contains(Integer.valueOf(device)) == true) goto L38;
        if ((flags & 64) == 0) goto L38;
        return;
    L38:
        if (uid != 1000) goto L40;
        int uid2 = UserHandle.getUid(getCurrentUserId(), UserHandle.getAppId(uid));
    L42:
        if (checkNoteAppOp(STREAM_VOLUME_OPS[streamTypeAlias3], uid2, callingPackage, attributionTag) == true) goto L45;
        return;
    L45:
        if (isAndroidNPlus(callingPackage) == false) goto L54;
        if (wouldToggleZenMode(getNewRingerMode(streamTypeAlias3, index, flags)) == false) goto L54;
        if (this.mNm.isNotificationPolicyAccessGrantedForPackage(callingPackage) == true) goto L54;
        throw new SecurityException("Not allowed to change Do Not Disturb state");
    L54:
        if (volumeAdjustmentAllowedByDnd(streamTypeAlias3, flags) == true) goto L56;
        return;
    L56:
        int streamType3 = streamTypeAlias4;
        if (this.mASExt.setStreamVolume_afterCheckingVolumeAdjustmentAllowedByDnd_earlyReturn(streamType3, index, flags, ada, callingPackage, caller, attributionTag, uid2, canChangeMuteAndUpdateController, streamTypeAlias3) == false) goto L59;
        return;
    L59:
        this.mSoundDoseHelper.invalidatePendingVolumeCommand();
        int oldIndex = streamState3.getIndex(device);
        int index2 = rescaleIndex(index * 10, streamType3, streamTypeAlias3);
        int flags2 = flags & (-33);
        if (streamTypeAlias3 == 3) goto L62;
    L70:
        int flags3 = flags2;
        int flags4 = index2;
    L72:
        if (this.mSoundDoseHelper.willDisplayWarningAfterCheckVolume(streamType3, flags4, device, flags3) == true) goto L74;
        int flags5 = flags3;
        int flags6 = device;
        onSetStreamVolume(streamType3, flags4, flags5, flags6, caller, hasModifyAudioSettings, canChangeMuteAndUpdateController);
    L75:
        int index3 = streamState3.getIndex(flags6);
        if (streamTypeAlias3 != getBluetoothContextualVolumeStream()) goto L83;
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(flags6)) == false) goto L83;
        if ((flags5 & 64) != 0) goto L83;
        Log.d(TAG, "setStreamVolume postSetAvrcpAbsoluteVolumeIndex index=" + index3 + "stream=" + streamType3);
        this.mDeviceBroker.postSetAvrcpAbsoluteVolumeIndex(index3 / 10);
    L88:
        if (AudioSystem.isLeAudioDeviceType(flags6) == false) goto L95;
        if (streamType3 != getBluetoothContextualVolumeStream()) goto L95;
        if ((flags5 & 64) != 0) goto L95;
        Log.d(TAG, "setStreamVolume postSetLeAudioVolumeIndex index=" + index3 + " stream=" + streamType3);
        this.mDeviceBroker.postSetLeAudioVolumeIndex(index3, getVssForStreamOrDefault(streamType3).getMaxIndex(), streamType3);
    L95:
        if (flags6 == 134217728) goto L97;
    L106:
        Object r6 = this.mHdmiClientLock;
        monitor-enter(r6);
        if (streamTypeAlias3 != 3) goto L130;
        if (oldIndex == index3) goto L130;
        maybeSendSystemAudioStatusCommand(false);     // Catch: Throwable -> L113
    L113:
        th = th;
    L136:
        monitor-exit(r6);     // Catch: Throwable -> L128
        throw th;
    L128:
        th = th;
    L130:
        monitor-exit(r6);     // Catch: Throwable -> L124
        if (canChangeMuteAndUpdateController == false) goto L118;
        int device2 = flags6;
        int device3 = flags5;
        int index4 = oldIndex;
        sendVolumeUpdate(streamType3, index4, index3, device3, device2);
        int index5 = index3;
        flags6 = device2;
    L119:
        MediaMetrics.Item mmi = mMmi.get();
        if (mmi != null) goto L122;
        Log.w(TAG, "setStreamVolume MediaMetrics.Item is null");
        return;
    L122:
        mmi.set(MediaMetrics.Property.OLD_INDEX, Integer.valueOf((index4 + 5) / 10)).set(MediaMetrics.Property.NEW_INDEX, Integer.valueOf((index5 + 5) / 10)).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(flags6));
        return;
    L118:
        index5 = index3;
        index4 = oldIndex;
    L124:
        th = th;
        goto L136
    L97:
        if (streamType3 != getBluetoothContextualVolumeStream()) goto L106;
        Log.i(TAG, "setStreamVolume postSetHearingAidVolumeIndex index=" + index3 + " stream=" + streamType3);
        VolumeStreamState vss = getVssForStreamOrDefault(streamType3);
        Object r7 = this.mVolumeStateLock;
        monitor-enter(r7);
        int haIndex = (int) (vss.getMinIndex() + ((index3 - vss.getMinIndex()) / vss.getIndexStepFactor()));     // Catch: Throwable -> L103
        monitor-exit(r7);     // Catch: Throwable -> L103
        this.mDeviceBroker.postSetHearingAidVolumeIndex(haIndex, streamType3);
    L103:
        th = move-exception;
        throw th;
    L83:
        if (isAbsoluteVolumeDevice(flags6) == false) goto L88;
        if ((flags5 & 8192) != 0) goto L88;
        AbsoluteVolumeDeviceInfo info = getAbsoluteVolumeDeviceInfo(flags6);
        dispatchAbsoluteVolumeChanged(streamType3, info, index3);
        goto L88
    L74:
        flags5 = flags3;
        flags6 = device;
        goto L75
    L62:
        if (isFixedVolumeDevice(device) == false) goto L70;
        int flags7 = flags2 | 32;
        if (index2 == 0) goto L69;
        int index6 = this.mSoundDoseHelper.getSafeMediaVolumeIndex(device);
        if (index6 >= 0) goto L68;
        flags3 = flags7;
        flags4 = streamState3.getMaxIndex();
        goto L72
    L68:
        flags3 = flags7;
        flags4 = index6;
        goto L72
    L69:
        flags3 = flags7;
        flags4 = index2;
        goto L72
    L40:
        uid2 = uid;
        goto L42
    L28:
        r0 = ada.getInternalType();
        goto L29
    L23:
        if (callingPackage.indexOf("com.android.bluetooth") <= (-1)) goto L26;
        if (streamTypeAlias4 != 0) goto L26;
        Log.d(TAG, "bluetooth update volume");
        device = 16;
        goto L31
    L20:
        streamTypeAlias3 = streamTypeAlias;
        streamState3 = streamState;
        streamTypeAlias4 = streamType2;
        goto L21
    L12:
        probeDevice = ada.getInternalType();
        goto L13
    }

    private void dispatchAbsoluteVolumeChanged(int streamType, AbsoluteVolumeDeviceInfo deviceInfo, int index) {
        VolumeInfo volumeInfo = AbsoluteVolumeDeviceInfo.m2116$$Nest$mgetMatchingVolumeInfoForStream(deviceInfo, streamType);
        if (volumeInfo == null) goto L11;
        AbsoluteVolumeDeviceInfo.m2112$$Nest$fgetmCallback(deviceInfo).dispatchDeviceVolumeChanged(AbsoluteVolumeDeviceInfo.m2113$$Nest$fgetmDevice(deviceInfo), new VolumeInfo.Builder(volumeInfo).setVolumeIndex(rescaleIndex(index, streamType, volumeInfo)).build());     // Catch: RemoteException -> L6
        return;
    L7:
        Log.w(TAG, "Couldn't dispatch absolute volume behavior volume change");
        return;
    }

    private void dispatchAbsoluteVolumeAdjusted(int streamType, AbsoluteVolumeDeviceInfo deviceInfo, int index, int direction, int mode) {
        VolumeInfo volumeInfo = AbsoluteVolumeDeviceInfo.m2116$$Nest$mgetMatchingVolumeInfoForStream(deviceInfo, streamType);
        if (volumeInfo == null) goto L11;
        AbsoluteVolumeDeviceInfo.m2112$$Nest$fgetmCallback(deviceInfo).dispatchDeviceVolumeAdjusted(AbsoluteVolumeDeviceInfo.m2113$$Nest$fgetmDevice(deviceInfo), new VolumeInfo.Builder(volumeInfo).setVolumeIndex(rescaleIndex(index, streamType, volumeInfo)).build(), direction, mode);     // Catch: RemoteException -> L6
        return;
    L7:
        Log.w(TAG, "Couldn't dispatch absolute volume behavior volume adjustment");
        return;
    }

    private boolean volumeAdjustmentAllowedByDnd(int streamTypeAlias, int flags) {
        switch(this.mNm.getZenMode()) {
            case 0: goto L15;
            case 1: goto L6;
            case 2: goto L6;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L15:
        return true;
    L6:
        if (isStreamMutedByRingerOrZenMode(streamTypeAlias) == true) goto L8;
        return true;
    L8:
        if (isUiSoundsStreamType(streamTypeAlias) == false) goto L10;
        return true;
    L10:
        if ((flags & 2) != 0) goto L18;
        return false;
    L18:
        return true;
    }

    public void forceVolumeControlStream(int streamType, IBinder cb) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto L5;
        return;
    L5:
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "forceVolumeControlStream");
        Log.d(TAG, String.format("forceVolumeControlStream(%d)", new Object[]{Integer.valueOf(streamType2)}));
        Object r1 = this.mForceControlStreamLock;
        monitor-enter(r1);
        int oldVolumeControlStream = this.mVolumeControlStream;     // Catch: Throwable -> L11
        boolean oldUserSelectedVolumeControlStream = this.mUserSelectedVolumeControlStream;     // Catch: Throwable -> L11
        boolean r5 = true;
        if (this.mVolumeControlStream == (-1)) goto L13;
        if (streamType2 == (-1)) goto L13;
        this.mUserSelectedVolumeControlStream = true;     // Catch: Throwable -> L11
    L13:
        this.mVolumeControlStream = streamType2;     // Catch: Throwable -> L11
        if (this.mVolumeControlStream != (-1)) goto L20;
        if (this.mForceControlStreamClient == null) goto L18;
        this.mForceControlStreamClient.release();     // Catch: Throwable -> L11
        this.mForceControlStreamClient = null;     // Catch: Throwable -> L11
    L18:
        this.mUserSelectedVolumeControlStream = false;     // Catch: Throwable -> L11
    L27:
        if (oldVolumeControlStream != this.mVolumeControlStream) goto L32;
        if (oldUserSelectedVolumeControlStream != this.mUserSelectedVolumeControlStream) goto L32;
        r5 = false;
    L32:
        boolean controlStreamChanged = r5;
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (controlStreamChanged == false) goto L41;
        this.mASExt.onControlStreamInputsChanged("force_volume_control_stream");
        return;
    L41:
        return;
    L20:
        if (this.mForceControlStreamClient != null) goto L23;
        this.mForceControlStreamClient = new ForceControlStreamClient(this, cb);     // Catch: Throwable -> L11
        goto L27
    L23:
        if (this.mForceControlStreamClient.getBinder() != cb) goto L25;
        Log.d(TAG, "forceVolumeControlStream cb:" + cb + " is already linked.");     // Catch: Throwable -> L11
        goto L27
    L25:
        this.mForceControlStreamClient.release();     // Catch: Throwable -> L11
        this.mForceControlStreamClient = new ForceControlStreamClient(this, cb);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void sendBroadcastToAll(Intent intent, Bundle options) {
        if (this.mSystemServer.isPrivileged() == true) goto L5;
        return;
    L5:
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        long ident = Binder.clearCallingIdentity();
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, null, options);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(ident);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void sendStickyBroadcastToAll(Intent intent) {
        intent.addFlags(268435456);
        long ident = Binder.clearCallingIdentity();
        this.mContext.sendStickyBroadcastAsUser(intent, UserHandle.ALL);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int getCurrentUserId() {
        long ident = Binder.clearCallingIdentity();
        UserInfo currentUser = ActivityManager.getService().getCurrentUser();     // Catch: Throwable -> L6 RemoteException -> L8
        int r3 = currentUser.id;     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(ident);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L12:
        Binder.restoreCallingIdentity(ident);
        return 0;
    }

    protected void sendVolumeUpdate(int streamType, int oldIndex, int index, int flags, int device) {
        int streamType2 = sStreamVolumeAlias.get(streamType, -1);
        if (streamType2 != (-1)) goto L7;
        Slog.e(TAG, "Invalid stream type. No update to IVolumeController", new Exception());
        return;
    L7:
        if (streamType2 == 3) goto L9;
    L11:
        this.mVolumeController.postVolumeChanged(streamType2, flags);
        return;
    L9:
        if (isFullVolumeDevice(device) == false) goto L11;
        flags = flags & (-2);
        goto L11
    }

    private int updateFlagsForTvPlatform(int flags) {
        Object r0 = this.mHdmiClientLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mHdmiTvClient != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return flags;
    L7:
        if (this.mHdmiSystemAudioSupported == false) goto L13;
        if (this.mHdmiCecVolumeControlEnabled == false) goto L13;
        flags = flags & (-2);     // Catch: Throwable -> L11
        goto L13
    }

    private void sendMasterMuteUpdate(boolean r10, int r11) {
        this.mVolumeController.postMasterMuteChanged(updateFlagsForTvPlatform(r11));
        sendMsg(this.mAudioHandler, 55, 2, r10 ? 1 : 0, 0, null, 0);
    }

    private void setStreamVolumeInt(int streamType, int index, int device, boolean force, String caller, boolean hasModifyAudioSettings) {
        if (isFullVolumeDevice(device) == false) goto L5;
        return;
    L5:
        VolumeStreamState streamState = getVssForStreamOrDefault(streamType);
        if (streamState.setIndex(index, device, caller, hasModifyAudioSettings) == true) goto L10;
        if (force == true) goto L10;
        return;
    L10:
        sendMsg(this.mAudioHandler, 0, 2, device, 0, streamState, 0);
    }

    public boolean isStreamMute(int streamType) {
        if (streamType != Integer.MIN_VALUE) goto L5;
        streamType = getActiveStreamType(streamType);
    L5:
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "isStreamMute");
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
        ensureValidStreamType(streamType2);     // Catch: Throwable -> L10
        boolean r1 = VolumeStreamState.m2126$$Nest$fgetmIsMuted(getVssForStreamOrDefault(streamType2));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean discardRmtSbmxFullVolDeathHandlerFor(IBinder cb) {
        Iterator<RmtSbmxFullVolDeathHandler> it = this.mRmtSbmxFullVolDeathHandlers.iterator();
    L4:
        if (it.hasNext() == false) goto L10;
        RmtSbmxFullVolDeathHandler handler = it.next();
        if (handler.isHandlerFor(cb) == false) goto L4;
        handler.forget();
        this.mRmtSbmxFullVolDeathHandlers.remove(handler);
        return true;
    L10:
        return false;
    }

    private boolean hasRmtSbmxFullVolDeathHandlerFor(IBinder cb) {
        Iterator<RmtSbmxFullVolDeathHandler> it = this.mRmtSbmxFullVolDeathHandlers.iterator();
    L4:
        if (it.hasNext() == false) goto L9;
        if (it.next().isHandlerFor(cb) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void forceRemoteSubmixFullVolume(boolean startForcing, IBinder cb) {
        if (cb != null) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CAPTURE_AUDIO_OUTPUT") == 0) goto L8;
        Log.w(TAG, "Trying to call forceRemoteSubmixFullVolume() without CAPTURE_AUDIO_OUTPUT");
        return;
    L8:
        ArrayList<RmtSbmxFullVolDeathHandler> r0 = this.mRmtSbmxFullVolDeathHandlers;
        monitor-enter(r0);
        boolean applyRequired = false;
        if (startForcing == false) goto L21;
        if (hasRmtSbmxFullVolDeathHandlerFor(cb) == true) goto L27;
        this.mRmtSbmxFullVolDeathHandlers.add(new RmtSbmxFullVolDeathHandler(this, cb));     // Catch: Throwable -> L17
        if (this.mRmtSbmxFullVolRefCount != 0) goto L19;
        this.mFullVolumeDevices.add(32768);     // Catch: Throwable -> L17
        this.mFixedVolumeDevices.add(32768);     // Catch: Throwable -> L17
        applyRequired = true;
    L19:
        this.mRmtSbmxFullVolRefCount++;     // Catch: Throwable -> L17
    L27:
        if (applyRequired == false) goto L29;
        checkAllFixedVolumeDevices(3);     // Catch: Throwable -> L17
        getVssForStreamOrDefault(3).applyAllVolumes();     // Catch: Throwable -> L17
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L21:
        if (discardRmtSbmxFullVolDeathHandlerFor(cb) == false) goto L27;
        if (this.mRmtSbmxFullVolRefCount <= 0) goto L27;
        this.mRmtSbmxFullVolRefCount--;     // Catch: Throwable -> L17
        if (this.mRmtSbmxFullVolRefCount != 0) goto L27;
        this.mFullVolumeDevices.remove(32768);     // Catch: Throwable -> L17
        this.mFixedVolumeDevices.remove(32768);     // Catch: Throwable -> L17
        applyRequired = true;
    L17:
        th = move-exception;
        throw th;
    }

    private void setMasterMuteInternal(boolean mute, int flags, String callingPackage, int uid, int userId, int pid, String attributionTag) {
        if (uid != 1000) goto L5;
        uid = UserHandle.getUid(userId, UserHandle.getAppId(uid));
    L5:
        if (mute == true) goto L10;
        if (checkNoteAppOp(33, uid, callingPackage, attributionTag) == true) goto L10;
        return;
    L10:
        if (userId != UserHandle.getCallingUserId()) goto L12;
    L14:
        setMasterMuteInternalNoCallerCheck(mute, flags, userId, "setMasterMute");
        return;
    L12:
        if (this.mContext.checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", pid, uid) == 0) goto L14;
    }

    private void setMasterMuteInternalNoCallerCheck(boolean mute, int flags, int userId, String eventSource) {
        Log.d(TAG, TextUtils.formatSimple("Master mute %s, flags 0x%x, userId=%d from %s", new Object[]{Boolean.valueOf(mute), Integer.valueOf(flags), Integer.valueOf(userId), eventSource}));
        if (isPlatformAutomotive() == true) goto L8;
        if (this.mUseFixedVolume == false) goto L8;
        mute = false;
    L8:
        if (isPlatformAutomotive() == false) goto L11;
        if (userId != 0) goto L11;
    L13:
        if (mute == this.mMasterMute.getAndSet(mute)) goto L17;
        sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(12, mute));
        this.mAudioSystem.setMasterMute(mute);
        sendMasterMuteUpdate(mute, flags);
        return;
    L17:
        return;
    L11:
        if (getCurrentUserId() == userId) goto L13;
    }

    public boolean isMasterMute() {
        return this.mMasterMute.get();
    }

    public void setMasterMute(boolean mute, int flags, String callingPackage, int userId, String attributionTag) {
        super.setMasterMute_enforcePermission();
        setMasterMuteInternal(mute, flags, callingPackage, Binder.getCallingUid(), userId, Binder.getCallingPid(), attributionTag);
    }

    public int getStreamVolume(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "getStreamVolume");
        ensureValidStreamType(streamType2);
        int device = getDeviceForStream(streamType2);
        return getStreamVolume(streamType2, device);
    }

    private int getStreamVolume(int streamType, int device) {
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
        VolumeStreamState vss = getVssForStreamOrDefault(streamType);     // Catch: Throwable -> L13
        int index = vss.getIndex(device);     // Catch: Throwable -> L13
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(vss) == false) goto L7;
        index = 0;
    L7:
        if (index != 0) goto L9;
    L15:
        int r3 = (index + 5) / 10;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L9:
        if (sStreamVolumeAlias.get(streamType) != 3) goto L15;
        if (isFixedVolumeDevice(device) == false) goto L15;
        index = vss.getMaxIndex();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public VolumeInfo getDeviceVolume(VolumeInfo vi, AudioDeviceAttributes ada, String callingPackage) {
        super.getDeviceVolume_enforcePermission();
        vi.getClass();
        ada.getClass();
        callingPackage.getClass();
        if (vi.hasStreamType() == true) goto L6;
        Log.e(TAG, "Unsupported non-stream type based VolumeInfo", new Exception());
        return getDefaultVolumeInfo();
    L6:
        int streamType = replaceBtScoStreamWithVoiceCall(vi.getStreamType(), "getStreamMaxVolume");
        VolumeInfo.Builder vib = new VolumeInfo.Builder(vi);
        VolumeStreamState vss = getVssForStream(streamType);
        if (vss != null) goto L10;
        Log.w(TAG, "getDeviceVolume unsupported stream type " + streamType + ". Return default");
        return getDefaultVolumeInfo();
    L10:
        vib.setMinVolumeIndex((VolumeStreamState.m2125$$Nest$fgetmIndexMin(vss) + 5) / 10);
        vib.setMaxVolumeIndex((VolumeStreamState.m2124$$Nest$fgetmIndexMax(vss) + 5) / 10);
        Object r3 = this.mVolumeStateLock;
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L13:
        if (isFixedVolumeDevice(ada.getInternalType()) == false) goto L17;
        int index = (VolumeStreamState.m2124$$Nest$fgetmIndexMax(vss) + 5) / 10;     // Catch: Throwable -> L15
    L18:
        vib.setVolumeIndex(index);     // Catch: Throwable -> L15
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(vss) == false) goto L21;
        vib.setMuted(true);     // Catch: Throwable -> L15
    L21:
        VolumeInfo r5 = vib.build();     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return r5;
    L17:
        index = (vss.getIndex(ada.getInternalType()) + 5) / 10;     // Catch: Throwable -> L15
        goto L18
    }

    public int getStreamMaxVolume(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "getStreamMaxVolume");
        ensureValidStreamType(streamType2);
        return (getVssForStreamOrDefault(streamType2).getMaxIndex() + 5) / 10;
    }

    public int getStreamMinVolume(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "getStreamMinVolume");
        ensureValidStreamType(streamType2);
        if (Binder.getCallingUid() != 1000) goto L5;
    L10:
        boolean isPrivileged = true;
    L12:
        return (getVssForStreamOrDefault(streamType2).getMinIndex(isPrivileged) + 5) / 10;
    L5:
        if (callingHasAudioSettingsPermission() == true) goto L10;
        if (this.mContext.checkCallingPermission("android.permission.MODIFY_AUDIO_ROUTING") == 0) goto L10;
        isPrivileged = false;
        goto L12
    }

    public int getLastAudibleStreamVolume(int streamType) {
        super.getLastAudibleStreamVolume_enforcePermission();
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "getLastAudibleStreamVolume");
        ensureValidStreamType(streamType2);
        int device = getDeviceForStream(streamType2);
        return (getVssForStreamOrDefault(streamType2).getIndex(device) + 5) / 10;
    }

    public VolumeInfo getDefaultVolumeInfo() {
        if (sDefaultVolumeInfo != null) goto L6;
        sDefaultVolumeInfo = new VolumeInfo.Builder(3).setMinVolumeIndex(getStreamMinVolume(3)).setMaxVolumeIndex(getStreamMaxVolume(3)).build();
    L6:
        return sDefaultVolumeInfo;
    }

    public void registerStreamAliasingDispatcher(IStreamAliasingDispatcher isad, boolean register) {
        super.registerStreamAliasingDispatcher_enforcePermission();
        isad.getClass();
        if (register == false) goto L5;
        this.mStreamAliasingDispatchers.register(isad);
        return;
    L5:
        this.mStreamAliasingDispatchers.unregister(isad);
    }

    protected void dispatchStreamAliasingUpdate() {
        int nbDispatchers = this.mStreamAliasingDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L9;
        this.mStreamAliasingDispatchers.getBroadcastItem(i).dispatchStreamAliasingChanged();     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error on stream alias update dispatch", e);
        goto L8
    L9:
        this.mStreamAliasingDispatchers.finishBroadcast();
    }

    public ArrayList<Integer> getIndependentStreamTypes() {
        super.getIndependentStreamTypes_enforcePermission();
        if (this.mUseVolumeGroupAliases == true) goto L5;
        ArrayList<Integer> res = new ArrayList(1);
        int streamIdx = 0;
    L8:
        if (streamIdx >= sStreamVolumeAlias.size()) goto L14;
        int streamAlias = sStreamVolumeAlias.valueAt(streamIdx);
        if (res.contains(Integer.valueOf(streamAlias)) == true) goto L12;
        res.add(Integer.valueOf(streamAlias));
    L12:
        streamIdx = streamIdx + 1;
        goto L8
    L14:
        return res;
    L5:
        return new ArrayList(Arrays.stream(AudioManager.getPublicStreamTypes()).boxed().toList());
    }

    public int getStreamTypeAlias(int sourceStreamType) {
        super.getStreamTypeAlias_enforcePermission();
        int sourceStreamType2 = replaceBtScoStreamWithVoiceCall(sourceStreamType, "getStreamTypeAlias");
        ensureValidStreamType(sourceStreamType2);
        return sStreamVolumeAlias.get(sourceStreamType2, -1);
    }

    public boolean isVolumeControlUsingVolumeGroups() {
        super.isVolumeControlUsingVolumeGroups_enforcePermission();
        return this.mUseVolumeGroupAliases;
    }

    public int getUiSoundsStreamType() {
        if (this.mUseVolumeGroupAliases == false) goto L6;
        return this.STREAM_VOLUME_ALIAS_VOICE[1];
    L6:
        return sStreamVolumeAlias.get(1);
    }

    private boolean isUiSoundsStreamType(int aliasStreamType) {
        if (this.mUseVolumeGroupAliases == false) goto L8;
        if (this.STREAM_VOLUME_ALIAS_VOICE[aliasStreamType] == this.STREAM_VOLUME_ALIAS_VOICE[1]) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (aliasStreamType == sStreamVolumeAlias.get(1)) goto L10;
        return false;
    L10:
        return true;
    }

    public void setInputGainIndex(AudioDeviceAttributes ada, int index) {
        super.setInputGainIndex_enforcePermission();
        if (this.mInputDeviceVolumeHelper.setInputGainIndex(ada, index) == false) goto L6;
        sendMsg(this.mAudioHandler, 105, 2, index, 0, ada, 0);
        return;
    }

    private void onApplyInputGainIndex(AudioDeviceAttributes ada, int index) {
        sendMsg(this.mAudioHandler, 106, 0, 0, 0, ada, 500);
    }

    private void onPersistInputGainIndex(AudioDeviceAttributes ada) {
        this.mInputDeviceVolumeHelper.persistInputGainIndex(ada);
    }

    public int getInputGainIndex(AudioDeviceAttributes ada) {
        super.getInputGainIndex_enforcePermission();
        return this.mInputDeviceVolumeHelper.getInputGainIndex(ada);
    }

    public int getMaxInputGainIndex() {
        super.getMaxInputGainIndex_enforcePermission();
        return this.mInputDeviceVolumeHelper.getMaxInputGainIndex();
    }

    public int getMinInputGainIndex() {
        super.getMinInputGainIndex_enforcePermission();
        return this.mInputDeviceVolumeHelper.getMinInputGainIndex();
    }

    public boolean isInputGainFixed(AudioDeviceAttributes ada) {
        super.isInputGainFixed_enforcePermission();
        return this.mInputDeviceVolumeHelper.isInputGainFixed(ada);
    }

    public void setMicrophoneMute(boolean on, String callingPackage, int userId, String attributionTag) {
        int uid = Binder.getCallingUid();
        if (uid != 1000) goto L5;
        uid = UserHandle.getUid(userId, UserHandle.getAppId(uid));
    L5:
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.mic").setUid(uid).set(MediaMetrics.Property.CALLING_PACKAGE, callingPackage).set(MediaMetrics.Property.EVENT, "setMicrophoneMute");
        MediaMetrics.Key r2 = MediaMetrics.Property.REQUEST;
        if (on == false) goto L8;
        String r3 = "mute";
    L9:
        MediaMetrics.Item mmi = r1.set(r2, r3);
        if (on == true) goto L16;
        if (checkNoteAppOp(44, uid, callingPackage, attributionTag) == true) goto L16;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "disallow unmuting").record();
        return;
    L16:
        if (checkAudioSettingsPermission("setMicrophoneMute()") == true) goto L20;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "!checkAudioSettingsPermission").record();
        return;
    L20:
        if (userId != UserHandle.getCallingUserId()) goto L22;
    L25:
        this.mMicMuteFromApi = on;
        mmi.record();
        setMicrophoneMuteNoCallerCheck(userId);
        return;
    L22:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L25;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "permission").record();
        return;
    L8:
        r3 = "unmute";
        goto L9
    }

    public void setMicrophoneMuteFromSwitch(boolean on) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L6;
        Log.e(TAG, "setMicrophoneMuteFromSwitch() called from non system user!");
        return;
    L6:
        this.mMicMuteFromSwitch = on;
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.mic").setUid(callingUid).set(MediaMetrics.Property.EVENT, "setMicrophoneMuteFromSwitch");
        MediaMetrics.Key r2 = MediaMetrics.Property.REQUEST;
        if (on == false) goto L9;
        String r3 = "mute";
    L10:
        r1.set(r2, r3).record();
        setMicrophoneMuteNoCallerCheck(UserHandle.getCallingUserId());
        return;
    L9:
        r3 = "unmute";
        goto L10
    }

    private void setMicMuteFromSwitchInput() {
        InputManager im = (InputManager) this.mContext.getSystemService(InputManager.class);
        int isMicMuted = im.isMicMuted();
        if (isMicMuted != (-1)) goto L5;
        return;
    L5:
        if (im.isMicMuted() == 0) goto L7;
        boolean r2 = true;
    L8:
        setMicrophoneMuteFromSwitch(r2);
        return;
    L7:
        r2 = false;
        goto L8
    }

    public boolean isMicrophoneMuted() {
        if (this.mMicMuteFromSystemCached == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mMicMuteFromPrivacyToggle == true) goto L7;
    L12:
        return true;
    L7:
        if (this.mMicMuteFromApi == true) goto L12;
        if (this.mMicMuteFromRestrictions == true) goto L12;
        if (this.mMicMuteFromSwitch == false) goto L13;
        goto L12
    }

    private boolean isMicrophoneSupposedToBeMuted() {
        if (this.mMicMuteFromSwitch == false) goto L5;
    L12:
        return true;
    L5:
        if (this.mMicMuteFromRestrictions == true) goto L12;
        if (this.mMicMuteFromApi == true) goto L12;
        if (this.mMicMuteFromPrivacyToggle == true) goto L12;
        return false;
    }

    private void setMicrophoneMuteNoCallerCheck(int userId) {
        boolean muted = isMicrophoneSupposedToBeMuted();
        Log.d(TAG, String.format("Mic mute %b, user=%d", new Object[]{Boolean.valueOf(muted), Integer.valueOf(userId)}));
        if (getCurrentUserId() == userId) goto L5;
        if (userId == 0) goto L5;
        return;
    L5:
        boolean currentMute = this.mAudioSystem.isMicrophoneMuted();
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        int ret = this.mAudioSystem.muteMicrophone(muted);     // Catch: Throwable -> L9
        this.mMicMuteFromSystemCached = this.mAudioSystem.isMicrophoneMuted();     // Catch: Throwable -> L9
        if (ret == 0) goto L11;
        Log.e(TAG, "Error changing mic mute state to " + muted + " current:" + this.mMicMuteFromSystemCached);     // Catch: Throwable -> L9
    L11:
        MediaMetrics.Item r2 = new MediaMetrics.Item("audio.mic").setUid(callingUid).set(MediaMetrics.Property.EVENT, "setMicrophoneMuteNoCallerCheck");     // Catch: Throwable -> L9
        MediaMetrics.Key r7 = MediaMetrics.Property.MUTE;     // Catch: Throwable -> L9
        if (this.mMicMuteFromSystemCached == false) goto L14;
        String r8 = "on";
    L15:
        MediaMetrics.Item r3 = r2.set(r7, r8);     // Catch: Throwable -> L9
        MediaMetrics.Key r9 = MediaMetrics.Property.REQUEST;     // Catch: Throwable -> L9
        if (muted == false) goto L18;
        String r10 = "mute";
    L19:
        r3.set(r9, r10).set(MediaMetrics.Property.STATUS, Integer.valueOf(ret)).record();     // Catch: Throwable -> L9
        if (muted == currentMute) goto L22;
        sendMsg(this.mAudioHandler, 30, 1, 0, 0, null, 0);     // Catch: Throwable -> L9
    L22:
        Binder.restoreCallingIdentity(identity);
        return;
    L18:
        r10 = "unmute";
        goto L19
    L14:
        r8 = "off";
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int getRingerModeExternal() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int r1 = this.mRingerModeExternal;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getRingerModeInternal() {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int r1 = this.mRingerMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void ensureValidRingerMode(int ringerMode) {
        if (isValidRingerMode(ringerMode) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Bad ringer mode " + ringerMode);
    }

    public boolean isValidRingerMode(int ringerMode) {
        if (ringerMode >= 0) goto L4;
    L6:
        return false;
    L4:
        if (ringerMode > 2) goto L6;
        return true;
    }

    public void setRingerModeExternal(int ringerMode, String caller) {
        if (this.mHardeningEnforcer.blockVolumeMethod(200, getPackageNameForUid(Binder.getCallingUid()), Binder.getCallingUid()) == false) goto L6;
        return;
    L6:
        if (isAndroidNPlus(caller) == true) goto L8;
    L14:
        setRingerMode(ringerMode, caller, true);
        return;
    L8:
        if (wouldToggleZenMode(ringerMode) == false) goto L14;
        if (this.mNm.isNotificationPolicyAccessGrantedForPackage(caller) == true) goto L14;
        throw new SecurityException("Not allowed to change Do Not Disturb state");
    }

    public void setRingerModeInternal(int ringerMode, String caller) {
        enforceVolumeController("setRingerModeInternal");
        setRingerMode(ringerMode, caller, false);
    }

    public void silenceRingerModeInternal(String reason) {
        VibrationEffect effect = null;
        int ringerMode = 0;
        int toastText = 0;
        int silenceRingerSetting = 0;
        if (this.mContext.getResources().getBoolean(R.bool.config_windowActionBarSupported) == false) goto L5;
        silenceRingerSetting = this.mSettings.getSecureIntForUser(this.mContentResolver, "volume_hush_gesture", 0, -2);
    L5:
        switch(silenceRingerSetting) {
            case 1: goto L8;
            case 2: goto L7;
            default: goto L9;
        };
    L7:
        effect = VibrationEffect.get(1);
        ringerMode = 0;
        toastText = 17042337;
        goto L9
    L8:
        effect = VibrationEffect.get(5);
        ringerMode = 1;
        toastText = 17042338;
    L9:
        maybeVibrate(effect, reason);
        setRingerModeInternal(ringerMode, reason);
        Toast.makeText(this.mContext, toastText, 0).show();
    }

    private boolean maybeVibrate(VibrationEffect effect, String reason) {
        if (this.mHasVibrator == true) goto L5;
        return false;
    L5:
        if (effect != null) goto L7;
        return false;
    L7:
        this.mVibrator.vibrate(Binder.getCallingUid(), this.mContext.getOpPackageName(), effect, reason, TOUCH_VIBRATION_ATTRIBUTES);
        return true;
    }

    private void setRingerMode(int r12, String r13, boolean r14) {
        if (this.mUseFixedVolume == true) goto L58;
        if (this.mIsSingleVolume == true) goto L58;
        if (this.mUseVolumeGroupAliases == true) goto L64;
        if (r13 == null) goto L56;
        if (r13.length() == 0) goto L56;
        ensureValidRingerMode(r12);
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.service.setRingerMode").setUid(Binder.getCallingUid()).set(MediaMetrics.Property.EVENT, "setRingerMode").set(MediaMetrics.Property.CLIENT_NAME, r13).set(MediaMetrics.Property.RINGER_MODE, Integer.valueOf(r12)).set(MediaMetrics.Property.IS_EXTERNAL, Integer.valueOf(r14 ? 1 : 0)).set(MediaMetrics.Property.ZEN_MODE, Integer.valueOf(this.mNm.getZenMode()));
        if (r12 == 1) goto L15;
    L17:
        int r4 = r12;
    L18:
        long r8 = Binder.clearCallingIdentity();
        Object r15 = this.mSettingsLock;     // Catch: Throwable -> L51
        monitor-enter(r15);     // Catch: Throwable -> L51
        int r3 = getRingerModeInternal();     // Catch: Throwable -> L30
        int r6 = getRingerModeExternal();     // Catch: Throwable -> L30
        r1.set(MediaMetrics.Property.OLD_RINGER_MODE_INTERNAL, Integer.valueOf(r3)).set(MediaMetrics.Property.OLD_RINGER_MODE_EXTERNAL, Integer.valueOf(r6));     // Catch: Throwable -> L30
        if (r14 == false) goto L36;
        setRingerModeExt(r4);     // Catch: Throwable -> L30
        if (this.mRingerModeDelegate == null) goto L33;
        int r16 = this.mRingerModeDelegate.onSetRingerModeExternal(r6, r4, r13, r3, this.mVolumePolicy);     // Catch: Throwable -> L28
        r3 = r3;
        r4 = r16;
    L33:
        if (r4 == r3) goto L42;
        setRingerModeInt(r4, true);     // Catch: Throwable -> L28
    L42:
        r1.set(MediaMetrics.Property.NEW_RINGER_MODE_INTERNAL, Integer.valueOf(getRingerModeInternal())).set(MediaMetrics.Property.NEW_RINGER_MODE_EXTERNAL, Integer.valueOf(getRingerModeExternal()));     // Catch: Throwable -> L28
        monitor-exit(r15);     // Catch: Throwable -> L28
        r1.record();     // Catch: Throwable -> L47
        Binder.restoreCallingIdentity(r8);
        return;
    L36:
        if (r4 == r3) goto L39;
        setRingerModeInt(r4, true);     // Catch: Throwable -> L28
    L39:
        if (this.mRingerModeDelegate == null) goto L41;
        r4 = this.mRingerModeDelegate.onSetRingerModeInternal(r3, r4, r13, r6, this.mVolumePolicy);     // Catch: Throwable -> L28
    L41:
        setRingerModeExt(r4);     // Catch: Throwable -> L28
    L30:
        th = move-exception;
        Throwable r17 = th;
    L49:
        monitor-exit(r15);     // Catch: Throwable -> L28
        throw r17;     // Catch: Throwable -> L47
    L28:
        th = move-exception;
        r17 = th;
    L47:
        th = move-exception;
        Throwable r18 = th;
    L53:
        Binder.restoreCallingIdentity(r8);
        throw r18;
    L51:
        th = move-exception;
        r18 = th;
        goto L53
    L15:
        if (this.mHasVibrator == true) goto L17;
        r4 = 0;
    L56:
        throw new IllegalArgumentException("Bad caller: " + r13);
    L64:
        return;
    }

    private void setRingerModeExt(int ringerMode) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (ringerMode != this.mRingerModeExternal) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mRingerModeExternal = ringerMode;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        broadcastRingerMode("android.media.RINGER_MODE_CHANGED", ringerMode);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:? -> B:85:0x013f). Please report as a decompilation issue!!! */
    private void muteRingerModeStreams() {
        int r2 = AudioSystem.getNumStreamTypes();
        if (this.mNm != null) goto L5;
        this.mNm = (NotificationManager) this.mContext.getSystemService("notification");
    L5:
        int r3 = this.mRingerMode;
        boolean r4 = true;
        if (r3 == 1) goto L10;
        if (r3 == 0) goto L10;
        boolean r5 = false;
    L12:
        if (r3 == 1) goto L14;
    L16:
        boolean r6 = false;
    L17:
        int r7 = 2;
        if (r3 == 1) goto L20;
    L24:
        boolean r8 = false;
    L25:
        String r16 = "muteRingerModeStreams() from u/pid:" + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid();
        if (r6 == false) goto L28;
        int r15 = 3;
    L31:
        sendMsg(this.mAudioHandler, 8, 2, 7, r15, r16, 0);
        int r9 = r2 - 1;
    L32:
        if (r9 < 0) goto L99;
        VolumeStreamState r10 = getVssForStream(r9);
        if (r10 != null) goto L36;
        int r24 = r2;
        int r25 = r3;
        boolean r11 = r4;
    L98:
        r9 = r9 - 1;
        r4 = r11;
        r2 = r24;
        r3 = r25;
        r7 = 2;
        goto L32
    L36:
        boolean r12 = isStreamMutedByRingerOrZenMode(r9);
        if (r6 == true) goto L39;
        if (r8 == true) goto L39;
    L40:
        boolean r13 = r4;
    L43:
        if (isStreamAffectedByCurrentZen(r9) == true) goto L50;
        if (r5 == true) goto L46;
    L49:
        boolean r14 = false;
    L52:
        if (r12 != r14) goto L54;
        r24 = r2;
        r25 = r3;
        r11 = r4;
        goto L98
    L54:
        if (r14 == false) goto L56;
        r24 = r2;
        r25 = r3;
        r11 = r4;
        sRingerAndZenModeMutedStreams |= (r11 ? 1 : 0) << r9;
        r10.mute(r11, "muteRingerModeStreams");
        goto L98
    L56:
        if (this.mASExt.muteRingerModeStreams_shouldStreamNotBeZero(sStreamVolumeAlias, r9) == false) goto L95;
        Object r17 = this.mVolumeStateLock;
        monitor-enter(r17);
        int r0 = 0;
    L109:
        if (r0 >= VolumeStreamState.m2123$$Nest$fgetmIndexMap(r10).size()) goto L78;
        int r18 = VolumeStreamState.m2123$$Nest$fgetmIndexMap(r10).keyAt(r0);     // Catch: Throwable -> L76
        int r26 = r2;
        if (VolumeStreamState.m2123$$Nest$fgetmIndexMap(r10).valueAt(r0) != 0) goto L75;
        r10.setIndex(10, r18, TAG, true);     // Catch: Throwable -> L70
    L70:
        th = th;
    L93:
        monitor-exit(r17);     // Catch: Throwable -> L85
        throw th;
    L85:
        th = th;
    L75:
        r0 = r0 + 1;
        r2 = r26;
        r3 = r3;
    L72:
        th = th;
    L76:
        th = th;
        goto L93
    L78:
        r24 = r2;
        r25 = r3;
        sendMsg(this.mAudioHandler, 1, 2, getDeviceForStream(r9), 0, r10, 500);     // Catch: Throwable -> L87
        VolumeStreamState r19 = r10;
        monitor-exit(r17);     // Catch: Throwable -> L85
    L96:
        r11 = true;
        sRingerAndZenModeMutedStreams &= ~(1 << r9);
        r19.mute(false, "muteRingerModeStreams");
    L87:
        th = th;
    L89:
        th = th;
    L91:
        th = th;
        goto L93
    L95:
        r24 = r2;
        r25 = r3;
        r19 = r10;
        goto L96
    L46:
        if (isStreamAffectedByRingerMode(r9) == false) goto L49;
        if (r13 == false) goto L49;
    L50:
        r14 = r4;
    L39:
        if (r9 != r7) goto L40;
        r13 = false;
        goto L43
    L99:
        sMuteLogger.enqueue(new AudioServiceEvents.RingerZenMutedStreamsEvent(sRingerAndZenModeMutedStreams, "muteRingerModeStreams"));
        return;
    L28:
        if (r8 == false) goto L30;
        r15 = 16;
        goto L31
    L30:
        r15 = 0;
        goto L31
    L20:
        if (this.mBtCommDeviceActive.get() != 2) goto L22;
    L23:
        r8 = true;
        goto L25
    L22:
        if (this.mBtCommDeviceActive.get() != 4) goto L24;
    L14:
        if (this.mBtCommDeviceActive.get() != 1) goto L16;
        r6 = true;
    L10:
        r5 = true;
        goto L12
    }

    private boolean isAlarm(int streamType) {
        if (streamType != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isNotificationOrRinger(int streamType) {
        if (streamType != 5) goto L5;
    L8:
        return true;
    L5:
        if (streamType == 2) goto L8;
        return false;
    }

    private boolean isMedia(int streamType) {
        if (streamType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSystem(int streamType) {
        if (streamType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setRingerModeInt(int ringerMode, boolean persist) {
        Object r1 = this.mSettingsLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mRingerMode == ringerMode) goto L7;
        boolean change = true;
    L8:
        this.mRingerMode = ringerMode;     // Catch: Throwable -> L15
        muteRingerModeStreams();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (persist == false) goto L12;
        sendMsg(this.mAudioHandler, 3, 0, 0, 0, null, 500);
    L12:
        if (change == false) goto L20;
        broadcastRingerMode("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION", ringerMode);
        return;
    L20:
        return;
    L7:
        change = false;
        goto L8
    }

    void postUpdateRingerModeServiceInt() {
        sendMsg(this.mAudioHandler, 25, 2, 0, 0, null, 0);
    }

    private void onUpdateRingerModeServiceInt() {
        setRingerModeInt(getRingerModeInternal(), false);
    }

    public boolean shouldVibrate(int vibrateType) {
        if (this.mHasVibrator == true) goto L6;
        return false;
    L6:
        switch(getVibrateSetting(vibrateType)) {
            case 0: goto L16;
            case 1: goto L13;
            case 2: goto L9;
            default: goto L7;
        };
    L7:
        return false;
    L16:
        return false;
    L9:
        if (getRingerModeExternal() == 1) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (getRingerModeExternal() != 0) goto L15;
        return false;
    L15:
        return true;
    }

    public int getVibrateSetting(int vibrateType) {
        if (this.mHasVibrator == true) goto L7;
        return 0;
    L7:
        return (this.mVibrateSetting >> (vibrateType * 2)) & 3;
    }

    public void setVibrateSetting(int vibrateType, int vibrateSetting) {
        if (this.mHasVibrator == true) goto L5;
        return;
    L5:
        this.mVibrateSetting = AudioSystem.getValueForVibrateSetting(this.mVibrateSetting, vibrateType, vibrateSetting);
        broadcastVibrateSetting(vibrateType);
    }

    private SetModeDeathHandler getAudioModeOwnerHandler() {
        SetModeDeathHandler modeOwner = null;
        SetModeDeathHandler privilegedModeOwner = null;
        Iterator<SetModeDeathHandler> r2 = this.mSetModeDeathHandlers.iterator();
    L4:
        if (r2.hasNext() == false) goto L18;
        SetModeDeathHandler h = r2.next();
        if (h.isActive() == false) goto L4;
        if (h.isPrivileged() == true) goto L9;
        if (modeOwner == null) goto L16;
        if (h.getUpdateTime() <= modeOwner.getUpdateTime()) goto L4;
    L16:
        modeOwner = h;
        goto L4
    L9:
        if (privilegedModeOwner == null) goto L12;
        if (h.getUpdateTime() <= privilegedModeOwner.getUpdateTime()) goto L4;
    L12:
        privilegedModeOwner = h;
        goto L4
    L18:
        if (privilegedModeOwner == null) goto L21;
        return privilegedModeOwner;
    L21:
        return modeOwner;
    }

    AudioDeviceBroker.AudioModeInfo getAudioModeOwner() {
        SetModeDeathHandler hdlr = getAudioModeOwnerHandler();
        if (hdlr == null) goto L7;
        return new AudioDeviceBroker.AudioModeInfo(hdlr.getMode(), hdlr.getPid(), hdlr.getUid());
    L7:
        return new AudioDeviceBroker.AudioModeInfo(0, 0, 0);
    }

    int getModeOwnerUid() {
        SetModeDeathHandler hdlr = getAudioModeOwnerHandler();
        if (hdlr != null) goto L5;
        return 0;
    L5:
        return hdlr.getUid();
    }

    public void setMode(int mode, IBinder cb, String callingPackage) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        Log.v(TAG, "setMode(mode=" + mode + ", pid=" + pid + ", uid=" + uid + ", caller=" + callingPackage + ")");
        if (checkAudioSettingsPermission("setMode()") == true) goto L5;
        return;
    L5:
        if (cb != null) goto L9;
        Log.e(TAG, "setMode() called with null binder");
        return;
    L9:
        if (mode < (-1)) goto L112;
        if (mode >= 7) goto L112;
        if (mode != (-1)) goto L15;
        int mode2 = getMode();
    L17:
        if (mode2 != 4) goto L23;
        if (this.mIsCallScreeningModeSupported == true) goto L23;
        Log.w(TAG, "setMode(MODE_CALL_SCREENING) not permitted when call screening is not supported");
        return;
    L23:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L25;
        boolean hasModifyPhoneStatePermission = true;
    L27:
        if (mode2 != 2) goto L29;
    L32:
        if (hasModifyPhoneStatePermission == true) goto L35;
        Log.w(TAG, "MODIFY_PHONE_STATE Permission Denial: setMode(" + AudioSystem.modeToString(mode2) + ") from pid=" + pid + ", uid=" + Binder.getCallingUid());
        return;
    L35:
        Object r10 = this.mDeviceBroker.mSetModeLock;
        monitor-enter(r10);
        Iterator<SetModeDeathHandler> r0 = this.mSetModeDeathHandlers.iterator();     // Catch: Throwable -> L107
    L38:
        if (r0.hasNext() == false) goto L46;
        SetModeDeathHandler h = r0.next();     // Catch: Throwable -> L44
        if (h.getPid() != pid) goto L38;
    L124:
        if (mode2 != 0) goto L63;
        if (h != null) goto L51;
    L62:
        hasModifyPhoneStatePermission = hasModifyPhoneStatePermission;
        SetModeDeathHandler currentModeHandler = h;
    L86:
        if (hasModifyPhoneStatePermission == false) goto L89;
        if (mode2 != 0) goto L89;
        boolean r6 = true;
    L116:
        postUpdateAudioMode(0, mode2, pid, callingPackage, r6, 0);     // Catch: Throwable -> L95
        monitor-exit(r10);     // Catch: Throwable -> L80
        return;
    L80:
        e = th;
    L109:
        monitor-exit(r10);     // Catch: Throwable -> L97
        throw e;
    L95:
        e = th;
    L89:
        r6 = false;
        goto L116
    L51:
        if (h.isPrivileged() == false) goto L53;
    L57:
        this.mSetModeDeathHandlers.remove(h);     // Catch: Throwable -> L55
        Log.v(TAG, "setMode(" + mode2 + ") removing hldr for pid: " + pid);     // Catch: Throwable -> L55
        h.getBinder().unlinkToDeath(h, 0);     // Catch: Throwable -> L55 NoSuchElementException -> L60
    L61:
        Log.w(TAG, "setMode link does not exist ...");     // Catch: Throwable -> L55
        goto L62
    L53:
        if (h.getMode() != 3) goto L57;
        this.mAudioHandler.removeEqualMessages(31, h);     // Catch: Throwable -> L55
        goto L57
    L63:
        if (h == null) goto L132;
        h.setMode(mode2);     // Catch: Throwable -> L55
        Log.v(TAG, "setMode(" + mode2 + ") updating hldr for pid: " + pid);     // Catch: Throwable -> L55
    L73:
        if (mode2 == 3) goto L114;
        currentModeHandler = h;
        goto L86
    L114:
    L82:
        e = th;
        goto L109
    L75:
        if (h.isPrivileged() == true) goto L84;
        h.setPlaybackActive(true);     // Catch: Throwable -> L82
        h.setRecordingActive(true);     // Catch: Throwable -> L82
        currentModeHandler = h;
        sendMsg(this.mAudioHandler, 31, 2, 0, 0, currentModeHandler, 6000);     // Catch: Throwable -> L80
        goto L86
    L84:
        currentModeHandler = h;
        goto L86
    L132:
        SetModeDeathHandler currentModeHandler2 = new SetModeDeathHandler(this, cb, pid, uid, hasModifyPhoneStatePermission, callingPackage, mode2);     // Catch: Throwable -> L103
        cb.linkToDeath(currentModeHandler2, 0);     // Catch: Throwable -> L97 RemoteException -> L99
        this.mSetModeDeathHandlers.add(currentModeHandler2);     // Catch: Throwable -> L97
        Log.v(TAG, "setMode(" + mode2 + ") adding handler for pid=" + pid);     // Catch: Throwable -> L97
        h = currentModeHandler2;
        goto L73
    L100:
        Log.w(TAG, "setMode() could not link to " + cb + " binder death");     // Catch: Throwable -> L97
        return;
    L103:
        e = th;
    L105:
        e = th;
    L55:
        e = th;
    L44:
        e = th;
        goto L109
    L46:
        h = null;
    L107:
        e = th;
    L97:
        e = th;
        goto L109
    L29:
        if (mode2 == 5) goto L32;
        if (mode2 != 6) goto L35;
    L25:
        hasModifyPhoneStatePermission = false;
        goto L27
    L15:
        mode2 = mode;
    L112:
        Log.w(TAG, "setMode() invalid mode: " + mode);
    }

    void onUpdateAudioMode(int requestedMode, int requesterPid, String requesterPackage, boolean force, boolean signal) {
        if (requestedMode != (-1)) goto L5;
        int requestedMode2 = getMode();
    L6:
        int uid = 0;
        SetModeDeathHandler currentModeHandler = getAudioModeOwnerHandler();
        if (currentModeHandler == null) goto L9;
        int mode = currentModeHandler.getMode();
        uid = currentModeHandler.getUid();
        int pid = currentModeHandler.getPid();
        int mode2 = mode;
        int pid2 = pid;
    L10:
        Log.v(TAG, "onUpdateAudioMode() new mode: " + mode2 + ", current mode: " + this.mMode.get() + " requested mode: " + requestedMode2 + " signal: " + signal);
        if (mode2 != this.mMode.get()) goto L16;
        if (force == true) goto L16;
        int requestedMode3 = requestedMode2;
        this.mASExt.onUpdateAudioMode_afterSetMode(mode2, pid2, uid, this.mModeOwnerInDeviceBroker, requesterPid, requesterPackage, requestedMode3, this.mModeLogger);
        return;
    L16:
        long identity = Binder.clearCallingIdentity();
        int status = this.mAudioSystem.setPhoneState(mode2, uid);     // Catch: Throwable -> L27
        Binder.restoreCallingIdentity(identity);
        if (status != 0) goto L24;
        Log.v(TAG, "onUpdateAudioMode: mode successfully set to " + mode2);
        sendMsg(this.mAudioHandler, 40, 0, mode2, 0, null, 0);
        this.mMode.getAndSet(mode2);
        int mode3 = mode2;
        int pid3 = pid2;
        this.mModeLogger.enqueue(new AudioServiceEvents.PhoneStateEvent(requesterPackage, requesterPid, requestedMode2, pid3, mode3));
        int streamType = getActiveStreamType(Integer.MIN_VALUE);
        int device = getDeviceForStream(streamType);
        int streamAlias = sStreamVolumeAlias.get(streamType, -1);
        if (streamAlias != (-1)) goto L23;
        Log.e(TAG, "onUpdateAudioMode: no stream vol alias for stream type " + streamType);
    L23:
        Log.v(TAG, "onUpdateAudioMode: streamType=" + streamType + ", streamAlias=" + streamAlias);
        int index = getVssForStreamOrDefault(streamAlias).getIndex(device);
        setStreamVolumeInt(streamAlias, index, device, true, requesterPackage, true);
        updateStreamVolumeAlias(true, requesterPackage);
        onUpdateContextualVolumes();
        this.mDeviceBroker.postSetModeOwner(mode3, pid3, uid, signal);
        this.mModeOwnerInDeviceBroker.set(pid3);
        return;
    L24:
        resetAudioModeResetCount();
        Log.w(TAG, "onUpdateAudioMode: failed to set audio mode to: " + mode2);
        return;
    L27:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L9:
        mode2 = 0;
        pid2 = 0;
        goto L10
    L5:
        requestedMode2 = requestedMode;
        goto L6
    }

    public int getMode() {
        Object r0 = this.mDeviceBroker.mSetModeLock;
        monitor-enter(r0);
        SetModeDeathHandler currentModeHandler = getAudioModeOwnerHandler();     // Catch: Throwable -> L9
        if (currentModeHandler == null) goto L11;
        int r2 = currentModeHandler.getMode();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isCallScreeningModeSupported() {
        return this.mIsCallScreeningModeSupported;
    }

    protected void dispatchMode(int mode) {
        int nbDispatchers = this.mModeDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L8;
        this.mModeDispatchers.getBroadcastItem(i).dispatchAudioModeChanged(mode);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mModeDispatchers.finishBroadcast();
    }

    public void registerModeDispatcher(IAudioModeDispatcher dispatcher) {
        this.mModeDispatchers.register(dispatcher);
    }

    public void unregisterModeDispatcher(IAudioModeDispatcher dispatcher) {
        this.mModeDispatchers.unregister(dispatcher);
    }

    public boolean isPstnCallAudioInterceptable() {
        super.isPstnCallAudioInterceptable_enforcePermission();
        boolean uplinkDeviceFound = false;
        boolean downlinkDeviceFound = false;
        AudioDeviceInfo[] devices = AudioManager.getDevicesStatic(3);
        int r3 = devices.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L15;
        AudioDeviceInfo device = devices[r5];
        if (device.getInternalType() != 65536) goto L8;
        uplinkDeviceFound = true;
    L10:
        if (uplinkDeviceFound == false) goto L14;
        if (downlinkDeviceFound == false) goto L14;
        return true;
    L14:
        r5 = r5 + 1;
        goto L3
    L8:
        if (device.getInternalType() != (-2147483584)) goto L10;
        downlinkDeviceFound = true;
        goto L10
    L15:
        return false;
    }

    public void setRttEnabled(boolean rttEnabled) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto L6;
        Log.w(TAG, "MODIFY_PHONE_STATE Permission Denial: setRttEnabled from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
        return;
    L6:
        monitor-enter(this);
        this.mRttEnabled.set(rttEnabled);     // Catch: Throwable -> L12
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L12
        AudioSystem.setRttEnabled(rttEnabled);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    protected boolean isRttEnabled() {
        return this.mRttEnabled.get();
    }

    public void adjustSuggestedStreamVolumeForUid(int streamType, int direction, int flags, String packageName, int uid, int pid, UserHandle userHandle, int targetSdkVersion) {
        if (Binder.getCallingUid() != 1000) goto L7;
        adjustSuggestedStreamVolume(direction, streamType, flags, packageName, packageName, uid, pid, hasAudioSettingsPermission(uid, pid), 0);
        return;
    L7:
        throw new SecurityException("Should only be called from system process");
    }

    public void adjustStreamVolumeForUid(int streamType, int direction, int flags, String packageName, int uid, int pid, UserHandle userHandle, int targetSdkVersion) {
        if (Binder.getCallingUid() != 1000) goto L9;
        if (direction == 0) goto L6;
        sVolumeLogger.enqueue(new AudioServiceEvents.VolumeEvent(5, streamType, direction, flags, packageName + " uid:" + uid));
    L6:
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.service.adjustStreamVolumeForUid").setUid(Binder.getCallingUid()).set(MediaMetrics.Property.STREAM_TYPE, AudioSystem.streamToString(streamType)).set(MediaMetrics.Property.EVENT, "adjustStreamVolumeForUid").set(MediaMetrics.Property.CALLING_PACKAGE, packageName).set(MediaMetrics.Property.DIRECTION, this.mASExt.getMediaMetricsValueByDirection(direction)).set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags));
        mMmi.set(mmi);
        adjustStreamVolume(streamType, direction, flags, packageName, packageName, uid, pid, null, hasAudioSettingsPermission(uid, pid), 0);
        return;
    L9:
        throw new SecurityException("Should only be called from system process");
    }

    public void adjustVolume(int direction, int flags) {
        if (this.mHardeningEnforcer.blockVolumeMethod(101, getPackageNameForUid(Binder.getCallingUid()), Binder.getCallingUid()) == false) goto L5;
        return;
    L5:
        getMediaSessionManager().dispatchAdjustVolume(Integer.MIN_VALUE, direction, flags);
    }

    public void adjustSuggestedStreamVolume(int direction, int suggestedStreamType, int flags) {
        if (this.mHardeningEnforcer.blockVolumeMethod(102, getPackageNameForUid(Binder.getCallingUid()), Binder.getCallingUid()) == false) goto L5;
        return;
    L5:
        getMediaSessionManager().dispatchAdjustVolume(suggestedStreamType, direction, flags);
    }

    public void setStreamVolumeForUid(int streamType, int index, int flags, String packageName, int uid, int pid, UserHandle userHandle, int targetSdkVersion) {
        if (Binder.getCallingUid() != 1000) goto L7;
        setStreamVolume(streamType, index, flags, null, packageName, packageName, null, uid, hasAudioSettingsPermission(uid, pid), true);
        return;
    L7:
        throw new SecurityException("Should only be called from system process");
    }

    public void playSoundEffect(int effectType, int userId) {
        if (querySoundEffectsEnabled(userId) == false) goto L6;
        playSoundEffectVolume(effectType, -1.0f);
        return;
    }

    private boolean querySoundEffectsEnabled(int user) {
        if (this.mSettings.getSystemIntForUser(getContentResolver(), "sound_effects_enabled", 0, user) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public void playSoundEffectVolume(int effectType, float volume) {
        if (isStreamMute(1) == false) goto L6;
        return;
    L6:
        if (effectType >= 16) goto L12;
        if (effectType < 0) goto L12;
        sendMsg(this.mAudioHandler, 5, 2, effectType, (int) (1000.0f * volume), null, 0);
        return;
    L12:
        Log.w(TAG, "AudioService effectType value " + effectType + " out of range");
    }

    public boolean loadSoundEffects() {
        LoadSoundEffectReply reply = new LoadSoundEffectReply(null);
        sendMsg(this.mAudioHandler, 7, 2, 0, 0, reply, 0);
        return reply.waitForLoaded(3);
    }

    protected void scheduleLoadSoundEffects() {
        sendMsg(this.mAudioHandler, 7, 2, 0, 0, null, 0);
    }

    public void unloadSoundEffects() {
        sendMsg(this.mAudioHandler, 15, 2, 0, 0, null, 0);
    }

    public void reloadAudioSettings() {
        readAudioSettings(false);
    }

    private void readAudioSettings(boolean userSwitch) {
        readPersistedSettings();
        readUserRestrictions();
        int numStreamTypes = AudioSystem.getNumStreamTypes();
        int streamType = 0;
    L4:
        if (streamType >= numStreamTypes) goto L30;
        VolumeStreamState streamState = getVssForStream(streamType);
        if (streamState == null) goto L27;
        if (userSwitch == true) goto L10;
    L12:
        streamState.readSettings();
        Object r4 = this.mVolumeStateLock;
        monitor-enter(r4);
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(streamState) == true) goto L17;
    L26:
        monitor-exit(r4);     // Catch: Throwable -> L21
        goto L27
    L17:
        if (isStreamAffectedByMute(streamType) == true) goto L24;
        if (isStreamMutedByRingerOrZenMode(streamType) == true) goto L24;
    L25:
        VolumeStreamState.m2128$$Nest$fputmIsMuted(streamState, false);     // Catch: Throwable -> L21
    L24:
        if (this.mUseFixedVolume == false) goto L26;
    L21:
        th = move-exception;
        throw th;
    L10:
        if (sStreamVolumeAlias.get(streamType) != 3) goto L12;
    L27:
        streamType = streamType + 1;     // Catch: Throwable -> L21
        goto L4
    L30:
        readVolumeGroupsSettings(userSwitch);
        setRingerModeInt(getRingerModeInternal(), false);
        checkAllFixedVolumeDevices();
        checkAllAliasStreamVolumes();
        checkMuteAffectedStreams();
        this.mSoundDoseHelper.restoreMusicActiveMs();
        if (userSwitch == false) goto L33;
        this.mSoundDoseHelper.resetMusicActiveMs();
    L33:
        this.mSoundDoseHelper.enforceSafeMediaVolumeIfActive(TAG);
        Log.d(TAG, "Restoring device volume behavior");
        restoreDeviceVolumeBehavior();
    }

    public int[] getAvailableCommunicationDeviceIds() {
        List<AudioDeviceInfo> commDevices = AudioDeviceBroker.getAvailableCommunicationDevices();
        return commDevices.stream().mapToInt(new AudioService$$ExternalSyntheticLambda7()).toArray();
    }

    public boolean setCommunicationDevice(IBinder cb, int portId, AttributionSource attributionSource) {
        boolean r0 = false;
        if (attributionSource != null) goto L5;
        return false;
    L5:
        int uid = attributionSource.getUid();
        int pid = attributionSource.getPid();
        if (portId == 0) goto L20;
        AudioDeviceInfo device = AudioManager.getDeviceForPortId(portId, 2);
        if (device != null) goto L12;
        Log.w(TAG, "setCommunicationDevice: invalid portID " + portId);
        return false;
    L12:
        if (AudioDeviceBroker.isValidCommunicationDevice(device) == false) goto L14;
        AudioDeviceInfo device2 = device;
    L21:
        StringBuilder r4 = new StringBuilder();
        if (device2 != null) goto L24;
        String r5 = "clearCommunicationDevice(";
    L25:
        r4.append(r5);
        r4.append(") from u/pid:");
        r4.append(uid);
        r4.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        r4.append(pid);
        String eventSource = r4.toString();
        int deviceType = 1073741824;
        String deviceAddress = null;
        if (device2 == null) goto L28;
        deviceType = device2.getPort().type();
        deviceAddress = device2.getAddress();
    L32:
        if (deviceType == 1073741824) goto L39;
        MediaMetrics.Item r6 = new MediaMetrics.Item("audio.device.setCommunicationDevice").set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(deviceType)).set(MediaMetrics.Property.ADDRESS, deviceAddress);
        MediaMetrics.Key r7 = MediaMetrics.Property.STATE;
        if (device2 == null) goto L36;
        String r8 = "connected";
    L37:
        r6.set(r7, r8).record();
        goto L39
    L36:
        r8 = "disconnected";
    L39:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L41;
        r0 = true;
    L41:
        boolean isPrivileged = r0;
        long ident = Binder.clearCallingIdentity();
        boolean r1 = this.mDeviceBroker.setCommunicationDevice(cb, attributionSource, device2, isPrivileged, eventSource);     // Catch: Throwable -> L45
        Binder.restoreCallingIdentity(ident);
        return r1;
    L45:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L28:
        AudioDeviceInfo curDevice = this.mDeviceBroker.getCommunicationDevice();
        if (curDevice == null) goto L32;
        deviceType = curDevice.getPort().type();
        deviceAddress = curDevice.getAddress();
        goto L32
    L24:
        r5 = "setCommunicationDevice(";
        goto L25
    L14:
        if (device.isSink() == true) goto L18;
        throw new IllegalArgumentException("device must have sink role");
    L18:
        throw new IllegalArgumentException("invalid device type: " + device.getType());
    L20:
        device2 = null;
        goto L21
    }

    public int getCommunicationDevice() {
        long ident = Binder.clearCallingIdentity();
        AudioDeviceInfo device = this.mDeviceBroker.getCommunicationDevice();     // Catch: Throwable -> L7
        if (device == null) goto L9;
        int deviceId = device.getId();     // Catch: Throwable -> L7
    L10:
        Binder.restoreCallingIdentity(ident);
        return deviceId;
    L9:
        deviceId = 0;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void registerCommunicationDeviceDispatcher(ICommunicationDeviceDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        this.mDeviceBroker.registerCommunicationDeviceDispatcher(dispatcher);
    }

    public void unregisterCommunicationDeviceDispatcher(ICommunicationDeviceDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        this.mDeviceBroker.unregisterCommunicationDeviceDispatcher(dispatcher);
    }

    public void setSpeakerphoneOn(IBinder cb, boolean on, AttributionSource attributionSource) {
        if (attributionSource != null) goto L5;
        return;
    L5:
        if (checkAudioSettingsPermission("setSpeakerphoneOn()") == true) goto L8;
        return;
    L8:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L10;
        boolean r0 = true;
    L11:
        boolean isPrivileged = r0;
        int uid = attributionSource.getUid();
        int pid = attributionSource.getPid();
        String eventSource = "setSpeakerphoneOn(" + on + ") from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid;
        Log.i(TAG, "In setSpeakerphoneOn(), on: " + on + ", eventSource: " + eventSource);
        MediaMetrics.Item r1 = new MediaMetrics.Item("audio.device.setSpeakerphoneOn").setUid(uid).setPid(pid);
        MediaMetrics.Key r2 = MediaMetrics.Property.STATE;
        if (on == false) goto L14;
        String r3 = "on";
    L15:
        r1.set(r2, r3).record();
        long ident = Binder.clearCallingIdentity();
        this.mDeviceBroker.setSpeakerphoneOn(cb, attributionSource, on, isPrivileged, eventSource);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(ident);
        return;
    L21:
        th = move-exception;
        Throwable r12 = th;
    L25:
        Binder.restoreCallingIdentity(ident);
        throw r12;
    L23:
        th = move-exception;
        r12 = th;
        goto L25
    L14:
        r3 = "off";
        goto L15
    L10:
        r0 = false;
        goto L11
    }

    public boolean isSpeakerphoneOn() {
        return this.mDeviceBroker.isSpeakerphoneOn();
    }

    public void setBluetoothScoOn(boolean on) {
        if (checkAudioSettingsPermission("setBluetoothScoOn()") == true) goto L6;
        return;
    L6:
        if (UserHandle.getCallingAppId() < 10000) goto L9;
        Log.i(TAG, "In setBluetoothScoOn(), on: " + on + ". The calling application Uid: " + Binder.getCallingUid() + ", is greater than FIRST_APPLICATION_UID exiting from setBluetoothScoOn()");
        this.mBtScoOnByApp = on;
        return;
    L9:
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String eventSource = "setBluetoothScoOn(" + on + ") from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid;
        Log.i(TAG, "In setBluetoothScoOn(), eventSource: " + eventSource);
        MediaMetrics.Item r2 = new MediaMetrics.Item("audio.device.setBluetoothScoOn").setUid(uid).setPid(pid);
        MediaMetrics.Key r4 = MediaMetrics.Property.STATE;
        if (on == false) goto L12;
        String r5 = "on";
    L13:
        r2.set(r4, r5).record();
        this.mDeviceBroker.setBluetoothScoOnExternal(on, eventSource);
        return;
    L12:
        r5 = "off";
        goto L13
    }

    public void setA2dpSuspended(boolean enable) {
        super.setA2dpSuspended_enforcePermission();
        String eventSource = "setA2dpSuspended(" + enable + ") from u/pid:" + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid();
        this.mDeviceBroker.setA2dpSuspended(enable, false, eventSource);
    }

    public void setLeAudioSuspended(boolean enable) {
        super.setLeAudioSuspended_enforcePermission();
        String eventSource = "setLeAudioSuspended(" + enable + ") from u/pid:" + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid();
        this.mDeviceBroker.setLeAudioSuspended(enable, false, eventSource);
    }

    public boolean isBluetoothScoOn() {
        if (this.mBtScoOnByApp == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDeviceBroker.isBluetoothScoOn() == true) goto L8;
        return false;
    }

    public void setBluetoothA2dpOn(boolean on) {
        if (checkAudioSettingsPermission("setBluetoothA2dpOn()") == true) goto L5;
        return;
    L5:
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        String eventSource = "setBluetoothA2dpOn(" + on + ") from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid + " src:AudioService.setBtA2dpOn";
        MediaMetrics.Item r3 = new MediaMetrics.Item("audio.device.setBluetoothA2dpOn").setUid(uid).setPid(pid);
        MediaMetrics.Key r4 = MediaMetrics.Property.STATE;
        if (on == false) goto L8;
        String r5 = "on";
    L9:
        r3.set(r4, r5).record();
        this.mDeviceBroker.setBluetoothA2dpOn_Async(on, eventSource);
        return;
    L8:
        r5 = "off";
        goto L9
    }

    public boolean isBluetoothA2dpOn() {
        return this.mDeviceBroker.isBluetoothA2dpOn();
    }

    public void setSwbParameters(String keyValuePairs) {
        this.mDeviceBroker.setSwbParameters(keyValuePairs);
    }

    public void setScoParameters(String name, boolean hasNrecEnabled, boolean hasWbsEnabled) {
        this.mDeviceBroker.setScoParameters(name, hasNrecEnabled, hasWbsEnabled);
    }

    public void startBluetoothSco(IBinder cb, int targetSdkVersion, AttributionSource attributionSource) {
        Log.i(TAG, "In startBluetoothSco()");
        if (attributionSource != null) goto L6;
        return;
    L6:
        if (checkAudioSettingsPermission("startBluetoothSco()") == true) goto L8;
        return;
    L8:
        int uid = attributionSource.getUid();
        int pid = attributionSource.getPid();
        if (targetSdkVersion >= 18) goto L11;
        int scoAudioMode = 0;
    L12:
        String eventSource = "startBluetoothSco()) from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid;
        new MediaMetrics.Item("audio.bluetooth").setUid(uid).setPid(pid).set(MediaMetrics.Property.EVENT, "startBluetoothSco").set(MediaMetrics.Property.SCO_AUDIO_MODE, BtHelper.scoAudioModeToString(scoAudioMode)).record();
        startBluetoothScoInt(cb, attributionSource, scoAudioMode, eventSource);
        return;
    L11:
        scoAudioMode = -1;
        goto L12
    }

    public void startBluetoothScoVirtualCall(IBinder cb, AttributionSource attributionSource) {
        Log.i(TAG, "In startBluetoothScoVirtualCall()");
        if (attributionSource != null) goto L6;
        return;
    L6:
        if (checkAudioSettingsPermission("startBluetoothScoVirtualCall()") == true) goto L8;
        return;
    L8:
        int uid = attributionSource.getUid();
        int pid = attributionSource.getPid();
        String eventSource = "startBluetoothScoVirtualCall()) from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid;
        new MediaMetrics.Item("audio.bluetooth").setUid(uid).setPid(pid).set(MediaMetrics.Property.EVENT, "startBluetoothScoVirtualCall").set(MediaMetrics.Property.SCO_AUDIO_MODE, BtHelper.scoAudioModeToString(0)).record();
        startBluetoothScoInt(cb, attributionSource, 0, eventSource);
    }

    void startBluetoothScoInt(IBinder cb, AttributionSource attributionSource, int scoAudioMode, String eventSource) {
        Log.i(TAG, "In startBluetoothScoInt(), scoAudioMode: " + scoAudioMode);
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.bluetooth").set(MediaMetrics.Property.EVENT, "startBluetoothScoInt").set(MediaMetrics.Property.SCO_AUDIO_MODE, BtHelper.scoAudioModeToString(scoAudioMode));
        if (checkAudioSettingsPermission("startBluetoothSco()") == false) goto L24;
        if (this.mSystemReady == false) goto L24;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L10;
        boolean r0 = true;
    L11:
        boolean isPrivileged = r0;
        long ident = Binder.clearCallingIdentity();
        this.mDeviceBroker.startBluetoothScoForClient(cb, attributionSource, scoAudioMode, isPrivileged, eventSource);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);
        mmi.record();
        return;
    L17:
        th = move-exception;
        Throwable r11 = th;
    L21:
        Binder.restoreCallingIdentity(ident);
        throw r11;
    L19:
        th = move-exception;
        r11 = th;
        goto L21
    L10:
        r0 = false;
    L24:
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "permission or systemReady").record();
    }

    public void stopBluetoothSco(IBinder cb, AttributionSource attributionSource) {
        Log.i(TAG, "In stopBluetoothSco()");
        if (attributionSource != null) goto L6;
        return;
    L6:
        if (checkAudioSettingsPermission("stopBluetoothSco()") == true) goto L8;
        return;
    L8:
        if (this.mSystemReady == false) goto L24;
        int uid = attributionSource.getUid();
        int pid = attributionSource.getPid();
        String eventSource = "stopBluetoothSco()) from u/pid:" + uid + SliceClientPermissions.SliceAuthority.DELIMITER + pid;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L13;
        boolean isPrivileged = true;
    L14:
        long ident = Binder.clearCallingIdentity();
        this.mDeviceBroker.stopBluetoothScoForClient(cb, attributionSource, isPrivileged, eventSource);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(ident);
        new MediaMetrics.Item("audio.bluetooth").setUid(uid).setPid(pid).set(MediaMetrics.Property.EVENT, "stopBluetoothSco").set(MediaMetrics.Property.SCO_AUDIO_MODE, BtHelper.scoAudioModeToString(-1)).record();
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L13:
        isPrivileged = false;
        goto L14
    }

    ContentResolver getContentResolver() {
        return this.mContentResolver;
    }

    public SettingsAdapter getSettings() {
        return this.mSettings;
    }

    private int checkForRingerModeChange(int oldIndex, int direction, int step, boolean isMuted, String caller, int flags) {
        int result = 1;
        if (isPlatformTelevision() == false) goto L5;
    L66:
        return 1;
    L5:
        if (this.mIsSingleVolume == true) goto L66;
        int ringerMode = getRingerModeInternal();
        switch(ringerMode) {
            case 0: goto L41;
            case 1: goto L22;
            case 2: goto L10;
            default: goto L9;
        };
    L9:
        Log.e(TAG, "checkForRingerModeChange() wrong ringer mode: " + ringerMode);
    L54:
        if (isAndroidNPlus(caller) == true) goto L56;
    L64:
        setRingerMode(ringerMode, "AS.AudioService.checkForRingerModeChange", false);
        this.mPrevVolDirection = direction;
        return result;
    L56:
        if (wouldToggleZenMode(ringerMode) == false) goto L64;
        if (this.mNm.isNotificationPolicyAccessGrantedForPackage(caller) == true) goto L64;
        if ((flags & 4096) != 0) goto L64;
        throw new SecurityException("Not allowed to change Do Not Disturb state");
    L10:
        if (direction != (-1)) goto L54;
        if (this.mHasVibrator == false) goto L17;
        if (step > oldIndex) goto L54;
        if (oldIndex >= (step * 2)) goto L54;
        ringerMode = 1;
        this.mLoweredFromNormalToVibrateTime = SystemClock.uptimeMillis();
        goto L54
    L17:
        if (oldIndex != step) goto L54;
        if (this.mVolumePolicy.volumeDownToEnterSilent == false) goto L54;
        ringerMode = 0;
        goto L54
    L41:
        if (direction == 1) goto L45;
        if (direction == 101) goto L45;
        if (direction == 100) goto L45;
    L52:
        result = result & (-2);
    L45:
        if (this.mVolumePolicy.volumeUpToExitSilent == true) goto L48;
        result = 1 | 128;
        goto L52
    L48:
        if (this.mHasVibrator == false) goto L51;
        if (direction != 1) goto L51;
        ringerMode = 1;
    L51:
        ringerMode = 2;
        goto L52
    L22:
        if (this.mHasVibrator == true) goto L24;
        Log.e(TAG, "checkForRingerModeChange() current ringer mode is vibratebut no vibrator is present");
        goto L54
    L24:
        if (direction == (-1)) goto L26;
        if (direction == 1) goto L39;
        if (direction == 101) goto L39;
        if (direction == 100) goto L39;
    L40:
        result = result & (-2);
    L39:
        ringerMode = 2;
        goto L40
    L26:
        if (this.mPrevVolDirection == (-1)) goto L40;
        if (this.mVolumePolicy.volumeDownToEnterSilent == false) goto L35;
        long diff = SystemClock.uptimeMillis() - this.mLoweredFromNormalToVibrateTime;
        if (diff <= this.mVolumePolicy.vibrateToSilentDebounce) goto L40;
        if (this.mRingerModeDelegate.canVolumeDownEnterSilent() == false) goto L40;
        ringerMode = 0;
        goto L40
    L35:
        result = 1 | 2048;
        goto L40
    }

    public boolean isStreamAffectedByRingerMode(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "isStreamAffectedByRingerMode");
        if ((this.mRingerModeAffectedStreams & (1 << streamType2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isStreamAffectedByCurrentZen(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "isStreamAffectedByCurrentZen");
        if ((this.mZenModeAffectedStreams & (1 << streamType2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isStreamMutedByRingerOrZenMode(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "isStreamMutedByRingerOrZenMode");
        if ((sRingerAndZenModeMutedStreams & (1 << streamType2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean updateZenModeAffectedStreams() {
        if (this.mSystemReady == true) goto L5;
        return false;
    L5:
        int zenModeAffectedStreams = 0;
        int zenMode = this.mNm.getZenMode();
        if (zenMode != 2) goto L8;
        zenModeAffectedStreams = ((((0 | 2) | 32) | 4) | 16) | 8;
    L23:
        final ArrayList autoZenDisallowMedia = new ArrayList();
        final ArrayList<ZenModeConfig.ZenRule> autoZenModeAlarm = new ArrayList();
        this.mNm.getZenModeConfig().automaticRules.forEach(new AudioService$$ExternalSyntheticLambda31(autoZenDisallowMedia, autoZenModeAlarm));
        if (autoZenDisallowMedia.isEmpty() == true) goto L26;
        zenModeAffectedStreams = zenModeAffectedStreams | 8;
    L26:
        if (zenMode != 3) goto L33;
        if (autoZenModeAlarm.size() != 1) goto L33;
        if ("game_mode".equals(autoZenModeAlarm.get(0).name) == false) goto L33;
        Slog.d(TAG, "clear AudioManager.STREAM_RING for game mode");
        zenModeAffectedStreams = zenModeAffectedStreams & (-5);
    L33:
        if (this.mZenModeAffectedStreams == zenModeAffectedStreams) goto L36;
        this.mZenModeAffectedStreams = zenModeAffectedStreams;
        return true;
    L36:
        return false;
    L8:
        if (zenMode != 3) goto L10;
        zenModeAffectedStreams = ((0 | 2) | 32) | 4;
        goto L23
    L10:
        if (zenMode != 1) goto L23;
        NotificationManager.Policy zenPolicy = this.mNm.getConsolidatedNotificationPolicy();
        if ((zenPolicy.priorityCategories & 32) != 0) goto L15;
        zenModeAffectedStreams = 0 | 16;
    L15:
        if ((zenPolicy.priorityCategories & 64) != 0) goto L18;
        zenModeAffectedStreams = zenModeAffectedStreams | 8;
    L18:
        if ((zenPolicy.priorityCategories & 128) != 0) goto L21;
        zenModeAffectedStreams = zenModeAffectedStreams | 2;
    L21:
        if (ZenModeConfig.areAllPriorityOnlyRingerSoundsMuted(zenPolicy) == false) goto L23;
        zenModeAffectedStreams = (zenModeAffectedStreams | 32) | 4;
        goto L23
    }

    private static /* synthetic */ void lambda$updateZenModeAffectedStreams$16(ArrayList autoZenDisallowMedia, ArrayList autoZenModeAlarm, String id, ZenModeConfig.ZenRule rule) {
        if (rule.isActive() == false) goto L8;
        if (rule.zenPolicy.getPriorityCategoryMedia() != 2) goto L8;
        autoZenDisallowMedia.add(rule);
    L8:
        if (rule.isActive() == true) goto L10;
        return;
    L10:
        if (rule.zenMode != 3) goto L14;
        autoZenModeAlarm.add(rule);
        return;
    }

    private boolean updateRingerAndZenModeAffectedStreams() {
        boolean updatedZenModeAffectedStreams = updateZenModeAffectedStreams();
        int ringerModeAffectedStreams = this.mSettings.getSystemIntForUser(this.mContentResolver, "mode_ringer_streams_affected", 166, -2);
        if (this.mIsSingleVolume == false) goto L6;
        ringerModeAffectedStreams = 0;
    L9:
        if (this.mCameraSoundForced.get() == false) goto L11;
        int ringerModeAffectedStreams2 = ringerModeAffectedStreams & (-129);
    L13:
        if (sStreamVolumeAlias.get(8) != 2) goto L15;
        int ringerModeAffectedStreams3 = ringerModeAffectedStreams2 | 256;
    L17:
        if (this.mRingerModeAffectsAlarm == false) goto L25;
        boolean muteAlarmWithRinger = false;
        if (this.mSettings.getGlobalInt(this.mContentResolver, "mute_alarm_stream_with_ringer_mode", 0) == 0) goto L21;
        muteAlarmWithRinger = true;
    L21:
        if (muteAlarmWithRinger == false) goto L23;
        ringerModeAffectedStreams3 = ringerModeAffectedStreams3 | 16;
        goto L25
    L23:
        ringerModeAffectedStreams3 = ringerModeAffectedStreams3 & (-17);
    L25:
        if (ringerModeAffectedStreams3 == this.mRingerModeAffectedStreams) goto L28;
        this.mSettings.putSystemIntForUser(this.mContentResolver, "mode_ringer_streams_affected", ringerModeAffectedStreams3, -2);
        this.mRingerModeAffectedStreams = ringerModeAffectedStreams3;
        return true;
    L28:
        return updatedZenModeAffectedStreams;
    L15:
        ringerModeAffectedStreams3 = ringerModeAffectedStreams2 & (-257);
        goto L17
    L11:
        ringerModeAffectedStreams2 = ringerModeAffectedStreams | 128;
        goto L13
    L6:
        if (this.mRingerModeDelegate == null) goto L9;
        ringerModeAffectedStreams = this.mRingerModeDelegate.getRingerModeAffectedStreams(ringerModeAffectedStreams);
        goto L9
    }

    public boolean isStreamAffectedByMute(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "isStreamAffectedByMute");
        if ((this.mMuteAffectedStreams & (1 << streamType2)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isStreamMutableByUi(int streamType) {
        if ((this.mUserMutableStreams & (1 << streamType)) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void ensureValidDirection(int direction) {
        switch(direction) {
            case -100: goto L6;
            case -1: goto L6;
            case 0: goto L6;
            case 1: goto L6;
            case 100: goto L6;
            case 101: goto L6;
            default: goto L4;
        };
    L6:
        return;
    L4:
        throw new IllegalArgumentException("Bad direction " + direction);
    }

    private void ensureValidStreamType(int streamType) {
        if (streamType < 0) goto L7;
        if (streamType >= AudioSystem.getNumStreamTypes()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Bad stream type " + streamType);
    }

    private boolean isMuteAdjust(int adjust) {
        if (adjust != (-100)) goto L5;
    L10:
        return true;
    L5:
        if (adjust == 100) goto L10;
        if (adjust == 101) goto L10;
        return false;
    }

    public boolean isInCommunication() {
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService("telecom");
        long ident = Binder.clearCallingIdentity();
        boolean IsInCall = telecomManager.isInCall();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        int mode = this.mMode.get();
        if (IsInCall == false) goto L7;
    L12:
        return true;
    L7:
        if (mode == 3) goto L12;
        if (mode == 2) goto L12;
        return false;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    boolean wasStreamActiveRecently(int stream, int delay_ms) {
        if (this.mAudioSystem.isStreamActive(stream, delay_ms) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mAudioSystem.isStreamActiveRemotely(stream, delay_ms) == true) goto L8;
        return false;
    }

    private int getActiveStreamType(int suggestedStreamType) {
        if (this.mIsSingleVolume == false) goto L8;
        if (suggestedStreamType != Integer.MIN_VALUE) goto L8;
        return 3;
    L8:
        switch(this.mPlatformType) {
            case 1: goto L11;
            default: goto L44;
        };
    L11:
        if (isInCommunication() == false) goto L13;
    L79:
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_VOICE_CALL...");
        return 0;
    L13:
        if (this.mAudioSystem.isStreamActive(0, 0) == true) goto L79;
        if (suggestedStreamType == Integer.MIN_VALUE) goto L18;
        Optional<Integer> result = this.mASExt.getActiveStreamType_onPlatformVoice_useOtherStreamType_onStart(sStreamOverrideDelayMs);
        if (result.isPresent() == false) goto L36;
        return result.get().intValue();
    L36:
        if (wasStreamActiveRecently(5, sStreamOverrideDelayMs) == false) goto L40;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_NOTIFICATION stream active");
        return 5;
    L40:
        if (wasStreamActiveRecently(2, sStreamOverrideDelayMs) == false) goto L44;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_RING stream active");
        return 2;
    L18:
        if (wasStreamActiveRecently(2, sStreamOverrideDelayMs) == false) goto L21;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_RING stream active");
        return 2;
    L21:
        Optional<Integer> result2 = this.mASExt.getActiveStreamType_onPlatformVoice_afterUseRingStreamType(sStreamOverrideDelayMs);
        if (result2.isPresent() == true) goto L24;
        Optional<Integer> result3 = this.mASExt.getActiveStreamType_onPlatformVoice_beforeUseDefaultStreamType(sStreamOverrideDelayMs);
        if (result3.isPresent() == true) goto L28;
        Log.v(TAG, "getActiveStreamType: Forcing DEFAULT_VOL_STREAM_NO_PLAYBACK(" + DEFAULT_VOL_STREAM_NO_PLAYBACK + ") b/c default");
        return DEFAULT_VOL_STREAM_NO_PLAYBACK;
    L28:
        return result3.get().intValue();
    L24:
        return result2.get().intValue();
    L44:
        if (isInCommunication() == false) goto L46;
    L77:
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_VOICE_CALL");
        return 0;
    L46:
        if (this.mAudioSystem.isStreamActive(0, 0) == true) goto L77;
        Optional<Integer> result4 = this.mASExt.getActiveStreamType_onDefault_useDefeaultStreamType_afterCall(sStreamOverrideDelayMs);
        if (result4.isPresent() == false) goto L53;
        return result4.get().intValue();
    L53:
        if (this.mAudioSystem.isStreamActive(5, sStreamOverrideDelayMs) == false) goto L57;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_NOTIFICATION");
        return 5;
    L57:
        if (this.mAudioSystem.isStreamActive(2, sStreamOverrideDelayMs) == false) goto L60;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_RING");
        return 2;
    L60:
        if (suggestedStreamType == Integer.MIN_VALUE) goto L62;
        int suggestedStreamType2 = replaceBtScoStreamWithVoiceCall(suggestedStreamType, "getActiveStreamType");
        Log.v(TAG, "getActiveStreamType: Returning suggested type " + suggestedStreamType2);
        return suggestedStreamType2;
    L62:
        if (this.mAudioSystem.isStreamActive(5, sStreamOverrideDelayMs) == false) goto L66;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_NOTIFICATION");
        return 5;
    L66:
        if (this.mAudioSystem.isStreamActive(2, sStreamOverrideDelayMs) == false) goto L69;
        Log.v(TAG, "getActiveStreamType: Forcing STREAM_RING");
        return 2;
    L69:
        Optional<Integer> result5 = this.mASExt.getActiveStreamType_onDefault_useDefeaultStreamType_onEnd(sStreamOverrideDelayMs);
        if (result5.isPresent() == true) goto L72;
        Log.v(TAG, "getActiveStreamType: Forcing DEFAULT_VOL_STREAM_NO_PLAYBACK(" + DEFAULT_VOL_STREAM_NO_PLAYBACK + ") b/c default");
        return DEFAULT_VOL_STREAM_NO_PLAYBACK;
    L72:
        return result5.get().intValue();
    }

    private void broadcastRingerMode(String action, int ringerMode) {
        if (this.mSystemServer.isPrivileged() == true) goto L5;
        return;
    L5:
        Intent broadcast = new Intent(action);
        broadcast.putExtra("android.media.EXTRA_RINGER_MODE", ringerMode);
        broadcast.addFlags(603979776);
        sendStickyBroadcastToAll(broadcast);
    }

    private void broadcastVibrateSetting(int vibrateType) {
        if (this.mSystemServer.isPrivileged() == true) goto L6;
        return;
    L6:
        if (this.mActivityManagerInternal.isSystemReady() == false) goto L9;
        Intent broadcast = new Intent("android.media.VIBRATE_SETTING_CHANGED");
        broadcast.putExtra("android.media.EXTRA_VIBRATE_TYPE", vibrateType);
        broadcast.putExtra("android.media.EXTRA_VIBRATE_SETTING", getVibrateSetting(vibrateType));
        sendBroadcastToAll(broadcast, null);
        return;
    }

    private void queueMsgUnderWakeLock(Handler handler, int msg, int arg1, int arg2, Object obj, int delay) {
        long ident = Binder.clearCallingIdentity();
        this.mAudioEventWakeLock.acquire();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        sendMsg(handler, msg, 2, arg1, arg2, obj, delay);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private static void sendMsg(Handler handler, int msg, int existingMsgPolicy, int arg1, int arg2, Object obj, int delay) {
        if (existingMsgPolicy != 0) goto L5;
        handler.removeMessages(msg);
    L9:
        long time = SystemClock.uptimeMillis() + ((long) delay);
        handler.sendMessageAtTime(handler.obtainMessage(msg, arg1, arg2, obj), time);
        return;
    L5:
        if (existingMsgPolicy != 1) goto L9;
        if (handler.hasMessages(msg) == false) goto L9;
    }

    private static void sendBundleMsg(Handler handler, int msg, int existingMsgPolicy, int arg1, int arg2, Object obj, Bundle bundle, int delay) {
        if (existingMsgPolicy != 0) goto L5;
        handler.removeMessages(msg);
    L9:
        long time = SystemClock.uptimeMillis() + ((long) delay);
        Message message = handler.obtainMessage(msg, arg1, arg2, obj);
        message.setData(bundle);
        handler.sendMessageAtTime(message, time);
        return;
    L5:
        if (existingMsgPolicy != 1) goto L9;
        if (handler.hasMessages(msg) == false) goto L9;
    }

    boolean checkAudioSettingsPermission(String method) {
        if (callingOrSelfHasAudioSettingsPermission() == false) goto L6;
        return true;
    L6:
        String msg = "Audio Settings Permission Denial: " + method + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid();
        Log.w(TAG, msg);
        return false;
    }

    private boolean callingOrSelfHasAudioSettingsPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean callingHasAudioSettingsPermission() {
        if (this.mContext.checkCallingPermission("android.permission.MODIFY_AUDIO_SETTINGS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasAudioSettingsPermission(int uid, int pid) {
        if (this.mContext.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", pid, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected void initMinStreamVolumeWithoutModifyAudioSettings() {
        int deviceForAlarm = 4194304;
        if (Float.isNaN(AudioSystem.getStreamVolumeDB(4, MIN_STREAM_VOLUME[4], 4194304)) == false) goto L5;
        deviceForAlarm = 2;
    L5:
        int idx = MAX_STREAM_VOLUME[4];
    L7:
        if (idx < MIN_STREAM_VOLUME[4]) goto L13;
        if (AudioSystem.getStreamVolumeDB(4, idx, deviceForAlarm) < MIN_ALARM_ATTENUATION_NON_PRIVILEGED_DB) goto L13;
        idx = idx - 1;
    L13:
        if (idx > MIN_STREAM_VOLUME[4]) goto L15;
        int safeIndex = MIN_STREAM_VOLUME[4];
    L16:
        int streamIdx = 0;
    L18:
        if (streamIdx >= sStreamVolumeAlias.size()) goto L24;
        int streamAlias = sStreamVolumeAlias.valueAt(streamIdx);
        if (streamAlias != 4) goto L22;
        getVssForStreamOrDefault(streamAlias).updateNoPermMinIndex(safeIndex);
    L22:
        streamIdx = streamIdx + 1;
        goto L18
    L24:
        return;
    L15:
        safeIndex = Math.min(idx + 1, MAX_STREAM_VOLUME[4]);
        goto L16
    }

    public int getDeviceForStream(int stream) {
        return selectOneAudioDevice(getDeviceSetForStream(replaceBtScoStreamWithVoiceCall(stream, "getDeviceForStream")));
    }

    private int selectOneAudioDevice(Set<Integer> deviceSet) {
        if (deviceSet.isEmpty() == false) goto L6;
        return 0;
    L6:
        if (deviceSet.size() != 1) goto L10;
        return deviceSet.iterator().next().intValue();
    L10:
        if (deviceSet.contains(4096) == false) goto L13;
        return 4096;
    L13:
        if (deviceSet.contains(2) == false) goto L16;
        return 2;
    L16:
        if (deviceSet.contains(4194304) == false) goto L19;
        return 4194304;
    L19:
        if (deviceSet.contains(262144) == false) goto L22;
        return 262144;
    L22:
        if (deviceSet.contains(262145) == false) goto L25;
        return 262145;
    L25:
        if (deviceSet.contains(2097152) == false) goto L28;
        return 2097152;
    L28:
        if (deviceSet.contains(524288) == false) goto L30;
        return 524288;
    L30:
        Iterator<Integer> r0 = deviceSet.iterator();
    L32:
        if (r0.hasNext() == false) goto L37;
        int deviceType = r0.next().intValue();
        if (AudioSystem.DEVICE_OUT_PICK_FOR_VOLUME_SET.contains(Integer.valueOf(deviceType)) == false) goto L32;
        return deviceType;
    L37:
        Log.w(TAG, "selectOneAudioDevice returning DEVICE_NONE from invalid device combination " + AudioSystem.deviceSetToString(deviceSet));
        return 0;
    }

    @Deprecated
    public int getDeviceMaskForStream(int streamType) {
        int streamType2 = replaceBtScoStreamWithVoiceCall(streamType, "getDeviceMaskForStream");
        ensureValidStreamType(streamType2);
        long token = Binder.clearCallingIdentity();
        int r2 = AudioSystem.getDeviceMaskFromSet(getDeviceSetForStreamDirect(streamType2));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private Set<Integer> getDeviceSetForStreamDirect(int stream) {
        AudioAttributes attr = AudioProductStrategy.getAudioAttributesForStrategyWithLegacyStreamType(stream);
        Set<Integer> deviceSet = AudioSystem.generateAudioDeviceTypesSet(getDevicesForAttributesInt(attr, true));
        return deviceSet;
    }

    public Set<Integer> getDeviceSetForStream(int stream) {
        int stream2 = replaceBtScoStreamWithVoiceCall(stream, "getDeviceSetForStream");
        ensureValidStreamType(stream2);
        Object r0 = this.mVolumeStateLock;
        monitor-enter(r0);
        Set<Integer> r1 = getVssForStreamOrDefault(stream2).observeDevicesForStream_syncVSS(true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void onObserveDevicesForAllStreams(int skipStream) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        Object r1 = this.mVolumeStateLock;     // Catch: Throwable -> L24
        monitor-enter(r1);     // Catch: Throwable -> L24
        int stream = 0;
    L30:
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L8:
        if (stream >= this.mStreamStates.size()) goto L21;
        VolumeStreamState vss = this.mStreamStates.valueAt(stream);     // Catch: Throwable -> L17
        if (vss == null) goto L19;
        if (vss.getStreamType() == skipStream) goto L19;
        Set<Integer> deviceSet = vss.observeDevicesForStream_syncVSS(false);     // Catch: Throwable -> L17
        Iterator<Integer> r5 = deviceSet.iterator();     // Catch: Throwable -> L17
    L15:
        if (r5.hasNext() == false) goto L19;
        Integer device = r5.next();     // Catch: Throwable -> L17
        updateVolumeStates(device.intValue(), vss.getStreamType(), "AudioService#onObserveDevicesForAllStreams");     // Catch: Throwable -> L17
    L19:
        stream = stream + 1;     // Catch: Throwable -> L17
        goto L30
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public void postObserveDevicesForAllStreams() {
        postObserveDevicesForAllStreams(-1);
    }

    public void postObserveDevicesForAllStreams(int skipStream) {
        sendMsg(this.mAudioHandler, 27, 2, skipStream, 0, null, 0);
    }

    void postBtCommDeviceActive(int btCommDeviceActive) {
        sendMsg(this.mAudioHandler, 57, 2, btCommDeviceActive, 0, null, 0);
    }

    private void onUpdateBtCommDeviceActive(int btCommDeviceActive) {
        if (this.mBtCommDeviceActive.getAndSet(btCommDeviceActive) == btCommDeviceActive) goto L6;
        getVssForStreamOrDefault(0).updateIndexFactors();
        return;
    }

    public void registerDeviceVolumeDispatcherForAbsoluteVolume(boolean register, IAudioDeviceVolumeDispatcher cb, String packageName, AudioDeviceAttributes device, List<VolumeInfo> volumes, boolean handlesVolumeAdjustment, int deviceVolumeBehavior) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
    L9:
        device.getClass();
        volumes.getClass();
        int deviceOut = device.getInternalType();
        if (register == false) goto L42;
        AbsoluteVolumeDeviceInfo info = new AbsoluteVolumeDeviceInfo(this, device, volumes, cb, handlesVolumeAdjustment, deviceVolumeBehavior, null);
        AbsoluteVolumeDeviceInfo oldInfo = getAbsoluteVolumeDeviceInfo(deviceOut);
        addAudioSystemDeviceOutToAbsVolumeDevices(deviceOut, info);
        if (oldInfo != null) goto L14;
    L17:
        boolean r1 = true;
    L18:
        boolean volumeBehaviorChanged = r1;
        if (volumeBehaviorChanged == false) goto L21;
        removeAudioSystemDeviceOutFromFullVolumeDevices(deviceOut);
        removeAudioSystemDeviceOutFromFixedVolumeDevices(deviceOut);
        dispatchDeviceVolumeBehavior(device, deviceVolumeBehavior);
    L21:
        Iterator<VolumeInfo> r14 = volumes.iterator();
    L23:
        if (r14.hasNext() == false) goto L52;
        VolumeInfo volumeInfo = r14.next();
        if (volumeInfo.getVolumeIndex() != (-100)) goto L27;
        int deviceOut2 = deviceOut;
    L40:
        deviceOut = deviceOut2;
        goto L23
    L27:
        if (volumeInfo.getMinVolumeIndex() != (-100)) goto L29;
        deviceOut2 = deviceOut;
        goto L40
    L29:
        if (volumeInfo.getMaxVolumeIndex() != (-100)) goto L31;
        deviceOut2 = deviceOut;
        goto L40
    L31:
        if (volumeInfo.hasStreamType() == false) goto L33;
        deviceOut2 = deviceOut;
        setStreamVolumeInt(volumeInfo.getStreamType(), rescaleIndex(volumeInfo, volumeInfo.getStreamType()), deviceOut2, false, packageName, true);
        goto L40
    L33:
        deviceOut2 = deviceOut;
        int[] r8 = volumeInfo.getVolumeGroup().getLegacyStreamTypes();
        int r2 = r8.length;
        int r3 = 0;
    L35:
        if (r3 >= r2) goto L40;
        int r4 = r2;
        int streamType = r8[r3];
        setStreamVolumeInt(streamType, rescaleIndex(volumeInfo, streamType), deviceOut2, false, packageName, true);
        r3 = r3 + 1;
        r2 = r4;
        goto L35
    L52:
        return;
    L14:
        if (AbsoluteVolumeDeviceInfo.m2114$$Nest$fgetmDeviceVolumeBehavior(oldInfo) != deviceVolumeBehavior) goto L17;
        r1 = false;
        goto L18
    L42:
        AbsoluteVolumeDeviceInfo deviceInfo = removeAudioSystemDeviceOutFromAbsVolumeDevices(deviceOut);
        if (deviceInfo == null) goto L53;
        deviceInfo.unlinkToDeath();
        dispatchDeviceVolumeBehavior(device, 0);
        return;
    L53:
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH_PRIVILEGED") == 0) goto L9;
        throw new SecurityException("Missing MODIFY_AUDIO_ROUTING or BLUETOOTH_PRIVILEGED permissions");
    }

    public void setDeviceVolumeBehavior(AudioDeviceAttributes device, int deviceVolumeBehavior, String pkgName) {
        super.setDeviceVolumeBehavior_enforcePermission();
        device.getClass();
        AudioDeviceVolumeManager.enforceValidVolumeBehavior(deviceVolumeBehavior);
        AudioDeviceAttributes device2 = retrieveBluetoothAddress(device);
        sVolumeLogger.enqueue(new EventLogger.StringEvent("setDeviceVolumeBehavior: dev:" + AudioSystem.getOutputDeviceName(device2.getInternalType()) + " addr:" + Utils.anonymizeBluetoothAddress(device2.getAddress()) + " behavior:" + AudioDeviceVolumeManager.volumeBehaviorName(deviceVolumeBehavior) + " pack:" + pkgName).printLog(TAG));
        if (pkgName != null) goto L6;
        pkgName = "";
    L6:
        if (device2.getType() != 8) goto L13;
        String r0 = device2.getAddress();
        if (deviceVolumeBehavior != 3) goto L10;
        boolean r1 = true;
    L11:
        avrcpSupportsAbsoluteVolume(r0, r1);
        return;
    L10:
        r1 = false;
        goto L11
    L13:
        setDeviceVolumeBehaviorInternal(device2, deviceVolumeBehavior, pkgName);
        persistDeviceVolumeBehavior(device2.getInternalType(), deviceVolumeBehavior);
    }

    private void setDeviceVolumeBehaviorInternal(AudioDeviceAttributes device, int deviceVolumeBehavior, String caller) {
        int audioSystemDeviceOut = device.getInternalType();
        boolean volumeBehaviorChanged = false;
        boolean r2 = false;
        switch(deviceVolumeBehavior) {
            case 0: goto L15;
            case 1: goto L11;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            default: goto L19;
        };
    L7:
        boolean r4 = removeAudioSystemDeviceOutFromFullVolumeDevices(audioSystemDeviceOut) | addAudioSystemDeviceOutToFixedVolumeDevices(audioSystemDeviceOut);
        if (removeAudioSystemDeviceOutFromAbsVolumeDevices(audioSystemDeviceOut) == null) goto L10;
        r2 = true;
    L10:
        volumeBehaviorChanged = false | (r2 | r4);
        goto L19
    L11:
        boolean r5 = addAudioSystemDeviceOutToFullVolumeDevices(audioSystemDeviceOut) | removeAudioSystemDeviceOutFromFixedVolumeDevices(audioSystemDeviceOut);
        if (removeAudioSystemDeviceOutFromAbsVolumeDevices(audioSystemDeviceOut) == null) goto L14;
        r2 = true;
    L14:
        volumeBehaviorChanged = false | (r2 | r5);
        goto L19
    L15:
        boolean r6 = removeAudioSystemDeviceOutFromFullVolumeDevices(audioSystemDeviceOut) | removeAudioSystemDeviceOutFromFixedVolumeDevices(audioSystemDeviceOut);
        if (removeAudioSystemDeviceOutFromAbsVolumeDevices(audioSystemDeviceOut) == null) goto L18;
        r2 = true;
    L18:
        volumeBehaviorChanged = false | (r2 | r6);
    L19:
        if (volumeBehaviorChanged == false) goto L21;
        int deviceVolumeBehavior2 = deviceVolumeBehavior;
        sendMsg(this.mAudioHandler, 47, 2, deviceVolumeBehavior2, 0, device, 0);
    L22:
        sDeviceLogger.enqueue(new EventLogger.StringEvent("Volume behavior " + deviceVolumeBehavior2 + " for dev=0x" + Integer.toHexString(audioSystemDeviceOut) + " from:" + caller));
        StringBuilder r10 = new StringBuilder();
        r10.append("setDeviceVolumeBehavior:");
        r10.append(caller);
        postUpdateVolumeStatesForAudioDevice(audioSystemDeviceOut, r10.toString());
        return;
    L21:
        deviceVolumeBehavior2 = deviceVolumeBehavior;
        goto L22
    L6:
        throw new IllegalArgumentException("Absolute volume unsupported for now");
    }

    public int getDeviceVolumeBehavior(AudioDeviceAttributes device) {
        super.getDeviceVolumeBehavior_enforcePermission();
        device.getClass();
        return getDeviceVolumeBehaviorInt(retrieveBluetoothAddress(device));
    }

    private int getDeviceVolumeBehaviorInt(AudioDeviceAttributes device) {
        int audioSystemDeviceOut = device.getInternalType();
        if (this.mFullVolumeDevices.contains(Integer.valueOf(audioSystemDeviceOut)) == false) goto L7;
        return 1;
    L7:
        if (this.mFixedVolumeDevices.contains(Integer.valueOf(audioSystemDeviceOut)) == false) goto L11;
        return 2;
    L11:
        if (this.mAbsVolumeMultiModeCaseDevices.contains(Integer.valueOf(audioSystemDeviceOut)) == false) goto L14;
        return 4;
    L14:
        Object r1 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r1);
    L23:
        th = move-exception;
        throw th;
    L17:
        if (this.mAbsoluteVolumeDeviceInfoMap.containsKey(Integer.valueOf(audioSystemDeviceOut)) == false) goto L26;
        AbsoluteVolumeDeviceInfo deviceInfo = this.mAbsoluteVolumeDeviceInfoMap.get(Integer.valueOf(audioSystemDeviceOut));     // Catch: Throwable -> L23
        if (deviceInfo == null) goto L25;
        int r3 = AbsoluteVolumeDeviceInfo.m2114$$Nest$fgetmDeviceVolumeBehavior(deviceInfo);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return r3;
    L25:
        Log.e(TAG, "Null absolute volume device info stored for key " + audioSystemDeviceOut);     // Catch: Throwable -> L23
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L23
        if (isA2dpAbsoluteVolumeDevice(audioSystemDeviceOut) == false) goto L30;
        return 3;
    L30:
        if (AudioSystem.isLeAudioDeviceType(audioSystemDeviceOut) == true) goto L39;
        return 0;
    L39:
        return 3;
    }

    public boolean isVolumeFixed() {
        if (this.mUseFixedVolume == false) goto L5;
        return true;
    L5:
        AudioAttributes attributes = new AudioAttributes.Builder().setUsage(1).build();
        List<AudioDeviceAttributes> devices = getDevicesForAttributesInt(attributes, true);
        Iterator<AudioDeviceAttributes> r3 = devices.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        AudioDeviceAttributes device = r3.next();
        if (getDeviceVolumeBehaviorInt(device) != 2) goto L7;
        return true;
    L12:
        return false;
    }

    public void setWiredDeviceConnectionState(AudioDeviceAttributes attributes, int state, String caller) {
        super.setWiredDeviceConnectionState_enforcePermission();
        attributes.getClass();
        AudioDeviceAttributes attributes2 = retrieveBluetoothAddress(attributes);
        if (attributes2.getType() == 10) goto L5;
    L9:
        if (state == 1) goto L14;
        if (state == 0) goto L14;
        throw new IllegalArgumentException("Invalid state " + state);
    L14:
        MediaMetrics.Item r0 = new MediaMetrics.Item("audio.service.setWiredDeviceConnectionState").set(MediaMetrics.Property.ADDRESS, attributes2.getAddress()).set(MediaMetrics.Property.CLIENT_NAME, caller).set(MediaMetrics.Property.DEVICE, AudioSystem.getDeviceName(attributes2.getInternalType())).set(MediaMetrics.Property.NAME, attributes2.getName());
        MediaMetrics.Key r1 = MediaMetrics.Property.STATE;
        if (state != 1) goto L17;
        String r2 = "connected";
    L18:
        r0.set(r1, r2).record();
        this.mDeviceBroker.setWiredDeviceConnectionState(attributes2, state, caller);
        if (attributes2.getInternalType() != (-2013265920)) goto L22;
        updateHdmiAudioSystemClient();
        return;
    L22:
        return;
    L17:
        r2 = "disconnected";
        goto L18
    L5:
        if (attributes2.getRole() != 2) goto L9;
        if (attributes2.getAudioDescriptors().isEmpty() == false) goto L9;
        attributes2 = new AudioDeviceAttributes(attributes2.getRole(), attributes2.getType(), attributes2.getAddress(), attributes2.getName(), attributes2.getAudioProfiles(), new ArrayList(Collections.singletonList(new AudioDescriptor(1, 0, DEFAULT_ARC_AUDIO_DESCRIPTOR))));
        goto L9
    }

    private void updateHdmiAudioSystemClient() {
        Slog.d(TAG, "Hdmi Audio System Client is updated");
        Object r0 = this.mHdmiClientLock;
        monitor-enter(r0);
        this.mHdmiAudioSystemClient = this.mHdmiManager.getAudioSystemClient();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setTestDeviceConnectionState(AudioDeviceAttributes r9, boolean r10) {
        r9.getClass();
        enforceModifyAudioRoutingPermission();
        AudioDeviceAttributes r11 = retrieveBluetoothAddress(r9);
        this.mDeviceBroker.setTestDeviceConnectionState(r11, r10 ? 1 : 0);
        sendMsg(this.mAudioHandler, 41, 0, 0, 0, null, 0);
    }

    public void handleBluetoothActiveDeviceChanged(BluetoothDevice newDevice, BluetoothDevice previousDevice, BluetoothProfileConnectionInfo info) {
        handleBluetoothActiveDeviceChanged_enforcePermission();
        if (info == null) goto L24;
        int profile = info.getProfile();
        if (profile != 2) goto L7;
    L21:
        sDeviceLogger.enqueue(new EventLogger.StringEvent("BluetoothActiveDeviceChanged for " + BluetoothProfile.getProfileName(profile) + ", device update " + previousDevice + " -> " + newDevice).printLog(TAG));
        AudioDeviceBroker.BtDeviceChangedData data = new AudioDeviceBroker.BtDeviceChangedData(newDevice, previousDevice, info, "AudioService");
        int delay = this.mASExt.handleBluetoothActiveDeviceChanged_getDelayMs(newDevice, previousDevice, info);
        sendMsg(this.mAudioHandler, 38, 2, 0, 0, data, delay);
        return;
    L7:
        if (profile == 11) goto L21;
        if (profile == 22) goto L21;
        if (profile == 26) goto L21;
        if (profile == 21) goto L21;
        if (this.mDeviceBroker.isScoManagedByAudio() == false) goto L20;
        if (profile == 1) goto L21;
    L20:
        throw new IllegalArgumentException("Illegal BluetoothProfile profile for device " + previousDevice + " -> " + newDevice + ". Got: " + profile);
    L24:
        throw new IllegalArgumentException("Illegal null BluetoothProfileConnectionInfo for device " + previousDevice + " -> " + newDevice);
    }

    public void setMusicMute(boolean mute) {
        getVssForStreamOrDefault(3).muteInternally(mute);
    }

    public void handleBluetoothA2dpActiveDeviceChange(BluetoothDevice device, int state, int profile, boolean suppressNoisyIntent, int a2dpVolume) {
        if (device == null) goto L18;
        if (profile != 2) goto L6;
    L10:
        if (state == 2) goto L15;
        if (state == 0) goto L15;
        throw new IllegalArgumentException("Invalid state " + state);
    L15:
        this.mDeviceBroker.queueOnBluetoothActiveDeviceChanged(new AudioDeviceBroker.BtDeviceChangedData(device, device, new BluetoothProfileConnectionInfo(profile), "AudioService"));
        return;
    L6:
        if (profile == 11) goto L10;
        throw new IllegalArgumentException("invalid profile " + profile);
    L18:
        throw new IllegalArgumentException("Illegal null device");
    }

    public void postAccessoryPlugMediaUnmute(int newDevice) {
        sendMsg(this.mAudioHandler, 21, 2, newDevice, 0, null, 0);
    }

    private void onAccessoryPlugMediaUnmute(int newDevice) {
        Log.i(TAG, String.format("onAccessoryPlugMediaUnmute newDevice=%d [%s]", new Object[]{Integer.valueOf(newDevice), AudioSystem.getOutputDeviceName(newDevice)}));
        if (this.mNm.getZenMode() != 2) goto L5;
        return;
    L5:
        if (isStreamMutedByRingerOrZenMode(3) == false) goto L7;
        return;
    L7:
        if (DEVICE_MEDIA_UNMUTED_ON_PLUG_SET.contains(Integer.valueOf(newDevice)) == true) goto L9;
        return;
    L9:
        if (VolumeStreamState.m2126$$Nest$fgetmIsMuted(getVssForStreamOrDefault(3)) == true) goto L11;
        return;
    L11:
        if (getVssForStreamOrDefault(3).getIndex(newDevice) != 0) goto L13;
        return;
    L13:
        if (getDeviceSetForStreamDirect(3).contains(Integer.valueOf(newDevice)) == false) goto L29;
        Log.i(TAG, String.format("onAccessoryPlugMediaUnmute unmuting device=%d [%s]", new Object[]{Integer.valueOf(newDevice), AudioSystem.getOutputDeviceName(newDevice)}));
        Object r1 = this.mSettingsLock;
        monitor-enter(r1);
        getVssForStreamOrDefault(3).mute(false, "onAccessoryPlugMediaUnmute");     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public boolean hasHapticChannels(Uri uri) {
        return AudioManager.hasHapticChannelsImpl(this.mContext, uri);
    }

    private void initVolumeGroupStates() {
        int btScoGroupId = -1;
        VolumeGroupState voiceCallGroup = null;
        Iterator<AudioVolumeGroup> r2 = getAudioVolumeGroups().iterator();
    L4:
        if (r2.hasNext() == false) goto L19;
        AudioVolumeGroup avg = r2.next();
        if (ensureValidVolumeGroup(avg) == true) goto L8;
        btScoGroupId = avg.getId();     // Catch: IllegalArgumentException -> L12
        goto L4
    L8:
        VolumeGroupState vgs = new VolumeGroupState(this, avg, null);     // Catch: IllegalArgumentException -> L12
        sVolumeGroupStates.append(avg.getId(), vgs);     // Catch: IllegalArgumentException -> L12
        if (vgs.isVoiceCall() == false) goto L4;
        voiceCallGroup = vgs;
    L17:
        Log.d(TAG, "volume group " + avg.name() + " for internal policy needs");
        goto L4
    L19:
        if (btScoGroupId < 0) goto L22;
        if (voiceCallGroup == null) goto L22;
        sVolumeGroupStates.append(btScoGroupId, voiceCallGroup);
    L22:
        Object r3 = this.mSettingsLock;
        monitor-enter(r3);
        int i = 0;
    L35:
    L28:
        th = move-exception;
        throw th;
    L26:
        if (i >= sVolumeGroupStates.size()) goto L31;
        sVolumeGroupStates.valueAt(i).applyAllVolumes(false);     // Catch: Throwable -> L28
        i = i + 1;     // Catch: Throwable -> L28
        goto L35
    L31:
        monitor-exit(r3);     // Catch: Throwable -> L28
    }

    private boolean ensureValidVolumeGroup(AudioVolumeGroup avg) {
        boolean hasAtLeastOneValidAudioAttributes = avg.getAudioAttributes().stream().anyMatch(new AudioService$$ExternalSyntheticLambda1());
        if (hasAtLeastOneValidAudioAttributes == false) goto L11;
        if (avg.getLegacyStreamTypes().length == 1) goto L7;
    L9:
        return true;
    L7:
        if (avg.getLegacyStreamTypes()[0] != 6) goto L9;
        return false;
    L11:
        throw new IllegalArgumentException("Volume Group " + avg.name() + " has no valid audio attributes");
    }

    private static /* synthetic */ boolean lambda$ensureValidVolumeGroup$17(AudioAttributes aa) {
        return !aa.equals(AudioProductStrategy.getDefaultAttributes());
    }

    private boolean shouldPreserveVolume(boolean userSwitch, VolumeGroupState vgs) {
        if (userSwitch == true) goto L4;
    L8:
        return false;
    L4:
        if (vgs.isMusic() == false) goto L8;
        if (isPlatformAutomotive() == true) goto L8;
        return true;
    }

    private void readVolumeGroupsSettings(boolean userSwitch) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        Object r1 = this.mVolumeStateLock;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        Log.d(TAG, "readVolumeGroupsSettings userSwitch=" + userSwitch);     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= sVolumeGroupStates.size()) goto L16;
        VolumeGroupState vgs = sVolumeGroupStates.valueAt(i);     // Catch: Throwable -> L12
        if (shouldPreserveVolume(userSwitch, vgs) == true) goto L14;
        vgs.clearIndexCache();     // Catch: Throwable -> L12
        vgs.readSettings();     // Catch: Throwable -> L12
    L14:
        vgs.applyAllVolumes(userSwitch);     // Catch: Throwable -> L12
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    private void restoreVolumeGroups() {
        Log.v(TAG, "restoreVolumeGroups");
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= sVolumeGroupStates.size()) goto L11;
        VolumeGroupState vgs = sVolumeGroupStates.valueAt(i);     // Catch: Throwable -> L8
        vgs.applyAllVolumes(false);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void dumpVolumeGroups(PrintWriter pw) {
        pw.println("\nVolume Groups (device: index)");
        int i = 0;
    L4:
        if (i >= sVolumeGroupStates.size()) goto L7;
        VolumeGroupState vgs = sVolumeGroupStates.valueAt(i);
        VolumeGroupState.m2120$$Nest$mdump(vgs, pw);
        pw.println("");
        i = i + 1;
        goto L4
    }

    private static boolean isCallStream(int stream) {
        if (stream != 0) goto L4;
    L7:
        return true;
    L4:
        if (stream == 6) goto L7;
        return false;
    }

    private static int getVolumeGroupForStreamType(int stream) {
        AudioAttributes attributes = AudioProductStrategy.getAudioAttributesForStrategyWithLegacyStreamType(stream);
        if (attributes.equals(new AudioAttributes.Builder().build()) == false) goto L7;
        return -1;
    L7:
        return AudioProductStrategy.getVolumeGroupIdForAudioAttributes(attributes, false);
    }

    public void postSetVolumeIndexOnDevice(int streamType, int vssVolIndex, int device, String caller) {
        sendMsg(this.mAudioHandler, 26, 2, 0, 0, new DeviceVolumeUpdate(streamType, vssVolIndex, device, caller), 0);
    }

    void postApplyVolumeOnDevice(int streamType, int device, String caller) {
        sendMsg(this.mAudioHandler, 26, 2, 0, 0, new DeviceVolumeUpdate(streamType, device, caller), 0);
    }

    private void onSetVolumeIndexOnDevice(DeviceVolumeUpdate update) {
        VolumeStreamState streamState = getVssForStream(update.mStreamType);
        if (streamState != null) goto L7;
        Log.w(TAG, "Invalid onSetVolumeIndexOnDevice for stream type " + update.mStreamType);
        return;
    L7:
        if (update.hasVolumeIndex() == false) goto L12;
        int index = update.getVolumeIndex();
        if (this.mSoundDoseHelper.checkSafeMediaVolume(update.mStreamType, index, update.mDevice) == false) goto L11;
        index = this.mSoundDoseHelper.safeMediaVolumeIndex(update.mDevice);
    L11:
        streamState.setIndex(index, update.mDevice, update.mCaller, true);
        sVolumeLogger.enqueue(new EventLogger.StringEvent(update.mCaller + " dev:0x" + Integer.toHexString(update.mDevice) + " volIdx:" + index));
    L13:
        setDeviceVolume(streamState, update.mDevice);
        return;
    L12:
        sVolumeLogger.enqueue(new EventLogger.StringEvent(update.mCaller + " update vol on dev:0x" + Integer.toHexString(update.mDevice)));
        goto L13
    }

    void setDeviceVolume(VolumeStreamState streamState, int device) {
        Object r8 = this.mVolumeStateLock;
        monitor-enter(r8);
        AudioHandler r1 = this.mAudioHandler;     // Catch: Throwable -> L13
        if (isAbsoluteVolumeDevice(device) == false) goto L7;
    L15:
        int r0 = 1;
    L16:
        sendMsg(r1, 1006, 2, device, r0, streamState, 0);     // Catch: Throwable -> L13
        streamState.applyDeviceVolume_syncVSS(device);     // Catch: Throwable -> L13
        int numStreamTypes = AudioSystem.getNumStreamTypes();     // Catch: Throwable -> L13
        int streamType = numStreamTypes - 1;     // Catch: Throwable -> L13
    L17:
        if (streamType < 0) goto L36;
        VolumeStreamState vss = getVssForStream(streamType);     // Catch: Throwable -> L13
        if (vss == null) goto L34;
        if (streamType == VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState)) goto L34;
        if (sStreamVolumeAlias.get(streamType, -1) != VolumeStreamState.m2127$$Nest$fgetmStreamType(streamState)) goto L34;
        int streamDevice = getDeviceForStream(streamType);     // Catch: Throwable -> L13
        if (device != streamDevice) goto L27;
    L33:
        vss.applyDeviceVolume_syncVSS(streamDevice);     // Catch: Throwable -> L13
        goto L34
    L27:
        if (isAbsoluteVolumeDevice(device) == false) goto L29;
    L32:
        vss.applyDeviceVolume_syncVSS(device);     // Catch: Throwable -> L13
        goto L33
    L29:
        if (isA2dpAbsoluteVolumeDevice(device) == true) goto L32;
        if (AudioSystem.isLeAudioDeviceType(device) == false) goto L33;
    L34:
        streamType = streamType - 1;     // Catch: Throwable -> L13
        goto L17
    L36:
        monitor-exit(r8);     // Catch: Throwable -> L13
        sendMsg(this.mAudioHandler, 1, 2, device, 0, streamState, 500);
        return;
    L7:
        if (isA2dpAbsoluteVolumeDevice(device) == true) goto L15;
        if (AudioSystem.isLeAudioDeviceType(device) == true) goto L15;
        r0 = 0;
    L13:
        th = move-exception;
        throw th;
    }

    private void avrcpSupportsAbsoluteVolume(String address, boolean support) {
        sVolumeLogger.enqueue(new EventLogger.StringEvent("avrcpSupportsAbsoluteVolume addr=" + Utils.anonymizeBluetoothAddress(address) + " support=" + support).printLog(TAG));
        this.mDeviceBroker.setAvrcpAbsoluteVolumeSupported(support);
        setAvrcpAbsoluteVolumeSupported(support);
    }

    void setAvrcpAbsoluteVolumeSupported(boolean support) {
        Log.i(TAG, "setAvrcpAbsoluteVolumeSupported support " + support);
        Object r1 = this.mCachedAbsVolDrivingStreamsLock;
        monitor-enter(r1);
        this.mAvrcpAbsVolSupported = support;     // Catch: Throwable -> L10
        final int a2dpDev = 128;
        this.mCachedAbsVolDrivingStreams.compute(128, new AudioService$$ExternalSyntheticLambda6(this, a2dpDev));     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        sendMsg(this.mAudioHandler, 0, 2, 128, 0, getVssForStreamOrDefault(3), 0);
        if (sStreamVolumeAlias.get(11, -1) != 11) goto L15;
        sendMsg(this.mAudioHandler, 0, 2, 128, 0, this.mStreamStates.get(11), 0);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Integer lambda$setAvrcpAbsoluteVolumeSupported$18(int a2dpDev, Integer dev, Integer stream) {
        if (this.mAvrcpAbsVolSupported == true) goto L9;
        int result = this.mAudioSystem.setDeviceAbsoluteVolumeEnabled(a2dpDev, "", false, -1);
        if (result == 0) goto L18;
        sVolumeLogger.enqueueAndSlog(new AudioServiceEvents.VolumeEvent(13, result, a2dpDev, false, -1).eventToString(), 1, TAG);
        return null;
    L18:
        return null;
    L9:
        int streamToDriveAbs = getBluetoothContextualVolumeStream();
        if (stream != null) goto L12;
    L13:
        int result2 = this.mAudioSystem.setDeviceAbsoluteVolumeEnabled(a2dpDev, "", true, streamToDriveAbs);
        if (result2 == 0) goto L17;
        sVolumeLogger.enqueueAndSlog(new AudioServiceEvents.VolumeEvent(13, result2, a2dpDev, true, streamToDriveAbs).eventToString(), 1, TAG);
    L17:
        return Integer.valueOf(streamToDriveAbs);
    L12:
        if (stream.intValue() == streamToDriveAbs) goto L17;
        goto L13
    }

    public boolean hasMediaDynamicPolicy() {
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioPolicies.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        Collection<AudioPolicyProxy> appColl = this.mAudioPolicies.values();     // Catch: Throwable -> L8
        Iterator<AudioPolicyProxy> r3 = appColl.iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L18;
        AudioPolicyProxy app = r3.next();     // Catch: Throwable -> L8
        if (app.hasMixAffectingUsage(1, 3) == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    }

    public void checkMusicActive(int deviceType, String caller) {
        if (this.mSoundDoseHelper.safeDevicesContains(deviceType) == false) goto L6;
        this.mSoundDoseHelper.scheduleMusicActiveCheck();
        return;
    }

    private void killBackgroundUserProcessesWithRecordAudioPermission(UserInfo oldUser) {
        PackageManager pm = this.mContext.getPackageManager();
        ComponentName homeActivityName = null;
        if (oldUser.isManagedProfile() == true) goto L5;
        homeActivityName = ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).getHomeActivityForUser(oldUser.id);
    L5:
        String[] permissions = {"android.permission.RECORD_AUDIO"};
        List<PackageInfo> packages = AppGlobals.getPackageManager().getPackagesHoldingPermissions(permissions, 0, oldUser.id).getList();     // Catch: RemoteException -> L29
        int j = packages.size() - 1;
    L8:
        if (j < 0) goto L28;
        PackageInfo pkg = packages.get(j);
        if (UserHandle.getAppId(pkg.applicationInfo.uid) < 10000) goto L26;
        if (pm.checkPermission("android.permission.INTERACT_ACROSS_USERS", pkg.packageName) == 0) goto L26;
        if (homeActivityName != null) goto L18;
    L32:
        int uid = pkg.applicationInfo.uid;     // Catch: RemoteException -> L24
        ActivityManager.getService().killUid(UserHandle.getAppId(uid), UserHandle.getUserId(uid), "killBackgroundUserProcessesWithAudioRecordPermission");     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        Log.w(TAG, "Error calling killUid", e);
        goto L26
    L18:
        if (pkg.packageName.equals(homeActivityName.getPackageName()) == false) goto L32;
        if (pkg.applicationInfo.isSystemApp() == false) goto L32;
    L26:
        j = j - 1;
        goto L8
    L28:
        return;
    L29:
        e = move-exception;
        throw new AndroidRuntimeException(e);
    }

    private void setupPermissionListener() {
        Executor r0 = this.mAudioServerLifecycleExecutor;
        if ((r0 instanceof ScheduledExecutorService) == false) goto L9;
        final ScheduledExecutorService exec = (ScheduledExecutorService) r0;
        Runnable task = new AudioService$$ExternalSyntheticLambda24(this, exec);
        if (PropertyInvalidatedCache.separatePermissionNotificationsEnabled() == false) goto L7;
        this.mCacheWatcher = new CacheWatcher(task);
        this.mCacheWatcher.start();
        return;
    L7:
        this.mSysPropListenerNativeHandle = this.mAudioSystem.listenForSystemPropertyChange(PermissionManager.CACHE_KEY_PACKAGE_INFO_NOTIFY, task);
        return;
    L9:
        this.mAudioSystem.listenForSystemPropertyChange(PermissionManager.CACHE_KEY_PACKAGE_INFO_NOTIFY, new AudioService$$ExternalSyntheticLambda25(this));
    }

    private /* synthetic */ void lambda$setupPermissionListener$20(ScheduledExecutorService exec) {
        List<Future> r0 = this.mScheduledPermissionTasks;
        monitor-enter(r0);
        this.mScheduledPermissionTasks.add(exec.schedule(new AudioService$$ExternalSyntheticLambda15(this), getAudioPermissionsDelay(), TimeUnit.MILLISECONDS));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$setupPermissionListener$19() {
        List<Future> r0 = this.mScheduledPermissionTasks;     // Catch: Exception -> L21
        monitor-enter(r0);     // Catch: Exception -> L21
        Iterator<Future> iter = this.mScheduledPermissionTasks.iterator();     // Catch: Throwable -> L8
    L6:
        if (iter.next().isDone() == false) goto L11;
        iter.remove();     // Catch: Throwable -> L8
    L11:
        if (iter.hasNext() == false) goto L18;
        if (iter.next().cancel(false) == false) goto L16;
        iter.remove();     // Catch: Throwable -> L8
        goto L11
    L16:
        throw new AssertionError("Cancel should be infallible since wecancel from the executor");     // Catch: Throwable -> L8
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mPermissionProvider.onPermissionStateChanged();     // Catch: Exception -> L21
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
    }

    private /* synthetic */ void lambda$setupPermissionListener$21() {
        Executor r0 = this.mAudioServerLifecycleExecutor;
        final AudioServerPermissionProvider r1 = this.mPermissionProvider;
        r1.getClass();
        r0.execute(new AudioService$$ExternalSyntheticLambda0(r1));
    }

    private boolean forceFocusDuckingForAccessibility(AudioAttributes aa, int request, int uid) {
        if (aa != null) goto L5;
    L36:
        return false;
    L5:
        if (aa.getUsage() != 11) goto L36;
        if (request != 3) goto L36;
        Bundle extraInfo = aa.getBundle();
        if (extraInfo != null) goto L12;
    L35:
        return false;
    L12:
        if (extraInfo.getBoolean("a11y_force_ducking") == false) goto L35;
        if (uid != 0) goto L17;
        return true;
    L17:
        Object r3 = this.mAccessibilityServiceUidsLock;
        monitor-enter(r3);
    L28:
        th = move-exception;
        throw th;
    L20:
        if (this.mAccessibilityServiceUids == null) goto L31;
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L28
        int i = 0;
    L23:
        if (i >= this.mAccessibilityServiceUids.length) goto L31;
        if (this.mAccessibilityServiceUids[i] == callingUid) goto L26;
        i = i + 1;     // Catch: Throwable -> L28
        goto L23
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L28
        return true;
    L31:
        monitor-exit(r3);     // Catch: Throwable -> L28
        return false;
    }

    private boolean isSupportedSystemUsage(int usage) {
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
        int i = 0;
    L21:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSupportedSystemUsages.length) goto L16;
        if (this.mSupportedSystemUsages[i] == usage) goto L9;
        i = i + 1;     // Catch: Throwable -> L12
        goto L21
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    private void validateAudioAttributesUsage(AudioAttributes audioAttributes) {
        int usage = audioAttributes.getSystemUsage();
        if (AudioAttributes.isSystemUsage(usage) == true) goto L5;
        return;
    L5:
        if (usage != 17) goto L12;
        if ((audioAttributes.getAllFlags() & 65536) == 0) goto L12;
        if (callerHasPermission("android.permission.CALL_AUDIO_INTERCEPTION") == false) goto L12;
    L14:
        if (isSupportedSystemUsage(usage) == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("Unsupported usage " + AudioAttributes.usageToString(usage));
    L12:
        if (callerHasPermission("android.permission.MODIFY_AUDIO_ROUTING") == true) goto L14;
        throw new SecurityException("Missing MODIFY_AUDIO_ROUTING permission");
    }

    private boolean isValidAudioAttributesUsage(AudioAttributes audioAttributes) {
        int usage = audioAttributes.getSystemUsage();
        if (AudioAttributes.isSystemUsage(usage) == true) goto L5;
        return true;
    L5:
        if (isSupportedSystemUsage(usage) == true) goto L7;
    L16:
        return false;
    L7:
        if (usage != 17) goto L14;
        if ((audioAttributes.getAllFlags() & 65536) == 0) goto L14;
        if (callerHasPermission("android.permission.CALL_AUDIO_INTERCEPTION") == false) goto L14;
        return true;
    L14:
        if (callerHasPermission("android.permission.MODIFY_AUDIO_ROUTING") == false) goto L16;
        return true;
    }

    public int requestAudioFocus(AudioAttributes aa, int focusReqType, IBinder cb, IAudioFocusDispatcher fd, String clientId, String callingPackageName, String attributionTag, int flags, IAudioPolicyCallback pcb, int sdk) {
        if ((flags & 8) != 0) goto L74;
        int uid = Binder.getCallingUid();
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.service.focus").setUid(uid).set(MediaMetrics.Property.CALLING_PACKAGE, callingPackageName).set(MediaMetrics.Property.CLIENT_NAME, clientId).set(MediaMetrics.Property.EVENT, "requestAudioFocus").set(MediaMetrics.Property.FLAGS, Integer.valueOf(flags));
        if (this.mActivityManagerInternal.getObricActivityManagerInternal().isMutedApp(uid, callingPackageName) == false) goto L8;
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "can not request focus in auto action").record();
        Log.d(TAG, "requestAudioFocus failed: can not request focus in auto action");
        return 0;
    L8:
        if (aa == null) goto L14;
        if (isValidAudioAttributesUsage(aa) == true) goto L14;
        Log.w(TAG, "Request using unsupported usage");
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "Request using unsupported usage").record();
        return 0;
    L14:
        if ((flags & 4) == 4) goto L16;
    L34:
        if (callingPackageName == null) goto L71;
        if (clientId == null) goto L71;
        if (aa == null) goto L71;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS_PRIVILEGED") != 0) goto L41;
    L47:
        boolean permissionOverridesCheck = true;
    L48:
        long token = Binder.clearCallingIdentity();
        if (permissionOverridesCheck == true) goto L75;
    L54:
        if (permissionOverridesCheck == true) goto L68;
        if (this.mHardeningEnforcer.blockFocusMethod(uid, 300, clientId, focusReqType, callingPackageName, attributionTag, sdk) == false) goto L68;
        Log.w(TAG, "Audio focus request blocked by hardening");     // Catch: Throwable -> L61
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "Audio focus request blocked by hardening").record();     // Catch: Throwable -> L61
        Binder.restoreCallingIdentity(token);
        return 0;
    L61:
        th = th;
    L65:
        Binder.restoreCallingIdentity(token);
        throw th;
    L63:
        th = th;
    L68:
        Binder.restoreCallingIdentity(token);
        mmi.record();
        return this.mMediaFocusControl.requestAudioFocus(aa, focusReqType, cb, fd, clientId, callingPackageName, flags, sdk, forceFocusDuckingForAccessibility(aa, focusReqType, uid), -1, permissionOverridesCheck);
    L75:
        this.mHardeningEnforcer.metricsLogFocusReq(false, focusReqType, uid, false);     // Catch: Throwable -> L52
    L52:
        th = th;
        goto L65
    L41:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") == 0) goto L47;
        if (uid >= 10000) goto L46;
        permissionOverridesCheck = true;
        goto L48
    L46:
        permissionOverridesCheck = false;
    L71:
        Log.e(TAG, "Invalid null parameter to request audio focus");
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "Invalid null parameter to request audio focus").record();
        return 0;
    L16:
        if ("AudioFocus_For_Phone_Ring_And_Calls".equals(clientId) == true) goto L18;
        HashMap<IBinder, AudioPolicyProxy> r4 = this.mAudioPolicies;
        monitor-enter(r4);
    L28:
        th = move-exception;
        throw th;
    L24:
        if (this.mAudioPolicies.containsKey(pcb.asBinder()) == true) goto L30;
        Log.e(TAG, "Invalid unregistered AudioPolicy to (un)lock audio focus");     // Catch: Throwable -> L28
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "Invalid unregistered AudioPolicy to (un)lock audio focus").record();     // Catch: Throwable -> L28
        monitor-exit(r4);     // Catch: Throwable -> L28
        return 0;
    L30:
        monitor-exit(r4);     // Catch: Throwable -> L28
        goto L34
    L18:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") == 0) goto L34;
        Log.e(TAG, "Invalid permission to (un)lock audio focus", new Exception());
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "Invalid permission to (un)lock audio focus").record();
        return 0;
    L74:
        throw new IllegalArgumentException("Invalid test flag");
    }

    public int requestAudioFocusForTest(AudioAttributes aa, int focusReqType, IBinder cb, IAudioFocusDispatcher fd, String clientId, String callingPackageName, int flags, int fakeUid, int sdk) {
        if (enforceQueryAudioStateForTest("focus request") == true) goto L5;
        return 0;
    L5:
        if (callingPackageName == null) goto L11;
        if (clientId == null) goto L11;
        if (aa == null) goto L11;
        return this.mMediaFocusControl.requestAudioFocus(aa, focusReqType, cb, fd, clientId, callingPackageName, flags, sdk, false, fakeUid, true);
    L11:
        Log.e(TAG, "Invalid null parameter to request audio focus");
        return 0;
    }

    public int abandonAudioFocus(IAudioFocusDispatcher fd, String clientId, AudioAttributes aa, String callingPackageName) {
        MediaMetrics.Item mmi = new MediaMetrics.Item("audio.service.focus").set(MediaMetrics.Property.CALLING_PACKAGE, callingPackageName).set(MediaMetrics.Property.CLIENT_NAME, clientId).set(MediaMetrics.Property.EVENT, "abandonAudioFocus");
        boolean r0 = false;
        if (aa != null) goto L5;
    L8:
        mmi.record();
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L17;
        if (aa == null) goto L14;
        if (aa.getUsage() != 2) goto L14;
    L15:
        r0 = true;
    L14:
        if ("AudioFocus_For_Phone_Ring_And_Calls".equals(clientId) == true) goto L15;
    L17:
        boolean abandonFromTelecom = r0;
        if (abandonFromTelecom == false) goto L43;
        Object r7 = this.mAudioModeResetLock;
        monitor-enter(r7);
        long start = System.currentTimeMillis();     // Catch: Throwable -> L28
        long elapsed = 0;
    L23:
        if (this.mAudioModeResetCount <= 0) goto L36;
        Log.i(TAG, "Abandon focus from Telecom, waiting for mode change");     // Catch: Throwable -> L28
        this.mAudioModeResetLock.wait(3000 - elapsed);     // Catch: Throwable -> L28 InterruptedException -> L30
    L32:
        elapsed = System.currentTimeMillis() - start;     // Catch: Throwable -> L28
        if (elapsed < 3000) goto L23;
        Log.e(TAG, "Timeout waiting for audio mode reset");     // Catch: Throwable -> L28
        resetAudioModeResetCount();     // Catch: Throwable -> L28
        goto L36
    L31:
        Log.w(TAG, "Interrupted while waiting for audio mode reset");     // Catch: Throwable -> L28
    L36:
        if (elapsed == 0) goto L38;
        Log.i(TAG, "Abandon focus from Telecom done waiting");     // Catch: Throwable -> L28
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L43:
        return this.mMediaFocusControl.abandonAudioFocus(fd, clientId, aa, callingPackageName);
    L5:
        if (isValidAudioAttributesUsage(aa) == true) goto L8;
        Log.w(TAG, "Request using unsupported usage.");
        mmi.set(MediaMetrics.Property.EARLY_RETURN, "unsupported usage").record();
        return 0;
    }

    void decrementAudioModeResetCount() {
        Object r0 = this.mAudioModeResetLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioModeResetCount <= 0) goto L9;
        this.mAudioModeResetCount--;     // Catch: Throwable -> L7
    L10:
        this.mAudioModeResetLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Log.w(TAG, "mAudioModeResetCount already 0");     // Catch: Throwable -> L7
        goto L10
    }

    private void resetAudioModeResetCount() {
        Object r0 = this.mAudioModeResetLock;
        monitor-enter(r0);
        this.mAudioModeResetCount = 0;     // Catch: Throwable -> L8
        this.mAudioModeResetLock.notify();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int abandonAudioFocusForTest(IAudioFocusDispatcher fd, String clientId, AudioAttributes aa, String callingPackageName) {
        if (enforceQueryAudioStateForTest("focus abandon") == true) goto L7;
        return 0;
    L7:
        return this.mMediaFocusControl.abandonAudioFocus(fd, clientId, aa, callingPackageName);
    }

    public List<Integer> getFocusDuckedUidsForTest() {
        super.getFocusDuckedUidsForTest_enforcePermission();
        return this.mPlaybackMonitor.getFocusDuckedUids();
    }

    public void unregisterAudioFocusClient(String clientId) {
        new MediaMetrics.Item("audio.service.focus").set(MediaMetrics.Property.CLIENT_NAME, clientId).set(MediaMetrics.Property.EVENT, "unregisterAudioFocusClient").record();
        this.mMediaFocusControl.unregisterAudioFocusClient(clientId);
    }

    public int getCurrentAudioFocus() {
        return this.mMediaFocusControl.getCurrentAudioFocus();
    }

    public int getFocusRampTimeMs(int focusGain, AudioAttributes attr) {
        return MediaFocusControl.getFocusRampTimeMs(focusGain, attr);
    }

    public long getFocusFadeOutDurationForTest() {
        super.getFocusFadeOutDurationForTest_enforcePermission();
        return this.mMediaFocusControl.getFocusFadeOutDurationForTest();
    }

    public long getFocusUnmuteDelayAfterFadeOutForTest() {
        super.getFocusUnmuteDelayAfterFadeOutForTest_enforcePermission();
        return this.mMediaFocusControl.getFocusUnmuteDelayAfterFadeOutForTest();
    }

    public boolean enterAudioFocusFreezeForTest(IBinder cb, int[] exemptedUids) {
        super.enterAudioFocusFreezeForTest_enforcePermission();
        exemptedUids.getClass();
        cb.getClass();
        return this.mMediaFocusControl.enterAudioFocusFreezeForTest(cb, exemptedUids);
    }

    public boolean exitAudioFocusFreezeForTest(IBinder cb) {
        super.exitAudioFocusFreezeForTest_enforcePermission();
        cb.getClass();
        return this.mMediaFocusControl.exitAudioFocusFreezeForTest(cb);
    }

    public boolean hasAudioFocusUsers() {
        return this.mMediaFocusControl.hasAudioFocusUsers();
    }

    public long getFadeOutDurationOnFocusLossMillis(AudioAttributes aa) {
        if (enforceQueryAudioStateForTest("fade out duration") == true) goto L7;
        return 0;
    L7:
        return this.mMediaFocusControl.getFadeOutDurationOnFocusLossMillis(aa);
    }

    private boolean enforceQueryAudioStateForTest(String mssg) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.QUERY_AUDIO_STATE") == 0) goto L6;
        String reason = "Doesn't have QUERY_AUDIO_STATE permission for " + mssg + " test API";
        Log.e(TAG, reason, new Exception());
        return false;
    L6:
        return true;
    }

    private void enforceModifyDefaultAudioEffectsPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_DEFAULT_AUDIO_EFFECTS") != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Missing MODIFY_DEFAULT_AUDIO_EFFECTS permission");
    }

    public int getSpatializerImmersiveAudioLevel() {
        return this.mSpatializerHelper.getCapableImmersiveAudioLevel();
    }

    public boolean isSpatializerEnabled() {
        return this.mSpatializerHelper.isEnabled();
    }

    public boolean isSpatializerAvailable() {
        return this.mSpatializerHelper.isAvailable();
    }

    public boolean isSpatializerAvailableForDevice(AudioDeviceAttributes device) {
        super.isSpatializerAvailableForDevice_enforcePermission();
        SpatializerHelper r0 = this.mSpatializerHelper;
        device.getClass();
        return r0.isAvailableForDevice(device);
    }

    public boolean hasHeadTracker(AudioDeviceAttributes device) {
        super.hasHeadTracker_enforcePermission();
        SpatializerHelper r0 = this.mSpatializerHelper;
        device.getClass();
        return r0.hasHeadTracker(device);
    }

    public void setHeadTrackerEnabled(boolean enabled, AudioDeviceAttributes device) {
        super.setHeadTrackerEnabled_enforcePermission();
        SpatializerHelper r0 = this.mSpatializerHelper;
        device.getClass();
        r0.setHeadTrackerEnabled(enabled, device);
    }

    public boolean isHeadTrackerEnabled(AudioDeviceAttributes device) {
        super.isHeadTrackerEnabled_enforcePermission();
        SpatializerHelper r0 = this.mSpatializerHelper;
        device.getClass();
        return r0.isHeadTrackerEnabled(device);
    }

    public boolean isHeadTrackerAvailable() {
        return this.mSpatializerHelper.isHeadTrackerAvailable();
    }

    public void setSpatializerEnabled(boolean enabled) {
        super.setSpatializerEnabled_enforcePermission();
        this.mSpatializerHelper.setFeatureEnabled(enabled);
    }

    public boolean canBeSpatialized(AudioAttributes attributes, AudioFormat format) {
        attributes.getClass();
        format.getClass();
        return this.mSpatializerHelper.canBeSpatialized(attributes, format);
    }

    public List<Integer> getSpatializedChannelMasks() {
        return this.mSpatializerHelper.getSpatializedChannelMasks();
    }

    public void registerSpatializerCallback(ISpatializerCallback cb) {
        cb.getClass();
        this.mSpatializerHelper.registerStateCallback(cb);
    }

    public void unregisterSpatializerCallback(ISpatializerCallback cb) {
        cb.getClass();
        this.mSpatializerHelper.unregisterStateCallback(cb);
    }

    public void registerSpatializerHeadTrackingCallback(ISpatializerHeadTrackingModeCallback cb) {
        super.registerSpatializerHeadTrackingCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.registerHeadTrackingModeCallback(cb);
    }

    public void unregisterSpatializerHeadTrackingCallback(ISpatializerHeadTrackingModeCallback cb) {
        super.unregisterSpatializerHeadTrackingCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.unregisterHeadTrackingModeCallback(cb);
    }

    public void registerSpatializerHeadTrackerAvailableCallback(ISpatializerHeadTrackerAvailableCallback cb, boolean register) {
        cb.getClass();
        this.mSpatializerHelper.registerHeadTrackerAvailableCallback(cb, register);
    }

    public void registerHeadToSoundstagePoseCallback(ISpatializerHeadToSoundStagePoseCallback cb) {
        super.registerHeadToSoundstagePoseCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.registerHeadToSoundstagePoseCallback(cb);
    }

    public void unregisterHeadToSoundstagePoseCallback(ISpatializerHeadToSoundStagePoseCallback cb) {
        super.unregisterHeadToSoundstagePoseCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.unregisterHeadToSoundstagePoseCallback(cb);
    }

    public List<AudioDeviceAttributes> getSpatializerCompatibleAudioDevices() {
        super.getSpatializerCompatibleAudioDevices_enforcePermission();
        return this.mSpatializerHelper.getCompatibleAudioDevices();
    }

    public void addSpatializerCompatibleAudioDevice(AudioDeviceAttributes ada) {
        super.addSpatializerCompatibleAudioDevice_enforcePermission();
        ada.getClass();
        this.mSpatializerHelper.addCompatibleAudioDevice(ada);
    }

    public void removeSpatializerCompatibleAudioDevice(AudioDeviceAttributes ada) {
        super.removeSpatializerCompatibleAudioDevice_enforcePermission();
        ada.getClass();
        this.mSpatializerHelper.removeCompatibleAudioDevice(ada);
    }

    public int[] getSupportedHeadTrackingModes() {
        super.getSupportedHeadTrackingModes_enforcePermission();
        return this.mSpatializerHelper.getSupportedHeadTrackingModes();
    }

    public int getActualHeadTrackingMode() {
        super.getActualHeadTrackingMode_enforcePermission();
        return this.mSpatializerHelper.getActualHeadTrackingMode();
    }

    public int getDesiredHeadTrackingMode() {
        super.getDesiredHeadTrackingMode_enforcePermission();
        return this.mSpatializerHelper.getDesiredHeadTrackingMode();
    }

    public void setSpatializerGlobalTransform(float[] transform) {
        super.setSpatializerGlobalTransform_enforcePermission();
        transform.getClass();
        this.mSpatializerHelper.setGlobalTransform(transform);
    }

    public void recenterHeadTracker() {
        super.recenterHeadTracker_enforcePermission();
        this.mSpatializerHelper.recenterHeadTracker();
    }

    public void setDesiredHeadTrackingMode(int mode) {
        super.setDesiredHeadTrackingMode_enforcePermission();
        switch(mode) {
            case -1: goto L5;
            case 0: goto L4;
            case 1: goto L5;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        this.mSpatializerHelper.setDesiredHeadTrackingMode(mode);
    }

    public void setSpatializerParameter(int key, byte[] value) {
        super.setSpatializerParameter_enforcePermission();
        value.getClass();
        this.mSpatializerHelper.setEffectParameter(key, value);
    }

    public void getSpatializerParameter(int key, byte[] value) {
        super.getSpatializerParameter_enforcePermission();
        value.getClass();
        this.mSpatializerHelper.getEffectParameter(key, value);
    }

    public int getSpatializerOutput() {
        super.getSpatializerOutput_enforcePermission();
        return this.mSpatializerHelper.getOutput();
    }

    public void registerSpatializerOutputCallback(ISpatializerOutputCallback cb) {
        super.registerSpatializerOutputCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.registerSpatializerOutputCallback(cb);
    }

    public void unregisterSpatializerOutputCallback(ISpatializerOutputCallback cb) {
        super.unregisterSpatializerOutputCallback_enforcePermission();
        cb.getClass();
        this.mSpatializerHelper.unregisterSpatializerOutputCallback(cb);
    }

    void postInitSpatializerHeadTrackingSensors() {
        sendMsg(this.mAudioHandler, 42, 0, 0, 0, TAG, 0);
    }

    void postResetSpatializer() {
        sendMsg(this.mAudioHandler, 50, 0, 0, 0, TAG, 0);
    }

    void onInitAdiDeviceStates() {
        this.mDeviceBroker.onReadAudioDeviceSettings();
        this.mSoundDoseHelper.initCachedAudioDeviceCategories(this.mDeviceBroker.getImmutableDeviceInventory());
    }

    void onInitSpatializer() {
        this.mSpatializerHelper.init(this.mHasSpatializerEffect);
        this.mSpatializerHelper.setFeatureEnabled(this.mHasSpatializerEffect);
    }

    boolean isSADevice(AdiDeviceState deviceState) {
        return this.mSpatializerHelper.isSADevice(deviceState);
    }

    private boolean isBluetoothPrividged() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L5;
    L8:
        return true;
    L5:
        if (Binder.getCallingUid() == 1000) goto L8;
        return false;
    }

    List<AudioDeviceAttributes> retrieveBluetoothAddresses(List<AudioDeviceAttributes> devices) {
        if (isBluetoothPrividged() == false) goto L5;
        return devices;
    L5:
        List<AudioDeviceAttributes> checkedDevices = new ArrayList();
        Iterator<AudioDeviceAttributes> r1 = devices.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        AudioDeviceAttributes ada = r1.next();
        if (ada == null) goto L7;
        checkedDevices.add(retrieveBluetoothAddressUncheked(ada));
        goto L7
    L12:
        return checkedDevices;
    }

    AudioDeviceAttributes retrieveBluetoothAddress(AudioDeviceAttributes ada) {
        if (isBluetoothPrividged() == false) goto L6;
        return ada;
    L6:
        return retrieveBluetoothAddressUncheked(ada);
    }

    AudioDeviceAttributes retrieveBluetoothAddressUncheked(AudioDeviceAttributes ada) {
        ada.getClass();
        if (AudioSystem.isBluetoothDevice(ada.getInternalType()) == false) goto L15;
        String anonymizedAddress = Utils.anonymizeBluetoothAddress(ada.getAddress());
        Iterator<AdiDeviceState> r1 = this.mDeviceBroker.getImmutableDeviceInventory().iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        AdiDeviceState ads = r1.next();
        if (AudioSystem.isBluetoothDevice(ads.getInternalDeviceType()) == false) goto L6;
        if (ada.getInternalType() != ads.getInternalDeviceType()) goto L6;
        if (anonymizedAddress.equals(Utils.anonymizeBluetoothAddress(ads.getDeviceAddress())) == false) goto L6;
        ada.setAddress(ads.getDeviceAddress());
    L15:
        return ada;
    }

    private List<AudioDeviceAttributes> anonymizeAudioDeviceAttributesList(List<AudioDeviceAttributes> devices) {
        if (isBluetoothPrividged() == false) goto L6;
        return devices;
    L6:
        return anonymizeAudioDeviceAttributesListUnchecked(devices);
    }

    List<AudioDeviceAttributes> anonymizeAudioDeviceAttributesListUnchecked(List<AudioDeviceAttributes> devices) {
        List<AudioDeviceAttributes> anonymizedDevices = new ArrayList();
        Iterator<AudioDeviceAttributes> r1 = devices.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        AudioDeviceAttributes ada = r1.next();
        anonymizedDevices.add(anonymizeAudioDeviceAttributesUnchecked(ada));
        goto L4
    L6:
        return anonymizedDevices;
    }

    private AudioDeviceAttributes anonymizeAudioDeviceAttributesUnchecked(AudioDeviceAttributes ada) {
        if (ada != null) goto L4;
    L8:
        return ada;
    L4:
        if (AudioSystem.isBluetoothDevice(ada.getInternalType()) == false) goto L8;
        AudioDeviceAttributes res = new AudioDeviceAttributes(ada);
        res.setAddress(Utils.anonymizeBluetoothAddress(ada.getAddress()));
        return res;
    }

    private AudioDeviceAttributes anonymizeAudioDeviceAttributes(AudioDeviceAttributes ada) {
        if (isBluetoothPrividged() == false) goto L6;
        return ada;
    L6:
        return anonymizeAudioDeviceAttributesUnchecked(ada);
    }

    public void registerLoudnessCodecUpdatesDispatcher(ILoudnessCodecUpdatesDispatcher dispatcher) {
        this.mLoudnessCodecHelper.registerLoudnessCodecUpdatesDispatcher(dispatcher);
    }

    public void unregisterLoudnessCodecUpdatesDispatcher(ILoudnessCodecUpdatesDispatcher dispatcher) {
        this.mLoudnessCodecHelper.unregisterLoudnessCodecUpdatesDispatcher(dispatcher);
    }

    public void startLoudnessCodecUpdates(int sessionId) {
        this.mLoudnessCodecHelper.startLoudnessCodecUpdates(sessionId);
    }

    public void stopLoudnessCodecUpdates(int sessionId) {
        this.mLoudnessCodecHelper.stopLoudnessCodecUpdates(sessionId);
    }

    public void addLoudnessCodecInfo(int sessionId, int mediaCodecHash, LoudnessCodecInfo codecInfo) {
        this.mLoudnessCodecHelper.addLoudnessCodecInfo(sessionId, mediaCodecHash, codecInfo);
    }

    public void removeLoudnessCodecInfo(int sessionId, LoudnessCodecInfo codecInfo) {
        this.mLoudnessCodecHelper.removeLoudnessCodecInfo(sessionId, codecInfo);
    }

    public PersistableBundle getLoudnessParams(LoudnessCodecInfo codecInfo) {
        return this.mLoudnessCodecHelper.getLoudnessParams(codecInfo);
    }

    private boolean readCameraSoundForced() {
        if (SystemProperties.getBoolean("audio.camerasound.force", false) == false) goto L5;
    L18:
        return true;
    L5:
        if (this.mContext.getResources().getBoolean(R.bool.config_canSwitchToHeadlessSystemUser) == true) goto L18;
        SubscriptionManager subscriptionManager = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (subscriptionManager != null) goto L11;
        Log.e(TAG, "readCameraSoundForced cannot create SubscriptionManager!");
        return false;
    L11:
        int[] subscriptionIds = subscriptionManager.getActiveSubscriptionIdList(false);
        int r5 = subscriptionIds.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L17;
        int subId = subscriptionIds[r6];
        if (SubscriptionManager.getResourcesForSubId(this.mContext, subId).getBoolean(R.bool.config_canSwitchToHeadlessSystemUser) == true) goto L15;
        r6 = r6 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    public void muteAwaitConnection(final int[] usages, AudioDeviceAttributes device, long timeOutMs) {
        usages.getClass();
        device.getClass();
        enforceModifyAudioRoutingPermission();
        final AudioDeviceAttributes ada = retrieveBluetoothAddress(device);
        if (timeOutMs <= 0) goto L25;
        if (usages.length == 0) goto L25;
        Log.i(TAG, "muteAwaitConnection dev:" + device + " timeOutMs:" + timeOutMs + " usages:" + Arrays.toString(usages));
        if (this.mDeviceBroker.isDeviceConnected(ada) == false) goto L10;
        Log.i(TAG, "muteAwaitConnection ignored, device (" + device + ") already connected");
        return;
    L10:
        Object r1 = this.mMuteAwaitConnectionLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        throw th;
    L13:
        if (this.mMutingExpectedDevice != null) goto L20;
        this.mMutingExpectedDevice = ada;     // Catch: Throwable -> L18
        this.mMutedUsagesAwaitingConnection = usages;     // Catch: Throwable -> L18
        this.mPlaybackMonitor.muteAwaitConnection(usages, ada, timeOutMs);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        dispatchMuteAwaitConnection(new AudioService$$ExternalSyntheticLambda33(this, ada, usages));
        return;
    L20:
        Log.e(TAG, "muteAwaitConnection ignored, another in progress for device:" + this.mMutingExpectedDevice);     // Catch: Throwable -> L18
        throw new IllegalStateException("muteAwaitConnection already in progress");     // Catch: Throwable -> L18
    L25:
        throw new IllegalArgumentException("Invalid timeOutMs/usagesToMute");
    }

    private /* synthetic */ void lambda$muteAwaitConnection$22(AudioDeviceAttributes ada, int[] usages, IMuteAwaitConnectionCallback cb, Boolean isPrivileged) {
        AudioDeviceAttributes dev = ada;
        if (isPrivileged.booleanValue() == true) goto L8;
        dev = anonymizeAudioDeviceAttributesUnchecked(ada);     // Catch: RemoteException -> L6
    L8:
        cb.dispatchOnMutedUntilConnection(dev, usages);     // Catch: RemoteException -> L6
        return;
    }

    public AudioDeviceAttributes getMutingExpectedDevice() {
        super.getMutingExpectedDevice_enforcePermission();
        Object r0 = this.mMuteAwaitConnectionLock;
        monitor-enter(r0);
        AudioDeviceAttributes r1 = anonymizeAudioDeviceAttributes(this.mMutingExpectedDevice);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void cancelMuteAwaitConnection(AudioDeviceAttributes device) {
        device.getClass();
        enforceModifyAudioRoutingPermission();
        final AudioDeviceAttributes ada = retrieveBluetoothAddress(device);
        Log.i(TAG, "cancelMuteAwaitConnection for device:" + device);
        Object r1 = this.mMuteAwaitConnectionLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mMutingExpectedDevice != null) goto L12;
        Log.i(TAG, "cancelMuteAwaitConnection ignored, no expected device");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (ada.equalTypeAddress(this.mMutingExpectedDevice) == false) goto L17;
        final int[] mutedUsages = this.mMutedUsagesAwaitingConnection;     // Catch: Throwable -> L9
        this.mMutingExpectedDevice = null;     // Catch: Throwable -> L9
        this.mMutedUsagesAwaitingConnection = null;     // Catch: Throwable -> L9
        this.mPlaybackMonitor.cancelMuteAwaitConnection("cancelMuteAwaitConnection dev:" + device);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        dispatchMuteAwaitConnection(new AudioService$$ExternalSyntheticLambda32(this, ada, mutedUsages));
        return;
    L17:
        Log.e(TAG, "cancelMuteAwaitConnection ignored, got " + device + "] but expected device is" + this.mMutingExpectedDevice);     // Catch: Throwable -> L9
        throw new IllegalStateException("cancelMuteAwaitConnection for wrong device");     // Catch: Throwable -> L9
    }

    private /* synthetic */ void lambda$cancelMuteAwaitConnection$23(AudioDeviceAttributes ada, int[] mutedUsages, IMuteAwaitConnectionCallback cb, Boolean isPrivileged) {
        AudioDeviceAttributes dev = ada;
        if (isPrivileged.booleanValue() == true) goto L8;
        dev = anonymizeAudioDeviceAttributesUnchecked(ada);     // Catch: RemoteException -> L6
    L8:
        cb.dispatchOnUnmutedEvent(3, dev, mutedUsages);     // Catch: RemoteException -> L6
        return;
    }

    public void registerMuteAwaitConnectionDispatcher(IMuteAwaitConnectionCallback cb, boolean register) {
        super.registerMuteAwaitConnectionDispatcher_enforcePermission();
        if (register == false) goto L5;
        this.mMuteAwaitConnectionDispatchers.register(cb, Boolean.valueOf(isBluetoothPrividged()));
        return;
    L5:
        this.mMuteAwaitConnectionDispatchers.unregister(cb);
    }

    void checkMuteAwaitConnection() {
        Object r0 = this.mMuteAwaitConnectionLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMutingExpectedDevice != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        final AudioDeviceAttributes device = this.mMutingExpectedDevice;     // Catch: Throwable -> L8
        final int[] mutedUsages = this.mMutedUsagesAwaitingConnection;     // Catch: Throwable -> L8
        if (this.mDeviceBroker.isDeviceConnected(device) == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mMutingExpectedDevice = null;     // Catch: Throwable -> L8
        this.mMutedUsagesAwaitingConnection = null;     // Catch: Throwable -> L8
        this.mPlaybackMonitor.cancelMuteAwaitConnection("checkMuteAwaitConnection device " + device + " connected, unmuting");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        dispatchMuteAwaitConnection(new AudioService$$ExternalSyntheticLambda13(this, device, mutedUsages));
    }

    private /* synthetic */ void lambda$checkMuteAwaitConnection$24(AudioDeviceAttributes device, int[] mutedUsages, IMuteAwaitConnectionCallback cb, Boolean isPrivileged) {
        AudioDeviceAttributes ada = device;
        if (isPrivileged.booleanValue() == true) goto L8;
        ada = anonymizeAudioDeviceAttributesUnchecked(device);     // Catch: RemoteException -> L6
    L8:
        cb.dispatchOnUnmutedEvent(1, ada, mutedUsages);     // Catch: RemoteException -> L6
        return;
    }

    void onMuteAwaitConnectionTimeout(final AudioDeviceAttributes timedOutDevice) {
        Object r0 = this.mMuteAwaitConnectionLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (timedOutDevice.equals(this.mMutingExpectedDevice) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Log.i(TAG, "muteAwaitConnection timeout, clearing expected device " + this.mMutingExpectedDevice);     // Catch: Throwable -> L8
        final int[] mutedUsages = this.mMutedUsagesAwaitingConnection;     // Catch: Throwable -> L8
        this.mMutingExpectedDevice = null;     // Catch: Throwable -> L8
        this.mMutedUsagesAwaitingConnection = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        dispatchMuteAwaitConnection(new AudioService$$ExternalSyntheticLambda8(timedOutDevice, mutedUsages));
    }

    private static /* synthetic */ void lambda$onMuteAwaitConnectionTimeout$25(AudioDeviceAttributes timedOutDevice, int[] mutedUsages, IMuteAwaitConnectionCallback cb, Boolean isPrivileged) {
        cb.dispatchOnUnmutedEvent(2, timedOutDevice, mutedUsages);     // Catch: RemoteException -> L5
        return;
    }

    private void dispatchMuteAwaitConnection(BiConsumer<IMuteAwaitConnectionCallback, Boolean> callback) {
        int nbDispatchers = this.mMuteAwaitConnectionDispatchers.beginBroadcast();
        ArrayList<IMuteAwaitConnectionCallback> errorList = null;
        int i = 0;
    L3:
        if (i >= nbDispatchers) goto L12;
        callback.accept((IMuteAwaitConnectionCallback) this.mMuteAwaitConnectionDispatchers.getBroadcastItem(i), (Boolean) this.mMuteAwaitConnectionDispatchers.getBroadcastCookie(i));     // Catch: Exception -> L6
    L10:
        i = i + 1;
    L7:
        if (errorList != null) goto L9;
        errorList = new ArrayList(1);
    L9:
        errorList.add(this.mMuteAwaitConnectionDispatchers.getBroadcastItem(i));
        goto L10
    L12:
        if (errorList == null) goto L17;
        Iterator<IMuteAwaitConnectionCallback> r2 = errorList.iterator();
    L15:
        if (r2.hasNext() == false) goto L17;
        IMuteAwaitConnectionCallback errorItem = r2.next();
        this.mMuteAwaitConnectionDispatchers.unregister(errorItem);
    L17:
        this.mMuteAwaitConnectionDispatchers.finishBroadcast();
    }

    public void registerDeviceVolumeBehaviorDispatcher(boolean register, IDeviceVolumeBehaviorDispatcher dispatcher) {
        enforceQueryStateOrModifyRoutingPermission();
        dispatcher.getClass();
        if (register == false) goto L5;
        this.mDeviceVolumeBehaviorDispatchers.register(dispatcher);
        return;
    L5:
        this.mDeviceVolumeBehaviorDispatchers.unregister(dispatcher);
    }

    private void dispatchDeviceVolumeBehavior(AudioDeviceAttributes device, int volumeBehavior) {
        int dispatchers = this.mDeviceVolumeBehaviorDispatchers.beginBroadcast();
        int i = 0;
    L3:
        if (i >= dispatchers) goto L8;
        this.mDeviceVolumeBehaviorDispatchers.getBroadcastItem(i).dispatchDeviceVolumeBehaviorChanged(device, volumeBehavior);     // Catch: RemoteException -> L6
    L7:
        i = i + 1;
        goto L3
    L8:
        this.mDeviceVolumeBehaviorDispatchers.finishBroadcast();
    }

    private void onConfigurationChanged() {
        Configuration config = this.mContext.getResources().getConfiguration();     // Catch: Exception -> L35
        int r4 = 0;
        this.mSoundDoseHelper.configureSafeMedia(false, TAG);     // Catch: Exception -> L35
        boolean cameraSoundForced = readCameraSoundForced();     // Catch: Exception -> L35
        if (this.mCameraSoundForced.getAndSet(cameraSoundForced) == cameraSoundForced) goto L6;
        boolean r0 = true;
    L7:
        boolean cameraSoundForcedChanged = r0;
        Object r7 = this.mSettingsLock;     // Catch: Exception -> L35
        monitor-enter(r7);     // Catch: Exception -> L35
        if (cameraSoundForcedChanged == true) goto L44;
    L32:
        monitor-exit(r7);     // Catch: Throwable -> L23
        this.mVolumeController.setLayoutDirection(config.getLayoutDirection());     // Catch: Exception -> L35
        return;
    L44:
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L11:
        if (this.mIsSingleVolume == true) goto L27;
        Object r9 = this.mVolumeStateLock;     // Catch: Throwable -> L23
        monitor-enter(r9);     // Catch: Throwable -> L23
        VolumeStreamState s = getVssForStreamOrDefault(7);     // Catch: Throwable -> L17
        if (cameraSoundForced == false) goto L19;
        s.setAllIndexesToMax();     // Catch: Throwable -> L17
        this.mRingerModeAffectedStreams &= -129;     // Catch: Throwable -> L17
    L20:
        monitor-exit(r9);     // Catch: Throwable -> L17
        setRingerModeInt(getRingerModeInternal(), false);     // Catch: Throwable -> L23
        goto L27
    L19:
        s.setAllIndexes(getVssForStreamOrDefault(1), TAG);     // Catch: Throwable -> L17
        this.mRingerModeAffectedStreams |= 128;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L27:
        AudioDeviceBroker r1 = this.mDeviceBroker;     // Catch: Throwable -> L23
        if (cameraSoundForced == false) goto L31;
        r4 = 11;
    L31:
        r1.setForceUse_Async(4, r4, "onConfigurationChanged");     // Catch: Throwable -> L23
        sendMsg(this.mAudioHandler, 10, 2, 0, 0, getVssForStreamOrDefault(7), 0);     // Catch: Throwable -> L23
        goto L32
    L6:
        r0 = false;
    L35:
        e = move-exception;
        Log.e(TAG, "Error handling configuration change: ", e);
    }

    public void setRingtonePlayer(IRingtonePlayer player) {
        setRingtonePlayer_enforcePermission();
        this.mRingtonePlayer = player;
    }

    public IRingtonePlayer getRingtonePlayer() {
        return this.mRingtonePlayer;
    }

    public AudioRoutesInfo startWatchingRoutes(IAudioRoutesObserver observer) {
        return this.mDeviceBroker.startWatchingRoutes(observer);
    }

    public void disableSafeMediaVolume(String callingPackage) {
        enforceVolumeController("disable the safe media volume");
        this.mSoundDoseHelper.disableSafeMediaVolume(callingPackage);
    }

    public void lowerVolumeToRs1(String callingPackage) {
        enforceVolumeController("lowerVolumeToRs1");
        postLowerVolumeToRs1();
    }

    void postLowerVolumeToRs1() {
        sendMsg(this.mAudioHandler, 1007, 2, 0, 0, null, 0);
    }

    public float getOutputRs2UpperBound() {
        super.getOutputRs2UpperBound_enforcePermission();
        return this.mSoundDoseHelper.getOutputRs2UpperBound();
    }

    public void setOutputRs2UpperBound(float rs2Value) {
        super.setOutputRs2UpperBound_enforcePermission();
        this.mSoundDoseHelper.setOutputRs2UpperBound(rs2Value);
    }

    public float getCsd() {
        super.getCsd_enforcePermission();
        return this.mSoundDoseHelper.getCsd();
    }

    public void setCsd(float csd) {
        super.setCsd_enforcePermission();
        if (csd >= 0.0f) goto L5;
        this.mSoundDoseHelper.resetCsdTimeouts();
        return;
    L5:
        this.mSoundDoseHelper.setCsd(csd);
    }

    public void forceUseFrameworkMel(boolean useFrameworkMel) {
        super.forceUseFrameworkMel_enforcePermission();
        this.mSoundDoseHelper.forceUseFrameworkMel(useFrameworkMel);
    }

    public void forceComputeCsdOnAllDevices(boolean computeCsdOnAllDevices) {
        super.forceComputeCsdOnAllDevices_enforcePermission();
        this.mSoundDoseHelper.forceComputeCsdOnAllDevices(computeCsdOnAllDevices);
    }

    public boolean isCsdEnabled() {
        super.isCsdEnabled_enforcePermission();
        return this.mSoundDoseHelper.isCsdEnabled();
    }

    public boolean isCsdAsAFeatureAvailable() {
        super.isCsdAsAFeatureAvailable_enforcePermission();
        return this.mSoundDoseHelper.isCsdAsAFeatureAvailable();
    }

    public boolean isCsdAsAFeatureEnabled() {
        super.isCsdAsAFeatureEnabled_enforcePermission();
        return this.mSoundDoseHelper.isCsdAsAFeatureEnabled();
    }

    public void setCsdAsAFeatureEnabled(boolean csdToggleValue) {
        super.setCsdAsAFeatureEnabled_enforcePermission();
        this.mSoundDoseHelper.setCsdAsAFeatureEnabled(csdToggleValue);
    }

    public boolean setBluetoothAudioDeviceCategory(String address, int btAudioDeviceCategory) {
        super.setBluetoothAudioDeviceCategory_enforcePermission();
        address.getClass();
        if (isBluetoothAudioDeviceCategoryFixed(address) == false) goto L6;
        Log.w(TAG, "Cannot set fixed audio device type for address " + Utils.anonymizeBluetoothAddress(address));
        return false;
    L6:
        this.mDeviceBroker.addAudioDeviceWithCategoryInInventoryIfNeeded(address, btAudioDeviceCategory);
        return true;
    }

    public int getBluetoothAudioDeviceCategory(String address) {
        super.getBluetoothAudioDeviceCategory_enforcePermission();
        return this.mDeviceBroker.getAndUpdateBtAdiDeviceStateCategoryForAddress(address);
    }

    public boolean isBluetoothAudioDeviceCategoryFixed(String address) {
        super.isBluetoothAudioDeviceCategoryFixed_enforcePermission();
        return this.mDeviceBroker.isBluetoothAudioDeviceCategoryFixed(address);
    }

    public void onUpdatedAdiDeviceState(AdiDeviceState deviceState, boolean initSA) {
        if (deviceState != null) goto L4;
        return;
    L4:
        this.mSpatializerHelper.refreshDevice(deviceState.getAudioDeviceAttributes(), initSA);
        SoundDoseHelper r0 = this.mSoundDoseHelper;
        String r1 = deviceState.getDeviceAddress();
        int r2 = deviceState.getInternalDeviceType();
        if (deviceState.getAudioDeviceCategory() != 3) goto L7;
        boolean r3 = true;
    L8:
        r0.setAudioDeviceCategory(r1, r2, r3);
        return;
    L7:
        r3 = false;
        goto L8
    }

    private void updateHdmiCecSinkLocked(boolean hdmiCecSink) {
        if (hasDeviceVolumeBehavior(1024) == false) goto L5;
        return;
    L5:
        if (hdmiCecSink == false) goto L7;
        Log.d(TAG, "CEC sink: setting HDMI as full vol device");
        setDeviceVolumeBehaviorInternal(new AudioDeviceAttributes(1024, ""), 1, "AudioService.updateHdmiCecSinkLocked()");
    L8:
        postUpdateVolumeStatesForAudioDevice(1024, "HdmiPlaybackClient.DisplayStatusCallback");
        return;
    L7:
        Log.d(TAG, "TV, no CEC: setting HDMI as regular vol device");
        setDeviceVolumeBehaviorInternal(new AudioDeviceAttributes(1024, ""), 0, "AudioService.updateHdmiCecSinkLocked()");
        goto L8
    }

    public int setHdmiSystemAudioSupported(boolean on) {
        int device = 0;
        Object r1 = this.mHdmiClientLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mHdmiManager != null) goto L7;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return device;
    L7:
        if (this.mHdmiTvClient != null) goto L16;
        if (this.mHdmiAudioSystemClient != null) goto L16;
        Log.w(TAG, "Only Hdmi-Cec enabled TV or audio system device supportssystem audio mode.");     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return 0;
    L16:
        if (this.mHdmiSystemAudioSupported == on) goto L22;
        this.mHdmiSystemAudioSupported = on;     // Catch: Throwable -> L13
        if (on == false) goto L20;
        int config = 12;
    L21:
        this.mDeviceBroker.setForceUse_Async(5, config, "setHdmiSystemAudioSupported");     // Catch: Throwable -> L13
        goto L22
    L20:
        config = 0;
    L22:
        device = getDeviceMaskForStream(3);     // Catch: Throwable -> L13
        goto L23
    }

    public boolean isHdmiSystemAudioSupported() {
        return this.mHdmiSystemAudioSupported;
    }

    private void initA11yMonitoring() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        updateDefaultStreamOverrideDelay(accessibilityManager.isTouchExplorationEnabled());
        updateA11yVolumeAlias(accessibilityManager.isAccessibilityVolumeStreamActive());
        accessibilityManager.addTouchExplorationStateChangeListener(this, null);
        accessibilityManager.addAccessibilityServicesStateChangeListener(this);
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean enabled) {
        updateDefaultStreamOverrideDelay(enabled);
    }

    private void updateDefaultStreamOverrideDelay(boolean touchExploreEnabled) {
        if (touchExploreEnabled == false) goto L4;
        sStreamOverrideDelayMs = 1000;
    L5:
        Log.d(TAG, "Touch exploration enabled=" + touchExploreEnabled + " stream override delay is now " + sStreamOverrideDelayMs + " ms");
        return;
    L4:
        sStreamOverrideDelayMs = 0;
        goto L5
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
    public void onAccessibilityServicesStateChanged(AccessibilityManager accessibilityManager) {
        updateA11yVolumeAlias(accessibilityManager.isAccessibilityVolumeStreamActive());
    }

    private void updateA11yVolumeAlias(boolean a11VolEnabled) {
        Log.d(TAG, "Accessibility volume enabled = " + a11VolEnabled);
        if (this.mIsSingleVolume == false) goto L7;
        Log.d(TAG, "Accessibility volume is not set on single volume device");
        return;
    L7:
        if (sIndependentA11yVolume == a11VolEnabled) goto L14;
        sIndependentA11yVolume = a11VolEnabled;
        int r0 = 1;
        updateStreamVolumeAlias(true, TAG);
        VolumeController r1 = this.mVolumeController;
        if (sIndependentA11yVolume == true) goto L12;
        r0 = 0;
    L12:
        r1.setA11yMode(r0);
        this.mVolumeController.postVolumeChanged(10, 0);
        return;
    }

    public boolean isCameraSoundForced() {
        return this.mCameraSoundForced.get();
    }

    private void dumpRingerMode(PrintWriter pw) {
        pw.println("\nRinger mode: ");
        pw.println("- mode (internal) = " + RINGER_MODE_NAMES[this.mRingerMode]);
        pw.println("- mode (external) = " + RINGER_MODE_NAMES[this.mRingerModeExternal]);
        pw.println("- zen mode:" + Settings.Global.zenModeToString(this.mNm.getZenMode()));
        dumpRingerModeStreams(pw, "affected", this.mRingerModeAffectedStreams);
        dumpRingerModeStreams(pw, "muted", sRingerAndZenModeMutedStreams);
        pw.print("- delegate = ");
        pw.println(this.mRingerModeDelegate);
    }

    private void dumpRingerModeStreams(PrintWriter pw, String type, int streams) {
        pw.print("- ringer mode ");
        pw.print(type);
        pw.print(" streams = 0x");
        pw.print(Integer.toHexString(streams));
        if (streams == 0) goto L19;
        pw.print(" (");
        boolean first = true;
        int i = 0;
    L6:
        if (i >= AudioSystem.STREAM_NAMES.length) goto L14;
        int stream = 1 << i;
        if ((streams & stream) == 0) goto L12;
        if (first == true) goto L11;
        pw.print(',');
    L11:
        pw.print(AudioSystem.STREAM_NAMES[i]);
        streams = streams & (~stream);
        first = false;
    L12:
        i = i + 1;
        goto L6
    L14:
        if (streams == 0) goto L18;
        if (first == true) goto L17;
        pw.print(',');
    L17:
        pw.print(streams);
    L18:
        pw.print(')');
    L19:
        pw.println();
    }

    private Set<Integer> getAbsoluteVolumeDevicesWithBehavior(final int behavior) {
        Object r0 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r0);
        Set<Integer> r1 = (Set) this.mAbsoluteVolumeDeviceInfoMap.entrySet().stream().filter(new AudioService$$ExternalSyntheticLambda11(behavior)).map(new UiModeManagerService$Stub$$ExternalSyntheticLambda3()).collect(Collectors.toSet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$getAbsoluteVolumeDevicesWithBehavior$26(int behavior, Map.Entry entry) {
        if (AbsoluteVolumeDeviceInfo.m2114$$Nest$fgetmDeviceVolumeBehavior((AbsoluteVolumeDeviceInfo) entry.getValue()) != behavior) goto L5;
        return true;
    L5:
        return false;
    }

    private String dumpDeviceTypes(Set<Integer> deviceTypes) {
        Iterator<Integer> it = deviceTypes.iterator();
        if (it.hasNext() == true) goto L6;
        return "";
    L6:
        StringBuilder sb = new StringBuilder();
        sb.append("0x" + Integer.toHexString(it.next().intValue()));
    L8:
        if (it.hasNext() == false) goto L11;
        sb.append(",0x" + Integer.toHexString(it.next().intValue()));
        goto L8
    L11:
        return sb.toString();
    }

    protected void dump(FileDescriptor fd, final PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        sLifecycleLogger.dump(pw);
        if (this.mAudioHandler == null) goto L8;
        pw.println("\nMessage handler (watch for unhandled messages):");
        this.mAudioHandler.dump(new PrintWriterPrinter(pw), "  ");
    L9:
        dumpFlags(pw);
        this.mHardeningLogger.dump(pw);
        this.mMediaFocusControl.dump(pw);
        dumpStreamStates(pw);
        dumpVolumeGroups(pw);
        dumpRingerMode(pw);
        dumpAudioMode(pw);
        pw.println("\nAudio routes:");
        pw.print("  mMainType=0x");
        pw.println(Integer.toHexString(this.mDeviceBroker.getCurAudioRoutes().mainType));
        pw.print("  mBluetoothName=");
        pw.println(this.mDeviceBroker.getCurAudioRoutes().bluetoothName);
        pw.println("\nOther state:");
        pw.print("  mUseVolumeGroupAliases=");
        pw.println(this.mUseVolumeGroupAliases);
        pw.print("  mVolumeController=");
        pw.println(this.mVolumeController);
        this.mSoundDoseHelper.dump(pw);
        pw.print("  sIndependentA11yVolume=");
        pw.println(sIndependentA11yVolume);
        pw.print("  mCameraSoundForced=");
        pw.println(isCameraSoundForced());
        pw.print("  mHasVibrator=");
        pw.println(this.mHasVibrator);
        pw.print("  mVolumePolicy=");
        pw.println(this.mVolumePolicy);
        pw.print("  mAvrcpAbsVolSupported=");
        pw.println(this.mAvrcpAbsVolSupported);
        pw.print("  mBtScoOnByApp=");
        pw.println(this.mBtScoOnByApp);
        pw.print("  mIsSingleVolume=");
        pw.println(this.mIsSingleVolume);
        pw.print("  mUseFixedVolume=");
        pw.println(this.mUseFixedVolume);
        pw.print("  mNotifAliasRing=");
        pw.println(this.mNotifAliasRing);
        pw.print("  mFixedVolumeDevices=");
        pw.println(dumpDeviceTypes(this.mFixedVolumeDevices));
        pw.print("  mFullVolumeDevices=");
        pw.println(dumpDeviceTypes(this.mFullVolumeDevices));
        pw.print("  absolute volume devices=");
        pw.println(dumpDeviceTypes(getAbsoluteVolumeDevicesWithBehavior(3)));
        pw.print("  adjust-only absolute volume devices=");
        pw.println(dumpDeviceTypes(getAbsoluteVolumeDevicesWithBehavior(5)));
        pw.print("  pre-scale for bluetooth absolute volume ");
        pw.println("= disabled");
        pw.print("  mExtVolumeController=");
        pw.println(this.mExtVolumeController);
        pw.print("  mHdmiAudioSystemClient=");
        pw.println(this.mHdmiAudioSystemClient);
        pw.print("  mHdmiPlaybackClient=");
        pw.println(this.mHdmiPlaybackClient);
        pw.print("  mHdmiTvClient=");
        pw.println(this.mHdmiTvClient);
        pw.print("  mHdmiSystemAudioSupported=");
        pw.println(this.mHdmiSystemAudioSupported);
        Object r0 = this.mHdmiClientLock;
        monitor-enter(r0);
        pw.print("  mHdmiCecVolumeControlEnabled=");     // Catch: Throwable -> L22
        pw.println(this.mHdmiCecVolumeControlEnabled);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        pw.print("  mIsCallScreeningModeSupported=");
        pw.println(this.mIsCallScreeningModeSupported);
        pw.println("  mic mute FromSwitch=" + this.mMicMuteFromSwitch + " FromRestrictions=" + this.mMicMuteFromRestrictions + " FromApi=" + this.mMicMuteFromApi + " from system=" + this.mMicMuteFromSystemCached);
        pw.print("  mMonitorRotation=");
        pw.println(this.mMonitorRotation);
        pw.print("  mMasterMute=");
        pw.println(this.mMasterMute.get());
        dumpAccessibilityServiceUids(pw);
        dumpAssistantServicesUids(pw);
        pw.print("  supportsBluetoothVariableLatency=");
        pw.println(AudioSystem.supportsBluetoothVariableLatency());
        pw.print("  isBluetoothVariableLatencyEnabled=");
        pw.println(AudioSystem.isBluetoothVariableLatencyEnabled());
        dumpAudioPolicies(pw);
        this.mDynPolicyLogger.dump(pw);
        this.mPlaybackMonitor.dump(pw);
        this.mRecordMonitor.dump(pw);
        pw.println("\nAudioDeviceBroker:");
        this.mDeviceBroker.dump(pw, "  ");
        pw.println("\nSoundEffects:");
        this.mSfxHelper.dump(pw, "  ");
        pw.println("\n");
        pw.println("\nEvent logs:");
        this.mModeLogger.dump(pw);
        pw.println("\n");
        sDeviceLogger.dump(pw);
        pw.println("\n");
        sForceUseLogger.dump(pw);
        pw.println("\n");
        sVolumeLogger.dump(pw);
        pw.println("\n");
        sMuteLogger.dump(pw);
        pw.println("\n");
        dumpSupportedSystemUsage(pw);
        pw.println("\n");
        pw.println("\nSpatial audio:");
        pw.println("mHasSpatializerEffect:" + this.mHasSpatializerEffect + " (effect present)");
        pw.println("isSpatializerEnabled:" + isSpatializerEnabled() + " (routing dependent)");
        this.mSpatializerHelper.dump(pw);
        sSpatialLogger.dump(pw);
        pw.println("\n");
        pw.println("\nLoudness alignment:");
        this.mLoudnessCodecHelper.dump(pw);
        pw.println("\nAbsolute volume devices with their volume driving streams:");
        Object r1 = this.mCachedAbsVolDrivingStreamsLock;
        monitor-enter(r1);
        this.mCachedAbsVolDrivingStreams.forEach(new AudioService$$ExternalSyntheticLambda23(pw));     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        this.mAudioSystem.dump(pw);
        this.mZAudioService.dump(pw);
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    L8:
        pw.println("\nMessage handler is null");
        goto L9
    }

    private static /* synthetic */ void lambda$dump$27(PrintWriter pw, Integer dev, Integer stream) {
        pw.println("Device type: 0x" + Integer.toHexString(dev.intValue()) + ", driving stream " + stream);
    }

    private void dumpSupportedSystemUsage(PrintWriter pw) {
        pw.println("Supported System Usages:");
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSupportedSystemUsages.length) goto L11;
        pw.printf("\t%s\n", new Object[]{AudioAttributes.usageToString(this.mSupportedSystemUsages[i])});     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void dumpAssistantServicesUids(PrintWriter pw) {
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAssistantUids.size() <= 0) goto L13;
        pw.println("  Assistant service UIDs:");     // Catch: Throwable -> L10
        Iterator<Integer> r1 = this.mAssistantUids.iterator();     // Catch: Throwable -> L10
    L8:
        if (r1.hasNext() == false) goto L14;
        int uid = r1.next().intValue();     // Catch: Throwable -> L10
        pw.println("  - " + uid);     // Catch: Throwable -> L10
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        pw.println("  No Assistant service Uids.");     // Catch: Throwable -> L10
        goto L14
    }

    private void dumpAccessibilityServiceUids(PrintWriter pw) {
        Object r0 = this.mSupportedSystemUsagesLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mAccessibilityServiceUids != null) goto L7;
    L13:
        pw.println("  No accessibility service Uids.");     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mAccessibilityServiceUids.length <= 0) goto L13;
        pw.println("  Accessibility service Uids:");     // Catch: Throwable -> L11
        int[] r1 = this.mAccessibilityServiceUids;     // Catch: Throwable -> L11
        int r2 = r1.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L14;
        int uid = r1[r3];     // Catch: Throwable -> L11
        pw.println("  - " + uid);     // Catch: Throwable -> L11
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L9
    }

    private static AudioServerPermissionProvider initializeAudioServerPermissionProvider(Context context, final AudioPolicyFacade audioPolicy, Executor audioserverExecutor) {
        PackageManagerLocal.UnfilteredSnapshot snapshot = ((PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class)).withUnfilteredSnapshot();
        Collection<PackageState> packageStates = snapshot.getPackageStates().values();     // Catch: Throwable -> L6
        snapshot.close();
        final UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        PermissionManagerServiceInternal r1 = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        final AudioServerPermissionProvider provider = new AudioServerPermissionProvider(packageStates, new AudioService$$ExternalSyntheticLambda19(), new AudioService$$ExternalSyntheticLambda20(umi));
        audioPolicy.registerOnStartTask(new AudioService$$ExternalSyntheticLambda21(provider, audioPolicy));
        IntentFilter packageUpdateFilter = new IntentFilter();
        packageUpdateFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageUpdateFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        context.registerReceiverForAllUsers(new AnonymousClass8(audioserverExecutor, provider), packageUpdateFilter, null, null);
        return provider;
    L6:
        th = move-exception;
        if (snapshot != null) goto L13;
    L12:
        throw th;
    L13:
        snapshot.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    private static /* synthetic */ boolean lambda$initializeAudioServerPermissionProvider$28(Integer uid, String perm) {
        if (ActivityManager.checkComponentPermission(perm, uid.intValue(), -1, true) == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ int[] lambda$initializeAudioServerPermissionProvider$29(UserManagerInternal umi) {
        return umi.getUserIds();
    }

    private static /* synthetic */ void lambda$initializeAudioServerPermissionProvider$30(AudioServerPermissionProvider provider, AudioPolicyFacade audioPolicy) {
        provider.onServiceStart(audioPolicy.getPermissionController());
        sLifecycleLogger.enqueue(new EventLogger.StringEvent("Controller start task complete").printLog(0, TAG));
    }

    private static void readAndSetLowRamDevice() {
        boolean isLowRamDevice = ActivityManager.isLowRamDeviceStatic();
        long totalMemory = 1073741824;
        ActivityManager.MemoryInfo info = new ActivityManager.MemoryInfo();     // Catch: RemoteException -> L5
        ActivityManager.getService().getMemoryInfo(info);     // Catch: RemoteException -> L5
        totalMemory = info.totalMem;     // Catch: RemoteException -> L5
    L7:
        int status = AudioSystem.setLowRamDevice(isLowRamDevice, totalMemory);
        if (status == 0) goto L13;
        Log.w(TAG, "AudioFlinger informed of device's low RAM attribute; status " + status);
        return;
    L13:
        return;
    L6:
        Log.w(TAG, "Cannot obtain MemoryInfo from ActivityManager, assume low memory device");
        isLowRamDevice = true;
        goto L7
    }

    private void enforceVolumeController(String action) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.STATUS_BAR_SERVICE", "Only SystemUI can " + action);
    }

    public void setVolumeController(final IVolumeController controller) {
        enforceVolumeController("set the volume controller");
        if (this.mVolumeController.isSameBinder(controller) == false) goto L5;
        return;
    L5:
        this.mVolumeController.postDismiss();
        if (controller != null) goto L12;
    L10:
        this.mVolumeController.setController(controller);
        Log.d(TAG, "Volume controller: " + this.mVolumeController);
        return;
    L12:
        controller.asBinder().linkToDeath(new AnonymousClass9(this, controller), 0);     // Catch: RemoteException -> L9
        goto L10
    }

    public IVolumeController getVolumeController() {
        enforceVolumeController("get the volume controller");
        Log.d(TAG, "Volume controller: " + this.mVolumeController);
        return this.mVolumeController.getController();
    }

    public void notifyVolumeControllerVisible(IVolumeController controller, boolean visible) {
        enforceVolumeController("notify about volume controller visibility");
        if (this.mVolumeController.isSameBinder(controller) == true) goto L5;
        return;
    L5:
        this.mVolumeController.setVisible(visible);
        Log.d(TAG, "Volume controller visible: " + visible);
    }

    public void setVolumeControllerLongPressTimeoutEnabled(boolean enable) {
        super.setVolumeControllerLongPressTimeoutEnabled_enforcePermission();
        this.mVolumeControllerLongPressEnabled.set(enable);
        Log.i(TAG, "Volume controller long press timeout enabled: " + enable);
    }

    public void setVolumePolicy(VolumePolicy policy) {
        enforceVolumeController("set volume policy");
        if (policy != null) goto L5;
        return;
    L5:
        if (policy.equals(this.mVolumePolicy) == true) goto L9;
        this.mVolumePolicy = policy;
        Log.d(TAG, "Volume policy changed: " + this.mVolumePolicy);
        return;
    }

    public VolumePolicy getVolumePolicy() {
        return this.mVolumePolicy;
    }

    private void onUpdateAccessibilityServiceUids() {
        Object r0 = this.mAccessibilityServiceUidsLock;
        monitor-enter(r0);
        int[] accessibilityServiceUids = this.mAccessibilityServiceUids;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        AudioSystem.setA11yServicesUids(accessibilityServiceUids);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public String registerAudioPolicy(AudioPolicyConfig policyConfig, IAudioPolicyCallback pcb, boolean hasFocusListener, boolean isFocusPolicy, boolean isTestFocusPolicy, boolean isVolumeController, IMediaProjection projection, AttributionSource attributionSource) {
        attributionSource.getClass();
        AudioSystem.setDynamicPolicyCallback(this.mDynPolicyCallback);
        if (isFocusPolicy == true) goto L8;
        if (isTestFocusPolicy == true) goto L8;
        if (hasFocusListener == true) goto L8;
        boolean r0 = false;
    L10:
        if (isPolicyRegisterAllowed(policyConfig, r0, isVolumeController, projection) == true) goto L13;
        Slog.w(TAG, "Permission denied to register audio policy for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", need system permission or a MediaProjection that can project audio");
        return null;
    L13:
        HashMap<IBinder, AudioPolicyProxy> r13 = this.mAudioPolicies;
        monitor-enter(r13);
    L20:
        e = th;
    L43:
        monitor-exit(r13);     // Catch: Throwable -> L27
        throw e;
    L16:
        if (this.mAudioPolicies.containsKey(pcb.asBinder()) == false) goto L47;
        Slog.e(TAG, "Cannot re-register policy");     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return null;
    L47:
        IAudioPolicyCallback r3 = pcb;
        AudioPolicyProxy app = new AudioPolicyProxy(this, policyConfig, r3, hasFocusListener, isFocusPolicy, isTestFocusPolicy, isVolumeController, projection, attributionSource);     // Catch: Throwable -> L27 IllegalStateException -> L29 RemoteException -> L31
        r3.asBinder().linkToDeath(app, 0);     // Catch: Throwable -> L27 IllegalStateException -> L29 RemoteException -> L31
        this.mDynPolicyLogger.enqueue(new EventLogger.StringEvent("registerAudioPolicy for " + r3.asBinder() + " u/pid:" + Binder.getCallingUid() + SliceClientPermissions.SliceAuthority.DELIMITER + Binder.getCallingPid() + " with config:" + app.toCompactLogString()).printLog(TAG));     // Catch: Throwable -> L27 IllegalStateException -> L29 RemoteException -> L31
        String regId = app.getRegistrationId();     // Catch: Throwable -> L27 IllegalStateException -> L29 RemoteException -> L31
        this.mAudioPolicies.put(r3.asBinder(), app);     // Catch: Throwable -> L27 IllegalStateException -> L29 RemoteException -> L31
        monitor-exit(r13);     // Catch: Throwable -> L27
        return regId;
    L31:
        e = e;
    L40:
        Slog.w(TAG, "Audio policy registration failed, could not link to " + r3 + " binder death", e);     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        return null;
    L29:
        e = e;
    L35:
        Slog.w(TAG, "Audio policy registration failed for binder " + r3, e);     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Throwable -> L27
        return null;
    L38:
        e = e;
        r3 = pcb;
    L33:
        e = e;
        r3 = pcb;
    L27:
        e = th;
    L8:
        r0 = true;
        goto L10
    }

    private void onPolicyClientDeath(List<String> addresses) {
        Iterator<String> r0 = addresses.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String address = r0.next();
        if (this.mPlaybackMonitor.hasActiveMediaPlaybackOnSubmixWithAddress(address) == false) goto L4;
        this.mDeviceBroker.postBroadcastBecomingNoisy();
        return;
    }

    private boolean isPolicyRegisterAllowed(AudioPolicyConfig policyConfig, boolean hasFocusAccess, boolean isVolumeController, IMediaProjection projection) {
        boolean requireValidProjection = false;
        boolean requireCaptureAudioOrMediaOutputPerm = false;
        boolean requireModifyRouting = false;
        boolean requireCallAudioInterception = false;
        ArrayList<AudioMix> voiceCommunicationCaptureMixes = null;
        if (hasFocusAccess == true) goto L9;
        if (isVolumeController == true) goto L9;
        if (policyConfig.getMixes().isEmpty() == false) goto L10;
        requireModifyRouting = false | true;
    L10:
        Iterator r5 = policyConfig.getMixes().iterator();
    L12:
        if (r5.hasNext() == false) goto L39;
        AudioMix mix = (AudioMix) r5.next();
        if (mix.getRule().allowPrivilegedMediaPlaybackCapture() == false) goto L21;
        String privilegedMediaCaptureError = AudioMix.canBeUsedForPrivilegedMediaCapture(mix.getFormat());
        if (privilegedMediaCaptureError != null) goto L17;
        requireCaptureAudioOrMediaOutputPerm = requireCaptureAudioOrMediaOutputPerm | true;
        goto L21
    L17:
        Log.e(TAG, privilegedMediaCaptureError);
        return false;
    L21:
        if (mix.containsMatchAttributeRuleForUsage(2) == false) goto L28;
        if (mix.getRouteFlags() != 3) goto L28;
        if (voiceCommunicationCaptureMixes != null) goto L26;
        voiceCommunicationCaptureMixes = new ArrayList();
    L26:
        voiceCommunicationCaptureMixes.add(mix);
    L28:
        if (mix.getRouteFlags() != 3) goto L32;
        if (projection == null) goto L32;
        requireValidProjection = requireValidProjection | true;
    L32:
        if (mix.isForCallRedirection() == true) goto L33;
        if (mix.containsMatchAttributeRuleForUsage(2) == false) goto L12;
        requireModifyRouting = requireModifyRouting | true;
        goto L12
    L33:
        requireCallAudioInterception = requireCallAudioInterception | true;
        goto L12
    L39:
        if (requireCaptureAudioOrMediaOutputPerm == false) goto L47;
        if (callerHasPermission("android.permission.CAPTURE_MEDIA_OUTPUT") == true) goto L47;
        if (callerHasPermission("android.permission.CAPTURE_AUDIO_OUTPUT") == true) goto L47;
        Log.e(TAG, "Privileged audio capture requires CAPTURE_MEDIA_OUTPUT or CAPTURE_AUDIO_OUTPUT system permission");
        return false;
    L47:
        if (voiceCommunicationCaptureMixes != null) goto L49;
    L58:
        if (requireValidProjection == true) goto L60;
    L63:
        if (requireModifyRouting == true) goto L65;
    L68:
        if (requireCallAudioInterception == true) goto L70;
    L73:
        return true;
    L70:
        if (callerHasPermission("android.permission.CALL_AUDIO_INTERCEPTION") == true) goto L73;
        Log.e(TAG, "Can not capture audio without CALL_AUDIO_INTERCEPTION");
        return false;
    L65:
        if (callerHasPermission("android.permission.MODIFY_AUDIO_ROUTING") == true) goto L68;
        Log.e(TAG, "Can not capture audio without MODIFY_AUDIO_ROUTING");
        return false;
    L60:
        if (canProjectAudio(projection) == true) goto L63;
        return false;
    L49:
        if (voiceCommunicationCaptureMixes.size() <= 0) goto L58;
        if (callerHasPermission("android.permission.CAPTURE_VOICE_COMMUNICATION_OUTPUT") == true) goto L54;
        Log.e(TAG, "Audio capture for voice communication requires CAPTURE_VOICE_COMMUNICATION_OUTPUT system permission");
        return false;
    L54:
        Iterator<AudioMix> r6 = voiceCommunicationCaptureMixes.iterator();
    L56:
        if (r6.hasNext() == false) goto L58;
        r6.next().getRule().setVoiceCommunicationCaptureAllowed(true);
    L9:
        requireModifyRouting = false | true;
        goto L10
    }

    private boolean callerHasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canProjectAudio(IMediaProjection projection) {
        if (projection != null) goto L6;
        Log.e(TAG, "MediaProjection is null");
        return false;
    L6:
        IMediaProjectionManager projectionService = getProjectionService();
        if (projectionService != null) goto L10;
        Log.e(TAG, "Can't get service IMediaProjectionManager");
        return false;
    L10:
        long token = Binder.clearCallingIdentity();
    L18:
        e = move-exception;
        Log.e(TAG, "Can't call .isCurrentProjection() on IMediaProjectionManager" + projectionService.asBinder(), e);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(token);
        return false;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L12:
        if (projectionService.isCurrentProjection(projection) == true) goto L20;
        Log.w(TAG, "App passed invalid MediaProjection token");     // Catch: Throwable -> L16 RemoteException -> L18
        Binder.restoreCallingIdentity(token);
        return false;
    L20:
        Binder.restoreCallingIdentity(token);
    L25:
        e = move-exception;
        Log.e(TAG, "Can't call .canProjectAudio() on valid IMediaProjection" + projection.asBinder(), e);
        return false;
    L22:
        if (projection.canProjectAudio() == true) goto L27;
        Log.w(TAG, "App passed MediaProjection that can not project audio");     // Catch: RemoteException -> L25
        return false;
    L27:
        return true;
    }

    private IMediaProjectionManager getProjectionService() {
        if (this.mProjectionService != null) goto L6;
        IBinder b = ServiceManager.getService("media_projection");
        this.mProjectionService = IMediaProjectionManager.Stub.asInterface(b);
    L6:
        return this.mProjectionService;
    }

    public void unregisterAudioPolicyAsync(IAudioPolicyCallback pcb) {
        if (pcb != null) goto L4;
        return;
    L4:
        unregisterAudioPolicyInt(pcb, "unregisterAudioPolicyAsync");
    }

    public void unregisterAudioPolicy(IAudioPolicyCallback pcb) {
        if (pcb != null) goto L4;
        return;
    L4:
        unregisterAudioPolicyInt(pcb, "unregisterAudioPolicy");
    }

    private void unregisterAudioPolicyInt(IAudioPolicyCallback pcb, String operationName) {
        this.mDynPolicyLogger.enqueue(new EventLogger.StringEvent(operationName + " for " + pcb.asBinder()).printLog(TAG));
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = this.mAudioPolicies.remove(pcb.asBinder());     // Catch: Throwable -> L9
        if (app != null) goto L11;
        Slog.w(TAG, "Trying to unregister unknown audio policy for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        pcb.asBinder().unlinkToDeath(app, 0);     // Catch: Throwable -> L9
        app.release();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private AudioPolicyProxy checkUpdateForPolicy(IAudioPolicyCallback pcb, String errorMsg) {
        if (this.mContext.checkCallingPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
        boolean hasPermissionForPolicy = true;
    L7:
        if (hasPermissionForPolicy == true) goto L10;
        Slog.w(TAG, errorMsg + " for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", need MODIFY_AUDIO_ROUTING");
        return null;
    L10:
        AudioPolicyProxy app = this.mAudioPolicies.get(pcb.asBinder());
        if (app != null) goto L14;
        Slog.w(TAG, errorMsg + " for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid() + ", unregistered policy");
        return null;
    L14:
        return app;
    L5:
        hasPermissionForPolicy = false;
        goto L7
    }

    public List<AudioMix> getRegisteredPolicyMixes() {
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        List<AudioMix> r1 = this.mAudioSystem.getRegisteredPolicyMixes();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int addMixForPolicy(AudioPolicyConfig policyConfig, IAudioPolicyCallback pcb) {
        Log.d(TAG, "addMixForPolicy for " + pcb.asBinder() + " with config:" + policyConfig);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot add AudioMix in audio policy");     // Catch: Throwable -> L8
        int r2 = -1;
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L11:
        if (app.addMixes(policyConfig.getMixes()) != 0) goto L14;
        r2 = 0;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public int removeMixForPolicy(AudioPolicyConfig policyConfig, IAudioPolicyCallback pcb) {
        Log.d(TAG, "removeMixForPolicy for " + pcb.asBinder() + " with config:" + policyConfig);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot add AudioMix in audio policy");     // Catch: Throwable -> L8
        int r2 = -1;
        if (app != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L10:
        Iterator r3 = policyConfig.getMixes().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L20;
        AudioMix mix = (AudioMix) r3.next();     // Catch: Throwable -> L8
        if (app.getMixes().contains(mix) == true) goto L12;
        Slog.e(TAG, "removeMixForPolicy attempted to unregister AudioMix(es) not belonging to the AudioPolicy");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L20:
        if (app.removeMixes(policyConfig.getMixes()) != 0) goto L23;
        r2 = 0;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public int updateMixingRulesForPolicy(AudioMix[] mixesToUpdate, AudioMixingRule[] updatedMixingRules, IAudioPolicyCallback pcb) {
        super.updateMixingRulesForPolicy_enforcePermission();
        mixesToUpdate.getClass();
        updatedMixingRules.getClass();
        pcb.getClass();
        int r2 = -1;
        if (mixesToUpdate.length == updatedMixingRules.length) goto L6;
        Log.e(TAG, "Provided list of audio mixes to update and corresponding mixing rules have mismatching length (mixesToUpdate.length = " + mixesToUpdate.length + ", updatedMixingRules.length = " + updatedMixingRules.length + ").");
        return -1;
    L6:
        Log.d(TAG, "updateMixingRules for " + pcb.asBinder() + "with mix rules: ");
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot add AudioMix in audio policy");     // Catch: Throwable -> L12
        if (app != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return -1;
    L15:
        if (app.updateMixingRules(mixesToUpdate, updatedMixingRules) != 0) goto L18;
        r2 = 0;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    public int setUidDeviceAffinity(IAudioPolicyCallback pcb, int uid, int[] deviceTypes, String[] deviceAddresses) {
        Log.d(TAG, "setUidDeviceAffinity for " + pcb.asBinder() + " uid:" + uid);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot change device affinity in audio policy");     // Catch: Throwable -> L8
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L11:
        if (app.hasMixRoutedToDevices(deviceTypes, deviceAddresses) == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L14:
        int r2 = app.setUidDeviceAffinities(uid, deviceTypes, deviceAddresses);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public int setUserIdDeviceAffinity(IAudioPolicyCallback pcb, int userId, int[] deviceTypes, String[] deviceAddresses) {
        Log.d(TAG, "setUserIdDeviceAffinity for " + pcb.asBinder() + " user:" + userId);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot change device affinity in audio policy");     // Catch: Throwable -> L8
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L11:
        if (app.hasMixRoutedToDevices(deviceTypes, deviceAddresses) == true) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L14:
        int r2 = app.setUserIdDeviceAffinities(userId, deviceTypes, deviceAddresses);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public int removeUidDeviceAffinity(IAudioPolicyCallback pcb, int uid) {
        Log.d(TAG, "removeUidDeviceAffinity for " + pcb.asBinder() + " uid:" + uid);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot remove device affinity in audio policy");     // Catch: Throwable -> L9
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L11:
        int r2 = app.removeUidDeviceAffinities(uid);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public int removeUserIdDeviceAffinity(IAudioPolicyCallback pcb, int userId) {
        Log.d(TAG, "removeUserIdDeviceAffinity for " + pcb.asBinder() + " userId:" + userId);
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot remove device affinity in audio policy");     // Catch: Throwable -> L9
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return -1;
    L11:
        int r2 = app.removeUserIdDeviceAffinities(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public int setFocusPropertiesForPolicy(int duckingBehavior, IAudioPolicyCallback pcb) {
        Log.d(TAG, "setFocusPropertiesForPolicy() duck behavior=" + duckingBehavior + " policy " + pcb.asBinder());
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        AudioPolicyProxy app = checkUpdateForPolicy(pcb, "Cannot change audio policy focus properties");     // Catch: Throwable -> L8
        if (app != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L11:
        if (this.mAudioPolicies.containsKey(pcb.asBinder()) == true) goto L15;
        Slog.e(TAG, "Cannot change audio policy focus properties, unregistered policy");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L15:
        boolean r3 = true;
        if (duckingBehavior != 1) goto L26;
        Iterator<AudioPolicyProxy> r4 = this.mAudioPolicies.values().iterator();     // Catch: Throwable -> L8
    L19:
        if (r4.hasNext() == false) goto L26;
        AudioPolicyProxy policy = r4.next();     // Catch: Throwable -> L8
        if (policy.mFocusDuckBehavior != 1) goto L19;
        Slog.e(TAG, "Cannot change audio policy ducking behavior, already handled");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L26:
        app.mFocusDuckBehavior = duckingBehavior;     // Catch: Throwable -> L8
        MediaFocusControl r2 = this.mMediaFocusControl;     // Catch: Throwable -> L8
        if (duckingBehavior == 1) goto L30;
        r3 = false;
    L30:
        r2.setDuckingInExtPolicyAvailable(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    public List<AudioFocusInfo> getFocusStack() {
        super.getFocusStack_enforcePermission();
        return this.mMediaFocusControl.getFocusStack();
    }

    public void sendFocusLossAndUpdate(AudioFocusInfo focusLoser, IAudioPolicyCallback apcb) {
        super.sendFocusLossAndUpdate_enforcePermission();
        apcb.getClass();
        if (this.mAudioPolicies.containsKey(apcb.asBinder()) == false) goto L11;
        if (this.mAudioPolicies.get(apcb.asBinder()).mHasFocusListener == false) goto L9;
        MediaFocusControl r0 = this.mMediaFocusControl;
        focusLoser.getClass();
        r0.sendFocusLossAndUpdate(focusLoser);
        return;
    L9:
        throw new IllegalStateException("AudioPolicy must have focus listener to change focus");
    L11:
        throw new IllegalStateException("Only registered AudioPolicy can change focus");
    }

    public boolean sendFocusLoss(AudioFocusInfo focusLoser, IAudioPolicyCallback apcb) {
        super.sendFocusLoss_enforcePermission();
        focusLoser.getClass();
        apcb.getClass();
        if (this.mAudioPolicies.containsKey(apcb.asBinder()) == false) goto L11;
        if (this.mAudioPolicies.get(apcb.asBinder()).mHasFocusListener == false) goto L9;
        return this.mMediaFocusControl.sendFocusLoss(focusLoser);
    L9:
        throw new IllegalStateException("AudioPolicy must have focus listener to change focus");
    L11:
        throw new IllegalStateException("Only registered AudioPolicy can change focus");
    }

    public int setFadeManagerConfigurationForFocusLoss(FadeManagerConfiguration fmcForFocusLoss) {
        super.setFadeManagerConfigurationForFocusLoss_enforcePermission();
        ensureFadeManagerConfigIsEnabled();
        fmcForFocusLoss.getClass();
        validateFadeManagerConfiguration(fmcForFocusLoss);
        return this.mPlaybackMonitor.setFadeManagerConfiguration(-1, fmcForFocusLoss);
    }

    public int clearFadeManagerConfigurationForFocusLoss() {
        super.clearFadeManagerConfigurationForFocusLoss_enforcePermission();
        ensureFadeManagerConfigIsEnabled();
        return this.mPlaybackMonitor.clearFadeManagerConfiguration(-1);
    }

    public FadeManagerConfiguration getFadeManagerConfigurationForFocusLoss() {
        super.getFadeManagerConfigurationForFocusLoss_enforcePermission();
        ensureFadeManagerConfigIsEnabled();
        return this.mPlaybackMonitor.getFadeManagerConfiguration(-1);
    }

    public AudioHalVersionInfo getHalVersion() {
        Iterator r1 = AudioHalVersionInfo.VERSIONS.iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        AudioHalVersionInfo version = (AudioHalVersionInfo) r1.next();
        String versionStr = version.getMajorVersion() + "." + version.getMinorVersion();     // Catch: RemoteException -> L11 NoSuchElementException -> L13
        String hidlStr = String.format("android.hardware.audio@%s::IDevicesFactory", new Object[]{versionStr});     // Catch: RemoteException -> L11 NoSuchElementException -> L13
        if (ServiceManager.checkService("android.hardware.audio.core.IModule/default") != null) goto L8;
        HwBinder.getService(hidlStr, "default");     // Catch: RemoteException -> L11 NoSuchElementException -> L13
        goto L4
    L10:
        return version;
    L8:
        return version;
    L11:
        re = move-exception;
        Log.e(TAG, "Remote exception when getting hardware audio service:", re);
        goto L4
    L18:
        return null;
    }

    public boolean hasRegisteredDynamicPolicy() {
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioPolicies.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public int setPreferredMixerAttributes(AudioAttributes attributes, int portId, AudioMixerAttributes mixerAttributes) {
        attributes.getClass();
        mixerAttributes.getClass();
        if (checkAudioSettingsPermission("setPreferredMixerAttributes()") == true) goto L6;
        return -4;
    L6:
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        long token = Binder.clearCallingIdentity();
        String logString = TextUtils.formatSimple("setPreferredMixerAttributes u/pid:%d/%d attr:%s mixerAttributes:%s portId:%d", new Object[]{Integer.valueOf(uid), Integer.valueOf(pid), attributes.toString(), mixerAttributes.toString(), Integer.valueOf(portId)});     // Catch: Throwable -> L10
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));     // Catch: Throwable -> L10
        int status = this.mAudioSystem.setPreferredMixerAttributes(attributes, portId, uid, mixerAttributes);     // Catch: Throwable -> L10
        if (status != 0) goto L12;
        dispatchPreferredMixerAttributesChanged(attributes, portId, mixerAttributes);     // Catch: Throwable -> L10
    L13:
        Binder.restoreCallingIdentity(token);
        return status;
    L12:
        Log.e(TAG, TextUtils.formatSimple("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public int clearPreferredMixerAttributes(AudioAttributes attributes, int portId) {
        attributes.getClass();
        if (checkAudioSettingsPermission("clearPreferredMixerAttributes()") == true) goto L6;
        return -4;
    L6:
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        long token = Binder.clearCallingIdentity();
        String logString = TextUtils.formatSimple("clearPreferredMixerAttributes u/pid:%d/%d attr:%s", new Object[]{Integer.valueOf(uid), Integer.valueOf(pid), attributes.toString()});     // Catch: Throwable -> L10
        sDeviceLogger.enqueue(new EventLogger.StringEvent(logString).printLog(TAG));     // Catch: Throwable -> L10
        int status = this.mAudioSystem.clearPreferredMixerAttributes(attributes, portId, uid);     // Catch: Throwable -> L10
        if (status != 0) goto L12;
        dispatchPreferredMixerAttributesChanged(attributes, portId, null);     // Catch: Throwable -> L10
    L13:
        Binder.restoreCallingIdentity(token);
        return status;
    L12:
        Log.e(TAG, TextUtils.formatSimple("Error %d in %s)", new Object[]{Integer.valueOf(status), logString}));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    void dispatchPreferredMixerAttributesChanged(AudioAttributes attr, int deviceId, AudioMixerAttributes mixerAttr) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_AUDIO_ATTRIBUTES, attr);
        bundle.putParcelable(KEY_AUDIO_MIXER_ATTRIBUTES, mixerAttr);
        sendBundleMsg(this.mAudioHandler, 52, 2, deviceId, 0, null, bundle, 0);
    }

    public void registerPreferredMixerAttributesDispatcher(IPreferredMixerAttributesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        this.mPrefMixerAttrDispatcher.register(dispatcher);
    }

    public void unregisterPreferredMixerAttributesDispatcher(IPreferredMixerAttributesDispatcher dispatcher) {
        if (dispatcher != null) goto L4;
        return;
    L4:
        this.mPrefMixerAttrDispatcher.unregister(dispatcher);
    }

    protected void onDispatchPreferredMixerAttributesChanged(Bundle data, int deviceId) {
        int nbDispathers = this.mPrefMixerAttrDispatcher.beginBroadcast();
        AudioAttributes attr = (AudioAttributes) data.getParcelable(KEY_AUDIO_ATTRIBUTES, AudioAttributes.class);
        AudioMixerAttributes mixerAttr = (AudioMixerAttributes) data.getParcelable(KEY_AUDIO_MIXER_ATTRIBUTES, AudioMixerAttributes.class);
        int i = 0;
    L3:
        if (i >= nbDispathers) goto L9;
        this.mPrefMixerAttrDispatcher.getBroadcastItem(i).dispatchPrefMixerAttributesChanged(attr, deviceId, mixerAttr);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Can't call dispatchPrefMixerAttributesChanged() IPreferredMixerAttributesDispatcher " + this.mPrefMixerAttrDispatcher.getBroadcastItem(i).asBinder(), e);
        goto L8
    L9:
        this.mPrefMixerAttrDispatcher.finishBroadcast();
    }

    public boolean supportsBluetoothVariableLatency() {
        super.supportsBluetoothVariableLatency_enforcePermission();
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        boolean r1 = AudioSystem.supportsBluetoothVariableLatency();     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L16;
    L13:
        throw th;
    L16:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public void setBluetoothVariableLatencyEnabled(boolean enabled) {
        super.setBluetoothVariableLatencyEnabled_enforcePermission();
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        AudioSystem.setBluetoothVariableLatencyEnabled(enabled);     // Catch: Throwable -> L7
        if (ignored == null) goto L18;
        ignored.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (ignored != null) goto L16;
    L13:
        throw th;
    L16:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public boolean isBluetoothVariableLatencyEnabled() {
        super.isBluetoothVariableLatencyEnabled_enforcePermission();
        SafeCloseable ignored = ClearCallingIdentityContext.create();
        boolean r1 = AudioSystem.isBluetoothVariableLatencyEnabled();     // Catch: Throwable -> L7
        if (ignored == null) goto L6;
        ignored.close();
    L6:
        return r1;
    L7:
        th = move-exception;
        if (ignored != null) goto L16;
    L13:
        throw th;
    L16:
        ignored.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    private void setExtVolumeController(IAudioPolicyCallback apc) {
        if (this.mContext.getResources().getBoolean(R.bool.config_hotspotNetworksEnabledForService) == true) goto L6;
        Log.e(TAG, "Cannot set external volume controller: device not set for volume keys handled in PhoneWindowManager");
        return;
    L6:
        Object r0 = this.mExtVolumeControllerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mExtVolumeController != null) goto L11;
    L15:
        this.mExtVolumeController = apc;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        if (this.mExtVolumeController.asBinder().pingBinder() == true) goto L15;
        Log.e(TAG, "Cannot set external volume controller: existing controller");     // Catch: Throwable -> L13
        goto L15
    }

    private void dumpAudioPolicies(PrintWriter pw) {
        pw.println("\nAudio policies:");
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        Iterator<AudioPolicyProxy> r1 = this.mAudioPolicies.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        AudioPolicyProxy policy = r1.next();     // Catch: Throwable -> L8
        pw.println(policy.toLogFriendlyString());     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void ensureFadeManagerConfigIsEnabled() {
        Preconditions.checkState(true, "Fade manager configuration not supported");
    }

    private void validateFadeManagerConfiguration(FadeManagerConfiguration fmc) {
        List<AudioAttributes> attrs = fmc.getAudioAttributesWithVolumeShaperConfigs();
        int index = 0;
    L4:
        if (index >= attrs.size()) goto L7;
        validateAudioAttributesUsage(attrs.get(index));
        index = index + 1;
        goto L4
    }

    private void onDynPolicyMixStateUpdate(String regId, int state) {
        Log.d(TAG, "onDynamicPolicyMixStateUpdate(" + regId + ", " + state + ")");
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        Iterator<AudioPolicyProxy> r1 = this.mAudioPolicies.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L22;
        AudioPolicyProxy policy = r1.next();     // Catch: Throwable -> L14
        Iterator r3 = policy.getMixes().iterator();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L6;
        AudioMix mix = (AudioMix) r3.next();     // Catch: Throwable -> L14
        if (mix.getRegistration().equals(regId) == false) goto L9;
        policy.mPolicyCallback.notifyMixStateUpdate(regId, state);     // Catch: Throwable -> L14 RemoteException -> L16
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        e = move-exception;
        Log.e(TAG, "Can't call notifyMixStateUpdate() on IAudioPolicyCallback " + policy.mPolicyCallback.asBinder(), e);     // Catch: Throwable -> L14
        goto L18
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void registerRecordingCallback(IRecordingConfigDispatcher rcdb) {
        if (this.mContext.checkCallingPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
        boolean isPrivileged = true;
    L6:
        this.mRecordMonitor.registerRecordingCallback(rcdb, isPrivileged);
        return;
    L5:
        isPrivileged = false;
        goto L6
    }

    public void unregisterRecordingCallback(IRecordingConfigDispatcher rcdb) {
        this.mRecordMonitor.unregisterRecordingCallback(rcdb);
    }

    public List<AudioRecordingConfiguration> getActiveRecordingConfigurations() {
        if (Binder.getCallingUid() != 1000) goto L5;
    L8:
        boolean isPrivileged = true;
    L10:
        return this.mRecordMonitor.getActiveRecordingConfigurations(isPrivileged);
    L5:
        if (this.mContext.checkCallingPermission("android.permission.MODIFY_AUDIO_ROUTING") == 0) goto L8;
        isPrivileged = false;
        goto L10
    }

    public int trackRecorder(IBinder recorder) {
        return this.mRecordMonitor.trackRecorder(recorder);
    }

    public void recorderEvent(int riid, int event) {
        this.mRecordMonitor.recorderEvent(riid, event);
    }

    public void releaseRecorder(int riid) {
        this.mRecordMonitor.releaseRecorder(riid);
    }

    public void registerPlaybackCallback(IPlaybackConfigDispatcher pcdb) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
        boolean isPrivileged = true;
    L6:
        this.mPlaybackMonitor.registerPlaybackCallback(pcdb, isPrivileged);
        return;
    L5:
        isPrivileged = false;
        goto L6
    }

    public void unregisterPlaybackCallback(IPlaybackConfigDispatcher pcdb) {
        this.mPlaybackMonitor.unregisterPlaybackCallback(pcdb);
    }

    public List<AudioPlaybackConfiguration> getActivePlaybackConfigurations() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L5;
        boolean isPrivileged = true;
    L7:
        return this.mPlaybackMonitor.getActivePlaybackConfigurations(isPrivileged);
    L5:
        isPrivileged = false;
        goto L7
    }

    public int trackPlayer(PlayerBase.PlayerIdCard pic) {
        if (pic == null) goto L7;
        if (pic.mAttributes == null) goto L7;
        validateAudioAttributesUsage(pic.mAttributes);
    L7:
        return this.mPlaybackMonitor.trackPlayer(pic);
    }

    public void playerAttributes(int piid, AudioAttributes attr) {
        if (attr == null) goto L4;
        validateAudioAttributesUsage(attr);
    L4:
        this.mPlaybackMonitor.playerAttributes(piid, attr, Binder.getCallingUid());
    }

    public void playerSessionId(int piid, int sessionId) {
        if (sessionId <= 0) goto L6;
        this.mPlaybackMonitor.playerSessionId(piid, sessionId, Binder.getCallingUid());
        return;
    L6:
        throw new IllegalArgumentException("invalid session Id " + sessionId);
    }

    public void playerEvent(int piid, int event, int[] eventValues) {
        this.mPlaybackMonitor.playerEvent(piid, event, eventValues, Binder.getCallingUid());
    }

    public void portEvent(int portId, int event, PersistableBundle extras) {
        this.mPlaybackMonitor.portEvent(portId, event, extras, Binder.getCallingUid());
    }

    public void playerHasOpPlayAudio(int piid, boolean hasOpPlayAudio) {
        this.mPlaybackMonitor.playerHasOpPlayAudio(piid, hasOpPlayAudio, Binder.getCallingUid());
    }

    public void releasePlayer(int piid) {
        this.mPlaybackMonitor.releasePlayer(piid, Binder.getCallingUid());
    }

    public int setAllowedCapturePolicy(int capturePolicy) {
        int callingUid = Binder.getCallingUid();
        int flags = AudioAttributes.capturePolicyToFlags(capturePolicy, 0);
        long identity = Binder.clearCallingIdentity();
        PlaybackActivityMonitor r4 = this.mPlaybackMonitor;     // Catch: Throwable -> L15
        monitor-enter(r4);     // Catch: Throwable -> L15
        int result = this.mAudioSystem.setAllowedCapturePolicy(callingUid, flags);     // Catch: Throwable -> L8
        if (result != 0) goto L10;
        this.mPlaybackMonitor.setAllowedCapturePolicy(callingUid, capturePolicy);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r4);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return result;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int getAllowedCapturePolicy() {
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        int r3 = this.mPlaybackMonitor.getAllowedCapturePolicy(callingUid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return r3;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    boolean isPlaybackActiveForUid(int uid) {
        return this.mPlaybackMonitor.isPlaybackActiveForUid(uid);
    }

    boolean isRecordingActiveForUid(int uid) {
        return this.mRecordMonitor.isRecordingActiveForUid(uid);
    }

    public int dispatchFocusChange(AudioFocusInfo afi, int focusChange, IAudioPolicyCallback pcb) {
        if (afi == null) goto L20;
        if (pcb == null) goto L18;
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAudioPolicies.containsKey(pcb.asBinder()) == false) goto L14;
        int r1 = this.mMediaFocusControl.dispatchFocusChange(afi, focusChange);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L14:
        throw new IllegalStateException("Unregistered AudioPolicy for focus dispatch");     // Catch: Throwable -> L11
    L18:
        throw new IllegalArgumentException("Illegal null AudioPolicy callback");
    L20:
        throw new IllegalArgumentException("Illegal null AudioFocusInfo");
    }

    public void setFocusRequestResultFromExtPolicy(AudioFocusInfo afi, int requestResult, IAudioPolicyCallback pcb) {
        if (afi == null) goto L20;
        if (pcb == null) goto L18;
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAudioPolicies.containsKey(pcb.asBinder()) == false) goto L14;
        this.mMediaFocusControl.setFocusRequestResultFromExtPolicy(afi, requestResult);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        throw new IllegalStateException("Unregistered AudioPolicy for external focus");     // Catch: Throwable -> L11
    L18:
        throw new IllegalArgumentException("Illegal null AudioPolicy callback");
    L20:
        throw new IllegalArgumentException("Illegal null AudioFocusInfo");
    }

    public int dispatchFocusChangeWithFade(AudioFocusInfo afi, int focusChange, IAudioPolicyCallback pcb, List<AudioFocusInfo> otherActiveAfis, FadeManagerConfiguration transientFadeMgrConfig) {
        super.dispatchFocusChangeWithFade_enforcePermission();
        ensureFadeManagerConfigIsEnabled();
        afi.getClass();
        pcb.getClass();
        otherActiveAfis.getClass();
        if (transientFadeMgrConfig == null) goto L5;
        validateFadeManagerConfiguration(transientFadeMgrConfig);
    L5:
        HashMap<IBinder, AudioPolicyProxy> r0 = this.mAudioPolicies;
        monitor-enter(r0);
        Preconditions.checkState(this.mAudioPolicies.containsKey(pcb.asBinder()), "Unregistered AudioPolicy for focus dispatch with fade");     // Catch: Throwable -> L10
        if (transientFadeMgrConfig == null) goto L12;
        this.mPlaybackMonitor.setTransientFadeManagerConfiguration(focusChange, transientFadeMgrConfig);     // Catch: Throwable -> L10
    L12:
        int status = this.mMediaFocusControl.dispatchFocusChangeWithFade(afi, focusChange, otherActiveAfis);     // Catch: Throwable -> L10
        if (transientFadeMgrConfig == null) goto L15;
        this.mPlaybackMonitor.clearTransientFadeManagerConfiguration(focusChange);     // Catch: Throwable -> L10
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return status;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean shouldNotificationSoundPlay(AudioAttributes aa) {
        super.shouldNotificationSoundPlay_enforcePermission();
        aa.getClass();
        int stream = AudioAttributes.toLegacyStreamType(aa);
        if (getStreamVolume(stream) != 0) goto L5;
        boolean mutingFromVolume = true;
    L7:
        if (mutingFromVolume == false) goto L10;
        Slog.i(TAG, "shouldNotificationSoundPlay false: muted stream:" + stream + " attr:" + aa);
        return false;
    L10:
        int uid = this.mMediaFocusControl.getExclusiveFocusOwnerUid();
        if (uid != (-1)) goto L13;
        return true;
    L13:
        boolean mutingFromFocusAndRecording = this.mRecordMonitor.isRecordingActiveForUid(uid);
        if (mutingFromFocusAndRecording == false) goto L17;
        Slog.i(TAG, "shouldNotificationSoundPlay false: exclusive focus owner recording  uid:" + uid + " attr:" + aa);
        return false;
    L17:
        return true;
    L5:
        mutingFromVolume = false;
        goto L7
    }

    public void setEnableHardening(boolean shouldEnable) {
        super.setEnableHardening_enforcePermission();
        this.mShouldEnableAllHardening.set(shouldEnable);
        this.mAudioPolicy.setEnableHardening(shouldEnable);
    }

    private void checkMonitorAudioServerStatePermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_PHONE_STATE") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_ROUTING") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("Not allowed to monitor audioserver state");
    }

    public void registerAudioServerStateDispatcher(IAudioServerStateDispatcher asd) {
        checkMonitorAudioServerStatePermission();
        HashMap<IBinder, AsdProxy> r0 = this.mAudioServerStateListeners;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAudioServerStateListeners.containsKey(asd.asBinder()) == false) goto L11;
        Slog.w(TAG, "Cannot re-register audio server state dispatcher");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        AsdProxy asdp = new AsdProxy(this, asd);     // Catch: Throwable -> L9
        asd.asBinder().linkToDeath(asdp, 0);     // Catch: Throwable -> L9 RemoteException -> L14
    L15:
        this.mAudioServerStateListeners.put(asd.asBinder(), asdp);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void unregisterAudioServerStateDispatcher(IAudioServerStateDispatcher asd) {
        checkMonitorAudioServerStatePermission();
        HashMap<IBinder, AsdProxy> r0 = this.mAudioServerStateListeners;
        monitor-enter(r0);
        AsdProxy asdp = this.mAudioServerStateListeners.remove(asd.asBinder());     // Catch: Throwable -> L9
        if (asdp != null) goto L11;
        Slog.w(TAG, "Trying to unregister unknown audioserver state dispatcher for pid " + Binder.getCallingPid() + " / uid " + Binder.getCallingUid());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        asd.asBinder().unlinkToDeath(asdp, 0);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isAudioServerRunning() {
        checkMonitorAudioServerStatePermission();
        if (AudioSystem.checkAudioFlinger() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void getAudioAidlHalPids(HashSet<Integer> pids) {
        ServiceDebugInfo[] infos = ServiceManager.getServiceDebugInfo();     // Catch: RuntimeException -> L13
        if (infos != null) goto L5;
        return;
    L5:
        int r1 = infos.length;     // Catch: RuntimeException -> L13
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L24;
        ServiceDebugInfo info = infos[r2];     // Catch: RuntimeException -> L13
        if (info.debugPid <= 0) goto L15;
        if (info.name.startsWith(AUDIO_HAL_SERVICE_PREFIX) == false) goto L15;
        pids.add(Integer.valueOf(info.debugPid));     // Catch: RuntimeException -> L13
    L15:
        r2 = r2 + 1;
        goto L6
    L24:
        return;
    }

    private void getAudioHalHidlPids(HashSet<Integer> pids) {
        IServiceManager serviceManager = IServiceManager.getService();     // Catch: Throwable -> L13
        ArrayList<IServiceManager.InstanceDebugInfo> dump = serviceManager.debugDump();     // Catch: Throwable -> L13
        Iterator<IServiceManager.InstanceDebugInfo> r2 = dump.iterator();     // Catch: Throwable -> L13
    L4:
        if (r2.hasNext() == false) goto L29;
        IServiceManager.InstanceDebugInfo info = r2.next();     // Catch: Throwable -> L13
        if (info.pid == (-1)) goto L4;
        if (info.interfaceName == null) goto L4;
        if (info.interfaceName.startsWith(AUDIO_HAL_SERVICE_PREFIX) == false) goto L4;
        pids.add(Integer.valueOf(info.pid));     // Catch: Throwable -> L13
    L29:
        return;
    }

    private Set<Integer> getAudioHalPids() {
        HashSet<Integer> pids = new HashSet();
        getAudioAidlHalPids(pids);
        getAudioHalHidlPids(pids);
        return pids;
    }

    private void updateAudioHalPids() {
        Set<Integer> pidsSet = getAudioHalPids();
        if (pidsSet.isEmpty() == false) goto L6;
        Slog.w(TAG, "Could not retrieve audio HAL service pids");
        return;
    L6:
        int[] pidsArray = pidsSet.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();
        AudioSystem.setAudioHalPids(pidsArray);
    }

    public void setMultiAudioFocusEnabled(boolean enabled) {
        super.setMultiAudioFocusEnabled_enforcePermission();
        if (this.mMediaFocusControl == null) goto L10;
        boolean mafEnabled = this.mMediaFocusControl.getMultiAudioFocusEnabled();
        if (mafEnabled == enabled) goto L11;
        this.mMediaFocusControl.updateMultiAudioFocus(enabled);
        if (enabled == true) goto L12;
        this.mDeviceBroker.postBroadcastBecomingNoisy();
        return;
    L12:
        return;
    L11:
        return;
    }

    public void cacheParameters(String keyValuePairs) {
        String[] kvpairs = keyValuePairs.split(";");
        int r1 = kvpairs.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        String pair = kvpairs[r3];
        String[] kv = pair.split("=");
        if (mCachedParams.containsKey(kv[0]) == false) goto L7;
        String oldVal = mCachedParams.put(kv[0], kv[1]);
        Slog.w(TAG, "Updated cached param " + kv[0] + " from " + oldVal + " to " + kv[1]);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    public boolean setAdditionalOutputDeviceDelay(AudioDeviceAttributes device, long delayMillis) {
        device.getClass();
        enforceModifyAudioRoutingPermission();
        AudioDeviceAttributes device2 = retrieveBluetoothAddress(device);
        String getterKey = "additional_output_device_delay=" + device2.getInternalType() + "," + device2.getAddress();
        String setterKey = getterKey + "," + delayMillis;
        if (this.mRestorableParameters.setParameters(getterKey, setterKey) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private long getDelayByKeyDevice(String key, AudioDeviceAttributes device) {
        long delayMillis = 0;
    L11:
        e = move-exception;
        Log.w(TAG, "NullPointerException when getting delay for device " + device, e);
        return 0;
    L5:
        if (1 != getHalVersion().getHalType()) goto L16;
        String reply = AudioSystem.getParameters(key);     // Catch: NullPointerException -> L11
        String keyDeviceAddressPrefix = Integer.toUnsignedString(device.getInternalType()) + "," + device.getAddress() + ",";     // Catch: NullPointerException -> L11
        int start = reply.indexOf(keyDeviceAddressPrefix);     // Catch: NullPointerException -> L11
        if (start == (-1)) goto L25;
        int start2 = start + keyDeviceAddressPrefix.length();     // Catch: NullPointerException -> L11
        int end = reply.indexOf("|", start2);     // Catch: NullPointerException -> L11
        if (end != (-1)) goto L13;
        String r5 = reply.substring(start2);     // Catch: NullPointerException -> L11
    L14:
        delayMillis = Long.parseLong(r5);     // Catch: NullPointerException -> L11
        goto L25
    L13:
        r5 = reply.substring(start2, end);     // Catch: NullPointerException -> L11
    L25:
        return delayMillis;
    L16:
        String reply2 = AudioSystem.getParameters(key + "=" + device.getInternalType() + "," + device.getAddress());     // Catch: NullPointerException -> L11
        if (reply2.contains(key) == false) goto L26;
        long delayMillis2 = Long.parseLong(reply2.substring(key.length() + 1));     // Catch: NullPointerException -> L11
        return delayMillis2;
    L26:
        return 0;
    }

    public long getAdditionalOutputDeviceDelay(AudioDeviceAttributes device) {
        device.getClass();
        return getDelayByKeyDevice("additional_output_device_delay", retrieveBluetoothAddress(device));
    }

    public long getMaxAdditionalOutputDeviceDelay(AudioDeviceAttributes device) {
        device.getClass();
        return getDelayByKeyDevice("max_additional_output_device_delay", retrieveBluetoothAddress(device));
    }

    public void addAssistantServicesUids(int[] assistantUids) {
        super.addAssistantServicesUids_enforcePermission();
        assistantUids.getClass();
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        addAssistantServiceUidsLocked(assistantUids);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAssistantServicesUids(int[] assistantUids) {
        super.removeAssistantServicesUids_enforcePermission();
        assistantUids.getClass();
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        removeAssistantServiceUidsLocked(assistantUids);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int[] getAssistantServicesUids() {
        super.getAssistantServicesUids_enforcePermission();
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int[] assistantUids = this.mAssistantUids.stream().mapToInt(new AudioService$$ExternalSyntheticLambda2()).toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return assistantUids;
    L7:
        th = move-exception;
        throw th;
    }

    public void setActiveAssistantServiceUids(int[] activeAssistantUids) {
        super.setActiveAssistantServiceUids_enforcePermission();
        activeAssistantUids.getClass();
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        this.mActiveAssistantServiceUids = activeAssistantUids;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        updateActiveAssistantServiceUids();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public int[] getActiveAssistantServiceUids() {
        super.getActiveAssistantServiceUids_enforcePermission();
        Object r0 = this.mSettingsLock;
        monitor-enter(r0);
        int[] activeAssistantUids = (int[]) this.mActiveAssistantServiceUids.clone();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return activeAssistantUids;
    L7:
        th = move-exception;
        throw th;
    }

    public void permissionUpdateBarrier() {
        if (PropertyInvalidatedCache.separatePermissionNotificationsEnabled() == false) goto L5;
        this.mCacheWatcher.doCheck();
    L6:
        List<Future> r0 = this.mScheduledPermissionTasks;
        monitor-enter(r0);
        List<Future> snapshot = List.copyOf(this.mScheduledPermissionTasks);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        Iterator<Future> r1 = snapshot.iterator();
    L12:
        if (r1.hasNext() == false) goto L21;
        Future x = r1.next();
        x.get();     // Catch: Throwable -> L16 CancellationException -> L18
    L16:
        e = move-exception;
        Log.wtf(TAG, "Exception which should never occur", e);
        goto L12
    L21:
        return;
    L22:
        th = move-exception;
        throw th;
    L5:
        this.mAudioSystem.triggerSystemPropertyUpdate(this.mSysPropListenerNativeHandle);
        goto L6
    }

    List<String> getDeviceIdentityAddresses(AudioDeviceAttributes device) {
        return this.mDeviceBroker.getDeviceIdentityAddresses(device);
    }

    MusicFxHelper getMusicFxHelper() {
        return this.mMusicFxHelper;
    }

    private boolean isFixedVolumeDevice(int deviceType) {
        if (deviceType != 32768) goto L9;
        if (this.mRecordMonitor.isLegacyRemoteSubmixActive() == false) goto L9;
        return false;
    L9:
        return this.mFixedVolumeDevices.contains(Integer.valueOf(deviceType));
    }

    private boolean isFullVolumeDevice(int deviceType) {
        if (deviceType != 32768) goto L9;
        if (this.mRecordMonitor.isLegacyRemoteSubmixActive() == false) goto L9;
        return false;
    L9:
        return this.mFullVolumeDevices.contains(Integer.valueOf(deviceType));
    }

    private AbsoluteVolumeDeviceInfo getAbsoluteVolumeDeviceInfo(int deviceType) {
        Object r0 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r0);
        AbsoluteVolumeDeviceInfo r1 = this.mAbsoluteVolumeDeviceInfoMap.get(Integer.valueOf(deviceType));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isAbsoluteVolumeDevice(int deviceType) {
        Object r0 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r0);
        boolean r1 = this.mAbsoluteVolumeDeviceInfoMap.containsKey(Integer.valueOf(deviceType));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isA2dpAbsoluteVolumeDevice(int deviceType) {
        if (this.mAvrcpAbsVolSupported == true) goto L5;
    L7:
        return false;
    L5:
        if (AudioSystem.DEVICE_OUT_ALL_A2DP_SET.contains(Integer.valueOf(deviceType)) == false) goto L7;
        return true;
    }

    private static String getSettingsNameForDeviceVolumeBehavior(int deviceType) {
        return "AudioService_DeviceVolumeBehavior_" + AudioSystem.getOutputDeviceName(deviceType);
    }

    private void persistDeviceVolumeBehavior(int deviceType, int deviceVolumeBehavior) {
        Log.d(TAG, "Persisting Volume Behavior for DeviceType: " + deviceType);
        long callingIdentity = Binder.clearCallingIdentity();
        this.mSettings.putSystemIntForUser(this.mContentResolver, getSettingsNameForDeviceVolumeBehavior(deviceType), deviceVolumeBehavior, -2);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingIdentity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    }

    private int retrieveStoredDeviceVolumeBehavior(int deviceType) {
        return this.mSettings.getSystemIntForUser(this.mContentResolver, getSettingsNameForDeviceVolumeBehavior(deviceType), -1, -2);
    }

    private void restoreDeviceVolumeBehavior() {
        Iterator r0 = AudioSystem.DEVICE_OUT_ALL_SET.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        int deviceType = ((Integer) r0.next()).intValue();
        Log.d(TAG, "Retrieving Volume Behavior for DeviceType: " + deviceType);
        int deviceVolumeBehavior = retrieveStoredDeviceVolumeBehavior(deviceType);
        if (deviceVolumeBehavior == (-1)) goto L7;
        setDeviceVolumeBehaviorInternal(new AudioDeviceAttributes(deviceType, ""), deviceVolumeBehavior, "AudioService.restoreDeviceVolumeBehavior()");
        goto L4
    L7:
        Log.d(TAG, "Skipping Setting Volume Behavior for DeviceType: " + deviceType);
        goto L4
    }

    private boolean hasDeviceVolumeBehavior(int audioSystemDeviceOut) {
        if (retrieveStoredDeviceVolumeBehavior(audioSystemDeviceOut) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean addAudioSystemDeviceOutToFixedVolumeDevices(int audioSystemDeviceOut) {
        Log.d(TAG, "Adding DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " to mFixedVolumeDevices");
        return this.mFixedVolumeDevices.add(Integer.valueOf(audioSystemDeviceOut));
    }

    private boolean removeAudioSystemDeviceOutFromFixedVolumeDevices(int audioSystemDeviceOut) {
        Log.d(TAG, "Removing DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " from mFixedVolumeDevices");
        return this.mFixedVolumeDevices.remove(Integer.valueOf(audioSystemDeviceOut));
    }

    private boolean addAudioSystemDeviceOutToFullVolumeDevices(int audioSystemDeviceOut) {
        Log.d(TAG, "Adding DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " to mFullVolumeDevices");
        return this.mFullVolumeDevices.add(Integer.valueOf(audioSystemDeviceOut));
    }

    private boolean removeAudioSystemDeviceOutFromFullVolumeDevices(int audioSystemDeviceOut) {
        Log.d(TAG, "Removing DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " from mFullVolumeDevices");
        return this.mFullVolumeDevices.remove(Integer.valueOf(audioSystemDeviceOut));
    }

    private void addAudioSystemDeviceOutToAbsVolumeDevices(int audioSystemDeviceOut, AbsoluteVolumeDeviceInfo info) {
        if (info != null) goto L5;
        Log.e(TAG, "Cannot add null absolute volume info for audioSystemDeviceOut " + audioSystemDeviceOut);
        return;
    L5:
        Log.d(TAG, "Adding DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " to mAbsoluteVolumeDeviceInfoMap with behavior " + AudioDeviceVolumeManager.volumeBehaviorName(AbsoluteVolumeDeviceInfo.m2114$$Nest$fgetmDeviceVolumeBehavior(info)));
        Object r0 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r0);
        this.mAbsoluteVolumeDeviceInfoMap.put(Integer.valueOf(audioSystemDeviceOut), info);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private AbsoluteVolumeDeviceInfo removeAudioSystemDeviceOutFromAbsVolumeDevices(int audioSystemDeviceOut) {
        Log.d(TAG, "Removing DeviceType: 0x" + Integer.toHexString(audioSystemDeviceOut) + " from mAbsoluteVolumeDeviceInfoMap");
        Object r0 = this.mAbsoluteVolumeDeviceInfoMapLock;
        monitor-enter(r0);
        AbsoluteVolumeDeviceInfo r1 = this.mAbsoluteVolumeDeviceInfoMap.remove(Integer.valueOf(audioSystemDeviceOut));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private long getAudioPermissionsDelay() {
        if (isAudioPermissionUpdatesAddtionallyDelayed() == false) goto L5;
        return 500;
    L5:
        return 60;
    }

    private boolean isAudioPermissionUpdatesAddtionallyDelayed() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == false) goto L5;
        return true;
    L5:
        return false;
    }

    public int[] getActiveUidsForStream(int streamType) {
        List<Integer> uidList = this.mZAudioService.getActiveUidsForStream(streamType);     // Catch: Exception -> L4
        return uidList.stream().mapToInt(new AudioService$$ExternalSyntheticLambda12()).toArray();
    L4:
        e = move-exception;
        Log.e(TAG, "Error in getActiveUidsForStream: " + e.getMessage());
        return new int[0];
    }

    private static /* synthetic */ int lambda$getActiveUidsForStream$31(Integer i) {
        return i.intValue();
    }

    public void registerAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) throws RemoteException {
        this.mZAudioService.registerAudioRecordChangedDispatcher(dispatcher);
    }

    public void unregisterAudioRecordChangedDispatcher(IAudioRecordChangedDispatcher dispatcher) throws RemoteException {
        this.mZAudioService.unregisterAudioRecordChangedDispatcher(dispatcher);
    }

    public boolean isDtsESupportedForUid(int uid) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages != null) goto L5;
    L9:
        return false;
    L5:
        if (packages.length == 0) goto L9;
        return isDtsESupportedForPackage(packages[0]);
    }

    public boolean isDtsESupportedForPackage(String packageName) {
        Log.d(TAG, "isDtsESupportedForPackage() package=" + packageName);
        return this.mZAudioService.isDtsSupported(packageName);
    }

    private boolean checkNoteAppOp(int op, int uid, String packageName, String attributionTag) {
        int op2 = op;
        int uid2 = uid;
        String packageName2 = packageName;
        if (this.mAppOps.noteOp(op2, uid2, packageName2, attributionTag, null) == 0) goto L8;
        return false;
    L8:
        return true;
    L10:
        e = move-exception;
        Exception e = e;
    L14:
        Log.e(TAG, "Error noting op:" + op2 + " on uid:" + uid2 + " for package:" + packageName2, e);
        return false;
    L12:
        e = move-exception;
        op2 = op;
        uid2 = uid;
        packageName2 = packageName;
        e = e;
        goto L14
    }

    private String getPackageNameForUid(int uid) {
        long token = Binder.clearCallingIdentity();
        String[] names = this.mContext.getPackageManager().getPackagesForUid(uid);     // Catch: Throwable -> L13
        if (names != null) goto L6;
    L15:
        String r3 = "[" + uid + "]";     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r3;
    L6:
        if (names.length == 0) goto L15;
        if (TextUtils.isEmpty(names[0]) == true) goto L15;
        String r4 = names[0];     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(token);
        return r4;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }
}
