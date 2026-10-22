package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionIntentMapping {
    private final List<AppFunctionNode> functions;
    private final AppFunctionResultNode result;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionIntentMapping() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppFunctionIntentMapping copy$default(AppFunctionIntentMapping r1, List r2, AppFunctionResultNode r3, int r4, Object r5) {
        List<AppFunctionNode> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.functions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.result;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<AppFunctionNode> component1() {
        return this.functions;
    }

    public final AppFunctionResultNode component2() {
        return this.result;
    }

    public final AppFunctionIntentMapping copy(List<AppFunctionNode> r2, AppFunctionResultNode r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "functions");
        return new AppFunctionIntentMapping(r1, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionIntentMapping.class) == true) goto L8;
        return false;
    L8:
        AppFunctionIntentMapping r6 = (AppFunctionIntentMapping) ZeusTransformUtils.preCheckCast(r5, AppFunctionIntentMapping.class, "com.obric.aiagent.plugin");
        if (o.a(this.functions, r6.functions) == true) goto L12;
        return false;
    L12:
        if (o.a(this.result, r6.result) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.functions.hashCode() * 31;
        AppFunctionResultNode r1 = this.result;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AppFunctionIntentMapping(functions=" + this.functions + ", result=" + this.result + ')';
    }

    public AppFunctionIntentMapping(List<AppFunctionNode> r3, AppFunctionResultNode r4) {
        List<AppFunctionNode> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "functions");
        this.functions = r5;
        this.result = r4;
    }

    public /* synthetic */ AppFunctionIntentMapping(List r2, AppFunctionResultNode r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = p.b();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r6, r3);
    }

    public final List<AppFunctionNode> getFunctions() {
        return this.functions;
    }

    public final AppFunctionResultNode getResult() {
        return this.result;
    }
}
