package com.stepos.aiengine.modelchange;

import Xa.d;
import com.stepos.core.deepbinder.IAIEngineDeepBinderService;
import com.stepos.core.deepbinder.IAbilityDeepBinderService;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;", "LXa/b;", "Lcom/stepos/aiengine/modelchange/ModelChangeEvent;", "getModelChanges", "(Lcom/stepos/core/deepbinder/IAbilityDeepBinderService;)LXa/b;", "modelChanges", "Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;", "getAllModelChanges", "(Lcom/stepos/core/deepbinder/IAIEngineDeepBinderService;)LXa/b;", "allModelChanges", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ModelChangeKt {
    public static final Xa.b<ModelChangeEvent> getAllModelChanges(IAIEngineDeepBinderService iAIEngineDeepBinderService) {
        p.i(iAIEngineDeepBinderService, "<this>");
        return d.f(new ModelChangeKt$allModelChanges$1(iAIEngineDeepBinderService, null));
    }

    public static final Xa.b<ModelChangeEvent> getModelChanges(IAbilityDeepBinderService iAbilityDeepBinderService) {
        p.i(iAbilityDeepBinderService, "<this>");
        return d.f(new ModelChangeKt$modelChanges$1(iAbilityDeepBinderService, null));
    }
}
