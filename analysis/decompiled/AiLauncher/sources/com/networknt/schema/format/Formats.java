package com.networknt.schema.format;

import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class Formats {
    public static final List<Format> DEFAULT;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pattern("hostname", "^([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])(\\.([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]))*$", "format.hostname"));
        arrayList.add(pattern("ipv4", "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$", "format.ipv4"));
        arrayList.add(new IPv6Format());
        arrayList.add(pattern("json-pointer", "^(/([^/#~]|[~](?=[01]))*)*$", "format.json-pointer"));
        arrayList.add(pattern("relative-json-pointer", "^(0|([1-9]\\d*))(#|(/([^/#~]|[~](?=[01]))*)*)$", "format.relative-json-pointer"));
        arrayList.add(pattern("uri-template", "^([^\\p{Cntrl}\"'%<>\\^`\\{|\\}]|%\\p{XDigit}{2}|\\{[+#./;?&=,!@|]?((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?)(,((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?))*\\})*$", "format.uri-template"));
        arrayList.add(pattern("uuid", "^\\p{XDigit}{8}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}$", "format.uuid"));
        arrayList.add(new DateFormat());
        arrayList.add(new DateTimeFormat());
        arrayList.add(new EmailFormat());
        arrayList.add(new IdnEmailFormat());
        arrayList.add(new IdnHostnameFormat());
        arrayList.add(new IriFormat());
        arrayList.add(new IriReferenceFormat());
        arrayList.add(new RegexFormat());
        arrayList.add(new TimeFormat());
        arrayList.add(new UriFormat());
        arrayList.add(new UriReferenceFormat());
        arrayList.add(new DurationFormat());
        arrayList.add(pattern(ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "^[a-zA-Z]+$"));
        arrayList.add(pattern("alphanumeric", "^[a-zA-Z0-9]+$"));
        arrayList.add(pattern("color", "(#?([0-9A-Fa-f]{3,6})\\b)|(aqua)|(black)|(blue)|(fuchsia)|(gray)|(green)|(lime)|(maroon)|(navy)|(olive)|(orange)|(purple)|(red)|(silver)|(teal)|(white)|(yellow)|(rgb\\(\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*\\))|(rgb\\(\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*\\))"));
        arrayList.add(pattern("ip-address", "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"));
        arrayList.add(pattern("phone", "^\\+(?:[0-9] ?){6,14}[0-9]$"));
        arrayList.add(pattern("style", "\\s*(.+?):\\s*([^;]+);?"));
        arrayList.add(pattern("utc-millisec", "^[0-9]+(\\.?[0-9]+)?$"));
        DEFAULT = Collections.unmodifiableList(arrayList);
    }

    private Formats() {
    }

    public static PatternFormat pattern(String str, String str2, String str3) {
        return PatternFormat.of(str, str2, str3);
    }

    public static PatternFormat pattern(String str, String str2) {
        return pattern(str, str2, null);
    }
}
