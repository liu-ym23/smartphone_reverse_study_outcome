package com.bytedance.retrofit2.b;

import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.an;
import com.bytedance.retrofit2.e.j;
import com.bytedance.retrofit2.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.ac;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private URI f9477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f9478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f9479e;
    private final ac f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    private final boolean k;
    private int l;
    private Object m;
    private final String n;
    private final Map<Class<?>, Object> o;
    private int p;
    private boolean q;
    private boolean r;
    private af s;

    /* JADX INFO: compiled from: Request.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f9480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f9481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List<b> f9482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        j f9483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ac f9484e;
        int f;
        int g;
        boolean h;
        int i;
        boolean j;
        int k;
        Object l;
        String m;
        af n;
        Map<Class<?>, Object> o;
        boolean p;
        boolean q;

        public a() {
            this.f9480a = "GET";
        }

        a(c r3) {
            this.f9480a = c.a(r3);
            this.f9481b = c.b(r3);
            LinkedList r0 = new LinkedList();
            this.f9482c = r0;
            r0.addAll(c.c(r3));
            this.f9483d = c.d(r3);
            this.f9484e = c.e(r3);
            this.f = c.f(r3);
            this.g = c.g(r3);
            this.h = c.h(r3);
            this.i = c.i(r3);
            this.j = c.j(r3);
            this.k = c.k(r3);
            this.l = c.l(r3);
            this.m = c.m(r3);
            this.n = c.n(r3);
            this.o = c.o(r3);
            this.p = c.p(r3);
            this.q = c.q(r3);
        }

        public a a() {
            return a("GET", null);
        }

        public a a(j r3) {
            return a("POST", (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin"));
        }

        public a delete(j r3) {
            return a("DELETE", (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.retrofit2.e.j] */
        /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.retrofit2.e.j] */
        /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.retrofit2.e.c] */
        public a a(String r3, j r4) {
            ?? r5 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
            Objects.requireNonNull(r3, "method == null");
            if (r3.length() == 0) goto L17;
            if (r5 != 0) goto L6;
        L10:
            if (r5 == 0) goto L12;
        L14:
            this.f9480a = r3;
            this.f9483d = r5;
            return this;
        L12:
            if (an.a(r3) == false) goto L14;
            r5 = new com.bytedance.retrofit2.e.c();
            r5.a("body", "null");
            goto L14
        L6:
            if (an.b(r3) == true) goto L10;
            throw new IllegalArgumentException("method " + r3 + " must not have a request body.");
        L17:
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a a(String r2) {
            Objects.requireNonNull(r2, "url == null");
            this.f9481b = r2;
            return this;
        }

        public a a(List<b> r3) {
            this.f9482c = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(int r1) {
            this.f = r1;
            return this;
        }

        public a b(int r1) {
            this.g = r1;
            return this;
        }

        public a a(boolean r1) {
            this.j = r1;
            return this;
        }

        public a a(Object r1) {
            this.l = r1;
            return this;
        }

        public <T> a a(Class<? super T> r2, T r3) {
            Objects.requireNonNull(r2, "type == null");
            if (this.o != null) goto L5;
            this.o = new HashMap();
        L5:
            if (r3 != null) goto L7;
            this.o.remove(r2);
        L8:
            return this;
        L7:
            this.o.put(r2, r2.cast(r3));
            goto L8
        }

        public c b() {
            if (this.f9481b == null) goto L7;
            return new c(this);
        L7:
            throw new IllegalStateException("url == null");
        }
    }

    static /* synthetic */ String a(c r0) {
        return r0.f9475a;
    }

    static /* synthetic */ String b(c r0) {
        return r0.f9476b;
    }

    static /* synthetic */ List c(c r0) {
        return r0.f9478d;
    }

    static /* synthetic */ j d(c r0) {
        return r0.f9479e;
    }

    static /* synthetic */ ac e(c r0) {
        return r0.f;
    }

    static /* synthetic */ int f(c r0) {
        return r0.g;
    }

    static /* synthetic */ int g(c r0) {
        return r0.h;
    }

    static /* synthetic */ boolean h(c r0) {
        return r0.i;
    }

    static /* synthetic */ int i(c r0) {
        return r0.j;
    }

    static /* synthetic */ boolean j(c r0) {
        return r0.k;
    }

    static /* synthetic */ int k(c r0) {
        return r0.l;
    }

    static /* synthetic */ Object l(c r0) {
        return r0.m;
    }

    static /* synthetic */ String m(c r0) {
        return r0.n;
    }

    static /* synthetic */ af n(c r0) {
        return r0.s;
    }

    static /* synthetic */ Map o(c r0) {
        return r0.o;
    }

    static /* synthetic */ boolean p(c r0) {
        return r0.q;
    }

    static /* synthetic */ boolean q(c r0) {
        return r0.r;
    }

    public c(String r9, String r10, List<b> r11, j r12, ac r13, int r14, int r15, boolean r16, int r17, boolean r18, int r19, Object r20, String r21, Map<Class<?>, Object> r22) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.aiagent.plugin");
        Map<Class<?>, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        this.p = 0;
        Objects.requireNonNull(r9, "Method must not be null.");
        Objects.requireNonNull(r10, "URL must not be null.");
        this.f9475a = r9;
        this.f9476b = r10;
        if (r3 != null) goto L5;
        this.f9478d = Collections.emptyList();
    L6:
        this.f9479e = r5;
        this.f = r13;
        this.g = r14;
        this.h = r15;
        this.i = r16;
        this.j = r17;
        this.k = r18;
        this.l = r19;
        this.m = r20;
        this.n = r21;
        this.o = r4;
        return;
    L5:
        this.f9478d = Collections.unmodifiableList(new ArrayList(r3));
        goto L6
    }

    c(a r3) {
        this.p = 0;
        Objects.requireNonNull(r3.f9481b, "URL must not be null.");
        this.f9476b = r3.f9481b;
        Objects.requireNonNull(r3.f9480a, "Method must not be null.");
        this.f9475a = r3.f9480a;
        if (r3.f9482c != null) goto L5;
        this.f9478d = Collections.emptyList();
    L6:
        this.f9479e = r3.f9483d;
        this.f = r3.f9484e;
        this.g = r3.f;
        this.h = r3.g;
        this.i = r3.h;
        this.j = r3.i;
        this.k = r3.j;
        this.l = r3.k;
        this.m = r3.l;
        this.n = r3.m;
        this.s = r3.n;
        this.o = r3.o;
        this.q = r3.p;
        this.r = r3.q;
        return;
    L5:
        this.f9478d = Collections.unmodifiableList(new ArrayList(r3.f9482c));
        goto L6
    }

    public String a() {
        return this.f9475a;
    }

    public String b() {
        return this.f9476b;
    }

    public List<b> c() {
        return this.f9478d;
    }

    public b a(String r5) {
        if (r5 == null) goto L13;
        List<b> r4 = this.f9478d;
        if (r4 == null) goto L13;
        Iterator<b> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
        if (r5.equalsIgnoreCase(r1.a()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<b> b(String r5) {
        ArrayList r0 = null;
        if (r5 == null) goto L15;
        List<b> r4 = this.f9478d;
        if (r4 == null) goto L15;
        Iterator<b> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
        if (r5.equalsIgnoreCase(r1.a()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public j d() {
        ac r0 = this.f;
        if (r0 == null) goto L7;
        return an.a(r0);
    L7:
        return this.f9479e;
    }

    public ac e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i() {
        return this.k;
    }

    public int j() {
        return this.l;
    }

    public void a(int r1) {
        this.l = r1;
    }

    public int k() {
        return this.j;
    }

    public Object l() {
        return this.m;
    }

    public a m() {
        return new a(this);
    }

    public String n() {
        URI r0 = v();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHost();
    }

    public String o() {
        URI r0 = v();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPath();
    }

    public af p() {
        return this.s;
    }

    public void a(af r1) {
        this.s = r1;
    }

    public int q() {
        return this.p;
    }

    public void b(int r1) {
        this.p = r1;
    }

    public boolean r() {
        return this.q;
    }

    public void a(boolean r1) {
        this.q = r1;
    }

    public boolean s() {
        return this.r;
    }

    public void b(boolean r1) {
        this.r = r1;
    }

    private URI v() {
        if (w.a() == false) goto L18;
        if (this.f9477c != null) goto L16;
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.f9477c != null) goto L10;
        this.f9477c = c(this.f9476b);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
    L16:
        return this.f9477c;
    L18:
        return c(this.f9476b);
    }

    private static URI c(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L17;
        return new URI(r2);
    L8:
        return URI.create(r2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return d(r2);
    L17:
        return null;
    }

    private static URI d(String r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == true) goto L18;
        int r0 = r2.indexOf("?");     // Catch: Exception -> L11
        if (r0 <= 0) goto L9;
        r2 = r2.substring(0, r0);     // Catch: Exception -> L11
    L9:
        return URI.create(r2);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L18:
        return null;
    }

    public <T> T a(Class<? extends T> r1) {
        Map<Class<?>, Object> r0 = this.o;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r1.cast(r0.get(r1));
    }

    public boolean t() {
        List<b> r3 = b("x-metasec-bypass-ttnet-features");
        if (r3 != null) goto L5;
    L10:
        return false;
    L5:
        if (r3.size() <= 0) goto L10;
        if ("1".equals(((b) ZeusTransformUtils.preCheckCast(r3.get(0), b.class, "com.obric.aiagent.plugin")).b()) == false) goto L10;
        return true;
    }

    public boolean u() {
        List<b> r3 = b("x-tt-bypass-dp");
        if (r3 != null) goto L5;
    L10:
        return false;
    L5:
        if (r3.size() <= 0) goto L10;
        if ("1".equals(((b) ZeusTransformUtils.preCheckCast(r3.get(0), b.class, "com.obric.aiagent.plugin")).b()) == false) goto L10;
        return true;
    }
}
