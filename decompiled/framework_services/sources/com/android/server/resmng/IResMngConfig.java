package com.android.server.resmng;

import android.util.ArrayMap;
import android.util.Slog;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IResMngConfig {
    public static final String FEAT_APP_START = "app_start";
    public static final String FEAT_CPU_OPTIMIZE = "cpu_optimize";
    public static final String FEAT_FREEZE = "freeze";
    public static final String FEAT_IO = "io_optimize";
    public static final String FEAT_MEMORY = "memory";
    public static final String FEAT_OAUTO_HELPER = "oauto_helper";
    public static final String FEAT_PERF_OAUTO = "perf_oauto";
    public static final String FEAT_PERF_SURFACEFLINGER = "perf_surfaceflinger";
    public static final String FEAT_PROCESSGUARD = "processguard";
    public static final String FEAT_SCENE_RES_OPTIMIZE = "scene_res_optimize";
    public static final String FEAT_VIRTUAL_FRAME_TIMELINE = "virtual_frame_timeline";
    public static final String MOD_APP_PROTECT = "app_protect";
    public static final String MOD_AUTO_FREEZE = "auto_freeze";
    public static final String MOD_BOOST_OPTIMIZE = "boost_optimize";
    public static final String MOD_CAMERA_BOOST = "camera_boost";
    public static final String MOD_COLD_START_TRIM = "cold_start_trim";
    public static final String MOD_CONTINUOUS_OPTIMIZE = "continuous_optimize";
    public static final String MOD_DWALT_SCHED = "dwalt_sched";
    public static final String MOD_FEATURE_LIST = "feature_list";
    public static final String MOD_FREEZER = "freezer";
    public static final String MOD_HIGH_TEMP_FREEZE = "high_temp_freeze";
    public static final String MOD_HYPERHOLD = "hyperhold";
    public static final String MOD_INIT_CONSTANTS = "init_constants";
    public static final String MOD_LMKD_DUMP = "lmkd_dump";
    public static final String MOD_MEMLEAK_PROTECTOR = "memleak_protector";
    public static final String MOD_NAME_DEFINITION = "name_definition";
    public static final String MOD_OPEN_APP = "open_app";
    public static final String MOD_PERF_AI_OPTIMIZE = "perf_ai_optimize";
    public static final String MOD_PROTECT_LRU = "protect_lru";
    public static final String MOD_QUICK_FREEZE = "quick_freeze";
    public static final String MOD_SCENE_RECOG = "scene_recognize";
    public static final String MOD_SCENE_RECOG_BALANCE = "scene_recognize_balance_mode";
    public static final String MOD_SCENE_RECOG_POWER_SAVE = "scene_recognize_power_save_mode";
    public static final String MOD_SCREENSHOT_ACCEL = "screenshot_accel";
    public static final String MOD_SPECIAL_BLACKSET = "special_blackset";
    public static final String MOD_SP_AWAIT_SVP_PRIORITY = "sp_await_svp_priority";
    public static final String MOD_SVP_SCENARIO_LIMIT_EXEMPT = "svp_scenario_limit_exempt";
    public static final String MOD_TOUCH_DOWN_PRELOAD = "touch_down_preload";
    public static final String MOD_VFT_CONTINUOUS_INSERT = "continuous_insert";
    public static final String MOD_VFT_FIRST_INSERT = "first_insert";
    public static final String PTE_PRELOAD = "pte_preload";
    public static final String TAG = "IResMngConfig";
    public static final String enabledFeatureVersion = "enabled_feature_version";

    public static class FeatureConfig {
        ArrayMap<String, ModuleConfig> children;
        int depth;
        boolean enable;
        int line;
        String name;
        String version;

        public FeatureConfig() {
            this.children = new ArrayMap();
        }

        public String toString() {
            return "FeatureConfig{enable=" + this.enable + ", version='" + this.version + "', name='" + this.name + "', line=" + this.line + ", depth=" + this.depth + ", children.size=" + this.children.size() + '}';
        }
    }

    public interface IBaseConfigIntf {
        void dump(FileDescriptor r1, PrintWriter r2, String[] r3);

        String getFeatureName();

        void onFeatureParsed(FeatureConfig r1);

        void setEnable(boolean r1, int r2);
    }

    public static class ItemConfig {
        ArrayMap<String, String> attrs;
        ArrayList<ItemConfig> children;
        int depth;
        int line;
        String tag;
        String text;

        public ItemConfig() {
            this.attrs = new ArrayMap();
            this.children = new ArrayList();
        }

        public String toString() {
            return "ItemConfig{tag='" + this.tag + "', attrs=" + this.attrs + ", text='" + this.text + "', line=" + this.line + ", depth=" + this.depth + ", children.size=" + this.children.size() + '}';
        }
    }

    public static class ModuleConfig {
        ArrayList<ItemConfig> children;
        int depth;
        boolean enable;
        int line;
        int mode;
        String name;
        String version;

        public ModuleConfig() {
            this.children = new ArrayList();
        }

        public String toString() {
            return "ModuleConfig{name='" + this.name + "', version='" + this.version + "', enable=" + this.enable + ", mode=" + this.mode + ", line=" + this.line + ", depth=" + this.depth + ", children.size=" + this.children.size() + '}';
        }
    }

    public static class RootConfig {
        ArrayMap<String, FeatureConfig> children;

        public RootConfig() {
            this.children = new ArrayMap();
        }
    }

    default void init() {
        Slog.i(TAG, "init");
    }

    default void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        Slog.i(TAG, "dump IResMngConfig");
    }

    default boolean isFeatureEnable(String fn) {
        return false;
    }

    default boolean isModuleEnable(String fn, String mn) {
        return false;
    }
}
