package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionEntityTemplate {
    private final Integer entityType;
    private final Map<String, AppFunctionValueMapping> fields;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionEntityTemplate() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppFunctionEntityTemplate copy$default(AppFunctionEntityTemplate r1, Integer r2, Map r3, int r4, Object r5) {
        Map<String, AppFunctionValueMapping> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.entityType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.fields;
    L9:
        return r1.copy(r2, r6);
    }

    public final Integer component1() {
        return this.entityType;
    }

    public final Map<String, AppFunctionValueMapping> component2() {
        return this.fields;
    }

    public final AppFunctionEntityTemplate copy(Integer r2, Map<String, AppFunctionValueMapping> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r1, "fields");
        return new AppFunctionEntityTemplate(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionEntityTemplate.class) == true) goto L8;
        return false;
    L8:
        AppFunctionEntityTemplate r6 = (AppFunctionEntityTemplate) ZeusTransformUtils.preCheckCast(r5, AppFunctionEntityTemplate.class, "com.obric.aiagent.plugin");
        if (o.a(this.entityType, r6.entityType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.fields, r6.fields) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.entityType;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.fields.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "AppFunctionEntityTemplate(entityType=" + this.entityType + ", fields=" + this.fields + ')';
    }

    public AppFunctionEntityTemplate(Integer r3, Map<String, AppFunctionValueMapping> r4) {
        Map<String, AppFunctionValueMapping> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r5, "fields");
        this.entityType = r3;
        this.fields = r5;
    }

    public final Integer getEntityType() {
        return this.entityType;
    }

    public /* synthetic */ AppFunctionEntityTemplate(Integer r2, Map r3, int r4, h r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = ao.b();
    L8:
        this(r2, r6);
    }

    public final Map<String, AppFunctionValueMapping> getFields() {
        return this.fields;
    }
}
