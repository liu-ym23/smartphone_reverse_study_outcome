package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i> f18239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18240b;

    public final List<i> a() {
        return this.f18239a;
    }

    public final String b() {
        return this.f18240b;
    }

    public b(List<? extends i> r3, String r4, boolean r5, String r6) {
        List<i> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "matchAll");
        d.h.b.o.e(r6, "description");
        super(r5, r6);
        this.f18239a = r7;
        this.f18240b = r4;
    }
}
