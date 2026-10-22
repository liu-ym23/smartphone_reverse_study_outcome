package com.obric.cloudsdk.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Throttle.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/cloudsdk/utils/CompositeAccessThrottle;", "", "intervalThreshold", "", "(J)V", "throttles", "", "", "Lcom/obric/cloudsdk/utils/SimpleAccessThrottle;", "isTooFrequently", "", "signature", "refresh", "", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompositeAccessThrottle {
    private final long intervalThreshold;
    private final Map<String, SimpleAccessThrottle> throttles;

    public CompositeAccessThrottle(long r1) {
        this.intervalThreshold = r1;
        this.throttles = new HashMap();
    }

    public final synchronized boolean isTooFrequently(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "signature");     // Catch: Throwable -> L9
        Map<String, SimpleAccessThrottle> r0 = this.throttles;     // Catch: Throwable -> L9
        SimpleAccessThrottle r1 = r0.get(r5);     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
        r1 = new SimpleAccessThrottle(r5, this.intervalThreshold);     // Catch: Throwable -> L9
        r0.put(r5, r1);     // Catch: Throwable -> L9
    L6:
        boolean r6 = r1.isTooFrequently();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r6;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void refresh(String r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "signature");     // Catch: Throwable -> L9
        Map<String, SimpleAccessThrottle> r0 = this.throttles;     // Catch: Throwable -> L9
        SimpleAccessThrottle r1 = r0.get(r5);     // Catch: Throwable -> L9
        if (r1 != null) goto L6;
        r1 = new SimpleAccessThrottle(r5, this.intervalThreshold);     // Catch: Throwable -> L9
        r0.put(r5, r1);     // Catch: Throwable -> L9
    L6:
        r1.refresh();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
