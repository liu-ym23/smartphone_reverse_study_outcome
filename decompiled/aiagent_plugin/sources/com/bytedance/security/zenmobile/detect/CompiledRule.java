package com.bytedance.security.zenmobile.detect;

import com.bytedance.security.zenmobile.detect.filter.Excluder;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CompiledRule {

    @JsonProperty("bdt_id")
    private long byteDataTagId;

    @JsonProperty("c_anchor")
    private CompiledAnchor compiledAnchor;

    @JsonProperty("c_backward")
    private CompiledBackward compiledBackward;

    @JsonProperty("c_forward")
    private CompiledForward compiledForward;

    @JsonProperty("c_value_excluders")
    private List<Excluder> compiledValueExcluders;

    @JsonProperty("editors")
    private List<String> editors;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("priority")
    private int priority;

    @JsonProperty("rule_id")
    private long ruleId;

    @JsonProperty("rule_name_en")
    private String ruleNameEn;

    @JsonProperty("rule_name_zh")
    private String ruleNameZh;

    @JsonProperty("rule_version")
    private int ruleVersion;

    @JsonProperty("sensitive_type")
    private String sensitiveType;

    public CompiledRule() {
        this.editors = new ArrayList();
        this.compiledValueExcluders = new ArrayList();
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

    public String getRuleNameZh() {
        return this.ruleNameZh;
    }

    public void setRuleNameZh(String r1) {
        this.ruleNameZh = r1;
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

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String r1) {
        this.owner = r1;
    }

    public List<String> getEditors() {
        return this.editors;
    }

    public void setEditors(List<String> r3) {
        this.editors = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public CompiledAnchor getCompiledAnchor() {
        return this.compiledAnchor;
    }

    public void setCompiledAnchor(CompiledAnchor r1) {
        this.compiledAnchor = r1;
    }

    public CompiledForward getCompiledForward() {
        return this.compiledForward;
    }

    public void setCompiledForward(CompiledForward r1) {
        this.compiledForward = r1;
    }

    public CompiledBackward getCompiledBackward() {
        return this.compiledBackward;
    }

    public void setCompiledBackward(CompiledBackward r1) {
        this.compiledBackward = r1;
    }

    public List<Excluder> getCompiledValueExcluders() {
        return this.compiledValueExcluders;
    }

    public void setCompiledValueExcluders(List<Excluder> r3) {
        this.compiledValueExcluders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
