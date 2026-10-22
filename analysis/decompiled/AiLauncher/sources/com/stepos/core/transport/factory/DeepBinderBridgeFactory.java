package com.stepos.core.transport.factory;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.stepos.core.AbilityHandle;
import com.stepos.core.DeepBinderAbilityProxy;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.core.transport.bridge.DeepBinderTransportBridge;
import com.stepos.core.transport.factory.DeepBinderBridgeFactory;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.utils.ComponentInternalInfo;
import com.stepos.deepbinder.core.utils.IPCUtilsKt;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/core/transport/factory/DeepBinderBridgeFactory;", "Lcom/stepos/core/transport/factory/IBridgeFactory;", "", "servicePackage", "<init>", "(Ljava/lang/String;)V", "Landroid/content/ComponentName;", "component", "LY8/t;", "preRegisterComponentInfo", "(Landroid/content/ComponentName;)V", "Landroid/content/Context;", "context", "abilityId", "Lcom/stepos/core/AbilityHandle;", "createHandle", "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/core/AbilityHandle;", "Ljava/lang/String;", "TAG", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeepBinderBridgeFactory implements IBridgeFactory {
    private final String TAG;
    private final String servicePackage;

    /* JADX WARN: Multi-variable type inference failed */
    public DeepBinderBridgeFactory() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IAbilityDeepBinderService createHandle$lambda$2(ComponentName componentName, String str) {
        return (IAbilityDeepBinderService) DeepBinderClient.INSTANCE.create(componentName, "com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl", IAbilityDeepBinderService.class, Pair.create(String.class, str));
    }

    private final void preRegisterComponentInfo(ComponentName component) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        try {
            String str = this.servicePackage + ".DEEP_BINDER_IPC_CALL";
            int i10 = IPCUtilsKt.f30125a;
            Field declaredField = IPCUtilsKt.class.getDeclaredField("componentInternalInfoMap");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            p.g(obj, "null cannot be cast to non-null type java.util.concurrent.ConcurrentHashMap<kotlin.Any, kotlin.Any>");
            Constructor declaredConstructor = ComponentInternalInfo.class.getDeclaredConstructor(String.class, String.class, Uri.class);
            declaredConstructor.setAccessible(true);
            ((ConcurrentHashMap) obj).put(component, declaredConstructor.newInstance(this.servicePackage, Constants.CLASS_PROCESS_STATE_SERVICE, Uri.parse("content://" + str)));
            Log.d(this.TAG, "preRegisterComponentInfo OK: authority=content://" + str + " processName=" + this.servicePackage);
        } catch (Exception e10) {
            Log.e(this.TAG, "preRegisterComponentInfo FAILED: " + e10.getClass().getSimpleName() + ": " + e10);
        }
    }

    @Override // com.stepos.core.transport.factory.IBridgeFactory
    public AbilityHandle createHandle(Context context, final String abilityId) {
        p.i(context, "context");
        p.i(abilityId, "abilityId");
        try {
            final ComponentName componentName = new ComponentName(this.servicePackage, "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider");
            RebuildableAbilityService rebuildableAbilityService = new RebuildableAbilityService(new InterfaceC5063a() { // from class: R6.a
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return DeepBinderBridgeFactory.createHandle$lambda$2(componentName, abilityId);
                }
            });
            return new AbilityHandle(new DeepBinderAbilityProxy(rebuildableAbilityService), new DeepBinderTransportBridge(rebuildableAbilityService));
        } catch (Exception e10) {
            Log.e(this.TAG, "createHandle failed for " + abilityId, e10);
            return null;
        }
    }

    public DeepBinderBridgeFactory(String servicePackage) {
        p.i(servicePackage, "servicePackage");
        this.servicePackage = servicePackage;
        this.TAG = "DeepBinderBridgeFactory";
    }

    public /* synthetic */ DeepBinderBridgeFactory(String str, int i10, i iVar) {
        this((i10 & 1) != 0 ? "com.stepos.aiengine" : str);
    }
}
