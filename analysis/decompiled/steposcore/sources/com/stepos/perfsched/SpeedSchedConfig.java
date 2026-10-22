package com.stepos.perfsched;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SpeedSchedConfig {
    private final List<ImFlagRecord> mImFlagRecords;
    private final boolean mNeedHwuiTask;
    private final int mRequestPriority;
    private final String mRequestTag;
    private final int mScene;
    private final List<SvipRecord> mSvipRecords;

    public static final class Scene {
        public static final int SS_ANIM = 16;
        public static final int SS_ANIM_START = 8;
        public static final int SS_CAMERA = 4;
        public static final int SS_INPUT = 32;
        public static final int SS_LAUNCH = 1;
        public static final int SS_LAUNCHER_SI = 64;
        public static final int SS_SCENE_OPT_CLEAR = 0;
        public static final int SS_SCENE_OPT_SET = 128;
        public static final int SS_SLIDE = 2;

        private Scene() {
        }
    }

    public static final class SvipType {
        public static final int SS_OPT_CLEAR = 0;
        public static final int SS_OPT_RESET = 256;
        public static final int SS_OPT_SET = 128;
        public static final int SS_OPT_SET_PRIORITY = 512;
        public static final int SS_TYPE_ANIMATOR = 4;
        public static final int SS_TYPE_HEAVY = 2;
        public static final int SS_TYPE_LIGHT = 1;
        public static final int SS_TYPE_LISTPICK = 8;
        public static final int SS_TYPE_MQ_VIP = 16;
        public static final int SS_TYPE_SWIFT = 16384;

        private SvipType() {
        }
    }

    public static final class ImFlag {
        public static final int IM_FLAG_CAMERA_HAL = 5;
        public static final int IM_FLAG_CLEAR = 64;
        public static final int IM_FLAG_FORBID_SET_CPU_AFFINITY = 11;
        public static final int IM_FLAG_HWBINDER = 7;
        public static final int IM_FLAG_LAUNCHER = 8;
        public static final int IM_FLAG_NONE = 0;
        public static final int IM_FLAG_RENDERENGINE = 3;
        public static final int IM_FLAG_RENDER_THREAD = 18;
        public static final int IM_FLAG_SURFACEFLINGER = 1;
        public static final int IM_FLAG_SYSTEMSERVER_PID = 12;
        public static final int IM_FLAG_WEBVIEW = 4;

        private ImFlag() {
        }
    }

    public static final class Priority {
        public static final int DEFAULT = 0;
        public static final int PIPELINE = 5;
        public static final int PIPELINE_UI = 6;
        public static final int TOP_APP = 10;

        private Priority() {
        }
    }

    public static final class SvipRecord {
        public final int pid;
        public final int priority;
        public final int svipType;
        public final int tid;

        public SvipRecord(int pid, int tid, int svipType, int priority) {
            this.pid = pid;
            this.tid = tid;
            this.svipType = svipType;
            this.priority = priority;
        }

        public int toSvipValue() {
            if (this.priority > 0) {
                return this.svipType | 640 | (this.priority << 24);
            }
            return this.svipType | 128;
        }

        public String toString() {
            return "SvipRecord{pid=" + this.pid + ", tid=" + this.tid + ", type=0x" + Integer.toHexString(this.svipType) + ", priority=" + this.priority + "}";
        }
    }

    public static final class ImFlagRecord {
        public final int imFlag;
        public final int tid;

        public ImFlagRecord(int tid, int imFlag) {
            this.tid = tid;
            this.imFlag = imFlag;
        }

        public String toString() {
            return "ImFlagRecord{tid=" + this.tid + ", flag=" + this.imFlag + "}";
        }
    }

    private SpeedSchedConfig(Builder builder) {
        this.mScene = builder.mScene;
        this.mSvipRecords = Collections.unmodifiableList(new ArrayList(builder.mSvipRecords));
        this.mImFlagRecords = Collections.unmodifiableList(new ArrayList(builder.mImFlagRecords));
        this.mRequestPriority = builder.mRequestPriority;
        this.mRequestTag = builder.mRequestTag;
        this.mNeedHwuiTask = builder.mNeedHwuiTask;
    }

    public int getScene() {
        return this.mScene;
    }

    public List<SvipRecord> getSvipRecords() {
        return this.mSvipRecords;
    }

    public List<ImFlagRecord> getImFlagRecords() {
        return this.mImFlagRecords;
    }

    public int getRequestPriority() {
        return this.mRequestPriority;
    }

    public String getRequestTag() {
        return this.mRequestTag;
    }

    public boolean isNeedHwuiTask() {
        return this.mNeedHwuiTask;
    }

    public boolean hasScene() {
        return this.mScene > 0;
    }

    public boolean hasSvip() {
        return !this.mSvipRecords.isEmpty();
    }

    public boolean hasImFlag() {
        return !this.mImFlagRecords.isEmpty();
    }

    public boolean isValid() {
        return hasScene() || hasSvip() || hasImFlag();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SpeedSchedConfig{");
        if (hasScene()) {
            sb.append("scene=0x").append(Integer.toHexString(this.mScene));
        }
        if (hasSvip()) {
            sb.append(", svips=").append(this.mSvipRecords);
        }
        if (hasImFlag()) {
            sb.append(", imFlags=").append(this.mImFlagRecords);
        }
        sb.append(", priority=").append(this.mRequestPriority);
        if (this.mRequestTag != null && !this.mRequestTag.isEmpty()) {
            sb.append(", tag='").append(this.mRequestTag).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    public static class Builder {
        private int mScene = -1;
        private final List<SvipRecord> mSvipRecords = new ArrayList();
        private final List<ImFlagRecord> mImFlagRecords = new ArrayList();
        private int mRequestPriority = 0;
        private String mRequestTag = "";
        private boolean mNeedHwuiTask = false;

        public Builder setScene(int scene) {
            this.mScene = scene;
            return this;
        }

        public Builder addSvip(int pid, int tid, int svipType) {
            return addSvip(pid, tid, svipType, 0);
        }

        public Builder addSvip(int pid, int tid, int svipType, int priority) {
            this.mSvipRecords.add(new SvipRecord(pid, tid, svipType, priority));
            return this;
        }

        public Builder addImFlag(int tid, int imFlag) {
            this.mImFlagRecords.add(new ImFlagRecord(tid, imFlag));
            return this;
        }

        public Builder setRequestPriority(int priority) {
            this.mRequestPriority = priority;
            return this;
        }

        public Builder setRequestTag(String tag) {
            this.mRequestTag = tag;
            return this;
        }

        public Builder setNeedHwuiTask(boolean needHwuiTask) {
            this.mNeedHwuiTask = needHwuiTask;
            return this;
        }

        public SpeedSchedConfig build() {
            return new SpeedSchedConfig(this);
        }
    }
}
