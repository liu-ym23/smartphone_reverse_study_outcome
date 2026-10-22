package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d.a f131480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f131481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f131482c;

    public c(d.a r100, Pair r101, Long r102) {
        this.f131480a = r100;
        this.f131481b = r101;
        this.f131482c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        PolarisFileWrapper r111 = new PolarisFileWrapper((String) this.f131481b.getSecond());
        if (r111.exists() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.live.revenue.common.c0.b(r111) == false) goto L13;
        int r112 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.f129081a;
        Long r113 = this.f131482c;
        if (r113 == null) goto L9;
        long r100 = r113.longValue();
    L10:
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r100, 0, (String) this.f131481b.getSecond(), "ai_lru_cache", null, null, null, 112);
        this.f131480a.size();
        String r114 = (String) this.f131481b.getSecond();
        return;
    L9:
        r100 = 0;
        goto L10
    }
}
