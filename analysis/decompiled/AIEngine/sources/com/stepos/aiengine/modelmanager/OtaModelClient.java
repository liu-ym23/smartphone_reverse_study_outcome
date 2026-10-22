package com.stepos.aiengine.modelmanager;

import a6.e;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.lifecycle.j0;
import com.stepos.aiengine.flow.ModelFlowStage;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.confirmui.ConfirmUiHost;
import com.stepos.core.ota.confirmui.ConfirmUiRequest;
import com.stepos.core.ota.confirmui.FallbackConfirmHost;
import com.stepos.core.ota.confirmui.InProcessConfirmHost;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;
import com.stepos.core.ota.confirmui.TrampolineConfirmHost;
import com.stepos.core.ota.d;
import com.stepos.core.ota.process.OtaProcessClient;
import com.stepos.core.ota.process.OtaProcessConfig;
import com.stepos.deepbinder.client.DeepBinderClient;
import h6.k;
import h6.m;
import h6.s;
import h6.t;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import lb.n;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaModelClient {

    /* renamed from: c, reason: collision with root package name */
    public static volatile k f5873c;

    /* renamed from: g, reason: collision with root package name */
    public static volatile IOtaDeepBinderService f5877g;

    /* renamed from: i, reason: collision with root package name */
    public static volatile j0 f5878i;

    /* renamed from: a, reason: collision with root package name */
    public static final OtaModelClient f5871a = new OtaModelClient();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f5872b = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap.KeySetView<String, Boolean> f5874d = ConcurrentHashMap.newKeySet();

    /* renamed from: e, reason: collision with root package name */
    public static final Handler f5875e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Runnable> f5876f = new ConcurrentHashMap<>();
    public static final CoroutineScope h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));

    /* renamed from: j, reason: collision with root package name */
    public static final InProcessConfirmHost f5879j = new InProcessConfirmHost(new com.stepos.cpuset.b(7));

    /* renamed from: k, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConfirmUiRequest> f5880k = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements ConfirmUiHost {

        /* renamed from: a, reason: collision with root package name */
        public final Context f5881a;

        public a(Context context) {
            this.f5881a = context;
        }

        @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
        public final String getPerfLabel() {
            return "toast";
        }

        @Override // com.stepos.core.ota.confirmui.ConfirmUiHost
        public final void show(ConfirmUiRequest request) {
            g.f(request, "request");
            OtaModelClient.f5871a.getClass();
            new Handler(Looper.getMainLooper()).post(new e(this.f5881a, 5));
            request.getOnShowFailed().invoke();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements e6.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ModelConfirmFlow.Mode f5882a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5883b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f5884c;

        public b(ModelConfirmFlow.Mode mode, String str, Ref$BooleanRef ref$BooleanRef) {
            this.f5882a = mode;
            this.f5883b = str;
            this.f5884c = ref$BooleanRef;
        }

        @Override // e6.a
        public final void onFailed(int i10, String message) {
            g.f(message, "message");
            StringBuilder sb2 = new StringBuilder("confirmFlow[");
            sb2.append(this.f5882a);
            sb2.append("] ");
            String str = this.f5883b;
            sb2.append(str);
            sb2.append(" failed code=");
            sb2.append(i10);
            sb2.append(" msg=");
            sb2.append(message);
            Log.w("OtaModelClient", sb2.toString());
            OtaModelClient.f5871a.getClass();
            OtaModelClient.b(i10, str);
        }

        @Override // e6.a
        public final void onReady(boolean z) {
            StringBuilder sb2 = new StringBuilder("confirmFlow[");
            ModelConfirmFlow.Mode mode = this.f5882a;
            sb2.append(mode);
            sb2.append("] ");
            String str = this.f5883b;
            sb2.append(str);
            sb2.append(" ready canUpdate=");
            sb2.append(z);
            Log.i("OtaModelClient", sb2.toString());
            int i10 = (mode == ModelConfirmFlow.Mode.DOWNLOAD && this.f5884c.f10073a) ? z ? -2 : -1 : 0;
            OtaModelClient.f5871a.getClass();
            OtaModelClient.b(i10, str);
        }

        @Override // e6.a
        public final void onStateChanged(ModelFlowStage stage) {
            g.f(stage, "stage");
            Log.i("OtaModelClient", "confirmFlow[" + this.f5882a + "] " + this.f5883b + " stage=" + stage);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c implements e6.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5885a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5886b;

        public c(String str, boolean z) {
            this.f5885a = z;
            this.f5886b = str;
        }

        @Override // e6.a
        public final void onFailed(int i10, String message) {
            g.f(message, "message");
            StringBuilder sb2 = new StringBuilder("notifResume[retry=");
            sb2.append(this.f5885a);
            sb2.append("] ");
            String str = this.f5886b;
            sb2.append(str);
            sb2.append(" failed code=");
            sb2.append(i10);
            sb2.append(" msg=");
            sb2.append(message);
            Log.w("OtaModelClient", sb2.toString());
            OtaModelClient.f5871a.getClass();
            OtaModelClient.b(i10, str);
        }

        @Override // e6.a
        public final void onReady(boolean z) {
            OtaModelClient.f5871a.getClass();
            OtaModelClient.b(0, this.f5886b);
        }

        @Override // e6.a
        public final void onStateChanged(ModelFlowStage stage) {
            g.f(stage, "stage");
            Log.i("OtaModelClient", "notifResume[retry=" + this.f5885a + "] " + this.f5886b + " stage=" + stage);
        }
    }

    public static void a(String str) {
        h0.e.k("[DIAG] ", str, LogModule.OTA, "MMUpdate");
    }

    public static void b(int i10, String str) {
        a("ended modelId=" + str + " code=" + i10);
        c(str);
        k kVar = f5873c;
        if (kVar != null) {
            ModelManagerFragment.onViewCreated$lambda$7(kVar.f9322g, str, i10);
        }
    }

    public static void c(String modelId) {
        g.f(modelId, "modelId");
        Runnable runnableRemove = f5876f.remove(modelId);
        if (runnableRemove != null) {
            f5875e.removeCallbacks(runnableRemove);
        }
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = f5874d;
        if (keySetView.remove(modelId)) {
            a("gate- end modelId=" + modelId + " inFlight=" + keySetView.size());
        }
    }

    public static void g(String str, long j10, String str2, String str3) {
        if (str.length() == 0) {
            return;
        }
        AIEngineLogger.i(LogModule.OTA, "OtaConfirmPerf", d.j(d.l("OCPERF tid=", SystemClock.elapsedRealtime() - j10, str, " +"), "ms stage=", str2, " ", str3));
    }

    public static void j(Context context, List rows) {
        Object objA;
        g.f(context, "context");
        g.f(rows, "rows");
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = rows.iterator();
            while (it.hasNext()) {
                s sVar = (s) it.next();
                jSONArray.put(new JSONObject().put("abilityId", sVar.f9338a).put("otaName", sVar.f9339b).put("displayName", sVar.f9340c).put("description", sVar.f9341d).put("fileSize", sVar.f9342e).put("installStatus", sVar.f9343f).put("downloadProgress", sVar.f9344g).put("isPreset", sVar.h).put("rawState", sVar.f9345i).put("remoteVersionCode", sVar.f9346j).put("displayDir", sVar.f9347k));
            }
            File file = new File(context.getCacheDir(), "model_manager_rows.json");
            String string = jSONArray.toString();
            g.e(string, "toString(...)");
            wb.d.e0(file, string);
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            Log.e("OtaModelClient", "saveCachedRows failed", thB);
        }
    }

    public static Flow l() {
        return FlowKt.callbackFlow(new OtaModelClient$taskStateFlow$1(2, null));
    }

    public static boolean m(String modelId) {
        g.f(modelId, "modelId");
        ConcurrentHashMap.KeySetView<String, Boolean> keySetView = f5874d;
        boolean zAdd = keySetView.add(modelId);
        if (!zAdd) {
            a("gate! dup-ignored modelId=" + modelId + " (confirm already in-flight)");
            return zAdd;
        }
        a("gate+ begin modelId=" + modelId + " inFlight=" + keySetView.size());
        ConcurrentHashMap<String, Runnable> concurrentHashMap = f5876f;
        Runnable runnableRemove = concurrentHashMap.remove(modelId);
        Handler handler = f5875e;
        if (runnableRemove != null) {
            handler.removeCallbacks(runnableRemove);
        }
        m mVar = new m(modelId, 1);
        concurrentHashMap.put(modelId, mVar);
        handler.postDelayed(mVar, 180000L);
        return zAdd;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(android.content.Context r17, java.lang.String r18, com.stepos.core.ota.confirmui.ModelConfirmFlow.Mode r19, java.lang.String r20, long r21, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.modelmanager.OtaModelClient.d(android.content.Context, java.lang.String, com.stepos.core.ota.confirmui.ModelConfirmFlow$Mode, java.lang.String, long, java.lang.String):void");
    }

    public final void e(Context context, String str, boolean z, ModelConfirmFlow.Mode mode, String str2) {
        if (!m(str)) {
            a("launchResumeFlow dup-ignored modelId=" + str + " (resume/retry already in-flight)");
            return;
        }
        IOtaDeepBinderService iOtaDeepBinderServiceK = k();
        if (iOtaDeepBinderServiceK == null) {
            Log.e("OtaModelClient", "launchResumeFlow: OTA service unavailable, modelId=".concat(str));
            b(5901, str);
            return;
        }
        t tVar = new t(str, z);
        Context applicationContext = context.getApplicationContext();
        g.e(applicationContext, "getApplicationContext(...)");
        ModelConfirmFlow.startResume$default(new ModelConfirmFlow(str, mode, null, 0L, str2, new FallbackConfirmHost(f5879j, new TrampolineConfirmHost(applicationContext)), null, false, 204, null), context, iOtaDeepBinderServiceK, tVar, null, h, z, false, false, TraceIdKeys.MAX_LENGTH, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List f(android.content.Context r27, java.lang.String r28, zb.l r29) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.aiengine.modelmanager.OtaModelClient.f(android.content.Context, java.lang.String, zb.l):java.util.List");
    }

    public final void h(Context context, String str, boolean z, boolean z3) {
        Context applicationContext = context.getApplicationContext();
        IOtaDeepBinderService iOtaDeepBinderServiceK = k();
        if (iOtaDeepBinderServiceK == null) {
            Log.e("OtaModelClient", "resumeFromNotification: OTA service unavailable, modelId=".concat(str));
            b(5901, str);
            return;
        }
        if (!CTAPermissionManager.INSTANCE.hasCTAPermission()) {
            g.c(applicationContext);
            new Handler(Looper.getMainLooper()).post(new e(applicationContext, 5));
            b(4001, str);
            return;
        }
        c cVar = new c(str, z);
        ModelConfirmFlow.Mode mode = ModelConfirmFlow.Mode.DOWNLOAD;
        g.c(applicationContext);
        ModelConfirmFlow.startResume$default(new ModelConfirmFlow(str, mode, null, 0L, null, new a(applicationContext), null, false, 220, null), context, iOtaDeepBinderServiceK, cVar, null, h, z, z3, false, TraceIdKeys.MAX_LENGTH, null);
    }

    public final void i(Context context, boolean z, String modelId, String displayName) {
        g.f(context, "context");
        g.f(modelId, "modelId");
        g.f(displayName, "displayName");
        if (OtaProcessConfig.INSTANCE.getEnabled()) {
            OtaProcessClient otaProcessClient = OtaProcessClient.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            g.e(applicationContext, "getApplicationContext(...)");
            otaProcessClient.bindAsync(applicationContext);
        }
        e(context, modelId, true, z ? ModelConfirmFlow.Mode.UPDATE : ModelConfirmFlow.Mode.DOWNLOAD, displayName);
    }

    public final IOtaDeepBinderService k() {
        IOtaDeepBinderService iOtaDeepBinderService;
        Object objA;
        IOtaDeepBinderService iOtaDeepBinderService2 = f5877g;
        if (iOtaDeepBinderService2 != null) {
            return iOtaDeepBinderService2;
        }
        synchronized (this) {
            try {
                iOtaDeepBinderService = f5877g;
                if (iOtaDeepBinderService == null) {
                    try {
                        Object objCreate = DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ota.deepbinder.OtaDeepBinderServiceImpl", IOtaDeepBinderService.class, new Pair[0]);
                        f5877g = (IOtaDeepBinderService) objCreate;
                        objA = (IOtaDeepBinderService) objCreate;
                    } catch (Throwable th) {
                        objA = kotlin.c.a(th);
                    }
                    Throwable thB = Result.b(objA);
                    if (thB != null) {
                        Log.e("OtaModelClient", "create OTA DeepBinder proxy failed", thB);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    iOtaDeepBinderService = (IOtaDeepBinderService) objA;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iOtaDeepBinderService;
    }
}
