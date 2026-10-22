package com.bytedance.android.livesdk.room.Task.execute;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class ExecutorHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f157599a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f157600b = null;

    static {
        f157599a = LazyKt.lazy(ExecutorHelper$mCommonThreadPool$2.INSTANCE);
        f157600b = LazyKt.lazy(ExecutorHelper$mIOThreadPool$2.INSTANCE);
    }
}
