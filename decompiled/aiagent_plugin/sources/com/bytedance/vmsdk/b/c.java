package com.bytedance.vmsdk.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: VmSdkServiceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f11731a;

    /* JADX INFO: renamed from: com.bytedance.vmsdk.b.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: VmSdkServiceManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: VmSdkServiceManager.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f11732a = null;

        static {
            f11732a = new c(null);
        }
    }

    /* synthetic */ c(AnonymousClass1 r1) {
        this();
    }

    private c() {
        this.f11731a = new ConcurrentHashMap();
    }

    public static c a() {
        return a.f11732a;
    }

    public <T extends com.bytedance.vmsdk.b.a> T a(Class<T> r2) {
        String r3 = r2.getName();
        Object r1 = this.f11731a.get(r3);
        if (r1 != null) goto L5;
        return null;
    L5:
        return (T) ZeusTransformUtils.preCheckCast(r1, com.bytedance.vmsdk.b.a.class, "com.obric.aiagent.plugin");
    }
}
