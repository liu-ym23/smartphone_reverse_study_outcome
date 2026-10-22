package okhttp3;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class u implements d.h.b.a.a, Iterable<d.m<? extends String, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40205a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f40206b;

    /* JADX INFO: compiled from: Headers.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f40207a;

        public a() {
            this.f40207a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(20), List.class, "com.obric.aiagent.plugin");
        }

        public final List<String> a() {
            return this.f40207a;
        }

        public final a a(String r11) {
            d.h.b.o.e(r11, "line");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            int r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), ':', 1, false, 4, null);
            if (r3 == (-1)) goto L6;
            String r6 = r11.substring(0, r3);
            d.h.b.o.c(r6, "this as java.lang.String…ing(startIndex, endIndex)");
            String r12 = r11.substring(r3 + 1);
            d.h.b.o.c(r12, "this as java.lang.String).substring(startIndex)");
            r2.b(r6, r12);
        L10:
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L6:
            if (r11.charAt(0) != ':') goto L8;
            String r13 = r11.substring(1);
            d.h.b.o.c(r13, "this as java.lang.String).substring(startIndex)");
            r2.b("", r13);
            goto L10
        L8:
            r2.b("", r11);
            goto L10
        }

        public final a a(String r5, String r6) {
            d.h.b.o.e(r5, "name");
            d.h.b.o.e(r6, "value");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            b.a(u.f40205a, r5);
            b.a(u.f40205a, r6, r5);
            r2.b(r5, r6);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(String r5, String r6) {
            d.h.b.o.e(r5, "name");
            d.h.b.o.e(r6, "value");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.f40207a.add(r5);
            r2.f40207a.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).toString());
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a b(String r7) {
            d.h.b.o.e(r7, "name");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            int r3 = 0;
        L4:
            if (r3 >= r2.f40207a.size()) goto L10;
            if (d.o.o.a(r7, (String) ZeusTransformUtils.preCheckCast(r2.f40207a.get(r3), String.class, "com.obric.aiagent.plugin"), true) == false) goto L8;
            r2.f40207a.remove(r3);
            r2.f40207a.remove(r3);
            r3 = r3 - 2;
        L8:
            r3 = r3 + 2;
            goto L4
        L10:
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a c(String r5, String r6) {
            d.h.b.o.e(r5, "name");
            d.h.b.o.e(r6, "value");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            b.a(u.f40205a, r5);
            b.a(u.f40205a, r6, r5);
            r2.b(r5);
            r2.b(r5, r6);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final String c(String r6) {
            d.h.b.o.e(r6, "name");
            int r0 = this.f40207a.size() - 2;
            int r1 = d.e.c.a(r0, 0, -2);
            if (r1 <= r0) goto L5;
            return null;
        L5:
            if (d.o.o.a(r6, (String) ZeusTransformUtils.preCheckCast(this.f40207a.get(r0), String.class, "com.obric.aiagent.plugin"), true) == true) goto L7;
            if (r0 == r1) goto L14;
            r0 = r0 - 2;
            goto L5
        L14:
            return null;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(this.f40207a.get(r0 + 1), String.class, "com.obric.aiagent.plugin");
        }

        public final u b() {
            return new u((String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(this.f40207a, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"), null);
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ String a(b r0, String[] r1, String r2) {
            return r0.a(r1, r2);
        }

        public static final /* synthetic */ void a(b r0, String r1) {
            r0.a(r1);
        }

        public static final /* synthetic */ void a(b r0, String r1, String r2) {
            r0.a(r1, r2);
        }

        private final String a(String[] r4, String r5) {
            int r3 = r4.length - 2;
            int r0 = d.e.c.a(r3, 0, -2);
            if (r0 <= r3) goto L5;
            return null;
        L5:
            if (d.o.o.a(r5, r4[r3], true) == true) goto L7;
            if (r3 == r0) goto L14;
            r3 = r3 - 2;
            goto L5
        L14:
            return null;
        L7:
            return r4[r3 + 1];
        }

        public final u a(String... r9) {
            d.h.b.o.e(r9, "namesAndValues");
            int r3 = 0;
            if ((r9.length % 2) != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L25;
            String[] r10 = (String[]) ZeusTransformUtils.preCheckCast(r9.clone(), String[].class, "com.obric.aiagent.plugin");
            int r1 = r10.length;
            int r5 = 0;
        L8:
            if (r5 >= r1) goto L17;
            if (r10[r5] == null) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == false) goto L16;
            r10[r5] = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r10[r5], CharSequence.class, "com.obric.aiagent.plugin")).toString();
            r5 = r5 + 1;
            goto L8
        L16:
            throw new IllegalArgumentException("Headers cannot be null".toString());
        L12:
            r6 = false;
            goto L13
        L17:
            int r2 = d.e.c.a(0, r10.length - 1, 2);
            if (r2 < 0) goto L23;
        L19:
            String r4 = r10[r3];
            String r7 = r10[r3 + 1];
            a(r4);
            a(r7, r4);
            if (r3 == r2) goto L23;
            r3 = r3 + 2;
        L23:
            return new u(r10, null);
        L25:
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        L5:
            r0 = false;
            goto L6
        }

        public final u a(Map<String, String> r7) {
            Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, "<this>");
            String[] r0 = new String[r8.size() * 2];
            Iterator r9 = r8.entrySet().iterator();
            int r2 = 0;
        L4:
            if (r9.hasNext() == false) goto L7;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin");
            String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            a(r6);
            a(r10, r6);
            r0[r2] = r6;
            r0[r2 + 1] = r10;
            r2 = r2 + 2;
            goto L4
        L7:
            return new u(r0, null);
        }

        private final void a(String r6) {
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L21;
            int r7 = r6.length();
            int r2 = 0;
        L8:
            if (r2 >= r7) goto L19;
            char r3 = r6.charAt(r2);
            if ('!' <= r3) goto L12;
        L14:
            boolean r4 = false;
        L15:
            if (r4 == false) goto L18;
            r2 = r2 + 1;
            goto L8
        L18:
            throw new IllegalArgumentException(okhttp3.internal.c.a("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r6}).toString());
        L12:
            if (r3 >= 127) goto L14;
            r4 = true;
            goto L15
        L19:
            return;
        L21:
            throw new IllegalArgumentException("name is empty".toString());
        L5:
            r5 = false;
            goto L6
        }

        private final void a(String r6, String r7) {
            int r5 = r6.length();
            int r1 = 0;
        L3:
            if (r1 >= r5) goto L24;
            char r2 = r6.charAt(r1);
            if (r2 != '\t') goto L7;
        L15:
            boolean r3 = true;
        L16:
            if (r3 == false) goto L17;
            r1 = r1 + 1;
            goto L3
        L17:
            StringBuilder r8 = new StringBuilder().append(okhttp3.internal.c.a("Unexpected char %#04x at %d in %s value", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1), r7}));
            if (okhttp3.internal.c.c(r7) == false) goto L20;
            String r9 = "";
        L22:
            throw new IllegalArgumentException(r8.append(r9).toString().toString());
        L20:
            r9 = ": " + r6;
            goto L22
        L7:
            if (' ' <= r2) goto L9;
        L11:
            boolean r4 = false;
        L12:
            if (r4 == true) goto L15;
            r3 = false;
            goto L16
        L9:
            if (r2 >= 127) goto L11;
            r4 = true;
            goto L12
        }
    }

    static {
        f40205a = new b(null);
    }

    public /* synthetic */ u(String[] r1, d.h.b.h r2) {
        this(r1);
    }

    public static final u a(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return f40205a.a(r3);
    }

    public static final u a(String... r1) {
        return f40205a.a(r1);
    }

    private u(String[] r1) {
        this.f40206b = r1;
    }

    public final String a(String r2) {
        d.h.b.o.e(r2, "name");
        return b.a(f40205a, this.f40206b, r2);
    }

    public final int a() {
        return this.f40206b.length / 2;
    }

    public final String a(int r1) {
        return this.f40206b[r1 * 2];
    }

    public final String b(int r1) {
        return this.f40206b[(r1 * 2) + 1];
    }

    public final Set<String> b() {
        TreeSet r0 = new TreeSet(d.o.o.a(d.h.b.ad.f38485a));
        int r1 = a();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(a(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Set<String> r4 = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r4, "unmodifiableSet(result)");
        return r4;
    }

    public final List<String> b(String r6) {
        d.h.b.o.e(r6, "name");
        int r0 = a();
        List r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        if (d.o.o.a(r6, a(r2), true) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.aiagent.plugin");
    L8:
        r1.add(b(r2));
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r1 == null) goto L13;
        List<String> r5 = Collections.unmodifiableList(r1);
        d.h.b.o.c(r5, "{\n      Collections.unmodifiableList(result)\n    }");
        return r5;
    L13:
        return d.a.p.b();
    }

    public final long c() {
        String[] r0 = this.f40206b;
        long r1 = r0.length * 2;
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = r1 + ((long) this.f40206b[r3].length());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // java.lang.Iterable
    public Iterator<d.m<? extends String, ? extends String>> iterator() {
        int r0 = a();
        d.m[] r1 = new d.m[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = d.s.a(a(r2), b(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return d.h.b.c.a(r1);
    }

    public final a d() {
        a r0 = new a();
        d.a.p.a((Collection) ZeusTransformUtils.preCheckCast(r0.a(), Collection.class, "com.obric.aiagent.plugin"), this.f40206b);
        return r0;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, u.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.f40206b, ((u) ZeusTransformUtils.preCheckCast(r3, u.class, "com.obric.aiagent.plugin")).f40206b) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f40206b);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = a();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = a(r2);
        String r4 = b(r2);
        r0.append(r3);
        r0.append(": ");
        if (okhttp3.internal.c.c(r3) == false) goto L7;
        r4 = "██";
    L7:
        r0.append(r4);
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L8:
        String r6 = r0.toString();
        d.h.b.o.c(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }

    public final Map<String, List<String>> e() {
        TreeMap r0 = new TreeMap(d.o.o.a(d.h.b.ad.f38485a));
        int r1 = a();
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L10;
        String r4 = a(r2);
        Locale r5 = Locale.US;
        d.h.b.o.c(r5, "US");
        String r6 = r4.toLowerCase(r5);
        d.h.b.o.c(r6, "this as java.lang.String).toLowerCase(locale)");
        List r7 = (List) ZeusTransformUtils.preCheckCast(r0.get(r6), List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L8;
        r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(2), List.class, "com.obric.aiagent.plugin");
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin")).put(r6, r7);
    L8:
        r7.add(b(r2));
        r2 = r2 + 1;
        goto L4
    L10:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }
}
