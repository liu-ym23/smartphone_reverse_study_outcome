package com.bytedance.android.livesdk.performance.battery;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class LivePerformancePowerHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f154465f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f154466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rn2.a f154467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f154468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f154469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f154470e;

    public static final class a {
    }

    static {
    }

    public LivePerformancePowerHelper() {
        this.f154467b = new rn2.a();
        this.f154468c = LazyKt.lazy(LivePerformancePowerHelper$enablePowerFunction$2.INSTANCE);
        this.f154469d = LazyKt.lazy(LivePerformancePowerHelper$enablePowerFunctionCollectOpt$2.INSTANCE);
        this.f154470e = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("LivePerformancePowerHelper"));
    }
}
