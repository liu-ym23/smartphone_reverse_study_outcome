package com.bytedance.common.wschannel.e;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: WsThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements ThreadFactory {
    private static final String TAG = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6953a;

    static {
    }

    static /* synthetic */ String a() {
        return TAG;
    }

    static /* synthetic */ String a(f r0) {
        return r0.f6953a;
    }

    public f(String r3) {
        this.f6953a = "WsChannel-" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "creating newThread " + this.f6953a);
    L6:
        return new Thread(new AnonymousClass1(this, r5), this.f6953a);
    }
}
