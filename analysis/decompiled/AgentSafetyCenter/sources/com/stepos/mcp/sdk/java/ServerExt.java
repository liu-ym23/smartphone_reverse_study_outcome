package com.stepos.mcp.sdk.java;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ServerExt {

    @JsonProperty("serverExts")
    private Map<String, Object> serverExts;

    @JsonProperty("toolExts")
    private List<ToolExt> toolExts;

    public ServerExt(Map<String, Object> map, List<ToolExt> list) {
        this.serverExts = map;
        this.toolExts = list;
    }

    public Map<String, Object> getServerExts() {
        return this.serverExts;
    }

    public List<ToolExt> getToolExts() {
        return this.toolExts;
    }

    public ServerExt() {
    }
}
