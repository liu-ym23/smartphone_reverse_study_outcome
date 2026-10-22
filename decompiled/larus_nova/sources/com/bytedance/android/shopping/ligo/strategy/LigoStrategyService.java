package com.bytedance.android.shopping.ligo.strategy;

import b93.b;
import b93.c;
import com.bytedance.android.livesdk.livecommerce.eventcenter.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LigoStrategyService implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f176465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176466b;

    public static final class a {
    }

    static {
    }

    @Override // b93.c
    public final b b() {
        String r100 = "custom_event_".concat("live");
        xe3.a r101 = (xe3.a) this.f176466b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "sourceName");
        return r101;
    }

    public LigoStrategyService() {
        this.f176465a = new ConcurrentHashMap();
        this.f176466b = LazyKt.lazy(LigoStrategyService$eventSource$2.INSTANCE);
    }

    @Override // b93.c
    public final void a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f176465a.put("", r100);
    }
}
