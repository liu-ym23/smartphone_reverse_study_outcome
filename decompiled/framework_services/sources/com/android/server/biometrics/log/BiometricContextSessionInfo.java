package com.android.server.biometrics.log;

import com.android.internal.logging.InstanceId;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class BiometricContextSessionInfo {
    private final InstanceId mId;
    private final AtomicInteger mOrder;

    BiometricContextSessionInfo(InstanceId id) {
        this.mOrder = new AtomicInteger(0);
        this.mId = id;
    }

    public int getId() {
        return this.mId.getId();
    }

    public int getOrder() {
        return this.mOrder.get();
    }

    public int getOrderAndIncrement() {
        return this.mOrder.getAndIncrement();
    }

    public String toString() {
        return "[sid: " + this.mId.getId() + "]";
    }
}
