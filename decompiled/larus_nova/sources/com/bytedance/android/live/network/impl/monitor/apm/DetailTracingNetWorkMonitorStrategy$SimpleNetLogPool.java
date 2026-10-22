package com.bytedance.android.live.network.impl.monitor.apm;

import androidx.core.util.Pools;
import eo0.a;

/* JADX INFO: loaded from: classes46.dex */
public class DetailTracingNetWorkMonitorStrategy$SimpleNetLogPool extends Pools.SynchronizedPool<a> {
    public DetailTracingNetWorkMonitorStrategy$SimpleNetLogPool() {
        super(20);
    }

    public final a a() {
        a r100 = (a) super.acquire();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new a();
    }

    @Override // androidx.core.util.Pools.SynchronizedPool, androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
    public final /* bridge */ /* synthetic */ Object acquire() {
        return a();
    }

    public final boolean b(a r100) {
        r100.f473252d = "";
        r100.f473249a = "";
        r100.f473250b = "";
        r100.f473253e = 0;
        r100.f473254f = 0;
        r100.f473251c = "";
        return super.release(r100);
    }

    @Override // androidx.core.util.Pools.SynchronizedPool, androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
    public final /* bridge */ /* synthetic */ boolean release(Object r100) {
        return b((a) r100);
    }
}
