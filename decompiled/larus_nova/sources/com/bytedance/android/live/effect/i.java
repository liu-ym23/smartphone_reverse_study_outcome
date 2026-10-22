package com.bytedance.android.live.effect;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f68029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f68030b;

    public i(h r100, String r101) {
        this.f68029a = r100;
        this.f68030b = r101;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "effect sql, duration of " + this.f68030b + ": " + (System.currentTimeMillis() - this.f68029a.f68028a) + ", thread: " + ThreadMethodProxy.currentThread().getName();
    }
}
