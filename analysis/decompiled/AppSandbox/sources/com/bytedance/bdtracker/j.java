package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.applog.IDataObserver;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.alink.IALinkListener;
import com.bytedance.applog.alink.util.LinkUtils;
import com.bytedance.applog.log.IAppLogLogger;
import com.stepos.cloudsdk.Constants;
import com.stepos.pps.logpull.LogPullAuthActivity;
import com.stepos.pps.reflect.ExceptionManagerStepOS;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0003J\u0010\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020\u0014H\u0003J\u0012\u0010)\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\n .*\u0004\u0018\u00010-0-H\u0002J\u0006\u0010/\u001a\u00020 J\u0018\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u000105J \u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0016J\u0018\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020=H\u0016J\u001a\u0010>\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\b\u0010?\u001a\u0004\u0018\u00010=H\u0016JB\u0010@\u001a\u00020 2\u0006\u0010;\u001a\u00020\u00142\b\u0010A\u001a\u0004\u0018\u00010\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bH\u0016J\u000e\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/applog/alink/ALinkManager;", "Landroid/os/Handler$Callback;", "Lcom/bytedance/applog/IDataObserver;", "engine", "Lcom/bytedance/applog/engine/Engine;", "(Lcom/bytedance/applog/engine/Engine;)V", "TRACE_DATA_ATTRS", "", "", "UTM_ATTRS", "apiService", "Lcom/bytedance/applog/alink/network/ApiService;", "cache", "Lcom/bytedance/applog/alink/ALinkCache;", "deepLinkUrl", "getDeepLinkUrl", "()Ljava/lang/String;", "setDeepLinkUrl", "(Ljava/lang/String;)V", "mClipboardEnable", "", "mDeepLinkRetryCount", "", "mEngine", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "maxDeepLinkRetryCount", "destroy", "", "doDeepLinked", "queryParam", "Lcom/bytedance/applog/alink/model/ALinkQueryParam;", "doDeferDeepLink", "exitsAppCache", "fillALinkQueryParams", "fillAttributionRequest", "Lcom/bytedance/applog/alink/model/AttributionRequest;", "handleMessage", "msg", "Landroid/os/Message;", "logger", "Lcom/bytedance/applog/log/IAppLogLogger;", "kotlin.jvm.PlatformType", "mergeTracerData", "onAbVidsChange", "vids", "extVids", "onDeepLinked", "uri", "Landroid/net/Uri;", "onIdLoaded", "did", "iid", "ssid", "onRemoteAbConfigGet", "changed", "abConfig", "Lorg/json/JSONObject;", "onRemoteConfigGet", Constants.PATH_CONFIG, "onRemoteIdGet", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "setClipboardEnabled", "clipboardEnable", "Companion", "agent_pickerChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class j implements Handler.Callback, IDataObserver {
    public static final /* synthetic */ KProperty[] k = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(j.class), "mHandler", "getMHandler()Landroid/os/Handler;"))};
    public boolean a;
    public final Lazy b;
    public e0 c;
    public h d;
    public int e;
    public q f;
    public int g;
    public String h;
    public final List<String> i;
    public final List<String> j;

    public static final class a extends Lambda implements Function0<Handler> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_alink");
            handlerThread.start();
            return new Handler(handlerThread.getLooper(), j.this);
        }
    }

    public j(e0 engine) {
        Intrinsics.checkParameterIsNotNull(engine, "engine");
        this.b = LazyKt.lazy(new a());
        this.c = engine;
        this.g = 10;
        this.i = CollectionsKt.listOf((Object[]) new String[]{"utm_campaign", "utm_source", "utm_term", "utm_medium", "utm_content"});
        this.j = CollectionsKt.listOf((Object[]) new String[]{"tr_shareuser", "tr_admaster", "tr_param1", "tr_param2", "tr_param3", "tr_param4", "reengagement_window", "reengagement_time", "is_retargeting"});
        String spName = b.a(engine.d, "ALINK_CACHE_SP");
        u1 u1Var = engine.e;
        Intrinsics.checkExpressionValueIsNotNull(u1Var, "engine.config");
        InitConfig initConfig = u1Var.c;
        Intrinsics.checkExpressionValueIsNotNull(initConfig, "engine.config.initConfig");
        Context contextB = engine.b();
        Intrinsics.checkExpressionValueIsNotNull(contextB, "engine.context");
        Intrinsics.checkExpressionValueIsNotNull(spName, "spName");
        this.d = new h(initConfig, contextB, spName);
        d dVar = engine.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar, "engine.appLog");
        this.f = new q(dVar);
    }

    public final Handler a() {
        Lazy lazy = this.b;
        KProperty kProperty = k[0];
        return (Handler) lazy.getValue();
    }

    public final IAppLogLogger b() {
        d dVar = this.c.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
        return dVar.D;
    }

    public final void c() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        k kVar = (k) this.d.a("deep_link", k.class);
        JSONObject jSONObjectA = kVar != null ? kVar.a() : null;
        if (jSONObjectA != null) {
            for (String str : this.i) {
                jSONObject2.put(str, jSONObjectA.optString(str, null));
            }
            for (String str2 : this.j) {
                if (Intrinsics.areEqual(str2, "is_retargeting")) {
                    jSONObject.put(str2, jSONObjectA.optBoolean(str2) ? 1 : 0);
                } else {
                    jSONObject.put(str2, jSONObjectA.optString(str2, null));
                }
            }
            w1 w1Var = this.c.i;
            if (w1Var != null) {
                w1Var.a("tracer_data", jSONObject);
            }
            w1 w1Var2 = this.c.i;
            if (w1Var2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    w1Var2.a(next, (Object) jSONObject2.optString(next));
                }
            }
        }
        String strA = this.d.a("tr_web_ssid");
        if (strA == null || strA.length() == 0) {
            return;
        }
        this.c.d.setHeaderInfo("$tr_web_ssid", strA);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) throws JSONException {
        String str;
        String str2;
        m<n> mVarA;
        String str3;
        String str4;
        k kVar;
        Integer numValueOf = msg != null ? Integer.valueOf(msg.what) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            w1 w1Var = this.c.i;
            if (w1Var == null || w1Var.h() != 0) {
                Object obj = msg.obj;
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.alink.model.ALinkQueryParam");
                }
                l lVar = (l) obj;
                String strC = lVar.c();
                if (strC != null && strC.length() != 0) {
                    lVar.l = com.stepos.pps.data.util.Constants.ANDROID_PACKAGE;
                    d dVar = this.c.d;
                    Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
                    lVar.a(dVar.m);
                    d dVar2 = this.c.d;
                    Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
                    lVar.b(dVar2.getDid());
                    d dVar3 = this.c.d;
                    Intrinsics.checkExpressionValueIsNotNull(dVar3, "mEngine.appLog");
                    lVar.c(dVar3.getSsid());
                    d dVar4 = this.c.d;
                    Intrinsics.checkExpressionValueIsNotNull(dVar4, "mEngine.appLog");
                    lVar.d(dVar4.getUserUniqueID());
                    w1 w1Var2 = this.c.i;
                    lVar.h = w1Var2 != null ? w1Var2.g() : null;
                    w1 w1Var3 = this.c.i;
                    lVar.i = w1Var3 != null ? w1Var3.j() : null;
                    w1 w1Var4 = this.c.i;
                    if (w1Var4 != null) {
                        str3 = null;
                        str4 = (String) w1Var4.a("device_model", (String) null, (Class<String>) String.class);
                    } else {
                        str3 = null;
                        str4 = null;
                    }
                    lVar.n = str4;
                    w1 w1Var5 = this.c.i;
                    lVar.m = w1Var5 != null ? (String) w1Var5.a("os_version", str3, (Class<String>) String.class) : str3;
                    w1 w1Var6 = this.c.i;
                    JSONObject jSONObject = w1Var6 != null ? (JSONObject) w1Var6.a(LogPullAuthActivity.EXTRA_OAID, str3, (Class<String>) JSONObject.class) : null;
                    lVar.j = jSONObject != null ? jSONObject.optString("id") : null;
                    w1 w1Var7 = this.c.i;
                    lVar.k = w1Var7 != null ? (String) w1Var7.a("google_aid", (String) null, (Class<String>) String.class) : null;
                    UriConfig uriConfigE = this.c.e();
                    Intrinsics.checkExpressionValueIsNotNull(uriConfigE, "mEngine.uriConfig");
                    String alinkQueryUri = uriConfigE.getAlinkQueryUri();
                    m<k> mVarA2 = alinkQueryUri != null ? this.f.a(alinkQueryUri, lVar) : null;
                    if (mVarA2 != null && (kVar = (k) mVarA2.a()) != null) {
                        kVar.t = strC;
                        this.d.a("deep_link", kVar, 2592000000L);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$link_type", "direct");
                        jSONObject2.put("$deeplink_url", this.h);
                        this.c.d.receive(new l4("$invoke", jSONObject2));
                        c();
                        d dVar5 = this.c.d;
                        Intrinsics.checkExpressionValueIsNotNull(dVar5, "mEngine.appLog");
                        IALinkListener iALinkListener = dVar5.z;
                        if (iALinkListener != null) {
                            iALinkListener.onALinkData(kVar.a(), null);
                        }
                    }
                }
                return true;
            }
            int i = this.e;
            if (i < this.g) {
                this.e = i + 1;
                b().debug(3, "Retry do deep link delay for the {} times...", Integer.valueOf(this.e));
                Handler handlerA = a();
                handlerA.sendMessageDelayed(handlerA.obtainMessage(msg.what, msg.obj), 500L);
            } else {
                b().warn(3, "Retried max times to do deep link until AppLog ready", new Object[0]);
            }
        } else if (numValueOf != null && numValueOf.intValue() == 0) {
            JSONObject paramFromClipboard = this.a ? LinkUtils.INSTANCE.getParamFromClipboard(this.c.b()) : new JSONObject();
            JSONObject jSONObject3 = paramFromClipboard;
            b().debug(3, "Start to do defer deeplink with data:{}...", paramFromClipboard);
            l lVar2 = (l) p.a.a(jSONObject3 != null ? jSONObject3 : new JSONObject(), l.class);
            if (lVar2 == null) {
                return true;
            }
            Object obj2 = msg.obj;
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
            }
            boolean zBooleanValue = ((Boolean) obj2).booleanValue();
            d dVar6 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar6, "mEngine.appLog");
            lVar2.a(dVar6.m);
            d dVar7 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar7, "mEngine.appLog");
            lVar2.b(dVar7.getDid());
            d dVar8 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar8, "mEngine.appLog");
            lVar2.c(dVar8.getSsid());
            d dVar9 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar9, "mEngine.appLog");
            lVar2.d(dVar9.getUserUniqueID());
            String strB = lVar2.b();
            if (strB != null && strB.length() != 0) {
                d dVar10 = this.c.d;
                String strB2 = lVar2.b();
                if (strB2 == null) {
                    strB2 = "";
                }
                if (!dVar10.a("setExternalAbVersion")) {
                    dVar10.p.g(strB2);
                }
            }
            String strD = lVar2.d();
            if (strD == null || strD.length() == 0) {
                str = "$invoke";
                str2 = "$link_type";
            } else {
                str = "$invoke";
                str2 = "$link_type";
                this.d.a("tr_web_ssid", lVar2.d(), 31536000000L);
            }
            UriConfig uriConfigE2 = this.c.e();
            Intrinsics.checkExpressionValueIsNotNull(uriConfigE2, "mEngine.uriConfig");
            String alinkAttributionUri = uriConfigE2.getAlinkAttributionUri();
            if (alinkAttributionUri != null) {
                q qVar = this.f;
                o oVar = new o();
                w1 w1Var8 = this.c.i;
                if (w1Var8 != null) {
                    oVar.b = w1Var8.c.b();
                    oVar.f = com.stepos.pps.data.util.Constants.ANDROID_PACKAGE;
                    oVar.e = w1Var8.f();
                    oVar.l = w1Var8.g();
                    oVar.m = w1Var8.j();
                    JSONObject jSONObject4 = (JSONObject) w1Var8.a(LogPullAuthActivity.EXTRA_OAID, (String) null, (Class<String>) JSONObject.class);
                    oVar.d = w1Var8.c();
                    oVar.n = jSONObject4 != null ? jSONObject4.optString("id") : null;
                    oVar.o = (String) w1Var8.a("google_aid", (String) null, (Class<String>) String.class);
                    oVar.q = (String) w1Var8.a("user_agent", (String) null, (Class<String>) String.class);
                    oVar.r = (String) w1Var8.a("device_model", (String) null, (Class<String>) String.class);
                    oVar.s = (String) w1Var8.a("os_version", (String) null, (Class<String>) String.class);
                    oVar.h = w1Var8.o();
                    oVar.i = zBooleanValue;
                    oVar.j = w1Var8.n();
                    oVar.k = (String) w1Var8.a("channel", (String) null, (Class<String>) String.class);
                    oVar.t = (String) w1Var8.a(ExceptionManagerStepOS.PACKAGE, (String) null, (Class<String>) String.class);
                }
                mVarA = qVar.a(alinkAttributionUri, oVar, lVar2);
            } else {
                mVarA = null;
            }
            n nVar = mVarA != null ? (n) mVarA.a() : null;
            if (nVar == null) {
                i iVar = i.a;
                d dVar11 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar11, "mEngine.appLog");
                IALinkListener iALinkListener2 = dVar11.z;
                if (iALinkListener2 == null) {
                    return true;
                }
                iALinkListener2.onAttributionFailedCallback(new IllegalStateException(iVar.invoke(mVarA != null ? mVarA.a : null)));
                return true;
            }
            if (!nVar.G) {
                d dVar12 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar12, "mEngine.appLog");
                IALinkListener iALinkListener3 = dVar12.z;
                if (iALinkListener3 == null) {
                    return true;
                }
                iALinkListener3.onAttributionFailedCallback(new IllegalStateException("DDL has data but not firstLaunch"));
                return true;
            }
            nVar.G = false;
            this.d.a("deferred_deep_link", nVar, -1L);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(str2, "deferred");
            this.c.d.receive(new l4(str, jSONObject5));
            d dVar13 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar13, "mEngine.appLog");
            IALinkListener iALinkListener4 = dVar13.z;
            if (iALinkListener4 == null) {
                return true;
            }
            iALinkListener4.onAttributionData(nVar.a(), null);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onAbVidsChange(String vids, String extVids) {
        Intrinsics.checkParameterIsNotNull(vids, "vids");
        Intrinsics.checkParameterIsNotNull(extVids, "extVids");
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onIdLoaded(String did, String iid, String ssid) {
        Intrinsics.checkParameterIsNotNull(did, "did");
        Intrinsics.checkParameterIsNotNull(iid, "iid");
        Intrinsics.checkParameterIsNotNull(ssid, "ssid");
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteAbConfigGet(boolean changed, JSONObject abConfig) {
        Intrinsics.checkParameterIsNotNull(abConfig, "abConfig");
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteConfigGet(boolean changed, JSONObject config) {
    }

    @Override // com.bytedance.applog.IDataObserver
    public void onRemoteIdGet(boolean changed, String oldDid, String newDid, String oldIid, String newIid, String oldSsid, String newSsid) {
        Intrinsics.checkParameterIsNotNull(newDid, "newDid");
        Intrinsics.checkParameterIsNotNull(oldIid, "oldIid");
        Intrinsics.checkParameterIsNotNull(newIid, "newIid");
        Intrinsics.checkParameterIsNotNull(oldSsid, "oldSsid");
        Intrinsics.checkParameterIsNotNull(newSsid, "newSsid");
        c();
        String strA = this.d.a("app_cache");
        boolean z = strA == null || strA.length() == 0;
        boolean z2 = !z;
        if (z) {
            this.d.a("app_cache", "app_cache", -1L);
        }
        if (z) {
            Handler handlerA = a();
            handlerA.sendMessage(handlerA.obtainMessage(0, Boolean.valueOf(z2)));
        }
        this.c.d.removeDataObserver(this);
    }
}
