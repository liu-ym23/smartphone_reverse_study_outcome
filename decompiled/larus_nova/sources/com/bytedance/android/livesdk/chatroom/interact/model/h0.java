package com.bytedance.android.livesdk.chatroom.interact.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f106759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f106760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f106761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.revlink.impl.pk.vm.linkout.p f106762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f106763e;

    public h0() {
    }

    public final void a(Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r110, "logMap");
        Long r100 = Long.valueOf(this.f106760b);
        boolean r101 = false;
        if (r100.longValue() == 0) goto L5;
        boolean r102 = true;
    L6:
        Long r103 = null;
        if (r102 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        r100.longValue();
        i97.a r104 = i97.a.f488802a;
        r110.put("match_time", String.valueOf((System.currentTimeMillis() - this.f106760b) / ((long) 1000)));
    L13:
        Long r105 = Long.valueOf(this.f106761c);
        if (r105.longValue() == 0) goto L16;
        r101 = true;
    L16:
        if (r101 == false) goto L18;
        r103 = r105;
    L18:
        if (r103 == null) goto L20;
        r103.longValue();
        i97.a r106 = i97.a.f488802a;
        r110.put("speedup_time", String.valueOf((System.currentTimeMillis() - this.f106761c) / ((long) 1000)));
    L20:
        String r107 = "1";
        if (this.f106761c == 0) goto L23;
        r110.put("speedup_status", "2");
    L24:
        r110.put("pk_automatch_type", String.valueOf(this.f106759a));
        if (this.f106763e == true) goto L28;
        r107 = "0";
    L28:
        r110.put("if_strategy_invite", r107);
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.p r108 = this.f106762d;
        if (r108 == null) goto L37;
        com.bytedance.android.livesdk.link.model.p0 r109 = r108.f97251a;
        if (r109 == null) goto L38;
        Intrinsics.checkNotNullParameter(r110, "logMap");
        String r111 = r109.getTraceID();
        if (r111 != null) goto L35;
        r111 = "";
    L35:
        r110.put("request_id", r111);
        return;
    L38:
        return;
    L37:
        return;
    L23:
        r110.put("speedup_status", "1");
        goto L24
    L5:
        r102 = false;
        goto L6
    }
}
