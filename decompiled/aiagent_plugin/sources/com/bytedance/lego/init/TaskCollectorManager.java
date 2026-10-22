package com.bytedance.lego.init;

import com.bytedance.lego.init.generate.DelayTaskCollector__assemble_init_task;
import com.bytedance.lego.init.generate.FeedShowTaskCollector__assemble_init_task;
import com.bytedance.lego.init.generate.PeriodTaskCollector__assemble_init_task;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.model.IdleTaskInfo;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.obric.init.task.business.InitAppIntentTask;
import com.obric.init.task.business.InitEventTask;
import com.obric.init.task.business.InitMemoryReportTask;
import com.obric.init.task.business.InitOmniClientToolTraceTask;
import com.obric.init.task.business.InitOmniReportTask;
import com.obric.init.task.business.InitPerformanceMonitorTask;
import com.obric.init.task.business.InitTraceTask;
import com.obric.init.task.comon.InitALogTask;
import com.obric.init.task.comon.InitApmTask;
import com.obric.init.task.comon.InitAppLogTask;
import com.obric.init.task.comon.InitCloudMessageTask;
import com.obric.init.task.comon.InitFlowAppLogTask;
import com.obric.init.task.comon.InitMsSdkServiceSdk;
import com.obric.init.task.comon.InitNpthTask;
import com.obric.init.task.comon.InitPrivacyTask;
import com.obric.init.task.comon.InitProductTask;
import com.obric.init.task.comon.InitRepatoTask;
import com.obric.init.task.comon.InitTtNetTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TaskCollectorManager {
    private static List<IdleTaskInfo> nonUiIdleTaskInfo;
    private static final List<IPeriodTaskCollector> sCollectors = null;
    private static final List<IDelayTaskCollector> sDelayTaskCollectors = null;
    private static List<DelayTaskInfo> sDelayTaskInfoList;
    private static final List<IFeedShowTaskCollector> sFeedShowTaskCollectors = null;
    private static List<FeedShowTaskInfo> sFeedShowTaskInfoList;
    private static List<PeriodTaskInfo> sPeriodTaskInfoList;
    private static final Map<String, InitTaskInfo> taskIndexs = null;
    private static List<IdleTaskInfo> uiIdleTaskInfo;

    static {
        sCollectors = new ArrayList();
        sDelayTaskCollectors = new ArrayList();
        sFeedShowTaskCollectors = new ArrayList();
        sPeriodTaskInfoList = null;
        sDelayTaskInfoList = null;
        sFeedShowTaskInfoList = null;
        taskIndexs = new HashMap();
        uiIdleTaskInfo = new LinkedList();
        nonUiIdleTaskInfo = new LinkedList();
    }

    public TaskCollectorManager() {
    }

    public static List<DelayTaskInfo> getAllDelayTaskInfo() {
        if (sDelayTaskInfoList != null) goto L9;
        sDelayTaskInfoList = new ArrayList();
        Iterator<IDelayTaskCollector> r0 = getDelayTaskCollectors().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        ((IDelayTaskCollector) ZeusTransformUtils.preCheckCast(r0.next(), IDelayTaskCollector.class, "com.obric.aiagent.plugin")).collectDelayTask(sDelayTaskInfoList);
    L9:
        return sDelayTaskInfoList;
    }

    public static List<FeedShowTaskInfo> getAllFeedShowTaskInfo() {
        if (sFeedShowTaskInfoList != null) goto L9;
        sFeedShowTaskInfoList = new ArrayList();
        Iterator<IFeedShowTaskCollector> r0 = getFeedShowTaskCollectors().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        ((IFeedShowTaskCollector) ZeusTransformUtils.preCheckCast(r0.next(), IFeedShowTaskCollector.class, "com.obric.aiagent.plugin")).collectTask(sFeedShowTaskInfoList);
    L9:
        return sFeedShowTaskInfoList;
    }

    public static List<PeriodTaskInfo> getAllPeriodTaskInfo() {
        if (sPeriodTaskInfoList != null) goto L9;
        sPeriodTaskInfoList = new ArrayList();
        Iterator<IPeriodTaskCollector> r0 = getCollectors().iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        ((IPeriodTaskCollector) ZeusTransformUtils.preCheckCast(r0.next(), IPeriodTaskCollector.class, "com.obric.aiagent.plugin")).collectPeriodTask(sPeriodTaskInfoList);
    L9:
        return sPeriodTaskInfoList;
    }

    private static List<IPeriodTaskCollector> getCollectors() {
        List<IPeriodTaskCollector> r0 = sCollectors;
        if (r0.isEmpty() == false) goto L5;
        initPeriodCollectors();
    L5:
        return r0;
    }

    private static List<IDelayTaskCollector> getDelayTaskCollectors() {
        List<IDelayTaskCollector> r0 = sDelayTaskCollectors;
        if (r0.isEmpty() == false) goto L5;
        initDelayTaskCollectors();
    L5:
        return r0;
    }

    private static List<IFeedShowTaskCollector> getFeedShowTaskCollectors() {
        List<IFeedShowTaskCollector> r0 = sFeedShowTaskCollectors;
        if (r0.isEmpty() == false) goto L5;
        initFeedShowTaskCollectors();
    L5:
        return r0;
    }

    public static Map<String, InitTaskInfo> getInitTaskIndexs() {
        Map<String, InitTaskInfo> r0 = taskIndexs;
        if (r0.isEmpty() == false) goto L5;
        initTasksIndexs();
    L5:
        return r0;
    }

    public static List<IdleTaskInfo> getNonUiIdleTaskInfo() {
        if (nonUiIdleTaskInfo.isEmpty() == false) goto L8;
        if (uiIdleTaskInfo.isEmpty() == false) goto L8;
        initIdleTasks();
    L8:
        return nonUiIdleTaskInfo;
    }

    public static List<IdleTaskInfo> getUiIdleTaskInfo() {
        if (nonUiIdleTaskInfo.isEmpty() == false) goto L8;
        if (uiIdleTaskInfo.isEmpty() == false) goto L8;
        initIdleTasks();
    L8:
        return uiIdleTaskInfo;
    }

    static void initDelayTaskCollectors() {
        List<IDelayTaskCollector> r0 = sDelayTaskCollectors;
        r0.clear();
        r0.add(new DelayTaskCollector__assemble_init_task());
    }

    static void initFeedShowTaskCollectors() {
        List<IFeedShowTaskCollector> r0 = sFeedShowTaskCollectors;
        r0.clear();
        r0.add(new FeedShowTaskCollector__assemble_init_task());
    }

    static void initIdleTasks() {
        uiIdleTaskInfo.clear();
        nonUiIdleTaskInfo.clear();
    }

    static void initPeriodCollectors() {
        List<IPeriodTaskCollector> r0 = sCollectors;
        r0.clear();
        r0.add(new PeriodTaskCollector__assemble_init_task());
    }

    static void initTasksIndexs() {
        Map<String, InitTaskInfo> r0 = taskIndexs;
        r0.clear();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r6 = new ArrayList();
        r7.add("SPLASH_ONCREATE2SUPER_START");
        r8.add("APP_SUPER2ONCREATEEND_START");
        r8.add(InitApmTask.ID);
        r8.add(InitProductTask.ID);
        r8.add(InitOmniClientToolTraceTask.ID);
        r8.add(InitEventTask.ID);
        r8.add(InitPerformanceMonitorTask.ID);
        r8.add(InitCloudMessageTask.ID);
        r8.add(InitTtNetTask.ID);
        r8.add(InitFlowAppLogTask.ID);
        r8.add(InitTraceTask.ID);
        r8.add(InitMsSdkServiceSdk.ID);
        r8.add(InitALogTask.ID);
        r8.add(InitPrivacyTask.ID);
        r8.add(InitOmniReportTask.ID);
        r8.add(InitAppIntentTask.ID);
        r8.add(InitAppLogTask.ID);
        r8.add(InitMemoryReportTask.ID);
        r9.add("APP_SUPER2ONCREATEEND_START");
        r9.add(InitApmTask.ID);
        r9.add(InitProductTask.ID);
        r9.add(InitOmniClientToolTraceTask.ID);
        r9.add(InitEventTask.ID);
        r9.add(InitPerformanceMonitorTask.ID);
        r9.add(InitCloudMessageTask.ID);
        r9.add(InitTtNetTask.ID);
        r9.add(InitFlowAppLogTask.ID);
        r9.add(InitTraceTask.ID);
        r9.add(InitMsSdkServiceSdk.ID);
        r9.add(InitALogTask.ID);
        r9.add(InitPrivacyTask.ID);
        r9.add(InitOmniReportTask.ID);
        r9.add(InitAppIntentTask.ID);
        r9.add(InitAppLogTask.ID);
        r9.add(InitMemoryReportTask.ID);
        r6.add("all");
        r0.put("APP_SUPER2ONCREATEEND_END", new InitTaskInfo("APP_SUPER2ONCREATEEND_END", true, false, 17.497513f, r6, r7, r8, r9, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        ArrayList r10 = new ArrayList();
        r3.add("MAIN_ONRESUME2SUPER_END");
        r4.add("MAIN_SUPER2ONCREATEEND_END");
        r5.add("MAIN_SUPER2ONCREATEEND_END");
        r10.add(InitTaskProcess.MAIN);
        r0.put("MAIN_ONRESUME2SUPER_START", new InitTaskInfo("MAIN_ONRESUME2SUPER_START", true, false, 4.4975123f, r10, r3, r4, r5, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        r11.add(InitALogTask.ID);
        r11.add("APP_SUPER2ONCREATEEND_END");
        r12.add("APP_ONCREATE2SUPER_START");
        r13.add("APP_ONCREATE2SUPER_START");
        r14.add("aiagent");
        r0.put(InitCloudMessageTask.ID, new InitTaskInfo(InitCloudMessageTask.ID, true, false, 108.49751f, r14, r11, r12, r13, "com.obric.init.task.comon.InitCloudMessageTask", new InitCloudMessageTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        r15.add("APP_SUPER2ATTACHBASEEND_END");
        r16.add("APP_SUPER2ATTACHBASEEND_START");
        r17.add("APP_SUPER2ATTACHBASEEND_START");
        r18.add("aiagent");
        r0.put(InitRepatoTask.ID, new InitTaskInfo(InitRepatoTask.ID, true, false, 598.4975f, r18, r15, r16, r17, "com.obric.init.task.comon.InitRepatoTask", new InitRepatoTask(), InitPeriod.APP_SUPER2ATTACHBASEEND));
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        ArrayList r21 = new ArrayList();
        ArrayList r110 = new ArrayList();
        r19.add("APP_SUPER2ONCREATEEND_END");
        r20.add("APP_ONCREATE2SUPER_START");
        r21.add("APP_ONCREATE2SUPER_START");
        r110.add("aiagent");
        r0.put(InitEventTask.ID, new InitTaskInfo(InitEventTask.ID, true, false, 18.497513f, r110, r19, r20, r21, "com.obric.init.task.business.InitEventTask", new InitEventTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r22 = new ArrayList();
        ArrayList r23 = new ArrayList();
        ArrayList r24 = new ArrayList();
        ArrayList r111 = new ArrayList();
        r22.add("MAIN_ONCREATE2SUPER_END");
        r23.add("SPLASH_SUPER2ONRESUMEEND_END");
        r24.add("SPLASH_SUPER2ONRESUMEEND_END");
        r111.add(InitTaskProcess.MAIN);
        r0.put("MAIN_ONCREATE2SUPER_START", new InitTaskInfo("MAIN_ONCREATE2SUPER_START", true, false, 8.497513f, r111, r22, r23, r24, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r25 = new ArrayList();
        ArrayList r26 = new ArrayList();
        ArrayList r27 = new ArrayList();
        ArrayList r112 = new ArrayList();
        r25.add("MAIN_ONRESUME2SUPER_START");
        r26.add("MAIN_SUPER2ONCREATEEND_START");
        r27.add("MAIN_SUPER2ONCREATEEND_START");
        r112.add(InitTaskProcess.MAIN);
        r0.put("MAIN_SUPER2ONCREATEEND_END", new InitTaskInfo("MAIN_SUPER2ONCREATEEND_END", true, false, 5.4975123f, r112, r25, r26, r27, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r28 = new ArrayList();
        ArrayList r29 = new ArrayList();
        ArrayList r30 = new ArrayList();
        ArrayList r113 = new ArrayList();
        r28.add("APP_SUPER2ATTACHBASEEND_START");
        r29.add("APP_ATTACHBASE2SUPER_START");
        r30.add("APP_ATTACHBASE2SUPER_START");
        r113.add("all");
        r0.put("APP_ATTACHBASE2SUPER_END", new InitTaskInfo("APP_ATTACHBASE2SUPER_END", true, false, 1197.4976f, r113, r28, r29, r30, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r31 = new ArrayList();
        ArrayList r32 = new ArrayList();
        ArrayList r33 = new ArrayList();
        ArrayList r114 = new ArrayList();
        r31.add("SPLASH_ONCREATE2SUPER_END");
        r32.add("APP_SUPER2ONCREATEEND_END");
        r33.add("APP_SUPER2ONCREATEEND_END");
        r114.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_ONCREATE2SUPER_START", new InitTaskInfo("SPLASH_ONCREATE2SUPER_START", true, false, 16.497513f, r114, r31, r32, r33, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r34 = new ArrayList();
        ArrayList r35 = new ArrayList();
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        r34.add("APP_SUPER2ONCREATEEND_END");
        r35.add("APP_ONCREATE2SUPER_START");
        r35.add(InitAppLogTask.ID);
        r115.add("APP_ONCREATE2SUPER_START");
        r115.add(InitAppLogTask.ID);
        r116.add("aiagent");
        r116.add("interactor");
        r0.put(InitTtNetTask.ID, new InitTaskInfo(InitTtNetTask.ID, true, false, 18.497513f, r116, r34, r35, r115, "com.obric.init.task.comon.InitTtNetTask", new InitTtNetTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r36 = new ArrayList();
        ArrayList r37 = new ArrayList();
        ArrayList r117 = new ArrayList();
        ArrayList r118 = new ArrayList();
        r36.add("APP_ONCREATE2SUPER_START");
        r37.add("APP_SUPER2ATTACHBASEEND_START");
        r37.add(InitNpthTask.ID);
        r37.add(InitRepatoTask.ID);
        r117.add("APP_SUPER2ATTACHBASEEND_START");
        r117.add(InitNpthTask.ID);
        r117.add(InitRepatoTask.ID);
        r118.add("all");
        r0.put("APP_SUPER2ATTACHBASEEND_END", new InitTaskInfo("APP_SUPER2ATTACHBASEEND_END", true, false, 597.4975f, r118, r36, r37, r117, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r38 = new ArrayList();
        ArrayList r39 = new ArrayList();
        ArrayList r40 = new ArrayList();
        ArrayList r119 = new ArrayList();
        r38.add("APP_SUPER2ONCREATEEND_END");
        r39.add("APP_ONCREATE2SUPER_START");
        r39.add(InitProductTask.ID);
        r40.add("APP_ONCREATE2SUPER_START");
        r40.add(InitProductTask.ID);
        r119.add("aiagent");
        r0.put(InitPerformanceMonitorTask.ID, new InitTaskInfo(InitPerformanceMonitorTask.ID, false, false, 18.497513f, r119, r38, r39, r40, "com.obric.init.task.business.InitPerformanceMonitorTask", new InitPerformanceMonitorTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r41 = new ArrayList();
        ArrayList r42 = new ArrayList();
        ArrayList r43 = new ArrayList();
        ArrayList r44 = new ArrayList();
        r41.add("APP_ATTACHBASE2SUPER_END");
        r41.add(InitNpthTask.ID);
        r44.add("all");
        r0.put("APP_ATTACHBASE2SUPER_START", new InitTaskInfo("APP_ATTACHBASE2SUPER_START", true, false, 1796.4976f, r44, r41, r42, r43, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r45 = new ArrayList();
        ArrayList r46 = new ArrayList();
        ArrayList r120 = new ArrayList();
        ArrayList r121 = new ArrayList();
        r45.add("APP_SUPER2ONCREATEEND_START");
        r46.add("APP_ONCREATE2SUPER_START");
        r120.add("APP_ONCREATE2SUPER_START");
        r121.add("all");
        r0.put("APP_ONCREATE2SUPER_END", new InitTaskInfo("APP_ONCREATE2SUPER_END", true, false, 37.497513f, r121, r45, r46, r120, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r47 = new ArrayList();
        ArrayList r48 = new ArrayList();
        ArrayList r49 = new ArrayList();
        ArrayList r122 = new ArrayList();
        r48.add("MAIN_SUPER2ONRESUMEEND_START");
        r49.add("MAIN_SUPER2ONRESUMEEND_START");
        r122.add(InitTaskProcess.MAIN);
        r0.put("MAIN_SUPER2ONRESUMEEND_END", new InitTaskInfo("MAIN_SUPER2ONRESUMEEND_END", true, false, 1.4975125f, r122, r47, r48, r49, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r50 = new ArrayList();
        ArrayList r51 = new ArrayList();
        ArrayList r123 = new ArrayList();
        ArrayList r124 = new ArrayList();
        r50.add("APP_SUPER2ONCREATEEND_END");
        r51.add("APP_ONCREATE2SUPER_START");
        r51.add(InitProductTask.ID);
        r123.add("APP_ONCREATE2SUPER_START");
        r123.add(InitProductTask.ID);
        r124.add("aiagent");
        r0.put(InitFlowAppLogTask.ID, new InitTaskInfo(InitFlowAppLogTask.ID, true, false, 18.497513f, r124, r50, r51, r123, "com.obric.init.task.comon.InitFlowAppLogTask", new InitFlowAppLogTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r52 = new ArrayList();
        ArrayList r125 = new ArrayList();
        ArrayList r126 = new ArrayList();
        ArrayList r127 = new ArrayList();
        r52.add("APP_SUPER2ONCREATEEND_END");
        r125.add("APP_ONCREATE2SUPER_START");
        r126.add("APP_ONCREATE2SUPER_START");
        r127.add("aiagent");
        r0.put(InitTraceTask.ID, new InitTaskInfo(InitTraceTask.ID, true, false, 18.497513f, r127, r52, r125, r126, "com.obric.init.task.business.InitTraceTask", new InitTraceTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r53 = new ArrayList();
        ArrayList r54 = new ArrayList();
        ArrayList r128 = new ArrayList();
        ArrayList r129 = new ArrayList();
        r53.add("APP_SUPER2ONCREATEEND_END");
        r54.add("APP_SUPER2ONCREATEEND_START");
        r54.add(InitAppLogTask.ID);
        r128.add("APP_SUPER2ONCREATEEND_START");
        r128.add(InitAppLogTask.ID);
        r129.add("aiagent");
        r0.put(InitMsSdkServiceSdk.ID, new InitTaskInfo(InitMsSdkServiceSdk.ID, true, false, 18.497513f, r129, r53, r54, r128, "com.obric.init.task.comon.InitMsSdkServiceSdk", new InitMsSdkServiceSdk(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r55 = new ArrayList();
        ArrayList r130 = new ArrayList();
        ArrayList r131 = new ArrayList();
        ArrayList r132 = new ArrayList();
        r55.add("SPLASH_SUPER2ONCREATEEND_START");
        r130.add("SPLASH_ONCREATE2SUPER_START");
        r131.add("SPLASH_ONCREATE2SUPER_START");
        r132.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_ONCREATE2SUPER_END", new InitTaskInfo("SPLASH_ONCREATE2SUPER_END", true, false, 15.497513f, r132, r55, r130, r131, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r56 = new ArrayList();
        ArrayList r57 = new ArrayList();
        ArrayList r133 = new ArrayList();
        ArrayList r134 = new ArrayList();
        r56.add("SPLASH_SUPER2ONCREATEEND_END");
        r57.add("SPLASH_ONCREATE2SUPER_END");
        r133.add("SPLASH_ONCREATE2SUPER_END");
        r134.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_SUPER2ONCREATEEND_START", new InitTaskInfo("SPLASH_SUPER2ONCREATEEND_START", true, false, 14.497513f, r134, r56, r57, r133, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r58 = new ArrayList();
        ArrayList r59 = new ArrayList();
        ArrayList r135 = new ArrayList();
        ArrayList r136 = new ArrayList();
        r58.add("APP_SUPER2ONCREATEEND_END");
        r59.add("APP_ONCREATE2SUPER_START");
        r135.add("APP_ONCREATE2SUPER_START");
        r136.add("aiagent");
        r0.put(InitAppIntentTask.ID, new InitTaskInfo(InitAppIntentTask.ID, true, false, 18.497513f, r136, r58, r59, r135, "com.obric.init.task.business.InitAppIntentTask", new InitAppIntentTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r60 = new ArrayList();
        ArrayList r61 = new ArrayList();
        ArrayList r137 = new ArrayList();
        ArrayList r138 = new ArrayList();
        r60.add("APP_SUPER2ONCREATEEND_END");
        r61.add("APP_ONCREATE2SUPER_START");
        r137.add("APP_ONCREATE2SUPER_START");
        r138.add("aiagent");
        r0.put(InitOmniClientToolTraceTask.ID, new InitTaskInfo(InitOmniClientToolTraceTask.ID, true, false, 18.497513f, r138, r60, r61, r137, "com.obric.init.task.business.InitOmniClientToolTraceTask", new InitOmniClientToolTraceTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r62 = new ArrayList();
        ArrayList r139 = new ArrayList();
        ArrayList r140 = new ArrayList();
        ArrayList r141 = new ArrayList();
        r62.add("APP_SUPER2ATTACHBASEEND_END");
        r139.add("APP_ATTACHBASE2SUPER_START");
        r140.add("APP_ATTACHBASE2SUPER_START");
        r141.add("aiagent");
        r0.put(InitNpthTask.ID, new InitTaskInfo(InitNpthTask.ID, true, false, 598.4975f, r141, r62, r139, r140, "com.obric.init.task.comon.InitNpthTask", new InitNpthTask(), InitPeriod.APP_SUPER2ATTACHBASEEND));
        ArrayList r63 = new ArrayList();
        ArrayList r142 = new ArrayList();
        ArrayList r143 = new ArrayList();
        ArrayList r144 = new ArrayList();
        r63.add("SPLASH_ONRESUME2SUPER_END");
        r142.add("SPLASH_SUPER2ONCREATEEND_END");
        r143.add("SPLASH_SUPER2ONCREATEEND_END");
        r144.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_ONRESUME2SUPER_START", new InitTaskInfo("SPLASH_ONRESUME2SUPER_START", true, false, 12.497513f, r144, r63, r142, r143, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r64 = new ArrayList();
        ArrayList r145 = new ArrayList();
        ArrayList r146 = new ArrayList();
        ArrayList r147 = new ArrayList();
        r64.add(InitMsSdkServiceSdk.ID);
        r64.add(InitPrivacyTask.ID);
        r64.add(InitTtNetTask.ID);
        r64.add("APP_SUPER2ONCREATEEND_END");
        r145.add("APP_ONCREATE2SUPER_START");
        r146.add("APP_ONCREATE2SUPER_START");
        r147.add("aiagent");
        r147.add("interactor");
        r0.put(InitAppLogTask.ID, new InitTaskInfo(InitAppLogTask.ID, true, false, 72.49751f, r147, r64, r145, r146, "com.obric.init.task.comon.InitAppLogTask", new InitAppLogTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r65 = new ArrayList();
        ArrayList r148 = new ArrayList();
        ArrayList r149 = new ArrayList();
        ArrayList r150 = new ArrayList();
        r65.add(InitCloudMessageTask.ID);
        r65.add(InitALogTask.ID);
        r65.add(InitAppLogTask.ID);
        r65.add(InitProductTask.ID);
        r65.add("APP_ONCREATE2SUPER_END");
        r65.add(InitApmTask.ID);
        r65.add(InitAppIntentTask.ID);
        r65.add(InitEventTask.ID);
        r65.add(InitMemoryReportTask.ID);
        r65.add(InitOmniClientToolTraceTask.ID);
        r65.add(InitOmniReportTask.ID);
        r65.add(InitPerformanceMonitorTask.ID);
        r65.add(InitTraceTask.ID);
        r65.add(InitFlowAppLogTask.ID);
        r65.add(InitPrivacyTask.ID);
        r65.add(InitTtNetTask.ID);
        r148.add("APP_SUPER2ATTACHBASEEND_END");
        r149.add("APP_SUPER2ATTACHBASEEND_END");
        r150.add("all");
        r0.put("APP_ONCREATE2SUPER_START", new InitTaskInfo("APP_ONCREATE2SUPER_START", true, false, 596.4975f, r150, r65, r148, r149, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r66 = new ArrayList();
        ArrayList r67 = new ArrayList();
        ArrayList r151 = new ArrayList();
        ArrayList r152 = new ArrayList();
        r66.add("MAIN_SUPER2ONRESUMEEND_END");
        r67.add("MAIN_ONRESUME2SUPER_END");
        r151.add("MAIN_ONRESUME2SUPER_END");
        r152.add(InitTaskProcess.MAIN);
        r0.put("MAIN_SUPER2ONRESUMEEND_START", new InitTaskInfo("MAIN_SUPER2ONRESUMEEND_START", true, false, 2.4975123f, r152, r66, r67, r151, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r68 = new ArrayList();
        ArrayList r69 = new ArrayList();
        ArrayList r153 = new ArrayList();
        ArrayList r154 = new ArrayList();
        r68.add("MAIN_SUPER2ONRESUMEEND_START");
        r69.add("MAIN_ONRESUME2SUPER_START");
        r153.add("MAIN_ONRESUME2SUPER_START");
        r154.add(InitTaskProcess.MAIN);
        r0.put("MAIN_ONRESUME2SUPER_END", new InitTaskInfo("MAIN_ONRESUME2SUPER_END", true, false, 3.4975123f, r154, r68, r69, r153, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r70 = new ArrayList();
        ArrayList r71 = new ArrayList();
        ArrayList r155 = new ArrayList();
        ArrayList r156 = new ArrayList();
        r70.add(InitMsSdkServiceSdk.ID);
        r70.add("APP_SUPER2ONCREATEEND_END");
        r71.add("APP_ONCREATE2SUPER_END");
        r155.add("APP_ONCREATE2SUPER_END");
        r156.add("all");
        r0.put("APP_SUPER2ONCREATEEND_START", new InitTaskInfo("APP_SUPER2ONCREATEEND_START", true, false, 36.497513f, r156, r70, r71, r155, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r72 = new ArrayList();
        ArrayList r73 = new ArrayList();
        ArrayList r157 = new ArrayList();
        ArrayList r158 = new ArrayList();
        r72.add(InitMemoryReportTask.ID);
        r72.add("APP_SUPER2ONCREATEEND_END");
        r73.add("APP_ONCREATE2SUPER_START");
        r157.add("APP_ONCREATE2SUPER_START");
        r158.add("aiagent");
        r0.put(InitApmTask.ID, new InitTaskInfo(InitApmTask.ID, true, false, 36.497513f, r158, r72, r73, r157, "com.obric.init.task.comon.InitApmTask", new InitApmTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r74 = new ArrayList();
        ArrayList r75 = new ArrayList();
        ArrayList r76 = new ArrayList();
        ArrayList r159 = new ArrayList();
        r74.add(InitRepatoTask.ID);
        r74.add("APP_SUPER2ATTACHBASEEND_END");
        r75.add("APP_ATTACHBASE2SUPER_END");
        r76.add("APP_ATTACHBASE2SUPER_END");
        r159.add("all");
        r0.put("APP_SUPER2ATTACHBASEEND_START", new InitTaskInfo("APP_SUPER2ATTACHBASEEND_START", true, false, 1196.4976f, r159, r74, r75, r76, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r77 = new ArrayList();
        ArrayList r78 = new ArrayList();
        ArrayList r79 = new ArrayList();
        ArrayList r80 = new ArrayList();
        r77.add("MAIN_SUPER2ONCREATEEND_START");
        r78.add("MAIN_ONCREATE2SUPER_START");
        r79.add("MAIN_ONCREATE2SUPER_START");
        r80.add(InitTaskProcess.MAIN);
        r0.put("MAIN_ONCREATE2SUPER_END", new InitTaskInfo("MAIN_ONCREATE2SUPER_END", true, false, 7.4975123f, r80, r77, r78, r79, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r81 = new ArrayList();
        ArrayList r82 = new ArrayList();
        ArrayList r83 = new ArrayList();
        ArrayList r84 = new ArrayList();
        r81.add("APP_SUPER2ONCREATEEND_END");
        r82.add("APP_ONCREATE2SUPER_START");
        r82.add(InitAppLogTask.ID);
        r83.add("APP_ONCREATE2SUPER_START");
        r83.add(InitAppLogTask.ID);
        r84.add("aiagent");
        r0.put(InitPrivacyTask.ID, new InitTaskInfo(InitPrivacyTask.ID, true, false, 18.497513f, r84, r81, r82, r83, "com.obric.init.task.comon.InitPrivacyTask", new InitPrivacyTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r1 = new ArrayList();
        ArrayList r85 = new ArrayList();
        ArrayList r86 = new ArrayList();
        ArrayList r87 = new ArrayList();
        r1.add("SPLASH_SUPER2ONRESUMEEND_END");
        r85.add("SPLASH_ONRESUME2SUPER_END");
        r86.add("SPLASH_ONRESUME2SUPER_END");
        r87.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_SUPER2ONRESUMEEND_START", new InitTaskInfo("SPLASH_SUPER2ONRESUMEEND_START", true, false, 10.497513f, r87, r1, r85, r86, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r2 = new ArrayList();
        ArrayList r88 = new ArrayList();
        ArrayList r89 = new ArrayList();
        ArrayList r90 = new ArrayList();
        r2.add("SPLASH_ONRESUME2SUPER_START");
        r88.add("SPLASH_SUPER2ONCREATEEND_START");
        r89.add("SPLASH_SUPER2ONCREATEEND_START");
        r90.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_SUPER2ONCREATEEND_END", new InitTaskInfo("SPLASH_SUPER2ONCREATEEND_END", true, false, 13.497513f, r90, r2, r88, r89, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r91 = new ArrayList();
        ArrayList r92 = new ArrayList();
        ArrayList r93 = new ArrayList();
        ArrayList r94 = new ArrayList();
        r91.add("MAIN_SUPER2ONCREATEEND_END");
        r92.add("MAIN_ONCREATE2SUPER_END");
        r93.add("MAIN_ONCREATE2SUPER_END");
        r94.add(InitTaskProcess.MAIN);
        r0.put("MAIN_SUPER2ONCREATEEND_START", new InitTaskInfo("MAIN_SUPER2ONCREATEEND_START", true, false, 6.4975123f, r94, r91, r92, r93, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r95 = new ArrayList();
        ArrayList r96 = new ArrayList();
        ArrayList r97 = new ArrayList();
        ArrayList r98 = new ArrayList();
        r95.add(InitMemoryReportTask.ID);
        r95.add(InitPerformanceMonitorTask.ID);
        r95.add(InitFlowAppLogTask.ID);
        r95.add("APP_SUPER2ONCREATEEND_END");
        r96.add("APP_ONCREATE2SUPER_START");
        r96.add(InitALogTask.ID);
        r97.add("APP_ONCREATE2SUPER_START");
        r97.add(InitALogTask.ID);
        r98.add("all");
        r0.put(InitProductTask.ID, new InitTaskInfo(InitProductTask.ID, true, false, 72.49751f, r98, r95, r96, r97, "com.obric.init.task.comon.InitProductTask", new InitProductTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r99 = new ArrayList();
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ArrayList r160 = new ArrayList();
        r99.add("APP_SUPER2ONCREATEEND_END");
        r100.add("APP_ONCREATE2SUPER_START");
        r101.add("APP_ONCREATE2SUPER_START");
        r160.add("aiagent");
        r0.put(InitOmniReportTask.ID, new InitTaskInfo(InitOmniReportTask.ID, true, false, 18.497513f, r160, r99, r100, r101, "com.obric.init.task.business.InitOmniReportTask", new InitOmniReportTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        ArrayList r161 = new ArrayList();
        r102.add("MAIN_ONCREATE2SUPER_START");
        r103.add("SPLASH_SUPER2ONRESUMEEND_START");
        r104.add("SPLASH_SUPER2ONRESUMEEND_START");
        r161.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_SUPER2ONRESUMEEND_END", new InitTaskInfo("SPLASH_SUPER2ONRESUMEEND_END", true, false, 9.497513f, r161, r102, r103, r104, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        ArrayList r107 = new ArrayList();
        ArrayList r162 = new ArrayList();
        r105.add(InitProductTask.ID);
        r105.add("APP_SUPER2ONCREATEEND_END");
        r106.add("APP_ONCREATE2SUPER_START");
        r106.add(InitCloudMessageTask.ID);
        r107.add("APP_ONCREATE2SUPER_START");
        r107.add(InitCloudMessageTask.ID);
        r162.add("all");
        r0.put(InitALogTask.ID, new InitTaskInfo(InitALogTask.ID, true, false, 90.49751f, r162, r105, r106, r107, "com.obric.init.task.comon.InitALogTask", new InitALogTask(), InitPeriod.APP_SUPER2ONCREATEEND));
        ArrayList r108 = new ArrayList();
        ArrayList r109 = new ArrayList();
        ArrayList r163 = new ArrayList();
        ArrayList r164 = new ArrayList();
        r108.add("SPLASH_SUPER2ONRESUMEEND_START");
        r109.add("SPLASH_ONRESUME2SUPER_START");
        r163.add("SPLASH_ONRESUME2SUPER_START");
        r164.add(InitTaskProcess.MAIN);
        r0.put("SPLASH_ONRESUME2SUPER_END", new InitTaskInfo("SPLASH_ONRESUME2SUPER_END", true, false, 11.497513f, r164, r108, r109, r163, InitTaskDispatcherKt.INIT_SCHEDULER_INTERNAL_TASK, InitPeriod.NONE));
        ArrayList r165 = new ArrayList();
        ArrayList r166 = new ArrayList();
        ArrayList r167 = new ArrayList();
        ArrayList r168 = new ArrayList();
        r165.add("APP_SUPER2ONCREATEEND_END");
        r166.add("APP_ONCREATE2SUPER_START");
        r166.add(InitProductTask.ID);
        r166.add(InitApmTask.ID);
        r167.add("APP_ONCREATE2SUPER_START");
        r167.add(InitProductTask.ID);
        r167.add(InitApmTask.ID);
        r168.add("aiagent");
        r0.put(InitMemoryReportTask.ID, new InitTaskInfo(InitMemoryReportTask.ID, true, false, 18.497513f, r168, r165, r166, r167, "com.obric.init.task.business.InitMemoryReportTask", new InitMemoryReportTask(), InitPeriod.APP_SUPER2ONCREATEEND));
    }
}
