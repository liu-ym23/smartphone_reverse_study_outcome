package com.bytedance.security.zenmobile.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Anchor {

    @JsonProperty("excluders")
    private List<Excluder> excluders;

    @JsonProperty("finders")
    private List<AnchorFinder> finders;

    public Anchor() {
        this.finders = new ArrayList();
        this.excluders = new ArrayList();
    }

    public List<AnchorFinder> getFinders() {
        return this.finders;
    }

    public void setFinders(List<AnchorFinder> r3) {
        this.finders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public List<Excluder> getExcluders() {
        return this.excluders;
    }

    public void setExcluders(List<Excluder> r3) {
        this.excluders = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
