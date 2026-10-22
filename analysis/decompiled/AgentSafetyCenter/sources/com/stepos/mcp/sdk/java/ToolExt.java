package com.stepos.mcp.sdk.java;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ToolExt {

    @JsonProperty("ext")
    private Map<String, Object> ext;

    @JsonProperty("toolName")
    private String toolName;

    public ToolExt(String str, Map<String, Object> map) {
        this.toolName = str;
        this.ext = map;
    }

    public Map<String, Object> getExt() {
        return this.ext;
    }

    public String getToolName() {
        return this.toolName;
    }

    public String toString() {
        try {
            return ZyMcpJson.jsonMapper.writeValueAsString(this);
        } catch (IOException e10) {
            e10.printStackTrace();
            return super.toString();
        }
    }

    public ToolExt() {
    }
}
