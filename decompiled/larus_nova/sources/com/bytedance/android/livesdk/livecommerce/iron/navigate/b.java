package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import io.reactivex.functions.Consumer;
import si2.g;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ il2.a f148852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ yk.a f148853b;

    public b(LiveActionTracker r100, yk.a r101) {
        this.f148852a = r100;
        this.f148853b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        il2.a r102 = this.f148852a;
        if (r102 == null) goto L7;
        il2.a r103 = il2.a.C6280a.a(r102, "req_get_fail", null, false, r101.getMessage(), null, null, 48);
        if (r103 == null) goto L7;
        ((LiveActionTracker) r103).e(false);
    L7:
        ECExceptionMonitor.e(r101);
        yk.a r104 = this.f148853b;
        if (r104 == null) goto L11;
        r104.onFailure(g.f542161k, r101);
        return;
    }
}
