package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.PrivilegedAction;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class b implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f31913a;

    public b() {
        this.f31913a = "org.spongycastle.asn1.allow_unsafe_integer";
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        Map r100 = (Map) c.f31914a.get();
        if (r100 == null) goto L7;
        return r100.get(this.f31913a);
    L7:
        return System.getProperty(this.f31913a);
    }
}
