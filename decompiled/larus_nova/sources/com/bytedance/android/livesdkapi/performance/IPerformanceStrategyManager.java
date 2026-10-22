package com.bytedance.android.livesdkapi.performance;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager")
public interface IPerformanceStrategyManager extends IService {
    public static final int BUSINESS_BASIC_COMMON = 100;
    public static final int BUSINESS_BASIC_ECOM = 110;
    public static final int BUSINESS_BASIC_LIVE_CORE = 120;
    public static final int BUSINESS_BASIC_LOCATION = 101;
    public static final int BUSINESS_BASIC_PULL = 140;
    public static final int BUSINESS_BASIC_RTC = 130;
    public static final int BUSINESS_GAME_COMMON = 600;
    public static final int BUSINESS_HYBRID = 950;
    public static final int BUSINESS_OTHER_COMMON = 900;
    public static final int BUSINESS_OTHER_MEDIA = 920;
    public static final int BUSINESS_OTHER_OFFICIAL = 940;
    public static final int BUSINESS_OTHER_RECORD = 930;
    public static final int BUSINESS_OTHER_THIRD_PARTY = 910;
    public static final int BUSINESS_REVENUE_COMMON = 500;
    public static final int BUSINESS_REVENUE_EFFECT = 540;
    public static final int BUSINESS_REVENUE_GIFT = 530;
    public static final int BUSINESS_REVENUE_GIFT_TRAY = 531;
    public static final int BUSINESS_REVENUE_GIFT_VIDEO = 532;
    public static final int BUSINESS_REVENUE_LINK_MIC = 520;
    public static final int BUSINESS_REVENUE_PK = 510;
    public static final int BUSINESS_REVENUE_RANK = 560;
    public static final int BUSINESS_REVENUE_TOOLBAR = 550;
    public static final int BUSINESS_SOCIAL_COMMON = 200;
    public static final int BUSINESS_SOCIAL_COMMON_CLEAN_SCREEN = 201;
    public static final int BUSINESS_SOCIAL_DANMU = 230;
    public static final int BUSINESS_SOCIAL_DIGG = 220;
    public static final int BUSINESS_SOCIAL_MESSAGE = 210;
    public static final int BUSINESS_VERTICAL_AUDIO = 310;
    public static final int BUSINESS_VERTICAL_COMMON = 300;
    public static final int BUSINESS_VERTICAL_KTV = 330;
    public static final int BUSINESS_VERTICAL_VIDEO = 320;
    public static final int BUSINESS_VS_COMMON = 400;
    public static final String CHANGE_TIME = "live_performance_change_time";
    public static final String CURRENT_LEVEL = "live_performance_current_level";
    public static final String DEGRADE_REASON_HIGH_SHELL_TEMPERATURE = "high_shell_temperature";
    public static final String DEGRADE_REASON_LOW_BATTERY = "low_battery";
    public static final String DEGRADE_REASON_LOW_POWER = "low_power";
    public static final String DEGRADE_REASON_STREAM_STALL = "stream_stall";
    public static final String DEGRADE_REASON_TEMPERATURE_SYS = "temperature_sys";
    public static final String DEGRADE_REASON_TEMPERATURE_THERMAL = "temperature_thermal";
    public static final String DEGRADE_REASON_UI_STALL = "ui_stall";
    public static final String KEY_BOOLEAN_BATTERY_CHARGE = "battery_charge";
    public static final String KEY_BOOLEAN_LOW_POWER = "low_power";
    public static final String KEY_DOUBLE_PREVIEW_FPS = "preview_fps";
    public static final String KEY_DOUBLE_UI_STALL_RATE = "ui_stall_rate";
    public static final String KEY_DOUBLE_UI_STALL_RATE_SERIOUS = "ui_stall_rate_serious";
    public static final String KEY_FLOAT_DEVICE_SCORE = "device_score";
    public static final String KEY_FLOAT_FPS = "fps";
    public static final String KEY_FLOAT_TEMPERATURE = "temperature";
    public static final String KEY_INT_BATTERY_LEVEL = "battery_level";
    public static final String KEY_INT_DEVICE_LEVEL = "device_level";
    public static final String KEY_LONG_ANCHOR_TEMPERATURE_LAST_DURATION = "anchor_temperature_last_duration";
    public static final int PERFORMANCE_LEVEL_DEGRADE_1 = 1;
    public static final int PERFORMANCE_LEVEL_DEGRADE_11 = 11;
    public static final int PERFORMANCE_LEVEL_DEGRADE_12 = 12;
    public static final int PERFORMANCE_LEVEL_DEGRADE_13 = 13;
    public static final int PERFORMANCE_LEVEL_DEGRADE_14 = 14;
    public static final int PERFORMANCE_LEVEL_DEGRADE_15 = 15;
    public static final int PERFORMANCE_LEVEL_DEGRADE_2 = 2;
    public static final int PERFORMANCE_LEVEL_DEGRADE_3 = 3;
    public static final int PERFORMANCE_LEVEL_DEGRADE_4 = 4;
    public static final int PERFORMANCE_LEVEL_DEGRADE_5 = 5;
    public static final int PERFORMANCE_LEVEL_ENHANCE_10 = 10;
    public static final int PERFORMANCE_LEVEL_ENHANCE_16 = 16;
    public static final int PERFORMANCE_LEVEL_ENHANCE_17 = 17;
    public static final int PERFORMANCE_LEVEL_ENHANCE_18 = 18;
    public static final int PERFORMANCE_LEVEL_ENHANCE_19 = 19;
    public static final int PERFORMANCE_LEVEL_ENHANCE_20 = 20;
    public static final int PERFORMANCE_LEVEL_ENHANCE_6 = 6;
    public static final int PERFORMANCE_LEVEL_ENHANCE_7 = 7;
    public static final int PERFORMANCE_LEVEL_ENHANCE_8 = 8;
    public static final int PERFORMANCE_LEVEL_ENHANCE_9 = 9;
    public static final int PERFORMANCE_LEVEL_NORMAL_0 = 0;
    public static final int PERFORMANCE_SHELL_TEMPERATURE_LEVEL_DEGRADE_22 = 22;
    public static final int PERFORMANCE_SHELL_TEMPERATURE_LEVEL_DEGRADE_23 = 23;
    public static final int PERFORMANCE_SHELL_TEMPERATURE_LEVEL_DEGRADE_24 = 24;
    public static final int PERFORMANCE_SHELL_TEMPERATURE_LEVEL_DEGRADE_25 = 25;
    public static final int PERFORMANCE_SHELL_TEMPERATURE_LEVEL_NORMAL_21 = 21;

    public @interface FeatureType {
    }

    boolean canLoad(int r100);

    boolean canShowAnimation(int r100);

    boolean enableRevOpt();

    int getCurrentPerformanceLevel();

    void registerPerformanceStrategyTask(int r100, BasePerformanceStrategyTask r101);

    void unregisterPerformanceStrategyTask(int r100);
}
