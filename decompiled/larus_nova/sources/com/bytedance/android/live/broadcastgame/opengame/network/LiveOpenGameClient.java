package com.bytedance.android.live.broadcastgame.opengame.network;

import com.bytedance.android.live.network.impl.utils.RetrofitProvider;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveOpenGameClient {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f60290d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f60291e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f60292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f60293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.a f60294c;

    public static final class a {
        public static LiveOpenGameClient a() {
            return (LiveOpenGameClient) LiveOpenGameClient.f60290d.getValue();
        }
    }

    static {
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.SYNCHRONIZED;
        f60290d = LazyKt.lazy(r100, LiveOpenGameClient$Companion$instance$2.INSTANCE);
        f60291e = LazyKt.lazy(r100, LiveOpenGameClient$Companion$commonInstance$2.INSTANCE);
    }

    public LiveOpenGameClient(RetrofitProvider r100) {
        this.f60294c = r100;
        this.f60292a = new ConcurrentHashMap();
        this.f60293b = LazyKt.lazy(LiveOpenGameClient$hasCheckOpenApiServiceSet$2.INSTANCE);
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        LocalTestManager.a(new Class[]{wy.a.class});
        if (this.f60292a.contains(r100) == true) goto L10;
        ConcurrentHashMap<Class<?>, Object> r101 = this.f60292a;
        Object r102 = this.f60294c.getRetrofitInstance().create(r100);
        if (r102 == null) goto L8;
        r101.putIfAbsent(r100, r102);
        goto L10
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L10:
        return (T) this.f60292a.get(r100);
    }
}
