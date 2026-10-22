package com.bytedance.bdtracker;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.bytedance.applog.IActiveCustomParamsCallback;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.IEventJsonObserver;
import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.IExtraParams;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.IPresetEventObserver;
import com.bytedance.applog.IPullAbTestConfigCallback;
import com.bytedance.applog.ISessionObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.Level;
import com.bytedance.applog.R;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.alink.util.LinkUtils;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.event.EventBuilder;
import com.bytedance.applog.event.IEventHandler;
import com.bytedance.applog.exception.AppCrashType;
import com.bytedance.applog.exposure.ViewExposureManager;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.ILogProcessor;
import com.bytedance.applog.log.LogProcessorHolder;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.profile.UserProfileCallback;
import com.bytedance.applog.simulate.SimulateLaunchActivity;
import com.stepos.cloudsdk.Constants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d implements IAppLogInstance {
    public static final List<d> K = new CopyOnWriteArrayList();
    public static final AtomicInteger L = new AtomicInteger(0);
    public IActiveCustomParamsCallback A;
    public volatile s B;
    public IEventHandler C;
    public final IAppLogLogger D;
    public final b4 j;
    public final z3 k;
    public volatile u1 o;
    public volatile w1 p;
    public volatile e0 q;
    public volatile w r;
    public volatile ViewExposureManager s;
    public volatile INetworkClient t;
    public volatile IHeaderCustomTimelyCallback v;
    public volatile e1 w;
    public h1 y;
    public IALinkListener z;
    public final ConcurrentHashMap<String, JSONObject> a = new ConcurrentHashMap<>();
    public final j1 b = new j1();
    public final i1 c = new i1();
    public final y1 d = new y1();
    public final n1 e = new n1();
    public final Set<Integer> f = new HashSet();
    public final Set<String> g = new HashSet();
    public final Set<Class<?>> h = new HashSet();
    public final Map<String, k0> i = new ConcurrentHashMap();
    public int l = 0;
    public String m = "";
    public volatile Application n = null;
    public volatile boolean u = false;
    public volatile boolean x = false;
    public volatile boolean E = true;
    public long F = 0;
    public volatile boolean G = false;
    public final i5<String> H = new i5<>();
    public final i5<String> I = new i5<>();
    public final Object J = new Object();

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("接口加密开关", this.a);
                jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public b(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("禁止采集详细信息开关", this.a);
                jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class c implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public c(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("剪切板开关", this.a);
                jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* renamed from: com.bytedance.bdtracker.d$d, reason: collision with other inner class name */
    public class C0001d implements EventBus.DataFetcher {
        public final /* synthetic */ boolean a;

        public C0001d(boolean z) {
            this.a = z;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("appId", d.this.m);
                jSONObject2.put("隐私模式开关", this.a);
                jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public d() {
        L.incrementAndGet();
        this.D = new LoggerImpl();
        this.j = new b4(this);
        this.k = new z3(this);
        K.add(this);
    }

    public y1 a() {
        return this.d;
    }

    public final void a(String str, Object obj) {
        InitConfig initConfig = getInitConfig();
        if (initConfig == null || initConfig.getProcess() != 2) {
            this.D.warn("call setHeaderInfo process unknown.", new Object[0]);
            return;
        }
        if (!(obj instanceof String)) {
            this.D.warn("call setHeaderInfo in other process, not support value type, key: {}, value: {}.", str, obj);
            return;
        }
        Intent intent = new Intent(this.n, (Class<?>) Collector.class);
        intent.putExtra("K_APP_ID", this.m);
        intent.putExtra("K_CUSTOM_HEADER_KEY", str);
        intent.putExtra("K_CUSTOM_HEADER_VALUE", (String) obj);
        intent.putExtra("K_ADD_CUSTOM_HEADER", true);
        this.n.sendBroadcast(intent);
    }

    public final boolean a(String str) {
        return r.b(this.p, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void activateALink(Uri uri) {
        if (b("activateALink")) {
            return;
        }
        j jVar = this.q.B;
        jVar.c();
        if (uri != null) {
            jVar.h = uri.toString();
        }
        jVar.b().debug(3, "Activate deep link with url: {}...", jVar.h);
        Handler handlerA = jVar.a();
        l lVar = (l) p.a.a(LinkUtils.INSTANCE.getParamFromLink(uri), l.class);
        String strC = lVar != null ? lVar.c() : null;
        if (strC == null || strC.length() == 0) {
            return;
        }
        jVar.e = 0;
        handlerA.sendMessage(handlerA.obtainMessage(1, lVar));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public synchronized void addDataObserver(IDataObserver iDataObserver) {
        if (this.y == null) {
            this.y = new h1();
        }
        this.y.a(iDataObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventJsonObserver(IEventJsonObserver iEventJsonObserver) {
        this.c.a(iEventJsonObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver) {
        this.c.a(iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.c.a(iEventObserver);
        this.c.a(iPresetEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return this.j.a(this.p != null ? this.p.e() : null, str, z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addSessionHook(ISessionObserver iSessionObserver) {
        this.b.a(iSessionObserver);
    }

    public boolean b() {
        return this.G;
    }

    public final boolean b(String str) {
        return r.b(this.q, "Call " + str + " before please initialize first");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void bind(Map<String, String> map, IDBindCallback iDBindCallback) {
        if (b("bind")) {
            return;
        }
        e0 e0Var = this.q;
        if (map == null) {
            e0Var.d.D.warn("BindID identities is null", new Object[0]);
        } else {
            e0Var.G.a(map, iDBindCallback);
        }
    }

    public final void c() {
        i5<String> i5Var = this.H;
        if (i5Var.b && !r.a(i5Var.a, this.o.g())) {
            this.p.i(this.H.a);
            IAppLogLogger iAppLogLogger = this.D;
            StringBuilder sbA = com.bytedance.bdtracker.a.a("postSetUuidAfterDm uuid -> ");
            sbA.append(this.H.a);
            iAppLogLogger.debug(sbA.toString(), new Object[0]);
            this.p.h("");
        }
        i5<String> i5Var2 = this.I;
        if (!i5Var2.b || r.a(i5Var2.a, this.o.h())) {
            return;
        }
        this.p.j(this.I.a);
        IAppLogLogger iAppLogLogger2 = this.D;
        StringBuilder sbA2 = com.bytedance.bdtracker.a.a("postSetUuidAfterDm uuid -> ");
        sbA2.append(this.I.a);
        iAppLogLogger2.debug(sbA2.toString(), new Object[0]);
        this.p.h("");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearAbTestConfigsCache() {
        if (this.p != null) {
            this.p.a();
        } else {
            new l0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearDb() {
        if (this.q == null) {
            new l0().initCause(new AssertionError("clearDb before init")).printStackTrace();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.D.debug("Start to clear db data...", new Object[0]);
        this.q.c().a();
        this.D.debug("Db data cleared", new Object[0]);
        o2.a(getMonitor(), "api_usage", "clearDb", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void flush() {
        if (b("flush")) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.q.a((String[]) null, true);
        o2.a(getMonitor(), "api_usage", "flush", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IALinkListener getALinkListener() {
        return this.z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getAbConfig(String str, T t) {
        if (a("getAbConfig")) {
            return null;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        w1 w1Var = this.p;
        JSONObject jSONObjectOptJSONObject = w1Var.c.a().optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("vid");
            Object objOpt = jSONObjectOptJSONObject.opt("val");
            w1Var.a(strOptString);
            InitConfig initConfig = w1Var.i.getInitConfig();
            if (initConfig != null) {
                if (initConfig.isAbTestExposureEventRepeatEnabled()) {
                    w1Var.e(strOptString);
                } else if (!w1Var.m.contains(strOptString)) {
                    w1Var.m.add(strOptString);
                    w1Var.e(strOptString);
                }
            }
            T t2 = objOpt != 0 ? objOpt : null;
            if (t2 != null) {
                t = t2;
            }
        }
        o2.a(getMonitor(), "api_usage", "getAbConfig", jElapsedRealtime);
        return t;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAbSdkVersion() {
        return a("getAbSdkVersion") ? "" : this.p.b();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IActiveCustomParamsCallback getActiveCustomParams() {
        return this.A;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public String getAid() {
        return this.m;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getAllAbTestConfigs() {
        return this.q == null ? new JSONObject() : this.q.e.a();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public f getAppContext() {
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAppId() {
        return this.m;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getClientUdid() {
        return a("getClientUdid") ? "" : this.p.d.optString("clientudid", "");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Context getContext() {
        return this.n;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDeepLinkUrl() {
        if (this.q != null) {
            return this.q.B.h;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDid() {
        if (a("getDid")) {
            return "";
        }
        String strC = this.p.c();
        return !TextUtils.isEmpty(strC) ? strC : this.p.d.optString("device_id", "");
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getEncryptAndCompress() {
        return this.E;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public e1 getEventFilterByClient() {
        return this.w;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IEventHandler getEventHandler() {
        return this.C;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getExternalAbVersion() {
        if (a("setExternalAbVersion")) {
            return null;
        }
        return this.o.d();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getHeader() {
        if (a("getHeader")) {
            return null;
        }
        return this.p.e();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return this.v;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (a("getHeaderValue")) {
            return null;
        }
        return (T) this.p.a(str, (String) t, (Class<String>) cls);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getIid() {
        return a("getIid") ? "" : this.p.f();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public InitConfig getInitConfig() {
        if (this.o != null) {
            return this.o.c;
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int getLaunchFrom() {
        return this.l;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public l2 getMonitor() {
        if (b("getMonitor")) {
            return null;
        }
        return this.q.q;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public INetworkClient getNetClient() {
        if (this.t != null) {
            return this.t;
        }
        if (getInitConfig() != null && getInitConfig().getNetworkClient() != null) {
            return getInitConfig().getNetworkClient();
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new g3(this.k);
            }
        }
        return this.t;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getOpenUdid() {
        return a("getOpenUdid") ? "" : this.p.g();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public Map<String, String> getRequestHeader() {
        if (this.o == null) {
            return Collections.EMPTY_MAP;
        }
        String string = this.o.f.getString("device_token", "");
        HashMap map = new HashMap();
        map.put("x-tt-dt", string != null ? string : "");
        return map;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSdkVersion() {
        return "6.17.4";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSessionId() {
        return this.q != null ? this.q.d() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSsid() {
        return a("getSsid") ? "" : this.p.i();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void getSsidGroup(Map<String, String> map) {
        String did = getDid();
        if (!TextUtils.isEmpty(did)) {
            map.put("device_id", did);
        }
        String iid = getIid();
        if (!TextUtils.isEmpty(iid)) {
            map.put("install_id", iid);
        }
        String openUdid = getOpenUdid();
        if (!TextUtils.isEmpty(openUdid)) {
            map.put("openudid", openUdid);
        }
        String clientUdid = getClientUdid();
        if (TextUtils.isEmpty(clientUdid)) {
            return;
        }
        map.put("clientudid", clientUdid);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public String getUdid() {
        return a("getUdid") ? "" : this.p.j();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public UriConfig getUriRuntime() {
        if (b("getUriRuntime")) {
            return null;
        }
        return this.q.e();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserID() {
        if (b("getUserID")) {
            return null;
        }
        return String.valueOf(this.q.n.a);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserUniqueID() {
        return a("getUserUniqueID") ? "" : this.p.k();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public ViewExposureManager getViewExposureManager() {
        return this.s;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getViewProperties(View view) {
        if (view != null) {
            return this.a.get(r.b(view));
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean hasStarted() {
        return this.u;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClick(View view) {
        if (view == null) {
            return;
        }
        this.g.add(r.b(view));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackClickByViewType(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        this.h.addAll(Arrays.asList(clsArr));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void ignoreAutoTrackPage(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                Iterator<Class<?>> it = l5.c.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().isAssignableFrom(cls)) {
                            break;
                        }
                    } else {
                        Iterator<Class<?>> it2 = l5.d.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().isAssignableFrom(cls)) {
                            }
                        }
                        this.D.warn("{} is not a page class", cls);
                    }
                }
                String canonicalName = cls.getCanonicalName();
                if (!TextUtils.isEmpty(canonicalName)) {
                    this.f.add(Integer.valueOf(canonicalName.hashCode()));
                }
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig) {
        String str;
        ILogProcessor k1Var;
        synchronized (d.class) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String aid = initConfig.getAid();
            if (r.c(aid)) {
                Log.e("AppLog", "Init failed. App id must not be empty!");
            } else if (r.c(initConfig.getChannel())) {
                Log.e("AppLog", "Channel must not be empty!");
            } else {
                if (!com.bytedance.bdtracker.b.c(aid)) {
                    this.D.setAppId(aid);
                    this.m = aid;
                    this.n = (Application) context.getApplicationContext();
                    if (initConfig.isLogEnable()) {
                        if (initConfig.getLogger() != null) {
                            str = this.m;
                            k1Var = new l1(initConfig.getLogger());
                        } else {
                            str = this.m;
                            k1Var = new k1(this);
                        }
                        LogProcessorHolder.setProcessor(str, k1Var);
                    }
                    this.D.info("AppLog init begin...", new Object[0]);
                    if (!initConfig.isMonitorEnabled() && !n2.a(initConfig) && initConfig.getUriConfig() == null) {
                        initConfig.setMonitorEnabled(true);
                    }
                    initMetaSec(context);
                    if (TextUtils.isEmpty(initConfig.getSpName())) {
                        initConfig.setSpName(com.bytedance.bdtracker.b.a(this, "applog_stats"));
                    }
                    synchronized (this.J) {
                        this.o = new u1(this, this.n, initConfig);
                        this.p = new w1(this, this.n, this.o);
                        c();
                        this.q = new e0(this, this.o, this.p, this.e);
                    }
                    if (!LogUtils.isDisabled()) {
                        LogUtils.sendJsonFetcher("init_begin", new e(this, initConfig));
                    }
                    this.r = w.a(this.n);
                    this.s = new ViewExposureManager(this);
                    if (AppCrashType.hasJavaCrashType(initConfig.getTrackCrashType()) || initConfig.isMonitorEnabled()) {
                        m0.a();
                    }
                    this.l = 1;
                    this.u = initConfig.autoStart();
                    LogUtils.sendString("init_end", this.m);
                    this.D.info("AppLog init end", new Object[0]);
                    if (r.a(SimulateLaunchActivity.entryAppId, this.m)) {
                        c4.a(this);
                    }
                    this.o.n();
                    l2 monitor = getMonitor();
                    Intrinsics.checkParameterIsNotNull("sdk_init", "metricsName");
                    o2.a(monitor, "sdk_init", (String) null, jElapsedRealtime);
                    this.q.h();
                    return;
                }
                Log.e("AppLog", "The app id: " + aid + " has initialized already");
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig, Activity activity) {
        init(context, initConfig);
        if (this.r == null || activity == null) {
            return;
        }
        this.r.onActivityCreated(activity, null);
        this.r.onActivityStarted(activity);
        this.r.onActivityResumed(activity);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initH5Bridge(View view, String str) {
        Class<?> clsB = r.b("com.bytedance.applog.tracker.WebViewUtil");
        if (clsB == null) {
            this.D.warn("No WebViewUtil class, and will not initialize h5 bridge", new Object[0]);
            return;
        }
        try {
            Method declaredMethod = clsB.getDeclaredMethod("injectWebViewBridges", View.class, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, view, str);
        } catch (Throwable th) {
            this.D.error("Initialize h5 bridge failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initMetaSec(Context context) {
        if (getInitConfig() == null || getInitConfig().isMetaSecEnabled()) {
            Class<?> clsB = r.b("com.bytedance.applog.metasec.AppLogSecHelper");
            if (clsB == null) {
                this.D.debug("No AppLogSecHelper class, and will not init", new Object[0]);
                return;
            }
            try {
                Method declaredMethod = clsB.getDeclaredMethod("init", IAppLogInstance.class, Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, this, context);
            } catch (Throwable th) {
                this.D.error("Initialize AppLogSecHelper failed", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initWebViewBridge(View view, String str) {
        Class<?> clsB = r.b("com.bytedance.applog.tracker.WebViewUtil");
        if (clsB != null) {
            try {
                clsB.getMethod("injectWebViewBridges", View.class, String.class).invoke(null, view, str);
            } catch (Throwable th) {
                this.D.error("Init webview bridge failed", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackClickIgnored(View view) {
        if (view == null) {
            return false;
        }
        if (this.g.contains(r.b(view))) {
            return true;
        }
        Iterator<Class<?>> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isAutoTrackPageIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        String canonicalName = cls.getCanonicalName();
        if (TextUtils.isEmpty(canonicalName)) {
            return false;
        }
        return this.f.contains(Integer.valueOf(canonicalName.hashCode()));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isBavEnabled() {
        return this.q != null && this.q.g();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5BridgeEnable() {
        return getInitConfig() != null && getInitConfig().isH5BridgeEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isH5CollectEnable() {
        return getInitConfig() != null && getInitConfig().isH5CollectEnable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUser() {
        if (a("isNewUser")) {
            return false;
        }
        return this.p.e;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isPrivacyMode() {
        return this.x;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean manualActivate() {
        if (b("manualActivate")) {
            return false;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zA = this.q.a(false);
        o2.a(getMonitor(), "api_usage", "manualActivate", jElapsedRealtime);
        return zA;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public EventBuilder newEvent(String str) {
        return new EventBuilder(this).setEvent(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityPause() {
        if (this.r != null) {
            this.r.onActivityPaused(null);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityResumed(Activity activity, int i) {
        if (this.r != null) {
            this.r.a(activity, i);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str) {
        onEventV3(str, (JSONObject) null, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle) {
        onEventV3(str, bundle, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3(str, jSONObject, 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            this.D.warn("call onMiscEvent with invalid params", new Object[0]);
            return;
        }
        this.D.debug(Arrays.asList("customEvent", "miscEvent"), "logType:{} params:{} ", str, jSONObject.toString());
        try {
            jSONObject.put("log_type", str);
            receive(new h4("log_data", jSONObject));
        } catch (Throwable th) {
            this.D.error("call onMiscEvent error", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed((Activity) context, context.hashCode());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pauseDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (r.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (r.b(k0Var, "No duration event with name: " + str)) {
            return;
        }
        k0Var.a(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileAppend(JSONObject jSONObject) {
        if (b("profileAppend") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectA = r.a(jSONObject);
        try {
            if (!r.a(jSONObjectA, (Class<?>[]) new Class[]{String.class, Integer.class}, (Class<?>[]) new Class[]{String.class})) {
                this.D.warn("only support String、Int、String Array！", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        t5.a(this.D, jSONObjectA);
        this.q.b(jSONObjectA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileIncrement(JSONObject jSONObject) {
        if (b("profileIncrement") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectA = r.a(jSONObject);
        try {
            if (!r.a(jSONObjectA, (Class<?>[]) new Class[]{Integer.class}, (Class<?>[]) null)) {
                this.D.warn("only support Int param", new Object[0]);
                return;
            }
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        t5.a(this.D, jSONObjectA);
        this.q.c(jSONObjectA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSet(JSONObject jSONObject) {
        if (b("profileSet") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectA = r.a(jSONObject);
        t5.a(this.D, jSONObjectA);
        this.q.d(jSONObjectA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileSetOnce(JSONObject jSONObject) {
        if (b("profileSetOnce") || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectA = r.a(jSONObject);
        t5.a(this.D, jSONObjectA);
        this.q.e(jSONObjectA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void profileUnset(String str) {
        if (b("profileUnset")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, "");
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        t5.a(this.D, jSONObject);
        this.q.f(jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pullAbTestConfigs() {
        pullAbTestConfigs(-1, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void pullAbTestConfigs(int i, IPullAbTestConfigCallback iPullAbTestConfigCallback) {
        if (this.q == null) {
            new l0().initCause(new AssertionError("Please initialize first")).printStackTrace();
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = this.q.a - Math.abs(jCurrentTimeMillis - this.F);
        if (jAbs < 0) {
            this.F = jCurrentTimeMillis;
            Handler handler = this.q.p;
            handler.sendMessage(handler.obtainMessage(18, i, -1, iPullAbTestConfigCallback));
        } else if (iPullAbTestConfigCallback != null) {
            iPullAbTestConfigCallback.onThrottle(jAbs);
        } else {
            this.D.warn("Pull ABTest config too frequently", new Object[0]);
        }
        o2.a(getMonitor(), "api_usage", "pullAbTestConfigs", jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        this.j.a(this.p != null ? this.p.e() : null, z, map, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(e4 e4Var) {
        if (e4Var == null) {
            return;
        }
        e4Var.m = this.m;
        if (this.q == null) {
            this.e.a(e4Var);
        } else {
            this.q.a(e4Var);
        }
        LogUtils.sendObject("event_receive", e4Var);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        this.v = iHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeAllDataObserver() {
        h1 h1Var = this.y;
        if (h1Var != null) {
            h1Var.a.clear();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeDataObserver(IDataObserver iDataObserver) {
        h1 h1Var = this.y;
        if (h1Var != null) {
            h1Var.b(iDataObserver);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
        this.c.b(iEventObserver);
        this.c.b(iPresetEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeHeaderInfo(String str) {
        if (a("removeHeaderInfo")) {
            return;
        }
        this.D.debug("call removeHeaderInfo isMainProcess: {}, key: {}", Boolean.valueOf(this.o.j()), str);
        if (this.o.j()) {
            this.p.d(str);
            return;
        }
        try {
            c(str);
        } catch (Throwable th) {
            this.D.debug("call removeHeaderInfo Post Main Process failed.", th);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeJsonEventObserver(IEventJsonObserver iEventJsonObserver) {
        this.c.b(iEventJsonObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeJsonEventObserver(IEventObserver iEventObserver) {
        this.c.b(iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeOaidObserver(IOaidObserver iOaidObserver) {
        y5.b(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeSessionHook(ISessionObserver iSessionObserver) {
        this.b.b(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public boolean reportPhoneDetailInfo() {
        return this.p != null && this.p.r();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void resumeDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (r.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (r.b(k0Var, "No duration event with name: " + str)) {
            return;
        }
        k0Var.b(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setALinkListener(IALinkListener iALinkListener) {
        this.z = iALinkListener;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void setAccount(Account account) {
        if (a("setAccount")) {
            return;
        }
        y1 y1VarA = this.p.i.a();
        if (!(y1VarA.a instanceof e5)) {
            y1VarA.b = account;
            return;
        }
        d4 d4Var = y1VarA.a.c;
        if (d4Var != null) {
            d4Var.a(account);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setActiveCustomParams(IActiveCustomParamsCallback iActiveCustomParamsCallback) {
        this.A = iActiveCustomParamsCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void setAppContext(f fVar) {
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppLanguageAndRegion(String str, String str2) {
        boolean z;
        if (b("setAppLanguageAndRegion")) {
            return;
        }
        e0 e0Var = this.q;
        w1 w1Var = e0Var.i;
        boolean z2 = true;
        if (w1Var.a("app_language", (Object) str)) {
            w1Var.c.f.putString("app_language", str);
            z = true;
        } else {
            z = false;
        }
        w1 w1Var2 = e0Var.i;
        if (w1Var2.a("app_region", (Object) str2)) {
            w1Var2.c.f.putString("app_region", str2);
        } else {
            z2 = false;
        }
        if (z || z2) {
            e0Var.a(e0Var.k);
            e0Var.a(e0Var.f);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null || a("setAppTrack")) {
            return;
        }
        w1 w1Var = this.p;
        if (w1Var.a("app_track", jSONObject)) {
            u1 u1Var = w1Var.c;
            u1Var.d.putString("app_track", jSONObject.toString());
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setClipboardEnabled(boolean z) {
        if (b("setClipboardEnabled")) {
            return;
        }
        this.q.B.a = z;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new c(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEncryptAndCompress(boolean z) {
        this.E = z;
        if (!r.d(this.m) || LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new a(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventFilterByClient(List<String> list, boolean z) {
        e1 g1Var = null;
        if (list != null && !list.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                g1Var = z ? new g1(hashSet, null) : new f1(hashSet, null);
            }
        }
        this.w = g1Var;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventHandler(IEventHandler iEventHandler) {
        this.C = iEventHandler;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExternalAbVersion(String str) {
        if (a("setExternalAbVersion")) {
            return;
        }
        this.p.g(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void setExtraParams(IExtraParams iExtraParams) {
        this.j.a = iExtraParams;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void setForbidReportPhoneDetailInfo(boolean z) {
        if (a("setForbidReportPhoneDetailInfo")) {
            return;
        }
        w1 w1Var = this.p;
        w1Var.l = z;
        if (!w1Var.r()) {
            w1Var.a("sim_serial_number", (Object) null);
        }
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new b(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGPSLocation(float f, float f2, String str) {
        if (this.p == null) {
            this.D.warn("Please initialize first", new Object[0]);
        } else {
            this.B = new s(f, f2, str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGoogleAid(String str) {
        if (a("setGoogleAid")) {
            return;
        }
        w1 w1Var = this.p;
        if (w1Var.a("google_aid", (Object) str)) {
            w1Var.c.f.putString("google_aid", str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(String str, Object obj) {
        if (a("setHeaderInfo")) {
            return;
        }
        this.D.debug("call setHeaderInfo isMainProcess: {}, key: {}, value: {}", Boolean.valueOf(this.o.j()), str, obj);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.o.j()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(str, obj);
            t5.a(this.D, map);
            this.p.a(map);
            return;
        }
        try {
            a(str, obj);
        } catch (Throwable th) {
            this.D.debug("call setHeaderInfo Post Main Process failed.", th);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLaunchFrom(int i) {
        this.l = i;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setOaidObserver(IOaidObserver iOaidObserver) {
        y5.a(iOaidObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPrivacyMode(boolean z) {
        this.x = z;
        if (!r.d(this.m) || LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new C0001d(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPullAbTestConfigsThrottleMills(Long l) {
        if (this.q != null) {
            this.q.a(l);
        } else {
            new l0().initCause(new AssertionError("Please initialize first")).printStackTrace();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setRangersEventVerifyEnable(boolean z, String str) {
        if (b("setRangersEventVerifyEnable")) {
            return;
        }
        e0 e0Var = this.q;
        e0Var.j.removeMessages(15);
        e0Var.j.obtainMessage(15, new Object[]{Boolean.valueOf(z), str}).sendToTarget();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTouchPoint(String str) {
        setHeaderInfo("touch_point", str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTracerData(JSONObject jSONObject) {
        if (a("setTracerData")) {
            return;
        }
        this.p.a("tracer_data", jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUriRuntime(UriConfig uriConfig) {
        if (b("setUriRuntime")) {
            return;
        }
        e0 e0Var = this.q;
        e0Var.o = uriConfig;
        e0Var.a(e0Var.k);
        if (e0Var.e.c.isAutoActive()) {
            e0Var.a(true);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserAgent(String str) {
        if (a("setUserAgent")) {
            return;
        }
        w1 w1Var = this.p;
        if (w1Var.a("user_agent", (Object) str)) {
            w1Var.c.f.putString("user_agent", str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserID(long j) {
        if (b("setUserID")) {
            return;
        }
        this.q.n.a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str) {
        if (this.p != null) {
            setUserUniqueID(str, this.p.l());
            return;
        }
        i5<String> i5Var = this.H;
        i5Var.a = str;
        i5Var.b = true;
        this.D.debug(com.bytedance.bdtracker.a.a("cache uuid before init id -> ", str), new Object[0]);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Dialog dialog, String str) {
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        dialog.getWindow().getDecorView().setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(View view, String str) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.applog_tag_view_id, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewId(Object obj, String str) {
        if (obj == null) {
            return;
        }
        if (!r.a(obj, "android.support.v7.app.AlertDialog", "androidx.appcompat.app.AlertDialog")) {
            this.D.warn("Only support AlertDialog view", new Object[0]);
            return;
        }
        try {
            Class[] clsArr = new Class[0];
            Window window = (Window) obj.getClass().getMethod("getWindow", null).invoke(obj, null);
            if (window != null) {
                window.getDecorView().setTag(R.id.applog_tag_view_id, str);
            }
        } catch (NoSuchMethodException e) {
            this.D.error("Not found getWindow method in alertDialog", e, new Object[0]);
        } catch (Throwable th) {
            this.D.error("Cannot set viewId for alertDialog", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view == null || jSONObject == null) {
            return;
        }
        this.a.put(r.b(view), jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void start() {
        if (b("start") || this.u) {
            return;
        }
        this.u = true;
        e0 e0Var = this.q;
        if (e0Var.r) {
            return;
        }
        e0Var.i();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void startDurationEvent(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (r.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (k0Var == null) {
            k0Var = new k0(this.D, str);
            this.i.put(str, k0Var);
        }
        k0Var.c(jElapsedRealtime);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void startSimulator(String str) {
        if (b("startSimulator")) {
            return;
        }
        e0 e0Var = this.q;
        c0 c0Var = e0Var.s;
        if (c0Var != null) {
            c0Var.setStop(true);
        }
        Class<?> clsB = r.b("com.bytedance.applog.picker.DomSender");
        if (clsB != null) {
            try {
                e0Var.s = (c0) clsB.getConstructor(e0.class, String.class).newInstance(e0Var, str);
                e0Var.j.sendMessage(e0Var.j.obtainMessage(9, e0Var.s));
            } catch (Throwable th) {
                e0Var.d.D.error("Start simulator failed.", th, new Object[0]);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void stopDurationEvent(String str, JSONObject jSONObject) {
        stopDurationEvent(str, jSONObject, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void stopDurationEvent(String str, JSONObject jSONObject, String str2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (r.a(TextUtils.isEmpty(str), "Event name must not empty!")) {
            return;
        }
        k0 k0Var = this.i.get(str);
        if (r.b(k0Var, "No duration event with name: " + str)) {
            return;
        }
        long j = 0;
        if (jElapsedRealtime <= 0) {
            IAppLogLogger iAppLogLogger = k0Var.a;
            if (iAppLogLogger != null) {
                iAppLogLogger.warn(4, "End at illegal time: " + jElapsedRealtime, new Object[0]);
            }
        } else {
            k0Var.a(jElapsedRealtime);
            IAppLogLogger iAppLogLogger2 = k0Var.a;
            if (iAppLogLogger2 != null) {
                iAppLogLogger2.debug(4, "[DurationEvent:{}] End[ at:{} and duration is {}ms", k0Var.b, Long.valueOf(jElapsedRealtime), Long.valueOf(k0Var.d));
            }
            j = k0Var.d;
        }
        JSONObject jSONObject2 = new JSONObject();
        r.c(jSONObject, jSONObject2);
        try {
            jSONObject2.put("$event_duration", j);
        } catch (Throwable th) {
            this.D.error("JSON handle failed", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str2)) {
            this.D.info(com.bytedance.bdtracker.a.a("CustomEventName is empty, use eventName, finalEventName: {}", str), new Object[0]);
            str2 = str;
        }
        receive(new l4(str2, jSONObject2));
        this.i.remove(str);
    }

    public String toString() {
        StringBuilder sbA = com.bytedance.bdtracker.a.a("AppLogInstance{id:");
        sbA.append(L.get());
        sbA.append(";appId:");
        sbA.append(this.m);
        sbA.append("}@");
        sbA.append(hashCode());
        return sbA.toString();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view) {
        trackClick(view, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackClick(View view, JSONObject jSONObject) {
        g4 g4VarA = r.a(view, false);
        if (g4VarA != null && jSONObject != null) {
            g4VarA.o = jSONObject;
        }
        receive(g4VarA);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity) {
        trackPage(activity, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Activity activity, JSONObject jSONObject) {
        a(activity, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj) {
        trackPage(obj, (JSONObject) null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void trackPage(Object obj, JSONObject jSONObject) {
        a(obj, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void userProfileSetOnce(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (b("userProfileSetOnce")) {
            return;
        }
        e0 e0Var = this.q;
        if (e0Var.j != null) {
            v3.a(e0Var, 0, jSONObject, userProfileCallback, e0Var.j, false);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    @Deprecated
    public void userProfileSync(JSONObject jSONObject, UserProfileCallback userProfileCallback) {
        if (b("userProfileSync")) {
            return;
        }
        e0 e0Var = this.q;
        if (e0Var.j != null) {
            v3.a(e0Var, 1, jSONObject, userProfileCallback, e0Var.j, false);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        this.D.error("Parse event params failed", th, new Object[0]);
                        onEventV3(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3(str, jSONObject, i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject, int i) {
        if (TextUtils.isEmpty(str)) {
            this.D.error("event name is empty", new Object[0]);
            return;
        }
        JSONObject jSONObjectA = r.a(jSONObject);
        this.D.debug(Arrays.asList("customEvent", "eventV3"), "[event_process] event:{} type:{} params:{} ", str, Integer.valueOf(i), jSONObjectA != null ? jSONObjectA.toString() : null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        t5.a(this.D, str, jSONObjectA);
        receive(new l4(this.m, str, false, jSONObjectA != null ? jSONObjectA.toString() : null, i));
        l2 monitor = getMonitor();
        String sessionId = getSessionId();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        z2 z2Var = new z2();
        z2Var.a = "onEventV3";
        z2Var.b = jElapsedRealtime2 - jElapsedRealtime;
        if (monitor != null) {
            ((q2) monitor).a(z2Var);
        }
        if (monitor != null) {
            if (sessionId == null) {
                sessionId = "";
            }
            ((q2) monitor).a(new x2(0L, sessionId, 1L));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
        }
        if (this.q == null) {
            this.e.a(strArr);
            return;
        }
        e0 e0Var = this.q;
        e0Var.p.removeMessages(4);
        e0Var.p.obtainMessage(4, strArr).sendToTarget();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str, String str2) {
        synchronized (this.J) {
            if (this.p == null) {
                i5<String> i5Var = this.H;
                i5Var.a = str;
                i5Var.b = true;
                this.D.debug("cache uuid before init id -> " + str, new Object[0]);
                i5<String> i5Var2 = this.I;
                i5Var2.a = str2;
                i5Var2.b = true;
                this.D.debug("cache uuid before init type -> " + str2, new Object[0]);
            } else {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.q.a(str, str2);
                o2.a(getMonitor(), "api_usage", "setUserUniqueID", jElapsedRealtime);
            }
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(HashMap<String, Object> map) {
        if (a("setHeaderInfo")) {
            return;
        }
        t5.a(this.D, map);
        this.p.a(map);
    }

    public final void a(Object obj, JSONObject jSONObject) {
        if (this.r == null || obj == null) {
            return;
        }
        l4 l4Var = new l4("bav2b_page", true);
        JSONObject jSONObject2 = new JSONObject();
        String name = obj.getClass().getName();
        boolean z = false;
        if (l5.f(obj)) {
            Activity activity = null;
            try {
                Class[] clsArr = new Class[0];
                activity = (Activity) obj.getClass().getMethod("getActivity", null).invoke(obj, null);
            } catch (Throwable unused) {
            }
            if (activity != null) {
                name = activity.getClass().getName() + ":" + name;
            }
            z = true;
        }
        try {
            jSONObject2.put("page_key", name);
            jSONObject2.put("is_fragment", z);
            jSONObject2.put("duration", 1000L);
            jSONObject2.put("page_title", l5.d(obj));
            jSONObject2.put("page_path", l5.c(obj));
            jSONObject2.put("is_custom", true);
            r.c(jSONObject, jSONObject2);
        } catch (Throwable unused2) {
        }
        l4Var.o = jSONObject2;
        receive(l4Var);
    }

    public final void c(String str) {
        InitConfig initConfig = getInitConfig();
        if (initConfig != null && initConfig.getProcess() == 2) {
            Intent intent = new Intent(this.n, (Class<?>) Collector.class);
            intent.putExtra("K_APP_ID", this.m);
            intent.putExtra("K_CUSTOM_HEADER_KEY", str);
            intent.putExtra("K_REMOVE_CUSTOM_HEADER", true);
            this.n.sendBroadcast(intent);
            return;
        }
        this.D.warn("call removeHeaderInfo process unknown.", new Object[0]);
    }
}
