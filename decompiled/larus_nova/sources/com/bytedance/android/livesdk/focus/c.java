package com.bytedance.android.livesdk.focus;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f125334a;

    public c(int r100) {
        this.f125334a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.d("FocusWidget", "set exposure: " + this.f125334a);
        if (qc1.a.f532433a.getValue().booleanValue() == false) goto L6;
        NewBroadcastMonitor.a r102 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.ANCHOR_SET_EXPOSURE, null, null, 14);
        r102.l(0);
        r102.i("status_msg", "LiveFocusWidget set exposure");
        r102.m("exposure value: " + this.f125334a);
        r102.a().report();
        return;
    }
}
