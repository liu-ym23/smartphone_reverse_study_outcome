package com.bytedance.android.shopping.store.home.preload.net;

import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreNetPreloadManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f183824b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f183825a;

    public static final class a {
    }

    public ECStoreNetPreloadManager() {
    }

    static {
        f183824b = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECStoreNetPreloadManager$Companion$instance$2.INSTANCE);
    }

    public static void a() {
        Lazy r100 = ECTaskManager.f48688b;
        ECTaskManager r101 = ECTaskManager.a.a();
        ECStoreNetPreloadManager$preloadPicDomain$1 r102 = ECStoreNetPreloadManager$preloadPicDomain$1.INSTANCE;
        r101.getClass();
        ECTaskManager.b(r102);
    }
}
