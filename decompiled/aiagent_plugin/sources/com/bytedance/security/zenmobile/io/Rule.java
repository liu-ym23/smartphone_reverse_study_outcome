package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Rule {

    @JsonProperty("anchor")
    private Anchor anchor;

    @JsonProperty("backward")
    private Extension backward;

    @JsonProperty("bdt_id")
    private long byteDataTagId;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("forward")
    private Extension forward;

    @JsonProperty("priority")
    private int priority;

    @JsonProperty("rule_id")
    private long ruleId;

    @JsonProperty("rule_name_en")
    private String ruleNameEn;

    @JsonProperty("rule_version")
    private int ruleVersion;

    @JsonProperty("sensitive_type")
    private String sensitiveType;

    @JsonProperty("value_excluders")
    private List<Excluder> valueExcluders;

    public Rule() {
        this.valueExcluders = new ArrayList();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public long getRuleId() {
        return this.ruleId;
    }

    public void setRuleId(long r1) {
        this.ruleId = r1;
    }

    public int getRuleVersion() {
        return this.ruleVersion;
    }

    public void setRuleVersion(int r1) {
        this.ruleVersion = r1;
    }

    public String getRuleNameEn() {
        return this.ruleNameEn;
    }

    public void setRuleNameEn(String r1) {
        this.ruleNameEn = r1;
    }

    public long getByteDataTagId() {
        return this.byteDataTagId;
    }

    public void setByteDataTagId(long r1) {
        this.byteDataTagId = r1;
    }

    public String getSensitiveType() {
        return this.sensitiveType;
    }

    public void setSensitiveType(String r1) {
        this.sensitiveType = r1;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int r1) {
        this.priority = r1;
    }

    public Anchor getAnchor() {
        return this.anchor;
    }

    public void setAnchor(Anchor r1) {
        this.anchor = r1;
    }

    public Extension getForward() {
        return this.forward;
    }

    public void setForward(Extension r1) {
        this.forward = r1;
    }

    public Extension getBackward() {
        return this.backward;
    }

    public void setBackward(Extension r1) {
        this.backward = r1;
    }

    public List<Excluder> getValueExcluders() {
        return this.valueExcluders;
    }

    public void setValueExcluders(List<Excluder> r3) {
        this.valueExcluders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
