package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f39782b;

    public h(String r6, Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "scheme");
        d.h.b.o.e(r8, "authParams");
        this.f39781a = r6;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        Iterator r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        Locale r3 = Locale.US;
        d.h.b.o.c(r3, "US");
        String r4 = r2.toLowerCase(r3);
        d.h.b.o.c(r4, "this as java.lang.String).toLowerCase(locale)");
    L9:
        r9.put(r4, r1);
        goto L4
    L8:
        r4 = null;
        goto L9
    L10:
        Map<String, String> r11 = Collections.unmodifiableMap(r9);
        d.h.b.o.c(r11, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f39782b = r11;
    }

    public final String a() {
        return this.f39781a;
    }

    public final String b() {
        return (String) ZeusTransformUtils.preCheckCast(this.f39782b.get("realm"), String.class, "com.obric.aiagent.plugin");
    }

    public final Charset c() {
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.f39782b.get("charset"), String.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L6:
        Charset r3 = StandardCharsets.ISO_8859_1;
        d.h.b.o.c(r3, "ISO_8859_1");
        return r3;
    L9:
        Charset r4 = Charset.forName(r2);     // Catch: Exception -> L8
        d.h.b.o.c(r4, "forName(charset)");     // Catch: Exception -> L8
        return r4;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L5;
    L9:
        return false;
    L5:
        if (d.h.b.o.a(((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f39781a, this.f39781a) == false) goto L9;
        if (d.h.b.o.a(((h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin")).f39782b, this.f39782b) == false) goto L9;
        return true;
    }

    public int hashCode() {
        return ((899 + this.f39781a.hashCode()) * 31) + this.f39782b.hashCode();
    }

    public String toString() {
        return this.f39781a + " authParams=" + this.f39782b;
    }
}
