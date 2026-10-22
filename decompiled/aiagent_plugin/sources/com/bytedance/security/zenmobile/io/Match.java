package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes.dex */
public class Match {

    @JsonProperty("bdt_id")
    private long byteDataTagId;

    @JsonProperty("byte_end")
    private int byteEnd;

    @JsonProperty("byte_start")
    private int byteStart;

    @JsonProperty("priority")
    private int priority;

    @JsonProperty("rule_id")
    private long ruleID;

    @JsonProperty("rule_name_en")
    private String ruleNameEn;

    @JsonProperty("rule_name_zh")
    private String ruleNameZh;

    @JsonProperty("rule_version")
    private int ruleVersion;

    @JsonProperty("sensitive_type")
    private String sensitiveType;

    @JsonProperty("value")
    private String value;

    public Match() {
    }

    public Match(long r1, int r3, String r4, String r5, long r6, int r8, int r9, String r10, String r11, int r12) {
        this.ruleID = r1;
        this.ruleVersion = r3;
        this.ruleNameEn = r4;
        this.ruleNameZh = r5;
        this.byteDataTagId = r6;
        this.byteStart = r8;
        this.byteEnd = r9;
        this.value = r10;
        this.sensitiveType = r11;
        this.priority = r12;
    }

    public long getRuleID() {
        return this.ruleID;
    }

    public int getRuleVersion() {
        return this.ruleVersion;
    }

    public String getRuleNameEn() {
        return this.ruleNameEn;
    }

    public String getRuleNameZh() {
        return this.ruleNameZh;
    }

    public long getByteDataTagId() {
        return this.byteDataTagId;
    }

    public int getByteStart() {
        return this.byteStart;
    }

    public int getByteEnd() {
        return this.byteEnd;
    }

    public String getValue() {
        return this.value;
    }

    public String getSensitiveType() {
        return this.sensitiveType;
    }

    public int getPriority() {
        return this.priority;
    }
}
