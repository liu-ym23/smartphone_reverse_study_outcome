package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ah extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f18223a;

    public ah(boolean r3, String r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "description");
        super(r3, r4);
        this.f18223a = r6;
    }
}
