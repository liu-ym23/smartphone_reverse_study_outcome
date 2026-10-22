package com.bytedance.android.live.liveinteract.plantform.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q0 implements com.bytedance.android.livesdk.log.filter.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.log.b f77529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q0 f77530b = null;

    public q0() {
    }

    static {
        f77530b = new q0();
        f77529a = new com.bytedance.android.livesdk.log.b("SubscribeLogInjector", null);
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void Rd() {
        f77529a.a("added");
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void onRemove() {
        f77529a.a("removed");
    }

    @Override // com.bytedance.android.livesdk.log.filter.v
    public final void L9(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        com.bytedance.android.live.profit.vip.e r102 = yt0.c.l();
        if (r102 == null) goto L11;
        com.bytedance.live.datacontext.m<? extends com.bytedance.android.live.profit.vip.h> r103 = r102.getSubscribeInfo();
        if (r103 == null) goto L11;
        com.bytedance.android.live.profit.vip.h r104 = r103.getValue();
        if (r104 == null) goto L11;
        if (r104.f89135c != true) goto L11;
        String r105 = "1";
    L12:
        r101.put("is_livevip", r105);
        return;
    L11:
        r105 = "0";
        goto L12
    }
}
