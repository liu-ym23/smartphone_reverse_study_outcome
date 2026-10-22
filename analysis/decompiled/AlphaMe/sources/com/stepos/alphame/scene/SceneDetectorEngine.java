package com.stepos.alphame.scene;

import B0.g;
import a.C0152a;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.AlphaMeServer;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.EngineContract;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.RuleUpdater;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.awareness.AwarenessStorable;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.request.RequestManager;
import com.stepos.alphame.request.ResponseListener;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.userbehavior.UserBehaviorDataSource;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.AppUtils;
import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.DeviceInfoKt;
import com.stepos.alphame.utils.LocalConsts;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.RangeArrayList;
import com.stepos.alphame.utils.ServerDumper;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.alphame.utils.UsageStatsUtils;
import com.stepos.alphame.utils.Utils;
import com.stepos.common.alphame.b;
import com.stepos.common.alphame.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s.AbstractC0831a;
import t0.J;

/* loaded from: classes.dex */
public class SceneDetectorEngine extends EngineBase implements QuickAppHelper.QuickAppListener {
    private static final String AUTO_LAUNCHER_CLS_NAME = "com.stepos.auto.launcherflow";
    private static final String BAIDU_MINI_APP_ACTIVITY = "com.baidu.searchbox.lightbrowser.ImmerseBrowserActivity";
    private static final String BAIDU_MINI_APP_BASE_URL = "https://mbd.baidu.com/matrixgame/gameapp";
    private static final String CAR_LAUNCHER_CLS_NAME = "com.stepos.carlauncher.CarLauncher";
    private static final int DETECT_STATE_CREATE = 0;
    private static final int DETECT_STATE_NONE_PAGE = 4;
    private static final int DETECT_STATE_QUICK_PAUSE = 2;
    private static final int DETECT_STATE_RESUME = 1;
    private static final int DETECT_STATE_RRE_PAGE = 3;
    private static final int DETECT_STATE_SCREEN_OFF = 5;
    private static final String DOUYIN_MINI_APP_ACTIVITY = "com.minigame.merge.miniapphost.placeholder";
    private static final String EXTRA_ACTIVITY_INTENT = "picker.activity.intent";
    private static final String EXTRA_ACTIVITY_NAME = "picker.activity.name";
    private static final int GAME_DISABLE = 3;
    private static final String GAME_NAME = "game";
    private static final int GAME_VALUE_NORMAL = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_OFFSET = 2;
    private static final int INDEX_TAG = 0;
    private static final String KEY_CUSTOM_DISABLE_LIST = "custom_disable_game_set";
    private static final String KEY_CUSTOM_ENABLE_LIST = "custom_enable_game_set";
    private static final long MIN_GAME_DURATION = 10000;
    private static final int MSG_APP_DIED = 3;
    private static final int MSG_APP_EVENT = 2;
    private static final int MSG_APP_RESUME_LONG_TIME = 6;
    private static final int MSG_CHECK_SCREEN_OFF = 5;
    private static final int MSG_DETECT_SCENE = 1;
    private static final int MSG_SCREEN_EVENT = 4;
    private static final String MZ_GAME_MODE = "stepos_game_mode";
    private static final String NORMAL_NAME = "normal";
    private static final String ONEMIND_TEST_PKG = "com.stepos.boweitest";
    private static final int PERMISSION_ID_GAME = 10;
    private static final int PID_NAVI = 33;
    public static final int PVALUE_LAUNCHER = 2;
    private static final int PVALUE_NOT_FOUND = -1;
    public static final int PVALUE_SCREEN_LOCKED = 1;
    public static final int PVALUE_SCREEN_OFF = 0;
    private static final int PVALUE_TRUE = 1;
    private static final int SCENE_GAME = 1;
    private static final int SCENE_MINI_GAME = 3;
    private static final int SCENE_NORMAL = 0;
    private static final int SCENE_QUICK_GAME = 2;
    public static final String SCREEN_LOCKED = "screen_locked";
    public static final String SCREEN_OFF = "screen_off";
    private static final String STATE_CREATE = "create";
    private static final String STATE_RESUME = "resume";
    private static final String STATE_SCREEN_OFF = "screen_off";
    private static final String TAG_ACTIVITY = "activity";
    private static final String TAG_NAME = "name";
    private static final String TAG_PKG = "pkg";
    private static final int TIMEOUT_CHECK_SCREEN_OFF = 2500;
    private static final int TIMEOUT_DETECT_DELAY_PAGE = 500;
    private static final int TIMEOUT_DETECT_HOME_PAGE = 10;
    private static final int TIMEOUT_DETECT_NEW_PAGE = 0;
    private static final int TIMEOUT_DETECT_NONE_PAGE = 3000;
    private static final int TIMEOUT_DETECT_PRE_PAGE = 100;
    private static final int TIMEOUT_RESUME_HOME_LONG_TIME = 300;
    private static final int TIMEOUT_RESUME_LONG_TIME = 3000;
    private static final String TOUTIAO_MINI_APP_ACTIVITY = "com.minigame.miniapphost.placeholder";
    private static final String TYPE_SCREENSHOT = "screenshot";
    private static final String TYPE_SHARE = "share";
    private static final String WORD_MATCH_SPLITTER = "^";
    private static SceneDetectorEngine sInstance;
    private AppInstallReceiver mAppInstallReceiver;
    private String mCurrActivity;
    private String mCurrApp;
    private Set<String> mCustomDisabledPackages;
    private Set<String> mCustomEnabledPackages;
    private Handler mHandler;
    private MiniAppInfo mLastMiniAppInfo;
    private QuickAppInfo mLastQuickAppInfo;
    private QuickAppHelper mQuickAppHelper;
    private ContentResolver mResolver;
    private static final Boolean ENABLE_DETECT_NONE_PAGE = Boolean.FALSE;
    private static final SceneItem SCENE_ITEM_GAME_ONLY = new SceneItem(true);
    private static final SceneItem SCENE_ITEM_NORMAL = new SceneItem(false);
    private static final Uri URI_APP = Uri.parse("content://com.stepos.alphame.sceneupdate.provider/apps");
    private static final Uri URI_ACTIVITY = Uri.parse("content://com.stepos.alphame.sceneupdate.provider/activities");
    private static final Uri URI_EXTRA = Uri.parse("content://com.stepos.alphame.sceneupdate.provider/extra_list");
    private static final Uri URI_UNBOUNDED = Uri.parse("content://com.stepos.alphame.sceneupdate.provider/unbounded_apps");
    private static final HashMap<String, SceneItem> PKG_CACHE = new HashMap<>(128);
    private static final HashMap<String, SceneItem> ACTIVITY_CACHE = new HashMap<>(256);
    private static final HashMap<String, String> MINI_APP_CACHE = new HashMap<>(64);
    private static final List<MiniAppActivityConfig> MINI_APP_CONFIGS = Arrays.asList(new MiniAppActivityConfig("weixin", "com.tencent.mm.plugin.appbrand.ui.AppBrandUI"), new MiniAppActivityConfig("qq", "com.tencent.mobileqq.minigame"), new MiniAppActivityConfig("toutiao", "com.tt.miniapphost.placeholder.MiniappTabActivity"), new MiniAppActivityConfig("baidu", "com.baidu.swan.apps.SwanAppActivity"));
    private static final List<String> DELAY_RESUME_PKGS = Arrays.asList("com.android.permissioncontroller");
    private static final List<String> DELAY_RESUME_ACTS = Arrays.asList("com.stepos.networkmanager.TipActivity", "com.android.server.telecom.components.UserCallActivity");
    private static final String[] MINI_APP_UPLOAD_BLACKLIST = {"1108291530"};
    public static Integer APP_TYPE_GAME = 10;
    public static Integer APP_TYPE_FINANCE = 11;
    private int mLastScene = 0;
    private String mLastScenePackage = "";
    private String mLastSceneActivity = "";
    private long mLastSceneTimeMill = System.currentTimeMillis();
    private boolean mStartUploadMiniGame = false;
    private RangeArrayList<AppRecord> mResumedApps = new RangeArrayList<>();
    private List<ActivityBean> mCollectActivities = new ArrayList();
    private boolean mMultiState = false;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.stepos.alphame.scene.SceneDetectorEngine.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            if (intent.getAction() == "android.intent.action.ACTION_SHUTDOWN" || intent.getAction() == "android.intent.action.REBOOT") {
                Property.setInt(Property.KEY_SCENE_MODE, 0);
            }
        }
    };
    private final b mEventReceiver = new b() { // from class: com.stepos.alphame.scene.SceneDetectorEngine.3
        @Override // com.stepos.common.alphame.b
        public void onReceiver(String str, Object obj) {
            str.getClass();
            switch (str) {
                case "APP_EVENT":
                    Message.obtain(SceneDetectorEngine.this.getHandler(), 2, obj).sendToTarget();
                    break;
                case "SCREEN_EVENT":
                    Message.obtain(SceneDetectorEngine.this.getHandler(), 4, obj).sendToTarget();
                    break;
                case "APP_DIED":
                    Message.obtain(SceneDetectorEngine.this.getHandler(), 3, obj).sendToTarget();
                    break;
            }
        }
    };

    public static class ActivityBean {
        String activity;
        String name;
        String pkg;

        public ActivityBean(JSONObject jSONObject) throws JSONException {
            this.activity = jSONObject.getString("activity");
            this.name = jSONObject.getString("name");
            this.pkg = jSONObject.getString(SceneDetectorEngine.TAG_PKG);
        }
    }

    public static class AppRecord {
        String activityName;
        int pid;
        String pkgName;
        String userId;

        public AppRecord(String str, String str2, int i4, String str3) {
            this.pkgName = str;
            this.activityName = str2;
            this.pid = i4;
            this.userId = str3;
        }
    }

    public static class DetectActivityScene extends EngineFunc {
        public DetectActivityScene(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_ACTIVITY_SCENE;
            this.isPublic = true;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{AwarenessStorable.COLUMN_SCENE};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"根据id查询当前activity属性", "@author lxh", "@param permissionID 指定场景，在服务端配置", "@return '-1为找不到，其它为服务端配置"};
        }
    }

    public static class DetectActivitySceneAll extends EngineFunc {
        public DetectActivitySceneAll(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_ACTIVITY_SCENE_ALL;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{AwarenessStorable.COLUMN_SCENE};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"查询当前activity属性", "@author lxh", "@return '17,23,25(permissionIds) 1,1,1(permissionValues)'"};
        }
    }

    public static class DetectActivitySceneByActivity extends EngineFunc {
        public DetectActivitySceneByActivity(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_DETECT_ACTIVITY_SCENE_BY_ACTIVITY;
            this.isPublic = true;
            this.argsType = new byte[]{4, 6};
            this.argsName = new String[]{AwarenessStorable.COLUMN_SCENE, "activity"};
            this.returnType = (byte) 4;
            this.annotation = new String[]{"根据id查询传入activity属性", "@author lxh", "@param permissionID 指定场景，在服务端配置, curActivity 指定acitivity", "@return '-1为找不到，其它为服务端配置"};
        }
    }

    public static class EnterDebugScene extends EngineFunc {
        public EnterDebugScene(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_ENTER_DEBUG_SCENE;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"进入调试场景，使Awareness的dump命令生效", "@author lxh"};
        }
    }

    public static class GetAllUnboundedPackages extends EngineFunc {
        public GetAllUnboundedPackages(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_ALL_UNBOUNDED_PACKAGES;
            this.argsType = new byte[]{4};
            this.argsName = new String[]{"type"};
            this.returnType = (byte) 9;
            this.annotation = new String[]{"根据类型获取其全部白名单，使用范围：无界桌面", "@param type 名单类型, 0: P档白名单  1: 平行视窗白名单  2: 非平行视窗白名单", "@param packageNameArray 指定的包名数组", "@return 字符串数组，元素值为白名单中全部包名", "@author lyl"};
        }
    }

    public static class GetAppBlackListForUserGeneratedContent extends EngineFunc {
        public GetAppBlackListForUserGeneratedContent(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_APP_BLACK_LIST_FOR_USER_GENERATE_CONTENT;
            this.argsType = new byte[]{9};
            this.argsName = new String[]{"packageNameList"};
            this.isPublic = true;
            this.returnType = (byte) 10;
            this.annotation = new String[]{"获取UGC应用黑名单结果", "@author 梁英杰", "@return 整形数组，元素值为1代表金融类或者游戏类，0代表不是金融类或者游戏类"};
        }
    }

    public static class GetAppInfo extends EngineFunc {
        public GetAppInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_APP_INFO;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME};
            this.isPublic = true;
            this.returnType = (byte) 9;
            this.annotation = new String[]{"根据包名获取应用的permissionId和permissionValue", "@author lxh", "@return [permissionIds.toString(),permissionValues.toString()]"};
        }
    }

    public static class GetCdnInfo extends EngineFunc {
        public GetCdnInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_CDN_INFO;
            this.isPublic = true;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"tag"};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"根据tag获取CDN打包里的信息", "@author lxh", "@return CDN打包里的信息"};
        }
    }

    public static class GetCurrentScene extends EngineFunc {
        public GetCurrentScene(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_CURRENT_SCENE;
            this.isPublic = true;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.annotation = new String[]{"获取当前应用场景", "@author lxh", "@return '17,23,25(permissionIds) 1,1,1(permissionValues)'"};
        }
    }

    public static class GetGameType extends EngineFunc {
        public GetGameType(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_GET_GAME_TYPE;
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.isPublic = true;
            this.annotation = new String[]{"获取当前游戏场景的类型。normal:非游戏，game_app:普通应用类游戏，game_quick_app:快应用类游戏，game_mini_xxx:小程序游戏（xxx可以为：weixin、QQ、toutiao、baidu）", "@author huangzuoyong"};
        }
    }

    public static class IsGame extends EngineFunc {
        public IsGame(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_IS_GAME;
            this.isPublic = true;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"根据应用包名，判断是否游戏", "@author lxh"};
        }
    }

    public static class IsGamePackages extends EngineFunc {
        public IsGamePackages(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_IS_GAME_PACKAGES;
            this.argsType = new byte[]{9};
            this.argsName = new String[]{"packageNameArray"};
            this.returnType = (byte) 8;
            this.annotation = new String[]{"批量查询一些应用的游戏模式。", "@return 数组元素值为1代表游戏，0代表非游戏。", "@author zuoyong"};
        }
    }

    public static class IsMiniGame extends EngineFunc {
        public IsMiniGame(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_IS_MINI_GAME;
            this.isPublic = true;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{"wxAppId"};
            this.returnType = (byte) 2;
            this.annotation = new String[]{"根据小程序app id，判断是否微信或QQ小游戏程序", "@author lxh"};
        }
    }

    public static class IsUnboundedPackages extends EngineFunc {
        public IsUnboundedPackages(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_IS_UNBOUNDED_PACKAGES;
            this.argsType = new byte[]{4, 9};
            this.argsName = new String[]{"type", "packageNameArray"};
            this.returnType = (byte) 10;
            this.annotation = new String[]{"根据类型获取某些包名的白名单结果，使用范围：无界桌面", "@param type 名单类型, 0: P档白名单 1: 平行视窗白名单 2: 非平行视窗白名单", "@param packageNameArray 指定的包名数组", "@return 整形数组，元素值为1代表在白名单，0或-1代表不在白名单", "@author lyl"};
        }
    }

    public static class MiniAppActivityConfig {
        static final String MINI_APP_BAIDU = "baidu";
        static final String MINI_APP_QQ = "qq";
        static final String MINI_APP_TOUTIAO = "toutiao";
        static final String MINI_APP_WX = "weixin";
        String activity;
        String type;

        public MiniAppActivityConfig(String str, String str2) {
            this.type = str;
            this.activity = str2;
        }
    }

    public static class MiniAppInfo {
        String app_id;
        String app_name;
        int is_game;
        long start_time = SystemClock.elapsedRealtime();
        String type;

        public MiniAppInfo(String str, String str2, String str3, int i4) {
            this.type = str;
            this.app_name = str2;
            this.app_id = str3;
            this.is_game = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MiniAppInfo miniAppInfo = (MiniAppInfo) obj;
            return this.is_game == miniAppInfo.is_game && Objects.equals(this.type, miniAppInfo.type) && Objects.equals(this.app_name, miniAppInfo.app_name) && Objects.equals(this.app_id, miniAppInfo.app_id);
        }

        public int hashCode() {
            return Objects.hash(this.type, this.app_name, this.app_id, Integer.valueOf(this.is_game));
        }

        public String toString() {
            return "MiniAppInfo app_id=" + this.app_id + ", app_name=" + this.app_name + ", type=" + this.type + ", is_game=" + this.is_game;
        }
    }

    public static class QuickAppInfo {
        String fakePkg;
        boolean isGame;
        String name;
        String pkg;

        public QuickAppInfo(String str, String str2, String str3, boolean z4) {
            this.fakePkg = str;
            this.pkg = str2;
            this.name = str3;
            this.isGame = z4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            QuickAppInfo quickAppInfo = (QuickAppInfo) obj;
            return this.isGame == quickAppInfo.isGame && Objects.equals(this.fakePkg, quickAppInfo.fakePkg) && Objects.equals(this.pkg, quickAppInfo.pkg) && Objects.equals(this.name, quickAppInfo.name);
        }

        public int hashCode() {
            return Objects.hash(this.fakePkg, this.pkg, this.name, Boolean.valueOf(this.isGame));
        }
    }

    public static class Scene extends EngineFunc {
        public Scene(EngineBase engineBase) {
            super(engineBase);
            this.name = "getScene";
            this.argsType = new byte[]{0};
            this.argsName = new String[]{""};
            this.returnType = (byte) 6;
            this.isPublic = true;
            this.annotation = new String[]{"获取当前场景", "@author zhuhequan", "@return 当前场景名字"};
        }
    }

    public static class SetAllPackagesCustomGameMode extends EngineFunc {
        public SetAllPackagesCustomGameMode(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_SET_ALL_PACKAGES_CUSTOM_GAME_MODE;
            this.argsType = new byte[]{9, 9};
            this.argsName = new String[]{"enabledPackageArray", "disabledPackageArray"};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"批量定制所有应用的游戏模式。调用以后会替换掉之前的定制名单。", "@author zuoyong"};
        }
    }

    public static class SetBroadcastExactlyGameInfo extends EngineFunc {
        public SetBroadcastExactlyGameInfo(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_SET_BROADCAST_EXACTLY_GAME_INFO;
            this.argsType = new byte[]{2};
            this.argsName = new String[]{"exactly"};
            this.returnType = (byte) 0;
            this.isPublic = false;
            this.annotation = new String[]{"接收游戏模式广播时，是否需要更精准的游戏信息, 默认为false。设置为False时，只有场景类型变化了才会有广播，但不保证游戏信息的正确。设置为True时，场景类型变化和游戏信息变化时都会收到游戏模式广播，以保证游戏信息正确。", "@author huangzuoyong"};
        }
    }

    public static class SetCustomGameModeForPackage extends EngineFunc {
        public SetCustomGameModeForPackage(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_SET_CUSTOM_GAME_MODE_FOR_PACKAGE;
            this.argsType = new byte[]{6, 2};
            this.argsName = new String[]{AppInfoDbHelper.TAG_U_PACKAGE_NAME, LocalConsts.FUNC_IS_GAME};
            this.returnType = (byte) 0;
            this.annotation = new String[]{"定制单个应用的游戏模式。仅设置该应用的游戏模式，其它应用不受影响。", "@author zuoyong"};
        }
    }

    public static class TopActivityInfo {
        String activity;
        Intent intent;

        public TopActivityInfo(String str, Intent intent) {
            this.activity = str;
            this.intent = intent;
        }
    }

    public static class WordMatch extends EngineFunc {
        public WordMatch(EngineBase engineBase) {
            super(engineBase);
            this.name = LocalConsts.FUNC_WORD_MATCH;
            this.argsType = new byte[]{6};
            this.argsName = new String[]{""};
            this.returnType = (byte) 12;
            this.annotation = new String[]{"文本分词", "@author lxh", "@param 类型String, 要进行分词的文本", "@return 分词结果的StringList，每个结果里面包含tag,具体string,识别匹配串的首尾偏移量，用空格隔开"};
        }
    }

    private SceneDetectorEngine() {
        sInstance = this;
        this.mQuickAppHelper = QuickAppHelper.getInstance();
        this.mCustomEnabledPackages = Property.getStringSet(KEY_CUSTOM_ENABLE_LIST, new HashSet());
        this.mCustomDisabledPackages = Property.getStringSet(KEY_CUSTOM_DISABLE_LIST, new HashSet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void changeScene(int i4, String str, String str2, String str3, int i5, MiniAppInfo miniAppInfo, QuickAppInfo quickAppInfo, int i6) {
        String strR;
        String str4;
        int i7;
        StringBuilder sb = new StringBuilder("changeScene currentScene ");
        int i8 = i4;
        sb.append(i8);
        sb.append(" pkgName ");
        sb.append(str);
        sb.append(" activity ");
        sb.append(str2);
        sb.append(" permissionValue ");
        sb.append(i5);
        sb.append(" miniAppInfo ");
        sb.append(miniAppInfo);
        sb.append(" quickAppInfo ");
        sb.append(quickAppInfo);
        sb.append(" state ");
        sb.append(i6);
        AlphaMeLogger.debugLog(EngineContract.GAME_MODE, sb.toString());
        boolean z4 = CAR_LAUNCHER_CLS_NAME.equals(str2) || AUTO_LAUNCHER_CLS_NAME.equals(str);
        if (z4) {
            return;
        }
        if (this.mMultiState) {
            i8 = 0;
        }
        String str5 = this.mLastScenePackage;
        String str6 = this.mLastSceneActivity;
        long j4 = this.mLastSceneTimeMill;
        int i9 = this.mLastScene;
        MiniAppInfo miniAppInfo2 = this.mLastMiniAppInfo;
        QuickAppInfo quickAppInfo2 = this.mLastQuickAppInfo;
        boolean z5 = z4;
        AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "lastValue lastScene " + this.mLastScene + " lastPkgName " + this.mLastScenePackage + " lastActivity " + this.mLastSceneActivity + " lastPermissionValue " + i5 + " lastMiniAppInfo " + this.mLastMiniAppInfo + " lastQuickAppInfo " + this.mLastQuickAppInfo);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mLastScenePackage = str;
        this.mLastSceneActivity = str2;
        this.mLastSceneTimeMill = jCurrentTimeMillis;
        this.mLastScene = i8;
        this.mLastMiniAppInfo = miniAppInfo;
        this.mLastQuickAppInfo = quickAppInfo;
        boolean z6 = i9 != i8 ? 1 : 0;
        boolean z7 = isGameScene(i8) && !(TextUtils.equals(str5, str) && ((miniAppInfo == null || Objects.equals(miniAppInfo2, miniAppInfo)) && (quickAppInfo == null || Objects.equals(quickAppInfo2, quickAppInfo))));
        boolean z8 = (miniAppInfo2 == null || miniAppInfo2.equals(miniAppInfo)) ? false : true;
        if (z6 != 0) {
            Property.setInt(Property.KEY_SCENE_MODE, i8);
        }
        if (z8) {
            staticsMiniAppUsage(miniAppInfo2);
            AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "mini_app_record, " + miniAppInfo2);
        }
        if (i9 != 0 && i8 == 0) {
            HashMap map = new HashMap();
            long j5 = jCurrentTimeMillis - j4;
            if (j5 > 10000) {
                map.put("duration", String.valueOf(j5));
                map.put("game_pkg", str5);
                UsageStatsUtils.onEvent("game_mode_record", null, map);
                AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "onEvent game_mode_record " + str5 + ", " + StringUtil.formatTimeMill(j5));
            } else {
                StringBuilder sbW = g.w("onEvent game_mode_record canceled ", str5, ", ");
                sbW.append(StringUtil.formatTimeMill(j5));
                AlphaMeLogger.debugLog(EngineContract.GAME_MODE, sbW.toString());
            }
        }
        if ((z6 != 0 || z7) && !z5) {
            if (miniAppInfo != null && miniAppInfo.is_game == 1) {
                String gamedMiniAppName = TextUtils.isEmpty(miniAppInfo.app_name) ? getGamedMiniAppName(miniAppInfo.app_id) : miniAppInfo.app_name;
                StringBuilder sb2 = new StringBuilder();
                AbstractC0351g.C(sb2, miniAppInfo.app_id, ",", gamedMiniAppName, ",");
                sb2.append(miniAppInfo.type);
                strR = sb2.toString();
            } else if (quickAppInfo == null || !quickAppInfo.isGame) {
                strR = "";
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(quickAppInfo.pkg);
                sb3.append(",");
                strR = g.r(sb3, quickAppInfo.name, ",quick_app");
            }
            int i10 = !z6;
            StringBuilder sbT = g.t("broadcast ACTION_SCENE_CHANGED for app has flag ", i10, ". getSceneName=");
            sbT.append(getSceneName(i8));
            sbT.append(", getGameType=");
            sbT.append(getGameType());
            sbT.append(", pkgName=");
            str4 = str;
            sbT.append(str4);
            sbT.append(", sceneChanged=");
            sbT.append(z6);
            sbT.append(", gameInfoChanged=");
            sbT.append(z7);
            sbT.append(", miniOrQuickAppInfo='");
            sbT.append(strR);
            sbT.append("'");
            AlphaMeLogger.debugILog(EngineContract.GAME_MODE, sbT.toString());
            i7 = i6;
            String[] strArr = {getSceneName(i8), str4, Integer.toString(i5), strR, getSceneStateStr(i7)};
            ActionManager.getInstance().broadcast("SCENE_CHANGED", i10, strArr);
            if (z6 != 0) {
                ApplicationImpl.getApplication().sendBroadcast(new Intent("com.stepos.alphame.action.SCENE_CHANGED").putExtra("str_values", strArr).addFlags(8388624), "stepos.alphame.USER_BEHAVIOR");
            }
        } else {
            str4 = str;
            i7 = i6;
            AlphaMeLogger.dLog("scene not changed: " + getSceneName(i8));
        }
        String str7 = quickAppInfo2 != null ? quickAppInfo2.fakePkg : null;
        String str8 = quickAppInfo != null ? quickAppInfo.fakePkg : null;
        boolean z9 = (TextUtils.equals(str6, str2) && TextUtils.equals(str5, str4)) ? false : true;
        boolean z10 = !Objects.equals(str7, str8);
        if (2 != i7) {
            if ((z9 || z10) && !"screen_off".equals(str4)) {
                StringBuilder sbX = g.x("ACTION_ACTIVITY_DETECT pkgName=", str4, ", activity=", str2, ", userId=");
                sbX.append(str3);
                sbX.append(", quickAppPkg=");
                sbX.append(str8);
                Log.i("WME_AppEvent", sbX.toString());
                StringBuilder sbX2 = g.x("ACTION_ACTIVITY_DETECT pkgName=", str4, ", activity=", str2, ", userId=");
                sbX2.append(str3);
                sbX2.append(", quickAppPkg=");
                sbX2.append(str8);
                AlphaMeLogger.dLog(sbX2.toString());
                ActionManager.getInstance().broadcast(LocalConsts.ACTION_ACTIVITY_DETECT, new String[]{str4, str2, str3, str8});
            }
        }
    }

    private void collectActivityIfNeed(String str, String str2) {
        for (ActivityBean activityBean : this.mCollectActivities) {
            if (TextUtils.equals(activityBean.pkg, str) && TextUtils.equals(activityBean.activity, str2)) {
                UsageStatsUtils.onEvent(activityBean.name, null, null);
            }
        }
    }

    private int getCategory(int i4, String str) {
        int length = str != null ? str.length() : 0;
        int i5 = (length - 1) - i4;
        if (i5 >= 0 && i5 < length) {
            char cCharAt = str.charAt(i5);
            if (cCharAt == '1') {
                return 1;
            }
            if (cCharAt == '0') {
                return 0;
            }
        }
        return -1;
    }

    private String[] getDefaultAppInfo() {
        return new String[]{String.valueOf(-1), String.valueOf(-1)};
    }

    private String getGamedMiniAppName(String str) {
        HashMap<String, String> map = MINI_APP_CACHE;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        try {
            Cursor cursorQuery = getResolver().query(URI_EXTRA, new String[]{"fremark"}, "fkey=? AND flevel1=0 AND flevel2=1", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(0);
                        map.put(str, string);
                        cursorQuery.close();
                        return string;
                    }
                } finally {
                }
            }
            map.put(str, "");
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return "";
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("isMiniGame error", e4);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(ApplicationImpl.getAlphaMeLooper()) { // from class: com.stepos.alphame.scene.SceneDetectorEngine.1
                @Override // android.os.Handler
                public void handleMessage(@NonNull Message message) {
                    switch (message.what) {
                        case 1:
                            SceneDetectorEngine.this.onHandleDetectScene(message.arg1, (String[]) message.obj);
                            break;
                        case 2:
                            SceneDetectorEngine.this.onHandleAppEvent((String[]) message.obj);
                            break;
                        case 3:
                            SceneDetectorEngine.this.onHandleAppDied(((Integer) message.obj).intValue());
                            break;
                        case 4:
                            SceneDetectorEngine.this.onHandleScreenEvent(((Integer) message.obj).intValue());
                            break;
                        case 5:
                            SceneDetectorEngine.this.onHandleCheckScreenOffByPause();
                            break;
                        case 6:
                            SceneDetectorEngine.this.onHandleAppResumeLongTime((String) message.obj);
                            break;
                    }
                }
            };
        }
        return this.mHandler;
    }

    public static SceneDetectorEngine getInstance() {
        if (sInstance == null) {
            sInstance = new SceneDetectorEngine();
        }
        return sInstance;
    }

    private String getMiniAppUrl(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return "";
        }
        if (!extras.containsKey(MapBundleKey.MapObjKey.OBJ_URL)) {
            AlphaMeLogger.dLog("Bundle中未找到url字段");
            return "";
        }
        String string = extras.getString(MapBundleKey.MapObjKey.OBJ_URL);
        if (string != null && !string.isEmpty()) {
            return string;
        }
        AlphaMeLogger.dLog("URL为空或无效");
        return "";
    }

    private ContentResolver getResolver() {
        if (this.mResolver == null) {
            this.mResolver = ApplicationImpl.getApplication().getContentResolver();
        }
        return this.mResolver;
    }

    private String getSceneName(int i4) {
        return isGameScene(i4) ? GAME_NAME : "normal";
    }

    private String getSceneStateStr(int i4) {
        return i4 == 0 ? "create" : i4 == 5 ? "screen_off" : "resume";
    }

    private static String getString(String str, String str2) {
        int iIndexOf;
        if (str == null || str.length() < 1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(str2);
        int i4 = -1;
        if (iIndexOf2 == -1 || (iIndexOf = str.indexOf(Consts.SPLITTER_EQUAL, iIndexOf2)) < 0) {
            return null;
        }
        int i5 = iIndexOf + 1;
        int length = str.length();
        for (int i6 = i5; i6 < length; i6++) {
            char cCharAt = str.charAt(i6);
            if (',' == cCharAt || '\n' == cCharAt || ']' == cCharAt) {
                i4 = i6;
                break;
            }
        }
        if (i5 >= i4) {
            return null;
        }
        String strSubstring = str.substring(i5, i4);
        return (strSubstring.length() > 2 && strSubstring.startsWith("'") && strSubstring.endsWith("'")) ? strSubstring.substring(1, strSubstring.length() - 1) : strSubstring;
    }

    private TopActivityInfo getTopActivityInfo() {
        try {
            Bundle topActivityBundle = PerfBinderHelper.getTopActivityBundle();
            if (topActivityBundle == null) {
                AlphaMeLogger.wLog("getTopActivityInfo result is null!");
                return null;
            }
            Bundle bundle = topActivityBundle.getBundle("android.intent.extra.ASSIST_CONTEXT");
            if (bundle == null) {
                bundle = PerfBinderHelper.getTopActivityBundle().getBundle("android.intent.extra.ASSIST_CONTEXT");
            }
            if (bundle != null) {
                return new TopActivityInfo(bundle.getString(EXTRA_ACTIVITY_NAME), (Intent) bundle.getParcelable(EXTRA_ACTIVITY_INTENT));
            }
            AlphaMeLogger.wLog("getTopActivityInfo content is null!");
            return null;
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("getTopActivityInfo error", e4);
            return null;
        }
    }

    private static boolean isGameScene(int i4) {
        return i4 == 1 || i4 == 2 || i4 == 3;
    }

    private boolean isInResumeApps(String str, String str2) {
        Iterator<AppRecord> it = this.mResumedApps.iterator();
        while (it.hasNext()) {
            AppRecord next = it.next();
            if (TextUtils.equals(next.pkgName, str) && TextUtils.equals(next.activityName, str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isInUploadBlacklist(String str) {
        for (String str2 : MINI_APP_UPLOAD_BLACKLIST) {
            if (str2.equals(str)) {
                AlphaMeLogger.wLog(str + "is in upload blacklist");
                return true;
            }
        }
        return false;
    }

    public static boolean isScreenLocked(String str) {
        return TextUtils.equals(str, SCREEN_LOCKED);
    }

    public static boolean isScreenOff(String str) {
        return TextUtils.equals(str, "screen_off");
    }

    private static <E> HashSet<E> newHashSet(E... eArr) {
        HashSet<E> hashSet = new HashSet<>(((eArr.length * 4) / 3) + 1);
        Collections.addAll(hashSet, eArr);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleAppDied(int i4) {
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        boolean[] zArr = new boolean[1];
        AppRecord appRecordRemoveLastResumedAppByPid = removeLastResumedAppByPid(i4, zArr);
        removeAllResumedAppByPid(i4);
        boolean z4 = zArr[0];
        String str = appRecordRemoveLastResumedAppByPid != null ? appRecordRemoveLastResumedAppByPid.pkgName : null;
        if (str != null) {
            AlphaMeLogger.iLog("app died: pkg=" + str + ", pid=" + i4 + ", isLast=" + z4);
        }
        if (appRecordRemoveLastResumedAppByPid != null) {
            this.mQuickAppHelper.appPaused(appRecordRemoveLastResumedAppByPid.pkgName, appRecordRemoveLastResumedAppByPid.activityName);
        }
        int size = rangeArrayList.size();
        if (!z4 || size <= 0) {
            if (ENABLE_DETECT_NONE_PAGE.booleanValue() && z4) {
                this.mCurrApp = "";
                this.mCurrActivity = "";
                sendDetectSceneMsg("", "", "0", 4, 3000);
                return;
            }
            return;
        }
        AppRecord appRecord = rangeArrayList.get(size - 1);
        String str2 = appRecord.pkgName;
        this.mCurrApp = str2;
        String str3 = appRecord.activityName;
        this.mCurrActivity = str3;
        sendDetectSceneMsg(str2, str3, appRecord.userId, 3, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleAppEvent(String[] strArr) {
        String str;
        Handler handler;
        int i4;
        int i5;
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        if (strArr == null || (str = strArr[1]) == null) {
            return;
        }
        handler = getHandler();
        switch (str) {
            case "create":
                String str2 = strArr[0];
                handler.removeMessages(5);
                handler.removeMessages(6);
                sendDetectSceneMsg(str2, strArr[2], strArr[3], 0, 0, strArr[9]);
                break;
            case "resume":
                String str3 = strArr[0];
                String str4 = strArr[2];
                this.mCurrActivity = str4;
                String str5 = strArr[3];
                int i6 = parseInt(strArr[7]);
                this.mCurrApp = str3;
                this.mCurrActivity = str4;
                this.mMultiState = Boolean.parseBoolean(strArr[6]);
                StringBuilder sbX = g.x("app resume: pkg=", str3, ", activity=", str4, ", pid=");
                sbX.append(i6);
                sbX.append(", uid=");
                sbX.append(str5);
                AlphaMeLogger.debugLog(EngineContract.GAME_MODE, sbX.toString());
                if (isInResumeApps(str3, str4)) {
                    removeResumedApp(str3, str4);
                }
                rangeArrayList.add(new AppRecord(str3, str4, i6, str5));
                int size = rangeArrayList.size();
                if (size > 16) {
                    StringBuilder sbT = g.t("resize resumedApps from ", size, " to ");
                    sbT.append(size - 8);
                    AlphaMeLogger.dLog(sbT.toString());
                    rangeArrayList.removeRange(0, 8);
                }
                boolean z4 = DELAY_RESUME_PKGS.contains(str3) || DELAY_RESUME_ACTS.contains(str4);
                if (str3 != null && PredictManager.getInstance(ApplicationImpl.getApplication()).isHome(str3)) {
                    i5 = 10;
                } else if (!z4) {
                    i4 = 0;
                    AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "pkgName " + this.mCurrApp + " activity " + this.mCurrActivity + " detectTimeOut " + i4);
                    handler.removeMessages(5);
                    handler.removeMessages(6);
                    sendDetectSceneMsg(str3, str4, str5, 1, i4, strArr[9]);
                    collectActivityIfNeed(str3, str4);
                    break;
                } else {
                    i5 = 500;
                }
                i4 = i5;
                AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "pkgName " + this.mCurrApp + " activity " + this.mCurrActivity + " detectTimeOut " + i4);
                handler.removeMessages(5);
                handler.removeMessages(6);
                sendDetectSceneMsg(str3, str4, str5, 1, i4, strArr[9]);
                collectActivityIfNeed(str3, str4);
                break;
            case "pause":
                String str6 = strArr[0];
                String str7 = strArr[2];
                boolean[] zArr = new boolean[1];
                int i7 = parseInt(strArr[7]);
                String str8 = strArr[3];
                boolean z5 = Boolean.parseBoolean(strArr[8]);
                handler.removeMessages(5);
                handler.removeMessages(6);
                handler.sendMessageDelayed(Message.obtain(handler, 5), 2500L);
                AppRecord appRecordRemoveLastResumedApp = z5 ? removeLastResumedApp(str6, str7, zArr) : removeLastResumedApp(str6, zArr);
                boolean z6 = zArr[0];
                if (appRecordRemoveLastResumedApp != null) {
                    AlphaMeLogger.debugILog(EngineContract.GAME_MODE, "app paused: pkg=" + appRecordRemoveLastResumedApp.pkgName + ", activity=" + appRecordRemoveLastResumedApp.activityName + ", pid=" + i7 + ", uid=" + str8 + ", isLast=" + z6 + ", isSpecActivity=" + z5);
                    this.mQuickAppHelper.appPaused(appRecordRemoveLastResumedApp.pkgName, appRecordRemoveLastResumedApp.activityName);
                }
                int size2 = rangeArrayList.size();
                if (z6 && size2 > 0) {
                    AppRecord appRecord = rangeArrayList.get(size2 - 1);
                    String str9 = appRecord.pkgName;
                    this.mCurrApp = str9;
                    String str10 = appRecord.activityName;
                    this.mCurrActivity = str10;
                    sendDetectSceneMsg(str9, str10, appRecord.userId, 3, 100, strArr[0]);
                    break;
                } else if (ENABLE_DETECT_NONE_PAGE.booleanValue() && z6) {
                    this.mCurrApp = "";
                    this.mCurrActivity = "";
                    sendDetectSceneMsg("", "", "0", 4, 3000, strArr[9]);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleAppResumeLongTime(String str) {
        int[] iArrRemoveAllResumedAppExcept = removeAllResumedAppExcept(str);
        StringBuilder sbW = g.w("resume app ", str, " for long time. resize resumed app size from ");
        sbW.append(iArrRemoveAllResumedAppExcept[0]);
        sbW.append(" to ");
        sbW.append(iArrRemoveAllResumedAppExcept[1]);
        AlphaMeLogger.dLog(sbW.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleCheckScreenOffByPause() {
        if (Utils.isScreenOn()) {
            return;
        }
        AlphaMeLogger.dLog("ACTION_SCREEN_OFF_BY_PAUSE");
        ActionManager.getInstance().broadcast(LocalConsts.ACTION_SCREEN_OFF_BY_PAUSE, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleDetectScene(int i4, String[] strArr) {
        MiniAppInfo miniAppInfo;
        int scene;
        int iIntValue;
        int i5;
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        boolean z4 = i4 == 5 || i4 == 4;
        StringBuilder sbW = g.w("detect scene pkgName = ", str, ", activity = ");
        sbW.append(this.mCurrActivity);
        sbW.append(", reset = ");
        sbW.append(z4);
        sbW.append(", state=");
        sbW.append(i4);
        AlphaMeLogger.debugILog(EngineContract.GAME_MODE, sbW.toString());
        if (z4) {
            AlphaMeLogger.wLog("DetectScene reset for '" + str + "'");
            miniAppInfo = null;
            scene = 0;
            iIntValue = 0;
        } else {
            SceneItem sceneItemQueryScene = queryScene(str);
            if (sceneItemQueryScene != null) {
                scene = sceneItemQueryScene.getScene(getResolver());
                iIntValue = ((Integer) sceneItemQueryScene.getInfo().second).intValue();
                StringBuilder sbW2 = g.w("DetectScene pkg=", str, " scene=");
                sbW2.append(getSceneName(scene));
                sbW2.append(" permissionIds=");
                sbW2.append(sceneItemQueryScene.permissionIds);
                sbW2.append(" permissionValues=");
                sbW2.append(sceneItemQueryScene.permissionValues);
                AlphaMeLogger.debugILog(EngineContract.GAME_MODE, sbW2.toString());
            } else {
                AlphaMeLogger.wLog("DetectScene pkg=" + str + ", query failed");
                scene = 0;
                iIntValue = 0;
            }
            miniAppInfo = getMiniAppInfo(str);
            if (miniAppInfo != null) {
                AlphaMeLogger.debugILog(EngineContract.GAME_MODE, "getMiniAppInfo: " + miniAppInfo);
                uploadMiniAppInfo(miniAppInfo);
                boolean z5 = Settings.Secure.getInt(getResolver(), MZ_GAME_MODE, 1) == 1;
                if (miniAppInfo.is_game == 1 && z5) {
                    scene = 3;
                }
            }
        }
        if (i4 == 0) {
            ActionManager.getInstance().broadcast(LocalConsts.ACTION_APP_CREATED, new String[]{str, getSceneName(scene)});
            return;
        }
        boolean z6 = Settings.Secure.getInt(getResolver(), MZ_GAME_MODE, 1) == 1;
        if (this.mLastScene == 2) {
            i5 = (PredictManager.getInstance(ApplicationImpl.getApplication()).isHome(str) || !z6) ? scene : 2;
            AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "mLastScene is quickGame, currentScene  " + i5);
        } else {
            i5 = scene;
        }
        changeScene(i5, str, str2, str3, iIntValue, miniAppInfo, null, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onHandleScreenEvent(int i4) {
        if (i4 == 0) {
            getHandler().removeMessages(5);
            boolean z4 = this.mResumedApps.size() == 0;
            StringBuilder sb = new StringBuilder("SceneDetectorEngine handleScreenOff mResumedApps.size() ");
            sb.append(z4 ? "==" : "!=");
            sb.append(" 0");
            AlphaMeLogger.dLog(sb.toString());
            if (!z4) {
                z4 = !Utils.isScreenOn();
                AlphaMeLogger.dLog("SceneDetectorEngine handleScreenOff isScreenOn = " + z4);
            }
            if (z4) {
                sendDetectSceneMsg("screen_off", "", "0", 5, 0);
            }
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    @NonNull
    private HashMap<String, SceneItem> queryActivityDB() {
        String[] strArr = {"activityName", "permissionId", "permissionValue"};
        long jUptimeMillis = SystemClock.uptimeMillis();
        HashMap<String, SceneItem> map = new HashMap<>();
        try {
            Cursor cursorQuery = getResolver().query(URI_ACTIVITY, strArr, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            String string = cursorQuery.getString(0);
                            int i4 = cursorQuery.getInt(1);
                            int i5 = cursorQuery.getInt(2);
                            SceneItem sceneItem = map.get(string);
                            if (sceneItem == null) {
                                sceneItem = new SceneItem();
                                map.put(string, sceneItem);
                            }
                            sceneItem.permissionIds.add(Integer.valueOf(i4));
                            sceneItem.permissionValues.add(Integer.valueOf(i5));
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e4) {
            AbstractC0351g.B("", e4, "AlphaMe");
        }
        Log.i("AlphaMe", "queryActivityDB size=" + map.size() + ", time=" + (SystemClock.uptimeMillis() - jUptimeMillis));
        return map;
    }

    private SceneItem queryActivityScene(String str) {
        SceneItem sceneItem;
        HashMap<String, SceneItem> map = ACTIVITY_CACHE;
        synchronized (map) {
            try {
                if (map.isEmpty()) {
                    map.putAll(queryActivityDB());
                }
                sceneItem = map.get(str);
            } catch (Throwable th) {
                throw th;
            }
        }
        return sceneItem;
    }

    private HashMap<String, SceneItem> queryDB(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new HashMap<>();
        }
        String[] strArr = {"pkgName", "permissionId", "permissionValue"};
        StringBuilder sb = new StringBuilder("pkgName IN (");
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str = list.get(i4);
            if (str != null) {
                AbstractC0831a.h(sb, "'", str, "',");
            }
        }
        sb.setCharAt(sb.length() - 1, CoreConstants.RIGHT_PARENTHESIS_CHAR);
        HashMap<String, SceneItem> map = new HashMap<>();
        try {
            Cursor cursorQuery = getResolver().query(URI_APP, strArr, sb.toString(), null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            String string = cursorQuery.getString(0);
                            int i5 = cursorQuery.getInt(1);
                            int i6 = cursorQuery.getInt(2);
                            Log.d("AlphaMe", String.format("Query pkg=%s permissionIds=%d permissionValues=%d", string, Integer.valueOf(i5), Integer.valueOf(i6)));
                            SceneItem sceneItem = map.get(string);
                            if (sceneItem == null) {
                                sceneItem = new SceneItem();
                                map.put(string, sceneItem);
                            }
                            sceneItem.permissionIds.add(Integer.valueOf(i5));
                            sceneItem.permissionValues.add(Integer.valueOf(i6));
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e4) {
            AbstractC0351g.B("", e4, "AlphaMe");
        }
        for (String str2 : list) {
            if (!map.containsKey(str2)) {
                map.put(str2, new SceneItem());
            }
        }
        return map;
    }

    private SceneItem queryScene(String str) {
        SceneItem sceneItemQueryDB;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, SceneItem> map = PKG_CACHE;
        synchronized (map) {
            sceneItemQueryDB = map.get(str);
        }
        if (sceneItemQueryDB == null) {
            if (this.mQuickAppHelper.isGame(str)) {
                sceneItemQueryDB = new SceneItem(true);
            } else {
                sceneItemQueryDB = queryDB(str);
                if (sceneItemQueryDB != null) {
                    synchronized (map) {
                        map.put(str, sceneItemQueryDB);
                    }
                }
            }
        }
        synchronized (map) {
            try {
                boolean zContains = this.mCustomEnabledPackages.contains(str);
                boolean zContains2 = this.mCustomDisabledPackages.contains(str);
                if (sceneItemQueryDB != null) {
                    if (zContains) {
                        sceneItemQueryDB.setGame(true);
                    } else if (zContains2) {
                        sceneItemQueryDB.setGame(false);
                    }
                } else if (zContains) {
                    sceneItemQueryDB = SCENE_ITEM_GAME_ONLY;
                } else if (zContains2) {
                    sceneItemQueryDB = SCENE_ITEM_NORMAL;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sceneItemQueryDB;
    }

    @NonNull
    @SuppressLint({"Range"})
    private HashMap<String, String> queryUnboundedAppDB(boolean z4, List<String> list) {
        String string;
        HashMap<String, String> map = new HashMap<>();
        if (!z4 && (list == null || list.isEmpty())) {
            return map;
        }
        String[] strArr = {"pkgName", "category"};
        if (z4) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder("pkgName IN (");
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                String str = list.get(i4);
                if (str != null) {
                    AbstractC0831a.h(sb, "'", str, "',");
                }
            }
            sb.setCharAt(sb.length() - 1, CoreConstants.RIGHT_PARENTHESIS_CHAR);
            string = sb.toString();
        }
        try {
            Cursor cursorQuery = getResolver().query(URI_UNBOUNDED, strArr, string, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("pkgName"));
                            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("category"));
                            if (!TextUtils.isEmpty(string2)) {
                                map.put(string2, string3);
                            }
                            Log.d("AlphaMe", "Query unbounded pkgName=" + string2 + " category=" + string3);
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e4) {
            AbstractC0351g.B("", e4, "AlphaMe");
        }
        return map;
    }

    private void registerAppReceiver(Context context) {
        this.mAppInstallReceiver = new AppInstallReceiver();
        PerfBinderHelper.enableCrossUserPackageMonitor();
        IntentFilter intentFilter = new IntentFilter(PerfBinderHelper.ACTION_PACKAGE_CHANGED_FORWARD);
        try {
            context.registerReceiver(this.mAppInstallReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null, 2);
        } catch (Throwable unused) {
            context.registerReceiver(this.mAppInstallReceiver, intentFilter, "com.stepos.appplatform.permission.ACCESS_IPC_SERVICE", null);
        }
    }

    private void removeAllResumedAppByPid(int i4) {
        if (i4 == 0 || -1 == i4) {
            return;
        }
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        for (int size = rangeArrayList.size() - 1; size >= 0; size--) {
            if (rangeArrayList.get(size).pid == i4) {
                rangeArrayList.remove(size);
            }
        }
    }

    @NonNull
    private int[] removeAllResumedAppExcept(String str) {
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        int size = rangeArrayList.size();
        for (int i4 = size - 1; i4 >= 0; i4--) {
            if (!Objects.equals(rangeArrayList.get(i4).pkgName, str)) {
                rangeArrayList.remove(i4);
            }
        }
        return new int[]{size, rangeArrayList.size()};
    }

    private AppRecord removeLastResumedApp(String str, String str2, boolean[] zArr) {
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        int size = rangeArrayList.size() - 1;
        int i4 = size;
        while (i4 >= 0) {
            AppRecord appRecord = rangeArrayList.get(i4);
            if (TextUtils.equals(appRecord.pkgName, str) && TextUtils.equals(appRecord.activityName, str2)) {
                zArr[0] = i4 == size;
                rangeArrayList.remove(i4);
                return appRecord;
            }
            i4--;
        }
        return null;
    }

    private AppRecord removeLastResumedAppByPid(int i4, boolean[] zArr) {
        if (i4 != 0 && -1 != i4) {
            RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
            int size = rangeArrayList.size() - 1;
            int i5 = size;
            while (i5 >= 0) {
                AppRecord appRecord = rangeArrayList.get(i5);
                if (appRecord.pid == i4) {
                    zArr[0] = i5 == size;
                    rangeArrayList.remove(i5);
                    return appRecord;
                }
                i5--;
            }
        }
        return null;
    }

    private void removeResumedApp(String str, String str2) {
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        for (int size = rangeArrayList.size() - 1; size >= 0; size--) {
            AppRecord appRecord = rangeArrayList.get(size);
            if (TextUtils.equals(appRecord.pkgName, str) && TextUtils.equals(appRecord.activityName, str2)) {
                rangeArrayList.remove(size);
                return;
            }
        }
    }

    private synchronized void sendDetectSceneMsg(String str, String str2, String str3, int i4, int i5, String str4) {
        if (parseInt(str4) != 0) {
            return;
        }
        Handler handler = getHandler();
        handler.removeMessages(1);
        handler.sendMessageDelayed(Message.obtain(handler, 1, i4, 0, new String[]{str, str2, str3}), i5);
    }

    private void staticsMiniAppUsage(MiniAppInfo miniAppInfo) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("app_name", miniAppInfo.app_name);
        arrayMap.put("app_id", miniAppInfo.app_id);
        arrayMap.put("is_game", String.valueOf(miniAppInfo.is_game));
        arrayMap.put("app_type", miniAppInfo.type);
        arrayMap.put("usage_time", String.valueOf(SystemClock.elapsedRealtime() - miniAppInfo.start_time));
        arrayMap.put(Constants.JSON_KEY_IMEI, DeviceInfoKt.getOaid());
        UsageStatsUtils.onEvent("mini_app_record", null, arrayMap);
    }

    private void unRegisterAppReceiver(Context context) {
        context.unregisterReceiver(this.mAppInstallReceiver);
    }

    private void uploadMiniAppInfo(final MiniAppInfo miniAppInfo) {
        if (this.mStartUploadMiniGame) {
            String str = miniAppInfo.app_id;
            final String gamedMiniAppName = miniAppInfo.app_name;
            if (isInUploadBlacklist(str)) {
                AlphaMeLogger.iLog("uploadMiniAppInfo in black list: " + miniAppInfo);
                return;
            }
            if ((gamedMiniAppName == null || gamedMiniAppName.length() <= 0) && ((gamedMiniAppName = getGamedMiniAppName(str)) == null || gamedMiniAppName.length() <= 0)) {
                gamedMiniAppName = g.r(new StringBuilder(), miniAppInfo.type, "_null");
            }
            try {
                RequestManager.getInstance(ApplicationImpl.getApplication()).uploadWXInfo(str, gamedMiniAppName, new ResponseListener<Object>() { // from class: com.stepos.alphame.scene.SceneDetectorEngine.4
                    @Override // com.stepos.alphame.request.ResponseListener
                    public void onFailed(int i4, Exception exc) {
                        AlphaMeLogger.iLog("uploadMiniAppInfo failed: " + miniAppInfo);
                    }

                    @Override // com.stepos.alphame.request.ResponseListener
                    public void onSuccess(int i4, Object obj) {
                        AlphaMeLogger.iLog("uploadMiniAppInfo success: " + miniAppInfo);
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.stepos.alphame.scene.SceneDetectorEngine.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(ApplicationImpl.getApplication(), gamedMiniAppName + " 上传成功", 0).show();
                            }
                        });
                    }
                });
                AlphaMeLogger.iLog("uploadMiniAppInfo: " + miniAppInfo);
            } catch (Exception e4) {
                AlphaMeLogger.exceptionLog("uploadMiniAppInfo error: ", e4);
            }
        }
    }

    public void clearActivityCache() {
        HashMap<String, SceneItem> map = ACTIVITY_CACHE;
        synchronized (map) {
            map.clear();
        }
    }

    public void clearCache() {
        HashMap<String, SceneItem> map = PKG_CACHE;
        synchronized (map) {
            map.clear();
        }
    }

    public void clearExtraCache() {
        HashMap<String, String> map = MINI_APP_CACHE;
        synchronized (map) {
            map.clear();
        }
    }

    @NotProguard
    public int detectActivityScene(int i4) {
        SceneItem sceneItemQueryActivityScene = queryActivityScene(this.mCurrActivity);
        if (sceneItemQueryActivityScene != null) {
            return sceneItemQueryActivityScene.getValueByID(i4);
        }
        return -1;
    }

    @NotProguard
    public String detectActivitySceneAll() {
        SceneItem sceneItemQueryActivityScene = queryActivityScene(this.mCurrActivity);
        if (sceneItemQueryActivityScene == null || sceneItemQueryActivityScene.permissionIds.size() == 0) {
            return null;
        }
        return StringUtil.arrayToString(sceneItemQueryActivityScene.permissionIds) + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.arrayToString(sceneItemQueryActivityScene.permissionValues);
    }

    @NotProguard
    public int detectActivitySceneByActivity(int i4, String str) {
        SceneItem sceneItemQueryActivityScene = queryActivityScene(str);
        if (sceneItemQueryActivityScene != null) {
            return sceneItemQueryActivityScene.getValueByID(i4);
        }
        return -1;
    }

    @NotProguard
    public void enterDebugScene() {
        ApplicationImpl application = ApplicationImpl.getApplication();
        if (application.checkCallingOrSelfPermission(LocalConsts.PERMISSION_DUMP) == 0 && TextUtils.equals(AppUtils.getAppName(application, Binder.getCallingPid()), ONEMIND_TEST_PKG)) {
            AwarenessDataSource.getInstance().enableDump();
            UserBehaviorDataSource.getInstance().enableDump();
            ServerDumper.enableInvoke();
        }
    }

    @NotProguard
    public String[] getAllUnboundedPackages(int i4) {
        Log.d("AlphaMe", "getAllUnboundedPackages type=" + i4);
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, String> entry : queryUnboundedAppDB(true, null).entrySet()) {
                if (getCategory(i4, entry.getValue()) == 1) {
                    arrayList.add(entry.getKey());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i5 = 0; i5 < size; i5++) {
            strArr[i5] = (String) arrayList.get(i5);
        }
        g.z("getAllUnboundedPackages length=", size, "AlphaMe");
        return strArr;
    }

    @NonNull
    @NotProguard
    public int[] getAppBlackListForUserGeneratedContent(String[] strArr) {
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    int length = strArr.length;
                    int[] iArr = new int[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        SceneItem sceneItemQueryScene = queryScene(strArr[i4]);
                        if (sceneItemQueryScene != null) {
                            int iIndexOf = sceneItemQueryScene.permissionIds.indexOf(APP_TYPE_GAME);
                            int iIndexOf2 = sceneItemQueryScene.permissionIds.indexOf(APP_TYPE_FINANCE);
                            if (iIndexOf == -1 && iIndexOf2 == -1) {
                                iArr[i4] = 0;
                            } else {
                                iArr[i4] = 1;
                            }
                        }
                    }
                    return iArr;
                }
            } catch (Exception unused) {
                return new int[0];
            }
        }
        return new int[0];
    }

    @NonNull
    @NotProguard
    public String[] getAppInfo(String str) {
        SceneItem sceneItemQueryScene = queryScene(str);
        return sceneItemQueryScene != null ? new String[]{StringUtil.arrayToString(sceneItemQueryScene.permissionIds), StringUtil.arrayToString(sceneItemQueryScene.permissionValues)} : getDefaultAppInfo();
    }

    @NotProguard
    public String getCdnInfo(String str) {
        return RuleUpdater.getInstance().getCdnInfo(str);
    }

    @NotProguard
    public String getCurrentScene() {
        SceneItem sceneItemQueryScene = queryScene(this.mCurrApp);
        if (sceneItemQueryScene == null || sceneItemQueryScene.permissionIds.size() == 0) {
            return null;
        }
        return StringUtil.arrayToString(sceneItemQueryScene.permissionIds) + AwarenessDataItem.PERMISSION_SPLITTER + StringUtil.arrayToString(sceneItemQueryScene.permissionValues);
    }

    @NotProguard
    public String getGameType() {
        int i4 = this.mLastScene;
        if (i4 == 2) {
            return "game_quick_app";
        }
        if (i4 != 3) {
            return i4 == 1 ? "game_app" : "normal";
        }
        MiniAppInfo miniAppInfo = this.mLastMiniAppInfo;
        if (miniAppInfo == null || miniAppInfo.is_game != 1) {
            return "game_app";
        }
        return "game_mini_" + miniAppInfo.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e5 A[Catch: Exception -> 0x0090, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0090, blocks: (B:31:0x006c, B:63:0x00c4, B:91:0x0149, B:113:0x01b6, B:115:0x01c2, B:116:0x01c8, B:123:0x01e5, B:40:0x0088, B:45:0x0095, B:48:0x009f, B:51:0x00a9), top: B:146:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011e A[Catch: Exception -> 0x00ef, TRY_LEAVE, TryCatch #3 {Exception -> 0x00ef, blocks: (B:66:0x00e8, B:72:0x00f8, B:75:0x0108, B:77:0x011e, B:87:0x0140, B:71:0x00f2, B:118:0x01d0, B:120:0x01d6, B:121:0x01dd, B:125:0x01f5, B:127:0x01fb, B:129:0x0207, B:131:0x020d), top: B:149:0x00b4 }] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.stepos.alphame.scene.SceneDetectorEngine.MiniAppInfo getMiniAppInfo(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 575
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.scene.SceneDetectorEngine.getMiniAppInfo(java.lang.String):com.stepos.alphame.scene.SceneDetectorEngine$MiniAppInfo");
    }

    @NotProguard
    public int getMyUserId() {
        return AlphaMeServer.getInstance().getMyUserId();
    }

    public String getPermissionInfo(String str) {
        return String.valueOf(queryScene(str));
    }

    @NotProguard
    public String[] getPrediction(int i4) {
        PredictManager predictManager = PredictManager.getInstance(ApplicationImpl.getApplication());
        List<String> listPredictApp = predictManager.predictApp(i4, false, System.currentTimeMillis());
        if (listPredictApp == null || listPredictApp.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listPredictApp) {
            if (str.contains(AwarenessDataItem.USERID_SPLITTER)) {
                String pkgName = predictManager.formatPkgName(str);
                if (!arrayList.contains(pkgName)) {
                    arrayList.add(pkgName);
                }
            } else if (!QuickAppHelper.isQuickPrefix(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[arrayList.size()];
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            strArr[i5] = (String) arrayList.get(i5);
        }
        return strArr;
    }

    @NotProguard
    public String getScene() {
        return getSceneName(this.mLastScene);
    }

    public boolean isAppInDB(String str) {
        SceneItem sceneItemQueryDB = queryDB(str);
        return sceneItemQueryDB != null && sceneItemQueryDB.permissionIds.size() > 0;
    }

    @NotProguard
    public boolean isGame(String str) {
        return queryScene(str).getScene(getResolver()) == 1;
    }

    public boolean isGameModeRunning() {
        return GAME_NAME.equals(getScene());
    }

    @NotProguard
    public byte[] isGamePackages(String[] strArr) {
        String str;
        SceneItem sceneItem;
        if (strArr == null || strArr.length <= 0) {
            return new byte[0];
        }
        ContentResolver resolver = getResolver();
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[strArr.length];
        synchronized (PKG_CACHE) {
            try {
                Set<String> set = this.mCustomEnabledPackages;
                Set<String> set2 = this.mCustomDisabledPackages;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    int i5 = 1;
                    if (i4 >= length) {
                        break;
                    }
                    String str2 = strArr[i4];
                    if (set.contains(str2)) {
                        bArr[i4] = 1;
                    } else if (set2.contains(str2)) {
                        bArr[i4] = 0;
                    } else {
                        SceneItem sceneItem2 = PKG_CACHE.get(str2);
                        if (sceneItem2 != null) {
                            if (sceneItem2.getScene(resolver) != 1) {
                                i5 = 0;
                            }
                            bArr[i4] = (byte) i5;
                        } else {
                            bArr[i4] = -1;
                            arrayList.add(str2);
                        }
                    }
                    i4++;
                }
            } finally {
            }
        }
        if (arrayList.size() > 0) {
            HashMap<String, SceneItem> mapQueryDB = queryDB(arrayList);
            synchronized (PKG_CACHE) {
                try {
                    for (Map.Entry<String, SceneItem> entry : mapQueryDB.entrySet()) {
                        PKG_CACHE.put(entry.getKey(), entry.getValue());
                    }
                } finally {
                }
            }
            int length2 = strArr.length;
            for (int i6 = 0; i6 < length2; i6++) {
                if (bArr[i6] == -1 && (str = strArr[i6]) != null && (sceneItem = mapQueryDB.get(str)) != null) {
                    bArr[i6] = (byte) (sceneItem.getScene(resolver) == 1 ? 1 : 0);
                }
            }
        }
        return bArr;
    }

    @NotProguard
    public boolean isMiniGame(String str) {
        String gamedMiniAppName = getGamedMiniAppName(str);
        return gamedMiniAppName != null && gamedMiniAppName.length() > 0;
    }

    public boolean isNavi(String str) {
        return queryScene(str).getValueByID(33) == 1;
    }

    @NotProguard
    public int[] isUnboundedPackages(int i4, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return new int[0];
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[strArr.length];
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = -1;
            arrayList.add(strArr[i5]);
        }
        HashMap<String, String> mapQueryUnboundedAppDB = queryUnboundedAppDB(false, arrayList);
        int length2 = strArr.length;
        for (int i6 = 0; i6 < length2; i6++) {
            iArr[i6] = getCategory(i4, mapQueryUnboundedAppDB.get(strArr[i6]));
        }
        return iArr;
    }

    public boolean match(String str, int i4, int i5) {
        SceneItem sceneItemQueryScene = queryScene(str);
        return sceneItemQueryScene != null && sceneItemQueryScene.getValueByID(i4) == i5;
    }

    @Override // com.stepos.alphame.scene.QuickAppHelper.QuickAppListener
    public void onQuickStart(String str, String str2, String str3) {
        StringBuilder sbX = g.x("detector engine onQuickStart lastPkgName ", str, " curPkgName ", str2, " name ");
        sbX.append(str3);
        AlphaMeLogger.debugLog(EngineContract.GAME_MODE, sbX.toString());
        boolean zIsGame = this.mQuickAppHelper.isGame(str);
        int i4 = 0;
        boolean z4 = Settings.Secure.getInt(getResolver(), MZ_GAME_MODE, 1) == 1;
        if (zIsGame && z4) {
            i4 = 2;
        }
        changeScene(i4, "com.stepos.directservice", this.mCurrActivity, "0", 0, null, new QuickAppInfo(str, str2, str3, zIsGame), 1);
    }

    @Override // com.stepos.alphame.scene.QuickAppHelper.QuickAppListener
    public void onQuickStop(String str) {
        AlphaMeLogger.debugLog(EngineContract.GAME_MODE, "onQuickStop pkgName " + str);
        if (this.mQuickAppHelper.isGame(str)) {
            changeScene(0, "com.stepos.directservice", this.mCurrActivity, "0", 0, null, null, 2);
        }
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        this.mLastScene = Property.getInt(Property.KEY_SCENE_MODE, 0);
        this.mQuickAppHelper.addQuickStartListener(this);
        EngineBase.addFunc(new Scene(this));
        EngineBase.addFunc(new GetCdnInfo(this));
        EngineBase.addFunc(new GetAppInfo(this));
        EngineBase.addFunc(new GetCurrentScene(this));
        EngineBase.addFunc(new WordMatch(this));
        EngineBase.addFunc(new DetectActivityScene(this));
        EngineBase.addFunc(new DetectActivitySceneByActivity(this));
        EngineBase.addFunc(new EnterDebugScene(this));
        EngineBase.addFunc(new IsMiniGame(this));
        EngineBase.addFunc(new IsGame(this));
        EngineBase.addFunc(new GetGameType(this));
        EngineBase.addFunc(new SetBroadcastExactlyGameInfo(this));
        EngineBase.addFunc(new DetectActivitySceneAll(this));
        EngineBase.addFunc(new SetCustomGameModeForPackage(this));
        EngineBase.addFunc(new SetAllPackagesCustomGameMode(this));
        EngineBase.addFunc(new IsGamePackages(this));
        EngineBase.addFunc(new IsUnboundedPackages(this));
        EngineBase.addFunc(new GetAllUnboundedPackages(this));
        EngineBase.addFunc(new GetAppBlackListForUserGeneratedContent(this));
        this.mEventReceiver.addAction("APP_EVENT");
        this.mEventReceiver.addAction("SCREEN_EVENT");
        this.mEventReceiver.addAction(LocalConsts.ACTION_APP_DIED);
        c.f11224a.f(this.mEventReceiver);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        intentFilter.addAction("android.intent.action.REBOOT");
        intentFilter.setPriority(1000);
        ApplicationImpl.getApplication().registerReceiver(this.mReceiver, intentFilter);
        registerAppReceiver(ApplicationImpl.getApplication());
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        c.f11224a.g(this.mEventReceiver);
        ApplicationImpl.getApplication().unregisterReceiver(this.mReceiver);
        unRegisterAppReceiver(ApplicationImpl.getApplication());
    }

    @NotProguard
    public void setAllPackagesCustomGameMode(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            strArr = new String[0];
        }
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        AlphaMeLogger.iLog("setAllPackagesCustomGameMode. enableCount=" + strArr.length + ", disableCount=" + strArr2.length);
        synchronized (PKG_CACHE) {
            HashSet hashSetNewHashSet = newHashSet(strArr);
            this.mCustomEnabledPackages = hashSetNewHashSet;
            HashSet hashSetNewHashSet2 = newHashSet(strArr2);
            this.mCustomDisabledPackages = hashSetNewHashSet2;
            Property.setStringSet(KEY_CUSTOM_ENABLE_LIST, hashSetNewHashSet, KEY_CUSTOM_DISABLE_LIST, hashSetNewHashSet2);
        }
    }

    @NotProguard
    public void setBroadcastExactlyGameInfo(boolean z4) {
        AlphaMeServer.getInstance().setClientFlag(Binder.getCallingPid(), 1, z4);
    }

    @NotProguard
    public void setCustomGameModeForPackage(String str, boolean z4) {
        boolean zAdd;
        boolean zRemove;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (PKG_CACHE) {
            try {
                Set<String> set = this.mCustomEnabledPackages;
                Set<String> set2 = this.mCustomDisabledPackages;
                if (z4) {
                    zAdd = set.add(str);
                    zRemove = set2.remove(str);
                } else {
                    zAdd = set2.add(str);
                    zRemove = set.remove(str);
                }
                if (zAdd | zRemove) {
                    AlphaMeLogger.iLog("setCustomGameModeForPackage changed. packageName=" + str + ", isGame=" + z4);
                    Property.setStringSet(KEY_CUSTOM_ENABLE_LIST, set, KEY_CUSTOM_DISABLE_LIST, set2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void startUploadWXGame(boolean z4) {
        this.mStartUploadMiniGame = z4;
    }

    public void updateCollectActivityInfo(Object obj) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                arrayList.add(new ActivityBean(jSONArray.getJSONObject(i4)));
            }
        }
        this.mCollectActivities = arrayList;
    }

    @NotProguard
    public List<String> wordMatch(String str) throws NumberFormatException {
        char c4;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Pattern patternCompile = Pattern.compile("0?(13|14|15|17|18|19)[0-9]{9}");
        Pattern patternCompile2 = Pattern.compile("[0-9-()（）]{7,18}");
        Pattern patternCompile3 = Pattern.compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
        Pattern patternCompile4 = Pattern.compile("([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+");
        Matcher matcher = patternCompile.matcher(str2);
        Matcher matcher2 = patternCompile2.matcher(str2);
        Matcher matcher3 = patternCompile3.matcher(str2);
        Matcher matcher4 = patternCompile4.matcher(str2);
        while (matcher2.find()) {
            map2.put(String.valueOf(matcher2.start()) + "," + matcher2.end(), "telephone\t\t" + matcher2.group());
        }
        while (matcher.find()) {
            map.put(String.valueOf(matcher.start()) + "," + matcher.end(), "\tmobile:           " + matcher.group());
            arrayList.add("mobile\t\t" + matcher.group() + "\t\t" + matcher.start() + "," + matcher.end());
        }
        while (matcher3.find()) {
            map.put(String.valueOf(matcher3.start()) + "," + matcher3.end(), "\temail:           " + matcher3.group());
            arrayList.add("email\t\t" + matcher3.group() + "\t\t" + matcher3.start() + "," + matcher3.end());
        }
        while (matcher4.find()) {
            map.put(String.valueOf(matcher4.start()) + "," + matcher4.end(), "\tURL:           " + matcher4.group());
            arrayList.add("URL\t\t" + matcher4.group() + "\t\t" + matcher4.start() + "," + matcher4.end());
        }
        int size = map2.size();
        C0152a[] c0152aArr = new C0152a[size];
        Iterator it = map2.keySet().iterator();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            c4 = 1;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            if (i5 <= map2.keySet().size()) {
                String[] strArrSplit = str3.split(",");
                c0152aArr[i5] = new C0152a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
                i5++;
                i4 = 0;
            } else {
                i4 = 0;
            }
        }
        int size2 = map.size();
        C0152a[] c0152aArr2 = new C0152a[size2];
        int i6 = i4;
        for (String str4 : map.keySet()) {
            if (i6 <= map.keySet().size()) {
                String[] strArrSplit2 = str4.split(",");
                c0152aArr2[i6] = new C0152a(Integer.parseInt(strArrSplit2[i4]), Integer.parseInt(strArrSplit2[1]));
                i6++;
                i4 = 0;
            }
            c4 = 1;
        }
        for (int i7 = i4; i7 < size; i7++) {
            int i8 = i4;
            while (i8 < size2) {
                C0152a c0152a = c0152aArr[i7];
                int i9 = c0152a.f2261a;
                C0152a c0152a2 = c0152aArr2[i8];
                if (i9 >= c0152a2.f2261a && c0152a.f2262b <= c0152a2.f2262b) {
                    map2.remove(String.valueOf(i9) + "," + c0152aArr[i7].f2262b);
                }
                i8++;
                c4 = 1;
            }
        }
        for (String str5 : map2.keySet()) {
            arrayList.add(String.valueOf((String) map2.get(str5)) + "\t\t" + str5);
        }
        while (!J.z(str2).equals("")) {
            String strZ = J.z(str2);
            arrayList.add("Date\t\t" + strZ);
            char[] charArray = str2.toCharArray();
            int i10 = Integer.parseInt(strZ.split("\t\t")[c4].split(",")[c4]);
            for (int i11 = Integer.parseInt(strZ.split("\t\t")[c4].split(",")[i4]); i11 < i10; i11++) {
                charArray[i11] = 'O';
            }
            str2 = new String(charArray);
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, arrayList.size(), 3);
        for (int i12 = i4; i12 < arrayList.size(); i12++) {
            String str6 = (String) arrayList.get(i12);
            strArr[i12][i4] = str6.split("\t\t")[i4];
            strArr[i12][c4] = str6.split("\t\t")[c4];
            strArr[i12][2] = str6.split("\t\t")[2];
        }
        ArrayList arrayList2 = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            for (int i13 = i4; i13 < length; i13++) {
                String[] strArr2 = strArr[i13];
                arrayList2.add(strArr2[i4] + WORD_MATCH_SPLITTER + strArr2[c4] + WORD_MATCH_SPLITTER + strArr2[2]);
            }
        }
        return arrayList2;
    }

    public static class SceneItem {
        static final int UNKNOWN = -1;
        final ArrayList<Integer> permissionIds;
        final ArrayList<Integer> permissionValues;

        public SceneItem() {
            this.permissionIds = new ArrayList<>();
            this.permissionValues = new ArrayList<>();
        }

        public Pair<Integer, Integer> getInfo() {
            if (this.permissionIds.size() == 0) {
                return new Pair<>(-1, -1);
            }
            for (int i4 = 0; i4 < this.permissionIds.size(); i4++) {
                if (this.permissionIds.get(i4).intValue() == 10 && this.permissionValues.get(i4).intValue() != 3) {
                    return new Pair<>(this.permissionIds.get(i4), this.permissionValues.get(i4));
                }
            }
            return new Pair<>(this.permissionIds.get(0), this.permissionValues.get(0));
        }

        public int getScene(ContentResolver contentResolver) {
            for (int i4 = 0; i4 < this.permissionIds.size(); i4++) {
                if (this.permissionIds.get(i4).intValue() == 10 && this.permissionValues.get(i4).intValue() != 3 && Settings.Secure.getInt(contentResolver, SceneDetectorEngine.MZ_GAME_MODE, 1) == 1) {
                    return 1;
                }
            }
            return 0;
        }

        public int getValueByID(int i4) {
            int iIntValue = -1;
            for (int i5 = 0; i5 < this.permissionIds.size(); i5++) {
                if (this.permissionIds.get(i5).intValue() == i4) {
                    iIntValue = this.permissionValues.get(i5).intValue();
                }
            }
            return iIntValue;
        }

        public void setGame(boolean z4) {
            int iIntValue;
            int i4 = -1;
            int i5 = 0;
            while (true) {
                if (i5 >= this.permissionIds.size()) {
                    i5 = i4;
                    iIntValue = -1;
                    break;
                }
                int iIntValue2 = this.permissionIds.get(i5).intValue();
                if (iIntValue2 == 10) {
                    iIntValue = this.permissionValues.get(i5).intValue();
                    break;
                } else {
                    if (iIntValue2 == -1) {
                        i4 = i5;
                    }
                    i5++;
                }
            }
            if (i5 != -1 && iIntValue != -1) {
                if (z4 == (iIntValue != 3)) {
                    return;
                }
            }
            int i6 = z4 ? 0 : 3;
            if (i5 != -1) {
                this.permissionIds.set(i5, 10);
                this.permissionValues.set(i5, Integer.valueOf(i6));
            } else {
                this.permissionValues.add(Integer.valueOf(i6));
                this.permissionIds.add(10);
            }
        }

        public String toString() {
            return this.permissionIds.toString() + "," + this.permissionValues.toString();
        }

        public SceneItem(boolean z4) {
            this();
            if (z4) {
                this.permissionIds.add(10);
                this.permissionValues.add(0);
            }
        }
    }

    public void clearCache(List<String> list) {
        synchronized (PKG_CACHE) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    PKG_CACHE.remove(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private AppRecord removeLastResumedApp(String str, boolean[] zArr) {
        RangeArrayList<AppRecord> rangeArrayList = this.mResumedApps;
        int size = rangeArrayList.size() - 1;
        int i4 = size;
        while (i4 >= 0) {
            AppRecord appRecord = rangeArrayList.get(i4);
            if (TextUtils.equals(appRecord.pkgName, str)) {
                zArr[0] = i4 == size;
                rangeArrayList.remove(i4);
                return appRecord;
            }
            i4--;
        }
        return null;
    }

    private synchronized void sendDetectSceneMsg(String str, String str2, String str3, int i4, int i5) {
        sendDetectSceneMsg(str, str2, str3, i4, i5, String.valueOf(0));
    }

    private SceneItem queryDB(String str) {
        SceneItem sceneItem = new SceneItem();
        if (TextUtils.isEmpty(str)) {
            return sceneItem;
        }
        try {
            Cursor cursorQuery = getResolver().query(URI_APP, new String[]{"permissionId", "permissionValue"}, "pkgName=?", new String[]{str}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        cursorQuery.moveToFirst();
                        do {
                            int i4 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("permissionId"));
                            int i5 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("permissionValue"));
                            Log.d("AlphaMe", String.format("Query pkg=%s permissionIds=%d permissionValues=%d", str, Integer.valueOf(i4), Integer.valueOf(i5)));
                            sceneItem.permissionIds.add(Integer.valueOf(i4));
                            sceneItem.permissionValues.add(Integer.valueOf(i5));
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e4) {
            AbstractC0351g.B("", e4, "AlphaMe");
        }
        return sceneItem;
    }
}
