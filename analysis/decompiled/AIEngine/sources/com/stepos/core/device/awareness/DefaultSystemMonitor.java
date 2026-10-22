package com.stepos.core.device.awareness;

import com.stepos.core.ability.util.EmbedSessionImageMock;
import q6.d;
import r6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DefaultSystemMonitor implements d {
    public long getAvailableMemoryMB() {
        return 2048L;
    }

    public int getBatteryLevel() {
        return 80;
    }

    public float getCpuUsage() {
        return 30.0f;
    }

    @Override // q6.d
    public b getCurrentLoad() {
        return new b(getCpuUsage(), getMemoryUsage(), getAvailableMemoryMB(), getBatteryLevel(), isCharging(), getTemperature(), isThermalThrottling(), EmbedSessionImageMock.DIM);
    }

    public float getMemoryUsage() {
        return 50.0f;
    }

    public float getTemperature() {
        return 35.0f;
    }

    public boolean isCharging() {
        return false;
    }

    public boolean isThermalThrottling() {
        return false;
    }
}
