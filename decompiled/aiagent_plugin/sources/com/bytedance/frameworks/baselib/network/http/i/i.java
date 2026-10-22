package com.bytedance.frameworks.baselib.network.http.i;

import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements ThreadFactory {
    private static final String TAG = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8387a;

    static {
    }

    static /* synthetic */ String a() {
        return TAG;
    }

    static /* synthetic */ String a(i r0) {
        return r0.f8387a;
    }

    public i(String r1) {
        this.f8387a = r1;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "creating newThread " + this.f8387a);
    L6:
        return new Thread(new AnonymousClass1(this, r5), this.f8387a);
    }
}
