package com.stepos.aiengine.client;

import R4.a;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.deepbinder.client.DeepBinderClient;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/aiengine/client/AbilityServiceClient;", "", "Landroid/content/Context;", "context", "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "get", "(Landroid/content/Context;)Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "R4/a", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityServiceClient {
    public static final AbilityServiceClient INSTANCE = new AbilityServiceClient();

    /* renamed from: a, reason: collision with root package name */
    public static volatile IAIEngineDeepBinderService f3505a;

    public static IAIEngineDeepBinderService a() {
        try {
            Object objCreate = DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ability.deepbinder.AIEngineDeepBinderServiceImpl", IAIEngineDeepBinderService.class, new Pair[0]);
            Log.d("AbilityServiceClient", "create succeeded");
            return (IAIEngineDeepBinderService) objCreate;
        } catch (Exception e) {
            Log.e("AbilityServiceClient", "create failed, returning no-op stub", e);
            return a.f1151a;
        }
    }

    public final IAIEngineDeepBinderService get(Context context) {
        IAIEngineDeepBinderService iAIEngineDeepBinderServiceA;
        k.f(context, "context");
        IAIEngineDeepBinderService iAIEngineDeepBinderService = f3505a;
        if (iAIEngineDeepBinderService != null) {
            return iAIEngineDeepBinderService;
        }
        synchronized (this) {
            iAIEngineDeepBinderServiceA = f3505a;
            if (iAIEngineDeepBinderServiceA == null) {
                INSTANCE.getClass();
                iAIEngineDeepBinderServiceA = a();
                f3505a = iAIEngineDeepBinderServiceA;
            }
        }
        return iAIEngineDeepBinderServiceA;
    }
}
