package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AnchorFinder {

    @JsonProperty("extra")
    private Map<String, Object> extra;

    @JsonProperty("in_value")
    private boolean inValue;

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("values")
    private List<String> values;

    public AnchorFinder() {
        this.values = new ArrayList();
        this.extra = new HashMap();
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String r1) {
        this.mode = r1;
    }

    public List<String> getValues() {
        return this.values;
    }

    public void setValues(List<String> r3) {
        this.values = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public boolean isInValue() {
        return this.inValue;
    }

    public void setInValue(boolean r1) {
        this.inValue = r1;
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setExtra(Map<String, Object> r3) {
        this.extra = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }
}
