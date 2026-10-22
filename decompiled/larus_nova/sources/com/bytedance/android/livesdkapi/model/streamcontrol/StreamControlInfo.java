package com.bytedance.android.livesdkapi.model.streamcontrol;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class StreamControlInfo {

    @SerializedName("control_params")
    private String controlParams;

    public static class ControlParams {
        public static final String CONTROL_COMMAND_PUSH_CHANGE_CLARITY = "push_changeClarity";
        public static final String CONTROL_COMMAND_PUSH_CHANGE_URL = "push_changeUrl";
        public static final String CONTROL_TYPE_PULL = "pull";
        public static final String CONTROL_TYPE_PUSH = "push";

        @SerializedName("command")
        public String command;

        @SerializedName("extra")
        public String extra;

        @SerializedName("filter_required")
        public boolean filterRequired;

        @SerializedName("filter_rule_id")
        public long filterRuleId;

        @SerializedName("params")
        public String params;

        @SerializedName("random")
        public long random;

        @SerializedName("type")
        public String type;

        public ControlParams() {
        }
    }

    public StreamControlInfo() {
    }

    public String getControlParams() {
        return this.controlParams;
    }
}
