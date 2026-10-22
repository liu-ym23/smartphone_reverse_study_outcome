package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.collections.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class NavDeepLink {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f3774m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f3775n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f3780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f3782g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3783h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3784i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f3785j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f3786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3787l;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0037a f3788d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f3791c;

        /* JADX INFO: renamed from: androidx.navigation.NavDeepLink$a$a, reason: collision with other inner class name */
        public static final class C0037a {
            public /* synthetic */ C0037a(DefaultConstructorMarker r10) {
                this();
            }

            public C0037a() {
            }
        }

        static {
            f3788d = new C0037a(null);
        }

        public a() {
        }

        public final NavDeepLink a() {
            return new NavDeepLink(this.f3789a, this.f3790b, this.f3791c);
        }

        public final a b(String r10) {
            kotlin.jvm.internal.q.g(r10, "action");
            if (r10.length() <= 0) goto L7;
            this.f3790b = r10;
            return this;
        L7:
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        public final a c(String r10) {
            kotlin.jvm.internal.q.g(r10, "mimeType");
            this.f3791c = r10;
            return this;
        }

        public final a d(String r10) {
            kotlin.jvm.internal.q.g(r10, "uriPattern");
            this.f3789a = r10;
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public static final class c implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3793b;

        public c(String r10) {
            kotlin.jvm.internal.q.g(r10, "mimeType");
            List<String> r11 = new Regex(LibrarianImpl.Constants.SEPARATOR).split(r10, 0);
            if (r11.isEmpty() == true) goto L11;
            ListIterator<String> r12 = r11.listIterator(r11.size());
        L6:
            if (r12.hasPrevious() == false) goto L11;
            if (r12.previous().length() == 0) goto L6;
            List r13 = b0.u0(r11, r12.nextIndex() + 1);
        L12:
            this.f3792a = (String) r13.get(0);
            this.f3793b = (String) r13.get(1);
            return;
        L11:
            r13 = t.i();
            goto L12
        }

        public int a(c r10) {
            kotlin.jvm.internal.q.g(r10, AppInfo.SEARCH_SOURCE_EXTENAL);
            if (kotlin.jvm.internal.q.b(this.f3792a, r10.f3792a) == false) goto L5;
            int r11 = 2;
        L7:
            if (kotlin.jvm.internal.q.b(this.f3793b, r10.f3793b) == true) goto L9;
            return r11;
        L9:
            return r11 + 1;
        L5:
            r11 = 0;
            goto L7
        }

        public final String b() {
            return this.f3793b;
        }

        public final String c() {
            return this.f3792a;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return a((c) r10);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3795b;

        public d() {
            this.f3795b = new ArrayList();
        }

        public final void a(String r10) {
            kotlin.jvm.internal.q.g(r10, "name");
            this.f3795b.add(r10);
        }

        public final String b(int r10) {
            return (String) this.f3795b.get(r10);
        }

        public final List c() {
            return this.f3795b;
        }

        public final String d() {
            return this.f3794a;
        }

        public final void e(String r10) {
            this.f3794a = r10;
        }

        public final int f() {
            return this.f3795b.size();
        }
    }

    static {
        f3774m = new b(null);
        f3775n = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    }

    public NavDeepLink(String r20, String r21, String r22) {
        this.f3776a = r20;
        this.f3777b = r21;
        this.f3778c = r22;
        this.f3779d = new ArrayList();
        this.f3780e = new LinkedHashMap();
        this.f3782g = kotlin.b.b(new NavDeepLink$pattern$2(this));
        this.f3786k = kotlin.b.b(new NavDeepLink$mimeTypePattern$2(this));
        if (r20 == null) goto L37;
        Uri r10 = Uri.parse(r20);
        if (r10.getQuery() == null) goto L7;
        boolean r11 = true;
    L8:
        this.f3783h = r11;
        StringBuilder r12 = new StringBuilder("^");
        if (f3775n.matcher(r20).find() == true) goto L11;
        r12.append("http[s]?://");
    L11:
        Pattern r13 = Pattern.compile("\\{(.+?)\\}");
        if (this.f3783h == false) goto L34;
        Matcher r14 = Pattern.compile("(\\?)").matcher(r20);
        if (r14.find() == false) goto L16;
        String r15 = r20.substring(0, r14.start());
        kotlin.jvm.internal.q.f(r15, "this as java.lang.String…ing(startIndex, endIndex)");
        kotlin.jvm.internal.q.f(r13, "fillInPattern");
        this.f3787l = c(r15, r12, r13);
    L16:
        Iterator<String> r16 = r10.getQueryParameterNames().iterator();
    L18:
        if (r16.hasNext() == false) goto L35;
        String r17 = r16.next();
        StringBuilder r18 = new StringBuilder();
        String r19 = r10.getQueryParameter(r17);
        if (r19 != null) goto L22;
        this.f3784i = true;
        r19 = r17;
    L22:
        Matcher r110 = r13.matcher(r19);
        d r111 = new d();
        int r112 = 0;
    L24:
        if (r110.find() == false) goto L31;
        String r113 = r110.group(1);
        if (r113 == null) goto L29;
        r111.a(r113);
        kotlin.jvm.internal.q.f(r19, "queryParam");
        String r114 = r19.substring(r112, r110.start());
        kotlin.jvm.internal.q.f(r114, "this as java.lang.String…ing(startIndex, endIndex)");
        r18.append(Pattern.quote(r114));
        r18.append("(.+?)?");
        r112 = r110.end();
        goto L24
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L31:
        if (r112 >= r19.length()) goto L33;
        kotlin.jvm.internal.q.f(r19, "queryParam");
        String r23 = r19.substring(r112);
        kotlin.jvm.internal.q.f(r23, "this as java.lang.String).substring(startIndex)");
        r18.append(Pattern.quote(r23));
    L33:
        String r115 = r18.toString();
        kotlin.jvm.internal.q.f(r115, "argRegex.toString()");
        r111.e(kotlin.text.o.x(r115, ".*", "\\E.*\\Q", false, 4, null));
        Map r24 = this.f3780e;
        kotlin.jvm.internal.q.f(r17, "paramName");
        r24.put(r17, r111);
    L35:
        String r25 = r12.toString();
        kotlin.jvm.internal.q.f(r25, "uriRegex.toString()");
        this.f3781f = kotlin.text.o.x(r25, ".*", "\\E.*\\Q", false, 4, null);
        goto L37
    L34:
        kotlin.jvm.internal.q.f(r13, "fillInPattern");
        this.f3787l = c(r20, r12, r13);
        goto L35
    L7:
        r11 = false;
    L37:
        if (this.f3778c != null) goto L39;
        return;
    L39:
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.f3778c).matches() == false) goto L42;
        c r26 = new c(this.f3778c);
        this.f3785j = kotlin.text.o.x("^(" + r26.c() + "|[*]+)/(" + r26.b() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
        return;
    L42:
        throw new IllegalArgumentException(("The given mimeType " + this.f3778c + " does not match to required \"type/subtype\" format").toString());
    }

    public static final /* synthetic */ String a(NavDeepLink r10) {
        return r10.f3785j;
    }

    public static final /* synthetic */ String b(NavDeepLink r10) {
        return r10.f3781f;
    }

    public final boolean c(String r10, StringBuilder r11, Pattern r12) {
        Matcher r13 = r12.matcher(r10);
        boolean r14 = !StringsKt__StringsKt.E(r10, ".*", false, 2, null);
        int r15 = 0;
    L4:
        if (r13.find() == false) goto L11;
        String r16 = r13.group(1);
        if (r16 == null) goto L9;
        this.f3779d.add(r16);
        String r17 = r10.substring(r15, r13.start());
        kotlin.jvm.internal.q.f(r17, "this as java.lang.String…ing(startIndex, endIndex)");
        r11.append(Pattern.quote(r17));
        r11.append("([^/]+?)");
        r15 = r13.end();
        r14 = false;
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L11:
        if (r15 >= r10.length()) goto L13;
        String r18 = r10.substring(r15);
        kotlin.jvm.internal.q.f(r18, "this as java.lang.String).substring(startIndex)");
        r11.append(Pattern.quote(r18));
    L13:
        r11.append("($|(\\?(.)*)|(\\#(.)*))");
        return r14;
    }

    public final String d() {
        return this.f3777b;
    }

    public final List e() {
        List r10 = this.f3779d;
        Collection r11 = this.f3780e.values();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        y.v(r12, ((d) r13.next()).c());
        goto L4
    L7:
        return b0.n0(r10, r12);
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if ((r10 instanceof NavDeepLink) == false) goto L19;
        NavDeepLink r11 = (NavDeepLink) r10;
        if (kotlin.jvm.internal.q.b(this.f3776a, r11.f3776a) == true) goto L10;
        return false;
    L10:
        if (kotlin.jvm.internal.q.b(this.f3777b, r11.f3777b) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f3778c, r11.f3778c) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public final Bundle f(Uri r17, Map r18) {
        kotlin.jvm.internal.q.g(r17, "deepLink");
        kotlin.jvm.internal.q.g(r18, "arguments");
        Pattern r10 = j();
        if (r10 == null) goto L5;
        Matcher r11 = r10.matcher(r17.toString());
    L6:
        if (r11 != null) goto L9;
        return null;
    L9:
        if (r11.matches() == true) goto L11;
        return null;
    L11:
        Bundle r12 = new Bundle();
        int r13 = this.f3779d.size();
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L18;
        String r15 = (String) this.f3779d.get(r14);
        r14 = r14 + 1;
        String r16 = Uri.decode(r11.group(r14));
        androidx.navigation.c r19 = (androidx.navigation.c) r18.get(r15);
        kotlin.jvm.internal.q.f(r16, CommonKey.KEY_VALUE);     // Catch: IllegalArgumentException -> L63
        if (m(r12, r15, r16, r19) == false) goto L12;
    L16:
        return null;
    L18:
        if (this.f3783h == false) goto L50;
        Iterator r20 = this.f3780e.keySet().iterator();
    L21:
        if (r20.hasNext() == false) goto L50;
        String r21 = (String) r20.next();
        d r22 = (d) this.f3780e.get(r21);
        String r23 = r17.getQueryParameter(r21);
        if (this.f3784i == false) goto L27;
        String r24 = r17.toString();
        kotlin.jvm.internal.q.f(r24, "deepLink.toString()");
        String r110 = StringsKt__StringsKt.t0(r24, '?', null, 2, null);
        if (kotlin.jvm.internal.q.b(r110, r24) == true) goto L27;
        r23 = r110;
    L27:
        if (r23 == null) goto L31;
        kotlin.jvm.internal.q.d(r22);
        Matcher r25 = Pattern.compile(r22.d(), 32).matcher(r23);
        if (r25.matches() == false) goto L30;
    L32:
        Bundle r26 = new Bundle();
        kotlin.jvm.internal.q.d(r22);     // Catch: IllegalArgumentException -> L64
        int r111 = r22.f();     // Catch: IllegalArgumentException -> L64
        int r112 = 0;
    L34:
        if (r112 >= r111) goto L48;
        if (r25 == null) goto L39;
        String r113 = r25.group(r112 + 1);     // Catch: IllegalArgumentException -> L64
        if (r113 != null) goto L40;
        r113 = "";
    L40:
        String r114 = r22.b(r112);     // Catch: IllegalArgumentException -> L64
        androidx.navigation.c r115 = (androidx.navigation.c) r18.get(r114);     // Catch: IllegalArgumentException -> L64
        if (r113 == null) goto L47;
        if (kotlin.jvm.internal.q.b(r113, '{' + r114 + '}') == true) goto L47;
        if (m(r26, r114, r113, r115) == false) goto L47;
        return null;
    L47:
        r112 = r112 + 1;     // Catch: IllegalArgumentException -> L64
        goto L34
    L39:
        r113 = null;
        goto L40
    L48:
        r12.putAll(r26);     // Catch: IllegalArgumentException -> L64
        goto L21
    L30:
        return null;
    L31:
        r25 = null;
    L50:
        Iterator r27 = r18.entrySet().iterator();
    L52:
        if (r27.hasNext() == false) goto L62;
        Map.Entry r28 = (Map.Entry) r27.next();
        String r29 = (String) r28.getKey();
        androidx.navigation.c r30 = (androidx.navigation.c) r28.getValue();
        if (r30 == null) goto L52;
        if (r30.c() == true) goto L52;
        if (r30.b() == true) goto L52;
        if (r12.containsKey(r29) == true) goto L52;
        return null;
    L62:
        return r12;
    L5:
        r11 = null;
        goto L6
    }

    public final String g() {
        return this.f3778c;
    }

    public final int h(String r10) {
        kotlin.jvm.internal.q.g(r10, "mimeType");
        if (this.f3778c == null) goto L8;
        Pattern r11 = i();
        kotlin.jvm.internal.q.d(r11);
        if (r11.matcher(r10).matches() == false) goto L8;
        return new c(this.f3778c).a(new c(r10));
    L8:
        return -1;
    }

    public int hashCode() {
        String r10 = this.f3776a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        String r14 = this.f3777b;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f3778c;
        if (r17 == null) goto L14;
        r11 = r17.hashCode();
    L14:
        return r16 + r11;
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final Pattern i() {
        return (Pattern) this.f3786k.getValue();
    }

    public final Pattern j() {
        return (Pattern) this.f3782g.getValue();
    }

    public final String k() {
        return this.f3776a;
    }

    public final boolean l() {
        return this.f3787l;
    }

    public final boolean m(Bundle r10, String r11, String r12, androidx.navigation.c r13) {
        if (r13 == null) goto L4;
        r13.a().d(r10, r11, r12);
        return false;
    L4:
        r10.putString(r11, r12);
        return false;
    }
}
