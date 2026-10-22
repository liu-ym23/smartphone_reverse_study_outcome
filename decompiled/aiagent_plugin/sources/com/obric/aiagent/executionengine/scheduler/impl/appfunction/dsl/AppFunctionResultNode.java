package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionResultNode {
    private final List<AppFunctionCodeMapping> codeMappings;
    private final AppFunctionEntityTemplate entity;
    private final Map<String, AppFunctionValueMapping> ext;

    public AppFunctionResultNode() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AppFunctionResultNode copy$default(AppFunctionResultNode r1, AppFunctionEntityTemplate r2, Map r3, List r4, int r5, Object r6) {
        Map<String, AppFunctionValueMapping> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List<AppFunctionCodeMapping> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.entity;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.ext;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.codeMappings;
    L12:
        return r1.copy(r2, r7, r8);
    }

    public final AppFunctionEntityTemplate component1() {
        return this.entity;
    }

    public final Map<String, AppFunctionValueMapping> component2() {
        return this.ext;
    }

    public final List<AppFunctionCodeMapping> component3() {
        return this.codeMappings;
    }

    public final AppFunctionResultNode copy(AppFunctionEntityTemplate r2, Map<String, AppFunctionValueMapping> r3, List<AppFunctionCodeMapping> r4) {
        return new AppFunctionResultNode(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionResultNode.class) == true) goto L8;
        return false;
    L8:
        AppFunctionResultNode r6 = (AppFunctionResultNode) ZeusTransformUtils.preCheckCast(r5, AppFunctionResultNode.class, "com.obric.aiagent.plugin");
        if (o.a(this.entity, r6.entity) == true) goto L12;
        return false;
    L12:
        if (o.a(this.ext, r6.ext) == true) goto L15;
        return false;
    L15:
        if (o.a(this.codeMappings, r6.codeMappings) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        AppFunctionEntityTemplate r0 = this.entity;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, AppFunctionValueMapping> r4 = this.ext;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<AppFunctionCodeMapping> r7 = this.codeMappings;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFunctionResultNode(entity=" + this.entity + ", ext=" + this.ext + ", codeMappings=" + this.codeMappings + ')';
    }

    public AppFunctionResultNode(AppFunctionEntityTemplate r3, Map<String, AppFunctionValueMapping> r4, List<AppFunctionCodeMapping> r5) {
        Map<String, AppFunctionValueMapping> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<AppFunctionCodeMapping> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.entity = r3;
        this.ext = r6;
        this.codeMappings = r7;
    }

    public /* synthetic */ AppFunctionResultNode(AppFunctionEntityTemplate r2, Map r3, List r4, int r5, h r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r8 = null;
    L11:
        this(r2, r7, r8);
    }

    public final AppFunctionEntityTemplate getEntity() {
        return this.entity;
    }

    public final Map<String, AppFunctionValueMapping> getExt() {
        return this.ext;
    }

    public final List<AppFunctionCodeMapping> getCodeMappings() {
        return this.codeMappings;
    }
}
