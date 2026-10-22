package com.bytedance.applog.d;

import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: GlobalExceptionHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.bytedance.applog.util.a<a> f5570c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<b> f5571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f5572b;

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static {
        f5570c = new AnonymousClass1();
    }

    public static a a() {
        return (a) ZeusTransformUtils.preCheckCast(f5570c.c(new Object[0]), a.class, "com.obric.aiagent.plugin");
    }

    private a() {
        this.f5571a = new CopyOnWriteArraySet();
        this.f5572b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        this.f5571a.add(r4);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r5, Throwable r6) {
        Iterator<b> r0 = this.f5571a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.aiagent.plugin")).a(r5, r6);
        goto L4
    L6:
        a(r5, r6);
    }

    private void a(Thread r1, Throwable r2) {
        Thread.UncaughtExceptionHandler r0 = this.f5572b;
        if (r0 == null) goto L8;
        r0.uncaughtException(r1, r2);
        return;
    L8:
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L7
        System.exit(10);     // Catch: Throwable -> L7
        return;
    }
}
