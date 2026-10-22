package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.IoUsage;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class IoStrategy extends BaseSystemStateStrategy {

    /* renamed from: a, reason: collision with root package name */
    public IoUsage f5732a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5733b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IoUsage.values().length];
            try {
                iArr[IoUsage.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IoUsage.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IoUsage.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IoUsage.CRITICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IoStrategy() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public DimensionConstraint desiredSuspension() {
        int i10 = WhenMappings.$EnumSwitchMapping$0[this.f5732a.ordinal()];
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
        return this.f5733b;
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public String getStateDescription() {
        return this.f5732a.name();
    }

    @Override // com.stepos.aicgroup.internal.ailimit.SystemStateStrategy
    public int getStateLevel() {
        return this.f5732a.getLevel();
    }

    public final void updateIoUsage(IoUsage ioUsage) {
        g.f(ioUsage, "ioUsage");
        this.f5732a = ioUsage;
    }

    public /* synthetic */ IoStrategy(IoUsage ioUsage, int i10, e eVar) {
        this((i10 & 1) != 0 ? IoUsage.NORMAL : ioUsage);
    }

    public IoStrategy(IoUsage currentIoUsage) {
        g.f(currentIoUsage, "currentIoUsage");
        this.f5732a = currentIoUsage;
        this.f5733b = "IO";
    }
}
