package com.bytedance.vmsdk.a.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: WriteHandler.java */
/* JADX INFO: loaded from: classes.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedOutputStream f11714a;

    public l(OutputStream r3) {
        this.f11714a = new BufferedOutputStream(r3, 1024);
    }

    public synchronized void a(a r3, k r4) {
        monitor-enter(this);
        k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        r3.a(this.f11714a);     // Catch: IOException -> L6 Throwable -> L10
        this.f11714a.flush();     // Catch: IOException -> L6 Throwable -> L10
        r5.a();     // Catch: IOException -> L6 Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L6:
        e = move-exception;
        r5.a(e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
