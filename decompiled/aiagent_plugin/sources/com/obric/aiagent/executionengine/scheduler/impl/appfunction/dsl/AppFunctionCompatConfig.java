package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionCompatConfig {
    private final List<AppFunctionProductConfig> productConfigList;

    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionCompatConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AppFunctionCompatConfig copy$default(AppFunctionCompatConfig r1, List r2, int r3, Object r4) {
        List<AppFunctionProductConfig> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r5 = r1.productConfigList;
    L6:
        return r1.copy(r5);
    }

    public final List<AppFunctionProductConfig> component1() {
        return this.productConfigList;
    }

    public final AppFunctionCompatConfig copy(List<AppFunctionProductConfig> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "productConfigList");
        return new AppFunctionCompatConfig(r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionCompatConfig.class) == true) goto L8;
        return false;
    L8:
        AppFunctionCompatConfig r6 = (AppFunctionCompatConfig) ZeusTransformUtils.preCheckCast(r5, AppFunctionCompatConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.productConfigList, r6.productConfigList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.productConfigList.hashCode();
    }

    public String toString() {
        return "AppFunctionCompatConfig(productConfigList=" + this.productConfigList + ')';
    }

    public AppFunctionCompatConfig(List<AppFunctionProductConfig> r3) {
        List<AppFunctionProductConfig> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "productConfigList");
        this.productConfigList = r4;
    }

    public /* synthetic */ AppFunctionCompatConfig(List r2, int r3, h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = p.b();
    L5:
        this(r5);
    }

    public final List<AppFunctionProductConfig> getProductConfigList() {
        return this.productConfigList;
    }
}
