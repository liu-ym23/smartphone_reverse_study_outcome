package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.PrivilegedAction;
import java.util.Map;

/* loaded from: classes.dex */
public final class b implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f7793a = "org.spongycastle.asn1.allow_unsafe_integer";

    @Override // java.security.PrivilegedAction
    public final Object run() {
        Map map = (Map) c.f7794a.get();
        String str = this.f7793a;
        return map != null ? map.get(str) : System.getProperty(str);
    }
}
