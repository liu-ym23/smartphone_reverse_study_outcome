package com.volcengine.tos.model.bucket;

import B7.a;
import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes3.dex */
public class Progress {

    @JsonProperty("HistoricalObject")
    private double historicalObject;

    @JsonProperty("NewObject")
    private String newObject;

    public static final class ProgressBuilder {
        private double historicalObject;
        private String newObject;

        public Progress build() {
            Progress progress = new Progress();
            progress.setHistoricalObject(this.historicalObject);
            progress.setNewObject(this.newObject);
            return progress;
        }

        public ProgressBuilder historicalObject(double d) {
            this.historicalObject = d;
            return this;
        }

        public ProgressBuilder newObject(String str) {
            this.newObject = str;
            return this;
        }

        private ProgressBuilder() {
        }
    }

    public static ProgressBuilder builder() {
        return new ProgressBuilder();
    }

    public double getHistoricalObject() {
        return this.historicalObject;
    }

    public String getNewObject() {
        return this.newObject;
    }

    public Progress setHistoricalObject(double d) {
        this.historicalObject = d;
        return this;
    }

    public Progress setNewObject(String str) {
        this.newObject = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Progress{historicalObject=");
        sb.append(this.historicalObject);
        sb.append(", newObject='");
        return a.q(sb, this.newObject, "'}");
    }
}
