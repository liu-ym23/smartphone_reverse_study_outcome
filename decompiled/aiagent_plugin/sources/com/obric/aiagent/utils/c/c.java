package com.obric.aiagent.utils.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: TrustedCallerConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<String> f22343b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22342a, r6.f22342a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22343b, r6.f22343b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f22342a.hashCode() * 31) + this.f22343b.hashCode();
    }

    public String toString() {
        return "TrustedExternalCaller(packageName=" + this.f22342a + ", signatureDigests=" + this.f22343b + ')';
    }

    public c(String r3, Set<String> r4) {
        Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        o.e(r3, "packageName");
        o.e(r5, "signatureDigests");
        this.f22342a = r3;
        this.f22343b = r5;
    }

    public final String a() {
        return this.f22342a;
    }

    public final Set<String> b() {
        return this.f22343b;
    }
}
