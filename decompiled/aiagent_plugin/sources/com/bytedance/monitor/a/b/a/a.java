package com.bytedance.monitor.a.b.a;

import com.bytedance.monitor.a.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ApmInnerThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f8891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0203a f8892d;

    /* JADX INFO: renamed from: com.bytedance.monitor.a.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApmInnerThreadFactory.java */
    public interface InterfaceC0203a {
        void a(long r1);
    }

    static /* synthetic */ InterfaceC0203a a(a r0) {
        return r0.f8892d;
    }

    static /* synthetic */ f b(a r0) {
        return r0.f8891c;
    }

    public a(String r3) {
        this.f8889a = getClass().getSimpleName();
        this.f8890b = "APM_" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return new Thread(new AnonymousClass1(this, r4), this.f8890b);
    }

    public void a(f r3) {
        this.f8891c = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    public void a(InterfaceC0203a r3) {
        this.f8892d = (InterfaceC0203a) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0203a.class, "com.obric.aiagent.plugin");
    }
}
