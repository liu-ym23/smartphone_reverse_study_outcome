package com.bytedance.security.zenmobile.detect;

import com.bytedance.security.zenmobile.detect.extension.Extender;
import com.bytedance.security.zenmobile.detect.filter.Excluder;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CompiledForward {

    @JsonProperty("c_excluders")
    private List<Excluder> compiledExcluders;

    @JsonProperty("c_extenders")
    private List<Extender> compiledExtenders;

    public CompiledForward() {
        this.compiledExtenders = new ArrayList();
        this.compiledExcluders = new ArrayList();
    }

    public void addExtender(Extender r2) {
        if (this.compiledExtenders != null) goto L5;
        this.compiledExtenders = new ArrayList();
    L5:
        this.compiledExtenders.add(r2);
    }

    public void addExcluder(Excluder r2) {
        if (this.compiledExcluders != null) goto L5;
        this.compiledExcluders = new ArrayList();
    L5:
        this.compiledExcluders.add(r2);
    }

    public List<Extender> getCompiledExtenders() {
        return this.compiledExtenders;
    }

    public List<Excluder> getCompiledExcluders() {
        return this.compiledExcluders;
    }
}
