package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public class s2 {

    @SerializedName("enable_log_dump")
    private boolean dumpEnv;

    @SerializedName("enable_all_log")
    private boolean enable;

    @SerializedName("enable_log_lifecycle")
    private boolean lifecycle;

    @SerializedName("enable_log_message")
    private boolean message;

    @SerializedName("enable_log_network")
    private boolean network;

    @SerializedName("enable_log_settings")
    private boolean settings;

    public static s2 b() {
        s2 r100 = new s2();
        r100.enable = true;
        r100.network = true;
        r100.lifecycle = true;
        r100.dumpEnv = true;
        r100.settings = true;
        r100.message = true;
        return r100;
    }

    public final boolean a() {
        return this.enable & this.network;
    }

    public s2() {
        this.enable = false;
        this.network = false;
        this.lifecycle = false;
        this.dumpEnv = false;
        this.settings = false;
        this.message = false;
    }
}
