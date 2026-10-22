package com.stepos.mcp.sdk.java;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ServerExt {

    @JsonProperty("serverExts")
    private Map<String, Object> serverExts;

    @JsonProperty("toolExts")
    private List<ToolExt> toolExts;

    public ServerExt() {
    }

    public Map<String, Object> getServerExts() {
        return this.serverExts;
    }

    public List<ToolExt> getToolExts() {
        return this.toolExts;
    }

    public ServerExt(Map<String, Object> map, List<ToolExt> list) {
        this.serverExts = map;
        this.toolExts = list;
    }
}
