package com.bytedance.security.zenmobile.boot;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes.dex */
public class DeidentifierConfig {
    static final String DEIDENTIFIER_MODE_MASKER = "masker";

    @JsonProperty("mode")
    String mode;

    @JsonProperty("value")
    String value;

    public DeidentifierConfig(String r1, String r2) {
        this.mode = r1;
        this.value = r2;
    }

    public static DeidentifierConfig defaultDeidentifierConfig() {
        return new DeidentifierConfig(DEIDENTIFIER_MODE_MASKER, "*");
    }

    public String getMode() {
        return this.mode;
    }

    public String getValue() {
        return this.value;
    }
}
