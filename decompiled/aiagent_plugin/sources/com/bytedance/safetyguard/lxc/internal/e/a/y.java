package com.bytedance.safetyguard.lxc.internal.e.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
/* JADX INFO: loaded from: classes.dex */
public final class y implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f10538a = null;

    /* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
    @d.c.b.a.f(b = "LarkOAuthHttpTransport.kt", c = {101}, d = "invokeSuspend", e = "com.bytedance.safetyguard.lxc.internal.sidecar.auth.UrlConnectionLarkOAuthHttpTransport$execute$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super p>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f10539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f10540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f10542d;

        /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.y$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LarkOAuthHttpTransport.kt */
        static final class C0236a extends d.h.b.p implements d.h.a.b<Throwable, d.x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ HttpURLConnection f10543a;

            C0236a(HttpURLConnection r1) {
                this.f10543a = r1;
                super(1);
            }

            public final void a(Throwable r1) {
                this.f10543a.disconnect();
            }

            @Override // d.h.a.b
            public /* synthetic */ d.x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        a(o r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f10542d = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super p> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f10542d, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super p> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f10541c;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o r2 = (o) ZeusTransformUtils.preCheckCast(this.f10540b, o.class, "com.obric.aiagent.plugin");
            HttpURLConnection r12 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(this.f10539a, HttpURLConnection.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L68:
            return r13;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            URLConnection r14 = this.f10542d.b().openConnection(Proxy.NO_PROXY);
            d.h.b.o.a(r14, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection r15 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r14, HttpURLConnection.class, "com.obric.aiagent.plugin");
            o r3 = this.f10542d;
            this.f10539a = r15;
            this.f10540b = r3;
            this.f10541c = 1;
            kotlinx.coroutines.o r5 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin")), 1);
            r5.e();
            kotlinx.coroutines.n r4 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            r4.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0236a(r15), d.h.a.b.class, "com.obric.aiagent.plugin"));
            r15.setRequestMethod(r3.a());     // Catch: Throwable -> L61
            r15.setConnectTimeout(r3.e());     // Catch: Throwable -> L61
            r15.setReadTimeout(r3.f());     // Catch: Throwable -> L61
            r15.setInstanceFollowRedirects(false);     // Catch: Throwable -> L61
            Iterator<Map.Entry<String, String>> r7 = r3.c().entrySet().iterator();     // Catch: Throwable -> L61
        L11:
            if (r7.hasNext() == false) goto L14;
            Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            r15.setRequestProperty((String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r8.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
            goto L11
        L14:
            if (r3.d().length != 0) goto L16;
            boolean r9 = true;
        L18:
            if ((!r9) == false) goto L28;
            r15.setDoOutput(true);     // Catch: Throwable -> L61
            Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r15.getOutputStream(), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            ((OutputStream) ZeusTransformUtils.preCheckCast(r6, OutputStream.class, "com.obric.aiagent.plugin")).write(r3.d());     // Catch: Throwable -> L23
            d.x r10 = d.x.f38692a;     // Catch: Throwable -> L23
            d.f.c.a(r6, null);     // Catch: Throwable -> L61
            goto L28
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            d.f.c.a(r6, th);     // Catch: Throwable -> L61
            throw th;     // Catch: Throwable -> L61
        L28:
            int r11 = r15.getResponseCode();     // Catch: Throwable -> L61
            if (r11 < 400) goto L31;
            InputStream r16 = r15.getErrorStream();     // Catch: Throwable -> L61
        L32:
            if (r16 == null) goto L43;
            d.h.b.o.a(r16);     // Catch: Throwable -> L61
            Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            byte[] r18 = d.f.b.a((InputStream) ZeusTransformUtils.preCheckCast(r17, InputStream.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L38
            d.f.c.a(r17, null);     // Catch: Throwable -> L61
            if (r18 == null) goto L43;
        L44:
            Map<String, List<String>> r19 = r15.getHeaderFields();     // Catch: Throwable -> L61
            if (r19 != null) goto L47;
            r19 = ao.b();     // Catch: Throwable -> L61
        L47:
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r19.entrySet(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            Iterator r22 = r20.iterator();     // Catch: Throwable -> L61
        L49:
            if (r22.hasNext() == false) goto L59;
            Map.Entry r23 = (Map.Entry) ZeusTransformUtils.preCheckCast(r22.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            String r110 = (String) ZeusTransformUtils.preCheckCast(r23.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            List r24 = (List) ZeusTransformUtils.preCheckCast(r23.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
            if (r110 == null) goto L56;
            d.h.b.o.a(r110);     // Catch: Throwable -> L61
            if (r24 != null) goto L55;
            r24 = d.a.p.b();     // Catch: Throwable -> L61
        L55:
            d.m r25 = d.s.a(r110, d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r24, Iterable.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L61
        L57:
            if (r25 == null) goto L49;
            r21.add(r25);     // Catch: Throwable -> L61
            goto L49
        L56:
            r25 = null;
            goto L57
        L59:
            p r26 = new p(r11, ao.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")), r18);     // Catch: Throwable -> L61
            d.n.a r27 = d.n.f38560a;     // Catch: Throwable -> L61
            r4.resumeWith(d.n.f(r26));     // Catch: Throwable -> L61
        L63:
            r15.disconnect();
            r13 = r5.h();
            if (r13 != d.c.a.b.a()) goto L66;
            d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        L66:
            if (r13 != r0) goto L68;
            return r0;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            d.f.c.a(r17, th);     // Catch: Throwable -> L61
            throw th;     // Catch: Throwable -> L61
        L43:
            r18 = new byte[0];     // Catch: Throwable -> L61
            goto L44
        L31:
            r16 = r15.getInputStream();     // Catch: Throwable -> L61
            goto L32
        L16:
            r9 = false;
        L61:
            th = move-exception;
            d.n.a r28 = d.n.f38560a;     // Catch: Throwable -> L69
            r4.resumeWith(d.n.f(d.o.a(th)));     // Catch: Throwable -> L69
        L69:
            th = move-exception;
            r15.disconnect();
            throw th;
        }
    }

    static {
        f10538a = new y();
    }

    private y() {
    }

    @Override // com.bytedance.safetyguard.lxc.internal.e.a.q
    public Object a(o r4, d.c.d<? super p> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }
}
