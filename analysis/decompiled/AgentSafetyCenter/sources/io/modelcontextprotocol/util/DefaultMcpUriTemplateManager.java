package io.modelcontextprotocol.util;

import androidx.activity.b;
import g5.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultMcpUriTemplateManager implements McpUriTemplateManager {
    private static final Pattern URI_VARIABLE_PATTERN = Pattern.compile("\\{([^/]+?)\\}");
    private final String uriTemplate;

    public DefaultMcpUriTemplateManager(String str) {
        Assert.hasText(str, "URI template must not be null or empty");
        this.uriTemplate = str;
    }

    @Override // io.modelcontextprotocol.util.McpUriTemplateManager
    public Map<String, String> extractVariableValues(String str) {
        String str2;
        HashMap map = new HashMap();
        List<String> variableNames = getVariableNames();
        if (Utils.hasText(str) && !variableNames.isEmpty()) {
            try {
                StringBuilder sb2 = new StringBuilder("^");
                Matcher matcher = URI_VARIABLE_PATTERN.matcher(this.uriTemplate);
                int i = 0;
                int iEnd = 0;
                while (true) {
                    boolean zFind = matcher.find();
                    str2 = this.uriTemplate;
                    if (!zFind) {
                        break;
                    }
                    sb2.append(Pattern.quote(str2.substring(iEnd, matcher.start())));
                    sb2.append("([^/]+)");
                    iEnd = matcher.end();
                }
                if (iEnd < str2.length()) {
                    sb2.append(Pattern.quote(this.uriTemplate.substring(iEnd)));
                }
                sb2.append("$");
                Matcher matcher2 = Pattern.compile(sb2.toString()).matcher(str);
                if (matcher2.find() && matcher2.groupCount() == variableNames.size()) {
                    while (i < variableNames.size()) {
                        int i3 = i + 1;
                        String strGroup = matcher2.group(i3);
                        if (strGroup == null || strGroup.isEmpty()) {
                            throw new IllegalArgumentException("Empty value for URI variable '" + variableNames.get(i) + "' in URI: " + str);
                        }
                        map.put(variableNames.get(i), strGroup);
                        i = i3;
                    }
                }
            } catch (Exception e10) {
                throw new IllegalArgumentException(b.j("Error parsing URI template: ", this.uriTemplate, " for URI: ", str), e10);
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
                f.s(c.b("Duplicate URI variable name in template: ", strGroup));
                return null;
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
        String str2;
        boolean zIsUriTemplate = isUriTemplate(this.uriTemplate);
        String str3 = this.uriTemplate;
        if (!zIsUriTemplate) {
            return str.equals(str3);
        }
        StringBuilder sb2 = new StringBuilder("^");
        Matcher matcher = URI_VARIABLE_PATTERN.matcher(str3);
        int iEnd = 0;
        while (true) {
            boolean zFind = matcher.find();
            str2 = this.uriTemplate;
            if (!zFind) {
                break;
            }
            sb2.append(Pattern.quote(str2.substring(iEnd, matcher.start())));
            sb2.append("([^/]+?)");
            iEnd = matcher.end();
        }
        if (iEnd < str2.length()) {
            sb2.append(Pattern.quote(this.uriTemplate.substring(iEnd)));
        }
        sb2.append("$");
        return Pattern.compile(sb2.toString()).matcher(str).matches();
    }
}
