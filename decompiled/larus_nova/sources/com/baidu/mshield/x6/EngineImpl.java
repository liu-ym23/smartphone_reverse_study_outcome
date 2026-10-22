package com.baidu.mshield.x6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.mshield.x6.b.b;
import com.baidu.mshield.x6.e.h;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.g;
import com.baidu.mshield.x6.f.m.c;
import com.baidu.mshield.x6.recv.MyReceiver;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.HashMap;
import java.util.Iterator;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_OAID = "oid";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    public static final HashMap<String, String> PROPERTY_MAP = null;
    private static EngineImpl instance = null;
    public static boolean isUnload = false;
    public static String sAppkey = null;
    public static String sLoadVersion = "4.2.9";
    public static String sSecKey;
    private IntentFilter alarmIntentFilter;
    private Context mContext;
    private a mSecApi;
    private MyReceiver receiver;

    public String bqp() {
        return "";
    }

    public String getEmulatorSig() {
        return "";
    }

    public void setBusy(boolean r100) {
    }

    public void setRunStatus(int r100) {
    }

    public synchronized void unload() {
        monitor-enter(this);
        com.baidu.mshield.x6.f.a.a(this.mContext);     // Catch: Throwable -> L6
        unRegister();     // Catch: Throwable -> L6
        c.b().c();     // Catch: Throwable -> L6
        isUnload = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        PROPERTY_MAP = new HashMap();
        isUnload = false;
    }

    private void registerReceiver() {
    L14:
        th = move-exception;
        f.b(th);
        return;
    L3:
        if (this.alarmIntentFilter != null) goto L5;
        this.alarmIntentFilter = new IntentFilter();     // Catch: Throwable -> L14
    L5:
        this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.zid");     // Catch: Throwable -> L14
        this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.finger");     // Catch: Throwable -> L14
        this.alarmIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L14
        this.alarmIntentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");     // Catch: Throwable -> L14
        MyReceiver r100 = new MyReceiver();     // Catch: Throwable -> L14
        this.receiver = r100;     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT >= 33) goto L18;
        INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r100, this.alarmIntentFilter);     // Catch: Throwable -> L14
        return;
    L18:
        INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r100, this.alarmIntentFilter, 4);     // Catch: Throwable -> L10
    L21:
        return;
    L10:
        th = move-exception;
        f.b(th);     // Catch: Throwable -> L14
    }

    private void unRegister() {
        INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.receiver);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        f.b(th);
    }

    public a getSecApi() {
        return this.mSecApi;
    }

    private EngineImpl(Context r100) {
        this.mContext = r100;
    }

    public static synchronized EngineImpl getInstance(Context r100) {
        monitor-enter(EngineImpl.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new EngineImpl(r100);     // Catch: Throwable -> L10
    L7:
        EngineImpl r101 = instance;     // Catch: Throwable -> L10
        monitor-exit(EngineImpl.class);
        return r101;
    }

    public String getPropertyByType(String r100) {
        HashMap<String, String> r101 = PROPERTY_MAP;     // Catch: Throwable -> L15
        if (r101.size() <= 0) goto L21;
        monitor-enter(r101);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L6:
        if (r101.containsKey(r100) == false) goto L10;
        String r102 = r101.get(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r102;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return "";
    L21:
        return "";
    L15:
        th = move-exception;
        f.b(th);
        return "";
    }

    public void setSecImpl(a r100) {
        this.mSecApi = r100;
    }

    public void ud(HashMap<String, String> r100) {
        if (r100 == null) goto L25;
    L18:
        th = move-exception;
        f.b(th);
        return;
    L4:
        if (r100.size() == 0) goto L26;
        HashMap<String, String> r101 = PROPERTY_MAP;     // Catch: Throwable -> L18
        monitor-enter(r101);     // Catch: Throwable -> L18
        Iterator<String> r102 = r100.keySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L15
        PROPERTY_MAP.put(r103, r100.get(r103));     // Catch: Throwable -> L15
        goto L10
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        com.baidu.xclient.gdid.a.a(r100);     // Catch: Throwable -> L18
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L26:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public void bdsd(int r100, boolean r101) {
        h.a(this.mContext).a(r100, r101);
    }

    public synchronized boolean init(int r100, boolean r101) {
        monitor-enter(this);
        isUnload = false;     // Catch: Throwable -> L8
        f.h(this.mContext);     // Catch: Throwable -> L8
        registerReceiver();     // Catch: Throwable -> L8
        com.baidu.mshield.x6.f.a.b(this.mContext);     // Catch: Throwable -> L8
        com.baidu.mshield.x6.f.a.c(this.mContext);     // Catch: Throwable -> L8
        h.a(this.mContext).b();     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L8:
        th = move-exception;
        throw th;
    }

    public void setPkgNameVersion(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        g.f32612a = r100;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        sLoadVersion = r101;
        return;
    }

    public void uccs(int r100, int r101) {
        new b(this.mContext).k(r100);
        h.a(this.mContext).a(r100, r101);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public void setSecurityVerifyInfo(String r100, String r101, HashMap<String, String> r102) {
        sAppkey = r100;
        sSecKey = r101;
        if (r102 == null) goto L12;
        HashMap<String, String> r103 = PROPERTY_MAP;
        monitor-enter(r103);
        r103.putAll(r102);     // Catch: Throwable -> L9
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_x6_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r111, null, null, 3, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, r111);
    L35:
        return r100.registerReceiver(r101, r110, r111);
    }
}
