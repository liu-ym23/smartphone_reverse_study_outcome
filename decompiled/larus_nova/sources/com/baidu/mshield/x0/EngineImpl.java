package com.baidu.mshield.x0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.d.e;
import com.baidu.mshield.x0.d.g;
import com.baidu.mshield.x0.l.c;
import com.baidu.mshield.x0.receiver.ReceiverWork;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    public static final HashMap<String, String> PROPERTY_MAP = null;
    public static boolean isUnload = false;
    public static Context mContext = null;
    public static String sAppkey = "";
    private static EngineImpl sInstance = null;
    public static boolean sIsArm = true;
    public static boolean sIsX86 = false;
    public static String sLoadVersion = null;
    public static int sScreenStatus = 0;
    public static String sSecKey = "";
    public static String secName;
    public static String secPackageName;
    public String ids;
    private IntentFilter mSecAlarmFilter;
    private IntentFilter mSecSystemFilter;
    private com.baidu.mshield.x0.l.a pref;
    private ReceiverWork secReceiver;
    private c sofirePreferences;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f32459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f32460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EngineImpl f32461c;

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mshield_x0_EngineImpl$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mshield_x0_EngineImpl$a__run$___twin___() {
            EngineImpl.access$000(this.f32461c, this.f32459a, this.f32460b);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mshield_x0_EngineImpl$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mshield_x0_EngineImpl$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(EngineImpl r100, int r101, boolean r102) {
            this.f32461c = r100;
            this.f32459a = r101;
            this.f32460b = r102;
        }
    }

    public class b extends com.baidu.mshield.x0.d.h.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EngineImpl f32462b;

        public class a extends TimerTask {
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                com_baidu_mshield_x0_EngineImpl$b$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void com_baidu_mshield_x0_EngineImpl$b$a__run$___twin___() {
                d.b(EngineImpl.mContext);
            }

            public a(b r100) {
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void com_baidu_mshield_x0_EngineImpl$b$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
                r100.com_baidu_mshield_x0_EngineImpl$b$a__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            com.baidu.mshield.b.c.a.b("setAliveDate");     // Catch: Throwable -> L7
            d.q(EngineImpl.mContext);     // Catch: Throwable -> L7
            String r100 = com.baidu.mshield.x0.a.f32466d;     // Catch: Throwable -> L7
            String r101 = EngineImpl.sLoadVersion;     // Catch: Throwable -> L7
            d.a(EngineImpl.mContext.getApplicationContext(), r100, com.baidu.mshield.x0.a.f32463a, r101, "1001003", "1001002");     // Catch: Throwable -> L7
            if (EngineImpl.access$100(this.f32462b).d("1001003").equals("") == false) goto L5;
            new PthreadTimer("/EngineImpl$b").schedule(new a(this), 60000);     // Catch: Throwable -> L7
        L10:
            return;
        L5:
            d.b(EngineImpl.mContext);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            d.a(th);
        }

        public b(EngineImpl r100) {
            this.f32462b = r100;
        }
    }

    public int adm(String r100) {
        return 0;
    }

    public int aen(String r100) {
        return 0;
    }

    public String getIccFWM() {
        return "";
    }

    public String getImeFWM() {
        return "";
    }

    public String getImsFWM() {
        return "";
    }

    public String getMaFWM() {
        return "";
    }

    public String ice() {
        return ice(-1);
    }

    public String mqa(int r100, String r101, int r102) {
        return "";
    }

    public void setBusy(boolean r100) {
    }

    public String uqi() {
        return "";
    }

    public String xgz(String r100) {
        return "";
    }

    static {
        PROPERTY_MAP = new HashMap();
        sScreenStatus = 1;
        sLoadVersion = com.baidu.mshield.x0.a.f32465c;
        secName = com.baidu.mshield.x0.a.f32466d;
        secPackageName = com.baidu.mshield.x0.a.f32463a;
    }

    private void handleTokenLogic() {
    L20:
        th = move-exception;
        d.a(th);
        return;
    L4:
        if (d.a(mContext, "plc95", false, this.pref) == true) goto L6;
        return;
    L6:
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L20
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(mContext);     // Catch: Throwable -> L20
        String r102 = r101.B();     // Catch: Throwable -> L20
        int r103 = r101.w();     // Catch: Throwable -> L20
        int r104 = r101.v();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r102) == false) goto L9;
        JSONArray r105 = new JSONArray();     // Catch: Throwable -> L20
    L11:
        if ((r105.length() + 1) <= r103) goto L13;
        r105.remove(0);     // Catch: Throwable -> L20
    L13:
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L20
        int r107 = r104 + 1;     // Catch: Throwable -> L20
        r106.append(r107);     // Catch: Throwable -> L20
        r106.append("#");     // Catch: Throwable -> L20
        r106.append(this.sofirePreferences.d());     // Catch: Throwable -> L20
        r106.append("#");     // Catch: Throwable -> L20
        r106.append(r100);     // Catch: Throwable -> L20
        r105.put(r106.toString());     // Catch: Throwable -> L20
        r101.a(r107);     // Catch: Throwable -> L20
        r101.j(r105.toString());     // Catch: Throwable -> L20
        String r108 = this.sofirePreferences.e();     // Catch: Throwable -> L20
        long r109 = this.pref.o();     // Catch: Throwable -> L20
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L20
        com.baidu.mshield.x0.d.c r111 = new com.baidu.mshield.x0.d.c();     // Catch: Throwable -> L20
        d.a(mContext, "plc95", r111, this.pref);     // Catch: Throwable -> L20
        long r112 = ((long) r111.f32482d) * 60000;     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r108) == false) goto L17;
        new com.baidu.mshield.x0.h.a().a(mContext, 6, 1, r112);     // Catch: Throwable -> L20
        this.pref.f(r110);     // Catch: Throwable -> L20
        return;
    L17:
        if ((r110 - r109) < r112) goto L25;
        this.sofirePreferences.d(r108);     // Catch: Throwable -> L20
        this.sofirePreferences.e("");     // Catch: Throwable -> L20
        this.pref.f(r110);     // Catch: Throwable -> L20
        new com.baidu.mshield.x0.h.a().a(mContext, 6, 1, r112);     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L9:
        r105 = new JSONArray(r102);     // Catch: Throwable -> L20
        goto L11
    }

    private void registerReceiver() {
        this.secReceiver = new ReceiverWork();     // Catch: Throwable -> L13
        if (this.mSecAlarmFilter != null) goto L16;
        IntentFilter r100 = new IntentFilter();     // Catch: Throwable -> L13
        this.mSecAlarmFilter = r100;     // Catch: Throwable -> L13
        r100.addAction("com.baidu.mshield.x0.alarm.action");     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT >= 33) goto L19;
        INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(mContext, this.secReceiver, this.mSecAlarmFilter);     // Catch: Throwable -> L13
        goto L16
    L19:
        INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(mContext, this.secReceiver, this.mSecAlarmFilter, 4);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L13
    L16:
        return;
    L13:
        th = move-exception;
        d.a(th);
    }

    private void setAlarms() {
        com.baidu.mshield.x0.l.a r100 = new com.baidu.mshield.x0.l.a(mContext);     // Catch: Throwable -> L10
        com.baidu.mshield.x0.d.b.a(mContext, false);     // Catch: Throwable -> L10
        long r101 = r100.n();     // Catch: Throwable -> L10
        if (r101 != 0) goto L5;
        long r102 = ((long) com.baidu.mshield.x0.d.b.b(mContext)) * 60000;     // Catch: Throwable -> L10
        r100.e(System.currentTimeMillis() + r102);     // Catch: Throwable -> L10
    L8:
        com.baidu.mshield.x0.d.b.a(mContext, r102);     // Catch: Throwable -> L10
        return;
    L5:
        r102 = r101 - System.currentTimeMillis();     // Catch: Throwable -> L10
        if (r102 >= 0) goto L8;
        r102 = 50;
    L10:
        th = move-exception;
        d.a(th);
    }

    public String getAidFWM() {
        return e.a(mContext);
    }

    public String getNui() {
        return g.b(mContext);
    }

    public int gpol() {
        return com.baidu.mshield.x0.j.a.a(mContext).a(null, false);
    }

    public void reportAlive() {
        d.b(mContext);
    }

    public void unload() {
        INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(mContext, this.secReceiver);     // Catch: Throwable -> L4
    L6:
        com.baidu.mshield.x0.d.b.a(mContext);
        stop();
        com.baidu.mshield.x0.e.a.a().b();
        com.baidu.xclient.gdid.a.c();
        com.baidu.mshield.x0.d.h.d.b().c();
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).unload();
        isUnload = true;
        return;
    L4:
        th = move-exception;
        d.a(th);
        goto L6
    }

    private void initReport() {
        com.baidu.mshield.x0.d.h.d.b().a(new b(this));
    }

    public String gtdid() {
        return com.baidu.xclient.gdid.a.b();
    L4:
        th = move-exception;
        d.a(th);
        return "";
    }

    public String getIds() {
        return this.ids;
    }

    public Boolean stop() {
        return Boolean.TRUE;
    }

    private EngineImpl(Context r100) {
        this.ids = SliceInitService.DEFAULT_SWITCH;
        mContext = r100;
        this.pref = new com.baidu.mshield.x0.l.a(r100);
        this.sofirePreferences = new c(r100);
    }

    public static /* synthetic */ com.baidu.mshield.x0.l.a access$100(EngineImpl r100) {
        return r100.pref;
    }

    public static synchronized EngineImpl getInstance(Context r100) {
        monitor-enter(EngineImpl.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new EngineImpl(r100);     // Catch: Throwable -> L10
    L7:
        EngineImpl r101 = sInstance;     // Catch: Throwable -> L10
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
        d.a(th);
        return "";
    }

    public String ice(int r100) {
        return ice("", r100);
    }

    public void sendWMCrashLog(int r100) {
        JSONArray r101 = new JSONArray();     // Catch: Throwable -> L4
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L4
        r102.put("0", r100);     // Catch: Throwable -> L4
        r101.put(r102);     // Catch: Throwable -> L4
        d.a(mContext, r101, "1001133");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.a(th);
    }

    public void setRunStatus(int r100) {
        this.pref.e(r100);     // Catch: Throwable -> L4
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setRunStatus(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.a(th);
    }

    public void ud(HashMap<String, String> r100) {
        if (r100 == null) goto L25;
    L18:
        th = move-exception;
        d.a(th);
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
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).ud(r100);     // Catch: Throwable -> L18
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L26:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
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

    private void doInit(int r100, boolean r101) {
        isUnload = false;     // Catch: Throwable -> L5
        d.m(mContext);     // Catch: Throwable -> L5
        com.baidu.xclient.gdid.a.a(mContext, sAppkey, sSecKey);     // Catch: Throwable -> L5
        this.pref.g(sLoadVersion);     // Catch: Throwable -> L5
        registerReceiver();     // Catch: Throwable -> L5
        com.baidu.mshield.x0.d.b.a(mContext, true);     // Catch: Throwable -> L5
        initReport();     // Catch: Throwable -> L5
        setAlarms();     // Catch: Throwable -> L5
        com.baidu.mshield.x0.c.a.a(mContext);     // Catch: Throwable -> L5
        com.baidu.mshield.x0.c.c.a(mContext);     // Catch: Throwable -> L5
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).init(r100, r101);     // Catch: Throwable -> L5
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecImpl(new com.baidu.mshield.x0.b());     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.a(th);
    }

    public String ice(String r100, int r101) {
        return ice(r100, r101, "");
    }

    public synchronized boolean init(int r100, boolean r101) {
        monitor-enter(this);
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this, r100, r101), "x0/EngineImpl"));     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }

    public void setPkgNameVersion(String r100, String r101) {
        com.baidu.mshield.b.c.a.b("p : " + r100 + " : v : " + r101);     // Catch: Throwable -> L10
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setPkgNameVersion(r100, r101);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r100) == true) goto L7;
        com.baidu.mshield.x0.a.f32463a = r100;     // Catch: Throwable -> L10
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L15;
        sLoadVersion = r101;     // Catch: Throwable -> L10
        this.pref.g(r101);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        d.a(th);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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

    public static /* synthetic */ void access$000(EngineImpl r100, int r101, boolean r102) {
        r100.doInit(r101, r102);
    }

    public String ice(String r100, int r101, String r102) {
        handleTokenLogic();
        return com.baidu.mshield.x0.g.a.a(mContext, r100, r101, r102);
    }

    public void setSecurityVerifyInfo(String r100, String r101, HashMap<String, String> r102) {
        com.baidu.mshield.b.c.a.b("a : " + r100 + " s : " + r101);     // Catch: Throwable -> L13
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecurityVerifyInfo(r100, r101, r102);     // Catch: Throwable -> L13
        com.baidu.xclient.gdid.a.a(mContext, r100, r101, r102);     // Catch: Throwable -> L13
        sAppkey = r100;     // Catch: Throwable -> L13
        sSecKey = r101;     // Catch: Throwable -> L13
        if (r102 == null) goto L20;
        HashMap<String, String> r103 = PROPERTY_MAP;     // Catch: Throwable -> L13
        monitor-enter(r103);     // Catch: Throwable -> L13
        r103.putAll(r102);     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
    L21:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L20:
        return;
    L13:
        th = move-exception;
        d.a(th);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_baidu_mshield_x0_EngineImpl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, int r111) {
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
