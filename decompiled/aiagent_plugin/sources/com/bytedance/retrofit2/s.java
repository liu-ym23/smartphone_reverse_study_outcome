package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Invocation.java */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f9587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<?> f9588b;

    s(Method r3, List<?> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f9587a = r3;
        this.f9588b = Collections.unmodifiableList(r5);
    }

    public Method a() {
        return this.f9587a;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f9587a.getDeclaringClass().getName(), this.f9587a.getName(), this.f9588b});
    }
}
