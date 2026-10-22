package com.stepos.stepclaw;

import a6.f0;
import a6.i0;
import a6.r0;
import a6.x1;
import a6.z;
import android.app.Application;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import b5.a0;
import b5.e;
import b5.i;
import b5.l;
import b8.h;
import c5.t;
import com.stepos.stepclaw.base.framework.ServiceLocator;
import com.stepos.stepclaw.base.net.StepNet;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.base.net.StepOSHeadersProviderKt;
import com.stepos.stepclaw.base.net.StepOSProxyServer;
import com.stepos.stepclaw.base.net.bean.StepOSCredentials;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.base.util.StepAccount;
import com.stepos.stepclaw.bridge.memory.MemoryBridge;
import com.stepos.stepclaw.service.StepClawService;
import d5.g;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m0.f;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004*\u0001;\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J'\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u0003J\r\u0010\u001e\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u0011J\r\u0010\u001f\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010\u0011J\r\u0010 \u001a\u00020\n¢\u0006\u0004\b \u0010\u0011J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010#R\"\u00103\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010:\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00107R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/stepos/stepclaw/StepClawManager;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lb5/a0;", "registerObservers", "handleNetEnvChanged", "(Lf5/c;)Ljava/lang/Object;", "refreshLightMemConfig", "refreshSearchScoreThreshold", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "raw", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "parseScoreThresholds", "(Ljava/lang/String;)Ljava/util/Map;", "readModelName", "()Ljava/lang/String;", "readApiToken", "Landroid/app/Application;", "requireApp", "()Landroid/app/Application;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "debug", "setDebug", "(Z)V", "app", "init", "(Landroid/app/Application;)V", "destroy", "getModelName", "getApiToken", "getOAID", "getLocalAccountId", "TAG", "Ljava/lang/String;", "Lcom/stepos/stepclaw/bridge/memory/MemoryBridge;", "memory$delegate", "Lb5/e;", "getMemory", "()Lcom/stepos/stepclaw/bridge/memory/MemoryBridge;", "memory", "La6/f0;", "scope", "La6/f0;", "application", "Landroid/app/Application;", "initialized", "Z", "cachedModelName", "cachedApiToken", "cachedSearchScoreThresholds", "Ljava/util/Map;", "Landroid/net/Uri;", "NET_ENV_URI", "Landroid/net/Uri;", "MODEL_URI", "KEY_URI", "SEARCH_SCORE_THRESHOLD_URI", "com/stepos/stepclaw/StepClawManager$observer$1", "observer", "Lcom/stepos/stepclaw/StepClawManager$observer$1;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StepClawManager {
    private static final Uri KEY_URI;
    private static final Uri MODEL_URI;
    private static final Uri NET_ENV_URI;
    private static final Uri SEARCH_SCORE_THRESHOLD_URI;
    private static final String TAG = "StepClawManager";
    private static volatile Application application;
    private static volatile String cachedApiToken;
    private static volatile String cachedModelName;
    private static volatile Map<String, Float> cachedSearchScoreThresholds;
    private static volatile boolean initialized;
    private static final StepClawManager$observer$1 observer;
    private static final f0 scope;
    public static final StepClawManager INSTANCE = new StepClawManager();

    /* renamed from: memory$delegate, reason: from kotlin metadata */
    private static final e memory = h.x(new a4.b(2));

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.StepClawManager", f = "StepClawManager.kt", l = {147}, m = "handleNetEnvChanged", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.StepClawManager$handleNetEnvChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StepClawManager.this.handleNetEnvChanged(this);
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [com.stepos.stepclaw.StepClawManager$observer$1] */
    static {
        x1 x1VarC = i0.c();
        h6.e eVar = r0.f210a;
        scope = i0.b(h.I(x1VarC, h6.d.f3059c));
        cachedModelName = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        cachedApiToken = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        cachedSearchScoreThresholds = t.f1093a;
        Uri uriFor = Settings.Secure.getUriFor("net_env");
        p.d(uriFor, "getUriFor(...)");
        NET_ENV_URI = uriFor;
        Uri uriFor2 = Settings.Secure.getUriFor("lightmem_model");
        p.d(uriFor2, "getUriFor(...)");
        MODEL_URI = uriFor2;
        Uri uriFor3 = Settings.Secure.getUriFor("lightmem_key");
        p.d(uriFor3, "getUriFor(...)");
        KEY_URI = uriFor3;
        Uri uriFor4 = Settings.Secure.getUriFor("memory_search_score_threshold");
        p.d(uriFor4, "getUriFor(...)");
        SEARCH_SCORE_THRESHOLD_URI = uriFor4;
        final Handler handler = new Handler(Looper.getMainLooper());
        observer = new ContentObserver(handler) { // from class: com.stepos.stepclaw.StepClawManager$observer$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                if (p.a(uri, StepClawManager.NET_ENV_URI)) {
                    i0.q(StepClawManager.scope, null, new StepClawManager$observer$1$onChange$1(null), 3);
                    return;
                }
                if (p.a(uri, StepClawManager.MODEL_URI) || p.a(uri, StepClawManager.KEY_URI)) {
                    i0.q(StepClawManager.scope, null, new StepClawManager$observer$1$onChange$2(null), 3);
                } else if (p.a(uri, StepClawManager.SEARCH_SCORE_THRESHOLD_URI)) {
                    i0.q(StepClawManager.scope, null, new StepClawManager$observer$1$onChange$3(null), 3);
                }
            }
        };
    }

    private StepClawManager() {
    }

    private final MemoryBridge getMemory() {
        return (MemoryBridge) memory.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleNetEnvChanged(f5.c r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.stepclaw.StepClawManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.stepclaw.StepClawManager$handleNetEnvChanged$1 r0 = (com.stepos.stepclaw.StepClawManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.StepClawManager$handleNetEnvChanged$1 r0 = new com.stepos.stepclaw.StepClawManager$handleNetEnvChanged$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            a.a.c0(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            a.a.c0(r5)
            com.stepos.stepclaw.base.net.StepNet r5 = com.stepos.stepclaw.base.net.StepNet.INSTANCE
            r0.label = r3
            java.lang.Object r5 = r5.handleNetEnvChanged(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            com.stepos.stepclaw.bridge.memory.MemoryBridge r4 = r4.getMemory()
            com.stepos.stepclaw.base.net.StepNet r5 = com.stepos.stepclaw.base.net.StepNet.INSTANCE
            java.lang.String r5 = r5.getMemoryBaseUrl()
            r4.updateBaseUrl(r5)
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.StepClawManager.handleNetEnvChanged(f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 init$lambda$0(String str) {
        p.e(str, "<unused var>");
        StepOSProxyServer.INSTANCE.getOrCreate().applyNetEnvBaseUrl();
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StepOSCredentials init$lambda$1() {
        return StepNet.INSTANCE.getSigningCredentials();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l init$lambda$2() {
        String string = UUID.randomUUID().toString();
        StepAccount stepAccount = StepAccount.INSTANCE;
        return new l(string, stepAccount.getLocalAccountId(), stepAccount.getOAID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MemoryBridge memory_delegate$lambda$0() {
        return (MemoryBridge) ServiceLocator.INSTANCE.get(MemoryBridge.class);
    }

    private final Map<String, Float> parseScoreThresholds(String raw) {
        if (raw != null && !n.t1(raw)) {
            try {
                JSONObject jSONObject = new JSONObject(raw);
                g gVar = new g();
                Iterator<String> itKeys = jSONObject.keys();
                p.d(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObject.optString(next);
                    p.d(strOptString, "optString(...)");
                    Float fValueOf = x5.t.S0(strOptString) ? Float.valueOf(Float.parseFloat(strOptString)) : null;
                    if (fValueOf != null) {
                        gVar.put(next, Float.valueOf(fValueOf.floatValue()));
                    }
                }
                g gVarB = gVar.b();
                if (!gVarB.isEmpty()) {
                    return gVarB;
                }
            } catch (Exception unused) {
                ALog.w$default(TAG, "Failed to parse memory_search_score_threshold: ".concat(raw), null, 4, null);
            }
        }
        return null;
    }

    private final String readApiToken() {
        String string = Settings.Secure.getString(requireApp().getContentResolver(), "lightmem_key");
        return string == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string;
    }

    private final String readModelName() {
        String string = Settings.Secure.getString(requireApp().getContentResolver(), "lightmem_model");
        return string == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshLightMemConfig() {
        cachedModelName = readModelName();
        cachedApiToken = readApiToken();
        ALog.i$default(TAG, f.c("lightmem updated: model=", cachedModelName), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshSearchScoreThreshold() {
        Map<String, Float> scoreThresholds = parseScoreThresholds(Settings.Secure.getString(requireApp().getContentResolver(), "memory_search_score_threshold"));
        if (scoreThresholds == null) {
            return;
        }
        cachedSearchScoreThresholds = scoreThresholds;
        getMemory().updateSearchScoreThresholds(cachedSearchScoreThresholds);
        ALog.i$default(TAG, "search score thresholds updated: " + cachedSearchScoreThresholds, null, 4, null);
    }

    private final void registerObservers() {
        Object objO;
        ContentResolver contentResolver = requireApp().getContentResolver();
        try {
            Uri uri = NET_ENV_URI;
            StepClawManager$observer$1 stepClawManager$observer$1 = observer;
            contentResolver.registerContentObserver(uri, false, stepClawManager$observer$1);
            contentResolver.registerContentObserver(MODEL_URI, false, stepClawManager$observer$1);
            contentResolver.registerContentObserver(KEY_URI, false, stepClawManager$observer$1);
            contentResolver.registerContentObserver(SEARCH_SCORE_THRESHOLD_URI, false, stepClawManager$observer$1);
            objO = a0.f883a;
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        Throwable thA = i.a(objO);
        if (thA != null) {
            ALog.w$default(TAG, f.c("register observer failed: ", thA.getMessage()), null, 4, null);
        }
    }

    private final Application requireApp() {
        Application application2 = application;
        if (application2 != null) {
            return application2;
        }
        throw new IllegalStateException("StepClawManager not initialized");
    }

    public final void destroy() {
        ContentResolver contentResolver;
        Object objO;
        Application application2 = application;
        if (application2 == null || (contentResolver = application2.getContentResolver()) == null) {
            return;
        }
        try {
            contentResolver.unregisterContentObserver(observer);
            objO = a0.f883a;
        } catch (Throwable th) {
            objO = a.a.o(th);
        }
        Throwable thA = i.a(objO);
        if (thA != null) {
            ALog.w$default(TAG, f.c("unregister observer failed: ", thA.getMessage()), null, 4, null);
        }
        i0.f(scope, null);
        initialized = false;
    }

    public final String getApiToken() {
        return cachedApiToken;
    }

    public final String getLocalAccountId() {
        return StepAccount.INSTANCE.getLocalAccountId();
    }

    public final String getModelName() {
        return cachedModelName;
    }

    public final String getOAID() {
        return StepAccount.INSTANCE.getOAID();
    }

    public final void init(Application app) {
        p.e(app, "app");
        if (initialized) {
            ALog.w$default(TAG, "init called twice, ignore", null, 4, null);
            return;
        }
        initialized = true;
        application = app;
        StepAccount.INSTANCE.init(app);
        StepNet stepNet = StepNet.INSTANCE;
        stepNet.init(app, new z(7));
        refreshLightMemConfig();
        registerObservers();
        StepClawService.INSTANCE.startService(app);
        StepOSHeadersProvider stepOSHeadersProviderSigningProvider = StepOSHeadersProviderKt.signingProvider(new a4.b(3), new a4.b(4));
        StepOSProxyServer.INSTANCE.getOrCreate().setHeadersProvider(stepOSHeadersProviderSigningProvider);
        MemoryBridge.init$default(getMemory(), app, stepNet.getMemoryBaseUrl(), scope, "/mnt/openclaw/rootfs/root/.openclaw/workspace", false, null, stepOSHeadersProviderSigningProvider, 48, null);
        refreshSearchScoreThreshold();
    }

    public final void setDebug(boolean debug) {
        getMemory().setDebug(debug);
    }
}
