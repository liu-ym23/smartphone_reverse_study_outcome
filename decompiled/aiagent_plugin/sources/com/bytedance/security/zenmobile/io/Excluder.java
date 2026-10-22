package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Excluder {

    @JsonProperty("mode")
    private String mode;

    @JsonProperty("values")
    private List<String> values;

    public Excluder() {
        this.values = new ArrayList();
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
}
