package com.stepos.perfsched;

/* loaded from: classes.dex */
public class IOLimitConfig {
    public static final long LIMIT_10MB = 10485760;
    public static final long LIMIT_20MB = 20971520;
    public static final long LIMIT_2MB = 2097152;
    public static final long LIMIT_50MB = 52428800;
    public static final long LIMIT_5MB = 5242880;
    public static final long LIMIT_UNLIMITED = 0;
    private final int mPid;
    private final String mRequestTag;
    private final long mWriteLimit;

    private IOLimitConfig(Builder builder) {
        this.mWriteLimit = builder.mWriteLimit;
        this.mPid = builder.mPid;
        this.mRequestTag = builder.mRequestTag;
    }

    public long getWriteLimit() {
        return this.mWriteLimit;
    }

    public int getPid() {
        return this.mPid;
    }

    public String getRequestTag() {
        return this.mRequestTag;
    }

    public boolean hasWriteLimit() {
        return this.mWriteLimit >= 0;
    }

    public boolean hasPid() {
        return this.mPid > 0;
    }

    public boolean isValid() {
        return hasWriteLimit() || hasPid();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IOLimitConfig{");
        sb.append("writeLimit=").append(this.mWriteLimit);
        sb.append(" (").append(formatBytes(this.mWriteLimit)).append("/s)");
        if (hasPid()) {
            sb.append(", pid=").append(this.mPid);
        }
        if (this.mRequestTag != null && !this.mRequestTag.isEmpty()) {
            sb.append(", tag='").append(this.mRequestTag).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    private static String formatBytes(long bytes) {
        return bytes < 1024 ? bytes + "B" : bytes < 1048576 ? String.format("%.1fKB", Double.valueOf(bytes / 1024.0d)) : bytes < 1073741824 ? String.format("%.1fMB", Double.valueOf(bytes / 1048576.0d)) : String.format("%.1fGB", Double.valueOf(bytes / 1.073741824E9d));
    }

    public static class Builder {
        private long mWriteLimit = -1;
        private int mPid = -1;
        private String mRequestTag = "";

        public Builder setWriteLimit(long bytesPerSec) {
            this.mWriteLimit = bytesPerSec;
            return this;
        }

        public Builder setPid(int pid) {
            this.mPid = pid;
            return this;
        }

        public Builder setRequestTag(String tag) {
            this.mRequestTag = tag;
            return this;
        }

        public IOLimitConfig build() {
            return new IOLimitConfig(this);
        }
    }
}
