package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.SystemTemperature;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TemperatureStrategy extends BaseSystemStateStrategy {

    /* renamed from: a, reason: collision with root package name */
    public SystemTemperature f5740a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5741b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemTemperature.values().length];
            try {
                iArr[SystemTemperature.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SystemTemperature.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SystemTemperature.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SystemTemperature.CRITICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TemperatureStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public DimensionConstraint desiredSuspension() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.f5740a.ordinal()];
        if (i10 == 1) {
            return DimensionConstraint.Companion.getNONE();
        }
        if (i10 == 2) {
            return BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.BACKGROUND);
        }
        if (i10 == 3) {
            return BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.NORMAL, AiDispatchers.DispatcherPriority.BACKGROUND);
        }
        if (i10 == 4) {
            return BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.IMPORTANT, AiDispatchers.DispatcherPriority.NORMAL, AiDispatchers.DispatcherPriority.BACKGROUND);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getName() {
        return this.f5741b;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getStateDescription() {
        return this.f5740a.name();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public int getStateLevel() {
        return this.f5740a.getLevel();
    }

    public final void updateTemperature(SystemTemperature temperature) {
        g.f(temperature, "temperature");
        this.f5740a = temperature;
    }

    public /* synthetic */ TemperatureStrategy(SystemTemperature systemTemperature, int i10, e eVar) {
        this((i10 & 1) != 0 ? SystemTemperature.NORMAL : systemTemperature);
    }

    public TemperatureStrategy(SystemTemperature currentTemperature) {
        g.f(currentTemperature, "currentTemperature");
        this.f5740a = currentTemperature;
        this.f5741b = "Temperature";
    }
}
