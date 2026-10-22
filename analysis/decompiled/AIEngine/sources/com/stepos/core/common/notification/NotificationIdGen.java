package com.stepos.core.common.notification;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class NotificationIdGen {
    public static final NotificationIdGen INSTANCE = new NotificationIdGen();
    private static final AtomicInteger counter = new AtomicInteger(1000);

    private NotificationIdGen() {
    }

    public final int next() {
        return counter.incrementAndGet();
    }
}
