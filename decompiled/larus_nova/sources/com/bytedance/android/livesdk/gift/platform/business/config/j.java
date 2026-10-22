package com.bytedance.android.livesdk.gift.platform.business.config;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<GiftConfigKey, Object> f126571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, p> f126572b;

    public j() {
        this.f126571a = new HashMap();
        this.f126572b = new ConcurrentHashMap();
    }

    public final <T extends p> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ConcurrentHashMap<Class<?>, p> r101 = this.f126572b;
        T r102 = r101.get(r100);
        if (r102 != null) goto L8;
        r102 = r100.newInstance();
        p r103 = r101.putIfAbsent(r100, r102);
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        if (r102 == null) goto L12;
        return (T) r102;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final void a(Class r100, p r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        this.f126572b.put(r100, r101);
    }

    public final void b(GiftConfigKey r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f126571a.put(r100, r101);
    }

    public final <V> V c(GiftConfigKey r100, V r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r102 = this.f126571a.get(r100);
        if ((r102 instanceof Object) == true) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L8;
        return r101;
    L8:
        return (V) r102;
    }
}
