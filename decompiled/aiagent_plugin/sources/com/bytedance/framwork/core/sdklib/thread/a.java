package com.bytedance.framwork.core.sdklib.thread;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: AsyncEventManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f8661d = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<b> f8662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadWithHandler f8663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f8664c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Runnable f8665e;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.thread.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncEventManager.java */
    private static final class C0194a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f8667a = null;

        static {
            f8667a = new a(null);
        }
    }

    static {
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.f8664c;
    }

    static /* synthetic */ long b() {
        return f8661d;
    }

    static /* synthetic */ ThreadWithHandler b(a r0) {
        return r0.f8663b;
    }

    private a() {
        this.f8664c = true;
        this.f8665e = new AnonymousClass1(this);
        this.f8662a = new CopyOnWriteArraySet();
        ThreadWithHandler r0 = new ThreadWithHandler("AsyncEventManager-Thread");
        this.f8663b = r0;
        r0.a();
    }

    public static a a() {
        return C0194a.f8667a;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.f8663b.a(r4);
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.f8663b.a(r5, r4);
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L11;
        this.f8662a.add(r4);     // Catch: Throwable -> L8
        if (this.f8664c == false) goto L12;
        this.f8663b.b(this.f8665e);     // Catch: Throwable -> L8
        this.f8663b.a(this.f8665e, f8661d);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }
}
