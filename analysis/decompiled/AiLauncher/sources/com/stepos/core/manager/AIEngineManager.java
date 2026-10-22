package com.stepos.core.manager;

import Y8.h;
import Y8.t;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.stepos.aiengine.client.AbilityServiceClient;
import com.stepos.aiengine.client.IServiceRemoteObserver;
import com.stepos.aiengine.clients.AICapabilityProvider;
import com.stepos.aiengine.model.IDownloader;
import com.stepos.aiengine.model.IDownloaderImpl;
import com.stepos.aiengine.model.IModelManager;
import com.stepos.aiengine.model.IModelManagerImpl;
import com.stepos.aiengine.update.OtaServiceClient;
import com.stepos.core.AbilityHandle;
import com.stepos.core.IAIEngine;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.ICTACallback;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.transport.factory.DeepBinderBridgeFactory;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.api.ProviderStateListener;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 T2\u00020\u0001:\u0001TB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0017\u0010\"\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010\u001aJ!\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010%J'\u0010'\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020\u000eH\u0016¢\u0006\u0004\b+\u0010,J\u0019\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\r\u00107\u001a\u000206¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u0014\u0010:\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u000e8\u0002X\u0082D¢\u0006\u0006\n\u0004\b<\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\t0F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020L8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0016\u0010S\u001a\u0004\u0018\u00010P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/stepos/core/manager/AIEngineManager;", "Lcom/stepos/core/IAIEngine;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "LY8/t;", "ensureProviderStateListenerRegistered", "()V", "Lcom/stepos/aiengine/client/IServiceRemoteObserver;", "observer", "addConnectionObserver", "(Lcom/stepos/aiengine/client/IServiceRemoteObserver;)V", "removeConnectionObserver", "", "abilityId", "Lcom/stepos/core/AbilityHandle;", "createAbility", "(Ljava/lang/String;)Lcom/stepos/core/AbilityHandle;", "", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilities", "()Ljava/util/List;", "id", "", "containsAbility", "(Ljava/lang/String;)Z", "isDeviceSupported", "", "getAbilityState", "(Ljava/lang/String;)I", "checkModelReady", "(Ljava/lang/String;)Ljava/lang/Boolean;", "checkEnable", "checkCloudEnable", "name", "getAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", UxipConstants.f30680s, "setAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "algorithm", "Lcom/stepos/aiengine/model/IModelManager;", "getModelManager", "(Ljava/lang/String;)Lcom/stepos/aiengine/model/IModelManager;", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/model/IDownloader;", "getDownloader", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/model/IDownloader;", "Lcom/stepos/core/deepbinder/ICTACallback;", "callback", "showCTADialog", "(Lcom/stepos/core/deepbinder/ICTACallback;)V", "Lcom/stepos/aiengine/clients/AICapabilityProvider;", "getCapabilityProvider", "()Lcom/stepos/aiengine/clients/AICapabilityProvider;", "Landroid/content/Context;", "TAG", "Ljava/lang/String;", "SERVICE_PACKAGE", "Lcom/stepos/core/transport/factory/DeepBinderBridgeFactory;", "deepBinderFactory$delegate", "LY8/h;", "getDeepBinderFactory", "()Lcom/stepos/core/transport/factory/DeepBinderBridgeFactory;", "deepBinderFactory", "Landroid/content/ComponentName;", "SERVICE_COMPONENT", "Landroid/content/ComponentName;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "connectionObservers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "connectionProviderStateListener", "Lcom/stepos/deepbinder/client/api/ProviderStateListener;", "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "getAbilitySvc", "()Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "abilitySvc", "Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "getOtaSvc", "()Lcom/stepos/core/deepbinder/IOtaDeepBinderService;", "otaSvc", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AIEngineManager implements IAIEngine {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SuppressLint({"StaticFieldLeak"})
    private static volatile AIEngineManager instance;
    private final ComponentName SERVICE_COMPONENT;
    private final String SERVICE_PACKAGE;
    private final String TAG;
    private final CopyOnWriteArrayList<IServiceRemoteObserver> connectionObservers;
    private volatile ProviderStateListener connectionProviderStateListener;
    private final Context context;

    /* renamed from: deepBinderFactory$delegate, reason: from kotlin metadata */
    private final h deepBinderFactory;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/core/manager/AIEngineManager$Companion;", "", "<init>", "()V", "instance", "Lcom/stepos/core/manager/AIEngineManager;", "getInstance", "context", "Landroid/content/Context;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final AIEngineManager getInstance(Context context) {
            AIEngineManager aIEngineManager;
            p.i(context, "context");
            AIEngineManager aIEngineManager2 = AIEngineManager.instance;
            if (aIEngineManager2 != null) {
                return aIEngineManager2;
            }
            synchronized (this) {
                aIEngineManager = AIEngineManager.instance;
                if (aIEngineManager == null) {
                    Context applicationContext = context.getApplicationContext();
                    p.h(applicationContext, "getApplicationContext(...)");
                    aIEngineManager = new AIEngineManager(applicationContext, null);
                    AIEngineManager.instance = aIEngineManager;
                }
            }
            return aIEngineManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AIEngineManager(Context context, i iVar) {
        this(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DeepBinderBridgeFactory deepBinderFactory_delegate$lambda$0(AIEngineManager aIEngineManager) {
        return new DeepBinderBridgeFactory(aIEngineManager.SERVICE_PACKAGE);
    }

    private final void ensureProviderStateListenerRegistered() {
        if (this.connectionProviderStateListener != null) {
            return;
        }
        synchronized (this) {
            if (this.connectionProviderStateListener != null) {
                return;
            }
            ProviderStateListener providerStateListener = new ProviderStateListener() { // from class: com.stepos.core.manager.AIEngineManager$ensureProviderStateListenerRegistered$1$listener$1
                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStart(ComponentName componentName) {
                    p.i(componentName, "componentName");
                }

                @Override // com.stepos.deepbinder.client.api.ProviderStateListener
                public void onProviderStop(ComponentName componentName) {
                    p.i(componentName, "componentName");
                    if (p.d(componentName, this.this$0.SERVICE_COMPONENT)) {
                        Log.d(this.this$0.TAG, "AIEngine service disconnected");
                        Iterator it = this.this$0.connectionObservers.iterator();
                        while (it.hasNext()) {
                            ((IServiceRemoteObserver) it.next()).onDisconnected();
                        }
                    }
                }
            };
            DeepBinderClient.INSTANCE.registerProviderStateListener(providerStateListener);
            this.connectionProviderStateListener = providerStateListener;
            t tVar = t.f7040a;
        }
    }

    private final IAIEngineDeepBinderService getAbilitySvc() {
        return AbilityServiceClient.INSTANCE.get(this.context);
    }

    private final DeepBinderBridgeFactory getDeepBinderFactory() {
        return (DeepBinderBridgeFactory) this.deepBinderFactory.getValue();
    }

    private final IOtaDeepBinderService getOtaSvc() {
        return OtaServiceClient.INSTANCE.get(this.context);
    }

    public final void addConnectionObserver(IServiceRemoteObserver observer) {
        p.i(observer, "observer");
        this.connectionObservers.add(observer);
        ensureProviderStateListenerRegistered();
    }

    @Override // com.stepos.core.IAIEngine
    public boolean checkCloudEnable(String id) {
        p.i(id, "id");
        return getAbilitySvc().checkCloudEnable(id);
    }

    @Override // com.stepos.core.IAIEngine
    public boolean checkEnable(String id) {
        p.i(id, "id");
        return getAbilitySvc().checkEnable(id);
    }

    @Override // com.stepos.core.IAIEngine
    public Boolean checkModelReady(String id) {
        p.i(id, "id");
        return getAbilitySvc().checkModelReady(id);
    }

    @Override // com.stepos.core.IAIEngine
    public boolean containsAbility(String id) {
        p.i(id, "id");
        return getAbilitySvc().containsAbility(id);
    }

    public final AbilityHandle createAbility(String abilityId) {
        p.i(abilityId, "abilityId");
        AbilityHandle abilityHandleCreateHandle = getDeepBinderFactory().createHandle(this.context, abilityId);
        if (abilityHandleCreateHandle == null) {
            Log.w(this.TAG, "createAbility: failed for " + abilityId);
        }
        return abilityHandleCreateHandle;
    }

    @Override // com.stepos.core.IAIEngine
    public List<AbilityInfo> getAbilities() {
        return getAbilitySvc().getAbilities();
    }

    @Override // com.stepos.core.IAIEngine
    public String getAbilityProperty(String id, String name) {
        p.i(id, "id");
        p.i(name, "name");
        return getAbilitySvc().getAbilityProperty(id, name);
    }

    @Override // com.stepos.core.IAIEngine
    public int getAbilityState(String id) {
        p.i(id, "id");
        return getAbilitySvc().getAbilityState(id);
    }

    public final AICapabilityProvider getCapabilityProvider() {
        return AICapabilityProvider.INSTANCE;
    }

    @Override // com.stepos.core.IAIEngine
    public IDownloader getDownloader(Bundle args) {
        String string;
        p.i(args, "args");
        IOtaDeepBinderService otaSvc = getOtaSvc();
        if (otaSvc == null || (string = args.getString("algorithm")) == null) {
            return null;
        }
        return new IDownloaderImpl(otaSvc, string, this.context);
    }

    @Override // com.stepos.core.IAIEngine
    public IModelManager getModelManager(String algorithm) {
        p.i(algorithm, "algorithm");
        IOtaDeepBinderService otaSvc = getOtaSvc();
        if (otaSvc == null) {
            return null;
        }
        return new IModelManagerImpl(otaSvc, algorithm, this.context);
    }

    @Override // com.stepos.core.IAIEngine
    public boolean isDeviceSupported(String id) {
        p.i(id, "id");
        return getAbilitySvc().isDeviceSupported(id);
    }

    public final void removeConnectionObserver(IServiceRemoteObserver observer) {
        ProviderStateListener providerStateListener;
        p.i(observer, "observer");
        this.connectionObservers.remove(observer);
        if (!this.connectionObservers.isEmpty() || (providerStateListener = this.connectionProviderStateListener) == null) {
            return;
        }
        DeepBinderClient.INSTANCE.unRegisterProviderStateListener(providerStateListener);
        this.connectionProviderStateListener = null;
    }

    @Override // com.stepos.core.IAIEngine
    public boolean setAbilityProperty(String id, String name, String value) {
        p.i(id, "id");
        p.i(name, "name");
        p.i(value, "value");
        return getAbilitySvc().setAbilityProperty(id, name, value);
    }

    @Override // com.stepos.core.IAIEngine
    public void showCTADialog(ICTACallback callback) {
        p.i(callback, "callback");
        getAbilitySvc().showCTADialog(callback);
    }

    private AIEngineManager(Context context) {
        this.context = context;
        this.TAG = "AIEngineManager";
        this.SERVICE_PACKAGE = "com.stepos.aiengine";
        this.deepBinderFactory = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.core.manager.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AIEngineManager.deepBinderFactory_delegate$lambda$0(this.f29524a);
            }
        });
        this.SERVICE_COMPONENT = new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider");
        this.connectionObservers = new CopyOnWriteArrayList<>();
    }
}
