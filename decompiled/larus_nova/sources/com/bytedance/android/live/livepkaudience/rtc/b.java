package com.bytedance.android.live.livepkaudience.rtc;

import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.liveinteract.plantform.core.v;
import gy.h;
import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f82213a;

    public b(a r100) {
        this.f82213a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        gy.a r102 = this.f82213a.f82194r;
        h r103 = r102.f483307f;
        LiveTracingMonitor.EventModule r104 = LiveTracingMonitor.b(0);
        HashMap<String, Object> r105 = r102.a();
        int r106 = h.f483311d;
        r103.m(r104, "start_time_out", r105, false);
        v r107 = this.f82213a.f82180d;
        if (r107 == null) goto L6;
        r107.R(10001, new IllegalStateException("start time out"));
        return;
    }
}
