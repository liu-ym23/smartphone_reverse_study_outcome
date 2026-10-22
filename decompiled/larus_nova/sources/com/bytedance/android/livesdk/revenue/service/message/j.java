package com.bytedance.android.livesdk.revenue.service.message;

import com.bytedance.common.utility.collection.WeakContainer;
import com.ss.ugc.live.sdk.platform.imbroadcast.IMBroadcast;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, omc.a> f157416a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public j() {
        this.f157416a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.b
    public final void bf(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        IMBroadcast r101 = com.ss.ugc.live.sdk.platform.a.f458523e;
        omc.a r102 = (omc.a) ((LinkedHashMap) this.f157416a).get(r100);
        r101.getClass();
        if (r100 == null) goto L9;
        if (r102 == null) goto L10;
        WeakContainer<omc.a> r103 = r101.f458527a.get(r100);
        if (r103 == null) goto L11;
        r103.remove(r102);
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.message.b
    public final void aj(String r100, com.bytedance.android.live.recharge.service.d.a r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        i r102 = new i(r101);
        this.f157416a.put(r100, r102);
        com.ss.ugc.live.sdk.platform.a.f458523e.a(r100, r102);
    }
}
