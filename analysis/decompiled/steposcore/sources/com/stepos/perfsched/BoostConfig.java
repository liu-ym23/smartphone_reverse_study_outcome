package com.stepos.perfsched;

/* loaded from: classes.dex */
public class BoostConfig {
    public static final int BOOST_ALL = -1;
    public static final int BOOST_CPU = 1;
    public static final int BOOST_DDR = 7;
    public static final int BOOST_FG_MIGRATE = 8;
    public static final int BOOST_GPU = 2;
    public static final int BOOST_IO = 4;
    public static final int BOOST_MEMORY = 6;
    public static final int BOOST_NPU = 3;
    public static final int BOOST_RENDER = 5;
    private final String cpuBigMaxFreq;
    private final String cpuBigMinFreq;
    private final int cpuBoostDurationMs;
    private final String cpuPrimeMaxFreq;
    private final String cpuPrimeMinFreq;
    private final int ddrBoostDurationMs;
    private final String ddrMaxFreq;
    private final String ddrMinFreq;
    private final int fgMigrateDownPct;
    private final int fgMigrateDurationMs;
    private final int fgMigrateUpPct;
    private final int gpuBoostDurationMs;
    private final String gpuMaxFreq;
    private final String gpuMinFreq;
    private final int priority;
    private final String requestTag;

    private BoostConfig(Builder builder) {
        this.cpuBigMinFreq = builder.cpuBigMinFreq;
        this.cpuBigMaxFreq = builder.cpuBigMaxFreq;
        this.cpuPrimeMinFreq = builder.cpuPrimeMinFreq;
        this.cpuPrimeMaxFreq = builder.cpuPrimeMaxFreq;
        this.cpuBoostDurationMs = builder.cpuBoostDurationMs;
        this.gpuMinFreq = builder.gpuMinFreq;
        this.gpuMaxFreq = builder.gpuMaxFreq;
        this.gpuBoostDurationMs = builder.gpuBoostDurationMs;
        this.ddrMinFreq = builder.ddrMinFreq;
        this.ddrMaxFreq = builder.ddrMaxFreq;
        this.ddrBoostDurationMs = builder.ddrBoostDurationMs;
        this.fgMigrateUpPct = builder.fgMigrateUpPct;
        this.fgMigrateDownPct = builder.fgMigrateDownPct;
        this.fgMigrateDurationMs = builder.fgMigrateDurationMs;
        this.priority = builder.priority;
        this.requestTag = builder.requestTag;
    }

    public String getCpuBigMinFreq() {
        return this.cpuBigMinFreq;
    }

    public String getCpuBigMaxFreq() {
        return this.cpuBigMaxFreq;
    }

    public String getCpuPrimeMinFreq() {
        return this.cpuPrimeMinFreq;
    }

    public String getCpuPrimeMaxFreq() {
        return this.cpuPrimeMaxFreq;
    }

    public int getCpuBoostDurationMs() {
        return this.cpuBoostDurationMs;
    }

    public String getGpuMinFreq() {
        return this.gpuMinFreq;
    }

    public String getGpuMaxFreq() {
        return this.gpuMaxFreq;
    }

    public int getGpuBoostDurationMs() {
        return this.gpuBoostDurationMs;
    }

    public String getDdrMinFreq() {
        return this.ddrMinFreq;
    }

    public String getDdrMaxFreq() {
        return this.ddrMaxFreq;
    }

    public int getDdrBoostDurationMs() {
        return this.ddrBoostDurationMs;
    }

    public int getFgMigrateUpPct() {
        return this.fgMigrateUpPct;
    }

    public int getFgMigrateDownPct() {
        return this.fgMigrateDownPct;
    }

