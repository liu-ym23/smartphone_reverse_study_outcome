package com.stepos.core.ota.download.control;

import com.stepos.core.ota.domain.TriggerSource;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface DownloadStrategy {
    StrategyOutcome evaluate(DeviceConditions deviceConditions, TriggerSource triggerSource);

    String getId();
}
