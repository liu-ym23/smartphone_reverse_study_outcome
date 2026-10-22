package com.bytedance.android.live.browser.jsbridge.prefetch;

import com.bytedance.android.live.network.api.INetworkService;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes45.dex */
public final class k<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrefetchNetworkExecutorImpl f63809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f63810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f63811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f63812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.protobuf.a f63813e;

    public k(PrefetchNetworkExecutorImpl r100, String r101, Map r102, Map r103, com.bytedance.android.live.browser.jsbridge.protobuf.a r104) {
        this.f63809a = r100;
        this.f63810b = r101;
        this.f63811c = r102;
        this.f63812d = r103;
        this.f63813e = r104;
    }

    @Override // java.util.concurrent.Callable
    public final com.bytedance.ies.tools.prefetch.i.b call() {
        PrefetchNetworkExecutorImpl r100 = this.f63809a;
        INetworkService r101 = (INetworkService) jc1.k.n(INetworkService.class);
        String r102 = this.f63810b;
        PrefetchNetworkExecutorImpl r103 = this.f63809a;
        Map r104 = this.f63811c;
        Map r105 = this.f63812d;
        if (this.f63813e != null) goto L5;
        boolean r106 = true;
    L7:
        return PrefetchNetworkExecutorImpl.e(r100, r101.get(r102, PrefetchNetworkExecutorImpl.d(r103, PrefetchNetworkExecutorImpl.c(r103, r104, r105, r106))).execute(), this.f63810b, this.f63812d, this.f63813e);
    L5:
        r106 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
