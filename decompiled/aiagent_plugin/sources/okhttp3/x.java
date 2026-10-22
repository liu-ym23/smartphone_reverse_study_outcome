package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40220a = null;
    private static final Pattern f = null;
    private static final Pattern g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f40223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String[] f40224e;

    /* JADX INFO: compiled from: MediaType.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final x a(String r14) {
            d.h.b.o.e(r14, "<this>");
            Matcher r13 = x.c().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
            if (r13.lookingAt() == false) goto L28;
            String r3 = r13.group(1);
            d.h.b.o.c(r3, "typeSubtype.group(1)");
            Locale r4 = Locale.US;
            d.h.b.o.c(r4, "US");
            String r8 = r3.toLowerCase(r4);
            d.h.b.o.c(r8, "this as java.lang.String).toLowerCase(locale)");
            String r6 = r13.group(2);
            d.h.b.o.c(r6, "typeSubtype.group(2)");
            Locale r7 = Locale.US;
            d.h.b.o.c(r7, "US");
            String r9 = r6.toLowerCase(r7);
            d.h.b.o.c(r9, "this as java.lang.String).toLowerCase(locale)");
            List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            Matcher r10 = x.d().matcher((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"));
            int r15 = r13.end();
        L6:
            if (r15 >= r14.length()) goto L26;
            r10.region(r15, r14.length());
            if (r10.lookingAt() == false) goto L23;
            String r16 = r10.group(1);
            if (r16 == null) goto L11;
            String r11 = r10.group(2);
            if (r11 != null) goto L16;
            r11 = r10.group(3);
        L22:
            ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r16);
            ((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).add(r11);
            r15 = r10.end();
            goto L6
        L16:
            if (d.o.o.b(r11, "'", false, 2, null) == false) goto L22;
            if (d.o.o.c(r11, "'", false, 2, null) == false) goto L22;
            if (r11.length() <= 2) goto L22;
            r11 = r11.substring(1, r11.length() - 1);
            d.h.b.o.c(r11, "this as java.lang.String…ing(startIndex, endIndex)");
            goto L22
        L11:
            r15 = r10.end();
            goto L6
        L23:
            StringBuilder r0 = new StringBuilder().append("Parameter is not formatted correctly: \"");
            String r17 = r14.substring(r15);
            d.h.b.o.c(r17, "this as java.lang.String).substring(startIndex)");
            throw new IllegalArgumentException(r0.append(r17).append("\" for: \"").append(r14).append('\"').toString().toString());
        L26:
            return new x(r14, r8, r9, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"), null);
        L28:
            throw new IllegalArgumentException(("No subtype found for: \"" + r14 + '\"').toString());
        }

        public final x b(String r2) {
            d.h.b.o.e(r2, "<this>");
            return a(r2);
        L5:
            return null;
        }
    }

    public /* synthetic */ x(String r1, String r2, String r3, String[] r4, d.h.b.h r5) {
        this(r1, r2, r3, r4);
    }

    public static final x b(String r1) {
        return f40220a.a(r1);
    }

    public static final x c(String r1) {
        return f40220a.b(r1);
    }

    private x(String r1, String r2, String r3, String[] r4) {
        this.f40221b = r1;
        this.f40222c = r2;
        this.f40223d = r3;
        this.f40224e = r4;
    }

    public static final /* synthetic */ Pattern c() {
        return f;
    }

    public static final /* synthetic */ Pattern d() {
        return g;
    }

    public final String a() {
        return this.f40222c;
    }

    public final String b() {
        return this.f40223d;
    }

    public static /* synthetic */ Charset a(x r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
    }

    public final Charset a(Charset r2) {
        String r1 = a("charset");
        if (r1 != null) goto L8;
        return r2;
    L8:
        return Charset.forName(r1);
    L10:
        return r2;
    }

    public final String a(String r5) {
        d.h.b.o.e(r5, "name");
        int r1 = 0;
        int r0 = d.e.c.a(0, this.f40224e.length - 1, 2);
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (d.o.o.a(this.f40224e[r1], r5, true) == true) goto L7;
        if (r1 == r0) goto L14;
        r1 = r1 + 2;
        goto L5
    L14:
        return null;
    L7:
        return this.f40224e[r1 + 1];
    }

    public String toString() {
        return this.f40221b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, x.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin")).f40221b, this.f40221b) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f40221b.hashCode();
    }

    static {
        f40220a = new a(null);
        f = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        g = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }
}
