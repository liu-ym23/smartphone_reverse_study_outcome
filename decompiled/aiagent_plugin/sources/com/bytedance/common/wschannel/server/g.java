package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MainChannelManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7065a;

    public static b a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (f7065a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7065a != null) goto L9;
        f7065a = b(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f7065a;
    }

    private static b b(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        HandlerThread r10 = new HandlerThread("wschannel");
        r10.start();
        a r4 = new a();
        h r7 = new h(r1, r4);
        e r6 = new AnonymousClass1();
        b r8 = new b(r1, r10.getLooper(), new AnonymousClass2(), r4, r7, r6);
        r7.a(r8);
        return r8;
    }
}
