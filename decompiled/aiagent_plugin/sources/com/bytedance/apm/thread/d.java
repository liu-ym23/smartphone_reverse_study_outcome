package com.bytedance.apm.thread;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: compiled from: ThreadWithBlockingQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f4882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Runnable> f4883b;

    static /* synthetic */ BlockingQueue a(d r0) {
        return r0.f4883b;
    }

    public d(String r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        this.f4883b = new LinkedTransferQueue();
    L6:
        this.f4882a = new Thread(new AnonymousClass1(this), r3);
        return;
    L5:
        this.f4883b = new LinkedBlockingQueue();
        goto L6
    }

    public void a() {
        this.f4882a.start();
    }

    public final boolean a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return this.f4883b.offer(r4);
    }
}
