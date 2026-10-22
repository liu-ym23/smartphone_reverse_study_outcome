package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import com.bytedance.android.live.base.model.message.m5;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f99671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnchorTrafficSupportDataChangeMonitor f99672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m5 f99673c;

    public a(long r100, AnchorTrafficSupportDataChangeMonitor r101, m5 r102) {
        this.f99671a = r100;
        this.f99672b = r101;
        this.f99673c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        AnchorTrafficSupportDataChangeMonitor r102 = this.f99672b;
        int r103 = w81.b.f558614e;
        w81.a r104 = r102.f99631i.get(Long.valueOf(this.f99671a));
        if (r104 != null) goto L5;
        r104 = this.f99672b.f99630h;
    L5:
        r102.f(w81.b.a.b(r104));
        this.f99672b.f99635m.put(Long.valueOf(this.f99671a), Boolean.FALSE);
    }
}
