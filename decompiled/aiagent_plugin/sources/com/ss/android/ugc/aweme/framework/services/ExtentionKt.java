package com.ss.android.ugc.aweme.framework.services;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.m.c;
import java.util.Set;

/* JADX INFO: compiled from: Extention.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExtentionKt {
    public static final /* synthetic */ <T> T getService(c<T> r2) {
        o.d((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"), "$this$getService");
        ServiceManager r3 = ServiceManager.get();
        o.a(4, "T");
        return (T) r3.getService(Object.class);
    }

    public static final /* synthetic */ <T> T getService(Class<T> r2) {
        o.d(r2, "$this$getService");
        ServiceManager r3 = ServiceManager.get();
        o.a(4, "T");
        return (T) r3.getService(Object.class);
    }

    public static final /* synthetic */ <T> Set<T> getServices(c<T> r2) {
        o.d((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin"), "$this$getServices");
        ServiceManager r3 = ServiceManager.get();
        o.a(4, "T");
        Set<T> r4 = r3.getServices(Object.class);
        o.b(r4, "ServiceManager.get().getServices(T::class.java)");
        return r4;
    }

    public static final /* synthetic */ <T> Set<T> getServices(Class<T> r2) {
        o.d(r2, "$this$getServices");
        ServiceManager r3 = ServiceManager.get();
        o.a(4, "T");
        Set<T> r4 = r3.getServices(Object.class);
        o.b(r4, "ServiceManager.get().getServices(T::class.java)");
        return r4;
    }
}
