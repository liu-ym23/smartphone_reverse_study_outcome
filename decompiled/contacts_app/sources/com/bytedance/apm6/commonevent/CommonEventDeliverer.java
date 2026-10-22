package com.bytedance.apm6.commonevent;

import android.text.TextUtils;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.commonevent.model.TracingData;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CommonEventDeliverer {
    public static boolean FAST_MODE = false;
    private static final int MAX_SIZE = 1000;
    private static volatile boolean inited = false;
    private static boolean isEnableException;
    private static LimitedQueue<Monitorable> limitedQueue;
    private static volatile CommonEventConfig sCommonEventConfig;

    public CommonEventDeliverer() {
    }

    static /* synthetic */ boolean access$000() {
        return isEnableException;
    }

    static {
        LimitedQueue<Monitorable> r0 = new LimitedQueue(1000);
        limitedQueue = r0;
        isEnableException = true;
        r0.setEvictListener(new AnonymousClass1());
    }

    public static synchronized void setReportFullException(boolean r1) {
        monitor-enter(CommonEventDeliverer.class);
        isEnableException = r1;     // Catch: Throwable -> L7
        monitor-exit(CommonEventDeliverer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static synchronized void initConfig() {
        monitor-enter(CommonEventDeliverer.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (inited == true) goto L9;
        CommonEventConfigService r1 = (CommonEventConfigService) ServiceManager.getService(CommonEventConfigService.class);     // Catch: Throwable -> L11
        if (r1 == null) goto L9;
        updateConfig(r1.getConfig());     // Catch: Throwable -> L11
        inited = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CommonEventDeliverer.class);
    }

    public static void monitorEvent(CommonEvent r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sCommonEventConfig != null) goto L12;
        limitedQueue.push(r3);
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "cached CommonEvent:" + r3);
    L9:
        initConfig();
        return;
    L12:
        if (sCommonEventConfig.isSampledService(r3.getServiceName()) == false) goto L17;
        r3.deepCopyJson();
        Monitor.record(r3);
        if (ApmContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "Sampled CommonEvent:" + r3);
        return;
    L23:
        return;
    L17:
        if (ApmContext.isDebugMode() == false) goto L20;
        Logger.d(Constants.TAG, "UnSampled CommonEvent:" + r3);
    L20:
        if (ApmContext.isDebugMode() == false) goto L25;
        r3.deepCopyJson();
        DoctorDataUtil.onReceivedEvent(r3.getLogType(), r3.toJsonObject(), false);
        return;
    }

    public static void monitorCommonLog(CommonLog r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (sCommonEventConfig != null) goto L12;
        limitedQueue.push(r4);
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "Cached CommonLog: " + r4);
    L9:
        initConfig();
        return;
    L12:
        if (sCommonEventConfig.isSampledLogType(r4.getLogType()) == false) goto L18;
        r4.deepCopyJson();
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.d(Constants.TAG, "Sampled CommonLog:" + r4);
    L16:
        Monitor.record(r4);
        return;
    L18:
        if (ApmContext.isDebugMode() == false) goto L22;
        r4.deepCopyJson();
        DoctorDataUtil.onReceivedEvent(r4.getLogType(), r4.toJsonObject(), false);
        Logger.d(Constants.TAG, "UnSampled CommonLog:" + r4);
        return;
    }

    public static boolean needSkip(String r2, Boolean r3) {
        if (FAST_MODE == true) goto L5;
        return false;
    L5:
        if (sCommonEventConfig != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        if (r3.booleanValue() == false) goto L15;
        if (sCommonEventConfig.isSampledService(r2) == true) goto L22;
    L16:
        return true;
    L22:
        return false;
    L15:
        if (sCommonEventConfig.isSampledLogType(r2) == false) goto L16;
        return false;
    }

    public static void monitorLegacyEvent(GeneralLegacyEvent r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        Monitor.record(r0);
    }

    public static void monitorTrace(TracingData r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.d(Constants.TAG, "trace_data:" + r2.toJsonObject());
    L7:
        Monitor.record(r2);
    }

    public static synchronized void updateConfig(CommonEventConfig r4) {
        monitor-enter(CommonEventDeliverer.class);
        if (r4 != null) goto L28;
    L26:
        monitor-exit(CommonEventDeliverer.class);
        return;
    L28:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (sCommonEventConfig == r4) goto L26;
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "updateConfig " + r4);     // Catch: Throwable -> L23
    L11:
        sCommonEventConfig = r4;     // Catch: Throwable -> L23
    L12:
        if (limitedQueue.isEmpty() == true) goto L21;
        Monitorable r5 = limitedQueue.pop();     // Catch: Throwable -> L23
        if ((r5 instanceof CommonEvent) == true) goto L16;
        if ((r5 instanceof CommonLog) == false) goto L12;
        monitorCommonLog((CommonLog) r5);     // Catch: Throwable -> L23
        goto L12
    L16:
        monitorEvent((CommonEvent) r5);     // Catch: Throwable -> L23
        goto L12
    L21:
        monitor-exit(CommonEventDeliverer.class);
    }

    public static void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        monitorStatusAndEvent(r1, 0, r2, r3, r4);
    }

    public static void monitorEvent(String r8, int r9, JSONObject r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        monitorEvent(new CommonEvent(r8, r9, r10, r11, r12, r13));
    }

    public static void monitorStatusAndEvent(String r6, int r7, JSONObject r8, JSONObject r9, JSONObject r10) {
        monitorEvent(r6, r7, null, r8, r9, r10);
    }

    public static void monitorDuration(String r8, JSONObject r9, JSONObject r10) {
        monitorEvent(new CommonEvent(r8, 0, r9, null, null, r10));
    }

    public static void monitorStatusRate(String r1, int r2, JSONObject r3) {
        monitorStatusAndEvent(r1, r2, null, null, r3);
    }

    public static void monitorStatusAndDuration(String r8, int r9, JSONObject r10, JSONObject r11) {
        monitorEvent(new CommonEvent(r8, r9, r10, null, null, r11));
    }

    public static void monitorCommonLog(String r1, JSONObject r2) {
        if (TextUtils.isEmpty(r1) == true) goto L5;
        monitorCommonLog(new CommonLog(r1, r2));
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.d(Constants.TAG, "logType must be not empty");
        return;
    }
}
