package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.MemoryState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MemoryStrategy extends BaseSystemStateStrategy {

    /* renamed from: a, reason: collision with root package name */
    public MemoryState f5734a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5735b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MemoryState.values().length];
            try {
                iArr[MemoryState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MemoryState.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MemoryState.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MemoryState.ULTRA_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemoryStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public DimensionConstraint desiredSuspension() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.f5734a.ordinal()];
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
        return this.f5735b;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getStateDescription() {
        return this.f5734a.name();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public int getStateLevel() {
        return this.f5734a.getLevel();
    }

    public final void updateMemoryState(MemoryState memoryState) {
        g.f(memoryState, "memoryState");
        this.f5734a = memoryState;
    }

    public /* synthetic */ MemoryStrategy(MemoryState memoryState, int i10, e eVar) {
        this((i10 & 1) != 0 ? MemoryState.NORMAL : memoryState);
    }

    public MemoryStrategy(MemoryState currentMemoryState) {
        g.f(currentMemoryState, "currentMemoryState");
        this.f5734a = currentMemoryState;
        this.f5735b = "Memory";
    }
}
