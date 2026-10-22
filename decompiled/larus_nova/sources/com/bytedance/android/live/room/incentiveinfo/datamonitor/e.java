package com.bytedance.android.live.room.incentiveinfo.datamonitor;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f99676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomIndicatorDataChangeMonitor f99677b;

    public e(long r100, RoomIndicatorDataChangeMonitor r101) {
        this.f99676a = r100;
        this.f99677b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        w81.a r102 = this.f99677b.f99666l.get(Long.valueOf(this.f99676a));
        if (r102 == null) goto L6;
        RoomIndicatorDataChangeMonitor r103 = this.f99677b;
        int r104 = w81.b.f558614e;
        r103.f(w81.b.a.b(r102));
        return;
    }
}
