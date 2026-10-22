package com.stepos.core.ota.adapter;

import android.os.SystemClock;
import com.stepos.core.ota.domain.port.OtaClock;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SystemOtaClock implements OtaClock {
    @Override // com.stepos.core.ota.domain.port.OtaClock
    public long elapsedMs() {
        return SystemClock.elapsedRealtime();
    }
}
