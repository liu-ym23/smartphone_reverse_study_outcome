package z7;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final List f16474a;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a("hostname", "^([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])(\\.([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9]))*$", "format.hostname"));
        arrayList.add(a("ipv4", "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$", "format.ipv4"));
        arrayList.add(new g());
        arrayList.add(a("json-pointer", "^(/([^/#~]|[~](?=[01]))*)*$", "format.json-pointer"));
        arrayList.add(a("relative-json-pointer", "^(0|([1-9]\\d*))(#|(/([^/#~]|[~](?=[01]))*)*)$", "format.relative-json-pointer"));
        arrayList.add(a("uri-template", "^([^\\p{Cntrl}\"'%<>\\^`\\{|\\}]|%\\p{XDigit}{2}|\\{[+#./;?&=,!@|]?((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?)(,((\\w|%\\p{XDigit}{2})(\\.?(\\w|%\\p{XDigit}{2}))*(:[1-9]\\d{0,3}|\\*)?))*\\})*$", "format.uri-template"));
        arrayList.add(a("uuid", "^\\p{XDigit}{8}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{4}-\\p{XDigit}{12}$", "format.uuid"));
        arrayList.add(new h(1));
        arrayList.add(new a());
        f fVar = new f(true, true);
        c cVar = new c(0);
        cVar.f16473b = fVar;
        VarHandle.storeStoreFence();
        arrayList.add(cVar);
        f fVar2 = new f(true, true);
        c cVar2 = new c(1);
        cVar2.f16473b = fVar2;
        VarHandle.storeStoreFence();
        arrayList.add(cVar2);
        arrayList.add(new h(0));
        arrayList.add(new i(0));
        arrayList.add(new i(1));
        arrayList.add(new k());
        arrayList.add(new l());
        arrayList.add(new i(2));
        arrayList.add(new i(3));
        arrayList.add(new b());
        arrayList.add(a("alpha", "^[a-zA-Z]+$", null));
        arrayList.add(a("alphanumeric", "^[a-zA-Z0-9]+$", null));
        arrayList.add(a("color", "(#?([0-9A-Fa-f]{3,6})\\b)|(aqua)|(black)|(blue)|(fuchsia)|(gray)|(green)|(lime)|(maroon)|(navy)|(olive)|(orange)|(purple)|(red)|(silver)|(teal)|(white)|(yellow)|(rgb\\(\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*,\\s*\\b([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\b\\s*\\))|(rgb\\(\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*,\\s*(\\d?\\d%|100%)+\\s*\\))", null));
        arrayList.add(a("ip-address", "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$", null));
        arrayList.add(a("phone", "^\\+(?:[0-9] ?){6,14}[0-9]$", null));
        arrayList.add(a("style", "\\s*(.+?):\\s*([^;]+);?", null));
        arrayList.add(a("utc-millisec", "^[0-9]+(\\.?[0-9]+)?$", null));
        f16474a = Collections.unmodifiableList(arrayList);
    }

    public static j a(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "format";
        }
        j jVar = new j();
        jVar.f16479a = str;
        jVar.f16481c = str3;
        jVar.f16480b = Pattern.compile(str2);
        VarHandle.storeStoreFence();
        return jVar;
    }
}
