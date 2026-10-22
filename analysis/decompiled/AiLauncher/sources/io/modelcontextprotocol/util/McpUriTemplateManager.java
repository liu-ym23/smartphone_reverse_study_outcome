package io.modelcontextprotocol.util;

import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface McpUriTemplateManager {
    Map<String, String> extractVariableValues(String str);

    List<String> getVariableNames();

    boolean isUriTemplate(String str);

    boolean matches(String str);
}
