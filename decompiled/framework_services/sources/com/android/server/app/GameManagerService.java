package com.android.server.app;

import android.app.ActivityManager;
import android.app.GameManagerInternal;
import android.app.GameModeConfiguration;
import android.app.GameModeInfo;
import android.app.GameState;
import android.app.IGameManagerService;
import android.app.IGameModeListener;
import android.app.IGameStateListener;
import android.app.StatsManager;
import android.app.UidObserver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PermissionEnforcer;
import android.os.PowerManagerInternal;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.AttributeSet;
import android.util.KeyValueListParser;
import android.util.Slog;
import android.util.StatsEvent;
import android.util.Xml;
import com.android.internal.R;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import com.android.server.utils.LazyJniRegistrar;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.CompatScaleProvider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class GameManagerService extends IGameManagerService.Stub {
    static final int CANCEL_GAME_LOADING_MODE = 5;
    private static final String EVENT_ON_USER_STARTING = "ON_USER_STARTING";
    private static final String EVENT_ON_USER_STOPPING = "ON_USER_STOPPING";
    private static final String EVENT_ON_USER_SWITCHING = "ON_USER_SWITCHING";
    private static final String EVENT_RECEIVE_SHUTDOWN_INDENT = "RECEIVE_SHUTDOWN_INDENT";
    private static final String EVENT_SET_GAME_MODE = "SET_GAME_MODE";
    private static final String EVENT_UPDATE_CUSTOM_GAME_MODE_CONFIG = "UPDATE_CUSTOM_GAME_MODE_CONFIG";
    private static final String GAME_MODE_INTERVENTION_LIST_FILE_NAME = "game_mode_intervention.list";
    static final int LOADING_BOOST_MAX_DURATION = 5000;
    private static final String PACKAGE_NAME_MSG_KEY = "packageName";
    static final int POPULATE_GAME_MODE_SETTINGS = 3;
    static final String PROPERTY_DEBUG_GFX_GAME_DEFAULT_FRAME_RATE_DISABLED = "debug.graphics.game_default_frame_rate.disabled";
    static final String PROPERTY_RO_SURFACEFLINGER_GAME_DEFAULT_FRAME_RATE = "ro.surface_flinger.game_default_frame_rate_override";
    static final int REMOVE_SETTINGS = 2;
    static final int SET_GAME_STATE = 4;
    public static final String TAG = "GameManagerService";
    private static final String USER_ID_MSG_KEY = "userId";
    static final int WRITE_DELAY_MILLIS = 10000;
    static final int WRITE_GAME_MODE_INTERVENTION_LIST_FILE = 6;
    static final int WRITE_SETTINGS = 1;
    private final ArrayMap<String, GamePackageConfiguration> mConfigs;
    private final Context mContext;
    private DeviceConfigListener mDeviceConfigListener;
    private final Object mDeviceConfigLock;
    private float mGameDefaultFrameRateValue;
    private final Set<Integer> mGameForegroundUids;
    final AtomicFile mGameModeInterventionListFile;
    private final Object mGameModeListenerLock;
    private final ArrayMap<IGameModeListener, Integer> mGameModeListeners;
    private final GameServiceController mGameServiceController;
    private final Object mGameStateListenerLock;
    private final ArrayMap<IGameStateListener, Integer> mGameStateListeners;
    final Handler mHandler;
    private final Object mLock;
    private final Set<Integer> mNonGameForegroundUids;
    private final PackageManager mPackageManager;
    private final PowerManagerInternal mPowerManagerInternal;
    private final ArrayMap<Integer, GameManagerSettings> mSettings;
    private final GameManagerServiceSystemPropertiesWrapper mSysProps;
    final MyUidObserver mUidObserver;
    private final Object mUidObserverLock;
    private final UserManager mUserManager;

    private class DeviceConfigListener implements DeviceConfig.OnPropertiesChangedListener {
        final /* synthetic */ GameManagerService this$0;

        DeviceConfigListener(GameManagerService r2) {
            this.this$0 = r2;
            DeviceConfig.addOnPropertiesChangedListener("game_overlay", GameManagerService.m1622$$Nest$fgetmContext(r2).getMainExecutor(), this);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            String[] packageNames = (String[]) properties.getKeyset().toArray(new String[0]);
            Slog.v(GameManagerService.TAG, "Device config changed for packages: " + Arrays.toString(packageNames));
            this.this$0.updateConfigsForUser(ActivityManager.getCurrentUser(), true, packageNames);
        }

        public void finalize() {
            DeviceConfig.removeOnPropertiesChangedListener(this);
        }
    }

    public static class GamePackageConfiguration {
        private static final String GAME_MODE_CONFIG_NODE_NAME = "game-mode-config";
        public static final String METADATA_ANGLE_ALLOW_ANGLE = "com.android.graphics.intervention.angle.allowAngle";
        public static final String METADATA_BATTERY_MODE_ENABLE = "com.android.app.gamemode.battery.enabled";
        public static final String METADATA_GAME_MODE_CONFIG = "android.game_mode_config";
        public static final String METADATA_PERFORMANCE_MODE_ENABLE = "com.android.app.gamemode.performance.enabled";
        public static final String METADATA_WM_ALLOW_DOWNSCALE = "com.android.graphics.intervention.wm.allowDownscale";
        public static final String TAG = "GameManagerService_GamePackageConfiguration";
        private boolean mAllowAngle;
        private boolean mAllowDownscale;
        private boolean mAllowFpsOverride;
        private boolean mBatteryModeOverridden;
        private final Object mModeConfigLock;
        private final ArrayMap<Integer, GameModeConfiguration> mModeConfigs;
        private final String mPackageName;
        private boolean mPerfModeOverridden;

        public class GameModeConfiguration {
            public static final String ANGLE_KEY = "useAngle";
            public static final String DEFAULT_FPS = "";
            public static final int DEFAULT_LOADING_BOOST_DURATION = -1;
            public static final float DEFAULT_SCALING = -1.0f;
            public static final boolean DEFAULT_USE_ANGLE = false;
            public static final String FPS_KEY = "fps";
            public static final String LOADING_BOOST_KEY = "loadingBoost";
            public static final String MODE_KEY = "mode";
            public static final String SCALING_KEY = "downscaleFactor";
            public static final String TAG = "GameManagerService_GameModeConfiguration";
            private String mFps;
            private final int mGameMode;
            private int mLoadingBoostDuration;
            private float mScaling;
            private boolean mUseAngle;
            final /* synthetic */ GamePackageConfiguration this$0;

            GameModeConfiguration(GamePackageConfiguration this$0, int gameMode) {
                this.this$0 = this$0;
                this.mScaling = -1.0f;
                this.mFps = "";
                this.mGameMode = gameMode;
                this.mUseAngle = false;
                this.mLoadingBoostDuration = -1;
            }

            GameModeConfiguration(GamePackageConfiguration this$0, KeyValueListParser parser) {
                this.this$0 = this$0;
                float r0 = -1.0f;
                this.mScaling = -1.0f;
                String r1 = "";
                this.mFps = "";
                boolean r3 = false;
                this.mGameMode = parser.getInt("mode", 0);
                if (GamePackageConfiguration.m1649$$Nest$fgetmAllowDownscale(this$0) == true) goto L5;
            L9:
                this.mScaling = r0;
                if (GamePackageConfiguration.m1650$$Nest$fgetmAllowFpsOverride(this$0) == true) goto L12;
            L15:
                this.mFps = r1;
                if (GamePackageConfiguration.m1648$$Nest$fgetmAllowAngle(this$0) == true) goto L18;
            L23:
                this.mUseAngle = r3;
                int r2 = -1;
                if (this$0.willGamePerformOptimizations(this.mGameMode) == true) goto L27;
                r2 = parser.getInt(LOADING_BOOST_KEY, -1);
            L27:
                this.mLoadingBoostDuration = r2;
                return;
            L18:
                if (this$0.willGamePerformOptimizations(this.mGameMode) == true) goto L23;
                if (parser.getBoolean(ANGLE_KEY, false) == false) goto L23;
                r3 = true;
                goto L23
            L12:
                if (this$0.willGamePerformOptimizations(this.mGameMode) == true) goto L15;
                r1 = parser.getString(FPS_KEY, "");
                goto L15
            L5:
                if (this$0.willGamePerformOptimizations(this.mGameMode) == true) goto L9;
                r0 = parser.getFloat(SCALING_KEY, -1.0f);
                goto L9
            }

            public int getGameMode() {
                return this.mGameMode;
            }

            public synchronized float getScaling() {
                monitor-enter(this);
                float r0 = this.mScaling;     // Catch: Throwable -> L6
                monitor-exit(this);
                return r0;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized int getFps() {
                monitor-enter(this);
                int fpsInt = Integer.parseInt(this.mFps);     // Catch: Throwable -> L6 NumberFormatException -> L8
                monitor-exit(this);
                return fpsInt;
            L6:
                th = move-exception;
                throw th;
            L14:
                return 0;
            }

            synchronized String getFpsStr() {
                monitor-enter(this);
                String r0 = this.mFps;     // Catch: Throwable -> L6
                monitor-exit(this);
                return r0;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized boolean getUseAngle() {
                monitor-enter(this);
                boolean r0 = this.mUseAngle;     // Catch: Throwable -> L6
                monitor-exit(this);
                return r0;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized int getLoadingBoostDuration() {
                monitor-enter(this);
                int r0 = this.mLoadingBoostDuration;     // Catch: Throwable -> L6
                monitor-exit(this);
                return r0;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized void setScaling(float scaling) {
                monitor-enter(this);
                this.mScaling = scaling;     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized void setFpsStr(String fpsStr) {
                monitor-enter(this);
                this.mFps = fpsStr;     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized void setUseAngle(boolean useAngle) {
                monitor-enter(this);
                this.mUseAngle = useAngle;     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public synchronized void setLoadingBoostDuration(int loadingBoostDuration) {
                monitor-enter(this);
                this.mLoadingBoostDuration = loadingBoostDuration;     // Catch: Throwable -> L6
                monitor-exit(this);
                return;
            L6:
                th = move-exception;
                throw th;
            }

            public boolean isActive() {
                if (this.mGameMode == 1) goto L11;
                if (this.mGameMode == 2) goto L11;
                if (this.mGameMode == 3) goto L11;
                if (this.mGameMode == 4) goto L11;
            L13:
                return false;
            L11:
                if (this.this$0.willGamePerformOptimizations(this.mGameMode) == true) goto L13;
                return true;
            }

            android.app.GameModeConfiguration toPublicGameModeConfig() {
                int fpsOverride = Integer.parseInt(this.mFps);     // Catch: NumberFormatException -> L4
            L6:
                if (fpsOverride <= 0) goto L8;
                int fpsOverride2 = fpsOverride;
            L10:
                if (this.mScaling != (-1.0f)) goto L12;
                float scaling = 1.0f;
            L14:
                return new android.app.GameModeConfiguration.Builder().setScalingFactor(scaling).setFpsOverride(fpsOverride2).build();
            L12:
                scaling = this.mScaling;
                goto L14
            L8:
                fpsOverride2 = 0;
            L5:
                fpsOverride = 0;
                goto L6
            }

            void updateFromPublicGameModeConfig(android.app.GameModeConfiguration config) {
                this.mScaling = config.getScalingFactor();
                this.mFps = String.valueOf(config.getFpsOverride());
            }

            public String toString() {
                return "[Game Mode:" + this.mGameMode + ",Scaling:" + this.mScaling + ",Use Angle:" + this.mUseAngle + ",Fps:" + this.mFps + ",Loading Boost Duration:" + this.mLoadingBoostDuration + "]";
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAllowAngle, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1648$$Nest$fgetmAllowAngle(GamePackageConfiguration r0) {
            return r0.mAllowAngle;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAllowDownscale, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1649$$Nest$fgetmAllowDownscale(GamePackageConfiguration r0) {
            return r0.mAllowDownscale;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAllowFpsOverride, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m1650$$Nest$fgetmAllowFpsOverride(GamePackageConfiguration r0) {
            return r0.mAllowFpsOverride;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetAvailableGameModesBitfield, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1651$$Nest$mgetAvailableGameModesBitfield(GamePackageConfiguration r0) {
            return r0.getAvailableGameModesBitfield();
        }

        GamePackageConfiguration(String packageName) {
            this.mModeConfigLock = new Object();
            this.mModeConfigs = new ArrayMap();
            this.mPerfModeOverridden = false;
            this.mBatteryModeOverridden = false;
            this.mAllowDownscale = true;
            this.mAllowAngle = true;
            this.mAllowFpsOverride = true;
            this.mPackageName = packageName;
        }

        GamePackageConfiguration(PackageManager packageManager, String packageName, int userId) {
            this.mModeConfigLock = new Object();
            this.mModeConfigs = new ArrayMap();
            int r1 = 0;
            this.mPerfModeOverridden = false;
            this.mBatteryModeOverridden = false;
            this.mAllowDownscale = true;
            this.mAllowAngle = true;
            this.mAllowFpsOverride = true;
            this.mPackageName = packageName;
            ApplicationInfo ai = packageManager.getApplicationInfoAsUser(packageName, 128, userId);     // Catch: PackageManager.NameNotFoundException -> L9
            if (parseInterventionFromXml(packageManager, ai, packageName) == false) goto L6;
        L13:
            String configString = DeviceConfig.getProperty("game_overlay", packageName);
            if (configString == null) goto L24;
            String[] gameModeConfigStrings = configString.split(":");
            int r4 = gameModeConfigStrings.length;
        L17:
            if (r1 >= r4) goto L32;
            String gameModeConfigString = gameModeConfigStrings[r1];
            KeyValueListParser parser = new KeyValueListParser(',');     // Catch: IllegalArgumentException -> L21
            parser.setString(gameModeConfigString);     // Catch: IllegalArgumentException -> L21
            addModeConfig(new GameModeConfiguration(this, parser));     // Catch: IllegalArgumentException -> L21
        L23:
            r1 = r1 + 1;
        L22:
            Slog.e(TAG, "Invalid config string");
            goto L23
        L32:
            return;
        L24:
            return;
        L6:
            if (ai.metaData == null) goto L13;
            this.mPerfModeOverridden = ai.metaData.getBoolean(METADATA_PERFORMANCE_MODE_ENABLE);     // Catch: PackageManager.NameNotFoundException -> L9
            this.mBatteryModeOverridden = ai.metaData.getBoolean(METADATA_BATTERY_MODE_ENABLE);     // Catch: PackageManager.NameNotFoundException -> L9
            this.mAllowDownscale = ai.metaData.getBoolean(METADATA_WM_ALLOW_DOWNSCALE, true);     // Catch: PackageManager.NameNotFoundException -> L9
            this.mAllowAngle = ai.metaData.getBoolean(METADATA_ANGLE_ALLOW_ANGLE, true);     // Catch: PackageManager.NameNotFoundException -> L9
        L12:
            Slog.v(TAG, "Failed to get package metadata");
            goto L13
        }

        private boolean parseInterventionFromXml(PackageManager packageManager, ApplicationInfo ai, String packageName) {
            boolean xmlFound = false;
            XmlResourceParser parser = ai.loadXmlMetaData(packageManager, METADATA_GAME_MODE_CONFIG);     // Catch: Throwable -> L20
            if (parser != null) goto L8;
            Slog.v(TAG, "No android.game_mode_config meta-data found for package " + this.mPackageName);     // Catch: Throwable -> L6
        L17:
            if (parser == null) goto L31;
            parser.close();     // Catch: Throwable -> L20 Throwable -> L20 Throwable -> L20
        L31:
            return xmlFound;
        L8:
            xmlFound = true;
            Resources resources = packageManager.getResourcesForApplication(packageName);     // Catch: Throwable -> L6
            AttributeSet attributeSet = Xml.asAttributeSet(parser);     // Catch: Throwable -> L6
        L9:
            int type = parser.next();     // Catch: Throwable -> L6
            if (type == 1) goto L13;
            if (type != 2) goto L9;
        L13:
            boolean isStartingTagGameModeConfig = GAME_MODE_CONFIG_NODE_NAME.equals(parser.getName());     // Catch: Throwable -> L6
            if (isStartingTagGameModeConfig == true) goto L16;
            Slog.w(TAG, "Meta-data does not start with game-mode-config tag");     // Catch: Throwable -> L6
            goto L17
        L16:
            TypedArray array = resources.obtainAttributes(attributeSet, R.styleable.GameModeConfig);     // Catch: Throwable -> L6
            this.mPerfModeOverridden = array.getBoolean(1, false);     // Catch: Throwable -> L6
            this.mBatteryModeOverridden = array.getBoolean(0, false);     // Catch: Throwable -> L6
            this.mAllowDownscale = array.getBoolean(3, true);     // Catch: Throwable -> L6
            this.mAllowAngle = array.getBoolean(2, true);     // Catch: Throwable -> L6
            this.mAllowFpsOverride = array.getBoolean(4, true);     // Catch: Throwable -> L6
            array.recycle();     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            if (parser != null) goto L34;
        L29:
            throw th;     // Catch: Throwable -> L20 Throwable -> L20 Throwable -> L20
        L34:
            parser.close();     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L20 Throwable -> L20 Throwable -> L20
            goto L29
        L30:
            this.mPerfModeOverridden = false;
            this.mBatteryModeOverridden = false;
            this.mAllowDownscale = true;
            this.mAllowAngle = true;
            this.mAllowFpsOverride = true;
            Slog.e(TAG, "Error while parsing XML meta-data for android.game_mode_config");
            goto L31
        }

        GameModeConfiguration getOrAddDefaultGameModeConfiguration(int gameMode) {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
            this.mModeConfigs.putIfAbsent(Integer.valueOf(gameMode), new GameModeConfiguration(this, gameMode));     // Catch: Throwable -> L7
            GameModeConfiguration r1 = this.mModeConfigs.get(Integer.valueOf(gameMode));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        boolean hasActiveGameModeConfig() {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mModeConfigs.isEmpty() == true) goto L7;
            boolean r1 = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L7:
            r1 = false;
            goto L8
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public boolean willGamePerformOptimizations(int gameMode) {
            if (this.mBatteryModeOverridden == false) goto L7;
            if (gameMode != 3) goto L7;
        L10:
            return true;
        L7:
            if (this.mPerfModeOverridden == true) goto L9;
        L11:
            return false;
        L9:
            if (gameMode != 2) goto L11;
            goto L10
        }

        private int getAvailableGameModesBitfield() {
            int field = GameManagerService.m1647$$Nest$smmodeToBitmask(4) | GameManagerService.m1647$$Nest$smmodeToBitmask(1);
            Object r1 = this.mModeConfigLock;
            monitor-enter(r1);
            Iterator<Integer> r2 = this.mModeConfigs.keySet().iterator();     // Catch: Throwable -> L8
        L6:
            if (r2.hasNext() == false) goto L10;
            int mode = r2.next().intValue();     // Catch: Throwable -> L8
            field = field | GameManagerService.m1647$$Nest$smmodeToBitmask(mode);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L8
            if (this.mBatteryModeOverridden == false) goto L15;
            field = field | GameManagerService.m1647$$Nest$smmodeToBitmask(3);
        L15:
            if (this.mPerfModeOverridden == true) goto L17;
            return field;
        L17:
            return field | GameManagerService.m1647$$Nest$smmodeToBitmask(2);
        L8:
            th = move-exception;
            throw th;
        }

        public int[] getAvailableGameModes() {
            int modesBitfield = getAvailableGameModesBitfield();
            int[] modes = new int[Integer.bitCount(modesBitfield)];
            int i = 0;
            int gameModeInHighestBit = Integer.numberOfTrailingZeros(Integer.highestOneBit(modesBitfield));
            int mode = 0;
        L3:
            if (mode > gameModeInHighestBit) goto L9;
            if (((modesBitfield >> mode) & 1) == 0) goto L7;
            modes[i] = mode;
            i = i + 1;
        L7:
            mode = mode + 1;
            goto L3
        L9:
            return modes;
        }

        public int[] getOverriddenGameModes() {
            if (this.mBatteryModeOverridden == false) goto L9;
            if (this.mPerfModeOverridden == false) goto L9;
            return new int[]{3, 2};
        L9:
            if (this.mBatteryModeOverridden == false) goto L13;
            return new int[]{3};
        L13:
            if (this.mPerfModeOverridden == false) goto L17;
            return new int[]{2};
        L17:
            return new int[0];
        }

        public GameModeConfiguration getGameModeConfiguration(int gameMode) {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
            GameModeConfiguration r1 = this.mModeConfigs.get(Integer.valueOf(gameMode));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void addModeConfig(GameModeConfiguration config) {
            if (config.isActive() == false) goto L12;
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
            this.mModeConfigs.put(Integer.valueOf(config.getGameMode()), config);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L12:
            Slog.w(TAG, "Attempt to add inactive game mode config for " + this.mPackageName + ":" + config.toString());
        }

        public void removeModeConfig(int mode) {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
            this.mModeConfigs.remove(Integer.valueOf(mode));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isActive() {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mModeConfigs.size() > 0) goto L14;
            if (this.mBatteryModeOverridden == true) goto L14;
            if (this.mPerfModeOverridden == true) goto L14;
            boolean r1 = false;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L14:
            r1 = true;
            goto L15
        }

        GamePackageConfiguration copyAndApplyOverride(GamePackageConfiguration overrideConfig) {
            GamePackageConfiguration copy = new GamePackageConfiguration(this.mPackageName);
            boolean r2 = false;
            if (this.mPerfModeOverridden == false) goto L8;
            if (overrideConfig != null) goto L6;
        L7:
            boolean r1 = true;
        L9:
            copy.mPerfModeOverridden = r1;
            if (this.mBatteryModeOverridden == false) goto L15;
            if (overrideConfig != null) goto L13;
        L14:
            boolean r3 = true;
        L16:
            copy.mBatteryModeOverridden = r3;
            if (this.mAllowDownscale == true) goto L21;
            if (overrideConfig != null) goto L21;
            boolean r4 = false;
        L22:
            copy.mAllowDownscale = r4;
            if (this.mAllowAngle == true) goto L27;
            if (overrideConfig != null) goto L27;
            boolean r5 = false;
        L28:
            copy.mAllowAngle = r5;
            if (this.mAllowFpsOverride == true) goto L31;
            if (overrideConfig != null) goto L31;
        L32:
            copy.mAllowFpsOverride = r2;
            if (overrideConfig == null) goto L64;
            Object r6 = copy.mModeConfigLock;
            monitor-enter(r6);
            Object r7 = this.mModeConfigLock;     // Catch: Throwable -> L56
            monitor-enter(r7);     // Catch: Throwable -> L56
            Iterator<Map.Entry<Integer, GameModeConfiguration>> r8 = this.mModeConfigs.entrySet().iterator();     // Catch: Throwable -> L42
        L40:
            if (r8.hasNext() == false) goto L44;
            Map.Entry<Integer, GameModeConfiguration> entry = r8.next();     // Catch: Throwable -> L42
            copy.mModeConfigs.put(entry.getKey(), entry.getValue());     // Catch: Throwable -> L42
            goto L40
        L44:
            monitor-exit(r7);     // Catch: Throwable -> L42
            Object r9 = overrideConfig.mModeConfigLock;     // Catch: Throwable -> L56
            monitor-enter(r9);     // Catch: Throwable -> L56
            Iterator<Map.Entry<Integer, GameModeConfiguration>> r10 = overrideConfig.mModeConfigs.entrySet().iterator();     // Catch: Throwable -> L51
        L49:
            if (r10.hasNext() == false) goto L53;
            Map.Entry<Integer, GameModeConfiguration> entry2 = r10.next();     // Catch: Throwable -> L51
            copy.mModeConfigs.put(entry2.getKey(), entry2.getValue());     // Catch: Throwable -> L51
            goto L49
        L53:
            monitor-exit(r9);     // Catch: Throwable -> L51
            monitor-exit(r6);     // Catch: Throwable -> L56
            goto L64
        L51:
            th = move-exception;
            throw th;     // Catch: Throwable -> L56
        L42:
            th = move-exception;
            throw th;     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            throw th;
        L64:
            return copy;
        L31:
            r2 = true;
        L27:
            r5 = true;
        L21:
            r4 = true;
            goto L22
        L13:
            if (overrideConfig.getGameModeConfiguration(3) == null) goto L14;
        L15:
            r3 = false;
            goto L16
        L6:
            if (overrideConfig.getGameModeConfiguration(2) == null) goto L7;
        L8:
            r1 = false;
            goto L9
        }

        public String toString() {
            Object r0 = this.mModeConfigLock;
            monitor-enter(r0);
            String r1 = "[Name:" + this.mPackageName + " Modes: " + this.mModeConfigs.toString() + "]";     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class Injector {
        Injector() {
        }

        public GameManagerServiceSystemPropertiesWrapper createSystemPropertiesWrapper() {
            return new AnonymousClass1(this);
        }
    }

    public static class Lifecycle extends SystemService {
        private GameManagerService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new GameManagerService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService("game", this.mService);
            GameManagerService.m1638$$Nest$mpublishLocalService(this.mService);
            GameManagerService.m1639$$Nest$mregisterDeviceConfigListener(this.mService);
            GameManagerService.m1640$$Nest$mregisterPackageReceiver(this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 1000) goto L6;
            this.mService.onBootCompleted();
            GameManagerService.m1641$$Nest$mregisterStatsCallbacks(this.mService);
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserStarting(SystemService.TargetUser user) {
            Slog.d(GameManagerService.TAG, "Starting user " + user.getUserIdentifier());
            this.mService.onUserStarting(user, null);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            this.mService.onUserUnlocking(user);
        }

        @Override // com.android.server.SystemService
        public void onUserStopping(SystemService.TargetUser user) {
            this.mService.onUserStopping(user);
        }

        @Override // com.android.server.SystemService
        public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
            this.mService.onUserSwitching(from, to);
        }
    }

    private final class LocalService extends GameManagerInternal implements CompatScaleProvider {
        final /* synthetic */ GameManagerService this$0;

        /* synthetic */ LocalService(GameManagerService r1, GameManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(GameManagerService r1) {
            this.this$0 = r1;
        }

        public float getResolutionScalingFactor(String packageName, int userId) {
            int gameMode = GameManagerService.m1635$$Nest$mgetGameModeFromSettingsUnchecked(this.this$0, packageName, userId);
            return this.this$0.getResolutionScalingFactorInternal(packageName, gameMode, userId);
        }

        @Override // com.android.server.wm.CompatScaleProvider
        public CompatibilityInfo.CompatScale getCompatScale(String packageName, int uid) {
            UserHandle userHandle = UserHandle.getUserHandleForUid(uid);
            int userId = userHandle.getIdentifier();
            float scalingFactor = getResolutionScalingFactor(packageName, userId);
            if (scalingFactor > 0.0f) goto L5;
            return null;
        L5:
            return new CompatibilityInfo.CompatScale(1.0f / scalingFactor);
        }
    }

    final class MyUidObserver extends UidObserver {
        final /* synthetic */ GameManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$mE-7E21f94kUEAgfV42TQXpejok, reason: not valid java name */
        public static /* synthetic */ boolean m1652$r8$lambda$mE7E21f94kUEAgfV42TQXpejok(MyUidObserver r0, int r1, String r2) {
            return r0.lambda$handleUidMovedToTop$0(r1, r2);
        }

        MyUidObserver(GameManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onUidGone(int uid, boolean disabled) {
            Object r0 = GameManagerService.m1633$$Nest$fgetmUidObserverLock(this.this$0);
            monitor-enter(r0);
            handleUidMovedOffTop(uid);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void onUidStateChanged(int uid, int procState, long procStateSeq, int capability) {
            switch(procState) {
                case 2: goto L5;
                default: goto L3;
            };
        L3:
            handleUidMovedOffTop(uid);
            return;
        L5:
            handleUidMovedToTop(uid);
        }

        private void handleUidMovedToTop(int uid) {
            String[] packages = GameManagerService.m1629$$Nest$fgetmPackageManager(this.this$0).getPackagesForUid(uid);
            if (packages != null) goto L5;
            return;
        L5:
            if (packages.length == 0) goto L36;
            final int userId = ActivityManager.getCurrentUser();
            boolean isNotGame = Arrays.stream(packages).noneMatch(new GameManagerService$MyUidObserver$$ExternalSyntheticLambda0(this, userId));
            Object r3 = GameManagerService.m1633$$Nest$fgetmUidObserverLock(this.this$0);
            monitor-enter(r3);
            boolean r5 = false;
            if (isNotGame == false) goto L22;
            if (GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).isEmpty() == false) goto L14;
        L18:
            GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).add(Integer.valueOf(uid));     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L14:
            if (GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).isEmpty() == false) goto L18;
            Slog.v(GameManagerService.TAG, "Game power mode OFF (first non-game in foreground)");     // Catch: Throwable -> L16
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(15, false);     // Catch: Throwable -> L16
            goto L18
        L22:
            if (GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).isEmpty() == true) goto L24;
        L26:
            boolean isGameDefaultFrameRateDisabled = GameManagerService.m1632$$Nest$fgetmSysProps(this.this$0).getBoolean(GameManagerService.PROPERTY_DEBUG_GFX_GAME_DEFAULT_FRAME_RATE_DISABLED, false);     // Catch: Throwable -> L16
            GameManagerService r6 = this.this$0;     // Catch: Throwable -> L16
            GameManagerService r8 = this.this$0;     // Catch: Throwable -> L16
            if (isGameDefaultFrameRateDisabled == true) goto L29;
            r5 = true;
        L29:
            r6.setGameDefaultFrameRateOverride(uid, GameManagerService.m1634$$Nest$mgetGameDefaultFrameRate(r8, r5));     // Catch: Throwable -> L16
            GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).add(Integer.valueOf(uid));     // Catch: Throwable -> L16
            monitor-exit(r3);     // Catch: Throwable -> L16
            return;
        L24:
            if (GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).isEmpty() == false) goto L26;
            Slog.v(GameManagerService.TAG, "Game power mode ON (first game in foreground)");     // Catch: Throwable -> L16
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(15, true);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ boolean lambda$handleUidMovedToTop$0(int userId, String p) {
            return GameManagerService.m1637$$Nest$misPackageGame(this.this$0, p, userId);
        }

        private void handleUidMovedOffTop(int uid) {
            Object r0 = GameManagerService.m1633$$Nest$fgetmUidObserverLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).contains(Integer.valueOf(uid)) == false) goto L14;
            GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L11
            if (GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).isEmpty() == true) goto L9;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L9:
            if (GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).isEmpty() == false) goto L20;
            Slog.v(GameManagerService.TAG, "Game power mode OFF (no games in foreground)");     // Catch: Throwable -> L11
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(15, false);     // Catch: Throwable -> L11
            goto L20
        L14:
            if (GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).contains(Integer.valueOf(uid)) == false) goto L20;
            GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L11
            if (GameManagerService.m1628$$Nest$fgetmNonGameForegroundUids(this.this$0).isEmpty() == false) goto L20;
            if (GameManagerService.m1624$$Nest$fgetmGameForegroundUids(this.this$0).isEmpty() == true) goto L20;
            Slog.v(GameManagerService.TAG, "Game power mode ON (only games in foreground)");     // Catch: Throwable -> L11
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(15, true);     // Catch: Throwable -> L11
            goto L20
        }
    }

    class SettingsHandler extends Handler {
        final /* synthetic */ GameManagerService this$0;

        SettingsHandler(GameManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            doHandleMessage(msg);
        }

        void doHandleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L94;
                case 2: goto L73;
                case 3: goto L62;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L5;
                default: goto L146;
            };
        L5:
            int userId = ((Integer) msg.obj).intValue();
            if (userId >= 0) goto L15;
            Slog.wtf(GameManagerService.TAG, "Attempt to write setting for invalid user: " + userId);
            Object r5 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r5);
            removeEqualMessages(6, msg.obj);     // Catch: Throwable -> L12
            monitor-exit(r5);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        L15:
            Process.setThreadPriority(0);
            removeEqualMessages(6, msg.obj);
            GameManagerService.m1645$$Nest$mwriteGameModeInterventionsToFile(this.this$0, userId);
            Process.setThreadPriority(10);
            return;
        L16:
            Slog.v(GameManagerService.TAG, "Game loading power mode OFF (loading boost ended)");
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(16, false);
            return;
        L17:
            GameState gameState = (GameState) msg.obj;
            boolean isLoading = gameState.isLoading();
            Bundle data = msg.getData();
            String packageName = data.getString("packageName");
            int userId2 = data.getInt("userId");
            if (this.this$0.getGameMode(packageName, userId2) != 2) goto L20;
            boolean boostEnabled = true;
        L132:
            int uid = GameManagerService.m1629$$Nest$fgetmPackageManager(this.this$0).getPackageUidAsUser(packageName, userId2);     // Catch: PackageManager.NameNotFoundException -> L23
            int uid2 = uid;
        L25:
            FrameworkStatsLog.write(FrameworkStatsLog.GAME_STATE_CHANGED, packageName, uid2, boostEnabled, GameManagerService.m1646$$Nest$smgameStateModeToStatsdGameState(gameState.getMode()), isLoading, gameState.getLabel(), gameState.getQuality());
            if (boostEnabled == true) goto L28;
        L44:
            Object r3 = GameManagerService.m1625$$Nest$fgetmGameStateListenerLock(this.this$0);
            monitor-enter(r3);
            Iterator r7 = GameManagerService.m1626$$Nest$fgetmGameStateListeners(this.this$0).keySet().iterator();     // Catch: Throwable -> L53
        L48:
            if (r7.hasNext() == false) goto L58;
            IGameStateListener listener = (IGameStateListener) r7.next();     // Catch: Throwable -> L53
            listener.onGameStateChanged(packageName, gameState, userId2);     // Catch: Throwable -> L53 RemoteException -> L55
        L56:
            Slog.w(GameManagerService.TAG, "Cannot notify game state change for listener added by " + GameManagerService.m1626$$Nest$fgetmGameStateListeners(this.this$0).get(listener));     // Catch: Throwable -> L53
            goto L48
        L58:
            monitor-exit(r3);     // Catch: Throwable -> L53
            return;
        L53:
            th = move-exception;
            throw th;
        L28:
            if (GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0) != null) goto L31;
            Slog.d(GameManagerService.TAG, "Error setting loading mode for package " + packageName + " and userId " + userId2);
            return;
        L31:
            if (this.this$0.mHandler.hasMessages(5) == false) goto L34;
            this.this$0.mHandler.removeMessages(5);
        L34:
            if (isLoading == false) goto L36;
            String r12 = "ON";
        L37:
            Slog.v(GameManagerService.TAG, String.format("Game loading power mode %s (game state change isLoading=%b)", new Object[]{r12, Boolean.valueOf(isLoading)}));
            GameManagerService.m1630$$Nest$fgetmPowerManagerInternal(this.this$0).setPowerMode(16, isLoading);
            if (isLoading == false) goto L44;
            int loadingBoostDuration = this.this$0.getLoadingBoostDuration(packageName, userId2);
            if (loadingBoostDuration <= 0) goto L42;
            int loadingBoostDuration2 = loadingBoostDuration;
        L43:
            this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(5), loadingBoostDuration2);
            goto L44
        L42:
            loadingBoostDuration2 = 5000;
            goto L43
        L36:
            r12 = "OFF";
        L24:
            Slog.v(GameManagerService.TAG, "Failed to get package metadata");
            uid2 = -1;
            goto L25
        L20:
            boostEnabled = false;
            goto L132
        L62:
            removeEqualMessages(3, msg.obj);
            int userId3 = ((Integer) msg.obj).intValue();
            Object r4 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
        L67:
            th = move-exception;
            throw th;
        L65:
            if (GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).containsKey(Integer.valueOf(userId3)) == true) goto L69;
            GameManagerSettings userSettings = new GameManagerSettings(Environment.getDataSystemDeDirectory(userId3));     // Catch: Throwable -> L67
            GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).put(Integer.valueOf(userId3), userSettings);     // Catch: Throwable -> L67
            userSettings.readPersistentDataLocked();     // Catch: Throwable -> L67
        L69:
            monitor-exit(r4);     // Catch: Throwable -> L67
            String[] packageNames = GameManagerService.m1636$$Nest$mgetInstalledGamePackageNames(this.this$0, userId3);
            this.this$0.updateConfigsForUser(userId3, false, packageNames);
            return;
        L73:
            int userId4 = ((Integer) msg.obj).intValue();
            if (userId4 >= 0) goto L83;
            Slog.wtf(GameManagerService.TAG, "Attempt to write settings for invalid user: " + userId4);
            Object r6 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r6);
            removeEqualMessages(1, msg.obj);     // Catch: Throwable -> L80
            removeEqualMessages(2, msg.obj);     // Catch: Throwable -> L80
            monitor-exit(r6);     // Catch: Throwable -> L80
            return;
        L80:
            th = move-exception;
            throw th;
        L83:
            Object r8 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r8);
            removeEqualMessages(1, msg.obj);     // Catch: Throwable -> L88
            removeEqualMessages(2, msg.obj);     // Catch: Throwable -> L88
            if (GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).containsKey(Integer.valueOf(userId4)) == false) goto L90;
            GameManagerSettings userSettings2 = (GameManagerSettings) GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).get(Integer.valueOf(userId4));     // Catch: Throwable -> L88
            GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).remove(Integer.valueOf(userId4));     // Catch: Throwable -> L88
            userSettings2.writePersistentDataLocked();     // Catch: Throwable -> L88
        L90:
            monitor-exit(r8);     // Catch: Throwable -> L88
            return;
        L88:
            th = move-exception;
            throw th;
        L94:
            int userId5 = ((Integer) msg.obj).intValue();
            if (userId5 >= 0) goto L104;
            Slog.wtf(GameManagerService.TAG, "Attempt to write settings for invalid user: " + userId5);
            Object r9 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r9);
            removeEqualMessages(1, msg.obj);     // Catch: Throwable -> L101
            monitor-exit(r9);     // Catch: Throwable -> L101
            return;
        L101:
            th = move-exception;
            throw th;
        L104:
            Process.setThreadPriority(0);
            Object r10 = GameManagerService.m1627$$Nest$fgetmLock(this.this$0);
            monitor-enter(r10);
            removeEqualMessages(1, msg.obj);     // Catch: Throwable -> L109
            if (GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).containsKey(Integer.valueOf(userId5)) == false) goto L111;
            GameManagerSettings userSettings3 = (GameManagerSettings) GameManagerService.m1631$$Nest$fgetmSettings(this.this$0).get(Integer.valueOf(userId5));     // Catch: Throwable -> L109
            userSettings3.writePersistentDataLocked();     // Catch: Throwable -> L109
        L111:
            monitor-exit(r10);     // Catch: Throwable -> L109
            Process.setThreadPriority(10);
            return;
        L109:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$LCP_4kvy-EB-QxmT_kuk0Xyillc, reason: not valid java name */
    public static /* synthetic */ int m1618$r8$lambda$LCP_4kvyEBQxmT_kuk0Xyillc(GameManagerService r0, int r1, List r2) {
        return r0.onPullAtom(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Sir-wtA0n6T1spL0WarCI-ChMjA, reason: not valid java name */
    public static /* synthetic */ boolean m1619$r8$lambda$SirwtA0n6T1spL0WarCIChMjA(PackageInfo r0) {
        return lambda$getInstalledGamePackageNames$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Vw8LG-SrmMKQ0zSB9jhVgUNBUkg, reason: not valid java name */
    public static /* synthetic */ String m1620$r8$lambda$Vw8LGSrmMKQ0zSB9jhVgUNBUkg(PackageInfo r0) {
        return lambda$getInstalledGamePackageNames$3(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$XK11PVBRPXwrQj1WwLFHGeixUJY(GameManagerService r0, int r1, String r2) {
        return r0.lambda$updateConfigsForUser$0(r1, r2);
    }

    public static /* synthetic */ String[] $r8$lambda$v0loNmftGWUMC3VLYZhDYOY54xM(int r0) {
        return lambda$getInstalledGamePackageNames$4(r0);
    }

    public static /* synthetic */ String[] $r8$lambda$xp9GXdoINU6fbuzy69VUqMrQlB0(int r0) {
        return lambda$updateConfigsForUser$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfigs, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1621$$Nest$fgetmConfigs(GameManagerService r0) {
        return r0.mConfigs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1622$$Nest$fgetmContext(GameManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceConfigLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1623$$Nest$fgetmDeviceConfigLock(GameManagerService r0) {
        return r0.mDeviceConfigLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGameForegroundUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m1624$$Nest$fgetmGameForegroundUids(GameManagerService r0) {
        return r0.mGameForegroundUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGameStateListenerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1625$$Nest$fgetmGameStateListenerLock(GameManagerService r0) {
        return r0.mGameStateListenerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGameStateListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1626$$Nest$fgetmGameStateListeners(GameManagerService r0) {
        return r0.mGameStateListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1627$$Nest$fgetmLock(GameManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNonGameForegroundUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m1628$$Nest$fgetmNonGameForegroundUids(GameManagerService r0) {
        return r0.mNonGameForegroundUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m1629$$Nest$fgetmPackageManager(GameManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerInternal m1630$$Nest$fgetmPowerManagerInternal(GameManagerService r0) {
        return r0.mPowerManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m1631$$Nest$fgetmSettings(GameManagerService r0) {
        return r0.mSettings;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSysProps, reason: not valid java name */
    static /* bridge */ /* synthetic */ GameManagerServiceSystemPropertiesWrapper m1632$$Nest$fgetmSysProps(GameManagerService r0) {
        return r0.mSysProps;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidObserverLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1633$$Nest$fgetmUidObserverLock(GameManagerService r0) {
        return r0.mUidObserverLock;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetGameDefaultFrameRate, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m1634$$Nest$mgetGameDefaultFrameRate(GameManagerService r0, boolean r1) {
        return r0.getGameDefaultFrameRate(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetGameModeFromSettingsUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1635$$Nest$mgetGameModeFromSettingsUnchecked(GameManagerService r0, String r1, int r2) {
        return r0.getGameModeFromSettingsUnchecked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetInstalledGamePackageNames, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m1636$$Nest$mgetInstalledGamePackageNames(GameManagerService r0, int r1) {
        return r0.getInstalledGamePackageNames(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPackageGame, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1637$$Nest$misPackageGame(GameManagerService r0, String r1, int r2) {
        return r0.isPackageGame(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpublishLocalService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1638$$Nest$mpublishLocalService(GameManagerService r0) {
        r0.publishLocalService();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDeviceConfigListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1639$$Nest$mregisterDeviceConfigListener(GameManagerService r0) {
        r0.registerDeviceConfigListener();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterPackageReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1640$$Nest$mregisterPackageReceiver(GameManagerService r0) {
        r0.registerPackageReceiver();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterStatsCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1641$$Nest$mregisterStatsCallbacks(GameManagerService r0) {
        r0.registerStatsCallbacks();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveGameModeListenerUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1642$$Nest$mremoveGameModeListenerUnchecked(GameManagerService r0, IGameModeListener r1) {
        r0.removeGameModeListenerUnchecked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveGameStateListenerUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1643$$Nest$mremoveGameStateListenerUnchecked(GameManagerService r0, IGameStateListener r1) {
        r0.removeGameStateListenerUnchecked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msendUserMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1644$$Nest$msendUserMessage(GameManagerService r0, int r1, int r2, String r3, int r4) {
        r0.sendUserMessage(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteGameModeInterventionsToFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1645$$Nest$mwriteGameModeInterventionsToFile(GameManagerService r0, int r1) {
        r0.writeGameModeInterventionsToFile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgameStateModeToStatsdGameState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1646$$Nest$smgameStateModeToStatsdGameState(int r0) {
        return gameStateModeToStatsdGameState(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smmodeToBitmask, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1647$$Nest$smmodeToBitmask(int r0) {
        return modeToBitmask(r0);
    }

    private static native void nativeSetGameDefaultFrameRateOverride(int r0, float r1);

    private static native void nativeSetGameModeFrameRateOverride(int r0, float r1);

    static {
        LazyJniRegistrar.registerGameManagerService();
    }

    public GameManagerService(Context context) {
        this(context, createServiceThread().getLooper());
    }

    GameManagerService(Context context, Looper looper) {
        this(context, looper, Environment.getDataDirectory(), new Injector());
    }

    GameManagerService(Context context, Looper looper, File dataDir, Injector injector) {
        super(PermissionEnforcer.fromContext(context));
        this.mLock = new Object();
        this.mDeviceConfigLock = new Object();
        this.mGameModeListenerLock = new Object();
        this.mGameStateListenerLock = new Object();
        this.mSettings = new ArrayMap();
        this.mConfigs = new ArrayMap();
        this.mGameModeListeners = new ArrayMap();
        this.mGameStateListeners = new ArrayMap();
        this.mUidObserverLock = new Object();
        this.mGameForegroundUids = new HashSet();
        this.mNonGameForegroundUids = new HashSet();
        this.mContext = context;
        this.mHandler = new SettingsHandler(this, looper);
        this.mPackageManager = this.mContext.getPackageManager();
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        this.mPowerManagerInternal = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        File systemDir = new File(dataDir, "system");
        systemDir.mkdirs();
        FileUtils.setPermissions(systemDir.toString(), 509, -1, -1);
        this.mGameModeInterventionListFile = new AtomicFile(new File(systemDir, GAME_MODE_INTERVENTION_LIST_FILE_NAME));
        FileUtils.setPermissions(this.mGameModeInterventionListFile.getBaseFile().getAbsolutePath(), FrameworkStatsLog.HOTWORD_DETECTION_SERVICE_RESTARTED, -1, -1);
        if (this.mPackageManager.hasSystemFeature("android.software.game_service") == false) goto L5;
        this.mGameServiceController = new GameServiceController(context, BackgroundThread.getExecutor(), new GameServiceProviderSelectorImpl(context.getResources(), this.mPackageManager), new GameServiceProviderInstanceFactoryImpl(context));
    L6:
        this.mUidObserver = new MyUidObserver(this);
        ActivityManager.getService().registerUidObserver(this.mUidObserver, 3, -1, null);     // Catch: RemoteException -> L9
    L11:
        this.mSysProps = injector.createSystemPropertiesWrapper();
        return;
    L10:
        Slog.w(TAG, "Could not register UidObserver");
        goto L11
    L5:
        this.mGameServiceController = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver result) {
        new GameManagerShellCommand(this.mPackageManager).exec(this, in, out, err, args, callback, result);
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        writer.println("Permission Denial: can't dump GameManagerService from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " without permission android.permission.DUMP");
        return;
    L6:
        if (args != null) goto L8;
    L9:
        writer.println("*Dump GameManagerService*");
        dumpAllGameConfigs(writer);
        return;
    L8:
        if (args.length == 0) goto L9;
    }

    private void dumpAllGameConfigs(PrintWriter pw) {
        int userId = ActivityManager.getCurrentUser();
        String[] packageList = getInstalledGamePackageNames(userId);
        int r2 = packageList.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        String packageName = packageList[r3];
        pw.println(getInterventionList(packageName, userId));
        r3 = r3 + 1;
        goto L3
    }

    public void setGameState(String packageName, GameState gameState, int userId) {
        if (isPackageGame(packageName, userId) == true) goto L6;
        Slog.d(TAG, "No-op for attempt to set game state for non-game app: " + packageName);
        return;
    L6:
        Message msg = this.mHandler.obtainMessage(4);
        Bundle data = new Bundle();
        data.putString("packageName", packageName);
        data.putInt("userId", userId);
        msg.setData(data);
        msg.obj = gameState;
        this.mHandler.sendMessage(msg);
    }

    private boolean isValidPackageName(String packageName, int userId) {
        if (this.mPackageManager.getPackageUidAsUser(packageName, userId) != Binder.getCallingUid()) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }

    private void checkPermission(String permission) throws SecurityException {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Access denied to process: " + Binder.getCallingPid() + ", must have permission " + permission);
    }

    private int[] getAvailableGameModesUnchecked(String packageName, int userId) {
        GamePackageConfiguration config = getConfig(packageName, userId);
        if (config != null) goto L7;
        return new int[]{1, 4};
    L7:
        return config.getAvailableGameModes();
    }

    private boolean isPackageGame(String packageName, int userId) {
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfoAsUser(packageName, 131072, userId);     // Catch: PackageManager.NameNotFoundException -> L7
        if (applicationInfo.category != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }

    public int[] getAvailableGameModes(String packageName, int userId) throws SecurityException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        if (isPackageGame(packageName, userId) == true) goto L7;
        return new int[0];
    L7:
        return getAvailableGameModesUnchecked(packageName, userId);
    }

    private int getGameModeFromSettingsUnchecked(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L12;
        Slog.d(TAG, "User ID '" + userId + "' does not have a Game Mode selected for package: '" + packageName + "'");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return 1;
    L12:
        int r1 = this.mSettings.get(Integer.valueOf(userId)).getGameModeLocked(packageName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    public int getGameMode(String packageName, int userId) throws SecurityException {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getGameMode", "com.android.server.app.GameManagerService");
        if (isPackageGame(packageName, userId2) == true) goto L7;
        return 0;
    L7:
        if (isValidPackageName(packageName, userId2) == true) goto L9;
        checkPermission("android.permission.MANAGE_GAME_MODE");
        return getGameModeFromSettingsUnchecked(packageName, userId2);
    L9:
        return getGameModeFromSettingsUnchecked(packageName, userId2);
    }

    public GameModeInfo getGameModeInfo(String packageName, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getGameModeInfo", "com.android.server.app.GameManagerService");
        checkPermission("android.permission.MANAGE_GAME_MODE");
        if (isPackageGame(packageName, userId2) == true) goto L6;
        return null;
    L6:
        int activeGameMode = getGameModeFromSettingsUnchecked(packageName, userId2);
        GamePackageConfiguration config = getConfig(packageName, userId2);
        if (config == null) goto L19;
        int[] overriddenGameModes = config.getOverriddenGameModes();
        int[] availableGameModes = config.getAvailableGameModes();
        GameModeInfo.Builder gameModeInfoBuilder = new GameModeInfo.Builder().setActiveGameMode(activeGameMode).setAvailableGameModes(availableGameModes).setOverriddenGameModes(overriddenGameModes).setDownscalingAllowed(GamePackageConfiguration.m1649$$Nest$fgetmAllowDownscale(config)).setFpsOverrideAllowed(GamePackageConfiguration.m1650$$Nest$fgetmAllowFpsOverride(config));
        int r5 = availableGameModes.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L17;
        int gameMode = availableGameModes[r6];
        if (config.willGamePerformOptimizations(gameMode) == true) goto L15;
        GamePackageConfiguration.GameModeConfiguration gameModeConfig = config.getGameModeConfiguration(gameMode);
        if (gameModeConfig == null) goto L15;
        gameModeInfoBuilder.setGameModeConfiguration(gameMode, gameModeConfig.toPublicGameModeConfig());
    L15:
        r6 = r6 + 1;
        goto L9
    L17:
        return gameModeInfoBuilder.build();
    L19:
        return new GameModeInfo.Builder().setActiveGameMode(activeGameMode).setAvailableGameModes(getAvailableGameModesUnchecked(packageName, userId2)).build();
    }

    public void setGameMode(String packageName, int gameMode, int userId) throws SecurityException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        if (gameMode != 0) goto L7;
        Slog.d(TAG, "No-op for attempt to set UNSUPPORTED mode for app: " + packageName);
        return;
    L7:
        if (isPackageGame(packageName, userId) == true) goto L10;
        Slog.d(TAG, "No-op for attempt to set game mode for non-game app: " + packageName);
        return;
    L10:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "setGameMode", "com.android.server.app.GameManagerService");     // Catch: Throwable -> L47
        if (this.mSettings.containsKey(Integer.valueOf(userId2)) == true) goto L22;
        Slog.d(TAG, "Failed to set game mode for package " + packageName + " as user " + userId2 + " is not started");     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L22:
        GameManagerSettings userSettings = this.mSettings.get(Integer.valueOf(userId2));     // Catch: Throwable -> L20
        int fromGameMode = userSettings.getGameModeLocked(packageName);     // Catch: Throwable -> L20
        userSettings.setGameModeLocked(packageName, gameMode);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        updateInterventions(packageName, gameMode, userId2);
        Object r3 = this.mGameModeListenerLock;
        monitor-enter(r3);
        Iterator<IGameModeListener> r2 = this.mGameModeListeners.keySet().iterator();     // Catch: Throwable -> L32
    L28:
        if (r2.hasNext() == false) goto L37;
        IGameModeListener listener = r2.next();     // Catch: Throwable -> L32
        Binder.allowBlocking(listener.asBinder());     // Catch: Throwable -> L32
        listener.onGameModeChanged(packageName, fromGameMode, gameMode, userId2);     // Catch: Throwable -> L32 RemoteException -> L34
    L35:
        Slog.w(TAG, "Cannot notify game mode change for listener added by " + this.mGameModeListeners.get(listener));     // Catch: Throwable -> L32
        goto L28
    L37:
        monitor-exit(r3);     // Catch: Throwable -> L32
        sendUserMessage(userId2, 1, EVENT_SET_GAME_MODE, 10000);
        sendUserMessage(userId2, 6, EVENT_SET_GAME_MODE, 0);
        int gameUid = -1;
        gameUid = this.mPackageManager.getPackageUidAsUser(packageName, userId2);     // Catch: PackageManager.NameNotFoundException -> L41
    L43:
        FrameworkStatsLog.write(FrameworkStatsLog.GAME_MODE_CHANGED, gameUid, Binder.getCallingUid(), gameModeToStatsdGameMode(fromGameMode), gameModeToStatsdGameMode(gameMode));
        return;
    L42:
        Slog.d(TAG, "Cannot find the UID for package " + packageName + " under user " + userId2);
    L32:
        th = move-exception;
        throw th;
    L47:
        th = th;
    L51:
        monitor-exit(r1);     // Catch: Throwable -> L20
        throw th;
    L49:
        th = th;
    L20:
        th = th;
        goto L51
    }

    public boolean isAngleEnabled(String packageName, int userId) throws SecurityException {
        int gameMode = getGameMode(packageName, userId);
        if (gameMode != 0) goto L5;
        return false;
    L5:
        Object r2 = this.mDeviceConfigLock;
        monitor-enter(r2);
        GamePackageConfiguration config = this.mConfigs.get(packageName);     // Catch: Throwable -> L11
        if (config != null) goto L13;
        monitor-exit(r2);     // Catch: Throwable -> L11
        return false;
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        GamePackageConfiguration.GameModeConfiguration gameModeConfiguration = config.getGameModeConfiguration(gameMode);
        if (gameModeConfiguration != null) goto L18;
        return false;
    L18:
        return gameModeConfiguration.getUseAngle();
    L11:
        th = move-exception;
        throw th;
    }

    public int getLoadingBoostDuration(String packageName, int userId) throws SecurityException {
        int gameMode = getGameMode(packageName, userId);
        if (gameMode != 0) goto L5;
        return -1;
    L5:
        Object r2 = this.mDeviceConfigLock;
        monitor-enter(r2);
        GamePackageConfiguration config = this.mConfigs.get(packageName);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        if (config != null) goto L11;
        return -1;
    L11:
        GamePackageConfiguration.GameModeConfiguration gameModeConfiguration = config.getGameModeConfiguration(gameMode);
        if (gameModeConfiguration != null) goto L15;
        return -1;
    L15:
        return gameModeConfiguration.getLoadingBoostDuration();
    L16:
        th = move-exception;
        throw th;
    }

    public void notifyGraphicsEnvironmentSetup(String packageName, int userId) throws SecurityException {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "notifyGraphicsEnvironmentSetup", "com.android.server.app.GameManagerService");
        if (isValidPackageName(packageName, userId2) == true) goto L6;
        Slog.d(TAG, "No-op for attempt to notify graphics env setup for different packagethan caller with uid: " + Binder.getCallingUid());
        return;
    L6:
        int gameMode = getGameMode(packageName, userId2);
        if (gameMode != 0) goto L10;
        Slog.d(TAG, "No-op for attempt to notify graphics env setup for non-game app: " + packageName);
        return;
    L10:
        int loadingBoostDuration = getLoadingBoostDuration(packageName, userId2);
        if (loadingBoostDuration == (-1)) goto L22;
        if (loadingBoostDuration != 0) goto L14;
    L15:
        loadingBoostDuration = 5000;
    L17:
        if (this.mHandler.hasMessages(5) == false) goto L19;
        this.mHandler.removeMessages(5);
    L20:
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(5), loadingBoostDuration);
        return;
    L19:
        Slog.v(TAG, "Game loading power mode ON (loading boost on game start)");
        this.mPowerManagerInternal.setPowerMode(16, true);
        goto L20
    L14:
        if (loadingBoostDuration <= 5000) goto L17;
    }

    public void setGameServiceProvider(String packageName) throws SecurityException {
        checkPermission("android.permission.SET_GAME_SERVICE");
        if (this.mGameServiceController != null) goto L5;
        return;
    L5:
        this.mGameServiceController.setGameServiceProvider(packageName);
    }

    public void updateResolutionScalingFactor(String packageName, int gameMode, float scalingFactor, int userId) throws SecurityException, IllegalArgumentException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        Throwable r9 = th;
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r9;
    L5:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L9
        setGameModeConfigOverride(packageName, userId, gameMode, null, Float.toString(scalingFactor));
        return;
    L13:
        throw new IllegalArgumentException("User " + userId + " wasn't started");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r9 = th;
        goto L16
    }

    public float getResolutionScalingFactor(String packageName, int gameMode, int userId) throws SecurityException, IllegalArgumentException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return getResolutionScalingFactorInternal(packageName, gameMode, userId);
    L12:
        throw new IllegalArgumentException("User " + userId + " wasn't started");     // Catch: Throwable -> L9
    }

    float getResolutionScalingFactorInternal(String packageName, int gameMode, int userId) {
        GamePackageConfiguration packageConfig = getConfig(packageName, userId);
        if (packageConfig != null) goto L5;
        return -1.0f;
    L5:
        GamePackageConfiguration.GameModeConfiguration modeConfig = packageConfig.getGameModeConfiguration(gameMode);
        if (modeConfig != null) goto L8;
        return -1.0f;
    L8:
        return modeConfig.getScaling();
    }

    public void updateCustomGameModeConfiguration(String packageName, GameModeConfiguration gameModeConfig, int userId) throws SecurityException, IllegalArgumentException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        if (isPackageGame(packageName, userId) == true) goto L6;
        Slog.d(TAG, "No-op for attempt to update custom game mode for non-game app: " + packageName);
        return;
    L6:
        Object r4 = this.mLock;
        monitor-enter(r4);
    L42:
        th = th;
    L43:
        monitor-exit(r4);     // Catch: Throwable -> L42
        throw th;
    L37:
        th = th;
        goto L43
    L9:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == false) goto L41;
        monitor-exit(r4);     // Catch: Throwable -> L37
        Object r5 = this.mLock;
        monitor-enter(r5);
    L17:
        th = th;
    L49:
        throw th;
    L35:
        th = th;
        goto L49
    L14:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L17
        return;
    L19:
        GameManagerSettings settings = this.mSettings.get(Integer.valueOf(userId));     // Catch: Throwable -> L17
        GamePackageConfiguration configOverride = settings.getConfigOverrideLocked(packageName);     // Catch: Throwable -> L17
        if (configOverride != null) goto L22;
        configOverride = new GamePackageConfiguration(packageName);     // Catch: Throwable -> L17
        settings.setConfigOverrideLocked(packageName, configOverride);     // Catch: Throwable -> L17
    L22:
        monitor-exit(r5);     // Catch: Throwable -> L17
        GamePackageConfiguration.GameModeConfiguration internalConfig = configOverride.getOrAddDefaultGameModeConfiguration(4);
        float scalingValueFrom = internalConfig.getScaling();
        int fpsValueFrom = internalConfig.getFps();
        internalConfig.updateFromPublicGameModeConfig(gameModeConfig);
        sendUserMessage(userId, 1, EVENT_UPDATE_CUSTOM_GAME_MODE_CONFIG, 10000);
        sendUserMessage(userId, 6, EVENT_UPDATE_CUSTOM_GAME_MODE_CONFIG, 10000);
        int gameMode = getGameMode(packageName, userId);
        if (gameMode != 4) goto L26;
        updateInterventions(packageName, gameMode, userId);
    L26:
        Slog.i(TAG, "Updated custom game mode config for package: " + packageName + " with FPS=" + internalConfig.getFps() + ";Scaling=" + internalConfig.getScaling() + " under user " + userId);
        int gameUid = -1;
        gameUid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L29
    L31:
        FrameworkStatsLog.write(FrameworkStatsLog.GAME_MODE_CONFIGURATION_CHANGED, gameUid, Binder.getCallingUid(), gameModeToStatsdGameMode(4), scalingValueFrom, gameModeConfig.getScalingFactor(), fpsValueFrom, gameModeConfig.getFpsOverride());
        return;
    L30:
        Slog.d(TAG, "Cannot find the UID for package " + packageName + " under user " + userId);
        goto L31
    L41:
        throw new IllegalArgumentException("User " + userId + " wasn't started");     // Catch: Throwable -> L42
    }

    public void addGameModeListener(final IGameModeListener listener) {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        final IBinder listenerBinder = listener.asBinder();     // Catch: RemoteException -> L11
        listenerBinder.linkToDeath(new AnonymousClass1(this, listener, listenerBinder), 0);     // Catch: RemoteException -> L11
        Object r1 = this.mGameModeListenerLock;     // Catch: RemoteException -> L11
        monitor-enter(r1);     // Catch: RemoteException -> L11
        this.mGameModeListeners.put(listener, Integer.valueOf(Binder.getCallingUid()));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
    L18:
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L11:
        ex = move-exception;
        Slog.e(TAG, "Failed to link death recipient for IGameModeListener from caller " + Binder.getCallingUid() + ", abandoned its listener registration", ex);
    }

    public void removeGameModeListener(IGameModeListener listener) {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        removeGameModeListenerUnchecked(listener);
    }

    private void removeGameModeListenerUnchecked(IGameModeListener listener) {
        Object r0 = this.mGameModeListenerLock;
        monitor-enter(r0);
        this.mGameModeListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addGameStateListener(final IGameStateListener listener) {
        final IBinder listenerBinder = listener.asBinder();     // Catch: RemoteException -> L10
        listenerBinder.linkToDeath(new AnonymousClass2(this, listener, listenerBinder), 0);     // Catch: RemoteException -> L10
        Object r1 = this.mGameStateListenerLock;     // Catch: RemoteException -> L10
        monitor-enter(r1);     // Catch: RemoteException -> L10
        this.mGameStateListeners.put(listener, Integer.valueOf(Binder.getCallingUid()));     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
    L16:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L10:
        ex = move-exception;
        Slog.e(TAG, "Failed to link death recipient for IGameStateListener from caller " + Binder.getCallingUid() + ", abandoned its listener registration", ex);
    }

    public void removeGameStateListener(IGameStateListener listener) {
        removeGameStateListenerUnchecked(listener);
    }

    private void removeGameStateListenerUnchecked(IGameStateListener listener) {
        Object r0 = this.mGameStateListenerLock;
        monitor-enter(r0);
        this.mGameStateListeners.remove(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onBootCompleted() {
        Slog.d(TAG, "onBootCompleted");
        if (this.mGameServiceController == null) goto L5;
        this.mGameServiceController.onBootComplete();
    L5:
        this.mContext.registerReceiver(new AnonymousClass3(this), new IntentFilter("android.intent.action.ACTION_SHUTDOWN"));
        Slog.v(TAG, "Game loading power mode OFF (game manager service start/restart)");
        this.mPowerManagerInternal.setPowerMode(16, false);
        Slog.v(TAG, "Game power mode OFF (game manager service start/restart)");
        this.mPowerManagerInternal.setPowerMode(15, false);
        this.mGameDefaultFrameRateValue = this.mSysProps.getInt(PROPERTY_RO_SURFACEFLINGER_GAME_DEFAULT_FRAME_RATE, 60);
        Slog.v(TAG, "Game Default Frame Rate : " + this.mGameDefaultFrameRateValue);
    }

    private void sendUserMessage(int userId, int what, String eventForLog, int delayMillis) {
        Message msg = this.mHandler.obtainMessage(what, Integer.valueOf(userId));
        if (this.mHandler.sendMessageDelayed(msg, delayMillis) == true) goto L6;
        Slog.e(TAG, "Failed to send user message " + what + " on " + eventForLog);
        return;
    }

    void onUserStarting(SystemService.TargetUser user, File settingDataDirOverride) {
        int userId = user.getUserIdentifier();
        if (settingDataDirOverride == null) goto L15;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L11;
        GameManagerSettings userSettings = new GameManagerSettings(settingDataDirOverride);     // Catch: Throwable -> L9
        this.mSettings.put(Integer.valueOf(userId), userSettings);     // Catch: Throwable -> L9
        userSettings.readPersistentDataLocked();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
    L15:
        sendUserMessage(userId, 3, EVENT_ON_USER_STARTING, 0);
        if (this.mGameServiceController == null) goto L21;
        this.mGameServiceController.notifyUserStarted(user);
        return;
    }

    void onUserUnlocking(SystemService.TargetUser user) {
        if (this.mGameServiceController == null) goto L6;
        this.mGameServiceController.notifyUserUnlocking(user);
        return;
    }

    void onUserStopping(SystemService.TargetUser user) {
        int userId = user.getUserIdentifier();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        sendUserMessage(userId, 2, EVENT_ON_USER_STOPPING, 0);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (this.mGameServiceController == null) goto L19;
        this.mGameServiceController.notifyUserStopped(user);
        return;
    }

    void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        int toUserId = to.getUserIdentifier();
        sendUserMessage(toUserId, 3, EVENT_ON_USER_SWITCHING, 0);
        if (this.mGameServiceController == null) goto L6;
        this.mGameServiceController.notifyNewForegroundUser(to);
        return;
    }

    private void resetFps(String packageName, int userId) {
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L5
        setGameModeFrameRateOverride(uid, 0.0f);     // Catch: PackageManager.NameNotFoundException -> L5
        return;
    }

    private static int modeToBitmask(int gameMode) {
        return 1 << gameMode;
    }

    private boolean bitFieldContainsModeBitmask(int bitField, int gameMode) {
        if ((modeToBitmask(gameMode) & bitField) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateUseAngle(String packageName, int gameMode) {
    }

    private void updateFps(GamePackageConfiguration packageConfig, String packageName, int gameMode, int userId) {
        GamePackageConfiguration.GameModeConfiguration modeConfig = packageConfig.getGameModeConfiguration(gameMode);
        if (modeConfig != null) goto L10;
        Slog.d(TAG, "Game mode " + gameMode + " not found for " + packageName);
        return;
    L10:
        float fps = modeConfig.getFps();     // Catch: PackageManager.NameNotFoundException -> L8
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L8
        setGameModeFrameRateOverride(uid, fps);     // Catch: PackageManager.NameNotFoundException -> L8
        return;
    }

    private void updateInterventions(String packageName, int gameMode, int userId) {
        GamePackageConfiguration packageConfig = getConfig(packageName, userId);
        if (gameMode == 1) goto L12;
        if (gameMode == 0) goto L12;
        if (packageConfig == null) goto L12;
        if (packageConfig.willGamePerformOptimizations(gameMode) == true) goto L12;
        if (packageConfig.getGameModeConfiguration(gameMode) == null) goto L12;
        updateFps(packageConfig, packageName, gameMode, userId);
    L16:
        updateUseAngle(packageName, gameMode);
        return;
    L12:
        resetFps(packageName, userId);
        if (packageConfig != null) goto L16;
        Slog.v(TAG, "Package configuration not found for " + packageName);
    }

    public void setGameModeConfigOverride(String packageName, int userId, int gameMode, String fpsStr, String scaling) throws SecurityException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        int gameUid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L5
        int gameUid2 = gameUid;
    L7:
        GamePackageConfiguration pkgConfig = getConfig(packageName, userId);
        if (pkgConfig != null) goto L10;
    L20:
        int r11 = Binder.getCallingUid();
        int r12 = gameModeToStatsdGameMode(gameMode);
        if (scaling != null) goto L23;
        float r14 = -1.0f;
    L25:
        if (fpsStr != null) goto L28;
        int r0 = 0;
    L29:
        FrameworkStatsLog.write(FrameworkStatsLog.GAME_MODE_CONFIGURATION_CHANGED, gameUid2, r11, r12, -1.0f, r14, 0, r0);
    L30:
        Object r7 = this.mLock;
        monitor-enter(r7);
    L36:
        th = move-exception;
        throw th;
    L33:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L38;
        monitor-exit(r7);     // Catch: Throwable -> L36
        return;
    L38:
        GameManagerSettings settings = this.mSettings.get(Integer.valueOf(userId));     // Catch: Throwable -> L36
        GamePackageConfiguration configOverride = settings.getConfigOverrideLocked(packageName);     // Catch: Throwable -> L36
        if (configOverride != null) goto L41;
        configOverride = new GamePackageConfiguration(packageName);     // Catch: Throwable -> L36
        settings.setConfigOverrideLocked(packageName, configOverride);     // Catch: Throwable -> L36
    L41:
        monitor-exit(r7);     // Catch: Throwable -> L36
        GamePackageConfiguration.GameModeConfiguration modeConfigOverride = configOverride.getOrAddDefaultGameModeConfiguration(gameMode);
        if (fpsStr == null) goto L45;
        modeConfigOverride.setFpsStr(fpsStr);
    L46:
        if (scaling == null) goto L48;
        modeConfigOverride.setScaling(Float.parseFloat(scaling));
    L48:
        Slog.i(TAG, "Package Name: " + packageName + " FPS: " + String.valueOf(modeConfigOverride.getFps()) + " Scaling: " + modeConfigOverride.getScaling());
        setGameMode(packageName, gameMode, userId);
        return;
    L45:
        modeConfigOverride.setFpsStr("");
        goto L46
    L28:
        r0 = Integer.parseInt(fpsStr);
        goto L29
    L23:
        r14 = Float.parseFloat(scaling);
        goto L25
    L10:
        if (pkgConfig.getGameModeConfiguration(gameMode) == null) goto L20;
        GamePackageConfiguration.GameModeConfiguration currentModeConfig = pkgConfig.getGameModeConfiguration(gameMode);
        int r13 = Binder.getCallingUid();
        int r15 = gameModeToStatsdGameMode(gameMode);
        float r16 = currentModeConfig.getScaling();
        if (scaling != null) goto L14;
        float r17 = currentModeConfig.getScaling();
    L15:
        int r18 = currentModeConfig.getFps();
        if (fpsStr != null) goto L18;
        int r19 = currentModeConfig.getFps();
    L19:
        FrameworkStatsLog.write(FrameworkStatsLog.GAME_MODE_CONFIGURATION_CHANGED, gameUid2, r13, r15, r16, r17, r18, r19);
        goto L30
    L18:
        r19 = Integer.parseInt(fpsStr);
        goto L19
    L14:
        r17 = Float.parseFloat(scaling);
    L6:
        Slog.d(TAG, "Cannot find the UID for package " + packageName + " under user " + userId);
        gameUid2 = -1;
        goto L7
    }

    public void resetGameModeConfigOverride(String packageName, int userId, int gameModeToReset) throws SecurityException {
        checkPermission("android.permission.MANAGE_GAME_MODE");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        GameManagerSettings settings = this.mSettings.get(Integer.valueOf(userId));     // Catch: Throwable -> L8
        if (gameModeToReset == (-1)) goto L24;
        GamePackageConfiguration configOverride = settings.getConfigOverrideLocked(packageName);     // Catch: Throwable -> L8
        if (configOverride != null) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L16:
        int modesBitfield = GamePackageConfiguration.m1651$$Nest$mgetAvailableGameModesBitfield(configOverride);     // Catch: Throwable -> L8
        if (bitFieldContainsModeBitmask(modesBitfield, gameModeToReset) == true) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L20:
        configOverride.removeModeConfig(gameModeToReset);     // Catch: Throwable -> L8
        if (configOverride.hasActiveGameModeConfig() == true) goto L25;
        settings.removeConfigOverrideLocked(packageName);     // Catch: Throwable -> L8
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L8
        int gameMode = getGameMode(packageName, userId);
        GamePackageConfiguration config = getConfig(packageName, userId);
        int newGameMode = getNewGameMode(gameMode, config);
        if (gameMode == newGameMode) goto L30;
        setGameMode(packageName, 1, userId);
        return;
    L30:
        setGameMode(packageName, gameMode, userId);
        return;
    L24:
        settings.removeConfigOverrideLocked(packageName);     // Catch: Throwable -> L8
        goto L25
    }

    private int getNewGameMode(int gameMode, GamePackageConfiguration config) {
        if (config == null) goto L8;
        int modesBitfield = GamePackageConfiguration.m1651$$Nest$mgetAvailableGameModesBitfield(config);
        if (bitFieldContainsModeBitmask(modesBitfield & (~modeToBitmask(0)), gameMode) == true) goto L11;
        return 1;
    L11:
        return gameMode;
    L8:
        return 1;
    }

    public String getInterventionList(String packageName, int userId) {
        checkPermission("android.permission.QUERY_ALL_PACKAGES");
        GamePackageConfiguration packageConfig = getConfig(packageName, userId);
        StringBuilder listStrSb = new StringBuilder();
        if (packageConfig != null) goto L6;
        listStrSb.append("\n No intervention found for package ");
        listStrSb.append(packageName);
        return listStrSb.toString();
    L6:
        listStrSb.append("\n");
        listStrSb.append(packageConfig.toString());
        return listStrSb.toString();
    }

    void updateConfigsForUser(final int userId, boolean checkGamePackage, String... packageNames) {
        if (checkGamePackage == false) goto L54;
        packageNames = (String[]) Arrays.stream(packageNames).filter(new GameManagerService$$ExternalSyntheticLambda3(this, userId)).toArray(new GameManagerService$$ExternalSyntheticLambda4());
    L54:
        Object r0 = this.mDeviceConfigLock;     // Catch: Exception -> L34
        monitor-enter(r0);     // Catch: Exception -> L34
        int r1 = packageNames.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L15;
        String packageName = packageNames[r3];     // Catch: Throwable -> L11
        GamePackageConfiguration config = new GamePackageConfiguration(this.mPackageManager, packageName, userId);     // Catch: Throwable -> L11
        if (config.isActive() == false) goto L13;
        Slog.v(TAG, "Adding config: " + config.toString());     // Catch: Throwable -> L11
        this.mConfigs.put(packageName, config);     // Catch: Throwable -> L11
    L14:
        r3 = r3 + 1;     // Catch: Throwable -> L11
        goto L7
    L13:
        Slog.v(TAG, "Inactive package config for " + config.getPackageName() + ":" + config.toString());     // Catch: Throwable -> L11
        this.mConfigs.remove(packageName);     // Catch: Throwable -> L11
        goto L14
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        Object r2 = this.mLock;     // Catch: Exception -> L34
        monitor-enter(r2);     // Catch: Exception -> L34
    L22:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L19:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == true) goto L24;
        monitor-exit(r2);     // Catch: Throwable -> L22
        return;
    L24:
        monitor-exit(r2);     // Catch: Throwable -> L22
        int r4 = packageNames.length;     // Catch: Exception -> L34
        int r5 = 0;
    L26:
        if (r5 >= r4) goto L41;
        String packageName2 = packageNames[r5];     // Catch: Exception -> L34
        int gameMode = getGameMode(packageName2, userId);     // Catch: Exception -> L34
        Object r6 = this.mDeviceConfigLock;     // Catch: Exception -> L34
        monitor-enter(r6);     // Catch: Exception -> L34
        GamePackageConfiguration config2 = this.mConfigs.get(packageName2);     // Catch: Throwable -> L38
        monitor-exit(r6);     // Catch: Throwable -> L38
        int newGameMode = getNewGameMode(gameMode, config2);     // Catch: Exception -> L34
        if (newGameMode == gameMode) goto L36;
        setGameMode(packageName2, newGameMode, userId);     // Catch: Exception -> L34
    L37:
        r5 = r5 + 1;
        goto L26
    L36:
        updateInterventions(packageName2, gameMode, userId);     // Catch: Exception -> L34
        goto L37
    L38:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L41:
        sendUserMessage(userId, 6, "UPDATE_CONFIGS_FOR_USERS", 0);     // Catch: Exception -> L34
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Slog.e(TAG, "Failed to update configs for user " + userId + ": " + e);
    }

    private /* synthetic */ boolean lambda$updateConfigsForUser$0(int userId, String p) {
        return isPackageGame(p, userId);
    }

    private static /* synthetic */ String[] lambda$updateConfigsForUser$1(int x$0) {
        return new String[x$0];
    }

    private void writeGameModeInterventionsToFile(int userId) {
        int r2 = userId;
        String r0 = ",";
        FileOutputStream fileOutputStream = null;
        fileOutputStream = this.mGameModeInterventionListFile.startWrite();     // Catch: Exception -> L20
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Charset.defaultCharset()));     // Catch: Exception -> L20
        StringBuilder sb = new StringBuilder();     // Catch: Exception -> L20
        List<String> installedGamesList = getInstalledGamePackageNamesByAllUsers(userId);     // Catch: Exception -> L20
        Iterator<String> r8 = installedGamesList.iterator();     // Catch: Exception -> L20
    L5:
        if (r8.hasNext() == false) goto L23;
        String packageName = r8.next();     // Catch: Exception -> L20
        GamePackageConfiguration packageConfig = getConfig(packageName, r2);     // Catch: Exception -> L20
        if (packageConfig == null) goto L5;
        sb.append(packageName);     // Catch: Exception -> L20
        sb.append("\t");     // Catch: Exception -> L20
        sb.append(this.mPackageManager.getPackageUidAsUser(packageName, r2));     // Catch: Exception -> L20
        sb.append("\t");     // Catch: Exception -> L20
        sb.append(getGameMode(packageName, r2));     // Catch: Exception -> L20
        sb.append("\t");     // Catch: Exception -> L20
        int[] modes = packageConfig.getAvailableGameModes();     // Catch: Exception -> L20
        int r12 = modes.length;     // Catch: Exception -> L20
        int r14 = 0;
    L10:
        if (r14 >= r12) goto L22;
        int mode = modes[r14];     // Catch: Exception -> L20
        GamePackageConfiguration.GameModeConfiguration gameModeConfiguration = packageConfig.getGameModeConfiguration(mode);     // Catch: Exception -> L20
        if (gameModeConfiguration == null) goto L19;
        sb.append(mode);     // Catch: Exception -> L20
        sb.append("\t");     // Catch: Exception -> L20
        if (gameModeConfiguration.getUseAngle() == false) goto L17;
        int useAngle = 1;
    L18:
        sb.append(TextUtils.formatSimple("angle=%d", new Object[]{Integer.valueOf(useAngle)}));     // Catch: Exception -> L20
        sb.append(r0);     // Catch: Exception -> L20
        float scaling = gameModeConfiguration.getScaling();     // Catch: Exception -> L20
        sb.append("scaling=");     // Catch: Exception -> L20
        sb.append(scaling);     // Catch: Exception -> L20
        sb.append(r0);     // Catch: Exception -> L20
        int fps = gameModeConfiguration.getFps();     // Catch: Exception -> L20
        sb.append(TextUtils.formatSimple("fps=%d", new Object[]{Integer.valueOf(fps)}));     // Catch: Exception -> L20
        sb.append("\t");     // Catch: Exception -> L20
        goto L19
    L17:
        useAngle = 0;
    L19:
        r14 = r14 + 1;     // Catch: Exception -> L20
        r0 = r0;
        goto L10
    L22:
        sb.append("\n");     // Catch: Exception -> L20
        r2 = userId;
        r0 = r0;
        goto L5
    L23:
        bufferedWriter.append(sb);     // Catch: Exception -> L20
        bufferedWriter.flush();     // Catch: Exception -> L20
        FileUtils.sync(fileOutputStream);     // Catch: Exception -> L20
        this.mGameModeInterventionListFile.finishWrite(fileOutputStream);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        this.mGameModeInterventionListFile.failWrite(fileOutputStream);
        Slog.wtf(TAG, "Failed to write game_mode_intervention.list, exception " + e);
    }

    private int[] getAllUserIds(int currentUserId) {
        List<UserInfo> users = this.mUserManager.getUsers();
        int[] userIds = new int[users.size()];
        int i = 0;
    L4:
        if (i >= userIds.length) goto L7;
        userIds[i] = users.get(i).id;
        i = i + 1;
        goto L4
    L7:
        if (currentUserId != (-1)) goto L9;
        return userIds;
    L9:
        return ArrayUtils.appendInt(userIds, currentUserId);
    }

    private String[] getInstalledGamePackageNames(int userId) {
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(0, userId);
        return (String[]) packages.stream().filter(new GameManagerService$$ExternalSyntheticLambda0()).map(new GameManagerService$$ExternalSyntheticLambda1()).toArray(new GameManagerService$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ boolean lambda$getInstalledGamePackageNames$2(PackageInfo e) {
        if (e.applicationInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (e.applicationInfo.category != 0) goto L7;
        return true;
    }

    private static /* synthetic */ String lambda$getInstalledGamePackageNames$3(PackageInfo e) {
        return e.packageName;
    }

    private static /* synthetic */ String[] lambda$getInstalledGamePackageNames$4(int x$0) {
        return new String[x$0];
    }

    private List<String> getInstalledGamePackageNamesByAllUsers(int currentUserId) {
        HashSet<String> packageSet = new HashSet();
        int[] userIds = getAllUserIds(currentUserId);
        int r2 = userIds.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L6;
        int userId = userIds[r3];
        packageSet.addAll(Arrays.asList(getInstalledGamePackageNames(userId)));
        r3 = r3 + 1;
        goto L3
    L6:
        return new ArrayList(packageSet);
    }

    public GamePackageConfiguration getConfig(String packageName, int userId) {
        GamePackageConfiguration overrideConfig = null;
        Object r1 = this.mDeviceConfigLock;
        monitor-enter(r1);
        GamePackageConfiguration config = this.mConfigs.get(packageName);     // Catch: Throwable -> L25
        monitor-exit(r1);     // Catch: Throwable -> L25
        Object r3 = this.mLock;
        monitor-enter(r3);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mSettings.containsKey(Integer.valueOf(userId)) == false) goto L13;
        overrideConfig = this.mSettings.get(Integer.valueOf(userId)).getConfigOverrideLocked(packageName);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r3);     // Catch: Throwable -> L11
        if (overrideConfig == null) goto L19;
        if (config == null) goto L19;
        return config.copyAndApplyOverride(overrideConfig);
    L19:
        if (overrideConfig != null) goto L22;
        return config;
    L22:
        return overrideConfig;
    L25:
        th = move-exception;
        throw th;
    }

    private void registerPackageReceiver() {
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.addDataScheme(Settings.ATTR_PACKAGE);
        BroadcastReceiver packageReceiver = new AnonymousClass4(this);
        this.mContext.registerReceiverForAllUsers(packageReceiver, packageFilter, null, null);
    }

    private void registerDeviceConfigListener() {
        this.mDeviceConfigListener = new DeviceConfigListener(this);
    }

    private void publishLocalService() {
        LocalService localService = new LocalService(this, null);
        ActivityTaskManagerInternal atmi = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        atmi.registerCompatScaleProvider(1, localService);
        LocalServices.addService(GameManagerInternal.class, localService);
    }

    private void registerStatsCallbacks() {
        StatsManager statsManager = (StatsManager) this.mContext.getSystemService(StatsManager.class);
        statsManager.setPullAtomCallback(FrameworkStatsLog.GAME_MODE_INFO, null, ConcurrentUtils.DIRECT_EXECUTOR, new GameManagerService$$ExternalSyntheticLambda5(this));
        statsManager.setPullAtomCallback(FrameworkStatsLog.GAME_MODE_CONFIGURATION, null, ConcurrentUtils.DIRECT_EXECUTOR, new GameManagerService$$ExternalSyntheticLambda5(this));
        statsManager.setPullAtomCallback(FrameworkStatsLog.GAME_MODE_LISTENER, null, ConcurrentUtils.DIRECT_EXECUTOR, new GameManagerService$$ExternalSyntheticLambda5(this));
    }

    private int onPullAtom(int atomTag, List<StatsEvent> data) {
        int r6 = FrameworkStatsLog.GAME_MODE_INFO;
        if (atomTag == 10165) goto L17;
        if (atomTag == 10166) goto L17;
        if (atomTag != 10167) goto L16;
        Object r5 = this.mGameModeListenerLock;
        monitor-enter(r5);
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.GAME_MODE_LISTENER, this.mGameModeListeners.size()));     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return 0;
    L13:
        th = move-exception;
        throw th;
    L16:
        return 0;
    L17:
        int userId = ActivityManager.getCurrentUser();
        Object r8 = this.mDeviceConfigLock;
        monitor-enter(r8);
        Set<String> packages = this.mConfigs.keySet();     // Catch: Throwable -> L47
        monitor-exit(r8);     // Catch: Throwable -> L47
        Iterator<String> r9 = packages.iterator();
    L23:
        if (r9.hasNext() == false) goto L45;
        String p = r9.next();
        GamePackageConfiguration config = getConfig(p, userId);
        if (config == null) goto L23;
        int uid = -1;
        uid = this.mPackageManager.getPackageUidAsUser(p, userId);     // Catch: PackageManager.NameNotFoundException -> L30
    L32:
        if (atomTag != r6) goto L34;
        data.add(FrameworkStatsLog.buildStatsEvent(r6, uid, gameModesToStatsdGameModes(config.getOverriddenGameModes()), gameModesToStatsdGameModes(config.getAvailableGameModes())));
    L44:
        r6 = FrameworkStatsLog.GAME_MODE_INFO;
        goto L23
    L34:
        if (atomTag != 10166) goto L44;
        int[] r0 = config.getAvailableGameModes();
        int r13 = r0.length;
        int r14 = 0;
    L36:
        if (r14 >= r13) goto L44;
        int gameMode = r0[r14];
        GamePackageConfiguration.GameModeConfiguration modeConfig = config.getGameModeConfiguration(gameMode);
        if (modeConfig == null) goto L41;
        data.add(FrameworkStatsLog.buildStatsEvent(FrameworkStatsLog.GAME_MODE_CONFIGURATION, uid, gameModeToStatsdGameMode(gameMode), modeConfig.getFps(), modeConfig.getScaling()));
    L41:
        r14 = r14 + 1;
        r0 = r0;
    L31:
        Slog.d(TAG, "Cannot find UID for package " + p + " under user handle id " + userId);
        goto L32
    L45:
        return 0;
    L47:
        th = move-exception;
        throw th;
    }

    private static int[] gameModesToStatsdGameModes(int[] modes) {
        if (modes != null) goto L5;
        return null;
    L5:
        int[] statsdModes = new int[modes.length];
        int i = 0;
        int r2 = modes.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        int mode = modes[r3];
        statsdModes[i] = gameModeToStatsdGameMode(mode);
        r3 = r3 + 1;
        i = i + 1;
        goto L6
    L8:
        return statsdModes;
    }

    private static int gameModeToStatsdGameMode(int mode) {
        switch(mode) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 1;
    }

    private static int gameStateModeToStatsdGameState(int mode) {
        switch(mode) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 2;
    L11:
        return 1;
    }

    private static ServiceThread createServiceThread() {
        ServiceThread handlerThread = new ServiceThread(TAG, 10, true);
        handlerThread.start();
        return handlerThread;
    }

    void setGameModeFrameRateOverride(int uid, float frameRate) {
        nativeSetGameModeFrameRateOverride(uid, frameRate);
    }

    void setGameDefaultFrameRateOverride(int uid, float frameRate) {
        Slog.v(TAG, "setDefaultFrameRateOverride : " + uid + " , " + frameRate);
        nativeSetGameDefaultFrameRateOverride(uid, frameRate);
    }

    private float getGameDefaultFrameRate(boolean isEnabled) {
        if (isEnabled == false) goto L5;
        float gameDefaultFrameRate = this.mGameDefaultFrameRateValue;
        return gameDefaultFrameRate;
    L5:
        return 0.0f;
    }

    public void toggleGameDefaultFrameRate(boolean isEnabled) {
        toggleGameDefaultFrameRate_enforcePermission();
        Slog.v(TAG, "toggleGameDefaultFrameRate : " + isEnabled);
        toggleGameDefaultFrameRateUnchecked(isEnabled);
    }

    private void toggleGameDefaultFrameRateUnchecked(boolean isEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (isEnabled == false) goto L8;
        this.mSysProps.set(PROPERTY_DEBUG_GFX_GAME_DEFAULT_FRAME_RATE_DISABLED, "false");     // Catch: Throwable -> L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L6
        Object r1 = this.mUidObserverLock;
        monitor-enter(r1);
        Iterator<Integer> r2 = this.mGameForegroundUids.iterator();     // Catch: Throwable -> L16
    L14:
        if (r2.hasNext() == false) goto L18;
        int uid = r2.next().intValue();     // Catch: Throwable -> L16
        setGameDefaultFrameRateOverride(uid, getGameDefaultFrameRate(isEnabled));     // Catch: Throwable -> L16
        goto L14
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L8:
        this.mSysProps.set(PROPERTY_DEBUG_GFX_GAME_DEFAULT_FRAME_RATE_DISABLED, "true");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
