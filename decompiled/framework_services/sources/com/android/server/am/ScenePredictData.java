package com.android.server.am;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScenePredictData {
    private final List<AppInfo> appList;
    private final int duration;
    private final String event;
    private final long timestamp;

    public static class AppInfo {
        private final String packageName;
        private final float prob;

        public AppInfo(String packageName, float prob) {
            this.packageName = packageName;
            this.prob = prob;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public float getProb() {
            return this.prob;
        }

        public String toString() {
            return "AppInfo{" + this.packageName + ", " + this.prob + "}";
        }
    }

    public static class Builder {
        private List<AppInfo> appList;
        private int duration;
        private String event;
        private long timestamp;

        /* JADX INFO: renamed from: -$$Nest$fgetappList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m1576$$Nest$fgetappList(Builder r0) {
            return r0.appList;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetduration, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m1577$$Nest$fgetduration(Builder r0) {
            return r0.duration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetevent, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m1578$$Nest$fgetevent(Builder r0) {
            return r0.event;
        }

        /* JADX INFO: renamed from: -$$Nest$fgettimestamp, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m1579$$Nest$fgettimestamp(Builder r2) {
            return r2.timestamp;
        }

        public Builder() {
            this.appList = new ArrayList();
            this.event = "";
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder addApp(String packageName, float prob) {
            this.appList.add(new AppInfo(packageName, prob));
            return this;
        }

        public Builder setEvent(String event) {
            this.event = event;
            return this;
        }

        public ScenePredictData build() {
            return new ScenePredictData(this, null);
        }
    }

    /* synthetic */ ScenePredictData(Builder r1, ScenePredictDataIA r2) {
        this(r1);
    }

    private ScenePredictData(Builder builder) {
        this.timestamp = Builder.m1579$$Nest$fgettimestamp(builder);
        this.duration = Builder.m1577$$Nest$fgetduration(builder);
        this.appList = Builder.m1576$$Nest$fgetappList(builder);
        this.event = Builder.m1578$$Nest$fgetevent(builder);
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getEvent() {
        return this.event;
    }

    public List<AppInfo> getAppList() {
        return this.appList;
    }

    public String toString() {
        return "ScenePredictData{ ts:" + this.timestamp + ", duration:" + this.duration + ", appList:" + this.appList + "}, event:" + this.event;
    }
}
