package com.bytedance.crash.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: compiled from: EventConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7371c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Set<String> f7372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7373b;

    public g(Set<String> r3) {
        this.f7372a = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
    }

    public static void a(boolean r0) {
        f7371c = r0;
    }

    public boolean a(String r4) {
        if (f7371c == false) goto L6;
        return false;
    L6:
        if (this.f7373b == false) goto L8;
        return true;
    L8:
        Set<String> r3 = this.f7372a;
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.contains(r4) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public String toString() {
        return "EventConfig{sampledService=" + this.f7372a + ", isAllSample=" + this.f7373b + '}';
    }
}
