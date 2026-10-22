package com.stepos.perfsched;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class AiCpuSetConfig {
    private final int mClusterType;
    private final List<Integer> mCustomCores;
    private final int mPolicy;
    private final String mRequestTag;
    private final boolean mResetAffinityOnRelease;
    private final int mTid;

    public static final class Policy {
        public static final int NONE = 0;
        public static final int POWER_LOWEST = 2;
        public static final int POWER_SAVE = 1;

        private Policy() {
        }
    }

    public static final class Cluster {
        public static final int ALL = 4;
        public static final int BIG = 2;
        public static final int MEDIUM = 1;
        public static final int SMALL = 0;
        public static final int ULTRA_BIG = 3;

        private Cluster() {
        }
    }

    private AiCpuSetConfig(Builder builder) {
        this.mTid = builder.mTid;
        this.mPolicy = builder.mPolicy;
        this.mClusterType = builder.mClusterType;
        this.mCustomCores = Collections.unmodifiableList(new ArrayList(builder.mCustomCores));
        this.mResetAffinityOnRelease = builder.mResetAffinityOnRelease;
        this.mRequestTag = builder.mRequestTag;
    }

    public int getTid() {
        return this.mTid;
    }

    public int getPolicy() {
        return this.mPolicy;
    }

    public int getClusterType() {
        return this.mClusterType;
    }

    public List<Integer> getCustomCores() {
        return this.mCustomCores;
    }

    public boolean shouldResetAffinityOnRelease() {
        return this.mResetAffinityOnRelease;
    }

    public String getRequestTag() {
        return this.mRequestTag;
    }

    public boolean hasTid() {
        return this.mTid > 0;
    }

    public boolean hasPolicy() {
        return this.mPolicy != 0;
    }

    public boolean hasClusterType() {
        return this.mClusterType >= 0;
    }

    public boolean hasCustomCores() {
        return !this.mCustomCores.isEmpty();
    }

    public boolean isValid() {
        return hasTid() && (hasPolicy() || hasClusterType() || hasCustomCores());
    }

    public static final class Builder {
        private int mTid = -1;
        private int mPolicy = 0;
        private int mClusterType = -1;
        private final List<Integer> mCustomCores = new ArrayList();
        private boolean mResetAffinityOnRelease = true;
        private String mRequestTag = "";

        public Builder setTid(int tid) {
            this.mTid = tid;
            return this;
        }

        public Builder setPolicy(int policy) {
            this.mPolicy = policy;
            return this;
        }

        public Builder setClusterType(int clusterType) {
            this.mClusterType = clusterType;
            return this;
        }

        public Builder setResetAffinityOnRelease(boolean reset) {
            this.mResetAffinityOnRelease = reset;
            return this;
        }

        public Builder setRequestTag(String tag) {
            this.mRequestTag = tag;
            return this;
        }

        public Builder addCore(int coreId) {
            this.mCustomCores.add(Integer.valueOf(coreId));
            return this;
        }

        public Builder setCustomCores(List<Integer> cores) {
            this.mCustomCores.clear();
            if (cores != null) {
                this.mCustomCores.addAll(cores);
            }
            return this;
        }

        public AiCpuSetConfig build() {
            return new AiCpuSetConfig(this);
        }
    }
}
