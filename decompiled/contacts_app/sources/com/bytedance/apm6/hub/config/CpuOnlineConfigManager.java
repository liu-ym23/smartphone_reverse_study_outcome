package com.bytedance.apm6.hub.config;

import com.android.contacts.util.HanziToPinyin;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CpuOnlineConfigManager implements CpuConfigService {
    private static final String BASE_CPU_KEY = "cpu";
    private static final String KEY_BACK_COLLECT_INTERVAL = "back_collect_interval";
    private static final String KEY_BACK_THREAD_COLLECT_INTERVAL = "back_thread_collect_interval";
    private static final String KEY_COLLECT_ALL_PROCESS = "exception_collect_all_process";
    private static final String KEY_ENABLE_ALL_PROCESS = "enable_collect_all_process";
    private static final String KEY_ENABLE_UPLOAD = "enable_upload";
    private static final String KEY_EXCEPTION_BACK_MAX_SPEED_SCENE = "exception_back_max_speed_scene";
    private static final String KEY_EXCEPTION_FORE_MAX_SPEED_SCENE = "exception_fore_max_speed_scene";
    private static final String KEY_EXCEPTION_NATIVE_THREAD_ENABLED = "exception_native_thread_enabled";
    private static final String KEY_EXCEPTION_SWITCH = "exception_switch";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE = "exception_thread_max_usage";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE_MAP = "exception_thread_max_usage_map";
    private static final String KEY_EXCEPTION_THREAD_STACK_ENABLED = "exception_thread_stack_enabled";
    private static final String KEY_FRONT_COLLECT_INTERVAL = "front_collect_interval";
    private static final String KEY_FRONT_THREAD_COLLECT_INTERVAL = "front_thread_collect_interval";
    private static final String KEY_MAIN_THREAD_COLLECT_ENABLED = "main_thread_collect_enabled";
    private static final String KEY_MONITOR_INTERVAL = "monitor_interval";
    private static final String KEY_PROCESS_BACK_MAX_SPEED = "exception_process_back_max_speed";
    private static final String KEY_PROCESS_DETECT_INTERVAL = "process_detect_interval";
    private static final String KEY_PROCESS_FORE_MAX_SPEED = "exception_process_fore_max_speed";
    private static final String KEY_THREAD_DETECT_INTERVAL = "thread_detect_interval";
    private CpuConfig mConfig;
    private CpuExceptionConfig mExceptionConfig;

    static /* synthetic */ void access$000(CpuOnlineConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    public CpuOnlineConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public CpuConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public CpuExceptionConfig getExceptionConfig() {
        return this.mExceptionConfig;
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = BasePerfConfigParser.parseData(r10, "cpu");
        if (r12 == null) goto L79;
        this.mConfig = new CpuConfig();
        boolean r1 = true;
        if (r12.optInt("enable_upload", 0) != 1) goto L9;
        boolean r13 = true;
    L10:
        this.mConfig.setEnableUpload(r13);
        if (r12.optInt(KEY_ENABLE_ALL_PROCESS, 0) != 1) goto L13;
        boolean r14 = true;
    L14:
        this.mConfig.setCollectAllProcess(r14);
        long r4 = r12.optLong(KEY_FRONT_COLLECT_INTERVAL, 0);
        if (r4 <= 0) goto L17;
        this.mConfig.setFrontCollectInterval(r4);
    L17:
        long r5 = r12.optLong(KEY_BACK_COLLECT_INTERVAL, 0);
        if (r5 <= 0) goto L20;
        this.mConfig.setBackCollectInterval(r5);
    L20:
        long r6 = r12.optLong("monitor_interval", 0);
        if (r6 <= 0) goto L23;
        this.mConfig.setMonitorInterval(r6);
    L23:
        long r7 = r12.optLong(KEY_FRONT_THREAD_COLLECT_INTERVAL, 0);
        if (r7 <= 0) goto L26;
        this.mConfig.setFrontThreadCollectInterval(r7);
    L26:
        long r8 = r12.optLong(KEY_BACK_THREAD_COLLECT_INTERVAL, 0);
        if (r8 <= 0) goto L29;
        this.mConfig.setBackThreadCollectInterval(r8);
    L29:
        this.mExceptionConfig = new CpuExceptionConfig();
        if (r12.optInt(KEY_EXCEPTION_SWITCH, 0) != 1) goto L32;
        boolean r15 = true;
    L33:
        this.mExceptionConfig.setOpen(r15);
        double r9 = r12.optDouble(KEY_PROCESS_BACK_MAX_SPEED, 0.0d);
        if (r9 <= 0.0d) goto L36;
        this.mExceptionConfig.setMaxProcessBackCpuSpeed(r9);
    L36:
        double r16 = r12.optDouble(KEY_PROCESS_FORE_MAX_SPEED, 0.0d);
        if (r16 <= 0.0d) goto L40;
        this.mExceptionConfig.setMaxProcessForeCpuSpeed(r16);
    L40:
        if (r12.optInt("main_thread_collect_enabled", 0) != 1) goto L42;
        boolean r17 = true;
    L43:
        this.mExceptionConfig.setCollectMainThread(r17);
        if (r12.optInt(KEY_COLLECT_ALL_PROCESS, 0) != 1) goto L46;
        boolean r18 = true;
    L47:
        this.mExceptionConfig.setCollectAllProcess(r18);
        if (r12.optInt(KEY_EXCEPTION_THREAD_STACK_ENABLED, 1) == 1) goto L51;
        r1 = false;
    L51:
        this.mExceptionConfig.setCollectThreadStack(r1);
        double r19 = r12.optDouble(KEY_EXCEPTION_THREAD_MAX_USAGE, 0.0d);
        if (r19 <= 0.0d) goto L54;
        this.mExceptionConfig.setMaxThreadCpuRate(r19);
    L54:
        JSONObject r110 = r12.optJSONObject(KEY_EXCEPTION_THREAD_MAX_USAGE_MAP);
        HashMap r2 = new HashMap();
        if (r110 == null) goto L62;
        Iterator<String> r20 = r110.keys();
    L58:
        if (r20.hasNext() == false) goto L62;
        String r21 = r20.next();
        double r22 = r110.optDouble(r21, 0.0d);
        if (r22 <= 0.0d) goto L58;
        r2.put(r21, Double.valueOf(r22));
    L62:
        this.mExceptionConfig.setMaxThreadCpuRateMap(r2);
        this.mExceptionConfig.setProcessDetectInterval(r12.optInt(KEY_PROCESS_DETECT_INTERVAL, 30));
        this.mExceptionConfig.setThreadDetectInterval(r12.optInt(KEY_THREAD_DETECT_INTERVAL, 30));
        JSONObject r111 = r12.optJSONObject(KEY_EXCEPTION_FORE_MAX_SPEED_SCENE);
        HashMap r3 = new HashMap();
        if (r111 == null) goto L70;
        Iterator<String> r23 = r111.keys();
    L66:
        if (r23.hasNext() == false) goto L70;
        String r24 = r23.next();
        double r25 = r111.optDouble(r24, 0.0d);
        if (r25 <= 0.0d) goto L66;
        r3.put(r24, Double.valueOf(r25));
    L70:
        this.mExceptionConfig.setForeSceneMaxSpeedMap(r3);
        JSONObject r112 = r12.optJSONObject(KEY_EXCEPTION_BACK_MAX_SPEED_SCENE);
        HashMap r26 = new HashMap();
        if (r112 == null) goto L78;
        Iterator<String> r27 = r112.keys();
    L74:
        if (r27.hasNext() == false) goto L78;
        String r28 = r27.next();
        double r29 = r112.optDouble(r28, 0.0d);
        if (r29 <= 0.0d) goto L74;
        r26.put(r28, Double.valueOf(r29));
    L78:
        this.mExceptionConfig.setBackSceneMaxSpeedMap(r26);
        this.mExceptionConfig.setCollectNativeThread(r12.optBoolean(KEY_EXCEPTION_NATIVE_THREAD_ENABLED, false));
        goto L79
    L46:
        r18 = false;
        goto L47
    L42:
        r17 = false;
        goto L43
    L32:
        r15 = false;
        goto L33
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L79:
        Logger.d(Constants.TAG, getConfig() + HanziToPinyin.Token.SEPARATOR + getExceptionConfig());
        CpuCollectManager.getInstance().updateConfig(getConfig());
        CpuExceptionManager.getInstance().updateConfig(getExceptionConfig());
    }
}
