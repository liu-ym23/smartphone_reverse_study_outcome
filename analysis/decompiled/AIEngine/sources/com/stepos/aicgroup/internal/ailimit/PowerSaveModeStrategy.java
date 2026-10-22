package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PowerSaveModeStrategy extends BaseSystemStateStrategy {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5736a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5737b;

    public PowerSaveModeStrategy() {
        this(false, 1, null);
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public DimensionConstraint desiredSuspension() {
        return this.f5736a ? BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.NORMAL, AiDispatchers.DispatcherPriority.BACKGROUND) : DimensionConstraint.Companion.getNONE();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getName() {
        return this.f5737b;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getStateDescription() {
        return this.f5736a ? "开启" : "关闭";
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public int getStateLevel() {
        return this.f5736a ? 1 : 0;
    }

    public final void updatePowerSaveMode(boolean z) {
        this.f5736a = z;
    }

    public /* synthetic */ PowerSaveModeStrategy(boolean z, int i10, e eVar) {
        this((i10 & 1) != 0 ? false : z);
    }

    public PowerSaveModeStrategy(boolean z) {
        this.f5736a = z;
        this.f5737b = "PowerSaveMode";
    }
}
