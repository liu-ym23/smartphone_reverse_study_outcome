package com.stepos.thermal;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class ThermalConstraint {
    private ThermalConstraint() {
    }

    public static final class Cluster {
        public static final String BIG = "big";
        public static final String LITTLE = "little";
        public static final String MID = "mid";
        public static final String PRIME = "prime";

        private Cluster() {
        }
    }

    public static final class Keys {
        public static final String CPU_CLUSTER_BIG_FREQ_MAX_MHZ = "cpu.cluster.big.freq_max_mhz";
        public static final String CPU_CLUSTER_BIG_OFFLINE_COUNT = "cpu.cluster.big.offline_count";
        public static final String CPU_CLUSTER_LITTLE_FREQ_MAX_MHZ = "cpu.cluster.little.freq_max_mhz";
        public static final String CPU_CLUSTER_MID_FREQ_MAX_MHZ = "cpu.cluster.mid.freq_max_mhz";
        public static final String CPU_CLUSTER_MID_OFFLINE_COUNT = "cpu.cluster.mid.offline_count";
        public static final String CPU_CLUSTER_PRIME_FREQ_MAX_MHZ = "cpu.cluster.prime.freq_max_mhz";
        public static final String CPU_CLUSTER_PRIME_OFFLINE_COUNT = "cpu.cluster.prime.offline_count";
        public static final String DDR_FREQ_MAX_MHZ = "ddr.freq_max_mhz";
        public static final String DISPLAY_REFRESH_RATE_MAX_HZ = "display.refresh_rate_max_hz";
        public static final String GPU_FREQ_MAX_MHZ = "gpu.freq_max_mhz";
        public static final String NPU_FREQ_MAX_MHZ = "npu.freq_max_mhz";
        public static final String PERF_BOOST_ALLOWED = "perf.boost.allowed";

        private Keys() {
        }
    }

    public static final class Builder {
        private final Bundle mBundle = new Bundle();

        public Builder setCpuFreqMaxMhz(String cluster, int freqMaxMhz) {
            this.mBundle.putInt(cpuFreqKey(cluster), freqMaxMhz);
            return this;
        }

        public Builder setCpuOfflineCount(String cluster, int offlineCount) {
            this.mBundle.putInt(cpuOfflineKey(cluster), offlineCount);
            return this;
        }

        public Builder setGpuFreqMaxMhz(int freqMaxMhz) {
            this.mBundle.putInt(Keys.GPU_FREQ_MAX_MHZ, freqMaxMhz);
            return this;
        }

        public Builder setNpuFreqMaxMhz(int freqMaxMhz) {
            this.mBundle.putInt(Keys.NPU_FREQ_MAX_MHZ, freqMaxMhz);
            return this;
        }

        public Builder setDdrFreqMaxMhz(int freqMaxMhz) {
            this.mBundle.putInt(Keys.DDR_FREQ_MAX_MHZ, freqMaxMhz);
            return this;
        }

        public Builder setDisplayRefreshRateMaxHz(int refreshRateHz) {
            this.mBundle.putInt(Keys.DISPLAY_REFRESH_RATE_MAX_HZ, refreshRateHz);
            return this;
        }

        public Builder setBoostAllowed(boolean allowed) {
            this.mBundle.putBoolean(Keys.PERF_BOOST_ALLOWED, allowed);
            return this;
        }

        public Bundle build() {
            return new Bundle(this.mBundle);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.String cpuFreqKey(java.lang.String r3) {
            /*
                int r0 = r3.hashCode()
                switch(r0) {
                    case -1102478602: goto L26;
                    case 97536: goto L1c;
                    case 108104: goto L12;
                    case 106934911: goto L8;
                    default: goto L7;
                }
            L7:
                goto L30
            L8:
                java.lang.String r0 = "prime"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 3
                goto L31
            L12:
                java.lang.String r0 = "mid"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 1
                goto L31
            L1c:
                java.lang.String r0 = "big"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 2
                goto L31
            L26:
                java.lang.String r0 = "little"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 0
                goto L31
            L30:
                r0 = -1
            L31:
                switch(r0) {
                    case 0: goto L56;
                    case 1: goto L53;
                    case 2: goto L50;
                    case 3: goto L4d;
                    default: goto L34;
                }
            L34:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported cluster: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L4d:
                java.lang.String r0 = "cpu.cluster.prime.freq_max_mhz"
                return r0
            L50:
                java.lang.String r0 = "cpu.cluster.big.freq_max_mhz"
                return r0
            L53:
                java.lang.String r0 = "cpu.cluster.mid.freq_max_mhz"
                return r0
            L56:
                java.lang.String r0 = "cpu.cluster.little.freq_max_mhz"
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.thermal.ThermalConstraint.Builder.cpuFreqKey(java.lang.String):java.lang.String");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.String cpuOfflineKey(java.lang.String r3) {
            /*
                int r0 = r3.hashCode()
                switch(r0) {
                    case 97536: goto L1c;
                    case 108104: goto L12;
                    case 106934911: goto L8;
                    default: goto L7;
                }
            L7:
                goto L26
            L8:
                java.lang.String r0 = "prime"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 2
                goto L27
            L12:
                java.lang.String r0 = "mid"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 0
                goto L27
            L1c:
                java.lang.String r0 = "big"
                boolean r0 = r3.equals(r0)
                if (r0 == 0) goto L7
                r0 = 1
                goto L27
            L26:
                r0 = -1
            L27:
                switch(r0) {
                    case 0: goto L49;
                    case 1: goto L46;
                    case 2: goto L43;
                    default: goto L2a;
                }
            L2a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unsupported cluster for offline count: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L43:
                java.lang.String r0 = "cpu.cluster.prime.offline_count"
                return r0
            L46:
                java.lang.String r0 = "cpu.cluster.big.offline_count"
                return r0
            L49:
                java.lang.String r0 = "cpu.cluster.mid.offline_count"
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.thermal.ThermalConstraint.Builder.cpuOfflineKey(java.lang.String):java.lang.String");
        }
    }
}
