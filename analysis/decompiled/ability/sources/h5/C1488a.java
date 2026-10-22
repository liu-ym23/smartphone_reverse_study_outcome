package h5;

import A8.d;
import C7.f;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.stepos.core.DeepBinderAbilityProxy;
import com.stepos.core.c;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import com.stepos.deepbinder.client.DeepBinderClient;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.k;

/* renamed from: h5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1488a {
    public static final F1.a b = new F1.a();
    public static volatile C1488a c;

    /* renamed from: a, reason: collision with root package name */
    public final f f4563a = kotlin.a.a(new com.uxsense.parse.a(this));

    public C1488a(Context context) {
        new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider");
        new CopyOnWriteArrayList();
    }

    public final c a(String abilityId) {
        c cVar;
        k.f(abilityId, "abilityId");
        ((i5.a) this.f4563a.getF4884a()).getClass();
        try {
            IAbilityDeepBinderService iAbilityDeepBinderService = (IAbilityDeepBinderService) DeepBinderClient.INSTANCE.create(new ComponentName("com.stepos.aiengine", "com.stepos.aiengine.deepbinder.AIEngineDeepBinderProvider"), "com.stepos.core.ability.deepbinder.AbilityDeepBinderServiceImpl", IAbilityDeepBinderService.class, Pair.create(String.class, abilityId));
            cVar = new c(new DeepBinderAbilityProxy(iAbilityDeepBinderService), new d(iAbilityDeepBinderService));
        } catch (Exception e) {
            Log.e("DeepBinderBridgeFactory", "createHandle failed for ".concat(abilityId), e);
            cVar = null;
        }
        if (cVar == null) {
            Log.w("AIEngineManager", "createAbility: failed for ".concat(abilityId));
        }
        return cVar;
    }
}
