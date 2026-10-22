package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.core.utils.l1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes13.dex */
public final class InflowRedPacketTimer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f175429b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l1 f175430a;

    public static final class a {
    }

    public InflowRedPacketTimer() {
    }

    static {
        f175429b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, InflowRedPacketTimer$Companion$instance$2.INSTANCE);
    }
}
