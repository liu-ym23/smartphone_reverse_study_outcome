package com.stepos.pps.logpull;

import java.util.Arrays;

/* loaded from: classes.dex */
public class LogPullConfig {
    public long configId;
    public String deadlineTime;
    public String fileType;
    public String logEndTime;
    public String logStartTime;
    public String[] logTypes;
    public long maxLimit;
    public String oaid;

    public String toString() {
        return "LogPullConfig{configId=" + this.configId + ", logTypes=" + Arrays.toString(this.logTypes) + ", logStartTime=" + this.logStartTime + ", logEndTime=" + this.logEndTime + ", deadlineTime=" + this.deadlineTime + ", maxLimit=" + this.maxLimit + ", fileType=" + this.fileType + "}";
    }
}
