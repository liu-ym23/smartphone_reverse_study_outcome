package x3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final List f6875a;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a("hostname", "^([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])(\\.([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]))*$", "format.hostname"));
        arrayList.add(a("ipv4", "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$", "format.ipv4"));
        arrayList.add(new f());
        arrayList.add(a("json-pointer", "^(/([^/#~]|[~](?=[01]))*)*$", "format.json-pointer"));
        arrayList.add(a("relative-json-pointer", "^(0|([1-9]\\d*))(#|(/([^/#~]|[~](?=[01]))*)*)$", "format.relative-json-pointer"));
        arrayList.add(a("uri-template", "^([^\\p{Cntrl}\"'%<>\\^`\\{|\\}]|%\\p{XDigit}{2}|\\{[+#./;?&=,!@|]?((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?)(,((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?))*\\})*$", "format.uri-template"));
        arrayList.add(a("uuid", "^\\p{XDigit}{8}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}$", "format.uuid"));
        arrayList.add(new g(1));
        arrayList.add(new b());
        arrayList.add(new com.networknt.schema.format.a(0));
        arrayList.add(new com.networknt.schema.format.a(1));
        arrayList.add(new g(0));
        arrayList.add(new h(0));
        arrayList.add(new h(1));
        arrayList.add(new j());
        arrayList.add(new k());
        arrayList.add(new h(2));
        arrayList.add(new h(3));
        arrayList.add(new c());
        arrayList.add(a("alpha", "^[a-zA-Z]+$", null));
        arrayList.add(a("alphanumeric", "^[a-zA-Z0-9]+$", null));
        arrayList.add(a(TypedValues.Custom.S_COLOR, "(#?([0-9A-Fa-f]{3,6})\\b)|(aqua)|(black)|(blue)|(fuchsia)|(gray)|(green)|(lime)|(maroon)|(navy)|(olive)|(orange)|(purple)|(red)|(silver)|(teal)|(white)|(yellow)|(rgb\\(\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*\\))|(rgb\\(\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*\\))", null));
        arrayList.add(a("ip-address", "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", null));
        arrayList.add(a("phone", "^\\+(?:[0-9] ?){6,14}[0-9]$", null));
        arrayList.add(a("style", "\\s*(.+?):\\s*([^;]+);?", null));
        arrayList.add(a("utc-millisec", "^[0-9]+(\\.?[0-9]+)?$", null));
        f6875a = Collections.unmodifiableList(arrayList);
    }

    public static i a(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "format";
        }
        return new i(str, str2, str3);
    }
}
