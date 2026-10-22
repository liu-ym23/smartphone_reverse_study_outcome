package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionProductConfig {
    private final Map<String, AppFunctionIntentMapping> intents;
    private final boolean matchAll;
    private final String name;
    private final List<String> productNames;

    public AppFunctionProductConfig() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ AppFunctionProductConfig copy$default(AppFunctionProductConfig r1, String r2, List r3, boolean r4, Map r5, int r6, Object r7) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionIntentMapping> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.name;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.productNames;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.matchAll;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.intents;
    L15:
        return r1.copy(r2, r8, r4, r9);
    }

    public final String component1() {
        return this.name;
    }

    public final List<String> component2() {
        return this.productNames;
    }

    public final boolean component3() {
        return this.matchAll;
    }

    public final Map<String, AppFunctionIntentMapping> component4() {
        return this.intents;
    }

    public final AppFunctionProductConfig copy(String r2, List<String> r3, boolean r4, Map<String, AppFunctionIntentMapping> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r6, "intents");
        return new AppFunctionProductConfig(r2, r1, r4, r6);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionProductConfig.class) == true) goto L8;
        return false;
    L8:
        AppFunctionProductConfig r6 = (AppFunctionProductConfig) ZeusTransformUtils.preCheckCast(r5, AppFunctionProductConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.name, r6.name) == true) goto L12;
        return false;
    L12:
        if (o.a(this.productNames, r6.productNames) == true) goto L15;
        return false;
    L15:
        if (this.matchAll == r6.matchAll) goto L18;
        return false;
    L18:
        if (o.a(this.intents, r6.intents) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.productNames;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((r3 + r1) * 31) + Boolean.hashCode(this.matchAll)) * 31) + this.intents.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFunctionProductConfig(name=" + this.name + ", productNames=" + this.productNames + ", matchAll=" + this.matchAll + ", intents=" + this.intents + ')';
    }

    public AppFunctionProductConfig(String r3, List<String> r4, boolean r5, Map<String, AppFunctionIntentMapping> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        Map<String, AppFunctionIntentMapping> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "intents");
        this.name = r3;
        this.productNames = r7;
        this.matchAll = r5;
        this.intents = r8;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getProductNames() {
        return this.productNames;
    }

    public final boolean getMatchAll() {
        return this.matchAll;
    }

    public /* synthetic */ AppFunctionProductConfig(String r2, List r3, boolean r4, Map r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r9 = ao.b();
    L14:
        this(r2, r8, r4, r9);
    }

    public final Map<String, AppFunctionIntentMapping> getIntents() {
        return this.intents;
    }
}
