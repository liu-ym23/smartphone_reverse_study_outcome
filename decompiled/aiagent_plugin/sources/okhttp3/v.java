package okhttp3;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40208a = null;
    private static final char[] l = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f40211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f40212e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;
    private final boolean k;

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C1092a f40213a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f40214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f40215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f40216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f40217e;
        private int f;
        private final List<String> g;
        private List<String> h;
        private String i;

        /* JADX INFO: renamed from: okhttp3.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.kt */
        public static final class C1092a {
            public /* synthetic */ C1092a(d.h.b.h r1) {
                this();
            }

            private C1092a() {
            }

            public static final /* synthetic */ int a(C1092a r0, String r1, int r2, int r3) {
                return r0.a(r1, r2, r3);
            }

            public static final /* synthetic */ int b(C1092a r0, String r1, int r2, int r3) {
                return r0.b(r1, r2, r3);
            }

            public static final /* synthetic */ int c(C1092a r0, String r1, int r2, int r3) {
                return r0.c(r1, r2, r3);
            }

            public static final /* synthetic */ int d(C1092a r0, String r1, int r2, int r3) {
                return r0.d(r1, r2, r3);
            }

            private final int a(String r8, int r9, int r10) {
                if ((r10 - r9) >= 2) goto L5;
                return -1;
            L5:
                char r7 = r8.charAt(r9);
                if (d.h.b.o.a(r7, 97) < 0) goto L10;
                if (d.h.b.o.a(r7, 122) > 0) goto L10;
            L14:
                int r11 = r9 + 1;
            L15:
                if (r11 >= r10) goto L59;
                char r2 = r8.charAt(r11);
                boolean r4 = false;
                if ('a' <= r2) goto L19;
            L21:
                boolean r5 = false;
            L22:
                if (r5 == false) goto L24;
            L23:
                boolean r6 = true;
            L30:
                if (r6 == false) goto L33;
            L31:
                boolean r12 = true;
            L37:
                if (r12 == false) goto L40;
            L38:
                boolean r13 = true;
            L43:
                if (r13 == false) goto L46;
            L44:
                boolean r14 = true;
            L49:
                if (r14 == false) goto L52;
            L50:
                r4 = true;
            L54:
                if (r4 == false) goto L55;
                r11 = r11 + 1;
                goto L15
            L55:
                if (r2 == ':') goto L57;
                return -1;
            L57:
                return r11;
            L52:
                if (r2 != '.') goto L54;
            L46:
                if (r2 == '-') goto L44;
                r14 = false;
                goto L49
            L40:
                if (r2 == '+') goto L38;
                r13 = false;
                goto L43
            L33:
                if ('0' > r2) goto L36;
                if (r2 < ':') goto L31;
            L36:
                r12 = false;
                goto L37
            L24:
                if ('A' <= r2) goto L26;
            L28:
                r6 = false;
                goto L30
            L26:
                if (r2 >= '[') goto L28;
            L19:
                if (r2 >= '{') goto L21;
                r5 = true;
            L59:
                return -1;
            L10:
                if (d.h.b.o.a(r7, 65) < 0) goto L59;
                if (d.h.b.o.a(r7, 90) <= 0) goto L14;
                goto L14
            }

            private final int b(String r3, int r4, int r5) {
                int r2 = 0;
            L3:
                if (r4 >= r5) goto L9;
                char r0 = r3.charAt(r4);
                if (r0 == '\\') goto L8;
                if (r0 != '/') goto L9;
            L8:
                r2 = r2 + 1;
                r4 = r4 + 1;
            L9:
                return r2;
            }

            private final int c(String r2, int r3, int r4) {
            L2:
                if (r3 >= r4) goto L14;
                char r1 = r2.charAt(r3);
                if (r1 != '[') goto L11;
            L5:
                r3 = r3 + 1;
                if (r3 >= r4) goto L13;
                if (r2.charAt(r3) != ']') goto L5;
            L13:
                r3 = r3 + 1;
                goto L2
            L11:
                if (r1 != ':') goto L13;
                return r3;
            L14:
                return r4;
            }

            private final int d(String r13, int r14, int r15) {
                int r16 = Integer.parseInt(b.a(v.f40208a, r13, r14, r15, "", false, false, false, false, null, 248, null));     // Catch: NumberFormatException -> L12
                boolean r17 = false;
                if (1 <= r16) goto L7;
            L9:
                if (r17 == true) goto L11;
                return -1;
            L11:
                return r16;
            L7:
                if (r16 >= 65536) goto L9;
                r17 = true;
            L16:
                return -1;
            }
        }

        static {
            f40213a = new C1092a(null);
        }

        public a() {
            this.f40215c = "";
            this.f40216d = "";
            this.f = -1;
            List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.g = r1;
            r1.add("");
        }

        public final void a(String r1) {
            this.f40214b = r1;
        }

        public final void b(String r2) {
            d.h.b.o.e(r2, "<set-?>");
            this.f40215c = r2;
        }

        public final void c(String r2) {
            d.h.b.o.e(r2, "<set-?>");
            this.f40216d = r2;
        }

        public final void d(String r1) {
            this.f40217e = r1;
        }

        public final void a(int r1) {
            this.f = r1;
        }

        public final List<String> a() {
            return this.g;
        }

        public final void e(String r1) {
            this.i = r1;
        }

        public final a f(String r7) {
            d.h.b.o.e(r7, "scheme");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.o.o.a(r7, "http", true) == false) goto L6;
            r2.f40214b = "http";
        L9:
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L6:
            if (d.o.o.a(r7, "https", true) == false) goto L11;
            r2.f40214b = "https";
            goto L9
        L11:
            throw new IllegalArgumentException("unexpected scheme: " + r7);
        }

        public final a g(String r17) {
            d.h.b.o.e(r17, "username");
            a r15 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r15.f40215c = b.a(v.f40208a, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a h(String r17) {
            d.h.b.o.e(r17, SensitiveType.PASSWORD);
            a r15 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r15.f40216d = b.a(v.f40208a, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a i(String r11) {
            d.h.b.o.e(r11, "host");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            String r3 = okhttp3.internal.a.a(b.a(v.f40208a, r11, 0, 0, false, 7, null));
            if (r3 == null) goto L7;
            r2.f40217e = r3;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalArgumentException("unexpected host: " + r11);
        }

        public final a b(int r7) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            boolean r3 = false;
            if (1 <= r7) goto L5;
        L7:
            if (r3 == false) goto L11;
            r2.f = r7;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L11:
            throw new IllegalArgumentException(("unexpected port: " + r7).toString());
        L5:
            if (r7 >= 65536) goto L7;
            r3 = true;
            goto L7
        }

        private final int d() {
            int r0 = this.f;
            if (r0 != (-1)) goto L7;
            b r1 = v.f40208a;
            String r2 = this.f40214b;
            d.h.b.o.a(r2);
            return r1.a(r2);
        L7:
            return r0;
        }

        public final a query(String r17) {
            a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L7;
            String r4 = b.a(v.f40208a, r17, 0, 0, " \"'<>#", false, false, true, false, null, 219, null);
            if (r4 == null) goto L7;
            List<String> r5 = v.f40208a.b(r4);
        L8:
            r3.h = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L7:
            r5 = null;
            goto L8
        }

        public final a j(String r17) {
            a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L7;
            String r4 = b.a(v.f40208a, r17, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
            if (r4 == null) goto L7;
            List<String> r5 = v.f40208a.b(r4);
        L8:
            r3.h = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L7:
            r5 = null;
            goto L8
        }

        public final a a(String r18, String r19) {
            d.h.b.o.e(r18, "name");
            a r15 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r15.h != null) goto L5;
            r15.h = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        L5:
            List<String> r14 = r15.h;
            d.h.b.o.a(r14);
            r14.add(b.a(v.f40208a, r18, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> r0 = r15.h;
            d.h.b.o.a(r0);
            if (r19 == null) goto L8;
            String r3 = b.a(v.f40208a, r19, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null);
        L9:
            r0.add(r3);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L8:
            r3 = null;
            goto L9
        }

        public final a b() {
            a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            String r4 = r3.f40217e;
            String r5 = null;
            if (r4 == null) goto L5;
            String r6 = new d.o.k("[\"<>^`{|}]").a((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), "");
        L6:
            r3.f40217e = r6;
            int r7 = r3.g.size();
            int r8 = 0;
            int r9 = 0;
        L7:
            if (r9 >= r7) goto L9;
            r3.g.set(r9, b.a(v.f40208a, (String) ZeusTransformUtils.preCheckCast(r3.g.get(r9), String.class, "com.obric.aiagent.plugin"), 0, 0, "[]", true, true, false, false, null, 227, null));
            r9 = r9 + 1;
            goto L7
        L9:
            List<String> r10 = r3.h;
            if (r10 == null) goto L18;
            int r11 = r10.size();
        L12:
            if (r8 >= r11) goto L18;
            String r12 = (String) ZeusTransformUtils.preCheckCast(r10.get(r8), String.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L16;
            String r13 = b.a(v.f40208a, r12, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null);
        L17:
            r10.set(r8, r13);
            r8 = r8 + 1;
            goto L12
        L16:
            r13 = null;
        L18:
            String r14 = r3.i;
            if (r14 == null) goto L21;
            r5 = b.a(v.f40208a, r14, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null);
        L21:
            r3.i = r5;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L5:
            r6 = null;
            goto L6
        }

        public final v c() {
            String r1 = this.f40214b;
            if (r1 == null) goto L31;
            String r2 = b.a(v.f40208a, this.f40215c, 0, 0, false, 7, null);
            String r3 = b.a(v.f40208a, this.f40216d, 0, 0, false, 7, null);
            String r4 = this.f40217e;
            if (r4 == null) goto L29;
            int r5 = d();
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.g, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r7.add(b.a(v.f40208a, (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), 0, 0, false, 7, null));
            goto L8
        L10:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
            List<String> r10 = this.h;
            if (r10 == null) goto L21;
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r13 = r11.iterator();
        L14:
            if (r13.hasNext() == false) goto L20;
            String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L18;
            String r15 = b.a(v.f40208a, r14, 0, 0, true, 3, null);
        L19:
            r12.add(r15);
            goto L14
        L18:
            r15 = null;
            goto L19
        L20:
            List r16 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");
        L22:
            String r17 = this.i;
            if (r17 == null) goto L25;
            String r18 = b.a(v.f40208a, r17, 0, 0, false, 7, null);
        L27:
            return new v(r1, r2, r3, r4, r5, r9, r16, r18, toString());
        L25:
            r18 = null;
            goto L27
        L21:
            r16 = null;
            goto L22
        L29:
            throw new IllegalStateException("host == null");
        L31:
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.f40214b;
            if (r1 == null) goto L5;
            r0.append(r1);
            r0.append("://");
        L6:
            boolean r2 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f40215c, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
            boolean r3 = true;
        L11:
            if (r3 == false) goto L13;
        L17:
            r0.append(this.f40215c);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f40216d, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L21;
            r2 = false;
        L21:
            if (r2 == false) goto L23;
            r0.append(':');
            r0.append(this.f40216d);
        L23:
            r0.append('@');
        L24:
            String r4 = this.f40217e;
            if (r4 == null) goto L31;
            d.h.b.o.a(r4);
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), ':', false, 2, null) == false) goto L29;
            r0.append('[');
            r0.append(this.f40217e);
            r0.append(']');
            goto L31
        L29:
            r0.append(this.f40217e);
        L31:
            if (this.f == (-1)) goto L33;
        L34:
            int r5 = d();
            if (this.f40214b == null) goto L38;
            b r6 = v.f40208a;
            String r7 = this.f40214b;
            d.h.b.o.a(r7);
            if (r5 != r6.a(r7)) goto L38;
        L39:
            v.f40208a.a(this.g, r0);
            if (this.h == null) goto L43;
            r0.append('?');
            b r8 = v.f40208a;
            List<String> r9 = this.h;
            d.h.b.o.a(r9);
            r8.b(r9, r0);
        L43:
            if (this.i == null) goto L45;
            r0.append('#');
            r0.append(this.i);
        L45:
            String r10 = r0.toString();
            d.h.b.o.c(r10, "StringBuilder().apply(builderAction).toString()");
            return r10;
        L38:
            r0.append(':');
            r0.append(r5);
            goto L39
        L33:
            if (this.f40214b == null) goto L39;
        L13:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f40216d, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
            boolean r11 = true;
        L16:
            if (r11 == false) goto L24;
        L15:
            r11 = false;
            goto L16
        L9:
            r3 = false;
            goto L11
        L5:
            r0.append("//");
            goto L6
        }

        public final a a(v r30, String r31) {
            String r13 = r31;
            d.h.b.o.e(r13, "input");
            int r1 = okhttp3.internal.c.a(r13, 0, 0, 3, null);
            int r15 = okhttp3.internal.c.b(r13, r1, 0, 2, null);
            C1092a r2 = f40213a;
            int r4 = C1092a.a(r2, r13, r1, r15);
            String r12 = "this as java.lang.String…ing(startIndex, endIndex)";
            byte r11 = -1;
            boolean r10 = true;
            if (r4 != (-1)) goto L5;
            if (r30 == null) goto L83;
            this.f40214b = r30.a();
        L14:
            int r3 = C1092a.b(r2, r13, r1, r15);
            byte r9 = 63;
            byte r8 = 35;
            if (r3 >= 2) goto L26;
            if (r30 == null) goto L26;
            if (d.h.b.o.a(r30.a(), this.f40214b) == false) goto L26;
            this.f40215c = r30.g();
            this.f40216d = r30.h();
            this.f40217e = r30.b();
            this.f = r30.c();
            this.g.clear();
            this.g.addAll((Collection) ZeusTransformUtils.preCheckCast(r30.j(), Collection.class, "com.obric.aiagent.plugin"));
            if (r1 != r15) goto L23;
        L24:
            j(r30.k());
        L25:
            int r19 = r15;
        L70:
            int r14 = r19;
            int r5 = okhttp3.internal.c.a(r13, "?#", r1, r14);
            a(r13, r1, r5);
            if (r5 < r14) goto L73;
        L75:
            if (r5 < r14) goto L77;
        L79:
            return this;
        L77:
            if (r13.charAt(r5) != '#') goto L79;
            this.i = b.a(v.f40208a, r31, r5 + 1, r14, "", true, false, false, true, null, 176, null);
            goto L79
        L73:
            if (r13.charAt(r5) != '?') goto L75;
            int r16 = okhttp3.internal.c.a(r13, '#', r5, r14);
            this.h = v.f40208a.b(b.a(v.f40208a, r31, r5 + 1, r16, " \"'<>#", true, false, true, false, null, 208, null));
            r5 = r16;
            goto L75
        L23:
            if (r13.charAt(r1) != '#') goto L25;
        L26:
            int r7 = r1 + r3;
            boolean r17 = false;
            boolean r18 = false;
        L27:
            int r6 = okhttp3.internal.c.a(r13, "@/\\?#", r7, r15);
            if (r6 == r15) goto L30;
            byte r20 = r13.charAt(r6);
        L31:
            if (r20 == r11) goto L53;
            if (r20 == r8) goto L53;
            if (r20 == 47) goto L53;
            if (r20 == 92) goto L53;
            if (r20 == r9) goto L53;
            if (r20 != 64) goto L27;
            if (r17 == true) goto L51;
            int r21 = okhttp3.internal.c.a(r13, ':', r7, r6);
            boolean r110 = r10;
            String r111 = r12;
            String r22 = b.a(v.f40208a, r31, r7, r21, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            if (r18 == false) goto L46;
            r22 = this.f40215c + "%40" + r22;
        L46:
            this.f40215c = r22;
            if (r21 == r6) goto L49;
            this.f40216d = b.a(v.f40208a, r31, r21 + 1, r6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            boolean r112 = r110;
        L50:
            r17 = r112;
            String r23 = r111;
            r18 = r110;
            int r113 = r6;
        L52:
            r7 = r113 + 1;
            r10 = r110;
            r15 = r15;
            r12 = r23;
            r8 = 35;
            r9 = 63;
            r11 = -1;
            goto L27
        L49:
            r112 = r17;
            goto L50
        L51:
            r110 = r10;
            r23 = r12;
            r113 = r6;
            this.f40216d += "%40" + b.a(v.f40208a, r31, r7, r6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
        L53:
            boolean r114 = r10;
            String r24 = r12;
            r19 = r15;
            C1092a r25 = f40213a;
            int r26 = C1092a.c(r25, r13, r7, r6);
            int r115 = r26 + 1;
            if (r115 >= r6) goto L63;
            int r116 = r7;
            this.f40217e = okhttp3.internal.a.a(b.a(v.f40208a, r31, r7, r26, false, 4, null));
            int r27 = C1092a.d(r25, r13, r115, r6);
            this.f = r27;
            if (r27 == (-1)) goto L58;
            boolean r28 = r114;
        L59:
            if (r28 == true) goto L65;
            StringBuilder r0 = new StringBuilder().append("Invalid URL port: \"");
            String r29 = r13.substring(r115, r6);
            d.h.b.o.c(r29, r24);
            throw new IllegalArgumentException(r0.append(r29).append('\"').toString().toString());
        L65:
            if (this.f40217e == null) goto L67;
            boolean r210 = r114;
        L68:
            if (r210 == false) goto L80;
            r1 = r6;
            goto L70
        L80:
            StringBuilder r32 = new StringBuilder().append("Invalid URL host: \"");
            String r33 = r13.substring(r116, r26);
            d.h.b.o.c(r33, r24);
            throw new IllegalArgumentException(r32.append(r33).append('\"').toString().toString());
        L67:
            r210 = false;
            goto L68
        L58:
            r28 = false;
            goto L59
        L63:
            r116 = r7;
            this.f40217e = okhttp3.internal.a.a(b.a(v.f40208a, r31, r116, r26, false, 4, null));
            b r34 = v.f40208a;
            String r35 = this.f40214b;
            d.h.b.o.a(r35);
            this.f = r34.a(r35);
            goto L65
        L30:
            r20 = r11;
            goto L31
        L83:
            if (r31.length() <= 6) goto L86;
            r13 = d.o.o.e(r13, 6) + "...";
        L86:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + r13);
        L5:
            if (d.o.o.a(r13, "https:", r1, true) == false) goto L8;
            this.f40214b = "https";
            r1 = r1 + 6;
            goto L14
        L8:
            if (d.o.o.a(r13, "http:", r1, true) == false) goto L10;
            this.f40214b = "http";
            r1 = r1 + 5;
            goto L14
        L10:
            StringBuilder r36 = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
            String r37 = r13.substring(0, r4);
            d.h.b.o.c(r37, "this as java.lang.String…ing(startIndex, endIndex)");
            throw new IllegalArgumentException(r36.append(r37).append('\'').toString());
        }

        private final void a(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r0 = r11.charAt(r12);
            if (r0 != '/') goto L7;
        L10:
            this.g.clear();
            this.g.add("");
            r12 = r12 + 1;
        L11:
            int r6 = r12;
        L12:
            if (r6 >= r13) goto L20;
            r12 = okhttp3.internal.c.a(r11, "/\\", r6, r13);
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            a(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r6 = r12 + 1;
            goto L12
        L16:
            r1 = false;
            goto L17
        L20:
            return;
        L7:
            if (r0 == '\\') goto L10;
            List<String> r2 = this.g;
            r2.set(r2.size() - 1, "");
            goto L11
        }

        private final void a(String r14, int r15, int r16, boolean r17, boolean r18) {
            String r1 = b.a(v.f40208a, r14, r15, r16, " \"<>^`{}|/\\?#", r18, false, false, false, null, 240, null);
            if (k(r1) == false) goto L6;
            return;
        L6:
            if (l(r1) == false) goto L9;
            e();
            return;
        L9:
            List<String> r2 = this.g;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            List<String> r4 = this.g;
            r4.set(r4.size() - 1, r1);
        L16:
            if (r17 == false) goto L19;
            this.g.add("");
            return;
        L19:
            return;
        L15:
            this.g.add(r1);
            goto L16
        L12:
            r3 = false;
            goto L13
        }

        private final boolean k(String r2) {
            if (d.h.b.o.a(r2, ".") == false) goto L5;
            return true;
        L5:
            if (d.o.o.a(r2, "%2e", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        private final boolean l(String r2) {
            if (d.h.b.o.a(r2, DownloadConstants.VULNERABILITY_PATH) == false) goto L5;
            return true;
        L5:
            if (d.o.o.a(r2, "%2e.", true) == false) goto L7;
            return true;
        L7:
            if (d.o.o.a(r2, ".%2e", true) == false) goto L9;
            return true;
        L9:
            if (d.o.o.a(r2, "%2e%2e", true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private final void e() {
            List<String> r0 = this.g;
            if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0.remove(r0.size() - 1), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L9;
        L11:
            this.g.add("");
            return;
        L9:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.g, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L11;
            List<String> r5 = this.g;
            r5.set(r5.size() - 1, "");
            return;
        L5:
            r1 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final int a(String r1) {
            d.h.b.o.e(r1, "scheme");
            if (d.h.b.o.a(r1, "http") == false) goto L6;
            return 80;
        L6:
            if (d.h.b.o.a(r1, "https") == false) goto L8;
            return 443;
        L8:
            return -1;
        }

        public final void a(List<String> r5, StringBuilder r6) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "<this>");
            d.h.b.o.e(r6, "out");
            int r7 = r4.size();
            int r1 = 0;
        L3:
            if (r1 >= r7) goto L5;
            r6.append('/');
            r6.append((String) ZeusTransformUtils.preCheckCast(r4.get(r1), String.class, "com.obric.aiagent.plugin"));
            r1 = r1 + 1;
            goto L3
        }

        public final void b(List<String> r7, StringBuilder r8) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "<this>");
            d.h.b.o.e(r8, "out");
            d.l.h r9 = d.l.n.a((d.l.h) ZeusTransformUtils.preCheckCast(d.l.n.b(0, r6.size()), d.l.h.class, "com.obric.aiagent.plugin"), 2);
            int r1 = r9.a();
            int r2 = r9.b();
            int r10 = r9.c();
            if (r10 <= 0) goto L5;
            if (r1 > r2) goto L5;
        L7:
            String r3 = (String) ZeusTransformUtils.preCheckCast(r6.get(r1), String.class, "com.obric.aiagent.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r6.get(r1 + 1), String.class, "com.obric.aiagent.plugin");
            if (r1 <= 0) goto L10;
            r8.append('&');
        L10:
            r8.append(r3);
            if (r4 == null) goto L13;
            r8.append('=');
            r8.append(r4);
        L13:
            if (r1 == r2) goto L19;
            r1 = r1 + r10;
            goto L7
        L19:
            return;
        L5:
            if (r10 >= 0) goto L15;
            if (r2 <= r1) goto L7;
            return;
        }

        public final List<String> b(String r11) {
            d.h.b.o.e(r11, "<this>");
            List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            int r0 = 0;
        L4:
            if (r0 > r11.length()) goto L15;
            int r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), '&', r0, false, 4, null);
            if (r2 != (-1)) goto L8;
            r2 = r11.length();
        L8:
            int r9 = r2;
            int r3 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"), '=', r0, false, 4, null);
            if (r3 == (-1)) goto L13;
            if (r3 > r9) goto L13;
            String r1 = r11.substring(r0, r3);
            d.h.b.o.c(r1, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r1);
            String r4 = r11.substring(r3 + 1, r9);
            d.h.b.o.c(r4, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r4);
        L14:
            r0 = r9 + 1;
        L13:
            String r5 = r11.substring(r0, r9);
            d.h.b.o.c(r5, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r5);
            r10.add(null);
            goto L14
        L15:
            return r10;
        }

        public final v c(String r2) {
            d.h.b.o.e(r2, "<this>");
            return new a().a(null, r2).c();
        }

        public final v d(String r2) {
            d.h.b.o.e(r2, "<this>");
            return c(r2);
        L5:
            return null;
        }

        public static /* synthetic */ String a(b r1, String r2, int r3, int r4, boolean r5, int r6, Object r7) {
            if ((r6 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = r2.length();
        L9:
            if ((r6 & 4) == 0) goto L12;
            r5 = false;
        L12:
            return r1.a(r2, r3, r4, r5);
        }

        public final String a(String r8, int r9, int r10, boolean r11) {
            d.h.b.o.e(r8, "<this>");
            int r4 = r9;
        L3:
            if (r4 >= r10) goto L13;
            char r0 = r8.charAt(r4);
            if (r0 == '%') goto L11;
            if (r0 != '+') goto L10;
            if (r11 == true) goto L11;
        L10:
            r4 = r4 + 1;
        L11:
            e.e r1 = new e.e();
            r1.a(r8, r9, r4);
            a(r1, r8, r4, r10, r11);
            return r1.u();
        L13:
            String r7 = r8.substring(r9, r10);
            d.h.b.o.c(r7, "this as java.lang.String…ing(startIndex, endIndex)");
            return r7;
        }

        private final void a(e.e r5, String r6, int r7, int r8, boolean r9) {
        L2:
            if (r7 >= r8) goto L16;
            int r4 = r6.codePointAt(r7);
            if (r4 != 37) goto L12;
            int r0 = r7 + 2;
            if (r0 >= r8) goto L12;
            int r1 = okhttp3.internal.c.a(r6.charAt(r7 + 1));
            int r2 = okhttp3.internal.c.a(r6.charAt(r0));
            if (r1 == (-1)) goto L15;
            if (r2 == (-1)) goto L15;
            r5.b((r1 << 4) + r2);
            r7 = r0 + Character.charCount(r4);
        L15:
            r5.a(r4);
            r7 = r7 + Character.charCount(r4);
        L12:
            if (r4 != 43) goto L15;
            if (r9 == false) goto L15;
            r5.b(32);
            r7 = r7 + 1;
            goto L2
        }

        private final boolean a(String r3, int r4, int r5) {
            int r2 = r4 + 2;
            if (r2 < r5) goto L5;
        L11:
            return false;
        L5:
            if (r3.charAt(r4) != '%') goto L11;
            if (okhttp3.internal.c.a(r3.charAt(r4 + 1)) == (-1)) goto L11;
            if (okhttp3.internal.c.a(r3.charAt(r2)) == (-1)) goto L11;
            return true;
        }

        public static /* synthetic */ String a(b r13, String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22, int r23, Object r24) {
            if ((r23 & 1) == 0) goto L5;
            int r5 = 0;
        L7:
            if ((r23 & 2) == 0) goto L9;
            int r6 = r14.length();
        L11:
            if ((r23 & 8) == 0) goto L13;
            boolean r8 = false;
        L15:
            if ((r23 & 16) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r23 & 32) == 0) goto L21;
            boolean r10 = false;
        L23:
            if ((r23 & 64) == 0) goto L25;
            boolean r11 = false;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Charset r12 = null;
        L31:
            return r13.a(r14, r5, r6, r17, r8, r9, r10, r11, r12);
        L29:
            r12 = r22;
            goto L31
        L25:
            r11 = r21;
            goto L27
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }

        public final String a(String r13, int r14, int r15, String r16, boolean r17, boolean r18, boolean r19, boolean r20, Charset r21) {
            d.h.b.o.e(r13, "<this>");
            d.h.b.o.e(r16, "encodeSet");
            int r3 = r14;
        L3:
            if (r3 >= r15) goto L29;
            int r0 = r13.codePointAt(r3);
            if (r0 < 32) goto L27;
            if (r0 == 127) goto L27;
            if (r0 < 128) goto L12;
            if (r20 == false) goto L27;
        L12:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"), (char) r0, false, 2, null) == true) goto L27;
            if (r0 != 37) goto L22;
            if (r17 == false) goto L27;
            if (r18 == false) goto L22;
            if (a(r13, r3, r15) == false) goto L27;
        L22:
            if (r0 != 43) goto L25;
            if (r19 == true) goto L27;
        L25:
            r3 = r3 + Character.charCount(r0);
        L27:
            e.e r11 = new e.e();
            r11.a(r13, r14, r3);
            a(r11, r13, r3, r15, r16, r17, r18, r19, r20, r21);
            return r11.u();
        L29:
            String r1 = r13.substring(r14, r15);
            d.h.b.o.c(r1, "this as java.lang.String…ing(startIndex, endIndex)");
            return r1;
        }

        private final void a(e.e r15, String r16, int r17, int r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, Charset r24) {
            int r5 = r17;
            e.e r6 = null;
        L3:
            if (r5 >= r18) goto L53;
            int r7 = r16.codePointAt(r5);
            if (r20 == false) goto L16;
            if (r7 == 9) goto L52;
            if (r7 == 10) goto L52;
            if (r7 == 12) goto L52;
            if (r7 != 13) goto L16;
        L52:
            r5 = r5 + Character.charCount(r7);
        L16:
            if (r7 != 43) goto L23;
            if (r22 == false) goto L23;
            if (r20 == false) goto L20;
            String r8 = "+";
        L21:
            r15.a(r8);
            goto L52
        L20:
            r8 = "%2B";
        L23:
            if (r7 < 32) goto L41;
            if (r7 == 127) goto L41;
            if (r7 < 128) goto L30;
            if (r23 == false) goto L41;
        L30:
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r19, CharSequence.class, "com.obric.aiagent.plugin"), (char) r7, false, 2, null) == true) goto L41;
            if (r7 != 37) goto L38;
            if (r20 == false) goto L41;
            if (r21 == false) goto L38;
            if (a(r16, r5, r18) == false) goto L41;
        L38:
            r15.a(r7);
        L41:
            if (r6 != null) goto L43;
            r6 = new e.e();
        L43:
            if (r24 != null) goto L45;
        L48:
            r6.a(r7);
        L50:
            if (r6.h() == true) goto L52;
            int r10 = r6.k() & 255;
            r15.b(37);
            r15.b(v.o()[(r10 >> 4) & 15]);
            r15.b(v.o()[r10 & 15]);
            goto L50
        L45:
            if (d.h.b.o.a(r24, StandardCharsets.UTF_8) == true) goto L48;
            r6.a(r16, r5, Character.charCount(r7) + r5, r24);
            goto L50
        }
    }

    public static final v c(String r1) {
        return f40208a.d(r1);
    }

    public v(String r3, String r4, String r5, String r6, int r7, List<String> r8, List<String> r9, String r10, String r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "scheme");
        d.h.b.o.e(r4, "username");
        d.h.b.o.e(r5, SensitiveType.PASSWORD);
        d.h.b.o.e(r6, "host");
        d.h.b.o.e(r12, "pathSegments");
        d.h.b.o.e(r11, "url");
        this.f40209b = r3;
        this.f40210c = r4;
        this.f40211d = r5;
        this.f40212e = r6;
        this.f = r7;
        this.g = r12;
        this.h = r13;
        this.i = r10;
        this.j = r11;
        this.k = d.h.b.o.a(r3, "https");
    }

    public static final /* synthetic */ char[] o() {
        return l;
    }

    public final String a() {
        return this.f40209b;
    }

    public final String b() {
        return this.f40212e;
    }

    public final int c() {
        return this.f;
    }

    public final boolean d() {
        return this.k;
    }

    public final URL e() {
        return new URL(this.j);
    L4:
        e = move-exception;
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final URI f() {
        String r4 = n().b().toString();
        return new URI(r4);
    L5:
        e = move-exception;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L9
        URI r1 = URI.create(new d.o.k("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").a(r5, ""));     // Catch: Exception -> L9
        d.h.b.o.c(r1, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
        return r1;
    L10:
        throw new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final String g() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f40210c, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r1 = this.f40209b.length() + 3;
        String r2 = this.j;
        int r3 = okhttp3.internal.c.a(r2, ":@", r1, r2.length());
        String r4 = this.j.substring(r1, r3);
        d.h.b.o.c(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public final String h() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f40211d, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        String r9 = this.j.substring(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), ':', this.f40209b.length() + 3, false, 4, null) + 1, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), '@', 0, false, 6, null));
        d.h.b.o.c(r9, "this as java.lang.String…ing(startIndex, endIndex)");
        return r9;
    L5:
        r0 = false;
        goto L6
    }

    public final String i() {
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), '/', this.f40209b.length() + 3, false, 4, null);
        String r1 = this.j;
        int r2 = okhttp3.internal.c.a(r1, "?#", r0, r1.length());
        String r7 = this.j.substring(r0, r2);
        d.h.b.o.c(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        return r7;
    }

    public final List<String> j() {
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), '/', this.f40209b.length() + 3, false, 4, null);
        String r1 = this.j;
        int r2 = okhttp3.internal.c.a(r1, "?#", r0, r1.length());
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    L3:
        if (r0 >= r2) goto L5;
        int r4 = r0 + 1;
        int r5 = okhttp3.internal.c.a(this.j, '/', r4, r2);
        String r6 = this.j.substring(r4, r5);
        d.h.b.o.c(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        r3.add(r6);
        r0 = r5;
        goto L3
    L5:
        return r3;
    }

    public final String k() {
        if (this.h != null) goto L6;
        return null;
    L6:
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), '?', 0, false, 6, null) + 1;
        String r1 = this.j;
        int r2 = okhttp3.internal.c.a(r1, '#', r0, r1.length());
        String r7 = this.j.substring(r0, r2);
        d.h.b.o.c(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        return r7;
    }

    public final String query() {
        if (this.h != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        f40208a.b(this.h, r0);
        return r0.toString();
    }

    public final String l() {
        if (this.i != null) goto L6;
        return null;
    L6:
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.aiagent.plugin"), '#', 0, false, 6, null) + 1;
        String r7 = this.j.substring(r0);
        d.h.b.o.c(r7, "this as java.lang.String).substring(startIndex)");
        return r7;
    }

    public final String m() {
        a r1 = b("/...");
        d.h.b.o.a(r1);
        return r1.g("").h("").c().toString();
    }

    public final v a(String r2) {
        d.h.b.o.e(r2, "link");
        a r1 = b(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c();
    }

    public final a n() {
        a r0 = new a();
        r0.a(this.f40209b);
        r0.b(g());
        r0.c(h());
        r0.d(this.f40212e);
        if (this.f == f40208a.a(this.f40209b)) goto L5;
        int r1 = this.f;
    L6:
        r0.a(r1);
        r0.a().clear();
        r0.a().addAll((Collection) ZeusTransformUtils.preCheckCast(j(), Collection.class, "com.obric.aiagent.plugin"));
        r0.j(k());
        r0.e(l());
        return r0;
    L5:
        r1 = -1;
        goto L6
    }

    public final a b(String r2) {
        d.h.b.o.e(r2, "link");
        return new a().a(this, r2);
    L5:
        return null;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, v.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(((v) ZeusTransformUtils.preCheckCast(r3, v.class, "com.obric.aiagent.plugin")).j, this.j) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }

    static {
        f40208a = new b(null);
        l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }
}
