package com.stepos.core.ota.deepbinder;

import com.stepos.core.download.ModelFlowMeta;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadResourceGate {
    public static final long FALLBACK_REQUIRED_BYTES = 536870912;
    public static final DownloadResourceGate INSTANCE = new DownloadResourceGate();
    public static final int MIN_BATTERY_PCT_CHARGING = 3;
    public static final int MIN_BATTERY_PCT_UNPLUGGED = 15;
    public static final long SPACE_MULTIPLIER = 2;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Verdict {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ Verdict[] $VALUES;
        public static final Verdict OK = new Verdict("OK", 0);
        public static final Verdict INSUFFICIENT_SPACE = new Verdict("INSUFFICIENT_SPACE", 1);
        public static final Verdict LOW_BATTERY = new Verdict("LOW_BATTERY", 2);

        private static final /* synthetic */ Verdict[] $values() {
            return new Verdict[]{OK, INSUFFICIENT_SPACE, LOW_BATTERY};
        }

        static {
            Verdict[] verdictArr$values = $values();
            $VALUES = verdictArr$values;
            $ENTRIES = kotlin.enums.a.a(verdictArr$values);
        }

        private Verdict(String str, int i10) {
        }

        public static sb.a<Verdict> getEntries() {
            return $ENTRIES;
        }

        public static Verdict valueOf(String str) {
            return (Verdict) Enum.valueOf(Verdict.class, str);
        }

        public static Verdict[] values() {
            return (Verdict[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Verdict.values().length];
            try {
                iArr[Verdict.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Verdict.INSUFFICIENT_SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Verdict.LOW_BATTERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DownloadResourceGate() {
    }

    public final int errorCode(Verdict verdict) {
        g.f(verdict, "verdict");
        int i10 = WhenMappings.$EnumSwitchMapping$0[verdict.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return ModelFlowMeta.GATE_ERROR_INSUFFICIENT_SPACE;
        }
        if (i10 == 3) {
            return ModelFlowMeta.GATE_ERROR_LOW_BATTERY;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Verdict evaluate(long j10, long j11, int i10, boolean z) {
        if (j11 <= 0) {
            j11 = FALLBACK_REQUIRED_BYTES;
        }
        return j10 < j11 * 2 ? Verdict.INSUFFICIENT_SPACE : (!z ? i10 > 15 : i10 > 3) ? Verdict.LOW_BATTERY : Verdict.OK;
    }
}
