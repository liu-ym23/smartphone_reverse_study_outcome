package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BatteryStrategy extends BaseSystemStateStrategy {

    /* renamed from: a, reason: collision with root package name */
    public int f5724a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f5725b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5726c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BatteryState.values().length];
            try {
                iArr[BatteryState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BatteryState.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BatteryState.CRITICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BatteryStrategy() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public final BatteryState b() {
        if (this.f5725b) {
            return BatteryState.NORMAL;
        }
        int i10 = this.f5724a;
        return i10 < 5 ? BatteryState.CRITICAL : i10 < 20 ? BatteryState.LOW : BatteryState.NORMAL;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public DimensionConstraint desiredSuspension() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[b().ordinal()];
        if (i10 == 1) {
            return DimensionConstraint.Companion.getNONE();
        }
        if (i10 == 2) {
            return BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.BACKGROUND);
        }
        if (i10 == 3) {
            return BaseSystemStateStrategy.a(AiDispatchers.DispatcherPriority.NORMAL, AiDispatchers.DispatcherPriority.BACKGROUND);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getName() {
        return this.f5726c;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getStateDescription() {
        return b().name() + " (" + this.f5724a + "%, 充电:" + this.f5725b + ")";
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public int getStateLevel() {
        return b().getLevel();
    }

    public final void updateBattery(int i10, boolean z) {
        this.f5724a = i10;
        this.f5725b = z;
    }

    public /* synthetic */ BatteryStrategy(int i10, boolean z, int i11, e eVar) {
        this((i11 & 1) != 0 ? 100 : i10, (i11 & 2) != 0 ? true : z);
    }

    public BatteryStrategy(int i10, boolean z) {
        this.f5724a = i10;
        this.f5725b = z;
        this.f5726c = "Battery";
    }
}
