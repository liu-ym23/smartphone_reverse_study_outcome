package com.bytedance.security.zenmobile.boot;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.b.a.b;
import com.fasterxml.jackson.databind.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Config {

    @JsonProperty("deidentifier")
    DeidentifierConfig deidentifier;

    @JsonProperty("max_detection_length")
    int maxDetectionLength;

    @JsonProperty("profile")
    ProfileConfig profile;

    @JsonProperty("skip_failure_compilation")
    boolean skipFailureCompilation;

    @JsonProperty("truncation_length")
    int truncationLength;

    public Config() {
    }

    public static Config fromJson(String r2) {
        return (Config) ZeusTransformUtils.preCheckCast(new t().a(r2, Config.class), Config.class, "com.obric.aiagent.plugin");
    }

    public static Config fromYaml(String r3) {
        return (Config) ZeusTransformUtils.preCheckCast(new t(new b()).a(r3, Config.class), Config.class, "com.obric.aiagent.plugin");
    }

    public static Config defaultConfig() {
        Config r0 = new Config();
        r0.profile = ProfileConfig.defaultProfileConfig();
        r0.skipFailureCompilation = false;
        r0.deidentifier = DeidentifierConfig.defaultDeidentifierConfig();
        r0.maxDetectionLength = 0;
        r0.truncationLength = 0;
        return r0;
    }
}
