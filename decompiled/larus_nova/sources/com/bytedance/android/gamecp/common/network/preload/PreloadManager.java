package com.bytedance.android.gamecp.common.network.preload;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class PreloadManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f56704c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.common.network.preload.a<String, Object> f56705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, PreloadState> f56706b;

    public static final class a {
    }

    public interface b<T> {
        void T0();

        void U0(T r100);

        void onError(int r100);
    }

    static {
        f56704c = LazyKt.lazy(PreloadManager$Companion$instance$2.INSTANCE);
    }

    public PreloadManager() {
        this.f56705a = new com.bytedance.android.gamecp.common.network.preload.a();
        this.f56706b = new ConcurrentHashMap();
    }
}
