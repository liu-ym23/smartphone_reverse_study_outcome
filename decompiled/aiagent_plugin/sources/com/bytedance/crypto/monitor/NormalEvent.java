package com.bytedance.crypto.monitor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.crypto.monitor.proto.CryptoSDKInfo;
import com.bytedance.crypto.monitor.proto.NormalTrace;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class NormalEvent {
    private static final long DELAY_TIME = 21600000;
    private static final String TAG = "NormalEvent";
    private static volatile NormalEvent normalEvent;
    private static final HashMap<String, NormalTrace> normalTraceMap = null;
    private final Object LOCK;
    private boolean isInit;
    private Handler mHandler;
    private Runnable mTimerTask;

    static {
        normalTraceMap = new HashMap();
    }

    public NormalEvent() {
        this.isInit = false;
        this.LOCK = new Object();
    }

    public static /* synthetic */ void access$000(NormalEvent r0) {
        r0.executeTask();
    }

    public static /* synthetic */ Handler access$100(NormalEvent r0) {
        return r0.mHandler;
    }

    private void executeTask() {
        Object r4 = this.LOCK;
        monitor-enter(r4);
        HashMap<String, NormalTrace> r0 = normalTraceMap;     // Catch: Throwable -> L12
        if (r0.size() > 0) goto L9;
        LogUtils.i(TAG, "normalTraceMap is empty, no need to write event");     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L9:
        LogUtils.i(TAG, "NormalEvent executeTask, normalTraceMap size = " + r0.size());     // Catch: Throwable -> L12
        r0.forEach($$Lambda$NormalEvent$G7guw5fAr0m7h4Qp1zLo3gey8E.INSTANCE);     // Catch: Throwable -> L12
        r0.clear();     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static NormalEvent getInstance() {
        if (normalEvent != null) goto L15;
        monitor-enter(NormalEvent.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (normalEvent != null) goto L9;
        normalEvent = new NormalEvent();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NormalEvent.class);     // Catch: Throwable -> L11
    L15:
        return normalEvent;
    }

    static /* synthetic */ void lambda$executeTask$0(String r2, NormalTrace r3) {
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(r3));
    }

    public void eventRecord(int r18, int r19, String r20, String r21, long r22, long r24) {
        LogUtils.d(TAG, "eventRecord, module: " + r18 + ", event: " + r19 + ", pkgName: " + r20 + ", appid: " + r21 + ", timeConsumption: " + r22 + ", dataSize: " + r24);
        Object r8 = this.LOCK;
        monitor-enter(r8);
        String r9 = r18 + "_" + r19 + "_" + r20 + "_" + r21;     // Catch: Throwable -> L12
        HashMap<String, NormalTrace> r10 = normalTraceMap;     // Catch: Throwable -> L12
        NormalTrace r11 = (NormalTrace) ZeusTransformUtils.preCheckCast(r10.get(r9), NormalTrace.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        if (r11 == null) goto L8;
        int r14 = r11.getTotalCalls() + 1;     // Catch: Throwable -> L12
        long r4 = r22 + r11.getTimeConsumption();     // Catch: Throwable -> L12
        NormalTrace.Builder r0 = NormalTrace.newBuilder().setModuleId(r18).setEventId(r19).setPackageName(r20).setAppId(r21).setUserid(0).setErrCode(0).setTotalCalls(r14).setTimeConsumption(r4).setTotalDataSize(r11.getTotalDataSize() + r24);     // Catch: Throwable -> L12
    L9:
        r10.put(r9, r0.build());     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L8:
        r0 = NormalTrace.newBuilder().setModuleId(r18).setEventId(r19).setPackageName(r20).setAppId(r21).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r22).setTotalDataSize(r24);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void eventReport(int r3, int r4, String r5, String r6, long r7) {
        LogUtils.d(TAG, "eventReport, module: " + r3 + ", event: " + r4 + ", pkgName: " + r5 + ", appid: " + r6 + ", timeConsumption: " + r7);
        Monitor.writeEvent(CryptoSDKInfo.newBuilder().setVersion(1).setTimestamp(System.currentTimeMillis()).addNormalTrace(NormalTrace.newBuilder().setModuleId(r3).setEventId(r4).setPackageName(r5).setAppId(r6).setUserid(0).setErrCode(0).setTotalCalls(1).setTimeConsumption(r7).setTotalDataSize(0)));
    }

    public void init() {
        String r0 = TAG;
        LogUtils.d(r0, "init");
        if (this.isInit == false) goto L6;
        LogUtils.i(r0, "init already!");
        return;
    L6:
        this.mHandler = new Handler(Looper.getMainLooper());
        Runnable r1 = new AnonymousClass1(this);
        this.mTimerTask = r1;
        this.mHandler.postDelayed(r1, DELAY_TIME);
        this.isInit = true;
    }
}
