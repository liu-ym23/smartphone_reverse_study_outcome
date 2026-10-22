package okhttp3;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f39698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f39700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ac f39701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, Object> f39702e;
    private d f;

    /* JADX INFO: compiled from: Request.kt */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v f39703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f39704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private u.a f39705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ac f39706d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<Class<?>, Object> f39707e;

        public final a delete() {
            return a(this, null, 1, null);
        }

        public a() {
            this.f39707e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            this.f39704b = "GET";
            this.f39705c = new u.a();
        }

        public a(ab r4) {
            d.h.b.o.e(r4, Ext.KEY_REQUEST);
            this.f39707e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            this.f39703a = r4.a();
            this.f39704b = r4.b();
            this.f39706d = r4.d();
            if (r4.e().isEmpty() == false) goto L5;
            Map<Class<?>, Object> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L6:
            this.f39707e = r0;
            this.f39705c = r4.c().d();
            return;
        L5:
            r0 = ao.e(r4.e());
            goto L6
        }

        public a a(v r4) {
            d.h.b.o.e(r4, "url");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39703a = r4;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(String r4) {
            d.h.b.o.e(r4, "url");
            if (d.o.o.b(r4, "ws:", true) == false) goto L6;
            StringBuilder r0 = new StringBuilder().append("http:");
            String r5 = r4.substring(3);
            d.h.b.o.c(r5, "this as java.lang.String).substring(startIndex)");
            r4 = r0.append(r5).toString();
        L9:
            return a(v.f40208a.c(r4));
        L6:
            if (d.o.o.b(r4, "wss:", true) == false) goto L9;
            StringBuilder r1 = new StringBuilder().append("https:");
            String r6 = r4.substring(4);
            d.h.b.o.c(r6, "this as java.lang.String).substring(startIndex)");
            r4 = r1.append(r6).toString();
            goto L9
        }

        public a a(String r4, String r5) {
            d.h.b.o.e(r4, "name");
            d.h.b.o.e(r5, "value");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39705c.c(r4, r5);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a b(String r4, String r5) {
            d.h.b.o.e(r4, "name");
            d.h.b.o.e(r5, "value");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39705c.a(r4, r5);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a b(String r4) {
            d.h.b.o.e(r4, "name");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39705c.b(r4);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a(u r4) {
            d.h.b.o.e(r4, "headers");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            r2.f39705c = r4.d();
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public a a() {
            return a("GET", null);
        }

        public a a(ac r2) {
            d.h.b.o.e(r2, "body");
            return a("POST", r2);
        }

        public static /* synthetic */ a a(a r0, ac r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L7;
            r1 = okhttp3.internal.c.f39836d;
        L7:
            return r0.delete(r1);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public a delete(ac r2) {
            return a("DELETE", r2);
        }

        public a a(String r7, ac r8) {
            d.h.b.o.e(r7, "method");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L21;
            if (r8 != null) goto L15;
            if ((true ^ okhttp3.internal.e.f.b(r7)) == false) goto L13;
        L16:
            r2.f39704b = r7;
            r2.f39706d = r8;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L13:
            throw new IllegalArgumentException(("method " + r7 + " must have a request body.").toString());
        L15:
            if (okhttp3.internal.e.f.c(r7) == true) goto L16;
            throw new IllegalArgumentException(("method " + r7 + " must not have a request body.").toString());
        L21:
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        L5:
            r3 = false;
            goto L6
        }

        public a a(Object r2) {
            return a(Object.class, r2);
        }

        public <T> a a(Class<? super T> r6, T r7) {
            d.h.b.o.e(r6, "type");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L6;
            r2.f39707e.remove(r6);
        L10:
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L6:
            if (r2.f39707e.isEmpty() == false) goto L8;
            r2.f39707e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        L8:
            Map<Class<?>, Object> r3 = r2.f39707e;
            T r8 = r6.cast(r7);
            d.h.b.o.a(r8);
            r3.put(r6, r8);
            goto L10
        }

        public ab b() {
            v r1 = this.f39703a;
            if (r1 == null) goto L7;
            return new ab(r1, this.f39704b, this.f39705c.b(), this.f39706d, okhttp3.internal.c.a(this.f39707e));
        L7:
            throw new IllegalStateException("url == null".toString());
        }
    }

    public ab(v r3, String r4, u r5, ac r6, Map<Class<?>, ? extends Object> r7) {
        Map<Class<?>, Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "url");
        d.h.b.o.e(r4, "method");
        d.h.b.o.e(r5, "headers");
        d.h.b.o.e(r8, "tags");
        this.f39698a = r3;
        this.f39699b = r4;
        this.f39700c = r5;
        this.f39701d = r6;
        this.f39702e = r8;
    }

    public final v a() {
        return this.f39698a;
    }

    public final String b() {
        return this.f39699b;
    }

    public final u c() {
        return this.f39700c;
    }

    public final ac d() {
        return this.f39701d;
    }

    public final Map<Class<?>, Object> e() {
        return this.f39702e;
    }

    public final boolean f() {
        return this.f39698a.d();
    }

    public final String a(String r2) {
        d.h.b.o.e(r2, "name");
        return this.f39700c.a(r2);
    }

    public final List<String> b(String r2) {
        d.h.b.o.e(r2, "name");
        return this.f39700c.b(r2);
    }

    public final Object g() {
        return a(Object.class);
    }

    public final <T> T a(Class<? extends T> r2) {
        d.h.b.o.e(r2, "type");
        return r2.cast(this.f39702e.get(r2));
    }

    public final a h() {
        return new a(this);
    }

    public final d i() {
        d r0 = this.f;
        if (r0 != null) goto L6;
        d r1 = d.f39760a.a(this.f39700c);
        this.f = r1;
        return r1;
    L6:
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Request{method=");
        r0.append(this.f39699b);
        r0.append(", url=");
        r0.append(this.f39698a);
        if (this.f39700c.a() == 0) goto L16;
        r0.append(", headers=[");
        int r2 = 0;
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f39700c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r4 = r1.next();
        int r5 = r2 + 1;
        if (r2 >= 0) goto L10;
        d.a.p.c();
    L10:
        d.m r6 = (d.m) ZeusTransformUtils.preCheckCast(r4, d.m.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.c(), String.class, "com.obric.aiagent.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.d(), String.class, "com.obric.aiagent.plugin");
        if (r2 <= 0) goto L13;
        r0.append(", ");
    L13:
        r0.append(r7);
        r0.append(':');
        r0.append(r8);
        r2 = r5;
        goto L6
    L14:
        r0.append(']');
    L16:
        if ((!this.f39702e.isEmpty()) == false) goto L18;
        r0.append(", tags=");
        r0.append(this.f39702e);
    L18:
        r0.append('}');
        String r9 = r0.toString();
        d.h.b.o.c(r9, "StringBuilder().apply(builderAction).toString()");
        return r9;
    }
}
