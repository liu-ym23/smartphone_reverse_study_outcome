package g6;

import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.mime.TypedOutput;
import f6.g;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f19956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TypedOutput f19957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RequestBody f19958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19959f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f19960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19961h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f19962i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19963j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Object f19964k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f19965l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map f19966m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f19967n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19968o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19969p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RetrofitMetrics f19970q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f19971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f19972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f19973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TypedOutput f19974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public RequestBody f19975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19977g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f19978h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19979i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f19980j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f19981k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f19982l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public RetrofitMetrics f19983m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Map f19984n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f19985o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f19986p;

        public a() {
            this.f19985o = false;
            this.f19986p = false;
            this.f19971a = "GET";
        }

        public b a() {
            if (this.f19972b == null) goto L7;
            return new b(this);
        L7:
            throw new IllegalStateException("url == null");
        }

        public a b(List r10) {
            this.f19973c = r10;
            return this;
        }

        public a c(String r10) {
            if (r10 == null) goto L6;
            this.f19972b = r10;
            return this;
        L6:
            throw new NullPointerException("url == null");
        }

        public a(b r10) {
            this.f19985o = false;
            this.f19986p = false;
            this.f19971a = b.a(r10);
            this.f19972b = b.b(r10);
            LinkedList r11 = new LinkedList();
            this.f19973c = r11;
            r11.addAll(b.i(r10));
            this.f19974d = b.j(r10);
            this.f19975e = b.k(r10);
            this.f19976f = b.l(r10);
            this.f19977g = b.m(r10);
            this.f19978h = b.n(r10);
            this.f19979i = b.o(r10);
            this.f19980j = b.p(r10);
            this.f19981k = b.c(r10);
            this.f19982l = b.d(r10);
            this.f19983m = b.e(r10);
            this.f19984n = b.f(r10);
            this.f19985o = b.g(r10);
            this.f19986p = b.h(r10);
        }
    }

    public b(String r10, String r11, List r12, TypedOutput r13, RequestBody r14, int r15, int r16, boolean r17, int r18, boolean r19, Object r110, String r111, Map r112) {
        this.f19967n = 0;
        this.f19968o = false;
        this.f19969p = false;
        if (r10 == null) goto L14;
        if (r11 == null) goto L12;
        this.f19954a = r10;
        this.f19955b = r11;
        if (r12 != null) goto L8;
        this.f19956c = Collections.emptyList();
    L9:
        this.f19957d = r13;
        this.f19958e = r14;
        this.f19959f = r15;
        this.f19960g = r16;
        this.f19961h = r17;
        this.f19962i = r18;
        this.f19963j = r19;
        this.f19964k = r110;
        this.f19965l = r111;
        this.f19966m = r112;
        return;
    L8:
        this.f19956c = Collections.unmodifiableList(new ArrayList(r12));
        goto L9
    L12:
        throw new NullPointerException("URL must not be null.");
    L14:
        throw new NullPointerException("Method must not be null.");
    }

    public static URI K(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L17;
        return new URI(r10);
    L8:
        return URI.create(r10.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return q(r10);
    L17:
        return null;
    }

    public static /* synthetic */ String a(b r10) {
        return r10.f19954a;
    }

    public static /* synthetic */ String b(b r10) {
        return r10.f19955b;
    }

    public static /* synthetic */ Object c(b r10) {
        return r10.f19964k;
    }

    public static /* synthetic */ String d(b r10) {
        return r10.f19965l;
    }

    public static /* synthetic */ RetrofitMetrics e(b r10) {
        return r10.f19970q;
    }

    public static /* synthetic */ Map f(b r10) {
        return r10.f19966m;
    }

    public static /* synthetic */ boolean g(b r10) {
        return r10.f19968o;
    }

    public static /* synthetic */ boolean h(b r10) {
        return r10.f19969p;
    }

    public static /* synthetic */ List i(b r10) {
        return r10.f19956c;
    }

    public static /* synthetic */ TypedOutput j(b r10) {
        return r10.f19957d;
    }

    public static /* synthetic */ RequestBody k(b r10) {
        return r10.f19958e;
    }

    public static /* synthetic */ int l(b r10) {
        return r10.f19959f;
    }

    public static /* synthetic */ int m(b r10) {
        return r10.f19960g;
    }

    public static /* synthetic */ boolean n(b r10) {
        return r10.f19961h;
    }

    public static /* synthetic */ int o(b r10) {
        return r10.f19962i;
    }

    public static /* synthetic */ boolean p(b r10) {
        return r10.f19963j;
    }

    public static URI q(String r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L19;
        int r11 = r10.indexOf("?");     // Catch: Exception -> L9
        if (r11 <= 0) goto L11;
        r10 = r10.substring(0, r11);     // Catch: Exception -> L9
    L11:
        return URI.create(r10);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        return null;
    }

    public int A() {
        return this.f19967n;
    }

    public RequestBody B() {
        return this.f19958e;
    }

    public int C() {
        return this.f19960g;
    }

    public String D() {
        return this.f19955b;
    }

    public List E(String r10) {
        ArrayList r11 = null;
        if (r10 == null) goto L15;
        List r12 = this.f19956c;
        if (r12 == null) goto L15;
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        g6.a r14 = (g6.a) r13.next();
        if (r10.equalsIgnoreCase(r14.a()) == false) goto L9;
        if (r11 != null) goto L14;
        r11 = new ArrayList();
    L14:
        r11.add(r14);
    L15:
        return r11;
    }

    public boolean F() {
        return this.f19963j;
    }

    public boolean G() {
        return this.f19969p;
    }

    public boolean H() {
        return this.f19968o;
    }

    public boolean I() {
        return this.f19961h;
    }

    public a J() {
        return new a(this);
    }

    public void L(boolean r10) {
        this.f19969p = r10;
    }

    public void M(Object r10) {
        this.f19964k = r10;
    }

    public void N(RetrofitMetrics r10) {
        this.f19970q = r10;
    }

    public void O(boolean r10) {
        this.f19968o = r10;
    }

    public void P(int r10) {
        this.f19967n = r10;
    }

    public TypedOutput r() {
        RequestBody r10 = this.f19958e;
        if (r10 == null) goto L7;
        return g.c(r10);
    L7:
        return this.f19957d;
    }

    public Object s() {
        return this.f19964k;
    }

    public g6.a t(String r10) {
        if (r10 == null) goto L13;
        List r11 = this.f19956c;
        if (r11 == null) goto L13;
        Iterator r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L13;
        g6.a r13 = (g6.a) r12.next();
        if (r10.equalsIgnoreCase(r13.a()) == false) goto L9;
        return r13;
    L13:
        return null;
    }

    public List u() {
        return this.f19956c;
    }

    public String v() {
        URI r10 = K(this.f19955b);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getHost();
    }

    public int w() {
        return this.f19962i;
    }

    public String x() {
        return this.f19954a;
    }

    public RetrofitMetrics y() {
        return this.f19970q;
    }

    public String z() {
        URI r10 = K(this.f19955b);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getPath();
    }

    public b(a r10) {
        this.f19967n = 0;
        this.f19968o = false;
        this.f19969p = false;
        String r11 = r10.f19972b;
        if (r11 == null) goto L15;
        this.f19955b = r11;
        String r12 = r10.f19971a;
        if (r12 == null) goto L13;
        this.f19954a = r12;
        if (r10.f19973c != null) goto L9;
        this.f19956c = Collections.emptyList();
    L10:
        this.f19957d = r10.f19974d;
        this.f19958e = r10.f19975e;
        this.f19959f = r10.f19976f;
        this.f19960g = r10.f19977g;
        this.f19961h = r10.f19978h;
        this.f19962i = r10.f19979i;
        this.f19963j = r10.f19980j;
        this.f19964k = r10.f19981k;
        this.f19965l = r10.f19982l;
        this.f19970q = r10.f19983m;
        this.f19966m = r10.f19984n;
        this.f19968o = r10.f19985o;
        this.f19969p = r10.f19986p;
        return;
    L9:
        this.f19956c = Collections.unmodifiableList(new ArrayList(r10.f19973c));
        goto L10
    L13:
        throw new NullPointerException("Method must not be null.");
    L15:
        throw new NullPointerException("URL must not be null.");
    }
}
