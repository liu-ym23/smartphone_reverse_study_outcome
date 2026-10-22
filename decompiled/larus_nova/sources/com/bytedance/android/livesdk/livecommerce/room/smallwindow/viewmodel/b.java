package com.bytedance.android.livesdk.livecommerce.room.smallwindow.viewmodel;

import android.os.Handler;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.List;
import vi2.v0;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements v0<yi2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f151894a;

    public b(a r100) {
        this.f151894a = r100;
    }

    @Override // vi2.v0
    public final void onError(Throwable r100) {
        if (r100 != null) goto L4;
        r100 = new Throwable("query LiveSmallWindowInfo fail");
    L4:
        ECExceptionMonitor.e(r100);
    }

    @Override // vi2.v0
    public final void onSuccess(yi2.a r100) {
        yi2.a r101 = r100;
        dm.a.a("LiveSmallWindowViewModel").a(String.valueOf(r101));
        if (r101 == null) goto L17;
        List<yi2.b> r102 = r101.b();
        if (r102 == null) goto L18;
        Long r103 = r101.a();
        if (r103 == null) goto L9;
        long r104 = r103.longValue();
    L11:
        if (r104 <= 0) goto L13;
        ((Handler) this.f151894a.f151888a.getValue()).postDelayed(this.f151894a.f151889b, r104 * ((long) 1000));
    L13:
        a.b r105 = this.f151894a.f151890c;
        if (r105 == null) goto L19;
        r105.d(r102);
        return;
    L19:
        return;
    L9:
        r104 = -1;
        goto L11
    L18:
        return;
    }
}
