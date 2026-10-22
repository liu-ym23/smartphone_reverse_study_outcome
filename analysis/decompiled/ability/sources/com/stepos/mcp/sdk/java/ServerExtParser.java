package com.stepos.mcp.sdk.java;

import io.modelcontextprotocol.json.TypeRef;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class ServerExtParser {
    private static final String TAG = "ServerExtParser";

    public static ServerExt parse(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        try {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '{') {
                return (ServerExt) ZyMcpJson.jsonMapper.readValue(strTrim, new TypeRef<ServerExt>() { // from class: com.stepos.mcp.sdk.java.ServerExtParser.1
                });
            }
            if (cCharAt == '[') {
                return new ServerExt(Collections.EMPTY_MAP, (List) ZyMcpJson.jsonMapper.readValue(strTrim, new TypeRef<List<ToolExt>>() { // from class: com.stepos.mcp.sdk.java.ServerExtParser.2
                }));
            }
            KLog.e(TAG, "Unsupported tool ext root type, first char=" + cCharAt);
            return null;
        } catch (Exception e) {
            KLog.e(TAG, "Failed to parse tool ext: " + e);
            return null;
        }
    }
}
