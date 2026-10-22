package com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDataTypeMetadata.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, i> f18301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f18302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18303c;

    public /* synthetic */ s(Map r8, List r9, String r10, boolean r11, String r12, int r13, d.h.b.h r14) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 16) == 0) goto L5;
        r12 = "";
    L5:
        this(r2, r3, r10, r11, r12);
    }

    public final Map<String, i> a() {
        return this.f18301a;
    }

    public final List<String> b() {
        return this.f18302b;
    }

    public final String d() {
        return this.f18303c;
    }

    public s(Map<String, ? extends i> r3, List<String> r4, String r5, boolean r6, String r7) {
        Map<String, i> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "properties");
        d.h.b.o.e(r9, "required");
        d.h.b.o.e(r7, "description");
        super(r6, r7);
        this.f18301a = r8;
        this.f18302b = r9;
        this.f18303c = r5;
    }
}
