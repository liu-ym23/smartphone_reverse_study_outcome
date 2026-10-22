package io.modelcontextprotocol.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DefaultMcpUriTemplateManager implements McpUriTemplateManager {
    private static final Pattern URI_VARIABLE_PATTERN = Pattern.compile("\\{([^/]+?)\\}");
    private final String uriTemplate;

    public DefaultMcpUriTemplateManager(String str) {
        Assert.hasText(str, "URI template must not be null or empty");
        this.uriTemplate = str;
    }

    @Override // io.modelcontextprotocol.util.McpUriTemplateManager
    public Map<String, String> extractVariableValues(String str) {
        HashMap map = new HashMap();
        List<String> variableNames = getVariableNames();
        if (Utils.hasText(str) && !variableNames.isEmpty()) {
            try {
                StringBuilder sb = new StringBuilder("^");
                Matcher matcher = URI_VARIABLE_PATTERN.matcher(this.uriTemplate);
                int i = 0;
                int iEnd = 0;
                while (matcher.find()) {
                    sb.append(Pattern.quote(this.uriTemplate.substring(iEnd, matcher.start())));
                    sb.append("([^/]+)");
                    iEnd = matcher.end();
                }
                if (iEnd < this.uriTemplate.length()) {
                    sb.append(Pattern.quote(this.uriTemplate.substring(iEnd)));
                }
                sb.append("$");
                Matcher matcher2 = Pattern.compile(sb.toString()).matcher(str);
                if (matcher2.find() && matcher2.groupCount() == variableNames.size()) {
                    while (i < variableNames.size()) {
                        int i6 = i + 1;
                        String strGroup = matcher2.group(i6);
                        if (strGroup == null || strGroup.isEmpty()) {
                            throw new IllegalArgumentException("Empty value for URI variable '" + variableNames.get(i) + "' in URI: " + str);
                        }
                        map.put(variableNames.get(i), strGroup);
                        i = i6;
                    }
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(B7.a.n("Error parsing URI template: ", this.uriTemplate, " for URI: ", str), e);
            }
        }
        return map;
    }

    @Override // io.modelcontextprotocol.util.McpUriTemplateManager
    public List<String> getVariableNames() {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = URI_VARIABLE_PATTERN.matcher(this.uriTemplate);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (arrayList.contains(strGroup)) {
                throw new IllegalArgumentException(B7.a.k("Duplicate URI variable name in template: ", strGroup));
            }
            arrayList.add(strGroup);
        }
        return arrayList;
    }

    @Override // io.modelcontextprotocol.util.McpUriTemplateManager
    public boolean isUriTemplate(String str) {
        return URI_VARIABLE_PATTERN.matcher(str).find();
    }

    @Override // io.modelcontextprotocol.util.McpUriTemplateManager
    public boolean matches(String str) {
        if (!isUriTemplate(this.uriTemplate)) {
            return str.equals(this.uriTemplate);
        }
        StringBuilder sb = new StringBuilder("^");
        Matcher matcher = URI_VARIABLE_PATTERN.matcher(this.uriTemplate);
        int iEnd = 0;
        while (matcher.find()) {
            sb.append(Pattern.quote(this.uriTemplate.substring(iEnd, matcher.start())));
            sb.append("([^/]+?)");
            iEnd = matcher.end();
        }
        if (iEnd < this.uriTemplate.length()) {
            sb.append(Pattern.quote(this.uriTemplate.substring(iEnd)));
        }
        sb.append("$");
        return Pattern.compile(sb.toString()).matcher(str).matches();
    }
}
