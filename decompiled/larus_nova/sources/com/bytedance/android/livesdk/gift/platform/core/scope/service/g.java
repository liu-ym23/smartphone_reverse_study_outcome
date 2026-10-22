package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f131555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.core.resources.e f131556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e f131557c;

    public g(d r100, com.bytedance.android.live.core.resources.e r101, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r102) {
        this.f131555a = r100;
        this.f131556b = r101;
        this.f131557c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        HashMap<String, d.a> r101 = this.f131555a.f131491a;
        monitor-enter(r101);
        com.bytedance.android.live.core.resources.b r102 = this.f131556b.getCleanStrategy();     // Catch: Throwable -> L28
        if (r102 == null) goto L8;
        String r103 = r102.getAssetType();     // Catch: Throwable -> L28
        if (r103 == null) goto L8;
    L9:
        String r104 = new AssetsFileCacheFactory().b(this.f131557c);     // Catch: Throwable -> L28
        int r105 = com.bytedance.android.live.revenue.common.c0.f90829a;     // Catch: Throwable -> L28
        long r106 = com.bytedance.android.live.revenue.common.c0.a(new PolarisFileWrapper(r104)) / ((long) 1024);     // Catch: Throwable -> L28
        if (r106 > 0) goto L12;
    L25:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L28
        monitor-exit(r101);
        return;
    L12:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r103) == null) goto L25;
        d.a r108 = this.f131555a.f131491a.get(r103);     // Catch: Throwable -> L28
        if (r108 != null) goto L20;
        com.bytedance.android.livesdk.gift.configmodel.g1 r109 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r103);     // Catch: Throwable -> L28
        if (r109 == null) goto L18;
        int r110 = r109.b();     // Catch: Throwable -> L28
    L19:
        r108 = new d.a(r110);     // Catch: Throwable -> L28
        goto L20
    L18:
        r110 = 1;
    L20:
        com.bytedance.android.livesdk.gift.configmodel.g1 r111 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r103);     // Catch: Throwable -> L28
        if (r111 == null) goto L23;
        int r112 = r111.a();     // Catch: Throwable -> L28
    L24:
        r108.f131493a = r112;     // Catch: Throwable -> L28
        r108.put(Long.valueOf(this.f131557c.f129099i), new Pair(Integer.valueOf((int) r106), r104));     // Catch: Throwable -> L28
        this.f131555a.f131491a.put(r103, r108);     // Catch: Throwable -> L28
        this.f131555a.c("updateCachePool");     // Catch: Throwable -> L28
        d.a(this.f131555a);     // Catch: Throwable -> L28
        goto L25
    L23:
        r112 = 0;
    L8:
        r103 = "";
    L28:
        th = move-exception;
        throw th;
    }
}
