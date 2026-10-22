package com.stepos.core.ability.speech;

import android.os.Bundle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrSseStreamLimits {
    public static final AsrSseStreamLimits INSTANCE = new AsrSseStreamLimits();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MaxDurationOrigin {
        private static final /* synthetic */ sb.a $ENTRIES;
        private static final /* synthetic */ MaxDurationOrigin[] $VALUES;
        private final String tag;
        public static final MaxDurationOrigin DEFAULT = new MaxDurationOrigin("DEFAULT", 0, "");
        public static final MaxDurationOrigin OVERRIDE = new MaxDurationOrigin("OVERRIDE", 1, VadRuntimeConfig.ORIGIN_OVERRIDE);
        public static final MaxDurationOrigin OVERRIDE_CLAMPED = new MaxDurationOrigin("OVERRIDE_CLAMPED", 2, "override,clamped");
        public static final MaxDurationOrigin CLIENT_REJECTED = new MaxDurationOrigin("CLIENT_REJECTED", 3, VadRuntimeConfig.ORIGIN_REJECTED);
        public static final MaxDurationOrigin BYTE_LIMIT = new MaxDurationOrigin("BYTE_LIMIT", 4, "byte_limit");

        private static final /* synthetic */ MaxDurationOrigin[] $values() {
            return new MaxDurationOrigin[]{DEFAULT, OVERRIDE, OVERRIDE_CLAMPED, CLIENT_REJECTED, BYTE_LIMIT};
        }

        static {
            MaxDurationOrigin[] maxDurationOriginArr$values = $values();
            $VALUES = maxDurationOriginArr$values;
            $ENTRIES = kotlin.enums.a.a(maxDurationOriginArr$values);
        }

        private MaxDurationOrigin(String str, int i10, String str2) {
            this.tag = str2;
        }

        public static sb.a<MaxDurationOrigin> getEntries() {
            return $ENTRIES;
        }

        public static MaxDurationOrigin valueOf(String str) {
            return (MaxDurationOrigin) Enum.valueOf(MaxDurationOrigin.class, str);
        }

        public static MaxDurationOrigin[] values() {
            return (MaxDurationOrigin[]) $VALUES.clone();
        }

        public final String getLogTag() {
            return this.tag.length() == 0 ? "" : a0.a.k("(", this.tag, ")");
        }

        public final String getTag() {
            return this.tag;
        }
    }

    private AsrSseStreamLimits() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRejected(Integer num) {
        return num != null && num.intValue() < 1000;
    }

    public final long executionBudgetMs(Bundle bundle, long j10, long j11) {
        return resolveMaxDurationMs(bundle, j10) + j11;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDuration resolveMaxDuration(android.os.Bundle r7, long r8) {
        /*
            r6 = this;
            r6 = 0
            if (r7 == 0) goto L19
            java.lang.String r0 = "asr.sse.stream.max_duration_ms"
            boolean r1 = r7.containsKey(r0)
            if (r1 == 0) goto Lc
            goto Ld
        Lc:
            r7 = r6
        Ld:
            if (r7 == 0) goto L19
            r1 = 0
            int r7 = r7.getInt(r0, r1)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L1a
        L19:
            r7 = r6
        L1a:
            if (r7 == 0) goto L2d
            int r0 = r7.intValue()
            com.stepos.core.ability.speech.AsrSseStreamLimits r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.INSTANCE
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = r1.isRejected(r0)
            if (r0 != 0) goto L2d
            r6 = r7
        L2d:
            r0 = 600000(0x927c0, float:8.40779E-40)
            if (r7 != 0) goto L35
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDurationOrigin r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDurationOrigin.DEFAULT
            goto L45
        L35:
            if (r6 != 0) goto L3a
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDurationOrigin r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDurationOrigin.CLIENT_REJECTED
            goto L45
        L3a:
            int r1 = r6.intValue()
            if (r1 <= r0) goto L43
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDurationOrigin r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDurationOrigin.OVERRIDE_CLAMPED
            goto L45
        L43:
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDurationOrigin r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDurationOrigin.OVERRIDE
        L45:
            if (r6 == 0) goto L51
            int r6 = r6.intValue()
            if (r6 <= r0) goto L4e
            goto L4f
        L4e:
            r0 = r6
        L4f:
            long r2 = (long) r0
            goto L54
        L51:
            r2 = 180000(0x2bf20, double:8.8932E-319)
        L54:
            r4 = 0
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 <= 0) goto L6b
            r4 = 2
            long r8 = r8 / r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r4
            r6 = 16000(0x3e80, float:2.2421E-41)
            long r4 = (long) r6
            long r8 = r8 / r4
            int r6 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r6 >= 0) goto L6b
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDurationOrigin r1 = com.stepos.core.ability.speech.AsrSseStreamLimits.MaxDurationOrigin.BYTE_LIMIT
            r2 = r8
        L6b:
            com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDuration r6 = new com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDuration
            r6.<init>(r2, r1, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.speech.AsrSseStreamLimits.resolveMaxDuration(android.os.Bundle, long):com.stepos.core.ability.speech.AsrSseStreamLimits$MaxDuration");
    }

    public final long resolveMaxDurationMs(Bundle bundle, long j10) {
        return resolveMaxDuration(bundle, j10).getMs();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class MaxDuration {
        private final long ms;
        private final MaxDurationOrigin origin;
        private final Integer recv;

        public MaxDuration(long j10, MaxDurationOrigin origin, Integer num) {
            kotlin.jvm.internal.g.f(origin, "origin");
            this.ms = j10;
            this.origin = origin;
            this.recv = num;
        }

        public static /* synthetic */ MaxDuration copy$default(MaxDuration maxDuration, long j10, MaxDurationOrigin maxDurationOrigin, Integer num, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = maxDuration.ms;
            }
            if ((i10 & 2) != 0) {
                maxDurationOrigin = maxDuration.origin;
            }
            if ((i10 & 4) != 0) {
                num = maxDuration.recv;
            }
            return maxDuration.copy(j10, maxDurationOrigin, num);
        }

        public final long component1() {
            return this.ms;
        }

        public final MaxDurationOrigin component2() {
            return this.origin;
        }

        public final Integer component3() {
            return this.recv;
        }

        public final MaxDuration copy(long j10, MaxDurationOrigin origin, Integer num) {
            kotlin.jvm.internal.g.f(origin, "origin");
            return new MaxDuration(j10, origin, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MaxDuration)) {
                return false;
            }
            MaxDuration maxDuration = (MaxDuration) obj;
            return this.ms == maxDuration.ms && this.origin == maxDuration.origin && kotlin.jvm.internal.g.b(this.recv, maxDuration.recv);
        }

        public final long getMs() {
            return this.ms;
        }

        public final MaxDurationOrigin getOrigin() {
            return this.origin;
        }

        public final Integer getRecv() {
            return this.recv;
        }

        public int hashCode() {
            int iHashCode = (this.origin.hashCode() + (Long.hashCode(this.ms) * 31)) * 31;
            Integer num = this.recv;
            return iHashCode + (num == null ? 0 : num.hashCode());
        }

        public final String rejectionLog() {
            if (!AsrSseStreamLimits.INSTANCE.isRejected(this.recv)) {
                return null;
            }
            Integer num = this.recv;
            String str = (num != null && num.intValue() == 0) ? VadRuntimeConfig.CAUSE_ZERO_OR_TYPE_MISMATCH : VadRuntimeConfig.CAUSE_BELOW_MIN;
            return "asr.sse.stream.max_duration_ms recv=" + this.recv + " legal=[1000,600000] cause=" + str + " effective=" + this.ms;
        }

        public String toString() {
            return "MaxDuration(ms=" + this.ms + ", origin=" + this.origin + ", recv=" + this.recv + ")";
        }

        public /* synthetic */ MaxDuration(long j10, MaxDurationOrigin maxDurationOrigin, Integer num, int i10, kotlin.jvm.internal.e eVar) {
            this(j10, maxDurationOrigin, (i10 & 4) != 0 ? null : num);
        }
    }
}
