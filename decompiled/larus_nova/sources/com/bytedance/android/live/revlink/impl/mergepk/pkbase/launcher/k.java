package com.bytedance.android.live.revlink.impl.mergepk.pkbase.launcher;

import com.bytedance.android.livesdk.link.model.IPropInfoNotifyResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f92837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f92838b;

    public k(j r100, long r101) {
        this.f92837a = r100;
        this.f92838b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = this.f92838b - ((long) 3);
        d51.c r103 = d51.c.A0;
        r103.getClass();
        if (r102 <= ((Number) d51.c.f466926f0.getValue(r103, d51.c.f466915a[56])).longValue()) goto L5;
        this.f92837a.a(IPropInfoNotifyResponse.RequestPropCardNotifyType.TypeAvailable.ordinal());
        return;
    L5:
        this.f92837a.a(IPropInfoNotifyResponse.RequestPropCardNotifyType.TypeExpired.ordinal());
    }
}
