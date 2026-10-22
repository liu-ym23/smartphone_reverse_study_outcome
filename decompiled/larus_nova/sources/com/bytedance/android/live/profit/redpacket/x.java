package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f88767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f88768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zy0.c f88769c;

    public x(Ref.LongRef r100, JSONObject r101, zy0.b r102) {
        this.f88767a = r100;
        this.f88768b = r101;
        this.f88769c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        long r102 = this.f88767a.element;
        if (r101 != null) goto L6;
    L7:
        boolean r103 = true;
    L9:
        Ref.LongRef r104 = this.f88767a;
        if (r101 == null) goto L12;
        long r105 = r101.longValue();
    L13:
        r104.element = r105;
        if (r103 == true) goto L19;
        if (r101 != null) goto L18;
        return;
    L18:
        if (r101.longValue() == 0) goto L19;
        return;
    L19:
        if (r101 != null) goto L22;
    L24:
        this.f88768b.put("count_down", r101.longValue());
        xy0.a<?> r106 = this.f88769c.g();
        if (r106 == null) goto L29;
        r106.sendJsEvent("H5_webcastNotification", this.f88768b);
        return;
    L29:
        return;
    L22:
        if (r101.longValue() != 0) goto L24;
        int r107 = com.bytedance.android.live.revenue.common.v.f91009a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", "interval native is ready, ts: " + System.currentTimeMillis());
        goto L24
    L12:
        r105 = 0;
        goto L13
    L6:
        if (r102 != r101.longValue()) goto L7;
        r103 = false;
        goto L9
    }
}
