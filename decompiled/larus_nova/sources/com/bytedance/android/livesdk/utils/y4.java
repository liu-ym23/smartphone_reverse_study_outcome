package com.bytedance.android.livesdk.utils;

import android.net.nsd.NsdManager;

/* JADX INFO: loaded from: classes11.dex */
public final class y4 implements MdnsServiceManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NsdManager f159221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4 f159222b;

    @Override // com.bytedance.android.livesdk.utils.MdnsServiceManager.c
    public final void a() {
        this.f159221a.stopServiceDiscovery(this.f159222b);
    }

    public y4(NsdManager r100, x4 r101) {
        this.f159221a = r100;
        this.f159222b = r101;
    }
}
