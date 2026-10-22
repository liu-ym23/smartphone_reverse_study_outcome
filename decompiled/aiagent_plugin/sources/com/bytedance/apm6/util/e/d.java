package com.bytedance.apm6.util.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SingleThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5478a;

    static /* synthetic */ String a(d r0) {
        return r0.f5478a;
    }

    public d(String r3) {
        this.f5478a = "APM6-" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (com.bytedance.apm6.util.a.u() == false) goto L6;
        com.bytedance.apm6.util.c.b.a("APM-AsyncTask", "creating newThread " + this.f5478a);
    L6:
        return new Thread(new AnonymousClass1(this, r4), this.f5478a);
    }
}
