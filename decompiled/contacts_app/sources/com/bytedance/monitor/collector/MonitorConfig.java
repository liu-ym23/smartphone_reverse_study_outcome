package com.bytedance.monitor.collector;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorConfig {
    private long alogRef;
    private long atraceTag;
    private boolean enableAtrace;
    private boolean enableBinder;
    private boolean enableLooperMonitor;
    private boolean enableStackSampling;
    private int runMode;

    public static class Builder {
        private long alogRef;
        private long atraceTag;
        private boolean enableAtrace;
        private boolean enableBinder;
        private boolean enableLock;
        private boolean enableLooperMonitor;
        private boolean enableStackSampling;
        private int runMode;

        @Deprecated
        public Builder enableLock(boolean r1) {
            return this;
        }

        public Builder() {
        }

        static /* synthetic */ boolean access$000(Builder r0) {
            return r0.enableAtrace;
        }

        static /* synthetic */ boolean access$100(Builder r0) {
            return r0.enableBinder;
        }

        static /* synthetic */ boolean access$200(Builder r0) {
            return r0.enableLooperMonitor;
        }

        static /* synthetic */ long access$300(Builder r2) {
            return r2.atraceTag;
        }

        static /* synthetic */ int access$400(Builder r0) {
            return r0.runMode;
        }

        static /* synthetic */ boolean access$500(Builder r0) {
            return r0.enableStackSampling;
        }

        public Builder enableAtrace(boolean r1) {
            this.enableAtrace = r1;
            return this;
        }

        public Builder enableBinder(boolean r1) {
            this.enableBinder = r1;
            return this;
        }

        public Builder enableLooperMonitor(boolean r1) {
            this.enableLooperMonitor = r1;
            return this;
        }

        public Builder enableStackSampling(boolean r1) {
            this.enableStackSampling = r1;
            return this;
        }

        public Builder atraceTag(long r1) {
            this.atraceTag = r1;
            return this;
        }

        public Builder runMode(int r1) {
            this.runMode = r1;
            return this;
        }

        public Builder alogRef(long r1) {
            this.alogRef = r1;
            return this;
        }

        public MonitorConfig build() {
            return new MonitorConfig(this);
        }
    }

    public MonitorConfig(Builder r3) {
        this.alogRef = 0;
        this.enableAtrace = Builder.access$000(r3);
        this.enableBinder = Builder.access$100(r3);
        this.enableLooperMonitor = Builder.access$200(r3);
        this.atraceTag = Builder.access$300(r3);
        this.runMode = Builder.access$400(r3);
        this.enableStackSampling = Builder.access$500(r3);
    }

    public boolean isEnableAtrace() {
        return this.enableAtrace;
    }

    public boolean isEnableBinder() {
        return this.enableBinder;
    }

    public boolean isEnableLooperMonitor() {
        return this.enableLooperMonitor;
    }

    public boolean isEnableStackSampling() {
        return this.enableStackSampling;
    }

    public long getAtraceTag() {
        return this.atraceTag;
    }

    public int getRunMode() {
        return this.runMode;
    }

    public long getAlogRef() {
        return this.alogRef;
    }

    public String toString() {
        return "MonitorConfig{enableAtrace=" + this.enableAtrace + ", enableBinder=" + this.enableBinder + ", enableLooperMonitor=" + this.enableLooperMonitor + ", enableStackSampling=" + this.enableStackSampling + ", atraceTag=" + this.atraceTag + ", runMode=" + this.runMode + ", alogRef=" + this.alogRef + '}';
    }
}
