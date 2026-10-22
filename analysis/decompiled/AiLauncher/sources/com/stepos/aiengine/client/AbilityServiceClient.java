package com.stepos.aiengine.client;

import Y8.t;
import Z8.C1173v;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ability.AbilityInfo;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.ICTACallback;
import com.stepos.core.deepbinder.IModelChangeListener;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/aiengine/client/AbilityServiceClient;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "get", "(Landroid/content/Context;)Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "LY8/t;", "invalidate", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "svc", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AbilityServiceClient {
    public static final AbilityServiceClient INSTANCE = new AbilityServiceClient();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static volatile IAIEngineDeepBinderService svc;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\fJ'\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/stepos/aiengine/client/AbilityServiceClient$a;", "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "<init>", "()V", "", "Lcom/stepos/core/ability/AbilityInfo;", "getAbilities", "()Ljava/util/List;", "", "id", "", "containsAbility", "(Ljava/lang/String;)Z", "isDeviceSupported", "", "getAbilityState", "(Ljava/lang/String;)I", "name", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Void;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/Void;", "checkEnable", "checkCloudEnable", UxipConstants.f30680s, "setAbilityProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "Lcom/stepos/core/deepbinder/ICTACallback;", "callback", "LY8/t;", "showCTADialog", "(Lcom/stepos/core/deepbinder/ICTACallback;)V", "openEnhancedServiceSettings", "()I", "listenerId", "Lcom/stepos/core/deepbinder/IModelChangeListener;", "listener", "registerGlobalModelChangeListener", "(Ljava/lang/String;Lcom/stepos/core/deepbinder/IModelChangeListener;)V", "unregisterGlobalModelChangeListener", "(Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements IAIEngineDeepBinderService {

        /* renamed from: a, reason: collision with root package name */
        public static final a f23714a = new a();

        public Void a(String id) {
            p.i(id, "id");
            return null;
        }

        public Void b(String id, String name) {
            p.i(id, "id");
            p.i(name, "name");
            return null;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public boolean checkCloudEnable(String id) {
            p.i(id, "id");
            return false;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public boolean checkEnable(String id) {
            p.i(id, "id");
            return false;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public /* bridge */ /* synthetic */ Boolean checkModelReady(String str) {
            return (Boolean) a(str);
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public boolean containsAbility(String id) {
            p.i(id, "id");
            return false;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public List<AbilityInfo> getAbilities() {
            return C1173v.m();
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public /* bridge */ /* synthetic */ String getAbilityProperty(String str, String str2) {
            return (String) b(str, str2);
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public int getAbilityState(String id) {
            p.i(id, "id");
            return -2;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public boolean isDeviceSupported(String id) {
            p.i(id, "id");
            return false;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public int openEnhancedServiceSettings() {
            return 1;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public void registerGlobalModelChangeListener(String listenerId, IModelChangeListener listener) {
            p.i(listenerId, "listenerId");
            p.i(listener, "listener");
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public boolean setAbilityProperty(String id, String name, String value) {
            p.i(id, "id");
            p.i(name, "name");
            p.i(value, "value");
            return false;
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public void showCTADialog(ICTACallback callback) {
            p.i(callback, "callback");
        }

        @Override // com.stepos.core.deepbinder.IAIEngineDeepBinderService
        public void unregisterGlobalModelChangeListener(String listenerId) {
            p.i(listenerId, "listenerId");
        }
    }

    public final IAIEngineDeepBinderService a(Context context) {
        try {
            Object objCreate = DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ability.deepbinder.AIEngineDeepBinderServiceImpl", IAIEngineDeepBinderService.class, new Pair[0]);
            Log.d("AbilityServiceClient", "create succeeded");
            return (IAIEngineDeepBinderService) objCreate;
        } catch (Exception e10) {
            Log.e("AbilityServiceClient", "create failed, returning no-op stub", e10);
            return a.f23714a;
        }
    }

    public final IAIEngineDeepBinderService get(Context context) {
        IAIEngineDeepBinderService iAIEngineDeepBinderServiceA;
        p.i(context, "context");
        IAIEngineDeepBinderService iAIEngineDeepBinderService = svc;
        if (iAIEngineDeepBinderService != null) {
            return iAIEngineDeepBinderService;
        }
        synchronized (this) {
            iAIEngineDeepBinderServiceA = svc;
            if (iAIEngineDeepBinderServiceA == null && (iAIEngineDeepBinderServiceA = INSTANCE.a(context)) != a.f23714a) {
                svc = iAIEngineDeepBinderServiceA;
            }
        }
        return iAIEngineDeepBinderServiceA;
    }

    public final void invalidate() {
        synchronized (this) {
            svc = null;
            t tVar = t.f7040a;
        }
        Log.w("AbilityServiceClient", "proxy invalidated, will re-create on next call");
    }
}
