package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EventConfig {
    private JSONObject category;
    private JSONObject extraLog;
    private boolean isUploadImmediate;
    private JSONObject metric;
    private String serviceName;
    private int status;

    /* JADX INFO: renamed from: com.bytedance.apm.config.EventConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private JSONObject category;
        private JSONObject extraLog;
        private boolean isUploadImmediate;
        private JSONObject metric;
        private String serviceName;
        private int status;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ String access$100(Builder r0) {
            return r0.serviceName;
        }

        static /* synthetic */ int access$200(Builder r0) {
            return r0.status;
        }

        static /* synthetic */ JSONObject access$300(Builder r0) {
            return r0.category;
        }

        static /* synthetic */ JSONObject access$400(Builder r0) {
            return r0.metric;
        }

        static /* synthetic */ JSONObject access$500(Builder r0) {
            return r0.extraLog;
        }

        static /* synthetic */ boolean access$600(Builder r0) {
            return r0.isUploadImmediate;
        }

        private Builder() {
        }

        public Builder setServiceName(String r1) {
            this.serviceName = r1;
            return this;
        }

        public Builder setStatus(int r1) {
            this.status = r1;
            return this;
        }

        public Builder setCategory(JSONObject r1) {
            this.category = r1;
            return this;
        }

        public Builder setMetric(JSONObject r1) {
            this.metric = r1;
            return this;
        }

        public Builder setExtraLog(JSONObject r1) {
            this.extraLog = r1;
            return this;
        }

        public Builder isUploadImmediate(boolean r1) {
            this.isUploadImmediate = r1;
            return this;
        }

        public EventConfig build() {
            return new EventConfig(this);
        }
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public int getStatus() {
        return this.status;
    }

    public JSONObject getExtraLog() {
        return this.extraLog;
    }

    public boolean isUploadImmediate() {
        return this.isUploadImmediate;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public EventConfig(Builder r2) {
        this.serviceName = Builder.access$100(r2);
        this.status = Builder.access$200(r2);
        this.category = Builder.access$300(r2);
        this.metric = Builder.access$400(r2);
        this.extraLog = Builder.access$500(r2);
        this.isUploadImmediate = Builder.access$600(r2);
    }
}
