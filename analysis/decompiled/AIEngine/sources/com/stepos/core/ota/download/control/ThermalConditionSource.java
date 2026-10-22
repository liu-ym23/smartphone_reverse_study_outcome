package com.stepos.core.ota.download.control;

import com.stepos.core.ota.download.control.DeviceConditions;
import kotlin.jvm.internal.g;
import lb.n;
import zb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThermalConditionSource implements ConditionSource {
    private final ThermalProvider provider;

    public ThermalConditionSource(ThermalProvider provider) {
        g.f(provider, "provider");
        this.provider = provider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n observe$lambda$1(a aVar, float f8) {
        aVar.invoke();
        return n.f10413a;
    }

    @Override // com.stepos.core.ota.download.control.ConditionSource
    public void contribute(DeviceConditions.Builder builder) {
        g.f(builder, "builder");
        Float fCurrent = this.provider.current();
        if (fCurrent != null) {
            builder.put(DeviceConditions.Companion.getTEMPERATURE_C(), Float.valueOf(fCurrent.floatValue()));
        }
    }

    @Override // com.stepos.core.ota.download.control.ConditionSource
    public void observe(a<n> onChange) {
        g.f(onChange, "onChange");
        this.provider.observe(new androidx.compose.runtime.g(onChange, 15));
    }

    @Override // com.stepos.core.ota.download.control.ConditionSource
    public void stop() {
        this.provider.stop();
    }
}