    public int getFgMigrateDurationMs() {
        return this.fgMigrateDurationMs;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getRequestTag() {
        return this.requestTag;
    }

    public boolean hasCpuBoost() {
        return notEmpty(this.cpuBigMinFreq) || notEmpty(this.cpuBigMaxFreq) || notEmpty(this.cpuPrimeMinFreq) || notEmpty(this.cpuPrimeMaxFreq);
    }

    private static boolean notEmpty(String s) {
        return (s == null || s.isEmpty()) ? false : true;
    }

    public boolean hasGpuBoost() {
        return notEmpty(this.gpuMinFreq) || notEmpty(this.gpuMaxFreq);
    }

    public boolean hasDdrBoost() {
        return notEmpty(this.ddrMinFreq) || notEmpty(this.ddrMaxFreq);
    }

    public boolean hasFgMigrate() {
        return this.fgMigrateUpPct > 0 && this.fgMigrateDownPct > 0;
    }

    public boolean isValid() {
        return hasCpuBoost() || hasGpuBoost() || hasDdrBoost() || hasFgMigrate();
    }

    public String toString() {
        return "BoostConfig{cpuBigMinFreq='" + this.cpuBigMinFreq + "', cpuBigMaxFreq='" + this.cpuBigMaxFreq + "', cpuPrimeMinFreq='" + this.cpuPrimeMinFreq + "', cpuPrimeMaxFreq='" + this.cpuPrimeMaxFreq + "', cpuBoostDurationMs=" + this.cpuBoostDurationMs + ", gpuMinFreq='" + this.gpuMinFreq + "', gpuMaxFreq='" + this.gpuMaxFreq + "', gpuBoostDurationMs=" + this.gpuBoostDurationMs + ", ddrMinFreq='" + this.ddrMinFreq + "', ddrMaxFreq='" + this.ddrMaxFreq + "', ddrBoostDurationMs=" + this.ddrBoostDurationMs + ", fgMigrateUpPct=" + this.fgMigrateUpPct + ", fgMigrateDownPct=" + this.fgMigrateDownPct + ", fgMigrateDurationMs=" + this.fgMigrateDurationMs + ", priority=" + this.priority + ", requestTag='" + this.requestTag + "'}";
    }

    public static class Builder {
        private String cpuBigMinFreq = null;
        private String cpuBigMaxFreq = null;
        private String cpuPrimeMinFreq = null;
        private String cpuPrimeMaxFreq = null;
        private int cpuBoostDurationMs = 0;
        private String gpuMinFreq = null;
        private String gpuMaxFreq = null;
        private int gpuBoostDurationMs = 0;
        private String ddrMinFreq = null;
        private String ddrMaxFreq = null;
        private int ddrBoostDurationMs = 0;
        private int fgMigrateUpPct = 0;
        private int fgMigrateDownPct = 0;
        private int fgMigrateDurationMs = 0;
        private int priority = 0;
        private String requestTag = "";

        public Builder setCpuBigMinFreq(String level) {
            this.cpuBigMinFreq = level;
            return this;
        }

        public Builder setCpuBigMaxFreq(String level) {
            this.cpuBigMaxFreq = level;
            return this;
        }

        public Builder setCpuPrimeMinFreq(String level) {
            this.cpuPrimeMinFreq = level;
            return this;
        }

        public Builder setCpuPrimeMaxFreq(String level) {
            this.cpuPrimeMaxFreq = level;
            return this;
        }

        public Builder setCpuBoostDurationMs(int durationMs) {
            this.cpuBoostDurationMs = durationMs;
            return this;
        }

        public Builder setGpuMinFreq(String level) {
            this.gpuMinFreq = level;
            return this;
        }

        public Builder setGpuMaxFreq(String level) {
            this.gpuMaxFreq = level;
            return this;
        }

        public Builder setGpuBoostDurationMs(int durationMs) {
            this.gpuBoostDurationMs = durationMs;
            return this;
        }

        public Builder setDdrMinFreq(String level) {
            this.ddrMinFreq = level;
            return this;
        }

        public Builder setDdrMaxFreq(String level) {
            this.ddrMaxFreq = level;
            return this;
        }

        public Builder setDdrBoostDurationMs(int durationMs) {
            this.ddrBoostDurationMs = durationMs;
            return this;
        }

        public Builder setFgMigrateUpPct(int upPct) {
            this.fgMigrateUpPct = upPct;
            return this;
        }

        public Builder setFgMigrateDownPct(int downPct) {
            this.fgMigrateDownPct = downPct;
            return this;
        }

        public Builder setFgMigrateDurationMs(int durationMs) {
            this.fgMigrateDurationMs = durationMs;
            return this;
        }

        public Builder setPriority(int priority) {
            this.priority = priority;
            return this;
        }

        public Builder setRequestTag(String tag) {
            this.requestTag = tag;
            return this;
        }

        public BoostConfig build() {
            return new BoostConfig(this);
        }
    }

    public static final class CpuLevel {
        public static final String L0_DEEP_SLEEP = "L0";
        public static final String L1_ULTRA_SAVE = "L1";
        public static final String L2_POWER_SAVE = "L2";
        public static final String L3_LIGHT_SAVE = "L3";
        public static final String L4_BALANCED = "L4";
        public static final String L5_LIGHT_PERF = "L5";
        public static final String L6_PERFORMANCE = "L6";
        public static final String L7_MID_HIGH = "L7";
        public static final String L8_HIGH_FREQ = "L8";
        public static final String L9_EXTREME = "L9";

        private CpuLevel() {
        }
    }

    public static final class GpuLevel {
        public static final String G0_SLEEP = "G0";
        public static final String G1_ULTRA_SAVE = "G1";
        public static final String G2_POWER_SAVE = "G2";
        public static final String G3_LIGHT_SAVE = "G3";
        public static final String G4_BALANCED = "G4";
        public static final String G5_LIGHT_PERF = "G5";
        public static final String G6_PERFORMANCE = "G6";
        public static final String G7_MID_HIGH = "G7";
        public static final String G8_HIGH_FREQ = "G8";
        public static final String G9_EXTREME = "G9";

        private GpuLevel() {
        }
    }

    public static final class DdrLevel {
        public static final String D0_LOW_POWER = "D0";
        public static final String D1_ULTRA_SAVE = "D1";
        public static final String D2_POWER_SAVE = "D2";
        public static final String D3_LIGHT_SAVE = "D3";
        public static final String D4_BALANCED = "D4";
        public static final String D5_LIGHT_PERF = "D5";
        public static final String D6_PERFORMANCE = "D6";
        public static final String D7_MID_HIGH = "D7";
        public static final String D8_HIGH_FREQ = "D8";
        public static final String D9_EXTREME = "D9";

        private DdrLevel() {
        }
    }
}
