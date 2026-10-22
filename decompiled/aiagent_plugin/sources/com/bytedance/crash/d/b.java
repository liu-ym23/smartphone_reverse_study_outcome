package com.bytedance.crash.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: BizExceptionConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f7341b;

    public b(boolean r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        this.f7340a = r3;
        this.f7341b = r5;
    }

    public boolean a() {
        return this.f7340a;
    }

    public boolean a(String r1) {
        Set<String> r0 = this.f7341b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }

    public String toString() {
        return "BizExceptionConfig{isEnableUpload=" + this.f7340a + ", sampledLogTypes=" + this.f7341b + '}';
    }
}
