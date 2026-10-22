package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveResourcesDistributionImpl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f125786d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f125787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, ? extends WebResourceResponse> f125788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125789c;

    public static final class a {
    }

    static {
    }

    public LiveResourcesDistributionImpl() {
        this.f125789c = LazyKt.lazy(LiveResourcesDistributionImpl$mPrefetchChannels$2.INSTANCE);
    }
}
