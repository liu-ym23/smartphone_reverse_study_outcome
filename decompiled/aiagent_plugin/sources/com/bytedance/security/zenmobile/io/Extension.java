package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Extension {

    @JsonProperty("excluders")
    private List<Excluder> excluders;

    @JsonProperty("extenders")
    private List<ExtensionExtender> extenders;

    public Extension() {
        this.extenders = new ArrayList();
        this.excluders = new ArrayList();
    }

    public List<ExtensionExtender> getExtenders() {
        return this.extenders;
    }

    public void setExtenders(List<ExtensionExtender> r3) {
        this.extenders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public List<Excluder> getExcluders() {
        return this.excluders;
    }

    public void setExcluders(List<Excluder> r3) {
        this.excluders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
