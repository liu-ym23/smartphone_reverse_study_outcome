package com.bytedance.apm6.commonevent.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: CommonEventConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f5042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f5043b;

    public a(Set<String> r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        this.f5042a = r5;
        this.f5043b = r6;
    }

    public boolean a(String r1) {
        Set<String> r0 = this.f5042a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public boolean b(String r1) {
        Set<String> r0 = this.f5043b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.contains(r1) == false) goto L7;
        return true;
    }

    public String toString() {
        return "CommonEventConfig{sampledService=" + this.f5042a + ", sampledLogType=" + this.f5043b + '}';
    }
}
