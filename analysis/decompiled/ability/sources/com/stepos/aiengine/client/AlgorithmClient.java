package com.stepos.aiengine.client;

import C7.r;
import S7.n;
import Z7.d;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.adapter.AdapterFactory;
import com.stepos.aiengine.api.IAlgorithmProperties;
import com.stepos.aiengine.api.task.IAlgorithmListener;
import com.stepos.aiengine.args.LoadParamBundle;
import com.stepos.aiengine.clients.AICapabilityProvider;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.aiengine.model.RemoteModelManager;
import com.stepos.aiengine.model.StubModelManager;
import com.stepos.aiengine.update.OtaServiceClient;
import com.stepos.core.c;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import f5.InterfaceC1435a;
import h5.C1488a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.a;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.q0;
import s9.C1923c;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001:B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u0011J\u0015\u0010\u001e\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b&\u0010%J!\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0005H\u0007¢\u0006\u0004\b'\u0010%J%\u0010)\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\b)\u0010*J\u001d\u0010,\u001a\u00020 2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0005¢\u0006\u0004\b,\u0010-J'\u00101\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u0002032\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b4\u00105R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/client/AlgorithmClient;", "", "I", "LZ7/d;", "interfaceClass", "", "algorithmId", AppAgent.CONSTRUCT, "(LZ7/d;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "params", "loadAlgorithm", "(Landroid/content/Context;Landroid/os/Bundle;)Ljava/lang/Object;", "LC7/r;", "releaseClient", "()V", "releaseAlgorithm", "(Landroid/content/Context;)V", "", "immediate", "(Landroid/content/Context;Z)V", "isClientAlive", "()Z", "", "delayMs", "scheduleDelayRelease", "(J)V", "cancelDelayRelease", "isSupported", "(Landroid/content/Context;)Z", "", "checkResources", "(Landroid/content/Context;)I", "key", "getInitialProperty", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "getRuntimeProperty", "getBundleProperty", "value", "setAlgorithmProperty", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "pluginKey", "checkPluginResources", "(Landroid/content/Context;Ljava/lang/String;)I", "identity", "Lcom/stepos/aiengine/api/task/IAlgorithmListener;", "listener", "setAlgorithmListener", "(Landroid/content/Context;JLcom/stepos/aiengine/api/task/IAlgorithmListener;)V", "Lcom/stepos/aiengine/model/IModelManager;", "getModelManager", "(Landroid/content/Context;)Lcom/stepos/aiengine/model/IModelManager;", "b", "Ljava/lang/String;", "getAlgorithmId", "()Ljava/lang/String;", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlgorithmClient<I> {
    public static final ComponentName k = new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider");

    /* renamed from: a, reason: collision with root package name */
    public final d f3506a;

    /* renamed from: b, reason: from kotlin metadata */
    public final String algorithmId;
    public Object c;
    public c d;
    public final C1923c e;
    public q0 f;
    public Context g;
    public AlgorithmClient$setAlgorithmListener$1$cb$1 h;
    public AlgorithmClient$setAlgorithmListener$1$stateListener$1 i;

    /* renamed from: j, reason: collision with root package name */
    public AlgorithmClient$ensureConnectionStateListener$listener$1 f3507j;

    @J7.c(c = "com.stepos.aiengine.client.AlgorithmClient$scheduleDelayRelease$1", f = "AlgorithmClient.kt", l = {141}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
    /* renamed from: com.stepos.aiengine.client.AlgorithmClient$scheduleDelayRelease$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {

        /* renamed from: a, reason: collision with root package name */
        public int f3509a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlgorithmClient c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j5, AlgorithmClient algorithmClient, H7.c cVar) {
            super(2, cVar);
            this.b = j5;
            this.c = algorithmClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c create(Object obj, H7.c cVar) {
            return new AnonymousClass1(this.b, this.c, cVar);
        }

        @Override // S7.n
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((InterfaceC1733z) obj, (H7.c) obj2)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.f3509a;
            if (i == 0) {
                b.b(obj);
                long j5 = this.b;
                this.f3509a = 1;
                if (a.f(j5, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            AlgorithmClient algorithmClient = this.c;
            synchronized (algorithmClient) {
                try {
                    c cVar = algorithmClient.d;
                    if (cVar != null) {
                        cVar.j();
                    }
                    algorithmClient.d = null;
                    algorithmClient.c = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return r.f317a;
        }
    }

    public AlgorithmClient(d interfaceClass, String algorithmId) {
        k.f(interfaceClass, "interfaceClass");
        k.f(algorithmId, "algorithmId");
        this.f3506a = interfaceClass;
        this.algorithmId = algorithmId;
        this.e = AbstractC1683A.b(AbstractC1691I.f5315a.plus(AbstractC1683A.c()));
    }

    public static /* synthetic */ Object loadAlgorithm$default(AlgorithmClient algorithmClient, Context context, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        return algorithmClient.loadAlgorithm(context, bundle);
    }

    public static /* synthetic */ void scheduleDelayRelease$default(AlgorithmClient algorithmClient, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = 5000;
        }
        algorithmClient.scheduleDelayRelease(j5);
    }

    public final void a() {
        AlgorithmClient$setAlgorithmListener$1$cb$1 algorithmClient$setAlgorithmListener$1$cb$1 = this.h;
        if (algorithmClient$setAlgorithmListener$1$cb$1 == null) {
            return;
        }
        Context context = this.g;
        this.h = null;
        this.g = null;
        AlgorithmClient$setAlgorithmListener$1$stateListener$1 algorithmClient$setAlgorithmListener$1$stateListener$1 = this.i;
        if (algorithmClient$setAlgorithmListener$1$stateListener$1 != null) {
            DeepBinderClient.INSTANCE.unRegisterProviderStateListener(algorithmClient$setAlgorithmListener$1$stateListener$1);
            this.i = null;
        }
        if (context != null) {
            try {
                IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
                if (iOtaDeepBinderService != null) {
                    iOtaDeepBinderService.unregisterDownloadCallback(this.algorithmId, algorithmClient$setAlgorithmListener$1$cb$1);
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
    }

    public final void cancelDelayRelease() {
        q0 q0Var = this.f;
        if (q0Var != null) {
            q0Var.cancel(null);
        }
        this.f = null;
    }

    public final int checkPluginResources(Context context, String pluginKey) {
        k.f(context, "context");
        k.f(pluginKey, "pluginKey");
        Boolean boolCheckModelReady = AbilityServiceClient.INSTANCE.get(context).checkModelReady(B7.a.B(this.algorithmId, "-", pluginKey));
        if (k.b(boolCheckModelReady, Boolean.TRUE)) {
            return 1;
        }
        if (k.b(boolCheckModelReady, Boolean.FALSE)) {
            return 0;
        }
        if (boolCheckModelReady == null) {
            return -2;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.Result$Failure] */
    public final int checkResources(Context context) {
        Integer numA;
        k.f(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        String str = this.algorithmId;
        if (iOtaDeepBinderService != null) {
            try {
                numA = Integer.valueOf(iOtaDeepBinderService.checkResources(str));
            } catch (Throwable th) {
                numA = b.a(th);
            }
            num = numA instanceof Result.Failure ? null : numA;
        }
        if (num != null && num.intValue() != 0 && num.intValue() != 5 && num.intValue() != -2) {
            Log.d("AlgorithmClient", "checkResources: algorithmId=" + str + " source=ota state=" + num);
            return num.intValue();
        }
        int iCheckResources = AICapabilityProvider.INSTANCE.checkResources(context, str);
        Log.d("AlgorithmClient", "checkResources: algorithmId=" + str + " source=file otaState=" + num + " fileState=" + iCheckResources);
        return iCheckResources;
    }

    public final String getAlgorithmId() {
        return this.algorithmId;
    }

    @WorkerThread
    public final String getBundleProperty(Context context, String key) {
        k.f(context, "context");
        k.f(key, "key");
        Bundle bundle = new Bundle();
        bundle.putInt(LoadParamBundle.KEY_INIT_STRATEGY, 0);
        loadAlgorithm(context, bundle);
        return AbilityServiceClient.INSTANCE.get(context).getAbilityProperty(this.algorithmId, key);
    }

    public final String getInitialProperty(Context context, String key) {
        k.f(context, "context");
        k.f(key, "key");
        IAIEngineDeepBinderService iAIEngineDeepBinderService = AbilityServiceClient.INSTANCE.get(context);
        int iHashCode = key.hashCode();
        String str = this.algorithmId;
        if (iHashCode == -1714660125) {
            if (key.equals(IAlgorithmProperties.CURRENT_MODEL)) {
                return iAIEngineDeepBinderService.getAbilityProperty(str, IAlgorithmProperties.CURRENT_MODEL);
            }
            return null;
        }
        if (iHashCode == -475629664) {
            if (key.equals(IAlgorithmProperties.PLUGINS)) {
                return iAIEngineDeepBinderService.getAbilityProperty(str, IAlgorithmProperties.PLUGINS);
            }
            return null;
        }
        if (iHashCode == 1736037254 && key.equals(IAlgorithmProperties.MAX_TOKEN_LIMIT)) {
            return "4096";
        }
        return null;
    }

    public final IModelManager getModelManager(Context context) {
        k.f(context, "context");
        IOtaDeepBinderService iOtaDeepBinderService = OtaServiceClient.INSTANCE.get(context);
        return iOtaDeepBinderService != null ? new RemoteModelManager(this.algorithmId, iOtaDeepBinderService) : new StubModelManager();
    }

    public final String getRuntimeProperty(Context context, String key) {
        boolean z10;
        k.f(context, "context");
        k.f(key, "key");
        if (!key.equals(IAlgorithmProperties.IS_BUSY)) {
            return null;
        }
        synchronized (this) {
            z10 = this.c != null;
        }
        return String.valueOf(z10);
    }

    public final boolean isClientAlive() {
        boolean z10;
        synchronized (this) {
            z10 = this.c != null;
        }
        return z10;
    }

    public final boolean isSupported(Context context) {
        k.f(context, "context");
        return AICapabilityProvider.INSTANCE.isDeviceSupported(context, this.algorithmId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.stepos.aiengine.client.AlgorithmClient$ensureConnectionStateListener$listener$1, com.stepos.deepbinder.client.api.ProviderStateListener] */
    @WorkerThread
    public final I loadAlgorithm(Context context, Bundle params) {
        String str;
        k.f(context, "context");
        synchronized (this) {
            I i = (I) this.c;
            if (i != null) {
                cancelDelayRelease();
                return i;
            }
            F1.a aVar = C1488a.b;
            C1488a c1488a = C1488a.c;
            if (c1488a == null) {
                synchronized (aVar) {
                    c1488a = C1488a.c;
                    if (c1488a == null) {
                        Context applicationContext = context.getApplicationContext();
                        k.e(applicationContext, "getApplicationContext(...)");
                        c1488a = new C1488a(applicationContext);
                        C1488a.c = c1488a;
                    }
                }
            }
            String string = params != null ? params.getString("plugin") : null;
            if (string != null) {
                str = this.algorithmId + "-" + string;
                if (!AbilityServiceClient.INSTANCE.get(context).containsAbility(str)) {
                    str = this.algorithmId;
                }
            } else {
                str = this.algorithmId;
            }
            c cVarA = c1488a.a(str);
            if (cVarA == null) {
                throw new IllegalStateException("Ability not found or service unavailable: ".concat(str).toString());
            }
            cVarA.f3825a.acquire();
            this.d = cVarA;
            I i6 = (I) AdapterFactory.INSTANCE.create(this.f3506a, cVarA, str, params);
            this.c = i6;
            if (this.f3507j == null) {
                ?? r72 = new ProviderStateListener() { // from class: com.stepos.aiengine.client.AlgorithmClient$ensureConnectionStateListener$listener$1
                    @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                    public void onProviderStart(ComponentName componentName) {
                        k.f(componentName, "componentName");
                    }

                    @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                    public void onProviderStop(ComponentName componentName) {
                        k.f(componentName, "componentName");
                        if (componentName.equals(AlgorithmClient.k)) {
                            androidx.constraintlayout.core.dsl.a.w("onProviderStop: server died, clearing cached adapter/handle for ", this.f3508a.getAlgorithmId(), "AlgorithmClient");
                            AlgorithmClient algorithmClient = this.f3508a;
                            synchronized (algorithmClient) {
                                try {
                                    algorithmClient.cancelDelayRelease();
                                    c cVar = algorithmClient.d;
                                    if (cVar != null) {
                                        cVar.d();
                                    }
                                    algorithmClient.d = null;
                                    algorithmClient.c = null;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }
                };
                DeepBinderClient.INSTANCE.registerProviderStateListener(r72);
                this.f3507j = r72;
            }
            return i6;
        }
    }

    public final void releaseAlgorithm(Context context) {
        k.f(context, "context");
        releaseClient();
    }

    public final void releaseClient() {
        synchronized (this) {
            try {
                a();
                AlgorithmClient$ensureConnectionStateListener$listener$1 algorithmClient$ensureConnectionStateListener$listener$1 = this.f3507j;
                if (algorithmClient$ensureConnectionStateListener$listener$1 != null) {
                    DeepBinderClient.INSTANCE.unRegisterProviderStateListener(algorithmClient$ensureConnectionStateListener$listener$1);
                    this.f3507j = null;
                }
                cancelDelayRelease();
                c cVar = this.d;
                if (cVar != null) {
                    cVar.j();
                }
                this.d = null;
                this.c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void scheduleDelayRelease(long delayMs) {
        cancelDelayRelease();
        this.f = AbstractC1683A.n(this.e, null, new AnonymousClass1(delayMs, this, null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$cb$1, f5.a] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$stateListener$1, com.stepos.deepbinder.client.api.ProviderStateListener] */
    public final void setAlgorithmListener(Context context, final long identity, final IAlgorithmListener listener) {
        k.f(context, "context");
        synchronized (this) {
            a();
            if (listener == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            OtaServiceClient otaServiceClient = OtaServiceClient.INSTANCE;
            k.c(applicationContext);
            IOtaDeepBinderService iOtaDeepBinderService = otaServiceClient.get(applicationContext);
            if (iOtaDeepBinderService == 0) {
                return;
            }
            ?? r1 = new InterfaceC1435a() { // from class: com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$cb$1
                public void onComplete(String localFilePath) {
                    k.f(localFilePath, "localFilePath");
                }

                public void onError(int i, String message) {
                    k.f(message, "message");
                }

                public void onProgress(int i, long j5, long j6) {
                }

                public void onUpdate(int state, int progress) {
                    IAlgorithmListener iAlgorithmListener = listener;
                    long j5 = identity;
                    iAlgorithmListener.onUpdate(j5, state, progress);
                    if (state == 5) {
                        Bundle bundle = new Bundle();
                        bundle.putString("algorithmId", this.getAlgorithmId());
                        iAlgorithmListener.onPrepared(j5, bundle);
                    }
                    if (state == 6) {
                        iAlgorithmListener.onFailed(j5, state, "download or install failed");
                    }
                }
            };
            try {
                iOtaDeepBinderService.registerDownloadCallback(this.algorithmId, r1);
            } catch (Throwable th) {
                b.a(th);
            }
            this.h = r1;
            this.g = applicationContext;
            ?? r32 = new ProviderStateListener() { // from class: com.stepos.aiengine.client.AlgorithmClient$setAlgorithmListener$1$stateListener$1
                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStart(ComponentName componentName) {
                    Object objA;
                    k.f(componentName, "componentName");
                    if (componentName.equals(AlgorithmClient.k)) {
                        AlgorithmClient algorithmClient = this.f3511a;
                        synchronized (algorithmClient) {
                            InterfaceC1435a interfaceC1435a = algorithmClient.h;
                            if (interfaceC1435a == null) {
                                return;
                            }
                            Context context2 = algorithmClient.g;
                            if (context2 == null) {
                                return;
                            }
                            try {
                                IOtaDeepBinderService iOtaDeepBinderService2 = OtaServiceClient.INSTANCE.get(context2);
                                if (iOtaDeepBinderService2 != null) {
                                    iOtaDeepBinderService2.registerDownloadCallback(algorithmClient.getAlgorithmId(), interfaceC1435a);
                                    objA = r.f317a;
                                } else {
                                    objA = null;
                                }
                            } catch (Throwable th2) {
                                objA = b.a(th2);
                            }
                            Throwable thA = Result.a(objA);
                            if (thA != null) {
                                Log.w("AlgorithmClient", "re-register download callback failed for " + algorithmClient.getAlgorithmId(), thA);
                            }
                        }
                    }
                }

                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStop(ComponentName componentName) {
                    k.f(componentName, "componentName");
                }
            };
            DeepBinderClient.INSTANCE.registerProviderStateListener(r32);
            this.i = r32;
        }
    }

    public final void setAlgorithmProperty(Context context, String key, String value) {
        k.f(context, "context");
        k.f(key, "key");
        k.f(value, "value");
    }

    public final void releaseAlgorithm(Context context, boolean immediate) {
        k.f(context, "context");
        releaseClient();
    }
}
