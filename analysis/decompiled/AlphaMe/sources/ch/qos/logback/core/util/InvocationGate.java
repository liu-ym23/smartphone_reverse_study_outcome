package ch.qos.logback.core.util;

import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public class InvocationGate {
    private static final int MAX_MASK = 65535;
    private static final long thresholdForMaskIncrease = 100;
    private volatile long mask = 15;
    private volatile long lastMaskCheck = System.currentTimeMillis();
    private long invocationCounter = 0;
    private final long thresholdForMaskDecrease = 800;

    public boolean skipFurtherWork() {
        long j4 = this.invocationCounter;
        this.invocationCounter = 1 + j4;
        return (j4 & this.mask) != this.mask;
    }

    public void updateMaskIfNecessary(long j4) {
        long j5 = j4 - this.lastMaskCheck;
        this.lastMaskCheck = j4;
        if (j5 < thresholdForMaskIncrease && this.mask < WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.mask = (this.mask << 1) | 1;
        } else if (j5 > 800) {
            this.mask >>>= 2;
        }
    }
}
