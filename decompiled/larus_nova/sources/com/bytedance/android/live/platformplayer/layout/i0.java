package com.bytedance.android.live.platformplayer.layout;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class i0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f85651a = null;

    static {
        f85651a = new i0();
    }

    public i0() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Long r101 = (Long) r100;
        if (r101 == null) goto L8;
        long r102 = r101.longValue();
        IPerformanceManager r103 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r103 == null) goto L9;
        r103.onVideoRenderStall(Long.valueOf(r102));
        return;
    L9:
        return;
    }
}
