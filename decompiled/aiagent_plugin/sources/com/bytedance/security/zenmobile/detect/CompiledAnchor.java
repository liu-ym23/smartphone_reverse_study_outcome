package com.bytedance.security.zenmobile.detect;

import com.bytedance.security.zenmobile.detect.filter.Excluder;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CompiledAnchor {

    @JsonProperty("c_excluders")
    private List<Excluder> compiledExcluders;

    public CompiledAnchor() {
        this.compiledExcluders = new ArrayList();
    }

    public void addExcluder(Excluder r2) {
        if (this.compiledExcluders != null) goto L5;
        this.compiledExcluders = new ArrayList();
    L5:
        this.compiledExcluders.add(r2);
    }

    public List<Excluder> getCompiledExcluders() {
        return this.compiledExcluders;
    }
}
