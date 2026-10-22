package com.obric.matrix.platform.sdk.ones.commonmonitor.Thread;

import com.bytedance.apm.perf.ThreadCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThreadMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/Thread/ThreadMonitor;", "", "()V", "reportThreadCount", "", "scene", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThreadMonitor {
    public static final ThreadMonitor INSTANCE = null;

    static {
        INSTANCE = new ThreadMonitor();
    }

    private ThreadMonitor() {
    }

    public final int reportThreadCount(String r1) {
        Intrinsics.checkNotNullParameter(r1, "scene");
        return ThreadCollector.reportThreadCount(r1, true);
    }
}
