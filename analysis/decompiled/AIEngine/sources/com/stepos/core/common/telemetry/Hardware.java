package com.stepos.core.common.telemetry;

import com.stepos.base.inference.data.BackendType;
import com.stepos.base.model.InferenceConfig;
import com.stepos.core.download.ModelFlowMeta;
import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Hardware {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ Hardware[] $VALUES;
    public static final Companion Companion;
    public static final Hardware NONE = new Hardware(ModelFlowMeta.PLAN_NONE, 0);
    public static final Hardware NPU = new Hardware("NPU", 1);
    public static final Hardware GPU = new Hardware("GPU", 2);
    public static final Hardware CPU = new Hardware("CPU", 3);
    public static final Hardware DSP = new Hardware("DSP", 4);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[BackendType.values().length];
                try {
                    BackendType.a aVar = BackendType.f6253c;
                    iArr[0] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    BackendType.a aVar2 = BackendType.f6253c;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    BackendType.a aVar3 = BackendType.f6253c;
                    iArr[3] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    BackendType.a aVar4 = BackendType.f6253c;
                    iArr[2] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    BackendType.a aVar5 = BackendType.f6253c;
                    iArr[4] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[InferenceConfig.ComputeDevice.values().length];
                try {
                    InferenceConfig.ComputeDevice computeDevice = InferenceConfig.ComputeDevice.f6270a;
                    iArr2[1] = 1;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    InferenceConfig.ComputeDevice computeDevice2 = InferenceConfig.ComputeDevice.f6270a;
                    iArr2[2] = 2;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    InferenceConfig.ComputeDevice computeDevice3 = InferenceConfig.ComputeDevice.f6270a;
                    iArr2[3] = 3;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    InferenceConfig.ComputeDevice computeDevice4 = InferenceConfig.ComputeDevice.f6270a;
                    iArr2[4] = 4;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    InferenceConfig.ComputeDevice computeDevice5 = InferenceConfig.ComputeDevice.f6270a;
                    iArr2[0] = 5;
                } catch (NoSuchFieldError unused10) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final Hardware fromBackendType(BackendType bt) {
            kotlin.jvm.internal.g.f(bt, "bt");
            int i10 = WhenMappings.$EnumSwitchMapping$0[bt.ordinal()];
            if (i10 == 1) {
                return Hardware.NPU;
            }
            if (i10 == 2) {
                return Hardware.GPU;
            }
            if (i10 == 3) {
                return Hardware.CPU;
            }
            if (i10 == 4) {
                return Hardware.NPU;
            }
            if (i10 == 5) {
                return Hardware.NONE;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final Hardware fromComputeDevice(InferenceConfig.ComputeDevice cd2) {
            kotlin.jvm.internal.g.f(cd2, "cd");
            int i10 = WhenMappings.$EnumSwitchMapping$1[cd2.ordinal()];
            if (i10 == 1) {
                return Hardware.CPU;
            }
            if (i10 == 2) {
                return Hardware.GPU;
            }
            if (i10 == 3) {
                return Hardware.NPU;
            }
            if (i10 == 4) {
                return Hardware.DSP;
            }
            if (i10 == 5) {
                return Hardware.NONE;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Hardware[] $values() {
        return new Hardware[]{NONE, NPU, GPU, CPU, DSP};
    }

    static {
        Hardware[] hardwareArr$values = $values();
        $VALUES = hardwareArr$values;
        $ENTRIES = kotlin.enums.a.a(hardwareArr$values);
        Companion = new Companion(null);
    }

    private Hardware(String str, int i10) {
    }

    public static final Hardware fromBackendType(BackendType backendType) {
        return Companion.fromBackendType(backendType);
    }

    public static final Hardware fromComputeDevice(InferenceConfig.ComputeDevice computeDevice) {
        return Companion.fromComputeDevice(computeDevice);
    }

    public static sb.a<Hardware> getEntries() {
        return $ENTRIES;
    }

    public static Hardware valueOf(String str) {
        return (Hardware) Enum.valueOf(Hardware.class, str);
    }

    public static Hardware[] values() {
        return (Hardware[]) $VALUES.clone();
    }
}
