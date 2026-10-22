package com.stepos.mcp.sdk.java;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
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

    @NonNull
    public String toString() {
        try {
            return ZyMcpJson.jsonMapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
            return super.toString();
        }
    }

    public ToolExt() {
    }
}
