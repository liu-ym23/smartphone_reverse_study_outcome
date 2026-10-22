package com.stepos.ailauncher.contract.api.aispace;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabRegistrar;", "", "Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabRegistry;", "registry", "LY8/t;", "registerTabs", "(Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabRegistry;)V", "unregisterTabs", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAiSpaceTabRegistrar {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void unregisterTabs(IAiSpaceTabRegistrar iAiSpaceTabRegistrar, IAiSpaceTabRegistry registry) {
            p.i(registry, "registry");
            IAiSpaceTabRegistrar.super.unregisterTabs(registry);
        }
    }

    void registerTabs(IAiSpaceTabRegistry registry);

    default void unregisterTabs(IAiSpaceTabRegistry registry) {
        p.i(registry, "registry");
    }
}
