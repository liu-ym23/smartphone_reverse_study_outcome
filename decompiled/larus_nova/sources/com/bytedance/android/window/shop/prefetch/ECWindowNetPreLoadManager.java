package com.bytedance.android.window.shop.prefetch;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowNetPreLoadManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f189257b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f189258a;

    public static final class a {
    }

    public ECWindowNetPreLoadManager() {
    }

    static {
        f189257b = LazyKt.lazy(LazyThreadSafetyMode.NONE, ECWindowNetPreLoadManager$Companion$instance$2.INSTANCE);
    }
}
